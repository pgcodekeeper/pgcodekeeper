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
		FUNCTION=44, ISODOW=179, OVERWRITE=205, FUNCTIONS=45, ROW=91, PRECISION=210, 
		ILIKE=52, Character_String_Literal=327, NOT=74, EXCEPT=35, FOREIGN=42, 
		CACHE=132, PRIVILEGES=87, BYTEA=290, MONTH=197, STATEMENT=106, CHARACTER=136, 
		TYPE=241, BlockComment=324, VARBIT=258, STDDEV_POP=228, CREATE=21, COMMENTS=142, 
		ESC_SEQUENCES=328, USING=121, UNLOGGED=243, NOT_EQUAL=303, TIMEZONE_MINUTE=238, 
		VERTICAL_BAR=317, VARIADIC=122, TIMESTAMPTZ=284, REGEXP=215, FAMILY=164, 
		GEQ=307, STDDEV_SAMP=229, DIVIDE=313, BLOB=289, STRICT=107, PRESERVE=85, 
		ASC=8, GROUPING=169, SUBPARTITION=230, KEY=67, TEMP=110, ELSE=34, NUMBER=322, 
		BOOL=256, TRAILING=113, DEFINER=154, SEMI_COLON=300, INT=265, RLIKE=216, 
		RESTRICT=95, LEADING=68, SERVER=221, PROCEDURAL=89, TABLESPACE=232, MILLISECONDS=193, 
		REAL=270, INTERSECT=60, GROUP=49, LANGUAGE=182, SEQUENCES=102, OUT=80, 
		REAL_NUMBER=323, NONE=200, TRIM=239, LEFT_PAREN=308, LOCATION=187, SEARCH=218, 
		END=33, CONSTRAINT=18, TIMEZONE_HOUR=237, CAST_EXPRESSION=296, OPTION=203, 
		ISOYEAR=180, UUID=286, NCHAR=278, EXECUTE=38, INPUT=175, TABLE=109, VARCHAR=277, 
		FLOAT=272, VERSION=248, IMMUTABLE=54, MICROSECONDS=191, ASYMMETRIC=7, 
		SUM=231, OWNED=84, Space=329, INOUT=62, STORAGE=227, TIME=281, AS=3, RIGHT_PAREN=309, 
		THEN=112, COLLATION=16, MAXVALUE=190, REPLACE=94, LEFT=69, AVG=129, ZONE=254, 
		TRUNCATE=116, COLUMN=140, PLUS=310, EXISTS=161, NVARCHAR=279, Not_Similar_To=293, 
		RETURNS=96, LIKE=70, COLLATE=15, INTEGER=266, OUTER=79, BY=131, DEFERRABLE=26, 
		TO=240, SET=222, RIGHT=98, HAVING=50, MIN=194, SESSION=104, MINUS=311, 
		TEXT=285, HOUR=171, CONCATENATION_OPERATOR=302, CONVERSION=20, UNION=117, 
		CURRENT=148, COLON=299, COMMIT=143, SCHEMA=100, DATABASE=23, DECIMAL=275, 
		DROP=158, BIGINT=267, WHEN=124, ROWS=92, START=226, BIT=257, LARGE=183, 
		REVOKE=97, NATURAL=73, FORMAT=167, PUBLIC=211, AGGREGATE=1, EXTENSION=39, 
		BETWEEN=130, OPTIONS=204, FIRST=166, CAST=14, WEEK=250, EXTERNAL=162, 
		DOUBLE_QUOTE=319, VARYING=247, TRIGGER=114, CASE=12, CHAR=276, INT8=262, 
		COUNT=146, DAY=151, CASCADE=13, COST=145, INT2=260, INT1=259, Identifier=326, 
		INT4=261, ISCACHABLE=178, QUOTE=318, MODULAR=314, INVOKER=64, FULL=43, 
		DICTIONARY=155, THAN=235, QUARTER=213, INSERT=176, INHERITS=57, CONNECT=17, 
		INTERSECTION=177, LESS=185, TINYINT=263, BOTH=11, Similar_To_Case_Insensitive=294, 
		DOUBLE=273, ADMIN=128, SYMMETRIC=108, ISSTRICT=181, EACH=32, LAST=184, 
		COMMENT=141, SELECT=103, INTO=61, UNIQUE=118, COALESCE=139, SECOND=219, 
		ROLE=90, RULE=99, VIEW=123, EPOCH=159, ROLLUP=217, NULL=75, WITHOUT=127, 
		NO=199, EVERY=160, ON=78, MATCH=188, PRIMARY=86, DELETE=28, INET4=291, 
		NUMERIC=274, LOCAL=72, OF=76, EXCLUDING=37, LIST=186, TABLES=233, UNDERLINE=316, 
		SEQUENCE=101, Not_Similar_To_Case_Insensitive=295, CUBE=147, NATIONAL=198, 
		CALLED=133, VAR_POP=246, OR=82, FILTER=165, CHECK=137, FROM=46, FALSE=40, 
		COLLECT=138, PARSER=206, DISTINCT=30, TEMPORARY=111, TIMESTAMP=283, SIMPLE=224, 
		DOLLAR=320, CONSTRAINTS=19, WHERE=125, DEC=152, VAR_SAMP=245, NULLIF=201, 
		CLASS=134, TIMETZ=282, INNER=59, YEAR=253, TIMEZONE=236, ORDER=83, AUTHORIZATION=9, 
		LIMIT=71, DECADE=153, GTH=306, CYCLE=149, White_Space=330, UPDATE=119, 
		MAX=189, LineComment=325, DEFERRED=27, FOR=41, FLOAT4=268, CONFIGURATION=144, 
		FLOAT8=269, AND=5, CROSS=22, Similar_To=292, USAGE=120, IF=51, INDEX=172, 
		OIDS=77, BOOLEAN=255, IN=55, MINVALUE=195, UNKNOWN=242, MULTIPLY=312, 
		OBJECT=202, COMMA=301, REFERENCES=93, PARTITION=208, IS=65, PARTITIONS=209, 
		SOME=105, EQUAL=298, ALL=4, DOUBLE_DOLLAR=321, DOT=315, EXTRACT=163, CENTURY=135, 
		STABLE=225, SECURITY=220, PARTIAL=207, DOW=156, EXCLUDE=36, WITH=126, 
		INITIALLY=58, DOY=157, FUSION=168, GRANT=48, VARBINARY=288, VOLATILE=249, 
		OPERATOR=81, DEFAULT=24, VALUES=244, HASH=170, RANGE=214, INDEXES=173, 
		MILLENNIUM=192, PURGE=212, BEFORE=10, AFTER=2, INSTEAD=63, WRAPPER=252, 
		TRUE=115, PROCEDURE=88, JOIN=66, SIMILAR=223, DOMAIN=31, DEFAULTS=25, 
		LTH=304, INCREMENT=174, ANY=6, TEMPLATE=234, BAD=331, ASSIGN=297, REGCLASS=271, 
		IMMEDIATE=53, WINDOW=251, BINARY=287, DESC=29, DATE=280, MINUTE=196, GLOBAL=47, 
		DATA=150, INCLUDING=56, LEQ=305, SMALLINT=264;
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
		"SESSION", "SOME", "STATEMENT", "STRICT", "SYMMETRIC", "TABLE", "TEMP", 
		"TEMPORARY", "THEN", "TRAILING", "TRIGGER", "TRUE", "TRUNCATE", "UNION", 
		"UNIQUE", "UPDATE", "USAGE", "USING", "VARIADIC", "VIEW", "WHEN", "WHERE", 
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
		"NONE", "NULLIF", "OBJECT", "OPTION", "OPTIONS", "OVERWRITE", "PARSER", 
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
		"BINARY", "VARBINARY", "BLOB", "BYTEA", "INET4", "'~'", "'!~'", "'~*'", 
		"'!~*'", "CAST_EXPRESSION", "':='", "'='", "':'", "';'", "','", "CONCATENATION_OPERATOR", 
		"NOT_EQUAL", "'<'", "'<='", "'>'", "'>='", "'('", "')'", "'+'", "'-'", 
		"'*'", "'/'", "'%'", "'.'", "'_'", "'|'", "'''", "'\"'", "'$'", "'$$'", 
		"NUMBER", "REAL_NUMBER", "BlockComment", "LineComment", "Identifier", 
		"Character_String_Literal", "ESC_SEQUENCES", "' '", "White_Space", "BAD"
	};
	public static final int
		RULE_sql = 0, RULE_statement = 1, RULE_data_statement = 2, RULE_data_change_statement = 3, 
		RULE_schema_statement = 4, RULE_index_statement = 5, RULE_create_extension_statement = 6, 
		RULE_set_statement = 7, RULE_create_trigger_statement = 8, RULE_revoke_statement = 9, 
		RULE_revoke_from_cascade_restrict = 10, RULE_grant_statement = 11, RULE_grant_to_rule = 12, 
		RULE_comment_on_statement = 13, RULE_create_function_statement = 14, RULE_function_body = 15, 
		RULE_function_attribute = 16, RULE_argmode = 17, RULE_function_definition = 18, 
		RULE_functions_definition_schema = 19, RULE_create_sequence_statement = 20, 
		RULE_create_schema_statement = 21, RULE_create_view_statement = 22, RULE_query = 23, 
		RULE_create_table_statement = 24, RULE_like_option = 25, RULE_table_constraint = 26, 
		RULE_column_constraint = 27, RULE_check_boolean_expression = 28, RULE_storage_parameter = 29, 
		RULE_storage_parameter_oid = 30, RULE_on_commit = 31, RULE_table_space = 32, 
		RULE_action = 33, RULE_index_parameters = 34, RULE_table_elements = 35, 
		RULE_field_element = 36, RULE_field_type = 37, RULE_param_clause = 38, 
		RULE_param = 39, RULE_method_specifier = 40, RULE_table_space_specifier = 41, 
		RULE_table_space_name = 42, RULE_table_partitioning_clauses = 43, RULE_range_partitions = 44, 
		RULE_range_value_clause_list = 45, RULE_range_value_clause = 46, RULE_hash_partitions = 47, 
		RULE_individual_hash_partitions = 48, RULE_individual_hash_partition = 49, 
		RULE_hash_partitions_by_quantity = 50, RULE_list_partitions = 51, RULE_list_value_clause_list = 52, 
		RULE_list_value_partition = 53, RULE_column_partitions = 54, RULE_partition_name = 55, 
		RULE_drop_table_statement = 56, RULE_identifier = 57, RULE_nonreserved_keywords = 58, 
		RULE_unsigned_literal = 59, RULE_general_literal = 60, RULE_datetime_literal = 61, 
		RULE_time_literal = 62, RULE_timestamp_literal = 63, RULE_date_literal = 64, 
		RULE_boolean_literal = 65, RULE_data_type = 66, RULE_predefined_type = 67, 
		RULE_regclass = 68, RULE_network_type = 69, RULE_character_string_type = 70, 
		RULE_type_length = 71, RULE_national_character_string_type = 72, RULE_binary_large_object_string_type = 73, 
		RULE_numeric_type = 74, RULE_exact_numeric_type = 75, RULE_approximate_numeric_type = 76, 
		RULE_precision_param = 77, RULE_boolean_type = 78, RULE_datetime_type = 79, 
		RULE_bit_type = 80, RULE_binary_type = 81, RULE_value_expression_primary = 82, 
		RULE_parenthesized_value_expression = 83, RULE_nonparenthesized_value_expression_primary = 84, 
		RULE_unsigned_value_specification = 85, RULE_unsigned_numeric_literal = 86, 
		RULE_signed_numerical_literal = 87, RULE_set_function_specification = 88, 
		RULE_aggregate_function = 89, RULE_general_set_function = 90, RULE_set_function_type = 91, 
		RULE_filter_clause = 92, RULE_grouping_operation = 93, RULE_case_expression = 94, 
		RULE_case_abbreviation = 95, RULE_case_specification = 96, RULE_simple_case = 97, 
		RULE_searched_case = 98, RULE_simple_when_clause = 99, RULE_searched_when_clause = 100, 
		RULE_else_clause = 101, RULE_result = 102, RULE_cast_specification = 103, 
		RULE_cast_operand = 104, RULE_cast_target = 105, RULE_value_expression = 106, 
		RULE_common_value_expression = 107, RULE_numeric_value_expression = 108, 
		RULE_term = 109, RULE_factor = 110, RULE_array = 111, RULE_numeric_primary = 112, 
		RULE_sign = 113, RULE_numeric_value_function = 114, RULE_extract_expression = 115, 
		RULE_extract_field = 116, RULE_time_zone_field = 117, RULE_extract_source = 118, 
		RULE_string_value_expression = 119, RULE_character_value_expression = 120, 
		RULE_character_factor = 121, RULE_character_primary = 122, RULE_string_value_function = 123, 
		RULE_trim_function = 124, RULE_trim_operands = 125, RULE_trim_specification = 126, 
		RULE_boolean_value_expression = 127, RULE_or_predicate = 128, RULE_and_predicate = 129, 
		RULE_boolean_factor = 130, RULE_boolean_test = 131, RULE_is_clause = 132, 
		RULE_truth_value = 133, RULE_boolean_primary = 134, RULE_boolean_predicand = 135, 
		RULE_parenthesized_boolean_value_expression = 136, RULE_row_value_expression = 137, 
		RULE_row_value_special_case = 138, RULE_explicit_row_value_constructor = 139, 
		RULE_row_value_predicand = 140, RULE_row_value_constructor_predicand = 141, 
		RULE_table_expression = 142, RULE_from_clause = 143, RULE_table_reference_list = 144, 
		RULE_table_reference = 145, RULE_joined_table = 146, RULE_joined_table_primary = 147, 
		RULE_cross_join = 148, RULE_qualified_join = 149, RULE_natural_join = 150, 
		RULE_union_join = 151, RULE_join_type = 152, RULE_outer_join_type = 153, 
		RULE_outer_join_type_part2 = 154, RULE_join_specification = 155, RULE_join_condition = 156, 
		RULE_named_columns_join = 157, RULE_table_primary = 158, RULE_column_name_list = 159, 
		RULE_derived_table = 160, RULE_where_clause = 161, RULE_search_condition = 162, 
		RULE_groupby_clause = 163, RULE_grouping_element_list = 164, RULE_grouping_element = 165, 
		RULE_ordinary_grouping_set = 166, RULE_ordinary_grouping_set_list = 167, 
		RULE_rollup_list = 168, RULE_cube_list = 169, RULE_empty_grouping_set = 170, 
		RULE_having_clause = 171, RULE_row_value_predicand_list = 172, RULE_query_expression = 173, 
		RULE_query_expression_body = 174, RULE_non_join_query_expression = 175, 
		RULE_query_term = 176, RULE_non_join_query_term = 177, RULE_query_primary = 178, 
		RULE_non_join_query_primary = 179, RULE_simple_table = 180, RULE_explicit_table = 181, 
		RULE_table_or_query_name = 182, RULE_schema_qualified_name = 183, RULE_query_specification = 184, 
		RULE_select_list = 185, RULE_select_sublist = 186, RULE_derived_column = 187, 
		RULE_qualified_asterisk = 188, RULE_set_qualifier = 189, RULE_column_reference = 190, 
		RULE_as_clause = 191, RULE_column_reference_list = 192, RULE_scalar_subquery = 193, 
		RULE_row_subquery = 194, RULE_table_subquery = 195, RULE_subquery = 196, 
		RULE_predicate = 197, RULE_comparison_predicate = 198, RULE_comp_op = 199, 
		RULE_between_predicate = 200, RULE_between_predicate_part_2 = 201, RULE_in_predicate = 202, 
		RULE_in_predicate_value = 203, RULE_in_value_list = 204, RULE_pattern_matching_predicate = 205, 
		RULE_pattern_matcher = 206, RULE_negativable_matcher = 207, RULE_regex_matcher = 208, 
		RULE_null_predicate = 209, RULE_quantified_comparison_predicate = 210, 
		RULE_quantifier = 211, RULE_all = 212, RULE_some = 213, RULE_exists_predicate = 214, 
		RULE_unique_predicate = 215, RULE_primary_datetime_field = 216, RULE_non_second_primary_datetime_field = 217, 
		RULE_extended_datetime_field = 218, RULE_routine_invocation = 219, RULE_function_names_for_reserved_words = 220, 
		RULE_function_name = 221, RULE_sql_argument_list = 222, RULE_orderby_clause = 223, 
		RULE_sort_specifier_list = 224, RULE_sort_specifier = 225, RULE_order_specification = 226, 
		RULE_limit_clause = 227, RULE_null_ordering = 228, RULE_insert_statement = 229;
	public static final String[] ruleNames = {
		"sql", "statement", "data_statement", "data_change_statement", "schema_statement", 
		"index_statement", "create_extension_statement", "set_statement", "create_trigger_statement", 
		"revoke_statement", "revoke_from_cascade_restrict", "grant_statement", 
		"grant_to_rule", "comment_on_statement", "create_function_statement", 
		"function_body", "function_attribute", "argmode", "function_definition", 
		"functions_definition_schema", "create_sequence_statement", "create_schema_statement", 
		"create_view_statement", "query", "create_table_statement", "like_option", 
		"table_constraint", "column_constraint", "check_boolean_expression", "storage_parameter", 
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
			setState(466);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CREATE || _la==GRANT || ((((_la - 97)) & ~0x3f) == 0 && ((1L << (_la - 97)) & ((1L << (REVOKE - 97)) | (1L << (SELECT - 97)) | (1L << (TABLE - 97)) | (1L << (ADMIN - 97)) | (1L << (AVG - 97)) | (1L << (BETWEEN - 97)) | (1L << (BY - 97)) | (1L << (CACHE - 97)) | (1L << (CALLED - 97)) | (1L << (CLASS - 97)) | (1L << (CENTURY - 97)) | (1L << (CHARACTER - 97)) | (1L << (CHECK - 97)) | (1L << (COLLECT - 97)) | (1L << (COALESCE - 97)) | (1L << (COLUMN - 97)) | (1L << (COMMENT - 97)) | (1L << (COMMENTS - 97)) | (1L << (COMMIT - 97)) | (1L << (CONFIGURATION - 97)) | (1L << (COST - 97)) | (1L << (COUNT - 97)) | (1L << (CUBE - 97)) | (1L << (CURRENT - 97)) | (1L << (CYCLE - 97)) | (1L << (DATA - 97)) | (1L << (DAY - 97)) | (1L << (DEC - 97)) | (1L << (DECADE - 97)) | (1L << (DEFINER - 97)) | (1L << (DICTIONARY - 97)) | (1L << (DOW - 97)) | (1L << (DOY - 97)) | (1L << (DROP - 97)) | (1L << (EPOCH - 97)) | (1L << (EVERY - 97)))) != 0) || ((((_la - 161)) & ~0x3f) == 0 && ((1L << (_la - 161)) & ((1L << (EXISTS - 161)) | (1L << (EXTERNAL - 161)) | (1L << (EXTRACT - 161)) | (1L << (FAMILY - 161)) | (1L << (FILTER - 161)) | (1L << (FIRST - 161)) | (1L << (FORMAT - 161)) | (1L << (FUSION - 161)) | (1L << (GROUPING - 161)) | (1L << (HASH - 161)) | (1L << (INDEX - 161)) | (1L << (INCREMENT - 161)) | (1L << (INPUT - 161)) | (1L << (INSERT - 161)) | (1L << (INTERSECTION - 161)) | (1L << (ISCACHABLE - 161)) | (1L << (ISODOW - 161)) | (1L << (ISOYEAR - 161)) | (1L << (ISSTRICT - 161)) | (1L << (LANGUAGE - 161)) | (1L << (LARGE - 161)) | (1L << (LAST - 161)) | (1L << (LESS - 161)) | (1L << (LIST - 161)) | (1L << (LOCATION - 161)) | (1L << (MATCH - 161)) | (1L << (MAX - 161)) | (1L << (MAXVALUE - 161)) | (1L << (MICROSECONDS - 161)) | (1L << (MILLENNIUM - 161)) | (1L << (MILLISECONDS - 161)) | (1L << (MIN - 161)) | (1L << (MINVALUE - 161)) | (1L << (MINUTE - 161)) | (1L << (MONTH - 161)) | (1L << (NATIONAL - 161)) | (1L << (NO - 161)) | (1L << (NONE - 161)) | (1L << (NULLIF - 161)) | (1L << (OBJECT - 161)) | (1L << (OPTION - 161)) | (1L << (OPTIONS - 161)) | (1L << (OVERWRITE - 161)) | (1L << (PARSER - 161)) | (1L << (PARTIAL - 161)) | (1L << (PARTITION - 161)) | (1L << (PARTITIONS - 161)) | (1L << (PRECISION - 161)) | (1L << (PUBLIC - 161)) | (1L << (PURGE - 161)) | (1L << (QUARTER - 161)) | (1L << (RANGE - 161)) | (1L << (REGEXP - 161)) | (1L << (RLIKE - 161)) | (1L << (ROLLUP - 161)) | (1L << (SEARCH - 161)) | (1L << (SECOND - 161)) | (1L << (SECURITY - 161)) | (1L << (SERVER - 161)) | (1L << (SET - 161)) | (1L << (SIMILAR - 161)) | (1L << (SIMPLE - 161)))) != 0) || ((((_la - 225)) & ~0x3f) == 0 && ((1L << (_la - 225)) & ((1L << (STABLE - 225)) | (1L << (START - 225)) | (1L << (STORAGE - 225)) | (1L << (STDDEV_POP - 225)) | (1L << (STDDEV_SAMP - 225)) | (1L << (SUBPARTITION - 225)) | (1L << (SUM - 225)) | (1L << (TABLESPACE - 225)) | (1L << (TEMPLATE - 225)) | (1L << (THAN - 225)) | (1L << (TIMEZONE - 225)) | (1L << (TIMEZONE_HOUR - 225)) | (1L << (TIMEZONE_MINUTE - 225)) | (1L << (TRIM - 225)) | (1L << (TO - 225)) | (1L << (TYPE - 225)) | (1L << (UNKNOWN - 225)) | (1L << (UNLOGGED - 225)) | (1L << (VALUES - 225)) | (1L << (VAR_SAMP - 225)) | (1L << (VAR_POP - 225)) | (1L << (VARYING - 225)) | (1L << (VOLATILE - 225)) | (1L << (WEEK - 225)) | (1L << (WINDOW - 225)) | (1L << (WRAPPER - 225)) | (1L << (YEAR - 225)) | (1L << (ZONE - 225)) | (1L << (BOOLEAN - 225)) | (1L << (BOOL - 225)) | (1L << (BIT - 225)) | (1L << (VARBIT - 225)) | (1L << (INT1 - 225)) | (1L << (INT2 - 225)) | (1L << (INT4 - 225)) | (1L << (INT8 - 225)) | (1L << (TINYINT - 225)) | (1L << (SMALLINT - 225)) | (1L << (INT - 225)) | (1L << (INTEGER - 225)) | (1L << (BIGINT - 225)) | (1L << (FLOAT4 - 225)) | (1L << (FLOAT8 - 225)) | (1L << (REAL - 225)) | (1L << (FLOAT - 225)) | (1L << (DOUBLE - 225)) | (1L << (NUMERIC - 225)) | (1L << (DECIMAL - 225)) | (1L << (CHAR - 225)) | (1L << (VARCHAR - 225)) | (1L << (NCHAR - 225)) | (1L << (NVARCHAR - 225)) | (1L << (DATE - 225)) | (1L << (TIME - 225)) | (1L << (TIMETZ - 225)) | (1L << (TIMESTAMP - 225)) | (1L << (TIMESTAMPTZ - 225)) | (1L << (TEXT - 225)) | (1L << (UUID - 225)) | (1L << (VARBINARY - 225)))) != 0) || ((((_la - 289)) & ~0x3f) == 0 && ((1L << (_la - 289)) & ((1L << (BLOB - 289)) | (1L << (BYTEA - 289)) | (1L << (INET4 - 289)) | (1L << (LEFT_PAREN - 289)) | (1L << (DOUBLE_QUOTE - 289)) | (1L << (Identifier - 289)))) != 0)) {
				{
				{
				setState(460); statement();
				setState(462);
				_la = _input.LA(1);
				if (_la==SEMI_COLON) {
					{
					setState(461); match(SEMI_COLON);
					}
				}

				}
				}
				setState(468);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(469); match(EOF);
			}
		}
		catch (RecognitionException re) {
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
			setState(484);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(471); data_statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(472); schema_statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(473); index_statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(474); create_extension_statement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(475); set_statement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(476); create_trigger_statement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(477); grant_statement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(478); revoke_statement();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(479); comment_on_statement();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(480); create_function_statement();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(481); create_sequence_statement();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(482); create_schema_statement();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(483); create_view_statement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
			setState(486); query_expression();
			}
		}
		catch (RecognitionException re) {
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
			setState(488); insert_statement();
			}
		}
		catch (RecognitionException re) {
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
			setState(492);
			switch (_input.LA(1)) {
			case CREATE:
				enterOuterAlt(_localctx, 1);
				{
				setState(490); create_table_statement();
				}
				break;
			case DROP:
				enterOuterAlt(_localctx, 2);
				{
				setState(491); drop_table_statement();
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
			setState(494); match(CREATE);
			setState(496);
			_la = _input.LA(1);
			if (_la==UNIQUE) {
				{
				setState(495); ((Index_statementContext)_localctx).u = match(UNIQUE);
				}
			}

			setState(498); match(INDEX);
			setState(499); ((Index_statementContext)_localctx).n = identifier();
			setState(500); match(ON);
			setState(501); ((Index_statementContext)_localctx).t = schema_qualified_name();
			setState(503);
			_la = _input.LA(1);
			if (_la==USING) {
				{
				setState(502); ((Index_statementContext)_localctx).m = method_specifier();
				}
			}

			setState(505); match(LEFT_PAREN);
			setState(506); ((Index_statementContext)_localctx).s = sort_specifier_list();
			setState(507); match(RIGHT_PAREN);
			setState(509);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(508); ((Index_statementContext)_localctx).p = param_clause();
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
			setState(511); match(CREATE);
			setState(512); match(EXTENSION);
			setState(516);
			_la = _input.LA(1);
			if (_la==IF) {
				{
				setState(513); match(IF);
				setState(514); match(NOT);
				setState(515); match(EXISTS);
				}
			}

			setState(518); ((Create_extension_statementContext)_localctx).name = identifier();
			setState(520);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(519); match(WITH);
				}
			}

			setState(524);
			_la = _input.LA(1);
			if (_la==SCHEMA) {
				{
				setState(522); match(SCHEMA);
				setState(523); ((Create_extension_statementContext)_localctx).schema_name = identifier();
				}
			}

			setState(528);
			_la = _input.LA(1);
			if (_la==VERSION) {
				{
				setState(526); match(VERSION);
				setState(527); ((Create_extension_statementContext)_localctx).version = identifier();
				}
			}

			setState(532);
			_la = _input.LA(1);
			if (_la==FROM) {
				{
				setState(530); match(FROM);
				setState(531); ((Create_extension_statementContext)_localctx).old_version = identifier();
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
			setState(573);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(534); match(SET);
				setState(536);
				_la = _input.LA(1);
				if (_la==LOCAL || _la==SESSION) {
					{
					setState(535);
					_la = _input.LA(1);
					if ( !(_la==LOCAL || _la==SESSION) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(538); ((Set_statementContext)_localctx).config_param = identifier();
				setState(539);
				_la = _input.LA(1);
				if ( !(_la==TO || _la==EQUAL) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(551); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(546);
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
						case DOUBLE_QUOTE:
						case Identifier:
							{
							setState(540); ((Set_statementContext)_localctx).value = identifier();
							}
							break;
						case QUOTE:
							{
							setState(541); match(QUOTE);
							setState(542); ((Set_statementContext)_localctx).value = identifier();
							setState(543); match(QUOTE);
							}
							break;
						case DEFAULT:
							{
							setState(545); match(DEFAULT);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(549);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(548); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(553); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(555); match(SET);
				setState(557);
				_la = _input.LA(1);
				if (_la==LOCAL || _la==SESSION) {
					{
					setState(556);
					_la = _input.LA(1);
					if ( !(_la==LOCAL || _la==SESSION) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(559); match(TIME);
				setState(560); match(ZONE);
				setState(569); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(564);
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
						case DOUBLE_QUOTE:
						case Identifier:
							{
							setState(561); ((Set_statementContext)_localctx).timezone = identifier();
							}
							break;
						case LOCAL:
							{
							setState(562); match(LOCAL);
							}
							break;
						case DEFAULT:
							{
							setState(563); match(DEFAULT);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(567);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(566); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(571); 
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
			setState(575); match(CREATE);
			setState(577);
			_la = _input.LA(1);
			if (_la==CONSTRAINT) {
				{
				setState(576); match(CONSTRAINT);
				}
			}

			setState(579); match(TRIGGER);
			setState(580); ((Create_trigger_statementContext)_localctx).name = identifier();
			setState(585);
			switch (_input.LA(1)) {
			case BEFORE:
				{
				setState(581); match(BEFORE);
				}
				break;
			case INSTEAD:
				{
				{
				setState(582); match(INSTEAD);
				setState(583); match(OF);
				}
				}
				break;
			case AFTER:
				{
				setState(584); match(AFTER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(602);
			switch (_input.LA(1)) {
			case INSERT:
				{
				setState(587); match(INSERT);
				}
				break;
			case DELETE:
				{
				setState(588); match(DELETE);
				}
				break;
			case TRUNCATE:
				{
				setState(589); match(TRUNCATE);
				}
				break;
			case UPDATE:
				{
				{
				setState(590); match(UPDATE);
				setState(600);
				_la = _input.LA(1);
				if (_la==OF) {
					{
					setState(591); match(OF);
					setState(596); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(592); ((Create_trigger_statementContext)_localctx).columnName = identifier();
						setState(594);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(593); match(COMMA);
							}
						}

						}
						}
						setState(598); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (ADMIN - 128)) | (1L << (AVG - 128)) | (1L << (BETWEEN - 128)) | (1L << (BY - 128)) | (1L << (CACHE - 128)) | (1L << (CALLED - 128)) | (1L << (CLASS - 128)) | (1L << (CENTURY - 128)) | (1L << (CHARACTER - 128)) | (1L << (CHECK - 128)) | (1L << (COLLECT - 128)) | (1L << (COALESCE - 128)) | (1L << (COLUMN - 128)) | (1L << (COMMENT - 128)) | (1L << (COMMENTS - 128)) | (1L << (COMMIT - 128)) | (1L << (CONFIGURATION - 128)) | (1L << (COST - 128)) | (1L << (COUNT - 128)) | (1L << (CUBE - 128)) | (1L << (CURRENT - 128)) | (1L << (CYCLE - 128)) | (1L << (DATA - 128)) | (1L << (DAY - 128)) | (1L << (DEC - 128)) | (1L << (DECADE - 128)) | (1L << (DEFINER - 128)) | (1L << (DICTIONARY - 128)) | (1L << (DOW - 128)) | (1L << (DOY - 128)) | (1L << (DROP - 128)) | (1L << (EPOCH - 128)) | (1L << (EVERY - 128)) | (1L << (EXISTS - 128)) | (1L << (EXTERNAL - 128)) | (1L << (EXTRACT - 128)) | (1L << (FAMILY - 128)) | (1L << (FILTER - 128)) | (1L << (FIRST - 128)) | (1L << (FORMAT - 128)) | (1L << (FUSION - 128)) | (1L << (GROUPING - 128)) | (1L << (HASH - 128)) | (1L << (INDEX - 128)) | (1L << (INCREMENT - 128)) | (1L << (INPUT - 128)) | (1L << (INSERT - 128)) | (1L << (INTERSECTION - 128)) | (1L << (ISCACHABLE - 128)) | (1L << (ISODOW - 128)) | (1L << (ISOYEAR - 128)) | (1L << (ISSTRICT - 128)) | (1L << (LANGUAGE - 128)) | (1L << (LARGE - 128)) | (1L << (LAST - 128)) | (1L << (LESS - 128)) | (1L << (LIST - 128)) | (1L << (LOCATION - 128)) | (1L << (MATCH - 128)) | (1L << (MAX - 128)) | (1L << (MAXVALUE - 128)) | (1L << (MICROSECONDS - 128)))) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (MILLENNIUM - 192)) | (1L << (MILLISECONDS - 192)) | (1L << (MIN - 192)) | (1L << (MINVALUE - 192)) | (1L << (MINUTE - 192)) | (1L << (MONTH - 192)) | (1L << (NATIONAL - 192)) | (1L << (NO - 192)) | (1L << (NONE - 192)) | (1L << (NULLIF - 192)) | (1L << (OBJECT - 192)) | (1L << (OPTION - 192)) | (1L << (OPTIONS - 192)) | (1L << (OVERWRITE - 192)) | (1L << (PARSER - 192)) | (1L << (PARTIAL - 192)) | (1L << (PARTITION - 192)) | (1L << (PARTITIONS - 192)) | (1L << (PRECISION - 192)) | (1L << (PUBLIC - 192)) | (1L << (PURGE - 192)) | (1L << (QUARTER - 192)) | (1L << (RANGE - 192)) | (1L << (REGEXP - 192)) | (1L << (RLIKE - 192)) | (1L << (ROLLUP - 192)) | (1L << (SEARCH - 192)) | (1L << (SECOND - 192)) | (1L << (SECURITY - 192)) | (1L << (SERVER - 192)) | (1L << (SET - 192)) | (1L << (SIMILAR - 192)) | (1L << (SIMPLE - 192)) | (1L << (STABLE - 192)) | (1L << (START - 192)) | (1L << (STORAGE - 192)) | (1L << (STDDEV_POP - 192)) | (1L << (STDDEV_SAMP - 192)) | (1L << (SUBPARTITION - 192)) | (1L << (SUM - 192)) | (1L << (TABLESPACE - 192)) | (1L << (TEMPLATE - 192)) | (1L << (THAN - 192)) | (1L << (TIMEZONE - 192)) | (1L << (TIMEZONE_HOUR - 192)) | (1L << (TIMEZONE_MINUTE - 192)) | (1L << (TRIM - 192)) | (1L << (TO - 192)) | (1L << (TYPE - 192)) | (1L << (UNKNOWN - 192)) | (1L << (UNLOGGED - 192)) | (1L << (VALUES - 192)) | (1L << (VAR_SAMP - 192)) | (1L << (VAR_POP - 192)) | (1L << (VARYING - 192)) | (1L << (VOLATILE - 192)) | (1L << (WEEK - 192)) | (1L << (WINDOW - 192)) | (1L << (WRAPPER - 192)) | (1L << (YEAR - 192)) | (1L << (ZONE - 192)) | (1L << (BOOLEAN - 192)))) != 0) || ((((_la - 256)) & ~0x3f) == 0 && ((1L << (_la - 256)) & ((1L << (BOOL - 256)) | (1L << (BIT - 256)) | (1L << (VARBIT - 256)) | (1L << (INT1 - 256)) | (1L << (INT2 - 256)) | (1L << (INT4 - 256)) | (1L << (INT8 - 256)) | (1L << (TINYINT - 256)) | (1L << (SMALLINT - 256)) | (1L << (INT - 256)) | (1L << (INTEGER - 256)) | (1L << (BIGINT - 256)) | (1L << (FLOAT4 - 256)) | (1L << (FLOAT8 - 256)) | (1L << (REAL - 256)) | (1L << (FLOAT - 256)) | (1L << (DOUBLE - 256)) | (1L << (NUMERIC - 256)) | (1L << (DECIMAL - 256)) | (1L << (CHAR - 256)) | (1L << (VARCHAR - 256)) | (1L << (NCHAR - 256)) | (1L << (NVARCHAR - 256)) | (1L << (DATE - 256)) | (1L << (TIME - 256)) | (1L << (TIMETZ - 256)) | (1L << (TIMESTAMP - 256)) | (1L << (TIMESTAMPTZ - 256)) | (1L << (TEXT - 256)) | (1L << (UUID - 256)) | (1L << (VARBINARY - 256)) | (1L << (BLOB - 256)) | (1L << (BYTEA - 256)) | (1L << (INET4 - 256)) | (1L << (DOUBLE_QUOTE - 256)))) != 0) || _la==Identifier );
					}
				}

				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(604); match(ON);
			setState(605); ((Create_trigger_statementContext)_localctx).tabl_name = schema_qualified_name();
			setState(608);
			_la = _input.LA(1);
			if (_la==FROM) {
				{
				setState(606); match(FROM);
				setState(607); ((Create_trigger_statementContext)_localctx).referenced_table_name = schema_qualified_name();
				}
			}

			setState(619);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				{
				setState(610); match(NOT);
				setState(611); match(DEFERRABLE);
				}
				break;
			case 2:
				{
				setState(613);
				_la = _input.LA(1);
				if (_la==DEFERRABLE) {
					{
					setState(612); match(DEFERRABLE);
					}
				}

				{
				setState(615); match(INITIALLY);
				setState(616); match(IMMEDIATE);
				}
				}
				break;
			case 3:
				{
				{
				setState(617); match(INITIALLY);
				setState(618); match(DEFERRED);
				}
				}
				break;
			}
			setState(627);
			switch (_input.LA(1)) {
			case FOR:
				{
				setState(621); match(FOR);
				setState(623);
				_la = _input.LA(1);
				if (_la==EACH) {
					{
					setState(622); match(EACH);
					}
				}

				setState(625); match(ROW);
				}
				break;
			case STATEMENT:
				{
				setState(626); match(STATEMENT);
				}
				break;
			case EXECUTE:
			case WHEN:
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(631);
			_la = _input.LA(1);
			if (_la==WHEN) {
				{
				setState(629); match(WHEN);
				{
				setState(630); boolean_value_expression();
				}
				}
			}

			setState(633); match(EXECUTE);
			setState(634); match(PROCEDURE);
			setState(635); ((Create_trigger_statementContext)_localctx).func_name = identifier();
			setState(636); match(LEFT_PAREN);
			setState(641);
			_la = _input.LA(1);
			if (((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (ADMIN - 128)) | (1L << (AVG - 128)) | (1L << (BETWEEN - 128)) | (1L << (BY - 128)) | (1L << (CACHE - 128)) | (1L << (CALLED - 128)) | (1L << (CLASS - 128)) | (1L << (CENTURY - 128)) | (1L << (CHARACTER - 128)) | (1L << (CHECK - 128)) | (1L << (COLLECT - 128)) | (1L << (COALESCE - 128)) | (1L << (COLUMN - 128)) | (1L << (COMMENT - 128)) | (1L << (COMMENTS - 128)) | (1L << (COMMIT - 128)) | (1L << (CONFIGURATION - 128)) | (1L << (COST - 128)) | (1L << (COUNT - 128)) | (1L << (CUBE - 128)) | (1L << (CURRENT - 128)) | (1L << (CYCLE - 128)) | (1L << (DATA - 128)) | (1L << (DAY - 128)) | (1L << (DEC - 128)) | (1L << (DECADE - 128)) | (1L << (DEFINER - 128)) | (1L << (DICTIONARY - 128)) | (1L << (DOW - 128)) | (1L << (DOY - 128)) | (1L << (DROP - 128)) | (1L << (EPOCH - 128)) | (1L << (EVERY - 128)) | (1L << (EXISTS - 128)) | (1L << (EXTERNAL - 128)) | (1L << (EXTRACT - 128)) | (1L << (FAMILY - 128)) | (1L << (FILTER - 128)) | (1L << (FIRST - 128)) | (1L << (FORMAT - 128)) | (1L << (FUSION - 128)) | (1L << (GROUPING - 128)) | (1L << (HASH - 128)) | (1L << (INDEX - 128)) | (1L << (INCREMENT - 128)) | (1L << (INPUT - 128)) | (1L << (INSERT - 128)) | (1L << (INTERSECTION - 128)) | (1L << (ISCACHABLE - 128)) | (1L << (ISODOW - 128)) | (1L << (ISOYEAR - 128)) | (1L << (ISSTRICT - 128)) | (1L << (LANGUAGE - 128)) | (1L << (LARGE - 128)) | (1L << (LAST - 128)) | (1L << (LESS - 128)) | (1L << (LIST - 128)) | (1L << (LOCATION - 128)) | (1L << (MATCH - 128)) | (1L << (MAX - 128)) | (1L << (MAXVALUE - 128)) | (1L << (MICROSECONDS - 128)))) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (MILLENNIUM - 192)) | (1L << (MILLISECONDS - 192)) | (1L << (MIN - 192)) | (1L << (MINVALUE - 192)) | (1L << (MINUTE - 192)) | (1L << (MONTH - 192)) | (1L << (NATIONAL - 192)) | (1L << (NO - 192)) | (1L << (NONE - 192)) | (1L << (NULLIF - 192)) | (1L << (OBJECT - 192)) | (1L << (OPTION - 192)) | (1L << (OPTIONS - 192)) | (1L << (OVERWRITE - 192)) | (1L << (PARSER - 192)) | (1L << (PARTIAL - 192)) | (1L << (PARTITION - 192)) | (1L << (PARTITIONS - 192)) | (1L << (PRECISION - 192)) | (1L << (PUBLIC - 192)) | (1L << (PURGE - 192)) | (1L << (QUARTER - 192)) | (1L << (RANGE - 192)) | (1L << (REGEXP - 192)) | (1L << (RLIKE - 192)) | (1L << (ROLLUP - 192)) | (1L << (SEARCH - 192)) | (1L << (SECOND - 192)) | (1L << (SECURITY - 192)) | (1L << (SERVER - 192)) | (1L << (SET - 192)) | (1L << (SIMILAR - 192)) | (1L << (SIMPLE - 192)) | (1L << (STABLE - 192)) | (1L << (START - 192)) | (1L << (STORAGE - 192)) | (1L << (STDDEV_POP - 192)) | (1L << (STDDEV_SAMP - 192)) | (1L << (SUBPARTITION - 192)) | (1L << (SUM - 192)) | (1L << (TABLESPACE - 192)) | (1L << (TEMPLATE - 192)) | (1L << (THAN - 192)) | (1L << (TIMEZONE - 192)) | (1L << (TIMEZONE_HOUR - 192)) | (1L << (TIMEZONE_MINUTE - 192)) | (1L << (TRIM - 192)) | (1L << (TO - 192)) | (1L << (TYPE - 192)) | (1L << (UNKNOWN - 192)) | (1L << (UNLOGGED - 192)) | (1L << (VALUES - 192)) | (1L << (VAR_SAMP - 192)) | (1L << (VAR_POP - 192)) | (1L << (VARYING - 192)) | (1L << (VOLATILE - 192)) | (1L << (WEEK - 192)) | (1L << (WINDOW - 192)) | (1L << (WRAPPER - 192)) | (1L << (YEAR - 192)) | (1L << (ZONE - 192)) | (1L << (BOOLEAN - 192)))) != 0) || ((((_la - 256)) & ~0x3f) == 0 && ((1L << (_la - 256)) & ((1L << (BOOL - 256)) | (1L << (BIT - 256)) | (1L << (VARBIT - 256)) | (1L << (INT1 - 256)) | (1L << (INT2 - 256)) | (1L << (INT4 - 256)) | (1L << (INT8 - 256)) | (1L << (TINYINT - 256)) | (1L << (SMALLINT - 256)) | (1L << (INT - 256)) | (1L << (INTEGER - 256)) | (1L << (BIGINT - 256)) | (1L << (FLOAT4 - 256)) | (1L << (FLOAT8 - 256)) | (1L << (REAL - 256)) | (1L << (FLOAT - 256)) | (1L << (DOUBLE - 256)) | (1L << (NUMERIC - 256)) | (1L << (DECIMAL - 256)) | (1L << (CHAR - 256)) | (1L << (VARCHAR - 256)) | (1L << (NCHAR - 256)) | (1L << (NVARCHAR - 256)) | (1L << (DATE - 256)) | (1L << (TIME - 256)) | (1L << (TIMETZ - 256)) | (1L << (TIMESTAMP - 256)) | (1L << (TIMESTAMPTZ - 256)) | (1L << (TEXT - 256)) | (1L << (UUID - 256)) | (1L << (VARBINARY - 256)) | (1L << (BLOB - 256)) | (1L << (BYTEA - 256)) | (1L << (INET4 - 256)) | (1L << (DOUBLE_QUOTE - 256)))) != 0) || _la==Identifier) {
				{
				setState(637); ((Create_trigger_statementContext)_localctx).arguments = identifier();
				setState(639);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(638); match(COMMA);
					}
				}

				}
			}

			setState(643); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
			setState(1024);
			switch ( getInterpreter().adaptivePredict(_input,114,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(645); match(REVOKE);
				setState(649);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(646); match(GRANT);
					setState(647); match(OPTION);
					setState(648); match(FOR);
					}
				}

				setState(660);
				switch (_input.LA(1)) {
				case DELETE:
				case REFERENCES:
				case SELECT:
				case TRIGGER:
				case TRUNCATE:
				case UPDATE:
				case INSERT:
					{
					setState(652); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(651);
						_la = _input.LA(1);
						if ( !(_la==DELETE || ((((_la - 93)) & ~0x3f) == 0 && ((1L << (_la - 93)) & ((1L << (REFERENCES - 93)) | (1L << (SELECT - 93)) | (1L << (TRIGGER - 93)) | (1L << (TRUNCATE - 93)) | (1L << (UPDATE - 93)))) != 0) || _la==INSERT) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
						}
						setState(654); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==DELETE || ((((_la - 93)) & ~0x3f) == 0 && ((1L << (_la - 93)) & ((1L << (REFERENCES - 93)) | (1L << (SELECT - 93)) | (1L << (TRIGGER - 93)) | (1L << (TRUNCATE - 93)) | (1L << (UPDATE - 93)))) != 0) || _la==INSERT );
					}
					break;
				case ALL:
					{
					setState(656); match(ALL);
					setState(658);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(657); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(662); match(ON);
				setState(680);
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
				case DOUBLE_QUOTE:
				case Identifier:
					{
					setState(667); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(664);
						_la = _input.LA(1);
						if (_la==TABLE) {
							{
							setState(663); match(TABLE);
							}
						}

						setState(666); ((Revoke_statementContext)_localctx).table_name = schema_qualified_name();
						}
						}
						setState(669); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 109)) & ~0x3f) == 0 && ((1L << (_la - 109)) & ((1L << (TABLE - 109)) | (1L << (ADMIN - 109)) | (1L << (AVG - 109)) | (1L << (BETWEEN - 109)) | (1L << (BY - 109)) | (1L << (CACHE - 109)) | (1L << (CALLED - 109)) | (1L << (CLASS - 109)) | (1L << (CENTURY - 109)) | (1L << (CHARACTER - 109)) | (1L << (CHECK - 109)) | (1L << (COLLECT - 109)) | (1L << (COALESCE - 109)) | (1L << (COLUMN - 109)) | (1L << (COMMENT - 109)) | (1L << (COMMENTS - 109)) | (1L << (COMMIT - 109)) | (1L << (CONFIGURATION - 109)) | (1L << (COST - 109)) | (1L << (COUNT - 109)) | (1L << (CUBE - 109)) | (1L << (CURRENT - 109)) | (1L << (CYCLE - 109)) | (1L << (DATA - 109)) | (1L << (DAY - 109)) | (1L << (DEC - 109)) | (1L << (DECADE - 109)) | (1L << (DEFINER - 109)) | (1L << (DICTIONARY - 109)) | (1L << (DOW - 109)) | (1L << (DOY - 109)) | (1L << (DROP - 109)) | (1L << (EPOCH - 109)) | (1L << (EVERY - 109)) | (1L << (EXISTS - 109)) | (1L << (EXTERNAL - 109)) | (1L << (EXTRACT - 109)) | (1L << (FAMILY - 109)) | (1L << (FILTER - 109)) | (1L << (FIRST - 109)) | (1L << (FORMAT - 109)) | (1L << (FUSION - 109)) | (1L << (GROUPING - 109)) | (1L << (HASH - 109)) | (1L << (INDEX - 109)))) != 0) || ((((_la - 174)) & ~0x3f) == 0 && ((1L << (_la - 174)) & ((1L << (INCREMENT - 174)) | (1L << (INPUT - 174)) | (1L << (INSERT - 174)) | (1L << (INTERSECTION - 174)) | (1L << (ISCACHABLE - 174)) | (1L << (ISODOW - 174)) | (1L << (ISOYEAR - 174)) | (1L << (ISSTRICT - 174)) | (1L << (LANGUAGE - 174)) | (1L << (LARGE - 174)) | (1L << (LAST - 174)) | (1L << (LESS - 174)) | (1L << (LIST - 174)) | (1L << (LOCATION - 174)) | (1L << (MATCH - 174)) | (1L << (MAX - 174)) | (1L << (MAXVALUE - 174)) | (1L << (MICROSECONDS - 174)) | (1L << (MILLENNIUM - 174)) | (1L << (MILLISECONDS - 174)) | (1L << (MIN - 174)) | (1L << (MINVALUE - 174)) | (1L << (MINUTE - 174)) | (1L << (MONTH - 174)) | (1L << (NATIONAL - 174)) | (1L << (NO - 174)) | (1L << (NONE - 174)) | (1L << (NULLIF - 174)) | (1L << (OBJECT - 174)) | (1L << (OPTION - 174)) | (1L << (OPTIONS - 174)) | (1L << (OVERWRITE - 174)) | (1L << (PARSER - 174)) | (1L << (PARTIAL - 174)) | (1L << (PARTITION - 174)) | (1L << (PARTITIONS - 174)) | (1L << (PRECISION - 174)) | (1L << (PUBLIC - 174)) | (1L << (PURGE - 174)) | (1L << (QUARTER - 174)) | (1L << (RANGE - 174)) | (1L << (REGEXP - 174)) | (1L << (RLIKE - 174)) | (1L << (ROLLUP - 174)) | (1L << (SEARCH - 174)) | (1L << (SECOND - 174)) | (1L << (SECURITY - 174)) | (1L << (SERVER - 174)) | (1L << (SET - 174)) | (1L << (SIMILAR - 174)) | (1L << (SIMPLE - 174)) | (1L << (STABLE - 174)) | (1L << (START - 174)) | (1L << (STORAGE - 174)) | (1L << (STDDEV_POP - 174)) | (1L << (STDDEV_SAMP - 174)) | (1L << (SUBPARTITION - 174)) | (1L << (SUM - 174)) | (1L << (TABLESPACE - 174)) | (1L << (TEMPLATE - 174)) | (1L << (THAN - 174)) | (1L << (TIMEZONE - 174)) | (1L << (TIMEZONE_HOUR - 174)))) != 0) || ((((_la - 238)) & ~0x3f) == 0 && ((1L << (_la - 238)) & ((1L << (TIMEZONE_MINUTE - 238)) | (1L << (TRIM - 238)) | (1L << (TO - 238)) | (1L << (TYPE - 238)) | (1L << (UNKNOWN - 238)) | (1L << (UNLOGGED - 238)) | (1L << (VALUES - 238)) | (1L << (VAR_SAMP - 238)) | (1L << (VAR_POP - 238)) | (1L << (VARYING - 238)) | (1L << (VOLATILE - 238)) | (1L << (WEEK - 238)) | (1L << (WINDOW - 238)) | (1L << (WRAPPER - 238)) | (1L << (YEAR - 238)) | (1L << (ZONE - 238)) | (1L << (BOOLEAN - 238)) | (1L << (BOOL - 238)) | (1L << (BIT - 238)) | (1L << (VARBIT - 238)) | (1L << (INT1 - 238)) | (1L << (INT2 - 238)) | (1L << (INT4 - 238)) | (1L << (INT8 - 238)) | (1L << (TINYINT - 238)) | (1L << (SMALLINT - 238)) | (1L << (INT - 238)) | (1L << (INTEGER - 238)) | (1L << (BIGINT - 238)) | (1L << (FLOAT4 - 238)) | (1L << (FLOAT8 - 238)) | (1L << (REAL - 238)) | (1L << (FLOAT - 238)) | (1L << (DOUBLE - 238)) | (1L << (NUMERIC - 238)) | (1L << (DECIMAL - 238)) | (1L << (CHAR - 238)) | (1L << (VARCHAR - 238)) | (1L << (NCHAR - 238)) | (1L << (NVARCHAR - 238)) | (1L << (DATE - 238)) | (1L << (TIME - 238)) | (1L << (TIMETZ - 238)) | (1L << (TIMESTAMP - 238)) | (1L << (TIMESTAMPTZ - 238)) | (1L << (TEXT - 238)) | (1L << (UUID - 238)) | (1L << (VARBINARY - 238)) | (1L << (BLOB - 238)) | (1L << (BYTEA - 238)) | (1L << (INET4 - 238)))) != 0) || _la==DOUBLE_QUOTE || _la==Identifier );
					}
					break;
				case ALL:
					{
					setState(671); match(ALL);
					setState(672); match(TABLES);
					setState(673); match(IN);
					setState(674); match(SCHEMA);
					setState(676); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(675); ((Revoke_statementContext)_localctx).schema_name = identifier();
						}
						}
						setState(678); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (ADMIN - 128)) | (1L << (AVG - 128)) | (1L << (BETWEEN - 128)) | (1L << (BY - 128)) | (1L << (CACHE - 128)) | (1L << (CALLED - 128)) | (1L << (CLASS - 128)) | (1L << (CENTURY - 128)) | (1L << (CHARACTER - 128)) | (1L << (CHECK - 128)) | (1L << (COLLECT - 128)) | (1L << (COALESCE - 128)) | (1L << (COLUMN - 128)) | (1L << (COMMENT - 128)) | (1L << (COMMENTS - 128)) | (1L << (COMMIT - 128)) | (1L << (CONFIGURATION - 128)) | (1L << (COST - 128)) | (1L << (COUNT - 128)) | (1L << (CUBE - 128)) | (1L << (CURRENT - 128)) | (1L << (CYCLE - 128)) | (1L << (DATA - 128)) | (1L << (DAY - 128)) | (1L << (DEC - 128)) | (1L << (DECADE - 128)) | (1L << (DEFINER - 128)) | (1L << (DICTIONARY - 128)) | (1L << (DOW - 128)) | (1L << (DOY - 128)) | (1L << (DROP - 128)) | (1L << (EPOCH - 128)) | (1L << (EVERY - 128)) | (1L << (EXISTS - 128)) | (1L << (EXTERNAL - 128)) | (1L << (EXTRACT - 128)) | (1L << (FAMILY - 128)) | (1L << (FILTER - 128)) | (1L << (FIRST - 128)) | (1L << (FORMAT - 128)) | (1L << (FUSION - 128)) | (1L << (GROUPING - 128)) | (1L << (HASH - 128)) | (1L << (INDEX - 128)) | (1L << (INCREMENT - 128)) | (1L << (INPUT - 128)) | (1L << (INSERT - 128)) | (1L << (INTERSECTION - 128)) | (1L << (ISCACHABLE - 128)) | (1L << (ISODOW - 128)) | (1L << (ISOYEAR - 128)) | (1L << (ISSTRICT - 128)) | (1L << (LANGUAGE - 128)) | (1L << (LARGE - 128)) | (1L << (LAST - 128)) | (1L << (LESS - 128)) | (1L << (LIST - 128)) | (1L << (LOCATION - 128)) | (1L << (MATCH - 128)) | (1L << (MAX - 128)) | (1L << (MAXVALUE - 128)) | (1L << (MICROSECONDS - 128)))) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (MILLENNIUM - 192)) | (1L << (MILLISECONDS - 192)) | (1L << (MIN - 192)) | (1L << (MINVALUE - 192)) | (1L << (MINUTE - 192)) | (1L << (MONTH - 192)) | (1L << (NATIONAL - 192)) | (1L << (NO - 192)) | (1L << (NONE - 192)) | (1L << (NULLIF - 192)) | (1L << (OBJECT - 192)) | (1L << (OPTION - 192)) | (1L << (OPTIONS - 192)) | (1L << (OVERWRITE - 192)) | (1L << (PARSER - 192)) | (1L << (PARTIAL - 192)) | (1L << (PARTITION - 192)) | (1L << (PARTITIONS - 192)) | (1L << (PRECISION - 192)) | (1L << (PUBLIC - 192)) | (1L << (PURGE - 192)) | (1L << (QUARTER - 192)) | (1L << (RANGE - 192)) | (1L << (REGEXP - 192)) | (1L << (RLIKE - 192)) | (1L << (ROLLUP - 192)) | (1L << (SEARCH - 192)) | (1L << (SECOND - 192)) | (1L << (SECURITY - 192)) | (1L << (SERVER - 192)) | (1L << (SET - 192)) | (1L << (SIMILAR - 192)) | (1L << (SIMPLE - 192)) | (1L << (STABLE - 192)) | (1L << (START - 192)) | (1L << (STORAGE - 192)) | (1L << (STDDEV_POP - 192)) | (1L << (STDDEV_SAMP - 192)) | (1L << (SUBPARTITION - 192)) | (1L << (SUM - 192)) | (1L << (TABLESPACE - 192)) | (1L << (TEMPLATE - 192)) | (1L << (THAN - 192)) | (1L << (TIMEZONE - 192)) | (1L << (TIMEZONE_HOUR - 192)) | (1L << (TIMEZONE_MINUTE - 192)) | (1L << (TRIM - 192)) | (1L << (TO - 192)) | (1L << (TYPE - 192)) | (1L << (UNKNOWN - 192)) | (1L << (UNLOGGED - 192)) | (1L << (VALUES - 192)) | (1L << (VAR_SAMP - 192)) | (1L << (VAR_POP - 192)) | (1L << (VARYING - 192)) | (1L << (VOLATILE - 192)) | (1L << (WEEK - 192)) | (1L << (WINDOW - 192)) | (1L << (WRAPPER - 192)) | (1L << (YEAR - 192)) | (1L << (ZONE - 192)) | (1L << (BOOLEAN - 192)))) != 0) || ((((_la - 256)) & ~0x3f) == 0 && ((1L << (_la - 256)) & ((1L << (BOOL - 256)) | (1L << (BIT - 256)) | (1L << (VARBIT - 256)) | (1L << (INT1 - 256)) | (1L << (INT2 - 256)) | (1L << (INT4 - 256)) | (1L << (INT8 - 256)) | (1L << (TINYINT - 256)) | (1L << (SMALLINT - 256)) | (1L << (INT - 256)) | (1L << (INTEGER - 256)) | (1L << (BIGINT - 256)) | (1L << (FLOAT4 - 256)) | (1L << (FLOAT8 - 256)) | (1L << (REAL - 256)) | (1L << (FLOAT - 256)) | (1L << (DOUBLE - 256)) | (1L << (NUMERIC - 256)) | (1L << (DECIMAL - 256)) | (1L << (CHAR - 256)) | (1L << (VARCHAR - 256)) | (1L << (NCHAR - 256)) | (1L << (NVARCHAR - 256)) | (1L << (DATE - 256)) | (1L << (TIME - 256)) | (1L << (TIMETZ - 256)) | (1L << (TIMESTAMP - 256)) | (1L << (TIMESTAMPTZ - 256)) | (1L << (TEXT - 256)) | (1L << (UUID - 256)) | (1L << (VARBINARY - 256)) | (1L << (BLOB - 256)) | (1L << (BYTEA - 256)) | (1L << (INET4 - 256)) | (1L << (DOUBLE_QUOTE - 256)))) != 0) || _la==Identifier );
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(682); revoke_from_cascade_restrict();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(684); match(REVOKE);
				setState(688);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(685); match(GRANT);
					setState(686); match(OPTION);
					setState(687); match(FOR);
					}
				}

				setState(721);
				switch (_input.LA(1)) {
				case REFERENCES:
				case SELECT:
				case UPDATE:
				case INSERT:
					{
					setState(702); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(690);
						_la = _input.LA(1);
						if ( !(((((_la - 93)) & ~0x3f) == 0 && ((1L << (_la - 93)) & ((1L << (REFERENCES - 93)) | (1L << (SELECT - 93)) | (1L << (UPDATE - 93)))) != 0) || _la==INSERT) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(691); match(LEFT_PAREN);
						setState(696); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(692); ((Revoke_statementContext)_localctx).column = identifier();
							setState(694);
							_la = _input.LA(1);
							if (_la==COMMA) {
								{
								setState(693); match(COMMA);
								}
							}

							}
							}
							setState(698); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (ADMIN - 128)) | (1L << (AVG - 128)) | (1L << (BETWEEN - 128)) | (1L << (BY - 128)) | (1L << (CACHE - 128)) | (1L << (CALLED - 128)) | (1L << (CLASS - 128)) | (1L << (CENTURY - 128)) | (1L << (CHARACTER - 128)) | (1L << (CHECK - 128)) | (1L << (COLLECT - 128)) | (1L << (COALESCE - 128)) | (1L << (COLUMN - 128)) | (1L << (COMMENT - 128)) | (1L << (COMMENTS - 128)) | (1L << (COMMIT - 128)) | (1L << (CONFIGURATION - 128)) | (1L << (COST - 128)) | (1L << (COUNT - 128)) | (1L << (CUBE - 128)) | (1L << (CURRENT - 128)) | (1L << (CYCLE - 128)) | (1L << (DATA - 128)) | (1L << (DAY - 128)) | (1L << (DEC - 128)) | (1L << (DECADE - 128)) | (1L << (DEFINER - 128)) | (1L << (DICTIONARY - 128)) | (1L << (DOW - 128)) | (1L << (DOY - 128)) | (1L << (DROP - 128)) | (1L << (EPOCH - 128)) | (1L << (EVERY - 128)) | (1L << (EXISTS - 128)) | (1L << (EXTERNAL - 128)) | (1L << (EXTRACT - 128)) | (1L << (FAMILY - 128)) | (1L << (FILTER - 128)) | (1L << (FIRST - 128)) | (1L << (FORMAT - 128)) | (1L << (FUSION - 128)) | (1L << (GROUPING - 128)) | (1L << (HASH - 128)) | (1L << (INDEX - 128)) | (1L << (INCREMENT - 128)) | (1L << (INPUT - 128)) | (1L << (INSERT - 128)) | (1L << (INTERSECTION - 128)) | (1L << (ISCACHABLE - 128)) | (1L << (ISODOW - 128)) | (1L << (ISOYEAR - 128)) | (1L << (ISSTRICT - 128)) | (1L << (LANGUAGE - 128)) | (1L << (LARGE - 128)) | (1L << (LAST - 128)) | (1L << (LESS - 128)) | (1L << (LIST - 128)) | (1L << (LOCATION - 128)) | (1L << (MATCH - 128)) | (1L << (MAX - 128)) | (1L << (MAXVALUE - 128)) | (1L << (MICROSECONDS - 128)))) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (MILLENNIUM - 192)) | (1L << (MILLISECONDS - 192)) | (1L << (MIN - 192)) | (1L << (MINVALUE - 192)) | (1L << (MINUTE - 192)) | (1L << (MONTH - 192)) | (1L << (NATIONAL - 192)) | (1L << (NO - 192)) | (1L << (NONE - 192)) | (1L << (NULLIF - 192)) | (1L << (OBJECT - 192)) | (1L << (OPTION - 192)) | (1L << (OPTIONS - 192)) | (1L << (OVERWRITE - 192)) | (1L << (PARSER - 192)) | (1L << (PARTIAL - 192)) | (1L << (PARTITION - 192)) | (1L << (PARTITIONS - 192)) | (1L << (PRECISION - 192)) | (1L << (PUBLIC - 192)) | (1L << (PURGE - 192)) | (1L << (QUARTER - 192)) | (1L << (RANGE - 192)) | (1L << (REGEXP - 192)) | (1L << (RLIKE - 192)) | (1L << (ROLLUP - 192)) | (1L << (SEARCH - 192)) | (1L << (SECOND - 192)) | (1L << (SECURITY - 192)) | (1L << (SERVER - 192)) | (1L << (SET - 192)) | (1L << (SIMILAR - 192)) | (1L << (SIMPLE - 192)) | (1L << (STABLE - 192)) | (1L << (START - 192)) | (1L << (STORAGE - 192)) | (1L << (STDDEV_POP - 192)) | (1L << (STDDEV_SAMP - 192)) | (1L << (SUBPARTITION - 192)) | (1L << (SUM - 192)) | (1L << (TABLESPACE - 192)) | (1L << (TEMPLATE - 192)) | (1L << (THAN - 192)) | (1L << (TIMEZONE - 192)) | (1L << (TIMEZONE_HOUR - 192)) | (1L << (TIMEZONE_MINUTE - 192)) | (1L << (TRIM - 192)) | (1L << (TO - 192)) | (1L << (TYPE - 192)) | (1L << (UNKNOWN - 192)) | (1L << (UNLOGGED - 192)) | (1L << (VALUES - 192)) | (1L << (VAR_SAMP - 192)) | (1L << (VAR_POP - 192)) | (1L << (VARYING - 192)) | (1L << (VOLATILE - 192)) | (1L << (WEEK - 192)) | (1L << (WINDOW - 192)) | (1L << (WRAPPER - 192)) | (1L << (YEAR - 192)) | (1L << (ZONE - 192)) | (1L << (BOOLEAN - 192)))) != 0) || ((((_la - 256)) & ~0x3f) == 0 && ((1L << (_la - 256)) & ((1L << (BOOL - 256)) | (1L << (BIT - 256)) | (1L << (VARBIT - 256)) | (1L << (INT1 - 256)) | (1L << (INT2 - 256)) | (1L << (INT4 - 256)) | (1L << (INT8 - 256)) | (1L << (TINYINT - 256)) | (1L << (SMALLINT - 256)) | (1L << (INT - 256)) | (1L << (INTEGER - 256)) | (1L << (BIGINT - 256)) | (1L << (FLOAT4 - 256)) | (1L << (FLOAT8 - 256)) | (1L << (REAL - 256)) | (1L << (FLOAT - 256)) | (1L << (DOUBLE - 256)) | (1L << (NUMERIC - 256)) | (1L << (DECIMAL - 256)) | (1L << (CHAR - 256)) | (1L << (VARCHAR - 256)) | (1L << (NCHAR - 256)) | (1L << (NVARCHAR - 256)) | (1L << (DATE - 256)) | (1L << (TIME - 256)) | (1L << (TIMETZ - 256)) | (1L << (TIMESTAMP - 256)) | (1L << (TIMESTAMPTZ - 256)) | (1L << (TEXT - 256)) | (1L << (UUID - 256)) | (1L << (VARBINARY - 256)) | (1L << (BLOB - 256)) | (1L << (BYTEA - 256)) | (1L << (INET4 - 256)) | (1L << (DOUBLE_QUOTE - 256)))) != 0) || _la==Identifier );
						setState(700); match(RIGHT_PAREN);
						}
						}
						setState(704); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 93)) & ~0x3f) == 0 && ((1L << (_la - 93)) & ((1L << (REFERENCES - 93)) | (1L << (SELECT - 93)) | (1L << (UPDATE - 93)))) != 0) || _la==INSERT );
					}
					break;
				case ALL:
					{
					setState(706); match(ALL);
					setState(708);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(707); match(PRIVILEGES);
						}
					}

					setState(710); match(LEFT_PAREN);
					setState(715); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(711); ((Revoke_statementContext)_localctx).column = identifier();
						setState(713);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(712); match(COMMA);
							}
						}

						}
						}
						setState(717); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (ADMIN - 128)) | (1L << (AVG - 128)) | (1L << (BETWEEN - 128)) | (1L << (BY - 128)) | (1L << (CACHE - 128)) | (1L << (CALLED - 128)) | (1L << (CLASS - 128)) | (1L << (CENTURY - 128)) | (1L << (CHARACTER - 128)) | (1L << (CHECK - 128)) | (1L << (COLLECT - 128)) | (1L << (COALESCE - 128)) | (1L << (COLUMN - 128)) | (1L << (COMMENT - 128)) | (1L << (COMMENTS - 128)) | (1L << (COMMIT - 128)) | (1L << (CONFIGURATION - 128)) | (1L << (COST - 128)) | (1L << (COUNT - 128)) | (1L << (CUBE - 128)) | (1L << (CURRENT - 128)) | (1L << (CYCLE - 128)) | (1L << (DATA - 128)) | (1L << (DAY - 128)) | (1L << (DEC - 128)) | (1L << (DECADE - 128)) | (1L << (DEFINER - 128)) | (1L << (DICTIONARY - 128)) | (1L << (DOW - 128)) | (1L << (DOY - 128)) | (1L << (DROP - 128)) | (1L << (EPOCH - 128)) | (1L << (EVERY - 128)) | (1L << (EXISTS - 128)) | (1L << (EXTERNAL - 128)) | (1L << (EXTRACT - 128)) | (1L << (FAMILY - 128)) | (1L << (FILTER - 128)) | (1L << (FIRST - 128)) | (1L << (FORMAT - 128)) | (1L << (FUSION - 128)) | (1L << (GROUPING - 128)) | (1L << (HASH - 128)) | (1L << (INDEX - 128)) | (1L << (INCREMENT - 128)) | (1L << (INPUT - 128)) | (1L << (INSERT - 128)) | (1L << (INTERSECTION - 128)) | (1L << (ISCACHABLE - 128)) | (1L << (ISODOW - 128)) | (1L << (ISOYEAR - 128)) | (1L << (ISSTRICT - 128)) | (1L << (LANGUAGE - 128)) | (1L << (LARGE - 128)) | (1L << (LAST - 128)) | (1L << (LESS - 128)) | (1L << (LIST - 128)) | (1L << (LOCATION - 128)) | (1L << (MATCH - 128)) | (1L << (MAX - 128)) | (1L << (MAXVALUE - 128)) | (1L << (MICROSECONDS - 128)))) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (MILLENNIUM - 192)) | (1L << (MILLISECONDS - 192)) | (1L << (MIN - 192)) | (1L << (MINVALUE - 192)) | (1L << (MINUTE - 192)) | (1L << (MONTH - 192)) | (1L << (NATIONAL - 192)) | (1L << (NO - 192)) | (1L << (NONE - 192)) | (1L << (NULLIF - 192)) | (1L << (OBJECT - 192)) | (1L << (OPTION - 192)) | (1L << (OPTIONS - 192)) | (1L << (OVERWRITE - 192)) | (1L << (PARSER - 192)) | (1L << (PARTIAL - 192)) | (1L << (PARTITION - 192)) | (1L << (PARTITIONS - 192)) | (1L << (PRECISION - 192)) | (1L << (PUBLIC - 192)) | (1L << (PURGE - 192)) | (1L << (QUARTER - 192)) | (1L << (RANGE - 192)) | (1L << (REGEXP - 192)) | (1L << (RLIKE - 192)) | (1L << (ROLLUP - 192)) | (1L << (SEARCH - 192)) | (1L << (SECOND - 192)) | (1L << (SECURITY - 192)) | (1L << (SERVER - 192)) | (1L << (SET - 192)) | (1L << (SIMILAR - 192)) | (1L << (SIMPLE - 192)) | (1L << (STABLE - 192)) | (1L << (START - 192)) | (1L << (STORAGE - 192)) | (1L << (STDDEV_POP - 192)) | (1L << (STDDEV_SAMP - 192)) | (1L << (SUBPARTITION - 192)) | (1L << (SUM - 192)) | (1L << (TABLESPACE - 192)) | (1L << (TEMPLATE - 192)) | (1L << (THAN - 192)) | (1L << (TIMEZONE - 192)) | (1L << (TIMEZONE_HOUR - 192)) | (1L << (TIMEZONE_MINUTE - 192)) | (1L << (TRIM - 192)) | (1L << (TO - 192)) | (1L << (TYPE - 192)) | (1L << (UNKNOWN - 192)) | (1L << (UNLOGGED - 192)) | (1L << (VALUES - 192)) | (1L << (VAR_SAMP - 192)) | (1L << (VAR_POP - 192)) | (1L << (VARYING - 192)) | (1L << (VOLATILE - 192)) | (1L << (WEEK - 192)) | (1L << (WINDOW - 192)) | (1L << (WRAPPER - 192)) | (1L << (YEAR - 192)) | (1L << (ZONE - 192)) | (1L << (BOOLEAN - 192)))) != 0) || ((((_la - 256)) & ~0x3f) == 0 && ((1L << (_la - 256)) & ((1L << (BOOL - 256)) | (1L << (BIT - 256)) | (1L << (VARBIT - 256)) | (1L << (INT1 - 256)) | (1L << (INT2 - 256)) | (1L << (INT4 - 256)) | (1L << (INT8 - 256)) | (1L << (TINYINT - 256)) | (1L << (SMALLINT - 256)) | (1L << (INT - 256)) | (1L << (INTEGER - 256)) | (1L << (BIGINT - 256)) | (1L << (FLOAT4 - 256)) | (1L << (FLOAT8 - 256)) | (1L << (REAL - 256)) | (1L << (FLOAT - 256)) | (1L << (DOUBLE - 256)) | (1L << (NUMERIC - 256)) | (1L << (DECIMAL - 256)) | (1L << (CHAR - 256)) | (1L << (VARCHAR - 256)) | (1L << (NCHAR - 256)) | (1L << (NVARCHAR - 256)) | (1L << (DATE - 256)) | (1L << (TIME - 256)) | (1L << (TIMETZ - 256)) | (1L << (TIMESTAMP - 256)) | (1L << (TIMESTAMPTZ - 256)) | (1L << (TEXT - 256)) | (1L << (UUID - 256)) | (1L << (VARBINARY - 256)) | (1L << (BLOB - 256)) | (1L << (BYTEA - 256)) | (1L << (INET4 - 256)) | (1L << (DOUBLE_QUOTE - 256)))) != 0) || _la==Identifier );
					setState(719); match(RIGHT_PAREN);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(723); match(ON);
				setState(725);
				_la = _input.LA(1);
				if (_la==TABLE) {
					{
					setState(724); match(TABLE);
					}
				}

				setState(731); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(727); ((Revoke_statementContext)_localctx).table_name = schema_qualified_name();
					setState(729);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(728); match(COMMA);
						}
					}

					}
					}
					setState(733); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (ADMIN - 128)) | (1L << (AVG - 128)) | (1L << (BETWEEN - 128)) | (1L << (BY - 128)) | (1L << (CACHE - 128)) | (1L << (CALLED - 128)) | (1L << (CLASS - 128)) | (1L << (CENTURY - 128)) | (1L << (CHARACTER - 128)) | (1L << (CHECK - 128)) | (1L << (COLLECT - 128)) | (1L << (COALESCE - 128)) | (1L << (COLUMN - 128)) | (1L << (COMMENT - 128)) | (1L << (COMMENTS - 128)) | (1L << (COMMIT - 128)) | (1L << (CONFIGURATION - 128)) | (1L << (COST - 128)) | (1L << (COUNT - 128)) | (1L << (CUBE - 128)) | (1L << (CURRENT - 128)) | (1L << (CYCLE - 128)) | (1L << (DATA - 128)) | (1L << (DAY - 128)) | (1L << (DEC - 128)) | (1L << (DECADE - 128)) | (1L << (DEFINER - 128)) | (1L << (DICTIONARY - 128)) | (1L << (DOW - 128)) | (1L << (DOY - 128)) | (1L << (DROP - 128)) | (1L << (EPOCH - 128)) | (1L << (EVERY - 128)) | (1L << (EXISTS - 128)) | (1L << (EXTERNAL - 128)) | (1L << (EXTRACT - 128)) | (1L << (FAMILY - 128)) | (1L << (FILTER - 128)) | (1L << (FIRST - 128)) | (1L << (FORMAT - 128)) | (1L << (FUSION - 128)) | (1L << (GROUPING - 128)) | (1L << (HASH - 128)) | (1L << (INDEX - 128)) | (1L << (INCREMENT - 128)) | (1L << (INPUT - 128)) | (1L << (INSERT - 128)) | (1L << (INTERSECTION - 128)) | (1L << (ISCACHABLE - 128)) | (1L << (ISODOW - 128)) | (1L << (ISOYEAR - 128)) | (1L << (ISSTRICT - 128)) | (1L << (LANGUAGE - 128)) | (1L << (LARGE - 128)) | (1L << (LAST - 128)) | (1L << (LESS - 128)) | (1L << (LIST - 128)) | (1L << (LOCATION - 128)) | (1L << (MATCH - 128)) | (1L << (MAX - 128)) | (1L << (MAXVALUE - 128)) | (1L << (MICROSECONDS - 128)))) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (MILLENNIUM - 192)) | (1L << (MILLISECONDS - 192)) | (1L << (MIN - 192)) | (1L << (MINVALUE - 192)) | (1L << (MINUTE - 192)) | (1L << (MONTH - 192)) | (1L << (NATIONAL - 192)) | (1L << (NO - 192)) | (1L << (NONE - 192)) | (1L << (NULLIF - 192)) | (1L << (OBJECT - 192)) | (1L << (OPTION - 192)) | (1L << (OPTIONS - 192)) | (1L << (OVERWRITE - 192)) | (1L << (PARSER - 192)) | (1L << (PARTIAL - 192)) | (1L << (PARTITION - 192)) | (1L << (PARTITIONS - 192)) | (1L << (PRECISION - 192)) | (1L << (PUBLIC - 192)) | (1L << (PURGE - 192)) | (1L << (QUARTER - 192)) | (1L << (RANGE - 192)) | (1L << (REGEXP - 192)) | (1L << (RLIKE - 192)) | (1L << (ROLLUP - 192)) | (1L << (SEARCH - 192)) | (1L << (SECOND - 192)) | (1L << (SECURITY - 192)) | (1L << (SERVER - 192)) | (1L << (SET - 192)) | (1L << (SIMILAR - 192)) | (1L << (SIMPLE - 192)) | (1L << (STABLE - 192)) | (1L << (START - 192)) | (1L << (STORAGE - 192)) | (1L << (STDDEV_POP - 192)) | (1L << (STDDEV_SAMP - 192)) | (1L << (SUBPARTITION - 192)) | (1L << (SUM - 192)) | (1L << (TABLESPACE - 192)) | (1L << (TEMPLATE - 192)) | (1L << (THAN - 192)) | (1L << (TIMEZONE - 192)) | (1L << (TIMEZONE_HOUR - 192)) | (1L << (TIMEZONE_MINUTE - 192)) | (1L << (TRIM - 192)) | (1L << (TO - 192)) | (1L << (TYPE - 192)) | (1L << (UNKNOWN - 192)) | (1L << (UNLOGGED - 192)) | (1L << (VALUES - 192)) | (1L << (VAR_SAMP - 192)) | (1L << (VAR_POP - 192)) | (1L << (VARYING - 192)) | (1L << (VOLATILE - 192)) | (1L << (WEEK - 192)) | (1L << (WINDOW - 192)) | (1L << (WRAPPER - 192)) | (1L << (YEAR - 192)) | (1L << (ZONE - 192)) | (1L << (BOOLEAN - 192)))) != 0) || ((((_la - 256)) & ~0x3f) == 0 && ((1L << (_la - 256)) & ((1L << (BOOL - 256)) | (1L << (BIT - 256)) | (1L << (VARBIT - 256)) | (1L << (INT1 - 256)) | (1L << (INT2 - 256)) | (1L << (INT4 - 256)) | (1L << (INT8 - 256)) | (1L << (TINYINT - 256)) | (1L << (SMALLINT - 256)) | (1L << (INT - 256)) | (1L << (INTEGER - 256)) | (1L << (BIGINT - 256)) | (1L << (FLOAT4 - 256)) | (1L << (FLOAT8 - 256)) | (1L << (REAL - 256)) | (1L << (FLOAT - 256)) | (1L << (DOUBLE - 256)) | (1L << (NUMERIC - 256)) | (1L << (DECIMAL - 256)) | (1L << (CHAR - 256)) | (1L << (VARCHAR - 256)) | (1L << (NCHAR - 256)) | (1L << (NVARCHAR - 256)) | (1L << (DATE - 256)) | (1L << (TIME - 256)) | (1L << (TIMETZ - 256)) | (1L << (TIMESTAMP - 256)) | (1L << (TIMESTAMPTZ - 256)) | (1L << (TEXT - 256)) | (1L << (UUID - 256)) | (1L << (VARBINARY - 256)) | (1L << (BLOB - 256)) | (1L << (BYTEA - 256)) | (1L << (INET4 - 256)) | (1L << (DOUBLE_QUOTE - 256)))) != 0) || _la==Identifier );
				setState(735); revoke_from_cascade_restrict();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(737); match(REVOKE);
				setState(741);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(738); match(GRANT);
					setState(739); match(OPTION);
					setState(740); match(FOR);
					}
				}

				setState(752);
				switch (_input.LA(1)) {
				case SELECT:
				case UPDATE:
				case USAGE:
					{
					setState(744); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(743);
						_la = _input.LA(1);
						if ( !(((((_la - 103)) & ~0x3f) == 0 && ((1L << (_la - 103)) & ((1L << (SELECT - 103)) | (1L << (UPDATE - 103)) | (1L << (USAGE - 103)))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
						}
						setState(746); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 103)) & ~0x3f) == 0 && ((1L << (_la - 103)) & ((1L << (SELECT - 103)) | (1L << (UPDATE - 103)) | (1L << (USAGE - 103)))) != 0) );
					}
					break;
				case ALL:
					{
					setState(748); match(ALL);
					setState(750);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(749); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(754); match(ON);
				setState(776);
				switch (_input.LA(1)) {
				case SEQUENCE:
					{
					setState(755); match(SEQUENCE);
					setState(760); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(756); ((Revoke_statementContext)_localctx).sequence_name = schema_qualified_name();
						setState(758);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(757); match(COMMA);
							}
						}

						}
						}
						setState(762); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (ADMIN - 128)) | (1L << (AVG - 128)) | (1L << (BETWEEN - 128)) | (1L << (BY - 128)) | (1L << (CACHE - 128)) | (1L << (CALLED - 128)) | (1L << (CLASS - 128)) | (1L << (CENTURY - 128)) | (1L << (CHARACTER - 128)) | (1L << (CHECK - 128)) | (1L << (COLLECT - 128)) | (1L << (COALESCE - 128)) | (1L << (COLUMN - 128)) | (1L << (COMMENT - 128)) | (1L << (COMMENTS - 128)) | (1L << (COMMIT - 128)) | (1L << (CONFIGURATION - 128)) | (1L << (COST - 128)) | (1L << (COUNT - 128)) | (1L << (CUBE - 128)) | (1L << (CURRENT - 128)) | (1L << (CYCLE - 128)) | (1L << (DATA - 128)) | (1L << (DAY - 128)) | (1L << (DEC - 128)) | (1L << (DECADE - 128)) | (1L << (DEFINER - 128)) | (1L << (DICTIONARY - 128)) | (1L << (DOW - 128)) | (1L << (DOY - 128)) | (1L << (DROP - 128)) | (1L << (EPOCH - 128)) | (1L << (EVERY - 128)) | (1L << (EXISTS - 128)) | (1L << (EXTERNAL - 128)) | (1L << (EXTRACT - 128)) | (1L << (FAMILY - 128)) | (1L << (FILTER - 128)) | (1L << (FIRST - 128)) | (1L << (FORMAT - 128)) | (1L << (FUSION - 128)) | (1L << (GROUPING - 128)) | (1L << (HASH - 128)) | (1L << (INDEX - 128)) | (1L << (INCREMENT - 128)) | (1L << (INPUT - 128)) | (1L << (INSERT - 128)) | (1L << (INTERSECTION - 128)) | (1L << (ISCACHABLE - 128)) | (1L << (ISODOW - 128)) | (1L << (ISOYEAR - 128)) | (1L << (ISSTRICT - 128)) | (1L << (LANGUAGE - 128)) | (1L << (LARGE - 128)) | (1L << (LAST - 128)) | (1L << (LESS - 128)) | (1L << (LIST - 128)) | (1L << (LOCATION - 128)) | (1L << (MATCH - 128)) | (1L << (MAX - 128)) | (1L << (MAXVALUE - 128)) | (1L << (MICROSECONDS - 128)))) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (MILLENNIUM - 192)) | (1L << (MILLISECONDS - 192)) | (1L << (MIN - 192)) | (1L << (MINVALUE - 192)) | (1L << (MINUTE - 192)) | (1L << (MONTH - 192)) | (1L << (NATIONAL - 192)) | (1L << (NO - 192)) | (1L << (NONE - 192)) | (1L << (NULLIF - 192)) | (1L << (OBJECT - 192)) | (1L << (OPTION - 192)) | (1L << (OPTIONS - 192)) | (1L << (OVERWRITE - 192)) | (1L << (PARSER - 192)) | (1L << (PARTIAL - 192)) | (1L << (PARTITION - 192)) | (1L << (PARTITIONS - 192)) | (1L << (PRECISION - 192)) | (1L << (PUBLIC - 192)) | (1L << (PURGE - 192)) | (1L << (QUARTER - 192)) | (1L << (RANGE - 192)) | (1L << (REGEXP - 192)) | (1L << (RLIKE - 192)) | (1L << (ROLLUP - 192)) | (1L << (SEARCH - 192)) | (1L << (SECOND - 192)) | (1L << (SECURITY - 192)) | (1L << (SERVER - 192)) | (1L << (SET - 192)) | (1L << (SIMILAR - 192)) | (1L << (SIMPLE - 192)) | (1L << (STABLE - 192)) | (1L << (START - 192)) | (1L << (STORAGE - 192)) | (1L << (STDDEV_POP - 192)) | (1L << (STDDEV_SAMP - 192)) | (1L << (SUBPARTITION - 192)) | (1L << (SUM - 192)) | (1L << (TABLESPACE - 192)) | (1L << (TEMPLATE - 192)) | (1L << (THAN - 192)) | (1L << (TIMEZONE - 192)) | (1L << (TIMEZONE_HOUR - 192)) | (1L << (TIMEZONE_MINUTE - 192)) | (1L << (TRIM - 192)) | (1L << (TO - 192)) | (1L << (TYPE - 192)) | (1L << (UNKNOWN - 192)) | (1L << (UNLOGGED - 192)) | (1L << (VALUES - 192)) | (1L << (VAR_SAMP - 192)) | (1L << (VAR_POP - 192)) | (1L << (VARYING - 192)) | (1L << (VOLATILE - 192)) | (1L << (WEEK - 192)) | (1L << (WINDOW - 192)) | (1L << (WRAPPER - 192)) | (1L << (YEAR - 192)) | (1L << (ZONE - 192)) | (1L << (BOOLEAN - 192)))) != 0) || ((((_la - 256)) & ~0x3f) == 0 && ((1L << (_la - 256)) & ((1L << (BOOL - 256)) | (1L << (BIT - 256)) | (1L << (VARBIT - 256)) | (1L << (INT1 - 256)) | (1L << (INT2 - 256)) | (1L << (INT4 - 256)) | (1L << (INT8 - 256)) | (1L << (TINYINT - 256)) | (1L << (SMALLINT - 256)) | (1L << (INT - 256)) | (1L << (INTEGER - 256)) | (1L << (BIGINT - 256)) | (1L << (FLOAT4 - 256)) | (1L << (FLOAT8 - 256)) | (1L << (REAL - 256)) | (1L << (FLOAT - 256)) | (1L << (DOUBLE - 256)) | (1L << (NUMERIC - 256)) | (1L << (DECIMAL - 256)) | (1L << (CHAR - 256)) | (1L << (VARCHAR - 256)) | (1L << (NCHAR - 256)) | (1L << (NVARCHAR - 256)) | (1L << (DATE - 256)) | (1L << (TIME - 256)) | (1L << (TIMETZ - 256)) | (1L << (TIMESTAMP - 256)) | (1L << (TIMESTAMPTZ - 256)) | (1L << (TEXT - 256)) | (1L << (UUID - 256)) | (1L << (VARBINARY - 256)) | (1L << (BLOB - 256)) | (1L << (BYTEA - 256)) | (1L << (INET4 - 256)) | (1L << (DOUBLE_QUOTE - 256)))) != 0) || _la==Identifier );
					}
					break;
				case ALL:
					{
					setState(764); match(ALL);
					setState(765); match(SEQUENCES);
					setState(766); match(IN);
					setState(767); match(SCHEMA);
					setState(772); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(768); ((Revoke_statementContext)_localctx).schema_name = identifier();
						setState(770);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(769); match(COMMA);
							}
						}

						}
						}
						setState(774); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (ADMIN - 128)) | (1L << (AVG - 128)) | (1L << (BETWEEN - 128)) | (1L << (BY - 128)) | (1L << (CACHE - 128)) | (1L << (CALLED - 128)) | (1L << (CLASS - 128)) | (1L << (CENTURY - 128)) | (1L << (CHARACTER - 128)) | (1L << (CHECK - 128)) | (1L << (COLLECT - 128)) | (1L << (COALESCE - 128)) | (1L << (COLUMN - 128)) | (1L << (COMMENT - 128)) | (1L << (COMMENTS - 128)) | (1L << (COMMIT - 128)) | (1L << (CONFIGURATION - 128)) | (1L << (COST - 128)) | (1L << (COUNT - 128)) | (1L << (CUBE - 128)) | (1L << (CURRENT - 128)) | (1L << (CYCLE - 128)) | (1L << (DATA - 128)) | (1L << (DAY - 128)) | (1L << (DEC - 128)) | (1L << (DECADE - 128)) | (1L << (DEFINER - 128)) | (1L << (DICTIONARY - 128)) | (1L << (DOW - 128)) | (1L << (DOY - 128)) | (1L << (DROP - 128)) | (1L << (EPOCH - 128)) | (1L << (EVERY - 128)) | (1L << (EXISTS - 128)) | (1L << (EXTERNAL - 128)) | (1L << (EXTRACT - 128)) | (1L << (FAMILY - 128)) | (1L << (FILTER - 128)) | (1L << (FIRST - 128)) | (1L << (FORMAT - 128)) | (1L << (FUSION - 128)) | (1L << (GROUPING - 128)) | (1L << (HASH - 128)) | (1L << (INDEX - 128)) | (1L << (INCREMENT - 128)) | (1L << (INPUT - 128)) | (1L << (INSERT - 128)) | (1L << (INTERSECTION - 128)) | (1L << (ISCACHABLE - 128)) | (1L << (ISODOW - 128)) | (1L << (ISOYEAR - 128)) | (1L << (ISSTRICT - 128)) | (1L << (LANGUAGE - 128)) | (1L << (LARGE - 128)) | (1L << (LAST - 128)) | (1L << (LESS - 128)) | (1L << (LIST - 128)) | (1L << (LOCATION - 128)) | (1L << (MATCH - 128)) | (1L << (MAX - 128)) | (1L << (MAXVALUE - 128)) | (1L << (MICROSECONDS - 128)))) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (MILLENNIUM - 192)) | (1L << (MILLISECONDS - 192)) | (1L << (MIN - 192)) | (1L << (MINVALUE - 192)) | (1L << (MINUTE - 192)) | (1L << (MONTH - 192)) | (1L << (NATIONAL - 192)) | (1L << (NO - 192)) | (1L << (NONE - 192)) | (1L << (NULLIF - 192)) | (1L << (OBJECT - 192)) | (1L << (OPTION - 192)) | (1L << (OPTIONS - 192)) | (1L << (OVERWRITE - 192)) | (1L << (PARSER - 192)) | (1L << (PARTIAL - 192)) | (1L << (PARTITION - 192)) | (1L << (PARTITIONS - 192)) | (1L << (PRECISION - 192)) | (1L << (PUBLIC - 192)) | (1L << (PURGE - 192)) | (1L << (QUARTER - 192)) | (1L << (RANGE - 192)) | (1L << (REGEXP - 192)) | (1L << (RLIKE - 192)) | (1L << (ROLLUP - 192)) | (1L << (SEARCH - 192)) | (1L << (SECOND - 192)) | (1L << (SECURITY - 192)) | (1L << (SERVER - 192)) | (1L << (SET - 192)) | (1L << (SIMILAR - 192)) | (1L << (SIMPLE - 192)) | (1L << (STABLE - 192)) | (1L << (START - 192)) | (1L << (STORAGE - 192)) | (1L << (STDDEV_POP - 192)) | (1L << (STDDEV_SAMP - 192)) | (1L << (SUBPARTITION - 192)) | (1L << (SUM - 192)) | (1L << (TABLESPACE - 192)) | (1L << (TEMPLATE - 192)) | (1L << (THAN - 192)) | (1L << (TIMEZONE - 192)) | (1L << (TIMEZONE_HOUR - 192)) | (1L << (TIMEZONE_MINUTE - 192)) | (1L << (TRIM - 192)) | (1L << (TO - 192)) | (1L << (TYPE - 192)) | (1L << (UNKNOWN - 192)) | (1L << (UNLOGGED - 192)) | (1L << (VALUES - 192)) | (1L << (VAR_SAMP - 192)) | (1L << (VAR_POP - 192)) | (1L << (VARYING - 192)) | (1L << (VOLATILE - 192)) | (1L << (WEEK - 192)) | (1L << (WINDOW - 192)) | (1L << (WRAPPER - 192)) | (1L << (YEAR - 192)) | (1L << (ZONE - 192)) | (1L << (BOOLEAN - 192)))) != 0) || ((((_la - 256)) & ~0x3f) == 0 && ((1L << (_la - 256)) & ((1L << (BOOL - 256)) | (1L << (BIT - 256)) | (1L << (VARBIT - 256)) | (1L << (INT1 - 256)) | (1L << (INT2 - 256)) | (1L << (INT4 - 256)) | (1L << (INT8 - 256)) | (1L << (TINYINT - 256)) | (1L << (SMALLINT - 256)) | (1L << (INT - 256)) | (1L << (INTEGER - 256)) | (1L << (BIGINT - 256)) | (1L << (FLOAT4 - 256)) | (1L << (FLOAT8 - 256)) | (1L << (REAL - 256)) | (1L << (FLOAT - 256)) | (1L << (DOUBLE - 256)) | (1L << (NUMERIC - 256)) | (1L << (DECIMAL - 256)) | (1L << (CHAR - 256)) | (1L << (VARCHAR - 256)) | (1L << (NCHAR - 256)) | (1L << (NVARCHAR - 256)) | (1L << (DATE - 256)) | (1L << (TIME - 256)) | (1L << (TIMETZ - 256)) | (1L << (TIMESTAMP - 256)) | (1L << (TIMESTAMPTZ - 256)) | (1L << (TEXT - 256)) | (1L << (UUID - 256)) | (1L << (VARBINARY - 256)) | (1L << (BLOB - 256)) | (1L << (BYTEA - 256)) | (1L << (INET4 - 256)) | (1L << (DOUBLE_QUOTE - 256)))) != 0) || _la==Identifier );
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(778); revoke_from_cascade_restrict();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(780); match(REVOKE);
				setState(784);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(781); match(GRANT);
					setState(782); match(OPTION);
					setState(783); match(FOR);
					}
				}

				setState(795);
				switch (_input.LA(1)) {
				case CONNECT:
				case CREATE:
				case TEMP:
				case TEMPORARY:
					{
					setState(787); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(786);
						_la = _input.LA(1);
						if ( !(_la==CONNECT || _la==CREATE || _la==TEMP || _la==TEMPORARY) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
						}
						setState(789); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==CONNECT || _la==CREATE || _la==TEMP || _la==TEMPORARY );
					}
					break;
				case ALL:
					{
					setState(791); match(ALL);
					setState(793);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(792); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(797); match(ON);
				setState(798); match(DATABASE);
				setState(803); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(799); ((Revoke_statementContext)_localctx).database_name = identifier();
					setState(801);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(800); match(COMMA);
						}
					}

					}
					}
					setState(805); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (ADMIN - 128)) | (1L << (AVG - 128)) | (1L << (BETWEEN - 128)) | (1L << (BY - 128)) | (1L << (CACHE - 128)) | (1L << (CALLED - 128)) | (1L << (CLASS - 128)) | (1L << (CENTURY - 128)) | (1L << (CHARACTER - 128)) | (1L << (CHECK - 128)) | (1L << (COLLECT - 128)) | (1L << (COALESCE - 128)) | (1L << (COLUMN - 128)) | (1L << (COMMENT - 128)) | (1L << (COMMENTS - 128)) | (1L << (COMMIT - 128)) | (1L << (CONFIGURATION - 128)) | (1L << (COST - 128)) | (1L << (COUNT - 128)) | (1L << (CUBE - 128)) | (1L << (CURRENT - 128)) | (1L << (CYCLE - 128)) | (1L << (DATA - 128)) | (1L << (DAY - 128)) | (1L << (DEC - 128)) | (1L << (DECADE - 128)) | (1L << (DEFINER - 128)) | (1L << (DICTIONARY - 128)) | (1L << (DOW - 128)) | (1L << (DOY - 128)) | (1L << (DROP - 128)) | (1L << (EPOCH - 128)) | (1L << (EVERY - 128)) | (1L << (EXISTS - 128)) | (1L << (EXTERNAL - 128)) | (1L << (EXTRACT - 128)) | (1L << (FAMILY - 128)) | (1L << (FILTER - 128)) | (1L << (FIRST - 128)) | (1L << (FORMAT - 128)) | (1L << (FUSION - 128)) | (1L << (GROUPING - 128)) | (1L << (HASH - 128)) | (1L << (INDEX - 128)) | (1L << (INCREMENT - 128)) | (1L << (INPUT - 128)) | (1L << (INSERT - 128)) | (1L << (INTERSECTION - 128)) | (1L << (ISCACHABLE - 128)) | (1L << (ISODOW - 128)) | (1L << (ISOYEAR - 128)) | (1L << (ISSTRICT - 128)) | (1L << (LANGUAGE - 128)) | (1L << (LARGE - 128)) | (1L << (LAST - 128)) | (1L << (LESS - 128)) | (1L << (LIST - 128)) | (1L << (LOCATION - 128)) | (1L << (MATCH - 128)) | (1L << (MAX - 128)) | (1L << (MAXVALUE - 128)) | (1L << (MICROSECONDS - 128)))) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (MILLENNIUM - 192)) | (1L << (MILLISECONDS - 192)) | (1L << (MIN - 192)) | (1L << (MINVALUE - 192)) | (1L << (MINUTE - 192)) | (1L << (MONTH - 192)) | (1L << (NATIONAL - 192)) | (1L << (NO - 192)) | (1L << (NONE - 192)) | (1L << (NULLIF - 192)) | (1L << (OBJECT - 192)) | (1L << (OPTION - 192)) | (1L << (OPTIONS - 192)) | (1L << (OVERWRITE - 192)) | (1L << (PARSER - 192)) | (1L << (PARTIAL - 192)) | (1L << (PARTITION - 192)) | (1L << (PARTITIONS - 192)) | (1L << (PRECISION - 192)) | (1L << (PUBLIC - 192)) | (1L << (PURGE - 192)) | (1L << (QUARTER - 192)) | (1L << (RANGE - 192)) | (1L << (REGEXP - 192)) | (1L << (RLIKE - 192)) | (1L << (ROLLUP - 192)) | (1L << (SEARCH - 192)) | (1L << (SECOND - 192)) | (1L << (SECURITY - 192)) | (1L << (SERVER - 192)) | (1L << (SET - 192)) | (1L << (SIMILAR - 192)) | (1L << (SIMPLE - 192)) | (1L << (STABLE - 192)) | (1L << (START - 192)) | (1L << (STORAGE - 192)) | (1L << (STDDEV_POP - 192)) | (1L << (STDDEV_SAMP - 192)) | (1L << (SUBPARTITION - 192)) | (1L << (SUM - 192)) | (1L << (TABLESPACE - 192)) | (1L << (TEMPLATE - 192)) | (1L << (THAN - 192)) | (1L << (TIMEZONE - 192)) | (1L << (TIMEZONE_HOUR - 192)) | (1L << (TIMEZONE_MINUTE - 192)) | (1L << (TRIM - 192)) | (1L << (TO - 192)) | (1L << (TYPE - 192)) | (1L << (UNKNOWN - 192)) | (1L << (UNLOGGED - 192)) | (1L << (VALUES - 192)) | (1L << (VAR_SAMP - 192)) | (1L << (VAR_POP - 192)) | (1L << (VARYING - 192)) | (1L << (VOLATILE - 192)) | (1L << (WEEK - 192)) | (1L << (WINDOW - 192)) | (1L << (WRAPPER - 192)) | (1L << (YEAR - 192)) | (1L << (ZONE - 192)) | (1L << (BOOLEAN - 192)))) != 0) || ((((_la - 256)) & ~0x3f) == 0 && ((1L << (_la - 256)) & ((1L << (BOOL - 256)) | (1L << (BIT - 256)) | (1L << (VARBIT - 256)) | (1L << (INT1 - 256)) | (1L << (INT2 - 256)) | (1L << (INT4 - 256)) | (1L << (INT8 - 256)) | (1L << (TINYINT - 256)) | (1L << (SMALLINT - 256)) | (1L << (INT - 256)) | (1L << (INTEGER - 256)) | (1L << (BIGINT - 256)) | (1L << (FLOAT4 - 256)) | (1L << (FLOAT8 - 256)) | (1L << (REAL - 256)) | (1L << (FLOAT - 256)) | (1L << (DOUBLE - 256)) | (1L << (NUMERIC - 256)) | (1L << (DECIMAL - 256)) | (1L << (CHAR - 256)) | (1L << (VARCHAR - 256)) | (1L << (NCHAR - 256)) | (1L << (NVARCHAR - 256)) | (1L << (DATE - 256)) | (1L << (TIME - 256)) | (1L << (TIMETZ - 256)) | (1L << (TIMESTAMP - 256)) | (1L << (TIMESTAMPTZ - 256)) | (1L << (TEXT - 256)) | (1L << (UUID - 256)) | (1L << (VARBINARY - 256)) | (1L << (BLOB - 256)) | (1L << (BYTEA - 256)) | (1L << (INET4 - 256)) | (1L << (DOUBLE_QUOTE - 256)))) != 0) || _la==Identifier );
				setState(807); revoke_from_cascade_restrict();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(809); match(REVOKE);
				setState(813);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(810); match(GRANT);
					setState(811); match(OPTION);
					setState(812); match(FOR);
					}
				}

				setState(820);
				switch (_input.LA(1)) {
				case USAGE:
					{
					setState(815); match(USAGE);
					}
					break;
				case ALL:
					{
					setState(816); match(ALL);
					setState(818);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(817); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(822); match(ON);
				setState(823); match(FOREIGN);
				setState(824); match(DATA);
				setState(825); match(WRAPPER);
				setState(830); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(826); ((Revoke_statementContext)_localctx).fdw_name = schema_qualified_name();
					setState(828);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(827); match(COMMA);
						}
					}

					}
					}
					setState(832); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (ADMIN - 128)) | (1L << (AVG - 128)) | (1L << (BETWEEN - 128)) | (1L << (BY - 128)) | (1L << (CACHE - 128)) | (1L << (CALLED - 128)) | (1L << (CLASS - 128)) | (1L << (CENTURY - 128)) | (1L << (CHARACTER - 128)) | (1L << (CHECK - 128)) | (1L << (COLLECT - 128)) | (1L << (COALESCE - 128)) | (1L << (COLUMN - 128)) | (1L << (COMMENT - 128)) | (1L << (COMMENTS - 128)) | (1L << (COMMIT - 128)) | (1L << (CONFIGURATION - 128)) | (1L << (COST - 128)) | (1L << (COUNT - 128)) | (1L << (CUBE - 128)) | (1L << (CURRENT - 128)) | (1L << (CYCLE - 128)) | (1L << (DATA - 128)) | (1L << (DAY - 128)) | (1L << (DEC - 128)) | (1L << (DECADE - 128)) | (1L << (DEFINER - 128)) | (1L << (DICTIONARY - 128)) | (1L << (DOW - 128)) | (1L << (DOY - 128)) | (1L << (DROP - 128)) | (1L << (EPOCH - 128)) | (1L << (EVERY - 128)) | (1L << (EXISTS - 128)) | (1L << (EXTERNAL - 128)) | (1L << (EXTRACT - 128)) | (1L << (FAMILY - 128)) | (1L << (FILTER - 128)) | (1L << (FIRST - 128)) | (1L << (FORMAT - 128)) | (1L << (FUSION - 128)) | (1L << (GROUPING - 128)) | (1L << (HASH - 128)) | (1L << (INDEX - 128)) | (1L << (INCREMENT - 128)) | (1L << (INPUT - 128)) | (1L << (INSERT - 128)) | (1L << (INTERSECTION - 128)) | (1L << (ISCACHABLE - 128)) | (1L << (ISODOW - 128)) | (1L << (ISOYEAR - 128)) | (1L << (ISSTRICT - 128)) | (1L << (LANGUAGE - 128)) | (1L << (LARGE - 128)) | (1L << (LAST - 128)) | (1L << (LESS - 128)) | (1L << (LIST - 128)) | (1L << (LOCATION - 128)) | (1L << (MATCH - 128)) | (1L << (MAX - 128)) | (1L << (MAXVALUE - 128)) | (1L << (MICROSECONDS - 128)))) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (MILLENNIUM - 192)) | (1L << (MILLISECONDS - 192)) | (1L << (MIN - 192)) | (1L << (MINVALUE - 192)) | (1L << (MINUTE - 192)) | (1L << (MONTH - 192)) | (1L << (NATIONAL - 192)) | (1L << (NO - 192)) | (1L << (NONE - 192)) | (1L << (NULLIF - 192)) | (1L << (OBJECT - 192)) | (1L << (OPTION - 192)) | (1L << (OPTIONS - 192)) | (1L << (OVERWRITE - 192)) | (1L << (PARSER - 192)) | (1L << (PARTIAL - 192)) | (1L << (PARTITION - 192)) | (1L << (PARTITIONS - 192)) | (1L << (PRECISION - 192)) | (1L << (PUBLIC - 192)) | (1L << (PURGE - 192)) | (1L << (QUARTER - 192)) | (1L << (RANGE - 192)) | (1L << (REGEXP - 192)) | (1L << (RLIKE - 192)) | (1L << (ROLLUP - 192)) | (1L << (SEARCH - 192)) | (1L << (SECOND - 192)) | (1L << (SECURITY - 192)) | (1L << (SERVER - 192)) | (1L << (SET - 192)) | (1L << (SIMILAR - 192)) | (1L << (SIMPLE - 192)) | (1L << (STABLE - 192)) | (1L << (START - 192)) | (1L << (STORAGE - 192)) | (1L << (STDDEV_POP - 192)) | (1L << (STDDEV_SAMP - 192)) | (1L << (SUBPARTITION - 192)) | (1L << (SUM - 192)) | (1L << (TABLESPACE - 192)) | (1L << (TEMPLATE - 192)) | (1L << (THAN - 192)) | (1L << (TIMEZONE - 192)) | (1L << (TIMEZONE_HOUR - 192)) | (1L << (TIMEZONE_MINUTE - 192)) | (1L << (TRIM - 192)) | (1L << (TO - 192)) | (1L << (TYPE - 192)) | (1L << (UNKNOWN - 192)) | (1L << (UNLOGGED - 192)) | (1L << (VALUES - 192)) | (1L << (VAR_SAMP - 192)) | (1L << (VAR_POP - 192)) | (1L << (VARYING - 192)) | (1L << (VOLATILE - 192)) | (1L << (WEEK - 192)) | (1L << (WINDOW - 192)) | (1L << (WRAPPER - 192)) | (1L << (YEAR - 192)) | (1L << (ZONE - 192)) | (1L << (BOOLEAN - 192)))) != 0) || ((((_la - 256)) & ~0x3f) == 0 && ((1L << (_la - 256)) & ((1L << (BOOL - 256)) | (1L << (BIT - 256)) | (1L << (VARBIT - 256)) | (1L << (INT1 - 256)) | (1L << (INT2 - 256)) | (1L << (INT4 - 256)) | (1L << (INT8 - 256)) | (1L << (TINYINT - 256)) | (1L << (SMALLINT - 256)) | (1L << (INT - 256)) | (1L << (INTEGER - 256)) | (1L << (BIGINT - 256)) | (1L << (FLOAT4 - 256)) | (1L << (FLOAT8 - 256)) | (1L << (REAL - 256)) | (1L << (FLOAT - 256)) | (1L << (DOUBLE - 256)) | (1L << (NUMERIC - 256)) | (1L << (DECIMAL - 256)) | (1L << (CHAR - 256)) | (1L << (VARCHAR - 256)) | (1L << (NCHAR - 256)) | (1L << (NVARCHAR - 256)) | (1L << (DATE - 256)) | (1L << (TIME - 256)) | (1L << (TIMETZ - 256)) | (1L << (TIMESTAMP - 256)) | (1L << (TIMESTAMPTZ - 256)) | (1L << (TEXT - 256)) | (1L << (UUID - 256)) | (1L << (VARBINARY - 256)) | (1L << (BLOB - 256)) | (1L << (BYTEA - 256)) | (1L << (INET4 - 256)) | (1L << (DOUBLE_QUOTE - 256)))) != 0) || _la==Identifier );
				setState(834); revoke_from_cascade_restrict();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(836); match(REVOKE);
				setState(840);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(837); match(GRANT);
					setState(838); match(OPTION);
					setState(839); match(FOR);
					}
				}

				setState(847);
				switch (_input.LA(1)) {
				case USAGE:
					{
					setState(842); match(USAGE);
					}
					break;
				case ALL:
					{
					setState(843); match(ALL);
					setState(845);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(844); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(849); match(ON);
				setState(850); match(FOREIGN);
				setState(851); match(SERVER);
				setState(856); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(852); ((Revoke_statementContext)_localctx).server_name = identifier();
					setState(854);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(853); match(COMMA);
						}
					}

					}
					}
					setState(858); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (ADMIN - 128)) | (1L << (AVG - 128)) | (1L << (BETWEEN - 128)) | (1L << (BY - 128)) | (1L << (CACHE - 128)) | (1L << (CALLED - 128)) | (1L << (CLASS - 128)) | (1L << (CENTURY - 128)) | (1L << (CHARACTER - 128)) | (1L << (CHECK - 128)) | (1L << (COLLECT - 128)) | (1L << (COALESCE - 128)) | (1L << (COLUMN - 128)) | (1L << (COMMENT - 128)) | (1L << (COMMENTS - 128)) | (1L << (COMMIT - 128)) | (1L << (CONFIGURATION - 128)) | (1L << (COST - 128)) | (1L << (COUNT - 128)) | (1L << (CUBE - 128)) | (1L << (CURRENT - 128)) | (1L << (CYCLE - 128)) | (1L << (DATA - 128)) | (1L << (DAY - 128)) | (1L << (DEC - 128)) | (1L << (DECADE - 128)) | (1L << (DEFINER - 128)) | (1L << (DICTIONARY - 128)) | (1L << (DOW - 128)) | (1L << (DOY - 128)) | (1L << (DROP - 128)) | (1L << (EPOCH - 128)) | (1L << (EVERY - 128)) | (1L << (EXISTS - 128)) | (1L << (EXTERNAL - 128)) | (1L << (EXTRACT - 128)) | (1L << (FAMILY - 128)) | (1L << (FILTER - 128)) | (1L << (FIRST - 128)) | (1L << (FORMAT - 128)) | (1L << (FUSION - 128)) | (1L << (GROUPING - 128)) | (1L << (HASH - 128)) | (1L << (INDEX - 128)) | (1L << (INCREMENT - 128)) | (1L << (INPUT - 128)) | (1L << (INSERT - 128)) | (1L << (INTERSECTION - 128)) | (1L << (ISCACHABLE - 128)) | (1L << (ISODOW - 128)) | (1L << (ISOYEAR - 128)) | (1L << (ISSTRICT - 128)) | (1L << (LANGUAGE - 128)) | (1L << (LARGE - 128)) | (1L << (LAST - 128)) | (1L << (LESS - 128)) | (1L << (LIST - 128)) | (1L << (LOCATION - 128)) | (1L << (MATCH - 128)) | (1L << (MAX - 128)) | (1L << (MAXVALUE - 128)) | (1L << (MICROSECONDS - 128)))) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (MILLENNIUM - 192)) | (1L << (MILLISECONDS - 192)) | (1L << (MIN - 192)) | (1L << (MINVALUE - 192)) | (1L << (MINUTE - 192)) | (1L << (MONTH - 192)) | (1L << (NATIONAL - 192)) | (1L << (NO - 192)) | (1L << (NONE - 192)) | (1L << (NULLIF - 192)) | (1L << (OBJECT - 192)) | (1L << (OPTION - 192)) | (1L << (OPTIONS - 192)) | (1L << (OVERWRITE - 192)) | (1L << (PARSER - 192)) | (1L << (PARTIAL - 192)) | (1L << (PARTITION - 192)) | (1L << (PARTITIONS - 192)) | (1L << (PRECISION - 192)) | (1L << (PUBLIC - 192)) | (1L << (PURGE - 192)) | (1L << (QUARTER - 192)) | (1L << (RANGE - 192)) | (1L << (REGEXP - 192)) | (1L << (RLIKE - 192)) | (1L << (ROLLUP - 192)) | (1L << (SEARCH - 192)) | (1L << (SECOND - 192)) | (1L << (SECURITY - 192)) | (1L << (SERVER - 192)) | (1L << (SET - 192)) | (1L << (SIMILAR - 192)) | (1L << (SIMPLE - 192)) | (1L << (STABLE - 192)) | (1L << (START - 192)) | (1L << (STORAGE - 192)) | (1L << (STDDEV_POP - 192)) | (1L << (STDDEV_SAMP - 192)) | (1L << (SUBPARTITION - 192)) | (1L << (SUM - 192)) | (1L << (TABLESPACE - 192)) | (1L << (TEMPLATE - 192)) | (1L << (THAN - 192)) | (1L << (TIMEZONE - 192)) | (1L << (TIMEZONE_HOUR - 192)) | (1L << (TIMEZONE_MINUTE - 192)) | (1L << (TRIM - 192)) | (1L << (TO - 192)) | (1L << (TYPE - 192)) | (1L << (UNKNOWN - 192)) | (1L << (UNLOGGED - 192)) | (1L << (VALUES - 192)) | (1L << (VAR_SAMP - 192)) | (1L << (VAR_POP - 192)) | (1L << (VARYING - 192)) | (1L << (VOLATILE - 192)) | (1L << (WEEK - 192)) | (1L << (WINDOW - 192)) | (1L << (WRAPPER - 192)) | (1L << (YEAR - 192)) | (1L << (ZONE - 192)) | (1L << (BOOLEAN - 192)))) != 0) || ((((_la - 256)) & ~0x3f) == 0 && ((1L << (_la - 256)) & ((1L << (BOOL - 256)) | (1L << (BIT - 256)) | (1L << (VARBIT - 256)) | (1L << (INT1 - 256)) | (1L << (INT2 - 256)) | (1L << (INT4 - 256)) | (1L << (INT8 - 256)) | (1L << (TINYINT - 256)) | (1L << (SMALLINT - 256)) | (1L << (INT - 256)) | (1L << (INTEGER - 256)) | (1L << (BIGINT - 256)) | (1L << (FLOAT4 - 256)) | (1L << (FLOAT8 - 256)) | (1L << (REAL - 256)) | (1L << (FLOAT - 256)) | (1L << (DOUBLE - 256)) | (1L << (NUMERIC - 256)) | (1L << (DECIMAL - 256)) | (1L << (CHAR - 256)) | (1L << (VARCHAR - 256)) | (1L << (NCHAR - 256)) | (1L << (NVARCHAR - 256)) | (1L << (DATE - 256)) | (1L << (TIME - 256)) | (1L << (TIMETZ - 256)) | (1L << (TIMESTAMP - 256)) | (1L << (TIMESTAMPTZ - 256)) | (1L << (TEXT - 256)) | (1L << (UUID - 256)) | (1L << (VARBINARY - 256)) | (1L << (BLOB - 256)) | (1L << (BYTEA - 256)) | (1L << (INET4 - 256)) | (1L << (DOUBLE_QUOTE - 256)))) != 0) || _la==Identifier );
				setState(860); revoke_from_cascade_restrict();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(862); match(REVOKE);
				setState(866);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(863); match(GRANT);
					setState(864); match(OPTION);
					setState(865); match(FOR);
					}
				}

				setState(873);
				switch (_input.LA(1)) {
				case EXECUTE:
					{
					setState(868); match(EXECUTE);
					}
					break;
				case ALL:
					{
					setState(869); match(ALL);
					setState(871);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(870); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(875); match(ON);
				setState(878);
				switch (_input.LA(1)) {
				case FUNCTION:
					{
					setState(876); function_definition();
					}
					break;
				case ALL:
					{
					setState(877); functions_definition_schema();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(880); revoke_from_cascade_restrict();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(882); match(REVOKE);
				setState(886);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(883); match(GRANT);
					setState(884); match(OPTION);
					setState(885); match(FOR);
					}
				}

				setState(893);
				switch (_input.LA(1)) {
				case USAGE:
					{
					setState(888); match(USAGE);
					}
					break;
				case ALL:
					{
					setState(889); match(ALL);
					setState(891);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(890); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(895); match(ON);
				setState(896); match(LANGUAGE);
				setState(901); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(897); ((Revoke_statementContext)_localctx).lang_name = identifier();
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
				} while ( ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (ADMIN - 128)) | (1L << (AVG - 128)) | (1L << (BETWEEN - 128)) | (1L << (BY - 128)) | (1L << (CACHE - 128)) | (1L << (CALLED - 128)) | (1L << (CLASS - 128)) | (1L << (CENTURY - 128)) | (1L << (CHARACTER - 128)) | (1L << (CHECK - 128)) | (1L << (COLLECT - 128)) | (1L << (COALESCE - 128)) | (1L << (COLUMN - 128)) | (1L << (COMMENT - 128)) | (1L << (COMMENTS - 128)) | (1L << (COMMIT - 128)) | (1L << (CONFIGURATION - 128)) | (1L << (COST - 128)) | (1L << (COUNT - 128)) | (1L << (CUBE - 128)) | (1L << (CURRENT - 128)) | (1L << (CYCLE - 128)) | (1L << (DATA - 128)) | (1L << (DAY - 128)) | (1L << (DEC - 128)) | (1L << (DECADE - 128)) | (1L << (DEFINER - 128)) | (1L << (DICTIONARY - 128)) | (1L << (DOW - 128)) | (1L << (DOY - 128)) | (1L << (DROP - 128)) | (1L << (EPOCH - 128)) | (1L << (EVERY - 128)) | (1L << (EXISTS - 128)) | (1L << (EXTERNAL - 128)) | (1L << (EXTRACT - 128)) | (1L << (FAMILY - 128)) | (1L << (FILTER - 128)) | (1L << (FIRST - 128)) | (1L << (FORMAT - 128)) | (1L << (FUSION - 128)) | (1L << (GROUPING - 128)) | (1L << (HASH - 128)) | (1L << (INDEX - 128)) | (1L << (INCREMENT - 128)) | (1L << (INPUT - 128)) | (1L << (INSERT - 128)) | (1L << (INTERSECTION - 128)) | (1L << (ISCACHABLE - 128)) | (1L << (ISODOW - 128)) | (1L << (ISOYEAR - 128)) | (1L << (ISSTRICT - 128)) | (1L << (LANGUAGE - 128)) | (1L << (LARGE - 128)) | (1L << (LAST - 128)) | (1L << (LESS - 128)) | (1L << (LIST - 128)) | (1L << (LOCATION - 128)) | (1L << (MATCH - 128)) | (1L << (MAX - 128)) | (1L << (MAXVALUE - 128)) | (1L << (MICROSECONDS - 128)))) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (MILLENNIUM - 192)) | (1L << (MILLISECONDS - 192)) | (1L << (MIN - 192)) | (1L << (MINVALUE - 192)) | (1L << (MINUTE - 192)) | (1L << (MONTH - 192)) | (1L << (NATIONAL - 192)) | (1L << (NO - 192)) | (1L << (NONE - 192)) | (1L << (NULLIF - 192)) | (1L << (OBJECT - 192)) | (1L << (OPTION - 192)) | (1L << (OPTIONS - 192)) | (1L << (OVERWRITE - 192)) | (1L << (PARSER - 192)) | (1L << (PARTIAL - 192)) | (1L << (PARTITION - 192)) | (1L << (PARTITIONS - 192)) | (1L << (PRECISION - 192)) | (1L << (PUBLIC - 192)) | (1L << (PURGE - 192)) | (1L << (QUARTER - 192)) | (1L << (RANGE - 192)) | (1L << (REGEXP - 192)) | (1L << (RLIKE - 192)) | (1L << (ROLLUP - 192)) | (1L << (SEARCH - 192)) | (1L << (SECOND - 192)) | (1L << (SECURITY - 192)) | (1L << (SERVER - 192)) | (1L << (SET - 192)) | (1L << (SIMILAR - 192)) | (1L << (SIMPLE - 192)) | (1L << (STABLE - 192)) | (1L << (START - 192)) | (1L << (STORAGE - 192)) | (1L << (STDDEV_POP - 192)) | (1L << (STDDEV_SAMP - 192)) | (1L << (SUBPARTITION - 192)) | (1L << (SUM - 192)) | (1L << (TABLESPACE - 192)) | (1L << (TEMPLATE - 192)) | (1L << (THAN - 192)) | (1L << (TIMEZONE - 192)) | (1L << (TIMEZONE_HOUR - 192)) | (1L << (TIMEZONE_MINUTE - 192)) | (1L << (TRIM - 192)) | (1L << (TO - 192)) | (1L << (TYPE - 192)) | (1L << (UNKNOWN - 192)) | (1L << (UNLOGGED - 192)) | (1L << (VALUES - 192)) | (1L << (VAR_SAMP - 192)) | (1L << (VAR_POP - 192)) | (1L << (VARYING - 192)) | (1L << (VOLATILE - 192)) | (1L << (WEEK - 192)) | (1L << (WINDOW - 192)) | (1L << (WRAPPER - 192)) | (1L << (YEAR - 192)) | (1L << (ZONE - 192)) | (1L << (BOOLEAN - 192)))) != 0) || ((((_la - 256)) & ~0x3f) == 0 && ((1L << (_la - 256)) & ((1L << (BOOL - 256)) | (1L << (BIT - 256)) | (1L << (VARBIT - 256)) | (1L << (INT1 - 256)) | (1L << (INT2 - 256)) | (1L << (INT4 - 256)) | (1L << (INT8 - 256)) | (1L << (TINYINT - 256)) | (1L << (SMALLINT - 256)) | (1L << (INT - 256)) | (1L << (INTEGER - 256)) | (1L << (BIGINT - 256)) | (1L << (FLOAT4 - 256)) | (1L << (FLOAT8 - 256)) | (1L << (REAL - 256)) | (1L << (FLOAT - 256)) | (1L << (DOUBLE - 256)) | (1L << (NUMERIC - 256)) | (1L << (DECIMAL - 256)) | (1L << (CHAR - 256)) | (1L << (VARCHAR - 256)) | (1L << (NCHAR - 256)) | (1L << (NVARCHAR - 256)) | (1L << (DATE - 256)) | (1L << (TIME - 256)) | (1L << (TIMETZ - 256)) | (1L << (TIMESTAMP - 256)) | (1L << (TIMESTAMPTZ - 256)) | (1L << (TEXT - 256)) | (1L << (UUID - 256)) | (1L << (VARBINARY - 256)) | (1L << (BLOB - 256)) | (1L << (BYTEA - 256)) | (1L << (INET4 - 256)) | (1L << (DOUBLE_QUOTE - 256)))) != 0) || _la==Identifier );
				setState(905); revoke_from_cascade_restrict();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(907); match(REVOKE);
				setState(911);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(908); match(GRANT);
					setState(909); match(OPTION);
					setState(910); match(FOR);
					}
				}

				setState(926);
				switch (_input.LA(1)) {
				case SELECT:
				case UPDATE:
					{
					setState(918); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						setState(918);
						switch (_input.LA(1)) {
						case SELECT:
							{
							setState(913); match(SELECT);
							}
							break;
						case UPDATE:
							{
							setState(914); match(UPDATE);
							setState(916);
							_la = _input.LA(1);
							if (_la==COMMA) {
								{
								setState(915); match(COMMA);
								}
							}

							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						setState(920); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==SELECT || _la==UPDATE );
					}
					break;
				case ALL:
					{
					setState(922); match(ALL);
					setState(924);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(923); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(928); match(ON);
				setState(929); match(LARGE);
				setState(930); match(OBJECT);
				setState(935); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(931); ((Revoke_statementContext)_localctx).loid = identifier();
					setState(933);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(932); match(COMMA);
						}
					}

					}
					}
					setState(937); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (ADMIN - 128)) | (1L << (AVG - 128)) | (1L << (BETWEEN - 128)) | (1L << (BY - 128)) | (1L << (CACHE - 128)) | (1L << (CALLED - 128)) | (1L << (CLASS - 128)) | (1L << (CENTURY - 128)) | (1L << (CHARACTER - 128)) | (1L << (CHECK - 128)) | (1L << (COLLECT - 128)) | (1L << (COALESCE - 128)) | (1L << (COLUMN - 128)) | (1L << (COMMENT - 128)) | (1L << (COMMENTS - 128)) | (1L << (COMMIT - 128)) | (1L << (CONFIGURATION - 128)) | (1L << (COST - 128)) | (1L << (COUNT - 128)) | (1L << (CUBE - 128)) | (1L << (CURRENT - 128)) | (1L << (CYCLE - 128)) | (1L << (DATA - 128)) | (1L << (DAY - 128)) | (1L << (DEC - 128)) | (1L << (DECADE - 128)) | (1L << (DEFINER - 128)) | (1L << (DICTIONARY - 128)) | (1L << (DOW - 128)) | (1L << (DOY - 128)) | (1L << (DROP - 128)) | (1L << (EPOCH - 128)) | (1L << (EVERY - 128)) | (1L << (EXISTS - 128)) | (1L << (EXTERNAL - 128)) | (1L << (EXTRACT - 128)) | (1L << (FAMILY - 128)) | (1L << (FILTER - 128)) | (1L << (FIRST - 128)) | (1L << (FORMAT - 128)) | (1L << (FUSION - 128)) | (1L << (GROUPING - 128)) | (1L << (HASH - 128)) | (1L << (INDEX - 128)) | (1L << (INCREMENT - 128)) | (1L << (INPUT - 128)) | (1L << (INSERT - 128)) | (1L << (INTERSECTION - 128)) | (1L << (ISCACHABLE - 128)) | (1L << (ISODOW - 128)) | (1L << (ISOYEAR - 128)) | (1L << (ISSTRICT - 128)) | (1L << (LANGUAGE - 128)) | (1L << (LARGE - 128)) | (1L << (LAST - 128)) | (1L << (LESS - 128)) | (1L << (LIST - 128)) | (1L << (LOCATION - 128)) | (1L << (MATCH - 128)) | (1L << (MAX - 128)) | (1L << (MAXVALUE - 128)) | (1L << (MICROSECONDS - 128)))) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (MILLENNIUM - 192)) | (1L << (MILLISECONDS - 192)) | (1L << (MIN - 192)) | (1L << (MINVALUE - 192)) | (1L << (MINUTE - 192)) | (1L << (MONTH - 192)) | (1L << (NATIONAL - 192)) | (1L << (NO - 192)) | (1L << (NONE - 192)) | (1L << (NULLIF - 192)) | (1L << (OBJECT - 192)) | (1L << (OPTION - 192)) | (1L << (OPTIONS - 192)) | (1L << (OVERWRITE - 192)) | (1L << (PARSER - 192)) | (1L << (PARTIAL - 192)) | (1L << (PARTITION - 192)) | (1L << (PARTITIONS - 192)) | (1L << (PRECISION - 192)) | (1L << (PUBLIC - 192)) | (1L << (PURGE - 192)) | (1L << (QUARTER - 192)) | (1L << (RANGE - 192)) | (1L << (REGEXP - 192)) | (1L << (RLIKE - 192)) | (1L << (ROLLUP - 192)) | (1L << (SEARCH - 192)) | (1L << (SECOND - 192)) | (1L << (SECURITY - 192)) | (1L << (SERVER - 192)) | (1L << (SET - 192)) | (1L << (SIMILAR - 192)) | (1L << (SIMPLE - 192)) | (1L << (STABLE - 192)) | (1L << (START - 192)) | (1L << (STORAGE - 192)) | (1L << (STDDEV_POP - 192)) | (1L << (STDDEV_SAMP - 192)) | (1L << (SUBPARTITION - 192)) | (1L << (SUM - 192)) | (1L << (TABLESPACE - 192)) | (1L << (TEMPLATE - 192)) | (1L << (THAN - 192)) | (1L << (TIMEZONE - 192)) | (1L << (TIMEZONE_HOUR - 192)) | (1L << (TIMEZONE_MINUTE - 192)) | (1L << (TRIM - 192)) | (1L << (TO - 192)) | (1L << (TYPE - 192)) | (1L << (UNKNOWN - 192)) | (1L << (UNLOGGED - 192)) | (1L << (VALUES - 192)) | (1L << (VAR_SAMP - 192)) | (1L << (VAR_POP - 192)) | (1L << (VARYING - 192)) | (1L << (VOLATILE - 192)) | (1L << (WEEK - 192)) | (1L << (WINDOW - 192)) | (1L << (WRAPPER - 192)) | (1L << (YEAR - 192)) | (1L << (ZONE - 192)) | (1L << (BOOLEAN - 192)))) != 0) || ((((_la - 256)) & ~0x3f) == 0 && ((1L << (_la - 256)) & ((1L << (BOOL - 256)) | (1L << (BIT - 256)) | (1L << (VARBIT - 256)) | (1L << (INT1 - 256)) | (1L << (INT2 - 256)) | (1L << (INT4 - 256)) | (1L << (INT8 - 256)) | (1L << (TINYINT - 256)) | (1L << (SMALLINT - 256)) | (1L << (INT - 256)) | (1L << (INTEGER - 256)) | (1L << (BIGINT - 256)) | (1L << (FLOAT4 - 256)) | (1L << (FLOAT8 - 256)) | (1L << (REAL - 256)) | (1L << (FLOAT - 256)) | (1L << (DOUBLE - 256)) | (1L << (NUMERIC - 256)) | (1L << (DECIMAL - 256)) | (1L << (CHAR - 256)) | (1L << (VARCHAR - 256)) | (1L << (NCHAR - 256)) | (1L << (NVARCHAR - 256)) | (1L << (DATE - 256)) | (1L << (TIME - 256)) | (1L << (TIMETZ - 256)) | (1L << (TIMESTAMP - 256)) | (1L << (TIMESTAMPTZ - 256)) | (1L << (TEXT - 256)) | (1L << (UUID - 256)) | (1L << (VARBINARY - 256)) | (1L << (BLOB - 256)) | (1L << (BYTEA - 256)) | (1L << (INET4 - 256)) | (1L << (DOUBLE_QUOTE - 256)))) != 0) || _la==Identifier );
				setState(939); revoke_from_cascade_restrict();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(941); match(REVOKE);
				setState(945);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(942); match(GRANT);
					setState(943); match(OPTION);
					setState(944); match(FOR);
					}
				}

				setState(959);
				switch (_input.LA(1)) {
				case CREATE:
				case USAGE:
					{
					setState(951); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(947);
						_la = _input.LA(1);
						if ( !(_la==CREATE || _la==USAGE) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(949);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(948); match(COMMA);
							}
						}

						}
						}
						setState(953); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==CREATE || _la==USAGE );
					}
					break;
				case ALL:
					{
					setState(955); match(ALL);
					setState(957);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(956); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(961); match(ON);
				setState(962); match(SCHEMA);
				setState(967); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(963); ((Revoke_statementContext)_localctx).schema_name = identifier();
					setState(965);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(964); match(COMMA);
						}
					}

					}
					}
					setState(969); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (ADMIN - 128)) | (1L << (AVG - 128)) | (1L << (BETWEEN - 128)) | (1L << (BY - 128)) | (1L << (CACHE - 128)) | (1L << (CALLED - 128)) | (1L << (CLASS - 128)) | (1L << (CENTURY - 128)) | (1L << (CHARACTER - 128)) | (1L << (CHECK - 128)) | (1L << (COLLECT - 128)) | (1L << (COALESCE - 128)) | (1L << (COLUMN - 128)) | (1L << (COMMENT - 128)) | (1L << (COMMENTS - 128)) | (1L << (COMMIT - 128)) | (1L << (CONFIGURATION - 128)) | (1L << (COST - 128)) | (1L << (COUNT - 128)) | (1L << (CUBE - 128)) | (1L << (CURRENT - 128)) | (1L << (CYCLE - 128)) | (1L << (DATA - 128)) | (1L << (DAY - 128)) | (1L << (DEC - 128)) | (1L << (DECADE - 128)) | (1L << (DEFINER - 128)) | (1L << (DICTIONARY - 128)) | (1L << (DOW - 128)) | (1L << (DOY - 128)) | (1L << (DROP - 128)) | (1L << (EPOCH - 128)) | (1L << (EVERY - 128)) | (1L << (EXISTS - 128)) | (1L << (EXTERNAL - 128)) | (1L << (EXTRACT - 128)) | (1L << (FAMILY - 128)) | (1L << (FILTER - 128)) | (1L << (FIRST - 128)) | (1L << (FORMAT - 128)) | (1L << (FUSION - 128)) | (1L << (GROUPING - 128)) | (1L << (HASH - 128)) | (1L << (INDEX - 128)) | (1L << (INCREMENT - 128)) | (1L << (INPUT - 128)) | (1L << (INSERT - 128)) | (1L << (INTERSECTION - 128)) | (1L << (ISCACHABLE - 128)) | (1L << (ISODOW - 128)) | (1L << (ISOYEAR - 128)) | (1L << (ISSTRICT - 128)) | (1L << (LANGUAGE - 128)) | (1L << (LARGE - 128)) | (1L << (LAST - 128)) | (1L << (LESS - 128)) | (1L << (LIST - 128)) | (1L << (LOCATION - 128)) | (1L << (MATCH - 128)) | (1L << (MAX - 128)) | (1L << (MAXVALUE - 128)) | (1L << (MICROSECONDS - 128)))) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (MILLENNIUM - 192)) | (1L << (MILLISECONDS - 192)) | (1L << (MIN - 192)) | (1L << (MINVALUE - 192)) | (1L << (MINUTE - 192)) | (1L << (MONTH - 192)) | (1L << (NATIONAL - 192)) | (1L << (NO - 192)) | (1L << (NONE - 192)) | (1L << (NULLIF - 192)) | (1L << (OBJECT - 192)) | (1L << (OPTION - 192)) | (1L << (OPTIONS - 192)) | (1L << (OVERWRITE - 192)) | (1L << (PARSER - 192)) | (1L << (PARTIAL - 192)) | (1L << (PARTITION - 192)) | (1L << (PARTITIONS - 192)) | (1L << (PRECISION - 192)) | (1L << (PUBLIC - 192)) | (1L << (PURGE - 192)) | (1L << (QUARTER - 192)) | (1L << (RANGE - 192)) | (1L << (REGEXP - 192)) | (1L << (RLIKE - 192)) | (1L << (ROLLUP - 192)) | (1L << (SEARCH - 192)) | (1L << (SECOND - 192)) | (1L << (SECURITY - 192)) | (1L << (SERVER - 192)) | (1L << (SET - 192)) | (1L << (SIMILAR - 192)) | (1L << (SIMPLE - 192)) | (1L << (STABLE - 192)) | (1L << (START - 192)) | (1L << (STORAGE - 192)) | (1L << (STDDEV_POP - 192)) | (1L << (STDDEV_SAMP - 192)) | (1L << (SUBPARTITION - 192)) | (1L << (SUM - 192)) | (1L << (TABLESPACE - 192)) | (1L << (TEMPLATE - 192)) | (1L << (THAN - 192)) | (1L << (TIMEZONE - 192)) | (1L << (TIMEZONE_HOUR - 192)) | (1L << (TIMEZONE_MINUTE - 192)) | (1L << (TRIM - 192)) | (1L << (TO - 192)) | (1L << (TYPE - 192)) | (1L << (UNKNOWN - 192)) | (1L << (UNLOGGED - 192)) | (1L << (VALUES - 192)) | (1L << (VAR_SAMP - 192)) | (1L << (VAR_POP - 192)) | (1L << (VARYING - 192)) | (1L << (VOLATILE - 192)) | (1L << (WEEK - 192)) | (1L << (WINDOW - 192)) | (1L << (WRAPPER - 192)) | (1L << (YEAR - 192)) | (1L << (ZONE - 192)) | (1L << (BOOLEAN - 192)))) != 0) || ((((_la - 256)) & ~0x3f) == 0 && ((1L << (_la - 256)) & ((1L << (BOOL - 256)) | (1L << (BIT - 256)) | (1L << (VARBIT - 256)) | (1L << (INT1 - 256)) | (1L << (INT2 - 256)) | (1L << (INT4 - 256)) | (1L << (INT8 - 256)) | (1L << (TINYINT - 256)) | (1L << (SMALLINT - 256)) | (1L << (INT - 256)) | (1L << (INTEGER - 256)) | (1L << (BIGINT - 256)) | (1L << (FLOAT4 - 256)) | (1L << (FLOAT8 - 256)) | (1L << (REAL - 256)) | (1L << (FLOAT - 256)) | (1L << (DOUBLE - 256)) | (1L << (NUMERIC - 256)) | (1L << (DECIMAL - 256)) | (1L << (CHAR - 256)) | (1L << (VARCHAR - 256)) | (1L << (NCHAR - 256)) | (1L << (NVARCHAR - 256)) | (1L << (DATE - 256)) | (1L << (TIME - 256)) | (1L << (TIMETZ - 256)) | (1L << (TIMESTAMP - 256)) | (1L << (TIMESTAMPTZ - 256)) | (1L << (TEXT - 256)) | (1L << (UUID - 256)) | (1L << (VARBINARY - 256)) | (1L << (BLOB - 256)) | (1L << (BYTEA - 256)) | (1L << (INET4 - 256)) | (1L << (DOUBLE_QUOTE - 256)))) != 0) || _la==Identifier );
				setState(971); revoke_from_cascade_restrict();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(973); match(REVOKE);
				setState(977);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(974); match(GRANT);
					setState(975); match(OPTION);
					setState(976); match(FOR);
					}
				}

				setState(984);
				switch (_input.LA(1)) {
				case CREATE:
					{
					setState(979); match(CREATE);
					}
					break;
				case ALL:
					{
					setState(980); match(ALL);
					setState(982);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(981); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(986); match(ON);
				setState(987); match(TABLESPACE);
				setState(992); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(988); ((Revoke_statementContext)_localctx).tablespace_name = identifier();
					setState(990);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(989); match(COMMA);
						}
					}

					}
					}
					setState(994); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (ADMIN - 128)) | (1L << (AVG - 128)) | (1L << (BETWEEN - 128)) | (1L << (BY - 128)) | (1L << (CACHE - 128)) | (1L << (CALLED - 128)) | (1L << (CLASS - 128)) | (1L << (CENTURY - 128)) | (1L << (CHARACTER - 128)) | (1L << (CHECK - 128)) | (1L << (COLLECT - 128)) | (1L << (COALESCE - 128)) | (1L << (COLUMN - 128)) | (1L << (COMMENT - 128)) | (1L << (COMMENTS - 128)) | (1L << (COMMIT - 128)) | (1L << (CONFIGURATION - 128)) | (1L << (COST - 128)) | (1L << (COUNT - 128)) | (1L << (CUBE - 128)) | (1L << (CURRENT - 128)) | (1L << (CYCLE - 128)) | (1L << (DATA - 128)) | (1L << (DAY - 128)) | (1L << (DEC - 128)) | (1L << (DECADE - 128)) | (1L << (DEFINER - 128)) | (1L << (DICTIONARY - 128)) | (1L << (DOW - 128)) | (1L << (DOY - 128)) | (1L << (DROP - 128)) | (1L << (EPOCH - 128)) | (1L << (EVERY - 128)) | (1L << (EXISTS - 128)) | (1L << (EXTERNAL - 128)) | (1L << (EXTRACT - 128)) | (1L << (FAMILY - 128)) | (1L << (FILTER - 128)) | (1L << (FIRST - 128)) | (1L << (FORMAT - 128)) | (1L << (FUSION - 128)) | (1L << (GROUPING - 128)) | (1L << (HASH - 128)) | (1L << (INDEX - 128)) | (1L << (INCREMENT - 128)) | (1L << (INPUT - 128)) | (1L << (INSERT - 128)) | (1L << (INTERSECTION - 128)) | (1L << (ISCACHABLE - 128)) | (1L << (ISODOW - 128)) | (1L << (ISOYEAR - 128)) | (1L << (ISSTRICT - 128)) | (1L << (LANGUAGE - 128)) | (1L << (LARGE - 128)) | (1L << (LAST - 128)) | (1L << (LESS - 128)) | (1L << (LIST - 128)) | (1L << (LOCATION - 128)) | (1L << (MATCH - 128)) | (1L << (MAX - 128)) | (1L << (MAXVALUE - 128)) | (1L << (MICROSECONDS - 128)))) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (MILLENNIUM - 192)) | (1L << (MILLISECONDS - 192)) | (1L << (MIN - 192)) | (1L << (MINVALUE - 192)) | (1L << (MINUTE - 192)) | (1L << (MONTH - 192)) | (1L << (NATIONAL - 192)) | (1L << (NO - 192)) | (1L << (NONE - 192)) | (1L << (NULLIF - 192)) | (1L << (OBJECT - 192)) | (1L << (OPTION - 192)) | (1L << (OPTIONS - 192)) | (1L << (OVERWRITE - 192)) | (1L << (PARSER - 192)) | (1L << (PARTIAL - 192)) | (1L << (PARTITION - 192)) | (1L << (PARTITIONS - 192)) | (1L << (PRECISION - 192)) | (1L << (PUBLIC - 192)) | (1L << (PURGE - 192)) | (1L << (QUARTER - 192)) | (1L << (RANGE - 192)) | (1L << (REGEXP - 192)) | (1L << (RLIKE - 192)) | (1L << (ROLLUP - 192)) | (1L << (SEARCH - 192)) | (1L << (SECOND - 192)) | (1L << (SECURITY - 192)) | (1L << (SERVER - 192)) | (1L << (SET - 192)) | (1L << (SIMILAR - 192)) | (1L << (SIMPLE - 192)) | (1L << (STABLE - 192)) | (1L << (START - 192)) | (1L << (STORAGE - 192)) | (1L << (STDDEV_POP - 192)) | (1L << (STDDEV_SAMP - 192)) | (1L << (SUBPARTITION - 192)) | (1L << (SUM - 192)) | (1L << (TABLESPACE - 192)) | (1L << (TEMPLATE - 192)) | (1L << (THAN - 192)) | (1L << (TIMEZONE - 192)) | (1L << (TIMEZONE_HOUR - 192)) | (1L << (TIMEZONE_MINUTE - 192)) | (1L << (TRIM - 192)) | (1L << (TO - 192)) | (1L << (TYPE - 192)) | (1L << (UNKNOWN - 192)) | (1L << (UNLOGGED - 192)) | (1L << (VALUES - 192)) | (1L << (VAR_SAMP - 192)) | (1L << (VAR_POP - 192)) | (1L << (VARYING - 192)) | (1L << (VOLATILE - 192)) | (1L << (WEEK - 192)) | (1L << (WINDOW - 192)) | (1L << (WRAPPER - 192)) | (1L << (YEAR - 192)) | (1L << (ZONE - 192)) | (1L << (BOOLEAN - 192)))) != 0) || ((((_la - 256)) & ~0x3f) == 0 && ((1L << (_la - 256)) & ((1L << (BOOL - 256)) | (1L << (BIT - 256)) | (1L << (VARBIT - 256)) | (1L << (INT1 - 256)) | (1L << (INT2 - 256)) | (1L << (INT4 - 256)) | (1L << (INT8 - 256)) | (1L << (TINYINT - 256)) | (1L << (SMALLINT - 256)) | (1L << (INT - 256)) | (1L << (INTEGER - 256)) | (1L << (BIGINT - 256)) | (1L << (FLOAT4 - 256)) | (1L << (FLOAT8 - 256)) | (1L << (REAL - 256)) | (1L << (FLOAT - 256)) | (1L << (DOUBLE - 256)) | (1L << (NUMERIC - 256)) | (1L << (DECIMAL - 256)) | (1L << (CHAR - 256)) | (1L << (VARCHAR - 256)) | (1L << (NCHAR - 256)) | (1L << (NVARCHAR - 256)) | (1L << (DATE - 256)) | (1L << (TIME - 256)) | (1L << (TIMETZ - 256)) | (1L << (TIMESTAMP - 256)) | (1L << (TIMESTAMPTZ - 256)) | (1L << (TEXT - 256)) | (1L << (UUID - 256)) | (1L << (VARBINARY - 256)) | (1L << (BLOB - 256)) | (1L << (BYTEA - 256)) | (1L << (INET4 - 256)) | (1L << (DOUBLE_QUOTE - 256)))) != 0) || _la==Identifier );
				setState(996); revoke_from_cascade_restrict();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(998); match(REVOKE);
				setState(1002);
				switch ( getInterpreter().adaptivePredict(_input,108,_ctx) ) {
				case 1:
					{
					setState(999); match(ADMIN);
					setState(1000); match(OPTION);
					setState(1001); match(FOR);
					}
					break;
				}
				setState(1008); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1004); ((Revoke_statementContext)_localctx).role_name = identifier();
					setState(1006);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1005); match(COMMA);
						}
					}

					}
					}
					setState(1010); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (ADMIN - 128)) | (1L << (AVG - 128)) | (1L << (BETWEEN - 128)) | (1L << (BY - 128)) | (1L << (CACHE - 128)) | (1L << (CALLED - 128)) | (1L << (CLASS - 128)) | (1L << (CENTURY - 128)) | (1L << (CHARACTER - 128)) | (1L << (CHECK - 128)) | (1L << (COLLECT - 128)) | (1L << (COALESCE - 128)) | (1L << (COLUMN - 128)) | (1L << (COMMENT - 128)) | (1L << (COMMENTS - 128)) | (1L << (COMMIT - 128)) | (1L << (CONFIGURATION - 128)) | (1L << (COST - 128)) | (1L << (COUNT - 128)) | (1L << (CUBE - 128)) | (1L << (CURRENT - 128)) | (1L << (CYCLE - 128)) | (1L << (DATA - 128)) | (1L << (DAY - 128)) | (1L << (DEC - 128)) | (1L << (DECADE - 128)) | (1L << (DEFINER - 128)) | (1L << (DICTIONARY - 128)) | (1L << (DOW - 128)) | (1L << (DOY - 128)) | (1L << (DROP - 128)) | (1L << (EPOCH - 128)) | (1L << (EVERY - 128)) | (1L << (EXISTS - 128)) | (1L << (EXTERNAL - 128)) | (1L << (EXTRACT - 128)) | (1L << (FAMILY - 128)) | (1L << (FILTER - 128)) | (1L << (FIRST - 128)) | (1L << (FORMAT - 128)) | (1L << (FUSION - 128)) | (1L << (GROUPING - 128)) | (1L << (HASH - 128)) | (1L << (INDEX - 128)) | (1L << (INCREMENT - 128)) | (1L << (INPUT - 128)) | (1L << (INSERT - 128)) | (1L << (INTERSECTION - 128)) | (1L << (ISCACHABLE - 128)) | (1L << (ISODOW - 128)) | (1L << (ISOYEAR - 128)) | (1L << (ISSTRICT - 128)) | (1L << (LANGUAGE - 128)) | (1L << (LARGE - 128)) | (1L << (LAST - 128)) | (1L << (LESS - 128)) | (1L << (LIST - 128)) | (1L << (LOCATION - 128)) | (1L << (MATCH - 128)) | (1L << (MAX - 128)) | (1L << (MAXVALUE - 128)) | (1L << (MICROSECONDS - 128)))) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (MILLENNIUM - 192)) | (1L << (MILLISECONDS - 192)) | (1L << (MIN - 192)) | (1L << (MINVALUE - 192)) | (1L << (MINUTE - 192)) | (1L << (MONTH - 192)) | (1L << (NATIONAL - 192)) | (1L << (NO - 192)) | (1L << (NONE - 192)) | (1L << (NULLIF - 192)) | (1L << (OBJECT - 192)) | (1L << (OPTION - 192)) | (1L << (OPTIONS - 192)) | (1L << (OVERWRITE - 192)) | (1L << (PARSER - 192)) | (1L << (PARTIAL - 192)) | (1L << (PARTITION - 192)) | (1L << (PARTITIONS - 192)) | (1L << (PRECISION - 192)) | (1L << (PUBLIC - 192)) | (1L << (PURGE - 192)) | (1L << (QUARTER - 192)) | (1L << (RANGE - 192)) | (1L << (REGEXP - 192)) | (1L << (RLIKE - 192)) | (1L << (ROLLUP - 192)) | (1L << (SEARCH - 192)) | (1L << (SECOND - 192)) | (1L << (SECURITY - 192)) | (1L << (SERVER - 192)) | (1L << (SET - 192)) | (1L << (SIMILAR - 192)) | (1L << (SIMPLE - 192)) | (1L << (STABLE - 192)) | (1L << (START - 192)) | (1L << (STORAGE - 192)) | (1L << (STDDEV_POP - 192)) | (1L << (STDDEV_SAMP - 192)) | (1L << (SUBPARTITION - 192)) | (1L << (SUM - 192)) | (1L << (TABLESPACE - 192)) | (1L << (TEMPLATE - 192)) | (1L << (THAN - 192)) | (1L << (TIMEZONE - 192)) | (1L << (TIMEZONE_HOUR - 192)) | (1L << (TIMEZONE_MINUTE - 192)) | (1L << (TRIM - 192)) | (1L << (TO - 192)) | (1L << (TYPE - 192)) | (1L << (UNKNOWN - 192)) | (1L << (UNLOGGED - 192)) | (1L << (VALUES - 192)) | (1L << (VAR_SAMP - 192)) | (1L << (VAR_POP - 192)) | (1L << (VARYING - 192)) | (1L << (VOLATILE - 192)) | (1L << (WEEK - 192)) | (1L << (WINDOW - 192)) | (1L << (WRAPPER - 192)) | (1L << (YEAR - 192)) | (1L << (ZONE - 192)) | (1L << (BOOLEAN - 192)))) != 0) || ((((_la - 256)) & ~0x3f) == 0 && ((1L << (_la - 256)) & ((1L << (BOOL - 256)) | (1L << (BIT - 256)) | (1L << (VARBIT - 256)) | (1L << (INT1 - 256)) | (1L << (INT2 - 256)) | (1L << (INT4 - 256)) | (1L << (INT8 - 256)) | (1L << (TINYINT - 256)) | (1L << (SMALLINT - 256)) | (1L << (INT - 256)) | (1L << (INTEGER - 256)) | (1L << (BIGINT - 256)) | (1L << (FLOAT4 - 256)) | (1L << (FLOAT8 - 256)) | (1L << (REAL - 256)) | (1L << (FLOAT - 256)) | (1L << (DOUBLE - 256)) | (1L << (NUMERIC - 256)) | (1L << (DECIMAL - 256)) | (1L << (CHAR - 256)) | (1L << (VARCHAR - 256)) | (1L << (NCHAR - 256)) | (1L << (NVARCHAR - 256)) | (1L << (DATE - 256)) | (1L << (TIME - 256)) | (1L << (TIMETZ - 256)) | (1L << (TIMESTAMP - 256)) | (1L << (TIMESTAMPTZ - 256)) | (1L << (TEXT - 256)) | (1L << (UUID - 256)) | (1L << (VARBINARY - 256)) | (1L << (BLOB - 256)) | (1L << (BYTEA - 256)) | (1L << (INET4 - 256)) | (1L << (DOUBLE_QUOTE - 256)))) != 0) || _la==Identifier );
				setState(1012); match(FROM);
				setState(1017); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1013); ((Revoke_statementContext)_localctx).role_name = identifier();
						setState(1015);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1014); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1019); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,112,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1022);
				_la = _input.LA(1);
				if (_la==CASCADE || _la==RESTRICT) {
					{
					setState(1021);
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
			setState(1026); match(FROM);
			setState(1035); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(1035);
					switch ( getInterpreter().adaptivePredict(_input,117,_ctx) ) {
					case 1:
						{
						setState(1028);
						_la = _input.LA(1);
						if (_la==GROUP) {
							{
							setState(1027); match(GROUP);
							}
						}

						setState(1030); ((Revoke_from_cascade_restrictContext)_localctx).role_name = identifier();
						}
						break;
					case 2:
						{
						setState(1031); match(PUBLIC);
						setState(1033);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1032); match(COMMA);
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
				setState(1037); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,118,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(1040);
			_la = _input.LA(1);
			if (_la==CASCADE || _la==RESTRICT) {
				{
				setState(1039);
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
			setState(1367);
			switch ( getInterpreter().adaptivePredict(_input,190,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1042); match(GRANT);
				setState(1052);
				switch (_input.LA(1)) {
				case DELETE:
				case REFERENCES:
				case SELECT:
				case TRIGGER:
				case TRUNCATE:
				case UPDATE:
				case INSERT:
					{
					setState(1044); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1043);
						_la = _input.LA(1);
						if ( !(_la==DELETE || ((((_la - 93)) & ~0x3f) == 0 && ((1L << (_la - 93)) & ((1L << (REFERENCES - 93)) | (1L << (SELECT - 93)) | (1L << (TRIGGER - 93)) | (1L << (TRUNCATE - 93)) | (1L << (UPDATE - 93)))) != 0) || _la==INSERT) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
						}
						setState(1046); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==DELETE || ((((_la - 93)) & ~0x3f) == 0 && ((1L << (_la - 93)) & ((1L << (REFERENCES - 93)) | (1L << (SELECT - 93)) | (1L << (TRIGGER - 93)) | (1L << (TRUNCATE - 93)) | (1L << (UPDATE - 93)))) != 0) || _la==INSERT );
					}
					break;
				case ALL:
					{
					setState(1048); match(ALL);
					setState(1050);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1049); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1054); match(ON);
				setState(1078);
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
				case DOUBLE_QUOTE:
				case Identifier:
					{
					{
					setState(1056);
					_la = _input.LA(1);
					if (_la==TABLE) {
						{
						setState(1055); match(TABLE);
						}
					}

					setState(1062); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(1058); ((Grant_statementContext)_localctx).tabl_name = schema_qualified_name();
							setState(1060);
							_la = _input.LA(1);
							if (_la==COMMA) {
								{
								setState(1059); match(COMMA);
								}
							}

							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(1064); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,125,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					}
					}
					break;
				case ALL:
					{
					{
					setState(1066); match(ALL);
					setState(1067); match(TABLES);
					setState(1068); match(IN);
					setState(1069); match(SCHEMA);
					setState(1074); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(1070); ((Grant_statementContext)_localctx).schem_name = identifier();
							setState(1072);
							_la = _input.LA(1);
							if (_la==COMMA) {
								{
								setState(1071); match(COMMA);
								}
							}

							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(1076); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,127,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1080); grant_to_rule();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1082); match(GRANT);
				setState(1108);
				switch (_input.LA(1)) {
				case REFERENCES:
				case SELECT:
				case UPDATE:
				case INSERT:
					{
					setState(1092); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1083);
						_la = _input.LA(1);
						if ( !(((((_la - 93)) & ~0x3f) == 0 && ((1L << (_la - 93)) & ((1L << (REFERENCES - 93)) | (1L << (SELECT - 93)) | (1L << (UPDATE - 93)))) != 0) || _la==INSERT) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(1088); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(1084); ((Grant_statementContext)_localctx).column = identifier();
								setState(1086);
								_la = _input.LA(1);
								if (_la==COMMA) {
									{
									setState(1085); match(COMMA);
									}
								}

								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(1090); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,130,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						}
						}
						setState(1094); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 93)) & ~0x3f) == 0 && ((1L << (_la - 93)) & ((1L << (REFERENCES - 93)) | (1L << (SELECT - 93)) | (1L << (UPDATE - 93)))) != 0) || _la==INSERT );
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

					setState(1104); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1100); ((Grant_statementContext)_localctx).column = identifier();
						setState(1102);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1101); match(COMMA);
							}
						}

						}
						}
						setState(1106); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (ADMIN - 128)) | (1L << (AVG - 128)) | (1L << (BETWEEN - 128)) | (1L << (BY - 128)) | (1L << (CACHE - 128)) | (1L << (CALLED - 128)) | (1L << (CLASS - 128)) | (1L << (CENTURY - 128)) | (1L << (CHARACTER - 128)) | (1L << (CHECK - 128)) | (1L << (COLLECT - 128)) | (1L << (COALESCE - 128)) | (1L << (COLUMN - 128)) | (1L << (COMMENT - 128)) | (1L << (COMMENTS - 128)) | (1L << (COMMIT - 128)) | (1L << (CONFIGURATION - 128)) | (1L << (COST - 128)) | (1L << (COUNT - 128)) | (1L << (CUBE - 128)) | (1L << (CURRENT - 128)) | (1L << (CYCLE - 128)) | (1L << (DATA - 128)) | (1L << (DAY - 128)) | (1L << (DEC - 128)) | (1L << (DECADE - 128)) | (1L << (DEFINER - 128)) | (1L << (DICTIONARY - 128)) | (1L << (DOW - 128)) | (1L << (DOY - 128)) | (1L << (DROP - 128)) | (1L << (EPOCH - 128)) | (1L << (EVERY - 128)) | (1L << (EXISTS - 128)) | (1L << (EXTERNAL - 128)) | (1L << (EXTRACT - 128)) | (1L << (FAMILY - 128)) | (1L << (FILTER - 128)) | (1L << (FIRST - 128)) | (1L << (FORMAT - 128)) | (1L << (FUSION - 128)) | (1L << (GROUPING - 128)) | (1L << (HASH - 128)) | (1L << (INDEX - 128)) | (1L << (INCREMENT - 128)) | (1L << (INPUT - 128)) | (1L << (INSERT - 128)) | (1L << (INTERSECTION - 128)) | (1L << (ISCACHABLE - 128)) | (1L << (ISODOW - 128)) | (1L << (ISOYEAR - 128)) | (1L << (ISSTRICT - 128)) | (1L << (LANGUAGE - 128)) | (1L << (LARGE - 128)) | (1L << (LAST - 128)) | (1L << (LESS - 128)) | (1L << (LIST - 128)) | (1L << (LOCATION - 128)) | (1L << (MATCH - 128)) | (1L << (MAX - 128)) | (1L << (MAXVALUE - 128)) | (1L << (MICROSECONDS - 128)))) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (MILLENNIUM - 192)) | (1L << (MILLISECONDS - 192)) | (1L << (MIN - 192)) | (1L << (MINVALUE - 192)) | (1L << (MINUTE - 192)) | (1L << (MONTH - 192)) | (1L << (NATIONAL - 192)) | (1L << (NO - 192)) | (1L << (NONE - 192)) | (1L << (NULLIF - 192)) | (1L << (OBJECT - 192)) | (1L << (OPTION - 192)) | (1L << (OPTIONS - 192)) | (1L << (OVERWRITE - 192)) | (1L << (PARSER - 192)) | (1L << (PARTIAL - 192)) | (1L << (PARTITION - 192)) | (1L << (PARTITIONS - 192)) | (1L << (PRECISION - 192)) | (1L << (PUBLIC - 192)) | (1L << (PURGE - 192)) | (1L << (QUARTER - 192)) | (1L << (RANGE - 192)) | (1L << (REGEXP - 192)) | (1L << (RLIKE - 192)) | (1L << (ROLLUP - 192)) | (1L << (SEARCH - 192)) | (1L << (SECOND - 192)) | (1L << (SECURITY - 192)) | (1L << (SERVER - 192)) | (1L << (SET - 192)) | (1L << (SIMILAR - 192)) | (1L << (SIMPLE - 192)) | (1L << (STABLE - 192)) | (1L << (START - 192)) | (1L << (STORAGE - 192)) | (1L << (STDDEV_POP - 192)) | (1L << (STDDEV_SAMP - 192)) | (1L << (SUBPARTITION - 192)) | (1L << (SUM - 192)) | (1L << (TABLESPACE - 192)) | (1L << (TEMPLATE - 192)) | (1L << (THAN - 192)) | (1L << (TIMEZONE - 192)) | (1L << (TIMEZONE_HOUR - 192)) | (1L << (TIMEZONE_MINUTE - 192)) | (1L << (TRIM - 192)) | (1L << (TO - 192)) | (1L << (TYPE - 192)) | (1L << (UNKNOWN - 192)) | (1L << (UNLOGGED - 192)) | (1L << (VALUES - 192)) | (1L << (VAR_SAMP - 192)) | (1L << (VAR_POP - 192)) | (1L << (VARYING - 192)) | (1L << (VOLATILE - 192)) | (1L << (WEEK - 192)) | (1L << (WINDOW - 192)) | (1L << (WRAPPER - 192)) | (1L << (YEAR - 192)) | (1L << (ZONE - 192)) | (1L << (BOOLEAN - 192)))) != 0) || ((((_la - 256)) & ~0x3f) == 0 && ((1L << (_la - 256)) & ((1L << (BOOL - 256)) | (1L << (BIT - 256)) | (1L << (VARBIT - 256)) | (1L << (INT1 - 256)) | (1L << (INT2 - 256)) | (1L << (INT4 - 256)) | (1L << (INT8 - 256)) | (1L << (TINYINT - 256)) | (1L << (SMALLINT - 256)) | (1L << (INT - 256)) | (1L << (INTEGER - 256)) | (1L << (BIGINT - 256)) | (1L << (FLOAT4 - 256)) | (1L << (FLOAT8 - 256)) | (1L << (REAL - 256)) | (1L << (FLOAT - 256)) | (1L << (DOUBLE - 256)) | (1L << (NUMERIC - 256)) | (1L << (DECIMAL - 256)) | (1L << (CHAR - 256)) | (1L << (VARCHAR - 256)) | (1L << (NCHAR - 256)) | (1L << (NVARCHAR - 256)) | (1L << (DATE - 256)) | (1L << (TIME - 256)) | (1L << (TIMETZ - 256)) | (1L << (TIMESTAMP - 256)) | (1L << (TIMESTAMPTZ - 256)) | (1L << (TEXT - 256)) | (1L << (UUID - 256)) | (1L << (VARBINARY - 256)) | (1L << (BLOB - 256)) | (1L << (BYTEA - 256)) | (1L << (INET4 - 256)) | (1L << (DOUBLE_QUOTE - 256)))) != 0) || _la==Identifier );
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1110); match(ON);
				setState(1118); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1112);
						_la = _input.LA(1);
						if (_la==TABLE) {
							{
							setState(1111); match(TABLE);
							}
						}

						setState(1114); ((Grant_statementContext)_localctx).tabl_name = schema_qualified_name();
						setState(1116);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1115); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1120); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,138,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1122); grant_to_rule();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1124); match(GRANT);
				setState(1137);
				switch (_input.LA(1)) {
				case SELECT:
				case UPDATE:
				case USAGE:
					{
					setState(1129); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1125);
						_la = _input.LA(1);
						if ( !(((((_la - 103)) & ~0x3f) == 0 && ((1L << (_la - 103)) & ((1L << (SELECT - 103)) | (1L << (UPDATE - 103)) | (1L << (USAGE - 103)))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(1127);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1126); match(COMMA);
							}
						}

						}
						}
						setState(1131); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 103)) & ~0x3f) == 0 && ((1L << (_la - 103)) & ((1L << (SELECT - 103)) | (1L << (UPDATE - 103)) | (1L << (USAGE - 103)))) != 0) );
					}
					break;
				case ALL:
					{
					setState(1133); match(ALL);
					setState(1135);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1134); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1139); match(ON);
				setState(1161);
				switch (_input.LA(1)) {
				case SEQUENCE:
					{
					setState(1145); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1140); match(SEQUENCE);
						setState(1141); ((Grant_statementContext)_localctx).sequence_name = identifier();
						setState(1143);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1142); match(COMMA);
							}
						}

						}
						}
						setState(1147); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==SEQUENCE );
					}
					break;
				case ALL:
					{
					setState(1149); match(ALL);
					setState(1150); match(SEQUENCES);
					setState(1151); match(IN);
					setState(1152); match(SCHEMA);
					setState(1157); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(1153); ((Grant_statementContext)_localctx).schema_name = identifier();
							setState(1155);
							_la = _input.LA(1);
							if (_la==COMMA) {
								{
								setState(1154); match(COMMA);
								}
							}

							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(1159); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,146,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1163); grant_to_rule();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1165); match(GRANT);
				setState(1178);
				switch (_input.LA(1)) {
				case CONNECT:
				case CREATE:
				case TEMP:
				case TEMPORARY:
					{
					setState(1170); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1166);
						_la = _input.LA(1);
						if ( !(_la==CONNECT || _la==CREATE || _la==TEMP || _la==TEMPORARY) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(1168);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1167); match(COMMA);
							}
						}

						}
						}
						setState(1172); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==CONNECT || _la==CREATE || _la==TEMP || _la==TEMPORARY );
					}
					break;
				case ALL:
					{
					setState(1174); match(ALL);
					setState(1176);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1175); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1180); match(ON);
				setState(1181); match(DATABASE);
				setState(1186); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1182); ((Grant_statementContext)_localctx).database_name = identifier();
						setState(1184);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1183); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1188); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,153,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1190); grant_to_rule();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1192); match(GRANT);
				setState(1198);
				switch (_input.LA(1)) {
				case USAGE:
					{
					setState(1193); match(USAGE);
					}
					break;
				case ALL:
					{
					setState(1194); match(ALL);
					setState(1196);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1195); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1200); match(ON);
				setState(1201); match(FOREIGN);
				setState(1202); match(DATA);
				setState(1203); match(WRAPPER);
				setState(1208); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1204); ((Grant_statementContext)_localctx).fdw_name = identifier();
						setState(1206);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1205); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1210); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,157,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1212); grant_to_rule();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1214); match(GRANT);
				setState(1220);
				switch (_input.LA(1)) {
				case USAGE:
					{
					setState(1215); match(USAGE);
					}
					break;
				case ALL:
					{
					setState(1216); match(ALL);
					setState(1218);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1217); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1222); match(ON);
				setState(1223); match(FOREIGN);
				setState(1224); match(SERVER);
				setState(1229); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1225); ((Grant_statementContext)_localctx).server_name = identifier();
						setState(1227);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1226); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1231); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,161,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1233); grant_to_rule();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1235); match(GRANT);
				setState(1241);
				switch (_input.LA(1)) {
				case EXECUTE:
					{
					setState(1236); match(EXECUTE);
					}
					break;
				case ALL:
					{
					setState(1237); match(ALL);
					setState(1239);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1238); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1243); match(ON);
				setState(1246);
				switch (_input.LA(1)) {
				case FUNCTION:
					{
					setState(1244); function_definition();
					}
					break;
				case ALL:
					{
					setState(1245); functions_definition_schema();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1248); grant_to_rule();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(1250); match(GRANT);
				setState(1256);
				switch (_input.LA(1)) {
				case USAGE:
					{
					setState(1251); match(USAGE);
					}
					break;
				case ALL:
					{
					setState(1252); match(ALL);
					setState(1254);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1253); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1258); match(ON);
				setState(1259); match(LANGUAGE);
				setState(1264); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1260); ((Grant_statementContext)_localctx).lang_name = identifier();
						setState(1262);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1261); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1266); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,168,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1268); grant_to_rule();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(1270); match(GRANT);
				setState(1283);
				switch (_input.LA(1)) {
				case SELECT:
				case UPDATE:
					{
					setState(1275); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1271);
						_la = _input.LA(1);
						if ( !(_la==SELECT || _la==UPDATE) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(1273);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1272); match(COMMA);
							}
						}

						}
						}
						setState(1277); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==SELECT || _la==UPDATE );
					}
					break;
				case ALL:
					{
					setState(1279); match(ALL);
					setState(1281);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1280); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1285); match(ON);
				setState(1286); match(LARGE);
				setState(1287); match(OBJECT);
				setState(1292); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1288); ((Grant_statementContext)_localctx).loid = identifier();
						setState(1290);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1289); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1294); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,174,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1296); grant_to_rule();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(1298); match(GRANT);
				setState(1311);
				switch (_input.LA(1)) {
				case CREATE:
				case USAGE:
					{
					setState(1303); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1299);
						_la = _input.LA(1);
						if ( !(_la==CREATE || _la==USAGE) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(1301);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1300); match(COMMA);
							}
						}

						}
						}
						setState(1305); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==CREATE || _la==USAGE );
					}
					break;
				case ALL:
					{
					setState(1307); match(ALL);
					setState(1309);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1308); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1313); match(ON);
				setState(1314); match(SCHEMA);
				setState(1319); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1315); ((Grant_statementContext)_localctx).schema_name = identifier();
						setState(1317);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1316); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1321); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,180,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1323); grant_to_rule();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(1325); match(GRANT);
				setState(1331);
				switch (_input.LA(1)) {
				case CREATE:
					{
					setState(1326); match(CREATE);
					}
					break;
				case ALL:
					{
					setState(1327); match(ALL);
					setState(1329);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1328); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1333); match(ON);
				setState(1334); match(TABLESPACE);
				setState(1339); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1335); ((Grant_statementContext)_localctx).tablespace_name = identifier();
						setState(1337);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1336); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1341); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,184,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1343); grant_to_rule();
				setState(1344); match(GRANT);
				setState(1349); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1345); ((Grant_statementContext)_localctx).role_name = identifier();
						setState(1347);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1346); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1351); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,186,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1353); match(TO);
				setState(1358); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1354); ((Grant_statementContext)_localctx).role_name = identifier();
						setState(1356);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1355); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1360); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,188,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1365);
				_la = _input.LA(1);
				if (_la==WITH) {
					{
					setState(1362); match(WITH);
					setState(1363); match(ADMIN);
					setState(1364); match(OPTION);
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
			setState(1369); match(TO);
			setState(1380); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(1371);
					_la = _input.LA(1);
					if (_la==GROUP) {
						{
						setState(1370); match(GROUP);
						}
					}

					setState(1375);
					switch ( getInterpreter().adaptivePredict(_input,192,_ctx) ) {
					case 1:
						{
						{
						setState(1373); ((Grant_to_ruleContext)_localctx).role_name = identifier();
						}
						}
						break;
					case 2:
						{
						setState(1374); match(PUBLIC);
						}
						break;
					}
					setState(1378);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1377); match(COMMA);
						}
					}

					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1382); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,194,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(1387);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(1384); match(WITH);
				setState(1385); match(GRANT);
				setState(1386); match(OPTION);
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
			setState(1389); match(COMMENT);
			setState(1390); match(ON);
			setState(1509);
			switch ( getInterpreter().adaptivePredict(_input,199,_ctx) ) {
			case 1:
				{
				setState(1391); match(AGGREGATE);
				setState(1392); ((Comment_on_statementContext)_localctx).agg_name = schema_qualified_name();
				setState(1393); match(LEFT_PAREN);
				setState(1400);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 114)) & ~0x3f) == 0 && ((1L << (_la - 114)) & ((1L << (TRIGGER - 114)) | (1L << (CHARACTER - 114)) | (1L << (DEC - 114)))) != 0) || ((((_la - 198)) & ~0x3f) == 0 && ((1L << (_la - 198)) & ((1L << (NATIONAL - 198)) | (1L << (BOOLEAN - 198)) | (1L << (BOOL - 198)) | (1L << (BIT - 198)) | (1L << (VARBIT - 198)) | (1L << (INT1 - 198)) | (1L << (INT2 - 198)) | (1L << (INT4 - 198)))) != 0) || ((((_la - 262)) & ~0x3f) == 0 && ((1L << (_la - 262)) & ((1L << (INT8 - 262)) | (1L << (TINYINT - 262)) | (1L << (SMALLINT - 262)) | (1L << (INT - 262)) | (1L << (INTEGER - 262)) | (1L << (BIGINT - 262)) | (1L << (FLOAT4 - 262)) | (1L << (FLOAT8 - 262)) | (1L << (REAL - 262)) | (1L << (REGCLASS - 262)) | (1L << (FLOAT - 262)) | (1L << (DOUBLE - 262)) | (1L << (NUMERIC - 262)) | (1L << (DECIMAL - 262)) | (1L << (CHAR - 262)) | (1L << (VARCHAR - 262)) | (1L << (NCHAR - 262)) | (1L << (NVARCHAR - 262)) | (1L << (DATE - 262)) | (1L << (TIME - 262)) | (1L << (TIMETZ - 262)) | (1L << (TIMESTAMP - 262)) | (1L << (TIMESTAMPTZ - 262)) | (1L << (TEXT - 262)) | (1L << (UUID - 262)) | (1L << (BINARY - 262)) | (1L << (VARBINARY - 262)) | (1L << (BLOB - 262)) | (1L << (BYTEA - 262)) | (1L << (INET4 - 262)))) != 0)) {
					{
					{
					setState(1394); ((Comment_on_statementContext)_localctx).agg_type = data_type();
					setState(1396);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1395); match(COMMA);
						}
					}

					}
					}
					setState(1402);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1403); match(RIGHT_PAREN);
				}
				break;
			case 2:
				{
				setState(1405); match(CAST);
				setState(1406); match(LEFT_PAREN);
				setState(1407); ((Comment_on_statementContext)_localctx).source_type = data_type();
				setState(1408); match(AS);
				setState(1409); ((Comment_on_statementContext)_localctx).target_type = data_type();
				setState(1410); match(RIGHT_PAREN);
				}
				break;
			case 3:
				{
				setState(1412); match(COLLATION);
				setState(1413); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 4:
				{
				setState(1414); match(COLUMN);
				setState(1415); ((Comment_on_statementContext)_localctx).column_name = schema_qualified_name();
				}
				break;
			case 5:
				{
				setState(1416); match(CONSTRAINT);
				setState(1417); ((Comment_on_statementContext)_localctx).constraint_name = schema_qualified_name();
				setState(1418); match(ON);
				setState(1419); ((Comment_on_statementContext)_localctx).table_name = schema_qualified_name();
				}
				break;
			case 6:
				{
				setState(1421); match(CONVERSION);
				setState(1422); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 7:
				{
				setState(1423); match(DATABASE);
				setState(1424); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 8:
				{
				setState(1425); match(DOMAIN);
				setState(1426); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 9:
				{
				setState(1427); match(EXTENSION);
				setState(1428); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 10:
				{
				setState(1429); match(FOREIGN);
				setState(1430); match(DATA);
				setState(1431); match(WRAPPER);
				setState(1432); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 11:
				{
				setState(1433); match(FOREIGN);
				setState(1434); match(TABLE);
				setState(1435); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 12:
				{
				setState(1436); function_definition();
				}
				break;
			case 13:
				{
				setState(1437); match(INDEX);
				setState(1438); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 14:
				{
				setState(1439); match(LARGE);
				setState(1440); match(OBJECT);
				setState(1441); ((Comment_on_statementContext)_localctx).large_object_oid = identifier();
				}
				break;
			case 15:
				{
				setState(1442); match(OPERATOR);
				setState(1443); ((Comment_on_statementContext)_localctx).operator_name = schema_qualified_name();
				setState(1444); match(LEFT_PAREN);
				setState(1445); ((Comment_on_statementContext)_localctx).left_type = data_type();
				setState(1446); match(COMMA);
				setState(1447); ((Comment_on_statementContext)_localctx).right_type = data_type();
				setState(1448); match(RIGHT_PAREN);
				}
				break;
			case 16:
				{
				setState(1450); match(OPERATOR);
				setState(1451); match(CLASS);
				setState(1452); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				setState(1453); match(USING);
				setState(1454); ((Comment_on_statementContext)_localctx).index_method = identifier();
				}
				break;
			case 17:
				{
				setState(1456); match(OPERATOR);
				setState(1457); match(FAMILY);
				setState(1458); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				setState(1459); match(USING);
				setState(1460); ((Comment_on_statementContext)_localctx).index_method = identifier();
				}
				break;
			case 18:
				{
				setState(1463);
				_la = _input.LA(1);
				if (_la==PROCEDURAL) {
					{
					setState(1462); match(PROCEDURAL);
					}
				}

				setState(1465); match(LANGUAGE);
				setState(1466); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 19:
				{
				setState(1467); match(ROLE);
				setState(1468); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 20:
				{
				setState(1469); match(RULE);
				setState(1470); ((Comment_on_statementContext)_localctx).rule_name = schema_qualified_name();
				setState(1471); match(ON);
				setState(1472); ((Comment_on_statementContext)_localctx).table_name = schema_qualified_name();
				}
				break;
			case 21:
				{
				setState(1474); match(SCHEMA);
				setState(1475); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 22:
				{
				setState(1476); match(SEQUENCE);
				setState(1477); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 23:
				{
				setState(1478); match(SERVER);
				setState(1479); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 24:
				{
				setState(1480); match(TABLE);
				setState(1481); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 25:
				{
				setState(1482); match(TABLESPACE);
				setState(1483); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 26:
				{
				setState(1484); match(TEXT);
				setState(1485); match(SEARCH);
				setState(1486); match(CONFIGURATION);
				setState(1487); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 27:
				{
				setState(1488); match(TEXT);
				setState(1489); match(SEARCH);
				setState(1490); match(DICTIONARY);
				setState(1491); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 28:
				{
				setState(1492); match(TEXT);
				setState(1493); match(SEARCH);
				setState(1494); match(PARSER);
				setState(1495); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 29:
				{
				setState(1496); match(TEXT);
				setState(1497); match(SEARCH);
				setState(1498); match(TEMPLATE);
				setState(1499); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 30:
				{
				setState(1500); match(TRIGGER);
				setState(1501); ((Comment_on_statementContext)_localctx).trigger_name = schema_qualified_name();
				setState(1502); match(ON);
				setState(1503); ((Comment_on_statementContext)_localctx).table_name = schema_qualified_name();
				}
				break;
			case 31:
				{
				setState(1505); match(TYPE);
				setState(1506); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 32:
				{
				setState(1507); match(VIEW);
				setState(1508); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			}
			setState(1511); match(IS);
			setState(1512); match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
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
		public IdentifierContext name;
		public ArgmodeContext arg_mode;
		public IdentifierContext argname;
		public Data_typeContext argtype;
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
		public Routine_invocationContext routine_invocation(int i) {
			return getRuleContext(Routine_invocationContext.class,i);
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
		public List<Routine_invocationContext> routine_invocation() {
			return getRuleContexts(Routine_invocationContext.class);
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
			setState(1514); match(CREATE);
			setState(1517);
			_la = _input.LA(1);
			if (_la==OR) {
				{
				setState(1515); match(OR);
				setState(1516); match(REPLACE);
				}
			}

			setState(1519); match(FUNCTION);
			setState(1520); ((Create_function_statementContext)_localctx).name = identifier();
			setState(1521); match(LEFT_PAREN);
			setState(1539);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IN || _la==INOUT || ((((_la - 80)) & ~0x3f) == 0 && ((1L << (_la - 80)) & ((1L << (OUT - 80)) | (1L << (TRIGGER - 80)) | (1L << (VARIADIC - 80)) | (1L << (ADMIN - 80)) | (1L << (AVG - 80)) | (1L << (BETWEEN - 80)) | (1L << (BY - 80)) | (1L << (CACHE - 80)) | (1L << (CALLED - 80)) | (1L << (CLASS - 80)) | (1L << (CENTURY - 80)) | (1L << (CHARACTER - 80)) | (1L << (CHECK - 80)) | (1L << (COLLECT - 80)) | (1L << (COALESCE - 80)) | (1L << (COLUMN - 80)) | (1L << (COMMENT - 80)) | (1L << (COMMENTS - 80)) | (1L << (COMMIT - 80)))) != 0) || ((((_la - 144)) & ~0x3f) == 0 && ((1L << (_la - 144)) & ((1L << (CONFIGURATION - 144)) | (1L << (COST - 144)) | (1L << (COUNT - 144)) | (1L << (CUBE - 144)) | (1L << (CURRENT - 144)) | (1L << (CYCLE - 144)) | (1L << (DATA - 144)) | (1L << (DAY - 144)) | (1L << (DEC - 144)) | (1L << (DECADE - 144)) | (1L << (DEFINER - 144)) | (1L << (DICTIONARY - 144)) | (1L << (DOW - 144)) | (1L << (DOY - 144)) | (1L << (DROP - 144)) | (1L << (EPOCH - 144)) | (1L << (EVERY - 144)) | (1L << (EXISTS - 144)) | (1L << (EXTERNAL - 144)) | (1L << (EXTRACT - 144)) | (1L << (FAMILY - 144)) | (1L << (FILTER - 144)) | (1L << (FIRST - 144)) | (1L << (FORMAT - 144)) | (1L << (FUSION - 144)) | (1L << (GROUPING - 144)) | (1L << (HASH - 144)) | (1L << (INDEX - 144)) | (1L << (INCREMENT - 144)) | (1L << (INPUT - 144)) | (1L << (INSERT - 144)) | (1L << (INTERSECTION - 144)) | (1L << (ISCACHABLE - 144)) | (1L << (ISODOW - 144)) | (1L << (ISOYEAR - 144)) | (1L << (ISSTRICT - 144)) | (1L << (LANGUAGE - 144)) | (1L << (LARGE - 144)) | (1L << (LAST - 144)) | (1L << (LESS - 144)) | (1L << (LIST - 144)) | (1L << (LOCATION - 144)) | (1L << (MATCH - 144)) | (1L << (MAX - 144)) | (1L << (MAXVALUE - 144)) | (1L << (MICROSECONDS - 144)) | (1L << (MILLENNIUM - 144)) | (1L << (MILLISECONDS - 144)) | (1L << (MIN - 144)) | (1L << (MINVALUE - 144)) | (1L << (MINUTE - 144)) | (1L << (MONTH - 144)) | (1L << (NATIONAL - 144)) | (1L << (NO - 144)) | (1L << (NONE - 144)) | (1L << (NULLIF - 144)) | (1L << (OBJECT - 144)) | (1L << (OPTION - 144)) | (1L << (OPTIONS - 144)) | (1L << (OVERWRITE - 144)) | (1L << (PARSER - 144)) | (1L << (PARTIAL - 144)))) != 0) || ((((_la - 208)) & ~0x3f) == 0 && ((1L << (_la - 208)) & ((1L << (PARTITION - 208)) | (1L << (PARTITIONS - 208)) | (1L << (PRECISION - 208)) | (1L << (PUBLIC - 208)) | (1L << (PURGE - 208)) | (1L << (QUARTER - 208)) | (1L << (RANGE - 208)) | (1L << (REGEXP - 208)) | (1L << (RLIKE - 208)) | (1L << (ROLLUP - 208)) | (1L << (SEARCH - 208)) | (1L << (SECOND - 208)) | (1L << (SECURITY - 208)) | (1L << (SERVER - 208)) | (1L << (SET - 208)) | (1L << (SIMILAR - 208)) | (1L << (SIMPLE - 208)) | (1L << (STABLE - 208)) | (1L << (START - 208)) | (1L << (STORAGE - 208)) | (1L << (STDDEV_POP - 208)) | (1L << (STDDEV_SAMP - 208)) | (1L << (SUBPARTITION - 208)) | (1L << (SUM - 208)) | (1L << (TABLESPACE - 208)) | (1L << (TEMPLATE - 208)) | (1L << (THAN - 208)) | (1L << (TIMEZONE - 208)) | (1L << (TIMEZONE_HOUR - 208)) | (1L << (TIMEZONE_MINUTE - 208)) | (1L << (TRIM - 208)) | (1L << (TO - 208)) | (1L << (TYPE - 208)) | (1L << (UNKNOWN - 208)) | (1L << (UNLOGGED - 208)) | (1L << (VALUES - 208)) | (1L << (VAR_SAMP - 208)) | (1L << (VAR_POP - 208)) | (1L << (VARYING - 208)) | (1L << (VOLATILE - 208)) | (1L << (WEEK - 208)) | (1L << (WINDOW - 208)) | (1L << (WRAPPER - 208)) | (1L << (YEAR - 208)) | (1L << (ZONE - 208)) | (1L << (BOOLEAN - 208)) | (1L << (BOOL - 208)) | (1L << (BIT - 208)) | (1L << (VARBIT - 208)) | (1L << (INT1 - 208)) | (1L << (INT2 - 208)) | (1L << (INT4 - 208)) | (1L << (INT8 - 208)) | (1L << (TINYINT - 208)) | (1L << (SMALLINT - 208)) | (1L << (INT - 208)) | (1L << (INTEGER - 208)) | (1L << (BIGINT - 208)) | (1L << (FLOAT4 - 208)) | (1L << (FLOAT8 - 208)) | (1L << (REAL - 208)) | (1L << (REGCLASS - 208)))) != 0) || ((((_la - 272)) & ~0x3f) == 0 && ((1L << (_la - 272)) & ((1L << (FLOAT - 272)) | (1L << (DOUBLE - 272)) | (1L << (NUMERIC - 272)) | (1L << (DECIMAL - 272)) | (1L << (CHAR - 272)) | (1L << (VARCHAR - 272)) | (1L << (NCHAR - 272)) | (1L << (NVARCHAR - 272)) | (1L << (DATE - 272)) | (1L << (TIME - 272)) | (1L << (TIMETZ - 272)) | (1L << (TIMESTAMP - 272)) | (1L << (TIMESTAMPTZ - 272)) | (1L << (TEXT - 272)) | (1L << (UUID - 272)) | (1L << (BINARY - 272)) | (1L << (VARBINARY - 272)) | (1L << (BLOB - 272)) | (1L << (BYTEA - 272)) | (1L << (INET4 - 272)) | (1L << (DOUBLE_QUOTE - 272)) | (1L << (Identifier - 272)))) != 0)) {
				{
				{
				setState(1523);
				_la = _input.LA(1);
				if (_la==IN || _la==INOUT || _la==OUT || _la==VARIADIC) {
					{
					setState(1522); ((Create_function_statementContext)_localctx).arg_mode = argmode();
					}
				}

				setState(1526);
				switch ( getInterpreter().adaptivePredict(_input,202,_ctx) ) {
				case 1:
					{
					setState(1525); ((Create_function_statementContext)_localctx).argname = identifier();
					}
					break;
				}
				setState(1528); ((Create_function_statementContext)_localctx).argtype = data_type();
				setState(1532);
				switch (_input.LA(1)) {
				case DEFAULT:
					{
					setState(1529); match(DEFAULT);
					}
					break;
				case EQUAL:
					{
					setState(1530); match(EQUAL);
					setState(1531); routine_invocation();
					}
					break;
				case IN:
				case INOUT:
				case OUT:
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
				case COMMA:
				case RIGHT_PAREN:
				case DOUBLE_QUOTE:
				case Identifier:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1535);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(1534); match(COMMA);
					}
				}

				}
				}
				setState(1541);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1542); match(RIGHT_PAREN);
			setState(1559);
			switch ( getInterpreter().adaptivePredict(_input,208,_ctx) ) {
			case 1:
				{
				setState(1543); match(RETURNS);
				setState(1544); ((Create_function_statementContext)_localctx).rettype = data_type();
				}
				break;
			case 2:
				{
				setState(1545); match(RETURNS);
				setState(1546); match(TABLE);
				setState(1547); match(LEFT_PAREN);
				setState(1553); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1548); ((Create_function_statementContext)_localctx).column_name = identifier();
					setState(1549); ((Create_function_statementContext)_localctx).column_type = data_type();
					setState(1551);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1550); match(COMMA);
						}
					}

					}
					}
					setState(1555); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (ADMIN - 128)) | (1L << (AVG - 128)) | (1L << (BETWEEN - 128)) | (1L << (BY - 128)) | (1L << (CACHE - 128)) | (1L << (CALLED - 128)) | (1L << (CLASS - 128)) | (1L << (CENTURY - 128)) | (1L << (CHARACTER - 128)) | (1L << (CHECK - 128)) | (1L << (COLLECT - 128)) | (1L << (COALESCE - 128)) | (1L << (COLUMN - 128)) | (1L << (COMMENT - 128)) | (1L << (COMMENTS - 128)) | (1L << (COMMIT - 128)) | (1L << (CONFIGURATION - 128)) | (1L << (COST - 128)) | (1L << (COUNT - 128)) | (1L << (CUBE - 128)) | (1L << (CURRENT - 128)) | (1L << (CYCLE - 128)) | (1L << (DATA - 128)) | (1L << (DAY - 128)) | (1L << (DEC - 128)) | (1L << (DECADE - 128)) | (1L << (DEFINER - 128)) | (1L << (DICTIONARY - 128)) | (1L << (DOW - 128)) | (1L << (DOY - 128)) | (1L << (DROP - 128)) | (1L << (EPOCH - 128)) | (1L << (EVERY - 128)) | (1L << (EXISTS - 128)) | (1L << (EXTERNAL - 128)) | (1L << (EXTRACT - 128)) | (1L << (FAMILY - 128)) | (1L << (FILTER - 128)) | (1L << (FIRST - 128)) | (1L << (FORMAT - 128)) | (1L << (FUSION - 128)) | (1L << (GROUPING - 128)) | (1L << (HASH - 128)) | (1L << (INDEX - 128)) | (1L << (INCREMENT - 128)) | (1L << (INPUT - 128)) | (1L << (INSERT - 128)) | (1L << (INTERSECTION - 128)) | (1L << (ISCACHABLE - 128)) | (1L << (ISODOW - 128)) | (1L << (ISOYEAR - 128)) | (1L << (ISSTRICT - 128)) | (1L << (LANGUAGE - 128)) | (1L << (LARGE - 128)) | (1L << (LAST - 128)) | (1L << (LESS - 128)) | (1L << (LIST - 128)) | (1L << (LOCATION - 128)) | (1L << (MATCH - 128)) | (1L << (MAX - 128)) | (1L << (MAXVALUE - 128)) | (1L << (MICROSECONDS - 128)))) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (MILLENNIUM - 192)) | (1L << (MILLISECONDS - 192)) | (1L << (MIN - 192)) | (1L << (MINVALUE - 192)) | (1L << (MINUTE - 192)) | (1L << (MONTH - 192)) | (1L << (NATIONAL - 192)) | (1L << (NO - 192)) | (1L << (NONE - 192)) | (1L << (NULLIF - 192)) | (1L << (OBJECT - 192)) | (1L << (OPTION - 192)) | (1L << (OPTIONS - 192)) | (1L << (OVERWRITE - 192)) | (1L << (PARSER - 192)) | (1L << (PARTIAL - 192)) | (1L << (PARTITION - 192)) | (1L << (PARTITIONS - 192)) | (1L << (PRECISION - 192)) | (1L << (PUBLIC - 192)) | (1L << (PURGE - 192)) | (1L << (QUARTER - 192)) | (1L << (RANGE - 192)) | (1L << (REGEXP - 192)) | (1L << (RLIKE - 192)) | (1L << (ROLLUP - 192)) | (1L << (SEARCH - 192)) | (1L << (SECOND - 192)) | (1L << (SECURITY - 192)) | (1L << (SERVER - 192)) | (1L << (SET - 192)) | (1L << (SIMILAR - 192)) | (1L << (SIMPLE - 192)) | (1L << (STABLE - 192)) | (1L << (START - 192)) | (1L << (STORAGE - 192)) | (1L << (STDDEV_POP - 192)) | (1L << (STDDEV_SAMP - 192)) | (1L << (SUBPARTITION - 192)) | (1L << (SUM - 192)) | (1L << (TABLESPACE - 192)) | (1L << (TEMPLATE - 192)) | (1L << (THAN - 192)) | (1L << (TIMEZONE - 192)) | (1L << (TIMEZONE_HOUR - 192)) | (1L << (TIMEZONE_MINUTE - 192)) | (1L << (TRIM - 192)) | (1L << (TO - 192)) | (1L << (TYPE - 192)) | (1L << (UNKNOWN - 192)) | (1L << (UNLOGGED - 192)) | (1L << (VALUES - 192)) | (1L << (VAR_SAMP - 192)) | (1L << (VAR_POP - 192)) | (1L << (VARYING - 192)) | (1L << (VOLATILE - 192)) | (1L << (WEEK - 192)) | (1L << (WINDOW - 192)) | (1L << (WRAPPER - 192)) | (1L << (YEAR - 192)) | (1L << (ZONE - 192)) | (1L << (BOOLEAN - 192)))) != 0) || ((((_la - 256)) & ~0x3f) == 0 && ((1L << (_la - 256)) & ((1L << (BOOL - 256)) | (1L << (BIT - 256)) | (1L << (VARBIT - 256)) | (1L << (INT1 - 256)) | (1L << (INT2 - 256)) | (1L << (INT4 - 256)) | (1L << (INT8 - 256)) | (1L << (TINYINT - 256)) | (1L << (SMALLINT - 256)) | (1L << (INT - 256)) | (1L << (INTEGER - 256)) | (1L << (BIGINT - 256)) | (1L << (FLOAT4 - 256)) | (1L << (FLOAT8 - 256)) | (1L << (REAL - 256)) | (1L << (FLOAT - 256)) | (1L << (DOUBLE - 256)) | (1L << (NUMERIC - 256)) | (1L << (DECIMAL - 256)) | (1L << (CHAR - 256)) | (1L << (VARCHAR - 256)) | (1L << (NCHAR - 256)) | (1L << (NVARCHAR - 256)) | (1L << (DATE - 256)) | (1L << (TIME - 256)) | (1L << (TIMETZ - 256)) | (1L << (TIMESTAMP - 256)) | (1L << (TIMESTAMPTZ - 256)) | (1L << (TEXT - 256)) | (1L << (UUID - 256)) | (1L << (VARBINARY - 256)) | (1L << (BLOB - 256)) | (1L << (BYTEA - 256)) | (1L << (INET4 - 256)) | (1L << (DOUBLE_QUOTE - 256)))) != 0) || _la==Identifier );
				setState(1557); match(RIGHT_PAREN);
				}
				break;
			}
			setState(1614); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(1614);
					switch ( getInterpreter().adaptivePredict(_input,213,_ctx) ) {
					case 1:
						{
						setState(1561); match(LANGUAGE);
						setState(1562); ((Create_function_statementContext)_localctx).lang_name = identifier();
						}
						break;
					case 2:
						{
						setState(1563); match(WINDOW);
						}
						break;
					case 3:
						{
						setState(1564); match(IMMUTABLE);
						}
						break;
					case 4:
						{
						setState(1565); match(STABLE);
						}
						break;
					case 5:
						{
						setState(1566); match(VOLATILE);
						}
						break;
					case 6:
						{
						setState(1567); match(CALLED);
						setState(1568); match(ON);
						setState(1569); match(NULL);
						setState(1570); match(INPUT);
						}
						break;
					case 7:
						{
						setState(1571); match(RETURNS);
						setState(1572); match(NULL);
						setState(1573); match(ON);
						setState(1574); match(NULL);
						setState(1575); match(INPUT);
						}
						break;
					case 8:
						{
						setState(1576); match(STRICT);
						}
						break;
					case 9:
						{
						setState(1578);
						_la = _input.LA(1);
						if (_la==EXTERNAL) {
							{
							setState(1577); match(EXTERNAL);
							}
						}

						setState(1580); match(SECURITY);
						setState(1581); match(INVOKER);
						}
						break;
					case 10:
						{
						setState(1583);
						_la = _input.LA(1);
						if (_la==EXTERNAL) {
							{
							setState(1582); match(EXTERNAL);
							}
						}

						setState(1585); match(SECURITY);
						setState(1586); match(DEFINER);
						}
						break;
					case 11:
						{
						setState(1587); match(COST);
						setState(1588); ((Create_function_statementContext)_localctx).execution_cost = match(NUMBER);
						}
						break;
					case 12:
						{
						setState(1589); match(ROWS);
						setState(1590); ((Create_function_statementContext)_localctx).result_rows = match(NUMBER);
						}
						break;
					case 13:
						{
						setState(1591); match(SET);
						setState(1592); ((Create_function_statementContext)_localctx).configuration_parameter = identifier();
						setState(1599);
						switch (_input.LA(1)) {
						case TO:
							{
							setState(1593); match(TO);
							setState(1594); ((Create_function_statementContext)_localctx).value = identifier();
							}
							break;
						case EQUAL:
							{
							setState(1595); match(EQUAL);
							setState(1596); ((Create_function_statementContext)_localctx).value = identifier();
							}
							break;
						case FROM:
							{
							setState(1597); match(FROM);
							setState(1598); match(CURRENT);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(1605);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(1601); match(COMMA);
							setState(1602); ((Create_function_statementContext)_localctx).value = identifier();
							}
							}
							setState(1607);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
						break;
					case 14:
						{
						setState(1608); match(AS);
						setState(1609); function_body();
						}
						break;
					case 15:
						{
						setState(1610); match(AS);
						setState(1611); match(Character_String_Literal);
						setState(1612); match(COMMA);
						setState(1613); match(Character_String_Literal);
						}
						break;
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1616); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,214,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(1630);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(1618); match(WITH);
				setState(1619); match(LEFT_PAREN);
				setState(1624); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1620); ((Create_function_statementContext)_localctx).attribute = function_attribute();
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
				} while ( _la==ISCACHABLE || _la==ISSTRICT );
				setState(1628); match(RIGHT_PAREN);
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
		public List<TerminalNode> DOUBLE_DOLLAR() { return getTokens(SQLParser.DOUBLE_DOLLAR); }
		public TerminalNode DOUBLE_DOLLAR(int i) {
			return getToken(SQLParser.DOUBLE_DOLLAR, i);
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1632); match(DOUBLE_DOLLAR);
			setState(1636);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AGGREGATE) | (1L << AFTER) | (1L << AS) | (1L << ALL) | (1L << AND) | (1L << ANY) | (1L << ASYMMETRIC) | (1L << ASC) | (1L << AUTHORIZATION) | (1L << BEFORE) | (1L << BOTH) | (1L << CASE) | (1L << CASCADE) | (1L << CAST) | (1L << COLLATE) | (1L << COLLATION) | (1L << CONNECT) | (1L << CONSTRAINT) | (1L << CONSTRAINTS) | (1L << CONVERSION) | (1L << CREATE) | (1L << CROSS) | (1L << DATABASE) | (1L << DEFAULT) | (1L << DEFAULTS) | (1L << DEFERRABLE) | (1L << DEFERRED) | (1L << DELETE) | (1L << DESC) | (1L << DISTINCT) | (1L << DOMAIN) | (1L << EACH) | (1L << END) | (1L << ELSE) | (1L << EXCEPT) | (1L << EXCLUDE) | (1L << EXCLUDING) | (1L << EXECUTE) | (1L << EXTENSION) | (1L << FALSE) | (1L << FOR) | (1L << FOREIGN) | (1L << FULL) | (1L << FUNCTION) | (1L << FUNCTIONS) | (1L << FROM) | (1L << GLOBAL) | (1L << GRANT) | (1L << GROUP) | (1L << HAVING) | (1L << IF) | (1L << ILIKE) | (1L << IMMEDIATE) | (1L << IMMUTABLE) | (1L << IN) | (1L << INCLUDING) | (1L << INHERITS) | (1L << INITIALLY) | (1L << INNER) | (1L << INTERSECT) | (1L << INTO) | (1L << INOUT) | (1L << INSTEAD))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (INVOKER - 64)) | (1L << (IS - 64)) | (1L << (JOIN - 64)) | (1L << (KEY - 64)) | (1L << (LEADING - 64)) | (1L << (LEFT - 64)) | (1L << (LIKE - 64)) | (1L << (LIMIT - 64)) | (1L << (LOCAL - 64)) | (1L << (NATURAL - 64)) | (1L << (NOT - 64)) | (1L << (NULL - 64)) | (1L << (OF - 64)) | (1L << (OIDS - 64)) | (1L << (ON - 64)) | (1L << (OUTER - 64)) | (1L << (OUT - 64)) | (1L << (OPERATOR - 64)) | (1L << (OR - 64)) | (1L << (ORDER - 64)) | (1L << (OWNED - 64)) | (1L << (PRESERVE - 64)) | (1L << (PRIMARY - 64)) | (1L << (PRIVILEGES - 64)) | (1L << (PROCEDURE - 64)) | (1L << (PROCEDURAL - 64)) | (1L << (ROLE - 64)) | (1L << (ROW - 64)) | (1L << (ROWS - 64)) | (1L << (REFERENCES - 64)) | (1L << (REPLACE - 64)) | (1L << (RESTRICT - 64)) | (1L << (RETURNS - 64)) | (1L << (REVOKE - 64)) | (1L << (RIGHT - 64)) | (1L << (RULE - 64)) | (1L << (SCHEMA - 64)) | (1L << (SEQUENCE - 64)) | (1L << (SEQUENCES - 64)) | (1L << (SELECT - 64)) | (1L << (SESSION - 64)) | (1L << (SOME - 64)) | (1L << (STATEMENT - 64)) | (1L << (STRICT - 64)) | (1L << (SYMMETRIC - 64)) | (1L << (TABLE - 64)) | (1L << (TEMP - 64)) | (1L << (TEMPORARY - 64)) | (1L << (THEN - 64)) | (1L << (TRAILING - 64)) | (1L << (TRIGGER - 64)) | (1L << (TRUE - 64)) | (1L << (TRUNCATE - 64)) | (1L << (UNION - 64)) | (1L << (UNIQUE - 64)) | (1L << (UPDATE - 64)) | (1L << (USAGE - 64)) | (1L << (USING - 64)) | (1L << (VARIADIC - 64)) | (1L << (VIEW - 64)) | (1L << (WHEN - 64)) | (1L << (WHERE - 64)) | (1L << (WITH - 64)) | (1L << (WITHOUT - 64)))) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (ADMIN - 128)) | (1L << (AVG - 128)) | (1L << (BETWEEN - 128)) | (1L << (BY - 128)) | (1L << (CACHE - 128)) | (1L << (CALLED - 128)) | (1L << (CLASS - 128)) | (1L << (CENTURY - 128)) | (1L << (CHARACTER - 128)) | (1L << (CHECK - 128)) | (1L << (COLLECT - 128)) | (1L << (COALESCE - 128)) | (1L << (COLUMN - 128)) | (1L << (COMMENT - 128)) | (1L << (COMMENTS - 128)) | (1L << (COMMIT - 128)) | (1L << (CONFIGURATION - 128)) | (1L << (COST - 128)) | (1L << (COUNT - 128)) | (1L << (CUBE - 128)) | (1L << (CURRENT - 128)) | (1L << (CYCLE - 128)) | (1L << (DATA - 128)) | (1L << (DAY - 128)) | (1L << (DEC - 128)) | (1L << (DECADE - 128)) | (1L << (DEFINER - 128)) | (1L << (DICTIONARY - 128)) | (1L << (DOW - 128)) | (1L << (DOY - 128)) | (1L << (DROP - 128)) | (1L << (EPOCH - 128)) | (1L << (EVERY - 128)) | (1L << (EXISTS - 128)) | (1L << (EXTERNAL - 128)) | (1L << (EXTRACT - 128)) | (1L << (FAMILY - 128)) | (1L << (FILTER - 128)) | (1L << (FIRST - 128)) | (1L << (FORMAT - 128)) | (1L << (FUSION - 128)) | (1L << (GROUPING - 128)) | (1L << (HASH - 128)) | (1L << (HOUR - 128)) | (1L << (INDEX - 128)) | (1L << (INDEXES - 128)) | (1L << (INCREMENT - 128)) | (1L << (INPUT - 128)) | (1L << (INSERT - 128)) | (1L << (INTERSECTION - 128)) | (1L << (ISCACHABLE - 128)) | (1L << (ISODOW - 128)) | (1L << (ISOYEAR - 128)) | (1L << (ISSTRICT - 128)) | (1L << (LANGUAGE - 128)) | (1L << (LARGE - 128)) | (1L << (LAST - 128)) | (1L << (LESS - 128)) | (1L << (LIST - 128)) | (1L << (LOCATION - 128)) | (1L << (MATCH - 128)) | (1L << (MAX - 128)) | (1L << (MAXVALUE - 128)) | (1L << (MICROSECONDS - 128)))) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (MILLENNIUM - 192)) | (1L << (MILLISECONDS - 192)) | (1L << (MIN - 192)) | (1L << (MINVALUE - 192)) | (1L << (MINUTE - 192)) | (1L << (MONTH - 192)) | (1L << (NATIONAL - 192)) | (1L << (NO - 192)) | (1L << (NONE - 192)) | (1L << (NULLIF - 192)) | (1L << (OBJECT - 192)) | (1L << (OPTION - 192)) | (1L << (OPTIONS - 192)) | (1L << (OVERWRITE - 192)) | (1L << (PARSER - 192)) | (1L << (PARTIAL - 192)) | (1L << (PARTITION - 192)) | (1L << (PARTITIONS - 192)) | (1L << (PRECISION - 192)) | (1L << (PUBLIC - 192)) | (1L << (PURGE - 192)) | (1L << (QUARTER - 192)) | (1L << (RANGE - 192)) | (1L << (REGEXP - 192)) | (1L << (RLIKE - 192)) | (1L << (ROLLUP - 192)) | (1L << (SEARCH - 192)) | (1L << (SECOND - 192)) | (1L << (SECURITY - 192)) | (1L << (SERVER - 192)) | (1L << (SET - 192)) | (1L << (SIMILAR - 192)) | (1L << (SIMPLE - 192)) | (1L << (STABLE - 192)) | (1L << (START - 192)) | (1L << (STORAGE - 192)) | (1L << (STDDEV_POP - 192)) | (1L << (STDDEV_SAMP - 192)) | (1L << (SUBPARTITION - 192)) | (1L << (SUM - 192)) | (1L << (TABLESPACE - 192)) | (1L << (TABLES - 192)) | (1L << (TEMPLATE - 192)) | (1L << (THAN - 192)) | (1L << (TIMEZONE - 192)) | (1L << (TIMEZONE_HOUR - 192)) | (1L << (TIMEZONE_MINUTE - 192)) | (1L << (TRIM - 192)) | (1L << (TO - 192)) | (1L << (TYPE - 192)) | (1L << (UNKNOWN - 192)) | (1L << (UNLOGGED - 192)) | (1L << (VALUES - 192)) | (1L << (VAR_SAMP - 192)) | (1L << (VAR_POP - 192)) | (1L << (VARYING - 192)) | (1L << (VERSION - 192)) | (1L << (VOLATILE - 192)) | (1L << (WEEK - 192)) | (1L << (WINDOW - 192)) | (1L << (WRAPPER - 192)) | (1L << (YEAR - 192)) | (1L << (ZONE - 192)) | (1L << (BOOLEAN - 192)))) != 0) || ((((_la - 256)) & ~0x3f) == 0 && ((1L << (_la - 256)) & ((1L << (BOOL - 256)) | (1L << (BIT - 256)) | (1L << (VARBIT - 256)) | (1L << (INT1 - 256)) | (1L << (INT2 - 256)) | (1L << (INT4 - 256)) | (1L << (INT8 - 256)) | (1L << (TINYINT - 256)) | (1L << (SMALLINT - 256)) | (1L << (INT - 256)) | (1L << (INTEGER - 256)) | (1L << (BIGINT - 256)) | (1L << (FLOAT4 - 256)) | (1L << (FLOAT8 - 256)) | (1L << (REAL - 256)) | (1L << (REGCLASS - 256)) | (1L << (FLOAT - 256)) | (1L << (DOUBLE - 256)) | (1L << (NUMERIC - 256)) | (1L << (DECIMAL - 256)) | (1L << (CHAR - 256)) | (1L << (VARCHAR - 256)) | (1L << (NCHAR - 256)) | (1L << (NVARCHAR - 256)) | (1L << (DATE - 256)) | (1L << (TIME - 256)) | (1L << (TIMETZ - 256)) | (1L << (TIMESTAMP - 256)) | (1L << (TIMESTAMPTZ - 256)) | (1L << (TEXT - 256)) | (1L << (UUID - 256)) | (1L << (BINARY - 256)) | (1L << (VARBINARY - 256)) | (1L << (BLOB - 256)) | (1L << (BYTEA - 256)) | (1L << (INET4 - 256)) | (1L << (Similar_To - 256)) | (1L << (Not_Similar_To - 256)) | (1L << (Similar_To_Case_Insensitive - 256)) | (1L << (Not_Similar_To_Case_Insensitive - 256)) | (1L << (CAST_EXPRESSION - 256)) | (1L << (ASSIGN - 256)) | (1L << (EQUAL - 256)) | (1L << (COLON - 256)) | (1L << (SEMI_COLON - 256)) | (1L << (COMMA - 256)) | (1L << (CONCATENATION_OPERATOR - 256)) | (1L << (NOT_EQUAL - 256)) | (1L << (LTH - 256)) | (1L << (LEQ - 256)) | (1L << (GTH - 256)) | (1L << (GEQ - 256)) | (1L << (LEFT_PAREN - 256)) | (1L << (RIGHT_PAREN - 256)) | (1L << (PLUS - 256)) | (1L << (MINUS - 256)) | (1L << (MULTIPLY - 256)) | (1L << (DIVIDE - 256)) | (1L << (MODULAR - 256)) | (1L << (DOT - 256)) | (1L << (UNDERLINE - 256)) | (1L << (VERTICAL_BAR - 256)) | (1L << (QUOTE - 256)) | (1L << (DOUBLE_QUOTE - 256)))) != 0) || ((((_la - 320)) & ~0x3f) == 0 && ((1L << (_la - 320)) & ((1L << (DOLLAR - 320)) | (1L << (NUMBER - 320)) | (1L << (REAL_NUMBER - 320)) | (1L << (BlockComment - 320)) | (1L << (LineComment - 320)) | (1L << (Identifier - 320)) | (1L << (Character_String_Literal - 320)) | (1L << (ESC_SEQUENCES - 320)) | (1L << (Space - 320)) | (1L << (White_Space - 320)) | (1L << (BAD - 320)))) != 0)) {
				{
				{
				setState(1633);
				_la = _input.LA(1);
				if ( _la <= 0 || (_la==DOUBLE_DOLLAR) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				}
				setState(1638);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1639); match(DOUBLE_DOLLAR);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 32, RULE_function_attribute);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1641);
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
		enterRule(_localctx, 34, RULE_argmode);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1643);
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
		public Value_expressionContext argtype;
		public Value_expressionContext value_expression(int i) {
			return getRuleContext(Value_expressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public List<Value_expressionContext> value_expression() {
			return getRuleContexts(Value_expressionContext.class);
		}
		public TerminalNode FUNCTION() { return getToken(SQLParser.FUNCTION, 0); }
		public List<ArgmodeContext> argmode() {
			return getRuleContexts(ArgmodeContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public ArgmodeContext argmode(int i) {
			return getRuleContext(ArgmodeContext.class,i);
		}
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
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
		enterRule(_localctx, 36, RULE_function_definition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1645); match(FUNCTION);
			setState(1646); ((Function_definitionContext)_localctx).func_name = identifier();
			setState(1647); match(LEFT_PAREN);
			setState(1660);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 6)) & ~0x3f) == 0 && ((1L << (_la - 6)) & ((1L << (ANY - 6)) | (1L << (CASE - 6)) | (1L << (CAST - 6)) | (1L << (FALSE - 6)) | (1L << (IN - 6)) | (1L << (INOUT - 6)) | (1L << (LEFT - 6)))) != 0) || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & ((1L << (NOT - 74)) | (1L << (NULL - 74)) | (1L << (OUT - 74)) | (1L << (RIGHT - 74)) | (1L << (SOME - 74)) | (1L << (TRUE - 74)) | (1L << (VARIADIC - 74)) | (1L << (ADMIN - 74)) | (1L << (AVG - 74)) | (1L << (BETWEEN - 74)) | (1L << (BY - 74)) | (1L << (CACHE - 74)) | (1L << (CALLED - 74)) | (1L << (CLASS - 74)) | (1L << (CENTURY - 74)) | (1L << (CHARACTER - 74)) | (1L << (CHECK - 74)))) != 0) || ((((_la - 138)) & ~0x3f) == 0 && ((1L << (_la - 138)) & ((1L << (COLLECT - 138)) | (1L << (COALESCE - 138)) | (1L << (COLUMN - 138)) | (1L << (COMMENT - 138)) | (1L << (COMMENTS - 138)) | (1L << (COMMIT - 138)) | (1L << (CONFIGURATION - 138)) | (1L << (COST - 138)) | (1L << (COUNT - 138)) | (1L << (CUBE - 138)) | (1L << (CURRENT - 138)) | (1L << (CYCLE - 138)) | (1L << (DATA - 138)) | (1L << (DAY - 138)) | (1L << (DEC - 138)) | (1L << (DECADE - 138)) | (1L << (DEFINER - 138)) | (1L << (DICTIONARY - 138)) | (1L << (DOW - 138)) | (1L << (DOY - 138)) | (1L << (DROP - 138)) | (1L << (EPOCH - 138)) | (1L << (EVERY - 138)) | (1L << (EXISTS - 138)) | (1L << (EXTERNAL - 138)) | (1L << (EXTRACT - 138)) | (1L << (FAMILY - 138)) | (1L << (FILTER - 138)) | (1L << (FIRST - 138)) | (1L << (FORMAT - 138)) | (1L << (FUSION - 138)) | (1L << (GROUPING - 138)) | (1L << (HASH - 138)) | (1L << (INDEX - 138)) | (1L << (INCREMENT - 138)) | (1L << (INPUT - 138)) | (1L << (INSERT - 138)) | (1L << (INTERSECTION - 138)) | (1L << (ISCACHABLE - 138)) | (1L << (ISODOW - 138)) | (1L << (ISOYEAR - 138)) | (1L << (ISSTRICT - 138)) | (1L << (LANGUAGE - 138)) | (1L << (LARGE - 138)) | (1L << (LAST - 138)) | (1L << (LESS - 138)) | (1L << (LIST - 138)) | (1L << (LOCATION - 138)) | (1L << (MATCH - 138)) | (1L << (MAX - 138)) | (1L << (MAXVALUE - 138)) | (1L << (MICROSECONDS - 138)) | (1L << (MILLENNIUM - 138)) | (1L << (MILLISECONDS - 138)) | (1L << (MIN - 138)) | (1L << (MINVALUE - 138)) | (1L << (MINUTE - 138)) | (1L << (MONTH - 138)) | (1L << (NATIONAL - 138)) | (1L << (NO - 138)) | (1L << (NONE - 138)) | (1L << (NULLIF - 138)))) != 0) || ((((_la - 202)) & ~0x3f) == 0 && ((1L << (_la - 202)) & ((1L << (OBJECT - 202)) | (1L << (OPTION - 202)) | (1L << (OPTIONS - 202)) | (1L << (OVERWRITE - 202)) | (1L << (PARSER - 202)) | (1L << (PARTIAL - 202)) | (1L << (PARTITION - 202)) | (1L << (PARTITIONS - 202)) | (1L << (PRECISION - 202)) | (1L << (PUBLIC - 202)) | (1L << (PURGE - 202)) | (1L << (QUARTER - 202)) | (1L << (RANGE - 202)) | (1L << (REGEXP - 202)) | (1L << (RLIKE - 202)) | (1L << (ROLLUP - 202)) | (1L << (SEARCH - 202)) | (1L << (SECOND - 202)) | (1L << (SECURITY - 202)) | (1L << (SERVER - 202)) | (1L << (SET - 202)) | (1L << (SIMILAR - 202)) | (1L << (SIMPLE - 202)) | (1L << (STABLE - 202)) | (1L << (START - 202)) | (1L << (STORAGE - 202)) | (1L << (STDDEV_POP - 202)) | (1L << (STDDEV_SAMP - 202)) | (1L << (SUBPARTITION - 202)) | (1L << (SUM - 202)) | (1L << (TABLESPACE - 202)) | (1L << (TEMPLATE - 202)) | (1L << (THAN - 202)) | (1L << (TIMEZONE - 202)) | (1L << (TIMEZONE_HOUR - 202)) | (1L << (TIMEZONE_MINUTE - 202)) | (1L << (TRIM - 202)) | (1L << (TO - 202)) | (1L << (TYPE - 202)) | (1L << (UNKNOWN - 202)) | (1L << (UNLOGGED - 202)) | (1L << (VALUES - 202)) | (1L << (VAR_SAMP - 202)) | (1L << (VAR_POP - 202)) | (1L << (VARYING - 202)) | (1L << (VOLATILE - 202)) | (1L << (WEEK - 202)) | (1L << (WINDOW - 202)) | (1L << (WRAPPER - 202)) | (1L << (YEAR - 202)) | (1L << (ZONE - 202)) | (1L << (BOOLEAN - 202)) | (1L << (BOOL - 202)) | (1L << (BIT - 202)) | (1L << (VARBIT - 202)) | (1L << (INT1 - 202)) | (1L << (INT2 - 202)) | (1L << (INT4 - 202)) | (1L << (INT8 - 202)) | (1L << (TINYINT - 202)) | (1L << (SMALLINT - 202)) | (1L << (INT - 202)))) != 0) || ((((_la - 266)) & ~0x3f) == 0 && ((1L << (_la - 266)) & ((1L << (INTEGER - 266)) | (1L << (BIGINT - 266)) | (1L << (FLOAT4 - 266)) | (1L << (FLOAT8 - 266)) | (1L << (REAL - 266)) | (1L << (FLOAT - 266)) | (1L << (DOUBLE - 266)) | (1L << (NUMERIC - 266)) | (1L << (DECIMAL - 266)) | (1L << (CHAR - 266)) | (1L << (VARCHAR - 266)) | (1L << (NCHAR - 266)) | (1L << (NVARCHAR - 266)) | (1L << (DATE - 266)) | (1L << (TIME - 266)) | (1L << (TIMETZ - 266)) | (1L << (TIMESTAMP - 266)) | (1L << (TIMESTAMPTZ - 266)) | (1L << (TEXT - 266)) | (1L << (UUID - 266)) | (1L << (VARBINARY - 266)) | (1L << (BLOB - 266)) | (1L << (BYTEA - 266)) | (1L << (INET4 - 266)) | (1L << (LEFT_PAREN - 266)) | (1L << (PLUS - 266)) | (1L << (MINUS - 266)) | (1L << (DOUBLE_QUOTE - 266)) | (1L << (NUMBER - 266)) | (1L << (REAL_NUMBER - 266)) | (1L << (Identifier - 266)) | (1L << (Character_String_Literal - 266)))) != 0)) {
				{
				{
				setState(1649);
				_la = _input.LA(1);
				if (_la==IN || _la==INOUT || _la==OUT || _la==VARIADIC) {
					{
					setState(1648); ((Function_definitionContext)_localctx).arg_mode = argmode();
					}
				}

				setState(1652);
				switch ( getInterpreter().adaptivePredict(_input,220,_ctx) ) {
				case 1:
					{
					setState(1651); ((Function_definitionContext)_localctx).argname = identifier();
					}
					break;
				}
				setState(1654); ((Function_definitionContext)_localctx).argtype = value_expression();
				setState(1656);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(1655); match(COMMA);
					}
				}

				}
				}
				setState(1662);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1663); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 38, RULE_functions_definition_schema);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1665); match(ALL);
			setState(1666); match(FUNCTIONS);
			setState(1667); match(IN);
			setState(1668); match(SCHEMA);
			setState(1673); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(1669); ((Functions_definition_schemaContext)_localctx).schema_name = identifier();
					setState(1671);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1670); match(COMMA);
						}
					}

					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1675); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,224,_ctx);
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
		enterRule(_localctx, 40, RULE_create_sequence_statement);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1677); match(CREATE);
			setState(1679);
			_la = _input.LA(1);
			if (_la==TEMP || _la==TEMPORARY) {
				{
				setState(1678);
				_la = _input.LA(1);
				if ( !(_la==TEMP || _la==TEMPORARY) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(1681); match(SEQUENCE);
			setState(1682); ((Create_sequence_statementContext)_localctx).name = schema_qualified_name();
			setState(1719);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,233,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(1717);
					switch ( getInterpreter().adaptivePredict(_input,232,_ctx) ) {
					case 1:
						{
						{
						setState(1683); match(INCREMENT);
						setState(1685);
						_la = _input.LA(1);
						if (_la==BY) {
							{
							setState(1684); match(BY);
							}
						}

						setState(1687); ((Create_sequence_statementContext)_localctx).incr = match(NUMBER);
						}
						}
						break;
					case 2:
						{
						setState(1692);
						switch (_input.LA(1)) {
						case MINVALUE:
							{
							setState(1688); match(MINVALUE);
							setState(1689); ((Create_sequence_statementContext)_localctx).minval = match(NUMBER);
							}
							break;
						case NO:
							{
							setState(1690); match(NO);
							setState(1691); match(MINVALUE);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						break;
					case 3:
						{
						setState(1698);
						switch (_input.LA(1)) {
						case MAXVALUE:
							{
							setState(1694); match(MAXVALUE);
							setState(1695); ((Create_sequence_statementContext)_localctx).maxval = numeric_type();
							}
							break;
						case NO:
							{
							setState(1696); match(NO);
							setState(1697); match(MAXVALUE);
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
						setState(1700); match(START);
						setState(1702);
						_la = _input.LA(1);
						if (_la==WITH) {
							{
							setState(1701); match(WITH);
							}
						}

						setState(1704); ((Create_sequence_statementContext)_localctx).start_val = match(NUMBER);
						}
						}
						break;
					case 5:
						{
						{
						setState(1705); match(CACHE);
						setState(1706); ((Create_sequence_statementContext)_localctx).cache_val = match(NUMBER);
						}
						}
						break;
					case 6:
						{
						{
						setState(1708);
						_la = _input.LA(1);
						if (_la==NO) {
							{
							setState(1707); match(NO);
							}
						}

						setState(1710); match(CYCLE);
						}
						}
						break;
					case 7:
						{
						{
						setState(1711); match(OWNED);
						setState(1712); match(BY);
						setState(1715);
						switch ( getInterpreter().adaptivePredict(_input,231,_ctx) ) {
						case 1:
							{
							setState(1713); ((Create_sequence_statementContext)_localctx).col_name = schema_qualified_name();
							}
							break;
						case 2:
							{
							setState(1714); match(NONE);
							}
							break;
						}
						}
						}
						break;
					}
					} 
				}
				setState(1721);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,233,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 42, RULE_create_schema_statement);
		int _la;
		try {
			int _alt;
			setState(1762);
			switch ( getInterpreter().adaptivePredict(_input,238,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1722); match(CREATE);
				setState(1723); match(SCHEMA);
				setState(1724); ((Create_schema_statementContext)_localctx).schema_name = identifier();
				setState(1727);
				_la = _input.LA(1);
				if (_la==AUTHORIZATION) {
					{
					setState(1725); match(AUTHORIZATION);
					setState(1726); ((Create_schema_statementContext)_localctx).user_name = identifier();
					}
				}

				setState(1732);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,235,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1729); ((Create_schema_statementContext)_localctx).schema_element = sql();
						}
						} 
					}
					setState(1734);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,235,_ctx);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1735); match(CREATE);
				setState(1736); match(SCHEMA);
				setState(1737); match(AUTHORIZATION);
				setState(1738); ((Create_schema_statementContext)_localctx).user_name = identifier();
				setState(1742);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,236,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1739); ((Create_schema_statementContext)_localctx).schema_element = sql();
						}
						} 
					}
					setState(1744);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,236,_ctx);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1745); match(CREATE);
				setState(1746); match(SCHEMA);
				setState(1747); match(IF);
				setState(1748); match(NOT);
				setState(1749); match(EXISTS);
				setState(1750); ((Create_schema_statementContext)_localctx).schema_name = identifier();
				setState(1753);
				_la = _input.LA(1);
				if (_la==AUTHORIZATION) {
					{
					setState(1751); match(AUTHORIZATION);
					setState(1752); ((Create_schema_statementContext)_localctx).user_name = identifier();
					}
				}

				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1755); match(CREATE);
				setState(1756); match(SCHEMA);
				setState(1757); match(IF);
				setState(1758); match(NOT);
				setState(1759); match(EXISTS);
				setState(1760); match(AUTHORIZATION);
				setState(1761); ((Create_schema_statementContext)_localctx).user_name = identifier();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 44, RULE_create_view_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1764); match(CREATE);
			setState(1767);
			_la = _input.LA(1);
			if (_la==OR) {
				{
				setState(1765); match(OR);
				setState(1766); match(REPLACE);
				}
			}

			setState(1770);
			_la = _input.LA(1);
			if (_la==TEMP || _la==TEMPORARY) {
				{
				setState(1769);
				_la = _input.LA(1);
				if ( !(_la==TEMP || _la==TEMPORARY) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(1772); match(VIEW);
			setState(1773); ((Create_view_statementContext)_localctx).name = schema_qualified_name();
			setState(1780);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (ADMIN - 128)) | (1L << (AVG - 128)) | (1L << (BETWEEN - 128)) | (1L << (BY - 128)) | (1L << (CACHE - 128)) | (1L << (CALLED - 128)) | (1L << (CLASS - 128)) | (1L << (CENTURY - 128)) | (1L << (CHARACTER - 128)) | (1L << (CHECK - 128)) | (1L << (COLLECT - 128)) | (1L << (COALESCE - 128)) | (1L << (COLUMN - 128)) | (1L << (COMMENT - 128)) | (1L << (COMMENTS - 128)) | (1L << (COMMIT - 128)) | (1L << (CONFIGURATION - 128)) | (1L << (COST - 128)) | (1L << (COUNT - 128)) | (1L << (CUBE - 128)) | (1L << (CURRENT - 128)) | (1L << (CYCLE - 128)) | (1L << (DATA - 128)) | (1L << (DAY - 128)) | (1L << (DEC - 128)) | (1L << (DECADE - 128)) | (1L << (DEFINER - 128)) | (1L << (DICTIONARY - 128)) | (1L << (DOW - 128)) | (1L << (DOY - 128)) | (1L << (DROP - 128)) | (1L << (EPOCH - 128)) | (1L << (EVERY - 128)) | (1L << (EXISTS - 128)) | (1L << (EXTERNAL - 128)) | (1L << (EXTRACT - 128)) | (1L << (FAMILY - 128)) | (1L << (FILTER - 128)) | (1L << (FIRST - 128)) | (1L << (FORMAT - 128)) | (1L << (FUSION - 128)) | (1L << (GROUPING - 128)) | (1L << (HASH - 128)) | (1L << (INDEX - 128)) | (1L << (INCREMENT - 128)) | (1L << (INPUT - 128)) | (1L << (INSERT - 128)) | (1L << (INTERSECTION - 128)) | (1L << (ISCACHABLE - 128)) | (1L << (ISODOW - 128)) | (1L << (ISOYEAR - 128)) | (1L << (ISSTRICT - 128)) | (1L << (LANGUAGE - 128)) | (1L << (LARGE - 128)) | (1L << (LAST - 128)) | (1L << (LESS - 128)) | (1L << (LIST - 128)) | (1L << (LOCATION - 128)) | (1L << (MATCH - 128)) | (1L << (MAX - 128)) | (1L << (MAXVALUE - 128)) | (1L << (MICROSECONDS - 128)))) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (MILLENNIUM - 192)) | (1L << (MILLISECONDS - 192)) | (1L << (MIN - 192)) | (1L << (MINVALUE - 192)) | (1L << (MINUTE - 192)) | (1L << (MONTH - 192)) | (1L << (NATIONAL - 192)) | (1L << (NO - 192)) | (1L << (NONE - 192)) | (1L << (NULLIF - 192)) | (1L << (OBJECT - 192)) | (1L << (OPTION - 192)) | (1L << (OPTIONS - 192)) | (1L << (OVERWRITE - 192)) | (1L << (PARSER - 192)) | (1L << (PARTIAL - 192)) | (1L << (PARTITION - 192)) | (1L << (PARTITIONS - 192)) | (1L << (PRECISION - 192)) | (1L << (PUBLIC - 192)) | (1L << (PURGE - 192)) | (1L << (QUARTER - 192)) | (1L << (RANGE - 192)) | (1L << (REGEXP - 192)) | (1L << (RLIKE - 192)) | (1L << (ROLLUP - 192)) | (1L << (SEARCH - 192)) | (1L << (SECOND - 192)) | (1L << (SECURITY - 192)) | (1L << (SERVER - 192)) | (1L << (SET - 192)) | (1L << (SIMILAR - 192)) | (1L << (SIMPLE - 192)) | (1L << (STABLE - 192)) | (1L << (START - 192)) | (1L << (STORAGE - 192)) | (1L << (STDDEV_POP - 192)) | (1L << (STDDEV_SAMP - 192)) | (1L << (SUBPARTITION - 192)) | (1L << (SUM - 192)) | (1L << (TABLESPACE - 192)) | (1L << (TEMPLATE - 192)) | (1L << (THAN - 192)) | (1L << (TIMEZONE - 192)) | (1L << (TIMEZONE_HOUR - 192)) | (1L << (TIMEZONE_MINUTE - 192)) | (1L << (TRIM - 192)) | (1L << (TO - 192)) | (1L << (TYPE - 192)) | (1L << (UNKNOWN - 192)) | (1L << (UNLOGGED - 192)) | (1L << (VALUES - 192)) | (1L << (VAR_SAMP - 192)) | (1L << (VAR_POP - 192)) | (1L << (VARYING - 192)) | (1L << (VOLATILE - 192)) | (1L << (WEEK - 192)) | (1L << (WINDOW - 192)) | (1L << (WRAPPER - 192)) | (1L << (YEAR - 192)) | (1L << (ZONE - 192)) | (1L << (BOOLEAN - 192)))) != 0) || ((((_la - 256)) & ~0x3f) == 0 && ((1L << (_la - 256)) & ((1L << (BOOL - 256)) | (1L << (BIT - 256)) | (1L << (VARBIT - 256)) | (1L << (INT1 - 256)) | (1L << (INT2 - 256)) | (1L << (INT4 - 256)) | (1L << (INT8 - 256)) | (1L << (TINYINT - 256)) | (1L << (SMALLINT - 256)) | (1L << (INT - 256)) | (1L << (INTEGER - 256)) | (1L << (BIGINT - 256)) | (1L << (FLOAT4 - 256)) | (1L << (FLOAT8 - 256)) | (1L << (REAL - 256)) | (1L << (FLOAT - 256)) | (1L << (DOUBLE - 256)) | (1L << (NUMERIC - 256)) | (1L << (DECIMAL - 256)) | (1L << (CHAR - 256)) | (1L << (VARCHAR - 256)) | (1L << (NCHAR - 256)) | (1L << (NVARCHAR - 256)) | (1L << (DATE - 256)) | (1L << (TIME - 256)) | (1L << (TIMETZ - 256)) | (1L << (TIMESTAMP - 256)) | (1L << (TIMESTAMPTZ - 256)) | (1L << (TEXT - 256)) | (1L << (UUID - 256)) | (1L << (VARBINARY - 256)) | (1L << (BLOB - 256)) | (1L << (BYTEA - 256)) | (1L << (INET4 - 256)) | (1L << (DOUBLE_QUOTE - 256)))) != 0) || _la==Identifier) {
				{
				{
				setState(1774); ((Create_view_statementContext)_localctx).column_name = identifier();
				setState(1776);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(1775); match(COMMA);
					}
				}

				}
				}
				setState(1782);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1796);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(1783); match(WITH);
				setState(1784); match(LEFT_PAREN);
				setState(1790); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1785); ((Create_view_statementContext)_localctx).view_option_name = identifier();
					setState(1788);
					_la = _input.LA(1);
					if (_la==EQUAL) {
						{
						setState(1786); match(EQUAL);
						setState(1787); ((Create_view_statementContext)_localctx).view_option_value = identifier();
						}
					}

					}
					}
					setState(1792); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (ADMIN - 128)) | (1L << (AVG - 128)) | (1L << (BETWEEN - 128)) | (1L << (BY - 128)) | (1L << (CACHE - 128)) | (1L << (CALLED - 128)) | (1L << (CLASS - 128)) | (1L << (CENTURY - 128)) | (1L << (CHARACTER - 128)) | (1L << (CHECK - 128)) | (1L << (COLLECT - 128)) | (1L << (COALESCE - 128)) | (1L << (COLUMN - 128)) | (1L << (COMMENT - 128)) | (1L << (COMMENTS - 128)) | (1L << (COMMIT - 128)) | (1L << (CONFIGURATION - 128)) | (1L << (COST - 128)) | (1L << (COUNT - 128)) | (1L << (CUBE - 128)) | (1L << (CURRENT - 128)) | (1L << (CYCLE - 128)) | (1L << (DATA - 128)) | (1L << (DAY - 128)) | (1L << (DEC - 128)) | (1L << (DECADE - 128)) | (1L << (DEFINER - 128)) | (1L << (DICTIONARY - 128)) | (1L << (DOW - 128)) | (1L << (DOY - 128)) | (1L << (DROP - 128)) | (1L << (EPOCH - 128)) | (1L << (EVERY - 128)) | (1L << (EXISTS - 128)) | (1L << (EXTERNAL - 128)) | (1L << (EXTRACT - 128)) | (1L << (FAMILY - 128)) | (1L << (FILTER - 128)) | (1L << (FIRST - 128)) | (1L << (FORMAT - 128)) | (1L << (FUSION - 128)) | (1L << (GROUPING - 128)) | (1L << (HASH - 128)) | (1L << (INDEX - 128)) | (1L << (INCREMENT - 128)) | (1L << (INPUT - 128)) | (1L << (INSERT - 128)) | (1L << (INTERSECTION - 128)) | (1L << (ISCACHABLE - 128)) | (1L << (ISODOW - 128)) | (1L << (ISOYEAR - 128)) | (1L << (ISSTRICT - 128)) | (1L << (LANGUAGE - 128)) | (1L << (LARGE - 128)) | (1L << (LAST - 128)) | (1L << (LESS - 128)) | (1L << (LIST - 128)) | (1L << (LOCATION - 128)) | (1L << (MATCH - 128)) | (1L << (MAX - 128)) | (1L << (MAXVALUE - 128)) | (1L << (MICROSECONDS - 128)))) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (MILLENNIUM - 192)) | (1L << (MILLISECONDS - 192)) | (1L << (MIN - 192)) | (1L << (MINVALUE - 192)) | (1L << (MINUTE - 192)) | (1L << (MONTH - 192)) | (1L << (NATIONAL - 192)) | (1L << (NO - 192)) | (1L << (NONE - 192)) | (1L << (NULLIF - 192)) | (1L << (OBJECT - 192)) | (1L << (OPTION - 192)) | (1L << (OPTIONS - 192)) | (1L << (OVERWRITE - 192)) | (1L << (PARSER - 192)) | (1L << (PARTIAL - 192)) | (1L << (PARTITION - 192)) | (1L << (PARTITIONS - 192)) | (1L << (PRECISION - 192)) | (1L << (PUBLIC - 192)) | (1L << (PURGE - 192)) | (1L << (QUARTER - 192)) | (1L << (RANGE - 192)) | (1L << (REGEXP - 192)) | (1L << (RLIKE - 192)) | (1L << (ROLLUP - 192)) | (1L << (SEARCH - 192)) | (1L << (SECOND - 192)) | (1L << (SECURITY - 192)) | (1L << (SERVER - 192)) | (1L << (SET - 192)) | (1L << (SIMILAR - 192)) | (1L << (SIMPLE - 192)) | (1L << (STABLE - 192)) | (1L << (START - 192)) | (1L << (STORAGE - 192)) | (1L << (STDDEV_POP - 192)) | (1L << (STDDEV_SAMP - 192)) | (1L << (SUBPARTITION - 192)) | (1L << (SUM - 192)) | (1L << (TABLESPACE - 192)) | (1L << (TEMPLATE - 192)) | (1L << (THAN - 192)) | (1L << (TIMEZONE - 192)) | (1L << (TIMEZONE_HOUR - 192)) | (1L << (TIMEZONE_MINUTE - 192)) | (1L << (TRIM - 192)) | (1L << (TO - 192)) | (1L << (TYPE - 192)) | (1L << (UNKNOWN - 192)) | (1L << (UNLOGGED - 192)) | (1L << (VALUES - 192)) | (1L << (VAR_SAMP - 192)) | (1L << (VAR_POP - 192)) | (1L << (VARYING - 192)) | (1L << (VOLATILE - 192)) | (1L << (WEEK - 192)) | (1L << (WINDOW - 192)) | (1L << (WRAPPER - 192)) | (1L << (YEAR - 192)) | (1L << (ZONE - 192)) | (1L << (BOOLEAN - 192)))) != 0) || ((((_la - 256)) & ~0x3f) == 0 && ((1L << (_la - 256)) & ((1L << (BOOL - 256)) | (1L << (BIT - 256)) | (1L << (VARBIT - 256)) | (1L << (INT1 - 256)) | (1L << (INT2 - 256)) | (1L << (INT4 - 256)) | (1L << (INT8 - 256)) | (1L << (TINYINT - 256)) | (1L << (SMALLINT - 256)) | (1L << (INT - 256)) | (1L << (INTEGER - 256)) | (1L << (BIGINT - 256)) | (1L << (FLOAT4 - 256)) | (1L << (FLOAT8 - 256)) | (1L << (REAL - 256)) | (1L << (FLOAT - 256)) | (1L << (DOUBLE - 256)) | (1L << (NUMERIC - 256)) | (1L << (DECIMAL - 256)) | (1L << (CHAR - 256)) | (1L << (VARCHAR - 256)) | (1L << (NCHAR - 256)) | (1L << (NVARCHAR - 256)) | (1L << (DATE - 256)) | (1L << (TIME - 256)) | (1L << (TIMETZ - 256)) | (1L << (TIMESTAMP - 256)) | (1L << (TIMESTAMPTZ - 256)) | (1L << (TEXT - 256)) | (1L << (UUID - 256)) | (1L << (VARBINARY - 256)) | (1L << (BLOB - 256)) | (1L << (BYTEA - 256)) | (1L << (INET4 - 256)) | (1L << (DOUBLE_QUOTE - 256)))) != 0) || _la==Identifier );
				setState(1794); match(RIGHT_PAREN);
				}
			}

			setState(1798); match(AS);
			setState(1799); query_specification();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 46, RULE_query);
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
		public IdentifierContext file_type;
		public Token path;
		public IdentifierContext column_name;
		public Data_typeContext datatype;
		public IdentifierContext collation;
		public Column_constraintContext colmn_constraint;
		public Table_constraintContext tabl_constraint;
		public IdentifierContext parent_table;
		public Like_optionContext like_opt;
		public IdentifierContext type_name;
		public Column_constraintContext col_constraint;
		public TerminalNode AS() { return getToken(SQLParser.AS, 0); }
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
		public Param_clauseContext param_clause() {
			return getRuleContext(Param_clauseContext.class,0);
		}
		public TerminalNode WITH(int i) {
			return getToken(SQLParser.WITH, i);
		}
		public TerminalNode INHERITS() { return getToken(SQLParser.INHERITS, 0); }
		public TerminalNode LOCATION() { return getToken(SQLParser.LOCATION, 0); }
		public TerminalNode Character_String_Literal() { return getToken(SQLParser.Character_String_Literal, 0); }
		public TerminalNode LIKE(int i) {
			return getToken(SQLParser.LIKE, i);
		}
		public Table_elementsContext table_elements() {
			return getRuleContext(Table_elementsContext.class,0);
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
		public Query_expressionContext query_expression() {
			return getRuleContext(Query_expressionContext.class,0);
		}
		public TerminalNode TEMP() { return getToken(SQLParser.TEMP, 0); }
		public TerminalNode TABLE() { return getToken(SQLParser.TABLE, 0); }
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
		public Table_partitioning_clausesContext table_partitioning_clauses() {
			return getRuleContext(Table_partitioning_clausesContext.class,0);
		}
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public TerminalNode EXTERNAL() { return getToken(SQLParser.EXTERNAL, 0); }
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
		public TerminalNode USING() { return getToken(SQLParser.USING, 0); }
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
		enterRule(_localctx, 48, RULE_create_table_statement);
		int _la;
		try {
			int _alt;
			setState(1965);
			switch ( getInterpreter().adaptivePredict(_input,276,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1803); match(CREATE);
				setState(1804); match(EXTERNAL);
				setState(1805); match(TABLE);
				setState(1806); ((Create_table_statementContext)_localctx).n = schema_qualified_name();
				setState(1807); table_elements();
				setState(1808); match(USING);
				setState(1809); ((Create_table_statementContext)_localctx).file_type = identifier();
				setState(1811);
				_la = _input.LA(1);
				if (_la==WITH) {
					{
					setState(1810); param_clause();
					}
				}

				setState(1814);
				_la = _input.LA(1);
				if (_la==PARTITION) {
					{
					setState(1813); table_partitioning_clauses();
					}
				}

				{
				setState(1816); match(LOCATION);
				setState(1817); ((Create_table_statementContext)_localctx).path = match(Character_String_Literal);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1819); match(CREATE);
				setState(1820); match(TABLE);
				setState(1821); ((Create_table_statementContext)_localctx).n = schema_qualified_name();
				setState(1822); table_elements();
				setState(1825);
				_la = _input.LA(1);
				if (_la==USING) {
					{
					setState(1823); match(USING);
					setState(1824); ((Create_table_statementContext)_localctx).file_type = identifier();
					}
				}

				setState(1828);
				_la = _input.LA(1);
				if (_la==WITH) {
					{
					setState(1827); param_clause();
					}
				}

				setState(1831);
				switch ( getInterpreter().adaptivePredict(_input,250,_ctx) ) {
				case 1:
					{
					setState(1830); table_partitioning_clauses();
					}
					break;
				}
				setState(1835);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(1833); match(AS);
					setState(1834); query_expression();
					}
				}

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1837); match(CREATE);
				setState(1838); match(TABLE);
				setState(1839); ((Create_table_statementContext)_localctx).n = schema_qualified_name();
				setState(1842);
				_la = _input.LA(1);
				if (_la==USING) {
					{
					setState(1840); match(USING);
					setState(1841); ((Create_table_statementContext)_localctx).file_type = identifier();
					}
				}

				setState(1845);
				_la = _input.LA(1);
				if (_la==WITH) {
					{
					setState(1844); param_clause();
					}
				}

				setState(1848);
				_la = _input.LA(1);
				if (_la==PARTITION) {
					{
					setState(1847); table_partitioning_clauses();
					}
				}

				setState(1850); match(AS);
				setState(1851); query_expression();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1853); match(CREATE);
				setState(1859);
				switch (_input.LA(1)) {
				case GLOBAL:
				case LOCAL:
				case TEMP:
				case TEMPORARY:
					{
					setState(1855);
					_la = _input.LA(1);
					if (_la==GLOBAL || _la==LOCAL) {
						{
						setState(1854);
						_la = _input.LA(1);
						if ( !(_la==GLOBAL || _la==LOCAL) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
					}

					setState(1857);
					_la = _input.LA(1);
					if ( !(_la==TEMP || _la==TEMPORARY) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
					break;
				case UNLOGGED:
					{
					setState(1858); match(UNLOGGED);
					}
					break;
				case TABLE:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1861); match(TABLE);
				setState(1865);
				_la = _input.LA(1);
				if (_la==IF) {
					{
					setState(1862); match(IF);
					setState(1863); match(NOT);
					setState(1864); match(EXISTS);
					}
				}

				setState(1867); ((Create_table_statementContext)_localctx).n = schema_qualified_name();
				setState(1868); match(LEFT_PAREN);
				setState(1899);
				_la = _input.LA(1);
				if (((((_la - 18)) & ~0x3f) == 0 && ((1L << (_la - 18)) & ((1L << (CONSTRAINT - 18)) | (1L << (EXCLUDE - 18)) | (1L << (FOREIGN - 18)) | (1L << (LIKE - 18)))) != 0) || ((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & ((1L << (PRIMARY - 86)) | (1L << (UNIQUE - 86)) | (1L << (ADMIN - 86)) | (1L << (AVG - 86)) | (1L << (BETWEEN - 86)) | (1L << (BY - 86)) | (1L << (CACHE - 86)) | (1L << (CALLED - 86)) | (1L << (CLASS - 86)) | (1L << (CENTURY - 86)) | (1L << (CHARACTER - 86)) | (1L << (CHECK - 86)) | (1L << (COLLECT - 86)) | (1L << (COALESCE - 86)) | (1L << (COLUMN - 86)) | (1L << (COMMENT - 86)) | (1L << (COMMENTS - 86)) | (1L << (COMMIT - 86)) | (1L << (CONFIGURATION - 86)) | (1L << (COST - 86)) | (1L << (COUNT - 86)) | (1L << (CUBE - 86)) | (1L << (CURRENT - 86)) | (1L << (CYCLE - 86)))) != 0) || ((((_la - 150)) & ~0x3f) == 0 && ((1L << (_la - 150)) & ((1L << (DATA - 150)) | (1L << (DAY - 150)) | (1L << (DEC - 150)) | (1L << (DECADE - 150)) | (1L << (DEFINER - 150)) | (1L << (DICTIONARY - 150)) | (1L << (DOW - 150)) | (1L << (DOY - 150)) | (1L << (DROP - 150)) | (1L << (EPOCH - 150)) | (1L << (EVERY - 150)) | (1L << (EXISTS - 150)) | (1L << (EXTERNAL - 150)) | (1L << (EXTRACT - 150)) | (1L << (FAMILY - 150)) | (1L << (FILTER - 150)) | (1L << (FIRST - 150)) | (1L << (FORMAT - 150)) | (1L << (FUSION - 150)) | (1L << (GROUPING - 150)) | (1L << (HASH - 150)) | (1L << (INDEX - 150)) | (1L << (INCREMENT - 150)) | (1L << (INPUT - 150)) | (1L << (INSERT - 150)) | (1L << (INTERSECTION - 150)) | (1L << (ISCACHABLE - 150)) | (1L << (ISODOW - 150)) | (1L << (ISOYEAR - 150)) | (1L << (ISSTRICT - 150)) | (1L << (LANGUAGE - 150)) | (1L << (LARGE - 150)) | (1L << (LAST - 150)) | (1L << (LESS - 150)) | (1L << (LIST - 150)) | (1L << (LOCATION - 150)) | (1L << (MATCH - 150)) | (1L << (MAX - 150)) | (1L << (MAXVALUE - 150)) | (1L << (MICROSECONDS - 150)) | (1L << (MILLENNIUM - 150)) | (1L << (MILLISECONDS - 150)) | (1L << (MIN - 150)) | (1L << (MINVALUE - 150)) | (1L << (MINUTE - 150)) | (1L << (MONTH - 150)) | (1L << (NATIONAL - 150)) | (1L << (NO - 150)) | (1L << (NONE - 150)) | (1L << (NULLIF - 150)) | (1L << (OBJECT - 150)) | (1L << (OPTION - 150)) | (1L << (OPTIONS - 150)) | (1L << (OVERWRITE - 150)) | (1L << (PARSER - 150)) | (1L << (PARTIAL - 150)) | (1L << (PARTITION - 150)) | (1L << (PARTITIONS - 150)) | (1L << (PRECISION - 150)) | (1L << (PUBLIC - 150)) | (1L << (PURGE - 150)) | (1L << (QUARTER - 150)))) != 0) || ((((_la - 214)) & ~0x3f) == 0 && ((1L << (_la - 214)) & ((1L << (RANGE - 214)) | (1L << (REGEXP - 214)) | (1L << (RLIKE - 214)) | (1L << (ROLLUP - 214)) | (1L << (SEARCH - 214)) | (1L << (SECOND - 214)) | (1L << (SECURITY - 214)) | (1L << (SERVER - 214)) | (1L << (SET - 214)) | (1L << (SIMILAR - 214)) | (1L << (SIMPLE - 214)) | (1L << (STABLE - 214)) | (1L << (START - 214)) | (1L << (STORAGE - 214)) | (1L << (STDDEV_POP - 214)) | (1L << (STDDEV_SAMP - 214)) | (1L << (SUBPARTITION - 214)) | (1L << (SUM - 214)) | (1L << (TABLESPACE - 214)) | (1L << (TEMPLATE - 214)) | (1L << (THAN - 214)) | (1L << (TIMEZONE - 214)) | (1L << (TIMEZONE_HOUR - 214)) | (1L << (TIMEZONE_MINUTE - 214)) | (1L << (TRIM - 214)) | (1L << (TO - 214)) | (1L << (TYPE - 214)) | (1L << (UNKNOWN - 214)) | (1L << (UNLOGGED - 214)) | (1L << (VALUES - 214)) | (1L << (VAR_SAMP - 214)) | (1L << (VAR_POP - 214)) | (1L << (VARYING - 214)) | (1L << (VOLATILE - 214)) | (1L << (WEEK - 214)) | (1L << (WINDOW - 214)) | (1L << (WRAPPER - 214)) | (1L << (YEAR - 214)) | (1L << (ZONE - 214)) | (1L << (BOOLEAN - 214)) | (1L << (BOOL - 214)) | (1L << (BIT - 214)) | (1L << (VARBIT - 214)) | (1L << (INT1 - 214)) | (1L << (INT2 - 214)) | (1L << (INT4 - 214)) | (1L << (INT8 - 214)) | (1L << (TINYINT - 214)) | (1L << (SMALLINT - 214)) | (1L << (INT - 214)) | (1L << (INTEGER - 214)) | (1L << (BIGINT - 214)) | (1L << (FLOAT4 - 214)) | (1L << (FLOAT8 - 214)) | (1L << (REAL - 214)) | (1L << (FLOAT - 214)) | (1L << (DOUBLE - 214)) | (1L << (NUMERIC - 214)) | (1L << (DECIMAL - 214)) | (1L << (CHAR - 214)) | (1L << (VARCHAR - 214)))) != 0) || ((((_la - 278)) & ~0x3f) == 0 && ((1L << (_la - 278)) & ((1L << (NCHAR - 278)) | (1L << (NVARCHAR - 278)) | (1L << (DATE - 278)) | (1L << (TIME - 278)) | (1L << (TIMETZ - 278)) | (1L << (TIMESTAMP - 278)) | (1L << (TIMESTAMPTZ - 278)) | (1L << (TEXT - 278)) | (1L << (UUID - 278)) | (1L << (VARBINARY - 278)) | (1L << (BLOB - 278)) | (1L << (BYTEA - 278)) | (1L << (INET4 - 278)) | (1L << (DOUBLE_QUOTE - 278)) | (1L << (Identifier - 278)))) != 0)) {
					{
					setState(1895); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1890);
						switch ( getInterpreter().adaptivePredict(_input,261,_ctx) ) {
						case 1:
							{
							{
							setState(1869); ((Create_table_statementContext)_localctx).column_name = identifier();
							setState(1870); ((Create_table_statementContext)_localctx).datatype = data_type();
							setState(1873);
							_la = _input.LA(1);
							if (_la==COLLATE) {
								{
								setState(1871); match(COLLATE);
								setState(1872); ((Create_table_statementContext)_localctx).collation = identifier();
								}
							}

							setState(1878);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,259,_ctx);
							while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
								if ( _alt==1 ) {
									{
									{
									setState(1875); ((Create_table_statementContext)_localctx).colmn_constraint = column_constraint();
									}
									} 
								}
								setState(1880);
								_errHandler.sync(this);
								_alt = getInterpreter().adaptivePredict(_input,259,_ctx);
							}
							}
							}
							break;
						case 2:
							{
							setState(1881); ((Create_table_statementContext)_localctx).tabl_constraint = table_constraint();
							}
							break;
						case 3:
							{
							{
							setState(1882); match(LIKE);
							setState(1883); ((Create_table_statementContext)_localctx).parent_table = identifier();
							setState(1887);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==EXCLUDING || _la==INCLUDING) {
								{
								{
								setState(1884); ((Create_table_statementContext)_localctx).like_opt = like_option();
								}
								}
								setState(1889);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
							}
							break;
						}
						setState(1893);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1892); match(COMMA);
							}
						}

						}
						}
						setState(1897); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 18)) & ~0x3f) == 0 && ((1L << (_la - 18)) & ((1L << (CONSTRAINT - 18)) | (1L << (EXCLUDE - 18)) | (1L << (FOREIGN - 18)) | (1L << (LIKE - 18)))) != 0) || ((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & ((1L << (PRIMARY - 86)) | (1L << (UNIQUE - 86)) | (1L << (ADMIN - 86)) | (1L << (AVG - 86)) | (1L << (BETWEEN - 86)) | (1L << (BY - 86)) | (1L << (CACHE - 86)) | (1L << (CALLED - 86)) | (1L << (CLASS - 86)) | (1L << (CENTURY - 86)) | (1L << (CHARACTER - 86)) | (1L << (CHECK - 86)) | (1L << (COLLECT - 86)) | (1L << (COALESCE - 86)) | (1L << (COLUMN - 86)) | (1L << (COMMENT - 86)) | (1L << (COMMENTS - 86)) | (1L << (COMMIT - 86)) | (1L << (CONFIGURATION - 86)) | (1L << (COST - 86)) | (1L << (COUNT - 86)) | (1L << (CUBE - 86)) | (1L << (CURRENT - 86)) | (1L << (CYCLE - 86)))) != 0) || ((((_la - 150)) & ~0x3f) == 0 && ((1L << (_la - 150)) & ((1L << (DATA - 150)) | (1L << (DAY - 150)) | (1L << (DEC - 150)) | (1L << (DECADE - 150)) | (1L << (DEFINER - 150)) | (1L << (DICTIONARY - 150)) | (1L << (DOW - 150)) | (1L << (DOY - 150)) | (1L << (DROP - 150)) | (1L << (EPOCH - 150)) | (1L << (EVERY - 150)) | (1L << (EXISTS - 150)) | (1L << (EXTERNAL - 150)) | (1L << (EXTRACT - 150)) | (1L << (FAMILY - 150)) | (1L << (FILTER - 150)) | (1L << (FIRST - 150)) | (1L << (FORMAT - 150)) | (1L << (FUSION - 150)) | (1L << (GROUPING - 150)) | (1L << (HASH - 150)) | (1L << (INDEX - 150)) | (1L << (INCREMENT - 150)) | (1L << (INPUT - 150)) | (1L << (INSERT - 150)) | (1L << (INTERSECTION - 150)) | (1L << (ISCACHABLE - 150)) | (1L << (ISODOW - 150)) | (1L << (ISOYEAR - 150)) | (1L << (ISSTRICT - 150)) | (1L << (LANGUAGE - 150)) | (1L << (LARGE - 150)) | (1L << (LAST - 150)) | (1L << (LESS - 150)) | (1L << (LIST - 150)) | (1L << (LOCATION - 150)) | (1L << (MATCH - 150)) | (1L << (MAX - 150)) | (1L << (MAXVALUE - 150)) | (1L << (MICROSECONDS - 150)) | (1L << (MILLENNIUM - 150)) | (1L << (MILLISECONDS - 150)) | (1L << (MIN - 150)) | (1L << (MINVALUE - 150)) | (1L << (MINUTE - 150)) | (1L << (MONTH - 150)) | (1L << (NATIONAL - 150)) | (1L << (NO - 150)) | (1L << (NONE - 150)) | (1L << (NULLIF - 150)) | (1L << (OBJECT - 150)) | (1L << (OPTION - 150)) | (1L << (OPTIONS - 150)) | (1L << (OVERWRITE - 150)) | (1L << (PARSER - 150)) | (1L << (PARTIAL - 150)) | (1L << (PARTITION - 150)) | (1L << (PARTITIONS - 150)) | (1L << (PRECISION - 150)) | (1L << (PUBLIC - 150)) | (1L << (PURGE - 150)) | (1L << (QUARTER - 150)))) != 0) || ((((_la - 214)) & ~0x3f) == 0 && ((1L << (_la - 214)) & ((1L << (RANGE - 214)) | (1L << (REGEXP - 214)) | (1L << (RLIKE - 214)) | (1L << (ROLLUP - 214)) | (1L << (SEARCH - 214)) | (1L << (SECOND - 214)) | (1L << (SECURITY - 214)) | (1L << (SERVER - 214)) | (1L << (SET - 214)) | (1L << (SIMILAR - 214)) | (1L << (SIMPLE - 214)) | (1L << (STABLE - 214)) | (1L << (START - 214)) | (1L << (STORAGE - 214)) | (1L << (STDDEV_POP - 214)) | (1L << (STDDEV_SAMP - 214)) | (1L << (SUBPARTITION - 214)) | (1L << (SUM - 214)) | (1L << (TABLESPACE - 214)) | (1L << (TEMPLATE - 214)) | (1L << (THAN - 214)) | (1L << (TIMEZONE - 214)) | (1L << (TIMEZONE_HOUR - 214)) | (1L << (TIMEZONE_MINUTE - 214)) | (1L << (TRIM - 214)) | (1L << (TO - 214)) | (1L << (TYPE - 214)) | (1L << (UNKNOWN - 214)) | (1L << (UNLOGGED - 214)) | (1L << (VALUES - 214)) | (1L << (VAR_SAMP - 214)) | (1L << (VAR_POP - 214)) | (1L << (VARYING - 214)) | (1L << (VOLATILE - 214)) | (1L << (WEEK - 214)) | (1L << (WINDOW - 214)) | (1L << (WRAPPER - 214)) | (1L << (YEAR - 214)) | (1L << (ZONE - 214)) | (1L << (BOOLEAN - 214)) | (1L << (BOOL - 214)) | (1L << (BIT - 214)) | (1L << (VARBIT - 214)) | (1L << (INT1 - 214)) | (1L << (INT2 - 214)) | (1L << (INT4 - 214)) | (1L << (INT8 - 214)) | (1L << (TINYINT - 214)) | (1L << (SMALLINT - 214)) | (1L << (INT - 214)) | (1L << (INTEGER - 214)) | (1L << (BIGINT - 214)) | (1L << (FLOAT4 - 214)) | (1L << (FLOAT8 - 214)) | (1L << (REAL - 214)) | (1L << (FLOAT - 214)) | (1L << (DOUBLE - 214)) | (1L << (NUMERIC - 214)) | (1L << (DECIMAL - 214)) | (1L << (CHAR - 214)) | (1L << (VARCHAR - 214)))) != 0) || ((((_la - 278)) & ~0x3f) == 0 && ((1L << (_la - 278)) & ((1L << (NCHAR - 278)) | (1L << (NVARCHAR - 278)) | (1L << (DATE - 278)) | (1L << (TIME - 278)) | (1L << (TIMETZ - 278)) | (1L << (TIMESTAMP - 278)) | (1L << (TIMESTAMPTZ - 278)) | (1L << (TEXT - 278)) | (1L << (UUID - 278)) | (1L << (VARBINARY - 278)) | (1L << (BLOB - 278)) | (1L << (BYTEA - 278)) | (1L << (INET4 - 278)) | (1L << (DOUBLE_QUOTE - 278)) | (1L << (Identifier - 278)))) != 0) );
					}
				}

				setState(1901); match(RIGHT_PAREN);
				setState(1914);
				_la = _input.LA(1);
				if (_la==INHERITS) {
					{
					setState(1902); match(INHERITS);
					setState(1903); match(LEFT_PAREN);
					setState(1908); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1904); ((Create_table_statementContext)_localctx).parent_table = identifier();
						setState(1906);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1905); match(COMMA);
							}
						}

						}
						}
						setState(1910); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (ADMIN - 128)) | (1L << (AVG - 128)) | (1L << (BETWEEN - 128)) | (1L << (BY - 128)) | (1L << (CACHE - 128)) | (1L << (CALLED - 128)) | (1L << (CLASS - 128)) | (1L << (CENTURY - 128)) | (1L << (CHARACTER - 128)) | (1L << (CHECK - 128)) | (1L << (COLLECT - 128)) | (1L << (COALESCE - 128)) | (1L << (COLUMN - 128)) | (1L << (COMMENT - 128)) | (1L << (COMMENTS - 128)) | (1L << (COMMIT - 128)) | (1L << (CONFIGURATION - 128)) | (1L << (COST - 128)) | (1L << (COUNT - 128)) | (1L << (CUBE - 128)) | (1L << (CURRENT - 128)) | (1L << (CYCLE - 128)) | (1L << (DATA - 128)) | (1L << (DAY - 128)) | (1L << (DEC - 128)) | (1L << (DECADE - 128)) | (1L << (DEFINER - 128)) | (1L << (DICTIONARY - 128)) | (1L << (DOW - 128)) | (1L << (DOY - 128)) | (1L << (DROP - 128)) | (1L << (EPOCH - 128)) | (1L << (EVERY - 128)) | (1L << (EXISTS - 128)) | (1L << (EXTERNAL - 128)) | (1L << (EXTRACT - 128)) | (1L << (FAMILY - 128)) | (1L << (FILTER - 128)) | (1L << (FIRST - 128)) | (1L << (FORMAT - 128)) | (1L << (FUSION - 128)) | (1L << (GROUPING - 128)) | (1L << (HASH - 128)) | (1L << (INDEX - 128)) | (1L << (INCREMENT - 128)) | (1L << (INPUT - 128)) | (1L << (INSERT - 128)) | (1L << (INTERSECTION - 128)) | (1L << (ISCACHABLE - 128)) | (1L << (ISODOW - 128)) | (1L << (ISOYEAR - 128)) | (1L << (ISSTRICT - 128)) | (1L << (LANGUAGE - 128)) | (1L << (LARGE - 128)) | (1L << (LAST - 128)) | (1L << (LESS - 128)) | (1L << (LIST - 128)) | (1L << (LOCATION - 128)) | (1L << (MATCH - 128)) | (1L << (MAX - 128)) | (1L << (MAXVALUE - 128)) | (1L << (MICROSECONDS - 128)))) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (MILLENNIUM - 192)) | (1L << (MILLISECONDS - 192)) | (1L << (MIN - 192)) | (1L << (MINVALUE - 192)) | (1L << (MINUTE - 192)) | (1L << (MONTH - 192)) | (1L << (NATIONAL - 192)) | (1L << (NO - 192)) | (1L << (NONE - 192)) | (1L << (NULLIF - 192)) | (1L << (OBJECT - 192)) | (1L << (OPTION - 192)) | (1L << (OPTIONS - 192)) | (1L << (OVERWRITE - 192)) | (1L << (PARSER - 192)) | (1L << (PARTIAL - 192)) | (1L << (PARTITION - 192)) | (1L << (PARTITIONS - 192)) | (1L << (PRECISION - 192)) | (1L << (PUBLIC - 192)) | (1L << (PURGE - 192)) | (1L << (QUARTER - 192)) | (1L << (RANGE - 192)) | (1L << (REGEXP - 192)) | (1L << (RLIKE - 192)) | (1L << (ROLLUP - 192)) | (1L << (SEARCH - 192)) | (1L << (SECOND - 192)) | (1L << (SECURITY - 192)) | (1L << (SERVER - 192)) | (1L << (SET - 192)) | (1L << (SIMILAR - 192)) | (1L << (SIMPLE - 192)) | (1L << (STABLE - 192)) | (1L << (START - 192)) | (1L << (STORAGE - 192)) | (1L << (STDDEV_POP - 192)) | (1L << (STDDEV_SAMP - 192)) | (1L << (SUBPARTITION - 192)) | (1L << (SUM - 192)) | (1L << (TABLESPACE - 192)) | (1L << (TEMPLATE - 192)) | (1L << (THAN - 192)) | (1L << (TIMEZONE - 192)) | (1L << (TIMEZONE_HOUR - 192)) | (1L << (TIMEZONE_MINUTE - 192)) | (1L << (TRIM - 192)) | (1L << (TO - 192)) | (1L << (TYPE - 192)) | (1L << (UNKNOWN - 192)) | (1L << (UNLOGGED - 192)) | (1L << (VALUES - 192)) | (1L << (VAR_SAMP - 192)) | (1L << (VAR_POP - 192)) | (1L << (VARYING - 192)) | (1L << (VOLATILE - 192)) | (1L << (WEEK - 192)) | (1L << (WINDOW - 192)) | (1L << (WRAPPER - 192)) | (1L << (YEAR - 192)) | (1L << (ZONE - 192)) | (1L << (BOOLEAN - 192)))) != 0) || ((((_la - 256)) & ~0x3f) == 0 && ((1L << (_la - 256)) & ((1L << (BOOL - 256)) | (1L << (BIT - 256)) | (1L << (VARBIT - 256)) | (1L << (INT1 - 256)) | (1L << (INT2 - 256)) | (1L << (INT4 - 256)) | (1L << (INT8 - 256)) | (1L << (TINYINT - 256)) | (1L << (SMALLINT - 256)) | (1L << (INT - 256)) | (1L << (INTEGER - 256)) | (1L << (BIGINT - 256)) | (1L << (FLOAT4 - 256)) | (1L << (FLOAT8 - 256)) | (1L << (REAL - 256)) | (1L << (FLOAT - 256)) | (1L << (DOUBLE - 256)) | (1L << (NUMERIC - 256)) | (1L << (DECIMAL - 256)) | (1L << (CHAR - 256)) | (1L << (VARCHAR - 256)) | (1L << (NCHAR - 256)) | (1L << (NVARCHAR - 256)) | (1L << (DATE - 256)) | (1L << (TIME - 256)) | (1L << (TIMETZ - 256)) | (1L << (TIMESTAMP - 256)) | (1L << (TIMESTAMPTZ - 256)) | (1L << (TEXT - 256)) | (1L << (UUID - 256)) | (1L << (VARBINARY - 256)) | (1L << (BLOB - 256)) | (1L << (BYTEA - 256)) | (1L << (INET4 - 256)) | (1L << (DOUBLE_QUOTE - 256)))) != 0) || _la==Identifier );
					setState(1912); match(RIGHT_PAREN);
					}
				}

				setState(1916); storage_parameter_oid();
				setState(1917); on_commit();
				setState(1918); table_space();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1920); match(CREATE);
				setState(1926);
				switch (_input.LA(1)) {
				case GLOBAL:
				case LOCAL:
				case TEMP:
				case TEMPORARY:
					{
					setState(1922);
					_la = _input.LA(1);
					if (_la==GLOBAL || _la==LOCAL) {
						{
						setState(1921);
						_la = _input.LA(1);
						if ( !(_la==GLOBAL || _la==LOCAL) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
					}

					setState(1924);
					_la = _input.LA(1);
					if ( !(_la==TEMP || _la==TEMPORARY) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
					break;
				case UNLOGGED:
					{
					setState(1925); match(UNLOGGED);
					}
					break;
				case TABLE:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1928); match(TABLE);
				setState(1932);
				_la = _input.LA(1);
				if (_la==IF) {
					{
					setState(1929); match(IF);
					setState(1930); match(NOT);
					setState(1931); match(EXISTS);
					}
				}

				setState(1934); ((Create_table_statementContext)_localctx).n = schema_qualified_name();
				setState(1935); match(OF);
				setState(1936); ((Create_table_statementContext)_localctx).type_name = identifier();
				setState(1959);
				switch ( getInterpreter().adaptivePredict(_input,275,_ctx) ) {
				case 1:
					{
					setState(1937); match(LEFT_PAREN);
					setState(1953); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1948);
						switch ( getInterpreter().adaptivePredict(_input,272,_ctx) ) {
						case 1:
							{
							{
							setState(1938); ((Create_table_statementContext)_localctx).column_name = identifier();
							setState(1939); match(WITH);
							setState(1940); match(OPTIONS);
							setState(1944);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,271,_ctx);
							while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
								if ( _alt==1 ) {
									{
									{
									setState(1941); ((Create_table_statementContext)_localctx).col_constraint = column_constraint();
									}
									} 
								}
								setState(1946);
								_errHandler.sync(this);
								_alt = getInterpreter().adaptivePredict(_input,271,_ctx);
							}
							}
							}
							break;
						case 2:
							{
							setState(1947); table_constraint();
							}
							break;
						}
						setState(1951);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1950); match(COMMA);
							}
						}

						}
						}
						setState(1955); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CONSTRAINT) | (1L << EXCLUDE) | (1L << FOREIGN))) != 0) || ((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & ((1L << (PRIMARY - 86)) | (1L << (UNIQUE - 86)) | (1L << (ADMIN - 86)) | (1L << (AVG - 86)) | (1L << (BETWEEN - 86)) | (1L << (BY - 86)) | (1L << (CACHE - 86)) | (1L << (CALLED - 86)) | (1L << (CLASS - 86)) | (1L << (CENTURY - 86)) | (1L << (CHARACTER - 86)) | (1L << (CHECK - 86)) | (1L << (COLLECT - 86)) | (1L << (COALESCE - 86)) | (1L << (COLUMN - 86)) | (1L << (COMMENT - 86)) | (1L << (COMMENTS - 86)) | (1L << (COMMIT - 86)) | (1L << (CONFIGURATION - 86)) | (1L << (COST - 86)) | (1L << (COUNT - 86)) | (1L << (CUBE - 86)) | (1L << (CURRENT - 86)) | (1L << (CYCLE - 86)))) != 0) || ((((_la - 150)) & ~0x3f) == 0 && ((1L << (_la - 150)) & ((1L << (DATA - 150)) | (1L << (DAY - 150)) | (1L << (DEC - 150)) | (1L << (DECADE - 150)) | (1L << (DEFINER - 150)) | (1L << (DICTIONARY - 150)) | (1L << (DOW - 150)) | (1L << (DOY - 150)) | (1L << (DROP - 150)) | (1L << (EPOCH - 150)) | (1L << (EVERY - 150)) | (1L << (EXISTS - 150)) | (1L << (EXTERNAL - 150)) | (1L << (EXTRACT - 150)) | (1L << (FAMILY - 150)) | (1L << (FILTER - 150)) | (1L << (FIRST - 150)) | (1L << (FORMAT - 150)) | (1L << (FUSION - 150)) | (1L << (GROUPING - 150)) | (1L << (HASH - 150)) | (1L << (INDEX - 150)) | (1L << (INCREMENT - 150)) | (1L << (INPUT - 150)) | (1L << (INSERT - 150)) | (1L << (INTERSECTION - 150)) | (1L << (ISCACHABLE - 150)) | (1L << (ISODOW - 150)) | (1L << (ISOYEAR - 150)) | (1L << (ISSTRICT - 150)) | (1L << (LANGUAGE - 150)) | (1L << (LARGE - 150)) | (1L << (LAST - 150)) | (1L << (LESS - 150)) | (1L << (LIST - 150)) | (1L << (LOCATION - 150)) | (1L << (MATCH - 150)) | (1L << (MAX - 150)) | (1L << (MAXVALUE - 150)) | (1L << (MICROSECONDS - 150)) | (1L << (MILLENNIUM - 150)) | (1L << (MILLISECONDS - 150)) | (1L << (MIN - 150)) | (1L << (MINVALUE - 150)) | (1L << (MINUTE - 150)) | (1L << (MONTH - 150)) | (1L << (NATIONAL - 150)) | (1L << (NO - 150)) | (1L << (NONE - 150)) | (1L << (NULLIF - 150)) | (1L << (OBJECT - 150)) | (1L << (OPTION - 150)) | (1L << (OPTIONS - 150)) | (1L << (OVERWRITE - 150)) | (1L << (PARSER - 150)) | (1L << (PARTIAL - 150)) | (1L << (PARTITION - 150)) | (1L << (PARTITIONS - 150)) | (1L << (PRECISION - 150)) | (1L << (PUBLIC - 150)) | (1L << (PURGE - 150)) | (1L << (QUARTER - 150)))) != 0) || ((((_la - 214)) & ~0x3f) == 0 && ((1L << (_la - 214)) & ((1L << (RANGE - 214)) | (1L << (REGEXP - 214)) | (1L << (RLIKE - 214)) | (1L << (ROLLUP - 214)) | (1L << (SEARCH - 214)) | (1L << (SECOND - 214)) | (1L << (SECURITY - 214)) | (1L << (SERVER - 214)) | (1L << (SET - 214)) | (1L << (SIMILAR - 214)) | (1L << (SIMPLE - 214)) | (1L << (STABLE - 214)) | (1L << (START - 214)) | (1L << (STORAGE - 214)) | (1L << (STDDEV_POP - 214)) | (1L << (STDDEV_SAMP - 214)) | (1L << (SUBPARTITION - 214)) | (1L << (SUM - 214)) | (1L << (TABLESPACE - 214)) | (1L << (TEMPLATE - 214)) | (1L << (THAN - 214)) | (1L << (TIMEZONE - 214)) | (1L << (TIMEZONE_HOUR - 214)) | (1L << (TIMEZONE_MINUTE - 214)) | (1L << (TRIM - 214)) | (1L << (TO - 214)) | (1L << (TYPE - 214)) | (1L << (UNKNOWN - 214)) | (1L << (UNLOGGED - 214)) | (1L << (VALUES - 214)) | (1L << (VAR_SAMP - 214)) | (1L << (VAR_POP - 214)) | (1L << (VARYING - 214)) | (1L << (VOLATILE - 214)) | (1L << (WEEK - 214)) | (1L << (WINDOW - 214)) | (1L << (WRAPPER - 214)) | (1L << (YEAR - 214)) | (1L << (ZONE - 214)) | (1L << (BOOLEAN - 214)) | (1L << (BOOL - 214)) | (1L << (BIT - 214)) | (1L << (VARBIT - 214)) | (1L << (INT1 - 214)) | (1L << (INT2 - 214)) | (1L << (INT4 - 214)) | (1L << (INT8 - 214)) | (1L << (TINYINT - 214)) | (1L << (SMALLINT - 214)) | (1L << (INT - 214)) | (1L << (INTEGER - 214)) | (1L << (BIGINT - 214)) | (1L << (FLOAT4 - 214)) | (1L << (FLOAT8 - 214)) | (1L << (REAL - 214)) | (1L << (FLOAT - 214)) | (1L << (DOUBLE - 214)) | (1L << (NUMERIC - 214)) | (1L << (DECIMAL - 214)) | (1L << (CHAR - 214)) | (1L << (VARCHAR - 214)))) != 0) || ((((_la - 278)) & ~0x3f) == 0 && ((1L << (_la - 278)) & ((1L << (NCHAR - 278)) | (1L << (NVARCHAR - 278)) | (1L << (DATE - 278)) | (1L << (TIME - 278)) | (1L << (TIMETZ - 278)) | (1L << (TIMESTAMP - 278)) | (1L << (TIMESTAMPTZ - 278)) | (1L << (TEXT - 278)) | (1L << (UUID - 278)) | (1L << (VARBINARY - 278)) | (1L << (BLOB - 278)) | (1L << (BYTEA - 278)) | (1L << (INET4 - 278)) | (1L << (DOUBLE_QUOTE - 278)) | (1L << (Identifier - 278)))) != 0) );
					setState(1957); match(RIGHT_PAREN);
					}
					break;
				}
				setState(1961); storage_parameter_oid();
				setState(1962); on_commit();
				setState(1963); table_space();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 50, RULE_like_option);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1967);
			_la = _input.LA(1);
			if ( !(_la==EXCLUDING || _la==INCLUDING) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(1968);
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
		enterRule(_localctx, 52, RULE_table_constraint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1972);
			_la = _input.LA(1);
			if (_la==CONSTRAINT) {
				{
				setState(1970); match(CONSTRAINT);
				setState(1971); ((Table_constraintContext)_localctx).constraint_name = identifier();
				}
			}

			setState(2072);
			switch (_input.LA(1)) {
			case CHECK:
				{
				setState(1974); check_boolean_expression();
				}
				break;
			case UNIQUE:
				{
				{
				setState(1975); match(UNIQUE);
				setState(1976); match(LEFT_PAREN);
				setState(1981); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1977); ((Table_constraintContext)_localctx).column_name_unique = identifier();
					setState(1979);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1978); match(COMMA);
						}
					}

					}
					}
					setState(1983); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (ADMIN - 128)) | (1L << (AVG - 128)) | (1L << (BETWEEN - 128)) | (1L << (BY - 128)) | (1L << (CACHE - 128)) | (1L << (CALLED - 128)) | (1L << (CLASS - 128)) | (1L << (CENTURY - 128)) | (1L << (CHARACTER - 128)) | (1L << (CHECK - 128)) | (1L << (COLLECT - 128)) | (1L << (COALESCE - 128)) | (1L << (COLUMN - 128)) | (1L << (COMMENT - 128)) | (1L << (COMMENTS - 128)) | (1L << (COMMIT - 128)) | (1L << (CONFIGURATION - 128)) | (1L << (COST - 128)) | (1L << (COUNT - 128)) | (1L << (CUBE - 128)) | (1L << (CURRENT - 128)) | (1L << (CYCLE - 128)) | (1L << (DATA - 128)) | (1L << (DAY - 128)) | (1L << (DEC - 128)) | (1L << (DECADE - 128)) | (1L << (DEFINER - 128)) | (1L << (DICTIONARY - 128)) | (1L << (DOW - 128)) | (1L << (DOY - 128)) | (1L << (DROP - 128)) | (1L << (EPOCH - 128)) | (1L << (EVERY - 128)) | (1L << (EXISTS - 128)) | (1L << (EXTERNAL - 128)) | (1L << (EXTRACT - 128)) | (1L << (FAMILY - 128)) | (1L << (FILTER - 128)) | (1L << (FIRST - 128)) | (1L << (FORMAT - 128)) | (1L << (FUSION - 128)) | (1L << (GROUPING - 128)) | (1L << (HASH - 128)) | (1L << (INDEX - 128)) | (1L << (INCREMENT - 128)) | (1L << (INPUT - 128)) | (1L << (INSERT - 128)) | (1L << (INTERSECTION - 128)) | (1L << (ISCACHABLE - 128)) | (1L << (ISODOW - 128)) | (1L << (ISOYEAR - 128)) | (1L << (ISSTRICT - 128)) | (1L << (LANGUAGE - 128)) | (1L << (LARGE - 128)) | (1L << (LAST - 128)) | (1L << (LESS - 128)) | (1L << (LIST - 128)) | (1L << (LOCATION - 128)) | (1L << (MATCH - 128)) | (1L << (MAX - 128)) | (1L << (MAXVALUE - 128)) | (1L << (MICROSECONDS - 128)))) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (MILLENNIUM - 192)) | (1L << (MILLISECONDS - 192)) | (1L << (MIN - 192)) | (1L << (MINVALUE - 192)) | (1L << (MINUTE - 192)) | (1L << (MONTH - 192)) | (1L << (NATIONAL - 192)) | (1L << (NO - 192)) | (1L << (NONE - 192)) | (1L << (NULLIF - 192)) | (1L << (OBJECT - 192)) | (1L << (OPTION - 192)) | (1L << (OPTIONS - 192)) | (1L << (OVERWRITE - 192)) | (1L << (PARSER - 192)) | (1L << (PARTIAL - 192)) | (1L << (PARTITION - 192)) | (1L << (PARTITIONS - 192)) | (1L << (PRECISION - 192)) | (1L << (PUBLIC - 192)) | (1L << (PURGE - 192)) | (1L << (QUARTER - 192)) | (1L << (RANGE - 192)) | (1L << (REGEXP - 192)) | (1L << (RLIKE - 192)) | (1L << (ROLLUP - 192)) | (1L << (SEARCH - 192)) | (1L << (SECOND - 192)) | (1L << (SECURITY - 192)) | (1L << (SERVER - 192)) | (1L << (SET - 192)) | (1L << (SIMILAR - 192)) | (1L << (SIMPLE - 192)) | (1L << (STABLE - 192)) | (1L << (START - 192)) | (1L << (STORAGE - 192)) | (1L << (STDDEV_POP - 192)) | (1L << (STDDEV_SAMP - 192)) | (1L << (SUBPARTITION - 192)) | (1L << (SUM - 192)) | (1L << (TABLESPACE - 192)) | (1L << (TEMPLATE - 192)) | (1L << (THAN - 192)) | (1L << (TIMEZONE - 192)) | (1L << (TIMEZONE_HOUR - 192)) | (1L << (TIMEZONE_MINUTE - 192)) | (1L << (TRIM - 192)) | (1L << (TO - 192)) | (1L << (TYPE - 192)) | (1L << (UNKNOWN - 192)) | (1L << (UNLOGGED - 192)) | (1L << (VALUES - 192)) | (1L << (VAR_SAMP - 192)) | (1L << (VAR_POP - 192)) | (1L << (VARYING - 192)) | (1L << (VOLATILE - 192)) | (1L << (WEEK - 192)) | (1L << (WINDOW - 192)) | (1L << (WRAPPER - 192)) | (1L << (YEAR - 192)) | (1L << (ZONE - 192)) | (1L << (BOOLEAN - 192)))) != 0) || ((((_la - 256)) & ~0x3f) == 0 && ((1L << (_la - 256)) & ((1L << (BOOL - 256)) | (1L << (BIT - 256)) | (1L << (VARBIT - 256)) | (1L << (INT1 - 256)) | (1L << (INT2 - 256)) | (1L << (INT4 - 256)) | (1L << (INT8 - 256)) | (1L << (TINYINT - 256)) | (1L << (SMALLINT - 256)) | (1L << (INT - 256)) | (1L << (INTEGER - 256)) | (1L << (BIGINT - 256)) | (1L << (FLOAT4 - 256)) | (1L << (FLOAT8 - 256)) | (1L << (REAL - 256)) | (1L << (FLOAT - 256)) | (1L << (DOUBLE - 256)) | (1L << (NUMERIC - 256)) | (1L << (DECIMAL - 256)) | (1L << (CHAR - 256)) | (1L << (VARCHAR - 256)) | (1L << (NCHAR - 256)) | (1L << (NVARCHAR - 256)) | (1L << (DATE - 256)) | (1L << (TIME - 256)) | (1L << (TIMETZ - 256)) | (1L << (TIMESTAMP - 256)) | (1L << (TIMESTAMPTZ - 256)) | (1L << (TEXT - 256)) | (1L << (UUID - 256)) | (1L << (VARBINARY - 256)) | (1L << (BLOB - 256)) | (1L << (BYTEA - 256)) | (1L << (INET4 - 256)) | (1L << (DOUBLE_QUOTE - 256)))) != 0) || _la==Identifier );
				setState(1985); match(RIGHT_PAREN);
				setState(1986); ((Table_constraintContext)_localctx).index_parameters_unique = index_parameters();
				}
				}
				break;
			case PRIMARY:
				{
				{
				setState(1988); match(PRIMARY);
				setState(1989); match(KEY);
				setState(1990); match(LEFT_PAREN);
				setState(1995); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1991); ((Table_constraintContext)_localctx).column_name_pr_key = identifier();
					setState(1993);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1992); match(COMMA);
						}
					}

					}
					}
					setState(1997); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (ADMIN - 128)) | (1L << (AVG - 128)) | (1L << (BETWEEN - 128)) | (1L << (BY - 128)) | (1L << (CACHE - 128)) | (1L << (CALLED - 128)) | (1L << (CLASS - 128)) | (1L << (CENTURY - 128)) | (1L << (CHARACTER - 128)) | (1L << (CHECK - 128)) | (1L << (COLLECT - 128)) | (1L << (COALESCE - 128)) | (1L << (COLUMN - 128)) | (1L << (COMMENT - 128)) | (1L << (COMMENTS - 128)) | (1L << (COMMIT - 128)) | (1L << (CONFIGURATION - 128)) | (1L << (COST - 128)) | (1L << (COUNT - 128)) | (1L << (CUBE - 128)) | (1L << (CURRENT - 128)) | (1L << (CYCLE - 128)) | (1L << (DATA - 128)) | (1L << (DAY - 128)) | (1L << (DEC - 128)) | (1L << (DECADE - 128)) | (1L << (DEFINER - 128)) | (1L << (DICTIONARY - 128)) | (1L << (DOW - 128)) | (1L << (DOY - 128)) | (1L << (DROP - 128)) | (1L << (EPOCH - 128)) | (1L << (EVERY - 128)) | (1L << (EXISTS - 128)) | (1L << (EXTERNAL - 128)) | (1L << (EXTRACT - 128)) | (1L << (FAMILY - 128)) | (1L << (FILTER - 128)) | (1L << (FIRST - 128)) | (1L << (FORMAT - 128)) | (1L << (FUSION - 128)) | (1L << (GROUPING - 128)) | (1L << (HASH - 128)) | (1L << (INDEX - 128)) | (1L << (INCREMENT - 128)) | (1L << (INPUT - 128)) | (1L << (INSERT - 128)) | (1L << (INTERSECTION - 128)) | (1L << (ISCACHABLE - 128)) | (1L << (ISODOW - 128)) | (1L << (ISOYEAR - 128)) | (1L << (ISSTRICT - 128)) | (1L << (LANGUAGE - 128)) | (1L << (LARGE - 128)) | (1L << (LAST - 128)) | (1L << (LESS - 128)) | (1L << (LIST - 128)) | (1L << (LOCATION - 128)) | (1L << (MATCH - 128)) | (1L << (MAX - 128)) | (1L << (MAXVALUE - 128)) | (1L << (MICROSECONDS - 128)))) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (MILLENNIUM - 192)) | (1L << (MILLISECONDS - 192)) | (1L << (MIN - 192)) | (1L << (MINVALUE - 192)) | (1L << (MINUTE - 192)) | (1L << (MONTH - 192)) | (1L << (NATIONAL - 192)) | (1L << (NO - 192)) | (1L << (NONE - 192)) | (1L << (NULLIF - 192)) | (1L << (OBJECT - 192)) | (1L << (OPTION - 192)) | (1L << (OPTIONS - 192)) | (1L << (OVERWRITE - 192)) | (1L << (PARSER - 192)) | (1L << (PARTIAL - 192)) | (1L << (PARTITION - 192)) | (1L << (PARTITIONS - 192)) | (1L << (PRECISION - 192)) | (1L << (PUBLIC - 192)) | (1L << (PURGE - 192)) | (1L << (QUARTER - 192)) | (1L << (RANGE - 192)) | (1L << (REGEXP - 192)) | (1L << (RLIKE - 192)) | (1L << (ROLLUP - 192)) | (1L << (SEARCH - 192)) | (1L << (SECOND - 192)) | (1L << (SECURITY - 192)) | (1L << (SERVER - 192)) | (1L << (SET - 192)) | (1L << (SIMILAR - 192)) | (1L << (SIMPLE - 192)) | (1L << (STABLE - 192)) | (1L << (START - 192)) | (1L << (STORAGE - 192)) | (1L << (STDDEV_POP - 192)) | (1L << (STDDEV_SAMP - 192)) | (1L << (SUBPARTITION - 192)) | (1L << (SUM - 192)) | (1L << (TABLESPACE - 192)) | (1L << (TEMPLATE - 192)) | (1L << (THAN - 192)) | (1L << (TIMEZONE - 192)) | (1L << (TIMEZONE_HOUR - 192)) | (1L << (TIMEZONE_MINUTE - 192)) | (1L << (TRIM - 192)) | (1L << (TO - 192)) | (1L << (TYPE - 192)) | (1L << (UNKNOWN - 192)) | (1L << (UNLOGGED - 192)) | (1L << (VALUES - 192)) | (1L << (VAR_SAMP - 192)) | (1L << (VAR_POP - 192)) | (1L << (VARYING - 192)) | (1L << (VOLATILE - 192)) | (1L << (WEEK - 192)) | (1L << (WINDOW - 192)) | (1L << (WRAPPER - 192)) | (1L << (YEAR - 192)) | (1L << (ZONE - 192)) | (1L << (BOOLEAN - 192)))) != 0) || ((((_la - 256)) & ~0x3f) == 0 && ((1L << (_la - 256)) & ((1L << (BOOL - 256)) | (1L << (BIT - 256)) | (1L << (VARBIT - 256)) | (1L << (INT1 - 256)) | (1L << (INT2 - 256)) | (1L << (INT4 - 256)) | (1L << (INT8 - 256)) | (1L << (TINYINT - 256)) | (1L << (SMALLINT - 256)) | (1L << (INT - 256)) | (1L << (INTEGER - 256)) | (1L << (BIGINT - 256)) | (1L << (FLOAT4 - 256)) | (1L << (FLOAT8 - 256)) | (1L << (REAL - 256)) | (1L << (FLOAT - 256)) | (1L << (DOUBLE - 256)) | (1L << (NUMERIC - 256)) | (1L << (DECIMAL - 256)) | (1L << (CHAR - 256)) | (1L << (VARCHAR - 256)) | (1L << (NCHAR - 256)) | (1L << (NVARCHAR - 256)) | (1L << (DATE - 256)) | (1L << (TIME - 256)) | (1L << (TIMETZ - 256)) | (1L << (TIMESTAMP - 256)) | (1L << (TIMESTAMPTZ - 256)) | (1L << (TEXT - 256)) | (1L << (UUID - 256)) | (1L << (VARBINARY - 256)) | (1L << (BLOB - 256)) | (1L << (BYTEA - 256)) | (1L << (INET4 - 256)) | (1L << (DOUBLE_QUOTE - 256)))) != 0) || _la==Identifier );
				setState(1999); match(RIGHT_PAREN);
				setState(2000); ((Table_constraintContext)_localctx).index_parameters_pr_key = index_parameters();
				}
				}
				break;
			case EXCLUDE:
				{
				{
				setState(2002); match(EXCLUDE);
				setState(2005);
				_la = _input.LA(1);
				if (_la==USING) {
					{
					setState(2003); match(USING);
					setState(2004); ((Table_constraintContext)_localctx).index_method = identifier();
					}
				}

				setState(2007); match(LEFT_PAREN);
				setState(2008); ((Table_constraintContext)_localctx).exclude_element = identifier();
				setState(2009); match(WITH);
				setState(2014); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(2010); ((Table_constraintContext)_localctx).operator = identifier();
					setState(2012);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(2011); match(COMMA);
						}
					}

					}
					}
					setState(2016); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (ADMIN - 128)) | (1L << (AVG - 128)) | (1L << (BETWEEN - 128)) | (1L << (BY - 128)) | (1L << (CACHE - 128)) | (1L << (CALLED - 128)) | (1L << (CLASS - 128)) | (1L << (CENTURY - 128)) | (1L << (CHARACTER - 128)) | (1L << (CHECK - 128)) | (1L << (COLLECT - 128)) | (1L << (COALESCE - 128)) | (1L << (COLUMN - 128)) | (1L << (COMMENT - 128)) | (1L << (COMMENTS - 128)) | (1L << (COMMIT - 128)) | (1L << (CONFIGURATION - 128)) | (1L << (COST - 128)) | (1L << (COUNT - 128)) | (1L << (CUBE - 128)) | (1L << (CURRENT - 128)) | (1L << (CYCLE - 128)) | (1L << (DATA - 128)) | (1L << (DAY - 128)) | (1L << (DEC - 128)) | (1L << (DECADE - 128)) | (1L << (DEFINER - 128)) | (1L << (DICTIONARY - 128)) | (1L << (DOW - 128)) | (1L << (DOY - 128)) | (1L << (DROP - 128)) | (1L << (EPOCH - 128)) | (1L << (EVERY - 128)) | (1L << (EXISTS - 128)) | (1L << (EXTERNAL - 128)) | (1L << (EXTRACT - 128)) | (1L << (FAMILY - 128)) | (1L << (FILTER - 128)) | (1L << (FIRST - 128)) | (1L << (FORMAT - 128)) | (1L << (FUSION - 128)) | (1L << (GROUPING - 128)) | (1L << (HASH - 128)) | (1L << (INDEX - 128)) | (1L << (INCREMENT - 128)) | (1L << (INPUT - 128)) | (1L << (INSERT - 128)) | (1L << (INTERSECTION - 128)) | (1L << (ISCACHABLE - 128)) | (1L << (ISODOW - 128)) | (1L << (ISOYEAR - 128)) | (1L << (ISSTRICT - 128)) | (1L << (LANGUAGE - 128)) | (1L << (LARGE - 128)) | (1L << (LAST - 128)) | (1L << (LESS - 128)) | (1L << (LIST - 128)) | (1L << (LOCATION - 128)) | (1L << (MATCH - 128)) | (1L << (MAX - 128)) | (1L << (MAXVALUE - 128)) | (1L << (MICROSECONDS - 128)))) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (MILLENNIUM - 192)) | (1L << (MILLISECONDS - 192)) | (1L << (MIN - 192)) | (1L << (MINVALUE - 192)) | (1L << (MINUTE - 192)) | (1L << (MONTH - 192)) | (1L << (NATIONAL - 192)) | (1L << (NO - 192)) | (1L << (NONE - 192)) | (1L << (NULLIF - 192)) | (1L << (OBJECT - 192)) | (1L << (OPTION - 192)) | (1L << (OPTIONS - 192)) | (1L << (OVERWRITE - 192)) | (1L << (PARSER - 192)) | (1L << (PARTIAL - 192)) | (1L << (PARTITION - 192)) | (1L << (PARTITIONS - 192)) | (1L << (PRECISION - 192)) | (1L << (PUBLIC - 192)) | (1L << (PURGE - 192)) | (1L << (QUARTER - 192)) | (1L << (RANGE - 192)) | (1L << (REGEXP - 192)) | (1L << (RLIKE - 192)) | (1L << (ROLLUP - 192)) | (1L << (SEARCH - 192)) | (1L << (SECOND - 192)) | (1L << (SECURITY - 192)) | (1L << (SERVER - 192)) | (1L << (SET - 192)) | (1L << (SIMILAR - 192)) | (1L << (SIMPLE - 192)) | (1L << (STABLE - 192)) | (1L << (START - 192)) | (1L << (STORAGE - 192)) | (1L << (STDDEV_POP - 192)) | (1L << (STDDEV_SAMP - 192)) | (1L << (SUBPARTITION - 192)) | (1L << (SUM - 192)) | (1L << (TABLESPACE - 192)) | (1L << (TEMPLATE - 192)) | (1L << (THAN - 192)) | (1L << (TIMEZONE - 192)) | (1L << (TIMEZONE_HOUR - 192)) | (1L << (TIMEZONE_MINUTE - 192)) | (1L << (TRIM - 192)) | (1L << (TO - 192)) | (1L << (TYPE - 192)) | (1L << (UNKNOWN - 192)) | (1L << (UNLOGGED - 192)) | (1L << (VALUES - 192)) | (1L << (VAR_SAMP - 192)) | (1L << (VAR_POP - 192)) | (1L << (VARYING - 192)) | (1L << (VOLATILE - 192)) | (1L << (WEEK - 192)) | (1L << (WINDOW - 192)) | (1L << (WRAPPER - 192)) | (1L << (YEAR - 192)) | (1L << (ZONE - 192)) | (1L << (BOOLEAN - 192)))) != 0) || ((((_la - 256)) & ~0x3f) == 0 && ((1L << (_la - 256)) & ((1L << (BOOL - 256)) | (1L << (BIT - 256)) | (1L << (VARBIT - 256)) | (1L << (INT1 - 256)) | (1L << (INT2 - 256)) | (1L << (INT4 - 256)) | (1L << (INT8 - 256)) | (1L << (TINYINT - 256)) | (1L << (SMALLINT - 256)) | (1L << (INT - 256)) | (1L << (INTEGER - 256)) | (1L << (BIGINT - 256)) | (1L << (FLOAT4 - 256)) | (1L << (FLOAT8 - 256)) | (1L << (REAL - 256)) | (1L << (FLOAT - 256)) | (1L << (DOUBLE - 256)) | (1L << (NUMERIC - 256)) | (1L << (DECIMAL - 256)) | (1L << (CHAR - 256)) | (1L << (VARCHAR - 256)) | (1L << (NCHAR - 256)) | (1L << (NVARCHAR - 256)) | (1L << (DATE - 256)) | (1L << (TIME - 256)) | (1L << (TIMETZ - 256)) | (1L << (TIMESTAMP - 256)) | (1L << (TIMESTAMPTZ - 256)) | (1L << (TEXT - 256)) | (1L << (UUID - 256)) | (1L << (VARBINARY - 256)) | (1L << (BLOB - 256)) | (1L << (BYTEA - 256)) | (1L << (INET4 - 256)) | (1L << (DOUBLE_QUOTE - 256)))) != 0) || _la==Identifier );
				setState(2018); match(RIGHT_PAREN);
				setState(2019); index_parameters();
				setState(2025);
				_la = _input.LA(1);
				if (_la==WHERE) {
					{
					setState(2020); match(WHERE);
					setState(2021); match(LEFT_PAREN);
					setState(2022); ((Table_constraintContext)_localctx).predicat = identifier();
					setState(2023); match(RIGHT_PAREN);
					}
				}

				}
				}
				break;
			case FOREIGN:
				{
				{
				setState(2027); match(FOREIGN);
				setState(2028); match(KEY);
				setState(2029); match(LEFT_PAREN);
				setState(2034); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(2030); ((Table_constraintContext)_localctx).column_name_for_key = identifier();
					setState(2032);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(2031); match(COMMA);
						}
					}

					}
					}
					setState(2036); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (ADMIN - 128)) | (1L << (AVG - 128)) | (1L << (BETWEEN - 128)) | (1L << (BY - 128)) | (1L << (CACHE - 128)) | (1L << (CALLED - 128)) | (1L << (CLASS - 128)) | (1L << (CENTURY - 128)) | (1L << (CHARACTER - 128)) | (1L << (CHECK - 128)) | (1L << (COLLECT - 128)) | (1L << (COALESCE - 128)) | (1L << (COLUMN - 128)) | (1L << (COMMENT - 128)) | (1L << (COMMENTS - 128)) | (1L << (COMMIT - 128)) | (1L << (CONFIGURATION - 128)) | (1L << (COST - 128)) | (1L << (COUNT - 128)) | (1L << (CUBE - 128)) | (1L << (CURRENT - 128)) | (1L << (CYCLE - 128)) | (1L << (DATA - 128)) | (1L << (DAY - 128)) | (1L << (DEC - 128)) | (1L << (DECADE - 128)) | (1L << (DEFINER - 128)) | (1L << (DICTIONARY - 128)) | (1L << (DOW - 128)) | (1L << (DOY - 128)) | (1L << (DROP - 128)) | (1L << (EPOCH - 128)) | (1L << (EVERY - 128)) | (1L << (EXISTS - 128)) | (1L << (EXTERNAL - 128)) | (1L << (EXTRACT - 128)) | (1L << (FAMILY - 128)) | (1L << (FILTER - 128)) | (1L << (FIRST - 128)) | (1L << (FORMAT - 128)) | (1L << (FUSION - 128)) | (1L << (GROUPING - 128)) | (1L << (HASH - 128)) | (1L << (INDEX - 128)) | (1L << (INCREMENT - 128)) | (1L << (INPUT - 128)) | (1L << (INSERT - 128)) | (1L << (INTERSECTION - 128)) | (1L << (ISCACHABLE - 128)) | (1L << (ISODOW - 128)) | (1L << (ISOYEAR - 128)) | (1L << (ISSTRICT - 128)) | (1L << (LANGUAGE - 128)) | (1L << (LARGE - 128)) | (1L << (LAST - 128)) | (1L << (LESS - 128)) | (1L << (LIST - 128)) | (1L << (LOCATION - 128)) | (1L << (MATCH - 128)) | (1L << (MAX - 128)) | (1L << (MAXVALUE - 128)) | (1L << (MICROSECONDS - 128)))) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (MILLENNIUM - 192)) | (1L << (MILLISECONDS - 192)) | (1L << (MIN - 192)) | (1L << (MINVALUE - 192)) | (1L << (MINUTE - 192)) | (1L << (MONTH - 192)) | (1L << (NATIONAL - 192)) | (1L << (NO - 192)) | (1L << (NONE - 192)) | (1L << (NULLIF - 192)) | (1L << (OBJECT - 192)) | (1L << (OPTION - 192)) | (1L << (OPTIONS - 192)) | (1L << (OVERWRITE - 192)) | (1L << (PARSER - 192)) | (1L << (PARTIAL - 192)) | (1L << (PARTITION - 192)) | (1L << (PARTITIONS - 192)) | (1L << (PRECISION - 192)) | (1L << (PUBLIC - 192)) | (1L << (PURGE - 192)) | (1L << (QUARTER - 192)) | (1L << (RANGE - 192)) | (1L << (REGEXP - 192)) | (1L << (RLIKE - 192)) | (1L << (ROLLUP - 192)) | (1L << (SEARCH - 192)) | (1L << (SECOND - 192)) | (1L << (SECURITY - 192)) | (1L << (SERVER - 192)) | (1L << (SET - 192)) | (1L << (SIMILAR - 192)) | (1L << (SIMPLE - 192)) | (1L << (STABLE - 192)) | (1L << (START - 192)) | (1L << (STORAGE - 192)) | (1L << (STDDEV_POP - 192)) | (1L << (STDDEV_SAMP - 192)) | (1L << (SUBPARTITION - 192)) | (1L << (SUM - 192)) | (1L << (TABLESPACE - 192)) | (1L << (TEMPLATE - 192)) | (1L << (THAN - 192)) | (1L << (TIMEZONE - 192)) | (1L << (TIMEZONE_HOUR - 192)) | (1L << (TIMEZONE_MINUTE - 192)) | (1L << (TRIM - 192)) | (1L << (TO - 192)) | (1L << (TYPE - 192)) | (1L << (UNKNOWN - 192)) | (1L << (UNLOGGED - 192)) | (1L << (VALUES - 192)) | (1L << (VAR_SAMP - 192)) | (1L << (VAR_POP - 192)) | (1L << (VARYING - 192)) | (1L << (VOLATILE - 192)) | (1L << (WEEK - 192)) | (1L << (WINDOW - 192)) | (1L << (WRAPPER - 192)) | (1L << (YEAR - 192)) | (1L << (ZONE - 192)) | (1L << (BOOLEAN - 192)))) != 0) || ((((_la - 256)) & ~0x3f) == 0 && ((1L << (_la - 256)) & ((1L << (BOOL - 256)) | (1L << (BIT - 256)) | (1L << (VARBIT - 256)) | (1L << (INT1 - 256)) | (1L << (INT2 - 256)) | (1L << (INT4 - 256)) | (1L << (INT8 - 256)) | (1L << (TINYINT - 256)) | (1L << (SMALLINT - 256)) | (1L << (INT - 256)) | (1L << (INTEGER - 256)) | (1L << (BIGINT - 256)) | (1L << (FLOAT4 - 256)) | (1L << (FLOAT8 - 256)) | (1L << (REAL - 256)) | (1L << (FLOAT - 256)) | (1L << (DOUBLE - 256)) | (1L << (NUMERIC - 256)) | (1L << (DECIMAL - 256)) | (1L << (CHAR - 256)) | (1L << (VARCHAR - 256)) | (1L << (NCHAR - 256)) | (1L << (NVARCHAR - 256)) | (1L << (DATE - 256)) | (1L << (TIME - 256)) | (1L << (TIMETZ - 256)) | (1L << (TIMESTAMP - 256)) | (1L << (TIMESTAMPTZ - 256)) | (1L << (TEXT - 256)) | (1L << (UUID - 256)) | (1L << (VARBINARY - 256)) | (1L << (BLOB - 256)) | (1L << (BYTEA - 256)) | (1L << (INET4 - 256)) | (1L << (DOUBLE_QUOTE - 256)))) != 0) || _la==Identifier );
				setState(2038); match(RIGHT_PAREN);
				setState(2039); match(REFERENCES);
				setState(2040); ((Table_constraintContext)_localctx).reftable = identifier();
				setState(2052);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(2041); match(LEFT_PAREN);
					setState(2046); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(2042); ((Table_constraintContext)_localctx).refcolumn = identifier();
						setState(2044);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(2043); match(COMMA);
							}
						}

						}
						}
						setState(2048); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (ADMIN - 128)) | (1L << (AVG - 128)) | (1L << (BETWEEN - 128)) | (1L << (BY - 128)) | (1L << (CACHE - 128)) | (1L << (CALLED - 128)) | (1L << (CLASS - 128)) | (1L << (CENTURY - 128)) | (1L << (CHARACTER - 128)) | (1L << (CHECK - 128)) | (1L << (COLLECT - 128)) | (1L << (COALESCE - 128)) | (1L << (COLUMN - 128)) | (1L << (COMMENT - 128)) | (1L << (COMMENTS - 128)) | (1L << (COMMIT - 128)) | (1L << (CONFIGURATION - 128)) | (1L << (COST - 128)) | (1L << (COUNT - 128)) | (1L << (CUBE - 128)) | (1L << (CURRENT - 128)) | (1L << (CYCLE - 128)) | (1L << (DATA - 128)) | (1L << (DAY - 128)) | (1L << (DEC - 128)) | (1L << (DECADE - 128)) | (1L << (DEFINER - 128)) | (1L << (DICTIONARY - 128)) | (1L << (DOW - 128)) | (1L << (DOY - 128)) | (1L << (DROP - 128)) | (1L << (EPOCH - 128)) | (1L << (EVERY - 128)) | (1L << (EXISTS - 128)) | (1L << (EXTERNAL - 128)) | (1L << (EXTRACT - 128)) | (1L << (FAMILY - 128)) | (1L << (FILTER - 128)) | (1L << (FIRST - 128)) | (1L << (FORMAT - 128)) | (1L << (FUSION - 128)) | (1L << (GROUPING - 128)) | (1L << (HASH - 128)) | (1L << (INDEX - 128)) | (1L << (INCREMENT - 128)) | (1L << (INPUT - 128)) | (1L << (INSERT - 128)) | (1L << (INTERSECTION - 128)) | (1L << (ISCACHABLE - 128)) | (1L << (ISODOW - 128)) | (1L << (ISOYEAR - 128)) | (1L << (ISSTRICT - 128)) | (1L << (LANGUAGE - 128)) | (1L << (LARGE - 128)) | (1L << (LAST - 128)) | (1L << (LESS - 128)) | (1L << (LIST - 128)) | (1L << (LOCATION - 128)) | (1L << (MATCH - 128)) | (1L << (MAX - 128)) | (1L << (MAXVALUE - 128)) | (1L << (MICROSECONDS - 128)))) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (MILLENNIUM - 192)) | (1L << (MILLISECONDS - 192)) | (1L << (MIN - 192)) | (1L << (MINVALUE - 192)) | (1L << (MINUTE - 192)) | (1L << (MONTH - 192)) | (1L << (NATIONAL - 192)) | (1L << (NO - 192)) | (1L << (NONE - 192)) | (1L << (NULLIF - 192)) | (1L << (OBJECT - 192)) | (1L << (OPTION - 192)) | (1L << (OPTIONS - 192)) | (1L << (OVERWRITE - 192)) | (1L << (PARSER - 192)) | (1L << (PARTIAL - 192)) | (1L << (PARTITION - 192)) | (1L << (PARTITIONS - 192)) | (1L << (PRECISION - 192)) | (1L << (PUBLIC - 192)) | (1L << (PURGE - 192)) | (1L << (QUARTER - 192)) | (1L << (RANGE - 192)) | (1L << (REGEXP - 192)) | (1L << (RLIKE - 192)) | (1L << (ROLLUP - 192)) | (1L << (SEARCH - 192)) | (1L << (SECOND - 192)) | (1L << (SECURITY - 192)) | (1L << (SERVER - 192)) | (1L << (SET - 192)) | (1L << (SIMILAR - 192)) | (1L << (SIMPLE - 192)) | (1L << (STABLE - 192)) | (1L << (START - 192)) | (1L << (STORAGE - 192)) | (1L << (STDDEV_POP - 192)) | (1L << (STDDEV_SAMP - 192)) | (1L << (SUBPARTITION - 192)) | (1L << (SUM - 192)) | (1L << (TABLESPACE - 192)) | (1L << (TEMPLATE - 192)) | (1L << (THAN - 192)) | (1L << (TIMEZONE - 192)) | (1L << (TIMEZONE_HOUR - 192)) | (1L << (TIMEZONE_MINUTE - 192)) | (1L << (TRIM - 192)) | (1L << (TO - 192)) | (1L << (TYPE - 192)) | (1L << (UNKNOWN - 192)) | (1L << (UNLOGGED - 192)) | (1L << (VALUES - 192)) | (1L << (VAR_SAMP - 192)) | (1L << (VAR_POP - 192)) | (1L << (VARYING - 192)) | (1L << (VOLATILE - 192)) | (1L << (WEEK - 192)) | (1L << (WINDOW - 192)) | (1L << (WRAPPER - 192)) | (1L << (YEAR - 192)) | (1L << (ZONE - 192)) | (1L << (BOOLEAN - 192)))) != 0) || ((((_la - 256)) & ~0x3f) == 0 && ((1L << (_la - 256)) & ((1L << (BOOL - 256)) | (1L << (BIT - 256)) | (1L << (VARBIT - 256)) | (1L << (INT1 - 256)) | (1L << (INT2 - 256)) | (1L << (INT4 - 256)) | (1L << (INT8 - 256)) | (1L << (TINYINT - 256)) | (1L << (SMALLINT - 256)) | (1L << (INT - 256)) | (1L << (INTEGER - 256)) | (1L << (BIGINT - 256)) | (1L << (FLOAT4 - 256)) | (1L << (FLOAT8 - 256)) | (1L << (REAL - 256)) | (1L << (FLOAT - 256)) | (1L << (DOUBLE - 256)) | (1L << (NUMERIC - 256)) | (1L << (DECIMAL - 256)) | (1L << (CHAR - 256)) | (1L << (VARCHAR - 256)) | (1L << (NCHAR - 256)) | (1L << (NVARCHAR - 256)) | (1L << (DATE - 256)) | (1L << (TIME - 256)) | (1L << (TIMETZ - 256)) | (1L << (TIMESTAMP - 256)) | (1L << (TIMESTAMPTZ - 256)) | (1L << (TEXT - 256)) | (1L << (UUID - 256)) | (1L << (VARBINARY - 256)) | (1L << (BLOB - 256)) | (1L << (BYTEA - 256)) | (1L << (INET4 - 256)) | (1L << (DOUBLE_QUOTE - 256)))) != 0) || _la==Identifier );
					setState(2050); match(RIGHT_PAREN);
					}
				}

				setState(2060);
				switch ( getInterpreter().adaptivePredict(_input,291,_ctx) ) {
				case 1:
					{
					{
					setState(2054); match(MATCH);
					setState(2055); match(FULL);
					}
					}
					break;
				case 2:
					{
					{
					setState(2056); match(MATCH);
					setState(2057); match(PARTIAL);
					}
					}
					break;
				case 3:
					{
					{
					setState(2058); match(MATCH);
					setState(2059); match(SIMPLE);
					}
					}
					break;
				}
				setState(2065);
				switch ( getInterpreter().adaptivePredict(_input,292,_ctx) ) {
				case 1:
					{
					setState(2062); match(ON);
					setState(2063); match(DELETE);
					setState(2064); ((Table_constraintContext)_localctx).action_on_delete = action();
					}
					break;
				}
				setState(2070);
				_la = _input.LA(1);
				if (_la==ON) {
					{
					setState(2067); match(ON);
					setState(2068); match(UPDATE);
					setState(2069); ((Table_constraintContext)_localctx).action_on_update = action();
					}
				}

				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(2077);
			switch (_input.LA(1)) {
			case DEFERRABLE:
				{
				setState(2074); match(DEFERRABLE);
				}
				break;
			case NOT:
				{
				{
				setState(2075); match(NOT);
				setState(2076); match(DEFERRABLE);
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
			case COMMA:
			case RIGHT_PAREN:
			case DOUBLE_QUOTE:
			case Identifier:
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(2083);
			switch ( getInterpreter().adaptivePredict(_input,296,_ctx) ) {
			case 1:
				{
				{
				setState(2079); match(INITIALLY);
				setState(2080); match(DEFERRED);
				}
				}
				break;
			case 2:
				{
				{
				setState(2081); match(INITIALLY);
				setState(2082); match(IMMEDIATE);
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
		public Routine_invocationContext default_expr;
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
		public TerminalNode DEFAULT() { return getToken(SQLParser.DEFAULT, 0); }
		public List<TerminalNode> ON() { return getTokens(SQLParser.ON); }
		public TerminalNode NOT(int i) {
			return getToken(SQLParser.NOT, i);
		}
		public TerminalNode DELETE() { return getToken(SQLParser.DELETE, 0); }
		public TerminalNode CONSTRAINT() { return getToken(SQLParser.CONSTRAINT, 0); }
		public TerminalNode SIMPLE() { return getToken(SQLParser.SIMPLE, 0); }
		public TerminalNode UPDATE() { return getToken(SQLParser.UPDATE, 0); }
		public TerminalNode IMMEDIATE() { return getToken(SQLParser.IMMEDIATE, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public TerminalNode ON(int i) {
			return getToken(SQLParser.ON, i);
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
		public Routine_invocationContext routine_invocation() {
			return getRuleContext(Routine_invocationContext.class,0);
		}
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
		enterRule(_localctx, 54, RULE_column_constraint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2087);
			_la = _input.LA(1);
			if (_la==CONSTRAINT) {
				{
				setState(2085); match(CONSTRAINT);
				setState(2086); ((Column_constraintContext)_localctx).constraint_name = identifier();
				}
			}

			setState(2121);
			switch (_input.LA(1)) {
			case NOT:
				{
				{
				setState(2089); match(NOT);
				setState(2090); match(NULL);
				}
				}
				break;
			case NULL:
				{
				setState(2091); match(NULL);
				}
				break;
			case CHECK:
				{
				setState(2092); check_boolean_expression();
				}
				break;
			case DEFAULT:
				{
				{
				setState(2093); match(DEFAULT);
				setState(2094); ((Column_constraintContext)_localctx).default_expr = routine_invocation();
				}
				}
				break;
			case UNIQUE:
				{
				{
				setState(2095); match(UNIQUE);
				setState(2096); ((Column_constraintContext)_localctx).index_params_unique = index_parameters();
				}
				}
				break;
			case PRIMARY:
				{
				{
				setState(2097); match(PRIMARY);
				setState(2098); match(KEY);
				setState(2099); ((Column_constraintContext)_localctx).index_params_pr_key = index_parameters();
				}
				}
				break;
			case REFERENCES:
				{
				{
				setState(2100); match(REFERENCES);
				setState(2101); ((Column_constraintContext)_localctx).reftable = schema_qualified_name();
				{
				{
				setState(2102); ((Column_constraintContext)_localctx).refcolumn = identifier();
				}
				}
				setState(2109);
				switch ( getInterpreter().adaptivePredict(_input,298,_ctx) ) {
				case 1:
					{
					setState(2103); match(MATCH);
					setState(2104); match(FULL);
					}
					break;
				case 2:
					{
					setState(2105); match(MATCH);
					setState(2106); match(PARTIAL);
					}
					break;
				case 3:
					{
					setState(2107); match(MATCH);
					setState(2108); match(SIMPLE);
					}
					break;
				}
				setState(2114);
				switch ( getInterpreter().adaptivePredict(_input,299,_ctx) ) {
				case 1:
					{
					setState(2111); match(ON);
					setState(2112); match(DELETE);
					setState(2113); ((Column_constraintContext)_localctx).action_on_delete = action();
					}
					break;
				}
				setState(2119);
				_la = _input.LA(1);
				if (_la==ON) {
					{
					setState(2116); match(ON);
					setState(2117); match(UPDATE);
					setState(2118); ((Column_constraintContext)_localctx).action_on_update = action();
					}
				}

				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(2126);
			switch ( getInterpreter().adaptivePredict(_input,302,_ctx) ) {
			case 1:
				{
				setState(2123); match(DEFERRABLE);
				}
				break;
			case 2:
				{
				{
				setState(2124); match(NOT);
				setState(2125); match(DEFERRABLE);
				}
				}
				break;
			}
			setState(2132);
			switch ( getInterpreter().adaptivePredict(_input,303,_ctx) ) {
			case 1:
				{
				{
				setState(2128); match(INITIALLY);
				setState(2129); match(DEFERRED);
				}
				}
				break;
			case 2:
				{
				{
				setState(2130); match(INITIALLY);
				setState(2131); match(IMMEDIATE);
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
		enterRule(_localctx, 56, RULE_check_boolean_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2134); match(CHECK);
			setState(2135); match(LEFT_PAREN);
			setState(2136); ((Check_boolean_expressionContext)_localctx).expression = boolean_value_expression();
			setState(2137); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 58, RULE_storage_parameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2139); match(WITH);
			setState(2140); match(LEFT_PAREN);
			setState(2149); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(2141); ((Storage_parameterContext)_localctx).storage_param = identifier();
				setState(2144);
				_la = _input.LA(1);
				if (_la==EQUAL) {
					{
					setState(2142); match(EQUAL);
					setState(2143); ((Storage_parameterContext)_localctx).value = identifier();
					}
				}

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
			} while ( ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (ADMIN - 128)) | (1L << (AVG - 128)) | (1L << (BETWEEN - 128)) | (1L << (BY - 128)) | (1L << (CACHE - 128)) | (1L << (CALLED - 128)) | (1L << (CLASS - 128)) | (1L << (CENTURY - 128)) | (1L << (CHARACTER - 128)) | (1L << (CHECK - 128)) | (1L << (COLLECT - 128)) | (1L << (COALESCE - 128)) | (1L << (COLUMN - 128)) | (1L << (COMMENT - 128)) | (1L << (COMMENTS - 128)) | (1L << (COMMIT - 128)) | (1L << (CONFIGURATION - 128)) | (1L << (COST - 128)) | (1L << (COUNT - 128)) | (1L << (CUBE - 128)) | (1L << (CURRENT - 128)) | (1L << (CYCLE - 128)) | (1L << (DATA - 128)) | (1L << (DAY - 128)) | (1L << (DEC - 128)) | (1L << (DECADE - 128)) | (1L << (DEFINER - 128)) | (1L << (DICTIONARY - 128)) | (1L << (DOW - 128)) | (1L << (DOY - 128)) | (1L << (DROP - 128)) | (1L << (EPOCH - 128)) | (1L << (EVERY - 128)) | (1L << (EXISTS - 128)) | (1L << (EXTERNAL - 128)) | (1L << (EXTRACT - 128)) | (1L << (FAMILY - 128)) | (1L << (FILTER - 128)) | (1L << (FIRST - 128)) | (1L << (FORMAT - 128)) | (1L << (FUSION - 128)) | (1L << (GROUPING - 128)) | (1L << (HASH - 128)) | (1L << (INDEX - 128)) | (1L << (INCREMENT - 128)) | (1L << (INPUT - 128)) | (1L << (INSERT - 128)) | (1L << (INTERSECTION - 128)) | (1L << (ISCACHABLE - 128)) | (1L << (ISODOW - 128)) | (1L << (ISOYEAR - 128)) | (1L << (ISSTRICT - 128)) | (1L << (LANGUAGE - 128)) | (1L << (LARGE - 128)) | (1L << (LAST - 128)) | (1L << (LESS - 128)) | (1L << (LIST - 128)) | (1L << (LOCATION - 128)) | (1L << (MATCH - 128)) | (1L << (MAX - 128)) | (1L << (MAXVALUE - 128)) | (1L << (MICROSECONDS - 128)))) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (MILLENNIUM - 192)) | (1L << (MILLISECONDS - 192)) | (1L << (MIN - 192)) | (1L << (MINVALUE - 192)) | (1L << (MINUTE - 192)) | (1L << (MONTH - 192)) | (1L << (NATIONAL - 192)) | (1L << (NO - 192)) | (1L << (NONE - 192)) | (1L << (NULLIF - 192)) | (1L << (OBJECT - 192)) | (1L << (OPTION - 192)) | (1L << (OPTIONS - 192)) | (1L << (OVERWRITE - 192)) | (1L << (PARSER - 192)) | (1L << (PARTIAL - 192)) | (1L << (PARTITION - 192)) | (1L << (PARTITIONS - 192)) | (1L << (PRECISION - 192)) | (1L << (PUBLIC - 192)) | (1L << (PURGE - 192)) | (1L << (QUARTER - 192)) | (1L << (RANGE - 192)) | (1L << (REGEXP - 192)) | (1L << (RLIKE - 192)) | (1L << (ROLLUP - 192)) | (1L << (SEARCH - 192)) | (1L << (SECOND - 192)) | (1L << (SECURITY - 192)) | (1L << (SERVER - 192)) | (1L << (SET - 192)) | (1L << (SIMILAR - 192)) | (1L << (SIMPLE - 192)) | (1L << (STABLE - 192)) | (1L << (START - 192)) | (1L << (STORAGE - 192)) | (1L << (STDDEV_POP - 192)) | (1L << (STDDEV_SAMP - 192)) | (1L << (SUBPARTITION - 192)) | (1L << (SUM - 192)) | (1L << (TABLESPACE - 192)) | (1L << (TEMPLATE - 192)) | (1L << (THAN - 192)) | (1L << (TIMEZONE - 192)) | (1L << (TIMEZONE_HOUR - 192)) | (1L << (TIMEZONE_MINUTE - 192)) | (1L << (TRIM - 192)) | (1L << (TO - 192)) | (1L << (TYPE - 192)) | (1L << (UNKNOWN - 192)) | (1L << (UNLOGGED - 192)) | (1L << (VALUES - 192)) | (1L << (VAR_SAMP - 192)) | (1L << (VAR_POP - 192)) | (1L << (VARYING - 192)) | (1L << (VOLATILE - 192)) | (1L << (WEEK - 192)) | (1L << (WINDOW - 192)) | (1L << (WRAPPER - 192)) | (1L << (YEAR - 192)) | (1L << (ZONE - 192)) | (1L << (BOOLEAN - 192)))) != 0) || ((((_la - 256)) & ~0x3f) == 0 && ((1L << (_la - 256)) & ((1L << (BOOL - 256)) | (1L << (BIT - 256)) | (1L << (VARBIT - 256)) | (1L << (INT1 - 256)) | (1L << (INT2 - 256)) | (1L << (INT4 - 256)) | (1L << (INT8 - 256)) | (1L << (TINYINT - 256)) | (1L << (SMALLINT - 256)) | (1L << (INT - 256)) | (1L << (INTEGER - 256)) | (1L << (BIGINT - 256)) | (1L << (FLOAT4 - 256)) | (1L << (FLOAT8 - 256)) | (1L << (REAL - 256)) | (1L << (FLOAT - 256)) | (1L << (DOUBLE - 256)) | (1L << (NUMERIC - 256)) | (1L << (DECIMAL - 256)) | (1L << (CHAR - 256)) | (1L << (VARCHAR - 256)) | (1L << (NCHAR - 256)) | (1L << (NVARCHAR - 256)) | (1L << (DATE - 256)) | (1L << (TIME - 256)) | (1L << (TIMETZ - 256)) | (1L << (TIMESTAMP - 256)) | (1L << (TIMESTAMPTZ - 256)) | (1L << (TEXT - 256)) | (1L << (UUID - 256)) | (1L << (VARBINARY - 256)) | (1L << (BLOB - 256)) | (1L << (BYTEA - 256)) | (1L << (INET4 - 256)) | (1L << (DOUBLE_QUOTE - 256)))) != 0) || _la==Identifier );
			setState(2153); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 60, RULE_storage_parameter_oid);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2160);
			switch ( getInterpreter().adaptivePredict(_input,307,_ctx) ) {
			case 1:
				{
				setState(2155); storage_parameter();
				}
				break;
			case 2:
				{
				{
				setState(2156); match(WITH);
				setState(2157); match(OIDS);
				}
				}
				break;
			case 3:
				{
				{
				setState(2158); match(WITHOUT);
				setState(2159); match(OIDS);
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
		enterRule(_localctx, 62, RULE_on_commit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2171);
			_la = _input.LA(1);
			if (_la==ON) {
				{
				setState(2162); match(ON);
				setState(2163); match(COMMIT);
				setState(2169);
				switch (_input.LA(1)) {
				case PRESERVE:
					{
					{
					setState(2164); match(PRESERVE);
					setState(2165); match(ROWS);
					}
					}
					break;
				case DELETE:
					{
					{
					setState(2166); match(DELETE);
					setState(2167); match(ROWS);
					}
					}
					break;
				case DROP:
					{
					setState(2168); match(DROP);
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
		enterRule(_localctx, 64, RULE_table_space);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2175);
			switch ( getInterpreter().adaptivePredict(_input,310,_ctx) ) {
			case 1:
				{
				setState(2173); match(TABLESPACE);
				setState(2174); ((Table_spaceContext)_localctx).tablespace = identifier();
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
		enterRule(_localctx, 66, RULE_action);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2183);
			switch ( getInterpreter().adaptivePredict(_input,311,_ctx) ) {
			case 1:
				{
				setState(2177); match(RESTRICT);
				}
				break;
			case 2:
				{
				setState(2178); match(CASCADE);
				}
				break;
			case 3:
				{
				setState(2179); match(SET);
				setState(2180); match(NULL);
				}
				break;
			case 4:
				{
				setState(2181); match(SET);
				setState(2182); match(DEFAULT);
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
		enterRule(_localctx, 68, RULE_index_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2186);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(2185); storage_parameter();
				}
			}

			setState(2192);
			_la = _input.LA(1);
			if (_la==USING) {
				{
				setState(2188); match(USING);
				setState(2189); match(INDEX);
				setState(2190); match(TABLESPACE);
				setState(2191); ((Index_parametersContext)_localctx).tablespace = identifier();
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
		enterRule(_localctx, 70, RULE_table_elements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2194); match(LEFT_PAREN);
			setState(2195); field_element();
			setState(2200);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2196); match(COMMA);
				setState(2197); field_element();
				}
				}
				setState(2202);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2203); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 72, RULE_field_element);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2205); ((Field_elementContext)_localctx).name = identifier();
			setState(2206); field_type();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 74, RULE_field_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2208); data_type();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 76, RULE_param_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2210); match(WITH);
			setState(2211); match(LEFT_PAREN);
			setState(2212); param();
			setState(2217);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2213); match(COMMA);
				setState(2214); param();
				}
				}
				setState(2219);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2220); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 78, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2222); ((ParamContext)_localctx).key = match(Character_String_Literal);
			setState(2223); match(EQUAL);
			setState(2224); ((ParamContext)_localctx).value = numeric_value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 80, RULE_method_specifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2226); match(USING);
			setState(2227); ((Method_specifierContext)_localctx).m = identifier();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 82, RULE_table_space_specifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2229); match(TABLESPACE);
			setState(2230); table_space_name();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 84, RULE_table_space_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2232); identifier();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 86, RULE_table_partitioning_clauses);
		try {
			setState(2238);
			switch ( getInterpreter().adaptivePredict(_input,316,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2234); range_partitions();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2235); hash_partitions();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2236); list_partitions();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2237); column_partitions();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 88, RULE_range_partitions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2240); match(PARTITION);
			setState(2241); match(BY);
			setState(2242); match(RANGE);
			setState(2243); match(LEFT_PAREN);
			setState(2244); column_reference_list();
			setState(2245); match(RIGHT_PAREN);
			setState(2246); match(LEFT_PAREN);
			setState(2247); range_value_clause_list();
			setState(2248); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 90, RULE_range_value_clause_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2250); range_value_clause();
			setState(2255);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2251); match(COMMA);
				setState(2252); range_value_clause();
				}
				}
				setState(2257);
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
		enterRule(_localctx, 92, RULE_range_value_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2258); match(PARTITION);
			setState(2259); partition_name();
			setState(2260); match(VALUES);
			setState(2261); match(LESS);
			setState(2262); match(THAN);
			setState(2274);
			switch ( getInterpreter().adaptivePredict(_input,320,_ctx) ) {
			case 1:
				{
				setState(2263); match(LEFT_PAREN);
				setState(2264); value_expression();
				setState(2265); match(RIGHT_PAREN);
				}
				break;
			case 2:
				{
				setState(2268);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(2267); match(LEFT_PAREN);
					}
				}

				setState(2270); match(MAXVALUE);
				setState(2272);
				switch ( getInterpreter().adaptivePredict(_input,319,_ctx) ) {
				case 1:
					{
					setState(2271); match(RIGHT_PAREN);
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
		enterRule(_localctx, 94, RULE_hash_partitions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2276); match(PARTITION);
			setState(2277); match(BY);
			setState(2278); match(HASH);
			setState(2279); match(LEFT_PAREN);
			setState(2280); column_reference_list();
			setState(2281); match(RIGHT_PAREN);
			setState(2287);
			switch (_input.LA(1)) {
			case LEFT_PAREN:
				{
				setState(2282); match(LEFT_PAREN);
				setState(2283); individual_hash_partitions();
				setState(2284); match(RIGHT_PAREN);
				}
				break;
			case PARTITIONS:
				{
				setState(2286); hash_partitions_by_quantity();
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
		enterRule(_localctx, 96, RULE_individual_hash_partitions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2289); individual_hash_partition();
			setState(2294);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2290); match(COMMA);
				setState(2291); individual_hash_partition();
				}
				}
				setState(2296);
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
		enterRule(_localctx, 98, RULE_individual_hash_partition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2297); match(PARTITION);
			setState(2298); partition_name();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 100, RULE_hash_partitions_by_quantity);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2300); match(PARTITIONS);
			setState(2301); ((Hash_partitions_by_quantityContext)_localctx).quantity = numeric_value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 102, RULE_list_partitions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2303); match(PARTITION);
			setState(2304); match(BY);
			setState(2305); match(LIST);
			setState(2306); match(LEFT_PAREN);
			setState(2307); column_reference_list();
			setState(2308); match(RIGHT_PAREN);
			setState(2309); match(LEFT_PAREN);
			setState(2310); list_value_clause_list();
			setState(2311); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 104, RULE_list_value_clause_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2313); list_value_partition();
			setState(2318);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2314); match(COMMA);
				setState(2315); list_value_partition();
				}
				}
				setState(2320);
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
		enterRule(_localctx, 106, RULE_list_value_partition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2321); match(PARTITION);
			setState(2322); partition_name();
			setState(2323); match(VALUES);
			setState(2325);
			_la = _input.LA(1);
			if (_la==IN) {
				{
				setState(2324); match(IN);
				}
			}

			setState(2327); match(LEFT_PAREN);
			setState(2328); in_value_list();
			setState(2329); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 108, RULE_column_partitions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2331); match(PARTITION);
			setState(2332); match(BY);
			setState(2333); match(COLUMN);
			setState(2334); table_elements();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 110, RULE_partition_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2336); identifier();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 112, RULE_drop_table_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2338); match(DROP);
			setState(2339); match(TABLE);
			setState(2340); schema_qualified_name();
			setState(2342);
			switch ( getInterpreter().adaptivePredict(_input,325,_ctx) ) {
			case 1:
				{
				setState(2341); match(PURGE);
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
		enterRule(_localctx, 114, RULE_identifier);
		int _la;
		try {
			setState(2358);
			switch ( getInterpreter().adaptivePredict(_input,330,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2345);
				_la = _input.LA(1);
				if (_la==DOUBLE_QUOTE) {
					{
					setState(2344); match(DOUBLE_QUOTE);
					}
				}

				setState(2347); match(Identifier);
				setState(2349);
				switch ( getInterpreter().adaptivePredict(_input,327,_ctx) ) {
				case 1:
					{
					setState(2348); match(DOUBLE_QUOTE);
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2352);
				_la = _input.LA(1);
				if (_la==DOUBLE_QUOTE) {
					{
					setState(2351); match(DOUBLE_QUOTE);
					}
				}

				setState(2354); nonreserved_keywords();
				setState(2356);
				switch ( getInterpreter().adaptivePredict(_input,329,_ctx) ) {
				case 1:
					{
					setState(2355); match(DOUBLE_QUOTE);
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
		enterRule(_localctx, 116, RULE_nonreserved_keywords);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2360);
			_la = _input.LA(1);
			if ( !(((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (ADMIN - 128)) | (1L << (AVG - 128)) | (1L << (BETWEEN - 128)) | (1L << (BY - 128)) | (1L << (CACHE - 128)) | (1L << (CALLED - 128)) | (1L << (CLASS - 128)) | (1L << (CENTURY - 128)) | (1L << (CHARACTER - 128)) | (1L << (CHECK - 128)) | (1L << (COLLECT - 128)) | (1L << (COALESCE - 128)) | (1L << (COLUMN - 128)) | (1L << (COMMENT - 128)) | (1L << (COMMENTS - 128)) | (1L << (COMMIT - 128)) | (1L << (CONFIGURATION - 128)) | (1L << (COST - 128)) | (1L << (COUNT - 128)) | (1L << (CUBE - 128)) | (1L << (CURRENT - 128)) | (1L << (CYCLE - 128)) | (1L << (DATA - 128)) | (1L << (DAY - 128)) | (1L << (DEC - 128)) | (1L << (DECADE - 128)) | (1L << (DEFINER - 128)) | (1L << (DICTIONARY - 128)) | (1L << (DOW - 128)) | (1L << (DOY - 128)) | (1L << (DROP - 128)) | (1L << (EPOCH - 128)) | (1L << (EVERY - 128)) | (1L << (EXISTS - 128)) | (1L << (EXTERNAL - 128)) | (1L << (EXTRACT - 128)) | (1L << (FAMILY - 128)) | (1L << (FILTER - 128)) | (1L << (FIRST - 128)) | (1L << (FORMAT - 128)) | (1L << (FUSION - 128)) | (1L << (GROUPING - 128)) | (1L << (HASH - 128)) | (1L << (INDEX - 128)) | (1L << (INCREMENT - 128)) | (1L << (INPUT - 128)) | (1L << (INSERT - 128)) | (1L << (INTERSECTION - 128)) | (1L << (ISCACHABLE - 128)) | (1L << (ISODOW - 128)) | (1L << (ISOYEAR - 128)) | (1L << (ISSTRICT - 128)) | (1L << (LANGUAGE - 128)) | (1L << (LARGE - 128)) | (1L << (LAST - 128)) | (1L << (LESS - 128)) | (1L << (LIST - 128)) | (1L << (LOCATION - 128)) | (1L << (MATCH - 128)) | (1L << (MAX - 128)) | (1L << (MAXVALUE - 128)) | (1L << (MICROSECONDS - 128)))) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (MILLENNIUM - 192)) | (1L << (MILLISECONDS - 192)) | (1L << (MIN - 192)) | (1L << (MINVALUE - 192)) | (1L << (MINUTE - 192)) | (1L << (MONTH - 192)) | (1L << (NATIONAL - 192)) | (1L << (NO - 192)) | (1L << (NONE - 192)) | (1L << (NULLIF - 192)) | (1L << (OBJECT - 192)) | (1L << (OPTION - 192)) | (1L << (OPTIONS - 192)) | (1L << (OVERWRITE - 192)) | (1L << (PARSER - 192)) | (1L << (PARTIAL - 192)) | (1L << (PARTITION - 192)) | (1L << (PARTITIONS - 192)) | (1L << (PRECISION - 192)) | (1L << (PUBLIC - 192)) | (1L << (PURGE - 192)) | (1L << (QUARTER - 192)) | (1L << (RANGE - 192)) | (1L << (REGEXP - 192)) | (1L << (RLIKE - 192)) | (1L << (ROLLUP - 192)) | (1L << (SEARCH - 192)) | (1L << (SECOND - 192)) | (1L << (SECURITY - 192)) | (1L << (SERVER - 192)) | (1L << (SET - 192)) | (1L << (SIMILAR - 192)) | (1L << (SIMPLE - 192)) | (1L << (STABLE - 192)) | (1L << (START - 192)) | (1L << (STORAGE - 192)) | (1L << (STDDEV_POP - 192)) | (1L << (STDDEV_SAMP - 192)) | (1L << (SUBPARTITION - 192)) | (1L << (SUM - 192)) | (1L << (TABLESPACE - 192)) | (1L << (TEMPLATE - 192)) | (1L << (THAN - 192)) | (1L << (TIMEZONE - 192)) | (1L << (TIMEZONE_HOUR - 192)) | (1L << (TIMEZONE_MINUTE - 192)) | (1L << (TRIM - 192)) | (1L << (TO - 192)) | (1L << (TYPE - 192)) | (1L << (UNKNOWN - 192)) | (1L << (UNLOGGED - 192)) | (1L << (VALUES - 192)) | (1L << (VAR_SAMP - 192)) | (1L << (VAR_POP - 192)) | (1L << (VARYING - 192)) | (1L << (VOLATILE - 192)) | (1L << (WEEK - 192)) | (1L << (WINDOW - 192)) | (1L << (WRAPPER - 192)) | (1L << (YEAR - 192)) | (1L << (ZONE - 192)) | (1L << (BOOLEAN - 192)))) != 0) || ((((_la - 256)) & ~0x3f) == 0 && ((1L << (_la - 256)) & ((1L << (BOOL - 256)) | (1L << (BIT - 256)) | (1L << (VARBIT - 256)) | (1L << (INT1 - 256)) | (1L << (INT2 - 256)) | (1L << (INT4 - 256)) | (1L << (INT8 - 256)) | (1L << (TINYINT - 256)) | (1L << (SMALLINT - 256)) | (1L << (INT - 256)) | (1L << (INTEGER - 256)) | (1L << (BIGINT - 256)) | (1L << (FLOAT4 - 256)) | (1L << (FLOAT8 - 256)) | (1L << (REAL - 256)) | (1L << (FLOAT - 256)) | (1L << (DOUBLE - 256)) | (1L << (NUMERIC - 256)) | (1L << (DECIMAL - 256)) | (1L << (CHAR - 256)) | (1L << (VARCHAR - 256)) | (1L << (NCHAR - 256)) | (1L << (NVARCHAR - 256)) | (1L << (DATE - 256)) | (1L << (TIME - 256)) | (1L << (TIMETZ - 256)) | (1L << (TIMESTAMP - 256)) | (1L << (TIMESTAMPTZ - 256)) | (1L << (TEXT - 256)) | (1L << (UUID - 256)) | (1L << (VARBINARY - 256)) | (1L << (BLOB - 256)) | (1L << (BYTEA - 256)) | (1L << (INET4 - 256)))) != 0)) ) {
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
		enterRule(_localctx, 118, RULE_unsigned_literal);
		try {
			setState(2364);
			switch (_input.LA(1)) {
			case NUMBER:
			case REAL_NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(2362); unsigned_numeric_literal();
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
				setState(2363); general_literal();
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
		enterRule(_localctx, 120, RULE_general_literal);
		try {
			setState(2369);
			switch (_input.LA(1)) {
			case Character_String_Literal:
				enterOuterAlt(_localctx, 1);
				{
				setState(2366); match(Character_String_Literal);
				}
				break;
			case DATE:
			case TIME:
			case TIMESTAMP:
				enterOuterAlt(_localctx, 2);
				{
				setState(2367); datetime_literal();
				}
				break;
			case FALSE:
			case TRUE:
			case UNKNOWN:
				enterOuterAlt(_localctx, 3);
				{
				setState(2368); boolean_literal();
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
		enterRule(_localctx, 122, RULE_datetime_literal);
		try {
			setState(2374);
			switch (_input.LA(1)) {
			case TIMESTAMP:
				enterOuterAlt(_localctx, 1);
				{
				setState(2371); timestamp_literal();
				}
				break;
			case TIME:
				enterOuterAlt(_localctx, 2);
				{
				setState(2372); time_literal();
				}
				break;
			case DATE:
				enterOuterAlt(_localctx, 3);
				{
				setState(2373); date_literal();
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
		enterRule(_localctx, 124, RULE_time_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2376); match(TIME);
			setState(2377); ((Time_literalContext)_localctx).time_string = match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 126, RULE_timestamp_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2379); match(TIMESTAMP);
			setState(2380); ((Timestamp_literalContext)_localctx).timestamp_string = match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 128, RULE_date_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2382); match(DATE);
			setState(2383); ((Date_literalContext)_localctx).date_string = match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 130, RULE_boolean_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2385);
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
		public Predefined_typeContext predefined_type() {
			return getRuleContext(Predefined_typeContext.class,0);
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
		enterRule(_localctx, 132, RULE_data_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2387); predefined_type();
			}
		}
		catch (RecognitionException re) {
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
		public TerminalNode TRIGGER() { return getToken(SQLParser.TRIGGER, 0); }
		public TerminalNode UUID() { return getToken(SQLParser.UUID, 0); }
		public Bit_typeContext bit_type() {
			return getRuleContext(Bit_typeContext.class,0);
		}
		public Network_typeContext network_type() {
			return getRuleContext(Network_typeContext.class,0);
		}
		public Character_string_typeContext character_string_type() {
			return getRuleContext(Character_string_typeContext.class,0);
		}
		public Binary_large_object_string_typeContext binary_large_object_string_type() {
			return getRuleContext(Binary_large_object_string_typeContext.class,0);
		}
		public Boolean_typeContext boolean_type() {
			return getRuleContext(Boolean_typeContext.class,0);
		}
		public National_character_string_typeContext national_character_string_type() {
			return getRuleContext(National_character_string_typeContext.class,0);
		}
		public Numeric_typeContext numeric_type() {
			return getRuleContext(Numeric_typeContext.class,0);
		}
		public Binary_typeContext binary_type() {
			return getRuleContext(Binary_typeContext.class,0);
		}
		public Datetime_typeContext datetime_type() {
			return getRuleContext(Datetime_typeContext.class,0);
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
		enterRule(_localctx, 134, RULE_predefined_type);
		try {
			setState(2401);
			switch (_input.LA(1)) {
			case CHARACTER:
			case CHAR:
			case VARCHAR:
			case TEXT:
				enterOuterAlt(_localctx, 1);
				{
				setState(2389); character_string_type();
				}
				break;
			case NATIONAL:
			case NCHAR:
			case NVARCHAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(2390); national_character_string_type();
				}
				break;
			case BLOB:
			case BYTEA:
				enterOuterAlt(_localctx, 3);
				{
				setState(2391); binary_large_object_string_type();
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
				setState(2392); numeric_type();
				}
				break;
			case BOOLEAN:
			case BOOL:
				enterOuterAlt(_localctx, 5);
				{
				setState(2393); boolean_type();
				}
				break;
			case DATE:
			case TIME:
			case TIMETZ:
			case TIMESTAMP:
			case TIMESTAMPTZ:
				enterOuterAlt(_localctx, 6);
				{
				setState(2394); datetime_type();
				}
				break;
			case BIT:
			case VARBIT:
				enterOuterAlt(_localctx, 7);
				{
				setState(2395); bit_type();
				}
				break;
			case BINARY:
			case VARBINARY:
				enterOuterAlt(_localctx, 8);
				{
				setState(2396); binary_type();
				}
				break;
			case INET4:
				enterOuterAlt(_localctx, 9);
				{
				setState(2397); network_type();
				}
				break;
			case REGCLASS:
				enterOuterAlt(_localctx, 10);
				{
				setState(2398); regclass();
				}
				break;
			case TRIGGER:
				enterOuterAlt(_localctx, 11);
				{
				setState(2399); match(TRIGGER);
				}
				break;
			case UUID:
				enterOuterAlt(_localctx, 12);
				{
				setState(2400); match(UUID);
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
		enterRule(_localctx, 136, RULE_regclass);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2403); match(REGCLASS);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 138, RULE_network_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2405); match(INET4);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 140, RULE_character_string_type);
		try {
			setState(2430);
			switch ( getInterpreter().adaptivePredict(_input,340,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2407); match(CHARACTER);
				setState(2409);
				switch ( getInterpreter().adaptivePredict(_input,335,_ctx) ) {
				case 1:
					{
					setState(2408); type_length();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2411); match(CHAR);
				setState(2413);
				switch ( getInterpreter().adaptivePredict(_input,336,_ctx) ) {
				case 1:
					{
					setState(2412); type_length();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2415); match(CHARACTER);
				setState(2416); match(VARYING);
				setState(2418);
				switch ( getInterpreter().adaptivePredict(_input,337,_ctx) ) {
				case 1:
					{
					setState(2417); type_length();
					}
					break;
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2420); match(CHAR);
				setState(2421); match(VARYING);
				setState(2423);
				switch ( getInterpreter().adaptivePredict(_input,338,_ctx) ) {
				case 1:
					{
					setState(2422); type_length();
					}
					break;
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2425); match(VARCHAR);
				setState(2427);
				switch ( getInterpreter().adaptivePredict(_input,339,_ctx) ) {
				case 1:
					{
					setState(2426); type_length();
					}
					break;
				}
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2429); match(TEXT);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 142, RULE_type_length);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2432); match(LEFT_PAREN);
			setState(2433); match(NUMBER);
			setState(2434); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 144, RULE_national_character_string_type);
		try {
			setState(2471);
			switch ( getInterpreter().adaptivePredict(_input,348,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2436); match(NATIONAL);
				setState(2437); match(CHARACTER);
				setState(2439);
				switch ( getInterpreter().adaptivePredict(_input,341,_ctx) ) {
				case 1:
					{
					setState(2438); type_length();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2441); match(NATIONAL);
				setState(2442); match(CHAR);
				setState(2444);
				switch ( getInterpreter().adaptivePredict(_input,342,_ctx) ) {
				case 1:
					{
					setState(2443); type_length();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2446); match(NCHAR);
				setState(2448);
				switch ( getInterpreter().adaptivePredict(_input,343,_ctx) ) {
				case 1:
					{
					setState(2447); type_length();
					}
					break;
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2450); match(NATIONAL);
				setState(2451); match(CHARACTER);
				setState(2452); match(VARYING);
				setState(2454);
				switch ( getInterpreter().adaptivePredict(_input,344,_ctx) ) {
				case 1:
					{
					setState(2453); type_length();
					}
					break;
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2456); match(NATIONAL);
				setState(2457); match(CHAR);
				setState(2458); match(VARYING);
				setState(2460);
				switch ( getInterpreter().adaptivePredict(_input,345,_ctx) ) {
				case 1:
					{
					setState(2459); type_length();
					}
					break;
				}
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2462); match(NCHAR);
				setState(2463); match(VARYING);
				setState(2465);
				switch ( getInterpreter().adaptivePredict(_input,346,_ctx) ) {
				case 1:
					{
					setState(2464); type_length();
					}
					break;
				}
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(2467); match(NVARCHAR);
				setState(2469);
				switch ( getInterpreter().adaptivePredict(_input,347,_ctx) ) {
				case 1:
					{
					setState(2468); type_length();
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
		enterRule(_localctx, 146, RULE_binary_large_object_string_type);
		try {
			setState(2481);
			switch (_input.LA(1)) {
			case BLOB:
				enterOuterAlt(_localctx, 1);
				{
				setState(2473); match(BLOB);
				setState(2475);
				switch ( getInterpreter().adaptivePredict(_input,349,_ctx) ) {
				case 1:
					{
					setState(2474); type_length();
					}
					break;
				}
				}
				break;
			case BYTEA:
				enterOuterAlt(_localctx, 2);
				{
				setState(2477); match(BYTEA);
				setState(2479);
				switch ( getInterpreter().adaptivePredict(_input,350,_ctx) ) {
				case 1:
					{
					setState(2478); type_length();
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
		enterRule(_localctx, 148, RULE_numeric_type);
		try {
			setState(2485);
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
				setState(2483); exact_numeric_type();
				}
				break;
			case FLOAT4:
			case FLOAT8:
			case REAL:
			case FLOAT:
			case DOUBLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(2484); approximate_numeric_type();
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
		enterRule(_localctx, 150, RULE_exact_numeric_type);
		try {
			setState(2508);
			switch (_input.LA(1)) {
			case NUMERIC:
				enterOuterAlt(_localctx, 1);
				{
				setState(2487); match(NUMERIC);
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
			case DECIMAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(2491); match(DECIMAL);
				setState(2493);
				switch ( getInterpreter().adaptivePredict(_input,354,_ctx) ) {
				case 1:
					{
					setState(2492); precision_param();
					}
					break;
				}
				}
				break;
			case DEC:
				enterOuterAlt(_localctx, 3);
				{
				setState(2495); match(DEC);
				setState(2497);
				switch ( getInterpreter().adaptivePredict(_input,355,_ctx) ) {
				case 1:
					{
					setState(2496); precision_param();
					}
					break;
				}
				}
				break;
			case INT1:
				enterOuterAlt(_localctx, 4);
				{
				setState(2499); match(INT1);
				}
				break;
			case TINYINT:
				enterOuterAlt(_localctx, 5);
				{
				setState(2500); match(TINYINT);
				}
				break;
			case INT2:
				enterOuterAlt(_localctx, 6);
				{
				setState(2501); match(INT2);
				}
				break;
			case SMALLINT:
				enterOuterAlt(_localctx, 7);
				{
				setState(2502); match(SMALLINT);
				}
				break;
			case INT4:
				enterOuterAlt(_localctx, 8);
				{
				setState(2503); match(INT4);
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 9);
				{
				setState(2504); match(INT);
				}
				break;
			case INTEGER:
				enterOuterAlt(_localctx, 10);
				{
				setState(2505); match(INTEGER);
				}
				break;
			case INT8:
				enterOuterAlt(_localctx, 11);
				{
				setState(2506); match(INT8);
				}
				break;
			case BIGINT:
				enterOuterAlt(_localctx, 12);
				{
				setState(2507); match(BIGINT);
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
		enterRule(_localctx, 152, RULE_approximate_numeric_type);
		try {
			setState(2520);
			switch ( getInterpreter().adaptivePredict(_input,358,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2510); match(FLOAT);
				setState(2512);
				switch ( getInterpreter().adaptivePredict(_input,357,_ctx) ) {
				case 1:
					{
					setState(2511); precision_param();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2514); match(FLOAT4);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2515); match(REAL);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2516); match(FLOAT8);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2517); match(DOUBLE);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2518); match(DOUBLE);
				setState(2519); match(PRECISION);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 154, RULE_precision_param);
		try {
			setState(2530);
			switch ( getInterpreter().adaptivePredict(_input,359,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2522); match(LEFT_PAREN);
				setState(2523); ((Precision_paramContext)_localctx).precision = match(NUMBER);
				setState(2524); match(RIGHT_PAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2525); match(LEFT_PAREN);
				setState(2526); ((Precision_paramContext)_localctx).precision = match(NUMBER);
				setState(2527); match(COMMA);
				setState(2528); ((Precision_paramContext)_localctx).scale = match(NUMBER);
				setState(2529); match(RIGHT_PAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 156, RULE_boolean_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2532);
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
		enterRule(_localctx, 158, RULE_datetime_type);
		try {
			setState(2547);
			switch ( getInterpreter().adaptivePredict(_input,360,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2534); match(DATE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2535); match(TIME);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2536); match(TIME);
				setState(2537); match(WITH);
				setState(2538); match(TIME);
				setState(2539); match(ZONE);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2540); match(TIMETZ);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2541); match(TIMESTAMP);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2542); match(TIMESTAMP);
				setState(2543); match(WITH);
				setState(2544); match(TIME);
				setState(2545); match(ZONE);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(2546); match(TIMESTAMPTZ);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 160, RULE_bit_type);
		try {
			setState(2562);
			switch ( getInterpreter().adaptivePredict(_input,364,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2549); match(BIT);
				setState(2551);
				switch ( getInterpreter().adaptivePredict(_input,361,_ctx) ) {
				case 1:
					{
					setState(2550); type_length();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2553); match(VARBIT);
				setState(2555);
				switch ( getInterpreter().adaptivePredict(_input,362,_ctx) ) {
				case 1:
					{
					setState(2554); type_length();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2557); match(BIT);
				setState(2558); match(VARYING);
				setState(2560);
				switch ( getInterpreter().adaptivePredict(_input,363,_ctx) ) {
				case 1:
					{
					setState(2559); type_length();
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
		enterRule(_localctx, 162, RULE_binary_type);
		try {
			setState(2577);
			switch ( getInterpreter().adaptivePredict(_input,368,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2564); match(BINARY);
				setState(2566);
				switch ( getInterpreter().adaptivePredict(_input,365,_ctx) ) {
				case 1:
					{
					setState(2565); type_length();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2568); match(BINARY);
				setState(2569); match(VARYING);
				setState(2571);
				switch ( getInterpreter().adaptivePredict(_input,366,_ctx) ) {
				case 1:
					{
					setState(2570); type_length();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2573); match(VARBINARY);
				setState(2575);
				switch ( getInterpreter().adaptivePredict(_input,367,_ctx) ) {
				case 1:
					{
					setState(2574); type_length();
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
		enterRule(_localctx, 164, RULE_value_expression_primary);
		try {
			setState(2581);
			switch ( getInterpreter().adaptivePredict(_input,369,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2579); parenthesized_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2580); nonparenthesized_value_expression_primary();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 166, RULE_parenthesized_value_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2583); match(LEFT_PAREN);
			setState(2584); value_expression();
			setState(2585); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 168, RULE_nonparenthesized_value_expression_primary);
		try {
			setState(2594);
			switch ( getInterpreter().adaptivePredict(_input,370,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2587); unsigned_value_specification();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2588); column_reference();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2589); set_function_specification();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2590); scalar_subquery();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2591); case_expression();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2592); cast_specification();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(2593); routine_invocation();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 170, RULE_unsigned_value_specification);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2596); unsigned_literal();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 172, RULE_unsigned_numeric_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2598);
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
		enterRule(_localctx, 174, RULE_signed_numerical_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2601);
			_la = _input.LA(1);
			if (_la==PLUS || _la==MINUS) {
				{
				setState(2600); sign();
				}
			}

			setState(2603); unsigned_numeric_literal();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 176, RULE_set_function_specification);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2605); aggregate_function();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 178, RULE_aggregate_function);
		try {
			setState(2615);
			switch ( getInterpreter().adaptivePredict(_input,373,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2607); match(COUNT);
				setState(2608); match(LEFT_PAREN);
				setState(2609); match(MULTIPLY);
				setState(2610); match(RIGHT_PAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2611); general_set_function();
				setState(2613);
				switch ( getInterpreter().adaptivePredict(_input,372,_ctx) ) {
				case 1:
					{
					setState(2612); filter_clause();
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
		enterRule(_localctx, 180, RULE_general_set_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2617); set_function_type();
			setState(2618); match(LEFT_PAREN);
			setState(2620);
			_la = _input.LA(1);
			if (_la==ALL || _la==DISTINCT) {
				{
				setState(2619); set_qualifier();
				}
			}

			setState(2622); value_expression();
			setState(2623); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 182, RULE_set_function_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2625);
			_la = _input.LA(1);
			if ( !(_la==ANY || ((((_la - 105)) & ~0x3f) == 0 && ((1L << (_la - 105)) & ((1L << (SOME - 105)) | (1L << (AVG - 105)) | (1L << (COLLECT - 105)) | (1L << (COUNT - 105)) | (1L << (EVERY - 105)) | (1L << (FUSION - 105)))) != 0) || ((((_la - 177)) & ~0x3f) == 0 && ((1L << (_la - 177)) & ((1L << (INTERSECTION - 177)) | (1L << (MAX - 177)) | (1L << (MIN - 177)) | (1L << (STDDEV_POP - 177)) | (1L << (STDDEV_SAMP - 177)) | (1L << (SUM - 177)))) != 0) || _la==VAR_SAMP || _la==VAR_POP) ) {
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
		enterRule(_localctx, 184, RULE_filter_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2627); match(FILTER);
			setState(2628); match(LEFT_PAREN);
			setState(2629); match(WHERE);
			setState(2630); search_condition();
			setState(2631); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 186, RULE_grouping_operation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2633); match(GROUPING);
			setState(2634); match(LEFT_PAREN);
			setState(2635); column_reference_list();
			setState(2636); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 188, RULE_case_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2638); case_specification();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 190, RULE_case_abbreviation);
		int _la;
		try {
			setState(2658);
			switch (_input.LA(1)) {
			case NULLIF:
				enterOuterAlt(_localctx, 1);
				{
				setState(2640); match(NULLIF);
				setState(2641); match(LEFT_PAREN);
				setState(2642); numeric_value_expression();
				setState(2643); match(COMMA);
				setState(2644); boolean_value_expression();
				setState(2645); match(RIGHT_PAREN);
				}
				break;
			case COALESCE:
				enterOuterAlt(_localctx, 2);
				{
				setState(2647); match(COALESCE);
				setState(2648); match(LEFT_PAREN);
				setState(2649); numeric_value_expression();
				setState(2652); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(2650); match(COMMA);
					setState(2651); boolean_value_expression();
					}
					}
					setState(2654); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==COMMA );
				setState(2656); match(RIGHT_PAREN);
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
		enterRule(_localctx, 192, RULE_case_specification);
		try {
			setState(2662);
			switch ( getInterpreter().adaptivePredict(_input,377,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2660); simple_case();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2661); searched_case();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 194, RULE_simple_case);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2664); match(CASE);
			setState(2665); boolean_value_expression();
			setState(2667); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(2666); simple_when_clause();
				}
				}
				setState(2669); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WHEN );
			setState(2672);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(2671); else_clause();
				}
			}

			setState(2674); match(END);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 196, RULE_searched_case);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2676); match(CASE);
			setState(2678); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(2677); searched_when_clause();
				}
				}
				setState(2680); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WHEN );
			setState(2683);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(2682); else_clause();
				}
			}

			setState(2685); match(END);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 198, RULE_simple_when_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2687); match(WHEN);
			setState(2688); search_condition();
			setState(2689); match(THEN);
			setState(2690); result();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 200, RULE_searched_when_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2692); match(WHEN);
			setState(2693); ((Searched_when_clauseContext)_localctx).c = search_condition();
			setState(2694); match(THEN);
			setState(2695); ((Searched_when_clauseContext)_localctx).r = result();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 202, RULE_else_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2697); match(ELSE);
			setState(2698); ((Else_clauseContext)_localctx).r = result();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 204, RULE_result);
		try {
			setState(2702);
			switch ( getInterpreter().adaptivePredict(_input,382,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2700); value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2701); match(NULL);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 206, RULE_cast_specification);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2704); match(CAST);
			setState(2705); match(LEFT_PAREN);
			setState(2706); cast_operand();
			setState(2707); match(AS);
			setState(2708); cast_target();
			setState(2709); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 208, RULE_cast_operand);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2711); value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 210, RULE_cast_target);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2713); data_type();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 212, RULE_value_expression);
		try {
			setState(2718);
			switch ( getInterpreter().adaptivePredict(_input,383,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2715); common_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2716); row_value_expression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2717); boolean_value_expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 214, RULE_common_value_expression);
		try {
			setState(2723);
			switch ( getInterpreter().adaptivePredict(_input,384,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2720); numeric_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2721); string_value_expression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2722); match(NULL);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 216, RULE_numeric_value_expression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2725); ((Numeric_value_expressionContext)_localctx).left = term();
			setState(2730);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,385,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(2726);
					_la = _input.LA(1);
					if ( !(_la==PLUS || _la==MINUS) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(2727); ((Numeric_value_expressionContext)_localctx).right = term();
					}
					} 
				}
				setState(2732);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,385,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 218, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2733); ((TermContext)_localctx).left = factor();
			setState(2738);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 312)) & ~0x3f) == 0 && ((1L << (_la - 312)) & ((1L << (MULTIPLY - 312)) | (1L << (DIVIDE - 312)) | (1L << (MODULAR - 312)))) != 0)) {
				{
				{
				setState(2734);
				_la = _input.LA(1);
				if ( !(((((_la - 312)) & ~0x3f) == 0 && ((1L << (_la - 312)) & ((1L << (MULTIPLY - 312)) | (1L << (DIVIDE - 312)) | (1L << (MODULAR - 312)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(2735); ((TermContext)_localctx).right = factor();
				}
				}
				setState(2740);
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
		enterRule(_localctx, 220, RULE_factor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2742);
			_la = _input.LA(1);
			if (_la==PLUS || _la==MINUS) {
				{
				setState(2741); sign();
				}
			}

			setState(2744); numeric_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 222, RULE_array);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2746); match(LEFT_PAREN);
			setState(2747); numeric_value_expression();
			setState(2752);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2748); match(COMMA);
				setState(2749); numeric_value_expression();
				}
				}
				setState(2754);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2755); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 224, RULE_numeric_primary);
		int _la;
		try {
			setState(2766);
			switch ( getInterpreter().adaptivePredict(_input,390,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2757); value_expression_primary();
				setState(2762);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CAST_EXPRESSION) {
					{
					{
					setState(2758); match(CAST_EXPRESSION);
					setState(2759); cast_target();
					}
					}
					setState(2764);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2765); numeric_value_function();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 226, RULE_sign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2768);
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
		enterRule(_localctx, 228, RULE_numeric_value_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2770); extract_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 230, RULE_extract_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2772); match(EXTRACT);
			setState(2773); match(LEFT_PAREN);
			setState(2774); ((Extract_expressionContext)_localctx).extract_field_string = extract_field();
			setState(2775); match(FROM);
			setState(2776); extract_source();
			setState(2777); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 232, RULE_extract_field);
		try {
			setState(2782);
			switch (_input.LA(1)) {
			case DAY:
			case HOUR:
			case MINUTE:
			case MONTH:
			case SECOND:
			case YEAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(2779); primary_datetime_field();
				}
				break;
			case TIMEZONE:
			case TIMEZONE_HOUR:
			case TIMEZONE_MINUTE:
				enterOuterAlt(_localctx, 2);
				{
				setState(2780); time_zone_field();
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
				setState(2781); extended_datetime_field();
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
		enterRule(_localctx, 234, RULE_time_zone_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2784);
			_la = _input.LA(1);
			if ( !(((((_la - 236)) & ~0x3f) == 0 && ((1L << (_la - 236)) & ((1L << (TIMEZONE - 236)) | (1L << (TIMEZONE_HOUR - 236)) | (1L << (TIMEZONE_MINUTE - 236)))) != 0)) ) {
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
		enterRule(_localctx, 236, RULE_extract_source);
		try {
			setState(2788);
			switch ( getInterpreter().adaptivePredict(_input,392,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2786); column_reference();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2787); datetime_literal();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 238, RULE_string_value_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2790); character_value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 240, RULE_character_value_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2792); character_factor();
			setState(2797);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CONCATENATION_OPERATOR) {
				{
				{
				setState(2793); match(CONCATENATION_OPERATOR);
				setState(2794); character_factor();
				}
				}
				setState(2799);
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
		enterRule(_localctx, 242, RULE_character_factor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2800); character_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 244, RULE_character_primary);
		try {
			setState(2804);
			switch ( getInterpreter().adaptivePredict(_input,394,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2802); value_expression_primary();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2803); string_value_function();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 246, RULE_string_value_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2806); trim_function();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 248, RULE_trim_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2808); match(TRIM);
			setState(2809); match(LEFT_PAREN);
			setState(2810); trim_operands();
			setState(2811); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 250, RULE_trim_operands);
		int _la;
		try {
			setState(2827);
			switch ( getInterpreter().adaptivePredict(_input,398,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2820);
				switch ( getInterpreter().adaptivePredict(_input,397,_ctx) ) {
				case 1:
					{
					setState(2814);
					_la = _input.LA(1);
					if (_la==BOTH || _la==LEADING || _la==TRAILING) {
						{
						setState(2813); trim_specification();
						}
					}

					setState(2817);
					_la = _input.LA(1);
					if (((((_la - 6)) & ~0x3f) == 0 && ((1L << (_la - 6)) & ((1L << (ANY - 6)) | (1L << (CASE - 6)) | (1L << (CAST - 6)) | (1L << (FALSE - 6)) | (1L << (LEFT - 6)))) != 0) || ((((_la - 98)) & ~0x3f) == 0 && ((1L << (_la - 98)) & ((1L << (RIGHT - 98)) | (1L << (SOME - 98)) | (1L << (TRUE - 98)) | (1L << (ADMIN - 98)) | (1L << (AVG - 98)) | (1L << (BETWEEN - 98)) | (1L << (BY - 98)) | (1L << (CACHE - 98)) | (1L << (CALLED - 98)) | (1L << (CLASS - 98)) | (1L << (CENTURY - 98)) | (1L << (CHARACTER - 98)) | (1L << (CHECK - 98)) | (1L << (COLLECT - 98)) | (1L << (COALESCE - 98)) | (1L << (COLUMN - 98)) | (1L << (COMMENT - 98)) | (1L << (COMMENTS - 98)) | (1L << (COMMIT - 98)) | (1L << (CONFIGURATION - 98)) | (1L << (COST - 98)) | (1L << (COUNT - 98)) | (1L << (CUBE - 98)) | (1L << (CURRENT - 98)) | (1L << (CYCLE - 98)) | (1L << (DATA - 98)) | (1L << (DAY - 98)) | (1L << (DEC - 98)) | (1L << (DECADE - 98)) | (1L << (DEFINER - 98)) | (1L << (DICTIONARY - 98)) | (1L << (DOW - 98)) | (1L << (DOY - 98)) | (1L << (DROP - 98)) | (1L << (EPOCH - 98)) | (1L << (EVERY - 98)) | (1L << (EXISTS - 98)))) != 0) || ((((_la - 162)) & ~0x3f) == 0 && ((1L << (_la - 162)) & ((1L << (EXTERNAL - 162)) | (1L << (EXTRACT - 162)) | (1L << (FAMILY - 162)) | (1L << (FILTER - 162)) | (1L << (FIRST - 162)) | (1L << (FORMAT - 162)) | (1L << (FUSION - 162)) | (1L << (GROUPING - 162)) | (1L << (HASH - 162)) | (1L << (INDEX - 162)) | (1L << (INCREMENT - 162)) | (1L << (INPUT - 162)) | (1L << (INSERT - 162)) | (1L << (INTERSECTION - 162)) | (1L << (ISCACHABLE - 162)) | (1L << (ISODOW - 162)) | (1L << (ISOYEAR - 162)) | (1L << (ISSTRICT - 162)) | (1L << (LANGUAGE - 162)) | (1L << (LARGE - 162)) | (1L << (LAST - 162)) | (1L << (LESS - 162)) | (1L << (LIST - 162)) | (1L << (LOCATION - 162)) | (1L << (MATCH - 162)) | (1L << (MAX - 162)) | (1L << (MAXVALUE - 162)) | (1L << (MICROSECONDS - 162)) | (1L << (MILLENNIUM - 162)) | (1L << (MILLISECONDS - 162)) | (1L << (MIN - 162)) | (1L << (MINVALUE - 162)) | (1L << (MINUTE - 162)) | (1L << (MONTH - 162)) | (1L << (NATIONAL - 162)) | (1L << (NO - 162)) | (1L << (NONE - 162)) | (1L << (NULLIF - 162)) | (1L << (OBJECT - 162)) | (1L << (OPTION - 162)) | (1L << (OPTIONS - 162)) | (1L << (OVERWRITE - 162)) | (1L << (PARSER - 162)) | (1L << (PARTIAL - 162)) | (1L << (PARTITION - 162)) | (1L << (PARTITIONS - 162)) | (1L << (PRECISION - 162)) | (1L << (PUBLIC - 162)) | (1L << (PURGE - 162)) | (1L << (QUARTER - 162)) | (1L << (RANGE - 162)) | (1L << (REGEXP - 162)) | (1L << (RLIKE - 162)) | (1L << (ROLLUP - 162)) | (1L << (SEARCH - 162)) | (1L << (SECOND - 162)) | (1L << (SECURITY - 162)) | (1L << (SERVER - 162)) | (1L << (SET - 162)) | (1L << (SIMILAR - 162)) | (1L << (SIMPLE - 162)) | (1L << (STABLE - 162)))) != 0) || ((((_la - 226)) & ~0x3f) == 0 && ((1L << (_la - 226)) & ((1L << (START - 226)) | (1L << (STORAGE - 226)) | (1L << (STDDEV_POP - 226)) | (1L << (STDDEV_SAMP - 226)) | (1L << (SUBPARTITION - 226)) | (1L << (SUM - 226)) | (1L << (TABLESPACE - 226)) | (1L << (TEMPLATE - 226)) | (1L << (THAN - 226)) | (1L << (TIMEZONE - 226)) | (1L << (TIMEZONE_HOUR - 226)) | (1L << (TIMEZONE_MINUTE - 226)) | (1L << (TRIM - 226)) | (1L << (TO - 226)) | (1L << (TYPE - 226)) | (1L << (UNKNOWN - 226)) | (1L << (UNLOGGED - 226)) | (1L << (VALUES - 226)) | (1L << (VAR_SAMP - 226)) | (1L << (VAR_POP - 226)) | (1L << (VARYING - 226)) | (1L << (VOLATILE - 226)) | (1L << (WEEK - 226)) | (1L << (WINDOW - 226)) | (1L << (WRAPPER - 226)) | (1L << (YEAR - 226)) | (1L << (ZONE - 226)) | (1L << (BOOLEAN - 226)) | (1L << (BOOL - 226)) | (1L << (BIT - 226)) | (1L << (VARBIT - 226)) | (1L << (INT1 - 226)) | (1L << (INT2 - 226)) | (1L << (INT4 - 226)) | (1L << (INT8 - 226)) | (1L << (TINYINT - 226)) | (1L << (SMALLINT - 226)) | (1L << (INT - 226)) | (1L << (INTEGER - 226)) | (1L << (BIGINT - 226)) | (1L << (FLOAT4 - 226)) | (1L << (FLOAT8 - 226)) | (1L << (REAL - 226)) | (1L << (FLOAT - 226)) | (1L << (DOUBLE - 226)) | (1L << (NUMERIC - 226)) | (1L << (DECIMAL - 226)) | (1L << (CHAR - 226)) | (1L << (VARCHAR - 226)) | (1L << (NCHAR - 226)) | (1L << (NVARCHAR - 226)) | (1L << (DATE - 226)) | (1L << (TIME - 226)) | (1L << (TIMETZ - 226)) | (1L << (TIMESTAMP - 226)) | (1L << (TIMESTAMPTZ - 226)) | (1L << (TEXT - 226)) | (1L << (UUID - 226)) | (1L << (VARBINARY - 226)) | (1L << (BLOB - 226)))) != 0) || ((((_la - 290)) & ~0x3f) == 0 && ((1L << (_la - 290)) & ((1L << (BYTEA - 290)) | (1L << (INET4 - 290)) | (1L << (LEFT_PAREN - 290)) | (1L << (DOUBLE_QUOTE - 290)) | (1L << (NUMBER - 290)) | (1L << (REAL_NUMBER - 290)) | (1L << (Identifier - 290)) | (1L << (Character_String_Literal - 290)))) != 0)) {
						{
						setState(2816); ((Trim_operandsContext)_localctx).trim_character = character_value_expression();
						}
					}

					setState(2819); match(FROM);
					}
					break;
				}
				setState(2822); ((Trim_operandsContext)_localctx).trim_source = character_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2823); ((Trim_operandsContext)_localctx).trim_source = character_value_expression();
				setState(2824); match(COMMA);
				setState(2825); ((Trim_operandsContext)_localctx).trim_character = character_value_expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 252, RULE_trim_specification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2829);
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
		enterRule(_localctx, 254, RULE_boolean_value_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2831); or_predicate();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 256, RULE_or_predicate);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2833); and_predicate();
			setState(2838);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,399,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(2834); match(OR);
					setState(2835); or_predicate();
					}
					} 
				}
				setState(2840);
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
		enterRule(_localctx, 258, RULE_and_predicate);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2841); boolean_factor();
			setState(2846);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,400,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(2842); match(AND);
					setState(2843); and_predicate();
					}
					} 
				}
				setState(2848);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,400,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 260, RULE_boolean_factor);
		try {
			setState(2852);
			switch ( getInterpreter().adaptivePredict(_input,401,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2849); boolean_test();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2850); match(NOT);
				setState(2851); boolean_test();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 262, RULE_boolean_test);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2854); boolean_primary();
			setState(2856);
			_la = _input.LA(1);
			if (_la==IS) {
				{
				setState(2855); is_clause();
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
		enterRule(_localctx, 264, RULE_is_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2858); match(IS);
			setState(2860);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(2859); match(NOT);
				}
			}

			setState(2862); ((Is_clauseContext)_localctx).t = truth_value();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 266, RULE_truth_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2864);
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
		enterRule(_localctx, 268, RULE_boolean_primary);
		try {
			setState(2868);
			switch ( getInterpreter().adaptivePredict(_input,404,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2866); predicate();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2867); boolean_predicand();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 270, RULE_boolean_predicand);
		try {
			setState(2872);
			switch ( getInterpreter().adaptivePredict(_input,405,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2870); parenthesized_boolean_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2871); nonparenthesized_value_expression_primary();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 272, RULE_parenthesized_boolean_value_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2874); match(LEFT_PAREN);
			setState(2875); boolean_value_expression();
			setState(2876); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 274, RULE_row_value_expression);
		try {
			setState(2880);
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
			case LEFT_PAREN:
			case DOUBLE_QUOTE:
			case NUMBER:
			case REAL_NUMBER:
			case Identifier:
			case Character_String_Literal:
				enterOuterAlt(_localctx, 1);
				{
				setState(2878); row_value_special_case();
				}
				break;
			case NULL:
				enterOuterAlt(_localctx, 2);
				{
				setState(2879); explicit_row_value_constructor();
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
		enterRule(_localctx, 276, RULE_row_value_special_case);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2882); nonparenthesized_value_expression_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 278, RULE_explicit_row_value_constructor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2884); match(NULL);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 280, RULE_row_value_predicand);
		try {
			setState(2888);
			switch ( getInterpreter().adaptivePredict(_input,407,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2886); row_value_special_case();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2887); row_value_constructor_predicand();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 282, RULE_row_value_constructor_predicand);
		try {
			setState(2892);
			switch ( getInterpreter().adaptivePredict(_input,408,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2890); common_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2891); boolean_predicand();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 284, RULE_table_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2894); from_clause();
			setState(2896);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(2895); where_clause();
				}
			}

			setState(2899);
			_la = _input.LA(1);
			if (_la==GROUP) {
				{
				setState(2898); groupby_clause();
				}
			}

			setState(2902);
			_la = _input.LA(1);
			if (_la==HAVING) {
				{
				setState(2901); having_clause();
				}
			}

			setState(2905);
			_la = _input.LA(1);
			if (_la==ORDER) {
				{
				setState(2904); orderby_clause();
				}
			}

			setState(2908);
			_la = _input.LA(1);
			if (_la==LIMIT) {
				{
				setState(2907); limit_clause();
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
		enterRule(_localctx, 286, RULE_from_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2910); match(FROM);
			setState(2911); table_reference_list();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 288, RULE_table_reference_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2913); table_reference();
			setState(2918);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2914); match(COMMA);
				setState(2915); table_reference();
				}
				}
				setState(2920);
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
		enterRule(_localctx, 290, RULE_table_reference);
		try {
			setState(2923);
			switch ( getInterpreter().adaptivePredict(_input,415,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2921); joined_table();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2922); table_primary();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 292, RULE_joined_table);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2925); table_primary();
			setState(2927); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(2926); joined_table_primary();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(2929); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,416,_ctx);
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
		enterRule(_localctx, 294, RULE_joined_table_primary);
		int _la;
		try {
			setState(2950);
			switch (_input.LA(1)) {
			case CROSS:
				enterOuterAlt(_localctx, 1);
				{
				setState(2931); match(CROSS);
				setState(2932); match(JOIN);
				setState(2933); ((Joined_table_primaryContext)_localctx).right = table_primary();
				}
				break;
			case FULL:
			case INNER:
			case JOIN:
			case LEFT:
			case RIGHT:
				enterOuterAlt(_localctx, 2);
				{
				setState(2935);
				_la = _input.LA(1);
				if (((((_la - 43)) & ~0x3f) == 0 && ((1L << (_la - 43)) & ((1L << (FULL - 43)) | (1L << (INNER - 43)) | (1L << (LEFT - 43)) | (1L << (RIGHT - 43)))) != 0)) {
					{
					setState(2934); ((Joined_table_primaryContext)_localctx).t = join_type();
					}
				}

				setState(2937); match(JOIN);
				setState(2938); ((Joined_table_primaryContext)_localctx).right = table_primary();
				setState(2939); ((Joined_table_primaryContext)_localctx).s = join_specification();
				}
				break;
			case NATURAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(2941); match(NATURAL);
				setState(2943);
				_la = _input.LA(1);
				if (((((_la - 43)) & ~0x3f) == 0 && ((1L << (_la - 43)) & ((1L << (FULL - 43)) | (1L << (INNER - 43)) | (1L << (LEFT - 43)) | (1L << (RIGHT - 43)))) != 0)) {
					{
					setState(2942); ((Joined_table_primaryContext)_localctx).t = join_type();
					}
				}

				setState(2945); match(JOIN);
				setState(2946); ((Joined_table_primaryContext)_localctx).right = table_primary();
				}
				break;
			case UNION:
				enterOuterAlt(_localctx, 4);
				{
				setState(2947); match(UNION);
				setState(2948); match(JOIN);
				setState(2949); ((Joined_table_primaryContext)_localctx).right = table_primary();
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
		enterRule(_localctx, 296, RULE_cross_join);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2952); match(CROSS);
			setState(2953); match(JOIN);
			setState(2954); ((Cross_joinContext)_localctx).r = table_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 298, RULE_qualified_join);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2957);
			_la = _input.LA(1);
			if (((((_la - 43)) & ~0x3f) == 0 && ((1L << (_la - 43)) & ((1L << (FULL - 43)) | (1L << (INNER - 43)) | (1L << (LEFT - 43)) | (1L << (RIGHT - 43)))) != 0)) {
				{
				setState(2956); ((Qualified_joinContext)_localctx).t = join_type();
				}
			}

			setState(2959); match(JOIN);
			setState(2960); ((Qualified_joinContext)_localctx).r = table_primary();
			setState(2961); ((Qualified_joinContext)_localctx).s = join_specification();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 300, RULE_natural_join);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2963); match(NATURAL);
			setState(2965);
			_la = _input.LA(1);
			if (((((_la - 43)) & ~0x3f) == 0 && ((1L << (_la - 43)) & ((1L << (FULL - 43)) | (1L << (INNER - 43)) | (1L << (LEFT - 43)) | (1L << (RIGHT - 43)))) != 0)) {
				{
				setState(2964); ((Natural_joinContext)_localctx).t = join_type();
				}
			}

			setState(2967); match(JOIN);
			setState(2968); ((Natural_joinContext)_localctx).r = table_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 302, RULE_union_join);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2970); match(UNION);
			setState(2971); match(JOIN);
			setState(2972); ((Union_joinContext)_localctx).r = table_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 304, RULE_join_type);
		try {
			setState(2976);
			switch (_input.LA(1)) {
			case INNER:
				enterOuterAlt(_localctx, 1);
				{
				setState(2974); match(INNER);
				}
				break;
			case FULL:
			case LEFT:
			case RIGHT:
				enterOuterAlt(_localctx, 2);
				{
				setState(2975); ((Join_typeContext)_localctx).t = outer_join_type();
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
		enterRule(_localctx, 306, RULE_outer_join_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2978); outer_join_type_part2();
			setState(2980);
			_la = _input.LA(1);
			if (_la==OUTER) {
				{
				setState(2979); match(OUTER);
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
		enterRule(_localctx, 308, RULE_outer_join_type_part2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2982);
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
		enterRule(_localctx, 310, RULE_join_specification);
		try {
			setState(2986);
			switch (_input.LA(1)) {
			case ON:
				enterOuterAlt(_localctx, 1);
				{
				setState(2984); join_condition();
				}
				break;
			case USING:
				enterOuterAlt(_localctx, 2);
				{
				setState(2985); named_columns_join();
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
		enterRule(_localctx, 312, RULE_join_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2988); match(ON);
			setState(2989); search_condition();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 314, RULE_named_columns_join);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2991); match(USING);
			setState(2992); match(LEFT_PAREN);
			setState(2993); ((Named_columns_joinContext)_localctx).f = column_reference_list();
			setState(2994); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 316, RULE_table_primary);
		int _la;
		try {
			setState(3020);
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
			case DOUBLE_QUOTE:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(2996); table_or_query_name();
				setState(3001);
				switch ( getInterpreter().adaptivePredict(_input,426,_ctx) ) {
				case 1:
					{
					setState(2998);
					_la = _input.LA(1);
					if (_la==AS) {
						{
						setState(2997); match(AS);
						}
					}

					setState(3000); ((Table_primaryContext)_localctx).alias = identifier();
					}
					break;
				}
				setState(3007);
				switch ( getInterpreter().adaptivePredict(_input,427,_ctx) ) {
				case 1:
					{
					setState(3003); match(LEFT_PAREN);
					setState(3004); column_name_list();
					setState(3005); match(RIGHT_PAREN);
					}
					break;
				}
				}
				break;
			case LEFT_PAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(3009); derived_table();
				setState(3011);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(3010); match(AS);
					}
				}

				setState(3013); ((Table_primaryContext)_localctx).name = identifier();
				setState(3018);
				switch ( getInterpreter().adaptivePredict(_input,429,_ctx) ) {
				case 1:
					{
					setState(3014); match(LEFT_PAREN);
					setState(3015); column_name_list();
					setState(3016); match(RIGHT_PAREN);
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
		enterRule(_localctx, 318, RULE_column_name_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3022); identifier();
			setState(3027);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3023); match(COMMA);
				setState(3024); identifier();
				}
				}
				setState(3029);
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
		enterRule(_localctx, 320, RULE_derived_table);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3030); table_subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 322, RULE_where_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3032); match(WHERE);
			setState(3033); search_condition();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 324, RULE_search_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3035); value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 326, RULE_groupby_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3037); match(GROUP);
			setState(3038); match(BY);
			setState(3039); ((Groupby_clauseContext)_localctx).g = grouping_element_list();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 328, RULE_grouping_element_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3041); grouping_element();
			setState(3046);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3042); match(COMMA);
				setState(3043); grouping_element();
				}
				}
				setState(3048);
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
		enterRule(_localctx, 330, RULE_grouping_element);
		try {
			setState(3053);
			switch ( getInterpreter().adaptivePredict(_input,433,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3049); rollup_list();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3050); cube_list();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(3051); empty_grouping_set();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(3052); ordinary_grouping_set();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 332, RULE_ordinary_grouping_set);
		try {
			setState(3060);
			switch ( getInterpreter().adaptivePredict(_input,434,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3055); row_value_predicand();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3056); match(LEFT_PAREN);
				setState(3057); row_value_predicand_list();
				setState(3058); match(RIGHT_PAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 334, RULE_ordinary_grouping_set_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3062); ordinary_grouping_set();
			setState(3067);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3063); match(COMMA);
				setState(3064); ordinary_grouping_set();
				}
				}
				setState(3069);
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
		enterRule(_localctx, 336, RULE_rollup_list);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3070); match(ROLLUP);
			setState(3071); match(LEFT_PAREN);
			setState(3072); ((Rollup_listContext)_localctx).c = ordinary_grouping_set_list();
			setState(3073); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 338, RULE_cube_list);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3075); match(CUBE);
			setState(3076); match(LEFT_PAREN);
			setState(3077); ((Cube_listContext)_localctx).c = ordinary_grouping_set_list();
			setState(3078); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 340, RULE_empty_grouping_set);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3080); match(LEFT_PAREN);
			setState(3081); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 342, RULE_having_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3083); match(HAVING);
			setState(3084); boolean_value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 344, RULE_row_value_predicand_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3086); row_value_predicand();
			setState(3091);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3087); match(COMMA);
				setState(3088); row_value_predicand();
				}
				}
				setState(3093);
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
		enterRule(_localctx, 346, RULE_query_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3094); query_expression_body();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 348, RULE_query_expression_body);
		try {
			setState(3098);
			switch ( getInterpreter().adaptivePredict(_input,437,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3096); non_join_query_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3097); joined_table();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 350, RULE_non_join_query_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3108);
			switch ( getInterpreter().adaptivePredict(_input,439,_ctx) ) {
			case 1:
				{
				setState(3100); non_join_query_term();
				}
				break;
			case 2:
				{
				setState(3101); joined_table();
				setState(3102);
				_la = _input.LA(1);
				if ( !(_la==EXCEPT || _la==UNION) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(3104);
				_la = _input.LA(1);
				if (_la==ALL || _la==DISTINCT) {
					{
					setState(3103);
					_la = _input.LA(1);
					if ( !(_la==ALL || _la==DISTINCT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(3106); query_term();
				}
				break;
			}
			setState(3117);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==EXCEPT || _la==UNION) {
				{
				{
				setState(3110);
				_la = _input.LA(1);
				if ( !(_la==EXCEPT || _la==UNION) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(3112);
				_la = _input.LA(1);
				if (_la==ALL || _la==DISTINCT) {
					{
					setState(3111);
					_la = _input.LA(1);
					if ( !(_la==ALL || _la==DISTINCT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(3114); query_term();
				}
				}
				setState(3119);
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
		enterRule(_localctx, 352, RULE_query_term);
		try {
			setState(3122);
			switch ( getInterpreter().adaptivePredict(_input,442,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3120); non_join_query_term();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3121); joined_table();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 354, RULE_non_join_query_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3132);
			switch ( getInterpreter().adaptivePredict(_input,444,_ctx) ) {
			case 1:
				{
				setState(3124); non_join_query_primary();
				}
				break;
			case 2:
				{
				setState(3125); joined_table();
				setState(3126); match(INTERSECT);
				setState(3128);
				_la = _input.LA(1);
				if (_la==ALL || _la==DISTINCT) {
					{
					setState(3127);
					_la = _input.LA(1);
					if ( !(_la==ALL || _la==DISTINCT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(3130); query_primary();
				}
				break;
			}
			setState(3141);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==INTERSECT) {
				{
				{
				setState(3134); match(INTERSECT);
				setState(3136);
				_la = _input.LA(1);
				if (_la==ALL || _la==DISTINCT) {
					{
					setState(3135);
					_la = _input.LA(1);
					if ( !(_la==ALL || _la==DISTINCT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(3138); query_primary();
				}
				}
				setState(3143);
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
		enterRule(_localctx, 356, RULE_query_primary);
		try {
			setState(3146);
			switch ( getInterpreter().adaptivePredict(_input,447,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3144); non_join_query_primary();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3145); joined_table();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 358, RULE_non_join_query_primary);
		try {
			setState(3153);
			switch (_input.LA(1)) {
			case SELECT:
			case TABLE:
				enterOuterAlt(_localctx, 1);
				{
				setState(3148); simple_table();
				}
				break;
			case LEFT_PAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(3149); match(LEFT_PAREN);
				setState(3150); non_join_query_expression();
				setState(3151); match(RIGHT_PAREN);
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
		enterRule(_localctx, 360, RULE_simple_table);
		try {
			setState(3157);
			switch (_input.LA(1)) {
			case SELECT:
				enterOuterAlt(_localctx, 1);
				{
				setState(3155); query_specification();
				}
				break;
			case TABLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(3156); explicit_table();
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
		enterRule(_localctx, 362, RULE_explicit_table);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3159); match(TABLE);
			setState(3160); table_or_query_name();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 364, RULE_table_or_query_name);
		try {
			setState(3164);
			switch ( getInterpreter().adaptivePredict(_input,450,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3162); schema_qualified_name();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3163); identifier();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 366, RULE_schema_qualified_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3166); identifier();
			setState(3173);
			_la = _input.LA(1);
			if (_la==DOT) {
				{
				setState(3167); match(DOT);
				setState(3168); identifier();
				setState(3171);
				_la = _input.LA(1);
				if (_la==DOT) {
					{
					setState(3169); match(DOT);
					setState(3170); identifier();
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
		enterRule(_localctx, 368, RULE_query_specification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3175); match(SELECT);
			setState(3177);
			_la = _input.LA(1);
			if (_la==ALL || _la==DISTINCT) {
				{
				setState(3176); set_qualifier();
				}
			}

			setState(3179); select_list();
			setState(3181);
			_la = _input.LA(1);
			if (_la==FROM) {
				{
				setState(3180); table_expression();
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
		enterRule(_localctx, 370, RULE_select_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3183); select_sublist();
			setState(3188);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3184); match(COMMA);
				setState(3185); select_sublist();
				}
				}
				setState(3190);
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
		enterRule(_localctx, 372, RULE_select_sublist);
		try {
			setState(3193);
			switch ( getInterpreter().adaptivePredict(_input,456,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3191); derived_column();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3192); qualified_asterisk();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 374, RULE_derived_column);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3195); value_expression();
			setState(3197);
			switch ( getInterpreter().adaptivePredict(_input,457,_ctx) ) {
			case 1:
				{
				setState(3196); as_clause();
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
		enterRule(_localctx, 376, RULE_qualified_asterisk);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3201);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(3199); ((Qualified_asteriskContext)_localctx).tb_name = match(Identifier);
				setState(3200); match(DOT);
				}
			}

			setState(3203); match(MULTIPLY);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 378, RULE_set_qualifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3205);
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
		enterRule(_localctx, 380, RULE_column_reference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3210);
			switch ( getInterpreter().adaptivePredict(_input,459,_ctx) ) {
			case 1:
				{
				setState(3207); ((Column_referenceContext)_localctx).tb_name = identifier();
				setState(3208); match(DOT);
				}
				break;
			}
			setState(3212); ((Column_referenceContext)_localctx).name = identifier();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 382, RULE_as_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3215);
			_la = _input.LA(1);
			if (_la==AS) {
				{
				setState(3214); match(AS);
				}
			}

			setState(3217); identifier();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 384, RULE_column_reference_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3219); column_reference();
			setState(3224);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3220); match(COMMA);
				setState(3221); column_reference();
				}
				}
				setState(3226);
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
		enterRule(_localctx, 386, RULE_scalar_subquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3227); subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 388, RULE_row_subquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3229); subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 390, RULE_table_subquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3231); subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 392, RULE_subquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3233); match(LEFT_PAREN);
			setState(3234); query_expression();
			setState(3235); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 394, RULE_predicate);
		try {
			setState(3243);
			switch ( getInterpreter().adaptivePredict(_input,462,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3237); comparison_predicate();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3238); between_predicate();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(3239); in_predicate();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(3240); pattern_matching_predicate();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(3241); null_predicate();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(3242); exists_predicate();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 396, RULE_comparison_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3245); ((Comparison_predicateContext)_localctx).left = row_value_predicand();
			setState(3246); ((Comparison_predicateContext)_localctx).c = comp_op();
			setState(3247); ((Comparison_predicateContext)_localctx).right = row_value_predicand();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 398, RULE_comp_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3249);
			_la = _input.LA(1);
			if ( !(((((_la - 298)) & ~0x3f) == 0 && ((1L << (_la - 298)) & ((1L << (EQUAL - 298)) | (1L << (NOT_EQUAL - 298)) | (1L << (LTH - 298)) | (1L << (LEQ - 298)) | (1L << (GTH - 298)) | (1L << (GEQ - 298)))) != 0)) ) {
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
		enterRule(_localctx, 400, RULE_between_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3251); ((Between_predicateContext)_localctx).predicand = row_value_predicand();
			setState(3252); between_predicate_part_2();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 402, RULE_between_predicate_part_2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3255);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(3254); match(NOT);
				}
			}

			setState(3257); match(BETWEEN);
			setState(3259);
			_la = _input.LA(1);
			if (_la==ASYMMETRIC || _la==SYMMETRIC) {
				{
				setState(3258);
				_la = _input.LA(1);
				if ( !(_la==ASYMMETRIC || _la==SYMMETRIC) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(3261); ((Between_predicate_part_2Context)_localctx).begin = row_value_predicand();
			setState(3262); match(AND);
			setState(3263); ((Between_predicate_part_2Context)_localctx).end = row_value_predicand();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 404, RULE_in_predicate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3265); ((In_predicateContext)_localctx).predicand = numeric_value_expression();
			setState(3267);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(3266); match(NOT);
				}
			}

			setState(3269); match(IN);
			setState(3270); in_predicate_value();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 406, RULE_in_predicate_value);
		try {
			setState(3277);
			switch ( getInterpreter().adaptivePredict(_input,466,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3272); table_subquery();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3273); match(LEFT_PAREN);
				setState(3274); in_value_list();
				setState(3275); match(RIGHT_PAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 408, RULE_in_value_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3279); row_value_expression();
			setState(3284);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3280); match(COMMA);
				setState(3281); row_value_expression();
				}
				}
				setState(3286);
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
		enterRule(_localctx, 410, RULE_pattern_matching_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3287); ((Pattern_matching_predicateContext)_localctx).f = row_value_predicand();
			setState(3288); pattern_matcher();
			setState(3289); ((Pattern_matching_predicateContext)_localctx).s = match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 412, RULE_pattern_matcher);
		int _la;
		try {
			setState(3296);
			switch (_input.LA(1)) {
			case ILIKE:
			case LIKE:
			case NOT:
			case REGEXP:
			case RLIKE:
			case SIMILAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(3292);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(3291); match(NOT);
					}
				}

				setState(3294); negativable_matcher();
				}
				break;
			case Similar_To:
			case Not_Similar_To:
			case Similar_To_Case_Insensitive:
			case Not_Similar_To_Case_Insensitive:
				enterOuterAlt(_localctx, 2);
				{
				setState(3295); regex_matcher();
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
		enterRule(_localctx, 414, RULE_negativable_matcher);
		try {
			setState(3304);
			switch (_input.LA(1)) {
			case LIKE:
				enterOuterAlt(_localctx, 1);
				{
				setState(3298); match(LIKE);
				}
				break;
			case ILIKE:
				enterOuterAlt(_localctx, 2);
				{
				setState(3299); match(ILIKE);
				}
				break;
			case SIMILAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(3300); match(SIMILAR);
				setState(3301); match(TO);
				}
				break;
			case REGEXP:
				enterOuterAlt(_localctx, 4);
				{
				setState(3302); match(REGEXP);
				}
				break;
			case RLIKE:
				enterOuterAlt(_localctx, 5);
				{
				setState(3303); match(RLIKE);
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
		enterRule(_localctx, 416, RULE_regex_matcher);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3306);
			_la = _input.LA(1);
			if ( !(((((_la - 292)) & ~0x3f) == 0 && ((1L << (_la - 292)) & ((1L << (Similar_To - 292)) | (1L << (Not_Similar_To - 292)) | (1L << (Similar_To_Case_Insensitive - 292)) | (1L << (Not_Similar_To_Case_Insensitive - 292)))) != 0)) ) {
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
		enterRule(_localctx, 418, RULE_null_predicate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3308); ((Null_predicateContext)_localctx).predicand = row_value_predicand();
			setState(3309); match(IS);
			setState(3311);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(3310); ((Null_predicateContext)_localctx).n = match(NOT);
				}
			}

			setState(3313); match(NULL);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 420, RULE_quantified_comparison_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3315); ((Quantified_comparison_predicateContext)_localctx).l = numeric_value_expression();
			setState(3316); ((Quantified_comparison_predicateContext)_localctx).c = comp_op();
			setState(3317); ((Quantified_comparison_predicateContext)_localctx).q = quantifier();
			setState(3318); ((Quantified_comparison_predicateContext)_localctx).s = table_subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 422, RULE_quantifier);
		try {
			setState(3322);
			switch (_input.LA(1)) {
			case ALL:
				enterOuterAlt(_localctx, 1);
				{
				setState(3320); all();
				}
				break;
			case ANY:
			case SOME:
				enterOuterAlt(_localctx, 2);
				{
				setState(3321); some();
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
		enterRule(_localctx, 424, RULE_all);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3324); match(ALL);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 426, RULE_some);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3326);
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
		enterRule(_localctx, 428, RULE_exists_predicate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3329);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(3328); match(NOT);
				}
			}

			setState(3331); match(EXISTS);
			setState(3332); ((Exists_predicateContext)_localctx).s = table_subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 430, RULE_unique_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3334); match(UNIQUE);
			setState(3335); ((Unique_predicateContext)_localctx).s = table_subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 432, RULE_primary_datetime_field);
		try {
			setState(3339);
			switch (_input.LA(1)) {
			case DAY:
			case HOUR:
			case MINUTE:
			case MONTH:
			case YEAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(3337); non_second_primary_datetime_field();
				}
				break;
			case SECOND:
				enterOuterAlt(_localctx, 2);
				{
				setState(3338); match(SECOND);
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
		enterRule(_localctx, 434, RULE_non_second_primary_datetime_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3341);
			_la = _input.LA(1);
			if ( !(((((_la - 151)) & ~0x3f) == 0 && ((1L << (_la - 151)) & ((1L << (DAY - 151)) | (1L << (HOUR - 151)) | (1L << (MINUTE - 151)) | (1L << (MONTH - 151)))) != 0) || _la==YEAR) ) {
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
		enterRule(_localctx, 436, RULE_extended_datetime_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3343);
			_la = _input.LA(1);
			if ( !(((((_la - 135)) & ~0x3f) == 0 && ((1L << (_la - 135)) & ((1L << (CENTURY - 135)) | (1L << (DECADE - 135)) | (1L << (DOW - 135)) | (1L << (DOY - 135)) | (1L << (EPOCH - 135)) | (1L << (ISODOW - 135)) | (1L << (ISOYEAR - 135)) | (1L << (MICROSECONDS - 135)) | (1L << (MILLENNIUM - 135)) | (1L << (MILLISECONDS - 135)))) != 0) || _la==QUARTER || _la==WEEK) ) {
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
		enterRule(_localctx, 438, RULE_routine_invocation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3345); function_name();
			setState(3346); match(LEFT_PAREN);
			setState(3348);
			_la = _input.LA(1);
			if (((((_la - 6)) & ~0x3f) == 0 && ((1L << (_la - 6)) & ((1L << (ANY - 6)) | (1L << (CASE - 6)) | (1L << (CAST - 6)) | (1L << (FALSE - 6)) | (1L << (LEFT - 6)))) != 0) || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & ((1L << (NOT - 74)) | (1L << (NULL - 74)) | (1L << (RIGHT - 74)) | (1L << (SOME - 74)) | (1L << (TRUE - 74)) | (1L << (ADMIN - 74)) | (1L << (AVG - 74)) | (1L << (BETWEEN - 74)) | (1L << (BY - 74)) | (1L << (CACHE - 74)) | (1L << (CALLED - 74)) | (1L << (CLASS - 74)) | (1L << (CENTURY - 74)) | (1L << (CHARACTER - 74)) | (1L << (CHECK - 74)))) != 0) || ((((_la - 138)) & ~0x3f) == 0 && ((1L << (_la - 138)) & ((1L << (COLLECT - 138)) | (1L << (COALESCE - 138)) | (1L << (COLUMN - 138)) | (1L << (COMMENT - 138)) | (1L << (COMMENTS - 138)) | (1L << (COMMIT - 138)) | (1L << (CONFIGURATION - 138)) | (1L << (COST - 138)) | (1L << (COUNT - 138)) | (1L << (CUBE - 138)) | (1L << (CURRENT - 138)) | (1L << (CYCLE - 138)) | (1L << (DATA - 138)) | (1L << (DAY - 138)) | (1L << (DEC - 138)) | (1L << (DECADE - 138)) | (1L << (DEFINER - 138)) | (1L << (DICTIONARY - 138)) | (1L << (DOW - 138)) | (1L << (DOY - 138)) | (1L << (DROP - 138)) | (1L << (EPOCH - 138)) | (1L << (EVERY - 138)) | (1L << (EXISTS - 138)) | (1L << (EXTERNAL - 138)) | (1L << (EXTRACT - 138)) | (1L << (FAMILY - 138)) | (1L << (FILTER - 138)) | (1L << (FIRST - 138)) | (1L << (FORMAT - 138)) | (1L << (FUSION - 138)) | (1L << (GROUPING - 138)) | (1L << (HASH - 138)) | (1L << (INDEX - 138)) | (1L << (INCREMENT - 138)) | (1L << (INPUT - 138)) | (1L << (INSERT - 138)) | (1L << (INTERSECTION - 138)) | (1L << (ISCACHABLE - 138)) | (1L << (ISODOW - 138)) | (1L << (ISOYEAR - 138)) | (1L << (ISSTRICT - 138)) | (1L << (LANGUAGE - 138)) | (1L << (LARGE - 138)) | (1L << (LAST - 138)) | (1L << (LESS - 138)) | (1L << (LIST - 138)) | (1L << (LOCATION - 138)) | (1L << (MATCH - 138)) | (1L << (MAX - 138)) | (1L << (MAXVALUE - 138)) | (1L << (MICROSECONDS - 138)) | (1L << (MILLENNIUM - 138)) | (1L << (MILLISECONDS - 138)) | (1L << (MIN - 138)) | (1L << (MINVALUE - 138)) | (1L << (MINUTE - 138)) | (1L << (MONTH - 138)) | (1L << (NATIONAL - 138)) | (1L << (NO - 138)) | (1L << (NONE - 138)) | (1L << (NULLIF - 138)))) != 0) || ((((_la - 202)) & ~0x3f) == 0 && ((1L << (_la - 202)) & ((1L << (OBJECT - 202)) | (1L << (OPTION - 202)) | (1L << (OPTIONS - 202)) | (1L << (OVERWRITE - 202)) | (1L << (PARSER - 202)) | (1L << (PARTIAL - 202)) | (1L << (PARTITION - 202)) | (1L << (PARTITIONS - 202)) | (1L << (PRECISION - 202)) | (1L << (PUBLIC - 202)) | (1L << (PURGE - 202)) | (1L << (QUARTER - 202)) | (1L << (RANGE - 202)) | (1L << (REGEXP - 202)) | (1L << (RLIKE - 202)) | (1L << (ROLLUP - 202)) | (1L << (SEARCH - 202)) | (1L << (SECOND - 202)) | (1L << (SECURITY - 202)) | (1L << (SERVER - 202)) | (1L << (SET - 202)) | (1L << (SIMILAR - 202)) | (1L << (SIMPLE - 202)) | (1L << (STABLE - 202)) | (1L << (START - 202)) | (1L << (STORAGE - 202)) | (1L << (STDDEV_POP - 202)) | (1L << (STDDEV_SAMP - 202)) | (1L << (SUBPARTITION - 202)) | (1L << (SUM - 202)) | (1L << (TABLESPACE - 202)) | (1L << (TEMPLATE - 202)) | (1L << (THAN - 202)) | (1L << (TIMEZONE - 202)) | (1L << (TIMEZONE_HOUR - 202)) | (1L << (TIMEZONE_MINUTE - 202)) | (1L << (TRIM - 202)) | (1L << (TO - 202)) | (1L << (TYPE - 202)) | (1L << (UNKNOWN - 202)) | (1L << (UNLOGGED - 202)) | (1L << (VALUES - 202)) | (1L << (VAR_SAMP - 202)) | (1L << (VAR_POP - 202)) | (1L << (VARYING - 202)) | (1L << (VOLATILE - 202)) | (1L << (WEEK - 202)) | (1L << (WINDOW - 202)) | (1L << (WRAPPER - 202)) | (1L << (YEAR - 202)) | (1L << (ZONE - 202)) | (1L << (BOOLEAN - 202)) | (1L << (BOOL - 202)) | (1L << (BIT - 202)) | (1L << (VARBIT - 202)) | (1L << (INT1 - 202)) | (1L << (INT2 - 202)) | (1L << (INT4 - 202)) | (1L << (INT8 - 202)) | (1L << (TINYINT - 202)) | (1L << (SMALLINT - 202)) | (1L << (INT - 202)))) != 0) || ((((_la - 266)) & ~0x3f) == 0 && ((1L << (_la - 266)) & ((1L << (INTEGER - 266)) | (1L << (BIGINT - 266)) | (1L << (FLOAT4 - 266)) | (1L << (FLOAT8 - 266)) | (1L << (REAL - 266)) | (1L << (FLOAT - 266)) | (1L << (DOUBLE - 266)) | (1L << (NUMERIC - 266)) | (1L << (DECIMAL - 266)) | (1L << (CHAR - 266)) | (1L << (VARCHAR - 266)) | (1L << (NCHAR - 266)) | (1L << (NVARCHAR - 266)) | (1L << (DATE - 266)) | (1L << (TIME - 266)) | (1L << (TIMETZ - 266)) | (1L << (TIMESTAMP - 266)) | (1L << (TIMESTAMPTZ - 266)) | (1L << (TEXT - 266)) | (1L << (UUID - 266)) | (1L << (VARBINARY - 266)) | (1L << (BLOB - 266)) | (1L << (BYTEA - 266)) | (1L << (INET4 - 266)) | (1L << (LEFT_PAREN - 266)) | (1L << (PLUS - 266)) | (1L << (MINUS - 266)) | (1L << (DOUBLE_QUOTE - 266)) | (1L << (NUMBER - 266)) | (1L << (REAL_NUMBER - 266)) | (1L << (Identifier - 266)) | (1L << (Character_String_Literal - 266)))) != 0)) {
				{
				setState(3347); sql_argument_list();
				}
			}

			setState(3350); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 440, RULE_function_names_for_reserved_words);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3352);
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
		enterRule(_localctx, 442, RULE_function_name);
		try {
			setState(3356);
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
			case DOUBLE_QUOTE:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(3354); identifier();
				}
				break;
			case LEFT:
			case RIGHT:
				enterOuterAlt(_localctx, 2);
				{
				setState(3355); function_names_for_reserved_words();
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
		enterRule(_localctx, 444, RULE_sql_argument_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3358); value_expression();
			setState(3363);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3359); match(COMMA);
				setState(3360); value_expression();
				}
				}
				setState(3365);
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
		enterRule(_localctx, 446, RULE_orderby_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3366); match(ORDER);
			setState(3367); match(BY);
			setState(3368); sort_specifier_list();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 448, RULE_sort_specifier_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3370); sort_specifier();
			setState(3375);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3371); match(COMMA);
				setState(3372); sort_specifier();
				}
				}
				setState(3377);
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
		enterRule(_localctx, 450, RULE_sort_specifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3378); ((Sort_specifierContext)_localctx).key = row_value_predicand();
			setState(3380);
			_la = _input.LA(1);
			if (_la==ASC || _la==DESC) {
				{
				setState(3379); ((Sort_specifierContext)_localctx).order = order_specification();
				}
			}

			setState(3383);
			_la = _input.LA(1);
			if (_la==NULL) {
				{
				setState(3382); ((Sort_specifierContext)_localctx).null_order = null_ordering();
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
		enterRule(_localctx, 452, RULE_order_specification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3385);
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
		enterRule(_localctx, 454, RULE_limit_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3387); match(LIMIT);
			setState(3388); ((Limit_clauseContext)_localctx).e = numeric_value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 456, RULE_null_ordering);
		try {
			setState(3394);
			switch ( getInterpreter().adaptivePredict(_input,481,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3390); match(NULL);
				setState(3391); match(FIRST);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3392); match(NULL);
				setState(3393); match(LAST);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 458, RULE_insert_statement);
		int _la;
		try {
			setState(3425);
			switch ( getInterpreter().adaptivePredict(_input,487,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3396); match(INSERT);
				setState(3398);
				_la = _input.LA(1);
				if (_la==OVERWRITE) {
					{
					setState(3397); match(OVERWRITE);
					}
				}

				setState(3400); match(INTO);
				setState(3401); schema_qualified_name();
				setState(3406);
				switch ( getInterpreter().adaptivePredict(_input,483,_ctx) ) {
				case 1:
					{
					setState(3402); match(LEFT_PAREN);
					setState(3403); column_name_list();
					setState(3404); match(RIGHT_PAREN);
					}
					break;
				}
				setState(3408); query_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3410); match(INSERT);
				setState(3412);
				_la = _input.LA(1);
				if (_la==OVERWRITE) {
					{
					setState(3411); match(OVERWRITE);
					}
				}

				setState(3414); match(INTO);
				setState(3415); match(LOCATION);
				setState(3416); ((Insert_statementContext)_localctx).path = match(Character_String_Literal);
				setState(3422);
				_la = _input.LA(1);
				if (_la==USING) {
					{
					setState(3417); match(USING);
					setState(3418); ((Insert_statementContext)_localctx).file_type = identifier();
					setState(3420);
					_la = _input.LA(1);
					if (_la==WITH) {
						{
						setState(3419); param_clause();
						}
					}

					}
				}

				setState(3424); query_expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\u014d\u0d66\4\2\t"+
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
		"\4\u00e4\t\u00e4\4\u00e5\t\u00e5\4\u00e6\t\u00e6\4\u00e7\t\u00e7\3\2\3"+
		"\2\5\2\u01d1\n\2\7\2\u01d3\n\2\f\2\16\2\u01d6\13\2\3\2\3\2\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\u01e7\n\3\3\4\3\4\3\5\3\5"+
		"\3\6\3\6\5\6\u01ef\n\6\3\7\3\7\5\7\u01f3\n\7\3\7\3\7\3\7\3\7\3\7\5\7\u01fa"+
		"\n\7\3\7\3\7\3\7\3\7\5\7\u0200\n\7\3\b\3\b\3\b\3\b\3\b\5\b\u0207\n\b\3"+
		"\b\3\b\5\b\u020b\n\b\3\b\3\b\5\b\u020f\n\b\3\b\3\b\5\b\u0213\n\b\3\b\3"+
		"\b\5\b\u0217\n\b\3\t\3\t\5\t\u021b\n\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\5\t\u0225\n\t\3\t\5\t\u0228\n\t\6\t\u022a\n\t\r\t\16\t\u022b\3\t\3\t"+
		"\5\t\u0230\n\t\3\t\3\t\3\t\3\t\3\t\5\t\u0237\n\t\3\t\5\t\u023a\n\t\6\t"+
		"\u023c\n\t\r\t\16\t\u023d\5\t\u0240\n\t\3\n\3\n\5\n\u0244\n\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\5\n\u024c\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u0255\n"+
		"\n\6\n\u0257\n\n\r\n\16\n\u0258\5\n\u025b\n\n\5\n\u025d\n\n\3\n\3\n\3"+
		"\n\3\n\5\n\u0263\n\n\3\n\3\n\3\n\5\n\u0268\n\n\3\n\3\n\3\n\3\n\5\n\u026e"+
		"\n\n\3\n\3\n\5\n\u0272\n\n\3\n\3\n\5\n\u0276\n\n\3\n\3\n\5\n\u027a\n\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u0282\n\n\5\n\u0284\n\n\3\n\3\n\3\13\3\13"+
		"\3\13\3\13\5\13\u028c\n\13\3\13\6\13\u028f\n\13\r\13\16\13\u0290\3\13"+
		"\3\13\5\13\u0295\n\13\5\13\u0297\n\13\3\13\3\13\5\13\u029b\n\13\3\13\6"+
		"\13\u029e\n\13\r\13\16\13\u029f\3\13\3\13\3\13\3\13\3\13\6\13\u02a7\n"+
		"\13\r\13\16\13\u02a8\5\13\u02ab\n\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13"+
		"\u02b3\n\13\3\13\3\13\3\13\3\13\5\13\u02b9\n\13\6\13\u02bb\n\13\r\13\16"+
		"\13\u02bc\3\13\3\13\6\13\u02c1\n\13\r\13\16\13\u02c2\3\13\3\13\5\13\u02c7"+
		"\n\13\3\13\3\13\3\13\5\13\u02cc\n\13\6\13\u02ce\n\13\r\13\16\13\u02cf"+
		"\3\13\3\13\5\13\u02d4\n\13\3\13\3\13\5\13\u02d8\n\13\3\13\3\13\5\13\u02dc"+
		"\n\13\6\13\u02de\n\13\r\13\16\13\u02df\3\13\3\13\3\13\3\13\3\13\3\13\5"+
		"\13\u02e8\n\13\3\13\6\13\u02eb\n\13\r\13\16\13\u02ec\3\13\3\13\5\13\u02f1"+
		"\n\13\5\13\u02f3\n\13\3\13\3\13\3\13\3\13\5\13\u02f9\n\13\6\13\u02fb\n"+
		"\13\r\13\16\13\u02fc\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u0305\n\13\6\13"+
		"\u0307\n\13\r\13\16\13\u0308\5\13\u030b\n\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\5\13\u0313\n\13\3\13\6\13\u0316\n\13\r\13\16\13\u0317\3\13\3\13"+
		"\5\13\u031c\n\13\5\13\u031e\n\13\3\13\3\13\3\13\3\13\5\13\u0324\n\13\6"+
		"\13\u0326\n\13\r\13\16\13\u0327\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u0330"+
		"\n\13\3\13\3\13\3\13\5\13\u0335\n\13\5\13\u0337\n\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\5\13\u033f\n\13\6\13\u0341\n\13\r\13\16\13\u0342\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\5\13\u034b\n\13\3\13\3\13\3\13\5\13\u0350\n\13"+
		"\5\13\u0352\n\13\3\13\3\13\3\13\3\13\3\13\5\13\u0359\n\13\6\13\u035b\n"+
		"\13\r\13\16\13\u035c\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u0365\n\13\3\13"+
		"\3\13\3\13\5\13\u036a\n\13\5\13\u036c\n\13\3\13\3\13\3\13\5\13\u0371\n"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u0379\n\13\3\13\3\13\3\13\5\13"+
		"\u037e\n\13\5\13\u0380\n\13\3\13\3\13\3\13\3\13\5\13\u0386\n\13\6\13\u0388"+
		"\n\13\r\13\16\13\u0389\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u0392\n\13\3"+
		"\13\3\13\3\13\5\13\u0397\n\13\6\13\u0399\n\13\r\13\16\13\u039a\3\13\3"+
		"\13\5\13\u039f\n\13\5\13\u03a1\n\13\3\13\3\13\3\13\3\13\3\13\5\13\u03a8"+
		"\n\13\6\13\u03aa\n\13\r\13\16\13\u03ab\3\13\3\13\3\13\3\13\3\13\3\13\5"+
		"\13\u03b4\n\13\3\13\3\13\5\13\u03b8\n\13\6\13\u03ba\n\13\r\13\16\13\u03bb"+
		"\3\13\3\13\5\13\u03c0\n\13\5\13\u03c2\n\13\3\13\3\13\3\13\3\13\5\13\u03c8"+
		"\n\13\6\13\u03ca\n\13\r\13\16\13\u03cb\3\13\3\13\3\13\3\13\3\13\3\13\5"+
		"\13\u03d4\n\13\3\13\3\13\3\13\5\13\u03d9\n\13\5\13\u03db\n\13\3\13\3\13"+
		"\3\13\3\13\5\13\u03e1\n\13\6\13\u03e3\n\13\r\13\16\13\u03e4\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\5\13\u03ed\n\13\3\13\3\13\5\13\u03f1\n\13\6\13\u03f3"+
		"\n\13\r\13\16\13\u03f4\3\13\3\13\3\13\5\13\u03fa\n\13\6\13\u03fc\n\13"+
		"\r\13\16\13\u03fd\3\13\5\13\u0401\n\13\5\13\u0403\n\13\3\f\3\f\5\f\u0407"+
		"\n\f\3\f\3\f\3\f\5\f\u040c\n\f\6\f\u040e\n\f\r\f\16\f\u040f\3\f\5\f\u0413"+
		"\n\f\3\r\3\r\6\r\u0417\n\r\r\r\16\r\u0418\3\r\3\r\5\r\u041d\n\r\5\r\u041f"+
		"\n\r\3\r\3\r\5\r\u0423\n\r\3\r\3\r\5\r\u0427\n\r\6\r\u0429\n\r\r\r\16"+
		"\r\u042a\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u0433\n\r\6\r\u0435\n\r\r\r\16\r"+
		"\u0436\5\r\u0439\n\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u0441\n\r\6\r\u0443\n"+
		"\r\r\r\16\r\u0444\6\r\u0447\n\r\r\r\16\r\u0448\3\r\3\r\5\r\u044d\n\r\3"+
		"\r\3\r\5\r\u0451\n\r\6\r\u0453\n\r\r\r\16\r\u0454\5\r\u0457\n\r\3\r\3"+
		"\r\5\r\u045b\n\r\3\r\3\r\5\r\u045f\n\r\6\r\u0461\n\r\r\r\16\r\u0462\3"+
		"\r\3\r\3\r\3\r\3\r\5\r\u046a\n\r\6\r\u046c\n\r\r\r\16\r\u046d\3\r\3\r"+
		"\5\r\u0472\n\r\5\r\u0474\n\r\3\r\3\r\3\r\3\r\5\r\u047a\n\r\6\r\u047c\n"+
		"\r\r\r\16\r\u047d\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u0486\n\r\6\r\u0488\n\r"+
		"\r\r\16\r\u0489\5\r\u048c\n\r\3\r\3\r\3\r\3\r\3\r\5\r\u0493\n\r\6\r\u0495"+
		"\n\r\r\r\16\r\u0496\3\r\3\r\5\r\u049b\n\r\5\r\u049d\n\r\3\r\3\r\3\r\3"+
		"\r\5\r\u04a3\n\r\6\r\u04a5\n\r\r\r\16\r\u04a6\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\5\r\u04af\n\r\5\r\u04b1\n\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u04b9\n\r\6\r"+
		"\u04bb\n\r\r\r\16\r\u04bc\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u04c5\n\r\5\r\u04c7"+
		"\n\r\3\r\3\r\3\r\3\r\3\r\5\r\u04ce\n\r\6\r\u04d0\n\r\r\r\16\r\u04d1\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\5\r\u04da\n\r\5\r\u04dc\n\r\3\r\3\r\3\r\5\r\u04e1"+
		"\n\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u04e9\n\r\5\r\u04eb\n\r\3\r\3\r\3\r\3"+
		"\r\5\r\u04f1\n\r\6\r\u04f3\n\r\r\r\16\r\u04f4\3\r\3\r\3\r\3\r\3\r\5\r"+
		"\u04fc\n\r\6\r\u04fe\n\r\r\r\16\r\u04ff\3\r\3\r\5\r\u0504\n\r\5\r\u0506"+
		"\n\r\3\r\3\r\3\r\3\r\3\r\5\r\u050d\n\r\6\r\u050f\n\r\r\r\16\r\u0510\3"+
		"\r\3\r\3\r\3\r\3\r\5\r\u0518\n\r\6\r\u051a\n\r\r\r\16\r\u051b\3\r\3\r"+
		"\5\r\u0520\n\r\5\r\u0522\n\r\3\r\3\r\3\r\3\r\5\r\u0528\n\r\6\r\u052a\n"+
		"\r\r\r\16\r\u052b\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u0534\n\r\5\r\u0536\n\r"+
		"\3\r\3\r\3\r\3\r\5\r\u053c\n\r\6\r\u053e\n\r\r\r\16\r\u053f\3\r\3\r\3"+
		"\r\3\r\5\r\u0546\n\r\6\r\u0548\n\r\r\r\16\r\u0549\3\r\3\r\3\r\5\r\u054f"+
		"\n\r\6\r\u0551\n\r\r\r\16\r\u0552\3\r\3\r\3\r\5\r\u0558\n\r\5\r\u055a"+
		"\n\r\3\16\3\16\5\16\u055e\n\16\3\16\3\16\5\16\u0562\n\16\3\16\5\16\u0565"+
		"\n\16\6\16\u0567\n\16\r\16\16\16\u0568\3\16\3\16\3\16\5\16\u056e\n\16"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u0577\n\17\7\17\u0579\n\17\f"+
		"\17\16\17\u057c\13\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u05ba\n\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17"+
		"\u05e8\n\17\3\17\3\17\3\17\3\20\3\20\3\20\5\20\u05f0\n\20\3\20\3\20\3"+
		"\20\3\20\5\20\u05f6\n\20\3\20\5\20\u05f9\n\20\3\20\3\20\3\20\3\20\5\20"+
		"\u05ff\n\20\3\20\5\20\u0602\n\20\7\20\u0604\n\20\f\20\16\20\u0607\13\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u0612\n\20\6\20\u0614"+
		"\n\20\r\20\16\20\u0615\3\20\3\20\5\20\u061a\n\20\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u062d"+
		"\n\20\3\20\3\20\3\20\5\20\u0632\n\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u0642\n\20\3\20\3\20\7\20\u0646"+
		"\n\20\f\20\16\20\u0649\13\20\3\20\3\20\3\20\3\20\3\20\3\20\6\20\u0651"+
		"\n\20\r\20\16\20\u0652\3\20\3\20\3\20\3\20\5\20\u0659\n\20\6\20\u065b"+
		"\n\20\r\20\16\20\u065c\3\20\3\20\5\20\u0661\n\20\3\21\3\21\7\21\u0665"+
		"\n\21\f\21\16\21\u0668\13\21\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3"+
		"\24\3\24\5\24\u0674\n\24\3\24\5\24\u0677\n\24\3\24\3\24\5\24\u067b\n\24"+
		"\7\24\u067d\n\24\f\24\16\24\u0680\13\24\3\24\3\24\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\5\25\u068a\n\25\6\25\u068c\n\25\r\25\16\25\u068d\3\26\3\26"+
		"\5\26\u0692\n\26\3\26\3\26\3\26\3\26\5\26\u0698\n\26\3\26\3\26\3\26\3"+
		"\26\3\26\5\26\u069f\n\26\3\26\3\26\3\26\3\26\5\26\u06a5\n\26\3\26\3\26"+
		"\5\26\u06a9\n\26\3\26\3\26\3\26\3\26\5\26\u06af\n\26\3\26\3\26\3\26\3"+
		"\26\3\26\5\26\u06b6\n\26\7\26\u06b8\n\26\f\26\16\26\u06bb\13\26\3\27\3"+
		"\27\3\27\3\27\3\27\5\27\u06c2\n\27\3\27\7\27\u06c5\n\27\f\27\16\27\u06c8"+
		"\13\27\3\27\3\27\3\27\3\27\3\27\7\27\u06cf\n\27\f\27\16\27\u06d2\13\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u06dc\n\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\5\27\u06e5\n\27\3\30\3\30\3\30\5\30\u06ea\n\30\3"+
		"\30\5\30\u06ed\n\30\3\30\3\30\3\30\3\30\5\30\u06f3\n\30\7\30\u06f5\n\30"+
		"\f\30\16\30\u06f8\13\30\3\30\3\30\3\30\3\30\3\30\5\30\u06ff\n\30\6\30"+
		"\u0701\n\30\r\30\16\30\u0702\3\30\3\30\5\30\u0707\n\30\3\30\3\30\3\30"+
		"\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u0716\n\32\3\32"+
		"\5\32\u0719\n\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u0724"+
		"\n\32\3\32\5\32\u0727\n\32\3\32\5\32\u072a\n\32\3\32\3\32\5\32\u072e\n"+
		"\32\3\32\3\32\3\32\3\32\3\32\5\32\u0735\n\32\3\32\5\32\u0738\n\32\3\32"+
		"\5\32\u073b\n\32\3\32\3\32\3\32\3\32\3\32\5\32\u0742\n\32\3\32\3\32\5"+
		"\32\u0746\n\32\3\32\3\32\3\32\3\32\5\32\u074c\n\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\5\32\u0754\n\32\3\32\7\32\u0757\n\32\f\32\16\32\u075a\13\32"+
		"\3\32\3\32\3\32\3\32\7\32\u0760\n\32\f\32\16\32\u0763\13\32\5\32\u0765"+
		"\n\32\3\32\5\32\u0768\n\32\6\32\u076a\n\32\r\32\16\32\u076b\5\32\u076e"+
		"\n\32\3\32\3\32\3\32\3\32\3\32\5\32\u0775\n\32\6\32\u0777\n\32\r\32\16"+
		"\32\u0778\3\32\3\32\5\32\u077d\n\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32"+
		"\u0785\n\32\3\32\3\32\5\32\u0789\n\32\3\32\3\32\3\32\3\32\5\32\u078f\n"+
		"\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\7\32\u0799\n\32\f\32\16\32"+
		"\u079c\13\32\3\32\5\32\u079f\n\32\3\32\5\32\u07a2\n\32\6\32\u07a4\n\32"+
		"\r\32\16\32\u07a5\3\32\3\32\5\32\u07aa\n\32\3\32\3\32\3\32\3\32\5\32\u07b0"+
		"\n\32\3\33\3\33\3\33\3\34\3\34\5\34\u07b7\n\34\3\34\3\34\3\34\3\34\3\34"+
		"\5\34\u07be\n\34\6\34\u07c0\n\34\r\34\16\34\u07c1\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\5\34\u07cc\n\34\6\34\u07ce\n\34\r\34\16\34\u07cf"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u07d8\n\34\3\34\3\34\3\34\3\34\3\34"+
		"\5\34\u07df\n\34\6\34\u07e1\n\34\r\34\16\34\u07e2\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\5\34\u07ec\n\34\3\34\3\34\3\34\3\34\3\34\5\34\u07f3\n"+
		"\34\6\34\u07f5\n\34\r\34\16\34\u07f6\3\34\3\34\3\34\3\34\3\34\3\34\5\34"+
		"\u07ff\n\34\6\34\u0801\n\34\r\34\16\34\u0802\3\34\3\34\5\34\u0807\n\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u080f\n\34\3\34\3\34\3\34\5\34\u0814"+
		"\n\34\3\34\3\34\3\34\5\34\u0819\n\34\5\34\u081b\n\34\3\34\3\34\3\34\5"+
		"\34\u0820\n\34\3\34\3\34\3\34\3\34\5\34\u0826\n\34\3\35\3\35\5\35\u082a"+
		"\n\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\3\35\5\35\u0840\n\35\3\35\3\35\3\35\5\35"+
		"\u0845\n\35\3\35\3\35\3\35\5\35\u084a\n\35\5\35\u084c\n\35\3\35\3\35\3"+
		"\35\5\35\u0851\n\35\3\35\3\35\3\35\3\35\5\35\u0857\n\35\3\36\3\36\3\36"+
		"\3\36\3\36\3\37\3\37\3\37\3\37\3\37\5\37\u0863\n\37\3\37\5\37\u0866\n"+
		"\37\6\37\u0868\n\37\r\37\16\37\u0869\3\37\3\37\3 \3 \3 \3 \3 \5 \u0873"+
		"\n \3!\3!\3!\3!\3!\3!\3!\5!\u087c\n!\5!\u087e\n!\3\"\3\"\5\"\u0882\n\""+
		"\3#\3#\3#\3#\3#\3#\5#\u088a\n#\3$\5$\u088d\n$\3$\3$\3$\3$\5$\u0893\n$"+
		"\3%\3%\3%\3%\7%\u0899\n%\f%\16%\u089c\13%\3%\3%\3&\3&\3&\3\'\3\'\3(\3"+
		"(\3(\3(\3(\7(\u08aa\n(\f(\16(\u08ad\13(\3(\3(\3)\3)\3)\3)\3*\3*\3*\3+"+
		"\3+\3+\3,\3,\3-\3-\3-\3-\5-\u08c1\n-\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3/"+
		"\3/\3/\7/\u08d0\n/\f/\16/\u08d3\13/\3\60\3\60\3\60\3\60\3\60\3\60\3\60"+
		"\3\60\3\60\3\60\5\60\u08df\n\60\3\60\3\60\5\60\u08e3\n\60\5\60\u08e5\n"+
		"\60\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\5\61\u08f2"+
		"\n\61\3\62\3\62\3\62\7\62\u08f7\n\62\f\62\16\62\u08fa\13\62\3\63\3\63"+
		"\3\63\3\64\3\64\3\64\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65"+
		"\3\66\3\66\3\66\7\66\u090f\n\66\f\66\16\66\u0912\13\66\3\67\3\67\3\67"+
		"\3\67\5\67\u0918\n\67\3\67\3\67\3\67\3\67\38\38\38\38\38\39\39\3:\3:\3"+
		":\3:\5:\u0929\n:\3;\5;\u092c\n;\3;\3;\5;\u0930\n;\3;\5;\u0933\n;\3;\3"+
		";\5;\u0937\n;\5;\u0939\n;\3<\3<\3=\3=\5=\u093f\n=\3>\3>\3>\5>\u0944\n"+
		">\3?\3?\3?\5?\u0949\n?\3@\3@\3@\3A\3A\3A\3B\3B\3B\3C\3C\3D\3D\3E\3E\3"+
		"E\3E\3E\3E\3E\3E\3E\3E\3E\3E\5E\u0964\nE\3F\3F\3G\3G\3H\3H\5H\u096c\n"+
		"H\3H\3H\5H\u0970\nH\3H\3H\3H\5H\u0975\nH\3H\3H\3H\5H\u097a\nH\3H\3H\5"+
		"H\u097e\nH\3H\5H\u0981\nH\3I\3I\3I\3I\3J\3J\3J\5J\u098a\nJ\3J\3J\3J\5"+
		"J\u098f\nJ\3J\3J\5J\u0993\nJ\3J\3J\3J\3J\5J\u0999\nJ\3J\3J\3J\3J\5J\u099f"+
		"\nJ\3J\3J\3J\5J\u09a4\nJ\3J\3J\5J\u09a8\nJ\5J\u09aa\nJ\3K\3K\5K\u09ae"+
		"\nK\3K\3K\5K\u09b2\nK\5K\u09b4\nK\3L\3L\5L\u09b8\nL\3M\3M\5M\u09bc\nM"+
		"\3M\3M\5M\u09c0\nM\3M\3M\5M\u09c4\nM\3M\3M\3M\3M\3M\3M\3M\3M\3M\5M\u09cf"+
		"\nM\3N\3N\5N\u09d3\nN\3N\3N\3N\3N\3N\3N\5N\u09db\nN\3O\3O\3O\3O\3O\3O"+
		"\3O\3O\5O\u09e5\nO\3P\3P\3Q\3Q\3Q\3Q\3Q\3Q\3Q\3Q\3Q\3Q\3Q\3Q\3Q\5Q\u09f6"+
		"\nQ\3R\3R\5R\u09fa\nR\3R\3R\5R\u09fe\nR\3R\3R\3R\5R\u0a03\nR\5R\u0a05"+
		"\nR\3S\3S\5S\u0a09\nS\3S\3S\3S\5S\u0a0e\nS\3S\3S\5S\u0a12\nS\5S\u0a14"+
		"\nS\3T\3T\5T\u0a18\nT\3U\3U\3U\3U\3V\3V\3V\3V\3V\3V\3V\5V\u0a25\nV\3W"+
		"\3W\3X\3X\3Y\5Y\u0a2c\nY\3Y\3Y\3Z\3Z\3[\3[\3[\3[\3[\3[\5[\u0a38\n[\5["+
		"\u0a3a\n[\3\\\3\\\3\\\5\\\u0a3f\n\\\3\\\3\\\3\\\3]\3]\3^\3^\3^\3^\3^\3"+
		"^\3_\3_\3_\3_\3_\3`\3`\3a\3a\3a\3a\3a\3a\3a\3a\3a\3a\3a\3a\6a\u0a5f\n"+
		"a\ra\16a\u0a60\3a\3a\5a\u0a65\na\3b\3b\5b\u0a69\nb\3c\3c\3c\6c\u0a6e\n"+
		"c\rc\16c\u0a6f\3c\5c\u0a73\nc\3c\3c\3d\3d\6d\u0a79\nd\rd\16d\u0a7a\3d"+
		"\5d\u0a7e\nd\3d\3d\3e\3e\3e\3e\3e\3f\3f\3f\3f\3f\3g\3g\3g\3h\3h\5h\u0a91"+
		"\nh\3i\3i\3i\3i\3i\3i\3i\3j\3j\3k\3k\3l\3l\3l\5l\u0aa1\nl\3m\3m\3m\5m"+
		"\u0aa6\nm\3n\3n\3n\7n\u0aab\nn\fn\16n\u0aae\13n\3o\3o\3o\7o\u0ab3\no\f"+
		"o\16o\u0ab6\13o\3p\5p\u0ab9\np\3p\3p\3q\3q\3q\3q\7q\u0ac1\nq\fq\16q\u0ac4"+
		"\13q\3q\3q\3r\3r\3r\7r\u0acb\nr\fr\16r\u0ace\13r\3r\5r\u0ad1\nr\3s\3s"+
		"\3t\3t\3u\3u\3u\3u\3u\3u\3u\3v\3v\3v\5v\u0ae1\nv\3w\3w\3x\3x\5x\u0ae7"+
		"\nx\3y\3y\3z\3z\3z\7z\u0aee\nz\fz\16z\u0af1\13z\3{\3{\3|\3|\5|\u0af7\n"+
		"|\3}\3}\3~\3~\3~\3~\3~\3\177\5\177\u0b01\n\177\3\177\5\177\u0b04\n\177"+
		"\3\177\5\177\u0b07\n\177\3\177\3\177\3\177\3\177\3\177\5\177\u0b0e\n\177"+
		"\3\u0080\3\u0080\3\u0081\3\u0081\3\u0082\3\u0082\3\u0082\7\u0082\u0b17"+
		"\n\u0082\f\u0082\16\u0082\u0b1a\13\u0082\3\u0083\3\u0083\3\u0083\7\u0083"+
		"\u0b1f\n\u0083\f\u0083\16\u0083\u0b22\13\u0083\3\u0084\3\u0084\3\u0084"+
		"\5\u0084\u0b27\n\u0084\3\u0085\3\u0085\5\u0085\u0b2b\n\u0085\3\u0086\3"+
		"\u0086\5\u0086\u0b2f\n\u0086\3\u0086\3\u0086\3\u0087\3\u0087\3\u0088\3"+
		"\u0088\5\u0088\u0b37\n\u0088\3\u0089\3\u0089\5\u0089\u0b3b\n\u0089\3\u008a"+
		"\3\u008a\3\u008a\3\u008a\3\u008b\3\u008b\5\u008b\u0b43\n\u008b\3\u008c"+
		"\3\u008c\3\u008d\3\u008d\3\u008e\3\u008e\5\u008e\u0b4b\n\u008e\3\u008f"+
		"\3\u008f\5\u008f\u0b4f\n\u008f\3\u0090\3\u0090\5\u0090\u0b53\n\u0090\3"+
		"\u0090\5\u0090\u0b56\n\u0090\3\u0090\5\u0090\u0b59\n\u0090\3\u0090\5\u0090"+
		"\u0b5c\n\u0090\3\u0090\5\u0090\u0b5f\n\u0090\3\u0091\3\u0091\3\u0091\3"+
		"\u0092\3\u0092\3\u0092\7\u0092\u0b67\n\u0092\f\u0092\16\u0092\u0b6a\13"+
		"\u0092\3\u0093\3\u0093\5\u0093\u0b6e\n\u0093\3\u0094\3\u0094\6\u0094\u0b72"+
		"\n\u0094\r\u0094\16\u0094\u0b73\3\u0095\3\u0095\3\u0095\3\u0095\5\u0095"+
		"\u0b7a\n\u0095\3\u0095\3\u0095\3\u0095\3\u0095\3\u0095\3\u0095\5\u0095"+
		"\u0b82\n\u0095\3\u0095\3\u0095\3\u0095\3\u0095\3\u0095\5\u0095\u0b89\n"+
		"\u0095\3\u0096\3\u0096\3\u0096\3\u0096\3\u0097\5\u0097\u0b90\n\u0097\3"+
		"\u0097\3\u0097\3\u0097\3\u0097\3\u0098\3\u0098\5\u0098\u0b98\n\u0098\3"+
		"\u0098\3\u0098\3\u0098\3\u0099\3\u0099\3\u0099\3\u0099\3\u009a\3\u009a"+
		"\5\u009a\u0ba3\n\u009a\3\u009b\3\u009b\5\u009b\u0ba7\n\u009b\3\u009c\3"+
		"\u009c\3\u009d\3\u009d\5\u009d\u0bad\n\u009d\3\u009e\3\u009e\3\u009e\3"+
		"\u009f\3\u009f\3\u009f\3\u009f\3\u009f\3\u00a0\3\u00a0\5\u00a0\u0bb9\n"+
		"\u00a0\3\u00a0\5\u00a0\u0bbc\n\u00a0\3\u00a0\3\u00a0\3\u00a0\3\u00a0\5"+
		"\u00a0\u0bc2\n\u00a0\3\u00a0\3\u00a0\5\u00a0\u0bc6\n\u00a0\3\u00a0\3\u00a0"+
		"\3\u00a0\3\u00a0\3\u00a0\5\u00a0\u0bcd\n\u00a0\5\u00a0\u0bcf\n\u00a0\3"+
		"\u00a1\3\u00a1\3\u00a1\7\u00a1\u0bd4\n\u00a1\f\u00a1\16\u00a1\u0bd7\13"+
		"\u00a1\3\u00a2\3\u00a2\3\u00a3\3\u00a3\3\u00a3\3\u00a4\3\u00a4\3\u00a5"+
		"\3\u00a5\3\u00a5\3\u00a5\3\u00a6\3\u00a6\3\u00a6\7\u00a6\u0be7\n\u00a6"+
		"\f\u00a6\16\u00a6\u0bea\13\u00a6\3\u00a7\3\u00a7\3\u00a7\3\u00a7\5\u00a7"+
		"\u0bf0\n\u00a7\3\u00a8\3\u00a8\3\u00a8\3\u00a8\3\u00a8\5\u00a8\u0bf7\n"+
		"\u00a8\3\u00a9\3\u00a9\3\u00a9\7\u00a9\u0bfc\n\u00a9\f\u00a9\16\u00a9"+
		"\u0bff\13\u00a9\3\u00aa\3\u00aa\3\u00aa\3\u00aa\3\u00aa\3\u00ab\3\u00ab"+
		"\3\u00ab\3\u00ab\3\u00ab\3\u00ac\3\u00ac\3\u00ac\3\u00ad\3\u00ad\3\u00ad"+
		"\3\u00ae\3\u00ae\3\u00ae\7\u00ae\u0c14\n\u00ae\f\u00ae\16\u00ae\u0c17"+
		"\13\u00ae\3\u00af\3\u00af\3\u00b0\3\u00b0\5\u00b0\u0c1d\n\u00b0\3\u00b1"+
		"\3\u00b1\3\u00b1\3\u00b1\5\u00b1\u0c23\n\u00b1\3\u00b1\3\u00b1\5\u00b1"+
		"\u0c27\n\u00b1\3\u00b1\3\u00b1\5\u00b1\u0c2b\n\u00b1\3\u00b1\7\u00b1\u0c2e"+
		"\n\u00b1\f\u00b1\16\u00b1\u0c31\13\u00b1\3\u00b2\3\u00b2\5\u00b2\u0c35"+
		"\n\u00b2\3\u00b3\3\u00b3\3\u00b3\3\u00b3\5\u00b3\u0c3b\n\u00b3\3\u00b3"+
		"\3\u00b3\5\u00b3\u0c3f\n\u00b3\3\u00b3\3\u00b3\5\u00b3\u0c43\n\u00b3\3"+
		"\u00b3\7\u00b3\u0c46\n\u00b3\f\u00b3\16\u00b3\u0c49\13\u00b3\3\u00b4\3"+
		"\u00b4\5\u00b4\u0c4d\n\u00b4\3\u00b5\3\u00b5\3\u00b5\3\u00b5\3\u00b5\5"+
		"\u00b5\u0c54\n\u00b5\3\u00b6\3\u00b6\5\u00b6\u0c58\n\u00b6\3\u00b7\3\u00b7"+
		"\3\u00b7\3\u00b8\3\u00b8\5\u00b8\u0c5f\n\u00b8\3\u00b9\3\u00b9\3\u00b9"+
		"\3\u00b9\3\u00b9\5\u00b9\u0c66\n\u00b9\5\u00b9\u0c68\n\u00b9\3\u00ba\3"+
		"\u00ba\5\u00ba\u0c6c\n\u00ba\3\u00ba\3\u00ba\5\u00ba\u0c70\n\u00ba\3\u00bb"+
		"\3\u00bb\3\u00bb\7\u00bb\u0c75\n\u00bb\f\u00bb\16\u00bb\u0c78\13\u00bb"+
		"\3\u00bc\3\u00bc\5\u00bc\u0c7c\n\u00bc\3\u00bd\3\u00bd\5\u00bd\u0c80\n"+
		"\u00bd\3\u00be\3\u00be\5\u00be\u0c84\n\u00be\3\u00be\3\u00be\3\u00bf\3"+
		"\u00bf\3\u00c0\3\u00c0\3\u00c0\5\u00c0\u0c8d\n\u00c0\3\u00c0\3\u00c0\3"+
		"\u00c1\5\u00c1\u0c92\n\u00c1\3\u00c1\3\u00c1\3\u00c2\3\u00c2\3\u00c2\7"+
		"\u00c2\u0c99\n\u00c2\f\u00c2\16\u00c2\u0c9c\13\u00c2\3\u00c3\3\u00c3\3"+
		"\u00c4\3\u00c4\3\u00c5\3\u00c5\3\u00c6\3\u00c6\3\u00c6\3\u00c6\3\u00c7"+
		"\3\u00c7\3\u00c7\3\u00c7\3\u00c7\3\u00c7\5\u00c7\u0cae\n\u00c7\3\u00c8"+
		"\3\u00c8\3\u00c8\3\u00c8\3\u00c9\3\u00c9\3\u00ca\3\u00ca\3\u00ca\3\u00cb"+
		"\5\u00cb\u0cba\n\u00cb\3\u00cb\3\u00cb\5\u00cb\u0cbe\n\u00cb\3\u00cb\3"+
		"\u00cb\3\u00cb\3\u00cb\3\u00cc\3\u00cc\5\u00cc\u0cc6\n\u00cc\3\u00cc\3"+
		"\u00cc\3\u00cc\3\u00cd\3\u00cd\3\u00cd\3\u00cd\3\u00cd\5\u00cd\u0cd0\n"+
		"\u00cd\3\u00ce\3\u00ce\3\u00ce\7\u00ce\u0cd5\n\u00ce\f\u00ce\16\u00ce"+
		"\u0cd8\13\u00ce\3\u00cf\3\u00cf\3\u00cf\3\u00cf\3\u00d0\5\u00d0\u0cdf"+
		"\n\u00d0\3\u00d0\3\u00d0\5\u00d0\u0ce3\n\u00d0\3\u00d1\3\u00d1\3\u00d1"+
		"\3\u00d1\3\u00d1\3\u00d1\5\u00d1\u0ceb\n\u00d1\3\u00d2\3\u00d2\3\u00d3"+
		"\3\u00d3\3\u00d3\5\u00d3\u0cf2\n\u00d3\3\u00d3\3\u00d3\3\u00d4\3\u00d4"+
		"\3\u00d4\3\u00d4\3\u00d4\3\u00d5\3\u00d5\5\u00d5\u0cfd\n\u00d5\3\u00d6"+
		"\3\u00d6\3\u00d7\3\u00d7\3\u00d8\5\u00d8\u0d04\n\u00d8\3\u00d8\3\u00d8"+
		"\3\u00d8\3\u00d9\3\u00d9\3\u00d9\3\u00da\3\u00da\5\u00da\u0d0e\n\u00da"+
		"\3\u00db\3\u00db\3\u00dc\3\u00dc\3\u00dd\3\u00dd\3\u00dd\5\u00dd\u0d17"+
		"\n\u00dd\3\u00dd\3\u00dd\3\u00de\3\u00de\3\u00df\3\u00df\5\u00df\u0d1f"+
		"\n\u00df\3\u00e0\3\u00e0\3\u00e0\7\u00e0\u0d24\n\u00e0\f\u00e0\16\u00e0"+
		"\u0d27\13\u00e0\3\u00e1\3\u00e1\3\u00e1\3\u00e1\3\u00e2\3\u00e2\3\u00e2"+
		"\7\u00e2\u0d30\n\u00e2\f\u00e2\16\u00e2\u0d33\13\u00e2\3\u00e3\3\u00e3"+
		"\5\u00e3\u0d37\n\u00e3\3\u00e3\5\u00e3\u0d3a\n\u00e3\3\u00e4\3\u00e4\3"+
		"\u00e5\3\u00e5\3\u00e5\3\u00e6\3\u00e6\3\u00e6\3\u00e6\5\u00e6\u0d45\n"+
		"\u00e6\3\u00e7\3\u00e7\5\u00e7\u0d49\n\u00e7\3\u00e7\3\u00e7\3\u00e7\3"+
		"\u00e7\3\u00e7\3\u00e7\5\u00e7\u0d51\n\u00e7\3\u00e7\3\u00e7\3\u00e7\3"+
		"\u00e7\5\u00e7\u0d57\n\u00e7\3\u00e7\3\u00e7\3\u00e7\3\u00e7\3\u00e7\3"+
		"\u00e7\5\u00e7\u0d5f\n\u00e7\5\u00e7\u0d61\n\u00e7\3\u00e7\5\u00e7\u0d64"+
		"\n\u00e7\3\u00e7\2\2\u00e8\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$"+
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
		"\u01be\u01c0\u01c2\u01c4\u01c6\u01c8\u01ca\u01cc\2&\4\2JJjj\4\2\u00f2"+
		"\u00f2\u012c\u012c\t\2\36\36__iittvvyy\u00b2\u00b2\6\2__iiyy\u00b2\u00b2"+
		"\4\2iiyz\5\2\23\23\27\27pq\4\2\27\27zz\4\2\17\17aa\4\2iiyy\3\2\u0143\u0143"+
		"\4\2\u00b4\u00b4\u00b7\u00b7\6\299@@RR||\3\2pq\4\2\61\61JJ\4\2\'\'::\b"+
		"\2\6\6\25\25\33\33\u0090\u0090\u00af\u00af\u00e5\u00e5\t\2\u0082\u00ac"+
		"\u00ae\u00ae\u00b0\u00ea\u00ec\u00f9\u00fb\u0110\u0112\u0120\u0122\u0125"+
		"\5\2**uu\u00f4\u00f4\3\2\u0101\u0102\3\2\u0144\u0145\17\2\b\bkk\u0083"+
		"\u0083\u008c\u008c\u0094\u0094\u00a2\u00a2\u00aa\u00aa\u00b3\u00b3\u00bf"+
		"\u00bf\u00c4\u00c4\u00e6\u00e7\u00e9\u00e9\u00f7\u00f8\3\2\u0138\u0139"+
		"\3\2\u013a\u013c\3\2\u00ee\u00f0\5\2\r\rFFss\5\2--GGdd\4\2%%ww\4\2\6\6"+
		"  \4\2\u012c\u012c\u0131\u0135\4\2\t\tnn\3\2\u0126\u0129\4\2\b\bkk\6\2"+
		"\u0099\u0099\u00ad\u00ad\u00c6\u00c7\u00ff\u00ff\n\2\u0089\u0089\u009b"+
		"\u009b\u009e\u009f\u00a1\u00a1\u00b5\u00b6\u00c1\u00c3\u00d7\u00d7\u00fc"+
		"\u00fc\4\2GGdd\4\2\n\n\37\37\u0f1c\2\u01d4\3\2\2\2\4\u01e6\3\2\2\2\6\u01e8"+
		"\3\2\2\2\b\u01ea\3\2\2\2\n\u01ee\3\2\2\2\f\u01f0\3\2\2\2\16\u0201\3\2"+
		"\2\2\20\u023f\3\2\2\2\22\u0241\3\2\2\2\24\u0402\3\2\2\2\26\u0404\3\2\2"+
		"\2\30\u0559\3\2\2\2\32\u055b\3\2\2\2\34\u056f\3\2\2\2\36\u05ec\3\2\2\2"+
		" \u0662\3\2\2\2\"\u066b\3\2\2\2$\u066d\3\2\2\2&\u066f\3\2\2\2(\u0683\3"+
		"\2\2\2*\u068f\3\2\2\2,\u06e4\3\2\2\2.\u06e6\3\2\2\2\60\u070b\3\2\2\2\62"+
		"\u07af\3\2\2\2\64\u07b1\3\2\2\2\66\u07b6\3\2\2\28\u0829\3\2\2\2:\u0858"+
		"\3\2\2\2<\u085d\3\2\2\2>\u0872\3\2\2\2@\u087d\3\2\2\2B\u0881\3\2\2\2D"+
		"\u0889\3\2\2\2F\u088c\3\2\2\2H\u0894\3\2\2\2J\u089f\3\2\2\2L\u08a2\3\2"+
		"\2\2N\u08a4\3\2\2\2P\u08b0\3\2\2\2R\u08b4\3\2\2\2T\u08b7\3\2\2\2V\u08ba"+
		"\3\2\2\2X\u08c0\3\2\2\2Z\u08c2\3\2\2\2\\\u08cc\3\2\2\2^\u08d4\3\2\2\2"+
		"`\u08e6\3\2\2\2b\u08f3\3\2\2\2d\u08fb\3\2\2\2f\u08fe\3\2\2\2h\u0901\3"+
		"\2\2\2j\u090b\3\2\2\2l\u0913\3\2\2\2n\u091d\3\2\2\2p\u0922\3\2\2\2r\u0924"+
		"\3\2\2\2t\u0938\3\2\2\2v\u093a\3\2\2\2x\u093e\3\2\2\2z\u0943\3\2\2\2|"+
		"\u0948\3\2\2\2~\u094a\3\2\2\2\u0080\u094d\3\2\2\2\u0082\u0950\3\2\2\2"+
		"\u0084\u0953\3\2\2\2\u0086\u0955\3\2\2\2\u0088\u0963\3\2\2\2\u008a\u0965"+
		"\3\2\2\2\u008c\u0967\3\2\2\2\u008e\u0980\3\2\2\2\u0090\u0982\3\2\2\2\u0092"+
		"\u09a9\3\2\2\2\u0094\u09b3\3\2\2\2\u0096\u09b7\3\2\2\2\u0098\u09ce\3\2"+
		"\2\2\u009a\u09da\3\2\2\2\u009c\u09e4\3\2\2\2\u009e\u09e6\3\2\2\2\u00a0"+
		"\u09f5\3\2\2\2\u00a2\u0a04\3\2\2\2\u00a4\u0a13\3\2\2\2\u00a6\u0a17\3\2"+
		"\2\2\u00a8\u0a19\3\2\2\2\u00aa\u0a24\3\2\2\2\u00ac\u0a26\3\2\2\2\u00ae"+
		"\u0a28\3\2\2\2\u00b0\u0a2b\3\2\2\2\u00b2\u0a2f\3\2\2\2\u00b4\u0a39\3\2"+
		"\2\2\u00b6\u0a3b\3\2\2\2\u00b8\u0a43\3\2\2\2\u00ba\u0a45\3\2\2\2\u00bc"+
		"\u0a4b\3\2\2\2\u00be\u0a50\3\2\2\2\u00c0\u0a64\3\2\2\2\u00c2\u0a68\3\2"+
		"\2\2\u00c4\u0a6a\3\2\2\2\u00c6\u0a76\3\2\2\2\u00c8\u0a81\3\2\2\2\u00ca"+
		"\u0a86\3\2\2\2\u00cc\u0a8b\3\2\2\2\u00ce\u0a90\3\2\2\2\u00d0\u0a92\3\2"+
		"\2\2\u00d2\u0a99\3\2\2\2\u00d4\u0a9b\3\2\2\2\u00d6\u0aa0\3\2\2\2\u00d8"+
		"\u0aa5\3\2\2\2\u00da\u0aa7\3\2\2\2\u00dc\u0aaf\3\2\2\2\u00de\u0ab8\3\2"+
		"\2\2\u00e0\u0abc\3\2\2\2\u00e2\u0ad0\3\2\2\2\u00e4\u0ad2\3\2\2\2\u00e6"+
		"\u0ad4\3\2\2\2\u00e8\u0ad6\3\2\2\2\u00ea\u0ae0\3\2\2\2\u00ec\u0ae2\3\2"+
		"\2\2\u00ee\u0ae6\3\2\2\2\u00f0\u0ae8\3\2\2\2\u00f2\u0aea\3\2\2\2\u00f4"+
		"\u0af2\3\2\2\2\u00f6\u0af6\3\2\2\2\u00f8\u0af8\3\2\2\2\u00fa\u0afa\3\2"+
		"\2\2\u00fc\u0b0d\3\2\2\2\u00fe\u0b0f\3\2\2\2\u0100\u0b11\3\2\2\2\u0102"+
		"\u0b13\3\2\2\2\u0104\u0b1b\3\2\2\2\u0106\u0b26\3\2\2\2\u0108\u0b28\3\2"+
		"\2\2\u010a\u0b2c\3\2\2\2\u010c\u0b32\3\2\2\2\u010e\u0b36\3\2\2\2\u0110"+
		"\u0b3a\3\2\2\2\u0112\u0b3c\3\2\2\2\u0114\u0b42\3\2\2\2\u0116\u0b44\3\2"+
		"\2\2\u0118\u0b46\3\2\2\2\u011a\u0b4a\3\2\2\2\u011c\u0b4e\3\2\2\2\u011e"+
		"\u0b50\3\2\2\2\u0120\u0b60\3\2\2\2\u0122\u0b63\3\2\2\2\u0124\u0b6d\3\2"+
		"\2\2\u0126\u0b6f\3\2\2\2\u0128\u0b88\3\2\2\2\u012a\u0b8a\3\2\2\2\u012c"+
		"\u0b8f\3\2\2\2\u012e\u0b95\3\2\2\2\u0130\u0b9c\3\2\2\2\u0132\u0ba2\3\2"+
		"\2\2\u0134\u0ba4\3\2\2\2\u0136\u0ba8\3\2\2\2\u0138\u0bac\3\2\2\2\u013a"+
		"\u0bae\3\2\2\2\u013c\u0bb1\3\2\2\2\u013e\u0bce\3\2\2\2\u0140\u0bd0\3\2"+
		"\2\2\u0142\u0bd8\3\2\2\2\u0144\u0bda\3\2\2\2\u0146\u0bdd\3\2\2\2\u0148"+
		"\u0bdf\3\2\2\2\u014a\u0be3\3\2\2\2\u014c\u0bef\3\2\2\2\u014e\u0bf6\3\2"+
		"\2\2\u0150\u0bf8\3\2\2\2\u0152\u0c00\3\2\2\2\u0154\u0c05\3\2\2\2\u0156"+
		"\u0c0a\3\2\2\2\u0158\u0c0d\3\2\2\2\u015a\u0c10\3\2\2\2\u015c\u0c18\3\2"+
		"\2\2\u015e\u0c1c\3\2\2\2\u0160\u0c26\3\2\2\2\u0162\u0c34\3\2\2\2\u0164"+
		"\u0c3e\3\2\2\2\u0166\u0c4c\3\2\2\2\u0168\u0c53\3\2\2\2\u016a\u0c57\3\2"+
		"\2\2\u016c\u0c59\3\2\2\2\u016e\u0c5e\3\2\2\2\u0170\u0c60\3\2\2\2\u0172"+
		"\u0c69\3\2\2\2\u0174\u0c71\3\2\2\2\u0176\u0c7b\3\2\2\2\u0178\u0c7d\3\2"+
		"\2\2\u017a\u0c83\3\2\2\2\u017c\u0c87\3\2\2\2\u017e\u0c8c\3\2\2\2\u0180"+
		"\u0c91\3\2\2\2\u0182\u0c95\3\2\2\2\u0184\u0c9d\3\2\2\2\u0186\u0c9f\3\2"+
		"\2\2\u0188\u0ca1\3\2\2\2\u018a\u0ca3\3\2\2\2\u018c\u0cad\3\2\2\2\u018e"+
		"\u0caf\3\2\2\2\u0190\u0cb3\3\2\2\2\u0192\u0cb5\3\2\2\2\u0194\u0cb9\3\2"+
		"\2\2\u0196\u0cc3\3\2\2\2\u0198\u0ccf\3\2\2\2\u019a\u0cd1\3\2\2\2\u019c"+
		"\u0cd9\3\2\2\2\u019e\u0ce2\3\2\2\2\u01a0\u0cea\3\2\2\2\u01a2\u0cec\3\2"+
		"\2\2\u01a4\u0cee\3\2\2\2\u01a6\u0cf5\3\2\2\2\u01a8\u0cfc\3\2\2\2\u01aa"+
		"\u0cfe\3\2\2\2\u01ac\u0d00\3\2\2\2\u01ae\u0d03\3\2\2\2\u01b0\u0d08\3\2"+
		"\2\2\u01b2\u0d0d\3\2\2\2\u01b4\u0d0f\3\2\2\2\u01b6\u0d11\3\2\2\2\u01b8"+
		"\u0d13\3\2\2\2\u01ba\u0d1a\3\2\2\2\u01bc\u0d1e\3\2\2\2\u01be\u0d20\3\2"+
		"\2\2\u01c0\u0d28\3\2\2\2\u01c2\u0d2c\3\2\2\2\u01c4\u0d34\3\2\2\2\u01c6"+
		"\u0d3b\3\2\2\2\u01c8\u0d3d\3\2\2\2\u01ca\u0d44\3\2\2\2\u01cc\u0d63\3\2"+
		"\2\2\u01ce\u01d0\5\4\3\2\u01cf\u01d1\7\u012e\2\2\u01d0\u01cf\3\2\2\2\u01d0"+
		"\u01d1\3\2\2\2\u01d1\u01d3\3\2\2\2\u01d2\u01ce\3\2\2\2\u01d3\u01d6\3\2"+
		"\2\2\u01d4\u01d2\3\2\2\2\u01d4\u01d5\3\2\2\2\u01d5\u01d7\3\2\2\2\u01d6"+
		"\u01d4\3\2\2\2\u01d7\u01d8\7\2\2\3\u01d8\3\3\2\2\2\u01d9\u01e7\5\6\4\2"+
		"\u01da\u01e7\5\n\6\2\u01db\u01e7\5\f\7\2\u01dc\u01e7\5\16\b\2\u01dd\u01e7"+
		"\5\20\t\2\u01de\u01e7\5\22\n\2\u01df\u01e7\5\30\r\2\u01e0\u01e7\5\24\13"+
		"\2\u01e1\u01e7\5\34\17\2\u01e2\u01e7\5\36\20\2\u01e3\u01e7\5*\26\2\u01e4"+
		"\u01e7\5,\27\2\u01e5\u01e7\5.\30\2\u01e6\u01d9\3\2\2\2\u01e6\u01da\3\2"+
		"\2\2\u01e6\u01db\3\2\2\2\u01e6\u01dc\3\2\2\2\u01e6\u01dd\3\2\2\2\u01e6"+
		"\u01de\3\2\2\2\u01e6\u01df\3\2\2\2\u01e6\u01e0\3\2\2\2\u01e6\u01e1\3\2"+
		"\2\2\u01e6\u01e2\3\2\2\2\u01e6\u01e3\3\2\2\2\u01e6\u01e4\3\2\2\2\u01e6"+
		"\u01e5\3\2\2\2\u01e7\5\3\2\2\2\u01e8\u01e9\5\u015c\u00af\2\u01e9\7\3\2"+
		"\2\2\u01ea\u01eb\5\u01cc\u00e7\2\u01eb\t\3\2\2\2\u01ec\u01ef\5\62\32\2"+
		"\u01ed\u01ef\5r:\2\u01ee\u01ec\3\2\2\2\u01ee\u01ed\3\2\2\2\u01ef\13\3"+
		"\2\2\2\u01f0\u01f2\7\27\2\2\u01f1\u01f3\7x\2\2\u01f2\u01f1\3\2\2\2\u01f2"+
		"\u01f3\3\2\2\2\u01f3\u01f4\3\2\2\2\u01f4\u01f5\7\u00ae\2\2\u01f5\u01f6"+
		"\5t;\2\u01f6\u01f7\7P\2\2\u01f7\u01f9\5\u0170\u00b9\2\u01f8\u01fa\5R*"+
		"\2\u01f9\u01f8\3\2\2\2\u01f9\u01fa\3\2\2\2\u01fa\u01fb\3\2\2\2\u01fb\u01fc"+
		"\7\u0136\2\2\u01fc\u01fd\5\u01c2\u00e2\2\u01fd\u01ff\7\u0137\2\2\u01fe"+
		"\u0200\5N(\2\u01ff\u01fe\3\2\2\2\u01ff\u0200\3\2\2\2\u0200\r\3\2\2\2\u0201"+
		"\u0202\7\27\2\2\u0202\u0206\7)\2\2\u0203\u0204\7\65\2\2\u0204\u0205\7"+
		"L\2\2\u0205\u0207\7\u00a3\2\2\u0206\u0203\3\2\2\2\u0206\u0207\3\2\2\2"+
		"\u0207\u0208\3\2\2\2\u0208\u020a\5t;\2\u0209\u020b\7\u0080\2\2\u020a\u0209"+
		"\3\2\2\2\u020a\u020b\3\2\2\2\u020b\u020e\3\2\2\2\u020c\u020d\7f\2\2\u020d"+
		"\u020f\5t;\2\u020e\u020c\3\2\2\2\u020e\u020f\3\2\2\2\u020f\u0212\3\2\2"+
		"\2\u0210\u0211\7\u00fa\2\2\u0211\u0213\5t;\2\u0212\u0210\3\2\2\2\u0212"+
		"\u0213\3\2\2\2\u0213\u0216\3\2\2\2\u0214\u0215\7\60\2\2\u0215\u0217\5"+
		"t;\2\u0216\u0214\3\2\2\2\u0216\u0217\3\2\2\2\u0217\17\3\2\2\2\u0218\u021a"+
		"\7\u00e0\2\2\u0219\u021b\t\2\2\2\u021a\u0219\3\2\2\2\u021a\u021b\3\2\2"+
		"\2\u021b\u021c\3\2\2\2\u021c\u021d\5t;\2\u021d\u0229\t\3\2\2\u021e\u0225"+
		"\5t;\2\u021f\u0220\7\u0140\2\2\u0220\u0221\5t;\2\u0221\u0222\7\u0140\2"+
		"\2\u0222\u0225\3\2\2\2\u0223\u0225\7\32\2\2\u0224\u021e\3\2\2\2\u0224"+
		"\u021f\3\2\2\2\u0224\u0223\3\2\2\2\u0225\u0227\3\2\2\2\u0226\u0228\7\u012f"+
		"\2\2\u0227\u0226\3\2\2\2\u0227\u0228\3\2\2\2\u0228\u022a\3\2\2\2\u0229"+
		"\u0224\3\2\2\2\u022a\u022b\3\2\2\2\u022b\u0229\3\2\2\2\u022b\u022c\3\2"+
		"\2\2\u022c\u0240\3\2\2\2\u022d\u022f\7\u00e0\2\2\u022e\u0230\t\2\2\2\u022f"+
		"\u022e\3\2\2\2\u022f\u0230\3\2\2\2\u0230\u0231\3\2\2\2\u0231\u0232\7\u011b"+
		"\2\2\u0232\u023b\7\u0100\2\2\u0233\u0237\5t;\2\u0234\u0237\7J\2\2\u0235"+
		"\u0237\7\32\2\2\u0236\u0233\3\2\2\2\u0236\u0234\3\2\2\2\u0236\u0235\3"+
		"\2\2\2\u0237\u0239\3\2\2\2\u0238\u023a\7\u012f\2\2\u0239\u0238\3\2\2\2"+
		"\u0239\u023a\3\2\2\2\u023a\u023c\3\2\2\2\u023b\u0236\3\2\2\2\u023c\u023d"+
		"\3\2\2\2\u023d\u023b\3\2\2\2\u023d\u023e\3\2\2\2\u023e\u0240\3\2\2\2\u023f"+
		"\u0218\3\2\2\2\u023f\u022d\3\2\2\2\u0240\21\3\2\2\2\u0241\u0243\7\27\2"+
		"\2\u0242\u0244\7\24\2\2\u0243\u0242\3\2\2\2\u0243\u0244\3\2\2\2\u0244"+
		"\u0245\3\2\2\2\u0245\u0246\7t\2\2\u0246\u024b\5t;\2\u0247\u024c\7\f\2"+
		"\2\u0248\u0249\7A\2\2\u0249\u024c\7N\2\2\u024a\u024c\7\4\2\2\u024b\u0247"+
		"\3\2\2\2\u024b\u0248\3\2\2\2\u024b\u024a\3\2\2\2\u024c\u025c\3\2\2\2\u024d"+
		"\u025d\7\u00b2\2\2\u024e\u025d\7\36\2\2\u024f\u025d\7v\2\2\u0250\u025a"+
		"\7y\2\2\u0251\u0256\7N\2\2\u0252\u0254\5t;\2\u0253\u0255\7\u012f\2\2\u0254"+
		"\u0253\3\2\2\2\u0254\u0255\3\2\2\2\u0255\u0257\3\2\2\2\u0256\u0252\3\2"+
		"\2\2\u0257\u0258\3\2\2\2\u0258\u0256\3\2\2\2\u0258\u0259\3\2\2\2\u0259"+
		"\u025b\3\2\2\2\u025a\u0251\3\2\2\2\u025a\u025b\3\2\2\2\u025b\u025d\3\2"+
		"\2\2\u025c\u024d\3\2\2\2\u025c\u024e\3\2\2\2\u025c\u024f\3\2\2\2\u025c"+
		"\u0250\3\2\2\2\u025d\u025e\3\2\2\2\u025e\u025f\7P\2\2\u025f\u0262\5\u0170"+
		"\u00b9\2\u0260\u0261\7\60\2\2\u0261\u0263\5\u0170\u00b9\2\u0262\u0260"+
		"\3\2\2\2\u0262\u0263\3\2\2\2\u0263\u026d\3\2\2\2\u0264\u0265\7L\2\2\u0265"+
		"\u026e\7\34\2\2\u0266\u0268\7\34\2\2\u0267\u0266\3\2\2\2\u0267\u0268\3"+
		"\2\2\2\u0268\u0269\3\2\2\2\u0269\u026a\7<\2\2\u026a\u026e\7\67\2\2\u026b"+
		"\u026c\7<\2\2\u026c\u026e\7\35\2\2\u026d\u0264\3\2\2\2\u026d\u0267\3\2"+
		"\2\2\u026d\u026b\3\2\2\2\u026d\u026e\3\2\2\2\u026e\u0275\3\2\2\2\u026f"+
		"\u0271\7+\2\2\u0270\u0272\7\"\2\2\u0271\u0270\3\2\2\2\u0271\u0272\3\2"+
		"\2\2\u0272\u0273\3\2\2\2\u0273\u0276\7]\2\2\u0274\u0276\7l\2\2\u0275\u026f"+
		"\3\2\2\2\u0275\u0274\3\2\2\2\u0275\u0276\3\2\2\2\u0276\u0279\3\2\2\2\u0277"+
		"\u0278\7~\2\2\u0278\u027a\5\u0100\u0081\2\u0279\u0277\3\2\2\2\u0279\u027a"+
		"\3\2\2\2\u027a\u027b\3\2\2\2\u027b\u027c\7(\2\2\u027c\u027d\7Z\2\2\u027d"+
		"\u027e\5t;\2\u027e\u0283\7\u0136\2\2\u027f\u0281\5t;\2\u0280\u0282\7\u012f"+
		"\2\2\u0281\u0280\3\2\2\2\u0281\u0282\3\2\2\2\u0282\u0284\3\2\2\2\u0283"+
		"\u027f\3\2\2\2\u0283\u0284\3\2\2\2\u0284\u0285\3\2\2\2\u0285\u0286\7\u0137"+
		"\2\2\u0286\23\3\2\2\2\u0287\u028b\7c\2\2\u0288\u0289\7\62\2\2\u0289\u028a"+
		"\7\u00cd\2\2\u028a\u028c\7+\2\2\u028b\u0288\3\2\2\2\u028b\u028c\3\2\2"+
		"\2\u028c\u0296\3\2\2\2\u028d\u028f\t\4\2\2\u028e\u028d\3\2\2\2\u028f\u0290"+
		"\3\2\2\2\u0290\u028e\3\2\2\2\u0290\u0291\3\2\2\2\u0291\u0297\3\2\2\2\u0292"+
		"\u0294\7\6\2\2\u0293\u0295\7Y\2\2\u0294\u0293\3\2\2\2\u0294\u0295\3\2"+
		"\2\2\u0295\u0297\3\2\2\2\u0296\u028e\3\2\2\2\u0296\u0292\3\2\2\2\u0297"+
		"\u0298\3\2\2\2\u0298\u02aa\7P\2\2\u0299\u029b\7o\2\2\u029a\u0299\3\2\2"+
		"\2\u029a\u029b\3\2\2\2\u029b\u029c\3\2\2\2\u029c\u029e\5\u0170\u00b9\2"+
		"\u029d\u029a\3\2\2\2\u029e\u029f\3\2\2\2\u029f\u029d\3\2\2\2\u029f\u02a0"+
		"\3\2\2\2\u02a0\u02ab\3\2\2\2\u02a1\u02a2\7\6\2\2\u02a2\u02a3\7\u00eb\2"+
		"\2\u02a3\u02a4\79\2\2\u02a4\u02a6\7f\2\2\u02a5\u02a7\5t;\2\u02a6\u02a5"+
		"\3\2\2\2\u02a7\u02a8\3\2\2\2\u02a8\u02a6\3\2\2\2\u02a8\u02a9\3\2\2\2\u02a9"+
		"\u02ab\3\2\2\2\u02aa\u029d\3\2\2\2\u02aa\u02a1\3\2\2\2\u02ab\u02ac\3\2"+
		"\2\2\u02ac\u02ad\5\26\f\2\u02ad\u0403\3\2\2\2\u02ae\u02b2\7c\2\2\u02af"+
		"\u02b0\7\62\2\2\u02b0\u02b1\7\u00cd\2\2\u02b1\u02b3\7+\2\2\u02b2\u02af"+
		"\3\2\2\2\u02b2\u02b3\3\2\2\2\u02b3\u02d3\3\2\2\2\u02b4\u02b5\t\5\2\2\u02b5"+
		"\u02ba\7\u0136\2\2\u02b6\u02b8\5t;\2\u02b7\u02b9\7\u012f\2\2\u02b8\u02b7"+
		"\3\2\2\2\u02b8\u02b9\3\2\2\2\u02b9\u02bb\3\2\2\2\u02ba\u02b6\3\2\2\2\u02bb"+
		"\u02bc\3\2\2\2\u02bc\u02ba\3\2\2\2\u02bc\u02bd\3\2\2\2\u02bd\u02be\3\2"+
		"\2\2\u02be\u02bf\7\u0137\2\2\u02bf\u02c1\3\2\2\2\u02c0\u02b4\3\2\2\2\u02c1"+
		"\u02c2\3\2\2\2\u02c2\u02c0\3\2\2\2\u02c2\u02c3\3\2\2\2\u02c3\u02d4\3\2"+
		"\2\2\u02c4\u02c6\7\6\2\2\u02c5\u02c7\7Y\2\2\u02c6\u02c5\3\2\2\2\u02c6"+
		"\u02c7\3\2\2\2\u02c7\u02c8\3\2\2\2\u02c8\u02cd\7\u0136\2\2\u02c9\u02cb"+
		"\5t;\2\u02ca\u02cc\7\u012f\2\2\u02cb\u02ca\3\2\2\2\u02cb\u02cc\3\2\2\2"+
		"\u02cc\u02ce\3\2\2\2\u02cd\u02c9\3\2\2\2\u02ce\u02cf\3\2\2\2\u02cf\u02cd"+
		"\3\2\2\2\u02cf\u02d0\3\2\2\2\u02d0\u02d1\3\2\2\2\u02d1\u02d2\7\u0137\2"+
		"\2\u02d2\u02d4\3\2\2\2\u02d3\u02c0\3\2\2\2\u02d3\u02c4\3\2\2\2\u02d4\u02d5"+
		"\3\2\2\2\u02d5\u02d7\7P\2\2\u02d6\u02d8\7o\2\2\u02d7\u02d6\3\2\2\2\u02d7"+
		"\u02d8\3\2\2\2\u02d8\u02dd\3\2\2\2\u02d9\u02db\5\u0170\u00b9\2\u02da\u02dc"+
		"\7\u012f\2\2\u02db\u02da\3\2\2\2\u02db\u02dc\3\2\2\2\u02dc\u02de\3\2\2"+
		"\2\u02dd\u02d9\3\2\2\2\u02de\u02df\3\2\2\2\u02df\u02dd\3\2\2\2\u02df\u02e0"+
		"\3\2\2\2\u02e0\u02e1\3\2\2\2\u02e1\u02e2\5\26\f\2\u02e2\u0403\3\2\2\2"+
		"\u02e3\u02e7\7c\2\2\u02e4\u02e5\7\62\2\2\u02e5\u02e6\7\u00cd\2\2\u02e6"+
		"\u02e8\7+\2\2\u02e7\u02e4\3\2\2\2\u02e7\u02e8\3\2\2\2\u02e8\u02f2\3\2"+
		"\2\2\u02e9\u02eb\t\6\2\2\u02ea\u02e9\3\2\2\2\u02eb\u02ec\3\2\2\2\u02ec"+
		"\u02ea\3\2\2\2\u02ec\u02ed\3\2\2\2\u02ed\u02f3\3\2\2\2\u02ee\u02f0\7\6"+
		"\2\2\u02ef\u02f1\7Y\2\2\u02f0\u02ef\3\2\2\2\u02f0\u02f1\3\2\2\2\u02f1"+
		"\u02f3\3\2\2\2\u02f2\u02ea\3\2\2\2\u02f2\u02ee\3\2\2\2\u02f3\u02f4\3\2"+
		"\2\2\u02f4\u030a\7P\2\2\u02f5\u02fa\7g\2\2\u02f6\u02f8\5\u0170\u00b9\2"+
		"\u02f7\u02f9\7\u012f\2\2\u02f8\u02f7\3\2\2\2\u02f8\u02f9\3\2\2\2\u02f9"+
		"\u02fb\3\2\2\2\u02fa\u02f6\3\2\2\2\u02fb\u02fc\3\2\2\2\u02fc\u02fa\3\2"+
		"\2\2\u02fc\u02fd\3\2\2\2\u02fd\u030b\3\2\2\2\u02fe\u02ff\7\6\2\2\u02ff"+
		"\u0300\7h\2\2\u0300\u0301\79\2\2\u0301\u0306\7f\2\2\u0302\u0304\5t;\2"+
		"\u0303\u0305\7\u012f\2\2\u0304\u0303\3\2\2\2\u0304\u0305\3\2\2\2\u0305"+
		"\u0307\3\2\2\2\u0306\u0302\3\2\2\2\u0307\u0308\3\2\2\2\u0308\u0306\3\2"+
		"\2\2\u0308\u0309\3\2\2\2\u0309\u030b\3\2\2\2\u030a\u02f5\3\2\2\2\u030a"+
		"\u02fe\3\2\2\2\u030b\u030c\3\2\2\2\u030c\u030d\5\26\f\2\u030d\u0403\3"+
		"\2\2\2\u030e\u0312\7c\2\2\u030f\u0310\7\62\2\2\u0310\u0311\7\u00cd\2\2"+
		"\u0311\u0313\7+\2\2\u0312\u030f\3\2\2\2\u0312\u0313\3\2\2\2\u0313\u031d"+
		"\3\2\2\2\u0314\u0316\t\7\2\2\u0315\u0314\3\2\2\2\u0316\u0317\3\2\2\2\u0317"+
		"\u0315\3\2\2\2\u0317\u0318\3\2\2\2\u0318\u031e\3\2\2\2\u0319\u031b\7\6"+
		"\2\2\u031a\u031c\7Y\2\2\u031b\u031a\3\2\2\2\u031b\u031c\3\2\2\2\u031c"+
		"\u031e\3\2\2\2\u031d\u0315\3\2\2\2\u031d\u0319\3\2\2\2\u031e\u031f\3\2"+
		"\2\2\u031f\u0320\7P\2\2\u0320\u0325\7\31\2\2\u0321\u0323\5t;\2\u0322\u0324"+
		"\7\u012f\2\2\u0323\u0322\3\2\2\2\u0323\u0324\3\2\2\2\u0324\u0326\3\2\2"+
		"\2\u0325\u0321\3\2\2\2\u0326\u0327\3\2\2\2\u0327\u0325\3\2\2\2\u0327\u0328"+
		"\3\2\2\2\u0328\u0329\3\2\2\2\u0329\u032a\5\26\f\2\u032a\u0403\3\2\2\2"+
		"\u032b\u032f\7c\2\2\u032c\u032d\7\62\2\2\u032d\u032e\7\u00cd\2\2\u032e"+
		"\u0330\7+\2\2\u032f\u032c\3\2\2\2\u032f\u0330\3\2\2\2\u0330\u0336\3\2"+
		"\2\2\u0331\u0337\7z\2\2\u0332\u0334\7\6\2\2\u0333\u0335\7Y\2\2\u0334\u0333"+
		"\3\2\2\2\u0334\u0335\3\2\2\2\u0335\u0337\3\2\2\2\u0336\u0331\3\2\2\2\u0336"+
		"\u0332\3\2\2\2\u0337\u0338\3\2\2\2\u0338\u0339\7P\2\2\u0339\u033a\7,\2"+
		"\2\u033a\u033b\7\u0098\2\2\u033b\u0340\7\u00fe\2\2\u033c\u033e\5\u0170"+
		"\u00b9\2\u033d\u033f\7\u012f\2\2\u033e\u033d\3\2\2\2\u033e\u033f\3\2\2"+
		"\2\u033f\u0341\3\2\2\2\u0340\u033c\3\2\2\2\u0341\u0342\3\2\2\2\u0342\u0340"+
		"\3\2\2\2\u0342\u0343\3\2\2\2\u0343\u0344\3\2\2\2\u0344\u0345\5\26\f\2"+
		"\u0345\u0403\3\2\2\2\u0346\u034a\7c\2\2\u0347\u0348\7\62\2\2\u0348\u0349"+
		"\7\u00cd\2\2\u0349\u034b\7+\2\2\u034a\u0347\3\2\2\2\u034a\u034b\3\2\2"+
		"\2\u034b\u0351\3\2\2\2\u034c\u0352\7z\2\2\u034d\u034f\7\6\2\2\u034e\u0350"+
		"\7Y\2\2\u034f\u034e\3\2\2\2\u034f\u0350\3\2\2\2\u0350\u0352\3\2\2\2\u0351"+
		"\u034c\3\2\2\2\u0351\u034d\3\2\2\2\u0352\u0353\3\2\2\2\u0353\u0354\7P"+
		"\2\2\u0354\u0355\7,\2\2\u0355\u035a\7\u00df\2\2\u0356\u0358\5t;\2\u0357"+
		"\u0359\7\u012f\2\2\u0358\u0357\3\2\2\2\u0358\u0359\3\2\2\2\u0359\u035b"+
		"\3\2\2\2\u035a\u0356\3\2\2\2\u035b\u035c\3\2\2\2\u035c\u035a\3\2\2\2\u035c"+
		"\u035d\3\2\2\2\u035d\u035e\3\2\2\2\u035e\u035f\5\26\f\2\u035f\u0403\3"+
		"\2\2\2\u0360\u0364\7c\2\2\u0361\u0362\7\62\2\2\u0362\u0363\7\u00cd\2\2"+
		"\u0363\u0365\7+\2\2\u0364\u0361\3\2\2\2\u0364\u0365\3\2\2\2\u0365\u036b"+
		"\3\2\2\2\u0366\u036c\7(\2\2\u0367\u0369\7\6\2\2\u0368\u036a\7Y\2\2\u0369"+
		"\u0368\3\2\2\2\u0369\u036a\3\2\2\2\u036a\u036c\3\2\2\2\u036b\u0366\3\2"+
		"\2\2\u036b\u0367\3\2\2\2\u036c\u036d\3\2\2\2\u036d\u0370\7P\2\2\u036e"+
		"\u0371\5&\24\2\u036f\u0371\5(\25\2\u0370\u036e\3\2\2\2\u0370\u036f\3\2"+
		"\2\2\u0371\u0372\3\2\2\2\u0372\u0373\5\26\f\2\u0373\u0403\3\2\2\2\u0374"+
		"\u0378\7c\2\2\u0375\u0376\7\62\2\2\u0376\u0377\7\u00cd\2\2\u0377\u0379"+
		"\7+\2\2\u0378\u0375\3\2\2\2\u0378\u0379\3\2\2\2\u0379\u037f\3\2\2\2\u037a"+
		"\u0380\7z\2\2\u037b\u037d\7\6\2\2\u037c\u037e\7Y\2\2\u037d\u037c\3\2\2"+
		"\2\u037d\u037e\3\2\2\2\u037e\u0380\3\2\2\2\u037f\u037a\3\2\2\2\u037f\u037b"+
		"\3\2\2\2\u0380\u0381\3\2\2\2\u0381\u0382\7P\2\2\u0382\u0387\7\u00b8\2"+
		"\2\u0383\u0385\5t;\2\u0384\u0386\7\u012f\2\2\u0385\u0384\3\2\2\2\u0385"+
		"\u0386\3\2\2\2\u0386\u0388\3\2\2\2\u0387\u0383\3\2\2\2\u0388\u0389\3\2"+
		"\2\2\u0389\u0387\3\2\2\2\u0389\u038a\3\2\2\2\u038a\u038b\3\2\2\2\u038b"+
		"\u038c\5\26\f\2\u038c\u0403\3\2\2\2\u038d\u0391\7c\2\2\u038e\u038f\7\62"+
		"\2\2\u038f\u0390\7\u00cd\2\2\u0390\u0392\7+\2\2\u0391\u038e\3\2\2\2\u0391"+
		"\u0392\3\2\2\2\u0392\u03a0\3\2\2\2\u0393\u0399\7i\2\2\u0394\u0396\7y\2"+
		"\2\u0395\u0397\7\u012f\2\2\u0396\u0395\3\2\2\2\u0396\u0397\3\2\2\2\u0397"+
		"\u0399\3\2\2\2\u0398\u0393\3\2\2\2\u0398\u0394\3\2\2\2\u0399\u039a\3\2"+
		"\2\2\u039a\u0398\3\2\2\2\u039a\u039b\3\2\2\2\u039b\u03a1\3\2\2\2\u039c"+
		"\u039e\7\6\2\2\u039d\u039f\7Y\2\2\u039e\u039d\3\2\2\2\u039e\u039f\3\2"+
		"\2\2\u039f\u03a1\3\2\2\2\u03a0\u0398\3\2\2\2\u03a0\u039c\3\2\2\2\u03a1"+
		"\u03a2\3\2\2\2\u03a2\u03a3\7P\2\2\u03a3\u03a4\7\u00b9\2\2\u03a4\u03a9"+
		"\7\u00cc\2\2\u03a5\u03a7\5t;\2\u03a6\u03a8\7\u012f\2\2\u03a7\u03a6\3\2"+
		"\2\2\u03a7\u03a8\3\2\2\2\u03a8\u03aa\3\2\2\2\u03a9\u03a5\3\2\2\2\u03aa"+
		"\u03ab\3\2\2\2\u03ab\u03a9\3\2\2\2\u03ab\u03ac\3\2\2\2\u03ac\u03ad\3\2"+
		"\2\2\u03ad\u03ae\5\26\f\2\u03ae\u0403\3\2\2\2\u03af\u03b3\7c\2\2\u03b0"+
		"\u03b1\7\62\2\2\u03b1\u03b2\7\u00cd\2\2\u03b2\u03b4\7+\2\2\u03b3\u03b0"+
		"\3\2\2\2\u03b3\u03b4\3\2\2\2\u03b4\u03c1\3\2\2\2\u03b5\u03b7\t\b\2\2\u03b6"+
		"\u03b8\7\u012f\2\2\u03b7\u03b6\3\2\2\2\u03b7\u03b8\3\2\2\2\u03b8\u03ba"+
		"\3\2\2\2\u03b9\u03b5\3\2\2\2\u03ba\u03bb\3\2\2\2\u03bb\u03b9\3\2\2\2\u03bb"+
		"\u03bc\3\2\2\2\u03bc\u03c2\3\2\2\2\u03bd\u03bf\7\6\2\2\u03be\u03c0\7Y"+
		"\2\2\u03bf\u03be\3\2\2\2\u03bf\u03c0\3\2\2\2\u03c0\u03c2\3\2\2\2\u03c1"+
		"\u03b9\3\2\2\2\u03c1\u03bd\3\2\2\2\u03c2\u03c3\3\2\2\2\u03c3\u03c4\7P"+
		"\2\2\u03c4\u03c9\7f\2\2\u03c5\u03c7\5t;\2\u03c6\u03c8\7\u012f\2\2\u03c7"+
		"\u03c6\3\2\2\2\u03c7\u03c8\3\2\2\2\u03c8\u03ca\3\2\2\2\u03c9\u03c5\3\2"+
		"\2\2\u03ca\u03cb\3\2\2\2\u03cb\u03c9\3\2\2\2\u03cb\u03cc\3\2\2\2\u03cc"+
		"\u03cd\3\2\2\2\u03cd\u03ce\5\26\f\2\u03ce\u0403\3\2\2\2\u03cf\u03d3\7"+
		"c\2\2\u03d0\u03d1\7\62\2\2\u03d1\u03d2\7\u00cd\2\2\u03d2\u03d4\7+\2\2"+
		"\u03d3\u03d0\3\2\2\2\u03d3\u03d4\3\2\2\2\u03d4\u03da\3\2\2\2\u03d5\u03db"+
		"\7\27\2\2\u03d6\u03d8\7\6\2\2\u03d7\u03d9\7Y\2\2\u03d8\u03d7\3\2\2\2\u03d8"+
		"\u03d9\3\2\2\2\u03d9\u03db\3\2\2\2\u03da\u03d5\3\2\2\2\u03da\u03d6\3\2"+
		"\2\2\u03db\u03dc\3\2\2\2\u03dc\u03dd\7P\2\2\u03dd\u03e2\7\u00ea\2\2\u03de"+
		"\u03e0\5t;\2\u03df\u03e1\7\u012f\2\2\u03e0\u03df\3\2\2\2\u03e0\u03e1\3"+
		"\2\2\2\u03e1\u03e3\3\2\2\2\u03e2\u03de\3\2\2\2\u03e3\u03e4\3\2\2\2\u03e4"+
		"\u03e2\3\2\2\2\u03e4\u03e5\3\2\2\2\u03e5\u03e6\3\2\2\2\u03e6\u03e7\5\26"+
		"\f\2\u03e7\u0403\3\2\2\2\u03e8\u03ec\7c\2\2\u03e9\u03ea\7\u0082\2\2\u03ea"+
		"\u03eb\7\u00cd\2\2\u03eb\u03ed\7+\2\2\u03ec\u03e9\3\2\2\2\u03ec\u03ed"+
		"\3\2\2\2\u03ed\u03f2\3\2\2\2\u03ee\u03f0\5t;\2\u03ef\u03f1\7\u012f\2\2"+
		"\u03f0\u03ef\3\2\2\2\u03f0\u03f1\3\2\2\2\u03f1\u03f3\3\2\2\2\u03f2\u03ee"+
		"\3\2\2\2\u03f3\u03f4\3\2\2\2\u03f4\u03f2\3\2\2\2\u03f4\u03f5\3\2\2\2\u03f5"+
		"\u03f6\3\2\2\2\u03f6\u03fb\7\60\2\2\u03f7\u03f9\5t;\2\u03f8\u03fa\7\u012f"+
		"\2\2\u03f9\u03f8\3\2\2\2\u03f9\u03fa\3\2\2\2\u03fa\u03fc\3\2\2\2\u03fb"+
		"\u03f7\3\2\2\2\u03fc\u03fd\3\2\2\2\u03fd\u03fb\3\2\2\2\u03fd\u03fe\3\2"+
		"\2\2\u03fe\u0400\3\2\2\2\u03ff\u0401\t\t\2\2\u0400\u03ff\3\2\2\2\u0400"+
		"\u0401\3\2\2\2\u0401\u0403\3\2\2\2\u0402\u0287\3\2\2\2\u0402\u02ae\3\2"+
		"\2\2\u0402\u02e3\3\2\2\2\u0402\u030e\3\2\2\2\u0402\u032b\3\2\2\2\u0402"+
		"\u0346\3\2\2\2\u0402\u0360\3\2\2\2\u0402\u0374\3\2\2\2\u0402\u038d\3\2"+
		"\2\2\u0402\u03af\3\2\2\2\u0402\u03cf\3\2\2\2\u0402\u03e8\3\2\2\2\u0403"+
		"\25\3\2\2\2\u0404\u040d\7\60\2\2\u0405\u0407\7\63\2\2\u0406\u0405\3\2"+
		"\2\2\u0406\u0407\3\2\2\2\u0407\u0408\3\2\2\2\u0408\u040e\5t;\2\u0409\u040b"+
		"\7\u00d5\2\2\u040a\u040c\7\u012f\2\2\u040b\u040a\3\2\2\2\u040b\u040c\3"+
		"\2\2\2\u040c\u040e\3\2\2\2\u040d\u0406\3\2\2\2\u040d\u0409\3\2\2\2\u040e"+
		"\u040f\3\2\2\2\u040f\u040d\3\2\2\2\u040f\u0410\3\2\2\2\u0410\u0412\3\2"+
		"\2\2\u0411\u0413\t\t\2\2\u0412\u0411\3\2\2\2\u0412\u0413\3\2\2\2\u0413"+
		"\27\3\2\2\2\u0414\u041e\7\62\2\2\u0415\u0417\t\4\2\2\u0416\u0415\3\2\2"+
		"\2\u0417\u0418\3\2\2\2\u0418\u0416\3\2\2\2\u0418\u0419\3\2\2\2\u0419\u041f"+
		"\3\2\2\2\u041a\u041c\7\6\2\2\u041b\u041d\7Y\2\2\u041c\u041b\3\2\2\2\u041c"+
		"\u041d\3\2\2\2\u041d\u041f\3\2\2\2\u041e\u0416\3\2\2\2\u041e\u041a\3\2"+
		"\2\2\u041f\u0420\3\2\2\2\u0420\u0438\7P\2\2\u0421\u0423\7o\2\2\u0422\u0421"+
		"\3\2\2\2\u0422\u0423\3\2\2\2\u0423\u0428\3\2\2\2\u0424\u0426\5\u0170\u00b9"+
		"\2\u0425\u0427\7\u012f\2\2\u0426\u0425\3\2\2\2\u0426\u0427\3\2\2\2\u0427"+
		"\u0429\3\2\2\2\u0428\u0424\3\2\2\2\u0429\u042a\3\2\2\2\u042a\u0428\3\2"+
		"\2\2\u042a\u042b\3\2\2\2\u042b\u0439\3\2\2\2\u042c\u042d\7\6\2\2\u042d"+
		"\u042e\7\u00eb\2\2\u042e\u042f\79\2\2\u042f\u0434\7f\2\2\u0430\u0432\5"+
		"t;\2\u0431\u0433\7\u012f\2\2\u0432\u0431\3\2\2\2\u0432\u0433\3\2\2\2\u0433"+
		"\u0435\3\2\2\2\u0434\u0430\3\2\2\2\u0435\u0436\3\2\2\2\u0436\u0434\3\2"+
		"\2\2\u0436\u0437\3\2\2\2\u0437\u0439\3\2\2\2\u0438\u0422\3\2\2\2\u0438"+
		"\u042c\3\2\2\2\u0439\u043a\3\2\2\2\u043a\u043b\5\32\16\2\u043b\u055a\3"+
		"\2\2\2\u043c\u0456\7\62\2\2\u043d\u0442\t\5\2\2\u043e\u0440\5t;\2\u043f"+
		"\u0441\7\u012f\2\2\u0440\u043f\3\2\2\2\u0440\u0441\3\2\2\2\u0441\u0443"+
		"\3\2\2\2\u0442\u043e\3\2\2\2\u0443\u0444\3\2\2\2\u0444\u0442\3\2\2\2\u0444"+
		"\u0445\3\2\2\2\u0445\u0447\3\2\2\2\u0446\u043d\3\2\2\2\u0447\u0448\3\2"+
		"\2\2\u0448\u0446\3\2\2\2\u0448\u0449\3\2\2\2\u0449\u0457\3\2\2\2\u044a"+
		"\u044c\7\6\2\2\u044b\u044d\7Y\2\2\u044c\u044b\3\2\2\2\u044c\u044d\3\2"+
		"\2\2\u044d\u0452\3\2\2\2\u044e\u0450\5t;\2\u044f\u0451\7\u012f\2\2\u0450"+
		"\u044f\3\2\2\2\u0450\u0451\3\2\2\2\u0451\u0453\3\2\2\2\u0452\u044e\3\2"+
		"\2\2\u0453\u0454\3\2\2\2\u0454\u0452\3\2\2\2\u0454\u0455\3\2\2\2\u0455"+
		"\u0457\3\2\2\2\u0456\u0446\3\2\2\2\u0456\u044a\3\2\2\2\u0457\u0458\3\2"+
		"\2\2\u0458\u0460\7P\2\2\u0459\u045b\7o\2\2\u045a\u0459\3\2\2\2\u045a\u045b"+
		"\3\2\2\2\u045b\u045c\3\2\2\2\u045c\u045e\5\u0170\u00b9\2\u045d\u045f\7"+
		"\u012f\2\2\u045e\u045d\3\2\2\2\u045e\u045f\3\2\2\2\u045f\u0461\3\2\2\2"+
		"\u0460\u045a\3\2\2\2\u0461\u0462\3\2\2\2\u0462\u0460\3\2\2\2\u0462\u0463"+
		"\3\2\2\2\u0463\u0464\3\2\2\2\u0464\u0465\5\32\16\2\u0465\u055a\3\2\2\2"+
		"\u0466\u0473\7\62\2\2\u0467\u0469\t\6\2\2\u0468\u046a\7\u012f\2\2\u0469"+
		"\u0468\3\2\2\2\u0469\u046a\3\2\2\2\u046a\u046c\3\2\2\2\u046b\u0467\3\2"+
		"\2\2\u046c\u046d\3\2\2\2\u046d\u046b\3\2\2\2\u046d\u046e\3\2\2\2\u046e"+
		"\u0474\3\2\2\2\u046f\u0471\7\6\2\2\u0470\u0472\7Y\2\2\u0471\u0470\3\2"+
		"\2\2\u0471\u0472\3\2\2\2\u0472\u0474\3\2\2\2\u0473\u046b\3\2\2\2\u0473"+
		"\u046f\3\2\2\2\u0474\u0475\3\2\2\2\u0475\u048b\7P\2\2\u0476\u0477\7g\2"+
		"\2\u0477\u0479\5t;\2\u0478\u047a\7\u012f\2\2\u0479\u0478\3\2\2\2\u0479"+
		"\u047a\3\2\2\2\u047a\u047c\3\2\2\2\u047b\u0476\3\2\2\2\u047c\u047d\3\2"+
		"\2\2\u047d\u047b\3\2\2\2\u047d\u047e\3\2\2\2\u047e\u048c\3\2\2\2\u047f"+
		"\u0480\7\6\2\2\u0480\u0481\7h\2\2\u0481\u0482\79\2\2\u0482\u0487\7f\2"+
		"\2\u0483\u0485\5t;\2\u0484\u0486\7\u012f\2\2\u0485\u0484\3\2\2\2\u0485"+
		"\u0486\3\2\2\2\u0486\u0488\3\2\2\2\u0487\u0483\3\2\2\2\u0488\u0489\3\2"+
		"\2\2\u0489\u0487\3\2\2\2\u0489\u048a\3\2\2\2\u048a\u048c\3\2\2\2\u048b"+
		"\u047b\3\2\2\2\u048b\u047f\3\2\2\2\u048c\u048d\3\2\2\2\u048d\u048e\5\32"+
		"\16\2\u048e\u055a\3\2\2\2\u048f\u049c\7\62\2\2\u0490\u0492\t\7\2\2\u0491"+
		"\u0493\7\u012f\2\2\u0492\u0491\3\2\2\2\u0492\u0493\3\2\2\2\u0493\u0495"+
		"\3\2\2\2\u0494\u0490\3\2\2\2\u0495\u0496\3\2\2\2\u0496\u0494\3\2\2\2\u0496"+
		"\u0497\3\2\2\2\u0497\u049d\3\2\2\2\u0498\u049a\7\6\2\2\u0499\u049b\7Y"+
		"\2\2\u049a\u0499\3\2\2\2\u049a\u049b\3\2\2\2\u049b\u049d\3\2\2\2\u049c"+
		"\u0494\3\2\2\2\u049c\u0498\3\2\2\2\u049d\u049e\3\2\2\2\u049e\u049f\7P"+
		"\2\2\u049f\u04a4\7\31\2\2\u04a0\u04a2\5t;\2\u04a1\u04a3\7\u012f\2\2\u04a2"+
		"\u04a1\3\2\2\2\u04a2\u04a3\3\2\2\2\u04a3\u04a5\3\2\2\2\u04a4\u04a0\3\2"+
		"\2\2\u04a5\u04a6\3\2\2\2\u04a6\u04a4\3\2\2\2\u04a6\u04a7\3\2\2\2\u04a7"+
		"\u04a8\3\2\2\2\u04a8\u04a9\5\32\16\2\u04a9\u055a\3\2\2\2\u04aa\u04b0\7"+
		"\62\2\2\u04ab\u04b1\7z\2\2\u04ac\u04ae\7\6\2\2\u04ad\u04af\7Y\2\2\u04ae"+
		"\u04ad\3\2\2\2\u04ae\u04af\3\2\2\2\u04af\u04b1\3\2\2\2\u04b0\u04ab\3\2"+
		"\2\2\u04b0\u04ac\3\2\2\2\u04b1\u04b2\3\2\2\2\u04b2\u04b3\7P\2\2\u04b3"+
		"\u04b4\7,\2\2\u04b4\u04b5\7\u0098\2\2\u04b5\u04ba\7\u00fe\2\2\u04b6\u04b8"+
		"\5t;\2\u04b7\u04b9\7\u012f\2\2\u04b8\u04b7\3\2\2\2\u04b8\u04b9\3\2\2\2"+
		"\u04b9\u04bb\3\2\2\2\u04ba\u04b6\3\2\2\2\u04bb\u04bc\3\2\2\2\u04bc\u04ba"+
		"\3\2\2\2\u04bc\u04bd\3\2\2\2\u04bd\u04be\3\2\2\2\u04be\u04bf\5\32\16\2"+
		"\u04bf\u055a\3\2\2\2\u04c0\u04c6\7\62\2\2\u04c1\u04c7\7z\2\2\u04c2\u04c4"+
		"\7\6\2\2\u04c3\u04c5\7Y\2\2\u04c4\u04c3\3\2\2\2\u04c4\u04c5\3\2\2\2\u04c5"+
		"\u04c7\3\2\2\2\u04c6\u04c1\3\2\2\2\u04c6\u04c2\3\2\2\2\u04c7\u04c8\3\2"+
		"\2\2\u04c8\u04c9\7P\2\2\u04c9\u04ca\7,\2\2\u04ca\u04cf\7\u00df\2\2\u04cb"+
		"\u04cd\5t;\2\u04cc\u04ce\7\u012f\2\2\u04cd\u04cc\3\2\2\2\u04cd\u04ce\3"+
		"\2\2\2\u04ce\u04d0\3\2\2\2\u04cf\u04cb\3\2\2\2\u04d0\u04d1\3\2\2\2\u04d1"+
		"\u04cf\3\2\2\2\u04d1\u04d2\3\2\2\2\u04d2\u04d3\3\2\2\2\u04d3\u04d4\5\32"+
		"\16\2\u04d4\u055a\3\2\2\2\u04d5\u04db\7\62\2\2\u04d6\u04dc\7(\2\2\u04d7"+
		"\u04d9\7\6\2\2\u04d8\u04da\7Y\2\2\u04d9\u04d8\3\2\2\2\u04d9\u04da\3\2"+
		"\2\2\u04da\u04dc\3\2\2\2\u04db\u04d6\3\2\2\2\u04db\u04d7\3\2\2\2\u04dc"+
		"\u04dd\3\2\2\2\u04dd\u04e0\7P\2\2\u04de\u04e1\5&\24\2\u04df\u04e1\5(\25"+
		"\2\u04e0\u04de\3\2\2\2\u04e0\u04df\3\2\2\2\u04e1\u04e2\3\2\2\2\u04e2\u04e3"+
		"\5\32\16\2\u04e3\u055a\3\2\2\2\u04e4\u04ea\7\62\2\2\u04e5\u04eb\7z\2\2"+
		"\u04e6\u04e8\7\6\2\2\u04e7\u04e9\7Y\2\2\u04e8\u04e7\3\2\2\2\u04e8\u04e9"+
		"\3\2\2\2\u04e9\u04eb\3\2\2\2\u04ea\u04e5\3\2\2\2\u04ea\u04e6\3\2\2\2\u04eb"+
		"\u04ec\3\2\2\2\u04ec\u04ed\7P\2\2\u04ed\u04f2\7\u00b8\2\2\u04ee\u04f0"+
		"\5t;\2\u04ef\u04f1\7\u012f\2\2\u04f0\u04ef\3\2\2\2\u04f0\u04f1\3\2\2\2"+
		"\u04f1\u04f3\3\2\2\2\u04f2\u04ee\3\2\2\2\u04f3\u04f4\3\2\2\2\u04f4\u04f2"+
		"\3\2\2\2\u04f4\u04f5\3\2\2\2\u04f5\u04f6\3\2\2\2\u04f6\u04f7\5\32\16\2"+
		"\u04f7\u055a\3\2\2\2\u04f8\u0505\7\62\2\2\u04f9\u04fb\t\n\2\2\u04fa\u04fc"+
		"\7\u012f\2\2\u04fb\u04fa\3\2\2\2\u04fb\u04fc\3\2\2\2\u04fc\u04fe\3\2\2"+
		"\2\u04fd\u04f9\3\2\2\2\u04fe\u04ff\3\2\2\2\u04ff\u04fd\3\2\2\2\u04ff\u0500"+
		"\3\2\2\2\u0500\u0506\3\2\2\2\u0501\u0503\7\6\2\2\u0502\u0504\7Y\2\2\u0503"+
		"\u0502\3\2\2\2\u0503\u0504\3\2\2\2\u0504\u0506\3\2\2\2\u0505\u04fd\3\2"+
		"\2\2\u0505\u0501\3\2\2\2\u0506\u0507\3\2\2\2\u0507\u0508\7P\2\2\u0508"+
		"\u0509\7\u00b9\2\2\u0509\u050e\7\u00cc\2\2\u050a\u050c\5t;\2\u050b\u050d"+
		"\7\u012f\2\2\u050c\u050b\3\2\2\2\u050c\u050d\3\2\2\2\u050d\u050f\3\2\2"+
		"\2\u050e\u050a\3\2\2\2\u050f\u0510\3\2\2\2\u0510\u050e\3\2\2\2\u0510\u0511"+
		"\3\2\2\2\u0511\u0512\3\2\2\2\u0512\u0513\5\32\16\2\u0513\u055a\3\2\2\2"+
		"\u0514\u0521\7\62\2\2\u0515\u0517\t\b\2\2\u0516\u0518\7\u012f\2\2\u0517"+
		"\u0516\3\2\2\2\u0517\u0518\3\2\2\2\u0518\u051a\3\2\2\2\u0519\u0515\3\2"+
		"\2\2\u051a\u051b\3\2\2\2\u051b\u0519\3\2\2\2\u051b\u051c\3\2\2\2\u051c"+
		"\u0522\3\2\2\2\u051d\u051f\7\6\2\2\u051e\u0520\7Y\2\2\u051f\u051e\3\2"+
		"\2\2\u051f\u0520\3\2\2\2\u0520\u0522\3\2\2\2\u0521\u0519\3\2\2\2\u0521"+
		"\u051d\3\2\2\2\u0522\u0523\3\2\2\2\u0523\u0524\7P\2\2\u0524\u0529\7f\2"+
		"\2\u0525\u0527\5t;\2\u0526\u0528\7\u012f\2\2\u0527\u0526\3\2\2\2\u0527"+
		"\u0528\3\2\2\2\u0528\u052a\3\2\2\2\u0529\u0525\3\2\2\2\u052a\u052b\3\2"+
		"\2\2\u052b\u0529\3\2\2\2\u052b\u052c\3\2\2\2\u052c\u052d\3\2\2\2\u052d"+
		"\u052e\5\32\16\2\u052e\u055a\3\2\2\2\u052f\u0535\7\62\2\2\u0530\u0536"+
		"\7\27\2\2\u0531\u0533\7\6\2\2\u0532\u0534\7Y\2\2\u0533\u0532\3\2\2\2\u0533"+
		"\u0534\3\2\2\2\u0534\u0536\3\2\2\2\u0535\u0530\3\2\2\2\u0535\u0531\3\2"+
		"\2\2\u0536\u0537\3\2\2\2\u0537\u0538\7P\2\2\u0538\u053d\7\u00ea\2\2\u0539"+
		"\u053b\5t;\2\u053a\u053c\7\u012f\2\2\u053b\u053a\3\2\2\2\u053b\u053c\3"+
		"\2\2\2\u053c\u053e\3\2\2\2\u053d\u0539\3\2\2\2\u053e\u053f\3\2\2\2\u053f"+
		"\u053d\3\2\2\2\u053f\u0540\3\2\2\2\u0540\u0541\3\2\2\2\u0541\u0542\5\32"+
		"\16\2\u0542\u0547\7\62\2\2\u0543\u0545\5t;\2\u0544\u0546\7\u012f\2\2\u0545"+
		"\u0544\3\2\2\2\u0545\u0546\3\2\2\2\u0546\u0548\3\2\2\2\u0547\u0543\3\2"+
		"\2\2\u0548\u0549\3\2\2\2\u0549\u0547\3\2\2\2\u0549\u054a\3\2\2\2\u054a"+
		"\u054b\3\2\2\2\u054b\u0550\7\u00f2\2\2\u054c\u054e\5t;\2\u054d\u054f\7"+
		"\u012f\2\2\u054e\u054d\3\2\2\2\u054e\u054f\3\2\2\2\u054f\u0551\3\2\2\2"+
		"\u0550\u054c\3\2\2\2\u0551\u0552\3\2\2\2\u0552\u0550\3\2\2\2\u0552\u0553"+
		"\3\2\2\2\u0553\u0557\3\2\2\2\u0554\u0555\7\u0080\2\2\u0555\u0556\7\u0082"+
		"\2\2\u0556\u0558\7\u00cd\2\2\u0557\u0554\3\2\2\2\u0557\u0558\3\2\2\2\u0558"+
		"\u055a\3\2\2\2\u0559\u0414\3\2\2\2\u0559\u043c\3\2\2\2\u0559\u0466\3\2"+
		"\2\2\u0559\u048f\3\2\2\2\u0559\u04aa\3\2\2\2\u0559\u04c0\3\2\2\2\u0559"+
		"\u04d5\3\2\2\2\u0559\u04e4\3\2\2\2\u0559\u04f8\3\2\2\2\u0559\u0514\3\2"+
		"\2\2\u0559\u052f\3\2\2\2\u055a\31\3\2\2\2\u055b\u0566\7\u00f2\2\2\u055c"+
		"\u055e\7\63\2\2\u055d\u055c\3\2\2\2\u055d\u055e\3\2\2\2\u055e\u0561\3"+
		"\2\2\2\u055f\u0562\5t;\2\u0560\u0562\7\u00d5\2\2\u0561\u055f\3\2\2\2\u0561"+
		"\u0560\3\2\2\2\u0562\u0564\3\2\2\2\u0563\u0565\7\u012f\2\2\u0564\u0563"+
		"\3\2\2\2\u0564\u0565\3\2\2\2\u0565\u0567\3\2\2\2\u0566\u055d\3\2\2\2\u0567"+
		"\u0568\3\2\2\2\u0568\u0566\3\2\2\2\u0568\u0569\3\2\2\2\u0569\u056d\3\2"+
		"\2\2\u056a\u056b\7\u0080\2\2\u056b\u056c\7\62\2\2\u056c\u056e\7\u00cd"+
		"\2\2\u056d\u056a\3\2\2\2\u056d\u056e\3\2\2\2\u056e\33\3\2\2\2\u056f\u0570"+
		"\7\u008f\2\2\u0570\u05e7\7P\2\2\u0571\u0572\7\3\2\2\u0572\u0573\5\u0170"+
		"\u00b9\2\u0573\u057a\7\u0136\2\2\u0574\u0576\5\u0086D\2\u0575\u0577\7"+
		"\u012f\2\2\u0576\u0575\3\2\2\2\u0576\u0577\3\2\2\2\u0577\u0579\3\2\2\2"+
		"\u0578\u0574\3\2\2\2\u0579\u057c\3\2\2\2\u057a\u0578\3\2\2\2\u057a\u057b"+
		"\3\2\2\2\u057b\u057d\3\2\2\2\u057c\u057a\3\2\2\2\u057d\u057e\7\u0137\2"+
		"\2\u057e\u05e8\3\2\2\2\u057f\u0580\7\20\2\2\u0580\u0581\7\u0136\2\2\u0581"+
		"\u0582\5\u0086D\2\u0582\u0583\7\5\2\2\u0583\u0584\5\u0086D\2\u0584\u0585"+
		"\7\u0137\2\2\u0585\u05e8\3\2\2\2\u0586\u0587\7\22\2\2\u0587\u05e8\5\u0170"+
		"\u00b9\2\u0588\u0589\7\u008e\2\2\u0589\u05e8\5\u0170\u00b9\2\u058a\u058b"+
		"\7\24\2\2\u058b\u058c\5\u0170\u00b9\2\u058c\u058d\7P\2\2\u058d\u058e\5"+
		"\u0170\u00b9\2\u058e\u05e8\3\2\2\2\u058f\u0590\7\26\2\2\u0590\u05e8\5"+
		"\u0170\u00b9\2\u0591\u0592\7\31\2\2\u0592\u05e8\5\u0170\u00b9\2\u0593"+
		"\u0594\7!\2\2\u0594\u05e8\5\u0170\u00b9\2\u0595\u0596\7)\2\2\u0596\u05e8"+
		"\5\u0170\u00b9\2\u0597\u0598\7,\2\2\u0598\u0599\7\u0098\2\2\u0599\u059a"+
		"\7\u00fe\2\2\u059a\u05e8\5\u0170\u00b9\2\u059b\u059c\7,\2\2\u059c\u059d"+
		"\7o\2\2\u059d\u05e8\5\u0170\u00b9\2\u059e\u05e8\5&\24\2\u059f\u05a0\7"+
		"\u00ae\2\2\u05a0\u05e8\5\u0170\u00b9\2\u05a1\u05a2\7\u00b9\2\2\u05a2\u05a3"+
		"\7\u00cc\2\2\u05a3\u05e8\5t;\2\u05a4\u05a5\7S\2\2\u05a5\u05a6\5\u0170"+
		"\u00b9\2\u05a6\u05a7\7\u0136\2\2\u05a7\u05a8\5\u0086D\2\u05a8\u05a9\7"+
		"\u012f\2\2\u05a9\u05aa\5\u0086D\2\u05aa\u05ab\7\u0137\2\2\u05ab\u05e8"+
		"\3\2\2\2\u05ac\u05ad\7S\2\2\u05ad\u05ae\7\u0088\2\2\u05ae\u05af\5\u0170"+
		"\u00b9\2\u05af\u05b0\7{\2\2\u05b0\u05b1\5t;\2\u05b1\u05e8\3\2\2\2\u05b2"+
		"\u05b3\7S\2\2\u05b3\u05b4\7\u00a6\2\2\u05b4\u05b5\5\u0170\u00b9\2\u05b5"+
		"\u05b6\7{\2\2\u05b6\u05b7\5t;\2\u05b7\u05e8\3\2\2\2\u05b8\u05ba\7[\2\2"+
		"\u05b9\u05b8\3\2\2\2\u05b9\u05ba\3\2\2\2\u05ba\u05bb\3\2\2\2\u05bb\u05bc"+
		"\7\u00b8\2\2\u05bc\u05e8\5\u0170\u00b9\2\u05bd\u05be\7\\\2\2\u05be\u05e8"+
		"\5\u0170\u00b9\2\u05bf\u05c0\7e\2\2\u05c0\u05c1\5\u0170\u00b9\2\u05c1"+
		"\u05c2\7P\2\2\u05c2\u05c3\5\u0170\u00b9\2\u05c3\u05e8\3\2\2\2\u05c4\u05c5"+
		"\7f\2\2\u05c5\u05e8\5\u0170\u00b9\2\u05c6\u05c7\7g\2\2\u05c7\u05e8\5\u0170"+
		"\u00b9\2\u05c8\u05c9\7\u00df\2\2\u05c9\u05e8\5\u0170\u00b9\2\u05ca\u05cb"+
		"\7o\2\2\u05cb\u05e8\5\u0170\u00b9\2\u05cc\u05cd\7\u00ea\2\2\u05cd\u05e8"+
		"\5\u0170\u00b9\2\u05ce\u05cf\7\u011f\2\2\u05cf\u05d0\7\u00dc\2\2\u05d0"+
		"\u05d1\7\u0092\2\2\u05d1\u05e8\5\u0170\u00b9\2\u05d2\u05d3\7\u011f\2\2"+
		"\u05d3\u05d4\7\u00dc\2\2\u05d4\u05d5\7\u009d\2\2\u05d5\u05e8\5\u0170\u00b9"+
		"\2\u05d6\u05d7\7\u011f\2\2\u05d7\u05d8\7\u00dc\2\2\u05d8\u05d9\7\u00d0"+
		"\2\2\u05d9\u05e8\5\u0170\u00b9\2\u05da\u05db\7\u011f\2\2\u05db\u05dc\7"+
		"\u00dc\2\2\u05dc\u05dd\7\u00ec\2\2\u05dd\u05e8\5\u0170\u00b9\2\u05de\u05df"+
		"\7t\2\2\u05df\u05e0\5\u0170\u00b9\2\u05e0\u05e1\7P\2\2\u05e1\u05e2\5\u0170"+
		"\u00b9\2\u05e2\u05e8\3\2\2\2\u05e3\u05e4\7\u00f3\2\2\u05e4\u05e8\5\u0170"+
		"\u00b9\2\u05e5\u05e6\7}\2\2\u05e6\u05e8\5\u0170\u00b9\2\u05e7\u0571\3"+
		"\2\2\2\u05e7\u057f\3\2\2\2\u05e7\u0586\3\2\2\2\u05e7\u0588\3\2\2\2\u05e7"+
		"\u058a\3\2\2\2\u05e7\u058f\3\2\2\2\u05e7\u0591\3\2\2\2\u05e7\u0593\3\2"+
		"\2\2\u05e7\u0595\3\2\2\2\u05e7\u0597\3\2\2\2\u05e7\u059b\3\2\2\2\u05e7"+
		"\u059e\3\2\2\2\u05e7\u059f\3\2\2\2\u05e7\u05a1\3\2\2\2\u05e7\u05a4\3\2"+
		"\2\2\u05e7\u05ac\3\2\2\2\u05e7\u05b2\3\2\2\2\u05e7\u05b9\3\2\2\2\u05e7"+
		"\u05bd\3\2\2\2\u05e7\u05bf\3\2\2\2\u05e7\u05c4\3\2\2\2\u05e7\u05c6\3\2"+
		"\2\2\u05e7\u05c8\3\2\2\2\u05e7\u05ca\3\2\2\2\u05e7\u05cc\3\2\2\2\u05e7"+
		"\u05ce\3\2\2\2\u05e7\u05d2\3\2\2\2\u05e7\u05d6\3\2\2\2\u05e7\u05da\3\2"+
		"\2\2\u05e7\u05de\3\2\2\2\u05e7\u05e3\3\2\2\2\u05e7\u05e5\3\2\2\2\u05e8"+
		"\u05e9\3\2\2\2\u05e9\u05ea\7C\2\2\u05ea\u05eb\7\u0149\2\2\u05eb\35\3\2"+
		"\2\2\u05ec\u05ef\7\27\2\2\u05ed\u05ee\7T\2\2\u05ee\u05f0\7`\2\2\u05ef"+
		"\u05ed\3\2\2\2\u05ef\u05f0\3\2\2\2\u05f0\u05f1\3\2\2\2\u05f1\u05f2\7."+
		"\2\2\u05f2\u05f3\5t;\2\u05f3\u0605\7\u0136\2\2\u05f4\u05f6\5$\23\2\u05f5"+
		"\u05f4\3\2\2\2\u05f5\u05f6\3\2\2\2\u05f6\u05f8\3\2\2\2\u05f7\u05f9\5t"+
		";\2\u05f8\u05f7\3\2\2\2\u05f8\u05f9\3\2\2\2\u05f9\u05fa\3\2\2\2\u05fa"+
		"\u05fe\5\u0086D\2\u05fb\u05ff\7\32\2\2\u05fc\u05fd\7\u012c\2\2\u05fd\u05ff"+
		"\5\u01b8\u00dd\2\u05fe\u05fb\3\2\2\2\u05fe\u05fc\3\2\2\2\u05fe\u05ff\3"+
		"\2\2\2\u05ff\u0601\3\2\2\2\u0600\u0602\7\u012f\2\2\u0601\u0600\3\2\2\2"+
		"\u0601\u0602\3\2\2\2\u0602\u0604\3\2\2\2\u0603\u05f5\3\2\2\2\u0604\u0607"+
		"\3\2\2\2\u0605\u0603\3\2\2\2\u0605\u0606\3\2\2\2\u0606\u0608\3\2\2\2\u0607"+
		"\u0605\3\2\2\2\u0608\u0619\7\u0137\2\2\u0609\u060a\7b\2\2\u060a\u061a"+
		"\5\u0086D\2\u060b\u060c\7b\2\2\u060c\u060d\7o\2\2\u060d\u0613\7\u0136"+
		"\2\2\u060e\u060f\5t;\2\u060f\u0611\5\u0086D\2\u0610\u0612\7\u012f\2\2"+
		"\u0611\u0610\3\2\2\2\u0611\u0612\3\2\2\2\u0612\u0614\3\2\2\2\u0613\u060e"+
		"\3\2\2\2\u0614\u0615\3\2\2\2\u0615\u0613\3\2\2\2\u0615\u0616\3\2\2\2\u0616"+
		"\u0617\3\2\2\2\u0617\u0618\7\u0137\2\2\u0618\u061a\3\2\2\2\u0619\u0609"+
		"\3\2\2\2\u0619\u060b\3\2\2\2\u0619\u061a\3\2\2\2\u061a\u0650\3\2\2\2\u061b"+
		"\u061c\7\u00b8\2\2\u061c\u0651\5t;\2\u061d\u0651\7\u00fd\2\2\u061e\u0651"+
		"\78\2\2\u061f\u0651\7\u00e3\2\2\u0620\u0651\7\u00fb\2\2\u0621\u0622\7"+
		"\u0087\2\2\u0622\u0623\7P\2\2\u0623\u0624\7M\2\2\u0624\u0651\7\u00b1\2"+
		"\2\u0625\u0626\7b\2\2\u0626\u0627\7M\2\2\u0627\u0628\7P\2\2\u0628\u0629"+
		"\7M\2\2\u0629\u0651\7\u00b1\2\2\u062a\u0651\7m\2\2\u062b\u062d\7\u00a4"+
		"\2\2\u062c\u062b\3\2\2\2\u062c\u062d\3\2\2\2\u062d\u062e\3\2\2\2\u062e"+
		"\u062f\7\u00de\2\2\u062f\u0651\7B\2\2\u0630\u0632\7\u00a4\2\2\u0631\u0630"+
		"\3\2\2\2\u0631\u0632\3\2\2\2\u0632\u0633\3\2\2\2\u0633\u0634\7\u00de\2"+
		"\2\u0634\u0651\7\u009c\2\2\u0635\u0636\7\u0093\2\2\u0636\u0651\7\u0144"+
		"\2\2\u0637\u0638\7^\2\2\u0638\u0651\7\u0144\2\2\u0639\u063a\7\u00e0\2"+
		"\2\u063a\u0641\5t;\2\u063b\u063c\7\u00f2\2\2\u063c\u0642\5t;\2\u063d\u063e"+
		"\7\u012c\2\2\u063e\u0642\5t;\2\u063f\u0640\7\60\2\2\u0640\u0642\7\u0096"+
		"\2\2\u0641\u063b\3\2\2\2\u0641\u063d\3\2\2\2\u0641\u063f\3\2\2\2\u0642"+
		"\u0647\3\2\2\2\u0643\u0644\7\u012f\2\2\u0644\u0646\5t;\2\u0645\u0643\3"+
		"\2\2\2\u0646\u0649\3\2\2\2\u0647\u0645\3\2\2\2\u0647\u0648\3\2\2\2\u0648"+
		"\u0651\3\2\2\2\u0649\u0647\3\2\2\2\u064a\u064b\7\5\2\2\u064b\u0651\5 "+
		"\21\2\u064c\u064d\7\5\2\2\u064d\u064e\7\u0149\2\2\u064e\u064f\7\u012f"+
		"\2\2\u064f\u0651\7\u0149\2\2\u0650\u061b\3\2\2\2\u0650\u061d\3\2\2\2\u0650"+
		"\u061e\3\2\2\2\u0650\u061f\3\2\2\2\u0650\u0620\3\2\2\2\u0650\u0621\3\2"+
		"\2\2\u0650\u0625\3\2\2\2\u0650\u062a\3\2\2\2\u0650\u062c\3\2\2\2\u0650"+
		"\u0631\3\2\2\2\u0650\u0635\3\2\2\2\u0650\u0637\3\2\2\2\u0650\u0639\3\2"+
		"\2\2\u0650\u064a\3\2\2\2\u0650\u064c\3\2\2\2\u0651\u0652\3\2\2\2\u0652"+
		"\u0650\3\2\2\2\u0652\u0653\3\2\2\2\u0653\u0660\3\2\2\2\u0654\u0655\7\u0080"+
		"\2\2\u0655\u065a\7\u0136\2\2\u0656\u0658\5\"\22\2\u0657\u0659\7\u012f"+
		"\2\2\u0658\u0657\3\2\2\2\u0658\u0659\3\2\2\2\u0659\u065b\3\2\2\2\u065a"+
		"\u0656\3\2\2\2\u065b\u065c\3\2\2\2\u065c\u065a\3\2\2\2\u065c\u065d\3\2"+
		"\2\2\u065d\u065e\3\2\2\2\u065e\u065f\7\u0137\2\2\u065f\u0661\3\2\2\2\u0660"+
		"\u0654\3\2\2\2\u0660\u0661\3\2\2\2\u0661\37\3\2\2\2\u0662\u0666\7\u0143"+
		"\2\2\u0663\u0665\n\13\2\2\u0664\u0663\3\2\2\2\u0665\u0668\3\2\2\2\u0666"+
		"\u0664\3\2\2\2\u0666\u0667\3\2\2\2\u0667\u0669\3\2\2\2\u0668\u0666\3\2"+
		"\2\2\u0669\u066a\7\u0143\2\2\u066a!\3\2\2\2\u066b\u066c\t\f\2\2\u066c"+
		"#\3\2\2\2\u066d\u066e\t\r\2\2\u066e%\3\2\2\2\u066f\u0670\7.\2\2\u0670"+
		"\u0671\5t;\2\u0671\u067e\7\u0136\2\2\u0672\u0674\5$\23\2\u0673\u0672\3"+
		"\2\2\2\u0673\u0674\3\2\2\2\u0674\u0676\3\2\2\2\u0675\u0677\5t;\2\u0676"+
		"\u0675\3\2\2\2\u0676\u0677\3\2\2\2\u0677\u0678\3\2\2\2\u0678\u067a\5\u00d6"+
		"l\2\u0679\u067b\7\u012f\2\2\u067a\u0679\3\2\2\2\u067a\u067b\3\2\2\2\u067b"+
		"\u067d\3\2\2\2\u067c\u0673\3\2\2\2\u067d\u0680\3\2\2\2\u067e\u067c\3\2"+
		"\2\2\u067e\u067f\3\2\2\2\u067f\u0681\3\2\2\2\u0680\u067e\3\2\2\2\u0681"+
		"\u0682\7\u0137\2\2\u0682\'\3\2\2\2\u0683\u0684\7\6\2\2\u0684\u0685\7/"+
		"\2\2\u0685\u0686\79\2\2\u0686\u068b\7f\2\2\u0687\u0689\5t;\2\u0688\u068a"+
		"\7\u012f\2\2\u0689\u0688\3\2\2\2\u0689\u068a\3\2\2\2\u068a\u068c\3\2\2"+
		"\2\u068b\u0687\3\2\2\2\u068c\u068d\3\2\2\2\u068d\u068b\3\2\2\2\u068d\u068e"+
		"\3\2\2\2\u068e)\3\2\2\2\u068f\u0691\7\27\2\2\u0690\u0692\t\16\2\2\u0691"+
		"\u0690\3\2\2\2\u0691\u0692\3\2\2\2\u0692\u0693\3\2\2\2\u0693\u0694\7g"+
		"\2\2\u0694\u06b9\5\u0170\u00b9\2\u0695\u0697\7\u00b0\2\2\u0696\u0698\7"+
		"\u0085\2\2\u0697\u0696\3\2\2\2\u0697\u0698\3\2\2\2\u0698\u0699\3\2\2\2"+
		"\u0699\u06b8\7\u0144\2\2\u069a\u069b\7\u00c5\2\2\u069b\u069f\7\u0144\2"+
		"\2\u069c\u069d\7\u00c9\2\2\u069d\u069f\7\u00c5\2\2\u069e\u069a\3\2\2\2"+
		"\u069e\u069c\3\2\2\2\u069f\u06b8\3\2\2\2\u06a0\u06a1\7\u00c0\2\2\u06a1"+
		"\u06a5\5\u0096L\2\u06a2\u06a3\7\u00c9\2\2\u06a3\u06a5\7\u00c0\2\2\u06a4"+
		"\u06a0\3\2\2\2\u06a4\u06a2\3\2\2\2\u06a5\u06b8\3\2\2\2\u06a6\u06a8\7\u00e4"+
		"\2\2\u06a7\u06a9\7\u0080\2\2\u06a8\u06a7\3\2\2\2\u06a8\u06a9\3\2\2\2\u06a9"+
		"\u06aa\3\2\2\2\u06aa\u06b8\7\u0144\2\2\u06ab\u06ac\7\u0086\2\2\u06ac\u06b8"+
		"\7\u0144\2\2\u06ad\u06af\7\u00c9\2\2\u06ae\u06ad\3\2\2\2\u06ae\u06af\3"+
		"\2\2\2\u06af\u06b0\3\2\2\2\u06b0\u06b8\7\u0097\2\2\u06b1\u06b2\7V\2\2"+
		"\u06b2\u06b5\7\u0085\2\2\u06b3\u06b6\5\u0170\u00b9\2\u06b4\u06b6\7\u00ca"+
		"\2\2\u06b5\u06b3\3\2\2\2\u06b5\u06b4\3\2\2\2\u06b6\u06b8\3\2\2\2\u06b7"+
		"\u0695\3\2\2\2\u06b7\u069e\3\2\2\2\u06b7\u06a4\3\2\2\2\u06b7\u06a6\3\2"+
		"\2\2\u06b7\u06ab\3\2\2\2\u06b7\u06ae\3\2\2\2\u06b7\u06b1\3\2\2\2\u06b8"+
		"\u06bb\3\2\2\2\u06b9\u06b7\3\2\2\2\u06b9\u06ba\3\2\2\2\u06ba+\3\2\2\2"+
		"\u06bb\u06b9\3\2\2\2\u06bc\u06bd\7\27\2\2\u06bd\u06be\7f\2\2\u06be\u06c1"+
		"\5t;\2\u06bf\u06c0\7\13\2\2\u06c0\u06c2\5t;\2\u06c1\u06bf\3\2\2\2\u06c1"+
		"\u06c2\3\2\2\2\u06c2\u06c6\3\2\2\2\u06c3\u06c5\5\2\2\2\u06c4\u06c3\3\2"+
		"\2\2\u06c5\u06c8\3\2\2\2\u06c6\u06c4\3\2\2\2\u06c6\u06c7\3\2\2\2\u06c7"+
		"\u06e5\3\2\2\2\u06c8\u06c6\3\2\2\2\u06c9\u06ca\7\27\2\2\u06ca\u06cb\7"+
		"f\2\2\u06cb\u06cc\7\13\2\2\u06cc\u06d0\5t;\2\u06cd\u06cf\5\2\2\2\u06ce"+
		"\u06cd\3\2\2\2\u06cf\u06d2\3\2\2\2\u06d0\u06ce\3\2\2\2\u06d0\u06d1\3\2"+
		"\2\2\u06d1\u06e5\3\2\2\2\u06d2\u06d0\3\2\2\2\u06d3\u06d4\7\27\2\2\u06d4"+
		"\u06d5\7f\2\2\u06d5\u06d6\7\65\2\2\u06d6\u06d7\7L\2\2\u06d7\u06d8\7\u00a3"+
		"\2\2\u06d8\u06db\5t;\2\u06d9\u06da\7\13\2\2\u06da\u06dc\5t;\2\u06db\u06d9"+
		"\3\2\2\2\u06db\u06dc\3\2\2\2\u06dc\u06e5\3\2\2\2\u06dd\u06de\7\27\2\2"+
		"\u06de\u06df\7f\2\2\u06df\u06e0\7\65\2\2\u06e0\u06e1\7L\2\2\u06e1\u06e2"+
		"\7\u00a3\2\2\u06e2\u06e3\7\13\2\2\u06e3\u06e5\5t;\2\u06e4\u06bc\3\2\2"+
		"\2\u06e4\u06c9\3\2\2\2\u06e4\u06d3\3\2\2\2\u06e4\u06dd\3\2\2\2\u06e5-"+
		"\3\2\2\2\u06e6\u06e9\7\27\2\2\u06e7\u06e8\7T\2\2\u06e8\u06ea\7`\2\2\u06e9"+
		"\u06e7\3\2\2\2\u06e9\u06ea\3\2\2\2\u06ea\u06ec\3\2\2\2\u06eb\u06ed\t\16"+
		"\2\2\u06ec\u06eb\3\2\2\2\u06ec\u06ed\3\2\2\2\u06ed\u06ee\3\2\2\2\u06ee"+
		"\u06ef\7}\2\2\u06ef\u06f6\5\u0170\u00b9\2\u06f0\u06f2\5t;\2\u06f1\u06f3"+
		"\7\u012f\2\2\u06f2\u06f1\3\2\2\2\u06f2\u06f3\3\2\2\2\u06f3\u06f5\3\2\2"+
		"\2\u06f4\u06f0\3\2\2\2\u06f5\u06f8\3\2\2\2\u06f6\u06f4\3\2\2\2\u06f6\u06f7"+
		"\3\2\2\2\u06f7\u0706\3\2\2\2\u06f8\u06f6\3\2\2\2\u06f9\u06fa\7\u0080\2"+
		"\2\u06fa\u0700\7\u0136\2\2\u06fb\u06fe\5t;\2\u06fc\u06fd\7\u012c\2\2\u06fd"+
		"\u06ff\5t;\2\u06fe\u06fc\3\2\2\2\u06fe\u06ff\3\2\2\2\u06ff\u0701\3\2\2"+
		"\2\u0700\u06fb\3\2\2\2\u0701\u0702\3\2\2\2\u0702\u0700\3\2\2\2\u0702\u0703"+
		"\3\2\2\2\u0703\u0704\3\2\2\2\u0704\u0705\7\u0137\2\2\u0705\u0707\3\2\2"+
		"\2\u0706\u06f9\3\2\2\2\u0706\u0707\3\2\2\2\u0707\u0708\3\2\2\2\u0708\u0709"+
		"\7\5\2\2\u0709\u070a\5\u0172\u00ba\2\u070a/\3\2\2\2\u070b\u070c\3\2\2"+
		"\2\u070c\61\3\2\2\2\u070d\u070e\7\27\2\2\u070e\u070f\7\u00a4\2\2\u070f"+
		"\u0710\7o\2\2\u0710\u0711\5\u0170\u00b9\2\u0711\u0712\5H%\2\u0712\u0713"+
		"\7{\2\2\u0713\u0715\5t;\2\u0714\u0716\5N(\2\u0715\u0714\3\2\2\2\u0715"+
		"\u0716\3\2\2\2\u0716\u0718\3\2\2\2\u0717\u0719\5X-\2\u0718\u0717\3\2\2"+
		"\2\u0718\u0719\3\2\2\2\u0719\u071a\3\2\2\2\u071a\u071b\7\u00bd\2\2\u071b"+
		"\u071c\7\u0149\2\2\u071c\u07b0\3\2\2\2\u071d\u071e\7\27\2\2\u071e\u071f"+
		"\7o\2\2\u071f\u0720\5\u0170\u00b9\2\u0720\u0723\5H%\2\u0721\u0722\7{\2"+
		"\2\u0722\u0724\5t;\2\u0723\u0721\3\2\2\2\u0723\u0724\3\2\2\2\u0724\u0726"+
		"\3\2\2\2\u0725\u0727\5N(\2\u0726\u0725\3\2\2\2\u0726\u0727\3\2\2\2\u0727"+
		"\u0729\3\2\2\2\u0728\u072a\5X-\2\u0729\u0728\3\2\2\2\u0729\u072a\3\2\2"+
		"\2\u072a\u072d\3\2\2\2\u072b\u072c\7\5\2\2\u072c\u072e\5\u015c\u00af\2"+
		"\u072d\u072b\3\2\2\2\u072d\u072e\3\2\2\2\u072e\u07b0\3\2\2\2\u072f\u0730"+
		"\7\27\2\2\u0730\u0731\7o\2\2\u0731\u0734\5\u0170\u00b9\2\u0732\u0733\7"+
		"{\2\2\u0733\u0735\5t;\2\u0734\u0732\3\2\2\2\u0734\u0735\3\2\2\2\u0735"+
		"\u0737\3\2\2\2\u0736\u0738\5N(\2\u0737\u0736\3\2\2\2\u0737\u0738\3\2\2"+
		"\2\u0738\u073a\3\2\2\2\u0739\u073b\5X-\2\u073a\u0739\3\2\2\2\u073a\u073b"+
		"\3\2\2\2\u073b\u073c\3\2\2\2\u073c\u073d\7\5\2\2\u073d\u073e\5\u015c\u00af"+
		"\2\u073e\u07b0\3\2\2\2\u073f\u0745\7\27\2\2\u0740\u0742\t\17\2\2\u0741"+
		"\u0740\3\2\2\2\u0741\u0742\3\2\2\2\u0742\u0743\3\2\2\2\u0743\u0746\t\16"+
		"\2\2\u0744\u0746\7\u00f5\2\2\u0745\u0741\3\2\2\2\u0745\u0744\3\2\2\2\u0745"+
		"\u0746\3\2\2\2\u0746\u0747\3\2\2\2\u0747\u074b\7o\2\2\u0748\u0749\7\65"+
		"\2\2\u0749\u074a\7L\2\2\u074a\u074c\7\u00a3\2\2\u074b\u0748\3\2\2\2\u074b"+
		"\u074c\3\2\2\2\u074c\u074d\3\2\2\2\u074d\u074e\5\u0170\u00b9\2\u074e\u076d"+
		"\7\u0136\2\2\u074f\u0750\5t;\2\u0750\u0753\5\u0086D\2\u0751\u0752\7\21"+
		"\2\2\u0752\u0754\5t;\2\u0753\u0751\3\2\2\2\u0753\u0754\3\2\2\2\u0754\u0758"+
		"\3\2\2\2\u0755\u0757\58\35\2\u0756\u0755\3\2\2\2\u0757\u075a\3\2\2\2\u0758"+
		"\u0756\3\2\2\2\u0758\u0759\3\2\2\2\u0759\u0765\3\2\2\2\u075a\u0758\3\2"+
		"\2\2\u075b\u0765\5\66\34\2\u075c\u075d\7H\2\2\u075d\u0761\5t;\2\u075e"+
		"\u0760\5\64\33\2\u075f\u075e\3\2\2\2\u0760\u0763\3\2\2\2\u0761\u075f\3"+
		"\2\2\2\u0761\u0762\3\2\2\2\u0762\u0765\3\2\2\2\u0763\u0761\3\2\2\2\u0764"+
		"\u074f\3\2\2\2\u0764\u075b\3\2\2\2\u0764\u075c\3\2\2\2\u0765\u0767\3\2"+
		"\2\2\u0766\u0768\7\u012f\2\2\u0767\u0766\3\2\2\2\u0767\u0768\3\2\2\2\u0768"+
		"\u076a\3\2\2\2\u0769\u0764\3\2\2\2\u076a\u076b\3\2\2\2\u076b\u0769\3\2"+
		"\2\2\u076b\u076c\3\2\2\2\u076c\u076e\3\2\2\2\u076d\u0769\3\2\2\2\u076d"+
		"\u076e\3\2\2\2\u076e\u076f\3\2\2\2\u076f\u077c\7\u0137\2\2\u0770\u0771"+
		"\7;\2\2\u0771\u0776\7\u0136\2\2\u0772\u0774\5t;\2\u0773\u0775\7\u012f"+
		"\2\2\u0774\u0773\3\2\2\2\u0774\u0775\3\2\2\2\u0775\u0777\3\2\2\2\u0776"+
		"\u0772\3\2\2\2\u0777\u0778\3\2\2\2\u0778\u0776\3\2\2\2\u0778\u0779\3\2"+
		"\2\2\u0779\u077a\3\2\2\2\u077a\u077b\7\u0137\2\2\u077b\u077d\3\2\2\2\u077c"+
		"\u0770\3\2\2\2\u077c\u077d\3\2\2\2\u077d\u077e\3\2\2\2\u077e\u077f\5>"+
		" \2\u077f\u0780\5@!\2\u0780\u0781\5B\"\2\u0781\u07b0\3\2\2\2\u0782\u0788"+
		"\7\27\2\2\u0783\u0785\t\17\2\2\u0784\u0783\3\2\2\2\u0784\u0785\3\2\2\2"+
		"\u0785\u0786\3\2\2\2\u0786\u0789\t\16\2\2\u0787\u0789\7\u00f5\2\2\u0788"+
		"\u0784\3\2\2\2\u0788\u0787\3\2\2\2\u0788\u0789\3\2\2\2\u0789\u078a\3\2"+
		"\2\2\u078a\u078e\7o\2\2\u078b\u078c\7\65\2\2\u078c\u078d\7L\2\2\u078d"+
		"\u078f\7\u00a3\2\2\u078e\u078b\3\2\2\2\u078e\u078f\3\2\2\2\u078f\u0790"+
		"\3\2\2\2\u0790\u0791\5\u0170\u00b9\2\u0791\u0792\7N\2\2\u0792\u07a9\5"+
		"t;\2\u0793\u07a3\7\u0136\2\2\u0794\u0795\5t;\2\u0795\u0796\7\u0080\2\2"+
		"\u0796\u079a\7\u00ce\2\2\u0797\u0799\58\35\2\u0798\u0797\3\2\2\2\u0799"+
		"\u079c\3\2\2\2\u079a\u0798\3\2\2\2\u079a\u079b\3\2\2\2\u079b\u079f\3\2"+
		"\2\2\u079c\u079a\3\2\2\2\u079d\u079f\5\66\34\2\u079e\u0794\3\2\2\2\u079e"+
		"\u079d\3\2\2\2\u079f\u07a1\3\2\2\2\u07a0\u07a2\7\u012f\2\2\u07a1\u07a0"+
		"\3\2\2\2\u07a1\u07a2\3\2\2\2\u07a2\u07a4\3\2\2\2\u07a3\u079e\3\2\2\2\u07a4"+
		"\u07a5\3\2\2\2\u07a5\u07a3\3\2\2\2\u07a5\u07a6\3\2\2\2\u07a6\u07a7\3\2"+
		"\2\2\u07a7\u07a8\7\u0137\2\2\u07a8\u07aa\3\2\2\2\u07a9\u0793\3\2\2\2\u07a9"+
		"\u07aa\3\2\2\2\u07aa\u07ab\3\2\2\2\u07ab\u07ac\5> \2\u07ac\u07ad\5@!\2"+
		"\u07ad\u07ae\5B\"\2\u07ae\u07b0\3\2\2\2\u07af\u070d\3\2\2\2\u07af\u071d"+
		"\3\2\2\2\u07af\u072f\3\2\2\2\u07af\u073f\3\2\2\2\u07af\u0782\3\2\2\2\u07b0"+
		"\63\3\2\2\2\u07b1\u07b2\t\20\2\2\u07b2\u07b3\t\21\2\2\u07b3\65\3\2\2\2"+
		"\u07b4\u07b5\7\24\2\2\u07b5\u07b7\5t;\2\u07b6\u07b4\3\2\2\2\u07b6\u07b7"+
		"\3\2\2\2\u07b7\u081a\3\2\2\2\u07b8\u081b\5:\36\2\u07b9\u07ba\7x\2\2\u07ba"+
		"\u07bf\7\u0136\2\2\u07bb\u07bd\5t;\2\u07bc\u07be\7\u012f\2\2\u07bd\u07bc"+
		"\3\2\2\2\u07bd\u07be\3\2\2\2\u07be\u07c0\3\2\2\2\u07bf\u07bb\3\2\2\2\u07c0"+
		"\u07c1\3\2\2\2\u07c1\u07bf\3\2\2\2\u07c1\u07c2\3\2\2\2\u07c2\u07c3\3\2"+
		"\2\2\u07c3\u07c4\7\u0137\2\2\u07c4\u07c5\5F$\2\u07c5\u081b\3\2\2\2\u07c6"+
		"\u07c7\7X\2\2\u07c7\u07c8\7E\2\2\u07c8\u07cd\7\u0136\2\2\u07c9\u07cb\5"+
		"t;\2\u07ca\u07cc\7\u012f\2\2\u07cb\u07ca\3\2\2\2\u07cb\u07cc\3\2\2\2\u07cc"+
		"\u07ce\3\2\2\2\u07cd\u07c9\3\2\2\2\u07ce\u07cf\3\2\2\2\u07cf\u07cd\3\2"+
		"\2\2\u07cf\u07d0\3\2\2\2\u07d0\u07d1\3\2\2\2\u07d1\u07d2\7\u0137\2\2\u07d2"+
		"\u07d3\5F$\2\u07d3\u081b\3\2\2\2\u07d4\u07d7\7&\2\2\u07d5\u07d6\7{\2\2"+
		"\u07d6\u07d8\5t;\2\u07d7\u07d5\3\2\2\2\u07d7\u07d8\3\2\2\2\u07d8\u07d9"+
		"\3\2\2\2\u07d9\u07da\7\u0136\2\2\u07da\u07db\5t;\2\u07db\u07e0\7\u0080"+
		"\2\2\u07dc\u07de\5t;\2\u07dd\u07df\7\u012f\2\2\u07de\u07dd\3\2\2\2\u07de"+
		"\u07df\3\2\2\2\u07df\u07e1\3\2\2\2\u07e0\u07dc\3\2\2\2\u07e1\u07e2\3\2"+
		"\2\2\u07e2\u07e0\3\2\2\2\u07e2\u07e3\3\2\2\2\u07e3\u07e4\3\2\2\2\u07e4"+
		"\u07e5\7\u0137\2\2\u07e5\u07eb\5F$\2\u07e6\u07e7\7\177\2\2\u07e7\u07e8"+
		"\7\u0136\2\2\u07e8\u07e9\5t;\2\u07e9\u07ea\7\u0137\2\2\u07ea\u07ec\3\2"+
		"\2\2\u07eb\u07e6\3\2\2\2\u07eb\u07ec\3\2\2\2\u07ec\u081b\3\2\2\2\u07ed"+
		"\u07ee\7,\2\2\u07ee\u07ef\7E\2\2\u07ef\u07f4\7\u0136\2\2\u07f0\u07f2\5"+
		"t;\2\u07f1\u07f3\7\u012f\2\2\u07f2\u07f1\3\2\2\2\u07f2\u07f3\3\2\2\2\u07f3"+
		"\u07f5\3\2\2\2\u07f4\u07f0\3\2\2\2\u07f5\u07f6\3\2\2\2\u07f6\u07f4\3\2"+
		"\2\2\u07f6\u07f7\3\2\2\2\u07f7\u07f8\3\2\2\2\u07f8\u07f9\7\u0137\2\2\u07f9"+
		"\u07fa\7_\2\2\u07fa\u0806\5t;\2\u07fb\u0800\7\u0136\2\2\u07fc\u07fe\5"+
		"t;\2\u07fd\u07ff\7\u012f\2\2\u07fe\u07fd\3\2\2\2\u07fe\u07ff\3\2\2\2\u07ff"+
		"\u0801\3\2\2\2\u0800\u07fc\3\2\2\2\u0801\u0802\3\2\2\2\u0802\u0800\3\2"+
		"\2\2\u0802\u0803\3\2\2\2\u0803\u0804\3\2\2\2\u0804\u0805\7\u0137\2\2\u0805"+
		"\u0807\3\2\2\2\u0806\u07fb\3\2\2\2\u0806\u0807\3\2\2\2\u0807\u080e\3\2"+
		"\2\2\u0808\u0809\7\u00be\2\2\u0809\u080f\7-\2\2\u080a\u080b\7\u00be\2"+
		"\2\u080b\u080f\7\u00d1\2\2\u080c\u080d\7\u00be\2\2\u080d\u080f\7\u00e2"+
		"\2\2\u080e\u0808\3\2\2\2\u080e\u080a\3\2\2\2\u080e\u080c\3\2\2\2\u080e"+
		"\u080f\3\2\2\2\u080f\u0813\3\2\2\2\u0810\u0811\7P\2\2\u0811\u0812\7\36"+
		"\2\2\u0812\u0814\5D#\2\u0813\u0810\3\2\2\2\u0813\u0814\3\2\2\2\u0814\u0818"+
		"\3\2\2\2\u0815\u0816\7P\2\2\u0816\u0817\7y\2\2\u0817\u0819\5D#\2\u0818"+
		"\u0815\3\2\2\2\u0818\u0819\3\2\2\2\u0819\u081b\3\2\2\2\u081a\u07b8\3\2"+
		"\2\2\u081a\u07b9\3\2\2\2\u081a\u07c6\3\2\2\2\u081a\u07d4\3\2\2\2\u081a"+
		"\u07ed\3\2\2\2\u081b\u081f\3\2\2\2\u081c\u0820\7\34\2\2\u081d\u081e\7"+
		"L\2\2\u081e\u0820\7\34\2\2\u081f\u081c\3\2\2\2\u081f\u081d\3\2\2\2\u081f"+
		"\u0820\3\2\2\2\u0820\u0825\3\2\2\2\u0821\u0822\7<\2\2\u0822\u0826\7\35"+
		"\2\2\u0823\u0824\7<\2\2\u0824\u0826\7\67\2\2\u0825\u0821\3\2\2\2\u0825"+
		"\u0823\3\2\2\2\u0825\u0826\3\2\2\2\u0826\67\3\2\2\2\u0827\u0828\7\24\2"+
		"\2\u0828\u082a\5t;\2\u0829\u0827\3\2\2\2\u0829\u082a\3\2\2\2\u082a\u084b"+
		"\3\2\2\2\u082b\u082c\7L\2\2\u082c\u084c\7M\2\2\u082d\u084c\7M\2\2\u082e"+
		"\u084c\5:\36\2\u082f\u0830\7\32\2\2\u0830\u084c\5\u01b8\u00dd\2\u0831"+
		"\u0832\7x\2\2\u0832\u084c\5F$\2\u0833\u0834\7X\2\2\u0834\u0835\7E\2\2"+
		"\u0835\u084c\5F$\2\u0836\u0837\7_\2\2\u0837\u0838\5\u0170\u00b9\2\u0838"+
		"\u083f\5t;\2\u0839\u083a\7\u00be\2\2\u083a\u0840\7-\2\2\u083b\u083c\7"+
		"\u00be\2\2\u083c\u0840\7\u00d1\2\2\u083d\u083e\7\u00be\2\2\u083e\u0840"+
		"\7\u00e2\2\2\u083f\u0839\3\2\2\2\u083f\u083b\3\2\2\2\u083f\u083d\3\2\2"+
		"\2\u083f\u0840\3\2\2\2\u0840\u0844\3\2\2\2\u0841\u0842\7P\2\2\u0842\u0843"+
		"\7\36\2\2\u0843\u0845\5D#\2\u0844\u0841\3\2\2\2\u0844\u0845\3\2\2\2\u0845"+
		"\u0849\3\2\2\2\u0846\u0847\7P\2\2\u0847\u0848\7y\2\2\u0848\u084a\5D#\2"+
		"\u0849\u0846\3\2\2\2\u0849\u084a\3\2\2\2\u084a\u084c\3\2\2\2\u084b\u082b"+
		"\3\2\2\2\u084b\u082d\3\2\2\2\u084b\u082e\3\2\2\2\u084b\u082f\3\2\2\2\u084b"+
		"\u0831\3\2\2\2\u084b\u0833\3\2\2\2\u084b\u0836\3\2\2\2\u084c\u0850\3\2"+
		"\2\2\u084d\u0851\7\34\2\2\u084e\u084f\7L\2\2\u084f\u0851\7\34\2\2\u0850"+
		"\u084d\3\2\2\2\u0850\u084e\3\2\2\2\u0850\u0851\3\2\2";
	private static final String _serializedATNSegment1 =
		"\2\u0851\u0856\3\2\2\2\u0852\u0853\7<\2\2\u0853\u0857\7\35\2\2\u0854\u0855"+
		"\7<\2\2\u0855\u0857\7\67\2\2\u0856\u0852\3\2\2\2\u0856\u0854\3\2\2\2\u0856"+
		"\u0857\3\2\2\2\u08579\3\2\2\2\u0858\u0859\7\u008b\2\2\u0859\u085a\7\u0136"+
		"\2\2\u085a\u085b\5\u0100\u0081\2\u085b\u085c\7\u0137\2\2\u085c;\3\2\2"+
		"\2\u085d\u085e\7\u0080\2\2\u085e\u0867\7\u0136\2\2\u085f\u0862\5t;\2\u0860"+
		"\u0861\7\u012c\2\2\u0861\u0863\5t;\2\u0862\u0860\3\2\2\2\u0862\u0863\3"+
		"\2\2\2\u0863\u0865\3\2\2\2\u0864\u0866\7\u012f\2\2\u0865\u0864\3\2\2\2"+
		"\u0865\u0866\3\2\2\2\u0866\u0868\3\2\2\2\u0867\u085f\3\2\2\2\u0868\u0869"+
		"\3\2\2\2\u0869\u0867\3\2\2\2\u0869\u086a\3\2\2\2\u086a\u086b\3\2\2\2\u086b"+
		"\u086c\7\u0137\2\2\u086c=\3\2\2\2\u086d\u0873\5<\37\2\u086e\u086f\7\u0080"+
		"\2\2\u086f\u0873\7O\2\2\u0870\u0871\7\u0081\2\2\u0871\u0873\7O\2\2\u0872"+
		"\u086d\3\2\2\2\u0872\u086e\3\2\2\2\u0872\u0870\3\2\2\2\u0872\u0873\3\2"+
		"\2\2\u0873?\3\2\2\2\u0874\u0875\7P\2\2\u0875\u087b\7\u0091\2\2\u0876\u0877"+
		"\7W\2\2\u0877\u087c\7^\2\2\u0878\u0879\7\36\2\2\u0879\u087c\7^\2\2\u087a"+
		"\u087c\7\u00a0\2\2\u087b\u0876\3\2\2\2\u087b\u0878\3\2\2\2\u087b\u087a"+
		"\3\2\2\2\u087c\u087e\3\2\2\2\u087d\u0874\3\2\2\2\u087d\u087e\3\2\2\2\u087e"+
		"A\3\2\2\2\u087f\u0880\7\u00ea\2\2\u0880\u0882\5t;\2\u0881\u087f\3\2\2"+
		"\2\u0881\u0882\3\2\2\2\u0882C\3\2\2\2\u0883\u088a\7a\2\2\u0884\u088a\7"+
		"\17\2\2\u0885\u0886\7\u00e0\2\2\u0886\u088a\7M\2\2\u0887\u0888\7\u00e0"+
		"\2\2\u0888\u088a\7\32\2\2\u0889\u0883\3\2\2\2\u0889\u0884\3\2\2\2\u0889"+
		"\u0885\3\2\2\2\u0889\u0887\3\2\2\2\u088aE\3\2\2\2\u088b\u088d\5<\37\2"+
		"\u088c\u088b\3\2\2\2\u088c\u088d\3\2\2\2\u088d\u0892\3\2\2\2\u088e\u088f"+
		"\7{\2\2\u088f\u0890\7\u00ae\2\2\u0890\u0891\7\u00ea\2\2\u0891\u0893\5"+
		"t;\2\u0892\u088e\3\2\2\2\u0892\u0893\3\2\2\2\u0893G\3\2\2\2\u0894\u0895"+
		"\7\u0136\2\2\u0895\u089a\5J&\2\u0896\u0897\7\u012f\2\2\u0897\u0899\5J"+
		"&\2\u0898\u0896\3\2\2\2\u0899\u089c\3\2\2\2\u089a\u0898\3\2\2\2\u089a"+
		"\u089b\3\2\2\2\u089b\u089d\3\2\2\2\u089c\u089a\3\2\2\2\u089d\u089e\7\u0137"+
		"\2\2\u089eI\3\2\2\2\u089f\u08a0\5t;\2\u08a0\u08a1\5L\'\2\u08a1K\3\2\2"+
		"\2\u08a2\u08a3\5\u0086D\2\u08a3M\3\2\2\2\u08a4\u08a5\7\u0080\2\2\u08a5"+
		"\u08a6\7\u0136\2\2\u08a6\u08ab\5P)\2\u08a7\u08a8\7\u012f\2\2\u08a8\u08aa"+
		"\5P)\2\u08a9\u08a7\3\2\2\2\u08aa\u08ad\3\2\2\2\u08ab\u08a9\3\2\2\2\u08ab"+
		"\u08ac\3\2\2\2\u08ac\u08ae\3\2\2\2\u08ad\u08ab\3\2\2\2\u08ae\u08af\7\u0137"+
		"\2\2\u08afO\3\2\2\2\u08b0\u08b1\7\u0149\2\2\u08b1\u08b2\7\u012c\2\2\u08b2"+
		"\u08b3\5\u00dan\2\u08b3Q\3\2\2\2\u08b4\u08b5\7{\2\2\u08b5\u08b6\5t;\2"+
		"\u08b6S\3\2\2\2\u08b7\u08b8\7\u00ea\2\2\u08b8\u08b9\5V,\2\u08b9U\3\2\2"+
		"\2\u08ba\u08bb\5t;\2\u08bbW\3\2\2\2\u08bc\u08c1\5Z.\2\u08bd\u08c1\5`\61"+
		"\2\u08be\u08c1\5h\65\2\u08bf\u08c1\5n8\2\u08c0\u08bc\3\2\2\2\u08c0\u08bd"+
		"\3\2\2\2\u08c0\u08be\3\2\2\2\u08c0\u08bf\3\2\2\2\u08c1Y\3\2\2\2\u08c2"+
		"\u08c3\7\u00d2\2\2\u08c3\u08c4\7\u0085\2\2\u08c4\u08c5\7\u00d8\2\2\u08c5"+
		"\u08c6\7\u0136\2\2\u08c6\u08c7\5\u0182\u00c2\2\u08c7\u08c8\7\u0137\2\2"+
		"\u08c8\u08c9\7\u0136\2\2\u08c9\u08ca\5\\/\2\u08ca\u08cb\7\u0137\2\2\u08cb"+
		"[\3\2\2\2\u08cc\u08d1\5^\60\2\u08cd\u08ce\7\u012f\2\2\u08ce\u08d0\5^\60"+
		"\2\u08cf\u08cd\3\2\2\2\u08d0\u08d3\3\2\2\2\u08d1\u08cf\3\2\2\2\u08d1\u08d2"+
		"\3\2\2\2\u08d2]\3\2\2\2\u08d3\u08d1\3\2\2\2\u08d4\u08d5\7\u00d2\2\2\u08d5"+
		"\u08d6\5p9\2\u08d6\u08d7\7\u00f6\2\2\u08d7\u08d8\7\u00bb\2\2\u08d8\u08e4"+
		"\7\u00ed\2\2\u08d9\u08da\7\u0136\2\2\u08da\u08db\5\u00d6l\2\u08db\u08dc"+
		"\7\u0137\2\2\u08dc\u08e5\3\2\2\2\u08dd\u08df\7\u0136\2\2\u08de\u08dd\3"+
		"\2\2\2\u08de\u08df\3\2\2\2\u08df\u08e0\3\2\2\2\u08e0\u08e2\7\u00c0\2\2"+
		"\u08e1\u08e3\7\u0137\2\2\u08e2\u08e1\3\2\2\2\u08e2\u08e3\3\2\2\2\u08e3"+
		"\u08e5\3\2\2\2\u08e4\u08d9\3\2\2\2\u08e4\u08de\3\2\2\2\u08e5_\3\2\2\2"+
		"\u08e6\u08e7\7\u00d2\2\2\u08e7\u08e8\7\u0085\2\2\u08e8\u08e9\7\u00ac\2"+
		"\2\u08e9\u08ea\7\u0136\2\2\u08ea\u08eb\5\u0182\u00c2\2\u08eb\u08f1\7\u0137"+
		"\2\2\u08ec\u08ed\7\u0136\2\2\u08ed\u08ee\5b\62\2\u08ee\u08ef\7\u0137\2"+
		"\2\u08ef\u08f2\3\2\2\2\u08f0\u08f2\5f\64\2\u08f1\u08ec\3\2\2\2\u08f1\u08f0"+
		"\3\2\2\2\u08f2a\3\2\2\2\u08f3\u08f8\5d\63\2\u08f4\u08f5\7\u012f\2\2\u08f5"+
		"\u08f7\5d\63\2\u08f6\u08f4\3\2\2\2\u08f7\u08fa\3\2\2\2\u08f8\u08f6\3\2"+
		"\2\2\u08f8\u08f9\3\2\2\2\u08f9c\3\2\2\2\u08fa\u08f8\3\2\2\2\u08fb\u08fc"+
		"\7\u00d2\2\2\u08fc\u08fd\5p9\2\u08fde\3\2\2\2\u08fe\u08ff\7\u00d3\2\2"+
		"\u08ff\u0900\5\u00dan\2\u0900g\3\2\2\2\u0901\u0902\7\u00d2\2\2\u0902\u0903"+
		"\7\u0085\2\2\u0903\u0904\7\u00bc\2\2\u0904\u0905\7\u0136\2\2\u0905\u0906"+
		"\5\u0182\u00c2\2\u0906\u0907\7\u0137\2\2\u0907\u0908\7\u0136\2\2\u0908"+
		"\u0909\5j\66\2\u0909\u090a\7\u0137\2\2\u090ai\3\2\2\2\u090b\u0910\5l\67"+
		"\2\u090c\u090d\7\u012f\2\2\u090d\u090f\5l\67\2\u090e\u090c\3\2\2\2\u090f"+
		"\u0912\3\2\2\2\u0910\u090e\3\2\2\2\u0910\u0911\3\2\2\2\u0911k\3\2\2\2"+
		"\u0912\u0910\3\2\2\2\u0913\u0914\7\u00d2\2\2\u0914\u0915\5p9\2\u0915\u0917"+
		"\7\u00f6\2\2\u0916\u0918\79\2\2\u0917\u0916\3\2\2\2\u0917\u0918\3\2\2"+
		"\2\u0918\u0919\3\2\2\2\u0919\u091a\7\u0136\2\2\u091a\u091b\5\u019a\u00ce"+
		"\2\u091b\u091c\7\u0137\2\2\u091cm\3\2\2\2\u091d\u091e\7\u00d2\2\2\u091e"+
		"\u091f\7\u0085\2\2\u091f\u0920\7\u008e\2\2\u0920\u0921\5H%\2\u0921o\3"+
		"\2\2\2\u0922\u0923\5t;\2\u0923q\3\2\2\2\u0924\u0925\7\u00a0\2\2\u0925"+
		"\u0926\7o\2\2\u0926\u0928\5\u0170\u00b9\2\u0927\u0929\7\u00d6\2\2\u0928"+
		"\u0927\3\2\2\2\u0928\u0929\3\2\2\2\u0929s\3\2\2\2\u092a\u092c\7\u0141"+
		"\2\2\u092b\u092a\3\2\2\2\u092b\u092c\3\2\2\2\u092c\u092d\3\2\2\2\u092d"+
		"\u092f\7\u0148\2\2\u092e\u0930\7\u0141\2\2\u092f\u092e\3\2\2\2\u092f\u0930"+
		"\3\2\2\2\u0930\u0939\3\2\2\2\u0931\u0933\7\u0141\2\2\u0932\u0931\3\2\2"+
		"\2\u0932\u0933\3\2\2\2\u0933\u0934\3\2\2\2\u0934\u0936\5v<\2\u0935\u0937"+
		"\7\u0141\2\2\u0936\u0935\3\2\2\2\u0936\u0937\3\2\2\2\u0937\u0939\3\2\2"+
		"\2\u0938\u092b\3\2\2\2\u0938\u0932\3\2\2\2\u0939u\3\2\2\2\u093a\u093b"+
		"\t\22\2\2\u093bw\3\2\2\2\u093c\u093f\5\u00aeX\2\u093d\u093f\5z>\2\u093e"+
		"\u093c\3\2\2\2\u093e\u093d\3\2\2\2\u093fy\3\2\2\2\u0940\u0944\7\u0149"+
		"\2\2\u0941\u0944\5|?\2\u0942\u0944\5\u0084C\2\u0943\u0940\3\2\2\2\u0943"+
		"\u0941\3\2\2\2\u0943\u0942\3\2\2\2\u0944{\3\2\2\2\u0945\u0949\5\u0080"+
		"A\2\u0946\u0949\5~@\2\u0947\u0949\5\u0082B\2\u0948\u0945\3\2\2\2\u0948"+
		"\u0946\3\2\2\2\u0948\u0947\3\2\2\2\u0949}\3\2\2\2\u094a\u094b\7\u011b"+
		"\2\2\u094b\u094c\7\u0149\2\2\u094c\177\3\2\2\2\u094d\u094e\7\u011d\2\2"+
		"\u094e\u094f\7\u0149\2\2\u094f\u0081\3\2\2\2\u0950\u0951\7\u011a\2\2\u0951"+
		"\u0952\7\u0149\2\2\u0952\u0083\3\2\2\2\u0953\u0954\t\23\2\2\u0954\u0085"+
		"\3\2\2\2\u0955\u0956\5\u0088E\2\u0956\u0087\3\2\2\2\u0957\u0964\5\u008e"+
		"H\2\u0958\u0964\5\u0092J\2\u0959\u0964\5\u0094K\2\u095a\u0964\5\u0096"+
		"L\2\u095b\u0964\5\u009eP\2\u095c\u0964\5\u00a0Q\2\u095d\u0964\5\u00a2"+
		"R\2\u095e\u0964\5\u00a4S\2\u095f\u0964\5\u008cG\2\u0960\u0964\5\u008a"+
		"F\2\u0961\u0964\7t\2\2\u0962\u0964\7\u0120\2\2\u0963\u0957\3\2\2\2\u0963"+
		"\u0958\3\2\2\2\u0963\u0959\3\2\2\2\u0963\u095a\3\2\2\2\u0963\u095b\3\2"+
		"\2\2\u0963\u095c\3\2\2\2\u0963\u095d\3\2\2\2\u0963\u095e\3\2\2\2\u0963"+
		"\u095f\3\2\2\2\u0963\u0960\3\2\2\2\u0963\u0961\3\2\2\2\u0963\u0962\3\2"+
		"\2\2\u0964\u0089\3\2\2\2\u0965\u0966\7\u0111\2\2\u0966\u008b\3\2\2\2\u0967"+
		"\u0968\7\u0125\2\2\u0968\u008d\3\2\2\2\u0969\u096b\7\u008a\2\2\u096a\u096c"+
		"\5\u0090I\2\u096b\u096a\3\2\2\2\u096b\u096c\3\2\2\2\u096c\u0981\3\2\2"+
		"\2\u096d\u096f\7\u0116\2\2\u096e\u0970\5\u0090I\2\u096f\u096e\3\2\2\2"+
		"\u096f\u0970\3\2\2\2\u0970\u0981\3\2\2\2\u0971\u0972\7\u008a\2\2\u0972"+
		"\u0974\7\u00f9\2\2\u0973\u0975\5\u0090I\2\u0974\u0973\3\2\2\2\u0974\u0975"+
		"\3\2\2\2\u0975\u0981\3\2\2\2\u0976\u0977\7\u0116\2\2\u0977\u0979\7\u00f9"+
		"\2\2\u0978\u097a\5\u0090I\2\u0979\u0978\3\2\2\2\u0979\u097a\3\2\2\2\u097a"+
		"\u0981\3\2\2\2\u097b\u097d\7\u0117\2\2\u097c\u097e\5\u0090I\2\u097d\u097c"+
		"\3\2\2\2\u097d\u097e\3\2\2\2\u097e\u0981\3\2\2\2\u097f\u0981\7\u011f\2"+
		"\2\u0980\u0969\3\2\2\2\u0980\u096d\3\2\2\2\u0980\u0971\3\2\2\2\u0980\u0976"+
		"\3\2\2\2\u0980\u097b\3\2\2\2\u0980\u097f\3\2\2\2\u0981\u008f\3\2\2\2\u0982"+
		"\u0983\7\u0136\2\2\u0983\u0984\7\u0144\2\2\u0984\u0985\7\u0137\2\2\u0985"+
		"\u0091\3\2\2\2\u0986\u0987\7\u00c8\2\2\u0987\u0989\7\u008a\2\2\u0988\u098a"+
		"\5\u0090I\2\u0989\u0988\3\2\2\2\u0989\u098a\3\2\2\2\u098a\u09aa\3\2\2"+
		"\2\u098b\u098c\7\u00c8\2\2\u098c\u098e\7\u0116\2\2\u098d\u098f\5\u0090"+
		"I\2\u098e\u098d\3\2\2\2\u098e\u098f\3\2\2\2\u098f\u09aa\3\2\2\2\u0990"+
		"\u0992\7\u0118\2\2\u0991\u0993\5\u0090I\2\u0992\u0991\3\2\2\2\u0992\u0993"+
		"\3\2\2\2\u0993\u09aa\3\2\2\2\u0994\u0995\7\u00c8\2\2\u0995\u0996\7\u008a"+
		"\2\2\u0996\u0998\7\u00f9\2\2\u0997\u0999\5\u0090I\2\u0998\u0997\3\2\2"+
		"\2\u0998\u0999\3\2\2\2\u0999\u09aa\3\2\2\2\u099a\u099b\7\u00c8\2\2\u099b"+
		"\u099c\7\u0116\2\2\u099c\u099e\7\u00f9\2\2\u099d\u099f\5\u0090I\2\u099e"+
		"\u099d\3\2\2\2\u099e\u099f\3\2\2\2\u099f\u09aa\3\2\2\2\u09a0\u09a1\7\u0118"+
		"\2\2\u09a1\u09a3\7\u00f9\2\2\u09a2\u09a4\5\u0090I\2\u09a3\u09a2\3\2\2"+
		"\2\u09a3\u09a4\3\2\2\2\u09a4\u09aa\3\2\2\2\u09a5\u09a7\7\u0119\2\2\u09a6"+
		"\u09a8\5\u0090I\2\u09a7\u09a6\3\2\2\2\u09a7\u09a8\3\2\2\2\u09a8\u09aa"+
		"\3\2\2\2\u09a9\u0986\3\2\2\2\u09a9\u098b\3\2\2\2\u09a9\u0990\3\2\2\2\u09a9"+
		"\u0994\3\2\2\2\u09a9\u099a\3\2\2\2\u09a9\u09a0\3\2\2\2\u09a9\u09a5\3\2"+
		"\2\2\u09aa\u0093\3\2\2\2\u09ab\u09ad\7\u0123\2\2\u09ac\u09ae\5\u0090I"+
		"\2\u09ad\u09ac\3\2\2\2\u09ad\u09ae\3\2\2\2\u09ae\u09b4\3\2\2\2\u09af\u09b1"+
		"\7\u0124\2\2\u09b0\u09b2\5\u0090I\2\u09b1\u09b0\3\2\2\2\u09b1\u09b2\3"+
		"\2\2\2\u09b2\u09b4\3\2\2\2\u09b3\u09ab\3\2\2\2\u09b3\u09af\3\2\2\2\u09b4"+
		"\u0095\3\2\2\2\u09b5\u09b8\5\u0098M\2\u09b6\u09b8\5\u009aN\2\u09b7\u09b5"+
		"\3\2\2\2\u09b7\u09b6\3\2\2\2\u09b8\u0097\3\2\2\2\u09b9\u09bb\7\u0114\2"+
		"\2\u09ba\u09bc\5\u009cO\2\u09bb\u09ba\3\2\2\2\u09bb\u09bc\3\2\2\2\u09bc"+
		"\u09cf\3\2\2\2\u09bd\u09bf\7\u0115\2\2\u09be\u09c0\5\u009cO\2\u09bf\u09be"+
		"\3\2\2\2\u09bf\u09c0\3\2\2\2\u09c0\u09cf\3\2\2\2\u09c1\u09c3\7\u009a\2"+
		"\2\u09c2\u09c4\5\u009cO\2\u09c3\u09c2\3\2\2\2\u09c3\u09c4\3\2\2\2\u09c4"+
		"\u09cf\3\2\2\2\u09c5\u09cf\7\u0105\2\2\u09c6\u09cf\7\u0109\2\2\u09c7\u09cf"+
		"\7\u0106\2\2\u09c8\u09cf\7\u010a\2\2\u09c9\u09cf\7\u0107\2\2\u09ca\u09cf"+
		"\7\u010b\2\2\u09cb\u09cf\7\u010c\2\2\u09cc\u09cf\7\u0108\2\2\u09cd\u09cf"+
		"\7\u010d\2\2\u09ce\u09b9\3\2\2\2\u09ce\u09bd\3\2\2\2\u09ce\u09c1\3\2\2"+
		"\2\u09ce\u09c5\3\2\2\2\u09ce\u09c6\3\2\2\2\u09ce\u09c7\3\2\2\2\u09ce\u09c8"+
		"\3\2\2\2\u09ce\u09c9\3\2\2\2\u09ce\u09ca\3\2\2\2\u09ce\u09cb\3\2\2\2\u09ce"+
		"\u09cc\3\2\2\2\u09ce\u09cd\3\2\2\2\u09cf\u0099\3\2\2\2\u09d0\u09d2\7\u0112"+
		"\2\2\u09d1\u09d3\5\u009cO\2\u09d2\u09d1\3\2\2\2\u09d2\u09d3\3\2\2\2\u09d3"+
		"\u09db\3\2\2\2\u09d4\u09db\7\u010e\2\2\u09d5\u09db\7\u0110\2\2\u09d6\u09db"+
		"\7\u010f\2\2\u09d7\u09db\7\u0113\2\2\u09d8\u09d9\7\u0113\2\2\u09d9\u09db"+
		"\7\u00d4\2\2\u09da\u09d0\3\2\2\2\u09da\u09d4\3\2\2\2\u09da\u09d5\3\2\2"+
		"\2\u09da\u09d6\3\2\2\2\u09da\u09d7\3\2\2\2\u09da\u09d8\3\2\2\2\u09db\u009b"+
		"\3\2\2\2\u09dc\u09dd\7\u0136\2\2\u09dd\u09de\7\u0144\2\2\u09de\u09e5\7"+
		"\u0137\2\2\u09df\u09e0\7\u0136\2\2\u09e0\u09e1\7\u0144\2\2\u09e1\u09e2"+
		"\7\u012f\2\2\u09e2\u09e3\7\u0144\2\2\u09e3\u09e5\7\u0137\2\2\u09e4\u09dc"+
		"\3\2\2\2\u09e4\u09df\3\2\2\2\u09e5\u009d\3\2\2\2\u09e6\u09e7\t\24\2\2"+
		"\u09e7\u009f\3\2\2\2\u09e8\u09f6\7\u011a\2\2\u09e9\u09f6\7\u011b\2\2\u09ea"+
		"\u09eb\7\u011b\2\2\u09eb\u09ec\7\u0080\2\2\u09ec\u09ed\7\u011b\2\2\u09ed"+
		"\u09f6\7\u0100\2\2\u09ee\u09f6\7\u011c\2\2\u09ef\u09f6\7\u011d\2\2\u09f0"+
		"\u09f1\7\u011d\2\2\u09f1\u09f2\7\u0080\2\2\u09f2\u09f3\7\u011b\2\2\u09f3"+
		"\u09f6\7\u0100\2\2\u09f4\u09f6\7\u011e\2\2\u09f5\u09e8\3\2\2\2\u09f5\u09e9"+
		"\3\2\2\2\u09f5\u09ea\3\2\2\2\u09f5\u09ee\3\2\2\2\u09f5\u09ef\3\2\2\2\u09f5"+
		"\u09f0\3\2\2\2\u09f5\u09f4\3\2\2\2\u09f6\u00a1\3\2\2\2\u09f7\u09f9\7\u0103"+
		"\2\2\u09f8\u09fa\5\u0090I\2\u09f9\u09f8\3\2\2\2\u09f9\u09fa\3\2\2\2\u09fa"+
		"\u0a05\3\2\2\2\u09fb\u09fd\7\u0104\2\2\u09fc\u09fe\5\u0090I\2\u09fd\u09fc"+
		"\3\2\2\2\u09fd\u09fe\3\2\2\2\u09fe\u0a05\3\2\2\2\u09ff\u0a00\7\u0103\2"+
		"\2\u0a00\u0a02\7\u00f9\2\2\u0a01\u0a03\5\u0090I\2\u0a02\u0a01\3\2\2\2"+
		"\u0a02\u0a03\3\2\2\2\u0a03\u0a05\3\2\2\2\u0a04\u09f7\3\2\2\2\u0a04\u09fb"+
		"\3\2\2\2\u0a04\u09ff\3\2\2\2\u0a05\u00a3\3\2\2\2\u0a06\u0a08\7\u0121\2"+
		"\2\u0a07\u0a09\5\u0090I\2\u0a08\u0a07\3\2\2\2\u0a08\u0a09\3\2\2\2\u0a09"+
		"\u0a14\3\2\2\2\u0a0a\u0a0b\7\u0121\2\2\u0a0b\u0a0d\7\u00f9\2\2\u0a0c\u0a0e"+
		"\5\u0090I\2\u0a0d\u0a0c\3\2\2\2\u0a0d\u0a0e\3\2\2\2\u0a0e\u0a14\3\2\2"+
		"\2\u0a0f\u0a11\7\u0122\2\2\u0a10\u0a12\5\u0090I\2\u0a11\u0a10\3\2\2\2"+
		"\u0a11\u0a12\3\2\2\2\u0a12\u0a14\3\2\2\2\u0a13\u0a06\3\2\2\2\u0a13\u0a0a"+
		"\3\2\2\2\u0a13\u0a0f\3\2\2\2\u0a14\u00a5\3\2\2\2\u0a15\u0a18\5\u00a8U"+
		"\2\u0a16\u0a18\5\u00aaV\2\u0a17\u0a15\3\2\2\2\u0a17\u0a16\3\2\2\2\u0a18"+
		"\u00a7\3\2\2\2\u0a19\u0a1a\7\u0136\2\2\u0a1a\u0a1b\5\u00d6l\2\u0a1b\u0a1c"+
		"\7\u0137\2\2\u0a1c\u00a9\3\2\2\2\u0a1d\u0a25\5\u00acW\2\u0a1e\u0a25\5"+
		"\u017e\u00c0\2\u0a1f\u0a25\5\u00b2Z\2\u0a20\u0a25\5\u0184\u00c3\2\u0a21"+
		"\u0a25\5\u00be`\2\u0a22\u0a25\5\u00d0i\2\u0a23\u0a25\5\u01b8\u00dd\2\u0a24"+
		"\u0a1d\3\2\2\2\u0a24\u0a1e\3\2\2\2\u0a24\u0a1f\3\2\2\2\u0a24\u0a20\3\2"+
		"\2\2\u0a24\u0a21\3\2\2\2\u0a24\u0a22\3\2\2\2\u0a24\u0a23\3\2\2\2\u0a25"+
		"\u00ab\3\2\2\2\u0a26\u0a27\5x=\2\u0a27\u00ad\3\2\2\2\u0a28\u0a29\t\25"+
		"\2\2\u0a29\u00af\3\2\2\2\u0a2a\u0a2c\5\u00e4s\2\u0a2b\u0a2a\3\2\2\2\u0a2b"+
		"\u0a2c\3\2\2\2\u0a2c\u0a2d\3\2\2\2\u0a2d\u0a2e\5\u00aeX\2\u0a2e\u00b1"+
		"\3\2\2\2\u0a2f\u0a30\5\u00b4[\2\u0a30\u00b3\3\2\2\2\u0a31\u0a32\7\u0094"+
		"\2\2\u0a32\u0a33\7\u0136\2\2\u0a33\u0a34\7\u013a\2\2\u0a34\u0a3a\7\u0137"+
		"\2\2\u0a35\u0a37\5\u00b6\\\2\u0a36\u0a38\5\u00ba^\2\u0a37\u0a36\3\2\2"+
		"\2\u0a37\u0a38\3\2\2\2\u0a38\u0a3a\3\2\2\2\u0a39\u0a31\3\2\2\2\u0a39\u0a35"+
		"\3\2\2\2\u0a3a\u00b5\3\2\2\2\u0a3b\u0a3c\5\u00b8]\2\u0a3c\u0a3e\7\u0136"+
		"\2\2\u0a3d\u0a3f\5\u017c\u00bf\2\u0a3e\u0a3d\3\2\2\2\u0a3e\u0a3f\3\2\2"+
		"\2\u0a3f\u0a40\3\2\2\2\u0a40\u0a41\5\u00d6l\2\u0a41\u0a42\7\u0137\2\2"+
		"\u0a42\u00b7\3\2\2\2\u0a43\u0a44\t\26\2\2\u0a44\u00b9\3\2\2\2\u0a45\u0a46"+
		"\7\u00a7\2\2\u0a46\u0a47\7\u0136\2\2\u0a47\u0a48\7\177\2\2\u0a48\u0a49"+
		"\5\u0146\u00a4\2\u0a49\u0a4a\7\u0137\2\2\u0a4a\u00bb\3\2\2\2\u0a4b\u0a4c"+
		"\7\u00ab\2\2\u0a4c\u0a4d\7\u0136\2\2\u0a4d\u0a4e\5\u0182\u00c2\2\u0a4e"+
		"\u0a4f\7\u0137\2\2\u0a4f\u00bd\3\2\2\2\u0a50\u0a51\5\u00c2b\2\u0a51\u00bf"+
		"\3\2\2\2\u0a52\u0a53\7\u00cb\2\2\u0a53\u0a54\7\u0136\2\2\u0a54\u0a55\5"+
		"\u00dan\2\u0a55\u0a56\7\u012f\2\2\u0a56\u0a57\5\u0100\u0081\2\u0a57\u0a58"+
		"\7\u0137\2\2\u0a58\u0a65\3\2\2\2\u0a59\u0a5a\7\u008d\2\2\u0a5a\u0a5b\7"+
		"\u0136\2\2\u0a5b\u0a5e\5\u00dan\2\u0a5c\u0a5d\7\u012f\2\2\u0a5d\u0a5f"+
		"\5\u0100\u0081\2\u0a5e\u0a5c\3\2\2\2\u0a5f\u0a60\3\2\2\2\u0a60\u0a5e\3"+
		"\2\2\2\u0a60\u0a61\3\2\2\2\u0a61\u0a62\3\2\2\2\u0a62\u0a63\7\u0137\2\2"+
		"\u0a63\u0a65\3\2\2\2\u0a64\u0a52\3\2\2\2\u0a64\u0a59\3\2\2\2\u0a65\u00c1"+
		"\3\2\2\2\u0a66\u0a69\5\u00c4c\2\u0a67\u0a69\5\u00c6d\2\u0a68\u0a66\3\2"+
		"\2\2\u0a68\u0a67\3\2\2\2\u0a69\u00c3\3\2\2\2\u0a6a\u0a6b\7\16\2\2\u0a6b"+
		"\u0a6d\5\u0100\u0081\2\u0a6c\u0a6e\5\u00c8e\2\u0a6d\u0a6c\3\2\2\2\u0a6e"+
		"\u0a6f\3\2\2\2\u0a6f\u0a6d\3\2\2\2\u0a6f\u0a70\3\2\2\2\u0a70\u0a72\3\2"+
		"\2\2\u0a71\u0a73\5\u00ccg\2\u0a72\u0a71\3\2\2\2\u0a72\u0a73\3\2\2\2\u0a73"+
		"\u0a74\3\2\2\2\u0a74\u0a75\7#\2\2\u0a75\u00c5\3\2\2\2\u0a76\u0a78\7\16"+
		"\2\2\u0a77\u0a79\5\u00caf\2\u0a78\u0a77\3\2\2\2\u0a79\u0a7a\3\2\2\2\u0a7a"+
		"\u0a78\3\2\2\2\u0a7a\u0a7b\3\2\2\2\u0a7b\u0a7d\3\2\2\2\u0a7c\u0a7e\5\u00cc"+
		"g\2\u0a7d\u0a7c\3\2\2\2\u0a7d\u0a7e\3\2\2\2\u0a7e\u0a7f\3\2\2\2\u0a7f"+
		"\u0a80\7#\2\2\u0a80\u00c7\3\2\2\2\u0a81\u0a82\7~\2\2\u0a82\u0a83\5\u0146"+
		"\u00a4\2\u0a83\u0a84\7r\2\2\u0a84\u0a85\5\u00ceh\2\u0a85\u00c9\3\2\2\2"+
		"\u0a86\u0a87\7~\2\2\u0a87\u0a88\5\u0146\u00a4\2\u0a88\u0a89\7r\2\2\u0a89"+
		"\u0a8a\5\u00ceh\2\u0a8a\u00cb\3\2\2\2\u0a8b\u0a8c\7$\2\2\u0a8c\u0a8d\5"+
		"\u00ceh\2\u0a8d\u00cd\3\2\2\2\u0a8e\u0a91\5\u00d6l\2\u0a8f\u0a91\7M\2"+
		"\2\u0a90\u0a8e\3\2\2\2\u0a90\u0a8f\3\2\2\2\u0a91\u00cf\3\2\2\2\u0a92\u0a93"+
		"\7\20\2\2\u0a93\u0a94\7\u0136\2\2\u0a94\u0a95\5\u00d2j\2\u0a95\u0a96\7"+
		"\5\2\2\u0a96\u0a97\5\u00d4k\2\u0a97\u0a98\7\u0137\2\2\u0a98\u00d1\3\2"+
		"\2\2\u0a99\u0a9a\5\u00d6l\2\u0a9a\u00d3\3\2\2\2\u0a9b\u0a9c\5\u0086D\2"+
		"\u0a9c\u00d5\3\2\2\2\u0a9d\u0aa1\5\u00d8m\2\u0a9e\u0aa1\5\u0114\u008b"+
		"\2\u0a9f\u0aa1\5\u0100\u0081\2\u0aa0\u0a9d\3\2\2\2\u0aa0\u0a9e\3\2\2\2"+
		"\u0aa0\u0a9f\3\2\2\2\u0aa1\u00d7\3\2\2\2\u0aa2\u0aa6\5\u00dan\2\u0aa3"+
		"\u0aa6\5\u00f0y\2\u0aa4\u0aa6\7M\2\2\u0aa5\u0aa2\3\2\2\2\u0aa5\u0aa3\3"+
		"\2\2\2\u0aa5\u0aa4\3\2\2\2\u0aa6\u00d9\3\2\2\2\u0aa7\u0aac\5\u00dco\2"+
		"\u0aa8\u0aa9\t\27\2\2\u0aa9\u0aab\5\u00dco\2\u0aaa\u0aa8\3\2\2\2\u0aab"+
		"\u0aae\3\2\2\2\u0aac\u0aaa\3\2\2\2\u0aac\u0aad\3\2\2\2\u0aad\u00db\3\2"+
		"\2\2\u0aae\u0aac\3\2\2\2\u0aaf\u0ab4\5\u00dep\2\u0ab0\u0ab1\t\30\2\2\u0ab1"+
		"\u0ab3\5\u00dep\2\u0ab2\u0ab0\3\2\2\2\u0ab3\u0ab6\3\2\2\2\u0ab4\u0ab2"+
		"\3\2\2\2\u0ab4\u0ab5\3\2\2\2\u0ab5\u00dd\3\2\2\2\u0ab6\u0ab4\3\2\2\2\u0ab7"+
		"\u0ab9\5\u00e4s\2\u0ab8\u0ab7\3\2\2\2\u0ab8\u0ab9\3\2\2\2\u0ab9\u0aba"+
		"\3\2\2\2\u0aba\u0abb\5\u00e2r\2\u0abb\u00df\3\2\2\2\u0abc\u0abd\7\u0136"+
		"\2\2\u0abd\u0ac2\5\u00dan\2\u0abe\u0abf\7\u012f\2\2\u0abf\u0ac1\5\u00da"+
		"n\2\u0ac0\u0abe\3\2\2\2\u0ac1\u0ac4\3\2\2\2\u0ac2\u0ac0\3\2\2\2\u0ac2"+
		"\u0ac3\3\2\2\2\u0ac3\u0ac5\3\2\2\2\u0ac4\u0ac2\3\2\2\2\u0ac5\u0ac6\7\u0137"+
		"\2\2\u0ac6\u00e1\3\2\2\2\u0ac7\u0acc\5\u00a6T\2\u0ac8\u0ac9\7\u012a\2"+
		"\2\u0ac9\u0acb\5\u00d4k\2\u0aca\u0ac8\3\2\2\2\u0acb\u0ace\3\2\2\2\u0acc"+
		"\u0aca\3\2\2\2\u0acc\u0acd\3\2\2\2\u0acd\u0ad1\3\2\2\2\u0ace\u0acc\3\2"+
		"\2\2\u0acf\u0ad1\5\u00e6t\2\u0ad0\u0ac7\3\2\2\2\u0ad0\u0acf\3\2\2\2\u0ad1"+
		"\u00e3\3\2\2\2\u0ad2\u0ad3\t\27\2\2\u0ad3\u00e5\3\2\2\2\u0ad4\u0ad5\5"+
		"\u00e8u\2\u0ad5\u00e7\3\2\2\2\u0ad6\u0ad7\7\u00a5\2\2\u0ad7\u0ad8\7\u0136"+
		"\2\2\u0ad8\u0ad9\5\u00eav\2\u0ad9\u0ada\7\60\2\2\u0ada\u0adb\5\u00eex"+
		"\2\u0adb\u0adc\7\u0137\2\2\u0adc\u00e9\3\2\2\2\u0add\u0ae1\5\u01b2\u00da"+
		"\2\u0ade\u0ae1\5\u00ecw\2\u0adf\u0ae1\5\u01b6\u00dc\2\u0ae0\u0add\3\2"+
		"\2\2\u0ae0\u0ade\3\2\2\2\u0ae0\u0adf\3\2\2\2\u0ae1\u00eb\3\2\2\2\u0ae2"+
		"\u0ae3\t\31\2\2\u0ae3\u00ed\3\2\2\2\u0ae4\u0ae7\5\u017e\u00c0\2\u0ae5"+
		"\u0ae7\5|?\2\u0ae6\u0ae4\3\2\2\2\u0ae6\u0ae5\3\2\2\2\u0ae7\u00ef\3\2\2"+
		"\2\u0ae8\u0ae9\5\u00f2z\2\u0ae9\u00f1\3\2\2\2\u0aea\u0aef\5\u00f4{\2\u0aeb"+
		"\u0aec\7\u0130\2\2\u0aec\u0aee\5\u00f4{\2\u0aed\u0aeb\3\2\2\2\u0aee\u0af1"+
		"\3\2\2\2\u0aef\u0aed\3\2\2\2\u0aef\u0af0\3\2\2\2\u0af0\u00f3\3\2\2\2\u0af1"+
		"\u0aef\3\2\2\2\u0af2\u0af3\5\u00f6|\2\u0af3\u00f5\3\2\2\2\u0af4\u0af7"+
		"\5\u00a6T\2\u0af5\u0af7\5\u00f8}\2\u0af6\u0af4\3\2\2\2\u0af6\u0af5\3\2"+
		"\2\2\u0af7\u00f7\3\2\2\2\u0af8\u0af9\5\u00fa~\2\u0af9\u00f9\3\2\2\2\u0afa"+
		"\u0afb\7\u00f1\2\2\u0afb\u0afc\7\u0136\2\2\u0afc\u0afd\5\u00fc\177\2\u0afd"+
		"\u0afe\7\u0137\2\2\u0afe\u00fb\3\2\2\2\u0aff\u0b01\5\u00fe\u0080\2\u0b00"+
		"\u0aff\3\2\2\2\u0b00\u0b01\3\2\2\2\u0b01\u0b03\3\2\2\2\u0b02\u0b04\5\u00f2"+
		"z\2\u0b03\u0b02\3\2\2\2\u0b03\u0b04\3\2\2\2\u0b04\u0b05\3\2\2\2\u0b05"+
		"\u0b07\7\60\2\2\u0b06\u0b00\3\2\2\2\u0b06\u0b07\3\2\2\2\u0b07\u0b08\3"+
		"\2\2\2\u0b08\u0b0e\5\u00f2z\2\u0b09\u0b0a\5\u00f2z\2\u0b0a\u0b0b\7\u012f"+
		"\2\2\u0b0b\u0b0c\5\u00f2z\2\u0b0c\u0b0e\3\2\2\2\u0b0d\u0b06\3\2\2\2\u0b0d"+
		"\u0b09\3\2\2\2\u0b0e\u00fd\3\2\2\2\u0b0f\u0b10\t\32\2\2\u0b10\u00ff\3"+
		"\2\2\2\u0b11\u0b12\5\u0102\u0082\2\u0b12\u0101\3\2\2\2\u0b13\u0b18\5\u0104"+
		"\u0083\2\u0b14\u0b15\7T\2\2\u0b15\u0b17\5\u0102\u0082\2\u0b16\u0b14\3"+
		"\2\2\2\u0b17\u0b1a\3\2\2\2\u0b18\u0b16\3\2\2\2\u0b18\u0b19\3\2\2\2\u0b19"+
		"\u0103\3\2\2\2\u0b1a\u0b18\3\2\2\2\u0b1b\u0b20\5\u0106\u0084\2\u0b1c\u0b1d"+
		"\7\7\2\2\u0b1d\u0b1f\5\u0104\u0083\2\u0b1e\u0b1c\3\2\2\2\u0b1f\u0b22\3"+
		"\2\2\2\u0b20\u0b1e\3\2\2\2\u0b20\u0b21\3\2\2\2\u0b21\u0105\3\2\2\2\u0b22"+
		"\u0b20\3\2\2\2\u0b23\u0b27\5\u0108\u0085\2\u0b24\u0b25\7L\2\2\u0b25\u0b27"+
		"\5\u0108\u0085\2\u0b26\u0b23\3\2\2\2\u0b26\u0b24\3\2\2\2\u0b27\u0107\3"+
		"\2\2\2\u0b28\u0b2a\5\u010e\u0088\2\u0b29\u0b2b\5\u010a\u0086\2\u0b2a\u0b29"+
		"\3\2\2\2\u0b2a\u0b2b\3\2\2\2\u0b2b\u0109\3\2\2\2\u0b2c\u0b2e\7C\2\2\u0b2d"+
		"\u0b2f\7L\2\2\u0b2e\u0b2d\3\2\2\2\u0b2e\u0b2f\3\2\2\2\u0b2f\u0b30\3\2"+
		"\2\2\u0b30\u0b31\5\u010c\u0087\2\u0b31\u010b\3\2\2\2\u0b32\u0b33\t\23"+
		"\2\2\u0b33\u010d\3\2\2\2\u0b34\u0b37\5\u018c\u00c7\2\u0b35\u0b37\5\u0110"+
		"\u0089\2\u0b36\u0b34\3\2\2\2\u0b36\u0b35\3\2\2\2\u0b37\u010f\3\2\2\2\u0b38"+
		"\u0b3b\5\u0112\u008a\2\u0b39\u0b3b\5\u00aaV\2\u0b3a\u0b38\3\2\2\2\u0b3a"+
		"\u0b39\3\2\2\2\u0b3b\u0111\3\2\2\2\u0b3c\u0b3d\7\u0136\2\2\u0b3d\u0b3e"+
		"\5\u0100\u0081\2\u0b3e\u0b3f\7\u0137\2\2\u0b3f\u0113\3\2\2\2\u0b40\u0b43"+
		"\5\u0116\u008c\2\u0b41\u0b43\5\u0118\u008d\2\u0b42\u0b40\3\2\2\2\u0b42"+
		"\u0b41\3\2\2\2\u0b43\u0115\3\2\2\2\u0b44\u0b45\5\u00aaV\2\u0b45\u0117"+
		"\3\2\2\2\u0b46\u0b47\7M\2\2\u0b47\u0119\3\2\2\2\u0b48\u0b4b\5\u0116\u008c"+
		"\2\u0b49\u0b4b\5\u011c\u008f\2\u0b4a\u0b48\3\2\2\2\u0b4a\u0b49\3\2\2\2"+
		"\u0b4b\u011b\3\2\2\2\u0b4c\u0b4f\5\u00d8m\2\u0b4d\u0b4f\5\u0110\u0089"+
		"\2\u0b4e\u0b4c\3\2\2\2\u0b4e\u0b4d\3\2\2\2\u0b4f\u011d\3\2\2\2\u0b50\u0b52"+
		"\5\u0120\u0091\2\u0b51\u0b53\5\u0144\u00a3\2\u0b52\u0b51\3\2\2\2\u0b52"+
		"\u0b53\3\2\2\2\u0b53\u0b55\3\2\2\2\u0b54\u0b56\5\u0148\u00a5\2\u0b55\u0b54"+
		"\3\2\2\2\u0b55\u0b56\3\2\2\2\u0b56\u0b58\3\2\2\2\u0b57\u0b59\5\u0158\u00ad"+
		"\2\u0b58\u0b57\3\2\2\2\u0b58\u0b59\3\2\2\2\u0b59\u0b5b\3\2\2\2\u0b5a\u0b5c"+
		"\5\u01c0\u00e1\2\u0b5b\u0b5a\3\2\2\2\u0b5b\u0b5c\3\2\2\2\u0b5c\u0b5e\3"+
		"\2\2\2\u0b5d\u0b5f\5\u01c8\u00e5\2\u0b5e\u0b5d\3\2\2\2\u0b5e\u0b5f\3\2"+
		"\2\2\u0b5f\u011f\3\2\2\2\u0b60\u0b61\7\60\2\2\u0b61\u0b62\5\u0122\u0092"+
		"\2\u0b62\u0121\3\2\2\2\u0b63\u0b68\5\u0124\u0093\2\u0b64\u0b65\7\u012f"+
		"\2\2\u0b65\u0b67\5\u0124\u0093\2\u0b66\u0b64\3\2\2\2\u0b67\u0b6a\3\2\2"+
		"\2\u0b68\u0b66\3\2\2\2\u0b68\u0b69\3\2\2\2\u0b69\u0123\3\2\2\2\u0b6a\u0b68"+
		"\3\2\2\2\u0b6b\u0b6e\5\u0126\u0094\2\u0b6c\u0b6e\5\u013e\u00a0\2\u0b6d"+
		"\u0b6b\3\2\2\2\u0b6d\u0b6c\3\2\2\2\u0b6e\u0125\3\2\2\2\u0b6f\u0b71\5\u013e"+
		"\u00a0\2\u0b70\u0b72\5\u0128\u0095\2\u0b71\u0b70\3\2\2\2\u0b72\u0b73\3"+
		"\2\2\2\u0b73\u0b71\3\2\2\2\u0b73\u0b74\3\2\2\2\u0b74\u0127\3\2\2\2\u0b75"+
		"\u0b76\7\30\2\2\u0b76\u0b77\7D\2\2\u0b77\u0b89\5\u013e\u00a0\2\u0b78\u0b7a"+
		"\5\u0132\u009a\2\u0b79\u0b78\3\2\2\2\u0b79\u0b7a\3\2\2\2\u0b7a\u0b7b\3"+
		"\2\2\2\u0b7b\u0b7c\7D\2\2\u0b7c\u0b7d\5\u013e\u00a0\2\u0b7d\u0b7e\5\u0138"+
		"\u009d\2\u0b7e\u0b89\3\2\2\2\u0b7f\u0b81\7K\2\2\u0b80\u0b82\5\u0132\u009a"+
		"\2\u0b81\u0b80\3\2\2\2\u0b81\u0b82\3\2\2\2\u0b82\u0b83\3\2\2\2\u0b83\u0b84"+
		"\7D\2\2\u0b84\u0b89\5\u013e\u00a0\2\u0b85\u0b86\7w\2\2\u0b86\u0b87\7D"+
		"\2\2\u0b87\u0b89\5\u013e\u00a0\2\u0b88\u0b75\3\2\2\2\u0b88\u0b79\3\2\2"+
		"\2\u0b88\u0b7f\3\2\2\2\u0b88\u0b85\3\2\2\2\u0b89\u0129\3\2\2\2\u0b8a\u0b8b"+
		"\7\30\2\2\u0b8b\u0b8c\7D\2\2\u0b8c\u0b8d\5\u013e\u00a0\2\u0b8d\u012b\3"+
		"\2\2\2\u0b8e\u0b90\5\u0132\u009a\2\u0b8f\u0b8e\3\2\2\2\u0b8f\u0b90\3\2"+
		"\2\2\u0b90\u0b91\3\2\2\2\u0b91\u0b92\7D\2\2\u0b92\u0b93\5\u013e\u00a0"+
		"\2\u0b93\u0b94\5\u0138\u009d\2\u0b94\u012d\3\2\2\2\u0b95\u0b97\7K\2\2"+
		"\u0b96\u0b98\5\u0132\u009a\2\u0b97\u0b96\3\2\2\2\u0b97\u0b98\3\2\2\2\u0b98"+
		"\u0b99\3\2\2\2\u0b99\u0b9a\7D\2\2\u0b9a\u0b9b\5\u013e\u00a0\2\u0b9b\u012f"+
		"\3\2\2\2\u0b9c\u0b9d\7w\2\2\u0b9d\u0b9e\7D\2\2\u0b9e\u0b9f\5\u013e\u00a0"+
		"\2\u0b9f\u0131\3\2\2\2\u0ba0\u0ba3\7=\2\2\u0ba1\u0ba3\5\u0134\u009b\2"+
		"\u0ba2\u0ba0\3\2\2\2\u0ba2\u0ba1\3\2\2\2\u0ba3\u0133\3\2\2\2\u0ba4\u0ba6"+
		"\5\u0136\u009c\2\u0ba5\u0ba7\7Q\2\2\u0ba6\u0ba5\3\2\2\2\u0ba6\u0ba7\3"+
		"\2\2\2\u0ba7\u0135\3\2\2\2\u0ba8\u0ba9\t\33\2\2\u0ba9\u0137\3\2\2\2\u0baa"+
		"\u0bad\5\u013a\u009e\2\u0bab\u0bad\5\u013c\u009f\2\u0bac\u0baa\3\2\2\2"+
		"\u0bac\u0bab\3\2\2\2\u0bad\u0139\3\2\2\2\u0bae\u0baf\7P\2\2\u0baf\u0bb0"+
		"\5\u0146\u00a4\2\u0bb0\u013b\3\2\2\2\u0bb1\u0bb2\7{\2\2\u0bb2\u0bb3\7"+
		"\u0136\2\2\u0bb3\u0bb4\5\u0182\u00c2\2\u0bb4\u0bb5\7\u0137\2\2\u0bb5\u013d"+
		"\3\2\2\2\u0bb6\u0bbb\5\u016e\u00b8\2\u0bb7\u0bb9\7\5\2\2\u0bb8\u0bb7\3"+
		"\2\2\2\u0bb8\u0bb9\3\2\2\2\u0bb9\u0bba\3\2\2\2\u0bba\u0bbc\5t;\2\u0bbb"+
		"\u0bb8\3\2\2\2\u0bbb\u0bbc\3\2\2\2\u0bbc\u0bc1\3\2\2\2\u0bbd\u0bbe\7\u0136"+
		"\2\2\u0bbe\u0bbf\5\u0140\u00a1\2\u0bbf\u0bc0\7\u0137\2\2\u0bc0\u0bc2\3"+
		"\2\2\2\u0bc1\u0bbd\3\2\2\2\u0bc1\u0bc2\3\2\2\2\u0bc2\u0bcf\3\2\2\2\u0bc3"+
		"\u0bc5\5\u0142\u00a2\2\u0bc4\u0bc6\7\5\2\2\u0bc5\u0bc4\3\2\2\2\u0bc5\u0bc6"+
		"\3\2\2\2\u0bc6\u0bc7\3\2\2\2\u0bc7\u0bcc\5t;\2\u0bc8\u0bc9\7\u0136\2\2"+
		"\u0bc9\u0bca\5\u0140\u00a1\2\u0bca\u0bcb\7\u0137\2\2\u0bcb\u0bcd\3\2\2"+
		"\2\u0bcc\u0bc8\3\2\2\2\u0bcc\u0bcd\3\2\2\2\u0bcd\u0bcf\3\2\2\2\u0bce\u0bb6"+
		"\3\2\2\2\u0bce\u0bc3\3\2\2\2\u0bcf\u013f\3\2\2\2\u0bd0\u0bd5\5t;\2\u0bd1"+
		"\u0bd2\7\u012f\2\2\u0bd2\u0bd4\5t;\2\u0bd3\u0bd1\3\2\2\2\u0bd4\u0bd7\3"+
		"\2\2\2\u0bd5\u0bd3\3\2\2\2\u0bd5\u0bd6\3\2\2\2\u0bd6\u0141\3\2\2\2\u0bd7"+
		"\u0bd5\3\2\2\2\u0bd8\u0bd9\5\u0188\u00c5\2\u0bd9\u0143\3\2\2\2\u0bda\u0bdb"+
		"\7\177\2\2\u0bdb\u0bdc\5\u0146\u00a4\2\u0bdc\u0145\3\2\2\2\u0bdd\u0bde"+
		"\5\u00d6l\2\u0bde\u0147\3\2\2\2\u0bdf\u0be0\7\63\2\2\u0be0\u0be1\7\u0085"+
		"\2\2\u0be1\u0be2\5\u014a\u00a6\2\u0be2\u0149\3\2\2\2\u0be3\u0be8\5\u014c"+
		"\u00a7\2\u0be4\u0be5\7\u012f\2\2\u0be5\u0be7\5\u014c\u00a7\2\u0be6\u0be4"+
		"\3\2\2\2\u0be7\u0bea\3\2\2\2\u0be8\u0be6\3\2\2\2\u0be8\u0be9\3\2\2\2\u0be9"+
		"\u014b\3\2\2\2\u0bea\u0be8\3\2\2\2\u0beb\u0bf0\5\u0152\u00aa\2\u0bec\u0bf0"+
		"\5\u0154\u00ab\2\u0bed\u0bf0\5\u0156\u00ac\2\u0bee\u0bf0\5\u014e\u00a8"+
		"\2\u0bef\u0beb\3\2\2\2\u0bef\u0bec\3\2\2\2\u0bef\u0bed\3\2\2\2\u0bef\u0bee"+
		"\3\2\2\2\u0bf0\u014d\3\2\2\2\u0bf1\u0bf7\5\u011a\u008e\2\u0bf2\u0bf3\7"+
		"\u0136\2\2\u0bf3\u0bf4\5\u015a\u00ae\2\u0bf4\u0bf5\7\u0137\2\2\u0bf5\u0bf7"+
		"\3\2\2\2\u0bf6\u0bf1\3\2\2\2\u0bf6\u0bf2\3\2\2\2\u0bf7\u014f\3\2\2\2\u0bf8"+
		"\u0bfd\5\u014e\u00a8\2\u0bf9\u0bfa\7\u012f\2\2\u0bfa\u0bfc\5\u014e\u00a8"+
		"\2\u0bfb\u0bf9\3\2\2\2\u0bfc\u0bff\3\2\2\2\u0bfd\u0bfb\3\2\2\2\u0bfd\u0bfe"+
		"\3\2\2\2\u0bfe\u0151\3\2\2\2\u0bff\u0bfd\3\2\2\2\u0c00\u0c01\7\u00db\2"+
		"\2\u0c01\u0c02\7\u0136\2\2\u0c02\u0c03\5\u0150\u00a9\2\u0c03\u0c04\7\u0137"+
		"\2\2\u0c04\u0153\3\2\2\2\u0c05\u0c06\7\u0095\2\2\u0c06\u0c07\7\u0136\2"+
		"\2\u0c07\u0c08\5\u0150\u00a9\2\u0c08\u0c09\7\u0137\2\2\u0c09\u0155\3\2"+
		"\2\2\u0c0a\u0c0b\7\u0136\2\2\u0c0b\u0c0c\7\u0137\2\2\u0c0c\u0157\3\2\2"+
		"\2\u0c0d\u0c0e\7\64\2\2\u0c0e\u0c0f\5\u0100\u0081\2\u0c0f\u0159\3\2\2"+
		"\2\u0c10\u0c15\5\u011a\u008e\2\u0c11\u0c12\7\u012f\2\2\u0c12\u0c14\5\u011a"+
		"\u008e\2\u0c13\u0c11\3\2\2\2\u0c14\u0c17\3\2\2\2\u0c15\u0c13\3\2\2\2\u0c15"+
		"\u0c16\3\2\2\2\u0c16\u015b\3\2\2\2\u0c17\u0c15\3\2\2\2\u0c18\u0c19\5\u015e"+
		"\u00b0\2\u0c19\u015d\3\2\2\2\u0c1a\u0c1d\5\u0160\u00b1\2\u0c1b\u0c1d\5"+
		"\u0126\u0094\2\u0c1c\u0c1a\3\2\2\2\u0c1c\u0c1b\3\2\2\2\u0c1d\u015f\3\2"+
		"\2\2\u0c1e\u0c27\5\u0164\u00b3\2\u0c1f\u0c20\5\u0126\u0094\2\u0c20\u0c22"+
		"\t\34\2\2\u0c21\u0c23\t\35\2\2\u0c22\u0c21\3\2\2\2\u0c22\u0c23\3\2\2\2"+
		"\u0c23\u0c24\3\2\2\2\u0c24\u0c25\5\u0162\u00b2\2\u0c25\u0c27\3\2\2\2\u0c26"+
		"\u0c1e\3\2\2\2\u0c26\u0c1f\3\2\2\2\u0c27\u0c2f\3\2\2\2\u0c28\u0c2a\t\34"+
		"\2\2\u0c29\u0c2b\t\35\2\2\u0c2a\u0c29\3\2\2\2\u0c2a\u0c2b\3\2\2\2\u0c2b"+
		"\u0c2c\3\2\2\2\u0c2c\u0c2e\5\u0162\u00b2\2\u0c2d\u0c28\3\2\2\2\u0c2e\u0c31"+
		"\3\2\2\2\u0c2f\u0c2d\3\2\2\2\u0c2f\u0c30\3\2\2\2\u0c30\u0161\3\2\2\2\u0c31"+
		"\u0c2f\3\2\2\2\u0c32\u0c35\5\u0164\u00b3\2\u0c33\u0c35\5\u0126\u0094\2"+
		"\u0c34\u0c32\3\2\2\2\u0c34\u0c33\3\2\2\2\u0c35\u0163\3\2\2\2\u0c36\u0c3f"+
		"\5\u0168\u00b5\2\u0c37\u0c38\5\u0126\u0094\2\u0c38\u0c3a\7>\2\2\u0c39"+
		"\u0c3b\t\35\2\2\u0c3a\u0c39\3\2\2\2\u0c3a\u0c3b\3\2\2\2\u0c3b\u0c3c\3"+
		"\2\2\2\u0c3c\u0c3d\5\u0166\u00b4\2\u0c3d\u0c3f\3\2\2\2\u0c3e\u0c36\3\2"+
		"\2\2\u0c3e\u0c37\3\2\2\2\u0c3f\u0c47\3\2\2\2\u0c40\u0c42\7>\2\2\u0c41"+
		"\u0c43\t\35\2\2\u0c42\u0c41\3\2\2\2\u0c42\u0c43\3\2\2\2\u0c43\u0c44\3"+
		"\2\2\2\u0c44\u0c46\5\u0166\u00b4\2\u0c45\u0c40\3\2\2\2\u0c46\u0c49\3\2"+
		"\2\2\u0c47\u0c45\3\2\2\2\u0c47\u0c48\3\2\2\2\u0c48\u0165\3\2\2\2\u0c49"+
		"\u0c47\3\2\2\2\u0c4a\u0c4d\5\u0168\u00b5\2\u0c4b\u0c4d\5\u0126\u0094\2"+
		"\u0c4c\u0c4a\3\2\2\2\u0c4c\u0c4b\3\2\2\2\u0c4d\u0167\3\2\2\2\u0c4e\u0c54"+
		"\5\u016a\u00b6\2\u0c4f\u0c50\7\u0136\2\2\u0c50\u0c51\5\u0160\u00b1\2\u0c51"+
		"\u0c52\7\u0137\2\2\u0c52\u0c54\3\2\2\2\u0c53\u0c4e\3\2\2\2\u0c53\u0c4f"+
		"\3\2\2\2\u0c54\u0169\3\2\2\2\u0c55\u0c58\5\u0172\u00ba\2\u0c56\u0c58\5"+
		"\u016c\u00b7\2\u0c57\u0c55\3\2\2\2\u0c57\u0c56\3\2\2\2\u0c58\u016b\3\2"+
		"\2\2\u0c59\u0c5a\7o\2\2\u0c5a\u0c5b\5\u016e\u00b8\2\u0c5b\u016d\3\2\2"+
		"\2\u0c5c\u0c5f\5\u0170\u00b9\2\u0c5d\u0c5f\5t;\2\u0c5e\u0c5c\3\2\2\2\u0c5e"+
		"\u0c5d\3\2\2\2\u0c5f\u016f\3\2\2\2\u0c60\u0c67\5t;\2\u0c61\u0c62\7\u013d"+
		"\2\2\u0c62\u0c65\5t;\2\u0c63\u0c64\7\u013d\2\2\u0c64\u0c66\5t;\2\u0c65"+
		"\u0c63\3\2\2\2\u0c65\u0c66\3\2\2\2\u0c66\u0c68\3\2\2\2\u0c67\u0c61\3\2"+
		"\2\2\u0c67\u0c68\3\2\2\2\u0c68\u0171\3\2\2\2\u0c69\u0c6b\7i\2\2\u0c6a"+
		"\u0c6c\5\u017c\u00bf\2\u0c6b\u0c6a\3\2\2\2\u0c6b\u0c6c\3\2\2\2\u0c6c\u0c6d"+
		"\3\2\2\2\u0c6d\u0c6f\5\u0174\u00bb\2\u0c6e\u0c70\5\u011e\u0090\2\u0c6f"+
		"\u0c6e\3\2\2\2\u0c6f\u0c70\3\2\2\2\u0c70\u0173\3\2\2\2\u0c71\u0c76\5\u0176"+
		"\u00bc\2\u0c72\u0c73\7\u012f\2\2\u0c73\u0c75\5\u0176\u00bc\2\u0c74\u0c72"+
		"\3\2\2\2\u0c75\u0c78\3\2\2\2\u0c76\u0c74\3\2\2\2\u0c76\u0c77\3\2\2\2\u0c77"+
		"\u0175\3\2\2\2\u0c78\u0c76\3\2\2\2\u0c79\u0c7c\5\u0178\u00bd\2\u0c7a\u0c7c"+
		"\5\u017a\u00be\2\u0c7b\u0c79\3\2\2\2\u0c7b\u0c7a\3\2\2\2\u0c7c\u0177\3"+
		"\2\2\2\u0c7d\u0c7f\5\u00d6l\2\u0c7e\u0c80\5\u0180\u00c1\2\u0c7f\u0c7e"+
		"\3\2\2\2\u0c7f\u0c80\3\2\2\2\u0c80\u0179\3\2\2\2\u0c81\u0c82\7\u0148\2"+
		"\2\u0c82\u0c84\7\u013d\2\2\u0c83\u0c81\3\2\2\2\u0c83\u0c84\3\2\2\2\u0c84"+
		"\u0c85\3\2\2\2\u0c85\u0c86\7\u013a\2\2\u0c86\u017b\3\2\2\2\u0c87\u0c88"+
		"\t\35\2\2\u0c88\u017d\3\2\2\2\u0c89\u0c8a\5t;\2\u0c8a\u0c8b\7\u013d\2"+
		"\2\u0c8b\u0c8d\3\2\2\2\u0c8c\u0c89\3\2\2\2\u0c8c\u0c8d\3\2\2\2\u0c8d\u0c8e"+
		"\3\2\2\2\u0c8e\u0c8f\5t;\2\u0c8f\u017f\3\2\2\2\u0c90\u0c92\7\5\2\2\u0c91"+
		"\u0c90\3\2\2\2\u0c91\u0c92\3\2\2\2\u0c92\u0c93\3\2\2\2\u0c93\u0c94\5t"+
		";\2\u0c94\u0181\3\2\2\2\u0c95\u0c9a\5\u017e\u00c0\2\u0c96\u0c97\7\u012f"+
		"\2\2\u0c97\u0c99\5\u017e\u00c0\2\u0c98\u0c96\3\2\2\2\u0c99\u0c9c\3\2\2"+
		"\2\u0c9a\u0c98\3\2\2\2\u0c9a\u0c9b\3\2\2\2\u0c9b\u0183\3\2\2\2\u0c9c\u0c9a"+
		"\3\2\2\2\u0c9d\u0c9e\5\u018a\u00c6\2\u0c9e\u0185\3\2\2\2\u0c9f\u0ca0\5"+
		"\u018a\u00c6\2\u0ca0\u0187\3\2\2\2\u0ca1\u0ca2\5\u018a\u00c6\2\u0ca2\u0189"+
		"\3\2\2\2\u0ca3\u0ca4\7\u0136\2\2\u0ca4\u0ca5\5\u015c\u00af\2\u0ca5\u0ca6"+
		"\7\u0137\2\2\u0ca6\u018b\3\2\2\2\u0ca7\u0cae\5\u018e\u00c8\2\u0ca8\u0cae"+
		"\5\u0192\u00ca\2\u0ca9\u0cae\5\u0196\u00cc\2\u0caa\u0cae\5\u019c\u00cf"+
		"\2\u0cab\u0cae\5\u01a4\u00d3\2\u0cac\u0cae\5\u01ae\u00d8\2\u0cad\u0ca7"+
		"\3\2\2\2\u0cad\u0ca8\3\2\2\2\u0cad\u0ca9\3\2\2\2\u0cad\u0caa\3\2\2\2\u0cad"+
		"\u0cab\3\2\2\2\u0cad\u0cac\3\2\2\2\u0cae\u018d\3\2\2\2\u0caf\u0cb0\5\u011a"+
		"\u008e\2\u0cb0\u0cb1\5\u0190\u00c9\2\u0cb1\u0cb2\5\u011a\u008e\2\u0cb2"+
		"\u018f\3\2\2\2\u0cb3\u0cb4\t\36\2\2\u0cb4\u0191\3\2\2\2\u0cb5\u0cb6\5"+
		"\u011a\u008e\2\u0cb6\u0cb7\5\u0194\u00cb\2\u0cb7\u0193\3\2\2\2\u0cb8\u0cba"+
		"\7L\2\2\u0cb9\u0cb8\3\2\2\2\u0cb9\u0cba\3\2\2\2\u0cba\u0cbb\3\2\2\2\u0cbb"+
		"\u0cbd\7\u0084\2\2\u0cbc\u0cbe\t\37\2\2\u0cbd\u0cbc\3\2\2\2\u0cbd\u0cbe"+
		"\3\2\2\2\u0cbe\u0cbf\3\2\2\2\u0cbf\u0cc0\5\u011a\u008e\2\u0cc0\u0cc1\7"+
		"\7\2\2\u0cc1\u0cc2\5\u011a\u008e\2\u0cc2\u0195\3\2\2\2\u0cc3\u0cc5\5\u00da"+
		"n\2\u0cc4\u0cc6\7L\2\2\u0cc5\u0cc4\3\2\2\2\u0cc5\u0cc6\3\2\2\2\u0cc6\u0cc7"+
		"\3\2\2\2\u0cc7\u0cc8\79\2\2\u0cc8\u0cc9\5\u0198\u00cd\2\u0cc9\u0197\3"+
		"\2\2\2\u0cca\u0cd0\5\u0188\u00c5\2\u0ccb\u0ccc\7\u0136\2\2\u0ccc\u0ccd"+
		"\5\u019a\u00ce\2\u0ccd\u0cce\7\u0137\2\2\u0cce\u0cd0\3\2\2\2\u0ccf\u0cca"+
		"\3\2\2\2\u0ccf\u0ccb\3\2\2\2\u0cd0\u0199\3\2\2\2\u0cd1\u0cd6\5\u0114\u008b"+
		"\2\u0cd2\u0cd3\7\u012f\2\2\u0cd3\u0cd5\5\u0114\u008b\2\u0cd4\u0cd2\3\2"+
		"\2\2\u0cd5\u0cd8\3\2\2\2\u0cd6\u0cd4\3\2\2\2\u0cd6\u0cd7\3\2\2\2\u0cd7"+
		"\u019b\3\2\2\2\u0cd8\u0cd6\3\2\2\2\u0cd9\u0cda\5\u011a\u008e\2\u0cda\u0cdb"+
		"\5\u019e\u00d0\2\u0cdb\u0cdc\7\u0149\2\2\u0cdc\u019d\3\2\2\2\u0cdd\u0cdf"+
		"\7L\2\2\u0cde\u0cdd\3\2\2\2\u0cde\u0cdf\3\2\2\2\u0cdf\u0ce0\3\2\2\2\u0ce0"+
		"\u0ce3\5\u01a0\u00d1\2\u0ce1\u0ce3\5\u01a2\u00d2\2\u0ce2\u0cde\3\2\2\2"+
		"\u0ce2\u0ce1\3\2\2\2\u0ce3\u019f\3\2\2\2\u0ce4\u0ceb\7H\2\2\u0ce5\u0ceb"+
		"\7\66\2\2\u0ce6\u0ce7\7\u00e1\2\2\u0ce7\u0ceb\7\u00f2\2\2\u0ce8\u0ceb"+
		"\7\u00d9\2\2\u0ce9\u0ceb\7\u00da\2\2\u0cea\u0ce4\3\2\2\2\u0cea\u0ce5\3"+
		"\2\2\2\u0cea\u0ce6\3\2\2\2\u0cea\u0ce8\3\2\2\2\u0cea\u0ce9\3\2\2\2\u0ceb"+
		"\u01a1\3\2\2\2\u0cec\u0ced\t \2\2\u0ced\u01a3\3\2\2\2\u0cee\u0cef\5\u011a"+
		"\u008e\2\u0cef\u0cf1\7C\2\2\u0cf0\u0cf2\7L\2\2\u0cf1\u0cf0\3\2\2\2\u0cf1"+
		"\u0cf2\3\2\2\2\u0cf2\u0cf3\3\2\2\2\u0cf3\u0cf4\7M\2\2\u0cf4\u01a5\3\2"+
		"\2\2\u0cf5\u0cf6\5\u00dan\2\u0cf6\u0cf7\5\u0190\u00c9\2\u0cf7\u0cf8\5"+
		"\u01a8\u00d5\2\u0cf8\u0cf9\5\u0188\u00c5\2\u0cf9\u01a7\3\2\2\2\u0cfa\u0cfd"+
		"\5\u01aa\u00d6\2\u0cfb\u0cfd\5\u01ac\u00d7\2\u0cfc\u0cfa\3\2\2\2\u0cfc"+
		"\u0cfb\3\2\2\2\u0cfd\u01a9\3\2\2\2\u0cfe\u0cff\7\6\2\2\u0cff\u01ab\3\2"+
		"\2\2\u0d00\u0d01\t!\2\2\u0d01\u01ad\3\2\2\2\u0d02\u0d04\7L\2\2\u0d03\u0d02"+
		"\3\2\2\2\u0d03\u0d04\3\2\2\2\u0d04\u0d05\3\2\2\2\u0d05\u0d06\7\u00a3\2"+
		"\2\u0d06\u0d07\5\u0188\u00c5\2\u0d07\u01af\3\2\2\2\u0d08\u0d09\7x\2\2"+
		"\u0d09\u0d0a\5\u0188\u00c5\2\u0d0a\u01b1\3\2\2\2\u0d0b\u0d0e\5\u01b4\u00db"+
		"\2\u0d0c\u0d0e\7\u00dd\2\2\u0d0d\u0d0b\3\2\2\2\u0d0d\u0d0c\3\2\2\2\u0d0e"+
		"\u01b3\3\2\2\2\u0d0f\u0d10\t\"\2\2\u0d10\u01b5\3\2\2\2\u0d11\u0d12\t#"+
		"\2\2\u0d12\u01b7\3\2\2\2\u0d13\u0d14\5\u01bc\u00df\2\u0d14\u0d16\7\u0136"+
		"\2\2\u0d15\u0d17\5\u01be\u00e0\2\u0d16\u0d15\3\2\2\2\u0d16\u0d17\3\2\2"+
		"\2\u0d17\u0d18\3\2\2\2\u0d18\u0d19\7\u0137\2\2\u0d19\u01b9\3\2\2\2\u0d1a"+
		"\u0d1b\t$\2\2\u0d1b\u01bb\3\2\2\2\u0d1c\u0d1f\5t;\2\u0d1d\u0d1f\5\u01ba"+
		"\u00de\2\u0d1e\u0d1c\3\2\2\2\u0d1e\u0d1d\3\2\2\2\u0d1f\u01bd\3\2\2\2\u0d20"+
		"\u0d25\5\u00d6l\2\u0d21\u0d22\7\u012f\2\2\u0d22\u0d24\5\u00d6l\2\u0d23"+
		"\u0d21\3\2\2\2\u0d24\u0d27\3\2\2\2\u0d25\u0d23\3\2\2\2\u0d25\u0d26\3\2"+
		"\2\2\u0d26\u01bf\3\2\2\2\u0d27\u0d25\3\2\2\2\u0d28\u0d29\7U\2\2\u0d29"+
		"\u0d2a\7\u0085\2\2\u0d2a\u0d2b\5\u01c2\u00e2\2\u0d2b\u01c1\3\2\2\2\u0d2c"+
		"\u0d31\5\u01c4\u00e3\2\u0d2d\u0d2e\7\u012f\2\2\u0d2e\u0d30\5\u01c4\u00e3"+
		"\2\u0d2f\u0d2d\3\2\2\2\u0d30\u0d33\3\2\2\2\u0d31\u0d2f\3\2\2\2\u0d31\u0d32"+
		"\3\2\2\2\u0d32\u01c3\3\2\2\2\u0d33\u0d31\3\2\2\2\u0d34\u0d36\5\u011a\u008e"+
		"\2\u0d35\u0d37\5\u01c6\u00e4\2\u0d36\u0d35\3\2\2\2\u0d36\u0d37\3\2\2\2"+
		"\u0d37\u0d39\3\2\2\2\u0d38\u0d3a\5\u01ca\u00e6\2\u0d39\u0d38\3\2\2\2\u0d39"+
		"\u0d3a\3\2\2\2\u0d3a\u01c5\3\2\2\2\u0d3b\u0d3c\t%\2\2\u0d3c\u01c7\3\2"+
		"\2\2\u0d3d\u0d3e\7I\2\2\u0d3e\u0d3f\5\u00dan\2\u0d3f\u01c9\3\2\2\2\u0d40"+
		"\u0d41\7M\2\2\u0d41\u0d45\7\u00a8\2\2\u0d42\u0d43\7M\2\2\u0d43\u0d45\7"+
		"\u00ba\2\2\u0d44\u0d40\3\2\2\2\u0d44\u0d42\3\2\2\2\u0d45\u01cb\3\2\2\2"+
		"\u0d46\u0d48\7\u00b2\2\2\u0d47\u0d49\7\u00cf\2\2\u0d48\u0d47\3\2\2\2\u0d48"+
		"\u0d49\3\2\2\2\u0d49\u0d4a\3\2\2\2\u0d4a\u0d4b\7?\2\2\u0d4b\u0d50\5\u0170"+
		"\u00b9\2\u0d4c\u0d4d\7\u0136\2\2\u0d4d\u0d4e\5\u0140\u00a1\2\u0d4e\u0d4f"+
		"\7\u0137\2\2\u0d4f\u0d51\3\2\2\2\u0d50\u0d4c\3\2\2\2\u0d50\u0d51\3\2\2"+
		"\2\u0d51\u0d52\3\2\2\2\u0d52\u0d53\5\u015c\u00af\2\u0d53\u0d64\3\2\2\2"+
		"\u0d54\u0d56\7\u00b2\2\2\u0d55\u0d57\7\u00cf\2\2\u0d56\u0d55\3\2\2\2\u0d56"+
		"\u0d57\3\2\2\2\u0d57\u0d58\3\2\2\2\u0d58\u0d59\7?\2\2\u0d59\u0d5a\7\u00bd"+
		"\2\2\u0d5a\u0d60\7\u0149\2\2\u0d5b\u0d5c\7{\2\2\u0d5c\u0d5e\5t;\2\u0d5d"+
		"\u0d5f\5N(\2\u0d5e\u0d5d\3\2\2\2\u0d5e\u0d5f\3\2\2\2\u0d5f\u0d61\3\2\2"+
		"\2\u0d60\u0d5b\3\2\2\2\u0d60\u0d61\3\2\2\2\u0d61\u0d62\3\2\2\2\u0d62\u0d64"+
		"\5\u015c\u00af\2\u0d63\u0d46\3\2\2\2\u0d63\u0d54\3\2\2\2\u0d64\u01cd\3"+
		"\2\2\2\u01ea\u01d0\u01d4\u01e6\u01ee\u01f2\u01f9\u01ff\u0206\u020a\u020e"+
		"\u0212\u0216\u021a\u0224\u0227\u022b\u022f\u0236\u0239\u023d\u023f\u0243"+
		"\u024b\u0254\u0258\u025a\u025c\u0262\u0267\u026d\u0271\u0275\u0279\u0281"+
		"\u0283\u028b\u0290\u0294\u0296\u029a\u029f\u02a8\u02aa\u02b2\u02b8\u02bc"+
		"\u02c2\u02c6\u02cb\u02cf\u02d3\u02d7\u02db\u02df\u02e7\u02ec\u02f0\u02f2"+
		"\u02f8\u02fc\u0304\u0308\u030a\u0312\u0317\u031b\u031d\u0323\u0327\u032f"+
		"\u0334\u0336\u033e\u0342\u034a\u034f\u0351\u0358\u035c\u0364\u0369\u036b"+
		"\u0370\u0378\u037d\u037f\u0385\u0389\u0391\u0396\u0398\u039a\u039e\u03a0"+
		"\u03a7\u03ab\u03b3\u03b7\u03bb\u03bf\u03c1\u03c7\u03cb\u03d3\u03d8\u03da"+
		"\u03e0\u03e4\u03ec\u03f0\u03f4\u03f9\u03fd\u0400\u0402\u0406\u040b\u040d"+
		"\u040f\u0412\u0418\u041c\u041e\u0422\u0426\u042a\u0432\u0436\u0438\u0440"+
		"\u0444\u0448\u044c\u0450\u0454\u0456\u045a\u045e\u0462\u0469\u046d\u0471"+
		"\u0473\u0479\u047d\u0485\u0489\u048b\u0492\u0496\u049a\u049c\u04a2\u04a6"+
		"\u04ae\u04b0\u04b8\u04bc\u04c4\u04c6\u04cd\u04d1\u04d9\u04db\u04e0\u04e8"+
		"\u04ea\u04f0\u04f4\u04fb\u04ff\u0503\u0505\u050c\u0510\u0517\u051b\u051f"+
		"\u0521\u0527\u052b\u0533\u0535\u053b\u053f\u0545\u0549\u054e\u0552\u0557"+
		"\u0559\u055d\u0561\u0564\u0568\u056d\u0576\u057a\u05b9\u05e7\u05ef\u05f5"+
		"\u05f8\u05fe\u0601\u0605\u0611\u0615\u0619\u062c\u0631\u0641\u0647\u0650"+
		"\u0652\u0658\u065c\u0660\u0666\u0673\u0676\u067a\u067e\u0689\u068d\u0691"+
		"\u0697\u069e\u06a4\u06a8\u06ae\u06b5\u06b7\u06b9\u06c1\u06c6\u06d0\u06db"+
		"\u06e4\u06e9\u06ec\u06f2\u06f6\u06fe\u0702\u0706\u0715\u0718\u0723\u0726"+
		"\u0729\u072d\u0734\u0737\u073a\u0741\u0745\u074b\u0753\u0758\u0761\u0764"+
		"\u0767\u076b\u076d\u0774\u0778\u077c\u0784\u0788\u078e\u079a\u079e\u07a1"+
		"\u07a5\u07a9\u07af\u07b6\u07bd\u07c1\u07cb\u07cf\u07d7\u07de\u07e2\u07eb"+
		"\u07f2\u07f6\u07fe\u0802\u0806\u080e\u0813\u0818\u081a\u081f\u0825\u0829"+
		"\u083f\u0844\u0849\u084b\u0850\u0856\u0862\u0865\u0869\u0872\u087b\u087d"+
		"\u0881\u0889\u088c\u0892\u089a\u08ab\u08c0\u08d1\u08de\u08e2\u08e4\u08f1"+
		"\u08f8\u0910\u0917\u0928\u092b\u092f\u0932\u0936\u0938\u093e\u0943\u0948"+
		"\u0963\u096b\u096f\u0974\u0979\u097d\u0980\u0989\u098e\u0992\u0998\u099e"+
		"\u09a3\u09a7\u09a9\u09ad\u09b1\u09b3\u09b7\u09bb\u09bf\u09c3\u09ce\u09d2"+
		"\u09da\u09e4\u09f5\u09f9\u09fd\u0a02\u0a04\u0a08\u0a0d\u0a11\u0a13\u0a17"+
		"\u0a24\u0a2b\u0a37\u0a39\u0a3e\u0a60\u0a64\u0a68\u0a6f\u0a72\u0a7a\u0a7d"+
		"\u0a90\u0aa0\u0aa5\u0aac\u0ab4\u0ab8\u0ac2\u0acc\u0ad0\u0ae0\u0ae6\u0aef"+
		"\u0af6\u0b00\u0b03\u0b06\u0b0d\u0b18\u0b20\u0b26\u0b2a\u0b2e\u0b36\u0b3a"+
		"\u0b42\u0b4a\u0b4e\u0b52\u0b55\u0b58\u0b5b\u0b5e\u0b68\u0b6d\u0b73\u0b79"+
		"\u0b81\u0b88\u0b8f\u0b97\u0ba2\u0ba6\u0bac\u0bb8\u0bbb\u0bc1\u0bc5\u0bcc"+
		"\u0bce\u0bd5\u0be8\u0bef\u0bf6\u0bfd\u0c15\u0c1c\u0c22\u0c26\u0c2a\u0c2f"+
		"\u0c34\u0c3a\u0c3e\u0c42\u0c47\u0c4c\u0c53\u0c57\u0c5e\u0c65\u0c67\u0c6b"+
		"\u0c6f\u0c76\u0c7b\u0c7f\u0c83\u0c8c\u0c91\u0c9a\u0cad\u0cb9\u0cbd\u0cc5"+
		"\u0ccf\u0cd6\u0cde\u0ce2\u0cea\u0cf1\u0cfc\u0d03\u0d0d\u0d16\u0d1e\u0d25"+
		"\u0d31\u0d36\u0d39\u0d44\u0d48\u0d50\u0d56\u0d5e\u0d60\u0d63";
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