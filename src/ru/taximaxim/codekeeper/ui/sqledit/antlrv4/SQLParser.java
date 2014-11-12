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
		FUNCTION=43, ISODOW=179, OVERWRITE=205, FUNCTIONS=44, ROW=90, PRECISION=210, 
		ILIKE=51, Character_String_Literal=325, NOT=73, EXCEPT=34, FOREIGN=41, 
		CACHE=132, PRIVILEGES=86, BYTEA=288, MONTH=197, STATEMENT=105, CHARACTER=136, 
		TYPE=116, BlockComment=322, VARBIT=257, STDDEV_POP=228, CREATE=20, COMMENTS=142, 
		ESC_SEQUENCES=326, USING=121, UNLOGGED=242, NOT_EQUAL=301, TIMEZONE_MINUTE=238, 
		VERTICAL_BAR=315, VARIADIC=122, TIMESTAMPTZ=283, REGEXP=215, FAMILY=164, 
		GEQ=305, STDDEV_SAMP=229, DIVIDE=311, BLOB=287, STRICT=106, PRESERVE=84, 
		ASC=8, GROUPING=169, SUBPARTITION=230, KEY=66, TEMP=109, ELSE=33, NUMBER=320, 
		BOOL=255, TRAILING=112, DEFINER=154, SEMI_COLON=298, INT=264, RLIKE=216, 
		RESTRICT=94, LEADING=67, SERVER=221, PROCEDURAL=88, TABLESPACE=232, MILLISECONDS=193, 
		REAL=269, INTERSECT=59, GROUP=48, LANGUAGE=182, SEQUENCES=101, OUT=79, 
		REAL_NUMBER=321, NONE=200, TRIM=239, LEFT_PAREN=306, LOCATION=187, SEARCH=218, 
		END=32, CONSTRAINT=17, TIMEZONE_HOUR=237, CAST_EXPRESSION=294, OPTION=203, 
		ISOYEAR=180, NCHAR=277, EXECUTE=37, INPUT=175, TABLE=108, VARCHAR=276, 
		FLOAT=271, VERSION=247, IMMUTABLE=53, MICROSECONDS=191, ASYMMETRIC=7, 
		SUM=231, OWNED=83, Space=327, INOUT=61, STORAGE=227, TIME=280, AS=3, RIGHT_PAREN=307, 
		THEN=111, COLLATION=15, MAXVALUE=190, REPLACE=93, LEFT=68, AVG=129, ZONE=253, 
		TRUNCATE=115, COLUMN=140, PLUS=308, EXISTS=161, NVARCHAR=278, Not_Similar_To=291, 
		RETURNS=95, LIKE=69, COLLATE=14, INTEGER=265, OUTER=78, BY=131, DEFERRABLE=25, 
		TO=240, SET=222, RIGHT=97, HAVING=49, MIN=194, SESSION=103, MINUS=309, 
		TEXT=284, HOUR=171, CONCATENATION_OPERATOR=300, CONVERSION=19, UNION=117, 
		CURRENT=148, COLON=297, COMMIT=143, SCHEMA=99, DATABASE=22, DECIMAL=274, 
		DROP=158, BIGINT=266, WHEN=124, ROWS=91, START=226, BIT=256, LARGE=183, 
		REVOKE=96, NATURAL=72, FORMAT=167, PUBLIC=211, AGGREGATE=1, EXTENSION=38, 
		BETWEEN=130, OPTIONS=204, FIRST=166, CAST=13, WEEK=249, EXTERNAL=162, 
		DOUBLE_QUOTE=317, VARYING=246, TRIGGER=113, CASE=11, CHAR=275, INT8=261, 
		COUNT=146, DAY=151, CASCADE=12, COST=145, INT2=259, INT1=258, Identifier=324, 
		INT4=260, ISCACHABLE=178, QUOTE=316, MODULAR=312, INVOKER=63, FULL=42, 
		DICTIONARY=155, THAN=235, QUARTER=213, INSERT=176, INHERITS=56, CONNECT=16, 
		INTERSECTION=177, LESS=185, TINYINT=262, BOTH=10, Similar_To_Case_Insensitive=292, 
		DOUBLE=272, ADMIN=128, SYMMETRIC=107, ISSTRICT=181, EACH=31, LAST=184, 
		COMMENT=141, SELECT=102, INTO=60, UNIQUE=118, COALESCE=139, SECOND=219, 
		ROLE=89, RULE=98, VIEW=123, EPOCH=159, ROLLUP=217, NULL=74, WITHOUT=127, 
		NO=199, EVERY=160, ON=77, MATCH=188, PRIMARY=85, DELETE=27, INET4=289, 
		NUMERIC=273, LOCAL=71, OF=75, EXCLUDING=36, LIST=186, TABLES=233, UNDERLINE=314, 
		SEQUENCE=100, Not_Similar_To_Case_Insensitive=293, CUBE=147, NATIONAL=198, 
		CALLED=133, VAR_POP=245, OR=81, FILTER=165, CHECK=137, FROM=45, FALSE=39, 
		COLLECT=138, PARSER=206, DISTINCT=29, TEMPORARY=110, TIMESTAMP=282, SIMPLE=224, 
		DOLLAR=318, CONSTRAINTS=18, WHERE=125, DEC=152, VAR_SAMP=244, NULLIF=201, 
		CLASS=134, TIMETZ=281, INNER=58, YEAR=252, TIMEZONE=236, ORDER=82, LIMIT=70, 
		DECADE=153, GTH=304, CYCLE=149, White_Space=328, UPDATE=119, MAX=189, 
		LineComment=323, DEFERRED=26, FOR=40, FLOAT4=267, CONFIGURATION=144, FLOAT8=268, 
		AND=5, CROSS=21, Similar_To=290, USAGE=120, IF=50, INDEX=172, OIDS=76, 
		BOOLEAN=254, IN=54, MINVALUE=195, UNKNOWN=241, MULTIPLY=310, OBJECT=202, 
		COMMA=299, REFERENCES=92, PARTITION=208, IS=64, PARTITIONS=209, SOME=104, 
		EQUAL=296, ALL=4, DOUBLE_DOLLAR=319, DOT=313, EXTRACT=163, CENTURY=135, 
		STABLE=225, SECURITY=220, PARTIAL=207, DOW=156, EXCLUDE=35, WITH=126, 
		INITIALLY=57, DOY=157, FUSION=168, GRANT=47, VARBINARY=286, VOLATILE=248, 
		OPERATOR=80, DEFAULT=23, VALUES=243, HASH=170, RANGE=214, INDEXES=173, 
		MILLENNIUM=192, PURGE=212, BEFORE=9, AFTER=2, INSTEAD=62, WRAPPER=251, 
		TRUE=114, PROCEDURE=87, JOIN=65, SIMILAR=223, DOMAIN=30, DEFAULTS=24, 
		LTH=302, INCREMENT=174, ANY=6, TEMPLATE=234, BAD=329, ASSIGN=295, REGCLASS=270, 
		IMMEDIATE=52, WINDOW=250, BINARY=285, DESC=28, DATE=279, MINUTE=196, GLOBAL=46, 
		DATA=150, INCLUDING=55, LEQ=303, SMALLINT=263;
	public static final String[] tokenNames = {
		"<INVALID>", "AGGREGATE", "AFTER", "AS", "ALL", "AND", "ANY", "ASYMMETRIC", 
		"ASC", "BEFORE", "BOTH", "CASE", "CASCADE", "CAST", "COLLATE", "COLLATION", 
		"CONNECT", "CONSTRAINT", "CONSTRAINTS", "CONVERSION", "CREATE", "CROSS", 
		"DATABASE", "DEFAULT", "DEFAULTS", "DEFERRABLE", "DEFERRED", "DELETE", 
		"DESC", "DISTINCT", "DOMAIN", "EACH", "END", "ELSE", "EXCEPT", "EXCLUDE", 
		"EXCLUDING", "EXECUTE", "EXTENSION", "FALSE", "FOR", "FOREIGN", "FULL", 
		"FUNCTION", "FUNCTIONS", "FROM", "GLOBAL", "GRANT", "GROUP", "HAVING", 
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
		RULE_create_table_statement = 21, RULE_like_option = 22, RULE_table_constraint = 23, 
		RULE_column_constraint = 24, RULE_check_boolean_expression = 25, RULE_storage_parameter = 26, 
		RULE_storage_parameter_oid = 27, RULE_on_commit = 28, RULE_table_space = 29, 
		RULE_action = 30, RULE_index_parameters = 31, RULE_table_elements = 32, 
		RULE_field_element = 33, RULE_field_type = 34, RULE_param_clause = 35, 
		RULE_param = 36, RULE_method_specifier = 37, RULE_table_space_specifier = 38, 
		RULE_table_space_name = 39, RULE_table_partitioning_clauses = 40, RULE_range_partitions = 41, 
		RULE_range_value_clause_list = 42, RULE_range_value_clause = 43, RULE_hash_partitions = 44, 
		RULE_individual_hash_partitions = 45, RULE_individual_hash_partition = 46, 
		RULE_hash_partitions_by_quantity = 47, RULE_list_partitions = 48, RULE_list_value_clause_list = 49, 
		RULE_list_value_partition = 50, RULE_column_partitions = 51, RULE_partition_name = 52, 
		RULE_drop_table_statement = 53, RULE_identifier = 54, RULE_nonreserved_keywords = 55, 
		RULE_unsigned_literal = 56, RULE_general_literal = 57, RULE_datetime_literal = 58, 
		RULE_time_literal = 59, RULE_timestamp_literal = 60, RULE_date_literal = 61, 
		RULE_boolean_literal = 62, RULE_data_type = 63, RULE_predefined_type = 64, 
		RULE_regclass = 65, RULE_network_type = 66, RULE_character_string_type = 67, 
		RULE_type_length = 68, RULE_national_character_string_type = 69, RULE_binary_large_object_string_type = 70, 
		RULE_numeric_type = 71, RULE_exact_numeric_type = 72, RULE_approximate_numeric_type = 73, 
		RULE_precision_param = 74, RULE_boolean_type = 75, RULE_datetime_type = 76, 
		RULE_bit_type = 77, RULE_binary_type = 78, RULE_value_expression_primary = 79, 
		RULE_parenthesized_value_expression = 80, RULE_nonparenthesized_value_expression_primary = 81, 
		RULE_unsigned_value_specification = 82, RULE_unsigned_numeric_literal = 83, 
		RULE_signed_numerical_literal = 84, RULE_set_function_specification = 85, 
		RULE_aggregate_function = 86, RULE_general_set_function = 87, RULE_set_function_type = 88, 
		RULE_filter_clause = 89, RULE_grouping_operation = 90, RULE_case_expression = 91, 
		RULE_case_abbreviation = 92, RULE_case_specification = 93, RULE_simple_case = 94, 
		RULE_searched_case = 95, RULE_simple_when_clause = 96, RULE_searched_when_clause = 97, 
		RULE_else_clause = 98, RULE_result = 99, RULE_cast_specification = 100, 
		RULE_cast_operand = 101, RULE_cast_target = 102, RULE_value_expression = 103, 
		RULE_common_value_expression = 104, RULE_numeric_value_expression = 105, 
		RULE_term = 106, RULE_factor = 107, RULE_array = 108, RULE_numeric_primary = 109, 
		RULE_sign = 110, RULE_numeric_value_function = 111, RULE_extract_expression = 112, 
		RULE_extract_field = 113, RULE_time_zone_field = 114, RULE_extract_source = 115, 
		RULE_string_value_expression = 116, RULE_character_value_expression = 117, 
		RULE_character_factor = 118, RULE_character_primary = 119, RULE_string_value_function = 120, 
		RULE_trim_function = 121, RULE_trim_operands = 122, RULE_trim_specification = 123, 
		RULE_boolean_value_expression = 124, RULE_or_predicate = 125, RULE_and_predicate = 126, 
		RULE_boolean_factor = 127, RULE_boolean_test = 128, RULE_is_clause = 129, 
		RULE_truth_value = 130, RULE_boolean_primary = 131, RULE_boolean_predicand = 132, 
		RULE_parenthesized_boolean_value_expression = 133, RULE_row_value_expression = 134, 
		RULE_row_value_special_case = 135, RULE_explicit_row_value_constructor = 136, 
		RULE_row_value_predicand = 137, RULE_row_value_constructor_predicand = 138, 
		RULE_table_expression = 139, RULE_from_clause = 140, RULE_table_reference_list = 141, 
		RULE_table_reference = 142, RULE_joined_table = 143, RULE_joined_table_primary = 144, 
		RULE_cross_join = 145, RULE_qualified_join = 146, RULE_natural_join = 147, 
		RULE_union_join = 148, RULE_join_type = 149, RULE_outer_join_type = 150, 
		RULE_outer_join_type_part2 = 151, RULE_join_specification = 152, RULE_join_condition = 153, 
		RULE_named_columns_join = 154, RULE_table_primary = 155, RULE_column_name_list = 156, 
		RULE_derived_table = 157, RULE_where_clause = 158, RULE_search_condition = 159, 
		RULE_groupby_clause = 160, RULE_grouping_element_list = 161, RULE_grouping_element = 162, 
		RULE_ordinary_grouping_set = 163, RULE_ordinary_grouping_set_list = 164, 
		RULE_rollup_list = 165, RULE_cube_list = 166, RULE_empty_grouping_set = 167, 
		RULE_having_clause = 168, RULE_row_value_predicand_list = 169, RULE_query_expression = 170, 
		RULE_query_expression_body = 171, RULE_non_join_query_expression = 172, 
		RULE_query_term = 173, RULE_non_join_query_term = 174, RULE_query_primary = 175, 
		RULE_non_join_query_primary = 176, RULE_simple_table = 177, RULE_explicit_table = 178, 
		RULE_table_or_query_name = 179, RULE_schema_qualified_name = 180, RULE_query_specification = 181, 
		RULE_select_list = 182, RULE_select_sublist = 183, RULE_derived_column = 184, 
		RULE_qualified_asterisk = 185, RULE_set_qualifier = 186, RULE_column_reference = 187, 
		RULE_as_clause = 188, RULE_column_reference_list = 189, RULE_scalar_subquery = 190, 
		RULE_row_subquery = 191, RULE_table_subquery = 192, RULE_subquery = 193, 
		RULE_predicate = 194, RULE_comparison_predicate = 195, RULE_comp_op = 196, 
		RULE_between_predicate = 197, RULE_between_predicate_part_2 = 198, RULE_in_predicate = 199, 
		RULE_in_predicate_value = 200, RULE_in_value_list = 201, RULE_pattern_matching_predicate = 202, 
		RULE_pattern_matcher = 203, RULE_negativable_matcher = 204, RULE_regex_matcher = 205, 
		RULE_null_predicate = 206, RULE_quantified_comparison_predicate = 207, 
		RULE_quantifier = 208, RULE_all = 209, RULE_some = 210, RULE_exists_predicate = 211, 
		RULE_unique_predicate = 212, RULE_primary_datetime_field = 213, RULE_non_second_primary_datetime_field = 214, 
		RULE_extended_datetime_field = 215, RULE_routine_invocation = 216, RULE_function_names_for_reserved_words = 217, 
		RULE_function_name = 218, RULE_sql_argument_list = 219, RULE_orderby_clause = 220, 
		RULE_sort_specifier_list = 221, RULE_sort_specifier = 222, RULE_order_specification = 223, 
		RULE_limit_clause = 224, RULE_null_ordering = 225, RULE_insert_statement = 226;
	public static final String[] ruleNames = {
		"sql", "statement", "data_statement", "data_change_statement", "schema_statement", 
		"index_statement", "create_extension_statement", "set_statement", "create_trigger_statement", 
		"revoke_statement", "revoke_from_cascade_restrict", "grant_statement", 
		"grant_to_rule", "comment_on_statement", "create_function_statement", 
		"function_body", "function_attribute", "argmode", "function_definition", 
		"functions_definition_schema", "create_sequence_statement", "create_table_statement", 
		"like_option", "table_constraint", "column_constraint", "check_boolean_expression", 
		"storage_parameter", "storage_parameter_oid", "on_commit", "table_space", 
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
			setState(460);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CREATE || _la==GRANT || ((((_la - 96)) & ~0x3f) == 0 && ((1L << (_la - 96)) & ((1L << (REVOKE - 96)) | (1L << (SELECT - 96)) | (1L << (TABLE - 96)) | (1L << (ADMIN - 96)) | (1L << (AVG - 96)) | (1L << (BETWEEN - 96)) | (1L << (BY - 96)) | (1L << (CACHE - 96)) | (1L << (CALLED - 96)) | (1L << (CLASS - 96)) | (1L << (CENTURY - 96)) | (1L << (CHARACTER - 96)) | (1L << (CHECK - 96)) | (1L << (COLLECT - 96)) | (1L << (COALESCE - 96)) | (1L << (COLUMN - 96)) | (1L << (COMMENT - 96)) | (1L << (COMMENTS - 96)) | (1L << (COMMIT - 96)) | (1L << (CONFIGURATION - 96)) | (1L << (COST - 96)) | (1L << (COUNT - 96)) | (1L << (CUBE - 96)) | (1L << (CURRENT - 96)) | (1L << (CYCLE - 96)) | (1L << (DATA - 96)) | (1L << (DAY - 96)) | (1L << (DEC - 96)) | (1L << (DECADE - 96)) | (1L << (DEFINER - 96)) | (1L << (DICTIONARY - 96)) | (1L << (DOW - 96)) | (1L << (DOY - 96)) | (1L << (DROP - 96)) | (1L << (EPOCH - 96)))) != 0) || ((((_la - 160)) & ~0x3f) == 0 && ((1L << (_la - 160)) & ((1L << (EVERY - 160)) | (1L << (EXISTS - 160)) | (1L << (EXTERNAL - 160)) | (1L << (EXTRACT - 160)) | (1L << (FAMILY - 160)) | (1L << (FILTER - 160)) | (1L << (FIRST - 160)) | (1L << (FORMAT - 160)) | (1L << (FUSION - 160)) | (1L << (GROUPING - 160)) | (1L << (HASH - 160)) | (1L << (INDEX - 160)) | (1L << (INCREMENT - 160)) | (1L << (INPUT - 160)) | (1L << (INSERT - 160)) | (1L << (INTERSECTION - 160)) | (1L << (ISCACHABLE - 160)) | (1L << (ISODOW - 160)) | (1L << (ISOYEAR - 160)) | (1L << (ISSTRICT - 160)) | (1L << (LANGUAGE - 160)) | (1L << (LARGE - 160)) | (1L << (LAST - 160)) | (1L << (LESS - 160)) | (1L << (LIST - 160)) | (1L << (LOCATION - 160)) | (1L << (MATCH - 160)) | (1L << (MAX - 160)) | (1L << (MAXVALUE - 160)) | (1L << (MICROSECONDS - 160)) | (1L << (MILLENNIUM - 160)) | (1L << (MILLISECONDS - 160)) | (1L << (MIN - 160)) | (1L << (MINVALUE - 160)) | (1L << (MINUTE - 160)) | (1L << (MONTH - 160)) | (1L << (NATIONAL - 160)) | (1L << (NO - 160)) | (1L << (NONE - 160)) | (1L << (NULLIF - 160)) | (1L << (OBJECT - 160)) | (1L << (OPTION - 160)) | (1L << (OPTIONS - 160)) | (1L << (OVERWRITE - 160)) | (1L << (PARSER - 160)) | (1L << (PARTIAL - 160)) | (1L << (PARTITION - 160)) | (1L << (PARTITIONS - 160)) | (1L << (PRECISION - 160)) | (1L << (PUBLIC - 160)) | (1L << (PURGE - 160)) | (1L << (QUARTER - 160)) | (1L << (RANGE - 160)) | (1L << (REGEXP - 160)) | (1L << (RLIKE - 160)) | (1L << (ROLLUP - 160)) | (1L << (SEARCH - 160)) | (1L << (SECOND - 160)) | (1L << (SECURITY - 160)) | (1L << (SERVER - 160)) | (1L << (SET - 160)) | (1L << (SIMILAR - 160)))) != 0) || ((((_la - 224)) & ~0x3f) == 0 && ((1L << (_la - 224)) & ((1L << (SIMPLE - 224)) | (1L << (STABLE - 224)) | (1L << (START - 224)) | (1L << (STORAGE - 224)) | (1L << (STDDEV_POP - 224)) | (1L << (STDDEV_SAMP - 224)) | (1L << (SUBPARTITION - 224)) | (1L << (SUM - 224)) | (1L << (TABLESPACE - 224)) | (1L << (TEMPLATE - 224)) | (1L << (THAN - 224)) | (1L << (TIMEZONE - 224)) | (1L << (TIMEZONE_HOUR - 224)) | (1L << (TIMEZONE_MINUTE - 224)) | (1L << (TRIM - 224)) | (1L << (TO - 224)) | (1L << (UNKNOWN - 224)) | (1L << (UNLOGGED - 224)) | (1L << (VALUES - 224)) | (1L << (VAR_SAMP - 224)) | (1L << (VAR_POP - 224)) | (1L << (VARYING - 224)) | (1L << (VOLATILE - 224)) | (1L << (WEEK - 224)) | (1L << (WINDOW - 224)) | (1L << (WRAPPER - 224)) | (1L << (YEAR - 224)) | (1L << (ZONE - 224)) | (1L << (BOOLEAN - 224)) | (1L << (BOOL - 224)) | (1L << (BIT - 224)) | (1L << (VARBIT - 224)) | (1L << (INT1 - 224)) | (1L << (INT2 - 224)) | (1L << (INT4 - 224)) | (1L << (INT8 - 224)) | (1L << (TINYINT - 224)) | (1L << (SMALLINT - 224)) | (1L << (INT - 224)) | (1L << (INTEGER - 224)) | (1L << (BIGINT - 224)) | (1L << (FLOAT4 - 224)) | (1L << (FLOAT8 - 224)) | (1L << (REAL - 224)) | (1L << (FLOAT - 224)) | (1L << (DOUBLE - 224)) | (1L << (NUMERIC - 224)) | (1L << (DECIMAL - 224)) | (1L << (CHAR - 224)) | (1L << (VARCHAR - 224)) | (1L << (NCHAR - 224)) | (1L << (NVARCHAR - 224)) | (1L << (DATE - 224)) | (1L << (TIME - 224)) | (1L << (TIMETZ - 224)) | (1L << (TIMESTAMP - 224)) | (1L << (TIMESTAMPTZ - 224)) | (1L << (TEXT - 224)) | (1L << (VARBINARY - 224)) | (1L << (BLOB - 224)))) != 0) || ((((_la - 288)) & ~0x3f) == 0 && ((1L << (_la - 288)) & ((1L << (BYTEA - 288)) | (1L << (INET4 - 288)) | (1L << (LEFT_PAREN - 288)) | (1L << (QUOTE - 288)) | (1L << (Identifier - 288)))) != 0)) {
				{
				{
				setState(454); statement();
				setState(456);
				_la = _input.LA(1);
				if (_la==SEMI_COLON) {
					{
					setState(455); match(SEMI_COLON);
					}
				}

				}
				}
				setState(462);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(463); match(EOF);
			}
		}
		catch (RecognitionException re) {
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
		public Grant_statementContext grant_statement() {
			return getRuleContext(Grant_statementContext.class,0);
		}
		public Create_trigger_statementContext create_trigger_statement() {
			return getRuleContext(Create_trigger_statementContext.class,0);
		}
		public Data_change_statementContext data_change_statement() {
			return getRuleContext(Data_change_statementContext.class,0);
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
			setState(477);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(465); data_statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(466); data_change_statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(467); schema_statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(468); index_statement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(469); create_extension_statement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(470); set_statement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(471); create_trigger_statement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(472); grant_statement();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(473); revoke_statement();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(474); comment_on_statement();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(475); create_function_statement();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(476); create_sequence_statement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
			setState(479); query_expression();
			}
		}
		catch (RecognitionException re) {
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
			setState(481); insert_statement();
			}
		}
		catch (RecognitionException re) {
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
			setState(485);
			switch (_input.LA(1)) {
			case CREATE:
				enterOuterAlt(_localctx, 1);
				{
				setState(483); create_table_statement();
				}
				break;
			case DROP:
				enterOuterAlt(_localctx, 2);
				{
				setState(484); drop_table_statement();
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
			setState(487); match(CREATE);
			setState(489);
			_la = _input.LA(1);
			if (_la==UNIQUE) {
				{
				setState(488); ((Index_statementContext)_localctx).u = match(UNIQUE);
				}
			}

			setState(491); match(INDEX);
			setState(492); ((Index_statementContext)_localctx).n = identifier();
			setState(493); match(ON);
			setState(494); ((Index_statementContext)_localctx).t = schema_qualified_name();
			setState(496);
			_la = _input.LA(1);
			if (_la==USING) {
				{
				setState(495); ((Index_statementContext)_localctx).m = method_specifier();
				}
			}

			setState(498); match(LEFT_PAREN);
			setState(499); ((Index_statementContext)_localctx).s = sort_specifier_list();
			setState(500); match(RIGHT_PAREN);
			setState(502);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(501); ((Index_statementContext)_localctx).p = param_clause();
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
			setState(504); match(CREATE);
			setState(505); match(EXTENSION);
			setState(509);
			_la = _input.LA(1);
			if (_la==IF) {
				{
				setState(506); match(IF);
				setState(507); match(NOT);
				setState(508); match(EXISTS);
				}
			}

			setState(511); ((Create_extension_statementContext)_localctx).name = identifier();
			setState(513);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(512); match(WITH);
				}
			}

			setState(517);
			_la = _input.LA(1);
			if (_la==SCHEMA) {
				{
				setState(515); match(SCHEMA);
				setState(516); ((Create_extension_statementContext)_localctx).schema_name = identifier();
				}
			}

			setState(521);
			_la = _input.LA(1);
			if (_la==VERSION) {
				{
				setState(519); match(VERSION);
				setState(520); ((Create_extension_statementContext)_localctx).version = identifier();
				}
			}

			setState(525);
			_la = _input.LA(1);
			if (_la==FROM) {
				{
				setState(523); match(FROM);
				setState(524); ((Create_extension_statementContext)_localctx).old_version = identifier();
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
			setState(566);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(527); match(SET);
				setState(529);
				_la = _input.LA(1);
				if (_la==LOCAL || _la==SESSION) {
					{
					setState(528);
					_la = _input.LA(1);
					if ( !(_la==LOCAL || _la==SESSION) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(531); ((Set_statementContext)_localctx).config_param = identifier();
				setState(532);
				_la = _input.LA(1);
				if ( !(_la==TO || _la==EQUAL) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(544); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(539);
						switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
						case 1:
							{
							setState(533); ((Set_statementContext)_localctx).value = identifier();
							}
							break;
						case 2:
							{
							setState(534); match(QUOTE);
							setState(535); ((Set_statementContext)_localctx).value = identifier();
							setState(536); match(QUOTE);
							}
							break;
						case 3:
							{
							setState(538); match(DEFAULT);
							}
							break;
						}
						setState(542);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(541); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(546); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(548); match(SET);
				setState(550);
				_la = _input.LA(1);
				if (_la==LOCAL || _la==SESSION) {
					{
					setState(549);
					_la = _input.LA(1);
					if ( !(_la==LOCAL || _la==SESSION) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(552); match(TIME);
				setState(553); match(ZONE);
				setState(562); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(557);
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
							setState(554); ((Set_statementContext)_localctx).timezone = identifier();
							}
							break;
						case LOCAL:
							{
							setState(555); match(LOCAL);
							}
							break;
						case DEFAULT:
							{
							setState(556); match(DEFAULT);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(560);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(559); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(564); 
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
			setState(568); match(CREATE);
			setState(570);
			_la = _input.LA(1);
			if (_la==CONSTRAINT) {
				{
				setState(569); match(CONSTRAINT);
				}
			}

			setState(572); match(TRIGGER);
			setState(573); ((Create_trigger_statementContext)_localctx).name = identifier();
			setState(578);
			switch (_input.LA(1)) {
			case BEFORE:
				{
				setState(574); match(BEFORE);
				}
				break;
			case INSTEAD:
				{
				{
				setState(575); match(INSTEAD);
				setState(576); match(OF);
				}
				}
				break;
			case AFTER:
				{
				setState(577); match(AFTER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(595);
			switch (_input.LA(1)) {
			case INSERT:
				{
				setState(580); match(INSERT);
				}
				break;
			case DELETE:
				{
				setState(581); match(DELETE);
				}
				break;
			case TRUNCATE:
				{
				setState(582); match(TRUNCATE);
				}
				break;
			case UPDATE:
				{
				{
				setState(583); match(UPDATE);
				setState(593);
				_la = _input.LA(1);
				if (_la==OF) {
					{
					setState(584); match(OF);
					setState(589); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(585); ((Create_trigger_statementContext)_localctx).columnName = identifier();
						setState(587);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(586); match(COMMA);
							}
						}

						}
						}
						setState(591); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (ADMIN - 128)) | (1L << (AVG - 128)) | (1L << (BETWEEN - 128)) | (1L << (BY - 128)) | (1L << (CACHE - 128)) | (1L << (CALLED - 128)) | (1L << (CLASS - 128)) | (1L << (CENTURY - 128)) | (1L << (CHARACTER - 128)) | (1L << (CHECK - 128)) | (1L << (COLLECT - 128)) | (1L << (COALESCE - 128)) | (1L << (COLUMN - 128)) | (1L << (COMMENT - 128)) | (1L << (COMMENTS - 128)) | (1L << (COMMIT - 128)) | (1L << (CONFIGURATION - 128)) | (1L << (COST - 128)) | (1L << (COUNT - 128)) | (1L << (CUBE - 128)) | (1L << (CURRENT - 128)) | (1L << (CYCLE - 128)) | (1L << (DATA - 128)) | (1L << (DAY - 128)) | (1L << (DEC - 128)) | (1L << (DECADE - 128)) | (1L << (DEFINER - 128)) | (1L << (DICTIONARY - 128)) | (1L << (DOW - 128)) | (1L << (DOY - 128)) | (1L << (DROP - 128)) | (1L << (EPOCH - 128)) | (1L << (EVERY - 128)) | (1L << (EXISTS - 128)) | (1L << (EXTERNAL - 128)) | (1L << (EXTRACT - 128)) | (1L << (FAMILY - 128)) | (1L << (FILTER - 128)) | (1L << (FIRST - 128)) | (1L << (FORMAT - 128)) | (1L << (FUSION - 128)) | (1L << (GROUPING - 128)) | (1L << (HASH - 128)) | (1L << (INDEX - 128)) | (1L << (INCREMENT - 128)) | (1L << (INPUT - 128)) | (1L << (INSERT - 128)) | (1L << (INTERSECTION - 128)) | (1L << (ISCACHABLE - 128)) | (1L << (ISODOW - 128)) | (1L << (ISOYEAR - 128)) | (1L << (ISSTRICT - 128)) | (1L << (LANGUAGE - 128)) | (1L << (LARGE - 128)) | (1L << (LAST - 128)) | (1L << (LESS - 128)) | (1L << (LIST - 128)) | (1L << (LOCATION - 128)) | (1L << (MATCH - 128)) | (1L << (MAX - 128)) | (1L << (MAXVALUE - 128)) | (1L << (MICROSECONDS - 128)))) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (MILLENNIUM - 192)) | (1L << (MILLISECONDS - 192)) | (1L << (MIN - 192)) | (1L << (MINVALUE - 192)) | (1L << (MINUTE - 192)) | (1L << (MONTH - 192)) | (1L << (NATIONAL - 192)) | (1L << (NO - 192)) | (1L << (NONE - 192)) | (1L << (NULLIF - 192)) | (1L << (OBJECT - 192)) | (1L << (OPTION - 192)) | (1L << (OPTIONS - 192)) | (1L << (OVERWRITE - 192)) | (1L << (PARSER - 192)) | (1L << (PARTIAL - 192)) | (1L << (PARTITION - 192)) | (1L << (PARTITIONS - 192)) | (1L << (PRECISION - 192)) | (1L << (PUBLIC - 192)) | (1L << (PURGE - 192)) | (1L << (QUARTER - 192)) | (1L << (RANGE - 192)) | (1L << (REGEXP - 192)) | (1L << (RLIKE - 192)) | (1L << (ROLLUP - 192)) | (1L << (SEARCH - 192)) | (1L << (SECOND - 192)) | (1L << (SECURITY - 192)) | (1L << (SERVER - 192)) | (1L << (SET - 192)) | (1L << (SIMILAR - 192)) | (1L << (SIMPLE - 192)) | (1L << (STABLE - 192)) | (1L << (START - 192)) | (1L << (STORAGE - 192)) | (1L << (STDDEV_POP - 192)) | (1L << (STDDEV_SAMP - 192)) | (1L << (SUBPARTITION - 192)) | (1L << (SUM - 192)) | (1L << (TABLESPACE - 192)) | (1L << (TEMPLATE - 192)) | (1L << (THAN - 192)) | (1L << (TIMEZONE - 192)) | (1L << (TIMEZONE_HOUR - 192)) | (1L << (TIMEZONE_MINUTE - 192)) | (1L << (TRIM - 192)) | (1L << (TO - 192)) | (1L << (UNKNOWN - 192)) | (1L << (UNLOGGED - 192)) | (1L << (VALUES - 192)) | (1L << (VAR_SAMP - 192)) | (1L << (VAR_POP - 192)) | (1L << (VARYING - 192)) | (1L << (VOLATILE - 192)) | (1L << (WEEK - 192)) | (1L << (WINDOW - 192)) | (1L << (WRAPPER - 192)) | (1L << (YEAR - 192)) | (1L << (ZONE - 192)) | (1L << (BOOLEAN - 192)) | (1L << (BOOL - 192)))) != 0) || ((((_la - 256)) & ~0x3f) == 0 && ((1L << (_la - 256)) & ((1L << (BIT - 256)) | (1L << (VARBIT - 256)) | (1L << (INT1 - 256)) | (1L << (INT2 - 256)) | (1L << (INT4 - 256)) | (1L << (INT8 - 256)) | (1L << (TINYINT - 256)) | (1L << (SMALLINT - 256)) | (1L << (INT - 256)) | (1L << (INTEGER - 256)) | (1L << (BIGINT - 256)) | (1L << (FLOAT4 - 256)) | (1L << (FLOAT8 - 256)) | (1L << (REAL - 256)) | (1L << (FLOAT - 256)) | (1L << (DOUBLE - 256)) | (1L << (NUMERIC - 256)) | (1L << (DECIMAL - 256)) | (1L << (CHAR - 256)) | (1L << (VARCHAR - 256)) | (1L << (NCHAR - 256)) | (1L << (NVARCHAR - 256)) | (1L << (DATE - 256)) | (1L << (TIME - 256)) | (1L << (TIMETZ - 256)) | (1L << (TIMESTAMP - 256)) | (1L << (TIMESTAMPTZ - 256)) | (1L << (TEXT - 256)) | (1L << (VARBINARY - 256)) | (1L << (BLOB - 256)) | (1L << (BYTEA - 256)) | (1L << (INET4 - 256)) | (1L << (QUOTE - 256)))) != 0) || _la==Identifier );
					}
				}

				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(597); match(ON);
			setState(598); ((Create_trigger_statementContext)_localctx).tabl_name = schema_qualified_name();
			setState(601);
			_la = _input.LA(1);
			if (_la==FROM) {
				{
				setState(599); match(FROM);
				setState(600); ((Create_trigger_statementContext)_localctx).referenced_table_name = schema_qualified_name();
				}
			}

			setState(612);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				{
				setState(603); match(NOT);
				setState(604); match(DEFERRABLE);
				}
				break;
			case 2:
				{
				setState(606);
				_la = _input.LA(1);
				if (_la==DEFERRABLE) {
					{
					setState(605); match(DEFERRABLE);
					}
				}

				{
				setState(608); match(INITIALLY);
				setState(609); match(IMMEDIATE);
				}
				}
				break;
			case 3:
				{
				{
				setState(610); match(INITIALLY);
				setState(611); match(DEFERRED);
				}
				}
				break;
			}
			setState(620);
			switch (_input.LA(1)) {
			case FOR:
				{
				setState(614); match(FOR);
				setState(616);
				_la = _input.LA(1);
				if (_la==EACH) {
					{
					setState(615); match(EACH);
					}
				}

				setState(618); match(ROW);
				}
				break;
			case STATEMENT:
				{
				setState(619); match(STATEMENT);
				}
				break;
			case EXECUTE:
			case WHEN:
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(624);
			_la = _input.LA(1);
			if (_la==WHEN) {
				{
				setState(622); match(WHEN);
				{
				setState(623); boolean_value_expression();
				}
				}
			}

			setState(626); match(EXECUTE);
			setState(627); match(PROCEDURE);
			setState(628); ((Create_trigger_statementContext)_localctx).func_name = identifier();
			setState(629); match(LEFT_PAREN);
			setState(634);
			_la = _input.LA(1);
			if (((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (ADMIN - 128)) | (1L << (AVG - 128)) | (1L << (BETWEEN - 128)) | (1L << (BY - 128)) | (1L << (CACHE - 128)) | (1L << (CALLED - 128)) | (1L << (CLASS - 128)) | (1L << (CENTURY - 128)) | (1L << (CHARACTER - 128)) | (1L << (CHECK - 128)) | (1L << (COLLECT - 128)) | (1L << (COALESCE - 128)) | (1L << (COLUMN - 128)) | (1L << (COMMENT - 128)) | (1L << (COMMENTS - 128)) | (1L << (COMMIT - 128)) | (1L << (CONFIGURATION - 128)) | (1L << (COST - 128)) | (1L << (COUNT - 128)) | (1L << (CUBE - 128)) | (1L << (CURRENT - 128)) | (1L << (CYCLE - 128)) | (1L << (DATA - 128)) | (1L << (DAY - 128)) | (1L << (DEC - 128)) | (1L << (DECADE - 128)) | (1L << (DEFINER - 128)) | (1L << (DICTIONARY - 128)) | (1L << (DOW - 128)) | (1L << (DOY - 128)) | (1L << (DROP - 128)) | (1L << (EPOCH - 128)) | (1L << (EVERY - 128)) | (1L << (EXISTS - 128)) | (1L << (EXTERNAL - 128)) | (1L << (EXTRACT - 128)) | (1L << (FAMILY - 128)) | (1L << (FILTER - 128)) | (1L << (FIRST - 128)) | (1L << (FORMAT - 128)) | (1L << (FUSION - 128)) | (1L << (GROUPING - 128)) | (1L << (HASH - 128)) | (1L << (INDEX - 128)) | (1L << (INCREMENT - 128)) | (1L << (INPUT - 128)) | (1L << (INSERT - 128)) | (1L << (INTERSECTION - 128)) | (1L << (ISCACHABLE - 128)) | (1L << (ISODOW - 128)) | (1L << (ISOYEAR - 128)) | (1L << (ISSTRICT - 128)) | (1L << (LANGUAGE - 128)) | (1L << (LARGE - 128)) | (1L << (LAST - 128)) | (1L << (LESS - 128)) | (1L << (LIST - 128)) | (1L << (LOCATION - 128)) | (1L << (MATCH - 128)) | (1L << (MAX - 128)) | (1L << (MAXVALUE - 128)) | (1L << (MICROSECONDS - 128)))) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (MILLENNIUM - 192)) | (1L << (MILLISECONDS - 192)) | (1L << (MIN - 192)) | (1L << (MINVALUE - 192)) | (1L << (MINUTE - 192)) | (1L << (MONTH - 192)) | (1L << (NATIONAL - 192)) | (1L << (NO - 192)) | (1L << (NONE - 192)) | (1L << (NULLIF - 192)) | (1L << (OBJECT - 192)) | (1L << (OPTION - 192)) | (1L << (OPTIONS - 192)) | (1L << (OVERWRITE - 192)) | (1L << (PARSER - 192)) | (1L << (PARTIAL - 192)) | (1L << (PARTITION - 192)) | (1L << (PARTITIONS - 192)) | (1L << (PRECISION - 192)) | (1L << (PUBLIC - 192)) | (1L << (PURGE - 192)) | (1L << (QUARTER - 192)) | (1L << (RANGE - 192)) | (1L << (REGEXP - 192)) | (1L << (RLIKE - 192)) | (1L << (ROLLUP - 192)) | (1L << (SEARCH - 192)) | (1L << (SECOND - 192)) | (1L << (SECURITY - 192)) | (1L << (SERVER - 192)) | (1L << (SET - 192)) | (1L << (SIMILAR - 192)) | (1L << (SIMPLE - 192)) | (1L << (STABLE - 192)) | (1L << (START - 192)) | (1L << (STORAGE - 192)) | (1L << (STDDEV_POP - 192)) | (1L << (STDDEV_SAMP - 192)) | (1L << (SUBPARTITION - 192)) | (1L << (SUM - 192)) | (1L << (TABLESPACE - 192)) | (1L << (TEMPLATE - 192)) | (1L << (THAN - 192)) | (1L << (TIMEZONE - 192)) | (1L << (TIMEZONE_HOUR - 192)) | (1L << (TIMEZONE_MINUTE - 192)) | (1L << (TRIM - 192)) | (1L << (TO - 192)) | (1L << (UNKNOWN - 192)) | (1L << (UNLOGGED - 192)) | (1L << (VALUES - 192)) | (1L << (VAR_SAMP - 192)) | (1L << (VAR_POP - 192)) | (1L << (VARYING - 192)) | (1L << (VOLATILE - 192)) | (1L << (WEEK - 192)) | (1L << (WINDOW - 192)) | (1L << (WRAPPER - 192)) | (1L << (YEAR - 192)) | (1L << (ZONE - 192)) | (1L << (BOOLEAN - 192)) | (1L << (BOOL - 192)))) != 0) || ((((_la - 256)) & ~0x3f) == 0 && ((1L << (_la - 256)) & ((1L << (BIT - 256)) | (1L << (VARBIT - 256)) | (1L << (INT1 - 256)) | (1L << (INT2 - 256)) | (1L << (INT4 - 256)) | (1L << (INT8 - 256)) | (1L << (TINYINT - 256)) | (1L << (SMALLINT - 256)) | (1L << (INT - 256)) | (1L << (INTEGER - 256)) | (1L << (BIGINT - 256)) | (1L << (FLOAT4 - 256)) | (1L << (FLOAT8 - 256)) | (1L << (REAL - 256)) | (1L << (FLOAT - 256)) | (1L << (DOUBLE - 256)) | (1L << (NUMERIC - 256)) | (1L << (DECIMAL - 256)) | (1L << (CHAR - 256)) | (1L << (VARCHAR - 256)) | (1L << (NCHAR - 256)) | (1L << (NVARCHAR - 256)) | (1L << (DATE - 256)) | (1L << (TIME - 256)) | (1L << (TIMETZ - 256)) | (1L << (TIMESTAMP - 256)) | (1L << (TIMESTAMPTZ - 256)) | (1L << (TEXT - 256)) | (1L << (VARBINARY - 256)) | (1L << (BLOB - 256)) | (1L << (BYTEA - 256)) | (1L << (INET4 - 256)) | (1L << (QUOTE - 256)))) != 0) || _la==Identifier) {
				{
				setState(630); ((Create_trigger_statementContext)_localctx).arguments = identifier();
				setState(632);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(631); match(COMMA);
					}
				}

				}
			}

			setState(636); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
			setState(1017);
			switch ( getInterpreter().adaptivePredict(_input,114,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(638); match(REVOKE);
				setState(642);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(639); match(GRANT);
					setState(640); match(OPTION);
					setState(641); match(FOR);
					}
				}

				setState(653);
				switch (_input.LA(1)) {
				case DELETE:
				case REFERENCES:
				case SELECT:
				case TRIGGER:
				case TRUNCATE:
				case UPDATE:
				case INSERT:
					{
					setState(645); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(644);
						_la = _input.LA(1);
						if ( !(_la==DELETE || ((((_la - 92)) & ~0x3f) == 0 && ((1L << (_la - 92)) & ((1L << (REFERENCES - 92)) | (1L << (SELECT - 92)) | (1L << (TRIGGER - 92)) | (1L << (TRUNCATE - 92)) | (1L << (UPDATE - 92)))) != 0) || _la==INSERT) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
						}
						setState(647); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==DELETE || ((((_la - 92)) & ~0x3f) == 0 && ((1L << (_la - 92)) & ((1L << (REFERENCES - 92)) | (1L << (SELECT - 92)) | (1L << (TRIGGER - 92)) | (1L << (TRUNCATE - 92)) | (1L << (UPDATE - 92)))) != 0) || _la==INSERT );
					}
					break;
				case ALL:
					{
					setState(649); match(ALL);
					setState(651);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(650); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(655); match(ON);
				setState(673);
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
					setState(660); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(657);
						_la = _input.LA(1);
						if (_la==TABLE) {
							{
							setState(656); match(TABLE);
							}
						}

						setState(659); ((Revoke_statementContext)_localctx).table_name = schema_qualified_name();
						}
						}
						setState(662); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 108)) & ~0x3f) == 0 && ((1L << (_la - 108)) & ((1L << (TABLE - 108)) | (1L << (ADMIN - 108)) | (1L << (AVG - 108)) | (1L << (BETWEEN - 108)) | (1L << (BY - 108)) | (1L << (CACHE - 108)) | (1L << (CALLED - 108)) | (1L << (CLASS - 108)) | (1L << (CENTURY - 108)) | (1L << (CHARACTER - 108)) | (1L << (CHECK - 108)) | (1L << (COLLECT - 108)) | (1L << (COALESCE - 108)) | (1L << (COLUMN - 108)) | (1L << (COMMENT - 108)) | (1L << (COMMENTS - 108)) | (1L << (COMMIT - 108)) | (1L << (CONFIGURATION - 108)) | (1L << (COST - 108)) | (1L << (COUNT - 108)) | (1L << (CUBE - 108)) | (1L << (CURRENT - 108)) | (1L << (CYCLE - 108)) | (1L << (DATA - 108)) | (1L << (DAY - 108)) | (1L << (DEC - 108)) | (1L << (DECADE - 108)) | (1L << (DEFINER - 108)) | (1L << (DICTIONARY - 108)) | (1L << (DOW - 108)) | (1L << (DOY - 108)) | (1L << (DROP - 108)) | (1L << (EPOCH - 108)) | (1L << (EVERY - 108)) | (1L << (EXISTS - 108)) | (1L << (EXTERNAL - 108)) | (1L << (EXTRACT - 108)) | (1L << (FAMILY - 108)) | (1L << (FILTER - 108)) | (1L << (FIRST - 108)) | (1L << (FORMAT - 108)) | (1L << (FUSION - 108)) | (1L << (GROUPING - 108)) | (1L << (HASH - 108)))) != 0) || ((((_la - 172)) & ~0x3f) == 0 && ((1L << (_la - 172)) & ((1L << (INDEX - 172)) | (1L << (INCREMENT - 172)) | (1L << (INPUT - 172)) | (1L << (INSERT - 172)) | (1L << (INTERSECTION - 172)) | (1L << (ISCACHABLE - 172)) | (1L << (ISODOW - 172)) | (1L << (ISOYEAR - 172)) | (1L << (ISSTRICT - 172)) | (1L << (LANGUAGE - 172)) | (1L << (LARGE - 172)) | (1L << (LAST - 172)) | (1L << (LESS - 172)) | (1L << (LIST - 172)) | (1L << (LOCATION - 172)) | (1L << (MATCH - 172)) | (1L << (MAX - 172)) | (1L << (MAXVALUE - 172)) | (1L << (MICROSECONDS - 172)) | (1L << (MILLENNIUM - 172)) | (1L << (MILLISECONDS - 172)) | (1L << (MIN - 172)) | (1L << (MINVALUE - 172)) | (1L << (MINUTE - 172)) | (1L << (MONTH - 172)) | (1L << (NATIONAL - 172)) | (1L << (NO - 172)) | (1L << (NONE - 172)) | (1L << (NULLIF - 172)) | (1L << (OBJECT - 172)) | (1L << (OPTION - 172)) | (1L << (OPTIONS - 172)) | (1L << (OVERWRITE - 172)) | (1L << (PARSER - 172)) | (1L << (PARTIAL - 172)) | (1L << (PARTITION - 172)) | (1L << (PARTITIONS - 172)) | (1L << (PRECISION - 172)) | (1L << (PUBLIC - 172)) | (1L << (PURGE - 172)) | (1L << (QUARTER - 172)) | (1L << (RANGE - 172)) | (1L << (REGEXP - 172)) | (1L << (RLIKE - 172)) | (1L << (ROLLUP - 172)) | (1L << (SEARCH - 172)) | (1L << (SECOND - 172)) | (1L << (SECURITY - 172)) | (1L << (SERVER - 172)) | (1L << (SET - 172)) | (1L << (SIMILAR - 172)) | (1L << (SIMPLE - 172)) | (1L << (STABLE - 172)) | (1L << (START - 172)) | (1L << (STORAGE - 172)) | (1L << (STDDEV_POP - 172)) | (1L << (STDDEV_SAMP - 172)) | (1L << (SUBPARTITION - 172)) | (1L << (SUM - 172)) | (1L << (TABLESPACE - 172)) | (1L << (TEMPLATE - 172)) | (1L << (THAN - 172)))) != 0) || ((((_la - 236)) & ~0x3f) == 0 && ((1L << (_la - 236)) & ((1L << (TIMEZONE - 236)) | (1L << (TIMEZONE_HOUR - 236)) | (1L << (TIMEZONE_MINUTE - 236)) | (1L << (TRIM - 236)) | (1L << (TO - 236)) | (1L << (UNKNOWN - 236)) | (1L << (UNLOGGED - 236)) | (1L << (VALUES - 236)) | (1L << (VAR_SAMP - 236)) | (1L << (VAR_POP - 236)) | (1L << (VARYING - 236)) | (1L << (VOLATILE - 236)) | (1L << (WEEK - 236)) | (1L << (WINDOW - 236)) | (1L << (WRAPPER - 236)) | (1L << (YEAR - 236)) | (1L << (ZONE - 236)) | (1L << (BOOLEAN - 236)) | (1L << (BOOL - 236)) | (1L << (BIT - 236)) | (1L << (VARBIT - 236)) | (1L << (INT1 - 236)) | (1L << (INT2 - 236)) | (1L << (INT4 - 236)) | (1L << (INT8 - 236)) | (1L << (TINYINT - 236)) | (1L << (SMALLINT - 236)) | (1L << (INT - 236)) | (1L << (INTEGER - 236)) | (1L << (BIGINT - 236)) | (1L << (FLOAT4 - 236)) | (1L << (FLOAT8 - 236)) | (1L << (REAL - 236)) | (1L << (FLOAT - 236)) | (1L << (DOUBLE - 236)) | (1L << (NUMERIC - 236)) | (1L << (DECIMAL - 236)) | (1L << (CHAR - 236)) | (1L << (VARCHAR - 236)) | (1L << (NCHAR - 236)) | (1L << (NVARCHAR - 236)) | (1L << (DATE - 236)) | (1L << (TIME - 236)) | (1L << (TIMETZ - 236)) | (1L << (TIMESTAMP - 236)) | (1L << (TIMESTAMPTZ - 236)) | (1L << (TEXT - 236)) | (1L << (VARBINARY - 236)) | (1L << (BLOB - 236)) | (1L << (BYTEA - 236)) | (1L << (INET4 - 236)))) != 0) || _la==QUOTE || _la==Identifier );
					}
					break;
				case ALL:
					{
					setState(664); match(ALL);
					setState(665); match(TABLES);
					setState(666); match(IN);
					setState(667); match(SCHEMA);
					setState(669); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(668); ((Revoke_statementContext)_localctx).schema_name = identifier();
						}
						}
						setState(671); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (ADMIN - 128)) | (1L << (AVG - 128)) | (1L << (BETWEEN - 128)) | (1L << (BY - 128)) | (1L << (CACHE - 128)) | (1L << (CALLED - 128)) | (1L << (CLASS - 128)) | (1L << (CENTURY - 128)) | (1L << (CHARACTER - 128)) | (1L << (CHECK - 128)) | (1L << (COLLECT - 128)) | (1L << (COALESCE - 128)) | (1L << (COLUMN - 128)) | (1L << (COMMENT - 128)) | (1L << (COMMENTS - 128)) | (1L << (COMMIT - 128)) | (1L << (CONFIGURATION - 128)) | (1L << (COST - 128)) | (1L << (COUNT - 128)) | (1L << (CUBE - 128)) | (1L << (CURRENT - 128)) | (1L << (CYCLE - 128)) | (1L << (DATA - 128)) | (1L << (DAY - 128)) | (1L << (DEC - 128)) | (1L << (DECADE - 128)) | (1L << (DEFINER - 128)) | (1L << (DICTIONARY - 128)) | (1L << (DOW - 128)) | (1L << (DOY - 128)) | (1L << (DROP - 128)) | (1L << (EPOCH - 128)) | (1L << (EVERY - 128)) | (1L << (EXISTS - 128)) | (1L << (EXTERNAL - 128)) | (1L << (EXTRACT - 128)) | (1L << (FAMILY - 128)) | (1L << (FILTER - 128)) | (1L << (FIRST - 128)) | (1L << (FORMAT - 128)) | (1L << (FUSION - 128)) | (1L << (GROUPING - 128)) | (1L << (HASH - 128)) | (1L << (INDEX - 128)) | (1L << (INCREMENT - 128)) | (1L << (INPUT - 128)) | (1L << (INSERT - 128)) | (1L << (INTERSECTION - 128)) | (1L << (ISCACHABLE - 128)) | (1L << (ISODOW - 128)) | (1L << (ISOYEAR - 128)) | (1L << (ISSTRICT - 128)) | (1L << (LANGUAGE - 128)) | (1L << (LARGE - 128)) | (1L << (LAST - 128)) | (1L << (LESS - 128)) | (1L << (LIST - 128)) | (1L << (LOCATION - 128)) | (1L << (MATCH - 128)) | (1L << (MAX - 128)) | (1L << (MAXVALUE - 128)) | (1L << (MICROSECONDS - 128)))) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (MILLENNIUM - 192)) | (1L << (MILLISECONDS - 192)) | (1L << (MIN - 192)) | (1L << (MINVALUE - 192)) | (1L << (MINUTE - 192)) | (1L << (MONTH - 192)) | (1L << (NATIONAL - 192)) | (1L << (NO - 192)) | (1L << (NONE - 192)) | (1L << (NULLIF - 192)) | (1L << (OBJECT - 192)) | (1L << (OPTION - 192)) | (1L << (OPTIONS - 192)) | (1L << (OVERWRITE - 192)) | (1L << (PARSER - 192)) | (1L << (PARTIAL - 192)) | (1L << (PARTITION - 192)) | (1L << (PARTITIONS - 192)) | (1L << (PRECISION - 192)) | (1L << (PUBLIC - 192)) | (1L << (PURGE - 192)) | (1L << (QUARTER - 192)) | (1L << (RANGE - 192)) | (1L << (REGEXP - 192)) | (1L << (RLIKE - 192)) | (1L << (ROLLUP - 192)) | (1L << (SEARCH - 192)) | (1L << (SECOND - 192)) | (1L << (SECURITY - 192)) | (1L << (SERVER - 192)) | (1L << (SET - 192)) | (1L << (SIMILAR - 192)) | (1L << (SIMPLE - 192)) | (1L << (STABLE - 192)) | (1L << (START - 192)) | (1L << (STORAGE - 192)) | (1L << (STDDEV_POP - 192)) | (1L << (STDDEV_SAMP - 192)) | (1L << (SUBPARTITION - 192)) | (1L << (SUM - 192)) | (1L << (TABLESPACE - 192)) | (1L << (TEMPLATE - 192)) | (1L << (THAN - 192)) | (1L << (TIMEZONE - 192)) | (1L << (TIMEZONE_HOUR - 192)) | (1L << (TIMEZONE_MINUTE - 192)) | (1L << (TRIM - 192)) | (1L << (TO - 192)) | (1L << (UNKNOWN - 192)) | (1L << (UNLOGGED - 192)) | (1L << (VALUES - 192)) | (1L << (VAR_SAMP - 192)) | (1L << (VAR_POP - 192)) | (1L << (VARYING - 192)) | (1L << (VOLATILE - 192)) | (1L << (WEEK - 192)) | (1L << (WINDOW - 192)) | (1L << (WRAPPER - 192)) | (1L << (YEAR - 192)) | (1L << (ZONE - 192)) | (1L << (BOOLEAN - 192)) | (1L << (BOOL - 192)))) != 0) || ((((_la - 256)) & ~0x3f) == 0 && ((1L << (_la - 256)) & ((1L << (BIT - 256)) | (1L << (VARBIT - 256)) | (1L << (INT1 - 256)) | (1L << (INT2 - 256)) | (1L << (INT4 - 256)) | (1L << (INT8 - 256)) | (1L << (TINYINT - 256)) | (1L << (SMALLINT - 256)) | (1L << (INT - 256)) | (1L << (INTEGER - 256)) | (1L << (BIGINT - 256)) | (1L << (FLOAT4 - 256)) | (1L << (FLOAT8 - 256)) | (1L << (REAL - 256)) | (1L << (FLOAT - 256)) | (1L << (DOUBLE - 256)) | (1L << (NUMERIC - 256)) | (1L << (DECIMAL - 256)) | (1L << (CHAR - 256)) | (1L << (VARCHAR - 256)) | (1L << (NCHAR - 256)) | (1L << (NVARCHAR - 256)) | (1L << (DATE - 256)) | (1L << (TIME - 256)) | (1L << (TIMETZ - 256)) | (1L << (TIMESTAMP - 256)) | (1L << (TIMESTAMPTZ - 256)) | (1L << (TEXT - 256)) | (1L << (VARBINARY - 256)) | (1L << (BLOB - 256)) | (1L << (BYTEA - 256)) | (1L << (INET4 - 256)) | (1L << (QUOTE - 256)))) != 0) || _la==Identifier );
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(675); revoke_from_cascade_restrict();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(677); match(REVOKE);
				setState(681);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(678); match(GRANT);
					setState(679); match(OPTION);
					setState(680); match(FOR);
					}
				}

				setState(714);
				switch (_input.LA(1)) {
				case REFERENCES:
				case SELECT:
				case UPDATE:
				case INSERT:
					{
					setState(695); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(683);
						_la = _input.LA(1);
						if ( !(((((_la - 92)) & ~0x3f) == 0 && ((1L << (_la - 92)) & ((1L << (REFERENCES - 92)) | (1L << (SELECT - 92)) | (1L << (UPDATE - 92)))) != 0) || _la==INSERT) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(684); match(LEFT_PAREN);
						setState(689); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(685); ((Revoke_statementContext)_localctx).column = identifier();
							setState(687);
							_la = _input.LA(1);
							if (_la==COMMA) {
								{
								setState(686); match(COMMA);
								}
							}

							}
							}
							setState(691); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (ADMIN - 128)) | (1L << (AVG - 128)) | (1L << (BETWEEN - 128)) | (1L << (BY - 128)) | (1L << (CACHE - 128)) | (1L << (CALLED - 128)) | (1L << (CLASS - 128)) | (1L << (CENTURY - 128)) | (1L << (CHARACTER - 128)) | (1L << (CHECK - 128)) | (1L << (COLLECT - 128)) | (1L << (COALESCE - 128)) | (1L << (COLUMN - 128)) | (1L << (COMMENT - 128)) | (1L << (COMMENTS - 128)) | (1L << (COMMIT - 128)) | (1L << (CONFIGURATION - 128)) | (1L << (COST - 128)) | (1L << (COUNT - 128)) | (1L << (CUBE - 128)) | (1L << (CURRENT - 128)) | (1L << (CYCLE - 128)) | (1L << (DATA - 128)) | (1L << (DAY - 128)) | (1L << (DEC - 128)) | (1L << (DECADE - 128)) | (1L << (DEFINER - 128)) | (1L << (DICTIONARY - 128)) | (1L << (DOW - 128)) | (1L << (DOY - 128)) | (1L << (DROP - 128)) | (1L << (EPOCH - 128)) | (1L << (EVERY - 128)) | (1L << (EXISTS - 128)) | (1L << (EXTERNAL - 128)) | (1L << (EXTRACT - 128)) | (1L << (FAMILY - 128)) | (1L << (FILTER - 128)) | (1L << (FIRST - 128)) | (1L << (FORMAT - 128)) | (1L << (FUSION - 128)) | (1L << (GROUPING - 128)) | (1L << (HASH - 128)) | (1L << (INDEX - 128)) | (1L << (INCREMENT - 128)) | (1L << (INPUT - 128)) | (1L << (INSERT - 128)) | (1L << (INTERSECTION - 128)) | (1L << (ISCACHABLE - 128)) | (1L << (ISODOW - 128)) | (1L << (ISOYEAR - 128)) | (1L << (ISSTRICT - 128)) | (1L << (LANGUAGE - 128)) | (1L << (LARGE - 128)) | (1L << (LAST - 128)) | (1L << (LESS - 128)) | (1L << (LIST - 128)) | (1L << (LOCATION - 128)) | (1L << (MATCH - 128)) | (1L << (MAX - 128)) | (1L << (MAXVALUE - 128)) | (1L << (MICROSECONDS - 128)))) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (MILLENNIUM - 192)) | (1L << (MILLISECONDS - 192)) | (1L << (MIN - 192)) | (1L << (MINVALUE - 192)) | (1L << (MINUTE - 192)) | (1L << (MONTH - 192)) | (1L << (NATIONAL - 192)) | (1L << (NO - 192)) | (1L << (NONE - 192)) | (1L << (NULLIF - 192)) | (1L << (OBJECT - 192)) | (1L << (OPTION - 192)) | (1L << (OPTIONS - 192)) | (1L << (OVERWRITE - 192)) | (1L << (PARSER - 192)) | (1L << (PARTIAL - 192)) | (1L << (PARTITION - 192)) | (1L << (PARTITIONS - 192)) | (1L << (PRECISION - 192)) | (1L << (PUBLIC - 192)) | (1L << (PURGE - 192)) | (1L << (QUARTER - 192)) | (1L << (RANGE - 192)) | (1L << (REGEXP - 192)) | (1L << (RLIKE - 192)) | (1L << (ROLLUP - 192)) | (1L << (SEARCH - 192)) | (1L << (SECOND - 192)) | (1L << (SECURITY - 192)) | (1L << (SERVER - 192)) | (1L << (SET - 192)) | (1L << (SIMILAR - 192)) | (1L << (SIMPLE - 192)) | (1L << (STABLE - 192)) | (1L << (START - 192)) | (1L << (STORAGE - 192)) | (1L << (STDDEV_POP - 192)) | (1L << (STDDEV_SAMP - 192)) | (1L << (SUBPARTITION - 192)) | (1L << (SUM - 192)) | (1L << (TABLESPACE - 192)) | (1L << (TEMPLATE - 192)) | (1L << (THAN - 192)) | (1L << (TIMEZONE - 192)) | (1L << (TIMEZONE_HOUR - 192)) | (1L << (TIMEZONE_MINUTE - 192)) | (1L << (TRIM - 192)) | (1L << (TO - 192)) | (1L << (UNKNOWN - 192)) | (1L << (UNLOGGED - 192)) | (1L << (VALUES - 192)) | (1L << (VAR_SAMP - 192)) | (1L << (VAR_POP - 192)) | (1L << (VARYING - 192)) | (1L << (VOLATILE - 192)) | (1L << (WEEK - 192)) | (1L << (WINDOW - 192)) | (1L << (WRAPPER - 192)) | (1L << (YEAR - 192)) | (1L << (ZONE - 192)) | (1L << (BOOLEAN - 192)) | (1L << (BOOL - 192)))) != 0) || ((((_la - 256)) & ~0x3f) == 0 && ((1L << (_la - 256)) & ((1L << (BIT - 256)) | (1L << (VARBIT - 256)) | (1L << (INT1 - 256)) | (1L << (INT2 - 256)) | (1L << (INT4 - 256)) | (1L << (INT8 - 256)) | (1L << (TINYINT - 256)) | (1L << (SMALLINT - 256)) | (1L << (INT - 256)) | (1L << (INTEGER - 256)) | (1L << (BIGINT - 256)) | (1L << (FLOAT4 - 256)) | (1L << (FLOAT8 - 256)) | (1L << (REAL - 256)) | (1L << (FLOAT - 256)) | (1L << (DOUBLE - 256)) | (1L << (NUMERIC - 256)) | (1L << (DECIMAL - 256)) | (1L << (CHAR - 256)) | (1L << (VARCHAR - 256)) | (1L << (NCHAR - 256)) | (1L << (NVARCHAR - 256)) | (1L << (DATE - 256)) | (1L << (TIME - 256)) | (1L << (TIMETZ - 256)) | (1L << (TIMESTAMP - 256)) | (1L << (TIMESTAMPTZ - 256)) | (1L << (TEXT - 256)) | (1L << (VARBINARY - 256)) | (1L << (BLOB - 256)) | (1L << (BYTEA - 256)) | (1L << (INET4 - 256)) | (1L << (QUOTE - 256)))) != 0) || _la==Identifier );
						setState(693); match(RIGHT_PAREN);
						}
						}
						setState(697); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 92)) & ~0x3f) == 0 && ((1L << (_la - 92)) & ((1L << (REFERENCES - 92)) | (1L << (SELECT - 92)) | (1L << (UPDATE - 92)))) != 0) || _la==INSERT );
					}
					break;
				case ALL:
					{
					setState(699); match(ALL);
					setState(701);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(700); match(PRIVILEGES);
						}
					}

					setState(703); match(LEFT_PAREN);
					setState(708); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(704); ((Revoke_statementContext)_localctx).column = identifier();
						setState(706);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(705); match(COMMA);
							}
						}

						}
						}
						setState(710); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (ADMIN - 128)) | (1L << (AVG - 128)) | (1L << (BETWEEN - 128)) | (1L << (BY - 128)) | (1L << (CACHE - 128)) | (1L << (CALLED - 128)) | (1L << (CLASS - 128)) | (1L << (CENTURY - 128)) | (1L << (CHARACTER - 128)) | (1L << (CHECK - 128)) | (1L << (COLLECT - 128)) | (1L << (COALESCE - 128)) | (1L << (COLUMN - 128)) | (1L << (COMMENT - 128)) | (1L << (COMMENTS - 128)) | (1L << (COMMIT - 128)) | (1L << (CONFIGURATION - 128)) | (1L << (COST - 128)) | (1L << (COUNT - 128)) | (1L << (CUBE - 128)) | (1L << (CURRENT - 128)) | (1L << (CYCLE - 128)) | (1L << (DATA - 128)) | (1L << (DAY - 128)) | (1L << (DEC - 128)) | (1L << (DECADE - 128)) | (1L << (DEFINER - 128)) | (1L << (DICTIONARY - 128)) | (1L << (DOW - 128)) | (1L << (DOY - 128)) | (1L << (DROP - 128)) | (1L << (EPOCH - 128)) | (1L << (EVERY - 128)) | (1L << (EXISTS - 128)) | (1L << (EXTERNAL - 128)) | (1L << (EXTRACT - 128)) | (1L << (FAMILY - 128)) | (1L << (FILTER - 128)) | (1L << (FIRST - 128)) | (1L << (FORMAT - 128)) | (1L << (FUSION - 128)) | (1L << (GROUPING - 128)) | (1L << (HASH - 128)) | (1L << (INDEX - 128)) | (1L << (INCREMENT - 128)) | (1L << (INPUT - 128)) | (1L << (INSERT - 128)) | (1L << (INTERSECTION - 128)) | (1L << (ISCACHABLE - 128)) | (1L << (ISODOW - 128)) | (1L << (ISOYEAR - 128)) | (1L << (ISSTRICT - 128)) | (1L << (LANGUAGE - 128)) | (1L << (LARGE - 128)) | (1L << (LAST - 128)) | (1L << (LESS - 128)) | (1L << (LIST - 128)) | (1L << (LOCATION - 128)) | (1L << (MATCH - 128)) | (1L << (MAX - 128)) | (1L << (MAXVALUE - 128)) | (1L << (MICROSECONDS - 128)))) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (MILLENNIUM - 192)) | (1L << (MILLISECONDS - 192)) | (1L << (MIN - 192)) | (1L << (MINVALUE - 192)) | (1L << (MINUTE - 192)) | (1L << (MONTH - 192)) | (1L << (NATIONAL - 192)) | (1L << (NO - 192)) | (1L << (NONE - 192)) | (1L << (NULLIF - 192)) | (1L << (OBJECT - 192)) | (1L << (OPTION - 192)) | (1L << (OPTIONS - 192)) | (1L << (OVERWRITE - 192)) | (1L << (PARSER - 192)) | (1L << (PARTIAL - 192)) | (1L << (PARTITION - 192)) | (1L << (PARTITIONS - 192)) | (1L << (PRECISION - 192)) | (1L << (PUBLIC - 192)) | (1L << (PURGE - 192)) | (1L << (QUARTER - 192)) | (1L << (RANGE - 192)) | (1L << (REGEXP - 192)) | (1L << (RLIKE - 192)) | (1L << (ROLLUP - 192)) | (1L << (SEARCH - 192)) | (1L << (SECOND - 192)) | (1L << (SECURITY - 192)) | (1L << (SERVER - 192)) | (1L << (SET - 192)) | (1L << (SIMILAR - 192)) | (1L << (SIMPLE - 192)) | (1L << (STABLE - 192)) | (1L << (START - 192)) | (1L << (STORAGE - 192)) | (1L << (STDDEV_POP - 192)) | (1L << (STDDEV_SAMP - 192)) | (1L << (SUBPARTITION - 192)) | (1L << (SUM - 192)) | (1L << (TABLESPACE - 192)) | (1L << (TEMPLATE - 192)) | (1L << (THAN - 192)) | (1L << (TIMEZONE - 192)) | (1L << (TIMEZONE_HOUR - 192)) | (1L << (TIMEZONE_MINUTE - 192)) | (1L << (TRIM - 192)) | (1L << (TO - 192)) | (1L << (UNKNOWN - 192)) | (1L << (UNLOGGED - 192)) | (1L << (VALUES - 192)) | (1L << (VAR_SAMP - 192)) | (1L << (VAR_POP - 192)) | (1L << (VARYING - 192)) | (1L << (VOLATILE - 192)) | (1L << (WEEK - 192)) | (1L << (WINDOW - 192)) | (1L << (WRAPPER - 192)) | (1L << (YEAR - 192)) | (1L << (ZONE - 192)) | (1L << (BOOLEAN - 192)) | (1L << (BOOL - 192)))) != 0) || ((((_la - 256)) & ~0x3f) == 0 && ((1L << (_la - 256)) & ((1L << (BIT - 256)) | (1L << (VARBIT - 256)) | (1L << (INT1 - 256)) | (1L << (INT2 - 256)) | (1L << (INT4 - 256)) | (1L << (INT8 - 256)) | (1L << (TINYINT - 256)) | (1L << (SMALLINT - 256)) | (1L << (INT - 256)) | (1L << (INTEGER - 256)) | (1L << (BIGINT - 256)) | (1L << (FLOAT4 - 256)) | (1L << (FLOAT8 - 256)) | (1L << (REAL - 256)) | (1L << (FLOAT - 256)) | (1L << (DOUBLE - 256)) | (1L << (NUMERIC - 256)) | (1L << (DECIMAL - 256)) | (1L << (CHAR - 256)) | (1L << (VARCHAR - 256)) | (1L << (NCHAR - 256)) | (1L << (NVARCHAR - 256)) | (1L << (DATE - 256)) | (1L << (TIME - 256)) | (1L << (TIMETZ - 256)) | (1L << (TIMESTAMP - 256)) | (1L << (TIMESTAMPTZ - 256)) | (1L << (TEXT - 256)) | (1L << (VARBINARY - 256)) | (1L << (BLOB - 256)) | (1L << (BYTEA - 256)) | (1L << (INET4 - 256)) | (1L << (QUOTE - 256)))) != 0) || _la==Identifier );
					setState(712); match(RIGHT_PAREN);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(716); match(ON);
				setState(718);
				_la = _input.LA(1);
				if (_la==TABLE) {
					{
					setState(717); match(TABLE);
					}
				}

				setState(724); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(720); ((Revoke_statementContext)_localctx).table_name = schema_qualified_name();
					setState(722);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(721); match(COMMA);
						}
					}

					}
					}
					setState(726); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (ADMIN - 128)) | (1L << (AVG - 128)) | (1L << (BETWEEN - 128)) | (1L << (BY - 128)) | (1L << (CACHE - 128)) | (1L << (CALLED - 128)) | (1L << (CLASS - 128)) | (1L << (CENTURY - 128)) | (1L << (CHARACTER - 128)) | (1L << (CHECK - 128)) | (1L << (COLLECT - 128)) | (1L << (COALESCE - 128)) | (1L << (COLUMN - 128)) | (1L << (COMMENT - 128)) | (1L << (COMMENTS - 128)) | (1L << (COMMIT - 128)) | (1L << (CONFIGURATION - 128)) | (1L << (COST - 128)) | (1L << (COUNT - 128)) | (1L << (CUBE - 128)) | (1L << (CURRENT - 128)) | (1L << (CYCLE - 128)) | (1L << (DATA - 128)) | (1L << (DAY - 128)) | (1L << (DEC - 128)) | (1L << (DECADE - 128)) | (1L << (DEFINER - 128)) | (1L << (DICTIONARY - 128)) | (1L << (DOW - 128)) | (1L << (DOY - 128)) | (1L << (DROP - 128)) | (1L << (EPOCH - 128)) | (1L << (EVERY - 128)) | (1L << (EXISTS - 128)) | (1L << (EXTERNAL - 128)) | (1L << (EXTRACT - 128)) | (1L << (FAMILY - 128)) | (1L << (FILTER - 128)) | (1L << (FIRST - 128)) | (1L << (FORMAT - 128)) | (1L << (FUSION - 128)) | (1L << (GROUPING - 128)) | (1L << (HASH - 128)) | (1L << (INDEX - 128)) | (1L << (INCREMENT - 128)) | (1L << (INPUT - 128)) | (1L << (INSERT - 128)) | (1L << (INTERSECTION - 128)) | (1L << (ISCACHABLE - 128)) | (1L << (ISODOW - 128)) | (1L << (ISOYEAR - 128)) | (1L << (ISSTRICT - 128)) | (1L << (LANGUAGE - 128)) | (1L << (LARGE - 128)) | (1L << (LAST - 128)) | (1L << (LESS - 128)) | (1L << (LIST - 128)) | (1L << (LOCATION - 128)) | (1L << (MATCH - 128)) | (1L << (MAX - 128)) | (1L << (MAXVALUE - 128)) | (1L << (MICROSECONDS - 128)))) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (MILLENNIUM - 192)) | (1L << (MILLISECONDS - 192)) | (1L << (MIN - 192)) | (1L << (MINVALUE - 192)) | (1L << (MINUTE - 192)) | (1L << (MONTH - 192)) | (1L << (NATIONAL - 192)) | (1L << (NO - 192)) | (1L << (NONE - 192)) | (1L << (NULLIF - 192)) | (1L << (OBJECT - 192)) | (1L << (OPTION - 192)) | (1L << (OPTIONS - 192)) | (1L << (OVERWRITE - 192)) | (1L << (PARSER - 192)) | (1L << (PARTIAL - 192)) | (1L << (PARTITION - 192)) | (1L << (PARTITIONS - 192)) | (1L << (PRECISION - 192)) | (1L << (PUBLIC - 192)) | (1L << (PURGE - 192)) | (1L << (QUARTER - 192)) | (1L << (RANGE - 192)) | (1L << (REGEXP - 192)) | (1L << (RLIKE - 192)) | (1L << (ROLLUP - 192)) | (1L << (SEARCH - 192)) | (1L << (SECOND - 192)) | (1L << (SECURITY - 192)) | (1L << (SERVER - 192)) | (1L << (SET - 192)) | (1L << (SIMILAR - 192)) | (1L << (SIMPLE - 192)) | (1L << (STABLE - 192)) | (1L << (START - 192)) | (1L << (STORAGE - 192)) | (1L << (STDDEV_POP - 192)) | (1L << (STDDEV_SAMP - 192)) | (1L << (SUBPARTITION - 192)) | (1L << (SUM - 192)) | (1L << (TABLESPACE - 192)) | (1L << (TEMPLATE - 192)) | (1L << (THAN - 192)) | (1L << (TIMEZONE - 192)) | (1L << (TIMEZONE_HOUR - 192)) | (1L << (TIMEZONE_MINUTE - 192)) | (1L << (TRIM - 192)) | (1L << (TO - 192)) | (1L << (UNKNOWN - 192)) | (1L << (UNLOGGED - 192)) | (1L << (VALUES - 192)) | (1L << (VAR_SAMP - 192)) | (1L << (VAR_POP - 192)) | (1L << (VARYING - 192)) | (1L << (VOLATILE - 192)) | (1L << (WEEK - 192)) | (1L << (WINDOW - 192)) | (1L << (WRAPPER - 192)) | (1L << (YEAR - 192)) | (1L << (ZONE - 192)) | (1L << (BOOLEAN - 192)) | (1L << (BOOL - 192)))) != 0) || ((((_la - 256)) & ~0x3f) == 0 && ((1L << (_la - 256)) & ((1L << (BIT - 256)) | (1L << (VARBIT - 256)) | (1L << (INT1 - 256)) | (1L << (INT2 - 256)) | (1L << (INT4 - 256)) | (1L << (INT8 - 256)) | (1L << (TINYINT - 256)) | (1L << (SMALLINT - 256)) | (1L << (INT - 256)) | (1L << (INTEGER - 256)) | (1L << (BIGINT - 256)) | (1L << (FLOAT4 - 256)) | (1L << (FLOAT8 - 256)) | (1L << (REAL - 256)) | (1L << (FLOAT - 256)) | (1L << (DOUBLE - 256)) | (1L << (NUMERIC - 256)) | (1L << (DECIMAL - 256)) | (1L << (CHAR - 256)) | (1L << (VARCHAR - 256)) | (1L << (NCHAR - 256)) | (1L << (NVARCHAR - 256)) | (1L << (DATE - 256)) | (1L << (TIME - 256)) | (1L << (TIMETZ - 256)) | (1L << (TIMESTAMP - 256)) | (1L << (TIMESTAMPTZ - 256)) | (1L << (TEXT - 256)) | (1L << (VARBINARY - 256)) | (1L << (BLOB - 256)) | (1L << (BYTEA - 256)) | (1L << (INET4 - 256)) | (1L << (QUOTE - 256)))) != 0) || _la==Identifier );
				setState(728); revoke_from_cascade_restrict();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(730); match(REVOKE);
				setState(734);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(731); match(GRANT);
					setState(732); match(OPTION);
					setState(733); match(FOR);
					}
				}

				setState(745);
				switch (_input.LA(1)) {
				case SELECT:
				case UPDATE:
				case USAGE:
					{
					setState(737); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(736);
						_la = _input.LA(1);
						if ( !(((((_la - 102)) & ~0x3f) == 0 && ((1L << (_la - 102)) & ((1L << (SELECT - 102)) | (1L << (UPDATE - 102)) | (1L << (USAGE - 102)))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
						}
						setState(739); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 102)) & ~0x3f) == 0 && ((1L << (_la - 102)) & ((1L << (SELECT - 102)) | (1L << (UPDATE - 102)) | (1L << (USAGE - 102)))) != 0) );
					}
					break;
				case ALL:
					{
					setState(741); match(ALL);
					setState(743);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(742); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(747); match(ON);
				setState(769);
				switch (_input.LA(1)) {
				case SEQUENCE:
					{
					setState(748); match(SEQUENCE);
					setState(753); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(749); ((Revoke_statementContext)_localctx).sequence_name = schema_qualified_name();
						setState(751);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(750); match(COMMA);
							}
						}

						}
						}
						setState(755); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (ADMIN - 128)) | (1L << (AVG - 128)) | (1L << (BETWEEN - 128)) | (1L << (BY - 128)) | (1L << (CACHE - 128)) | (1L << (CALLED - 128)) | (1L << (CLASS - 128)) | (1L << (CENTURY - 128)) | (1L << (CHARACTER - 128)) | (1L << (CHECK - 128)) | (1L << (COLLECT - 128)) | (1L << (COALESCE - 128)) | (1L << (COLUMN - 128)) | (1L << (COMMENT - 128)) | (1L << (COMMENTS - 128)) | (1L << (COMMIT - 128)) | (1L << (CONFIGURATION - 128)) | (1L << (COST - 128)) | (1L << (COUNT - 128)) | (1L << (CUBE - 128)) | (1L << (CURRENT - 128)) | (1L << (CYCLE - 128)) | (1L << (DATA - 128)) | (1L << (DAY - 128)) | (1L << (DEC - 128)) | (1L << (DECADE - 128)) | (1L << (DEFINER - 128)) | (1L << (DICTIONARY - 128)) | (1L << (DOW - 128)) | (1L << (DOY - 128)) | (1L << (DROP - 128)) | (1L << (EPOCH - 128)) | (1L << (EVERY - 128)) | (1L << (EXISTS - 128)) | (1L << (EXTERNAL - 128)) | (1L << (EXTRACT - 128)) | (1L << (FAMILY - 128)) | (1L << (FILTER - 128)) | (1L << (FIRST - 128)) | (1L << (FORMAT - 128)) | (1L << (FUSION - 128)) | (1L << (GROUPING - 128)) | (1L << (HASH - 128)) | (1L << (INDEX - 128)) | (1L << (INCREMENT - 128)) | (1L << (INPUT - 128)) | (1L << (INSERT - 128)) | (1L << (INTERSECTION - 128)) | (1L << (ISCACHABLE - 128)) | (1L << (ISODOW - 128)) | (1L << (ISOYEAR - 128)) | (1L << (ISSTRICT - 128)) | (1L << (LANGUAGE - 128)) | (1L << (LARGE - 128)) | (1L << (LAST - 128)) | (1L << (LESS - 128)) | (1L << (LIST - 128)) | (1L << (LOCATION - 128)) | (1L << (MATCH - 128)) | (1L << (MAX - 128)) | (1L << (MAXVALUE - 128)) | (1L << (MICROSECONDS - 128)))) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (MILLENNIUM - 192)) | (1L << (MILLISECONDS - 192)) | (1L << (MIN - 192)) | (1L << (MINVALUE - 192)) | (1L << (MINUTE - 192)) | (1L << (MONTH - 192)) | (1L << (NATIONAL - 192)) | (1L << (NO - 192)) | (1L << (NONE - 192)) | (1L << (NULLIF - 192)) | (1L << (OBJECT - 192)) | (1L << (OPTION - 192)) | (1L << (OPTIONS - 192)) | (1L << (OVERWRITE - 192)) | (1L << (PARSER - 192)) | (1L << (PARTIAL - 192)) | (1L << (PARTITION - 192)) | (1L << (PARTITIONS - 192)) | (1L << (PRECISION - 192)) | (1L << (PUBLIC - 192)) | (1L << (PURGE - 192)) | (1L << (QUARTER - 192)) | (1L << (RANGE - 192)) | (1L << (REGEXP - 192)) | (1L << (RLIKE - 192)) | (1L << (ROLLUP - 192)) | (1L << (SEARCH - 192)) | (1L << (SECOND - 192)) | (1L << (SECURITY - 192)) | (1L << (SERVER - 192)) | (1L << (SET - 192)) | (1L << (SIMILAR - 192)) | (1L << (SIMPLE - 192)) | (1L << (STABLE - 192)) | (1L << (START - 192)) | (1L << (STORAGE - 192)) | (1L << (STDDEV_POP - 192)) | (1L << (STDDEV_SAMP - 192)) | (1L << (SUBPARTITION - 192)) | (1L << (SUM - 192)) | (1L << (TABLESPACE - 192)) | (1L << (TEMPLATE - 192)) | (1L << (THAN - 192)) | (1L << (TIMEZONE - 192)) | (1L << (TIMEZONE_HOUR - 192)) | (1L << (TIMEZONE_MINUTE - 192)) | (1L << (TRIM - 192)) | (1L << (TO - 192)) | (1L << (UNKNOWN - 192)) | (1L << (UNLOGGED - 192)) | (1L << (VALUES - 192)) | (1L << (VAR_SAMP - 192)) | (1L << (VAR_POP - 192)) | (1L << (VARYING - 192)) | (1L << (VOLATILE - 192)) | (1L << (WEEK - 192)) | (1L << (WINDOW - 192)) | (1L << (WRAPPER - 192)) | (1L << (YEAR - 192)) | (1L << (ZONE - 192)) | (1L << (BOOLEAN - 192)) | (1L << (BOOL - 192)))) != 0) || ((((_la - 256)) & ~0x3f) == 0 && ((1L << (_la - 256)) & ((1L << (BIT - 256)) | (1L << (VARBIT - 256)) | (1L << (INT1 - 256)) | (1L << (INT2 - 256)) | (1L << (INT4 - 256)) | (1L << (INT8 - 256)) | (1L << (TINYINT - 256)) | (1L << (SMALLINT - 256)) | (1L << (INT - 256)) | (1L << (INTEGER - 256)) | (1L << (BIGINT - 256)) | (1L << (FLOAT4 - 256)) | (1L << (FLOAT8 - 256)) | (1L << (REAL - 256)) | (1L << (FLOAT - 256)) | (1L << (DOUBLE - 256)) | (1L << (NUMERIC - 256)) | (1L << (DECIMAL - 256)) | (1L << (CHAR - 256)) | (1L << (VARCHAR - 256)) | (1L << (NCHAR - 256)) | (1L << (NVARCHAR - 256)) | (1L << (DATE - 256)) | (1L << (TIME - 256)) | (1L << (TIMETZ - 256)) | (1L << (TIMESTAMP - 256)) | (1L << (TIMESTAMPTZ - 256)) | (1L << (TEXT - 256)) | (1L << (VARBINARY - 256)) | (1L << (BLOB - 256)) | (1L << (BYTEA - 256)) | (1L << (INET4 - 256)) | (1L << (QUOTE - 256)))) != 0) || _la==Identifier );
					}
					break;
				case ALL:
					{
					setState(757); match(ALL);
					setState(758); match(SEQUENCES);
					setState(759); match(IN);
					setState(760); match(SCHEMA);
					setState(765); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(761); ((Revoke_statementContext)_localctx).schema_name = identifier();
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
					} while ( ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (ADMIN - 128)) | (1L << (AVG - 128)) | (1L << (BETWEEN - 128)) | (1L << (BY - 128)) | (1L << (CACHE - 128)) | (1L << (CALLED - 128)) | (1L << (CLASS - 128)) | (1L << (CENTURY - 128)) | (1L << (CHARACTER - 128)) | (1L << (CHECK - 128)) | (1L << (COLLECT - 128)) | (1L << (COALESCE - 128)) | (1L << (COLUMN - 128)) | (1L << (COMMENT - 128)) | (1L << (COMMENTS - 128)) | (1L << (COMMIT - 128)) | (1L << (CONFIGURATION - 128)) | (1L << (COST - 128)) | (1L << (COUNT - 128)) | (1L << (CUBE - 128)) | (1L << (CURRENT - 128)) | (1L << (CYCLE - 128)) | (1L << (DATA - 128)) | (1L << (DAY - 128)) | (1L << (DEC - 128)) | (1L << (DECADE - 128)) | (1L << (DEFINER - 128)) | (1L << (DICTIONARY - 128)) | (1L << (DOW - 128)) | (1L << (DOY - 128)) | (1L << (DROP - 128)) | (1L << (EPOCH - 128)) | (1L << (EVERY - 128)) | (1L << (EXISTS - 128)) | (1L << (EXTERNAL - 128)) | (1L << (EXTRACT - 128)) | (1L << (FAMILY - 128)) | (1L << (FILTER - 128)) | (1L << (FIRST - 128)) | (1L << (FORMAT - 128)) | (1L << (FUSION - 128)) | (1L << (GROUPING - 128)) | (1L << (HASH - 128)) | (1L << (INDEX - 128)) | (1L << (INCREMENT - 128)) | (1L << (INPUT - 128)) | (1L << (INSERT - 128)) | (1L << (INTERSECTION - 128)) | (1L << (ISCACHABLE - 128)) | (1L << (ISODOW - 128)) | (1L << (ISOYEAR - 128)) | (1L << (ISSTRICT - 128)) | (1L << (LANGUAGE - 128)) | (1L << (LARGE - 128)) | (1L << (LAST - 128)) | (1L << (LESS - 128)) | (1L << (LIST - 128)) | (1L << (LOCATION - 128)) | (1L << (MATCH - 128)) | (1L << (MAX - 128)) | (1L << (MAXVALUE - 128)) | (1L << (MICROSECONDS - 128)))) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (MILLENNIUM - 192)) | (1L << (MILLISECONDS - 192)) | (1L << (MIN - 192)) | (1L << (MINVALUE - 192)) | (1L << (MINUTE - 192)) | (1L << (MONTH - 192)) | (1L << (NATIONAL - 192)) | (1L << (NO - 192)) | (1L << (NONE - 192)) | (1L << (NULLIF - 192)) | (1L << (OBJECT - 192)) | (1L << (OPTION - 192)) | (1L << (OPTIONS - 192)) | (1L << (OVERWRITE - 192)) | (1L << (PARSER - 192)) | (1L << (PARTIAL - 192)) | (1L << (PARTITION - 192)) | (1L << (PARTITIONS - 192)) | (1L << (PRECISION - 192)) | (1L << (PUBLIC - 192)) | (1L << (PURGE - 192)) | (1L << (QUARTER - 192)) | (1L << (RANGE - 192)) | (1L << (REGEXP - 192)) | (1L << (RLIKE - 192)) | (1L << (ROLLUP - 192)) | (1L << (SEARCH - 192)) | (1L << (SECOND - 192)) | (1L << (SECURITY - 192)) | (1L << (SERVER - 192)) | (1L << (SET - 192)) | (1L << (SIMILAR - 192)) | (1L << (SIMPLE - 192)) | (1L << (STABLE - 192)) | (1L << (START - 192)) | (1L << (STORAGE - 192)) | (1L << (STDDEV_POP - 192)) | (1L << (STDDEV_SAMP - 192)) | (1L << (SUBPARTITION - 192)) | (1L << (SUM - 192)) | (1L << (TABLESPACE - 192)) | (1L << (TEMPLATE - 192)) | (1L << (THAN - 192)) | (1L << (TIMEZONE - 192)) | (1L << (TIMEZONE_HOUR - 192)) | (1L << (TIMEZONE_MINUTE - 192)) | (1L << (TRIM - 192)) | (1L << (TO - 192)) | (1L << (UNKNOWN - 192)) | (1L << (UNLOGGED - 192)) | (1L << (VALUES - 192)) | (1L << (VAR_SAMP - 192)) | (1L << (VAR_POP - 192)) | (1L << (VARYING - 192)) | (1L << (VOLATILE - 192)) | (1L << (WEEK - 192)) | (1L << (WINDOW - 192)) | (1L << (WRAPPER - 192)) | (1L << (YEAR - 192)) | (1L << (ZONE - 192)) | (1L << (BOOLEAN - 192)) | (1L << (BOOL - 192)))) != 0) || ((((_la - 256)) & ~0x3f) == 0 && ((1L << (_la - 256)) & ((1L << (BIT - 256)) | (1L << (VARBIT - 256)) | (1L << (INT1 - 256)) | (1L << (INT2 - 256)) | (1L << (INT4 - 256)) | (1L << (INT8 - 256)) | (1L << (TINYINT - 256)) | (1L << (SMALLINT - 256)) | (1L << (INT - 256)) | (1L << (INTEGER - 256)) | (1L << (BIGINT - 256)) | (1L << (FLOAT4 - 256)) | (1L << (FLOAT8 - 256)) | (1L << (REAL - 256)) | (1L << (FLOAT - 256)) | (1L << (DOUBLE - 256)) | (1L << (NUMERIC - 256)) | (1L << (DECIMAL - 256)) | (1L << (CHAR - 256)) | (1L << (VARCHAR - 256)) | (1L << (NCHAR - 256)) | (1L << (NVARCHAR - 256)) | (1L << (DATE - 256)) | (1L << (TIME - 256)) | (1L << (TIMETZ - 256)) | (1L << (TIMESTAMP - 256)) | (1L << (TIMESTAMPTZ - 256)) | (1L << (TEXT - 256)) | (1L << (VARBINARY - 256)) | (1L << (BLOB - 256)) | (1L << (BYTEA - 256)) | (1L << (INET4 - 256)) | (1L << (QUOTE - 256)))) != 0) || _la==Identifier );
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(771); revoke_from_cascade_restrict();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(773); match(REVOKE);
				setState(777);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(774); match(GRANT);
					setState(775); match(OPTION);
					setState(776); match(FOR);
					}
				}

				setState(788);
				switch (_input.LA(1)) {
				case CONNECT:
				case CREATE:
				case TEMP:
				case TEMPORARY:
					{
					setState(780); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(779);
						_la = _input.LA(1);
						if ( !(_la==CONNECT || _la==CREATE || _la==TEMP || _la==TEMPORARY) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
						}
						setState(782); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==CONNECT || _la==CREATE || _la==TEMP || _la==TEMPORARY );
					}
					break;
				case ALL:
					{
					setState(784); match(ALL);
					setState(786);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(785); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(790); match(ON);
				setState(791); match(DATABASE);
				setState(796); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(792); ((Revoke_statementContext)_localctx).database_name = identifier();
					setState(794);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(793); match(COMMA);
						}
					}

					}
					}
					setState(798); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (ADMIN - 128)) | (1L << (AVG - 128)) | (1L << (BETWEEN - 128)) | (1L << (BY - 128)) | (1L << (CACHE - 128)) | (1L << (CALLED - 128)) | (1L << (CLASS - 128)) | (1L << (CENTURY - 128)) | (1L << (CHARACTER - 128)) | (1L << (CHECK - 128)) | (1L << (COLLECT - 128)) | (1L << (COALESCE - 128)) | (1L << (COLUMN - 128)) | (1L << (COMMENT - 128)) | (1L << (COMMENTS - 128)) | (1L << (COMMIT - 128)) | (1L << (CONFIGURATION - 128)) | (1L << (COST - 128)) | (1L << (COUNT - 128)) | (1L << (CUBE - 128)) | (1L << (CURRENT - 128)) | (1L << (CYCLE - 128)) | (1L << (DATA - 128)) | (1L << (DAY - 128)) | (1L << (DEC - 128)) | (1L << (DECADE - 128)) | (1L << (DEFINER - 128)) | (1L << (DICTIONARY - 128)) | (1L << (DOW - 128)) | (1L << (DOY - 128)) | (1L << (DROP - 128)) | (1L << (EPOCH - 128)) | (1L << (EVERY - 128)) | (1L << (EXISTS - 128)) | (1L << (EXTERNAL - 128)) | (1L << (EXTRACT - 128)) | (1L << (FAMILY - 128)) | (1L << (FILTER - 128)) | (1L << (FIRST - 128)) | (1L << (FORMAT - 128)) | (1L << (FUSION - 128)) | (1L << (GROUPING - 128)) | (1L << (HASH - 128)) | (1L << (INDEX - 128)) | (1L << (INCREMENT - 128)) | (1L << (INPUT - 128)) | (1L << (INSERT - 128)) | (1L << (INTERSECTION - 128)) | (1L << (ISCACHABLE - 128)) | (1L << (ISODOW - 128)) | (1L << (ISOYEAR - 128)) | (1L << (ISSTRICT - 128)) | (1L << (LANGUAGE - 128)) | (1L << (LARGE - 128)) | (1L << (LAST - 128)) | (1L << (LESS - 128)) | (1L << (LIST - 128)) | (1L << (LOCATION - 128)) | (1L << (MATCH - 128)) | (1L << (MAX - 128)) | (1L << (MAXVALUE - 128)) | (1L << (MICROSECONDS - 128)))) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (MILLENNIUM - 192)) | (1L << (MILLISECONDS - 192)) | (1L << (MIN - 192)) | (1L << (MINVALUE - 192)) | (1L << (MINUTE - 192)) | (1L << (MONTH - 192)) | (1L << (NATIONAL - 192)) | (1L << (NO - 192)) | (1L << (NONE - 192)) | (1L << (NULLIF - 192)) | (1L << (OBJECT - 192)) | (1L << (OPTION - 192)) | (1L << (OPTIONS - 192)) | (1L << (OVERWRITE - 192)) | (1L << (PARSER - 192)) | (1L << (PARTIAL - 192)) | (1L << (PARTITION - 192)) | (1L << (PARTITIONS - 192)) | (1L << (PRECISION - 192)) | (1L << (PUBLIC - 192)) | (1L << (PURGE - 192)) | (1L << (QUARTER - 192)) | (1L << (RANGE - 192)) | (1L << (REGEXP - 192)) | (1L << (RLIKE - 192)) | (1L << (ROLLUP - 192)) | (1L << (SEARCH - 192)) | (1L << (SECOND - 192)) | (1L << (SECURITY - 192)) | (1L << (SERVER - 192)) | (1L << (SET - 192)) | (1L << (SIMILAR - 192)) | (1L << (SIMPLE - 192)) | (1L << (STABLE - 192)) | (1L << (START - 192)) | (1L << (STORAGE - 192)) | (1L << (STDDEV_POP - 192)) | (1L << (STDDEV_SAMP - 192)) | (1L << (SUBPARTITION - 192)) | (1L << (SUM - 192)) | (1L << (TABLESPACE - 192)) | (1L << (TEMPLATE - 192)) | (1L << (THAN - 192)) | (1L << (TIMEZONE - 192)) | (1L << (TIMEZONE_HOUR - 192)) | (1L << (TIMEZONE_MINUTE - 192)) | (1L << (TRIM - 192)) | (1L << (TO - 192)) | (1L << (UNKNOWN - 192)) | (1L << (UNLOGGED - 192)) | (1L << (VALUES - 192)) | (1L << (VAR_SAMP - 192)) | (1L << (VAR_POP - 192)) | (1L << (VARYING - 192)) | (1L << (VOLATILE - 192)) | (1L << (WEEK - 192)) | (1L << (WINDOW - 192)) | (1L << (WRAPPER - 192)) | (1L << (YEAR - 192)) | (1L << (ZONE - 192)) | (1L << (BOOLEAN - 192)) | (1L << (BOOL - 192)))) != 0) || ((((_la - 256)) & ~0x3f) == 0 && ((1L << (_la - 256)) & ((1L << (BIT - 256)) | (1L << (VARBIT - 256)) | (1L << (INT1 - 256)) | (1L << (INT2 - 256)) | (1L << (INT4 - 256)) | (1L << (INT8 - 256)) | (1L << (TINYINT - 256)) | (1L << (SMALLINT - 256)) | (1L << (INT - 256)) | (1L << (INTEGER - 256)) | (1L << (BIGINT - 256)) | (1L << (FLOAT4 - 256)) | (1L << (FLOAT8 - 256)) | (1L << (REAL - 256)) | (1L << (FLOAT - 256)) | (1L << (DOUBLE - 256)) | (1L << (NUMERIC - 256)) | (1L << (DECIMAL - 256)) | (1L << (CHAR - 256)) | (1L << (VARCHAR - 256)) | (1L << (NCHAR - 256)) | (1L << (NVARCHAR - 256)) | (1L << (DATE - 256)) | (1L << (TIME - 256)) | (1L << (TIMETZ - 256)) | (1L << (TIMESTAMP - 256)) | (1L << (TIMESTAMPTZ - 256)) | (1L << (TEXT - 256)) | (1L << (VARBINARY - 256)) | (1L << (BLOB - 256)) | (1L << (BYTEA - 256)) | (1L << (INET4 - 256)) | (1L << (QUOTE - 256)))) != 0) || _la==Identifier );
				setState(800); revoke_from_cascade_restrict();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(802); match(REVOKE);
				setState(806);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(803); match(GRANT);
					setState(804); match(OPTION);
					setState(805); match(FOR);
					}
				}

				setState(813);
				switch (_input.LA(1)) {
				case USAGE:
					{
					setState(808); match(USAGE);
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

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(815); match(ON);
				setState(816); match(FOREIGN);
				setState(817); match(DATA);
				setState(818); match(WRAPPER);
				setState(823); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(819); ((Revoke_statementContext)_localctx).fdw_name = schema_qualified_name();
					setState(821);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(820); match(COMMA);
						}
					}

					}
					}
					setState(825); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (ADMIN - 128)) | (1L << (AVG - 128)) | (1L << (BETWEEN - 128)) | (1L << (BY - 128)) | (1L << (CACHE - 128)) | (1L << (CALLED - 128)) | (1L << (CLASS - 128)) | (1L << (CENTURY - 128)) | (1L << (CHARACTER - 128)) | (1L << (CHECK - 128)) | (1L << (COLLECT - 128)) | (1L << (COALESCE - 128)) | (1L << (COLUMN - 128)) | (1L << (COMMENT - 128)) | (1L << (COMMENTS - 128)) | (1L << (COMMIT - 128)) | (1L << (CONFIGURATION - 128)) | (1L << (COST - 128)) | (1L << (COUNT - 128)) | (1L << (CUBE - 128)) | (1L << (CURRENT - 128)) | (1L << (CYCLE - 128)) | (1L << (DATA - 128)) | (1L << (DAY - 128)) | (1L << (DEC - 128)) | (1L << (DECADE - 128)) | (1L << (DEFINER - 128)) | (1L << (DICTIONARY - 128)) | (1L << (DOW - 128)) | (1L << (DOY - 128)) | (1L << (DROP - 128)) | (1L << (EPOCH - 128)) | (1L << (EVERY - 128)) | (1L << (EXISTS - 128)) | (1L << (EXTERNAL - 128)) | (1L << (EXTRACT - 128)) | (1L << (FAMILY - 128)) | (1L << (FILTER - 128)) | (1L << (FIRST - 128)) | (1L << (FORMAT - 128)) | (1L << (FUSION - 128)) | (1L << (GROUPING - 128)) | (1L << (HASH - 128)) | (1L << (INDEX - 128)) | (1L << (INCREMENT - 128)) | (1L << (INPUT - 128)) | (1L << (INSERT - 128)) | (1L << (INTERSECTION - 128)) | (1L << (ISCACHABLE - 128)) | (1L << (ISODOW - 128)) | (1L << (ISOYEAR - 128)) | (1L << (ISSTRICT - 128)) | (1L << (LANGUAGE - 128)) | (1L << (LARGE - 128)) | (1L << (LAST - 128)) | (1L << (LESS - 128)) | (1L << (LIST - 128)) | (1L << (LOCATION - 128)) | (1L << (MATCH - 128)) | (1L << (MAX - 128)) | (1L << (MAXVALUE - 128)) | (1L << (MICROSECONDS - 128)))) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (MILLENNIUM - 192)) | (1L << (MILLISECONDS - 192)) | (1L << (MIN - 192)) | (1L << (MINVALUE - 192)) | (1L << (MINUTE - 192)) | (1L << (MONTH - 192)) | (1L << (NATIONAL - 192)) | (1L << (NO - 192)) | (1L << (NONE - 192)) | (1L << (NULLIF - 192)) | (1L << (OBJECT - 192)) | (1L << (OPTION - 192)) | (1L << (OPTIONS - 192)) | (1L << (OVERWRITE - 192)) | (1L << (PARSER - 192)) | (1L << (PARTIAL - 192)) | (1L << (PARTITION - 192)) | (1L << (PARTITIONS - 192)) | (1L << (PRECISION - 192)) | (1L << (PUBLIC - 192)) | (1L << (PURGE - 192)) | (1L << (QUARTER - 192)) | (1L << (RANGE - 192)) | (1L << (REGEXP - 192)) | (1L << (RLIKE - 192)) | (1L << (ROLLUP - 192)) | (1L << (SEARCH - 192)) | (1L << (SECOND - 192)) | (1L << (SECURITY - 192)) | (1L << (SERVER - 192)) | (1L << (SET - 192)) | (1L << (SIMILAR - 192)) | (1L << (SIMPLE - 192)) | (1L << (STABLE - 192)) | (1L << (START - 192)) | (1L << (STORAGE - 192)) | (1L << (STDDEV_POP - 192)) | (1L << (STDDEV_SAMP - 192)) | (1L << (SUBPARTITION - 192)) | (1L << (SUM - 192)) | (1L << (TABLESPACE - 192)) | (1L << (TEMPLATE - 192)) | (1L << (THAN - 192)) | (1L << (TIMEZONE - 192)) | (1L << (TIMEZONE_HOUR - 192)) | (1L << (TIMEZONE_MINUTE - 192)) | (1L << (TRIM - 192)) | (1L << (TO - 192)) | (1L << (UNKNOWN - 192)) | (1L << (UNLOGGED - 192)) | (1L << (VALUES - 192)) | (1L << (VAR_SAMP - 192)) | (1L << (VAR_POP - 192)) | (1L << (VARYING - 192)) | (1L << (VOLATILE - 192)) | (1L << (WEEK - 192)) | (1L << (WINDOW - 192)) | (1L << (WRAPPER - 192)) | (1L << (YEAR - 192)) | (1L << (ZONE - 192)) | (1L << (BOOLEAN - 192)) | (1L << (BOOL - 192)))) != 0) || ((((_la - 256)) & ~0x3f) == 0 && ((1L << (_la - 256)) & ((1L << (BIT - 256)) | (1L << (VARBIT - 256)) | (1L << (INT1 - 256)) | (1L << (INT2 - 256)) | (1L << (INT4 - 256)) | (1L << (INT8 - 256)) | (1L << (TINYINT - 256)) | (1L << (SMALLINT - 256)) | (1L << (INT - 256)) | (1L << (INTEGER - 256)) | (1L << (BIGINT - 256)) | (1L << (FLOAT4 - 256)) | (1L << (FLOAT8 - 256)) | (1L << (REAL - 256)) | (1L << (FLOAT - 256)) | (1L << (DOUBLE - 256)) | (1L << (NUMERIC - 256)) | (1L << (DECIMAL - 256)) | (1L << (CHAR - 256)) | (1L << (VARCHAR - 256)) | (1L << (NCHAR - 256)) | (1L << (NVARCHAR - 256)) | (1L << (DATE - 256)) | (1L << (TIME - 256)) | (1L << (TIMETZ - 256)) | (1L << (TIMESTAMP - 256)) | (1L << (TIMESTAMPTZ - 256)) | (1L << (TEXT - 256)) | (1L << (VARBINARY - 256)) | (1L << (BLOB - 256)) | (1L << (BYTEA - 256)) | (1L << (INET4 - 256)) | (1L << (QUOTE - 256)))) != 0) || _la==Identifier );
				setState(827); revoke_from_cascade_restrict();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(829); match(REVOKE);
				setState(833);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(830); match(GRANT);
					setState(831); match(OPTION);
					setState(832); match(FOR);
					}
				}

				setState(840);
				switch (_input.LA(1)) {
				case USAGE:
					{
					setState(835); match(USAGE);
					}
					break;
				case ALL:
					{
					setState(836); match(ALL);
					setState(838);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(837); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(842); match(ON);
				setState(843); match(FOREIGN);
				setState(844); match(SERVER);
				setState(849); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(845); ((Revoke_statementContext)_localctx).server_name = identifier();
					setState(847);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(846); match(COMMA);
						}
					}

					}
					}
					setState(851); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (ADMIN - 128)) | (1L << (AVG - 128)) | (1L << (BETWEEN - 128)) | (1L << (BY - 128)) | (1L << (CACHE - 128)) | (1L << (CALLED - 128)) | (1L << (CLASS - 128)) | (1L << (CENTURY - 128)) | (1L << (CHARACTER - 128)) | (1L << (CHECK - 128)) | (1L << (COLLECT - 128)) | (1L << (COALESCE - 128)) | (1L << (COLUMN - 128)) | (1L << (COMMENT - 128)) | (1L << (COMMENTS - 128)) | (1L << (COMMIT - 128)) | (1L << (CONFIGURATION - 128)) | (1L << (COST - 128)) | (1L << (COUNT - 128)) | (1L << (CUBE - 128)) | (1L << (CURRENT - 128)) | (1L << (CYCLE - 128)) | (1L << (DATA - 128)) | (1L << (DAY - 128)) | (1L << (DEC - 128)) | (1L << (DECADE - 128)) | (1L << (DEFINER - 128)) | (1L << (DICTIONARY - 128)) | (1L << (DOW - 128)) | (1L << (DOY - 128)) | (1L << (DROP - 128)) | (1L << (EPOCH - 128)) | (1L << (EVERY - 128)) | (1L << (EXISTS - 128)) | (1L << (EXTERNAL - 128)) | (1L << (EXTRACT - 128)) | (1L << (FAMILY - 128)) | (1L << (FILTER - 128)) | (1L << (FIRST - 128)) | (1L << (FORMAT - 128)) | (1L << (FUSION - 128)) | (1L << (GROUPING - 128)) | (1L << (HASH - 128)) | (1L << (INDEX - 128)) | (1L << (INCREMENT - 128)) | (1L << (INPUT - 128)) | (1L << (INSERT - 128)) | (1L << (INTERSECTION - 128)) | (1L << (ISCACHABLE - 128)) | (1L << (ISODOW - 128)) | (1L << (ISOYEAR - 128)) | (1L << (ISSTRICT - 128)) | (1L << (LANGUAGE - 128)) | (1L << (LARGE - 128)) | (1L << (LAST - 128)) | (1L << (LESS - 128)) | (1L << (LIST - 128)) | (1L << (LOCATION - 128)) | (1L << (MATCH - 128)) | (1L << (MAX - 128)) | (1L << (MAXVALUE - 128)) | (1L << (MICROSECONDS - 128)))) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (MILLENNIUM - 192)) | (1L << (MILLISECONDS - 192)) | (1L << (MIN - 192)) | (1L << (MINVALUE - 192)) | (1L << (MINUTE - 192)) | (1L << (MONTH - 192)) | (1L << (NATIONAL - 192)) | (1L << (NO - 192)) | (1L << (NONE - 192)) | (1L << (NULLIF - 192)) | (1L << (OBJECT - 192)) | (1L << (OPTION - 192)) | (1L << (OPTIONS - 192)) | (1L << (OVERWRITE - 192)) | (1L << (PARSER - 192)) | (1L << (PARTIAL - 192)) | (1L << (PARTITION - 192)) | (1L << (PARTITIONS - 192)) | (1L << (PRECISION - 192)) | (1L << (PUBLIC - 192)) | (1L << (PURGE - 192)) | (1L << (QUARTER - 192)) | (1L << (RANGE - 192)) | (1L << (REGEXP - 192)) | (1L << (RLIKE - 192)) | (1L << (ROLLUP - 192)) | (1L << (SEARCH - 192)) | (1L << (SECOND - 192)) | (1L << (SECURITY - 192)) | (1L << (SERVER - 192)) | (1L << (SET - 192)) | (1L << (SIMILAR - 192)) | (1L << (SIMPLE - 192)) | (1L << (STABLE - 192)) | (1L << (START - 192)) | (1L << (STORAGE - 192)) | (1L << (STDDEV_POP - 192)) | (1L << (STDDEV_SAMP - 192)) | (1L << (SUBPARTITION - 192)) | (1L << (SUM - 192)) | (1L << (TABLESPACE - 192)) | (1L << (TEMPLATE - 192)) | (1L << (THAN - 192)) | (1L << (TIMEZONE - 192)) | (1L << (TIMEZONE_HOUR - 192)) | (1L << (TIMEZONE_MINUTE - 192)) | (1L << (TRIM - 192)) | (1L << (TO - 192)) | (1L << (UNKNOWN - 192)) | (1L << (UNLOGGED - 192)) | (1L << (VALUES - 192)) | (1L << (VAR_SAMP - 192)) | (1L << (VAR_POP - 192)) | (1L << (VARYING - 192)) | (1L << (VOLATILE - 192)) | (1L << (WEEK - 192)) | (1L << (WINDOW - 192)) | (1L << (WRAPPER - 192)) | (1L << (YEAR - 192)) | (1L << (ZONE - 192)) | (1L << (BOOLEAN - 192)) | (1L << (BOOL - 192)))) != 0) || ((((_la - 256)) & ~0x3f) == 0 && ((1L << (_la - 256)) & ((1L << (BIT - 256)) | (1L << (VARBIT - 256)) | (1L << (INT1 - 256)) | (1L << (INT2 - 256)) | (1L << (INT4 - 256)) | (1L << (INT8 - 256)) | (1L << (TINYINT - 256)) | (1L << (SMALLINT - 256)) | (1L << (INT - 256)) | (1L << (INTEGER - 256)) | (1L << (BIGINT - 256)) | (1L << (FLOAT4 - 256)) | (1L << (FLOAT8 - 256)) | (1L << (REAL - 256)) | (1L << (FLOAT - 256)) | (1L << (DOUBLE - 256)) | (1L << (NUMERIC - 256)) | (1L << (DECIMAL - 256)) | (1L << (CHAR - 256)) | (1L << (VARCHAR - 256)) | (1L << (NCHAR - 256)) | (1L << (NVARCHAR - 256)) | (1L << (DATE - 256)) | (1L << (TIME - 256)) | (1L << (TIMETZ - 256)) | (1L << (TIMESTAMP - 256)) | (1L << (TIMESTAMPTZ - 256)) | (1L << (TEXT - 256)) | (1L << (VARBINARY - 256)) | (1L << (BLOB - 256)) | (1L << (BYTEA - 256)) | (1L << (INET4 - 256)) | (1L << (QUOTE - 256)))) != 0) || _la==Identifier );
				setState(853); revoke_from_cascade_restrict();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(855); match(REVOKE);
				setState(859);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(856); match(GRANT);
					setState(857); match(OPTION);
					setState(858); match(FOR);
					}
				}

				setState(866);
				switch (_input.LA(1)) {
				case EXECUTE:
					{
					setState(861); match(EXECUTE);
					}
					break;
				case ALL:
					{
					setState(862); match(ALL);
					setState(864);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(863); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(868); match(ON);
				setState(871);
				switch (_input.LA(1)) {
				case FUNCTION:
					{
					setState(869); function_definition();
					}
					break;
				case ALL:
					{
					setState(870); functions_definition_schema();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(873); revoke_from_cascade_restrict();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(875); match(REVOKE);
				setState(879);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(876); match(GRANT);
					setState(877); match(OPTION);
					setState(878); match(FOR);
					}
				}

				setState(886);
				switch (_input.LA(1)) {
				case USAGE:
					{
					setState(881); match(USAGE);
					}
					break;
				case ALL:
					{
					setState(882); match(ALL);
					setState(884);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(883); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(888); match(ON);
				setState(889); match(LANGUAGE);
				setState(894); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(890); ((Revoke_statementContext)_localctx).lang_name = identifier();
					setState(892);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(891); match(COMMA);
						}
					}

					}
					}
					setState(896); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (ADMIN - 128)) | (1L << (AVG - 128)) | (1L << (BETWEEN - 128)) | (1L << (BY - 128)) | (1L << (CACHE - 128)) | (1L << (CALLED - 128)) | (1L << (CLASS - 128)) | (1L << (CENTURY - 128)) | (1L << (CHARACTER - 128)) | (1L << (CHECK - 128)) | (1L << (COLLECT - 128)) | (1L << (COALESCE - 128)) | (1L << (COLUMN - 128)) | (1L << (COMMENT - 128)) | (1L << (COMMENTS - 128)) | (1L << (COMMIT - 128)) | (1L << (CONFIGURATION - 128)) | (1L << (COST - 128)) | (1L << (COUNT - 128)) | (1L << (CUBE - 128)) | (1L << (CURRENT - 128)) | (1L << (CYCLE - 128)) | (1L << (DATA - 128)) | (1L << (DAY - 128)) | (1L << (DEC - 128)) | (1L << (DECADE - 128)) | (1L << (DEFINER - 128)) | (1L << (DICTIONARY - 128)) | (1L << (DOW - 128)) | (1L << (DOY - 128)) | (1L << (DROP - 128)) | (1L << (EPOCH - 128)) | (1L << (EVERY - 128)) | (1L << (EXISTS - 128)) | (1L << (EXTERNAL - 128)) | (1L << (EXTRACT - 128)) | (1L << (FAMILY - 128)) | (1L << (FILTER - 128)) | (1L << (FIRST - 128)) | (1L << (FORMAT - 128)) | (1L << (FUSION - 128)) | (1L << (GROUPING - 128)) | (1L << (HASH - 128)) | (1L << (INDEX - 128)) | (1L << (INCREMENT - 128)) | (1L << (INPUT - 128)) | (1L << (INSERT - 128)) | (1L << (INTERSECTION - 128)) | (1L << (ISCACHABLE - 128)) | (1L << (ISODOW - 128)) | (1L << (ISOYEAR - 128)) | (1L << (ISSTRICT - 128)) | (1L << (LANGUAGE - 128)) | (1L << (LARGE - 128)) | (1L << (LAST - 128)) | (1L << (LESS - 128)) | (1L << (LIST - 128)) | (1L << (LOCATION - 128)) | (1L << (MATCH - 128)) | (1L << (MAX - 128)) | (1L << (MAXVALUE - 128)) | (1L << (MICROSECONDS - 128)))) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (MILLENNIUM - 192)) | (1L << (MILLISECONDS - 192)) | (1L << (MIN - 192)) | (1L << (MINVALUE - 192)) | (1L << (MINUTE - 192)) | (1L << (MONTH - 192)) | (1L << (NATIONAL - 192)) | (1L << (NO - 192)) | (1L << (NONE - 192)) | (1L << (NULLIF - 192)) | (1L << (OBJECT - 192)) | (1L << (OPTION - 192)) | (1L << (OPTIONS - 192)) | (1L << (OVERWRITE - 192)) | (1L << (PARSER - 192)) | (1L << (PARTIAL - 192)) | (1L << (PARTITION - 192)) | (1L << (PARTITIONS - 192)) | (1L << (PRECISION - 192)) | (1L << (PUBLIC - 192)) | (1L << (PURGE - 192)) | (1L << (QUARTER - 192)) | (1L << (RANGE - 192)) | (1L << (REGEXP - 192)) | (1L << (RLIKE - 192)) | (1L << (ROLLUP - 192)) | (1L << (SEARCH - 192)) | (1L << (SECOND - 192)) | (1L << (SECURITY - 192)) | (1L << (SERVER - 192)) | (1L << (SET - 192)) | (1L << (SIMILAR - 192)) | (1L << (SIMPLE - 192)) | (1L << (STABLE - 192)) | (1L << (START - 192)) | (1L << (STORAGE - 192)) | (1L << (STDDEV_POP - 192)) | (1L << (STDDEV_SAMP - 192)) | (1L << (SUBPARTITION - 192)) | (1L << (SUM - 192)) | (1L << (TABLESPACE - 192)) | (1L << (TEMPLATE - 192)) | (1L << (THAN - 192)) | (1L << (TIMEZONE - 192)) | (1L << (TIMEZONE_HOUR - 192)) | (1L << (TIMEZONE_MINUTE - 192)) | (1L << (TRIM - 192)) | (1L << (TO - 192)) | (1L << (UNKNOWN - 192)) | (1L << (UNLOGGED - 192)) | (1L << (VALUES - 192)) | (1L << (VAR_SAMP - 192)) | (1L << (VAR_POP - 192)) | (1L << (VARYING - 192)) | (1L << (VOLATILE - 192)) | (1L << (WEEK - 192)) | (1L << (WINDOW - 192)) | (1L << (WRAPPER - 192)) | (1L << (YEAR - 192)) | (1L << (ZONE - 192)) | (1L << (BOOLEAN - 192)) | (1L << (BOOL - 192)))) != 0) || ((((_la - 256)) & ~0x3f) == 0 && ((1L << (_la - 256)) & ((1L << (BIT - 256)) | (1L << (VARBIT - 256)) | (1L << (INT1 - 256)) | (1L << (INT2 - 256)) | (1L << (INT4 - 256)) | (1L << (INT8 - 256)) | (1L << (TINYINT - 256)) | (1L << (SMALLINT - 256)) | (1L << (INT - 256)) | (1L << (INTEGER - 256)) | (1L << (BIGINT - 256)) | (1L << (FLOAT4 - 256)) | (1L << (FLOAT8 - 256)) | (1L << (REAL - 256)) | (1L << (FLOAT - 256)) | (1L << (DOUBLE - 256)) | (1L << (NUMERIC - 256)) | (1L << (DECIMAL - 256)) | (1L << (CHAR - 256)) | (1L << (VARCHAR - 256)) | (1L << (NCHAR - 256)) | (1L << (NVARCHAR - 256)) | (1L << (DATE - 256)) | (1L << (TIME - 256)) | (1L << (TIMETZ - 256)) | (1L << (TIMESTAMP - 256)) | (1L << (TIMESTAMPTZ - 256)) | (1L << (TEXT - 256)) | (1L << (VARBINARY - 256)) | (1L << (BLOB - 256)) | (1L << (BYTEA - 256)) | (1L << (INET4 - 256)) | (1L << (QUOTE - 256)))) != 0) || _la==Identifier );
				setState(898); revoke_from_cascade_restrict();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(900); match(REVOKE);
				setState(904);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(901); match(GRANT);
					setState(902); match(OPTION);
					setState(903); match(FOR);
					}
				}

				setState(919);
				switch (_input.LA(1)) {
				case SELECT:
				case UPDATE:
					{
					setState(911); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						setState(911);
						switch (_input.LA(1)) {
						case SELECT:
							{
							setState(906); match(SELECT);
							}
							break;
						case UPDATE:
							{
							setState(907); match(UPDATE);
							setState(909);
							_la = _input.LA(1);
							if (_la==COMMA) {
								{
								setState(908); match(COMMA);
								}
							}

							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						setState(913); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==SELECT || _la==UPDATE );
					}
					break;
				case ALL:
					{
					setState(915); match(ALL);
					setState(917);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(916); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(921); match(ON);
				setState(922); match(LARGE);
				setState(923); match(OBJECT);
				setState(928); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(924); ((Revoke_statementContext)_localctx).loid = identifier();
					setState(926);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(925); match(COMMA);
						}
					}

					}
					}
					setState(930); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (ADMIN - 128)) | (1L << (AVG - 128)) | (1L << (BETWEEN - 128)) | (1L << (BY - 128)) | (1L << (CACHE - 128)) | (1L << (CALLED - 128)) | (1L << (CLASS - 128)) | (1L << (CENTURY - 128)) | (1L << (CHARACTER - 128)) | (1L << (CHECK - 128)) | (1L << (COLLECT - 128)) | (1L << (COALESCE - 128)) | (1L << (COLUMN - 128)) | (1L << (COMMENT - 128)) | (1L << (COMMENTS - 128)) | (1L << (COMMIT - 128)) | (1L << (CONFIGURATION - 128)) | (1L << (COST - 128)) | (1L << (COUNT - 128)) | (1L << (CUBE - 128)) | (1L << (CURRENT - 128)) | (1L << (CYCLE - 128)) | (1L << (DATA - 128)) | (1L << (DAY - 128)) | (1L << (DEC - 128)) | (1L << (DECADE - 128)) | (1L << (DEFINER - 128)) | (1L << (DICTIONARY - 128)) | (1L << (DOW - 128)) | (1L << (DOY - 128)) | (1L << (DROP - 128)) | (1L << (EPOCH - 128)) | (1L << (EVERY - 128)) | (1L << (EXISTS - 128)) | (1L << (EXTERNAL - 128)) | (1L << (EXTRACT - 128)) | (1L << (FAMILY - 128)) | (1L << (FILTER - 128)) | (1L << (FIRST - 128)) | (1L << (FORMAT - 128)) | (1L << (FUSION - 128)) | (1L << (GROUPING - 128)) | (1L << (HASH - 128)) | (1L << (INDEX - 128)) | (1L << (INCREMENT - 128)) | (1L << (INPUT - 128)) | (1L << (INSERT - 128)) | (1L << (INTERSECTION - 128)) | (1L << (ISCACHABLE - 128)) | (1L << (ISODOW - 128)) | (1L << (ISOYEAR - 128)) | (1L << (ISSTRICT - 128)) | (1L << (LANGUAGE - 128)) | (1L << (LARGE - 128)) | (1L << (LAST - 128)) | (1L << (LESS - 128)) | (1L << (LIST - 128)) | (1L << (LOCATION - 128)) | (1L << (MATCH - 128)) | (1L << (MAX - 128)) | (1L << (MAXVALUE - 128)) | (1L << (MICROSECONDS - 128)))) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (MILLENNIUM - 192)) | (1L << (MILLISECONDS - 192)) | (1L << (MIN - 192)) | (1L << (MINVALUE - 192)) | (1L << (MINUTE - 192)) | (1L << (MONTH - 192)) | (1L << (NATIONAL - 192)) | (1L << (NO - 192)) | (1L << (NONE - 192)) | (1L << (NULLIF - 192)) | (1L << (OBJECT - 192)) | (1L << (OPTION - 192)) | (1L << (OPTIONS - 192)) | (1L << (OVERWRITE - 192)) | (1L << (PARSER - 192)) | (1L << (PARTIAL - 192)) | (1L << (PARTITION - 192)) | (1L << (PARTITIONS - 192)) | (1L << (PRECISION - 192)) | (1L << (PUBLIC - 192)) | (1L << (PURGE - 192)) | (1L << (QUARTER - 192)) | (1L << (RANGE - 192)) | (1L << (REGEXP - 192)) | (1L << (RLIKE - 192)) | (1L << (ROLLUP - 192)) | (1L << (SEARCH - 192)) | (1L << (SECOND - 192)) | (1L << (SECURITY - 192)) | (1L << (SERVER - 192)) | (1L << (SET - 192)) | (1L << (SIMILAR - 192)) | (1L << (SIMPLE - 192)) | (1L << (STABLE - 192)) | (1L << (START - 192)) | (1L << (STORAGE - 192)) | (1L << (STDDEV_POP - 192)) | (1L << (STDDEV_SAMP - 192)) | (1L << (SUBPARTITION - 192)) | (1L << (SUM - 192)) | (1L << (TABLESPACE - 192)) | (1L << (TEMPLATE - 192)) | (1L << (THAN - 192)) | (1L << (TIMEZONE - 192)) | (1L << (TIMEZONE_HOUR - 192)) | (1L << (TIMEZONE_MINUTE - 192)) | (1L << (TRIM - 192)) | (1L << (TO - 192)) | (1L << (UNKNOWN - 192)) | (1L << (UNLOGGED - 192)) | (1L << (VALUES - 192)) | (1L << (VAR_SAMP - 192)) | (1L << (VAR_POP - 192)) | (1L << (VARYING - 192)) | (1L << (VOLATILE - 192)) | (1L << (WEEK - 192)) | (1L << (WINDOW - 192)) | (1L << (WRAPPER - 192)) | (1L << (YEAR - 192)) | (1L << (ZONE - 192)) | (1L << (BOOLEAN - 192)) | (1L << (BOOL - 192)))) != 0) || ((((_la - 256)) & ~0x3f) == 0 && ((1L << (_la - 256)) & ((1L << (BIT - 256)) | (1L << (VARBIT - 256)) | (1L << (INT1 - 256)) | (1L << (INT2 - 256)) | (1L << (INT4 - 256)) | (1L << (INT8 - 256)) | (1L << (TINYINT - 256)) | (1L << (SMALLINT - 256)) | (1L << (INT - 256)) | (1L << (INTEGER - 256)) | (1L << (BIGINT - 256)) | (1L << (FLOAT4 - 256)) | (1L << (FLOAT8 - 256)) | (1L << (REAL - 256)) | (1L << (FLOAT - 256)) | (1L << (DOUBLE - 256)) | (1L << (NUMERIC - 256)) | (1L << (DECIMAL - 256)) | (1L << (CHAR - 256)) | (1L << (VARCHAR - 256)) | (1L << (NCHAR - 256)) | (1L << (NVARCHAR - 256)) | (1L << (DATE - 256)) | (1L << (TIME - 256)) | (1L << (TIMETZ - 256)) | (1L << (TIMESTAMP - 256)) | (1L << (TIMESTAMPTZ - 256)) | (1L << (TEXT - 256)) | (1L << (VARBINARY - 256)) | (1L << (BLOB - 256)) | (1L << (BYTEA - 256)) | (1L << (INET4 - 256)) | (1L << (QUOTE - 256)))) != 0) || _la==Identifier );
				setState(932); revoke_from_cascade_restrict();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(934); match(REVOKE);
				setState(938);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(935); match(GRANT);
					setState(936); match(OPTION);
					setState(937); match(FOR);
					}
				}

				setState(952);
				switch (_input.LA(1)) {
				case CREATE:
				case USAGE:
					{
					setState(944); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(940);
						_la = _input.LA(1);
						if ( !(_la==CREATE || _la==USAGE) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(942);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(941); match(COMMA);
							}
						}

						}
						}
						setState(946); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==CREATE || _la==USAGE );
					}
					break;
				case ALL:
					{
					setState(948); match(ALL);
					setState(950);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(949); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(954); match(ON);
				setState(955); match(SCHEMA);
				setState(960); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(956); ((Revoke_statementContext)_localctx).schema_name = identifier();
					setState(958);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(957); match(COMMA);
						}
					}

					}
					}
					setState(962); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (ADMIN - 128)) | (1L << (AVG - 128)) | (1L << (BETWEEN - 128)) | (1L << (BY - 128)) | (1L << (CACHE - 128)) | (1L << (CALLED - 128)) | (1L << (CLASS - 128)) | (1L << (CENTURY - 128)) | (1L << (CHARACTER - 128)) | (1L << (CHECK - 128)) | (1L << (COLLECT - 128)) | (1L << (COALESCE - 128)) | (1L << (COLUMN - 128)) | (1L << (COMMENT - 128)) | (1L << (COMMENTS - 128)) | (1L << (COMMIT - 128)) | (1L << (CONFIGURATION - 128)) | (1L << (COST - 128)) | (1L << (COUNT - 128)) | (1L << (CUBE - 128)) | (1L << (CURRENT - 128)) | (1L << (CYCLE - 128)) | (1L << (DATA - 128)) | (1L << (DAY - 128)) | (1L << (DEC - 128)) | (1L << (DECADE - 128)) | (1L << (DEFINER - 128)) | (1L << (DICTIONARY - 128)) | (1L << (DOW - 128)) | (1L << (DOY - 128)) | (1L << (DROP - 128)) | (1L << (EPOCH - 128)) | (1L << (EVERY - 128)) | (1L << (EXISTS - 128)) | (1L << (EXTERNAL - 128)) | (1L << (EXTRACT - 128)) | (1L << (FAMILY - 128)) | (1L << (FILTER - 128)) | (1L << (FIRST - 128)) | (1L << (FORMAT - 128)) | (1L << (FUSION - 128)) | (1L << (GROUPING - 128)) | (1L << (HASH - 128)) | (1L << (INDEX - 128)) | (1L << (INCREMENT - 128)) | (1L << (INPUT - 128)) | (1L << (INSERT - 128)) | (1L << (INTERSECTION - 128)) | (1L << (ISCACHABLE - 128)) | (1L << (ISODOW - 128)) | (1L << (ISOYEAR - 128)) | (1L << (ISSTRICT - 128)) | (1L << (LANGUAGE - 128)) | (1L << (LARGE - 128)) | (1L << (LAST - 128)) | (1L << (LESS - 128)) | (1L << (LIST - 128)) | (1L << (LOCATION - 128)) | (1L << (MATCH - 128)) | (1L << (MAX - 128)) | (1L << (MAXVALUE - 128)) | (1L << (MICROSECONDS - 128)))) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (MILLENNIUM - 192)) | (1L << (MILLISECONDS - 192)) | (1L << (MIN - 192)) | (1L << (MINVALUE - 192)) | (1L << (MINUTE - 192)) | (1L << (MONTH - 192)) | (1L << (NATIONAL - 192)) | (1L << (NO - 192)) | (1L << (NONE - 192)) | (1L << (NULLIF - 192)) | (1L << (OBJECT - 192)) | (1L << (OPTION - 192)) | (1L << (OPTIONS - 192)) | (1L << (OVERWRITE - 192)) | (1L << (PARSER - 192)) | (1L << (PARTIAL - 192)) | (1L << (PARTITION - 192)) | (1L << (PARTITIONS - 192)) | (1L << (PRECISION - 192)) | (1L << (PUBLIC - 192)) | (1L << (PURGE - 192)) | (1L << (QUARTER - 192)) | (1L << (RANGE - 192)) | (1L << (REGEXP - 192)) | (1L << (RLIKE - 192)) | (1L << (ROLLUP - 192)) | (1L << (SEARCH - 192)) | (1L << (SECOND - 192)) | (1L << (SECURITY - 192)) | (1L << (SERVER - 192)) | (1L << (SET - 192)) | (1L << (SIMILAR - 192)) | (1L << (SIMPLE - 192)) | (1L << (STABLE - 192)) | (1L << (START - 192)) | (1L << (STORAGE - 192)) | (1L << (STDDEV_POP - 192)) | (1L << (STDDEV_SAMP - 192)) | (1L << (SUBPARTITION - 192)) | (1L << (SUM - 192)) | (1L << (TABLESPACE - 192)) | (1L << (TEMPLATE - 192)) | (1L << (THAN - 192)) | (1L << (TIMEZONE - 192)) | (1L << (TIMEZONE_HOUR - 192)) | (1L << (TIMEZONE_MINUTE - 192)) | (1L << (TRIM - 192)) | (1L << (TO - 192)) | (1L << (UNKNOWN - 192)) | (1L << (UNLOGGED - 192)) | (1L << (VALUES - 192)) | (1L << (VAR_SAMP - 192)) | (1L << (VAR_POP - 192)) | (1L << (VARYING - 192)) | (1L << (VOLATILE - 192)) | (1L << (WEEK - 192)) | (1L << (WINDOW - 192)) | (1L << (WRAPPER - 192)) | (1L << (YEAR - 192)) | (1L << (ZONE - 192)) | (1L << (BOOLEAN - 192)) | (1L << (BOOL - 192)))) != 0) || ((((_la - 256)) & ~0x3f) == 0 && ((1L << (_la - 256)) & ((1L << (BIT - 256)) | (1L << (VARBIT - 256)) | (1L << (INT1 - 256)) | (1L << (INT2 - 256)) | (1L << (INT4 - 256)) | (1L << (INT8 - 256)) | (1L << (TINYINT - 256)) | (1L << (SMALLINT - 256)) | (1L << (INT - 256)) | (1L << (INTEGER - 256)) | (1L << (BIGINT - 256)) | (1L << (FLOAT4 - 256)) | (1L << (FLOAT8 - 256)) | (1L << (REAL - 256)) | (1L << (FLOAT - 256)) | (1L << (DOUBLE - 256)) | (1L << (NUMERIC - 256)) | (1L << (DECIMAL - 256)) | (1L << (CHAR - 256)) | (1L << (VARCHAR - 256)) | (1L << (NCHAR - 256)) | (1L << (NVARCHAR - 256)) | (1L << (DATE - 256)) | (1L << (TIME - 256)) | (1L << (TIMETZ - 256)) | (1L << (TIMESTAMP - 256)) | (1L << (TIMESTAMPTZ - 256)) | (1L << (TEXT - 256)) | (1L << (VARBINARY - 256)) | (1L << (BLOB - 256)) | (1L << (BYTEA - 256)) | (1L << (INET4 - 256)) | (1L << (QUOTE - 256)))) != 0) || _la==Identifier );
				setState(964); revoke_from_cascade_restrict();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
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

				setState(977);
				switch (_input.LA(1)) {
				case CREATE:
					{
					setState(972); match(CREATE);
					}
					break;
				case ALL:
					{
					setState(973); match(ALL);
					setState(975);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(974); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(979); match(ON);
				setState(980); match(TABLESPACE);
				setState(985); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(981); ((Revoke_statementContext)_localctx).tablespace_name = identifier();
					setState(983);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(982); match(COMMA);
						}
					}

					}
					}
					setState(987); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (ADMIN - 128)) | (1L << (AVG - 128)) | (1L << (BETWEEN - 128)) | (1L << (BY - 128)) | (1L << (CACHE - 128)) | (1L << (CALLED - 128)) | (1L << (CLASS - 128)) | (1L << (CENTURY - 128)) | (1L << (CHARACTER - 128)) | (1L << (CHECK - 128)) | (1L << (COLLECT - 128)) | (1L << (COALESCE - 128)) | (1L << (COLUMN - 128)) | (1L << (COMMENT - 128)) | (1L << (COMMENTS - 128)) | (1L << (COMMIT - 128)) | (1L << (CONFIGURATION - 128)) | (1L << (COST - 128)) | (1L << (COUNT - 128)) | (1L << (CUBE - 128)) | (1L << (CURRENT - 128)) | (1L << (CYCLE - 128)) | (1L << (DATA - 128)) | (1L << (DAY - 128)) | (1L << (DEC - 128)) | (1L << (DECADE - 128)) | (1L << (DEFINER - 128)) | (1L << (DICTIONARY - 128)) | (1L << (DOW - 128)) | (1L << (DOY - 128)) | (1L << (DROP - 128)) | (1L << (EPOCH - 128)) | (1L << (EVERY - 128)) | (1L << (EXISTS - 128)) | (1L << (EXTERNAL - 128)) | (1L << (EXTRACT - 128)) | (1L << (FAMILY - 128)) | (1L << (FILTER - 128)) | (1L << (FIRST - 128)) | (1L << (FORMAT - 128)) | (1L << (FUSION - 128)) | (1L << (GROUPING - 128)) | (1L << (HASH - 128)) | (1L << (INDEX - 128)) | (1L << (INCREMENT - 128)) | (1L << (INPUT - 128)) | (1L << (INSERT - 128)) | (1L << (INTERSECTION - 128)) | (1L << (ISCACHABLE - 128)) | (1L << (ISODOW - 128)) | (1L << (ISOYEAR - 128)) | (1L << (ISSTRICT - 128)) | (1L << (LANGUAGE - 128)) | (1L << (LARGE - 128)) | (1L << (LAST - 128)) | (1L << (LESS - 128)) | (1L << (LIST - 128)) | (1L << (LOCATION - 128)) | (1L << (MATCH - 128)) | (1L << (MAX - 128)) | (1L << (MAXVALUE - 128)) | (1L << (MICROSECONDS - 128)))) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (MILLENNIUM - 192)) | (1L << (MILLISECONDS - 192)) | (1L << (MIN - 192)) | (1L << (MINVALUE - 192)) | (1L << (MINUTE - 192)) | (1L << (MONTH - 192)) | (1L << (NATIONAL - 192)) | (1L << (NO - 192)) | (1L << (NONE - 192)) | (1L << (NULLIF - 192)) | (1L << (OBJECT - 192)) | (1L << (OPTION - 192)) | (1L << (OPTIONS - 192)) | (1L << (OVERWRITE - 192)) | (1L << (PARSER - 192)) | (1L << (PARTIAL - 192)) | (1L << (PARTITION - 192)) | (1L << (PARTITIONS - 192)) | (1L << (PRECISION - 192)) | (1L << (PUBLIC - 192)) | (1L << (PURGE - 192)) | (1L << (QUARTER - 192)) | (1L << (RANGE - 192)) | (1L << (REGEXP - 192)) | (1L << (RLIKE - 192)) | (1L << (ROLLUP - 192)) | (1L << (SEARCH - 192)) | (1L << (SECOND - 192)) | (1L << (SECURITY - 192)) | (1L << (SERVER - 192)) | (1L << (SET - 192)) | (1L << (SIMILAR - 192)) | (1L << (SIMPLE - 192)) | (1L << (STABLE - 192)) | (1L << (START - 192)) | (1L << (STORAGE - 192)) | (1L << (STDDEV_POP - 192)) | (1L << (STDDEV_SAMP - 192)) | (1L << (SUBPARTITION - 192)) | (1L << (SUM - 192)) | (1L << (TABLESPACE - 192)) | (1L << (TEMPLATE - 192)) | (1L << (THAN - 192)) | (1L << (TIMEZONE - 192)) | (1L << (TIMEZONE_HOUR - 192)) | (1L << (TIMEZONE_MINUTE - 192)) | (1L << (TRIM - 192)) | (1L << (TO - 192)) | (1L << (UNKNOWN - 192)) | (1L << (UNLOGGED - 192)) | (1L << (VALUES - 192)) | (1L << (VAR_SAMP - 192)) | (1L << (VAR_POP - 192)) | (1L << (VARYING - 192)) | (1L << (VOLATILE - 192)) | (1L << (WEEK - 192)) | (1L << (WINDOW - 192)) | (1L << (WRAPPER - 192)) | (1L << (YEAR - 192)) | (1L << (ZONE - 192)) | (1L << (BOOLEAN - 192)) | (1L << (BOOL - 192)))) != 0) || ((((_la - 256)) & ~0x3f) == 0 && ((1L << (_la - 256)) & ((1L << (BIT - 256)) | (1L << (VARBIT - 256)) | (1L << (INT1 - 256)) | (1L << (INT2 - 256)) | (1L << (INT4 - 256)) | (1L << (INT8 - 256)) | (1L << (TINYINT - 256)) | (1L << (SMALLINT - 256)) | (1L << (INT - 256)) | (1L << (INTEGER - 256)) | (1L << (BIGINT - 256)) | (1L << (FLOAT4 - 256)) | (1L << (FLOAT8 - 256)) | (1L << (REAL - 256)) | (1L << (FLOAT - 256)) | (1L << (DOUBLE - 256)) | (1L << (NUMERIC - 256)) | (1L << (DECIMAL - 256)) | (1L << (CHAR - 256)) | (1L << (VARCHAR - 256)) | (1L << (NCHAR - 256)) | (1L << (NVARCHAR - 256)) | (1L << (DATE - 256)) | (1L << (TIME - 256)) | (1L << (TIMETZ - 256)) | (1L << (TIMESTAMP - 256)) | (1L << (TIMESTAMPTZ - 256)) | (1L << (TEXT - 256)) | (1L << (VARBINARY - 256)) | (1L << (BLOB - 256)) | (1L << (BYTEA - 256)) | (1L << (INET4 - 256)) | (1L << (QUOTE - 256)))) != 0) || _la==Identifier );
				setState(989); revoke_from_cascade_restrict();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(991); match(REVOKE);
				setState(995);
				switch ( getInterpreter().adaptivePredict(_input,108,_ctx) ) {
				case 1:
					{
					setState(992); match(ADMIN);
					setState(993); match(OPTION);
					setState(994); match(FOR);
					}
					break;
				}
				setState(1001); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(997); ((Revoke_statementContext)_localctx).role_name = identifier();
					setState(999);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(998); match(COMMA);
						}
					}

					}
					}
					setState(1003); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (ADMIN - 128)) | (1L << (AVG - 128)) | (1L << (BETWEEN - 128)) | (1L << (BY - 128)) | (1L << (CACHE - 128)) | (1L << (CALLED - 128)) | (1L << (CLASS - 128)) | (1L << (CENTURY - 128)) | (1L << (CHARACTER - 128)) | (1L << (CHECK - 128)) | (1L << (COLLECT - 128)) | (1L << (COALESCE - 128)) | (1L << (COLUMN - 128)) | (1L << (COMMENT - 128)) | (1L << (COMMENTS - 128)) | (1L << (COMMIT - 128)) | (1L << (CONFIGURATION - 128)) | (1L << (COST - 128)) | (1L << (COUNT - 128)) | (1L << (CUBE - 128)) | (1L << (CURRENT - 128)) | (1L << (CYCLE - 128)) | (1L << (DATA - 128)) | (1L << (DAY - 128)) | (1L << (DEC - 128)) | (1L << (DECADE - 128)) | (1L << (DEFINER - 128)) | (1L << (DICTIONARY - 128)) | (1L << (DOW - 128)) | (1L << (DOY - 128)) | (1L << (DROP - 128)) | (1L << (EPOCH - 128)) | (1L << (EVERY - 128)) | (1L << (EXISTS - 128)) | (1L << (EXTERNAL - 128)) | (1L << (EXTRACT - 128)) | (1L << (FAMILY - 128)) | (1L << (FILTER - 128)) | (1L << (FIRST - 128)) | (1L << (FORMAT - 128)) | (1L << (FUSION - 128)) | (1L << (GROUPING - 128)) | (1L << (HASH - 128)) | (1L << (INDEX - 128)) | (1L << (INCREMENT - 128)) | (1L << (INPUT - 128)) | (1L << (INSERT - 128)) | (1L << (INTERSECTION - 128)) | (1L << (ISCACHABLE - 128)) | (1L << (ISODOW - 128)) | (1L << (ISOYEAR - 128)) | (1L << (ISSTRICT - 128)) | (1L << (LANGUAGE - 128)) | (1L << (LARGE - 128)) | (1L << (LAST - 128)) | (1L << (LESS - 128)) | (1L << (LIST - 128)) | (1L << (LOCATION - 128)) | (1L << (MATCH - 128)) | (1L << (MAX - 128)) | (1L << (MAXVALUE - 128)) | (1L << (MICROSECONDS - 128)))) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (MILLENNIUM - 192)) | (1L << (MILLISECONDS - 192)) | (1L << (MIN - 192)) | (1L << (MINVALUE - 192)) | (1L << (MINUTE - 192)) | (1L << (MONTH - 192)) | (1L << (NATIONAL - 192)) | (1L << (NO - 192)) | (1L << (NONE - 192)) | (1L << (NULLIF - 192)) | (1L << (OBJECT - 192)) | (1L << (OPTION - 192)) | (1L << (OPTIONS - 192)) | (1L << (OVERWRITE - 192)) | (1L << (PARSER - 192)) | (1L << (PARTIAL - 192)) | (1L << (PARTITION - 192)) | (1L << (PARTITIONS - 192)) | (1L << (PRECISION - 192)) | (1L << (PUBLIC - 192)) | (1L << (PURGE - 192)) | (1L << (QUARTER - 192)) | (1L << (RANGE - 192)) | (1L << (REGEXP - 192)) | (1L << (RLIKE - 192)) | (1L << (ROLLUP - 192)) | (1L << (SEARCH - 192)) | (1L << (SECOND - 192)) | (1L << (SECURITY - 192)) | (1L << (SERVER - 192)) | (1L << (SET - 192)) | (1L << (SIMILAR - 192)) | (1L << (SIMPLE - 192)) | (1L << (STABLE - 192)) | (1L << (START - 192)) | (1L << (STORAGE - 192)) | (1L << (STDDEV_POP - 192)) | (1L << (STDDEV_SAMP - 192)) | (1L << (SUBPARTITION - 192)) | (1L << (SUM - 192)) | (1L << (TABLESPACE - 192)) | (1L << (TEMPLATE - 192)) | (1L << (THAN - 192)) | (1L << (TIMEZONE - 192)) | (1L << (TIMEZONE_HOUR - 192)) | (1L << (TIMEZONE_MINUTE - 192)) | (1L << (TRIM - 192)) | (1L << (TO - 192)) | (1L << (UNKNOWN - 192)) | (1L << (UNLOGGED - 192)) | (1L << (VALUES - 192)) | (1L << (VAR_SAMP - 192)) | (1L << (VAR_POP - 192)) | (1L << (VARYING - 192)) | (1L << (VOLATILE - 192)) | (1L << (WEEK - 192)) | (1L << (WINDOW - 192)) | (1L << (WRAPPER - 192)) | (1L << (YEAR - 192)) | (1L << (ZONE - 192)) | (1L << (BOOLEAN - 192)) | (1L << (BOOL - 192)))) != 0) || ((((_la - 256)) & ~0x3f) == 0 && ((1L << (_la - 256)) & ((1L << (BIT - 256)) | (1L << (VARBIT - 256)) | (1L << (INT1 - 256)) | (1L << (INT2 - 256)) | (1L << (INT4 - 256)) | (1L << (INT8 - 256)) | (1L << (TINYINT - 256)) | (1L << (SMALLINT - 256)) | (1L << (INT - 256)) | (1L << (INTEGER - 256)) | (1L << (BIGINT - 256)) | (1L << (FLOAT4 - 256)) | (1L << (FLOAT8 - 256)) | (1L << (REAL - 256)) | (1L << (FLOAT - 256)) | (1L << (DOUBLE - 256)) | (1L << (NUMERIC - 256)) | (1L << (DECIMAL - 256)) | (1L << (CHAR - 256)) | (1L << (VARCHAR - 256)) | (1L << (NCHAR - 256)) | (1L << (NVARCHAR - 256)) | (1L << (DATE - 256)) | (1L << (TIME - 256)) | (1L << (TIMETZ - 256)) | (1L << (TIMESTAMP - 256)) | (1L << (TIMESTAMPTZ - 256)) | (1L << (TEXT - 256)) | (1L << (VARBINARY - 256)) | (1L << (BLOB - 256)) | (1L << (BYTEA - 256)) | (1L << (INET4 - 256)) | (1L << (QUOTE - 256)))) != 0) || _la==Identifier );
				setState(1005); match(FROM);
				setState(1010); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1006); ((Revoke_statementContext)_localctx).role_name = identifier();
						setState(1008);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1007); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1012); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,112,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1015);
				_la = _input.LA(1);
				if (_la==CASCADE || _la==RESTRICT) {
					{
					setState(1014);
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
			setState(1019); match(FROM);
			setState(1028); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(1028);
					switch ( getInterpreter().adaptivePredict(_input,117,_ctx) ) {
					case 1:
						{
						setState(1021);
						_la = _input.LA(1);
						if (_la==GROUP) {
							{
							setState(1020); match(GROUP);
							}
						}

						setState(1023); ((Revoke_from_cascade_restrictContext)_localctx).role_name = identifier();
						}
						break;
					case 2:
						{
						setState(1024); match(PUBLIC);
						setState(1026);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1025); match(COMMA);
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
				setState(1030); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,118,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(1033);
			_la = _input.LA(1);
			if (_la==CASCADE || _la==RESTRICT) {
				{
				setState(1032);
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
			setState(1360);
			switch ( getInterpreter().adaptivePredict(_input,190,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1035); match(GRANT);
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
					setState(1037); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1036);
						_la = _input.LA(1);
						if ( !(_la==DELETE || ((((_la - 92)) & ~0x3f) == 0 && ((1L << (_la - 92)) & ((1L << (REFERENCES - 92)) | (1L << (SELECT - 92)) | (1L << (TRIGGER - 92)) | (1L << (TRUNCATE - 92)) | (1L << (UPDATE - 92)))) != 0) || _la==INSERT) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
						}
						setState(1039); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==DELETE || ((((_la - 92)) & ~0x3f) == 0 && ((1L << (_la - 92)) & ((1L << (REFERENCES - 92)) | (1L << (SELECT - 92)) | (1L << (TRIGGER - 92)) | (1L << (TRUNCATE - 92)) | (1L << (UPDATE - 92)))) != 0) || _la==INSERT );
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
				setState(1071);
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
					setState(1049);
					_la = _input.LA(1);
					if (_la==TABLE) {
						{
						setState(1048); match(TABLE);
						}
					}

					setState(1055); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(1051); ((Grant_statementContext)_localctx).tabl_name = schema_qualified_name();
							setState(1053);
							_la = _input.LA(1);
							if (_la==COMMA) {
								{
								setState(1052); match(COMMA);
								}
							}

							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(1057); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,125,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					}
					}
					break;
				case ALL:
					{
					{
					setState(1059); match(ALL);
					setState(1060); match(TABLES);
					setState(1061); match(IN);
					setState(1062); match(SCHEMA);
					setState(1067); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(1063); ((Grant_statementContext)_localctx).schem_name = identifier();
							setState(1065);
							_la = _input.LA(1);
							if (_la==COMMA) {
								{
								setState(1064); match(COMMA);
								}
							}

							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(1069); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,127,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1073); grant_to_rule();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1075); match(GRANT);
				setState(1101);
				switch (_input.LA(1)) {
				case REFERENCES:
				case SELECT:
				case UPDATE:
				case INSERT:
					{
					setState(1085); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1076);
						_la = _input.LA(1);
						if ( !(((((_la - 92)) & ~0x3f) == 0 && ((1L << (_la - 92)) & ((1L << (REFERENCES - 92)) | (1L << (SELECT - 92)) | (1L << (UPDATE - 92)))) != 0) || _la==INSERT) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(1081); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(1077); ((Grant_statementContext)_localctx).column = identifier();
								setState(1079);
								_la = _input.LA(1);
								if (_la==COMMA) {
									{
									setState(1078); match(COMMA);
									}
								}

								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(1083); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,130,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						}
						}
						setState(1087); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 92)) & ~0x3f) == 0 && ((1L << (_la - 92)) & ((1L << (REFERENCES - 92)) | (1L << (SELECT - 92)) | (1L << (UPDATE - 92)))) != 0) || _la==INSERT );
					}
					break;
				case ALL:
					{
					setState(1089); match(ALL);
					setState(1091);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1090); match(PRIVILEGES);
						}
					}

					setState(1097); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1093); ((Grant_statementContext)_localctx).column = identifier();
						setState(1095);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1094); match(COMMA);
							}
						}

						}
						}
						setState(1099); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (ADMIN - 128)) | (1L << (AVG - 128)) | (1L << (BETWEEN - 128)) | (1L << (BY - 128)) | (1L << (CACHE - 128)) | (1L << (CALLED - 128)) | (1L << (CLASS - 128)) | (1L << (CENTURY - 128)) | (1L << (CHARACTER - 128)) | (1L << (CHECK - 128)) | (1L << (COLLECT - 128)) | (1L << (COALESCE - 128)) | (1L << (COLUMN - 128)) | (1L << (COMMENT - 128)) | (1L << (COMMENTS - 128)) | (1L << (COMMIT - 128)) | (1L << (CONFIGURATION - 128)) | (1L << (COST - 128)) | (1L << (COUNT - 128)) | (1L << (CUBE - 128)) | (1L << (CURRENT - 128)) | (1L << (CYCLE - 128)) | (1L << (DATA - 128)) | (1L << (DAY - 128)) | (1L << (DEC - 128)) | (1L << (DECADE - 128)) | (1L << (DEFINER - 128)) | (1L << (DICTIONARY - 128)) | (1L << (DOW - 128)) | (1L << (DOY - 128)) | (1L << (DROP - 128)) | (1L << (EPOCH - 128)) | (1L << (EVERY - 128)) | (1L << (EXISTS - 128)) | (1L << (EXTERNAL - 128)) | (1L << (EXTRACT - 128)) | (1L << (FAMILY - 128)) | (1L << (FILTER - 128)) | (1L << (FIRST - 128)) | (1L << (FORMAT - 128)) | (1L << (FUSION - 128)) | (1L << (GROUPING - 128)) | (1L << (HASH - 128)) | (1L << (INDEX - 128)) | (1L << (INCREMENT - 128)) | (1L << (INPUT - 128)) | (1L << (INSERT - 128)) | (1L << (INTERSECTION - 128)) | (1L << (ISCACHABLE - 128)) | (1L << (ISODOW - 128)) | (1L << (ISOYEAR - 128)) | (1L << (ISSTRICT - 128)) | (1L << (LANGUAGE - 128)) | (1L << (LARGE - 128)) | (1L << (LAST - 128)) | (1L << (LESS - 128)) | (1L << (LIST - 128)) | (1L << (LOCATION - 128)) | (1L << (MATCH - 128)) | (1L << (MAX - 128)) | (1L << (MAXVALUE - 128)) | (1L << (MICROSECONDS - 128)))) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (MILLENNIUM - 192)) | (1L << (MILLISECONDS - 192)) | (1L << (MIN - 192)) | (1L << (MINVALUE - 192)) | (1L << (MINUTE - 192)) | (1L << (MONTH - 192)) | (1L << (NATIONAL - 192)) | (1L << (NO - 192)) | (1L << (NONE - 192)) | (1L << (NULLIF - 192)) | (1L << (OBJECT - 192)) | (1L << (OPTION - 192)) | (1L << (OPTIONS - 192)) | (1L << (OVERWRITE - 192)) | (1L << (PARSER - 192)) | (1L << (PARTIAL - 192)) | (1L << (PARTITION - 192)) | (1L << (PARTITIONS - 192)) | (1L << (PRECISION - 192)) | (1L << (PUBLIC - 192)) | (1L << (PURGE - 192)) | (1L << (QUARTER - 192)) | (1L << (RANGE - 192)) | (1L << (REGEXP - 192)) | (1L << (RLIKE - 192)) | (1L << (ROLLUP - 192)) | (1L << (SEARCH - 192)) | (1L << (SECOND - 192)) | (1L << (SECURITY - 192)) | (1L << (SERVER - 192)) | (1L << (SET - 192)) | (1L << (SIMILAR - 192)) | (1L << (SIMPLE - 192)) | (1L << (STABLE - 192)) | (1L << (START - 192)) | (1L << (STORAGE - 192)) | (1L << (STDDEV_POP - 192)) | (1L << (STDDEV_SAMP - 192)) | (1L << (SUBPARTITION - 192)) | (1L << (SUM - 192)) | (1L << (TABLESPACE - 192)) | (1L << (TEMPLATE - 192)) | (1L << (THAN - 192)) | (1L << (TIMEZONE - 192)) | (1L << (TIMEZONE_HOUR - 192)) | (1L << (TIMEZONE_MINUTE - 192)) | (1L << (TRIM - 192)) | (1L << (TO - 192)) | (1L << (UNKNOWN - 192)) | (1L << (UNLOGGED - 192)) | (1L << (VALUES - 192)) | (1L << (VAR_SAMP - 192)) | (1L << (VAR_POP - 192)) | (1L << (VARYING - 192)) | (1L << (VOLATILE - 192)) | (1L << (WEEK - 192)) | (1L << (WINDOW - 192)) | (1L << (WRAPPER - 192)) | (1L << (YEAR - 192)) | (1L << (ZONE - 192)) | (1L << (BOOLEAN - 192)) | (1L << (BOOL - 192)))) != 0) || ((((_la - 256)) & ~0x3f) == 0 && ((1L << (_la - 256)) & ((1L << (BIT - 256)) | (1L << (VARBIT - 256)) | (1L << (INT1 - 256)) | (1L << (INT2 - 256)) | (1L << (INT4 - 256)) | (1L << (INT8 - 256)) | (1L << (TINYINT - 256)) | (1L << (SMALLINT - 256)) | (1L << (INT - 256)) | (1L << (INTEGER - 256)) | (1L << (BIGINT - 256)) | (1L << (FLOAT4 - 256)) | (1L << (FLOAT8 - 256)) | (1L << (REAL - 256)) | (1L << (FLOAT - 256)) | (1L << (DOUBLE - 256)) | (1L << (NUMERIC - 256)) | (1L << (DECIMAL - 256)) | (1L << (CHAR - 256)) | (1L << (VARCHAR - 256)) | (1L << (NCHAR - 256)) | (1L << (NVARCHAR - 256)) | (1L << (DATE - 256)) | (1L << (TIME - 256)) | (1L << (TIMETZ - 256)) | (1L << (TIMESTAMP - 256)) | (1L << (TIMESTAMPTZ - 256)) | (1L << (TEXT - 256)) | (1L << (VARBINARY - 256)) | (1L << (BLOB - 256)) | (1L << (BYTEA - 256)) | (1L << (INET4 - 256)) | (1L << (QUOTE - 256)))) != 0) || _la==Identifier );
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1103); match(ON);
				setState(1111); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1105);
						_la = _input.LA(1);
						if (_la==TABLE) {
							{
							setState(1104); match(TABLE);
							}
						}

						setState(1107); ((Grant_statementContext)_localctx).tabl_name = schema_qualified_name();
						setState(1109);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1108); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1113); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,138,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1115); grant_to_rule();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1117); match(GRANT);
				setState(1130);
				switch (_input.LA(1)) {
				case SELECT:
				case UPDATE:
				case USAGE:
					{
					setState(1122); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1118);
						_la = _input.LA(1);
						if ( !(((((_la - 102)) & ~0x3f) == 0 && ((1L << (_la - 102)) & ((1L << (SELECT - 102)) | (1L << (UPDATE - 102)) | (1L << (USAGE - 102)))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(1120);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1119); match(COMMA);
							}
						}

						}
						}
						setState(1124); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 102)) & ~0x3f) == 0 && ((1L << (_la - 102)) & ((1L << (SELECT - 102)) | (1L << (UPDATE - 102)) | (1L << (USAGE - 102)))) != 0) );
					}
					break;
				case ALL:
					{
					setState(1126); match(ALL);
					setState(1128);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1127); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1132); match(ON);
				setState(1154);
				switch (_input.LA(1)) {
				case SEQUENCE:
					{
					setState(1138); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1133); match(SEQUENCE);
						setState(1134); ((Grant_statementContext)_localctx).sequence_name = identifier();
						setState(1136);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1135); match(COMMA);
							}
						}

						}
						}
						setState(1140); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==SEQUENCE );
					}
					break;
				case ALL:
					{
					setState(1142); match(ALL);
					setState(1143); match(SEQUENCES);
					setState(1144); match(IN);
					setState(1145); match(SCHEMA);
					setState(1150); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(1146); ((Grant_statementContext)_localctx).schema_name = identifier();
							setState(1148);
							_la = _input.LA(1);
							if (_la==COMMA) {
								{
								setState(1147); match(COMMA);
								}
							}

							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(1152); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,146,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1156); grant_to_rule();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1158); match(GRANT);
				setState(1171);
				switch (_input.LA(1)) {
				case CONNECT:
				case CREATE:
				case TEMP:
				case TEMPORARY:
					{
					setState(1163); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1159);
						_la = _input.LA(1);
						if ( !(_la==CONNECT || _la==CREATE || _la==TEMP || _la==TEMPORARY) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(1161);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1160); match(COMMA);
							}
						}

						}
						}
						setState(1165); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==CONNECT || _la==CREATE || _la==TEMP || _la==TEMPORARY );
					}
					break;
				case ALL:
					{
					setState(1167); match(ALL);
					setState(1169);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1168); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1173); match(ON);
				setState(1174); match(DATABASE);
				setState(1179); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1175); ((Grant_statementContext)_localctx).database_name = identifier();
						setState(1177);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1176); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1181); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,153,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1183); grant_to_rule();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1185); match(GRANT);
				setState(1191);
				switch (_input.LA(1)) {
				case USAGE:
					{
					setState(1186); match(USAGE);
					}
					break;
				case ALL:
					{
					setState(1187); match(ALL);
					setState(1189);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1188); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1193); match(ON);
				setState(1194); match(FOREIGN);
				setState(1195); match(DATA);
				setState(1196); match(WRAPPER);
				setState(1201); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1197); ((Grant_statementContext)_localctx).fdw_name = identifier();
						setState(1199);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1198); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1203); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,157,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1205); grant_to_rule();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1207); match(GRANT);
				setState(1213);
				switch (_input.LA(1)) {
				case USAGE:
					{
					setState(1208); match(USAGE);
					}
					break;
				case ALL:
					{
					setState(1209); match(ALL);
					setState(1211);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1210); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1215); match(ON);
				setState(1216); match(FOREIGN);
				setState(1217); match(SERVER);
				setState(1222); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1218); ((Grant_statementContext)_localctx).server_name = identifier();
						setState(1220);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1219); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1224); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,161,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1226); grant_to_rule();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1228); match(GRANT);
				setState(1234);
				switch (_input.LA(1)) {
				case EXECUTE:
					{
					setState(1229); match(EXECUTE);
					}
					break;
				case ALL:
					{
					setState(1230); match(ALL);
					setState(1232);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1231); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1236); match(ON);
				setState(1239);
				switch (_input.LA(1)) {
				case FUNCTION:
					{
					setState(1237); function_definition();
					}
					break;
				case ALL:
					{
					setState(1238); functions_definition_schema();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1241); grant_to_rule();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(1243); match(GRANT);
				setState(1249);
				switch (_input.LA(1)) {
				case USAGE:
					{
					setState(1244); match(USAGE);
					}
					break;
				case ALL:
					{
					setState(1245); match(ALL);
					setState(1247);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1246); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1251); match(ON);
				setState(1252); match(LANGUAGE);
				setState(1257); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1253); ((Grant_statementContext)_localctx).lang_name = identifier();
						setState(1255);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1254); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1259); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,168,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1261); grant_to_rule();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(1263); match(GRANT);
				setState(1276);
				switch (_input.LA(1)) {
				case SELECT:
				case UPDATE:
					{
					setState(1268); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1264);
						_la = _input.LA(1);
						if ( !(_la==SELECT || _la==UPDATE) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(1266);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1265); match(COMMA);
							}
						}

						}
						}
						setState(1270); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==SELECT || _la==UPDATE );
					}
					break;
				case ALL:
					{
					setState(1272); match(ALL);
					setState(1274);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1273); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1278); match(ON);
				setState(1279); match(LARGE);
				setState(1280); match(OBJECT);
				setState(1285); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1281); ((Grant_statementContext)_localctx).loid = identifier();
						setState(1283);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1282); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1287); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,174,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1289); grant_to_rule();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(1291); match(GRANT);
				setState(1304);
				switch (_input.LA(1)) {
				case CREATE:
				case USAGE:
					{
					setState(1296); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1292);
						_la = _input.LA(1);
						if ( !(_la==CREATE || _la==USAGE) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(1294);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1293); match(COMMA);
							}
						}

						}
						}
						setState(1298); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==CREATE || _la==USAGE );
					}
					break;
				case ALL:
					{
					setState(1300); match(ALL);
					setState(1302);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1301); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1306); match(ON);
				setState(1307); match(SCHEMA);
				setState(1312); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1308); ((Grant_statementContext)_localctx).schema_name = identifier();
						setState(1310);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1309); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1314); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,180,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1316); grant_to_rule();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(1318); match(GRANT);
				setState(1324);
				switch (_input.LA(1)) {
				case CREATE:
					{
					setState(1319); match(CREATE);
					}
					break;
				case ALL:
					{
					setState(1320); match(ALL);
					setState(1322);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1321); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1326); match(ON);
				setState(1327); match(TABLESPACE);
				setState(1332); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1328); ((Grant_statementContext)_localctx).tablespace_name = identifier();
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
					_alt = getInterpreter().adaptivePredict(_input,184,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1336); grant_to_rule();
				setState(1337); match(GRANT);
				setState(1342); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1338); ((Grant_statementContext)_localctx).role_name = identifier();
						setState(1340);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1339); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1344); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,186,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1346); match(TO);
				setState(1351); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1347); ((Grant_statementContext)_localctx).role_name = identifier();
						setState(1349);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1348); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1353); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,188,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1358);
				_la = _input.LA(1);
				if (_la==WITH) {
					{
					setState(1355); match(WITH);
					setState(1356); match(ADMIN);
					setState(1357); match(OPTION);
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
			setState(1362); match(TO);
			setState(1373); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(1364);
					_la = _input.LA(1);
					if (_la==GROUP) {
						{
						setState(1363); match(GROUP);
						}
					}

					setState(1368);
					switch ( getInterpreter().adaptivePredict(_input,192,_ctx) ) {
					case 1:
						{
						{
						setState(1366); ((Grant_to_ruleContext)_localctx).role_name = identifier();
						}
						}
						break;
					case 2:
						{
						setState(1367); match(PUBLIC);
						}
						break;
					}
					setState(1371);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1370); match(COMMA);
						}
					}

					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1375); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,194,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(1380);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(1377); match(WITH);
				setState(1378); match(GRANT);
				setState(1379); match(OPTION);
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
			setState(1382); match(COMMENT);
			setState(1383); match(ON);
			setState(1503);
			switch ( getInterpreter().adaptivePredict(_input,199,_ctx) ) {
			case 1:
				{
				setState(1384); match(AGGREGATE);
				setState(1385); ((Comment_on_statementContext)_localctx).agg_name = schema_qualified_name();
				setState(1386); match(LEFT_PAREN);
				setState(1393);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 136)) & ~0x3f) == 0 && ((1L << (_la - 136)) & ((1L << (CHARACTER - 136)) | (1L << (DEC - 136)) | (1L << (NATIONAL - 136)))) != 0) || ((((_la - 254)) & ~0x3f) == 0 && ((1L << (_la - 254)) & ((1L << (BOOLEAN - 254)) | (1L << (BOOL - 254)) | (1L << (BIT - 254)) | (1L << (VARBIT - 254)) | (1L << (INT1 - 254)) | (1L << (INT2 - 254)) | (1L << (INT4 - 254)) | (1L << (INT8 - 254)) | (1L << (TINYINT - 254)) | (1L << (SMALLINT - 254)) | (1L << (INT - 254)) | (1L << (INTEGER - 254)) | (1L << (BIGINT - 254)) | (1L << (FLOAT4 - 254)) | (1L << (FLOAT8 - 254)) | (1L << (REAL - 254)) | (1L << (REGCLASS - 254)) | (1L << (FLOAT - 254)) | (1L << (DOUBLE - 254)) | (1L << (NUMERIC - 254)) | (1L << (DECIMAL - 254)) | (1L << (CHAR - 254)) | (1L << (VARCHAR - 254)) | (1L << (NCHAR - 254)) | (1L << (NVARCHAR - 254)) | (1L << (DATE - 254)) | (1L << (TIME - 254)) | (1L << (TIMETZ - 254)) | (1L << (TIMESTAMP - 254)) | (1L << (TIMESTAMPTZ - 254)) | (1L << (TEXT - 254)) | (1L << (BINARY - 254)) | (1L << (VARBINARY - 254)) | (1L << (BLOB - 254)) | (1L << (BYTEA - 254)) | (1L << (INET4 - 254)))) != 0)) {
					{
					{
					setState(1387); ((Comment_on_statementContext)_localctx).agg_type = data_type();
					setState(1389);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1388); match(COMMA);
						}
					}

					}
					}
					setState(1395);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1396); match(RIGHT_PAREN);
				}
				break;
			case 2:
				{
				setState(1398); match(CAST);
				setState(1399); match(LEFT_PAREN);
				setState(1400); ((Comment_on_statementContext)_localctx).source_type = data_type();
				setState(1401); match(AS);
				setState(1402); ((Comment_on_statementContext)_localctx).target_type = data_type();
				setState(1403); match(RIGHT_PAREN);
				}
				break;
			case 3:
				{
				setState(1405); match(COLLATION);
				setState(1406); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 4:
				{
				setState(1407); match(COLUMN);
				setState(1408); ((Comment_on_statementContext)_localctx).column_name = schema_qualified_name();
				}
				break;
			case 5:
				{
				setState(1409); match(CONSTRAINT);
				setState(1410); ((Comment_on_statementContext)_localctx).constraint_name = schema_qualified_name();
				setState(1411); match(ON);
				setState(1412); ((Comment_on_statementContext)_localctx).table_name = schema_qualified_name();
				}
				break;
			case 6:
				{
				setState(1414); match(CONVERSION);
				setState(1415); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 7:
				{
				setState(1416); match(DATABASE);
				setState(1417); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 8:
				{
				setState(1418); match(DOMAIN);
				setState(1419); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 9:
				{
				setState(1420); match(EXTENSION);
				setState(1421); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 10:
				{
				setState(1422); match(FOREIGN);
				setState(1423); match(DATA);
				setState(1424); match(WRAPPER);
				setState(1425); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 11:
				{
				setState(1426); match(FOREIGN);
				setState(1427); match(TABLE);
				setState(1428); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 12:
				{
				setState(1429); match(FUNCTION);
				setState(1430); routine_invocation();
				}
				break;
			case 13:
				{
				setState(1431); match(INDEX);
				setState(1432); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 14:
				{
				setState(1433); match(LARGE);
				setState(1434); match(OBJECT);
				setState(1435); ((Comment_on_statementContext)_localctx).large_object_oid = identifier();
				}
				break;
			case 15:
				{
				setState(1436); match(OPERATOR);
				setState(1437); ((Comment_on_statementContext)_localctx).operator_name = schema_qualified_name();
				setState(1438); match(LEFT_PAREN);
				setState(1439); ((Comment_on_statementContext)_localctx).left_type = data_type();
				setState(1440); match(COMMA);
				setState(1441); ((Comment_on_statementContext)_localctx).right_type = data_type();
				setState(1442); match(RIGHT_PAREN);
				}
				break;
			case 16:
				{
				setState(1444); match(OPERATOR);
				setState(1445); match(CLASS);
				setState(1446); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				setState(1447); match(USING);
				setState(1448); ((Comment_on_statementContext)_localctx).index_method = identifier();
				}
				break;
			case 17:
				{
				setState(1450); match(OPERATOR);
				setState(1451); match(FAMILY);
				setState(1452); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				setState(1453); match(USING);
				setState(1454); ((Comment_on_statementContext)_localctx).index_method = identifier();
				}
				break;
			case 18:
				{
				setState(1457);
				_la = _input.LA(1);
				if (_la==PROCEDURAL) {
					{
					setState(1456); match(PROCEDURAL);
					}
				}

				setState(1459); match(LANGUAGE);
				setState(1460); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 19:
				{
				setState(1461); match(ROLE);
				setState(1462); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 20:
				{
				setState(1463); match(RULE);
				setState(1464); ((Comment_on_statementContext)_localctx).rule_name = schema_qualified_name();
				setState(1465); match(ON);
				setState(1466); ((Comment_on_statementContext)_localctx).table_name = schema_qualified_name();
				}
				break;
			case 21:
				{
				setState(1468); match(SCHEMA);
				setState(1469); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 22:
				{
				setState(1470); match(SEQUENCE);
				setState(1471); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 23:
				{
				setState(1472); match(SERVER);
				setState(1473); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 24:
				{
				setState(1474); match(TABLE);
				setState(1475); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 25:
				{
				setState(1476); match(TABLESPACE);
				setState(1477); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 26:
				{
				setState(1478); match(TEXT);
				setState(1479); match(SEARCH);
				setState(1480); match(CONFIGURATION);
				setState(1481); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 27:
				{
				setState(1482); match(TEXT);
				setState(1483); match(SEARCH);
				setState(1484); match(DICTIONARY);
				setState(1485); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 28:
				{
				setState(1486); match(TEXT);
				setState(1487); match(SEARCH);
				setState(1488); match(PARSER);
				setState(1489); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 29:
				{
				setState(1490); match(TEXT);
				setState(1491); match(SEARCH);
				setState(1492); match(TEMPLATE);
				setState(1493); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 30:
				{
				setState(1494); match(TRIGGER);
				setState(1495); ((Comment_on_statementContext)_localctx).trigger_name = schema_qualified_name();
				setState(1496); match(ON);
				setState(1497); ((Comment_on_statementContext)_localctx).table_name = schema_qualified_name();
				}
				break;
			case 31:
				{
				setState(1499); match(TYPE);
				setState(1500); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 32:
				{
				setState(1501); match(VIEW);
				setState(1502); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			}
			setState(1505); match(IS);
			setState(1506); match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
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
			setState(1508); match(CREATE);
			setState(1511);
			_la = _input.LA(1);
			if (_la==OR) {
				{
				setState(1509); match(OR);
				setState(1510); match(REPLACE);
				}
			}

			setState(1513); match(FUNCTION);
			setState(1514); ((Create_function_statementContext)_localctx).name = identifier();
			setState(1515); match(LEFT_PAREN);
			setState(1535);
			_la = _input.LA(1);
			if (_la==IN || _la==INOUT || ((((_la - 79)) & ~0x3f) == 0 && ((1L << (_la - 79)) & ((1L << (OUT - 79)) | (1L << (VARIADIC - 79)) | (1L << (ADMIN - 79)) | (1L << (AVG - 79)) | (1L << (BETWEEN - 79)) | (1L << (BY - 79)) | (1L << (CACHE - 79)) | (1L << (CALLED - 79)) | (1L << (CLASS - 79)) | (1L << (CENTURY - 79)) | (1L << (CHARACTER - 79)) | (1L << (CHECK - 79)) | (1L << (COLLECT - 79)) | (1L << (COALESCE - 79)) | (1L << (COLUMN - 79)) | (1L << (COMMENT - 79)) | (1L << (COMMENTS - 79)))) != 0) || ((((_la - 143)) & ~0x3f) == 0 && ((1L << (_la - 143)) & ((1L << (COMMIT - 143)) | (1L << (CONFIGURATION - 143)) | (1L << (COST - 143)) | (1L << (COUNT - 143)) | (1L << (CUBE - 143)) | (1L << (CURRENT - 143)) | (1L << (CYCLE - 143)) | (1L << (DATA - 143)) | (1L << (DAY - 143)) | (1L << (DEC - 143)) | (1L << (DECADE - 143)) | (1L << (DEFINER - 143)) | (1L << (DICTIONARY - 143)) | (1L << (DOW - 143)) | (1L << (DOY - 143)) | (1L << (DROP - 143)) | (1L << (EPOCH - 143)) | (1L << (EVERY - 143)) | (1L << (EXISTS - 143)) | (1L << (EXTERNAL - 143)) | (1L << (EXTRACT - 143)) | (1L << (FAMILY - 143)) | (1L << (FILTER - 143)) | (1L << (FIRST - 143)) | (1L << (FORMAT - 143)) | (1L << (FUSION - 143)) | (1L << (GROUPING - 143)) | (1L << (HASH - 143)) | (1L << (INDEX - 143)) | (1L << (INCREMENT - 143)) | (1L << (INPUT - 143)) | (1L << (INSERT - 143)) | (1L << (INTERSECTION - 143)) | (1L << (ISCACHABLE - 143)) | (1L << (ISODOW - 143)) | (1L << (ISOYEAR - 143)) | (1L << (ISSTRICT - 143)) | (1L << (LANGUAGE - 143)) | (1L << (LARGE - 143)) | (1L << (LAST - 143)) | (1L << (LESS - 143)) | (1L << (LIST - 143)) | (1L << (LOCATION - 143)) | (1L << (MATCH - 143)) | (1L << (MAX - 143)) | (1L << (MAXVALUE - 143)) | (1L << (MICROSECONDS - 143)) | (1L << (MILLENNIUM - 143)) | (1L << (MILLISECONDS - 143)) | (1L << (MIN - 143)) | (1L << (MINVALUE - 143)) | (1L << (MINUTE - 143)) | (1L << (MONTH - 143)) | (1L << (NATIONAL - 143)) | (1L << (NO - 143)) | (1L << (NONE - 143)) | (1L << (NULLIF - 143)) | (1L << (OBJECT - 143)) | (1L << (OPTION - 143)) | (1L << (OPTIONS - 143)) | (1L << (OVERWRITE - 143)) | (1L << (PARSER - 143)))) != 0) || ((((_la - 207)) & ~0x3f) == 0 && ((1L << (_la - 207)) & ((1L << (PARTIAL - 207)) | (1L << (PARTITION - 207)) | (1L << (PARTITIONS - 207)) | (1L << (PRECISION - 207)) | (1L << (PUBLIC - 207)) | (1L << (PURGE - 207)) | (1L << (QUARTER - 207)) | (1L << (RANGE - 207)) | (1L << (REGEXP - 207)) | (1L << (RLIKE - 207)) | (1L << (ROLLUP - 207)) | (1L << (SEARCH - 207)) | (1L << (SECOND - 207)) | (1L << (SECURITY - 207)) | (1L << (SERVER - 207)) | (1L << (SET - 207)) | (1L << (SIMILAR - 207)) | (1L << (SIMPLE - 207)) | (1L << (STABLE - 207)) | (1L << (START - 207)) | (1L << (STORAGE - 207)) | (1L << (STDDEV_POP - 207)) | (1L << (STDDEV_SAMP - 207)) | (1L << (SUBPARTITION - 207)) | (1L << (SUM - 207)) | (1L << (TABLESPACE - 207)) | (1L << (TEMPLATE - 207)) | (1L << (THAN - 207)) | (1L << (TIMEZONE - 207)) | (1L << (TIMEZONE_HOUR - 207)) | (1L << (TIMEZONE_MINUTE - 207)) | (1L << (TRIM - 207)) | (1L << (TO - 207)) | (1L << (UNKNOWN - 207)) | (1L << (UNLOGGED - 207)) | (1L << (VALUES - 207)) | (1L << (VAR_SAMP - 207)) | (1L << (VAR_POP - 207)) | (1L << (VARYING - 207)) | (1L << (VOLATILE - 207)) | (1L << (WEEK - 207)) | (1L << (WINDOW - 207)) | (1L << (WRAPPER - 207)) | (1L << (YEAR - 207)) | (1L << (ZONE - 207)) | (1L << (BOOLEAN - 207)) | (1L << (BOOL - 207)) | (1L << (BIT - 207)) | (1L << (VARBIT - 207)) | (1L << (INT1 - 207)) | (1L << (INT2 - 207)) | (1L << (INT4 - 207)) | (1L << (INT8 - 207)) | (1L << (TINYINT - 207)) | (1L << (SMALLINT - 207)) | (1L << (INT - 207)) | (1L << (INTEGER - 207)) | (1L << (BIGINT - 207)) | (1L << (FLOAT4 - 207)) | (1L << (FLOAT8 - 207)) | (1L << (REAL - 207)) | (1L << (REGCLASS - 207)))) != 0) || ((((_la - 271)) & ~0x3f) == 0 && ((1L << (_la - 271)) & ((1L << (FLOAT - 271)) | (1L << (DOUBLE - 271)) | (1L << (NUMERIC - 271)) | (1L << (DECIMAL - 271)) | (1L << (CHAR - 271)) | (1L << (VARCHAR - 271)) | (1L << (NCHAR - 271)) | (1L << (NVARCHAR - 271)) | (1L << (DATE - 271)) | (1L << (TIME - 271)) | (1L << (TIMETZ - 271)) | (1L << (TIMESTAMP - 271)) | (1L << (TIMESTAMPTZ - 271)) | (1L << (TEXT - 271)) | (1L << (BINARY - 271)) | (1L << (VARBINARY - 271)) | (1L << (BLOB - 271)) | (1L << (BYTEA - 271)) | (1L << (INET4 - 271)) | (1L << (QUOTE - 271)) | (1L << (Identifier - 271)))) != 0)) {
				{
				setState(1517);
				_la = _input.LA(1);
				if (_la==IN || _la==INOUT || _la==OUT || _la==VARIADIC) {
					{
					setState(1516); ((Create_function_statementContext)_localctx).arg_mode = argmode();
					}
				}

				setState(1520);
				switch ( getInterpreter().adaptivePredict(_input,202,_ctx) ) {
				case 1:
					{
					setState(1519); ((Create_function_statementContext)_localctx).argname = identifier();
					}
					break;
				}
				setState(1522); ((Create_function_statementContext)_localctx).argtype = data_type();
				setState(1533);
				_la = _input.LA(1);
				if (_la==DEFAULT || _la==EQUAL) {
					{
					setState(1529); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						setState(1529);
						switch (_input.LA(1)) {
						case DEFAULT:
							{
							setState(1523); match(DEFAULT);
							}
							break;
						case EQUAL:
							{
							setState(1524); match(EQUAL);
							setState(1525); routine_invocation();
							setState(1527);
							_la = _input.LA(1);
							if (_la==COMMA) {
								{
								setState(1526); match(COMMA);
								}
							}

							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						setState(1531); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==DEFAULT || _la==EQUAL );
					}
				}

				}
			}

			setState(1537); match(RIGHT_PAREN);
			setState(1554);
			switch ( getInterpreter().adaptivePredict(_input,210,_ctx) ) {
			case 1:
				{
				setState(1538); match(RETURNS);
				setState(1539); ((Create_function_statementContext)_localctx).rettype = data_type();
				}
				break;
			case 2:
				{
				setState(1540); match(RETURNS);
				setState(1541); match(TABLE);
				setState(1542); match(LEFT_PAREN);
				setState(1548); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1543); ((Create_function_statementContext)_localctx).column_name = identifier();
					setState(1544); ((Create_function_statementContext)_localctx).column_type = data_type();
					setState(1546);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1545); match(COMMA);
						}
					}

					}
					}
					setState(1550); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (ADMIN - 128)) | (1L << (AVG - 128)) | (1L << (BETWEEN - 128)) | (1L << (BY - 128)) | (1L << (CACHE - 128)) | (1L << (CALLED - 128)) | (1L << (CLASS - 128)) | (1L << (CENTURY - 128)) | (1L << (CHARACTER - 128)) | (1L << (CHECK - 128)) | (1L << (COLLECT - 128)) | (1L << (COALESCE - 128)) | (1L << (COLUMN - 128)) | (1L << (COMMENT - 128)) | (1L << (COMMENTS - 128)) | (1L << (COMMIT - 128)) | (1L << (CONFIGURATION - 128)) | (1L << (COST - 128)) | (1L << (COUNT - 128)) | (1L << (CUBE - 128)) | (1L << (CURRENT - 128)) | (1L << (CYCLE - 128)) | (1L << (DATA - 128)) | (1L << (DAY - 128)) | (1L << (DEC - 128)) | (1L << (DECADE - 128)) | (1L << (DEFINER - 128)) | (1L << (DICTIONARY - 128)) | (1L << (DOW - 128)) | (1L << (DOY - 128)) | (1L << (DROP - 128)) | (1L << (EPOCH - 128)) | (1L << (EVERY - 128)) | (1L << (EXISTS - 128)) | (1L << (EXTERNAL - 128)) | (1L << (EXTRACT - 128)) | (1L << (FAMILY - 128)) | (1L << (FILTER - 128)) | (1L << (FIRST - 128)) | (1L << (FORMAT - 128)) | (1L << (FUSION - 128)) | (1L << (GROUPING - 128)) | (1L << (HASH - 128)) | (1L << (INDEX - 128)) | (1L << (INCREMENT - 128)) | (1L << (INPUT - 128)) | (1L << (INSERT - 128)) | (1L << (INTERSECTION - 128)) | (1L << (ISCACHABLE - 128)) | (1L << (ISODOW - 128)) | (1L << (ISOYEAR - 128)) | (1L << (ISSTRICT - 128)) | (1L << (LANGUAGE - 128)) | (1L << (LARGE - 128)) | (1L << (LAST - 128)) | (1L << (LESS - 128)) | (1L << (LIST - 128)) | (1L << (LOCATION - 128)) | (1L << (MATCH - 128)) | (1L << (MAX - 128)) | (1L << (MAXVALUE - 128)) | (1L << (MICROSECONDS - 128)))) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (MILLENNIUM - 192)) | (1L << (MILLISECONDS - 192)) | (1L << (MIN - 192)) | (1L << (MINVALUE - 192)) | (1L << (MINUTE - 192)) | (1L << (MONTH - 192)) | (1L << (NATIONAL - 192)) | (1L << (NO - 192)) | (1L << (NONE - 192)) | (1L << (NULLIF - 192)) | (1L << (OBJECT - 192)) | (1L << (OPTION - 192)) | (1L << (OPTIONS - 192)) | (1L << (OVERWRITE - 192)) | (1L << (PARSER - 192)) | (1L << (PARTIAL - 192)) | (1L << (PARTITION - 192)) | (1L << (PARTITIONS - 192)) | (1L << (PRECISION - 192)) | (1L << (PUBLIC - 192)) | (1L << (PURGE - 192)) | (1L << (QUARTER - 192)) | (1L << (RANGE - 192)) | (1L << (REGEXP - 192)) | (1L << (RLIKE - 192)) | (1L << (ROLLUP - 192)) | (1L << (SEARCH - 192)) | (1L << (SECOND - 192)) | (1L << (SECURITY - 192)) | (1L << (SERVER - 192)) | (1L << (SET - 192)) | (1L << (SIMILAR - 192)) | (1L << (SIMPLE - 192)) | (1L << (STABLE - 192)) | (1L << (START - 192)) | (1L << (STORAGE - 192)) | (1L << (STDDEV_POP - 192)) | (1L << (STDDEV_SAMP - 192)) | (1L << (SUBPARTITION - 192)) | (1L << (SUM - 192)) | (1L << (TABLESPACE - 192)) | (1L << (TEMPLATE - 192)) | (1L << (THAN - 192)) | (1L << (TIMEZONE - 192)) | (1L << (TIMEZONE_HOUR - 192)) | (1L << (TIMEZONE_MINUTE - 192)) | (1L << (TRIM - 192)) | (1L << (TO - 192)) | (1L << (UNKNOWN - 192)) | (1L << (UNLOGGED - 192)) | (1L << (VALUES - 192)) | (1L << (VAR_SAMP - 192)) | (1L << (VAR_POP - 192)) | (1L << (VARYING - 192)) | (1L << (VOLATILE - 192)) | (1L << (WEEK - 192)) | (1L << (WINDOW - 192)) | (1L << (WRAPPER - 192)) | (1L << (YEAR - 192)) | (1L << (ZONE - 192)) | (1L << (BOOLEAN - 192)) | (1L << (BOOL - 192)))) != 0) || ((((_la - 256)) & ~0x3f) == 0 && ((1L << (_la - 256)) & ((1L << (BIT - 256)) | (1L << (VARBIT - 256)) | (1L << (INT1 - 256)) | (1L << (INT2 - 256)) | (1L << (INT4 - 256)) | (1L << (INT8 - 256)) | (1L << (TINYINT - 256)) | (1L << (SMALLINT - 256)) | (1L << (INT - 256)) | (1L << (INTEGER - 256)) | (1L << (BIGINT - 256)) | (1L << (FLOAT4 - 256)) | (1L << (FLOAT8 - 256)) | (1L << (REAL - 256)) | (1L << (FLOAT - 256)) | (1L << (DOUBLE - 256)) | (1L << (NUMERIC - 256)) | (1L << (DECIMAL - 256)) | (1L << (CHAR - 256)) | (1L << (VARCHAR - 256)) | (1L << (NCHAR - 256)) | (1L << (NVARCHAR - 256)) | (1L << (DATE - 256)) | (1L << (TIME - 256)) | (1L << (TIMETZ - 256)) | (1L << (TIMESTAMP - 256)) | (1L << (TIMESTAMPTZ - 256)) | (1L << (TEXT - 256)) | (1L << (VARBINARY - 256)) | (1L << (BLOB - 256)) | (1L << (BYTEA - 256)) | (1L << (INET4 - 256)) | (1L << (QUOTE - 256)))) != 0) || _la==Identifier );
				setState(1552); match(RIGHT_PAREN);
				}
				break;
			}
			setState(1602); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(1602);
					switch ( getInterpreter().adaptivePredict(_input,214,_ctx) ) {
					case 1:
						{
						setState(1556); match(LANGUAGE);
						setState(1557); ((Create_function_statementContext)_localctx).lang_name = identifier();
						}
						break;
					case 2:
						{
						setState(1558); match(WINDOW);
						}
						break;
					case 3:
						{
						setState(1559); match(IMMUTABLE);
						}
						break;
					case 4:
						{
						setState(1560); match(STABLE);
						}
						break;
					case 5:
						{
						setState(1561); match(VOLATILE);
						}
						break;
					case 6:
						{
						setState(1562); match(CALLED);
						setState(1563); match(ON);
						setState(1564); match(NULL);
						setState(1565); match(INPUT);
						}
						break;
					case 7:
						{
						setState(1566); match(RETURNS);
						setState(1567); match(NULL);
						setState(1568); match(ON);
						setState(1569); match(NULL);
						setState(1570); match(INPUT);
						}
						break;
					case 8:
						{
						setState(1571); match(STRICT);
						}
						break;
					case 9:
						{
						setState(1573);
						_la = _input.LA(1);
						if (_la==EXTERNAL) {
							{
							setState(1572); match(EXTERNAL);
							}
						}

						setState(1575); match(SECURITY);
						setState(1576); match(INVOKER);
						}
						break;
					case 10:
						{
						setState(1578);
						_la = _input.LA(1);
						if (_la==EXTERNAL) {
							{
							setState(1577); match(EXTERNAL);
							}
						}

						setState(1580); match(SECURITY);
						setState(1581); match(DEFINER);
						}
						break;
					case 11:
						{
						setState(1582); match(COST);
						setState(1583); ((Create_function_statementContext)_localctx).execution_cost = match(NUMBER);
						}
						break;
					case 12:
						{
						setState(1584); match(ROWS);
						setState(1585); ((Create_function_statementContext)_localctx).result_rows = match(NUMBER);
						}
						break;
					case 13:
						{
						setState(1586); match(SET);
						setState(1587); ((Create_function_statementContext)_localctx).configuration_parameter = identifier();
						setState(1594);
						switch (_input.LA(1)) {
						case TO:
							{
							setState(1588); match(TO);
							setState(1589); ((Create_function_statementContext)_localctx).value = match(Character_String_Literal);
							}
							break;
						case EQUAL:
							{
							setState(1590); match(EQUAL);
							setState(1591); ((Create_function_statementContext)_localctx).value = match(Character_String_Literal);
							}
							break;
						case FROM:
							{
							setState(1592); match(FROM);
							setState(1593); match(CURRENT);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						break;
					case 14:
						{
						setState(1596); match(AS);
						setState(1597); function_body();
						}
						break;
					case 15:
						{
						setState(1598); match(AS);
						setState(1599); match(Character_String_Literal);
						setState(1600); match(COMMA);
						setState(1601); match(Character_String_Literal);
						}
						break;
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1604); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,215,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(1618);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(1606); match(WITH);
				setState(1607); match(LEFT_PAREN);
				setState(1612); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1608); ((Create_function_statementContext)_localctx).attribute = function_attribute();
					setState(1610);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1609); match(COMMA);
						}
					}

					}
					}
					setState(1614); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==ISCACHABLE || _la==ISSTRICT );
				setState(1616); match(RIGHT_PAREN);
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
			setState(1620); match(DOUBLE_DOLLAR);
			setState(1624);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AGGREGATE) | (1L << AFTER) | (1L << AS) | (1L << ALL) | (1L << AND) | (1L << ANY) | (1L << ASYMMETRIC) | (1L << ASC) | (1L << BEFORE) | (1L << BOTH) | (1L << CASE) | (1L << CASCADE) | (1L << CAST) | (1L << COLLATE) | (1L << COLLATION) | (1L << CONNECT) | (1L << CONSTRAINT) | (1L << CONSTRAINTS) | (1L << CONVERSION) | (1L << CREATE) | (1L << CROSS) | (1L << DATABASE) | (1L << DEFAULT) | (1L << DEFAULTS) | (1L << DEFERRABLE) | (1L << DEFERRED) | (1L << DELETE) | (1L << DESC) | (1L << DISTINCT) | (1L << DOMAIN) | (1L << EACH) | (1L << END) | (1L << ELSE) | (1L << EXCEPT) | (1L << EXCLUDE) | (1L << EXCLUDING) | (1L << EXECUTE) | (1L << EXTENSION) | (1L << FALSE) | (1L << FOR) | (1L << FOREIGN) | (1L << FULL) | (1L << FUNCTION) | (1L << FUNCTIONS) | (1L << FROM) | (1L << GLOBAL) | (1L << GRANT) | (1L << GROUP) | (1L << HAVING) | (1L << IF) | (1L << ILIKE) | (1L << IMMEDIATE) | (1L << IMMUTABLE) | (1L << IN) | (1L << INCLUDING) | (1L << INHERITS) | (1L << INITIALLY) | (1L << INNER) | (1L << INTERSECT) | (1L << INTO) | (1L << INOUT) | (1L << INSTEAD) | (1L << INVOKER))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (IS - 64)) | (1L << (JOIN - 64)) | (1L << (KEY - 64)) | (1L << (LEADING - 64)) | (1L << (LEFT - 64)) | (1L << (LIKE - 64)) | (1L << (LIMIT - 64)) | (1L << (LOCAL - 64)) | (1L << (NATURAL - 64)) | (1L << (NOT - 64)) | (1L << (NULL - 64)) | (1L << (OF - 64)) | (1L << (OIDS - 64)) | (1L << (ON - 64)) | (1L << (OUTER - 64)) | (1L << (OUT - 64)) | (1L << (OPERATOR - 64)) | (1L << (OR - 64)) | (1L << (ORDER - 64)) | (1L << (OWNED - 64)) | (1L << (PRESERVE - 64)) | (1L << (PRIMARY - 64)) | (1L << (PRIVILEGES - 64)) | (1L << (PROCEDURE - 64)) | (1L << (PROCEDURAL - 64)) | (1L << (ROLE - 64)) | (1L << (ROW - 64)) | (1L << (ROWS - 64)) | (1L << (REFERENCES - 64)) | (1L << (REPLACE - 64)) | (1L << (RESTRICT - 64)) | (1L << (RETURNS - 64)) | (1L << (REVOKE - 64)) | (1L << (RIGHT - 64)) | (1L << (RULE - 64)) | (1L << (SCHEMA - 64)) | (1L << (SEQUENCE - 64)) | (1L << (SEQUENCES - 64)) | (1L << (SELECT - 64)) | (1L << (SESSION - 64)) | (1L << (SOME - 64)) | (1L << (STATEMENT - 64)) | (1L << (STRICT - 64)) | (1L << (SYMMETRIC - 64)) | (1L << (TABLE - 64)) | (1L << (TEMP - 64)) | (1L << (TEMPORARY - 64)) | (1L << (THEN - 64)) | (1L << (TRAILING - 64)) | (1L << (TRIGGER - 64)) | (1L << (TRUE - 64)) | (1L << (TRUNCATE - 64)) | (1L << (TYPE - 64)) | (1L << (UNION - 64)) | (1L << (UNIQUE - 64)) | (1L << (UPDATE - 64)) | (1L << (USAGE - 64)) | (1L << (USING - 64)) | (1L << (VARIADIC - 64)) | (1L << (VIEW - 64)) | (1L << (WHEN - 64)) | (1L << (WHERE - 64)) | (1L << (WITH - 64)) | (1L << (WITHOUT - 64)))) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (ADMIN - 128)) | (1L << (AVG - 128)) | (1L << (BETWEEN - 128)) | (1L << (BY - 128)) | (1L << (CACHE - 128)) | (1L << (CALLED - 128)) | (1L << (CLASS - 128)) | (1L << (CENTURY - 128)) | (1L << (CHARACTER - 128)) | (1L << (CHECK - 128)) | (1L << (COLLECT - 128)) | (1L << (COALESCE - 128)) | (1L << (COLUMN - 128)) | (1L << (COMMENT - 128)) | (1L << (COMMENTS - 128)) | (1L << (COMMIT - 128)) | (1L << (CONFIGURATION - 128)) | (1L << (COST - 128)) | (1L << (COUNT - 128)) | (1L << (CUBE - 128)) | (1L << (CURRENT - 128)) | (1L << (CYCLE - 128)) | (1L << (DATA - 128)) | (1L << (DAY - 128)) | (1L << (DEC - 128)) | (1L << (DECADE - 128)) | (1L << (DEFINER - 128)) | (1L << (DICTIONARY - 128)) | (1L << (DOW - 128)) | (1L << (DOY - 128)) | (1L << (DROP - 128)) | (1L << (EPOCH - 128)) | (1L << (EVERY - 128)) | (1L << (EXISTS - 128)) | (1L << (EXTERNAL - 128)) | (1L << (EXTRACT - 128)) | (1L << (FAMILY - 128)) | (1L << (FILTER - 128)) | (1L << (FIRST - 128)) | (1L << (FORMAT - 128)) | (1L << (FUSION - 128)) | (1L << (GROUPING - 128)) | (1L << (HASH - 128)) | (1L << (HOUR - 128)) | (1L << (INDEX - 128)) | (1L << (INDEXES - 128)) | (1L << (INCREMENT - 128)) | (1L << (INPUT - 128)) | (1L << (INSERT - 128)) | (1L << (INTERSECTION - 128)) | (1L << (ISCACHABLE - 128)) | (1L << (ISODOW - 128)) | (1L << (ISOYEAR - 128)) | (1L << (ISSTRICT - 128)) | (1L << (LANGUAGE - 128)) | (1L << (LARGE - 128)) | (1L << (LAST - 128)) | (1L << (LESS - 128)) | (1L << (LIST - 128)) | (1L << (LOCATION - 128)) | (1L << (MATCH - 128)) | (1L << (MAX - 128)) | (1L << (MAXVALUE - 128)) | (1L << (MICROSECONDS - 128)))) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (MILLENNIUM - 192)) | (1L << (MILLISECONDS - 192)) | (1L << (MIN - 192)) | (1L << (MINVALUE - 192)) | (1L << (MINUTE - 192)) | (1L << (MONTH - 192)) | (1L << (NATIONAL - 192)) | (1L << (NO - 192)) | (1L << (NONE - 192)) | (1L << (NULLIF - 192)) | (1L << (OBJECT - 192)) | (1L << (OPTION - 192)) | (1L << (OPTIONS - 192)) | (1L << (OVERWRITE - 192)) | (1L << (PARSER - 192)) | (1L << (PARTIAL - 192)) | (1L << (PARTITION - 192)) | (1L << (PARTITIONS - 192)) | (1L << (PRECISION - 192)) | (1L << (PUBLIC - 192)) | (1L << (PURGE - 192)) | (1L << (QUARTER - 192)) | (1L << (RANGE - 192)) | (1L << (REGEXP - 192)) | (1L << (RLIKE - 192)) | (1L << (ROLLUP - 192)) | (1L << (SEARCH - 192)) | (1L << (SECOND - 192)) | (1L << (SECURITY - 192)) | (1L << (SERVER - 192)) | (1L << (SET - 192)) | (1L << (SIMILAR - 192)) | (1L << (SIMPLE - 192)) | (1L << (STABLE - 192)) | (1L << (START - 192)) | (1L << (STORAGE - 192)) | (1L << (STDDEV_POP - 192)) | (1L << (STDDEV_SAMP - 192)) | (1L << (SUBPARTITION - 192)) | (1L << (SUM - 192)) | (1L << (TABLESPACE - 192)) | (1L << (TABLES - 192)) | (1L << (TEMPLATE - 192)) | (1L << (THAN - 192)) | (1L << (TIMEZONE - 192)) | (1L << (TIMEZONE_HOUR - 192)) | (1L << (TIMEZONE_MINUTE - 192)) | (1L << (TRIM - 192)) | (1L << (TO - 192)) | (1L << (UNKNOWN - 192)) | (1L << (UNLOGGED - 192)) | (1L << (VALUES - 192)) | (1L << (VAR_SAMP - 192)) | (1L << (VAR_POP - 192)) | (1L << (VARYING - 192)) | (1L << (VERSION - 192)) | (1L << (VOLATILE - 192)) | (1L << (WEEK - 192)) | (1L << (WINDOW - 192)) | (1L << (WRAPPER - 192)) | (1L << (YEAR - 192)) | (1L << (ZONE - 192)) | (1L << (BOOLEAN - 192)) | (1L << (BOOL - 192)))) != 0) || ((((_la - 256)) & ~0x3f) == 0 && ((1L << (_la - 256)) & ((1L << (BIT - 256)) | (1L << (VARBIT - 256)) | (1L << (INT1 - 256)) | (1L << (INT2 - 256)) | (1L << (INT4 - 256)) | (1L << (INT8 - 256)) | (1L << (TINYINT - 256)) | (1L << (SMALLINT - 256)) | (1L << (INT - 256)) | (1L << (INTEGER - 256)) | (1L << (BIGINT - 256)) | (1L << (FLOAT4 - 256)) | (1L << (FLOAT8 - 256)) | (1L << (REAL - 256)) | (1L << (REGCLASS - 256)) | (1L << (FLOAT - 256)) | (1L << (DOUBLE - 256)) | (1L << (NUMERIC - 256)) | (1L << (DECIMAL - 256)) | (1L << (CHAR - 256)) | (1L << (VARCHAR - 256)) | (1L << (NCHAR - 256)) | (1L << (NVARCHAR - 256)) | (1L << (DATE - 256)) | (1L << (TIME - 256)) | (1L << (TIMETZ - 256)) | (1L << (TIMESTAMP - 256)) | (1L << (TIMESTAMPTZ - 256)) | (1L << (TEXT - 256)) | (1L << (BINARY - 256)) | (1L << (VARBINARY - 256)) | (1L << (BLOB - 256)) | (1L << (BYTEA - 256)) | (1L << (INET4 - 256)) | (1L << (Similar_To - 256)) | (1L << (Not_Similar_To - 256)) | (1L << (Similar_To_Case_Insensitive - 256)) | (1L << (Not_Similar_To_Case_Insensitive - 256)) | (1L << (CAST_EXPRESSION - 256)) | (1L << (ASSIGN - 256)) | (1L << (EQUAL - 256)) | (1L << (COLON - 256)) | (1L << (SEMI_COLON - 256)) | (1L << (COMMA - 256)) | (1L << (CONCATENATION_OPERATOR - 256)) | (1L << (NOT_EQUAL - 256)) | (1L << (LTH - 256)) | (1L << (LEQ - 256)) | (1L << (GTH - 256)) | (1L << (GEQ - 256)) | (1L << (LEFT_PAREN - 256)) | (1L << (RIGHT_PAREN - 256)) | (1L << (PLUS - 256)) | (1L << (MINUS - 256)) | (1L << (MULTIPLY - 256)) | (1L << (DIVIDE - 256)) | (1L << (MODULAR - 256)) | (1L << (DOT - 256)) | (1L << (UNDERLINE - 256)) | (1L << (VERTICAL_BAR - 256)) | (1L << (QUOTE - 256)) | (1L << (DOUBLE_QUOTE - 256)) | (1L << (DOLLAR - 256)))) != 0) || ((((_la - 320)) & ~0x3f) == 0 && ((1L << (_la - 320)) & ((1L << (NUMBER - 320)) | (1L << (REAL_NUMBER - 320)) | (1L << (BlockComment - 320)) | (1L << (LineComment - 320)) | (1L << (Identifier - 320)) | (1L << (Character_String_Literal - 320)) | (1L << (ESC_SEQUENCES - 320)) | (1L << (Space - 320)) | (1L << (White_Space - 320)) | (1L << (BAD - 320)))) != 0)) {
				{
				{
				setState(1621);
				_la = _input.LA(1);
				if ( _la <= 0 || (_la==DOUBLE_DOLLAR) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				}
				setState(1626);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1627); match(DOUBLE_DOLLAR);
			}
		}
		catch (RecognitionException re) {
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
			setState(1629);
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
			setState(1631);
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
			setState(1633); match(FUNCTION);
			setState(1634); ((Function_definitionContext)_localctx).func_name = identifier();
			setState(1635); match(LEFT_PAREN);
			setState(1648);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IN || _la==INOUT || ((((_la - 79)) & ~0x3f) == 0 && ((1L << (_la - 79)) & ((1L << (OUT - 79)) | (1L << (VARIADIC - 79)) | (1L << (ADMIN - 79)) | (1L << (AVG - 79)) | (1L << (BETWEEN - 79)) | (1L << (BY - 79)) | (1L << (CACHE - 79)) | (1L << (CALLED - 79)) | (1L << (CLASS - 79)) | (1L << (CENTURY - 79)) | (1L << (CHARACTER - 79)) | (1L << (CHECK - 79)) | (1L << (COLLECT - 79)) | (1L << (COALESCE - 79)) | (1L << (COLUMN - 79)) | (1L << (COMMENT - 79)) | (1L << (COMMENTS - 79)))) != 0) || ((((_la - 143)) & ~0x3f) == 0 && ((1L << (_la - 143)) & ((1L << (COMMIT - 143)) | (1L << (CONFIGURATION - 143)) | (1L << (COST - 143)) | (1L << (COUNT - 143)) | (1L << (CUBE - 143)) | (1L << (CURRENT - 143)) | (1L << (CYCLE - 143)) | (1L << (DATA - 143)) | (1L << (DAY - 143)) | (1L << (DEC - 143)) | (1L << (DECADE - 143)) | (1L << (DEFINER - 143)) | (1L << (DICTIONARY - 143)) | (1L << (DOW - 143)) | (1L << (DOY - 143)) | (1L << (DROP - 143)) | (1L << (EPOCH - 143)) | (1L << (EVERY - 143)) | (1L << (EXISTS - 143)) | (1L << (EXTERNAL - 143)) | (1L << (EXTRACT - 143)) | (1L << (FAMILY - 143)) | (1L << (FILTER - 143)) | (1L << (FIRST - 143)) | (1L << (FORMAT - 143)) | (1L << (FUSION - 143)) | (1L << (GROUPING - 143)) | (1L << (HASH - 143)) | (1L << (INDEX - 143)) | (1L << (INCREMENT - 143)) | (1L << (INPUT - 143)) | (1L << (INSERT - 143)) | (1L << (INTERSECTION - 143)) | (1L << (ISCACHABLE - 143)) | (1L << (ISODOW - 143)) | (1L << (ISOYEAR - 143)) | (1L << (ISSTRICT - 143)) | (1L << (LANGUAGE - 143)) | (1L << (LARGE - 143)) | (1L << (LAST - 143)) | (1L << (LESS - 143)) | (1L << (LIST - 143)) | (1L << (LOCATION - 143)) | (1L << (MATCH - 143)) | (1L << (MAX - 143)) | (1L << (MAXVALUE - 143)) | (1L << (MICROSECONDS - 143)) | (1L << (MILLENNIUM - 143)) | (1L << (MILLISECONDS - 143)) | (1L << (MIN - 143)) | (1L << (MINVALUE - 143)) | (1L << (MINUTE - 143)) | (1L << (MONTH - 143)) | (1L << (NATIONAL - 143)) | (1L << (NO - 143)) | (1L << (NONE - 143)) | (1L << (NULLIF - 143)) | (1L << (OBJECT - 143)) | (1L << (OPTION - 143)) | (1L << (OPTIONS - 143)) | (1L << (OVERWRITE - 143)) | (1L << (PARSER - 143)))) != 0) || ((((_la - 207)) & ~0x3f) == 0 && ((1L << (_la - 207)) & ((1L << (PARTIAL - 207)) | (1L << (PARTITION - 207)) | (1L << (PARTITIONS - 207)) | (1L << (PRECISION - 207)) | (1L << (PUBLIC - 207)) | (1L << (PURGE - 207)) | (1L << (QUARTER - 207)) | (1L << (RANGE - 207)) | (1L << (REGEXP - 207)) | (1L << (RLIKE - 207)) | (1L << (ROLLUP - 207)) | (1L << (SEARCH - 207)) | (1L << (SECOND - 207)) | (1L << (SECURITY - 207)) | (1L << (SERVER - 207)) | (1L << (SET - 207)) | (1L << (SIMILAR - 207)) | (1L << (SIMPLE - 207)) | (1L << (STABLE - 207)) | (1L << (START - 207)) | (1L << (STORAGE - 207)) | (1L << (STDDEV_POP - 207)) | (1L << (STDDEV_SAMP - 207)) | (1L << (SUBPARTITION - 207)) | (1L << (SUM - 207)) | (1L << (TABLESPACE - 207)) | (1L << (TEMPLATE - 207)) | (1L << (THAN - 207)) | (1L << (TIMEZONE - 207)) | (1L << (TIMEZONE_HOUR - 207)) | (1L << (TIMEZONE_MINUTE - 207)) | (1L << (TRIM - 207)) | (1L << (TO - 207)) | (1L << (UNKNOWN - 207)) | (1L << (UNLOGGED - 207)) | (1L << (VALUES - 207)) | (1L << (VAR_SAMP - 207)) | (1L << (VAR_POP - 207)) | (1L << (VARYING - 207)) | (1L << (VOLATILE - 207)) | (1L << (WEEK - 207)) | (1L << (WINDOW - 207)) | (1L << (WRAPPER - 207)) | (1L << (YEAR - 207)) | (1L << (ZONE - 207)) | (1L << (BOOLEAN - 207)) | (1L << (BOOL - 207)) | (1L << (BIT - 207)) | (1L << (VARBIT - 207)) | (1L << (INT1 - 207)) | (1L << (INT2 - 207)) | (1L << (INT4 - 207)) | (1L << (INT8 - 207)) | (1L << (TINYINT - 207)) | (1L << (SMALLINT - 207)) | (1L << (INT - 207)) | (1L << (INTEGER - 207)) | (1L << (BIGINT - 207)) | (1L << (FLOAT4 - 207)) | (1L << (FLOAT8 - 207)) | (1L << (REAL - 207)) | (1L << (REGCLASS - 207)))) != 0) || ((((_la - 271)) & ~0x3f) == 0 && ((1L << (_la - 271)) & ((1L << (FLOAT - 271)) | (1L << (DOUBLE - 271)) | (1L << (NUMERIC - 271)) | (1L << (DECIMAL - 271)) | (1L << (CHAR - 271)) | (1L << (VARCHAR - 271)) | (1L << (NCHAR - 271)) | (1L << (NVARCHAR - 271)) | (1L << (DATE - 271)) | (1L << (TIME - 271)) | (1L << (TIMETZ - 271)) | (1L << (TIMESTAMP - 271)) | (1L << (TIMESTAMPTZ - 271)) | (1L << (TEXT - 271)) | (1L << (BINARY - 271)) | (1L << (VARBINARY - 271)) | (1L << (BLOB - 271)) | (1L << (BYTEA - 271)) | (1L << (INET4 - 271)) | (1L << (QUOTE - 271)) | (1L << (Identifier - 271)))) != 0)) {
				{
				{
				setState(1637);
				_la = _input.LA(1);
				if (_la==IN || _la==INOUT || _la==OUT || _la==VARIADIC) {
					{
					setState(1636); ((Function_definitionContext)_localctx).arg_mode = argmode();
					}
				}

				setState(1640);
				switch ( getInterpreter().adaptivePredict(_input,221,_ctx) ) {
				case 1:
					{
					setState(1639); ((Function_definitionContext)_localctx).argname = identifier();
					}
					break;
				}
				setState(1642); ((Function_definitionContext)_localctx).argtype = data_type();
				setState(1644);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(1643); match(COMMA);
					}
				}

				}
				}
				setState(1650);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1651); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
			setState(1653); match(ALL);
			setState(1654); match(FUNCTIONS);
			setState(1655); match(IN);
			setState(1656); match(SCHEMA);
			setState(1661); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(1657); ((Functions_definition_schemaContext)_localctx).schema_name = identifier();
					setState(1659);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1658); match(COMMA);
						}
					}

					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1663); 
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
		public TerminalNode BY(int i) {
			return getToken(SQLParser.BY, i);
		}
		public TerminalNode CREATE() { return getToken(SQLParser.CREATE, 0); }
		public TerminalNode TEMPORARY() { return getToken(SQLParser.TEMPORARY, 0); }
		public TerminalNode WITH() { return getToken(SQLParser.WITH, 0); }
		public List<TerminalNode> NO() { return getTokens(SQLParser.NO); }
		public TerminalNode OWNED() { return getToken(SQLParser.OWNED, 0); }
		public TerminalNode MAXVALUE() { return getToken(SQLParser.MAXVALUE, 0); }
		public TerminalNode SEQUENCE() { return getToken(SQLParser.SEQUENCE, 0); }
		public TerminalNode INCREMENT() { return getToken(SQLParser.INCREMENT, 0); }
		public TerminalNode NONE() { return getToken(SQLParser.NONE, 0); }
		public TerminalNode START() { return getToken(SQLParser.START, 0); }
		public TerminalNode MINVALUE() { return getToken(SQLParser.MINVALUE, 0); }
		public List<TerminalNode> BY() { return getTokens(SQLParser.BY); }
		public TerminalNode NUMBER(int i) {
			return getToken(SQLParser.NUMBER, i);
		}
		public Numeric_typeContext numeric_type() {
			return getRuleContext(Numeric_typeContext.class,0);
		}
		public TerminalNode CYCLE() { return getToken(SQLParser.CYCLE, 0); }
		public TerminalNode TEMP() { return getToken(SQLParser.TEMP, 0); }
		public Schema_qualified_nameContext schema_qualified_name(int i) {
			return getRuleContext(Schema_qualified_nameContext.class,i);
		}
		public List<TerminalNode> NUMBER() { return getTokens(SQLParser.NUMBER); }
		public TerminalNode NO(int i) {
			return getToken(SQLParser.NO, i);
		}
		public TerminalNode CACHE() { return getToken(SQLParser.CACHE, 0); }
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
			enterOuterAlt(_localctx, 1);
			{
			setState(1665); match(CREATE);
			setState(1667);
			_la = _input.LA(1);
			if (_la==TEMP || _la==TEMPORARY) {
				{
				setState(1666);
				_la = _input.LA(1);
				if ( !(_la==TEMP || _la==TEMPORARY) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(1669); match(SEQUENCE);
			setState(1670); ((Create_sequence_statementContext)_localctx).name = schema_qualified_name();
			setState(1676);
			switch ( getInterpreter().adaptivePredict(_input,228,_ctx) ) {
			case 1:
				{
				setState(1671); match(INCREMENT);
				setState(1673);
				_la = _input.LA(1);
				if (_la==BY) {
					{
					setState(1672); match(BY);
					}
				}

				setState(1675); ((Create_sequence_statementContext)_localctx).incr = match(NUMBER);
				}
				break;
			}
			setState(1682);
			switch ( getInterpreter().adaptivePredict(_input,229,_ctx) ) {
			case 1:
				{
				setState(1678); match(MINVALUE);
				setState(1679); ((Create_sequence_statementContext)_localctx).minval = match(NUMBER);
				}
				break;
			case 2:
				{
				setState(1680); match(NO);
				setState(1681); match(MINVALUE);
				}
				break;
			}
			setState(1688);
			switch ( getInterpreter().adaptivePredict(_input,230,_ctx) ) {
			case 1:
				{
				setState(1684); match(MAXVALUE);
				setState(1685); ((Create_sequence_statementContext)_localctx).maxval = numeric_type();
				}
				break;
			case 2:
				{
				setState(1686); match(NO);
				setState(1687); match(MAXVALUE);
				}
				break;
			}
			setState(1695);
			switch ( getInterpreter().adaptivePredict(_input,232,_ctx) ) {
			case 1:
				{
				setState(1690); match(START);
				setState(1692);
				_la = _input.LA(1);
				if (_la==WITH) {
					{
					setState(1691); match(WITH);
					}
				}

				setState(1694); ((Create_sequence_statementContext)_localctx).start_val = match(NUMBER);
				}
				break;
			}
			setState(1699);
			switch ( getInterpreter().adaptivePredict(_input,233,_ctx) ) {
			case 1:
				{
				setState(1697); match(CACHE);
				setState(1698); ((Create_sequence_statementContext)_localctx).cache_val = match(NUMBER);
				}
				break;
			}
			setState(1705);
			switch ( getInterpreter().adaptivePredict(_input,235,_ctx) ) {
			case 1:
				{
				setState(1702);
				_la = _input.LA(1);
				if (_la==NO) {
					{
					setState(1701); match(NO);
					}
				}

				setState(1704); match(CYCLE);
				}
				break;
			}
			setState(1713);
			_la = _input.LA(1);
			if (_la==OWNED) {
				{
				setState(1707); match(OWNED);
				setState(1708); match(BY);
				setState(1711);
				switch ( getInterpreter().adaptivePredict(_input,236,_ctx) ) {
				case 1:
					{
					setState(1709); ((Create_sequence_statementContext)_localctx).col_name = schema_qualified_name();
					}
					break;
				case 2:
					{
					setState(1710); match(NONE);
					}
					break;
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
		enterRule(_localctx, 42, RULE_create_table_statement);
		int _la;
		try {
			int _alt;
			setState(1877);
			switch ( getInterpreter().adaptivePredict(_input,268,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1715); match(CREATE);
				setState(1716); match(EXTERNAL);
				setState(1717); match(TABLE);
				setState(1718); ((Create_table_statementContext)_localctx).n = schema_qualified_name();
				setState(1719); table_elements();
				setState(1720); match(USING);
				setState(1721); ((Create_table_statementContext)_localctx).file_type = identifier();
				setState(1723);
				_la = _input.LA(1);
				if (_la==WITH) {
					{
					setState(1722); param_clause();
					}
				}

				setState(1726);
				_la = _input.LA(1);
				if (_la==PARTITION) {
					{
					setState(1725); table_partitioning_clauses();
					}
				}

				{
				setState(1728); match(LOCATION);
				setState(1729); ((Create_table_statementContext)_localctx).path = match(Character_String_Literal);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1731); match(CREATE);
				setState(1732); match(TABLE);
				setState(1733); ((Create_table_statementContext)_localctx).n = schema_qualified_name();
				setState(1734); table_elements();
				setState(1737);
				_la = _input.LA(1);
				if (_la==USING) {
					{
					setState(1735); match(USING);
					setState(1736); ((Create_table_statementContext)_localctx).file_type = identifier();
					}
				}

				setState(1740);
				_la = _input.LA(1);
				if (_la==WITH) {
					{
					setState(1739); param_clause();
					}
				}

				setState(1743);
				switch ( getInterpreter().adaptivePredict(_input,242,_ctx) ) {
				case 1:
					{
					setState(1742); table_partitioning_clauses();
					}
					break;
				}
				setState(1747);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(1745); match(AS);
					setState(1746); query_expression();
					}
				}

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1749); match(CREATE);
				setState(1750); match(TABLE);
				setState(1751); ((Create_table_statementContext)_localctx).n = schema_qualified_name();
				setState(1754);
				_la = _input.LA(1);
				if (_la==USING) {
					{
					setState(1752); match(USING);
					setState(1753); ((Create_table_statementContext)_localctx).file_type = identifier();
					}
				}

				setState(1757);
				_la = _input.LA(1);
				if (_la==WITH) {
					{
					setState(1756); param_clause();
					}
				}

				setState(1760);
				_la = _input.LA(1);
				if (_la==PARTITION) {
					{
					setState(1759); table_partitioning_clauses();
					}
				}

				setState(1762); match(AS);
				setState(1763); query_expression();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1765); match(CREATE);
				setState(1771);
				switch (_input.LA(1)) {
				case GLOBAL:
				case LOCAL:
				case TEMP:
				case TEMPORARY:
					{
					setState(1767);
					_la = _input.LA(1);
					if (_la==GLOBAL || _la==LOCAL) {
						{
						setState(1766);
						_la = _input.LA(1);
						if ( !(_la==GLOBAL || _la==LOCAL) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
					}

					setState(1769);
					_la = _input.LA(1);
					if ( !(_la==TEMP || _la==TEMPORARY) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
					break;
				case UNLOGGED:
					{
					setState(1770); match(UNLOGGED);
					}
					break;
				case TABLE:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1773); match(TABLE);
				setState(1777);
				_la = _input.LA(1);
				if (_la==IF) {
					{
					setState(1774); match(IF);
					setState(1775); match(NOT);
					setState(1776); match(EXISTS);
					}
				}

				setState(1779); ((Create_table_statementContext)_localctx).n = schema_qualified_name();
				setState(1780); match(LEFT_PAREN);
				setState(1811);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CONSTRAINT) | (1L << EXCLUDE) | (1L << FOREIGN))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (LIKE - 69)) | (1L << (PRIMARY - 69)) | (1L << (UNIQUE - 69)) | (1L << (ADMIN - 69)) | (1L << (AVG - 69)) | (1L << (BETWEEN - 69)) | (1L << (BY - 69)) | (1L << (CACHE - 69)))) != 0) || ((((_la - 133)) & ~0x3f) == 0 && ((1L << (_la - 133)) & ((1L << (CALLED - 133)) | (1L << (CLASS - 133)) | (1L << (CENTURY - 133)) | (1L << (CHARACTER - 133)) | (1L << (CHECK - 133)) | (1L << (COLLECT - 133)) | (1L << (COALESCE - 133)) | (1L << (COLUMN - 133)) | (1L << (COMMENT - 133)) | (1L << (COMMENTS - 133)) | (1L << (COMMIT - 133)) | (1L << (CONFIGURATION - 133)) | (1L << (COST - 133)) | (1L << (COUNT - 133)) | (1L << (CUBE - 133)) | (1L << (CURRENT - 133)) | (1L << (CYCLE - 133)) | (1L << (DATA - 133)) | (1L << (DAY - 133)) | (1L << (DEC - 133)) | (1L << (DECADE - 133)) | (1L << (DEFINER - 133)) | (1L << (DICTIONARY - 133)) | (1L << (DOW - 133)) | (1L << (DOY - 133)) | (1L << (DROP - 133)) | (1L << (EPOCH - 133)) | (1L << (EVERY - 133)) | (1L << (EXISTS - 133)) | (1L << (EXTERNAL - 133)) | (1L << (EXTRACT - 133)) | (1L << (FAMILY - 133)) | (1L << (FILTER - 133)) | (1L << (FIRST - 133)) | (1L << (FORMAT - 133)) | (1L << (FUSION - 133)) | (1L << (GROUPING - 133)) | (1L << (HASH - 133)) | (1L << (INDEX - 133)) | (1L << (INCREMENT - 133)) | (1L << (INPUT - 133)) | (1L << (INSERT - 133)) | (1L << (INTERSECTION - 133)) | (1L << (ISCACHABLE - 133)) | (1L << (ISODOW - 133)) | (1L << (ISOYEAR - 133)) | (1L << (ISSTRICT - 133)) | (1L << (LANGUAGE - 133)) | (1L << (LARGE - 133)) | (1L << (LAST - 133)) | (1L << (LESS - 133)) | (1L << (LIST - 133)) | (1L << (LOCATION - 133)) | (1L << (MATCH - 133)) | (1L << (MAX - 133)) | (1L << (MAXVALUE - 133)) | (1L << (MICROSECONDS - 133)) | (1L << (MILLENNIUM - 133)) | (1L << (MILLISECONDS - 133)) | (1L << (MIN - 133)) | (1L << (MINVALUE - 133)) | (1L << (MINUTE - 133)))) != 0) || ((((_la - 197)) & ~0x3f) == 0 && ((1L << (_la - 197)) & ((1L << (MONTH - 197)) | (1L << (NATIONAL - 197)) | (1L << (NO - 197)) | (1L << (NONE - 197)) | (1L << (NULLIF - 197)) | (1L << (OBJECT - 197)) | (1L << (OPTION - 197)) | (1L << (OPTIONS - 197)) | (1L << (OVERWRITE - 197)) | (1L << (PARSER - 197)) | (1L << (PARTIAL - 197)) | (1L << (PARTITION - 197)) | (1L << (PARTITIONS - 197)) | (1L << (PRECISION - 197)) | (1L << (PUBLIC - 197)) | (1L << (PURGE - 197)) | (1L << (QUARTER - 197)) | (1L << (RANGE - 197)) | (1L << (REGEXP - 197)) | (1L << (RLIKE - 197)) | (1L << (ROLLUP - 197)) | (1L << (SEARCH - 197)) | (1L << (SECOND - 197)) | (1L << (SECURITY - 197)) | (1L << (SERVER - 197)) | (1L << (SET - 197)) | (1L << (SIMILAR - 197)) | (1L << (SIMPLE - 197)) | (1L << (STABLE - 197)) | (1L << (START - 197)) | (1L << (STORAGE - 197)) | (1L << (STDDEV_POP - 197)) | (1L << (STDDEV_SAMP - 197)) | (1L << (SUBPARTITION - 197)) | (1L << (SUM - 197)) | (1L << (TABLESPACE - 197)) | (1L << (TEMPLATE - 197)) | (1L << (THAN - 197)) | (1L << (TIMEZONE - 197)) | (1L << (TIMEZONE_HOUR - 197)) | (1L << (TIMEZONE_MINUTE - 197)) | (1L << (TRIM - 197)) | (1L << (TO - 197)) | (1L << (UNKNOWN - 197)) | (1L << (UNLOGGED - 197)) | (1L << (VALUES - 197)) | (1L << (VAR_SAMP - 197)) | (1L << (VAR_POP - 197)) | (1L << (VARYING - 197)) | (1L << (VOLATILE - 197)) | (1L << (WEEK - 197)) | (1L << (WINDOW - 197)) | (1L << (WRAPPER - 197)) | (1L << (YEAR - 197)) | (1L << (ZONE - 197)) | (1L << (BOOLEAN - 197)) | (1L << (BOOL - 197)) | (1L << (BIT - 197)) | (1L << (VARBIT - 197)) | (1L << (INT1 - 197)) | (1L << (INT2 - 197)) | (1L << (INT4 - 197)))) != 0) || ((((_la - 261)) & ~0x3f) == 0 && ((1L << (_la - 261)) & ((1L << (INT8 - 261)) | (1L << (TINYINT - 261)) | (1L << (SMALLINT - 261)) | (1L << (INT - 261)) | (1L << (INTEGER - 261)) | (1L << (BIGINT - 261)) | (1L << (FLOAT4 - 261)) | (1L << (FLOAT8 - 261)) | (1L << (REAL - 261)) | (1L << (FLOAT - 261)) | (1L << (DOUBLE - 261)) | (1L << (NUMERIC - 261)) | (1L << (DECIMAL - 261)) | (1L << (CHAR - 261)) | (1L << (VARCHAR - 261)) | (1L << (NCHAR - 261)) | (1L << (NVARCHAR - 261)) | (1L << (DATE - 261)) | (1L << (TIME - 261)) | (1L << (TIMETZ - 261)) | (1L << (TIMESTAMP - 261)) | (1L << (TIMESTAMPTZ - 261)) | (1L << (TEXT - 261)) | (1L << (VARBINARY - 261)) | (1L << (BLOB - 261)) | (1L << (BYTEA - 261)) | (1L << (INET4 - 261)) | (1L << (QUOTE - 261)) | (1L << (Identifier - 261)))) != 0)) {
					{
					setState(1807); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1802);
						switch ( getInterpreter().adaptivePredict(_input,253,_ctx) ) {
						case 1:
							{
							{
							setState(1781); ((Create_table_statementContext)_localctx).column_name = identifier();
							setState(1782); ((Create_table_statementContext)_localctx).datatype = data_type();
							setState(1785);
							_la = _input.LA(1);
							if (_la==COLLATE) {
								{
								setState(1783); match(COLLATE);
								setState(1784); ((Create_table_statementContext)_localctx).collation = identifier();
								}
							}

							setState(1790);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,251,_ctx);
							while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
								if ( _alt==1 ) {
									{
									{
									setState(1787); ((Create_table_statementContext)_localctx).colmn_constraint = column_constraint();
									}
									} 
								}
								setState(1792);
								_errHandler.sync(this);
								_alt = getInterpreter().adaptivePredict(_input,251,_ctx);
							}
							}
							}
							break;
						case 2:
							{
							setState(1793); ((Create_table_statementContext)_localctx).tabl_constraint = table_constraint();
							}
							break;
						case 3:
							{
							{
							setState(1794); match(LIKE);
							setState(1795); ((Create_table_statementContext)_localctx).parent_table = identifier();
							setState(1799);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==EXCLUDING || _la==INCLUDING) {
								{
								{
								setState(1796); ((Create_table_statementContext)_localctx).like_opt = like_option();
								}
								}
								setState(1801);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
							}
							break;
						}
						setState(1805);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1804); match(COMMA);
							}
						}

						}
						}
						setState(1809); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CONSTRAINT) | (1L << EXCLUDE) | (1L << FOREIGN))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (LIKE - 69)) | (1L << (PRIMARY - 69)) | (1L << (UNIQUE - 69)) | (1L << (ADMIN - 69)) | (1L << (AVG - 69)) | (1L << (BETWEEN - 69)) | (1L << (BY - 69)) | (1L << (CACHE - 69)))) != 0) || ((((_la - 133)) & ~0x3f) == 0 && ((1L << (_la - 133)) & ((1L << (CALLED - 133)) | (1L << (CLASS - 133)) | (1L << (CENTURY - 133)) | (1L << (CHARACTER - 133)) | (1L << (CHECK - 133)) | (1L << (COLLECT - 133)) | (1L << (COALESCE - 133)) | (1L << (COLUMN - 133)) | (1L << (COMMENT - 133)) | (1L << (COMMENTS - 133)) | (1L << (COMMIT - 133)) | (1L << (CONFIGURATION - 133)) | (1L << (COST - 133)) | (1L << (COUNT - 133)) | (1L << (CUBE - 133)) | (1L << (CURRENT - 133)) | (1L << (CYCLE - 133)) | (1L << (DATA - 133)) | (1L << (DAY - 133)) | (1L << (DEC - 133)) | (1L << (DECADE - 133)) | (1L << (DEFINER - 133)) | (1L << (DICTIONARY - 133)) | (1L << (DOW - 133)) | (1L << (DOY - 133)) | (1L << (DROP - 133)) | (1L << (EPOCH - 133)) | (1L << (EVERY - 133)) | (1L << (EXISTS - 133)) | (1L << (EXTERNAL - 133)) | (1L << (EXTRACT - 133)) | (1L << (FAMILY - 133)) | (1L << (FILTER - 133)) | (1L << (FIRST - 133)) | (1L << (FORMAT - 133)) | (1L << (FUSION - 133)) | (1L << (GROUPING - 133)) | (1L << (HASH - 133)) | (1L << (INDEX - 133)) | (1L << (INCREMENT - 133)) | (1L << (INPUT - 133)) | (1L << (INSERT - 133)) | (1L << (INTERSECTION - 133)) | (1L << (ISCACHABLE - 133)) | (1L << (ISODOW - 133)) | (1L << (ISOYEAR - 133)) | (1L << (ISSTRICT - 133)) | (1L << (LANGUAGE - 133)) | (1L << (LARGE - 133)) | (1L << (LAST - 133)) | (1L << (LESS - 133)) | (1L << (LIST - 133)) | (1L << (LOCATION - 133)) | (1L << (MATCH - 133)) | (1L << (MAX - 133)) | (1L << (MAXVALUE - 133)) | (1L << (MICROSECONDS - 133)) | (1L << (MILLENNIUM - 133)) | (1L << (MILLISECONDS - 133)) | (1L << (MIN - 133)) | (1L << (MINVALUE - 133)) | (1L << (MINUTE - 133)))) != 0) || ((((_la - 197)) & ~0x3f) == 0 && ((1L << (_la - 197)) & ((1L << (MONTH - 197)) | (1L << (NATIONAL - 197)) | (1L << (NO - 197)) | (1L << (NONE - 197)) | (1L << (NULLIF - 197)) | (1L << (OBJECT - 197)) | (1L << (OPTION - 197)) | (1L << (OPTIONS - 197)) | (1L << (OVERWRITE - 197)) | (1L << (PARSER - 197)) | (1L << (PARTIAL - 197)) | (1L << (PARTITION - 197)) | (1L << (PARTITIONS - 197)) | (1L << (PRECISION - 197)) | (1L << (PUBLIC - 197)) | (1L << (PURGE - 197)) | (1L << (QUARTER - 197)) | (1L << (RANGE - 197)) | (1L << (REGEXP - 197)) | (1L << (RLIKE - 197)) | (1L << (ROLLUP - 197)) | (1L << (SEARCH - 197)) | (1L << (SECOND - 197)) | (1L << (SECURITY - 197)) | (1L << (SERVER - 197)) | (1L << (SET - 197)) | (1L << (SIMILAR - 197)) | (1L << (SIMPLE - 197)) | (1L << (STABLE - 197)) | (1L << (START - 197)) | (1L << (STORAGE - 197)) | (1L << (STDDEV_POP - 197)) | (1L << (STDDEV_SAMP - 197)) | (1L << (SUBPARTITION - 197)) | (1L << (SUM - 197)) | (1L << (TABLESPACE - 197)) | (1L << (TEMPLATE - 197)) | (1L << (THAN - 197)) | (1L << (TIMEZONE - 197)) | (1L << (TIMEZONE_HOUR - 197)) | (1L << (TIMEZONE_MINUTE - 197)) | (1L << (TRIM - 197)) | (1L << (TO - 197)) | (1L << (UNKNOWN - 197)) | (1L << (UNLOGGED - 197)) | (1L << (VALUES - 197)) | (1L << (VAR_SAMP - 197)) | (1L << (VAR_POP - 197)) | (1L << (VARYING - 197)) | (1L << (VOLATILE - 197)) | (1L << (WEEK - 197)) | (1L << (WINDOW - 197)) | (1L << (WRAPPER - 197)) | (1L << (YEAR - 197)) | (1L << (ZONE - 197)) | (1L << (BOOLEAN - 197)) | (1L << (BOOL - 197)) | (1L << (BIT - 197)) | (1L << (VARBIT - 197)) | (1L << (INT1 - 197)) | (1L << (INT2 - 197)) | (1L << (INT4 - 197)))) != 0) || ((((_la - 261)) & ~0x3f) == 0 && ((1L << (_la - 261)) & ((1L << (INT8 - 261)) | (1L << (TINYINT - 261)) | (1L << (SMALLINT - 261)) | (1L << (INT - 261)) | (1L << (INTEGER - 261)) | (1L << (BIGINT - 261)) | (1L << (FLOAT4 - 261)) | (1L << (FLOAT8 - 261)) | (1L << (REAL - 261)) | (1L << (FLOAT - 261)) | (1L << (DOUBLE - 261)) | (1L << (NUMERIC - 261)) | (1L << (DECIMAL - 261)) | (1L << (CHAR - 261)) | (1L << (VARCHAR - 261)) | (1L << (NCHAR - 261)) | (1L << (NVARCHAR - 261)) | (1L << (DATE - 261)) | (1L << (TIME - 261)) | (1L << (TIMETZ - 261)) | (1L << (TIMESTAMP - 261)) | (1L << (TIMESTAMPTZ - 261)) | (1L << (TEXT - 261)) | (1L << (VARBINARY - 261)) | (1L << (BLOB - 261)) | (1L << (BYTEA - 261)) | (1L << (INET4 - 261)) | (1L << (QUOTE - 261)) | (1L << (Identifier - 261)))) != 0) );
					}
				}

				setState(1813); match(RIGHT_PAREN);
				setState(1826);
				_la = _input.LA(1);
				if (_la==INHERITS) {
					{
					setState(1814); match(INHERITS);
					setState(1815); match(LEFT_PAREN);
					setState(1820); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1816); ((Create_table_statementContext)_localctx).parent_table = identifier();
						setState(1818);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1817); match(COMMA);
							}
						}

						}
						}
						setState(1822); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (ADMIN - 128)) | (1L << (AVG - 128)) | (1L << (BETWEEN - 128)) | (1L << (BY - 128)) | (1L << (CACHE - 128)) | (1L << (CALLED - 128)) | (1L << (CLASS - 128)) | (1L << (CENTURY - 128)) | (1L << (CHARACTER - 128)) | (1L << (CHECK - 128)) | (1L << (COLLECT - 128)) | (1L << (COALESCE - 128)) | (1L << (COLUMN - 128)) | (1L << (COMMENT - 128)) | (1L << (COMMENTS - 128)) | (1L << (COMMIT - 128)) | (1L << (CONFIGURATION - 128)) | (1L << (COST - 128)) | (1L << (COUNT - 128)) | (1L << (CUBE - 128)) | (1L << (CURRENT - 128)) | (1L << (CYCLE - 128)) | (1L << (DATA - 128)) | (1L << (DAY - 128)) | (1L << (DEC - 128)) | (1L << (DECADE - 128)) | (1L << (DEFINER - 128)) | (1L << (DICTIONARY - 128)) | (1L << (DOW - 128)) | (1L << (DOY - 128)) | (1L << (DROP - 128)) | (1L << (EPOCH - 128)) | (1L << (EVERY - 128)) | (1L << (EXISTS - 128)) | (1L << (EXTERNAL - 128)) | (1L << (EXTRACT - 128)) | (1L << (FAMILY - 128)) | (1L << (FILTER - 128)) | (1L << (FIRST - 128)) | (1L << (FORMAT - 128)) | (1L << (FUSION - 128)) | (1L << (GROUPING - 128)) | (1L << (HASH - 128)) | (1L << (INDEX - 128)) | (1L << (INCREMENT - 128)) | (1L << (INPUT - 128)) | (1L << (INSERT - 128)) | (1L << (INTERSECTION - 128)) | (1L << (ISCACHABLE - 128)) | (1L << (ISODOW - 128)) | (1L << (ISOYEAR - 128)) | (1L << (ISSTRICT - 128)) | (1L << (LANGUAGE - 128)) | (1L << (LARGE - 128)) | (1L << (LAST - 128)) | (1L << (LESS - 128)) | (1L << (LIST - 128)) | (1L << (LOCATION - 128)) | (1L << (MATCH - 128)) | (1L << (MAX - 128)) | (1L << (MAXVALUE - 128)) | (1L << (MICROSECONDS - 128)))) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (MILLENNIUM - 192)) | (1L << (MILLISECONDS - 192)) | (1L << (MIN - 192)) | (1L << (MINVALUE - 192)) | (1L << (MINUTE - 192)) | (1L << (MONTH - 192)) | (1L << (NATIONAL - 192)) | (1L << (NO - 192)) | (1L << (NONE - 192)) | (1L << (NULLIF - 192)) | (1L << (OBJECT - 192)) | (1L << (OPTION - 192)) | (1L << (OPTIONS - 192)) | (1L << (OVERWRITE - 192)) | (1L << (PARSER - 192)) | (1L << (PARTIAL - 192)) | (1L << (PARTITION - 192)) | (1L << (PARTITIONS - 192)) | (1L << (PRECISION - 192)) | (1L << (PUBLIC - 192)) | (1L << (PURGE - 192)) | (1L << (QUARTER - 192)) | (1L << (RANGE - 192)) | (1L << (REGEXP - 192)) | (1L << (RLIKE - 192)) | (1L << (ROLLUP - 192)) | (1L << (SEARCH - 192)) | (1L << (SECOND - 192)) | (1L << (SECURITY - 192)) | (1L << (SERVER - 192)) | (1L << (SET - 192)) | (1L << (SIMILAR - 192)) | (1L << (SIMPLE - 192)) | (1L << (STABLE - 192)) | (1L << (START - 192)) | (1L << (STORAGE - 192)) | (1L << (STDDEV_POP - 192)) | (1L << (STDDEV_SAMP - 192)) | (1L << (SUBPARTITION - 192)) | (1L << (SUM - 192)) | (1L << (TABLESPACE - 192)) | (1L << (TEMPLATE - 192)) | (1L << (THAN - 192)) | (1L << (TIMEZONE - 192)) | (1L << (TIMEZONE_HOUR - 192)) | (1L << (TIMEZONE_MINUTE - 192)) | (1L << (TRIM - 192)) | (1L << (TO - 192)) | (1L << (UNKNOWN - 192)) | (1L << (UNLOGGED - 192)) | (1L << (VALUES - 192)) | (1L << (VAR_SAMP - 192)) | (1L << (VAR_POP - 192)) | (1L << (VARYING - 192)) | (1L << (VOLATILE - 192)) | (1L << (WEEK - 192)) | (1L << (WINDOW - 192)) | (1L << (WRAPPER - 192)) | (1L << (YEAR - 192)) | (1L << (ZONE - 192)) | (1L << (BOOLEAN - 192)) | (1L << (BOOL - 192)))) != 0) || ((((_la - 256)) & ~0x3f) == 0 && ((1L << (_la - 256)) & ((1L << (BIT - 256)) | (1L << (VARBIT - 256)) | (1L << (INT1 - 256)) | (1L << (INT2 - 256)) | (1L << (INT4 - 256)) | (1L << (INT8 - 256)) | (1L << (TINYINT - 256)) | (1L << (SMALLINT - 256)) | (1L << (INT - 256)) | (1L << (INTEGER - 256)) | (1L << (BIGINT - 256)) | (1L << (FLOAT4 - 256)) | (1L << (FLOAT8 - 256)) | (1L << (REAL - 256)) | (1L << (FLOAT - 256)) | (1L << (DOUBLE - 256)) | (1L << (NUMERIC - 256)) | (1L << (DECIMAL - 256)) | (1L << (CHAR - 256)) | (1L << (VARCHAR - 256)) | (1L << (NCHAR - 256)) | (1L << (NVARCHAR - 256)) | (1L << (DATE - 256)) | (1L << (TIME - 256)) | (1L << (TIMETZ - 256)) | (1L << (TIMESTAMP - 256)) | (1L << (TIMESTAMPTZ - 256)) | (1L << (TEXT - 256)) | (1L << (VARBINARY - 256)) | (1L << (BLOB - 256)) | (1L << (BYTEA - 256)) | (1L << (INET4 - 256)) | (1L << (QUOTE - 256)))) != 0) || _la==Identifier );
					setState(1824); match(RIGHT_PAREN);
					}
				}

				setState(1828); storage_parameter_oid();
				setState(1829); on_commit();
				setState(1830); table_space();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1832); match(CREATE);
				setState(1838);
				switch (_input.LA(1)) {
				case GLOBAL:
				case LOCAL:
				case TEMP:
				case TEMPORARY:
					{
					setState(1834);
					_la = _input.LA(1);
					if (_la==GLOBAL || _la==LOCAL) {
						{
						setState(1833);
						_la = _input.LA(1);
						if ( !(_la==GLOBAL || _la==LOCAL) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
					}

					setState(1836);
					_la = _input.LA(1);
					if ( !(_la==TEMP || _la==TEMPORARY) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
					break;
				case UNLOGGED:
					{
					setState(1837); match(UNLOGGED);
					}
					break;
				case TABLE:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1840); match(TABLE);
				setState(1844);
				_la = _input.LA(1);
				if (_la==IF) {
					{
					setState(1841); match(IF);
					setState(1842); match(NOT);
					setState(1843); match(EXISTS);
					}
				}

				setState(1846); ((Create_table_statementContext)_localctx).n = schema_qualified_name();
				setState(1847); match(OF);
				setState(1848); ((Create_table_statementContext)_localctx).type_name = identifier();
				setState(1871);
				switch ( getInterpreter().adaptivePredict(_input,267,_ctx) ) {
				case 1:
					{
					setState(1849); match(LEFT_PAREN);
					setState(1865); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1860);
						switch ( getInterpreter().adaptivePredict(_input,264,_ctx) ) {
						case 1:
							{
							{
							setState(1850); ((Create_table_statementContext)_localctx).column_name = identifier();
							setState(1851); match(WITH);
							setState(1852); match(OPTIONS);
							setState(1856);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,263,_ctx);
							while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
								if ( _alt==1 ) {
									{
									{
									setState(1853); ((Create_table_statementContext)_localctx).col_constraint = column_constraint();
									}
									} 
								}
								setState(1858);
								_errHandler.sync(this);
								_alt = getInterpreter().adaptivePredict(_input,263,_ctx);
							}
							}
							}
							break;
						case 2:
							{
							setState(1859); table_constraint();
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
					} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CONSTRAINT) | (1L << EXCLUDE) | (1L << FOREIGN))) != 0) || ((((_la - 85)) & ~0x3f) == 0 && ((1L << (_la - 85)) & ((1L << (PRIMARY - 85)) | (1L << (UNIQUE - 85)) | (1L << (ADMIN - 85)) | (1L << (AVG - 85)) | (1L << (BETWEEN - 85)) | (1L << (BY - 85)) | (1L << (CACHE - 85)) | (1L << (CALLED - 85)) | (1L << (CLASS - 85)) | (1L << (CENTURY - 85)) | (1L << (CHARACTER - 85)) | (1L << (CHECK - 85)) | (1L << (COLLECT - 85)) | (1L << (COALESCE - 85)) | (1L << (COLUMN - 85)) | (1L << (COMMENT - 85)) | (1L << (COMMENTS - 85)) | (1L << (COMMIT - 85)) | (1L << (CONFIGURATION - 85)) | (1L << (COST - 85)) | (1L << (COUNT - 85)) | (1L << (CUBE - 85)) | (1L << (CURRENT - 85)))) != 0) || ((((_la - 149)) & ~0x3f) == 0 && ((1L << (_la - 149)) & ((1L << (CYCLE - 149)) | (1L << (DATA - 149)) | (1L << (DAY - 149)) | (1L << (DEC - 149)) | (1L << (DECADE - 149)) | (1L << (DEFINER - 149)) | (1L << (DICTIONARY - 149)) | (1L << (DOW - 149)) | (1L << (DOY - 149)) | (1L << (DROP - 149)) | (1L << (EPOCH - 149)) | (1L << (EVERY - 149)) | (1L << (EXISTS - 149)) | (1L << (EXTERNAL - 149)) | (1L << (EXTRACT - 149)) | (1L << (FAMILY - 149)) | (1L << (FILTER - 149)) | (1L << (FIRST - 149)) | (1L << (FORMAT - 149)) | (1L << (FUSION - 149)) | (1L << (GROUPING - 149)) | (1L << (HASH - 149)) | (1L << (INDEX - 149)) | (1L << (INCREMENT - 149)) | (1L << (INPUT - 149)) | (1L << (INSERT - 149)) | (1L << (INTERSECTION - 149)) | (1L << (ISCACHABLE - 149)) | (1L << (ISODOW - 149)) | (1L << (ISOYEAR - 149)) | (1L << (ISSTRICT - 149)) | (1L << (LANGUAGE - 149)) | (1L << (LARGE - 149)) | (1L << (LAST - 149)) | (1L << (LESS - 149)) | (1L << (LIST - 149)) | (1L << (LOCATION - 149)) | (1L << (MATCH - 149)) | (1L << (MAX - 149)) | (1L << (MAXVALUE - 149)) | (1L << (MICROSECONDS - 149)) | (1L << (MILLENNIUM - 149)) | (1L << (MILLISECONDS - 149)) | (1L << (MIN - 149)) | (1L << (MINVALUE - 149)) | (1L << (MINUTE - 149)) | (1L << (MONTH - 149)) | (1L << (NATIONAL - 149)) | (1L << (NO - 149)) | (1L << (NONE - 149)) | (1L << (NULLIF - 149)) | (1L << (OBJECT - 149)) | (1L << (OPTION - 149)) | (1L << (OPTIONS - 149)) | (1L << (OVERWRITE - 149)) | (1L << (PARSER - 149)) | (1L << (PARTIAL - 149)) | (1L << (PARTITION - 149)) | (1L << (PARTITIONS - 149)) | (1L << (PRECISION - 149)) | (1L << (PUBLIC - 149)) | (1L << (PURGE - 149)))) != 0) || ((((_la - 213)) & ~0x3f) == 0 && ((1L << (_la - 213)) & ((1L << (QUARTER - 213)) | (1L << (RANGE - 213)) | (1L << (REGEXP - 213)) | (1L << (RLIKE - 213)) | (1L << (ROLLUP - 213)) | (1L << (SEARCH - 213)) | (1L << (SECOND - 213)) | (1L << (SECURITY - 213)) | (1L << (SERVER - 213)) | (1L << (SET - 213)) | (1L << (SIMILAR - 213)) | (1L << (SIMPLE - 213)) | (1L << (STABLE - 213)) | (1L << (START - 213)) | (1L << (STORAGE - 213)) | (1L << (STDDEV_POP - 213)) | (1L << (STDDEV_SAMP - 213)) | (1L << (SUBPARTITION - 213)) | (1L << (SUM - 213)) | (1L << (TABLESPACE - 213)) | (1L << (TEMPLATE - 213)) | (1L << (THAN - 213)) | (1L << (TIMEZONE - 213)) | (1L << (TIMEZONE_HOUR - 213)) | (1L << (TIMEZONE_MINUTE - 213)) | (1L << (TRIM - 213)) | (1L << (TO - 213)) | (1L << (UNKNOWN - 213)) | (1L << (UNLOGGED - 213)) | (1L << (VALUES - 213)) | (1L << (VAR_SAMP - 213)) | (1L << (VAR_POP - 213)) | (1L << (VARYING - 213)) | (1L << (VOLATILE - 213)) | (1L << (WEEK - 213)) | (1L << (WINDOW - 213)) | (1L << (WRAPPER - 213)) | (1L << (YEAR - 213)) | (1L << (ZONE - 213)) | (1L << (BOOLEAN - 213)) | (1L << (BOOL - 213)) | (1L << (BIT - 213)) | (1L << (VARBIT - 213)) | (1L << (INT1 - 213)) | (1L << (INT2 - 213)) | (1L << (INT4 - 213)) | (1L << (INT8 - 213)) | (1L << (TINYINT - 213)) | (1L << (SMALLINT - 213)) | (1L << (INT - 213)) | (1L << (INTEGER - 213)) | (1L << (BIGINT - 213)) | (1L << (FLOAT4 - 213)) | (1L << (FLOAT8 - 213)) | (1L << (REAL - 213)) | (1L << (FLOAT - 213)) | (1L << (DOUBLE - 213)) | (1L << (NUMERIC - 213)) | (1L << (DECIMAL - 213)) | (1L << (CHAR - 213)) | (1L << (VARCHAR - 213)))) != 0) || ((((_la - 277)) & ~0x3f) == 0 && ((1L << (_la - 277)) & ((1L << (NCHAR - 277)) | (1L << (NVARCHAR - 277)) | (1L << (DATE - 277)) | (1L << (TIME - 277)) | (1L << (TIMETZ - 277)) | (1L << (TIMESTAMP - 277)) | (1L << (TIMESTAMPTZ - 277)) | (1L << (TEXT - 277)) | (1L << (VARBINARY - 277)) | (1L << (BLOB - 277)) | (1L << (BYTEA - 277)) | (1L << (INET4 - 277)) | (1L << (QUOTE - 277)) | (1L << (Identifier - 277)))) != 0) );
					setState(1869); match(RIGHT_PAREN);
					}
					break;
				}
				setState(1873); storage_parameter_oid();
				setState(1874); on_commit();
				setState(1875); table_space();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 44, RULE_like_option);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1879);
			_la = _input.LA(1);
			if ( !(_la==EXCLUDING || _la==INCLUDING) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(1880);
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
		enterRule(_localctx, 46, RULE_table_constraint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1884);
			_la = _input.LA(1);
			if (_la==CONSTRAINT) {
				{
				setState(1882); match(CONSTRAINT);
				setState(1883); ((Table_constraintContext)_localctx).constraint_name = identifier();
				}
			}

			setState(1984);
			switch (_input.LA(1)) {
			case CHECK:
				{
				setState(1886); check_boolean_expression();
				}
				break;
			case UNIQUE:
				{
				{
				setState(1887); match(UNIQUE);
				setState(1888); match(LEFT_PAREN);
				setState(1893); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1889); ((Table_constraintContext)_localctx).column_name_unique = identifier();
					setState(1891);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1890); match(COMMA);
						}
					}

					}
					}
					setState(1895); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (ADMIN - 128)) | (1L << (AVG - 128)) | (1L << (BETWEEN - 128)) | (1L << (BY - 128)) | (1L << (CACHE - 128)) | (1L << (CALLED - 128)) | (1L << (CLASS - 128)) | (1L << (CENTURY - 128)) | (1L << (CHARACTER - 128)) | (1L << (CHECK - 128)) | (1L << (COLLECT - 128)) | (1L << (COALESCE - 128)) | (1L << (COLUMN - 128)) | (1L << (COMMENT - 128)) | (1L << (COMMENTS - 128)) | (1L << (COMMIT - 128)) | (1L << (CONFIGURATION - 128)) | (1L << (COST - 128)) | (1L << (COUNT - 128)) | (1L << (CUBE - 128)) | (1L << (CURRENT - 128)) | (1L << (CYCLE - 128)) | (1L << (DATA - 128)) | (1L << (DAY - 128)) | (1L << (DEC - 128)) | (1L << (DECADE - 128)) | (1L << (DEFINER - 128)) | (1L << (DICTIONARY - 128)) | (1L << (DOW - 128)) | (1L << (DOY - 128)) | (1L << (DROP - 128)) | (1L << (EPOCH - 128)) | (1L << (EVERY - 128)) | (1L << (EXISTS - 128)) | (1L << (EXTERNAL - 128)) | (1L << (EXTRACT - 128)) | (1L << (FAMILY - 128)) | (1L << (FILTER - 128)) | (1L << (FIRST - 128)) | (1L << (FORMAT - 128)) | (1L << (FUSION - 128)) | (1L << (GROUPING - 128)) | (1L << (HASH - 128)) | (1L << (INDEX - 128)) | (1L << (INCREMENT - 128)) | (1L << (INPUT - 128)) | (1L << (INSERT - 128)) | (1L << (INTERSECTION - 128)) | (1L << (ISCACHABLE - 128)) | (1L << (ISODOW - 128)) | (1L << (ISOYEAR - 128)) | (1L << (ISSTRICT - 128)) | (1L << (LANGUAGE - 128)) | (1L << (LARGE - 128)) | (1L << (LAST - 128)) | (1L << (LESS - 128)) | (1L << (LIST - 128)) | (1L << (LOCATION - 128)) | (1L << (MATCH - 128)) | (1L << (MAX - 128)) | (1L << (MAXVALUE - 128)) | (1L << (MICROSECONDS - 128)))) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (MILLENNIUM - 192)) | (1L << (MILLISECONDS - 192)) | (1L << (MIN - 192)) | (1L << (MINVALUE - 192)) | (1L << (MINUTE - 192)) | (1L << (MONTH - 192)) | (1L << (NATIONAL - 192)) | (1L << (NO - 192)) | (1L << (NONE - 192)) | (1L << (NULLIF - 192)) | (1L << (OBJECT - 192)) | (1L << (OPTION - 192)) | (1L << (OPTIONS - 192)) | (1L << (OVERWRITE - 192)) | (1L << (PARSER - 192)) | (1L << (PARTIAL - 192)) | (1L << (PARTITION - 192)) | (1L << (PARTITIONS - 192)) | (1L << (PRECISION - 192)) | (1L << (PUBLIC - 192)) | (1L << (PURGE - 192)) | (1L << (QUARTER - 192)) | (1L << (RANGE - 192)) | (1L << (REGEXP - 192)) | (1L << (RLIKE - 192)) | (1L << (ROLLUP - 192)) | (1L << (SEARCH - 192)) | (1L << (SECOND - 192)) | (1L << (SECURITY - 192)) | (1L << (SERVER - 192)) | (1L << (SET - 192)) | (1L << (SIMILAR - 192)) | (1L << (SIMPLE - 192)) | (1L << (STABLE - 192)) | (1L << (START - 192)) | (1L << (STORAGE - 192)) | (1L << (STDDEV_POP - 192)) | (1L << (STDDEV_SAMP - 192)) | (1L << (SUBPARTITION - 192)) | (1L << (SUM - 192)) | (1L << (TABLESPACE - 192)) | (1L << (TEMPLATE - 192)) | (1L << (THAN - 192)) | (1L << (TIMEZONE - 192)) | (1L << (TIMEZONE_HOUR - 192)) | (1L << (TIMEZONE_MINUTE - 192)) | (1L << (TRIM - 192)) | (1L << (TO - 192)) | (1L << (UNKNOWN - 192)) | (1L << (UNLOGGED - 192)) | (1L << (VALUES - 192)) | (1L << (VAR_SAMP - 192)) | (1L << (VAR_POP - 192)) | (1L << (VARYING - 192)) | (1L << (VOLATILE - 192)) | (1L << (WEEK - 192)) | (1L << (WINDOW - 192)) | (1L << (WRAPPER - 192)) | (1L << (YEAR - 192)) | (1L << (ZONE - 192)) | (1L << (BOOLEAN - 192)) | (1L << (BOOL - 192)))) != 0) || ((((_la - 256)) & ~0x3f) == 0 && ((1L << (_la - 256)) & ((1L << (BIT - 256)) | (1L << (VARBIT - 256)) | (1L << (INT1 - 256)) | (1L << (INT2 - 256)) | (1L << (INT4 - 256)) | (1L << (INT8 - 256)) | (1L << (TINYINT - 256)) | (1L << (SMALLINT - 256)) | (1L << (INT - 256)) | (1L << (INTEGER - 256)) | (1L << (BIGINT - 256)) | (1L << (FLOAT4 - 256)) | (1L << (FLOAT8 - 256)) | (1L << (REAL - 256)) | (1L << (FLOAT - 256)) | (1L << (DOUBLE - 256)) | (1L << (NUMERIC - 256)) | (1L << (DECIMAL - 256)) | (1L << (CHAR - 256)) | (1L << (VARCHAR - 256)) | (1L << (NCHAR - 256)) | (1L << (NVARCHAR - 256)) | (1L << (DATE - 256)) | (1L << (TIME - 256)) | (1L << (TIMETZ - 256)) | (1L << (TIMESTAMP - 256)) | (1L << (TIMESTAMPTZ - 256)) | (1L << (TEXT - 256)) | (1L << (VARBINARY - 256)) | (1L << (BLOB - 256)) | (1L << (BYTEA - 256)) | (1L << (INET4 - 256)) | (1L << (QUOTE - 256)))) != 0) || _la==Identifier );
				setState(1897); match(RIGHT_PAREN);
				setState(1898); ((Table_constraintContext)_localctx).index_parameters_unique = index_parameters();
				}
				}
				break;
			case PRIMARY:
				{
				{
				setState(1900); match(PRIMARY);
				setState(1901); match(KEY);
				setState(1902); match(LEFT_PAREN);
				setState(1907); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1903); ((Table_constraintContext)_localctx).column_name_pr_key = identifier();
					setState(1905);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1904); match(COMMA);
						}
					}

					}
					}
					setState(1909); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (ADMIN - 128)) | (1L << (AVG - 128)) | (1L << (BETWEEN - 128)) | (1L << (BY - 128)) | (1L << (CACHE - 128)) | (1L << (CALLED - 128)) | (1L << (CLASS - 128)) | (1L << (CENTURY - 128)) | (1L << (CHARACTER - 128)) | (1L << (CHECK - 128)) | (1L << (COLLECT - 128)) | (1L << (COALESCE - 128)) | (1L << (COLUMN - 128)) | (1L << (COMMENT - 128)) | (1L << (COMMENTS - 128)) | (1L << (COMMIT - 128)) | (1L << (CONFIGURATION - 128)) | (1L << (COST - 128)) | (1L << (COUNT - 128)) | (1L << (CUBE - 128)) | (1L << (CURRENT - 128)) | (1L << (CYCLE - 128)) | (1L << (DATA - 128)) | (1L << (DAY - 128)) | (1L << (DEC - 128)) | (1L << (DECADE - 128)) | (1L << (DEFINER - 128)) | (1L << (DICTIONARY - 128)) | (1L << (DOW - 128)) | (1L << (DOY - 128)) | (1L << (DROP - 128)) | (1L << (EPOCH - 128)) | (1L << (EVERY - 128)) | (1L << (EXISTS - 128)) | (1L << (EXTERNAL - 128)) | (1L << (EXTRACT - 128)) | (1L << (FAMILY - 128)) | (1L << (FILTER - 128)) | (1L << (FIRST - 128)) | (1L << (FORMAT - 128)) | (1L << (FUSION - 128)) | (1L << (GROUPING - 128)) | (1L << (HASH - 128)) | (1L << (INDEX - 128)) | (1L << (INCREMENT - 128)) | (1L << (INPUT - 128)) | (1L << (INSERT - 128)) | (1L << (INTERSECTION - 128)) | (1L << (ISCACHABLE - 128)) | (1L << (ISODOW - 128)) | (1L << (ISOYEAR - 128)) | (1L << (ISSTRICT - 128)) | (1L << (LANGUAGE - 128)) | (1L << (LARGE - 128)) | (1L << (LAST - 128)) | (1L << (LESS - 128)) | (1L << (LIST - 128)) | (1L << (LOCATION - 128)) | (1L << (MATCH - 128)) | (1L << (MAX - 128)) | (1L << (MAXVALUE - 128)) | (1L << (MICROSECONDS - 128)))) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (MILLENNIUM - 192)) | (1L << (MILLISECONDS - 192)) | (1L << (MIN - 192)) | (1L << (MINVALUE - 192)) | (1L << (MINUTE - 192)) | (1L << (MONTH - 192)) | (1L << (NATIONAL - 192)) | (1L << (NO - 192)) | (1L << (NONE - 192)) | (1L << (NULLIF - 192)) | (1L << (OBJECT - 192)) | (1L << (OPTION - 192)) | (1L << (OPTIONS - 192)) | (1L << (OVERWRITE - 192)) | (1L << (PARSER - 192)) | (1L << (PARTIAL - 192)) | (1L << (PARTITION - 192)) | (1L << (PARTITIONS - 192)) | (1L << (PRECISION - 192)) | (1L << (PUBLIC - 192)) | (1L << (PURGE - 192)) | (1L << (QUARTER - 192)) | (1L << (RANGE - 192)) | (1L << (REGEXP - 192)) | (1L << (RLIKE - 192)) | (1L << (ROLLUP - 192)) | (1L << (SEARCH - 192)) | (1L << (SECOND - 192)) | (1L << (SECURITY - 192)) | (1L << (SERVER - 192)) | (1L << (SET - 192)) | (1L << (SIMILAR - 192)) | (1L << (SIMPLE - 192)) | (1L << (STABLE - 192)) | (1L << (START - 192)) | (1L << (STORAGE - 192)) | (1L << (STDDEV_POP - 192)) | (1L << (STDDEV_SAMP - 192)) | (1L << (SUBPARTITION - 192)) | (1L << (SUM - 192)) | (1L << (TABLESPACE - 192)) | (1L << (TEMPLATE - 192)) | (1L << (THAN - 192)) | (1L << (TIMEZONE - 192)) | (1L << (TIMEZONE_HOUR - 192)) | (1L << (TIMEZONE_MINUTE - 192)) | (1L << (TRIM - 192)) | (1L << (TO - 192)) | (1L << (UNKNOWN - 192)) | (1L << (UNLOGGED - 192)) | (1L << (VALUES - 192)) | (1L << (VAR_SAMP - 192)) | (1L << (VAR_POP - 192)) | (1L << (VARYING - 192)) | (1L << (VOLATILE - 192)) | (1L << (WEEK - 192)) | (1L << (WINDOW - 192)) | (1L << (WRAPPER - 192)) | (1L << (YEAR - 192)) | (1L << (ZONE - 192)) | (1L << (BOOLEAN - 192)) | (1L << (BOOL - 192)))) != 0) || ((((_la - 256)) & ~0x3f) == 0 && ((1L << (_la - 256)) & ((1L << (BIT - 256)) | (1L << (VARBIT - 256)) | (1L << (INT1 - 256)) | (1L << (INT2 - 256)) | (1L << (INT4 - 256)) | (1L << (INT8 - 256)) | (1L << (TINYINT - 256)) | (1L << (SMALLINT - 256)) | (1L << (INT - 256)) | (1L << (INTEGER - 256)) | (1L << (BIGINT - 256)) | (1L << (FLOAT4 - 256)) | (1L << (FLOAT8 - 256)) | (1L << (REAL - 256)) | (1L << (FLOAT - 256)) | (1L << (DOUBLE - 256)) | (1L << (NUMERIC - 256)) | (1L << (DECIMAL - 256)) | (1L << (CHAR - 256)) | (1L << (VARCHAR - 256)) | (1L << (NCHAR - 256)) | (1L << (NVARCHAR - 256)) | (1L << (DATE - 256)) | (1L << (TIME - 256)) | (1L << (TIMETZ - 256)) | (1L << (TIMESTAMP - 256)) | (1L << (TIMESTAMPTZ - 256)) | (1L << (TEXT - 256)) | (1L << (VARBINARY - 256)) | (1L << (BLOB - 256)) | (1L << (BYTEA - 256)) | (1L << (INET4 - 256)) | (1L << (QUOTE - 256)))) != 0) || _la==Identifier );
				setState(1911); match(RIGHT_PAREN);
				setState(1912); ((Table_constraintContext)_localctx).index_parameters_pr_key = index_parameters();
				}
				}
				break;
			case EXCLUDE:
				{
				{
				setState(1914); match(EXCLUDE);
				setState(1917);
				_la = _input.LA(1);
				if (_la==USING) {
					{
					setState(1915); match(USING);
					setState(1916); ((Table_constraintContext)_localctx).index_method = identifier();
					}
				}

				setState(1919); match(LEFT_PAREN);
				setState(1920); ((Table_constraintContext)_localctx).exclude_element = identifier();
				setState(1921); match(WITH);
				setState(1926); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1922); ((Table_constraintContext)_localctx).operator = identifier();
					setState(1924);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1923); match(COMMA);
						}
					}

					}
					}
					setState(1928); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (ADMIN - 128)) | (1L << (AVG - 128)) | (1L << (BETWEEN - 128)) | (1L << (BY - 128)) | (1L << (CACHE - 128)) | (1L << (CALLED - 128)) | (1L << (CLASS - 128)) | (1L << (CENTURY - 128)) | (1L << (CHARACTER - 128)) | (1L << (CHECK - 128)) | (1L << (COLLECT - 128)) | (1L << (COALESCE - 128)) | (1L << (COLUMN - 128)) | (1L << (COMMENT - 128)) | (1L << (COMMENTS - 128)) | (1L << (COMMIT - 128)) | (1L << (CONFIGURATION - 128)) | (1L << (COST - 128)) | (1L << (COUNT - 128)) | (1L << (CUBE - 128)) | (1L << (CURRENT - 128)) | (1L << (CYCLE - 128)) | (1L << (DATA - 128)) | (1L << (DAY - 128)) | (1L << (DEC - 128)) | (1L << (DECADE - 128)) | (1L << (DEFINER - 128)) | (1L << (DICTIONARY - 128)) | (1L << (DOW - 128)) | (1L << (DOY - 128)) | (1L << (DROP - 128)) | (1L << (EPOCH - 128)) | (1L << (EVERY - 128)) | (1L << (EXISTS - 128)) | (1L << (EXTERNAL - 128)) | (1L << (EXTRACT - 128)) | (1L << (FAMILY - 128)) | (1L << (FILTER - 128)) | (1L << (FIRST - 128)) | (1L << (FORMAT - 128)) | (1L << (FUSION - 128)) | (1L << (GROUPING - 128)) | (1L << (HASH - 128)) | (1L << (INDEX - 128)) | (1L << (INCREMENT - 128)) | (1L << (INPUT - 128)) | (1L << (INSERT - 128)) | (1L << (INTERSECTION - 128)) | (1L << (ISCACHABLE - 128)) | (1L << (ISODOW - 128)) | (1L << (ISOYEAR - 128)) | (1L << (ISSTRICT - 128)) | (1L << (LANGUAGE - 128)) | (1L << (LARGE - 128)) | (1L << (LAST - 128)) | (1L << (LESS - 128)) | (1L << (LIST - 128)) | (1L << (LOCATION - 128)) | (1L << (MATCH - 128)) | (1L << (MAX - 128)) | (1L << (MAXVALUE - 128)) | (1L << (MICROSECONDS - 128)))) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (MILLENNIUM - 192)) | (1L << (MILLISECONDS - 192)) | (1L << (MIN - 192)) | (1L << (MINVALUE - 192)) | (1L << (MINUTE - 192)) | (1L << (MONTH - 192)) | (1L << (NATIONAL - 192)) | (1L << (NO - 192)) | (1L << (NONE - 192)) | (1L << (NULLIF - 192)) | (1L << (OBJECT - 192)) | (1L << (OPTION - 192)) | (1L << (OPTIONS - 192)) | (1L << (OVERWRITE - 192)) | (1L << (PARSER - 192)) | (1L << (PARTIAL - 192)) | (1L << (PARTITION - 192)) | (1L << (PARTITIONS - 192)) | (1L << (PRECISION - 192)) | (1L << (PUBLIC - 192)) | (1L << (PURGE - 192)) | (1L << (QUARTER - 192)) | (1L << (RANGE - 192)) | (1L << (REGEXP - 192)) | (1L << (RLIKE - 192)) | (1L << (ROLLUP - 192)) | (1L << (SEARCH - 192)) | (1L << (SECOND - 192)) | (1L << (SECURITY - 192)) | (1L << (SERVER - 192)) | (1L << (SET - 192)) | (1L << (SIMILAR - 192)) | (1L << (SIMPLE - 192)) | (1L << (STABLE - 192)) | (1L << (START - 192)) | (1L << (STORAGE - 192)) | (1L << (STDDEV_POP - 192)) | (1L << (STDDEV_SAMP - 192)) | (1L << (SUBPARTITION - 192)) | (1L << (SUM - 192)) | (1L << (TABLESPACE - 192)) | (1L << (TEMPLATE - 192)) | (1L << (THAN - 192)) | (1L << (TIMEZONE - 192)) | (1L << (TIMEZONE_HOUR - 192)) | (1L << (TIMEZONE_MINUTE - 192)) | (1L << (TRIM - 192)) | (1L << (TO - 192)) | (1L << (UNKNOWN - 192)) | (1L << (UNLOGGED - 192)) | (1L << (VALUES - 192)) | (1L << (VAR_SAMP - 192)) | (1L << (VAR_POP - 192)) | (1L << (VARYING - 192)) | (1L << (VOLATILE - 192)) | (1L << (WEEK - 192)) | (1L << (WINDOW - 192)) | (1L << (WRAPPER - 192)) | (1L << (YEAR - 192)) | (1L << (ZONE - 192)) | (1L << (BOOLEAN - 192)) | (1L << (BOOL - 192)))) != 0) || ((((_la - 256)) & ~0x3f) == 0 && ((1L << (_la - 256)) & ((1L << (BIT - 256)) | (1L << (VARBIT - 256)) | (1L << (INT1 - 256)) | (1L << (INT2 - 256)) | (1L << (INT4 - 256)) | (1L << (INT8 - 256)) | (1L << (TINYINT - 256)) | (1L << (SMALLINT - 256)) | (1L << (INT - 256)) | (1L << (INTEGER - 256)) | (1L << (BIGINT - 256)) | (1L << (FLOAT4 - 256)) | (1L << (FLOAT8 - 256)) | (1L << (REAL - 256)) | (1L << (FLOAT - 256)) | (1L << (DOUBLE - 256)) | (1L << (NUMERIC - 256)) | (1L << (DECIMAL - 256)) | (1L << (CHAR - 256)) | (1L << (VARCHAR - 256)) | (1L << (NCHAR - 256)) | (1L << (NVARCHAR - 256)) | (1L << (DATE - 256)) | (1L << (TIME - 256)) | (1L << (TIMETZ - 256)) | (1L << (TIMESTAMP - 256)) | (1L << (TIMESTAMPTZ - 256)) | (1L << (TEXT - 256)) | (1L << (VARBINARY - 256)) | (1L << (BLOB - 256)) | (1L << (BYTEA - 256)) | (1L << (INET4 - 256)) | (1L << (QUOTE - 256)))) != 0) || _la==Identifier );
				setState(1930); match(RIGHT_PAREN);
				setState(1931); index_parameters();
				setState(1937);
				_la = _input.LA(1);
				if (_la==WHERE) {
					{
					setState(1932); match(WHERE);
					setState(1933); match(LEFT_PAREN);
					setState(1934); ((Table_constraintContext)_localctx).predicat = identifier();
					setState(1935); match(RIGHT_PAREN);
					}
				}

				}
				}
				break;
			case FOREIGN:
				{
				{
				setState(1939); match(FOREIGN);
				setState(1940); match(KEY);
				setState(1941); match(LEFT_PAREN);
				setState(1946); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1942); ((Table_constraintContext)_localctx).column_name_for_key = identifier();
					setState(1944);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1943); match(COMMA);
						}
					}

					}
					}
					setState(1948); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (ADMIN - 128)) | (1L << (AVG - 128)) | (1L << (BETWEEN - 128)) | (1L << (BY - 128)) | (1L << (CACHE - 128)) | (1L << (CALLED - 128)) | (1L << (CLASS - 128)) | (1L << (CENTURY - 128)) | (1L << (CHARACTER - 128)) | (1L << (CHECK - 128)) | (1L << (COLLECT - 128)) | (1L << (COALESCE - 128)) | (1L << (COLUMN - 128)) | (1L << (COMMENT - 128)) | (1L << (COMMENTS - 128)) | (1L << (COMMIT - 128)) | (1L << (CONFIGURATION - 128)) | (1L << (COST - 128)) | (1L << (COUNT - 128)) | (1L << (CUBE - 128)) | (1L << (CURRENT - 128)) | (1L << (CYCLE - 128)) | (1L << (DATA - 128)) | (1L << (DAY - 128)) | (1L << (DEC - 128)) | (1L << (DECADE - 128)) | (1L << (DEFINER - 128)) | (1L << (DICTIONARY - 128)) | (1L << (DOW - 128)) | (1L << (DOY - 128)) | (1L << (DROP - 128)) | (1L << (EPOCH - 128)) | (1L << (EVERY - 128)) | (1L << (EXISTS - 128)) | (1L << (EXTERNAL - 128)) | (1L << (EXTRACT - 128)) | (1L << (FAMILY - 128)) | (1L << (FILTER - 128)) | (1L << (FIRST - 128)) | (1L << (FORMAT - 128)) | (1L << (FUSION - 128)) | (1L << (GROUPING - 128)) | (1L << (HASH - 128)) | (1L << (INDEX - 128)) | (1L << (INCREMENT - 128)) | (1L << (INPUT - 128)) | (1L << (INSERT - 128)) | (1L << (INTERSECTION - 128)) | (1L << (ISCACHABLE - 128)) | (1L << (ISODOW - 128)) | (1L << (ISOYEAR - 128)) | (1L << (ISSTRICT - 128)) | (1L << (LANGUAGE - 128)) | (1L << (LARGE - 128)) | (1L << (LAST - 128)) | (1L << (LESS - 128)) | (1L << (LIST - 128)) | (1L << (LOCATION - 128)) | (1L << (MATCH - 128)) | (1L << (MAX - 128)) | (1L << (MAXVALUE - 128)) | (1L << (MICROSECONDS - 128)))) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (MILLENNIUM - 192)) | (1L << (MILLISECONDS - 192)) | (1L << (MIN - 192)) | (1L << (MINVALUE - 192)) | (1L << (MINUTE - 192)) | (1L << (MONTH - 192)) | (1L << (NATIONAL - 192)) | (1L << (NO - 192)) | (1L << (NONE - 192)) | (1L << (NULLIF - 192)) | (1L << (OBJECT - 192)) | (1L << (OPTION - 192)) | (1L << (OPTIONS - 192)) | (1L << (OVERWRITE - 192)) | (1L << (PARSER - 192)) | (1L << (PARTIAL - 192)) | (1L << (PARTITION - 192)) | (1L << (PARTITIONS - 192)) | (1L << (PRECISION - 192)) | (1L << (PUBLIC - 192)) | (1L << (PURGE - 192)) | (1L << (QUARTER - 192)) | (1L << (RANGE - 192)) | (1L << (REGEXP - 192)) | (1L << (RLIKE - 192)) | (1L << (ROLLUP - 192)) | (1L << (SEARCH - 192)) | (1L << (SECOND - 192)) | (1L << (SECURITY - 192)) | (1L << (SERVER - 192)) | (1L << (SET - 192)) | (1L << (SIMILAR - 192)) | (1L << (SIMPLE - 192)) | (1L << (STABLE - 192)) | (1L << (START - 192)) | (1L << (STORAGE - 192)) | (1L << (STDDEV_POP - 192)) | (1L << (STDDEV_SAMP - 192)) | (1L << (SUBPARTITION - 192)) | (1L << (SUM - 192)) | (1L << (TABLESPACE - 192)) | (1L << (TEMPLATE - 192)) | (1L << (THAN - 192)) | (1L << (TIMEZONE - 192)) | (1L << (TIMEZONE_HOUR - 192)) | (1L << (TIMEZONE_MINUTE - 192)) | (1L << (TRIM - 192)) | (1L << (TO - 192)) | (1L << (UNKNOWN - 192)) | (1L << (UNLOGGED - 192)) | (1L << (VALUES - 192)) | (1L << (VAR_SAMP - 192)) | (1L << (VAR_POP - 192)) | (1L << (VARYING - 192)) | (1L << (VOLATILE - 192)) | (1L << (WEEK - 192)) | (1L << (WINDOW - 192)) | (1L << (WRAPPER - 192)) | (1L << (YEAR - 192)) | (1L << (ZONE - 192)) | (1L << (BOOLEAN - 192)) | (1L << (BOOL - 192)))) != 0) || ((((_la - 256)) & ~0x3f) == 0 && ((1L << (_la - 256)) & ((1L << (BIT - 256)) | (1L << (VARBIT - 256)) | (1L << (INT1 - 256)) | (1L << (INT2 - 256)) | (1L << (INT4 - 256)) | (1L << (INT8 - 256)) | (1L << (TINYINT - 256)) | (1L << (SMALLINT - 256)) | (1L << (INT - 256)) | (1L << (INTEGER - 256)) | (1L << (BIGINT - 256)) | (1L << (FLOAT4 - 256)) | (1L << (FLOAT8 - 256)) | (1L << (REAL - 256)) | (1L << (FLOAT - 256)) | (1L << (DOUBLE - 256)) | (1L << (NUMERIC - 256)) | (1L << (DECIMAL - 256)) | (1L << (CHAR - 256)) | (1L << (VARCHAR - 256)) | (1L << (NCHAR - 256)) | (1L << (NVARCHAR - 256)) | (1L << (DATE - 256)) | (1L << (TIME - 256)) | (1L << (TIMETZ - 256)) | (1L << (TIMESTAMP - 256)) | (1L << (TIMESTAMPTZ - 256)) | (1L << (TEXT - 256)) | (1L << (VARBINARY - 256)) | (1L << (BLOB - 256)) | (1L << (BYTEA - 256)) | (1L << (INET4 - 256)) | (1L << (QUOTE - 256)))) != 0) || _la==Identifier );
				setState(1950); match(RIGHT_PAREN);
				setState(1951); match(REFERENCES);
				setState(1952); ((Table_constraintContext)_localctx).reftable = identifier();
				setState(1964);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(1953); match(LEFT_PAREN);
					setState(1958); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1954); ((Table_constraintContext)_localctx).refcolumn = identifier();
						setState(1956);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1955); match(COMMA);
							}
						}

						}
						}
						setState(1960); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (ADMIN - 128)) | (1L << (AVG - 128)) | (1L << (BETWEEN - 128)) | (1L << (BY - 128)) | (1L << (CACHE - 128)) | (1L << (CALLED - 128)) | (1L << (CLASS - 128)) | (1L << (CENTURY - 128)) | (1L << (CHARACTER - 128)) | (1L << (CHECK - 128)) | (1L << (COLLECT - 128)) | (1L << (COALESCE - 128)) | (1L << (COLUMN - 128)) | (1L << (COMMENT - 128)) | (1L << (COMMENTS - 128)) | (1L << (COMMIT - 128)) | (1L << (CONFIGURATION - 128)) | (1L << (COST - 128)) | (1L << (COUNT - 128)) | (1L << (CUBE - 128)) | (1L << (CURRENT - 128)) | (1L << (CYCLE - 128)) | (1L << (DATA - 128)) | (1L << (DAY - 128)) | (1L << (DEC - 128)) | (1L << (DECADE - 128)) | (1L << (DEFINER - 128)) | (1L << (DICTIONARY - 128)) | (1L << (DOW - 128)) | (1L << (DOY - 128)) | (1L << (DROP - 128)) | (1L << (EPOCH - 128)) | (1L << (EVERY - 128)) | (1L << (EXISTS - 128)) | (1L << (EXTERNAL - 128)) | (1L << (EXTRACT - 128)) | (1L << (FAMILY - 128)) | (1L << (FILTER - 128)) | (1L << (FIRST - 128)) | (1L << (FORMAT - 128)) | (1L << (FUSION - 128)) | (1L << (GROUPING - 128)) | (1L << (HASH - 128)) | (1L << (INDEX - 128)) | (1L << (INCREMENT - 128)) | (1L << (INPUT - 128)) | (1L << (INSERT - 128)) | (1L << (INTERSECTION - 128)) | (1L << (ISCACHABLE - 128)) | (1L << (ISODOW - 128)) | (1L << (ISOYEAR - 128)) | (1L << (ISSTRICT - 128)) | (1L << (LANGUAGE - 128)) | (1L << (LARGE - 128)) | (1L << (LAST - 128)) | (1L << (LESS - 128)) | (1L << (LIST - 128)) | (1L << (LOCATION - 128)) | (1L << (MATCH - 128)) | (1L << (MAX - 128)) | (1L << (MAXVALUE - 128)) | (1L << (MICROSECONDS - 128)))) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (MILLENNIUM - 192)) | (1L << (MILLISECONDS - 192)) | (1L << (MIN - 192)) | (1L << (MINVALUE - 192)) | (1L << (MINUTE - 192)) | (1L << (MONTH - 192)) | (1L << (NATIONAL - 192)) | (1L << (NO - 192)) | (1L << (NONE - 192)) | (1L << (NULLIF - 192)) | (1L << (OBJECT - 192)) | (1L << (OPTION - 192)) | (1L << (OPTIONS - 192)) | (1L << (OVERWRITE - 192)) | (1L << (PARSER - 192)) | (1L << (PARTIAL - 192)) | (1L << (PARTITION - 192)) | (1L << (PARTITIONS - 192)) | (1L << (PRECISION - 192)) | (1L << (PUBLIC - 192)) | (1L << (PURGE - 192)) | (1L << (QUARTER - 192)) | (1L << (RANGE - 192)) | (1L << (REGEXP - 192)) | (1L << (RLIKE - 192)) | (1L << (ROLLUP - 192)) | (1L << (SEARCH - 192)) | (1L << (SECOND - 192)) | (1L << (SECURITY - 192)) | (1L << (SERVER - 192)) | (1L << (SET - 192)) | (1L << (SIMILAR - 192)) | (1L << (SIMPLE - 192)) | (1L << (STABLE - 192)) | (1L << (START - 192)) | (1L << (STORAGE - 192)) | (1L << (STDDEV_POP - 192)) | (1L << (STDDEV_SAMP - 192)) | (1L << (SUBPARTITION - 192)) | (1L << (SUM - 192)) | (1L << (TABLESPACE - 192)) | (1L << (TEMPLATE - 192)) | (1L << (THAN - 192)) | (1L << (TIMEZONE - 192)) | (1L << (TIMEZONE_HOUR - 192)) | (1L << (TIMEZONE_MINUTE - 192)) | (1L << (TRIM - 192)) | (1L << (TO - 192)) | (1L << (UNKNOWN - 192)) | (1L << (UNLOGGED - 192)) | (1L << (VALUES - 192)) | (1L << (VAR_SAMP - 192)) | (1L << (VAR_POP - 192)) | (1L << (VARYING - 192)) | (1L << (VOLATILE - 192)) | (1L << (WEEK - 192)) | (1L << (WINDOW - 192)) | (1L << (WRAPPER - 192)) | (1L << (YEAR - 192)) | (1L << (ZONE - 192)) | (1L << (BOOLEAN - 192)) | (1L << (BOOL - 192)))) != 0) || ((((_la - 256)) & ~0x3f) == 0 && ((1L << (_la - 256)) & ((1L << (BIT - 256)) | (1L << (VARBIT - 256)) | (1L << (INT1 - 256)) | (1L << (INT2 - 256)) | (1L << (INT4 - 256)) | (1L << (INT8 - 256)) | (1L << (TINYINT - 256)) | (1L << (SMALLINT - 256)) | (1L << (INT - 256)) | (1L << (INTEGER - 256)) | (1L << (BIGINT - 256)) | (1L << (FLOAT4 - 256)) | (1L << (FLOAT8 - 256)) | (1L << (REAL - 256)) | (1L << (FLOAT - 256)) | (1L << (DOUBLE - 256)) | (1L << (NUMERIC - 256)) | (1L << (DECIMAL - 256)) | (1L << (CHAR - 256)) | (1L << (VARCHAR - 256)) | (1L << (NCHAR - 256)) | (1L << (NVARCHAR - 256)) | (1L << (DATE - 256)) | (1L << (TIME - 256)) | (1L << (TIMETZ - 256)) | (1L << (TIMESTAMP - 256)) | (1L << (TIMESTAMPTZ - 256)) | (1L << (TEXT - 256)) | (1L << (VARBINARY - 256)) | (1L << (BLOB - 256)) | (1L << (BYTEA - 256)) | (1L << (INET4 - 256)) | (1L << (QUOTE - 256)))) != 0) || _la==Identifier );
					setState(1962); match(RIGHT_PAREN);
					}
				}

				setState(1972);
				switch ( getInterpreter().adaptivePredict(_input,283,_ctx) ) {
				case 1:
					{
					{
					setState(1966); match(MATCH);
					setState(1967); match(FULL);
					}
					}
					break;
				case 2:
					{
					{
					setState(1968); match(MATCH);
					setState(1969); match(PARTIAL);
					}
					}
					break;
				case 3:
					{
					{
					setState(1970); match(MATCH);
					setState(1971); match(SIMPLE);
					}
					}
					break;
				}
				setState(1977);
				switch ( getInterpreter().adaptivePredict(_input,284,_ctx) ) {
				case 1:
					{
					setState(1974); match(ON);
					setState(1975); match(DELETE);
					setState(1976); ((Table_constraintContext)_localctx).action_on_delete = action();
					}
					break;
				}
				setState(1982);
				_la = _input.LA(1);
				if (_la==ON) {
					{
					setState(1979); match(ON);
					setState(1980); match(UPDATE);
					setState(1981); ((Table_constraintContext)_localctx).action_on_update = action();
					}
				}

				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(1989);
			switch (_input.LA(1)) {
			case DEFERRABLE:
				{
				setState(1986); match(DEFERRABLE);
				}
				break;
			case NOT:
				{
				{
				setState(1987); match(NOT);
				setState(1988); match(DEFERRABLE);
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
			setState(1995);
			switch ( getInterpreter().adaptivePredict(_input,288,_ctx) ) {
			case 1:
				{
				{
				setState(1991); match(INITIALLY);
				setState(1992); match(DEFERRED);
				}
				}
				break;
			case 2:
				{
				{
				setState(1993); match(INITIALLY);
				setState(1994); match(IMMEDIATE);
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
		enterRule(_localctx, 48, RULE_column_constraint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1999);
			_la = _input.LA(1);
			if (_la==CONSTRAINT) {
				{
				setState(1997); match(CONSTRAINT);
				setState(1998); ((Column_constraintContext)_localctx).constraint_name = identifier();
				}
			}

			setState(2033);
			switch (_input.LA(1)) {
			case NOT:
				{
				{
				setState(2001); match(NOT);
				setState(2002); match(NULL);
				}
				}
				break;
			case NULL:
				{
				setState(2003); match(NULL);
				}
				break;
			case CHECK:
				{
				setState(2004); check_boolean_expression();
				}
				break;
			case DEFAULT:
				{
				{
				setState(2005); match(DEFAULT);
				setState(2006); ((Column_constraintContext)_localctx).default_expr = routine_invocation();
				}
				}
				break;
			case UNIQUE:
				{
				{
				setState(2007); match(UNIQUE);
				setState(2008); ((Column_constraintContext)_localctx).index_params_unique = index_parameters();
				}
				}
				break;
			case PRIMARY:
				{
				{
				setState(2009); match(PRIMARY);
				setState(2010); match(KEY);
				setState(2011); ((Column_constraintContext)_localctx).index_params_pr_key = index_parameters();
				}
				}
				break;
			case REFERENCES:
				{
				{
				setState(2012); match(REFERENCES);
				setState(2013); ((Column_constraintContext)_localctx).reftable = schema_qualified_name();
				{
				{
				setState(2014); ((Column_constraintContext)_localctx).refcolumn = identifier();
				}
				}
				setState(2021);
				switch ( getInterpreter().adaptivePredict(_input,290,_ctx) ) {
				case 1:
					{
					setState(2015); match(MATCH);
					setState(2016); match(FULL);
					}
					break;
				case 2:
					{
					setState(2017); match(MATCH);
					setState(2018); match(PARTIAL);
					}
					break;
				case 3:
					{
					setState(2019); match(MATCH);
					setState(2020); match(SIMPLE);
					}
					break;
				}
				setState(2026);
				switch ( getInterpreter().adaptivePredict(_input,291,_ctx) ) {
				case 1:
					{
					setState(2023); match(ON);
					setState(2024); match(DELETE);
					setState(2025); ((Column_constraintContext)_localctx).action_on_delete = action();
					}
					break;
				}
				setState(2031);
				_la = _input.LA(1);
				if (_la==ON) {
					{
					setState(2028); match(ON);
					setState(2029); match(UPDATE);
					setState(2030); ((Column_constraintContext)_localctx).action_on_update = action();
					}
				}

				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(2038);
			switch ( getInterpreter().adaptivePredict(_input,294,_ctx) ) {
			case 1:
				{
				setState(2035); match(DEFERRABLE);
				}
				break;
			case 2:
				{
				{
				setState(2036); match(NOT);
				setState(2037); match(DEFERRABLE);
				}
				}
				break;
			}
			setState(2044);
			switch ( getInterpreter().adaptivePredict(_input,295,_ctx) ) {
			case 1:
				{
				{
				setState(2040); match(INITIALLY);
				setState(2041); match(DEFERRED);
				}
				}
				break;
			case 2:
				{
				{
				setState(2042); match(INITIALLY);
				setState(2043); match(IMMEDIATE);
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
		enterRule(_localctx, 50, RULE_check_boolean_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2046); match(CHECK);
			setState(2047); match(LEFT_PAREN);
			setState(2048); ((Check_boolean_expressionContext)_localctx).expression = boolean_value_expression();
			setState(2049); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 52, RULE_storage_parameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2051); match(WITH);
			setState(2052); match(LEFT_PAREN);
			setState(2061); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(2053); ((Storage_parameterContext)_localctx).storage_param = identifier();
				setState(2056);
				_la = _input.LA(1);
				if (_la==EQUAL) {
					{
					setState(2054); match(EQUAL);
					setState(2055); ((Storage_parameterContext)_localctx).value = identifier();
					}
				}

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
			} while ( ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (ADMIN - 128)) | (1L << (AVG - 128)) | (1L << (BETWEEN - 128)) | (1L << (BY - 128)) | (1L << (CACHE - 128)) | (1L << (CALLED - 128)) | (1L << (CLASS - 128)) | (1L << (CENTURY - 128)) | (1L << (CHARACTER - 128)) | (1L << (CHECK - 128)) | (1L << (COLLECT - 128)) | (1L << (COALESCE - 128)) | (1L << (COLUMN - 128)) | (1L << (COMMENT - 128)) | (1L << (COMMENTS - 128)) | (1L << (COMMIT - 128)) | (1L << (CONFIGURATION - 128)) | (1L << (COST - 128)) | (1L << (COUNT - 128)) | (1L << (CUBE - 128)) | (1L << (CURRENT - 128)) | (1L << (CYCLE - 128)) | (1L << (DATA - 128)) | (1L << (DAY - 128)) | (1L << (DEC - 128)) | (1L << (DECADE - 128)) | (1L << (DEFINER - 128)) | (1L << (DICTIONARY - 128)) | (1L << (DOW - 128)) | (1L << (DOY - 128)) | (1L << (DROP - 128)) | (1L << (EPOCH - 128)) | (1L << (EVERY - 128)) | (1L << (EXISTS - 128)) | (1L << (EXTERNAL - 128)) | (1L << (EXTRACT - 128)) | (1L << (FAMILY - 128)) | (1L << (FILTER - 128)) | (1L << (FIRST - 128)) | (1L << (FORMAT - 128)) | (1L << (FUSION - 128)) | (1L << (GROUPING - 128)) | (1L << (HASH - 128)) | (1L << (INDEX - 128)) | (1L << (INCREMENT - 128)) | (1L << (INPUT - 128)) | (1L << (INSERT - 128)) | (1L << (INTERSECTION - 128)) | (1L << (ISCACHABLE - 128)) | (1L << (ISODOW - 128)) | (1L << (ISOYEAR - 128)) | (1L << (ISSTRICT - 128)) | (1L << (LANGUAGE - 128)) | (1L << (LARGE - 128)) | (1L << (LAST - 128)) | (1L << (LESS - 128)) | (1L << (LIST - 128)) | (1L << (LOCATION - 128)) | (1L << (MATCH - 128)) | (1L << (MAX - 128)) | (1L << (MAXVALUE - 128)) | (1L << (MICROSECONDS - 128)))) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (MILLENNIUM - 192)) | (1L << (MILLISECONDS - 192)) | (1L << (MIN - 192)) | (1L << (MINVALUE - 192)) | (1L << (MINUTE - 192)) | (1L << (MONTH - 192)) | (1L << (NATIONAL - 192)) | (1L << (NO - 192)) | (1L << (NONE - 192)) | (1L << (NULLIF - 192)) | (1L << (OBJECT - 192)) | (1L << (OPTION - 192)) | (1L << (OPTIONS - 192)) | (1L << (OVERWRITE - 192)) | (1L << (PARSER - 192)) | (1L << (PARTIAL - 192)) | (1L << (PARTITION - 192)) | (1L << (PARTITIONS - 192)) | (1L << (PRECISION - 192)) | (1L << (PUBLIC - 192)) | (1L << (PURGE - 192)) | (1L << (QUARTER - 192)) | (1L << (RANGE - 192)) | (1L << (REGEXP - 192)) | (1L << (RLIKE - 192)) | (1L << (ROLLUP - 192)) | (1L << (SEARCH - 192)) | (1L << (SECOND - 192)) | (1L << (SECURITY - 192)) | (1L << (SERVER - 192)) | (1L << (SET - 192)) | (1L << (SIMILAR - 192)) | (1L << (SIMPLE - 192)) | (1L << (STABLE - 192)) | (1L << (START - 192)) | (1L << (STORAGE - 192)) | (1L << (STDDEV_POP - 192)) | (1L << (STDDEV_SAMP - 192)) | (1L << (SUBPARTITION - 192)) | (1L << (SUM - 192)) | (1L << (TABLESPACE - 192)) | (1L << (TEMPLATE - 192)) | (1L << (THAN - 192)) | (1L << (TIMEZONE - 192)) | (1L << (TIMEZONE_HOUR - 192)) | (1L << (TIMEZONE_MINUTE - 192)) | (1L << (TRIM - 192)) | (1L << (TO - 192)) | (1L << (UNKNOWN - 192)) | (1L << (UNLOGGED - 192)) | (1L << (VALUES - 192)) | (1L << (VAR_SAMP - 192)) | (1L << (VAR_POP - 192)) | (1L << (VARYING - 192)) | (1L << (VOLATILE - 192)) | (1L << (WEEK - 192)) | (1L << (WINDOW - 192)) | (1L << (WRAPPER - 192)) | (1L << (YEAR - 192)) | (1L << (ZONE - 192)) | (1L << (BOOLEAN - 192)) | (1L << (BOOL - 192)))) != 0) || ((((_la - 256)) & ~0x3f) == 0 && ((1L << (_la - 256)) & ((1L << (BIT - 256)) | (1L << (VARBIT - 256)) | (1L << (INT1 - 256)) | (1L << (INT2 - 256)) | (1L << (INT4 - 256)) | (1L << (INT8 - 256)) | (1L << (TINYINT - 256)) | (1L << (SMALLINT - 256)) | (1L << (INT - 256)) | (1L << (INTEGER - 256)) | (1L << (BIGINT - 256)) | (1L << (FLOAT4 - 256)) | (1L << (FLOAT8 - 256)) | (1L << (REAL - 256)) | (1L << (FLOAT - 256)) | (1L << (DOUBLE - 256)) | (1L << (NUMERIC - 256)) | (1L << (DECIMAL - 256)) | (1L << (CHAR - 256)) | (1L << (VARCHAR - 256)) | (1L << (NCHAR - 256)) | (1L << (NVARCHAR - 256)) | (1L << (DATE - 256)) | (1L << (TIME - 256)) | (1L << (TIMETZ - 256)) | (1L << (TIMESTAMP - 256)) | (1L << (TIMESTAMPTZ - 256)) | (1L << (TEXT - 256)) | (1L << (VARBINARY - 256)) | (1L << (BLOB - 256)) | (1L << (BYTEA - 256)) | (1L << (INET4 - 256)) | (1L << (QUOTE - 256)))) != 0) || _la==Identifier );
			setState(2065); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 54, RULE_storage_parameter_oid);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2072);
			switch ( getInterpreter().adaptivePredict(_input,299,_ctx) ) {
			case 1:
				{
				setState(2067); storage_parameter();
				}
				break;
			case 2:
				{
				{
				setState(2068); match(WITH);
				setState(2069); match(OIDS);
				}
				}
				break;
			case 3:
				{
				{
				setState(2070); match(WITHOUT);
				setState(2071); match(OIDS);
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
		enterRule(_localctx, 56, RULE_on_commit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2083);
			_la = _input.LA(1);
			if (_la==ON) {
				{
				setState(2074); match(ON);
				setState(2075); match(COMMIT);
				setState(2081);
				switch (_input.LA(1)) {
				case PRESERVE:
					{
					{
					setState(2076); match(PRESERVE);
					setState(2077); match(ROWS);
					}
					}
					break;
				case DELETE:
					{
					{
					setState(2078); match(DELETE);
					setState(2079); match(ROWS);
					}
					}
					break;
				case DROP:
					{
					setState(2080); match(DROP);
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
		enterRule(_localctx, 58, RULE_table_space);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2087);
			switch ( getInterpreter().adaptivePredict(_input,302,_ctx) ) {
			case 1:
				{
				setState(2085); match(TABLESPACE);
				setState(2086); ((Table_spaceContext)_localctx).tablespace = identifier();
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
		enterRule(_localctx, 60, RULE_action);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2095);
			switch ( getInterpreter().adaptivePredict(_input,303,_ctx) ) {
			case 1:
				{
				setState(2089); match(RESTRICT);
				}
				break;
			case 2:
				{
				setState(2090); match(CASCADE);
				}
				break;
			case 3:
				{
				setState(2091); match(SET);
				setState(2092); match(NULL);
				}
				break;
			case 4:
				{
				setState(2093); match(SET);
				setState(2094); match(DEFAULT);
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
		enterRule(_localctx, 62, RULE_index_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2098);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(2097); storage_parameter();
				}
			}

			setState(2104);
			_la = _input.LA(1);
			if (_la==USING) {
				{
				setState(2100); match(USING);
				setState(2101); match(INDEX);
				setState(2102); match(TABLESPACE);
				setState(2103); ((Index_parametersContext)_localctx).tablespace = identifier();
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
		enterRule(_localctx, 64, RULE_table_elements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2106); match(LEFT_PAREN);
			setState(2107); field_element();
			setState(2112);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2108); match(COMMA);
				setState(2109); field_element();
				}
				}
				setState(2114);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2115); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 66, RULE_field_element);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2117); ((Field_elementContext)_localctx).name = identifier();
			setState(2118); field_type();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 68, RULE_field_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2120); data_type();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 70, RULE_param_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2122); match(WITH);
			setState(2123); match(LEFT_PAREN);
			setState(2124); param();
			setState(2129);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2125); match(COMMA);
				setState(2126); param();
				}
				}
				setState(2131);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2132); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 72, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2134); ((ParamContext)_localctx).key = match(Character_String_Literal);
			setState(2135); match(EQUAL);
			setState(2136); ((ParamContext)_localctx).value = numeric_value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 74, RULE_method_specifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2138); match(USING);
			setState(2139); ((Method_specifierContext)_localctx).m = identifier();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 76, RULE_table_space_specifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2141); match(TABLESPACE);
			setState(2142); table_space_name();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 78, RULE_table_space_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2144); identifier();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 80, RULE_table_partitioning_clauses);
		try {
			setState(2150);
			switch ( getInterpreter().adaptivePredict(_input,308,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2146); range_partitions();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2147); hash_partitions();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2148); list_partitions();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2149); column_partitions();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 82, RULE_range_partitions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2152); match(PARTITION);
			setState(2153); match(BY);
			setState(2154); match(RANGE);
			setState(2155); match(LEFT_PAREN);
			setState(2156); column_reference_list();
			setState(2157); match(RIGHT_PAREN);
			setState(2158); match(LEFT_PAREN);
			setState(2159); range_value_clause_list();
			setState(2160); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 84, RULE_range_value_clause_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2162); range_value_clause();
			setState(2167);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2163); match(COMMA);
				setState(2164); range_value_clause();
				}
				}
				setState(2169);
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
		enterRule(_localctx, 86, RULE_range_value_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2170); match(PARTITION);
			setState(2171); partition_name();
			setState(2172); match(VALUES);
			setState(2173); match(LESS);
			setState(2174); match(THAN);
			setState(2186);
			switch ( getInterpreter().adaptivePredict(_input,312,_ctx) ) {
			case 1:
				{
				setState(2175); match(LEFT_PAREN);
				setState(2176); value_expression();
				setState(2177); match(RIGHT_PAREN);
				}
				break;
			case 2:
				{
				setState(2180);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(2179); match(LEFT_PAREN);
					}
				}

				setState(2182); match(MAXVALUE);
				setState(2184);
				switch ( getInterpreter().adaptivePredict(_input,311,_ctx) ) {
				case 1:
					{
					setState(2183); match(RIGHT_PAREN);
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
		enterRule(_localctx, 88, RULE_hash_partitions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2188); match(PARTITION);
			setState(2189); match(BY);
			setState(2190); match(HASH);
			setState(2191); match(LEFT_PAREN);
			setState(2192); column_reference_list();
			setState(2193); match(RIGHT_PAREN);
			setState(2199);
			switch (_input.LA(1)) {
			case LEFT_PAREN:
				{
				setState(2194); match(LEFT_PAREN);
				setState(2195); individual_hash_partitions();
				setState(2196); match(RIGHT_PAREN);
				}
				break;
			case PARTITIONS:
				{
				setState(2198); hash_partitions_by_quantity();
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
		enterRule(_localctx, 90, RULE_individual_hash_partitions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2201); individual_hash_partition();
			setState(2206);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2202); match(COMMA);
				setState(2203); individual_hash_partition();
				}
				}
				setState(2208);
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
		enterRule(_localctx, 92, RULE_individual_hash_partition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2209); match(PARTITION);
			setState(2210); partition_name();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 94, RULE_hash_partitions_by_quantity);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2212); match(PARTITIONS);
			setState(2213); ((Hash_partitions_by_quantityContext)_localctx).quantity = numeric_value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 96, RULE_list_partitions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2215); match(PARTITION);
			setState(2216); match(BY);
			setState(2217); match(LIST);
			setState(2218); match(LEFT_PAREN);
			setState(2219); column_reference_list();
			setState(2220); match(RIGHT_PAREN);
			setState(2221); match(LEFT_PAREN);
			setState(2222); list_value_clause_list();
			setState(2223); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 98, RULE_list_value_clause_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2225); list_value_partition();
			setState(2230);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2226); match(COMMA);
				setState(2227); list_value_partition();
				}
				}
				setState(2232);
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
		enterRule(_localctx, 100, RULE_list_value_partition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2233); match(PARTITION);
			setState(2234); partition_name();
			setState(2235); match(VALUES);
			setState(2237);
			_la = _input.LA(1);
			if (_la==IN) {
				{
				setState(2236); match(IN);
				}
			}

			setState(2239); match(LEFT_PAREN);
			setState(2240); in_value_list();
			setState(2241); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 102, RULE_column_partitions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2243); match(PARTITION);
			setState(2244); match(BY);
			setState(2245); match(COLUMN);
			setState(2246); table_elements();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 104, RULE_partition_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2248); identifier();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 106, RULE_drop_table_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2250); match(DROP);
			setState(2251); match(TABLE);
			setState(2252); schema_qualified_name();
			setState(2254);
			switch ( getInterpreter().adaptivePredict(_input,317,_ctx) ) {
			case 1:
				{
				setState(2253); match(PURGE);
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
		enterRule(_localctx, 108, RULE_identifier);
		int _la;
		try {
			setState(2264);
			switch (_input.LA(1)) {
			case QUOTE:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(2257);
				_la = _input.LA(1);
				if (_la==QUOTE) {
					{
					setState(2256); match(QUOTE);
					}
				}

				setState(2259); match(Identifier);
				setState(2261);
				switch ( getInterpreter().adaptivePredict(_input,319,_ctx) ) {
				case 1:
					{
					setState(2260); match(QUOTE);
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
				setState(2263); nonreserved_keywords();
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
		enterRule(_localctx, 110, RULE_nonreserved_keywords);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2266);
			_la = _input.LA(1);
			if ( !(((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (ADMIN - 128)) | (1L << (AVG - 128)) | (1L << (BETWEEN - 128)) | (1L << (BY - 128)) | (1L << (CACHE - 128)) | (1L << (CALLED - 128)) | (1L << (CLASS - 128)) | (1L << (CENTURY - 128)) | (1L << (CHARACTER - 128)) | (1L << (CHECK - 128)) | (1L << (COLLECT - 128)) | (1L << (COALESCE - 128)) | (1L << (COLUMN - 128)) | (1L << (COMMENT - 128)) | (1L << (COMMENTS - 128)) | (1L << (COMMIT - 128)) | (1L << (CONFIGURATION - 128)) | (1L << (COST - 128)) | (1L << (COUNT - 128)) | (1L << (CUBE - 128)) | (1L << (CURRENT - 128)) | (1L << (CYCLE - 128)) | (1L << (DATA - 128)) | (1L << (DAY - 128)) | (1L << (DEC - 128)) | (1L << (DECADE - 128)) | (1L << (DEFINER - 128)) | (1L << (DICTIONARY - 128)) | (1L << (DOW - 128)) | (1L << (DOY - 128)) | (1L << (DROP - 128)) | (1L << (EPOCH - 128)) | (1L << (EVERY - 128)) | (1L << (EXISTS - 128)) | (1L << (EXTERNAL - 128)) | (1L << (EXTRACT - 128)) | (1L << (FAMILY - 128)) | (1L << (FILTER - 128)) | (1L << (FIRST - 128)) | (1L << (FORMAT - 128)) | (1L << (FUSION - 128)) | (1L << (GROUPING - 128)) | (1L << (HASH - 128)) | (1L << (INDEX - 128)) | (1L << (INCREMENT - 128)) | (1L << (INPUT - 128)) | (1L << (INSERT - 128)) | (1L << (INTERSECTION - 128)) | (1L << (ISCACHABLE - 128)) | (1L << (ISODOW - 128)) | (1L << (ISOYEAR - 128)) | (1L << (ISSTRICT - 128)) | (1L << (LANGUAGE - 128)) | (1L << (LARGE - 128)) | (1L << (LAST - 128)) | (1L << (LESS - 128)) | (1L << (LIST - 128)) | (1L << (LOCATION - 128)) | (1L << (MATCH - 128)) | (1L << (MAX - 128)) | (1L << (MAXVALUE - 128)) | (1L << (MICROSECONDS - 128)))) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (MILLENNIUM - 192)) | (1L << (MILLISECONDS - 192)) | (1L << (MIN - 192)) | (1L << (MINVALUE - 192)) | (1L << (MINUTE - 192)) | (1L << (MONTH - 192)) | (1L << (NATIONAL - 192)) | (1L << (NO - 192)) | (1L << (NONE - 192)) | (1L << (NULLIF - 192)) | (1L << (OBJECT - 192)) | (1L << (OPTION - 192)) | (1L << (OPTIONS - 192)) | (1L << (OVERWRITE - 192)) | (1L << (PARSER - 192)) | (1L << (PARTIAL - 192)) | (1L << (PARTITION - 192)) | (1L << (PARTITIONS - 192)) | (1L << (PRECISION - 192)) | (1L << (PUBLIC - 192)) | (1L << (PURGE - 192)) | (1L << (QUARTER - 192)) | (1L << (RANGE - 192)) | (1L << (REGEXP - 192)) | (1L << (RLIKE - 192)) | (1L << (ROLLUP - 192)) | (1L << (SEARCH - 192)) | (1L << (SECOND - 192)) | (1L << (SECURITY - 192)) | (1L << (SERVER - 192)) | (1L << (SET - 192)) | (1L << (SIMILAR - 192)) | (1L << (SIMPLE - 192)) | (1L << (STABLE - 192)) | (1L << (START - 192)) | (1L << (STORAGE - 192)) | (1L << (STDDEV_POP - 192)) | (1L << (STDDEV_SAMP - 192)) | (1L << (SUBPARTITION - 192)) | (1L << (SUM - 192)) | (1L << (TABLESPACE - 192)) | (1L << (TEMPLATE - 192)) | (1L << (THAN - 192)) | (1L << (TIMEZONE - 192)) | (1L << (TIMEZONE_HOUR - 192)) | (1L << (TIMEZONE_MINUTE - 192)) | (1L << (TRIM - 192)) | (1L << (TO - 192)) | (1L << (UNKNOWN - 192)) | (1L << (UNLOGGED - 192)) | (1L << (VALUES - 192)) | (1L << (VAR_SAMP - 192)) | (1L << (VAR_POP - 192)) | (1L << (VARYING - 192)) | (1L << (VOLATILE - 192)) | (1L << (WEEK - 192)) | (1L << (WINDOW - 192)) | (1L << (WRAPPER - 192)) | (1L << (YEAR - 192)) | (1L << (ZONE - 192)) | (1L << (BOOLEAN - 192)) | (1L << (BOOL - 192)))) != 0) || ((((_la - 256)) & ~0x3f) == 0 && ((1L << (_la - 256)) & ((1L << (BIT - 256)) | (1L << (VARBIT - 256)) | (1L << (INT1 - 256)) | (1L << (INT2 - 256)) | (1L << (INT4 - 256)) | (1L << (INT8 - 256)) | (1L << (TINYINT - 256)) | (1L << (SMALLINT - 256)) | (1L << (INT - 256)) | (1L << (INTEGER - 256)) | (1L << (BIGINT - 256)) | (1L << (FLOAT4 - 256)) | (1L << (FLOAT8 - 256)) | (1L << (REAL - 256)) | (1L << (FLOAT - 256)) | (1L << (DOUBLE - 256)) | (1L << (NUMERIC - 256)) | (1L << (DECIMAL - 256)) | (1L << (CHAR - 256)) | (1L << (VARCHAR - 256)) | (1L << (NCHAR - 256)) | (1L << (NVARCHAR - 256)) | (1L << (DATE - 256)) | (1L << (TIME - 256)) | (1L << (TIMETZ - 256)) | (1L << (TIMESTAMP - 256)) | (1L << (TIMESTAMPTZ - 256)) | (1L << (TEXT - 256)) | (1L << (VARBINARY - 256)) | (1L << (BLOB - 256)) | (1L << (BYTEA - 256)) | (1L << (INET4 - 256)))) != 0)) ) {
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
		enterRule(_localctx, 112, RULE_unsigned_literal);
		try {
			setState(2270);
			switch (_input.LA(1)) {
			case NUMBER:
			case REAL_NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(2268); unsigned_numeric_literal();
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
				setState(2269); general_literal();
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
		enterRule(_localctx, 114, RULE_general_literal);
		try {
			setState(2275);
			switch (_input.LA(1)) {
			case Character_String_Literal:
				enterOuterAlt(_localctx, 1);
				{
				setState(2272); match(Character_String_Literal);
				}
				break;
			case DATE:
			case TIME:
			case TIMESTAMP:
				enterOuterAlt(_localctx, 2);
				{
				setState(2273); datetime_literal();
				}
				break;
			case FALSE:
			case TRUE:
			case UNKNOWN:
				enterOuterAlt(_localctx, 3);
				{
				setState(2274); boolean_literal();
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
		enterRule(_localctx, 116, RULE_datetime_literal);
		try {
			setState(2280);
			switch (_input.LA(1)) {
			case TIMESTAMP:
				enterOuterAlt(_localctx, 1);
				{
				setState(2277); timestamp_literal();
				}
				break;
			case TIME:
				enterOuterAlt(_localctx, 2);
				{
				setState(2278); time_literal();
				}
				break;
			case DATE:
				enterOuterAlt(_localctx, 3);
				{
				setState(2279); date_literal();
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
		enterRule(_localctx, 118, RULE_time_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2282); match(TIME);
			setState(2283); ((Time_literalContext)_localctx).time_string = match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 120, RULE_timestamp_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2285); match(TIMESTAMP);
			setState(2286); ((Timestamp_literalContext)_localctx).timestamp_string = match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 122, RULE_date_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2288); match(DATE);
			setState(2289); ((Date_literalContext)_localctx).date_string = match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 124, RULE_boolean_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2291);
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
		enterRule(_localctx, 126, RULE_data_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2293); predefined_type();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 128, RULE_predefined_type);
		try {
			setState(2305);
			switch (_input.LA(1)) {
			case CHARACTER:
			case CHAR:
			case VARCHAR:
			case TEXT:
				enterOuterAlt(_localctx, 1);
				{
				setState(2295); character_string_type();
				}
				break;
			case NATIONAL:
			case NCHAR:
			case NVARCHAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(2296); national_character_string_type();
				}
				break;
			case BLOB:
			case BYTEA:
				enterOuterAlt(_localctx, 3);
				{
				setState(2297); binary_large_object_string_type();
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
				setState(2298); numeric_type();
				}
				break;
			case BOOLEAN:
			case BOOL:
				enterOuterAlt(_localctx, 5);
				{
				setState(2299); boolean_type();
				}
				break;
			case DATE:
			case TIME:
			case TIMETZ:
			case TIMESTAMP:
			case TIMESTAMPTZ:
				enterOuterAlt(_localctx, 6);
				{
				setState(2300); datetime_type();
				}
				break;
			case BIT:
			case VARBIT:
				enterOuterAlt(_localctx, 7);
				{
				setState(2301); bit_type();
				}
				break;
			case BINARY:
			case VARBINARY:
				enterOuterAlt(_localctx, 8);
				{
				setState(2302); binary_type();
				}
				break;
			case INET4:
				enterOuterAlt(_localctx, 9);
				{
				setState(2303); network_type();
				}
				break;
			case REGCLASS:
				enterOuterAlt(_localctx, 10);
				{
				setState(2304); regclass();
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
		enterRule(_localctx, 130, RULE_regclass);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2307); match(REGCLASS);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 132, RULE_network_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2309); match(INET4);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 134, RULE_character_string_type);
		try {
			setState(2334);
			switch ( getInterpreter().adaptivePredict(_input,330,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2311); match(CHARACTER);
				setState(2313);
				switch ( getInterpreter().adaptivePredict(_input,325,_ctx) ) {
				case 1:
					{
					setState(2312); type_length();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2315); match(CHAR);
				setState(2317);
				switch ( getInterpreter().adaptivePredict(_input,326,_ctx) ) {
				case 1:
					{
					setState(2316); type_length();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2319); match(CHARACTER);
				setState(2320); match(VARYING);
				setState(2322);
				switch ( getInterpreter().adaptivePredict(_input,327,_ctx) ) {
				case 1:
					{
					setState(2321); type_length();
					}
					break;
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2324); match(CHAR);
				setState(2325); match(VARYING);
				setState(2327);
				switch ( getInterpreter().adaptivePredict(_input,328,_ctx) ) {
				case 1:
					{
					setState(2326); type_length();
					}
					break;
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2329); match(VARCHAR);
				setState(2331);
				switch ( getInterpreter().adaptivePredict(_input,329,_ctx) ) {
				case 1:
					{
					setState(2330); type_length();
					}
					break;
				}
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2333); match(TEXT);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 136, RULE_type_length);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2336); match(LEFT_PAREN);
			setState(2337); match(NUMBER);
			setState(2338); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 138, RULE_national_character_string_type);
		try {
			setState(2375);
			switch ( getInterpreter().adaptivePredict(_input,338,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2340); match(NATIONAL);
				setState(2341); match(CHARACTER);
				setState(2343);
				switch ( getInterpreter().adaptivePredict(_input,331,_ctx) ) {
				case 1:
					{
					setState(2342); type_length();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2345); match(NATIONAL);
				setState(2346); match(CHAR);
				setState(2348);
				switch ( getInterpreter().adaptivePredict(_input,332,_ctx) ) {
				case 1:
					{
					setState(2347); type_length();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2350); match(NCHAR);
				setState(2352);
				switch ( getInterpreter().adaptivePredict(_input,333,_ctx) ) {
				case 1:
					{
					setState(2351); type_length();
					}
					break;
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2354); match(NATIONAL);
				setState(2355); match(CHARACTER);
				setState(2356); match(VARYING);
				setState(2358);
				switch ( getInterpreter().adaptivePredict(_input,334,_ctx) ) {
				case 1:
					{
					setState(2357); type_length();
					}
					break;
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2360); match(NATIONAL);
				setState(2361); match(CHAR);
				setState(2362); match(VARYING);
				setState(2364);
				switch ( getInterpreter().adaptivePredict(_input,335,_ctx) ) {
				case 1:
					{
					setState(2363); type_length();
					}
					break;
				}
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2366); match(NCHAR);
				setState(2367); match(VARYING);
				setState(2369);
				switch ( getInterpreter().adaptivePredict(_input,336,_ctx) ) {
				case 1:
					{
					setState(2368); type_length();
					}
					break;
				}
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(2371); match(NVARCHAR);
				setState(2373);
				switch ( getInterpreter().adaptivePredict(_input,337,_ctx) ) {
				case 1:
					{
					setState(2372); type_length();
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
		enterRule(_localctx, 140, RULE_binary_large_object_string_type);
		try {
			setState(2385);
			switch (_input.LA(1)) {
			case BLOB:
				enterOuterAlt(_localctx, 1);
				{
				setState(2377); match(BLOB);
				setState(2379);
				switch ( getInterpreter().adaptivePredict(_input,339,_ctx) ) {
				case 1:
					{
					setState(2378); type_length();
					}
					break;
				}
				}
				break;
			case BYTEA:
				enterOuterAlt(_localctx, 2);
				{
				setState(2381); match(BYTEA);
				setState(2383);
				switch ( getInterpreter().adaptivePredict(_input,340,_ctx) ) {
				case 1:
					{
					setState(2382); type_length();
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
		enterRule(_localctx, 142, RULE_numeric_type);
		try {
			setState(2389);
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
				setState(2387); exact_numeric_type();
				}
				break;
			case FLOAT4:
			case FLOAT8:
			case REAL:
			case FLOAT:
			case DOUBLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(2388); approximate_numeric_type();
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
		enterRule(_localctx, 144, RULE_exact_numeric_type);
		try {
			setState(2412);
			switch (_input.LA(1)) {
			case NUMERIC:
				enterOuterAlt(_localctx, 1);
				{
				setState(2391); match(NUMERIC);
				setState(2393);
				switch ( getInterpreter().adaptivePredict(_input,343,_ctx) ) {
				case 1:
					{
					setState(2392); precision_param();
					}
					break;
				}
				}
				break;
			case DECIMAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(2395); match(DECIMAL);
				setState(2397);
				switch ( getInterpreter().adaptivePredict(_input,344,_ctx) ) {
				case 1:
					{
					setState(2396); precision_param();
					}
					break;
				}
				}
				break;
			case DEC:
				enterOuterAlt(_localctx, 3);
				{
				setState(2399); match(DEC);
				setState(2401);
				switch ( getInterpreter().adaptivePredict(_input,345,_ctx) ) {
				case 1:
					{
					setState(2400); precision_param();
					}
					break;
				}
				}
				break;
			case INT1:
				enterOuterAlt(_localctx, 4);
				{
				setState(2403); match(INT1);
				}
				break;
			case TINYINT:
				enterOuterAlt(_localctx, 5);
				{
				setState(2404); match(TINYINT);
				}
				break;
			case INT2:
				enterOuterAlt(_localctx, 6);
				{
				setState(2405); match(INT2);
				}
				break;
			case SMALLINT:
				enterOuterAlt(_localctx, 7);
				{
				setState(2406); match(SMALLINT);
				}
				break;
			case INT4:
				enterOuterAlt(_localctx, 8);
				{
				setState(2407); match(INT4);
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 9);
				{
				setState(2408); match(INT);
				}
				break;
			case INTEGER:
				enterOuterAlt(_localctx, 10);
				{
				setState(2409); match(INTEGER);
				}
				break;
			case INT8:
				enterOuterAlt(_localctx, 11);
				{
				setState(2410); match(INT8);
				}
				break;
			case BIGINT:
				enterOuterAlt(_localctx, 12);
				{
				setState(2411); match(BIGINT);
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
		enterRule(_localctx, 146, RULE_approximate_numeric_type);
		try {
			setState(2424);
			switch ( getInterpreter().adaptivePredict(_input,348,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2414); match(FLOAT);
				setState(2416);
				switch ( getInterpreter().adaptivePredict(_input,347,_ctx) ) {
				case 1:
					{
					setState(2415); precision_param();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2418); match(FLOAT4);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2419); match(REAL);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2420); match(FLOAT8);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2421); match(DOUBLE);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2422); match(DOUBLE);
				setState(2423); match(PRECISION);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 148, RULE_precision_param);
		try {
			setState(2434);
			switch ( getInterpreter().adaptivePredict(_input,349,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2426); match(LEFT_PAREN);
				setState(2427); ((Precision_paramContext)_localctx).precision = match(NUMBER);
				setState(2428); match(RIGHT_PAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2429); match(LEFT_PAREN);
				setState(2430); ((Precision_paramContext)_localctx).precision = match(NUMBER);
				setState(2431); match(COMMA);
				setState(2432); ((Precision_paramContext)_localctx).scale = match(NUMBER);
				setState(2433); match(RIGHT_PAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 150, RULE_boolean_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2436);
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
		enterRule(_localctx, 152, RULE_datetime_type);
		try {
			setState(2451);
			switch ( getInterpreter().adaptivePredict(_input,350,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2438); match(DATE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2439); match(TIME);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2440); match(TIME);
				setState(2441); match(WITH);
				setState(2442); match(TIME);
				setState(2443); match(ZONE);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2444); match(TIMETZ);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2445); match(TIMESTAMP);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2446); match(TIMESTAMP);
				setState(2447); match(WITH);
				setState(2448); match(TIME);
				setState(2449); match(ZONE);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(2450); match(TIMESTAMPTZ);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 154, RULE_bit_type);
		try {
			setState(2466);
			switch ( getInterpreter().adaptivePredict(_input,354,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2453); match(BIT);
				setState(2455);
				switch ( getInterpreter().adaptivePredict(_input,351,_ctx) ) {
				case 1:
					{
					setState(2454); type_length();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2457); match(VARBIT);
				setState(2459);
				switch ( getInterpreter().adaptivePredict(_input,352,_ctx) ) {
				case 1:
					{
					setState(2458); type_length();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2461); match(BIT);
				setState(2462); match(VARYING);
				setState(2464);
				switch ( getInterpreter().adaptivePredict(_input,353,_ctx) ) {
				case 1:
					{
					setState(2463); type_length();
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
		enterRule(_localctx, 156, RULE_binary_type);
		try {
			setState(2481);
			switch ( getInterpreter().adaptivePredict(_input,358,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2468); match(BINARY);
				setState(2470);
				switch ( getInterpreter().adaptivePredict(_input,355,_ctx) ) {
				case 1:
					{
					setState(2469); type_length();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2472); match(BINARY);
				setState(2473); match(VARYING);
				setState(2475);
				switch ( getInterpreter().adaptivePredict(_input,356,_ctx) ) {
				case 1:
					{
					setState(2474); type_length();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2477); match(VARBINARY);
				setState(2479);
				switch ( getInterpreter().adaptivePredict(_input,357,_ctx) ) {
				case 1:
					{
					setState(2478); type_length();
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
		enterRule(_localctx, 158, RULE_value_expression_primary);
		try {
			setState(2485);
			switch ( getInterpreter().adaptivePredict(_input,359,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2483); parenthesized_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2484); nonparenthesized_value_expression_primary();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 160, RULE_parenthesized_value_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2487); match(LEFT_PAREN);
			setState(2488); value_expression();
			setState(2489); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 162, RULE_nonparenthesized_value_expression_primary);
		try {
			setState(2498);
			switch ( getInterpreter().adaptivePredict(_input,360,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2491); unsigned_value_specification();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2492); column_reference();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2493); set_function_specification();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2494); scalar_subquery();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2495); case_expression();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2496); cast_specification();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(2497); routine_invocation();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 164, RULE_unsigned_value_specification);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2500); unsigned_literal();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 166, RULE_unsigned_numeric_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2502);
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
		enterRule(_localctx, 168, RULE_signed_numerical_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2505);
			_la = _input.LA(1);
			if (_la==PLUS || _la==MINUS) {
				{
				setState(2504); sign();
				}
			}

			setState(2507); unsigned_numeric_literal();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 170, RULE_set_function_specification);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2509); aggregate_function();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 172, RULE_aggregate_function);
		try {
			setState(2519);
			switch ( getInterpreter().adaptivePredict(_input,363,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2511); match(COUNT);
				setState(2512); match(LEFT_PAREN);
				setState(2513); match(MULTIPLY);
				setState(2514); match(RIGHT_PAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2515); general_set_function();
				setState(2517);
				switch ( getInterpreter().adaptivePredict(_input,362,_ctx) ) {
				case 1:
					{
					setState(2516); filter_clause();
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
		enterRule(_localctx, 174, RULE_general_set_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2521); set_function_type();
			setState(2522); match(LEFT_PAREN);
			setState(2524);
			_la = _input.LA(1);
			if (_la==ALL || _la==DISTINCT) {
				{
				setState(2523); set_qualifier();
				}
			}

			setState(2526); value_expression();
			setState(2527); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 176, RULE_set_function_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2529);
			_la = _input.LA(1);
			if ( !(_la==ANY || ((((_la - 104)) & ~0x3f) == 0 && ((1L << (_la - 104)) & ((1L << (SOME - 104)) | (1L << (AVG - 104)) | (1L << (COLLECT - 104)) | (1L << (COUNT - 104)) | (1L << (EVERY - 104)))) != 0) || ((((_la - 168)) & ~0x3f) == 0 && ((1L << (_la - 168)) & ((1L << (FUSION - 168)) | (1L << (INTERSECTION - 168)) | (1L << (MAX - 168)) | (1L << (MIN - 168)) | (1L << (STDDEV_POP - 168)) | (1L << (STDDEV_SAMP - 168)) | (1L << (SUM - 168)))) != 0) || _la==VAR_SAMP || _la==VAR_POP) ) {
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
		enterRule(_localctx, 178, RULE_filter_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2531); match(FILTER);
			setState(2532); match(LEFT_PAREN);
			setState(2533); match(WHERE);
			setState(2534); search_condition();
			setState(2535); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 180, RULE_grouping_operation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2537); match(GROUPING);
			setState(2538); match(LEFT_PAREN);
			setState(2539); column_reference_list();
			setState(2540); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 182, RULE_case_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2542); case_specification();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 184, RULE_case_abbreviation);
		int _la;
		try {
			setState(2562);
			switch (_input.LA(1)) {
			case NULLIF:
				enterOuterAlt(_localctx, 1);
				{
				setState(2544); match(NULLIF);
				setState(2545); match(LEFT_PAREN);
				setState(2546); numeric_value_expression();
				setState(2547); match(COMMA);
				setState(2548); boolean_value_expression();
				setState(2549); match(RIGHT_PAREN);
				}
				break;
			case COALESCE:
				enterOuterAlt(_localctx, 2);
				{
				setState(2551); match(COALESCE);
				setState(2552); match(LEFT_PAREN);
				setState(2553); numeric_value_expression();
				setState(2556); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(2554); match(COMMA);
					setState(2555); boolean_value_expression();
					}
					}
					setState(2558); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==COMMA );
				setState(2560); match(RIGHT_PAREN);
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
		enterRule(_localctx, 186, RULE_case_specification);
		try {
			setState(2566);
			switch ( getInterpreter().adaptivePredict(_input,367,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2564); simple_case();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2565); searched_case();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 188, RULE_simple_case);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2568); match(CASE);
			setState(2569); boolean_value_expression();
			setState(2571); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(2570); simple_when_clause();
				}
				}
				setState(2573); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WHEN );
			setState(2576);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(2575); else_clause();
				}
			}

			setState(2578); match(END);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 190, RULE_searched_case);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2580); match(CASE);
			setState(2582); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(2581); searched_when_clause();
				}
				}
				setState(2584); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WHEN );
			setState(2587);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(2586); else_clause();
				}
			}

			setState(2589); match(END);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 192, RULE_simple_when_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2591); match(WHEN);
			setState(2592); search_condition();
			setState(2593); match(THEN);
			setState(2594); result();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 194, RULE_searched_when_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2596); match(WHEN);
			setState(2597); ((Searched_when_clauseContext)_localctx).c = search_condition();
			setState(2598); match(THEN);
			setState(2599); ((Searched_when_clauseContext)_localctx).r = result();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 196, RULE_else_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2601); match(ELSE);
			setState(2602); ((Else_clauseContext)_localctx).r = result();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 198, RULE_result);
		try {
			setState(2606);
			switch ( getInterpreter().adaptivePredict(_input,372,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2604); value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2605); match(NULL);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 200, RULE_cast_specification);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2608); match(CAST);
			setState(2609); match(LEFT_PAREN);
			setState(2610); cast_operand();
			setState(2611); match(AS);
			setState(2612); cast_target();
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
		enterRule(_localctx, 202, RULE_cast_operand);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2615); value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 204, RULE_cast_target);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2617); data_type();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 206, RULE_value_expression);
		try {
			setState(2622);
			switch ( getInterpreter().adaptivePredict(_input,373,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2619); common_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2620); row_value_expression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2621); boolean_value_expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 208, RULE_common_value_expression);
		try {
			setState(2627);
			switch ( getInterpreter().adaptivePredict(_input,374,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2624); numeric_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2625); string_value_expression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2626); match(NULL);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 210, RULE_numeric_value_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2629); ((Numeric_value_expressionContext)_localctx).left = term();
			setState(2634);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				{
				setState(2630);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(2631); ((Numeric_value_expressionContext)_localctx).right = term();
				}
				}
				setState(2636);
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
		enterRule(_localctx, 212, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2637); ((TermContext)_localctx).left = factor();
			setState(2642);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 310)) & ~0x3f) == 0 && ((1L << (_la - 310)) & ((1L << (MULTIPLY - 310)) | (1L << (DIVIDE - 310)) | (1L << (MODULAR - 310)))) != 0)) {
				{
				{
				setState(2638);
				_la = _input.LA(1);
				if ( !(((((_la - 310)) & ~0x3f) == 0 && ((1L << (_la - 310)) & ((1L << (MULTIPLY - 310)) | (1L << (DIVIDE - 310)) | (1L << (MODULAR - 310)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(2639); ((TermContext)_localctx).right = factor();
				}
				}
				setState(2644);
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
		enterRule(_localctx, 214, RULE_factor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2646);
			_la = _input.LA(1);
			if (_la==PLUS || _la==MINUS) {
				{
				setState(2645); sign();
				}
			}

			setState(2648); numeric_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 216, RULE_array);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2650); match(LEFT_PAREN);
			setState(2651); numeric_value_expression();
			setState(2656);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2652); match(COMMA);
				setState(2653); numeric_value_expression();
				}
				}
				setState(2658);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2659); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 218, RULE_numeric_primary);
		int _la;
		try {
			setState(2670);
			switch ( getInterpreter().adaptivePredict(_input,380,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2661); value_expression_primary();
				setState(2666);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CAST_EXPRESSION) {
					{
					{
					setState(2662); match(CAST_EXPRESSION);
					setState(2663); cast_target();
					}
					}
					setState(2668);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2669); numeric_value_function();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 220, RULE_sign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2672);
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
		enterRule(_localctx, 222, RULE_numeric_value_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2674); extract_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 224, RULE_extract_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2676); match(EXTRACT);
			setState(2677); match(LEFT_PAREN);
			setState(2678); ((Extract_expressionContext)_localctx).extract_field_string = extract_field();
			setState(2679); match(FROM);
			setState(2680); extract_source();
			setState(2681); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 226, RULE_extract_field);
		try {
			setState(2686);
			switch (_input.LA(1)) {
			case DAY:
			case HOUR:
			case MINUTE:
			case MONTH:
			case SECOND:
			case YEAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(2683); primary_datetime_field();
				}
				break;
			case TIMEZONE:
			case TIMEZONE_HOUR:
			case TIMEZONE_MINUTE:
				enterOuterAlt(_localctx, 2);
				{
				setState(2684); time_zone_field();
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
				setState(2685); extended_datetime_field();
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
		enterRule(_localctx, 228, RULE_time_zone_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2688);
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
		enterRule(_localctx, 230, RULE_extract_source);
		try {
			setState(2692);
			switch ( getInterpreter().adaptivePredict(_input,382,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2690); column_reference();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2691); datetime_literal();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 232, RULE_string_value_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2694); character_value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 234, RULE_character_value_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2696); character_factor();
			setState(2701);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CONCATENATION_OPERATOR) {
				{
				{
				setState(2697); match(CONCATENATION_OPERATOR);
				setState(2698); character_factor();
				}
				}
				setState(2703);
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
		enterRule(_localctx, 236, RULE_character_factor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2704); character_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 238, RULE_character_primary);
		try {
			setState(2708);
			switch ( getInterpreter().adaptivePredict(_input,384,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2706); value_expression_primary();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2707); string_value_function();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 240, RULE_string_value_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2710); trim_function();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 242, RULE_trim_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2712); match(TRIM);
			setState(2713); match(LEFT_PAREN);
			setState(2714); trim_operands();
			setState(2715); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 244, RULE_trim_operands);
		int _la;
		try {
			setState(2731);
			switch ( getInterpreter().adaptivePredict(_input,388,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2724);
				switch ( getInterpreter().adaptivePredict(_input,387,_ctx) ) {
				case 1:
					{
					setState(2718);
					_la = _input.LA(1);
					if (_la==BOTH || _la==LEADING || _la==TRAILING) {
						{
						setState(2717); trim_specification();
						}
					}

					setState(2721);
					_la = _input.LA(1);
					if (((((_la - 6)) & ~0x3f) == 0 && ((1L << (_la - 6)) & ((1L << (ANY - 6)) | (1L << (CASE - 6)) | (1L << (CAST - 6)) | (1L << (FALSE - 6)) | (1L << (LEFT - 6)))) != 0) || ((((_la - 97)) & ~0x3f) == 0 && ((1L << (_la - 97)) & ((1L << (RIGHT - 97)) | (1L << (SOME - 97)) | (1L << (TRUE - 97)) | (1L << (ADMIN - 97)) | (1L << (AVG - 97)) | (1L << (BETWEEN - 97)) | (1L << (BY - 97)) | (1L << (CACHE - 97)) | (1L << (CALLED - 97)) | (1L << (CLASS - 97)) | (1L << (CENTURY - 97)) | (1L << (CHARACTER - 97)) | (1L << (CHECK - 97)) | (1L << (COLLECT - 97)) | (1L << (COALESCE - 97)) | (1L << (COLUMN - 97)) | (1L << (COMMENT - 97)) | (1L << (COMMENTS - 97)) | (1L << (COMMIT - 97)) | (1L << (CONFIGURATION - 97)) | (1L << (COST - 97)) | (1L << (COUNT - 97)) | (1L << (CUBE - 97)) | (1L << (CURRENT - 97)) | (1L << (CYCLE - 97)) | (1L << (DATA - 97)) | (1L << (DAY - 97)) | (1L << (DEC - 97)) | (1L << (DECADE - 97)) | (1L << (DEFINER - 97)) | (1L << (DICTIONARY - 97)) | (1L << (DOW - 97)) | (1L << (DOY - 97)) | (1L << (DROP - 97)) | (1L << (EPOCH - 97)) | (1L << (EVERY - 97)))) != 0) || ((((_la - 161)) & ~0x3f) == 0 && ((1L << (_la - 161)) & ((1L << (EXISTS - 161)) | (1L << (EXTERNAL - 161)) | (1L << (EXTRACT - 161)) | (1L << (FAMILY - 161)) | (1L << (FILTER - 161)) | (1L << (FIRST - 161)) | (1L << (FORMAT - 161)) | (1L << (FUSION - 161)) | (1L << (GROUPING - 161)) | (1L << (HASH - 161)) | (1L << (INDEX - 161)) | (1L << (INCREMENT - 161)) | (1L << (INPUT - 161)) | (1L << (INSERT - 161)) | (1L << (INTERSECTION - 161)) | (1L << (ISCACHABLE - 161)) | (1L << (ISODOW - 161)) | (1L << (ISOYEAR - 161)) | (1L << (ISSTRICT - 161)) | (1L << (LANGUAGE - 161)) | (1L << (LARGE - 161)) | (1L << (LAST - 161)) | (1L << (LESS - 161)) | (1L << (LIST - 161)) | (1L << (LOCATION - 161)) | (1L << (MATCH - 161)) | (1L << (MAX - 161)) | (1L << (MAXVALUE - 161)) | (1L << (MICROSECONDS - 161)) | (1L << (MILLENNIUM - 161)) | (1L << (MILLISECONDS - 161)) | (1L << (MIN - 161)) | (1L << (MINVALUE - 161)) | (1L << (MINUTE - 161)) | (1L << (MONTH - 161)) | (1L << (NATIONAL - 161)) | (1L << (NO - 161)) | (1L << (NONE - 161)) | (1L << (NULLIF - 161)) | (1L << (OBJECT - 161)) | (1L << (OPTION - 161)) | (1L << (OPTIONS - 161)) | (1L << (OVERWRITE - 161)) | (1L << (PARSER - 161)) | (1L << (PARTIAL - 161)) | (1L << (PARTITION - 161)) | (1L << (PARTITIONS - 161)) | (1L << (PRECISION - 161)) | (1L << (PUBLIC - 161)) | (1L << (PURGE - 161)) | (1L << (QUARTER - 161)) | (1L << (RANGE - 161)) | (1L << (REGEXP - 161)) | (1L << (RLIKE - 161)) | (1L << (ROLLUP - 161)) | (1L << (SEARCH - 161)) | (1L << (SECOND - 161)) | (1L << (SECURITY - 161)) | (1L << (SERVER - 161)) | (1L << (SET - 161)) | (1L << (SIMILAR - 161)) | (1L << (SIMPLE - 161)))) != 0) || ((((_la - 225)) & ~0x3f) == 0 && ((1L << (_la - 225)) & ((1L << (STABLE - 225)) | (1L << (START - 225)) | (1L << (STORAGE - 225)) | (1L << (STDDEV_POP - 225)) | (1L << (STDDEV_SAMP - 225)) | (1L << (SUBPARTITION - 225)) | (1L << (SUM - 225)) | (1L << (TABLESPACE - 225)) | (1L << (TEMPLATE - 225)) | (1L << (THAN - 225)) | (1L << (TIMEZONE - 225)) | (1L << (TIMEZONE_HOUR - 225)) | (1L << (TIMEZONE_MINUTE - 225)) | (1L << (TRIM - 225)) | (1L << (TO - 225)) | (1L << (UNKNOWN - 225)) | (1L << (UNLOGGED - 225)) | (1L << (VALUES - 225)) | (1L << (VAR_SAMP - 225)) | (1L << (VAR_POP - 225)) | (1L << (VARYING - 225)) | (1L << (VOLATILE - 225)) | (1L << (WEEK - 225)) | (1L << (WINDOW - 225)) | (1L << (WRAPPER - 225)) | (1L << (YEAR - 225)) | (1L << (ZONE - 225)) | (1L << (BOOLEAN - 225)) | (1L << (BOOL - 225)) | (1L << (BIT - 225)) | (1L << (VARBIT - 225)) | (1L << (INT1 - 225)) | (1L << (INT2 - 225)) | (1L << (INT4 - 225)) | (1L << (INT8 - 225)) | (1L << (TINYINT - 225)) | (1L << (SMALLINT - 225)) | (1L << (INT - 225)) | (1L << (INTEGER - 225)) | (1L << (BIGINT - 225)) | (1L << (FLOAT4 - 225)) | (1L << (FLOAT8 - 225)) | (1L << (REAL - 225)) | (1L << (FLOAT - 225)) | (1L << (DOUBLE - 225)) | (1L << (NUMERIC - 225)) | (1L << (DECIMAL - 225)) | (1L << (CHAR - 225)) | (1L << (VARCHAR - 225)) | (1L << (NCHAR - 225)) | (1L << (NVARCHAR - 225)) | (1L << (DATE - 225)) | (1L << (TIME - 225)) | (1L << (TIMETZ - 225)) | (1L << (TIMESTAMP - 225)) | (1L << (TIMESTAMPTZ - 225)) | (1L << (TEXT - 225)) | (1L << (VARBINARY - 225)) | (1L << (BLOB - 225)) | (1L << (BYTEA - 225)))) != 0) || ((((_la - 289)) & ~0x3f) == 0 && ((1L << (_la - 289)) & ((1L << (INET4 - 289)) | (1L << (LEFT_PAREN - 289)) | (1L << (QUOTE - 289)) | (1L << (NUMBER - 289)) | (1L << (REAL_NUMBER - 289)) | (1L << (Identifier - 289)) | (1L << (Character_String_Literal - 289)))) != 0)) {
						{
						setState(2720); ((Trim_operandsContext)_localctx).trim_character = character_value_expression();
						}
					}

					setState(2723); match(FROM);
					}
					break;
				}
				setState(2726); ((Trim_operandsContext)_localctx).trim_source = character_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2727); ((Trim_operandsContext)_localctx).trim_source = character_value_expression();
				setState(2728); match(COMMA);
				setState(2729); ((Trim_operandsContext)_localctx).trim_character = character_value_expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 246, RULE_trim_specification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2733);
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
		enterRule(_localctx, 248, RULE_boolean_value_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2735); or_predicate();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 250, RULE_or_predicate);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2737); and_predicate();
			setState(2742);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,389,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(2738); match(OR);
					setState(2739); or_predicate();
					}
					} 
				}
				setState(2744);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,389,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 252, RULE_and_predicate);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2745); boolean_factor();
			setState(2750);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,390,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(2746); match(AND);
					setState(2747); and_predicate();
					}
					} 
				}
				setState(2752);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,390,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 254, RULE_boolean_factor);
		try {
			setState(2756);
			switch ( getInterpreter().adaptivePredict(_input,391,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2753); boolean_test();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2754); match(NOT);
				setState(2755); boolean_test();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 256, RULE_boolean_test);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2758); boolean_primary();
			setState(2760);
			_la = _input.LA(1);
			if (_la==IS) {
				{
				setState(2759); is_clause();
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
		enterRule(_localctx, 258, RULE_is_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2762); match(IS);
			setState(2764);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(2763); match(NOT);
				}
			}

			setState(2766); ((Is_clauseContext)_localctx).t = truth_value();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 260, RULE_truth_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2768);
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
		enterRule(_localctx, 262, RULE_boolean_primary);
		try {
			setState(2772);
			switch ( getInterpreter().adaptivePredict(_input,394,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2770); predicate();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2771); boolean_predicand();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 264, RULE_boolean_predicand);
		try {
			setState(2776);
			switch ( getInterpreter().adaptivePredict(_input,395,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2774); parenthesized_boolean_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2775); nonparenthesized_value_expression_primary();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 266, RULE_parenthesized_boolean_value_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2778); match(LEFT_PAREN);
			setState(2779); boolean_value_expression();
			setState(2780); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 268, RULE_row_value_expression);
		try {
			setState(2784);
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
				setState(2782); row_value_special_case();
				}
				break;
			case NULL:
				enterOuterAlt(_localctx, 2);
				{
				setState(2783); explicit_row_value_constructor();
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
		enterRule(_localctx, 270, RULE_row_value_special_case);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2786); nonparenthesized_value_expression_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 272, RULE_explicit_row_value_constructor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2788); match(NULL);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 274, RULE_row_value_predicand);
		try {
			setState(2792);
			switch ( getInterpreter().adaptivePredict(_input,397,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2790); row_value_special_case();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2791); row_value_constructor_predicand();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 276, RULE_row_value_constructor_predicand);
		try {
			setState(2796);
			switch ( getInterpreter().adaptivePredict(_input,398,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2794); common_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2795); boolean_predicand();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 278, RULE_table_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2798); from_clause();
			setState(2800);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(2799); where_clause();
				}
			}

			setState(2803);
			_la = _input.LA(1);
			if (_la==GROUP) {
				{
				setState(2802); groupby_clause();
				}
			}

			setState(2806);
			_la = _input.LA(1);
			if (_la==HAVING) {
				{
				setState(2805); having_clause();
				}
			}

			setState(2809);
			_la = _input.LA(1);
			if (_la==ORDER) {
				{
				setState(2808); orderby_clause();
				}
			}

			setState(2812);
			_la = _input.LA(1);
			if (_la==LIMIT) {
				{
				setState(2811); limit_clause();
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
		enterRule(_localctx, 280, RULE_from_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2814); match(FROM);
			setState(2815); table_reference_list();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 282, RULE_table_reference_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2817); table_reference();
			setState(2822);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2818); match(COMMA);
				setState(2819); table_reference();
				}
				}
				setState(2824);
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
		enterRule(_localctx, 284, RULE_table_reference);
		try {
			setState(2827);
			switch ( getInterpreter().adaptivePredict(_input,405,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2825); joined_table();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2826); table_primary();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 286, RULE_joined_table);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2829); table_primary();
			setState(2831); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(2830); joined_table_primary();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(2833); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,406,_ctx);
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
		enterRule(_localctx, 288, RULE_joined_table_primary);
		int _la;
		try {
			setState(2854);
			switch (_input.LA(1)) {
			case CROSS:
				enterOuterAlt(_localctx, 1);
				{
				setState(2835); match(CROSS);
				setState(2836); match(JOIN);
				setState(2837); ((Joined_table_primaryContext)_localctx).right = table_primary();
				}
				break;
			case FULL:
			case INNER:
			case JOIN:
			case LEFT:
			case RIGHT:
				enterOuterAlt(_localctx, 2);
				{
				setState(2839);
				_la = _input.LA(1);
				if (((((_la - 42)) & ~0x3f) == 0 && ((1L << (_la - 42)) & ((1L << (FULL - 42)) | (1L << (INNER - 42)) | (1L << (LEFT - 42)) | (1L << (RIGHT - 42)))) != 0)) {
					{
					setState(2838); ((Joined_table_primaryContext)_localctx).t = join_type();
					}
				}

				setState(2841); match(JOIN);
				setState(2842); ((Joined_table_primaryContext)_localctx).right = table_primary();
				setState(2843); ((Joined_table_primaryContext)_localctx).s = join_specification();
				}
				break;
			case NATURAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(2845); match(NATURAL);
				setState(2847);
				_la = _input.LA(1);
				if (((((_la - 42)) & ~0x3f) == 0 && ((1L << (_la - 42)) & ((1L << (FULL - 42)) | (1L << (INNER - 42)) | (1L << (LEFT - 42)) | (1L << (RIGHT - 42)))) != 0)) {
					{
					setState(2846); ((Joined_table_primaryContext)_localctx).t = join_type();
					}
				}

				setState(2849); match(JOIN);
				setState(2850); ((Joined_table_primaryContext)_localctx).right = table_primary();
				}
				break;
			case UNION:
				enterOuterAlt(_localctx, 4);
				{
				setState(2851); match(UNION);
				setState(2852); match(JOIN);
				setState(2853); ((Joined_table_primaryContext)_localctx).right = table_primary();
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
		enterRule(_localctx, 290, RULE_cross_join);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2856); match(CROSS);
			setState(2857); match(JOIN);
			setState(2858); ((Cross_joinContext)_localctx).r = table_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 292, RULE_qualified_join);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2861);
			_la = _input.LA(1);
			if (((((_la - 42)) & ~0x3f) == 0 && ((1L << (_la - 42)) & ((1L << (FULL - 42)) | (1L << (INNER - 42)) | (1L << (LEFT - 42)) | (1L << (RIGHT - 42)))) != 0)) {
				{
				setState(2860); ((Qualified_joinContext)_localctx).t = join_type();
				}
			}

			setState(2863); match(JOIN);
			setState(2864); ((Qualified_joinContext)_localctx).r = table_primary();
			setState(2865); ((Qualified_joinContext)_localctx).s = join_specification();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 294, RULE_natural_join);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2867); match(NATURAL);
			setState(2869);
			_la = _input.LA(1);
			if (((((_la - 42)) & ~0x3f) == 0 && ((1L << (_la - 42)) & ((1L << (FULL - 42)) | (1L << (INNER - 42)) | (1L << (LEFT - 42)) | (1L << (RIGHT - 42)))) != 0)) {
				{
				setState(2868); ((Natural_joinContext)_localctx).t = join_type();
				}
			}

			setState(2871); match(JOIN);
			setState(2872); ((Natural_joinContext)_localctx).r = table_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 296, RULE_union_join);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2874); match(UNION);
			setState(2875); match(JOIN);
			setState(2876); ((Union_joinContext)_localctx).r = table_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 298, RULE_join_type);
		try {
			setState(2880);
			switch (_input.LA(1)) {
			case INNER:
				enterOuterAlt(_localctx, 1);
				{
				setState(2878); match(INNER);
				}
				break;
			case FULL:
			case LEFT:
			case RIGHT:
				enterOuterAlt(_localctx, 2);
				{
				setState(2879); ((Join_typeContext)_localctx).t = outer_join_type();
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
		enterRule(_localctx, 300, RULE_outer_join_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2882); outer_join_type_part2();
			setState(2884);
			_la = _input.LA(1);
			if (_la==OUTER) {
				{
				setState(2883); match(OUTER);
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
		enterRule(_localctx, 302, RULE_outer_join_type_part2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2886);
			_la = _input.LA(1);
			if ( !(((((_la - 42)) & ~0x3f) == 0 && ((1L << (_la - 42)) & ((1L << (FULL - 42)) | (1L << (LEFT - 42)) | (1L << (RIGHT - 42)))) != 0)) ) {
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
		enterRule(_localctx, 304, RULE_join_specification);
		try {
			setState(2890);
			switch (_input.LA(1)) {
			case ON:
				enterOuterAlt(_localctx, 1);
				{
				setState(2888); join_condition();
				}
				break;
			case USING:
				enterOuterAlt(_localctx, 2);
				{
				setState(2889); named_columns_join();
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
		enterRule(_localctx, 306, RULE_join_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2892); match(ON);
			setState(2893); search_condition();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 308, RULE_named_columns_join);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2895); match(USING);
			setState(2896); match(LEFT_PAREN);
			setState(2897); ((Named_columns_joinContext)_localctx).f = column_reference_list();
			setState(2898); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 310, RULE_table_primary);
		int _la;
		try {
			setState(2924);
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
				setState(2900); table_or_query_name();
				setState(2905);
				switch ( getInterpreter().adaptivePredict(_input,416,_ctx) ) {
				case 1:
					{
					setState(2902);
					_la = _input.LA(1);
					if (_la==AS) {
						{
						setState(2901); match(AS);
						}
					}

					setState(2904); ((Table_primaryContext)_localctx).alias = identifier();
					}
					break;
				}
				setState(2911);
				switch ( getInterpreter().adaptivePredict(_input,417,_ctx) ) {
				case 1:
					{
					setState(2907); match(LEFT_PAREN);
					setState(2908); column_name_list();
					setState(2909); match(RIGHT_PAREN);
					}
					break;
				}
				}
				break;
			case LEFT_PAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(2913); derived_table();
				setState(2915);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(2914); match(AS);
					}
				}

				setState(2917); ((Table_primaryContext)_localctx).name = identifier();
				setState(2922);
				switch ( getInterpreter().adaptivePredict(_input,419,_ctx) ) {
				case 1:
					{
					setState(2918); match(LEFT_PAREN);
					setState(2919); column_name_list();
					setState(2920); match(RIGHT_PAREN);
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
		enterRule(_localctx, 312, RULE_column_name_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2926); identifier();
			setState(2931);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2927); match(COMMA);
				setState(2928); identifier();
				}
				}
				setState(2933);
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
		enterRule(_localctx, 314, RULE_derived_table);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2934); table_subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 316, RULE_where_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2936); match(WHERE);
			setState(2937); search_condition();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 318, RULE_search_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2939); value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 320, RULE_groupby_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2941); match(GROUP);
			setState(2942); match(BY);
			setState(2943); ((Groupby_clauseContext)_localctx).g = grouping_element_list();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 322, RULE_grouping_element_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2945); grouping_element();
			setState(2950);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2946); match(COMMA);
				setState(2947); grouping_element();
				}
				}
				setState(2952);
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
		enterRule(_localctx, 324, RULE_grouping_element);
		try {
			setState(2957);
			switch ( getInterpreter().adaptivePredict(_input,423,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2953); rollup_list();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2954); cube_list();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2955); empty_grouping_set();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2956); ordinary_grouping_set();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 326, RULE_ordinary_grouping_set);
		try {
			setState(2964);
			switch ( getInterpreter().adaptivePredict(_input,424,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2959); row_value_predicand();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2960); match(LEFT_PAREN);
				setState(2961); row_value_predicand_list();
				setState(2962); match(RIGHT_PAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 328, RULE_ordinary_grouping_set_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2966); ordinary_grouping_set();
			setState(2971);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2967); match(COMMA);
				setState(2968); ordinary_grouping_set();
				}
				}
				setState(2973);
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
		enterRule(_localctx, 330, RULE_rollup_list);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2974); match(ROLLUP);
			setState(2975); match(LEFT_PAREN);
			setState(2976); ((Rollup_listContext)_localctx).c = ordinary_grouping_set_list();
			setState(2977); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 332, RULE_cube_list);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2979); match(CUBE);
			setState(2980); match(LEFT_PAREN);
			setState(2981); ((Cube_listContext)_localctx).c = ordinary_grouping_set_list();
			setState(2982); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 334, RULE_empty_grouping_set);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2984); match(LEFT_PAREN);
			setState(2985); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 336, RULE_having_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2987); match(HAVING);
			setState(2988); boolean_value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 338, RULE_row_value_predicand_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2990); row_value_predicand();
			setState(2995);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2991); match(COMMA);
				setState(2992); row_value_predicand();
				}
				}
				setState(2997);
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
		enterRule(_localctx, 340, RULE_query_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2998); query_expression_body();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 342, RULE_query_expression_body);
		try {
			setState(3002);
			switch ( getInterpreter().adaptivePredict(_input,427,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3000); non_join_query_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3001); joined_table();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 344, RULE_non_join_query_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3012);
			switch ( getInterpreter().adaptivePredict(_input,429,_ctx) ) {
			case 1:
				{
				setState(3004); non_join_query_term();
				}
				break;
			case 2:
				{
				setState(3005); joined_table();
				setState(3006);
				_la = _input.LA(1);
				if ( !(_la==EXCEPT || _la==UNION) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(3008);
				_la = _input.LA(1);
				if (_la==ALL || _la==DISTINCT) {
					{
					setState(3007);
					_la = _input.LA(1);
					if ( !(_la==ALL || _la==DISTINCT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(3010); query_term();
				}
				break;
			}
			setState(3021);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==EXCEPT || _la==UNION) {
				{
				{
				setState(3014);
				_la = _input.LA(1);
				if ( !(_la==EXCEPT || _la==UNION) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(3016);
				_la = _input.LA(1);
				if (_la==ALL || _la==DISTINCT) {
					{
					setState(3015);
					_la = _input.LA(1);
					if ( !(_la==ALL || _la==DISTINCT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(3018); query_term();
				}
				}
				setState(3023);
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
		enterRule(_localctx, 346, RULE_query_term);
		try {
			setState(3026);
			switch ( getInterpreter().adaptivePredict(_input,432,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3024); non_join_query_term();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3025); joined_table();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 348, RULE_non_join_query_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3036);
			switch ( getInterpreter().adaptivePredict(_input,434,_ctx) ) {
			case 1:
				{
				setState(3028); non_join_query_primary();
				}
				break;
			case 2:
				{
				setState(3029); joined_table();
				setState(3030); match(INTERSECT);
				setState(3032);
				_la = _input.LA(1);
				if (_la==ALL || _la==DISTINCT) {
					{
					setState(3031);
					_la = _input.LA(1);
					if ( !(_la==ALL || _la==DISTINCT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(3034); query_primary();
				}
				break;
			}
			setState(3045);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==INTERSECT) {
				{
				{
				setState(3038); match(INTERSECT);
				setState(3040);
				_la = _input.LA(1);
				if (_la==ALL || _la==DISTINCT) {
					{
					setState(3039);
					_la = _input.LA(1);
					if ( !(_la==ALL || _la==DISTINCT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(3042); query_primary();
				}
				}
				setState(3047);
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
		enterRule(_localctx, 350, RULE_query_primary);
		try {
			setState(3050);
			switch ( getInterpreter().adaptivePredict(_input,437,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3048); non_join_query_primary();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3049); joined_table();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 352, RULE_non_join_query_primary);
		try {
			setState(3057);
			switch (_input.LA(1)) {
			case SELECT:
			case TABLE:
				enterOuterAlt(_localctx, 1);
				{
				setState(3052); simple_table();
				}
				break;
			case LEFT_PAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(3053); match(LEFT_PAREN);
				setState(3054); non_join_query_expression();
				setState(3055); match(RIGHT_PAREN);
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
		enterRule(_localctx, 354, RULE_simple_table);
		try {
			setState(3061);
			switch (_input.LA(1)) {
			case SELECT:
				enterOuterAlt(_localctx, 1);
				{
				setState(3059); query_specification();
				}
				break;
			case TABLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(3060); explicit_table();
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
		enterRule(_localctx, 356, RULE_explicit_table);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3063); match(TABLE);
			setState(3064); table_or_query_name();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 358, RULE_table_or_query_name);
		try {
			setState(3068);
			switch ( getInterpreter().adaptivePredict(_input,440,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3066); schema_qualified_name();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3067); identifier();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 360, RULE_schema_qualified_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3070); identifier();
			setState(3077);
			_la = _input.LA(1);
			if (_la==DOT) {
				{
				setState(3071); match(DOT);
				setState(3072); identifier();
				setState(3075);
				_la = _input.LA(1);
				if (_la==DOT) {
					{
					setState(3073); match(DOT);
					setState(3074); identifier();
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
		enterRule(_localctx, 362, RULE_query_specification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3079); match(SELECT);
			setState(3081);
			_la = _input.LA(1);
			if (_la==ALL || _la==DISTINCT) {
				{
				setState(3080); set_qualifier();
				}
			}

			setState(3083); select_list();
			setState(3085);
			_la = _input.LA(1);
			if (_la==FROM) {
				{
				setState(3084); table_expression();
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
		enterRule(_localctx, 364, RULE_select_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3087); select_sublist();
			setState(3092);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3088); match(COMMA);
				setState(3089); select_sublist();
				}
				}
				setState(3094);
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
		enterRule(_localctx, 366, RULE_select_sublist);
		try {
			setState(3097);
			switch ( getInterpreter().adaptivePredict(_input,446,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3095); derived_column();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3096); qualified_asterisk();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 368, RULE_derived_column);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3099); value_expression();
			setState(3101);
			switch ( getInterpreter().adaptivePredict(_input,447,_ctx) ) {
			case 1:
				{
				setState(3100); as_clause();
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
		enterRule(_localctx, 370, RULE_qualified_asterisk);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3105);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(3103); ((Qualified_asteriskContext)_localctx).tb_name = match(Identifier);
				setState(3104); match(DOT);
				}
			}

			setState(3107); match(MULTIPLY);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 372, RULE_set_qualifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3109);
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
		enterRule(_localctx, 374, RULE_column_reference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3114);
			switch ( getInterpreter().adaptivePredict(_input,449,_ctx) ) {
			case 1:
				{
				setState(3111); ((Column_referenceContext)_localctx).tb_name = identifier();
				setState(3112); match(DOT);
				}
				break;
			}
			setState(3116); ((Column_referenceContext)_localctx).name = identifier();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 376, RULE_as_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3119);
			_la = _input.LA(1);
			if (_la==AS) {
				{
				setState(3118); match(AS);
				}
			}

			setState(3121); identifier();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 378, RULE_column_reference_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3123); column_reference();
			setState(3128);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3124); match(COMMA);
				setState(3125); column_reference();
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
		enterRule(_localctx, 380, RULE_scalar_subquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3131); subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 382, RULE_row_subquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3133); subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 384, RULE_table_subquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3135); subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 386, RULE_subquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3137); match(LEFT_PAREN);
			setState(3138); query_expression();
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
		enterRule(_localctx, 388, RULE_predicate);
		try {
			setState(3147);
			switch ( getInterpreter().adaptivePredict(_input,452,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3141); comparison_predicate();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3142); between_predicate();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(3143); in_predicate();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(3144); pattern_matching_predicate();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(3145); null_predicate();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(3146); exists_predicate();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 390, RULE_comparison_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3149); ((Comparison_predicateContext)_localctx).left = row_value_predicand();
			setState(3150); ((Comparison_predicateContext)_localctx).c = comp_op();
			setState(3151); ((Comparison_predicateContext)_localctx).right = row_value_predicand();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 392, RULE_comp_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3153);
			_la = _input.LA(1);
			if ( !(((((_la - 296)) & ~0x3f) == 0 && ((1L << (_la - 296)) & ((1L << (EQUAL - 296)) | (1L << (NOT_EQUAL - 296)) | (1L << (LTH - 296)) | (1L << (LEQ - 296)) | (1L << (GTH - 296)) | (1L << (GEQ - 296)))) != 0)) ) {
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
		enterRule(_localctx, 394, RULE_between_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3155); ((Between_predicateContext)_localctx).predicand = row_value_predicand();
			setState(3156); between_predicate_part_2();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 396, RULE_between_predicate_part_2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3159);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(3158); match(NOT);
				}
			}

			setState(3161); match(BETWEEN);
			setState(3163);
			_la = _input.LA(1);
			if (_la==ASYMMETRIC || _la==SYMMETRIC) {
				{
				setState(3162);
				_la = _input.LA(1);
				if ( !(_la==ASYMMETRIC || _la==SYMMETRIC) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(3165); ((Between_predicate_part_2Context)_localctx).begin = row_value_predicand();
			setState(3166); match(AND);
			setState(3167); ((Between_predicate_part_2Context)_localctx).end = row_value_predicand();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 398, RULE_in_predicate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3169); ((In_predicateContext)_localctx).predicand = numeric_value_expression();
			setState(3171);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(3170); match(NOT);
				}
			}

			setState(3173); match(IN);
			setState(3174); in_predicate_value();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 400, RULE_in_predicate_value);
		try {
			setState(3181);
			switch ( getInterpreter().adaptivePredict(_input,456,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3176); table_subquery();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3177); match(LEFT_PAREN);
				setState(3178); in_value_list();
				setState(3179); match(RIGHT_PAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 402, RULE_in_value_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3183); row_value_expression();
			setState(3188);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3184); match(COMMA);
				setState(3185); row_value_expression();
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
		enterRule(_localctx, 404, RULE_pattern_matching_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3191); ((Pattern_matching_predicateContext)_localctx).f = row_value_predicand();
			setState(3192); pattern_matcher();
			setState(3193); ((Pattern_matching_predicateContext)_localctx).s = match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 406, RULE_pattern_matcher);
		int _la;
		try {
			setState(3200);
			switch (_input.LA(1)) {
			case ILIKE:
			case LIKE:
			case NOT:
			case REGEXP:
			case RLIKE:
			case SIMILAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(3196);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(3195); match(NOT);
					}
				}

				setState(3198); negativable_matcher();
				}
				break;
			case Similar_To:
			case Not_Similar_To:
			case Similar_To_Case_Insensitive:
			case Not_Similar_To_Case_Insensitive:
				enterOuterAlt(_localctx, 2);
				{
				setState(3199); regex_matcher();
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
		enterRule(_localctx, 408, RULE_negativable_matcher);
		try {
			setState(3208);
			switch (_input.LA(1)) {
			case LIKE:
				enterOuterAlt(_localctx, 1);
				{
				setState(3202); match(LIKE);
				}
				break;
			case ILIKE:
				enterOuterAlt(_localctx, 2);
				{
				setState(3203); match(ILIKE);
				}
				break;
			case SIMILAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(3204); match(SIMILAR);
				setState(3205); match(TO);
				}
				break;
			case REGEXP:
				enterOuterAlt(_localctx, 4);
				{
				setState(3206); match(REGEXP);
				}
				break;
			case RLIKE:
				enterOuterAlt(_localctx, 5);
				{
				setState(3207); match(RLIKE);
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
		enterRule(_localctx, 410, RULE_regex_matcher);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3210);
			_la = _input.LA(1);
			if ( !(((((_la - 290)) & ~0x3f) == 0 && ((1L << (_la - 290)) & ((1L << (Similar_To - 290)) | (1L << (Not_Similar_To - 290)) | (1L << (Similar_To_Case_Insensitive - 290)) | (1L << (Not_Similar_To_Case_Insensitive - 290)))) != 0)) ) {
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
		enterRule(_localctx, 412, RULE_null_predicate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3212); ((Null_predicateContext)_localctx).predicand = row_value_predicand();
			setState(3213); match(IS);
			setState(3215);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(3214); ((Null_predicateContext)_localctx).n = match(NOT);
				}
			}

			setState(3217); match(NULL);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 414, RULE_quantified_comparison_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3219); ((Quantified_comparison_predicateContext)_localctx).l = numeric_value_expression();
			setState(3220); ((Quantified_comparison_predicateContext)_localctx).c = comp_op();
			setState(3221); ((Quantified_comparison_predicateContext)_localctx).q = quantifier();
			setState(3222); ((Quantified_comparison_predicateContext)_localctx).s = table_subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 416, RULE_quantifier);
		try {
			setState(3226);
			switch (_input.LA(1)) {
			case ALL:
				enterOuterAlt(_localctx, 1);
				{
				setState(3224); all();
				}
				break;
			case ANY:
			case SOME:
				enterOuterAlt(_localctx, 2);
				{
				setState(3225); some();
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
		enterRule(_localctx, 418, RULE_all);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3228); match(ALL);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 420, RULE_some);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3230);
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
		enterRule(_localctx, 422, RULE_exists_predicate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3233);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(3232); match(NOT);
				}
			}

			setState(3235); match(EXISTS);
			setState(3236); ((Exists_predicateContext)_localctx).s = table_subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 424, RULE_unique_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3238); match(UNIQUE);
			setState(3239); ((Unique_predicateContext)_localctx).s = table_subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 426, RULE_primary_datetime_field);
		try {
			setState(3243);
			switch (_input.LA(1)) {
			case DAY:
			case HOUR:
			case MINUTE:
			case MONTH:
			case YEAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(3241); non_second_primary_datetime_field();
				}
				break;
			case SECOND:
				enterOuterAlt(_localctx, 2);
				{
				setState(3242); match(SECOND);
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
		enterRule(_localctx, 428, RULE_non_second_primary_datetime_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3245);
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
		enterRule(_localctx, 430, RULE_extended_datetime_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3247);
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
		enterRule(_localctx, 432, RULE_routine_invocation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3249); function_name();
			setState(3250); match(LEFT_PAREN);
			setState(3252);
			_la = _input.LA(1);
			if (((((_la - 6)) & ~0x3f) == 0 && ((1L << (_la - 6)) & ((1L << (ANY - 6)) | (1L << (CASE - 6)) | (1L << (CAST - 6)) | (1L << (FALSE - 6)) | (1L << (LEFT - 6)))) != 0) || ((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & ((1L << (NOT - 73)) | (1L << (NULL - 73)) | (1L << (RIGHT - 73)) | (1L << (SOME - 73)) | (1L << (TRUE - 73)) | (1L << (ADMIN - 73)) | (1L << (AVG - 73)) | (1L << (BETWEEN - 73)) | (1L << (BY - 73)) | (1L << (CACHE - 73)) | (1L << (CALLED - 73)) | (1L << (CLASS - 73)) | (1L << (CENTURY - 73)) | (1L << (CHARACTER - 73)))) != 0) || ((((_la - 137)) & ~0x3f) == 0 && ((1L << (_la - 137)) & ((1L << (CHECK - 137)) | (1L << (COLLECT - 137)) | (1L << (COALESCE - 137)) | (1L << (COLUMN - 137)) | (1L << (COMMENT - 137)) | (1L << (COMMENTS - 137)) | (1L << (COMMIT - 137)) | (1L << (CONFIGURATION - 137)) | (1L << (COST - 137)) | (1L << (COUNT - 137)) | (1L << (CUBE - 137)) | (1L << (CURRENT - 137)) | (1L << (CYCLE - 137)) | (1L << (DATA - 137)) | (1L << (DAY - 137)) | (1L << (DEC - 137)) | (1L << (DECADE - 137)) | (1L << (DEFINER - 137)) | (1L << (DICTIONARY - 137)) | (1L << (DOW - 137)) | (1L << (DOY - 137)) | (1L << (DROP - 137)) | (1L << (EPOCH - 137)) | (1L << (EVERY - 137)) | (1L << (EXISTS - 137)) | (1L << (EXTERNAL - 137)) | (1L << (EXTRACT - 137)) | (1L << (FAMILY - 137)) | (1L << (FILTER - 137)) | (1L << (FIRST - 137)) | (1L << (FORMAT - 137)) | (1L << (FUSION - 137)) | (1L << (GROUPING - 137)) | (1L << (HASH - 137)) | (1L << (INDEX - 137)) | (1L << (INCREMENT - 137)) | (1L << (INPUT - 137)) | (1L << (INSERT - 137)) | (1L << (INTERSECTION - 137)) | (1L << (ISCACHABLE - 137)) | (1L << (ISODOW - 137)) | (1L << (ISOYEAR - 137)) | (1L << (ISSTRICT - 137)) | (1L << (LANGUAGE - 137)) | (1L << (LARGE - 137)) | (1L << (LAST - 137)) | (1L << (LESS - 137)) | (1L << (LIST - 137)) | (1L << (LOCATION - 137)) | (1L << (MATCH - 137)) | (1L << (MAX - 137)) | (1L << (MAXVALUE - 137)) | (1L << (MICROSECONDS - 137)) | (1L << (MILLENNIUM - 137)) | (1L << (MILLISECONDS - 137)) | (1L << (MIN - 137)) | (1L << (MINVALUE - 137)) | (1L << (MINUTE - 137)) | (1L << (MONTH - 137)) | (1L << (NATIONAL - 137)) | (1L << (NO - 137)) | (1L << (NONE - 137)))) != 0) || ((((_la - 201)) & ~0x3f) == 0 && ((1L << (_la - 201)) & ((1L << (NULLIF - 201)) | (1L << (OBJECT - 201)) | (1L << (OPTION - 201)) | (1L << (OPTIONS - 201)) | (1L << (OVERWRITE - 201)) | (1L << (PARSER - 201)) | (1L << (PARTIAL - 201)) | (1L << (PARTITION - 201)) | (1L << (PARTITIONS - 201)) | (1L << (PRECISION - 201)) | (1L << (PUBLIC - 201)) | (1L << (PURGE - 201)) | (1L << (QUARTER - 201)) | (1L << (RANGE - 201)) | (1L << (REGEXP - 201)) | (1L << (RLIKE - 201)) | (1L << (ROLLUP - 201)) | (1L << (SEARCH - 201)) | (1L << (SECOND - 201)) | (1L << (SECURITY - 201)) | (1L << (SERVER - 201)) | (1L << (SET - 201)) | (1L << (SIMILAR - 201)) | (1L << (SIMPLE - 201)) | (1L << (STABLE - 201)) | (1L << (START - 201)) | (1L << (STORAGE - 201)) | (1L << (STDDEV_POP - 201)) | (1L << (STDDEV_SAMP - 201)) | (1L << (SUBPARTITION - 201)) | (1L << (SUM - 201)) | (1L << (TABLESPACE - 201)) | (1L << (TEMPLATE - 201)) | (1L << (THAN - 201)) | (1L << (TIMEZONE - 201)) | (1L << (TIMEZONE_HOUR - 201)) | (1L << (TIMEZONE_MINUTE - 201)) | (1L << (TRIM - 201)) | (1L << (TO - 201)) | (1L << (UNKNOWN - 201)) | (1L << (UNLOGGED - 201)) | (1L << (VALUES - 201)) | (1L << (VAR_SAMP - 201)) | (1L << (VAR_POP - 201)) | (1L << (VARYING - 201)) | (1L << (VOLATILE - 201)) | (1L << (WEEK - 201)) | (1L << (WINDOW - 201)) | (1L << (WRAPPER - 201)) | (1L << (YEAR - 201)) | (1L << (ZONE - 201)) | (1L << (BOOLEAN - 201)) | (1L << (BOOL - 201)) | (1L << (BIT - 201)) | (1L << (VARBIT - 201)) | (1L << (INT1 - 201)) | (1L << (INT2 - 201)) | (1L << (INT4 - 201)) | (1L << (INT8 - 201)) | (1L << (TINYINT - 201)) | (1L << (SMALLINT - 201)) | (1L << (INT - 201)))) != 0) || ((((_la - 265)) & ~0x3f) == 0 && ((1L << (_la - 265)) & ((1L << (INTEGER - 265)) | (1L << (BIGINT - 265)) | (1L << (FLOAT4 - 265)) | (1L << (FLOAT8 - 265)) | (1L << (REAL - 265)) | (1L << (FLOAT - 265)) | (1L << (DOUBLE - 265)) | (1L << (NUMERIC - 265)) | (1L << (DECIMAL - 265)) | (1L << (CHAR - 265)) | (1L << (VARCHAR - 265)) | (1L << (NCHAR - 265)) | (1L << (NVARCHAR - 265)) | (1L << (DATE - 265)) | (1L << (TIME - 265)) | (1L << (TIMETZ - 265)) | (1L << (TIMESTAMP - 265)) | (1L << (TIMESTAMPTZ - 265)) | (1L << (TEXT - 265)) | (1L << (VARBINARY - 265)) | (1L << (BLOB - 265)) | (1L << (BYTEA - 265)) | (1L << (INET4 - 265)) | (1L << (LEFT_PAREN - 265)) | (1L << (PLUS - 265)) | (1L << (MINUS - 265)) | (1L << (QUOTE - 265)) | (1L << (NUMBER - 265)) | (1L << (REAL_NUMBER - 265)) | (1L << (Identifier - 265)) | (1L << (Character_String_Literal - 265)))) != 0)) {
				{
				setState(3251); sql_argument_list();
				}
			}

			setState(3254); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 434, RULE_function_names_for_reserved_words);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3256);
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
		enterRule(_localctx, 436, RULE_function_name);
		try {
			setState(3260);
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
				setState(3258); identifier();
				}
				break;
			case LEFT:
			case RIGHT:
				enterOuterAlt(_localctx, 2);
				{
				setState(3259); function_names_for_reserved_words();
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
		enterRule(_localctx, 438, RULE_sql_argument_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3262); value_expression();
			setState(3267);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3263); match(COMMA);
				setState(3264); value_expression();
				}
				}
				setState(3269);
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
		enterRule(_localctx, 440, RULE_orderby_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3270); match(ORDER);
			setState(3271); match(BY);
			setState(3272); sort_specifier_list();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 442, RULE_sort_specifier_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3274); sort_specifier();
			setState(3279);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3275); match(COMMA);
				setState(3276); sort_specifier();
				}
				}
				setState(3281);
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
		enterRule(_localctx, 444, RULE_sort_specifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3282); ((Sort_specifierContext)_localctx).key = row_value_predicand();
			setState(3284);
			_la = _input.LA(1);
			if (_la==ASC || _la==DESC) {
				{
				setState(3283); ((Sort_specifierContext)_localctx).order = order_specification();
				}
			}

			setState(3287);
			_la = _input.LA(1);
			if (_la==NULL) {
				{
				setState(3286); ((Sort_specifierContext)_localctx).null_order = null_ordering();
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
		enterRule(_localctx, 446, RULE_order_specification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3289);
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
		enterRule(_localctx, 448, RULE_limit_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3291); match(LIMIT);
			setState(3292); ((Limit_clauseContext)_localctx).e = numeric_value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 450, RULE_null_ordering);
		try {
			setState(3298);
			switch ( getInterpreter().adaptivePredict(_input,471,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3294); match(NULL);
				setState(3295); match(FIRST);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3296); match(NULL);
				setState(3297); match(LAST);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 452, RULE_insert_statement);
		int _la;
		try {
			setState(3329);
			switch ( getInterpreter().adaptivePredict(_input,477,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3300); match(INSERT);
				setState(3302);
				_la = _input.LA(1);
				if (_la==OVERWRITE) {
					{
					setState(3301); match(OVERWRITE);
					}
				}

				setState(3304); match(INTO);
				setState(3305); schema_qualified_name();
				setState(3310);
				switch ( getInterpreter().adaptivePredict(_input,473,_ctx) ) {
				case 1:
					{
					setState(3306); match(LEFT_PAREN);
					setState(3307); column_name_list();
					setState(3308); match(RIGHT_PAREN);
					}
					break;
				}
				setState(3312); query_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3314); match(INSERT);
				setState(3316);
				_la = _input.LA(1);
				if (_la==OVERWRITE) {
					{
					setState(3315); match(OVERWRITE);
					}
				}

				setState(3318); match(INTO);
				setState(3319); match(LOCATION);
				setState(3320); ((Insert_statementContext)_localctx).path = match(Character_String_Literal);
				setState(3326);
				_la = _input.LA(1);
				if (_la==USING) {
					{
					setState(3321); match(USING);
					setState(3322); ((Insert_statementContext)_localctx).file_type = identifier();
					setState(3324);
					_la = _input.LA(1);
					if (_la==WITH) {
						{
						setState(3323); param_clause();
						}
					}

					}
				}

				setState(3328); query_expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\u014b\u0d06\4\2\t"+
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
		"\4\u00e4\t\u00e4\3\2\3\2\5\2\u01cb\n\2\7\2\u01cd\n\2\f\2\16\2\u01d0\13"+
		"\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\u01e0\n"+
		"\3\3\4\3\4\3\5\3\5\3\6\3\6\5\6\u01e8\n\6\3\7\3\7\5\7\u01ec\n\7\3\7\3\7"+
		"\3\7\3\7\3\7\5\7\u01f3\n\7\3\7\3\7\3\7\3\7\5\7\u01f9\n\7\3\b\3\b\3\b\3"+
		"\b\3\b\5\b\u0200\n\b\3\b\3\b\5\b\u0204\n\b\3\b\3\b\5\b\u0208\n\b\3\b\3"+
		"\b\5\b\u020c\n\b\3\b\3\b\5\b\u0210\n\b\3\t\3\t\5\t\u0214\n\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\5\t\u021e\n\t\3\t\5\t\u0221\n\t\6\t\u0223\n\t\r"+
		"\t\16\t\u0224\3\t\3\t\5\t\u0229\n\t\3\t\3\t\3\t\3\t\3\t\5\t\u0230\n\t"+
		"\3\t\5\t\u0233\n\t\6\t\u0235\n\t\r\t\16\t\u0236\5\t\u0239\n\t\3\n\3\n"+
		"\5\n\u023d\n\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u0245\n\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\5\n\u024e\n\n\6\n\u0250\n\n\r\n\16\n\u0251\5\n\u0254\n\n\5"+
		"\n\u0256\n\n\3\n\3\n\3\n\3\n\5\n\u025c\n\n\3\n\3\n\3\n\5\n\u0261\n\n\3"+
		"\n\3\n\3\n\3\n\5\n\u0267\n\n\3\n\3\n\5\n\u026b\n\n\3\n\3\n\5\n\u026f\n"+
		"\n\3\n\3\n\5\n\u0273\n\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u027b\n\n\5\n\u027d"+
		"\n\n\3\n\3\n\3\13\3\13\3\13\3\13\5\13\u0285\n\13\3\13\6\13\u0288\n\13"+
		"\r\13\16\13\u0289\3\13\3\13\5\13\u028e\n\13\5\13\u0290\n\13\3\13\3\13"+
		"\5\13\u0294\n\13\3\13\6\13\u0297\n\13\r\13\16\13\u0298\3\13\3\13\3\13"+
		"\3\13\3\13\6\13\u02a0\n\13\r\13\16\13\u02a1\5\13\u02a4\n\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\5\13\u02ac\n\13\3\13\3\13\3\13\3\13\5\13\u02b2\n"+
		"\13\6\13\u02b4\n\13\r\13\16\13\u02b5\3\13\3\13\6\13\u02ba\n\13\r\13\16"+
		"\13\u02bb\3\13\3\13\5\13\u02c0\n\13\3\13\3\13\3\13\5\13\u02c5\n\13\6\13"+
		"\u02c7\n\13\r\13\16\13\u02c8\3\13\3\13\5\13\u02cd\n\13\3\13\3\13\5\13"+
		"\u02d1\n\13\3\13\3\13\5\13\u02d5\n\13\6\13\u02d7\n\13\r\13\16\13\u02d8"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u02e1\n\13\3\13\6\13\u02e4\n\13\r"+
		"\13\16\13\u02e5\3\13\3\13\5\13\u02ea\n\13\5\13\u02ec\n\13\3\13\3\13\3"+
		"\13\3\13\5\13\u02f2\n\13\6\13\u02f4\n\13\r\13\16\13\u02f5\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\5\13\u02fe\n\13\6\13\u0300\n\13\r\13\16\13\u0301\5"+
		"\13\u0304\n\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u030c\n\13\3\13\6\13"+
		"\u030f\n\13\r\13\16\13\u0310\3\13\3\13\5\13\u0315\n\13\5\13\u0317\n\13"+
		"\3\13\3\13\3\13\3\13\5\13\u031d\n\13\6\13\u031f\n\13\r\13\16\13\u0320"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u0329\n\13\3\13\3\13\3\13\5\13\u032e"+
		"\n\13\5\13\u0330\n\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u0338\n\13\6"+
		"\13\u033a\n\13\r\13\16\13\u033b\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u0344"+
		"\n\13\3\13\3\13\3\13\5\13\u0349\n\13\5\13\u034b\n\13\3\13\3\13\3\13\3"+
		"\13\3\13\5\13\u0352\n\13\6\13\u0354\n\13\r\13\16\13\u0355\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\5\13\u035e\n\13\3\13\3\13\3\13\5\13\u0363\n\13\5\13"+
		"\u0365\n\13\3\13\3\13\3\13\5\13\u036a\n\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\5\13\u0372\n\13\3\13\3\13\3\13\5\13\u0377\n\13\5\13\u0379\n\13\3\13"+
		"\3\13\3\13\3\13\5\13\u037f\n\13\6\13\u0381\n\13\r\13\16\13\u0382\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\5\13\u038b\n\13\3\13\3\13\3\13\5\13\u0390\n"+
		"\13\6\13\u0392\n\13\r\13\16\13\u0393\3\13\3\13\5\13\u0398\n\13\5\13\u039a"+
		"\n\13\3\13\3\13\3\13\3\13\3\13\5\13\u03a1\n\13\6\13\u03a3\n\13\r\13\16"+
		"\13\u03a4\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u03ad\n\13\3\13\3\13\5\13"+
		"\u03b1\n\13\6\13\u03b3\n\13\r\13\16\13\u03b4\3\13\3\13\5\13\u03b9\n\13"+
		"\5\13\u03bb\n\13\3\13\3\13\3\13\3\13\5\13\u03c1\n\13\6\13\u03c3\n\13\r"+
		"\13\16\13\u03c4\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u03cd\n\13\3\13\3\13"+
		"\3\13\5\13\u03d2\n\13\5\13\u03d4\n\13\3\13\3\13\3\13\3\13\5\13\u03da\n"+
		"\13\6\13\u03dc\n\13\r\13\16\13\u03dd\3\13\3\13\3\13\3\13\3\13\3\13\5\13"+
		"\u03e6\n\13\3\13\3\13\5\13\u03ea\n\13\6\13\u03ec\n\13\r\13\16\13\u03ed"+
		"\3\13\3\13\3\13\5\13\u03f3\n\13\6\13\u03f5\n\13\r\13\16\13\u03f6\3\13"+
		"\5\13\u03fa\n\13\5\13\u03fc\n\13\3\f\3\f\5\f\u0400\n\f\3\f\3\f\3\f\5\f"+
		"\u0405\n\f\6\f\u0407\n\f\r\f\16\f\u0408\3\f\5\f\u040c\n\f\3\r\3\r\6\r"+
		"\u0410\n\r\r\r\16\r\u0411\3\r\3\r\5\r\u0416\n\r\5\r\u0418\n\r\3\r\3\r"+
		"\5\r\u041c\n\r\3\r\3\r\5\r\u0420\n\r\6\r\u0422\n\r\r\r\16\r\u0423\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\5\r\u042c\n\r\6\r\u042e\n\r\r\r\16\r\u042f\5\r\u0432"+
		"\n\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u043a\n\r\6\r\u043c\n\r\r\r\16\r\u043d"+
		"\6\r\u0440\n\r\r\r\16\r\u0441\3\r\3\r\5\r\u0446\n\r\3\r\3\r\5\r\u044a"+
		"\n\r\6\r\u044c\n\r\r\r\16\r\u044d\5\r\u0450\n\r\3\r\3\r\5\r\u0454\n\r"+
		"\3\r\3\r\5\r\u0458\n\r\6\r\u045a\n\r\r\r\16\r\u045b\3\r\3\r\3\r\3\r\3"+
		"\r\5\r\u0463\n\r\6\r\u0465\n\r\r\r\16\r\u0466\3\r\3\r\5\r\u046b\n\r\5"+
		"\r\u046d\n\r\3\r\3\r\3\r\3\r\5\r\u0473\n\r\6\r\u0475\n\r\r\r\16\r\u0476"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u047f\n\r\6\r\u0481\n\r\r\r\16\r\u0482\5"+
		"\r\u0485\n\r\3\r\3\r\3\r\3\r\3\r\5\r\u048c\n\r\6\r\u048e\n\r\r\r\16\r"+
		"\u048f\3\r\3\r\5\r\u0494\n\r\5\r\u0496\n\r\3\r\3\r\3\r\3\r\5\r\u049c\n"+
		"\r\6\r\u049e\n\r\r\r\16\r\u049f\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u04a8\n\r"+
		"\5\r\u04aa\n\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u04b2\n\r\6\r\u04b4\n\r\r\r"+
		"\16\r\u04b5\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u04be\n\r\5\r\u04c0\n\r\3\r\3"+
		"\r\3\r\3\r\3\r\5\r\u04c7\n\r\6\r\u04c9\n\r\r\r\16\r\u04ca\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\5\r\u04d3\n\r\5\r\u04d5\n\r\3\r\3\r\3\r\5\r\u04da\n\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\5\r\u04e2\n\r\5\r\u04e4\n\r\3\r\3\r\3\r\3\r\5\r\u04ea"+
		"\n\r\6\r\u04ec\n\r\r\r\16\r\u04ed\3\r\3\r\3\r\3\r\3\r\5\r\u04f5\n\r\6"+
		"\r\u04f7\n\r\r\r\16\r\u04f8\3\r\3\r\5\r\u04fd\n\r\5\r\u04ff\n\r\3\r\3"+
		"\r\3\r\3\r\3\r\5\r\u0506\n\r\6\r\u0508\n\r\r\r\16\r\u0509\3\r\3\r\3\r"+
		"\3\r\3\r\5\r\u0511\n\r\6\r\u0513\n\r\r\r\16\r\u0514\3\r\3\r\5\r\u0519"+
		"\n\r\5\r\u051b\n\r\3\r\3\r\3\r\3\r\5\r\u0521\n\r\6\r\u0523\n\r\r\r\16"+
		"\r\u0524\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u052d\n\r\5\r\u052f\n\r\3\r\3\r\3"+
		"\r\3\r\5\r\u0535\n\r\6\r\u0537\n\r\r\r\16\r\u0538\3\r\3\r\3\r\3\r\5\r"+
		"\u053f\n\r\6\r\u0541\n\r\r\r\16\r\u0542\3\r\3\r\3\r\5\r\u0548\n\r\6\r"+
		"\u054a\n\r\r\r\16\r\u054b\3\r\3\r\3\r\5\r\u0551\n\r\5\r\u0553\n\r\3\16"+
		"\3\16\5\16\u0557\n\16\3\16\3\16\5\16\u055b\n\16\3\16\5\16\u055e\n\16\6"+
		"\16\u0560\n\16\r\16\16\16\u0561\3\16\3\16\3\16\5\16\u0567\n\16\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\5\17\u0570\n\17\7\17\u0572\n\17\f\17\16\17"+
		"\u0575\13\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u05b4\n\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17"+
		"\u05e2\n\17\3\17\3\17\3\17\3\20\3\20\3\20\5\20\u05ea\n\20\3\20\3\20\3"+
		"\20\3\20\5\20\u05f0\n\20\3\20\5\20\u05f3\n\20\3\20\3\20\3\20\3\20\3\20"+
		"\5\20\u05fa\n\20\6\20\u05fc\n\20\r\20\16\20\u05fd\5\20\u0600\n\20\5\20"+
		"\u0602\n\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u060d\n"+
		"\20\6\20\u060f\n\20\r\20\16\20\u0610\3\20\3\20\5\20\u0615\n\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\5\20\u0628\n\20\3\20\3\20\3\20\5\20\u062d\n\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u063d\n\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\6\20\u0645\n\20\r\20\16\20\u0646\3\20\3"+
		"\20\3\20\3\20\5\20\u064d\n\20\6\20\u064f\n\20\r\20\16\20\u0650\3\20\3"+
		"\20\5\20\u0655\n\20\3\21\3\21\7\21\u0659\n\21\f\21\16\21\u065c\13\21\3"+
		"\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\24\5\24\u0668\n\24\3\24"+
		"\5\24\u066b\n\24\3\24\3\24\5\24\u066f\n\24\7\24\u0671\n\24\f\24\16\24"+
		"\u0674\13\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u067e\n\25\6"+
		"\25\u0680\n\25\r\25\16\25\u0681\3\26\3\26\5\26\u0686\n\26\3\26\3\26\3"+
		"\26\3\26\5\26\u068c\n\26\3\26\5\26\u068f\n\26\3\26\3\26\3\26\3\26\5\26"+
		"\u0695\n\26\3\26\3\26\3\26\3\26\5\26\u069b\n\26\3\26\3\26\5\26\u069f\n"+
		"\26\3\26\5\26\u06a2\n\26\3\26\3\26\5\26\u06a6\n\26\3\26\5\26\u06a9\n\26"+
		"\3\26\5\26\u06ac\n\26\3\26\3\26\3\26\3\26\5\26\u06b2\n\26\5\26\u06b4\n"+
		"\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u06be\n\27\3\27\5\27"+
		"\u06c1\n\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u06cc\n"+
		"\27\3\27\5\27\u06cf\n\27\3\27\5\27\u06d2\n\27\3\27\3\27\5\27\u06d6\n\27"+
		"\3\27\3\27\3\27\3\27\3\27\5\27\u06dd\n\27\3\27\5\27\u06e0\n\27\3\27\5"+
		"\27\u06e3\n\27\3\27\3\27\3\27\3\27\3\27\5\27\u06ea\n\27\3\27\3\27\5\27"+
		"\u06ee\n\27\3\27\3\27\3\27\3\27\5\27\u06f4\n\27\3\27\3\27\3\27\3\27\3"+
		"\27\3\27\5\27\u06fc\n\27\3\27\7\27\u06ff\n\27\f\27\16\27\u0702\13\27\3"+
		"\27\3\27\3\27\3\27\7\27\u0708\n\27\f\27\16\27\u070b\13\27\5\27\u070d\n"+
		"\27\3\27\5\27\u0710\n\27\6\27\u0712\n\27\r\27\16\27\u0713\5\27\u0716\n"+
		"\27\3\27\3\27\3\27\3\27\3\27\5\27\u071d\n\27\6\27\u071f\n\27\r\27\16\27"+
		"\u0720\3\27\3\27\5\27\u0725\n\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u072d"+
		"\n\27\3\27\3\27\5\27\u0731\n\27\3\27\3\27\3\27\3\27\5\27\u0737\n\27\3"+
		"\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\7\27\u0741\n\27\f\27\16\27\u0744"+
		"\13\27\3\27\5\27\u0747\n\27\3\27\5\27\u074a\n\27\6\27\u074c\n\27\r\27"+
		"\16\27\u074d\3\27\3\27\5\27\u0752\n\27\3\27\3\27\3\27\3\27\5\27\u0758"+
		"\n\27\3\30\3\30\3\30\3\31\3\31\5\31\u075f\n\31\3\31\3\31\3\31\3\31\3\31"+
		"\5\31\u0766\n\31\6\31\u0768\n\31\r\31\16\31\u0769\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\5\31\u0774\n\31\6\31\u0776\n\31\r\31\16\31\u0777"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u0780\n\31\3\31\3\31\3\31\3\31\3\31"+
		"\5\31\u0787\n\31\6\31\u0789\n\31\r\31\16\31\u078a\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\5\31\u0794\n\31\3\31\3\31\3\31\3\31\3\31\5\31\u079b\n"+
		"\31\6\31\u079d\n\31\r\31\16\31\u079e\3\31\3\31\3\31\3\31\3\31\3\31\5\31"+
		"\u07a7\n\31\6\31\u07a9\n\31\r\31\16\31\u07aa\3\31\3\31\5\31\u07af\n\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u07b7\n\31\3\31\3\31\3\31\5\31\u07bc"+
		"\n\31\3\31\3\31\3\31\5\31\u07c1\n\31\5\31\u07c3\n\31\3\31\3\31\3\31\5"+
		"\31\u07c8\n\31\3\31\3\31\3\31\3\31\5\31\u07ce\n\31\3\32\3\32\5\32\u07d2"+
		"\n\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u07e8\n\32\3\32\3\32\3\32\5\32"+
		"\u07ed\n\32\3\32\3\32\3\32\5\32\u07f2\n\32\5\32\u07f4\n\32\3\32\3\32\3"+
		"\32\5\32\u07f9\n\32\3\32\3\32\3\32\3\32\5\32\u07ff\n\32\3\33\3\33\3\33"+
		"\3\33\3\33\3\34\3\34\3\34\3\34\3\34\5\34\u080b\n\34\3\34\5\34\u080e\n"+
		"\34\6\34\u0810\n\34\r\34\16\34\u0811\3\34\3\34\3\35\3\35\3\35\3\35\3\35"+
		"\5\35\u081b\n\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\5\36\u0824\n\36\5"+
		"\36\u0826\n\36\3\37\3\37\5\37\u082a\n\37\3 \3 \3 \3 \3 \3 \5 \u0832\n"+
		" \3!\5!\u0835\n!\3!\3!\3!\3!\5!\u083b\n!\3\"\3\"\3\"\3\"\7\"\u0841\n\""+
		"\f\"\16\"\u0844\13\"\3\"\3\"\3#\3#\3#\3$\3$\3%\3%\3%\3%\3%\7%\u0852\n"+
		"%\f%\16%\u0855\13%\3%\3%\3&\3&\3&\3&\3\'\3\'\3\'\3(\3(\3(\3)\3)\3*\3*"+
		"\3*\3*\5*\u0869\n*\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3,\3,\3,\7,\u0878\n,"+
		"\f,\16,\u087b\13,\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\5-\u0887\n-\3-\3-\5-\u088b"+
		"\n-\5-\u088d\n-\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\5.\u089a\n.\3/\3/\3/"+
		"\7/\u089f\n/\f/\16/\u08a2\13/\3\60\3\60\3\60\3\61\3\61\3\61\3\62\3\62"+
		"\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\63\3\63\3\63\7\63\u08b7\n\63"+
		"\f\63\16\63\u08ba\13\63\3\64\3\64\3\64\3\64\5\64\u08c0\n\64\3\64\3\64"+
		"\3\64\3\64\3\65\3\65\3\65\3\65\3\65\3\66\3\66\3\67\3\67\3\67\3\67\5\67"+
		"\u08d1\n\67\38\58\u08d4\n8\38\38\58\u08d8\n8\38\58\u08db\n8\39\39\3:\3"+
		":\5:\u08e1\n:\3;\3;\3;\5;\u08e6\n;\3<\3<\3<\5<\u08eb\n<\3=\3=\3=\3>\3"+
		">\3>\3?\3?\3?\3@\3@\3A\3A\3B\3B\3B\3B\3B\3B\3B\3B\3B\3B\5B\u0904\nB\3"+
		"C\3C\3D\3D\3E\3E\5E\u090c\nE\3E\3E\5E\u0910\nE\3E\3E\3E\5E\u0915\nE\3"+
		"E\3E\3E\5E\u091a\nE\3E\3E\5E\u091e\nE\3E\5E\u0921\nE\3F\3F\3F\3F\3G\3"+
		"G\3G\5G\u092a\nG\3G\3G\3G\5G\u092f\nG\3G\3G\5G\u0933\nG\3G\3G\3G\3G\5"+
		"G\u0939\nG\3G\3G\3G\3G\5G\u093f\nG\3G\3G\3G\5G\u0944\nG\3G\3G\5G\u0948"+
		"\nG\5G\u094a\nG\3H\3H\5H\u094e\nH\3H\3H\5H\u0952\nH\5H\u0954\nH\3I\3I"+
		"\5I\u0958\nI\3J\3J\5J\u095c\nJ\3J\3J\5J\u0960\nJ\3J\3J\5J\u0964\nJ\3J"+
		"\3J\3J\3J\3J\3J\3J\3J\3J\5J\u096f\nJ\3K\3K\5K\u0973\nK\3K\3K\3K\3K\3K"+
		"\3K\5K\u097b\nK\3L\3L\3L\3L\3L\3L\3L\3L\5L\u0985\nL\3M\3M\3N\3N\3N\3N"+
		"\3N\3N\3N\3N\3N\3N\3N\3N\3N\5N\u0996\nN\3O\3O\5O\u099a\nO\3O\3O\5O\u099e"+
		"\nO\3O\3O\3O\5O\u09a3\nO\5O\u09a5\nO\3P\3P\5P\u09a9\nP\3P\3P\3P\5P\u09ae"+
		"\nP\3P\3P\5P\u09b2\nP\5P\u09b4\nP\3Q\3Q\5Q\u09b8\nQ\3R\3R\3R\3R\3S\3S"+
		"\3S\3S\3S\3S\3S\5S\u09c5\nS\3T\3T\3U\3U\3V\5V\u09cc\nV\3V\3V\3W\3W\3X"+
		"\3X\3X\3X\3X\3X\5X\u09d8\nX\5X\u09da\nX\3Y\3Y\3Y\5Y\u09df\nY\3Y\3Y\3Y"+
		"\3Z\3Z\3[\3[\3[\3[\3[\3[\3\\\3\\\3\\\3\\\3\\\3]\3]\3^\3^\3^\3^\3^\3^\3"+
		"^\3^\3^\3^\3^\3^\6^\u09ff\n^\r^\16^\u0a00\3^\3^\5^\u0a05\n^\3_\3_\5_\u0a09"+
		"\n_\3`\3`\3`\6`\u0a0e\n`\r`\16`\u0a0f\3`\5`\u0a13\n`\3`\3`\3a\3a\6a\u0a19"+
		"\na\ra\16a\u0a1a\3a\5a\u0a1e\na\3a\3a\3b\3b\3b\3b\3b\3c\3c\3c\3c\3c\3"+
		"d\3d\3d\3e\3e\5e\u0a31\ne\3f\3f\3f\3f\3f\3f\3f\3g\3g\3h\3h\3i\3i\3i\5"+
		"i\u0a41\ni\3j\3j\3j\5j\u0a46\nj\3k\3k\3k\7k\u0a4b\nk\fk\16k\u0a4e\13k"+
		"\3l\3l\3l\7l\u0a53\nl\fl\16l\u0a56\13l\3m\5m\u0a59\nm\3m\3m\3n\3n\3n\3"+
		"n\7n\u0a61\nn\fn\16n\u0a64\13n\3n\3n\3o\3o\3o\7o\u0a6b\no\fo\16o\u0a6e"+
		"\13o\3o\5o\u0a71\no\3p\3p\3q\3q\3r\3r\3r\3r\3r\3r\3r\3s\3s\3s\5s\u0a81"+
		"\ns\3t\3t\3u\3u\5u\u0a87\nu\3v\3v\3w\3w\3w\7w\u0a8e\nw\fw\16w\u0a91\13"+
		"w\3x\3x\3y\3y\5y\u0a97\ny\3z\3z\3{\3{\3{\3{\3{\3|\5|\u0aa1\n|\3|\5|\u0aa4"+
		"\n|\3|\5|\u0aa7\n|\3|\3|\3|\3|\3|\5|\u0aae\n|\3}\3}\3~\3~\3\177\3\177"+
		"\3\177\7\177\u0ab7\n\177\f\177\16\177\u0aba\13\177\3\u0080\3\u0080\3\u0080"+
		"\7\u0080\u0abf\n\u0080\f\u0080\16\u0080\u0ac2\13\u0080\3\u0081\3\u0081"+
		"\3\u0081\5\u0081\u0ac7\n\u0081\3\u0082\3\u0082\5\u0082\u0acb\n\u0082\3"+
		"\u0083\3\u0083\5\u0083\u0acf\n\u0083\3\u0083\3\u0083\3\u0084\3\u0084\3"+
		"\u0085\3\u0085\5\u0085\u0ad7\n\u0085\3\u0086\3\u0086\5\u0086\u0adb\n\u0086"+
		"\3\u0087\3\u0087\3\u0087\3\u0087\3\u0088\3\u0088\5\u0088\u0ae3\n\u0088"+
		"\3\u0089\3\u0089\3\u008a\3\u008a\3\u008b\3\u008b\5\u008b\u0aeb\n\u008b"+
		"\3\u008c\3\u008c\5\u008c\u0aef\n\u008c\3\u008d\3\u008d\5\u008d\u0af3\n"+
		"\u008d\3\u008d\5\u008d\u0af6\n\u008d\3\u008d\5\u008d\u0af9\n\u008d\3\u008d"+
		"\5\u008d\u0afc\n\u008d\3\u008d\5\u008d\u0aff\n\u008d\3\u008e\3\u008e\3"+
		"\u008e\3\u008f\3\u008f\3\u008f\7\u008f\u0b07\n\u008f\f\u008f\16\u008f"+
		"\u0b0a\13\u008f\3\u0090\3\u0090\5\u0090\u0b0e\n\u0090\3\u0091\3\u0091"+
		"\6\u0091\u0b12\n\u0091\r\u0091\16\u0091\u0b13\3\u0092\3\u0092\3\u0092"+
		"\3\u0092\5\u0092\u0b1a\n\u0092\3\u0092\3\u0092\3\u0092\3\u0092\3\u0092"+
		"\3\u0092\5\u0092\u0b22\n\u0092\3\u0092\3\u0092\3\u0092\3\u0092\3\u0092"+
		"\5\u0092\u0b29\n\u0092\3\u0093\3\u0093\3\u0093\3\u0093\3\u0094\5\u0094"+
		"\u0b30\n\u0094\3\u0094\3\u0094\3\u0094\3\u0094\3\u0095\3\u0095\5\u0095"+
		"\u0b38\n\u0095\3\u0095\3\u0095\3\u0095\3\u0096\3\u0096\3\u0096\3\u0096"+
		"\3\u0097\3\u0097\5\u0097\u0b43\n\u0097\3\u0098\3\u0098\5\u0098\u0b47\n"+
		"\u0098\3\u0099\3\u0099\3\u009a\3\u009a\5\u009a\u0b4d\n\u009a\3\u009b\3"+
		"\u009b\3\u009b\3\u009c\3\u009c\3\u009c\3\u009c\3\u009c\3\u009d\3\u009d"+
		"\5\u009d\u0b59\n\u009d\3\u009d\5\u009d\u0b5c\n\u009d\3\u009d\3\u009d\3"+
		"\u009d\3\u009d\5\u009d\u0b62\n\u009d\3\u009d\3\u009d\5\u009d\u0b66\n\u009d"+
		"\3\u009d\3\u009d\3\u009d\3\u009d\3\u009d\5\u009d\u0b6d\n\u009d\5\u009d"+
		"\u0b6f\n\u009d\3\u009e\3\u009e\3\u009e\7\u009e\u0b74\n\u009e\f\u009e\16"+
		"\u009e\u0b77\13\u009e\3\u009f\3\u009f\3\u00a0\3\u00a0\3\u00a0\3\u00a1"+
		"\3\u00a1\3\u00a2\3\u00a2\3\u00a2\3\u00a2\3\u00a3\3\u00a3\3\u00a3\7\u00a3"+
		"\u0b87\n\u00a3\f\u00a3\16\u00a3\u0b8a\13\u00a3\3\u00a4\3\u00a4\3\u00a4"+
		"\3\u00a4\5\u00a4\u0b90\n\u00a4\3\u00a5\3\u00a5\3\u00a5\3\u00a5\3\u00a5"+
		"\5\u00a5\u0b97\n\u00a5\3\u00a6\3\u00a6\3\u00a6\7\u00a6\u0b9c\n\u00a6\f"+
		"\u00a6\16\u00a6\u0b9f\13\u00a6\3\u00a7\3\u00a7\3\u00a7\3\u00a7\3\u00a7"+
		"\3\u00a8\3\u00a8\3\u00a8\3\u00a8\3\u00a8\3\u00a9\3\u00a9\3\u00a9\3\u00aa"+
		"\3\u00aa\3\u00aa\3\u00ab\3\u00ab\3\u00ab\7\u00ab\u0bb4\n\u00ab\f\u00ab"+
		"\16\u00ab\u0bb7\13\u00ab\3\u00ac\3\u00ac\3\u00ad\3\u00ad\5\u00ad\u0bbd"+
		"\n\u00ad\3\u00ae\3\u00ae\3\u00ae\3\u00ae\5\u00ae\u0bc3\n\u00ae\3\u00ae"+
		"\3\u00ae\5\u00ae\u0bc7\n\u00ae\3\u00ae\3\u00ae\5\u00ae\u0bcb\n\u00ae\3"+
		"\u00ae\7\u00ae\u0bce\n\u00ae\f\u00ae\16\u00ae\u0bd1\13\u00ae\3\u00af\3"+
		"\u00af\5\u00af\u0bd5\n\u00af\3\u00b0\3\u00b0\3\u00b0\3\u00b0\5\u00b0\u0bdb"+
		"\n\u00b0\3\u00b0\3\u00b0\5\u00b0\u0bdf\n\u00b0\3\u00b0\3\u00b0\5\u00b0"+
		"\u0be3\n\u00b0\3\u00b0\7\u00b0\u0be6\n\u00b0\f\u00b0\16\u00b0\u0be9\13"+
		"\u00b0\3\u00b1\3\u00b1\5\u00b1\u0bed\n\u00b1\3\u00b2\3\u00b2\3\u00b2\3"+
		"\u00b2\3\u00b2\5\u00b2\u0bf4\n\u00b2\3\u00b3\3\u00b3\5\u00b3\u0bf8\n\u00b3"+
		"\3\u00b4\3\u00b4\3\u00b4\3\u00b5\3\u00b5\5\u00b5\u0bff\n\u00b5\3\u00b6"+
		"\3\u00b6\3\u00b6\3\u00b6\3\u00b6\5\u00b6\u0c06\n\u00b6\5\u00b6\u0c08\n"+
		"\u00b6\3\u00b7\3\u00b7\5\u00b7\u0c0c\n\u00b7\3\u00b7\3\u00b7\5\u00b7\u0c10"+
		"\n\u00b7\3\u00b8\3\u00b8\3\u00b8\7\u00b8\u0c15\n\u00b8\f\u00b8\16\u00b8"+
		"\u0c18\13\u00b8\3\u00b9\3\u00b9\5\u00b9\u0c1c\n\u00b9\3\u00ba\3\u00ba"+
		"\5\u00ba\u0c20\n\u00ba\3\u00bb\3\u00bb\5\u00bb\u0c24\n\u00bb\3\u00bb\3"+
		"\u00bb\3\u00bc\3\u00bc\3\u00bd\3\u00bd\3\u00bd\5\u00bd\u0c2d\n\u00bd\3"+
		"\u00bd\3\u00bd\3\u00be\5\u00be\u0c32\n\u00be\3\u00be\3\u00be\3\u00bf\3"+
		"\u00bf\3\u00bf\7\u00bf\u0c39\n\u00bf\f\u00bf\16\u00bf\u0c3c\13\u00bf\3"+
		"\u00c0\3\u00c0\3\u00c1\3\u00c1\3\u00c2\3\u00c2\3\u00c3\3\u00c3\3\u00c3"+
		"\3\u00c3\3\u00c4\3\u00c4\3\u00c4\3\u00c4\3\u00c4\3\u00c4\5\u00c4\u0c4e"+
		"\n\u00c4\3\u00c5\3\u00c5\3\u00c5\3\u00c5\3\u00c6\3\u00c6\3\u00c7\3\u00c7"+
		"\3\u00c7\3\u00c8\5\u00c8\u0c5a\n\u00c8\3\u00c8\3\u00c8\5\u00c8\u0c5e\n"+
		"\u00c8\3\u00c8\3\u00c8\3\u00c8\3\u00c8\3\u00c9\3\u00c9\5\u00c9\u0c66\n"+
		"\u00c9\3\u00c9\3\u00c9\3\u00c9\3\u00ca\3\u00ca\3\u00ca\3\u00ca\3\u00ca"+
		"\5\u00ca\u0c70\n\u00ca\3\u00cb\3\u00cb\3\u00cb\7\u00cb\u0c75\n\u00cb\f"+
		"\u00cb\16\u00cb\u0c78\13\u00cb\3\u00cc\3\u00cc\3\u00cc\3\u00cc\3\u00cd"+
		"\5\u00cd\u0c7f\n\u00cd\3\u00cd\3\u00cd\5\u00cd\u0c83\n\u00cd\3\u00ce\3"+
		"\u00ce\3\u00ce\3\u00ce\3\u00ce\3\u00ce\5\u00ce\u0c8b\n\u00ce\3\u00cf\3"+
		"\u00cf\3\u00d0\3\u00d0\3\u00d0\5\u00d0\u0c92\n\u00d0\3\u00d0\3\u00d0\3"+
		"\u00d1\3\u00d1\3\u00d1\3\u00d1\3\u00d1\3\u00d2\3\u00d2\5\u00d2\u0c9d\n"+
		"\u00d2\3\u00d3\3\u00d3\3\u00d4\3\u00d4\3\u00d5\5\u00d5\u0ca4\n\u00d5\3"+
		"\u00d5\3\u00d5\3\u00d5\3\u00d6\3\u00d6\3\u00d6\3\u00d7\3\u00d7\5\u00d7"+
		"\u0cae\n\u00d7\3\u00d8\3\u00d8\3\u00d9\3\u00d9\3\u00da\3\u00da\3\u00da"+
		"\5\u00da\u0cb7\n\u00da\3\u00da\3\u00da\3\u00db\3\u00db\3\u00dc\3\u00dc"+
		"\5\u00dc\u0cbf\n\u00dc\3\u00dd\3\u00dd\3\u00dd\7\u00dd\u0cc4\n\u00dd\f"+
		"\u00dd\16\u00dd\u0cc7\13\u00dd\3\u00de\3\u00de\3\u00de\3\u00de\3\u00df"+
		"\3\u00df\3\u00df\7\u00df\u0cd0\n\u00df\f\u00df\16\u00df\u0cd3\13\u00df"+
		"\3\u00e0\3\u00e0\5\u00e0\u0cd7\n\u00e0\3\u00e0\5\u00e0\u0cda\n\u00e0\3"+
		"\u00e1\3\u00e1\3\u00e2\3\u00e2\3\u00e2\3\u00e3\3\u00e3\3\u00e3\3\u00e3"+
		"\5\u00e3\u0ce5\n\u00e3\3\u00e4\3\u00e4\5\u00e4\u0ce9\n\u00e4\3\u00e4\3"+
		"\u00e4\3\u00e4\3\u00e4\3\u00e4\3\u00e4\5\u00e4\u0cf1\n\u00e4\3\u00e4\3"+
		"\u00e4\3\u00e4\3\u00e4\5\u00e4\u0cf7\n\u00e4\3\u00e4\3\u00e4\3\u00e4\3"+
		"\u00e4\3\u00e4\3\u00e4\5\u00e4\u0cff\n\u00e4\5\u00e4\u0d01\n\u00e4\3\u00e4"+
		"\5\u00e4\u0d04\n\u00e4\3\u00e4\2\2\u00e5\2\4\6\b\n\f\16\20\22\24\26\30"+
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
		"\u01ba\u01bc\u01be\u01c0\u01c2\u01c4\u01c6\2&\4\2IIii\4\2\u00f2\u00f2"+
		"\u012a\u012a\t\2\35\35^^hhssuuyy\u00b2\u00b2\6\2^^hhyy\u00b2\u00b2\4\2"+
		"hhyz\5\2\22\22\26\26op\4\2\26\26zz\4\2\16\16``\4\2hhyy\3\2\u0141\u0141"+
		"\4\2\u00b4\u00b4\u00b7\u00b7\6\288??QQ||\3\2op\4\2\60\60II\4\2&&99\b\2"+
		"\6\6\24\24\32\32\u0090\u0090\u00af\u00af\u00e5\u00e5\t\2\u0082\u00ac\u00ae"+
		"\u00ae\u00b0\u00ea\u00ec\u00f8\u00fa\u010f\u0111\u011e\u0120\u0123\5\2"+
		"))tt\u00f3\u00f3\3\2\u0100\u0101\3\2\u0142\u0143\17\2\b\bjj\u0083\u0083"+
		"\u008c\u008c\u0094\u0094\u00a2\u00a2\u00aa\u00aa\u00b3\u00b3\u00bf\u00bf"+
		"\u00c4\u00c4\u00e6\u00e7\u00e9\u00e9\u00f6\u00f7\3\2\u0136\u0137\3\2\u0138"+
		"\u013a\3\2\u00ee\u00f0\5\2\f\fEErr\5\2,,FFcc\4\2$$ww\4\2\6\6\37\37\4\2"+
		"\u012a\u012a\u012f\u0133\4\2\t\tmm\3\2\u0124\u0127\4\2\b\bjj\6\2\u0099"+
		"\u0099\u00ad\u00ad\u00c6\u00c7\u00fe\u00fe\n\2\u0089\u0089\u009b\u009b"+
		"\u009e\u009f\u00a1\u00a1\u00b5\u00b6\u00c1\u00c3\u00d7\u00d7\u00fb\u00fb"+
		"\4\2FFcc\4\2\n\n\36\36\u0eac\2\u01ce\3\2\2\2\4\u01df\3\2\2\2\6\u01e1\3"+
		"\2\2\2\b\u01e3\3\2\2\2\n\u01e7\3\2\2\2\f\u01e9\3\2\2\2\16\u01fa\3\2\2"+
		"\2\20\u0238\3\2\2\2\22\u023a\3\2\2\2\24\u03fb\3\2\2\2\26\u03fd\3\2\2\2"+
		"\30\u0552\3\2\2\2\32\u0554\3\2\2\2\34\u0568\3\2\2\2\36\u05e6\3\2\2\2 "+
		"\u0656\3\2\2\2\"\u065f\3\2\2\2$\u0661\3\2\2\2&\u0663\3\2\2\2(\u0677\3"+
		"\2\2\2*\u0683\3\2\2\2,\u0757\3\2\2\2.\u0759\3\2\2\2\60\u075e\3\2\2\2\62"+
		"\u07d1\3\2\2\2\64\u0800\3\2\2\2\66\u0805\3\2\2\28\u081a\3\2\2\2:\u0825"+
		"\3\2\2\2<\u0829\3\2\2\2>\u0831\3\2\2\2@\u0834\3\2\2\2B\u083c\3\2\2\2D"+
		"\u0847\3\2\2\2F\u084a\3\2\2\2H\u084c\3\2\2\2J\u0858\3\2\2\2L\u085c\3\2"+
		"\2\2N\u085f\3\2\2\2P\u0862\3\2\2\2R\u0868\3\2\2\2T\u086a\3\2\2\2V\u0874"+
		"\3\2\2\2X\u087c\3\2\2\2Z\u088e\3\2\2\2\\\u089b\3\2\2\2^\u08a3\3\2\2\2"+
		"`\u08a6\3\2\2\2b\u08a9\3\2\2\2d\u08b3\3\2\2\2f\u08bb\3\2\2\2h\u08c5\3"+
		"\2\2\2j\u08ca\3\2\2\2l\u08cc\3\2\2\2n\u08da\3\2\2\2p\u08dc\3\2\2\2r\u08e0"+
		"\3\2\2\2t\u08e5\3\2\2\2v\u08ea\3\2\2\2x\u08ec\3\2\2\2z\u08ef\3\2\2\2|"+
		"\u08f2\3\2\2\2~\u08f5\3\2\2\2\u0080\u08f7\3\2\2\2\u0082\u0903\3\2\2\2"+
		"\u0084\u0905\3\2\2\2\u0086\u0907\3\2\2\2\u0088\u0920\3\2\2\2\u008a\u0922"+
		"\3\2\2\2\u008c\u0949\3\2\2\2\u008e\u0953\3\2\2\2\u0090\u0957\3\2\2\2\u0092"+
		"\u096e\3\2\2\2\u0094\u097a\3\2\2\2\u0096\u0984\3\2\2\2\u0098\u0986\3\2"+
		"\2\2\u009a\u0995\3\2\2\2\u009c\u09a4\3\2\2\2\u009e\u09b3\3\2\2\2\u00a0"+
		"\u09b7\3\2\2\2\u00a2\u09b9\3\2\2\2\u00a4\u09c4\3\2\2\2\u00a6\u09c6\3\2"+
		"\2\2\u00a8\u09c8\3\2\2\2\u00aa\u09cb\3\2\2\2\u00ac\u09cf\3\2\2\2\u00ae"+
		"\u09d9\3\2\2\2\u00b0\u09db\3\2\2\2\u00b2\u09e3\3\2\2\2\u00b4\u09e5\3\2"+
		"\2\2\u00b6\u09eb\3\2\2\2\u00b8\u09f0\3\2\2\2\u00ba\u0a04\3\2\2\2\u00bc"+
		"\u0a08\3\2\2\2\u00be\u0a0a\3\2\2\2\u00c0\u0a16\3\2\2\2\u00c2\u0a21\3\2"+
		"\2\2\u00c4\u0a26\3\2\2\2\u00c6\u0a2b\3\2\2\2\u00c8\u0a30\3\2\2\2\u00ca"+
		"\u0a32\3\2\2\2\u00cc\u0a39\3\2\2\2\u00ce\u0a3b\3\2\2\2\u00d0\u0a40\3\2"+
		"\2\2\u00d2\u0a45\3\2\2\2\u00d4\u0a47\3\2\2\2\u00d6\u0a4f\3\2\2\2\u00d8"+
		"\u0a58\3\2\2\2\u00da\u0a5c\3\2\2\2\u00dc\u0a70\3\2\2\2\u00de\u0a72\3\2"+
		"\2\2\u00e0\u0a74\3\2\2\2\u00e2\u0a76\3\2\2\2\u00e4\u0a80\3\2\2\2\u00e6"+
		"\u0a82\3\2\2\2\u00e8\u0a86\3\2\2\2\u00ea\u0a88\3\2\2\2\u00ec\u0a8a\3\2"+
		"\2\2\u00ee\u0a92\3\2\2\2\u00f0\u0a96\3\2\2\2\u00f2\u0a98\3\2\2\2\u00f4"+
		"\u0a9a\3\2\2\2\u00f6\u0aad\3\2\2\2\u00f8\u0aaf\3\2\2\2\u00fa\u0ab1\3\2"+
		"\2\2\u00fc\u0ab3\3\2\2\2\u00fe\u0abb\3\2\2\2\u0100\u0ac6\3\2\2\2\u0102"+
		"\u0ac8\3\2\2\2\u0104\u0acc\3\2\2\2\u0106\u0ad2\3\2\2\2\u0108\u0ad6\3\2"+
		"\2\2\u010a\u0ada\3\2\2\2\u010c\u0adc\3\2\2\2\u010e\u0ae2\3\2\2\2\u0110"+
		"\u0ae4\3\2\2\2\u0112\u0ae6\3\2\2\2\u0114\u0aea\3\2\2\2\u0116\u0aee\3\2"+
		"\2\2\u0118\u0af0\3\2\2\2\u011a\u0b00\3\2\2\2\u011c\u0b03\3\2\2\2\u011e"+
		"\u0b0d\3\2\2\2\u0120\u0b0f\3\2\2\2\u0122\u0b28\3\2\2\2\u0124\u0b2a\3\2"+
		"\2\2\u0126\u0b2f\3\2\2\2\u0128\u0b35\3\2\2\2\u012a\u0b3c\3\2\2\2\u012c"+
		"\u0b42\3\2\2\2\u012e\u0b44\3\2\2\2\u0130\u0b48\3\2\2\2\u0132\u0b4c\3\2"+
		"\2\2\u0134\u0b4e\3\2\2\2\u0136\u0b51\3\2\2\2\u0138\u0b6e\3\2\2\2\u013a"+
		"\u0b70\3\2\2\2\u013c\u0b78\3\2\2\2\u013e\u0b7a\3\2\2\2\u0140\u0b7d\3\2"+
		"\2\2\u0142\u0b7f\3\2\2\2\u0144\u0b83\3\2\2\2\u0146\u0b8f\3\2\2\2\u0148"+
		"\u0b96\3\2\2\2\u014a\u0b98\3\2\2\2\u014c\u0ba0\3\2\2\2\u014e\u0ba5\3\2"+
		"\2\2\u0150\u0baa\3\2\2\2\u0152\u0bad\3\2\2\2\u0154\u0bb0\3\2\2\2\u0156"+
		"\u0bb8\3\2\2\2\u0158\u0bbc\3\2\2\2\u015a\u0bc6\3\2\2\2\u015c\u0bd4\3\2"+
		"\2\2\u015e\u0bde\3\2\2\2\u0160\u0bec\3\2\2\2\u0162\u0bf3\3\2\2\2\u0164"+
		"\u0bf7\3\2\2\2\u0166\u0bf9\3\2\2\2\u0168\u0bfe\3\2\2\2\u016a\u0c00\3\2"+
		"\2\2\u016c\u0c09\3\2\2\2\u016e\u0c11\3\2\2\2\u0170\u0c1b\3\2\2\2\u0172"+
		"\u0c1d\3\2\2\2\u0174\u0c23\3\2\2\2\u0176\u0c27\3\2\2\2\u0178\u0c2c\3\2"+
		"\2\2\u017a\u0c31\3\2\2\2\u017c\u0c35\3\2\2\2\u017e\u0c3d\3\2\2\2\u0180"+
		"\u0c3f\3\2\2\2\u0182\u0c41\3\2\2\2\u0184\u0c43\3\2\2\2\u0186\u0c4d\3\2"+
		"\2\2\u0188\u0c4f\3\2\2\2\u018a\u0c53\3\2\2\2\u018c\u0c55\3\2\2\2\u018e"+
		"\u0c59\3\2\2\2\u0190\u0c63\3\2\2\2\u0192\u0c6f\3\2\2\2\u0194\u0c71\3\2"+
		"\2\2\u0196\u0c79\3\2\2\2\u0198\u0c82\3\2\2\2\u019a\u0c8a\3\2\2\2\u019c"+
		"\u0c8c\3\2\2\2\u019e\u0c8e\3\2\2\2\u01a0\u0c95\3\2\2\2\u01a2\u0c9c\3\2"+
		"\2\2\u01a4\u0c9e\3\2\2\2\u01a6\u0ca0\3\2\2\2\u01a8\u0ca3\3\2\2\2\u01aa"+
		"\u0ca8\3\2\2\2\u01ac\u0cad\3\2\2\2\u01ae\u0caf\3\2\2\2\u01b0\u0cb1\3\2"+
		"\2\2\u01b2\u0cb3\3\2\2\2\u01b4\u0cba\3\2\2\2\u01b6\u0cbe\3\2\2\2\u01b8"+
		"\u0cc0\3\2\2\2\u01ba\u0cc8\3\2\2\2\u01bc\u0ccc\3\2\2\2\u01be\u0cd4\3\2"+
		"\2\2\u01c0\u0cdb\3\2\2\2\u01c2\u0cdd\3\2\2\2\u01c4\u0ce4\3\2\2\2\u01c6"+
		"\u0d03\3\2\2\2\u01c8\u01ca\5\4\3\2\u01c9\u01cb\7\u012c\2\2\u01ca\u01c9"+
		"\3\2\2\2\u01ca\u01cb\3\2\2\2\u01cb\u01cd\3\2\2\2\u01cc\u01c8\3\2\2\2\u01cd"+
		"\u01d0\3\2\2\2\u01ce\u01cc\3\2\2\2\u01ce\u01cf\3\2\2\2\u01cf\u01d1\3\2"+
		"\2\2\u01d0\u01ce\3\2\2\2\u01d1\u01d2\7\2\2\3\u01d2\3\3\2\2\2\u01d3\u01e0"+
		"\5\6\4\2\u01d4\u01e0\5\b\5\2\u01d5\u01e0\5\n\6\2\u01d6\u01e0\5\f\7\2\u01d7"+
		"\u01e0\5\16\b\2\u01d8\u01e0\5\20\t\2\u01d9\u01e0\5\22\n\2\u01da\u01e0"+
		"\5\30\r\2\u01db\u01e0\5\24\13\2\u01dc\u01e0\5\34\17\2\u01dd\u01e0\5\36"+
		"\20\2\u01de\u01e0\5*\26\2\u01df\u01d3\3\2\2\2\u01df\u01d4\3\2\2\2\u01df"+
		"\u01d5\3\2\2\2\u01df\u01d6\3\2\2\2\u01df\u01d7\3\2\2\2\u01df\u01d8\3\2"+
		"\2\2\u01df\u01d9\3\2\2\2\u01df\u01da\3\2\2\2\u01df\u01db\3\2\2\2\u01df"+
		"\u01dc\3\2\2\2\u01df\u01dd\3\2\2\2\u01df\u01de\3\2\2\2\u01e0\5\3\2\2\2"+
		"\u01e1\u01e2\5\u0156\u00ac\2\u01e2\7\3\2\2\2\u01e3\u01e4\5\u01c6\u00e4"+
		"\2\u01e4\t\3\2\2\2\u01e5\u01e8\5,\27\2\u01e6\u01e8\5l\67\2\u01e7\u01e5"+
		"\3\2\2\2\u01e7\u01e6\3\2\2\2\u01e8\13\3\2\2\2\u01e9\u01eb\7\26\2\2\u01ea"+
		"\u01ec\7x\2\2\u01eb\u01ea\3\2\2\2\u01eb\u01ec\3\2\2\2\u01ec\u01ed\3\2"+
		"\2\2\u01ed\u01ee\7\u00ae\2\2\u01ee\u01ef\5n8\2\u01ef\u01f0\7O\2\2\u01f0"+
		"\u01f2\5\u016a\u00b6\2\u01f1\u01f3\5L\'\2\u01f2\u01f1\3\2\2\2\u01f2\u01f3"+
		"\3\2\2\2\u01f3\u01f4\3\2\2\2\u01f4\u01f5\7\u0134\2\2\u01f5\u01f6\5\u01bc"+
		"\u00df\2\u01f6\u01f8\7\u0135\2\2\u01f7\u01f9\5H%\2\u01f8\u01f7\3\2\2\2"+
		"\u01f8\u01f9\3\2\2\2\u01f9\r\3\2\2\2\u01fa\u01fb\7\26\2\2\u01fb\u01ff"+
		"\7(\2\2\u01fc\u01fd\7\64\2\2\u01fd\u01fe\7K\2\2\u01fe\u0200\7\u00a3\2"+
		"\2\u01ff\u01fc\3\2\2\2\u01ff\u0200\3\2\2\2\u0200\u0201\3\2\2\2\u0201\u0203"+
		"\5n8\2\u0202\u0204\7\u0080\2\2\u0203\u0202\3\2\2\2\u0203\u0204\3\2\2\2"+
		"\u0204\u0207\3\2\2\2\u0205\u0206\7e\2\2\u0206\u0208\5n8\2\u0207\u0205"+
		"\3\2\2\2\u0207\u0208\3\2\2\2\u0208\u020b\3\2\2\2\u0209\u020a\7\u00f9\2"+
		"\2\u020a\u020c\5n8\2\u020b\u0209\3\2\2\2\u020b\u020c\3\2\2\2\u020c\u020f"+
		"\3\2\2\2\u020d\u020e\7/\2\2\u020e\u0210\5n8\2\u020f\u020d\3\2\2\2\u020f"+
		"\u0210\3\2\2\2\u0210\17\3\2\2\2\u0211\u0213\7\u00e0\2\2\u0212\u0214\t"+
		"\2\2\2\u0213\u0212\3\2\2\2\u0213\u0214\3\2\2\2\u0214\u0215\3\2\2\2\u0215"+
		"\u0216\5n8\2\u0216\u0222\t\3\2\2\u0217\u021e\5n8\2\u0218\u0219\7\u013e"+
		"\2\2\u0219\u021a\5n8\2\u021a\u021b\7\u013e\2\2\u021b\u021e\3\2\2\2\u021c"+
		"\u021e\7\31\2\2\u021d\u0217\3\2\2\2\u021d\u0218\3\2\2\2\u021d\u021c\3"+
		"\2\2\2\u021e\u0220\3\2\2\2\u021f\u0221\7\u012d\2\2\u0220\u021f\3\2\2\2"+
		"\u0220\u0221\3\2\2\2\u0221\u0223\3\2\2\2\u0222\u021d\3\2\2\2\u0223\u0224"+
		"\3\2\2\2\u0224\u0222\3\2\2\2\u0224\u0225\3\2\2\2\u0225\u0239\3\2\2\2\u0226"+
		"\u0228\7\u00e0\2\2\u0227\u0229\t\2\2\2\u0228\u0227\3\2\2\2\u0228\u0229"+
		"\3\2\2\2\u0229\u022a\3\2\2\2\u022a\u022b\7\u011a\2\2\u022b\u0234\7\u00ff"+
		"\2\2\u022c\u0230\5n8\2\u022d\u0230\7I\2\2\u022e\u0230\7\31\2\2\u022f\u022c"+
		"\3\2\2\2\u022f\u022d\3\2\2\2\u022f\u022e\3\2\2\2\u0230\u0232\3\2\2\2\u0231"+
		"\u0233\7\u012d\2\2\u0232\u0231\3\2\2\2\u0232\u0233\3\2\2\2\u0233\u0235"+
		"\3\2\2\2\u0234\u022f\3\2\2\2\u0235\u0236\3\2\2\2\u0236\u0234\3\2\2\2\u0236"+
		"\u0237\3\2\2\2\u0237\u0239\3\2\2\2\u0238\u0211\3\2\2\2\u0238\u0226\3\2"+
		"\2\2\u0239\21\3\2\2\2\u023a\u023c\7\26\2\2\u023b\u023d\7\23\2\2\u023c"+
		"\u023b\3\2\2\2\u023c\u023d\3\2\2\2\u023d\u023e\3\2\2\2\u023e\u023f\7s"+
		"\2\2\u023f\u0244\5n8\2\u0240\u0245\7\13\2\2\u0241\u0242\7@\2\2\u0242\u0245"+
		"\7M\2\2\u0243\u0245\7\4\2\2\u0244\u0240\3\2\2\2\u0244\u0241\3\2\2\2\u0244"+
		"\u0243\3\2\2\2\u0245\u0255\3\2\2\2\u0246\u0256\7\u00b2\2\2\u0247\u0256"+
		"\7\35\2\2\u0248\u0256\7u\2\2\u0249\u0253\7y\2\2\u024a\u024f\7M\2\2\u024b"+
		"\u024d\5n8\2\u024c\u024e\7\u012d\2\2\u024d\u024c\3\2\2\2\u024d\u024e\3"+
		"\2\2\2\u024e\u0250\3\2\2\2\u024f\u024b\3\2\2\2\u0250\u0251\3\2\2\2\u0251"+
		"\u024f\3\2\2\2\u0251\u0252\3\2\2\2\u0252\u0254\3\2\2\2\u0253\u024a\3\2"+
		"\2\2\u0253\u0254\3\2\2\2\u0254\u0256\3\2\2\2\u0255\u0246\3\2\2\2\u0255"+
		"\u0247\3\2\2\2\u0255\u0248\3\2\2\2\u0255\u0249\3\2\2\2\u0256\u0257\3\2"+
		"\2\2\u0257\u0258\7O\2\2\u0258\u025b\5\u016a\u00b6\2\u0259\u025a\7/\2\2"+
		"\u025a\u025c\5\u016a\u00b6\2\u025b\u0259\3\2\2\2\u025b\u025c\3\2\2\2\u025c"+
		"\u0266\3\2\2\2\u025d\u025e\7K\2\2\u025e\u0267\7\33\2\2\u025f\u0261\7\33"+
		"\2\2\u0260\u025f\3\2\2\2\u0260\u0261\3\2\2\2\u0261\u0262\3\2\2\2\u0262"+
		"\u0263\7;\2\2\u0263\u0267\7\66\2\2\u0264\u0265\7;\2\2\u0265\u0267\7\34"+
		"\2\2\u0266\u025d\3\2\2\2\u0266\u0260\3\2\2\2\u0266\u0264\3\2\2\2\u0266"+
		"\u0267\3\2\2\2\u0267\u026e\3\2\2\2\u0268\u026a\7*\2\2\u0269\u026b\7!\2"+
		"\2\u026a\u0269\3\2\2\2\u026a\u026b\3\2\2\2\u026b\u026c\3\2\2\2\u026c\u026f"+
		"\7\\\2\2\u026d\u026f\7k\2\2\u026e\u0268\3\2\2\2\u026e\u026d\3\2\2\2\u026e"+
		"\u026f\3\2\2\2\u026f\u0272\3\2\2\2\u0270\u0271\7~\2\2\u0271\u0273\5\u00fa"+
		"~\2\u0272\u0270\3\2\2\2\u0272\u0273\3\2\2\2\u0273\u0274\3\2\2\2\u0274"+
		"\u0275\7\'\2\2\u0275\u0276\7Y\2\2\u0276\u0277\5n8\2\u0277\u027c\7\u0134"+
		"\2\2\u0278\u027a\5n8\2\u0279\u027b\7\u012d\2\2\u027a\u0279\3\2\2\2\u027a"+
		"\u027b\3\2\2\2\u027b\u027d\3\2\2\2\u027c\u0278\3\2\2\2\u027c\u027d\3\2"+
		"\2\2\u027d\u027e\3\2\2\2\u027e\u027f\7\u0135\2\2\u027f\23\3\2\2\2\u0280"+
		"\u0284\7b\2\2\u0281\u0282\7\61\2\2\u0282\u0283\7\u00cd\2\2\u0283\u0285"+
		"\7*\2\2\u0284\u0281\3\2\2\2\u0284\u0285\3\2\2\2\u0285\u028f\3\2\2\2\u0286"+
		"\u0288\t\4\2\2\u0287\u0286\3\2\2\2\u0288\u0289\3\2\2\2\u0289\u0287\3\2"+
		"\2\2\u0289\u028a\3\2\2\2\u028a\u0290\3\2\2\2\u028b\u028d\7\6\2\2\u028c"+
		"\u028e\7X\2\2\u028d\u028c\3\2\2\2\u028d\u028e\3\2\2\2\u028e\u0290\3\2"+
		"\2\2\u028f\u0287\3\2\2\2\u028f\u028b\3\2\2\2\u0290\u0291\3\2\2\2\u0291"+
		"\u02a3\7O\2\2\u0292\u0294\7n\2\2\u0293\u0292\3\2\2\2\u0293\u0294\3\2\2"+
		"\2\u0294\u0295\3\2\2\2\u0295\u0297\5\u016a\u00b6\2\u0296\u0293\3\2\2\2"+
		"\u0297\u0298\3\2\2\2\u0298\u0296\3\2\2\2\u0298\u0299\3\2\2\2\u0299\u02a4"+
		"\3\2\2\2\u029a\u029b\7\6\2\2\u029b\u029c\7\u00eb\2\2\u029c\u029d\78\2"+
		"\2\u029d\u029f\7e\2\2\u029e\u02a0\5n8\2\u029f\u029e\3\2\2\2\u02a0\u02a1"+
		"\3\2\2\2\u02a1\u029f\3\2\2\2\u02a1\u02a2\3\2\2\2\u02a2\u02a4\3\2\2\2\u02a3"+
		"\u0296\3\2\2\2\u02a3\u029a\3\2\2\2\u02a4\u02a5\3\2\2\2\u02a5\u02a6\5\26"+
		"\f\2\u02a6\u03fc\3\2\2\2\u02a7\u02ab\7b\2\2\u02a8\u02a9\7\61\2\2\u02a9"+
		"\u02aa\7\u00cd\2\2\u02aa\u02ac\7*\2\2\u02ab\u02a8\3\2\2\2\u02ab\u02ac"+
		"\3\2\2\2\u02ac\u02cc\3\2\2\2\u02ad\u02ae\t\5\2\2\u02ae\u02b3\7\u0134\2"+
		"\2\u02af\u02b1\5n8\2\u02b0\u02b2\7\u012d\2\2\u02b1\u02b0\3\2\2\2\u02b1"+
		"\u02b2\3\2\2\2\u02b2\u02b4\3\2\2\2\u02b3\u02af\3\2\2\2\u02b4\u02b5\3\2"+
		"\2\2\u02b5\u02b3\3\2\2\2\u02b5\u02b6\3\2\2\2\u02b6\u02b7\3\2\2\2\u02b7"+
		"\u02b8\7\u0135\2\2\u02b8\u02ba\3\2\2\2\u02b9\u02ad\3\2\2\2\u02ba\u02bb"+
		"\3\2\2\2\u02bb\u02b9\3\2\2\2\u02bb\u02bc\3\2\2\2\u02bc\u02cd\3\2\2\2\u02bd"+
		"\u02bf\7\6\2\2\u02be\u02c0\7X\2\2\u02bf\u02be\3\2\2\2\u02bf\u02c0\3\2"+
		"\2\2\u02c0\u02c1\3\2\2\2\u02c1\u02c6\7\u0134\2\2\u02c2\u02c4\5n8\2\u02c3"+
		"\u02c5\7\u012d\2\2\u02c4\u02c3\3\2\2\2\u02c4\u02c5\3\2\2\2\u02c5\u02c7"+
		"\3\2\2\2\u02c6\u02c2\3\2\2\2\u02c7\u02c8\3\2\2\2\u02c8\u02c6\3\2\2\2\u02c8"+
		"\u02c9\3\2\2\2\u02c9\u02ca\3\2\2\2\u02ca\u02cb\7\u0135\2\2\u02cb\u02cd"+
		"\3\2\2\2\u02cc\u02b9\3\2\2\2\u02cc\u02bd\3\2\2\2\u02cd\u02ce\3\2\2\2\u02ce"+
		"\u02d0\7O\2\2\u02cf\u02d1\7n\2\2\u02d0\u02cf\3\2\2\2\u02d0\u02d1\3\2\2"+
		"\2\u02d1\u02d6\3\2\2\2\u02d2\u02d4\5\u016a\u00b6\2\u02d3\u02d5\7\u012d"+
		"\2\2\u02d4\u02d3\3\2\2\2\u02d4\u02d5\3\2\2\2\u02d5\u02d7\3\2\2\2\u02d6"+
		"\u02d2\3\2\2\2\u02d7\u02d8\3\2\2\2\u02d8\u02d6\3\2\2\2\u02d8\u02d9\3\2"+
		"\2\2\u02d9\u02da\3\2\2\2\u02da\u02db\5\26\f\2\u02db\u03fc\3\2\2\2\u02dc"+
		"\u02e0\7b\2\2\u02dd\u02de\7\61\2\2\u02de\u02df\7\u00cd\2\2\u02df\u02e1"+
		"\7*\2\2\u02e0\u02dd\3\2\2\2\u02e0\u02e1\3\2\2\2\u02e1\u02eb\3\2\2\2\u02e2"+
		"\u02e4\t\6\2\2\u02e3\u02e2\3\2\2\2\u02e4\u02e5\3\2\2\2\u02e5\u02e3\3\2"+
		"\2\2\u02e5\u02e6\3\2\2\2\u02e6\u02ec\3\2\2\2\u02e7\u02e9\7\6\2\2\u02e8"+
		"\u02ea\7X\2\2\u02e9\u02e8\3\2\2\2\u02e9\u02ea\3\2\2\2\u02ea\u02ec\3\2"+
		"\2\2\u02eb\u02e3\3\2\2\2\u02eb\u02e7\3\2\2\2\u02ec\u02ed\3\2\2\2\u02ed"+
		"\u0303\7O\2\2\u02ee\u02f3\7f\2\2\u02ef\u02f1\5\u016a\u00b6\2\u02f0\u02f2"+
		"\7\u012d\2\2\u02f1\u02f0\3\2\2\2\u02f1\u02f2\3\2\2\2\u02f2\u02f4\3\2\2"+
		"\2\u02f3\u02ef\3\2\2\2\u02f4\u02f5\3\2\2\2\u02f5\u02f3\3\2\2\2\u02f5\u02f6"+
		"\3\2\2\2\u02f6\u0304\3\2\2\2\u02f7\u02f8\7\6\2\2\u02f8\u02f9\7g\2\2\u02f9"+
		"\u02fa\78\2\2\u02fa\u02ff\7e\2\2\u02fb\u02fd\5n8\2\u02fc\u02fe\7\u012d"+
		"\2\2\u02fd\u02fc\3\2\2\2\u02fd\u02fe\3\2\2\2\u02fe\u0300\3\2\2\2\u02ff"+
		"\u02fb\3\2\2\2\u0300\u0301\3\2\2\2\u0301\u02ff\3\2\2\2\u0301\u0302\3\2"+
		"\2\2\u0302\u0304\3\2\2\2\u0303\u02ee\3\2\2\2\u0303\u02f7\3\2\2\2\u0304"+
		"\u0305\3\2\2\2\u0305\u0306\5\26\f\2\u0306\u03fc\3\2\2\2\u0307\u030b\7"+
		"b\2\2\u0308\u0309\7\61\2\2\u0309\u030a\7\u00cd\2\2\u030a\u030c\7*\2\2"+
		"\u030b\u0308\3\2\2\2\u030b\u030c\3\2\2\2\u030c\u0316\3\2\2\2\u030d\u030f"+
		"\t\7\2\2\u030e\u030d\3\2\2\2\u030f\u0310\3\2\2\2\u0310\u030e\3\2\2\2\u0310"+
		"\u0311\3\2\2\2\u0311\u0317\3\2\2\2\u0312\u0314\7\6\2\2\u0313\u0315\7X"+
		"\2\2\u0314\u0313\3\2\2\2\u0314\u0315\3\2\2\2\u0315\u0317\3\2\2\2\u0316"+
		"\u030e\3\2\2\2\u0316\u0312\3\2\2\2\u0317\u0318\3\2\2\2\u0318\u0319\7O"+
		"\2\2\u0319\u031e\7\30\2\2\u031a\u031c\5n8\2\u031b\u031d\7\u012d\2\2\u031c"+
		"\u031b\3\2\2\2\u031c\u031d\3\2\2\2\u031d\u031f\3\2\2\2\u031e\u031a\3\2"+
		"\2\2\u031f\u0320\3\2\2\2\u0320\u031e\3\2\2\2\u0320\u0321\3\2\2\2\u0321"+
		"\u0322\3\2\2\2\u0322\u0323\5\26\f\2\u0323\u03fc\3\2\2\2\u0324\u0328\7"+
		"b\2\2\u0325\u0326\7\61\2\2\u0326\u0327\7\u00cd\2\2\u0327\u0329\7*\2\2"+
		"\u0328\u0325\3\2\2\2\u0328\u0329\3\2\2\2\u0329\u032f\3\2\2\2\u032a\u0330"+
		"\7z\2\2\u032b\u032d\7\6\2\2\u032c\u032e\7X\2\2\u032d\u032c\3\2\2\2\u032d"+
		"\u032e\3\2\2\2\u032e\u0330\3\2\2\2\u032f\u032a\3\2\2\2\u032f\u032b\3\2"+
		"\2\2\u0330\u0331\3\2\2\2\u0331\u0332\7O\2\2\u0332\u0333\7+\2\2\u0333\u0334"+
		"\7\u0098\2\2\u0334\u0339\7\u00fd\2\2\u0335\u0337\5\u016a\u00b6\2\u0336"+
		"\u0338\7\u012d\2\2\u0337\u0336\3\2\2\2\u0337\u0338\3\2\2\2\u0338\u033a"+
		"\3\2\2\2\u0339\u0335\3\2\2\2\u033a\u033b\3\2\2\2\u033b\u0339\3\2\2\2\u033b"+
		"\u033c\3\2\2\2\u033c\u033d\3\2\2\2\u033d\u033e\5\26\f\2\u033e\u03fc\3"+
		"\2\2\2\u033f\u0343\7b\2\2\u0340\u0341\7\61\2\2\u0341\u0342\7\u00cd\2\2"+
		"\u0342\u0344\7*\2\2\u0343\u0340\3\2\2\2\u0343\u0344\3\2\2\2\u0344\u034a"+
		"\3\2\2\2\u0345\u034b\7z\2\2\u0346\u0348\7\6\2\2\u0347\u0349\7X\2\2\u0348"+
		"\u0347\3\2\2\2\u0348\u0349\3\2\2\2\u0349\u034b\3\2\2\2\u034a\u0345\3\2"+
		"\2\2\u034a\u0346\3\2\2\2\u034b\u034c\3\2\2\2\u034c\u034d\7O\2\2\u034d"+
		"\u034e\7+\2\2\u034e\u0353\7\u00df\2\2\u034f\u0351\5n8\2\u0350\u0352\7"+
		"\u012d\2\2\u0351\u0350\3\2\2\2\u0351\u0352\3\2\2\2\u0352\u0354\3\2\2\2"+
		"\u0353\u034f\3\2\2\2\u0354\u0355\3\2\2\2\u0355\u0353\3\2\2\2\u0355\u0356"+
		"\3\2\2\2\u0356\u0357\3\2\2\2\u0357\u0358\5\26\f\2\u0358\u03fc\3\2\2\2"+
		"\u0359\u035d\7b\2\2\u035a\u035b\7\61\2\2\u035b\u035c\7\u00cd\2\2\u035c"+
		"\u035e\7*\2\2\u035d\u035a\3\2\2\2\u035d\u035e\3\2\2\2\u035e\u0364\3\2"+
		"\2\2\u035f\u0365\7\'\2\2\u0360\u0362\7\6\2\2\u0361\u0363\7X\2\2\u0362"+
		"\u0361\3\2\2\2\u0362\u0363\3\2\2\2\u0363\u0365\3\2\2\2\u0364\u035f\3\2"+
		"\2\2\u0364\u0360\3\2\2\2\u0365\u0366\3\2\2\2\u0366\u0369\7O\2\2\u0367"+
		"\u036a\5&\24\2\u0368\u036a\5(\25\2\u0369\u0367\3\2\2\2\u0369\u0368\3\2"+
		"\2\2\u036a\u036b\3\2\2\2\u036b\u036c\5\26\f\2\u036c\u03fc\3\2\2\2\u036d"+
		"\u0371\7b\2\2\u036e\u036f\7\61\2\2\u036f\u0370\7\u00cd\2\2\u0370\u0372"+
		"\7*\2\2\u0371\u036e\3\2\2\2\u0371\u0372\3\2\2\2\u0372\u0378\3\2\2\2\u0373"+
		"\u0379\7z\2\2\u0374\u0376\7\6\2\2\u0375\u0377\7X\2\2\u0376\u0375\3\2\2"+
		"\2\u0376\u0377\3\2\2\2\u0377\u0379\3\2\2\2\u0378\u0373\3\2\2\2\u0378\u0374"+
		"\3\2\2\2\u0379\u037a\3\2\2\2\u037a\u037b\7O\2\2\u037b\u0380\7\u00b8\2"+
		"\2\u037c\u037e\5n8\2\u037d\u037f\7\u012d\2\2\u037e\u037d\3\2\2\2\u037e"+
		"\u037f\3\2\2\2\u037f\u0381\3\2\2\2\u0380\u037c\3\2\2\2\u0381\u0382\3\2"+
		"\2\2\u0382\u0380\3\2\2\2\u0382\u0383\3\2\2\2\u0383\u0384\3\2\2\2\u0384"+
		"\u0385\5\26\f\2\u0385\u03fc\3\2\2\2\u0386\u038a\7b\2\2\u0387\u0388\7\61"+
		"\2\2\u0388\u0389\7\u00cd\2\2\u0389\u038b\7*\2\2\u038a\u0387\3\2\2\2\u038a"+
		"\u038b\3\2\2\2\u038b\u0399\3\2\2\2\u038c\u0392\7h\2\2\u038d\u038f\7y\2"+
		"\2\u038e\u0390\7\u012d\2\2\u038f\u038e\3\2\2\2\u038f\u0390\3\2\2\2\u0390"+
		"\u0392\3\2\2\2\u0391\u038c\3\2\2\2\u0391\u038d\3\2\2\2\u0392\u0393\3\2"+
		"\2\2\u0393\u0391\3\2\2\2\u0393\u0394\3\2\2\2\u0394\u039a\3\2\2\2\u0395"+
		"\u0397\7\6\2\2\u0396\u0398\7X\2\2\u0397\u0396\3\2\2\2\u0397\u0398\3\2"+
		"\2\2\u0398\u039a\3\2\2\2\u0399\u0391\3\2\2\2\u0399\u0395\3\2\2\2\u039a"+
		"\u039b\3\2\2\2\u039b\u039c\7O\2\2\u039c\u039d\7\u00b9\2\2\u039d\u03a2"+
		"\7\u00cc\2\2\u039e\u03a0\5n8\2\u039f\u03a1\7\u012d\2\2\u03a0\u039f\3\2"+
		"\2\2\u03a0\u03a1\3\2\2\2\u03a1\u03a3\3\2\2\2\u03a2\u039e\3\2\2\2\u03a3"+
		"\u03a4\3\2\2\2\u03a4\u03a2\3\2\2\2\u03a4\u03a5\3\2\2\2\u03a5\u03a6\3\2"+
		"\2\2\u03a6\u03a7\5\26\f\2\u03a7\u03fc\3\2\2\2\u03a8\u03ac\7b\2\2\u03a9"+
		"\u03aa\7\61\2\2\u03aa\u03ab\7\u00cd\2\2\u03ab\u03ad\7*\2\2\u03ac\u03a9"+
		"\3\2\2\2\u03ac\u03ad\3\2\2\2\u03ad\u03ba\3\2\2\2\u03ae\u03b0\t\b\2\2\u03af"+
		"\u03b1\7\u012d\2\2\u03b0\u03af\3\2\2\2\u03b0\u03b1\3\2\2\2\u03b1\u03b3"+
		"\3\2\2\2\u03b2\u03ae\3\2\2\2\u03b3\u03b4\3\2\2\2\u03b4\u03b2\3\2\2\2\u03b4"+
		"\u03b5\3\2\2\2\u03b5\u03bb\3\2\2\2\u03b6\u03b8\7\6\2\2\u03b7\u03b9\7X"+
		"\2\2\u03b8\u03b7\3\2\2\2\u03b8\u03b9\3\2\2\2\u03b9\u03bb\3\2\2\2\u03ba"+
		"\u03b2\3\2\2\2\u03ba\u03b6\3\2\2\2\u03bb\u03bc\3\2\2\2\u03bc\u03bd\7O"+
		"\2\2\u03bd\u03c2\7e\2\2\u03be\u03c0\5n8\2\u03bf\u03c1\7\u012d\2\2\u03c0"+
		"\u03bf\3\2\2\2\u03c0\u03c1\3\2\2\2\u03c1\u03c3\3\2\2\2\u03c2\u03be\3\2"+
		"\2\2\u03c3\u03c4\3\2\2\2\u03c4\u03c2\3\2\2\2\u03c4\u03c5\3\2\2\2\u03c5"+
		"\u03c6\3\2\2\2\u03c6\u03c7\5\26\f\2\u03c7\u03fc\3\2\2\2\u03c8\u03cc\7"+
		"b\2\2\u03c9\u03ca\7\61\2\2\u03ca\u03cb\7\u00cd\2\2\u03cb\u03cd\7*\2\2"+
		"\u03cc\u03c9\3\2\2\2\u03cc\u03cd\3\2\2\2\u03cd\u03d3\3\2\2\2\u03ce\u03d4"+
		"\7\26\2\2\u03cf\u03d1\7\6\2\2\u03d0\u03d2\7X\2\2\u03d1\u03d0\3\2\2\2\u03d1"+
		"\u03d2\3\2\2\2\u03d2\u03d4\3\2\2\2\u03d3\u03ce\3\2\2\2\u03d3\u03cf\3\2"+
		"\2\2\u03d4\u03d5\3\2\2\2\u03d5\u03d6\7O\2\2\u03d6\u03db\7\u00ea\2\2\u03d7"+
		"\u03d9\5n8\2\u03d8\u03da\7\u012d\2\2\u03d9\u03d8\3\2\2\2\u03d9\u03da\3"+
		"\2\2\2\u03da\u03dc\3\2\2\2\u03db\u03d7\3\2\2\2\u03dc\u03dd\3\2\2\2\u03dd"+
		"\u03db\3\2\2\2\u03dd\u03de\3\2\2\2\u03de\u03df\3\2\2\2\u03df\u03e0\5\26"+
		"\f\2\u03e0\u03fc\3\2\2\2\u03e1\u03e5\7b\2\2\u03e2\u03e3\7\u0082\2\2\u03e3"+
		"\u03e4\7\u00cd\2\2\u03e4\u03e6\7*\2\2\u03e5\u03e2\3\2\2\2\u03e5\u03e6"+
		"\3\2\2\2\u03e6\u03eb\3\2\2\2\u03e7\u03e9\5n8\2\u03e8\u03ea\7\u012d\2\2"+
		"\u03e9\u03e8\3\2\2\2\u03e9\u03ea\3\2\2\2\u03ea\u03ec\3\2\2\2\u03eb\u03e7"+
		"\3\2\2\2\u03ec\u03ed\3\2\2\2\u03ed\u03eb\3\2\2\2\u03ed\u03ee\3\2\2\2\u03ee"+
		"\u03ef\3\2\2\2\u03ef\u03f4\7/\2\2\u03f0\u03f2\5n8\2\u03f1\u03f3\7\u012d"+
		"\2\2\u03f2\u03f1\3\2\2\2\u03f2\u03f3\3\2\2\2\u03f3\u03f5\3\2\2\2\u03f4"+
		"\u03f0\3\2\2\2\u03f5\u03f6\3\2\2\2\u03f6\u03f4\3\2\2\2\u03f6\u03f7\3\2"+
		"\2\2\u03f7\u03f9\3\2\2\2\u03f8\u03fa\t\t\2\2\u03f9\u03f8\3\2\2\2\u03f9"+
		"\u03fa\3\2\2\2\u03fa\u03fc\3\2\2\2\u03fb\u0280\3\2\2\2\u03fb\u02a7\3\2"+
		"\2\2\u03fb\u02dc\3\2\2\2\u03fb\u0307\3\2\2\2\u03fb\u0324\3\2\2\2\u03fb"+
		"\u033f\3\2\2\2\u03fb\u0359\3\2\2\2\u03fb\u036d\3\2\2\2\u03fb\u0386\3\2"+
		"\2\2\u03fb\u03a8\3\2\2\2\u03fb\u03c8\3\2\2\2\u03fb\u03e1\3\2\2\2\u03fc"+
		"\25\3\2\2\2\u03fd\u0406\7/\2\2\u03fe\u0400\7\62\2\2\u03ff\u03fe\3\2\2"+
		"\2\u03ff\u0400\3\2\2\2\u0400\u0401\3\2\2\2\u0401\u0407\5n8\2\u0402\u0404"+
		"\7\u00d5\2\2\u0403\u0405\7\u012d\2\2\u0404\u0403\3\2\2\2\u0404\u0405\3"+
		"\2\2\2\u0405\u0407\3\2\2\2\u0406\u03ff\3\2\2\2\u0406\u0402\3\2\2\2\u0407"+
		"\u0408\3\2\2\2\u0408\u0406\3\2\2\2\u0408\u0409\3\2\2\2\u0409\u040b\3\2"+
		"\2\2\u040a\u040c\t\t\2\2\u040b\u040a\3\2\2\2\u040b\u040c\3\2\2\2\u040c"+
		"\27\3\2\2\2\u040d\u0417\7\61\2\2\u040e\u0410\t\4\2\2\u040f\u040e\3\2\2"+
		"\2\u0410\u0411\3\2\2\2\u0411\u040f\3\2\2\2\u0411\u0412\3\2\2\2\u0412\u0418"+
		"\3\2\2\2\u0413\u0415\7\6\2\2\u0414\u0416\7X\2\2\u0415\u0414\3\2\2\2\u0415"+
		"\u0416\3\2\2\2\u0416\u0418\3\2\2\2\u0417\u040f\3\2\2\2\u0417\u0413\3\2"+
		"\2\2\u0418\u0419\3\2\2\2\u0419\u0431\7O\2\2\u041a\u041c\7n\2\2\u041b\u041a"+
		"\3\2\2\2\u041b\u041c\3\2\2\2\u041c\u0421\3\2\2\2\u041d\u041f\5\u016a\u00b6"+
		"\2\u041e\u0420\7\u012d\2\2\u041f\u041e\3\2\2\2\u041f\u0420\3\2\2\2\u0420"+
		"\u0422\3\2\2\2\u0421\u041d\3\2\2\2\u0422\u0423\3\2\2\2\u0423\u0421\3\2"+
		"\2\2\u0423\u0424\3\2\2\2\u0424\u0432\3\2\2\2\u0425\u0426\7\6\2\2\u0426"+
		"\u0427\7\u00eb\2\2\u0427\u0428\78\2\2\u0428\u042d\7e\2\2\u0429\u042b\5"+
		"n8\2\u042a\u042c\7\u012d\2\2\u042b\u042a\3\2\2\2\u042b\u042c\3\2\2\2\u042c"+
		"\u042e\3\2\2\2\u042d\u0429\3\2\2\2\u042e\u042f\3\2\2\2\u042f\u042d\3\2"+
		"\2\2\u042f\u0430\3\2\2\2\u0430\u0432\3\2\2\2\u0431\u041b\3\2\2\2\u0431"+
		"\u0425\3\2\2\2\u0432\u0433\3\2\2\2\u0433\u0434\5\32\16\2\u0434\u0553\3"+
		"\2\2\2\u0435\u044f\7\61\2\2\u0436\u043b\t\5\2\2\u0437\u0439\5n8\2\u0438"+
		"\u043a\7\u012d\2\2\u0439\u0438\3\2\2\2\u0439\u043a\3\2\2\2\u043a\u043c"+
		"\3\2\2\2\u043b\u0437\3\2\2\2\u043c\u043d\3\2\2\2\u043d\u043b\3\2\2\2\u043d"+
		"\u043e\3\2\2\2\u043e\u0440\3\2\2\2\u043f\u0436\3\2\2\2\u0440\u0441\3\2"+
		"\2\2\u0441\u043f\3\2\2\2\u0441\u0442\3\2\2\2\u0442\u0450\3\2\2\2\u0443"+
		"\u0445\7\6\2\2\u0444\u0446\7X\2\2\u0445\u0444\3\2\2\2\u0445\u0446\3\2"+
		"\2\2\u0446\u044b\3\2\2\2\u0447\u0449\5n8\2\u0448\u044a\7\u012d\2\2\u0449"+
		"\u0448\3\2\2\2\u0449\u044a\3\2\2\2\u044a\u044c\3\2\2\2\u044b\u0447\3\2"+
		"\2\2\u044c\u044d\3\2\2\2\u044d\u044b\3\2\2\2\u044d\u044e\3\2\2\2\u044e"+
		"\u0450\3\2\2\2\u044f\u043f\3\2\2\2\u044f\u0443\3\2\2\2\u0450\u0451\3\2"+
		"\2\2\u0451\u0459\7O\2\2\u0452\u0454\7n\2\2\u0453\u0452\3\2\2\2\u0453\u0454"+
		"\3\2\2\2\u0454\u0455\3\2\2\2\u0455\u0457\5\u016a\u00b6\2\u0456\u0458\7"+
		"\u012d\2\2\u0457\u0456\3\2\2\2\u0457\u0458\3\2\2\2\u0458\u045a\3\2\2\2"+
		"\u0459\u0453\3\2\2\2\u045a\u045b\3\2\2\2\u045b\u0459\3\2\2\2\u045b\u045c"+
		"\3\2\2\2\u045c\u045d\3\2\2\2\u045d\u045e\5\32\16\2\u045e\u0553\3\2\2\2"+
		"\u045f\u046c\7\61\2\2\u0460\u0462\t\6\2\2\u0461\u0463\7\u012d\2\2\u0462"+
		"\u0461\3\2\2\2\u0462\u0463\3\2\2\2\u0463\u0465\3\2\2\2\u0464\u0460\3\2"+
		"\2\2\u0465\u0466\3\2\2\2\u0466\u0464\3\2\2\2\u0466\u0467\3\2\2\2\u0467"+
		"\u046d\3\2\2\2\u0468\u046a\7\6\2\2\u0469\u046b\7X\2\2\u046a\u0469\3\2"+
		"\2\2\u046a\u046b\3\2\2\2\u046b\u046d\3\2\2\2\u046c\u0464\3\2\2\2\u046c"+
		"\u0468\3\2\2\2\u046d\u046e\3\2\2\2\u046e\u0484\7O\2\2\u046f\u0470\7f\2"+
		"\2\u0470\u0472\5n8\2\u0471\u0473\7\u012d\2\2\u0472\u0471\3\2\2\2\u0472"+
		"\u0473\3\2\2\2\u0473\u0475\3\2\2\2\u0474\u046f\3\2\2\2\u0475\u0476\3\2"+
		"\2\2\u0476\u0474\3\2\2\2\u0476\u0477\3\2\2\2\u0477\u0485\3\2\2\2\u0478"+
		"\u0479\7\6\2\2\u0479\u047a\7g\2\2\u047a\u047b\78\2\2\u047b\u0480\7e\2"+
		"\2\u047c\u047e\5n8\2\u047d\u047f\7\u012d\2\2\u047e\u047d\3\2\2\2\u047e"+
		"\u047f\3\2\2\2\u047f\u0481\3\2\2\2\u0480\u047c\3\2\2\2\u0481\u0482\3\2"+
		"\2\2\u0482\u0480\3\2\2\2\u0482\u0483\3\2\2\2\u0483\u0485\3\2\2\2\u0484"+
		"\u0474\3\2\2\2\u0484\u0478\3\2\2\2\u0485\u0486\3\2\2\2\u0486\u0487\5\32"+
		"\16\2\u0487\u0553\3\2\2\2\u0488\u0495\7\61\2\2\u0489\u048b\t\7\2\2\u048a"+
		"\u048c\7\u012d\2\2\u048b\u048a\3\2\2\2\u048b\u048c\3\2\2\2\u048c\u048e"+
		"\3\2\2\2\u048d\u0489\3\2\2\2\u048e\u048f\3\2\2\2\u048f\u048d\3\2\2\2\u048f"+
		"\u0490\3\2\2\2\u0490\u0496\3\2\2\2\u0491\u0493\7\6\2\2\u0492\u0494\7X"+
		"\2\2\u0493\u0492\3\2\2\2\u0493\u0494\3\2\2\2\u0494\u0496\3\2\2\2\u0495"+
		"\u048d\3\2\2\2\u0495\u0491\3\2\2\2\u0496\u0497\3\2\2\2\u0497\u0498\7O"+
		"\2\2\u0498\u049d\7\30\2\2\u0499\u049b\5n8\2\u049a\u049c\7\u012d\2\2\u049b"+
		"\u049a\3\2\2\2\u049b\u049c\3\2\2\2\u049c\u049e\3\2\2\2\u049d\u0499\3\2"+
		"\2\2\u049e\u049f\3\2\2\2\u049f\u049d\3\2\2\2\u049f\u04a0\3\2\2\2\u04a0"+
		"\u04a1\3\2\2\2\u04a1\u04a2\5\32\16\2\u04a2\u0553\3\2\2\2\u04a3\u04a9\7"+
		"\61\2\2\u04a4\u04aa\7z\2\2\u04a5\u04a7\7\6\2\2\u04a6\u04a8\7X\2\2\u04a7"+
		"\u04a6\3\2\2\2\u04a7\u04a8\3\2\2\2\u04a8\u04aa\3\2\2\2\u04a9\u04a4\3\2"+
		"\2\2\u04a9\u04a5\3\2\2\2\u04aa\u04ab\3\2\2\2\u04ab\u04ac\7O\2\2\u04ac"+
		"\u04ad\7+\2\2\u04ad\u04ae\7\u0098\2\2\u04ae\u04b3\7\u00fd\2\2\u04af\u04b1"+
		"\5n8\2\u04b0\u04b2\7\u012d\2\2\u04b1\u04b0\3\2\2\2\u04b1\u04b2\3\2\2\2"+
		"\u04b2\u04b4\3\2\2\2\u04b3\u04af\3\2\2\2\u04b4\u04b5\3\2\2\2\u04b5\u04b3"+
		"\3\2\2\2\u04b5\u04b6\3\2\2\2\u04b6\u04b7\3\2\2\2\u04b7\u04b8\5\32\16\2"+
		"\u04b8\u0553\3\2\2\2\u04b9\u04bf\7\61\2\2\u04ba\u04c0\7z\2\2\u04bb\u04bd"+
		"\7\6\2\2\u04bc\u04be\7X\2\2\u04bd\u04bc\3\2\2\2\u04bd\u04be\3\2\2\2\u04be"+
		"\u04c0\3\2\2\2\u04bf\u04ba\3\2\2\2\u04bf\u04bb\3\2\2\2\u04c0\u04c1\3\2"+
		"\2\2\u04c1\u04c2\7O\2\2\u04c2\u04c3\7+\2\2\u04c3\u04c8\7\u00df\2\2\u04c4"+
		"\u04c6\5n8\2\u04c5\u04c7\7\u012d\2\2\u04c6\u04c5\3\2\2\2\u04c6\u04c7\3"+
		"\2\2\2\u04c7\u04c9\3\2\2\2\u04c8\u04c4\3\2\2\2\u04c9\u04ca\3\2\2\2\u04ca"+
		"\u04c8\3\2\2\2\u04ca\u04cb\3\2\2\2\u04cb\u04cc\3\2\2\2\u04cc\u04cd\5\32"+
		"\16\2\u04cd\u0553\3\2\2\2\u04ce\u04d4\7\61\2\2\u04cf\u04d5\7\'\2\2\u04d0"+
		"\u04d2\7\6\2\2\u04d1\u04d3\7X\2\2\u04d2\u04d1\3\2\2\2\u04d2\u04d3\3\2"+
		"\2\2\u04d3\u04d5\3\2\2\2\u04d4\u04cf\3\2\2\2\u04d4\u04d0\3\2\2\2\u04d5"+
		"\u04d6\3\2\2\2\u04d6\u04d9\7O\2\2\u04d7\u04da\5&\24\2\u04d8\u04da\5(\25"+
		"\2\u04d9\u04d7\3\2\2\2\u04d9\u04d8\3\2\2\2\u04da\u04db\3\2\2\2\u04db\u04dc"+
		"\5\32\16\2\u04dc\u0553\3\2\2\2\u04dd\u04e3\7\61\2\2\u04de\u04e4\7z\2\2"+
		"\u04df\u04e1\7\6\2\2\u04e0\u04e2\7X\2\2\u04e1\u04e0\3\2\2\2\u04e1\u04e2"+
		"\3\2\2\2\u04e2\u04e4\3\2\2\2\u04e3\u04de\3\2\2\2\u04e3\u04df\3\2\2\2\u04e4"+
		"\u04e5\3\2\2\2\u04e5\u04e6\7O\2\2\u04e6\u04eb\7\u00b8\2\2\u04e7\u04e9"+
		"\5n8\2\u04e8\u04ea\7\u012d\2\2\u04e9\u04e8\3\2\2\2\u04e9\u04ea\3\2\2\2"+
		"\u04ea\u04ec\3\2\2\2\u04eb\u04e7\3\2\2\2\u04ec\u04ed\3\2\2\2\u04ed\u04eb"+
		"\3\2\2\2\u04ed\u04ee\3\2\2\2\u04ee\u04ef\3\2\2\2\u04ef\u04f0\5\32\16\2"+
		"\u04f0\u0553\3\2\2\2\u04f1\u04fe\7\61\2\2\u04f2\u04f4\t\n\2\2\u04f3\u04f5"+
		"\7\u012d\2\2\u04f4\u04f3\3\2\2\2\u04f4\u04f5\3\2\2\2\u04f5\u04f7\3\2\2"+
		"\2\u04f6\u04f2\3\2\2\2\u04f7\u04f8\3\2\2\2\u04f8\u04f6\3\2\2\2\u04f8\u04f9"+
		"\3\2\2\2\u04f9\u04ff\3\2\2\2\u04fa\u04fc\7\6\2\2\u04fb\u04fd\7X\2\2\u04fc"+
		"\u04fb\3\2\2\2\u04fc\u04fd\3\2\2\2\u04fd\u04ff\3\2\2\2\u04fe\u04f6\3\2"+
		"\2\2\u04fe\u04fa\3\2\2\2\u04ff\u0500\3\2\2\2\u0500\u0501\7O\2\2\u0501"+
		"\u0502\7\u00b9\2\2\u0502\u0507\7\u00cc\2\2\u0503\u0505\5n8\2\u0504\u0506"+
		"\7\u012d\2\2\u0505\u0504\3\2\2\2\u0505\u0506\3\2\2\2\u0506\u0508\3\2\2"+
		"\2\u0507\u0503\3\2\2\2\u0508\u0509\3\2\2\2\u0509\u0507\3\2\2\2\u0509\u050a"+
		"\3\2\2\2\u050a\u050b\3\2\2\2\u050b\u050c\5\32\16\2\u050c\u0553\3\2\2\2"+
		"\u050d\u051a\7\61\2\2\u050e\u0510\t\b\2\2\u050f\u0511\7\u012d\2\2\u0510"+
		"\u050f\3\2\2\2\u0510\u0511\3\2\2\2\u0511\u0513\3\2\2\2\u0512\u050e\3\2"+
		"\2\2\u0513\u0514\3\2\2\2\u0514\u0512\3\2\2\2\u0514\u0515\3\2\2\2\u0515"+
		"\u051b\3\2\2\2\u0516\u0518\7\6\2\2\u0517\u0519\7X\2\2\u0518\u0517\3\2"+
		"\2\2\u0518\u0519\3\2\2\2\u0519\u051b\3\2\2\2\u051a\u0512\3\2\2\2\u051a"+
		"\u0516\3\2\2\2\u051b\u051c\3\2\2\2\u051c\u051d\7O\2\2\u051d\u0522\7e\2"+
		"\2\u051e\u0520\5n8\2\u051f\u0521\7\u012d\2\2\u0520\u051f\3\2\2\2\u0520"+
		"\u0521\3\2\2\2\u0521\u0523\3\2\2\2\u0522\u051e\3\2\2\2\u0523\u0524\3\2"+
		"\2\2\u0524\u0522\3\2\2\2\u0524\u0525\3\2\2\2\u0525\u0526\3\2\2\2\u0526"+
		"\u0527\5\32\16\2\u0527\u0553\3\2\2\2\u0528\u052e\7\61\2\2\u0529\u052f"+
		"\7\26\2\2\u052a\u052c\7\6\2\2\u052b\u052d\7X\2\2\u052c\u052b\3\2\2\2\u052c"+
		"\u052d\3\2\2\2\u052d\u052f\3\2\2\2\u052e\u0529\3\2\2\2\u052e\u052a\3\2"+
		"\2\2\u052f\u0530\3\2\2\2\u0530\u0531\7O\2\2\u0531\u0536\7\u00ea\2\2\u0532"+
		"\u0534\5n8\2\u0533\u0535\7\u012d\2\2\u0534\u0533\3\2\2\2\u0534\u0535\3"+
		"\2\2\2\u0535\u0537\3\2\2\2\u0536\u0532\3\2\2\2\u0537\u0538\3\2\2\2\u0538"+
		"\u0536\3\2\2\2\u0538\u0539\3\2\2\2\u0539\u053a\3\2\2\2\u053a\u053b\5\32"+
		"\16\2\u053b\u0540\7\61\2\2\u053c\u053e\5n8\2\u053d\u053f\7\u012d\2\2\u053e"+
		"\u053d\3\2\2\2\u053e\u053f\3\2\2\2\u053f\u0541\3\2\2\2\u0540\u053c\3\2"+
		"\2\2\u0541\u0542\3\2\2\2\u0542\u0540\3\2\2\2\u0542\u0543\3\2\2\2\u0543"+
		"\u0544\3\2\2\2\u0544\u0549\7\u00f2\2\2\u0545\u0547\5n8\2\u0546\u0548\7"+
		"\u012d\2\2\u0547\u0546\3\2\2\2\u0547\u0548\3\2\2\2\u0548\u054a\3\2\2\2"+
		"\u0549\u0545\3\2\2\2\u054a\u054b\3\2\2\2\u054b\u0549\3\2\2\2\u054b\u054c"+
		"\3\2\2\2\u054c\u0550\3\2\2\2\u054d\u054e\7\u0080\2\2\u054e\u054f\7\u0082"+
		"\2\2\u054f\u0551\7\u00cd\2\2\u0550\u054d\3\2\2\2\u0550\u0551\3\2\2\2\u0551"+
		"\u0553\3\2\2\2\u0552\u040d\3\2\2\2\u0552\u0435\3\2\2\2\u0552\u045f\3\2"+
		"\2\2\u0552\u0488\3\2\2\2\u0552\u04a3\3\2\2\2\u0552\u04b9\3\2\2\2\u0552"+
		"\u04ce\3\2\2\2\u0552\u04dd\3\2\2\2\u0552\u04f1\3\2\2\2\u0552\u050d\3\2"+
		"\2\2\u0552\u0528\3\2\2\2\u0553\31\3\2\2\2\u0554\u055f\7\u00f2\2\2\u0555"+
		"\u0557\7\62\2\2\u0556\u0555\3\2\2\2\u0556\u0557\3\2\2\2\u0557\u055a\3"+
		"\2\2\2\u0558\u055b\5n8\2\u0559\u055b\7\u00d5\2\2\u055a\u0558\3\2\2\2\u055a"+
		"\u0559\3\2\2\2\u055b\u055d\3\2\2\2\u055c\u055e\7\u012d\2\2\u055d\u055c"+
		"\3\2\2\2\u055d\u055e\3\2\2\2\u055e\u0560\3\2\2\2\u055f\u0556\3\2\2\2\u0560"+
		"\u0561\3\2\2\2\u0561\u055f\3\2\2\2\u0561\u0562\3\2\2\2\u0562\u0566\3\2"+
		"\2\2\u0563\u0564\7\u0080\2\2\u0564\u0565\7\61\2\2\u0565\u0567\7\u00cd"+
		"\2\2\u0566\u0563\3\2\2\2\u0566\u0567\3\2\2\2\u0567\33\3\2\2\2\u0568\u0569"+
		"\7\u008f\2\2\u0569\u05e1\7O\2\2\u056a\u056b\7\3\2\2\u056b\u056c\5\u016a"+
		"\u00b6\2\u056c\u0573\7\u0134\2\2\u056d\u056f\5\u0080A\2\u056e\u0570\7"+
		"\u012d\2\2\u056f\u056e\3\2\2\2\u056f\u0570\3\2\2\2\u0570\u0572\3\2\2\2"+
		"\u0571\u056d\3\2\2\2\u0572\u0575\3\2\2\2\u0573\u0571\3\2\2\2\u0573\u0574"+
		"\3\2\2\2\u0574\u0576\3\2\2\2\u0575\u0573\3\2\2\2\u0576\u0577\7\u0135\2"+
		"\2\u0577\u05e2\3\2\2\2\u0578\u0579\7\17\2\2\u0579\u057a\7\u0134\2\2\u057a"+
		"\u057b\5\u0080A\2\u057b\u057c\7\5\2\2\u057c\u057d\5\u0080A\2\u057d\u057e"+
		"\7\u0135\2\2\u057e\u05e2\3\2\2\2\u057f\u0580\7\21\2\2\u0580\u05e2\5\u016a"+
		"\u00b6\2\u0581\u0582\7\u008e\2\2\u0582\u05e2\5\u016a\u00b6\2\u0583\u0584"+
		"\7\23\2\2\u0584\u0585\5\u016a\u00b6\2\u0585\u0586\7O\2\2\u0586\u0587\5"+
		"\u016a\u00b6\2\u0587\u05e2\3\2\2\2\u0588\u0589\7\25\2\2\u0589\u05e2\5"+
		"\u016a\u00b6\2\u058a\u058b\7\30\2\2\u058b\u05e2\5\u016a\u00b6\2\u058c"+
		"\u058d\7 \2\2\u058d\u05e2\5\u016a\u00b6\2\u058e\u058f\7(\2\2\u058f\u05e2"+
		"\5\u016a\u00b6\2\u0590\u0591\7+\2\2\u0591\u0592\7\u0098\2\2\u0592\u0593"+
		"\7\u00fd\2\2\u0593\u05e2\5\u016a\u00b6\2\u0594\u0595\7+\2\2\u0595\u0596"+
		"\7n\2\2\u0596\u05e2\5\u016a\u00b6\2\u0597\u0598\7-\2\2\u0598\u05e2\5\u01b2"+
		"\u00da\2\u0599\u059a\7\u00ae\2\2\u059a\u05e2\5\u016a\u00b6\2\u059b\u059c"+
		"\7\u00b9\2\2\u059c\u059d\7\u00cc\2\2\u059d\u05e2\5n8\2\u059e\u059f\7R"+
		"\2\2\u059f\u05a0\5\u016a\u00b6\2\u05a0\u05a1\7\u0134\2\2\u05a1\u05a2\5"+
		"\u0080A\2\u05a2\u05a3\7\u012d\2\2\u05a3\u05a4\5\u0080A\2\u05a4\u05a5\7"+
		"\u0135\2\2\u05a5\u05e2\3\2\2\2\u05a6\u05a7\7R\2\2\u05a7\u05a8\7\u0088"+
		"\2\2\u05a8\u05a9\5\u016a\u00b6\2\u05a9\u05aa\7{\2\2\u05aa\u05ab\5n8\2"+
		"\u05ab\u05e2\3\2\2\2\u05ac\u05ad\7R\2\2\u05ad\u05ae\7\u00a6\2\2\u05ae"+
		"\u05af\5\u016a\u00b6\2\u05af\u05b0\7{\2\2\u05b0\u05b1\5n8\2\u05b1\u05e2"+
		"\3\2\2\2\u05b2\u05b4\7Z\2\2\u05b3\u05b2\3\2\2\2\u05b3\u05b4\3\2\2\2\u05b4"+
		"\u05b5\3\2\2\2\u05b5\u05b6\7\u00b8\2\2\u05b6\u05e2\5\u016a\u00b6\2\u05b7"+
		"\u05b8\7[\2\2\u05b8\u05e2\5\u016a\u00b6\2\u05b9\u05ba\7d\2\2\u05ba\u05bb"+
		"\5\u016a\u00b6\2\u05bb\u05bc\7O\2\2\u05bc\u05bd\5\u016a\u00b6\2\u05bd"+
		"\u05e2\3\2\2\2\u05be\u05bf\7e\2\2\u05bf\u05e2\5\u016a\u00b6\2\u05c0\u05c1"+
		"\7f\2\2\u05c1\u05e2\5\u016a\u00b6\2\u05c2\u05c3\7\u00df\2\2\u05c3\u05e2"+
		"\5\u016a\u00b6\2\u05c4\u05c5\7n\2\2\u05c5\u05e2\5\u016a\u00b6\2\u05c6"+
		"\u05c7\7\u00ea\2\2\u05c7\u05e2\5\u016a\u00b6\2\u05c8\u05c9\7\u011e\2\2"+
		"\u05c9\u05ca\7\u00dc\2\2\u05ca\u05cb\7\u0092\2\2\u05cb\u05e2\5\u016a\u00b6"+
		"\2\u05cc\u05cd\7\u011e\2\2\u05cd\u05ce\7\u00dc\2\2\u05ce\u05cf\7\u009d"+
		"\2\2\u05cf\u05e2\5\u016a\u00b6\2\u05d0\u05d1\7\u011e\2\2\u05d1\u05d2\7"+
		"\u00dc\2\2\u05d2\u05d3\7\u00d0\2\2\u05d3\u05e2\5\u016a\u00b6\2\u05d4\u05d5"+
		"\7\u011e\2\2\u05d5\u05d6\7\u00dc\2\2\u05d6\u05d7\7\u00ec\2\2\u05d7\u05e2"+
		"\5\u016a\u00b6\2\u05d8\u05d9\7s\2\2\u05d9\u05da\5\u016a\u00b6\2\u05da"+
		"\u05db\7O\2\2\u05db\u05dc\5\u016a\u00b6\2\u05dc\u05e2\3\2\2\2\u05dd\u05de"+
		"\7v\2\2\u05de\u05e2\5\u016a\u00b6\2\u05df\u05e0\7}\2\2\u05e0\u05e2\5\u016a"+
		"\u00b6\2\u05e1\u056a\3\2\2\2\u05e1\u0578\3\2\2\2\u05e1\u057f\3\2\2\2\u05e1"+
		"\u0581\3\2\2\2\u05e1\u0583\3\2\2\2\u05e1\u0588\3\2\2\2\u05e1\u058a\3\2"+
		"\2\2\u05e1\u058c\3\2\2\2\u05e1\u058e\3\2\2\2\u05e1\u0590\3\2\2\2\u05e1"+
		"\u0594\3\2\2\2\u05e1\u0597\3\2\2\2\u05e1\u0599\3\2\2\2\u05e1\u059b\3\2"+
		"\2\2\u05e1\u059e\3\2\2\2\u05e1\u05a6\3\2\2\2\u05e1\u05ac\3\2\2\2\u05e1"+
		"\u05b3\3\2\2\2\u05e1\u05b7\3\2\2\2\u05e1\u05b9\3\2\2\2\u05e1\u05be\3\2"+
		"\2\2\u05e1\u05c0\3\2\2\2\u05e1\u05c2\3\2\2\2\u05e1\u05c4\3\2\2\2\u05e1"+
		"\u05c6\3\2\2\2\u05e1\u05c8\3\2\2\2\u05e1\u05cc\3\2\2\2\u05e1\u05d0\3\2"+
		"\2\2\u05e1\u05d4\3\2\2\2\u05e1\u05d8\3\2\2\2\u05e1\u05dd\3\2\2\2\u05e1"+
		"\u05df\3\2\2\2\u05e2\u05e3\3\2\2\2\u05e3\u05e4\7B\2\2\u05e4\u05e5\7\u0147"+
		"\2\2\u05e5\35\3\2\2\2\u05e6\u05e9\7\26\2\2\u05e7\u05e8\7S\2\2\u05e8\u05ea"+
		"\7_\2\2\u05e9\u05e7\3\2\2\2\u05e9\u05ea\3\2\2\2\u05ea\u05eb\3\2\2\2\u05eb"+
		"\u05ec\7-\2\2\u05ec\u05ed\5n8\2\u05ed\u0601\7\u0134\2\2\u05ee\u05f0\5"+
		"$\23\2\u05ef\u05ee\3\2\2\2\u05ef\u05f0\3\2\2\2\u05f0\u05f2\3\2\2\2\u05f1"+
		"\u05f3\5n8\2\u05f2\u05f1\3\2\2\2\u05f2\u05f3\3\2\2\2\u05f3\u05f4\3\2\2"+
		"\2\u05f4\u05ff\5\u0080A\2\u05f5\u05fc\7\31\2\2\u05f6\u05f7\7\u012a\2\2"+
		"\u05f7\u05f9\5\u01b2\u00da\2\u05f8\u05fa\7\u012d\2\2\u05f9\u05f8\3\2\2"+
		"\2\u05f9\u05fa\3\2\2\2\u05fa\u05fc\3\2\2\2\u05fb\u05f5\3\2\2\2\u05fb\u05f6"+
		"\3\2\2\2\u05fc\u05fd\3\2\2\2\u05fd\u05fb\3\2\2\2\u05fd\u05fe\3\2\2\2\u05fe"+
		"\u0600\3\2\2\2\u05ff\u05fb\3\2\2\2\u05ff\u0600\3\2\2\2\u0600\u0602\3\2"+
		"\2\2\u0601\u05ef\3\2\2\2\u0601\u0602\3\2\2\2\u0602\u0603\3\2\2\2\u0603"+
		"\u0614\7\u0135\2\2\u0604\u0605\7a\2\2\u0605\u0615\5\u0080A\2\u0606\u0607"+
		"\7a\2\2\u0607\u0608\7n\2\2\u0608\u060e\7\u0134\2\2\u0609\u060a\5n8\2\u060a"+
		"\u060c\5\u0080A\2\u060b\u060d\7\u012d\2\2\u060c\u060b\3\2\2\2\u060c\u060d"+
		"\3\2\2\2\u060d\u060f\3\2\2\2\u060e\u0609\3\2\2\2\u060f\u0610\3\2\2\2\u0610"+
		"\u060e\3\2\2\2\u0610\u0611\3\2\2\2\u0611\u0612\3\2\2\2\u0612\u0613\7\u0135"+
		"\2\2\u0613\u0615\3\2\2\2\u0614\u0604\3\2\2\2\u0614\u0606\3\2\2\2\u0614"+
		"\u0615\3\2\2\2\u0615\u0644\3\2\2\2\u0616\u0617\7\u00b8\2\2\u0617\u0645"+
		"\5n8\2\u0618\u0645\7\u00fc\2\2\u0619\u0645\7\67\2\2\u061a\u0645\7\u00e3"+
		"\2\2\u061b\u0645\7\u00fa\2\2\u061c\u061d\7\u0087\2\2\u061d\u061e\7O\2"+
		"\2\u061e\u061f\7L\2\2\u061f\u0645\7\u00b1\2\2\u0620\u0621\7a\2\2\u0621"+
		"\u0622\7L\2\2\u0622\u0623\7O\2\2\u0623\u0624\7L\2\2\u0624\u0645\7\u00b1"+
		"\2\2\u0625\u0645\7l\2\2\u0626\u0628\7\u00a4\2\2\u0627\u0626\3\2\2\2\u0627"+
		"\u0628\3\2\2\2\u0628\u0629\3\2\2\2\u0629\u062a\7\u00de\2\2\u062a\u0645"+
		"\7A\2\2\u062b\u062d\7\u00a4\2\2\u062c\u062b\3\2\2\2\u062c\u062d\3\2\2"+
		"\2\u062d\u062e\3\2\2\2\u062e\u062f\7\u00de\2\2\u062f\u0645\7\u009c\2\2"+
		"\u0630\u0631\7\u0093\2\2\u0631\u0645\7\u0142\2\2\u0632\u0633\7]\2\2\u0633"+
		"\u0645\7\u0142\2\2\u0634\u0635\7\u00e0\2\2\u0635\u063c\5n8\2\u0636\u0637"+
		"\7\u00f2\2\2\u0637\u063d\7\u0147\2\2\u0638\u0639\7\u012a\2\2\u0639\u063d"+
		"\7\u0147\2\2\u063a\u063b\7/\2\2\u063b\u063d\7\u0096\2\2\u063c\u0636\3"+
		"\2\2\2\u063c\u0638\3\2\2\2\u063c\u063a\3\2\2\2\u063d\u0645\3\2\2\2\u063e"+
		"\u063f\7\5\2\2\u063f\u0645\5 \21\2\u0640\u0641\7\5\2\2\u0641\u0642\7\u0147"+
		"\2\2\u0642\u0643\7\u012d\2\2\u0643\u0645\7\u0147\2\2\u0644\u0616\3\2\2"+
		"\2\u0644\u0618\3\2\2\2\u0644\u0619\3\2\2\2\u0644\u061a\3\2\2\2\u0644\u061b"+
		"\3\2\2\2\u0644\u061c\3\2\2\2\u0644\u0620\3\2\2\2\u0644\u0625\3\2\2\2\u0644"+
		"\u0627\3\2\2\2\u0644\u062c\3\2\2\2\u0644\u0630\3\2\2\2\u0644\u0632\3\2"+
		"\2\2\u0644\u0634\3\2\2\2\u0644\u063e\3\2\2\2\u0644\u0640\3\2\2\2\u0645"+
		"\u0646\3\2\2\2\u0646\u0644\3\2\2\2\u0646\u0647\3\2\2\2\u0647\u0654\3\2"+
		"\2\2\u0648\u0649\7\u0080\2\2\u0649\u064e\7\u0134\2\2\u064a\u064c\5\"\22"+
		"\2\u064b\u064d\7\u012d\2\2\u064c\u064b\3\2\2\2\u064c\u064d\3\2\2\2\u064d"+
		"\u064f\3\2\2\2\u064e\u064a\3\2\2\2\u064f\u0650\3\2\2\2\u0650\u064e\3\2"+
		"\2\2\u0650\u0651\3\2\2\2\u0651\u0652\3\2\2\2\u0652\u0653\7\u0135\2\2\u0653"+
		"\u0655\3\2\2\2\u0654\u0648\3\2\2\2\u0654\u0655\3\2\2\2\u0655\37\3\2\2"+
		"\2\u0656\u065a\7\u0141\2\2\u0657\u0659\n\13\2\2\u0658\u0657\3\2\2\2\u0659"+
		"\u065c\3\2\2\2\u065a\u0658\3\2\2\2\u065a\u065b\3\2\2\2\u065b\u065d\3\2"+
		"\2\2\u065c\u065a\3\2\2\2\u065d\u065e\7\u0141\2\2\u065e!\3\2\2\2\u065f"+
		"\u0660\t\f\2\2\u0660#\3\2\2\2\u0661\u0662\t\r\2\2\u0662%\3\2\2\2\u0663"+
		"\u0664\7-\2\2\u0664\u0665\5n8\2\u0665\u0672\7\u0134\2\2\u0666\u0668\5"+
		"$\23\2\u0667\u0666\3\2\2\2\u0667\u0668\3\2\2\2\u0668\u066a\3\2\2\2\u0669"+
		"\u066b\5n8\2\u066a\u0669\3\2\2\2\u066a\u066b\3\2\2\2\u066b\u066c\3\2\2"+
		"\2\u066c\u066e\5\u0080A\2\u066d\u066f\7\u012d\2\2\u066e\u066d\3\2\2\2"+
		"\u066e\u066f\3\2\2\2\u066f\u0671\3\2\2\2\u0670\u0667\3\2\2\2\u0671\u0674"+
		"\3\2\2\2\u0672\u0670\3\2\2\2\u0672\u0673\3\2\2\2\u0673\u0675\3\2\2\2\u0674"+
		"\u0672\3\2\2\2\u0675\u0676\7\u0135\2\2\u0676\'\3\2\2\2\u0677\u0678\7\6"+
		"\2\2\u0678\u0679\7.\2\2\u0679\u067a\78\2\2\u067a\u067f\7e\2\2\u067b\u067d"+
		"\5n8\2\u067c\u067e\7\u012d\2\2\u067d\u067c\3\2\2\2\u067d\u067e\3\2\2\2"+
		"\u067e\u0680\3\2\2\2\u067f\u067b\3\2\2\2\u0680\u0681\3\2\2\2\u0681\u067f"+
		"\3\2\2\2\u0681\u0682\3\2\2\2\u0682)\3\2\2\2\u0683\u0685\7\26\2\2\u0684"+
		"\u0686\t\16\2\2\u0685\u0684\3\2\2\2\u0685\u0686\3\2\2\2\u0686\u0687\3"+
		"\2\2\2\u0687\u0688\7f\2\2\u0688\u068e\5\u016a\u00b6\2\u0689\u068b\7\u00b0"+
		"\2\2\u068a\u068c\7\u0085\2\2\u068b\u068a\3\2\2\2\u068b\u068c\3\2\2\2\u068c"+
		"\u068d\3\2\2\2\u068d\u068f\7\u0142\2\2\u068e\u0689\3\2\2\2\u068e\u068f"+
		"\3\2\2\2\u068f\u0694\3\2\2\2\u0690\u0691\7\u00c5\2\2\u0691\u0695\7\u0142"+
		"\2\2\u0692\u0693\7\u00c9\2\2\u0693\u0695\7\u00c5\2\2\u0694\u0690\3\2\2"+
		"\2\u0694\u0692\3\2\2\2\u0694\u0695\3\2\2\2\u0695\u069a\3\2\2\2\u0696\u0697"+
		"\7\u00c0\2\2\u0697\u069b\5\u0090I\2\u0698\u0699\7\u00c9\2\2\u0699\u069b"+
		"\7\u00c0\2\2\u069a\u0696\3\2\2\2\u069a\u0698\3\2\2\2\u069a\u069b\3\2\2"+
		"\2\u069b\u06a1\3\2\2\2\u069c\u069e\7\u00e4\2\2\u069d\u069f\7\u0080\2\2"+
		"\u069e\u069d\3\2\2\2\u069e\u069f\3\2\2\2\u069f\u06a0\3\2\2\2\u06a0\u06a2"+
		"\7\u0142\2\2\u06a1\u069c\3\2\2\2\u06a1\u06a2\3\2\2\2\u06a2\u06a5\3\2\2"+
		"\2\u06a3\u06a4\7\u0086\2\2\u06a4\u06a6\7\u0142\2\2\u06a5\u06a3\3\2\2\2"+
		"\u06a5\u06a6\3\2\2\2\u06a6\u06ab\3\2\2\2\u06a7\u06a9\7\u00c9\2\2\u06a8"+
		"\u06a7\3\2\2\2\u06a8\u06a9\3\2\2\2\u06a9\u06aa\3\2\2\2\u06aa\u06ac\7\u0097"+
		"\2\2\u06ab\u06a8\3\2\2\2\u06ab\u06ac\3\2\2\2\u06ac\u06b3\3\2\2\2\u06ad"+
		"\u06ae\7U\2\2\u06ae\u06b1\7\u0085\2\2\u06af\u06b2\5\u016a\u00b6\2\u06b0"+
		"\u06b2\7\u00ca\2\2\u06b1\u06af\3\2\2\2\u06b1\u06b0\3\2\2\2\u06b2\u06b4"+
		"\3\2\2\2\u06b3\u06ad\3\2\2\2\u06b3\u06b4\3\2\2\2\u06b4+\3\2\2\2\u06b5"+
		"\u06b6\7\26\2\2\u06b6\u06b7\7\u00a4\2\2\u06b7\u06b8\7n\2\2\u06b8\u06b9"+
		"\5\u016a\u00b6\2\u06b9\u06ba\5B\"\2\u06ba\u06bb\7{\2\2\u06bb\u06bd\5n"+
		"8\2\u06bc\u06be\5H%\2\u06bd\u06bc\3\2\2\2\u06bd\u06be\3\2\2\2\u06be\u06c0"+
		"\3\2\2\2\u06bf\u06c1\5R*\2\u06c0\u06bf\3\2\2\2\u06c0\u06c1\3\2\2\2\u06c1"+
		"\u06c2\3\2\2\2\u06c2\u06c3\7\u00bd\2\2\u06c3\u06c4\7\u0147\2\2\u06c4\u0758"+
		"\3\2\2\2\u06c5\u06c6\7\26\2\2\u06c6\u06c7\7n\2\2\u06c7\u06c8\5\u016a\u00b6"+
		"\2\u06c8\u06cb\5B\"\2\u06c9\u06ca\7{\2\2\u06ca\u06cc\5n8\2\u06cb\u06c9"+
		"\3\2\2\2\u06cb\u06cc\3\2\2\2\u06cc\u06ce\3\2\2\2\u06cd\u06cf\5H%\2\u06ce"+
		"\u06cd\3\2\2\2\u06ce\u06cf\3\2\2\2\u06cf\u06d1\3\2\2\2\u06d0\u06d2\5R"+
		"*\2\u06d1\u06d0\3\2\2\2\u06d1\u06d2\3\2\2\2\u06d2\u06d5\3\2\2\2\u06d3"+
		"\u06d4\7\5\2\2\u06d4\u06d6\5\u0156\u00ac\2\u06d5\u06d3\3\2\2\2\u06d5\u06d6"+
		"\3\2\2\2\u06d6\u0758\3\2\2\2\u06d7\u06d8\7\26\2\2\u06d8\u06d9\7n\2\2\u06d9"+
		"\u06dc\5\u016a\u00b6\2\u06da\u06db\7{\2\2\u06db\u06dd\5n8\2\u06dc\u06da"+
		"\3\2\2\2\u06dc\u06dd\3\2\2\2\u06dd\u06df\3\2\2\2\u06de\u06e0\5H%\2\u06df"+
		"\u06de\3\2\2\2\u06df\u06e0\3\2\2\2\u06e0\u06e2\3\2\2\2\u06e1\u06e3\5R"+
		"*\2\u06e2\u06e1\3\2\2\2\u06e2\u06e3\3\2\2\2\u06e3\u06e4\3\2\2\2\u06e4"+
		"\u06e5\7\5\2\2\u06e5\u06e6\5\u0156\u00ac\2\u06e6\u0758\3\2\2\2\u06e7\u06ed"+
		"\7\26\2\2\u06e8\u06ea\t\17\2\2\u06e9\u06e8\3\2\2\2\u06e9\u06ea\3\2\2\2"+
		"\u06ea\u06eb\3\2\2\2\u06eb\u06ee\t\16\2\2\u06ec\u06ee\7\u00f4\2\2\u06ed"+
		"\u06e9\3\2\2\2\u06ed\u06ec\3\2\2\2\u06ed\u06ee\3\2\2\2\u06ee\u06ef\3\2"+
		"\2\2\u06ef\u06f3\7n\2\2\u06f0\u06f1\7\64\2\2\u06f1\u06f2\7K\2\2\u06f2"+
		"\u06f4\7\u00a3\2\2\u06f3\u06f0\3\2\2\2\u06f3\u06f4\3\2\2\2\u06f4\u06f5"+
		"\3\2\2\2\u06f5\u06f6\5\u016a\u00b6\2\u06f6\u0715\7\u0134\2\2\u06f7\u06f8"+
		"\5n8\2\u06f8\u06fb\5\u0080A\2\u06f9\u06fa\7\20\2\2\u06fa\u06fc\5n8\2\u06fb"+
		"\u06f9\3\2\2\2\u06fb\u06fc\3\2\2\2\u06fc\u0700\3\2\2\2\u06fd\u06ff\5\62"+
		"\32\2\u06fe\u06fd\3\2\2\2\u06ff\u0702\3\2\2\2\u0700\u06fe\3\2\2\2\u0700"+
		"\u0701\3\2\2\2\u0701\u070d\3\2\2\2\u0702\u0700\3\2\2\2\u0703\u070d\5\60"+
		"\31\2\u0704\u0705\7G\2\2\u0705\u0709\5n8\2\u0706\u0708\5.\30\2\u0707\u0706"+
		"\3\2\2\2\u0708\u070b\3\2\2\2\u0709\u0707\3\2\2\2\u0709\u070a\3\2\2\2\u070a"+
		"\u070d\3\2\2\2\u070b\u0709\3\2\2\2\u070c\u06f7\3\2\2\2\u070c\u0703\3\2"+
		"\2\2\u070c\u0704\3\2\2\2\u070d\u070f\3\2\2\2\u070e\u0710\7\u012d\2\2\u070f"+
		"\u070e\3\2\2\2\u070f\u0710\3\2\2\2\u0710\u0712\3\2\2\2\u0711\u070c\3\2"+
		"\2\2\u0712\u0713\3\2\2\2\u0713\u0711\3\2\2\2\u0713\u0714\3\2\2\2\u0714"+
		"\u0716\3\2\2\2\u0715\u0711\3\2\2\2\u0715\u0716\3\2\2\2\u0716\u0717\3\2"+
		"\2\2\u0717\u0724\7\u0135\2\2\u0718\u0719\7:\2\2\u0719\u071e\7\u0134\2"+
		"\2\u071a\u071c\5n8\2\u071b\u071d\7\u012d\2\2\u071c\u071b\3\2\2\2\u071c"+
		"\u071d\3\2\2\2\u071d\u071f\3\2\2\2\u071e\u071a\3\2\2\2\u071f\u0720\3\2"+
		"\2\2\u0720\u071e\3\2\2\2\u0720\u0721\3\2\2\2\u0721\u0722\3\2\2\2\u0722"+
		"\u0723\7\u0135\2\2\u0723\u0725\3\2\2\2\u0724\u0718\3\2\2\2\u0724\u0725"+
		"\3\2\2\2\u0725\u0726\3\2\2\2\u0726\u0727\58\35\2\u0727\u0728\5:\36\2\u0728"+
		"\u0729\5<\37\2\u0729\u0758\3\2\2\2\u072a\u0730\7\26\2\2\u072b\u072d\t"+
		"\17\2\2\u072c\u072b\3\2\2\2\u072c\u072d\3\2\2\2\u072d\u072e\3\2\2\2\u072e"+
		"\u0731\t\16\2\2\u072f\u0731\7\u00f4\2\2\u0730\u072c\3\2\2\2\u0730\u072f"+
		"\3\2\2\2\u0730\u0731\3\2\2\2\u0731\u0732\3\2\2\2\u0732\u0736\7n\2\2\u0733"+
		"\u0734\7\64\2\2\u0734\u0735\7K\2\2\u0735\u0737\7\u00a3\2\2\u0736\u0733"+
		"\3\2\2\2\u0736\u0737\3\2\2\2\u0737\u0738\3\2\2\2\u0738\u0739\5\u016a\u00b6"+
		"\2\u0739\u073a\7M\2\2\u073a\u0751\5n8\2\u073b\u074b\7\u0134\2\2\u073c"+
		"\u073d\5n8\2\u073d\u073e\7\u0080\2\2\u073e\u0742\7\u00ce\2\2\u073f\u0741"+
		"\5\62\32\2\u0740\u073f\3\2\2\2\u0741\u0744\3\2\2\2\u0742\u0740\3\2\2\2"+
		"\u0742\u0743\3\2\2\2\u0743\u0747\3\2\2\2\u0744\u0742\3\2\2\2\u0745\u0747"+
		"\5\60\31\2\u0746\u073c\3\2\2\2\u0746\u0745\3\2\2\2\u0747\u0749\3\2\2\2"+
		"\u0748\u074a\7\u012d\2\2\u0749\u0748\3\2\2\2\u0749\u074a\3\2\2\2\u074a"+
		"\u074c\3\2\2\2\u074b\u0746\3\2\2\2\u074c\u074d\3\2\2\2\u074d\u074b\3\2"+
		"\2\2\u074d\u074e\3\2\2\2\u074e\u074f\3\2\2\2\u074f\u0750\7\u0135\2\2\u0750"+
		"\u0752\3\2\2\2\u0751\u073b\3\2\2\2\u0751\u0752\3\2\2\2\u0752\u0753\3\2"+
		"\2\2\u0753\u0754\58\35\2\u0754\u0755\5:\36\2\u0755\u0756\5<\37\2\u0756"+
		"\u0758\3\2\2\2\u0757\u06b5\3\2\2\2\u0757\u06c5\3\2\2\2\u0757\u06d7\3\2"+
		"\2\2\u0757\u06e7\3\2\2\2\u0757\u072a\3\2\2\2\u0758-\3\2\2\2\u0759\u075a"+
		"\t\20\2\2\u075a\u075b\t\21\2\2\u075b/\3\2\2\2\u075c\u075d\7\23\2\2\u075d"+
		"\u075f\5n8\2\u075e\u075c\3\2\2\2\u075e\u075f\3\2\2\2\u075f\u07c2\3\2\2"+
		"\2\u0760\u07c3\5\64\33\2\u0761\u0762\7x\2\2\u0762\u0767\7\u0134\2\2\u0763"+
		"\u0765\5n8\2\u0764\u0766\7\u012d\2\2\u0765\u0764\3\2\2\2\u0765\u0766\3"+
		"\2\2\2\u0766\u0768\3\2\2\2\u0767\u0763\3\2\2\2\u0768\u0769\3\2\2\2\u0769"+
		"\u0767\3\2\2\2\u0769\u076a\3\2\2\2\u076a\u076b\3\2\2\2\u076b\u076c\7\u0135"+
		"\2\2\u076c\u076d\5@!\2\u076d\u07c3\3\2\2\2\u076e\u076f\7W\2\2\u076f\u0770"+
		"\7D\2\2\u0770\u0775\7\u0134\2\2\u0771\u0773\5n8\2\u0772\u0774\7\u012d"+
		"\2\2\u0773\u0772\3\2\2\2\u0773\u0774\3\2\2\2\u0774\u0776\3\2\2\2\u0775"+
		"\u0771\3\2\2\2\u0776\u0777\3\2\2\2\u0777\u0775\3\2\2\2\u0777\u0778\3\2"+
		"\2\2\u0778\u0779\3\2\2\2\u0779\u077a\7\u0135\2\2\u077a\u077b\5@!\2\u077b"+
		"\u07c3\3\2\2\2\u077c\u077f\7%\2\2\u077d\u077e\7{\2\2\u077e\u0780\5n8\2"+
		"\u077f\u077d\3\2\2\2\u077f\u0780\3\2\2\2\u0780\u0781\3\2\2\2\u0781\u0782"+
		"\7\u0134\2\2\u0782\u0783\5n8\2\u0783\u0788\7\u0080\2\2\u0784\u0786\5n"+
		"8\2\u0785\u0787\7\u012d\2\2\u0786\u0785\3\2\2\2\u0786\u0787\3\2\2\2\u0787"+
		"\u0789\3\2\2\2\u0788\u0784\3\2\2\2\u0789\u078a\3\2\2\2\u078a\u0788\3\2"+
		"\2\2\u078a\u078b\3\2\2\2\u078b\u078c\3\2\2\2\u078c\u078d\7\u0135\2\2\u078d"+
		"\u0793\5@!\2\u078e\u078f\7\177\2\2\u078f\u0790\7\u0134\2\2\u0790\u0791"+
		"\5n8\2\u0791\u0792\7\u0135\2\2\u0792\u0794\3\2\2\2\u0793\u078e\3\2\2\2"+
		"\u0793\u0794\3\2\2\2\u0794\u07c3\3\2\2\2\u0795\u0796\7+\2\2\u0796\u0797"+
		"\7D\2\2\u0797\u079c\7\u0134\2\2\u0798\u079a\5n8\2\u0799\u079b\7\u012d"+
		"\2\2\u079a\u0799\3\2\2\2\u079a\u079b\3\2\2\2\u079b\u079d\3\2\2\2\u079c"+
		"\u0798\3\2\2\2\u079d\u079e\3\2\2\2\u079e\u079c\3\2\2\2\u079e\u079f\3\2"+
		"\2\2\u079f\u07a0\3\2\2\2\u07a0\u07a1\7\u0135\2\2\u07a1\u07a2\7^\2\2\u07a2"+
		"\u07ae\5n8\2\u07a3\u07a8\7\u0134\2\2\u07a4\u07a6\5n8\2\u07a5\u07a7\7\u012d"+
		"\2\2\u07a6\u07a5\3\2\2\2\u07a6\u07a7\3\2\2\2\u07a7\u07a9\3\2\2\2\u07a8"+
		"\u07a4\3\2\2\2\u07a9\u07aa\3\2\2\2\u07aa\u07a8\3\2\2\2\u07aa\u07ab\3\2"+
		"\2\2\u07ab\u07ac\3\2\2\2\u07ac\u07ad\7\u0135\2\2\u07ad\u07af\3\2\2\2\u07ae"+
		"\u07a3\3\2\2\2\u07ae\u07af\3\2\2\2\u07af\u07b6\3\2\2\2\u07b0\u07b1\7\u00be"+
		"\2\2\u07b1\u07b7\7,\2\2\u07b2\u07b3\7\u00be\2\2\u07b3\u07b7\7\u00d1\2"+
		"\2\u07b4\u07b5\7\u00be\2\2\u07b5\u07b7\7\u00e2\2\2\u07b6\u07b0\3\2\2\2"+
		"\u07b6\u07b2\3\2\2\2\u07b6\u07b4\3\2\2\2\u07b6\u07b7\3\2\2\2\u07b7\u07bb"+
		"\3\2\2\2\u07b8\u07b9\7O\2\2\u07b9\u07ba\7\35\2\2\u07ba\u07bc\5> \2\u07bb"+
		"\u07b8\3\2\2\2\u07bb\u07bc\3\2\2\2\u07bc\u07c0\3\2\2\2\u07bd\u07be\7O"+
		"\2\2\u07be\u07bf\7y\2\2\u07bf\u07c1\5> \2\u07c0\u07bd\3\2\2\2\u07c0\u07c1"+
		"\3\2\2\2\u07c1\u07c3\3\2\2\2\u07c2\u0760\3\2\2\2\u07c2\u0761\3\2\2\2\u07c2"+
		"\u076e\3\2\2\2\u07c2\u077c\3\2\2\2\u07c2\u0795\3\2\2\2\u07c3\u07c7\3\2"+
		"\2\2\u07c4\u07c8\7\33\2\2\u07c5\u07c6\7K\2\2\u07c6\u07c8\7\33\2\2\u07c7"+
		"\u07c4\3\2\2\2\u07c7\u07c5\3\2\2\2\u07c7\u07c8\3\2\2\2\u07c8\u07cd\3\2"+
		"\2\2\u07c9\u07ca\7;\2\2\u07ca\u07ce\7\34\2\2\u07cb\u07cc\7;\2\2\u07cc"+
		"\u07ce\7\66\2\2\u07cd\u07c9\3\2\2\2\u07cd\u07cb\3\2\2\2\u07cd\u07ce\3"+
		"\2\2\2\u07ce\61\3\2\2\2\u07cf\u07d0\7\23\2\2\u07d0\u07d2\5n8\2\u07d1\u07cf"+
		"\3\2\2\2\u07d1\u07d2\3\2\2\2\u07d2\u07f3\3\2\2\2\u07d3\u07d4\7K\2\2\u07d4"+
		"\u07f4\7L\2\2\u07d5\u07f4\7L\2\2\u07d6\u07f4\5\64\33\2\u07d7\u07d8\7\31"+
		"\2\2\u07d8\u07f4\5\u01b2\u00da\2\u07d9\u07da\7x\2\2\u07da\u07f4\5@!\2"+
		"\u07db\u07dc\7W\2\2\u07dc\u07dd\7D\2\2\u07dd\u07f4\5@!\2\u07de\u07df\7"+
		"^\2\2\u07df\u07e0\5\u016a\u00b6\2\u07e0\u07e7\5n8\2\u07e1\u07e2\7\u00be"+
		"\2\2\u07e2\u07e8\7,\2\2\u07e3\u07e4\7\u00be\2\2\u07e4\u07e8\7\u00d1\2"+
		"\2\u07e5\u07e6\7\u00be\2\2\u07e6\u07e8\7\u00e2\2\2\u07e7\u07e1\3\2\2\2"+
		"\u07e7\u07e3\3\2\2\2\u07e7\u07e5\3\2\2\2\u07e7\u07e8\3\2\2\2\u07e8\u07ec"+
		"\3\2\2\2\u07e9\u07ea\7O\2\2\u07ea\u07eb\7\35\2\2\u07eb\u07ed\5> \2\u07ec"+
		"\u07e9\3\2\2\2\u07ec\u07ed\3\2\2\2\u07ed\u07f1\3\2\2\2\u07ee\u07ef\7O"+
		"\2\2\u07ef\u07f0\7y\2\2\u07f0\u07f2\5> \2\u07f1\u07ee\3\2\2\2\u07f1\u07f2"+
		"\3\2\2\2\u07f2\u07f4\3\2\2\2\u07f3\u07d3\3\2\2\2\u07f3\u07d5\3\2\2\2\u07f3"+
		"\u07d6\3\2\2\2\u07f3\u07d7\3\2\2\2\u07f3\u07d9\3\2\2\2\u07f3\u07db\3\2"+
		"\2\2\u07f3\u07de\3\2\2\2\u07f4\u07f8\3\2\2\2\u07f5\u07f9\7\33\2\2\u07f6"+
		"\u07f7\7K\2\2\u07f7\u07f9\7\33\2\2\u07f8\u07f5\3\2\2\2\u07f8\u07f6\3\2"+
		"\2\2\u07f8\u07f9\3\2\2\2\u07f9\u07fe\3\2\2\2\u07fa\u07fb\7;\2\2\u07fb"+
		"\u07ff\7\34\2\2\u07fc\u07fd\7;\2\2\u07fd\u07ff\7\66\2\2\u07fe\u07fa\3"+
		"\2\2\2\u07fe\u07fc\3\2\2\2\u07fe\u07ff\3\2\2\2\u07ff\63\3\2\2\2\u0800"+
		"\u0801\7\u008b\2\2\u0801\u0802\7\u0134\2\2\u0802\u0803\5\u00fa~\2\u0803"+
		"\u0804\7\u0135\2\2\u0804\65\3\2\2\2\u0805\u0806\7\u0080\2\2\u0806\u080f"+
		"\7\u0134\2\2\u0807\u080a\5n8\2\u0808\u0809\7\u012a\2\2\u0809\u080b\5n"+
		"8\2\u080a\u0808\3\2\2\2\u080a\u080b\3\2\2\2\u080b\u080d\3\2\2\2\u080c"+
		"\u080e\7\u012d\2\2\u080d\u080c\3\2\2\2\u080d\u080e\3\2\2\2\u080e\u0810"+
		"\3\2\2\2\u080f\u0807\3\2\2\2\u0810\u0811\3\2\2\2\u0811\u080f\3\2\2\2\u0811"+
		"\u0812\3\2\2\2\u0812\u0813\3\2\2\2\u0813\u0814\7\u0135\2\2\u0814\67\3"+
		"\2\2\2\u0815\u081b\5\66\34\2\u0816\u0817\7\u0080\2\2\u0817\u081b\7N\2"+
		"\2\u0818\u0819\7\u0081\2\2\u0819\u081b\7N\2\2\u081a\u0815\3\2\2\2\u081a"+
		"\u0816\3\2\2\2\u081a\u0818\3\2\2\2\u081a\u081b\3\2\2\2\u081b9\3\2\2\2"+
		"\u081c\u081d\7O\2\2\u081d\u0823\7\u0091\2\2\u081e\u081f\7V\2\2\u081f\u0824"+
		"\7]\2\2\u0820\u0821\7\35\2\2\u0821\u0824\7]\2\2\u0822\u0824\7\u00a0\2"+
		"\2\u0823\u081e\3\2\2\2\u0823\u0820\3\2\2\2\u0823\u0822\3\2\2\2\u0824\u0826"+
		"\3\2\2\2\u0825\u081c\3\2\2\2\u0825\u0826\3\2\2\2\u0826;\3\2\2\2\u0827"+
		"\u0828\7\u00ea\2\2\u0828\u082a\5n8\2\u0829\u0827\3\2\2\2\u0829\u082a\3"+
		"\2\2\2\u082a=\3\2\2\2\u082b\u0832\7`\2\2\u082c\u0832\7\16\2\2\u082d\u082e"+
		"\7\u00e0\2\2\u082e\u0832\7L\2\2\u082f\u0830\7\u00e0\2\2\u0830\u0832\7"+
		"\31\2\2\u0831\u082b\3\2\2\2\u0831\u082c\3\2\2\2\u0831\u082d\3\2\2\2\u0831"+
		"\u082f\3\2\2\2\u0832?\3\2\2\2\u0833\u0835\5\66\34\2\u0834\u0833\3\2\2"+
		"\2\u0834\u0835\3\2\2\2\u0835\u083a\3\2\2\2\u0836\u0837\7{\2\2\u0837\u0838"+
		"\7\u00ae\2\2\u0838\u0839\7\u00ea\2\2\u0839\u083b\5n8\2\u083a\u0836\3\2"+
		"\2\2\u083a\u083b\3\2\2\2\u083bA\3\2\2\2\u083c\u083d\7\u0134\2\2\u083d"+
		"\u0842\5D#\2\u083e\u083f\7\u012d\2\2\u083f\u0841\5D#\2\u0840\u083e\3\2"+
		"\2\2\u0841\u0844\3\2\2\2\u0842\u0840\3\2\2\2\u0842\u0843\3\2\2\2\u0843"+
		"\u0845\3\2\2\2\u0844\u0842\3\2\2\2\u0845\u0846\7\u0135\2\2\u0846C\3\2"+
		"\2\2\u0847\u0848\5n8\2\u0848\u0849\5F$\2\u0849E\3\2\2\2\u084a\u084b\5"+
		"\u0080A\2\u084bG\3\2\2\2\u084c\u084d\7\u0080\2\2\u084d\u084e\7\u0134\2"+
		"\2\u084e\u0853\5J&\2\u084f\u0850\7\u012d\2\2\u0850\u0852\5J&\2\u0851\u084f"+
		"\3\2\2\2\u0852\u0855\3\2\2\2\u0853\u0851\3\2\2\2\u0853\u0854\3\2\2\2\u0854"+
		"\u0856\3\2\2\2\u0855\u0853\3\2\2\2\u0856\u0857\7\u0135\2\2\u0857I\3\2"+
		"\2\2\u0858\u0859\7\u0147\2\2\u0859\u085a\7\u012a\2\2\u085a\u085b\5\u00d4"+
		"k\2\u085bK\3\2\2\2\u085c\u085d\7{\2\2\u085d\u085e\5n8\2\u085eM\3\2\2\2"+
		"\u085f\u0860\7\u00ea\2\2\u0860\u0861\5P)\2\u0861O\3\2\2\2\u0862\u0863"+
		"\5n8\2\u0863Q\3\2\2\2\u0864\u0869\5T+\2\u0865\u0869\5Z.\2\u0866\u0869"+
		"\5b\62\2\u0867\u0869\5h\65\2\u0868\u0864\3\2\2\2\u0868\u0865\3\2\2\2\u0868"+
		"\u0866\3\2\2\2\u0868\u0867\3\2\2\2\u0869S\3\2\2\2";
	private static final String _serializedATNSegment1 =
		"\u086a\u086b\7\u00d2\2\2\u086b\u086c\7\u0085\2\2\u086c\u086d\7\u00d8\2"+
		"\2\u086d\u086e\7\u0134\2\2\u086e\u086f\5\u017c\u00bf\2\u086f\u0870\7\u0135"+
		"\2\2\u0870\u0871\7\u0134\2\2\u0871\u0872\5V,\2\u0872\u0873\7\u0135\2\2"+
		"\u0873U\3\2\2\2\u0874\u0879\5X-\2\u0875\u0876\7\u012d\2\2\u0876\u0878"+
		"\5X-\2\u0877\u0875\3\2\2\2\u0878\u087b\3\2\2\2\u0879\u0877\3\2\2\2\u0879"+
		"\u087a\3\2\2\2\u087aW\3\2\2\2\u087b\u0879\3\2\2\2\u087c\u087d\7\u00d2"+
		"\2\2\u087d\u087e\5j\66\2\u087e\u087f\7\u00f5\2\2\u087f\u0880\7\u00bb\2"+
		"\2\u0880\u088c\7\u00ed\2\2\u0881\u0882\7\u0134\2\2\u0882\u0883\5\u00d0"+
		"i\2\u0883\u0884\7\u0135\2\2\u0884\u088d\3\2\2\2\u0885\u0887\7\u0134\2"+
		"\2\u0886\u0885\3\2\2\2\u0886\u0887\3\2\2\2\u0887\u0888\3\2\2\2\u0888\u088a"+
		"\7\u00c0\2\2\u0889\u088b\7\u0135\2\2\u088a\u0889\3\2\2\2\u088a\u088b\3"+
		"\2\2\2\u088b\u088d\3\2\2\2\u088c\u0881\3\2\2\2\u088c\u0886\3\2\2\2\u088d"+
		"Y\3\2\2\2\u088e\u088f\7\u00d2\2\2\u088f\u0890\7\u0085\2\2\u0890\u0891"+
		"\7\u00ac\2\2\u0891\u0892\7\u0134\2\2\u0892\u0893\5\u017c\u00bf\2\u0893"+
		"\u0899\7\u0135\2\2\u0894\u0895\7\u0134\2\2\u0895\u0896\5\\/\2\u0896\u0897"+
		"\7\u0135\2\2\u0897\u089a\3\2\2\2\u0898\u089a\5`\61\2\u0899\u0894\3\2\2"+
		"\2\u0899\u0898\3\2\2\2\u089a[\3\2\2\2\u089b\u08a0\5^\60\2\u089c\u089d"+
		"\7\u012d\2\2\u089d\u089f\5^\60\2\u089e\u089c\3\2\2\2\u089f\u08a2\3\2\2"+
		"\2\u08a0\u089e\3\2\2\2\u08a0\u08a1\3\2\2\2\u08a1]\3\2\2\2\u08a2\u08a0"+
		"\3\2\2\2\u08a3\u08a4\7\u00d2\2\2\u08a4\u08a5\5j\66\2\u08a5_\3\2\2\2\u08a6"+
		"\u08a7\7\u00d3\2\2\u08a7\u08a8\5\u00d4k\2\u08a8a\3\2\2\2\u08a9\u08aa\7"+
		"\u00d2\2\2\u08aa\u08ab\7\u0085\2\2\u08ab\u08ac\7\u00bc\2\2\u08ac\u08ad"+
		"\7\u0134\2\2\u08ad\u08ae\5\u017c\u00bf\2\u08ae\u08af\7\u0135\2\2\u08af"+
		"\u08b0\7\u0134\2\2\u08b0\u08b1\5d\63\2\u08b1\u08b2\7\u0135\2\2\u08b2c"+
		"\3\2\2\2\u08b3\u08b8\5f\64\2\u08b4\u08b5\7\u012d\2\2\u08b5\u08b7\5f\64"+
		"\2\u08b6\u08b4\3\2\2\2\u08b7\u08ba\3\2\2\2\u08b8\u08b6\3\2\2\2\u08b8\u08b9"+
		"\3\2\2\2\u08b9e\3\2\2\2\u08ba\u08b8\3\2\2\2\u08bb\u08bc\7\u00d2\2\2\u08bc"+
		"\u08bd\5j\66\2\u08bd\u08bf\7\u00f5\2\2\u08be\u08c0\78\2\2\u08bf\u08be"+
		"\3\2\2\2\u08bf\u08c0\3\2\2\2\u08c0\u08c1\3\2\2\2\u08c1\u08c2\7\u0134\2"+
		"\2\u08c2\u08c3\5\u0194\u00cb\2\u08c3\u08c4\7\u0135\2\2\u08c4g\3\2\2\2"+
		"\u08c5\u08c6\7\u00d2\2\2\u08c6\u08c7\7\u0085\2\2\u08c7\u08c8\7\u008e\2"+
		"\2\u08c8\u08c9\5B\"\2\u08c9i\3\2\2\2\u08ca\u08cb\5n8\2\u08cbk\3\2\2\2"+
		"\u08cc\u08cd\7\u00a0\2\2\u08cd\u08ce\7n\2\2\u08ce\u08d0\5\u016a\u00b6"+
		"\2\u08cf\u08d1\7\u00d6\2\2\u08d0\u08cf\3\2\2\2\u08d0\u08d1\3\2\2\2\u08d1"+
		"m\3\2\2\2\u08d2\u08d4\7\u013e\2\2\u08d3\u08d2\3\2\2\2\u08d3\u08d4\3\2"+
		"\2\2\u08d4\u08d5\3\2\2\2\u08d5\u08d7\7\u0146\2\2\u08d6\u08d8\7\u013e\2"+
		"\2\u08d7\u08d6\3\2\2\2\u08d7\u08d8\3\2\2\2\u08d8\u08db\3\2\2\2\u08d9\u08db"+
		"\5p9\2\u08da\u08d3\3\2\2\2\u08da\u08d9\3\2\2\2\u08dbo\3\2\2\2\u08dc\u08dd"+
		"\t\22\2\2\u08ddq\3\2\2\2\u08de\u08e1\5\u00a8U\2\u08df\u08e1\5t;\2\u08e0"+
		"\u08de\3\2\2\2\u08e0\u08df\3\2\2\2\u08e1s\3\2\2\2\u08e2\u08e6\7\u0147"+
		"\2\2\u08e3\u08e6\5v<\2\u08e4\u08e6\5~@\2\u08e5\u08e2\3\2\2\2\u08e5\u08e3"+
		"\3\2\2\2\u08e5\u08e4\3\2\2\2\u08e6u\3\2\2\2\u08e7\u08eb\5z>\2\u08e8\u08eb"+
		"\5x=\2\u08e9\u08eb\5|?\2\u08ea\u08e7\3\2\2\2\u08ea\u08e8\3\2\2\2\u08ea"+
		"\u08e9\3\2\2\2\u08ebw\3\2\2\2\u08ec\u08ed\7\u011a\2\2\u08ed\u08ee\7\u0147"+
		"\2\2\u08eey\3\2\2\2\u08ef\u08f0\7\u011c\2\2\u08f0\u08f1\7\u0147\2\2\u08f1"+
		"{\3\2\2\2\u08f2\u08f3\7\u0119\2\2\u08f3\u08f4\7\u0147\2\2\u08f4}\3\2\2"+
		"\2\u08f5\u08f6\t\23\2\2\u08f6\177\3\2\2\2\u08f7\u08f8\5\u0082B\2\u08f8"+
		"\u0081\3\2\2\2\u08f9\u0904\5\u0088E\2\u08fa\u0904\5\u008cG\2\u08fb\u0904"+
		"\5\u008eH\2\u08fc\u0904\5\u0090I\2\u08fd\u0904\5\u0098M\2\u08fe\u0904"+
		"\5\u009aN\2\u08ff\u0904\5\u009cO\2\u0900\u0904\5\u009eP\2\u0901\u0904"+
		"\5\u0086D\2\u0902\u0904\5\u0084C\2\u0903\u08f9\3\2\2\2\u0903\u08fa\3\2"+
		"\2\2\u0903\u08fb\3\2\2\2\u0903\u08fc\3\2\2\2\u0903\u08fd\3\2\2\2\u0903"+
		"\u08fe\3\2\2\2\u0903\u08ff\3\2\2\2\u0903\u0900\3\2\2\2\u0903\u0901\3\2"+
		"\2\2\u0903\u0902\3\2\2\2\u0904\u0083\3\2\2\2\u0905\u0906\7\u0110\2\2\u0906"+
		"\u0085\3\2\2\2\u0907\u0908\7\u0123\2\2\u0908\u0087\3\2\2\2\u0909\u090b"+
		"\7\u008a\2\2\u090a\u090c\5\u008aF\2\u090b\u090a\3\2\2\2\u090b\u090c\3"+
		"\2\2\2\u090c\u0921\3\2\2\2\u090d\u090f\7\u0115\2\2\u090e\u0910\5\u008a"+
		"F\2\u090f\u090e\3\2\2\2\u090f\u0910\3\2\2\2\u0910\u0921\3\2\2\2\u0911"+
		"\u0912\7\u008a\2\2\u0912\u0914\7\u00f8\2\2\u0913\u0915\5\u008aF\2\u0914"+
		"\u0913\3\2\2\2\u0914\u0915\3\2\2\2\u0915\u0921\3\2\2\2\u0916\u0917\7\u0115"+
		"\2\2\u0917\u0919\7\u00f8\2\2\u0918\u091a\5\u008aF\2\u0919\u0918\3\2\2"+
		"\2\u0919\u091a\3\2\2\2\u091a\u0921\3\2\2\2\u091b\u091d\7\u0116\2\2\u091c"+
		"\u091e\5\u008aF\2\u091d\u091c\3\2\2\2\u091d\u091e\3\2\2\2\u091e\u0921"+
		"\3\2\2\2\u091f\u0921\7\u011e\2\2\u0920\u0909\3\2\2\2\u0920\u090d\3\2\2"+
		"\2\u0920\u0911\3\2\2\2\u0920\u0916\3\2\2\2\u0920\u091b\3\2\2\2\u0920\u091f"+
		"\3\2\2\2\u0921\u0089\3\2\2\2\u0922\u0923\7\u0134\2\2\u0923\u0924\7\u0142"+
		"\2\2\u0924\u0925\7\u0135\2\2\u0925\u008b\3\2\2\2\u0926\u0927\7\u00c8\2"+
		"\2\u0927\u0929\7\u008a\2\2\u0928\u092a\5\u008aF\2\u0929\u0928\3\2\2\2"+
		"\u0929\u092a\3\2\2\2\u092a\u094a\3\2\2\2\u092b\u092c\7\u00c8\2\2\u092c"+
		"\u092e\7\u0115\2\2\u092d\u092f\5\u008aF\2\u092e\u092d\3\2\2\2\u092e\u092f"+
		"\3\2\2\2\u092f\u094a\3\2\2\2\u0930\u0932\7\u0117\2\2\u0931\u0933\5\u008a"+
		"F\2\u0932\u0931\3\2\2\2\u0932\u0933\3\2\2\2\u0933\u094a\3\2\2\2\u0934"+
		"\u0935\7\u00c8\2\2\u0935\u0936\7\u008a\2\2\u0936\u0938\7\u00f8\2\2\u0937"+
		"\u0939\5\u008aF\2\u0938\u0937\3\2\2\2\u0938\u0939\3\2\2\2\u0939\u094a"+
		"\3\2\2\2\u093a\u093b\7\u00c8\2\2\u093b\u093c\7\u0115\2\2\u093c\u093e\7"+
		"\u00f8\2\2\u093d\u093f\5\u008aF\2\u093e\u093d\3\2\2\2\u093e\u093f\3\2"+
		"\2\2\u093f\u094a\3\2\2\2\u0940\u0941\7\u0117\2\2\u0941\u0943\7\u00f8\2"+
		"\2\u0942\u0944\5\u008aF\2\u0943\u0942\3\2\2\2\u0943\u0944\3\2\2\2\u0944"+
		"\u094a\3\2\2\2\u0945\u0947\7\u0118\2\2\u0946\u0948\5\u008aF\2\u0947\u0946"+
		"\3\2\2\2\u0947\u0948\3\2\2\2\u0948\u094a\3\2\2\2\u0949\u0926\3\2\2\2\u0949"+
		"\u092b\3\2\2\2\u0949\u0930\3\2\2\2\u0949\u0934\3\2\2\2\u0949\u093a\3\2"+
		"\2\2\u0949\u0940\3\2\2\2\u0949\u0945\3\2\2\2\u094a\u008d\3\2\2\2\u094b"+
		"\u094d\7\u0121\2\2\u094c\u094e\5\u008aF\2\u094d\u094c\3\2\2\2\u094d\u094e"+
		"\3\2\2\2\u094e\u0954\3\2\2\2\u094f\u0951\7\u0122\2\2\u0950\u0952\5\u008a"+
		"F\2\u0951\u0950\3\2\2\2\u0951\u0952\3\2\2\2\u0952\u0954\3\2\2\2\u0953"+
		"\u094b\3\2\2\2\u0953\u094f\3\2\2\2\u0954\u008f\3\2\2\2\u0955\u0958\5\u0092"+
		"J\2\u0956\u0958\5\u0094K\2\u0957\u0955\3\2\2\2\u0957\u0956\3\2\2\2\u0958"+
		"\u0091\3\2\2\2\u0959\u095b\7\u0113\2\2\u095a\u095c\5\u0096L\2\u095b\u095a"+
		"\3\2\2\2\u095b\u095c\3\2\2\2\u095c\u096f\3\2\2\2\u095d\u095f\7\u0114\2"+
		"\2\u095e\u0960\5\u0096L\2\u095f\u095e\3\2\2\2\u095f\u0960\3\2\2\2\u0960"+
		"\u096f\3\2\2\2\u0961\u0963\7\u009a\2\2\u0962\u0964\5\u0096L\2\u0963\u0962"+
		"\3\2\2\2\u0963\u0964\3\2\2\2\u0964\u096f\3\2\2\2\u0965\u096f\7\u0104\2"+
		"\2\u0966\u096f\7\u0108\2\2\u0967\u096f\7\u0105\2\2\u0968\u096f\7\u0109"+
		"\2\2\u0969\u096f\7\u0106\2\2\u096a\u096f\7\u010a\2\2\u096b\u096f\7\u010b"+
		"\2\2\u096c\u096f\7\u0107\2\2\u096d\u096f\7\u010c\2\2\u096e\u0959\3\2\2"+
		"\2\u096e\u095d\3\2\2\2\u096e\u0961\3\2\2\2\u096e\u0965\3\2\2\2\u096e\u0966"+
		"\3\2\2\2\u096e\u0967\3\2\2\2\u096e\u0968\3\2\2\2\u096e\u0969\3\2\2\2\u096e"+
		"\u096a\3\2\2\2\u096e\u096b\3\2\2\2\u096e\u096c\3\2\2\2\u096e\u096d\3\2"+
		"\2\2\u096f\u0093\3\2\2\2\u0970\u0972\7\u0111\2\2\u0971\u0973\5\u0096L"+
		"\2\u0972\u0971\3\2\2\2\u0972\u0973\3\2\2\2\u0973\u097b\3\2\2\2\u0974\u097b"+
		"\7\u010d\2\2\u0975\u097b\7\u010f\2\2\u0976\u097b\7\u010e\2\2\u0977\u097b"+
		"\7\u0112\2\2\u0978\u0979\7\u0112\2\2\u0979\u097b\7\u00d4\2\2\u097a\u0970"+
		"\3\2\2\2\u097a\u0974\3\2\2\2\u097a\u0975\3\2\2\2\u097a\u0976\3\2\2\2\u097a"+
		"\u0977\3\2\2\2\u097a\u0978\3\2\2\2\u097b\u0095\3\2\2\2\u097c\u097d\7\u0134"+
		"\2\2\u097d\u097e\7\u0142\2\2\u097e\u0985\7\u0135\2\2\u097f\u0980\7\u0134"+
		"\2\2\u0980\u0981\7\u0142\2\2\u0981\u0982\7\u012d\2\2\u0982\u0983\7\u0142"+
		"\2\2\u0983\u0985\7\u0135\2\2\u0984\u097c\3\2\2\2\u0984\u097f\3\2\2\2\u0985"+
		"\u0097\3\2\2\2\u0986\u0987\t\24\2\2\u0987\u0099\3\2\2\2\u0988\u0996\7"+
		"\u0119\2\2\u0989\u0996\7\u011a\2\2\u098a\u098b\7\u011a\2\2\u098b\u098c"+
		"\7\u0080\2\2\u098c\u098d\7\u011a\2\2\u098d\u0996\7\u00ff\2\2\u098e\u0996"+
		"\7\u011b\2\2\u098f\u0996\7\u011c\2\2\u0990\u0991\7\u011c\2\2\u0991\u0992"+
		"\7\u0080\2\2\u0992\u0993\7\u011a\2\2\u0993\u0996\7\u00ff\2\2\u0994\u0996"+
		"\7\u011d\2\2\u0995\u0988\3\2\2\2\u0995\u0989\3\2\2\2\u0995\u098a\3\2\2"+
		"\2\u0995\u098e\3\2\2\2\u0995\u098f\3\2\2\2\u0995\u0990\3\2\2\2\u0995\u0994"+
		"\3\2\2\2\u0996\u009b\3\2\2\2\u0997\u0999\7\u0102\2\2\u0998\u099a\5\u008a"+
		"F\2\u0999\u0998\3\2\2\2\u0999\u099a\3\2\2\2\u099a\u09a5\3\2\2\2\u099b"+
		"\u099d\7\u0103\2\2\u099c\u099e\5\u008aF\2\u099d\u099c\3\2\2\2\u099d\u099e"+
		"\3\2\2\2\u099e\u09a5\3\2\2\2\u099f\u09a0\7\u0102\2\2\u09a0\u09a2\7\u00f8"+
		"\2\2\u09a1\u09a3\5\u008aF\2\u09a2\u09a1\3\2\2\2\u09a2\u09a3\3\2\2\2\u09a3"+
		"\u09a5\3\2\2\2\u09a4\u0997\3\2\2\2\u09a4\u099b\3\2\2\2\u09a4\u099f\3\2"+
		"\2\2\u09a5\u009d\3\2\2\2\u09a6\u09a8\7\u011f\2\2\u09a7\u09a9\5\u008aF"+
		"\2\u09a8\u09a7\3\2\2\2\u09a8\u09a9\3\2\2\2\u09a9\u09b4\3\2\2\2\u09aa\u09ab"+
		"\7\u011f\2\2\u09ab\u09ad\7\u00f8\2\2\u09ac\u09ae\5\u008aF\2\u09ad\u09ac"+
		"\3\2\2\2\u09ad\u09ae\3\2\2\2\u09ae\u09b4\3\2\2\2\u09af\u09b1\7\u0120\2"+
		"\2\u09b0\u09b2\5\u008aF\2\u09b1\u09b0\3\2\2\2\u09b1\u09b2\3\2\2\2\u09b2"+
		"\u09b4\3\2\2\2\u09b3\u09a6\3\2\2\2\u09b3\u09aa\3\2\2\2\u09b3\u09af\3\2"+
		"\2\2\u09b4\u009f\3\2\2\2\u09b5\u09b8\5\u00a2R\2\u09b6\u09b8\5\u00a4S\2"+
		"\u09b7\u09b5\3\2\2\2\u09b7\u09b6\3\2\2\2\u09b8\u00a1\3\2\2\2\u09b9\u09ba"+
		"\7\u0134\2\2\u09ba\u09bb\5\u00d0i\2\u09bb\u09bc\7\u0135\2\2\u09bc\u00a3"+
		"\3\2\2\2\u09bd\u09c5\5\u00a6T\2\u09be\u09c5\5\u0178\u00bd\2\u09bf\u09c5"+
		"\5\u00acW\2\u09c0\u09c5\5\u017e\u00c0\2\u09c1\u09c5\5\u00b8]\2\u09c2\u09c5"+
		"\5\u00caf\2\u09c3\u09c5\5\u01b2\u00da\2\u09c4\u09bd\3\2\2\2\u09c4\u09be"+
		"\3\2\2\2\u09c4\u09bf\3\2\2\2\u09c4\u09c0\3\2\2\2\u09c4\u09c1\3\2\2\2\u09c4"+
		"\u09c2\3\2\2\2\u09c4\u09c3\3\2\2\2\u09c5\u00a5\3\2\2\2\u09c6\u09c7\5r"+
		":\2\u09c7\u00a7\3\2\2\2\u09c8\u09c9\t\25\2\2\u09c9\u00a9\3\2\2\2\u09ca"+
		"\u09cc\5\u00dep\2\u09cb\u09ca\3\2\2\2\u09cb\u09cc\3\2\2\2\u09cc\u09cd"+
		"\3\2\2\2\u09cd\u09ce\5\u00a8U\2\u09ce\u00ab\3\2\2\2\u09cf\u09d0\5\u00ae"+
		"X\2\u09d0\u00ad\3\2\2\2\u09d1\u09d2\7\u0094\2\2\u09d2\u09d3\7\u0134\2"+
		"\2\u09d3\u09d4\7\u0138\2\2\u09d4\u09da\7\u0135\2\2\u09d5\u09d7\5\u00b0"+
		"Y\2\u09d6\u09d8\5\u00b4[\2\u09d7\u09d6\3\2\2\2\u09d7\u09d8\3\2\2\2\u09d8"+
		"\u09da\3\2\2\2\u09d9\u09d1\3\2\2\2\u09d9\u09d5\3\2\2\2\u09da\u00af\3\2"+
		"\2\2\u09db\u09dc\5\u00b2Z\2\u09dc\u09de\7\u0134\2\2\u09dd\u09df\5\u0176"+
		"\u00bc\2\u09de\u09dd\3\2\2\2\u09de\u09df\3\2\2\2\u09df\u09e0\3\2\2\2\u09e0"+
		"\u09e1\5\u00d0i\2\u09e1\u09e2\7\u0135\2\2\u09e2\u00b1\3\2\2\2\u09e3\u09e4"+
		"\t\26\2\2\u09e4\u00b3\3\2\2\2\u09e5\u09e6\7\u00a7\2\2\u09e6\u09e7\7\u0134"+
		"\2\2\u09e7\u09e8\7\177\2\2\u09e8\u09e9\5\u0140\u00a1\2\u09e9\u09ea\7\u0135"+
		"\2\2\u09ea\u00b5\3\2\2\2\u09eb\u09ec\7\u00ab\2\2\u09ec\u09ed\7\u0134\2"+
		"\2\u09ed\u09ee\5\u017c\u00bf\2\u09ee\u09ef\7\u0135\2\2\u09ef\u00b7\3\2"+
		"\2\2\u09f0\u09f1\5\u00bc_\2\u09f1\u00b9\3\2\2\2\u09f2\u09f3\7\u00cb\2"+
		"\2\u09f3\u09f4\7\u0134\2\2\u09f4\u09f5\5\u00d4k\2\u09f5\u09f6\7\u012d"+
		"\2\2\u09f6\u09f7\5\u00fa~\2\u09f7\u09f8\7\u0135\2\2\u09f8\u0a05\3\2\2"+
		"\2\u09f9\u09fa\7\u008d\2\2\u09fa\u09fb\7\u0134\2\2\u09fb\u09fe\5\u00d4"+
		"k\2\u09fc\u09fd\7\u012d\2\2\u09fd\u09ff\5\u00fa~\2\u09fe\u09fc\3\2\2\2"+
		"\u09ff\u0a00\3\2\2\2\u0a00\u09fe\3\2\2\2\u0a00\u0a01\3\2\2\2\u0a01\u0a02"+
		"\3\2\2\2\u0a02\u0a03\7\u0135\2\2\u0a03\u0a05\3\2\2\2\u0a04\u09f2\3\2\2"+
		"\2\u0a04\u09f9\3\2\2\2\u0a05\u00bb\3\2\2\2\u0a06\u0a09\5\u00be`\2\u0a07"+
		"\u0a09\5\u00c0a\2\u0a08\u0a06\3\2\2\2\u0a08\u0a07\3\2\2\2\u0a09\u00bd"+
		"\3\2\2\2\u0a0a\u0a0b\7\r\2\2\u0a0b\u0a0d\5\u00fa~\2\u0a0c\u0a0e\5\u00c2"+
		"b\2\u0a0d\u0a0c\3\2\2\2\u0a0e\u0a0f\3\2\2\2\u0a0f\u0a0d\3\2\2\2\u0a0f"+
		"\u0a10\3\2\2\2\u0a10\u0a12\3\2\2\2\u0a11\u0a13\5\u00c6d\2\u0a12\u0a11"+
		"\3\2\2\2\u0a12\u0a13\3\2\2\2\u0a13\u0a14\3\2\2\2\u0a14\u0a15\7\"\2\2\u0a15"+
		"\u00bf\3\2\2\2\u0a16\u0a18\7\r\2\2\u0a17\u0a19\5\u00c4c\2\u0a18\u0a17"+
		"\3\2\2\2\u0a19\u0a1a\3\2\2\2\u0a1a\u0a18\3\2\2\2\u0a1a\u0a1b\3\2\2\2\u0a1b"+
		"\u0a1d\3\2\2\2\u0a1c\u0a1e\5\u00c6d\2\u0a1d\u0a1c\3\2\2\2\u0a1d\u0a1e"+
		"\3\2\2\2\u0a1e\u0a1f\3\2\2\2\u0a1f\u0a20\7\"\2\2\u0a20\u00c1\3\2\2\2\u0a21"+
		"\u0a22\7~\2\2\u0a22\u0a23\5\u0140\u00a1\2\u0a23\u0a24\7q\2\2\u0a24\u0a25"+
		"\5\u00c8e\2\u0a25\u00c3\3\2\2\2\u0a26\u0a27\7~\2\2\u0a27\u0a28\5\u0140"+
		"\u00a1\2\u0a28\u0a29\7q\2\2\u0a29\u0a2a\5\u00c8e\2\u0a2a\u00c5\3\2\2\2"+
		"\u0a2b\u0a2c\7#\2\2\u0a2c\u0a2d\5\u00c8e\2\u0a2d\u00c7\3\2\2\2\u0a2e\u0a31"+
		"\5\u00d0i\2\u0a2f\u0a31\7L\2\2\u0a30\u0a2e\3\2\2\2\u0a30\u0a2f\3\2\2\2"+
		"\u0a31\u00c9\3\2\2\2\u0a32\u0a33\7\17\2\2\u0a33\u0a34\7\u0134\2\2\u0a34"+
		"\u0a35\5\u00ccg\2\u0a35\u0a36\7\5\2\2\u0a36\u0a37\5\u00ceh\2\u0a37\u0a38"+
		"\7\u0135\2\2\u0a38\u00cb\3\2\2\2\u0a39\u0a3a\5\u00d0i\2\u0a3a\u00cd\3"+
		"\2\2\2\u0a3b\u0a3c\5\u0080A\2\u0a3c\u00cf\3\2\2\2\u0a3d\u0a41\5\u00d2"+
		"j\2\u0a3e\u0a41\5\u010e\u0088\2\u0a3f\u0a41\5\u00fa~\2\u0a40\u0a3d\3\2"+
		"\2\2\u0a40\u0a3e\3\2\2\2\u0a40\u0a3f\3\2\2\2\u0a41\u00d1\3\2\2\2\u0a42"+
		"\u0a46\5\u00d4k\2\u0a43\u0a46\5\u00eav\2\u0a44\u0a46\7L\2\2\u0a45\u0a42"+
		"\3\2\2\2\u0a45\u0a43\3\2\2\2\u0a45\u0a44\3\2\2\2\u0a46\u00d3\3\2\2\2\u0a47"+
		"\u0a4c\5\u00d6l\2\u0a48\u0a49\t\27\2\2\u0a49\u0a4b\5\u00d6l\2\u0a4a\u0a48"+
		"\3\2\2\2\u0a4b\u0a4e\3\2\2\2\u0a4c\u0a4a\3\2\2\2\u0a4c\u0a4d\3\2\2\2\u0a4d"+
		"\u00d5\3\2\2\2\u0a4e\u0a4c\3\2\2\2\u0a4f\u0a54\5\u00d8m\2\u0a50\u0a51"+
		"\t\30\2\2\u0a51\u0a53\5\u00d8m\2\u0a52\u0a50\3\2\2\2\u0a53\u0a56\3\2\2"+
		"\2\u0a54\u0a52\3\2\2\2\u0a54\u0a55\3\2\2\2\u0a55\u00d7\3\2\2\2\u0a56\u0a54"+
		"\3\2\2\2\u0a57\u0a59\5\u00dep\2\u0a58\u0a57\3\2\2\2\u0a58\u0a59\3\2\2"+
		"\2\u0a59\u0a5a\3\2\2\2\u0a5a\u0a5b\5\u00dco\2\u0a5b\u00d9\3\2\2\2\u0a5c"+
		"\u0a5d\7\u0134\2\2\u0a5d\u0a62\5\u00d4k\2\u0a5e\u0a5f\7\u012d\2\2\u0a5f"+
		"\u0a61\5\u00d4k\2\u0a60\u0a5e\3\2\2\2\u0a61\u0a64\3\2\2\2\u0a62\u0a60"+
		"\3\2\2\2\u0a62\u0a63\3\2\2\2\u0a63\u0a65\3\2\2\2\u0a64\u0a62\3\2\2\2\u0a65"+
		"\u0a66\7\u0135\2\2\u0a66\u00db\3\2\2\2\u0a67\u0a6c\5\u00a0Q\2\u0a68\u0a69"+
		"\7\u0128\2\2\u0a69\u0a6b\5\u00ceh\2\u0a6a\u0a68\3\2\2\2\u0a6b\u0a6e\3"+
		"\2\2\2\u0a6c\u0a6a\3\2\2\2\u0a6c\u0a6d\3\2\2\2\u0a6d\u0a71\3\2\2\2\u0a6e"+
		"\u0a6c\3\2\2\2\u0a6f\u0a71\5\u00e0q\2\u0a70\u0a67\3\2\2\2\u0a70\u0a6f"+
		"\3\2\2\2\u0a71\u00dd\3\2\2\2\u0a72\u0a73\t\27\2\2\u0a73\u00df\3\2\2\2"+
		"\u0a74\u0a75\5\u00e2r\2\u0a75\u00e1\3\2\2\2\u0a76\u0a77\7\u00a5\2\2\u0a77"+
		"\u0a78\7\u0134\2\2\u0a78\u0a79\5\u00e4s\2\u0a79\u0a7a\7/\2\2\u0a7a\u0a7b"+
		"\5\u00e8u\2\u0a7b\u0a7c\7\u0135\2\2\u0a7c\u00e3\3\2\2\2\u0a7d\u0a81\5"+
		"\u01ac\u00d7\2\u0a7e\u0a81\5\u00e6t\2\u0a7f\u0a81\5\u01b0\u00d9\2\u0a80"+
		"\u0a7d\3\2\2\2\u0a80\u0a7e\3\2\2\2\u0a80\u0a7f\3\2\2\2\u0a81\u00e5\3\2"+
		"\2\2\u0a82\u0a83\t\31\2\2\u0a83\u00e7\3\2\2\2\u0a84\u0a87\5\u0178\u00bd"+
		"\2\u0a85\u0a87\5v<\2\u0a86\u0a84\3\2\2\2\u0a86\u0a85\3\2\2\2\u0a87\u00e9"+
		"\3\2\2\2\u0a88\u0a89\5\u00ecw\2\u0a89\u00eb\3\2\2\2\u0a8a\u0a8f\5\u00ee"+
		"x\2\u0a8b\u0a8c\7\u012e\2\2\u0a8c\u0a8e\5\u00eex\2\u0a8d\u0a8b\3\2\2\2"+
		"\u0a8e\u0a91\3\2\2\2\u0a8f\u0a8d\3\2\2\2\u0a8f\u0a90\3\2\2\2\u0a90\u00ed"+
		"\3\2\2\2\u0a91\u0a8f\3\2\2\2\u0a92\u0a93\5\u00f0y\2\u0a93\u00ef\3\2\2"+
		"\2\u0a94\u0a97\5\u00a0Q\2\u0a95\u0a97\5\u00f2z\2\u0a96\u0a94\3\2\2\2\u0a96"+
		"\u0a95\3\2\2\2\u0a97\u00f1\3\2\2\2\u0a98\u0a99\5\u00f4{\2\u0a99\u00f3"+
		"\3\2\2\2\u0a9a\u0a9b\7\u00f1\2\2\u0a9b\u0a9c\7\u0134\2\2\u0a9c\u0a9d\5"+
		"\u00f6|\2\u0a9d\u0a9e\7\u0135\2\2\u0a9e\u00f5\3\2\2\2\u0a9f\u0aa1\5\u00f8"+
		"}\2\u0aa0\u0a9f\3\2\2\2\u0aa0\u0aa1\3\2\2\2\u0aa1\u0aa3\3\2\2\2\u0aa2"+
		"\u0aa4\5\u00ecw\2\u0aa3\u0aa2\3\2\2\2\u0aa3\u0aa4\3\2\2\2\u0aa4\u0aa5"+
		"\3\2\2\2\u0aa5\u0aa7\7/\2\2\u0aa6\u0aa0\3\2\2\2\u0aa6\u0aa7\3\2\2\2\u0aa7"+
		"\u0aa8\3\2\2\2\u0aa8\u0aae\5\u00ecw\2\u0aa9\u0aaa\5\u00ecw\2\u0aaa\u0aab"+
		"\7\u012d\2\2\u0aab\u0aac\5\u00ecw\2\u0aac\u0aae\3\2\2\2\u0aad\u0aa6\3"+
		"\2\2\2\u0aad\u0aa9\3\2\2\2\u0aae\u00f7\3\2\2\2\u0aaf\u0ab0\t\32\2\2\u0ab0"+
		"\u00f9\3\2\2\2\u0ab1\u0ab2\5\u00fc\177\2\u0ab2\u00fb\3\2\2\2\u0ab3\u0ab8"+
		"\5\u00fe\u0080\2\u0ab4\u0ab5\7S\2\2\u0ab5\u0ab7\5\u00fc\177\2\u0ab6\u0ab4"+
		"\3\2\2\2\u0ab7\u0aba\3\2\2\2\u0ab8\u0ab6\3\2\2\2\u0ab8\u0ab9\3\2\2\2\u0ab9"+
		"\u00fd\3\2\2\2\u0aba\u0ab8\3\2\2\2\u0abb\u0ac0\5\u0100\u0081\2\u0abc\u0abd"+
		"\7\7\2\2\u0abd\u0abf\5\u00fe\u0080\2\u0abe\u0abc\3\2\2\2\u0abf\u0ac2\3"+
		"\2\2\2\u0ac0\u0abe\3\2\2\2\u0ac0\u0ac1\3\2\2\2\u0ac1\u00ff\3\2\2\2\u0ac2"+
		"\u0ac0\3\2\2\2\u0ac3\u0ac7\5\u0102\u0082\2\u0ac4\u0ac5\7K\2\2\u0ac5\u0ac7"+
		"\5\u0102\u0082\2\u0ac6\u0ac3\3\2\2\2\u0ac6\u0ac4\3\2\2\2\u0ac7\u0101\3"+
		"\2\2\2\u0ac8\u0aca\5\u0108\u0085\2\u0ac9\u0acb\5\u0104\u0083\2\u0aca\u0ac9"+
		"\3\2\2\2\u0aca\u0acb\3\2\2\2\u0acb\u0103\3\2\2\2\u0acc\u0ace\7B\2\2\u0acd"+
		"\u0acf\7K\2\2\u0ace\u0acd\3\2\2\2\u0ace\u0acf\3\2\2\2\u0acf\u0ad0\3\2"+
		"\2\2\u0ad0\u0ad1\5\u0106\u0084\2\u0ad1\u0105\3\2\2\2\u0ad2\u0ad3\t\23"+
		"\2\2\u0ad3\u0107\3\2\2\2\u0ad4\u0ad7\5\u0186\u00c4\2\u0ad5\u0ad7\5\u010a"+
		"\u0086\2\u0ad6\u0ad4\3\2\2\2\u0ad6\u0ad5\3\2\2\2\u0ad7\u0109\3\2\2\2\u0ad8"+
		"\u0adb\5\u010c\u0087\2\u0ad9\u0adb\5\u00a4S\2\u0ada\u0ad8\3\2\2\2\u0ada"+
		"\u0ad9\3\2\2\2\u0adb\u010b\3\2\2\2\u0adc\u0add\7\u0134\2\2\u0add\u0ade"+
		"\5\u00fa~\2\u0ade\u0adf\7\u0135\2\2\u0adf\u010d\3\2\2\2\u0ae0\u0ae3\5"+
		"\u0110\u0089\2\u0ae1\u0ae3\5\u0112\u008a\2\u0ae2\u0ae0\3\2\2\2\u0ae2\u0ae1"+
		"\3\2\2\2\u0ae3\u010f\3\2\2\2\u0ae4\u0ae5\5\u00a4S\2\u0ae5\u0111\3\2\2"+
		"\2\u0ae6\u0ae7\7L\2\2\u0ae7\u0113\3\2\2\2\u0ae8\u0aeb\5\u0110\u0089\2"+
		"\u0ae9\u0aeb\5\u0116\u008c\2\u0aea\u0ae8\3\2\2\2\u0aea\u0ae9\3\2\2\2\u0aeb"+
		"\u0115\3\2\2\2\u0aec\u0aef\5\u00d2j\2\u0aed\u0aef\5\u010a\u0086\2\u0aee"+
		"\u0aec\3\2\2\2\u0aee\u0aed\3\2\2\2\u0aef\u0117\3\2\2\2\u0af0\u0af2\5\u011a"+
		"\u008e\2\u0af1\u0af3\5\u013e\u00a0\2\u0af2\u0af1\3\2\2\2\u0af2\u0af3\3"+
		"\2\2\2\u0af3\u0af5\3\2\2\2\u0af4\u0af6\5\u0142\u00a2\2\u0af5\u0af4\3\2"+
		"\2\2\u0af5\u0af6\3\2\2\2\u0af6\u0af8\3\2\2\2\u0af7\u0af9\5\u0152\u00aa"+
		"\2\u0af8\u0af7\3\2\2\2\u0af8\u0af9\3\2\2\2\u0af9\u0afb\3\2\2\2\u0afa\u0afc"+
		"\5\u01ba\u00de\2\u0afb\u0afa\3\2\2\2\u0afb\u0afc\3\2\2\2\u0afc\u0afe\3"+
		"\2\2\2\u0afd\u0aff\5\u01c2\u00e2\2\u0afe\u0afd\3\2\2\2\u0afe\u0aff\3\2"+
		"\2\2\u0aff\u0119\3\2\2\2\u0b00\u0b01\7/\2\2\u0b01\u0b02\5\u011c\u008f"+
		"\2\u0b02\u011b\3\2\2\2\u0b03\u0b08\5\u011e\u0090\2\u0b04\u0b05\7\u012d"+
		"\2\2\u0b05\u0b07\5\u011e\u0090\2\u0b06\u0b04\3\2\2\2\u0b07\u0b0a\3\2\2"+
		"\2\u0b08\u0b06\3\2\2\2\u0b08\u0b09\3\2\2\2\u0b09\u011d\3\2\2\2\u0b0a\u0b08"+
		"\3\2\2\2\u0b0b\u0b0e\5\u0120\u0091\2\u0b0c\u0b0e\5\u0138\u009d\2\u0b0d"+
		"\u0b0b\3\2\2\2\u0b0d\u0b0c\3\2\2\2\u0b0e\u011f\3\2\2\2\u0b0f\u0b11\5\u0138"+
		"\u009d\2\u0b10\u0b12\5\u0122\u0092\2\u0b11\u0b10\3\2\2\2\u0b12\u0b13\3"+
		"\2\2\2\u0b13\u0b11\3\2\2\2\u0b13\u0b14\3\2\2\2\u0b14\u0121\3\2\2\2\u0b15"+
		"\u0b16\7\27\2\2\u0b16\u0b17\7C\2\2\u0b17\u0b29\5\u0138\u009d\2\u0b18\u0b1a"+
		"\5\u012c\u0097\2\u0b19\u0b18\3\2\2\2\u0b19\u0b1a\3\2\2\2\u0b1a\u0b1b\3"+
		"\2\2\2\u0b1b\u0b1c\7C\2\2\u0b1c\u0b1d\5\u0138\u009d\2\u0b1d\u0b1e\5\u0132"+
		"\u009a\2\u0b1e\u0b29\3\2\2\2\u0b1f\u0b21\7J\2\2\u0b20\u0b22\5\u012c\u0097"+
		"\2\u0b21\u0b20\3\2\2\2\u0b21\u0b22\3\2\2\2\u0b22\u0b23\3\2\2\2\u0b23\u0b24"+
		"\7C\2\2\u0b24\u0b29\5\u0138\u009d\2\u0b25\u0b26\7w\2\2\u0b26\u0b27\7C"+
		"\2\2\u0b27\u0b29\5\u0138\u009d\2\u0b28\u0b15\3\2\2\2\u0b28\u0b19\3\2\2"+
		"\2\u0b28\u0b1f\3\2\2\2\u0b28\u0b25\3\2\2\2\u0b29\u0123\3\2\2\2\u0b2a\u0b2b"+
		"\7\27\2\2\u0b2b\u0b2c\7C\2\2\u0b2c\u0b2d\5\u0138\u009d\2\u0b2d\u0125\3"+
		"\2\2\2\u0b2e\u0b30\5\u012c\u0097\2\u0b2f\u0b2e\3\2\2\2\u0b2f\u0b30\3\2"+
		"\2\2\u0b30\u0b31\3\2\2\2\u0b31\u0b32\7C\2\2\u0b32\u0b33\5\u0138\u009d"+
		"\2\u0b33\u0b34\5\u0132\u009a\2\u0b34\u0127\3\2\2\2\u0b35\u0b37\7J\2\2"+
		"\u0b36\u0b38\5\u012c\u0097\2\u0b37\u0b36\3\2\2\2\u0b37\u0b38\3\2\2\2\u0b38"+
		"\u0b39\3\2\2\2\u0b39\u0b3a\7C\2\2\u0b3a\u0b3b\5\u0138\u009d\2\u0b3b\u0129"+
		"\3\2\2\2\u0b3c\u0b3d\7w\2\2\u0b3d\u0b3e\7C\2\2\u0b3e\u0b3f\5\u0138\u009d"+
		"\2\u0b3f\u012b\3\2\2\2\u0b40\u0b43\7<\2\2\u0b41\u0b43\5\u012e\u0098\2"+
		"\u0b42\u0b40\3\2\2\2\u0b42\u0b41\3\2\2\2\u0b43\u012d\3\2\2\2\u0b44\u0b46"+
		"\5\u0130\u0099\2\u0b45\u0b47\7P\2\2\u0b46\u0b45\3\2\2\2\u0b46\u0b47\3"+
		"\2\2\2\u0b47\u012f\3\2\2\2\u0b48\u0b49\t\33\2\2\u0b49\u0131\3\2\2\2\u0b4a"+
		"\u0b4d\5\u0134\u009b\2\u0b4b\u0b4d\5\u0136\u009c\2\u0b4c\u0b4a\3\2\2\2"+
		"\u0b4c\u0b4b\3\2\2\2\u0b4d\u0133\3\2\2\2\u0b4e\u0b4f\7O\2\2\u0b4f\u0b50"+
		"\5\u0140\u00a1\2\u0b50\u0135\3\2\2\2\u0b51\u0b52\7{\2\2\u0b52\u0b53\7"+
		"\u0134\2\2\u0b53\u0b54\5\u017c\u00bf\2\u0b54\u0b55\7\u0135\2\2\u0b55\u0137"+
		"\3\2\2\2\u0b56\u0b5b\5\u0168\u00b5\2\u0b57\u0b59\7\5\2\2\u0b58\u0b57\3"+
		"\2\2\2\u0b58\u0b59\3\2\2\2\u0b59\u0b5a\3\2\2\2\u0b5a\u0b5c\5n8\2\u0b5b"+
		"\u0b58\3\2\2\2\u0b5b\u0b5c\3\2\2\2\u0b5c\u0b61\3\2\2\2\u0b5d\u0b5e\7\u0134"+
		"\2\2\u0b5e\u0b5f\5\u013a\u009e\2\u0b5f\u0b60\7\u0135\2\2\u0b60\u0b62\3"+
		"\2\2\2\u0b61\u0b5d\3\2\2\2\u0b61\u0b62\3\2\2\2\u0b62\u0b6f\3\2\2\2\u0b63"+
		"\u0b65\5\u013c\u009f\2\u0b64\u0b66\7\5\2\2\u0b65\u0b64\3\2\2\2\u0b65\u0b66"+
		"\3\2\2\2\u0b66\u0b67\3\2\2\2\u0b67\u0b6c\5n8\2\u0b68\u0b69\7\u0134\2\2"+
		"\u0b69\u0b6a\5\u013a\u009e\2\u0b6a\u0b6b\7\u0135\2\2\u0b6b\u0b6d\3\2\2"+
		"\2\u0b6c\u0b68\3\2\2\2\u0b6c\u0b6d\3\2\2\2\u0b6d\u0b6f\3\2\2\2\u0b6e\u0b56"+
		"\3\2\2\2\u0b6e\u0b63\3\2\2\2\u0b6f\u0139\3\2\2\2\u0b70\u0b75\5n8\2\u0b71"+
		"\u0b72\7\u012d\2\2\u0b72\u0b74\5n8\2\u0b73\u0b71\3\2\2\2\u0b74\u0b77\3"+
		"\2\2\2\u0b75\u0b73\3\2\2\2\u0b75\u0b76\3\2\2\2\u0b76\u013b\3\2\2\2\u0b77"+
		"\u0b75\3\2\2\2\u0b78\u0b79\5\u0182\u00c2\2\u0b79\u013d\3\2\2\2\u0b7a\u0b7b"+
		"\7\177\2\2\u0b7b\u0b7c\5\u0140\u00a1\2\u0b7c\u013f\3\2\2\2\u0b7d\u0b7e"+
		"\5\u00d0i\2\u0b7e\u0141\3\2\2\2\u0b7f\u0b80\7\62\2\2\u0b80\u0b81\7\u0085"+
		"\2\2\u0b81\u0b82\5\u0144\u00a3\2\u0b82\u0143\3\2\2\2\u0b83\u0b88\5\u0146"+
		"\u00a4\2\u0b84\u0b85\7\u012d\2\2\u0b85\u0b87\5\u0146\u00a4\2\u0b86\u0b84"+
		"\3\2\2\2\u0b87\u0b8a\3\2\2\2\u0b88\u0b86\3\2\2\2\u0b88\u0b89\3\2\2\2\u0b89"+
		"\u0145\3\2\2\2\u0b8a\u0b88\3\2\2\2\u0b8b\u0b90\5\u014c\u00a7\2\u0b8c\u0b90"+
		"\5\u014e\u00a8\2\u0b8d\u0b90\5\u0150\u00a9\2\u0b8e\u0b90\5\u0148\u00a5"+
		"\2\u0b8f\u0b8b\3\2\2\2\u0b8f\u0b8c\3\2\2\2\u0b8f\u0b8d\3\2\2\2\u0b8f\u0b8e"+
		"\3\2\2\2\u0b90\u0147\3\2\2\2\u0b91\u0b97\5\u0114\u008b\2\u0b92\u0b93\7"+
		"\u0134\2\2\u0b93\u0b94\5\u0154\u00ab\2\u0b94\u0b95\7\u0135\2\2\u0b95\u0b97"+
		"\3\2\2\2\u0b96\u0b91\3\2\2\2\u0b96\u0b92\3\2\2\2\u0b97\u0149\3\2\2\2\u0b98"+
		"\u0b9d\5\u0148\u00a5\2\u0b99\u0b9a\7\u012d\2\2\u0b9a\u0b9c\5\u0148\u00a5"+
		"\2\u0b9b\u0b99\3\2\2\2\u0b9c\u0b9f\3\2\2\2\u0b9d\u0b9b\3\2\2\2\u0b9d\u0b9e"+
		"\3\2\2\2\u0b9e\u014b\3\2\2\2\u0b9f\u0b9d\3\2\2\2\u0ba0\u0ba1\7\u00db\2"+
		"\2\u0ba1\u0ba2\7\u0134\2\2\u0ba2\u0ba3\5\u014a\u00a6\2\u0ba3\u0ba4\7\u0135"+
		"\2\2\u0ba4\u014d\3\2\2\2\u0ba5\u0ba6\7\u0095\2\2\u0ba6\u0ba7\7\u0134\2"+
		"\2\u0ba7\u0ba8\5\u014a\u00a6\2\u0ba8\u0ba9\7\u0135\2\2\u0ba9\u014f\3\2"+
		"\2\2\u0baa\u0bab\7\u0134\2\2\u0bab\u0bac\7\u0135\2\2\u0bac\u0151\3\2\2"+
		"\2\u0bad\u0bae\7\63\2\2\u0bae\u0baf\5\u00fa~\2\u0baf\u0153\3\2\2\2\u0bb0"+
		"\u0bb5\5\u0114\u008b\2\u0bb1\u0bb2\7\u012d\2\2\u0bb2\u0bb4\5\u0114\u008b"+
		"\2\u0bb3\u0bb1\3\2\2\2\u0bb4\u0bb7\3\2\2\2\u0bb5\u0bb3\3\2\2\2\u0bb5\u0bb6"+
		"\3\2\2\2\u0bb6\u0155\3\2\2\2\u0bb7\u0bb5\3\2\2\2\u0bb8\u0bb9\5\u0158\u00ad"+
		"\2\u0bb9\u0157\3\2\2\2\u0bba\u0bbd\5\u015a\u00ae\2\u0bbb\u0bbd\5\u0120"+
		"\u0091\2\u0bbc\u0bba\3\2\2\2\u0bbc\u0bbb\3\2\2\2\u0bbd\u0159\3\2\2\2\u0bbe"+
		"\u0bc7\5\u015e\u00b0\2\u0bbf\u0bc0\5\u0120\u0091\2\u0bc0\u0bc2\t\34\2"+
		"\2\u0bc1\u0bc3\t\35\2\2\u0bc2\u0bc1\3\2\2\2\u0bc2\u0bc3\3\2\2\2\u0bc3"+
		"\u0bc4\3\2\2\2\u0bc4\u0bc5\5\u015c\u00af\2\u0bc5\u0bc7\3\2\2\2\u0bc6\u0bbe"+
		"\3\2\2\2\u0bc6\u0bbf\3\2\2\2\u0bc7\u0bcf\3\2\2\2\u0bc8\u0bca\t\34\2\2"+
		"\u0bc9\u0bcb\t\35\2\2\u0bca\u0bc9\3\2\2\2\u0bca\u0bcb\3\2\2\2\u0bcb\u0bcc"+
		"\3\2\2\2\u0bcc\u0bce\5\u015c\u00af\2\u0bcd\u0bc8\3\2\2\2\u0bce\u0bd1\3"+
		"\2\2\2\u0bcf\u0bcd\3\2\2\2\u0bcf\u0bd0\3\2\2\2\u0bd0\u015b\3\2\2\2\u0bd1"+
		"\u0bcf\3\2\2\2\u0bd2\u0bd5\5\u015e\u00b0\2\u0bd3\u0bd5\5\u0120\u0091\2"+
		"\u0bd4\u0bd2\3\2\2\2\u0bd4\u0bd3\3\2\2\2\u0bd5\u015d\3\2\2\2\u0bd6\u0bdf"+
		"\5\u0162\u00b2\2\u0bd7\u0bd8\5\u0120\u0091\2\u0bd8\u0bda\7=\2\2\u0bd9"+
		"\u0bdb\t\35\2\2\u0bda\u0bd9\3\2\2\2\u0bda\u0bdb\3\2\2\2\u0bdb\u0bdc\3"+
		"\2\2\2\u0bdc\u0bdd\5\u0160\u00b1\2\u0bdd\u0bdf\3\2\2\2\u0bde\u0bd6\3\2"+
		"\2\2\u0bde\u0bd7\3\2\2\2\u0bdf\u0be7\3\2\2\2\u0be0\u0be2\7=\2\2\u0be1"+
		"\u0be3\t\35\2\2\u0be2\u0be1\3\2\2\2\u0be2\u0be3\3\2\2\2\u0be3\u0be4\3"+
		"\2\2\2\u0be4\u0be6\5\u0160\u00b1\2\u0be5\u0be0\3\2\2\2\u0be6\u0be9\3\2"+
		"\2\2\u0be7\u0be5\3\2\2\2\u0be7\u0be8\3\2\2\2\u0be8\u015f\3\2\2\2\u0be9"+
		"\u0be7\3\2\2\2\u0bea\u0bed\5\u0162\u00b2\2\u0beb\u0bed\5\u0120\u0091\2"+
		"\u0bec\u0bea\3\2\2\2\u0bec\u0beb\3\2\2\2\u0bed\u0161\3\2\2\2\u0bee\u0bf4"+
		"\5\u0164\u00b3\2\u0bef\u0bf0\7\u0134\2\2\u0bf0\u0bf1\5\u015a\u00ae\2\u0bf1"+
		"\u0bf2\7\u0135\2\2\u0bf2\u0bf4\3\2\2\2\u0bf3\u0bee\3\2\2\2\u0bf3\u0bef"+
		"\3\2\2\2\u0bf4\u0163\3\2\2\2\u0bf5\u0bf8\5\u016c\u00b7\2\u0bf6\u0bf8\5"+
		"\u0166\u00b4\2\u0bf7\u0bf5\3\2\2\2\u0bf7\u0bf6\3\2\2\2\u0bf8\u0165\3\2"+
		"\2\2\u0bf9\u0bfa\7n\2\2\u0bfa\u0bfb\5\u0168\u00b5\2\u0bfb\u0167\3\2\2"+
		"\2\u0bfc\u0bff\5\u016a\u00b6\2\u0bfd\u0bff\5n8\2\u0bfe\u0bfc\3\2\2\2\u0bfe"+
		"\u0bfd\3\2\2\2\u0bff\u0169\3\2\2\2\u0c00\u0c07\5n8\2\u0c01\u0c02\7\u013b"+
		"\2\2\u0c02\u0c05\5n8\2\u0c03\u0c04\7\u013b\2\2\u0c04\u0c06\5n8\2\u0c05"+
		"\u0c03\3\2\2\2\u0c05\u0c06\3\2\2\2\u0c06\u0c08\3\2\2\2\u0c07\u0c01\3\2"+
		"\2\2\u0c07\u0c08\3\2\2\2\u0c08\u016b\3\2\2\2\u0c09\u0c0b\7h\2\2\u0c0a"+
		"\u0c0c\5\u0176\u00bc\2\u0c0b\u0c0a\3\2\2\2\u0c0b\u0c0c\3\2\2\2\u0c0c\u0c0d"+
		"\3\2\2\2\u0c0d\u0c0f\5\u016e\u00b8\2\u0c0e\u0c10\5\u0118\u008d\2\u0c0f"+
		"\u0c0e\3\2\2\2\u0c0f\u0c10\3\2\2\2\u0c10\u016d\3\2\2\2\u0c11\u0c16\5\u0170"+
		"\u00b9\2\u0c12\u0c13\7\u012d\2\2\u0c13\u0c15\5\u0170\u00b9\2\u0c14\u0c12"+
		"\3\2\2\2\u0c15\u0c18\3\2\2\2\u0c16\u0c14\3\2\2\2\u0c16\u0c17\3\2\2\2\u0c17"+
		"\u016f\3\2\2\2\u0c18\u0c16\3\2\2\2\u0c19\u0c1c\5\u0172\u00ba\2\u0c1a\u0c1c"+
		"\5\u0174\u00bb\2\u0c1b\u0c19\3\2\2\2\u0c1b\u0c1a\3\2\2\2\u0c1c\u0171\3"+
		"\2\2\2\u0c1d\u0c1f\5\u00d0i\2\u0c1e\u0c20\5\u017a\u00be\2\u0c1f\u0c1e"+
		"\3\2\2\2\u0c1f\u0c20\3\2\2\2\u0c20\u0173\3\2\2\2\u0c21\u0c22\7\u0146\2"+
		"\2\u0c22\u0c24\7\u013b\2\2\u0c23\u0c21\3\2\2\2\u0c23\u0c24\3\2\2\2\u0c24"+
		"\u0c25\3\2\2\2\u0c25\u0c26\7\u0138\2\2\u0c26\u0175\3\2\2\2\u0c27\u0c28"+
		"\t\35\2\2\u0c28\u0177\3\2\2\2\u0c29\u0c2a\5n8\2\u0c2a\u0c2b\7\u013b\2"+
		"\2\u0c2b\u0c2d\3\2\2\2\u0c2c\u0c29\3\2\2\2\u0c2c\u0c2d\3\2\2\2\u0c2d\u0c2e"+
		"\3\2\2\2\u0c2e\u0c2f\5n8\2\u0c2f\u0179\3\2\2\2\u0c30\u0c32\7\5\2\2\u0c31"+
		"\u0c30\3\2\2\2\u0c31\u0c32\3\2\2\2\u0c32\u0c33\3\2\2\2\u0c33\u0c34\5n"+
		"8\2\u0c34\u017b\3\2\2\2\u0c35\u0c3a\5\u0178\u00bd\2\u0c36\u0c37\7\u012d"+
		"\2\2\u0c37\u0c39\5\u0178\u00bd\2\u0c38\u0c36\3\2\2\2\u0c39\u0c3c\3\2\2"+
		"\2\u0c3a\u0c38\3\2\2\2\u0c3a\u0c3b\3\2\2\2\u0c3b\u017d\3\2\2\2\u0c3c\u0c3a"+
		"\3\2\2\2\u0c3d\u0c3e\5\u0184\u00c3\2\u0c3e\u017f\3\2\2\2\u0c3f\u0c40\5"+
		"\u0184\u00c3\2\u0c40\u0181\3\2\2\2\u0c41\u0c42\5\u0184\u00c3\2\u0c42\u0183"+
		"\3\2\2\2\u0c43\u0c44\7\u0134\2\2\u0c44\u0c45\5\u0156\u00ac\2\u0c45\u0c46"+
		"\7\u0135\2\2\u0c46\u0185\3\2\2\2\u0c47\u0c4e\5\u0188\u00c5\2\u0c48\u0c4e"+
		"\5\u018c\u00c7\2\u0c49\u0c4e\5\u0190\u00c9\2\u0c4a\u0c4e\5\u0196\u00cc"+
		"\2\u0c4b\u0c4e\5\u019e\u00d0\2\u0c4c\u0c4e\5\u01a8\u00d5\2\u0c4d\u0c47"+
		"\3\2\2\2\u0c4d\u0c48\3\2\2\2\u0c4d\u0c49\3\2\2\2\u0c4d\u0c4a\3\2\2\2\u0c4d"+
		"\u0c4b\3\2\2\2\u0c4d\u0c4c\3\2\2\2\u0c4e\u0187\3\2\2\2\u0c4f\u0c50\5\u0114"+
		"\u008b\2\u0c50\u0c51\5\u018a\u00c6\2\u0c51\u0c52\5\u0114\u008b\2\u0c52"+
		"\u0189\3\2\2\2\u0c53\u0c54\t\36\2\2\u0c54\u018b\3\2\2\2\u0c55\u0c56\5"+
		"\u0114\u008b\2\u0c56\u0c57\5\u018e\u00c8\2\u0c57\u018d\3\2\2\2\u0c58\u0c5a"+
		"\7K\2\2\u0c59\u0c58\3\2\2\2\u0c59\u0c5a\3\2\2\2\u0c5a\u0c5b\3\2\2\2\u0c5b"+
		"\u0c5d\7\u0084\2\2\u0c5c\u0c5e\t\37\2\2\u0c5d\u0c5c\3\2\2\2\u0c5d\u0c5e"+
		"\3\2\2\2\u0c5e\u0c5f\3\2\2\2\u0c5f\u0c60\5\u0114\u008b\2\u0c60\u0c61\7"+
		"\7\2\2\u0c61\u0c62\5\u0114\u008b\2\u0c62\u018f\3\2\2\2\u0c63\u0c65\5\u00d4"+
		"k\2\u0c64\u0c66\7K\2\2\u0c65\u0c64\3\2\2\2\u0c65\u0c66\3\2\2\2\u0c66\u0c67"+
		"\3\2\2\2\u0c67\u0c68\78\2\2\u0c68\u0c69\5\u0192\u00ca\2\u0c69\u0191\3"+
		"\2\2\2\u0c6a\u0c70\5\u0182\u00c2\2\u0c6b\u0c6c\7\u0134\2\2\u0c6c\u0c6d"+
		"\5\u0194\u00cb\2\u0c6d\u0c6e\7\u0135\2\2\u0c6e\u0c70\3\2\2\2\u0c6f\u0c6a"+
		"\3\2\2\2\u0c6f\u0c6b\3\2\2\2\u0c70\u0193\3\2\2\2\u0c71\u0c76\5\u010e\u0088"+
		"\2\u0c72\u0c73\7\u012d\2\2\u0c73\u0c75\5\u010e\u0088\2\u0c74\u0c72\3\2"+
		"\2\2\u0c75\u0c78\3\2\2\2\u0c76\u0c74\3\2\2\2\u0c76\u0c77\3\2\2\2\u0c77"+
		"\u0195\3\2\2\2\u0c78\u0c76\3\2\2\2\u0c79\u0c7a\5\u0114\u008b\2\u0c7a\u0c7b"+
		"\5\u0198\u00cd\2\u0c7b\u0c7c\7\u0147\2\2\u0c7c\u0197\3\2\2\2\u0c7d\u0c7f"+
		"\7K\2\2\u0c7e\u0c7d\3\2\2\2\u0c7e\u0c7f\3\2\2\2\u0c7f\u0c80\3\2\2\2\u0c80"+
		"\u0c83\5\u019a\u00ce\2\u0c81\u0c83\5\u019c\u00cf\2\u0c82\u0c7e\3\2\2\2"+
		"\u0c82\u0c81\3\2\2\2\u0c83\u0199\3\2\2\2\u0c84\u0c8b\7G\2\2\u0c85\u0c8b"+
		"\7\65\2\2\u0c86\u0c87\7\u00e1\2\2\u0c87\u0c8b\7\u00f2\2\2\u0c88\u0c8b"+
		"\7\u00d9\2\2\u0c89\u0c8b\7\u00da\2\2\u0c8a\u0c84\3\2\2\2\u0c8a\u0c85\3"+
		"\2\2\2\u0c8a\u0c86\3\2\2\2\u0c8a\u0c88\3\2\2\2\u0c8a\u0c89\3\2\2\2\u0c8b"+
		"\u019b\3\2\2\2\u0c8c\u0c8d\t \2\2\u0c8d\u019d\3\2\2\2\u0c8e\u0c8f\5\u0114"+
		"\u008b\2\u0c8f\u0c91\7B\2\2\u0c90\u0c92\7K\2\2\u0c91\u0c90\3\2\2\2\u0c91"+
		"\u0c92\3\2\2\2\u0c92\u0c93\3\2\2\2\u0c93\u0c94\7L\2\2\u0c94\u019f\3\2"+
		"\2\2\u0c95\u0c96\5\u00d4k\2\u0c96\u0c97\5\u018a\u00c6\2\u0c97\u0c98\5"+
		"\u01a2\u00d2\2\u0c98\u0c99\5\u0182\u00c2\2\u0c99\u01a1\3\2\2\2\u0c9a\u0c9d"+
		"\5\u01a4\u00d3\2\u0c9b\u0c9d\5\u01a6\u00d4\2\u0c9c\u0c9a\3\2\2\2\u0c9c"+
		"\u0c9b\3\2\2\2\u0c9d\u01a3\3\2\2\2\u0c9e\u0c9f\7\6\2\2\u0c9f\u01a5\3\2"+
		"\2\2\u0ca0\u0ca1\t!\2\2\u0ca1\u01a7\3\2\2\2\u0ca2\u0ca4\7K\2\2\u0ca3\u0ca2"+
		"\3\2\2\2\u0ca3\u0ca4\3\2\2\2\u0ca4\u0ca5\3\2\2\2\u0ca5\u0ca6\7\u00a3\2"+
		"\2\u0ca6\u0ca7\5\u0182\u00c2\2\u0ca7\u01a9\3\2\2\2\u0ca8\u0ca9\7x\2\2"+
		"\u0ca9\u0caa\5\u0182\u00c2\2\u0caa\u01ab\3\2\2\2\u0cab\u0cae\5\u01ae\u00d8"+
		"\2\u0cac\u0cae\7\u00dd\2\2\u0cad\u0cab\3\2\2\2\u0cad\u0cac\3\2\2\2\u0cae"+
		"\u01ad\3\2\2\2\u0caf\u0cb0\t\"\2\2\u0cb0\u01af\3\2\2\2\u0cb1\u0cb2\t#"+
		"\2\2\u0cb2\u01b1\3\2\2\2\u0cb3\u0cb4\5\u01b6\u00dc\2\u0cb4\u0cb6\7\u0134"+
		"\2\2\u0cb5\u0cb7\5\u01b8\u00dd\2\u0cb6\u0cb5\3\2\2\2\u0cb6\u0cb7\3\2\2"+
		"\2\u0cb7\u0cb8\3\2\2\2\u0cb8\u0cb9\7\u0135\2\2\u0cb9\u01b3\3\2\2\2\u0cba"+
		"\u0cbb\t$\2\2\u0cbb\u01b5\3\2\2\2\u0cbc\u0cbf\5n8\2\u0cbd\u0cbf\5\u01b4"+
		"\u00db\2\u0cbe\u0cbc\3\2\2\2\u0cbe\u0cbd\3\2\2\2\u0cbf\u01b7\3\2\2\2\u0cc0"+
		"\u0cc5\5\u00d0i\2\u0cc1\u0cc2\7\u012d\2\2\u0cc2\u0cc4\5\u00d0i\2\u0cc3"+
		"\u0cc1\3\2\2\2\u0cc4\u0cc7\3\2\2\2\u0cc5\u0cc3\3\2\2\2\u0cc5\u0cc6\3\2"+
		"\2\2\u0cc6\u01b9\3\2\2\2\u0cc7\u0cc5\3\2\2\2\u0cc8\u0cc9\7T\2\2\u0cc9"+
		"\u0cca\7\u0085\2\2\u0cca\u0ccb\5\u01bc\u00df\2\u0ccb\u01bb\3\2\2\2\u0ccc"+
		"\u0cd1\5\u01be\u00e0\2\u0ccd\u0cce\7\u012d\2\2\u0cce\u0cd0\5\u01be\u00e0"+
		"\2\u0ccf\u0ccd\3\2\2\2\u0cd0\u0cd3\3\2\2\2\u0cd1\u0ccf\3\2\2\2\u0cd1\u0cd2"+
		"\3\2\2\2\u0cd2\u01bd\3\2\2\2\u0cd3\u0cd1\3\2\2\2\u0cd4\u0cd6\5\u0114\u008b"+
		"\2\u0cd5\u0cd7\5\u01c0\u00e1\2\u0cd6\u0cd5\3\2\2\2\u0cd6\u0cd7\3\2\2\2"+
		"\u0cd7\u0cd9\3\2\2\2\u0cd8\u0cda\5\u01c4\u00e3\2\u0cd9\u0cd8\3\2\2\2\u0cd9"+
		"\u0cda\3\2\2\2\u0cda\u01bf\3\2\2\2\u0cdb\u0cdc\t%\2\2\u0cdc\u01c1\3\2"+
		"\2\2\u0cdd\u0cde\7H\2\2\u0cde\u0cdf\5\u00d4k\2\u0cdf\u01c3\3\2\2\2\u0ce0"+
		"\u0ce1\7L\2\2\u0ce1\u0ce5\7\u00a8\2\2\u0ce2\u0ce3\7L\2\2\u0ce3\u0ce5\7"+
		"\u00ba\2\2\u0ce4\u0ce0\3\2\2\2\u0ce4\u0ce2\3\2\2\2\u0ce5\u01c5\3\2\2\2"+
		"\u0ce6\u0ce8\7\u00b2\2\2\u0ce7\u0ce9\7\u00cf\2\2\u0ce8\u0ce7\3\2\2\2\u0ce8"+
		"\u0ce9\3\2\2\2\u0ce9\u0cea\3\2\2\2\u0cea\u0ceb\7>\2\2\u0ceb\u0cf0\5\u016a"+
		"\u00b6\2\u0cec\u0ced\7\u0134\2\2\u0ced\u0cee\5\u013a\u009e\2\u0cee\u0cef"+
		"\7\u0135\2\2\u0cef\u0cf1\3\2\2\2\u0cf0\u0cec\3\2\2\2\u0cf0\u0cf1\3\2\2"+
		"\2\u0cf1\u0cf2\3\2\2\2\u0cf2\u0cf3\5\u0156\u00ac\2\u0cf3\u0d04\3\2\2\2"+
		"\u0cf4\u0cf6\7\u00b2\2\2\u0cf5\u0cf7\7\u00cf\2\2\u0cf6\u0cf5\3\2\2\2\u0cf6"+
		"\u0cf7\3\2\2\2\u0cf7\u0cf8\3\2\2\2\u0cf8\u0cf9\7>\2\2\u0cf9\u0cfa\7\u00bd"+
		"\2\2\u0cfa\u0d00\7\u0147\2\2\u0cfb\u0cfc\7{\2\2\u0cfc\u0cfe\5n8\2\u0cfd"+
		"\u0cff\5H%\2\u0cfe\u0cfd\3\2\2\2\u0cfe\u0cff\3\2\2\2\u0cff\u0d01\3\2\2"+
		"\2\u0d00\u0cfb\3\2\2\2\u0d00\u0d01\3\2\2\2\u0d01\u0d02\3\2\2\2\u0d02\u0d04"+
		"\5\u0156\u00ac\2\u0d03\u0ce6\3\2\2\2\u0d03\u0cf4\3\2\2\2\u0d04\u01c7\3"+
		"\2\2\2\u01e0\u01ca\u01ce\u01df\u01e7\u01eb\u01f2\u01f8\u01ff\u0203\u0207"+
		"\u020b\u020f\u0213\u021d\u0220\u0224\u0228\u022f\u0232\u0236\u0238\u023c"+
		"\u0244\u024d\u0251\u0253\u0255\u025b\u0260\u0266\u026a\u026e\u0272\u027a"+
		"\u027c\u0284\u0289\u028d\u028f\u0293\u0298\u02a1\u02a3\u02ab\u02b1\u02b5"+
		"\u02bb\u02bf\u02c4\u02c8\u02cc\u02d0\u02d4\u02d8\u02e0\u02e5\u02e9\u02eb"+
		"\u02f1\u02f5\u02fd\u0301\u0303\u030b\u0310\u0314\u0316\u031c\u0320\u0328"+
		"\u032d\u032f\u0337\u033b\u0343\u0348\u034a\u0351\u0355\u035d\u0362\u0364"+
		"\u0369\u0371\u0376\u0378\u037e\u0382\u038a\u038f\u0391\u0393\u0397\u0399"+
		"\u03a0\u03a4\u03ac\u03b0\u03b4\u03b8\u03ba\u03c0\u03c4\u03cc\u03d1\u03d3"+
		"\u03d9\u03dd\u03e5\u03e9\u03ed\u03f2\u03f6\u03f9\u03fb\u03ff\u0404\u0406"+
		"\u0408\u040b\u0411\u0415\u0417\u041b\u041f\u0423\u042b\u042f\u0431\u0439"+
		"\u043d\u0441\u0445\u0449\u044d\u044f\u0453\u0457\u045b\u0462\u0466\u046a"+
		"\u046c\u0472\u0476\u047e\u0482\u0484\u048b\u048f\u0493\u0495\u049b\u049f"+
		"\u04a7\u04a9\u04b1\u04b5\u04bd\u04bf\u04c6\u04ca\u04d2\u04d4\u04d9\u04e1"+
		"\u04e3\u04e9\u04ed\u04f4\u04f8\u04fc\u04fe\u0505\u0509\u0510\u0514\u0518"+
		"\u051a\u0520\u0524\u052c\u052e\u0534\u0538\u053e\u0542\u0547\u054b\u0550"+
		"\u0552\u0556\u055a\u055d\u0561\u0566\u056f\u0573\u05b3\u05e1\u05e9\u05ef"+
		"\u05f2\u05f9\u05fb\u05fd\u05ff\u0601\u060c\u0610\u0614\u0627\u062c\u063c"+
		"\u0644\u0646\u064c\u0650\u0654\u065a\u0667\u066a\u066e\u0672\u067d\u0681"+
		"\u0685\u068b\u068e\u0694\u069a\u069e\u06a1\u06a5\u06a8\u06ab\u06b1\u06b3"+
		"\u06bd\u06c0\u06cb\u06ce\u06d1\u06d5\u06dc\u06df\u06e2\u06e9\u06ed\u06f3"+
		"\u06fb\u0700\u0709\u070c\u070f\u0713\u0715\u071c\u0720\u0724\u072c\u0730"+
		"\u0736\u0742\u0746\u0749\u074d\u0751\u0757\u075e\u0765\u0769\u0773\u0777"+
		"\u077f\u0786\u078a\u0793\u079a\u079e\u07a6\u07aa\u07ae\u07b6\u07bb\u07c0"+
		"\u07c2\u07c7\u07cd\u07d1\u07e7\u07ec\u07f1\u07f3\u07f8\u07fe\u080a\u080d"+
		"\u0811\u081a\u0823\u0825\u0829\u0831\u0834\u083a\u0842\u0853\u0868\u0879"+
		"\u0886\u088a\u088c\u0899\u08a0\u08b8\u08bf\u08d0\u08d3\u08d7\u08da\u08e0"+
		"\u08e5\u08ea\u0903\u090b\u090f\u0914\u0919\u091d\u0920\u0929\u092e\u0932"+
		"\u0938\u093e\u0943\u0947\u0949\u094d\u0951\u0953\u0957\u095b\u095f\u0963"+
		"\u096e\u0972\u097a\u0984\u0995\u0999\u099d\u09a2\u09a4\u09a8\u09ad\u09b1"+
		"\u09b3\u09b7\u09c4\u09cb\u09d7\u09d9\u09de\u0a00\u0a04\u0a08\u0a0f\u0a12"+
		"\u0a1a\u0a1d\u0a30\u0a40\u0a45\u0a4c\u0a54\u0a58\u0a62\u0a6c\u0a70\u0a80"+
		"\u0a86\u0a8f\u0a96\u0aa0\u0aa3\u0aa6\u0aad\u0ab8\u0ac0\u0ac6\u0aca\u0ace"+
		"\u0ad6\u0ada\u0ae2\u0aea\u0aee\u0af2\u0af5\u0af8\u0afb\u0afe\u0b08\u0b0d"+
		"\u0b13\u0b19\u0b21\u0b28\u0b2f\u0b37\u0b42\u0b46\u0b4c\u0b58\u0b5b\u0b61"+
		"\u0b65\u0b6c\u0b6e\u0b75\u0b88\u0b8f\u0b96\u0b9d\u0bb5\u0bbc\u0bc2\u0bc6"+
		"\u0bca\u0bcf\u0bd4\u0bda\u0bde\u0be2\u0be7\u0bec\u0bf3\u0bf7\u0bfe\u0c05"+
		"\u0c07\u0c0b\u0c0f\u0c16\u0c1b\u0c1f\u0c23\u0c2c\u0c31\u0c3a\u0c4d\u0c59"+
		"\u0c5d\u0c65\u0c6f\u0c76\u0c7e\u0c82\u0c8a\u0c91\u0c9c\u0ca3\u0cad\u0cb6"+
		"\u0cbe\u0cc5\u0cd1\u0cd6\u0cd9\u0ce4\u0ce8\u0cf0\u0cf6\u0cfe\u0d00\u0d03";
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