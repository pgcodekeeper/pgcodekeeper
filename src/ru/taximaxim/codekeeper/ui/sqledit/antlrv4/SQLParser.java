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
		FUNCTION=43, ISODOW=165, OVERWRITE=187, FUNCTIONS=44, ROW=87, PRECISION=192, 
		ILIKE=51, Character_String_Literal=300, NOT=71, EXCEPT=34, FOREIGN=41, 
		PRIVILEGES=83, BYTEA=265, STATEMENT=101, CHARACTER=129, MONTH=181, TYPE=111, 
		BlockComment=297, VARBIT=234, STDDEV_POP=207, CREATE=20, COMMENTS=135, 
		USING=116, UNLOGGED=221, NOT_EQUAL=278, TIMEZONE_MINUTE=217, VERTICAL_BAR=292, 
		VARIADIC=117, TIMESTAMPTZ=260, REGEXP=197, FAMILY=153, GEQ=282, STDDEV_SAMP=208, 
		DIVIDE=288, BLOB=264, PRESERVE=81, ASC=8, GROUPING=158, SUBPARTITION=209, 
		KEY=64, TEMP=104, ELSE=33, NUMBER=295, BOOL=232, TRAILING=107, SEMI_COLON=275, 
		INT=241, RLIKE=198, RESTRICT=91, LEADING=65, SERVER=202, PROCEDURAL=85, 
		TABLESPACE=211, MILLISECONDS=178, REAL=246, INTERSECT=58, GROUP=48, LANGUAGE=167, 
		SEQUENCES=97, OUT=77, REAL_NUMBER=296, TRIM=218, LEFT_PAREN=283, LOCATION=172, 
		SEARCH=200, END=32, CONSTRAINT=17, TIMEZONE_HOUR=216, CAST_EXPRESSION=271, 
		OPTION=185, ISOYEAR=166, NCHAR=254, EXECUTE=37, TABLE=103, VARCHAR=253, 
		FLOAT=248, VERSION=226, MICROSECONDS=176, ASYMMETRIC=7, SUM=210, Space=301, 
		INOUT=60, STORAGE=206, TIME=257, AS=3, RIGHT_PAREN=284, THEN=106, COLLATION=15, 
		MAXVALUE=175, REPLACE=90, LEFT=66, AVG=124, ZONE=230, TRUNCATE=110, COLUMN=133, 
		PLUS=285, EXISTS=150, NVARCHAR=255, Not_Similar_To=268, LIKE=67, COLLATE=14, 
		INTEGER=242, OUTER=76, BY=126, DEFERRABLE=25, TO=219, SET=203, RIGHT=93, 
		HAVING=49, SESSION=99, MIN=179, MINUS=286, TEXT=261, HOUR=160, CONCATENATION_OPERATOR=277, 
		CONVERSION=19, UNION=112, COLON=274, COMMIT=136, SCHEMA=95, DATABASE=22, 
		DECIMAL=251, DROP=147, BIGINT=243, WHEN=119, ROWS=88, BIT=233, LARGE=168, 
		REVOKE=92, NATURAL=70, FORMAT=156, PUBLIC=193, AGGREGATE=1, EXTENSION=38, 
		BETWEEN=125, OPTIONS=186, FIRST=155, CAST=13, WEEK=227, EXTERNAL=151, 
		DOUBLE_QUOTE=294, VARYING=225, TRIGGER=108, CASE=11, CHAR=252, INT8=238, 
		COUNT=138, DAY=141, CASCADE=12, INT2=236, INT1=235, Identifier=299, INT4=237, 
		QUOTE=293, MODULAR=289, FULL=42, DICTIONARY=144, THAN=214, QUARTER=195, 
		INSERT=163, INHERITS=55, CONNECT=16, INTERSECTION=164, LESS=170, TINYINT=239, 
		BOTH=10, Similar_To_Case_Insensitive=269, DOUBLE=249, ADMIN=123, SYMMETRIC=102, 
		EACH=31, LAST=169, COMMENT=134, SELECT=98, INTO=59, UNIQUE=113, COALESCE=132, 
		SECOND=201, RULE=94, ROLE=86, VIEW=118, EPOCH=148, ROLLUP=199, NULL=72, 
		WITHOUT=122, EVERY=149, ON=75, MATCH=173, PRIMARY=82, DELETE=27, INET4=266, 
		NUMERIC=250, LOCAL=69, OF=73, EXCLUDING=36, LIST=171, TABLES=212, UNDERLINE=291, 
		SEQUENCE=96, Not_Similar_To_Case_Insensitive=270, CUBE=139, NATIONAL=182, 
		VAR_POP=224, OR=79, FILTER=154, CHECK=130, FROM=45, FALSE=39, COLLECT=131, 
		DISTINCT=29, TEMPORARY=105, PARSER=188, TIMESTAMP=259, SIMPLE=205, CONSTRAINTS=18, 
		WHERE=120, DEC=142, VAR_SAMP=223, CLASS=127, NULLIF=183, TIMETZ=258, INNER=57, 
		YEAR=229, TIMEZONE=215, ORDER=80, LIMIT=68, DECADE=143, GTH=281, White_Space=302, 
		UPDATE=114, MAX=174, LineComment=298, DEFERRED=26, FOR=40, FLOAT4=244, 
		CONFIGURATION=137, FLOAT8=245, AND=5, CROSS=21, Similar_To=267, USAGE=115, 
		IF=50, INDEX=161, OIDS=74, BOOLEAN=231, IN=53, UNKNOWN=220, MULTIPLY=287, 
		OBJECT=184, COMMA=276, REFERENCES=89, IS=62, PARTITION=190, PARTITIONS=191, 
		SOME=100, EQUAL=273, ALL=4, DOT=290, EXTRACT=152, CENTURY=128, DOW=145, 
		PARTIAL=189, EXCLUDE=35, WITH=121, INITIALLY=56, DOY=146, FUSION=157, 
		GRANT=47, VARBINARY=263, OPERATOR=78, DEFAULT=23, VALUES=222, HASH=159, 
		RANGE=196, INDEXES=162, MILLENNIUM=177, PURGE=194, BEFORE=9, AFTER=2, 
		INSTEAD=61, WRAPPER=228, TRUE=109, PROCEDURE=84, JOIN=63, SIMILAR=204, 
		DOMAIN=30, DEFAULTS=24, LTH=279, ANY=6, TEMPLATE=213, BAD=303, ASSIGN=272, 
		REGCLASS=247, IMMEDIATE=52, BINARY=262, DESC=28, DATE=256, GLOBAL=46, 
		MINUTE=180, DATA=140, INCLUDING=54, LEQ=280, SMALLINT=240;
	public static final String[] tokenNames = {
		"<INVALID>", "AGGREGATE", "AFTER", "AS", "ALL", "AND", "ANY", "ASYMMETRIC", 
		"ASC", "BEFORE", "BOTH", "CASE", "CASCADE", "CAST", "COLLATE", "COLLATION", 
		"CONNECT", "CONSTRAINT", "CONSTRAINTS", "CONVERSION", "CREATE", "CROSS", 
		"DATABASE", "DEFAULT", "DEFAULTS", "DEFERRABLE", "DEFERRED", "DELETE", 
		"DESC", "DISTINCT", "DOMAIN", "EACH", "END", "ELSE", "EXCEPT", "EXCLUDE", 
		"EXCLUDING", "EXECUTE", "EXTENSION", "FALSE", "FOR", "FOREIGN", "FULL", 
		"FUNCTION", "FUNCTIONS", "FROM", "GLOBAL", "GRANT", "GROUP", "HAVING", 
		"IF", "ILIKE", "IMMEDIATE", "IN", "INCLUDING", "INHERITS", "INITIALLY", 
		"INNER", "INTERSECT", "INTO", "INOUT", "INSTEAD", "IS", "JOIN", "KEY", 
		"LEADING", "LEFT", "LIKE", "LIMIT", "LOCAL", "NATURAL", "NOT", "NULL", 
		"OF", "OIDS", "ON", "OUTER", "OUT", "OPERATOR", "OR", "ORDER", "PRESERVE", 
		"PRIMARY", "PRIVILEGES", "PROCEDURE", "PROCEDURAL", "ROLE", "ROW", "ROWS", 
		"REFERENCES", "REPLACE", "RESTRICT", "REVOKE", "RIGHT", "RULE", "SCHEMA", 
		"SEQUENCE", "SEQUENCES", "SELECT", "SESSION", "SOME", "STATEMENT", "SYMMETRIC", 
		"TABLE", "TEMP", "TEMPORARY", "THEN", "TRAILING", "TRIGGER", "TRUE", "TRUNCATE", 
		"TYPE", "UNION", "UNIQUE", "UPDATE", "USAGE", "USING", "VARIADIC", "VIEW", 
		"WHEN", "WHERE", "WITH", "WITHOUT", "ADMIN", "AVG", "BETWEEN", "BY", "CLASS", 
		"CENTURY", "CHARACTER", "CHECK", "COLLECT", "COALESCE", "COLUMN", "COMMENT", 
		"COMMENTS", "COMMIT", "CONFIGURATION", "COUNT", "CUBE", "DATA", "DAY", 
		"DEC", "DECADE", "DICTIONARY", "DOW", "DOY", "DROP", "EPOCH", "EVERY", 
		"EXISTS", "EXTERNAL", "EXTRACT", "FAMILY", "FILTER", "FIRST", "FORMAT", 
		"FUSION", "GROUPING", "HASH", "HOUR", "INDEX", "INDEXES", "INSERT", "INTERSECTION", 
		"ISODOW", "ISOYEAR", "LANGUAGE", "LARGE", "LAST", "LESS", "LIST", "LOCATION", 
		"MATCH", "MAX", "MAXVALUE", "MICROSECONDS", "MILLENNIUM", "MILLISECONDS", 
		"MIN", "MINUTE", "MONTH", "NATIONAL", "NULLIF", "OBJECT", "OPTION", "OPTIONS", 
		"OVERWRITE", "PARSER", "PARTIAL", "PARTITION", "PARTITIONS", "PRECISION", 
		"PUBLIC", "PURGE", "QUARTER", "RANGE", "REGEXP", "RLIKE", "ROLLUP", "SEARCH", 
		"SECOND", "SERVER", "SET", "SIMILAR", "SIMPLE", "STORAGE", "STDDEV_POP", 
		"STDDEV_SAMP", "SUBPARTITION", "SUM", "TABLESPACE", "TABLES", "TEMPLATE", 
		"THAN", "TIMEZONE", "TIMEZONE_HOUR", "TIMEZONE_MINUTE", "TRIM", "TO", 
		"UNKNOWN", "UNLOGGED", "VALUES", "VAR_SAMP", "VAR_POP", "VARYING", "VERSION", 
		"WEEK", "WRAPPER", "YEAR", "ZONE", "BOOLEAN", "BOOL", "BIT", "VARBIT", 
		"INT1", "INT2", "INT4", "INT8", "TINYINT", "SMALLINT", "INT", "INTEGER", 
		"BIGINT", "FLOAT4", "FLOAT8", "REAL", "REGCLASS", "FLOAT", "DOUBLE", "NUMERIC", 
		"DECIMAL", "CHAR", "VARCHAR", "NCHAR", "NVARCHAR", "DATE", "TIME", "TIMETZ", 
		"TIMESTAMP", "TIMESTAMPTZ", "TEXT", "BINARY", "VARBINARY", "BLOB", "BYTEA", 
		"INET4", "'~'", "'!~'", "'~*'", "'!~*'", "CAST_EXPRESSION", "':='", "'='", 
		"':'", "';'", "','", "CONCATENATION_OPERATOR", "NOT_EQUAL", "'<'", "'<='", 
		"'>'", "'>='", "'('", "')'", "'+'", "'-'", "'*'", "'/'", "'%'", "'.'", 
		"'_'", "'|'", "'''", "'\"'", "NUMBER", "REAL_NUMBER", "BlockComment", 
		"LineComment", "Identifier", "Character_String_Literal", "' '", "White_Space", 
		"BAD"
	};
	public static final int
		RULE_sql = 0, RULE_statement = 1, RULE_data_statement = 2, RULE_data_change_statement = 3, 
		RULE_schema_statement = 4, RULE_index_statement = 5, RULE_create_extension_statement = 6, 
		RULE_set_statement = 7, RULE_create_trigger_statement = 8, RULE_revoke_statement = 9, 
		RULE_revoke_from_cascade_restrict = 10, RULE_grant_statement = 11, RULE_grant_to_rule = 12, 
		RULE_comment_on_statement = 13, RULE_argmode = 14, RULE_function_definition = 15, 
		RULE_functions_definition_schema = 16, RULE_create_table_statement = 17, 
		RULE_like_option = 18, RULE_table_constraint = 19, RULE_column_constraint = 20, 
		RULE_check_boolean_expression = 21, RULE_storage_parameter = 22, RULE_storage_parameter_oid = 23, 
		RULE_on_commit = 24, RULE_table_space = 25, RULE_action = 26, RULE_index_parameters = 27, 
		RULE_table_elements = 28, RULE_field_element = 29, RULE_field_type = 30, 
		RULE_param_clause = 31, RULE_param = 32, RULE_method_specifier = 33, RULE_table_space_specifier = 34, 
		RULE_table_space_name = 35, RULE_table_partitioning_clauses = 36, RULE_range_partitions = 37, 
		RULE_range_value_clause_list = 38, RULE_range_value_clause = 39, RULE_hash_partitions = 40, 
		RULE_individual_hash_partitions = 41, RULE_individual_hash_partition = 42, 
		RULE_hash_partitions_by_quantity = 43, RULE_list_partitions = 44, RULE_list_value_clause_list = 45, 
		RULE_list_value_partition = 46, RULE_column_partitions = 47, RULE_partition_name = 48, 
		RULE_drop_table_statement = 49, RULE_identifier = 50, RULE_nonreserved_keywords = 51, 
		RULE_unsigned_literal = 52, RULE_general_literal = 53, RULE_datetime_literal = 54, 
		RULE_time_literal = 55, RULE_timestamp_literal = 56, RULE_date_literal = 57, 
		RULE_boolean_literal = 58, RULE_data_type = 59, RULE_predefined_type = 60, 
		RULE_regclass = 61, RULE_network_type = 62, RULE_character_string_type = 63, 
		RULE_type_length = 64, RULE_national_character_string_type = 65, RULE_binary_large_object_string_type = 66, 
		RULE_numeric_type = 67, RULE_exact_numeric_type = 68, RULE_approximate_numeric_type = 69, 
		RULE_precision_param = 70, RULE_boolean_type = 71, RULE_datetime_type = 72, 
		RULE_bit_type = 73, RULE_binary_type = 74, RULE_value_expression_primary = 75, 
		RULE_parenthesized_value_expression = 76, RULE_nonparenthesized_value_expression_primary = 77, 
		RULE_unsigned_value_specification = 78, RULE_unsigned_numeric_literal = 79, 
		RULE_signed_numerical_literal = 80, RULE_set_function_specification = 81, 
		RULE_aggregate_function = 82, RULE_general_set_function = 83, RULE_set_function_type = 84, 
		RULE_filter_clause = 85, RULE_grouping_operation = 86, RULE_case_expression = 87, 
		RULE_case_abbreviation = 88, RULE_case_specification = 89, RULE_simple_case = 90, 
		RULE_searched_case = 91, RULE_simple_when_clause = 92, RULE_searched_when_clause = 93, 
		RULE_else_clause = 94, RULE_result = 95, RULE_cast_specification = 96, 
		RULE_cast_operand = 97, RULE_cast_target = 98, RULE_value_expression = 99, 
		RULE_common_value_expression = 100, RULE_numeric_value_expression = 101, 
		RULE_term = 102, RULE_factor = 103, RULE_array = 104, RULE_numeric_primary = 105, 
		RULE_sign = 106, RULE_numeric_value_function = 107, RULE_extract_expression = 108, 
		RULE_extract_field = 109, RULE_time_zone_field = 110, RULE_extract_source = 111, 
		RULE_string_value_expression = 112, RULE_character_value_expression = 113, 
		RULE_character_factor = 114, RULE_character_primary = 115, RULE_string_value_function = 116, 
		RULE_trim_function = 117, RULE_trim_operands = 118, RULE_trim_specification = 119, 
		RULE_boolean_value_expression = 120, RULE_or_predicate = 121, RULE_and_predicate = 122, 
		RULE_boolean_factor = 123, RULE_boolean_test = 124, RULE_is_clause = 125, 
		RULE_truth_value = 126, RULE_boolean_primary = 127, RULE_boolean_predicand = 128, 
		RULE_parenthesized_boolean_value_expression = 129, RULE_row_value_expression = 130, 
		RULE_row_value_special_case = 131, RULE_explicit_row_value_constructor = 132, 
		RULE_row_value_predicand = 133, RULE_row_value_constructor_predicand = 134, 
		RULE_table_expression = 135, RULE_from_clause = 136, RULE_table_reference_list = 137, 
		RULE_table_reference = 138, RULE_joined_table = 139, RULE_joined_table_primary = 140, 
		RULE_cross_join = 141, RULE_qualified_join = 142, RULE_natural_join = 143, 
		RULE_union_join = 144, RULE_join_type = 145, RULE_outer_join_type = 146, 
		RULE_outer_join_type_part2 = 147, RULE_join_specification = 148, RULE_join_condition = 149, 
		RULE_named_columns_join = 150, RULE_table_primary = 151, RULE_column_name_list = 152, 
		RULE_derived_table = 153, RULE_where_clause = 154, RULE_search_condition = 155, 
		RULE_groupby_clause = 156, RULE_grouping_element_list = 157, RULE_grouping_element = 158, 
		RULE_ordinary_grouping_set = 159, RULE_ordinary_grouping_set_list = 160, 
		RULE_rollup_list = 161, RULE_cube_list = 162, RULE_empty_grouping_set = 163, 
		RULE_having_clause = 164, RULE_row_value_predicand_list = 165, RULE_query_expression = 166, 
		RULE_query_expression_body = 167, RULE_non_join_query_expression = 168, 
		RULE_query_term = 169, RULE_non_join_query_term = 170, RULE_query_primary = 171, 
		RULE_non_join_query_primary = 172, RULE_simple_table = 173, RULE_explicit_table = 174, 
		RULE_table_or_query_name = 175, RULE_schema_qualified_name = 176, RULE_query_specification = 177, 
		RULE_select_list = 178, RULE_select_sublist = 179, RULE_derived_column = 180, 
		RULE_qualified_asterisk = 181, RULE_set_qualifier = 182, RULE_column_reference = 183, 
		RULE_as_clause = 184, RULE_column_reference_list = 185, RULE_scalar_subquery = 186, 
		RULE_row_subquery = 187, RULE_table_subquery = 188, RULE_subquery = 189, 
		RULE_predicate = 190, RULE_comparison_predicate = 191, RULE_comp_op = 192, 
		RULE_between_predicate = 193, RULE_between_predicate_part_2 = 194, RULE_in_predicate = 195, 
		RULE_in_predicate_value = 196, RULE_in_value_list = 197, RULE_pattern_matching_predicate = 198, 
		RULE_pattern_matcher = 199, RULE_negativable_matcher = 200, RULE_regex_matcher = 201, 
		RULE_null_predicate = 202, RULE_quantified_comparison_predicate = 203, 
		RULE_quantifier = 204, RULE_all = 205, RULE_some = 206, RULE_exists_predicate = 207, 
		RULE_unique_predicate = 208, RULE_primary_datetime_field = 209, RULE_non_second_primary_datetime_field = 210, 
		RULE_extended_datetime_field = 211, RULE_routine_invocation = 212, RULE_function_names_for_reserved_words = 213, 
		RULE_function_name = 214, RULE_sql_argument_list = 215, RULE_orderby_clause = 216, 
		RULE_sort_specifier_list = 217, RULE_sort_specifier = 218, RULE_order_specification = 219, 
		RULE_limit_clause = 220, RULE_null_ordering = 221, RULE_insert_statement = 222;
	public static final String[] ruleNames = {
		"sql", "statement", "data_statement", "data_change_statement", "schema_statement", 
		"index_statement", "create_extension_statement", "set_statement", "create_trigger_statement", 
		"revoke_statement", "revoke_from_cascade_restrict", "grant_statement", 
		"grant_to_rule", "comment_on_statement", "argmode", "function_definition", 
		"functions_definition_schema", "create_table_statement", "like_option", 
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
			setState(450); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(446); statement();
				setState(448);
				_la = _input.LA(1);
				if (_la==SEMI_COLON) {
					{
					setState(447); match(SEMI_COLON);
					}
				}

				}
				}
				setState(452); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==CREATE || _la==GRANT || ((((_la - 92)) & ~0x3f) == 0 && ((1L << (_la - 92)) & ((1L << (REVOKE - 92)) | (1L << (SELECT - 92)) | (1L << (TABLE - 92)) | (1L << (ADMIN - 92)) | (1L << (AVG - 92)) | (1L << (BETWEEN - 92)) | (1L << (BY - 92)) | (1L << (CLASS - 92)) | (1L << (CENTURY - 92)) | (1L << (CHARACTER - 92)) | (1L << (CHECK - 92)) | (1L << (COLLECT - 92)) | (1L << (COALESCE - 92)) | (1L << (COLUMN - 92)) | (1L << (COMMENT - 92)) | (1L << (COMMENTS - 92)) | (1L << (COMMIT - 92)) | (1L << (CONFIGURATION - 92)) | (1L << (COUNT - 92)) | (1L << (CUBE - 92)) | (1L << (DATA - 92)) | (1L << (DAY - 92)) | (1L << (DEC - 92)) | (1L << (DECADE - 92)) | (1L << (DICTIONARY - 92)) | (1L << (DOW - 92)) | (1L << (DOY - 92)) | (1L << (DROP - 92)) | (1L << (EPOCH - 92)) | (1L << (EVERY - 92)) | (1L << (EXISTS - 92)) | (1L << (EXTERNAL - 92)) | (1L << (EXTRACT - 92)) | (1L << (FAMILY - 92)) | (1L << (FILTER - 92)) | (1L << (FIRST - 92)))) != 0) || ((((_la - 156)) & ~0x3f) == 0 && ((1L << (_la - 156)) & ((1L << (FORMAT - 156)) | (1L << (FUSION - 156)) | (1L << (GROUPING - 156)) | (1L << (HASH - 156)) | (1L << (INDEX - 156)) | (1L << (INSERT - 156)) | (1L << (INTERSECTION - 156)) | (1L << (ISODOW - 156)) | (1L << (ISOYEAR - 156)) | (1L << (LANGUAGE - 156)) | (1L << (LARGE - 156)) | (1L << (LAST - 156)) | (1L << (LESS - 156)) | (1L << (LIST - 156)) | (1L << (LOCATION - 156)) | (1L << (MATCH - 156)) | (1L << (MAX - 156)) | (1L << (MAXVALUE - 156)) | (1L << (MICROSECONDS - 156)) | (1L << (MILLENNIUM - 156)) | (1L << (MILLISECONDS - 156)) | (1L << (MIN - 156)) | (1L << (MINUTE - 156)) | (1L << (MONTH - 156)) | (1L << (NATIONAL - 156)) | (1L << (NULLIF - 156)) | (1L << (OBJECT - 156)) | (1L << (OPTION - 156)) | (1L << (OPTIONS - 156)) | (1L << (OVERWRITE - 156)) | (1L << (PARSER - 156)) | (1L << (PARTIAL - 156)) | (1L << (PARTITION - 156)) | (1L << (PARTITIONS - 156)) | (1L << (PRECISION - 156)) | (1L << (PUBLIC - 156)) | (1L << (PURGE - 156)) | (1L << (QUARTER - 156)) | (1L << (RANGE - 156)) | (1L << (REGEXP - 156)) | (1L << (RLIKE - 156)) | (1L << (ROLLUP - 156)) | (1L << (SEARCH - 156)) | (1L << (SECOND - 156)) | (1L << (SERVER - 156)) | (1L << (SET - 156)) | (1L << (SIMILAR - 156)) | (1L << (SIMPLE - 156)) | (1L << (STORAGE - 156)) | (1L << (STDDEV_POP - 156)) | (1L << (STDDEV_SAMP - 156)) | (1L << (SUBPARTITION - 156)) | (1L << (SUM - 156)) | (1L << (TABLESPACE - 156)) | (1L << (TEMPLATE - 156)) | (1L << (THAN - 156)) | (1L << (TIMEZONE - 156)) | (1L << (TIMEZONE_HOUR - 156)) | (1L << (TIMEZONE_MINUTE - 156)) | (1L << (TRIM - 156)) | (1L << (TO - 156)))) != 0) || ((((_la - 220)) & ~0x3f) == 0 && ((1L << (_la - 220)) & ((1L << (UNKNOWN - 220)) | (1L << (UNLOGGED - 220)) | (1L << (VALUES - 220)) | (1L << (VAR_SAMP - 220)) | (1L << (VAR_POP - 220)) | (1L << (VARYING - 220)) | (1L << (WEEK - 220)) | (1L << (WRAPPER - 220)) | (1L << (YEAR - 220)) | (1L << (ZONE - 220)) | (1L << (BOOLEAN - 220)) | (1L << (BOOL - 220)) | (1L << (BIT - 220)) | (1L << (VARBIT - 220)) | (1L << (INT1 - 220)) | (1L << (INT2 - 220)) | (1L << (INT4 - 220)) | (1L << (INT8 - 220)) | (1L << (TINYINT - 220)) | (1L << (SMALLINT - 220)) | (1L << (INT - 220)) | (1L << (INTEGER - 220)) | (1L << (BIGINT - 220)) | (1L << (FLOAT4 - 220)) | (1L << (FLOAT8 - 220)) | (1L << (REAL - 220)) | (1L << (FLOAT - 220)) | (1L << (DOUBLE - 220)) | (1L << (NUMERIC - 220)) | (1L << (DECIMAL - 220)) | (1L << (CHAR - 220)) | (1L << (VARCHAR - 220)) | (1L << (NCHAR - 220)) | (1L << (NVARCHAR - 220)) | (1L << (DATE - 220)) | (1L << (TIME - 220)) | (1L << (TIMETZ - 220)) | (1L << (TIMESTAMP - 220)) | (1L << (TIMESTAMPTZ - 220)) | (1L << (TEXT - 220)) | (1L << (VARBINARY - 220)) | (1L << (BLOB - 220)) | (1L << (BYTEA - 220)) | (1L << (INET4 - 220)) | (1L << (LEFT_PAREN - 220)))) != 0) || _la==QUOTE || _la==Identifier );
			setState(454); match(EOF);
			}
		}
		catch (RecognitionException re) {
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
			setState(466);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(456); data_statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(457); data_change_statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(458); schema_statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(459); index_statement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(460); create_extension_statement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(461); set_statement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(462); create_trigger_statement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(463); grant_statement();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(464); revoke_statement();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(465); comment_on_statement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
			setState(468); query_expression();
			}
		}
		catch (RecognitionException re) {
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
			setState(470); insert_statement();
			}
		}
		catch (RecognitionException re) {
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
			setState(474);
			switch (_input.LA(1)) {
			case CREATE:
				enterOuterAlt(_localctx, 1);
				{
				setState(472); create_table_statement();
				}
				break;
			case DROP:
				enterOuterAlt(_localctx, 2);
				{
				setState(473); drop_table_statement();
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
			setState(476); match(CREATE);
			setState(478);
			_la = _input.LA(1);
			if (_la==UNIQUE) {
				{
				setState(477); ((Index_statementContext)_localctx).u = match(UNIQUE);
				}
			}

			setState(480); match(INDEX);
			setState(481); ((Index_statementContext)_localctx).n = identifier();
			setState(482); match(ON);
			setState(483); ((Index_statementContext)_localctx).t = schema_qualified_name();
			setState(485);
			_la = _input.LA(1);
			if (_la==USING) {
				{
				setState(484); ((Index_statementContext)_localctx).m = method_specifier();
				}
			}

			setState(487); match(LEFT_PAREN);
			setState(488); ((Index_statementContext)_localctx).s = sort_specifier_list();
			setState(489); match(RIGHT_PAREN);
			setState(491);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(490); ((Index_statementContext)_localctx).p = param_clause();
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
			setState(493); match(CREATE);
			setState(494); match(EXTENSION);
			setState(498);
			_la = _input.LA(1);
			if (_la==IF) {
				{
				setState(495); match(IF);
				setState(496); match(NOT);
				setState(497); match(EXISTS);
				}
			}

			setState(500); ((Create_extension_statementContext)_localctx).name = identifier();
			setState(502);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(501); match(WITH);
				}
			}

			setState(506);
			_la = _input.LA(1);
			if (_la==SCHEMA) {
				{
				setState(504); match(SCHEMA);
				setState(505); ((Create_extension_statementContext)_localctx).schema_name = identifier();
				}
			}

			setState(510);
			_la = _input.LA(1);
			if (_la==VERSION) {
				{
				setState(508); match(VERSION);
				setState(509); ((Create_extension_statementContext)_localctx).version = identifier();
				}
			}

			setState(514);
			_la = _input.LA(1);
			if (_la==FROM) {
				{
				setState(512); match(FROM);
				setState(513); ((Create_extension_statementContext)_localctx).old_version = identifier();
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
			setState(555);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(516); match(SET);
				setState(518);
				_la = _input.LA(1);
				if (_la==LOCAL || _la==SESSION) {
					{
					setState(517);
					_la = _input.LA(1);
					if ( !(_la==LOCAL || _la==SESSION) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(520); ((Set_statementContext)_localctx).config_param = identifier();
				setState(521);
				_la = _input.LA(1);
				if ( !(_la==TO || _la==EQUAL) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(533); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(528);
						switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
						case 1:
							{
							setState(522); ((Set_statementContext)_localctx).value = identifier();
							}
							break;
						case 2:
							{
							setState(523); match(QUOTE);
							setState(524); ((Set_statementContext)_localctx).value = identifier();
							setState(525); match(QUOTE);
							}
							break;
						case 3:
							{
							setState(527); match(DEFAULT);
							}
							break;
						}
						setState(531);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(530); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(535); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(537); match(SET);
				setState(539);
				_la = _input.LA(1);
				if (_la==LOCAL || _la==SESSION) {
					{
					setState(538);
					_la = _input.LA(1);
					if ( !(_la==LOCAL || _la==SESSION) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(541); match(TIME);
				setState(542); match(ZONE);
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
						case COUNT:
						case CUBE:
						case DATA:
						case DAY:
						case DEC:
						case DECADE:
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
						case INSERT:
						case INTERSECTION:
						case ISODOW:
						case ISOYEAR:
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
						case MINUTE:
						case MONTH:
						case NATIONAL:
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
						case SERVER:
						case SET:
						case SIMILAR:
						case SIMPLE:
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
						case WEEK:
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
							setState(543); ((Set_statementContext)_localctx).timezone = identifier();
							}
							break;
						case LOCAL:
							{
							setState(544); match(LOCAL);
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
			setState(557); match(CREATE);
			setState(559);
			_la = _input.LA(1);
			if (_la==CONSTRAINT) {
				{
				setState(558); match(CONSTRAINT);
				}
			}

			setState(561); match(TRIGGER);
			setState(562); ((Create_trigger_statementContext)_localctx).name = identifier();
			setState(567);
			switch (_input.LA(1)) {
			case BEFORE:
				{
				setState(563); match(BEFORE);
				}
				break;
			case INSTEAD:
				{
				{
				setState(564); match(INSTEAD);
				setState(565); match(OF);
				}
				}
				break;
			case AFTER:
				{
				setState(566); match(AFTER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(584);
			switch (_input.LA(1)) {
			case INSERT:
				{
				setState(569); match(INSERT);
				}
				break;
			case DELETE:
				{
				setState(570); match(DELETE);
				}
				break;
			case TRUNCATE:
				{
				setState(571); match(TRUNCATE);
				}
				break;
			case UPDATE:
				{
				{
				setState(572); match(UPDATE);
				setState(582);
				_la = _input.LA(1);
				if (_la==OF) {
					{
					setState(573); match(OF);
					setState(578); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(574); ((Create_trigger_statementContext)_localctx).columnName = identifier();
						setState(576);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(575); match(COMMA);
							}
						}

						}
						}
						setState(580); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 123)) & ~0x3f) == 0 && ((1L << (_la - 123)) & ((1L << (ADMIN - 123)) | (1L << (AVG - 123)) | (1L << (BETWEEN - 123)) | (1L << (BY - 123)) | (1L << (CLASS - 123)) | (1L << (CENTURY - 123)) | (1L << (CHARACTER - 123)) | (1L << (CHECK - 123)) | (1L << (COLLECT - 123)) | (1L << (COALESCE - 123)) | (1L << (COLUMN - 123)) | (1L << (COMMENT - 123)) | (1L << (COMMENTS - 123)) | (1L << (COMMIT - 123)) | (1L << (CONFIGURATION - 123)) | (1L << (COUNT - 123)) | (1L << (CUBE - 123)) | (1L << (DATA - 123)) | (1L << (DAY - 123)) | (1L << (DEC - 123)) | (1L << (DECADE - 123)) | (1L << (DICTIONARY - 123)) | (1L << (DOW - 123)) | (1L << (DOY - 123)) | (1L << (DROP - 123)) | (1L << (EPOCH - 123)) | (1L << (EVERY - 123)) | (1L << (EXISTS - 123)) | (1L << (EXTERNAL - 123)) | (1L << (EXTRACT - 123)) | (1L << (FAMILY - 123)) | (1L << (FILTER - 123)) | (1L << (FIRST - 123)) | (1L << (FORMAT - 123)) | (1L << (FUSION - 123)) | (1L << (GROUPING - 123)) | (1L << (HASH - 123)) | (1L << (INDEX - 123)) | (1L << (INSERT - 123)) | (1L << (INTERSECTION - 123)) | (1L << (ISODOW - 123)) | (1L << (ISOYEAR - 123)) | (1L << (LANGUAGE - 123)) | (1L << (LARGE - 123)) | (1L << (LAST - 123)) | (1L << (LESS - 123)) | (1L << (LIST - 123)) | (1L << (LOCATION - 123)) | (1L << (MATCH - 123)) | (1L << (MAX - 123)) | (1L << (MAXVALUE - 123)) | (1L << (MICROSECONDS - 123)) | (1L << (MILLENNIUM - 123)) | (1L << (MILLISECONDS - 123)) | (1L << (MIN - 123)) | (1L << (MINUTE - 123)) | (1L << (MONTH - 123)) | (1L << (NATIONAL - 123)) | (1L << (NULLIF - 123)) | (1L << (OBJECT - 123)) | (1L << (OPTION - 123)) | (1L << (OPTIONS - 123)))) != 0) || ((((_la - 187)) & ~0x3f) == 0 && ((1L << (_la - 187)) & ((1L << (OVERWRITE - 187)) | (1L << (PARSER - 187)) | (1L << (PARTIAL - 187)) | (1L << (PARTITION - 187)) | (1L << (PARTITIONS - 187)) | (1L << (PRECISION - 187)) | (1L << (PUBLIC - 187)) | (1L << (PURGE - 187)) | (1L << (QUARTER - 187)) | (1L << (RANGE - 187)) | (1L << (REGEXP - 187)) | (1L << (RLIKE - 187)) | (1L << (ROLLUP - 187)) | (1L << (SEARCH - 187)) | (1L << (SECOND - 187)) | (1L << (SERVER - 187)) | (1L << (SET - 187)) | (1L << (SIMILAR - 187)) | (1L << (SIMPLE - 187)) | (1L << (STORAGE - 187)) | (1L << (STDDEV_POP - 187)) | (1L << (STDDEV_SAMP - 187)) | (1L << (SUBPARTITION - 187)) | (1L << (SUM - 187)) | (1L << (TABLESPACE - 187)) | (1L << (TEMPLATE - 187)) | (1L << (THAN - 187)) | (1L << (TIMEZONE - 187)) | (1L << (TIMEZONE_HOUR - 187)) | (1L << (TIMEZONE_MINUTE - 187)) | (1L << (TRIM - 187)) | (1L << (TO - 187)) | (1L << (UNKNOWN - 187)) | (1L << (UNLOGGED - 187)) | (1L << (VALUES - 187)) | (1L << (VAR_SAMP - 187)) | (1L << (VAR_POP - 187)) | (1L << (VARYING - 187)) | (1L << (WEEK - 187)) | (1L << (WRAPPER - 187)) | (1L << (YEAR - 187)) | (1L << (ZONE - 187)) | (1L << (BOOLEAN - 187)) | (1L << (BOOL - 187)) | (1L << (BIT - 187)) | (1L << (VARBIT - 187)) | (1L << (INT1 - 187)) | (1L << (INT2 - 187)) | (1L << (INT4 - 187)) | (1L << (INT8 - 187)) | (1L << (TINYINT - 187)) | (1L << (SMALLINT - 187)) | (1L << (INT - 187)) | (1L << (INTEGER - 187)) | (1L << (BIGINT - 187)) | (1L << (FLOAT4 - 187)) | (1L << (FLOAT8 - 187)) | (1L << (REAL - 187)) | (1L << (FLOAT - 187)) | (1L << (DOUBLE - 187)) | (1L << (NUMERIC - 187)))) != 0) || ((((_la - 251)) & ~0x3f) == 0 && ((1L << (_la - 251)) & ((1L << (DECIMAL - 251)) | (1L << (CHAR - 251)) | (1L << (VARCHAR - 251)) | (1L << (NCHAR - 251)) | (1L << (NVARCHAR - 251)) | (1L << (DATE - 251)) | (1L << (TIME - 251)) | (1L << (TIMETZ - 251)) | (1L << (TIMESTAMP - 251)) | (1L << (TIMESTAMPTZ - 251)) | (1L << (TEXT - 251)) | (1L << (VARBINARY - 251)) | (1L << (BLOB - 251)) | (1L << (BYTEA - 251)) | (1L << (INET4 - 251)) | (1L << (QUOTE - 251)) | (1L << (Identifier - 251)))) != 0) );
					}
				}

				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(586); match(ON);
			setState(587); ((Create_trigger_statementContext)_localctx).tabl_name = schema_qualified_name();
			setState(590);
			_la = _input.LA(1);
			if (_la==FROM) {
				{
				setState(588); match(FROM);
				setState(589); ((Create_trigger_statementContext)_localctx).referenced_table_name = schema_qualified_name();
				}
			}

			setState(601);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				{
				setState(592); match(NOT);
				setState(593); match(DEFERRABLE);
				}
				break;
			case 2:
				{
				setState(595);
				_la = _input.LA(1);
				if (_la==DEFERRABLE) {
					{
					setState(594); match(DEFERRABLE);
					}
				}

				{
				setState(597); match(INITIALLY);
				setState(598); match(IMMEDIATE);
				}
				}
				break;
			case 3:
				{
				{
				setState(599); match(INITIALLY);
				setState(600); match(DEFERRED);
				}
				}
				break;
			}
			setState(609);
			switch (_input.LA(1)) {
			case FOR:
				{
				setState(603); match(FOR);
				setState(605);
				_la = _input.LA(1);
				if (_la==EACH) {
					{
					setState(604); match(EACH);
					}
				}

				setState(607); match(ROW);
				}
				break;
			case STATEMENT:
				{
				setState(608); match(STATEMENT);
				}
				break;
			case EXECUTE:
			case WHEN:
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(613);
			_la = _input.LA(1);
			if (_la==WHEN) {
				{
				setState(611); match(WHEN);
				{
				setState(612); boolean_value_expression();
				}
				}
			}

			setState(615); match(EXECUTE);
			setState(616); match(PROCEDURE);
			setState(617); ((Create_trigger_statementContext)_localctx).func_name = identifier();
			setState(618); match(LEFT_PAREN);
			setState(623);
			_la = _input.LA(1);
			if (((((_la - 123)) & ~0x3f) == 0 && ((1L << (_la - 123)) & ((1L << (ADMIN - 123)) | (1L << (AVG - 123)) | (1L << (BETWEEN - 123)) | (1L << (BY - 123)) | (1L << (CLASS - 123)) | (1L << (CENTURY - 123)) | (1L << (CHARACTER - 123)) | (1L << (CHECK - 123)) | (1L << (COLLECT - 123)) | (1L << (COALESCE - 123)) | (1L << (COLUMN - 123)) | (1L << (COMMENT - 123)) | (1L << (COMMENTS - 123)) | (1L << (COMMIT - 123)) | (1L << (CONFIGURATION - 123)) | (1L << (COUNT - 123)) | (1L << (CUBE - 123)) | (1L << (DATA - 123)) | (1L << (DAY - 123)) | (1L << (DEC - 123)) | (1L << (DECADE - 123)) | (1L << (DICTIONARY - 123)) | (1L << (DOW - 123)) | (1L << (DOY - 123)) | (1L << (DROP - 123)) | (1L << (EPOCH - 123)) | (1L << (EVERY - 123)) | (1L << (EXISTS - 123)) | (1L << (EXTERNAL - 123)) | (1L << (EXTRACT - 123)) | (1L << (FAMILY - 123)) | (1L << (FILTER - 123)) | (1L << (FIRST - 123)) | (1L << (FORMAT - 123)) | (1L << (FUSION - 123)) | (1L << (GROUPING - 123)) | (1L << (HASH - 123)) | (1L << (INDEX - 123)) | (1L << (INSERT - 123)) | (1L << (INTERSECTION - 123)) | (1L << (ISODOW - 123)) | (1L << (ISOYEAR - 123)) | (1L << (LANGUAGE - 123)) | (1L << (LARGE - 123)) | (1L << (LAST - 123)) | (1L << (LESS - 123)) | (1L << (LIST - 123)) | (1L << (LOCATION - 123)) | (1L << (MATCH - 123)) | (1L << (MAX - 123)) | (1L << (MAXVALUE - 123)) | (1L << (MICROSECONDS - 123)) | (1L << (MILLENNIUM - 123)) | (1L << (MILLISECONDS - 123)) | (1L << (MIN - 123)) | (1L << (MINUTE - 123)) | (1L << (MONTH - 123)) | (1L << (NATIONAL - 123)) | (1L << (NULLIF - 123)) | (1L << (OBJECT - 123)) | (1L << (OPTION - 123)) | (1L << (OPTIONS - 123)))) != 0) || ((((_la - 187)) & ~0x3f) == 0 && ((1L << (_la - 187)) & ((1L << (OVERWRITE - 187)) | (1L << (PARSER - 187)) | (1L << (PARTIAL - 187)) | (1L << (PARTITION - 187)) | (1L << (PARTITIONS - 187)) | (1L << (PRECISION - 187)) | (1L << (PUBLIC - 187)) | (1L << (PURGE - 187)) | (1L << (QUARTER - 187)) | (1L << (RANGE - 187)) | (1L << (REGEXP - 187)) | (1L << (RLIKE - 187)) | (1L << (ROLLUP - 187)) | (1L << (SEARCH - 187)) | (1L << (SECOND - 187)) | (1L << (SERVER - 187)) | (1L << (SET - 187)) | (1L << (SIMILAR - 187)) | (1L << (SIMPLE - 187)) | (1L << (STORAGE - 187)) | (1L << (STDDEV_POP - 187)) | (1L << (STDDEV_SAMP - 187)) | (1L << (SUBPARTITION - 187)) | (1L << (SUM - 187)) | (1L << (TABLESPACE - 187)) | (1L << (TEMPLATE - 187)) | (1L << (THAN - 187)) | (1L << (TIMEZONE - 187)) | (1L << (TIMEZONE_HOUR - 187)) | (1L << (TIMEZONE_MINUTE - 187)) | (1L << (TRIM - 187)) | (1L << (TO - 187)) | (1L << (UNKNOWN - 187)) | (1L << (UNLOGGED - 187)) | (1L << (VALUES - 187)) | (1L << (VAR_SAMP - 187)) | (1L << (VAR_POP - 187)) | (1L << (VARYING - 187)) | (1L << (WEEK - 187)) | (1L << (WRAPPER - 187)) | (1L << (YEAR - 187)) | (1L << (ZONE - 187)) | (1L << (BOOLEAN - 187)) | (1L << (BOOL - 187)) | (1L << (BIT - 187)) | (1L << (VARBIT - 187)) | (1L << (INT1 - 187)) | (1L << (INT2 - 187)) | (1L << (INT4 - 187)) | (1L << (INT8 - 187)) | (1L << (TINYINT - 187)) | (1L << (SMALLINT - 187)) | (1L << (INT - 187)) | (1L << (INTEGER - 187)) | (1L << (BIGINT - 187)) | (1L << (FLOAT4 - 187)) | (1L << (FLOAT8 - 187)) | (1L << (REAL - 187)) | (1L << (FLOAT - 187)) | (1L << (DOUBLE - 187)) | (1L << (NUMERIC - 187)))) != 0) || ((((_la - 251)) & ~0x3f) == 0 && ((1L << (_la - 251)) & ((1L << (DECIMAL - 251)) | (1L << (CHAR - 251)) | (1L << (VARCHAR - 251)) | (1L << (NCHAR - 251)) | (1L << (NVARCHAR - 251)) | (1L << (DATE - 251)) | (1L << (TIME - 251)) | (1L << (TIMETZ - 251)) | (1L << (TIMESTAMP - 251)) | (1L << (TIMESTAMPTZ - 251)) | (1L << (TEXT - 251)) | (1L << (VARBINARY - 251)) | (1L << (BLOB - 251)) | (1L << (BYTEA - 251)) | (1L << (INET4 - 251)) | (1L << (QUOTE - 251)) | (1L << (Identifier - 251)))) != 0)) {
				{
				setState(619); ((Create_trigger_statementContext)_localctx).arguments = identifier();
				setState(621);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(620); match(COMMA);
					}
				}

				}
			}

			setState(625); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
			setState(1006);
			switch ( getInterpreter().adaptivePredict(_input,114,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(627); match(REVOKE);
				setState(631);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(628); match(GRANT);
					setState(629); match(OPTION);
					setState(630); match(FOR);
					}
				}

				setState(642);
				switch (_input.LA(1)) {
				case DELETE:
				case REFERENCES:
				case SELECT:
				case TRIGGER:
				case TRUNCATE:
				case UPDATE:
				case INSERT:
					{
					setState(634); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(633);
						_la = _input.LA(1);
						if ( !(_la==DELETE || ((((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & ((1L << (REFERENCES - 89)) | (1L << (SELECT - 89)) | (1L << (TRIGGER - 89)) | (1L << (TRUNCATE - 89)) | (1L << (UPDATE - 89)))) != 0) || _la==INSERT) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
						}
						setState(636); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==DELETE || ((((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & ((1L << (REFERENCES - 89)) | (1L << (SELECT - 89)) | (1L << (TRIGGER - 89)) | (1L << (TRUNCATE - 89)) | (1L << (UPDATE - 89)))) != 0) || _la==INSERT );
					}
					break;
				case ALL:
					{
					setState(638); match(ALL);
					setState(640);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(639); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(644); match(ON);
				setState(662);
				switch (_input.LA(1)) {
				case TABLE:
				case ADMIN:
				case AVG:
				case BETWEEN:
				case BY:
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
				case COUNT:
				case CUBE:
				case DATA:
				case DAY:
				case DEC:
				case DECADE:
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
				case INSERT:
				case INTERSECTION:
				case ISODOW:
				case ISOYEAR:
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
				case MINUTE:
				case MONTH:
				case NATIONAL:
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
				case SERVER:
				case SET:
				case SIMILAR:
				case SIMPLE:
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
				case WEEK:
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
					setState(649); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(646);
						_la = _input.LA(1);
						if (_la==TABLE) {
							{
							setState(645); match(TABLE);
							}
						}

						setState(648); ((Revoke_statementContext)_localctx).table_name = schema_qualified_name();
						}
						}
						setState(651); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 103)) & ~0x3f) == 0 && ((1L << (_la - 103)) & ((1L << (TABLE - 103)) | (1L << (ADMIN - 103)) | (1L << (AVG - 103)) | (1L << (BETWEEN - 103)) | (1L << (BY - 103)) | (1L << (CLASS - 103)) | (1L << (CENTURY - 103)) | (1L << (CHARACTER - 103)) | (1L << (CHECK - 103)) | (1L << (COLLECT - 103)) | (1L << (COALESCE - 103)) | (1L << (COLUMN - 103)) | (1L << (COMMENT - 103)) | (1L << (COMMENTS - 103)) | (1L << (COMMIT - 103)) | (1L << (CONFIGURATION - 103)) | (1L << (COUNT - 103)) | (1L << (CUBE - 103)) | (1L << (DATA - 103)) | (1L << (DAY - 103)) | (1L << (DEC - 103)) | (1L << (DECADE - 103)) | (1L << (DICTIONARY - 103)) | (1L << (DOW - 103)) | (1L << (DOY - 103)) | (1L << (DROP - 103)) | (1L << (EPOCH - 103)) | (1L << (EVERY - 103)) | (1L << (EXISTS - 103)) | (1L << (EXTERNAL - 103)) | (1L << (EXTRACT - 103)) | (1L << (FAMILY - 103)) | (1L << (FILTER - 103)) | (1L << (FIRST - 103)) | (1L << (FORMAT - 103)) | (1L << (FUSION - 103)) | (1L << (GROUPING - 103)) | (1L << (HASH - 103)) | (1L << (INDEX - 103)) | (1L << (INSERT - 103)) | (1L << (INTERSECTION - 103)) | (1L << (ISODOW - 103)) | (1L << (ISOYEAR - 103)))) != 0) || ((((_la - 167)) & ~0x3f) == 0 && ((1L << (_la - 167)) & ((1L << (LANGUAGE - 167)) | (1L << (LARGE - 167)) | (1L << (LAST - 167)) | (1L << (LESS - 167)) | (1L << (LIST - 167)) | (1L << (LOCATION - 167)) | (1L << (MATCH - 167)) | (1L << (MAX - 167)) | (1L << (MAXVALUE - 167)) | (1L << (MICROSECONDS - 167)) | (1L << (MILLENNIUM - 167)) | (1L << (MILLISECONDS - 167)) | (1L << (MIN - 167)) | (1L << (MINUTE - 167)) | (1L << (MONTH - 167)) | (1L << (NATIONAL - 167)) | (1L << (NULLIF - 167)) | (1L << (OBJECT - 167)) | (1L << (OPTION - 167)) | (1L << (OPTIONS - 167)) | (1L << (OVERWRITE - 167)) | (1L << (PARSER - 167)) | (1L << (PARTIAL - 167)) | (1L << (PARTITION - 167)) | (1L << (PARTITIONS - 167)) | (1L << (PRECISION - 167)) | (1L << (PUBLIC - 167)) | (1L << (PURGE - 167)) | (1L << (QUARTER - 167)) | (1L << (RANGE - 167)) | (1L << (REGEXP - 167)) | (1L << (RLIKE - 167)) | (1L << (ROLLUP - 167)) | (1L << (SEARCH - 167)) | (1L << (SECOND - 167)) | (1L << (SERVER - 167)) | (1L << (SET - 167)) | (1L << (SIMILAR - 167)) | (1L << (SIMPLE - 167)) | (1L << (STORAGE - 167)) | (1L << (STDDEV_POP - 167)) | (1L << (STDDEV_SAMP - 167)) | (1L << (SUBPARTITION - 167)) | (1L << (SUM - 167)) | (1L << (TABLESPACE - 167)) | (1L << (TEMPLATE - 167)) | (1L << (THAN - 167)) | (1L << (TIMEZONE - 167)) | (1L << (TIMEZONE_HOUR - 167)) | (1L << (TIMEZONE_MINUTE - 167)) | (1L << (TRIM - 167)) | (1L << (TO - 167)) | (1L << (UNKNOWN - 167)) | (1L << (UNLOGGED - 167)) | (1L << (VALUES - 167)) | (1L << (VAR_SAMP - 167)) | (1L << (VAR_POP - 167)) | (1L << (VARYING - 167)) | (1L << (WEEK - 167)) | (1L << (WRAPPER - 167)) | (1L << (YEAR - 167)) | (1L << (ZONE - 167)))) != 0) || ((((_la - 231)) & ~0x3f) == 0 && ((1L << (_la - 231)) & ((1L << (BOOLEAN - 231)) | (1L << (BOOL - 231)) | (1L << (BIT - 231)) | (1L << (VARBIT - 231)) | (1L << (INT1 - 231)) | (1L << (INT2 - 231)) | (1L << (INT4 - 231)) | (1L << (INT8 - 231)) | (1L << (TINYINT - 231)) | (1L << (SMALLINT - 231)) | (1L << (INT - 231)) | (1L << (INTEGER - 231)) | (1L << (BIGINT - 231)) | (1L << (FLOAT4 - 231)) | (1L << (FLOAT8 - 231)) | (1L << (REAL - 231)) | (1L << (FLOAT - 231)) | (1L << (DOUBLE - 231)) | (1L << (NUMERIC - 231)) | (1L << (DECIMAL - 231)) | (1L << (CHAR - 231)) | (1L << (VARCHAR - 231)) | (1L << (NCHAR - 231)) | (1L << (NVARCHAR - 231)) | (1L << (DATE - 231)) | (1L << (TIME - 231)) | (1L << (TIMETZ - 231)) | (1L << (TIMESTAMP - 231)) | (1L << (TIMESTAMPTZ - 231)) | (1L << (TEXT - 231)) | (1L << (VARBINARY - 231)) | (1L << (BLOB - 231)) | (1L << (BYTEA - 231)) | (1L << (INET4 - 231)) | (1L << (QUOTE - 231)))) != 0) || _la==Identifier );
					}
					break;
				case ALL:
					{
					setState(653); match(ALL);
					setState(654); match(TABLES);
					setState(655); match(IN);
					setState(656); match(SCHEMA);
					setState(658); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(657); ((Revoke_statementContext)_localctx).schema_name = identifier();
						}
						}
						setState(660); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 123)) & ~0x3f) == 0 && ((1L << (_la - 123)) & ((1L << (ADMIN - 123)) | (1L << (AVG - 123)) | (1L << (BETWEEN - 123)) | (1L << (BY - 123)) | (1L << (CLASS - 123)) | (1L << (CENTURY - 123)) | (1L << (CHARACTER - 123)) | (1L << (CHECK - 123)) | (1L << (COLLECT - 123)) | (1L << (COALESCE - 123)) | (1L << (COLUMN - 123)) | (1L << (COMMENT - 123)) | (1L << (COMMENTS - 123)) | (1L << (COMMIT - 123)) | (1L << (CONFIGURATION - 123)) | (1L << (COUNT - 123)) | (1L << (CUBE - 123)) | (1L << (DATA - 123)) | (1L << (DAY - 123)) | (1L << (DEC - 123)) | (1L << (DECADE - 123)) | (1L << (DICTIONARY - 123)) | (1L << (DOW - 123)) | (1L << (DOY - 123)) | (1L << (DROP - 123)) | (1L << (EPOCH - 123)) | (1L << (EVERY - 123)) | (1L << (EXISTS - 123)) | (1L << (EXTERNAL - 123)) | (1L << (EXTRACT - 123)) | (1L << (FAMILY - 123)) | (1L << (FILTER - 123)) | (1L << (FIRST - 123)) | (1L << (FORMAT - 123)) | (1L << (FUSION - 123)) | (1L << (GROUPING - 123)) | (1L << (HASH - 123)) | (1L << (INDEX - 123)) | (1L << (INSERT - 123)) | (1L << (INTERSECTION - 123)) | (1L << (ISODOW - 123)) | (1L << (ISOYEAR - 123)) | (1L << (LANGUAGE - 123)) | (1L << (LARGE - 123)) | (1L << (LAST - 123)) | (1L << (LESS - 123)) | (1L << (LIST - 123)) | (1L << (LOCATION - 123)) | (1L << (MATCH - 123)) | (1L << (MAX - 123)) | (1L << (MAXVALUE - 123)) | (1L << (MICROSECONDS - 123)) | (1L << (MILLENNIUM - 123)) | (1L << (MILLISECONDS - 123)) | (1L << (MIN - 123)) | (1L << (MINUTE - 123)) | (1L << (MONTH - 123)) | (1L << (NATIONAL - 123)) | (1L << (NULLIF - 123)) | (1L << (OBJECT - 123)) | (1L << (OPTION - 123)) | (1L << (OPTIONS - 123)))) != 0) || ((((_la - 187)) & ~0x3f) == 0 && ((1L << (_la - 187)) & ((1L << (OVERWRITE - 187)) | (1L << (PARSER - 187)) | (1L << (PARTIAL - 187)) | (1L << (PARTITION - 187)) | (1L << (PARTITIONS - 187)) | (1L << (PRECISION - 187)) | (1L << (PUBLIC - 187)) | (1L << (PURGE - 187)) | (1L << (QUARTER - 187)) | (1L << (RANGE - 187)) | (1L << (REGEXP - 187)) | (1L << (RLIKE - 187)) | (1L << (ROLLUP - 187)) | (1L << (SEARCH - 187)) | (1L << (SECOND - 187)) | (1L << (SERVER - 187)) | (1L << (SET - 187)) | (1L << (SIMILAR - 187)) | (1L << (SIMPLE - 187)) | (1L << (STORAGE - 187)) | (1L << (STDDEV_POP - 187)) | (1L << (STDDEV_SAMP - 187)) | (1L << (SUBPARTITION - 187)) | (1L << (SUM - 187)) | (1L << (TABLESPACE - 187)) | (1L << (TEMPLATE - 187)) | (1L << (THAN - 187)) | (1L << (TIMEZONE - 187)) | (1L << (TIMEZONE_HOUR - 187)) | (1L << (TIMEZONE_MINUTE - 187)) | (1L << (TRIM - 187)) | (1L << (TO - 187)) | (1L << (UNKNOWN - 187)) | (1L << (UNLOGGED - 187)) | (1L << (VALUES - 187)) | (1L << (VAR_SAMP - 187)) | (1L << (VAR_POP - 187)) | (1L << (VARYING - 187)) | (1L << (WEEK - 187)) | (1L << (WRAPPER - 187)) | (1L << (YEAR - 187)) | (1L << (ZONE - 187)) | (1L << (BOOLEAN - 187)) | (1L << (BOOL - 187)) | (1L << (BIT - 187)) | (1L << (VARBIT - 187)) | (1L << (INT1 - 187)) | (1L << (INT2 - 187)) | (1L << (INT4 - 187)) | (1L << (INT8 - 187)) | (1L << (TINYINT - 187)) | (1L << (SMALLINT - 187)) | (1L << (INT - 187)) | (1L << (INTEGER - 187)) | (1L << (BIGINT - 187)) | (1L << (FLOAT4 - 187)) | (1L << (FLOAT8 - 187)) | (1L << (REAL - 187)) | (1L << (FLOAT - 187)) | (1L << (DOUBLE - 187)) | (1L << (NUMERIC - 187)))) != 0) || ((((_la - 251)) & ~0x3f) == 0 && ((1L << (_la - 251)) & ((1L << (DECIMAL - 251)) | (1L << (CHAR - 251)) | (1L << (VARCHAR - 251)) | (1L << (NCHAR - 251)) | (1L << (NVARCHAR - 251)) | (1L << (DATE - 251)) | (1L << (TIME - 251)) | (1L << (TIMETZ - 251)) | (1L << (TIMESTAMP - 251)) | (1L << (TIMESTAMPTZ - 251)) | (1L << (TEXT - 251)) | (1L << (VARBINARY - 251)) | (1L << (BLOB - 251)) | (1L << (BYTEA - 251)) | (1L << (INET4 - 251)) | (1L << (QUOTE - 251)) | (1L << (Identifier - 251)))) != 0) );
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(664); revoke_from_cascade_restrict();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(666); match(REVOKE);
				setState(670);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(667); match(GRANT);
					setState(668); match(OPTION);
					setState(669); match(FOR);
					}
				}

				setState(703);
				switch (_input.LA(1)) {
				case REFERENCES:
				case SELECT:
				case UPDATE:
				case INSERT:
					{
					setState(684); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(672);
						_la = _input.LA(1);
						if ( !(((((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & ((1L << (REFERENCES - 89)) | (1L << (SELECT - 89)) | (1L << (UPDATE - 89)))) != 0) || _la==INSERT) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(673); match(LEFT_PAREN);
						setState(678); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(674); ((Revoke_statementContext)_localctx).column = identifier();
							setState(676);
							_la = _input.LA(1);
							if (_la==COMMA) {
								{
								setState(675); match(COMMA);
								}
							}

							}
							}
							setState(680); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( ((((_la - 123)) & ~0x3f) == 0 && ((1L << (_la - 123)) & ((1L << (ADMIN - 123)) | (1L << (AVG - 123)) | (1L << (BETWEEN - 123)) | (1L << (BY - 123)) | (1L << (CLASS - 123)) | (1L << (CENTURY - 123)) | (1L << (CHARACTER - 123)) | (1L << (CHECK - 123)) | (1L << (COLLECT - 123)) | (1L << (COALESCE - 123)) | (1L << (COLUMN - 123)) | (1L << (COMMENT - 123)) | (1L << (COMMENTS - 123)) | (1L << (COMMIT - 123)) | (1L << (CONFIGURATION - 123)) | (1L << (COUNT - 123)) | (1L << (CUBE - 123)) | (1L << (DATA - 123)) | (1L << (DAY - 123)) | (1L << (DEC - 123)) | (1L << (DECADE - 123)) | (1L << (DICTIONARY - 123)) | (1L << (DOW - 123)) | (1L << (DOY - 123)) | (1L << (DROP - 123)) | (1L << (EPOCH - 123)) | (1L << (EVERY - 123)) | (1L << (EXISTS - 123)) | (1L << (EXTERNAL - 123)) | (1L << (EXTRACT - 123)) | (1L << (FAMILY - 123)) | (1L << (FILTER - 123)) | (1L << (FIRST - 123)) | (1L << (FORMAT - 123)) | (1L << (FUSION - 123)) | (1L << (GROUPING - 123)) | (1L << (HASH - 123)) | (1L << (INDEX - 123)) | (1L << (INSERT - 123)) | (1L << (INTERSECTION - 123)) | (1L << (ISODOW - 123)) | (1L << (ISOYEAR - 123)) | (1L << (LANGUAGE - 123)) | (1L << (LARGE - 123)) | (1L << (LAST - 123)) | (1L << (LESS - 123)) | (1L << (LIST - 123)) | (1L << (LOCATION - 123)) | (1L << (MATCH - 123)) | (1L << (MAX - 123)) | (1L << (MAXVALUE - 123)) | (1L << (MICROSECONDS - 123)) | (1L << (MILLENNIUM - 123)) | (1L << (MILLISECONDS - 123)) | (1L << (MIN - 123)) | (1L << (MINUTE - 123)) | (1L << (MONTH - 123)) | (1L << (NATIONAL - 123)) | (1L << (NULLIF - 123)) | (1L << (OBJECT - 123)) | (1L << (OPTION - 123)) | (1L << (OPTIONS - 123)))) != 0) || ((((_la - 187)) & ~0x3f) == 0 && ((1L << (_la - 187)) & ((1L << (OVERWRITE - 187)) | (1L << (PARSER - 187)) | (1L << (PARTIAL - 187)) | (1L << (PARTITION - 187)) | (1L << (PARTITIONS - 187)) | (1L << (PRECISION - 187)) | (1L << (PUBLIC - 187)) | (1L << (PURGE - 187)) | (1L << (QUARTER - 187)) | (1L << (RANGE - 187)) | (1L << (REGEXP - 187)) | (1L << (RLIKE - 187)) | (1L << (ROLLUP - 187)) | (1L << (SEARCH - 187)) | (1L << (SECOND - 187)) | (1L << (SERVER - 187)) | (1L << (SET - 187)) | (1L << (SIMILAR - 187)) | (1L << (SIMPLE - 187)) | (1L << (STORAGE - 187)) | (1L << (STDDEV_POP - 187)) | (1L << (STDDEV_SAMP - 187)) | (1L << (SUBPARTITION - 187)) | (1L << (SUM - 187)) | (1L << (TABLESPACE - 187)) | (1L << (TEMPLATE - 187)) | (1L << (THAN - 187)) | (1L << (TIMEZONE - 187)) | (1L << (TIMEZONE_HOUR - 187)) | (1L << (TIMEZONE_MINUTE - 187)) | (1L << (TRIM - 187)) | (1L << (TO - 187)) | (1L << (UNKNOWN - 187)) | (1L << (UNLOGGED - 187)) | (1L << (VALUES - 187)) | (1L << (VAR_SAMP - 187)) | (1L << (VAR_POP - 187)) | (1L << (VARYING - 187)) | (1L << (WEEK - 187)) | (1L << (WRAPPER - 187)) | (1L << (YEAR - 187)) | (1L << (ZONE - 187)) | (1L << (BOOLEAN - 187)) | (1L << (BOOL - 187)) | (1L << (BIT - 187)) | (1L << (VARBIT - 187)) | (1L << (INT1 - 187)) | (1L << (INT2 - 187)) | (1L << (INT4 - 187)) | (1L << (INT8 - 187)) | (1L << (TINYINT - 187)) | (1L << (SMALLINT - 187)) | (1L << (INT - 187)) | (1L << (INTEGER - 187)) | (1L << (BIGINT - 187)) | (1L << (FLOAT4 - 187)) | (1L << (FLOAT8 - 187)) | (1L << (REAL - 187)) | (1L << (FLOAT - 187)) | (1L << (DOUBLE - 187)) | (1L << (NUMERIC - 187)))) != 0) || ((((_la - 251)) & ~0x3f) == 0 && ((1L << (_la - 251)) & ((1L << (DECIMAL - 251)) | (1L << (CHAR - 251)) | (1L << (VARCHAR - 251)) | (1L << (NCHAR - 251)) | (1L << (NVARCHAR - 251)) | (1L << (DATE - 251)) | (1L << (TIME - 251)) | (1L << (TIMETZ - 251)) | (1L << (TIMESTAMP - 251)) | (1L << (TIMESTAMPTZ - 251)) | (1L << (TEXT - 251)) | (1L << (VARBINARY - 251)) | (1L << (BLOB - 251)) | (1L << (BYTEA - 251)) | (1L << (INET4 - 251)) | (1L << (QUOTE - 251)) | (1L << (Identifier - 251)))) != 0) );
						setState(682); match(RIGHT_PAREN);
						}
						}
						setState(686); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & ((1L << (REFERENCES - 89)) | (1L << (SELECT - 89)) | (1L << (UPDATE - 89)))) != 0) || _la==INSERT );
					}
					break;
				case ALL:
					{
					setState(688); match(ALL);
					setState(690);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(689); match(PRIVILEGES);
						}
					}

					setState(692); match(LEFT_PAREN);
					setState(697); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(693); ((Revoke_statementContext)_localctx).column = identifier();
						setState(695);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(694); match(COMMA);
							}
						}

						}
						}
						setState(699); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 123)) & ~0x3f) == 0 && ((1L << (_la - 123)) & ((1L << (ADMIN - 123)) | (1L << (AVG - 123)) | (1L << (BETWEEN - 123)) | (1L << (BY - 123)) | (1L << (CLASS - 123)) | (1L << (CENTURY - 123)) | (1L << (CHARACTER - 123)) | (1L << (CHECK - 123)) | (1L << (COLLECT - 123)) | (1L << (COALESCE - 123)) | (1L << (COLUMN - 123)) | (1L << (COMMENT - 123)) | (1L << (COMMENTS - 123)) | (1L << (COMMIT - 123)) | (1L << (CONFIGURATION - 123)) | (1L << (COUNT - 123)) | (1L << (CUBE - 123)) | (1L << (DATA - 123)) | (1L << (DAY - 123)) | (1L << (DEC - 123)) | (1L << (DECADE - 123)) | (1L << (DICTIONARY - 123)) | (1L << (DOW - 123)) | (1L << (DOY - 123)) | (1L << (DROP - 123)) | (1L << (EPOCH - 123)) | (1L << (EVERY - 123)) | (1L << (EXISTS - 123)) | (1L << (EXTERNAL - 123)) | (1L << (EXTRACT - 123)) | (1L << (FAMILY - 123)) | (1L << (FILTER - 123)) | (1L << (FIRST - 123)) | (1L << (FORMAT - 123)) | (1L << (FUSION - 123)) | (1L << (GROUPING - 123)) | (1L << (HASH - 123)) | (1L << (INDEX - 123)) | (1L << (INSERT - 123)) | (1L << (INTERSECTION - 123)) | (1L << (ISODOW - 123)) | (1L << (ISOYEAR - 123)) | (1L << (LANGUAGE - 123)) | (1L << (LARGE - 123)) | (1L << (LAST - 123)) | (1L << (LESS - 123)) | (1L << (LIST - 123)) | (1L << (LOCATION - 123)) | (1L << (MATCH - 123)) | (1L << (MAX - 123)) | (1L << (MAXVALUE - 123)) | (1L << (MICROSECONDS - 123)) | (1L << (MILLENNIUM - 123)) | (1L << (MILLISECONDS - 123)) | (1L << (MIN - 123)) | (1L << (MINUTE - 123)) | (1L << (MONTH - 123)) | (1L << (NATIONAL - 123)) | (1L << (NULLIF - 123)) | (1L << (OBJECT - 123)) | (1L << (OPTION - 123)) | (1L << (OPTIONS - 123)))) != 0) || ((((_la - 187)) & ~0x3f) == 0 && ((1L << (_la - 187)) & ((1L << (OVERWRITE - 187)) | (1L << (PARSER - 187)) | (1L << (PARTIAL - 187)) | (1L << (PARTITION - 187)) | (1L << (PARTITIONS - 187)) | (1L << (PRECISION - 187)) | (1L << (PUBLIC - 187)) | (1L << (PURGE - 187)) | (1L << (QUARTER - 187)) | (1L << (RANGE - 187)) | (1L << (REGEXP - 187)) | (1L << (RLIKE - 187)) | (1L << (ROLLUP - 187)) | (1L << (SEARCH - 187)) | (1L << (SECOND - 187)) | (1L << (SERVER - 187)) | (1L << (SET - 187)) | (1L << (SIMILAR - 187)) | (1L << (SIMPLE - 187)) | (1L << (STORAGE - 187)) | (1L << (STDDEV_POP - 187)) | (1L << (STDDEV_SAMP - 187)) | (1L << (SUBPARTITION - 187)) | (1L << (SUM - 187)) | (1L << (TABLESPACE - 187)) | (1L << (TEMPLATE - 187)) | (1L << (THAN - 187)) | (1L << (TIMEZONE - 187)) | (1L << (TIMEZONE_HOUR - 187)) | (1L << (TIMEZONE_MINUTE - 187)) | (1L << (TRIM - 187)) | (1L << (TO - 187)) | (1L << (UNKNOWN - 187)) | (1L << (UNLOGGED - 187)) | (1L << (VALUES - 187)) | (1L << (VAR_SAMP - 187)) | (1L << (VAR_POP - 187)) | (1L << (VARYING - 187)) | (1L << (WEEK - 187)) | (1L << (WRAPPER - 187)) | (1L << (YEAR - 187)) | (1L << (ZONE - 187)) | (1L << (BOOLEAN - 187)) | (1L << (BOOL - 187)) | (1L << (BIT - 187)) | (1L << (VARBIT - 187)) | (1L << (INT1 - 187)) | (1L << (INT2 - 187)) | (1L << (INT4 - 187)) | (1L << (INT8 - 187)) | (1L << (TINYINT - 187)) | (1L << (SMALLINT - 187)) | (1L << (INT - 187)) | (1L << (INTEGER - 187)) | (1L << (BIGINT - 187)) | (1L << (FLOAT4 - 187)) | (1L << (FLOAT8 - 187)) | (1L << (REAL - 187)) | (1L << (FLOAT - 187)) | (1L << (DOUBLE - 187)) | (1L << (NUMERIC - 187)))) != 0) || ((((_la - 251)) & ~0x3f) == 0 && ((1L << (_la - 251)) & ((1L << (DECIMAL - 251)) | (1L << (CHAR - 251)) | (1L << (VARCHAR - 251)) | (1L << (NCHAR - 251)) | (1L << (NVARCHAR - 251)) | (1L << (DATE - 251)) | (1L << (TIME - 251)) | (1L << (TIMETZ - 251)) | (1L << (TIMESTAMP - 251)) | (1L << (TIMESTAMPTZ - 251)) | (1L << (TEXT - 251)) | (1L << (VARBINARY - 251)) | (1L << (BLOB - 251)) | (1L << (BYTEA - 251)) | (1L << (INET4 - 251)) | (1L << (QUOTE - 251)) | (1L << (Identifier - 251)))) != 0) );
					setState(701); match(RIGHT_PAREN);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(705); match(ON);
				setState(707);
				_la = _input.LA(1);
				if (_la==TABLE) {
					{
					setState(706); match(TABLE);
					}
				}

				setState(713); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(709); ((Revoke_statementContext)_localctx).table_name = schema_qualified_name();
					setState(711);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(710); match(COMMA);
						}
					}

					}
					}
					setState(715); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 123)) & ~0x3f) == 0 && ((1L << (_la - 123)) & ((1L << (ADMIN - 123)) | (1L << (AVG - 123)) | (1L << (BETWEEN - 123)) | (1L << (BY - 123)) | (1L << (CLASS - 123)) | (1L << (CENTURY - 123)) | (1L << (CHARACTER - 123)) | (1L << (CHECK - 123)) | (1L << (COLLECT - 123)) | (1L << (COALESCE - 123)) | (1L << (COLUMN - 123)) | (1L << (COMMENT - 123)) | (1L << (COMMENTS - 123)) | (1L << (COMMIT - 123)) | (1L << (CONFIGURATION - 123)) | (1L << (COUNT - 123)) | (1L << (CUBE - 123)) | (1L << (DATA - 123)) | (1L << (DAY - 123)) | (1L << (DEC - 123)) | (1L << (DECADE - 123)) | (1L << (DICTIONARY - 123)) | (1L << (DOW - 123)) | (1L << (DOY - 123)) | (1L << (DROP - 123)) | (1L << (EPOCH - 123)) | (1L << (EVERY - 123)) | (1L << (EXISTS - 123)) | (1L << (EXTERNAL - 123)) | (1L << (EXTRACT - 123)) | (1L << (FAMILY - 123)) | (1L << (FILTER - 123)) | (1L << (FIRST - 123)) | (1L << (FORMAT - 123)) | (1L << (FUSION - 123)) | (1L << (GROUPING - 123)) | (1L << (HASH - 123)) | (1L << (INDEX - 123)) | (1L << (INSERT - 123)) | (1L << (INTERSECTION - 123)) | (1L << (ISODOW - 123)) | (1L << (ISOYEAR - 123)) | (1L << (LANGUAGE - 123)) | (1L << (LARGE - 123)) | (1L << (LAST - 123)) | (1L << (LESS - 123)) | (1L << (LIST - 123)) | (1L << (LOCATION - 123)) | (1L << (MATCH - 123)) | (1L << (MAX - 123)) | (1L << (MAXVALUE - 123)) | (1L << (MICROSECONDS - 123)) | (1L << (MILLENNIUM - 123)) | (1L << (MILLISECONDS - 123)) | (1L << (MIN - 123)) | (1L << (MINUTE - 123)) | (1L << (MONTH - 123)) | (1L << (NATIONAL - 123)) | (1L << (NULLIF - 123)) | (1L << (OBJECT - 123)) | (1L << (OPTION - 123)) | (1L << (OPTIONS - 123)))) != 0) || ((((_la - 187)) & ~0x3f) == 0 && ((1L << (_la - 187)) & ((1L << (OVERWRITE - 187)) | (1L << (PARSER - 187)) | (1L << (PARTIAL - 187)) | (1L << (PARTITION - 187)) | (1L << (PARTITIONS - 187)) | (1L << (PRECISION - 187)) | (1L << (PUBLIC - 187)) | (1L << (PURGE - 187)) | (1L << (QUARTER - 187)) | (1L << (RANGE - 187)) | (1L << (REGEXP - 187)) | (1L << (RLIKE - 187)) | (1L << (ROLLUP - 187)) | (1L << (SEARCH - 187)) | (1L << (SECOND - 187)) | (1L << (SERVER - 187)) | (1L << (SET - 187)) | (1L << (SIMILAR - 187)) | (1L << (SIMPLE - 187)) | (1L << (STORAGE - 187)) | (1L << (STDDEV_POP - 187)) | (1L << (STDDEV_SAMP - 187)) | (1L << (SUBPARTITION - 187)) | (1L << (SUM - 187)) | (1L << (TABLESPACE - 187)) | (1L << (TEMPLATE - 187)) | (1L << (THAN - 187)) | (1L << (TIMEZONE - 187)) | (1L << (TIMEZONE_HOUR - 187)) | (1L << (TIMEZONE_MINUTE - 187)) | (1L << (TRIM - 187)) | (1L << (TO - 187)) | (1L << (UNKNOWN - 187)) | (1L << (UNLOGGED - 187)) | (1L << (VALUES - 187)) | (1L << (VAR_SAMP - 187)) | (1L << (VAR_POP - 187)) | (1L << (VARYING - 187)) | (1L << (WEEK - 187)) | (1L << (WRAPPER - 187)) | (1L << (YEAR - 187)) | (1L << (ZONE - 187)) | (1L << (BOOLEAN - 187)) | (1L << (BOOL - 187)) | (1L << (BIT - 187)) | (1L << (VARBIT - 187)) | (1L << (INT1 - 187)) | (1L << (INT2 - 187)) | (1L << (INT4 - 187)) | (1L << (INT8 - 187)) | (1L << (TINYINT - 187)) | (1L << (SMALLINT - 187)) | (1L << (INT - 187)) | (1L << (INTEGER - 187)) | (1L << (BIGINT - 187)) | (1L << (FLOAT4 - 187)) | (1L << (FLOAT8 - 187)) | (1L << (REAL - 187)) | (1L << (FLOAT - 187)) | (1L << (DOUBLE - 187)) | (1L << (NUMERIC - 187)))) != 0) || ((((_la - 251)) & ~0x3f) == 0 && ((1L << (_la - 251)) & ((1L << (DECIMAL - 251)) | (1L << (CHAR - 251)) | (1L << (VARCHAR - 251)) | (1L << (NCHAR - 251)) | (1L << (NVARCHAR - 251)) | (1L << (DATE - 251)) | (1L << (TIME - 251)) | (1L << (TIMETZ - 251)) | (1L << (TIMESTAMP - 251)) | (1L << (TIMESTAMPTZ - 251)) | (1L << (TEXT - 251)) | (1L << (VARBINARY - 251)) | (1L << (BLOB - 251)) | (1L << (BYTEA - 251)) | (1L << (INET4 - 251)) | (1L << (QUOTE - 251)) | (1L << (Identifier - 251)))) != 0) );
				setState(717); revoke_from_cascade_restrict();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(719); match(REVOKE);
				setState(723);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(720); match(GRANT);
					setState(721); match(OPTION);
					setState(722); match(FOR);
					}
				}

				setState(734);
				switch (_input.LA(1)) {
				case SELECT:
				case UPDATE:
				case USAGE:
					{
					setState(726); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(725);
						_la = _input.LA(1);
						if ( !(((((_la - 98)) & ~0x3f) == 0 && ((1L << (_la - 98)) & ((1L << (SELECT - 98)) | (1L << (UPDATE - 98)) | (1L << (USAGE - 98)))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
						}
						setState(728); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 98)) & ~0x3f) == 0 && ((1L << (_la - 98)) & ((1L << (SELECT - 98)) | (1L << (UPDATE - 98)) | (1L << (USAGE - 98)))) != 0) );
					}
					break;
				case ALL:
					{
					setState(730); match(ALL);
					setState(732);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(731); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(736); match(ON);
				setState(758);
				switch (_input.LA(1)) {
				case SEQUENCE:
					{
					setState(737); match(SEQUENCE);
					setState(742); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(738); ((Revoke_statementContext)_localctx).sequence_name = schema_qualified_name();
						setState(740);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(739); match(COMMA);
							}
						}

						}
						}
						setState(744); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 123)) & ~0x3f) == 0 && ((1L << (_la - 123)) & ((1L << (ADMIN - 123)) | (1L << (AVG - 123)) | (1L << (BETWEEN - 123)) | (1L << (BY - 123)) | (1L << (CLASS - 123)) | (1L << (CENTURY - 123)) | (1L << (CHARACTER - 123)) | (1L << (CHECK - 123)) | (1L << (COLLECT - 123)) | (1L << (COALESCE - 123)) | (1L << (COLUMN - 123)) | (1L << (COMMENT - 123)) | (1L << (COMMENTS - 123)) | (1L << (COMMIT - 123)) | (1L << (CONFIGURATION - 123)) | (1L << (COUNT - 123)) | (1L << (CUBE - 123)) | (1L << (DATA - 123)) | (1L << (DAY - 123)) | (1L << (DEC - 123)) | (1L << (DECADE - 123)) | (1L << (DICTIONARY - 123)) | (1L << (DOW - 123)) | (1L << (DOY - 123)) | (1L << (DROP - 123)) | (1L << (EPOCH - 123)) | (1L << (EVERY - 123)) | (1L << (EXISTS - 123)) | (1L << (EXTERNAL - 123)) | (1L << (EXTRACT - 123)) | (1L << (FAMILY - 123)) | (1L << (FILTER - 123)) | (1L << (FIRST - 123)) | (1L << (FORMAT - 123)) | (1L << (FUSION - 123)) | (1L << (GROUPING - 123)) | (1L << (HASH - 123)) | (1L << (INDEX - 123)) | (1L << (INSERT - 123)) | (1L << (INTERSECTION - 123)) | (1L << (ISODOW - 123)) | (1L << (ISOYEAR - 123)) | (1L << (LANGUAGE - 123)) | (1L << (LARGE - 123)) | (1L << (LAST - 123)) | (1L << (LESS - 123)) | (1L << (LIST - 123)) | (1L << (LOCATION - 123)) | (1L << (MATCH - 123)) | (1L << (MAX - 123)) | (1L << (MAXVALUE - 123)) | (1L << (MICROSECONDS - 123)) | (1L << (MILLENNIUM - 123)) | (1L << (MILLISECONDS - 123)) | (1L << (MIN - 123)) | (1L << (MINUTE - 123)) | (1L << (MONTH - 123)) | (1L << (NATIONAL - 123)) | (1L << (NULLIF - 123)) | (1L << (OBJECT - 123)) | (1L << (OPTION - 123)) | (1L << (OPTIONS - 123)))) != 0) || ((((_la - 187)) & ~0x3f) == 0 && ((1L << (_la - 187)) & ((1L << (OVERWRITE - 187)) | (1L << (PARSER - 187)) | (1L << (PARTIAL - 187)) | (1L << (PARTITION - 187)) | (1L << (PARTITIONS - 187)) | (1L << (PRECISION - 187)) | (1L << (PUBLIC - 187)) | (1L << (PURGE - 187)) | (1L << (QUARTER - 187)) | (1L << (RANGE - 187)) | (1L << (REGEXP - 187)) | (1L << (RLIKE - 187)) | (1L << (ROLLUP - 187)) | (1L << (SEARCH - 187)) | (1L << (SECOND - 187)) | (1L << (SERVER - 187)) | (1L << (SET - 187)) | (1L << (SIMILAR - 187)) | (1L << (SIMPLE - 187)) | (1L << (STORAGE - 187)) | (1L << (STDDEV_POP - 187)) | (1L << (STDDEV_SAMP - 187)) | (1L << (SUBPARTITION - 187)) | (1L << (SUM - 187)) | (1L << (TABLESPACE - 187)) | (1L << (TEMPLATE - 187)) | (1L << (THAN - 187)) | (1L << (TIMEZONE - 187)) | (1L << (TIMEZONE_HOUR - 187)) | (1L << (TIMEZONE_MINUTE - 187)) | (1L << (TRIM - 187)) | (1L << (TO - 187)) | (1L << (UNKNOWN - 187)) | (1L << (UNLOGGED - 187)) | (1L << (VALUES - 187)) | (1L << (VAR_SAMP - 187)) | (1L << (VAR_POP - 187)) | (1L << (VARYING - 187)) | (1L << (WEEK - 187)) | (1L << (WRAPPER - 187)) | (1L << (YEAR - 187)) | (1L << (ZONE - 187)) | (1L << (BOOLEAN - 187)) | (1L << (BOOL - 187)) | (1L << (BIT - 187)) | (1L << (VARBIT - 187)) | (1L << (INT1 - 187)) | (1L << (INT2 - 187)) | (1L << (INT4 - 187)) | (1L << (INT8 - 187)) | (1L << (TINYINT - 187)) | (1L << (SMALLINT - 187)) | (1L << (INT - 187)) | (1L << (INTEGER - 187)) | (1L << (BIGINT - 187)) | (1L << (FLOAT4 - 187)) | (1L << (FLOAT8 - 187)) | (1L << (REAL - 187)) | (1L << (FLOAT - 187)) | (1L << (DOUBLE - 187)) | (1L << (NUMERIC - 187)))) != 0) || ((((_la - 251)) & ~0x3f) == 0 && ((1L << (_la - 251)) & ((1L << (DECIMAL - 251)) | (1L << (CHAR - 251)) | (1L << (VARCHAR - 251)) | (1L << (NCHAR - 251)) | (1L << (NVARCHAR - 251)) | (1L << (DATE - 251)) | (1L << (TIME - 251)) | (1L << (TIMETZ - 251)) | (1L << (TIMESTAMP - 251)) | (1L << (TIMESTAMPTZ - 251)) | (1L << (TEXT - 251)) | (1L << (VARBINARY - 251)) | (1L << (BLOB - 251)) | (1L << (BYTEA - 251)) | (1L << (INET4 - 251)) | (1L << (QUOTE - 251)) | (1L << (Identifier - 251)))) != 0) );
					}
					break;
				case ALL:
					{
					setState(746); match(ALL);
					setState(747); match(SEQUENCES);
					setState(748); match(IN);
					setState(749); match(SCHEMA);
					setState(754); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(750); ((Revoke_statementContext)_localctx).schema_name = identifier();
						setState(752);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(751); match(COMMA);
							}
						}

						}
						}
						setState(756); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 123)) & ~0x3f) == 0 && ((1L << (_la - 123)) & ((1L << (ADMIN - 123)) | (1L << (AVG - 123)) | (1L << (BETWEEN - 123)) | (1L << (BY - 123)) | (1L << (CLASS - 123)) | (1L << (CENTURY - 123)) | (1L << (CHARACTER - 123)) | (1L << (CHECK - 123)) | (1L << (COLLECT - 123)) | (1L << (COALESCE - 123)) | (1L << (COLUMN - 123)) | (1L << (COMMENT - 123)) | (1L << (COMMENTS - 123)) | (1L << (COMMIT - 123)) | (1L << (CONFIGURATION - 123)) | (1L << (COUNT - 123)) | (1L << (CUBE - 123)) | (1L << (DATA - 123)) | (1L << (DAY - 123)) | (1L << (DEC - 123)) | (1L << (DECADE - 123)) | (1L << (DICTIONARY - 123)) | (1L << (DOW - 123)) | (1L << (DOY - 123)) | (1L << (DROP - 123)) | (1L << (EPOCH - 123)) | (1L << (EVERY - 123)) | (1L << (EXISTS - 123)) | (1L << (EXTERNAL - 123)) | (1L << (EXTRACT - 123)) | (1L << (FAMILY - 123)) | (1L << (FILTER - 123)) | (1L << (FIRST - 123)) | (1L << (FORMAT - 123)) | (1L << (FUSION - 123)) | (1L << (GROUPING - 123)) | (1L << (HASH - 123)) | (1L << (INDEX - 123)) | (1L << (INSERT - 123)) | (1L << (INTERSECTION - 123)) | (1L << (ISODOW - 123)) | (1L << (ISOYEAR - 123)) | (1L << (LANGUAGE - 123)) | (1L << (LARGE - 123)) | (1L << (LAST - 123)) | (1L << (LESS - 123)) | (1L << (LIST - 123)) | (1L << (LOCATION - 123)) | (1L << (MATCH - 123)) | (1L << (MAX - 123)) | (1L << (MAXVALUE - 123)) | (1L << (MICROSECONDS - 123)) | (1L << (MILLENNIUM - 123)) | (1L << (MILLISECONDS - 123)) | (1L << (MIN - 123)) | (1L << (MINUTE - 123)) | (1L << (MONTH - 123)) | (1L << (NATIONAL - 123)) | (1L << (NULLIF - 123)) | (1L << (OBJECT - 123)) | (1L << (OPTION - 123)) | (1L << (OPTIONS - 123)))) != 0) || ((((_la - 187)) & ~0x3f) == 0 && ((1L << (_la - 187)) & ((1L << (OVERWRITE - 187)) | (1L << (PARSER - 187)) | (1L << (PARTIAL - 187)) | (1L << (PARTITION - 187)) | (1L << (PARTITIONS - 187)) | (1L << (PRECISION - 187)) | (1L << (PUBLIC - 187)) | (1L << (PURGE - 187)) | (1L << (QUARTER - 187)) | (1L << (RANGE - 187)) | (1L << (REGEXP - 187)) | (1L << (RLIKE - 187)) | (1L << (ROLLUP - 187)) | (1L << (SEARCH - 187)) | (1L << (SECOND - 187)) | (1L << (SERVER - 187)) | (1L << (SET - 187)) | (1L << (SIMILAR - 187)) | (1L << (SIMPLE - 187)) | (1L << (STORAGE - 187)) | (1L << (STDDEV_POP - 187)) | (1L << (STDDEV_SAMP - 187)) | (1L << (SUBPARTITION - 187)) | (1L << (SUM - 187)) | (1L << (TABLESPACE - 187)) | (1L << (TEMPLATE - 187)) | (1L << (THAN - 187)) | (1L << (TIMEZONE - 187)) | (1L << (TIMEZONE_HOUR - 187)) | (1L << (TIMEZONE_MINUTE - 187)) | (1L << (TRIM - 187)) | (1L << (TO - 187)) | (1L << (UNKNOWN - 187)) | (1L << (UNLOGGED - 187)) | (1L << (VALUES - 187)) | (1L << (VAR_SAMP - 187)) | (1L << (VAR_POP - 187)) | (1L << (VARYING - 187)) | (1L << (WEEK - 187)) | (1L << (WRAPPER - 187)) | (1L << (YEAR - 187)) | (1L << (ZONE - 187)) | (1L << (BOOLEAN - 187)) | (1L << (BOOL - 187)) | (1L << (BIT - 187)) | (1L << (VARBIT - 187)) | (1L << (INT1 - 187)) | (1L << (INT2 - 187)) | (1L << (INT4 - 187)) | (1L << (INT8 - 187)) | (1L << (TINYINT - 187)) | (1L << (SMALLINT - 187)) | (1L << (INT - 187)) | (1L << (INTEGER - 187)) | (1L << (BIGINT - 187)) | (1L << (FLOAT4 - 187)) | (1L << (FLOAT8 - 187)) | (1L << (REAL - 187)) | (1L << (FLOAT - 187)) | (1L << (DOUBLE - 187)) | (1L << (NUMERIC - 187)))) != 0) || ((((_la - 251)) & ~0x3f) == 0 && ((1L << (_la - 251)) & ((1L << (DECIMAL - 251)) | (1L << (CHAR - 251)) | (1L << (VARCHAR - 251)) | (1L << (NCHAR - 251)) | (1L << (NVARCHAR - 251)) | (1L << (DATE - 251)) | (1L << (TIME - 251)) | (1L << (TIMETZ - 251)) | (1L << (TIMESTAMP - 251)) | (1L << (TIMESTAMPTZ - 251)) | (1L << (TEXT - 251)) | (1L << (VARBINARY - 251)) | (1L << (BLOB - 251)) | (1L << (BYTEA - 251)) | (1L << (INET4 - 251)) | (1L << (QUOTE - 251)) | (1L << (Identifier - 251)))) != 0) );
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(760); revoke_from_cascade_restrict();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(762); match(REVOKE);
				setState(766);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(763); match(GRANT);
					setState(764); match(OPTION);
					setState(765); match(FOR);
					}
				}

				setState(777);
				switch (_input.LA(1)) {
				case CONNECT:
				case CREATE:
				case TEMP:
				case TEMPORARY:
					{
					setState(769); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(768);
						_la = _input.LA(1);
						if ( !(_la==CONNECT || _la==CREATE || _la==TEMP || _la==TEMPORARY) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
						}
						setState(771); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==CONNECT || _la==CREATE || _la==TEMP || _la==TEMPORARY );
					}
					break;
				case ALL:
					{
					setState(773); match(ALL);
					setState(775);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(774); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(779); match(ON);
				setState(780); match(DATABASE);
				setState(785); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(781); ((Revoke_statementContext)_localctx).database_name = identifier();
					setState(783);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(782); match(COMMA);
						}
					}

					}
					}
					setState(787); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 123)) & ~0x3f) == 0 && ((1L << (_la - 123)) & ((1L << (ADMIN - 123)) | (1L << (AVG - 123)) | (1L << (BETWEEN - 123)) | (1L << (BY - 123)) | (1L << (CLASS - 123)) | (1L << (CENTURY - 123)) | (1L << (CHARACTER - 123)) | (1L << (CHECK - 123)) | (1L << (COLLECT - 123)) | (1L << (COALESCE - 123)) | (1L << (COLUMN - 123)) | (1L << (COMMENT - 123)) | (1L << (COMMENTS - 123)) | (1L << (COMMIT - 123)) | (1L << (CONFIGURATION - 123)) | (1L << (COUNT - 123)) | (1L << (CUBE - 123)) | (1L << (DATA - 123)) | (1L << (DAY - 123)) | (1L << (DEC - 123)) | (1L << (DECADE - 123)) | (1L << (DICTIONARY - 123)) | (1L << (DOW - 123)) | (1L << (DOY - 123)) | (1L << (DROP - 123)) | (1L << (EPOCH - 123)) | (1L << (EVERY - 123)) | (1L << (EXISTS - 123)) | (1L << (EXTERNAL - 123)) | (1L << (EXTRACT - 123)) | (1L << (FAMILY - 123)) | (1L << (FILTER - 123)) | (1L << (FIRST - 123)) | (1L << (FORMAT - 123)) | (1L << (FUSION - 123)) | (1L << (GROUPING - 123)) | (1L << (HASH - 123)) | (1L << (INDEX - 123)) | (1L << (INSERT - 123)) | (1L << (INTERSECTION - 123)) | (1L << (ISODOW - 123)) | (1L << (ISOYEAR - 123)) | (1L << (LANGUAGE - 123)) | (1L << (LARGE - 123)) | (1L << (LAST - 123)) | (1L << (LESS - 123)) | (1L << (LIST - 123)) | (1L << (LOCATION - 123)) | (1L << (MATCH - 123)) | (1L << (MAX - 123)) | (1L << (MAXVALUE - 123)) | (1L << (MICROSECONDS - 123)) | (1L << (MILLENNIUM - 123)) | (1L << (MILLISECONDS - 123)) | (1L << (MIN - 123)) | (1L << (MINUTE - 123)) | (1L << (MONTH - 123)) | (1L << (NATIONAL - 123)) | (1L << (NULLIF - 123)) | (1L << (OBJECT - 123)) | (1L << (OPTION - 123)) | (1L << (OPTIONS - 123)))) != 0) || ((((_la - 187)) & ~0x3f) == 0 && ((1L << (_la - 187)) & ((1L << (OVERWRITE - 187)) | (1L << (PARSER - 187)) | (1L << (PARTIAL - 187)) | (1L << (PARTITION - 187)) | (1L << (PARTITIONS - 187)) | (1L << (PRECISION - 187)) | (1L << (PUBLIC - 187)) | (1L << (PURGE - 187)) | (1L << (QUARTER - 187)) | (1L << (RANGE - 187)) | (1L << (REGEXP - 187)) | (1L << (RLIKE - 187)) | (1L << (ROLLUP - 187)) | (1L << (SEARCH - 187)) | (1L << (SECOND - 187)) | (1L << (SERVER - 187)) | (1L << (SET - 187)) | (1L << (SIMILAR - 187)) | (1L << (SIMPLE - 187)) | (1L << (STORAGE - 187)) | (1L << (STDDEV_POP - 187)) | (1L << (STDDEV_SAMP - 187)) | (1L << (SUBPARTITION - 187)) | (1L << (SUM - 187)) | (1L << (TABLESPACE - 187)) | (1L << (TEMPLATE - 187)) | (1L << (THAN - 187)) | (1L << (TIMEZONE - 187)) | (1L << (TIMEZONE_HOUR - 187)) | (1L << (TIMEZONE_MINUTE - 187)) | (1L << (TRIM - 187)) | (1L << (TO - 187)) | (1L << (UNKNOWN - 187)) | (1L << (UNLOGGED - 187)) | (1L << (VALUES - 187)) | (1L << (VAR_SAMP - 187)) | (1L << (VAR_POP - 187)) | (1L << (VARYING - 187)) | (1L << (WEEK - 187)) | (1L << (WRAPPER - 187)) | (1L << (YEAR - 187)) | (1L << (ZONE - 187)) | (1L << (BOOLEAN - 187)) | (1L << (BOOL - 187)) | (1L << (BIT - 187)) | (1L << (VARBIT - 187)) | (1L << (INT1 - 187)) | (1L << (INT2 - 187)) | (1L << (INT4 - 187)) | (1L << (INT8 - 187)) | (1L << (TINYINT - 187)) | (1L << (SMALLINT - 187)) | (1L << (INT - 187)) | (1L << (INTEGER - 187)) | (1L << (BIGINT - 187)) | (1L << (FLOAT4 - 187)) | (1L << (FLOAT8 - 187)) | (1L << (REAL - 187)) | (1L << (FLOAT - 187)) | (1L << (DOUBLE - 187)) | (1L << (NUMERIC - 187)))) != 0) || ((((_la - 251)) & ~0x3f) == 0 && ((1L << (_la - 251)) & ((1L << (DECIMAL - 251)) | (1L << (CHAR - 251)) | (1L << (VARCHAR - 251)) | (1L << (NCHAR - 251)) | (1L << (NVARCHAR - 251)) | (1L << (DATE - 251)) | (1L << (TIME - 251)) | (1L << (TIMETZ - 251)) | (1L << (TIMESTAMP - 251)) | (1L << (TIMESTAMPTZ - 251)) | (1L << (TEXT - 251)) | (1L << (VARBINARY - 251)) | (1L << (BLOB - 251)) | (1L << (BYTEA - 251)) | (1L << (INET4 - 251)) | (1L << (QUOTE - 251)) | (1L << (Identifier - 251)))) != 0) );
				setState(789); revoke_from_cascade_restrict();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(791); match(REVOKE);
				setState(795);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(792); match(GRANT);
					setState(793); match(OPTION);
					setState(794); match(FOR);
					}
				}

				setState(802);
				switch (_input.LA(1)) {
				case USAGE:
					{
					setState(797); match(USAGE);
					}
					break;
				case ALL:
					{
					setState(798); match(ALL);
					setState(800);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(799); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(804); match(ON);
				setState(805); match(FOREIGN);
				setState(806); match(DATA);
				setState(807); match(WRAPPER);
				setState(812); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(808); ((Revoke_statementContext)_localctx).fdw_name = schema_qualified_name();
					setState(810);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(809); match(COMMA);
						}
					}

					}
					}
					setState(814); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 123)) & ~0x3f) == 0 && ((1L << (_la - 123)) & ((1L << (ADMIN - 123)) | (1L << (AVG - 123)) | (1L << (BETWEEN - 123)) | (1L << (BY - 123)) | (1L << (CLASS - 123)) | (1L << (CENTURY - 123)) | (1L << (CHARACTER - 123)) | (1L << (CHECK - 123)) | (1L << (COLLECT - 123)) | (1L << (COALESCE - 123)) | (1L << (COLUMN - 123)) | (1L << (COMMENT - 123)) | (1L << (COMMENTS - 123)) | (1L << (COMMIT - 123)) | (1L << (CONFIGURATION - 123)) | (1L << (COUNT - 123)) | (1L << (CUBE - 123)) | (1L << (DATA - 123)) | (1L << (DAY - 123)) | (1L << (DEC - 123)) | (1L << (DECADE - 123)) | (1L << (DICTIONARY - 123)) | (1L << (DOW - 123)) | (1L << (DOY - 123)) | (1L << (DROP - 123)) | (1L << (EPOCH - 123)) | (1L << (EVERY - 123)) | (1L << (EXISTS - 123)) | (1L << (EXTERNAL - 123)) | (1L << (EXTRACT - 123)) | (1L << (FAMILY - 123)) | (1L << (FILTER - 123)) | (1L << (FIRST - 123)) | (1L << (FORMAT - 123)) | (1L << (FUSION - 123)) | (1L << (GROUPING - 123)) | (1L << (HASH - 123)) | (1L << (INDEX - 123)) | (1L << (INSERT - 123)) | (1L << (INTERSECTION - 123)) | (1L << (ISODOW - 123)) | (1L << (ISOYEAR - 123)) | (1L << (LANGUAGE - 123)) | (1L << (LARGE - 123)) | (1L << (LAST - 123)) | (1L << (LESS - 123)) | (1L << (LIST - 123)) | (1L << (LOCATION - 123)) | (1L << (MATCH - 123)) | (1L << (MAX - 123)) | (1L << (MAXVALUE - 123)) | (1L << (MICROSECONDS - 123)) | (1L << (MILLENNIUM - 123)) | (1L << (MILLISECONDS - 123)) | (1L << (MIN - 123)) | (1L << (MINUTE - 123)) | (1L << (MONTH - 123)) | (1L << (NATIONAL - 123)) | (1L << (NULLIF - 123)) | (1L << (OBJECT - 123)) | (1L << (OPTION - 123)) | (1L << (OPTIONS - 123)))) != 0) || ((((_la - 187)) & ~0x3f) == 0 && ((1L << (_la - 187)) & ((1L << (OVERWRITE - 187)) | (1L << (PARSER - 187)) | (1L << (PARTIAL - 187)) | (1L << (PARTITION - 187)) | (1L << (PARTITIONS - 187)) | (1L << (PRECISION - 187)) | (1L << (PUBLIC - 187)) | (1L << (PURGE - 187)) | (1L << (QUARTER - 187)) | (1L << (RANGE - 187)) | (1L << (REGEXP - 187)) | (1L << (RLIKE - 187)) | (1L << (ROLLUP - 187)) | (1L << (SEARCH - 187)) | (1L << (SECOND - 187)) | (1L << (SERVER - 187)) | (1L << (SET - 187)) | (1L << (SIMILAR - 187)) | (1L << (SIMPLE - 187)) | (1L << (STORAGE - 187)) | (1L << (STDDEV_POP - 187)) | (1L << (STDDEV_SAMP - 187)) | (1L << (SUBPARTITION - 187)) | (1L << (SUM - 187)) | (1L << (TABLESPACE - 187)) | (1L << (TEMPLATE - 187)) | (1L << (THAN - 187)) | (1L << (TIMEZONE - 187)) | (1L << (TIMEZONE_HOUR - 187)) | (1L << (TIMEZONE_MINUTE - 187)) | (1L << (TRIM - 187)) | (1L << (TO - 187)) | (1L << (UNKNOWN - 187)) | (1L << (UNLOGGED - 187)) | (1L << (VALUES - 187)) | (1L << (VAR_SAMP - 187)) | (1L << (VAR_POP - 187)) | (1L << (VARYING - 187)) | (1L << (WEEK - 187)) | (1L << (WRAPPER - 187)) | (1L << (YEAR - 187)) | (1L << (ZONE - 187)) | (1L << (BOOLEAN - 187)) | (1L << (BOOL - 187)) | (1L << (BIT - 187)) | (1L << (VARBIT - 187)) | (1L << (INT1 - 187)) | (1L << (INT2 - 187)) | (1L << (INT4 - 187)) | (1L << (INT8 - 187)) | (1L << (TINYINT - 187)) | (1L << (SMALLINT - 187)) | (1L << (INT - 187)) | (1L << (INTEGER - 187)) | (1L << (BIGINT - 187)) | (1L << (FLOAT4 - 187)) | (1L << (FLOAT8 - 187)) | (1L << (REAL - 187)) | (1L << (FLOAT - 187)) | (1L << (DOUBLE - 187)) | (1L << (NUMERIC - 187)))) != 0) || ((((_la - 251)) & ~0x3f) == 0 && ((1L << (_la - 251)) & ((1L << (DECIMAL - 251)) | (1L << (CHAR - 251)) | (1L << (VARCHAR - 251)) | (1L << (NCHAR - 251)) | (1L << (NVARCHAR - 251)) | (1L << (DATE - 251)) | (1L << (TIME - 251)) | (1L << (TIMETZ - 251)) | (1L << (TIMESTAMP - 251)) | (1L << (TIMESTAMPTZ - 251)) | (1L << (TEXT - 251)) | (1L << (VARBINARY - 251)) | (1L << (BLOB - 251)) | (1L << (BYTEA - 251)) | (1L << (INET4 - 251)) | (1L << (QUOTE - 251)) | (1L << (Identifier - 251)))) != 0) );
				setState(816); revoke_from_cascade_restrict();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(818); match(REVOKE);
				setState(822);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(819); match(GRANT);
					setState(820); match(OPTION);
					setState(821); match(FOR);
					}
				}

				setState(829);
				switch (_input.LA(1)) {
				case USAGE:
					{
					setState(824); match(USAGE);
					}
					break;
				case ALL:
					{
					setState(825); match(ALL);
					setState(827);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(826); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(831); match(ON);
				setState(832); match(FOREIGN);
				setState(833); match(SERVER);
				setState(838); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(834); ((Revoke_statementContext)_localctx).server_name = identifier();
					setState(836);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(835); match(COMMA);
						}
					}

					}
					}
					setState(840); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 123)) & ~0x3f) == 0 && ((1L << (_la - 123)) & ((1L << (ADMIN - 123)) | (1L << (AVG - 123)) | (1L << (BETWEEN - 123)) | (1L << (BY - 123)) | (1L << (CLASS - 123)) | (1L << (CENTURY - 123)) | (1L << (CHARACTER - 123)) | (1L << (CHECK - 123)) | (1L << (COLLECT - 123)) | (1L << (COALESCE - 123)) | (1L << (COLUMN - 123)) | (1L << (COMMENT - 123)) | (1L << (COMMENTS - 123)) | (1L << (COMMIT - 123)) | (1L << (CONFIGURATION - 123)) | (1L << (COUNT - 123)) | (1L << (CUBE - 123)) | (1L << (DATA - 123)) | (1L << (DAY - 123)) | (1L << (DEC - 123)) | (1L << (DECADE - 123)) | (1L << (DICTIONARY - 123)) | (1L << (DOW - 123)) | (1L << (DOY - 123)) | (1L << (DROP - 123)) | (1L << (EPOCH - 123)) | (1L << (EVERY - 123)) | (1L << (EXISTS - 123)) | (1L << (EXTERNAL - 123)) | (1L << (EXTRACT - 123)) | (1L << (FAMILY - 123)) | (1L << (FILTER - 123)) | (1L << (FIRST - 123)) | (1L << (FORMAT - 123)) | (1L << (FUSION - 123)) | (1L << (GROUPING - 123)) | (1L << (HASH - 123)) | (1L << (INDEX - 123)) | (1L << (INSERT - 123)) | (1L << (INTERSECTION - 123)) | (1L << (ISODOW - 123)) | (1L << (ISOYEAR - 123)) | (1L << (LANGUAGE - 123)) | (1L << (LARGE - 123)) | (1L << (LAST - 123)) | (1L << (LESS - 123)) | (1L << (LIST - 123)) | (1L << (LOCATION - 123)) | (1L << (MATCH - 123)) | (1L << (MAX - 123)) | (1L << (MAXVALUE - 123)) | (1L << (MICROSECONDS - 123)) | (1L << (MILLENNIUM - 123)) | (1L << (MILLISECONDS - 123)) | (1L << (MIN - 123)) | (1L << (MINUTE - 123)) | (1L << (MONTH - 123)) | (1L << (NATIONAL - 123)) | (1L << (NULLIF - 123)) | (1L << (OBJECT - 123)) | (1L << (OPTION - 123)) | (1L << (OPTIONS - 123)))) != 0) || ((((_la - 187)) & ~0x3f) == 0 && ((1L << (_la - 187)) & ((1L << (OVERWRITE - 187)) | (1L << (PARSER - 187)) | (1L << (PARTIAL - 187)) | (1L << (PARTITION - 187)) | (1L << (PARTITIONS - 187)) | (1L << (PRECISION - 187)) | (1L << (PUBLIC - 187)) | (1L << (PURGE - 187)) | (1L << (QUARTER - 187)) | (1L << (RANGE - 187)) | (1L << (REGEXP - 187)) | (1L << (RLIKE - 187)) | (1L << (ROLLUP - 187)) | (1L << (SEARCH - 187)) | (1L << (SECOND - 187)) | (1L << (SERVER - 187)) | (1L << (SET - 187)) | (1L << (SIMILAR - 187)) | (1L << (SIMPLE - 187)) | (1L << (STORAGE - 187)) | (1L << (STDDEV_POP - 187)) | (1L << (STDDEV_SAMP - 187)) | (1L << (SUBPARTITION - 187)) | (1L << (SUM - 187)) | (1L << (TABLESPACE - 187)) | (1L << (TEMPLATE - 187)) | (1L << (THAN - 187)) | (1L << (TIMEZONE - 187)) | (1L << (TIMEZONE_HOUR - 187)) | (1L << (TIMEZONE_MINUTE - 187)) | (1L << (TRIM - 187)) | (1L << (TO - 187)) | (1L << (UNKNOWN - 187)) | (1L << (UNLOGGED - 187)) | (1L << (VALUES - 187)) | (1L << (VAR_SAMP - 187)) | (1L << (VAR_POP - 187)) | (1L << (VARYING - 187)) | (1L << (WEEK - 187)) | (1L << (WRAPPER - 187)) | (1L << (YEAR - 187)) | (1L << (ZONE - 187)) | (1L << (BOOLEAN - 187)) | (1L << (BOOL - 187)) | (1L << (BIT - 187)) | (1L << (VARBIT - 187)) | (1L << (INT1 - 187)) | (1L << (INT2 - 187)) | (1L << (INT4 - 187)) | (1L << (INT8 - 187)) | (1L << (TINYINT - 187)) | (1L << (SMALLINT - 187)) | (1L << (INT - 187)) | (1L << (INTEGER - 187)) | (1L << (BIGINT - 187)) | (1L << (FLOAT4 - 187)) | (1L << (FLOAT8 - 187)) | (1L << (REAL - 187)) | (1L << (FLOAT - 187)) | (1L << (DOUBLE - 187)) | (1L << (NUMERIC - 187)))) != 0) || ((((_la - 251)) & ~0x3f) == 0 && ((1L << (_la - 251)) & ((1L << (DECIMAL - 251)) | (1L << (CHAR - 251)) | (1L << (VARCHAR - 251)) | (1L << (NCHAR - 251)) | (1L << (NVARCHAR - 251)) | (1L << (DATE - 251)) | (1L << (TIME - 251)) | (1L << (TIMETZ - 251)) | (1L << (TIMESTAMP - 251)) | (1L << (TIMESTAMPTZ - 251)) | (1L << (TEXT - 251)) | (1L << (VARBINARY - 251)) | (1L << (BLOB - 251)) | (1L << (BYTEA - 251)) | (1L << (INET4 - 251)) | (1L << (QUOTE - 251)) | (1L << (Identifier - 251)))) != 0) );
				setState(842); revoke_from_cascade_restrict();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(844); match(REVOKE);
				setState(848);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(845); match(GRANT);
					setState(846); match(OPTION);
					setState(847); match(FOR);
					}
				}

				setState(855);
				switch (_input.LA(1)) {
				case EXECUTE:
					{
					setState(850); match(EXECUTE);
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
				setState(860);
				switch (_input.LA(1)) {
				case FUNCTION:
					{
					setState(858); function_definition();
					}
					break;
				case ALL:
					{
					setState(859); functions_definition_schema();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(862); revoke_from_cascade_restrict();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(864); match(REVOKE);
				setState(868);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(865); match(GRANT);
					setState(866); match(OPTION);
					setState(867); match(FOR);
					}
				}

				setState(875);
				switch (_input.LA(1)) {
				case USAGE:
					{
					setState(870); match(USAGE);
					}
					break;
				case ALL:
					{
					setState(871); match(ALL);
					setState(873);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(872); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(877); match(ON);
				setState(878); match(LANGUAGE);
				setState(883); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(879); ((Revoke_statementContext)_localctx).lang_name = identifier();
					setState(881);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(880); match(COMMA);
						}
					}

					}
					}
					setState(885); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 123)) & ~0x3f) == 0 && ((1L << (_la - 123)) & ((1L << (ADMIN - 123)) | (1L << (AVG - 123)) | (1L << (BETWEEN - 123)) | (1L << (BY - 123)) | (1L << (CLASS - 123)) | (1L << (CENTURY - 123)) | (1L << (CHARACTER - 123)) | (1L << (CHECK - 123)) | (1L << (COLLECT - 123)) | (1L << (COALESCE - 123)) | (1L << (COLUMN - 123)) | (1L << (COMMENT - 123)) | (1L << (COMMENTS - 123)) | (1L << (COMMIT - 123)) | (1L << (CONFIGURATION - 123)) | (1L << (COUNT - 123)) | (1L << (CUBE - 123)) | (1L << (DATA - 123)) | (1L << (DAY - 123)) | (1L << (DEC - 123)) | (1L << (DECADE - 123)) | (1L << (DICTIONARY - 123)) | (1L << (DOW - 123)) | (1L << (DOY - 123)) | (1L << (DROP - 123)) | (1L << (EPOCH - 123)) | (1L << (EVERY - 123)) | (1L << (EXISTS - 123)) | (1L << (EXTERNAL - 123)) | (1L << (EXTRACT - 123)) | (1L << (FAMILY - 123)) | (1L << (FILTER - 123)) | (1L << (FIRST - 123)) | (1L << (FORMAT - 123)) | (1L << (FUSION - 123)) | (1L << (GROUPING - 123)) | (1L << (HASH - 123)) | (1L << (INDEX - 123)) | (1L << (INSERT - 123)) | (1L << (INTERSECTION - 123)) | (1L << (ISODOW - 123)) | (1L << (ISOYEAR - 123)) | (1L << (LANGUAGE - 123)) | (1L << (LARGE - 123)) | (1L << (LAST - 123)) | (1L << (LESS - 123)) | (1L << (LIST - 123)) | (1L << (LOCATION - 123)) | (1L << (MATCH - 123)) | (1L << (MAX - 123)) | (1L << (MAXVALUE - 123)) | (1L << (MICROSECONDS - 123)) | (1L << (MILLENNIUM - 123)) | (1L << (MILLISECONDS - 123)) | (1L << (MIN - 123)) | (1L << (MINUTE - 123)) | (1L << (MONTH - 123)) | (1L << (NATIONAL - 123)) | (1L << (NULLIF - 123)) | (1L << (OBJECT - 123)) | (1L << (OPTION - 123)) | (1L << (OPTIONS - 123)))) != 0) || ((((_la - 187)) & ~0x3f) == 0 && ((1L << (_la - 187)) & ((1L << (OVERWRITE - 187)) | (1L << (PARSER - 187)) | (1L << (PARTIAL - 187)) | (1L << (PARTITION - 187)) | (1L << (PARTITIONS - 187)) | (1L << (PRECISION - 187)) | (1L << (PUBLIC - 187)) | (1L << (PURGE - 187)) | (1L << (QUARTER - 187)) | (1L << (RANGE - 187)) | (1L << (REGEXP - 187)) | (1L << (RLIKE - 187)) | (1L << (ROLLUP - 187)) | (1L << (SEARCH - 187)) | (1L << (SECOND - 187)) | (1L << (SERVER - 187)) | (1L << (SET - 187)) | (1L << (SIMILAR - 187)) | (1L << (SIMPLE - 187)) | (1L << (STORAGE - 187)) | (1L << (STDDEV_POP - 187)) | (1L << (STDDEV_SAMP - 187)) | (1L << (SUBPARTITION - 187)) | (1L << (SUM - 187)) | (1L << (TABLESPACE - 187)) | (1L << (TEMPLATE - 187)) | (1L << (THAN - 187)) | (1L << (TIMEZONE - 187)) | (1L << (TIMEZONE_HOUR - 187)) | (1L << (TIMEZONE_MINUTE - 187)) | (1L << (TRIM - 187)) | (1L << (TO - 187)) | (1L << (UNKNOWN - 187)) | (1L << (UNLOGGED - 187)) | (1L << (VALUES - 187)) | (1L << (VAR_SAMP - 187)) | (1L << (VAR_POP - 187)) | (1L << (VARYING - 187)) | (1L << (WEEK - 187)) | (1L << (WRAPPER - 187)) | (1L << (YEAR - 187)) | (1L << (ZONE - 187)) | (1L << (BOOLEAN - 187)) | (1L << (BOOL - 187)) | (1L << (BIT - 187)) | (1L << (VARBIT - 187)) | (1L << (INT1 - 187)) | (1L << (INT2 - 187)) | (1L << (INT4 - 187)) | (1L << (INT8 - 187)) | (1L << (TINYINT - 187)) | (1L << (SMALLINT - 187)) | (1L << (INT - 187)) | (1L << (INTEGER - 187)) | (1L << (BIGINT - 187)) | (1L << (FLOAT4 - 187)) | (1L << (FLOAT8 - 187)) | (1L << (REAL - 187)) | (1L << (FLOAT - 187)) | (1L << (DOUBLE - 187)) | (1L << (NUMERIC - 187)))) != 0) || ((((_la - 251)) & ~0x3f) == 0 && ((1L << (_la - 251)) & ((1L << (DECIMAL - 251)) | (1L << (CHAR - 251)) | (1L << (VARCHAR - 251)) | (1L << (NCHAR - 251)) | (1L << (NVARCHAR - 251)) | (1L << (DATE - 251)) | (1L << (TIME - 251)) | (1L << (TIMETZ - 251)) | (1L << (TIMESTAMP - 251)) | (1L << (TIMESTAMPTZ - 251)) | (1L << (TEXT - 251)) | (1L << (VARBINARY - 251)) | (1L << (BLOB - 251)) | (1L << (BYTEA - 251)) | (1L << (INET4 - 251)) | (1L << (QUOTE - 251)) | (1L << (Identifier - 251)))) != 0) );
				setState(887); revoke_from_cascade_restrict();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(889); match(REVOKE);
				setState(893);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(890); match(GRANT);
					setState(891); match(OPTION);
					setState(892); match(FOR);
					}
				}

				setState(908);
				switch (_input.LA(1)) {
				case SELECT:
				case UPDATE:
					{
					setState(900); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						setState(900);
						switch (_input.LA(1)) {
						case SELECT:
							{
							setState(895); match(SELECT);
							}
							break;
						case UPDATE:
							{
							setState(896); match(UPDATE);
							setState(898);
							_la = _input.LA(1);
							if (_la==COMMA) {
								{
								setState(897); match(COMMA);
								}
							}

							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						setState(902); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==SELECT || _la==UPDATE );
					}
					break;
				case ALL:
					{
					setState(904); match(ALL);
					setState(906);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(905); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(910); match(ON);
				setState(911); match(LARGE);
				setState(912); match(OBJECT);
				setState(917); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(913); ((Revoke_statementContext)_localctx).loid = identifier();
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
				} while ( ((((_la - 123)) & ~0x3f) == 0 && ((1L << (_la - 123)) & ((1L << (ADMIN - 123)) | (1L << (AVG - 123)) | (1L << (BETWEEN - 123)) | (1L << (BY - 123)) | (1L << (CLASS - 123)) | (1L << (CENTURY - 123)) | (1L << (CHARACTER - 123)) | (1L << (CHECK - 123)) | (1L << (COLLECT - 123)) | (1L << (COALESCE - 123)) | (1L << (COLUMN - 123)) | (1L << (COMMENT - 123)) | (1L << (COMMENTS - 123)) | (1L << (COMMIT - 123)) | (1L << (CONFIGURATION - 123)) | (1L << (COUNT - 123)) | (1L << (CUBE - 123)) | (1L << (DATA - 123)) | (1L << (DAY - 123)) | (1L << (DEC - 123)) | (1L << (DECADE - 123)) | (1L << (DICTIONARY - 123)) | (1L << (DOW - 123)) | (1L << (DOY - 123)) | (1L << (DROP - 123)) | (1L << (EPOCH - 123)) | (1L << (EVERY - 123)) | (1L << (EXISTS - 123)) | (1L << (EXTERNAL - 123)) | (1L << (EXTRACT - 123)) | (1L << (FAMILY - 123)) | (1L << (FILTER - 123)) | (1L << (FIRST - 123)) | (1L << (FORMAT - 123)) | (1L << (FUSION - 123)) | (1L << (GROUPING - 123)) | (1L << (HASH - 123)) | (1L << (INDEX - 123)) | (1L << (INSERT - 123)) | (1L << (INTERSECTION - 123)) | (1L << (ISODOW - 123)) | (1L << (ISOYEAR - 123)) | (1L << (LANGUAGE - 123)) | (1L << (LARGE - 123)) | (1L << (LAST - 123)) | (1L << (LESS - 123)) | (1L << (LIST - 123)) | (1L << (LOCATION - 123)) | (1L << (MATCH - 123)) | (1L << (MAX - 123)) | (1L << (MAXVALUE - 123)) | (1L << (MICROSECONDS - 123)) | (1L << (MILLENNIUM - 123)) | (1L << (MILLISECONDS - 123)) | (1L << (MIN - 123)) | (1L << (MINUTE - 123)) | (1L << (MONTH - 123)) | (1L << (NATIONAL - 123)) | (1L << (NULLIF - 123)) | (1L << (OBJECT - 123)) | (1L << (OPTION - 123)) | (1L << (OPTIONS - 123)))) != 0) || ((((_la - 187)) & ~0x3f) == 0 && ((1L << (_la - 187)) & ((1L << (OVERWRITE - 187)) | (1L << (PARSER - 187)) | (1L << (PARTIAL - 187)) | (1L << (PARTITION - 187)) | (1L << (PARTITIONS - 187)) | (1L << (PRECISION - 187)) | (1L << (PUBLIC - 187)) | (1L << (PURGE - 187)) | (1L << (QUARTER - 187)) | (1L << (RANGE - 187)) | (1L << (REGEXP - 187)) | (1L << (RLIKE - 187)) | (1L << (ROLLUP - 187)) | (1L << (SEARCH - 187)) | (1L << (SECOND - 187)) | (1L << (SERVER - 187)) | (1L << (SET - 187)) | (1L << (SIMILAR - 187)) | (1L << (SIMPLE - 187)) | (1L << (STORAGE - 187)) | (1L << (STDDEV_POP - 187)) | (1L << (STDDEV_SAMP - 187)) | (1L << (SUBPARTITION - 187)) | (1L << (SUM - 187)) | (1L << (TABLESPACE - 187)) | (1L << (TEMPLATE - 187)) | (1L << (THAN - 187)) | (1L << (TIMEZONE - 187)) | (1L << (TIMEZONE_HOUR - 187)) | (1L << (TIMEZONE_MINUTE - 187)) | (1L << (TRIM - 187)) | (1L << (TO - 187)) | (1L << (UNKNOWN - 187)) | (1L << (UNLOGGED - 187)) | (1L << (VALUES - 187)) | (1L << (VAR_SAMP - 187)) | (1L << (VAR_POP - 187)) | (1L << (VARYING - 187)) | (1L << (WEEK - 187)) | (1L << (WRAPPER - 187)) | (1L << (YEAR - 187)) | (1L << (ZONE - 187)) | (1L << (BOOLEAN - 187)) | (1L << (BOOL - 187)) | (1L << (BIT - 187)) | (1L << (VARBIT - 187)) | (1L << (INT1 - 187)) | (1L << (INT2 - 187)) | (1L << (INT4 - 187)) | (1L << (INT8 - 187)) | (1L << (TINYINT - 187)) | (1L << (SMALLINT - 187)) | (1L << (INT - 187)) | (1L << (INTEGER - 187)) | (1L << (BIGINT - 187)) | (1L << (FLOAT4 - 187)) | (1L << (FLOAT8 - 187)) | (1L << (REAL - 187)) | (1L << (FLOAT - 187)) | (1L << (DOUBLE - 187)) | (1L << (NUMERIC - 187)))) != 0) || ((((_la - 251)) & ~0x3f) == 0 && ((1L << (_la - 251)) & ((1L << (DECIMAL - 251)) | (1L << (CHAR - 251)) | (1L << (VARCHAR - 251)) | (1L << (NCHAR - 251)) | (1L << (NVARCHAR - 251)) | (1L << (DATE - 251)) | (1L << (TIME - 251)) | (1L << (TIMETZ - 251)) | (1L << (TIMESTAMP - 251)) | (1L << (TIMESTAMPTZ - 251)) | (1L << (TEXT - 251)) | (1L << (VARBINARY - 251)) | (1L << (BLOB - 251)) | (1L << (BYTEA - 251)) | (1L << (INET4 - 251)) | (1L << (QUOTE - 251)) | (1L << (Identifier - 251)))) != 0) );
				setState(921); revoke_from_cascade_restrict();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
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

				setState(941);
				switch (_input.LA(1)) {
				case CREATE:
				case USAGE:
					{
					setState(933); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(929);
						_la = _input.LA(1);
						if ( !(_la==CREATE || _la==USAGE) ) {
						_errHandler.recoverInline(this);
						}
						consume();
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
					} while ( _la==CREATE || _la==USAGE );
					}
					break;
				case ALL:
					{
					setState(937); match(ALL);
					setState(939);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(938); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(943); match(ON);
				setState(944); match(SCHEMA);
				setState(949); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(945); ((Revoke_statementContext)_localctx).schema_name = identifier();
					setState(947);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(946); match(COMMA);
						}
					}

					}
					}
					setState(951); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 123)) & ~0x3f) == 0 && ((1L << (_la - 123)) & ((1L << (ADMIN - 123)) | (1L << (AVG - 123)) | (1L << (BETWEEN - 123)) | (1L << (BY - 123)) | (1L << (CLASS - 123)) | (1L << (CENTURY - 123)) | (1L << (CHARACTER - 123)) | (1L << (CHECK - 123)) | (1L << (COLLECT - 123)) | (1L << (COALESCE - 123)) | (1L << (COLUMN - 123)) | (1L << (COMMENT - 123)) | (1L << (COMMENTS - 123)) | (1L << (COMMIT - 123)) | (1L << (CONFIGURATION - 123)) | (1L << (COUNT - 123)) | (1L << (CUBE - 123)) | (1L << (DATA - 123)) | (1L << (DAY - 123)) | (1L << (DEC - 123)) | (1L << (DECADE - 123)) | (1L << (DICTIONARY - 123)) | (1L << (DOW - 123)) | (1L << (DOY - 123)) | (1L << (DROP - 123)) | (1L << (EPOCH - 123)) | (1L << (EVERY - 123)) | (1L << (EXISTS - 123)) | (1L << (EXTERNAL - 123)) | (1L << (EXTRACT - 123)) | (1L << (FAMILY - 123)) | (1L << (FILTER - 123)) | (1L << (FIRST - 123)) | (1L << (FORMAT - 123)) | (1L << (FUSION - 123)) | (1L << (GROUPING - 123)) | (1L << (HASH - 123)) | (1L << (INDEX - 123)) | (1L << (INSERT - 123)) | (1L << (INTERSECTION - 123)) | (1L << (ISODOW - 123)) | (1L << (ISOYEAR - 123)) | (1L << (LANGUAGE - 123)) | (1L << (LARGE - 123)) | (1L << (LAST - 123)) | (1L << (LESS - 123)) | (1L << (LIST - 123)) | (1L << (LOCATION - 123)) | (1L << (MATCH - 123)) | (1L << (MAX - 123)) | (1L << (MAXVALUE - 123)) | (1L << (MICROSECONDS - 123)) | (1L << (MILLENNIUM - 123)) | (1L << (MILLISECONDS - 123)) | (1L << (MIN - 123)) | (1L << (MINUTE - 123)) | (1L << (MONTH - 123)) | (1L << (NATIONAL - 123)) | (1L << (NULLIF - 123)) | (1L << (OBJECT - 123)) | (1L << (OPTION - 123)) | (1L << (OPTIONS - 123)))) != 0) || ((((_la - 187)) & ~0x3f) == 0 && ((1L << (_la - 187)) & ((1L << (OVERWRITE - 187)) | (1L << (PARSER - 187)) | (1L << (PARTIAL - 187)) | (1L << (PARTITION - 187)) | (1L << (PARTITIONS - 187)) | (1L << (PRECISION - 187)) | (1L << (PUBLIC - 187)) | (1L << (PURGE - 187)) | (1L << (QUARTER - 187)) | (1L << (RANGE - 187)) | (1L << (REGEXP - 187)) | (1L << (RLIKE - 187)) | (1L << (ROLLUP - 187)) | (1L << (SEARCH - 187)) | (1L << (SECOND - 187)) | (1L << (SERVER - 187)) | (1L << (SET - 187)) | (1L << (SIMILAR - 187)) | (1L << (SIMPLE - 187)) | (1L << (STORAGE - 187)) | (1L << (STDDEV_POP - 187)) | (1L << (STDDEV_SAMP - 187)) | (1L << (SUBPARTITION - 187)) | (1L << (SUM - 187)) | (1L << (TABLESPACE - 187)) | (1L << (TEMPLATE - 187)) | (1L << (THAN - 187)) | (1L << (TIMEZONE - 187)) | (1L << (TIMEZONE_HOUR - 187)) | (1L << (TIMEZONE_MINUTE - 187)) | (1L << (TRIM - 187)) | (1L << (TO - 187)) | (1L << (UNKNOWN - 187)) | (1L << (UNLOGGED - 187)) | (1L << (VALUES - 187)) | (1L << (VAR_SAMP - 187)) | (1L << (VAR_POP - 187)) | (1L << (VARYING - 187)) | (1L << (WEEK - 187)) | (1L << (WRAPPER - 187)) | (1L << (YEAR - 187)) | (1L << (ZONE - 187)) | (1L << (BOOLEAN - 187)) | (1L << (BOOL - 187)) | (1L << (BIT - 187)) | (1L << (VARBIT - 187)) | (1L << (INT1 - 187)) | (1L << (INT2 - 187)) | (1L << (INT4 - 187)) | (1L << (INT8 - 187)) | (1L << (TINYINT - 187)) | (1L << (SMALLINT - 187)) | (1L << (INT - 187)) | (1L << (INTEGER - 187)) | (1L << (BIGINT - 187)) | (1L << (FLOAT4 - 187)) | (1L << (FLOAT8 - 187)) | (1L << (REAL - 187)) | (1L << (FLOAT - 187)) | (1L << (DOUBLE - 187)) | (1L << (NUMERIC - 187)))) != 0) || ((((_la - 251)) & ~0x3f) == 0 && ((1L << (_la - 251)) & ((1L << (DECIMAL - 251)) | (1L << (CHAR - 251)) | (1L << (VARCHAR - 251)) | (1L << (NCHAR - 251)) | (1L << (NVARCHAR - 251)) | (1L << (DATE - 251)) | (1L << (TIME - 251)) | (1L << (TIMETZ - 251)) | (1L << (TIMESTAMP - 251)) | (1L << (TIMESTAMPTZ - 251)) | (1L << (TEXT - 251)) | (1L << (VARBINARY - 251)) | (1L << (BLOB - 251)) | (1L << (BYTEA - 251)) | (1L << (INET4 - 251)) | (1L << (QUOTE - 251)) | (1L << (Identifier - 251)))) != 0) );
				setState(953); revoke_from_cascade_restrict();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(955); match(REVOKE);
				setState(959);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(956); match(GRANT);
					setState(957); match(OPTION);
					setState(958); match(FOR);
					}
				}

				setState(966);
				switch (_input.LA(1)) {
				case CREATE:
					{
					setState(961); match(CREATE);
					}
					break;
				case ALL:
					{
					setState(962); match(ALL);
					setState(964);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(963); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(968); match(ON);
				setState(969); match(TABLESPACE);
				setState(974); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(970); ((Revoke_statementContext)_localctx).tablespace_name = identifier();
					setState(972);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(971); match(COMMA);
						}
					}

					}
					}
					setState(976); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 123)) & ~0x3f) == 0 && ((1L << (_la - 123)) & ((1L << (ADMIN - 123)) | (1L << (AVG - 123)) | (1L << (BETWEEN - 123)) | (1L << (BY - 123)) | (1L << (CLASS - 123)) | (1L << (CENTURY - 123)) | (1L << (CHARACTER - 123)) | (1L << (CHECK - 123)) | (1L << (COLLECT - 123)) | (1L << (COALESCE - 123)) | (1L << (COLUMN - 123)) | (1L << (COMMENT - 123)) | (1L << (COMMENTS - 123)) | (1L << (COMMIT - 123)) | (1L << (CONFIGURATION - 123)) | (1L << (COUNT - 123)) | (1L << (CUBE - 123)) | (1L << (DATA - 123)) | (1L << (DAY - 123)) | (1L << (DEC - 123)) | (1L << (DECADE - 123)) | (1L << (DICTIONARY - 123)) | (1L << (DOW - 123)) | (1L << (DOY - 123)) | (1L << (DROP - 123)) | (1L << (EPOCH - 123)) | (1L << (EVERY - 123)) | (1L << (EXISTS - 123)) | (1L << (EXTERNAL - 123)) | (1L << (EXTRACT - 123)) | (1L << (FAMILY - 123)) | (1L << (FILTER - 123)) | (1L << (FIRST - 123)) | (1L << (FORMAT - 123)) | (1L << (FUSION - 123)) | (1L << (GROUPING - 123)) | (1L << (HASH - 123)) | (1L << (INDEX - 123)) | (1L << (INSERT - 123)) | (1L << (INTERSECTION - 123)) | (1L << (ISODOW - 123)) | (1L << (ISOYEAR - 123)) | (1L << (LANGUAGE - 123)) | (1L << (LARGE - 123)) | (1L << (LAST - 123)) | (1L << (LESS - 123)) | (1L << (LIST - 123)) | (1L << (LOCATION - 123)) | (1L << (MATCH - 123)) | (1L << (MAX - 123)) | (1L << (MAXVALUE - 123)) | (1L << (MICROSECONDS - 123)) | (1L << (MILLENNIUM - 123)) | (1L << (MILLISECONDS - 123)) | (1L << (MIN - 123)) | (1L << (MINUTE - 123)) | (1L << (MONTH - 123)) | (1L << (NATIONAL - 123)) | (1L << (NULLIF - 123)) | (1L << (OBJECT - 123)) | (1L << (OPTION - 123)) | (1L << (OPTIONS - 123)))) != 0) || ((((_la - 187)) & ~0x3f) == 0 && ((1L << (_la - 187)) & ((1L << (OVERWRITE - 187)) | (1L << (PARSER - 187)) | (1L << (PARTIAL - 187)) | (1L << (PARTITION - 187)) | (1L << (PARTITIONS - 187)) | (1L << (PRECISION - 187)) | (1L << (PUBLIC - 187)) | (1L << (PURGE - 187)) | (1L << (QUARTER - 187)) | (1L << (RANGE - 187)) | (1L << (REGEXP - 187)) | (1L << (RLIKE - 187)) | (1L << (ROLLUP - 187)) | (1L << (SEARCH - 187)) | (1L << (SECOND - 187)) | (1L << (SERVER - 187)) | (1L << (SET - 187)) | (1L << (SIMILAR - 187)) | (1L << (SIMPLE - 187)) | (1L << (STORAGE - 187)) | (1L << (STDDEV_POP - 187)) | (1L << (STDDEV_SAMP - 187)) | (1L << (SUBPARTITION - 187)) | (1L << (SUM - 187)) | (1L << (TABLESPACE - 187)) | (1L << (TEMPLATE - 187)) | (1L << (THAN - 187)) | (1L << (TIMEZONE - 187)) | (1L << (TIMEZONE_HOUR - 187)) | (1L << (TIMEZONE_MINUTE - 187)) | (1L << (TRIM - 187)) | (1L << (TO - 187)) | (1L << (UNKNOWN - 187)) | (1L << (UNLOGGED - 187)) | (1L << (VALUES - 187)) | (1L << (VAR_SAMP - 187)) | (1L << (VAR_POP - 187)) | (1L << (VARYING - 187)) | (1L << (WEEK - 187)) | (1L << (WRAPPER - 187)) | (1L << (YEAR - 187)) | (1L << (ZONE - 187)) | (1L << (BOOLEAN - 187)) | (1L << (BOOL - 187)) | (1L << (BIT - 187)) | (1L << (VARBIT - 187)) | (1L << (INT1 - 187)) | (1L << (INT2 - 187)) | (1L << (INT4 - 187)) | (1L << (INT8 - 187)) | (1L << (TINYINT - 187)) | (1L << (SMALLINT - 187)) | (1L << (INT - 187)) | (1L << (INTEGER - 187)) | (1L << (BIGINT - 187)) | (1L << (FLOAT4 - 187)) | (1L << (FLOAT8 - 187)) | (1L << (REAL - 187)) | (1L << (FLOAT - 187)) | (1L << (DOUBLE - 187)) | (1L << (NUMERIC - 187)))) != 0) || ((((_la - 251)) & ~0x3f) == 0 && ((1L << (_la - 251)) & ((1L << (DECIMAL - 251)) | (1L << (CHAR - 251)) | (1L << (VARCHAR - 251)) | (1L << (NCHAR - 251)) | (1L << (NVARCHAR - 251)) | (1L << (DATE - 251)) | (1L << (TIME - 251)) | (1L << (TIMETZ - 251)) | (1L << (TIMESTAMP - 251)) | (1L << (TIMESTAMPTZ - 251)) | (1L << (TEXT - 251)) | (1L << (VARBINARY - 251)) | (1L << (BLOB - 251)) | (1L << (BYTEA - 251)) | (1L << (INET4 - 251)) | (1L << (QUOTE - 251)) | (1L << (Identifier - 251)))) != 0) );
				setState(978); revoke_from_cascade_restrict();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(980); match(REVOKE);
				setState(984);
				switch ( getInterpreter().adaptivePredict(_input,108,_ctx) ) {
				case 1:
					{
					setState(981); match(ADMIN);
					setState(982); match(OPTION);
					setState(983); match(FOR);
					}
					break;
				}
				setState(990); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(986); ((Revoke_statementContext)_localctx).role_name = identifier();
					setState(988);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(987); match(COMMA);
						}
					}

					}
					}
					setState(992); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 123)) & ~0x3f) == 0 && ((1L << (_la - 123)) & ((1L << (ADMIN - 123)) | (1L << (AVG - 123)) | (1L << (BETWEEN - 123)) | (1L << (BY - 123)) | (1L << (CLASS - 123)) | (1L << (CENTURY - 123)) | (1L << (CHARACTER - 123)) | (1L << (CHECK - 123)) | (1L << (COLLECT - 123)) | (1L << (COALESCE - 123)) | (1L << (COLUMN - 123)) | (1L << (COMMENT - 123)) | (1L << (COMMENTS - 123)) | (1L << (COMMIT - 123)) | (1L << (CONFIGURATION - 123)) | (1L << (COUNT - 123)) | (1L << (CUBE - 123)) | (1L << (DATA - 123)) | (1L << (DAY - 123)) | (1L << (DEC - 123)) | (1L << (DECADE - 123)) | (1L << (DICTIONARY - 123)) | (1L << (DOW - 123)) | (1L << (DOY - 123)) | (1L << (DROP - 123)) | (1L << (EPOCH - 123)) | (1L << (EVERY - 123)) | (1L << (EXISTS - 123)) | (1L << (EXTERNAL - 123)) | (1L << (EXTRACT - 123)) | (1L << (FAMILY - 123)) | (1L << (FILTER - 123)) | (1L << (FIRST - 123)) | (1L << (FORMAT - 123)) | (1L << (FUSION - 123)) | (1L << (GROUPING - 123)) | (1L << (HASH - 123)) | (1L << (INDEX - 123)) | (1L << (INSERT - 123)) | (1L << (INTERSECTION - 123)) | (1L << (ISODOW - 123)) | (1L << (ISOYEAR - 123)) | (1L << (LANGUAGE - 123)) | (1L << (LARGE - 123)) | (1L << (LAST - 123)) | (1L << (LESS - 123)) | (1L << (LIST - 123)) | (1L << (LOCATION - 123)) | (1L << (MATCH - 123)) | (1L << (MAX - 123)) | (1L << (MAXVALUE - 123)) | (1L << (MICROSECONDS - 123)) | (1L << (MILLENNIUM - 123)) | (1L << (MILLISECONDS - 123)) | (1L << (MIN - 123)) | (1L << (MINUTE - 123)) | (1L << (MONTH - 123)) | (1L << (NATIONAL - 123)) | (1L << (NULLIF - 123)) | (1L << (OBJECT - 123)) | (1L << (OPTION - 123)) | (1L << (OPTIONS - 123)))) != 0) || ((((_la - 187)) & ~0x3f) == 0 && ((1L << (_la - 187)) & ((1L << (OVERWRITE - 187)) | (1L << (PARSER - 187)) | (1L << (PARTIAL - 187)) | (1L << (PARTITION - 187)) | (1L << (PARTITIONS - 187)) | (1L << (PRECISION - 187)) | (1L << (PUBLIC - 187)) | (1L << (PURGE - 187)) | (1L << (QUARTER - 187)) | (1L << (RANGE - 187)) | (1L << (REGEXP - 187)) | (1L << (RLIKE - 187)) | (1L << (ROLLUP - 187)) | (1L << (SEARCH - 187)) | (1L << (SECOND - 187)) | (1L << (SERVER - 187)) | (1L << (SET - 187)) | (1L << (SIMILAR - 187)) | (1L << (SIMPLE - 187)) | (1L << (STORAGE - 187)) | (1L << (STDDEV_POP - 187)) | (1L << (STDDEV_SAMP - 187)) | (1L << (SUBPARTITION - 187)) | (1L << (SUM - 187)) | (1L << (TABLESPACE - 187)) | (1L << (TEMPLATE - 187)) | (1L << (THAN - 187)) | (1L << (TIMEZONE - 187)) | (1L << (TIMEZONE_HOUR - 187)) | (1L << (TIMEZONE_MINUTE - 187)) | (1L << (TRIM - 187)) | (1L << (TO - 187)) | (1L << (UNKNOWN - 187)) | (1L << (UNLOGGED - 187)) | (1L << (VALUES - 187)) | (1L << (VAR_SAMP - 187)) | (1L << (VAR_POP - 187)) | (1L << (VARYING - 187)) | (1L << (WEEK - 187)) | (1L << (WRAPPER - 187)) | (1L << (YEAR - 187)) | (1L << (ZONE - 187)) | (1L << (BOOLEAN - 187)) | (1L << (BOOL - 187)) | (1L << (BIT - 187)) | (1L << (VARBIT - 187)) | (1L << (INT1 - 187)) | (1L << (INT2 - 187)) | (1L << (INT4 - 187)) | (1L << (INT8 - 187)) | (1L << (TINYINT - 187)) | (1L << (SMALLINT - 187)) | (1L << (INT - 187)) | (1L << (INTEGER - 187)) | (1L << (BIGINT - 187)) | (1L << (FLOAT4 - 187)) | (1L << (FLOAT8 - 187)) | (1L << (REAL - 187)) | (1L << (FLOAT - 187)) | (1L << (DOUBLE - 187)) | (1L << (NUMERIC - 187)))) != 0) || ((((_la - 251)) & ~0x3f) == 0 && ((1L << (_la - 251)) & ((1L << (DECIMAL - 251)) | (1L << (CHAR - 251)) | (1L << (VARCHAR - 251)) | (1L << (NCHAR - 251)) | (1L << (NVARCHAR - 251)) | (1L << (DATE - 251)) | (1L << (TIME - 251)) | (1L << (TIMETZ - 251)) | (1L << (TIMESTAMP - 251)) | (1L << (TIMESTAMPTZ - 251)) | (1L << (TEXT - 251)) | (1L << (VARBINARY - 251)) | (1L << (BLOB - 251)) | (1L << (BYTEA - 251)) | (1L << (INET4 - 251)) | (1L << (QUOTE - 251)) | (1L << (Identifier - 251)))) != 0) );
				setState(994); match(FROM);
				setState(999); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(995); ((Revoke_statementContext)_localctx).role_name = identifier();
						setState(997);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(996); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1001); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,112,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1004);
				_la = _input.LA(1);
				if (_la==CASCADE || _la==RESTRICT) {
					{
					setState(1003);
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
			setState(1008); match(FROM);
			setState(1017); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(1017);
					switch ( getInterpreter().adaptivePredict(_input,117,_ctx) ) {
					case 1:
						{
						setState(1010);
						_la = _input.LA(1);
						if (_la==GROUP) {
							{
							setState(1009); match(GROUP);
							}
						}

						setState(1012); ((Revoke_from_cascade_restrictContext)_localctx).role_name = identifier();
						}
						break;
					case 2:
						{
						setState(1013); match(PUBLIC);
						setState(1015);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1014); match(COMMA);
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
				setState(1019); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,118,_ctx);
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
		}
		catch (RecognitionException re) {
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
			setState(1349);
			switch ( getInterpreter().adaptivePredict(_input,190,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1024); match(GRANT);
				setState(1034);
				switch (_input.LA(1)) {
				case DELETE:
				case REFERENCES:
				case SELECT:
				case TRIGGER:
				case TRUNCATE:
				case UPDATE:
				case INSERT:
					{
					setState(1026); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1025);
						_la = _input.LA(1);
						if ( !(_la==DELETE || ((((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & ((1L << (REFERENCES - 89)) | (1L << (SELECT - 89)) | (1L << (TRIGGER - 89)) | (1L << (TRUNCATE - 89)) | (1L << (UPDATE - 89)))) != 0) || _la==INSERT) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
						}
						setState(1028); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==DELETE || ((((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & ((1L << (REFERENCES - 89)) | (1L << (SELECT - 89)) | (1L << (TRIGGER - 89)) | (1L << (TRUNCATE - 89)) | (1L << (UPDATE - 89)))) != 0) || _la==INSERT );
					}
					break;
				case ALL:
					{
					setState(1030); match(ALL);
					setState(1032);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1031); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1036); match(ON);
				setState(1060);
				switch (_input.LA(1)) {
				case TABLE:
				case ADMIN:
				case AVG:
				case BETWEEN:
				case BY:
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
				case COUNT:
				case CUBE:
				case DATA:
				case DAY:
				case DEC:
				case DECADE:
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
				case INSERT:
				case INTERSECTION:
				case ISODOW:
				case ISOYEAR:
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
				case MINUTE:
				case MONTH:
				case NATIONAL:
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
				case SERVER:
				case SET:
				case SIMILAR:
				case SIMPLE:
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
				case WEEK:
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
					setState(1038);
					_la = _input.LA(1);
					if (_la==TABLE) {
						{
						setState(1037); match(TABLE);
						}
					}

					setState(1044); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(1040); ((Grant_statementContext)_localctx).tabl_name = schema_qualified_name();
							setState(1042);
							_la = _input.LA(1);
							if (_la==COMMA) {
								{
								setState(1041); match(COMMA);
								}
							}

							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(1046); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,125,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					}
					}
					break;
				case ALL:
					{
					{
					setState(1048); match(ALL);
					setState(1049); match(TABLES);
					setState(1050); match(IN);
					setState(1051); match(SCHEMA);
					setState(1056); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(1052); ((Grant_statementContext)_localctx).schem_name = identifier();
							setState(1054);
							_la = _input.LA(1);
							if (_la==COMMA) {
								{
								setState(1053); match(COMMA);
								}
							}

							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(1058); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,127,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1062); grant_to_rule();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1064); match(GRANT);
				setState(1090);
				switch (_input.LA(1)) {
				case REFERENCES:
				case SELECT:
				case UPDATE:
				case INSERT:
					{
					setState(1074); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1065);
						_la = _input.LA(1);
						if ( !(((((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & ((1L << (REFERENCES - 89)) | (1L << (SELECT - 89)) | (1L << (UPDATE - 89)))) != 0) || _la==INSERT) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(1070); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(1066); ((Grant_statementContext)_localctx).column = identifier();
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
							_alt = getInterpreter().adaptivePredict(_input,130,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						}
						}
						setState(1076); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & ((1L << (REFERENCES - 89)) | (1L << (SELECT - 89)) | (1L << (UPDATE - 89)))) != 0) || _la==INSERT );
					}
					break;
				case ALL:
					{
					setState(1078); match(ALL);
					setState(1080);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1079); match(PRIVILEGES);
						}
					}

					setState(1086); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1082); ((Grant_statementContext)_localctx).column = identifier();
						setState(1084);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1083); match(COMMA);
							}
						}

						}
						}
						setState(1088); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 123)) & ~0x3f) == 0 && ((1L << (_la - 123)) & ((1L << (ADMIN - 123)) | (1L << (AVG - 123)) | (1L << (BETWEEN - 123)) | (1L << (BY - 123)) | (1L << (CLASS - 123)) | (1L << (CENTURY - 123)) | (1L << (CHARACTER - 123)) | (1L << (CHECK - 123)) | (1L << (COLLECT - 123)) | (1L << (COALESCE - 123)) | (1L << (COLUMN - 123)) | (1L << (COMMENT - 123)) | (1L << (COMMENTS - 123)) | (1L << (COMMIT - 123)) | (1L << (CONFIGURATION - 123)) | (1L << (COUNT - 123)) | (1L << (CUBE - 123)) | (1L << (DATA - 123)) | (1L << (DAY - 123)) | (1L << (DEC - 123)) | (1L << (DECADE - 123)) | (1L << (DICTIONARY - 123)) | (1L << (DOW - 123)) | (1L << (DOY - 123)) | (1L << (DROP - 123)) | (1L << (EPOCH - 123)) | (1L << (EVERY - 123)) | (1L << (EXISTS - 123)) | (1L << (EXTERNAL - 123)) | (1L << (EXTRACT - 123)) | (1L << (FAMILY - 123)) | (1L << (FILTER - 123)) | (1L << (FIRST - 123)) | (1L << (FORMAT - 123)) | (1L << (FUSION - 123)) | (1L << (GROUPING - 123)) | (1L << (HASH - 123)) | (1L << (INDEX - 123)) | (1L << (INSERT - 123)) | (1L << (INTERSECTION - 123)) | (1L << (ISODOW - 123)) | (1L << (ISOYEAR - 123)) | (1L << (LANGUAGE - 123)) | (1L << (LARGE - 123)) | (1L << (LAST - 123)) | (1L << (LESS - 123)) | (1L << (LIST - 123)) | (1L << (LOCATION - 123)) | (1L << (MATCH - 123)) | (1L << (MAX - 123)) | (1L << (MAXVALUE - 123)) | (1L << (MICROSECONDS - 123)) | (1L << (MILLENNIUM - 123)) | (1L << (MILLISECONDS - 123)) | (1L << (MIN - 123)) | (1L << (MINUTE - 123)) | (1L << (MONTH - 123)) | (1L << (NATIONAL - 123)) | (1L << (NULLIF - 123)) | (1L << (OBJECT - 123)) | (1L << (OPTION - 123)) | (1L << (OPTIONS - 123)))) != 0) || ((((_la - 187)) & ~0x3f) == 0 && ((1L << (_la - 187)) & ((1L << (OVERWRITE - 187)) | (1L << (PARSER - 187)) | (1L << (PARTIAL - 187)) | (1L << (PARTITION - 187)) | (1L << (PARTITIONS - 187)) | (1L << (PRECISION - 187)) | (1L << (PUBLIC - 187)) | (1L << (PURGE - 187)) | (1L << (QUARTER - 187)) | (1L << (RANGE - 187)) | (1L << (REGEXP - 187)) | (1L << (RLIKE - 187)) | (1L << (ROLLUP - 187)) | (1L << (SEARCH - 187)) | (1L << (SECOND - 187)) | (1L << (SERVER - 187)) | (1L << (SET - 187)) | (1L << (SIMILAR - 187)) | (1L << (SIMPLE - 187)) | (1L << (STORAGE - 187)) | (1L << (STDDEV_POP - 187)) | (1L << (STDDEV_SAMP - 187)) | (1L << (SUBPARTITION - 187)) | (1L << (SUM - 187)) | (1L << (TABLESPACE - 187)) | (1L << (TEMPLATE - 187)) | (1L << (THAN - 187)) | (1L << (TIMEZONE - 187)) | (1L << (TIMEZONE_HOUR - 187)) | (1L << (TIMEZONE_MINUTE - 187)) | (1L << (TRIM - 187)) | (1L << (TO - 187)) | (1L << (UNKNOWN - 187)) | (1L << (UNLOGGED - 187)) | (1L << (VALUES - 187)) | (1L << (VAR_SAMP - 187)) | (1L << (VAR_POP - 187)) | (1L << (VARYING - 187)) | (1L << (WEEK - 187)) | (1L << (WRAPPER - 187)) | (1L << (YEAR - 187)) | (1L << (ZONE - 187)) | (1L << (BOOLEAN - 187)) | (1L << (BOOL - 187)) | (1L << (BIT - 187)) | (1L << (VARBIT - 187)) | (1L << (INT1 - 187)) | (1L << (INT2 - 187)) | (1L << (INT4 - 187)) | (1L << (INT8 - 187)) | (1L << (TINYINT - 187)) | (1L << (SMALLINT - 187)) | (1L << (INT - 187)) | (1L << (INTEGER - 187)) | (1L << (BIGINT - 187)) | (1L << (FLOAT4 - 187)) | (1L << (FLOAT8 - 187)) | (1L << (REAL - 187)) | (1L << (FLOAT - 187)) | (1L << (DOUBLE - 187)) | (1L << (NUMERIC - 187)))) != 0) || ((((_la - 251)) & ~0x3f) == 0 && ((1L << (_la - 251)) & ((1L << (DECIMAL - 251)) | (1L << (CHAR - 251)) | (1L << (VARCHAR - 251)) | (1L << (NCHAR - 251)) | (1L << (NVARCHAR - 251)) | (1L << (DATE - 251)) | (1L << (TIME - 251)) | (1L << (TIMETZ - 251)) | (1L << (TIMESTAMP - 251)) | (1L << (TIMESTAMPTZ - 251)) | (1L << (TEXT - 251)) | (1L << (VARBINARY - 251)) | (1L << (BLOB - 251)) | (1L << (BYTEA - 251)) | (1L << (INET4 - 251)) | (1L << (QUOTE - 251)) | (1L << (Identifier - 251)))) != 0) );
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1092); match(ON);
				setState(1100); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1094);
						_la = _input.LA(1);
						if (_la==TABLE) {
							{
							setState(1093); match(TABLE);
							}
						}

						setState(1096); ((Grant_statementContext)_localctx).tabl_name = schema_qualified_name();
						setState(1098);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1097); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1102); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,138,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1104); grant_to_rule();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1106); match(GRANT);
				setState(1119);
				switch (_input.LA(1)) {
				case SELECT:
				case UPDATE:
				case USAGE:
					{
					setState(1111); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1107);
						_la = _input.LA(1);
						if ( !(((((_la - 98)) & ~0x3f) == 0 && ((1L << (_la - 98)) & ((1L << (SELECT - 98)) | (1L << (UPDATE - 98)) | (1L << (USAGE - 98)))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
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
					} while ( ((((_la - 98)) & ~0x3f) == 0 && ((1L << (_la - 98)) & ((1L << (SELECT - 98)) | (1L << (UPDATE - 98)) | (1L << (USAGE - 98)))) != 0) );
					}
					break;
				case ALL:
					{
					setState(1115); match(ALL);
					setState(1117);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1116); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1121); match(ON);
				setState(1143);
				switch (_input.LA(1)) {
				case SEQUENCE:
					{
					setState(1127); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1122); match(SEQUENCE);
						setState(1123); ((Grant_statementContext)_localctx).sequence_name = identifier();
						setState(1125);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1124); match(COMMA);
							}
						}

						}
						}
						setState(1129); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==SEQUENCE );
					}
					break;
				case ALL:
					{
					setState(1131); match(ALL);
					setState(1132); match(SEQUENCES);
					setState(1133); match(IN);
					setState(1134); match(SCHEMA);
					setState(1139); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(1135); ((Grant_statementContext)_localctx).schema_name = identifier();
							setState(1137);
							_la = _input.LA(1);
							if (_la==COMMA) {
								{
								setState(1136); match(COMMA);
								}
							}

							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(1141); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,146,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1145); grant_to_rule();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1147); match(GRANT);
				setState(1160);
				switch (_input.LA(1)) {
				case CONNECT:
				case CREATE:
				case TEMP:
				case TEMPORARY:
					{
					setState(1152); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1148);
						_la = _input.LA(1);
						if ( !(_la==CONNECT || _la==CREATE || _la==TEMP || _la==TEMPORARY) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(1150);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1149); match(COMMA);
							}
						}

						}
						}
						setState(1154); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==CONNECT || _la==CREATE || _la==TEMP || _la==TEMPORARY );
					}
					break;
				case ALL:
					{
					setState(1156); match(ALL);
					setState(1158);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1157); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1162); match(ON);
				setState(1163); match(DATABASE);
				setState(1168); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1164); ((Grant_statementContext)_localctx).database_name = identifier();
						setState(1166);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1165); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1170); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,153,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1172); grant_to_rule();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1174); match(GRANT);
				setState(1180);
				switch (_input.LA(1)) {
				case USAGE:
					{
					setState(1175); match(USAGE);
					}
					break;
				case ALL:
					{
					setState(1176); match(ALL);
					setState(1178);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1177); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1182); match(ON);
				setState(1183); match(FOREIGN);
				setState(1184); match(DATA);
				setState(1185); match(WRAPPER);
				setState(1190); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1186); ((Grant_statementContext)_localctx).fdw_name = identifier();
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
					_alt = getInterpreter().adaptivePredict(_input,157,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1194); grant_to_rule();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
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
				setState(1206); match(SERVER);
				setState(1211); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1207); ((Grant_statementContext)_localctx).server_name = identifier();
						setState(1209);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1208); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1213); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,161,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1215); grant_to_rule();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1217); match(GRANT);
				setState(1223);
				switch (_input.LA(1)) {
				case EXECUTE:
					{
					setState(1218); match(EXECUTE);
					}
					break;
				case ALL:
					{
					setState(1219); match(ALL);
					setState(1221);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1220); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1225); match(ON);
				setState(1228);
				switch (_input.LA(1)) {
				case FUNCTION:
					{
					setState(1226); function_definition();
					}
					break;
				case ALL:
					{
					setState(1227); functions_definition_schema();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1230); grant_to_rule();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(1232); match(GRANT);
				setState(1238);
				switch (_input.LA(1)) {
				case USAGE:
					{
					setState(1233); match(USAGE);
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
				setState(1241); match(LANGUAGE);
				setState(1246); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1242); ((Grant_statementContext)_localctx).lang_name = identifier();
						setState(1244);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1243); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1248); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,168,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1250); grant_to_rule();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(1252); match(GRANT);
				setState(1265);
				switch (_input.LA(1)) {
				case SELECT:
				case UPDATE:
					{
					setState(1257); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1253);
						_la = _input.LA(1);
						if ( !(_la==SELECT || _la==UPDATE) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(1255);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1254); match(COMMA);
							}
						}

						}
						}
						setState(1259); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==SELECT || _la==UPDATE );
					}
					break;
				case ALL:
					{
					setState(1261); match(ALL);
					setState(1263);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1262); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1267); match(ON);
				setState(1268); match(LARGE);
				setState(1269); match(OBJECT);
				setState(1274); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1270); ((Grant_statementContext)_localctx).loid = identifier();
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
					_alt = getInterpreter().adaptivePredict(_input,174,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1278); grant_to_rule();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(1280); match(GRANT);
				setState(1293);
				switch (_input.LA(1)) {
				case CREATE:
				case USAGE:
					{
					setState(1285); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1281);
						_la = _input.LA(1);
						if ( !(_la==CREATE || _la==USAGE) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(1283);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1282); match(COMMA);
							}
						}

						}
						}
						setState(1287); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==CREATE || _la==USAGE );
					}
					break;
				case ALL:
					{
					setState(1289); match(ALL);
					setState(1291);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1290); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1295); match(ON);
				setState(1296); match(SCHEMA);
				setState(1301); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1297); ((Grant_statementContext)_localctx).schema_name = identifier();
						setState(1299);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1298); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1303); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,180,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1305); grant_to_rule();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(1307); match(GRANT);
				setState(1313);
				switch (_input.LA(1)) {
				case CREATE:
					{
					setState(1308); match(CREATE);
					}
					break;
				case ALL:
					{
					setState(1309); match(ALL);
					setState(1311);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1310); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1315); match(ON);
				setState(1316); match(TABLESPACE);
				setState(1321); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1317); ((Grant_statementContext)_localctx).tablespace_name = identifier();
						setState(1319);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1318); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1323); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,184,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1325); grant_to_rule();
				setState(1326); match(GRANT);
				setState(1331); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1327); ((Grant_statementContext)_localctx).role_name = identifier();
						setState(1329);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1328); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1333); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,186,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1335); match(TO);
				setState(1340); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1336); ((Grant_statementContext)_localctx).role_name = identifier();
						setState(1338);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1337); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1342); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,188,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1347);
				_la = _input.LA(1);
				if (_la==WITH) {
					{
					setState(1344); match(WITH);
					setState(1345); match(ADMIN);
					setState(1346); match(OPTION);
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
			setState(1351); match(TO);
			setState(1362); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(1353);
					_la = _input.LA(1);
					if (_la==GROUP) {
						{
						setState(1352); match(GROUP);
						}
					}

					setState(1357);
					switch ( getInterpreter().adaptivePredict(_input,192,_ctx) ) {
					case 1:
						{
						{
						setState(1355); ((Grant_to_ruleContext)_localctx).role_name = identifier();
						}
						}
						break;
					case 2:
						{
						setState(1356); match(PUBLIC);
						}
						break;
					}
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
				_alt = getInterpreter().adaptivePredict(_input,194,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(1369);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(1366); match(WITH);
				setState(1367); match(GRANT);
				setState(1368); match(OPTION);
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
		public TerminalNode QUOTE(int i) {
			return getToken(SQLParser.QUOTE, i);
		}
		public TerminalNode DATABASE() { return getToken(SQLParser.DATABASE, 0); }
		public TerminalNode LARGE() { return getToken(SQLParser.LARGE, 0); }
		public TerminalNode PROCEDURAL() { return getToken(SQLParser.PROCEDURAL, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public TerminalNode SEQUENCE() { return getToken(SQLParser.SEQUENCE, 0); }
		public TerminalNode PARSER() { return getToken(SQLParser.PARSER, 0); }
		public List<TerminalNode> QUOTE() { return getTokens(SQLParser.QUOTE); }
		public TerminalNode FUNCTION() { return getToken(SQLParser.FUNCTION, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public Schema_qualified_nameContext schema_qualified_name(int i) {
			return getRuleContext(Schema_qualified_nameContext.class,i);
		}
		public TerminalNode FAMILY() { return getToken(SQLParser.FAMILY, 0); }
		public List<Schema_qualified_nameContext> schema_qualified_name() {
			return getRuleContexts(Schema_qualified_nameContext.class);
		}
		public Routine_invocationContext routine_invocation() {
			return getRuleContext(Routine_invocationContext.class,0);
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
		enterRule(_localctx, 26, RULE_comment_on_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1371); match(COMMENT);
			setState(1372); match(ON);
			setState(1492);
			switch ( getInterpreter().adaptivePredict(_input,199,_ctx) ) {
			case 1:
				{
				setState(1373); match(AGGREGATE);
				setState(1374); ((Comment_on_statementContext)_localctx).agg_name = schema_qualified_name();
				setState(1375); match(LEFT_PAREN);
				setState(1382);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (CHARACTER - 129)) | (1L << (DEC - 129)) | (1L << (NATIONAL - 129)))) != 0) || ((((_la - 231)) & ~0x3f) == 0 && ((1L << (_la - 231)) & ((1L << (BOOLEAN - 231)) | (1L << (BOOL - 231)) | (1L << (BIT - 231)) | (1L << (VARBIT - 231)) | (1L << (INT1 - 231)) | (1L << (INT2 - 231)) | (1L << (INT4 - 231)) | (1L << (INT8 - 231)) | (1L << (TINYINT - 231)) | (1L << (SMALLINT - 231)) | (1L << (INT - 231)) | (1L << (INTEGER - 231)) | (1L << (BIGINT - 231)) | (1L << (FLOAT4 - 231)) | (1L << (FLOAT8 - 231)) | (1L << (REAL - 231)) | (1L << (REGCLASS - 231)) | (1L << (FLOAT - 231)) | (1L << (DOUBLE - 231)) | (1L << (NUMERIC - 231)) | (1L << (DECIMAL - 231)) | (1L << (CHAR - 231)) | (1L << (VARCHAR - 231)) | (1L << (NCHAR - 231)) | (1L << (NVARCHAR - 231)) | (1L << (DATE - 231)) | (1L << (TIME - 231)) | (1L << (TIMETZ - 231)) | (1L << (TIMESTAMP - 231)) | (1L << (TIMESTAMPTZ - 231)) | (1L << (TEXT - 231)) | (1L << (BINARY - 231)) | (1L << (VARBINARY - 231)) | (1L << (BLOB - 231)) | (1L << (BYTEA - 231)) | (1L << (INET4 - 231)))) != 0)) {
					{
					{
					setState(1376); ((Comment_on_statementContext)_localctx).agg_type = data_type();
					setState(1378);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1377); match(COMMA);
						}
					}

					}
					}
					setState(1384);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1385); match(RIGHT_PAREN);
				}
				break;
			case 2:
				{
				setState(1387); match(CAST);
				setState(1388); match(LEFT_PAREN);
				setState(1389); ((Comment_on_statementContext)_localctx).source_type = data_type();
				setState(1390); match(AS);
				setState(1391); ((Comment_on_statementContext)_localctx).target_type = data_type();
				setState(1392); match(RIGHT_PAREN);
				}
				break;
			case 3:
				{
				setState(1394); match(COLLATION);
				setState(1395); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 4:
				{
				setState(1396); match(COLUMN);
				setState(1397); ((Comment_on_statementContext)_localctx).column_name = schema_qualified_name();
				}
				break;
			case 5:
				{
				setState(1398); match(CONSTRAINT);
				setState(1399); ((Comment_on_statementContext)_localctx).constraint_name = schema_qualified_name();
				setState(1400); match(ON);
				setState(1401); ((Comment_on_statementContext)_localctx).table_name = schema_qualified_name();
				}
				break;
			case 6:
				{
				setState(1403); match(CONVERSION);
				setState(1404); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 7:
				{
				setState(1405); match(DATABASE);
				setState(1406); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 8:
				{
				setState(1407); match(DOMAIN);
				setState(1408); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 9:
				{
				setState(1409); match(EXTENSION);
				setState(1410); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 10:
				{
				setState(1411); match(FOREIGN);
				setState(1412); match(DATA);
				setState(1413); match(WRAPPER);
				setState(1414); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 11:
				{
				setState(1415); match(FOREIGN);
				setState(1416); match(TABLE);
				setState(1417); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 12:
				{
				setState(1418); match(FUNCTION);
				setState(1419); routine_invocation();
				}
				break;
			case 13:
				{
				setState(1420); match(INDEX);
				setState(1421); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 14:
				{
				setState(1422); match(LARGE);
				setState(1423); match(OBJECT);
				setState(1424); ((Comment_on_statementContext)_localctx).large_object_oid = identifier();
				}
				break;
			case 15:
				{
				setState(1425); match(OPERATOR);
				setState(1426); ((Comment_on_statementContext)_localctx).operator_name = schema_qualified_name();
				setState(1427); match(LEFT_PAREN);
				setState(1428); ((Comment_on_statementContext)_localctx).left_type = data_type();
				setState(1429); match(COMMA);
				setState(1430); ((Comment_on_statementContext)_localctx).right_type = data_type();
				setState(1431); match(RIGHT_PAREN);
				}
				break;
			case 16:
				{
				setState(1433); match(OPERATOR);
				setState(1434); match(CLASS);
				setState(1435); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				setState(1436); match(USING);
				setState(1437); ((Comment_on_statementContext)_localctx).index_method = identifier();
				}
				break;
			case 17:
				{
				setState(1439); match(OPERATOR);
				setState(1440); match(FAMILY);
				setState(1441); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				setState(1442); match(USING);
				setState(1443); ((Comment_on_statementContext)_localctx).index_method = identifier();
				}
				break;
			case 18:
				{
				setState(1446);
				_la = _input.LA(1);
				if (_la==PROCEDURAL) {
					{
					setState(1445); match(PROCEDURAL);
					}
				}

				setState(1448); match(LANGUAGE);
				setState(1449); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 19:
				{
				setState(1450); match(ROLE);
				setState(1451); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 20:
				{
				setState(1452); match(RULE);
				setState(1453); ((Comment_on_statementContext)_localctx).rule_name = schema_qualified_name();
				setState(1454); match(ON);
				setState(1455); ((Comment_on_statementContext)_localctx).table_name = schema_qualified_name();
				}
				break;
			case 21:
				{
				setState(1457); match(SCHEMA);
				setState(1458); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 22:
				{
				setState(1459); match(SEQUENCE);
				setState(1460); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 23:
				{
				setState(1461); match(SERVER);
				setState(1462); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 24:
				{
				setState(1463); match(TABLE);
				setState(1464); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 25:
				{
				setState(1465); match(TABLESPACE);
				setState(1466); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 26:
				{
				setState(1467); match(TEXT);
				setState(1468); match(SEARCH);
				setState(1469); match(CONFIGURATION);
				setState(1470); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 27:
				{
				setState(1471); match(TEXT);
				setState(1472); match(SEARCH);
				setState(1473); match(DICTIONARY);
				setState(1474); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 28:
				{
				setState(1475); match(TEXT);
				setState(1476); match(SEARCH);
				setState(1477); match(PARSER);
				setState(1478); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 29:
				{
				setState(1479); match(TEXT);
				setState(1480); match(SEARCH);
				setState(1481); match(TEMPLATE);
				setState(1482); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 30:
				{
				setState(1483); match(TRIGGER);
				setState(1484); ((Comment_on_statementContext)_localctx).trigger_name = schema_qualified_name();
				setState(1485); match(ON);
				setState(1486); ((Comment_on_statementContext)_localctx).table_name = schema_qualified_name();
				}
				break;
			case 31:
				{
				setState(1488); match(TYPE);
				setState(1489); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 32:
				{
				setState(1490); match(VIEW);
				setState(1491); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			}
			setState(1494); match(IS);
			setState(1495); match(QUOTE);
			setState(1496); match(Character_String_Literal);
			setState(1497); match(QUOTE);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 28, RULE_argmode);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1499);
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
		enterRule(_localctx, 30, RULE_function_definition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1501); match(FUNCTION);
			setState(1502); ((Function_definitionContext)_localctx).func_name = identifier();
			setState(1503); match(LEFT_PAREN);
			setState(1516);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 53)) & ~0x3f) == 0 && ((1L << (_la - 53)) & ((1L << (IN - 53)) | (1L << (INOUT - 53)) | (1L << (OUT - 53)))) != 0) || ((((_la - 117)) & ~0x3f) == 0 && ((1L << (_la - 117)) & ((1L << (VARIADIC - 117)) | (1L << (ADMIN - 117)) | (1L << (AVG - 117)) | (1L << (BETWEEN - 117)) | (1L << (BY - 117)) | (1L << (CLASS - 117)) | (1L << (CENTURY - 117)) | (1L << (CHARACTER - 117)) | (1L << (CHECK - 117)) | (1L << (COLLECT - 117)) | (1L << (COALESCE - 117)) | (1L << (COLUMN - 117)) | (1L << (COMMENT - 117)) | (1L << (COMMENTS - 117)) | (1L << (COMMIT - 117)) | (1L << (CONFIGURATION - 117)) | (1L << (COUNT - 117)) | (1L << (CUBE - 117)) | (1L << (DATA - 117)) | (1L << (DAY - 117)) | (1L << (DEC - 117)) | (1L << (DECADE - 117)) | (1L << (DICTIONARY - 117)) | (1L << (DOW - 117)) | (1L << (DOY - 117)) | (1L << (DROP - 117)) | (1L << (EPOCH - 117)) | (1L << (EVERY - 117)) | (1L << (EXISTS - 117)) | (1L << (EXTERNAL - 117)) | (1L << (EXTRACT - 117)) | (1L << (FAMILY - 117)) | (1L << (FILTER - 117)) | (1L << (FIRST - 117)) | (1L << (FORMAT - 117)) | (1L << (FUSION - 117)) | (1L << (GROUPING - 117)) | (1L << (HASH - 117)) | (1L << (INDEX - 117)) | (1L << (INSERT - 117)) | (1L << (INTERSECTION - 117)) | (1L << (ISODOW - 117)) | (1L << (ISOYEAR - 117)) | (1L << (LANGUAGE - 117)) | (1L << (LARGE - 117)) | (1L << (LAST - 117)) | (1L << (LESS - 117)) | (1L << (LIST - 117)) | (1L << (LOCATION - 117)) | (1L << (MATCH - 117)) | (1L << (MAX - 117)) | (1L << (MAXVALUE - 117)) | (1L << (MICROSECONDS - 117)) | (1L << (MILLENNIUM - 117)) | (1L << (MILLISECONDS - 117)) | (1L << (MIN - 117)) | (1L << (MINUTE - 117)))) != 0) || ((((_la - 181)) & ~0x3f) == 0 && ((1L << (_la - 181)) & ((1L << (MONTH - 181)) | (1L << (NATIONAL - 181)) | (1L << (NULLIF - 181)) | (1L << (OBJECT - 181)) | (1L << (OPTION - 181)) | (1L << (OPTIONS - 181)) | (1L << (OVERWRITE - 181)) | (1L << (PARSER - 181)) | (1L << (PARTIAL - 181)) | (1L << (PARTITION - 181)) | (1L << (PARTITIONS - 181)) | (1L << (PRECISION - 181)) | (1L << (PUBLIC - 181)) | (1L << (PURGE - 181)) | (1L << (QUARTER - 181)) | (1L << (RANGE - 181)) | (1L << (REGEXP - 181)) | (1L << (RLIKE - 181)) | (1L << (ROLLUP - 181)) | (1L << (SEARCH - 181)) | (1L << (SECOND - 181)) | (1L << (SERVER - 181)) | (1L << (SET - 181)) | (1L << (SIMILAR - 181)) | (1L << (SIMPLE - 181)) | (1L << (STORAGE - 181)) | (1L << (STDDEV_POP - 181)) | (1L << (STDDEV_SAMP - 181)) | (1L << (SUBPARTITION - 181)) | (1L << (SUM - 181)) | (1L << (TABLESPACE - 181)) | (1L << (TEMPLATE - 181)) | (1L << (THAN - 181)) | (1L << (TIMEZONE - 181)) | (1L << (TIMEZONE_HOUR - 181)) | (1L << (TIMEZONE_MINUTE - 181)) | (1L << (TRIM - 181)) | (1L << (TO - 181)) | (1L << (UNKNOWN - 181)) | (1L << (UNLOGGED - 181)) | (1L << (VALUES - 181)) | (1L << (VAR_SAMP - 181)) | (1L << (VAR_POP - 181)) | (1L << (VARYING - 181)) | (1L << (WEEK - 181)) | (1L << (WRAPPER - 181)) | (1L << (YEAR - 181)) | (1L << (ZONE - 181)) | (1L << (BOOLEAN - 181)) | (1L << (BOOL - 181)) | (1L << (BIT - 181)) | (1L << (VARBIT - 181)) | (1L << (INT1 - 181)) | (1L << (INT2 - 181)) | (1L << (INT4 - 181)) | (1L << (INT8 - 181)) | (1L << (TINYINT - 181)) | (1L << (SMALLINT - 181)) | (1L << (INT - 181)) | (1L << (INTEGER - 181)) | (1L << (BIGINT - 181)) | (1L << (FLOAT4 - 181)))) != 0) || ((((_la - 245)) & ~0x3f) == 0 && ((1L << (_la - 245)) & ((1L << (FLOAT8 - 245)) | (1L << (REAL - 245)) | (1L << (REGCLASS - 245)) | (1L << (FLOAT - 245)) | (1L << (DOUBLE - 245)) | (1L << (NUMERIC - 245)) | (1L << (DECIMAL - 245)) | (1L << (CHAR - 245)) | (1L << (VARCHAR - 245)) | (1L << (NCHAR - 245)) | (1L << (NVARCHAR - 245)) | (1L << (DATE - 245)) | (1L << (TIME - 245)) | (1L << (TIMETZ - 245)) | (1L << (TIMESTAMP - 245)) | (1L << (TIMESTAMPTZ - 245)) | (1L << (TEXT - 245)) | (1L << (BINARY - 245)) | (1L << (VARBINARY - 245)) | (1L << (BLOB - 245)) | (1L << (BYTEA - 245)) | (1L << (INET4 - 245)) | (1L << (QUOTE - 245)) | (1L << (Identifier - 245)))) != 0)) {
				{
				{
				setState(1505);
				_la = _input.LA(1);
				if (_la==IN || _la==INOUT || _la==OUT || _la==VARIADIC) {
					{
					setState(1504); ((Function_definitionContext)_localctx).arg_mode = argmode();
					}
				}

				setState(1508);
				switch ( getInterpreter().adaptivePredict(_input,201,_ctx) ) {
				case 1:
					{
					setState(1507); ((Function_definitionContext)_localctx).argname = identifier();
					}
					break;
				}
				setState(1510); ((Function_definitionContext)_localctx).argtype = data_type();
				setState(1512);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(1511); match(COMMA);
					}
				}

				}
				}
				setState(1518);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1519); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 32, RULE_functions_definition_schema);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1521); match(ALL);
			setState(1522); match(FUNCTIONS);
			setState(1523); match(IN);
			setState(1524); match(SCHEMA);
			setState(1529); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(1525); ((Functions_definition_schemaContext)_localctx).schema_name = identifier();
					setState(1527);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1526); match(COMMA);
						}
					}

					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1531); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,205,_ctx);
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
		enterRule(_localctx, 34, RULE_create_table_statement);
		int _la;
		try {
			int _alt;
			setState(1695);
			switch ( getInterpreter().adaptivePredict(_input,236,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1533); match(CREATE);
				setState(1534); match(EXTERNAL);
				setState(1535); match(TABLE);
				setState(1536); ((Create_table_statementContext)_localctx).n = schema_qualified_name();
				setState(1537); table_elements();
				setState(1538); match(USING);
				setState(1539); ((Create_table_statementContext)_localctx).file_type = identifier();
				setState(1541);
				_la = _input.LA(1);
				if (_la==WITH) {
					{
					setState(1540); param_clause();
					}
				}

				setState(1544);
				_la = _input.LA(1);
				if (_la==PARTITION) {
					{
					setState(1543); table_partitioning_clauses();
					}
				}

				{
				setState(1546); match(LOCATION);
				setState(1547); ((Create_table_statementContext)_localctx).path = match(Character_String_Literal);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1549); match(CREATE);
				setState(1550); match(TABLE);
				setState(1551); ((Create_table_statementContext)_localctx).n = schema_qualified_name();
				setState(1552); table_elements();
				setState(1555);
				_la = _input.LA(1);
				if (_la==USING) {
					{
					setState(1553); match(USING);
					setState(1554); ((Create_table_statementContext)_localctx).file_type = identifier();
					}
				}

				setState(1558);
				_la = _input.LA(1);
				if (_la==WITH) {
					{
					setState(1557); param_clause();
					}
				}

				setState(1561);
				switch ( getInterpreter().adaptivePredict(_input,210,_ctx) ) {
				case 1:
					{
					setState(1560); table_partitioning_clauses();
					}
					break;
				}
				setState(1565);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(1563); match(AS);
					setState(1564); query_expression();
					}
				}

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1567); match(CREATE);
				setState(1568); match(TABLE);
				setState(1569); ((Create_table_statementContext)_localctx).n = schema_qualified_name();
				setState(1572);
				_la = _input.LA(1);
				if (_la==USING) {
					{
					setState(1570); match(USING);
					setState(1571); ((Create_table_statementContext)_localctx).file_type = identifier();
					}
				}

				setState(1575);
				_la = _input.LA(1);
				if (_la==WITH) {
					{
					setState(1574); param_clause();
					}
				}

				setState(1578);
				_la = _input.LA(1);
				if (_la==PARTITION) {
					{
					setState(1577); table_partitioning_clauses();
					}
				}

				setState(1580); match(AS);
				setState(1581); query_expression();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1583); match(CREATE);
				setState(1589);
				switch (_input.LA(1)) {
				case GLOBAL:
				case LOCAL:
				case TEMP:
				case TEMPORARY:
					{
					setState(1585);
					_la = _input.LA(1);
					if (_la==GLOBAL || _la==LOCAL) {
						{
						setState(1584);
						_la = _input.LA(1);
						if ( !(_la==GLOBAL || _la==LOCAL) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
					}

					setState(1587);
					_la = _input.LA(1);
					if ( !(_la==TEMP || _la==TEMPORARY) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
					break;
				case UNLOGGED:
					{
					setState(1588); match(UNLOGGED);
					}
					break;
				case TABLE:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1591); match(TABLE);
				setState(1595);
				_la = _input.LA(1);
				if (_la==IF) {
					{
					setState(1592); match(IF);
					setState(1593); match(NOT);
					setState(1594); match(EXISTS);
					}
				}

				setState(1597); ((Create_table_statementContext)_localctx).n = schema_qualified_name();
				setState(1598); match(LEFT_PAREN);
				setState(1629);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CONSTRAINT) | (1L << EXCLUDE) | (1L << FOREIGN))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (LIKE - 67)) | (1L << (PRIMARY - 67)) | (1L << (UNIQUE - 67)) | (1L << (ADMIN - 67)) | (1L << (AVG - 67)) | (1L << (BETWEEN - 67)) | (1L << (BY - 67)) | (1L << (CLASS - 67)) | (1L << (CENTURY - 67)) | (1L << (CHARACTER - 67)) | (1L << (CHECK - 67)))) != 0) || ((((_la - 131)) & ~0x3f) == 0 && ((1L << (_la - 131)) & ((1L << (COLLECT - 131)) | (1L << (COALESCE - 131)) | (1L << (COLUMN - 131)) | (1L << (COMMENT - 131)) | (1L << (COMMENTS - 131)) | (1L << (COMMIT - 131)) | (1L << (CONFIGURATION - 131)) | (1L << (COUNT - 131)) | (1L << (CUBE - 131)) | (1L << (DATA - 131)) | (1L << (DAY - 131)) | (1L << (DEC - 131)) | (1L << (DECADE - 131)) | (1L << (DICTIONARY - 131)) | (1L << (DOW - 131)) | (1L << (DOY - 131)) | (1L << (DROP - 131)) | (1L << (EPOCH - 131)) | (1L << (EVERY - 131)) | (1L << (EXISTS - 131)) | (1L << (EXTERNAL - 131)) | (1L << (EXTRACT - 131)) | (1L << (FAMILY - 131)) | (1L << (FILTER - 131)) | (1L << (FIRST - 131)) | (1L << (FORMAT - 131)) | (1L << (FUSION - 131)) | (1L << (GROUPING - 131)) | (1L << (HASH - 131)) | (1L << (INDEX - 131)) | (1L << (INSERT - 131)) | (1L << (INTERSECTION - 131)) | (1L << (ISODOW - 131)) | (1L << (ISOYEAR - 131)) | (1L << (LANGUAGE - 131)) | (1L << (LARGE - 131)) | (1L << (LAST - 131)) | (1L << (LESS - 131)) | (1L << (LIST - 131)) | (1L << (LOCATION - 131)) | (1L << (MATCH - 131)) | (1L << (MAX - 131)) | (1L << (MAXVALUE - 131)) | (1L << (MICROSECONDS - 131)) | (1L << (MILLENNIUM - 131)) | (1L << (MILLISECONDS - 131)) | (1L << (MIN - 131)) | (1L << (MINUTE - 131)) | (1L << (MONTH - 131)) | (1L << (NATIONAL - 131)) | (1L << (NULLIF - 131)) | (1L << (OBJECT - 131)) | (1L << (OPTION - 131)) | (1L << (OPTIONS - 131)) | (1L << (OVERWRITE - 131)) | (1L << (PARSER - 131)) | (1L << (PARTIAL - 131)) | (1L << (PARTITION - 131)) | (1L << (PARTITIONS - 131)) | (1L << (PRECISION - 131)) | (1L << (PUBLIC - 131)) | (1L << (PURGE - 131)))) != 0) || ((((_la - 195)) & ~0x3f) == 0 && ((1L << (_la - 195)) & ((1L << (QUARTER - 195)) | (1L << (RANGE - 195)) | (1L << (REGEXP - 195)) | (1L << (RLIKE - 195)) | (1L << (ROLLUP - 195)) | (1L << (SEARCH - 195)) | (1L << (SECOND - 195)) | (1L << (SERVER - 195)) | (1L << (SET - 195)) | (1L << (SIMILAR - 195)) | (1L << (SIMPLE - 195)) | (1L << (STORAGE - 195)) | (1L << (STDDEV_POP - 195)) | (1L << (STDDEV_SAMP - 195)) | (1L << (SUBPARTITION - 195)) | (1L << (SUM - 195)) | (1L << (TABLESPACE - 195)) | (1L << (TEMPLATE - 195)) | (1L << (THAN - 195)) | (1L << (TIMEZONE - 195)) | (1L << (TIMEZONE_HOUR - 195)) | (1L << (TIMEZONE_MINUTE - 195)) | (1L << (TRIM - 195)) | (1L << (TO - 195)) | (1L << (UNKNOWN - 195)) | (1L << (UNLOGGED - 195)) | (1L << (VALUES - 195)) | (1L << (VAR_SAMP - 195)) | (1L << (VAR_POP - 195)) | (1L << (VARYING - 195)) | (1L << (WEEK - 195)) | (1L << (WRAPPER - 195)) | (1L << (YEAR - 195)) | (1L << (ZONE - 195)) | (1L << (BOOLEAN - 195)) | (1L << (BOOL - 195)) | (1L << (BIT - 195)) | (1L << (VARBIT - 195)) | (1L << (INT1 - 195)) | (1L << (INT2 - 195)) | (1L << (INT4 - 195)) | (1L << (INT8 - 195)) | (1L << (TINYINT - 195)) | (1L << (SMALLINT - 195)) | (1L << (INT - 195)) | (1L << (INTEGER - 195)) | (1L << (BIGINT - 195)) | (1L << (FLOAT4 - 195)) | (1L << (FLOAT8 - 195)) | (1L << (REAL - 195)) | (1L << (FLOAT - 195)) | (1L << (DOUBLE - 195)) | (1L << (NUMERIC - 195)) | (1L << (DECIMAL - 195)) | (1L << (CHAR - 195)) | (1L << (VARCHAR - 195)) | (1L << (NCHAR - 195)) | (1L << (NVARCHAR - 195)) | (1L << (DATE - 195)) | (1L << (TIME - 195)) | (1L << (TIMETZ - 195)))) != 0) || ((((_la - 259)) & ~0x3f) == 0 && ((1L << (_la - 259)) & ((1L << (TIMESTAMP - 259)) | (1L << (TIMESTAMPTZ - 259)) | (1L << (TEXT - 259)) | (1L << (VARBINARY - 259)) | (1L << (BLOB - 259)) | (1L << (BYTEA - 259)) | (1L << (INET4 - 259)) | (1L << (QUOTE - 259)) | (1L << (Identifier - 259)))) != 0)) {
					{
					setState(1625); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1620);
						switch ( getInterpreter().adaptivePredict(_input,221,_ctx) ) {
						case 1:
							{
							{
							setState(1599); ((Create_table_statementContext)_localctx).column_name = identifier();
							setState(1600); ((Create_table_statementContext)_localctx).datatype = data_type();
							setState(1603);
							_la = _input.LA(1);
							if (_la==COLLATE) {
								{
								setState(1601); match(COLLATE);
								setState(1602); ((Create_table_statementContext)_localctx).collation = identifier();
								}
							}

							setState(1608);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,219,_ctx);
							while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
								if ( _alt==1 ) {
									{
									{
									setState(1605); ((Create_table_statementContext)_localctx).colmn_constraint = column_constraint();
									}
									} 
								}
								setState(1610);
								_errHandler.sync(this);
								_alt = getInterpreter().adaptivePredict(_input,219,_ctx);
							}
							}
							}
							break;
						case 2:
							{
							setState(1611); ((Create_table_statementContext)_localctx).tabl_constraint = table_constraint();
							}
							break;
						case 3:
							{
							{
							setState(1612); match(LIKE);
							setState(1613); ((Create_table_statementContext)_localctx).parent_table = identifier();
							setState(1617);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==EXCLUDING || _la==INCLUDING) {
								{
								{
								setState(1614); ((Create_table_statementContext)_localctx).like_opt = like_option();
								}
								}
								setState(1619);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
							}
							break;
						}
						setState(1623);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1622); match(COMMA);
							}
						}

						}
						}
						setState(1627); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CONSTRAINT) | (1L << EXCLUDE) | (1L << FOREIGN))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (LIKE - 67)) | (1L << (PRIMARY - 67)) | (1L << (UNIQUE - 67)) | (1L << (ADMIN - 67)) | (1L << (AVG - 67)) | (1L << (BETWEEN - 67)) | (1L << (BY - 67)) | (1L << (CLASS - 67)) | (1L << (CENTURY - 67)) | (1L << (CHARACTER - 67)) | (1L << (CHECK - 67)))) != 0) || ((((_la - 131)) & ~0x3f) == 0 && ((1L << (_la - 131)) & ((1L << (COLLECT - 131)) | (1L << (COALESCE - 131)) | (1L << (COLUMN - 131)) | (1L << (COMMENT - 131)) | (1L << (COMMENTS - 131)) | (1L << (COMMIT - 131)) | (1L << (CONFIGURATION - 131)) | (1L << (COUNT - 131)) | (1L << (CUBE - 131)) | (1L << (DATA - 131)) | (1L << (DAY - 131)) | (1L << (DEC - 131)) | (1L << (DECADE - 131)) | (1L << (DICTIONARY - 131)) | (1L << (DOW - 131)) | (1L << (DOY - 131)) | (1L << (DROP - 131)) | (1L << (EPOCH - 131)) | (1L << (EVERY - 131)) | (1L << (EXISTS - 131)) | (1L << (EXTERNAL - 131)) | (1L << (EXTRACT - 131)) | (1L << (FAMILY - 131)) | (1L << (FILTER - 131)) | (1L << (FIRST - 131)) | (1L << (FORMAT - 131)) | (1L << (FUSION - 131)) | (1L << (GROUPING - 131)) | (1L << (HASH - 131)) | (1L << (INDEX - 131)) | (1L << (INSERT - 131)) | (1L << (INTERSECTION - 131)) | (1L << (ISODOW - 131)) | (1L << (ISOYEAR - 131)) | (1L << (LANGUAGE - 131)) | (1L << (LARGE - 131)) | (1L << (LAST - 131)) | (1L << (LESS - 131)) | (1L << (LIST - 131)) | (1L << (LOCATION - 131)) | (1L << (MATCH - 131)) | (1L << (MAX - 131)) | (1L << (MAXVALUE - 131)) | (1L << (MICROSECONDS - 131)) | (1L << (MILLENNIUM - 131)) | (1L << (MILLISECONDS - 131)) | (1L << (MIN - 131)) | (1L << (MINUTE - 131)) | (1L << (MONTH - 131)) | (1L << (NATIONAL - 131)) | (1L << (NULLIF - 131)) | (1L << (OBJECT - 131)) | (1L << (OPTION - 131)) | (1L << (OPTIONS - 131)) | (1L << (OVERWRITE - 131)) | (1L << (PARSER - 131)) | (1L << (PARTIAL - 131)) | (1L << (PARTITION - 131)) | (1L << (PARTITIONS - 131)) | (1L << (PRECISION - 131)) | (1L << (PUBLIC - 131)) | (1L << (PURGE - 131)))) != 0) || ((((_la - 195)) & ~0x3f) == 0 && ((1L << (_la - 195)) & ((1L << (QUARTER - 195)) | (1L << (RANGE - 195)) | (1L << (REGEXP - 195)) | (1L << (RLIKE - 195)) | (1L << (ROLLUP - 195)) | (1L << (SEARCH - 195)) | (1L << (SECOND - 195)) | (1L << (SERVER - 195)) | (1L << (SET - 195)) | (1L << (SIMILAR - 195)) | (1L << (SIMPLE - 195)) | (1L << (STORAGE - 195)) | (1L << (STDDEV_POP - 195)) | (1L << (STDDEV_SAMP - 195)) | (1L << (SUBPARTITION - 195)) | (1L << (SUM - 195)) | (1L << (TABLESPACE - 195)) | (1L << (TEMPLATE - 195)) | (1L << (THAN - 195)) | (1L << (TIMEZONE - 195)) | (1L << (TIMEZONE_HOUR - 195)) | (1L << (TIMEZONE_MINUTE - 195)) | (1L << (TRIM - 195)) | (1L << (TO - 195)) | (1L << (UNKNOWN - 195)) | (1L << (UNLOGGED - 195)) | (1L << (VALUES - 195)) | (1L << (VAR_SAMP - 195)) | (1L << (VAR_POP - 195)) | (1L << (VARYING - 195)) | (1L << (WEEK - 195)) | (1L << (WRAPPER - 195)) | (1L << (YEAR - 195)) | (1L << (ZONE - 195)) | (1L << (BOOLEAN - 195)) | (1L << (BOOL - 195)) | (1L << (BIT - 195)) | (1L << (VARBIT - 195)) | (1L << (INT1 - 195)) | (1L << (INT2 - 195)) | (1L << (INT4 - 195)) | (1L << (INT8 - 195)) | (1L << (TINYINT - 195)) | (1L << (SMALLINT - 195)) | (1L << (INT - 195)) | (1L << (INTEGER - 195)) | (1L << (BIGINT - 195)) | (1L << (FLOAT4 - 195)) | (1L << (FLOAT8 - 195)) | (1L << (REAL - 195)) | (1L << (FLOAT - 195)) | (1L << (DOUBLE - 195)) | (1L << (NUMERIC - 195)) | (1L << (DECIMAL - 195)) | (1L << (CHAR - 195)) | (1L << (VARCHAR - 195)) | (1L << (NCHAR - 195)) | (1L << (NVARCHAR - 195)) | (1L << (DATE - 195)) | (1L << (TIME - 195)) | (1L << (TIMETZ - 195)))) != 0) || ((((_la - 259)) & ~0x3f) == 0 && ((1L << (_la - 259)) & ((1L << (TIMESTAMP - 259)) | (1L << (TIMESTAMPTZ - 259)) | (1L << (TEXT - 259)) | (1L << (VARBINARY - 259)) | (1L << (BLOB - 259)) | (1L << (BYTEA - 259)) | (1L << (INET4 - 259)) | (1L << (QUOTE - 259)) | (1L << (Identifier - 259)))) != 0) );
					}
				}

				setState(1631); match(RIGHT_PAREN);
				setState(1644);
				_la = _input.LA(1);
				if (_la==INHERITS) {
					{
					setState(1632); match(INHERITS);
					setState(1633); match(LEFT_PAREN);
					setState(1638); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1634); ((Create_table_statementContext)_localctx).parent_table = identifier();
						setState(1636);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1635); match(COMMA);
							}
						}

						}
						}
						setState(1640); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 123)) & ~0x3f) == 0 && ((1L << (_la - 123)) & ((1L << (ADMIN - 123)) | (1L << (AVG - 123)) | (1L << (BETWEEN - 123)) | (1L << (BY - 123)) | (1L << (CLASS - 123)) | (1L << (CENTURY - 123)) | (1L << (CHARACTER - 123)) | (1L << (CHECK - 123)) | (1L << (COLLECT - 123)) | (1L << (COALESCE - 123)) | (1L << (COLUMN - 123)) | (1L << (COMMENT - 123)) | (1L << (COMMENTS - 123)) | (1L << (COMMIT - 123)) | (1L << (CONFIGURATION - 123)) | (1L << (COUNT - 123)) | (1L << (CUBE - 123)) | (1L << (DATA - 123)) | (1L << (DAY - 123)) | (1L << (DEC - 123)) | (1L << (DECADE - 123)) | (1L << (DICTIONARY - 123)) | (1L << (DOW - 123)) | (1L << (DOY - 123)) | (1L << (DROP - 123)) | (1L << (EPOCH - 123)) | (1L << (EVERY - 123)) | (1L << (EXISTS - 123)) | (1L << (EXTERNAL - 123)) | (1L << (EXTRACT - 123)) | (1L << (FAMILY - 123)) | (1L << (FILTER - 123)) | (1L << (FIRST - 123)) | (1L << (FORMAT - 123)) | (1L << (FUSION - 123)) | (1L << (GROUPING - 123)) | (1L << (HASH - 123)) | (1L << (INDEX - 123)) | (1L << (INSERT - 123)) | (1L << (INTERSECTION - 123)) | (1L << (ISODOW - 123)) | (1L << (ISOYEAR - 123)) | (1L << (LANGUAGE - 123)) | (1L << (LARGE - 123)) | (1L << (LAST - 123)) | (1L << (LESS - 123)) | (1L << (LIST - 123)) | (1L << (LOCATION - 123)) | (1L << (MATCH - 123)) | (1L << (MAX - 123)) | (1L << (MAXVALUE - 123)) | (1L << (MICROSECONDS - 123)) | (1L << (MILLENNIUM - 123)) | (1L << (MILLISECONDS - 123)) | (1L << (MIN - 123)) | (1L << (MINUTE - 123)) | (1L << (MONTH - 123)) | (1L << (NATIONAL - 123)) | (1L << (NULLIF - 123)) | (1L << (OBJECT - 123)) | (1L << (OPTION - 123)) | (1L << (OPTIONS - 123)))) != 0) || ((((_la - 187)) & ~0x3f) == 0 && ((1L << (_la - 187)) & ((1L << (OVERWRITE - 187)) | (1L << (PARSER - 187)) | (1L << (PARTIAL - 187)) | (1L << (PARTITION - 187)) | (1L << (PARTITIONS - 187)) | (1L << (PRECISION - 187)) | (1L << (PUBLIC - 187)) | (1L << (PURGE - 187)) | (1L << (QUARTER - 187)) | (1L << (RANGE - 187)) | (1L << (REGEXP - 187)) | (1L << (RLIKE - 187)) | (1L << (ROLLUP - 187)) | (1L << (SEARCH - 187)) | (1L << (SECOND - 187)) | (1L << (SERVER - 187)) | (1L << (SET - 187)) | (1L << (SIMILAR - 187)) | (1L << (SIMPLE - 187)) | (1L << (STORAGE - 187)) | (1L << (STDDEV_POP - 187)) | (1L << (STDDEV_SAMP - 187)) | (1L << (SUBPARTITION - 187)) | (1L << (SUM - 187)) | (1L << (TABLESPACE - 187)) | (1L << (TEMPLATE - 187)) | (1L << (THAN - 187)) | (1L << (TIMEZONE - 187)) | (1L << (TIMEZONE_HOUR - 187)) | (1L << (TIMEZONE_MINUTE - 187)) | (1L << (TRIM - 187)) | (1L << (TO - 187)) | (1L << (UNKNOWN - 187)) | (1L << (UNLOGGED - 187)) | (1L << (VALUES - 187)) | (1L << (VAR_SAMP - 187)) | (1L << (VAR_POP - 187)) | (1L << (VARYING - 187)) | (1L << (WEEK - 187)) | (1L << (WRAPPER - 187)) | (1L << (YEAR - 187)) | (1L << (ZONE - 187)) | (1L << (BOOLEAN - 187)) | (1L << (BOOL - 187)) | (1L << (BIT - 187)) | (1L << (VARBIT - 187)) | (1L << (INT1 - 187)) | (1L << (INT2 - 187)) | (1L << (INT4 - 187)) | (1L << (INT8 - 187)) | (1L << (TINYINT - 187)) | (1L << (SMALLINT - 187)) | (1L << (INT - 187)) | (1L << (INTEGER - 187)) | (1L << (BIGINT - 187)) | (1L << (FLOAT4 - 187)) | (1L << (FLOAT8 - 187)) | (1L << (REAL - 187)) | (1L << (FLOAT - 187)) | (1L << (DOUBLE - 187)) | (1L << (NUMERIC - 187)))) != 0) || ((((_la - 251)) & ~0x3f) == 0 && ((1L << (_la - 251)) & ((1L << (DECIMAL - 251)) | (1L << (CHAR - 251)) | (1L << (VARCHAR - 251)) | (1L << (NCHAR - 251)) | (1L << (NVARCHAR - 251)) | (1L << (DATE - 251)) | (1L << (TIME - 251)) | (1L << (TIMETZ - 251)) | (1L << (TIMESTAMP - 251)) | (1L << (TIMESTAMPTZ - 251)) | (1L << (TEXT - 251)) | (1L << (VARBINARY - 251)) | (1L << (BLOB - 251)) | (1L << (BYTEA - 251)) | (1L << (INET4 - 251)) | (1L << (QUOTE - 251)) | (1L << (Identifier - 251)))) != 0) );
					setState(1642); match(RIGHT_PAREN);
					}
				}

				setState(1646); storage_parameter_oid();
				setState(1647); on_commit();
				setState(1648); table_space();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1650); match(CREATE);
				setState(1656);
				switch (_input.LA(1)) {
				case GLOBAL:
				case LOCAL:
				case TEMP:
				case TEMPORARY:
					{
					setState(1652);
					_la = _input.LA(1);
					if (_la==GLOBAL || _la==LOCAL) {
						{
						setState(1651);
						_la = _input.LA(1);
						if ( !(_la==GLOBAL || _la==LOCAL) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
					}

					setState(1654);
					_la = _input.LA(1);
					if ( !(_la==TEMP || _la==TEMPORARY) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
					break;
				case UNLOGGED:
					{
					setState(1655); match(UNLOGGED);
					}
					break;
				case TABLE:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1658); match(TABLE);
				setState(1662);
				_la = _input.LA(1);
				if (_la==IF) {
					{
					setState(1659); match(IF);
					setState(1660); match(NOT);
					setState(1661); match(EXISTS);
					}
				}

				setState(1664); ((Create_table_statementContext)_localctx).n = schema_qualified_name();
				setState(1665); match(OF);
				setState(1666); ((Create_table_statementContext)_localctx).type_name = identifier();
				setState(1689);
				switch ( getInterpreter().adaptivePredict(_input,235,_ctx) ) {
				case 1:
					{
					setState(1667); match(LEFT_PAREN);
					setState(1683); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1678);
						switch ( getInterpreter().adaptivePredict(_input,232,_ctx) ) {
						case 1:
							{
							{
							setState(1668); ((Create_table_statementContext)_localctx).column_name = identifier();
							setState(1669); match(WITH);
							setState(1670); match(OPTIONS);
							setState(1674);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,231,_ctx);
							while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
								if ( _alt==1 ) {
									{
									{
									setState(1671); ((Create_table_statementContext)_localctx).col_constraint = column_constraint();
									}
									} 
								}
								setState(1676);
								_errHandler.sync(this);
								_alt = getInterpreter().adaptivePredict(_input,231,_ctx);
							}
							}
							}
							break;
						case 2:
							{
							setState(1677); table_constraint();
							}
							break;
						}
						setState(1681);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1680); match(COMMA);
							}
						}

						}
						}
						setState(1685); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CONSTRAINT) | (1L << EXCLUDE) | (1L << FOREIGN))) != 0) || ((((_la - 82)) & ~0x3f) == 0 && ((1L << (_la - 82)) & ((1L << (PRIMARY - 82)) | (1L << (UNIQUE - 82)) | (1L << (ADMIN - 82)) | (1L << (AVG - 82)) | (1L << (BETWEEN - 82)) | (1L << (BY - 82)) | (1L << (CLASS - 82)) | (1L << (CENTURY - 82)) | (1L << (CHARACTER - 82)) | (1L << (CHECK - 82)) | (1L << (COLLECT - 82)) | (1L << (COALESCE - 82)) | (1L << (COLUMN - 82)) | (1L << (COMMENT - 82)) | (1L << (COMMENTS - 82)) | (1L << (COMMIT - 82)) | (1L << (CONFIGURATION - 82)) | (1L << (COUNT - 82)) | (1L << (CUBE - 82)) | (1L << (DATA - 82)) | (1L << (DAY - 82)) | (1L << (DEC - 82)) | (1L << (DECADE - 82)) | (1L << (DICTIONARY - 82)) | (1L << (DOW - 82)))) != 0) || ((((_la - 146)) & ~0x3f) == 0 && ((1L << (_la - 146)) & ((1L << (DOY - 146)) | (1L << (DROP - 146)) | (1L << (EPOCH - 146)) | (1L << (EVERY - 146)) | (1L << (EXISTS - 146)) | (1L << (EXTERNAL - 146)) | (1L << (EXTRACT - 146)) | (1L << (FAMILY - 146)) | (1L << (FILTER - 146)) | (1L << (FIRST - 146)) | (1L << (FORMAT - 146)) | (1L << (FUSION - 146)) | (1L << (GROUPING - 146)) | (1L << (HASH - 146)) | (1L << (INDEX - 146)) | (1L << (INSERT - 146)) | (1L << (INTERSECTION - 146)) | (1L << (ISODOW - 146)) | (1L << (ISOYEAR - 146)) | (1L << (LANGUAGE - 146)) | (1L << (LARGE - 146)) | (1L << (LAST - 146)) | (1L << (LESS - 146)) | (1L << (LIST - 146)) | (1L << (LOCATION - 146)) | (1L << (MATCH - 146)) | (1L << (MAX - 146)) | (1L << (MAXVALUE - 146)) | (1L << (MICROSECONDS - 146)) | (1L << (MILLENNIUM - 146)) | (1L << (MILLISECONDS - 146)) | (1L << (MIN - 146)) | (1L << (MINUTE - 146)) | (1L << (MONTH - 146)) | (1L << (NATIONAL - 146)) | (1L << (NULLIF - 146)) | (1L << (OBJECT - 146)) | (1L << (OPTION - 146)) | (1L << (OPTIONS - 146)) | (1L << (OVERWRITE - 146)) | (1L << (PARSER - 146)) | (1L << (PARTIAL - 146)) | (1L << (PARTITION - 146)) | (1L << (PARTITIONS - 146)) | (1L << (PRECISION - 146)) | (1L << (PUBLIC - 146)) | (1L << (PURGE - 146)) | (1L << (QUARTER - 146)) | (1L << (RANGE - 146)) | (1L << (REGEXP - 146)) | (1L << (RLIKE - 146)) | (1L << (ROLLUP - 146)) | (1L << (SEARCH - 146)) | (1L << (SECOND - 146)) | (1L << (SERVER - 146)) | (1L << (SET - 146)) | (1L << (SIMILAR - 146)) | (1L << (SIMPLE - 146)) | (1L << (STORAGE - 146)) | (1L << (STDDEV_POP - 146)) | (1L << (STDDEV_SAMP - 146)) | (1L << (SUBPARTITION - 146)))) != 0) || ((((_la - 210)) & ~0x3f) == 0 && ((1L << (_la - 210)) & ((1L << (SUM - 210)) | (1L << (TABLESPACE - 210)) | (1L << (TEMPLATE - 210)) | (1L << (THAN - 210)) | (1L << (TIMEZONE - 210)) | (1L << (TIMEZONE_HOUR - 210)) | (1L << (TIMEZONE_MINUTE - 210)) | (1L << (TRIM - 210)) | (1L << (TO - 210)) | (1L << (UNKNOWN - 210)) | (1L << (UNLOGGED - 210)) | (1L << (VALUES - 210)) | (1L << (VAR_SAMP - 210)) | (1L << (VAR_POP - 210)) | (1L << (VARYING - 210)) | (1L << (WEEK - 210)) | (1L << (WRAPPER - 210)) | (1L << (YEAR - 210)) | (1L << (ZONE - 210)) | (1L << (BOOLEAN - 210)) | (1L << (BOOL - 210)) | (1L << (BIT - 210)) | (1L << (VARBIT - 210)) | (1L << (INT1 - 210)) | (1L << (INT2 - 210)) | (1L << (INT4 - 210)) | (1L << (INT8 - 210)) | (1L << (TINYINT - 210)) | (1L << (SMALLINT - 210)) | (1L << (INT - 210)) | (1L << (INTEGER - 210)) | (1L << (BIGINT - 210)) | (1L << (FLOAT4 - 210)) | (1L << (FLOAT8 - 210)) | (1L << (REAL - 210)) | (1L << (FLOAT - 210)) | (1L << (DOUBLE - 210)) | (1L << (NUMERIC - 210)) | (1L << (DECIMAL - 210)) | (1L << (CHAR - 210)) | (1L << (VARCHAR - 210)) | (1L << (NCHAR - 210)) | (1L << (NVARCHAR - 210)) | (1L << (DATE - 210)) | (1L << (TIME - 210)) | (1L << (TIMETZ - 210)) | (1L << (TIMESTAMP - 210)) | (1L << (TIMESTAMPTZ - 210)) | (1L << (TEXT - 210)) | (1L << (VARBINARY - 210)) | (1L << (BLOB - 210)) | (1L << (BYTEA - 210)) | (1L << (INET4 - 210)))) != 0) || _la==QUOTE || _la==Identifier );
					setState(1687); match(RIGHT_PAREN);
					}
					break;
				}
				setState(1691); storage_parameter_oid();
				setState(1692); on_commit();
				setState(1693); table_space();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 36, RULE_like_option);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1697);
			_la = _input.LA(1);
			if ( !(_la==EXCLUDING || _la==INCLUDING) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(1698);
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
		enterRule(_localctx, 38, RULE_table_constraint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1702);
			_la = _input.LA(1);
			if (_la==CONSTRAINT) {
				{
				setState(1700); match(CONSTRAINT);
				setState(1701); ((Table_constraintContext)_localctx).constraint_name = identifier();
				}
			}

			setState(1802);
			switch (_input.LA(1)) {
			case CHECK:
				{
				setState(1704); check_boolean_expression();
				}
				break;
			case UNIQUE:
				{
				{
				setState(1705); match(UNIQUE);
				setState(1706); match(LEFT_PAREN);
				setState(1711); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1707); ((Table_constraintContext)_localctx).column_name_unique = identifier();
					setState(1709);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1708); match(COMMA);
						}
					}

					}
					}
					setState(1713); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 123)) & ~0x3f) == 0 && ((1L << (_la - 123)) & ((1L << (ADMIN - 123)) | (1L << (AVG - 123)) | (1L << (BETWEEN - 123)) | (1L << (BY - 123)) | (1L << (CLASS - 123)) | (1L << (CENTURY - 123)) | (1L << (CHARACTER - 123)) | (1L << (CHECK - 123)) | (1L << (COLLECT - 123)) | (1L << (COALESCE - 123)) | (1L << (COLUMN - 123)) | (1L << (COMMENT - 123)) | (1L << (COMMENTS - 123)) | (1L << (COMMIT - 123)) | (1L << (CONFIGURATION - 123)) | (1L << (COUNT - 123)) | (1L << (CUBE - 123)) | (1L << (DATA - 123)) | (1L << (DAY - 123)) | (1L << (DEC - 123)) | (1L << (DECADE - 123)) | (1L << (DICTIONARY - 123)) | (1L << (DOW - 123)) | (1L << (DOY - 123)) | (1L << (DROP - 123)) | (1L << (EPOCH - 123)) | (1L << (EVERY - 123)) | (1L << (EXISTS - 123)) | (1L << (EXTERNAL - 123)) | (1L << (EXTRACT - 123)) | (1L << (FAMILY - 123)) | (1L << (FILTER - 123)) | (1L << (FIRST - 123)) | (1L << (FORMAT - 123)) | (1L << (FUSION - 123)) | (1L << (GROUPING - 123)) | (1L << (HASH - 123)) | (1L << (INDEX - 123)) | (1L << (INSERT - 123)) | (1L << (INTERSECTION - 123)) | (1L << (ISODOW - 123)) | (1L << (ISOYEAR - 123)) | (1L << (LANGUAGE - 123)) | (1L << (LARGE - 123)) | (1L << (LAST - 123)) | (1L << (LESS - 123)) | (1L << (LIST - 123)) | (1L << (LOCATION - 123)) | (1L << (MATCH - 123)) | (1L << (MAX - 123)) | (1L << (MAXVALUE - 123)) | (1L << (MICROSECONDS - 123)) | (1L << (MILLENNIUM - 123)) | (1L << (MILLISECONDS - 123)) | (1L << (MIN - 123)) | (1L << (MINUTE - 123)) | (1L << (MONTH - 123)) | (1L << (NATIONAL - 123)) | (1L << (NULLIF - 123)) | (1L << (OBJECT - 123)) | (1L << (OPTION - 123)) | (1L << (OPTIONS - 123)))) != 0) || ((((_la - 187)) & ~0x3f) == 0 && ((1L << (_la - 187)) & ((1L << (OVERWRITE - 187)) | (1L << (PARSER - 187)) | (1L << (PARTIAL - 187)) | (1L << (PARTITION - 187)) | (1L << (PARTITIONS - 187)) | (1L << (PRECISION - 187)) | (1L << (PUBLIC - 187)) | (1L << (PURGE - 187)) | (1L << (QUARTER - 187)) | (1L << (RANGE - 187)) | (1L << (REGEXP - 187)) | (1L << (RLIKE - 187)) | (1L << (ROLLUP - 187)) | (1L << (SEARCH - 187)) | (1L << (SECOND - 187)) | (1L << (SERVER - 187)) | (1L << (SET - 187)) | (1L << (SIMILAR - 187)) | (1L << (SIMPLE - 187)) | (1L << (STORAGE - 187)) | (1L << (STDDEV_POP - 187)) | (1L << (STDDEV_SAMP - 187)) | (1L << (SUBPARTITION - 187)) | (1L << (SUM - 187)) | (1L << (TABLESPACE - 187)) | (1L << (TEMPLATE - 187)) | (1L << (THAN - 187)) | (1L << (TIMEZONE - 187)) | (1L << (TIMEZONE_HOUR - 187)) | (1L << (TIMEZONE_MINUTE - 187)) | (1L << (TRIM - 187)) | (1L << (TO - 187)) | (1L << (UNKNOWN - 187)) | (1L << (UNLOGGED - 187)) | (1L << (VALUES - 187)) | (1L << (VAR_SAMP - 187)) | (1L << (VAR_POP - 187)) | (1L << (VARYING - 187)) | (1L << (WEEK - 187)) | (1L << (WRAPPER - 187)) | (1L << (YEAR - 187)) | (1L << (ZONE - 187)) | (1L << (BOOLEAN - 187)) | (1L << (BOOL - 187)) | (1L << (BIT - 187)) | (1L << (VARBIT - 187)) | (1L << (INT1 - 187)) | (1L << (INT2 - 187)) | (1L << (INT4 - 187)) | (1L << (INT8 - 187)) | (1L << (TINYINT - 187)) | (1L << (SMALLINT - 187)) | (1L << (INT - 187)) | (1L << (INTEGER - 187)) | (1L << (BIGINT - 187)) | (1L << (FLOAT4 - 187)) | (1L << (FLOAT8 - 187)) | (1L << (REAL - 187)) | (1L << (FLOAT - 187)) | (1L << (DOUBLE - 187)) | (1L << (NUMERIC - 187)))) != 0) || ((((_la - 251)) & ~0x3f) == 0 && ((1L << (_la - 251)) & ((1L << (DECIMAL - 251)) | (1L << (CHAR - 251)) | (1L << (VARCHAR - 251)) | (1L << (NCHAR - 251)) | (1L << (NVARCHAR - 251)) | (1L << (DATE - 251)) | (1L << (TIME - 251)) | (1L << (TIMETZ - 251)) | (1L << (TIMESTAMP - 251)) | (1L << (TIMESTAMPTZ - 251)) | (1L << (TEXT - 251)) | (1L << (VARBINARY - 251)) | (1L << (BLOB - 251)) | (1L << (BYTEA - 251)) | (1L << (INET4 - 251)) | (1L << (QUOTE - 251)) | (1L << (Identifier - 251)))) != 0) );
				setState(1715); match(RIGHT_PAREN);
				setState(1716); ((Table_constraintContext)_localctx).index_parameters_unique = index_parameters();
				}
				}
				break;
			case PRIMARY:
				{
				{
				setState(1718); match(PRIMARY);
				setState(1719); match(KEY);
				setState(1720); match(LEFT_PAREN);
				setState(1725); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1721); ((Table_constraintContext)_localctx).column_name_pr_key = identifier();
					setState(1723);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1722); match(COMMA);
						}
					}

					}
					}
					setState(1727); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 123)) & ~0x3f) == 0 && ((1L << (_la - 123)) & ((1L << (ADMIN - 123)) | (1L << (AVG - 123)) | (1L << (BETWEEN - 123)) | (1L << (BY - 123)) | (1L << (CLASS - 123)) | (1L << (CENTURY - 123)) | (1L << (CHARACTER - 123)) | (1L << (CHECK - 123)) | (1L << (COLLECT - 123)) | (1L << (COALESCE - 123)) | (1L << (COLUMN - 123)) | (1L << (COMMENT - 123)) | (1L << (COMMENTS - 123)) | (1L << (COMMIT - 123)) | (1L << (CONFIGURATION - 123)) | (1L << (COUNT - 123)) | (1L << (CUBE - 123)) | (1L << (DATA - 123)) | (1L << (DAY - 123)) | (1L << (DEC - 123)) | (1L << (DECADE - 123)) | (1L << (DICTIONARY - 123)) | (1L << (DOW - 123)) | (1L << (DOY - 123)) | (1L << (DROP - 123)) | (1L << (EPOCH - 123)) | (1L << (EVERY - 123)) | (1L << (EXISTS - 123)) | (1L << (EXTERNAL - 123)) | (1L << (EXTRACT - 123)) | (1L << (FAMILY - 123)) | (1L << (FILTER - 123)) | (1L << (FIRST - 123)) | (1L << (FORMAT - 123)) | (1L << (FUSION - 123)) | (1L << (GROUPING - 123)) | (1L << (HASH - 123)) | (1L << (INDEX - 123)) | (1L << (INSERT - 123)) | (1L << (INTERSECTION - 123)) | (1L << (ISODOW - 123)) | (1L << (ISOYEAR - 123)) | (1L << (LANGUAGE - 123)) | (1L << (LARGE - 123)) | (1L << (LAST - 123)) | (1L << (LESS - 123)) | (1L << (LIST - 123)) | (1L << (LOCATION - 123)) | (1L << (MATCH - 123)) | (1L << (MAX - 123)) | (1L << (MAXVALUE - 123)) | (1L << (MICROSECONDS - 123)) | (1L << (MILLENNIUM - 123)) | (1L << (MILLISECONDS - 123)) | (1L << (MIN - 123)) | (1L << (MINUTE - 123)) | (1L << (MONTH - 123)) | (1L << (NATIONAL - 123)) | (1L << (NULLIF - 123)) | (1L << (OBJECT - 123)) | (1L << (OPTION - 123)) | (1L << (OPTIONS - 123)))) != 0) || ((((_la - 187)) & ~0x3f) == 0 && ((1L << (_la - 187)) & ((1L << (OVERWRITE - 187)) | (1L << (PARSER - 187)) | (1L << (PARTIAL - 187)) | (1L << (PARTITION - 187)) | (1L << (PARTITIONS - 187)) | (1L << (PRECISION - 187)) | (1L << (PUBLIC - 187)) | (1L << (PURGE - 187)) | (1L << (QUARTER - 187)) | (1L << (RANGE - 187)) | (1L << (REGEXP - 187)) | (1L << (RLIKE - 187)) | (1L << (ROLLUP - 187)) | (1L << (SEARCH - 187)) | (1L << (SECOND - 187)) | (1L << (SERVER - 187)) | (1L << (SET - 187)) | (1L << (SIMILAR - 187)) | (1L << (SIMPLE - 187)) | (1L << (STORAGE - 187)) | (1L << (STDDEV_POP - 187)) | (1L << (STDDEV_SAMP - 187)) | (1L << (SUBPARTITION - 187)) | (1L << (SUM - 187)) | (1L << (TABLESPACE - 187)) | (1L << (TEMPLATE - 187)) | (1L << (THAN - 187)) | (1L << (TIMEZONE - 187)) | (1L << (TIMEZONE_HOUR - 187)) | (1L << (TIMEZONE_MINUTE - 187)) | (1L << (TRIM - 187)) | (1L << (TO - 187)) | (1L << (UNKNOWN - 187)) | (1L << (UNLOGGED - 187)) | (1L << (VALUES - 187)) | (1L << (VAR_SAMP - 187)) | (1L << (VAR_POP - 187)) | (1L << (VARYING - 187)) | (1L << (WEEK - 187)) | (1L << (WRAPPER - 187)) | (1L << (YEAR - 187)) | (1L << (ZONE - 187)) | (1L << (BOOLEAN - 187)) | (1L << (BOOL - 187)) | (1L << (BIT - 187)) | (1L << (VARBIT - 187)) | (1L << (INT1 - 187)) | (1L << (INT2 - 187)) | (1L << (INT4 - 187)) | (1L << (INT8 - 187)) | (1L << (TINYINT - 187)) | (1L << (SMALLINT - 187)) | (1L << (INT - 187)) | (1L << (INTEGER - 187)) | (1L << (BIGINT - 187)) | (1L << (FLOAT4 - 187)) | (1L << (FLOAT8 - 187)) | (1L << (REAL - 187)) | (1L << (FLOAT - 187)) | (1L << (DOUBLE - 187)) | (1L << (NUMERIC - 187)))) != 0) || ((((_la - 251)) & ~0x3f) == 0 && ((1L << (_la - 251)) & ((1L << (DECIMAL - 251)) | (1L << (CHAR - 251)) | (1L << (VARCHAR - 251)) | (1L << (NCHAR - 251)) | (1L << (NVARCHAR - 251)) | (1L << (DATE - 251)) | (1L << (TIME - 251)) | (1L << (TIMETZ - 251)) | (1L << (TIMESTAMP - 251)) | (1L << (TIMESTAMPTZ - 251)) | (1L << (TEXT - 251)) | (1L << (VARBINARY - 251)) | (1L << (BLOB - 251)) | (1L << (BYTEA - 251)) | (1L << (INET4 - 251)) | (1L << (QUOTE - 251)) | (1L << (Identifier - 251)))) != 0) );
				setState(1729); match(RIGHT_PAREN);
				setState(1730); ((Table_constraintContext)_localctx).index_parameters_pr_key = index_parameters();
				}
				}
				break;
			case EXCLUDE:
				{
				{
				setState(1732); match(EXCLUDE);
				setState(1735);
				_la = _input.LA(1);
				if (_la==USING) {
					{
					setState(1733); match(USING);
					setState(1734); ((Table_constraintContext)_localctx).index_method = identifier();
					}
				}

				setState(1737); match(LEFT_PAREN);
				setState(1738); ((Table_constraintContext)_localctx).exclude_element = identifier();
				setState(1739); match(WITH);
				setState(1744); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1740); ((Table_constraintContext)_localctx).operator = identifier();
					setState(1742);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1741); match(COMMA);
						}
					}

					}
					}
					setState(1746); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 123)) & ~0x3f) == 0 && ((1L << (_la - 123)) & ((1L << (ADMIN - 123)) | (1L << (AVG - 123)) | (1L << (BETWEEN - 123)) | (1L << (BY - 123)) | (1L << (CLASS - 123)) | (1L << (CENTURY - 123)) | (1L << (CHARACTER - 123)) | (1L << (CHECK - 123)) | (1L << (COLLECT - 123)) | (1L << (COALESCE - 123)) | (1L << (COLUMN - 123)) | (1L << (COMMENT - 123)) | (1L << (COMMENTS - 123)) | (1L << (COMMIT - 123)) | (1L << (CONFIGURATION - 123)) | (1L << (COUNT - 123)) | (1L << (CUBE - 123)) | (1L << (DATA - 123)) | (1L << (DAY - 123)) | (1L << (DEC - 123)) | (1L << (DECADE - 123)) | (1L << (DICTIONARY - 123)) | (1L << (DOW - 123)) | (1L << (DOY - 123)) | (1L << (DROP - 123)) | (1L << (EPOCH - 123)) | (1L << (EVERY - 123)) | (1L << (EXISTS - 123)) | (1L << (EXTERNAL - 123)) | (1L << (EXTRACT - 123)) | (1L << (FAMILY - 123)) | (1L << (FILTER - 123)) | (1L << (FIRST - 123)) | (1L << (FORMAT - 123)) | (1L << (FUSION - 123)) | (1L << (GROUPING - 123)) | (1L << (HASH - 123)) | (1L << (INDEX - 123)) | (1L << (INSERT - 123)) | (1L << (INTERSECTION - 123)) | (1L << (ISODOW - 123)) | (1L << (ISOYEAR - 123)) | (1L << (LANGUAGE - 123)) | (1L << (LARGE - 123)) | (1L << (LAST - 123)) | (1L << (LESS - 123)) | (1L << (LIST - 123)) | (1L << (LOCATION - 123)) | (1L << (MATCH - 123)) | (1L << (MAX - 123)) | (1L << (MAXVALUE - 123)) | (1L << (MICROSECONDS - 123)) | (1L << (MILLENNIUM - 123)) | (1L << (MILLISECONDS - 123)) | (1L << (MIN - 123)) | (1L << (MINUTE - 123)) | (1L << (MONTH - 123)) | (1L << (NATIONAL - 123)) | (1L << (NULLIF - 123)) | (1L << (OBJECT - 123)) | (1L << (OPTION - 123)) | (1L << (OPTIONS - 123)))) != 0) || ((((_la - 187)) & ~0x3f) == 0 && ((1L << (_la - 187)) & ((1L << (OVERWRITE - 187)) | (1L << (PARSER - 187)) | (1L << (PARTIAL - 187)) | (1L << (PARTITION - 187)) | (1L << (PARTITIONS - 187)) | (1L << (PRECISION - 187)) | (1L << (PUBLIC - 187)) | (1L << (PURGE - 187)) | (1L << (QUARTER - 187)) | (1L << (RANGE - 187)) | (1L << (REGEXP - 187)) | (1L << (RLIKE - 187)) | (1L << (ROLLUP - 187)) | (1L << (SEARCH - 187)) | (1L << (SECOND - 187)) | (1L << (SERVER - 187)) | (1L << (SET - 187)) | (1L << (SIMILAR - 187)) | (1L << (SIMPLE - 187)) | (1L << (STORAGE - 187)) | (1L << (STDDEV_POP - 187)) | (1L << (STDDEV_SAMP - 187)) | (1L << (SUBPARTITION - 187)) | (1L << (SUM - 187)) | (1L << (TABLESPACE - 187)) | (1L << (TEMPLATE - 187)) | (1L << (THAN - 187)) | (1L << (TIMEZONE - 187)) | (1L << (TIMEZONE_HOUR - 187)) | (1L << (TIMEZONE_MINUTE - 187)) | (1L << (TRIM - 187)) | (1L << (TO - 187)) | (1L << (UNKNOWN - 187)) | (1L << (UNLOGGED - 187)) | (1L << (VALUES - 187)) | (1L << (VAR_SAMP - 187)) | (1L << (VAR_POP - 187)) | (1L << (VARYING - 187)) | (1L << (WEEK - 187)) | (1L << (WRAPPER - 187)) | (1L << (YEAR - 187)) | (1L << (ZONE - 187)) | (1L << (BOOLEAN - 187)) | (1L << (BOOL - 187)) | (1L << (BIT - 187)) | (1L << (VARBIT - 187)) | (1L << (INT1 - 187)) | (1L << (INT2 - 187)) | (1L << (INT4 - 187)) | (1L << (INT8 - 187)) | (1L << (TINYINT - 187)) | (1L << (SMALLINT - 187)) | (1L << (INT - 187)) | (1L << (INTEGER - 187)) | (1L << (BIGINT - 187)) | (1L << (FLOAT4 - 187)) | (1L << (FLOAT8 - 187)) | (1L << (REAL - 187)) | (1L << (FLOAT - 187)) | (1L << (DOUBLE - 187)) | (1L << (NUMERIC - 187)))) != 0) || ((((_la - 251)) & ~0x3f) == 0 && ((1L << (_la - 251)) & ((1L << (DECIMAL - 251)) | (1L << (CHAR - 251)) | (1L << (VARCHAR - 251)) | (1L << (NCHAR - 251)) | (1L << (NVARCHAR - 251)) | (1L << (DATE - 251)) | (1L << (TIME - 251)) | (1L << (TIMETZ - 251)) | (1L << (TIMESTAMP - 251)) | (1L << (TIMESTAMPTZ - 251)) | (1L << (TEXT - 251)) | (1L << (VARBINARY - 251)) | (1L << (BLOB - 251)) | (1L << (BYTEA - 251)) | (1L << (INET4 - 251)) | (1L << (QUOTE - 251)) | (1L << (Identifier - 251)))) != 0) );
				setState(1748); match(RIGHT_PAREN);
				setState(1749); index_parameters();
				setState(1755);
				_la = _input.LA(1);
				if (_la==WHERE) {
					{
					setState(1750); match(WHERE);
					setState(1751); match(LEFT_PAREN);
					setState(1752); ((Table_constraintContext)_localctx).predicat = identifier();
					setState(1753); match(RIGHT_PAREN);
					}
				}

				}
				}
				break;
			case FOREIGN:
				{
				{
				setState(1757); match(FOREIGN);
				setState(1758); match(KEY);
				setState(1759); match(LEFT_PAREN);
				setState(1764); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1760); ((Table_constraintContext)_localctx).column_name_for_key = identifier();
					setState(1762);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1761); match(COMMA);
						}
					}

					}
					}
					setState(1766); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 123)) & ~0x3f) == 0 && ((1L << (_la - 123)) & ((1L << (ADMIN - 123)) | (1L << (AVG - 123)) | (1L << (BETWEEN - 123)) | (1L << (BY - 123)) | (1L << (CLASS - 123)) | (1L << (CENTURY - 123)) | (1L << (CHARACTER - 123)) | (1L << (CHECK - 123)) | (1L << (COLLECT - 123)) | (1L << (COALESCE - 123)) | (1L << (COLUMN - 123)) | (1L << (COMMENT - 123)) | (1L << (COMMENTS - 123)) | (1L << (COMMIT - 123)) | (1L << (CONFIGURATION - 123)) | (1L << (COUNT - 123)) | (1L << (CUBE - 123)) | (1L << (DATA - 123)) | (1L << (DAY - 123)) | (1L << (DEC - 123)) | (1L << (DECADE - 123)) | (1L << (DICTIONARY - 123)) | (1L << (DOW - 123)) | (1L << (DOY - 123)) | (1L << (DROP - 123)) | (1L << (EPOCH - 123)) | (1L << (EVERY - 123)) | (1L << (EXISTS - 123)) | (1L << (EXTERNAL - 123)) | (1L << (EXTRACT - 123)) | (1L << (FAMILY - 123)) | (1L << (FILTER - 123)) | (1L << (FIRST - 123)) | (1L << (FORMAT - 123)) | (1L << (FUSION - 123)) | (1L << (GROUPING - 123)) | (1L << (HASH - 123)) | (1L << (INDEX - 123)) | (1L << (INSERT - 123)) | (1L << (INTERSECTION - 123)) | (1L << (ISODOW - 123)) | (1L << (ISOYEAR - 123)) | (1L << (LANGUAGE - 123)) | (1L << (LARGE - 123)) | (1L << (LAST - 123)) | (1L << (LESS - 123)) | (1L << (LIST - 123)) | (1L << (LOCATION - 123)) | (1L << (MATCH - 123)) | (1L << (MAX - 123)) | (1L << (MAXVALUE - 123)) | (1L << (MICROSECONDS - 123)) | (1L << (MILLENNIUM - 123)) | (1L << (MILLISECONDS - 123)) | (1L << (MIN - 123)) | (1L << (MINUTE - 123)) | (1L << (MONTH - 123)) | (1L << (NATIONAL - 123)) | (1L << (NULLIF - 123)) | (1L << (OBJECT - 123)) | (1L << (OPTION - 123)) | (1L << (OPTIONS - 123)))) != 0) || ((((_la - 187)) & ~0x3f) == 0 && ((1L << (_la - 187)) & ((1L << (OVERWRITE - 187)) | (1L << (PARSER - 187)) | (1L << (PARTIAL - 187)) | (1L << (PARTITION - 187)) | (1L << (PARTITIONS - 187)) | (1L << (PRECISION - 187)) | (1L << (PUBLIC - 187)) | (1L << (PURGE - 187)) | (1L << (QUARTER - 187)) | (1L << (RANGE - 187)) | (1L << (REGEXP - 187)) | (1L << (RLIKE - 187)) | (1L << (ROLLUP - 187)) | (1L << (SEARCH - 187)) | (1L << (SECOND - 187)) | (1L << (SERVER - 187)) | (1L << (SET - 187)) | (1L << (SIMILAR - 187)) | (1L << (SIMPLE - 187)) | (1L << (STORAGE - 187)) | (1L << (STDDEV_POP - 187)) | (1L << (STDDEV_SAMP - 187)) | (1L << (SUBPARTITION - 187)) | (1L << (SUM - 187)) | (1L << (TABLESPACE - 187)) | (1L << (TEMPLATE - 187)) | (1L << (THAN - 187)) | (1L << (TIMEZONE - 187)) | (1L << (TIMEZONE_HOUR - 187)) | (1L << (TIMEZONE_MINUTE - 187)) | (1L << (TRIM - 187)) | (1L << (TO - 187)) | (1L << (UNKNOWN - 187)) | (1L << (UNLOGGED - 187)) | (1L << (VALUES - 187)) | (1L << (VAR_SAMP - 187)) | (1L << (VAR_POP - 187)) | (1L << (VARYING - 187)) | (1L << (WEEK - 187)) | (1L << (WRAPPER - 187)) | (1L << (YEAR - 187)) | (1L << (ZONE - 187)) | (1L << (BOOLEAN - 187)) | (1L << (BOOL - 187)) | (1L << (BIT - 187)) | (1L << (VARBIT - 187)) | (1L << (INT1 - 187)) | (1L << (INT2 - 187)) | (1L << (INT4 - 187)) | (1L << (INT8 - 187)) | (1L << (TINYINT - 187)) | (1L << (SMALLINT - 187)) | (1L << (INT - 187)) | (1L << (INTEGER - 187)) | (1L << (BIGINT - 187)) | (1L << (FLOAT4 - 187)) | (1L << (FLOAT8 - 187)) | (1L << (REAL - 187)) | (1L << (FLOAT - 187)) | (1L << (DOUBLE - 187)) | (1L << (NUMERIC - 187)))) != 0) || ((((_la - 251)) & ~0x3f) == 0 && ((1L << (_la - 251)) & ((1L << (DECIMAL - 251)) | (1L << (CHAR - 251)) | (1L << (VARCHAR - 251)) | (1L << (NCHAR - 251)) | (1L << (NVARCHAR - 251)) | (1L << (DATE - 251)) | (1L << (TIME - 251)) | (1L << (TIMETZ - 251)) | (1L << (TIMESTAMP - 251)) | (1L << (TIMESTAMPTZ - 251)) | (1L << (TEXT - 251)) | (1L << (VARBINARY - 251)) | (1L << (BLOB - 251)) | (1L << (BYTEA - 251)) | (1L << (INET4 - 251)) | (1L << (QUOTE - 251)) | (1L << (Identifier - 251)))) != 0) );
				setState(1768); match(RIGHT_PAREN);
				setState(1769); match(REFERENCES);
				setState(1770); ((Table_constraintContext)_localctx).reftable = identifier();
				setState(1782);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(1771); match(LEFT_PAREN);
					setState(1776); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1772); ((Table_constraintContext)_localctx).refcolumn = identifier();
						setState(1774);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1773); match(COMMA);
							}
						}

						}
						}
						setState(1778); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 123)) & ~0x3f) == 0 && ((1L << (_la - 123)) & ((1L << (ADMIN - 123)) | (1L << (AVG - 123)) | (1L << (BETWEEN - 123)) | (1L << (BY - 123)) | (1L << (CLASS - 123)) | (1L << (CENTURY - 123)) | (1L << (CHARACTER - 123)) | (1L << (CHECK - 123)) | (1L << (COLLECT - 123)) | (1L << (COALESCE - 123)) | (1L << (COLUMN - 123)) | (1L << (COMMENT - 123)) | (1L << (COMMENTS - 123)) | (1L << (COMMIT - 123)) | (1L << (CONFIGURATION - 123)) | (1L << (COUNT - 123)) | (1L << (CUBE - 123)) | (1L << (DATA - 123)) | (1L << (DAY - 123)) | (1L << (DEC - 123)) | (1L << (DECADE - 123)) | (1L << (DICTIONARY - 123)) | (1L << (DOW - 123)) | (1L << (DOY - 123)) | (1L << (DROP - 123)) | (1L << (EPOCH - 123)) | (1L << (EVERY - 123)) | (1L << (EXISTS - 123)) | (1L << (EXTERNAL - 123)) | (1L << (EXTRACT - 123)) | (1L << (FAMILY - 123)) | (1L << (FILTER - 123)) | (1L << (FIRST - 123)) | (1L << (FORMAT - 123)) | (1L << (FUSION - 123)) | (1L << (GROUPING - 123)) | (1L << (HASH - 123)) | (1L << (INDEX - 123)) | (1L << (INSERT - 123)) | (1L << (INTERSECTION - 123)) | (1L << (ISODOW - 123)) | (1L << (ISOYEAR - 123)) | (1L << (LANGUAGE - 123)) | (1L << (LARGE - 123)) | (1L << (LAST - 123)) | (1L << (LESS - 123)) | (1L << (LIST - 123)) | (1L << (LOCATION - 123)) | (1L << (MATCH - 123)) | (1L << (MAX - 123)) | (1L << (MAXVALUE - 123)) | (1L << (MICROSECONDS - 123)) | (1L << (MILLENNIUM - 123)) | (1L << (MILLISECONDS - 123)) | (1L << (MIN - 123)) | (1L << (MINUTE - 123)) | (1L << (MONTH - 123)) | (1L << (NATIONAL - 123)) | (1L << (NULLIF - 123)) | (1L << (OBJECT - 123)) | (1L << (OPTION - 123)) | (1L << (OPTIONS - 123)))) != 0) || ((((_la - 187)) & ~0x3f) == 0 && ((1L << (_la - 187)) & ((1L << (OVERWRITE - 187)) | (1L << (PARSER - 187)) | (1L << (PARTIAL - 187)) | (1L << (PARTITION - 187)) | (1L << (PARTITIONS - 187)) | (1L << (PRECISION - 187)) | (1L << (PUBLIC - 187)) | (1L << (PURGE - 187)) | (1L << (QUARTER - 187)) | (1L << (RANGE - 187)) | (1L << (REGEXP - 187)) | (1L << (RLIKE - 187)) | (1L << (ROLLUP - 187)) | (1L << (SEARCH - 187)) | (1L << (SECOND - 187)) | (1L << (SERVER - 187)) | (1L << (SET - 187)) | (1L << (SIMILAR - 187)) | (1L << (SIMPLE - 187)) | (1L << (STORAGE - 187)) | (1L << (STDDEV_POP - 187)) | (1L << (STDDEV_SAMP - 187)) | (1L << (SUBPARTITION - 187)) | (1L << (SUM - 187)) | (1L << (TABLESPACE - 187)) | (1L << (TEMPLATE - 187)) | (1L << (THAN - 187)) | (1L << (TIMEZONE - 187)) | (1L << (TIMEZONE_HOUR - 187)) | (1L << (TIMEZONE_MINUTE - 187)) | (1L << (TRIM - 187)) | (1L << (TO - 187)) | (1L << (UNKNOWN - 187)) | (1L << (UNLOGGED - 187)) | (1L << (VALUES - 187)) | (1L << (VAR_SAMP - 187)) | (1L << (VAR_POP - 187)) | (1L << (VARYING - 187)) | (1L << (WEEK - 187)) | (1L << (WRAPPER - 187)) | (1L << (YEAR - 187)) | (1L << (ZONE - 187)) | (1L << (BOOLEAN - 187)) | (1L << (BOOL - 187)) | (1L << (BIT - 187)) | (1L << (VARBIT - 187)) | (1L << (INT1 - 187)) | (1L << (INT2 - 187)) | (1L << (INT4 - 187)) | (1L << (INT8 - 187)) | (1L << (TINYINT - 187)) | (1L << (SMALLINT - 187)) | (1L << (INT - 187)) | (1L << (INTEGER - 187)) | (1L << (BIGINT - 187)) | (1L << (FLOAT4 - 187)) | (1L << (FLOAT8 - 187)) | (1L << (REAL - 187)) | (1L << (FLOAT - 187)) | (1L << (DOUBLE - 187)) | (1L << (NUMERIC - 187)))) != 0) || ((((_la - 251)) & ~0x3f) == 0 && ((1L << (_la - 251)) & ((1L << (DECIMAL - 251)) | (1L << (CHAR - 251)) | (1L << (VARCHAR - 251)) | (1L << (NCHAR - 251)) | (1L << (NVARCHAR - 251)) | (1L << (DATE - 251)) | (1L << (TIME - 251)) | (1L << (TIMETZ - 251)) | (1L << (TIMESTAMP - 251)) | (1L << (TIMESTAMPTZ - 251)) | (1L << (TEXT - 251)) | (1L << (VARBINARY - 251)) | (1L << (BLOB - 251)) | (1L << (BYTEA - 251)) | (1L << (INET4 - 251)) | (1L << (QUOTE - 251)) | (1L << (Identifier - 251)))) != 0) );
					setState(1780); match(RIGHT_PAREN);
					}
				}

				setState(1790);
				switch ( getInterpreter().adaptivePredict(_input,251,_ctx) ) {
				case 1:
					{
					{
					setState(1784); match(MATCH);
					setState(1785); match(FULL);
					}
					}
					break;
				case 2:
					{
					{
					setState(1786); match(MATCH);
					setState(1787); match(PARTIAL);
					}
					}
					break;
				case 3:
					{
					{
					setState(1788); match(MATCH);
					setState(1789); match(SIMPLE);
					}
					}
					break;
				}
				setState(1795);
				switch ( getInterpreter().adaptivePredict(_input,252,_ctx) ) {
				case 1:
					{
					setState(1792); match(ON);
					setState(1793); match(DELETE);
					setState(1794); ((Table_constraintContext)_localctx).action_on_delete = action();
					}
					break;
				}
				setState(1800);
				_la = _input.LA(1);
				if (_la==ON) {
					{
					setState(1797); match(ON);
					setState(1798); match(UPDATE);
					setState(1799); ((Table_constraintContext)_localctx).action_on_update = action();
					}
				}

				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(1807);
			switch (_input.LA(1)) {
			case DEFERRABLE:
				{
				setState(1804); match(DEFERRABLE);
				}
				break;
			case NOT:
				{
				{
				setState(1805); match(NOT);
				setState(1806); match(DEFERRABLE);
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
			case COUNT:
			case CUBE:
			case DATA:
			case DAY:
			case DEC:
			case DECADE:
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
			case INSERT:
			case INTERSECTION:
			case ISODOW:
			case ISOYEAR:
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
			case MINUTE:
			case MONTH:
			case NATIONAL:
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
			case SERVER:
			case SET:
			case SIMILAR:
			case SIMPLE:
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
			case WEEK:
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
			setState(1813);
			switch ( getInterpreter().adaptivePredict(_input,256,_ctx) ) {
			case 1:
				{
				{
				setState(1809); match(INITIALLY);
				setState(1810); match(DEFERRED);
				}
				}
				break;
			case 2:
				{
				{
				setState(1811); match(INITIALLY);
				setState(1812); match(IMMEDIATE);
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
		enterRule(_localctx, 40, RULE_column_constraint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1817);
			_la = _input.LA(1);
			if (_la==CONSTRAINT) {
				{
				setState(1815); match(CONSTRAINT);
				setState(1816); ((Column_constraintContext)_localctx).constraint_name = identifier();
				}
			}

			setState(1851);
			switch (_input.LA(1)) {
			case NOT:
				{
				{
				setState(1819); match(NOT);
				setState(1820); match(NULL);
				}
				}
				break;
			case NULL:
				{
				setState(1821); match(NULL);
				}
				break;
			case CHECK:
				{
				setState(1822); check_boolean_expression();
				}
				break;
			case DEFAULT:
				{
				{
				setState(1823); match(DEFAULT);
				setState(1824); ((Column_constraintContext)_localctx).default_expr = routine_invocation();
				}
				}
				break;
			case UNIQUE:
				{
				{
				setState(1825); match(UNIQUE);
				setState(1826); ((Column_constraintContext)_localctx).index_params_unique = index_parameters();
				}
				}
				break;
			case PRIMARY:
				{
				{
				setState(1827); match(PRIMARY);
				setState(1828); match(KEY);
				setState(1829); ((Column_constraintContext)_localctx).index_params_pr_key = index_parameters();
				}
				}
				break;
			case REFERENCES:
				{
				{
				setState(1830); match(REFERENCES);
				setState(1831); ((Column_constraintContext)_localctx).reftable = schema_qualified_name();
				{
				{
				setState(1832); ((Column_constraintContext)_localctx).refcolumn = identifier();
				}
				}
				setState(1839);
				switch ( getInterpreter().adaptivePredict(_input,258,_ctx) ) {
				case 1:
					{
					setState(1833); match(MATCH);
					setState(1834); match(FULL);
					}
					break;
				case 2:
					{
					setState(1835); match(MATCH);
					setState(1836); match(PARTIAL);
					}
					break;
				case 3:
					{
					setState(1837); match(MATCH);
					setState(1838); match(SIMPLE);
					}
					break;
				}
				setState(1844);
				switch ( getInterpreter().adaptivePredict(_input,259,_ctx) ) {
				case 1:
					{
					setState(1841); match(ON);
					setState(1842); match(DELETE);
					setState(1843); ((Column_constraintContext)_localctx).action_on_delete = action();
					}
					break;
				}
				setState(1849);
				_la = _input.LA(1);
				if (_la==ON) {
					{
					setState(1846); match(ON);
					setState(1847); match(UPDATE);
					setState(1848); ((Column_constraintContext)_localctx).action_on_update = action();
					}
				}

				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(1856);
			switch ( getInterpreter().adaptivePredict(_input,262,_ctx) ) {
			case 1:
				{
				setState(1853); match(DEFERRABLE);
				}
				break;
			case 2:
				{
				{
				setState(1854); match(NOT);
				setState(1855); match(DEFERRABLE);
				}
				}
				break;
			}
			setState(1862);
			switch ( getInterpreter().adaptivePredict(_input,263,_ctx) ) {
			case 1:
				{
				{
				setState(1858); match(INITIALLY);
				setState(1859); match(DEFERRED);
				}
				}
				break;
			case 2:
				{
				{
				setState(1860); match(INITIALLY);
				setState(1861); match(IMMEDIATE);
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
		enterRule(_localctx, 42, RULE_check_boolean_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1864); match(CHECK);
			setState(1865); match(LEFT_PAREN);
			setState(1866); ((Check_boolean_expressionContext)_localctx).expression = boolean_value_expression();
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
		enterRule(_localctx, 44, RULE_storage_parameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1869); match(WITH);
			setState(1870); match(LEFT_PAREN);
			setState(1879); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1871); ((Storage_parameterContext)_localctx).storage_param = identifier();
				setState(1874);
				_la = _input.LA(1);
				if (_la==EQUAL) {
					{
					setState(1872); match(EQUAL);
					setState(1873); ((Storage_parameterContext)_localctx).value = identifier();
					}
				}

				setState(1877);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(1876); match(COMMA);
					}
				}

				}
				}
				setState(1881); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 123)) & ~0x3f) == 0 && ((1L << (_la - 123)) & ((1L << (ADMIN - 123)) | (1L << (AVG - 123)) | (1L << (BETWEEN - 123)) | (1L << (BY - 123)) | (1L << (CLASS - 123)) | (1L << (CENTURY - 123)) | (1L << (CHARACTER - 123)) | (1L << (CHECK - 123)) | (1L << (COLLECT - 123)) | (1L << (COALESCE - 123)) | (1L << (COLUMN - 123)) | (1L << (COMMENT - 123)) | (1L << (COMMENTS - 123)) | (1L << (COMMIT - 123)) | (1L << (CONFIGURATION - 123)) | (1L << (COUNT - 123)) | (1L << (CUBE - 123)) | (1L << (DATA - 123)) | (1L << (DAY - 123)) | (1L << (DEC - 123)) | (1L << (DECADE - 123)) | (1L << (DICTIONARY - 123)) | (1L << (DOW - 123)) | (1L << (DOY - 123)) | (1L << (DROP - 123)) | (1L << (EPOCH - 123)) | (1L << (EVERY - 123)) | (1L << (EXISTS - 123)) | (1L << (EXTERNAL - 123)) | (1L << (EXTRACT - 123)) | (1L << (FAMILY - 123)) | (1L << (FILTER - 123)) | (1L << (FIRST - 123)) | (1L << (FORMAT - 123)) | (1L << (FUSION - 123)) | (1L << (GROUPING - 123)) | (1L << (HASH - 123)) | (1L << (INDEX - 123)) | (1L << (INSERT - 123)) | (1L << (INTERSECTION - 123)) | (1L << (ISODOW - 123)) | (1L << (ISOYEAR - 123)) | (1L << (LANGUAGE - 123)) | (1L << (LARGE - 123)) | (1L << (LAST - 123)) | (1L << (LESS - 123)) | (1L << (LIST - 123)) | (1L << (LOCATION - 123)) | (1L << (MATCH - 123)) | (1L << (MAX - 123)) | (1L << (MAXVALUE - 123)) | (1L << (MICROSECONDS - 123)) | (1L << (MILLENNIUM - 123)) | (1L << (MILLISECONDS - 123)) | (1L << (MIN - 123)) | (1L << (MINUTE - 123)) | (1L << (MONTH - 123)) | (1L << (NATIONAL - 123)) | (1L << (NULLIF - 123)) | (1L << (OBJECT - 123)) | (1L << (OPTION - 123)) | (1L << (OPTIONS - 123)))) != 0) || ((((_la - 187)) & ~0x3f) == 0 && ((1L << (_la - 187)) & ((1L << (OVERWRITE - 187)) | (1L << (PARSER - 187)) | (1L << (PARTIAL - 187)) | (1L << (PARTITION - 187)) | (1L << (PARTITIONS - 187)) | (1L << (PRECISION - 187)) | (1L << (PUBLIC - 187)) | (1L << (PURGE - 187)) | (1L << (QUARTER - 187)) | (1L << (RANGE - 187)) | (1L << (REGEXP - 187)) | (1L << (RLIKE - 187)) | (1L << (ROLLUP - 187)) | (1L << (SEARCH - 187)) | (1L << (SECOND - 187)) | (1L << (SERVER - 187)) | (1L << (SET - 187)) | (1L << (SIMILAR - 187)) | (1L << (SIMPLE - 187)) | (1L << (STORAGE - 187)) | (1L << (STDDEV_POP - 187)) | (1L << (STDDEV_SAMP - 187)) | (1L << (SUBPARTITION - 187)) | (1L << (SUM - 187)) | (1L << (TABLESPACE - 187)) | (1L << (TEMPLATE - 187)) | (1L << (THAN - 187)) | (1L << (TIMEZONE - 187)) | (1L << (TIMEZONE_HOUR - 187)) | (1L << (TIMEZONE_MINUTE - 187)) | (1L << (TRIM - 187)) | (1L << (TO - 187)) | (1L << (UNKNOWN - 187)) | (1L << (UNLOGGED - 187)) | (1L << (VALUES - 187)) | (1L << (VAR_SAMP - 187)) | (1L << (VAR_POP - 187)) | (1L << (VARYING - 187)) | (1L << (WEEK - 187)) | (1L << (WRAPPER - 187)) | (1L << (YEAR - 187)) | (1L << (ZONE - 187)) | (1L << (BOOLEAN - 187)) | (1L << (BOOL - 187)) | (1L << (BIT - 187)) | (1L << (VARBIT - 187)) | (1L << (INT1 - 187)) | (1L << (INT2 - 187)) | (1L << (INT4 - 187)) | (1L << (INT8 - 187)) | (1L << (TINYINT - 187)) | (1L << (SMALLINT - 187)) | (1L << (INT - 187)) | (1L << (INTEGER - 187)) | (1L << (BIGINT - 187)) | (1L << (FLOAT4 - 187)) | (1L << (FLOAT8 - 187)) | (1L << (REAL - 187)) | (1L << (FLOAT - 187)) | (1L << (DOUBLE - 187)) | (1L << (NUMERIC - 187)))) != 0) || ((((_la - 251)) & ~0x3f) == 0 && ((1L << (_la - 251)) & ((1L << (DECIMAL - 251)) | (1L << (CHAR - 251)) | (1L << (VARCHAR - 251)) | (1L << (NCHAR - 251)) | (1L << (NVARCHAR - 251)) | (1L << (DATE - 251)) | (1L << (TIME - 251)) | (1L << (TIMETZ - 251)) | (1L << (TIMESTAMP - 251)) | (1L << (TIMESTAMPTZ - 251)) | (1L << (TEXT - 251)) | (1L << (VARBINARY - 251)) | (1L << (BLOB - 251)) | (1L << (BYTEA - 251)) | (1L << (INET4 - 251)) | (1L << (QUOTE - 251)) | (1L << (Identifier - 251)))) != 0) );
			setState(1883); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 46, RULE_storage_parameter_oid);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1890);
			switch ( getInterpreter().adaptivePredict(_input,267,_ctx) ) {
			case 1:
				{
				setState(1885); storage_parameter();
				}
				break;
			case 2:
				{
				{
				setState(1886); match(WITH);
				setState(1887); match(OIDS);
				}
				}
				break;
			case 3:
				{
				{
				setState(1888); match(WITHOUT);
				setState(1889); match(OIDS);
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
		enterRule(_localctx, 48, RULE_on_commit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1901);
			_la = _input.LA(1);
			if (_la==ON) {
				{
				setState(1892); match(ON);
				setState(1893); match(COMMIT);
				setState(1899);
				switch (_input.LA(1)) {
				case PRESERVE:
					{
					{
					setState(1894); match(PRESERVE);
					setState(1895); match(ROWS);
					}
					}
					break;
				case DELETE:
					{
					{
					setState(1896); match(DELETE);
					setState(1897); match(ROWS);
					}
					}
					break;
				case DROP:
					{
					setState(1898); match(DROP);
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
		enterRule(_localctx, 50, RULE_table_space);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1905);
			switch ( getInterpreter().adaptivePredict(_input,270,_ctx) ) {
			case 1:
				{
				setState(1903); match(TABLESPACE);
				setState(1904); ((Table_spaceContext)_localctx).tablespace = identifier();
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
		enterRule(_localctx, 52, RULE_action);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1913);
			switch ( getInterpreter().adaptivePredict(_input,271,_ctx) ) {
			case 1:
				{
				setState(1907); match(RESTRICT);
				}
				break;
			case 2:
				{
				setState(1908); match(CASCADE);
				}
				break;
			case 3:
				{
				setState(1909); match(SET);
				setState(1910); match(NULL);
				}
				break;
			case 4:
				{
				setState(1911); match(SET);
				setState(1912); match(DEFAULT);
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
		enterRule(_localctx, 54, RULE_index_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1916);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(1915); storage_parameter();
				}
			}

			setState(1922);
			_la = _input.LA(1);
			if (_la==USING) {
				{
				setState(1918); match(USING);
				setState(1919); match(INDEX);
				setState(1920); match(TABLESPACE);
				setState(1921); ((Index_parametersContext)_localctx).tablespace = identifier();
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
		enterRule(_localctx, 56, RULE_table_elements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1924); match(LEFT_PAREN);
			setState(1925); field_element();
			setState(1930);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1926); match(COMMA);
				setState(1927); field_element();
				}
				}
				setState(1932);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1933); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 58, RULE_field_element);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1935); ((Field_elementContext)_localctx).name = identifier();
			setState(1936); field_type();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 60, RULE_field_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1938); data_type();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 62, RULE_param_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1940); match(WITH);
			setState(1941); match(LEFT_PAREN);
			setState(1942); param();
			setState(1947);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1943); match(COMMA);
				setState(1944); param();
				}
				}
				setState(1949);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1950); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 64, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1952); ((ParamContext)_localctx).key = match(Character_String_Literal);
			setState(1953); match(EQUAL);
			setState(1954); ((ParamContext)_localctx).value = numeric_value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 66, RULE_method_specifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1956); match(USING);
			setState(1957); ((Method_specifierContext)_localctx).m = identifier();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 68, RULE_table_space_specifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1959); match(TABLESPACE);
			setState(1960); table_space_name();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 70, RULE_table_space_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1962); identifier();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 72, RULE_table_partitioning_clauses);
		try {
			setState(1968);
			switch ( getInterpreter().adaptivePredict(_input,276,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1964); range_partitions();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1965); hash_partitions();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1966); list_partitions();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1967); column_partitions();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 74, RULE_range_partitions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1970); match(PARTITION);
			setState(1971); match(BY);
			setState(1972); match(RANGE);
			setState(1973); match(LEFT_PAREN);
			setState(1974); column_reference_list();
			setState(1975); match(RIGHT_PAREN);
			setState(1976); match(LEFT_PAREN);
			setState(1977); range_value_clause_list();
			setState(1978); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 76, RULE_range_value_clause_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1980); range_value_clause();
			setState(1985);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1981); match(COMMA);
				setState(1982); range_value_clause();
				}
				}
				setState(1987);
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
		enterRule(_localctx, 78, RULE_range_value_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1988); match(PARTITION);
			setState(1989); partition_name();
			setState(1990); match(VALUES);
			setState(1991); match(LESS);
			setState(1992); match(THAN);
			setState(2004);
			switch ( getInterpreter().adaptivePredict(_input,280,_ctx) ) {
			case 1:
				{
				setState(1993); match(LEFT_PAREN);
				setState(1994); value_expression();
				setState(1995); match(RIGHT_PAREN);
				}
				break;
			case 2:
				{
				setState(1998);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(1997); match(LEFT_PAREN);
					}
				}

				setState(2000); match(MAXVALUE);
				setState(2002);
				switch ( getInterpreter().adaptivePredict(_input,279,_ctx) ) {
				case 1:
					{
					setState(2001); match(RIGHT_PAREN);
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
		enterRule(_localctx, 80, RULE_hash_partitions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2006); match(PARTITION);
			setState(2007); match(BY);
			setState(2008); match(HASH);
			setState(2009); match(LEFT_PAREN);
			setState(2010); column_reference_list();
			setState(2011); match(RIGHT_PAREN);
			setState(2017);
			switch (_input.LA(1)) {
			case LEFT_PAREN:
				{
				setState(2012); match(LEFT_PAREN);
				setState(2013); individual_hash_partitions();
				setState(2014); match(RIGHT_PAREN);
				}
				break;
			case PARTITIONS:
				{
				setState(2016); hash_partitions_by_quantity();
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
		enterRule(_localctx, 82, RULE_individual_hash_partitions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2019); individual_hash_partition();
			setState(2024);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2020); match(COMMA);
				setState(2021); individual_hash_partition();
				}
				}
				setState(2026);
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
		enterRule(_localctx, 84, RULE_individual_hash_partition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2027); match(PARTITION);
			setState(2028); partition_name();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 86, RULE_hash_partitions_by_quantity);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2030); match(PARTITIONS);
			setState(2031); ((Hash_partitions_by_quantityContext)_localctx).quantity = numeric_value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 88, RULE_list_partitions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2033); match(PARTITION);
			setState(2034); match(BY);
			setState(2035); match(LIST);
			setState(2036); match(LEFT_PAREN);
			setState(2037); column_reference_list();
			setState(2038); match(RIGHT_PAREN);
			setState(2039); match(LEFT_PAREN);
			setState(2040); list_value_clause_list();
			setState(2041); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 90, RULE_list_value_clause_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2043); list_value_partition();
			setState(2048);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2044); match(COMMA);
				setState(2045); list_value_partition();
				}
				}
				setState(2050);
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
		enterRule(_localctx, 92, RULE_list_value_partition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2051); match(PARTITION);
			setState(2052); partition_name();
			setState(2053); match(VALUES);
			setState(2055);
			_la = _input.LA(1);
			if (_la==IN) {
				{
				setState(2054); match(IN);
				}
			}

			setState(2057); match(LEFT_PAREN);
			setState(2058); in_value_list();
			setState(2059); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 94, RULE_column_partitions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2061); match(PARTITION);
			setState(2062); match(BY);
			setState(2063); match(COLUMN);
			setState(2064); table_elements();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 96, RULE_partition_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2066); identifier();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 98, RULE_drop_table_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2068); match(DROP);
			setState(2069); match(TABLE);
			setState(2070); schema_qualified_name();
			setState(2072);
			switch ( getInterpreter().adaptivePredict(_input,285,_ctx) ) {
			case 1:
				{
				setState(2071); match(PURGE);
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
		enterRule(_localctx, 100, RULE_identifier);
		int _la;
		try {
			setState(2082);
			switch (_input.LA(1)) {
			case QUOTE:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(2075);
				_la = _input.LA(1);
				if (_la==QUOTE) {
					{
					setState(2074); match(QUOTE);
					}
				}

				setState(2077); match(Identifier);
				setState(2079);
				switch ( getInterpreter().adaptivePredict(_input,287,_ctx) ) {
				case 1:
					{
					setState(2078); match(QUOTE);
					}
					break;
				}
				}
				break;
			case ADMIN:
			case AVG:
			case BETWEEN:
			case BY:
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
			case COUNT:
			case CUBE:
			case DATA:
			case DAY:
			case DEC:
			case DECADE:
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
			case INSERT:
			case INTERSECTION:
			case ISODOW:
			case ISOYEAR:
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
			case MINUTE:
			case MONTH:
			case NATIONAL:
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
			case SERVER:
			case SET:
			case SIMILAR:
			case SIMPLE:
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
			case WEEK:
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
				setState(2081); nonreserved_keywords();
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
		public TerminalNode COALESCE() { return getToken(SQLParser.COALESCE, 0); }
		public TerminalNode STDDEV_POP() { return getToken(SQLParser.STDDEV_POP, 0); }
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
		public TerminalNode RLIKE() { return getToken(SQLParser.RLIKE, 0); }
		public TerminalNode BYTEA() { return getToken(SQLParser.BYTEA, 0); }
		public TerminalNode PARTITION() { return getToken(SQLParser.PARTITION, 0); }
		public TerminalNode PURGE() { return getToken(SQLParser.PURGE, 0); }
		public TerminalNode CHAR() { return getToken(SQLParser.CHAR, 0); }
		public TerminalNode VARBINARY() { return getToken(SQLParser.VARBINARY, 0); }
		public TerminalNode VARCHAR() { return getToken(SQLParser.VARCHAR, 0); }
		public TerminalNode AVG() { return getToken(SQLParser.AVG, 0); }
		public TerminalNode INET4() { return getToken(SQLParser.INET4, 0); }
		public TerminalNode FLOAT8() { return getToken(SQLParser.FLOAT8, 0); }
		public TerminalNode DROP() { return getToken(SQLParser.DROP, 0); }
		public TerminalNode VAR_POP() { return getToken(SQLParser.VAR_POP, 0); }
		public TerminalNode ISOYEAR() { return getToken(SQLParser.ISOYEAR, 0); }
		public TerminalNode CONFIGURATION() { return getToken(SQLParser.CONFIGURATION, 0); }
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
		public TerminalNode CHECK() { return getToken(SQLParser.CHECK, 0); }
		public TerminalNode OBJECT() { return getToken(SQLParser.OBJECT, 0); }
		public TerminalNode TABLESPACE() { return getToken(SQLParser.TABLESPACE, 0); }
		public TerminalNode TEXT() { return getToken(SQLParser.TEXT, 0); }
		public TerminalNode MONTH() { return getToken(SQLParser.MONTH, 0); }
		public TerminalNode BLOB() { return getToken(SQLParser.BLOB, 0); }
		public TerminalNode DEC() { return getToken(SQLParser.DEC, 0); }
		public TerminalNode INTERSECTION() { return getToken(SQLParser.INTERSECTION, 0); }
		public TerminalNode TEMPLATE() { return getToken(SQLParser.TEMPLATE, 0); }
		public TerminalNode CLASS() { return getToken(SQLParser.CLASS, 0); }
		public TerminalNode LESS() { return getToken(SQLParser.LESS, 0); }
		public TerminalNode MILLENNIUM() { return getToken(SQLParser.MILLENNIUM, 0); }
		public TerminalNode SIMPLE() { return getToken(SQLParser.SIMPLE, 0); }
		public TerminalNode OPTION() { return getToken(SQLParser.OPTION, 0); }
		public TerminalNode TINYINT() { return getToken(SQLParser.TINYINT, 0); }
		public TerminalNode STORAGE() { return getToken(SQLParser.STORAGE, 0); }
		public TerminalNode GROUPING() { return getToken(SQLParser.GROUPING, 0); }
		public TerminalNode TIMESTAMPTZ() { return getToken(SQLParser.TIMESTAMPTZ, 0); }
		public TerminalNode NATIONAL() { return getToken(SQLParser.NATIONAL, 0); }
		public TerminalNode BETWEEN() { return getToken(SQLParser.BETWEEN, 0); }
		public TerminalNode DATE() { return getToken(SQLParser.DATE, 0); }
		public TerminalNode PARSER() { return getToken(SQLParser.PARSER, 0); }
		public TerminalNode FUSION() { return getToken(SQLParser.FUSION, 0); }
		public TerminalNode UNLOGGED() { return getToken(SQLParser.UNLOGGED, 0); }
		public TerminalNode COMMIT() { return getToken(SQLParser.COMMIT, 0); }
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
		public TerminalNode VALUES() { return getToken(SQLParser.VALUES, 0); }
		public TerminalNode TO() { return getToken(SQLParser.TO, 0); }
		public TerminalNode SMALLINT() { return getToken(SQLParser.SMALLINT, 0); }
		public TerminalNode ISODOW() { return getToken(SQLParser.ISODOW, 0); }
		public TerminalNode FORMAT() { return getToken(SQLParser.FORMAT, 0); }
		public TerminalNode DOY() { return getToken(SQLParser.DOY, 0); }
		public TerminalNode COMMENTS() { return getToken(SQLParser.COMMENTS, 0); }
		public TerminalNode MIN() { return getToken(SQLParser.MIN, 0); }
		public TerminalNode FILTER() { return getToken(SQLParser.FILTER, 0); }
		public TerminalNode PRECISION() { return getToken(SQLParser.PRECISION, 0); }
		public TerminalNode SUBPARTITION() { return getToken(SQLParser.SUBPARTITION, 0); }
		public TerminalNode DOW() { return getToken(SQLParser.DOW, 0); }
		public TerminalNode EXTERNAL() { return getToken(SQLParser.EXTERNAL, 0); }
		public TerminalNode SEARCH() { return getToken(SQLParser.SEARCH, 0); }
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
		public TerminalNode SERVER() { return getToken(SQLParser.SERVER, 0); }
		public TerminalNode REAL() { return getToken(SQLParser.REAL, 0); }
		public TerminalNode LANGUAGE() { return getToken(SQLParser.LANGUAGE, 0); }
		public TerminalNode COMMENT() { return getToken(SQLParser.COMMENT, 0); }
		public TerminalNode DAY() { return getToken(SQLParser.DAY, 0); }
		public TerminalNode COLLECT() { return getToken(SQLParser.COLLECT, 0); }
		public TerminalNode BIGINT() { return getToken(SQLParser.BIGINT, 0); }
		public TerminalNode STDDEV_SAMP() { return getToken(SQLParser.STDDEV_SAMP, 0); }
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
		enterRule(_localctx, 102, RULE_nonreserved_keywords);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2084);
			_la = _input.LA(1);
			if ( !(((((_la - 123)) & ~0x3f) == 0 && ((1L << (_la - 123)) & ((1L << (ADMIN - 123)) | (1L << (AVG - 123)) | (1L << (BETWEEN - 123)) | (1L << (BY - 123)) | (1L << (CLASS - 123)) | (1L << (CENTURY - 123)) | (1L << (CHARACTER - 123)) | (1L << (CHECK - 123)) | (1L << (COLLECT - 123)) | (1L << (COALESCE - 123)) | (1L << (COLUMN - 123)) | (1L << (COMMENT - 123)) | (1L << (COMMENTS - 123)) | (1L << (COMMIT - 123)) | (1L << (CONFIGURATION - 123)) | (1L << (COUNT - 123)) | (1L << (CUBE - 123)) | (1L << (DATA - 123)) | (1L << (DAY - 123)) | (1L << (DEC - 123)) | (1L << (DECADE - 123)) | (1L << (DICTIONARY - 123)) | (1L << (DOW - 123)) | (1L << (DOY - 123)) | (1L << (DROP - 123)) | (1L << (EPOCH - 123)) | (1L << (EVERY - 123)) | (1L << (EXISTS - 123)) | (1L << (EXTERNAL - 123)) | (1L << (EXTRACT - 123)) | (1L << (FAMILY - 123)) | (1L << (FILTER - 123)) | (1L << (FIRST - 123)) | (1L << (FORMAT - 123)) | (1L << (FUSION - 123)) | (1L << (GROUPING - 123)) | (1L << (HASH - 123)) | (1L << (INDEX - 123)) | (1L << (INSERT - 123)) | (1L << (INTERSECTION - 123)) | (1L << (ISODOW - 123)) | (1L << (ISOYEAR - 123)) | (1L << (LANGUAGE - 123)) | (1L << (LARGE - 123)) | (1L << (LAST - 123)) | (1L << (LESS - 123)) | (1L << (LIST - 123)) | (1L << (LOCATION - 123)) | (1L << (MATCH - 123)) | (1L << (MAX - 123)) | (1L << (MAXVALUE - 123)) | (1L << (MICROSECONDS - 123)) | (1L << (MILLENNIUM - 123)) | (1L << (MILLISECONDS - 123)) | (1L << (MIN - 123)) | (1L << (MINUTE - 123)) | (1L << (MONTH - 123)) | (1L << (NATIONAL - 123)) | (1L << (NULLIF - 123)) | (1L << (OBJECT - 123)) | (1L << (OPTION - 123)) | (1L << (OPTIONS - 123)))) != 0) || ((((_la - 187)) & ~0x3f) == 0 && ((1L << (_la - 187)) & ((1L << (OVERWRITE - 187)) | (1L << (PARSER - 187)) | (1L << (PARTIAL - 187)) | (1L << (PARTITION - 187)) | (1L << (PARTITIONS - 187)) | (1L << (PRECISION - 187)) | (1L << (PUBLIC - 187)) | (1L << (PURGE - 187)) | (1L << (QUARTER - 187)) | (1L << (RANGE - 187)) | (1L << (REGEXP - 187)) | (1L << (RLIKE - 187)) | (1L << (ROLLUP - 187)) | (1L << (SEARCH - 187)) | (1L << (SECOND - 187)) | (1L << (SERVER - 187)) | (1L << (SET - 187)) | (1L << (SIMILAR - 187)) | (1L << (SIMPLE - 187)) | (1L << (STORAGE - 187)) | (1L << (STDDEV_POP - 187)) | (1L << (STDDEV_SAMP - 187)) | (1L << (SUBPARTITION - 187)) | (1L << (SUM - 187)) | (1L << (TABLESPACE - 187)) | (1L << (TEMPLATE - 187)) | (1L << (THAN - 187)) | (1L << (TIMEZONE - 187)) | (1L << (TIMEZONE_HOUR - 187)) | (1L << (TIMEZONE_MINUTE - 187)) | (1L << (TRIM - 187)) | (1L << (TO - 187)) | (1L << (UNKNOWN - 187)) | (1L << (UNLOGGED - 187)) | (1L << (VALUES - 187)) | (1L << (VAR_SAMP - 187)) | (1L << (VAR_POP - 187)) | (1L << (VARYING - 187)) | (1L << (WEEK - 187)) | (1L << (WRAPPER - 187)) | (1L << (YEAR - 187)) | (1L << (ZONE - 187)) | (1L << (BOOLEAN - 187)) | (1L << (BOOL - 187)) | (1L << (BIT - 187)) | (1L << (VARBIT - 187)) | (1L << (INT1 - 187)) | (1L << (INT2 - 187)) | (1L << (INT4 - 187)) | (1L << (INT8 - 187)) | (1L << (TINYINT - 187)) | (1L << (SMALLINT - 187)) | (1L << (INT - 187)) | (1L << (INTEGER - 187)) | (1L << (BIGINT - 187)) | (1L << (FLOAT4 - 187)) | (1L << (FLOAT8 - 187)) | (1L << (REAL - 187)) | (1L << (FLOAT - 187)) | (1L << (DOUBLE - 187)) | (1L << (NUMERIC - 187)))) != 0) || ((((_la - 251)) & ~0x3f) == 0 && ((1L << (_la - 251)) & ((1L << (DECIMAL - 251)) | (1L << (CHAR - 251)) | (1L << (VARCHAR - 251)) | (1L << (NCHAR - 251)) | (1L << (NVARCHAR - 251)) | (1L << (DATE - 251)) | (1L << (TIME - 251)) | (1L << (TIMETZ - 251)) | (1L << (TIMESTAMP - 251)) | (1L << (TIMESTAMPTZ - 251)) | (1L << (TEXT - 251)) | (1L << (VARBINARY - 251)) | (1L << (BLOB - 251)) | (1L << (BYTEA - 251)) | (1L << (INET4 - 251)))) != 0)) ) {
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
		enterRule(_localctx, 104, RULE_unsigned_literal);
		try {
			setState(2088);
			switch (_input.LA(1)) {
			case NUMBER:
			case REAL_NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(2086); unsigned_numeric_literal();
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
				setState(2087); general_literal();
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
		enterRule(_localctx, 106, RULE_general_literal);
		try {
			setState(2093);
			switch (_input.LA(1)) {
			case Character_String_Literal:
				enterOuterAlt(_localctx, 1);
				{
				setState(2090); match(Character_String_Literal);
				}
				break;
			case DATE:
			case TIME:
			case TIMESTAMP:
				enterOuterAlt(_localctx, 2);
				{
				setState(2091); datetime_literal();
				}
				break;
			case FALSE:
			case TRUE:
			case UNKNOWN:
				enterOuterAlt(_localctx, 3);
				{
				setState(2092); boolean_literal();
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
		enterRule(_localctx, 108, RULE_datetime_literal);
		try {
			setState(2098);
			switch (_input.LA(1)) {
			case TIMESTAMP:
				enterOuterAlt(_localctx, 1);
				{
				setState(2095); timestamp_literal();
				}
				break;
			case TIME:
				enterOuterAlt(_localctx, 2);
				{
				setState(2096); time_literal();
				}
				break;
			case DATE:
				enterOuterAlt(_localctx, 3);
				{
				setState(2097); date_literal();
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
		enterRule(_localctx, 110, RULE_time_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2100); match(TIME);
			setState(2101); ((Time_literalContext)_localctx).time_string = match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 112, RULE_timestamp_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2103); match(TIMESTAMP);
			setState(2104); ((Timestamp_literalContext)_localctx).timestamp_string = match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 114, RULE_date_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2106); match(DATE);
			setState(2107); ((Date_literalContext)_localctx).date_string = match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 116, RULE_boolean_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2109);
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
		enterRule(_localctx, 118, RULE_data_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2111); predefined_type();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 120, RULE_predefined_type);
		try {
			setState(2123);
			switch (_input.LA(1)) {
			case CHARACTER:
			case CHAR:
			case VARCHAR:
			case TEXT:
				enterOuterAlt(_localctx, 1);
				{
				setState(2113); character_string_type();
				}
				break;
			case NATIONAL:
			case NCHAR:
			case NVARCHAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(2114); national_character_string_type();
				}
				break;
			case BLOB:
			case BYTEA:
				enterOuterAlt(_localctx, 3);
				{
				setState(2115); binary_large_object_string_type();
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
				setState(2116); numeric_type();
				}
				break;
			case BOOLEAN:
			case BOOL:
				enterOuterAlt(_localctx, 5);
				{
				setState(2117); boolean_type();
				}
				break;
			case DATE:
			case TIME:
			case TIMETZ:
			case TIMESTAMP:
			case TIMESTAMPTZ:
				enterOuterAlt(_localctx, 6);
				{
				setState(2118); datetime_type();
				}
				break;
			case BIT:
			case VARBIT:
				enterOuterAlt(_localctx, 7);
				{
				setState(2119); bit_type();
				}
				break;
			case BINARY:
			case VARBINARY:
				enterOuterAlt(_localctx, 8);
				{
				setState(2120); binary_type();
				}
				break;
			case INET4:
				enterOuterAlt(_localctx, 9);
				{
				setState(2121); network_type();
				}
				break;
			case REGCLASS:
				enterOuterAlt(_localctx, 10);
				{
				setState(2122); regclass();
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
		enterRule(_localctx, 122, RULE_regclass);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2125); match(REGCLASS);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 124, RULE_network_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2127); match(INET4);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 126, RULE_character_string_type);
		try {
			setState(2152);
			switch ( getInterpreter().adaptivePredict(_input,298,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2129); match(CHARACTER);
				setState(2131);
				switch ( getInterpreter().adaptivePredict(_input,293,_ctx) ) {
				case 1:
					{
					setState(2130); type_length();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2133); match(CHAR);
				setState(2135);
				switch ( getInterpreter().adaptivePredict(_input,294,_ctx) ) {
				case 1:
					{
					setState(2134); type_length();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2137); match(CHARACTER);
				setState(2138); match(VARYING);
				setState(2140);
				switch ( getInterpreter().adaptivePredict(_input,295,_ctx) ) {
				case 1:
					{
					setState(2139); type_length();
					}
					break;
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2142); match(CHAR);
				setState(2143); match(VARYING);
				setState(2145);
				switch ( getInterpreter().adaptivePredict(_input,296,_ctx) ) {
				case 1:
					{
					setState(2144); type_length();
					}
					break;
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2147); match(VARCHAR);
				setState(2149);
				switch ( getInterpreter().adaptivePredict(_input,297,_ctx) ) {
				case 1:
					{
					setState(2148); type_length();
					}
					break;
				}
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2151); match(TEXT);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 128, RULE_type_length);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2154); match(LEFT_PAREN);
			setState(2155); match(NUMBER);
			setState(2156); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 130, RULE_national_character_string_type);
		try {
			setState(2193);
			switch ( getInterpreter().adaptivePredict(_input,306,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2158); match(NATIONAL);
				setState(2159); match(CHARACTER);
				setState(2161);
				switch ( getInterpreter().adaptivePredict(_input,299,_ctx) ) {
				case 1:
					{
					setState(2160); type_length();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2163); match(NATIONAL);
				setState(2164); match(CHAR);
				setState(2166);
				switch ( getInterpreter().adaptivePredict(_input,300,_ctx) ) {
				case 1:
					{
					setState(2165); type_length();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2168); match(NCHAR);
				setState(2170);
				switch ( getInterpreter().adaptivePredict(_input,301,_ctx) ) {
				case 1:
					{
					setState(2169); type_length();
					}
					break;
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2172); match(NATIONAL);
				setState(2173); match(CHARACTER);
				setState(2174); match(VARYING);
				setState(2176);
				switch ( getInterpreter().adaptivePredict(_input,302,_ctx) ) {
				case 1:
					{
					setState(2175); type_length();
					}
					break;
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2178); match(NATIONAL);
				setState(2179); match(CHAR);
				setState(2180); match(VARYING);
				setState(2182);
				switch ( getInterpreter().adaptivePredict(_input,303,_ctx) ) {
				case 1:
					{
					setState(2181); type_length();
					}
					break;
				}
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2184); match(NCHAR);
				setState(2185); match(VARYING);
				setState(2187);
				switch ( getInterpreter().adaptivePredict(_input,304,_ctx) ) {
				case 1:
					{
					setState(2186); type_length();
					}
					break;
				}
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(2189); match(NVARCHAR);
				setState(2191);
				switch ( getInterpreter().adaptivePredict(_input,305,_ctx) ) {
				case 1:
					{
					setState(2190); type_length();
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
		enterRule(_localctx, 132, RULE_binary_large_object_string_type);
		try {
			setState(2203);
			switch (_input.LA(1)) {
			case BLOB:
				enterOuterAlt(_localctx, 1);
				{
				setState(2195); match(BLOB);
				setState(2197);
				switch ( getInterpreter().adaptivePredict(_input,307,_ctx) ) {
				case 1:
					{
					setState(2196); type_length();
					}
					break;
				}
				}
				break;
			case BYTEA:
				enterOuterAlt(_localctx, 2);
				{
				setState(2199); match(BYTEA);
				setState(2201);
				switch ( getInterpreter().adaptivePredict(_input,308,_ctx) ) {
				case 1:
					{
					setState(2200); type_length();
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
		enterRule(_localctx, 134, RULE_numeric_type);
		try {
			setState(2207);
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
				setState(2205); exact_numeric_type();
				}
				break;
			case FLOAT4:
			case FLOAT8:
			case REAL:
			case FLOAT:
			case DOUBLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(2206); approximate_numeric_type();
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
		enterRule(_localctx, 136, RULE_exact_numeric_type);
		try {
			setState(2230);
			switch (_input.LA(1)) {
			case NUMERIC:
				enterOuterAlt(_localctx, 1);
				{
				setState(2209); match(NUMERIC);
				setState(2211);
				switch ( getInterpreter().adaptivePredict(_input,311,_ctx) ) {
				case 1:
					{
					setState(2210); precision_param();
					}
					break;
				}
				}
				break;
			case DECIMAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(2213); match(DECIMAL);
				setState(2215);
				switch ( getInterpreter().adaptivePredict(_input,312,_ctx) ) {
				case 1:
					{
					setState(2214); precision_param();
					}
					break;
				}
				}
				break;
			case DEC:
				enterOuterAlt(_localctx, 3);
				{
				setState(2217); match(DEC);
				setState(2219);
				switch ( getInterpreter().adaptivePredict(_input,313,_ctx) ) {
				case 1:
					{
					setState(2218); precision_param();
					}
					break;
				}
				}
				break;
			case INT1:
				enterOuterAlt(_localctx, 4);
				{
				setState(2221); match(INT1);
				}
				break;
			case TINYINT:
				enterOuterAlt(_localctx, 5);
				{
				setState(2222); match(TINYINT);
				}
				break;
			case INT2:
				enterOuterAlt(_localctx, 6);
				{
				setState(2223); match(INT2);
				}
				break;
			case SMALLINT:
				enterOuterAlt(_localctx, 7);
				{
				setState(2224); match(SMALLINT);
				}
				break;
			case INT4:
				enterOuterAlt(_localctx, 8);
				{
				setState(2225); match(INT4);
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 9);
				{
				setState(2226); match(INT);
				}
				break;
			case INTEGER:
				enterOuterAlt(_localctx, 10);
				{
				setState(2227); match(INTEGER);
				}
				break;
			case INT8:
				enterOuterAlt(_localctx, 11);
				{
				setState(2228); match(INT8);
				}
				break;
			case BIGINT:
				enterOuterAlt(_localctx, 12);
				{
				setState(2229); match(BIGINT);
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
		enterRule(_localctx, 138, RULE_approximate_numeric_type);
		try {
			setState(2242);
			switch ( getInterpreter().adaptivePredict(_input,316,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2232); match(FLOAT);
				setState(2234);
				switch ( getInterpreter().adaptivePredict(_input,315,_ctx) ) {
				case 1:
					{
					setState(2233); precision_param();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2236); match(FLOAT4);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2237); match(REAL);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2238); match(FLOAT8);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2239); match(DOUBLE);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2240); match(DOUBLE);
				setState(2241); match(PRECISION);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 140, RULE_precision_param);
		try {
			setState(2252);
			switch ( getInterpreter().adaptivePredict(_input,317,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2244); match(LEFT_PAREN);
				setState(2245); ((Precision_paramContext)_localctx).precision = match(NUMBER);
				setState(2246); match(RIGHT_PAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2247); match(LEFT_PAREN);
				setState(2248); ((Precision_paramContext)_localctx).precision = match(NUMBER);
				setState(2249); match(COMMA);
				setState(2250); ((Precision_paramContext)_localctx).scale = match(NUMBER);
				setState(2251); match(RIGHT_PAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 142, RULE_boolean_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2254);
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
		enterRule(_localctx, 144, RULE_datetime_type);
		try {
			setState(2269);
			switch ( getInterpreter().adaptivePredict(_input,318,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2256); match(DATE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2257); match(TIME);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2258); match(TIME);
				setState(2259); match(WITH);
				setState(2260); match(TIME);
				setState(2261); match(ZONE);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2262); match(TIMETZ);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2263); match(TIMESTAMP);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2264); match(TIMESTAMP);
				setState(2265); match(WITH);
				setState(2266); match(TIME);
				setState(2267); match(ZONE);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(2268); match(TIMESTAMPTZ);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 146, RULE_bit_type);
		try {
			setState(2284);
			switch ( getInterpreter().adaptivePredict(_input,322,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2271); match(BIT);
				setState(2273);
				switch ( getInterpreter().adaptivePredict(_input,319,_ctx) ) {
				case 1:
					{
					setState(2272); type_length();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2275); match(VARBIT);
				setState(2277);
				switch ( getInterpreter().adaptivePredict(_input,320,_ctx) ) {
				case 1:
					{
					setState(2276); type_length();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2279); match(BIT);
				setState(2280); match(VARYING);
				setState(2282);
				switch ( getInterpreter().adaptivePredict(_input,321,_ctx) ) {
				case 1:
					{
					setState(2281); type_length();
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
		enterRule(_localctx, 148, RULE_binary_type);
		try {
			setState(2299);
			switch ( getInterpreter().adaptivePredict(_input,326,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2286); match(BINARY);
				setState(2288);
				switch ( getInterpreter().adaptivePredict(_input,323,_ctx) ) {
				case 1:
					{
					setState(2287); type_length();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2290); match(BINARY);
				setState(2291); match(VARYING);
				setState(2293);
				switch ( getInterpreter().adaptivePredict(_input,324,_ctx) ) {
				case 1:
					{
					setState(2292); type_length();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2295); match(VARBINARY);
				setState(2297);
				switch ( getInterpreter().adaptivePredict(_input,325,_ctx) ) {
				case 1:
					{
					setState(2296); type_length();
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
		enterRule(_localctx, 150, RULE_value_expression_primary);
		try {
			setState(2303);
			switch ( getInterpreter().adaptivePredict(_input,327,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2301); parenthesized_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2302); nonparenthesized_value_expression_primary();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 152, RULE_parenthesized_value_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2305); match(LEFT_PAREN);
			setState(2306); value_expression();
			setState(2307); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 154, RULE_nonparenthesized_value_expression_primary);
		try {
			setState(2316);
			switch ( getInterpreter().adaptivePredict(_input,328,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2309); unsigned_value_specification();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2310); column_reference();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2311); set_function_specification();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2312); scalar_subquery();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2313); case_expression();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2314); cast_specification();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(2315); routine_invocation();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 156, RULE_unsigned_value_specification);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2318); unsigned_literal();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 158, RULE_unsigned_numeric_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2320);
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
		enterRule(_localctx, 160, RULE_signed_numerical_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2323);
			_la = _input.LA(1);
			if (_la==PLUS || _la==MINUS) {
				{
				setState(2322); sign();
				}
			}

			setState(2325); unsigned_numeric_literal();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 162, RULE_set_function_specification);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2327); aggregate_function();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 164, RULE_aggregate_function);
		try {
			setState(2337);
			switch ( getInterpreter().adaptivePredict(_input,331,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2329); match(COUNT);
				setState(2330); match(LEFT_PAREN);
				setState(2331); match(MULTIPLY);
				setState(2332); match(RIGHT_PAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2333); general_set_function();
				setState(2335);
				switch ( getInterpreter().adaptivePredict(_input,330,_ctx) ) {
				case 1:
					{
					setState(2334); filter_clause();
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
		enterRule(_localctx, 166, RULE_general_set_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2339); set_function_type();
			setState(2340); match(LEFT_PAREN);
			setState(2342);
			_la = _input.LA(1);
			if (_la==ALL || _la==DISTINCT) {
				{
				setState(2341); set_qualifier();
				}
			}

			setState(2344); value_expression();
			setState(2345); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 168, RULE_set_function_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2347);
			_la = _input.LA(1);
			if ( !(_la==ANY || ((((_la - 100)) & ~0x3f) == 0 && ((1L << (_la - 100)) & ((1L << (SOME - 100)) | (1L << (AVG - 100)) | (1L << (COLLECT - 100)) | (1L << (COUNT - 100)) | (1L << (EVERY - 100)) | (1L << (FUSION - 100)))) != 0) || ((((_la - 164)) & ~0x3f) == 0 && ((1L << (_la - 164)) & ((1L << (INTERSECTION - 164)) | (1L << (MAX - 164)) | (1L << (MIN - 164)) | (1L << (STDDEV_POP - 164)) | (1L << (STDDEV_SAMP - 164)) | (1L << (SUM - 164)) | (1L << (VAR_SAMP - 164)) | (1L << (VAR_POP - 164)))) != 0)) ) {
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
		enterRule(_localctx, 170, RULE_filter_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2349); match(FILTER);
			setState(2350); match(LEFT_PAREN);
			setState(2351); match(WHERE);
			setState(2352); search_condition();
			setState(2353); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 172, RULE_grouping_operation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2355); match(GROUPING);
			setState(2356); match(LEFT_PAREN);
			setState(2357); column_reference_list();
			setState(2358); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 174, RULE_case_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2360); case_specification();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 176, RULE_case_abbreviation);
		int _la;
		try {
			setState(2380);
			switch (_input.LA(1)) {
			case NULLIF:
				enterOuterAlt(_localctx, 1);
				{
				setState(2362); match(NULLIF);
				setState(2363); match(LEFT_PAREN);
				setState(2364); numeric_value_expression();
				setState(2365); match(COMMA);
				setState(2366); boolean_value_expression();
				setState(2367); match(RIGHT_PAREN);
				}
				break;
			case COALESCE:
				enterOuterAlt(_localctx, 2);
				{
				setState(2369); match(COALESCE);
				setState(2370); match(LEFT_PAREN);
				setState(2371); numeric_value_expression();
				setState(2374); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(2372); match(COMMA);
					setState(2373); boolean_value_expression();
					}
					}
					setState(2376); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==COMMA );
				setState(2378); match(RIGHT_PAREN);
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
		enterRule(_localctx, 178, RULE_case_specification);
		try {
			setState(2384);
			switch ( getInterpreter().adaptivePredict(_input,335,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2382); simple_case();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2383); searched_case();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 180, RULE_simple_case);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2386); match(CASE);
			setState(2387); boolean_value_expression();
			setState(2389); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(2388); simple_when_clause();
				}
				}
				setState(2391); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WHEN );
			setState(2394);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(2393); else_clause();
				}
			}

			setState(2396); match(END);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 182, RULE_searched_case);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2398); match(CASE);
			setState(2400); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(2399); searched_when_clause();
				}
				}
				setState(2402); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WHEN );
			setState(2405);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(2404); else_clause();
				}
			}

			setState(2407); match(END);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 184, RULE_simple_when_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2409); match(WHEN);
			setState(2410); search_condition();
			setState(2411); match(THEN);
			setState(2412); result();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 186, RULE_searched_when_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2414); match(WHEN);
			setState(2415); ((Searched_when_clauseContext)_localctx).c = search_condition();
			setState(2416); match(THEN);
			setState(2417); ((Searched_when_clauseContext)_localctx).r = result();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 188, RULE_else_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2419); match(ELSE);
			setState(2420); ((Else_clauseContext)_localctx).r = result();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 190, RULE_result);
		try {
			setState(2424);
			switch ( getInterpreter().adaptivePredict(_input,340,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2422); value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2423); match(NULL);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 192, RULE_cast_specification);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2426); match(CAST);
			setState(2427); match(LEFT_PAREN);
			setState(2428); cast_operand();
			setState(2429); match(AS);
			setState(2430); cast_target();
			setState(2431); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 194, RULE_cast_operand);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2433); value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 196, RULE_cast_target);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2435); data_type();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 198, RULE_value_expression);
		try {
			setState(2440);
			switch ( getInterpreter().adaptivePredict(_input,341,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2437); common_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2438); row_value_expression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2439); boolean_value_expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 200, RULE_common_value_expression);
		try {
			setState(2445);
			switch ( getInterpreter().adaptivePredict(_input,342,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2442); numeric_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2443); string_value_expression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2444); match(NULL);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 202, RULE_numeric_value_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2447); ((Numeric_value_expressionContext)_localctx).left = term();
			setState(2452);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				{
				setState(2448);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(2449); ((Numeric_value_expressionContext)_localctx).right = term();
				}
				}
				setState(2454);
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
		enterRule(_localctx, 204, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2455); ((TermContext)_localctx).left = factor();
			setState(2460);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 287)) & ~0x3f) == 0 && ((1L << (_la - 287)) & ((1L << (MULTIPLY - 287)) | (1L << (DIVIDE - 287)) | (1L << (MODULAR - 287)))) != 0)) {
				{
				{
				setState(2456);
				_la = _input.LA(1);
				if ( !(((((_la - 287)) & ~0x3f) == 0 && ((1L << (_la - 287)) & ((1L << (MULTIPLY - 287)) | (1L << (DIVIDE - 287)) | (1L << (MODULAR - 287)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(2457); ((TermContext)_localctx).right = factor();
				}
				}
				setState(2462);
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
		enterRule(_localctx, 206, RULE_factor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2464);
			_la = _input.LA(1);
			if (_la==PLUS || _la==MINUS) {
				{
				setState(2463); sign();
				}
			}

			setState(2466); numeric_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 208, RULE_array);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2468); match(LEFT_PAREN);
			setState(2469); numeric_value_expression();
			setState(2474);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2470); match(COMMA);
				setState(2471); numeric_value_expression();
				}
				}
				setState(2476);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2477); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 210, RULE_numeric_primary);
		int _la;
		try {
			setState(2488);
			switch ( getInterpreter().adaptivePredict(_input,348,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2479); value_expression_primary();
				setState(2484);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CAST_EXPRESSION) {
					{
					{
					setState(2480); match(CAST_EXPRESSION);
					setState(2481); cast_target();
					}
					}
					setState(2486);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2487); numeric_value_function();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 212, RULE_sign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2490);
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
		enterRule(_localctx, 214, RULE_numeric_value_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2492); extract_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 216, RULE_extract_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2494); match(EXTRACT);
			setState(2495); match(LEFT_PAREN);
			setState(2496); ((Extract_expressionContext)_localctx).extract_field_string = extract_field();
			setState(2497); match(FROM);
			setState(2498); extract_source();
			setState(2499); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 218, RULE_extract_field);
		try {
			setState(2504);
			switch (_input.LA(1)) {
			case DAY:
			case HOUR:
			case MINUTE:
			case MONTH:
			case SECOND:
			case YEAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(2501); primary_datetime_field();
				}
				break;
			case TIMEZONE:
			case TIMEZONE_HOUR:
			case TIMEZONE_MINUTE:
				enterOuterAlt(_localctx, 2);
				{
				setState(2502); time_zone_field();
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
				setState(2503); extended_datetime_field();
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
		enterRule(_localctx, 220, RULE_time_zone_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2506);
			_la = _input.LA(1);
			if ( !(((((_la - 215)) & ~0x3f) == 0 && ((1L << (_la - 215)) & ((1L << (TIMEZONE - 215)) | (1L << (TIMEZONE_HOUR - 215)) | (1L << (TIMEZONE_MINUTE - 215)))) != 0)) ) {
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
		enterRule(_localctx, 222, RULE_extract_source);
		try {
			setState(2510);
			switch ( getInterpreter().adaptivePredict(_input,350,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2508); column_reference();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2509); datetime_literal();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 224, RULE_string_value_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2512); character_value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 226, RULE_character_value_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2514); character_factor();
			setState(2519);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CONCATENATION_OPERATOR) {
				{
				{
				setState(2515); match(CONCATENATION_OPERATOR);
				setState(2516); character_factor();
				}
				}
				setState(2521);
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
		enterRule(_localctx, 228, RULE_character_factor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2522); character_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 230, RULE_character_primary);
		try {
			setState(2526);
			switch ( getInterpreter().adaptivePredict(_input,352,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2524); value_expression_primary();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2525); string_value_function();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 232, RULE_string_value_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2528); trim_function();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 234, RULE_trim_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2530); match(TRIM);
			setState(2531); match(LEFT_PAREN);
			setState(2532); trim_operands();
			setState(2533); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 236, RULE_trim_operands);
		int _la;
		try {
			setState(2549);
			switch ( getInterpreter().adaptivePredict(_input,356,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2542);
				switch ( getInterpreter().adaptivePredict(_input,355,_ctx) ) {
				case 1:
					{
					setState(2536);
					_la = _input.LA(1);
					if (_la==BOTH || _la==LEADING || _la==TRAILING) {
						{
						setState(2535); trim_specification();
						}
					}

					setState(2539);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ANY) | (1L << CASE) | (1L << CAST) | (1L << FALSE))) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (LEFT - 66)) | (1L << (RIGHT - 66)) | (1L << (SOME - 66)) | (1L << (TRUE - 66)) | (1L << (ADMIN - 66)) | (1L << (AVG - 66)) | (1L << (BETWEEN - 66)) | (1L << (BY - 66)) | (1L << (CLASS - 66)) | (1L << (CENTURY - 66)) | (1L << (CHARACTER - 66)))) != 0) || ((((_la - 130)) & ~0x3f) == 0 && ((1L << (_la - 130)) & ((1L << (CHECK - 130)) | (1L << (COLLECT - 130)) | (1L << (COALESCE - 130)) | (1L << (COLUMN - 130)) | (1L << (COMMENT - 130)) | (1L << (COMMENTS - 130)) | (1L << (COMMIT - 130)) | (1L << (CONFIGURATION - 130)) | (1L << (COUNT - 130)) | (1L << (CUBE - 130)) | (1L << (DATA - 130)) | (1L << (DAY - 130)) | (1L << (DEC - 130)) | (1L << (DECADE - 130)) | (1L << (DICTIONARY - 130)) | (1L << (DOW - 130)) | (1L << (DOY - 130)) | (1L << (DROP - 130)) | (1L << (EPOCH - 130)) | (1L << (EVERY - 130)) | (1L << (EXISTS - 130)) | (1L << (EXTERNAL - 130)) | (1L << (EXTRACT - 130)) | (1L << (FAMILY - 130)) | (1L << (FILTER - 130)) | (1L << (FIRST - 130)) | (1L << (FORMAT - 130)) | (1L << (FUSION - 130)) | (1L << (GROUPING - 130)) | (1L << (HASH - 130)) | (1L << (INDEX - 130)) | (1L << (INSERT - 130)) | (1L << (INTERSECTION - 130)) | (1L << (ISODOW - 130)) | (1L << (ISOYEAR - 130)) | (1L << (LANGUAGE - 130)) | (1L << (LARGE - 130)) | (1L << (LAST - 130)) | (1L << (LESS - 130)) | (1L << (LIST - 130)) | (1L << (LOCATION - 130)) | (1L << (MATCH - 130)) | (1L << (MAX - 130)) | (1L << (MAXVALUE - 130)) | (1L << (MICROSECONDS - 130)) | (1L << (MILLENNIUM - 130)) | (1L << (MILLISECONDS - 130)) | (1L << (MIN - 130)) | (1L << (MINUTE - 130)) | (1L << (MONTH - 130)) | (1L << (NATIONAL - 130)) | (1L << (NULLIF - 130)) | (1L << (OBJECT - 130)) | (1L << (OPTION - 130)) | (1L << (OPTIONS - 130)) | (1L << (OVERWRITE - 130)) | (1L << (PARSER - 130)) | (1L << (PARTIAL - 130)) | (1L << (PARTITION - 130)) | (1L << (PARTITIONS - 130)) | (1L << (PRECISION - 130)) | (1L << (PUBLIC - 130)))) != 0) || ((((_la - 194)) & ~0x3f) == 0 && ((1L << (_la - 194)) & ((1L << (PURGE - 194)) | (1L << (QUARTER - 194)) | (1L << (RANGE - 194)) | (1L << (REGEXP - 194)) | (1L << (RLIKE - 194)) | (1L << (ROLLUP - 194)) | (1L << (SEARCH - 194)) | (1L << (SECOND - 194)) | (1L << (SERVER - 194)) | (1L << (SET - 194)) | (1L << (SIMILAR - 194)) | (1L << (SIMPLE - 194)) | (1L << (STORAGE - 194)) | (1L << (STDDEV_POP - 194)) | (1L << (STDDEV_SAMP - 194)) | (1L << (SUBPARTITION - 194)) | (1L << (SUM - 194)) | (1L << (TABLESPACE - 194)) | (1L << (TEMPLATE - 194)) | (1L << (THAN - 194)) | (1L << (TIMEZONE - 194)) | (1L << (TIMEZONE_HOUR - 194)) | (1L << (TIMEZONE_MINUTE - 194)) | (1L << (TRIM - 194)) | (1L << (TO - 194)) | (1L << (UNKNOWN - 194)) | (1L << (UNLOGGED - 194)) | (1L << (VALUES - 194)) | (1L << (VAR_SAMP - 194)) | (1L << (VAR_POP - 194)) | (1L << (VARYING - 194)) | (1L << (WEEK - 194)) | (1L << (WRAPPER - 194)) | (1L << (YEAR - 194)) | (1L << (ZONE - 194)) | (1L << (BOOLEAN - 194)) | (1L << (BOOL - 194)) | (1L << (BIT - 194)) | (1L << (VARBIT - 194)) | (1L << (INT1 - 194)) | (1L << (INT2 - 194)) | (1L << (INT4 - 194)) | (1L << (INT8 - 194)) | (1L << (TINYINT - 194)) | (1L << (SMALLINT - 194)) | (1L << (INT - 194)) | (1L << (INTEGER - 194)) | (1L << (BIGINT - 194)) | (1L << (FLOAT4 - 194)) | (1L << (FLOAT8 - 194)) | (1L << (REAL - 194)) | (1L << (FLOAT - 194)) | (1L << (DOUBLE - 194)) | (1L << (NUMERIC - 194)) | (1L << (DECIMAL - 194)) | (1L << (CHAR - 194)) | (1L << (VARCHAR - 194)) | (1L << (NCHAR - 194)) | (1L << (NVARCHAR - 194)) | (1L << (DATE - 194)) | (1L << (TIME - 194)))) != 0) || ((((_la - 258)) & ~0x3f) == 0 && ((1L << (_la - 258)) & ((1L << (TIMETZ - 258)) | (1L << (TIMESTAMP - 258)) | (1L << (TIMESTAMPTZ - 258)) | (1L << (TEXT - 258)) | (1L << (VARBINARY - 258)) | (1L << (BLOB - 258)) | (1L << (BYTEA - 258)) | (1L << (INET4 - 258)) | (1L << (LEFT_PAREN - 258)) | (1L << (QUOTE - 258)) | (1L << (NUMBER - 258)) | (1L << (REAL_NUMBER - 258)) | (1L << (Identifier - 258)) | (1L << (Character_String_Literal - 258)))) != 0)) {
						{
						setState(2538); ((Trim_operandsContext)_localctx).trim_character = character_value_expression();
						}
					}

					setState(2541); match(FROM);
					}
					break;
				}
				setState(2544); ((Trim_operandsContext)_localctx).trim_source = character_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2545); ((Trim_operandsContext)_localctx).trim_source = character_value_expression();
				setState(2546); match(COMMA);
				setState(2547); ((Trim_operandsContext)_localctx).trim_character = character_value_expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 238, RULE_trim_specification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2551);
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
		enterRule(_localctx, 240, RULE_boolean_value_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2553); or_predicate();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 242, RULE_or_predicate);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2555); and_predicate();
			setState(2560);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,357,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(2556); match(OR);
					setState(2557); or_predicate();
					}
					} 
				}
				setState(2562);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,357,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 244, RULE_and_predicate);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2563); boolean_factor();
			setState(2568);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,358,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(2564); match(AND);
					setState(2565); and_predicate();
					}
					} 
				}
				setState(2570);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,358,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 246, RULE_boolean_factor);
		try {
			setState(2574);
			switch ( getInterpreter().adaptivePredict(_input,359,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2571); boolean_test();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2572); match(NOT);
				setState(2573); boolean_test();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 248, RULE_boolean_test);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2576); boolean_primary();
			setState(2578);
			_la = _input.LA(1);
			if (_la==IS) {
				{
				setState(2577); is_clause();
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
		enterRule(_localctx, 250, RULE_is_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2580); match(IS);
			setState(2582);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(2581); match(NOT);
				}
			}

			setState(2584); ((Is_clauseContext)_localctx).t = truth_value();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 252, RULE_truth_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2586);
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
		enterRule(_localctx, 254, RULE_boolean_primary);
		try {
			setState(2590);
			switch ( getInterpreter().adaptivePredict(_input,362,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2588); predicate();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2589); boolean_predicand();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 256, RULE_boolean_predicand);
		try {
			setState(2594);
			switch ( getInterpreter().adaptivePredict(_input,363,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2592); parenthesized_boolean_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2593); nonparenthesized_value_expression_primary();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 258, RULE_parenthesized_boolean_value_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2596); match(LEFT_PAREN);
			setState(2597); boolean_value_expression();
			setState(2598); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 260, RULE_row_value_expression);
		try {
			setState(2602);
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
			case COUNT:
			case CUBE:
			case DATA:
			case DAY:
			case DEC:
			case DECADE:
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
			case INSERT:
			case INTERSECTION:
			case ISODOW:
			case ISOYEAR:
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
			case MINUTE:
			case MONTH:
			case NATIONAL:
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
			case SERVER:
			case SET:
			case SIMILAR:
			case SIMPLE:
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
			case WEEK:
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
				setState(2600); row_value_special_case();
				}
				break;
			case NULL:
				enterOuterAlt(_localctx, 2);
				{
				setState(2601); explicit_row_value_constructor();
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
		enterRule(_localctx, 262, RULE_row_value_special_case);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2604); nonparenthesized_value_expression_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 264, RULE_explicit_row_value_constructor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2606); match(NULL);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 266, RULE_row_value_predicand);
		try {
			setState(2610);
			switch ( getInterpreter().adaptivePredict(_input,365,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2608); row_value_special_case();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2609); row_value_constructor_predicand();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 268, RULE_row_value_constructor_predicand);
		try {
			setState(2614);
			switch ( getInterpreter().adaptivePredict(_input,366,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2612); common_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2613); boolean_predicand();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 270, RULE_table_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2616); from_clause();
			setState(2618);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(2617); where_clause();
				}
			}

			setState(2621);
			_la = _input.LA(1);
			if (_la==GROUP) {
				{
				setState(2620); groupby_clause();
				}
			}

			setState(2624);
			_la = _input.LA(1);
			if (_la==HAVING) {
				{
				setState(2623); having_clause();
				}
			}

			setState(2627);
			_la = _input.LA(1);
			if (_la==ORDER) {
				{
				setState(2626); orderby_clause();
				}
			}

			setState(2630);
			_la = _input.LA(1);
			if (_la==LIMIT) {
				{
				setState(2629); limit_clause();
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
		enterRule(_localctx, 272, RULE_from_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2632); match(FROM);
			setState(2633); table_reference_list();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 274, RULE_table_reference_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2635); table_reference();
			setState(2640);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2636); match(COMMA);
				setState(2637); table_reference();
				}
				}
				setState(2642);
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
		enterRule(_localctx, 276, RULE_table_reference);
		try {
			setState(2645);
			switch ( getInterpreter().adaptivePredict(_input,373,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2643); joined_table();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2644); table_primary();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 278, RULE_joined_table);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2647); table_primary();
			setState(2649); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(2648); joined_table_primary();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(2651); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,374,_ctx);
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
		enterRule(_localctx, 280, RULE_joined_table_primary);
		int _la;
		try {
			setState(2672);
			switch (_input.LA(1)) {
			case CROSS:
				enterOuterAlt(_localctx, 1);
				{
				setState(2653); match(CROSS);
				setState(2654); match(JOIN);
				setState(2655); ((Joined_table_primaryContext)_localctx).right = table_primary();
				}
				break;
			case FULL:
			case INNER:
			case JOIN:
			case LEFT:
			case RIGHT:
				enterOuterAlt(_localctx, 2);
				{
				setState(2657);
				_la = _input.LA(1);
				if (((((_la - 42)) & ~0x3f) == 0 && ((1L << (_la - 42)) & ((1L << (FULL - 42)) | (1L << (INNER - 42)) | (1L << (LEFT - 42)) | (1L << (RIGHT - 42)))) != 0)) {
					{
					setState(2656); ((Joined_table_primaryContext)_localctx).t = join_type();
					}
				}

				setState(2659); match(JOIN);
				setState(2660); ((Joined_table_primaryContext)_localctx).right = table_primary();
				setState(2661); ((Joined_table_primaryContext)_localctx).s = join_specification();
				}
				break;
			case NATURAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(2663); match(NATURAL);
				setState(2665);
				_la = _input.LA(1);
				if (((((_la - 42)) & ~0x3f) == 0 && ((1L << (_la - 42)) & ((1L << (FULL - 42)) | (1L << (INNER - 42)) | (1L << (LEFT - 42)) | (1L << (RIGHT - 42)))) != 0)) {
					{
					setState(2664); ((Joined_table_primaryContext)_localctx).t = join_type();
					}
				}

				setState(2667); match(JOIN);
				setState(2668); ((Joined_table_primaryContext)_localctx).right = table_primary();
				}
				break;
			case UNION:
				enterOuterAlt(_localctx, 4);
				{
				setState(2669); match(UNION);
				setState(2670); match(JOIN);
				setState(2671); ((Joined_table_primaryContext)_localctx).right = table_primary();
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
		enterRule(_localctx, 282, RULE_cross_join);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2674); match(CROSS);
			setState(2675); match(JOIN);
			setState(2676); ((Cross_joinContext)_localctx).r = table_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 284, RULE_qualified_join);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2679);
			_la = _input.LA(1);
			if (((((_la - 42)) & ~0x3f) == 0 && ((1L << (_la - 42)) & ((1L << (FULL - 42)) | (1L << (INNER - 42)) | (1L << (LEFT - 42)) | (1L << (RIGHT - 42)))) != 0)) {
				{
				setState(2678); ((Qualified_joinContext)_localctx).t = join_type();
				}
			}

			setState(2681); match(JOIN);
			setState(2682); ((Qualified_joinContext)_localctx).r = table_primary();
			setState(2683); ((Qualified_joinContext)_localctx).s = join_specification();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 286, RULE_natural_join);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2685); match(NATURAL);
			setState(2687);
			_la = _input.LA(1);
			if (((((_la - 42)) & ~0x3f) == 0 && ((1L << (_la - 42)) & ((1L << (FULL - 42)) | (1L << (INNER - 42)) | (1L << (LEFT - 42)) | (1L << (RIGHT - 42)))) != 0)) {
				{
				setState(2686); ((Natural_joinContext)_localctx).t = join_type();
				}
			}

			setState(2689); match(JOIN);
			setState(2690); ((Natural_joinContext)_localctx).r = table_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 288, RULE_union_join);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2692); match(UNION);
			setState(2693); match(JOIN);
			setState(2694); ((Union_joinContext)_localctx).r = table_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 290, RULE_join_type);
		try {
			setState(2698);
			switch (_input.LA(1)) {
			case INNER:
				enterOuterAlt(_localctx, 1);
				{
				setState(2696); match(INNER);
				}
				break;
			case FULL:
			case LEFT:
			case RIGHT:
				enterOuterAlt(_localctx, 2);
				{
				setState(2697); ((Join_typeContext)_localctx).t = outer_join_type();
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
		enterRule(_localctx, 292, RULE_outer_join_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2700); outer_join_type_part2();
			setState(2702);
			_la = _input.LA(1);
			if (_la==OUTER) {
				{
				setState(2701); match(OUTER);
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
		enterRule(_localctx, 294, RULE_outer_join_type_part2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2704);
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
		enterRule(_localctx, 296, RULE_join_specification);
		try {
			setState(2708);
			switch (_input.LA(1)) {
			case ON:
				enterOuterAlt(_localctx, 1);
				{
				setState(2706); join_condition();
				}
				break;
			case USING:
				enterOuterAlt(_localctx, 2);
				{
				setState(2707); named_columns_join();
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
		enterRule(_localctx, 298, RULE_join_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2710); match(ON);
			setState(2711); search_condition();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 300, RULE_named_columns_join);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2713); match(USING);
			setState(2714); match(LEFT_PAREN);
			setState(2715); ((Named_columns_joinContext)_localctx).f = column_reference_list();
			setState(2716); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 302, RULE_table_primary);
		int _la;
		try {
			setState(2742);
			switch (_input.LA(1)) {
			case ADMIN:
			case AVG:
			case BETWEEN:
			case BY:
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
			case COUNT:
			case CUBE:
			case DATA:
			case DAY:
			case DEC:
			case DECADE:
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
			case INSERT:
			case INTERSECTION:
			case ISODOW:
			case ISOYEAR:
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
			case MINUTE:
			case MONTH:
			case NATIONAL:
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
			case SERVER:
			case SET:
			case SIMILAR:
			case SIMPLE:
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
			case WEEK:
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
				setState(2718); table_or_query_name();
				setState(2723);
				switch ( getInterpreter().adaptivePredict(_input,384,_ctx) ) {
				case 1:
					{
					setState(2720);
					_la = _input.LA(1);
					if (_la==AS) {
						{
						setState(2719); match(AS);
						}
					}

					setState(2722); ((Table_primaryContext)_localctx).alias = identifier();
					}
					break;
				}
				setState(2729);
				switch ( getInterpreter().adaptivePredict(_input,385,_ctx) ) {
				case 1:
					{
					setState(2725); match(LEFT_PAREN);
					setState(2726); column_name_list();
					setState(2727); match(RIGHT_PAREN);
					}
					break;
				}
				}
				break;
			case LEFT_PAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(2731); derived_table();
				setState(2733);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(2732); match(AS);
					}
				}

				setState(2735); ((Table_primaryContext)_localctx).name = identifier();
				setState(2740);
				switch ( getInterpreter().adaptivePredict(_input,387,_ctx) ) {
				case 1:
					{
					setState(2736); match(LEFT_PAREN);
					setState(2737); column_name_list();
					setState(2738); match(RIGHT_PAREN);
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
		enterRule(_localctx, 304, RULE_column_name_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2744); identifier();
			setState(2749);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2745); match(COMMA);
				setState(2746); identifier();
				}
				}
				setState(2751);
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
		enterRule(_localctx, 306, RULE_derived_table);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2752); table_subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 308, RULE_where_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2754); match(WHERE);
			setState(2755); search_condition();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 310, RULE_search_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2757); value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 312, RULE_groupby_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2759); match(GROUP);
			setState(2760); match(BY);
			setState(2761); ((Groupby_clauseContext)_localctx).g = grouping_element_list();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 314, RULE_grouping_element_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2763); grouping_element();
			setState(2768);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2764); match(COMMA);
				setState(2765); grouping_element();
				}
				}
				setState(2770);
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
		enterRule(_localctx, 316, RULE_grouping_element);
		try {
			setState(2775);
			switch ( getInterpreter().adaptivePredict(_input,391,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2771); rollup_list();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2772); cube_list();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2773); empty_grouping_set();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2774); ordinary_grouping_set();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 318, RULE_ordinary_grouping_set);
		try {
			setState(2782);
			switch ( getInterpreter().adaptivePredict(_input,392,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2777); row_value_predicand();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2778); match(LEFT_PAREN);
				setState(2779); row_value_predicand_list();
				setState(2780); match(RIGHT_PAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 320, RULE_ordinary_grouping_set_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2784); ordinary_grouping_set();
			setState(2789);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2785); match(COMMA);
				setState(2786); ordinary_grouping_set();
				}
				}
				setState(2791);
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
		enterRule(_localctx, 322, RULE_rollup_list);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2792); match(ROLLUP);
			setState(2793); match(LEFT_PAREN);
			setState(2794); ((Rollup_listContext)_localctx).c = ordinary_grouping_set_list();
			setState(2795); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 324, RULE_cube_list);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2797); match(CUBE);
			setState(2798); match(LEFT_PAREN);
			setState(2799); ((Cube_listContext)_localctx).c = ordinary_grouping_set_list();
			setState(2800); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 326, RULE_empty_grouping_set);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2802); match(LEFT_PAREN);
			setState(2803); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 328, RULE_having_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2805); match(HAVING);
			setState(2806); boolean_value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 330, RULE_row_value_predicand_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2808); row_value_predicand();
			setState(2813);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2809); match(COMMA);
				setState(2810); row_value_predicand();
				}
				}
				setState(2815);
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
		enterRule(_localctx, 332, RULE_query_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2816); query_expression_body();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 334, RULE_query_expression_body);
		try {
			setState(2820);
			switch ( getInterpreter().adaptivePredict(_input,395,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2818); non_join_query_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2819); joined_table();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 336, RULE_non_join_query_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2830);
			switch ( getInterpreter().adaptivePredict(_input,397,_ctx) ) {
			case 1:
				{
				setState(2822); non_join_query_term();
				}
				break;
			case 2:
				{
				setState(2823); joined_table();
				setState(2824);
				_la = _input.LA(1);
				if ( !(_la==EXCEPT || _la==UNION) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(2826);
				_la = _input.LA(1);
				if (_la==ALL || _la==DISTINCT) {
					{
					setState(2825);
					_la = _input.LA(1);
					if ( !(_la==ALL || _la==DISTINCT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(2828); query_term();
				}
				break;
			}
			setState(2839);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==EXCEPT || _la==UNION) {
				{
				{
				setState(2832);
				_la = _input.LA(1);
				if ( !(_la==EXCEPT || _la==UNION) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(2834);
				_la = _input.LA(1);
				if (_la==ALL || _la==DISTINCT) {
					{
					setState(2833);
					_la = _input.LA(1);
					if ( !(_la==ALL || _la==DISTINCT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(2836); query_term();
				}
				}
				setState(2841);
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
		enterRule(_localctx, 338, RULE_query_term);
		try {
			setState(2844);
			switch ( getInterpreter().adaptivePredict(_input,400,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2842); non_join_query_term();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2843); joined_table();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 340, RULE_non_join_query_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2854);
			switch ( getInterpreter().adaptivePredict(_input,402,_ctx) ) {
			case 1:
				{
				setState(2846); non_join_query_primary();
				}
				break;
			case 2:
				{
				setState(2847); joined_table();
				setState(2848); match(INTERSECT);
				setState(2850);
				_la = _input.LA(1);
				if (_la==ALL || _la==DISTINCT) {
					{
					setState(2849);
					_la = _input.LA(1);
					if ( !(_la==ALL || _la==DISTINCT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(2852); query_primary();
				}
				break;
			}
			setState(2863);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==INTERSECT) {
				{
				{
				setState(2856); match(INTERSECT);
				setState(2858);
				_la = _input.LA(1);
				if (_la==ALL || _la==DISTINCT) {
					{
					setState(2857);
					_la = _input.LA(1);
					if ( !(_la==ALL || _la==DISTINCT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(2860); query_primary();
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
		enterRule(_localctx, 342, RULE_query_primary);
		try {
			setState(2868);
			switch ( getInterpreter().adaptivePredict(_input,405,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2866); non_join_query_primary();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2867); joined_table();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 344, RULE_non_join_query_primary);
		try {
			setState(2875);
			switch (_input.LA(1)) {
			case SELECT:
			case TABLE:
				enterOuterAlt(_localctx, 1);
				{
				setState(2870); simple_table();
				}
				break;
			case LEFT_PAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(2871); match(LEFT_PAREN);
				setState(2872); non_join_query_expression();
				setState(2873); match(RIGHT_PAREN);
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
		enterRule(_localctx, 346, RULE_simple_table);
		try {
			setState(2879);
			switch (_input.LA(1)) {
			case SELECT:
				enterOuterAlt(_localctx, 1);
				{
				setState(2877); query_specification();
				}
				break;
			case TABLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(2878); explicit_table();
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
		enterRule(_localctx, 348, RULE_explicit_table);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2881); match(TABLE);
			setState(2882); table_or_query_name();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 350, RULE_table_or_query_name);
		try {
			setState(2886);
			switch ( getInterpreter().adaptivePredict(_input,408,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2884); schema_qualified_name();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2885); identifier();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 352, RULE_schema_qualified_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2888); identifier();
			setState(2895);
			_la = _input.LA(1);
			if (_la==DOT) {
				{
				setState(2889); match(DOT);
				setState(2890); identifier();
				setState(2893);
				_la = _input.LA(1);
				if (_la==DOT) {
					{
					setState(2891); match(DOT);
					setState(2892); identifier();
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
		enterRule(_localctx, 354, RULE_query_specification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2897); match(SELECT);
			setState(2899);
			_la = _input.LA(1);
			if (_la==ALL || _la==DISTINCT) {
				{
				setState(2898); set_qualifier();
				}
			}

			setState(2901); select_list();
			setState(2903);
			_la = _input.LA(1);
			if (_la==FROM) {
				{
				setState(2902); table_expression();
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
		enterRule(_localctx, 356, RULE_select_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2905); select_sublist();
			setState(2910);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2906); match(COMMA);
				setState(2907); select_sublist();
				}
				}
				setState(2912);
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
		enterRule(_localctx, 358, RULE_select_sublist);
		try {
			setState(2915);
			switch ( getInterpreter().adaptivePredict(_input,414,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2913); derived_column();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2914); qualified_asterisk();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 360, RULE_derived_column);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2917); value_expression();
			setState(2919);
			switch ( getInterpreter().adaptivePredict(_input,415,_ctx) ) {
			case 1:
				{
				setState(2918); as_clause();
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
		enterRule(_localctx, 362, RULE_qualified_asterisk);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2923);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(2921); ((Qualified_asteriskContext)_localctx).tb_name = match(Identifier);
				setState(2922); match(DOT);
				}
			}

			setState(2925); match(MULTIPLY);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 364, RULE_set_qualifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2927);
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
		enterRule(_localctx, 366, RULE_column_reference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2932);
			switch ( getInterpreter().adaptivePredict(_input,417,_ctx) ) {
			case 1:
				{
				setState(2929); ((Column_referenceContext)_localctx).tb_name = identifier();
				setState(2930); match(DOT);
				}
				break;
			}
			setState(2934); ((Column_referenceContext)_localctx).name = identifier();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 368, RULE_as_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2937);
			_la = _input.LA(1);
			if (_la==AS) {
				{
				setState(2936); match(AS);
				}
			}

			setState(2939); identifier();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 370, RULE_column_reference_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2941); column_reference();
			setState(2946);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2942); match(COMMA);
				setState(2943); column_reference();
				}
				}
				setState(2948);
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
		enterRule(_localctx, 372, RULE_scalar_subquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2949); subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 374, RULE_row_subquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2951); subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 376, RULE_table_subquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2953); subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 378, RULE_subquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2955); match(LEFT_PAREN);
			setState(2956); query_expression();
			setState(2957); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 380, RULE_predicate);
		try {
			setState(2965);
			switch ( getInterpreter().adaptivePredict(_input,420,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2959); comparison_predicate();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2960); between_predicate();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2961); in_predicate();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2962); pattern_matching_predicate();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2963); null_predicate();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2964); exists_predicate();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 382, RULE_comparison_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2967); ((Comparison_predicateContext)_localctx).left = row_value_predicand();
			setState(2968); ((Comparison_predicateContext)_localctx).c = comp_op();
			setState(2969); ((Comparison_predicateContext)_localctx).right = row_value_predicand();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 384, RULE_comp_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2971);
			_la = _input.LA(1);
			if ( !(((((_la - 273)) & ~0x3f) == 0 && ((1L << (_la - 273)) & ((1L << (EQUAL - 273)) | (1L << (NOT_EQUAL - 273)) | (1L << (LTH - 273)) | (1L << (LEQ - 273)) | (1L << (GTH - 273)) | (1L << (GEQ - 273)))) != 0)) ) {
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
		enterRule(_localctx, 386, RULE_between_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2973); ((Between_predicateContext)_localctx).predicand = row_value_predicand();
			setState(2974); between_predicate_part_2();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 388, RULE_between_predicate_part_2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2977);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(2976); match(NOT);
				}
			}

			setState(2979); match(BETWEEN);
			setState(2981);
			_la = _input.LA(1);
			if (_la==ASYMMETRIC || _la==SYMMETRIC) {
				{
				setState(2980);
				_la = _input.LA(1);
				if ( !(_la==ASYMMETRIC || _la==SYMMETRIC) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(2983); ((Between_predicate_part_2Context)_localctx).begin = row_value_predicand();
			setState(2984); match(AND);
			setState(2985); ((Between_predicate_part_2Context)_localctx).end = row_value_predicand();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 390, RULE_in_predicate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2987); ((In_predicateContext)_localctx).predicand = numeric_value_expression();
			setState(2989);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(2988); match(NOT);
				}
			}

			setState(2991); match(IN);
			setState(2992); in_predicate_value();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 392, RULE_in_predicate_value);
		try {
			setState(2999);
			switch ( getInterpreter().adaptivePredict(_input,424,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2994); table_subquery();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2995); match(LEFT_PAREN);
				setState(2996); in_value_list();
				setState(2997); match(RIGHT_PAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 394, RULE_in_value_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3001); row_value_expression();
			setState(3006);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3002); match(COMMA);
				setState(3003); row_value_expression();
				}
				}
				setState(3008);
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
		enterRule(_localctx, 396, RULE_pattern_matching_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3009); ((Pattern_matching_predicateContext)_localctx).f = row_value_predicand();
			setState(3010); pattern_matcher();
			setState(3011); ((Pattern_matching_predicateContext)_localctx).s = match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 398, RULE_pattern_matcher);
		int _la;
		try {
			setState(3018);
			switch (_input.LA(1)) {
			case ILIKE:
			case LIKE:
			case NOT:
			case REGEXP:
			case RLIKE:
			case SIMILAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(3014);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(3013); match(NOT);
					}
				}

				setState(3016); negativable_matcher();
				}
				break;
			case Similar_To:
			case Not_Similar_To:
			case Similar_To_Case_Insensitive:
			case Not_Similar_To_Case_Insensitive:
				enterOuterAlt(_localctx, 2);
				{
				setState(3017); regex_matcher();
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
		enterRule(_localctx, 400, RULE_negativable_matcher);
		try {
			setState(3026);
			switch (_input.LA(1)) {
			case LIKE:
				enterOuterAlt(_localctx, 1);
				{
				setState(3020); match(LIKE);
				}
				break;
			case ILIKE:
				enterOuterAlt(_localctx, 2);
				{
				setState(3021); match(ILIKE);
				}
				break;
			case SIMILAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(3022); match(SIMILAR);
				setState(3023); match(TO);
				}
				break;
			case REGEXP:
				enterOuterAlt(_localctx, 4);
				{
				setState(3024); match(REGEXP);
				}
				break;
			case RLIKE:
				enterOuterAlt(_localctx, 5);
				{
				setState(3025); match(RLIKE);
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
		enterRule(_localctx, 402, RULE_regex_matcher);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3028);
			_la = _input.LA(1);
			if ( !(((((_la - 267)) & ~0x3f) == 0 && ((1L << (_la - 267)) & ((1L << (Similar_To - 267)) | (1L << (Not_Similar_To - 267)) | (1L << (Similar_To_Case_Insensitive - 267)) | (1L << (Not_Similar_To_Case_Insensitive - 267)))) != 0)) ) {
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
		enterRule(_localctx, 404, RULE_null_predicate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3030); ((Null_predicateContext)_localctx).predicand = row_value_predicand();
			setState(3031); match(IS);
			setState(3033);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(3032); ((Null_predicateContext)_localctx).n = match(NOT);
				}
			}

			setState(3035); match(NULL);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 406, RULE_quantified_comparison_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3037); ((Quantified_comparison_predicateContext)_localctx).l = numeric_value_expression();
			setState(3038); ((Quantified_comparison_predicateContext)_localctx).c = comp_op();
			setState(3039); ((Quantified_comparison_predicateContext)_localctx).q = quantifier();
			setState(3040); ((Quantified_comparison_predicateContext)_localctx).s = table_subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 408, RULE_quantifier);
		try {
			setState(3044);
			switch (_input.LA(1)) {
			case ALL:
				enterOuterAlt(_localctx, 1);
				{
				setState(3042); all();
				}
				break;
			case ANY:
			case SOME:
				enterOuterAlt(_localctx, 2);
				{
				setState(3043); some();
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
		enterRule(_localctx, 410, RULE_all);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3046); match(ALL);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 412, RULE_some);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3048);
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
		enterRule(_localctx, 414, RULE_exists_predicate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3051);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(3050); match(NOT);
				}
			}

			setState(3053); match(EXISTS);
			setState(3054); ((Exists_predicateContext)_localctx).s = table_subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 416, RULE_unique_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3056); match(UNIQUE);
			setState(3057); ((Unique_predicateContext)_localctx).s = table_subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 418, RULE_primary_datetime_field);
		try {
			setState(3061);
			switch (_input.LA(1)) {
			case DAY:
			case HOUR:
			case MINUTE:
			case MONTH:
			case YEAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(3059); non_second_primary_datetime_field();
				}
				break;
			case SECOND:
				enterOuterAlt(_localctx, 2);
				{
				setState(3060); match(SECOND);
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
		enterRule(_localctx, 420, RULE_non_second_primary_datetime_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3063);
			_la = _input.LA(1);
			if ( !(((((_la - 141)) & ~0x3f) == 0 && ((1L << (_la - 141)) & ((1L << (DAY - 141)) | (1L << (HOUR - 141)) | (1L << (MINUTE - 141)) | (1L << (MONTH - 141)))) != 0) || _la==YEAR) ) {
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
		enterRule(_localctx, 422, RULE_extended_datetime_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3065);
			_la = _input.LA(1);
			if ( !(((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (CENTURY - 128)) | (1L << (DECADE - 128)) | (1L << (DOW - 128)) | (1L << (DOY - 128)) | (1L << (EPOCH - 128)) | (1L << (ISODOW - 128)) | (1L << (ISOYEAR - 128)) | (1L << (MICROSECONDS - 128)) | (1L << (MILLENNIUM - 128)) | (1L << (MILLISECONDS - 128)))) != 0) || _la==QUARTER || _la==WEEK) ) {
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
		enterRule(_localctx, 424, RULE_routine_invocation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3067); function_name();
			setState(3068); match(LEFT_PAREN);
			setState(3070);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ANY) | (1L << CASE) | (1L << CAST) | (1L << FALSE))) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (LEFT - 66)) | (1L << (NOT - 66)) | (1L << (NULL - 66)) | (1L << (RIGHT - 66)) | (1L << (SOME - 66)) | (1L << (TRUE - 66)) | (1L << (ADMIN - 66)) | (1L << (AVG - 66)) | (1L << (BETWEEN - 66)) | (1L << (BY - 66)) | (1L << (CLASS - 66)) | (1L << (CENTURY - 66)) | (1L << (CHARACTER - 66)))) != 0) || ((((_la - 130)) & ~0x3f) == 0 && ((1L << (_la - 130)) & ((1L << (CHECK - 130)) | (1L << (COLLECT - 130)) | (1L << (COALESCE - 130)) | (1L << (COLUMN - 130)) | (1L << (COMMENT - 130)) | (1L << (COMMENTS - 130)) | (1L << (COMMIT - 130)) | (1L << (CONFIGURATION - 130)) | (1L << (COUNT - 130)) | (1L << (CUBE - 130)) | (1L << (DATA - 130)) | (1L << (DAY - 130)) | (1L << (DEC - 130)) | (1L << (DECADE - 130)) | (1L << (DICTIONARY - 130)) | (1L << (DOW - 130)) | (1L << (DOY - 130)) | (1L << (DROP - 130)) | (1L << (EPOCH - 130)) | (1L << (EVERY - 130)) | (1L << (EXISTS - 130)) | (1L << (EXTERNAL - 130)) | (1L << (EXTRACT - 130)) | (1L << (FAMILY - 130)) | (1L << (FILTER - 130)) | (1L << (FIRST - 130)) | (1L << (FORMAT - 130)) | (1L << (FUSION - 130)) | (1L << (GROUPING - 130)) | (1L << (HASH - 130)) | (1L << (INDEX - 130)) | (1L << (INSERT - 130)) | (1L << (INTERSECTION - 130)) | (1L << (ISODOW - 130)) | (1L << (ISOYEAR - 130)) | (1L << (LANGUAGE - 130)) | (1L << (LARGE - 130)) | (1L << (LAST - 130)) | (1L << (LESS - 130)) | (1L << (LIST - 130)) | (1L << (LOCATION - 130)) | (1L << (MATCH - 130)) | (1L << (MAX - 130)) | (1L << (MAXVALUE - 130)) | (1L << (MICROSECONDS - 130)) | (1L << (MILLENNIUM - 130)) | (1L << (MILLISECONDS - 130)) | (1L << (MIN - 130)) | (1L << (MINUTE - 130)) | (1L << (MONTH - 130)) | (1L << (NATIONAL - 130)) | (1L << (NULLIF - 130)) | (1L << (OBJECT - 130)) | (1L << (OPTION - 130)) | (1L << (OPTIONS - 130)) | (1L << (OVERWRITE - 130)) | (1L << (PARSER - 130)) | (1L << (PARTIAL - 130)) | (1L << (PARTITION - 130)) | (1L << (PARTITIONS - 130)) | (1L << (PRECISION - 130)) | (1L << (PUBLIC - 130)))) != 0) || ((((_la - 194)) & ~0x3f) == 0 && ((1L << (_la - 194)) & ((1L << (PURGE - 194)) | (1L << (QUARTER - 194)) | (1L << (RANGE - 194)) | (1L << (REGEXP - 194)) | (1L << (RLIKE - 194)) | (1L << (ROLLUP - 194)) | (1L << (SEARCH - 194)) | (1L << (SECOND - 194)) | (1L << (SERVER - 194)) | (1L << (SET - 194)) | (1L << (SIMILAR - 194)) | (1L << (SIMPLE - 194)) | (1L << (STORAGE - 194)) | (1L << (STDDEV_POP - 194)) | (1L << (STDDEV_SAMP - 194)) | (1L << (SUBPARTITION - 194)) | (1L << (SUM - 194)) | (1L << (TABLESPACE - 194)) | (1L << (TEMPLATE - 194)) | (1L << (THAN - 194)) | (1L << (TIMEZONE - 194)) | (1L << (TIMEZONE_HOUR - 194)) | (1L << (TIMEZONE_MINUTE - 194)) | (1L << (TRIM - 194)) | (1L << (TO - 194)) | (1L << (UNKNOWN - 194)) | (1L << (UNLOGGED - 194)) | (1L << (VALUES - 194)) | (1L << (VAR_SAMP - 194)) | (1L << (VAR_POP - 194)) | (1L << (VARYING - 194)) | (1L << (WEEK - 194)) | (1L << (WRAPPER - 194)) | (1L << (YEAR - 194)) | (1L << (ZONE - 194)) | (1L << (BOOLEAN - 194)) | (1L << (BOOL - 194)) | (1L << (BIT - 194)) | (1L << (VARBIT - 194)) | (1L << (INT1 - 194)) | (1L << (INT2 - 194)) | (1L << (INT4 - 194)) | (1L << (INT8 - 194)) | (1L << (TINYINT - 194)) | (1L << (SMALLINT - 194)) | (1L << (INT - 194)) | (1L << (INTEGER - 194)) | (1L << (BIGINT - 194)) | (1L << (FLOAT4 - 194)) | (1L << (FLOAT8 - 194)) | (1L << (REAL - 194)) | (1L << (FLOAT - 194)) | (1L << (DOUBLE - 194)) | (1L << (NUMERIC - 194)) | (1L << (DECIMAL - 194)) | (1L << (CHAR - 194)) | (1L << (VARCHAR - 194)) | (1L << (NCHAR - 194)) | (1L << (NVARCHAR - 194)) | (1L << (DATE - 194)) | (1L << (TIME - 194)))) != 0) || ((((_la - 258)) & ~0x3f) == 0 && ((1L << (_la - 258)) & ((1L << (TIMETZ - 258)) | (1L << (TIMESTAMP - 258)) | (1L << (TIMESTAMPTZ - 258)) | (1L << (TEXT - 258)) | (1L << (VARBINARY - 258)) | (1L << (BLOB - 258)) | (1L << (BYTEA - 258)) | (1L << (INET4 - 258)) | (1L << (LEFT_PAREN - 258)) | (1L << (PLUS - 258)) | (1L << (MINUS - 258)) | (1L << (QUOTE - 258)) | (1L << (NUMBER - 258)) | (1L << (REAL_NUMBER - 258)) | (1L << (Identifier - 258)) | (1L << (Character_String_Literal - 258)))) != 0)) {
				{
				setState(3069); sql_argument_list();
				}
			}

			setState(3072); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 426, RULE_function_names_for_reserved_words);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3074);
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
		enterRule(_localctx, 428, RULE_function_name);
		try {
			setState(3078);
			switch (_input.LA(1)) {
			case ADMIN:
			case AVG:
			case BETWEEN:
			case BY:
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
			case COUNT:
			case CUBE:
			case DATA:
			case DAY:
			case DEC:
			case DECADE:
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
			case INSERT:
			case INTERSECTION:
			case ISODOW:
			case ISOYEAR:
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
			case MINUTE:
			case MONTH:
			case NATIONAL:
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
			case SERVER:
			case SET:
			case SIMILAR:
			case SIMPLE:
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
			case WEEK:
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
				setState(3076); identifier();
				}
				break;
			case LEFT:
			case RIGHT:
				enterOuterAlt(_localctx, 2);
				{
				setState(3077); function_names_for_reserved_words();
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
		enterRule(_localctx, 430, RULE_sql_argument_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3080); value_expression();
			setState(3085);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3081); match(COMMA);
				setState(3082); value_expression();
				}
				}
				setState(3087);
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
		enterRule(_localctx, 432, RULE_orderby_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3088); match(ORDER);
			setState(3089); match(BY);
			setState(3090); sort_specifier_list();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 434, RULE_sort_specifier_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3092); sort_specifier();
			setState(3097);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3093); match(COMMA);
				setState(3094); sort_specifier();
				}
				}
				setState(3099);
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
		enterRule(_localctx, 436, RULE_sort_specifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3100); ((Sort_specifierContext)_localctx).key = row_value_predicand();
			setState(3102);
			_la = _input.LA(1);
			if (_la==ASC || _la==DESC) {
				{
				setState(3101); ((Sort_specifierContext)_localctx).order = order_specification();
				}
			}

			setState(3105);
			_la = _input.LA(1);
			if (_la==NULL) {
				{
				setState(3104); ((Sort_specifierContext)_localctx).null_order = null_ordering();
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
		enterRule(_localctx, 438, RULE_order_specification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3107);
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
		enterRule(_localctx, 440, RULE_limit_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3109); match(LIMIT);
			setState(3110); ((Limit_clauseContext)_localctx).e = numeric_value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 442, RULE_null_ordering);
		try {
			setState(3116);
			switch ( getInterpreter().adaptivePredict(_input,439,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3112); match(NULL);
				setState(3113); match(FIRST);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3114); match(NULL);
				setState(3115); match(LAST);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 444, RULE_insert_statement);
		int _la;
		try {
			setState(3147);
			switch ( getInterpreter().adaptivePredict(_input,445,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3118); match(INSERT);
				setState(3120);
				_la = _input.LA(1);
				if (_la==OVERWRITE) {
					{
					setState(3119); match(OVERWRITE);
					}
				}

				setState(3122); match(INTO);
				setState(3123); schema_qualified_name();
				setState(3128);
				switch ( getInterpreter().adaptivePredict(_input,441,_ctx) ) {
				case 1:
					{
					setState(3124); match(LEFT_PAREN);
					setState(3125); column_name_list();
					setState(3126); match(RIGHT_PAREN);
					}
					break;
				}
				setState(3130); query_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3132); match(INSERT);
				setState(3134);
				_la = _input.LA(1);
				if (_la==OVERWRITE) {
					{
					setState(3133); match(OVERWRITE);
					}
				}

				setState(3136); match(INTO);
				setState(3137); match(LOCATION);
				setState(3138); ((Insert_statementContext)_localctx).path = match(Character_String_Literal);
				setState(3144);
				_la = _input.LA(1);
				if (_la==USING) {
					{
					setState(3139); match(USING);
					setState(3140); ((Insert_statementContext)_localctx).file_type = identifier();
					setState(3142);
					_la = _input.LA(1);
					if (_la==WITH) {
						{
						setState(3141); param_clause();
						}
					}

					}
				}

				setState(3146); query_expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\u0131\u0c50\4\2\t"+
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
		"\t\u00df\4\u00e0\t\u00e0\3\2\3\2\5\2\u01c3\n\2\6\2\u01c5\n\2\r\2\16\2"+
		"\u01c6\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\u01d5\n\3\3"+
		"\4\3\4\3\5\3\5\3\6\3\6\5\6\u01dd\n\6\3\7\3\7\5\7\u01e1\n\7\3\7\3\7\3\7"+
		"\3\7\3\7\5\7\u01e8\n\7\3\7\3\7\3\7\3\7\5\7\u01ee\n\7\3\b\3\b\3\b\3\b\3"+
		"\b\5\b\u01f5\n\b\3\b\3\b\5\b\u01f9\n\b\3\b\3\b\5\b\u01fd\n\b\3\b\3\b\5"+
		"\b\u0201\n\b\3\b\3\b\5\b\u0205\n\b\3\t\3\t\5\t\u0209\n\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\5\t\u0213\n\t\3\t\5\t\u0216\n\t\6\t\u0218\n\t\r\t\16"+
		"\t\u0219\3\t\3\t\5\t\u021e\n\t\3\t\3\t\3\t\3\t\3\t\5\t\u0225\n\t\3\t\5"+
		"\t\u0228\n\t\6\t\u022a\n\t\r\t\16\t\u022b\5\t\u022e\n\t\3\n\3\n\5\n\u0232"+
		"\n\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u023a\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\5\n\u0243\n\n\6\n\u0245\n\n\r\n\16\n\u0246\5\n\u0249\n\n\5\n\u024b\n"+
		"\n\3\n\3\n\3\n\3\n\5\n\u0251\n\n\3\n\3\n\3\n\5\n\u0256\n\n\3\n\3\n\3\n"+
		"\3\n\5\n\u025c\n\n\3\n\3\n\5\n\u0260\n\n\3\n\3\n\5\n\u0264\n\n\3\n\3\n"+
		"\5\n\u0268\n\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u0270\n\n\5\n\u0272\n\n\3\n"+
		"\3\n\3\13\3\13\3\13\3\13\5\13\u027a\n\13\3\13\6\13\u027d\n\13\r\13\16"+
		"\13\u027e\3\13\3\13\5\13\u0283\n\13\5\13\u0285\n\13\3\13\3\13\5\13\u0289"+
		"\n\13\3\13\6\13\u028c\n\13\r\13\16\13\u028d\3\13\3\13\3\13\3\13\3\13\6"+
		"\13\u0295\n\13\r\13\16\13\u0296\5\13\u0299\n\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\5\13\u02a1\n\13\3\13\3\13\3\13\3\13\5\13\u02a7\n\13\6\13\u02a9"+
		"\n\13\r\13\16\13\u02aa\3\13\3\13\6\13\u02af\n\13\r\13\16\13\u02b0\3\13"+
		"\3\13\5\13\u02b5\n\13\3\13\3\13\3\13\5\13\u02ba\n\13\6\13\u02bc\n\13\r"+
		"\13\16\13\u02bd\3\13\3\13\5\13\u02c2\n\13\3\13\3\13\5\13\u02c6\n\13\3"+
		"\13\3\13\5\13\u02ca\n\13\6\13\u02cc\n\13\r\13\16\13\u02cd\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\5\13\u02d6\n\13\3\13\6\13\u02d9\n\13\r\13\16\13\u02da"+
		"\3\13\3\13\5\13\u02df\n\13\5\13\u02e1\n\13\3\13\3\13\3\13\3\13\5\13\u02e7"+
		"\n\13\6\13\u02e9\n\13\r\13\16\13\u02ea\3\13\3\13\3\13\3\13\3\13\3\13\5"+
		"\13\u02f3\n\13\6\13\u02f5\n\13\r\13\16\13\u02f6\5\13\u02f9\n\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\5\13\u0301\n\13\3\13\6\13\u0304\n\13\r\13\16\13"+
		"\u0305\3\13\3\13\5\13\u030a\n\13\5\13\u030c\n\13\3\13\3\13\3\13\3\13\5"+
		"\13\u0312\n\13\6\13\u0314\n\13\r\13\16\13\u0315\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\5\13\u031e\n\13\3\13\3\13\3\13\5\13\u0323\n\13\5\13\u0325\n\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u032d\n\13\6\13\u032f\n\13\r\13\16"+
		"\13\u0330\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u0339\n\13\3\13\3\13\3\13"+
		"\5\13\u033e\n\13\5\13\u0340\n\13\3\13\3\13\3\13\3\13\3\13\5\13\u0347\n"+
		"\13\6\13\u0349\n\13\r\13\16\13\u034a\3\13\3\13\3\13\3\13\3\13\3\13\5\13"+
		"\u0353\n\13\3\13\3\13\3\13\5\13\u0358\n\13\5\13\u035a\n\13\3\13\3\13\3"+
		"\13\5\13\u035f\n\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u0367\n\13\3\13"+
		"\3\13\3\13\5\13\u036c\n\13\5\13\u036e\n\13\3\13\3\13\3\13\3\13\5\13\u0374"+
		"\n\13\6\13\u0376\n\13\r\13\16\13\u0377\3\13\3\13\3\13\3\13\3\13\3\13\5"+
		"\13\u0380\n\13\3\13\3\13\3\13\5\13\u0385\n\13\6\13\u0387\n\13\r\13\16"+
		"\13\u0388\3\13\3\13\5\13\u038d\n\13\5\13\u038f\n\13\3\13\3\13\3\13\3\13"+
		"\3\13\5\13\u0396\n\13\6\13\u0398\n\13\r\13\16\13\u0399\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\5\13\u03a2\n\13\3\13\3\13\5\13\u03a6\n\13\6\13\u03a8\n"+
		"\13\r\13\16\13\u03a9\3\13\3\13\5\13\u03ae\n\13\5\13\u03b0\n\13\3\13\3"+
		"\13\3\13\3\13\5\13\u03b6\n\13\6\13\u03b8\n\13\r\13\16\13\u03b9\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\5\13\u03c2\n\13\3\13\3\13\3\13\5\13\u03c7\n\13"+
		"\5\13\u03c9\n\13\3\13\3\13\3\13\3\13\5\13\u03cf\n\13\6\13\u03d1\n\13\r"+
		"\13\16\13\u03d2\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u03db\n\13\3\13\3\13"+
		"\5\13\u03df\n\13\6\13\u03e1\n\13\r\13\16\13\u03e2\3\13\3\13\3\13\5\13"+
		"\u03e8\n\13\6\13\u03ea\n\13\r\13\16\13\u03eb\3\13\5\13\u03ef\n\13\5\13"+
		"\u03f1\n\13\3\f\3\f\5\f\u03f5\n\f\3\f\3\f\3\f\5\f\u03fa\n\f\6\f\u03fc"+
		"\n\f\r\f\16\f\u03fd\3\f\5\f\u0401\n\f\3\r\3\r\6\r\u0405\n\r\r\r\16\r\u0406"+
		"\3\r\3\r\5\r\u040b\n\r\5\r\u040d\n\r\3\r\3\r\5\r\u0411\n\r\3\r\3\r\5\r"+
		"\u0415\n\r\6\r\u0417\n\r\r\r\16\r\u0418\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u0421"+
		"\n\r\6\r\u0423\n\r\r\r\16\r\u0424\5\r\u0427\n\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\5\r\u042f\n\r\6\r\u0431\n\r\r\r\16\r\u0432\6\r\u0435\n\r\r\r\16\r\u0436"+
		"\3\r\3\r\5\r\u043b\n\r\3\r\3\r\5\r\u043f\n\r\6\r\u0441\n\r\r\r\16\r\u0442"+
		"\5\r\u0445\n\r\3\r\3\r\5\r\u0449\n\r\3\r\3\r\5\r\u044d\n\r\6\r\u044f\n"+
		"\r\r\r\16\r\u0450\3\r\3\r\3\r\3\r\3\r\5\r\u0458\n\r\6\r\u045a\n\r\r\r"+
		"\16\r\u045b\3\r\3\r\5\r\u0460\n\r\5\r\u0462\n\r\3\r\3\r\3\r\3\r\5\r\u0468"+
		"\n\r\6\r\u046a\n\r\r\r\16\r\u046b\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u0474\n"+
		"\r\6\r\u0476\n\r\r\r\16\r\u0477\5\r\u047a\n\r\3\r\3\r\3\r\3\r\3\r\5\r"+
		"\u0481\n\r\6\r\u0483\n\r\r\r\16\r\u0484\3\r\3\r\5\r\u0489\n\r\5\r\u048b"+
		"\n\r\3\r\3\r\3\r\3\r\5\r\u0491\n\r\6\r\u0493\n\r\r\r\16\r\u0494\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\5\r\u049d\n\r\5\r\u049f\n\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\5\r\u04a7\n\r\6\r\u04a9\n\r\r\r\16\r\u04aa\3\r\3\r\3\r\3\r\3\r\3\r\5"+
		"\r\u04b3\n\r\5\r\u04b5\n\r\3\r\3\r\3\r\3\r\3\r\5\r\u04bc\n\r\6\r\u04be"+
		"\n\r\r\r\16\r\u04bf\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u04c8\n\r\5\r\u04ca\n"+
		"\r\3\r\3\r\3\r\5\r\u04cf\n\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u04d7\n\r\5\r"+
		"\u04d9\n\r\3\r\3\r\3\r\3\r\5\r\u04df\n\r\6\r\u04e1\n\r\r\r\16\r\u04e2"+
		"\3\r\3\r\3\r\3\r\3\r\5\r\u04ea\n\r\6\r\u04ec\n\r\r\r\16\r\u04ed\3\r\3"+
		"\r\5\r\u04f2\n\r\5\r\u04f4\n\r\3\r\3\r\3\r\3\r\3\r\5\r\u04fb\n\r\6\r\u04fd"+
		"\n\r\r\r\16\r\u04fe\3\r\3\r\3\r\3\r\3\r\5\r\u0506\n\r\6\r\u0508\n\r\r"+
		"\r\16\r\u0509\3\r\3\r\5\r\u050e\n\r\5\r\u0510\n\r\3\r\3\r\3\r\3\r\5\r"+
		"\u0516\n\r\6\r\u0518\n\r\r\r\16\r\u0519\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u0522"+
		"\n\r\5\r\u0524\n\r\3\r\3\r\3\r\3\r\5\r\u052a\n\r\6\r\u052c\n\r\r\r\16"+
		"\r\u052d\3\r\3\r\3\r\3\r\5\r\u0534\n\r\6\r\u0536\n\r\r\r\16\r\u0537\3"+
		"\r\3\r\3\r\5\r\u053d\n\r\6\r\u053f\n\r\r\r\16\r\u0540\3\r\3\r\3\r\5\r"+
		"\u0546\n\r\5\r\u0548\n\r\3\16\3\16\5\16\u054c\n\16\3\16\3\16\5\16\u0550"+
		"\n\16\3\16\5\16\u0553\n\16\6\16\u0555\n\16\r\16\16\16\u0556\3\16\3\16"+
		"\3\16\5\16\u055c\n\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u0565\n"+
		"\17\7\17\u0567\n\17\f\17\16\17\u056a\13\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5"+
		"\17\u05a9\n\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\5\17\u05d7\n\17\3\17\3\17\3\17\3\17\3\17\3\20"+
		"\3\20\3\21\3\21\3\21\3\21\5\21\u05e4\n\21\3\21\5\21\u05e7\n\21\3\21\3"+
		"\21\5\21\u05eb\n\21\7\21\u05ed\n\21\f\21\16\21\u05f0\13\21\3\21\3\21\3"+
		"\22\3\22\3\22\3\22\3\22\3\22\5\22\u05fa\n\22\6\22\u05fc\n\22\r\22\16\22"+
		"\u05fd\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u0608\n\23\3\23\5"+
		"\23\u060b\n\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u0616"+
		"\n\23\3\23\5\23\u0619\n\23\3\23\5\23\u061c\n\23\3\23\3\23\5\23\u0620\n"+
		"\23\3\23\3\23\3\23\3\23\3\23\5\23\u0627\n\23\3\23\5\23\u062a\n\23\3\23"+
		"\5\23\u062d\n\23\3\23\3\23\3\23\3\23\3\23\5\23\u0634\n\23\3\23\3\23\5"+
		"\23\u0638\n\23\3\23\3\23\3\23\3\23\5\23\u063e\n\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\5\23\u0646\n\23\3\23\7\23\u0649\n\23\f\23\16\23\u064c\13\23"+
		"\3\23\3\23\3\23\3\23\7\23\u0652\n\23\f\23\16\23\u0655\13\23\5\23\u0657"+
		"\n\23\3\23\5\23\u065a\n\23\6\23\u065c\n\23\r\23\16\23\u065d\5\23\u0660"+
		"\n\23\3\23\3\23\3\23\3\23\3\23\5\23\u0667\n\23\6\23\u0669\n\23\r\23\16"+
		"\23\u066a\3\23\3\23\5\23\u066f\n\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23"+
		"\u0677\n\23\3\23\3\23\5\23\u067b\n\23\3\23\3\23\3\23\3\23\5\23\u0681\n"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\7\23\u068b\n\23\f\23\16\23"+
		"\u068e\13\23\3\23\5\23\u0691\n\23\3\23\5\23\u0694\n\23\6\23\u0696\n\23"+
		"\r\23\16\23\u0697\3\23\3\23\5\23\u069c\n\23\3\23\3\23\3\23\3\23\5\23\u06a2"+
		"\n\23\3\24\3\24\3\24\3\25\3\25\5\25\u06a9\n\25\3\25\3\25\3\25\3\25\3\25"+
		"\5\25\u06b0\n\25\6\25\u06b2\n\25\r\25\16\25\u06b3\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\5\25\u06be\n\25\6\25\u06c0\n\25\r\25\16\25\u06c1"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u06ca\n\25\3\25\3\25\3\25\3\25\3\25"+
		"\5\25\u06d1\n\25\6\25\u06d3\n\25\r\25\16\25\u06d4\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\5\25\u06de\n\25\3\25\3\25\3\25\3\25\3\25\5\25\u06e5\n"+
		"\25\6\25\u06e7\n\25\r\25\16\25\u06e8\3\25\3\25\3\25\3\25\3\25\3\25\5\25"+
		"\u06f1\n\25\6\25\u06f3\n\25\r\25\16\25\u06f4\3\25\3\25\5\25\u06f9\n\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u0701\n\25\3\25\3\25\3\25\5\25\u0706"+
		"\n\25\3\25\3\25\3\25\5\25\u070b\n\25\5\25\u070d\n\25\3\25\3\25\3\25\5"+
		"\25\u0712\n\25\3\25\3\25\3\25\3\25\5\25\u0718\n\25\3\26\3\26\5\26\u071c"+
		"\n\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u0732\n\26\3\26\3\26\3\26\5\26"+
		"\u0737\n\26\3\26\3\26\3\26\5\26\u073c\n\26\5\26\u073e\n\26\3\26\3\26\3"+
		"\26\5\26\u0743\n\26\3\26\3\26\3\26\3\26\5\26\u0749\n\26\3\27\3\27\3\27"+
		"\3\27\3\27\3\30\3\30\3\30\3\30\3\30\5\30\u0755\n\30\3\30\5\30\u0758\n"+
		"\30\6\30\u075a\n\30\r\30\16\30\u075b\3\30\3\30\3\31\3\31\3\31\3\31\3\31"+
		"\5\31\u0765\n\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u076e\n\32\5"+
		"\32\u0770\n\32\3\33\3\33\5\33\u0774\n\33\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\5\34\u077c\n\34\3\35\5\35\u077f\n\35\3\35\3\35\3\35\3\35\5\35\u0785\n"+
		"\35\3\36\3\36\3\36\3\36\7\36\u078b\n\36\f\36\16\36\u078e\13\36\3\36\3"+
		"\36\3\37\3\37\3\37\3 \3 \3!\3!\3!\3!\3!\7!\u079c\n!\f!\16!\u079f\13!\3"+
		"!\3!\3\"\3\"\3\"\3\"\3#\3#\3#\3$\3$\3$\3%\3%\3&\3&\3&\3&\5&\u07b3\n&\3"+
		"\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\7(\u07c2\n(\f(\16(\u07c5"+
		"\13(\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\5)\u07d1\n)\3)\3)\5)\u07d5\n)\5)\u07d7"+
		"\n)\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\5*\u07e4\n*\3+\3+\3+\7+\u07e9\n+"+
		"\f+\16+\u07ec\13+\3,\3,\3,\3-\3-\3-\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3/\3"+
		"/\3/\7/\u0801\n/\f/\16/\u0804\13/\3\60\3\60\3\60\3\60\5\60\u080a\n\60"+
		"\3\60\3\60\3\60\3\60\3\61\3\61\3\61\3\61\3\61\3\62\3\62\3\63\3\63\3\63"+
		"\3\63\5\63\u081b\n\63\3\64\5\64\u081e\n\64\3\64\3\64\5\64\u0822\n\64\3"+
		"\64\5\64\u0825\n\64\3\65\3\65\3\66\3\66\5\66\u082b\n\66\3\67\3\67\3\67"+
		"\5\67\u0830\n\67\38\38\38\58\u0835\n8\39\39\39\3:\3:\3:\3;\3;\3;\3<\3"+
		"<\3=\3=\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\5>\u084e\n>\3?\3?\3@\3@\3A\3A\5"+
		"A\u0856\nA\3A\3A\5A\u085a\nA\3A\3A\3A\5A\u085f\nA\3A\3A\3A\5A\u0864\n"+
		"A\3A\3A\5A\u0868\nA\3A\5A\u086b\nA\3B\3B\3B\3B\3C\3C\3C\5C\u0874\nC\3"+
		"C\3C\3C\5C\u0879\nC\3C\3C\5C\u087d\nC\3C\3C\3C\3C\5C\u0883\nC\3C\3C\3"+
		"C\3C\5C\u0889\nC\3C\3C\3C\5C\u088e\nC\3C\3C\5C\u0892\nC\5C\u0894\nC\3"+
		"D\3D\5D\u0898\nD\3D\3D\5D\u089c\nD\5D\u089e\nD\3E\3E\5E\u08a2\nE\3F\3"+
		"F\5F\u08a6\nF\3F\3F\5F\u08aa\nF\3F\3F\5F\u08ae\nF\3F\3F\3F\3F\3F\3F\3"+
		"F\3F\3F\5F\u08b9\nF\3G\3G\5G\u08bd\nG\3G\3G\3G\3G\3G\3G\5G\u08c5\nG\3"+
		"H\3H\3H\3H\3H\3H\3H\3H\5H\u08cf\nH\3I\3I\3J\3J\3J\3J\3J\3J\3J\3J\3J\3"+
		"J\3J\3J\3J\5J\u08e0\nJ\3K\3K\5K\u08e4\nK\3K\3K\5K\u08e8\nK\3K\3K\3K\5"+
		"K\u08ed\nK\5K\u08ef\nK\3L\3L\5L\u08f3\nL\3L\3L\3L\5L\u08f8\nL\3L\3L\5"+
		"L\u08fc\nL\5L\u08fe\nL\3M\3M\5M\u0902\nM\3N\3N\3N\3N\3O\3O\3O\3O\3O\3"+
		"O\3O\5O\u090f\nO\3P\3P\3Q\3Q\3R\5R\u0916\nR\3R\3R\3S\3S\3T\3T\3T\3T\3"+
		"T\3T\5T\u0922\nT\5T\u0924\nT\3U\3U\3U\5U\u0929\nU\3U\3U\3U\3V\3V\3W\3"+
		"W\3W\3W\3W\3W\3X\3X\3X\3X\3X\3Y\3Y\3Z\3Z\3Z\3Z\3Z\3Z\3Z\3Z\3Z\3Z\3Z\3"+
		"Z\6Z\u0949\nZ\rZ\16Z\u094a\3Z\3Z\5Z\u094f\nZ\3[\3[\5[\u0953\n[\3\\\3\\"+
		"\3\\\6\\\u0958\n\\\r\\\16\\\u0959\3\\\5\\\u095d\n\\\3\\\3\\\3]\3]\6]\u0963"+
		"\n]\r]\16]\u0964\3]\5]\u0968\n]\3]\3]\3^\3^\3^\3^\3^\3_\3_\3_\3_\3_\3"+
		"`\3`\3`\3a\3a\5a\u097b\na\3b\3b\3b\3b\3b\3b\3b\3c\3c\3d\3d\3e\3e\3e\5"+
		"e\u098b\ne\3f\3f\3f\5f\u0990\nf\3g\3g\3g\7g\u0995\ng\fg\16g\u0998\13g"+
		"\3h\3h\3h\7h\u099d\nh\fh\16h\u09a0\13h\3i\5i\u09a3\ni\3i\3i\3j\3j\3j\3"+
		"j\7j\u09ab\nj\fj\16j\u09ae\13j\3j\3j\3k\3k\3k\7k\u09b5\nk\fk\16k\u09b8"+
		"\13k\3k\5k\u09bb\nk\3l\3l\3m\3m\3n\3n\3n\3n\3n\3n\3n\3o\3o\3o\5o\u09cb"+
		"\no\3p\3p\3q\3q\5q\u09d1\nq\3r\3r\3s\3s\3s\7s\u09d8\ns\fs\16s\u09db\13"+
		"s\3t\3t\3u\3u\5u\u09e1\nu\3v\3v\3w\3w\3w\3w\3w\3x\5x\u09eb\nx\3x\5x\u09ee"+
		"\nx\3x\5x\u09f1\nx\3x\3x\3x\3x\3x\5x\u09f8\nx\3y\3y\3z\3z\3{\3{\3{\7{"+
		"\u0a01\n{\f{\16{\u0a04\13{\3|\3|\3|\7|\u0a09\n|\f|\16|\u0a0c\13|\3}\3"+
		"}\3}\5}\u0a11\n}\3~\3~\5~\u0a15\n~\3\177\3\177\5\177\u0a19\n\177\3\177"+
		"\3\177\3\u0080\3\u0080\3\u0081\3\u0081\5\u0081\u0a21\n\u0081\3\u0082\3"+
		"\u0082\5\u0082\u0a25\n\u0082\3\u0083\3\u0083\3\u0083\3\u0083\3\u0084\3"+
		"\u0084\5\u0084\u0a2d\n\u0084\3\u0085\3\u0085\3\u0086\3\u0086\3\u0087\3"+
		"\u0087\5\u0087\u0a35\n\u0087\3\u0088\3\u0088\5\u0088\u0a39\n\u0088\3\u0089"+
		"\3\u0089\5\u0089\u0a3d\n\u0089\3\u0089\5\u0089\u0a40\n\u0089\3\u0089\5"+
		"\u0089\u0a43\n\u0089\3\u0089\5\u0089\u0a46\n\u0089\3\u0089\5\u0089\u0a49"+
		"\n\u0089\3\u008a\3\u008a\3\u008a\3\u008b\3\u008b\3\u008b\7\u008b\u0a51"+
		"\n\u008b\f\u008b\16\u008b\u0a54\13\u008b\3\u008c\3\u008c\5\u008c\u0a58"+
		"\n\u008c\3\u008d\3\u008d\6\u008d\u0a5c\n\u008d\r\u008d\16\u008d\u0a5d"+
		"\3\u008e\3\u008e\3\u008e\3\u008e\5\u008e\u0a64\n\u008e\3\u008e\3\u008e"+
		"\3\u008e\3\u008e\3\u008e\3\u008e\5\u008e\u0a6c\n\u008e\3\u008e\3\u008e"+
		"\3\u008e\3\u008e\3\u008e\5\u008e\u0a73\n\u008e\3\u008f\3\u008f\3\u008f"+
		"\3\u008f\3\u0090\5\u0090\u0a7a\n\u0090\3\u0090\3\u0090\3\u0090\3\u0090"+
		"\3\u0091\3\u0091\5\u0091\u0a82\n\u0091\3\u0091\3\u0091\3\u0091\3\u0092"+
		"\3\u0092\3\u0092\3\u0092\3\u0093\3\u0093\5\u0093\u0a8d\n\u0093\3\u0094"+
		"\3\u0094\5\u0094\u0a91\n\u0094\3\u0095\3\u0095\3\u0096\3\u0096\5\u0096"+
		"\u0a97\n\u0096\3\u0097\3\u0097\3\u0097\3\u0098\3\u0098\3\u0098\3\u0098"+
		"\3\u0098\3\u0099\3\u0099\5\u0099\u0aa3\n\u0099\3\u0099\5\u0099\u0aa6\n"+
		"\u0099\3\u0099\3\u0099\3\u0099\3\u0099\5\u0099\u0aac\n\u0099\3\u0099\3"+
		"\u0099\5\u0099\u0ab0\n\u0099\3\u0099\3\u0099\3\u0099\3\u0099\3\u0099\5"+
		"\u0099\u0ab7\n\u0099\5\u0099\u0ab9\n\u0099\3\u009a\3\u009a\3\u009a\7\u009a"+
		"\u0abe\n\u009a\f\u009a\16\u009a\u0ac1\13\u009a\3\u009b\3\u009b\3\u009c"+
		"\3\u009c\3\u009c\3\u009d\3\u009d\3\u009e\3\u009e\3\u009e\3\u009e\3\u009f"+
		"\3\u009f\3\u009f\7\u009f\u0ad1\n\u009f\f\u009f\16\u009f\u0ad4\13\u009f"+
		"\3\u00a0\3\u00a0\3\u00a0\3\u00a0\5\u00a0\u0ada\n\u00a0\3\u00a1\3\u00a1"+
		"\3\u00a1\3\u00a1\3\u00a1\5\u00a1\u0ae1\n\u00a1\3\u00a2\3\u00a2\3\u00a2"+
		"\7\u00a2\u0ae6\n\u00a2\f\u00a2\16\u00a2\u0ae9\13\u00a2\3\u00a3\3\u00a3"+
		"\3\u00a3\3\u00a3\3\u00a3\3\u00a4\3\u00a4\3\u00a4\3\u00a4\3\u00a4\3\u00a5"+
		"\3\u00a5\3\u00a5\3\u00a6\3\u00a6\3\u00a6\3\u00a7\3\u00a7\3\u00a7\7\u00a7"+
		"\u0afe\n\u00a7\f\u00a7\16\u00a7\u0b01\13\u00a7\3\u00a8\3\u00a8\3\u00a9"+
		"\3\u00a9\5\u00a9\u0b07\n\u00a9\3\u00aa\3\u00aa\3\u00aa\3\u00aa\5\u00aa"+
		"\u0b0d\n\u00aa\3\u00aa\3\u00aa\5\u00aa\u0b11\n\u00aa\3\u00aa\3\u00aa\5"+
		"\u00aa\u0b15\n\u00aa\3\u00aa\7\u00aa\u0b18\n\u00aa\f\u00aa\16\u00aa\u0b1b"+
		"\13\u00aa\3\u00ab\3\u00ab\5\u00ab\u0b1f\n\u00ab\3\u00ac\3\u00ac\3\u00ac"+
		"\3\u00ac\5\u00ac\u0b25\n\u00ac\3\u00ac\3\u00ac\5\u00ac\u0b29\n\u00ac\3"+
		"\u00ac\3\u00ac\5\u00ac\u0b2d\n\u00ac\3\u00ac\7\u00ac\u0b30\n\u00ac\f\u00ac"+
		"\16\u00ac\u0b33\13\u00ac\3\u00ad\3\u00ad\5\u00ad\u0b37\n\u00ad\3\u00ae"+
		"\3\u00ae\3\u00ae\3\u00ae\3\u00ae\5\u00ae\u0b3e\n\u00ae\3\u00af\3\u00af"+
		"\5\u00af\u0b42\n\u00af\3\u00b0\3\u00b0\3\u00b0\3\u00b1\3\u00b1\5\u00b1"+
		"\u0b49\n\u00b1\3\u00b2\3\u00b2\3\u00b2\3\u00b2\3\u00b2\5\u00b2\u0b50\n"+
		"\u00b2\5\u00b2\u0b52\n\u00b2\3\u00b3\3\u00b3\5\u00b3\u0b56\n\u00b3\3\u00b3"+
		"\3\u00b3\5\u00b3\u0b5a\n\u00b3\3\u00b4\3\u00b4\3\u00b4\7\u00b4\u0b5f\n"+
		"\u00b4\f\u00b4\16\u00b4\u0b62\13\u00b4\3\u00b5\3\u00b5\5\u00b5\u0b66\n"+
		"\u00b5\3\u00b6\3\u00b6\5\u00b6\u0b6a\n\u00b6\3\u00b7\3\u00b7\5\u00b7\u0b6e"+
		"\n\u00b7\3\u00b7\3\u00b7\3\u00b8\3\u00b8\3\u00b9\3\u00b9\3\u00b9\5\u00b9"+
		"\u0b77\n\u00b9\3\u00b9\3\u00b9\3\u00ba\5\u00ba\u0b7c\n\u00ba\3\u00ba\3"+
		"\u00ba\3\u00bb\3\u00bb\3\u00bb\7\u00bb\u0b83\n\u00bb\f\u00bb\16\u00bb"+
		"\u0b86\13\u00bb\3\u00bc\3\u00bc\3\u00bd\3\u00bd\3\u00be\3\u00be\3\u00bf"+
		"\3\u00bf\3\u00bf\3\u00bf\3\u00c0\3\u00c0\3\u00c0\3\u00c0\3\u00c0\3\u00c0"+
		"\5\u00c0\u0b98\n\u00c0\3\u00c1\3\u00c1\3\u00c1\3\u00c1\3\u00c2\3\u00c2"+
		"\3\u00c3\3\u00c3\3\u00c3\3\u00c4\5\u00c4\u0ba4\n\u00c4\3\u00c4\3\u00c4"+
		"\5\u00c4\u0ba8\n\u00c4\3\u00c4\3\u00c4\3\u00c4\3\u00c4\3\u00c5\3\u00c5"+
		"\5\u00c5\u0bb0\n\u00c5\3\u00c5\3\u00c5\3\u00c5\3\u00c6\3\u00c6\3\u00c6"+
		"\3\u00c6\3\u00c6\5\u00c6\u0bba\n\u00c6\3\u00c7\3\u00c7\3\u00c7\7\u00c7"+
		"\u0bbf\n\u00c7\f\u00c7\16\u00c7\u0bc2\13\u00c7\3\u00c8\3\u00c8\3\u00c8"+
		"\3\u00c8\3\u00c9\5\u00c9\u0bc9\n\u00c9\3\u00c9\3\u00c9\5\u00c9\u0bcd\n"+
		"\u00c9\3\u00ca\3\u00ca\3\u00ca\3\u00ca\3\u00ca\3\u00ca\5\u00ca\u0bd5\n"+
		"\u00ca\3\u00cb\3\u00cb\3\u00cc\3\u00cc\3\u00cc\5\u00cc\u0bdc\n\u00cc\3"+
		"\u00cc\3\u00cc\3\u00cd\3\u00cd\3\u00cd\3\u00cd\3\u00cd\3\u00ce\3\u00ce"+
		"\5\u00ce\u0be7\n\u00ce\3\u00cf\3\u00cf\3\u00d0\3\u00d0\3\u00d1\5\u00d1"+
		"\u0bee\n\u00d1\3\u00d1\3\u00d1\3\u00d1\3\u00d2\3\u00d2\3\u00d2\3\u00d3"+
		"\3\u00d3\5\u00d3\u0bf8\n\u00d3\3\u00d4\3\u00d4\3\u00d5\3\u00d5\3\u00d6"+
		"\3\u00d6\3\u00d6\5\u00d6\u0c01\n\u00d6\3\u00d6\3\u00d6\3\u00d7\3\u00d7"+
		"\3\u00d8\3\u00d8\5\u00d8\u0c09\n\u00d8\3\u00d9\3\u00d9\3\u00d9\7\u00d9"+
		"\u0c0e\n\u00d9\f\u00d9\16\u00d9\u0c11\13\u00d9\3\u00da\3\u00da\3\u00da"+
		"\3\u00da\3\u00db\3\u00db\3\u00db\7\u00db\u0c1a\n\u00db\f\u00db\16\u00db"+
		"\u0c1d\13\u00db\3\u00dc\3\u00dc\5\u00dc\u0c21\n\u00dc\3\u00dc\5\u00dc"+
		"\u0c24\n\u00dc\3\u00dd\3\u00dd\3\u00de\3\u00de\3\u00de\3\u00df\3\u00df"+
		"\3\u00df\3\u00df\5\u00df\u0c2f\n\u00df\3\u00e0\3\u00e0\5\u00e0\u0c33\n"+
		"\u00e0\3\u00e0\3\u00e0\3\u00e0\3\u00e0\3\u00e0\3\u00e0\5\u00e0\u0c3b\n"+
		"\u00e0\3\u00e0\3\u00e0\3\u00e0\3\u00e0\5\u00e0\u0c41\n\u00e0\3\u00e0\3"+
		"\u00e0\3\u00e0\3\u00e0\3\u00e0\3\u00e0\5\u00e0\u0c49\n\u00e0\5\u00e0\u0c4b"+
		"\n\u00e0\3\u00e0\5\u00e0\u0c4e\n\u00e0\3\u00e0\2\2\u00e1\2\4\6\b\n\f\16"+
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
		"\u01b4\u01b6\u01b8\u01ba\u01bc\u01be\2$\4\2GGee\4\2\u00dd\u00dd\u0113"+
		"\u0113\t\2\35\35[[ddnnpptt\u00a5\u00a5\6\2[[ddtt\u00a5\u00a5\4\2ddtu\5"+
		"\2\22\22\26\26jk\4\2\26\26uu\4\2\16\16]]\4\2ddtt\6\2\67\67>>OOww\4\2\60"+
		"\60GG\3\2jk\4\2&&88\b\2\6\6\24\24\32\32\u0089\u0089\u00a4\u00a4\u00d0"+
		"\u00d0\t\2}\u00a1\u00a3\u00a3\u00a5\u00d5\u00d7\u00e3\u00e5\u00f8\u00fa"+
		"\u0107\u0109\u010c\5\2))oo\u00de\u00de\3\2\u00e9\u00ea\3\2\u0129\u012a"+
		"\17\2\b\bff~~\u0085\u0085\u008c\u008c\u0097\u0097\u009f\u009f\u00a6\u00a6"+
		"\u00b0\u00b0\u00b5\u00b5\u00d1\u00d2\u00d4\u00d4\u00e1\u00e2\3\2\u011f"+
		"\u0120\3\2\u0121\u0123\3\2\u00d9\u00db\5\2\f\fCCmm\5\2,,DD__\4\2$$rr\4"+
		"\2\6\6\37\37\4\2\u0113\u0113\u0118\u011c\4\2\t\thh\3\2\u010d\u0110\4\2"+
		"\b\bff\6\2\u008f\u008f\u00a2\u00a2\u00b6\u00b7\u00e7\u00e7\n\2\u0082\u0082"+
		"\u0091\u0091\u0093\u0094\u0096\u0096\u00a7\u00a8\u00b2\u00b4\u00c5\u00c5"+
		"\u00e5\u00e5\4\2DD__\4\2\n\n\36\36\u0dc7\2\u01c4\3\2\2\2\4\u01d4\3\2\2"+
		"\2\6\u01d6\3\2\2\2\b\u01d8\3\2\2\2\n\u01dc\3\2\2\2\f\u01de\3\2\2\2\16"+
		"\u01ef\3\2\2\2\20\u022d\3\2\2\2\22\u022f\3\2\2\2\24\u03f0\3\2\2\2\26\u03f2"+
		"\3\2\2\2\30\u0547\3\2\2\2\32\u0549\3\2\2\2\34\u055d\3\2\2\2\36\u05dd\3"+
		"\2\2\2 \u05df\3\2\2\2\"\u05f3\3\2\2\2$\u06a1\3\2\2\2&\u06a3\3\2\2\2(\u06a8"+
		"\3\2\2\2*\u071b\3\2\2\2,\u074a\3\2\2\2.\u074f\3\2\2\2\60\u0764\3\2\2\2"+
		"\62\u076f\3\2\2\2\64\u0773\3\2\2\2\66\u077b\3\2\2\28\u077e\3\2\2\2:\u0786"+
		"\3\2\2\2<\u0791\3\2\2\2>\u0794\3\2\2\2@\u0796\3\2\2\2B\u07a2\3\2\2\2D"+
		"\u07a6\3\2\2\2F\u07a9\3\2\2\2H\u07ac\3\2\2\2J\u07b2\3\2\2\2L\u07b4\3\2"+
		"\2\2N\u07be\3\2\2\2P\u07c6\3\2\2\2R\u07d8\3\2\2\2T\u07e5\3\2\2\2V\u07ed"+
		"\3\2\2\2X\u07f0\3\2\2\2Z\u07f3\3\2\2\2\\\u07fd\3\2\2\2^\u0805\3\2\2\2"+
		"`\u080f\3\2\2\2b\u0814\3\2\2\2d\u0816\3\2\2\2f\u0824\3\2\2\2h\u0826\3"+
		"\2\2\2j\u082a\3\2\2\2l\u082f\3\2\2\2n\u0834\3\2\2\2p\u0836\3\2\2\2r\u0839"+
		"\3\2\2\2t\u083c\3\2\2\2v\u083f\3\2\2\2x\u0841\3\2\2\2z\u084d\3\2\2\2|"+
		"\u084f\3\2\2\2~\u0851\3\2\2\2\u0080\u086a\3\2\2\2\u0082\u086c\3\2\2\2"+
		"\u0084\u0893\3\2\2\2\u0086\u089d\3\2\2\2\u0088\u08a1\3\2\2\2\u008a\u08b8"+
		"\3\2\2\2\u008c\u08c4\3\2\2\2\u008e\u08ce\3\2\2\2\u0090\u08d0\3\2\2\2\u0092"+
		"\u08df\3\2\2\2\u0094\u08ee\3\2\2\2\u0096\u08fd\3\2\2\2\u0098\u0901\3\2"+
		"\2\2\u009a\u0903\3\2\2\2\u009c\u090e\3\2\2\2\u009e\u0910\3\2\2\2\u00a0"+
		"\u0912\3\2\2\2\u00a2\u0915\3\2\2\2\u00a4\u0919\3\2\2\2\u00a6\u0923\3\2"+
		"\2\2\u00a8\u0925\3\2\2\2\u00aa\u092d\3\2\2\2\u00ac\u092f\3\2\2\2\u00ae"+
		"\u0935\3\2\2\2\u00b0\u093a\3\2\2\2\u00b2\u094e\3\2\2\2\u00b4\u0952\3\2"+
		"\2\2\u00b6\u0954\3\2\2\2\u00b8\u0960\3\2\2\2\u00ba\u096b\3\2\2\2\u00bc"+
		"\u0970\3\2\2\2\u00be\u0975\3\2\2\2\u00c0\u097a\3\2\2\2\u00c2\u097c\3\2"+
		"\2\2\u00c4\u0983\3\2\2\2\u00c6\u0985\3\2\2\2\u00c8\u098a\3\2\2\2\u00ca"+
		"\u098f\3\2\2\2\u00cc\u0991\3\2\2\2\u00ce\u0999\3\2\2\2\u00d0\u09a2\3\2"+
		"\2\2\u00d2\u09a6\3\2\2\2\u00d4\u09ba\3\2\2\2\u00d6\u09bc\3\2\2\2\u00d8"+
		"\u09be\3\2\2\2\u00da\u09c0\3\2\2\2\u00dc\u09ca\3\2\2\2\u00de\u09cc\3\2"+
		"\2\2\u00e0\u09d0\3\2\2\2\u00e2\u09d2\3\2\2\2\u00e4\u09d4\3\2\2\2\u00e6"+
		"\u09dc\3\2\2\2\u00e8\u09e0\3\2\2\2\u00ea\u09e2\3\2\2\2\u00ec\u09e4\3\2"+
		"\2\2\u00ee\u09f7\3\2\2\2\u00f0\u09f9\3\2\2\2\u00f2\u09fb\3\2\2\2\u00f4"+
		"\u09fd\3\2\2\2\u00f6\u0a05\3\2\2\2\u00f8\u0a10\3\2\2\2\u00fa\u0a12\3\2"+
		"\2\2\u00fc\u0a16\3\2\2\2\u00fe\u0a1c\3\2\2\2\u0100\u0a20\3\2\2\2\u0102"+
		"\u0a24\3\2\2\2\u0104\u0a26\3\2\2\2\u0106\u0a2c\3\2\2\2\u0108\u0a2e\3\2"+
		"\2\2\u010a\u0a30\3\2\2\2\u010c\u0a34\3\2\2\2\u010e\u0a38\3\2\2\2\u0110"+
		"\u0a3a\3\2\2\2\u0112\u0a4a\3\2\2\2\u0114\u0a4d\3\2\2\2\u0116\u0a57\3\2"+
		"\2\2\u0118\u0a59\3\2\2\2\u011a\u0a72\3\2\2\2\u011c\u0a74\3\2\2\2\u011e"+
		"\u0a79\3\2\2\2\u0120\u0a7f\3\2\2\2\u0122\u0a86\3\2\2\2\u0124\u0a8c\3\2"+
		"\2\2\u0126\u0a8e\3\2\2\2\u0128\u0a92\3\2\2\2\u012a\u0a96\3\2\2\2\u012c"+
		"\u0a98\3\2\2\2\u012e\u0a9b\3\2\2\2\u0130\u0ab8\3\2\2\2\u0132\u0aba\3\2"+
		"\2\2\u0134\u0ac2\3\2\2\2\u0136\u0ac4\3\2\2\2\u0138\u0ac7\3\2\2\2\u013a"+
		"\u0ac9\3\2\2\2\u013c\u0acd\3\2\2\2\u013e\u0ad9\3\2\2\2\u0140\u0ae0\3\2"+
		"\2\2\u0142\u0ae2\3\2\2\2\u0144\u0aea\3\2\2\2\u0146\u0aef\3\2\2\2\u0148"+
		"\u0af4\3\2\2\2\u014a\u0af7\3\2\2\2\u014c\u0afa\3\2\2\2\u014e\u0b02\3\2"+
		"\2\2\u0150\u0b06\3\2\2\2\u0152\u0b10\3\2\2\2\u0154\u0b1e\3\2\2\2\u0156"+
		"\u0b28\3\2\2\2\u0158\u0b36\3\2\2\2\u015a\u0b3d\3\2\2\2\u015c\u0b41\3\2"+
		"\2\2\u015e\u0b43\3\2\2\2\u0160\u0b48\3\2\2\2\u0162\u0b4a\3\2\2\2\u0164"+
		"\u0b53\3\2\2\2\u0166\u0b5b\3\2\2\2\u0168\u0b65\3\2\2\2\u016a\u0b67\3\2"+
		"\2\2\u016c\u0b6d\3\2\2\2\u016e\u0b71\3\2\2\2\u0170\u0b76\3\2\2\2\u0172"+
		"\u0b7b\3\2\2\2\u0174\u0b7f\3\2\2\2\u0176\u0b87\3\2\2\2\u0178\u0b89\3\2"+
		"\2\2\u017a\u0b8b\3\2\2\2\u017c\u0b8d\3\2\2\2\u017e\u0b97\3\2\2\2\u0180"+
		"\u0b99\3\2\2\2\u0182\u0b9d\3\2\2\2\u0184\u0b9f\3\2\2\2\u0186\u0ba3\3\2"+
		"\2\2\u0188\u0bad\3\2\2\2\u018a\u0bb9\3\2\2\2\u018c\u0bbb\3\2\2\2\u018e"+
		"\u0bc3\3\2\2\2\u0190\u0bcc\3\2\2\2\u0192\u0bd4\3\2\2\2\u0194\u0bd6\3\2"+
		"\2\2\u0196\u0bd8\3\2\2\2\u0198\u0bdf\3\2\2\2\u019a\u0be6\3\2\2\2\u019c"+
		"\u0be8\3\2\2\2\u019e\u0bea\3\2\2\2\u01a0\u0bed\3\2\2\2\u01a2\u0bf2\3\2"+
		"\2\2\u01a4\u0bf7\3\2\2\2\u01a6\u0bf9\3\2\2\2\u01a8\u0bfb\3\2\2\2\u01aa"+
		"\u0bfd\3\2\2\2\u01ac\u0c04\3\2\2\2\u01ae\u0c08\3\2\2\2\u01b0\u0c0a\3\2"+
		"\2\2\u01b2\u0c12\3\2\2\2\u01b4\u0c16\3\2\2\2\u01b6\u0c1e\3\2\2\2\u01b8"+
		"\u0c25\3\2\2\2\u01ba\u0c27\3\2\2\2\u01bc\u0c2e\3\2\2\2\u01be\u0c4d\3\2"+
		"\2\2\u01c0\u01c2\5\4\3\2\u01c1\u01c3\7\u0115\2\2\u01c2\u01c1\3\2\2\2\u01c2"+
		"\u01c3\3\2\2\2\u01c3\u01c5\3\2\2\2\u01c4\u01c0\3\2\2\2\u01c5\u01c6\3\2"+
		"\2\2\u01c6\u01c4\3\2\2\2\u01c6\u01c7\3\2\2\2\u01c7\u01c8\3\2\2\2\u01c8"+
		"\u01c9\7\2\2\3\u01c9\3\3\2\2\2\u01ca\u01d5\5\6\4\2\u01cb\u01d5\5\b\5\2"+
		"\u01cc\u01d5\5\n\6\2\u01cd\u01d5\5\f\7\2\u01ce\u01d5\5\16\b\2\u01cf\u01d5"+
		"\5\20\t\2\u01d0\u01d5\5\22\n\2\u01d1\u01d5\5\30\r\2\u01d2\u01d5\5\24\13"+
		"\2\u01d3\u01d5\5\34\17\2\u01d4\u01ca\3\2\2\2\u01d4\u01cb\3\2\2\2\u01d4"+
		"\u01cc\3\2\2\2\u01d4\u01cd\3\2\2\2\u01d4\u01ce\3\2\2\2\u01d4\u01cf\3\2"+
		"\2\2\u01d4\u01d0\3\2\2\2\u01d4\u01d1\3\2\2\2\u01d4\u01d2\3\2\2\2\u01d4"+
		"\u01d3\3\2\2\2\u01d5\5\3\2\2\2\u01d6\u01d7\5\u014e\u00a8\2\u01d7\7\3\2"+
		"\2\2\u01d8\u01d9\5\u01be\u00e0\2\u01d9\t\3\2\2\2\u01da\u01dd\5$\23\2\u01db"+
		"\u01dd\5d\63\2\u01dc\u01da\3\2\2\2\u01dc\u01db\3\2\2\2\u01dd\13\3\2\2"+
		"\2\u01de\u01e0\7\26\2\2\u01df\u01e1\7s\2\2\u01e0\u01df\3\2\2\2\u01e0\u01e1"+
		"\3\2\2\2\u01e1\u01e2\3\2\2\2\u01e2\u01e3\7\u00a3\2\2\u01e3\u01e4\5f\64"+
		"\2\u01e4\u01e5\7M\2\2\u01e5\u01e7\5\u0162\u00b2\2\u01e6\u01e8\5D#\2\u01e7"+
		"\u01e6\3\2\2\2\u01e7\u01e8\3\2\2\2\u01e8\u01e9\3\2\2\2\u01e9\u01ea\7\u011d"+
		"\2\2\u01ea\u01eb\5\u01b4\u00db\2\u01eb\u01ed\7\u011e\2\2\u01ec\u01ee\5"+
		"@!\2\u01ed\u01ec\3\2\2\2\u01ed\u01ee\3\2\2\2\u01ee\r\3\2\2\2\u01ef\u01f0"+
		"\7\26\2\2\u01f0\u01f4\7(\2\2\u01f1\u01f2\7\64\2\2\u01f2\u01f3\7I\2\2\u01f3"+
		"\u01f5\7\u0098\2\2\u01f4\u01f1\3\2\2\2\u01f4\u01f5\3\2\2\2\u01f5\u01f6"+
		"\3\2\2\2\u01f6\u01f8\5f\64\2\u01f7\u01f9\7{\2\2\u01f8\u01f7\3\2\2\2\u01f8"+
		"\u01f9\3\2\2\2\u01f9\u01fc\3\2\2\2\u01fa\u01fb\7a\2\2\u01fb\u01fd\5f\64"+
		"\2\u01fc\u01fa\3\2\2\2\u01fc\u01fd\3\2\2\2\u01fd\u0200\3\2\2\2\u01fe\u01ff"+
		"\7\u00e4\2\2\u01ff\u0201\5f\64\2\u0200\u01fe\3\2\2\2\u0200\u0201\3\2\2"+
		"\2\u0201\u0204\3\2\2\2\u0202\u0203\7/\2\2\u0203\u0205\5f\64\2\u0204\u0202"+
		"\3\2\2\2\u0204\u0205\3\2\2\2\u0205\17\3\2\2\2\u0206\u0208\7\u00cd\2\2"+
		"\u0207\u0209\t\2\2\2\u0208\u0207\3\2\2\2\u0208\u0209\3\2\2\2\u0209\u020a"+
		"\3\2\2\2\u020a\u020b\5f\64\2\u020b\u0217\t\3\2\2\u020c\u0213\5f\64\2\u020d"+
		"\u020e\7\u0127\2\2\u020e\u020f\5f\64\2\u020f\u0210\7\u0127\2\2\u0210\u0213"+
		"\3\2\2\2\u0211\u0213\7\31\2\2\u0212\u020c\3\2\2\2\u0212\u020d\3\2\2\2"+
		"\u0212\u0211\3\2\2\2\u0213\u0215\3\2\2\2\u0214\u0216\7\u0116\2\2\u0215"+
		"\u0214\3\2\2\2\u0215\u0216\3\2\2\2\u0216\u0218\3\2\2\2\u0217\u0212\3\2"+
		"\2\2\u0218\u0219\3\2\2\2\u0219\u0217\3\2\2\2\u0219\u021a\3\2\2\2\u021a"+
		"\u022e\3\2\2\2\u021b\u021d\7\u00cd\2\2\u021c\u021e\t\2\2\2\u021d\u021c"+
		"\3\2\2\2\u021d\u021e\3\2\2\2\u021e\u021f\3\2\2\2\u021f\u0220\7\u0103\2"+
		"\2\u0220\u0229\7\u00e8\2\2\u0221\u0225\5f\64\2\u0222\u0225\7G\2\2\u0223"+
		"\u0225\7\31\2\2\u0224\u0221\3\2\2\2\u0224\u0222\3\2\2\2\u0224\u0223\3"+
		"\2\2\2\u0225\u0227\3\2\2\2\u0226\u0228\7\u0116\2\2\u0227\u0226\3\2\2\2"+
		"\u0227\u0228\3\2\2\2\u0228\u022a\3\2\2\2\u0229\u0224\3\2\2\2\u022a\u022b"+
		"\3\2\2\2\u022b\u0229\3\2\2\2\u022b\u022c\3\2\2\2\u022c\u022e\3\2\2\2\u022d"+
		"\u0206\3\2\2\2\u022d\u021b\3\2\2\2\u022e\21\3\2\2\2\u022f\u0231\7\26\2"+
		"\2\u0230\u0232\7\23\2\2\u0231\u0230\3\2\2\2\u0231\u0232\3\2\2\2\u0232"+
		"\u0233\3\2\2\2\u0233\u0234\7n\2\2\u0234\u0239\5f\64\2\u0235\u023a\7\13"+
		"\2\2\u0236\u0237\7?\2\2\u0237\u023a\7K\2\2\u0238\u023a\7\4\2\2\u0239\u0235"+
		"\3\2\2\2\u0239\u0236\3\2\2\2\u0239\u0238\3\2\2\2\u023a\u024a\3\2\2\2\u023b"+
		"\u024b\7\u00a5\2\2\u023c\u024b\7\35\2\2\u023d\u024b\7p\2\2\u023e\u0248"+
		"\7t\2\2\u023f\u0244\7K\2\2\u0240\u0242\5f\64\2\u0241\u0243\7\u0116\2\2"+
		"\u0242\u0241\3\2\2\2\u0242\u0243\3\2\2\2\u0243\u0245\3\2\2\2\u0244\u0240"+
		"\3\2\2\2\u0245\u0246\3\2\2\2\u0246\u0244\3\2\2\2\u0246\u0247\3\2\2\2\u0247"+
		"\u0249\3\2\2\2\u0248\u023f\3\2\2\2\u0248\u0249\3\2\2\2\u0249\u024b\3\2"+
		"\2\2\u024a\u023b\3\2\2\2\u024a\u023c\3\2\2\2\u024a\u023d\3\2\2\2\u024a"+
		"\u023e\3\2\2\2\u024b\u024c\3\2\2\2\u024c\u024d\7M\2\2\u024d\u0250\5\u0162"+
		"\u00b2\2\u024e\u024f\7/\2\2\u024f\u0251\5\u0162\u00b2\2\u0250\u024e\3"+
		"\2\2\2\u0250\u0251\3\2\2\2\u0251\u025b\3\2\2\2\u0252\u0253\7I\2\2\u0253"+
		"\u025c\7\33\2\2\u0254\u0256\7\33\2\2\u0255\u0254\3\2\2\2\u0255\u0256\3"+
		"\2\2\2\u0256\u0257\3\2\2\2\u0257\u0258\7:\2\2\u0258\u025c\7\66\2\2\u0259"+
		"\u025a\7:\2\2\u025a\u025c\7\34\2\2\u025b\u0252\3\2\2\2\u025b\u0255\3\2"+
		"\2\2\u025b\u0259\3\2\2\2\u025b\u025c\3\2\2\2\u025c\u0263\3\2\2\2\u025d"+
		"\u025f\7*\2\2\u025e\u0260\7!\2\2\u025f\u025e\3\2\2\2\u025f\u0260\3\2\2"+
		"\2\u0260\u0261\3\2\2\2\u0261\u0264\7Y\2\2\u0262\u0264\7g\2\2\u0263\u025d"+
		"\3\2\2\2\u0263\u0262\3\2\2\2\u0263\u0264\3\2\2\2\u0264\u0267\3\2\2\2\u0265"+
		"\u0266\7y\2\2\u0266\u0268\5\u00f2z\2\u0267\u0265\3\2\2\2\u0267\u0268\3"+
		"\2\2\2\u0268\u0269\3\2\2\2\u0269\u026a\7\'\2\2\u026a\u026b\7V\2\2\u026b"+
		"\u026c\5f\64\2\u026c\u0271\7\u011d\2\2\u026d\u026f\5f\64\2\u026e\u0270"+
		"\7\u0116\2\2\u026f\u026e\3\2\2\2\u026f\u0270\3\2\2\2\u0270\u0272\3\2\2"+
		"\2\u0271\u026d\3\2\2\2\u0271\u0272\3\2\2\2\u0272\u0273\3\2\2\2\u0273\u0274"+
		"\7\u011e\2\2\u0274\23\3\2\2\2\u0275\u0279\7^\2\2\u0276\u0277\7\61\2\2"+
		"\u0277\u0278\7\u00bb\2\2\u0278\u027a\7*\2\2\u0279\u0276\3\2\2\2\u0279"+
		"\u027a\3\2\2\2\u027a\u0284\3\2\2\2\u027b\u027d\t\4\2\2\u027c\u027b\3\2"+
		"\2\2\u027d\u027e\3\2\2\2\u027e\u027c\3\2\2\2\u027e\u027f\3\2\2\2\u027f"+
		"\u0285\3\2\2\2\u0280\u0282\7\6\2\2\u0281\u0283\7U\2\2\u0282\u0281\3\2"+
		"\2\2\u0282\u0283\3\2\2\2\u0283\u0285\3\2\2\2\u0284\u027c\3\2\2\2\u0284"+
		"\u0280\3\2\2\2\u0285\u0286\3\2\2\2\u0286\u0298\7M\2\2\u0287\u0289\7i\2"+
		"\2\u0288\u0287\3\2\2\2\u0288\u0289\3\2\2\2\u0289\u028a\3\2\2\2\u028a\u028c"+
		"\5\u0162\u00b2\2\u028b\u0288\3\2\2\2\u028c\u028d\3\2\2\2\u028d\u028b\3"+
		"\2\2\2\u028d\u028e\3\2\2\2\u028e\u0299\3\2\2\2\u028f\u0290\7\6\2\2\u0290"+
		"\u0291\7\u00d6\2\2\u0291\u0292\7\67\2\2\u0292\u0294\7a\2\2\u0293\u0295"+
		"\5f\64\2\u0294\u0293\3\2\2\2\u0295\u0296\3\2\2\2\u0296\u0294\3\2\2\2\u0296"+
		"\u0297\3\2\2\2\u0297\u0299\3\2\2\2\u0298\u028b\3\2\2\2\u0298\u028f\3\2"+
		"\2\2\u0299\u029a\3\2\2\2\u029a\u029b\5\26\f\2\u029b\u03f1\3\2\2\2\u029c"+
		"\u02a0\7^\2\2\u029d\u029e\7\61\2\2\u029e\u029f\7\u00bb\2\2\u029f\u02a1"+
		"\7*\2\2\u02a0\u029d\3\2\2\2\u02a0\u02a1\3\2\2\2\u02a1\u02c1\3\2\2\2\u02a2"+
		"\u02a3\t\5\2\2\u02a3\u02a8\7\u011d\2\2\u02a4\u02a6\5f\64\2\u02a5\u02a7"+
		"\7\u0116\2\2\u02a6\u02a5\3\2\2\2\u02a6\u02a7\3\2\2\2\u02a7\u02a9\3\2\2"+
		"\2\u02a8\u02a4\3\2\2\2\u02a9\u02aa\3\2\2\2\u02aa\u02a8\3\2\2\2\u02aa\u02ab"+
		"\3\2\2\2\u02ab\u02ac\3\2\2\2\u02ac\u02ad\7\u011e\2\2\u02ad\u02af\3\2\2"+
		"\2\u02ae\u02a2\3\2\2\2\u02af\u02b0\3\2\2\2\u02b0\u02ae\3\2\2\2\u02b0\u02b1"+
		"\3\2\2\2\u02b1\u02c2\3\2\2\2\u02b2\u02b4\7\6\2\2\u02b3\u02b5\7U\2\2\u02b4"+
		"\u02b3\3\2\2\2\u02b4\u02b5\3\2\2\2\u02b5\u02b6\3\2\2\2\u02b6\u02bb\7\u011d"+
		"\2\2\u02b7\u02b9\5f\64\2\u02b8\u02ba\7\u0116\2\2\u02b9\u02b8\3\2\2\2\u02b9"+
		"\u02ba\3\2\2\2\u02ba\u02bc\3\2\2\2\u02bb\u02b7\3\2\2\2\u02bc\u02bd\3\2"+
		"\2\2\u02bd\u02bb\3\2\2\2\u02bd\u02be\3\2\2\2\u02be\u02bf\3\2\2\2\u02bf"+
		"\u02c0\7\u011e\2\2\u02c0\u02c2\3\2\2\2\u02c1\u02ae\3\2\2\2\u02c1\u02b2"+
		"\3\2\2\2\u02c2\u02c3\3\2\2\2\u02c3\u02c5\7M\2\2\u02c4\u02c6\7i\2\2\u02c5"+
		"\u02c4\3\2\2\2\u02c5\u02c6\3\2\2\2\u02c6\u02cb\3\2\2\2\u02c7\u02c9\5\u0162"+
		"\u00b2\2\u02c8\u02ca\7\u0116\2\2\u02c9\u02c8\3\2\2\2\u02c9\u02ca\3\2\2"+
		"\2\u02ca\u02cc\3\2\2\2\u02cb\u02c7\3\2\2\2\u02cc\u02cd\3\2\2\2\u02cd\u02cb"+
		"\3\2\2\2\u02cd\u02ce\3\2\2\2\u02ce\u02cf\3\2\2\2\u02cf\u02d0\5\26\f\2"+
		"\u02d0\u03f1\3\2\2\2\u02d1\u02d5\7^\2\2\u02d2\u02d3\7\61\2\2\u02d3\u02d4"+
		"\7\u00bb\2\2\u02d4\u02d6\7*\2\2\u02d5\u02d2\3\2\2\2\u02d5\u02d6\3\2\2"+
		"\2\u02d6\u02e0\3\2\2\2\u02d7\u02d9\t\6\2\2\u02d8\u02d7\3\2\2\2\u02d9\u02da"+
		"\3\2\2\2\u02da\u02d8\3\2\2\2\u02da\u02db\3\2\2\2\u02db\u02e1\3\2\2\2\u02dc"+
		"\u02de\7\6\2\2\u02dd\u02df\7U\2\2\u02de\u02dd\3\2\2\2\u02de\u02df\3\2"+
		"\2\2\u02df\u02e1\3\2\2\2\u02e0\u02d8\3\2\2\2\u02e0\u02dc\3\2\2\2\u02e1"+
		"\u02e2\3\2\2\2\u02e2\u02f8\7M\2\2\u02e3\u02e8\7b\2\2\u02e4\u02e6\5\u0162"+
		"\u00b2\2\u02e5\u02e7\7\u0116\2\2\u02e6\u02e5\3\2\2\2\u02e6\u02e7\3\2\2"+
		"\2\u02e7\u02e9\3\2\2\2\u02e8\u02e4\3\2\2\2\u02e9\u02ea\3\2\2\2\u02ea\u02e8"+
		"\3\2\2\2\u02ea\u02eb\3\2\2\2\u02eb\u02f9\3\2\2\2\u02ec\u02ed\7\6\2\2\u02ed"+
		"\u02ee\7c\2\2\u02ee\u02ef\7\67\2\2\u02ef\u02f4\7a\2\2\u02f0\u02f2\5f\64"+
		"\2\u02f1\u02f3\7\u0116\2\2\u02f2\u02f1\3\2\2\2\u02f2\u02f3\3\2\2\2\u02f3"+
		"\u02f5\3\2\2\2\u02f4\u02f0\3\2\2\2\u02f5\u02f6\3\2\2\2\u02f6\u02f4\3\2"+
		"\2\2\u02f6\u02f7\3\2\2\2\u02f7\u02f9\3\2\2\2\u02f8\u02e3\3\2\2\2\u02f8"+
		"\u02ec\3\2\2\2\u02f9\u02fa\3\2\2\2\u02fa\u02fb\5\26\f\2\u02fb\u03f1\3"+
		"\2\2\2\u02fc\u0300\7^\2\2\u02fd\u02fe\7\61\2\2\u02fe\u02ff\7\u00bb\2\2"+
		"\u02ff\u0301\7*\2\2\u0300\u02fd\3\2\2\2\u0300\u0301\3\2\2\2\u0301\u030b"+
		"\3\2\2\2\u0302\u0304\t\7\2\2\u0303\u0302\3\2\2\2\u0304\u0305\3\2\2\2\u0305"+
		"\u0303\3\2\2\2\u0305\u0306\3\2\2\2\u0306\u030c\3\2\2\2\u0307\u0309\7\6"+
		"\2\2\u0308\u030a\7U\2\2\u0309\u0308\3\2\2\2\u0309\u030a\3\2\2\2\u030a"+
		"\u030c\3\2\2\2\u030b\u0303\3\2\2\2\u030b\u0307\3\2\2\2\u030c\u030d\3\2"+
		"\2\2\u030d\u030e\7M\2\2\u030e\u0313\7\30\2\2\u030f\u0311\5f\64\2\u0310"+
		"\u0312\7\u0116\2\2\u0311\u0310\3\2\2\2\u0311\u0312\3\2\2\2\u0312\u0314"+
		"\3\2\2\2\u0313\u030f\3\2\2\2\u0314\u0315\3\2\2\2\u0315\u0313\3\2\2\2\u0315"+
		"\u0316\3\2\2\2\u0316\u0317\3\2\2\2\u0317\u0318\5\26\f\2\u0318\u03f1\3"+
		"\2\2\2\u0319\u031d\7^\2\2\u031a\u031b\7\61\2\2\u031b\u031c\7\u00bb\2\2"+
		"\u031c\u031e\7*\2\2\u031d\u031a\3\2\2\2\u031d\u031e\3\2\2\2\u031e\u0324"+
		"\3\2\2\2\u031f\u0325\7u\2\2\u0320\u0322\7\6\2\2\u0321\u0323\7U\2\2\u0322"+
		"\u0321\3\2\2\2\u0322\u0323\3\2\2\2\u0323\u0325\3\2\2\2\u0324\u031f\3\2"+
		"\2\2\u0324\u0320\3\2\2\2\u0325\u0326\3\2\2\2\u0326\u0327\7M\2\2\u0327"+
		"\u0328\7+\2\2\u0328\u0329\7\u008e\2\2\u0329\u032e\7\u00e6\2\2\u032a\u032c"+
		"\5\u0162\u00b2\2\u032b\u032d\7\u0116\2\2\u032c\u032b\3\2\2\2\u032c\u032d"+
		"\3\2\2\2\u032d\u032f\3\2\2\2\u032e\u032a\3\2\2\2\u032f\u0330\3\2\2\2\u0330"+
		"\u032e\3\2\2\2\u0330\u0331\3\2\2\2\u0331\u0332\3\2\2\2\u0332\u0333\5\26"+
		"\f\2\u0333\u03f1\3\2\2\2\u0334\u0338\7^\2\2\u0335\u0336\7\61\2\2\u0336"+
		"\u0337\7\u00bb\2\2\u0337\u0339\7*\2\2\u0338\u0335\3\2\2\2\u0338\u0339"+
		"\3\2\2\2\u0339\u033f\3\2\2\2\u033a\u0340\7u\2\2\u033b\u033d\7\6\2\2\u033c"+
		"\u033e\7U\2\2\u033d\u033c\3\2\2\2\u033d\u033e\3\2\2\2\u033e\u0340\3\2"+
		"\2\2\u033f\u033a\3\2\2\2\u033f\u033b\3\2\2\2\u0340\u0341\3\2\2\2\u0341"+
		"\u0342\7M\2\2\u0342\u0343\7+\2\2\u0343\u0348\7\u00cc\2\2\u0344\u0346\5"+
		"f\64\2\u0345\u0347\7\u0116\2\2\u0346\u0345\3\2\2\2\u0346\u0347\3\2\2\2"+
		"\u0347\u0349\3\2\2\2\u0348\u0344\3\2\2\2\u0349\u034a\3\2\2\2\u034a\u0348"+
		"\3\2\2\2\u034a\u034b\3\2\2\2\u034b\u034c\3\2\2\2\u034c\u034d\5\26\f\2"+
		"\u034d\u03f1\3\2\2\2\u034e\u0352\7^\2\2\u034f\u0350\7\61\2\2\u0350\u0351"+
		"\7\u00bb\2\2\u0351\u0353\7*\2\2\u0352\u034f\3\2\2\2\u0352\u0353\3\2\2"+
		"\2\u0353\u0359\3\2\2\2\u0354\u035a\7\'\2\2\u0355\u0357\7\6\2\2\u0356\u0358"+
		"\7U\2\2\u0357\u0356\3\2\2\2\u0357\u0358\3\2\2\2\u0358\u035a\3\2\2\2\u0359"+
		"\u0354\3\2\2\2\u0359\u0355\3\2\2\2\u035a\u035b\3\2\2\2\u035b\u035e\7M"+
		"\2\2\u035c\u035f\5 \21\2\u035d\u035f\5\"\22\2\u035e\u035c\3\2\2\2\u035e"+
		"\u035d\3\2\2\2\u035f\u0360\3\2\2\2\u0360\u0361\5\26\f\2\u0361\u03f1\3"+
		"\2\2\2\u0362\u0366\7^\2\2\u0363\u0364\7\61\2\2\u0364\u0365\7\u00bb\2\2"+
		"\u0365\u0367\7*\2\2\u0366\u0363\3\2\2\2\u0366\u0367\3\2\2\2\u0367\u036d"+
		"\3\2\2\2\u0368\u036e\7u\2\2\u0369\u036b\7\6\2\2\u036a\u036c\7U\2\2\u036b"+
		"\u036a\3\2\2\2\u036b\u036c\3\2\2\2\u036c\u036e\3\2\2\2\u036d\u0368\3\2"+
		"\2\2\u036d\u0369\3\2\2\2\u036e\u036f\3\2\2\2\u036f\u0370\7M\2\2\u0370"+
		"\u0375\7\u00a9\2\2\u0371\u0373\5f\64\2\u0372\u0374\7\u0116\2\2\u0373\u0372"+
		"\3\2\2\2\u0373\u0374\3\2\2\2\u0374\u0376\3\2\2\2\u0375\u0371\3\2\2\2\u0376"+
		"\u0377\3\2\2\2\u0377\u0375\3\2\2\2\u0377\u0378\3\2\2\2\u0378\u0379\3\2"+
		"\2\2\u0379\u037a\5\26\f\2\u037a\u03f1\3\2\2\2\u037b\u037f\7^\2\2\u037c"+
		"\u037d\7\61\2\2\u037d\u037e\7\u00bb\2\2\u037e\u0380\7*\2\2\u037f\u037c"+
		"\3\2\2\2\u037f\u0380\3\2\2\2\u0380\u038e\3\2\2\2\u0381\u0387\7d\2\2\u0382"+
		"\u0384\7t\2\2\u0383\u0385\7\u0116\2\2\u0384\u0383\3\2\2\2\u0384\u0385"+
		"\3\2\2\2\u0385\u0387\3\2\2\2\u0386\u0381\3\2\2\2\u0386\u0382\3\2\2\2\u0387"+
		"\u0388\3\2\2\2\u0388\u0386\3\2\2\2\u0388\u0389\3\2\2\2\u0389\u038f\3\2"+
		"\2\2\u038a\u038c\7\6\2\2\u038b\u038d\7U\2\2\u038c\u038b\3\2\2\2\u038c"+
		"\u038d\3\2\2\2\u038d\u038f\3\2\2\2\u038e\u0386\3\2\2\2\u038e\u038a\3\2"+
		"\2\2\u038f\u0390\3\2\2\2\u0390\u0391\7M\2\2\u0391\u0392\7\u00aa\2\2\u0392"+
		"\u0397\7\u00ba\2\2\u0393\u0395\5f\64\2\u0394\u0396\7\u0116\2\2\u0395\u0394"+
		"\3\2\2\2\u0395\u0396\3\2\2\2\u0396\u0398\3\2\2\2\u0397\u0393\3\2\2\2\u0398"+
		"\u0399\3\2\2\2\u0399\u0397\3\2\2\2\u0399\u039a\3\2\2\2\u039a\u039b\3\2"+
		"\2\2\u039b\u039c\5\26\f\2\u039c\u03f1\3\2\2\2\u039d\u03a1\7^\2\2\u039e"+
		"\u039f\7\61\2\2\u039f\u03a0\7\u00bb\2\2\u03a0\u03a2\7*\2\2\u03a1\u039e"+
		"\3\2\2\2\u03a1\u03a2\3\2\2\2\u03a2\u03af\3\2\2\2\u03a3\u03a5\t\b\2\2\u03a4"+
		"\u03a6\7\u0116\2\2\u03a5\u03a4\3\2\2\2\u03a5\u03a6\3\2\2\2\u03a6\u03a8"+
		"\3\2\2\2\u03a7\u03a3\3\2\2\2\u03a8\u03a9\3\2\2\2\u03a9\u03a7\3\2\2\2\u03a9"+
		"\u03aa\3\2\2\2\u03aa\u03b0\3\2\2\2\u03ab\u03ad\7\6\2\2\u03ac\u03ae\7U"+
		"\2\2\u03ad\u03ac\3\2\2\2\u03ad\u03ae\3\2\2\2\u03ae\u03b0\3\2\2\2\u03af"+
		"\u03a7\3\2\2\2\u03af\u03ab\3\2\2\2\u03b0\u03b1\3\2\2\2\u03b1\u03b2\7M"+
		"\2\2\u03b2\u03b7\7a\2\2\u03b3\u03b5\5f\64\2\u03b4\u03b6\7\u0116\2\2\u03b5"+
		"\u03b4\3\2\2\2\u03b5\u03b6\3\2\2\2\u03b6\u03b8\3\2\2\2\u03b7\u03b3\3\2"+
		"\2\2\u03b8\u03b9\3\2\2\2\u03b9\u03b7\3\2\2\2\u03b9\u03ba\3\2\2\2\u03ba"+
		"\u03bb\3\2\2\2\u03bb\u03bc\5\26\f\2\u03bc\u03f1\3\2\2\2\u03bd\u03c1\7"+
		"^\2\2\u03be\u03bf\7\61\2\2\u03bf\u03c0\7\u00bb\2\2\u03c0\u03c2\7*\2\2"+
		"\u03c1\u03be\3\2\2\2\u03c1\u03c2\3\2\2\2\u03c2\u03c8\3\2\2\2\u03c3\u03c9"+
		"\7\26\2\2\u03c4\u03c6\7\6\2\2\u03c5\u03c7\7U\2\2\u03c6\u03c5\3\2\2\2\u03c6"+
		"\u03c7\3\2\2\2\u03c7\u03c9\3\2\2\2\u03c8\u03c3\3\2\2\2\u03c8\u03c4\3\2"+
		"\2\2\u03c9\u03ca\3\2\2\2\u03ca\u03cb\7M\2\2\u03cb\u03d0\7\u00d5\2\2\u03cc"+
		"\u03ce\5f\64\2\u03cd\u03cf\7\u0116\2\2\u03ce\u03cd\3\2\2\2\u03ce\u03cf"+
		"\3\2\2\2\u03cf\u03d1\3\2\2\2\u03d0\u03cc\3\2\2\2\u03d1\u03d2\3\2\2\2\u03d2"+
		"\u03d0\3\2\2\2\u03d2\u03d3\3\2\2\2\u03d3\u03d4\3\2\2\2\u03d4\u03d5\5\26"+
		"\f\2\u03d5\u03f1\3\2\2\2\u03d6\u03da\7^\2\2\u03d7\u03d8\7}\2\2\u03d8\u03d9"+
		"\7\u00bb\2\2\u03d9\u03db\7*\2\2\u03da\u03d7\3\2\2\2\u03da\u03db\3\2\2"+
		"\2\u03db\u03e0\3\2\2\2\u03dc\u03de\5f\64\2\u03dd\u03df\7\u0116\2\2\u03de"+
		"\u03dd\3\2\2\2\u03de\u03df\3\2\2\2\u03df\u03e1\3\2\2\2\u03e0\u03dc\3\2"+
		"\2\2\u03e1\u03e2\3\2\2\2\u03e2\u03e0\3\2\2\2\u03e2\u03e3\3\2\2\2\u03e3"+
		"\u03e4\3\2\2\2\u03e4\u03e9\7/\2\2\u03e5\u03e7\5f\64\2\u03e6\u03e8\7\u0116"+
		"\2\2\u03e7\u03e6\3\2\2\2\u03e7\u03e8\3\2\2\2\u03e8\u03ea\3\2\2\2\u03e9"+
		"\u03e5\3\2\2\2\u03ea\u03eb\3\2\2\2\u03eb\u03e9\3\2\2\2\u03eb\u03ec\3\2"+
		"\2\2\u03ec\u03ee\3\2\2\2\u03ed\u03ef\t\t\2\2\u03ee\u03ed\3\2\2\2\u03ee"+
		"\u03ef\3\2\2\2\u03ef\u03f1\3\2\2\2\u03f0\u0275\3\2\2\2\u03f0\u029c\3\2"+
		"\2\2\u03f0\u02d1\3\2\2\2\u03f0\u02fc\3\2\2\2\u03f0\u0319\3\2\2\2\u03f0"+
		"\u0334\3\2\2\2\u03f0\u034e\3\2\2\2\u03f0\u0362\3\2\2\2\u03f0\u037b\3\2"+
		"\2\2\u03f0\u039d\3\2\2\2\u03f0\u03bd\3\2\2\2\u03f0\u03d6\3\2\2\2\u03f1"+
		"\25\3\2\2\2\u03f2\u03fb\7/\2\2\u03f3\u03f5\7\62\2\2\u03f4\u03f3\3\2\2"+
		"\2\u03f4\u03f5\3\2\2\2\u03f5\u03f6\3\2\2\2\u03f6\u03fc\5f\64\2\u03f7\u03f9"+
		"\7\u00c3\2\2\u03f8\u03fa\7\u0116\2\2\u03f9\u03f8\3\2\2\2\u03f9\u03fa\3"+
		"\2\2\2\u03fa\u03fc\3\2\2\2\u03fb\u03f4\3\2\2\2\u03fb\u03f7\3\2\2\2\u03fc"+
		"\u03fd\3\2\2\2\u03fd\u03fb\3\2\2\2\u03fd\u03fe\3\2\2\2\u03fe\u0400\3\2"+
		"\2\2\u03ff\u0401\t\t\2\2\u0400\u03ff\3\2\2\2\u0400\u0401\3\2\2\2\u0401"+
		"\27\3\2\2\2\u0402\u040c\7\61\2\2\u0403\u0405\t\4\2\2\u0404\u0403\3\2\2"+
		"\2\u0405\u0406\3\2\2\2\u0406\u0404\3\2\2\2\u0406\u0407\3\2\2\2\u0407\u040d"+
		"\3\2\2\2\u0408\u040a\7\6\2\2\u0409\u040b\7U\2\2\u040a\u0409\3\2\2\2\u040a"+
		"\u040b\3\2\2\2\u040b\u040d\3\2\2\2\u040c\u0404\3\2\2\2\u040c\u0408\3\2"+
		"\2\2\u040d\u040e\3\2\2\2\u040e\u0426\7M\2\2\u040f\u0411\7i\2\2\u0410\u040f"+
		"\3\2\2\2\u0410\u0411\3\2\2\2\u0411\u0416\3\2\2\2\u0412\u0414\5\u0162\u00b2"+
		"\2\u0413\u0415\7\u0116\2\2\u0414\u0413\3\2\2\2\u0414\u0415\3\2\2\2\u0415"+
		"\u0417\3\2\2\2\u0416\u0412\3\2\2\2\u0417\u0418\3\2\2\2\u0418\u0416\3\2"+
		"\2\2\u0418\u0419\3\2\2\2\u0419\u0427\3\2\2\2\u041a\u041b\7\6\2\2\u041b"+
		"\u041c\7\u00d6\2\2\u041c\u041d\7\67\2\2\u041d\u0422\7a\2\2\u041e\u0420"+
		"\5f\64\2\u041f\u0421\7\u0116\2\2\u0420\u041f\3\2\2\2\u0420\u0421\3\2\2"+
		"\2\u0421\u0423\3\2\2\2\u0422\u041e\3\2\2\2\u0423\u0424\3\2\2\2\u0424\u0422"+
		"\3\2\2\2\u0424\u0425\3\2\2\2\u0425\u0427\3\2\2\2\u0426\u0410\3\2\2\2\u0426"+
		"\u041a\3\2\2\2\u0427\u0428\3\2\2\2\u0428\u0429\5\32\16\2\u0429\u0548\3"+
		"\2\2\2\u042a\u0444\7\61\2\2\u042b\u0430\t\5\2\2\u042c\u042e\5f\64\2\u042d"+
		"\u042f\7\u0116\2\2\u042e\u042d\3\2\2\2\u042e\u042f\3\2\2\2\u042f\u0431"+
		"\3\2\2\2\u0430\u042c\3\2\2\2\u0431\u0432\3\2\2\2\u0432\u0430\3\2\2\2\u0432"+
		"\u0433\3\2\2\2\u0433\u0435\3\2\2\2\u0434\u042b\3\2\2\2\u0435\u0436\3\2"+
		"\2\2\u0436\u0434\3\2\2\2\u0436\u0437\3\2\2\2\u0437\u0445\3\2\2\2\u0438"+
		"\u043a\7\6\2\2\u0439\u043b\7U\2\2\u043a\u0439\3\2\2\2\u043a\u043b\3\2"+
		"\2\2\u043b\u0440\3\2\2\2\u043c\u043e\5f\64\2\u043d\u043f\7\u0116\2\2\u043e"+
		"\u043d\3\2\2\2\u043e\u043f\3\2\2\2\u043f\u0441\3\2\2\2\u0440\u043c\3\2"+
		"\2\2\u0441\u0442\3\2\2\2\u0442\u0440\3\2\2\2\u0442\u0443\3\2\2\2\u0443"+
		"\u0445\3\2\2\2\u0444\u0434\3\2\2\2\u0444\u0438\3\2\2\2\u0445\u0446\3\2"+
		"\2\2\u0446\u044e\7M\2\2\u0447\u0449\7i\2\2\u0448\u0447\3\2\2\2\u0448\u0449"+
		"\3\2\2\2\u0449\u044a\3\2\2\2\u044a\u044c\5\u0162\u00b2\2\u044b\u044d\7"+
		"\u0116\2\2\u044c\u044b\3\2\2\2\u044c\u044d\3\2\2\2\u044d\u044f\3\2\2\2"+
		"\u044e\u0448\3\2\2\2\u044f\u0450\3\2\2\2\u0450\u044e\3\2\2\2\u0450\u0451"+
		"\3\2\2\2\u0451\u0452\3\2\2\2\u0452\u0453\5\32\16\2\u0453\u0548\3\2\2\2"+
		"\u0454\u0461\7\61\2\2\u0455\u0457\t\6\2\2\u0456\u0458\7\u0116\2\2\u0457"+
		"\u0456\3\2\2\2\u0457\u0458\3\2\2\2\u0458\u045a\3\2\2\2\u0459\u0455\3\2"+
		"\2\2\u045a\u045b\3\2\2\2\u045b\u0459\3\2\2\2\u045b\u045c\3\2\2\2\u045c"+
		"\u0462\3\2\2\2\u045d\u045f\7\6\2\2\u045e\u0460\7U\2\2\u045f\u045e\3\2"+
		"\2\2\u045f\u0460\3\2\2\2\u0460\u0462\3\2\2\2\u0461\u0459\3\2\2\2\u0461"+
		"\u045d\3\2\2\2\u0462\u0463\3\2\2\2\u0463\u0479\7M\2\2\u0464\u0465\7b\2"+
		"\2\u0465\u0467\5f\64\2\u0466\u0468\7\u0116\2\2\u0467\u0466\3\2\2\2\u0467"+
		"\u0468\3\2\2\2\u0468\u046a\3\2\2\2\u0469\u0464\3\2\2\2\u046a\u046b\3\2"+
		"\2\2\u046b\u0469\3\2\2\2\u046b\u046c\3\2\2\2\u046c\u047a\3\2\2\2\u046d"+
		"\u046e\7\6\2\2\u046e\u046f\7c\2\2\u046f\u0470\7\67\2\2\u0470\u0475\7a"+
		"\2\2\u0471\u0473\5f\64\2\u0472\u0474\7\u0116\2\2\u0473\u0472\3\2\2\2\u0473"+
		"\u0474\3\2\2\2\u0474\u0476\3\2\2\2\u0475\u0471\3\2\2\2\u0476\u0477\3\2"+
		"\2\2\u0477\u0475\3\2\2\2\u0477\u0478\3\2\2\2\u0478\u047a\3\2\2\2\u0479"+
		"\u0469\3\2\2\2\u0479\u046d\3\2\2\2\u047a\u047b\3\2\2\2\u047b\u047c\5\32"+
		"\16\2\u047c\u0548\3\2\2\2\u047d\u048a\7\61\2\2\u047e\u0480\t\7\2\2\u047f"+
		"\u0481\7\u0116\2\2\u0480\u047f\3\2\2\2\u0480\u0481\3\2\2\2\u0481\u0483"+
		"\3\2\2\2\u0482\u047e\3\2\2\2\u0483\u0484\3\2\2\2\u0484\u0482\3\2\2\2\u0484"+
		"\u0485\3\2\2\2\u0485\u048b\3\2\2\2\u0486\u0488\7\6\2\2\u0487\u0489\7U"+
		"\2\2\u0488\u0487\3\2\2\2\u0488\u0489\3\2\2\2\u0489\u048b\3\2\2\2\u048a"+
		"\u0482\3\2\2\2\u048a\u0486\3\2\2\2\u048b\u048c\3\2\2\2\u048c\u048d\7M"+
		"\2\2\u048d\u0492\7\30\2\2\u048e\u0490\5f\64\2\u048f\u0491\7\u0116\2\2"+
		"\u0490\u048f\3\2\2\2\u0490\u0491\3\2\2\2\u0491\u0493\3\2\2\2\u0492\u048e"+
		"\3\2\2\2\u0493\u0494\3\2\2\2\u0494\u0492\3\2\2\2\u0494\u0495\3\2\2\2\u0495"+
		"\u0496\3\2\2\2\u0496\u0497\5\32\16\2\u0497\u0548\3\2\2\2\u0498\u049e\7"+
		"\61\2\2\u0499\u049f\7u\2\2\u049a\u049c\7\6\2\2\u049b\u049d\7U\2\2\u049c"+
		"\u049b\3\2\2\2\u049c\u049d\3\2\2\2\u049d\u049f\3\2\2\2\u049e\u0499\3\2"+
		"\2\2\u049e\u049a\3\2\2\2\u049f\u04a0\3\2\2\2\u04a0\u04a1\7M\2\2\u04a1"+
		"\u04a2\7+\2\2\u04a2\u04a3\7\u008e\2\2\u04a3\u04a8\7\u00e6\2\2\u04a4\u04a6"+
		"\5f\64\2\u04a5\u04a7\7\u0116\2\2\u04a6\u04a5\3\2\2\2\u04a6\u04a7\3\2\2"+
		"\2\u04a7\u04a9\3\2\2\2\u04a8\u04a4\3\2\2\2\u04a9\u04aa\3\2\2\2\u04aa\u04a8"+
		"\3\2\2\2\u04aa\u04ab\3\2\2\2\u04ab\u04ac\3\2\2\2\u04ac\u04ad\5\32\16\2"+
		"\u04ad\u0548\3\2\2\2\u04ae\u04b4\7\61\2\2\u04af\u04b5\7u\2\2\u04b0\u04b2"+
		"\7\6\2\2\u04b1\u04b3\7U\2\2\u04b2\u04b1\3\2\2\2\u04b2\u04b3\3\2\2\2\u04b3"+
		"\u04b5\3\2\2\2\u04b4\u04af\3\2\2\2\u04b4\u04b0\3\2\2\2\u04b5\u04b6\3\2"+
		"\2\2\u04b6\u04b7\7M\2\2\u04b7\u04b8\7+\2\2\u04b8\u04bd\7\u00cc\2\2\u04b9"+
		"\u04bb\5f\64\2\u04ba\u04bc\7\u0116\2\2\u04bb\u04ba\3\2\2\2\u04bb\u04bc"+
		"\3\2\2\2\u04bc\u04be\3\2\2\2\u04bd\u04b9\3\2\2\2\u04be\u04bf\3\2\2\2\u04bf"+
		"\u04bd\3\2\2\2\u04bf\u04c0\3\2\2\2\u04c0\u04c1\3\2\2\2\u04c1\u04c2\5\32"+
		"\16\2\u04c2\u0548\3\2\2\2\u04c3\u04c9\7\61\2\2\u04c4\u04ca\7\'\2\2\u04c5"+
		"\u04c7\7\6\2\2\u04c6\u04c8\7U\2\2\u04c7\u04c6\3\2\2\2\u04c7\u04c8\3\2"+
		"\2\2\u04c8\u04ca\3\2\2\2\u04c9\u04c4\3\2\2\2\u04c9\u04c5\3\2\2\2\u04ca"+
		"\u04cb\3\2\2\2\u04cb\u04ce\7M\2\2\u04cc\u04cf\5 \21\2\u04cd\u04cf\5\""+
		"\22\2\u04ce\u04cc\3\2\2\2\u04ce\u04cd\3\2\2\2\u04cf\u04d0\3\2\2\2\u04d0"+
		"\u04d1\5\32\16\2\u04d1\u0548\3\2\2\2\u04d2\u04d8\7\61\2\2\u04d3\u04d9"+
		"\7u\2\2\u04d4\u04d6\7\6\2\2\u04d5\u04d7\7U\2\2\u04d6\u04d5\3\2\2\2\u04d6"+
		"\u04d7\3\2\2\2\u04d7\u04d9\3\2\2\2\u04d8\u04d3\3\2\2\2\u04d8\u04d4\3\2"+
		"\2\2\u04d9\u04da\3\2\2\2\u04da\u04db\7M\2\2\u04db\u04e0\7\u00a9\2\2\u04dc"+
		"\u04de\5f\64\2\u04dd\u04df\7\u0116\2\2\u04de\u04dd\3\2\2\2\u04de\u04df"+
		"\3\2\2\2\u04df\u04e1\3\2\2\2\u04e0\u04dc\3\2\2\2\u04e1\u04e2\3\2\2\2\u04e2"+
		"\u04e0\3\2\2\2\u04e2\u04e3\3\2\2\2\u04e3\u04e4\3\2\2\2\u04e4\u04e5\5\32"+
		"\16\2\u04e5\u0548\3\2\2\2\u04e6\u04f3\7\61\2\2\u04e7\u04e9\t\n\2\2\u04e8"+
		"\u04ea\7\u0116\2\2\u04e9\u04e8\3\2\2\2\u04e9\u04ea\3\2\2\2\u04ea\u04ec"+
		"\3\2\2\2\u04eb\u04e7\3\2\2\2\u04ec\u04ed\3\2\2\2\u04ed\u04eb\3\2\2\2\u04ed"+
		"\u04ee\3\2\2\2\u04ee\u04f4\3\2\2\2\u04ef\u04f1\7\6\2\2\u04f0\u04f2\7U"+
		"\2\2\u04f1\u04f0\3\2\2\2\u04f1\u04f2\3\2\2\2\u04f2\u04f4\3\2\2\2\u04f3"+
		"\u04eb\3\2\2\2\u04f3\u04ef\3\2\2\2\u04f4\u04f5\3\2\2\2\u04f5\u04f6\7M"+
		"\2\2\u04f6\u04f7\7\u00aa\2\2\u04f7\u04fc\7\u00ba\2\2\u04f8\u04fa\5f\64"+
		"\2\u04f9\u04fb\7\u0116\2\2\u04fa\u04f9\3\2\2\2\u04fa\u04fb\3\2\2\2\u04fb"+
		"\u04fd\3\2\2\2\u04fc\u04f8\3\2\2\2\u04fd\u04fe\3\2\2\2\u04fe\u04fc\3\2"+
		"\2\2\u04fe\u04ff\3\2\2\2\u04ff\u0500\3\2\2\2\u0500\u0501\5\32\16\2\u0501"+
		"\u0548\3\2\2\2\u0502\u050f\7\61\2\2\u0503\u0505\t\b\2\2\u0504\u0506\7"+
		"\u0116\2\2\u0505\u0504\3\2\2\2\u0505\u0506\3\2\2\2\u0506\u0508\3\2\2\2"+
		"\u0507\u0503\3\2\2\2\u0508\u0509\3\2\2\2\u0509\u0507\3\2\2\2\u0509\u050a"+
		"\3\2\2\2\u050a\u0510\3\2\2\2\u050b\u050d\7\6\2\2\u050c\u050e\7U\2\2\u050d"+
		"\u050c\3\2\2\2\u050d\u050e\3\2\2\2\u050e\u0510\3\2\2\2\u050f\u0507\3\2"+
		"\2\2\u050f\u050b\3\2\2\2\u0510\u0511\3\2\2\2\u0511\u0512\7M\2\2\u0512"+
		"\u0517\7a\2\2\u0513\u0515\5f\64\2\u0514\u0516\7\u0116\2\2\u0515\u0514"+
		"\3\2\2\2\u0515\u0516\3\2\2\2\u0516\u0518\3\2\2\2\u0517\u0513\3\2\2\2\u0518"+
		"\u0519\3\2\2\2\u0519\u0517\3\2\2\2\u0519\u051a\3\2\2\2\u051a\u051b\3\2"+
		"\2\2\u051b\u051c\5\32\16\2\u051c\u0548\3\2\2\2\u051d\u0523\7\61\2\2\u051e"+
		"\u0524\7\26\2\2\u051f\u0521\7\6\2\2\u0520\u0522\7U\2\2\u0521\u0520\3\2"+
		"\2\2\u0521\u0522\3\2\2\2\u0522\u0524\3\2\2\2\u0523\u051e\3\2\2\2\u0523"+
		"\u051f\3\2\2\2\u0524\u0525\3\2\2\2\u0525\u0526\7M\2\2\u0526\u052b\7\u00d5"+
		"\2\2\u0527\u0529\5f\64\2\u0528\u052a\7\u0116\2\2\u0529\u0528\3\2\2\2\u0529"+
		"\u052a\3\2\2\2\u052a\u052c\3\2\2\2\u052b\u0527\3\2\2\2\u052c\u052d\3\2"+
		"\2\2\u052d\u052b\3\2\2\2\u052d\u052e\3\2\2\2\u052e\u052f\3\2\2\2\u052f"+
		"\u0530\5\32\16\2\u0530\u0535\7\61\2\2\u0531\u0533\5f\64\2\u0532\u0534"+
		"\7\u0116\2\2\u0533\u0532\3\2\2\2\u0533\u0534\3\2\2\2\u0534\u0536\3\2\2"+
		"\2\u0535\u0531\3\2\2\2\u0536\u0537\3\2\2\2\u0537\u0535\3\2\2\2\u0537\u0538"+
		"\3\2\2\2\u0538\u0539\3\2\2\2\u0539\u053e\7\u00dd\2\2\u053a\u053c\5f\64"+
		"\2\u053b\u053d\7\u0116\2\2\u053c\u053b\3\2\2\2\u053c\u053d\3\2\2\2\u053d"+
		"\u053f\3\2\2\2\u053e\u053a\3\2\2\2\u053f\u0540\3\2\2\2\u0540\u053e\3\2"+
		"\2\2\u0540\u0541\3\2\2\2\u0541\u0545\3\2\2\2\u0542\u0543\7{\2\2\u0543"+
		"\u0544\7}\2\2\u0544\u0546\7\u00bb\2\2\u0545\u0542\3\2\2\2\u0545\u0546"+
		"\3\2\2\2\u0546\u0548\3\2\2\2\u0547\u0402\3\2\2\2\u0547\u042a\3\2\2\2\u0547"+
		"\u0454\3\2\2\2\u0547\u047d\3\2\2\2\u0547\u0498\3\2\2\2\u0547\u04ae\3\2"+
		"\2\2\u0547\u04c3\3\2\2\2\u0547\u04d2\3\2\2\2\u0547\u04e6\3\2\2\2\u0547"+
		"\u0502\3\2\2\2\u0547\u051d\3\2\2\2\u0548\31\3\2\2\2\u0549\u0554\7\u00dd"+
		"\2\2\u054a\u054c\7\62\2\2\u054b\u054a\3\2\2\2\u054b\u054c\3\2\2\2\u054c"+
		"\u054f\3\2\2\2\u054d\u0550\5f\64\2\u054e\u0550\7\u00c3\2\2\u054f\u054d"+
		"\3\2\2\2\u054f\u054e\3\2\2\2\u0550\u0552\3\2\2\2\u0551\u0553\7\u0116\2"+
		"\2\u0552\u0551\3\2\2\2\u0552\u0553\3\2\2\2\u0553\u0555\3\2\2\2\u0554\u054b"+
		"\3\2\2\2\u0555\u0556\3\2\2\2\u0556\u0554\3\2\2\2\u0556\u0557\3\2\2\2\u0557"+
		"\u055b\3\2\2\2\u0558\u0559\7{\2\2\u0559\u055a\7\61\2\2\u055a\u055c\7\u00bb"+
		"\2\2\u055b\u0558\3\2\2\2\u055b\u055c\3\2\2\2\u055c\33\3\2\2\2\u055d\u055e"+
		"\7\u0088\2\2\u055e\u05d6\7M\2\2\u055f\u0560\7\3\2\2\u0560\u0561\5\u0162"+
		"\u00b2\2\u0561\u0568\7\u011d\2\2\u0562\u0564\5x=\2\u0563\u0565\7\u0116"+
		"\2\2\u0564\u0563\3\2\2\2\u0564\u0565\3\2\2\2\u0565\u0567\3\2\2\2\u0566"+
		"\u0562\3\2\2\2\u0567\u056a\3\2\2\2\u0568\u0566\3\2\2\2\u0568\u0569\3\2"+
		"\2\2\u0569\u056b\3\2\2\2\u056a\u0568\3\2\2\2\u056b\u056c\7\u011e\2\2\u056c"+
		"\u05d7\3\2\2\2\u056d\u056e\7\17\2\2\u056e\u056f\7\u011d\2\2\u056f\u0570"+
		"\5x=\2\u0570\u0571\7\5\2\2\u0571\u0572\5x=\2\u0572\u0573\7\u011e\2\2\u0573"+
		"\u05d7\3\2\2\2\u0574\u0575\7\21\2\2\u0575\u05d7\5\u0162\u00b2\2\u0576"+
		"\u0577\7\u0087\2\2\u0577\u05d7\5\u0162\u00b2\2\u0578\u0579\7\23\2\2\u0579"+
		"\u057a\5\u0162\u00b2\2\u057a\u057b\7M\2\2\u057b\u057c\5\u0162\u00b2\2"+
		"\u057c\u05d7\3\2\2\2\u057d\u057e\7\25\2\2\u057e\u05d7\5\u0162\u00b2\2"+
		"\u057f\u0580\7\30\2\2\u0580\u05d7\5\u0162\u00b2\2\u0581\u0582\7 \2\2\u0582"+
		"\u05d7\5\u0162\u00b2\2\u0583\u0584\7(\2\2\u0584\u05d7\5\u0162\u00b2\2"+
		"\u0585\u0586\7+\2\2\u0586\u0587\7\u008e\2\2\u0587\u0588\7\u00e6\2\2\u0588"+
		"\u05d7\5\u0162\u00b2\2\u0589\u058a\7+\2\2\u058a\u058b\7i\2\2\u058b\u05d7"+
		"\5\u0162\u00b2\2\u058c\u058d\7-\2\2\u058d\u05d7\5\u01aa\u00d6\2\u058e"+
		"\u058f\7\u00a3\2\2\u058f\u05d7\5\u0162\u00b2\2\u0590\u0591\7\u00aa\2\2"+
		"\u0591\u0592\7\u00ba\2\2\u0592\u05d7\5f\64\2\u0593\u0594\7P\2\2\u0594"+
		"\u0595\5\u0162\u00b2\2\u0595\u0596\7\u011d\2\2\u0596\u0597\5x=\2\u0597"+
		"\u0598\7\u0116\2\2\u0598\u0599\5x=\2\u0599\u059a\7\u011e\2\2\u059a\u05d7"+
		"\3\2\2\2\u059b\u059c\7P\2\2\u059c\u059d\7\u0081\2\2\u059d\u059e\5\u0162"+
		"\u00b2\2\u059e\u059f\7v\2\2\u059f\u05a0\5f\64\2\u05a0\u05d7\3\2\2\2\u05a1"+
		"\u05a2\7P\2\2\u05a2\u05a3\7\u009b\2\2\u05a3\u05a4\5\u0162\u00b2\2\u05a4"+
		"\u05a5\7v\2\2\u05a5\u05a6\5f\64\2\u05a6\u05d7\3\2\2\2\u05a7\u05a9\7W\2"+
		"\2\u05a8\u05a7\3\2\2\2\u05a8\u05a9\3\2\2\2\u05a9\u05aa\3\2\2\2\u05aa\u05ab"+
		"\7\u00a9\2\2\u05ab\u05d7\5\u0162\u00b2\2\u05ac\u05ad\7X\2\2\u05ad\u05d7"+
		"\5\u0162\u00b2\2\u05ae\u05af\7`\2\2\u05af\u05b0\5\u0162\u00b2\2\u05b0"+
		"\u05b1\7M\2\2\u05b1\u05b2\5\u0162\u00b2\2\u05b2\u05d7\3\2\2\2\u05b3\u05b4"+
		"\7a\2\2\u05b4\u05d7\5\u0162\u00b2\2\u05b5\u05b6\7b\2\2\u05b6\u05d7\5\u0162"+
		"\u00b2\2\u05b7\u05b8\7\u00cc\2\2\u05b8\u05d7\5\u0162\u00b2\2\u05b9\u05ba"+
		"\7i\2\2\u05ba\u05d7\5\u0162\u00b2\2\u05bb\u05bc\7\u00d5\2\2\u05bc\u05d7"+
		"\5\u0162\u00b2\2\u05bd\u05be\7\u0107\2\2\u05be\u05bf\7\u00ca\2\2\u05bf"+
		"\u05c0\7\u008b\2\2\u05c0\u05d7\5\u0162\u00b2\2\u05c1\u05c2\7\u0107\2\2"+
		"\u05c2\u05c3\7\u00ca\2\2\u05c3\u05c4\7\u0092\2\2\u05c4\u05d7\5\u0162\u00b2"+
		"\2\u05c5\u05c6\7\u0107\2\2\u05c6\u05c7\7\u00ca\2\2\u05c7\u05c8\7\u00be"+
		"\2\2\u05c8\u05d7\5\u0162\u00b2\2\u05c9\u05ca\7\u0107\2\2\u05ca\u05cb\7"+
		"\u00ca\2\2\u05cb\u05cc\7\u00d7\2\2\u05cc\u05d7\5\u0162\u00b2\2\u05cd\u05ce"+
		"\7n\2\2\u05ce\u05cf\5\u0162\u00b2\2\u05cf\u05d0\7M\2\2\u05d0\u05d1\5\u0162"+
		"\u00b2\2\u05d1\u05d7\3\2\2\2\u05d2\u05d3\7q\2\2\u05d3\u05d7\5\u0162\u00b2"+
		"\2\u05d4\u05d5\7x\2\2\u05d5\u05d7\5\u0162\u00b2\2\u05d6\u055f\3\2\2\2"+
		"\u05d6\u056d\3\2\2\2\u05d6\u0574\3\2\2\2\u05d6\u0576\3\2\2\2\u05d6\u0578"+
		"\3\2\2\2\u05d6\u057d\3\2\2\2\u05d6\u057f\3\2\2\2\u05d6\u0581\3\2\2\2\u05d6"+
		"\u0583\3\2\2\2\u05d6\u0585\3\2\2\2\u05d6\u0589\3\2\2\2\u05d6\u058c\3\2"+
		"\2\2\u05d6\u058e\3\2\2\2\u05d6\u0590\3\2\2\2\u05d6\u0593\3\2\2\2\u05d6"+
		"\u059b\3\2\2\2\u05d6\u05a1\3\2\2\2\u05d6\u05a8\3\2\2\2\u05d6\u05ac\3\2"+
		"\2\2\u05d6\u05ae\3\2\2\2\u05d6\u05b3\3\2\2\2\u05d6\u05b5\3\2\2\2\u05d6"+
		"\u05b7\3\2\2\2\u05d6\u05b9\3\2\2\2\u05d6\u05bb\3\2\2\2\u05d6\u05bd\3\2"+
		"\2\2\u05d6\u05c1\3\2\2\2\u05d6\u05c5\3\2\2\2\u05d6\u05c9\3\2\2\2\u05d6"+
		"\u05cd\3\2\2\2\u05d6\u05d2\3\2\2\2\u05d6\u05d4\3\2\2\2\u05d7\u05d8\3\2"+
		"\2\2\u05d8\u05d9\7@\2\2\u05d9\u05da\7\u0127\2\2\u05da\u05db\7\u012e\2"+
		"\2\u05db\u05dc\7\u0127\2\2\u05dc\35\3\2\2\2\u05dd\u05de\t\13\2\2\u05de"+
		"\37\3\2\2\2\u05df\u05e0\7-\2\2\u05e0\u05e1\5f\64\2\u05e1\u05ee\7\u011d"+
		"\2\2\u05e2\u05e4\5\36\20\2\u05e3\u05e2\3\2\2\2\u05e3\u05e4\3\2\2\2\u05e4"+
		"\u05e6\3\2\2\2\u05e5\u05e7\5f\64\2\u05e6\u05e5\3\2\2\2\u05e6\u05e7\3\2"+
		"\2\2\u05e7\u05e8\3\2\2\2\u05e8\u05ea\5x=\2\u05e9\u05eb\7\u0116\2\2\u05ea"+
		"\u05e9\3\2\2\2\u05ea\u05eb\3\2\2\2\u05eb\u05ed\3\2\2\2\u05ec\u05e3\3\2"+
		"\2\2\u05ed\u05f0\3\2\2\2\u05ee\u05ec\3\2\2\2\u05ee\u05ef\3\2\2\2\u05ef"+
		"\u05f1\3\2\2\2\u05f0\u05ee\3\2\2\2\u05f1\u05f2\7\u011e\2\2\u05f2!\3\2"+
		"\2\2\u05f3\u05f4\7\6\2\2\u05f4\u05f5\7.\2\2\u05f5\u05f6\7\67\2\2\u05f6"+
		"\u05fb\7a\2\2\u05f7\u05f9\5f\64\2\u05f8\u05fa\7\u0116\2\2\u05f9\u05f8"+
		"\3\2\2\2\u05f9\u05fa\3\2\2\2\u05fa\u05fc\3\2\2\2\u05fb\u05f7\3\2\2\2\u05fc"+
		"\u05fd\3\2\2\2\u05fd\u05fb\3\2\2\2\u05fd\u05fe\3\2\2\2\u05fe#\3\2\2\2"+
		"\u05ff\u0600\7\26\2\2\u0600\u0601\7\u0099\2\2\u0601\u0602\7i\2\2\u0602"+
		"\u0603\5\u0162\u00b2\2\u0603\u0604\5:\36\2\u0604\u0605\7v\2\2\u0605\u0607"+
		"\5f\64\2\u0606\u0608\5@!\2\u0607\u0606\3\2\2\2\u0607\u0608\3\2\2\2\u0608"+
		"\u060a\3\2\2\2\u0609\u060b\5J&\2\u060a\u0609\3\2\2\2\u060a\u060b\3\2\2"+
		"\2\u060b\u060c\3\2\2\2\u060c\u060d\7\u00ae\2\2\u060d\u060e\7\u012e\2\2"+
		"\u060e\u06a2\3\2\2\2\u060f\u0610\7\26\2\2\u0610\u0611\7i\2\2\u0611\u0612"+
		"\5\u0162\u00b2\2\u0612\u0615\5:\36\2\u0613\u0614\7v\2\2\u0614\u0616\5"+
		"f\64\2\u0615\u0613\3\2\2\2\u0615\u0616\3\2\2\2\u0616\u0618\3\2\2\2\u0617"+
		"\u0619\5@!\2\u0618\u0617\3\2\2\2\u0618\u0619\3\2\2\2\u0619\u061b\3\2\2"+
		"\2\u061a\u061c\5J&\2\u061b\u061a\3\2\2\2\u061b\u061c\3\2\2\2\u061c\u061f"+
		"\3\2\2\2\u061d\u061e\7\5\2\2\u061e\u0620\5\u014e\u00a8\2\u061f\u061d\3"+
		"\2\2\2\u061f\u0620\3\2\2\2\u0620\u06a2\3\2\2\2\u0621\u0622\7\26\2\2\u0622"+
		"\u0623\7i\2\2\u0623\u0626\5\u0162\u00b2\2\u0624\u0625\7v\2\2\u0625\u0627"+
		"\5f\64\2\u0626\u0624\3\2\2\2\u0626\u0627\3\2\2\2\u0627\u0629\3\2\2\2\u0628"+
		"\u062a\5@!\2\u0629\u0628\3\2\2\2\u0629\u062a\3\2\2\2\u062a\u062c\3\2\2"+
		"\2\u062b\u062d\5J&\2\u062c\u062b\3\2\2\2\u062c\u062d\3\2\2\2\u062d\u062e"+
		"\3\2\2\2\u062e\u062f\7\5\2\2\u062f\u0630\5\u014e\u00a8\2\u0630\u06a2\3"+
		"\2\2\2\u0631\u0637\7\26\2\2\u0632\u0634\t\f\2\2\u0633\u0632\3\2\2\2\u0633"+
		"\u0634\3\2\2\2\u0634\u0635\3\2\2\2\u0635\u0638\t\r\2\2\u0636\u0638\7\u00df"+
		"\2\2\u0637\u0633\3\2\2\2\u0637\u0636\3\2\2\2\u0637\u0638\3\2\2\2\u0638"+
		"\u0639\3\2\2\2\u0639\u063d\7i\2\2\u063a\u063b\7\64\2\2\u063b\u063c\7I"+
		"\2\2\u063c\u063e\7\u0098\2\2\u063d\u063a\3\2\2\2\u063d\u063e\3\2\2\2\u063e"+
		"\u063f\3\2\2\2\u063f\u0640\5\u0162\u00b2\2\u0640\u065f\7\u011d\2\2\u0641"+
		"\u0642\5f\64\2\u0642\u0645\5x=\2\u0643\u0644\7\20\2\2\u0644\u0646\5f\64"+
		"\2\u0645\u0643\3\2\2\2\u0645\u0646\3\2\2\2\u0646\u064a\3\2\2\2\u0647\u0649"+
		"\5*\26\2\u0648\u0647\3\2\2\2\u0649\u064c\3\2\2\2\u064a\u0648\3\2\2\2\u064a"+
		"\u064b\3\2\2\2\u064b\u0657\3\2\2\2\u064c\u064a\3\2\2\2\u064d\u0657\5("+
		"\25\2\u064e\u064f\7E\2\2\u064f\u0653\5f\64\2\u0650\u0652\5&\24\2\u0651"+
		"\u0650\3\2\2\2\u0652\u0655\3\2\2\2\u0653\u0651\3\2\2\2\u0653\u0654\3\2"+
		"\2\2\u0654\u0657\3\2\2\2\u0655\u0653\3\2\2\2\u0656\u0641\3\2\2\2\u0656"+
		"\u064d\3\2\2\2\u0656\u064e\3\2\2\2\u0657\u0659\3\2\2\2\u0658\u065a\7\u0116"+
		"\2\2\u0659\u0658\3\2\2\2\u0659\u065a\3\2\2\2\u065a\u065c\3\2\2\2\u065b"+
		"\u0656\3\2\2\2\u065c\u065d\3\2\2\2\u065d\u065b\3\2\2\2\u065d\u065e\3\2"+
		"\2\2\u065e\u0660\3\2\2\2\u065f\u065b\3\2\2\2\u065f\u0660\3\2\2\2\u0660"+
		"\u0661\3\2\2\2\u0661\u066e\7\u011e\2\2\u0662\u0663\79\2\2\u0663\u0668"+
		"\7\u011d\2\2\u0664\u0666\5f\64\2\u0665\u0667\7\u0116\2\2\u0666\u0665\3"+
		"\2\2\2\u0666\u0667\3\2\2\2\u0667\u0669\3\2\2\2\u0668\u0664\3\2\2\2\u0669"+
		"\u066a\3\2\2\2\u066a\u0668\3\2\2\2\u066a\u066b\3\2\2\2\u066b\u066c\3\2"+
		"\2\2\u066c\u066d\7\u011e\2\2\u066d\u066f\3\2\2\2\u066e\u0662\3\2\2\2\u066e"+
		"\u066f\3\2\2\2\u066f\u0670\3\2\2\2\u0670\u0671\5\60\31\2\u0671\u0672\5"+
		"\62\32\2\u0672\u0673\5\64\33\2\u0673\u06a2\3\2\2\2\u0674\u067a\7\26\2"+
		"\2\u0675\u0677\t\f\2\2\u0676\u0675\3\2\2\2\u0676\u0677\3\2\2\2\u0677\u0678"+
		"\3\2\2\2\u0678\u067b\t\r\2\2\u0679\u067b\7\u00df\2\2\u067a\u0676\3\2\2"+
		"\2\u067a\u0679\3\2\2\2\u067a\u067b\3\2\2\2\u067b\u067c\3\2\2\2\u067c\u0680"+
		"\7i\2\2\u067d\u067e\7\64\2\2\u067e\u067f\7I\2\2\u067f\u0681\7\u0098\2"+
		"\2\u0680\u067d\3\2\2\2\u0680\u0681\3\2\2\2\u0681\u0682\3\2\2\2\u0682\u0683"+
		"\5\u0162\u00b2\2\u0683\u0684\7K\2\2\u0684\u069b\5f\64\2\u0685\u0695\7"+
		"\u011d\2\2\u0686\u0687\5f\64\2\u0687\u0688\7{\2\2\u0688\u068c\7\u00bc"+
		"\2\2\u0689\u068b\5*\26\2\u068a\u0689\3\2\2\2\u068b\u068e\3\2\2\2\u068c"+
		"\u068a\3\2\2\2\u068c\u068d\3\2\2\2\u068d\u0691\3\2\2\2\u068e\u068c\3\2"+
		"\2\2\u068f\u0691\5(\25\2\u0690\u0686\3\2\2\2\u0690\u068f\3\2\2\2\u0691"+
		"\u0693\3\2\2\2\u0692\u0694\7\u0116\2\2\u0693\u0692\3\2\2\2\u0693\u0694"+
		"\3\2\2\2\u0694\u0696\3\2\2\2\u0695\u0690\3\2\2\2\u0696\u0697\3\2\2\2\u0697"+
		"\u0695\3\2\2\2\u0697\u0698\3\2\2\2\u0698\u0699\3\2\2\2\u0699\u069a\7\u011e"+
		"\2\2\u069a\u069c\3\2\2\2\u069b\u0685\3\2\2\2\u069b\u069c\3\2\2\2\u069c"+
		"\u069d\3\2\2\2\u069d\u069e\5\60\31\2\u069e\u069f\5\62\32\2\u069f\u06a0"+
		"\5\64\33\2\u06a0\u06a2\3\2\2\2\u06a1\u05ff\3\2\2\2\u06a1\u060f\3\2\2\2"+
		"\u06a1\u0621\3\2\2\2\u06a1\u0631\3\2\2\2\u06a1\u0674\3\2\2\2\u06a2%\3"+
		"\2\2\2\u06a3\u06a4\t\16\2\2\u06a4\u06a5\t\17\2\2\u06a5\'\3\2\2\2\u06a6"+
		"\u06a7\7\23\2\2\u06a7\u06a9\5f\64\2\u06a8\u06a6\3\2\2\2\u06a8\u06a9\3"+
		"\2\2\2\u06a9\u070c\3\2\2\2\u06aa\u070d\5,\27\2\u06ab\u06ac\7s\2\2\u06ac"+
		"\u06b1\7\u011d\2\2\u06ad\u06af\5f\64\2\u06ae\u06b0\7\u0116\2\2\u06af\u06ae"+
		"\3\2\2\2\u06af\u06b0\3\2\2\2\u06b0\u06b2\3\2\2\2\u06b1\u06ad\3\2\2\2\u06b2"+
		"\u06b3\3\2\2\2\u06b3\u06b1\3\2\2\2\u06b3\u06b4\3\2\2\2\u06b4\u06b5\3\2"+
		"\2\2\u06b5\u06b6\7\u011e\2\2\u06b6\u06b7\58\35\2\u06b7\u070d\3\2\2\2\u06b8"+
		"\u06b9\7T\2\2\u06b9\u06ba\7B\2\2\u06ba\u06bf\7\u011d\2\2\u06bb\u06bd\5"+
		"f\64\2\u06bc\u06be\7\u0116\2\2\u06bd\u06bc\3\2\2\2\u06bd\u06be\3\2\2\2"+
		"\u06be\u06c0\3\2\2\2\u06bf\u06bb\3\2\2\2\u06c0\u06c1\3\2\2\2\u06c1\u06bf"+
		"\3\2\2\2\u06c1\u06c2\3\2\2\2\u06c2\u06c3\3\2\2\2\u06c3\u06c4\7\u011e\2"+
		"\2\u06c4\u06c5\58\35\2\u06c5\u070d\3\2\2\2\u06c6\u06c9\7%\2\2\u06c7\u06c8"+
		"\7v\2\2\u06c8\u06ca\5f\64\2\u06c9\u06c7\3\2\2\2\u06c9\u06ca\3\2\2\2\u06ca"+
		"\u06cb\3\2\2\2\u06cb\u06cc\7\u011d\2\2\u06cc\u06cd\5f\64\2\u06cd\u06d2"+
		"\7{\2\2\u06ce\u06d0\5f\64\2\u06cf\u06d1\7\u0116\2\2\u06d0\u06cf\3\2\2"+
		"\2\u06d0\u06d1\3\2\2\2\u06d1\u06d3\3\2\2\2\u06d2\u06ce\3\2\2\2\u06d3\u06d4"+
		"\3\2\2\2\u06d4\u06d2\3\2\2\2\u06d4\u06d5\3\2\2\2\u06d5\u06d6\3\2\2\2\u06d6"+
		"\u06d7\7\u011e\2\2\u06d7\u06dd\58\35\2\u06d8\u06d9\7z\2\2\u06d9\u06da"+
		"\7\u011d\2\2\u06da\u06db\5f\64\2\u06db\u06dc\7\u011e\2\2\u06dc\u06de\3"+
		"\2\2\2\u06dd\u06d8\3\2\2\2\u06dd\u06de\3\2\2\2\u06de\u070d\3\2\2\2\u06df"+
		"\u06e0\7+\2\2\u06e0\u06e1\7B\2\2\u06e1\u06e6\7\u011d\2\2\u06e2\u06e4\5"+
		"f\64\2\u06e3\u06e5\7\u0116\2\2\u06e4\u06e3\3\2\2\2\u06e4\u06e5\3\2\2\2"+
		"\u06e5\u06e7\3\2\2\2\u06e6\u06e2\3\2\2\2\u06e7\u06e8\3\2\2\2\u06e8\u06e6"+
		"\3\2\2\2\u06e8\u06e9\3\2\2\2\u06e9\u06ea\3\2\2\2\u06ea\u06eb\7\u011e\2"+
		"\2\u06eb\u06ec\7[\2\2\u06ec\u06f8\5f\64\2\u06ed\u06f2\7\u011d\2\2\u06ee"+
		"\u06f0\5f\64\2\u06ef\u06f1\7\u0116\2\2\u06f0\u06ef\3\2\2\2\u06f0\u06f1"+
		"\3\2\2\2\u06f1\u06f3\3\2\2\2\u06f2\u06ee\3\2\2\2\u06f3\u06f4\3\2\2\2\u06f4"+
		"\u06f2\3\2\2\2\u06f4\u06f5\3\2\2\2\u06f5\u06f6\3\2\2\2\u06f6\u06f7\7\u011e"+
		"\2\2\u06f7\u06f9\3\2\2\2\u06f8\u06ed\3\2\2\2\u06f8\u06f9\3\2\2\2\u06f9"+
		"\u0700\3\2\2\2\u06fa\u06fb\7\u00af\2\2\u06fb\u0701\7,\2\2\u06fc\u06fd"+
		"\7\u00af\2\2\u06fd\u0701\7\u00bf\2\2\u06fe\u06ff\7\u00af\2\2\u06ff\u0701"+
		"\7\u00cf\2\2\u0700\u06fa\3\2\2\2\u0700\u06fc\3\2\2\2\u0700\u06fe\3\2\2"+
		"\2\u0700\u0701\3\2\2\2\u0701\u0705\3\2\2\2\u0702\u0703\7M\2\2\u0703\u0704"+
		"\7\35\2\2\u0704\u0706\5\66\34\2\u0705\u0702\3\2\2\2\u0705\u0706\3\2\2"+
		"\2\u0706\u070a\3\2\2\2\u0707\u0708\7M\2\2\u0708\u0709\7t\2\2\u0709\u070b"+
		"\5\66\34\2\u070a\u0707\3\2\2\2\u070a\u070b\3\2\2\2\u070b\u070d\3\2\2\2"+
		"\u070c\u06aa\3\2\2\2\u070c\u06ab\3\2\2\2\u070c\u06b8\3\2\2\2\u070c\u06c6"+
		"\3\2\2\2\u070c\u06df\3\2\2\2\u070d\u0711\3\2\2\2\u070e\u0712\7\33\2\2"+
		"\u070f\u0710\7I\2\2\u0710\u0712\7\33\2\2\u0711\u070e\3\2\2\2\u0711\u070f"+
		"\3\2\2\2\u0711\u0712\3\2\2\2\u0712\u0717\3\2\2\2\u0713\u0714\7:\2\2\u0714"+
		"\u0718\7\34\2\2\u0715\u0716\7:\2\2\u0716\u0718\7\66\2\2\u0717\u0713\3"+
		"\2\2\2\u0717\u0715\3\2\2\2\u0717\u0718\3\2\2\2\u0718)\3\2\2\2\u0719\u071a"+
		"\7\23\2\2\u071a\u071c\5f\64\2\u071b\u0719\3\2\2\2\u071b\u071c\3\2\2\2"+
		"\u071c\u073d\3\2\2\2\u071d\u071e\7I\2\2\u071e\u073e\7J\2\2\u071f\u073e"+
		"\7J\2\2\u0720\u073e\5,\27\2\u0721\u0722\7\31\2\2\u0722\u073e\5\u01aa\u00d6"+
		"\2\u0723\u0724\7s\2\2\u0724\u073e\58\35\2\u0725\u0726\7T\2\2\u0726\u0727"+
		"\7B\2\2\u0727\u073e\58\35\2\u0728\u0729\7[\2\2\u0729\u072a\5\u0162\u00b2"+
		"\2\u072a\u0731\5f\64\2\u072b\u072c\7\u00af\2\2\u072c\u0732\7,\2\2\u072d"+
		"\u072e\7\u00af\2\2\u072e\u0732\7\u00bf\2\2\u072f\u0730\7\u00af\2\2\u0730"+
		"\u0732\7\u00cf\2\2\u0731\u072b\3\2\2\2\u0731\u072d\3\2\2\2\u0731\u072f"+
		"\3\2\2\2\u0731\u0732\3\2\2\2\u0732\u0736\3\2\2\2\u0733\u0734\7M\2\2\u0734"+
		"\u0735\7\35\2\2\u0735\u0737\5\66\34\2\u0736\u0733\3\2\2\2\u0736\u0737"+
		"\3\2\2\2\u0737\u073b\3\2\2\2\u0738\u0739\7M\2\2\u0739\u073a\7t\2\2\u073a"+
		"\u073c\5\66\34\2\u073b\u0738\3\2\2\2\u073b\u073c\3\2\2\2\u073c\u073e\3"+
		"\2\2\2\u073d\u071d\3\2\2\2\u073d\u071f\3\2\2\2\u073d\u0720\3\2\2\2\u073d"+
		"\u0721\3\2\2\2\u073d\u0723\3\2\2\2\u073d\u0725\3\2\2\2\u073d\u0728\3\2"+
		"\2\2\u073e\u0742\3\2\2\2\u073f\u0743\7\33\2\2\u0740\u0741\7I\2\2\u0741"+
		"\u0743\7\33\2\2\u0742\u073f\3\2\2\2\u0742\u0740\3\2\2\2\u0742\u0743\3"+
		"\2\2\2\u0743\u0748\3\2\2\2\u0744\u0745\7:\2\2\u0745\u0749\7\34\2\2\u0746"+
		"\u0747\7:\2\2\u0747\u0749\7\66\2\2\u0748\u0744\3\2\2\2\u0748\u0746\3\2"+
		"\2\2\u0748\u0749\3\2\2\2\u0749+\3\2\2\2\u074a\u074b\7\u0084\2\2\u074b"+
		"\u074c\7\u011d\2\2\u074c\u074d\5\u00f2z\2\u074d\u074e\7\u011e\2\2\u074e"+
		"-\3\2\2\2\u074f\u0750\7{\2\2\u0750\u0759\7\u011d\2\2\u0751\u0754\5f\64"+
		"\2\u0752\u0753\7\u0113\2\2\u0753\u0755\5f\64\2\u0754\u0752\3\2\2\2\u0754"+
		"\u0755\3\2\2\2\u0755\u0757\3\2\2\2\u0756\u0758\7\u0116\2\2\u0757\u0756"+
		"\3\2\2\2\u0757\u0758\3\2\2\2\u0758\u075a\3\2\2\2\u0759\u0751\3\2\2\2\u075a"+
		"\u075b\3\2\2\2\u075b\u0759\3\2\2\2\u075b\u075c\3\2\2\2\u075c\u075d\3\2"+
		"\2\2\u075d\u075e\7\u011e\2\2\u075e/\3\2\2\2\u075f\u0765\5.\30\2\u0760"+
		"\u0761\7{\2\2\u0761\u0765\7L\2\2\u0762\u0763\7|\2\2\u0763\u0765\7L\2\2"+
		"\u0764\u075f\3\2\2\2\u0764\u0760\3\2\2\2\u0764\u0762\3\2\2\2\u0764\u0765"+
		"\3\2\2\2\u0765\61\3\2\2\2\u0766\u0767\7M\2\2\u0767\u076d\7\u008a\2\2\u0768"+
		"\u0769\7S\2\2\u0769\u076e\7Z\2\2\u076a\u076b\7\35\2\2\u076b\u076e\7Z\2"+
		"\2\u076c\u076e\7\u0095\2\2\u076d\u0768\3\2\2\2\u076d\u076a\3\2\2\2\u076d"+
		"\u076c\3\2\2\2\u076e\u0770\3\2\2\2\u076f\u0766\3\2\2\2\u076f\u0770\3\2"+
		"\2\2\u0770\63\3\2\2\2\u0771\u0772\7\u00d5\2\2\u0772\u0774\5f\64\2\u0773"+
		"\u0771\3\2\2\2\u0773\u0774\3\2\2\2\u0774\65\3\2\2\2\u0775\u077c\7]\2\2"+
		"\u0776\u077c\7\16\2\2\u0777\u0778\7\u00cd\2\2\u0778\u077c\7J\2\2\u0779"+
		"\u077a\7\u00cd\2\2\u077a\u077c\7\31\2\2\u077b\u0775\3\2\2\2\u077b\u0776"+
		"\3\2\2\2\u077b\u0777\3\2\2\2\u077b\u0779\3\2\2\2\u077c\67\3\2\2\2\u077d"+
		"\u077f\5.\30\2\u077e\u077d\3\2\2\2\u077e\u077f\3\2\2\2\u077f\u0784\3\2"+
		"\2\2\u0780\u0781\7v\2\2\u0781\u0782\7\u00a3\2\2\u0782\u0783\7\u00d5\2"+
		"\2\u0783\u0785\5f\64\2\u0784\u0780\3\2\2\2\u0784\u0785\3\2\2\2\u07859"+
		"\3\2\2\2\u0786\u0787\7\u011d\2\2\u0787\u078c\5<\37\2\u0788\u0789\7\u0116"+
		"\2\2\u0789\u078b\5<\37\2\u078a\u0788\3\2\2\2\u078b\u078e\3\2\2\2\u078c"+
		"\u078a\3\2\2\2\u078c\u078d\3\2\2\2\u078d\u078f\3\2\2\2\u078e\u078c\3\2"+
		"\2\2\u078f\u0790\7\u011e\2\2\u0790;\3\2\2\2\u0791\u0792\5f\64\2\u0792"+
		"\u0793\5> \2\u0793=\3\2\2\2\u0794\u0795\5x=\2\u0795?\3\2\2\2\u0796\u0797"+
		"\7{\2\2\u0797\u0798\7\u011d\2\2\u0798\u079d\5B\"\2\u0799\u079a\7\u0116"+
		"\2\2\u079a\u079c\5B\"\2\u079b\u0799\3\2\2\2\u079c\u079f\3\2\2\2\u079d"+
		"\u079b\3\2\2\2\u079d\u079e\3\2\2\2\u079e\u07a0\3\2\2\2\u079f\u079d\3\2"+
		"\2\2\u07a0\u07a1\7\u011e\2\2\u07a1A\3\2\2\2\u07a2\u07a3\7\u012e\2\2\u07a3"+
		"\u07a4\7\u0113\2\2\u07a4\u07a5\5\u00ccg\2\u07a5C\3\2\2\2\u07a6\u07a7\7"+
		"v\2\2\u07a7\u07a8\5f\64\2\u07a8E\3\2\2\2\u07a9\u07aa\7\u00d5\2\2\u07aa"+
		"\u07ab\5H%\2\u07abG\3\2\2\2\u07ac\u07ad\5f\64\2\u07adI\3\2\2\2\u07ae\u07b3"+
		"\5L\'\2\u07af\u07b3\5R*\2\u07b0\u07b3\5Z.\2\u07b1\u07b3\5`\61\2\u07b2"+
		"\u07ae\3\2\2\2\u07b2\u07af\3\2\2\2\u07b2\u07b0\3\2\2\2\u07b2\u07b1\3\2"+
		"\2\2\u07b3K\3\2\2\2\u07b4\u07b5\7\u00c0\2\2\u07b5\u07b6\7\u0080\2\2\u07b6"+
		"\u07b7\7\u00c6\2\2\u07b7\u07b8\7\u011d\2\2\u07b8\u07b9\5\u0174\u00bb\2"+
		"\u07b9\u07ba\7\u011e\2\2\u07ba\u07bb\7\u011d\2\2\u07bb\u07bc\5N(\2\u07bc"+
		"\u07bd\7\u011e\2\2\u07bdM\3\2\2\2\u07be\u07c3\5P)\2\u07bf\u07c0\7\u0116"+
		"\2\2\u07c0\u07c2\5P)\2\u07c1\u07bf\3\2\2\2\u07c2\u07c5\3\2\2\2\u07c3\u07c1"+
		"\3\2\2\2\u07c3\u07c4\3\2\2\2\u07c4O\3\2\2\2\u07c5\u07c3\3\2\2\2\u07c6"+
		"\u07c7\7\u00c0\2\2\u07c7\u07c8\5b\62\2\u07c8\u07c9\7\u00e0\2\2\u07c9\u07ca"+
		"\7\u00ac\2\2\u07ca\u07d6\7\u00d8\2\2\u07cb\u07cc\7\u011d\2\2\u07cc\u07cd"+
		"\5\u00c8e\2\u07cd\u07ce\7\u011e\2\2\u07ce\u07d7\3\2\2\2\u07cf\u07d1\7"+
		"\u011d\2\2\u07d0\u07cf\3\2\2\2\u07d0\u07d1\3\2\2\2\u07d1\u07d2\3\2\2\2"+
		"\u07d2\u07d4\7\u00b1\2\2\u07d3\u07d5\7\u011e\2\2\u07d4\u07d3\3\2\2\2\u07d4"+
		"\u07d5\3\2\2\2\u07d5\u07d7\3\2\2\2\u07d6\u07cb\3\2\2\2\u07d6\u07d0\3\2"+
		"\2\2\u07d7Q\3\2\2\2\u07d8\u07d9\7\u00c0\2\2\u07d9\u07da\7\u0080\2\2\u07da"+
		"\u07db\7\u00a1\2\2\u07db\u07dc\7\u011d\2\2\u07dc\u07dd\5\u0174\u00bb\2"+
		"\u07dd\u07e3\7\u011e\2\2\u07de\u07df\7\u011d\2\2\u07df\u07e0\5T+\2\u07e0"+
		"\u07e1\7\u011e\2\2\u07e1\u07e4\3\2\2\2\u07e2\u07e4\5X-\2\u07e3\u07de\3"+
		"\2\2\2\u07e3\u07e2\3\2\2\2\u07e4S\3\2\2\2\u07e5\u07ea\5V,\2\u07e6\u07e7"+
		"\7\u0116\2\2\u07e7\u07e9\5V,\2\u07e8\u07e6\3\2\2\2\u07e9\u07ec\3\2\2\2"+
		"\u07ea\u07e8\3\2\2\2\u07ea\u07eb\3\2\2\2\u07ebU\3\2\2\2\u07ec\u07ea\3"+
		"\2\2\2\u07ed\u07ee\7\u00c0\2\2\u07ee\u07ef\5b\62\2\u07efW\3\2\2\2\u07f0"+
		"\u07f1\7\u00c1\2\2\u07f1\u07f2\5\u00ccg\2\u07f2Y\3\2\2\2\u07f3\u07f4\7"+
		"\u00c0\2\2\u07f4\u07f5\7\u0080\2\2\u07f5\u07f6\7\u00ad\2\2\u07f6\u07f7"+
		"\7\u011d\2\2\u07f7\u07f8\5\u0174\u00bb\2\u07f8\u07f9\7\u011e\2\2\u07f9"+
		"\u07fa\7\u011d\2\2\u07fa\u07fb\5\\/\2\u07fb\u07fc\7\u011e\2\2\u07fc[\3"+
		"\2\2\2\u07fd\u0802\5^\60\2\u07fe\u07ff\7\u0116\2\2\u07ff\u0801\5^\60\2"+
		"\u0800\u07fe\3\2\2\2\u0801\u0804\3\2\2\2\u0802\u0800\3\2\2\2\u0802\u0803"+
		"\3\2\2\2\u0803]\3\2\2\2\u0804\u0802\3\2\2\2\u0805\u0806\7\u00c0\2\2\u0806"+
		"\u0807\5b\62\2\u0807\u0809\7\u00e0\2\2\u0808\u080a\7\67\2\2\u0809\u0808"+
		"\3\2\2\2\u0809\u080a\3\2\2\2\u080a\u080b\3\2\2\2\u080b\u080c\7\u011d\2"+
		"\2\u080c\u080d\5\u018c\u00c7\2\u080d\u080e\7\u011e\2\2\u080e_\3\2\2\2"+
		"\u080f\u0810\7\u00c0\2\2\u0810\u0811\7\u0080\2\2\u0811\u0812\7\u0087\2"+
		"\2\u0812\u0813\5:\36\2\u0813a\3\2\2\2\u0814\u0815\5f\64\2\u0815c\3\2\2"+
		"\2\u0816\u0817\7\u0095\2\2\u0817\u0818\7i\2\2\u0818\u081a\5\u0162\u00b2"+
		"\2\u0819\u081b\7\u00c4\2\2\u081a\u0819\3\2\2\2\u081a\u081b\3\2\2\2\u081b"+
		"e\3\2\2\2\u081c\u081e\7\u0127\2\2\u081d\u081c\3\2\2\2\u081d\u081e\3\2"+
		"\2\2\u081e\u081f\3\2\2\2\u081f\u0821\7\u012d\2\2\u0820\u0822\7\u0127\2"+
		"\2\u0821\u0820\3\2\2\2\u0821\u0822\3\2\2\2\u0822\u0825\3\2\2\2\u0823\u0825"+
		"\5h\65\2\u0824\u081d\3\2\2\2\u0824\u0823\3\2\2\2\u0825g\3\2\2\2\u0826"+
		"\u0827\t\20\2\2\u0827i\3\2\2\2\u0828\u082b\5\u00a0Q\2\u0829\u082b\5l\67"+
		"\2\u082a\u0828\3\2\2\2\u082a\u0829\3\2\2\2\u082bk\3\2\2\2\u082c\u0830"+
		"\7\u012e\2\2\u082d\u0830\5n8\2\u082e\u0830\5v<\2\u082f\u082c\3\2\2\2\u082f"+
		"\u082d\3\2\2\2\u082f\u082e\3\2\2\2\u0830m\3\2\2\2\u0831\u0835\5r:\2\u0832"+
		"\u0835\5p9\2\u0833\u0835\5t;\2\u0834\u0831\3\2\2\2\u0834\u0832\3\2\2\2"+
		"\u0834\u0833\3\2\2\2\u0835o\3\2\2\2\u0836\u0837\7\u0103\2\2\u0837\u0838"+
		"\7\u012e\2\2\u0838q\3\2\2\2\u0839\u083a\7\u0105\2\2\u083a\u083b\7\u012e"+
		"\2\2\u083bs\3\2\2\2\u083c\u083d\7\u0102\2\2\u083d\u083e\7\u012e\2\2\u083e"+
		"u\3\2\2\2\u083f\u0840\t\21\2\2\u0840w\3\2\2\2\u0841\u0842\5z>\2\u0842"+
		"y\3\2\2\2\u0843\u084e\5\u0080A\2\u0844\u084e\5\u0084C\2\u0845\u084e\5"+
		"\u0086D\2\u0846\u084e\5\u0088E\2\u0847\u084e\5\u0090I\2\u0848\u084e\5"+
		"\u0092J\2\u0849\u084e\5\u0094K\2\u084a\u084e\5\u0096L\2\u084b\u084e\5"+
		"~@\2\u084c\u084e\5|?\2\u084d\u0843\3\2\2\2\u084d\u0844\3\2\2\2\u084d\u0845"+
		"\3\2\2\2\u084d\u0846\3\2\2\2\u084d\u0847\3\2\2\2\u084d\u0848\3\2\2\2\u084d"+
		"\u0849\3\2\2\2\u084d\u084a\3\2\2\2\u084d\u084b\3\2\2\2\u084d\u084c\3\2"+
		"\2\2\u084e{\3\2\2\2\u084f\u0850\7\u00f9\2\2\u0850}\3\2\2\2\u0851\u0852"+
		"\7\u010c\2\2\u0852\177\3\2\2\2\u0853\u0855\7\u0083\2\2\u0854\u0856\5\u0082"+
		"B\2\u0855\u0854\3\2\2\2\u0855\u0856\3\2\2\2\u0856\u086b\3\2\2\2\u0857"+
		"\u0859\7\u00fe\2\2\u0858\u085a\5\u0082B\2\u0859\u0858\3\2\2\2\u0859\u085a"+
		"\3\2\2\2\u085a\u086b\3\2\2\2\u085b\u085c\7\u0083\2\2\u085c\u085e\7\u00e3"+
		"\2\2\u085d\u085f\5\u0082B\2\u085e\u085d\3\2\2\2\u085e\u085f\3\2\2\2\u085f"+
		"\u086b\3\2\2\2\u0860\u0861\7\u00fe\2\2\u0861\u0863\7\u00e3\2\2\u0862\u0864"+
		"\5\u0082B\2\u0863\u0862\3\2\2\2\u0863\u0864\3\2\2\2\u0864\u086b\3\2\2"+
		"\2\u0865\u0867\7\u00ff\2\2\u0866\u0868\5\u0082B\2\u0867\u0866\3\2\2\2"+
		"\u0867\u0868\3\2\2\2\u0868\u086b\3\2\2\2\u0869\u086b\7\u0107\2\2\u086a"+
		"\u0853\3\2\2\2\u086a\u0857\3\2\2\2\u086a\u085b\3\2\2\2\u086a\u0860\3\2"+
		"\2\2\u086a\u0865\3\2\2\2\u086a\u0869\3\2\2\2\u086b\u0081\3\2\2\2\u086c"+
		"\u086d\7\u011d\2\2\u086d\u086e\7\u0129\2\2\u086e\u086f\7\u011e\2\2\u086f"+
		"\u0083\3\2\2\2\u0870\u0871\7\u00b8\2\2\u0871\u0873\7\u0083\2\2\u0872\u0874"+
		"\5\u0082B\2\u0873\u0872\3\2\2\2\u0873\u0874\3\2\2\2\u0874\u0894\3\2\2"+
		"\2\u0875\u0876\7\u00b8\2\2\u0876\u0878\7\u00fe\2\2\u0877\u0879\5\u0082"+
		"B\2\u0878\u0877\3\2\2\2\u0878\u0879\3\2\2\2\u0879\u0894\3\2\2\2\u087a"+
		"\u087c\7\u0100\2\2\u087b\u087d\5\u0082B\2\u087c\u087b\3\2\2\2\u087c\u087d"+
		"\3\2\2\2\u087d\u0894\3\2\2\2\u087e\u087f\7\u00b8\2\2\u087f\u0880\7\u0083"+
		"\2\2\u0880\u0882\7\u00e3\2\2\u0881\u0883\5\u0082B\2\u0882\u0881\3\2\2"+
		"\2\u0882\u0883\3\2\2\2\u0883\u0894\3\2\2\2\u0884\u0885\7\u00b8\2\2\u0885"+
		"\u0886\7\u00fe\2\2\u0886\u0888\7\u00e3\2\2\u0887\u0889\5\u0082B\2\u0888"+
		"\u0887\3\2\2\2\u0888\u0889\3\2\2\2\u0889\u0894\3\2\2\2\u088a\u088b\7\u0100"+
		"\2\2\u088b\u088d\7\u00e3\2\2\u088c\u088e\5\u0082B\2\u088d\u088c\3\2\2"+
		"\2\u088d\u088e\3\2\2\2\u088e\u0894\3\2\2\2\u088f\u0891\7\u0101\2\2\u0890"+
		"\u0892\5\u0082B\2\u0891\u0890\3\2\2\2\u0891\u0892\3\2\2\2\u0892\u0894"+
		"\3\2\2\2\u0893\u0870\3\2\2\2\u0893\u0875\3\2\2\2\u0893\u087a\3\2\2\2\u0893"+
		"\u087e\3\2\2\2\u0893\u0884\3\2\2\2\u0893\u088a\3\2\2\2\u0893\u088f\3\2"+
		"\2\2\u0894\u0085\3\2\2\2\u0895\u0897\7\u010a\2\2\u0896\u0898\5\u0082B"+
		"\2\u0897\u0896\3\2\2\2\u0897\u0898\3\2\2\2\u0898\u089e\3\2\2\2\u0899\u089b"+
		"\7\u010b\2\2\u089a\u089c\5\u0082B\2\u089b\u089a\3\2\2\2\u089b\u089c\3"+
		"\2\2\2\u089c\u089e\3\2\2\2\u089d\u0895\3\2\2\2\u089d\u0899\3\2\2\2\u089e"+
		"\u0087\3\2\2\2\u089f\u08a2\5\u008aF\2\u08a0\u08a2\5\u008cG\2\u08a1\u089f"+
		"\3\2\2\2\u08a1\u08a0\3\2\2\2\u08a2\u0089\3\2\2\2\u08a3\u08a5\7\u00fc\2"+
		"\2\u08a4\u08a6\5\u008eH\2\u08a5\u08a4\3\2\2\2\u08a5\u08a6\3\2\2\2\u08a6"+
		"\u08b9\3\2\2\2\u08a7\u08a9\7\u00fd\2";
	private static final String _serializedATNSegment1 =
		"\2\u08a8\u08aa\5\u008eH\2\u08a9\u08a8\3\2\2\2\u08a9\u08aa\3\2\2\2\u08aa"+
		"\u08b9\3\2\2\2\u08ab\u08ad\7\u0090\2\2\u08ac\u08ae\5\u008eH\2\u08ad\u08ac"+
		"\3\2\2\2\u08ad\u08ae\3\2\2\2\u08ae\u08b9\3\2\2\2\u08af\u08b9\7\u00ed\2"+
		"\2\u08b0\u08b9\7\u00f1\2\2\u08b1\u08b9\7\u00ee\2\2\u08b2\u08b9\7\u00f2"+
		"\2\2\u08b3\u08b9\7\u00ef\2\2\u08b4\u08b9\7\u00f3\2\2\u08b5\u08b9\7\u00f4"+
		"\2\2\u08b6\u08b9\7\u00f0\2\2\u08b7\u08b9\7\u00f5\2\2\u08b8\u08a3\3\2\2"+
		"\2\u08b8\u08a7\3\2\2\2\u08b8\u08ab\3\2\2\2\u08b8\u08af\3\2\2\2\u08b8\u08b0"+
		"\3\2\2\2\u08b8\u08b1\3\2\2\2\u08b8\u08b2\3\2\2\2\u08b8\u08b3\3\2\2\2\u08b8"+
		"\u08b4\3\2\2\2\u08b8\u08b5\3\2\2\2\u08b8\u08b6\3\2\2\2\u08b8\u08b7\3\2"+
		"\2\2\u08b9\u008b\3\2\2\2\u08ba\u08bc\7\u00fa\2\2\u08bb\u08bd\5\u008eH"+
		"\2\u08bc\u08bb\3\2\2\2\u08bc\u08bd\3\2\2\2\u08bd\u08c5\3\2\2\2\u08be\u08c5"+
		"\7\u00f6\2\2\u08bf\u08c5\7\u00f8\2\2\u08c0\u08c5\7\u00f7\2\2\u08c1\u08c5"+
		"\7\u00fb\2\2\u08c2\u08c3\7\u00fb\2\2\u08c3\u08c5\7\u00c2\2\2\u08c4\u08ba"+
		"\3\2\2\2\u08c4\u08be\3\2\2\2\u08c4\u08bf\3\2\2\2\u08c4\u08c0\3\2\2\2\u08c4"+
		"\u08c1\3\2\2\2\u08c4\u08c2\3\2\2\2\u08c5\u008d\3\2\2\2\u08c6\u08c7\7\u011d"+
		"\2\2\u08c7\u08c8\7\u0129\2\2\u08c8\u08cf\7\u011e\2\2\u08c9\u08ca\7\u011d"+
		"\2\2\u08ca\u08cb\7\u0129\2\2\u08cb\u08cc\7\u0116\2\2\u08cc\u08cd\7\u0129"+
		"\2\2\u08cd\u08cf\7\u011e\2\2\u08ce\u08c6\3\2\2\2\u08ce\u08c9\3\2\2\2\u08cf"+
		"\u008f\3\2\2\2\u08d0\u08d1\t\22\2\2\u08d1\u0091\3\2\2\2\u08d2\u08e0\7"+
		"\u0102\2\2\u08d3\u08e0\7\u0103\2\2\u08d4\u08d5\7\u0103\2\2\u08d5\u08d6"+
		"\7{\2\2\u08d6\u08d7\7\u0103\2\2\u08d7\u08e0\7\u00e8\2\2\u08d8\u08e0\7"+
		"\u0104\2\2\u08d9\u08e0\7\u0105\2\2\u08da\u08db\7\u0105\2\2\u08db\u08dc"+
		"\7{\2\2\u08dc\u08dd\7\u0103\2\2\u08dd\u08e0\7\u00e8\2\2\u08de\u08e0\7"+
		"\u0106\2\2\u08df\u08d2\3\2\2\2\u08df\u08d3\3\2\2\2\u08df\u08d4\3\2\2\2"+
		"\u08df\u08d8\3\2\2\2\u08df\u08d9\3\2\2\2\u08df\u08da\3\2\2\2\u08df\u08de"+
		"\3\2\2\2\u08e0\u0093\3\2\2\2\u08e1\u08e3\7\u00eb\2\2\u08e2\u08e4\5\u0082"+
		"B\2\u08e3\u08e2\3\2\2\2\u08e3\u08e4\3\2\2\2\u08e4\u08ef\3\2\2\2\u08e5"+
		"\u08e7\7\u00ec\2\2\u08e6\u08e8\5\u0082B\2\u08e7\u08e6\3\2\2\2\u08e7\u08e8"+
		"\3\2\2\2\u08e8\u08ef\3\2\2\2\u08e9\u08ea\7\u00eb\2\2\u08ea\u08ec\7\u00e3"+
		"\2\2\u08eb\u08ed\5\u0082B\2\u08ec\u08eb\3\2\2\2\u08ec\u08ed\3\2\2\2\u08ed"+
		"\u08ef\3\2\2\2\u08ee\u08e1\3\2\2\2\u08ee\u08e5\3\2\2\2\u08ee\u08e9\3\2"+
		"\2\2\u08ef\u0095\3\2\2\2\u08f0\u08f2\7\u0108\2\2\u08f1\u08f3\5\u0082B"+
		"\2\u08f2\u08f1\3\2\2\2\u08f2\u08f3\3\2\2\2\u08f3\u08fe\3\2\2\2\u08f4\u08f5"+
		"\7\u0108\2\2\u08f5\u08f7\7\u00e3\2\2\u08f6\u08f8\5\u0082B\2\u08f7\u08f6"+
		"\3\2\2\2\u08f7\u08f8\3\2\2\2\u08f8\u08fe\3\2\2\2\u08f9\u08fb\7\u0109\2"+
		"\2\u08fa\u08fc\5\u0082B\2\u08fb\u08fa\3\2\2\2\u08fb\u08fc\3\2\2\2\u08fc"+
		"\u08fe\3\2\2\2\u08fd\u08f0\3\2\2\2\u08fd\u08f4\3\2\2\2\u08fd\u08f9\3\2"+
		"\2\2\u08fe\u0097\3\2\2\2\u08ff\u0902\5\u009aN\2\u0900\u0902\5\u009cO\2"+
		"\u0901\u08ff\3\2\2\2\u0901\u0900\3\2\2\2\u0902\u0099\3\2\2\2\u0903\u0904"+
		"\7\u011d\2\2\u0904\u0905\5\u00c8e\2\u0905\u0906\7\u011e\2\2\u0906\u009b"+
		"\3\2\2\2\u0907\u090f\5\u009eP\2\u0908\u090f\5\u0170\u00b9\2\u0909\u090f"+
		"\5\u00a4S\2\u090a\u090f\5\u0176\u00bc\2\u090b\u090f\5\u00b0Y\2\u090c\u090f"+
		"\5\u00c2b\2\u090d\u090f\5\u01aa\u00d6\2\u090e\u0907\3\2\2\2\u090e\u0908"+
		"\3\2\2\2\u090e\u0909\3\2\2\2\u090e\u090a\3\2\2\2\u090e\u090b\3\2\2\2\u090e"+
		"\u090c\3\2\2\2\u090e\u090d\3\2\2\2\u090f\u009d\3\2\2\2\u0910\u0911\5j"+
		"\66\2\u0911\u009f\3\2\2\2\u0912\u0913\t\23\2\2\u0913\u00a1\3\2\2\2\u0914"+
		"\u0916\5\u00d6l\2\u0915\u0914\3\2\2\2\u0915\u0916\3\2\2\2\u0916\u0917"+
		"\3\2\2\2\u0917\u0918\5\u00a0Q\2\u0918\u00a3\3\2\2\2\u0919\u091a\5\u00a6"+
		"T\2\u091a\u00a5\3\2\2\2\u091b\u091c\7\u008c\2\2\u091c\u091d\7\u011d\2"+
		"\2\u091d\u091e\7\u0121\2\2\u091e\u0924\7\u011e\2\2\u091f\u0921\5\u00a8"+
		"U\2\u0920\u0922\5\u00acW\2\u0921\u0920\3\2\2\2\u0921\u0922\3\2\2\2\u0922"+
		"\u0924\3\2\2\2\u0923\u091b\3\2\2\2\u0923\u091f\3\2\2\2\u0924\u00a7\3\2"+
		"\2\2\u0925\u0926\5\u00aaV\2\u0926\u0928\7\u011d\2\2\u0927\u0929\5\u016e"+
		"\u00b8\2\u0928\u0927\3\2\2\2\u0928\u0929\3\2\2\2\u0929\u092a\3\2\2\2\u092a"+
		"\u092b\5\u00c8e\2\u092b\u092c\7\u011e\2\2\u092c\u00a9\3\2\2\2\u092d\u092e"+
		"\t\24\2\2\u092e\u00ab\3\2\2\2\u092f\u0930\7\u009c\2\2\u0930\u0931\7\u011d"+
		"\2\2\u0931\u0932\7z\2\2\u0932\u0933\5\u0138\u009d\2\u0933\u0934\7\u011e"+
		"\2\2\u0934\u00ad\3\2\2\2\u0935\u0936\7\u00a0\2\2\u0936\u0937\7\u011d\2"+
		"\2\u0937\u0938\5\u0174\u00bb\2\u0938\u0939\7\u011e\2\2\u0939\u00af\3\2"+
		"\2\2\u093a\u093b\5\u00b4[\2\u093b\u00b1\3\2\2\2\u093c\u093d\7\u00b9\2"+
		"\2\u093d\u093e\7\u011d\2\2\u093e\u093f\5\u00ccg\2\u093f\u0940\7\u0116"+
		"\2\2\u0940\u0941\5\u00f2z\2\u0941\u0942\7\u011e\2\2\u0942\u094f\3\2\2"+
		"\2\u0943\u0944\7\u0086\2\2\u0944\u0945\7\u011d\2\2\u0945\u0948\5\u00cc"+
		"g\2\u0946\u0947\7\u0116\2\2\u0947\u0949\5\u00f2z\2\u0948\u0946\3\2\2\2"+
		"\u0949\u094a\3\2\2\2\u094a\u0948\3\2\2\2\u094a\u094b\3\2\2\2\u094b\u094c"+
		"\3\2\2\2\u094c\u094d\7\u011e\2\2\u094d\u094f\3\2\2\2\u094e\u093c\3\2\2"+
		"\2\u094e\u0943\3\2\2\2\u094f\u00b3\3\2\2\2\u0950\u0953\5\u00b6\\\2\u0951"+
		"\u0953\5\u00b8]\2\u0952\u0950\3\2\2\2\u0952\u0951\3\2\2\2\u0953\u00b5"+
		"\3\2\2\2\u0954\u0955\7\r\2\2\u0955\u0957\5\u00f2z\2\u0956\u0958\5\u00ba"+
		"^\2\u0957\u0956\3\2\2\2\u0958\u0959\3\2\2\2\u0959\u0957\3\2\2\2\u0959"+
		"\u095a\3\2\2\2\u095a\u095c\3\2\2\2\u095b\u095d\5\u00be`\2\u095c\u095b"+
		"\3\2\2\2\u095c\u095d\3\2\2\2\u095d\u095e\3\2\2\2\u095e\u095f\7\"\2\2\u095f"+
		"\u00b7\3\2\2\2\u0960\u0962\7\r\2\2\u0961\u0963\5\u00bc_\2\u0962\u0961"+
		"\3\2\2\2\u0963\u0964\3\2\2\2\u0964\u0962\3\2\2\2\u0964\u0965\3\2\2\2\u0965"+
		"\u0967\3\2\2\2\u0966\u0968\5\u00be`\2\u0967\u0966\3\2\2\2\u0967\u0968"+
		"\3\2\2\2\u0968\u0969\3\2\2\2\u0969\u096a\7\"\2\2\u096a\u00b9\3\2\2\2\u096b"+
		"\u096c\7y\2\2\u096c\u096d\5\u0138\u009d\2\u096d\u096e\7l\2\2\u096e\u096f"+
		"\5\u00c0a\2\u096f\u00bb\3\2\2\2\u0970\u0971\7y\2\2\u0971\u0972\5\u0138"+
		"\u009d\2\u0972\u0973\7l\2\2\u0973\u0974\5\u00c0a\2\u0974\u00bd\3\2\2\2"+
		"\u0975\u0976\7#\2\2\u0976\u0977\5\u00c0a\2\u0977\u00bf\3\2\2\2\u0978\u097b"+
		"\5\u00c8e\2\u0979\u097b\7J\2\2\u097a\u0978\3\2\2\2\u097a\u0979\3\2\2\2"+
		"\u097b\u00c1\3\2\2\2\u097c\u097d\7\17\2\2\u097d\u097e\7\u011d\2\2\u097e"+
		"\u097f\5\u00c4c\2\u097f\u0980\7\5\2\2\u0980\u0981\5\u00c6d\2\u0981\u0982"+
		"\7\u011e\2\2\u0982\u00c3\3\2\2\2\u0983\u0984\5\u00c8e\2\u0984\u00c5\3"+
		"\2\2\2\u0985\u0986\5x=\2\u0986\u00c7\3\2\2\2\u0987\u098b\5\u00caf\2\u0988"+
		"\u098b\5\u0106\u0084\2\u0989\u098b\5\u00f2z\2\u098a\u0987\3\2\2\2\u098a"+
		"\u0988\3\2\2\2\u098a\u0989\3\2\2\2\u098b\u00c9\3\2\2\2\u098c\u0990\5\u00cc"+
		"g\2\u098d\u0990\5\u00e2r\2\u098e\u0990\7J\2\2\u098f\u098c\3\2\2\2\u098f"+
		"\u098d\3\2\2\2\u098f\u098e\3\2\2\2\u0990\u00cb\3\2\2\2\u0991\u0996\5\u00ce"+
		"h\2\u0992\u0993\t\25\2\2\u0993\u0995\5\u00ceh\2\u0994\u0992\3\2\2\2\u0995"+
		"\u0998\3\2\2\2\u0996\u0994\3\2\2\2\u0996\u0997\3\2\2\2\u0997\u00cd\3\2"+
		"\2\2\u0998\u0996\3\2\2\2\u0999\u099e\5\u00d0i\2\u099a\u099b\t\26\2\2\u099b"+
		"\u099d\5\u00d0i\2\u099c\u099a\3\2\2\2\u099d\u09a0\3\2\2\2\u099e\u099c"+
		"\3\2\2\2\u099e\u099f\3\2\2\2\u099f\u00cf\3\2\2\2\u09a0\u099e\3\2\2\2\u09a1"+
		"\u09a3\5\u00d6l\2\u09a2\u09a1\3\2\2\2\u09a2\u09a3\3\2\2\2\u09a3\u09a4"+
		"\3\2\2\2\u09a4\u09a5\5\u00d4k\2\u09a5\u00d1\3\2\2\2\u09a6\u09a7\7\u011d"+
		"\2\2\u09a7\u09ac\5\u00ccg\2\u09a8\u09a9\7\u0116\2\2\u09a9\u09ab\5\u00cc"+
		"g\2\u09aa\u09a8\3\2\2\2\u09ab\u09ae\3\2\2\2\u09ac\u09aa\3\2\2\2\u09ac"+
		"\u09ad\3\2\2\2\u09ad\u09af\3\2\2\2\u09ae\u09ac\3\2\2\2\u09af\u09b0\7\u011e"+
		"\2\2\u09b0\u00d3\3\2\2\2\u09b1\u09b6\5\u0098M\2\u09b2\u09b3\7\u0111\2"+
		"\2\u09b3\u09b5\5\u00c6d\2\u09b4\u09b2\3\2\2\2\u09b5\u09b8\3\2\2\2\u09b6"+
		"\u09b4\3\2\2\2\u09b6\u09b7\3\2\2\2\u09b7\u09bb\3\2\2\2\u09b8\u09b6\3\2"+
		"\2\2\u09b9\u09bb\5\u00d8m\2\u09ba\u09b1\3\2\2\2\u09ba\u09b9\3\2\2\2\u09bb"+
		"\u00d5\3\2\2\2\u09bc\u09bd\t\25\2\2\u09bd\u00d7\3\2\2\2\u09be\u09bf\5"+
		"\u00dan\2\u09bf\u00d9\3\2\2\2\u09c0\u09c1\7\u009a\2\2\u09c1\u09c2\7\u011d"+
		"\2\2\u09c2\u09c3\5\u00dco\2\u09c3\u09c4\7/\2\2\u09c4\u09c5\5\u00e0q\2"+
		"\u09c5\u09c6\7\u011e\2\2\u09c6\u00db\3\2\2\2\u09c7\u09cb\5\u01a4\u00d3"+
		"\2\u09c8\u09cb\5\u00dep\2\u09c9\u09cb\5\u01a8\u00d5\2\u09ca\u09c7\3\2"+
		"\2\2\u09ca\u09c8\3\2\2\2\u09ca\u09c9\3\2\2\2\u09cb\u00dd\3\2\2\2\u09cc"+
		"\u09cd\t\27\2\2\u09cd\u00df\3\2\2\2\u09ce\u09d1\5\u0170\u00b9\2\u09cf"+
		"\u09d1\5n8\2\u09d0\u09ce\3\2\2\2\u09d0\u09cf\3\2\2\2\u09d1\u00e1\3\2\2"+
		"\2\u09d2\u09d3\5\u00e4s\2\u09d3\u00e3\3\2\2\2\u09d4\u09d9\5\u00e6t\2\u09d5"+
		"\u09d6\7\u0117\2\2\u09d6\u09d8\5\u00e6t\2\u09d7\u09d5\3\2\2\2\u09d8\u09db"+
		"\3\2\2\2\u09d9\u09d7\3\2\2\2\u09d9\u09da\3\2\2\2\u09da\u00e5\3\2\2\2\u09db"+
		"\u09d9\3\2\2\2\u09dc\u09dd\5\u00e8u\2\u09dd\u00e7\3\2\2\2\u09de\u09e1"+
		"\5\u0098M\2\u09df\u09e1\5\u00eav\2\u09e0\u09de\3\2\2\2\u09e0\u09df\3\2"+
		"\2\2\u09e1\u00e9\3\2\2\2\u09e2\u09e3\5\u00ecw\2\u09e3\u00eb\3\2\2\2\u09e4"+
		"\u09e5\7\u00dc\2\2\u09e5\u09e6\7\u011d\2\2\u09e6\u09e7\5\u00eex\2\u09e7"+
		"\u09e8\7\u011e\2\2\u09e8\u00ed\3\2\2\2\u09e9\u09eb\5\u00f0y\2\u09ea\u09e9"+
		"\3\2\2\2\u09ea\u09eb\3\2\2\2\u09eb\u09ed\3\2\2\2\u09ec\u09ee\5\u00e4s"+
		"\2\u09ed\u09ec\3\2\2\2\u09ed\u09ee\3\2\2\2\u09ee\u09ef\3\2\2\2\u09ef\u09f1"+
		"\7/\2\2\u09f0\u09ea\3\2\2\2\u09f0\u09f1\3\2\2\2\u09f1\u09f2\3\2\2\2\u09f2"+
		"\u09f8\5\u00e4s\2\u09f3\u09f4\5\u00e4s\2\u09f4\u09f5\7\u0116\2\2\u09f5"+
		"\u09f6\5\u00e4s\2\u09f6\u09f8\3\2\2\2\u09f7\u09f0\3\2\2\2\u09f7\u09f3"+
		"\3\2\2\2\u09f8\u00ef\3\2\2\2\u09f9\u09fa\t\30\2\2\u09fa\u00f1\3\2\2\2"+
		"\u09fb\u09fc\5\u00f4{\2\u09fc\u00f3\3\2\2\2\u09fd\u0a02\5\u00f6|\2\u09fe"+
		"\u09ff\7Q\2\2\u09ff\u0a01\5\u00f4{\2\u0a00\u09fe\3\2\2\2\u0a01\u0a04\3"+
		"\2\2\2\u0a02\u0a00\3\2\2\2\u0a02\u0a03\3\2\2\2\u0a03\u00f5\3\2\2\2\u0a04"+
		"\u0a02\3\2\2\2\u0a05\u0a0a\5\u00f8}\2\u0a06\u0a07\7\7\2\2\u0a07\u0a09"+
		"\5\u00f6|\2\u0a08\u0a06\3\2\2\2\u0a09\u0a0c\3\2\2\2\u0a0a\u0a08\3\2\2"+
		"\2\u0a0a\u0a0b\3\2\2\2\u0a0b\u00f7\3\2\2\2\u0a0c\u0a0a\3\2\2\2\u0a0d\u0a11"+
		"\5\u00fa~\2\u0a0e\u0a0f\7I\2\2\u0a0f\u0a11\5\u00fa~\2\u0a10\u0a0d\3\2"+
		"\2\2\u0a10\u0a0e\3\2\2\2\u0a11\u00f9\3\2\2\2\u0a12\u0a14\5\u0100\u0081"+
		"\2\u0a13\u0a15\5\u00fc\177\2\u0a14\u0a13\3\2\2\2\u0a14\u0a15\3\2\2\2\u0a15"+
		"\u00fb\3\2\2\2\u0a16\u0a18\7@\2\2\u0a17\u0a19\7I\2\2\u0a18\u0a17\3\2\2"+
		"\2\u0a18\u0a19\3\2\2\2\u0a19\u0a1a\3\2\2\2\u0a1a\u0a1b\5\u00fe\u0080\2"+
		"\u0a1b\u00fd\3\2\2\2\u0a1c\u0a1d\t\21\2\2\u0a1d\u00ff\3\2\2\2\u0a1e\u0a21"+
		"\5\u017e\u00c0\2\u0a1f\u0a21\5\u0102\u0082\2\u0a20\u0a1e\3\2\2\2\u0a20"+
		"\u0a1f\3\2\2\2\u0a21\u0101\3\2\2\2\u0a22\u0a25\5\u0104\u0083\2\u0a23\u0a25"+
		"\5\u009cO\2\u0a24\u0a22\3\2\2\2\u0a24\u0a23\3\2\2\2\u0a25\u0103\3\2\2"+
		"\2\u0a26\u0a27\7\u011d\2\2\u0a27\u0a28\5\u00f2z\2\u0a28\u0a29\7\u011e"+
		"\2\2\u0a29\u0105\3\2\2\2\u0a2a\u0a2d\5\u0108\u0085\2\u0a2b\u0a2d\5\u010a"+
		"\u0086\2\u0a2c\u0a2a\3\2\2\2\u0a2c\u0a2b\3\2\2\2\u0a2d\u0107\3\2\2\2\u0a2e"+
		"\u0a2f\5\u009cO\2\u0a2f\u0109\3\2\2\2\u0a30\u0a31\7J\2\2\u0a31\u010b\3"+
		"\2\2\2\u0a32\u0a35\5\u0108\u0085\2\u0a33\u0a35\5\u010e\u0088\2\u0a34\u0a32"+
		"\3\2\2\2\u0a34\u0a33\3\2\2\2\u0a35\u010d\3\2\2\2\u0a36\u0a39\5\u00caf"+
		"\2\u0a37\u0a39\5\u0102\u0082\2\u0a38\u0a36\3\2\2\2\u0a38\u0a37\3\2\2\2"+
		"\u0a39\u010f\3\2\2\2\u0a3a\u0a3c\5\u0112\u008a\2\u0a3b\u0a3d\5\u0136\u009c"+
		"\2\u0a3c\u0a3b\3\2\2\2\u0a3c\u0a3d\3\2\2\2\u0a3d\u0a3f\3\2\2\2\u0a3e\u0a40"+
		"\5\u013a\u009e\2\u0a3f\u0a3e\3\2\2\2\u0a3f\u0a40\3\2\2\2\u0a40\u0a42\3"+
		"\2\2\2\u0a41\u0a43\5\u014a\u00a6\2\u0a42\u0a41\3\2\2\2\u0a42\u0a43\3\2"+
		"\2\2\u0a43\u0a45\3\2\2\2\u0a44\u0a46\5\u01b2\u00da\2\u0a45\u0a44\3\2\2"+
		"\2\u0a45\u0a46\3\2\2\2\u0a46\u0a48\3\2\2\2\u0a47\u0a49\5\u01ba\u00de\2"+
		"\u0a48\u0a47\3\2\2\2\u0a48\u0a49\3\2\2\2\u0a49\u0111\3\2\2\2\u0a4a\u0a4b"+
		"\7/\2\2\u0a4b\u0a4c\5\u0114\u008b\2\u0a4c\u0113\3\2\2\2\u0a4d\u0a52\5"+
		"\u0116\u008c\2\u0a4e\u0a4f\7\u0116\2\2\u0a4f\u0a51\5\u0116\u008c\2\u0a50"+
		"\u0a4e\3\2\2\2\u0a51\u0a54\3\2\2\2\u0a52\u0a50\3\2\2\2\u0a52\u0a53\3\2"+
		"\2\2\u0a53\u0115\3\2\2\2\u0a54\u0a52\3\2\2\2\u0a55\u0a58\5\u0118\u008d"+
		"\2\u0a56\u0a58\5\u0130\u0099\2\u0a57\u0a55\3\2\2\2\u0a57\u0a56\3\2\2\2"+
		"\u0a58\u0117\3\2\2\2\u0a59\u0a5b\5\u0130\u0099\2\u0a5a\u0a5c\5\u011a\u008e"+
		"\2\u0a5b\u0a5a\3\2\2\2\u0a5c\u0a5d\3\2\2\2\u0a5d\u0a5b\3\2\2\2\u0a5d\u0a5e"+
		"\3\2\2\2\u0a5e\u0119\3\2\2\2\u0a5f\u0a60\7\27\2\2\u0a60\u0a61\7A\2\2\u0a61"+
		"\u0a73\5\u0130\u0099\2\u0a62\u0a64\5\u0124\u0093\2\u0a63\u0a62\3\2\2\2"+
		"\u0a63\u0a64\3\2\2\2\u0a64\u0a65\3\2\2\2\u0a65\u0a66\7A\2\2\u0a66\u0a67"+
		"\5\u0130\u0099\2\u0a67\u0a68\5\u012a\u0096\2\u0a68\u0a73\3\2\2\2\u0a69"+
		"\u0a6b\7H\2\2\u0a6a\u0a6c\5\u0124\u0093\2\u0a6b\u0a6a\3\2\2\2\u0a6b\u0a6c"+
		"\3\2\2\2\u0a6c\u0a6d\3\2\2\2\u0a6d\u0a6e\7A\2\2\u0a6e\u0a73\5\u0130\u0099"+
		"\2\u0a6f\u0a70\7r\2\2\u0a70\u0a71\7A\2\2\u0a71\u0a73\5\u0130\u0099\2\u0a72"+
		"\u0a5f\3\2\2\2\u0a72\u0a63\3\2\2\2\u0a72\u0a69\3\2\2\2\u0a72\u0a6f\3\2"+
		"\2\2\u0a73\u011b\3\2\2\2\u0a74\u0a75\7\27\2\2\u0a75\u0a76\7A\2\2\u0a76"+
		"\u0a77\5\u0130\u0099\2\u0a77\u011d\3\2\2\2\u0a78\u0a7a\5\u0124\u0093\2"+
		"\u0a79\u0a78\3\2\2\2\u0a79\u0a7a\3\2\2\2\u0a7a\u0a7b\3\2\2\2\u0a7b\u0a7c"+
		"\7A\2\2\u0a7c\u0a7d\5\u0130\u0099\2\u0a7d\u0a7e\5\u012a\u0096\2\u0a7e"+
		"\u011f\3\2\2\2\u0a7f\u0a81\7H\2\2\u0a80\u0a82\5\u0124\u0093\2\u0a81\u0a80"+
		"\3\2\2\2\u0a81\u0a82\3\2\2\2\u0a82\u0a83\3\2\2\2\u0a83\u0a84\7A\2\2\u0a84"+
		"\u0a85\5\u0130\u0099\2\u0a85\u0121\3\2\2\2\u0a86\u0a87\7r\2\2\u0a87\u0a88"+
		"\7A\2\2\u0a88\u0a89\5\u0130\u0099\2\u0a89\u0123\3\2\2\2\u0a8a\u0a8d\7"+
		";\2\2\u0a8b\u0a8d\5\u0126\u0094\2\u0a8c\u0a8a\3\2\2\2\u0a8c\u0a8b\3\2"+
		"\2\2\u0a8d\u0125\3\2\2\2\u0a8e\u0a90\5\u0128\u0095\2\u0a8f\u0a91\7N\2"+
		"\2\u0a90\u0a8f\3\2\2\2\u0a90\u0a91\3\2\2\2\u0a91\u0127\3\2\2\2\u0a92\u0a93"+
		"\t\31\2\2\u0a93\u0129\3\2\2\2\u0a94\u0a97\5\u012c\u0097\2\u0a95\u0a97"+
		"\5\u012e\u0098\2\u0a96\u0a94\3\2\2\2\u0a96\u0a95\3\2\2\2\u0a97\u012b\3"+
		"\2\2\2\u0a98\u0a99\7M\2\2\u0a99\u0a9a\5\u0138\u009d\2\u0a9a\u012d\3\2"+
		"\2\2\u0a9b\u0a9c\7v\2\2\u0a9c\u0a9d\7\u011d\2\2\u0a9d\u0a9e\5\u0174\u00bb"+
		"\2\u0a9e\u0a9f\7\u011e\2\2\u0a9f\u012f\3\2\2\2\u0aa0\u0aa5\5\u0160\u00b1"+
		"\2\u0aa1\u0aa3\7\5\2\2\u0aa2\u0aa1\3\2\2\2\u0aa2\u0aa3\3\2\2\2\u0aa3\u0aa4"+
		"\3\2\2\2\u0aa4\u0aa6\5f\64\2\u0aa5\u0aa2\3\2\2\2\u0aa5\u0aa6\3\2\2\2\u0aa6"+
		"\u0aab\3\2\2\2\u0aa7\u0aa8\7\u011d\2\2\u0aa8\u0aa9\5\u0132\u009a\2\u0aa9"+
		"\u0aaa\7\u011e\2\2\u0aaa\u0aac\3\2\2\2\u0aab\u0aa7\3\2\2\2\u0aab\u0aac"+
		"\3\2\2\2\u0aac\u0ab9\3\2\2\2\u0aad\u0aaf\5\u0134\u009b\2\u0aae\u0ab0\7"+
		"\5\2\2\u0aaf\u0aae\3\2\2\2\u0aaf\u0ab0\3\2\2\2\u0ab0\u0ab1\3\2\2\2\u0ab1"+
		"\u0ab6\5f\64\2\u0ab2\u0ab3\7\u011d\2\2\u0ab3\u0ab4\5\u0132\u009a\2\u0ab4"+
		"\u0ab5\7\u011e\2\2\u0ab5\u0ab7\3\2\2\2\u0ab6\u0ab2\3\2\2\2\u0ab6\u0ab7"+
		"\3\2\2\2\u0ab7\u0ab9\3\2\2\2\u0ab8\u0aa0\3\2\2\2\u0ab8\u0aad\3\2\2\2\u0ab9"+
		"\u0131\3\2\2\2\u0aba\u0abf\5f\64\2\u0abb\u0abc\7\u0116\2\2\u0abc\u0abe"+
		"\5f\64\2\u0abd\u0abb\3\2\2\2\u0abe\u0ac1\3\2\2\2\u0abf\u0abd\3\2\2\2\u0abf"+
		"\u0ac0\3\2\2\2\u0ac0\u0133\3\2\2\2\u0ac1\u0abf\3\2\2\2\u0ac2\u0ac3\5\u017a"+
		"\u00be\2\u0ac3\u0135\3\2\2\2\u0ac4\u0ac5\7z\2\2\u0ac5\u0ac6\5\u0138\u009d"+
		"\2\u0ac6\u0137\3\2\2\2\u0ac7\u0ac8\5\u00c8e\2\u0ac8\u0139\3\2\2\2\u0ac9"+
		"\u0aca\7\62\2\2\u0aca\u0acb\7\u0080\2\2\u0acb\u0acc\5\u013c\u009f\2\u0acc"+
		"\u013b\3\2\2\2\u0acd\u0ad2\5\u013e\u00a0\2\u0ace\u0acf\7\u0116\2\2\u0acf"+
		"\u0ad1\5\u013e\u00a0\2\u0ad0\u0ace\3\2\2\2\u0ad1\u0ad4\3\2\2\2\u0ad2\u0ad0"+
		"\3\2\2\2\u0ad2\u0ad3\3\2\2\2\u0ad3\u013d\3\2\2\2\u0ad4\u0ad2\3\2\2\2\u0ad5"+
		"\u0ada\5\u0144\u00a3\2\u0ad6\u0ada\5\u0146\u00a4\2\u0ad7\u0ada\5\u0148"+
		"\u00a5\2\u0ad8\u0ada\5\u0140\u00a1\2\u0ad9\u0ad5\3\2\2\2\u0ad9\u0ad6\3"+
		"\2\2\2\u0ad9\u0ad7\3\2\2\2\u0ad9\u0ad8\3\2\2\2\u0ada\u013f\3\2\2\2\u0adb"+
		"\u0ae1\5\u010c\u0087\2\u0adc\u0add\7\u011d\2\2\u0add\u0ade\5\u014c\u00a7"+
		"\2\u0ade\u0adf\7\u011e\2\2\u0adf\u0ae1\3\2\2\2\u0ae0\u0adb\3\2\2\2\u0ae0"+
		"\u0adc\3\2\2\2\u0ae1\u0141\3\2\2\2\u0ae2\u0ae7\5\u0140\u00a1\2\u0ae3\u0ae4"+
		"\7\u0116\2\2\u0ae4\u0ae6\5\u0140\u00a1\2\u0ae5\u0ae3\3\2\2\2\u0ae6\u0ae9"+
		"\3\2\2\2\u0ae7\u0ae5\3\2\2\2\u0ae7\u0ae8\3\2\2\2\u0ae8\u0143\3\2\2\2\u0ae9"+
		"\u0ae7\3\2\2\2\u0aea\u0aeb\7\u00c9\2\2\u0aeb\u0aec\7\u011d\2\2\u0aec\u0aed"+
		"\5\u0142\u00a2\2\u0aed\u0aee\7\u011e\2\2\u0aee\u0145\3\2\2\2\u0aef\u0af0"+
		"\7\u008d\2\2\u0af0\u0af1\7\u011d\2\2\u0af1\u0af2\5\u0142\u00a2\2\u0af2"+
		"\u0af3\7\u011e\2\2\u0af3\u0147\3\2\2\2\u0af4\u0af5\7\u011d\2\2\u0af5\u0af6"+
		"\7\u011e\2\2\u0af6\u0149\3\2\2\2\u0af7\u0af8\7\63\2\2\u0af8\u0af9\5\u00f2"+
		"z\2\u0af9\u014b\3\2\2\2\u0afa\u0aff\5\u010c\u0087\2\u0afb\u0afc\7\u0116"+
		"\2\2\u0afc\u0afe\5\u010c\u0087\2\u0afd\u0afb\3\2\2\2\u0afe\u0b01\3\2\2"+
		"\2\u0aff\u0afd\3\2\2\2\u0aff\u0b00\3\2\2\2\u0b00\u014d\3\2\2\2\u0b01\u0aff"+
		"\3\2\2\2\u0b02\u0b03\5\u0150\u00a9\2\u0b03\u014f\3\2\2\2\u0b04\u0b07\5"+
		"\u0152\u00aa\2\u0b05\u0b07\5\u0118\u008d\2\u0b06\u0b04\3\2\2\2\u0b06\u0b05"+
		"\3\2\2\2\u0b07\u0151\3\2\2\2\u0b08\u0b11\5\u0156\u00ac\2\u0b09\u0b0a\5"+
		"\u0118\u008d\2\u0b0a\u0b0c\t\32\2\2\u0b0b\u0b0d\t\33\2\2\u0b0c\u0b0b\3"+
		"\2\2\2\u0b0c\u0b0d\3\2\2\2\u0b0d\u0b0e\3\2\2\2\u0b0e\u0b0f\5\u0154\u00ab"+
		"\2\u0b0f\u0b11\3\2\2\2\u0b10\u0b08\3\2\2\2\u0b10\u0b09\3\2\2\2\u0b11\u0b19"+
		"\3\2\2\2\u0b12\u0b14\t\32\2\2\u0b13\u0b15\t\33\2\2\u0b14\u0b13\3\2\2\2"+
		"\u0b14\u0b15\3\2\2\2\u0b15\u0b16\3\2\2\2\u0b16\u0b18\5\u0154\u00ab\2\u0b17"+
		"\u0b12\3\2\2\2\u0b18\u0b1b\3\2\2\2\u0b19\u0b17\3\2\2\2\u0b19\u0b1a\3\2"+
		"\2\2\u0b1a\u0153\3\2\2\2\u0b1b\u0b19\3\2\2\2\u0b1c\u0b1f\5\u0156\u00ac"+
		"\2\u0b1d\u0b1f\5\u0118\u008d\2\u0b1e\u0b1c\3\2\2\2\u0b1e\u0b1d\3\2\2\2"+
		"\u0b1f\u0155\3\2\2\2\u0b20\u0b29\5\u015a\u00ae\2\u0b21\u0b22\5\u0118\u008d"+
		"\2\u0b22\u0b24\7<\2\2\u0b23\u0b25\t\33\2\2\u0b24\u0b23\3\2\2\2\u0b24\u0b25"+
		"\3\2\2\2\u0b25\u0b26\3\2\2\2\u0b26\u0b27\5\u0158\u00ad\2\u0b27\u0b29\3"+
		"\2\2\2\u0b28\u0b20\3\2\2\2\u0b28\u0b21\3\2\2\2\u0b29\u0b31\3\2\2\2\u0b2a"+
		"\u0b2c\7<\2\2\u0b2b\u0b2d\t\33\2\2\u0b2c\u0b2b\3\2\2\2\u0b2c\u0b2d\3\2"+
		"\2\2\u0b2d\u0b2e\3\2\2\2\u0b2e\u0b30\5\u0158\u00ad\2\u0b2f\u0b2a\3\2\2"+
		"\2\u0b30\u0b33\3\2\2\2\u0b31\u0b2f\3\2\2\2\u0b31\u0b32\3\2\2\2\u0b32\u0157"+
		"\3\2\2\2\u0b33\u0b31\3\2\2\2\u0b34\u0b37\5\u015a\u00ae\2\u0b35\u0b37\5"+
		"\u0118\u008d\2\u0b36\u0b34\3\2\2\2\u0b36\u0b35\3\2\2\2\u0b37\u0159\3\2"+
		"\2\2\u0b38\u0b3e\5\u015c\u00af\2\u0b39\u0b3a\7\u011d\2\2\u0b3a\u0b3b\5"+
		"\u0152\u00aa\2\u0b3b\u0b3c\7\u011e\2\2\u0b3c\u0b3e\3\2\2\2\u0b3d\u0b38"+
		"\3\2\2\2\u0b3d\u0b39\3\2\2\2\u0b3e\u015b\3\2\2\2\u0b3f\u0b42\5\u0164\u00b3"+
		"\2\u0b40\u0b42\5\u015e\u00b0\2\u0b41\u0b3f\3\2\2\2\u0b41\u0b40\3\2\2\2"+
		"\u0b42\u015d\3\2\2\2\u0b43\u0b44\7i\2\2\u0b44\u0b45\5\u0160\u00b1\2\u0b45"+
		"\u015f\3\2\2\2\u0b46\u0b49\5\u0162\u00b2\2\u0b47\u0b49\5f\64\2\u0b48\u0b46"+
		"\3\2\2\2\u0b48\u0b47\3\2\2\2\u0b49\u0161\3\2\2\2\u0b4a\u0b51\5f\64\2\u0b4b"+
		"\u0b4c\7\u0124\2\2\u0b4c\u0b4f\5f\64\2\u0b4d\u0b4e\7\u0124\2\2\u0b4e\u0b50"+
		"\5f\64\2\u0b4f\u0b4d\3\2\2\2\u0b4f\u0b50\3\2\2\2\u0b50\u0b52\3\2\2\2\u0b51"+
		"\u0b4b\3\2\2\2\u0b51\u0b52\3\2\2\2\u0b52\u0163\3\2\2\2\u0b53\u0b55\7d"+
		"\2\2\u0b54\u0b56\5\u016e\u00b8\2\u0b55\u0b54\3\2\2\2\u0b55\u0b56\3\2\2"+
		"\2\u0b56\u0b57\3\2\2\2\u0b57\u0b59\5\u0166\u00b4\2\u0b58\u0b5a\5\u0110"+
		"\u0089\2\u0b59\u0b58\3\2\2\2\u0b59\u0b5a\3\2\2\2\u0b5a\u0165\3\2\2\2\u0b5b"+
		"\u0b60\5\u0168\u00b5\2\u0b5c\u0b5d\7\u0116\2\2\u0b5d\u0b5f\5\u0168\u00b5"+
		"\2\u0b5e\u0b5c\3\2\2\2\u0b5f\u0b62\3\2\2\2\u0b60\u0b5e\3\2\2\2\u0b60\u0b61"+
		"\3\2\2\2\u0b61\u0167\3\2\2\2\u0b62\u0b60\3\2\2\2\u0b63\u0b66\5\u016a\u00b6"+
		"\2\u0b64\u0b66\5\u016c\u00b7\2\u0b65\u0b63\3\2\2\2\u0b65\u0b64\3\2\2\2"+
		"\u0b66\u0169\3\2\2\2\u0b67\u0b69\5\u00c8e\2\u0b68\u0b6a\5\u0172\u00ba"+
		"\2\u0b69\u0b68\3\2\2\2\u0b69\u0b6a\3\2\2\2\u0b6a\u016b\3\2\2\2\u0b6b\u0b6c"+
		"\7\u012d\2\2\u0b6c\u0b6e\7\u0124\2\2\u0b6d\u0b6b\3\2\2\2\u0b6d\u0b6e\3"+
		"\2\2\2\u0b6e\u0b6f\3\2\2\2\u0b6f\u0b70\7\u0121\2\2\u0b70\u016d\3\2\2\2"+
		"\u0b71\u0b72\t\33\2\2\u0b72\u016f\3\2\2\2\u0b73\u0b74\5f\64\2\u0b74\u0b75"+
		"\7\u0124\2\2\u0b75\u0b77\3\2\2\2\u0b76\u0b73\3\2\2\2\u0b76\u0b77\3\2\2"+
		"\2\u0b77\u0b78\3\2\2\2\u0b78\u0b79\5f\64\2\u0b79\u0171\3\2\2\2\u0b7a\u0b7c"+
		"\7\5\2\2\u0b7b\u0b7a\3\2\2\2\u0b7b\u0b7c\3\2\2\2\u0b7c\u0b7d\3\2\2\2\u0b7d"+
		"\u0b7e\5f\64\2\u0b7e\u0173\3\2\2\2\u0b7f\u0b84\5\u0170\u00b9\2\u0b80\u0b81"+
		"\7\u0116\2\2\u0b81\u0b83\5\u0170\u00b9\2\u0b82\u0b80\3\2\2\2\u0b83\u0b86"+
		"\3\2\2\2\u0b84\u0b82\3\2\2\2\u0b84\u0b85\3\2\2\2\u0b85\u0175\3\2\2\2\u0b86"+
		"\u0b84\3\2\2\2\u0b87\u0b88\5\u017c\u00bf\2\u0b88\u0177\3\2\2\2\u0b89\u0b8a"+
		"\5\u017c\u00bf\2\u0b8a\u0179\3\2\2\2\u0b8b\u0b8c\5\u017c\u00bf\2\u0b8c"+
		"\u017b\3\2\2\2\u0b8d\u0b8e\7\u011d\2\2\u0b8e\u0b8f\5\u014e\u00a8\2\u0b8f"+
		"\u0b90\7\u011e\2\2\u0b90\u017d\3\2\2\2\u0b91\u0b98\5\u0180\u00c1\2\u0b92"+
		"\u0b98\5\u0184\u00c3\2\u0b93\u0b98\5\u0188\u00c5\2\u0b94\u0b98\5\u018e"+
		"\u00c8\2\u0b95\u0b98\5\u0196\u00cc\2\u0b96\u0b98\5\u01a0\u00d1\2\u0b97"+
		"\u0b91\3\2\2\2\u0b97\u0b92\3\2\2\2\u0b97\u0b93\3\2\2\2\u0b97\u0b94\3\2"+
		"\2\2\u0b97\u0b95\3\2\2\2\u0b97\u0b96\3\2\2\2\u0b98\u017f\3\2\2\2\u0b99"+
		"\u0b9a\5\u010c\u0087\2\u0b9a\u0b9b\5\u0182\u00c2\2\u0b9b\u0b9c\5\u010c"+
		"\u0087\2\u0b9c\u0181\3\2\2\2\u0b9d\u0b9e\t\34\2\2\u0b9e\u0183\3\2\2\2"+
		"\u0b9f\u0ba0\5\u010c\u0087\2\u0ba0\u0ba1\5\u0186\u00c4\2\u0ba1\u0185\3"+
		"\2\2\2\u0ba2\u0ba4\7I\2\2\u0ba3\u0ba2\3\2\2\2\u0ba3\u0ba4\3\2\2\2\u0ba4"+
		"\u0ba5\3\2\2\2\u0ba5\u0ba7\7\177\2\2\u0ba6\u0ba8\t\35\2\2\u0ba7\u0ba6"+
		"\3\2\2\2\u0ba7\u0ba8\3\2\2\2\u0ba8\u0ba9\3\2\2\2\u0ba9\u0baa\5\u010c\u0087"+
		"\2\u0baa\u0bab\7\7\2\2\u0bab\u0bac\5\u010c\u0087\2\u0bac\u0187\3\2\2\2"+
		"\u0bad\u0baf\5\u00ccg\2\u0bae\u0bb0\7I\2\2\u0baf\u0bae\3\2\2\2\u0baf\u0bb0"+
		"\3\2\2\2\u0bb0\u0bb1\3\2\2\2\u0bb1\u0bb2\7\67\2\2\u0bb2\u0bb3\5\u018a"+
		"\u00c6\2\u0bb3\u0189\3\2\2\2\u0bb4\u0bba\5\u017a\u00be\2\u0bb5\u0bb6\7"+
		"\u011d\2\2\u0bb6\u0bb7\5\u018c\u00c7\2\u0bb7\u0bb8\7\u011e\2\2\u0bb8\u0bba"+
		"\3\2\2\2\u0bb9\u0bb4\3\2\2\2\u0bb9\u0bb5\3\2\2\2\u0bba\u018b\3\2\2\2\u0bbb"+
		"\u0bc0\5\u0106\u0084\2\u0bbc\u0bbd\7\u0116\2\2\u0bbd\u0bbf\5\u0106\u0084"+
		"\2\u0bbe\u0bbc\3\2\2\2\u0bbf\u0bc2\3\2\2\2\u0bc0\u0bbe\3\2\2\2\u0bc0\u0bc1"+
		"\3\2\2\2\u0bc1\u018d\3\2\2\2\u0bc2\u0bc0\3\2\2\2\u0bc3\u0bc4\5\u010c\u0087"+
		"\2\u0bc4\u0bc5\5\u0190\u00c9\2\u0bc5\u0bc6\7\u012e\2\2\u0bc6\u018f\3\2"+
		"\2\2\u0bc7\u0bc9\7I\2\2\u0bc8\u0bc7\3\2\2\2\u0bc8\u0bc9\3\2\2\2\u0bc9"+
		"\u0bca\3\2\2\2\u0bca\u0bcd\5\u0192\u00ca\2\u0bcb\u0bcd\5\u0194\u00cb\2"+
		"\u0bcc\u0bc8\3\2\2\2\u0bcc\u0bcb\3\2\2\2\u0bcd\u0191\3\2\2\2\u0bce\u0bd5"+
		"\7E\2\2\u0bcf\u0bd5\7\65\2\2\u0bd0\u0bd1\7\u00ce\2\2\u0bd1\u0bd5\7\u00dd"+
		"\2\2\u0bd2\u0bd5\7\u00c7\2\2\u0bd3\u0bd5\7\u00c8\2\2\u0bd4\u0bce\3\2\2"+
		"\2\u0bd4\u0bcf\3\2\2\2\u0bd4\u0bd0\3\2\2\2\u0bd4\u0bd2\3\2\2\2\u0bd4\u0bd3"+
		"\3\2\2\2\u0bd5\u0193\3\2\2\2\u0bd6\u0bd7\t\36\2\2\u0bd7\u0195\3\2\2\2"+
		"\u0bd8\u0bd9\5\u010c\u0087\2\u0bd9\u0bdb\7@\2\2\u0bda\u0bdc\7I\2\2\u0bdb"+
		"\u0bda\3\2\2\2\u0bdb\u0bdc\3\2\2\2\u0bdc\u0bdd\3\2\2\2\u0bdd\u0bde\7J"+
		"\2\2\u0bde\u0197\3\2\2\2\u0bdf\u0be0\5\u00ccg\2\u0be0\u0be1\5\u0182\u00c2"+
		"\2\u0be1\u0be2\5\u019a\u00ce\2\u0be2\u0be3\5\u017a\u00be\2\u0be3\u0199"+
		"\3\2\2\2\u0be4\u0be7\5\u019c\u00cf\2\u0be5\u0be7\5\u019e\u00d0\2\u0be6"+
		"\u0be4\3\2\2\2\u0be6\u0be5\3\2\2\2\u0be7\u019b\3\2\2\2\u0be8\u0be9\7\6"+
		"\2\2\u0be9\u019d\3\2\2\2\u0bea\u0beb\t\37\2\2\u0beb\u019f\3\2\2\2\u0bec"+
		"\u0bee\7I\2\2\u0bed\u0bec\3\2\2\2\u0bed\u0bee\3\2\2\2\u0bee\u0bef\3\2"+
		"\2\2\u0bef\u0bf0\7\u0098\2\2\u0bf0\u0bf1\5\u017a\u00be\2\u0bf1\u01a1\3"+
		"\2\2\2\u0bf2\u0bf3\7s\2\2\u0bf3\u0bf4\5\u017a\u00be\2\u0bf4\u01a3\3\2"+
		"\2\2\u0bf5\u0bf8\5\u01a6\u00d4\2\u0bf6\u0bf8\7\u00cb\2\2\u0bf7\u0bf5\3"+
		"\2\2\2\u0bf7\u0bf6\3\2\2\2\u0bf8\u01a5\3\2\2\2\u0bf9\u0bfa\t \2\2\u0bfa"+
		"\u01a7\3\2\2\2\u0bfb\u0bfc\t!\2\2\u0bfc\u01a9\3\2\2\2\u0bfd\u0bfe\5\u01ae"+
		"\u00d8\2\u0bfe\u0c00\7\u011d\2\2\u0bff\u0c01\5\u01b0\u00d9\2\u0c00\u0bff"+
		"\3\2\2\2\u0c00\u0c01\3\2\2\2\u0c01\u0c02\3\2\2\2\u0c02\u0c03\7\u011e\2"+
		"\2\u0c03\u01ab\3\2\2\2\u0c04\u0c05\t\"\2\2\u0c05\u01ad\3\2\2\2\u0c06\u0c09"+
		"\5f\64\2\u0c07\u0c09\5\u01ac\u00d7\2\u0c08\u0c06\3\2\2\2\u0c08\u0c07\3"+
		"\2\2\2\u0c09\u01af\3\2\2\2\u0c0a\u0c0f\5\u00c8e\2\u0c0b\u0c0c\7\u0116"+
		"\2\2\u0c0c\u0c0e\5\u00c8e\2\u0c0d\u0c0b\3\2\2\2\u0c0e\u0c11\3\2\2\2\u0c0f"+
		"\u0c0d\3\2\2\2\u0c0f\u0c10\3\2\2\2\u0c10\u01b1\3\2\2\2\u0c11\u0c0f\3\2"+
		"\2\2\u0c12\u0c13\7R\2\2\u0c13\u0c14\7\u0080\2\2\u0c14\u0c15\5\u01b4\u00db"+
		"\2\u0c15\u01b3\3\2\2\2\u0c16\u0c1b\5\u01b6\u00dc\2\u0c17\u0c18\7\u0116"+
		"\2\2\u0c18\u0c1a\5\u01b6\u00dc\2\u0c19\u0c17\3\2\2\2\u0c1a\u0c1d\3\2\2"+
		"\2\u0c1b\u0c19\3\2\2\2\u0c1b\u0c1c\3\2\2\2\u0c1c\u01b5\3\2\2\2\u0c1d\u0c1b"+
		"\3\2\2\2\u0c1e\u0c20\5\u010c\u0087\2\u0c1f\u0c21\5\u01b8\u00dd\2\u0c20"+
		"\u0c1f\3\2\2\2\u0c20\u0c21\3\2\2\2\u0c21\u0c23\3\2\2\2\u0c22\u0c24\5\u01bc"+
		"\u00df\2\u0c23\u0c22\3\2\2\2\u0c23\u0c24\3\2\2\2\u0c24\u01b7\3\2\2\2\u0c25"+
		"\u0c26\t#\2\2\u0c26\u01b9\3\2\2\2\u0c27\u0c28\7F\2\2\u0c28\u0c29\5\u00cc"+
		"g\2\u0c29\u01bb\3\2\2\2\u0c2a\u0c2b\7J\2\2\u0c2b\u0c2f\7\u009d\2\2\u0c2c"+
		"\u0c2d\7J\2\2\u0c2d\u0c2f\7\u00ab\2\2\u0c2e\u0c2a\3\2\2\2\u0c2e\u0c2c"+
		"\3\2\2\2\u0c2f\u01bd\3\2\2\2\u0c30\u0c32\7\u00a5\2\2\u0c31\u0c33\7\u00bd"+
		"\2\2\u0c32\u0c31\3\2\2\2\u0c32\u0c33\3\2\2\2\u0c33\u0c34\3\2\2\2\u0c34"+
		"\u0c35\7=\2\2\u0c35\u0c3a\5\u0162\u00b2\2\u0c36\u0c37\7\u011d\2\2\u0c37"+
		"\u0c38\5\u0132\u009a\2\u0c38\u0c39\7\u011e\2\2\u0c39\u0c3b\3\2\2\2\u0c3a"+
		"\u0c36\3\2\2\2\u0c3a\u0c3b\3\2\2\2\u0c3b\u0c3c\3\2\2\2\u0c3c\u0c3d\5\u014e"+
		"\u00a8\2\u0c3d\u0c4e\3\2\2\2\u0c3e\u0c40\7\u00a5\2\2\u0c3f\u0c41\7\u00bd"+
		"\2\2\u0c40\u0c3f\3\2\2\2\u0c40\u0c41\3\2\2\2\u0c41\u0c42\3\2\2\2\u0c42"+
		"\u0c43\7=\2\2\u0c43\u0c44\7\u00ae\2\2\u0c44\u0c4a\7\u012e\2\2\u0c45\u0c46"+
		"\7v\2\2\u0c46\u0c48\5f\64\2\u0c47\u0c49\5@!\2\u0c48\u0c47\3\2\2\2\u0c48"+
		"\u0c49\3\2\2\2\u0c49\u0c4b\3\2\2\2\u0c4a\u0c45\3\2\2\2\u0c4a\u0c4b\3\2"+
		"\2\2\u0c4b\u0c4c\3\2\2\2\u0c4c\u0c4e\5\u014e\u00a8\2\u0c4d\u0c30\3\2\2"+
		"\2\u0c4d\u0c3e\3\2\2\2\u0c4e\u01bf\3\2\2\2\u01c0\u01c2\u01c6\u01d4\u01dc"+
		"\u01e0\u01e7\u01ed\u01f4\u01f8\u01fc\u0200\u0204\u0208\u0212\u0215\u0219"+
		"\u021d\u0224\u0227\u022b\u022d\u0231\u0239\u0242\u0246\u0248\u024a\u0250"+
		"\u0255\u025b\u025f\u0263\u0267\u026f\u0271\u0279\u027e\u0282\u0284\u0288"+
		"\u028d\u0296\u0298\u02a0\u02a6\u02aa\u02b0\u02b4\u02b9\u02bd\u02c1\u02c5"+
		"\u02c9\u02cd\u02d5\u02da\u02de\u02e0\u02e6\u02ea\u02f2\u02f6\u02f8\u0300"+
		"\u0305\u0309\u030b\u0311\u0315\u031d\u0322\u0324\u032c\u0330\u0338\u033d"+
		"\u033f\u0346\u034a\u0352\u0357\u0359\u035e\u0366\u036b\u036d\u0373\u0377"+
		"\u037f\u0384\u0386\u0388\u038c\u038e\u0395\u0399\u03a1\u03a5\u03a9\u03ad"+
		"\u03af\u03b5\u03b9\u03c1\u03c6\u03c8\u03ce\u03d2\u03da\u03de\u03e2\u03e7"+
		"\u03eb\u03ee\u03f0\u03f4\u03f9\u03fb\u03fd\u0400\u0406\u040a\u040c\u0410"+
		"\u0414\u0418\u0420\u0424\u0426\u042e\u0432\u0436\u043a\u043e\u0442\u0444"+
		"\u0448\u044c\u0450\u0457\u045b\u045f\u0461\u0467\u046b\u0473\u0477\u0479"+
		"\u0480\u0484\u0488\u048a\u0490\u0494\u049c\u049e\u04a6\u04aa\u04b2\u04b4"+
		"\u04bb\u04bf\u04c7\u04c9\u04ce\u04d6\u04d8\u04de\u04e2\u04e9\u04ed\u04f1"+
		"\u04f3\u04fa\u04fe\u0505\u0509\u050d\u050f\u0515\u0519\u0521\u0523\u0529"+
		"\u052d\u0533\u0537\u053c\u0540\u0545\u0547\u054b\u054f\u0552\u0556\u055b"+
		"\u0564\u0568\u05a8\u05d6\u05e3\u05e6\u05ea\u05ee\u05f9\u05fd\u0607\u060a"+
		"\u0615\u0618\u061b\u061f\u0626\u0629\u062c\u0633\u0637\u063d\u0645\u064a"+
		"\u0653\u0656\u0659\u065d\u065f\u0666\u066a\u066e\u0676\u067a\u0680\u068c"+
		"\u0690\u0693\u0697\u069b\u06a1\u06a8\u06af\u06b3\u06bd\u06c1\u06c9\u06d0"+
		"\u06d4\u06dd\u06e4\u06e8\u06f0\u06f4\u06f8\u0700\u0705\u070a\u070c\u0711"+
		"\u0717\u071b\u0731\u0736\u073b\u073d\u0742\u0748\u0754\u0757\u075b\u0764"+
		"\u076d\u076f\u0773\u077b\u077e\u0784\u078c\u079d\u07b2\u07c3\u07d0\u07d4"+
		"\u07d6\u07e3\u07ea\u0802\u0809\u081a\u081d\u0821\u0824\u082a\u082f\u0834"+
		"\u084d\u0855\u0859\u085e\u0863\u0867\u086a\u0873\u0878\u087c\u0882\u0888"+
		"\u088d\u0891\u0893\u0897\u089b\u089d\u08a1\u08a5\u08a9\u08ad\u08b8\u08bc"+
		"\u08c4\u08ce\u08df\u08e3\u08e7\u08ec\u08ee\u08f2\u08f7\u08fb\u08fd\u0901"+
		"\u090e\u0915\u0921\u0923\u0928\u094a\u094e\u0952\u0959\u095c\u0964\u0967"+
		"\u097a\u098a\u098f\u0996\u099e\u09a2\u09ac\u09b6\u09ba\u09ca\u09d0\u09d9"+
		"\u09e0\u09ea\u09ed\u09f0\u09f7\u0a02\u0a0a\u0a10\u0a14\u0a18\u0a20\u0a24"+
		"\u0a2c\u0a34\u0a38\u0a3c\u0a3f\u0a42\u0a45\u0a48\u0a52\u0a57\u0a5d\u0a63"+
		"\u0a6b\u0a72\u0a79\u0a81\u0a8c\u0a90\u0a96\u0aa2\u0aa5\u0aab\u0aaf\u0ab6"+
		"\u0ab8\u0abf\u0ad2\u0ad9\u0ae0\u0ae7\u0aff\u0b06\u0b0c\u0b10\u0b14\u0b19"+
		"\u0b1e\u0b24\u0b28\u0b2c\u0b31\u0b36\u0b3d\u0b41\u0b48\u0b4f\u0b51\u0b55"+
		"\u0b59\u0b60\u0b65\u0b69\u0b6d\u0b76\u0b7b\u0b84\u0b97\u0ba3\u0ba7\u0baf"+
		"\u0bb9\u0bc0\u0bc8\u0bcc\u0bd4\u0bdb\u0be6\u0bed\u0bf7\u0c00\u0c08\u0c0f"+
		"\u0c1b\u0c20\u0c23\u0c2e\u0c32\u0c3a\u0c40\u0c48\u0c4a\u0c4d";
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