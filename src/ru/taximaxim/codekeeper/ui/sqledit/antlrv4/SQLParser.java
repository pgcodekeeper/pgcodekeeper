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
		ILIKE=52, Character_String_Literal=326, NOT=74, EXCEPT=35, FOREIGN=42, 
		CACHE=133, PRIVILEGES=87, BYTEA=289, MONTH=198, STATEMENT=106, CHARACTER=137, 
		TYPE=117, BlockComment=323, VARBIT=258, STDDEV_POP=229, CREATE=21, COMMENTS=143, 
		ESC_SEQUENCES=327, USING=122, UNLOGGED=243, NOT_EQUAL=302, TIMEZONE_MINUTE=239, 
		VERTICAL_BAR=316, VARIADIC=123, TIMESTAMPTZ=284, REGEXP=216, FAMILY=165, 
		GEQ=306, STDDEV_SAMP=230, DIVIDE=312, BLOB=288, STRICT=107, PRESERVE=85, 
		ASC=8, GROUPING=170, SUBPARTITION=231, KEY=67, TEMP=110, ELSE=34, NUMBER=321, 
		BOOL=256, TRAILING=113, DEFINER=155, SEMI_COLON=299, INT=265, RLIKE=217, 
		RESTRICT=95, LEADING=68, SERVER=222, PROCEDURAL=89, TABLESPACE=233, MILLISECONDS=194, 
		REAL=270, INTERSECT=60, GROUP=49, LANGUAGE=183, SEQUENCES=102, OUT=80, 
		REAL_NUMBER=322, NONE=201, TRIM=240, LEFT_PAREN=307, LOCATION=188, SEARCH=219, 
		END=33, CONSTRAINT=18, TIMEZONE_HOUR=238, CAST_EXPRESSION=295, OPTION=204, 
		ISOYEAR=181, NCHAR=278, EXECUTE=38, INPUT=176, TABLE=109, VARCHAR=277, 
		FLOAT=272, VERSION=248, IMMUTABLE=54, MICROSECONDS=192, ASYMMETRIC=7, 
		SUM=232, OWNED=84, Space=328, INOUT=62, STORAGE=228, TIME=281, AS=3, RIGHT_PAREN=308, 
		THEN=112, COLLATION=16, MAXVALUE=191, REPLACE=94, LEFT=69, AVG=130, ZONE=254, 
		TRUNCATE=116, COLUMN=141, PLUS=309, EXISTS=162, NVARCHAR=279, Not_Similar_To=292, 
		RETURNS=96, LIKE=70, COLLATE=15, INTEGER=266, OUTER=79, BY=132, DEFERRABLE=26, 
		TO=241, SET=223, RIGHT=98, HAVING=50, MIN=195, SESSION=104, MINUS=310, 
		TEXT=285, HOUR=172, CONCATENATION_OPERATOR=301, CONVERSION=20, UNION=118, 
		CURRENT=149, COLON=298, COMMIT=144, SCHEMA=100, DATABASE=23, DECIMAL=275, 
		DROP=159, BIGINT=267, WHEN=125, ROWS=92, START=227, BIT=257, LARGE=184, 
		REVOKE=97, NATURAL=73, FORMAT=168, PUBLIC=212, AGGREGATE=1, EXTENSION=39, 
		BETWEEN=131, OPTIONS=205, FIRST=167, CAST=14, WEEK=250, EXTERNAL=163, 
		DOUBLE_QUOTE=318, VARYING=247, TRIGGER=114, CASE=12, CHAR=276, INT8=262, 
		COUNT=147, DAY=152, CASCADE=13, COST=146, INT2=260, INT1=259, Identifier=325, 
		INT4=261, ISCACHABLE=179, QUOTE=317, MODULAR=313, INVOKER=64, FULL=43, 
		DICTIONARY=156, THAN=236, QUARTER=214, INSERT=177, INHERITS=57, CONNECT=17, 
		INTERSECTION=178, LESS=186, TINYINT=263, BOTH=11, Similar_To_Case_Insensitive=293, 
		DOUBLE=273, ADMIN=129, SYMMETRIC=108, ISSTRICT=182, EACH=32, LAST=185, 
		COMMENT=142, SELECT=103, INTO=61, UNIQUE=119, COALESCE=140, SECOND=220, 
		ROLE=90, RULE=99, VIEW=124, EPOCH=160, ROLLUP=218, NULL=75, WITHOUT=128, 
		NO=200, EVERY=161, ON=78, MATCH=189, PRIMARY=86, DELETE=28, INET4=290, 
		NUMERIC=274, LOCAL=72, OF=76, EXCLUDING=37, LIST=187, TABLES=234, UNDERLINE=315, 
		SEQUENCE=101, Not_Similar_To_Case_Insensitive=294, CUBE=148, NATIONAL=199, 
		CALLED=134, VAR_POP=246, OR=82, FILTER=166, CHECK=138, FROM=46, FALSE=40, 
		COLLECT=139, PARSER=207, DISTINCT=30, TEMPORARY=111, TIMESTAMP=283, SIMPLE=225, 
		DOLLAR=319, CONSTRAINTS=19, WHERE=126, DEC=153, VAR_SAMP=245, NULLIF=202, 
		CLASS=135, TIMETZ=282, INNER=59, YEAR=253, TIMEZONE=237, ORDER=83, AUTHORIZATION=9, 
		LIMIT=71, DECADE=154, GTH=305, CYCLE=150, White_Space=329, UPDATE=120, 
		MAX=190, LineComment=324, DEFERRED=27, FOR=41, FLOAT4=268, CONFIGURATION=145, 
		FLOAT8=269, AND=5, CROSS=22, Similar_To=291, USAGE=121, IF=51, INDEX=173, 
		OIDS=77, BOOLEAN=255, IN=55, MINVALUE=196, UNKNOWN=242, MULTIPLY=311, 
		OBJECT=203, COMMA=300, REFERENCES=93, PARTITION=209, IS=65, PARTITIONS=210, 
		SOME=105, EQUAL=297, ALL=4, DOUBLE_DOLLAR=320, DOT=314, EXTRACT=164, CENTURY=136, 
		STABLE=226, SECURITY=221, PARTIAL=208, DOW=157, EXCLUDE=36, WITH=127, 
		INITIALLY=58, DOY=158, FUSION=169, GRANT=48, VARBINARY=287, VOLATILE=249, 
		OPERATOR=81, DEFAULT=24, VALUES=244, HASH=171, RANGE=215, MILLENNIUM=193, 
		INDEXES=174, PURGE=213, BEFORE=10, AFTER=2, INSTEAD=63, WRAPPER=252, TRUE=115, 
		PROCEDURE=88, JOIN=66, SIMILAR=224, DOMAIN=31, DEFAULTS=25, LTH=303, INCREMENT=175, 
		ANY=6, TEMPLATE=235, BAD=330, ASSIGN=296, REGCLASS=271, IMMEDIATE=53, 
		WINDOW=251, BINARY=286, DESC=29, DATE=280, MINUTE=197, GLOBAL=47, DATA=151, 
		INCLUDING=56, LEQ=304, SMALLINT=264;
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
		"TEMPORARY", "THEN", "TRAILING", "TRIGGER", "TRUE", "TRUNCATE", "TYPE", 
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
		"UNKNOWN", "UNLOGGED", "VALUES", "VAR_SAMP", "VAR_POP", "VARYING", "VERSION", 
		"VOLATILE", "WEEK", "WINDOW", "WRAPPER", "YEAR", "ZONE", "BOOLEAN", "BOOL", 
		"BIT", "VARBIT", "INT1", "INT2", "INT4", "INT8", "TINYINT", "SMALLINT", 
		"INT", "INTEGER", "BIGINT", "FLOAT4", "FLOAT8", "REAL", "REGCLASS", "FLOAT", 
		"DOUBLE", "NUMERIC", "DECIMAL", "CHAR", "VARCHAR", "NCHAR", "NVARCHAR", 
		"DATE", "TIME", "TIMETZ", "TIMESTAMP", "TIMESTAMPTZ", "TEXT", "BINARY", 
		"VARBINARY", "BLOB", "BYTEA", "INET4", "'~'", "'!~'", "'~*'", "'!~*'", 
		"CAST_EXPRESSION", "':='", "'='", "':'", "';'", "','", "CONCATENATION_OPERATOR", 
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
		RULE_create_schema_statement = 21, RULE_create_table_statement = 22, RULE_like_option = 23, 
		RULE_table_constraint = 24, RULE_column_constraint = 25, RULE_check_boolean_expression = 26, 
		RULE_storage_parameter = 27, RULE_storage_parameter_oid = 28, RULE_on_commit = 29, 
		RULE_table_space = 30, RULE_action = 31, RULE_index_parameters = 32, RULE_table_elements = 33, 
		RULE_field_element = 34, RULE_field_type = 35, RULE_param_clause = 36, 
		RULE_param = 37, RULE_method_specifier = 38, RULE_table_space_specifier = 39, 
		RULE_table_space_name = 40, RULE_table_partitioning_clauses = 41, RULE_range_partitions = 42, 
		RULE_range_value_clause_list = 43, RULE_range_value_clause = 44, RULE_hash_partitions = 45, 
		RULE_individual_hash_partitions = 46, RULE_individual_hash_partition = 47, 
		RULE_hash_partitions_by_quantity = 48, RULE_list_partitions = 49, RULE_list_value_clause_list = 50, 
		RULE_list_value_partition = 51, RULE_column_partitions = 52, RULE_partition_name = 53, 
		RULE_drop_table_statement = 54, RULE_identifier = 55, RULE_nonreserved_keywords = 56, 
		RULE_unsigned_literal = 57, RULE_general_literal = 58, RULE_datetime_literal = 59, 
		RULE_time_literal = 60, RULE_timestamp_literal = 61, RULE_date_literal = 62, 
		RULE_boolean_literal = 63, RULE_data_type = 64, RULE_predefined_type = 65, 
		RULE_regclass = 66, RULE_network_type = 67, RULE_character_string_type = 68, 
		RULE_type_length = 69, RULE_national_character_string_type = 70, RULE_binary_large_object_string_type = 71, 
		RULE_numeric_type = 72, RULE_exact_numeric_type = 73, RULE_approximate_numeric_type = 74, 
		RULE_precision_param = 75, RULE_boolean_type = 76, RULE_datetime_type = 77, 
		RULE_bit_type = 78, RULE_binary_type = 79, RULE_value_expression_primary = 80, 
		RULE_parenthesized_value_expression = 81, RULE_nonparenthesized_value_expression_primary = 82, 
		RULE_unsigned_value_specification = 83, RULE_unsigned_numeric_literal = 84, 
		RULE_signed_numerical_literal = 85, RULE_set_function_specification = 86, 
		RULE_aggregate_function = 87, RULE_general_set_function = 88, RULE_set_function_type = 89, 
		RULE_filter_clause = 90, RULE_grouping_operation = 91, RULE_case_expression = 92, 
		RULE_case_abbreviation = 93, RULE_case_specification = 94, RULE_simple_case = 95, 
		RULE_searched_case = 96, RULE_simple_when_clause = 97, RULE_searched_when_clause = 98, 
		RULE_else_clause = 99, RULE_result = 100, RULE_cast_specification = 101, 
		RULE_cast_operand = 102, RULE_cast_target = 103, RULE_value_expression = 104, 
		RULE_common_value_expression = 105, RULE_numeric_value_expression = 106, 
		RULE_term = 107, RULE_factor = 108, RULE_array = 109, RULE_numeric_primary = 110, 
		RULE_sign = 111, RULE_numeric_value_function = 112, RULE_extract_expression = 113, 
		RULE_extract_field = 114, RULE_time_zone_field = 115, RULE_extract_source = 116, 
		RULE_string_value_expression = 117, RULE_character_value_expression = 118, 
		RULE_character_factor = 119, RULE_character_primary = 120, RULE_string_value_function = 121, 
		RULE_trim_function = 122, RULE_trim_operands = 123, RULE_trim_specification = 124, 
		RULE_boolean_value_expression = 125, RULE_or_predicate = 126, RULE_and_predicate = 127, 
		RULE_boolean_factor = 128, RULE_boolean_test = 129, RULE_is_clause = 130, 
		RULE_truth_value = 131, RULE_boolean_primary = 132, RULE_boolean_predicand = 133, 
		RULE_parenthesized_boolean_value_expression = 134, RULE_row_value_expression = 135, 
		RULE_row_value_special_case = 136, RULE_explicit_row_value_constructor = 137, 
		RULE_row_value_predicand = 138, RULE_row_value_constructor_predicand = 139, 
		RULE_table_expression = 140, RULE_from_clause = 141, RULE_table_reference_list = 142, 
		RULE_table_reference = 143, RULE_joined_table = 144, RULE_joined_table_primary = 145, 
		RULE_cross_join = 146, RULE_qualified_join = 147, RULE_natural_join = 148, 
		RULE_union_join = 149, RULE_join_type = 150, RULE_outer_join_type = 151, 
		RULE_outer_join_type_part2 = 152, RULE_join_specification = 153, RULE_join_condition = 154, 
		RULE_named_columns_join = 155, RULE_table_primary = 156, RULE_column_name_list = 157, 
		RULE_derived_table = 158, RULE_where_clause = 159, RULE_search_condition = 160, 
		RULE_groupby_clause = 161, RULE_grouping_element_list = 162, RULE_grouping_element = 163, 
		RULE_ordinary_grouping_set = 164, RULE_ordinary_grouping_set_list = 165, 
		RULE_rollup_list = 166, RULE_cube_list = 167, RULE_empty_grouping_set = 168, 
		RULE_having_clause = 169, RULE_row_value_predicand_list = 170, RULE_query_expression = 171, 
		RULE_query_expression_body = 172, RULE_non_join_query_expression = 173, 
		RULE_query_term = 174, RULE_non_join_query_term = 175, RULE_query_primary = 176, 
		RULE_non_join_query_primary = 177, RULE_simple_table = 178, RULE_explicit_table = 179, 
		RULE_table_or_query_name = 180, RULE_schema_qualified_name = 181, RULE_query_specification = 182, 
		RULE_select_list = 183, RULE_select_sublist = 184, RULE_derived_column = 185, 
		RULE_qualified_asterisk = 186, RULE_set_qualifier = 187, RULE_column_reference = 188, 
		RULE_as_clause = 189, RULE_column_reference_list = 190, RULE_scalar_subquery = 191, 
		RULE_row_subquery = 192, RULE_table_subquery = 193, RULE_subquery = 194, 
		RULE_predicate = 195, RULE_comparison_predicate = 196, RULE_comp_op = 197, 
		RULE_between_predicate = 198, RULE_between_predicate_part_2 = 199, RULE_in_predicate = 200, 
		RULE_in_predicate_value = 201, RULE_in_value_list = 202, RULE_pattern_matching_predicate = 203, 
		RULE_pattern_matcher = 204, RULE_negativable_matcher = 205, RULE_regex_matcher = 206, 
		RULE_null_predicate = 207, RULE_quantified_comparison_predicate = 208, 
		RULE_quantifier = 209, RULE_all = 210, RULE_some = 211, RULE_exists_predicate = 212, 
		RULE_unique_predicate = 213, RULE_primary_datetime_field = 214, RULE_non_second_primary_datetime_field = 215, 
		RULE_extended_datetime_field = 216, RULE_routine_invocation = 217, RULE_function_names_for_reserved_words = 218, 
		RULE_function_name = 219, RULE_sql_argument_list = 220, RULE_orderby_clause = 221, 
		RULE_sort_specifier_list = 222, RULE_sort_specifier = 223, RULE_order_specification = 224, 
		RULE_limit_clause = 225, RULE_null_ordering = 226, RULE_insert_statement = 227;
	public static final String[] ruleNames = {
		"sql", "statement", "data_statement", "data_change_statement", "schema_statement", 
		"index_statement", "create_extension_statement", "set_statement", "create_trigger_statement", 
		"revoke_statement", "revoke_from_cascade_restrict", "grant_statement", 
		"grant_to_rule", "comment_on_statement", "create_function_statement", 
		"function_body", "function_attribute", "argmode", "function_definition", 
		"functions_definition_schema", "create_sequence_statement", "create_schema_statement", 
		"create_table_statement", "like_option", "table_constraint", "column_constraint", 
		"check_boolean_expression", "storage_parameter", "storage_parameter_oid", 
		"on_commit", "table_space", "action", "index_parameters", "table_elements", 
		"field_element", "field_type", "param_clause", "param", "method_specifier", 
		"table_space_specifier", "table_space_name", "table_partitioning_clauses", 
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
			setState(462);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CREATE || _la==GRANT || ((((_la - 97)) & ~0x3f) == 0 && ((1L << (_la - 97)) & ((1L << (REVOKE - 97)) | (1L << (SELECT - 97)) | (1L << (TABLE - 97)) | (1L << (ADMIN - 97)) | (1L << (AVG - 97)) | (1L << (BETWEEN - 97)) | (1L << (BY - 97)) | (1L << (CACHE - 97)) | (1L << (CALLED - 97)) | (1L << (CLASS - 97)) | (1L << (CENTURY - 97)) | (1L << (CHARACTER - 97)) | (1L << (CHECK - 97)) | (1L << (COLLECT - 97)) | (1L << (COALESCE - 97)) | (1L << (COLUMN - 97)) | (1L << (COMMENT - 97)) | (1L << (COMMENTS - 97)) | (1L << (COMMIT - 97)) | (1L << (CONFIGURATION - 97)) | (1L << (COST - 97)) | (1L << (COUNT - 97)) | (1L << (CUBE - 97)) | (1L << (CURRENT - 97)) | (1L << (CYCLE - 97)) | (1L << (DATA - 97)) | (1L << (DAY - 97)) | (1L << (DEC - 97)) | (1L << (DECADE - 97)) | (1L << (DEFINER - 97)) | (1L << (DICTIONARY - 97)) | (1L << (DOW - 97)) | (1L << (DOY - 97)) | (1L << (DROP - 97)) | (1L << (EPOCH - 97)))) != 0) || ((((_la - 161)) & ~0x3f) == 0 && ((1L << (_la - 161)) & ((1L << (EVERY - 161)) | (1L << (EXISTS - 161)) | (1L << (EXTERNAL - 161)) | (1L << (EXTRACT - 161)) | (1L << (FAMILY - 161)) | (1L << (FILTER - 161)) | (1L << (FIRST - 161)) | (1L << (FORMAT - 161)) | (1L << (FUSION - 161)) | (1L << (GROUPING - 161)) | (1L << (HASH - 161)) | (1L << (INDEX - 161)) | (1L << (INCREMENT - 161)) | (1L << (INPUT - 161)) | (1L << (INSERT - 161)) | (1L << (INTERSECTION - 161)) | (1L << (ISCACHABLE - 161)) | (1L << (ISODOW - 161)) | (1L << (ISOYEAR - 161)) | (1L << (ISSTRICT - 161)) | (1L << (LANGUAGE - 161)) | (1L << (LARGE - 161)) | (1L << (LAST - 161)) | (1L << (LESS - 161)) | (1L << (LIST - 161)) | (1L << (LOCATION - 161)) | (1L << (MATCH - 161)) | (1L << (MAX - 161)) | (1L << (MAXVALUE - 161)) | (1L << (MICROSECONDS - 161)) | (1L << (MILLENNIUM - 161)) | (1L << (MILLISECONDS - 161)) | (1L << (MIN - 161)) | (1L << (MINVALUE - 161)) | (1L << (MINUTE - 161)) | (1L << (MONTH - 161)) | (1L << (NATIONAL - 161)) | (1L << (NO - 161)) | (1L << (NONE - 161)) | (1L << (NULLIF - 161)) | (1L << (OBJECT - 161)) | (1L << (OPTION - 161)) | (1L << (OPTIONS - 161)) | (1L << (OVERWRITE - 161)) | (1L << (PARSER - 161)) | (1L << (PARTIAL - 161)) | (1L << (PARTITION - 161)) | (1L << (PARTITIONS - 161)) | (1L << (PRECISION - 161)) | (1L << (PUBLIC - 161)) | (1L << (PURGE - 161)) | (1L << (QUARTER - 161)) | (1L << (RANGE - 161)) | (1L << (REGEXP - 161)) | (1L << (RLIKE - 161)) | (1L << (ROLLUP - 161)) | (1L << (SEARCH - 161)) | (1L << (SECOND - 161)) | (1L << (SECURITY - 161)) | (1L << (SERVER - 161)) | (1L << (SET - 161)) | (1L << (SIMILAR - 161)))) != 0) || ((((_la - 225)) & ~0x3f) == 0 && ((1L << (_la - 225)) & ((1L << (SIMPLE - 225)) | (1L << (STABLE - 225)) | (1L << (START - 225)) | (1L << (STORAGE - 225)) | (1L << (STDDEV_POP - 225)) | (1L << (STDDEV_SAMP - 225)) | (1L << (SUBPARTITION - 225)) | (1L << (SUM - 225)) | (1L << (TABLESPACE - 225)) | (1L << (TEMPLATE - 225)) | (1L << (THAN - 225)) | (1L << (TIMEZONE - 225)) | (1L << (TIMEZONE_HOUR - 225)) | (1L << (TIMEZONE_MINUTE - 225)) | (1L << (TRIM - 225)) | (1L << (TO - 225)) | (1L << (UNKNOWN - 225)) | (1L << (UNLOGGED - 225)) | (1L << (VALUES - 225)) | (1L << (VAR_SAMP - 225)) | (1L << (VAR_POP - 225)) | (1L << (VARYING - 225)) | (1L << (VOLATILE - 225)) | (1L << (WEEK - 225)) | (1L << (WINDOW - 225)) | (1L << (WRAPPER - 225)) | (1L << (YEAR - 225)) | (1L << (ZONE - 225)) | (1L << (BOOLEAN - 225)) | (1L << (BOOL - 225)) | (1L << (BIT - 225)) | (1L << (VARBIT - 225)) | (1L << (INT1 - 225)) | (1L << (INT2 - 225)) | (1L << (INT4 - 225)) | (1L << (INT8 - 225)) | (1L << (TINYINT - 225)) | (1L << (SMALLINT - 225)) | (1L << (INT - 225)) | (1L << (INTEGER - 225)) | (1L << (BIGINT - 225)) | (1L << (FLOAT4 - 225)) | (1L << (FLOAT8 - 225)) | (1L << (REAL - 225)) | (1L << (FLOAT - 225)) | (1L << (DOUBLE - 225)) | (1L << (NUMERIC - 225)) | (1L << (DECIMAL - 225)) | (1L << (CHAR - 225)) | (1L << (VARCHAR - 225)) | (1L << (NCHAR - 225)) | (1L << (NVARCHAR - 225)) | (1L << (DATE - 225)) | (1L << (TIME - 225)) | (1L << (TIMETZ - 225)) | (1L << (TIMESTAMP - 225)) | (1L << (TIMESTAMPTZ - 225)) | (1L << (TEXT - 225)) | (1L << (VARBINARY - 225)) | (1L << (BLOB - 225)))) != 0) || ((((_la - 289)) & ~0x3f) == 0 && ((1L << (_la - 289)) & ((1L << (BYTEA - 289)) | (1L << (INET4 - 289)) | (1L << (LEFT_PAREN - 289)) | (1L << (QUOTE - 289)) | (1L << (Identifier - 289)))) != 0)) {
				{
				{
				setState(456); statement();
				setState(458);
				_la = _input.LA(1);
				if (_la==SEMI_COLON) {
					{
					setState(457); match(SEMI_COLON);
					}
				}

				}
				}
				setState(464);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(465); match(EOF);
			}
		}
		catch (RecognitionException re) {
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
		public Create_sequence_statementContext create_sequence_statement() {
			return getRuleContext(Create_sequence_statementContext.class,0);
		}
		public Index_statementContext index_statement() {
			return getRuleContext(Index_statementContext.class,0);
		}
		public Create_extension_statementContext create_extension_statement() {
			return getRuleContext(Create_extension_statementContext.class,0);
		}
		public Revoke_statementContext revoke_statement() {
			return getRuleContext(Revoke_statementContext.class,0);
		}
		public Data_change_statementContext data_change_statement() {
			return getRuleContext(Data_change_statementContext.class,0);
		}
		public Create_function_statementContext create_function_statement() {
			return getRuleContext(Create_function_statementContext.class,0);
		}
		public Data_statementContext data_statement() {
			return getRuleContext(Data_statementContext.class,0);
		}
		public Schema_statementContext schema_statement() {
			return getRuleContext(Schema_statementContext.class,0);
		}
		public Set_statementContext set_statement() {
			return getRuleContext(Set_statementContext.class,0);
		}
		public Comment_on_statementContext comment_on_statement() {
			return getRuleContext(Comment_on_statementContext.class,0);
		}
		public Create_schema_statementContext create_schema_statement() {
			return getRuleContext(Create_schema_statementContext.class,0);
		}
		public Create_trigger_statementContext create_trigger_statement() {
			return getRuleContext(Create_trigger_statementContext.class,0);
		}
		public Grant_statementContext grant_statement() {
			return getRuleContext(Grant_statementContext.class,0);
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
			setState(480);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(467); data_statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(468); data_change_statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(469); schema_statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(470); index_statement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(471); create_extension_statement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(472); set_statement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(473); create_trigger_statement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(474); grant_statement();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(475); revoke_statement();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(476); comment_on_statement();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(477); create_function_statement();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(478); create_sequence_statement();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(479); create_schema_statement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
			setState(482); query_expression();
			}
		}
		catch (RecognitionException re) {
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
			setState(484); insert_statement();
			}
		}
		catch (RecognitionException re) {
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
			setState(488);
			switch (_input.LA(1)) {
			case CREATE:
				enterOuterAlt(_localctx, 1);
				{
				setState(486); create_table_statement();
				}
				break;
			case DROP:
				enterOuterAlt(_localctx, 2);
				{
				setState(487); drop_table_statement();
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
			setState(490); match(CREATE);
			setState(492);
			_la = _input.LA(1);
			if (_la==UNIQUE) {
				{
				setState(491); ((Index_statementContext)_localctx).u = match(UNIQUE);
				}
			}

			setState(494); match(INDEX);
			setState(495); ((Index_statementContext)_localctx).n = identifier();
			setState(496); match(ON);
			setState(497); ((Index_statementContext)_localctx).t = schema_qualified_name();
			setState(499);
			_la = _input.LA(1);
			if (_la==USING) {
				{
				setState(498); ((Index_statementContext)_localctx).m = method_specifier();
				}
			}

			setState(501); match(LEFT_PAREN);
			setState(502); ((Index_statementContext)_localctx).s = sort_specifier_list();
			setState(503); match(RIGHT_PAREN);
			setState(505);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(504); ((Index_statementContext)_localctx).p = param_clause();
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
			setState(507); match(CREATE);
			setState(508); match(EXTENSION);
			setState(512);
			_la = _input.LA(1);
			if (_la==IF) {
				{
				setState(509); match(IF);
				setState(510); match(NOT);
				setState(511); match(EXISTS);
				}
			}

			setState(514); ((Create_extension_statementContext)_localctx).name = identifier();
			setState(516);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(515); match(WITH);
				}
			}

			setState(520);
			_la = _input.LA(1);
			if (_la==SCHEMA) {
				{
				setState(518); match(SCHEMA);
				setState(519); ((Create_extension_statementContext)_localctx).schema_name = identifier();
				}
			}

			setState(524);
			_la = _input.LA(1);
			if (_la==VERSION) {
				{
				setState(522); match(VERSION);
				setState(523); ((Create_extension_statementContext)_localctx).version = identifier();
				}
			}

			setState(528);
			_la = _input.LA(1);
			if (_la==FROM) {
				{
				setState(526); match(FROM);
				setState(527); ((Create_extension_statementContext)_localctx).old_version = identifier();
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
			setState(569);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(530); match(SET);
				setState(532);
				_la = _input.LA(1);
				if (_la==LOCAL || _la==SESSION) {
					{
					setState(531);
					_la = _input.LA(1);
					if ( !(_la==LOCAL || _la==SESSION) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(534); ((Set_statementContext)_localctx).config_param = identifier();
				setState(535);
				_la = _input.LA(1);
				if ( !(_la==TO || _la==EQUAL) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(547); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(542);
						switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
						case 1:
							{
							setState(536); ((Set_statementContext)_localctx).value = identifier();
							}
							break;
						case 2:
							{
							setState(537); match(QUOTE);
							setState(538); ((Set_statementContext)_localctx).value = identifier();
							setState(539); match(QUOTE);
							}
							break;
						case 3:
							{
							setState(541); match(DEFAULT);
							}
							break;
						}
						setState(545);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(544); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(549); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(551); match(SET);
				setState(553);
				_la = _input.LA(1);
				if (_la==LOCAL || _la==SESSION) {
					{
					setState(552);
					_la = _input.LA(1);
					if ( !(_la==LOCAL || _la==SESSION) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(555); match(TIME);
				setState(556); match(ZONE);
				setState(565); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(560);
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
						case VARBINARY:
						case BLOB:
						case BYTEA:
						case INET4:
						case QUOTE:
						case Identifier:
							{
							setState(557); ((Set_statementContext)_localctx).timezone = identifier();
							}
							break;
						case LOCAL:
							{
							setState(558); match(LOCAL);
							}
							break;
						case DEFAULT:
							{
							setState(559); match(DEFAULT);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(563);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(562); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(567); 
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
			setState(571); match(CREATE);
			setState(573);
			_la = _input.LA(1);
			if (_la==CONSTRAINT) {
				{
				setState(572); match(CONSTRAINT);
				}
			}

			setState(575); match(TRIGGER);
			setState(576); ((Create_trigger_statementContext)_localctx).name = identifier();
			setState(581);
			switch (_input.LA(1)) {
			case BEFORE:
				{
				setState(577); match(BEFORE);
				}
				break;
			case INSTEAD:
				{
				{
				setState(578); match(INSTEAD);
				setState(579); match(OF);
				}
				}
				break;
			case AFTER:
				{
				setState(580); match(AFTER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(598);
			switch (_input.LA(1)) {
			case INSERT:
				{
				setState(583); match(INSERT);
				}
				break;
			case DELETE:
				{
				setState(584); match(DELETE);
				}
				break;
			case TRUNCATE:
				{
				setState(585); match(TRUNCATE);
				}
				break;
			case UPDATE:
				{
				{
				setState(586); match(UPDATE);
				setState(596);
				_la = _input.LA(1);
				if (_la==OF) {
					{
					setState(587); match(OF);
					setState(592); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(588); ((Create_trigger_statementContext)_localctx).columnName = identifier();
						setState(590);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(589); match(COMMA);
							}
						}

						}
						}
						setState(594); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (ADMIN - 129)) | (1L << (AVG - 129)) | (1L << (BETWEEN - 129)) | (1L << (BY - 129)) | (1L << (CACHE - 129)) | (1L << (CALLED - 129)) | (1L << (CLASS - 129)) | (1L << (CENTURY - 129)) | (1L << (CHARACTER - 129)) | (1L << (CHECK - 129)) | (1L << (COLLECT - 129)) | (1L << (COALESCE - 129)) | (1L << (COLUMN - 129)) | (1L << (COMMENT - 129)) | (1L << (COMMENTS - 129)) | (1L << (COMMIT - 129)) | (1L << (CONFIGURATION - 129)) | (1L << (COST - 129)) | (1L << (COUNT - 129)) | (1L << (CUBE - 129)) | (1L << (CURRENT - 129)) | (1L << (CYCLE - 129)) | (1L << (DATA - 129)) | (1L << (DAY - 129)) | (1L << (DEC - 129)) | (1L << (DECADE - 129)) | (1L << (DEFINER - 129)) | (1L << (DICTIONARY - 129)) | (1L << (DOW - 129)) | (1L << (DOY - 129)) | (1L << (DROP - 129)) | (1L << (EPOCH - 129)) | (1L << (EVERY - 129)) | (1L << (EXISTS - 129)) | (1L << (EXTERNAL - 129)) | (1L << (EXTRACT - 129)) | (1L << (FAMILY - 129)) | (1L << (FILTER - 129)) | (1L << (FIRST - 129)) | (1L << (FORMAT - 129)) | (1L << (FUSION - 129)) | (1L << (GROUPING - 129)) | (1L << (HASH - 129)) | (1L << (INDEX - 129)) | (1L << (INCREMENT - 129)) | (1L << (INPUT - 129)) | (1L << (INSERT - 129)) | (1L << (INTERSECTION - 129)) | (1L << (ISCACHABLE - 129)) | (1L << (ISODOW - 129)) | (1L << (ISOYEAR - 129)) | (1L << (ISSTRICT - 129)) | (1L << (LANGUAGE - 129)) | (1L << (LARGE - 129)) | (1L << (LAST - 129)) | (1L << (LESS - 129)) | (1L << (LIST - 129)) | (1L << (LOCATION - 129)) | (1L << (MATCH - 129)) | (1L << (MAX - 129)) | (1L << (MAXVALUE - 129)) | (1L << (MICROSECONDS - 129)))) != 0) || ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & ((1L << (MILLENNIUM - 193)) | (1L << (MILLISECONDS - 193)) | (1L << (MIN - 193)) | (1L << (MINVALUE - 193)) | (1L << (MINUTE - 193)) | (1L << (MONTH - 193)) | (1L << (NATIONAL - 193)) | (1L << (NO - 193)) | (1L << (NONE - 193)) | (1L << (NULLIF - 193)) | (1L << (OBJECT - 193)) | (1L << (OPTION - 193)) | (1L << (OPTIONS - 193)) | (1L << (OVERWRITE - 193)) | (1L << (PARSER - 193)) | (1L << (PARTIAL - 193)) | (1L << (PARTITION - 193)) | (1L << (PARTITIONS - 193)) | (1L << (PRECISION - 193)) | (1L << (PUBLIC - 193)) | (1L << (PURGE - 193)) | (1L << (QUARTER - 193)) | (1L << (RANGE - 193)) | (1L << (REGEXP - 193)) | (1L << (RLIKE - 193)) | (1L << (ROLLUP - 193)) | (1L << (SEARCH - 193)) | (1L << (SECOND - 193)) | (1L << (SECURITY - 193)) | (1L << (SERVER - 193)) | (1L << (SET - 193)) | (1L << (SIMILAR - 193)) | (1L << (SIMPLE - 193)) | (1L << (STABLE - 193)) | (1L << (START - 193)) | (1L << (STORAGE - 193)) | (1L << (STDDEV_POP - 193)) | (1L << (STDDEV_SAMP - 193)) | (1L << (SUBPARTITION - 193)) | (1L << (SUM - 193)) | (1L << (TABLESPACE - 193)) | (1L << (TEMPLATE - 193)) | (1L << (THAN - 193)) | (1L << (TIMEZONE - 193)) | (1L << (TIMEZONE_HOUR - 193)) | (1L << (TIMEZONE_MINUTE - 193)) | (1L << (TRIM - 193)) | (1L << (TO - 193)) | (1L << (UNKNOWN - 193)) | (1L << (UNLOGGED - 193)) | (1L << (VALUES - 193)) | (1L << (VAR_SAMP - 193)) | (1L << (VAR_POP - 193)) | (1L << (VARYING - 193)) | (1L << (VOLATILE - 193)) | (1L << (WEEK - 193)) | (1L << (WINDOW - 193)) | (1L << (WRAPPER - 193)) | (1L << (YEAR - 193)) | (1L << (ZONE - 193)) | (1L << (BOOLEAN - 193)) | (1L << (BOOL - 193)))) != 0) || ((((_la - 257)) & ~0x3f) == 0 && ((1L << (_la - 257)) & ((1L << (BIT - 257)) | (1L << (VARBIT - 257)) | (1L << (INT1 - 257)) | (1L << (INT2 - 257)) | (1L << (INT4 - 257)) | (1L << (INT8 - 257)) | (1L << (TINYINT - 257)) | (1L << (SMALLINT - 257)) | (1L << (INT - 257)) | (1L << (INTEGER - 257)) | (1L << (BIGINT - 257)) | (1L << (FLOAT4 - 257)) | (1L << (FLOAT8 - 257)) | (1L << (REAL - 257)) | (1L << (FLOAT - 257)) | (1L << (DOUBLE - 257)) | (1L << (NUMERIC - 257)) | (1L << (DECIMAL - 257)) | (1L << (CHAR - 257)) | (1L << (VARCHAR - 257)) | (1L << (NCHAR - 257)) | (1L << (NVARCHAR - 257)) | (1L << (DATE - 257)) | (1L << (TIME - 257)) | (1L << (TIMETZ - 257)) | (1L << (TIMESTAMP - 257)) | (1L << (TIMESTAMPTZ - 257)) | (1L << (TEXT - 257)) | (1L << (VARBINARY - 257)) | (1L << (BLOB - 257)) | (1L << (BYTEA - 257)) | (1L << (INET4 - 257)) | (1L << (QUOTE - 257)))) != 0) || _la==Identifier );
					}
				}

				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(600); match(ON);
			setState(601); ((Create_trigger_statementContext)_localctx).tabl_name = schema_qualified_name();
			setState(604);
			_la = _input.LA(1);
			if (_la==FROM) {
				{
				setState(602); match(FROM);
				setState(603); ((Create_trigger_statementContext)_localctx).referenced_table_name = schema_qualified_name();
				}
			}

			setState(615);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				{
				setState(606); match(NOT);
				setState(607); match(DEFERRABLE);
				}
				break;
			case 2:
				{
				setState(609);
				_la = _input.LA(1);
				if (_la==DEFERRABLE) {
					{
					setState(608); match(DEFERRABLE);
					}
				}

				{
				setState(611); match(INITIALLY);
				setState(612); match(IMMEDIATE);
				}
				}
				break;
			case 3:
				{
				{
				setState(613); match(INITIALLY);
				setState(614); match(DEFERRED);
				}
				}
				break;
			}
			setState(623);
			switch (_input.LA(1)) {
			case FOR:
				{
				setState(617); match(FOR);
				setState(619);
				_la = _input.LA(1);
				if (_la==EACH) {
					{
					setState(618); match(EACH);
					}
				}

				setState(621); match(ROW);
				}
				break;
			case STATEMENT:
				{
				setState(622); match(STATEMENT);
				}
				break;
			case EXECUTE:
			case WHEN:
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(627);
			_la = _input.LA(1);
			if (_la==WHEN) {
				{
				setState(625); match(WHEN);
				{
				setState(626); boolean_value_expression();
				}
				}
			}

			setState(629); match(EXECUTE);
			setState(630); match(PROCEDURE);
			setState(631); ((Create_trigger_statementContext)_localctx).func_name = identifier();
			setState(632); match(LEFT_PAREN);
			setState(637);
			_la = _input.LA(1);
			if (((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (ADMIN - 129)) | (1L << (AVG - 129)) | (1L << (BETWEEN - 129)) | (1L << (BY - 129)) | (1L << (CACHE - 129)) | (1L << (CALLED - 129)) | (1L << (CLASS - 129)) | (1L << (CENTURY - 129)) | (1L << (CHARACTER - 129)) | (1L << (CHECK - 129)) | (1L << (COLLECT - 129)) | (1L << (COALESCE - 129)) | (1L << (COLUMN - 129)) | (1L << (COMMENT - 129)) | (1L << (COMMENTS - 129)) | (1L << (COMMIT - 129)) | (1L << (CONFIGURATION - 129)) | (1L << (COST - 129)) | (1L << (COUNT - 129)) | (1L << (CUBE - 129)) | (1L << (CURRENT - 129)) | (1L << (CYCLE - 129)) | (1L << (DATA - 129)) | (1L << (DAY - 129)) | (1L << (DEC - 129)) | (1L << (DECADE - 129)) | (1L << (DEFINER - 129)) | (1L << (DICTIONARY - 129)) | (1L << (DOW - 129)) | (1L << (DOY - 129)) | (1L << (DROP - 129)) | (1L << (EPOCH - 129)) | (1L << (EVERY - 129)) | (1L << (EXISTS - 129)) | (1L << (EXTERNAL - 129)) | (1L << (EXTRACT - 129)) | (1L << (FAMILY - 129)) | (1L << (FILTER - 129)) | (1L << (FIRST - 129)) | (1L << (FORMAT - 129)) | (1L << (FUSION - 129)) | (1L << (GROUPING - 129)) | (1L << (HASH - 129)) | (1L << (INDEX - 129)) | (1L << (INCREMENT - 129)) | (1L << (INPUT - 129)) | (1L << (INSERT - 129)) | (1L << (INTERSECTION - 129)) | (1L << (ISCACHABLE - 129)) | (1L << (ISODOW - 129)) | (1L << (ISOYEAR - 129)) | (1L << (ISSTRICT - 129)) | (1L << (LANGUAGE - 129)) | (1L << (LARGE - 129)) | (1L << (LAST - 129)) | (1L << (LESS - 129)) | (1L << (LIST - 129)) | (1L << (LOCATION - 129)) | (1L << (MATCH - 129)) | (1L << (MAX - 129)) | (1L << (MAXVALUE - 129)) | (1L << (MICROSECONDS - 129)))) != 0) || ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & ((1L << (MILLENNIUM - 193)) | (1L << (MILLISECONDS - 193)) | (1L << (MIN - 193)) | (1L << (MINVALUE - 193)) | (1L << (MINUTE - 193)) | (1L << (MONTH - 193)) | (1L << (NATIONAL - 193)) | (1L << (NO - 193)) | (1L << (NONE - 193)) | (1L << (NULLIF - 193)) | (1L << (OBJECT - 193)) | (1L << (OPTION - 193)) | (1L << (OPTIONS - 193)) | (1L << (OVERWRITE - 193)) | (1L << (PARSER - 193)) | (1L << (PARTIAL - 193)) | (1L << (PARTITION - 193)) | (1L << (PARTITIONS - 193)) | (1L << (PRECISION - 193)) | (1L << (PUBLIC - 193)) | (1L << (PURGE - 193)) | (1L << (QUARTER - 193)) | (1L << (RANGE - 193)) | (1L << (REGEXP - 193)) | (1L << (RLIKE - 193)) | (1L << (ROLLUP - 193)) | (1L << (SEARCH - 193)) | (1L << (SECOND - 193)) | (1L << (SECURITY - 193)) | (1L << (SERVER - 193)) | (1L << (SET - 193)) | (1L << (SIMILAR - 193)) | (1L << (SIMPLE - 193)) | (1L << (STABLE - 193)) | (1L << (START - 193)) | (1L << (STORAGE - 193)) | (1L << (STDDEV_POP - 193)) | (1L << (STDDEV_SAMP - 193)) | (1L << (SUBPARTITION - 193)) | (1L << (SUM - 193)) | (1L << (TABLESPACE - 193)) | (1L << (TEMPLATE - 193)) | (1L << (THAN - 193)) | (1L << (TIMEZONE - 193)) | (1L << (TIMEZONE_HOUR - 193)) | (1L << (TIMEZONE_MINUTE - 193)) | (1L << (TRIM - 193)) | (1L << (TO - 193)) | (1L << (UNKNOWN - 193)) | (1L << (UNLOGGED - 193)) | (1L << (VALUES - 193)) | (1L << (VAR_SAMP - 193)) | (1L << (VAR_POP - 193)) | (1L << (VARYING - 193)) | (1L << (VOLATILE - 193)) | (1L << (WEEK - 193)) | (1L << (WINDOW - 193)) | (1L << (WRAPPER - 193)) | (1L << (YEAR - 193)) | (1L << (ZONE - 193)) | (1L << (BOOLEAN - 193)) | (1L << (BOOL - 193)))) != 0) || ((((_la - 257)) & ~0x3f) == 0 && ((1L << (_la - 257)) & ((1L << (BIT - 257)) | (1L << (VARBIT - 257)) | (1L << (INT1 - 257)) | (1L << (INT2 - 257)) | (1L << (INT4 - 257)) | (1L << (INT8 - 257)) | (1L << (TINYINT - 257)) | (1L << (SMALLINT - 257)) | (1L << (INT - 257)) | (1L << (INTEGER - 257)) | (1L << (BIGINT - 257)) | (1L << (FLOAT4 - 257)) | (1L << (FLOAT8 - 257)) | (1L << (REAL - 257)) | (1L << (FLOAT - 257)) | (1L << (DOUBLE - 257)) | (1L << (NUMERIC - 257)) | (1L << (DECIMAL - 257)) | (1L << (CHAR - 257)) | (1L << (VARCHAR - 257)) | (1L << (NCHAR - 257)) | (1L << (NVARCHAR - 257)) | (1L << (DATE - 257)) | (1L << (TIME - 257)) | (1L << (TIMETZ - 257)) | (1L << (TIMESTAMP - 257)) | (1L << (TIMESTAMPTZ - 257)) | (1L << (TEXT - 257)) | (1L << (VARBINARY - 257)) | (1L << (BLOB - 257)) | (1L << (BYTEA - 257)) | (1L << (INET4 - 257)) | (1L << (QUOTE - 257)))) != 0) || _la==Identifier) {
				{
				setState(633); ((Create_trigger_statementContext)_localctx).arguments = identifier();
				setState(635);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(634); match(COMMA);
					}
				}

				}
			}

			setState(639); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
			setState(1020);
			switch ( getInterpreter().adaptivePredict(_input,114,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(641); match(REVOKE);
				setState(645);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(642); match(GRANT);
					setState(643); match(OPTION);
					setState(644); match(FOR);
					}
				}

				setState(656);
				switch (_input.LA(1)) {
				case DELETE:
				case REFERENCES:
				case SELECT:
				case TRIGGER:
				case TRUNCATE:
				case UPDATE:
				case INSERT:
					{
					setState(648); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(647);
						_la = _input.LA(1);
						if ( !(_la==DELETE || ((((_la - 93)) & ~0x3f) == 0 && ((1L << (_la - 93)) & ((1L << (REFERENCES - 93)) | (1L << (SELECT - 93)) | (1L << (TRIGGER - 93)) | (1L << (TRUNCATE - 93)) | (1L << (UPDATE - 93)))) != 0) || _la==INSERT) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
						}
						setState(650); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==DELETE || ((((_la - 93)) & ~0x3f) == 0 && ((1L << (_la - 93)) & ((1L << (REFERENCES - 93)) | (1L << (SELECT - 93)) | (1L << (TRIGGER - 93)) | (1L << (TRUNCATE - 93)) | (1L << (UPDATE - 93)))) != 0) || _la==INSERT );
					}
					break;
				case ALL:
					{
					setState(652); match(ALL);
					setState(654);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(653); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(658); match(ON);
				setState(676);
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
				case VARBINARY:
				case BLOB:
				case BYTEA:
				case INET4:
				case QUOTE:
				case Identifier:
					{
					setState(663); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(660);
						_la = _input.LA(1);
						if (_la==TABLE) {
							{
							setState(659); match(TABLE);
							}
						}

						setState(662); ((Revoke_statementContext)_localctx).table_name = schema_qualified_name();
						}
						}
						setState(665); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 109)) & ~0x3f) == 0 && ((1L << (_la - 109)) & ((1L << (TABLE - 109)) | (1L << (ADMIN - 109)) | (1L << (AVG - 109)) | (1L << (BETWEEN - 109)) | (1L << (BY - 109)) | (1L << (CACHE - 109)) | (1L << (CALLED - 109)) | (1L << (CLASS - 109)) | (1L << (CENTURY - 109)) | (1L << (CHARACTER - 109)) | (1L << (CHECK - 109)) | (1L << (COLLECT - 109)) | (1L << (COALESCE - 109)) | (1L << (COLUMN - 109)) | (1L << (COMMENT - 109)) | (1L << (COMMENTS - 109)) | (1L << (COMMIT - 109)) | (1L << (CONFIGURATION - 109)) | (1L << (COST - 109)) | (1L << (COUNT - 109)) | (1L << (CUBE - 109)) | (1L << (CURRENT - 109)) | (1L << (CYCLE - 109)) | (1L << (DATA - 109)) | (1L << (DAY - 109)) | (1L << (DEC - 109)) | (1L << (DECADE - 109)) | (1L << (DEFINER - 109)) | (1L << (DICTIONARY - 109)) | (1L << (DOW - 109)) | (1L << (DOY - 109)) | (1L << (DROP - 109)) | (1L << (EPOCH - 109)) | (1L << (EVERY - 109)) | (1L << (EXISTS - 109)) | (1L << (EXTERNAL - 109)) | (1L << (EXTRACT - 109)) | (1L << (FAMILY - 109)) | (1L << (FILTER - 109)) | (1L << (FIRST - 109)) | (1L << (FORMAT - 109)) | (1L << (FUSION - 109)) | (1L << (GROUPING - 109)) | (1L << (HASH - 109)))) != 0) || ((((_la - 173)) & ~0x3f) == 0 && ((1L << (_la - 173)) & ((1L << (INDEX - 173)) | (1L << (INCREMENT - 173)) | (1L << (INPUT - 173)) | (1L << (INSERT - 173)) | (1L << (INTERSECTION - 173)) | (1L << (ISCACHABLE - 173)) | (1L << (ISODOW - 173)) | (1L << (ISOYEAR - 173)) | (1L << (ISSTRICT - 173)) | (1L << (LANGUAGE - 173)) | (1L << (LARGE - 173)) | (1L << (LAST - 173)) | (1L << (LESS - 173)) | (1L << (LIST - 173)) | (1L << (LOCATION - 173)) | (1L << (MATCH - 173)) | (1L << (MAX - 173)) | (1L << (MAXVALUE - 173)) | (1L << (MICROSECONDS - 173)) | (1L << (MILLENNIUM - 173)) | (1L << (MILLISECONDS - 173)) | (1L << (MIN - 173)) | (1L << (MINVALUE - 173)) | (1L << (MINUTE - 173)) | (1L << (MONTH - 173)) | (1L << (NATIONAL - 173)) | (1L << (NO - 173)) | (1L << (NONE - 173)) | (1L << (NULLIF - 173)) | (1L << (OBJECT - 173)) | (1L << (OPTION - 173)) | (1L << (OPTIONS - 173)) | (1L << (OVERWRITE - 173)) | (1L << (PARSER - 173)) | (1L << (PARTIAL - 173)) | (1L << (PARTITION - 173)) | (1L << (PARTITIONS - 173)) | (1L << (PRECISION - 173)) | (1L << (PUBLIC - 173)) | (1L << (PURGE - 173)) | (1L << (QUARTER - 173)) | (1L << (RANGE - 173)) | (1L << (REGEXP - 173)) | (1L << (RLIKE - 173)) | (1L << (ROLLUP - 173)) | (1L << (SEARCH - 173)) | (1L << (SECOND - 173)) | (1L << (SECURITY - 173)) | (1L << (SERVER - 173)) | (1L << (SET - 173)) | (1L << (SIMILAR - 173)) | (1L << (SIMPLE - 173)) | (1L << (STABLE - 173)) | (1L << (START - 173)) | (1L << (STORAGE - 173)) | (1L << (STDDEV_POP - 173)) | (1L << (STDDEV_SAMP - 173)) | (1L << (SUBPARTITION - 173)) | (1L << (SUM - 173)) | (1L << (TABLESPACE - 173)) | (1L << (TEMPLATE - 173)) | (1L << (THAN - 173)))) != 0) || ((((_la - 237)) & ~0x3f) == 0 && ((1L << (_la - 237)) & ((1L << (TIMEZONE - 237)) | (1L << (TIMEZONE_HOUR - 237)) | (1L << (TIMEZONE_MINUTE - 237)) | (1L << (TRIM - 237)) | (1L << (TO - 237)) | (1L << (UNKNOWN - 237)) | (1L << (UNLOGGED - 237)) | (1L << (VALUES - 237)) | (1L << (VAR_SAMP - 237)) | (1L << (VAR_POP - 237)) | (1L << (VARYING - 237)) | (1L << (VOLATILE - 237)) | (1L << (WEEK - 237)) | (1L << (WINDOW - 237)) | (1L << (WRAPPER - 237)) | (1L << (YEAR - 237)) | (1L << (ZONE - 237)) | (1L << (BOOLEAN - 237)) | (1L << (BOOL - 237)) | (1L << (BIT - 237)) | (1L << (VARBIT - 237)) | (1L << (INT1 - 237)) | (1L << (INT2 - 237)) | (1L << (INT4 - 237)) | (1L << (INT8 - 237)) | (1L << (TINYINT - 237)) | (1L << (SMALLINT - 237)) | (1L << (INT - 237)) | (1L << (INTEGER - 237)) | (1L << (BIGINT - 237)) | (1L << (FLOAT4 - 237)) | (1L << (FLOAT8 - 237)) | (1L << (REAL - 237)) | (1L << (FLOAT - 237)) | (1L << (DOUBLE - 237)) | (1L << (NUMERIC - 237)) | (1L << (DECIMAL - 237)) | (1L << (CHAR - 237)) | (1L << (VARCHAR - 237)) | (1L << (NCHAR - 237)) | (1L << (NVARCHAR - 237)) | (1L << (DATE - 237)) | (1L << (TIME - 237)) | (1L << (TIMETZ - 237)) | (1L << (TIMESTAMP - 237)) | (1L << (TIMESTAMPTZ - 237)) | (1L << (TEXT - 237)) | (1L << (VARBINARY - 237)) | (1L << (BLOB - 237)) | (1L << (BYTEA - 237)) | (1L << (INET4 - 237)))) != 0) || _la==QUOTE || _la==Identifier );
					}
					break;
				case ALL:
					{
					setState(667); match(ALL);
					setState(668); match(TABLES);
					setState(669); match(IN);
					setState(670); match(SCHEMA);
					setState(672); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(671); ((Revoke_statementContext)_localctx).schema_name = identifier();
						}
						}
						setState(674); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (ADMIN - 129)) | (1L << (AVG - 129)) | (1L << (BETWEEN - 129)) | (1L << (BY - 129)) | (1L << (CACHE - 129)) | (1L << (CALLED - 129)) | (1L << (CLASS - 129)) | (1L << (CENTURY - 129)) | (1L << (CHARACTER - 129)) | (1L << (CHECK - 129)) | (1L << (COLLECT - 129)) | (1L << (COALESCE - 129)) | (1L << (COLUMN - 129)) | (1L << (COMMENT - 129)) | (1L << (COMMENTS - 129)) | (1L << (COMMIT - 129)) | (1L << (CONFIGURATION - 129)) | (1L << (COST - 129)) | (1L << (COUNT - 129)) | (1L << (CUBE - 129)) | (1L << (CURRENT - 129)) | (1L << (CYCLE - 129)) | (1L << (DATA - 129)) | (1L << (DAY - 129)) | (1L << (DEC - 129)) | (1L << (DECADE - 129)) | (1L << (DEFINER - 129)) | (1L << (DICTIONARY - 129)) | (1L << (DOW - 129)) | (1L << (DOY - 129)) | (1L << (DROP - 129)) | (1L << (EPOCH - 129)) | (1L << (EVERY - 129)) | (1L << (EXISTS - 129)) | (1L << (EXTERNAL - 129)) | (1L << (EXTRACT - 129)) | (1L << (FAMILY - 129)) | (1L << (FILTER - 129)) | (1L << (FIRST - 129)) | (1L << (FORMAT - 129)) | (1L << (FUSION - 129)) | (1L << (GROUPING - 129)) | (1L << (HASH - 129)) | (1L << (INDEX - 129)) | (1L << (INCREMENT - 129)) | (1L << (INPUT - 129)) | (1L << (INSERT - 129)) | (1L << (INTERSECTION - 129)) | (1L << (ISCACHABLE - 129)) | (1L << (ISODOW - 129)) | (1L << (ISOYEAR - 129)) | (1L << (ISSTRICT - 129)) | (1L << (LANGUAGE - 129)) | (1L << (LARGE - 129)) | (1L << (LAST - 129)) | (1L << (LESS - 129)) | (1L << (LIST - 129)) | (1L << (LOCATION - 129)) | (1L << (MATCH - 129)) | (1L << (MAX - 129)) | (1L << (MAXVALUE - 129)) | (1L << (MICROSECONDS - 129)))) != 0) || ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & ((1L << (MILLENNIUM - 193)) | (1L << (MILLISECONDS - 193)) | (1L << (MIN - 193)) | (1L << (MINVALUE - 193)) | (1L << (MINUTE - 193)) | (1L << (MONTH - 193)) | (1L << (NATIONAL - 193)) | (1L << (NO - 193)) | (1L << (NONE - 193)) | (1L << (NULLIF - 193)) | (1L << (OBJECT - 193)) | (1L << (OPTION - 193)) | (1L << (OPTIONS - 193)) | (1L << (OVERWRITE - 193)) | (1L << (PARSER - 193)) | (1L << (PARTIAL - 193)) | (1L << (PARTITION - 193)) | (1L << (PARTITIONS - 193)) | (1L << (PRECISION - 193)) | (1L << (PUBLIC - 193)) | (1L << (PURGE - 193)) | (1L << (QUARTER - 193)) | (1L << (RANGE - 193)) | (1L << (REGEXP - 193)) | (1L << (RLIKE - 193)) | (1L << (ROLLUP - 193)) | (1L << (SEARCH - 193)) | (1L << (SECOND - 193)) | (1L << (SECURITY - 193)) | (1L << (SERVER - 193)) | (1L << (SET - 193)) | (1L << (SIMILAR - 193)) | (1L << (SIMPLE - 193)) | (1L << (STABLE - 193)) | (1L << (START - 193)) | (1L << (STORAGE - 193)) | (1L << (STDDEV_POP - 193)) | (1L << (STDDEV_SAMP - 193)) | (1L << (SUBPARTITION - 193)) | (1L << (SUM - 193)) | (1L << (TABLESPACE - 193)) | (1L << (TEMPLATE - 193)) | (1L << (THAN - 193)) | (1L << (TIMEZONE - 193)) | (1L << (TIMEZONE_HOUR - 193)) | (1L << (TIMEZONE_MINUTE - 193)) | (1L << (TRIM - 193)) | (1L << (TO - 193)) | (1L << (UNKNOWN - 193)) | (1L << (UNLOGGED - 193)) | (1L << (VALUES - 193)) | (1L << (VAR_SAMP - 193)) | (1L << (VAR_POP - 193)) | (1L << (VARYING - 193)) | (1L << (VOLATILE - 193)) | (1L << (WEEK - 193)) | (1L << (WINDOW - 193)) | (1L << (WRAPPER - 193)) | (1L << (YEAR - 193)) | (1L << (ZONE - 193)) | (1L << (BOOLEAN - 193)) | (1L << (BOOL - 193)))) != 0) || ((((_la - 257)) & ~0x3f) == 0 && ((1L << (_la - 257)) & ((1L << (BIT - 257)) | (1L << (VARBIT - 257)) | (1L << (INT1 - 257)) | (1L << (INT2 - 257)) | (1L << (INT4 - 257)) | (1L << (INT8 - 257)) | (1L << (TINYINT - 257)) | (1L << (SMALLINT - 257)) | (1L << (INT - 257)) | (1L << (INTEGER - 257)) | (1L << (BIGINT - 257)) | (1L << (FLOAT4 - 257)) | (1L << (FLOAT8 - 257)) | (1L << (REAL - 257)) | (1L << (FLOAT - 257)) | (1L << (DOUBLE - 257)) | (1L << (NUMERIC - 257)) | (1L << (DECIMAL - 257)) | (1L << (CHAR - 257)) | (1L << (VARCHAR - 257)) | (1L << (NCHAR - 257)) | (1L << (NVARCHAR - 257)) | (1L << (DATE - 257)) | (1L << (TIME - 257)) | (1L << (TIMETZ - 257)) | (1L << (TIMESTAMP - 257)) | (1L << (TIMESTAMPTZ - 257)) | (1L << (TEXT - 257)) | (1L << (VARBINARY - 257)) | (1L << (BLOB - 257)) | (1L << (BYTEA - 257)) | (1L << (INET4 - 257)) | (1L << (QUOTE - 257)))) != 0) || _la==Identifier );
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(678); revoke_from_cascade_restrict();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(680); match(REVOKE);
				setState(684);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(681); match(GRANT);
					setState(682); match(OPTION);
					setState(683); match(FOR);
					}
				}

				setState(717);
				switch (_input.LA(1)) {
				case REFERENCES:
				case SELECT:
				case UPDATE:
				case INSERT:
					{
					setState(698); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(686);
						_la = _input.LA(1);
						if ( !(((((_la - 93)) & ~0x3f) == 0 && ((1L << (_la - 93)) & ((1L << (REFERENCES - 93)) | (1L << (SELECT - 93)) | (1L << (UPDATE - 93)))) != 0) || _la==INSERT) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(687); match(LEFT_PAREN);
						setState(692); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(688); ((Revoke_statementContext)_localctx).column = identifier();
							setState(690);
							_la = _input.LA(1);
							if (_la==COMMA) {
								{
								setState(689); match(COMMA);
								}
							}

							}
							}
							setState(694); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (ADMIN - 129)) | (1L << (AVG - 129)) | (1L << (BETWEEN - 129)) | (1L << (BY - 129)) | (1L << (CACHE - 129)) | (1L << (CALLED - 129)) | (1L << (CLASS - 129)) | (1L << (CENTURY - 129)) | (1L << (CHARACTER - 129)) | (1L << (CHECK - 129)) | (1L << (COLLECT - 129)) | (1L << (COALESCE - 129)) | (1L << (COLUMN - 129)) | (1L << (COMMENT - 129)) | (1L << (COMMENTS - 129)) | (1L << (COMMIT - 129)) | (1L << (CONFIGURATION - 129)) | (1L << (COST - 129)) | (1L << (COUNT - 129)) | (1L << (CUBE - 129)) | (1L << (CURRENT - 129)) | (1L << (CYCLE - 129)) | (1L << (DATA - 129)) | (1L << (DAY - 129)) | (1L << (DEC - 129)) | (1L << (DECADE - 129)) | (1L << (DEFINER - 129)) | (1L << (DICTIONARY - 129)) | (1L << (DOW - 129)) | (1L << (DOY - 129)) | (1L << (DROP - 129)) | (1L << (EPOCH - 129)) | (1L << (EVERY - 129)) | (1L << (EXISTS - 129)) | (1L << (EXTERNAL - 129)) | (1L << (EXTRACT - 129)) | (1L << (FAMILY - 129)) | (1L << (FILTER - 129)) | (1L << (FIRST - 129)) | (1L << (FORMAT - 129)) | (1L << (FUSION - 129)) | (1L << (GROUPING - 129)) | (1L << (HASH - 129)) | (1L << (INDEX - 129)) | (1L << (INCREMENT - 129)) | (1L << (INPUT - 129)) | (1L << (INSERT - 129)) | (1L << (INTERSECTION - 129)) | (1L << (ISCACHABLE - 129)) | (1L << (ISODOW - 129)) | (1L << (ISOYEAR - 129)) | (1L << (ISSTRICT - 129)) | (1L << (LANGUAGE - 129)) | (1L << (LARGE - 129)) | (1L << (LAST - 129)) | (1L << (LESS - 129)) | (1L << (LIST - 129)) | (1L << (LOCATION - 129)) | (1L << (MATCH - 129)) | (1L << (MAX - 129)) | (1L << (MAXVALUE - 129)) | (1L << (MICROSECONDS - 129)))) != 0) || ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & ((1L << (MILLENNIUM - 193)) | (1L << (MILLISECONDS - 193)) | (1L << (MIN - 193)) | (1L << (MINVALUE - 193)) | (1L << (MINUTE - 193)) | (1L << (MONTH - 193)) | (1L << (NATIONAL - 193)) | (1L << (NO - 193)) | (1L << (NONE - 193)) | (1L << (NULLIF - 193)) | (1L << (OBJECT - 193)) | (1L << (OPTION - 193)) | (1L << (OPTIONS - 193)) | (1L << (OVERWRITE - 193)) | (1L << (PARSER - 193)) | (1L << (PARTIAL - 193)) | (1L << (PARTITION - 193)) | (1L << (PARTITIONS - 193)) | (1L << (PRECISION - 193)) | (1L << (PUBLIC - 193)) | (1L << (PURGE - 193)) | (1L << (QUARTER - 193)) | (1L << (RANGE - 193)) | (1L << (REGEXP - 193)) | (1L << (RLIKE - 193)) | (1L << (ROLLUP - 193)) | (1L << (SEARCH - 193)) | (1L << (SECOND - 193)) | (1L << (SECURITY - 193)) | (1L << (SERVER - 193)) | (1L << (SET - 193)) | (1L << (SIMILAR - 193)) | (1L << (SIMPLE - 193)) | (1L << (STABLE - 193)) | (1L << (START - 193)) | (1L << (STORAGE - 193)) | (1L << (STDDEV_POP - 193)) | (1L << (STDDEV_SAMP - 193)) | (1L << (SUBPARTITION - 193)) | (1L << (SUM - 193)) | (1L << (TABLESPACE - 193)) | (1L << (TEMPLATE - 193)) | (1L << (THAN - 193)) | (1L << (TIMEZONE - 193)) | (1L << (TIMEZONE_HOUR - 193)) | (1L << (TIMEZONE_MINUTE - 193)) | (1L << (TRIM - 193)) | (1L << (TO - 193)) | (1L << (UNKNOWN - 193)) | (1L << (UNLOGGED - 193)) | (1L << (VALUES - 193)) | (1L << (VAR_SAMP - 193)) | (1L << (VAR_POP - 193)) | (1L << (VARYING - 193)) | (1L << (VOLATILE - 193)) | (1L << (WEEK - 193)) | (1L << (WINDOW - 193)) | (1L << (WRAPPER - 193)) | (1L << (YEAR - 193)) | (1L << (ZONE - 193)) | (1L << (BOOLEAN - 193)) | (1L << (BOOL - 193)))) != 0) || ((((_la - 257)) & ~0x3f) == 0 && ((1L << (_la - 257)) & ((1L << (BIT - 257)) | (1L << (VARBIT - 257)) | (1L << (INT1 - 257)) | (1L << (INT2 - 257)) | (1L << (INT4 - 257)) | (1L << (INT8 - 257)) | (1L << (TINYINT - 257)) | (1L << (SMALLINT - 257)) | (1L << (INT - 257)) | (1L << (INTEGER - 257)) | (1L << (BIGINT - 257)) | (1L << (FLOAT4 - 257)) | (1L << (FLOAT8 - 257)) | (1L << (REAL - 257)) | (1L << (FLOAT - 257)) | (1L << (DOUBLE - 257)) | (1L << (NUMERIC - 257)) | (1L << (DECIMAL - 257)) | (1L << (CHAR - 257)) | (1L << (VARCHAR - 257)) | (1L << (NCHAR - 257)) | (1L << (NVARCHAR - 257)) | (1L << (DATE - 257)) | (1L << (TIME - 257)) | (1L << (TIMETZ - 257)) | (1L << (TIMESTAMP - 257)) | (1L << (TIMESTAMPTZ - 257)) | (1L << (TEXT - 257)) | (1L << (VARBINARY - 257)) | (1L << (BLOB - 257)) | (1L << (BYTEA - 257)) | (1L << (INET4 - 257)) | (1L << (QUOTE - 257)))) != 0) || _la==Identifier );
						setState(696); match(RIGHT_PAREN);
						}
						}
						setState(700); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 93)) & ~0x3f) == 0 && ((1L << (_la - 93)) & ((1L << (REFERENCES - 93)) | (1L << (SELECT - 93)) | (1L << (UPDATE - 93)))) != 0) || _la==INSERT );
					}
					break;
				case ALL:
					{
					setState(702); match(ALL);
					setState(704);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(703); match(PRIVILEGES);
						}
					}

					setState(706); match(LEFT_PAREN);
					setState(711); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(707); ((Revoke_statementContext)_localctx).column = identifier();
						setState(709);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(708); match(COMMA);
							}
						}

						}
						}
						setState(713); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (ADMIN - 129)) | (1L << (AVG - 129)) | (1L << (BETWEEN - 129)) | (1L << (BY - 129)) | (1L << (CACHE - 129)) | (1L << (CALLED - 129)) | (1L << (CLASS - 129)) | (1L << (CENTURY - 129)) | (1L << (CHARACTER - 129)) | (1L << (CHECK - 129)) | (1L << (COLLECT - 129)) | (1L << (COALESCE - 129)) | (1L << (COLUMN - 129)) | (1L << (COMMENT - 129)) | (1L << (COMMENTS - 129)) | (1L << (COMMIT - 129)) | (1L << (CONFIGURATION - 129)) | (1L << (COST - 129)) | (1L << (COUNT - 129)) | (1L << (CUBE - 129)) | (1L << (CURRENT - 129)) | (1L << (CYCLE - 129)) | (1L << (DATA - 129)) | (1L << (DAY - 129)) | (1L << (DEC - 129)) | (1L << (DECADE - 129)) | (1L << (DEFINER - 129)) | (1L << (DICTIONARY - 129)) | (1L << (DOW - 129)) | (1L << (DOY - 129)) | (1L << (DROP - 129)) | (1L << (EPOCH - 129)) | (1L << (EVERY - 129)) | (1L << (EXISTS - 129)) | (1L << (EXTERNAL - 129)) | (1L << (EXTRACT - 129)) | (1L << (FAMILY - 129)) | (1L << (FILTER - 129)) | (1L << (FIRST - 129)) | (1L << (FORMAT - 129)) | (1L << (FUSION - 129)) | (1L << (GROUPING - 129)) | (1L << (HASH - 129)) | (1L << (INDEX - 129)) | (1L << (INCREMENT - 129)) | (1L << (INPUT - 129)) | (1L << (INSERT - 129)) | (1L << (INTERSECTION - 129)) | (1L << (ISCACHABLE - 129)) | (1L << (ISODOW - 129)) | (1L << (ISOYEAR - 129)) | (1L << (ISSTRICT - 129)) | (1L << (LANGUAGE - 129)) | (1L << (LARGE - 129)) | (1L << (LAST - 129)) | (1L << (LESS - 129)) | (1L << (LIST - 129)) | (1L << (LOCATION - 129)) | (1L << (MATCH - 129)) | (1L << (MAX - 129)) | (1L << (MAXVALUE - 129)) | (1L << (MICROSECONDS - 129)))) != 0) || ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & ((1L << (MILLENNIUM - 193)) | (1L << (MILLISECONDS - 193)) | (1L << (MIN - 193)) | (1L << (MINVALUE - 193)) | (1L << (MINUTE - 193)) | (1L << (MONTH - 193)) | (1L << (NATIONAL - 193)) | (1L << (NO - 193)) | (1L << (NONE - 193)) | (1L << (NULLIF - 193)) | (1L << (OBJECT - 193)) | (1L << (OPTION - 193)) | (1L << (OPTIONS - 193)) | (1L << (OVERWRITE - 193)) | (1L << (PARSER - 193)) | (1L << (PARTIAL - 193)) | (1L << (PARTITION - 193)) | (1L << (PARTITIONS - 193)) | (1L << (PRECISION - 193)) | (1L << (PUBLIC - 193)) | (1L << (PURGE - 193)) | (1L << (QUARTER - 193)) | (1L << (RANGE - 193)) | (1L << (REGEXP - 193)) | (1L << (RLIKE - 193)) | (1L << (ROLLUP - 193)) | (1L << (SEARCH - 193)) | (1L << (SECOND - 193)) | (1L << (SECURITY - 193)) | (1L << (SERVER - 193)) | (1L << (SET - 193)) | (1L << (SIMILAR - 193)) | (1L << (SIMPLE - 193)) | (1L << (STABLE - 193)) | (1L << (START - 193)) | (1L << (STORAGE - 193)) | (1L << (STDDEV_POP - 193)) | (1L << (STDDEV_SAMP - 193)) | (1L << (SUBPARTITION - 193)) | (1L << (SUM - 193)) | (1L << (TABLESPACE - 193)) | (1L << (TEMPLATE - 193)) | (1L << (THAN - 193)) | (1L << (TIMEZONE - 193)) | (1L << (TIMEZONE_HOUR - 193)) | (1L << (TIMEZONE_MINUTE - 193)) | (1L << (TRIM - 193)) | (1L << (TO - 193)) | (1L << (UNKNOWN - 193)) | (1L << (UNLOGGED - 193)) | (1L << (VALUES - 193)) | (1L << (VAR_SAMP - 193)) | (1L << (VAR_POP - 193)) | (1L << (VARYING - 193)) | (1L << (VOLATILE - 193)) | (1L << (WEEK - 193)) | (1L << (WINDOW - 193)) | (1L << (WRAPPER - 193)) | (1L << (YEAR - 193)) | (1L << (ZONE - 193)) | (1L << (BOOLEAN - 193)) | (1L << (BOOL - 193)))) != 0) || ((((_la - 257)) & ~0x3f) == 0 && ((1L << (_la - 257)) & ((1L << (BIT - 257)) | (1L << (VARBIT - 257)) | (1L << (INT1 - 257)) | (1L << (INT2 - 257)) | (1L << (INT4 - 257)) | (1L << (INT8 - 257)) | (1L << (TINYINT - 257)) | (1L << (SMALLINT - 257)) | (1L << (INT - 257)) | (1L << (INTEGER - 257)) | (1L << (BIGINT - 257)) | (1L << (FLOAT4 - 257)) | (1L << (FLOAT8 - 257)) | (1L << (REAL - 257)) | (1L << (FLOAT - 257)) | (1L << (DOUBLE - 257)) | (1L << (NUMERIC - 257)) | (1L << (DECIMAL - 257)) | (1L << (CHAR - 257)) | (1L << (VARCHAR - 257)) | (1L << (NCHAR - 257)) | (1L << (NVARCHAR - 257)) | (1L << (DATE - 257)) | (1L << (TIME - 257)) | (1L << (TIMETZ - 257)) | (1L << (TIMESTAMP - 257)) | (1L << (TIMESTAMPTZ - 257)) | (1L << (TEXT - 257)) | (1L << (VARBINARY - 257)) | (1L << (BLOB - 257)) | (1L << (BYTEA - 257)) | (1L << (INET4 - 257)) | (1L << (QUOTE - 257)))) != 0) || _la==Identifier );
					setState(715); match(RIGHT_PAREN);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(719); match(ON);
				setState(721);
				_la = _input.LA(1);
				if (_la==TABLE) {
					{
					setState(720); match(TABLE);
					}
				}

				setState(727); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(723); ((Revoke_statementContext)_localctx).table_name = schema_qualified_name();
					setState(725);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(724); match(COMMA);
						}
					}

					}
					}
					setState(729); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (ADMIN - 129)) | (1L << (AVG - 129)) | (1L << (BETWEEN - 129)) | (1L << (BY - 129)) | (1L << (CACHE - 129)) | (1L << (CALLED - 129)) | (1L << (CLASS - 129)) | (1L << (CENTURY - 129)) | (1L << (CHARACTER - 129)) | (1L << (CHECK - 129)) | (1L << (COLLECT - 129)) | (1L << (COALESCE - 129)) | (1L << (COLUMN - 129)) | (1L << (COMMENT - 129)) | (1L << (COMMENTS - 129)) | (1L << (COMMIT - 129)) | (1L << (CONFIGURATION - 129)) | (1L << (COST - 129)) | (1L << (COUNT - 129)) | (1L << (CUBE - 129)) | (1L << (CURRENT - 129)) | (1L << (CYCLE - 129)) | (1L << (DATA - 129)) | (1L << (DAY - 129)) | (1L << (DEC - 129)) | (1L << (DECADE - 129)) | (1L << (DEFINER - 129)) | (1L << (DICTIONARY - 129)) | (1L << (DOW - 129)) | (1L << (DOY - 129)) | (1L << (DROP - 129)) | (1L << (EPOCH - 129)) | (1L << (EVERY - 129)) | (1L << (EXISTS - 129)) | (1L << (EXTERNAL - 129)) | (1L << (EXTRACT - 129)) | (1L << (FAMILY - 129)) | (1L << (FILTER - 129)) | (1L << (FIRST - 129)) | (1L << (FORMAT - 129)) | (1L << (FUSION - 129)) | (1L << (GROUPING - 129)) | (1L << (HASH - 129)) | (1L << (INDEX - 129)) | (1L << (INCREMENT - 129)) | (1L << (INPUT - 129)) | (1L << (INSERT - 129)) | (1L << (INTERSECTION - 129)) | (1L << (ISCACHABLE - 129)) | (1L << (ISODOW - 129)) | (1L << (ISOYEAR - 129)) | (1L << (ISSTRICT - 129)) | (1L << (LANGUAGE - 129)) | (1L << (LARGE - 129)) | (1L << (LAST - 129)) | (1L << (LESS - 129)) | (1L << (LIST - 129)) | (1L << (LOCATION - 129)) | (1L << (MATCH - 129)) | (1L << (MAX - 129)) | (1L << (MAXVALUE - 129)) | (1L << (MICROSECONDS - 129)))) != 0) || ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & ((1L << (MILLENNIUM - 193)) | (1L << (MILLISECONDS - 193)) | (1L << (MIN - 193)) | (1L << (MINVALUE - 193)) | (1L << (MINUTE - 193)) | (1L << (MONTH - 193)) | (1L << (NATIONAL - 193)) | (1L << (NO - 193)) | (1L << (NONE - 193)) | (1L << (NULLIF - 193)) | (1L << (OBJECT - 193)) | (1L << (OPTION - 193)) | (1L << (OPTIONS - 193)) | (1L << (OVERWRITE - 193)) | (1L << (PARSER - 193)) | (1L << (PARTIAL - 193)) | (1L << (PARTITION - 193)) | (1L << (PARTITIONS - 193)) | (1L << (PRECISION - 193)) | (1L << (PUBLIC - 193)) | (1L << (PURGE - 193)) | (1L << (QUARTER - 193)) | (1L << (RANGE - 193)) | (1L << (REGEXP - 193)) | (1L << (RLIKE - 193)) | (1L << (ROLLUP - 193)) | (1L << (SEARCH - 193)) | (1L << (SECOND - 193)) | (1L << (SECURITY - 193)) | (1L << (SERVER - 193)) | (1L << (SET - 193)) | (1L << (SIMILAR - 193)) | (1L << (SIMPLE - 193)) | (1L << (STABLE - 193)) | (1L << (START - 193)) | (1L << (STORAGE - 193)) | (1L << (STDDEV_POP - 193)) | (1L << (STDDEV_SAMP - 193)) | (1L << (SUBPARTITION - 193)) | (1L << (SUM - 193)) | (1L << (TABLESPACE - 193)) | (1L << (TEMPLATE - 193)) | (1L << (THAN - 193)) | (1L << (TIMEZONE - 193)) | (1L << (TIMEZONE_HOUR - 193)) | (1L << (TIMEZONE_MINUTE - 193)) | (1L << (TRIM - 193)) | (1L << (TO - 193)) | (1L << (UNKNOWN - 193)) | (1L << (UNLOGGED - 193)) | (1L << (VALUES - 193)) | (1L << (VAR_SAMP - 193)) | (1L << (VAR_POP - 193)) | (1L << (VARYING - 193)) | (1L << (VOLATILE - 193)) | (1L << (WEEK - 193)) | (1L << (WINDOW - 193)) | (1L << (WRAPPER - 193)) | (1L << (YEAR - 193)) | (1L << (ZONE - 193)) | (1L << (BOOLEAN - 193)) | (1L << (BOOL - 193)))) != 0) || ((((_la - 257)) & ~0x3f) == 0 && ((1L << (_la - 257)) & ((1L << (BIT - 257)) | (1L << (VARBIT - 257)) | (1L << (INT1 - 257)) | (1L << (INT2 - 257)) | (1L << (INT4 - 257)) | (1L << (INT8 - 257)) | (1L << (TINYINT - 257)) | (1L << (SMALLINT - 257)) | (1L << (INT - 257)) | (1L << (INTEGER - 257)) | (1L << (BIGINT - 257)) | (1L << (FLOAT4 - 257)) | (1L << (FLOAT8 - 257)) | (1L << (REAL - 257)) | (1L << (FLOAT - 257)) | (1L << (DOUBLE - 257)) | (1L << (NUMERIC - 257)) | (1L << (DECIMAL - 257)) | (1L << (CHAR - 257)) | (1L << (VARCHAR - 257)) | (1L << (NCHAR - 257)) | (1L << (NVARCHAR - 257)) | (1L << (DATE - 257)) | (1L << (TIME - 257)) | (1L << (TIMETZ - 257)) | (1L << (TIMESTAMP - 257)) | (1L << (TIMESTAMPTZ - 257)) | (1L << (TEXT - 257)) | (1L << (VARBINARY - 257)) | (1L << (BLOB - 257)) | (1L << (BYTEA - 257)) | (1L << (INET4 - 257)) | (1L << (QUOTE - 257)))) != 0) || _la==Identifier );
				setState(731); revoke_from_cascade_restrict();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(733); match(REVOKE);
				setState(737);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(734); match(GRANT);
					setState(735); match(OPTION);
					setState(736); match(FOR);
					}
				}

				setState(748);
				switch (_input.LA(1)) {
				case SELECT:
				case UPDATE:
				case USAGE:
					{
					setState(740); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(739);
						_la = _input.LA(1);
						if ( !(((((_la - 103)) & ~0x3f) == 0 && ((1L << (_la - 103)) & ((1L << (SELECT - 103)) | (1L << (UPDATE - 103)) | (1L << (USAGE - 103)))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
						}
						setState(742); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 103)) & ~0x3f) == 0 && ((1L << (_la - 103)) & ((1L << (SELECT - 103)) | (1L << (UPDATE - 103)) | (1L << (USAGE - 103)))) != 0) );
					}
					break;
				case ALL:
					{
					setState(744); match(ALL);
					setState(746);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(745); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(750); match(ON);
				setState(772);
				switch (_input.LA(1)) {
				case SEQUENCE:
					{
					setState(751); match(SEQUENCE);
					setState(756); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(752); ((Revoke_statementContext)_localctx).sequence_name = schema_qualified_name();
						setState(754);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(753); match(COMMA);
							}
						}

						}
						}
						setState(758); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (ADMIN - 129)) | (1L << (AVG - 129)) | (1L << (BETWEEN - 129)) | (1L << (BY - 129)) | (1L << (CACHE - 129)) | (1L << (CALLED - 129)) | (1L << (CLASS - 129)) | (1L << (CENTURY - 129)) | (1L << (CHARACTER - 129)) | (1L << (CHECK - 129)) | (1L << (COLLECT - 129)) | (1L << (COALESCE - 129)) | (1L << (COLUMN - 129)) | (1L << (COMMENT - 129)) | (1L << (COMMENTS - 129)) | (1L << (COMMIT - 129)) | (1L << (CONFIGURATION - 129)) | (1L << (COST - 129)) | (1L << (COUNT - 129)) | (1L << (CUBE - 129)) | (1L << (CURRENT - 129)) | (1L << (CYCLE - 129)) | (1L << (DATA - 129)) | (1L << (DAY - 129)) | (1L << (DEC - 129)) | (1L << (DECADE - 129)) | (1L << (DEFINER - 129)) | (1L << (DICTIONARY - 129)) | (1L << (DOW - 129)) | (1L << (DOY - 129)) | (1L << (DROP - 129)) | (1L << (EPOCH - 129)) | (1L << (EVERY - 129)) | (1L << (EXISTS - 129)) | (1L << (EXTERNAL - 129)) | (1L << (EXTRACT - 129)) | (1L << (FAMILY - 129)) | (1L << (FILTER - 129)) | (1L << (FIRST - 129)) | (1L << (FORMAT - 129)) | (1L << (FUSION - 129)) | (1L << (GROUPING - 129)) | (1L << (HASH - 129)) | (1L << (INDEX - 129)) | (1L << (INCREMENT - 129)) | (1L << (INPUT - 129)) | (1L << (INSERT - 129)) | (1L << (INTERSECTION - 129)) | (1L << (ISCACHABLE - 129)) | (1L << (ISODOW - 129)) | (1L << (ISOYEAR - 129)) | (1L << (ISSTRICT - 129)) | (1L << (LANGUAGE - 129)) | (1L << (LARGE - 129)) | (1L << (LAST - 129)) | (1L << (LESS - 129)) | (1L << (LIST - 129)) | (1L << (LOCATION - 129)) | (1L << (MATCH - 129)) | (1L << (MAX - 129)) | (1L << (MAXVALUE - 129)) | (1L << (MICROSECONDS - 129)))) != 0) || ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & ((1L << (MILLENNIUM - 193)) | (1L << (MILLISECONDS - 193)) | (1L << (MIN - 193)) | (1L << (MINVALUE - 193)) | (1L << (MINUTE - 193)) | (1L << (MONTH - 193)) | (1L << (NATIONAL - 193)) | (1L << (NO - 193)) | (1L << (NONE - 193)) | (1L << (NULLIF - 193)) | (1L << (OBJECT - 193)) | (1L << (OPTION - 193)) | (1L << (OPTIONS - 193)) | (1L << (OVERWRITE - 193)) | (1L << (PARSER - 193)) | (1L << (PARTIAL - 193)) | (1L << (PARTITION - 193)) | (1L << (PARTITIONS - 193)) | (1L << (PRECISION - 193)) | (1L << (PUBLIC - 193)) | (1L << (PURGE - 193)) | (1L << (QUARTER - 193)) | (1L << (RANGE - 193)) | (1L << (REGEXP - 193)) | (1L << (RLIKE - 193)) | (1L << (ROLLUP - 193)) | (1L << (SEARCH - 193)) | (1L << (SECOND - 193)) | (1L << (SECURITY - 193)) | (1L << (SERVER - 193)) | (1L << (SET - 193)) | (1L << (SIMILAR - 193)) | (1L << (SIMPLE - 193)) | (1L << (STABLE - 193)) | (1L << (START - 193)) | (1L << (STORAGE - 193)) | (1L << (STDDEV_POP - 193)) | (1L << (STDDEV_SAMP - 193)) | (1L << (SUBPARTITION - 193)) | (1L << (SUM - 193)) | (1L << (TABLESPACE - 193)) | (1L << (TEMPLATE - 193)) | (1L << (THAN - 193)) | (1L << (TIMEZONE - 193)) | (1L << (TIMEZONE_HOUR - 193)) | (1L << (TIMEZONE_MINUTE - 193)) | (1L << (TRIM - 193)) | (1L << (TO - 193)) | (1L << (UNKNOWN - 193)) | (1L << (UNLOGGED - 193)) | (1L << (VALUES - 193)) | (1L << (VAR_SAMP - 193)) | (1L << (VAR_POP - 193)) | (1L << (VARYING - 193)) | (1L << (VOLATILE - 193)) | (1L << (WEEK - 193)) | (1L << (WINDOW - 193)) | (1L << (WRAPPER - 193)) | (1L << (YEAR - 193)) | (1L << (ZONE - 193)) | (1L << (BOOLEAN - 193)) | (1L << (BOOL - 193)))) != 0) || ((((_la - 257)) & ~0x3f) == 0 && ((1L << (_la - 257)) & ((1L << (BIT - 257)) | (1L << (VARBIT - 257)) | (1L << (INT1 - 257)) | (1L << (INT2 - 257)) | (1L << (INT4 - 257)) | (1L << (INT8 - 257)) | (1L << (TINYINT - 257)) | (1L << (SMALLINT - 257)) | (1L << (INT - 257)) | (1L << (INTEGER - 257)) | (1L << (BIGINT - 257)) | (1L << (FLOAT4 - 257)) | (1L << (FLOAT8 - 257)) | (1L << (REAL - 257)) | (1L << (FLOAT - 257)) | (1L << (DOUBLE - 257)) | (1L << (NUMERIC - 257)) | (1L << (DECIMAL - 257)) | (1L << (CHAR - 257)) | (1L << (VARCHAR - 257)) | (1L << (NCHAR - 257)) | (1L << (NVARCHAR - 257)) | (1L << (DATE - 257)) | (1L << (TIME - 257)) | (1L << (TIMETZ - 257)) | (1L << (TIMESTAMP - 257)) | (1L << (TIMESTAMPTZ - 257)) | (1L << (TEXT - 257)) | (1L << (VARBINARY - 257)) | (1L << (BLOB - 257)) | (1L << (BYTEA - 257)) | (1L << (INET4 - 257)) | (1L << (QUOTE - 257)))) != 0) || _la==Identifier );
					}
					break;
				case ALL:
					{
					setState(760); match(ALL);
					setState(761); match(SEQUENCES);
					setState(762); match(IN);
					setState(763); match(SCHEMA);
					setState(768); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(764); ((Revoke_statementContext)_localctx).schema_name = identifier();
						setState(766);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(765); match(COMMA);
							}
						}

						}
						}
						setState(770); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (ADMIN - 129)) | (1L << (AVG - 129)) | (1L << (BETWEEN - 129)) | (1L << (BY - 129)) | (1L << (CACHE - 129)) | (1L << (CALLED - 129)) | (1L << (CLASS - 129)) | (1L << (CENTURY - 129)) | (1L << (CHARACTER - 129)) | (1L << (CHECK - 129)) | (1L << (COLLECT - 129)) | (1L << (COALESCE - 129)) | (1L << (COLUMN - 129)) | (1L << (COMMENT - 129)) | (1L << (COMMENTS - 129)) | (1L << (COMMIT - 129)) | (1L << (CONFIGURATION - 129)) | (1L << (COST - 129)) | (1L << (COUNT - 129)) | (1L << (CUBE - 129)) | (1L << (CURRENT - 129)) | (1L << (CYCLE - 129)) | (1L << (DATA - 129)) | (1L << (DAY - 129)) | (1L << (DEC - 129)) | (1L << (DECADE - 129)) | (1L << (DEFINER - 129)) | (1L << (DICTIONARY - 129)) | (1L << (DOW - 129)) | (1L << (DOY - 129)) | (1L << (DROP - 129)) | (1L << (EPOCH - 129)) | (1L << (EVERY - 129)) | (1L << (EXISTS - 129)) | (1L << (EXTERNAL - 129)) | (1L << (EXTRACT - 129)) | (1L << (FAMILY - 129)) | (1L << (FILTER - 129)) | (1L << (FIRST - 129)) | (1L << (FORMAT - 129)) | (1L << (FUSION - 129)) | (1L << (GROUPING - 129)) | (1L << (HASH - 129)) | (1L << (INDEX - 129)) | (1L << (INCREMENT - 129)) | (1L << (INPUT - 129)) | (1L << (INSERT - 129)) | (1L << (INTERSECTION - 129)) | (1L << (ISCACHABLE - 129)) | (1L << (ISODOW - 129)) | (1L << (ISOYEAR - 129)) | (1L << (ISSTRICT - 129)) | (1L << (LANGUAGE - 129)) | (1L << (LARGE - 129)) | (1L << (LAST - 129)) | (1L << (LESS - 129)) | (1L << (LIST - 129)) | (1L << (LOCATION - 129)) | (1L << (MATCH - 129)) | (1L << (MAX - 129)) | (1L << (MAXVALUE - 129)) | (1L << (MICROSECONDS - 129)))) != 0) || ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & ((1L << (MILLENNIUM - 193)) | (1L << (MILLISECONDS - 193)) | (1L << (MIN - 193)) | (1L << (MINVALUE - 193)) | (1L << (MINUTE - 193)) | (1L << (MONTH - 193)) | (1L << (NATIONAL - 193)) | (1L << (NO - 193)) | (1L << (NONE - 193)) | (1L << (NULLIF - 193)) | (1L << (OBJECT - 193)) | (1L << (OPTION - 193)) | (1L << (OPTIONS - 193)) | (1L << (OVERWRITE - 193)) | (1L << (PARSER - 193)) | (1L << (PARTIAL - 193)) | (1L << (PARTITION - 193)) | (1L << (PARTITIONS - 193)) | (1L << (PRECISION - 193)) | (1L << (PUBLIC - 193)) | (1L << (PURGE - 193)) | (1L << (QUARTER - 193)) | (1L << (RANGE - 193)) | (1L << (REGEXP - 193)) | (1L << (RLIKE - 193)) | (1L << (ROLLUP - 193)) | (1L << (SEARCH - 193)) | (1L << (SECOND - 193)) | (1L << (SECURITY - 193)) | (1L << (SERVER - 193)) | (1L << (SET - 193)) | (1L << (SIMILAR - 193)) | (1L << (SIMPLE - 193)) | (1L << (STABLE - 193)) | (1L << (START - 193)) | (1L << (STORAGE - 193)) | (1L << (STDDEV_POP - 193)) | (1L << (STDDEV_SAMP - 193)) | (1L << (SUBPARTITION - 193)) | (1L << (SUM - 193)) | (1L << (TABLESPACE - 193)) | (1L << (TEMPLATE - 193)) | (1L << (THAN - 193)) | (1L << (TIMEZONE - 193)) | (1L << (TIMEZONE_HOUR - 193)) | (1L << (TIMEZONE_MINUTE - 193)) | (1L << (TRIM - 193)) | (1L << (TO - 193)) | (1L << (UNKNOWN - 193)) | (1L << (UNLOGGED - 193)) | (1L << (VALUES - 193)) | (1L << (VAR_SAMP - 193)) | (1L << (VAR_POP - 193)) | (1L << (VARYING - 193)) | (1L << (VOLATILE - 193)) | (1L << (WEEK - 193)) | (1L << (WINDOW - 193)) | (1L << (WRAPPER - 193)) | (1L << (YEAR - 193)) | (1L << (ZONE - 193)) | (1L << (BOOLEAN - 193)) | (1L << (BOOL - 193)))) != 0) || ((((_la - 257)) & ~0x3f) == 0 && ((1L << (_la - 257)) & ((1L << (BIT - 257)) | (1L << (VARBIT - 257)) | (1L << (INT1 - 257)) | (1L << (INT2 - 257)) | (1L << (INT4 - 257)) | (1L << (INT8 - 257)) | (1L << (TINYINT - 257)) | (1L << (SMALLINT - 257)) | (1L << (INT - 257)) | (1L << (INTEGER - 257)) | (1L << (BIGINT - 257)) | (1L << (FLOAT4 - 257)) | (1L << (FLOAT8 - 257)) | (1L << (REAL - 257)) | (1L << (FLOAT - 257)) | (1L << (DOUBLE - 257)) | (1L << (NUMERIC - 257)) | (1L << (DECIMAL - 257)) | (1L << (CHAR - 257)) | (1L << (VARCHAR - 257)) | (1L << (NCHAR - 257)) | (1L << (NVARCHAR - 257)) | (1L << (DATE - 257)) | (1L << (TIME - 257)) | (1L << (TIMETZ - 257)) | (1L << (TIMESTAMP - 257)) | (1L << (TIMESTAMPTZ - 257)) | (1L << (TEXT - 257)) | (1L << (VARBINARY - 257)) | (1L << (BLOB - 257)) | (1L << (BYTEA - 257)) | (1L << (INET4 - 257)) | (1L << (QUOTE - 257)))) != 0) || _la==Identifier );
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(774); revoke_from_cascade_restrict();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(776); match(REVOKE);
				setState(780);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(777); match(GRANT);
					setState(778); match(OPTION);
					setState(779); match(FOR);
					}
				}

				setState(791);
				switch (_input.LA(1)) {
				case CONNECT:
				case CREATE:
				case TEMP:
				case TEMPORARY:
					{
					setState(783); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(782);
						_la = _input.LA(1);
						if ( !(_la==CONNECT || _la==CREATE || _la==TEMP || _la==TEMPORARY) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
						}
						setState(785); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==CONNECT || _la==CREATE || _la==TEMP || _la==TEMPORARY );
					}
					break;
				case ALL:
					{
					setState(787); match(ALL);
					setState(789);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(788); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(793); match(ON);
				setState(794); match(DATABASE);
				setState(799); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(795); ((Revoke_statementContext)_localctx).database_name = identifier();
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
				} while ( ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (ADMIN - 129)) | (1L << (AVG - 129)) | (1L << (BETWEEN - 129)) | (1L << (BY - 129)) | (1L << (CACHE - 129)) | (1L << (CALLED - 129)) | (1L << (CLASS - 129)) | (1L << (CENTURY - 129)) | (1L << (CHARACTER - 129)) | (1L << (CHECK - 129)) | (1L << (COLLECT - 129)) | (1L << (COALESCE - 129)) | (1L << (COLUMN - 129)) | (1L << (COMMENT - 129)) | (1L << (COMMENTS - 129)) | (1L << (COMMIT - 129)) | (1L << (CONFIGURATION - 129)) | (1L << (COST - 129)) | (1L << (COUNT - 129)) | (1L << (CUBE - 129)) | (1L << (CURRENT - 129)) | (1L << (CYCLE - 129)) | (1L << (DATA - 129)) | (1L << (DAY - 129)) | (1L << (DEC - 129)) | (1L << (DECADE - 129)) | (1L << (DEFINER - 129)) | (1L << (DICTIONARY - 129)) | (1L << (DOW - 129)) | (1L << (DOY - 129)) | (1L << (DROP - 129)) | (1L << (EPOCH - 129)) | (1L << (EVERY - 129)) | (1L << (EXISTS - 129)) | (1L << (EXTERNAL - 129)) | (1L << (EXTRACT - 129)) | (1L << (FAMILY - 129)) | (1L << (FILTER - 129)) | (1L << (FIRST - 129)) | (1L << (FORMAT - 129)) | (1L << (FUSION - 129)) | (1L << (GROUPING - 129)) | (1L << (HASH - 129)) | (1L << (INDEX - 129)) | (1L << (INCREMENT - 129)) | (1L << (INPUT - 129)) | (1L << (INSERT - 129)) | (1L << (INTERSECTION - 129)) | (1L << (ISCACHABLE - 129)) | (1L << (ISODOW - 129)) | (1L << (ISOYEAR - 129)) | (1L << (ISSTRICT - 129)) | (1L << (LANGUAGE - 129)) | (1L << (LARGE - 129)) | (1L << (LAST - 129)) | (1L << (LESS - 129)) | (1L << (LIST - 129)) | (1L << (LOCATION - 129)) | (1L << (MATCH - 129)) | (1L << (MAX - 129)) | (1L << (MAXVALUE - 129)) | (1L << (MICROSECONDS - 129)))) != 0) || ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & ((1L << (MILLENNIUM - 193)) | (1L << (MILLISECONDS - 193)) | (1L << (MIN - 193)) | (1L << (MINVALUE - 193)) | (1L << (MINUTE - 193)) | (1L << (MONTH - 193)) | (1L << (NATIONAL - 193)) | (1L << (NO - 193)) | (1L << (NONE - 193)) | (1L << (NULLIF - 193)) | (1L << (OBJECT - 193)) | (1L << (OPTION - 193)) | (1L << (OPTIONS - 193)) | (1L << (OVERWRITE - 193)) | (1L << (PARSER - 193)) | (1L << (PARTIAL - 193)) | (1L << (PARTITION - 193)) | (1L << (PARTITIONS - 193)) | (1L << (PRECISION - 193)) | (1L << (PUBLIC - 193)) | (1L << (PURGE - 193)) | (1L << (QUARTER - 193)) | (1L << (RANGE - 193)) | (1L << (REGEXP - 193)) | (1L << (RLIKE - 193)) | (1L << (ROLLUP - 193)) | (1L << (SEARCH - 193)) | (1L << (SECOND - 193)) | (1L << (SECURITY - 193)) | (1L << (SERVER - 193)) | (1L << (SET - 193)) | (1L << (SIMILAR - 193)) | (1L << (SIMPLE - 193)) | (1L << (STABLE - 193)) | (1L << (START - 193)) | (1L << (STORAGE - 193)) | (1L << (STDDEV_POP - 193)) | (1L << (STDDEV_SAMP - 193)) | (1L << (SUBPARTITION - 193)) | (1L << (SUM - 193)) | (1L << (TABLESPACE - 193)) | (1L << (TEMPLATE - 193)) | (1L << (THAN - 193)) | (1L << (TIMEZONE - 193)) | (1L << (TIMEZONE_HOUR - 193)) | (1L << (TIMEZONE_MINUTE - 193)) | (1L << (TRIM - 193)) | (1L << (TO - 193)) | (1L << (UNKNOWN - 193)) | (1L << (UNLOGGED - 193)) | (1L << (VALUES - 193)) | (1L << (VAR_SAMP - 193)) | (1L << (VAR_POP - 193)) | (1L << (VARYING - 193)) | (1L << (VOLATILE - 193)) | (1L << (WEEK - 193)) | (1L << (WINDOW - 193)) | (1L << (WRAPPER - 193)) | (1L << (YEAR - 193)) | (1L << (ZONE - 193)) | (1L << (BOOLEAN - 193)) | (1L << (BOOL - 193)))) != 0) || ((((_la - 257)) & ~0x3f) == 0 && ((1L << (_la - 257)) & ((1L << (BIT - 257)) | (1L << (VARBIT - 257)) | (1L << (INT1 - 257)) | (1L << (INT2 - 257)) | (1L << (INT4 - 257)) | (1L << (INT8 - 257)) | (1L << (TINYINT - 257)) | (1L << (SMALLINT - 257)) | (1L << (INT - 257)) | (1L << (INTEGER - 257)) | (1L << (BIGINT - 257)) | (1L << (FLOAT4 - 257)) | (1L << (FLOAT8 - 257)) | (1L << (REAL - 257)) | (1L << (FLOAT - 257)) | (1L << (DOUBLE - 257)) | (1L << (NUMERIC - 257)) | (1L << (DECIMAL - 257)) | (1L << (CHAR - 257)) | (1L << (VARCHAR - 257)) | (1L << (NCHAR - 257)) | (1L << (NVARCHAR - 257)) | (1L << (DATE - 257)) | (1L << (TIME - 257)) | (1L << (TIMETZ - 257)) | (1L << (TIMESTAMP - 257)) | (1L << (TIMESTAMPTZ - 257)) | (1L << (TEXT - 257)) | (1L << (VARBINARY - 257)) | (1L << (BLOB - 257)) | (1L << (BYTEA - 257)) | (1L << (INET4 - 257)) | (1L << (QUOTE - 257)))) != 0) || _la==Identifier );
				setState(803); revoke_from_cascade_restrict();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(805); match(REVOKE);
				setState(809);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(806); match(GRANT);
					setState(807); match(OPTION);
					setState(808); match(FOR);
					}
				}

				setState(816);
				switch (_input.LA(1)) {
				case USAGE:
					{
					setState(811); match(USAGE);
					}
					break;
				case ALL:
					{
					setState(812); match(ALL);
					setState(814);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(813); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(818); match(ON);
				setState(819); match(FOREIGN);
				setState(820); match(DATA);
				setState(821); match(WRAPPER);
				setState(826); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(822); ((Revoke_statementContext)_localctx).fdw_name = schema_qualified_name();
					setState(824);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(823); match(COMMA);
						}
					}

					}
					}
					setState(828); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (ADMIN - 129)) | (1L << (AVG - 129)) | (1L << (BETWEEN - 129)) | (1L << (BY - 129)) | (1L << (CACHE - 129)) | (1L << (CALLED - 129)) | (1L << (CLASS - 129)) | (1L << (CENTURY - 129)) | (1L << (CHARACTER - 129)) | (1L << (CHECK - 129)) | (1L << (COLLECT - 129)) | (1L << (COALESCE - 129)) | (1L << (COLUMN - 129)) | (1L << (COMMENT - 129)) | (1L << (COMMENTS - 129)) | (1L << (COMMIT - 129)) | (1L << (CONFIGURATION - 129)) | (1L << (COST - 129)) | (1L << (COUNT - 129)) | (1L << (CUBE - 129)) | (1L << (CURRENT - 129)) | (1L << (CYCLE - 129)) | (1L << (DATA - 129)) | (1L << (DAY - 129)) | (1L << (DEC - 129)) | (1L << (DECADE - 129)) | (1L << (DEFINER - 129)) | (1L << (DICTIONARY - 129)) | (1L << (DOW - 129)) | (1L << (DOY - 129)) | (1L << (DROP - 129)) | (1L << (EPOCH - 129)) | (1L << (EVERY - 129)) | (1L << (EXISTS - 129)) | (1L << (EXTERNAL - 129)) | (1L << (EXTRACT - 129)) | (1L << (FAMILY - 129)) | (1L << (FILTER - 129)) | (1L << (FIRST - 129)) | (1L << (FORMAT - 129)) | (1L << (FUSION - 129)) | (1L << (GROUPING - 129)) | (1L << (HASH - 129)) | (1L << (INDEX - 129)) | (1L << (INCREMENT - 129)) | (1L << (INPUT - 129)) | (1L << (INSERT - 129)) | (1L << (INTERSECTION - 129)) | (1L << (ISCACHABLE - 129)) | (1L << (ISODOW - 129)) | (1L << (ISOYEAR - 129)) | (1L << (ISSTRICT - 129)) | (1L << (LANGUAGE - 129)) | (1L << (LARGE - 129)) | (1L << (LAST - 129)) | (1L << (LESS - 129)) | (1L << (LIST - 129)) | (1L << (LOCATION - 129)) | (1L << (MATCH - 129)) | (1L << (MAX - 129)) | (1L << (MAXVALUE - 129)) | (1L << (MICROSECONDS - 129)))) != 0) || ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & ((1L << (MILLENNIUM - 193)) | (1L << (MILLISECONDS - 193)) | (1L << (MIN - 193)) | (1L << (MINVALUE - 193)) | (1L << (MINUTE - 193)) | (1L << (MONTH - 193)) | (1L << (NATIONAL - 193)) | (1L << (NO - 193)) | (1L << (NONE - 193)) | (1L << (NULLIF - 193)) | (1L << (OBJECT - 193)) | (1L << (OPTION - 193)) | (1L << (OPTIONS - 193)) | (1L << (OVERWRITE - 193)) | (1L << (PARSER - 193)) | (1L << (PARTIAL - 193)) | (1L << (PARTITION - 193)) | (1L << (PARTITIONS - 193)) | (1L << (PRECISION - 193)) | (1L << (PUBLIC - 193)) | (1L << (PURGE - 193)) | (1L << (QUARTER - 193)) | (1L << (RANGE - 193)) | (1L << (REGEXP - 193)) | (1L << (RLIKE - 193)) | (1L << (ROLLUP - 193)) | (1L << (SEARCH - 193)) | (1L << (SECOND - 193)) | (1L << (SECURITY - 193)) | (1L << (SERVER - 193)) | (1L << (SET - 193)) | (1L << (SIMILAR - 193)) | (1L << (SIMPLE - 193)) | (1L << (STABLE - 193)) | (1L << (START - 193)) | (1L << (STORAGE - 193)) | (1L << (STDDEV_POP - 193)) | (1L << (STDDEV_SAMP - 193)) | (1L << (SUBPARTITION - 193)) | (1L << (SUM - 193)) | (1L << (TABLESPACE - 193)) | (1L << (TEMPLATE - 193)) | (1L << (THAN - 193)) | (1L << (TIMEZONE - 193)) | (1L << (TIMEZONE_HOUR - 193)) | (1L << (TIMEZONE_MINUTE - 193)) | (1L << (TRIM - 193)) | (1L << (TO - 193)) | (1L << (UNKNOWN - 193)) | (1L << (UNLOGGED - 193)) | (1L << (VALUES - 193)) | (1L << (VAR_SAMP - 193)) | (1L << (VAR_POP - 193)) | (1L << (VARYING - 193)) | (1L << (VOLATILE - 193)) | (1L << (WEEK - 193)) | (1L << (WINDOW - 193)) | (1L << (WRAPPER - 193)) | (1L << (YEAR - 193)) | (1L << (ZONE - 193)) | (1L << (BOOLEAN - 193)) | (1L << (BOOL - 193)))) != 0) || ((((_la - 257)) & ~0x3f) == 0 && ((1L << (_la - 257)) & ((1L << (BIT - 257)) | (1L << (VARBIT - 257)) | (1L << (INT1 - 257)) | (1L << (INT2 - 257)) | (1L << (INT4 - 257)) | (1L << (INT8 - 257)) | (1L << (TINYINT - 257)) | (1L << (SMALLINT - 257)) | (1L << (INT - 257)) | (1L << (INTEGER - 257)) | (1L << (BIGINT - 257)) | (1L << (FLOAT4 - 257)) | (1L << (FLOAT8 - 257)) | (1L << (REAL - 257)) | (1L << (FLOAT - 257)) | (1L << (DOUBLE - 257)) | (1L << (NUMERIC - 257)) | (1L << (DECIMAL - 257)) | (1L << (CHAR - 257)) | (1L << (VARCHAR - 257)) | (1L << (NCHAR - 257)) | (1L << (NVARCHAR - 257)) | (1L << (DATE - 257)) | (1L << (TIME - 257)) | (1L << (TIMETZ - 257)) | (1L << (TIMESTAMP - 257)) | (1L << (TIMESTAMPTZ - 257)) | (1L << (TEXT - 257)) | (1L << (VARBINARY - 257)) | (1L << (BLOB - 257)) | (1L << (BYTEA - 257)) | (1L << (INET4 - 257)) | (1L << (QUOTE - 257)))) != 0) || _la==Identifier );
				setState(830); revoke_from_cascade_restrict();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(832); match(REVOKE);
				setState(836);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(833); match(GRANT);
					setState(834); match(OPTION);
					setState(835); match(FOR);
					}
				}

				setState(843);
				switch (_input.LA(1)) {
				case USAGE:
					{
					setState(838); match(USAGE);
					}
					break;
				case ALL:
					{
					setState(839); match(ALL);
					setState(841);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(840); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(845); match(ON);
				setState(846); match(FOREIGN);
				setState(847); match(SERVER);
				setState(852); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(848); ((Revoke_statementContext)_localctx).server_name = identifier();
					setState(850);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(849); match(COMMA);
						}
					}

					}
					}
					setState(854); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (ADMIN - 129)) | (1L << (AVG - 129)) | (1L << (BETWEEN - 129)) | (1L << (BY - 129)) | (1L << (CACHE - 129)) | (1L << (CALLED - 129)) | (1L << (CLASS - 129)) | (1L << (CENTURY - 129)) | (1L << (CHARACTER - 129)) | (1L << (CHECK - 129)) | (1L << (COLLECT - 129)) | (1L << (COALESCE - 129)) | (1L << (COLUMN - 129)) | (1L << (COMMENT - 129)) | (1L << (COMMENTS - 129)) | (1L << (COMMIT - 129)) | (1L << (CONFIGURATION - 129)) | (1L << (COST - 129)) | (1L << (COUNT - 129)) | (1L << (CUBE - 129)) | (1L << (CURRENT - 129)) | (1L << (CYCLE - 129)) | (1L << (DATA - 129)) | (1L << (DAY - 129)) | (1L << (DEC - 129)) | (1L << (DECADE - 129)) | (1L << (DEFINER - 129)) | (1L << (DICTIONARY - 129)) | (1L << (DOW - 129)) | (1L << (DOY - 129)) | (1L << (DROP - 129)) | (1L << (EPOCH - 129)) | (1L << (EVERY - 129)) | (1L << (EXISTS - 129)) | (1L << (EXTERNAL - 129)) | (1L << (EXTRACT - 129)) | (1L << (FAMILY - 129)) | (1L << (FILTER - 129)) | (1L << (FIRST - 129)) | (1L << (FORMAT - 129)) | (1L << (FUSION - 129)) | (1L << (GROUPING - 129)) | (1L << (HASH - 129)) | (1L << (INDEX - 129)) | (1L << (INCREMENT - 129)) | (1L << (INPUT - 129)) | (1L << (INSERT - 129)) | (1L << (INTERSECTION - 129)) | (1L << (ISCACHABLE - 129)) | (1L << (ISODOW - 129)) | (1L << (ISOYEAR - 129)) | (1L << (ISSTRICT - 129)) | (1L << (LANGUAGE - 129)) | (1L << (LARGE - 129)) | (1L << (LAST - 129)) | (1L << (LESS - 129)) | (1L << (LIST - 129)) | (1L << (LOCATION - 129)) | (1L << (MATCH - 129)) | (1L << (MAX - 129)) | (1L << (MAXVALUE - 129)) | (1L << (MICROSECONDS - 129)))) != 0) || ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & ((1L << (MILLENNIUM - 193)) | (1L << (MILLISECONDS - 193)) | (1L << (MIN - 193)) | (1L << (MINVALUE - 193)) | (1L << (MINUTE - 193)) | (1L << (MONTH - 193)) | (1L << (NATIONAL - 193)) | (1L << (NO - 193)) | (1L << (NONE - 193)) | (1L << (NULLIF - 193)) | (1L << (OBJECT - 193)) | (1L << (OPTION - 193)) | (1L << (OPTIONS - 193)) | (1L << (OVERWRITE - 193)) | (1L << (PARSER - 193)) | (1L << (PARTIAL - 193)) | (1L << (PARTITION - 193)) | (1L << (PARTITIONS - 193)) | (1L << (PRECISION - 193)) | (1L << (PUBLIC - 193)) | (1L << (PURGE - 193)) | (1L << (QUARTER - 193)) | (1L << (RANGE - 193)) | (1L << (REGEXP - 193)) | (1L << (RLIKE - 193)) | (1L << (ROLLUP - 193)) | (1L << (SEARCH - 193)) | (1L << (SECOND - 193)) | (1L << (SECURITY - 193)) | (1L << (SERVER - 193)) | (1L << (SET - 193)) | (1L << (SIMILAR - 193)) | (1L << (SIMPLE - 193)) | (1L << (STABLE - 193)) | (1L << (START - 193)) | (1L << (STORAGE - 193)) | (1L << (STDDEV_POP - 193)) | (1L << (STDDEV_SAMP - 193)) | (1L << (SUBPARTITION - 193)) | (1L << (SUM - 193)) | (1L << (TABLESPACE - 193)) | (1L << (TEMPLATE - 193)) | (1L << (THAN - 193)) | (1L << (TIMEZONE - 193)) | (1L << (TIMEZONE_HOUR - 193)) | (1L << (TIMEZONE_MINUTE - 193)) | (1L << (TRIM - 193)) | (1L << (TO - 193)) | (1L << (UNKNOWN - 193)) | (1L << (UNLOGGED - 193)) | (1L << (VALUES - 193)) | (1L << (VAR_SAMP - 193)) | (1L << (VAR_POP - 193)) | (1L << (VARYING - 193)) | (1L << (VOLATILE - 193)) | (1L << (WEEK - 193)) | (1L << (WINDOW - 193)) | (1L << (WRAPPER - 193)) | (1L << (YEAR - 193)) | (1L << (ZONE - 193)) | (1L << (BOOLEAN - 193)) | (1L << (BOOL - 193)))) != 0) || ((((_la - 257)) & ~0x3f) == 0 && ((1L << (_la - 257)) & ((1L << (BIT - 257)) | (1L << (VARBIT - 257)) | (1L << (INT1 - 257)) | (1L << (INT2 - 257)) | (1L << (INT4 - 257)) | (1L << (INT8 - 257)) | (1L << (TINYINT - 257)) | (1L << (SMALLINT - 257)) | (1L << (INT - 257)) | (1L << (INTEGER - 257)) | (1L << (BIGINT - 257)) | (1L << (FLOAT4 - 257)) | (1L << (FLOAT8 - 257)) | (1L << (REAL - 257)) | (1L << (FLOAT - 257)) | (1L << (DOUBLE - 257)) | (1L << (NUMERIC - 257)) | (1L << (DECIMAL - 257)) | (1L << (CHAR - 257)) | (1L << (VARCHAR - 257)) | (1L << (NCHAR - 257)) | (1L << (NVARCHAR - 257)) | (1L << (DATE - 257)) | (1L << (TIME - 257)) | (1L << (TIMETZ - 257)) | (1L << (TIMESTAMP - 257)) | (1L << (TIMESTAMPTZ - 257)) | (1L << (TEXT - 257)) | (1L << (VARBINARY - 257)) | (1L << (BLOB - 257)) | (1L << (BYTEA - 257)) | (1L << (INET4 - 257)) | (1L << (QUOTE - 257)))) != 0) || _la==Identifier );
				setState(856); revoke_from_cascade_restrict();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(858); match(REVOKE);
				setState(862);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(859); match(GRANT);
					setState(860); match(OPTION);
					setState(861); match(FOR);
					}
				}

				setState(869);
				switch (_input.LA(1)) {
				case EXECUTE:
					{
					setState(864); match(EXECUTE);
					}
					break;
				case ALL:
					{
					setState(865); match(ALL);
					setState(867);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(866); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(871); match(ON);
				setState(874);
				switch (_input.LA(1)) {
				case FUNCTION:
					{
					setState(872); function_definition();
					}
					break;
				case ALL:
					{
					setState(873); functions_definition_schema();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(876); revoke_from_cascade_restrict();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(878); match(REVOKE);
				setState(882);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(879); match(GRANT);
					setState(880); match(OPTION);
					setState(881); match(FOR);
					}
				}

				setState(889);
				switch (_input.LA(1)) {
				case USAGE:
					{
					setState(884); match(USAGE);
					}
					break;
				case ALL:
					{
					setState(885); match(ALL);
					setState(887);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(886); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(891); match(ON);
				setState(892); match(LANGUAGE);
				setState(897); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(893); ((Revoke_statementContext)_localctx).lang_name = identifier();
					setState(895);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(894); match(COMMA);
						}
					}

					}
					}
					setState(899); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (ADMIN - 129)) | (1L << (AVG - 129)) | (1L << (BETWEEN - 129)) | (1L << (BY - 129)) | (1L << (CACHE - 129)) | (1L << (CALLED - 129)) | (1L << (CLASS - 129)) | (1L << (CENTURY - 129)) | (1L << (CHARACTER - 129)) | (1L << (CHECK - 129)) | (1L << (COLLECT - 129)) | (1L << (COALESCE - 129)) | (1L << (COLUMN - 129)) | (1L << (COMMENT - 129)) | (1L << (COMMENTS - 129)) | (1L << (COMMIT - 129)) | (1L << (CONFIGURATION - 129)) | (1L << (COST - 129)) | (1L << (COUNT - 129)) | (1L << (CUBE - 129)) | (1L << (CURRENT - 129)) | (1L << (CYCLE - 129)) | (1L << (DATA - 129)) | (1L << (DAY - 129)) | (1L << (DEC - 129)) | (1L << (DECADE - 129)) | (1L << (DEFINER - 129)) | (1L << (DICTIONARY - 129)) | (1L << (DOW - 129)) | (1L << (DOY - 129)) | (1L << (DROP - 129)) | (1L << (EPOCH - 129)) | (1L << (EVERY - 129)) | (1L << (EXISTS - 129)) | (1L << (EXTERNAL - 129)) | (1L << (EXTRACT - 129)) | (1L << (FAMILY - 129)) | (1L << (FILTER - 129)) | (1L << (FIRST - 129)) | (1L << (FORMAT - 129)) | (1L << (FUSION - 129)) | (1L << (GROUPING - 129)) | (1L << (HASH - 129)) | (1L << (INDEX - 129)) | (1L << (INCREMENT - 129)) | (1L << (INPUT - 129)) | (1L << (INSERT - 129)) | (1L << (INTERSECTION - 129)) | (1L << (ISCACHABLE - 129)) | (1L << (ISODOW - 129)) | (1L << (ISOYEAR - 129)) | (1L << (ISSTRICT - 129)) | (1L << (LANGUAGE - 129)) | (1L << (LARGE - 129)) | (1L << (LAST - 129)) | (1L << (LESS - 129)) | (1L << (LIST - 129)) | (1L << (LOCATION - 129)) | (1L << (MATCH - 129)) | (1L << (MAX - 129)) | (1L << (MAXVALUE - 129)) | (1L << (MICROSECONDS - 129)))) != 0) || ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & ((1L << (MILLENNIUM - 193)) | (1L << (MILLISECONDS - 193)) | (1L << (MIN - 193)) | (1L << (MINVALUE - 193)) | (1L << (MINUTE - 193)) | (1L << (MONTH - 193)) | (1L << (NATIONAL - 193)) | (1L << (NO - 193)) | (1L << (NONE - 193)) | (1L << (NULLIF - 193)) | (1L << (OBJECT - 193)) | (1L << (OPTION - 193)) | (1L << (OPTIONS - 193)) | (1L << (OVERWRITE - 193)) | (1L << (PARSER - 193)) | (1L << (PARTIAL - 193)) | (1L << (PARTITION - 193)) | (1L << (PARTITIONS - 193)) | (1L << (PRECISION - 193)) | (1L << (PUBLIC - 193)) | (1L << (PURGE - 193)) | (1L << (QUARTER - 193)) | (1L << (RANGE - 193)) | (1L << (REGEXP - 193)) | (1L << (RLIKE - 193)) | (1L << (ROLLUP - 193)) | (1L << (SEARCH - 193)) | (1L << (SECOND - 193)) | (1L << (SECURITY - 193)) | (1L << (SERVER - 193)) | (1L << (SET - 193)) | (1L << (SIMILAR - 193)) | (1L << (SIMPLE - 193)) | (1L << (STABLE - 193)) | (1L << (START - 193)) | (1L << (STORAGE - 193)) | (1L << (STDDEV_POP - 193)) | (1L << (STDDEV_SAMP - 193)) | (1L << (SUBPARTITION - 193)) | (1L << (SUM - 193)) | (1L << (TABLESPACE - 193)) | (1L << (TEMPLATE - 193)) | (1L << (THAN - 193)) | (1L << (TIMEZONE - 193)) | (1L << (TIMEZONE_HOUR - 193)) | (1L << (TIMEZONE_MINUTE - 193)) | (1L << (TRIM - 193)) | (1L << (TO - 193)) | (1L << (UNKNOWN - 193)) | (1L << (UNLOGGED - 193)) | (1L << (VALUES - 193)) | (1L << (VAR_SAMP - 193)) | (1L << (VAR_POP - 193)) | (1L << (VARYING - 193)) | (1L << (VOLATILE - 193)) | (1L << (WEEK - 193)) | (1L << (WINDOW - 193)) | (1L << (WRAPPER - 193)) | (1L << (YEAR - 193)) | (1L << (ZONE - 193)) | (1L << (BOOLEAN - 193)) | (1L << (BOOL - 193)))) != 0) || ((((_la - 257)) & ~0x3f) == 0 && ((1L << (_la - 257)) & ((1L << (BIT - 257)) | (1L << (VARBIT - 257)) | (1L << (INT1 - 257)) | (1L << (INT2 - 257)) | (1L << (INT4 - 257)) | (1L << (INT8 - 257)) | (1L << (TINYINT - 257)) | (1L << (SMALLINT - 257)) | (1L << (INT - 257)) | (1L << (INTEGER - 257)) | (1L << (BIGINT - 257)) | (1L << (FLOAT4 - 257)) | (1L << (FLOAT8 - 257)) | (1L << (REAL - 257)) | (1L << (FLOAT - 257)) | (1L << (DOUBLE - 257)) | (1L << (NUMERIC - 257)) | (1L << (DECIMAL - 257)) | (1L << (CHAR - 257)) | (1L << (VARCHAR - 257)) | (1L << (NCHAR - 257)) | (1L << (NVARCHAR - 257)) | (1L << (DATE - 257)) | (1L << (TIME - 257)) | (1L << (TIMETZ - 257)) | (1L << (TIMESTAMP - 257)) | (1L << (TIMESTAMPTZ - 257)) | (1L << (TEXT - 257)) | (1L << (VARBINARY - 257)) | (1L << (BLOB - 257)) | (1L << (BYTEA - 257)) | (1L << (INET4 - 257)) | (1L << (QUOTE - 257)))) != 0) || _la==Identifier );
				setState(901); revoke_from_cascade_restrict();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(903); match(REVOKE);
				setState(907);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(904); match(GRANT);
					setState(905); match(OPTION);
					setState(906); match(FOR);
					}
				}

				setState(922);
				switch (_input.LA(1)) {
				case SELECT:
				case UPDATE:
					{
					setState(914); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						setState(914);
						switch (_input.LA(1)) {
						case SELECT:
							{
							setState(909); match(SELECT);
							}
							break;
						case UPDATE:
							{
							setState(910); match(UPDATE);
							setState(912);
							_la = _input.LA(1);
							if (_la==COMMA) {
								{
								setState(911); match(COMMA);
								}
							}

							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						setState(916); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==SELECT || _la==UPDATE );
					}
					break;
				case ALL:
					{
					setState(918); match(ALL);
					setState(920);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(919); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(924); match(ON);
				setState(925); match(LARGE);
				setState(926); match(OBJECT);
				setState(931); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(927); ((Revoke_statementContext)_localctx).loid = identifier();
					setState(929);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(928); match(COMMA);
						}
					}

					}
					}
					setState(933); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (ADMIN - 129)) | (1L << (AVG - 129)) | (1L << (BETWEEN - 129)) | (1L << (BY - 129)) | (1L << (CACHE - 129)) | (1L << (CALLED - 129)) | (1L << (CLASS - 129)) | (1L << (CENTURY - 129)) | (1L << (CHARACTER - 129)) | (1L << (CHECK - 129)) | (1L << (COLLECT - 129)) | (1L << (COALESCE - 129)) | (1L << (COLUMN - 129)) | (1L << (COMMENT - 129)) | (1L << (COMMENTS - 129)) | (1L << (COMMIT - 129)) | (1L << (CONFIGURATION - 129)) | (1L << (COST - 129)) | (1L << (COUNT - 129)) | (1L << (CUBE - 129)) | (1L << (CURRENT - 129)) | (1L << (CYCLE - 129)) | (1L << (DATA - 129)) | (1L << (DAY - 129)) | (1L << (DEC - 129)) | (1L << (DECADE - 129)) | (1L << (DEFINER - 129)) | (1L << (DICTIONARY - 129)) | (1L << (DOW - 129)) | (1L << (DOY - 129)) | (1L << (DROP - 129)) | (1L << (EPOCH - 129)) | (1L << (EVERY - 129)) | (1L << (EXISTS - 129)) | (1L << (EXTERNAL - 129)) | (1L << (EXTRACT - 129)) | (1L << (FAMILY - 129)) | (1L << (FILTER - 129)) | (1L << (FIRST - 129)) | (1L << (FORMAT - 129)) | (1L << (FUSION - 129)) | (1L << (GROUPING - 129)) | (1L << (HASH - 129)) | (1L << (INDEX - 129)) | (1L << (INCREMENT - 129)) | (1L << (INPUT - 129)) | (1L << (INSERT - 129)) | (1L << (INTERSECTION - 129)) | (1L << (ISCACHABLE - 129)) | (1L << (ISODOW - 129)) | (1L << (ISOYEAR - 129)) | (1L << (ISSTRICT - 129)) | (1L << (LANGUAGE - 129)) | (1L << (LARGE - 129)) | (1L << (LAST - 129)) | (1L << (LESS - 129)) | (1L << (LIST - 129)) | (1L << (LOCATION - 129)) | (1L << (MATCH - 129)) | (1L << (MAX - 129)) | (1L << (MAXVALUE - 129)) | (1L << (MICROSECONDS - 129)))) != 0) || ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & ((1L << (MILLENNIUM - 193)) | (1L << (MILLISECONDS - 193)) | (1L << (MIN - 193)) | (1L << (MINVALUE - 193)) | (1L << (MINUTE - 193)) | (1L << (MONTH - 193)) | (1L << (NATIONAL - 193)) | (1L << (NO - 193)) | (1L << (NONE - 193)) | (1L << (NULLIF - 193)) | (1L << (OBJECT - 193)) | (1L << (OPTION - 193)) | (1L << (OPTIONS - 193)) | (1L << (OVERWRITE - 193)) | (1L << (PARSER - 193)) | (1L << (PARTIAL - 193)) | (1L << (PARTITION - 193)) | (1L << (PARTITIONS - 193)) | (1L << (PRECISION - 193)) | (1L << (PUBLIC - 193)) | (1L << (PURGE - 193)) | (1L << (QUARTER - 193)) | (1L << (RANGE - 193)) | (1L << (REGEXP - 193)) | (1L << (RLIKE - 193)) | (1L << (ROLLUP - 193)) | (1L << (SEARCH - 193)) | (1L << (SECOND - 193)) | (1L << (SECURITY - 193)) | (1L << (SERVER - 193)) | (1L << (SET - 193)) | (1L << (SIMILAR - 193)) | (1L << (SIMPLE - 193)) | (1L << (STABLE - 193)) | (1L << (START - 193)) | (1L << (STORAGE - 193)) | (1L << (STDDEV_POP - 193)) | (1L << (STDDEV_SAMP - 193)) | (1L << (SUBPARTITION - 193)) | (1L << (SUM - 193)) | (1L << (TABLESPACE - 193)) | (1L << (TEMPLATE - 193)) | (1L << (THAN - 193)) | (1L << (TIMEZONE - 193)) | (1L << (TIMEZONE_HOUR - 193)) | (1L << (TIMEZONE_MINUTE - 193)) | (1L << (TRIM - 193)) | (1L << (TO - 193)) | (1L << (UNKNOWN - 193)) | (1L << (UNLOGGED - 193)) | (1L << (VALUES - 193)) | (1L << (VAR_SAMP - 193)) | (1L << (VAR_POP - 193)) | (1L << (VARYING - 193)) | (1L << (VOLATILE - 193)) | (1L << (WEEK - 193)) | (1L << (WINDOW - 193)) | (1L << (WRAPPER - 193)) | (1L << (YEAR - 193)) | (1L << (ZONE - 193)) | (1L << (BOOLEAN - 193)) | (1L << (BOOL - 193)))) != 0) || ((((_la - 257)) & ~0x3f) == 0 && ((1L << (_la - 257)) & ((1L << (BIT - 257)) | (1L << (VARBIT - 257)) | (1L << (INT1 - 257)) | (1L << (INT2 - 257)) | (1L << (INT4 - 257)) | (1L << (INT8 - 257)) | (1L << (TINYINT - 257)) | (1L << (SMALLINT - 257)) | (1L << (INT - 257)) | (1L << (INTEGER - 257)) | (1L << (BIGINT - 257)) | (1L << (FLOAT4 - 257)) | (1L << (FLOAT8 - 257)) | (1L << (REAL - 257)) | (1L << (FLOAT - 257)) | (1L << (DOUBLE - 257)) | (1L << (NUMERIC - 257)) | (1L << (DECIMAL - 257)) | (1L << (CHAR - 257)) | (1L << (VARCHAR - 257)) | (1L << (NCHAR - 257)) | (1L << (NVARCHAR - 257)) | (1L << (DATE - 257)) | (1L << (TIME - 257)) | (1L << (TIMETZ - 257)) | (1L << (TIMESTAMP - 257)) | (1L << (TIMESTAMPTZ - 257)) | (1L << (TEXT - 257)) | (1L << (VARBINARY - 257)) | (1L << (BLOB - 257)) | (1L << (BYTEA - 257)) | (1L << (INET4 - 257)) | (1L << (QUOTE - 257)))) != 0) || _la==Identifier );
				setState(935); revoke_from_cascade_restrict();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(937); match(REVOKE);
				setState(941);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(938); match(GRANT);
					setState(939); match(OPTION);
					setState(940); match(FOR);
					}
				}

				setState(955);
				switch (_input.LA(1)) {
				case CREATE:
				case USAGE:
					{
					setState(947); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(943);
						_la = _input.LA(1);
						if ( !(_la==CREATE || _la==USAGE) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(945);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(944); match(COMMA);
							}
						}

						}
						}
						setState(949); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==CREATE || _la==USAGE );
					}
					break;
				case ALL:
					{
					setState(951); match(ALL);
					setState(953);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(952); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(957); match(ON);
				setState(958); match(SCHEMA);
				setState(963); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(959); ((Revoke_statementContext)_localctx).schema_name = identifier();
					setState(961);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(960); match(COMMA);
						}
					}

					}
					}
					setState(965); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (ADMIN - 129)) | (1L << (AVG - 129)) | (1L << (BETWEEN - 129)) | (1L << (BY - 129)) | (1L << (CACHE - 129)) | (1L << (CALLED - 129)) | (1L << (CLASS - 129)) | (1L << (CENTURY - 129)) | (1L << (CHARACTER - 129)) | (1L << (CHECK - 129)) | (1L << (COLLECT - 129)) | (1L << (COALESCE - 129)) | (1L << (COLUMN - 129)) | (1L << (COMMENT - 129)) | (1L << (COMMENTS - 129)) | (1L << (COMMIT - 129)) | (1L << (CONFIGURATION - 129)) | (1L << (COST - 129)) | (1L << (COUNT - 129)) | (1L << (CUBE - 129)) | (1L << (CURRENT - 129)) | (1L << (CYCLE - 129)) | (1L << (DATA - 129)) | (1L << (DAY - 129)) | (1L << (DEC - 129)) | (1L << (DECADE - 129)) | (1L << (DEFINER - 129)) | (1L << (DICTIONARY - 129)) | (1L << (DOW - 129)) | (1L << (DOY - 129)) | (1L << (DROP - 129)) | (1L << (EPOCH - 129)) | (1L << (EVERY - 129)) | (1L << (EXISTS - 129)) | (1L << (EXTERNAL - 129)) | (1L << (EXTRACT - 129)) | (1L << (FAMILY - 129)) | (1L << (FILTER - 129)) | (1L << (FIRST - 129)) | (1L << (FORMAT - 129)) | (1L << (FUSION - 129)) | (1L << (GROUPING - 129)) | (1L << (HASH - 129)) | (1L << (INDEX - 129)) | (1L << (INCREMENT - 129)) | (1L << (INPUT - 129)) | (1L << (INSERT - 129)) | (1L << (INTERSECTION - 129)) | (1L << (ISCACHABLE - 129)) | (1L << (ISODOW - 129)) | (1L << (ISOYEAR - 129)) | (1L << (ISSTRICT - 129)) | (1L << (LANGUAGE - 129)) | (1L << (LARGE - 129)) | (1L << (LAST - 129)) | (1L << (LESS - 129)) | (1L << (LIST - 129)) | (1L << (LOCATION - 129)) | (1L << (MATCH - 129)) | (1L << (MAX - 129)) | (1L << (MAXVALUE - 129)) | (1L << (MICROSECONDS - 129)))) != 0) || ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & ((1L << (MILLENNIUM - 193)) | (1L << (MILLISECONDS - 193)) | (1L << (MIN - 193)) | (1L << (MINVALUE - 193)) | (1L << (MINUTE - 193)) | (1L << (MONTH - 193)) | (1L << (NATIONAL - 193)) | (1L << (NO - 193)) | (1L << (NONE - 193)) | (1L << (NULLIF - 193)) | (1L << (OBJECT - 193)) | (1L << (OPTION - 193)) | (1L << (OPTIONS - 193)) | (1L << (OVERWRITE - 193)) | (1L << (PARSER - 193)) | (1L << (PARTIAL - 193)) | (1L << (PARTITION - 193)) | (1L << (PARTITIONS - 193)) | (1L << (PRECISION - 193)) | (1L << (PUBLIC - 193)) | (1L << (PURGE - 193)) | (1L << (QUARTER - 193)) | (1L << (RANGE - 193)) | (1L << (REGEXP - 193)) | (1L << (RLIKE - 193)) | (1L << (ROLLUP - 193)) | (1L << (SEARCH - 193)) | (1L << (SECOND - 193)) | (1L << (SECURITY - 193)) | (1L << (SERVER - 193)) | (1L << (SET - 193)) | (1L << (SIMILAR - 193)) | (1L << (SIMPLE - 193)) | (1L << (STABLE - 193)) | (1L << (START - 193)) | (1L << (STORAGE - 193)) | (1L << (STDDEV_POP - 193)) | (1L << (STDDEV_SAMP - 193)) | (1L << (SUBPARTITION - 193)) | (1L << (SUM - 193)) | (1L << (TABLESPACE - 193)) | (1L << (TEMPLATE - 193)) | (1L << (THAN - 193)) | (1L << (TIMEZONE - 193)) | (1L << (TIMEZONE_HOUR - 193)) | (1L << (TIMEZONE_MINUTE - 193)) | (1L << (TRIM - 193)) | (1L << (TO - 193)) | (1L << (UNKNOWN - 193)) | (1L << (UNLOGGED - 193)) | (1L << (VALUES - 193)) | (1L << (VAR_SAMP - 193)) | (1L << (VAR_POP - 193)) | (1L << (VARYING - 193)) | (1L << (VOLATILE - 193)) | (1L << (WEEK - 193)) | (1L << (WINDOW - 193)) | (1L << (WRAPPER - 193)) | (1L << (YEAR - 193)) | (1L << (ZONE - 193)) | (1L << (BOOLEAN - 193)) | (1L << (BOOL - 193)))) != 0) || ((((_la - 257)) & ~0x3f) == 0 && ((1L << (_la - 257)) & ((1L << (BIT - 257)) | (1L << (VARBIT - 257)) | (1L << (INT1 - 257)) | (1L << (INT2 - 257)) | (1L << (INT4 - 257)) | (1L << (INT8 - 257)) | (1L << (TINYINT - 257)) | (1L << (SMALLINT - 257)) | (1L << (INT - 257)) | (1L << (INTEGER - 257)) | (1L << (BIGINT - 257)) | (1L << (FLOAT4 - 257)) | (1L << (FLOAT8 - 257)) | (1L << (REAL - 257)) | (1L << (FLOAT - 257)) | (1L << (DOUBLE - 257)) | (1L << (NUMERIC - 257)) | (1L << (DECIMAL - 257)) | (1L << (CHAR - 257)) | (1L << (VARCHAR - 257)) | (1L << (NCHAR - 257)) | (1L << (NVARCHAR - 257)) | (1L << (DATE - 257)) | (1L << (TIME - 257)) | (1L << (TIMETZ - 257)) | (1L << (TIMESTAMP - 257)) | (1L << (TIMESTAMPTZ - 257)) | (1L << (TEXT - 257)) | (1L << (VARBINARY - 257)) | (1L << (BLOB - 257)) | (1L << (BYTEA - 257)) | (1L << (INET4 - 257)) | (1L << (QUOTE - 257)))) != 0) || _la==Identifier );
				setState(967); revoke_from_cascade_restrict();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(969); match(REVOKE);
				setState(973);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(970); match(GRANT);
					setState(971); match(OPTION);
					setState(972); match(FOR);
					}
				}

				setState(980);
				switch (_input.LA(1)) {
				case CREATE:
					{
					setState(975); match(CREATE);
					}
					break;
				case ALL:
					{
					setState(976); match(ALL);
					setState(978);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(977); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(982); match(ON);
				setState(983); match(TABLESPACE);
				setState(988); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(984); ((Revoke_statementContext)_localctx).tablespace_name = identifier();
					setState(986);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(985); match(COMMA);
						}
					}

					}
					}
					setState(990); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (ADMIN - 129)) | (1L << (AVG - 129)) | (1L << (BETWEEN - 129)) | (1L << (BY - 129)) | (1L << (CACHE - 129)) | (1L << (CALLED - 129)) | (1L << (CLASS - 129)) | (1L << (CENTURY - 129)) | (1L << (CHARACTER - 129)) | (1L << (CHECK - 129)) | (1L << (COLLECT - 129)) | (1L << (COALESCE - 129)) | (1L << (COLUMN - 129)) | (1L << (COMMENT - 129)) | (1L << (COMMENTS - 129)) | (1L << (COMMIT - 129)) | (1L << (CONFIGURATION - 129)) | (1L << (COST - 129)) | (1L << (COUNT - 129)) | (1L << (CUBE - 129)) | (1L << (CURRENT - 129)) | (1L << (CYCLE - 129)) | (1L << (DATA - 129)) | (1L << (DAY - 129)) | (1L << (DEC - 129)) | (1L << (DECADE - 129)) | (1L << (DEFINER - 129)) | (1L << (DICTIONARY - 129)) | (1L << (DOW - 129)) | (1L << (DOY - 129)) | (1L << (DROP - 129)) | (1L << (EPOCH - 129)) | (1L << (EVERY - 129)) | (1L << (EXISTS - 129)) | (1L << (EXTERNAL - 129)) | (1L << (EXTRACT - 129)) | (1L << (FAMILY - 129)) | (1L << (FILTER - 129)) | (1L << (FIRST - 129)) | (1L << (FORMAT - 129)) | (1L << (FUSION - 129)) | (1L << (GROUPING - 129)) | (1L << (HASH - 129)) | (1L << (INDEX - 129)) | (1L << (INCREMENT - 129)) | (1L << (INPUT - 129)) | (1L << (INSERT - 129)) | (1L << (INTERSECTION - 129)) | (1L << (ISCACHABLE - 129)) | (1L << (ISODOW - 129)) | (1L << (ISOYEAR - 129)) | (1L << (ISSTRICT - 129)) | (1L << (LANGUAGE - 129)) | (1L << (LARGE - 129)) | (1L << (LAST - 129)) | (1L << (LESS - 129)) | (1L << (LIST - 129)) | (1L << (LOCATION - 129)) | (1L << (MATCH - 129)) | (1L << (MAX - 129)) | (1L << (MAXVALUE - 129)) | (1L << (MICROSECONDS - 129)))) != 0) || ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & ((1L << (MILLENNIUM - 193)) | (1L << (MILLISECONDS - 193)) | (1L << (MIN - 193)) | (1L << (MINVALUE - 193)) | (1L << (MINUTE - 193)) | (1L << (MONTH - 193)) | (1L << (NATIONAL - 193)) | (1L << (NO - 193)) | (1L << (NONE - 193)) | (1L << (NULLIF - 193)) | (1L << (OBJECT - 193)) | (1L << (OPTION - 193)) | (1L << (OPTIONS - 193)) | (1L << (OVERWRITE - 193)) | (1L << (PARSER - 193)) | (1L << (PARTIAL - 193)) | (1L << (PARTITION - 193)) | (1L << (PARTITIONS - 193)) | (1L << (PRECISION - 193)) | (1L << (PUBLIC - 193)) | (1L << (PURGE - 193)) | (1L << (QUARTER - 193)) | (1L << (RANGE - 193)) | (1L << (REGEXP - 193)) | (1L << (RLIKE - 193)) | (1L << (ROLLUP - 193)) | (1L << (SEARCH - 193)) | (1L << (SECOND - 193)) | (1L << (SECURITY - 193)) | (1L << (SERVER - 193)) | (1L << (SET - 193)) | (1L << (SIMILAR - 193)) | (1L << (SIMPLE - 193)) | (1L << (STABLE - 193)) | (1L << (START - 193)) | (1L << (STORAGE - 193)) | (1L << (STDDEV_POP - 193)) | (1L << (STDDEV_SAMP - 193)) | (1L << (SUBPARTITION - 193)) | (1L << (SUM - 193)) | (1L << (TABLESPACE - 193)) | (1L << (TEMPLATE - 193)) | (1L << (THAN - 193)) | (1L << (TIMEZONE - 193)) | (1L << (TIMEZONE_HOUR - 193)) | (1L << (TIMEZONE_MINUTE - 193)) | (1L << (TRIM - 193)) | (1L << (TO - 193)) | (1L << (UNKNOWN - 193)) | (1L << (UNLOGGED - 193)) | (1L << (VALUES - 193)) | (1L << (VAR_SAMP - 193)) | (1L << (VAR_POP - 193)) | (1L << (VARYING - 193)) | (1L << (VOLATILE - 193)) | (1L << (WEEK - 193)) | (1L << (WINDOW - 193)) | (1L << (WRAPPER - 193)) | (1L << (YEAR - 193)) | (1L << (ZONE - 193)) | (1L << (BOOLEAN - 193)) | (1L << (BOOL - 193)))) != 0) || ((((_la - 257)) & ~0x3f) == 0 && ((1L << (_la - 257)) & ((1L << (BIT - 257)) | (1L << (VARBIT - 257)) | (1L << (INT1 - 257)) | (1L << (INT2 - 257)) | (1L << (INT4 - 257)) | (1L << (INT8 - 257)) | (1L << (TINYINT - 257)) | (1L << (SMALLINT - 257)) | (1L << (INT - 257)) | (1L << (INTEGER - 257)) | (1L << (BIGINT - 257)) | (1L << (FLOAT4 - 257)) | (1L << (FLOAT8 - 257)) | (1L << (REAL - 257)) | (1L << (FLOAT - 257)) | (1L << (DOUBLE - 257)) | (1L << (NUMERIC - 257)) | (1L << (DECIMAL - 257)) | (1L << (CHAR - 257)) | (1L << (VARCHAR - 257)) | (1L << (NCHAR - 257)) | (1L << (NVARCHAR - 257)) | (1L << (DATE - 257)) | (1L << (TIME - 257)) | (1L << (TIMETZ - 257)) | (1L << (TIMESTAMP - 257)) | (1L << (TIMESTAMPTZ - 257)) | (1L << (TEXT - 257)) | (1L << (VARBINARY - 257)) | (1L << (BLOB - 257)) | (1L << (BYTEA - 257)) | (1L << (INET4 - 257)) | (1L << (QUOTE - 257)))) != 0) || _la==Identifier );
				setState(992); revoke_from_cascade_restrict();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(994); match(REVOKE);
				setState(998);
				switch ( getInterpreter().adaptivePredict(_input,108,_ctx) ) {
				case 1:
					{
					setState(995); match(ADMIN);
					setState(996); match(OPTION);
					setState(997); match(FOR);
					}
					break;
				}
				setState(1004); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1000); ((Revoke_statementContext)_localctx).role_name = identifier();
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
				} while ( ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (ADMIN - 129)) | (1L << (AVG - 129)) | (1L << (BETWEEN - 129)) | (1L << (BY - 129)) | (1L << (CACHE - 129)) | (1L << (CALLED - 129)) | (1L << (CLASS - 129)) | (1L << (CENTURY - 129)) | (1L << (CHARACTER - 129)) | (1L << (CHECK - 129)) | (1L << (COLLECT - 129)) | (1L << (COALESCE - 129)) | (1L << (COLUMN - 129)) | (1L << (COMMENT - 129)) | (1L << (COMMENTS - 129)) | (1L << (COMMIT - 129)) | (1L << (CONFIGURATION - 129)) | (1L << (COST - 129)) | (1L << (COUNT - 129)) | (1L << (CUBE - 129)) | (1L << (CURRENT - 129)) | (1L << (CYCLE - 129)) | (1L << (DATA - 129)) | (1L << (DAY - 129)) | (1L << (DEC - 129)) | (1L << (DECADE - 129)) | (1L << (DEFINER - 129)) | (1L << (DICTIONARY - 129)) | (1L << (DOW - 129)) | (1L << (DOY - 129)) | (1L << (DROP - 129)) | (1L << (EPOCH - 129)) | (1L << (EVERY - 129)) | (1L << (EXISTS - 129)) | (1L << (EXTERNAL - 129)) | (1L << (EXTRACT - 129)) | (1L << (FAMILY - 129)) | (1L << (FILTER - 129)) | (1L << (FIRST - 129)) | (1L << (FORMAT - 129)) | (1L << (FUSION - 129)) | (1L << (GROUPING - 129)) | (1L << (HASH - 129)) | (1L << (INDEX - 129)) | (1L << (INCREMENT - 129)) | (1L << (INPUT - 129)) | (1L << (INSERT - 129)) | (1L << (INTERSECTION - 129)) | (1L << (ISCACHABLE - 129)) | (1L << (ISODOW - 129)) | (1L << (ISOYEAR - 129)) | (1L << (ISSTRICT - 129)) | (1L << (LANGUAGE - 129)) | (1L << (LARGE - 129)) | (1L << (LAST - 129)) | (1L << (LESS - 129)) | (1L << (LIST - 129)) | (1L << (LOCATION - 129)) | (1L << (MATCH - 129)) | (1L << (MAX - 129)) | (1L << (MAXVALUE - 129)) | (1L << (MICROSECONDS - 129)))) != 0) || ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & ((1L << (MILLENNIUM - 193)) | (1L << (MILLISECONDS - 193)) | (1L << (MIN - 193)) | (1L << (MINVALUE - 193)) | (1L << (MINUTE - 193)) | (1L << (MONTH - 193)) | (1L << (NATIONAL - 193)) | (1L << (NO - 193)) | (1L << (NONE - 193)) | (1L << (NULLIF - 193)) | (1L << (OBJECT - 193)) | (1L << (OPTION - 193)) | (1L << (OPTIONS - 193)) | (1L << (OVERWRITE - 193)) | (1L << (PARSER - 193)) | (1L << (PARTIAL - 193)) | (1L << (PARTITION - 193)) | (1L << (PARTITIONS - 193)) | (1L << (PRECISION - 193)) | (1L << (PUBLIC - 193)) | (1L << (PURGE - 193)) | (1L << (QUARTER - 193)) | (1L << (RANGE - 193)) | (1L << (REGEXP - 193)) | (1L << (RLIKE - 193)) | (1L << (ROLLUP - 193)) | (1L << (SEARCH - 193)) | (1L << (SECOND - 193)) | (1L << (SECURITY - 193)) | (1L << (SERVER - 193)) | (1L << (SET - 193)) | (1L << (SIMILAR - 193)) | (1L << (SIMPLE - 193)) | (1L << (STABLE - 193)) | (1L << (START - 193)) | (1L << (STORAGE - 193)) | (1L << (STDDEV_POP - 193)) | (1L << (STDDEV_SAMP - 193)) | (1L << (SUBPARTITION - 193)) | (1L << (SUM - 193)) | (1L << (TABLESPACE - 193)) | (1L << (TEMPLATE - 193)) | (1L << (THAN - 193)) | (1L << (TIMEZONE - 193)) | (1L << (TIMEZONE_HOUR - 193)) | (1L << (TIMEZONE_MINUTE - 193)) | (1L << (TRIM - 193)) | (1L << (TO - 193)) | (1L << (UNKNOWN - 193)) | (1L << (UNLOGGED - 193)) | (1L << (VALUES - 193)) | (1L << (VAR_SAMP - 193)) | (1L << (VAR_POP - 193)) | (1L << (VARYING - 193)) | (1L << (VOLATILE - 193)) | (1L << (WEEK - 193)) | (1L << (WINDOW - 193)) | (1L << (WRAPPER - 193)) | (1L << (YEAR - 193)) | (1L << (ZONE - 193)) | (1L << (BOOLEAN - 193)) | (1L << (BOOL - 193)))) != 0) || ((((_la - 257)) & ~0x3f) == 0 && ((1L << (_la - 257)) & ((1L << (BIT - 257)) | (1L << (VARBIT - 257)) | (1L << (INT1 - 257)) | (1L << (INT2 - 257)) | (1L << (INT4 - 257)) | (1L << (INT8 - 257)) | (1L << (TINYINT - 257)) | (1L << (SMALLINT - 257)) | (1L << (INT - 257)) | (1L << (INTEGER - 257)) | (1L << (BIGINT - 257)) | (1L << (FLOAT4 - 257)) | (1L << (FLOAT8 - 257)) | (1L << (REAL - 257)) | (1L << (FLOAT - 257)) | (1L << (DOUBLE - 257)) | (1L << (NUMERIC - 257)) | (1L << (DECIMAL - 257)) | (1L << (CHAR - 257)) | (1L << (VARCHAR - 257)) | (1L << (NCHAR - 257)) | (1L << (NVARCHAR - 257)) | (1L << (DATE - 257)) | (1L << (TIME - 257)) | (1L << (TIMETZ - 257)) | (1L << (TIMESTAMP - 257)) | (1L << (TIMESTAMPTZ - 257)) | (1L << (TEXT - 257)) | (1L << (VARBINARY - 257)) | (1L << (BLOB - 257)) | (1L << (BYTEA - 257)) | (1L << (INET4 - 257)) | (1L << (QUOTE - 257)))) != 0) || _la==Identifier );
				setState(1008); match(FROM);
				setState(1013); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1009); ((Revoke_statementContext)_localctx).role_name = identifier();
						setState(1011);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1010); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1015); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,112,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1018);
				_la = _input.LA(1);
				if (_la==CASCADE || _la==RESTRICT) {
					{
					setState(1017);
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
			setState(1022); match(FROM);
			setState(1031); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(1031);
					switch ( getInterpreter().adaptivePredict(_input,117,_ctx) ) {
					case 1:
						{
						setState(1024);
						_la = _input.LA(1);
						if (_la==GROUP) {
							{
							setState(1023); match(GROUP);
							}
						}

						setState(1026); ((Revoke_from_cascade_restrictContext)_localctx).role_name = identifier();
						}
						break;
					case 2:
						{
						setState(1027); match(PUBLIC);
						setState(1029);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1028); match(COMMA);
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
				setState(1033); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,118,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(1036);
			_la = _input.LA(1);
			if (_la==CASCADE || _la==RESTRICT) {
				{
				setState(1035);
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
			setState(1363);
			switch ( getInterpreter().adaptivePredict(_input,190,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1038); match(GRANT);
				setState(1048);
				switch (_input.LA(1)) {
				case DELETE:
				case REFERENCES:
				case SELECT:
				case TRIGGER:
				case TRUNCATE:
				case UPDATE:
				case INSERT:
					{
					setState(1040); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1039);
						_la = _input.LA(1);
						if ( !(_la==DELETE || ((((_la - 93)) & ~0x3f) == 0 && ((1L << (_la - 93)) & ((1L << (REFERENCES - 93)) | (1L << (SELECT - 93)) | (1L << (TRIGGER - 93)) | (1L << (TRUNCATE - 93)) | (1L << (UPDATE - 93)))) != 0) || _la==INSERT) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
						}
						setState(1042); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==DELETE || ((((_la - 93)) & ~0x3f) == 0 && ((1L << (_la - 93)) & ((1L << (REFERENCES - 93)) | (1L << (SELECT - 93)) | (1L << (TRIGGER - 93)) | (1L << (TRUNCATE - 93)) | (1L << (UPDATE - 93)))) != 0) || _la==INSERT );
					}
					break;
				case ALL:
					{
					setState(1044); match(ALL);
					setState(1046);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1045); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1050); match(ON);
				setState(1074);
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
				case VARBINARY:
				case BLOB:
				case BYTEA:
				case INET4:
				case QUOTE:
				case Identifier:
					{
					{
					setState(1052);
					_la = _input.LA(1);
					if (_la==TABLE) {
						{
						setState(1051); match(TABLE);
						}
					}

					setState(1058); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(1054); ((Grant_statementContext)_localctx).tabl_name = schema_qualified_name();
							setState(1056);
							_la = _input.LA(1);
							if (_la==COMMA) {
								{
								setState(1055); match(COMMA);
								}
							}

							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(1060); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,125,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					}
					}
					break;
				case ALL:
					{
					{
					setState(1062); match(ALL);
					setState(1063); match(TABLES);
					setState(1064); match(IN);
					setState(1065); match(SCHEMA);
					setState(1070); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(1066); ((Grant_statementContext)_localctx).schem_name = identifier();
							setState(1068);
							_la = _input.LA(1);
							if (_la==COMMA) {
								{
								setState(1067); match(COMMA);
								}
							}

							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(1072); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,127,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1076); grant_to_rule();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1078); match(GRANT);
				setState(1104);
				switch (_input.LA(1)) {
				case REFERENCES:
				case SELECT:
				case UPDATE:
				case INSERT:
					{
					setState(1088); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1079);
						_la = _input.LA(1);
						if ( !(((((_la - 93)) & ~0x3f) == 0 && ((1L << (_la - 93)) & ((1L << (REFERENCES - 93)) | (1L << (SELECT - 93)) | (1L << (UPDATE - 93)))) != 0) || _la==INSERT) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(1084); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(1080); ((Grant_statementContext)_localctx).column = identifier();
								setState(1082);
								_la = _input.LA(1);
								if (_la==COMMA) {
									{
									setState(1081); match(COMMA);
									}
								}

								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(1086); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,130,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						}
						}
						setState(1090); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 93)) & ~0x3f) == 0 && ((1L << (_la - 93)) & ((1L << (REFERENCES - 93)) | (1L << (SELECT - 93)) | (1L << (UPDATE - 93)))) != 0) || _la==INSERT );
					}
					break;
				case ALL:
					{
					setState(1092); match(ALL);
					setState(1094);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1093); match(PRIVILEGES);
						}
					}

					setState(1100); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1096); ((Grant_statementContext)_localctx).column = identifier();
						setState(1098);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1097); match(COMMA);
							}
						}

						}
						}
						setState(1102); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (ADMIN - 129)) | (1L << (AVG - 129)) | (1L << (BETWEEN - 129)) | (1L << (BY - 129)) | (1L << (CACHE - 129)) | (1L << (CALLED - 129)) | (1L << (CLASS - 129)) | (1L << (CENTURY - 129)) | (1L << (CHARACTER - 129)) | (1L << (CHECK - 129)) | (1L << (COLLECT - 129)) | (1L << (COALESCE - 129)) | (1L << (COLUMN - 129)) | (1L << (COMMENT - 129)) | (1L << (COMMENTS - 129)) | (1L << (COMMIT - 129)) | (1L << (CONFIGURATION - 129)) | (1L << (COST - 129)) | (1L << (COUNT - 129)) | (1L << (CUBE - 129)) | (1L << (CURRENT - 129)) | (1L << (CYCLE - 129)) | (1L << (DATA - 129)) | (1L << (DAY - 129)) | (1L << (DEC - 129)) | (1L << (DECADE - 129)) | (1L << (DEFINER - 129)) | (1L << (DICTIONARY - 129)) | (1L << (DOW - 129)) | (1L << (DOY - 129)) | (1L << (DROP - 129)) | (1L << (EPOCH - 129)) | (1L << (EVERY - 129)) | (1L << (EXISTS - 129)) | (1L << (EXTERNAL - 129)) | (1L << (EXTRACT - 129)) | (1L << (FAMILY - 129)) | (1L << (FILTER - 129)) | (1L << (FIRST - 129)) | (1L << (FORMAT - 129)) | (1L << (FUSION - 129)) | (1L << (GROUPING - 129)) | (1L << (HASH - 129)) | (1L << (INDEX - 129)) | (1L << (INCREMENT - 129)) | (1L << (INPUT - 129)) | (1L << (INSERT - 129)) | (1L << (INTERSECTION - 129)) | (1L << (ISCACHABLE - 129)) | (1L << (ISODOW - 129)) | (1L << (ISOYEAR - 129)) | (1L << (ISSTRICT - 129)) | (1L << (LANGUAGE - 129)) | (1L << (LARGE - 129)) | (1L << (LAST - 129)) | (1L << (LESS - 129)) | (1L << (LIST - 129)) | (1L << (LOCATION - 129)) | (1L << (MATCH - 129)) | (1L << (MAX - 129)) | (1L << (MAXVALUE - 129)) | (1L << (MICROSECONDS - 129)))) != 0) || ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & ((1L << (MILLENNIUM - 193)) | (1L << (MILLISECONDS - 193)) | (1L << (MIN - 193)) | (1L << (MINVALUE - 193)) | (1L << (MINUTE - 193)) | (1L << (MONTH - 193)) | (1L << (NATIONAL - 193)) | (1L << (NO - 193)) | (1L << (NONE - 193)) | (1L << (NULLIF - 193)) | (1L << (OBJECT - 193)) | (1L << (OPTION - 193)) | (1L << (OPTIONS - 193)) | (1L << (OVERWRITE - 193)) | (1L << (PARSER - 193)) | (1L << (PARTIAL - 193)) | (1L << (PARTITION - 193)) | (1L << (PARTITIONS - 193)) | (1L << (PRECISION - 193)) | (1L << (PUBLIC - 193)) | (1L << (PURGE - 193)) | (1L << (QUARTER - 193)) | (1L << (RANGE - 193)) | (1L << (REGEXP - 193)) | (1L << (RLIKE - 193)) | (1L << (ROLLUP - 193)) | (1L << (SEARCH - 193)) | (1L << (SECOND - 193)) | (1L << (SECURITY - 193)) | (1L << (SERVER - 193)) | (1L << (SET - 193)) | (1L << (SIMILAR - 193)) | (1L << (SIMPLE - 193)) | (1L << (STABLE - 193)) | (1L << (START - 193)) | (1L << (STORAGE - 193)) | (1L << (STDDEV_POP - 193)) | (1L << (STDDEV_SAMP - 193)) | (1L << (SUBPARTITION - 193)) | (1L << (SUM - 193)) | (1L << (TABLESPACE - 193)) | (1L << (TEMPLATE - 193)) | (1L << (THAN - 193)) | (1L << (TIMEZONE - 193)) | (1L << (TIMEZONE_HOUR - 193)) | (1L << (TIMEZONE_MINUTE - 193)) | (1L << (TRIM - 193)) | (1L << (TO - 193)) | (1L << (UNKNOWN - 193)) | (1L << (UNLOGGED - 193)) | (1L << (VALUES - 193)) | (1L << (VAR_SAMP - 193)) | (1L << (VAR_POP - 193)) | (1L << (VARYING - 193)) | (1L << (VOLATILE - 193)) | (1L << (WEEK - 193)) | (1L << (WINDOW - 193)) | (1L << (WRAPPER - 193)) | (1L << (YEAR - 193)) | (1L << (ZONE - 193)) | (1L << (BOOLEAN - 193)) | (1L << (BOOL - 193)))) != 0) || ((((_la - 257)) & ~0x3f) == 0 && ((1L << (_la - 257)) & ((1L << (BIT - 257)) | (1L << (VARBIT - 257)) | (1L << (INT1 - 257)) | (1L << (INT2 - 257)) | (1L << (INT4 - 257)) | (1L << (INT8 - 257)) | (1L << (TINYINT - 257)) | (1L << (SMALLINT - 257)) | (1L << (INT - 257)) | (1L << (INTEGER - 257)) | (1L << (BIGINT - 257)) | (1L << (FLOAT4 - 257)) | (1L << (FLOAT8 - 257)) | (1L << (REAL - 257)) | (1L << (FLOAT - 257)) | (1L << (DOUBLE - 257)) | (1L << (NUMERIC - 257)) | (1L << (DECIMAL - 257)) | (1L << (CHAR - 257)) | (1L << (VARCHAR - 257)) | (1L << (NCHAR - 257)) | (1L << (NVARCHAR - 257)) | (1L << (DATE - 257)) | (1L << (TIME - 257)) | (1L << (TIMETZ - 257)) | (1L << (TIMESTAMP - 257)) | (1L << (TIMESTAMPTZ - 257)) | (1L << (TEXT - 257)) | (1L << (VARBINARY - 257)) | (1L << (BLOB - 257)) | (1L << (BYTEA - 257)) | (1L << (INET4 - 257)) | (1L << (QUOTE - 257)))) != 0) || _la==Identifier );
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1106); match(ON);
				setState(1114); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1108);
						_la = _input.LA(1);
						if (_la==TABLE) {
							{
							setState(1107); match(TABLE);
							}
						}

						setState(1110); ((Grant_statementContext)_localctx).tabl_name = schema_qualified_name();
						setState(1112);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1111); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1116); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,138,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1118); grant_to_rule();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1120); match(GRANT);
				setState(1133);
				switch (_input.LA(1)) {
				case SELECT:
				case UPDATE:
				case USAGE:
					{
					setState(1125); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1121);
						_la = _input.LA(1);
						if ( !(((((_la - 103)) & ~0x3f) == 0 && ((1L << (_la - 103)) & ((1L << (SELECT - 103)) | (1L << (UPDATE - 103)) | (1L << (USAGE - 103)))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(1123);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1122); match(COMMA);
							}
						}

						}
						}
						setState(1127); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 103)) & ~0x3f) == 0 && ((1L << (_la - 103)) & ((1L << (SELECT - 103)) | (1L << (UPDATE - 103)) | (1L << (USAGE - 103)))) != 0) );
					}
					break;
				case ALL:
					{
					setState(1129); match(ALL);
					setState(1131);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1130); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1135); match(ON);
				setState(1157);
				switch (_input.LA(1)) {
				case SEQUENCE:
					{
					setState(1141); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1136); match(SEQUENCE);
						setState(1137); ((Grant_statementContext)_localctx).sequence_name = identifier();
						setState(1139);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1138); match(COMMA);
							}
						}

						}
						}
						setState(1143); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==SEQUENCE );
					}
					break;
				case ALL:
					{
					setState(1145); match(ALL);
					setState(1146); match(SEQUENCES);
					setState(1147); match(IN);
					setState(1148); match(SCHEMA);
					setState(1153); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(1149); ((Grant_statementContext)_localctx).schema_name = identifier();
							setState(1151);
							_la = _input.LA(1);
							if (_la==COMMA) {
								{
								setState(1150); match(COMMA);
								}
							}

							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(1155); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,146,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1159); grant_to_rule();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1161); match(GRANT);
				setState(1174);
				switch (_input.LA(1)) {
				case CONNECT:
				case CREATE:
				case TEMP:
				case TEMPORARY:
					{
					setState(1166); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1162);
						_la = _input.LA(1);
						if ( !(_la==CONNECT || _la==CREATE || _la==TEMP || _la==TEMPORARY) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(1164);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1163); match(COMMA);
							}
						}

						}
						}
						setState(1168); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==CONNECT || _la==CREATE || _la==TEMP || _la==TEMPORARY );
					}
					break;
				case ALL:
					{
					setState(1170); match(ALL);
					setState(1172);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1171); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1176); match(ON);
				setState(1177); match(DATABASE);
				setState(1182); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1178); ((Grant_statementContext)_localctx).database_name = identifier();
						setState(1180);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1179); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1184); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,153,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1186); grant_to_rule();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1188); match(GRANT);
				setState(1194);
				switch (_input.LA(1)) {
				case USAGE:
					{
					setState(1189); match(USAGE);
					}
					break;
				case ALL:
					{
					setState(1190); match(ALL);
					setState(1192);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1191); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1196); match(ON);
				setState(1197); match(FOREIGN);
				setState(1198); match(DATA);
				setState(1199); match(WRAPPER);
				setState(1204); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1200); ((Grant_statementContext)_localctx).fdw_name = identifier();
						setState(1202);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1201); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1206); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,157,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1208); grant_to_rule();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1210); match(GRANT);
				setState(1216);
				switch (_input.LA(1)) {
				case USAGE:
					{
					setState(1211); match(USAGE);
					}
					break;
				case ALL:
					{
					setState(1212); match(ALL);
					setState(1214);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1213); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1218); match(ON);
				setState(1219); match(FOREIGN);
				setState(1220); match(SERVER);
				setState(1225); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1221); ((Grant_statementContext)_localctx).server_name = identifier();
						setState(1223);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1222); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1227); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,161,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1229); grant_to_rule();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1231); match(GRANT);
				setState(1237);
				switch (_input.LA(1)) {
				case EXECUTE:
					{
					setState(1232); match(EXECUTE);
					}
					break;
				case ALL:
					{
					setState(1233); match(ALL);
					setState(1235);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1234); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1239); match(ON);
				setState(1242);
				switch (_input.LA(1)) {
				case FUNCTION:
					{
					setState(1240); function_definition();
					}
					break;
				case ALL:
					{
					setState(1241); functions_definition_schema();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1244); grant_to_rule();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(1246); match(GRANT);
				setState(1252);
				switch (_input.LA(1)) {
				case USAGE:
					{
					setState(1247); match(USAGE);
					}
					break;
				case ALL:
					{
					setState(1248); match(ALL);
					setState(1250);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1249); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1254); match(ON);
				setState(1255); match(LANGUAGE);
				setState(1260); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1256); ((Grant_statementContext)_localctx).lang_name = identifier();
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
					_alt = getInterpreter().adaptivePredict(_input,168,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1264); grant_to_rule();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(1266); match(GRANT);
				setState(1279);
				switch (_input.LA(1)) {
				case SELECT:
				case UPDATE:
					{
					setState(1271); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1267);
						_la = _input.LA(1);
						if ( !(_la==SELECT || _la==UPDATE) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(1269);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1268); match(COMMA);
							}
						}

						}
						}
						setState(1273); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==SELECT || _la==UPDATE );
					}
					break;
				case ALL:
					{
					setState(1275); match(ALL);
					setState(1277);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1276); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1281); match(ON);
				setState(1282); match(LARGE);
				setState(1283); match(OBJECT);
				setState(1288); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1284); ((Grant_statementContext)_localctx).loid = identifier();
						setState(1286);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1285); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1290); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,174,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1292); grant_to_rule();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(1294); match(GRANT);
				setState(1307);
				switch (_input.LA(1)) {
				case CREATE:
				case USAGE:
					{
					setState(1299); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1295);
						_la = _input.LA(1);
						if ( !(_la==CREATE || _la==USAGE) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(1297);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1296); match(COMMA);
							}
						}

						}
						}
						setState(1301); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==CREATE || _la==USAGE );
					}
					break;
				case ALL:
					{
					setState(1303); match(ALL);
					setState(1305);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1304); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1309); match(ON);
				setState(1310); match(SCHEMA);
				setState(1315); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1311); ((Grant_statementContext)_localctx).schema_name = identifier();
						setState(1313);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1312); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1317); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,180,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1319); grant_to_rule();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(1321); match(GRANT);
				setState(1327);
				switch (_input.LA(1)) {
				case CREATE:
					{
					setState(1322); match(CREATE);
					}
					break;
				case ALL:
					{
					setState(1323); match(ALL);
					setState(1325);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1324); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1329); match(ON);
				setState(1330); match(TABLESPACE);
				setState(1335); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1331); ((Grant_statementContext)_localctx).tablespace_name = identifier();
						setState(1333);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1332); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1337); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,184,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1339); grant_to_rule();
				setState(1340); match(GRANT);
				setState(1345); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1341); ((Grant_statementContext)_localctx).role_name = identifier();
						setState(1343);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1342); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1347); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,186,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1349); match(TO);
				setState(1354); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1350); ((Grant_statementContext)_localctx).role_name = identifier();
						setState(1352);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1351); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1356); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,188,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1361);
				_la = _input.LA(1);
				if (_la==WITH) {
					{
					setState(1358); match(WITH);
					setState(1359); match(ADMIN);
					setState(1360); match(OPTION);
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
			setState(1365); match(TO);
			setState(1376); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(1367);
					_la = _input.LA(1);
					if (_la==GROUP) {
						{
						setState(1366); match(GROUP);
						}
					}

					setState(1371);
					switch ( getInterpreter().adaptivePredict(_input,192,_ctx) ) {
					case 1:
						{
						{
						setState(1369); ((Grant_to_ruleContext)_localctx).role_name = identifier();
						}
						}
						break;
					case 2:
						{
						setState(1370); match(PUBLIC);
						}
						break;
					}
					setState(1374);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1373); match(COMMA);
						}
					}

					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1378); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,194,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(1383);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(1380); match(WITH);
				setState(1381); match(GRANT);
				setState(1382); match(OPTION);
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
		public TerminalNode FUNCTION() { return getToken(SQLParser.FUNCTION, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public Schema_qualified_nameContext schema_qualified_name(int i) {
			return getRuleContext(Schema_qualified_nameContext.class,i);
		}
		public TerminalNode FAMILY() { return getToken(SQLParser.FAMILY, 0); }
		public List<Schema_qualified_nameContext> schema_qualified_name() {
			return getRuleContexts(Schema_qualified_nameContext.class);
		}
		public TerminalNode INDEX() { return getToken(SQLParser.INDEX, 0); }
		public Routine_invocationContext routine_invocation() {
			return getRuleContext(Routine_invocationContext.class,0);
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
			setState(1385); match(COMMENT);
			setState(1386); match(ON);
			setState(1506);
			switch ( getInterpreter().adaptivePredict(_input,199,_ctx) ) {
			case 1:
				{
				setState(1387); match(AGGREGATE);
				setState(1388); ((Comment_on_statementContext)_localctx).agg_name = schema_qualified_name();
				setState(1389); match(LEFT_PAREN);
				setState(1396);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 114)) & ~0x3f) == 0 && ((1L << (_la - 114)) & ((1L << (TRIGGER - 114)) | (1L << (CHARACTER - 114)) | (1L << (DEC - 114)))) != 0) || ((((_la - 199)) & ~0x3f) == 0 && ((1L << (_la - 199)) & ((1L << (NATIONAL - 199)) | (1L << (BOOLEAN - 199)) | (1L << (BOOL - 199)) | (1L << (BIT - 199)) | (1L << (VARBIT - 199)) | (1L << (INT1 - 199)) | (1L << (INT2 - 199)) | (1L << (INT4 - 199)) | (1L << (INT8 - 199)))) != 0) || ((((_la - 263)) & ~0x3f) == 0 && ((1L << (_la - 263)) & ((1L << (TINYINT - 263)) | (1L << (SMALLINT - 263)) | (1L << (INT - 263)) | (1L << (INTEGER - 263)) | (1L << (BIGINT - 263)) | (1L << (FLOAT4 - 263)) | (1L << (FLOAT8 - 263)) | (1L << (REAL - 263)) | (1L << (REGCLASS - 263)) | (1L << (FLOAT - 263)) | (1L << (DOUBLE - 263)) | (1L << (NUMERIC - 263)) | (1L << (DECIMAL - 263)) | (1L << (CHAR - 263)) | (1L << (VARCHAR - 263)) | (1L << (NCHAR - 263)) | (1L << (NVARCHAR - 263)) | (1L << (DATE - 263)) | (1L << (TIME - 263)) | (1L << (TIMETZ - 263)) | (1L << (TIMESTAMP - 263)) | (1L << (TIMESTAMPTZ - 263)) | (1L << (TEXT - 263)) | (1L << (BINARY - 263)) | (1L << (VARBINARY - 263)) | (1L << (BLOB - 263)) | (1L << (BYTEA - 263)) | (1L << (INET4 - 263)))) != 0)) {
					{
					{
					setState(1390); ((Comment_on_statementContext)_localctx).agg_type = data_type();
					setState(1392);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1391); match(COMMA);
						}
					}

					}
					}
					setState(1398);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1399); match(RIGHT_PAREN);
				}
				break;
			case 2:
				{
				setState(1401); match(CAST);
				setState(1402); match(LEFT_PAREN);
				setState(1403); ((Comment_on_statementContext)_localctx).source_type = data_type();
				setState(1404); match(AS);
				setState(1405); ((Comment_on_statementContext)_localctx).target_type = data_type();
				setState(1406); match(RIGHT_PAREN);
				}
				break;
			case 3:
				{
				setState(1408); match(COLLATION);
				setState(1409); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 4:
				{
				setState(1410); match(COLUMN);
				setState(1411); ((Comment_on_statementContext)_localctx).column_name = schema_qualified_name();
				}
				break;
			case 5:
				{
				setState(1412); match(CONSTRAINT);
				setState(1413); ((Comment_on_statementContext)_localctx).constraint_name = schema_qualified_name();
				setState(1414); match(ON);
				setState(1415); ((Comment_on_statementContext)_localctx).table_name = schema_qualified_name();
				}
				break;
			case 6:
				{
				setState(1417); match(CONVERSION);
				setState(1418); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 7:
				{
				setState(1419); match(DATABASE);
				setState(1420); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 8:
				{
				setState(1421); match(DOMAIN);
				setState(1422); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 9:
				{
				setState(1423); match(EXTENSION);
				setState(1424); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 10:
				{
				setState(1425); match(FOREIGN);
				setState(1426); match(DATA);
				setState(1427); match(WRAPPER);
				setState(1428); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 11:
				{
				setState(1429); match(FOREIGN);
				setState(1430); match(TABLE);
				setState(1431); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 12:
				{
				setState(1432); match(FUNCTION);
				setState(1433); routine_invocation();
				}
				break;
			case 13:
				{
				setState(1434); match(INDEX);
				setState(1435); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 14:
				{
				setState(1436); match(LARGE);
				setState(1437); match(OBJECT);
				setState(1438); ((Comment_on_statementContext)_localctx).large_object_oid = identifier();
				}
				break;
			case 15:
				{
				setState(1439); match(OPERATOR);
				setState(1440); ((Comment_on_statementContext)_localctx).operator_name = schema_qualified_name();
				setState(1441); match(LEFT_PAREN);
				setState(1442); ((Comment_on_statementContext)_localctx).left_type = data_type();
				setState(1443); match(COMMA);
				setState(1444); ((Comment_on_statementContext)_localctx).right_type = data_type();
				setState(1445); match(RIGHT_PAREN);
				}
				break;
			case 16:
				{
				setState(1447); match(OPERATOR);
				setState(1448); match(CLASS);
				setState(1449); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				setState(1450); match(USING);
				setState(1451); ((Comment_on_statementContext)_localctx).index_method = identifier();
				}
				break;
			case 17:
				{
				setState(1453); match(OPERATOR);
				setState(1454); match(FAMILY);
				setState(1455); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				setState(1456); match(USING);
				setState(1457); ((Comment_on_statementContext)_localctx).index_method = identifier();
				}
				break;
			case 18:
				{
				setState(1460);
				_la = _input.LA(1);
				if (_la==PROCEDURAL) {
					{
					setState(1459); match(PROCEDURAL);
					}
				}

				setState(1462); match(LANGUAGE);
				setState(1463); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 19:
				{
				setState(1464); match(ROLE);
				setState(1465); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 20:
				{
				setState(1466); match(RULE);
				setState(1467); ((Comment_on_statementContext)_localctx).rule_name = schema_qualified_name();
				setState(1468); match(ON);
				setState(1469); ((Comment_on_statementContext)_localctx).table_name = schema_qualified_name();
				}
				break;
			case 21:
				{
				setState(1471); match(SCHEMA);
				setState(1472); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 22:
				{
				setState(1473); match(SEQUENCE);
				setState(1474); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 23:
				{
				setState(1475); match(SERVER);
				setState(1476); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 24:
				{
				setState(1477); match(TABLE);
				setState(1478); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 25:
				{
				setState(1479); match(TABLESPACE);
				setState(1480); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 26:
				{
				setState(1481); match(TEXT);
				setState(1482); match(SEARCH);
				setState(1483); match(CONFIGURATION);
				setState(1484); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 27:
				{
				setState(1485); match(TEXT);
				setState(1486); match(SEARCH);
				setState(1487); match(DICTIONARY);
				setState(1488); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 28:
				{
				setState(1489); match(TEXT);
				setState(1490); match(SEARCH);
				setState(1491); match(PARSER);
				setState(1492); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 29:
				{
				setState(1493); match(TEXT);
				setState(1494); match(SEARCH);
				setState(1495); match(TEMPLATE);
				setState(1496); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 30:
				{
				setState(1497); match(TRIGGER);
				setState(1498); ((Comment_on_statementContext)_localctx).trigger_name = schema_qualified_name();
				setState(1499); match(ON);
				setState(1500); ((Comment_on_statementContext)_localctx).table_name = schema_qualified_name();
				}
				break;
			case 31:
				{
				setState(1502); match(TYPE);
				setState(1503); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 32:
				{
				setState(1504); match(VIEW);
				setState(1505); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			}
			setState(1508); match(IS);
			setState(1509); match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
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
		public Token value;
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
		public ArgmodeContext argmode() {
			return getRuleContext(ArgmodeContext.class,0);
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
			setState(1511); match(CREATE);
			setState(1514);
			_la = _input.LA(1);
			if (_la==OR) {
				{
				setState(1512); match(OR);
				setState(1513); match(REPLACE);
				}
			}

			setState(1516); match(FUNCTION);
			setState(1517); ((Create_function_statementContext)_localctx).name = identifier();
			setState(1518); match(LEFT_PAREN);
			setState(1538);
			_la = _input.LA(1);
			if (_la==IN || _la==INOUT || ((((_la - 80)) & ~0x3f) == 0 && ((1L << (_la - 80)) & ((1L << (OUT - 80)) | (1L << (TRIGGER - 80)) | (1L << (VARIADIC - 80)) | (1L << (ADMIN - 80)) | (1L << (AVG - 80)) | (1L << (BETWEEN - 80)) | (1L << (BY - 80)) | (1L << (CACHE - 80)) | (1L << (CALLED - 80)) | (1L << (CLASS - 80)) | (1L << (CENTURY - 80)) | (1L << (CHARACTER - 80)) | (1L << (CHECK - 80)) | (1L << (COLLECT - 80)) | (1L << (COALESCE - 80)) | (1L << (COLUMN - 80)) | (1L << (COMMENT - 80)) | (1L << (COMMENTS - 80)))) != 0) || ((((_la - 144)) & ~0x3f) == 0 && ((1L << (_la - 144)) & ((1L << (COMMIT - 144)) | (1L << (CONFIGURATION - 144)) | (1L << (COST - 144)) | (1L << (COUNT - 144)) | (1L << (CUBE - 144)) | (1L << (CURRENT - 144)) | (1L << (CYCLE - 144)) | (1L << (DATA - 144)) | (1L << (DAY - 144)) | (1L << (DEC - 144)) | (1L << (DECADE - 144)) | (1L << (DEFINER - 144)) | (1L << (DICTIONARY - 144)) | (1L << (DOW - 144)) | (1L << (DOY - 144)) | (1L << (DROP - 144)) | (1L << (EPOCH - 144)) | (1L << (EVERY - 144)) | (1L << (EXISTS - 144)) | (1L << (EXTERNAL - 144)) | (1L << (EXTRACT - 144)) | (1L << (FAMILY - 144)) | (1L << (FILTER - 144)) | (1L << (FIRST - 144)) | (1L << (FORMAT - 144)) | (1L << (FUSION - 144)) | (1L << (GROUPING - 144)) | (1L << (HASH - 144)) | (1L << (INDEX - 144)) | (1L << (INCREMENT - 144)) | (1L << (INPUT - 144)) | (1L << (INSERT - 144)) | (1L << (INTERSECTION - 144)) | (1L << (ISCACHABLE - 144)) | (1L << (ISODOW - 144)) | (1L << (ISOYEAR - 144)) | (1L << (ISSTRICT - 144)) | (1L << (LANGUAGE - 144)) | (1L << (LARGE - 144)) | (1L << (LAST - 144)) | (1L << (LESS - 144)) | (1L << (LIST - 144)) | (1L << (LOCATION - 144)) | (1L << (MATCH - 144)) | (1L << (MAX - 144)) | (1L << (MAXVALUE - 144)) | (1L << (MICROSECONDS - 144)) | (1L << (MILLENNIUM - 144)) | (1L << (MILLISECONDS - 144)) | (1L << (MIN - 144)) | (1L << (MINVALUE - 144)) | (1L << (MINUTE - 144)) | (1L << (MONTH - 144)) | (1L << (NATIONAL - 144)) | (1L << (NO - 144)) | (1L << (NONE - 144)) | (1L << (NULLIF - 144)) | (1L << (OBJECT - 144)) | (1L << (OPTION - 144)) | (1L << (OPTIONS - 144)) | (1L << (OVERWRITE - 144)) | (1L << (PARSER - 144)))) != 0) || ((((_la - 208)) & ~0x3f) == 0 && ((1L << (_la - 208)) & ((1L << (PARTIAL - 208)) | (1L << (PARTITION - 208)) | (1L << (PARTITIONS - 208)) | (1L << (PRECISION - 208)) | (1L << (PUBLIC - 208)) | (1L << (PURGE - 208)) | (1L << (QUARTER - 208)) | (1L << (RANGE - 208)) | (1L << (REGEXP - 208)) | (1L << (RLIKE - 208)) | (1L << (ROLLUP - 208)) | (1L << (SEARCH - 208)) | (1L << (SECOND - 208)) | (1L << (SECURITY - 208)) | (1L << (SERVER - 208)) | (1L << (SET - 208)) | (1L << (SIMILAR - 208)) | (1L << (SIMPLE - 208)) | (1L << (STABLE - 208)) | (1L << (START - 208)) | (1L << (STORAGE - 208)) | (1L << (STDDEV_POP - 208)) | (1L << (STDDEV_SAMP - 208)) | (1L << (SUBPARTITION - 208)) | (1L << (SUM - 208)) | (1L << (TABLESPACE - 208)) | (1L << (TEMPLATE - 208)) | (1L << (THAN - 208)) | (1L << (TIMEZONE - 208)) | (1L << (TIMEZONE_HOUR - 208)) | (1L << (TIMEZONE_MINUTE - 208)) | (1L << (TRIM - 208)) | (1L << (TO - 208)) | (1L << (UNKNOWN - 208)) | (1L << (UNLOGGED - 208)) | (1L << (VALUES - 208)) | (1L << (VAR_SAMP - 208)) | (1L << (VAR_POP - 208)) | (1L << (VARYING - 208)) | (1L << (VOLATILE - 208)) | (1L << (WEEK - 208)) | (1L << (WINDOW - 208)) | (1L << (WRAPPER - 208)) | (1L << (YEAR - 208)) | (1L << (ZONE - 208)) | (1L << (BOOLEAN - 208)) | (1L << (BOOL - 208)) | (1L << (BIT - 208)) | (1L << (VARBIT - 208)) | (1L << (INT1 - 208)) | (1L << (INT2 - 208)) | (1L << (INT4 - 208)) | (1L << (INT8 - 208)) | (1L << (TINYINT - 208)) | (1L << (SMALLINT - 208)) | (1L << (INT - 208)) | (1L << (INTEGER - 208)) | (1L << (BIGINT - 208)) | (1L << (FLOAT4 - 208)) | (1L << (FLOAT8 - 208)) | (1L << (REAL - 208)) | (1L << (REGCLASS - 208)))) != 0) || ((((_la - 272)) & ~0x3f) == 0 && ((1L << (_la - 272)) & ((1L << (FLOAT - 272)) | (1L << (DOUBLE - 272)) | (1L << (NUMERIC - 272)) | (1L << (DECIMAL - 272)) | (1L << (CHAR - 272)) | (1L << (VARCHAR - 272)) | (1L << (NCHAR - 272)) | (1L << (NVARCHAR - 272)) | (1L << (DATE - 272)) | (1L << (TIME - 272)) | (1L << (TIMETZ - 272)) | (1L << (TIMESTAMP - 272)) | (1L << (TIMESTAMPTZ - 272)) | (1L << (TEXT - 272)) | (1L << (BINARY - 272)) | (1L << (VARBINARY - 272)) | (1L << (BLOB - 272)) | (1L << (BYTEA - 272)) | (1L << (INET4 - 272)) | (1L << (QUOTE - 272)) | (1L << (Identifier - 272)))) != 0)) {
				{
				setState(1520);
				_la = _input.LA(1);
				if (_la==IN || _la==INOUT || _la==OUT || _la==VARIADIC) {
					{
					setState(1519); ((Create_function_statementContext)_localctx).arg_mode = argmode();
					}
				}

				setState(1523);
				switch ( getInterpreter().adaptivePredict(_input,202,_ctx) ) {
				case 1:
					{
					setState(1522); ((Create_function_statementContext)_localctx).argname = identifier();
					}
					break;
				}
				setState(1525); ((Create_function_statementContext)_localctx).argtype = data_type();
				setState(1536);
				_la = _input.LA(1);
				if (_la==DEFAULT || _la==EQUAL) {
					{
					setState(1532); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						setState(1532);
						switch (_input.LA(1)) {
						case DEFAULT:
							{
							setState(1526); match(DEFAULT);
							}
							break;
						case EQUAL:
							{
							setState(1527); match(EQUAL);
							setState(1528); routine_invocation();
							setState(1530);
							_la = _input.LA(1);
							if (_la==COMMA) {
								{
								setState(1529); match(COMMA);
								}
							}

							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						setState(1534); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==DEFAULT || _la==EQUAL );
					}
				}

				}
			}

			setState(1540); match(RIGHT_PAREN);
			setState(1557);
			switch ( getInterpreter().adaptivePredict(_input,210,_ctx) ) {
			case 1:
				{
				setState(1541); match(RETURNS);
				setState(1542); ((Create_function_statementContext)_localctx).rettype = data_type();
				}
				break;
			case 2:
				{
				setState(1543); match(RETURNS);
				setState(1544); match(TABLE);
				setState(1545); match(LEFT_PAREN);
				setState(1551); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1546); ((Create_function_statementContext)_localctx).column_name = identifier();
					setState(1547); ((Create_function_statementContext)_localctx).column_type = data_type();
					setState(1549);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1548); match(COMMA);
						}
					}

					}
					}
					setState(1553); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (ADMIN - 129)) | (1L << (AVG - 129)) | (1L << (BETWEEN - 129)) | (1L << (BY - 129)) | (1L << (CACHE - 129)) | (1L << (CALLED - 129)) | (1L << (CLASS - 129)) | (1L << (CENTURY - 129)) | (1L << (CHARACTER - 129)) | (1L << (CHECK - 129)) | (1L << (COLLECT - 129)) | (1L << (COALESCE - 129)) | (1L << (COLUMN - 129)) | (1L << (COMMENT - 129)) | (1L << (COMMENTS - 129)) | (1L << (COMMIT - 129)) | (1L << (CONFIGURATION - 129)) | (1L << (COST - 129)) | (1L << (COUNT - 129)) | (1L << (CUBE - 129)) | (1L << (CURRENT - 129)) | (1L << (CYCLE - 129)) | (1L << (DATA - 129)) | (1L << (DAY - 129)) | (1L << (DEC - 129)) | (1L << (DECADE - 129)) | (1L << (DEFINER - 129)) | (1L << (DICTIONARY - 129)) | (1L << (DOW - 129)) | (1L << (DOY - 129)) | (1L << (DROP - 129)) | (1L << (EPOCH - 129)) | (1L << (EVERY - 129)) | (1L << (EXISTS - 129)) | (1L << (EXTERNAL - 129)) | (1L << (EXTRACT - 129)) | (1L << (FAMILY - 129)) | (1L << (FILTER - 129)) | (1L << (FIRST - 129)) | (1L << (FORMAT - 129)) | (1L << (FUSION - 129)) | (1L << (GROUPING - 129)) | (1L << (HASH - 129)) | (1L << (INDEX - 129)) | (1L << (INCREMENT - 129)) | (1L << (INPUT - 129)) | (1L << (INSERT - 129)) | (1L << (INTERSECTION - 129)) | (1L << (ISCACHABLE - 129)) | (1L << (ISODOW - 129)) | (1L << (ISOYEAR - 129)) | (1L << (ISSTRICT - 129)) | (1L << (LANGUAGE - 129)) | (1L << (LARGE - 129)) | (1L << (LAST - 129)) | (1L << (LESS - 129)) | (1L << (LIST - 129)) | (1L << (LOCATION - 129)) | (1L << (MATCH - 129)) | (1L << (MAX - 129)) | (1L << (MAXVALUE - 129)) | (1L << (MICROSECONDS - 129)))) != 0) || ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & ((1L << (MILLENNIUM - 193)) | (1L << (MILLISECONDS - 193)) | (1L << (MIN - 193)) | (1L << (MINVALUE - 193)) | (1L << (MINUTE - 193)) | (1L << (MONTH - 193)) | (1L << (NATIONAL - 193)) | (1L << (NO - 193)) | (1L << (NONE - 193)) | (1L << (NULLIF - 193)) | (1L << (OBJECT - 193)) | (1L << (OPTION - 193)) | (1L << (OPTIONS - 193)) | (1L << (OVERWRITE - 193)) | (1L << (PARSER - 193)) | (1L << (PARTIAL - 193)) | (1L << (PARTITION - 193)) | (1L << (PARTITIONS - 193)) | (1L << (PRECISION - 193)) | (1L << (PUBLIC - 193)) | (1L << (PURGE - 193)) | (1L << (QUARTER - 193)) | (1L << (RANGE - 193)) | (1L << (REGEXP - 193)) | (1L << (RLIKE - 193)) | (1L << (ROLLUP - 193)) | (1L << (SEARCH - 193)) | (1L << (SECOND - 193)) | (1L << (SECURITY - 193)) | (1L << (SERVER - 193)) | (1L << (SET - 193)) | (1L << (SIMILAR - 193)) | (1L << (SIMPLE - 193)) | (1L << (STABLE - 193)) | (1L << (START - 193)) | (1L << (STORAGE - 193)) | (1L << (STDDEV_POP - 193)) | (1L << (STDDEV_SAMP - 193)) | (1L << (SUBPARTITION - 193)) | (1L << (SUM - 193)) | (1L << (TABLESPACE - 193)) | (1L << (TEMPLATE - 193)) | (1L << (THAN - 193)) | (1L << (TIMEZONE - 193)) | (1L << (TIMEZONE_HOUR - 193)) | (1L << (TIMEZONE_MINUTE - 193)) | (1L << (TRIM - 193)) | (1L << (TO - 193)) | (1L << (UNKNOWN - 193)) | (1L << (UNLOGGED - 193)) | (1L << (VALUES - 193)) | (1L << (VAR_SAMP - 193)) | (1L << (VAR_POP - 193)) | (1L << (VARYING - 193)) | (1L << (VOLATILE - 193)) | (1L << (WEEK - 193)) | (1L << (WINDOW - 193)) | (1L << (WRAPPER - 193)) | (1L << (YEAR - 193)) | (1L << (ZONE - 193)) | (1L << (BOOLEAN - 193)) | (1L << (BOOL - 193)))) != 0) || ((((_la - 257)) & ~0x3f) == 0 && ((1L << (_la - 257)) & ((1L << (BIT - 257)) | (1L << (VARBIT - 257)) | (1L << (INT1 - 257)) | (1L << (INT2 - 257)) | (1L << (INT4 - 257)) | (1L << (INT8 - 257)) | (1L << (TINYINT - 257)) | (1L << (SMALLINT - 257)) | (1L << (INT - 257)) | (1L << (INTEGER - 257)) | (1L << (BIGINT - 257)) | (1L << (FLOAT4 - 257)) | (1L << (FLOAT8 - 257)) | (1L << (REAL - 257)) | (1L << (FLOAT - 257)) | (1L << (DOUBLE - 257)) | (1L << (NUMERIC - 257)) | (1L << (DECIMAL - 257)) | (1L << (CHAR - 257)) | (1L << (VARCHAR - 257)) | (1L << (NCHAR - 257)) | (1L << (NVARCHAR - 257)) | (1L << (DATE - 257)) | (1L << (TIME - 257)) | (1L << (TIMETZ - 257)) | (1L << (TIMESTAMP - 257)) | (1L << (TIMESTAMPTZ - 257)) | (1L << (TEXT - 257)) | (1L << (VARBINARY - 257)) | (1L << (BLOB - 257)) | (1L << (BYTEA - 257)) | (1L << (INET4 - 257)) | (1L << (QUOTE - 257)))) != 0) || _la==Identifier );
				setState(1555); match(RIGHT_PAREN);
				}
				break;
			}
			setState(1605); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(1605);
					switch ( getInterpreter().adaptivePredict(_input,214,_ctx) ) {
					case 1:
						{
						setState(1559); match(LANGUAGE);
						setState(1560); ((Create_function_statementContext)_localctx).lang_name = identifier();
						}
						break;
					case 2:
						{
						setState(1561); match(WINDOW);
						}
						break;
					case 3:
						{
						setState(1562); match(IMMUTABLE);
						}
						break;
					case 4:
						{
						setState(1563); match(STABLE);
						}
						break;
					case 5:
						{
						setState(1564); match(VOLATILE);
						}
						break;
					case 6:
						{
						setState(1565); match(CALLED);
						setState(1566); match(ON);
						setState(1567); match(NULL);
						setState(1568); match(INPUT);
						}
						break;
					case 7:
						{
						setState(1569); match(RETURNS);
						setState(1570); match(NULL);
						setState(1571); match(ON);
						setState(1572); match(NULL);
						setState(1573); match(INPUT);
						}
						break;
					case 8:
						{
						setState(1574); match(STRICT);
						}
						break;
					case 9:
						{
						setState(1576);
						_la = _input.LA(1);
						if (_la==EXTERNAL) {
							{
							setState(1575); match(EXTERNAL);
							}
						}

						setState(1578); match(SECURITY);
						setState(1579); match(INVOKER);
						}
						break;
					case 10:
						{
						setState(1581);
						_la = _input.LA(1);
						if (_la==EXTERNAL) {
							{
							setState(1580); match(EXTERNAL);
							}
						}

						setState(1583); match(SECURITY);
						setState(1584); match(DEFINER);
						}
						break;
					case 11:
						{
						setState(1585); match(COST);
						setState(1586); ((Create_function_statementContext)_localctx).execution_cost = match(NUMBER);
						}
						break;
					case 12:
						{
						setState(1587); match(ROWS);
						setState(1588); ((Create_function_statementContext)_localctx).result_rows = match(NUMBER);
						}
						break;
					case 13:
						{
						setState(1589); match(SET);
						setState(1590); ((Create_function_statementContext)_localctx).configuration_parameter = identifier();
						setState(1597);
						switch (_input.LA(1)) {
						case TO:
							{
							setState(1591); match(TO);
							setState(1592); ((Create_function_statementContext)_localctx).value = match(Character_String_Literal);
							}
							break;
						case EQUAL:
							{
							setState(1593); match(EQUAL);
							setState(1594); ((Create_function_statementContext)_localctx).value = match(Character_String_Literal);
							}
							break;
						case FROM:
							{
							setState(1595); match(FROM);
							setState(1596); match(CURRENT);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						break;
					case 14:
						{
						setState(1599); match(AS);
						setState(1600); function_body();
						}
						break;
					case 15:
						{
						setState(1601); match(AS);
						setState(1602); match(Character_String_Literal);
						setState(1603); match(COMMA);
						setState(1604); match(Character_String_Literal);
						}
						break;
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1607); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,215,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(1621);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(1609); match(WITH);
				setState(1610); match(LEFT_PAREN);
				setState(1615); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1611); ((Create_function_statementContext)_localctx).attribute = function_attribute();
					setState(1613);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1612); match(COMMA);
						}
					}

					}
					}
					setState(1617); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==ISCACHABLE || _la==ISSTRICT );
				setState(1619); match(RIGHT_PAREN);
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
			setState(1623); match(DOUBLE_DOLLAR);
			setState(1627);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AGGREGATE) | (1L << AFTER) | (1L << AS) | (1L << ALL) | (1L << AND) | (1L << ANY) | (1L << ASYMMETRIC) | (1L << ASC) | (1L << AUTHORIZATION) | (1L << BEFORE) | (1L << BOTH) | (1L << CASE) | (1L << CASCADE) | (1L << CAST) | (1L << COLLATE) | (1L << COLLATION) | (1L << CONNECT) | (1L << CONSTRAINT) | (1L << CONSTRAINTS) | (1L << CONVERSION) | (1L << CREATE) | (1L << CROSS) | (1L << DATABASE) | (1L << DEFAULT) | (1L << DEFAULTS) | (1L << DEFERRABLE) | (1L << DEFERRED) | (1L << DELETE) | (1L << DESC) | (1L << DISTINCT) | (1L << DOMAIN) | (1L << EACH) | (1L << END) | (1L << ELSE) | (1L << EXCEPT) | (1L << EXCLUDE) | (1L << EXCLUDING) | (1L << EXECUTE) | (1L << EXTENSION) | (1L << FALSE) | (1L << FOR) | (1L << FOREIGN) | (1L << FULL) | (1L << FUNCTION) | (1L << FUNCTIONS) | (1L << FROM) | (1L << GLOBAL) | (1L << GRANT) | (1L << GROUP) | (1L << HAVING) | (1L << IF) | (1L << ILIKE) | (1L << IMMEDIATE) | (1L << IMMUTABLE) | (1L << IN) | (1L << INCLUDING) | (1L << INHERITS) | (1L << INITIALLY) | (1L << INNER) | (1L << INTERSECT) | (1L << INTO) | (1L << INOUT) | (1L << INSTEAD))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (INVOKER - 64)) | (1L << (IS - 64)) | (1L << (JOIN - 64)) | (1L << (KEY - 64)) | (1L << (LEADING - 64)) | (1L << (LEFT - 64)) | (1L << (LIKE - 64)) | (1L << (LIMIT - 64)) | (1L << (LOCAL - 64)) | (1L << (NATURAL - 64)) | (1L << (NOT - 64)) | (1L << (NULL - 64)) | (1L << (OF - 64)) | (1L << (OIDS - 64)) | (1L << (ON - 64)) | (1L << (OUTER - 64)) | (1L << (OUT - 64)) | (1L << (OPERATOR - 64)) | (1L << (OR - 64)) | (1L << (ORDER - 64)) | (1L << (OWNED - 64)) | (1L << (PRESERVE - 64)) | (1L << (PRIMARY - 64)) | (1L << (PRIVILEGES - 64)) | (1L << (PROCEDURE - 64)) | (1L << (PROCEDURAL - 64)) | (1L << (ROLE - 64)) | (1L << (ROW - 64)) | (1L << (ROWS - 64)) | (1L << (REFERENCES - 64)) | (1L << (REPLACE - 64)) | (1L << (RESTRICT - 64)) | (1L << (RETURNS - 64)) | (1L << (REVOKE - 64)) | (1L << (RIGHT - 64)) | (1L << (RULE - 64)) | (1L << (SCHEMA - 64)) | (1L << (SEQUENCE - 64)) | (1L << (SEQUENCES - 64)) | (1L << (SELECT - 64)) | (1L << (SESSION - 64)) | (1L << (SOME - 64)) | (1L << (STATEMENT - 64)) | (1L << (STRICT - 64)) | (1L << (SYMMETRIC - 64)) | (1L << (TABLE - 64)) | (1L << (TEMP - 64)) | (1L << (TEMPORARY - 64)) | (1L << (THEN - 64)) | (1L << (TRAILING - 64)) | (1L << (TRIGGER - 64)) | (1L << (TRUE - 64)) | (1L << (TRUNCATE - 64)) | (1L << (TYPE - 64)) | (1L << (UNION - 64)) | (1L << (UNIQUE - 64)) | (1L << (UPDATE - 64)) | (1L << (USAGE - 64)) | (1L << (USING - 64)) | (1L << (VARIADIC - 64)) | (1L << (VIEW - 64)) | (1L << (WHEN - 64)) | (1L << (WHERE - 64)) | (1L << (WITH - 64)))) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (WITHOUT - 128)) | (1L << (ADMIN - 128)) | (1L << (AVG - 128)) | (1L << (BETWEEN - 128)) | (1L << (BY - 128)) | (1L << (CACHE - 128)) | (1L << (CALLED - 128)) | (1L << (CLASS - 128)) | (1L << (CENTURY - 128)) | (1L << (CHARACTER - 128)) | (1L << (CHECK - 128)) | (1L << (COLLECT - 128)) | (1L << (COALESCE - 128)) | (1L << (COLUMN - 128)) | (1L << (COMMENT - 128)) | (1L << (COMMENTS - 128)) | (1L << (COMMIT - 128)) | (1L << (CONFIGURATION - 128)) | (1L << (COST - 128)) | (1L << (COUNT - 128)) | (1L << (CUBE - 128)) | (1L << (CURRENT - 128)) | (1L << (CYCLE - 128)) | (1L << (DATA - 128)) | (1L << (DAY - 128)) | (1L << (DEC - 128)) | (1L << (DECADE - 128)) | (1L << (DEFINER - 128)) | (1L << (DICTIONARY - 128)) | (1L << (DOW - 128)) | (1L << (DOY - 128)) | (1L << (DROP - 128)) | (1L << (EPOCH - 128)) | (1L << (EVERY - 128)) | (1L << (EXISTS - 128)) | (1L << (EXTERNAL - 128)) | (1L << (EXTRACT - 128)) | (1L << (FAMILY - 128)) | (1L << (FILTER - 128)) | (1L << (FIRST - 128)) | (1L << (FORMAT - 128)) | (1L << (FUSION - 128)) | (1L << (GROUPING - 128)) | (1L << (HASH - 128)) | (1L << (HOUR - 128)) | (1L << (INDEX - 128)) | (1L << (INDEXES - 128)) | (1L << (INCREMENT - 128)) | (1L << (INPUT - 128)) | (1L << (INSERT - 128)) | (1L << (INTERSECTION - 128)) | (1L << (ISCACHABLE - 128)) | (1L << (ISODOW - 128)) | (1L << (ISOYEAR - 128)) | (1L << (ISSTRICT - 128)) | (1L << (LANGUAGE - 128)) | (1L << (LARGE - 128)) | (1L << (LAST - 128)) | (1L << (LESS - 128)) | (1L << (LIST - 128)) | (1L << (LOCATION - 128)) | (1L << (MATCH - 128)) | (1L << (MAX - 128)) | (1L << (MAXVALUE - 128)))) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (MICROSECONDS - 192)) | (1L << (MILLENNIUM - 192)) | (1L << (MILLISECONDS - 192)) | (1L << (MIN - 192)) | (1L << (MINVALUE - 192)) | (1L << (MINUTE - 192)) | (1L << (MONTH - 192)) | (1L << (NATIONAL - 192)) | (1L << (NO - 192)) | (1L << (NONE - 192)) | (1L << (NULLIF - 192)) | (1L << (OBJECT - 192)) | (1L << (OPTION - 192)) | (1L << (OPTIONS - 192)) | (1L << (OVERWRITE - 192)) | (1L << (PARSER - 192)) | (1L << (PARTIAL - 192)) | (1L << (PARTITION - 192)) | (1L << (PARTITIONS - 192)) | (1L << (PRECISION - 192)) | (1L << (PUBLIC - 192)) | (1L << (PURGE - 192)) | (1L << (QUARTER - 192)) | (1L << (RANGE - 192)) | (1L << (REGEXP - 192)) | (1L << (RLIKE - 192)) | (1L << (ROLLUP - 192)) | (1L << (SEARCH - 192)) | (1L << (SECOND - 192)) | (1L << (SECURITY - 192)) | (1L << (SERVER - 192)) | (1L << (SET - 192)) | (1L << (SIMILAR - 192)) | (1L << (SIMPLE - 192)) | (1L << (STABLE - 192)) | (1L << (START - 192)) | (1L << (STORAGE - 192)) | (1L << (STDDEV_POP - 192)) | (1L << (STDDEV_SAMP - 192)) | (1L << (SUBPARTITION - 192)) | (1L << (SUM - 192)) | (1L << (TABLESPACE - 192)) | (1L << (TABLES - 192)) | (1L << (TEMPLATE - 192)) | (1L << (THAN - 192)) | (1L << (TIMEZONE - 192)) | (1L << (TIMEZONE_HOUR - 192)) | (1L << (TIMEZONE_MINUTE - 192)) | (1L << (TRIM - 192)) | (1L << (TO - 192)) | (1L << (UNKNOWN - 192)) | (1L << (UNLOGGED - 192)) | (1L << (VALUES - 192)) | (1L << (VAR_SAMP - 192)) | (1L << (VAR_POP - 192)) | (1L << (VARYING - 192)) | (1L << (VERSION - 192)) | (1L << (VOLATILE - 192)) | (1L << (WEEK - 192)) | (1L << (WINDOW - 192)) | (1L << (WRAPPER - 192)) | (1L << (YEAR - 192)) | (1L << (ZONE - 192)) | (1L << (BOOLEAN - 192)))) != 0) || ((((_la - 256)) & ~0x3f) == 0 && ((1L << (_la - 256)) & ((1L << (BOOL - 256)) | (1L << (BIT - 256)) | (1L << (VARBIT - 256)) | (1L << (INT1 - 256)) | (1L << (INT2 - 256)) | (1L << (INT4 - 256)) | (1L << (INT8 - 256)) | (1L << (TINYINT - 256)) | (1L << (SMALLINT - 256)) | (1L << (INT - 256)) | (1L << (INTEGER - 256)) | (1L << (BIGINT - 256)) | (1L << (FLOAT4 - 256)) | (1L << (FLOAT8 - 256)) | (1L << (REAL - 256)) | (1L << (REGCLASS - 256)) | (1L << (FLOAT - 256)) | (1L << (DOUBLE - 256)) | (1L << (NUMERIC - 256)) | (1L << (DECIMAL - 256)) | (1L << (CHAR - 256)) | (1L << (VARCHAR - 256)) | (1L << (NCHAR - 256)) | (1L << (NVARCHAR - 256)) | (1L << (DATE - 256)) | (1L << (TIME - 256)) | (1L << (TIMETZ - 256)) | (1L << (TIMESTAMP - 256)) | (1L << (TIMESTAMPTZ - 256)) | (1L << (TEXT - 256)) | (1L << (BINARY - 256)) | (1L << (VARBINARY - 256)) | (1L << (BLOB - 256)) | (1L << (BYTEA - 256)) | (1L << (INET4 - 256)) | (1L << (Similar_To - 256)) | (1L << (Not_Similar_To - 256)) | (1L << (Similar_To_Case_Insensitive - 256)) | (1L << (Not_Similar_To_Case_Insensitive - 256)) | (1L << (CAST_EXPRESSION - 256)) | (1L << (ASSIGN - 256)) | (1L << (EQUAL - 256)) | (1L << (COLON - 256)) | (1L << (SEMI_COLON - 256)) | (1L << (COMMA - 256)) | (1L << (CONCATENATION_OPERATOR - 256)) | (1L << (NOT_EQUAL - 256)) | (1L << (LTH - 256)) | (1L << (LEQ - 256)) | (1L << (GTH - 256)) | (1L << (GEQ - 256)) | (1L << (LEFT_PAREN - 256)) | (1L << (RIGHT_PAREN - 256)) | (1L << (PLUS - 256)) | (1L << (MINUS - 256)) | (1L << (MULTIPLY - 256)) | (1L << (DIVIDE - 256)) | (1L << (MODULAR - 256)) | (1L << (DOT - 256)) | (1L << (UNDERLINE - 256)) | (1L << (VERTICAL_BAR - 256)) | (1L << (QUOTE - 256)) | (1L << (DOUBLE_QUOTE - 256)) | (1L << (DOLLAR - 256)))) != 0) || ((((_la - 321)) & ~0x3f) == 0 && ((1L << (_la - 321)) & ((1L << (NUMBER - 321)) | (1L << (REAL_NUMBER - 321)) | (1L << (BlockComment - 321)) | (1L << (LineComment - 321)) | (1L << (Identifier - 321)) | (1L << (Character_String_Literal - 321)) | (1L << (ESC_SEQUENCES - 321)) | (1L << (Space - 321)) | (1L << (White_Space - 321)) | (1L << (BAD - 321)))) != 0)) {
				{
				{
				setState(1624);
				_la = _input.LA(1);
				if ( _la <= 0 || (_la==DOUBLE_DOLLAR) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				}
				setState(1629);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1630); match(DOUBLE_DOLLAR);
			}
		}
		catch (RecognitionException re) {
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
			setState(1632);
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
			setState(1634);
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
		public Data_typeContext argtype;
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode FUNCTION() { return getToken(SQLParser.FUNCTION, 0); }
		public Data_typeContext data_type(int i) {
			return getRuleContext(Data_typeContext.class,i);
		}
		public List<ArgmodeContext> argmode() {
			return getRuleContexts(ArgmodeContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public List<Data_typeContext> data_type() {
			return getRuleContexts(Data_typeContext.class);
		}
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
			setState(1636); match(FUNCTION);
			setState(1637); ((Function_definitionContext)_localctx).func_name = identifier();
			setState(1638); match(LEFT_PAREN);
			setState(1651);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IN || _la==INOUT || ((((_la - 80)) & ~0x3f) == 0 && ((1L << (_la - 80)) & ((1L << (OUT - 80)) | (1L << (TRIGGER - 80)) | (1L << (VARIADIC - 80)) | (1L << (ADMIN - 80)) | (1L << (AVG - 80)) | (1L << (BETWEEN - 80)) | (1L << (BY - 80)) | (1L << (CACHE - 80)) | (1L << (CALLED - 80)) | (1L << (CLASS - 80)) | (1L << (CENTURY - 80)) | (1L << (CHARACTER - 80)) | (1L << (CHECK - 80)) | (1L << (COLLECT - 80)) | (1L << (COALESCE - 80)) | (1L << (COLUMN - 80)) | (1L << (COMMENT - 80)) | (1L << (COMMENTS - 80)))) != 0) || ((((_la - 144)) & ~0x3f) == 0 && ((1L << (_la - 144)) & ((1L << (COMMIT - 144)) | (1L << (CONFIGURATION - 144)) | (1L << (COST - 144)) | (1L << (COUNT - 144)) | (1L << (CUBE - 144)) | (1L << (CURRENT - 144)) | (1L << (CYCLE - 144)) | (1L << (DATA - 144)) | (1L << (DAY - 144)) | (1L << (DEC - 144)) | (1L << (DECADE - 144)) | (1L << (DEFINER - 144)) | (1L << (DICTIONARY - 144)) | (1L << (DOW - 144)) | (1L << (DOY - 144)) | (1L << (DROP - 144)) | (1L << (EPOCH - 144)) | (1L << (EVERY - 144)) | (1L << (EXISTS - 144)) | (1L << (EXTERNAL - 144)) | (1L << (EXTRACT - 144)) | (1L << (FAMILY - 144)) | (1L << (FILTER - 144)) | (1L << (FIRST - 144)) | (1L << (FORMAT - 144)) | (1L << (FUSION - 144)) | (1L << (GROUPING - 144)) | (1L << (HASH - 144)) | (1L << (INDEX - 144)) | (1L << (INCREMENT - 144)) | (1L << (INPUT - 144)) | (1L << (INSERT - 144)) | (1L << (INTERSECTION - 144)) | (1L << (ISCACHABLE - 144)) | (1L << (ISODOW - 144)) | (1L << (ISOYEAR - 144)) | (1L << (ISSTRICT - 144)) | (1L << (LANGUAGE - 144)) | (1L << (LARGE - 144)) | (1L << (LAST - 144)) | (1L << (LESS - 144)) | (1L << (LIST - 144)) | (1L << (LOCATION - 144)) | (1L << (MATCH - 144)) | (1L << (MAX - 144)) | (1L << (MAXVALUE - 144)) | (1L << (MICROSECONDS - 144)) | (1L << (MILLENNIUM - 144)) | (1L << (MILLISECONDS - 144)) | (1L << (MIN - 144)) | (1L << (MINVALUE - 144)) | (1L << (MINUTE - 144)) | (1L << (MONTH - 144)) | (1L << (NATIONAL - 144)) | (1L << (NO - 144)) | (1L << (NONE - 144)) | (1L << (NULLIF - 144)) | (1L << (OBJECT - 144)) | (1L << (OPTION - 144)) | (1L << (OPTIONS - 144)) | (1L << (OVERWRITE - 144)) | (1L << (PARSER - 144)))) != 0) || ((((_la - 208)) & ~0x3f) == 0 && ((1L << (_la - 208)) & ((1L << (PARTIAL - 208)) | (1L << (PARTITION - 208)) | (1L << (PARTITIONS - 208)) | (1L << (PRECISION - 208)) | (1L << (PUBLIC - 208)) | (1L << (PURGE - 208)) | (1L << (QUARTER - 208)) | (1L << (RANGE - 208)) | (1L << (REGEXP - 208)) | (1L << (RLIKE - 208)) | (1L << (ROLLUP - 208)) | (1L << (SEARCH - 208)) | (1L << (SECOND - 208)) | (1L << (SECURITY - 208)) | (1L << (SERVER - 208)) | (1L << (SET - 208)) | (1L << (SIMILAR - 208)) | (1L << (SIMPLE - 208)) | (1L << (STABLE - 208)) | (1L << (START - 208)) | (1L << (STORAGE - 208)) | (1L << (STDDEV_POP - 208)) | (1L << (STDDEV_SAMP - 208)) | (1L << (SUBPARTITION - 208)) | (1L << (SUM - 208)) | (1L << (TABLESPACE - 208)) | (1L << (TEMPLATE - 208)) | (1L << (THAN - 208)) | (1L << (TIMEZONE - 208)) | (1L << (TIMEZONE_HOUR - 208)) | (1L << (TIMEZONE_MINUTE - 208)) | (1L << (TRIM - 208)) | (1L << (TO - 208)) | (1L << (UNKNOWN - 208)) | (1L << (UNLOGGED - 208)) | (1L << (VALUES - 208)) | (1L << (VAR_SAMP - 208)) | (1L << (VAR_POP - 208)) | (1L << (VARYING - 208)) | (1L << (VOLATILE - 208)) | (1L << (WEEK - 208)) | (1L << (WINDOW - 208)) | (1L << (WRAPPER - 208)) | (1L << (YEAR - 208)) | (1L << (ZONE - 208)) | (1L << (BOOLEAN - 208)) | (1L << (BOOL - 208)) | (1L << (BIT - 208)) | (1L << (VARBIT - 208)) | (1L << (INT1 - 208)) | (1L << (INT2 - 208)) | (1L << (INT4 - 208)) | (1L << (INT8 - 208)) | (1L << (TINYINT - 208)) | (1L << (SMALLINT - 208)) | (1L << (INT - 208)) | (1L << (INTEGER - 208)) | (1L << (BIGINT - 208)) | (1L << (FLOAT4 - 208)) | (1L << (FLOAT8 - 208)) | (1L << (REAL - 208)) | (1L << (REGCLASS - 208)))) != 0) || ((((_la - 272)) & ~0x3f) == 0 && ((1L << (_la - 272)) & ((1L << (FLOAT - 272)) | (1L << (DOUBLE - 272)) | (1L << (NUMERIC - 272)) | (1L << (DECIMAL - 272)) | (1L << (CHAR - 272)) | (1L << (VARCHAR - 272)) | (1L << (NCHAR - 272)) | (1L << (NVARCHAR - 272)) | (1L << (DATE - 272)) | (1L << (TIME - 272)) | (1L << (TIMETZ - 272)) | (1L << (TIMESTAMP - 272)) | (1L << (TIMESTAMPTZ - 272)) | (1L << (TEXT - 272)) | (1L << (BINARY - 272)) | (1L << (VARBINARY - 272)) | (1L << (BLOB - 272)) | (1L << (BYTEA - 272)) | (1L << (INET4 - 272)) | (1L << (QUOTE - 272)) | (1L << (Identifier - 272)))) != 0)) {
				{
				{
				setState(1640);
				_la = _input.LA(1);
				if (_la==IN || _la==INOUT || _la==OUT || _la==VARIADIC) {
					{
					setState(1639); ((Function_definitionContext)_localctx).arg_mode = argmode();
					}
				}

				setState(1643);
				switch ( getInterpreter().adaptivePredict(_input,221,_ctx) ) {
				case 1:
					{
					setState(1642); ((Function_definitionContext)_localctx).argname = identifier();
					}
					break;
				}
				setState(1645); ((Function_definitionContext)_localctx).argtype = data_type();
				setState(1647);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(1646); match(COMMA);
					}
				}

				}
				}
				setState(1653);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1654); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
			setState(1656); match(ALL);
			setState(1657); match(FUNCTIONS);
			setState(1658); match(IN);
			setState(1659); match(SCHEMA);
			setState(1664); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(1660); ((Functions_definition_schemaContext)_localctx).schema_name = identifier();
					setState(1662);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1661); match(COMMA);
						}
					}

					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1666); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,225,_ctx);
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
			setState(1668); match(CREATE);
			setState(1670);
			_la = _input.LA(1);
			if (_la==TEMP || _la==TEMPORARY) {
				{
				setState(1669);
				_la = _input.LA(1);
				if ( !(_la==TEMP || _la==TEMPORARY) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(1672); match(SEQUENCE);
			setState(1673); ((Create_sequence_statementContext)_localctx).name = schema_qualified_name();
			setState(1710);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,234,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(1708);
					switch ( getInterpreter().adaptivePredict(_input,233,_ctx) ) {
					case 1:
						{
						{
						setState(1674); match(INCREMENT);
						setState(1676);
						_la = _input.LA(1);
						if (_la==BY) {
							{
							setState(1675); match(BY);
							}
						}

						setState(1678); ((Create_sequence_statementContext)_localctx).incr = match(NUMBER);
						}
						}
						break;
					case 2:
						{
						setState(1683);
						switch (_input.LA(1)) {
						case MINVALUE:
							{
							setState(1679); match(MINVALUE);
							setState(1680); ((Create_sequence_statementContext)_localctx).minval = match(NUMBER);
							}
							break;
						case NO:
							{
							setState(1681); match(NO);
							setState(1682); match(MINVALUE);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						break;
					case 3:
						{
						setState(1689);
						switch (_input.LA(1)) {
						case MAXVALUE:
							{
							setState(1685); match(MAXVALUE);
							setState(1686); ((Create_sequence_statementContext)_localctx).maxval = numeric_type();
							}
							break;
						case NO:
							{
							setState(1687); match(NO);
							setState(1688); match(MAXVALUE);
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
						setState(1691); match(START);
						setState(1693);
						_la = _input.LA(1);
						if (_la==WITH) {
							{
							setState(1692); match(WITH);
							}
						}

						setState(1695); ((Create_sequence_statementContext)_localctx).start_val = match(NUMBER);
						}
						}
						break;
					case 5:
						{
						{
						setState(1696); match(CACHE);
						setState(1697); ((Create_sequence_statementContext)_localctx).cache_val = match(NUMBER);
						}
						}
						break;
					case 6:
						{
						{
						setState(1699);
						_la = _input.LA(1);
						if (_la==NO) {
							{
							setState(1698); match(NO);
							}
						}

						setState(1701); match(CYCLE);
						}
						}
						break;
					case 7:
						{
						{
						setState(1702); match(OWNED);
						setState(1703); match(BY);
						setState(1706);
						switch ( getInterpreter().adaptivePredict(_input,232,_ctx) ) {
						case 1:
							{
							setState(1704); ((Create_sequence_statementContext)_localctx).col_name = schema_qualified_name();
							}
							break;
						case 2:
							{
							setState(1705); match(NONE);
							}
							break;
						}
						}
						}
						break;
					}
					} 
				}
				setState(1712);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,234,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
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
			setState(1753);
			switch ( getInterpreter().adaptivePredict(_input,239,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1713); match(CREATE);
				setState(1714); match(SCHEMA);
				setState(1715); ((Create_schema_statementContext)_localctx).schema_name = identifier();
				setState(1718);
				_la = _input.LA(1);
				if (_la==AUTHORIZATION) {
					{
					setState(1716); match(AUTHORIZATION);
					setState(1717); ((Create_schema_statementContext)_localctx).user_name = identifier();
					}
				}

				setState(1723);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,236,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1720); ((Create_schema_statementContext)_localctx).schema_element = sql();
						}
						} 
					}
					setState(1725);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,236,_ctx);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1726); match(CREATE);
				setState(1727); match(SCHEMA);
				setState(1728); match(AUTHORIZATION);
				setState(1729); ((Create_schema_statementContext)_localctx).user_name = identifier();
				setState(1733);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,237,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1730); ((Create_schema_statementContext)_localctx).schema_element = sql();
						}
						} 
					}
					setState(1735);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,237,_ctx);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1736); match(CREATE);
				setState(1737); match(SCHEMA);
				setState(1738); match(IF);
				setState(1739); match(NOT);
				setState(1740); match(EXISTS);
				setState(1741); ((Create_schema_statementContext)_localctx).schema_name = identifier();
				setState(1744);
				_la = _input.LA(1);
				if (_la==AUTHORIZATION) {
					{
					setState(1742); match(AUTHORIZATION);
					setState(1743); ((Create_schema_statementContext)_localctx).user_name = identifier();
					}
				}

				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1746); match(CREATE);
				setState(1747); match(SCHEMA);
				setState(1748); match(IF);
				setState(1749); match(NOT);
				setState(1750); match(EXISTS);
				setState(1751); match(AUTHORIZATION);
				setState(1752); ((Create_schema_statementContext)_localctx).user_name = identifier();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 44, RULE_create_table_statement);
		int _la;
		try {
			int _alt;
			setState(1917);
			switch ( getInterpreter().adaptivePredict(_input,270,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1755); match(CREATE);
				setState(1756); match(EXTERNAL);
				setState(1757); match(TABLE);
				setState(1758); ((Create_table_statementContext)_localctx).n = schema_qualified_name();
				setState(1759); table_elements();
				setState(1760); match(USING);
				setState(1761); ((Create_table_statementContext)_localctx).file_type = identifier();
				setState(1763);
				_la = _input.LA(1);
				if (_la==WITH) {
					{
					setState(1762); param_clause();
					}
				}

				setState(1766);
				_la = _input.LA(1);
				if (_la==PARTITION) {
					{
					setState(1765); table_partitioning_clauses();
					}
				}

				{
				setState(1768); match(LOCATION);
				setState(1769); ((Create_table_statementContext)_localctx).path = match(Character_String_Literal);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1771); match(CREATE);
				setState(1772); match(TABLE);
				setState(1773); ((Create_table_statementContext)_localctx).n = schema_qualified_name();
				setState(1774); table_elements();
				setState(1777);
				_la = _input.LA(1);
				if (_la==USING) {
					{
					setState(1775); match(USING);
					setState(1776); ((Create_table_statementContext)_localctx).file_type = identifier();
					}
				}

				setState(1780);
				_la = _input.LA(1);
				if (_la==WITH) {
					{
					setState(1779); param_clause();
					}
				}

				setState(1783);
				switch ( getInterpreter().adaptivePredict(_input,244,_ctx) ) {
				case 1:
					{
					setState(1782); table_partitioning_clauses();
					}
					break;
				}
				setState(1787);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(1785); match(AS);
					setState(1786); query_expression();
					}
				}

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1789); match(CREATE);
				setState(1790); match(TABLE);
				setState(1791); ((Create_table_statementContext)_localctx).n = schema_qualified_name();
				setState(1794);
				_la = _input.LA(1);
				if (_la==USING) {
					{
					setState(1792); match(USING);
					setState(1793); ((Create_table_statementContext)_localctx).file_type = identifier();
					}
				}

				setState(1797);
				_la = _input.LA(1);
				if (_la==WITH) {
					{
					setState(1796); param_clause();
					}
				}

				setState(1800);
				_la = _input.LA(1);
				if (_la==PARTITION) {
					{
					setState(1799); table_partitioning_clauses();
					}
				}

				setState(1802); match(AS);
				setState(1803); query_expression();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1805); match(CREATE);
				setState(1811);
				switch (_input.LA(1)) {
				case GLOBAL:
				case LOCAL:
				case TEMP:
				case TEMPORARY:
					{
					setState(1807);
					_la = _input.LA(1);
					if (_la==GLOBAL || _la==LOCAL) {
						{
						setState(1806);
						_la = _input.LA(1);
						if ( !(_la==GLOBAL || _la==LOCAL) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
					}

					setState(1809);
					_la = _input.LA(1);
					if ( !(_la==TEMP || _la==TEMPORARY) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
					break;
				case UNLOGGED:
					{
					setState(1810); match(UNLOGGED);
					}
					break;
				case TABLE:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1813); match(TABLE);
				setState(1817);
				_la = _input.LA(1);
				if (_la==IF) {
					{
					setState(1814); match(IF);
					setState(1815); match(NOT);
					setState(1816); match(EXISTS);
					}
				}

				setState(1819); ((Create_table_statementContext)_localctx).n = schema_qualified_name();
				setState(1820); match(LEFT_PAREN);
				setState(1851);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CONSTRAINT) | (1L << EXCLUDE) | (1L << FOREIGN))) != 0) || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (LIKE - 70)) | (1L << (PRIMARY - 70)) | (1L << (UNIQUE - 70)) | (1L << (ADMIN - 70)) | (1L << (AVG - 70)) | (1L << (BETWEEN - 70)) | (1L << (BY - 70)) | (1L << (CACHE - 70)))) != 0) || ((((_la - 134)) & ~0x3f) == 0 && ((1L << (_la - 134)) & ((1L << (CALLED - 134)) | (1L << (CLASS - 134)) | (1L << (CENTURY - 134)) | (1L << (CHARACTER - 134)) | (1L << (CHECK - 134)) | (1L << (COLLECT - 134)) | (1L << (COALESCE - 134)) | (1L << (COLUMN - 134)) | (1L << (COMMENT - 134)) | (1L << (COMMENTS - 134)) | (1L << (COMMIT - 134)) | (1L << (CONFIGURATION - 134)) | (1L << (COST - 134)) | (1L << (COUNT - 134)) | (1L << (CUBE - 134)) | (1L << (CURRENT - 134)) | (1L << (CYCLE - 134)) | (1L << (DATA - 134)) | (1L << (DAY - 134)) | (1L << (DEC - 134)) | (1L << (DECADE - 134)) | (1L << (DEFINER - 134)) | (1L << (DICTIONARY - 134)) | (1L << (DOW - 134)) | (1L << (DOY - 134)) | (1L << (DROP - 134)) | (1L << (EPOCH - 134)) | (1L << (EVERY - 134)) | (1L << (EXISTS - 134)) | (1L << (EXTERNAL - 134)) | (1L << (EXTRACT - 134)) | (1L << (FAMILY - 134)) | (1L << (FILTER - 134)) | (1L << (FIRST - 134)) | (1L << (FORMAT - 134)) | (1L << (FUSION - 134)) | (1L << (GROUPING - 134)) | (1L << (HASH - 134)) | (1L << (INDEX - 134)) | (1L << (INCREMENT - 134)) | (1L << (INPUT - 134)) | (1L << (INSERT - 134)) | (1L << (INTERSECTION - 134)) | (1L << (ISCACHABLE - 134)) | (1L << (ISODOW - 134)) | (1L << (ISOYEAR - 134)) | (1L << (ISSTRICT - 134)) | (1L << (LANGUAGE - 134)) | (1L << (LARGE - 134)) | (1L << (LAST - 134)) | (1L << (LESS - 134)) | (1L << (LIST - 134)) | (1L << (LOCATION - 134)) | (1L << (MATCH - 134)) | (1L << (MAX - 134)) | (1L << (MAXVALUE - 134)) | (1L << (MICROSECONDS - 134)) | (1L << (MILLENNIUM - 134)) | (1L << (MILLISECONDS - 134)) | (1L << (MIN - 134)) | (1L << (MINVALUE - 134)) | (1L << (MINUTE - 134)))) != 0) || ((((_la - 198)) & ~0x3f) == 0 && ((1L << (_la - 198)) & ((1L << (MONTH - 198)) | (1L << (NATIONAL - 198)) | (1L << (NO - 198)) | (1L << (NONE - 198)) | (1L << (NULLIF - 198)) | (1L << (OBJECT - 198)) | (1L << (OPTION - 198)) | (1L << (OPTIONS - 198)) | (1L << (OVERWRITE - 198)) | (1L << (PARSER - 198)) | (1L << (PARTIAL - 198)) | (1L << (PARTITION - 198)) | (1L << (PARTITIONS - 198)) | (1L << (PRECISION - 198)) | (1L << (PUBLIC - 198)) | (1L << (PURGE - 198)) | (1L << (QUARTER - 198)) | (1L << (RANGE - 198)) | (1L << (REGEXP - 198)) | (1L << (RLIKE - 198)) | (1L << (ROLLUP - 198)) | (1L << (SEARCH - 198)) | (1L << (SECOND - 198)) | (1L << (SECURITY - 198)) | (1L << (SERVER - 198)) | (1L << (SET - 198)) | (1L << (SIMILAR - 198)) | (1L << (SIMPLE - 198)) | (1L << (STABLE - 198)) | (1L << (START - 198)) | (1L << (STORAGE - 198)) | (1L << (STDDEV_POP - 198)) | (1L << (STDDEV_SAMP - 198)) | (1L << (SUBPARTITION - 198)) | (1L << (SUM - 198)) | (1L << (TABLESPACE - 198)) | (1L << (TEMPLATE - 198)) | (1L << (THAN - 198)) | (1L << (TIMEZONE - 198)) | (1L << (TIMEZONE_HOUR - 198)) | (1L << (TIMEZONE_MINUTE - 198)) | (1L << (TRIM - 198)) | (1L << (TO - 198)) | (1L << (UNKNOWN - 198)) | (1L << (UNLOGGED - 198)) | (1L << (VALUES - 198)) | (1L << (VAR_SAMP - 198)) | (1L << (VAR_POP - 198)) | (1L << (VARYING - 198)) | (1L << (VOLATILE - 198)) | (1L << (WEEK - 198)) | (1L << (WINDOW - 198)) | (1L << (WRAPPER - 198)) | (1L << (YEAR - 198)) | (1L << (ZONE - 198)) | (1L << (BOOLEAN - 198)) | (1L << (BOOL - 198)) | (1L << (BIT - 198)) | (1L << (VARBIT - 198)) | (1L << (INT1 - 198)) | (1L << (INT2 - 198)) | (1L << (INT4 - 198)))) != 0) || ((((_la - 262)) & ~0x3f) == 0 && ((1L << (_la - 262)) & ((1L << (INT8 - 262)) | (1L << (TINYINT - 262)) | (1L << (SMALLINT - 262)) | (1L << (INT - 262)) | (1L << (INTEGER - 262)) | (1L << (BIGINT - 262)) | (1L << (FLOAT4 - 262)) | (1L << (FLOAT8 - 262)) | (1L << (REAL - 262)) | (1L << (FLOAT - 262)) | (1L << (DOUBLE - 262)) | (1L << (NUMERIC - 262)) | (1L << (DECIMAL - 262)) | (1L << (CHAR - 262)) | (1L << (VARCHAR - 262)) | (1L << (NCHAR - 262)) | (1L << (NVARCHAR - 262)) | (1L << (DATE - 262)) | (1L << (TIME - 262)) | (1L << (TIMETZ - 262)) | (1L << (TIMESTAMP - 262)) | (1L << (TIMESTAMPTZ - 262)) | (1L << (TEXT - 262)) | (1L << (VARBINARY - 262)) | (1L << (BLOB - 262)) | (1L << (BYTEA - 262)) | (1L << (INET4 - 262)) | (1L << (QUOTE - 262)) | (1L << (Identifier - 262)))) != 0)) {
					{
					setState(1847); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1842);
						switch ( getInterpreter().adaptivePredict(_input,255,_ctx) ) {
						case 1:
							{
							{
							setState(1821); ((Create_table_statementContext)_localctx).column_name = identifier();
							setState(1822); ((Create_table_statementContext)_localctx).datatype = data_type();
							setState(1825);
							_la = _input.LA(1);
							if (_la==COLLATE) {
								{
								setState(1823); match(COLLATE);
								setState(1824); ((Create_table_statementContext)_localctx).collation = identifier();
								}
							}

							setState(1830);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,253,_ctx);
							while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
								if ( _alt==1 ) {
									{
									{
									setState(1827); ((Create_table_statementContext)_localctx).colmn_constraint = column_constraint();
									}
									} 
								}
								setState(1832);
								_errHandler.sync(this);
								_alt = getInterpreter().adaptivePredict(_input,253,_ctx);
							}
							}
							}
							break;
						case 2:
							{
							setState(1833); ((Create_table_statementContext)_localctx).tabl_constraint = table_constraint();
							}
							break;
						case 3:
							{
							{
							setState(1834); match(LIKE);
							setState(1835); ((Create_table_statementContext)_localctx).parent_table = identifier();
							setState(1839);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==EXCLUDING || _la==INCLUDING) {
								{
								{
								setState(1836); ((Create_table_statementContext)_localctx).like_opt = like_option();
								}
								}
								setState(1841);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
							}
							break;
						}
						setState(1845);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1844); match(COMMA);
							}
						}

						}
						}
						setState(1849); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CONSTRAINT) | (1L << EXCLUDE) | (1L << FOREIGN))) != 0) || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (LIKE - 70)) | (1L << (PRIMARY - 70)) | (1L << (UNIQUE - 70)) | (1L << (ADMIN - 70)) | (1L << (AVG - 70)) | (1L << (BETWEEN - 70)) | (1L << (BY - 70)) | (1L << (CACHE - 70)))) != 0) || ((((_la - 134)) & ~0x3f) == 0 && ((1L << (_la - 134)) & ((1L << (CALLED - 134)) | (1L << (CLASS - 134)) | (1L << (CENTURY - 134)) | (1L << (CHARACTER - 134)) | (1L << (CHECK - 134)) | (1L << (COLLECT - 134)) | (1L << (COALESCE - 134)) | (1L << (COLUMN - 134)) | (1L << (COMMENT - 134)) | (1L << (COMMENTS - 134)) | (1L << (COMMIT - 134)) | (1L << (CONFIGURATION - 134)) | (1L << (COST - 134)) | (1L << (COUNT - 134)) | (1L << (CUBE - 134)) | (1L << (CURRENT - 134)) | (1L << (CYCLE - 134)) | (1L << (DATA - 134)) | (1L << (DAY - 134)) | (1L << (DEC - 134)) | (1L << (DECADE - 134)) | (1L << (DEFINER - 134)) | (1L << (DICTIONARY - 134)) | (1L << (DOW - 134)) | (1L << (DOY - 134)) | (1L << (DROP - 134)) | (1L << (EPOCH - 134)) | (1L << (EVERY - 134)) | (1L << (EXISTS - 134)) | (1L << (EXTERNAL - 134)) | (1L << (EXTRACT - 134)) | (1L << (FAMILY - 134)) | (1L << (FILTER - 134)) | (1L << (FIRST - 134)) | (1L << (FORMAT - 134)) | (1L << (FUSION - 134)) | (1L << (GROUPING - 134)) | (1L << (HASH - 134)) | (1L << (INDEX - 134)) | (1L << (INCREMENT - 134)) | (1L << (INPUT - 134)) | (1L << (INSERT - 134)) | (1L << (INTERSECTION - 134)) | (1L << (ISCACHABLE - 134)) | (1L << (ISODOW - 134)) | (1L << (ISOYEAR - 134)) | (1L << (ISSTRICT - 134)) | (1L << (LANGUAGE - 134)) | (1L << (LARGE - 134)) | (1L << (LAST - 134)) | (1L << (LESS - 134)) | (1L << (LIST - 134)) | (1L << (LOCATION - 134)) | (1L << (MATCH - 134)) | (1L << (MAX - 134)) | (1L << (MAXVALUE - 134)) | (1L << (MICROSECONDS - 134)) | (1L << (MILLENNIUM - 134)) | (1L << (MILLISECONDS - 134)) | (1L << (MIN - 134)) | (1L << (MINVALUE - 134)) | (1L << (MINUTE - 134)))) != 0) || ((((_la - 198)) & ~0x3f) == 0 && ((1L << (_la - 198)) & ((1L << (MONTH - 198)) | (1L << (NATIONAL - 198)) | (1L << (NO - 198)) | (1L << (NONE - 198)) | (1L << (NULLIF - 198)) | (1L << (OBJECT - 198)) | (1L << (OPTION - 198)) | (1L << (OPTIONS - 198)) | (1L << (OVERWRITE - 198)) | (1L << (PARSER - 198)) | (1L << (PARTIAL - 198)) | (1L << (PARTITION - 198)) | (1L << (PARTITIONS - 198)) | (1L << (PRECISION - 198)) | (1L << (PUBLIC - 198)) | (1L << (PURGE - 198)) | (1L << (QUARTER - 198)) | (1L << (RANGE - 198)) | (1L << (REGEXP - 198)) | (1L << (RLIKE - 198)) | (1L << (ROLLUP - 198)) | (1L << (SEARCH - 198)) | (1L << (SECOND - 198)) | (1L << (SECURITY - 198)) | (1L << (SERVER - 198)) | (1L << (SET - 198)) | (1L << (SIMILAR - 198)) | (1L << (SIMPLE - 198)) | (1L << (STABLE - 198)) | (1L << (START - 198)) | (1L << (STORAGE - 198)) | (1L << (STDDEV_POP - 198)) | (1L << (STDDEV_SAMP - 198)) | (1L << (SUBPARTITION - 198)) | (1L << (SUM - 198)) | (1L << (TABLESPACE - 198)) | (1L << (TEMPLATE - 198)) | (1L << (THAN - 198)) | (1L << (TIMEZONE - 198)) | (1L << (TIMEZONE_HOUR - 198)) | (1L << (TIMEZONE_MINUTE - 198)) | (1L << (TRIM - 198)) | (1L << (TO - 198)) | (1L << (UNKNOWN - 198)) | (1L << (UNLOGGED - 198)) | (1L << (VALUES - 198)) | (1L << (VAR_SAMP - 198)) | (1L << (VAR_POP - 198)) | (1L << (VARYING - 198)) | (1L << (VOLATILE - 198)) | (1L << (WEEK - 198)) | (1L << (WINDOW - 198)) | (1L << (WRAPPER - 198)) | (1L << (YEAR - 198)) | (1L << (ZONE - 198)) | (1L << (BOOLEAN - 198)) | (1L << (BOOL - 198)) | (1L << (BIT - 198)) | (1L << (VARBIT - 198)) | (1L << (INT1 - 198)) | (1L << (INT2 - 198)) | (1L << (INT4 - 198)))) != 0) || ((((_la - 262)) & ~0x3f) == 0 && ((1L << (_la - 262)) & ((1L << (INT8 - 262)) | (1L << (TINYINT - 262)) | (1L << (SMALLINT - 262)) | (1L << (INT - 262)) | (1L << (INTEGER - 262)) | (1L << (BIGINT - 262)) | (1L << (FLOAT4 - 262)) | (1L << (FLOAT8 - 262)) | (1L << (REAL - 262)) | (1L << (FLOAT - 262)) | (1L << (DOUBLE - 262)) | (1L << (NUMERIC - 262)) | (1L << (DECIMAL - 262)) | (1L << (CHAR - 262)) | (1L << (VARCHAR - 262)) | (1L << (NCHAR - 262)) | (1L << (NVARCHAR - 262)) | (1L << (DATE - 262)) | (1L << (TIME - 262)) | (1L << (TIMETZ - 262)) | (1L << (TIMESTAMP - 262)) | (1L << (TIMESTAMPTZ - 262)) | (1L << (TEXT - 262)) | (1L << (VARBINARY - 262)) | (1L << (BLOB - 262)) | (1L << (BYTEA - 262)) | (1L << (INET4 - 262)) | (1L << (QUOTE - 262)) | (1L << (Identifier - 262)))) != 0) );
					}
				}

				setState(1853); match(RIGHT_PAREN);
				setState(1866);
				_la = _input.LA(1);
				if (_la==INHERITS) {
					{
					setState(1854); match(INHERITS);
					setState(1855); match(LEFT_PAREN);
					setState(1860); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1856); ((Create_table_statementContext)_localctx).parent_table = identifier();
						setState(1858);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1857); match(COMMA);
							}
						}

						}
						}
						setState(1862); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (ADMIN - 129)) | (1L << (AVG - 129)) | (1L << (BETWEEN - 129)) | (1L << (BY - 129)) | (1L << (CACHE - 129)) | (1L << (CALLED - 129)) | (1L << (CLASS - 129)) | (1L << (CENTURY - 129)) | (1L << (CHARACTER - 129)) | (1L << (CHECK - 129)) | (1L << (COLLECT - 129)) | (1L << (COALESCE - 129)) | (1L << (COLUMN - 129)) | (1L << (COMMENT - 129)) | (1L << (COMMENTS - 129)) | (1L << (COMMIT - 129)) | (1L << (CONFIGURATION - 129)) | (1L << (COST - 129)) | (1L << (COUNT - 129)) | (1L << (CUBE - 129)) | (1L << (CURRENT - 129)) | (1L << (CYCLE - 129)) | (1L << (DATA - 129)) | (1L << (DAY - 129)) | (1L << (DEC - 129)) | (1L << (DECADE - 129)) | (1L << (DEFINER - 129)) | (1L << (DICTIONARY - 129)) | (1L << (DOW - 129)) | (1L << (DOY - 129)) | (1L << (DROP - 129)) | (1L << (EPOCH - 129)) | (1L << (EVERY - 129)) | (1L << (EXISTS - 129)) | (1L << (EXTERNAL - 129)) | (1L << (EXTRACT - 129)) | (1L << (FAMILY - 129)) | (1L << (FILTER - 129)) | (1L << (FIRST - 129)) | (1L << (FORMAT - 129)) | (1L << (FUSION - 129)) | (1L << (GROUPING - 129)) | (1L << (HASH - 129)) | (1L << (INDEX - 129)) | (1L << (INCREMENT - 129)) | (1L << (INPUT - 129)) | (1L << (INSERT - 129)) | (1L << (INTERSECTION - 129)) | (1L << (ISCACHABLE - 129)) | (1L << (ISODOW - 129)) | (1L << (ISOYEAR - 129)) | (1L << (ISSTRICT - 129)) | (1L << (LANGUAGE - 129)) | (1L << (LARGE - 129)) | (1L << (LAST - 129)) | (1L << (LESS - 129)) | (1L << (LIST - 129)) | (1L << (LOCATION - 129)) | (1L << (MATCH - 129)) | (1L << (MAX - 129)) | (1L << (MAXVALUE - 129)) | (1L << (MICROSECONDS - 129)))) != 0) || ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & ((1L << (MILLENNIUM - 193)) | (1L << (MILLISECONDS - 193)) | (1L << (MIN - 193)) | (1L << (MINVALUE - 193)) | (1L << (MINUTE - 193)) | (1L << (MONTH - 193)) | (1L << (NATIONAL - 193)) | (1L << (NO - 193)) | (1L << (NONE - 193)) | (1L << (NULLIF - 193)) | (1L << (OBJECT - 193)) | (1L << (OPTION - 193)) | (1L << (OPTIONS - 193)) | (1L << (OVERWRITE - 193)) | (1L << (PARSER - 193)) | (1L << (PARTIAL - 193)) | (1L << (PARTITION - 193)) | (1L << (PARTITIONS - 193)) | (1L << (PRECISION - 193)) | (1L << (PUBLIC - 193)) | (1L << (PURGE - 193)) | (1L << (QUARTER - 193)) | (1L << (RANGE - 193)) | (1L << (REGEXP - 193)) | (1L << (RLIKE - 193)) | (1L << (ROLLUP - 193)) | (1L << (SEARCH - 193)) | (1L << (SECOND - 193)) | (1L << (SECURITY - 193)) | (1L << (SERVER - 193)) | (1L << (SET - 193)) | (1L << (SIMILAR - 193)) | (1L << (SIMPLE - 193)) | (1L << (STABLE - 193)) | (1L << (START - 193)) | (1L << (STORAGE - 193)) | (1L << (STDDEV_POP - 193)) | (1L << (STDDEV_SAMP - 193)) | (1L << (SUBPARTITION - 193)) | (1L << (SUM - 193)) | (1L << (TABLESPACE - 193)) | (1L << (TEMPLATE - 193)) | (1L << (THAN - 193)) | (1L << (TIMEZONE - 193)) | (1L << (TIMEZONE_HOUR - 193)) | (1L << (TIMEZONE_MINUTE - 193)) | (1L << (TRIM - 193)) | (1L << (TO - 193)) | (1L << (UNKNOWN - 193)) | (1L << (UNLOGGED - 193)) | (1L << (VALUES - 193)) | (1L << (VAR_SAMP - 193)) | (1L << (VAR_POP - 193)) | (1L << (VARYING - 193)) | (1L << (VOLATILE - 193)) | (1L << (WEEK - 193)) | (1L << (WINDOW - 193)) | (1L << (WRAPPER - 193)) | (1L << (YEAR - 193)) | (1L << (ZONE - 193)) | (1L << (BOOLEAN - 193)) | (1L << (BOOL - 193)))) != 0) || ((((_la - 257)) & ~0x3f) == 0 && ((1L << (_la - 257)) & ((1L << (BIT - 257)) | (1L << (VARBIT - 257)) | (1L << (INT1 - 257)) | (1L << (INT2 - 257)) | (1L << (INT4 - 257)) | (1L << (INT8 - 257)) | (1L << (TINYINT - 257)) | (1L << (SMALLINT - 257)) | (1L << (INT - 257)) | (1L << (INTEGER - 257)) | (1L << (BIGINT - 257)) | (1L << (FLOAT4 - 257)) | (1L << (FLOAT8 - 257)) | (1L << (REAL - 257)) | (1L << (FLOAT - 257)) | (1L << (DOUBLE - 257)) | (1L << (NUMERIC - 257)) | (1L << (DECIMAL - 257)) | (1L << (CHAR - 257)) | (1L << (VARCHAR - 257)) | (1L << (NCHAR - 257)) | (1L << (NVARCHAR - 257)) | (1L << (DATE - 257)) | (1L << (TIME - 257)) | (1L << (TIMETZ - 257)) | (1L << (TIMESTAMP - 257)) | (1L << (TIMESTAMPTZ - 257)) | (1L << (TEXT - 257)) | (1L << (VARBINARY - 257)) | (1L << (BLOB - 257)) | (1L << (BYTEA - 257)) | (1L << (INET4 - 257)) | (1L << (QUOTE - 257)))) != 0) || _la==Identifier );
					setState(1864); match(RIGHT_PAREN);
					}
				}

				setState(1868); storage_parameter_oid();
				setState(1869); on_commit();
				setState(1870); table_space();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1872); match(CREATE);
				setState(1878);
				switch (_input.LA(1)) {
				case GLOBAL:
				case LOCAL:
				case TEMP:
				case TEMPORARY:
					{
					setState(1874);
					_la = _input.LA(1);
					if (_la==GLOBAL || _la==LOCAL) {
						{
						setState(1873);
						_la = _input.LA(1);
						if ( !(_la==GLOBAL || _la==LOCAL) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
					}

					setState(1876);
					_la = _input.LA(1);
					if ( !(_la==TEMP || _la==TEMPORARY) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
					break;
				case UNLOGGED:
					{
					setState(1877); match(UNLOGGED);
					}
					break;
				case TABLE:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1880); match(TABLE);
				setState(1884);
				_la = _input.LA(1);
				if (_la==IF) {
					{
					setState(1881); match(IF);
					setState(1882); match(NOT);
					setState(1883); match(EXISTS);
					}
				}

				setState(1886); ((Create_table_statementContext)_localctx).n = schema_qualified_name();
				setState(1887); match(OF);
				setState(1888); ((Create_table_statementContext)_localctx).type_name = identifier();
				setState(1911);
				switch ( getInterpreter().adaptivePredict(_input,269,_ctx) ) {
				case 1:
					{
					setState(1889); match(LEFT_PAREN);
					setState(1905); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1900);
						switch ( getInterpreter().adaptivePredict(_input,266,_ctx) ) {
						case 1:
							{
							{
							setState(1890); ((Create_table_statementContext)_localctx).column_name = identifier();
							setState(1891); match(WITH);
							setState(1892); match(OPTIONS);
							setState(1896);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,265,_ctx);
							while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
								if ( _alt==1 ) {
									{
									{
									setState(1893); ((Create_table_statementContext)_localctx).col_constraint = column_constraint();
									}
									} 
								}
								setState(1898);
								_errHandler.sync(this);
								_alt = getInterpreter().adaptivePredict(_input,265,_ctx);
							}
							}
							}
							break;
						case 2:
							{
							setState(1899); table_constraint();
							}
							break;
						}
						setState(1903);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1902); match(COMMA);
							}
						}

						}
						}
						setState(1907); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CONSTRAINT) | (1L << EXCLUDE) | (1L << FOREIGN))) != 0) || ((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & ((1L << (PRIMARY - 86)) | (1L << (UNIQUE - 86)) | (1L << (ADMIN - 86)) | (1L << (AVG - 86)) | (1L << (BETWEEN - 86)) | (1L << (BY - 86)) | (1L << (CACHE - 86)) | (1L << (CALLED - 86)) | (1L << (CLASS - 86)) | (1L << (CENTURY - 86)) | (1L << (CHARACTER - 86)) | (1L << (CHECK - 86)) | (1L << (COLLECT - 86)) | (1L << (COALESCE - 86)) | (1L << (COLUMN - 86)) | (1L << (COMMENT - 86)) | (1L << (COMMENTS - 86)) | (1L << (COMMIT - 86)) | (1L << (CONFIGURATION - 86)) | (1L << (COST - 86)) | (1L << (COUNT - 86)) | (1L << (CUBE - 86)) | (1L << (CURRENT - 86)))) != 0) || ((((_la - 150)) & ~0x3f) == 0 && ((1L << (_la - 150)) & ((1L << (CYCLE - 150)) | (1L << (DATA - 150)) | (1L << (DAY - 150)) | (1L << (DEC - 150)) | (1L << (DECADE - 150)) | (1L << (DEFINER - 150)) | (1L << (DICTIONARY - 150)) | (1L << (DOW - 150)) | (1L << (DOY - 150)) | (1L << (DROP - 150)) | (1L << (EPOCH - 150)) | (1L << (EVERY - 150)) | (1L << (EXISTS - 150)) | (1L << (EXTERNAL - 150)) | (1L << (EXTRACT - 150)) | (1L << (FAMILY - 150)) | (1L << (FILTER - 150)) | (1L << (FIRST - 150)) | (1L << (FORMAT - 150)) | (1L << (FUSION - 150)) | (1L << (GROUPING - 150)) | (1L << (HASH - 150)) | (1L << (INDEX - 150)) | (1L << (INCREMENT - 150)) | (1L << (INPUT - 150)) | (1L << (INSERT - 150)) | (1L << (INTERSECTION - 150)) | (1L << (ISCACHABLE - 150)) | (1L << (ISODOW - 150)) | (1L << (ISOYEAR - 150)) | (1L << (ISSTRICT - 150)) | (1L << (LANGUAGE - 150)) | (1L << (LARGE - 150)) | (1L << (LAST - 150)) | (1L << (LESS - 150)) | (1L << (LIST - 150)) | (1L << (LOCATION - 150)) | (1L << (MATCH - 150)) | (1L << (MAX - 150)) | (1L << (MAXVALUE - 150)) | (1L << (MICROSECONDS - 150)) | (1L << (MILLENNIUM - 150)) | (1L << (MILLISECONDS - 150)) | (1L << (MIN - 150)) | (1L << (MINVALUE - 150)) | (1L << (MINUTE - 150)) | (1L << (MONTH - 150)) | (1L << (NATIONAL - 150)) | (1L << (NO - 150)) | (1L << (NONE - 150)) | (1L << (NULLIF - 150)) | (1L << (OBJECT - 150)) | (1L << (OPTION - 150)) | (1L << (OPTIONS - 150)) | (1L << (OVERWRITE - 150)) | (1L << (PARSER - 150)) | (1L << (PARTIAL - 150)) | (1L << (PARTITION - 150)) | (1L << (PARTITIONS - 150)) | (1L << (PRECISION - 150)) | (1L << (PUBLIC - 150)) | (1L << (PURGE - 150)))) != 0) || ((((_la - 214)) & ~0x3f) == 0 && ((1L << (_la - 214)) & ((1L << (QUARTER - 214)) | (1L << (RANGE - 214)) | (1L << (REGEXP - 214)) | (1L << (RLIKE - 214)) | (1L << (ROLLUP - 214)) | (1L << (SEARCH - 214)) | (1L << (SECOND - 214)) | (1L << (SECURITY - 214)) | (1L << (SERVER - 214)) | (1L << (SET - 214)) | (1L << (SIMILAR - 214)) | (1L << (SIMPLE - 214)) | (1L << (STABLE - 214)) | (1L << (START - 214)) | (1L << (STORAGE - 214)) | (1L << (STDDEV_POP - 214)) | (1L << (STDDEV_SAMP - 214)) | (1L << (SUBPARTITION - 214)) | (1L << (SUM - 214)) | (1L << (TABLESPACE - 214)) | (1L << (TEMPLATE - 214)) | (1L << (THAN - 214)) | (1L << (TIMEZONE - 214)) | (1L << (TIMEZONE_HOUR - 214)) | (1L << (TIMEZONE_MINUTE - 214)) | (1L << (TRIM - 214)) | (1L << (TO - 214)) | (1L << (UNKNOWN - 214)) | (1L << (UNLOGGED - 214)) | (1L << (VALUES - 214)) | (1L << (VAR_SAMP - 214)) | (1L << (VAR_POP - 214)) | (1L << (VARYING - 214)) | (1L << (VOLATILE - 214)) | (1L << (WEEK - 214)) | (1L << (WINDOW - 214)) | (1L << (WRAPPER - 214)) | (1L << (YEAR - 214)) | (1L << (ZONE - 214)) | (1L << (BOOLEAN - 214)) | (1L << (BOOL - 214)) | (1L << (BIT - 214)) | (1L << (VARBIT - 214)) | (1L << (INT1 - 214)) | (1L << (INT2 - 214)) | (1L << (INT4 - 214)) | (1L << (INT8 - 214)) | (1L << (TINYINT - 214)) | (1L << (SMALLINT - 214)) | (1L << (INT - 214)) | (1L << (INTEGER - 214)) | (1L << (BIGINT - 214)) | (1L << (FLOAT4 - 214)) | (1L << (FLOAT8 - 214)) | (1L << (REAL - 214)) | (1L << (FLOAT - 214)) | (1L << (DOUBLE - 214)) | (1L << (NUMERIC - 214)) | (1L << (DECIMAL - 214)) | (1L << (CHAR - 214)) | (1L << (VARCHAR - 214)))) != 0) || ((((_la - 278)) & ~0x3f) == 0 && ((1L << (_la - 278)) & ((1L << (NCHAR - 278)) | (1L << (NVARCHAR - 278)) | (1L << (DATE - 278)) | (1L << (TIME - 278)) | (1L << (TIMETZ - 278)) | (1L << (TIMESTAMP - 278)) | (1L << (TIMESTAMPTZ - 278)) | (1L << (TEXT - 278)) | (1L << (VARBINARY - 278)) | (1L << (BLOB - 278)) | (1L << (BYTEA - 278)) | (1L << (INET4 - 278)) | (1L << (QUOTE - 278)) | (1L << (Identifier - 278)))) != 0) );
					setState(1909); match(RIGHT_PAREN);
					}
					break;
				}
				setState(1913); storage_parameter_oid();
				setState(1914); on_commit();
				setState(1915); table_space();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 46, RULE_like_option);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1919);
			_la = _input.LA(1);
			if ( !(_la==EXCLUDING || _la==INCLUDING) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(1920);
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
		enterRule(_localctx, 48, RULE_table_constraint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1924);
			_la = _input.LA(1);
			if (_la==CONSTRAINT) {
				{
				setState(1922); match(CONSTRAINT);
				setState(1923); ((Table_constraintContext)_localctx).constraint_name = identifier();
				}
			}

			setState(2024);
			switch (_input.LA(1)) {
			case CHECK:
				{
				setState(1926); check_boolean_expression();
				}
				break;
			case UNIQUE:
				{
				{
				setState(1927); match(UNIQUE);
				setState(1928); match(LEFT_PAREN);
				setState(1933); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1929); ((Table_constraintContext)_localctx).column_name_unique = identifier();
					setState(1931);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1930); match(COMMA);
						}
					}

					}
					}
					setState(1935); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (ADMIN - 129)) | (1L << (AVG - 129)) | (1L << (BETWEEN - 129)) | (1L << (BY - 129)) | (1L << (CACHE - 129)) | (1L << (CALLED - 129)) | (1L << (CLASS - 129)) | (1L << (CENTURY - 129)) | (1L << (CHARACTER - 129)) | (1L << (CHECK - 129)) | (1L << (COLLECT - 129)) | (1L << (COALESCE - 129)) | (1L << (COLUMN - 129)) | (1L << (COMMENT - 129)) | (1L << (COMMENTS - 129)) | (1L << (COMMIT - 129)) | (1L << (CONFIGURATION - 129)) | (1L << (COST - 129)) | (1L << (COUNT - 129)) | (1L << (CUBE - 129)) | (1L << (CURRENT - 129)) | (1L << (CYCLE - 129)) | (1L << (DATA - 129)) | (1L << (DAY - 129)) | (1L << (DEC - 129)) | (1L << (DECADE - 129)) | (1L << (DEFINER - 129)) | (1L << (DICTIONARY - 129)) | (1L << (DOW - 129)) | (1L << (DOY - 129)) | (1L << (DROP - 129)) | (1L << (EPOCH - 129)) | (1L << (EVERY - 129)) | (1L << (EXISTS - 129)) | (1L << (EXTERNAL - 129)) | (1L << (EXTRACT - 129)) | (1L << (FAMILY - 129)) | (1L << (FILTER - 129)) | (1L << (FIRST - 129)) | (1L << (FORMAT - 129)) | (1L << (FUSION - 129)) | (1L << (GROUPING - 129)) | (1L << (HASH - 129)) | (1L << (INDEX - 129)) | (1L << (INCREMENT - 129)) | (1L << (INPUT - 129)) | (1L << (INSERT - 129)) | (1L << (INTERSECTION - 129)) | (1L << (ISCACHABLE - 129)) | (1L << (ISODOW - 129)) | (1L << (ISOYEAR - 129)) | (1L << (ISSTRICT - 129)) | (1L << (LANGUAGE - 129)) | (1L << (LARGE - 129)) | (1L << (LAST - 129)) | (1L << (LESS - 129)) | (1L << (LIST - 129)) | (1L << (LOCATION - 129)) | (1L << (MATCH - 129)) | (1L << (MAX - 129)) | (1L << (MAXVALUE - 129)) | (1L << (MICROSECONDS - 129)))) != 0) || ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & ((1L << (MILLENNIUM - 193)) | (1L << (MILLISECONDS - 193)) | (1L << (MIN - 193)) | (1L << (MINVALUE - 193)) | (1L << (MINUTE - 193)) | (1L << (MONTH - 193)) | (1L << (NATIONAL - 193)) | (1L << (NO - 193)) | (1L << (NONE - 193)) | (1L << (NULLIF - 193)) | (1L << (OBJECT - 193)) | (1L << (OPTION - 193)) | (1L << (OPTIONS - 193)) | (1L << (OVERWRITE - 193)) | (1L << (PARSER - 193)) | (1L << (PARTIAL - 193)) | (1L << (PARTITION - 193)) | (1L << (PARTITIONS - 193)) | (1L << (PRECISION - 193)) | (1L << (PUBLIC - 193)) | (1L << (PURGE - 193)) | (1L << (QUARTER - 193)) | (1L << (RANGE - 193)) | (1L << (REGEXP - 193)) | (1L << (RLIKE - 193)) | (1L << (ROLLUP - 193)) | (1L << (SEARCH - 193)) | (1L << (SECOND - 193)) | (1L << (SECURITY - 193)) | (1L << (SERVER - 193)) | (1L << (SET - 193)) | (1L << (SIMILAR - 193)) | (1L << (SIMPLE - 193)) | (1L << (STABLE - 193)) | (1L << (START - 193)) | (1L << (STORAGE - 193)) | (1L << (STDDEV_POP - 193)) | (1L << (STDDEV_SAMP - 193)) | (1L << (SUBPARTITION - 193)) | (1L << (SUM - 193)) | (1L << (TABLESPACE - 193)) | (1L << (TEMPLATE - 193)) | (1L << (THAN - 193)) | (1L << (TIMEZONE - 193)) | (1L << (TIMEZONE_HOUR - 193)) | (1L << (TIMEZONE_MINUTE - 193)) | (1L << (TRIM - 193)) | (1L << (TO - 193)) | (1L << (UNKNOWN - 193)) | (1L << (UNLOGGED - 193)) | (1L << (VALUES - 193)) | (1L << (VAR_SAMP - 193)) | (1L << (VAR_POP - 193)) | (1L << (VARYING - 193)) | (1L << (VOLATILE - 193)) | (1L << (WEEK - 193)) | (1L << (WINDOW - 193)) | (1L << (WRAPPER - 193)) | (1L << (YEAR - 193)) | (1L << (ZONE - 193)) | (1L << (BOOLEAN - 193)) | (1L << (BOOL - 193)))) != 0) || ((((_la - 257)) & ~0x3f) == 0 && ((1L << (_la - 257)) & ((1L << (BIT - 257)) | (1L << (VARBIT - 257)) | (1L << (INT1 - 257)) | (1L << (INT2 - 257)) | (1L << (INT4 - 257)) | (1L << (INT8 - 257)) | (1L << (TINYINT - 257)) | (1L << (SMALLINT - 257)) | (1L << (INT - 257)) | (1L << (INTEGER - 257)) | (1L << (BIGINT - 257)) | (1L << (FLOAT4 - 257)) | (1L << (FLOAT8 - 257)) | (1L << (REAL - 257)) | (1L << (FLOAT - 257)) | (1L << (DOUBLE - 257)) | (1L << (NUMERIC - 257)) | (1L << (DECIMAL - 257)) | (1L << (CHAR - 257)) | (1L << (VARCHAR - 257)) | (1L << (NCHAR - 257)) | (1L << (NVARCHAR - 257)) | (1L << (DATE - 257)) | (1L << (TIME - 257)) | (1L << (TIMETZ - 257)) | (1L << (TIMESTAMP - 257)) | (1L << (TIMESTAMPTZ - 257)) | (1L << (TEXT - 257)) | (1L << (VARBINARY - 257)) | (1L << (BLOB - 257)) | (1L << (BYTEA - 257)) | (1L << (INET4 - 257)) | (1L << (QUOTE - 257)))) != 0) || _la==Identifier );
				setState(1937); match(RIGHT_PAREN);
				setState(1938); ((Table_constraintContext)_localctx).index_parameters_unique = index_parameters();
				}
				}
				break;
			case PRIMARY:
				{
				{
				setState(1940); match(PRIMARY);
				setState(1941); match(KEY);
				setState(1942); match(LEFT_PAREN);
				setState(1947); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1943); ((Table_constraintContext)_localctx).column_name_pr_key = identifier();
					setState(1945);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1944); match(COMMA);
						}
					}

					}
					}
					setState(1949); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (ADMIN - 129)) | (1L << (AVG - 129)) | (1L << (BETWEEN - 129)) | (1L << (BY - 129)) | (1L << (CACHE - 129)) | (1L << (CALLED - 129)) | (1L << (CLASS - 129)) | (1L << (CENTURY - 129)) | (1L << (CHARACTER - 129)) | (1L << (CHECK - 129)) | (1L << (COLLECT - 129)) | (1L << (COALESCE - 129)) | (1L << (COLUMN - 129)) | (1L << (COMMENT - 129)) | (1L << (COMMENTS - 129)) | (1L << (COMMIT - 129)) | (1L << (CONFIGURATION - 129)) | (1L << (COST - 129)) | (1L << (COUNT - 129)) | (1L << (CUBE - 129)) | (1L << (CURRENT - 129)) | (1L << (CYCLE - 129)) | (1L << (DATA - 129)) | (1L << (DAY - 129)) | (1L << (DEC - 129)) | (1L << (DECADE - 129)) | (1L << (DEFINER - 129)) | (1L << (DICTIONARY - 129)) | (1L << (DOW - 129)) | (1L << (DOY - 129)) | (1L << (DROP - 129)) | (1L << (EPOCH - 129)) | (1L << (EVERY - 129)) | (1L << (EXISTS - 129)) | (1L << (EXTERNAL - 129)) | (1L << (EXTRACT - 129)) | (1L << (FAMILY - 129)) | (1L << (FILTER - 129)) | (1L << (FIRST - 129)) | (1L << (FORMAT - 129)) | (1L << (FUSION - 129)) | (1L << (GROUPING - 129)) | (1L << (HASH - 129)) | (1L << (INDEX - 129)) | (1L << (INCREMENT - 129)) | (1L << (INPUT - 129)) | (1L << (INSERT - 129)) | (1L << (INTERSECTION - 129)) | (1L << (ISCACHABLE - 129)) | (1L << (ISODOW - 129)) | (1L << (ISOYEAR - 129)) | (1L << (ISSTRICT - 129)) | (1L << (LANGUAGE - 129)) | (1L << (LARGE - 129)) | (1L << (LAST - 129)) | (1L << (LESS - 129)) | (1L << (LIST - 129)) | (1L << (LOCATION - 129)) | (1L << (MATCH - 129)) | (1L << (MAX - 129)) | (1L << (MAXVALUE - 129)) | (1L << (MICROSECONDS - 129)))) != 0) || ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & ((1L << (MILLENNIUM - 193)) | (1L << (MILLISECONDS - 193)) | (1L << (MIN - 193)) | (1L << (MINVALUE - 193)) | (1L << (MINUTE - 193)) | (1L << (MONTH - 193)) | (1L << (NATIONAL - 193)) | (1L << (NO - 193)) | (1L << (NONE - 193)) | (1L << (NULLIF - 193)) | (1L << (OBJECT - 193)) | (1L << (OPTION - 193)) | (1L << (OPTIONS - 193)) | (1L << (OVERWRITE - 193)) | (1L << (PARSER - 193)) | (1L << (PARTIAL - 193)) | (1L << (PARTITION - 193)) | (1L << (PARTITIONS - 193)) | (1L << (PRECISION - 193)) | (1L << (PUBLIC - 193)) | (1L << (PURGE - 193)) | (1L << (QUARTER - 193)) | (1L << (RANGE - 193)) | (1L << (REGEXP - 193)) | (1L << (RLIKE - 193)) | (1L << (ROLLUP - 193)) | (1L << (SEARCH - 193)) | (1L << (SECOND - 193)) | (1L << (SECURITY - 193)) | (1L << (SERVER - 193)) | (1L << (SET - 193)) | (1L << (SIMILAR - 193)) | (1L << (SIMPLE - 193)) | (1L << (STABLE - 193)) | (1L << (START - 193)) | (1L << (STORAGE - 193)) | (1L << (STDDEV_POP - 193)) | (1L << (STDDEV_SAMP - 193)) | (1L << (SUBPARTITION - 193)) | (1L << (SUM - 193)) | (1L << (TABLESPACE - 193)) | (1L << (TEMPLATE - 193)) | (1L << (THAN - 193)) | (1L << (TIMEZONE - 193)) | (1L << (TIMEZONE_HOUR - 193)) | (1L << (TIMEZONE_MINUTE - 193)) | (1L << (TRIM - 193)) | (1L << (TO - 193)) | (1L << (UNKNOWN - 193)) | (1L << (UNLOGGED - 193)) | (1L << (VALUES - 193)) | (1L << (VAR_SAMP - 193)) | (1L << (VAR_POP - 193)) | (1L << (VARYING - 193)) | (1L << (VOLATILE - 193)) | (1L << (WEEK - 193)) | (1L << (WINDOW - 193)) | (1L << (WRAPPER - 193)) | (1L << (YEAR - 193)) | (1L << (ZONE - 193)) | (1L << (BOOLEAN - 193)) | (1L << (BOOL - 193)))) != 0) || ((((_la - 257)) & ~0x3f) == 0 && ((1L << (_la - 257)) & ((1L << (BIT - 257)) | (1L << (VARBIT - 257)) | (1L << (INT1 - 257)) | (1L << (INT2 - 257)) | (1L << (INT4 - 257)) | (1L << (INT8 - 257)) | (1L << (TINYINT - 257)) | (1L << (SMALLINT - 257)) | (1L << (INT - 257)) | (1L << (INTEGER - 257)) | (1L << (BIGINT - 257)) | (1L << (FLOAT4 - 257)) | (1L << (FLOAT8 - 257)) | (1L << (REAL - 257)) | (1L << (FLOAT - 257)) | (1L << (DOUBLE - 257)) | (1L << (NUMERIC - 257)) | (1L << (DECIMAL - 257)) | (1L << (CHAR - 257)) | (1L << (VARCHAR - 257)) | (1L << (NCHAR - 257)) | (1L << (NVARCHAR - 257)) | (1L << (DATE - 257)) | (1L << (TIME - 257)) | (1L << (TIMETZ - 257)) | (1L << (TIMESTAMP - 257)) | (1L << (TIMESTAMPTZ - 257)) | (1L << (TEXT - 257)) | (1L << (VARBINARY - 257)) | (1L << (BLOB - 257)) | (1L << (BYTEA - 257)) | (1L << (INET4 - 257)) | (1L << (QUOTE - 257)))) != 0) || _la==Identifier );
				setState(1951); match(RIGHT_PAREN);
				setState(1952); ((Table_constraintContext)_localctx).index_parameters_pr_key = index_parameters();
				}
				}
				break;
			case EXCLUDE:
				{
				{
				setState(1954); match(EXCLUDE);
				setState(1957);
				_la = _input.LA(1);
				if (_la==USING) {
					{
					setState(1955); match(USING);
					setState(1956); ((Table_constraintContext)_localctx).index_method = identifier();
					}
				}

				setState(1959); match(LEFT_PAREN);
				setState(1960); ((Table_constraintContext)_localctx).exclude_element = identifier();
				setState(1961); match(WITH);
				setState(1966); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1962); ((Table_constraintContext)_localctx).operator = identifier();
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
				} while ( ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (ADMIN - 129)) | (1L << (AVG - 129)) | (1L << (BETWEEN - 129)) | (1L << (BY - 129)) | (1L << (CACHE - 129)) | (1L << (CALLED - 129)) | (1L << (CLASS - 129)) | (1L << (CENTURY - 129)) | (1L << (CHARACTER - 129)) | (1L << (CHECK - 129)) | (1L << (COLLECT - 129)) | (1L << (COALESCE - 129)) | (1L << (COLUMN - 129)) | (1L << (COMMENT - 129)) | (1L << (COMMENTS - 129)) | (1L << (COMMIT - 129)) | (1L << (CONFIGURATION - 129)) | (1L << (COST - 129)) | (1L << (COUNT - 129)) | (1L << (CUBE - 129)) | (1L << (CURRENT - 129)) | (1L << (CYCLE - 129)) | (1L << (DATA - 129)) | (1L << (DAY - 129)) | (1L << (DEC - 129)) | (1L << (DECADE - 129)) | (1L << (DEFINER - 129)) | (1L << (DICTIONARY - 129)) | (1L << (DOW - 129)) | (1L << (DOY - 129)) | (1L << (DROP - 129)) | (1L << (EPOCH - 129)) | (1L << (EVERY - 129)) | (1L << (EXISTS - 129)) | (1L << (EXTERNAL - 129)) | (1L << (EXTRACT - 129)) | (1L << (FAMILY - 129)) | (1L << (FILTER - 129)) | (1L << (FIRST - 129)) | (1L << (FORMAT - 129)) | (1L << (FUSION - 129)) | (1L << (GROUPING - 129)) | (1L << (HASH - 129)) | (1L << (INDEX - 129)) | (1L << (INCREMENT - 129)) | (1L << (INPUT - 129)) | (1L << (INSERT - 129)) | (1L << (INTERSECTION - 129)) | (1L << (ISCACHABLE - 129)) | (1L << (ISODOW - 129)) | (1L << (ISOYEAR - 129)) | (1L << (ISSTRICT - 129)) | (1L << (LANGUAGE - 129)) | (1L << (LARGE - 129)) | (1L << (LAST - 129)) | (1L << (LESS - 129)) | (1L << (LIST - 129)) | (1L << (LOCATION - 129)) | (1L << (MATCH - 129)) | (1L << (MAX - 129)) | (1L << (MAXVALUE - 129)) | (1L << (MICROSECONDS - 129)))) != 0) || ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & ((1L << (MILLENNIUM - 193)) | (1L << (MILLISECONDS - 193)) | (1L << (MIN - 193)) | (1L << (MINVALUE - 193)) | (1L << (MINUTE - 193)) | (1L << (MONTH - 193)) | (1L << (NATIONAL - 193)) | (1L << (NO - 193)) | (1L << (NONE - 193)) | (1L << (NULLIF - 193)) | (1L << (OBJECT - 193)) | (1L << (OPTION - 193)) | (1L << (OPTIONS - 193)) | (1L << (OVERWRITE - 193)) | (1L << (PARSER - 193)) | (1L << (PARTIAL - 193)) | (1L << (PARTITION - 193)) | (1L << (PARTITIONS - 193)) | (1L << (PRECISION - 193)) | (1L << (PUBLIC - 193)) | (1L << (PURGE - 193)) | (1L << (QUARTER - 193)) | (1L << (RANGE - 193)) | (1L << (REGEXP - 193)) | (1L << (RLIKE - 193)) | (1L << (ROLLUP - 193)) | (1L << (SEARCH - 193)) | (1L << (SECOND - 193)) | (1L << (SECURITY - 193)) | (1L << (SERVER - 193)) | (1L << (SET - 193)) | (1L << (SIMILAR - 193)) | (1L << (SIMPLE - 193)) | (1L << (STABLE - 193)) | (1L << (START - 193)) | (1L << (STORAGE - 193)) | (1L << (STDDEV_POP - 193)) | (1L << (STDDEV_SAMP - 193)) | (1L << (SUBPARTITION - 193)) | (1L << (SUM - 193)) | (1L << (TABLESPACE - 193)) | (1L << (TEMPLATE - 193)) | (1L << (THAN - 193)) | (1L << (TIMEZONE - 193)) | (1L << (TIMEZONE_HOUR - 193)) | (1L << (TIMEZONE_MINUTE - 193)) | (1L << (TRIM - 193)) | (1L << (TO - 193)) | (1L << (UNKNOWN - 193)) | (1L << (UNLOGGED - 193)) | (1L << (VALUES - 193)) | (1L << (VAR_SAMP - 193)) | (1L << (VAR_POP - 193)) | (1L << (VARYING - 193)) | (1L << (VOLATILE - 193)) | (1L << (WEEK - 193)) | (1L << (WINDOW - 193)) | (1L << (WRAPPER - 193)) | (1L << (YEAR - 193)) | (1L << (ZONE - 193)) | (1L << (BOOLEAN - 193)) | (1L << (BOOL - 193)))) != 0) || ((((_la - 257)) & ~0x3f) == 0 && ((1L << (_la - 257)) & ((1L << (BIT - 257)) | (1L << (VARBIT - 257)) | (1L << (INT1 - 257)) | (1L << (INT2 - 257)) | (1L << (INT4 - 257)) | (1L << (INT8 - 257)) | (1L << (TINYINT - 257)) | (1L << (SMALLINT - 257)) | (1L << (INT - 257)) | (1L << (INTEGER - 257)) | (1L << (BIGINT - 257)) | (1L << (FLOAT4 - 257)) | (1L << (FLOAT8 - 257)) | (1L << (REAL - 257)) | (1L << (FLOAT - 257)) | (1L << (DOUBLE - 257)) | (1L << (NUMERIC - 257)) | (1L << (DECIMAL - 257)) | (1L << (CHAR - 257)) | (1L << (VARCHAR - 257)) | (1L << (NCHAR - 257)) | (1L << (NVARCHAR - 257)) | (1L << (DATE - 257)) | (1L << (TIME - 257)) | (1L << (TIMETZ - 257)) | (1L << (TIMESTAMP - 257)) | (1L << (TIMESTAMPTZ - 257)) | (1L << (TEXT - 257)) | (1L << (VARBINARY - 257)) | (1L << (BLOB - 257)) | (1L << (BYTEA - 257)) | (1L << (INET4 - 257)) | (1L << (QUOTE - 257)))) != 0) || _la==Identifier );
				setState(1970); match(RIGHT_PAREN);
				setState(1971); index_parameters();
				setState(1977);
				_la = _input.LA(1);
				if (_la==WHERE) {
					{
					setState(1972); match(WHERE);
					setState(1973); match(LEFT_PAREN);
					setState(1974); ((Table_constraintContext)_localctx).predicat = identifier();
					setState(1975); match(RIGHT_PAREN);
					}
				}

				}
				}
				break;
			case FOREIGN:
				{
				{
				setState(1979); match(FOREIGN);
				setState(1980); match(KEY);
				setState(1981); match(LEFT_PAREN);
				setState(1986); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1982); ((Table_constraintContext)_localctx).column_name_for_key = identifier();
					setState(1984);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1983); match(COMMA);
						}
					}

					}
					}
					setState(1988); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (ADMIN - 129)) | (1L << (AVG - 129)) | (1L << (BETWEEN - 129)) | (1L << (BY - 129)) | (1L << (CACHE - 129)) | (1L << (CALLED - 129)) | (1L << (CLASS - 129)) | (1L << (CENTURY - 129)) | (1L << (CHARACTER - 129)) | (1L << (CHECK - 129)) | (1L << (COLLECT - 129)) | (1L << (COALESCE - 129)) | (1L << (COLUMN - 129)) | (1L << (COMMENT - 129)) | (1L << (COMMENTS - 129)) | (1L << (COMMIT - 129)) | (1L << (CONFIGURATION - 129)) | (1L << (COST - 129)) | (1L << (COUNT - 129)) | (1L << (CUBE - 129)) | (1L << (CURRENT - 129)) | (1L << (CYCLE - 129)) | (1L << (DATA - 129)) | (1L << (DAY - 129)) | (1L << (DEC - 129)) | (1L << (DECADE - 129)) | (1L << (DEFINER - 129)) | (1L << (DICTIONARY - 129)) | (1L << (DOW - 129)) | (1L << (DOY - 129)) | (1L << (DROP - 129)) | (1L << (EPOCH - 129)) | (1L << (EVERY - 129)) | (1L << (EXISTS - 129)) | (1L << (EXTERNAL - 129)) | (1L << (EXTRACT - 129)) | (1L << (FAMILY - 129)) | (1L << (FILTER - 129)) | (1L << (FIRST - 129)) | (1L << (FORMAT - 129)) | (1L << (FUSION - 129)) | (1L << (GROUPING - 129)) | (1L << (HASH - 129)) | (1L << (INDEX - 129)) | (1L << (INCREMENT - 129)) | (1L << (INPUT - 129)) | (1L << (INSERT - 129)) | (1L << (INTERSECTION - 129)) | (1L << (ISCACHABLE - 129)) | (1L << (ISODOW - 129)) | (1L << (ISOYEAR - 129)) | (1L << (ISSTRICT - 129)) | (1L << (LANGUAGE - 129)) | (1L << (LARGE - 129)) | (1L << (LAST - 129)) | (1L << (LESS - 129)) | (1L << (LIST - 129)) | (1L << (LOCATION - 129)) | (1L << (MATCH - 129)) | (1L << (MAX - 129)) | (1L << (MAXVALUE - 129)) | (1L << (MICROSECONDS - 129)))) != 0) || ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & ((1L << (MILLENNIUM - 193)) | (1L << (MILLISECONDS - 193)) | (1L << (MIN - 193)) | (1L << (MINVALUE - 193)) | (1L << (MINUTE - 193)) | (1L << (MONTH - 193)) | (1L << (NATIONAL - 193)) | (1L << (NO - 193)) | (1L << (NONE - 193)) | (1L << (NULLIF - 193)) | (1L << (OBJECT - 193)) | (1L << (OPTION - 193)) | (1L << (OPTIONS - 193)) | (1L << (OVERWRITE - 193)) | (1L << (PARSER - 193)) | (1L << (PARTIAL - 193)) | (1L << (PARTITION - 193)) | (1L << (PARTITIONS - 193)) | (1L << (PRECISION - 193)) | (1L << (PUBLIC - 193)) | (1L << (PURGE - 193)) | (1L << (QUARTER - 193)) | (1L << (RANGE - 193)) | (1L << (REGEXP - 193)) | (1L << (RLIKE - 193)) | (1L << (ROLLUP - 193)) | (1L << (SEARCH - 193)) | (1L << (SECOND - 193)) | (1L << (SECURITY - 193)) | (1L << (SERVER - 193)) | (1L << (SET - 193)) | (1L << (SIMILAR - 193)) | (1L << (SIMPLE - 193)) | (1L << (STABLE - 193)) | (1L << (START - 193)) | (1L << (STORAGE - 193)) | (1L << (STDDEV_POP - 193)) | (1L << (STDDEV_SAMP - 193)) | (1L << (SUBPARTITION - 193)) | (1L << (SUM - 193)) | (1L << (TABLESPACE - 193)) | (1L << (TEMPLATE - 193)) | (1L << (THAN - 193)) | (1L << (TIMEZONE - 193)) | (1L << (TIMEZONE_HOUR - 193)) | (1L << (TIMEZONE_MINUTE - 193)) | (1L << (TRIM - 193)) | (1L << (TO - 193)) | (1L << (UNKNOWN - 193)) | (1L << (UNLOGGED - 193)) | (1L << (VALUES - 193)) | (1L << (VAR_SAMP - 193)) | (1L << (VAR_POP - 193)) | (1L << (VARYING - 193)) | (1L << (VOLATILE - 193)) | (1L << (WEEK - 193)) | (1L << (WINDOW - 193)) | (1L << (WRAPPER - 193)) | (1L << (YEAR - 193)) | (1L << (ZONE - 193)) | (1L << (BOOLEAN - 193)) | (1L << (BOOL - 193)))) != 0) || ((((_la - 257)) & ~0x3f) == 0 && ((1L << (_la - 257)) & ((1L << (BIT - 257)) | (1L << (VARBIT - 257)) | (1L << (INT1 - 257)) | (1L << (INT2 - 257)) | (1L << (INT4 - 257)) | (1L << (INT8 - 257)) | (1L << (TINYINT - 257)) | (1L << (SMALLINT - 257)) | (1L << (INT - 257)) | (1L << (INTEGER - 257)) | (1L << (BIGINT - 257)) | (1L << (FLOAT4 - 257)) | (1L << (FLOAT8 - 257)) | (1L << (REAL - 257)) | (1L << (FLOAT - 257)) | (1L << (DOUBLE - 257)) | (1L << (NUMERIC - 257)) | (1L << (DECIMAL - 257)) | (1L << (CHAR - 257)) | (1L << (VARCHAR - 257)) | (1L << (NCHAR - 257)) | (1L << (NVARCHAR - 257)) | (1L << (DATE - 257)) | (1L << (TIME - 257)) | (1L << (TIMETZ - 257)) | (1L << (TIMESTAMP - 257)) | (1L << (TIMESTAMPTZ - 257)) | (1L << (TEXT - 257)) | (1L << (VARBINARY - 257)) | (1L << (BLOB - 257)) | (1L << (BYTEA - 257)) | (1L << (INET4 - 257)) | (1L << (QUOTE - 257)))) != 0) || _la==Identifier );
				setState(1990); match(RIGHT_PAREN);
				setState(1991); match(REFERENCES);
				setState(1992); ((Table_constraintContext)_localctx).reftable = identifier();
				setState(2004);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(1993); match(LEFT_PAREN);
					setState(1998); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1994); ((Table_constraintContext)_localctx).refcolumn = identifier();
						setState(1996);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1995); match(COMMA);
							}
						}

						}
						}
						setState(2000); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (ADMIN - 129)) | (1L << (AVG - 129)) | (1L << (BETWEEN - 129)) | (1L << (BY - 129)) | (1L << (CACHE - 129)) | (1L << (CALLED - 129)) | (1L << (CLASS - 129)) | (1L << (CENTURY - 129)) | (1L << (CHARACTER - 129)) | (1L << (CHECK - 129)) | (1L << (COLLECT - 129)) | (1L << (COALESCE - 129)) | (1L << (COLUMN - 129)) | (1L << (COMMENT - 129)) | (1L << (COMMENTS - 129)) | (1L << (COMMIT - 129)) | (1L << (CONFIGURATION - 129)) | (1L << (COST - 129)) | (1L << (COUNT - 129)) | (1L << (CUBE - 129)) | (1L << (CURRENT - 129)) | (1L << (CYCLE - 129)) | (1L << (DATA - 129)) | (1L << (DAY - 129)) | (1L << (DEC - 129)) | (1L << (DECADE - 129)) | (1L << (DEFINER - 129)) | (1L << (DICTIONARY - 129)) | (1L << (DOW - 129)) | (1L << (DOY - 129)) | (1L << (DROP - 129)) | (1L << (EPOCH - 129)) | (1L << (EVERY - 129)) | (1L << (EXISTS - 129)) | (1L << (EXTERNAL - 129)) | (1L << (EXTRACT - 129)) | (1L << (FAMILY - 129)) | (1L << (FILTER - 129)) | (1L << (FIRST - 129)) | (1L << (FORMAT - 129)) | (1L << (FUSION - 129)) | (1L << (GROUPING - 129)) | (1L << (HASH - 129)) | (1L << (INDEX - 129)) | (1L << (INCREMENT - 129)) | (1L << (INPUT - 129)) | (1L << (INSERT - 129)) | (1L << (INTERSECTION - 129)) | (1L << (ISCACHABLE - 129)) | (1L << (ISODOW - 129)) | (1L << (ISOYEAR - 129)) | (1L << (ISSTRICT - 129)) | (1L << (LANGUAGE - 129)) | (1L << (LARGE - 129)) | (1L << (LAST - 129)) | (1L << (LESS - 129)) | (1L << (LIST - 129)) | (1L << (LOCATION - 129)) | (1L << (MATCH - 129)) | (1L << (MAX - 129)) | (1L << (MAXVALUE - 129)) | (1L << (MICROSECONDS - 129)))) != 0) || ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & ((1L << (MILLENNIUM - 193)) | (1L << (MILLISECONDS - 193)) | (1L << (MIN - 193)) | (1L << (MINVALUE - 193)) | (1L << (MINUTE - 193)) | (1L << (MONTH - 193)) | (1L << (NATIONAL - 193)) | (1L << (NO - 193)) | (1L << (NONE - 193)) | (1L << (NULLIF - 193)) | (1L << (OBJECT - 193)) | (1L << (OPTION - 193)) | (1L << (OPTIONS - 193)) | (1L << (OVERWRITE - 193)) | (1L << (PARSER - 193)) | (1L << (PARTIAL - 193)) | (1L << (PARTITION - 193)) | (1L << (PARTITIONS - 193)) | (1L << (PRECISION - 193)) | (1L << (PUBLIC - 193)) | (1L << (PURGE - 193)) | (1L << (QUARTER - 193)) | (1L << (RANGE - 193)) | (1L << (REGEXP - 193)) | (1L << (RLIKE - 193)) | (1L << (ROLLUP - 193)) | (1L << (SEARCH - 193)) | (1L << (SECOND - 193)) | (1L << (SECURITY - 193)) | (1L << (SERVER - 193)) | (1L << (SET - 193)) | (1L << (SIMILAR - 193)) | (1L << (SIMPLE - 193)) | (1L << (STABLE - 193)) | (1L << (START - 193)) | (1L << (STORAGE - 193)) | (1L << (STDDEV_POP - 193)) | (1L << (STDDEV_SAMP - 193)) | (1L << (SUBPARTITION - 193)) | (1L << (SUM - 193)) | (1L << (TABLESPACE - 193)) | (1L << (TEMPLATE - 193)) | (1L << (THAN - 193)) | (1L << (TIMEZONE - 193)) | (1L << (TIMEZONE_HOUR - 193)) | (1L << (TIMEZONE_MINUTE - 193)) | (1L << (TRIM - 193)) | (1L << (TO - 193)) | (1L << (UNKNOWN - 193)) | (1L << (UNLOGGED - 193)) | (1L << (VALUES - 193)) | (1L << (VAR_SAMP - 193)) | (1L << (VAR_POP - 193)) | (1L << (VARYING - 193)) | (1L << (VOLATILE - 193)) | (1L << (WEEK - 193)) | (1L << (WINDOW - 193)) | (1L << (WRAPPER - 193)) | (1L << (YEAR - 193)) | (1L << (ZONE - 193)) | (1L << (BOOLEAN - 193)) | (1L << (BOOL - 193)))) != 0) || ((((_la - 257)) & ~0x3f) == 0 && ((1L << (_la - 257)) & ((1L << (BIT - 257)) | (1L << (VARBIT - 257)) | (1L << (INT1 - 257)) | (1L << (INT2 - 257)) | (1L << (INT4 - 257)) | (1L << (INT8 - 257)) | (1L << (TINYINT - 257)) | (1L << (SMALLINT - 257)) | (1L << (INT - 257)) | (1L << (INTEGER - 257)) | (1L << (BIGINT - 257)) | (1L << (FLOAT4 - 257)) | (1L << (FLOAT8 - 257)) | (1L << (REAL - 257)) | (1L << (FLOAT - 257)) | (1L << (DOUBLE - 257)) | (1L << (NUMERIC - 257)) | (1L << (DECIMAL - 257)) | (1L << (CHAR - 257)) | (1L << (VARCHAR - 257)) | (1L << (NCHAR - 257)) | (1L << (NVARCHAR - 257)) | (1L << (DATE - 257)) | (1L << (TIME - 257)) | (1L << (TIMETZ - 257)) | (1L << (TIMESTAMP - 257)) | (1L << (TIMESTAMPTZ - 257)) | (1L << (TEXT - 257)) | (1L << (VARBINARY - 257)) | (1L << (BLOB - 257)) | (1L << (BYTEA - 257)) | (1L << (INET4 - 257)) | (1L << (QUOTE - 257)))) != 0) || _la==Identifier );
					setState(2002); match(RIGHT_PAREN);
					}
				}

				setState(2012);
				switch ( getInterpreter().adaptivePredict(_input,285,_ctx) ) {
				case 1:
					{
					{
					setState(2006); match(MATCH);
					setState(2007); match(FULL);
					}
					}
					break;
				case 2:
					{
					{
					setState(2008); match(MATCH);
					setState(2009); match(PARTIAL);
					}
					}
					break;
				case 3:
					{
					{
					setState(2010); match(MATCH);
					setState(2011); match(SIMPLE);
					}
					}
					break;
				}
				setState(2017);
				switch ( getInterpreter().adaptivePredict(_input,286,_ctx) ) {
				case 1:
					{
					setState(2014); match(ON);
					setState(2015); match(DELETE);
					setState(2016); ((Table_constraintContext)_localctx).action_on_delete = action();
					}
					break;
				}
				setState(2022);
				_la = _input.LA(1);
				if (_la==ON) {
					{
					setState(2019); match(ON);
					setState(2020); match(UPDATE);
					setState(2021); ((Table_constraintContext)_localctx).action_on_update = action();
					}
				}

				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(2029);
			switch (_input.LA(1)) {
			case DEFERRABLE:
				{
				setState(2026); match(DEFERRABLE);
				}
				break;
			case NOT:
				{
				{
				setState(2027); match(NOT);
				setState(2028); match(DEFERRABLE);
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
			case VARBINARY:
			case BLOB:
			case BYTEA:
			case INET4:
			case COMMA:
			case RIGHT_PAREN:
			case QUOTE:
			case Identifier:
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(2035);
			switch ( getInterpreter().adaptivePredict(_input,290,_ctx) ) {
			case 1:
				{
				{
				setState(2031); match(INITIALLY);
				setState(2032); match(DEFERRED);
				}
				}
				break;
			case 2:
				{
				{
				setState(2033); match(INITIALLY);
				setState(2034); match(IMMEDIATE);
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
		enterRule(_localctx, 50, RULE_column_constraint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2039);
			_la = _input.LA(1);
			if (_la==CONSTRAINT) {
				{
				setState(2037); match(CONSTRAINT);
				setState(2038); ((Column_constraintContext)_localctx).constraint_name = identifier();
				}
			}

			setState(2073);
			switch (_input.LA(1)) {
			case NOT:
				{
				{
				setState(2041); match(NOT);
				setState(2042); match(NULL);
				}
				}
				break;
			case NULL:
				{
				setState(2043); match(NULL);
				}
				break;
			case CHECK:
				{
				setState(2044); check_boolean_expression();
				}
				break;
			case DEFAULT:
				{
				{
				setState(2045); match(DEFAULT);
				setState(2046); ((Column_constraintContext)_localctx).default_expr = routine_invocation();
				}
				}
				break;
			case UNIQUE:
				{
				{
				setState(2047); match(UNIQUE);
				setState(2048); ((Column_constraintContext)_localctx).index_params_unique = index_parameters();
				}
				}
				break;
			case PRIMARY:
				{
				{
				setState(2049); match(PRIMARY);
				setState(2050); match(KEY);
				setState(2051); ((Column_constraintContext)_localctx).index_params_pr_key = index_parameters();
				}
				}
				break;
			case REFERENCES:
				{
				{
				setState(2052); match(REFERENCES);
				setState(2053); ((Column_constraintContext)_localctx).reftable = schema_qualified_name();
				{
				{
				setState(2054); ((Column_constraintContext)_localctx).refcolumn = identifier();
				}
				}
				setState(2061);
				switch ( getInterpreter().adaptivePredict(_input,292,_ctx) ) {
				case 1:
					{
					setState(2055); match(MATCH);
					setState(2056); match(FULL);
					}
					break;
				case 2:
					{
					setState(2057); match(MATCH);
					setState(2058); match(PARTIAL);
					}
					break;
				case 3:
					{
					setState(2059); match(MATCH);
					setState(2060); match(SIMPLE);
					}
					break;
				}
				setState(2066);
				switch ( getInterpreter().adaptivePredict(_input,293,_ctx) ) {
				case 1:
					{
					setState(2063); match(ON);
					setState(2064); match(DELETE);
					setState(2065); ((Column_constraintContext)_localctx).action_on_delete = action();
					}
					break;
				}
				setState(2071);
				_la = _input.LA(1);
				if (_la==ON) {
					{
					setState(2068); match(ON);
					setState(2069); match(UPDATE);
					setState(2070); ((Column_constraintContext)_localctx).action_on_update = action();
					}
				}

				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(2078);
			switch ( getInterpreter().adaptivePredict(_input,296,_ctx) ) {
			case 1:
				{
				setState(2075); match(DEFERRABLE);
				}
				break;
			case 2:
				{
				{
				setState(2076); match(NOT);
				setState(2077); match(DEFERRABLE);
				}
				}
				break;
			}
			setState(2084);
			switch ( getInterpreter().adaptivePredict(_input,297,_ctx) ) {
			case 1:
				{
				{
				setState(2080); match(INITIALLY);
				setState(2081); match(DEFERRED);
				}
				}
				break;
			case 2:
				{
				{
				setState(2082); match(INITIALLY);
				setState(2083); match(IMMEDIATE);
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
		enterRule(_localctx, 52, RULE_check_boolean_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2086); match(CHECK);
			setState(2087); match(LEFT_PAREN);
			setState(2088); ((Check_boolean_expressionContext)_localctx).expression = boolean_value_expression();
			setState(2089); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 54, RULE_storage_parameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2091); match(WITH);
			setState(2092); match(LEFT_PAREN);
			setState(2101); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(2093); ((Storage_parameterContext)_localctx).storage_param = identifier();
				setState(2096);
				_la = _input.LA(1);
				if (_la==EQUAL) {
					{
					setState(2094); match(EQUAL);
					setState(2095); ((Storage_parameterContext)_localctx).value = identifier();
					}
				}

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
			} while ( ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (ADMIN - 129)) | (1L << (AVG - 129)) | (1L << (BETWEEN - 129)) | (1L << (BY - 129)) | (1L << (CACHE - 129)) | (1L << (CALLED - 129)) | (1L << (CLASS - 129)) | (1L << (CENTURY - 129)) | (1L << (CHARACTER - 129)) | (1L << (CHECK - 129)) | (1L << (COLLECT - 129)) | (1L << (COALESCE - 129)) | (1L << (COLUMN - 129)) | (1L << (COMMENT - 129)) | (1L << (COMMENTS - 129)) | (1L << (COMMIT - 129)) | (1L << (CONFIGURATION - 129)) | (1L << (COST - 129)) | (1L << (COUNT - 129)) | (1L << (CUBE - 129)) | (1L << (CURRENT - 129)) | (1L << (CYCLE - 129)) | (1L << (DATA - 129)) | (1L << (DAY - 129)) | (1L << (DEC - 129)) | (1L << (DECADE - 129)) | (1L << (DEFINER - 129)) | (1L << (DICTIONARY - 129)) | (1L << (DOW - 129)) | (1L << (DOY - 129)) | (1L << (DROP - 129)) | (1L << (EPOCH - 129)) | (1L << (EVERY - 129)) | (1L << (EXISTS - 129)) | (1L << (EXTERNAL - 129)) | (1L << (EXTRACT - 129)) | (1L << (FAMILY - 129)) | (1L << (FILTER - 129)) | (1L << (FIRST - 129)) | (1L << (FORMAT - 129)) | (1L << (FUSION - 129)) | (1L << (GROUPING - 129)) | (1L << (HASH - 129)) | (1L << (INDEX - 129)) | (1L << (INCREMENT - 129)) | (1L << (INPUT - 129)) | (1L << (INSERT - 129)) | (1L << (INTERSECTION - 129)) | (1L << (ISCACHABLE - 129)) | (1L << (ISODOW - 129)) | (1L << (ISOYEAR - 129)) | (1L << (ISSTRICT - 129)) | (1L << (LANGUAGE - 129)) | (1L << (LARGE - 129)) | (1L << (LAST - 129)) | (1L << (LESS - 129)) | (1L << (LIST - 129)) | (1L << (LOCATION - 129)) | (1L << (MATCH - 129)) | (1L << (MAX - 129)) | (1L << (MAXVALUE - 129)) | (1L << (MICROSECONDS - 129)))) != 0) || ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & ((1L << (MILLENNIUM - 193)) | (1L << (MILLISECONDS - 193)) | (1L << (MIN - 193)) | (1L << (MINVALUE - 193)) | (1L << (MINUTE - 193)) | (1L << (MONTH - 193)) | (1L << (NATIONAL - 193)) | (1L << (NO - 193)) | (1L << (NONE - 193)) | (1L << (NULLIF - 193)) | (1L << (OBJECT - 193)) | (1L << (OPTION - 193)) | (1L << (OPTIONS - 193)) | (1L << (OVERWRITE - 193)) | (1L << (PARSER - 193)) | (1L << (PARTIAL - 193)) | (1L << (PARTITION - 193)) | (1L << (PARTITIONS - 193)) | (1L << (PRECISION - 193)) | (1L << (PUBLIC - 193)) | (1L << (PURGE - 193)) | (1L << (QUARTER - 193)) | (1L << (RANGE - 193)) | (1L << (REGEXP - 193)) | (1L << (RLIKE - 193)) | (1L << (ROLLUP - 193)) | (1L << (SEARCH - 193)) | (1L << (SECOND - 193)) | (1L << (SECURITY - 193)) | (1L << (SERVER - 193)) | (1L << (SET - 193)) | (1L << (SIMILAR - 193)) | (1L << (SIMPLE - 193)) | (1L << (STABLE - 193)) | (1L << (START - 193)) | (1L << (STORAGE - 193)) | (1L << (STDDEV_POP - 193)) | (1L << (STDDEV_SAMP - 193)) | (1L << (SUBPARTITION - 193)) | (1L << (SUM - 193)) | (1L << (TABLESPACE - 193)) | (1L << (TEMPLATE - 193)) | (1L << (THAN - 193)) | (1L << (TIMEZONE - 193)) | (1L << (TIMEZONE_HOUR - 193)) | (1L << (TIMEZONE_MINUTE - 193)) | (1L << (TRIM - 193)) | (1L << (TO - 193)) | (1L << (UNKNOWN - 193)) | (1L << (UNLOGGED - 193)) | (1L << (VALUES - 193)) | (1L << (VAR_SAMP - 193)) | (1L << (VAR_POP - 193)) | (1L << (VARYING - 193)) | (1L << (VOLATILE - 193)) | (1L << (WEEK - 193)) | (1L << (WINDOW - 193)) | (1L << (WRAPPER - 193)) | (1L << (YEAR - 193)) | (1L << (ZONE - 193)) | (1L << (BOOLEAN - 193)) | (1L << (BOOL - 193)))) != 0) || ((((_la - 257)) & ~0x3f) == 0 && ((1L << (_la - 257)) & ((1L << (BIT - 257)) | (1L << (VARBIT - 257)) | (1L << (INT1 - 257)) | (1L << (INT2 - 257)) | (1L << (INT4 - 257)) | (1L << (INT8 - 257)) | (1L << (TINYINT - 257)) | (1L << (SMALLINT - 257)) | (1L << (INT - 257)) | (1L << (INTEGER - 257)) | (1L << (BIGINT - 257)) | (1L << (FLOAT4 - 257)) | (1L << (FLOAT8 - 257)) | (1L << (REAL - 257)) | (1L << (FLOAT - 257)) | (1L << (DOUBLE - 257)) | (1L << (NUMERIC - 257)) | (1L << (DECIMAL - 257)) | (1L << (CHAR - 257)) | (1L << (VARCHAR - 257)) | (1L << (NCHAR - 257)) | (1L << (NVARCHAR - 257)) | (1L << (DATE - 257)) | (1L << (TIME - 257)) | (1L << (TIMETZ - 257)) | (1L << (TIMESTAMP - 257)) | (1L << (TIMESTAMPTZ - 257)) | (1L << (TEXT - 257)) | (1L << (VARBINARY - 257)) | (1L << (BLOB - 257)) | (1L << (BYTEA - 257)) | (1L << (INET4 - 257)) | (1L << (QUOTE - 257)))) != 0) || _la==Identifier );
			setState(2105); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 56, RULE_storage_parameter_oid);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2112);
			switch ( getInterpreter().adaptivePredict(_input,301,_ctx) ) {
			case 1:
				{
				setState(2107); storage_parameter();
				}
				break;
			case 2:
				{
				{
				setState(2108); match(WITH);
				setState(2109); match(OIDS);
				}
				}
				break;
			case 3:
				{
				{
				setState(2110); match(WITHOUT);
				setState(2111); match(OIDS);
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
		enterRule(_localctx, 58, RULE_on_commit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2123);
			_la = _input.LA(1);
			if (_la==ON) {
				{
				setState(2114); match(ON);
				setState(2115); match(COMMIT);
				setState(2121);
				switch (_input.LA(1)) {
				case PRESERVE:
					{
					{
					setState(2116); match(PRESERVE);
					setState(2117); match(ROWS);
					}
					}
					break;
				case DELETE:
					{
					{
					setState(2118); match(DELETE);
					setState(2119); match(ROWS);
					}
					}
					break;
				case DROP:
					{
					setState(2120); match(DROP);
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
		enterRule(_localctx, 60, RULE_table_space);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2127);
			switch ( getInterpreter().adaptivePredict(_input,304,_ctx) ) {
			case 1:
				{
				setState(2125); match(TABLESPACE);
				setState(2126); ((Table_spaceContext)_localctx).tablespace = identifier();
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
		enterRule(_localctx, 62, RULE_action);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2135);
			switch ( getInterpreter().adaptivePredict(_input,305,_ctx) ) {
			case 1:
				{
				setState(2129); match(RESTRICT);
				}
				break;
			case 2:
				{
				setState(2130); match(CASCADE);
				}
				break;
			case 3:
				{
				setState(2131); match(SET);
				setState(2132); match(NULL);
				}
				break;
			case 4:
				{
				setState(2133); match(SET);
				setState(2134); match(DEFAULT);
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
		enterRule(_localctx, 64, RULE_index_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2138);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(2137); storage_parameter();
				}
			}

			setState(2144);
			_la = _input.LA(1);
			if (_la==USING) {
				{
				setState(2140); match(USING);
				setState(2141); match(INDEX);
				setState(2142); match(TABLESPACE);
				setState(2143); ((Index_parametersContext)_localctx).tablespace = identifier();
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
		enterRule(_localctx, 66, RULE_table_elements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2146); match(LEFT_PAREN);
			setState(2147); field_element();
			setState(2152);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2148); match(COMMA);
				setState(2149); field_element();
				}
				}
				setState(2154);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2155); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 68, RULE_field_element);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2157); ((Field_elementContext)_localctx).name = identifier();
			setState(2158); field_type();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 70, RULE_field_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2160); data_type();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 72, RULE_param_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2162); match(WITH);
			setState(2163); match(LEFT_PAREN);
			setState(2164); param();
			setState(2169);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2165); match(COMMA);
				setState(2166); param();
				}
				}
				setState(2171);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2172); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 74, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2174); ((ParamContext)_localctx).key = match(Character_String_Literal);
			setState(2175); match(EQUAL);
			setState(2176); ((ParamContext)_localctx).value = numeric_value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 76, RULE_method_specifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2178); match(USING);
			setState(2179); ((Method_specifierContext)_localctx).m = identifier();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 78, RULE_table_space_specifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2181); match(TABLESPACE);
			setState(2182); table_space_name();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 80, RULE_table_space_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2184); identifier();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 82, RULE_table_partitioning_clauses);
		try {
			setState(2190);
			switch ( getInterpreter().adaptivePredict(_input,310,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2186); range_partitions();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2187); hash_partitions();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2188); list_partitions();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2189); column_partitions();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 84, RULE_range_partitions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2192); match(PARTITION);
			setState(2193); match(BY);
			setState(2194); match(RANGE);
			setState(2195); match(LEFT_PAREN);
			setState(2196); column_reference_list();
			setState(2197); match(RIGHT_PAREN);
			setState(2198); match(LEFT_PAREN);
			setState(2199); range_value_clause_list();
			setState(2200); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 86, RULE_range_value_clause_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2202); range_value_clause();
			setState(2207);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2203); match(COMMA);
				setState(2204); range_value_clause();
				}
				}
				setState(2209);
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
		enterRule(_localctx, 88, RULE_range_value_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2210); match(PARTITION);
			setState(2211); partition_name();
			setState(2212); match(VALUES);
			setState(2213); match(LESS);
			setState(2214); match(THAN);
			setState(2226);
			switch ( getInterpreter().adaptivePredict(_input,314,_ctx) ) {
			case 1:
				{
				setState(2215); match(LEFT_PAREN);
				setState(2216); value_expression();
				setState(2217); match(RIGHT_PAREN);
				}
				break;
			case 2:
				{
				setState(2220);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(2219); match(LEFT_PAREN);
					}
				}

				setState(2222); match(MAXVALUE);
				setState(2224);
				switch ( getInterpreter().adaptivePredict(_input,313,_ctx) ) {
				case 1:
					{
					setState(2223); match(RIGHT_PAREN);
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
		enterRule(_localctx, 90, RULE_hash_partitions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2228); match(PARTITION);
			setState(2229); match(BY);
			setState(2230); match(HASH);
			setState(2231); match(LEFT_PAREN);
			setState(2232); column_reference_list();
			setState(2233); match(RIGHT_PAREN);
			setState(2239);
			switch (_input.LA(1)) {
			case LEFT_PAREN:
				{
				setState(2234); match(LEFT_PAREN);
				setState(2235); individual_hash_partitions();
				setState(2236); match(RIGHT_PAREN);
				}
				break;
			case PARTITIONS:
				{
				setState(2238); hash_partitions_by_quantity();
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
		enterRule(_localctx, 92, RULE_individual_hash_partitions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2241); individual_hash_partition();
			setState(2246);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2242); match(COMMA);
				setState(2243); individual_hash_partition();
				}
				}
				setState(2248);
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
		enterRule(_localctx, 94, RULE_individual_hash_partition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2249); match(PARTITION);
			setState(2250); partition_name();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 96, RULE_hash_partitions_by_quantity);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2252); match(PARTITIONS);
			setState(2253); ((Hash_partitions_by_quantityContext)_localctx).quantity = numeric_value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 98, RULE_list_partitions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2255); match(PARTITION);
			setState(2256); match(BY);
			setState(2257); match(LIST);
			setState(2258); match(LEFT_PAREN);
			setState(2259); column_reference_list();
			setState(2260); match(RIGHT_PAREN);
			setState(2261); match(LEFT_PAREN);
			setState(2262); list_value_clause_list();
			setState(2263); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 100, RULE_list_value_clause_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2265); list_value_partition();
			setState(2270);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2266); match(COMMA);
				setState(2267); list_value_partition();
				}
				}
				setState(2272);
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
		enterRule(_localctx, 102, RULE_list_value_partition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2273); match(PARTITION);
			setState(2274); partition_name();
			setState(2275); match(VALUES);
			setState(2277);
			_la = _input.LA(1);
			if (_la==IN) {
				{
				setState(2276); match(IN);
				}
			}

			setState(2279); match(LEFT_PAREN);
			setState(2280); in_value_list();
			setState(2281); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 104, RULE_column_partitions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2283); match(PARTITION);
			setState(2284); match(BY);
			setState(2285); match(COLUMN);
			setState(2286); table_elements();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 106, RULE_partition_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2288); identifier();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 108, RULE_drop_table_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2290); match(DROP);
			setState(2291); match(TABLE);
			setState(2292); schema_qualified_name();
			setState(2294);
			switch ( getInterpreter().adaptivePredict(_input,319,_ctx) ) {
			case 1:
				{
				setState(2293); match(PURGE);
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
		public TerminalNode QUOTE(int i) {
			return getToken(SQLParser.QUOTE, i);
		}
		public List<TerminalNode> QUOTE() { return getTokens(SQLParser.QUOTE); }
		public Nonreserved_keywordsContext nonreserved_keywords() {
			return getRuleContext(Nonreserved_keywordsContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(SQLParser.Identifier, 0); }
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
		enterRule(_localctx, 110, RULE_identifier);
		int _la;
		try {
			setState(2304);
			switch (_input.LA(1)) {
			case QUOTE:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(2297);
				_la = _input.LA(1);
				if (_la==QUOTE) {
					{
					setState(2296); match(QUOTE);
					}
				}

				setState(2299); match(Identifier);
				setState(2301);
				switch ( getInterpreter().adaptivePredict(_input,321,_ctx) ) {
				case 1:
					{
					setState(2300); match(QUOTE);
					}
					break;
				}
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
			case VARBINARY:
			case BLOB:
			case BYTEA:
			case INET4:
				enterOuterAlt(_localctx, 2);
				{
				setState(2303); nonreserved_keywords();
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
		public TerminalNode SMALLINT() { return getToken(SQLParser.SMALLINT, 0); }
		public TerminalNode ISODOW() { return getToken(SQLParser.ISODOW, 0); }
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
		enterRule(_localctx, 112, RULE_nonreserved_keywords);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2306);
			_la = _input.LA(1);
			if ( !(((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (ADMIN - 129)) | (1L << (AVG - 129)) | (1L << (BETWEEN - 129)) | (1L << (BY - 129)) | (1L << (CACHE - 129)) | (1L << (CALLED - 129)) | (1L << (CLASS - 129)) | (1L << (CENTURY - 129)) | (1L << (CHARACTER - 129)) | (1L << (CHECK - 129)) | (1L << (COLLECT - 129)) | (1L << (COALESCE - 129)) | (1L << (COLUMN - 129)) | (1L << (COMMENT - 129)) | (1L << (COMMENTS - 129)) | (1L << (COMMIT - 129)) | (1L << (CONFIGURATION - 129)) | (1L << (COST - 129)) | (1L << (COUNT - 129)) | (1L << (CUBE - 129)) | (1L << (CURRENT - 129)) | (1L << (CYCLE - 129)) | (1L << (DATA - 129)) | (1L << (DAY - 129)) | (1L << (DEC - 129)) | (1L << (DECADE - 129)) | (1L << (DEFINER - 129)) | (1L << (DICTIONARY - 129)) | (1L << (DOW - 129)) | (1L << (DOY - 129)) | (1L << (DROP - 129)) | (1L << (EPOCH - 129)) | (1L << (EVERY - 129)) | (1L << (EXISTS - 129)) | (1L << (EXTERNAL - 129)) | (1L << (EXTRACT - 129)) | (1L << (FAMILY - 129)) | (1L << (FILTER - 129)) | (1L << (FIRST - 129)) | (1L << (FORMAT - 129)) | (1L << (FUSION - 129)) | (1L << (GROUPING - 129)) | (1L << (HASH - 129)) | (1L << (INDEX - 129)) | (1L << (INCREMENT - 129)) | (1L << (INPUT - 129)) | (1L << (INSERT - 129)) | (1L << (INTERSECTION - 129)) | (1L << (ISCACHABLE - 129)) | (1L << (ISODOW - 129)) | (1L << (ISOYEAR - 129)) | (1L << (ISSTRICT - 129)) | (1L << (LANGUAGE - 129)) | (1L << (LARGE - 129)) | (1L << (LAST - 129)) | (1L << (LESS - 129)) | (1L << (LIST - 129)) | (1L << (LOCATION - 129)) | (1L << (MATCH - 129)) | (1L << (MAX - 129)) | (1L << (MAXVALUE - 129)) | (1L << (MICROSECONDS - 129)))) != 0) || ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & ((1L << (MILLENNIUM - 193)) | (1L << (MILLISECONDS - 193)) | (1L << (MIN - 193)) | (1L << (MINVALUE - 193)) | (1L << (MINUTE - 193)) | (1L << (MONTH - 193)) | (1L << (NATIONAL - 193)) | (1L << (NO - 193)) | (1L << (NONE - 193)) | (1L << (NULLIF - 193)) | (1L << (OBJECT - 193)) | (1L << (OPTION - 193)) | (1L << (OPTIONS - 193)) | (1L << (OVERWRITE - 193)) | (1L << (PARSER - 193)) | (1L << (PARTIAL - 193)) | (1L << (PARTITION - 193)) | (1L << (PARTITIONS - 193)) | (1L << (PRECISION - 193)) | (1L << (PUBLIC - 193)) | (1L << (PURGE - 193)) | (1L << (QUARTER - 193)) | (1L << (RANGE - 193)) | (1L << (REGEXP - 193)) | (1L << (RLIKE - 193)) | (1L << (ROLLUP - 193)) | (1L << (SEARCH - 193)) | (1L << (SECOND - 193)) | (1L << (SECURITY - 193)) | (1L << (SERVER - 193)) | (1L << (SET - 193)) | (1L << (SIMILAR - 193)) | (1L << (SIMPLE - 193)) | (1L << (STABLE - 193)) | (1L << (START - 193)) | (1L << (STORAGE - 193)) | (1L << (STDDEV_POP - 193)) | (1L << (STDDEV_SAMP - 193)) | (1L << (SUBPARTITION - 193)) | (1L << (SUM - 193)) | (1L << (TABLESPACE - 193)) | (1L << (TEMPLATE - 193)) | (1L << (THAN - 193)) | (1L << (TIMEZONE - 193)) | (1L << (TIMEZONE_HOUR - 193)) | (1L << (TIMEZONE_MINUTE - 193)) | (1L << (TRIM - 193)) | (1L << (TO - 193)) | (1L << (UNKNOWN - 193)) | (1L << (UNLOGGED - 193)) | (1L << (VALUES - 193)) | (1L << (VAR_SAMP - 193)) | (1L << (VAR_POP - 193)) | (1L << (VARYING - 193)) | (1L << (VOLATILE - 193)) | (1L << (WEEK - 193)) | (1L << (WINDOW - 193)) | (1L << (WRAPPER - 193)) | (1L << (YEAR - 193)) | (1L << (ZONE - 193)) | (1L << (BOOLEAN - 193)) | (1L << (BOOL - 193)))) != 0) || ((((_la - 257)) & ~0x3f) == 0 && ((1L << (_la - 257)) & ((1L << (BIT - 257)) | (1L << (VARBIT - 257)) | (1L << (INT1 - 257)) | (1L << (INT2 - 257)) | (1L << (INT4 - 257)) | (1L << (INT8 - 257)) | (1L << (TINYINT - 257)) | (1L << (SMALLINT - 257)) | (1L << (INT - 257)) | (1L << (INTEGER - 257)) | (1L << (BIGINT - 257)) | (1L << (FLOAT4 - 257)) | (1L << (FLOAT8 - 257)) | (1L << (REAL - 257)) | (1L << (FLOAT - 257)) | (1L << (DOUBLE - 257)) | (1L << (NUMERIC - 257)) | (1L << (DECIMAL - 257)) | (1L << (CHAR - 257)) | (1L << (VARCHAR - 257)) | (1L << (NCHAR - 257)) | (1L << (NVARCHAR - 257)) | (1L << (DATE - 257)) | (1L << (TIME - 257)) | (1L << (TIMETZ - 257)) | (1L << (TIMESTAMP - 257)) | (1L << (TIMESTAMPTZ - 257)) | (1L << (TEXT - 257)) | (1L << (VARBINARY - 257)) | (1L << (BLOB - 257)) | (1L << (BYTEA - 257)) | (1L << (INET4 - 257)))) != 0)) ) {
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
		enterRule(_localctx, 114, RULE_unsigned_literal);
		try {
			setState(2310);
			switch (_input.LA(1)) {
			case NUMBER:
			case REAL_NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(2308); unsigned_numeric_literal();
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
				setState(2309); general_literal();
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
		enterRule(_localctx, 116, RULE_general_literal);
		try {
			setState(2315);
			switch (_input.LA(1)) {
			case Character_String_Literal:
				enterOuterAlt(_localctx, 1);
				{
				setState(2312); match(Character_String_Literal);
				}
				break;
			case DATE:
			case TIME:
			case TIMESTAMP:
				enterOuterAlt(_localctx, 2);
				{
				setState(2313); datetime_literal();
				}
				break;
			case FALSE:
			case TRUE:
			case UNKNOWN:
				enterOuterAlt(_localctx, 3);
				{
				setState(2314); boolean_literal();
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
		enterRule(_localctx, 118, RULE_datetime_literal);
		try {
			setState(2320);
			switch (_input.LA(1)) {
			case TIMESTAMP:
				enterOuterAlt(_localctx, 1);
				{
				setState(2317); timestamp_literal();
				}
				break;
			case TIME:
				enterOuterAlt(_localctx, 2);
				{
				setState(2318); time_literal();
				}
				break;
			case DATE:
				enterOuterAlt(_localctx, 3);
				{
				setState(2319); date_literal();
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
		enterRule(_localctx, 120, RULE_time_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2322); match(TIME);
			setState(2323); ((Time_literalContext)_localctx).time_string = match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 122, RULE_timestamp_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2325); match(TIMESTAMP);
			setState(2326); ((Timestamp_literalContext)_localctx).timestamp_string = match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 124, RULE_date_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2328); match(DATE);
			setState(2329); ((Date_literalContext)_localctx).date_string = match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 126, RULE_boolean_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2331);
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
		enterRule(_localctx, 128, RULE_data_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2333); predefined_type();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 130, RULE_predefined_type);
		try {
			setState(2346);
			switch (_input.LA(1)) {
			case CHARACTER:
			case CHAR:
			case VARCHAR:
			case TEXT:
				enterOuterAlt(_localctx, 1);
				{
				setState(2335); character_string_type();
				}
				break;
			case NATIONAL:
			case NCHAR:
			case NVARCHAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(2336); national_character_string_type();
				}
				break;
			case BLOB:
			case BYTEA:
				enterOuterAlt(_localctx, 3);
				{
				setState(2337); binary_large_object_string_type();
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
				setState(2338); numeric_type();
				}
				break;
			case BOOLEAN:
			case BOOL:
				enterOuterAlt(_localctx, 5);
				{
				setState(2339); boolean_type();
				}
				break;
			case DATE:
			case TIME:
			case TIMETZ:
			case TIMESTAMP:
			case TIMESTAMPTZ:
				enterOuterAlt(_localctx, 6);
				{
				setState(2340); datetime_type();
				}
				break;
			case BIT:
			case VARBIT:
				enterOuterAlt(_localctx, 7);
				{
				setState(2341); bit_type();
				}
				break;
			case BINARY:
			case VARBINARY:
				enterOuterAlt(_localctx, 8);
				{
				setState(2342); binary_type();
				}
				break;
			case INET4:
				enterOuterAlt(_localctx, 9);
				{
				setState(2343); network_type();
				}
				break;
			case REGCLASS:
				enterOuterAlt(_localctx, 10);
				{
				setState(2344); regclass();
				}
				break;
			case TRIGGER:
				enterOuterAlt(_localctx, 11);
				{
				setState(2345); match(TRIGGER);
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
		enterRule(_localctx, 132, RULE_regclass);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2348); match(REGCLASS);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 134, RULE_network_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2350); match(INET4);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 136, RULE_character_string_type);
		try {
			setState(2375);
			switch ( getInterpreter().adaptivePredict(_input,332,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2352); match(CHARACTER);
				setState(2354);
				switch ( getInterpreter().adaptivePredict(_input,327,_ctx) ) {
				case 1:
					{
					setState(2353); type_length();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2356); match(CHAR);
				setState(2358);
				switch ( getInterpreter().adaptivePredict(_input,328,_ctx) ) {
				case 1:
					{
					setState(2357); type_length();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2360); match(CHARACTER);
				setState(2361); match(VARYING);
				setState(2363);
				switch ( getInterpreter().adaptivePredict(_input,329,_ctx) ) {
				case 1:
					{
					setState(2362); type_length();
					}
					break;
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2365); match(CHAR);
				setState(2366); match(VARYING);
				setState(2368);
				switch ( getInterpreter().adaptivePredict(_input,330,_ctx) ) {
				case 1:
					{
					setState(2367); type_length();
					}
					break;
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2370); match(VARCHAR);
				setState(2372);
				switch ( getInterpreter().adaptivePredict(_input,331,_ctx) ) {
				case 1:
					{
					setState(2371); type_length();
					}
					break;
				}
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2374); match(TEXT);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 138, RULE_type_length);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2377); match(LEFT_PAREN);
			setState(2378); match(NUMBER);
			setState(2379); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 140, RULE_national_character_string_type);
		try {
			setState(2416);
			switch ( getInterpreter().adaptivePredict(_input,340,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2381); match(NATIONAL);
				setState(2382); match(CHARACTER);
				setState(2384);
				switch ( getInterpreter().adaptivePredict(_input,333,_ctx) ) {
				case 1:
					{
					setState(2383); type_length();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2386); match(NATIONAL);
				setState(2387); match(CHAR);
				setState(2389);
				switch ( getInterpreter().adaptivePredict(_input,334,_ctx) ) {
				case 1:
					{
					setState(2388); type_length();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2391); match(NCHAR);
				setState(2393);
				switch ( getInterpreter().adaptivePredict(_input,335,_ctx) ) {
				case 1:
					{
					setState(2392); type_length();
					}
					break;
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2395); match(NATIONAL);
				setState(2396); match(CHARACTER);
				setState(2397); match(VARYING);
				setState(2399);
				switch ( getInterpreter().adaptivePredict(_input,336,_ctx) ) {
				case 1:
					{
					setState(2398); type_length();
					}
					break;
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2401); match(NATIONAL);
				setState(2402); match(CHAR);
				setState(2403); match(VARYING);
				setState(2405);
				switch ( getInterpreter().adaptivePredict(_input,337,_ctx) ) {
				case 1:
					{
					setState(2404); type_length();
					}
					break;
				}
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2407); match(NCHAR);
				setState(2408); match(VARYING);
				setState(2410);
				switch ( getInterpreter().adaptivePredict(_input,338,_ctx) ) {
				case 1:
					{
					setState(2409); type_length();
					}
					break;
				}
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(2412); match(NVARCHAR);
				setState(2414);
				switch ( getInterpreter().adaptivePredict(_input,339,_ctx) ) {
				case 1:
					{
					setState(2413); type_length();
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
		enterRule(_localctx, 142, RULE_binary_large_object_string_type);
		try {
			setState(2426);
			switch (_input.LA(1)) {
			case BLOB:
				enterOuterAlt(_localctx, 1);
				{
				setState(2418); match(BLOB);
				setState(2420);
				switch ( getInterpreter().adaptivePredict(_input,341,_ctx) ) {
				case 1:
					{
					setState(2419); type_length();
					}
					break;
				}
				}
				break;
			case BYTEA:
				enterOuterAlt(_localctx, 2);
				{
				setState(2422); match(BYTEA);
				setState(2424);
				switch ( getInterpreter().adaptivePredict(_input,342,_ctx) ) {
				case 1:
					{
					setState(2423); type_length();
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
		enterRule(_localctx, 144, RULE_numeric_type);
		try {
			setState(2430);
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
				setState(2428); exact_numeric_type();
				}
				break;
			case FLOAT4:
			case FLOAT8:
			case REAL:
			case FLOAT:
			case DOUBLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(2429); approximate_numeric_type();
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
		enterRule(_localctx, 146, RULE_exact_numeric_type);
		try {
			setState(2453);
			switch (_input.LA(1)) {
			case NUMERIC:
				enterOuterAlt(_localctx, 1);
				{
				setState(2432); match(NUMERIC);
				setState(2434);
				switch ( getInterpreter().adaptivePredict(_input,345,_ctx) ) {
				case 1:
					{
					setState(2433); precision_param();
					}
					break;
				}
				}
				break;
			case DECIMAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(2436); match(DECIMAL);
				setState(2438);
				switch ( getInterpreter().adaptivePredict(_input,346,_ctx) ) {
				case 1:
					{
					setState(2437); precision_param();
					}
					break;
				}
				}
				break;
			case DEC:
				enterOuterAlt(_localctx, 3);
				{
				setState(2440); match(DEC);
				setState(2442);
				switch ( getInterpreter().adaptivePredict(_input,347,_ctx) ) {
				case 1:
					{
					setState(2441); precision_param();
					}
					break;
				}
				}
				break;
			case INT1:
				enterOuterAlt(_localctx, 4);
				{
				setState(2444); match(INT1);
				}
				break;
			case TINYINT:
				enterOuterAlt(_localctx, 5);
				{
				setState(2445); match(TINYINT);
				}
				break;
			case INT2:
				enterOuterAlt(_localctx, 6);
				{
				setState(2446); match(INT2);
				}
				break;
			case SMALLINT:
				enterOuterAlt(_localctx, 7);
				{
				setState(2447); match(SMALLINT);
				}
				break;
			case INT4:
				enterOuterAlt(_localctx, 8);
				{
				setState(2448); match(INT4);
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 9);
				{
				setState(2449); match(INT);
				}
				break;
			case INTEGER:
				enterOuterAlt(_localctx, 10);
				{
				setState(2450); match(INTEGER);
				}
				break;
			case INT8:
				enterOuterAlt(_localctx, 11);
				{
				setState(2451); match(INT8);
				}
				break;
			case BIGINT:
				enterOuterAlt(_localctx, 12);
				{
				setState(2452); match(BIGINT);
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
		enterRule(_localctx, 148, RULE_approximate_numeric_type);
		try {
			setState(2465);
			switch ( getInterpreter().adaptivePredict(_input,350,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2455); match(FLOAT);
				setState(2457);
				switch ( getInterpreter().adaptivePredict(_input,349,_ctx) ) {
				case 1:
					{
					setState(2456); precision_param();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2459); match(FLOAT4);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2460); match(REAL);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2461); match(FLOAT8);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2462); match(DOUBLE);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2463); match(DOUBLE);
				setState(2464); match(PRECISION);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 150, RULE_precision_param);
		try {
			setState(2475);
			switch ( getInterpreter().adaptivePredict(_input,351,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2467); match(LEFT_PAREN);
				setState(2468); ((Precision_paramContext)_localctx).precision = match(NUMBER);
				setState(2469); match(RIGHT_PAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2470); match(LEFT_PAREN);
				setState(2471); ((Precision_paramContext)_localctx).precision = match(NUMBER);
				setState(2472); match(COMMA);
				setState(2473); ((Precision_paramContext)_localctx).scale = match(NUMBER);
				setState(2474); match(RIGHT_PAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 152, RULE_boolean_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2477);
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
		enterRule(_localctx, 154, RULE_datetime_type);
		try {
			setState(2492);
			switch ( getInterpreter().adaptivePredict(_input,352,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2479); match(DATE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2480); match(TIME);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2481); match(TIME);
				setState(2482); match(WITH);
				setState(2483); match(TIME);
				setState(2484); match(ZONE);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2485); match(TIMETZ);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2486); match(TIMESTAMP);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2487); match(TIMESTAMP);
				setState(2488); match(WITH);
				setState(2489); match(TIME);
				setState(2490); match(ZONE);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(2491); match(TIMESTAMPTZ);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 156, RULE_bit_type);
		try {
			setState(2507);
			switch ( getInterpreter().adaptivePredict(_input,356,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2494); match(BIT);
				setState(2496);
				switch ( getInterpreter().adaptivePredict(_input,353,_ctx) ) {
				case 1:
					{
					setState(2495); type_length();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2498); match(VARBIT);
				setState(2500);
				switch ( getInterpreter().adaptivePredict(_input,354,_ctx) ) {
				case 1:
					{
					setState(2499); type_length();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2502); match(BIT);
				setState(2503); match(VARYING);
				setState(2505);
				switch ( getInterpreter().adaptivePredict(_input,355,_ctx) ) {
				case 1:
					{
					setState(2504); type_length();
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
		enterRule(_localctx, 158, RULE_binary_type);
		try {
			setState(2522);
			switch ( getInterpreter().adaptivePredict(_input,360,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2509); match(BINARY);
				setState(2511);
				switch ( getInterpreter().adaptivePredict(_input,357,_ctx) ) {
				case 1:
					{
					setState(2510); type_length();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2513); match(BINARY);
				setState(2514); match(VARYING);
				setState(2516);
				switch ( getInterpreter().adaptivePredict(_input,358,_ctx) ) {
				case 1:
					{
					setState(2515); type_length();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2518); match(VARBINARY);
				setState(2520);
				switch ( getInterpreter().adaptivePredict(_input,359,_ctx) ) {
				case 1:
					{
					setState(2519); type_length();
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
		enterRule(_localctx, 160, RULE_value_expression_primary);
		try {
			setState(2526);
			switch ( getInterpreter().adaptivePredict(_input,361,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2524); parenthesized_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2525); nonparenthesized_value_expression_primary();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 162, RULE_parenthesized_value_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2528); match(LEFT_PAREN);
			setState(2529); value_expression();
			setState(2530); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 164, RULE_nonparenthesized_value_expression_primary);
		try {
			setState(2539);
			switch ( getInterpreter().adaptivePredict(_input,362,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2532); unsigned_value_specification();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2533); column_reference();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2534); set_function_specification();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2535); scalar_subquery();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2536); case_expression();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2537); cast_specification();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(2538); routine_invocation();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 166, RULE_unsigned_value_specification);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2541); unsigned_literal();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 168, RULE_unsigned_numeric_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2543);
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
		enterRule(_localctx, 170, RULE_signed_numerical_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2546);
			_la = _input.LA(1);
			if (_la==PLUS || _la==MINUS) {
				{
				setState(2545); sign();
				}
			}

			setState(2548); unsigned_numeric_literal();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 172, RULE_set_function_specification);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2550); aggregate_function();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 174, RULE_aggregate_function);
		try {
			setState(2560);
			switch ( getInterpreter().adaptivePredict(_input,365,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2552); match(COUNT);
				setState(2553); match(LEFT_PAREN);
				setState(2554); match(MULTIPLY);
				setState(2555); match(RIGHT_PAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2556); general_set_function();
				setState(2558);
				switch ( getInterpreter().adaptivePredict(_input,364,_ctx) ) {
				case 1:
					{
					setState(2557); filter_clause();
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
		enterRule(_localctx, 176, RULE_general_set_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2562); set_function_type();
			setState(2563); match(LEFT_PAREN);
			setState(2565);
			_la = _input.LA(1);
			if (_la==ALL || _la==DISTINCT) {
				{
				setState(2564); set_qualifier();
				}
			}

			setState(2567); value_expression();
			setState(2568); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 178, RULE_set_function_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2570);
			_la = _input.LA(1);
			if ( !(_la==ANY || ((((_la - 105)) & ~0x3f) == 0 && ((1L << (_la - 105)) & ((1L << (SOME - 105)) | (1L << (AVG - 105)) | (1L << (COLLECT - 105)) | (1L << (COUNT - 105)) | (1L << (EVERY - 105)))) != 0) || ((((_la - 169)) & ~0x3f) == 0 && ((1L << (_la - 169)) & ((1L << (FUSION - 169)) | (1L << (INTERSECTION - 169)) | (1L << (MAX - 169)) | (1L << (MIN - 169)) | (1L << (STDDEV_POP - 169)) | (1L << (STDDEV_SAMP - 169)) | (1L << (SUM - 169)))) != 0) || _la==VAR_SAMP || _la==VAR_POP) ) {
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
		enterRule(_localctx, 180, RULE_filter_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2572); match(FILTER);
			setState(2573); match(LEFT_PAREN);
			setState(2574); match(WHERE);
			setState(2575); search_condition();
			setState(2576); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 182, RULE_grouping_operation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2578); match(GROUPING);
			setState(2579); match(LEFT_PAREN);
			setState(2580); column_reference_list();
			setState(2581); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 184, RULE_case_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2583); case_specification();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 186, RULE_case_abbreviation);
		int _la;
		try {
			setState(2603);
			switch (_input.LA(1)) {
			case NULLIF:
				enterOuterAlt(_localctx, 1);
				{
				setState(2585); match(NULLIF);
				setState(2586); match(LEFT_PAREN);
				setState(2587); numeric_value_expression();
				setState(2588); match(COMMA);
				setState(2589); boolean_value_expression();
				setState(2590); match(RIGHT_PAREN);
				}
				break;
			case COALESCE:
				enterOuterAlt(_localctx, 2);
				{
				setState(2592); match(COALESCE);
				setState(2593); match(LEFT_PAREN);
				setState(2594); numeric_value_expression();
				setState(2597); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(2595); match(COMMA);
					setState(2596); boolean_value_expression();
					}
					}
					setState(2599); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==COMMA );
				setState(2601); match(RIGHT_PAREN);
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
		enterRule(_localctx, 188, RULE_case_specification);
		try {
			setState(2607);
			switch ( getInterpreter().adaptivePredict(_input,369,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2605); simple_case();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2606); searched_case();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 190, RULE_simple_case);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2609); match(CASE);
			setState(2610); boolean_value_expression();
			setState(2612); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(2611); simple_when_clause();
				}
				}
				setState(2614); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WHEN );
			setState(2617);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(2616); else_clause();
				}
			}

			setState(2619); match(END);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 192, RULE_searched_case);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2621); match(CASE);
			setState(2623); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(2622); searched_when_clause();
				}
				}
				setState(2625); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WHEN );
			setState(2628);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(2627); else_clause();
				}
			}

			setState(2630); match(END);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 194, RULE_simple_when_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2632); match(WHEN);
			setState(2633); search_condition();
			setState(2634); match(THEN);
			setState(2635); result();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 196, RULE_searched_when_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2637); match(WHEN);
			setState(2638); ((Searched_when_clauseContext)_localctx).c = search_condition();
			setState(2639); match(THEN);
			setState(2640); ((Searched_when_clauseContext)_localctx).r = result();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 198, RULE_else_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2642); match(ELSE);
			setState(2643); ((Else_clauseContext)_localctx).r = result();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 200, RULE_result);
		try {
			setState(2647);
			switch ( getInterpreter().adaptivePredict(_input,374,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2645); value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2646); match(NULL);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 202, RULE_cast_specification);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2649); match(CAST);
			setState(2650); match(LEFT_PAREN);
			setState(2651); cast_operand();
			setState(2652); match(AS);
			setState(2653); cast_target();
			setState(2654); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 204, RULE_cast_operand);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2656); value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 206, RULE_cast_target);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2658); data_type();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 208, RULE_value_expression);
		try {
			setState(2663);
			switch ( getInterpreter().adaptivePredict(_input,375,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2660); common_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2661); row_value_expression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2662); boolean_value_expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 210, RULE_common_value_expression);
		try {
			setState(2668);
			switch ( getInterpreter().adaptivePredict(_input,376,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2665); numeric_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2666); string_value_expression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2667); match(NULL);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 212, RULE_numeric_value_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2670); ((Numeric_value_expressionContext)_localctx).left = term();
			setState(2675);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				{
				setState(2671);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(2672); ((Numeric_value_expressionContext)_localctx).right = term();
				}
				}
				setState(2677);
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
		enterRule(_localctx, 214, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2678); ((TermContext)_localctx).left = factor();
			setState(2683);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 311)) & ~0x3f) == 0 && ((1L << (_la - 311)) & ((1L << (MULTIPLY - 311)) | (1L << (DIVIDE - 311)) | (1L << (MODULAR - 311)))) != 0)) {
				{
				{
				setState(2679);
				_la = _input.LA(1);
				if ( !(((((_la - 311)) & ~0x3f) == 0 && ((1L << (_la - 311)) & ((1L << (MULTIPLY - 311)) | (1L << (DIVIDE - 311)) | (1L << (MODULAR - 311)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(2680); ((TermContext)_localctx).right = factor();
				}
				}
				setState(2685);
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
		enterRule(_localctx, 216, RULE_factor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2687);
			_la = _input.LA(1);
			if (_la==PLUS || _la==MINUS) {
				{
				setState(2686); sign();
				}
			}

			setState(2689); numeric_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 218, RULE_array);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2691); match(LEFT_PAREN);
			setState(2692); numeric_value_expression();
			setState(2697);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2693); match(COMMA);
				setState(2694); numeric_value_expression();
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
		enterRule(_localctx, 220, RULE_numeric_primary);
		int _la;
		try {
			setState(2711);
			switch ( getInterpreter().adaptivePredict(_input,382,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2702); value_expression_primary();
				setState(2707);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CAST_EXPRESSION) {
					{
					{
					setState(2703); match(CAST_EXPRESSION);
					setState(2704); cast_target();
					}
					}
					setState(2709);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2710); numeric_value_function();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 222, RULE_sign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2713);
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
		enterRule(_localctx, 224, RULE_numeric_value_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2715); extract_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 226, RULE_extract_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2717); match(EXTRACT);
			setState(2718); match(LEFT_PAREN);
			setState(2719); ((Extract_expressionContext)_localctx).extract_field_string = extract_field();
			setState(2720); match(FROM);
			setState(2721); extract_source();
			setState(2722); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 228, RULE_extract_field);
		try {
			setState(2727);
			switch (_input.LA(1)) {
			case DAY:
			case HOUR:
			case MINUTE:
			case MONTH:
			case SECOND:
			case YEAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(2724); primary_datetime_field();
				}
				break;
			case TIMEZONE:
			case TIMEZONE_HOUR:
			case TIMEZONE_MINUTE:
				enterOuterAlt(_localctx, 2);
				{
				setState(2725); time_zone_field();
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
				setState(2726); extended_datetime_field();
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
		enterRule(_localctx, 230, RULE_time_zone_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2729);
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
		enterRule(_localctx, 232, RULE_extract_source);
		try {
			setState(2733);
			switch ( getInterpreter().adaptivePredict(_input,384,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2731); column_reference();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2732); datetime_literal();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 234, RULE_string_value_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2735); character_value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 236, RULE_character_value_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2737); character_factor();
			setState(2742);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CONCATENATION_OPERATOR) {
				{
				{
				setState(2738); match(CONCATENATION_OPERATOR);
				setState(2739); character_factor();
				}
				}
				setState(2744);
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
		enterRule(_localctx, 238, RULE_character_factor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2745); character_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 240, RULE_character_primary);
		try {
			setState(2749);
			switch ( getInterpreter().adaptivePredict(_input,386,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2747); value_expression_primary();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2748); string_value_function();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 242, RULE_string_value_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2751); trim_function();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 244, RULE_trim_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2753); match(TRIM);
			setState(2754); match(LEFT_PAREN);
			setState(2755); trim_operands();
			setState(2756); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 246, RULE_trim_operands);
		int _la;
		try {
			setState(2772);
			switch ( getInterpreter().adaptivePredict(_input,390,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2765);
				switch ( getInterpreter().adaptivePredict(_input,389,_ctx) ) {
				case 1:
					{
					setState(2759);
					_la = _input.LA(1);
					if (_la==BOTH || _la==LEADING || _la==TRAILING) {
						{
						setState(2758); trim_specification();
						}
					}

					setState(2762);
					_la = _input.LA(1);
					if (((((_la - 6)) & ~0x3f) == 0 && ((1L << (_la - 6)) & ((1L << (ANY - 6)) | (1L << (CASE - 6)) | (1L << (CAST - 6)) | (1L << (FALSE - 6)) | (1L << (LEFT - 6)))) != 0) || ((((_la - 98)) & ~0x3f) == 0 && ((1L << (_la - 98)) & ((1L << (RIGHT - 98)) | (1L << (SOME - 98)) | (1L << (TRUE - 98)) | (1L << (ADMIN - 98)) | (1L << (AVG - 98)) | (1L << (BETWEEN - 98)) | (1L << (BY - 98)) | (1L << (CACHE - 98)) | (1L << (CALLED - 98)) | (1L << (CLASS - 98)) | (1L << (CENTURY - 98)) | (1L << (CHARACTER - 98)) | (1L << (CHECK - 98)) | (1L << (COLLECT - 98)) | (1L << (COALESCE - 98)) | (1L << (COLUMN - 98)) | (1L << (COMMENT - 98)) | (1L << (COMMENTS - 98)) | (1L << (COMMIT - 98)) | (1L << (CONFIGURATION - 98)) | (1L << (COST - 98)) | (1L << (COUNT - 98)) | (1L << (CUBE - 98)) | (1L << (CURRENT - 98)) | (1L << (CYCLE - 98)) | (1L << (DATA - 98)) | (1L << (DAY - 98)) | (1L << (DEC - 98)) | (1L << (DECADE - 98)) | (1L << (DEFINER - 98)) | (1L << (DICTIONARY - 98)) | (1L << (DOW - 98)) | (1L << (DOY - 98)) | (1L << (DROP - 98)) | (1L << (EPOCH - 98)) | (1L << (EVERY - 98)))) != 0) || ((((_la - 162)) & ~0x3f) == 0 && ((1L << (_la - 162)) & ((1L << (EXISTS - 162)) | (1L << (EXTERNAL - 162)) | (1L << (EXTRACT - 162)) | (1L << (FAMILY - 162)) | (1L << (FILTER - 162)) | (1L << (FIRST - 162)) | (1L << (FORMAT - 162)) | (1L << (FUSION - 162)) | (1L << (GROUPING - 162)) | (1L << (HASH - 162)) | (1L << (INDEX - 162)) | (1L << (INCREMENT - 162)) | (1L << (INPUT - 162)) | (1L << (INSERT - 162)) | (1L << (INTERSECTION - 162)) | (1L << (ISCACHABLE - 162)) | (1L << (ISODOW - 162)) | (1L << (ISOYEAR - 162)) | (1L << (ISSTRICT - 162)) | (1L << (LANGUAGE - 162)) | (1L << (LARGE - 162)) | (1L << (LAST - 162)) | (1L << (LESS - 162)) | (1L << (LIST - 162)) | (1L << (LOCATION - 162)) | (1L << (MATCH - 162)) | (1L << (MAX - 162)) | (1L << (MAXVALUE - 162)) | (1L << (MICROSECONDS - 162)) | (1L << (MILLENNIUM - 162)) | (1L << (MILLISECONDS - 162)) | (1L << (MIN - 162)) | (1L << (MINVALUE - 162)) | (1L << (MINUTE - 162)) | (1L << (MONTH - 162)) | (1L << (NATIONAL - 162)) | (1L << (NO - 162)) | (1L << (NONE - 162)) | (1L << (NULLIF - 162)) | (1L << (OBJECT - 162)) | (1L << (OPTION - 162)) | (1L << (OPTIONS - 162)) | (1L << (OVERWRITE - 162)) | (1L << (PARSER - 162)) | (1L << (PARTIAL - 162)) | (1L << (PARTITION - 162)) | (1L << (PARTITIONS - 162)) | (1L << (PRECISION - 162)) | (1L << (PUBLIC - 162)) | (1L << (PURGE - 162)) | (1L << (QUARTER - 162)) | (1L << (RANGE - 162)) | (1L << (REGEXP - 162)) | (1L << (RLIKE - 162)) | (1L << (ROLLUP - 162)) | (1L << (SEARCH - 162)) | (1L << (SECOND - 162)) | (1L << (SECURITY - 162)) | (1L << (SERVER - 162)) | (1L << (SET - 162)) | (1L << (SIMILAR - 162)) | (1L << (SIMPLE - 162)))) != 0) || ((((_la - 226)) & ~0x3f) == 0 && ((1L << (_la - 226)) & ((1L << (STABLE - 226)) | (1L << (START - 226)) | (1L << (STORAGE - 226)) | (1L << (STDDEV_POP - 226)) | (1L << (STDDEV_SAMP - 226)) | (1L << (SUBPARTITION - 226)) | (1L << (SUM - 226)) | (1L << (TABLESPACE - 226)) | (1L << (TEMPLATE - 226)) | (1L << (THAN - 226)) | (1L << (TIMEZONE - 226)) | (1L << (TIMEZONE_HOUR - 226)) | (1L << (TIMEZONE_MINUTE - 226)) | (1L << (TRIM - 226)) | (1L << (TO - 226)) | (1L << (UNKNOWN - 226)) | (1L << (UNLOGGED - 226)) | (1L << (VALUES - 226)) | (1L << (VAR_SAMP - 226)) | (1L << (VAR_POP - 226)) | (1L << (VARYING - 226)) | (1L << (VOLATILE - 226)) | (1L << (WEEK - 226)) | (1L << (WINDOW - 226)) | (1L << (WRAPPER - 226)) | (1L << (YEAR - 226)) | (1L << (ZONE - 226)) | (1L << (BOOLEAN - 226)) | (1L << (BOOL - 226)) | (1L << (BIT - 226)) | (1L << (VARBIT - 226)) | (1L << (INT1 - 226)) | (1L << (INT2 - 226)) | (1L << (INT4 - 226)) | (1L << (INT8 - 226)) | (1L << (TINYINT - 226)) | (1L << (SMALLINT - 226)) | (1L << (INT - 226)) | (1L << (INTEGER - 226)) | (1L << (BIGINT - 226)) | (1L << (FLOAT4 - 226)) | (1L << (FLOAT8 - 226)) | (1L << (REAL - 226)) | (1L << (FLOAT - 226)) | (1L << (DOUBLE - 226)) | (1L << (NUMERIC - 226)) | (1L << (DECIMAL - 226)) | (1L << (CHAR - 226)) | (1L << (VARCHAR - 226)) | (1L << (NCHAR - 226)) | (1L << (NVARCHAR - 226)) | (1L << (DATE - 226)) | (1L << (TIME - 226)) | (1L << (TIMETZ - 226)) | (1L << (TIMESTAMP - 226)) | (1L << (TIMESTAMPTZ - 226)) | (1L << (TEXT - 226)) | (1L << (VARBINARY - 226)) | (1L << (BLOB - 226)) | (1L << (BYTEA - 226)))) != 0) || ((((_la - 290)) & ~0x3f) == 0 && ((1L << (_la - 290)) & ((1L << (INET4 - 290)) | (1L << (LEFT_PAREN - 290)) | (1L << (QUOTE - 290)) | (1L << (NUMBER - 290)) | (1L << (REAL_NUMBER - 290)) | (1L << (Identifier - 290)) | (1L << (Character_String_Literal - 290)))) != 0)) {
						{
						setState(2761); ((Trim_operandsContext)_localctx).trim_character = character_value_expression();
						}
					}

					setState(2764); match(FROM);
					}
					break;
				}
				setState(2767); ((Trim_operandsContext)_localctx).trim_source = character_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2768); ((Trim_operandsContext)_localctx).trim_source = character_value_expression();
				setState(2769); match(COMMA);
				setState(2770); ((Trim_operandsContext)_localctx).trim_character = character_value_expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 248, RULE_trim_specification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2774);
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
		enterRule(_localctx, 250, RULE_boolean_value_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2776); or_predicate();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 252, RULE_or_predicate);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2778); and_predicate();
			setState(2783);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,391,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(2779); match(OR);
					setState(2780); or_predicate();
					}
					} 
				}
				setState(2785);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,391,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 254, RULE_and_predicate);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2786); boolean_factor();
			setState(2791);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,392,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(2787); match(AND);
					setState(2788); and_predicate();
					}
					} 
				}
				setState(2793);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,392,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 256, RULE_boolean_factor);
		try {
			setState(2797);
			switch ( getInterpreter().adaptivePredict(_input,393,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2794); boolean_test();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2795); match(NOT);
				setState(2796); boolean_test();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 258, RULE_boolean_test);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2799); boolean_primary();
			setState(2801);
			_la = _input.LA(1);
			if (_la==IS) {
				{
				setState(2800); is_clause();
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
		enterRule(_localctx, 260, RULE_is_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2803); match(IS);
			setState(2805);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(2804); match(NOT);
				}
			}

			setState(2807); ((Is_clauseContext)_localctx).t = truth_value();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 262, RULE_truth_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2809);
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
		enterRule(_localctx, 264, RULE_boolean_primary);
		try {
			setState(2813);
			switch ( getInterpreter().adaptivePredict(_input,396,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2811); predicate();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2812); boolean_predicand();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 266, RULE_boolean_predicand);
		try {
			setState(2817);
			switch ( getInterpreter().adaptivePredict(_input,397,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2815); parenthesized_boolean_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2816); nonparenthesized_value_expression_primary();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 268, RULE_parenthesized_boolean_value_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2819); match(LEFT_PAREN);
			setState(2820); boolean_value_expression();
			setState(2821); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 270, RULE_row_value_expression);
		try {
			setState(2825);
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
			case VARBINARY:
			case BLOB:
			case BYTEA:
			case INET4:
			case LEFT_PAREN:
			case QUOTE:
			case NUMBER:
			case REAL_NUMBER:
			case Identifier:
			case Character_String_Literal:
				enterOuterAlt(_localctx, 1);
				{
				setState(2823); row_value_special_case();
				}
				break;
			case NULL:
				enterOuterAlt(_localctx, 2);
				{
				setState(2824); explicit_row_value_constructor();
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
		enterRule(_localctx, 272, RULE_row_value_special_case);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2827); nonparenthesized_value_expression_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 274, RULE_explicit_row_value_constructor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2829); match(NULL);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 276, RULE_row_value_predicand);
		try {
			setState(2833);
			switch ( getInterpreter().adaptivePredict(_input,399,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2831); row_value_special_case();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2832); row_value_constructor_predicand();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 278, RULE_row_value_constructor_predicand);
		try {
			setState(2837);
			switch ( getInterpreter().adaptivePredict(_input,400,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2835); common_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2836); boolean_predicand();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 280, RULE_table_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2839); from_clause();
			setState(2841);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(2840); where_clause();
				}
			}

			setState(2844);
			_la = _input.LA(1);
			if (_la==GROUP) {
				{
				setState(2843); groupby_clause();
				}
			}

			setState(2847);
			_la = _input.LA(1);
			if (_la==HAVING) {
				{
				setState(2846); having_clause();
				}
			}

			setState(2850);
			_la = _input.LA(1);
			if (_la==ORDER) {
				{
				setState(2849); orderby_clause();
				}
			}

			setState(2853);
			_la = _input.LA(1);
			if (_la==LIMIT) {
				{
				setState(2852); limit_clause();
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
		enterRule(_localctx, 282, RULE_from_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2855); match(FROM);
			setState(2856); table_reference_list();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 284, RULE_table_reference_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2858); table_reference();
			setState(2863);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2859); match(COMMA);
				setState(2860); table_reference();
				}
				}
				setState(2865);
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
		enterRule(_localctx, 286, RULE_table_reference);
		try {
			setState(2868);
			switch ( getInterpreter().adaptivePredict(_input,407,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2866); joined_table();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2867); table_primary();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 288, RULE_joined_table);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2870); table_primary();
			setState(2872); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(2871); joined_table_primary();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(2874); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,408,_ctx);
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
		enterRule(_localctx, 290, RULE_joined_table_primary);
		int _la;
		try {
			setState(2895);
			switch (_input.LA(1)) {
			case CROSS:
				enterOuterAlt(_localctx, 1);
				{
				setState(2876); match(CROSS);
				setState(2877); match(JOIN);
				setState(2878); ((Joined_table_primaryContext)_localctx).right = table_primary();
				}
				break;
			case FULL:
			case INNER:
			case JOIN:
			case LEFT:
			case RIGHT:
				enterOuterAlt(_localctx, 2);
				{
				setState(2880);
				_la = _input.LA(1);
				if (((((_la - 43)) & ~0x3f) == 0 && ((1L << (_la - 43)) & ((1L << (FULL - 43)) | (1L << (INNER - 43)) | (1L << (LEFT - 43)) | (1L << (RIGHT - 43)))) != 0)) {
					{
					setState(2879); ((Joined_table_primaryContext)_localctx).t = join_type();
					}
				}

				setState(2882); match(JOIN);
				setState(2883); ((Joined_table_primaryContext)_localctx).right = table_primary();
				setState(2884); ((Joined_table_primaryContext)_localctx).s = join_specification();
				}
				break;
			case NATURAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(2886); match(NATURAL);
				setState(2888);
				_la = _input.LA(1);
				if (((((_la - 43)) & ~0x3f) == 0 && ((1L << (_la - 43)) & ((1L << (FULL - 43)) | (1L << (INNER - 43)) | (1L << (LEFT - 43)) | (1L << (RIGHT - 43)))) != 0)) {
					{
					setState(2887); ((Joined_table_primaryContext)_localctx).t = join_type();
					}
				}

				setState(2890); match(JOIN);
				setState(2891); ((Joined_table_primaryContext)_localctx).right = table_primary();
				}
				break;
			case UNION:
				enterOuterAlt(_localctx, 4);
				{
				setState(2892); match(UNION);
				setState(2893); match(JOIN);
				setState(2894); ((Joined_table_primaryContext)_localctx).right = table_primary();
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
		enterRule(_localctx, 292, RULE_cross_join);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2897); match(CROSS);
			setState(2898); match(JOIN);
			setState(2899); ((Cross_joinContext)_localctx).r = table_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 294, RULE_qualified_join);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2902);
			_la = _input.LA(1);
			if (((((_la - 43)) & ~0x3f) == 0 && ((1L << (_la - 43)) & ((1L << (FULL - 43)) | (1L << (INNER - 43)) | (1L << (LEFT - 43)) | (1L << (RIGHT - 43)))) != 0)) {
				{
				setState(2901); ((Qualified_joinContext)_localctx).t = join_type();
				}
			}

			setState(2904); match(JOIN);
			setState(2905); ((Qualified_joinContext)_localctx).r = table_primary();
			setState(2906); ((Qualified_joinContext)_localctx).s = join_specification();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 296, RULE_natural_join);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2908); match(NATURAL);
			setState(2910);
			_la = _input.LA(1);
			if (((((_la - 43)) & ~0x3f) == 0 && ((1L << (_la - 43)) & ((1L << (FULL - 43)) | (1L << (INNER - 43)) | (1L << (LEFT - 43)) | (1L << (RIGHT - 43)))) != 0)) {
				{
				setState(2909); ((Natural_joinContext)_localctx).t = join_type();
				}
			}

			setState(2912); match(JOIN);
			setState(2913); ((Natural_joinContext)_localctx).r = table_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 298, RULE_union_join);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2915); match(UNION);
			setState(2916); match(JOIN);
			setState(2917); ((Union_joinContext)_localctx).r = table_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 300, RULE_join_type);
		try {
			setState(2921);
			switch (_input.LA(1)) {
			case INNER:
				enterOuterAlt(_localctx, 1);
				{
				setState(2919); match(INNER);
				}
				break;
			case FULL:
			case LEFT:
			case RIGHT:
				enterOuterAlt(_localctx, 2);
				{
				setState(2920); ((Join_typeContext)_localctx).t = outer_join_type();
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
		enterRule(_localctx, 302, RULE_outer_join_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2923); outer_join_type_part2();
			setState(2925);
			_la = _input.LA(1);
			if (_la==OUTER) {
				{
				setState(2924); match(OUTER);
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
		enterRule(_localctx, 304, RULE_outer_join_type_part2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2927);
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
		enterRule(_localctx, 306, RULE_join_specification);
		try {
			setState(2931);
			switch (_input.LA(1)) {
			case ON:
				enterOuterAlt(_localctx, 1);
				{
				setState(2929); join_condition();
				}
				break;
			case USING:
				enterOuterAlt(_localctx, 2);
				{
				setState(2930); named_columns_join();
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
		enterRule(_localctx, 308, RULE_join_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2933); match(ON);
			setState(2934); search_condition();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 310, RULE_named_columns_join);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2936); match(USING);
			setState(2937); match(LEFT_PAREN);
			setState(2938); ((Named_columns_joinContext)_localctx).f = column_reference_list();
			setState(2939); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 312, RULE_table_primary);
		int _la;
		try {
			setState(2965);
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
			case VARBINARY:
			case BLOB:
			case BYTEA:
			case INET4:
			case QUOTE:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(2941); table_or_query_name();
				setState(2946);
				switch ( getInterpreter().adaptivePredict(_input,418,_ctx) ) {
				case 1:
					{
					setState(2943);
					_la = _input.LA(1);
					if (_la==AS) {
						{
						setState(2942); match(AS);
						}
					}

					setState(2945); ((Table_primaryContext)_localctx).alias = identifier();
					}
					break;
				}
				setState(2952);
				switch ( getInterpreter().adaptivePredict(_input,419,_ctx) ) {
				case 1:
					{
					setState(2948); match(LEFT_PAREN);
					setState(2949); column_name_list();
					setState(2950); match(RIGHT_PAREN);
					}
					break;
				}
				}
				break;
			case LEFT_PAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(2954); derived_table();
				setState(2956);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(2955); match(AS);
					}
				}

				setState(2958); ((Table_primaryContext)_localctx).name = identifier();
				setState(2963);
				switch ( getInterpreter().adaptivePredict(_input,421,_ctx) ) {
				case 1:
					{
					setState(2959); match(LEFT_PAREN);
					setState(2960); column_name_list();
					setState(2961); match(RIGHT_PAREN);
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
		enterRule(_localctx, 314, RULE_column_name_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2967); identifier();
			setState(2972);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2968); match(COMMA);
				setState(2969); identifier();
				}
				}
				setState(2974);
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
		enterRule(_localctx, 316, RULE_derived_table);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2975); table_subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 318, RULE_where_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2977); match(WHERE);
			setState(2978); search_condition();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 320, RULE_search_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2980); value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 322, RULE_groupby_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2982); match(GROUP);
			setState(2983); match(BY);
			setState(2984); ((Groupby_clauseContext)_localctx).g = grouping_element_list();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 324, RULE_grouping_element_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2986); grouping_element();
			setState(2991);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2987); match(COMMA);
				setState(2988); grouping_element();
				}
				}
				setState(2993);
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
		enterRule(_localctx, 326, RULE_grouping_element);
		try {
			setState(2998);
			switch ( getInterpreter().adaptivePredict(_input,425,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2994); rollup_list();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2995); cube_list();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2996); empty_grouping_set();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2997); ordinary_grouping_set();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 328, RULE_ordinary_grouping_set);
		try {
			setState(3005);
			switch ( getInterpreter().adaptivePredict(_input,426,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3000); row_value_predicand();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3001); match(LEFT_PAREN);
				setState(3002); row_value_predicand_list();
				setState(3003); match(RIGHT_PAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 330, RULE_ordinary_grouping_set_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3007); ordinary_grouping_set();
			setState(3012);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3008); match(COMMA);
				setState(3009); ordinary_grouping_set();
				}
				}
				setState(3014);
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
		enterRule(_localctx, 332, RULE_rollup_list);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3015); match(ROLLUP);
			setState(3016); match(LEFT_PAREN);
			setState(3017); ((Rollup_listContext)_localctx).c = ordinary_grouping_set_list();
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
		enterRule(_localctx, 334, RULE_cube_list);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3020); match(CUBE);
			setState(3021); match(LEFT_PAREN);
			setState(3022); ((Cube_listContext)_localctx).c = ordinary_grouping_set_list();
			setState(3023); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 336, RULE_empty_grouping_set);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3025); match(LEFT_PAREN);
			setState(3026); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 338, RULE_having_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3028); match(HAVING);
			setState(3029); boolean_value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 340, RULE_row_value_predicand_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3031); row_value_predicand();
			setState(3036);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3032); match(COMMA);
				setState(3033); row_value_predicand();
				}
				}
				setState(3038);
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
		enterRule(_localctx, 342, RULE_query_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3039); query_expression_body();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 344, RULE_query_expression_body);
		try {
			setState(3043);
			switch ( getInterpreter().adaptivePredict(_input,429,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3041); non_join_query_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3042); joined_table();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 346, RULE_non_join_query_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3053);
			switch ( getInterpreter().adaptivePredict(_input,431,_ctx) ) {
			case 1:
				{
				setState(3045); non_join_query_term();
				}
				break;
			case 2:
				{
				setState(3046); joined_table();
				setState(3047);
				_la = _input.LA(1);
				if ( !(_la==EXCEPT || _la==UNION) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(3049);
				_la = _input.LA(1);
				if (_la==ALL || _la==DISTINCT) {
					{
					setState(3048);
					_la = _input.LA(1);
					if ( !(_la==ALL || _la==DISTINCT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(3051); query_term();
				}
				break;
			}
			setState(3062);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==EXCEPT || _la==UNION) {
				{
				{
				setState(3055);
				_la = _input.LA(1);
				if ( !(_la==EXCEPT || _la==UNION) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(3057);
				_la = _input.LA(1);
				if (_la==ALL || _la==DISTINCT) {
					{
					setState(3056);
					_la = _input.LA(1);
					if ( !(_la==ALL || _la==DISTINCT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(3059); query_term();
				}
				}
				setState(3064);
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
		enterRule(_localctx, 348, RULE_query_term);
		try {
			setState(3067);
			switch ( getInterpreter().adaptivePredict(_input,434,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3065); non_join_query_term();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3066); joined_table();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 350, RULE_non_join_query_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3077);
			switch ( getInterpreter().adaptivePredict(_input,436,_ctx) ) {
			case 1:
				{
				setState(3069); non_join_query_primary();
				}
				break;
			case 2:
				{
				setState(3070); joined_table();
				setState(3071); match(INTERSECT);
				setState(3073);
				_la = _input.LA(1);
				if (_la==ALL || _la==DISTINCT) {
					{
					setState(3072);
					_la = _input.LA(1);
					if ( !(_la==ALL || _la==DISTINCT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(3075); query_primary();
				}
				break;
			}
			setState(3086);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==INTERSECT) {
				{
				{
				setState(3079); match(INTERSECT);
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

				setState(3083); query_primary();
				}
				}
				setState(3088);
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
		enterRule(_localctx, 352, RULE_query_primary);
		try {
			setState(3091);
			switch ( getInterpreter().adaptivePredict(_input,439,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3089); non_join_query_primary();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3090); joined_table();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 354, RULE_non_join_query_primary);
		try {
			setState(3098);
			switch (_input.LA(1)) {
			case SELECT:
			case TABLE:
				enterOuterAlt(_localctx, 1);
				{
				setState(3093); simple_table();
				}
				break;
			case LEFT_PAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(3094); match(LEFT_PAREN);
				setState(3095); non_join_query_expression();
				setState(3096); match(RIGHT_PAREN);
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
		enterRule(_localctx, 356, RULE_simple_table);
		try {
			setState(3102);
			switch (_input.LA(1)) {
			case SELECT:
				enterOuterAlt(_localctx, 1);
				{
				setState(3100); query_specification();
				}
				break;
			case TABLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(3101); explicit_table();
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
		enterRule(_localctx, 358, RULE_explicit_table);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3104); match(TABLE);
			setState(3105); table_or_query_name();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 360, RULE_table_or_query_name);
		try {
			setState(3109);
			switch ( getInterpreter().adaptivePredict(_input,442,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3107); schema_qualified_name();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3108); identifier();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 362, RULE_schema_qualified_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3111); identifier();
			setState(3118);
			_la = _input.LA(1);
			if (_la==DOT) {
				{
				setState(3112); match(DOT);
				setState(3113); identifier();
				setState(3116);
				_la = _input.LA(1);
				if (_la==DOT) {
					{
					setState(3114); match(DOT);
					setState(3115); identifier();
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
		enterRule(_localctx, 364, RULE_query_specification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3120); match(SELECT);
			setState(3122);
			_la = _input.LA(1);
			if (_la==ALL || _la==DISTINCT) {
				{
				setState(3121); set_qualifier();
				}
			}

			setState(3124); select_list();
			setState(3126);
			_la = _input.LA(1);
			if (_la==FROM) {
				{
				setState(3125); table_expression();
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
		enterRule(_localctx, 366, RULE_select_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3128); select_sublist();
			setState(3133);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3129); match(COMMA);
				setState(3130); select_sublist();
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
		enterRule(_localctx, 368, RULE_select_sublist);
		try {
			setState(3138);
			switch ( getInterpreter().adaptivePredict(_input,448,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3136); derived_column();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3137); qualified_asterisk();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 370, RULE_derived_column);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3140); value_expression();
			setState(3142);
			switch ( getInterpreter().adaptivePredict(_input,449,_ctx) ) {
			case 1:
				{
				setState(3141); as_clause();
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
		enterRule(_localctx, 372, RULE_qualified_asterisk);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3146);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(3144); ((Qualified_asteriskContext)_localctx).tb_name = match(Identifier);
				setState(3145); match(DOT);
				}
			}

			setState(3148); match(MULTIPLY);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 374, RULE_set_qualifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3150);
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
		enterRule(_localctx, 376, RULE_column_reference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3155);
			switch ( getInterpreter().adaptivePredict(_input,451,_ctx) ) {
			case 1:
				{
				setState(3152); ((Column_referenceContext)_localctx).tb_name = identifier();
				setState(3153); match(DOT);
				}
				break;
			}
			setState(3157); ((Column_referenceContext)_localctx).name = identifier();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 378, RULE_as_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3160);
			_la = _input.LA(1);
			if (_la==AS) {
				{
				setState(3159); match(AS);
				}
			}

			setState(3162); identifier();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 380, RULE_column_reference_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3164); column_reference();
			setState(3169);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3165); match(COMMA);
				setState(3166); column_reference();
				}
				}
				setState(3171);
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
		enterRule(_localctx, 382, RULE_scalar_subquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3172); subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 384, RULE_row_subquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3174); subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 386, RULE_table_subquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3176); subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 388, RULE_subquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3178); match(LEFT_PAREN);
			setState(3179); query_expression();
			setState(3180); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 390, RULE_predicate);
		try {
			setState(3188);
			switch ( getInterpreter().adaptivePredict(_input,454,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3182); comparison_predicate();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3183); between_predicate();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(3184); in_predicate();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(3185); pattern_matching_predicate();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(3186); null_predicate();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(3187); exists_predicate();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 392, RULE_comparison_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3190); ((Comparison_predicateContext)_localctx).left = row_value_predicand();
			setState(3191); ((Comparison_predicateContext)_localctx).c = comp_op();
			setState(3192); ((Comparison_predicateContext)_localctx).right = row_value_predicand();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 394, RULE_comp_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3194);
			_la = _input.LA(1);
			if ( !(((((_la - 297)) & ~0x3f) == 0 && ((1L << (_la - 297)) & ((1L << (EQUAL - 297)) | (1L << (NOT_EQUAL - 297)) | (1L << (LTH - 297)) | (1L << (LEQ - 297)) | (1L << (GTH - 297)) | (1L << (GEQ - 297)))) != 0)) ) {
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
		enterRule(_localctx, 396, RULE_between_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3196); ((Between_predicateContext)_localctx).predicand = row_value_predicand();
			setState(3197); between_predicate_part_2();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 398, RULE_between_predicate_part_2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3200);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(3199); match(NOT);
				}
			}

			setState(3202); match(BETWEEN);
			setState(3204);
			_la = _input.LA(1);
			if (_la==ASYMMETRIC || _la==SYMMETRIC) {
				{
				setState(3203);
				_la = _input.LA(1);
				if ( !(_la==ASYMMETRIC || _la==SYMMETRIC) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(3206); ((Between_predicate_part_2Context)_localctx).begin = row_value_predicand();
			setState(3207); match(AND);
			setState(3208); ((Between_predicate_part_2Context)_localctx).end = row_value_predicand();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 400, RULE_in_predicate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3210); ((In_predicateContext)_localctx).predicand = numeric_value_expression();
			setState(3212);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(3211); match(NOT);
				}
			}

			setState(3214); match(IN);
			setState(3215); in_predicate_value();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 402, RULE_in_predicate_value);
		try {
			setState(3222);
			switch ( getInterpreter().adaptivePredict(_input,458,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3217); table_subquery();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3218); match(LEFT_PAREN);
				setState(3219); in_value_list();
				setState(3220); match(RIGHT_PAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 404, RULE_in_value_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3224); row_value_expression();
			setState(3229);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3225); match(COMMA);
				setState(3226); row_value_expression();
				}
				}
				setState(3231);
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
		enterRule(_localctx, 406, RULE_pattern_matching_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3232); ((Pattern_matching_predicateContext)_localctx).f = row_value_predicand();
			setState(3233); pattern_matcher();
			setState(3234); ((Pattern_matching_predicateContext)_localctx).s = match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 408, RULE_pattern_matcher);
		int _la;
		try {
			setState(3241);
			switch (_input.LA(1)) {
			case ILIKE:
			case LIKE:
			case NOT:
			case REGEXP:
			case RLIKE:
			case SIMILAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(3237);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(3236); match(NOT);
					}
				}

				setState(3239); negativable_matcher();
				}
				break;
			case Similar_To:
			case Not_Similar_To:
			case Similar_To_Case_Insensitive:
			case Not_Similar_To_Case_Insensitive:
				enterOuterAlt(_localctx, 2);
				{
				setState(3240); regex_matcher();
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
		enterRule(_localctx, 410, RULE_negativable_matcher);
		try {
			setState(3249);
			switch (_input.LA(1)) {
			case LIKE:
				enterOuterAlt(_localctx, 1);
				{
				setState(3243); match(LIKE);
				}
				break;
			case ILIKE:
				enterOuterAlt(_localctx, 2);
				{
				setState(3244); match(ILIKE);
				}
				break;
			case SIMILAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(3245); match(SIMILAR);
				setState(3246); match(TO);
				}
				break;
			case REGEXP:
				enterOuterAlt(_localctx, 4);
				{
				setState(3247); match(REGEXP);
				}
				break;
			case RLIKE:
				enterOuterAlt(_localctx, 5);
				{
				setState(3248); match(RLIKE);
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
		enterRule(_localctx, 412, RULE_regex_matcher);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3251);
			_la = _input.LA(1);
			if ( !(((((_la - 291)) & ~0x3f) == 0 && ((1L << (_la - 291)) & ((1L << (Similar_To - 291)) | (1L << (Not_Similar_To - 291)) | (1L << (Similar_To_Case_Insensitive - 291)) | (1L << (Not_Similar_To_Case_Insensitive - 291)))) != 0)) ) {
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
		enterRule(_localctx, 414, RULE_null_predicate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3253); ((Null_predicateContext)_localctx).predicand = row_value_predicand();
			setState(3254); match(IS);
			setState(3256);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(3255); ((Null_predicateContext)_localctx).n = match(NOT);
				}
			}

			setState(3258); match(NULL);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 416, RULE_quantified_comparison_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3260); ((Quantified_comparison_predicateContext)_localctx).l = numeric_value_expression();
			setState(3261); ((Quantified_comparison_predicateContext)_localctx).c = comp_op();
			setState(3262); ((Quantified_comparison_predicateContext)_localctx).q = quantifier();
			setState(3263); ((Quantified_comparison_predicateContext)_localctx).s = table_subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 418, RULE_quantifier);
		try {
			setState(3267);
			switch (_input.LA(1)) {
			case ALL:
				enterOuterAlt(_localctx, 1);
				{
				setState(3265); all();
				}
				break;
			case ANY:
			case SOME:
				enterOuterAlt(_localctx, 2);
				{
				setState(3266); some();
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
		enterRule(_localctx, 420, RULE_all);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3269); match(ALL);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 422, RULE_some);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3271);
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
		enterRule(_localctx, 424, RULE_exists_predicate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3274);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(3273); match(NOT);
				}
			}

			setState(3276); match(EXISTS);
			setState(3277); ((Exists_predicateContext)_localctx).s = table_subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 426, RULE_unique_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3279); match(UNIQUE);
			setState(3280); ((Unique_predicateContext)_localctx).s = table_subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 428, RULE_primary_datetime_field);
		try {
			setState(3284);
			switch (_input.LA(1)) {
			case DAY:
			case HOUR:
			case MINUTE:
			case MONTH:
			case YEAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(3282); non_second_primary_datetime_field();
				}
				break;
			case SECOND:
				enterOuterAlt(_localctx, 2);
				{
				setState(3283); match(SECOND);
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
		enterRule(_localctx, 430, RULE_non_second_primary_datetime_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3286);
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
		enterRule(_localctx, 432, RULE_extended_datetime_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3288);
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
		enterRule(_localctx, 434, RULE_routine_invocation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3290); function_name();
			setState(3291); match(LEFT_PAREN);
			setState(3293);
			_la = _input.LA(1);
			if (((((_la - 6)) & ~0x3f) == 0 && ((1L << (_la - 6)) & ((1L << (ANY - 6)) | (1L << (CASE - 6)) | (1L << (CAST - 6)) | (1L << (FALSE - 6)) | (1L << (LEFT - 6)))) != 0) || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & ((1L << (NOT - 74)) | (1L << (NULL - 74)) | (1L << (RIGHT - 74)) | (1L << (SOME - 74)) | (1L << (TRUE - 74)) | (1L << (ADMIN - 74)) | (1L << (AVG - 74)) | (1L << (BETWEEN - 74)) | (1L << (BY - 74)) | (1L << (CACHE - 74)) | (1L << (CALLED - 74)) | (1L << (CLASS - 74)) | (1L << (CENTURY - 74)) | (1L << (CHARACTER - 74)))) != 0) || ((((_la - 138)) & ~0x3f) == 0 && ((1L << (_la - 138)) & ((1L << (CHECK - 138)) | (1L << (COLLECT - 138)) | (1L << (COALESCE - 138)) | (1L << (COLUMN - 138)) | (1L << (COMMENT - 138)) | (1L << (COMMENTS - 138)) | (1L << (COMMIT - 138)) | (1L << (CONFIGURATION - 138)) | (1L << (COST - 138)) | (1L << (COUNT - 138)) | (1L << (CUBE - 138)) | (1L << (CURRENT - 138)) | (1L << (CYCLE - 138)) | (1L << (DATA - 138)) | (1L << (DAY - 138)) | (1L << (DEC - 138)) | (1L << (DECADE - 138)) | (1L << (DEFINER - 138)) | (1L << (DICTIONARY - 138)) | (1L << (DOW - 138)) | (1L << (DOY - 138)) | (1L << (DROP - 138)) | (1L << (EPOCH - 138)) | (1L << (EVERY - 138)) | (1L << (EXISTS - 138)) | (1L << (EXTERNAL - 138)) | (1L << (EXTRACT - 138)) | (1L << (FAMILY - 138)) | (1L << (FILTER - 138)) | (1L << (FIRST - 138)) | (1L << (FORMAT - 138)) | (1L << (FUSION - 138)) | (1L << (GROUPING - 138)) | (1L << (HASH - 138)) | (1L << (INDEX - 138)) | (1L << (INCREMENT - 138)) | (1L << (INPUT - 138)) | (1L << (INSERT - 138)) | (1L << (INTERSECTION - 138)) | (1L << (ISCACHABLE - 138)) | (1L << (ISODOW - 138)) | (1L << (ISOYEAR - 138)) | (1L << (ISSTRICT - 138)) | (1L << (LANGUAGE - 138)) | (1L << (LARGE - 138)) | (1L << (LAST - 138)) | (1L << (LESS - 138)) | (1L << (LIST - 138)) | (1L << (LOCATION - 138)) | (1L << (MATCH - 138)) | (1L << (MAX - 138)) | (1L << (MAXVALUE - 138)) | (1L << (MICROSECONDS - 138)) | (1L << (MILLENNIUM - 138)) | (1L << (MILLISECONDS - 138)) | (1L << (MIN - 138)) | (1L << (MINVALUE - 138)) | (1L << (MINUTE - 138)) | (1L << (MONTH - 138)) | (1L << (NATIONAL - 138)) | (1L << (NO - 138)) | (1L << (NONE - 138)))) != 0) || ((((_la - 202)) & ~0x3f) == 0 && ((1L << (_la - 202)) & ((1L << (NULLIF - 202)) | (1L << (OBJECT - 202)) | (1L << (OPTION - 202)) | (1L << (OPTIONS - 202)) | (1L << (OVERWRITE - 202)) | (1L << (PARSER - 202)) | (1L << (PARTIAL - 202)) | (1L << (PARTITION - 202)) | (1L << (PARTITIONS - 202)) | (1L << (PRECISION - 202)) | (1L << (PUBLIC - 202)) | (1L << (PURGE - 202)) | (1L << (QUARTER - 202)) | (1L << (RANGE - 202)) | (1L << (REGEXP - 202)) | (1L << (RLIKE - 202)) | (1L << (ROLLUP - 202)) | (1L << (SEARCH - 202)) | (1L << (SECOND - 202)) | (1L << (SECURITY - 202)) | (1L << (SERVER - 202)) | (1L << (SET - 202)) | (1L << (SIMILAR - 202)) | (1L << (SIMPLE - 202)) | (1L << (STABLE - 202)) | (1L << (START - 202)) | (1L << (STORAGE - 202)) | (1L << (STDDEV_POP - 202)) | (1L << (STDDEV_SAMP - 202)) | (1L << (SUBPARTITION - 202)) | (1L << (SUM - 202)) | (1L << (TABLESPACE - 202)) | (1L << (TEMPLATE - 202)) | (1L << (THAN - 202)) | (1L << (TIMEZONE - 202)) | (1L << (TIMEZONE_HOUR - 202)) | (1L << (TIMEZONE_MINUTE - 202)) | (1L << (TRIM - 202)) | (1L << (TO - 202)) | (1L << (UNKNOWN - 202)) | (1L << (UNLOGGED - 202)) | (1L << (VALUES - 202)) | (1L << (VAR_SAMP - 202)) | (1L << (VAR_POP - 202)) | (1L << (VARYING - 202)) | (1L << (VOLATILE - 202)) | (1L << (WEEK - 202)) | (1L << (WINDOW - 202)) | (1L << (WRAPPER - 202)) | (1L << (YEAR - 202)) | (1L << (ZONE - 202)) | (1L << (BOOLEAN - 202)) | (1L << (BOOL - 202)) | (1L << (BIT - 202)) | (1L << (VARBIT - 202)) | (1L << (INT1 - 202)) | (1L << (INT2 - 202)) | (1L << (INT4 - 202)) | (1L << (INT8 - 202)) | (1L << (TINYINT - 202)) | (1L << (SMALLINT - 202)) | (1L << (INT - 202)))) != 0) || ((((_la - 266)) & ~0x3f) == 0 && ((1L << (_la - 266)) & ((1L << (INTEGER - 266)) | (1L << (BIGINT - 266)) | (1L << (FLOAT4 - 266)) | (1L << (FLOAT8 - 266)) | (1L << (REAL - 266)) | (1L << (FLOAT - 266)) | (1L << (DOUBLE - 266)) | (1L << (NUMERIC - 266)) | (1L << (DECIMAL - 266)) | (1L << (CHAR - 266)) | (1L << (VARCHAR - 266)) | (1L << (NCHAR - 266)) | (1L << (NVARCHAR - 266)) | (1L << (DATE - 266)) | (1L << (TIME - 266)) | (1L << (TIMETZ - 266)) | (1L << (TIMESTAMP - 266)) | (1L << (TIMESTAMPTZ - 266)) | (1L << (TEXT - 266)) | (1L << (VARBINARY - 266)) | (1L << (BLOB - 266)) | (1L << (BYTEA - 266)) | (1L << (INET4 - 266)) | (1L << (LEFT_PAREN - 266)) | (1L << (PLUS - 266)) | (1L << (MINUS - 266)) | (1L << (QUOTE - 266)) | (1L << (NUMBER - 266)) | (1L << (REAL_NUMBER - 266)) | (1L << (Identifier - 266)) | (1L << (Character_String_Literal - 266)))) != 0)) {
				{
				setState(3292); sql_argument_list();
				}
			}

			setState(3295); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 436, RULE_function_names_for_reserved_words);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3297);
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
		enterRule(_localctx, 438, RULE_function_name);
		try {
			setState(3301);
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
			case VARBINARY:
			case BLOB:
			case BYTEA:
			case INET4:
			case QUOTE:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(3299); identifier();
				}
				break;
			case LEFT:
			case RIGHT:
				enterOuterAlt(_localctx, 2);
				{
				setState(3300); function_names_for_reserved_words();
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
		enterRule(_localctx, 440, RULE_sql_argument_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3303); value_expression();
			setState(3308);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3304); match(COMMA);
				setState(3305); value_expression();
				}
				}
				setState(3310);
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
		enterRule(_localctx, 442, RULE_orderby_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3311); match(ORDER);
			setState(3312); match(BY);
			setState(3313); sort_specifier_list();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 444, RULE_sort_specifier_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3315); sort_specifier();
			setState(3320);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3316); match(COMMA);
				setState(3317); sort_specifier();
				}
				}
				setState(3322);
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
		enterRule(_localctx, 446, RULE_sort_specifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3323); ((Sort_specifierContext)_localctx).key = row_value_predicand();
			setState(3325);
			_la = _input.LA(1);
			if (_la==ASC || _la==DESC) {
				{
				setState(3324); ((Sort_specifierContext)_localctx).order = order_specification();
				}
			}

			setState(3328);
			_la = _input.LA(1);
			if (_la==NULL) {
				{
				setState(3327); ((Sort_specifierContext)_localctx).null_order = null_ordering();
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
		enterRule(_localctx, 448, RULE_order_specification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3330);
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
		enterRule(_localctx, 450, RULE_limit_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3332); match(LIMIT);
			setState(3333); ((Limit_clauseContext)_localctx).e = numeric_value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 452, RULE_null_ordering);
		try {
			setState(3339);
			switch ( getInterpreter().adaptivePredict(_input,473,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3335); match(NULL);
				setState(3336); match(FIRST);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3337); match(NULL);
				setState(3338); match(LAST);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 454, RULE_insert_statement);
		int _la;
		try {
			setState(3370);
			switch ( getInterpreter().adaptivePredict(_input,479,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3341); match(INSERT);
				setState(3343);
				_la = _input.LA(1);
				if (_la==OVERWRITE) {
					{
					setState(3342); match(OVERWRITE);
					}
				}

				setState(3345); match(INTO);
				setState(3346); schema_qualified_name();
				setState(3351);
				switch ( getInterpreter().adaptivePredict(_input,475,_ctx) ) {
				case 1:
					{
					setState(3347); match(LEFT_PAREN);
					setState(3348); column_name_list();
					setState(3349); match(RIGHT_PAREN);
					}
					break;
				}
				setState(3353); query_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3355); match(INSERT);
				setState(3357);
				_la = _input.LA(1);
				if (_la==OVERWRITE) {
					{
					setState(3356); match(OVERWRITE);
					}
				}

				setState(3359); match(INTO);
				setState(3360); match(LOCATION);
				setState(3361); ((Insert_statementContext)_localctx).path = match(Character_String_Literal);
				setState(3367);
				_la = _input.LA(1);
				if (_la==USING) {
					{
					setState(3362); match(USING);
					setState(3363); ((Insert_statementContext)_localctx).file_type = identifier();
					setState(3365);
					_la = _input.LA(1);
					if (_la==WITH) {
						{
						setState(3364); param_clause();
						}
					}

					}
				}

				setState(3369); query_expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\u014c\u0d2f\4\2\t"+
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
		"\4\u00e4\t\u00e4\4\u00e5\t\u00e5\3\2\3\2\5\2\u01cd\n\2\7\2\u01cf\n\2\f"+
		"\2\16\2\u01d2\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\5\3\u01e3\n\3\3\4\3\4\3\5\3\5\3\6\3\6\5\6\u01eb\n\6\3\7\3\7\5"+
		"\7\u01ef\n\7\3\7\3\7\3\7\3\7\3\7\5\7\u01f6\n\7\3\7\3\7\3\7\3\7\5\7\u01fc"+
		"\n\7\3\b\3\b\3\b\3\b\3\b\5\b\u0203\n\b\3\b\3\b\5\b\u0207\n\b\3\b\3\b\5"+
		"\b\u020b\n\b\3\b\3\b\5\b\u020f\n\b\3\b\3\b\5\b\u0213\n\b\3\t\3\t\5\t\u0217"+
		"\n\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u0221\n\t\3\t\5\t\u0224\n\t\6"+
		"\t\u0226\n\t\r\t\16\t\u0227\3\t\3\t\5\t\u022c\n\t\3\t\3\t\3\t\3\t\3\t"+
		"\5\t\u0233\n\t\3\t\5\t\u0236\n\t\6\t\u0238\n\t\r\t\16\t\u0239\5\t\u023c"+
		"\n\t\3\n\3\n\5\n\u0240\n\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u0248\n\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\5\n\u0251\n\n\6\n\u0253\n\n\r\n\16\n\u0254\5\n"+
		"\u0257\n\n\5\n\u0259\n\n\3\n\3\n\3\n\3\n\5\n\u025f\n\n\3\n\3\n\3\n\5\n"+
		"\u0264\n\n\3\n\3\n\3\n\3\n\5\n\u026a\n\n\3\n\3\n\5\n\u026e\n\n\3\n\3\n"+
		"\5\n\u0272\n\n\3\n\3\n\5\n\u0276\n\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u027e"+
		"\n\n\5\n\u0280\n\n\3\n\3\n\3\13\3\13\3\13\3\13\5\13\u0288\n\13\3\13\6"+
		"\13\u028b\n\13\r\13\16\13\u028c\3\13\3\13\5\13\u0291\n\13\5\13\u0293\n"+
		"\13\3\13\3\13\5\13\u0297\n\13\3\13\6\13\u029a\n\13\r\13\16\13\u029b\3"+
		"\13\3\13\3\13\3\13\3\13\6\13\u02a3\n\13\r\13\16\13\u02a4\5\13\u02a7\n"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u02af\n\13\3\13\3\13\3\13\3\13"+
		"\5\13\u02b5\n\13\6\13\u02b7\n\13\r\13\16\13\u02b8\3\13\3\13\6\13\u02bd"+
		"\n\13\r\13\16\13\u02be\3\13\3\13\5\13\u02c3\n\13\3\13\3\13\3\13\5\13\u02c8"+
		"\n\13\6\13\u02ca\n\13\r\13\16\13\u02cb\3\13\3\13\5\13\u02d0\n\13\3\13"+
		"\3\13\5\13\u02d4\n\13\3\13\3\13\5\13\u02d8\n\13\6\13\u02da\n\13\r\13\16"+
		"\13\u02db\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u02e4\n\13\3\13\6\13\u02e7"+
		"\n\13\r\13\16\13\u02e8\3\13\3\13\5\13\u02ed\n\13\5\13\u02ef\n\13\3\13"+
		"\3\13\3\13\3\13\5\13\u02f5\n\13\6\13\u02f7\n\13\r\13\16\13\u02f8\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\5\13\u0301\n\13\6\13\u0303\n\13\r\13\16\13\u0304"+
		"\5\13\u0307\n\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u030f\n\13\3\13\6"+
		"\13\u0312\n\13\r\13\16\13\u0313\3\13\3\13\5\13\u0318\n\13\5\13\u031a\n"+
		"\13\3\13\3\13\3\13\3\13\5\13\u0320\n\13\6\13\u0322\n\13\r\13\16\13\u0323"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u032c\n\13\3\13\3\13\3\13\5\13\u0331"+
		"\n\13\5\13\u0333\n\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u033b\n\13\6"+
		"\13\u033d\n\13\r\13\16\13\u033e\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u0347"+
		"\n\13\3\13\3\13\3\13\5\13\u034c\n\13\5\13\u034e\n\13\3\13\3\13\3\13\3"+
		"\13\3\13\5\13\u0355\n\13\6\13\u0357\n\13\r\13\16\13\u0358\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\5\13\u0361\n\13\3\13\3\13\3\13\5\13\u0366\n\13\5\13"+
		"\u0368\n\13\3\13\3\13\3\13\5\13\u036d\n\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\5\13\u0375\n\13\3\13\3\13\3\13\5\13\u037a\n\13\5\13\u037c\n\13\3\13"+
		"\3\13\3\13\3\13\5\13\u0382\n\13\6\13\u0384\n\13\r\13\16\13\u0385\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\5\13\u038e\n\13\3\13\3\13\3\13\5\13\u0393\n"+
		"\13\6\13\u0395\n\13\r\13\16\13\u0396\3\13\3\13\5\13\u039b\n\13\5\13\u039d"+
		"\n\13\3\13\3\13\3\13\3\13\3\13\5\13\u03a4\n\13\6\13\u03a6\n\13\r\13\16"+
		"\13\u03a7\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u03b0\n\13\3\13\3\13\5\13"+
		"\u03b4\n\13\6\13\u03b6\n\13\r\13\16\13\u03b7\3\13\3\13\5\13\u03bc\n\13"+
		"\5\13\u03be\n\13\3\13\3\13\3\13\3\13\5\13\u03c4\n\13\6\13\u03c6\n\13\r"+
		"\13\16\13\u03c7\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u03d0\n\13\3\13\3\13"+
		"\3\13\5\13\u03d5\n\13\5\13\u03d7\n\13\3\13\3\13\3\13\3\13\5\13\u03dd\n"+
		"\13\6\13\u03df\n\13\r\13\16\13\u03e0\3\13\3\13\3\13\3\13\3\13\3\13\5\13"+
		"\u03e9\n\13\3\13\3\13\5\13\u03ed\n\13\6\13\u03ef\n\13\r\13\16\13\u03f0"+
		"\3\13\3\13\3\13\5\13\u03f6\n\13\6\13\u03f8\n\13\r\13\16\13\u03f9\3\13"+
		"\5\13\u03fd\n\13\5\13\u03ff\n\13\3\f\3\f\5\f\u0403\n\f\3\f\3\f\3\f\5\f"+
		"\u0408\n\f\6\f\u040a\n\f\r\f\16\f\u040b\3\f\5\f\u040f\n\f\3\r\3\r\6\r"+
		"\u0413\n\r\r\r\16\r\u0414\3\r\3\r\5\r\u0419\n\r\5\r\u041b\n\r\3\r\3\r"+
		"\5\r\u041f\n\r\3\r\3\r\5\r\u0423\n\r\6\r\u0425\n\r\r\r\16\r\u0426\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\5\r\u042f\n\r\6\r\u0431\n\r\r\r\16\r\u0432\5\r\u0435"+
		"\n\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u043d\n\r\6\r\u043f\n\r\r\r\16\r\u0440"+
		"\6\r\u0443\n\r\r\r\16\r\u0444\3\r\3\r\5\r\u0449\n\r\3\r\3\r\5\r\u044d"+
		"\n\r\6\r\u044f\n\r\r\r\16\r\u0450\5\r\u0453\n\r\3\r\3\r\5\r\u0457\n\r"+
		"\3\r\3\r\5\r\u045b\n\r\6\r\u045d\n\r\r\r\16\r\u045e\3\r\3\r\3\r\3\r\3"+
		"\r\5\r\u0466\n\r\6\r\u0468\n\r\r\r\16\r\u0469\3\r\3\r\5\r\u046e\n\r\5"+
		"\r\u0470\n\r\3\r\3\r\3\r\3\r\5\r\u0476\n\r\6\r\u0478\n\r\r\r\16\r\u0479"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u0482\n\r\6\r\u0484\n\r\r\r\16\r\u0485\5"+
		"\r\u0488\n\r\3\r\3\r\3\r\3\r\3\r\5\r\u048f\n\r\6\r\u0491\n\r\r\r\16\r"+
		"\u0492\3\r\3\r\5\r\u0497\n\r\5\r\u0499\n\r\3\r\3\r\3\r\3\r\5\r\u049f\n"+
		"\r\6\r\u04a1\n\r\r\r\16\r\u04a2\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u04ab\n\r"+
		"\5\r\u04ad\n\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u04b5\n\r\6\r\u04b7\n\r\r\r"+
		"\16\r\u04b8\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u04c1\n\r\5\r\u04c3\n\r\3\r\3"+
		"\r\3\r\3\r\3\r\5\r\u04ca\n\r\6\r\u04cc\n\r\r\r\16\r\u04cd\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\5\r\u04d6\n\r\5\r\u04d8\n\r\3\r\3\r\3\r\5\r\u04dd\n\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\5\r\u04e5\n\r\5\r\u04e7\n\r\3\r\3\r\3\r\3\r\5\r\u04ed"+
		"\n\r\6\r\u04ef\n\r\r\r\16\r\u04f0\3\r\3\r\3\r\3\r\3\r\5\r\u04f8\n\r\6"+
		"\r\u04fa\n\r\r\r\16\r\u04fb\3\r\3\r\5\r\u0500\n\r\5\r\u0502\n\r\3\r\3"+
		"\r\3\r\3\r\3\r\5\r\u0509\n\r\6\r\u050b\n\r\r\r\16\r\u050c\3\r\3\r\3\r"+
		"\3\r\3\r\5\r\u0514\n\r\6\r\u0516\n\r\r\r\16\r\u0517\3\r\3\r\5\r\u051c"+
		"\n\r\5\r\u051e\n\r\3\r\3\r\3\r\3\r\5\r\u0524\n\r\6\r\u0526\n\r\r\r\16"+
		"\r\u0527\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u0530\n\r\5\r\u0532\n\r\3\r\3\r\3"+
		"\r\3\r\5\r\u0538\n\r\6\r\u053a\n\r\r\r\16\r\u053b\3\r\3\r\3\r\3\r\5\r"+
		"\u0542\n\r\6\r\u0544\n\r\r\r\16\r\u0545\3\r\3\r\3\r\5\r\u054b\n\r\6\r"+
		"\u054d\n\r\r\r\16\r\u054e\3\r\3\r\3\r\5\r\u0554\n\r\5\r\u0556\n\r\3\16"+
		"\3\16\5\16\u055a\n\16\3\16\3\16\5\16\u055e\n\16\3\16\5\16\u0561\n\16\6"+
		"\16\u0563\n\16\r\16\16\16\u0564\3\16\3\16\3\16\5\16\u056a\n\16\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\5\17\u0573\n\17\7\17\u0575\n\17\f\17\16\17"+
		"\u0578\13\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u05b7\n\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17"+
		"\u05e5\n\17\3\17\3\17\3\17\3\20\3\20\3\20\5\20\u05ed\n\20\3\20\3\20\3"+
		"\20\3\20\5\20\u05f3\n\20\3\20\5\20\u05f6\n\20\3\20\3\20\3\20\3\20\3\20"+
		"\5\20\u05fd\n\20\6\20\u05ff\n\20\r\20\16\20\u0600\5\20\u0603\n\20\5\20"+
		"\u0605\n\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u0610\n"+
		"\20\6\20\u0612\n\20\r\20\16\20\u0613\3\20\3\20\5\20\u0618\n\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\5\20\u062b\n\20\3\20\3\20\3\20\5\20\u0630\n\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u0640\n\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\6\20\u0648\n\20\r\20\16\20\u0649\3\20\3"+
		"\20\3\20\3\20\5\20\u0650\n\20\6\20\u0652\n\20\r\20\16\20\u0653\3\20\3"+
		"\20\5\20\u0658\n\20\3\21\3\21\7\21\u065c\n\21\f\21\16\21\u065f\13\21\3"+
		"\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\24\5\24\u066b\n\24\3\24"+
		"\5\24\u066e\n\24\3\24\3\24\5\24\u0672\n\24\7\24\u0674\n\24\f\24\16\24"+
		"\u0677\13\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u0681\n\25\6"+
		"\25\u0683\n\25\r\25\16\25\u0684\3\26\3\26\5\26\u0689\n\26\3\26\3\26\3"+
		"\26\3\26\5\26\u068f\n\26\3\26\3\26\3\26\3\26\3\26\5\26\u0696\n\26\3\26"+
		"\3\26\3\26\3\26\5\26\u069c\n\26\3\26\3\26\5\26\u06a0\n\26\3\26\3\26\3"+
		"\26\3\26\5\26\u06a6\n\26\3\26\3\26\3\26\3\26\3\26\5\26\u06ad\n\26\7\26"+
		"\u06af\n\26\f\26\16\26\u06b2\13\26\3\27\3\27\3\27\3\27\3\27\5\27\u06b9"+
		"\n\27\3\27\7\27\u06bc\n\27\f\27\16\27\u06bf\13\27\3\27\3\27\3\27\3\27"+
		"\3\27\7\27\u06c6\n\27\f\27\16\27\u06c9\13\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\5\27\u06d3\n\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27"+
		"\u06dc\n\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u06e6\n\30\3"+
		"\30\5\30\u06e9\n\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30"+
		"\u06f4\n\30\3\30\5\30\u06f7\n\30\3\30\5\30\u06fa\n\30\3\30\3\30\5\30\u06fe"+
		"\n\30\3\30\3\30\3\30\3\30\3\30\5\30\u0705\n\30\3\30\5\30\u0708\n\30\3"+
		"\30\5\30\u070b\n\30\3\30\3\30\3\30\3\30\3\30\5\30\u0712\n\30\3\30\3\30"+
		"\5\30\u0716\n\30\3\30\3\30\3\30\3\30\5\30\u071c\n\30\3\30\3\30\3\30\3"+
		"\30\3\30\3\30\5\30\u0724\n\30\3\30\7\30\u0727\n\30\f\30\16\30\u072a\13"+
		"\30\3\30\3\30\3\30\3\30\7\30\u0730\n\30\f\30\16\30\u0733\13\30\5\30\u0735"+
		"\n\30\3\30\5\30\u0738\n\30\6\30\u073a\n\30\r\30\16\30\u073b\5\30\u073e"+
		"\n\30\3\30\3\30\3\30\3\30\3\30\5\30\u0745\n\30\6\30\u0747\n\30\r\30\16"+
		"\30\u0748\3\30\3\30\5\30\u074d\n\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30"+
		"\u0755\n\30\3\30\3\30\5\30\u0759\n\30\3\30\3\30\3\30\3\30\5\30\u075f\n"+
		"\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\7\30\u0769\n\30\f\30\16\30"+
		"\u076c\13\30\3\30\5\30\u076f\n\30\3\30\5\30\u0772\n\30\6\30\u0774\n\30"+
		"\r\30\16\30\u0775\3\30\3\30\5\30\u077a\n\30\3\30\3\30\3\30\3\30\5\30\u0780"+
		"\n\30\3\31\3\31\3\31\3\32\3\32\5\32\u0787\n\32\3\32\3\32\3\32\3\32\3\32"+
		"\5\32\u078e\n\32\6\32\u0790\n\32\r\32\16\32\u0791\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\5\32\u079c\n\32\6\32\u079e\n\32\r\32\16\32\u079f"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u07a8\n\32\3\32\3\32\3\32\3\32\3\32"+
		"\5\32\u07af\n\32\6\32\u07b1\n\32\r\32\16\32\u07b2\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\5\32\u07bc\n\32\3\32\3\32\3\32\3\32\3\32\5\32\u07c3\n"+
		"\32\6\32\u07c5\n\32\r\32\16\32\u07c6\3\32\3\32\3\32\3\32\3\32\3\32\5\32"+
		"\u07cf\n\32\6\32\u07d1\n\32\r\32\16\32\u07d2\3\32\3\32\5\32\u07d7\n\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u07df\n\32\3\32\3\32\3\32\5\32\u07e4"+
		"\n\32\3\32\3\32\3\32\5\32\u07e9\n\32\5\32\u07eb\n\32\3\32\3\32\3\32\5"+
		"\32\u07f0\n\32\3\32\3\32\3\32\3\32\5\32\u07f6\n\32\3\33\3\33\5\33\u07fa"+
		"\n\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u0810\n\33\3\33\3\33\3\33\5\33"+
		"\u0815\n\33\3\33\3\33\3\33\5\33\u081a\n\33\5\33\u081c\n\33\3\33\3\33\3"+
		"\33\5\33\u0821\n\33\3\33\3\33\3\33\3\33\5\33\u0827\n\33\3\34\3\34\3\34"+
		"\3\34\3\34\3\35\3\35\3\35\3\35\3\35\5\35\u0833\n\35\3\35\5\35\u0836\n"+
		"\35\6\35\u0838\n\35\r\35\16\35\u0839\3\35\3\35\3\36\3\36\3\36\3\36\3\36"+
		"\5\36\u0843\n\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\5\37\u084c\n\37\5"+
		"\37\u084e\n\37\3 \3 \5 \u0852\n \3!\3!\3!\3!\3!\3!\5!\u085a\n!\3\"\5\""+
		"\u085d\n\"\3\"\3\"\3\"\3\"\5\"\u0863\n\"\3#\3#\3#\3#\7#\u0869\n#\f#\16"+
		"#\u086c\13#\3#\3#\3$\3$\3$\3%\3%\3&\3&\3&\3&\3&\7&\u087a\n&\f&\16&\u087d"+
		"\13&\3&\3&\3\'\3\'\3\'\3\'\3(\3(\3(\3)\3)\3)\3*\3*\3+\3+\3+\3+\5+\u0891"+
		"\n+\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3-\3-\3-\7-\u08a0\n-\f-\16-\u08a3\13"+
		"-\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\5.\u08af\n.\3.\3.\5.\u08b3\n.\5.\u08b5"+
		"\n.\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\5/\u08c2\n/\3\60\3\60\3\60\7\60\u08c7"+
		"\n\60\f\60\16\60\u08ca\13\60\3\61\3\61\3\61\3\62\3\62\3\62\3\63\3\63\3"+
		"\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\64\3\64\3\64\7\64\u08df\n\64"+
		"\f\64\16\64\u08e2\13\64\3\65\3\65\3\65\3\65\5\65\u08e8\n\65\3\65\3\65"+
		"\3\65\3\65\3\66\3\66\3\66\3\66\3\66\3\67\3\67\38\38\38\38\58\u08f9\n8"+
		"\39\59\u08fc\n9\39\39\59\u0900\n9\39\59\u0903\n9\3:\3:\3;\3;\5;\u0909"+
		"\n;\3<\3<\3<\5<\u090e\n<\3=\3=\3=\5=\u0913\n=\3>\3>\3>\3?\3?\3?\3@\3@"+
		"\3@\3A\3A\3B\3B\3C\3C\3C\3C\3C\3C\3C\3C\3C\3C\3C\5C\u092d\nC\3D\3D\3E"+
		"\3E\3F\3F\5F\u0935\nF\3F\3F\5F\u0939\nF\3F\3F\3F\5F\u093e\nF\3F\3F\3F"+
		"\5F\u0943\nF\3F\3F\5F\u0947\nF\3F\5F\u094a\nF\3G\3G\3G\3G\3H\3H\3H\5H"+
		"\u0953\nH\3H\3H\3H\5H\u0958\nH\3H\3H\5H\u095c\nH\3H\3H\3H\3H\5H\u0962"+
		"\nH\3H\3H\3H\3H\5H\u0968\nH\3H\3H\3H\5H\u096d\nH\3H\3H\5H\u0971\nH\5H"+
		"\u0973\nH\3I\3I\5I\u0977\nI\3I\3I\5I\u097b\nI\5I\u097d\nI\3J\3J\5J\u0981"+
		"\nJ\3K\3K\5K\u0985\nK\3K\3K\5K\u0989\nK\3K\3K\5K\u098d\nK\3K\3K\3K\3K"+
		"\3K\3K\3K\3K\3K\5K\u0998\nK\3L\3L\5L\u099c\nL\3L\3L\3L\3L\3L\3L\5L\u09a4"+
		"\nL\3M\3M\3M\3M\3M\3M\3M\3M\5M\u09ae\nM\3N\3N\3O\3O\3O\3O\3O\3O\3O\3O"+
		"\3O\3O\3O\3O\3O\5O\u09bf\nO\3P\3P\5P\u09c3\nP\3P\3P\5P\u09c7\nP\3P\3P"+
		"\3P\5P\u09cc\nP\5P\u09ce\nP\3Q\3Q\5Q\u09d2\nQ\3Q\3Q\3Q\5Q\u09d7\nQ\3Q"+
		"\3Q\5Q\u09db\nQ\5Q\u09dd\nQ\3R\3R\5R\u09e1\nR\3S\3S\3S\3S\3T\3T\3T\3T"+
		"\3T\3T\3T\5T\u09ee\nT\3U\3U\3V\3V\3W\5W\u09f5\nW\3W\3W\3X\3X\3Y\3Y\3Y"+
		"\3Y\3Y\3Y\5Y\u0a01\nY\5Y\u0a03\nY\3Z\3Z\3Z\5Z\u0a08\nZ\3Z\3Z\3Z\3[\3["+
		"\3\\\3\\\3\\\3\\\3\\\3\\\3]\3]\3]\3]\3]\3^\3^\3_\3_\3_\3_\3_\3_\3_\3_"+
		"\3_\3_\3_\3_\6_\u0a28\n_\r_\16_\u0a29\3_\3_\5_\u0a2e\n_\3`\3`\5`\u0a32"+
		"\n`\3a\3a\3a\6a\u0a37\na\ra\16a\u0a38\3a\5a\u0a3c\na\3a\3a\3b\3b\6b\u0a42"+
		"\nb\rb\16b\u0a43\3b\5b\u0a47\nb\3b\3b\3c\3c\3c\3c\3c\3d\3d\3d\3d\3d\3"+
		"e\3e\3e\3f\3f\5f\u0a5a\nf\3g\3g\3g\3g\3g\3g\3g\3h\3h\3i\3i\3j\3j\3j\5"+
		"j\u0a6a\nj\3k\3k\3k\5k\u0a6f\nk\3l\3l\3l\7l\u0a74\nl\fl\16l\u0a77\13l"+
		"\3m\3m\3m\7m\u0a7c\nm\fm\16m\u0a7f\13m\3n\5n\u0a82\nn\3n\3n\3o\3o\3o\3"+
		"o\7o\u0a8a\no\fo\16o\u0a8d\13o\3o\3o\3p\3p\3p\7p\u0a94\np\fp\16p\u0a97"+
		"\13p\3p\5p\u0a9a\np\3q\3q\3r\3r\3s\3s\3s\3s\3s\3s\3s\3t\3t\3t\5t\u0aaa"+
		"\nt\3u\3u\3v\3v\5v\u0ab0\nv\3w\3w\3x\3x\3x\7x\u0ab7\nx\fx\16x\u0aba\13"+
		"x\3y\3y\3z\3z\5z\u0ac0\nz\3{\3{\3|\3|\3|\3|\3|\3}\5}\u0aca\n}\3}\5}\u0acd"+
		"\n}\3}\5}\u0ad0\n}\3}\3}\3}\3}\3}\5}\u0ad7\n}\3~\3~\3\177\3\177\3\u0080"+
		"\3\u0080\3\u0080\7\u0080\u0ae0\n\u0080\f\u0080\16\u0080\u0ae3\13\u0080"+
		"\3\u0081\3\u0081\3\u0081\7\u0081\u0ae8\n\u0081\f\u0081\16\u0081\u0aeb"+
		"\13\u0081\3\u0082\3\u0082\3\u0082\5\u0082\u0af0\n\u0082\3\u0083\3\u0083"+
		"\5\u0083\u0af4\n\u0083\3\u0084\3\u0084\5\u0084\u0af8\n\u0084\3\u0084\3"+
		"\u0084\3\u0085\3\u0085\3\u0086\3\u0086\5\u0086\u0b00\n\u0086\3\u0087\3"+
		"\u0087\5\u0087\u0b04\n\u0087\3\u0088\3\u0088\3\u0088\3\u0088\3\u0089\3"+
		"\u0089\5\u0089\u0b0c\n\u0089\3\u008a\3\u008a\3\u008b\3\u008b\3\u008c\3"+
		"\u008c\5\u008c\u0b14\n\u008c\3\u008d\3\u008d\5\u008d\u0b18\n\u008d\3\u008e"+
		"\3\u008e\5\u008e\u0b1c\n\u008e\3\u008e\5\u008e\u0b1f\n\u008e\3\u008e\5"+
		"\u008e\u0b22\n\u008e\3\u008e\5\u008e\u0b25\n\u008e\3\u008e\5\u008e\u0b28"+
		"\n\u008e\3\u008f\3\u008f\3\u008f\3\u0090\3\u0090\3\u0090\7\u0090\u0b30"+
		"\n\u0090\f\u0090\16\u0090\u0b33\13\u0090\3\u0091\3\u0091\5\u0091\u0b37"+
		"\n\u0091\3\u0092\3\u0092\6\u0092\u0b3b\n\u0092\r\u0092\16\u0092\u0b3c"+
		"\3\u0093\3\u0093\3\u0093\3\u0093\5\u0093\u0b43\n\u0093\3\u0093\3\u0093"+
		"\3\u0093\3\u0093\3\u0093\3\u0093\5\u0093\u0b4b\n\u0093\3\u0093\3\u0093"+
		"\3\u0093\3\u0093\3\u0093\5\u0093\u0b52\n\u0093\3\u0094\3\u0094\3\u0094"+
		"\3\u0094\3\u0095\5\u0095\u0b59\n\u0095\3\u0095\3\u0095\3\u0095\3\u0095"+
		"\3\u0096\3\u0096\5\u0096\u0b61\n\u0096\3\u0096\3\u0096\3\u0096\3\u0097"+
		"\3\u0097\3\u0097\3\u0097\3\u0098\3\u0098\5\u0098\u0b6c\n\u0098\3\u0099"+
		"\3\u0099\5\u0099\u0b70\n\u0099\3\u009a\3\u009a\3\u009b\3\u009b\5\u009b"+
		"\u0b76\n\u009b\3\u009c\3\u009c\3\u009c\3\u009d\3\u009d\3\u009d\3\u009d"+
		"\3\u009d\3\u009e\3\u009e\5\u009e\u0b82\n\u009e\3\u009e\5\u009e\u0b85\n"+
		"\u009e\3\u009e\3\u009e\3\u009e\3\u009e\5\u009e\u0b8b\n\u009e\3\u009e\3"+
		"\u009e\5\u009e\u0b8f\n\u009e\3\u009e\3\u009e\3\u009e\3\u009e\3\u009e\5"+
		"\u009e\u0b96\n\u009e\5\u009e\u0b98\n\u009e\3\u009f\3\u009f\3\u009f\7\u009f"+
		"\u0b9d\n\u009f\f\u009f\16\u009f\u0ba0\13\u009f\3\u00a0\3\u00a0\3\u00a1"+
		"\3\u00a1\3\u00a1\3\u00a2\3\u00a2\3\u00a3\3\u00a3\3\u00a3\3\u00a3\3\u00a4"+
		"\3\u00a4\3\u00a4\7\u00a4\u0bb0\n\u00a4\f\u00a4\16\u00a4\u0bb3\13\u00a4"+
		"\3\u00a5\3\u00a5\3\u00a5\3\u00a5\5\u00a5\u0bb9\n\u00a5\3\u00a6\3\u00a6"+
		"\3\u00a6\3\u00a6\3\u00a6\5\u00a6\u0bc0\n\u00a6\3\u00a7\3\u00a7\3\u00a7"+
		"\7\u00a7\u0bc5\n\u00a7\f\u00a7\16\u00a7\u0bc8\13\u00a7\3\u00a8\3\u00a8"+
		"\3\u00a8\3\u00a8\3\u00a8\3\u00a9\3\u00a9\3\u00a9\3\u00a9\3\u00a9\3\u00aa"+
		"\3\u00aa\3\u00aa\3\u00ab\3\u00ab\3\u00ab\3\u00ac\3\u00ac\3\u00ac\7\u00ac"+
		"\u0bdd\n\u00ac\f\u00ac\16\u00ac\u0be0\13\u00ac\3\u00ad\3\u00ad\3\u00ae"+
		"\3\u00ae\5\u00ae\u0be6\n\u00ae\3\u00af\3\u00af\3\u00af\3\u00af\5\u00af"+
		"\u0bec\n\u00af\3\u00af\3\u00af\5\u00af\u0bf0\n\u00af\3\u00af\3\u00af\5"+
		"\u00af\u0bf4\n\u00af\3\u00af\7\u00af\u0bf7\n\u00af\f\u00af\16\u00af\u0bfa"+
		"\13\u00af\3\u00b0\3\u00b0\5\u00b0\u0bfe\n\u00b0\3\u00b1\3\u00b1\3\u00b1"+
		"\3\u00b1\5\u00b1\u0c04\n\u00b1\3\u00b1\3\u00b1\5\u00b1\u0c08\n\u00b1\3"+
		"\u00b1\3\u00b1\5\u00b1\u0c0c\n\u00b1\3\u00b1\7\u00b1\u0c0f\n\u00b1\f\u00b1"+
		"\16\u00b1\u0c12\13\u00b1\3\u00b2\3\u00b2\5\u00b2\u0c16\n\u00b2\3\u00b3"+
		"\3\u00b3\3\u00b3\3\u00b3\3\u00b3\5\u00b3\u0c1d\n\u00b3\3\u00b4\3\u00b4"+
		"\5\u00b4\u0c21\n\u00b4\3\u00b5\3\u00b5\3\u00b5\3\u00b6\3\u00b6\5\u00b6"+
		"\u0c28\n\u00b6\3\u00b7\3\u00b7\3\u00b7\3\u00b7\3\u00b7\5\u00b7\u0c2f\n"+
		"\u00b7\5\u00b7\u0c31\n\u00b7\3\u00b8\3\u00b8\5\u00b8\u0c35\n\u00b8\3\u00b8"+
		"\3\u00b8\5\u00b8\u0c39\n\u00b8\3\u00b9\3\u00b9\3\u00b9\7\u00b9\u0c3e\n"+
		"\u00b9\f\u00b9\16\u00b9\u0c41\13\u00b9\3\u00ba\3\u00ba\5\u00ba\u0c45\n"+
		"\u00ba\3\u00bb\3\u00bb\5\u00bb\u0c49\n\u00bb\3\u00bc\3\u00bc\5\u00bc\u0c4d"+
		"\n\u00bc\3\u00bc\3\u00bc\3\u00bd\3\u00bd\3\u00be\3\u00be\3\u00be\5\u00be"+
		"\u0c56\n\u00be\3\u00be\3\u00be\3\u00bf\5\u00bf\u0c5b\n\u00bf\3\u00bf\3"+
		"\u00bf\3\u00c0\3\u00c0\3\u00c0\7\u00c0\u0c62\n\u00c0\f\u00c0\16\u00c0"+
		"\u0c65\13\u00c0\3\u00c1\3\u00c1\3\u00c2\3\u00c2\3\u00c3\3\u00c3\3\u00c4"+
		"\3\u00c4\3\u00c4\3\u00c4\3\u00c5\3\u00c5\3\u00c5\3\u00c5\3\u00c5\3\u00c5"+
		"\5\u00c5\u0c77\n\u00c5\3\u00c6\3\u00c6\3\u00c6\3\u00c6\3\u00c7\3\u00c7"+
		"\3\u00c8\3\u00c8\3\u00c8\3\u00c9\5\u00c9\u0c83\n\u00c9\3\u00c9\3\u00c9"+
		"\5\u00c9\u0c87\n\u00c9\3\u00c9\3\u00c9\3\u00c9\3\u00c9\3\u00ca\3\u00ca"+
		"\5\u00ca\u0c8f\n\u00ca\3\u00ca\3\u00ca\3\u00ca\3\u00cb\3\u00cb\3\u00cb"+
		"\3\u00cb\3\u00cb\5\u00cb\u0c99\n\u00cb\3\u00cc\3\u00cc\3\u00cc\7\u00cc"+
		"\u0c9e\n\u00cc\f\u00cc\16\u00cc\u0ca1\13\u00cc\3\u00cd\3\u00cd\3\u00cd"+
		"\3\u00cd\3\u00ce\5\u00ce\u0ca8\n\u00ce\3\u00ce\3\u00ce\5\u00ce\u0cac\n"+
		"\u00ce\3\u00cf\3\u00cf\3\u00cf\3\u00cf\3\u00cf\3\u00cf\5\u00cf\u0cb4\n"+
		"\u00cf\3\u00d0\3\u00d0\3\u00d1\3\u00d1\3\u00d1\5\u00d1\u0cbb\n\u00d1\3"+
		"\u00d1\3\u00d1\3\u00d2\3\u00d2\3\u00d2\3\u00d2\3\u00d2\3\u00d3\3\u00d3"+
		"\5\u00d3\u0cc6\n\u00d3\3\u00d4\3\u00d4\3\u00d5\3\u00d5\3\u00d6\5\u00d6"+
		"\u0ccd\n\u00d6\3\u00d6\3\u00d6\3\u00d6\3\u00d7\3\u00d7\3\u00d7\3\u00d8"+
		"\3\u00d8\5\u00d8\u0cd7\n\u00d8\3\u00d9\3\u00d9\3\u00da\3\u00da\3\u00db"+
		"\3\u00db\3\u00db\5\u00db\u0ce0\n\u00db\3\u00db\3\u00db\3\u00dc\3\u00dc"+
		"\3\u00dd\3\u00dd\5\u00dd\u0ce8\n\u00dd\3\u00de\3\u00de\3\u00de\7\u00de"+
		"\u0ced\n\u00de\f\u00de\16\u00de\u0cf0\13\u00de\3\u00df\3\u00df\3\u00df"+
		"\3\u00df\3\u00e0\3\u00e0\3\u00e0\7\u00e0\u0cf9\n\u00e0\f\u00e0\16\u00e0"+
		"\u0cfc\13\u00e0\3\u00e1\3\u00e1\5\u00e1\u0d00\n\u00e1\3\u00e1\5\u00e1"+
		"\u0d03\n\u00e1\3\u00e2\3\u00e2\3\u00e3\3\u00e3\3\u00e3\3\u00e4\3\u00e4"+
		"\3\u00e4\3\u00e4\5\u00e4\u0d0e\n\u00e4\3\u00e5\3\u00e5\5\u00e5\u0d12\n"+
		"\u00e5\3\u00e5\3\u00e5\3\u00e5\3\u00e5\3\u00e5\3\u00e5\5\u00e5\u0d1a\n"+
		"\u00e5\3\u00e5\3\u00e5\3\u00e5\3\u00e5\5\u00e5\u0d20\n\u00e5\3\u00e5\3"+
		"\u00e5\3\u00e5\3\u00e5\3\u00e5\3\u00e5\5\u00e5\u0d28\n\u00e5\5\u00e5\u0d2a"+
		"\n\u00e5\3\u00e5\5\u00e5\u0d2d\n\u00e5\3\u00e5\2\2\u00e6\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bd"+
		"fhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088\u008a\u008c\u008e\u0090\u0092"+
		"\u0094\u0096\u0098\u009a\u009c\u009e\u00a0\u00a2\u00a4\u00a6\u00a8\u00aa"+
		"\u00ac\u00ae\u00b0\u00b2\u00b4\u00b6\u00b8\u00ba\u00bc\u00be\u00c0\u00c2"+
		"\u00c4\u00c6\u00c8\u00ca\u00cc\u00ce\u00d0\u00d2\u00d4\u00d6\u00d8\u00da"+
		"\u00dc\u00de\u00e0\u00e2\u00e4\u00e6\u00e8\u00ea\u00ec\u00ee\u00f0\u00f2"+
		"\u00f4\u00f6\u00f8\u00fa\u00fc\u00fe\u0100\u0102\u0104\u0106\u0108\u010a"+
		"\u010c\u010e\u0110\u0112\u0114\u0116\u0118\u011a\u011c\u011e\u0120\u0122"+
		"\u0124\u0126\u0128\u012a\u012c\u012e\u0130\u0132\u0134\u0136\u0138\u013a"+
		"\u013c\u013e\u0140\u0142\u0144\u0146\u0148\u014a\u014c\u014e\u0150\u0152"+
		"\u0154\u0156\u0158\u015a\u015c\u015e\u0160\u0162\u0164\u0166\u0168\u016a"+
		"\u016c\u016e\u0170\u0172\u0174\u0176\u0178\u017a\u017c\u017e\u0180\u0182"+
		"\u0184\u0186\u0188\u018a\u018c\u018e\u0190\u0192\u0194\u0196\u0198\u019a"+
		"\u019c\u019e\u01a0\u01a2\u01a4\u01a6\u01a8\u01aa\u01ac\u01ae\u01b0\u01b2"+
		"\u01b4\u01b6\u01b8\u01ba\u01bc\u01be\u01c0\u01c2\u01c4\u01c6\u01c8\2&"+
		"\4\2JJjj\4\2\u00f3\u00f3\u012b\u012b\t\2\36\36__iittvvzz\u00b3\u00b3\6"+
		"\2__iizz\u00b3\u00b3\4\2iiz{\5\2\23\23\27\27pq\4\2\27\27{{\4\2\17\17a"+
		"a\4\2iizz\3\2\u0142\u0142\4\2\u00b5\u00b5\u00b8\u00b8\6\299@@RR}}\3\2"+
		"pq\4\2\61\61JJ\4\2\'\'::\b\2\6\6\25\25\33\33\u0091\u0091\u00b0\u00b0\u00e6"+
		"\u00e6\t\2\u0083\u00ad\u00af\u00af\u00b1\u00eb\u00ed\u00f9\u00fb\u0110"+
		"\u0112\u011f\u0121\u0124\5\2**uu\u00f4\u00f4\3\2\u0101\u0102\3\2\u0143"+
		"\u0144\17\2\b\bkk\u0084\u0084\u008d\u008d\u0095\u0095\u00a3\u00a3\u00ab"+
		"\u00ab\u00b4\u00b4\u00c0\u00c0\u00c5\u00c5\u00e7\u00e8\u00ea\u00ea\u00f7"+
		"\u00f8\3\2\u0137\u0138\3\2\u0139\u013b\3\2\u00ef\u00f1\5\2\r\rFFss\5\2"+
		"--GGdd\4\2%%xx\4\2\6\6  \4\2\u012b\u012b\u0130\u0134\4\2\t\tnn\3\2\u0125"+
		"\u0128\4\2\b\bkk\6\2\u009a\u009a\u00ae\u00ae\u00c7\u00c8\u00ff\u00ff\n"+
		"\2\u008a\u008a\u009c\u009c\u009f\u00a0\u00a2\u00a2\u00b6\u00b7\u00c2\u00c4"+
		"\u00d8\u00d8\u00fc\u00fc\4\2GGdd\4\2\n\n\37\37\u0edd\2\u01d0\3\2\2\2\4"+
		"\u01e2\3\2\2\2\6\u01e4\3\2\2\2\b\u01e6\3\2\2\2\n\u01ea\3\2\2\2\f\u01ec"+
		"\3\2\2\2\16\u01fd\3\2\2\2\20\u023b\3\2\2\2\22\u023d\3\2\2\2\24\u03fe\3"+
		"\2\2\2\26\u0400\3\2\2\2\30\u0555\3\2\2\2\32\u0557\3\2\2\2\34\u056b\3\2"+
		"\2\2\36\u05e9\3\2\2\2 \u0659\3\2\2\2\"\u0662\3\2\2\2$\u0664\3\2\2\2&\u0666"+
		"\3\2\2\2(\u067a\3\2\2\2*\u0686\3\2\2\2,\u06db\3\2\2\2.\u077f\3\2\2\2\60"+
		"\u0781\3\2\2\2\62\u0786\3\2\2\2\64\u07f9\3\2\2\2\66\u0828\3\2\2\28\u082d"+
		"\3\2\2\2:\u0842\3\2\2\2<\u084d\3\2\2\2>\u0851\3\2\2\2@\u0859\3\2\2\2B"+
		"\u085c\3\2\2\2D\u0864\3\2\2\2F\u086f\3\2\2\2H\u0872\3\2\2\2J\u0874\3\2"+
		"\2\2L\u0880\3\2\2\2N\u0884\3\2\2\2P\u0887\3\2\2\2R\u088a\3\2\2\2T\u0890"+
		"\3\2\2\2V\u0892\3\2\2\2X\u089c\3\2\2\2Z\u08a4\3\2\2\2\\\u08b6\3\2\2\2"+
		"^\u08c3\3\2\2\2`\u08cb\3\2\2\2b\u08ce\3\2\2\2d\u08d1\3\2\2\2f\u08db\3"+
		"\2\2\2h\u08e3\3\2\2\2j\u08ed\3\2\2\2l\u08f2\3\2\2\2n\u08f4\3\2\2\2p\u0902"+
		"\3\2\2\2r\u0904\3\2\2\2t\u0908\3\2\2\2v\u090d\3\2\2\2x\u0912\3\2\2\2z"+
		"\u0914\3\2\2\2|\u0917\3\2\2\2~\u091a\3\2\2\2\u0080\u091d\3\2\2\2\u0082"+
		"\u091f\3\2\2\2\u0084\u092c\3\2\2\2\u0086\u092e\3\2\2\2\u0088\u0930\3\2"+
		"\2\2\u008a\u0949\3\2\2\2\u008c\u094b\3\2\2\2\u008e\u0972\3\2\2\2\u0090"+
		"\u097c\3\2\2\2\u0092\u0980\3\2\2\2\u0094\u0997\3\2\2\2\u0096\u09a3\3\2"+
		"\2\2\u0098\u09ad\3\2\2\2\u009a\u09af\3\2\2\2\u009c\u09be\3\2\2\2\u009e"+
		"\u09cd\3\2\2\2\u00a0\u09dc\3\2\2\2\u00a2\u09e0\3\2\2\2\u00a4\u09e2\3\2"+
		"\2\2\u00a6\u09ed\3\2\2\2\u00a8\u09ef\3\2\2\2\u00aa\u09f1\3\2\2\2\u00ac"+
		"\u09f4\3\2\2\2\u00ae\u09f8\3\2\2\2\u00b0\u0a02\3\2\2\2\u00b2\u0a04\3\2"+
		"\2\2\u00b4\u0a0c\3\2\2\2\u00b6\u0a0e\3\2\2\2\u00b8\u0a14\3\2\2\2\u00ba"+
		"\u0a19\3\2\2\2\u00bc\u0a2d\3\2\2\2\u00be\u0a31\3\2\2\2\u00c0\u0a33\3\2"+
		"\2\2\u00c2\u0a3f\3\2\2\2\u00c4\u0a4a\3\2\2\2\u00c6\u0a4f\3\2\2\2\u00c8"+
		"\u0a54\3\2\2\2\u00ca\u0a59\3\2\2\2\u00cc\u0a5b\3\2\2\2\u00ce\u0a62\3\2"+
		"\2\2\u00d0\u0a64\3\2\2\2\u00d2\u0a69\3\2\2\2\u00d4\u0a6e\3\2\2\2\u00d6"+
		"\u0a70\3\2\2\2\u00d8\u0a78\3\2\2\2\u00da\u0a81\3\2\2\2\u00dc\u0a85\3\2"+
		"\2\2\u00de\u0a99\3\2\2\2\u00e0\u0a9b\3\2\2\2\u00e2\u0a9d\3\2\2\2\u00e4"+
		"\u0a9f\3\2\2\2\u00e6\u0aa9\3\2\2\2\u00e8\u0aab\3\2\2\2\u00ea\u0aaf\3\2"+
		"\2\2\u00ec\u0ab1\3\2\2\2\u00ee\u0ab3\3\2\2\2\u00f0\u0abb\3\2\2\2\u00f2"+
		"\u0abf\3\2\2\2\u00f4\u0ac1\3\2\2\2\u00f6\u0ac3\3\2\2\2\u00f8\u0ad6\3\2"+
		"\2\2\u00fa\u0ad8\3\2\2\2\u00fc\u0ada\3\2\2\2\u00fe\u0adc\3\2\2\2\u0100"+
		"\u0ae4\3\2\2\2\u0102\u0aef\3\2\2\2\u0104\u0af1\3\2\2\2\u0106\u0af5\3\2"+
		"\2\2\u0108\u0afb\3\2\2\2\u010a\u0aff\3\2\2\2\u010c\u0b03\3\2\2\2\u010e"+
		"\u0b05\3\2\2\2\u0110\u0b0b\3\2\2\2\u0112\u0b0d\3\2\2\2\u0114\u0b0f\3\2"+
		"\2\2\u0116\u0b13\3\2\2\2\u0118\u0b17\3\2\2\2\u011a\u0b19\3\2\2\2\u011c"+
		"\u0b29\3\2\2\2\u011e\u0b2c\3\2\2\2\u0120\u0b36\3\2\2\2\u0122\u0b38\3\2"+
		"\2\2\u0124\u0b51\3\2\2\2\u0126\u0b53\3\2\2\2\u0128\u0b58\3\2\2\2\u012a"+
		"\u0b5e\3\2\2\2\u012c\u0b65\3\2\2\2\u012e\u0b6b\3\2\2\2\u0130\u0b6d\3\2"+
		"\2\2\u0132\u0b71\3\2\2\2\u0134\u0b75\3\2\2\2\u0136\u0b77\3\2\2\2\u0138"+
		"\u0b7a\3\2\2\2\u013a\u0b97\3\2\2\2\u013c\u0b99\3\2\2\2\u013e\u0ba1\3\2"+
		"\2\2\u0140\u0ba3\3\2\2\2\u0142\u0ba6\3\2\2\2\u0144\u0ba8\3\2\2\2\u0146"+
		"\u0bac\3\2\2\2\u0148\u0bb8\3\2\2\2\u014a\u0bbf\3\2\2\2\u014c\u0bc1\3\2"+
		"\2\2\u014e\u0bc9\3\2\2\2\u0150\u0bce\3\2\2\2\u0152\u0bd3\3\2\2\2\u0154"+
		"\u0bd6\3\2\2\2\u0156\u0bd9\3\2\2\2\u0158\u0be1\3\2\2\2\u015a\u0be5\3\2"+
		"\2\2\u015c\u0bef\3\2\2\2\u015e\u0bfd\3\2\2\2\u0160\u0c07\3\2\2\2\u0162"+
		"\u0c15\3\2\2\2\u0164\u0c1c\3\2\2\2\u0166\u0c20\3\2\2\2\u0168\u0c22\3\2"+
		"\2\2\u016a\u0c27\3\2\2\2\u016c\u0c29\3\2\2\2\u016e\u0c32\3\2\2\2\u0170"+
		"\u0c3a\3\2\2\2\u0172\u0c44\3\2\2\2\u0174\u0c46\3\2\2\2\u0176\u0c4c\3\2"+
		"\2\2\u0178\u0c50\3\2\2\2\u017a\u0c55\3\2\2\2\u017c\u0c5a\3\2\2\2\u017e"+
		"\u0c5e\3\2\2\2\u0180\u0c66\3\2\2\2\u0182\u0c68\3\2\2\2\u0184\u0c6a\3\2"+
		"\2\2\u0186\u0c6c\3\2\2\2\u0188\u0c76\3\2\2\2\u018a\u0c78\3\2\2\2\u018c"+
		"\u0c7c\3\2\2\2\u018e\u0c7e\3\2\2\2\u0190\u0c82\3\2\2\2\u0192\u0c8c\3\2"+
		"\2\2\u0194\u0c98\3\2\2\2\u0196\u0c9a\3\2\2\2\u0198\u0ca2\3\2\2\2\u019a"+
		"\u0cab\3\2\2\2\u019c\u0cb3\3\2\2\2\u019e\u0cb5\3\2\2\2\u01a0\u0cb7\3\2"+
		"\2\2\u01a2\u0cbe\3\2\2\2\u01a4\u0cc5\3\2\2\2\u01a6\u0cc7\3\2\2\2\u01a8"+
		"\u0cc9\3\2\2\2\u01aa\u0ccc\3\2\2\2\u01ac\u0cd1\3\2\2\2\u01ae\u0cd6\3\2"+
		"\2\2\u01b0\u0cd8\3\2\2\2\u01b2\u0cda\3\2\2\2\u01b4\u0cdc\3\2\2\2\u01b6"+
		"\u0ce3\3\2\2\2\u01b8\u0ce7\3\2\2\2\u01ba\u0ce9\3\2\2\2\u01bc\u0cf1\3\2"+
		"\2\2\u01be\u0cf5\3\2\2\2\u01c0\u0cfd\3\2\2\2\u01c2\u0d04\3\2\2\2\u01c4"+
		"\u0d06\3\2\2\2\u01c6\u0d0d\3\2\2\2\u01c8\u0d2c\3\2\2\2\u01ca\u01cc\5\4"+
		"\3\2\u01cb\u01cd\7\u012d\2\2\u01cc\u01cb\3\2\2\2\u01cc\u01cd\3\2\2\2\u01cd"+
		"\u01cf\3\2\2\2\u01ce\u01ca\3\2\2\2\u01cf\u01d2\3\2\2\2\u01d0\u01ce\3\2"+
		"\2\2\u01d0\u01d1\3\2\2\2\u01d1\u01d3\3\2\2\2\u01d2\u01d0\3\2\2\2\u01d3"+
		"\u01d4\7\2\2\3\u01d4\3\3\2\2\2\u01d5\u01e3\5\6\4\2\u01d6\u01e3\5\b\5\2"+
		"\u01d7\u01e3\5\n\6\2\u01d8\u01e3\5\f\7\2\u01d9\u01e3\5\16\b\2\u01da\u01e3"+
		"\5\20\t\2\u01db\u01e3\5\22\n\2\u01dc\u01e3\5\30\r\2\u01dd\u01e3\5\24\13"+
		"\2\u01de\u01e3\5\34\17\2\u01df\u01e3\5\36\20\2\u01e0\u01e3\5*\26\2\u01e1"+
		"\u01e3\5,\27\2\u01e2\u01d5\3\2\2\2\u01e2\u01d6\3\2\2\2\u01e2\u01d7\3\2"+
		"\2\2\u01e2\u01d8\3\2\2\2\u01e2\u01d9\3\2\2\2\u01e2\u01da\3\2\2\2\u01e2"+
		"\u01db\3\2\2\2\u01e2\u01dc\3\2\2\2\u01e2\u01dd\3\2\2\2\u01e2\u01de\3\2"+
		"\2\2\u01e2\u01df\3\2\2\2\u01e2\u01e0\3\2\2\2\u01e2\u01e1\3\2\2\2\u01e3"+
		"\5\3\2\2\2\u01e4\u01e5\5\u0158\u00ad\2\u01e5\7\3\2\2\2\u01e6\u01e7\5\u01c8"+
		"\u00e5\2\u01e7\t\3\2\2\2\u01e8\u01eb\5.\30\2\u01e9\u01eb\5n8\2\u01ea\u01e8"+
		"\3\2\2\2\u01ea\u01e9\3\2\2\2\u01eb\13\3\2\2\2\u01ec\u01ee\7\27\2\2\u01ed"+
		"\u01ef\7y\2\2\u01ee\u01ed\3\2\2\2\u01ee\u01ef\3\2\2\2\u01ef\u01f0\3\2"+
		"\2\2\u01f0\u01f1\7\u00af\2\2\u01f1\u01f2\5p9\2\u01f2\u01f3\7P\2\2\u01f3"+
		"\u01f5\5\u016c\u00b7\2\u01f4\u01f6\5N(\2\u01f5\u01f4\3\2\2\2\u01f5\u01f6"+
		"\3\2\2\2\u01f6\u01f7\3\2\2\2\u01f7\u01f8\7\u0135\2\2\u01f8\u01f9\5\u01be"+
		"\u00e0\2\u01f9\u01fb\7\u0136\2\2\u01fa\u01fc\5J&\2\u01fb\u01fa\3\2\2\2"+
		"\u01fb\u01fc\3\2\2\2\u01fc\r\3\2\2\2\u01fd\u01fe\7\27\2\2\u01fe\u0202"+
		"\7)\2\2\u01ff\u0200\7\65\2\2\u0200\u0201\7L\2\2\u0201\u0203\7\u00a4\2"+
		"\2\u0202\u01ff\3\2\2\2\u0202\u0203\3\2\2\2\u0203\u0204\3\2\2\2\u0204\u0206"+
		"\5p9\2\u0205\u0207\7\u0081\2\2\u0206\u0205\3\2\2\2\u0206\u0207\3\2\2\2"+
		"\u0207\u020a\3\2\2\2\u0208\u0209\7f\2\2\u0209\u020b\5p9\2\u020a\u0208"+
		"\3\2\2\2\u020a\u020b\3\2\2\2\u020b\u020e\3\2\2\2\u020c\u020d\7\u00fa\2"+
		"\2\u020d\u020f\5p9\2\u020e\u020c\3\2\2\2\u020e\u020f\3\2\2\2\u020f\u0212"+
		"\3\2\2\2\u0210\u0211\7\60\2\2\u0211\u0213\5p9\2\u0212\u0210\3\2\2\2\u0212"+
		"\u0213\3\2\2\2\u0213\17\3\2\2\2\u0214\u0216\7\u00e1\2\2\u0215\u0217\t"+
		"\2\2\2\u0216\u0215\3\2\2\2\u0216\u0217\3\2\2\2\u0217\u0218\3\2\2\2\u0218"+
		"\u0219\5p9\2\u0219\u0225\t\3\2\2\u021a\u0221\5p9\2\u021b\u021c\7\u013f"+
		"\2\2\u021c\u021d\5p9\2\u021d\u021e\7\u013f\2\2\u021e\u0221\3\2\2\2\u021f"+
		"\u0221\7\32\2\2\u0220\u021a\3\2\2\2\u0220\u021b\3\2\2\2\u0220\u021f\3"+
		"\2\2\2\u0221\u0223\3\2\2\2\u0222\u0224\7\u012e\2\2\u0223\u0222\3\2\2\2"+
		"\u0223\u0224\3\2\2\2\u0224\u0226\3\2\2\2\u0225\u0220\3\2\2\2\u0226\u0227"+
		"\3\2\2\2\u0227\u0225\3\2\2\2\u0227\u0228\3\2\2\2\u0228\u023c\3\2\2\2\u0229"+
		"\u022b\7\u00e1\2\2\u022a\u022c\t\2\2\2\u022b\u022a\3\2\2\2\u022b\u022c"+
		"\3\2\2\2\u022c\u022d\3\2\2\2\u022d\u022e\7\u011b\2\2\u022e\u0237\7\u0100"+
		"\2\2\u022f\u0233\5p9\2\u0230\u0233\7J\2\2\u0231\u0233\7\32\2\2\u0232\u022f"+
		"\3\2\2\2\u0232\u0230\3\2\2\2\u0232\u0231\3\2\2\2\u0233\u0235\3\2\2\2\u0234"+
		"\u0236\7\u012e\2\2\u0235\u0234\3\2\2\2\u0235\u0236\3\2\2\2\u0236\u0238"+
		"\3\2\2\2\u0237\u0232\3\2\2\2\u0238\u0239\3\2\2\2\u0239\u0237\3\2\2\2\u0239"+
		"\u023a\3\2\2\2\u023a\u023c\3\2\2\2\u023b\u0214\3\2\2\2\u023b\u0229\3\2"+
		"\2\2\u023c\21\3\2\2\2\u023d\u023f\7\27\2\2\u023e\u0240\7\24\2\2\u023f"+
		"\u023e\3\2\2\2\u023f\u0240\3\2\2\2\u0240\u0241\3\2\2\2\u0241\u0242\7t"+
		"\2\2\u0242\u0247\5p9\2\u0243\u0248\7\f\2\2\u0244\u0245\7A\2\2\u0245\u0248"+
		"\7N\2\2\u0246\u0248\7\4\2\2\u0247\u0243\3\2\2\2\u0247\u0244\3\2\2\2\u0247"+
		"\u0246\3\2\2\2\u0248\u0258\3\2\2\2\u0249\u0259\7\u00b3\2\2\u024a\u0259"+
		"\7\36\2\2\u024b\u0259\7v\2\2\u024c\u0256\7z\2\2\u024d\u0252\7N\2\2\u024e"+
		"\u0250\5p9\2\u024f\u0251\7\u012e\2\2\u0250\u024f\3\2\2\2\u0250\u0251\3"+
		"\2\2\2\u0251\u0253\3\2\2\2\u0252\u024e\3\2\2\2\u0253\u0254\3\2\2\2\u0254"+
		"\u0252\3\2\2\2\u0254\u0255\3\2\2\2\u0255\u0257\3\2\2\2\u0256\u024d\3\2"+
		"\2\2\u0256\u0257\3\2\2\2\u0257\u0259\3\2\2\2\u0258\u0249\3\2\2\2\u0258"+
		"\u024a\3\2\2\2\u0258\u024b\3\2\2\2\u0258\u024c\3\2\2\2\u0259\u025a\3\2"+
		"\2\2\u025a\u025b\7P\2\2\u025b\u025e\5\u016c\u00b7\2\u025c\u025d\7\60\2"+
		"\2\u025d\u025f\5\u016c\u00b7\2\u025e\u025c\3\2\2\2\u025e\u025f\3\2\2\2"+
		"\u025f\u0269\3\2\2\2\u0260\u0261\7L\2\2\u0261\u026a\7\34\2\2\u0262\u0264"+
		"\7\34\2\2\u0263\u0262\3\2\2\2\u0263\u0264\3\2\2\2\u0264\u0265\3\2\2\2"+
		"\u0265\u0266\7<\2\2\u0266\u026a\7\67\2\2\u0267\u0268\7<\2\2\u0268\u026a"+
		"\7\35\2\2\u0269\u0260\3\2\2\2\u0269\u0263\3\2\2\2\u0269\u0267\3\2\2\2"+
		"\u0269\u026a\3\2\2\2\u026a\u0271\3\2\2\2\u026b\u026d\7+\2\2\u026c\u026e"+
		"\7\"\2\2\u026d\u026c\3\2\2\2\u026d\u026e\3\2\2\2\u026e\u026f\3\2\2\2\u026f"+
		"\u0272\7]\2\2\u0270\u0272\7l\2\2\u0271\u026b\3\2\2\2\u0271\u0270\3\2\2"+
		"\2\u0271\u0272\3\2\2\2\u0272\u0275\3\2\2\2\u0273\u0274\7\177\2\2\u0274"+
		"\u0276\5\u00fc\177\2\u0275\u0273\3\2\2\2\u0275\u0276\3\2\2\2\u0276\u0277"+
		"\3\2\2\2\u0277\u0278\7(\2\2\u0278\u0279\7Z\2\2\u0279\u027a\5p9\2\u027a"+
		"\u027f\7\u0135\2\2\u027b\u027d\5p9\2\u027c\u027e\7\u012e\2\2\u027d\u027c"+
		"\3\2\2\2\u027d\u027e\3\2\2\2\u027e\u0280\3\2\2\2\u027f\u027b\3\2\2\2\u027f"+
		"\u0280\3\2\2\2\u0280\u0281\3\2\2\2\u0281\u0282\7\u0136\2\2\u0282\23\3"+
		"\2\2\2\u0283\u0287\7c\2\2\u0284\u0285\7\62\2\2\u0285\u0286\7\u00ce\2\2"+
		"\u0286\u0288\7+\2\2\u0287\u0284\3\2\2\2\u0287\u0288\3\2\2\2\u0288\u0292"+
		"\3\2\2\2\u0289\u028b\t\4\2\2\u028a\u0289\3\2\2\2\u028b\u028c\3\2\2\2\u028c"+
		"\u028a\3\2\2\2\u028c\u028d\3\2\2\2\u028d\u0293\3\2\2\2\u028e\u0290\7\6"+
		"\2\2\u028f\u0291\7Y\2\2\u0290\u028f\3\2\2\2\u0290\u0291\3\2\2\2\u0291"+
		"\u0293\3\2\2\2\u0292\u028a\3\2\2\2\u0292\u028e\3\2\2\2\u0293\u0294\3\2"+
		"\2\2\u0294\u02a6\7P\2\2\u0295\u0297\7o\2\2\u0296\u0295\3\2\2\2\u0296\u0297"+
		"\3\2\2\2\u0297\u0298\3\2\2\2\u0298\u029a\5\u016c\u00b7\2\u0299\u0296\3"+
		"\2\2\2\u029a\u029b\3\2\2\2\u029b\u0299\3\2\2\2\u029b\u029c\3\2\2\2\u029c"+
		"\u02a7\3\2\2\2\u029d\u029e\7\6\2\2\u029e\u029f\7\u00ec\2\2\u029f\u02a0"+
		"\79\2\2\u02a0\u02a2\7f\2\2\u02a1\u02a3\5p9\2\u02a2\u02a1\3\2\2\2\u02a3"+
		"\u02a4\3\2\2\2\u02a4\u02a2\3\2\2\2\u02a4\u02a5\3\2\2\2\u02a5\u02a7\3\2"+
		"\2\2\u02a6\u0299\3\2\2\2\u02a6\u029d\3\2\2\2\u02a7\u02a8\3\2\2\2\u02a8"+
		"\u02a9\5\26\f\2\u02a9\u03ff\3\2\2\2\u02aa\u02ae\7c\2\2\u02ab\u02ac\7\62"+
		"\2\2\u02ac\u02ad\7\u00ce\2\2\u02ad\u02af\7+\2\2\u02ae\u02ab\3\2\2\2\u02ae"+
		"\u02af\3\2\2\2\u02af\u02cf\3\2\2\2\u02b0\u02b1\t\5\2\2\u02b1\u02b6\7\u0135"+
		"\2\2\u02b2\u02b4\5p9\2\u02b3\u02b5\7\u012e\2\2\u02b4\u02b3\3\2\2\2\u02b4"+
		"\u02b5\3\2\2\2\u02b5\u02b7\3\2\2\2\u02b6\u02b2\3\2\2\2\u02b7\u02b8\3\2"+
		"\2\2\u02b8\u02b6\3\2\2\2\u02b8\u02b9\3\2\2\2\u02b9\u02ba\3\2\2\2\u02ba"+
		"\u02bb\7\u0136\2\2\u02bb\u02bd\3\2\2\2\u02bc\u02b0\3\2\2\2\u02bd\u02be"+
		"\3\2\2\2\u02be\u02bc\3\2\2\2\u02be\u02bf\3\2\2\2\u02bf\u02d0\3\2\2\2\u02c0"+
		"\u02c2\7\6\2\2\u02c1\u02c3\7Y\2\2\u02c2\u02c1\3\2\2\2\u02c2\u02c3\3\2"+
		"\2\2\u02c3\u02c4\3\2\2\2\u02c4\u02c9\7\u0135\2\2\u02c5\u02c7\5p9\2\u02c6"+
		"\u02c8\7\u012e\2\2\u02c7\u02c6\3\2\2\2\u02c7\u02c8\3\2\2\2\u02c8\u02ca"+
		"\3\2\2\2\u02c9\u02c5\3\2\2\2\u02ca\u02cb\3\2\2\2\u02cb\u02c9\3\2\2\2\u02cb"+
		"\u02cc\3\2\2\2\u02cc\u02cd\3\2\2\2\u02cd\u02ce\7\u0136\2\2\u02ce\u02d0"+
		"\3\2\2\2\u02cf\u02bc\3\2\2\2\u02cf\u02c0\3\2\2\2\u02d0\u02d1\3\2\2\2\u02d1"+
		"\u02d3\7P\2\2\u02d2\u02d4\7o\2\2\u02d3\u02d2\3\2\2\2\u02d3\u02d4\3\2\2"+
		"\2\u02d4\u02d9\3\2\2\2\u02d5\u02d7\5\u016c\u00b7\2\u02d6\u02d8\7\u012e"+
		"\2\2\u02d7\u02d6\3\2\2\2\u02d7\u02d8\3\2\2\2\u02d8\u02da\3\2\2\2\u02d9"+
		"\u02d5\3\2\2\2\u02da\u02db\3\2\2\2\u02db\u02d9\3\2\2\2\u02db\u02dc\3\2"+
		"\2\2\u02dc\u02dd\3\2\2\2\u02dd\u02de\5\26\f\2\u02de\u03ff\3\2\2\2\u02df"+
		"\u02e3\7c\2\2\u02e0\u02e1\7\62\2\2\u02e1\u02e2\7\u00ce\2\2\u02e2\u02e4"+
		"\7+\2\2\u02e3\u02e0\3\2\2\2\u02e3\u02e4\3\2\2\2\u02e4\u02ee\3\2\2\2\u02e5"+
		"\u02e7\t\6\2\2\u02e6\u02e5\3\2\2\2\u02e7\u02e8\3\2\2\2\u02e8\u02e6\3\2"+
		"\2\2\u02e8\u02e9\3\2\2\2\u02e9\u02ef\3\2\2\2\u02ea\u02ec\7\6\2\2\u02eb"+
		"\u02ed\7Y\2\2\u02ec\u02eb\3\2\2\2\u02ec\u02ed\3\2\2\2\u02ed\u02ef\3\2"+
		"\2\2\u02ee\u02e6\3\2\2\2\u02ee\u02ea\3\2\2\2\u02ef\u02f0\3\2\2\2\u02f0"+
		"\u0306\7P\2\2\u02f1\u02f6\7g\2\2\u02f2\u02f4\5\u016c\u00b7\2\u02f3\u02f5"+
		"\7\u012e\2\2\u02f4\u02f3\3\2\2\2\u02f4\u02f5\3\2\2\2\u02f5\u02f7\3\2\2"+
		"\2\u02f6\u02f2\3\2\2\2\u02f7\u02f8\3\2\2\2\u02f8\u02f6\3\2\2\2\u02f8\u02f9"+
		"\3\2\2\2\u02f9\u0307\3\2\2\2\u02fa\u02fb\7\6\2\2\u02fb\u02fc\7h\2\2\u02fc"+
		"\u02fd\79\2\2\u02fd\u0302\7f\2\2\u02fe\u0300\5p9\2\u02ff\u0301\7\u012e"+
		"\2\2\u0300\u02ff\3\2\2\2\u0300\u0301\3\2\2\2\u0301\u0303\3\2\2\2\u0302"+
		"\u02fe\3\2\2\2\u0303\u0304\3\2\2\2\u0304\u0302\3\2\2\2\u0304\u0305\3\2"+
		"\2\2\u0305\u0307\3\2\2\2\u0306\u02f1\3\2\2\2\u0306\u02fa\3\2\2\2\u0307"+
		"\u0308\3\2\2\2\u0308\u0309\5\26\f\2\u0309\u03ff\3\2\2\2\u030a\u030e\7"+
		"c\2\2\u030b\u030c\7\62\2\2\u030c\u030d\7\u00ce\2\2\u030d\u030f\7+\2\2"+
		"\u030e\u030b\3\2\2\2\u030e\u030f\3\2\2\2\u030f\u0319\3\2\2\2\u0310\u0312"+
		"\t\7\2\2\u0311\u0310\3\2\2\2\u0312\u0313\3\2\2\2\u0313\u0311\3\2\2\2\u0313"+
		"\u0314\3\2\2\2\u0314\u031a\3\2\2\2\u0315\u0317\7\6\2\2\u0316\u0318\7Y"+
		"\2\2\u0317\u0316\3\2\2\2\u0317\u0318\3\2\2\2\u0318\u031a\3\2\2\2\u0319"+
		"\u0311\3\2\2\2\u0319\u0315\3\2\2\2\u031a\u031b\3\2\2\2\u031b\u031c\7P"+
		"\2\2\u031c\u0321\7\31\2\2\u031d\u031f\5p9\2\u031e\u0320\7\u012e\2\2\u031f"+
		"\u031e\3\2\2\2\u031f\u0320\3\2\2\2\u0320\u0322\3\2\2\2\u0321\u031d\3\2"+
		"\2\2\u0322\u0323\3\2\2\2\u0323\u0321\3\2\2\2\u0323\u0324\3\2\2\2\u0324"+
		"\u0325\3\2\2\2\u0325\u0326\5\26\f\2\u0326\u03ff\3\2\2\2\u0327\u032b\7"+
		"c\2\2\u0328\u0329\7\62\2\2\u0329\u032a\7\u00ce\2\2\u032a\u032c\7+\2\2"+
		"\u032b\u0328\3\2\2\2\u032b\u032c\3\2\2\2\u032c\u0332\3\2\2\2\u032d\u0333"+
		"\7{\2\2\u032e\u0330\7\6\2\2\u032f\u0331\7Y\2\2\u0330\u032f\3\2\2\2\u0330"+
		"\u0331\3\2\2\2\u0331\u0333\3\2\2\2\u0332\u032d\3\2\2\2\u0332\u032e\3\2"+
		"\2\2\u0333\u0334\3\2\2\2\u0334\u0335\7P\2\2\u0335\u0336\7,\2\2\u0336\u0337"+
		"\7\u0099\2\2\u0337\u033c\7\u00fe\2\2\u0338\u033a\5\u016c\u00b7\2\u0339"+
		"\u033b\7\u012e\2\2\u033a\u0339\3\2\2\2\u033a\u033b\3\2\2\2\u033b\u033d"+
		"\3\2\2\2\u033c\u0338\3\2\2\2\u033d\u033e\3\2\2\2\u033e\u033c\3\2\2\2\u033e"+
		"\u033f\3\2\2\2\u033f\u0340\3\2\2\2\u0340\u0341\5\26\f\2\u0341\u03ff\3"+
		"\2\2\2\u0342\u0346\7c\2\2\u0343\u0344\7\62\2\2\u0344\u0345\7\u00ce\2\2"+
		"\u0345\u0347\7+\2\2\u0346\u0343\3\2\2\2\u0346\u0347\3\2\2\2\u0347\u034d"+
		"\3\2\2\2\u0348\u034e\7{\2\2\u0349\u034b\7\6\2\2\u034a\u034c\7Y\2\2\u034b"+
		"\u034a\3\2\2\2\u034b\u034c\3\2\2\2\u034c\u034e\3\2\2\2\u034d\u0348\3\2"+
		"\2\2\u034d\u0349\3\2\2\2\u034e\u034f\3\2\2\2\u034f\u0350\7P\2\2\u0350"+
		"\u0351\7,\2\2\u0351\u0356\7\u00e0\2\2\u0352\u0354\5p9\2\u0353\u0355\7"+
		"\u012e\2\2\u0354\u0353\3\2\2\2\u0354\u0355\3\2\2\2\u0355\u0357\3\2\2\2"+
		"\u0356\u0352\3\2\2\2\u0357\u0358\3\2\2\2\u0358\u0356\3\2\2\2\u0358\u0359"+
		"\3\2\2\2\u0359\u035a\3\2\2\2\u035a\u035b\5\26\f\2\u035b\u03ff\3\2\2\2"+
		"\u035c\u0360\7c\2\2\u035d\u035e\7\62\2\2\u035e\u035f\7\u00ce\2\2\u035f"+
		"\u0361\7+\2\2\u0360\u035d\3\2\2\2\u0360\u0361\3\2\2\2\u0361\u0367\3\2"+
		"\2\2\u0362\u0368\7(\2\2\u0363\u0365\7\6\2\2\u0364\u0366\7Y\2\2\u0365\u0364"+
		"\3\2\2\2\u0365\u0366\3\2\2\2\u0366\u0368\3\2\2\2\u0367\u0362\3\2\2\2\u0367"+
		"\u0363\3\2\2\2\u0368\u0369\3\2\2\2\u0369\u036c\7P\2\2\u036a\u036d\5&\24"+
		"\2\u036b\u036d\5(\25\2\u036c\u036a\3\2\2\2\u036c\u036b\3\2\2\2\u036d\u036e"+
		"\3\2\2\2\u036e\u036f\5\26\f\2\u036f\u03ff\3\2\2\2\u0370\u0374\7c\2\2\u0371"+
		"\u0372\7\62\2\2\u0372\u0373\7\u00ce\2\2\u0373\u0375\7+\2\2\u0374\u0371"+
		"\3\2\2\2\u0374\u0375\3\2\2\2\u0375\u037b\3\2\2\2\u0376\u037c\7{\2\2\u0377"+
		"\u0379\7\6\2\2\u0378\u037a\7Y\2\2\u0379\u0378\3\2\2\2\u0379\u037a\3\2"+
		"\2\2\u037a\u037c\3\2\2\2\u037b\u0376\3\2\2\2\u037b\u0377\3\2\2\2\u037c"+
		"\u037d\3\2\2\2\u037d\u037e\7P\2\2\u037e\u0383\7\u00b9\2\2\u037f\u0381"+
		"\5p9\2\u0380\u0382\7\u012e\2\2\u0381\u0380\3\2\2\2\u0381\u0382\3\2\2\2"+
		"\u0382\u0384\3\2\2\2\u0383\u037f\3\2\2\2\u0384\u0385\3\2\2\2\u0385\u0383"+
		"\3\2\2\2\u0385\u0386\3\2\2\2\u0386\u0387\3\2\2\2\u0387\u0388\5\26\f\2"+
		"\u0388\u03ff\3\2\2\2\u0389\u038d\7c\2\2\u038a\u038b\7\62\2\2\u038b\u038c"+
		"\7\u00ce\2\2\u038c\u038e\7+\2\2\u038d\u038a\3\2\2\2\u038d\u038e\3\2\2"+
		"\2\u038e\u039c\3\2\2\2\u038f\u0395\7i\2\2\u0390\u0392\7z\2\2\u0391\u0393"+
		"\7\u012e\2\2\u0392\u0391\3\2\2\2\u0392\u0393\3\2\2\2\u0393\u0395\3\2\2"+
		"\2\u0394\u038f\3\2\2\2\u0394\u0390\3\2\2\2\u0395\u0396\3\2\2\2\u0396\u0394"+
		"\3\2\2\2\u0396\u0397\3\2\2\2\u0397\u039d\3\2\2\2\u0398\u039a\7\6\2\2\u0399"+
		"\u039b\7Y\2\2\u039a\u0399\3\2\2\2\u039a\u039b\3\2\2\2\u039b\u039d\3\2"+
		"\2\2\u039c\u0394\3\2\2\2\u039c\u0398\3\2\2\2\u039d\u039e\3\2\2\2\u039e"+
		"\u039f\7P\2\2\u039f\u03a0\7\u00ba\2\2\u03a0\u03a5\7\u00cd\2\2\u03a1\u03a3"+
		"\5p9\2\u03a2\u03a4\7\u012e\2\2\u03a3\u03a2\3\2\2\2\u03a3\u03a4\3\2\2\2"+
		"\u03a4\u03a6\3\2\2\2\u03a5\u03a1\3\2\2\2\u03a6\u03a7\3\2\2\2\u03a7\u03a5"+
		"\3\2\2\2\u03a7\u03a8\3\2\2\2\u03a8\u03a9\3\2\2\2\u03a9\u03aa\5\26\f\2"+
		"\u03aa\u03ff\3\2\2\2\u03ab\u03af\7c\2\2\u03ac\u03ad\7\62\2\2\u03ad\u03ae"+
		"\7\u00ce\2\2\u03ae\u03b0\7+\2\2\u03af\u03ac\3\2\2\2\u03af\u03b0\3\2\2"+
		"\2\u03b0\u03bd\3\2\2\2\u03b1\u03b3\t\b\2\2\u03b2\u03b4\7\u012e\2\2\u03b3"+
		"\u03b2\3\2\2\2\u03b3\u03b4\3\2\2\2\u03b4\u03b6\3\2\2\2\u03b5\u03b1\3\2"+
		"\2\2\u03b6\u03b7\3\2\2\2\u03b7\u03b5\3\2\2\2\u03b7\u03b8\3\2\2\2\u03b8"+
		"\u03be\3\2\2\2\u03b9\u03bb\7\6\2\2\u03ba\u03bc\7Y\2\2\u03bb\u03ba\3\2"+
		"\2\2\u03bb\u03bc\3\2\2\2\u03bc\u03be\3\2\2\2\u03bd\u03b5\3\2\2\2\u03bd"+
		"\u03b9\3\2\2\2\u03be\u03bf\3\2\2\2\u03bf\u03c0\7P\2\2\u03c0\u03c5\7f\2"+
		"\2\u03c1\u03c3\5p9\2\u03c2\u03c4\7\u012e\2\2\u03c3\u03c2\3\2\2\2\u03c3"+
		"\u03c4\3\2\2\2\u03c4\u03c6\3\2\2\2\u03c5\u03c1\3\2\2\2\u03c6\u03c7\3\2"+
		"\2\2\u03c7\u03c5\3\2\2\2\u03c7\u03c8\3\2\2\2\u03c8\u03c9\3\2\2\2\u03c9"+
		"\u03ca\5\26\f\2\u03ca\u03ff\3\2\2\2\u03cb\u03cf\7c\2\2\u03cc\u03cd\7\62"+
		"\2\2\u03cd\u03ce\7\u00ce\2\2\u03ce\u03d0\7+\2\2\u03cf\u03cc\3\2\2\2\u03cf"+
		"\u03d0\3\2\2\2\u03d0\u03d6\3\2\2\2\u03d1\u03d7\7\27\2\2\u03d2\u03d4\7"+
		"\6\2\2\u03d3\u03d5\7Y\2\2\u03d4\u03d3\3\2\2\2\u03d4\u03d5\3\2\2\2\u03d5"+
		"\u03d7\3\2\2\2\u03d6\u03d1\3\2\2\2\u03d6\u03d2\3\2\2\2\u03d7\u03d8\3\2"+
		"\2\2\u03d8\u03d9\7P\2\2\u03d9\u03de\7\u00eb\2\2\u03da\u03dc\5p9\2\u03db"+
		"\u03dd\7\u012e\2\2\u03dc\u03db\3\2\2\2\u03dc\u03dd\3\2\2\2\u03dd\u03df"+
		"\3\2\2\2\u03de\u03da\3\2\2\2\u03df\u03e0\3\2\2\2\u03e0\u03de\3\2\2\2\u03e0"+
		"\u03e1\3\2\2\2\u03e1\u03e2\3\2\2\2\u03e2\u03e3\5\26\f\2\u03e3\u03ff\3"+
		"\2\2\2\u03e4\u03e8\7c\2\2\u03e5\u03e6\7\u0083\2\2\u03e6\u03e7\7\u00ce"+
		"\2\2\u03e7\u03e9\7+\2\2\u03e8\u03e5\3\2\2\2\u03e8\u03e9\3\2\2\2\u03e9"+
		"\u03ee\3\2\2\2\u03ea\u03ec\5p9\2\u03eb\u03ed\7\u012e\2\2\u03ec\u03eb\3"+
		"\2\2\2\u03ec\u03ed\3\2\2\2\u03ed\u03ef\3\2\2\2\u03ee\u03ea\3\2\2\2\u03ef"+
		"\u03f0\3\2\2\2\u03f0\u03ee\3\2\2\2\u03f0\u03f1\3\2\2\2\u03f1\u03f2\3\2"+
		"\2\2\u03f2\u03f7\7\60\2\2\u03f3\u03f5\5p9\2\u03f4\u03f6\7\u012e\2\2\u03f5"+
		"\u03f4\3\2\2\2\u03f5\u03f6\3\2\2\2\u03f6\u03f8\3\2\2\2\u03f7\u03f3\3\2"+
		"\2\2\u03f8\u03f9\3\2\2\2\u03f9\u03f7\3\2\2\2\u03f9\u03fa\3\2\2\2\u03fa"+
		"\u03fc\3\2\2\2\u03fb\u03fd\t\t\2\2\u03fc\u03fb\3\2\2\2\u03fc\u03fd\3\2"+
		"\2\2\u03fd\u03ff\3\2\2\2\u03fe\u0283\3\2\2\2\u03fe\u02aa\3\2\2\2\u03fe"+
		"\u02df\3\2\2\2\u03fe\u030a\3\2\2\2\u03fe\u0327\3\2\2\2\u03fe\u0342\3\2"+
		"\2\2\u03fe\u035c\3\2\2\2\u03fe\u0370\3\2\2\2\u03fe\u0389\3\2\2\2\u03fe"+
		"\u03ab\3\2\2\2\u03fe\u03cb\3\2\2\2\u03fe\u03e4\3\2\2\2\u03ff\25\3\2\2"+
		"\2\u0400\u0409\7\60\2\2\u0401\u0403\7\63\2\2\u0402\u0401\3\2\2\2\u0402"+
		"\u0403\3\2\2\2\u0403\u0404\3\2\2\2\u0404\u040a\5p9\2\u0405\u0407\7\u00d6"+
		"\2\2\u0406\u0408\7\u012e\2\2\u0407\u0406\3\2\2\2\u0407\u0408\3\2\2\2\u0408"+
		"\u040a\3\2\2\2\u0409\u0402\3\2\2\2\u0409\u0405\3\2\2\2\u040a\u040b\3\2"+
		"\2\2\u040b\u0409\3\2\2\2\u040b\u040c\3\2\2\2\u040c\u040e\3\2\2\2\u040d"+
		"\u040f\t\t\2\2\u040e\u040d\3\2\2\2\u040e\u040f\3\2\2\2\u040f\27\3\2\2"+
		"\2\u0410\u041a\7\62\2\2\u0411\u0413\t\4\2\2\u0412\u0411\3\2\2\2\u0413"+
		"\u0414\3\2\2\2\u0414\u0412\3\2\2\2\u0414\u0415\3\2\2\2\u0415\u041b\3\2"+
		"\2\2\u0416\u0418\7\6\2\2\u0417\u0419\7Y\2\2\u0418\u0417\3\2\2\2\u0418"+
		"\u0419\3\2\2\2\u0419\u041b\3\2\2\2\u041a\u0412\3\2\2\2\u041a\u0416\3\2"+
		"\2\2\u041b\u041c\3\2\2\2\u041c\u0434\7P\2\2\u041d\u041f\7o\2\2\u041e\u041d"+
		"\3\2\2\2\u041e\u041f\3\2\2\2\u041f\u0424\3\2\2\2\u0420\u0422\5\u016c\u00b7"+
		"\2\u0421\u0423\7\u012e\2\2\u0422\u0421\3\2\2\2\u0422\u0423\3\2\2\2\u0423"+
		"\u0425\3\2\2\2\u0424\u0420\3\2\2\2\u0425\u0426\3\2\2\2\u0426\u0424\3\2"+
		"\2\2\u0426\u0427\3\2\2\2\u0427\u0435\3\2\2\2\u0428\u0429\7\6\2\2\u0429"+
		"\u042a\7\u00ec\2\2\u042a\u042b\79\2\2\u042b\u0430\7f\2\2\u042c\u042e\5"+
		"p9\2\u042d\u042f\7\u012e\2\2\u042e\u042d\3\2\2\2\u042e\u042f\3\2\2\2\u042f"+
		"\u0431\3\2\2\2\u0430\u042c\3\2\2\2\u0431\u0432\3\2\2\2\u0432\u0430\3\2"+
		"\2\2\u0432\u0433\3\2\2\2\u0433\u0435\3\2\2\2\u0434\u041e\3\2\2\2\u0434"+
		"\u0428\3\2\2\2\u0435\u0436\3\2\2\2\u0436\u0437\5\32\16\2\u0437\u0556\3"+
		"\2\2\2\u0438\u0452\7\62\2\2\u0439\u043e\t\5\2\2\u043a\u043c\5p9\2\u043b"+
		"\u043d\7\u012e\2\2\u043c\u043b\3\2\2\2\u043c\u043d\3\2\2\2\u043d\u043f"+
		"\3\2\2\2\u043e\u043a\3\2\2\2\u043f\u0440\3\2\2\2\u0440\u043e\3\2\2\2\u0440"+
		"\u0441\3\2\2\2\u0441\u0443\3\2\2\2\u0442\u0439\3\2\2\2\u0443\u0444\3\2"+
		"\2\2\u0444\u0442\3\2\2\2\u0444\u0445\3\2\2\2\u0445\u0453\3\2\2\2\u0446"+
		"\u0448\7\6\2\2\u0447\u0449\7Y\2\2\u0448\u0447\3\2\2\2\u0448\u0449\3\2"+
		"\2\2\u0449\u044e\3\2\2\2\u044a\u044c\5p9\2\u044b\u044d\7\u012e\2\2\u044c"+
		"\u044b\3\2\2\2\u044c\u044d\3\2\2\2\u044d\u044f\3\2\2\2\u044e\u044a\3\2"+
		"\2\2\u044f\u0450\3\2\2\2\u0450\u044e\3\2\2\2\u0450\u0451\3\2\2\2\u0451"+
		"\u0453\3\2\2\2\u0452\u0442\3\2\2\2\u0452\u0446\3\2\2\2\u0453\u0454\3\2"+
		"\2\2\u0454\u045c\7P\2\2\u0455\u0457\7o\2\2\u0456\u0455\3\2\2\2\u0456\u0457"+
		"\3\2\2\2\u0457\u0458\3\2\2\2\u0458\u045a\5\u016c\u00b7\2\u0459\u045b\7"+
		"\u012e\2\2\u045a\u0459\3\2\2\2\u045a\u045b\3\2\2\2\u045b\u045d\3\2\2\2"+
		"\u045c\u0456\3\2\2\2\u045d\u045e\3\2\2\2\u045e\u045c\3\2\2\2\u045e\u045f"+
		"\3\2\2\2\u045f\u0460\3\2\2\2\u0460\u0461\5\32\16\2\u0461\u0556\3\2\2\2"+
		"\u0462\u046f\7\62\2\2\u0463\u0465\t\6\2\2\u0464\u0466\7\u012e\2\2\u0465"+
		"\u0464\3\2\2\2\u0465\u0466\3\2\2\2\u0466\u0468\3\2\2\2\u0467\u0463\3\2"+
		"\2\2\u0468\u0469\3\2\2\2\u0469\u0467\3\2\2\2\u0469\u046a\3\2\2\2\u046a"+
		"\u0470\3\2\2\2\u046b\u046d\7\6\2\2\u046c\u046e\7Y\2\2\u046d\u046c\3\2"+
		"\2\2\u046d\u046e\3\2\2\2\u046e\u0470\3\2\2\2\u046f\u0467\3\2\2\2\u046f"+
		"\u046b\3\2\2\2\u0470\u0471\3\2\2\2\u0471\u0487\7P\2\2\u0472\u0473\7g\2"+
		"\2\u0473\u0475\5p9\2\u0474\u0476\7\u012e\2\2\u0475\u0474\3\2\2\2\u0475"+
		"\u0476\3\2\2\2\u0476\u0478\3\2\2\2\u0477\u0472\3\2\2\2\u0478\u0479\3\2"+
		"\2\2\u0479\u0477\3\2\2\2\u0479\u047a\3\2\2\2\u047a\u0488\3\2\2\2\u047b"+
		"\u047c\7\6\2\2\u047c\u047d\7h\2\2\u047d\u047e\79\2\2\u047e\u0483\7f\2"+
		"\2\u047f\u0481\5p9\2\u0480\u0482\7\u012e\2\2\u0481\u0480\3\2\2\2\u0481"+
		"\u0482\3\2\2\2\u0482\u0484\3\2\2\2\u0483\u047f\3\2\2\2\u0484\u0485\3\2"+
		"\2\2\u0485\u0483\3\2\2\2\u0485\u0486\3\2\2\2\u0486\u0488\3\2\2\2\u0487"+
		"\u0477\3\2\2\2\u0487\u047b\3\2\2\2\u0488\u0489\3\2\2\2\u0489\u048a\5\32"+
		"\16\2\u048a\u0556\3\2\2\2\u048b\u0498\7\62\2\2\u048c\u048e\t\7\2\2\u048d"+
		"\u048f\7\u012e\2\2\u048e\u048d\3\2\2\2\u048e\u048f\3\2\2\2\u048f\u0491"+
		"\3\2\2\2\u0490\u048c\3\2\2\2\u0491\u0492\3\2\2\2\u0492\u0490\3\2\2\2\u0492"+
		"\u0493\3\2\2\2\u0493\u0499\3\2\2\2\u0494\u0496\7\6\2\2\u0495\u0497\7Y"+
		"\2\2\u0496\u0495\3\2\2\2\u0496\u0497\3\2\2\2\u0497\u0499\3\2\2\2\u0498"+
		"\u0490\3\2\2\2\u0498\u0494\3\2\2\2\u0499\u049a\3\2\2\2\u049a\u049b\7P"+
		"\2\2\u049b\u04a0\7\31\2\2\u049c\u049e\5p9\2\u049d\u049f\7\u012e\2\2\u049e"+
		"\u049d\3\2\2\2\u049e\u049f\3\2\2\2\u049f\u04a1\3\2\2\2\u04a0\u049c\3\2"+
		"\2\2\u04a1\u04a2\3\2\2\2\u04a2\u04a0\3\2\2\2\u04a2\u04a3\3\2\2\2\u04a3"+
		"\u04a4\3\2\2\2\u04a4\u04a5\5\32\16\2\u04a5\u0556\3\2\2\2\u04a6\u04ac\7"+
		"\62\2\2\u04a7\u04ad\7{\2\2\u04a8\u04aa\7\6\2\2\u04a9\u04ab\7Y\2\2\u04aa"+
		"\u04a9\3\2\2\2\u04aa\u04ab\3\2\2\2\u04ab\u04ad\3\2\2\2\u04ac\u04a7\3\2"+
		"\2\2\u04ac\u04a8\3\2\2\2\u04ad\u04ae\3\2\2\2\u04ae\u04af\7P\2\2\u04af"+
		"\u04b0\7,\2\2\u04b0\u04b1\7\u0099\2\2\u04b1\u04b6\7\u00fe\2\2\u04b2\u04b4"+
		"\5p9\2\u04b3\u04b5\7\u012e\2\2\u04b4\u04b3\3\2\2\2\u04b4\u04b5\3\2\2\2"+
		"\u04b5\u04b7\3\2\2\2\u04b6\u04b2\3\2\2\2\u04b7\u04b8\3\2\2\2\u04b8\u04b6"+
		"\3\2\2\2\u04b8\u04b9\3\2\2\2\u04b9\u04ba\3\2\2\2\u04ba\u04bb\5\32\16\2"+
		"\u04bb\u0556\3\2\2\2\u04bc\u04c2\7\62\2\2\u04bd\u04c3\7{\2\2\u04be\u04c0"+
		"\7\6\2\2\u04bf\u04c1\7Y\2\2\u04c0\u04bf\3\2\2\2\u04c0\u04c1\3\2\2\2\u04c1"+
		"\u04c3\3\2\2\2\u04c2\u04bd\3\2\2\2\u04c2\u04be\3\2\2\2\u04c3\u04c4\3\2"+
		"\2\2\u04c4\u04c5\7P\2\2\u04c5\u04c6\7,\2\2\u04c6\u04cb\7\u00e0\2\2\u04c7"+
		"\u04c9\5p9\2\u04c8\u04ca\7\u012e\2\2\u04c9\u04c8\3\2\2\2\u04c9\u04ca\3"+
		"\2\2\2\u04ca\u04cc\3\2\2\2\u04cb\u04c7\3\2\2\2\u04cc\u04cd\3\2\2\2\u04cd"+
		"\u04cb\3\2\2\2\u04cd\u04ce\3\2\2\2\u04ce\u04cf\3\2\2\2\u04cf\u04d0\5\32"+
		"\16\2\u04d0\u0556\3\2\2\2\u04d1\u04d7\7\62\2\2\u04d2\u04d8\7(\2\2\u04d3"+
		"\u04d5\7\6\2\2\u04d4\u04d6\7Y\2\2\u04d5\u04d4\3\2\2\2\u04d5\u04d6\3\2"+
		"\2\2\u04d6\u04d8\3\2\2\2\u04d7\u04d2\3\2\2\2\u04d7\u04d3\3\2\2\2\u04d8"+
		"\u04d9\3\2\2\2\u04d9\u04dc\7P\2\2\u04da\u04dd\5&\24\2\u04db\u04dd\5(\25"+
		"\2\u04dc\u04da\3\2\2\2\u04dc\u04db\3\2\2\2\u04dd\u04de\3\2\2\2\u04de\u04df"+
		"\5\32\16\2\u04df\u0556\3\2\2\2\u04e0\u04e6\7\62\2\2\u04e1\u04e7\7{\2\2"+
		"\u04e2\u04e4\7\6\2\2\u04e3\u04e5\7Y\2\2\u04e4\u04e3\3\2\2\2\u04e4\u04e5"+
		"\3\2\2\2\u04e5\u04e7\3\2\2\2\u04e6\u04e1\3\2\2\2\u04e6\u04e2\3\2\2\2\u04e7"+
		"\u04e8\3\2\2\2\u04e8\u04e9\7P\2\2\u04e9\u04ee\7\u00b9\2\2\u04ea\u04ec"+
		"\5p9\2\u04eb\u04ed\7\u012e\2\2\u04ec\u04eb\3\2\2\2\u04ec\u04ed\3\2\2\2"+
		"\u04ed\u04ef\3\2\2\2\u04ee\u04ea\3\2\2\2\u04ef\u04f0\3\2\2\2\u04f0\u04ee"+
		"\3\2\2\2\u04f0\u04f1\3\2\2\2\u04f1\u04f2\3\2\2\2\u04f2\u04f3\5\32\16\2"+
		"\u04f3\u0556\3\2\2\2\u04f4\u0501\7\62\2\2\u04f5\u04f7\t\n\2\2\u04f6\u04f8"+
		"\7\u012e\2\2\u04f7\u04f6\3\2\2\2\u04f7\u04f8\3\2\2\2\u04f8\u04fa\3\2\2"+
		"\2\u04f9\u04f5\3\2\2\2\u04fa\u04fb\3\2\2\2\u04fb\u04f9\3\2\2\2\u04fb\u04fc"+
		"\3\2\2\2\u04fc\u0502\3\2\2\2\u04fd\u04ff\7\6\2\2\u04fe\u0500\7Y\2\2\u04ff"+
		"\u04fe\3\2\2\2\u04ff\u0500\3\2\2\2\u0500\u0502\3\2\2\2\u0501\u04f9\3\2"+
		"\2\2\u0501\u04fd\3\2\2\2\u0502\u0503\3\2\2\2\u0503\u0504\7P\2\2\u0504"+
		"\u0505\7\u00ba\2\2\u0505\u050a\7\u00cd\2\2\u0506\u0508\5p9\2\u0507\u0509"+
		"\7\u012e\2\2\u0508\u0507\3\2\2\2\u0508\u0509\3\2\2\2\u0509\u050b\3\2\2"+
		"\2\u050a\u0506\3\2\2\2\u050b\u050c\3\2\2\2\u050c\u050a\3\2\2\2\u050c\u050d"+
		"\3\2\2\2\u050d\u050e\3\2\2\2\u050e\u050f\5\32\16\2\u050f\u0556\3\2\2\2"+
		"\u0510\u051d\7\62\2\2\u0511\u0513\t\b\2\2\u0512\u0514\7\u012e\2\2\u0513"+
		"\u0512\3\2\2\2\u0513\u0514\3\2\2\2\u0514\u0516\3\2\2\2\u0515\u0511\3\2"+
		"\2\2\u0516\u0517\3\2\2\2\u0517\u0515\3\2\2\2\u0517\u0518\3\2\2\2\u0518"+
		"\u051e\3\2\2\2\u0519\u051b\7\6\2\2\u051a\u051c\7Y\2\2\u051b\u051a\3\2"+
		"\2\2\u051b\u051c\3\2\2\2\u051c\u051e\3\2\2\2\u051d\u0515\3\2\2\2\u051d"+
		"\u0519\3\2\2\2\u051e\u051f\3\2\2\2\u051f\u0520\7P\2\2\u0520\u0525\7f\2"+
		"\2\u0521\u0523\5p9\2\u0522\u0524\7\u012e\2\2\u0523\u0522\3\2\2\2\u0523"+
		"\u0524\3\2\2\2\u0524\u0526\3\2\2\2\u0525\u0521\3\2\2\2\u0526\u0527\3\2"+
		"\2\2\u0527\u0525\3\2\2\2\u0527\u0528\3\2\2\2\u0528\u0529\3\2\2\2\u0529"+
		"\u052a\5\32\16\2\u052a\u0556\3\2\2\2\u052b\u0531\7\62\2\2\u052c\u0532"+
		"\7\27\2\2\u052d\u052f\7\6\2\2\u052e\u0530\7Y\2\2\u052f\u052e\3\2\2\2\u052f"+
		"\u0530\3\2\2\2\u0530\u0532\3\2\2\2\u0531\u052c\3\2\2\2\u0531\u052d\3\2"+
		"\2\2\u0532\u0533\3\2\2\2\u0533\u0534\7P\2\2\u0534\u0539\7\u00eb\2\2\u0535"+
		"\u0537\5p9\2\u0536\u0538\7\u012e\2\2\u0537\u0536\3\2\2\2\u0537\u0538\3"+
		"\2\2\2\u0538\u053a\3\2\2\2\u0539\u0535\3\2\2\2\u053a\u053b\3\2\2\2\u053b"+
		"\u0539\3\2\2\2\u053b\u053c\3\2\2\2\u053c\u053d\3\2\2\2\u053d\u053e\5\32"+
		"\16\2\u053e\u0543\7\62\2\2\u053f\u0541\5p9\2\u0540\u0542\7\u012e\2\2\u0541"+
		"\u0540\3\2\2\2\u0541\u0542\3\2\2\2\u0542\u0544\3\2\2\2\u0543\u053f\3\2"+
		"\2\2\u0544\u0545\3\2\2\2\u0545\u0543\3\2\2\2\u0545\u0546\3\2\2\2\u0546"+
		"\u0547\3\2\2\2\u0547\u054c\7\u00f3\2\2\u0548\u054a\5p9\2\u0549\u054b\7"+
		"\u012e\2\2\u054a\u0549\3\2\2\2\u054a\u054b\3\2\2\2\u054b\u054d\3\2\2\2"+
		"\u054c\u0548\3\2\2\2\u054d\u054e\3\2\2\2\u054e\u054c\3\2\2\2\u054e\u054f"+
		"\3\2\2\2\u054f\u0553\3\2\2\2\u0550\u0551\7\u0081\2\2\u0551\u0552\7\u0083"+
		"\2\2\u0552\u0554\7\u00ce\2\2\u0553\u0550\3\2\2\2\u0553\u0554\3\2\2\2\u0554"+
		"\u0556\3\2\2\2\u0555\u0410\3\2\2\2\u0555\u0438\3\2\2\2\u0555\u0462\3\2"+
		"\2\2\u0555\u048b\3\2\2\2\u0555\u04a6\3\2\2\2\u0555\u04bc\3\2\2\2\u0555"+
		"\u04d1\3\2\2\2\u0555\u04e0\3\2\2\2\u0555\u04f4\3\2\2\2\u0555\u0510\3\2"+
		"\2\2\u0555\u052b\3\2\2\2\u0556\31\3\2\2\2\u0557\u0562\7\u00f3\2\2\u0558"+
		"\u055a\7\63\2\2\u0559\u0558\3\2\2\2\u0559\u055a\3\2\2\2\u055a\u055d\3"+
		"\2\2\2\u055b\u055e\5p9\2\u055c\u055e\7\u00d6\2\2\u055d\u055b\3\2\2\2\u055d"+
		"\u055c\3\2\2\2\u055e\u0560\3\2\2\2\u055f\u0561\7\u012e\2\2\u0560\u055f"+
		"\3\2\2\2\u0560\u0561\3\2\2\2\u0561\u0563\3\2\2\2\u0562\u0559\3\2\2\2\u0563"+
		"\u0564\3\2\2\2\u0564\u0562\3\2\2\2\u0564\u0565\3\2\2\2\u0565\u0569\3\2"+
		"\2\2\u0566\u0567\7\u0081\2\2\u0567\u0568\7\62\2\2\u0568\u056a\7\u00ce"+
		"\2\2\u0569\u0566\3\2\2\2\u0569\u056a\3\2\2\2\u056a\33\3\2\2\2\u056b\u056c"+
		"\7\u0090\2\2\u056c\u05e4\7P\2\2\u056d\u056e\7\3\2\2\u056e\u056f\5\u016c"+
		"\u00b7\2\u056f\u0576\7\u0135\2\2\u0570\u0572\5\u0082B\2\u0571\u0573\7"+
		"\u012e\2\2\u0572\u0571\3\2\2\2\u0572\u0573\3\2\2\2\u0573\u0575\3\2\2\2"+
		"\u0574\u0570\3\2\2\2\u0575\u0578\3\2\2\2\u0576\u0574\3\2\2\2\u0576\u0577"+
		"\3\2\2\2\u0577\u0579\3\2\2\2\u0578\u0576\3\2\2\2\u0579\u057a\7\u0136\2"+
		"\2\u057a\u05e5\3\2\2\2\u057b\u057c\7\20\2\2\u057c\u057d\7\u0135\2\2\u057d"+
		"\u057e\5\u0082B\2\u057e\u057f\7\5\2\2\u057f\u0580\5\u0082B\2\u0580\u0581"+
		"\7\u0136\2\2\u0581\u05e5\3\2\2\2\u0582\u0583\7\22\2\2\u0583\u05e5\5\u016c"+
		"\u00b7\2\u0584\u0585\7\u008f\2\2\u0585\u05e5\5\u016c\u00b7\2\u0586\u0587"+
		"\7\24\2\2\u0587\u0588\5\u016c\u00b7\2\u0588\u0589\7P\2\2\u0589\u058a\5"+
		"\u016c\u00b7\2\u058a\u05e5\3\2\2\2\u058b\u058c\7\26\2\2\u058c\u05e5\5"+
		"\u016c\u00b7\2\u058d\u058e\7\31\2\2\u058e\u05e5\5\u016c\u00b7\2\u058f"+
		"\u0590\7!\2\2\u0590\u05e5\5\u016c\u00b7\2\u0591\u0592\7)\2\2\u0592\u05e5"+
		"\5\u016c\u00b7\2\u0593\u0594\7,\2\2\u0594\u0595\7\u0099\2\2\u0595\u0596"+
		"\7\u00fe\2\2\u0596\u05e5\5\u016c\u00b7\2\u0597\u0598\7,\2\2\u0598\u0599"+
		"\7o\2\2\u0599\u05e5\5\u016c\u00b7\2\u059a\u059b\7.\2\2\u059b\u05e5\5\u01b4"+
		"\u00db\2\u059c\u059d\7\u00af\2\2\u059d\u05e5\5\u016c\u00b7\2\u059e\u059f"+
		"\7\u00ba\2\2\u059f\u05a0\7\u00cd\2\2\u05a0\u05e5\5p9\2\u05a1\u05a2\7S"+
		"\2\2\u05a2\u05a3\5\u016c\u00b7\2\u05a3\u05a4\7\u0135\2\2\u05a4\u05a5\5"+
		"\u0082B\2\u05a5\u05a6\7\u012e\2\2\u05a6\u05a7\5\u0082B\2\u05a7\u05a8\7"+
		"\u0136\2\2\u05a8\u05e5\3\2\2\2\u05a9\u05aa\7S\2\2\u05aa\u05ab\7\u0089"+
		"\2\2\u05ab\u05ac\5\u016c\u00b7\2\u05ac\u05ad\7|\2\2\u05ad\u05ae\5p9\2"+
		"\u05ae\u05e5\3\2\2\2\u05af\u05b0\7S\2\2\u05b0\u05b1\7\u00a7\2\2\u05b1"+
		"\u05b2\5\u016c\u00b7\2\u05b2\u05b3\7|\2\2\u05b3\u05b4\5p9\2\u05b4\u05e5"+
		"\3\2\2\2\u05b5\u05b7\7[\2\2\u05b6\u05b5\3\2\2\2\u05b6\u05b7\3\2\2\2\u05b7"+
		"\u05b8\3\2\2\2\u05b8\u05b9\7\u00b9\2\2\u05b9\u05e5\5\u016c\u00b7\2\u05ba"+
		"\u05bb\7\\\2\2\u05bb\u05e5\5\u016c\u00b7\2\u05bc\u05bd\7e\2\2\u05bd\u05be"+
		"\5\u016c\u00b7\2\u05be\u05bf\7P\2\2\u05bf\u05c0\5\u016c\u00b7\2\u05c0"+
		"\u05e5\3\2\2\2\u05c1\u05c2\7f\2\2\u05c2\u05e5\5\u016c\u00b7\2\u05c3\u05c4"+
		"\7g\2\2\u05c4\u05e5\5\u016c\u00b7\2\u05c5\u05c6\7\u00e0\2\2\u05c6\u05e5"+
		"\5\u016c\u00b7\2\u05c7\u05c8\7o\2\2\u05c8\u05e5\5\u016c\u00b7\2\u05c9"+
		"\u05ca\7\u00eb\2\2\u05ca\u05e5\5\u016c\u00b7\2\u05cb\u05cc\7\u011f\2\2"+
		"\u05cc\u05cd\7\u00dd\2\2\u05cd\u05ce\7\u0093\2\2\u05ce\u05e5\5\u016c\u00b7"+
		"\2\u05cf\u05d0\7\u011f\2\2\u05d0\u05d1\7\u00dd\2\2\u05d1\u05d2\7\u009e"+
		"\2\2\u05d2\u05e5\5\u016c\u00b7\2\u05d3\u05d4\7\u011f\2\2\u05d4\u05d5\7"+
		"\u00dd\2\2\u05d5\u05d6\7\u00d1\2\2\u05d6\u05e5\5\u016c\u00b7\2\u05d7\u05d8"+
		"\7\u011f\2\2\u05d8\u05d9\7\u00dd\2\2\u05d9\u05da\7\u00ed\2\2\u05da\u05e5"+
		"\5\u016c\u00b7\2\u05db\u05dc\7t\2\2\u05dc\u05dd\5\u016c\u00b7\2\u05dd"+
		"\u05de\7P\2\2\u05de\u05df\5\u016c\u00b7\2\u05df\u05e5\3\2\2\2\u05e0\u05e1"+
		"\7w\2\2\u05e1\u05e5\5\u016c\u00b7\2\u05e2\u05e3\7~\2\2\u05e3\u05e5\5\u016c"+
		"\u00b7\2\u05e4\u056d\3\2\2\2\u05e4\u057b\3\2\2\2\u05e4\u0582\3\2\2\2\u05e4"+
		"\u0584\3\2\2\2\u05e4\u0586\3\2\2\2\u05e4\u058b\3\2\2\2\u05e4\u058d\3\2"+
		"\2\2\u05e4\u058f\3\2\2\2\u05e4\u0591\3\2\2\2\u05e4\u0593\3\2\2\2\u05e4"+
		"\u0597\3\2\2\2\u05e4\u059a\3\2\2\2\u05e4\u059c\3\2\2\2\u05e4\u059e\3\2"+
		"\2\2\u05e4\u05a1\3\2\2\2\u05e4\u05a9\3\2\2\2\u05e4\u05af\3\2\2\2\u05e4"+
		"\u05b6\3\2\2\2\u05e4\u05ba\3\2\2\2\u05e4\u05bc\3\2\2\2\u05e4\u05c1\3\2"+
		"\2\2\u05e4\u05c3\3\2\2\2\u05e4\u05c5\3\2\2\2\u05e4\u05c7\3\2\2\2\u05e4"+
		"\u05c9\3\2\2\2\u05e4\u05cb\3\2\2\2\u05e4\u05cf\3\2\2\2\u05e4\u05d3\3\2"+
		"\2\2\u05e4\u05d7\3\2\2\2\u05e4\u05db\3\2\2\2\u05e4\u05e0\3\2\2\2\u05e4"+
		"\u05e2\3\2\2\2\u05e5\u05e6\3\2\2\2\u05e6\u05e7\7C\2\2\u05e7\u05e8\7\u0148"+
		"\2\2\u05e8\35\3\2\2\2\u05e9\u05ec\7\27\2\2\u05ea\u05eb\7T\2\2\u05eb\u05ed"+
		"\7`\2\2\u05ec\u05ea\3\2\2\2\u05ec\u05ed\3\2\2\2\u05ed\u05ee\3\2\2\2\u05ee"+
		"\u05ef\7.\2\2\u05ef\u05f0\5p9\2\u05f0\u0604\7\u0135\2\2\u05f1\u05f3\5"+
		"$\23\2\u05f2\u05f1\3\2\2\2\u05f2\u05f3\3\2\2\2\u05f3\u05f5\3\2\2\2\u05f4"+
		"\u05f6\5p9\2\u05f5\u05f4\3\2\2\2\u05f5\u05f6\3\2\2\2\u05f6\u05f7\3\2\2"+
		"\2\u05f7\u0602\5\u0082B\2\u05f8\u05ff\7\32\2\2\u05f9\u05fa\7\u012b\2\2"+
		"\u05fa\u05fc\5\u01b4\u00db\2\u05fb\u05fd\7\u012e\2\2\u05fc\u05fb\3\2\2"+
		"\2\u05fc\u05fd\3\2\2\2\u05fd\u05ff\3\2\2\2\u05fe\u05f8\3\2\2\2\u05fe\u05f9"+
		"\3\2\2\2\u05ff\u0600\3\2\2\2\u0600\u05fe\3\2\2\2\u0600\u0601\3\2\2\2\u0601"+
		"\u0603\3\2\2\2\u0602\u05fe\3\2\2\2\u0602\u0603\3\2\2\2\u0603\u0605\3\2"+
		"\2\2\u0604\u05f2\3\2\2\2\u0604\u0605\3\2\2\2\u0605\u0606\3\2\2\2\u0606"+
		"\u0617\7\u0136\2\2\u0607\u0608\7b\2\2\u0608\u0618\5\u0082B\2\u0609\u060a"+
		"\7b\2\2\u060a\u060b\7o\2\2\u060b\u0611\7\u0135\2\2\u060c\u060d\5p9\2\u060d"+
		"\u060f\5\u0082B\2\u060e\u0610\7\u012e\2\2\u060f\u060e\3\2\2\2\u060f\u0610"+
		"\3\2\2\2\u0610\u0612\3\2\2\2\u0611\u060c\3\2\2\2\u0612\u0613\3\2\2\2\u0613"+
		"\u0611\3\2\2\2\u0613\u0614\3\2\2\2\u0614\u0615\3\2\2\2\u0615\u0616\7\u0136"+
		"\2\2\u0616\u0618\3\2\2\2\u0617\u0607\3\2\2\2\u0617\u0609\3\2\2\2\u0617"+
		"\u0618\3\2\2\2\u0618\u0647\3\2\2\2\u0619\u061a\7\u00b9\2\2\u061a\u0648"+
		"\5p9\2\u061b\u0648\7\u00fd\2\2\u061c\u0648\78\2\2\u061d\u0648\7\u00e4"+
		"\2\2\u061e\u0648\7\u00fb\2\2\u061f\u0620\7\u0088\2\2\u0620\u0621\7P\2"+
		"\2\u0621\u0622\7M\2\2\u0622\u0648\7\u00b2\2\2\u0623\u0624\7b\2\2\u0624"+
		"\u0625\7M\2\2\u0625\u0626\7P\2\2\u0626\u0627\7M\2\2\u0627\u0648\7\u00b2"+
		"\2\2\u0628\u0648\7m\2\2\u0629\u062b\7\u00a5\2\2\u062a\u0629\3\2\2\2\u062a"+
		"\u062b\3\2\2\2\u062b\u062c\3\2\2\2\u062c\u062d\7\u00df\2\2\u062d\u0648"+
		"\7B\2\2\u062e\u0630\7\u00a5\2\2\u062f\u062e\3\2\2\2\u062f\u0630\3\2\2"+
		"\2\u0630\u0631\3\2\2\2\u0631\u0632\7\u00df\2\2\u0632\u0648\7\u009d\2\2"+
		"\u0633\u0634\7\u0094\2\2\u0634\u0648\7\u0143\2\2\u0635\u0636\7^\2\2\u0636"+
		"\u0648\7\u0143\2\2\u0637\u0638\7\u00e1\2\2\u0638\u063f\5p9\2\u0639\u063a"+
		"\7\u00f3\2\2\u063a\u0640\7\u0148\2\2\u063b\u063c\7\u012b\2\2\u063c\u0640"+
		"\7\u0148\2\2\u063d\u063e\7\60\2\2\u063e\u0640\7\u0097\2\2\u063f\u0639"+
		"\3\2\2\2\u063f\u063b\3\2\2\2\u063f\u063d\3\2\2\2\u0640\u0648\3\2\2\2\u0641"+
		"\u0642\7\5\2\2\u0642\u0648\5 \21\2\u0643\u0644\7\5\2\2\u0644\u0645\7\u0148"+
		"\2\2\u0645\u0646\7\u012e\2\2\u0646\u0648\7\u0148\2\2\u0647\u0619\3\2\2"+
		"\2\u0647\u061b\3\2\2\2\u0647\u061c\3\2\2\2\u0647\u061d\3\2\2\2\u0647\u061e"+
		"\3\2\2\2\u0647\u061f\3\2\2\2\u0647\u0623\3\2\2\2\u0647\u0628\3\2\2\2\u0647"+
		"\u062a\3\2\2\2\u0647\u062f\3\2\2\2\u0647\u0633\3\2\2\2\u0647\u0635\3\2"+
		"\2\2\u0647\u0637\3\2\2\2\u0647\u0641\3\2\2\2\u0647\u0643\3\2\2\2\u0648"+
		"\u0649\3\2\2\2\u0649\u0647\3\2\2\2\u0649\u064a\3\2\2\2\u064a\u0657\3\2"+
		"\2\2\u064b\u064c\7\u0081\2\2\u064c\u0651\7\u0135\2\2\u064d\u064f\5\"\22"+
		"\2\u064e\u0650\7\u012e\2\2\u064f\u064e\3\2\2\2\u064f\u0650\3\2\2\2\u0650"+
		"\u0652\3\2\2\2\u0651\u064d\3\2\2\2\u0652\u0653\3\2\2\2\u0653\u0651\3\2"+
		"\2\2\u0653\u0654\3\2\2\2\u0654\u0655\3\2\2\2\u0655\u0656\7\u0136\2\2\u0656"+
		"\u0658\3\2\2\2\u0657\u064b\3\2\2\2\u0657\u0658\3\2\2\2\u0658\37\3\2\2"+
		"\2\u0659\u065d\7\u0142\2\2\u065a\u065c\n\13\2\2\u065b\u065a\3\2\2\2\u065c"+
		"\u065f\3\2\2\2\u065d\u065b\3\2\2\2\u065d\u065e\3\2\2\2\u065e\u0660\3\2"+
		"\2\2\u065f\u065d\3\2\2\2\u0660\u0661\7\u0142\2\2\u0661!\3\2\2\2\u0662"+
		"\u0663\t\f\2\2\u0663#\3\2\2\2\u0664\u0665\t\r\2\2\u0665%\3\2\2\2\u0666"+
		"\u0667\7.\2\2\u0667\u0668\5p9\2\u0668\u0675\7\u0135\2\2\u0669\u066b\5"+
		"$\23\2\u066a\u0669\3\2\2\2\u066a\u066b\3\2\2\2\u066b\u066d\3\2\2\2\u066c"+
		"\u066e\5p9\2\u066d\u066c\3\2\2\2\u066d\u066e\3\2\2\2\u066e\u066f\3\2\2"+
		"\2\u066f\u0671\5\u0082B\2\u0670\u0672\7\u012e\2\2\u0671\u0670\3\2\2\2"+
		"\u0671\u0672\3\2\2\2\u0672\u0674\3\2\2\2\u0673\u066a\3\2\2\2\u0674\u0677"+
		"\3\2\2\2\u0675\u0673\3\2\2\2\u0675\u0676\3\2\2\2\u0676\u0678\3\2\2\2\u0677"+
		"\u0675\3\2\2\2\u0678\u0679\7\u0136\2\2\u0679\'\3\2\2\2\u067a\u067b\7\6"+
		"\2\2\u067b\u067c\7/\2\2\u067c\u067d\79\2\2\u067d\u0682\7f\2\2\u067e\u0680"+
		"\5p9\2\u067f\u0681\7\u012e\2\2\u0680\u067f\3\2\2\2\u0680\u0681\3\2\2\2"+
		"\u0681\u0683\3\2\2\2\u0682\u067e\3\2\2\2\u0683\u0684\3\2\2\2\u0684\u0682"+
		"\3\2\2\2\u0684\u0685\3\2\2\2\u0685)\3\2\2\2\u0686\u0688\7\27\2\2\u0687"+
		"\u0689\t\16\2\2\u0688\u0687\3\2\2\2\u0688\u0689\3\2\2\2\u0689\u068a\3"+
		"\2\2\2\u068a\u068b\7g\2\2\u068b\u06b0\5\u016c\u00b7\2\u068c\u068e\7\u00b1"+
		"\2\2\u068d\u068f\7\u0086\2\2\u068e\u068d\3\2\2\2\u068e\u068f\3\2\2\2\u068f"+
		"\u0690\3\2\2\2\u0690\u06af\7\u0143\2\2\u0691\u0692\7\u00c6\2\2\u0692\u0696"+
		"\7\u0143\2\2\u0693\u0694\7\u00ca\2\2\u0694\u0696\7\u00c6\2\2\u0695\u0691"+
		"\3\2\2\2\u0695\u0693\3\2\2\2\u0696\u06af\3\2\2\2\u0697\u0698\7\u00c1\2"+
		"\2\u0698\u069c\5\u0092J\2\u0699\u069a\7\u00ca\2\2\u069a\u069c\7\u00c1"+
		"\2\2\u069b\u0697\3\2\2\2\u069b\u0699\3\2\2\2\u069c\u06af\3\2\2\2\u069d"+
		"\u069f\7\u00e5\2\2\u069e\u06a0\7\u0081\2\2\u069f\u069e\3\2\2\2\u069f\u06a0"+
		"\3\2\2\2\u06a0\u06a1\3\2\2\2\u06a1\u06af\7\u0143\2\2\u06a2\u06a3\7\u0087"+
		"\2\2\u06a3\u06af\7\u0143\2\2\u06a4\u06a6\7\u00ca\2\2\u06a5\u06a4\3\2\2"+
		"\2\u06a5\u06a6\3\2\2\2\u06a6\u06a7\3\2\2\2\u06a7\u06af\7\u0098\2\2\u06a8"+
		"\u06a9\7V\2\2\u06a9\u06ac\7\u0086\2\2\u06aa\u06ad\5\u016c\u00b7\2\u06ab"+
		"\u06ad\7\u00cb\2\2\u06ac\u06aa\3\2\2\2\u06ac\u06ab\3\2\2\2\u06ad\u06af"+
		"\3\2\2\2\u06ae\u068c\3\2\2\2\u06ae\u0695\3\2\2\2\u06ae\u069b\3\2\2\2\u06ae"+
		"\u069d\3\2\2\2\u06ae\u06a2\3\2\2\2\u06ae\u06a5\3\2\2\2\u06ae\u06a8\3\2"+
		"\2\2\u06af\u06b2\3\2\2\2\u06b0\u06ae\3\2\2\2\u06b0\u06b1\3\2\2\2\u06b1"+
		"+\3\2\2\2\u06b2\u06b0\3\2\2\2\u06b3\u06b4\7\27\2\2\u06b4\u06b5\7f\2\2"+
		"\u06b5\u06b8\5p9\2\u06b6\u06b7\7\13\2\2\u06b7\u06b9\5p9\2\u06b8\u06b6"+
		"\3\2\2\2\u06b8\u06b9\3\2\2\2\u06b9\u06bd\3\2\2\2\u06ba\u06bc\5\2\2\2\u06bb"+
		"\u06ba\3\2\2\2\u06bc\u06bf\3\2\2\2\u06bd\u06bb\3\2\2\2\u06bd\u06be\3\2"+
		"\2\2\u06be\u06dc\3\2\2\2\u06bf\u06bd\3\2\2\2\u06c0\u06c1\7\27\2\2\u06c1"+
		"\u06c2\7f\2\2\u06c2\u06c3\7\13\2\2\u06c3\u06c7\5p9\2\u06c4\u06c6\5\2\2"+
		"\2\u06c5\u06c4\3\2\2\2\u06c6\u06c9\3\2\2\2\u06c7\u06c5\3\2\2\2\u06c7\u06c8"+
		"\3\2\2\2\u06c8\u06dc\3\2\2\2\u06c9\u06c7\3\2\2\2\u06ca\u06cb\7\27\2\2"+
		"\u06cb\u06cc\7f\2\2\u06cc\u06cd\7\65\2\2\u06cd\u06ce\7L\2\2\u06ce\u06cf"+
		"\7\u00a4\2\2\u06cf\u06d2\5p9\2\u06d0\u06d1\7\13\2\2\u06d1\u06d3\5p9\2"+
		"\u06d2\u06d0\3\2\2\2\u06d2\u06d3\3\2\2\2\u06d3\u06dc\3\2\2\2\u06d4\u06d5"+
		"\7\27\2\2\u06d5\u06d6\7f\2\2\u06d6\u06d7\7\65\2\2\u06d7\u06d8\7L\2\2\u06d8"+
		"\u06d9\7\u00a4\2\2\u06d9\u06da\7\13\2\2\u06da\u06dc\5p9\2\u06db\u06b3"+
		"\3\2\2\2\u06db\u06c0\3\2\2\2\u06db\u06ca\3\2\2\2\u06db\u06d4\3\2\2\2\u06dc"+
		"-\3\2\2\2\u06dd\u06de\7\27\2\2\u06de\u06df\7\u00a5\2\2\u06df\u06e0\7o"+
		"\2\2\u06e0\u06e1\5\u016c\u00b7\2\u06e1\u06e2\5D#\2\u06e2\u06e3\7|\2\2"+
		"\u06e3\u06e5\5p9\2\u06e4\u06e6\5J&\2\u06e5\u06e4\3\2\2\2\u06e5\u06e6\3"+
		"\2\2\2\u06e6\u06e8\3\2\2\2\u06e7\u06e9\5T+\2\u06e8\u06e7\3\2\2\2\u06e8"+
		"\u06e9\3\2\2\2\u06e9\u06ea\3\2\2\2\u06ea\u06eb\7\u00be\2\2\u06eb\u06ec"+
		"\7\u0148\2\2\u06ec\u0780\3\2\2\2\u06ed\u06ee\7\27\2\2\u06ee\u06ef\7o\2"+
		"\2\u06ef\u06f0\5\u016c\u00b7\2\u06f0\u06f3\5D#\2\u06f1\u06f2\7|\2\2\u06f2"+
		"\u06f4\5p9\2\u06f3\u06f1\3\2\2\2\u06f3\u06f4\3\2\2\2\u06f4\u06f6\3\2\2"+
		"\2\u06f5\u06f7\5J&\2\u06f6\u06f5\3\2\2\2\u06f6\u06f7\3\2\2\2\u06f7\u06f9"+
		"\3\2\2\2\u06f8\u06fa\5T+\2\u06f9\u06f8\3\2\2\2\u06f9\u06fa\3\2\2\2\u06fa"+
		"\u06fd\3\2\2\2\u06fb\u06fc\7\5\2\2\u06fc\u06fe\5\u0158\u00ad\2\u06fd\u06fb"+
		"\3\2\2\2\u06fd\u06fe\3\2\2\2\u06fe\u0780\3\2\2\2\u06ff\u0700\7\27\2\2"+
		"\u0700\u0701\7o\2\2\u0701\u0704\5\u016c\u00b7\2\u0702\u0703\7|\2\2\u0703"+
		"\u0705\5p9\2\u0704\u0702\3\2\2\2\u0704\u0705\3\2\2\2\u0705\u0707\3\2\2"+
		"\2\u0706\u0708\5J&\2\u0707\u0706\3\2\2\2\u0707\u0708\3\2\2\2\u0708\u070a"+
		"\3\2\2\2\u0709\u070b\5T+\2\u070a\u0709\3\2\2\2\u070a\u070b\3\2\2\2\u070b"+
		"\u070c\3\2\2\2\u070c\u070d\7\5\2\2\u070d\u070e\5\u0158\u00ad\2\u070e\u0780"+
		"\3\2\2\2\u070f\u0715\7\27\2\2\u0710\u0712\t\17\2\2\u0711\u0710\3\2\2\2"+
		"\u0711\u0712\3\2\2\2\u0712\u0713\3\2\2\2\u0713\u0716\t\16\2\2\u0714\u0716"+
		"\7\u00f5\2\2\u0715\u0711\3\2\2\2\u0715\u0714\3\2\2\2\u0715\u0716\3\2\2"+
		"\2\u0716\u0717\3\2\2\2\u0717\u071b\7o\2\2\u0718\u0719\7\65\2\2\u0719\u071a"+
		"\7L\2\2\u071a\u071c\7\u00a4\2\2\u071b\u0718\3\2\2\2\u071b\u071c\3\2\2"+
		"\2\u071c\u071d\3\2\2\2\u071d\u071e\5\u016c\u00b7\2\u071e\u073d\7\u0135"+
		"\2\2\u071f\u0720\5p9\2\u0720\u0723\5\u0082B\2\u0721\u0722\7\21\2\2\u0722"+
		"\u0724\5p9\2\u0723\u0721\3\2\2\2\u0723\u0724\3\2\2\2\u0724\u0728\3\2\2"+
		"\2\u0725\u0727\5\64\33\2\u0726\u0725\3\2\2\2\u0727\u072a\3\2\2\2\u0728"+
		"\u0726\3\2\2\2\u0728\u0729\3\2\2\2\u0729\u0735\3\2\2\2\u072a\u0728\3\2"+
		"\2\2\u072b\u0735\5\62\32\2\u072c\u072d\7H\2\2\u072d\u0731\5p9\2\u072e"+
		"\u0730\5\60\31\2\u072f\u072e\3\2\2\2\u0730\u0733\3\2\2\2\u0731\u072f\3"+
		"\2\2\2\u0731\u0732\3\2\2\2\u0732\u0735\3\2\2\2\u0733\u0731\3\2\2\2\u0734"+
		"\u071f\3\2\2\2\u0734\u072b\3\2\2\2\u0734\u072c\3\2\2\2\u0735\u0737\3\2"+
		"\2\2\u0736\u0738\7\u012e\2\2\u0737\u0736\3\2\2\2\u0737\u0738\3\2\2\2\u0738"+
		"\u073a\3\2\2\2\u0739\u0734\3\2\2\2\u073a\u073b\3\2\2\2\u073b\u0739\3\2"+
		"\2\2\u073b\u073c\3\2\2\2\u073c\u073e\3\2\2\2\u073d\u0739\3\2\2\2\u073d"+
		"\u073e\3\2\2\2\u073e\u073f\3\2\2\2\u073f\u074c\7\u0136\2\2\u0740\u0741"+
		"\7;\2\2\u0741\u0746\7\u0135\2\2\u0742\u0744\5p9\2\u0743\u0745\7\u012e"+
		"\2\2\u0744\u0743\3\2\2\2\u0744\u0745\3\2\2\2\u0745\u0747\3\2\2\2\u0746"+
		"\u0742\3\2\2\2\u0747\u0748\3\2\2\2\u0748\u0746\3\2\2\2\u0748\u0749\3\2"+
		"\2\2\u0749\u074a\3\2\2\2\u074a\u074b\7\u0136\2\2\u074b\u074d\3\2\2\2\u074c"+
		"\u0740\3\2\2\2\u074c\u074d\3\2\2\2\u074d\u074e\3\2\2\2\u074e\u074f\5:"+
		"\36\2\u074f\u0750\5<\37\2\u0750\u0751\5> \2\u0751\u0780\3\2\2\2\u0752"+
		"\u0758\7\27\2\2\u0753\u0755\t\17\2\2\u0754\u0753\3\2\2\2\u0754\u0755\3"+
		"\2\2\2\u0755\u0756\3\2\2\2\u0756\u0759\t\16\2\2\u0757\u0759\7\u00f5\2"+
		"\2\u0758\u0754\3\2\2\2\u0758\u0757\3\2\2\2\u0758\u0759\3\2\2\2\u0759\u075a"+
		"\3\2\2\2\u075a\u075e\7o\2\2\u075b\u075c\7\65\2\2\u075c\u075d\7L\2\2\u075d"+
		"\u075f\7\u00a4\2\2\u075e\u075b\3\2\2\2\u075e\u075f\3\2\2\2\u075f\u0760"+
		"\3\2\2\2\u0760\u0761\5\u016c\u00b7\2\u0761\u0762\7N\2\2\u0762\u0779\5"+
		"p9\2\u0763\u0773\7\u0135\2\2\u0764\u0765\5p9\2\u0765\u0766\7\u0081\2\2"+
		"\u0766\u076a\7\u00cf\2\2\u0767\u0769\5\64\33\2\u0768\u0767\3\2\2\2\u0769"+
		"\u076c\3\2\2\2\u076a\u0768\3\2\2\2\u076a\u076b\3\2\2\2\u076b\u076f\3\2"+
		"\2\2\u076c\u076a\3\2\2\2\u076d\u076f\5\62\32\2\u076e\u0764\3\2\2\2\u076e"+
		"\u076d\3\2\2\2\u076f\u0771\3\2\2\2\u0770\u0772\7\u012e\2\2\u0771\u0770"+
		"\3\2\2\2\u0771\u0772\3\2\2\2\u0772\u0774\3\2\2\2\u0773\u076e\3\2\2\2\u0774"+
		"\u0775\3\2\2\2\u0775\u0773\3\2\2\2\u0775\u0776\3\2\2\2\u0776\u0777\3\2"+
		"\2\2\u0777\u0778\7\u0136\2\2\u0778\u077a\3\2\2\2\u0779\u0763\3\2\2\2\u0779"+
		"\u077a\3\2\2\2\u077a\u077b\3\2\2\2\u077b\u077c\5:\36\2\u077c\u077d\5<"+
		"\37\2\u077d\u077e\5> \2\u077e\u0780\3\2\2\2\u077f\u06dd\3\2\2\2\u077f"+
		"\u06ed\3\2\2\2\u077f\u06ff\3\2\2\2\u077f\u070f\3\2\2\2\u077f\u0752\3\2"+
		"\2\2\u0780/\3\2\2\2\u0781\u0782\t\20\2\2\u0782\u0783\t\21\2\2\u0783\61"+
		"\3\2\2\2\u0784\u0785\7\24\2\2\u0785\u0787\5p9\2\u0786\u0784\3\2\2\2\u0786"+
		"\u0787\3\2\2\2\u0787\u07ea\3\2\2\2\u0788\u07eb\5\66\34\2\u0789\u078a\7"+
		"y\2\2\u078a\u078f\7\u0135\2\2\u078b\u078d\5p9\2\u078c\u078e\7\u012e\2"+
		"\2\u078d\u078c\3\2\2\2\u078d\u078e\3\2\2\2\u078e\u0790\3\2\2\2\u078f\u078b"+
		"\3\2\2\2\u0790\u0791\3\2\2\2\u0791\u078f\3\2\2\2\u0791\u0792\3\2\2\2\u0792"+
		"\u0793\3\2\2\2\u0793\u0794\7\u0136\2\2\u0794\u0795\5B\"\2\u0795\u07eb"+
		"\3\2\2\2\u0796\u0797\7X\2\2\u0797\u0798\7E\2\2\u0798\u079d\7\u0135\2\2"+
		"\u0799\u079b\5p9\2\u079a\u079c\7\u012e\2\2\u079b\u079a\3\2\2\2\u079b\u079c"+
		"\3\2\2\2\u079c\u079e\3\2\2\2\u079d\u0799\3\2\2\2\u079e\u079f\3\2\2\2\u079f"+
		"\u079d\3\2\2\2\u079f\u07a0\3\2\2\2\u07a0\u07a1\3\2\2\2\u07a1\u07a2\7\u0136"+
		"\2\2\u07a2\u07a3\5B\"\2\u07a3\u07eb\3\2\2\2\u07a4\u07a7\7&\2\2\u07a5\u07a6"+
		"\7|\2\2\u07a6\u07a8\5p9\2\u07a7\u07a5\3\2\2\2\u07a7\u07a8\3\2\2\2\u07a8"+
		"\u07a9\3\2\2\2\u07a9\u07aa\7\u0135\2\2\u07aa\u07ab\5p9\2\u07ab\u07b0\7"+
		"\u0081\2\2\u07ac\u07ae\5p9\2\u07ad\u07af\7\u012e\2\2\u07ae\u07ad\3\2\2"+
		"\2\u07ae\u07af\3\2\2\2\u07af\u07b1\3\2\2\2\u07b0\u07ac\3\2\2\2\u07b1\u07b2"+
		"\3\2\2\2\u07b2\u07b0\3\2\2\2\u07b2\u07b3\3\2\2\2\u07b3\u07b4\3\2\2\2\u07b4"+
		"\u07b5\7\u0136\2\2\u07b5\u07bb\5B\"\2\u07b6\u07b7\7\u0080\2\2\u07b7\u07b8"+
		"\7\u0135\2\2\u07b8\u07b9\5p9\2\u07b9\u07ba\7\u0136\2\2\u07ba\u07bc\3\2"+
		"\2\2\u07bb\u07b6\3\2\2\2\u07bb\u07bc\3\2\2\2\u07bc\u07eb\3\2\2\2\u07bd"+
		"\u07be\7,\2\2\u07be\u07bf\7E\2\2\u07bf\u07c4\7\u0135\2\2\u07c0\u07c2\5"+
		"p9\2\u07c1\u07c3\7\u012e\2\2\u07c2\u07c1\3\2\2\2\u07c2\u07c3\3\2\2\2\u07c3"+
		"\u07c5\3\2\2\2\u07c4\u07c0\3\2\2\2\u07c5\u07c6\3\2\2\2\u07c6\u07c4\3\2"+
		"\2\2\u07c6\u07c7\3\2\2\2\u07c7\u07c8\3\2\2\2\u07c8\u07c9\7\u0136\2\2\u07c9"+
		"\u07ca\7_\2\2\u07ca\u07d6\5p9\2\u07cb\u07d0\7\u0135\2\2\u07cc\u07ce\5"+
		"p9\2\u07cd\u07cf\7\u012e\2\2\u07ce\u07cd\3\2\2\2\u07ce\u07cf\3\2\2\2\u07cf"+
		"\u07d1\3\2\2\2\u07d0\u07cc\3\2\2\2\u07d1\u07d2\3\2\2\2\u07d2\u07d0\3\2"+
		"\2\2\u07d2\u07d3\3\2\2\2\u07d3\u07d4\3\2\2\2\u07d4\u07d5\7\u0136\2\2\u07d5"+
		"\u07d7\3\2\2\2\u07d6\u07cb\3\2\2\2\u07d6\u07d7\3\2\2\2\u07d7\u07de\3\2"+
		"\2\2\u07d8\u07d9\7\u00bf\2\2\u07d9\u07df\7-\2\2\u07da\u07db\7\u00bf\2"+
		"\2\u07db\u07df\7\u00d2\2\2\u07dc\u07dd\7\u00bf\2\2\u07dd\u07df\7\u00e3"+
		"\2\2\u07de\u07d8\3\2\2\2\u07de\u07da\3\2\2\2\u07de\u07dc\3\2\2\2\u07de"+
		"\u07df\3\2\2\2\u07df\u07e3\3\2\2\2\u07e0\u07e1\7P\2\2\u07e1\u07e2\7\36"+
		"\2\2\u07e2\u07e4\5@!\2\u07e3\u07e0\3\2\2\2\u07e3\u07e4\3\2\2\2\u07e4\u07e8"+
		"\3\2\2\2\u07e5\u07e6\7P\2\2\u07e6\u07e7\7z\2\2\u07e7\u07e9\5@!\2\u07e8"+
		"\u07e5\3\2\2\2\u07e8\u07e9\3\2\2\2\u07e9\u07eb\3\2\2\2\u07ea\u0788\3\2"+
		"\2\2\u07ea\u0789\3\2\2\2\u07ea\u0796\3\2\2\2\u07ea\u07a4\3\2\2\2\u07ea"+
		"\u07bd\3\2\2\2\u07eb\u07ef\3\2\2\2\u07ec\u07f0\7\34\2\2\u07ed\u07ee\7"+
		"L\2\2\u07ee\u07f0\7\34\2\2\u07ef\u07ec\3\2\2\2\u07ef\u07ed\3\2\2\2\u07ef"+
		"\u07f0\3\2\2\2\u07f0\u07f5\3\2\2\2\u07f1\u07f2\7<\2\2\u07f2\u07f6\7\35"+
		"\2\2\u07f3\u07f4\7<\2\2\u07f4\u07f6\7\67\2\2\u07f5\u07f1\3\2\2\2\u07f5"+
		"\u07f3\3\2\2\2\u07f5\u07f6\3\2\2\2\u07f6\63\3\2\2\2\u07f7\u07f8\7\24\2"+
		"\2\u07f8\u07fa\5p9\2\u07f9\u07f7\3\2\2\2\u07f9\u07fa\3\2\2\2\u07fa\u081b"+
		"\3\2\2\2\u07fb\u07fc\7L\2\2\u07fc\u081c\7M\2\2\u07fd\u081c\7M\2\2\u07fe"+
		"\u081c\5\66\34\2\u07ff\u0800\7\32\2\2\u0800\u081c\5\u01b4\u00db\2\u0801"+
		"\u0802\7y\2\2\u0802\u081c\5B\"\2\u0803\u0804\7X\2\2\u0804\u0805\7E\2\2"+
		"\u0805\u081c\5B\"\2\u0806\u0807\7_\2\2\u0807\u0808\5\u016c\u00b7\2\u0808"+
		"\u080f\5p9\2\u0809\u080a\7\u00bf\2\2\u080a\u0810\7-\2\2\u080b\u080c\7"+
		"\u00bf\2\2\u080c\u0810\7\u00d2\2\2\u080d\u080e\7\u00bf\2\2\u080e\u0810"+
		"\7\u00e3\2\2\u080f\u0809\3\2\2\2\u080f\u080b\3\2\2\2\u080f\u080d\3\2\2"+
		"\2\u080f\u0810\3\2\2\2\u0810\u0814\3\2\2\2\u0811\u0812\7P\2\2\u0812\u0813"+
		"\7\36\2\2\u0813\u0815\5@!\2\u0814\u0811\3\2\2\2\u0814\u0815\3\2\2\2\u0815"+
		"\u0819\3\2\2\2\u0816\u0817\7P\2\2\u0817\u0818\7z\2\2\u0818\u081a\5@!\2"+
		"\u0819\u0816\3\2\2\2\u0819\u081a\3\2\2\2\u081a\u081c\3\2\2\2\u081b\u07fb"+
		"\3\2\2\2\u081b\u07fd\3\2\2\2\u081b\u07fe\3\2\2\2\u081b\u07ff\3\2\2\2\u081b"+
		"\u0801\3\2\2\2\u081b\u0803\3\2\2\2\u081b\u0806\3\2\2\2\u081c\u0820\3\2"+
		"\2\2\u081d\u0821\7\34\2\2\u081e\u081f\7L\2\2\u081f\u0821\7\34\2\2\u0820"+
		"\u081d\3\2\2\2\u0820\u081e\3\2\2\2\u0820\u0821\3\2\2\2\u0821\u0826\3\2"+
		"\2\2\u0822\u0823\7<\2\2\u0823\u0827\7\35\2\2\u0824\u0825\7<\2\2\u0825"+
		"\u0827\7\67\2\2\u0826\u0822\3\2\2\2\u0826\u0824\3\2\2\2\u0826\u0827\3"+
		"\2\2\2\u0827\65\3\2\2\2\u0828\u0829\7\u008c\2\2\u0829\u082a\7\u0135\2"+
		"\2\u082a\u082b\5\u00fc\177\2\u082b\u082c\7\u0136\2\2\u082c\67\3\2\2\2"+
		"\u082d\u082e\7\u0081\2\2\u082e\u0837\7\u0135\2\2\u082f\u0832\5p9\2\u0830"+
		"\u0831\7\u012b\2\2\u0831\u0833\5p9\2\u0832\u0830\3\2\2\2\u0832\u0833\3"+
		"\2\2\2\u0833\u0835\3\2\2\2\u0834\u0836\7\u012e\2\2\u0835\u0834\3\2\2\2"+
		"\u0835\u0836\3\2\2\2\u0836\u0838\3\2\2\2\u0837\u082f\3\2\2\2\u0838\u0839"+
		"\3\2\2\2\u0839\u0837\3\2\2\2\u0839\u083a\3\2\2\2\u083a\u083b\3\2\2\2\u083b"+
		"\u083c\7\u0136\2\2\u083c9\3\2\2\2\u083d\u0843\58\35\2\u083e\u083f\7\u0081"+
		"\2\2\u083f\u0843\7O\2\2\u0840\u0841\7\u0082\2\2\u0841\u0843\7O\2\2\u0842"+
		"\u083d\3\2\2\2\u0842\u083e\3\2\2\2\u0842\u0840\3\2\2\2\u0842\u0843\3\2"+
		"\2\2\u0843;\3\2\2\2\u0844\u0845\7P\2\2\u0845\u084b\7\u0092\2\2\u0846\u0847"+
		"\7W\2\2\u0847\u084c\7^\2\2\u0848\u0849\7\36\2\2\u0849\u084c\7^\2\2\u084a"+
		"\u084c\7\u00a1\2\2\u084b\u0846\3\2\2\2\u084b\u0848\3\2\2\2\u084b\u084a"+
		"\3\2\2\2\u084c\u084e\3\2\2\2\u084d\u0844\3\2\2\2\u084d\u084e\3\2\2\2\u084e"+
		"=\3\2\2\2\u084f\u0850\7\u00eb\2\2\u0850\u0852\5p9\2\u0851\u084f\3\2\2"+
		"\2\u0851\u0852\3\2\2\2\u0852?\3\2\2\2\u0853\u085a\7a\2\2\u0854\u085a\7"+
		"\17\2\2\u0855\u0856\7\u00e1\2\2\u0856\u085a\7M\2\2\u0857\u0858\7\u00e1"+
		"\2\2\u0858\u085a\7\32\2\2\u0859\u0853\3\2\2\2\u0859\u0854\3\2\2\2\u0859"+
		"\u0855\3\2\2\2\u0859\u0857\3\2\2\2\u085aA\3\2\2\2\u085b\u085d\5";
	private static final String _serializedATNSegment1 =
		"8\35\2\u085c\u085b\3\2\2\2\u085c\u085d\3\2\2\2\u085d\u0862\3\2\2\2\u085e"+
		"\u085f\7|\2\2\u085f\u0860\7\u00af\2\2\u0860\u0861\7\u00eb\2\2\u0861\u0863"+
		"\5p9\2\u0862\u085e\3\2\2\2\u0862\u0863\3\2\2\2\u0863C\3\2\2\2\u0864\u0865"+
		"\7\u0135\2\2\u0865\u086a\5F$\2\u0866\u0867\7\u012e\2\2\u0867\u0869\5F"+
		"$\2\u0868\u0866\3\2\2\2\u0869\u086c\3\2\2\2\u086a\u0868\3\2\2\2\u086a"+
		"\u086b\3\2\2\2\u086b\u086d\3\2\2\2\u086c\u086a\3\2\2\2\u086d\u086e\7\u0136"+
		"\2\2\u086eE\3\2\2\2\u086f\u0870\5p9\2\u0870\u0871\5H%\2\u0871G\3\2\2\2"+
		"\u0872\u0873\5\u0082B\2\u0873I\3\2\2\2\u0874\u0875\7\u0081\2\2\u0875\u0876"+
		"\7\u0135\2\2\u0876\u087b\5L\'\2\u0877\u0878\7\u012e\2\2\u0878\u087a\5"+
		"L\'\2\u0879\u0877\3\2\2\2\u087a\u087d\3\2\2\2\u087b\u0879\3\2\2\2\u087b"+
		"\u087c\3\2\2\2\u087c\u087e\3\2\2\2\u087d\u087b\3\2\2\2\u087e\u087f\7\u0136"+
		"\2\2\u087fK\3\2\2\2\u0880\u0881\7\u0148\2\2\u0881\u0882\7\u012b\2\2\u0882"+
		"\u0883\5\u00d6l\2\u0883M\3\2\2\2\u0884\u0885\7|\2\2\u0885\u0886\5p9\2"+
		"\u0886O\3\2\2\2\u0887\u0888\7\u00eb\2\2\u0888\u0889\5R*\2\u0889Q\3\2\2"+
		"\2\u088a\u088b\5p9\2\u088bS\3\2\2\2\u088c\u0891\5V,\2\u088d\u0891\5\\"+
		"/\2\u088e\u0891\5d\63\2\u088f\u0891\5j\66\2\u0890\u088c\3\2\2\2\u0890"+
		"\u088d\3\2\2\2\u0890\u088e\3\2\2\2\u0890\u088f\3\2\2\2\u0891U\3\2\2\2"+
		"\u0892\u0893\7\u00d3\2\2\u0893\u0894\7\u0086\2\2\u0894\u0895\7\u00d9\2"+
		"\2\u0895\u0896\7\u0135\2\2\u0896\u0897\5\u017e\u00c0\2\u0897\u0898\7\u0136"+
		"\2\2\u0898\u0899\7\u0135\2\2\u0899\u089a\5X-\2\u089a\u089b\7\u0136\2\2"+
		"\u089bW\3\2\2\2\u089c\u08a1\5Z.\2\u089d\u089e\7\u012e\2\2\u089e\u08a0"+
		"\5Z.\2\u089f\u089d\3\2\2\2\u08a0\u08a3\3\2\2\2\u08a1\u089f\3\2\2\2\u08a1"+
		"\u08a2\3\2\2\2\u08a2Y\3\2\2\2\u08a3\u08a1\3\2\2\2\u08a4\u08a5\7\u00d3"+
		"\2\2\u08a5\u08a6\5l\67\2\u08a6\u08a7\7\u00f6\2\2\u08a7\u08a8\7\u00bc\2"+
		"\2\u08a8\u08b4\7\u00ee\2\2\u08a9\u08aa\7\u0135\2\2\u08aa\u08ab\5\u00d2"+
		"j\2\u08ab\u08ac\7\u0136\2\2\u08ac\u08b5\3\2\2\2\u08ad\u08af\7\u0135\2"+
		"\2\u08ae\u08ad\3\2\2\2\u08ae\u08af\3\2\2\2\u08af\u08b0\3\2\2\2\u08b0\u08b2"+
		"\7\u00c1\2\2\u08b1\u08b3\7\u0136\2\2\u08b2\u08b1\3\2\2\2\u08b2\u08b3\3"+
		"\2\2\2\u08b3\u08b5\3\2\2\2\u08b4\u08a9\3\2\2\2\u08b4\u08ae\3\2\2\2\u08b5"+
		"[\3\2\2\2\u08b6\u08b7\7\u00d3\2\2\u08b7\u08b8\7\u0086\2\2\u08b8\u08b9"+
		"\7\u00ad\2\2\u08b9\u08ba\7\u0135\2\2\u08ba\u08bb\5\u017e\u00c0\2\u08bb"+
		"\u08c1\7\u0136\2\2\u08bc\u08bd\7\u0135\2\2\u08bd\u08be\5^\60\2\u08be\u08bf"+
		"\7\u0136\2\2\u08bf\u08c2\3\2\2\2\u08c0\u08c2\5b\62\2\u08c1\u08bc\3\2\2"+
		"\2\u08c1\u08c0\3\2\2\2\u08c2]\3\2\2\2\u08c3\u08c8\5`\61\2\u08c4\u08c5"+
		"\7\u012e\2\2\u08c5\u08c7\5`\61\2\u08c6\u08c4\3\2\2\2\u08c7\u08ca\3\2\2"+
		"\2\u08c8\u08c6\3\2\2\2\u08c8\u08c9\3\2\2\2\u08c9_\3\2\2\2\u08ca\u08c8"+
		"\3\2\2\2\u08cb\u08cc\7\u00d3\2\2\u08cc\u08cd\5l\67\2\u08cda\3\2\2\2\u08ce"+
		"\u08cf\7\u00d4\2\2\u08cf\u08d0\5\u00d6l\2\u08d0c\3\2\2\2\u08d1\u08d2\7"+
		"\u00d3\2\2\u08d2\u08d3\7\u0086\2\2\u08d3\u08d4\7\u00bd\2\2\u08d4\u08d5"+
		"\7\u0135\2\2\u08d5\u08d6\5\u017e\u00c0\2\u08d6\u08d7\7\u0136\2\2\u08d7"+
		"\u08d8\7\u0135\2\2\u08d8\u08d9\5f\64\2\u08d9\u08da\7\u0136\2\2\u08dae"+
		"\3\2\2\2\u08db\u08e0\5h\65\2\u08dc\u08dd\7\u012e\2\2\u08dd\u08df\5h\65"+
		"\2\u08de\u08dc\3\2\2\2\u08df\u08e2\3\2\2\2\u08e0\u08de\3\2\2\2\u08e0\u08e1"+
		"\3\2\2\2\u08e1g\3\2\2\2\u08e2\u08e0\3\2\2\2\u08e3\u08e4\7\u00d3\2\2\u08e4"+
		"\u08e5\5l\67\2\u08e5\u08e7\7\u00f6\2\2\u08e6\u08e8\79\2\2\u08e7\u08e6"+
		"\3\2\2\2\u08e7\u08e8\3\2\2\2\u08e8\u08e9\3\2\2\2\u08e9\u08ea\7\u0135\2"+
		"\2\u08ea\u08eb\5\u0196\u00cc\2\u08eb\u08ec\7\u0136\2\2\u08eci\3\2\2\2"+
		"\u08ed\u08ee\7\u00d3\2\2\u08ee\u08ef\7\u0086\2\2\u08ef\u08f0\7\u008f\2"+
		"\2\u08f0\u08f1\5D#\2\u08f1k\3\2\2\2\u08f2\u08f3\5p9\2\u08f3m\3\2\2\2\u08f4"+
		"\u08f5\7\u00a1\2\2\u08f5\u08f6\7o\2\2\u08f6\u08f8\5\u016c\u00b7\2\u08f7"+
		"\u08f9\7\u00d7\2\2\u08f8\u08f7\3\2\2\2\u08f8\u08f9\3\2\2\2\u08f9o\3\2"+
		"\2\2\u08fa\u08fc\7\u013f\2\2\u08fb\u08fa\3\2\2\2\u08fb\u08fc\3\2\2\2\u08fc"+
		"\u08fd\3\2\2\2\u08fd\u08ff\7\u0147\2\2\u08fe\u0900\7\u013f\2\2\u08ff\u08fe"+
		"\3\2\2\2\u08ff\u0900\3\2\2\2\u0900\u0903\3\2\2\2\u0901\u0903\5r:\2\u0902"+
		"\u08fb\3\2\2\2\u0902\u0901\3\2\2\2\u0903q\3\2\2\2\u0904\u0905\t\22\2\2"+
		"\u0905s\3\2\2\2\u0906\u0909\5\u00aaV\2\u0907\u0909\5v<\2\u0908\u0906\3"+
		"\2\2\2\u0908\u0907\3\2\2\2\u0909u\3\2\2\2\u090a\u090e\7\u0148\2\2\u090b"+
		"\u090e\5x=\2\u090c\u090e\5\u0080A\2\u090d\u090a\3\2\2\2\u090d\u090b\3"+
		"\2\2\2\u090d\u090c\3\2\2\2\u090ew\3\2\2\2\u090f\u0913\5|?\2\u0910\u0913"+
		"\5z>\2\u0911\u0913\5~@\2\u0912\u090f\3\2\2\2\u0912\u0910\3\2\2\2\u0912"+
		"\u0911\3\2\2\2\u0913y\3\2\2\2\u0914\u0915\7\u011b\2\2\u0915\u0916\7\u0148"+
		"\2\2\u0916{\3\2\2\2\u0917\u0918\7\u011d\2\2\u0918\u0919\7\u0148\2\2\u0919"+
		"}\3\2\2\2\u091a\u091b\7\u011a\2\2\u091b\u091c\7\u0148\2\2\u091c\177\3"+
		"\2\2\2\u091d\u091e\t\23\2\2\u091e\u0081\3\2\2\2\u091f\u0920\5\u0084C\2"+
		"\u0920\u0083\3\2\2\2\u0921\u092d\5\u008aF\2\u0922\u092d\5\u008eH\2\u0923"+
		"\u092d\5\u0090I\2\u0924\u092d\5\u0092J\2\u0925\u092d\5\u009aN\2\u0926"+
		"\u092d\5\u009cO\2\u0927\u092d\5\u009eP\2\u0928\u092d\5\u00a0Q\2\u0929"+
		"\u092d\5\u0088E\2\u092a\u092d\5\u0086D\2\u092b\u092d\7t\2\2\u092c\u0921"+
		"\3\2\2\2\u092c\u0922\3\2\2\2\u092c\u0923\3\2\2\2\u092c\u0924\3\2\2\2\u092c"+
		"\u0925\3\2\2\2\u092c\u0926\3\2\2\2\u092c\u0927\3\2\2\2\u092c\u0928\3\2"+
		"\2\2\u092c\u0929\3\2\2\2\u092c\u092a\3\2\2\2\u092c\u092b\3\2\2\2\u092d"+
		"\u0085\3\2\2\2\u092e\u092f\7\u0111\2\2\u092f\u0087\3\2\2\2\u0930\u0931"+
		"\7\u0124\2\2\u0931\u0089\3\2\2\2\u0932\u0934\7\u008b\2\2\u0933\u0935\5"+
		"\u008cG\2\u0934\u0933\3\2\2\2\u0934\u0935\3\2\2\2\u0935\u094a\3\2\2\2"+
		"\u0936\u0938\7\u0116\2\2\u0937\u0939\5\u008cG\2\u0938\u0937\3\2\2\2\u0938"+
		"\u0939\3\2\2\2\u0939\u094a\3\2\2\2\u093a\u093b\7\u008b\2\2\u093b\u093d"+
		"\7\u00f9\2\2\u093c\u093e\5\u008cG\2\u093d\u093c\3\2\2\2\u093d\u093e\3"+
		"\2\2\2\u093e\u094a\3\2\2\2\u093f\u0940\7\u0116\2\2\u0940\u0942\7\u00f9"+
		"\2\2\u0941\u0943\5\u008cG\2\u0942\u0941\3\2\2\2\u0942\u0943\3\2\2\2\u0943"+
		"\u094a\3\2\2\2\u0944\u0946\7\u0117\2\2\u0945\u0947\5\u008cG\2\u0946\u0945"+
		"\3\2\2\2\u0946\u0947\3\2\2\2\u0947\u094a\3\2\2\2\u0948\u094a\7\u011f\2"+
		"\2\u0949\u0932\3\2\2\2\u0949\u0936\3\2\2\2\u0949\u093a\3\2\2\2\u0949\u093f"+
		"\3\2\2\2\u0949\u0944\3\2\2\2\u0949\u0948\3\2\2\2\u094a\u008b\3\2\2\2\u094b"+
		"\u094c\7\u0135\2\2\u094c\u094d\7\u0143\2\2\u094d\u094e\7\u0136\2\2\u094e"+
		"\u008d\3\2\2\2\u094f\u0950\7\u00c9\2\2\u0950\u0952\7\u008b\2\2\u0951\u0953"+
		"\5\u008cG\2\u0952\u0951\3\2\2\2\u0952\u0953\3\2\2\2\u0953\u0973\3\2\2"+
		"\2\u0954\u0955\7\u00c9\2\2\u0955\u0957\7\u0116\2\2\u0956\u0958\5\u008c"+
		"G\2\u0957\u0956\3\2\2\2\u0957\u0958\3\2\2\2\u0958\u0973\3\2\2\2\u0959"+
		"\u095b\7\u0118\2\2\u095a\u095c\5\u008cG\2\u095b\u095a\3\2\2\2\u095b\u095c"+
		"\3\2\2\2\u095c\u0973\3\2\2\2\u095d\u095e\7\u00c9\2\2\u095e\u095f\7\u008b"+
		"\2\2\u095f\u0961\7\u00f9\2\2\u0960\u0962\5\u008cG\2\u0961\u0960\3\2\2"+
		"\2\u0961\u0962\3\2\2\2\u0962\u0973\3\2\2\2\u0963\u0964\7\u00c9\2\2\u0964"+
		"\u0965\7\u0116\2\2\u0965\u0967\7\u00f9\2\2\u0966\u0968\5\u008cG\2\u0967"+
		"\u0966\3\2\2\2\u0967\u0968\3\2\2\2\u0968\u0973\3\2\2\2\u0969\u096a\7\u0118"+
		"\2\2\u096a\u096c\7\u00f9\2\2\u096b\u096d\5\u008cG\2\u096c\u096b\3\2\2"+
		"\2\u096c\u096d\3\2\2\2\u096d\u0973\3\2\2\2\u096e\u0970\7\u0119\2\2\u096f"+
		"\u0971\5\u008cG\2\u0970\u096f\3\2\2\2\u0970\u0971\3\2\2\2\u0971\u0973"+
		"\3\2\2\2\u0972\u094f\3\2\2\2\u0972\u0954\3\2\2\2\u0972\u0959\3\2\2\2\u0972"+
		"\u095d\3\2\2\2\u0972\u0963\3\2\2\2\u0972\u0969\3\2\2\2\u0972\u096e\3\2"+
		"\2\2\u0973\u008f\3\2\2\2\u0974\u0976\7\u0122\2\2\u0975\u0977\5\u008cG"+
		"\2\u0976\u0975\3\2\2\2\u0976\u0977\3\2\2\2\u0977\u097d\3\2\2\2\u0978\u097a"+
		"\7\u0123\2\2\u0979\u097b\5\u008cG\2\u097a\u0979\3\2\2\2\u097a\u097b\3"+
		"\2\2\2\u097b\u097d\3\2\2\2\u097c\u0974\3\2\2\2\u097c\u0978\3\2\2\2\u097d"+
		"\u0091\3\2\2\2\u097e\u0981\5\u0094K\2\u097f\u0981\5\u0096L\2\u0980\u097e"+
		"\3\2\2\2\u0980\u097f\3\2\2\2\u0981\u0093\3\2\2\2\u0982\u0984\7\u0114\2"+
		"\2\u0983\u0985\5\u0098M\2\u0984\u0983\3\2\2\2\u0984\u0985\3\2\2\2\u0985"+
		"\u0998\3\2\2\2\u0986\u0988\7\u0115\2\2\u0987\u0989\5\u0098M\2\u0988\u0987"+
		"\3\2\2\2\u0988\u0989\3\2\2\2\u0989\u0998\3\2\2\2\u098a\u098c\7\u009b\2"+
		"\2\u098b\u098d\5\u0098M\2\u098c\u098b\3\2\2\2\u098c\u098d\3\2\2\2\u098d"+
		"\u0998\3\2\2\2\u098e\u0998\7\u0105\2\2\u098f\u0998\7\u0109\2\2\u0990\u0998"+
		"\7\u0106\2\2\u0991\u0998\7\u010a\2\2\u0992\u0998\7\u0107\2\2\u0993\u0998"+
		"\7\u010b\2\2\u0994\u0998\7\u010c\2\2\u0995\u0998\7\u0108\2\2\u0996\u0998"+
		"\7\u010d\2\2\u0997\u0982\3\2\2\2\u0997\u0986\3\2\2\2\u0997\u098a\3\2\2"+
		"\2\u0997\u098e\3\2\2\2\u0997\u098f\3\2\2\2\u0997\u0990\3\2\2\2\u0997\u0991"+
		"\3\2\2\2\u0997\u0992\3\2\2\2\u0997\u0993\3\2\2\2\u0997\u0994\3\2\2\2\u0997"+
		"\u0995\3\2\2\2\u0997\u0996\3\2\2\2\u0998\u0095\3\2\2\2\u0999\u099b\7\u0112"+
		"\2\2\u099a\u099c\5\u0098M\2\u099b\u099a\3\2\2\2\u099b\u099c\3\2\2\2\u099c"+
		"\u09a4\3\2\2\2\u099d\u09a4\7\u010e\2\2\u099e\u09a4\7\u0110\2\2\u099f\u09a4"+
		"\7\u010f\2\2\u09a0\u09a4\7\u0113\2\2\u09a1\u09a2\7\u0113\2\2\u09a2\u09a4"+
		"\7\u00d5\2\2\u09a3\u0999\3\2\2\2\u09a3\u099d\3\2\2\2\u09a3\u099e\3\2\2"+
		"\2\u09a3\u099f\3\2\2\2\u09a3\u09a0\3\2\2\2\u09a3\u09a1\3\2\2\2\u09a4\u0097"+
		"\3\2\2\2\u09a5\u09a6\7\u0135\2\2\u09a6\u09a7\7\u0143\2\2\u09a7\u09ae\7"+
		"\u0136\2\2\u09a8\u09a9\7\u0135\2\2\u09a9\u09aa\7\u0143\2\2\u09aa\u09ab"+
		"\7\u012e\2\2\u09ab\u09ac\7\u0143\2\2\u09ac\u09ae\7\u0136\2\2\u09ad\u09a5"+
		"\3\2\2\2\u09ad\u09a8\3\2\2\2\u09ae\u0099\3\2\2\2\u09af\u09b0\t\24\2\2"+
		"\u09b0\u009b\3\2\2\2\u09b1\u09bf\7\u011a\2\2\u09b2\u09bf\7\u011b\2\2\u09b3"+
		"\u09b4\7\u011b\2\2\u09b4\u09b5\7\u0081\2\2\u09b5\u09b6\7\u011b\2\2\u09b6"+
		"\u09bf\7\u0100\2\2\u09b7\u09bf\7\u011c\2\2\u09b8\u09bf\7\u011d\2\2\u09b9"+
		"\u09ba\7\u011d\2\2\u09ba\u09bb\7\u0081\2\2\u09bb\u09bc\7\u011b\2\2\u09bc"+
		"\u09bf\7\u0100\2\2\u09bd\u09bf\7\u011e\2\2\u09be\u09b1\3\2\2\2\u09be\u09b2"+
		"\3\2\2\2\u09be\u09b3\3\2\2\2\u09be\u09b7\3\2\2\2\u09be\u09b8\3\2\2\2\u09be"+
		"\u09b9\3\2\2\2\u09be\u09bd\3\2\2\2\u09bf\u009d\3\2\2\2\u09c0\u09c2\7\u0103"+
		"\2\2\u09c1\u09c3\5\u008cG\2\u09c2\u09c1\3\2\2\2\u09c2\u09c3\3\2\2\2\u09c3"+
		"\u09ce\3\2\2\2\u09c4\u09c6\7\u0104\2\2\u09c5\u09c7\5\u008cG\2\u09c6\u09c5"+
		"\3\2\2\2\u09c6\u09c7\3\2\2\2\u09c7\u09ce\3\2\2\2\u09c8\u09c9\7\u0103\2"+
		"\2\u09c9\u09cb\7\u00f9\2\2\u09ca\u09cc\5\u008cG\2\u09cb\u09ca\3\2\2\2"+
		"\u09cb\u09cc\3\2\2\2\u09cc\u09ce\3\2\2\2\u09cd\u09c0\3\2\2\2\u09cd\u09c4"+
		"\3\2\2\2\u09cd\u09c8\3\2\2\2\u09ce\u009f\3\2\2\2\u09cf\u09d1\7\u0120\2"+
		"\2\u09d0\u09d2\5\u008cG\2\u09d1\u09d0\3\2\2\2\u09d1\u09d2\3\2\2\2\u09d2"+
		"\u09dd\3\2\2\2\u09d3\u09d4\7\u0120\2\2\u09d4\u09d6\7\u00f9\2\2\u09d5\u09d7"+
		"\5\u008cG\2\u09d6\u09d5\3\2\2\2\u09d6\u09d7\3\2\2\2\u09d7\u09dd\3\2\2"+
		"\2\u09d8\u09da\7\u0121\2\2\u09d9\u09db\5\u008cG\2\u09da\u09d9\3\2\2\2"+
		"\u09da\u09db\3\2\2\2\u09db\u09dd\3\2\2\2\u09dc\u09cf\3\2\2\2\u09dc\u09d3"+
		"\3\2\2\2\u09dc\u09d8\3\2\2\2\u09dd\u00a1\3\2\2\2\u09de\u09e1\5\u00a4S"+
		"\2\u09df\u09e1\5\u00a6T\2\u09e0\u09de\3\2\2\2\u09e0\u09df\3\2\2\2\u09e1"+
		"\u00a3\3\2\2\2\u09e2\u09e3\7\u0135\2\2\u09e3\u09e4\5\u00d2j\2\u09e4\u09e5"+
		"\7\u0136\2\2\u09e5\u00a5\3\2\2\2\u09e6\u09ee\5\u00a8U\2\u09e7\u09ee\5"+
		"\u017a\u00be\2\u09e8\u09ee\5\u00aeX\2\u09e9\u09ee\5\u0180\u00c1\2\u09ea"+
		"\u09ee\5\u00ba^\2\u09eb\u09ee\5\u00ccg\2\u09ec\u09ee\5\u01b4\u00db\2\u09ed"+
		"\u09e6\3\2\2\2\u09ed\u09e7\3\2\2\2\u09ed\u09e8\3\2\2\2\u09ed\u09e9\3\2"+
		"\2\2\u09ed\u09ea\3\2\2\2\u09ed\u09eb\3\2\2\2\u09ed\u09ec\3\2\2\2\u09ee"+
		"\u00a7\3\2\2\2\u09ef\u09f0\5t;\2\u09f0\u00a9\3\2\2\2\u09f1\u09f2\t\25"+
		"\2\2\u09f2\u00ab\3\2\2\2\u09f3\u09f5\5\u00e0q\2\u09f4\u09f3\3\2\2\2\u09f4"+
		"\u09f5\3\2\2\2\u09f5\u09f6\3\2\2\2\u09f6\u09f7\5\u00aaV\2\u09f7\u00ad"+
		"\3\2\2\2\u09f8\u09f9\5\u00b0Y\2\u09f9\u00af\3\2\2\2\u09fa\u09fb\7\u0095"+
		"\2\2\u09fb\u09fc\7\u0135\2\2\u09fc\u09fd\7\u0139\2\2\u09fd\u0a03\7\u0136"+
		"\2\2\u09fe\u0a00\5\u00b2Z\2\u09ff\u0a01\5\u00b6\\\2\u0a00\u09ff\3\2\2"+
		"\2\u0a00\u0a01\3\2\2\2\u0a01\u0a03\3\2\2\2\u0a02\u09fa\3\2\2\2\u0a02\u09fe"+
		"\3\2\2\2\u0a03\u00b1\3\2\2\2\u0a04\u0a05\5\u00b4[\2\u0a05\u0a07\7\u0135"+
		"\2\2\u0a06\u0a08\5\u0178\u00bd\2\u0a07\u0a06\3\2\2\2\u0a07\u0a08\3\2\2"+
		"\2\u0a08\u0a09\3\2\2\2\u0a09\u0a0a\5\u00d2j\2\u0a0a\u0a0b\7\u0136\2\2"+
		"\u0a0b\u00b3\3\2\2\2\u0a0c\u0a0d\t\26\2\2\u0a0d\u00b5\3\2\2\2\u0a0e\u0a0f"+
		"\7\u00a8\2\2\u0a0f\u0a10\7\u0135\2\2\u0a10\u0a11\7\u0080\2\2\u0a11\u0a12"+
		"\5\u0142\u00a2\2\u0a12\u0a13\7\u0136\2\2\u0a13\u00b7\3\2\2\2\u0a14\u0a15"+
		"\7\u00ac\2\2\u0a15\u0a16\7\u0135\2\2\u0a16\u0a17\5\u017e\u00c0\2\u0a17"+
		"\u0a18\7\u0136\2\2\u0a18\u00b9\3\2\2\2\u0a19\u0a1a\5\u00be`\2\u0a1a\u00bb"+
		"\3\2\2\2\u0a1b\u0a1c\7\u00cc\2\2\u0a1c\u0a1d\7\u0135\2\2\u0a1d\u0a1e\5"+
		"\u00d6l\2\u0a1e\u0a1f\7\u012e\2\2\u0a1f\u0a20\5\u00fc\177\2\u0a20\u0a21"+
		"\7\u0136\2\2\u0a21\u0a2e\3\2\2\2\u0a22\u0a23\7\u008e\2\2\u0a23\u0a24\7"+
		"\u0135\2\2\u0a24\u0a27\5\u00d6l\2\u0a25\u0a26\7\u012e\2\2\u0a26\u0a28"+
		"\5\u00fc\177\2\u0a27\u0a25\3\2\2\2\u0a28\u0a29\3\2\2\2\u0a29\u0a27\3\2"+
		"\2\2\u0a29\u0a2a\3\2\2\2\u0a2a\u0a2b\3\2\2\2\u0a2b\u0a2c\7\u0136\2\2\u0a2c"+
		"\u0a2e\3\2\2\2\u0a2d\u0a1b\3\2\2\2\u0a2d\u0a22\3\2\2\2\u0a2e\u00bd\3\2"+
		"\2\2\u0a2f\u0a32\5\u00c0a\2\u0a30\u0a32\5\u00c2b\2\u0a31\u0a2f\3\2\2\2"+
		"\u0a31\u0a30\3\2\2\2\u0a32\u00bf\3\2\2\2\u0a33\u0a34\7\16\2\2\u0a34\u0a36"+
		"\5\u00fc\177\2\u0a35\u0a37\5\u00c4c\2\u0a36\u0a35\3\2\2\2\u0a37\u0a38"+
		"\3\2\2\2\u0a38\u0a36\3\2\2\2\u0a38\u0a39\3\2\2\2\u0a39\u0a3b\3\2\2\2\u0a3a"+
		"\u0a3c\5\u00c8e\2\u0a3b\u0a3a\3\2\2\2\u0a3b\u0a3c\3\2\2\2\u0a3c\u0a3d"+
		"\3\2\2\2\u0a3d\u0a3e\7#\2\2\u0a3e\u00c1\3\2\2\2\u0a3f\u0a41\7\16\2\2\u0a40"+
		"\u0a42\5\u00c6d\2\u0a41\u0a40\3\2\2\2\u0a42\u0a43\3\2\2\2\u0a43\u0a41"+
		"\3\2\2\2\u0a43\u0a44\3\2\2\2\u0a44\u0a46\3\2\2\2\u0a45\u0a47\5\u00c8e"+
		"\2\u0a46\u0a45\3\2\2\2\u0a46\u0a47\3\2\2\2\u0a47\u0a48\3\2\2\2\u0a48\u0a49"+
		"\7#\2\2\u0a49\u00c3\3\2\2\2\u0a4a\u0a4b\7\177\2\2\u0a4b\u0a4c\5\u0142"+
		"\u00a2\2\u0a4c\u0a4d\7r\2\2\u0a4d\u0a4e\5\u00caf\2\u0a4e\u00c5\3\2\2\2"+
		"\u0a4f\u0a50\7\177\2\2\u0a50\u0a51\5\u0142\u00a2\2\u0a51\u0a52\7r\2\2"+
		"\u0a52\u0a53\5\u00caf\2\u0a53\u00c7\3\2\2\2\u0a54\u0a55\7$\2\2\u0a55\u0a56"+
		"\5\u00caf\2\u0a56\u00c9\3\2\2\2\u0a57\u0a5a\5\u00d2j\2\u0a58\u0a5a\7M"+
		"\2\2\u0a59\u0a57\3\2\2\2\u0a59\u0a58\3\2\2\2\u0a5a\u00cb\3\2\2\2\u0a5b"+
		"\u0a5c\7\20\2\2\u0a5c\u0a5d\7\u0135\2\2\u0a5d\u0a5e\5\u00ceh\2\u0a5e\u0a5f"+
		"\7\5\2\2\u0a5f\u0a60\5\u00d0i\2\u0a60\u0a61\7\u0136\2\2\u0a61\u00cd\3"+
		"\2\2\2\u0a62\u0a63\5\u00d2j\2\u0a63\u00cf\3\2\2\2\u0a64\u0a65\5\u0082"+
		"B\2\u0a65\u00d1\3\2\2\2\u0a66\u0a6a\5\u00d4k\2\u0a67\u0a6a\5\u0110\u0089"+
		"\2\u0a68\u0a6a\5\u00fc\177\2\u0a69\u0a66\3\2\2\2\u0a69\u0a67\3\2\2\2\u0a69"+
		"\u0a68\3\2\2\2\u0a6a\u00d3\3\2\2\2\u0a6b\u0a6f\5\u00d6l\2\u0a6c\u0a6f"+
		"\5\u00ecw\2\u0a6d\u0a6f\7M\2\2\u0a6e\u0a6b\3\2\2\2\u0a6e\u0a6c\3\2\2\2"+
		"\u0a6e\u0a6d\3\2\2\2\u0a6f\u00d5\3\2\2\2\u0a70\u0a75\5\u00d8m\2\u0a71"+
		"\u0a72\t\27\2\2\u0a72\u0a74\5\u00d8m\2\u0a73\u0a71\3\2\2\2\u0a74\u0a77"+
		"\3\2\2\2\u0a75\u0a73\3\2\2\2\u0a75\u0a76\3\2\2\2\u0a76\u00d7\3\2\2\2\u0a77"+
		"\u0a75\3\2\2\2\u0a78\u0a7d\5\u00dan\2\u0a79\u0a7a\t\30\2\2\u0a7a\u0a7c"+
		"\5\u00dan\2\u0a7b\u0a79\3\2\2\2\u0a7c\u0a7f\3\2\2\2\u0a7d\u0a7b\3\2\2"+
		"\2\u0a7d\u0a7e\3\2\2\2\u0a7e\u00d9\3\2\2\2\u0a7f\u0a7d\3\2\2\2\u0a80\u0a82"+
		"\5\u00e0q\2\u0a81\u0a80\3\2\2\2\u0a81\u0a82\3\2\2\2\u0a82\u0a83\3\2\2"+
		"\2\u0a83\u0a84\5\u00dep\2\u0a84\u00db\3\2\2\2\u0a85\u0a86\7\u0135\2\2"+
		"\u0a86\u0a8b\5\u00d6l\2\u0a87\u0a88\7\u012e\2\2\u0a88\u0a8a\5\u00d6l\2"+
		"\u0a89\u0a87\3\2\2\2\u0a8a\u0a8d\3\2\2\2\u0a8b\u0a89\3\2\2\2\u0a8b\u0a8c"+
		"\3\2\2\2\u0a8c\u0a8e\3\2\2\2\u0a8d\u0a8b\3\2\2\2\u0a8e\u0a8f\7\u0136\2"+
		"\2\u0a8f\u00dd\3\2\2\2\u0a90\u0a95\5\u00a2R\2\u0a91\u0a92\7\u0129\2\2"+
		"\u0a92\u0a94\5\u00d0i\2\u0a93\u0a91\3\2\2\2\u0a94\u0a97\3\2\2\2\u0a95"+
		"\u0a93\3\2\2\2\u0a95\u0a96\3\2\2\2\u0a96\u0a9a\3\2\2\2\u0a97\u0a95\3\2"+
		"\2\2\u0a98\u0a9a\5\u00e2r\2\u0a99\u0a90\3\2\2\2\u0a99\u0a98\3\2\2\2\u0a9a"+
		"\u00df\3\2\2\2\u0a9b\u0a9c\t\27\2\2\u0a9c\u00e1\3\2\2\2\u0a9d\u0a9e\5"+
		"\u00e4s\2\u0a9e\u00e3\3\2\2\2\u0a9f\u0aa0\7\u00a6\2\2\u0aa0\u0aa1\7\u0135"+
		"\2\2\u0aa1\u0aa2\5\u00e6t\2\u0aa2\u0aa3\7\60\2\2\u0aa3\u0aa4\5\u00eav"+
		"\2\u0aa4\u0aa5\7\u0136\2\2\u0aa5\u00e5\3\2\2\2\u0aa6\u0aaa\5\u01ae\u00d8"+
		"\2\u0aa7\u0aaa\5\u00e8u\2\u0aa8\u0aaa\5\u01b2\u00da\2\u0aa9\u0aa6\3\2"+
		"\2\2\u0aa9\u0aa7\3\2\2\2\u0aa9\u0aa8\3\2\2\2\u0aaa\u00e7\3\2\2\2\u0aab"+
		"\u0aac\t\31\2\2\u0aac\u00e9\3\2\2\2\u0aad\u0ab0\5\u017a\u00be\2\u0aae"+
		"\u0ab0\5x=\2\u0aaf\u0aad\3\2\2\2\u0aaf\u0aae\3\2\2\2\u0ab0\u00eb\3\2\2"+
		"\2\u0ab1\u0ab2\5\u00eex\2\u0ab2\u00ed\3\2\2\2\u0ab3\u0ab8\5\u00f0y\2\u0ab4"+
		"\u0ab5\7\u012f\2\2\u0ab5\u0ab7\5\u00f0y\2\u0ab6\u0ab4\3\2\2\2\u0ab7\u0aba"+
		"\3\2\2\2\u0ab8\u0ab6\3\2\2\2\u0ab8\u0ab9\3\2\2\2\u0ab9\u00ef\3\2\2\2\u0aba"+
		"\u0ab8\3\2\2\2\u0abb\u0abc\5\u00f2z\2\u0abc\u00f1\3\2\2\2\u0abd\u0ac0"+
		"\5\u00a2R\2\u0abe\u0ac0\5\u00f4{\2\u0abf\u0abd\3\2\2\2\u0abf\u0abe\3\2"+
		"\2\2\u0ac0\u00f3\3\2\2\2\u0ac1\u0ac2\5\u00f6|\2\u0ac2\u00f5\3\2\2\2\u0ac3"+
		"\u0ac4\7\u00f2\2\2\u0ac4\u0ac5\7\u0135\2\2\u0ac5\u0ac6\5\u00f8}\2\u0ac6"+
		"\u0ac7\7\u0136\2\2\u0ac7\u00f7\3\2\2\2\u0ac8\u0aca\5\u00fa~\2\u0ac9\u0ac8"+
		"\3\2\2\2\u0ac9\u0aca\3\2\2\2\u0aca\u0acc\3\2\2\2\u0acb\u0acd\5\u00eex"+
		"\2\u0acc\u0acb\3\2\2\2\u0acc\u0acd\3\2\2\2\u0acd\u0ace\3\2\2\2\u0ace\u0ad0"+
		"\7\60\2\2\u0acf\u0ac9\3\2\2\2\u0acf\u0ad0\3\2\2\2\u0ad0\u0ad1\3\2\2\2"+
		"\u0ad1\u0ad7\5\u00eex\2\u0ad2\u0ad3\5\u00eex\2\u0ad3\u0ad4\7\u012e\2\2"+
		"\u0ad4\u0ad5\5\u00eex\2\u0ad5\u0ad7\3\2\2\2\u0ad6\u0acf\3\2\2\2\u0ad6"+
		"\u0ad2\3\2\2\2\u0ad7\u00f9\3\2\2\2\u0ad8\u0ad9\t\32\2\2\u0ad9\u00fb\3"+
		"\2\2\2\u0ada\u0adb\5\u00fe\u0080\2\u0adb\u00fd\3\2\2\2\u0adc\u0ae1\5\u0100"+
		"\u0081\2\u0add\u0ade\7T\2\2\u0ade\u0ae0\5\u00fe\u0080\2\u0adf\u0add\3"+
		"\2\2\2\u0ae0\u0ae3\3\2\2\2\u0ae1\u0adf\3\2\2\2\u0ae1\u0ae2\3\2\2\2\u0ae2"+
		"\u00ff\3\2\2\2\u0ae3\u0ae1\3\2\2\2\u0ae4\u0ae9\5\u0102\u0082\2\u0ae5\u0ae6"+
		"\7\7\2\2\u0ae6\u0ae8\5\u0100\u0081\2\u0ae7\u0ae5\3\2\2\2\u0ae8\u0aeb\3"+
		"\2\2\2\u0ae9\u0ae7\3\2\2\2\u0ae9\u0aea\3\2\2\2\u0aea\u0101\3\2\2\2\u0aeb"+
		"\u0ae9\3\2\2\2\u0aec\u0af0\5\u0104\u0083\2\u0aed\u0aee\7L\2\2\u0aee\u0af0"+
		"\5\u0104\u0083\2\u0aef\u0aec\3\2\2\2\u0aef\u0aed\3\2\2\2\u0af0\u0103\3"+
		"\2\2\2\u0af1\u0af3\5\u010a\u0086\2\u0af2\u0af4\5\u0106\u0084\2\u0af3\u0af2"+
		"\3\2\2\2\u0af3\u0af4\3\2\2\2\u0af4\u0105\3\2\2\2\u0af5\u0af7\7C\2\2\u0af6"+
		"\u0af8\7L\2\2\u0af7\u0af6\3\2\2\2\u0af7\u0af8\3\2\2\2\u0af8\u0af9\3\2"+
		"\2\2\u0af9\u0afa\5\u0108\u0085\2\u0afa\u0107\3\2\2\2\u0afb\u0afc\t\23"+
		"\2\2\u0afc\u0109\3\2\2\2\u0afd\u0b00\5\u0188\u00c5\2\u0afe\u0b00\5\u010c"+
		"\u0087\2\u0aff\u0afd\3\2\2\2\u0aff\u0afe\3\2\2\2\u0b00\u010b\3\2\2\2\u0b01"+
		"\u0b04\5\u010e\u0088\2\u0b02\u0b04\5\u00a6T\2\u0b03\u0b01\3\2\2\2\u0b03"+
		"\u0b02\3\2\2\2\u0b04\u010d\3\2\2\2\u0b05\u0b06\7\u0135\2\2\u0b06\u0b07"+
		"\5\u00fc\177\2\u0b07\u0b08\7\u0136\2\2\u0b08\u010f\3\2\2\2\u0b09\u0b0c"+
		"\5\u0112\u008a\2\u0b0a\u0b0c\5\u0114\u008b\2\u0b0b\u0b09\3\2\2\2\u0b0b"+
		"\u0b0a\3\2\2\2\u0b0c\u0111\3\2\2\2\u0b0d\u0b0e\5\u00a6T\2\u0b0e\u0113"+
		"\3\2\2\2\u0b0f\u0b10\7M\2\2\u0b10\u0115\3\2\2\2\u0b11\u0b14\5\u0112\u008a"+
		"\2\u0b12\u0b14\5\u0118\u008d\2\u0b13\u0b11\3\2\2\2\u0b13\u0b12\3\2\2\2"+
		"\u0b14\u0117\3\2\2\2\u0b15\u0b18\5\u00d4k\2\u0b16\u0b18\5\u010c\u0087"+
		"\2\u0b17\u0b15\3\2\2\2\u0b17\u0b16\3\2\2\2\u0b18\u0119\3\2\2\2\u0b19\u0b1b"+
		"\5\u011c\u008f\2\u0b1a\u0b1c\5\u0140\u00a1\2\u0b1b\u0b1a\3\2\2\2\u0b1b"+
		"\u0b1c\3\2\2\2\u0b1c\u0b1e\3\2\2\2\u0b1d\u0b1f\5\u0144\u00a3\2\u0b1e\u0b1d"+
		"\3\2\2\2\u0b1e\u0b1f\3\2\2\2\u0b1f\u0b21\3\2\2\2\u0b20\u0b22\5\u0154\u00ab"+
		"\2\u0b21\u0b20\3\2\2\2\u0b21\u0b22\3\2\2\2\u0b22\u0b24\3\2\2\2\u0b23\u0b25"+
		"\5\u01bc\u00df\2\u0b24\u0b23\3\2\2\2\u0b24\u0b25\3\2\2\2\u0b25\u0b27\3"+
		"\2\2\2\u0b26\u0b28\5\u01c4\u00e3\2\u0b27\u0b26\3\2\2\2\u0b27\u0b28\3\2"+
		"\2\2\u0b28\u011b\3\2\2\2\u0b29\u0b2a\7\60\2\2\u0b2a\u0b2b\5\u011e\u0090"+
		"\2\u0b2b\u011d\3\2\2\2\u0b2c\u0b31\5\u0120\u0091\2\u0b2d\u0b2e\7\u012e"+
		"\2\2\u0b2e\u0b30\5\u0120\u0091\2\u0b2f\u0b2d\3\2\2\2\u0b30\u0b33\3\2\2"+
		"\2\u0b31\u0b2f\3\2\2\2\u0b31\u0b32\3\2\2\2\u0b32\u011f\3\2\2\2\u0b33\u0b31"+
		"\3\2\2\2\u0b34\u0b37\5\u0122\u0092\2\u0b35\u0b37\5\u013a\u009e\2\u0b36"+
		"\u0b34\3\2\2\2\u0b36\u0b35\3\2\2\2\u0b37\u0121\3\2\2\2\u0b38\u0b3a\5\u013a"+
		"\u009e\2\u0b39\u0b3b\5\u0124\u0093\2\u0b3a\u0b39\3\2\2\2\u0b3b\u0b3c\3"+
		"\2\2\2\u0b3c\u0b3a\3\2\2\2\u0b3c\u0b3d\3\2\2\2\u0b3d\u0123\3\2\2\2\u0b3e"+
		"\u0b3f\7\30\2\2\u0b3f\u0b40\7D\2\2\u0b40\u0b52\5\u013a\u009e\2\u0b41\u0b43"+
		"\5\u012e\u0098\2\u0b42\u0b41\3\2\2\2\u0b42\u0b43\3\2\2\2\u0b43\u0b44\3"+
		"\2\2\2\u0b44\u0b45\7D\2\2\u0b45\u0b46\5\u013a\u009e\2\u0b46\u0b47\5\u0134"+
		"\u009b\2\u0b47\u0b52\3\2\2\2\u0b48\u0b4a\7K\2\2\u0b49\u0b4b\5\u012e\u0098"+
		"\2\u0b4a\u0b49\3\2\2\2\u0b4a\u0b4b\3\2\2\2\u0b4b\u0b4c\3\2\2\2\u0b4c\u0b4d"+
		"\7D\2\2\u0b4d\u0b52\5\u013a\u009e\2\u0b4e\u0b4f\7x\2\2\u0b4f\u0b50\7D"+
		"\2\2\u0b50\u0b52\5\u013a\u009e\2\u0b51\u0b3e\3\2\2\2\u0b51\u0b42\3\2\2"+
		"\2\u0b51\u0b48\3\2\2\2\u0b51\u0b4e\3\2\2\2\u0b52\u0125\3\2\2\2\u0b53\u0b54"+
		"\7\30\2\2\u0b54\u0b55\7D\2\2\u0b55\u0b56\5\u013a\u009e\2\u0b56\u0127\3"+
		"\2\2\2\u0b57\u0b59\5\u012e\u0098\2\u0b58\u0b57\3\2\2\2\u0b58\u0b59\3\2"+
		"\2\2\u0b59\u0b5a\3\2\2\2\u0b5a\u0b5b\7D\2\2\u0b5b\u0b5c\5\u013a\u009e"+
		"\2\u0b5c\u0b5d\5\u0134\u009b\2\u0b5d\u0129\3\2\2\2\u0b5e\u0b60\7K\2\2"+
		"\u0b5f\u0b61\5\u012e\u0098\2\u0b60\u0b5f\3\2\2\2\u0b60\u0b61\3\2\2\2\u0b61"+
		"\u0b62\3\2\2\2\u0b62\u0b63\7D\2\2\u0b63\u0b64\5\u013a\u009e\2\u0b64\u012b"+
		"\3\2\2\2\u0b65\u0b66\7x\2\2\u0b66\u0b67\7D\2\2\u0b67\u0b68\5\u013a\u009e"+
		"\2\u0b68\u012d\3\2\2\2\u0b69\u0b6c\7=\2\2\u0b6a\u0b6c\5\u0130\u0099\2"+
		"\u0b6b\u0b69\3\2\2\2\u0b6b\u0b6a\3\2\2\2\u0b6c\u012f\3\2\2\2\u0b6d\u0b6f"+
		"\5\u0132\u009a\2\u0b6e\u0b70\7Q\2\2\u0b6f\u0b6e\3\2\2\2\u0b6f\u0b70\3"+
		"\2\2\2\u0b70\u0131\3\2\2\2\u0b71\u0b72\t\33\2\2\u0b72\u0133\3\2\2\2\u0b73"+
		"\u0b76\5\u0136\u009c\2\u0b74\u0b76\5\u0138\u009d\2\u0b75\u0b73\3\2\2\2"+
		"\u0b75\u0b74\3\2\2\2\u0b76\u0135\3\2\2\2\u0b77\u0b78\7P\2\2\u0b78\u0b79"+
		"\5\u0142\u00a2\2\u0b79\u0137\3\2\2\2\u0b7a\u0b7b\7|\2\2\u0b7b\u0b7c\7"+
		"\u0135\2\2\u0b7c\u0b7d\5\u017e\u00c0\2\u0b7d\u0b7e\7\u0136\2\2\u0b7e\u0139"+
		"\3\2\2\2\u0b7f\u0b84\5\u016a\u00b6\2\u0b80\u0b82\7\5\2\2\u0b81\u0b80\3"+
		"\2\2\2\u0b81\u0b82\3\2\2\2\u0b82\u0b83\3\2\2\2\u0b83\u0b85\5p9\2\u0b84"+
		"\u0b81\3\2\2\2\u0b84\u0b85\3\2\2\2\u0b85\u0b8a\3\2\2\2\u0b86\u0b87\7\u0135"+
		"\2\2\u0b87\u0b88\5\u013c\u009f\2\u0b88\u0b89\7\u0136\2\2\u0b89\u0b8b\3"+
		"\2\2\2\u0b8a\u0b86\3\2\2\2\u0b8a\u0b8b\3\2\2\2\u0b8b\u0b98\3\2\2\2\u0b8c"+
		"\u0b8e\5\u013e\u00a0\2\u0b8d\u0b8f\7\5\2\2\u0b8e\u0b8d\3\2\2\2\u0b8e\u0b8f"+
		"\3\2\2\2\u0b8f\u0b90\3\2\2\2\u0b90\u0b95\5p9\2\u0b91\u0b92\7\u0135\2\2"+
		"\u0b92\u0b93\5\u013c\u009f\2\u0b93\u0b94\7\u0136\2\2\u0b94\u0b96\3\2\2"+
		"\2\u0b95\u0b91\3\2\2\2\u0b95\u0b96\3\2\2\2\u0b96\u0b98\3\2\2\2\u0b97\u0b7f"+
		"\3\2\2\2\u0b97\u0b8c\3\2\2\2\u0b98\u013b\3\2\2\2\u0b99\u0b9e\5p9\2\u0b9a"+
		"\u0b9b\7\u012e\2\2\u0b9b\u0b9d\5p9\2\u0b9c\u0b9a\3\2\2\2\u0b9d\u0ba0\3"+
		"\2\2\2\u0b9e\u0b9c\3\2\2\2\u0b9e\u0b9f\3\2\2\2\u0b9f\u013d\3\2\2\2\u0ba0"+
		"\u0b9e\3\2\2\2\u0ba1\u0ba2\5\u0184\u00c3\2\u0ba2\u013f\3\2\2\2\u0ba3\u0ba4"+
		"\7\u0080\2\2\u0ba4\u0ba5\5\u0142\u00a2\2\u0ba5\u0141\3\2\2\2\u0ba6\u0ba7"+
		"\5\u00d2j\2\u0ba7\u0143\3\2\2\2\u0ba8\u0ba9\7\63\2\2\u0ba9\u0baa\7\u0086"+
		"\2\2\u0baa\u0bab\5\u0146\u00a4\2\u0bab\u0145\3\2\2\2\u0bac\u0bb1\5\u0148"+
		"\u00a5\2\u0bad\u0bae\7\u012e\2\2\u0bae\u0bb0\5\u0148\u00a5\2\u0baf\u0bad"+
		"\3\2\2\2\u0bb0\u0bb3\3\2\2\2\u0bb1\u0baf\3\2\2\2\u0bb1\u0bb2\3\2\2\2\u0bb2"+
		"\u0147\3\2\2\2\u0bb3\u0bb1\3\2\2\2\u0bb4\u0bb9\5\u014e\u00a8\2\u0bb5\u0bb9"+
		"\5\u0150\u00a9\2\u0bb6\u0bb9\5\u0152\u00aa\2\u0bb7\u0bb9\5\u014a\u00a6"+
		"\2\u0bb8\u0bb4\3\2\2\2\u0bb8\u0bb5\3\2\2\2\u0bb8\u0bb6\3\2\2\2\u0bb8\u0bb7"+
		"\3\2\2\2\u0bb9\u0149\3\2\2\2\u0bba\u0bc0\5\u0116\u008c\2\u0bbb\u0bbc\7"+
		"\u0135\2\2\u0bbc\u0bbd\5\u0156\u00ac\2\u0bbd\u0bbe\7\u0136\2\2\u0bbe\u0bc0"+
		"\3\2\2\2\u0bbf\u0bba\3\2\2\2\u0bbf\u0bbb\3\2\2\2\u0bc0\u014b\3\2\2\2\u0bc1"+
		"\u0bc6\5\u014a\u00a6\2\u0bc2\u0bc3\7\u012e\2\2\u0bc3\u0bc5\5\u014a\u00a6"+
		"\2\u0bc4\u0bc2\3\2\2\2\u0bc5\u0bc8\3\2\2\2\u0bc6\u0bc4\3\2\2\2\u0bc6\u0bc7"+
		"\3\2\2\2\u0bc7\u014d\3\2\2\2\u0bc8\u0bc6\3\2\2\2\u0bc9\u0bca\7\u00dc\2"+
		"\2\u0bca\u0bcb\7\u0135\2\2\u0bcb\u0bcc\5\u014c\u00a7\2\u0bcc\u0bcd\7\u0136"+
		"\2\2\u0bcd\u014f\3\2\2\2\u0bce\u0bcf\7\u0096\2\2\u0bcf\u0bd0\7\u0135\2"+
		"\2\u0bd0\u0bd1\5\u014c\u00a7\2\u0bd1\u0bd2\7\u0136\2\2\u0bd2\u0151\3\2"+
		"\2\2\u0bd3\u0bd4\7\u0135\2\2\u0bd4\u0bd5\7\u0136\2\2\u0bd5\u0153\3\2\2"+
		"\2\u0bd6\u0bd7\7\64\2\2\u0bd7\u0bd8\5\u00fc\177\2\u0bd8\u0155\3\2\2\2"+
		"\u0bd9\u0bde\5\u0116\u008c\2\u0bda\u0bdb\7\u012e\2\2\u0bdb\u0bdd\5\u0116"+
		"\u008c\2\u0bdc\u0bda\3\2\2\2\u0bdd\u0be0\3\2\2\2\u0bde\u0bdc\3\2\2\2\u0bde"+
		"\u0bdf\3\2\2\2\u0bdf\u0157\3\2\2\2\u0be0\u0bde\3\2\2\2\u0be1\u0be2\5\u015a"+
		"\u00ae\2\u0be2\u0159\3\2\2\2\u0be3\u0be6\5\u015c\u00af\2\u0be4\u0be6\5"+
		"\u0122\u0092\2\u0be5\u0be3\3\2\2\2\u0be5\u0be4\3\2\2\2\u0be6\u015b\3\2"+
		"\2\2\u0be7\u0bf0\5\u0160\u00b1\2\u0be8\u0be9\5\u0122\u0092\2\u0be9\u0beb"+
		"\t\34\2\2\u0bea\u0bec\t\35\2\2\u0beb\u0bea\3\2\2\2\u0beb\u0bec\3\2\2\2"+
		"\u0bec\u0bed\3\2\2\2\u0bed\u0bee\5\u015e\u00b0\2\u0bee\u0bf0\3\2\2\2\u0bef"+
		"\u0be7\3\2\2\2\u0bef\u0be8\3\2\2\2\u0bf0\u0bf8\3\2\2\2\u0bf1\u0bf3\t\34"+
		"\2\2\u0bf2\u0bf4\t\35\2\2\u0bf3\u0bf2\3\2\2\2\u0bf3\u0bf4\3\2\2\2\u0bf4"+
		"\u0bf5\3\2\2\2\u0bf5\u0bf7\5\u015e\u00b0\2\u0bf6\u0bf1\3\2\2\2\u0bf7\u0bfa"+
		"\3\2\2\2\u0bf8\u0bf6\3\2\2\2\u0bf8\u0bf9\3\2\2\2\u0bf9\u015d\3\2\2\2\u0bfa"+
		"\u0bf8\3\2\2\2\u0bfb\u0bfe\5\u0160\u00b1\2\u0bfc\u0bfe\5\u0122\u0092\2"+
		"\u0bfd\u0bfb\3\2\2\2\u0bfd\u0bfc\3\2\2\2\u0bfe\u015f\3\2\2\2\u0bff\u0c08"+
		"\5\u0164\u00b3\2\u0c00\u0c01\5\u0122\u0092\2\u0c01\u0c03\7>\2\2\u0c02"+
		"\u0c04\t\35\2\2\u0c03\u0c02\3\2\2\2\u0c03\u0c04\3\2\2\2\u0c04\u0c05\3"+
		"\2\2\2\u0c05\u0c06\5\u0162\u00b2\2\u0c06\u0c08\3\2\2\2\u0c07\u0bff\3\2"+
		"\2\2\u0c07\u0c00\3\2\2\2\u0c08\u0c10\3\2\2\2\u0c09\u0c0b\7>\2\2\u0c0a"+
		"\u0c0c\t\35\2\2\u0c0b\u0c0a\3\2\2\2\u0c0b\u0c0c\3\2\2\2\u0c0c\u0c0d\3"+
		"\2\2\2\u0c0d\u0c0f\5\u0162\u00b2\2\u0c0e\u0c09\3\2\2\2\u0c0f\u0c12\3\2"+
		"\2\2\u0c10\u0c0e\3\2\2\2\u0c10\u0c11\3\2\2\2\u0c11\u0161\3\2\2\2\u0c12"+
		"\u0c10\3\2\2\2\u0c13\u0c16\5\u0164\u00b3\2\u0c14\u0c16\5\u0122\u0092\2"+
		"\u0c15\u0c13\3\2\2\2\u0c15\u0c14\3\2\2\2\u0c16\u0163\3\2\2\2\u0c17\u0c1d"+
		"\5\u0166\u00b4\2\u0c18\u0c19\7\u0135\2\2\u0c19\u0c1a\5\u015c\u00af\2\u0c1a"+
		"\u0c1b\7\u0136\2\2\u0c1b\u0c1d\3\2\2\2\u0c1c\u0c17\3\2\2\2\u0c1c\u0c18"+
		"\3\2\2\2\u0c1d\u0165\3\2\2\2\u0c1e\u0c21\5\u016e\u00b8\2\u0c1f\u0c21\5"+
		"\u0168\u00b5\2\u0c20\u0c1e\3\2\2\2\u0c20\u0c1f\3\2\2\2\u0c21\u0167\3\2"+
		"\2\2\u0c22\u0c23\7o\2\2\u0c23\u0c24\5\u016a\u00b6\2\u0c24\u0169\3\2\2"+
		"\2\u0c25\u0c28\5\u016c\u00b7\2\u0c26\u0c28\5p9\2\u0c27\u0c25\3\2\2\2\u0c27"+
		"\u0c26\3\2\2\2\u0c28\u016b\3\2\2\2\u0c29\u0c30\5p9\2\u0c2a\u0c2b\7\u013c"+
		"\2\2\u0c2b\u0c2e\5p9\2\u0c2c\u0c2d\7\u013c\2\2\u0c2d\u0c2f\5p9\2\u0c2e"+
		"\u0c2c\3\2\2\2\u0c2e\u0c2f\3\2\2\2\u0c2f\u0c31\3\2\2\2\u0c30\u0c2a\3\2"+
		"\2\2\u0c30\u0c31\3\2\2\2\u0c31\u016d\3\2\2\2\u0c32\u0c34\7i\2\2\u0c33"+
		"\u0c35\5\u0178\u00bd\2\u0c34\u0c33\3\2\2\2\u0c34\u0c35\3\2\2\2\u0c35\u0c36"+
		"\3\2\2\2\u0c36\u0c38\5\u0170\u00b9\2\u0c37\u0c39\5\u011a\u008e\2\u0c38"+
		"\u0c37\3\2\2\2\u0c38\u0c39\3\2\2\2\u0c39\u016f\3\2\2\2\u0c3a\u0c3f\5\u0172"+
		"\u00ba\2\u0c3b\u0c3c\7\u012e\2\2\u0c3c\u0c3e\5\u0172\u00ba\2\u0c3d\u0c3b"+
		"\3\2\2\2\u0c3e\u0c41\3\2\2\2\u0c3f\u0c3d\3\2\2\2\u0c3f\u0c40\3\2\2\2\u0c40"+
		"\u0171\3\2\2\2\u0c41\u0c3f\3\2\2\2\u0c42\u0c45\5\u0174\u00bb\2\u0c43\u0c45"+
		"\5\u0176\u00bc\2\u0c44\u0c42\3\2\2\2\u0c44\u0c43\3\2\2\2\u0c45\u0173\3"+
		"\2\2\2\u0c46\u0c48\5\u00d2j\2\u0c47\u0c49\5\u017c\u00bf\2\u0c48\u0c47"+
		"\3\2\2\2\u0c48\u0c49\3\2\2\2\u0c49\u0175\3\2\2\2\u0c4a\u0c4b\7\u0147\2"+
		"\2\u0c4b\u0c4d\7\u013c\2\2\u0c4c\u0c4a\3\2\2\2\u0c4c\u0c4d\3\2\2\2\u0c4d"+
		"\u0c4e\3\2\2\2\u0c4e\u0c4f\7\u0139\2\2\u0c4f\u0177\3\2\2\2\u0c50\u0c51"+
		"\t\35\2\2\u0c51\u0179\3\2\2\2\u0c52\u0c53\5p9\2\u0c53\u0c54\7\u013c\2"+
		"\2\u0c54\u0c56\3\2\2\2\u0c55\u0c52\3\2\2\2\u0c55\u0c56\3\2\2\2\u0c56\u0c57"+
		"\3\2\2\2\u0c57\u0c58\5p9\2\u0c58\u017b\3\2\2\2\u0c59\u0c5b\7\5\2\2\u0c5a"+
		"\u0c59\3\2\2\2\u0c5a\u0c5b\3\2\2\2\u0c5b\u0c5c\3\2\2\2\u0c5c\u0c5d\5p"+
		"9\2\u0c5d\u017d\3\2\2\2\u0c5e\u0c63\5\u017a\u00be\2\u0c5f\u0c60\7\u012e"+
		"\2\2\u0c60\u0c62\5\u017a\u00be\2\u0c61\u0c5f\3\2\2\2\u0c62\u0c65\3\2\2"+
		"\2\u0c63\u0c61\3\2\2\2\u0c63\u0c64\3\2\2\2\u0c64\u017f\3\2\2\2\u0c65\u0c63"+
		"\3\2\2\2\u0c66\u0c67\5\u0186\u00c4\2\u0c67\u0181\3\2\2\2\u0c68\u0c69\5"+
		"\u0186\u00c4\2\u0c69\u0183\3\2\2\2\u0c6a\u0c6b\5\u0186\u00c4\2\u0c6b\u0185"+
		"\3\2\2\2\u0c6c\u0c6d\7\u0135\2\2\u0c6d\u0c6e\5\u0158\u00ad\2\u0c6e\u0c6f"+
		"\7\u0136\2\2\u0c6f\u0187\3\2\2\2\u0c70\u0c77\5\u018a\u00c6\2\u0c71\u0c77"+
		"\5\u018e\u00c8\2\u0c72\u0c77\5\u0192\u00ca\2\u0c73\u0c77\5\u0198\u00cd"+
		"\2\u0c74\u0c77\5\u01a0\u00d1\2\u0c75\u0c77\5\u01aa\u00d6\2\u0c76\u0c70"+
		"\3\2\2\2\u0c76\u0c71\3\2\2\2\u0c76\u0c72\3\2\2\2\u0c76\u0c73\3\2\2\2\u0c76"+
		"\u0c74\3\2\2\2\u0c76\u0c75\3\2\2\2\u0c77\u0189\3\2\2\2\u0c78\u0c79\5\u0116"+
		"\u008c\2\u0c79\u0c7a\5\u018c\u00c7\2\u0c7a\u0c7b\5\u0116\u008c\2\u0c7b"+
		"\u018b\3\2\2\2\u0c7c\u0c7d\t\36\2\2\u0c7d\u018d\3\2\2\2\u0c7e\u0c7f\5"+
		"\u0116\u008c\2\u0c7f\u0c80\5\u0190\u00c9\2\u0c80\u018f\3\2\2\2\u0c81\u0c83"+
		"\7L\2\2\u0c82\u0c81\3\2\2\2\u0c82\u0c83\3\2\2\2\u0c83\u0c84\3\2\2\2\u0c84"+
		"\u0c86\7\u0085\2\2\u0c85\u0c87\t\37\2\2\u0c86\u0c85\3\2\2\2\u0c86\u0c87"+
		"\3\2\2\2\u0c87\u0c88\3\2\2\2\u0c88\u0c89\5\u0116\u008c\2\u0c89\u0c8a\7"+
		"\7\2\2\u0c8a\u0c8b\5\u0116\u008c\2\u0c8b\u0191\3\2\2\2\u0c8c\u0c8e\5\u00d6"+
		"l\2\u0c8d\u0c8f\7L\2\2\u0c8e\u0c8d\3\2\2\2\u0c8e\u0c8f\3\2\2\2\u0c8f\u0c90"+
		"\3\2\2\2\u0c90\u0c91\79\2\2\u0c91\u0c92\5\u0194\u00cb\2\u0c92\u0193\3"+
		"\2\2\2\u0c93\u0c99\5\u0184\u00c3\2\u0c94\u0c95\7\u0135\2\2\u0c95\u0c96"+
		"\5\u0196\u00cc\2\u0c96\u0c97\7\u0136\2\2\u0c97\u0c99\3\2\2\2\u0c98\u0c93"+
		"\3\2\2\2\u0c98\u0c94\3\2\2\2\u0c99\u0195\3\2\2\2\u0c9a\u0c9f\5\u0110\u0089"+
		"\2\u0c9b\u0c9c\7\u012e\2\2\u0c9c\u0c9e\5\u0110\u0089\2\u0c9d\u0c9b\3\2"+
		"\2\2\u0c9e\u0ca1\3\2\2\2\u0c9f\u0c9d\3\2\2\2\u0c9f\u0ca0\3\2\2\2\u0ca0"+
		"\u0197\3\2\2\2\u0ca1\u0c9f\3\2\2\2\u0ca2\u0ca3\5\u0116\u008c\2\u0ca3\u0ca4"+
		"\5\u019a\u00ce\2\u0ca4\u0ca5\7\u0148\2\2\u0ca5\u0199\3\2\2\2\u0ca6\u0ca8"+
		"\7L\2\2\u0ca7\u0ca6\3\2\2\2\u0ca7\u0ca8\3\2\2\2\u0ca8\u0ca9\3\2\2\2\u0ca9"+
		"\u0cac\5\u019c\u00cf\2\u0caa\u0cac\5\u019e\u00d0\2\u0cab\u0ca7\3\2\2\2"+
		"\u0cab\u0caa\3\2\2\2\u0cac\u019b\3\2\2\2\u0cad\u0cb4\7H\2\2\u0cae\u0cb4"+
		"\7\66\2\2\u0caf\u0cb0\7\u00e2\2\2\u0cb0\u0cb4\7\u00f3\2\2\u0cb1\u0cb4"+
		"\7\u00da\2\2\u0cb2\u0cb4\7\u00db\2\2\u0cb3\u0cad\3\2\2\2\u0cb3\u0cae\3"+
		"\2\2\2\u0cb3\u0caf\3\2\2\2\u0cb3\u0cb1\3\2\2\2\u0cb3\u0cb2\3\2\2\2\u0cb4"+
		"\u019d\3\2\2\2\u0cb5\u0cb6\t \2\2\u0cb6\u019f\3\2\2\2\u0cb7\u0cb8\5\u0116"+
		"\u008c\2\u0cb8\u0cba\7C\2\2\u0cb9\u0cbb\7L\2\2\u0cba\u0cb9\3\2\2\2\u0cba"+
		"\u0cbb\3\2\2\2\u0cbb\u0cbc\3\2\2\2\u0cbc\u0cbd\7M\2\2\u0cbd\u01a1\3\2"+
		"\2\2\u0cbe\u0cbf\5\u00d6l\2\u0cbf\u0cc0\5\u018c\u00c7\2\u0cc0\u0cc1\5"+
		"\u01a4\u00d3\2\u0cc1\u0cc2\5\u0184\u00c3\2\u0cc2\u01a3\3\2\2\2\u0cc3\u0cc6"+
		"\5\u01a6\u00d4\2\u0cc4\u0cc6\5\u01a8\u00d5\2\u0cc5\u0cc3\3\2\2\2\u0cc5"+
		"\u0cc4\3\2\2\2\u0cc6\u01a5\3\2\2\2\u0cc7\u0cc8\7\6\2\2\u0cc8\u01a7\3\2"+
		"\2\2\u0cc9\u0cca\t!\2\2\u0cca\u01a9\3\2\2\2\u0ccb\u0ccd\7L\2\2\u0ccc\u0ccb"+
		"\3\2\2\2\u0ccc\u0ccd\3\2\2\2\u0ccd\u0cce\3\2\2\2\u0cce\u0ccf\7\u00a4\2"+
		"\2\u0ccf\u0cd0\5\u0184\u00c3\2\u0cd0\u01ab\3\2\2\2\u0cd1\u0cd2\7y\2\2"+
		"\u0cd2\u0cd3\5\u0184\u00c3\2\u0cd3\u01ad\3\2\2\2\u0cd4\u0cd7\5\u01b0\u00d9"+
		"\2\u0cd5\u0cd7\7\u00de\2\2\u0cd6\u0cd4\3\2\2\2\u0cd6\u0cd5\3\2\2\2\u0cd7"+
		"\u01af\3\2\2\2\u0cd8\u0cd9\t\"\2\2\u0cd9\u01b1\3\2\2\2\u0cda\u0cdb\t#"+
		"\2\2\u0cdb\u01b3\3\2\2\2\u0cdc\u0cdd\5\u01b8\u00dd\2\u0cdd\u0cdf\7\u0135"+
		"\2\2\u0cde\u0ce0\5\u01ba\u00de\2\u0cdf\u0cde\3\2\2\2\u0cdf\u0ce0\3\2\2"+
		"\2\u0ce0\u0ce1\3\2\2\2\u0ce1\u0ce2\7\u0136\2\2\u0ce2\u01b5\3\2\2\2\u0ce3"+
		"\u0ce4\t$\2\2\u0ce4\u01b7\3\2\2\2\u0ce5\u0ce8\5p9\2\u0ce6\u0ce8\5\u01b6"+
		"\u00dc\2\u0ce7\u0ce5\3\2\2\2\u0ce7\u0ce6\3\2\2\2\u0ce8\u01b9\3\2\2\2\u0ce9"+
		"\u0cee\5\u00d2j\2\u0cea\u0ceb\7\u012e\2\2\u0ceb\u0ced\5\u00d2j\2\u0cec"+
		"\u0cea\3\2\2\2\u0ced\u0cf0\3\2\2\2\u0cee\u0cec\3\2\2\2\u0cee\u0cef\3\2"+
		"\2\2\u0cef\u01bb\3\2\2\2\u0cf0\u0cee\3\2\2\2\u0cf1\u0cf2\7U\2\2\u0cf2"+
		"\u0cf3\7\u0086\2\2\u0cf3\u0cf4\5\u01be\u00e0\2\u0cf4\u01bd\3\2\2\2\u0cf5"+
		"\u0cfa\5\u01c0\u00e1\2\u0cf6\u0cf7\7\u012e\2\2\u0cf7\u0cf9\5\u01c0\u00e1"+
		"\2\u0cf8\u0cf6\3\2\2\2\u0cf9\u0cfc\3\2\2\2\u0cfa\u0cf8\3\2\2\2\u0cfa\u0cfb"+
		"\3\2\2\2\u0cfb\u01bf\3\2\2\2\u0cfc\u0cfa\3\2\2\2\u0cfd\u0cff\5\u0116\u008c"+
		"\2\u0cfe\u0d00\5\u01c2\u00e2\2\u0cff\u0cfe\3\2\2\2\u0cff\u0d00\3\2\2\2"+
		"\u0d00\u0d02\3\2\2\2\u0d01\u0d03\5\u01c6\u00e4\2\u0d02\u0d01\3\2\2\2\u0d02"+
		"\u0d03\3\2\2\2\u0d03\u01c1\3\2\2\2\u0d04\u0d05\t%\2\2\u0d05\u01c3\3\2"+
		"\2\2\u0d06\u0d07\7I\2\2\u0d07\u0d08\5\u00d6l\2\u0d08\u01c5\3\2\2\2\u0d09"+
		"\u0d0a\7M\2\2\u0d0a\u0d0e\7\u00a9\2\2\u0d0b\u0d0c\7M\2\2\u0d0c\u0d0e\7"+
		"\u00bb\2\2\u0d0d\u0d09\3\2\2\2\u0d0d\u0d0b\3\2\2\2\u0d0e\u01c7\3\2\2\2"+
		"\u0d0f\u0d11\7\u00b3\2\2\u0d10\u0d12\7\u00d0\2\2\u0d11\u0d10\3\2\2\2\u0d11"+
		"\u0d12\3\2\2\2\u0d12\u0d13\3\2\2\2\u0d13\u0d14\7?\2\2\u0d14\u0d19\5\u016c"+
		"\u00b7\2\u0d15\u0d16\7\u0135\2\2\u0d16\u0d17\5\u013c\u009f\2\u0d17\u0d18"+
		"\7\u0136\2\2\u0d18\u0d1a\3\2\2\2\u0d19\u0d15\3\2\2\2\u0d19\u0d1a\3\2\2"+
		"\2\u0d1a\u0d1b\3\2\2\2\u0d1b\u0d1c\5\u0158\u00ad\2\u0d1c\u0d2d\3\2\2\2"+
		"\u0d1d\u0d1f\7\u00b3\2\2\u0d1e\u0d20\7\u00d0\2\2\u0d1f\u0d1e\3\2\2\2\u0d1f"+
		"\u0d20\3\2\2\2\u0d20\u0d21\3\2\2\2\u0d21\u0d22\7?\2\2\u0d22\u0d23\7\u00be"+
		"\2\2\u0d23\u0d29\7\u0148\2\2\u0d24\u0d25\7|\2\2\u0d25\u0d27\5p9\2\u0d26"+
		"\u0d28\5J&\2\u0d27\u0d26\3\2\2\2\u0d27\u0d28\3\2\2\2\u0d28\u0d2a\3\2\2"+
		"\2\u0d29\u0d24\3\2\2\2\u0d29\u0d2a\3\2\2\2\u0d2a\u0d2b\3\2\2\2\u0d2b\u0d2d"+
		"\5\u0158\u00ad\2\u0d2c\u0d0f\3\2\2\2\u0d2c\u0d1d\3\2\2\2\u0d2d\u01c9\3"+
		"\2\2\2\u01e2\u01cc\u01d0\u01e2\u01ea\u01ee\u01f5\u01fb\u0202\u0206\u020a"+
		"\u020e\u0212\u0216\u0220\u0223\u0227\u022b\u0232\u0235\u0239\u023b\u023f"+
		"\u0247\u0250\u0254\u0256\u0258\u025e\u0263\u0269\u026d\u0271\u0275\u027d"+
		"\u027f\u0287\u028c\u0290\u0292\u0296\u029b\u02a4\u02a6\u02ae\u02b4\u02b8"+
		"\u02be\u02c2\u02c7\u02cb\u02cf\u02d3\u02d7\u02db\u02e3\u02e8\u02ec\u02ee"+
		"\u02f4\u02f8\u0300\u0304\u0306\u030e\u0313\u0317\u0319\u031f\u0323\u032b"+
		"\u0330\u0332\u033a\u033e\u0346\u034b\u034d\u0354\u0358\u0360\u0365\u0367"+
		"\u036c\u0374\u0379\u037b\u0381\u0385\u038d\u0392\u0394\u0396\u039a\u039c"+
		"\u03a3\u03a7\u03af\u03b3\u03b7\u03bb\u03bd\u03c3\u03c7\u03cf\u03d4\u03d6"+
		"\u03dc\u03e0\u03e8\u03ec\u03f0\u03f5\u03f9\u03fc\u03fe\u0402\u0407\u0409"+
		"\u040b\u040e\u0414\u0418\u041a\u041e\u0422\u0426\u042e\u0432\u0434\u043c"+
		"\u0440\u0444\u0448\u044c\u0450\u0452\u0456\u045a\u045e\u0465\u0469\u046d"+
		"\u046f\u0475\u0479\u0481\u0485\u0487\u048e\u0492\u0496\u0498\u049e\u04a2"+
		"\u04aa\u04ac\u04b4\u04b8\u04c0\u04c2\u04c9\u04cd\u04d5\u04d7\u04dc\u04e4"+
		"\u04e6\u04ec\u04f0\u04f7\u04fb\u04ff\u0501\u0508\u050c\u0513\u0517\u051b"+
		"\u051d\u0523\u0527\u052f\u0531\u0537\u053b\u0541\u0545\u054a\u054e\u0553"+
		"\u0555\u0559\u055d\u0560\u0564\u0569\u0572\u0576\u05b6\u05e4\u05ec\u05f2"+
		"\u05f5\u05fc\u05fe\u0600\u0602\u0604\u060f\u0613\u0617\u062a\u062f\u063f"+
		"\u0647\u0649\u064f\u0653\u0657\u065d\u066a\u066d\u0671\u0675\u0680\u0684"+
		"\u0688\u068e\u0695\u069b\u069f\u06a5\u06ac\u06ae\u06b0\u06b8\u06bd\u06c7"+
		"\u06d2\u06db\u06e5\u06e8\u06f3\u06f6\u06f9\u06fd\u0704\u0707\u070a\u0711"+
		"\u0715\u071b\u0723\u0728\u0731\u0734\u0737\u073b\u073d\u0744\u0748\u074c"+
		"\u0754\u0758\u075e\u076a\u076e\u0771\u0775\u0779\u077f\u0786\u078d\u0791"+
		"\u079b\u079f\u07a7\u07ae\u07b2\u07bb\u07c2\u07c6\u07ce\u07d2\u07d6\u07de"+
		"\u07e3\u07e8\u07ea\u07ef\u07f5\u07f9\u080f\u0814\u0819\u081b\u0820\u0826"+
		"\u0832\u0835\u0839\u0842\u084b\u084d\u0851\u0859\u085c\u0862\u086a\u087b"+
		"\u0890\u08a1\u08ae\u08b2\u08b4\u08c1\u08c8\u08e0\u08e7\u08f8\u08fb\u08ff"+
		"\u0902\u0908\u090d\u0912\u092c\u0934\u0938\u093d\u0942\u0946\u0949\u0952"+
		"\u0957\u095b\u0961\u0967\u096c\u0970\u0972\u0976\u097a\u097c\u0980\u0984"+
		"\u0988\u098c\u0997\u099b\u09a3\u09ad\u09be\u09c2\u09c6\u09cb\u09cd\u09d1"+
		"\u09d6\u09da\u09dc\u09e0\u09ed\u09f4\u0a00\u0a02\u0a07\u0a29\u0a2d\u0a31"+
		"\u0a38\u0a3b\u0a43\u0a46\u0a59\u0a69\u0a6e\u0a75\u0a7d\u0a81\u0a8b\u0a95"+
		"\u0a99\u0aa9\u0aaf\u0ab8\u0abf\u0ac9\u0acc\u0acf\u0ad6\u0ae1\u0ae9\u0aef"+
		"\u0af3\u0af7\u0aff\u0b03\u0b0b\u0b13\u0b17\u0b1b\u0b1e\u0b21\u0b24\u0b27"+
		"\u0b31\u0b36\u0b3c\u0b42\u0b4a\u0b51\u0b58\u0b60\u0b6b\u0b6f\u0b75\u0b81"+
		"\u0b84\u0b8a\u0b8e\u0b95\u0b97\u0b9e\u0bb1\u0bb8\u0bbf\u0bc6\u0bde\u0be5"+
		"\u0beb\u0bef\u0bf3\u0bf8\u0bfd\u0c03\u0c07\u0c0b\u0c10\u0c15\u0c1c\u0c20"+
		"\u0c27\u0c2e\u0c30\u0c34\u0c38\u0c3f\u0c44\u0c48\u0c4c\u0c55\u0c5a\u0c63"+
		"\u0c76\u0c82\u0c86\u0c8e\u0c98\u0c9f\u0ca7\u0cab\u0cb3\u0cba\u0cc5\u0ccc"+
		"\u0cd6\u0cdf\u0ce7\u0cee\u0cfa\u0cff\u0d02\u0d0d\u0d11\u0d19\u0d1f\u0d27"+
		"\u0d29\u0d2c";
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