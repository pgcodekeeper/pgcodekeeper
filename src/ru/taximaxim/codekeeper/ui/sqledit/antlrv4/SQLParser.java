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
		FUNCTION=33, ISODOW=129, OVERWRITE=149, FUNCTIONS=34, ROW=67, PRECISION=152, 
		ILIKE=40, Character_String_Literal=254, NOT=57, EXCEPT=26, FOREIGN=31, 
		PRIVILEGES=65, BYTEA=219, STATEMENT=77, CHARACTER=101, MONTH=144, BlockComment=251, 
		VARBIT=189, CREATE=14, STDDEV_POP=164, USING=91, NOT_EQUAL=232, TIMEZONE_MINUTE=173, 
		VERTICAL_BAR=246, VARIADIC=92, TIMESTAMPTZ=214, REGEXP=157, GEQ=236, STDDEV_SAMP=165, 
		DIVIDE=242, BLOB=218, ASC=7, GROUPING=123, SUBPARTITION=166, TEMP=80, 
		ELSE=25, NUMBER=249, BOOL=187, TRAILING=83, SEMI_COLON=229, INT=196, RLIKE=158, 
		LEADING=51, SERVER=161, TABLESPACE=168, MILLISECONDS=141, REAL=201, GROUP=37, 
		INTERSECT=45, LANGUAGE=131, SEQUENCES=73, OUT=62, REAL_NUMBER=250, TRIM=174, 
		LEFT_PAREN=237, LOCATION=136, END=24, CONSTRAINT=13, TIMEZONE_HOUR=172, 
		CAST_EXPRESSION=225, OPTION=148, ISOYEAR=130, NCHAR=208, EXECUTE=27, TABLE=79, 
		VARCHAR=207, FLOAT=202, MICROSECONDS=139, VERSION=181, ASYMMETRIC=6, SUM=167, 
		Space=255, INOUT=47, TIME=211, AS=2, RIGHT_PAREN=238, THEN=82, MAXVALUE=138, 
		REPLACE=69, LEFT=52, AVG=97, TRUNCATE=86, ZONE=185, COLUMN=104, PLUS=239, 
		EXISTS=116, NVARCHAR=209, Not_Similar_To=222, LIKE=53, INTEGER=197, OUTER=61, 
		BY=99, DEFERRABLE=18, TO=175, RIGHT=70, SET=162, HAVING=38, SESSION=75, 
		MIN=142, MINUS=240, TEXT=215, HOUR=125, CONCATENATION_OPERATOR=231, UNION=87, 
		COLON=228, SCHEMA=71, DATABASE=16, DECIMAL=205, DROP=113, BIGINT=198, 
		WHEN=93, BIT=188, LARGE=132, NATURAL=56, FORMAT=121, PUBLIC=153, EXTENSION=28, 
		BETWEEN=98, FIRST=120, CAST=11, EXTERNAL=117, WEEK=182, DOUBLE_QUOTE=248, 
		VARYING=180, TRIGGER=84, CASE=10, CHAR=206, INT8=193, COUNT=105, DAY=108, 
		INT2=191, INT1=190, Identifier=253, INT4=192, QUOTE=247, MODULAR=243, 
		FULL=32, QUARTER=155, THAN=170, INSERT=127, CONNECT=12, INTERSECTION=128, 
		LESS=134, TINYINT=194, BOTH=9, Similar_To_Case_Insensitive=223, DOUBLE=203, 
		ADMIN=96, SYMMETRIC=78, EACH=23, LAST=133, SELECT=74, INTO=46, UNIQUE=88, 
		COALESCE=103, SECOND=160, EPOCH=114, ROLLUP=159, NULL=58, EVERY=115, ON=60, 
		DELETE=20, INET4=220, NUMERIC=204, LOCAL=55, OF=59, LIST=135, TABLES=169, 
		UNDERLINE=245, SEQUENCE=72, Not_Similar_To_Case_Insensitive=224, CUBE=106, 
		NATIONAL=145, OR=63, VAR_POP=179, FILTER=119, FROM=35, FALSE=29, COLLECT=102, 
		TEMPORARY=81, DISTINCT=22, TIMESTAMP=213, WHERE=94, DEC=109, NULLIF=146, 
		VAR_SAMP=178, TIMETZ=212, INNER=44, YEAR=184, ORDER=64, TIMEZONE=171, 
		LIMIT=54, DECADE=110, GTH=235, White_Space=256, UPDATE=89, MAX=137, LineComment=252, 
		DEFERRED=19, FOR=30, FLOAT4=199, FLOAT8=200, AND=4, CROSS=15, Similar_To=221, 
		USAGE=90, IF=39, INDEX=126, BOOLEAN=186, IN=42, UNKNOWN=176, MULTIPLY=241, 
		OBJECT=147, COMMA=230, REFERENCES=68, IS=49, PARTITION=150, PARTITIONS=151, 
		SOME=76, EQUAL=227, ALL=3, DOT=244, EXTRACT=118, CENTURY=100, DOW=111, 
		WITH=95, INITIALLY=43, DOY=112, FUSION=122, GRANT=36, VARBINARY=217, DEFAULT=17, 
		VALUES=177, HASH=124, MILLENNIUM=140, RANGE=156, BEFORE=8, PURGE=154, 
		AFTER=1, INSTEAD=48, TRUE=85, WRAPPER=183, PROCEDURE=66, JOIN=50, SIMILAR=163, 
		LTH=233, ANY=5, BAD=257, ASSIGN=226, IMMEDIATE=41, BINARY=216, DESC=21, 
		DATE=210, MINUTE=143, DATA=107, LEQ=234, SMALLINT=195;
	public static final String[] tokenNames = {
		"<INVALID>", "AFTER", "AS", "ALL", "AND", "ANY", "ASYMMETRIC", "ASC", 
		"BEFORE", "BOTH", "CASE", "CAST", "CONNECT", "CONSTRAINT", "CREATE", "CROSS", 
		"DATABASE", "DEFAULT", "DEFERRABLE", "DEFERRED", "DELETE", "DESC", "DISTINCT", 
		"EACH", "END", "ELSE", "EXCEPT", "EXECUTE", "EXTENSION", "FALSE", "FOR", 
		"FOREIGN", "FULL", "FUNCTION", "FUNCTIONS", "FROM", "GRANT", "GROUP", 
		"HAVING", "IF", "ILIKE", "IMMEDIATE", "IN", "INITIALLY", "INNER", "INTERSECT", 
		"INTO", "INOUT", "INSTEAD", "IS", "JOIN", "LEADING", "LEFT", "LIKE", "LIMIT", 
		"LOCAL", "NATURAL", "NOT", "NULL", "OF", "ON", "OUTER", "OUT", "OR", "ORDER", 
		"PRIVILEGES", "PROCEDURE", "ROW", "REFERENCES", "REPLACE", "RIGHT", "SCHEMA", 
		"SEQUENCE", "SEQUENCES", "SELECT", "SESSION", "SOME", "STATEMENT", "SYMMETRIC", 
		"TABLE", "TEMP", "TEMPORARY", "THEN", "TRAILING", "TRIGGER", "TRUE", "TRUNCATE", 
		"UNION", "UNIQUE", "UPDATE", "USAGE", "USING", "VARIADIC", "WHEN", "WHERE", 
		"WITH", "ADMIN", "AVG", "BETWEEN", "BY", "CENTURY", "CHARACTER", "COLLECT", 
		"COALESCE", "COLUMN", "COUNT", "CUBE", "DATA", "DAY", "DEC", "DECADE", 
		"DOW", "DOY", "DROP", "EPOCH", "EVERY", "EXISTS", "EXTERNAL", "EXTRACT", 
		"FILTER", "FIRST", "FORMAT", "FUSION", "GROUPING", "HASH", "HOUR", "INDEX", 
		"INSERT", "INTERSECTION", "ISODOW", "ISOYEAR", "LANGUAGE", "LARGE", "LAST", 
		"LESS", "LIST", "LOCATION", "MAX", "MAXVALUE", "MICROSECONDS", "MILLENNIUM", 
		"MILLISECONDS", "MIN", "MINUTE", "MONTH", "NATIONAL", "NULLIF", "OBJECT", 
		"OPTION", "OVERWRITE", "PARTITION", "PARTITIONS", "PRECISION", "PUBLIC", 
		"PURGE", "QUARTER", "RANGE", "REGEXP", "RLIKE", "ROLLUP", "SECOND", "SERVER", 
		"SET", "SIMILAR", "STDDEV_POP", "STDDEV_SAMP", "SUBPARTITION", "SUM", 
		"TABLESPACE", "TABLES", "THAN", "TIMEZONE", "TIMEZONE_HOUR", "TIMEZONE_MINUTE", 
		"TRIM", "TO", "UNKNOWN", "VALUES", "VAR_SAMP", "VAR_POP", "VARYING", "VERSION", 
		"WEEK", "WRAPPER", "YEAR", "ZONE", "BOOLEAN", "BOOL", "BIT", "VARBIT", 
		"INT1", "INT2", "INT4", "INT8", "TINYINT", "SMALLINT", "INT", "INTEGER", 
		"BIGINT", "FLOAT4", "FLOAT8", "REAL", "FLOAT", "DOUBLE", "NUMERIC", "DECIMAL", 
		"CHAR", "VARCHAR", "NCHAR", "NVARCHAR", "DATE", "TIME", "TIMETZ", "TIMESTAMP", 
		"TIMESTAMPTZ", "TEXT", "BINARY", "VARBINARY", "BLOB", "BYTEA", "INET4", 
		"'~'", "'!~'", "'~*'", "'!~*'", "CAST_EXPRESSION", "':='", "'='", "':'", 
		"';'", "','", "CONCATENATION_OPERATOR", "NOT_EQUAL", "'<'", "'<='", "'>'", 
		"'>='", "'('", "')'", "'+'", "'-'", "'*'", "'/'", "'%'", "'.'", "'_'", 
		"'|'", "'''", "'\"'", "NUMBER", "REAL_NUMBER", "BlockComment", "LineComment", 
		"Identifier", "Character_String_Literal", "' '", "White_Space", "BAD"
	};
	public static final int
		RULE_sql = 0, RULE_statement = 1, RULE_data_statement = 2, RULE_data_change_statement = 3, 
		RULE_schema_statement = 4, RULE_index_statement = 5, RULE_create_extension_statement = 6, 
		RULE_set_statement = 7, RULE_create_trigger_statement = 8, RULE_grant_statement = 9, 
		RULE_grant_to_rule = 10, RULE_argmode = 11, RULE_create_table_statement = 12, 
		RULE_table_elements = 13, RULE_field_element = 14, RULE_field_type = 15, 
		RULE_param_clause = 16, RULE_param = 17, RULE_method_specifier = 18, RULE_table_space_specifier = 19, 
		RULE_table_space_name = 20, RULE_table_partitioning_clauses = 21, RULE_range_partitions = 22, 
		RULE_range_value_clause_list = 23, RULE_range_value_clause = 24, RULE_hash_partitions = 25, 
		RULE_individual_hash_partitions = 26, RULE_individual_hash_partition = 27, 
		RULE_hash_partitions_by_quantity = 28, RULE_list_partitions = 29, RULE_list_value_clause_list = 30, 
		RULE_list_value_partition = 31, RULE_column_partitions = 32, RULE_partition_name = 33, 
		RULE_drop_table_statement = 34, RULE_identifier = 35, RULE_nonreserved_keywords = 36, 
		RULE_unsigned_literal = 37, RULE_general_literal = 38, RULE_datetime_literal = 39, 
		RULE_time_literal = 40, RULE_timestamp_literal = 41, RULE_date_literal = 42, 
		RULE_boolean_literal = 43, RULE_data_type = 44, RULE_predefined_type = 45, 
		RULE_network_type = 46, RULE_character_string_type = 47, RULE_type_length = 48, 
		RULE_national_character_string_type = 49, RULE_binary_large_object_string_type = 50, 
		RULE_numeric_type = 51, RULE_exact_numeric_type = 52, RULE_approximate_numeric_type = 53, 
		RULE_precision_param = 54, RULE_boolean_type = 55, RULE_datetime_type = 56, 
		RULE_bit_type = 57, RULE_binary_type = 58, RULE_value_expression_primary = 59, 
		RULE_parenthesized_value_expression = 60, RULE_nonparenthesized_value_expression_primary = 61, 
		RULE_unsigned_value_specification = 62, RULE_unsigned_numeric_literal = 63, 
		RULE_signed_numerical_literal = 64, RULE_set_function_specification = 65, 
		RULE_aggregate_function = 66, RULE_general_set_function = 67, RULE_set_function_type = 68, 
		RULE_filter_clause = 69, RULE_grouping_operation = 70, RULE_case_expression = 71, 
		RULE_case_abbreviation = 72, RULE_case_specification = 73, RULE_simple_case = 74, 
		RULE_searched_case = 75, RULE_simple_when_clause = 76, RULE_searched_when_clause = 77, 
		RULE_else_clause = 78, RULE_result = 79, RULE_cast_specification = 80, 
		RULE_cast_operand = 81, RULE_cast_target = 82, RULE_value_expression = 83, 
		RULE_common_value_expression = 84, RULE_numeric_value_expression = 85, 
		RULE_term = 86, RULE_factor = 87, RULE_array = 88, RULE_numeric_primary = 89, 
		RULE_sign = 90, RULE_numeric_value_function = 91, RULE_extract_expression = 92, 
		RULE_extract_field = 93, RULE_time_zone_field = 94, RULE_extract_source = 95, 
		RULE_string_value_expression = 96, RULE_character_value_expression = 97, 
		RULE_character_factor = 98, RULE_character_primary = 99, RULE_string_value_function = 100, 
		RULE_trim_function = 101, RULE_trim_operands = 102, RULE_trim_specification = 103, 
		RULE_boolean_value_expression = 104, RULE_or_predicate = 105, RULE_and_predicate = 106, 
		RULE_boolean_factor = 107, RULE_boolean_test = 108, RULE_is_clause = 109, 
		RULE_truth_value = 110, RULE_boolean_primary = 111, RULE_boolean_predicand = 112, 
		RULE_parenthesized_boolean_value_expression = 113, RULE_row_value_expression = 114, 
		RULE_row_value_special_case = 115, RULE_explicit_row_value_constructor = 116, 
		RULE_row_value_predicand = 117, RULE_row_value_constructor_predicand = 118, 
		RULE_table_expression = 119, RULE_from_clause = 120, RULE_table_reference_list = 121, 
		RULE_table_reference = 122, RULE_joined_table = 123, RULE_joined_table_primary = 124, 
		RULE_cross_join = 125, RULE_qualified_join = 126, RULE_natural_join = 127, 
		RULE_union_join = 128, RULE_join_type = 129, RULE_outer_join_type = 130, 
		RULE_outer_join_type_part2 = 131, RULE_join_specification = 132, RULE_join_condition = 133, 
		RULE_named_columns_join = 134, RULE_table_primary = 135, RULE_column_name_list = 136, 
		RULE_derived_table = 137, RULE_where_clause = 138, RULE_search_condition = 139, 
		RULE_groupby_clause = 140, RULE_grouping_element_list = 141, RULE_grouping_element = 142, 
		RULE_ordinary_grouping_set = 143, RULE_ordinary_grouping_set_list = 144, 
		RULE_rollup_list = 145, RULE_cube_list = 146, RULE_empty_grouping_set = 147, 
		RULE_having_clause = 148, RULE_row_value_predicand_list = 149, RULE_query_expression = 150, 
		RULE_query_expression_body = 151, RULE_non_join_query_expression = 152, 
		RULE_query_term = 153, RULE_non_join_query_term = 154, RULE_query_primary = 155, 
		RULE_non_join_query_primary = 156, RULE_simple_table = 157, RULE_explicit_table = 158, 
		RULE_table_or_query_name = 159, RULE_table_name = 160, RULE_query_specification = 161, 
		RULE_select_list = 162, RULE_select_sublist = 163, RULE_derived_column = 164, 
		RULE_qualified_asterisk = 165, RULE_set_qualifier = 166, RULE_column_reference = 167, 
		RULE_as_clause = 168, RULE_column_reference_list = 169, RULE_scalar_subquery = 170, 
		RULE_row_subquery = 171, RULE_table_subquery = 172, RULE_subquery = 173, 
		RULE_predicate = 174, RULE_comparison_predicate = 175, RULE_comp_op = 176, 
		RULE_between_predicate = 177, RULE_between_predicate_part_2 = 178, RULE_in_predicate = 179, 
		RULE_in_predicate_value = 180, RULE_in_value_list = 181, RULE_pattern_matching_predicate = 182, 
		RULE_pattern_matcher = 183, RULE_negativable_matcher = 184, RULE_regex_matcher = 185, 
		RULE_null_predicate = 186, RULE_quantified_comparison_predicate = 187, 
		RULE_quantifier = 188, RULE_all = 189, RULE_some = 190, RULE_exists_predicate = 191, 
		RULE_unique_predicate = 192, RULE_primary_datetime_field = 193, RULE_non_second_primary_datetime_field = 194, 
		RULE_extended_datetime_field = 195, RULE_routine_invocation = 196, RULE_function_names_for_reserved_words = 197, 
		RULE_function_name = 198, RULE_sql_argument_list = 199, RULE_orderby_clause = 200, 
		RULE_sort_specifier_list = 201, RULE_sort_specifier = 202, RULE_order_specification = 203, 
		RULE_limit_clause = 204, RULE_null_ordering = 205, RULE_insert_statement = 206;
	public static final String[] ruleNames = {
		"sql", "statement", "data_statement", "data_change_statement", "schema_statement", 
		"index_statement", "create_extension_statement", "set_statement", "create_trigger_statement", 
		"grant_statement", "grant_to_rule", "argmode", "create_table_statement", 
		"table_elements", "field_element", "field_type", "param_clause", "param", 
		"method_specifier", "table_space_specifier", "table_space_name", "table_partitioning_clauses", 
		"range_partitions", "range_value_clause_list", "range_value_clause", "hash_partitions", 
		"individual_hash_partitions", "individual_hash_partition", "hash_partitions_by_quantity", 
		"list_partitions", "list_value_clause_list", "list_value_partition", "column_partitions", 
		"partition_name", "drop_table_statement", "identifier", "nonreserved_keywords", 
		"unsigned_literal", "general_literal", "datetime_literal", "time_literal", 
		"timestamp_literal", "date_literal", "boolean_literal", "data_type", "predefined_type", 
		"network_type", "character_string_type", "type_length", "national_character_string_type", 
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
		"simple_table", "explicit_table", "table_or_query_name", "table_name", 
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
			setState(418); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(414); statement();
				setState(416);
				_la = _input.LA(1);
				if (_la==SEMI_COLON) {
					{
					setState(415); match(SEMI_COLON);
					}
				}

				}
				}
				setState(420); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==CREATE || _la==GRANT || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & ((1L << (SELECT - 74)) | (1L << (TABLE - 74)) | (1L << (ADMIN - 74)) | (1L << (AVG - 74)) | (1L << (BETWEEN - 74)) | (1L << (BY - 74)) | (1L << (CENTURY - 74)) | (1L << (CHARACTER - 74)) | (1L << (COLLECT - 74)) | (1L << (COALESCE - 74)) | (1L << (COLUMN - 74)) | (1L << (COUNT - 74)) | (1L << (CUBE - 74)) | (1L << (DATA - 74)) | (1L << (DAY - 74)) | (1L << (DEC - 74)) | (1L << (DECADE - 74)) | (1L << (DOW - 74)) | (1L << (DOY - 74)) | (1L << (DROP - 74)) | (1L << (EPOCH - 74)) | (1L << (EVERY - 74)) | (1L << (EXISTS - 74)) | (1L << (EXTERNAL - 74)) | (1L << (EXTRACT - 74)) | (1L << (FILTER - 74)) | (1L << (FIRST - 74)) | (1L << (FORMAT - 74)) | (1L << (FUSION - 74)) | (1L << (GROUPING - 74)) | (1L << (HASH - 74)) | (1L << (INDEX - 74)) | (1L << (INSERT - 74)) | (1L << (INTERSECTION - 74)) | (1L << (ISODOW - 74)) | (1L << (ISOYEAR - 74)) | (1L << (LANGUAGE - 74)) | (1L << (LARGE - 74)) | (1L << (LAST - 74)) | (1L << (LESS - 74)) | (1L << (LIST - 74)) | (1L << (LOCATION - 74)) | (1L << (MAX - 74)))) != 0) || ((((_la - 138)) & ~0x3f) == 0 && ((1L << (_la - 138)) & ((1L << (MAXVALUE - 138)) | (1L << (MICROSECONDS - 138)) | (1L << (MILLENNIUM - 138)) | (1L << (MILLISECONDS - 138)) | (1L << (MIN - 138)) | (1L << (MINUTE - 138)) | (1L << (MONTH - 138)) | (1L << (NATIONAL - 138)) | (1L << (NULLIF - 138)) | (1L << (OBJECT - 138)) | (1L << (OPTION - 138)) | (1L << (OVERWRITE - 138)) | (1L << (PARTITION - 138)) | (1L << (PARTITIONS - 138)) | (1L << (PRECISION - 138)) | (1L << (PUBLIC - 138)) | (1L << (PURGE - 138)) | (1L << (QUARTER - 138)) | (1L << (RANGE - 138)) | (1L << (REGEXP - 138)) | (1L << (RLIKE - 138)) | (1L << (ROLLUP - 138)) | (1L << (SECOND - 138)) | (1L << (SERVER - 138)) | (1L << (SET - 138)) | (1L << (SIMILAR - 138)) | (1L << (STDDEV_POP - 138)) | (1L << (STDDEV_SAMP - 138)) | (1L << (SUBPARTITION - 138)) | (1L << (SUM - 138)) | (1L << (TABLESPACE - 138)) | (1L << (THAN - 138)) | (1L << (TIMEZONE - 138)) | (1L << (TIMEZONE_HOUR - 138)) | (1L << (TIMEZONE_MINUTE - 138)) | (1L << (TRIM - 138)) | (1L << (TO - 138)) | (1L << (UNKNOWN - 138)) | (1L << (VALUES - 138)) | (1L << (VAR_SAMP - 138)) | (1L << (VAR_POP - 138)) | (1L << (VARYING - 138)) | (1L << (WEEK - 138)) | (1L << (WRAPPER - 138)) | (1L << (YEAR - 138)) | (1L << (ZONE - 138)) | (1L << (BOOLEAN - 138)) | (1L << (BOOL - 138)) | (1L << (BIT - 138)) | (1L << (VARBIT - 138)) | (1L << (INT1 - 138)) | (1L << (INT2 - 138)) | (1L << (INT4 - 138)) | (1L << (INT8 - 138)) | (1L << (TINYINT - 138)) | (1L << (SMALLINT - 138)) | (1L << (INT - 138)) | (1L << (INTEGER - 138)) | (1L << (BIGINT - 138)) | (1L << (FLOAT4 - 138)) | (1L << (FLOAT8 - 138)) | (1L << (REAL - 138)))) != 0) || ((((_la - 202)) & ~0x3f) == 0 && ((1L << (_la - 202)) & ((1L << (FLOAT - 202)) | (1L << (DOUBLE - 202)) | (1L << (NUMERIC - 202)) | (1L << (DECIMAL - 202)) | (1L << (CHAR - 202)) | (1L << (VARCHAR - 202)) | (1L << (NCHAR - 202)) | (1L << (NVARCHAR - 202)) | (1L << (DATE - 202)) | (1L << (TIME - 202)) | (1L << (TIMETZ - 202)) | (1L << (TIMESTAMP - 202)) | (1L << (TIMESTAMPTZ - 202)) | (1L << (TEXT - 202)) | (1L << (VARBINARY - 202)) | (1L << (BLOB - 202)) | (1L << (BYTEA - 202)) | (1L << (INET4 - 202)) | (1L << (LEFT_PAREN - 202)) | (1L << (Identifier - 202)))) != 0) );
			setState(422); match(EOF);
			}
		}
		catch (RecognitionException re) {
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
			setState(432);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(424); data_statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(425); data_change_statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(426); schema_statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(427); index_statement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(428); create_extension_statement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(429); set_statement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(430); create_trigger_statement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(431); grant_statement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
			setState(434); query_expression();
			}
		}
		catch (RecognitionException re) {
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
			setState(436); insert_statement();
			}
		}
		catch (RecognitionException re) {
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
			setState(440);
			switch (_input.LA(1)) {
			case CREATE:
				enterOuterAlt(_localctx, 1);
				{
				setState(438); create_table_statement();
				}
				break;
			case DROP:
				enterOuterAlt(_localctx, 2);
				{
				setState(439); drop_table_statement();
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
		public Table_nameContext t;
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
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public Method_specifierContext method_specifier() {
			return getRuleContext(Method_specifierContext.class,0);
		}
		public TerminalNode UNIQUE() { return getToken(SQLParser.UNIQUE, 0); }
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
			setState(442); match(CREATE);
			setState(444);
			_la = _input.LA(1);
			if (_la==UNIQUE) {
				{
				setState(443); ((Index_statementContext)_localctx).u = match(UNIQUE);
				}
			}

			setState(446); match(INDEX);
			setState(447); ((Index_statementContext)_localctx).n = identifier();
			setState(448); match(ON);
			setState(449); ((Index_statementContext)_localctx).t = table_name();
			setState(451);
			_la = _input.LA(1);
			if (_la==USING) {
				{
				setState(450); ((Index_statementContext)_localctx).m = method_specifier();
				}
			}

			setState(453); match(LEFT_PAREN);
			setState(454); ((Index_statementContext)_localctx).s = sort_specifier_list();
			setState(455); match(RIGHT_PAREN);
			setState(457);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(456); ((Index_statementContext)_localctx).p = param_clause();
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
			setState(459); match(CREATE);
			setState(460); match(EXTENSION);
			setState(464);
			_la = _input.LA(1);
			if (_la==IF) {
				{
				setState(461); match(IF);
				setState(462); match(NOT);
				setState(463); match(EXISTS);
				}
			}

			setState(466); ((Create_extension_statementContext)_localctx).name = identifier();
			setState(468);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(467); match(WITH);
				}
			}

			setState(472);
			_la = _input.LA(1);
			if (_la==SCHEMA) {
				{
				setState(470); match(SCHEMA);
				setState(471); ((Create_extension_statementContext)_localctx).schema_name = identifier();
				}
			}

			setState(476);
			_la = _input.LA(1);
			if (_la==VERSION) {
				{
				setState(474); match(VERSION);
				setState(475); ((Create_extension_statementContext)_localctx).version = identifier();
				}
			}

			setState(480);
			_la = _input.LA(1);
			if (_la==FROM) {
				{
				setState(478); match(FROM);
				setState(479); ((Create_extension_statementContext)_localctx).old_version = identifier();
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
			setState(521);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(482); match(SET);
				setState(484);
				_la = _input.LA(1);
				if (_la==LOCAL || _la==SESSION) {
					{
					setState(483);
					_la = _input.LA(1);
					if ( !(_la==LOCAL || _la==SESSION) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(486); ((Set_statementContext)_localctx).config_param = identifier();
				setState(487);
				_la = _input.LA(1);
				if ( !(_la==TO || _la==EQUAL) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(499); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(494);
						switch (_input.LA(1)) {
						case ADMIN:
						case AVG:
						case BETWEEN:
						case BY:
						case CENTURY:
						case CHARACTER:
						case COLLECT:
						case COALESCE:
						case COLUMN:
						case COUNT:
						case CUBE:
						case DATA:
						case DAY:
						case DEC:
						case DECADE:
						case DOW:
						case DOY:
						case DROP:
						case EPOCH:
						case EVERY:
						case EXISTS:
						case EXTERNAL:
						case EXTRACT:
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
						case OVERWRITE:
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
						case SECOND:
						case SERVER:
						case SET:
						case SIMILAR:
						case STDDEV_POP:
						case STDDEV_SAMP:
						case SUBPARTITION:
						case SUM:
						case TABLESPACE:
						case THAN:
						case TIMEZONE:
						case TIMEZONE_HOUR:
						case TIMEZONE_MINUTE:
						case TRIM:
						case TO:
						case UNKNOWN:
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
						case Identifier:
							{
							setState(488); ((Set_statementContext)_localctx).value = identifier();
							}
							break;
						case QUOTE:
							{
							setState(489); match(QUOTE);
							setState(490); ((Set_statementContext)_localctx).value = identifier();
							setState(491); match(QUOTE);
							}
							break;
						case DEFAULT:
							{
							setState(493); match(DEFAULT);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(497);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(496); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(501); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(503); match(SET);
				setState(505);
				_la = _input.LA(1);
				if (_la==LOCAL || _la==SESSION) {
					{
					setState(504);
					_la = _input.LA(1);
					if ( !(_la==LOCAL || _la==SESSION) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(507); match(TIME);
				setState(508); match(ZONE);
				setState(517); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(512);
						switch (_input.LA(1)) {
						case ADMIN:
						case AVG:
						case BETWEEN:
						case BY:
						case CENTURY:
						case CHARACTER:
						case COLLECT:
						case COALESCE:
						case COLUMN:
						case COUNT:
						case CUBE:
						case DATA:
						case DAY:
						case DEC:
						case DECADE:
						case DOW:
						case DOY:
						case DROP:
						case EPOCH:
						case EVERY:
						case EXISTS:
						case EXTERNAL:
						case EXTRACT:
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
						case OVERWRITE:
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
						case SECOND:
						case SERVER:
						case SET:
						case SIMILAR:
						case STDDEV_POP:
						case STDDEV_SAMP:
						case SUBPARTITION:
						case SUM:
						case TABLESPACE:
						case THAN:
						case TIMEZONE:
						case TIMEZONE_HOUR:
						case TIMEZONE_MINUTE:
						case TRIM:
						case TO:
						case UNKNOWN:
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
						case Identifier:
							{
							setState(509); ((Set_statementContext)_localctx).timezone = identifier();
							}
							break;
						case LOCAL:
							{
							setState(510); match(LOCAL);
							}
							break;
						case DEFAULT:
							{
							setState(511); match(DEFAULT);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(515);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(514); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(519); 
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
		public Table_nameContext tabl_name;
		public Table_nameContext referenced_table_name;
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
		public List<Table_nameContext> table_name() {
			return getRuleContexts(Table_nameContext.class);
		}
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
		public Table_nameContext table_name(int i) {
			return getRuleContext(Table_nameContext.class,i);
		}
		public Boolean_value_expressionContext boolean_value_expression() {
			return getRuleContext(Boolean_value_expressionContext.class,0);
		}
		public TerminalNode NOT() { return getToken(SQLParser.NOT, 0); }
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode AFTER() { return getToken(SQLParser.AFTER, 0); }
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
			setState(523); match(CREATE);
			setState(525);
			_la = _input.LA(1);
			if (_la==CONSTRAINT) {
				{
				setState(524); match(CONSTRAINT);
				}
			}

			setState(527); match(TRIGGER);
			setState(528); ((Create_trigger_statementContext)_localctx).name = identifier();
			setState(533);
			switch (_input.LA(1)) {
			case BEFORE:
				{
				setState(529); match(BEFORE);
				}
				break;
			case INSTEAD:
				{
				{
				setState(530); match(INSTEAD);
				setState(531); match(OF);
				}
				}
				break;
			case AFTER:
				{
				setState(532); match(AFTER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(550);
			switch (_input.LA(1)) {
			case INSERT:
				{
				setState(535); match(INSERT);
				}
				break;
			case DELETE:
				{
				setState(536); match(DELETE);
				}
				break;
			case TRUNCATE:
				{
				setState(537); match(TRUNCATE);
				}
				break;
			case UPDATE:
				{
				{
				setState(538); match(UPDATE);
				setState(548);
				_la = _input.LA(1);
				if (_la==OF) {
					{
					setState(539); match(OF);
					setState(544); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(540); ((Create_trigger_statementContext)_localctx).columnName = identifier();
						setState(542);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(541); match(COMMA);
							}
						}

						}
						}
						setState(546); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 96)) & ~0x3f) == 0 && ((1L << (_la - 96)) & ((1L << (ADMIN - 96)) | (1L << (AVG - 96)) | (1L << (BETWEEN - 96)) | (1L << (BY - 96)) | (1L << (CENTURY - 96)) | (1L << (CHARACTER - 96)) | (1L << (COLLECT - 96)) | (1L << (COALESCE - 96)) | (1L << (COLUMN - 96)) | (1L << (COUNT - 96)) | (1L << (CUBE - 96)) | (1L << (DATA - 96)) | (1L << (DAY - 96)) | (1L << (DEC - 96)) | (1L << (DECADE - 96)) | (1L << (DOW - 96)) | (1L << (DOY - 96)) | (1L << (DROP - 96)) | (1L << (EPOCH - 96)) | (1L << (EVERY - 96)) | (1L << (EXISTS - 96)) | (1L << (EXTERNAL - 96)) | (1L << (EXTRACT - 96)) | (1L << (FILTER - 96)) | (1L << (FIRST - 96)) | (1L << (FORMAT - 96)) | (1L << (FUSION - 96)) | (1L << (GROUPING - 96)) | (1L << (HASH - 96)) | (1L << (INDEX - 96)) | (1L << (INSERT - 96)) | (1L << (INTERSECTION - 96)) | (1L << (ISODOW - 96)) | (1L << (ISOYEAR - 96)) | (1L << (LANGUAGE - 96)) | (1L << (LARGE - 96)) | (1L << (LAST - 96)) | (1L << (LESS - 96)) | (1L << (LIST - 96)) | (1L << (LOCATION - 96)) | (1L << (MAX - 96)) | (1L << (MAXVALUE - 96)) | (1L << (MICROSECONDS - 96)) | (1L << (MILLENNIUM - 96)) | (1L << (MILLISECONDS - 96)) | (1L << (MIN - 96)) | (1L << (MINUTE - 96)) | (1L << (MONTH - 96)) | (1L << (NATIONAL - 96)) | (1L << (NULLIF - 96)) | (1L << (OBJECT - 96)) | (1L << (OPTION - 96)) | (1L << (OVERWRITE - 96)) | (1L << (PARTITION - 96)) | (1L << (PARTITIONS - 96)) | (1L << (PRECISION - 96)) | (1L << (PUBLIC - 96)) | (1L << (PURGE - 96)) | (1L << (QUARTER - 96)) | (1L << (RANGE - 96)) | (1L << (REGEXP - 96)) | (1L << (RLIKE - 96)) | (1L << (ROLLUP - 96)))) != 0) || ((((_la - 160)) & ~0x3f) == 0 && ((1L << (_la - 160)) & ((1L << (SECOND - 160)) | (1L << (SERVER - 160)) | (1L << (SET - 160)) | (1L << (SIMILAR - 160)) | (1L << (STDDEV_POP - 160)) | (1L << (STDDEV_SAMP - 160)) | (1L << (SUBPARTITION - 160)) | (1L << (SUM - 160)) | (1L << (TABLESPACE - 160)) | (1L << (THAN - 160)) | (1L << (TIMEZONE - 160)) | (1L << (TIMEZONE_HOUR - 160)) | (1L << (TIMEZONE_MINUTE - 160)) | (1L << (TRIM - 160)) | (1L << (TO - 160)) | (1L << (UNKNOWN - 160)) | (1L << (VALUES - 160)) | (1L << (VAR_SAMP - 160)) | (1L << (VAR_POP - 160)) | (1L << (VARYING - 160)) | (1L << (WEEK - 160)) | (1L << (WRAPPER - 160)) | (1L << (YEAR - 160)) | (1L << (ZONE - 160)) | (1L << (BOOLEAN - 160)) | (1L << (BOOL - 160)) | (1L << (BIT - 160)) | (1L << (VARBIT - 160)) | (1L << (INT1 - 160)) | (1L << (INT2 - 160)) | (1L << (INT4 - 160)) | (1L << (INT8 - 160)) | (1L << (TINYINT - 160)) | (1L << (SMALLINT - 160)) | (1L << (INT - 160)) | (1L << (INTEGER - 160)) | (1L << (BIGINT - 160)) | (1L << (FLOAT4 - 160)) | (1L << (FLOAT8 - 160)) | (1L << (REAL - 160)) | (1L << (FLOAT - 160)) | (1L << (DOUBLE - 160)) | (1L << (NUMERIC - 160)) | (1L << (DECIMAL - 160)) | (1L << (CHAR - 160)) | (1L << (VARCHAR - 160)) | (1L << (NCHAR - 160)) | (1L << (NVARCHAR - 160)) | (1L << (DATE - 160)) | (1L << (TIME - 160)) | (1L << (TIMETZ - 160)) | (1L << (TIMESTAMP - 160)) | (1L << (TIMESTAMPTZ - 160)) | (1L << (TEXT - 160)) | (1L << (VARBINARY - 160)) | (1L << (BLOB - 160)) | (1L << (BYTEA - 160)) | (1L << (INET4 - 160)))) != 0) || _la==Identifier );
					}
				}

				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(552); match(ON);
			setState(553); ((Create_trigger_statementContext)_localctx).tabl_name = table_name();
			setState(556);
			_la = _input.LA(1);
			if (_la==FROM) {
				{
				setState(554); match(FROM);
				setState(555); ((Create_trigger_statementContext)_localctx).referenced_table_name = table_name();
				}
			}

			setState(567);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				{
				setState(558); match(NOT);
				setState(559); match(DEFERRABLE);
				}
				break;
			case 2:
				{
				setState(561);
				_la = _input.LA(1);
				if (_la==DEFERRABLE) {
					{
					setState(560); match(DEFERRABLE);
					}
				}

				{
				setState(563); match(INITIALLY);
				setState(564); match(IMMEDIATE);
				}
				}
				break;
			case 3:
				{
				{
				setState(565); match(INITIALLY);
				setState(566); match(DEFERRED);
				}
				}
				break;
			}
			setState(575);
			switch (_input.LA(1)) {
			case FOR:
				{
				setState(569); match(FOR);
				setState(571);
				_la = _input.LA(1);
				if (_la==EACH) {
					{
					setState(570); match(EACH);
					}
				}

				setState(573); match(ROW);
				}
				break;
			case STATEMENT:
				{
				setState(574); match(STATEMENT);
				}
				break;
			case EXECUTE:
			case WHEN:
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(579);
			_la = _input.LA(1);
			if (_la==WHEN) {
				{
				setState(577); match(WHEN);
				{
				setState(578); boolean_value_expression();
				}
				}
			}

			setState(581); match(EXECUTE);
			setState(582); match(PROCEDURE);
			setState(583); ((Create_trigger_statementContext)_localctx).func_name = identifier();
			setState(584); match(LEFT_PAREN);
			setState(589);
			_la = _input.LA(1);
			if (((((_la - 96)) & ~0x3f) == 0 && ((1L << (_la - 96)) & ((1L << (ADMIN - 96)) | (1L << (AVG - 96)) | (1L << (BETWEEN - 96)) | (1L << (BY - 96)) | (1L << (CENTURY - 96)) | (1L << (CHARACTER - 96)) | (1L << (COLLECT - 96)) | (1L << (COALESCE - 96)) | (1L << (COLUMN - 96)) | (1L << (COUNT - 96)) | (1L << (CUBE - 96)) | (1L << (DATA - 96)) | (1L << (DAY - 96)) | (1L << (DEC - 96)) | (1L << (DECADE - 96)) | (1L << (DOW - 96)) | (1L << (DOY - 96)) | (1L << (DROP - 96)) | (1L << (EPOCH - 96)) | (1L << (EVERY - 96)) | (1L << (EXISTS - 96)) | (1L << (EXTERNAL - 96)) | (1L << (EXTRACT - 96)) | (1L << (FILTER - 96)) | (1L << (FIRST - 96)) | (1L << (FORMAT - 96)) | (1L << (FUSION - 96)) | (1L << (GROUPING - 96)) | (1L << (HASH - 96)) | (1L << (INDEX - 96)) | (1L << (INSERT - 96)) | (1L << (INTERSECTION - 96)) | (1L << (ISODOW - 96)) | (1L << (ISOYEAR - 96)) | (1L << (LANGUAGE - 96)) | (1L << (LARGE - 96)) | (1L << (LAST - 96)) | (1L << (LESS - 96)) | (1L << (LIST - 96)) | (1L << (LOCATION - 96)) | (1L << (MAX - 96)) | (1L << (MAXVALUE - 96)) | (1L << (MICROSECONDS - 96)) | (1L << (MILLENNIUM - 96)) | (1L << (MILLISECONDS - 96)) | (1L << (MIN - 96)) | (1L << (MINUTE - 96)) | (1L << (MONTH - 96)) | (1L << (NATIONAL - 96)) | (1L << (NULLIF - 96)) | (1L << (OBJECT - 96)) | (1L << (OPTION - 96)) | (1L << (OVERWRITE - 96)) | (1L << (PARTITION - 96)) | (1L << (PARTITIONS - 96)) | (1L << (PRECISION - 96)) | (1L << (PUBLIC - 96)) | (1L << (PURGE - 96)) | (1L << (QUARTER - 96)) | (1L << (RANGE - 96)) | (1L << (REGEXP - 96)) | (1L << (RLIKE - 96)) | (1L << (ROLLUP - 96)))) != 0) || ((((_la - 160)) & ~0x3f) == 0 && ((1L << (_la - 160)) & ((1L << (SECOND - 160)) | (1L << (SERVER - 160)) | (1L << (SET - 160)) | (1L << (SIMILAR - 160)) | (1L << (STDDEV_POP - 160)) | (1L << (STDDEV_SAMP - 160)) | (1L << (SUBPARTITION - 160)) | (1L << (SUM - 160)) | (1L << (TABLESPACE - 160)) | (1L << (THAN - 160)) | (1L << (TIMEZONE - 160)) | (1L << (TIMEZONE_HOUR - 160)) | (1L << (TIMEZONE_MINUTE - 160)) | (1L << (TRIM - 160)) | (1L << (TO - 160)) | (1L << (UNKNOWN - 160)) | (1L << (VALUES - 160)) | (1L << (VAR_SAMP - 160)) | (1L << (VAR_POP - 160)) | (1L << (VARYING - 160)) | (1L << (WEEK - 160)) | (1L << (WRAPPER - 160)) | (1L << (YEAR - 160)) | (1L << (ZONE - 160)) | (1L << (BOOLEAN - 160)) | (1L << (BOOL - 160)) | (1L << (BIT - 160)) | (1L << (VARBIT - 160)) | (1L << (INT1 - 160)) | (1L << (INT2 - 160)) | (1L << (INT4 - 160)) | (1L << (INT8 - 160)) | (1L << (TINYINT - 160)) | (1L << (SMALLINT - 160)) | (1L << (INT - 160)) | (1L << (INTEGER - 160)) | (1L << (BIGINT - 160)) | (1L << (FLOAT4 - 160)) | (1L << (FLOAT8 - 160)) | (1L << (REAL - 160)) | (1L << (FLOAT - 160)) | (1L << (DOUBLE - 160)) | (1L << (NUMERIC - 160)) | (1L << (DECIMAL - 160)) | (1L << (CHAR - 160)) | (1L << (VARCHAR - 160)) | (1L << (NCHAR - 160)) | (1L << (NVARCHAR - 160)) | (1L << (DATE - 160)) | (1L << (TIME - 160)) | (1L << (TIMETZ - 160)) | (1L << (TIMESTAMP - 160)) | (1L << (TIMESTAMPTZ - 160)) | (1L << (TEXT - 160)) | (1L << (VARBINARY - 160)) | (1L << (BLOB - 160)) | (1L << (BYTEA - 160)) | (1L << (INET4 - 160)))) != 0) || _la==Identifier) {
				{
				setState(585); ((Create_trigger_statementContext)_localctx).arguments = identifier();
				setState(587);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(586); match(COMMA);
					}
				}

				}
			}

			setState(591); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		public Table_nameContext tabl_name;
		public IdentifierContext schem_name;
		public IdentifierContext column;
		public IdentifierContext sequence_name;
		public IdentifierContext schema_name;
		public IdentifierContext database_name;
		public IdentifierContext fdw_name;
		public IdentifierContext server_name;
		public IdentifierContext func_name;
		public ArgmodeContext arg_mode;
		public IdentifierContext argname;
		public Data_typeContext argtype;
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
		public TerminalNode FUNCTIONS() { return getToken(SQLParser.FUNCTIONS, 0); }
		public List<TerminalNode> TRUNCATE() { return getTokens(SQLParser.TRUNCATE); }
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
		public List<ArgmodeContext> argmode() {
			return getRuleContexts(ArgmodeContext.class);
		}
		public TerminalNode PRIVILEGES() { return getToken(SQLParser.PRIVILEGES, 0); }
		public TerminalNode TO() { return getToken(SQLParser.TO, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public List<TerminalNode> ALL() { return getTokens(SQLParser.ALL); }
		public TerminalNode WITH() { return getToken(SQLParser.WITH, 0); }
		public List<TerminalNode> USAGE() { return getTokens(SQLParser.USAGE); }
		public ArgmodeContext argmode(int i) {
			return getRuleContext(ArgmodeContext.class,i);
		}
		public List<TerminalNode> REFERENCES() { return getTokens(SQLParser.REFERENCES); }
		public List<TerminalNode> TRIGGER() { return getTokens(SQLParser.TRIGGER); }
		public TerminalNode ALL(int i) {
			return getToken(SQLParser.ALL, i);
		}
		public TerminalNode DATA() { return getToken(SQLParser.DATA, 0); }
		public Table_nameContext table_name(int i) {
			return getRuleContext(Table_nameContext.class,i);
		}
		public List<TerminalNode> CONNECT() { return getTokens(SQLParser.CONNECT); }
		public Data_typeContext data_type(int i) {
			return getRuleContext(Data_typeContext.class,i);
		}
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
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public List<TerminalNode> UPDATE() { return getTokens(SQLParser.UPDATE); }
		public TerminalNode OPTION() { return getToken(SQLParser.OPTION, 0); }
		public List<Data_typeContext> data_type() {
			return getRuleContexts(Data_typeContext.class);
		}
		public List<Table_nameContext> table_name() {
			return getRuleContexts(Table_nameContext.class);
		}
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
		public TerminalNode FUNCTION() { return getToken(SQLParser.FUNCTION, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode TEMPORARY(int i) {
			return getToken(SQLParser.TEMPORARY, i);
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
		enterRule(_localctx, 18, RULE_grant_statement);
		int _la;
		try {
			int _alt;
			setState(948);
			switch ( getInterpreter().adaptivePredict(_input,111,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(593); match(GRANT);
				setState(603);
				switch (_input.LA(1)) {
				case DELETE:
				case REFERENCES:
				case SELECT:
				case TRIGGER:
				case TRUNCATE:
				case UPDATE:
				case INSERT:
					{
					setState(595); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(594);
						_la = _input.LA(1);
						if ( !(_la==DELETE || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (REFERENCES - 68)) | (1L << (SELECT - 68)) | (1L << (TRIGGER - 68)) | (1L << (TRUNCATE - 68)) | (1L << (UPDATE - 68)) | (1L << (INSERT - 68)))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
						}
						setState(597); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==DELETE || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (REFERENCES - 68)) | (1L << (SELECT - 68)) | (1L << (TRIGGER - 68)) | (1L << (TRUNCATE - 68)) | (1L << (UPDATE - 68)) | (1L << (INSERT - 68)))) != 0) );
					}
					break;
				case ALL:
					{
					setState(599); match(ALL);
					setState(601);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(600); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(605); match(ON);
				setState(629);
				switch (_input.LA(1)) {
				case TABLE:
				case ADMIN:
				case AVG:
				case BETWEEN:
				case BY:
				case CENTURY:
				case CHARACTER:
				case COLLECT:
				case COALESCE:
				case COLUMN:
				case COUNT:
				case CUBE:
				case DATA:
				case DAY:
				case DEC:
				case DECADE:
				case DOW:
				case DOY:
				case DROP:
				case EPOCH:
				case EVERY:
				case EXISTS:
				case EXTERNAL:
				case EXTRACT:
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
				case OVERWRITE:
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
				case SECOND:
				case SERVER:
				case SET:
				case SIMILAR:
				case STDDEV_POP:
				case STDDEV_SAMP:
				case SUBPARTITION:
				case SUM:
				case TABLESPACE:
				case THAN:
				case TIMEZONE:
				case TIMEZONE_HOUR:
				case TIMEZONE_MINUTE:
				case TRIM:
				case TO:
				case UNKNOWN:
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
				case Identifier:
					{
					{
					setState(607);
					_la = _input.LA(1);
					if (_la==TABLE) {
						{
						setState(606); match(TABLE);
						}
					}

					setState(613); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(609); ((Grant_statementContext)_localctx).tabl_name = table_name();
							setState(611);
							_la = _input.LA(1);
							if (_la==COMMA) {
								{
								setState(610); match(COMMA);
								}
							}

							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(615); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					}
					}
					break;
				case ALL:
					{
					{
					setState(617); match(ALL);
					setState(618); match(TABLES);
					setState(619); match(IN);
					setState(620); match(SCHEMA);
					setState(625); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(621); ((Grant_statementContext)_localctx).schem_name = identifier();
							setState(623);
							_la = _input.LA(1);
							if (_la==COMMA) {
								{
								setState(622); match(COMMA);
								}
							}

							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(627); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(631); grant_to_rule();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(633); match(GRANT);
				setState(659);
				switch (_input.LA(1)) {
				case REFERENCES:
				case SELECT:
				case UPDATE:
				case INSERT:
					{
					setState(643); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(634);
						_la = _input.LA(1);
						if ( !(((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (REFERENCES - 68)) | (1L << (SELECT - 68)) | (1L << (UPDATE - 68)) | (1L << (INSERT - 68)))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(639); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(635); ((Grant_statementContext)_localctx).column = identifier();
								setState(637);
								_la = _input.LA(1);
								if (_la==COMMA) {
									{
									setState(636); match(COMMA);
									}
								}

								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(641); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						}
						}
						setState(645); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (REFERENCES - 68)) | (1L << (SELECT - 68)) | (1L << (UPDATE - 68)) | (1L << (INSERT - 68)))) != 0) );
					}
					break;
				case ALL:
					{
					setState(647); match(ALL);
					setState(649);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(648); match(PRIVILEGES);
						}
					}

					setState(655); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(651); ((Grant_statementContext)_localctx).column = identifier();
						setState(653);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(652); match(COMMA);
							}
						}

						}
						}
						setState(657); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 96)) & ~0x3f) == 0 && ((1L << (_la - 96)) & ((1L << (ADMIN - 96)) | (1L << (AVG - 96)) | (1L << (BETWEEN - 96)) | (1L << (BY - 96)) | (1L << (CENTURY - 96)) | (1L << (CHARACTER - 96)) | (1L << (COLLECT - 96)) | (1L << (COALESCE - 96)) | (1L << (COLUMN - 96)) | (1L << (COUNT - 96)) | (1L << (CUBE - 96)) | (1L << (DATA - 96)) | (1L << (DAY - 96)) | (1L << (DEC - 96)) | (1L << (DECADE - 96)) | (1L << (DOW - 96)) | (1L << (DOY - 96)) | (1L << (DROP - 96)) | (1L << (EPOCH - 96)) | (1L << (EVERY - 96)) | (1L << (EXISTS - 96)) | (1L << (EXTERNAL - 96)) | (1L << (EXTRACT - 96)) | (1L << (FILTER - 96)) | (1L << (FIRST - 96)) | (1L << (FORMAT - 96)) | (1L << (FUSION - 96)) | (1L << (GROUPING - 96)) | (1L << (HASH - 96)) | (1L << (INDEX - 96)) | (1L << (INSERT - 96)) | (1L << (INTERSECTION - 96)) | (1L << (ISODOW - 96)) | (1L << (ISOYEAR - 96)) | (1L << (LANGUAGE - 96)) | (1L << (LARGE - 96)) | (1L << (LAST - 96)) | (1L << (LESS - 96)) | (1L << (LIST - 96)) | (1L << (LOCATION - 96)) | (1L << (MAX - 96)) | (1L << (MAXVALUE - 96)) | (1L << (MICROSECONDS - 96)) | (1L << (MILLENNIUM - 96)) | (1L << (MILLISECONDS - 96)) | (1L << (MIN - 96)) | (1L << (MINUTE - 96)) | (1L << (MONTH - 96)) | (1L << (NATIONAL - 96)) | (1L << (NULLIF - 96)) | (1L << (OBJECT - 96)) | (1L << (OPTION - 96)) | (1L << (OVERWRITE - 96)) | (1L << (PARTITION - 96)) | (1L << (PARTITIONS - 96)) | (1L << (PRECISION - 96)) | (1L << (PUBLIC - 96)) | (1L << (PURGE - 96)) | (1L << (QUARTER - 96)) | (1L << (RANGE - 96)) | (1L << (REGEXP - 96)) | (1L << (RLIKE - 96)) | (1L << (ROLLUP - 96)))) != 0) || ((((_la - 160)) & ~0x3f) == 0 && ((1L << (_la - 160)) & ((1L << (SECOND - 160)) | (1L << (SERVER - 160)) | (1L << (SET - 160)) | (1L << (SIMILAR - 160)) | (1L << (STDDEV_POP - 160)) | (1L << (STDDEV_SAMP - 160)) | (1L << (SUBPARTITION - 160)) | (1L << (SUM - 160)) | (1L << (TABLESPACE - 160)) | (1L << (THAN - 160)) | (1L << (TIMEZONE - 160)) | (1L << (TIMEZONE_HOUR - 160)) | (1L << (TIMEZONE_MINUTE - 160)) | (1L << (TRIM - 160)) | (1L << (TO - 160)) | (1L << (UNKNOWN - 160)) | (1L << (VALUES - 160)) | (1L << (VAR_SAMP - 160)) | (1L << (VAR_POP - 160)) | (1L << (VARYING - 160)) | (1L << (WEEK - 160)) | (1L << (WRAPPER - 160)) | (1L << (YEAR - 160)) | (1L << (ZONE - 160)) | (1L << (BOOLEAN - 160)) | (1L << (BOOL - 160)) | (1L << (BIT - 160)) | (1L << (VARBIT - 160)) | (1L << (INT1 - 160)) | (1L << (INT2 - 160)) | (1L << (INT4 - 160)) | (1L << (INT8 - 160)) | (1L << (TINYINT - 160)) | (1L << (SMALLINT - 160)) | (1L << (INT - 160)) | (1L << (INTEGER - 160)) | (1L << (BIGINT - 160)) | (1L << (FLOAT4 - 160)) | (1L << (FLOAT8 - 160)) | (1L << (REAL - 160)) | (1L << (FLOAT - 160)) | (1L << (DOUBLE - 160)) | (1L << (NUMERIC - 160)) | (1L << (DECIMAL - 160)) | (1L << (CHAR - 160)) | (1L << (VARCHAR - 160)) | (1L << (NCHAR - 160)) | (1L << (NVARCHAR - 160)) | (1L << (DATE - 160)) | (1L << (TIME - 160)) | (1L << (TIMETZ - 160)) | (1L << (TIMESTAMP - 160)) | (1L << (TIMESTAMPTZ - 160)) | (1L << (TEXT - 160)) | (1L << (VARBINARY - 160)) | (1L << (BLOB - 160)) | (1L << (BYTEA - 160)) | (1L << (INET4 - 160)))) != 0) || _la==Identifier );
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(661); match(ON);
				setState(669); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(663);
						_la = _input.LA(1);
						if (_la==TABLE) {
							{
							setState(662); match(TABLE);
							}
						}

						setState(665); ((Grant_statementContext)_localctx).tabl_name = table_name();
						setState(667);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(666); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(671); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,53,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(673); grant_to_rule();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(675); match(GRANT);
				setState(688);
				switch (_input.LA(1)) {
				case SELECT:
				case UPDATE:
				case USAGE:
					{
					setState(680); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(676);
						_la = _input.LA(1);
						if ( !(((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & ((1L << (SELECT - 74)) | (1L << (UPDATE - 74)) | (1L << (USAGE - 74)))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(678);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(677); match(COMMA);
							}
						}

						}
						}
						setState(682); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & ((1L << (SELECT - 74)) | (1L << (UPDATE - 74)) | (1L << (USAGE - 74)))) != 0) );
					}
					break;
				case ALL:
					{
					setState(684); match(ALL);
					setState(686);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(685); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(690); match(ON);
				setState(712);
				switch (_input.LA(1)) {
				case SEQUENCE:
					{
					setState(696); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(691); match(SEQUENCE);
						setState(692); ((Grant_statementContext)_localctx).sequence_name = identifier();
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
					} while ( _la==SEQUENCE );
					}
					break;
				case ALL:
					{
					setState(700); match(ALL);
					setState(701); match(SEQUENCES);
					setState(702); match(IN);
					setState(703); match(SCHEMA);
					setState(708); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(704); ((Grant_statementContext)_localctx).schema_name = identifier();
							setState(706);
							_la = _input.LA(1);
							if (_la==COMMA) {
								{
								setState(705); match(COMMA);
								}
							}

							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(710); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,61,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(714); grant_to_rule();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(716); match(GRANT);
				setState(729);
				switch (_input.LA(1)) {
				case CONNECT:
				case CREATE:
				case TEMP:
				case TEMPORARY:
					{
					setState(721); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(717);
						_la = _input.LA(1);
						if ( !(_la==CONNECT || _la==CREATE || _la==TEMP || _la==TEMPORARY) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(719);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(718); match(COMMA);
							}
						}

						}
						}
						setState(723); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==CONNECT || _la==CREATE || _la==TEMP || _la==TEMPORARY );
					}
					break;
				case ALL:
					{
					setState(725); match(ALL);
					setState(727);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(726); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(731); match(ON);
				setState(732); match(DATABASE);
				setState(737); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(733); ((Grant_statementContext)_localctx).database_name = identifier();
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
					_alt = getInterpreter().adaptivePredict(_input,68,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(741); grant_to_rule();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(743); match(GRANT);
				setState(749);
				switch (_input.LA(1)) {
				case USAGE:
					{
					setState(744); match(USAGE);
					}
					break;
				case ALL:
					{
					setState(745); match(ALL);
					setState(747);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(746); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(751); match(ON);
				setState(752); match(FOREIGN);
				setState(753); match(DATA);
				setState(754); match(WRAPPER);
				setState(759); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(755); ((Grant_statementContext)_localctx).fdw_name = identifier();
						setState(757);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(756); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(761); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,72,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(763); grant_to_rule();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(765); match(GRANT);
				setState(771);
				switch (_input.LA(1)) {
				case USAGE:
					{
					setState(766); match(USAGE);
					}
					break;
				case ALL:
					{
					setState(767); match(ALL);
					setState(769);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(768); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(773); match(ON);
				setState(774); match(FOREIGN);
				setState(775); match(SERVER);
				setState(780); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(776); ((Grant_statementContext)_localctx).server_name = identifier();
						setState(778);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(777); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(782); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,76,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(784); grant_to_rule();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(786); match(GRANT);
				setState(792);
				switch (_input.LA(1)) {
				case EXECUTE:
					{
					setState(787); match(EXECUTE);
					}
					break;
				case ALL:
					{
					setState(788); match(ALL);
					setState(790);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(789); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(794); match(ON);
				setState(827);
				switch (_input.LA(1)) {
				case FUNCTION:
					{
					setState(795); match(FUNCTION);
					setState(796); ((Grant_statementContext)_localctx).func_name = identifier();
					setState(797); match(LEFT_PAREN);
					setState(810);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IN) | (1L << INOUT) | (1L << OUT))) != 0) || ((((_la - 92)) & ~0x3f) == 0 && ((1L << (_la - 92)) & ((1L << (VARIADIC - 92)) | (1L << (ADMIN - 92)) | (1L << (AVG - 92)) | (1L << (BETWEEN - 92)) | (1L << (BY - 92)) | (1L << (CENTURY - 92)) | (1L << (CHARACTER - 92)) | (1L << (COLLECT - 92)) | (1L << (COALESCE - 92)) | (1L << (COLUMN - 92)) | (1L << (COUNT - 92)) | (1L << (CUBE - 92)) | (1L << (DATA - 92)) | (1L << (DAY - 92)) | (1L << (DEC - 92)) | (1L << (DECADE - 92)) | (1L << (DOW - 92)) | (1L << (DOY - 92)) | (1L << (DROP - 92)) | (1L << (EPOCH - 92)) | (1L << (EVERY - 92)) | (1L << (EXISTS - 92)) | (1L << (EXTERNAL - 92)) | (1L << (EXTRACT - 92)) | (1L << (FILTER - 92)) | (1L << (FIRST - 92)) | (1L << (FORMAT - 92)) | (1L << (FUSION - 92)) | (1L << (GROUPING - 92)) | (1L << (HASH - 92)) | (1L << (INDEX - 92)) | (1L << (INSERT - 92)) | (1L << (INTERSECTION - 92)) | (1L << (ISODOW - 92)) | (1L << (ISOYEAR - 92)) | (1L << (LANGUAGE - 92)) | (1L << (LARGE - 92)) | (1L << (LAST - 92)) | (1L << (LESS - 92)) | (1L << (LIST - 92)) | (1L << (LOCATION - 92)) | (1L << (MAX - 92)) | (1L << (MAXVALUE - 92)) | (1L << (MICROSECONDS - 92)) | (1L << (MILLENNIUM - 92)) | (1L << (MILLISECONDS - 92)) | (1L << (MIN - 92)) | (1L << (MINUTE - 92)) | (1L << (MONTH - 92)) | (1L << (NATIONAL - 92)) | (1L << (NULLIF - 92)) | (1L << (OBJECT - 92)) | (1L << (OPTION - 92)) | (1L << (OVERWRITE - 92)) | (1L << (PARTITION - 92)) | (1L << (PARTITIONS - 92)) | (1L << (PRECISION - 92)) | (1L << (PUBLIC - 92)) | (1L << (PURGE - 92)) | (1L << (QUARTER - 92)))) != 0) || ((((_la - 156)) & ~0x3f) == 0 && ((1L << (_la - 156)) & ((1L << (RANGE - 156)) | (1L << (REGEXP - 156)) | (1L << (RLIKE - 156)) | (1L << (ROLLUP - 156)) | (1L << (SECOND - 156)) | (1L << (SERVER - 156)) | (1L << (SET - 156)) | (1L << (SIMILAR - 156)) | (1L << (STDDEV_POP - 156)) | (1L << (STDDEV_SAMP - 156)) | (1L << (SUBPARTITION - 156)) | (1L << (SUM - 156)) | (1L << (TABLESPACE - 156)) | (1L << (THAN - 156)) | (1L << (TIMEZONE - 156)) | (1L << (TIMEZONE_HOUR - 156)) | (1L << (TIMEZONE_MINUTE - 156)) | (1L << (TRIM - 156)) | (1L << (TO - 156)) | (1L << (UNKNOWN - 156)) | (1L << (VALUES - 156)) | (1L << (VAR_SAMP - 156)) | (1L << (VAR_POP - 156)) | (1L << (VARYING - 156)) | (1L << (WEEK - 156)) | (1L << (WRAPPER - 156)) | (1L << (YEAR - 156)) | (1L << (ZONE - 156)) | (1L << (BOOLEAN - 156)) | (1L << (BOOL - 156)) | (1L << (BIT - 156)) | (1L << (VARBIT - 156)) | (1L << (INT1 - 156)) | (1L << (INT2 - 156)) | (1L << (INT4 - 156)) | (1L << (INT8 - 156)) | (1L << (TINYINT - 156)) | (1L << (SMALLINT - 156)) | (1L << (INT - 156)) | (1L << (INTEGER - 156)) | (1L << (BIGINT - 156)) | (1L << (FLOAT4 - 156)) | (1L << (FLOAT8 - 156)) | (1L << (REAL - 156)) | (1L << (FLOAT - 156)) | (1L << (DOUBLE - 156)) | (1L << (NUMERIC - 156)) | (1L << (DECIMAL - 156)) | (1L << (CHAR - 156)) | (1L << (VARCHAR - 156)) | (1L << (NCHAR - 156)) | (1L << (NVARCHAR - 156)) | (1L << (DATE - 156)) | (1L << (TIME - 156)) | (1L << (TIMETZ - 156)) | (1L << (TIMESTAMP - 156)) | (1L << (TIMESTAMPTZ - 156)) | (1L << (TEXT - 156)) | (1L << (BINARY - 156)) | (1L << (VARBINARY - 156)) | (1L << (BLOB - 156)) | (1L << (BYTEA - 156)))) != 0) || _la==INET4 || _la==Identifier) {
						{
						{
						setState(799);
						_la = _input.LA(1);
						if (((((_la - 42)) & ~0x3f) == 0 && ((1L << (_la - 42)) & ((1L << (IN - 42)) | (1L << (INOUT - 42)) | (1L << (OUT - 42)) | (1L << (VARIADIC - 42)))) != 0)) {
							{
							setState(798); ((Grant_statementContext)_localctx).arg_mode = argmode();
							}
						}

						setState(802);
						switch ( getInterpreter().adaptivePredict(_input,80,_ctx) ) {
						case 1:
							{
							setState(801); ((Grant_statementContext)_localctx).argname = identifier();
							}
							break;
						}
						setState(804); ((Grant_statementContext)_localctx).argtype = data_type();
						setState(806);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(805); match(COMMA);
							}
						}

						}
						}
						setState(812);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(813); match(RIGHT_PAREN);
					}
					break;
				case ALL:
					{
					setState(815); match(ALL);
					setState(816); match(FUNCTIONS);
					setState(817); match(IN);
					setState(818); match(SCHEMA);
					setState(823); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(819); ((Grant_statementContext)_localctx).schema_name = identifier();
							setState(821);
							_la = _input.LA(1);
							if (_la==COMMA) {
								{
								setState(820); match(COMMA);
								}
							}

							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(825); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,84,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(829); grant_to_rule();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(831); match(GRANT);
				setState(837);
				switch (_input.LA(1)) {
				case USAGE:
					{
					setState(832); match(USAGE);
					}
					break;
				case ALL:
					{
					setState(833); match(ALL);
					setState(835);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(834); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(839); match(ON);
				setState(840); match(LANGUAGE);
				setState(845); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(841); ((Grant_statementContext)_localctx).lang_name = identifier();
						setState(843);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(842); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(847); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,89,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(849); grant_to_rule();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(851); match(GRANT);
				setState(864);
				switch (_input.LA(1)) {
				case SELECT:
				case UPDATE:
					{
					setState(856); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(852);
						_la = _input.LA(1);
						if ( !(_la==SELECT || _la==UPDATE) ) {
						_errHandler.recoverInline(this);
						}
						consume();
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
					} while ( _la==SELECT || _la==UPDATE );
					}
					break;
				case ALL:
					{
					setState(860); match(ALL);
					setState(862);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(861); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(866); match(ON);
				setState(867); match(LARGE);
				setState(868); match(OBJECT);
				setState(873); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(869); ((Grant_statementContext)_localctx).loid = identifier();
						setState(871);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(870); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(875); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,95,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(877); grant_to_rule();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(879); match(GRANT);
				setState(892);
				switch (_input.LA(1)) {
				case CREATE:
				case USAGE:
					{
					setState(884); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(880);
						_la = _input.LA(1);
						if ( !(_la==CREATE || _la==USAGE) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(882);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(881); match(COMMA);
							}
						}

						}
						}
						setState(886); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==CREATE || _la==USAGE );
					}
					break;
				case ALL:
					{
					setState(888); match(ALL);
					setState(890);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(889); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(894); match(ON);
				setState(895); match(SCHEMA);
				setState(900); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(896); ((Grant_statementContext)_localctx).schema_name = identifier();
						setState(898);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(897); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(902); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,101,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(904); grant_to_rule();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(906); match(GRANT);
				setState(912);
				switch (_input.LA(1)) {
				case CREATE:
					{
					setState(907); match(CREATE);
					}
					break;
				case ALL:
					{
					setState(908); match(ALL);
					setState(910);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(909); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(914); match(ON);
				setState(915); match(TABLESPACE);
				setState(920); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(916); ((Grant_statementContext)_localctx).tablespace_name = identifier();
						setState(918);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(917); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(922); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,105,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(924); grant_to_rule();
				setState(925); match(GRANT);
				setState(930); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(926); ((Grant_statementContext)_localctx).role_name = identifier();
						setState(928);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(927); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(932); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,107,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(934); match(TO);
				setState(939); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(935); ((Grant_statementContext)_localctx).role_name = identifier();
						setState(937);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(936); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(941); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,109,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(946);
				_la = _input.LA(1);
				if (_la==WITH) {
					{
					setState(943); match(WITH);
					setState(944); match(ADMIN);
					setState(945); match(OPTION);
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
		enterRule(_localctx, 20, RULE_grant_to_rule);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(950); match(TO);
			setState(961); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(952);
					_la = _input.LA(1);
					if (_la==GROUP) {
						{
						setState(951); match(GROUP);
						}
					}

					setState(956);
					switch ( getInterpreter().adaptivePredict(_input,113,_ctx) ) {
					case 1:
						{
						{
						setState(954); ((Grant_to_ruleContext)_localctx).role_name = identifier();
						}
						}
						break;
					case 2:
						{
						setState(955); match(PUBLIC);
						}
						break;
					}
					setState(959);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(958); match(COMMA);
						}
					}

					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(963); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,115,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(968);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(965); match(WITH);
				setState(966); match(GRANT);
				setState(967); match(OPTION);
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
		enterRule(_localctx, 22, RULE_argmode);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(970);
			_la = _input.LA(1);
			if ( !(((((_la - 42)) & ~0x3f) == 0 && ((1L << (_la - 42)) & ((1L << (IN - 42)) | (1L << (INOUT - 42)) | (1L << (OUT - 42)) | (1L << (VARIADIC - 42)))) != 0)) ) {
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

	public static class Create_table_statementContext extends ParserRuleContext {
		public Table_nameContext n;
		public IdentifierContext file_type;
		public Token path;
		public TerminalNode AS() { return getToken(SQLParser.AS, 0); }
		public TerminalNode CREATE() { return getToken(SQLParser.CREATE, 0); }
		public Param_clauseContext param_clause() {
			return getRuleContext(Param_clauseContext.class,0);
		}
		public TerminalNode LOCATION() { return getToken(SQLParser.LOCATION, 0); }
		public Table_partitioning_clausesContext table_partitioning_clauses() {
			return getRuleContext(Table_partitioning_clausesContext.class,0);
		}
		public TerminalNode Character_String_Literal() { return getToken(SQLParser.Character_String_Literal, 0); }
		public Table_elementsContext table_elements() {
			return getRuleContext(Table_elementsContext.class,0);
		}
		public TerminalNode EXTERNAL() { return getToken(SQLParser.EXTERNAL, 0); }
		public Query_expressionContext query_expression() {
			return getRuleContext(Query_expressionContext.class,0);
		}
		public TerminalNode USING() { return getToken(SQLParser.USING, 0); }
		public TerminalNode TABLE() { return getToken(SQLParser.TABLE, 0); }
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
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
		enterRule(_localctx, 24, RULE_create_table_statement);
		int _la;
		try {
			setState(1022);
			switch ( getInterpreter().adaptivePredict(_input,126,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(972); match(CREATE);
				setState(973); match(EXTERNAL);
				setState(974); match(TABLE);
				setState(975); ((Create_table_statementContext)_localctx).n = table_name();
				setState(976); table_elements();
				setState(977); match(USING);
				setState(978); ((Create_table_statementContext)_localctx).file_type = identifier();
				setState(980);
				_la = _input.LA(1);
				if (_la==WITH) {
					{
					setState(979); param_clause();
					}
				}

				setState(983);
				_la = _input.LA(1);
				if (_la==PARTITION) {
					{
					setState(982); table_partitioning_clauses();
					}
				}

				{
				setState(985); match(LOCATION);
				setState(986); ((Create_table_statementContext)_localctx).path = match(Character_String_Literal);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(988); match(CREATE);
				setState(989); match(TABLE);
				setState(990); ((Create_table_statementContext)_localctx).n = table_name();
				setState(991); table_elements();
				setState(994);
				_la = _input.LA(1);
				if (_la==USING) {
					{
					setState(992); match(USING);
					setState(993); ((Create_table_statementContext)_localctx).file_type = identifier();
					}
				}

				setState(997);
				_la = _input.LA(1);
				if (_la==WITH) {
					{
					setState(996); param_clause();
					}
				}

				setState(1000);
				switch ( getInterpreter().adaptivePredict(_input,121,_ctx) ) {
				case 1:
					{
					setState(999); table_partitioning_clauses();
					}
					break;
				}
				setState(1004);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(1002); match(AS);
					setState(1003); query_expression();
					}
				}

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1006); match(CREATE);
				setState(1007); match(TABLE);
				setState(1008); ((Create_table_statementContext)_localctx).n = table_name();
				setState(1011);
				_la = _input.LA(1);
				if (_la==USING) {
					{
					setState(1009); match(USING);
					setState(1010); ((Create_table_statementContext)_localctx).file_type = identifier();
					}
				}

				setState(1014);
				_la = _input.LA(1);
				if (_la==WITH) {
					{
					setState(1013); param_clause();
					}
				}

				setState(1017);
				_la = _input.LA(1);
				if (_la==PARTITION) {
					{
					setState(1016); table_partitioning_clauses();
					}
				}

				setState(1019); match(AS);
				setState(1020); query_expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 26, RULE_table_elements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1024); match(LEFT_PAREN);
			setState(1025); field_element();
			setState(1030);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1026); match(COMMA);
				setState(1027); field_element();
				}
				}
				setState(1032);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1033); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 28, RULE_field_element);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1035); ((Field_elementContext)_localctx).name = identifier();
			setState(1036); field_type();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 30, RULE_field_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1038); data_type();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 32, RULE_param_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1040); match(WITH);
			setState(1041); match(LEFT_PAREN);
			setState(1042); param();
			setState(1047);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1043); match(COMMA);
				setState(1044); param();
				}
				}
				setState(1049);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1050); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 34, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1052); ((ParamContext)_localctx).key = match(Character_String_Literal);
			setState(1053); match(EQUAL);
			setState(1054); ((ParamContext)_localctx).value = numeric_value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 36, RULE_method_specifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1056); match(USING);
			setState(1057); ((Method_specifierContext)_localctx).m = identifier();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 38, RULE_table_space_specifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1059); match(TABLESPACE);
			setState(1060); table_space_name();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 40, RULE_table_space_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1062); identifier();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 42, RULE_table_partitioning_clauses);
		try {
			setState(1068);
			switch ( getInterpreter().adaptivePredict(_input,129,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1064); range_partitions();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1065); hash_partitions();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1066); list_partitions();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1067); column_partitions();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 44, RULE_range_partitions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1070); match(PARTITION);
			setState(1071); match(BY);
			setState(1072); match(RANGE);
			setState(1073); match(LEFT_PAREN);
			setState(1074); column_reference_list();
			setState(1075); match(RIGHT_PAREN);
			setState(1076); match(LEFT_PAREN);
			setState(1077); range_value_clause_list();
			setState(1078); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 46, RULE_range_value_clause_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1080); range_value_clause();
			setState(1085);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1081); match(COMMA);
				setState(1082); range_value_clause();
				}
				}
				setState(1087);
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
		enterRule(_localctx, 48, RULE_range_value_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1088); match(PARTITION);
			setState(1089); partition_name();
			setState(1090); match(VALUES);
			setState(1091); match(LESS);
			setState(1092); match(THAN);
			setState(1104);
			switch ( getInterpreter().adaptivePredict(_input,133,_ctx) ) {
			case 1:
				{
				setState(1093); match(LEFT_PAREN);
				setState(1094); value_expression();
				setState(1095); match(RIGHT_PAREN);
				}
				break;
			case 2:
				{
				setState(1098);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(1097); match(LEFT_PAREN);
					}
				}

				setState(1100); match(MAXVALUE);
				setState(1102);
				switch ( getInterpreter().adaptivePredict(_input,132,_ctx) ) {
				case 1:
					{
					setState(1101); match(RIGHT_PAREN);
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
		enterRule(_localctx, 50, RULE_hash_partitions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1106); match(PARTITION);
			setState(1107); match(BY);
			setState(1108); match(HASH);
			setState(1109); match(LEFT_PAREN);
			setState(1110); column_reference_list();
			setState(1111); match(RIGHT_PAREN);
			setState(1117);
			switch (_input.LA(1)) {
			case LEFT_PAREN:
				{
				setState(1112); match(LEFT_PAREN);
				setState(1113); individual_hash_partitions();
				setState(1114); match(RIGHT_PAREN);
				}
				break;
			case PARTITIONS:
				{
				setState(1116); hash_partitions_by_quantity();
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
		enterRule(_localctx, 52, RULE_individual_hash_partitions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1119); individual_hash_partition();
			setState(1124);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1120); match(COMMA);
				setState(1121); individual_hash_partition();
				}
				}
				setState(1126);
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
		enterRule(_localctx, 54, RULE_individual_hash_partition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1127); match(PARTITION);
			setState(1128); partition_name();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 56, RULE_hash_partitions_by_quantity);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1130); match(PARTITIONS);
			setState(1131); ((Hash_partitions_by_quantityContext)_localctx).quantity = numeric_value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 58, RULE_list_partitions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1133); match(PARTITION);
			setState(1134); match(BY);
			setState(1135); match(LIST);
			setState(1136); match(LEFT_PAREN);
			setState(1137); column_reference_list();
			setState(1138); match(RIGHT_PAREN);
			setState(1139); match(LEFT_PAREN);
			setState(1140); list_value_clause_list();
			setState(1141); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 60, RULE_list_value_clause_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1143); list_value_partition();
			setState(1148);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1144); match(COMMA);
				setState(1145); list_value_partition();
				}
				}
				setState(1150);
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
		enterRule(_localctx, 62, RULE_list_value_partition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1151); match(PARTITION);
			setState(1152); partition_name();
			setState(1153); match(VALUES);
			setState(1155);
			_la = _input.LA(1);
			if (_la==IN) {
				{
				setState(1154); match(IN);
				}
			}

			setState(1157); match(LEFT_PAREN);
			setState(1158); in_value_list();
			setState(1159); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 64, RULE_column_partitions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1161); match(PARTITION);
			setState(1162); match(BY);
			setState(1163); match(COLUMN);
			setState(1164); table_elements();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 66, RULE_partition_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1166); identifier();
			}
		}
		catch (RecognitionException re) {
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
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public TerminalNode DROP() { return getToken(SQLParser.DROP, 0); }
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
		enterRule(_localctx, 68, RULE_drop_table_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1168); match(DROP);
			setState(1169); match(TABLE);
			setState(1170); table_name();
			setState(1172);
			switch ( getInterpreter().adaptivePredict(_input,138,_ctx) ) {
			case 1:
				{
				setState(1171); match(PURGE);
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
		enterRule(_localctx, 70, RULE_identifier);
		try {
			setState(1176);
			switch (_input.LA(1)) {
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(1174); match(Identifier);
				}
				break;
			case ADMIN:
			case AVG:
			case BETWEEN:
			case BY:
			case CENTURY:
			case CHARACTER:
			case COLLECT:
			case COALESCE:
			case COLUMN:
			case COUNT:
			case CUBE:
			case DATA:
			case DAY:
			case DEC:
			case DECADE:
			case DOW:
			case DOY:
			case DROP:
			case EPOCH:
			case EVERY:
			case EXISTS:
			case EXTERNAL:
			case EXTRACT:
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
			case OVERWRITE:
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
			case SECOND:
			case SERVER:
			case SET:
			case SIMILAR:
			case STDDEV_POP:
			case STDDEV_SAMP:
			case SUBPARTITION:
			case SUM:
			case TABLESPACE:
			case THAN:
			case TIMEZONE:
			case TIMEZONE_HOUR:
			case TIMEZONE_MINUTE:
			case TRIM:
			case TO:
			case UNKNOWN:
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
				setState(1175); nonreserved_keywords();
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
		public TerminalNode COALESCE() { return getToken(SQLParser.COALESCE, 0); }
		public TerminalNode STDDEV_POP() { return getToken(SQLParser.STDDEV_POP, 0); }
		public TerminalNode VAR_SAMP() { return getToken(SQLParser.VAR_SAMP, 0); }
		public TerminalNode BIT() { return getToken(SQLParser.BIT, 0); }
		public TerminalNode SUM() { return getToken(SQLParser.SUM, 0); }
		public TerminalNode INT() { return getToken(SQLParser.INT, 0); }
		public TerminalNode QUARTER() { return getToken(SQLParser.QUARTER, 0); }
		public TerminalNode EVERY() { return getToken(SQLParser.EVERY, 0); }
		public TerminalNode NVARCHAR() { return getToken(SQLParser.NVARCHAR, 0); }
		public TerminalNode INT1() { return getToken(SQLParser.INT1, 0); }
		public TerminalNode MAX() { return getToken(SQLParser.MAX, 0); }
		public TerminalNode ROLLUP() { return getToken(SQLParser.ROLLUP, 0); }
		public TerminalNode SECOND() { return getToken(SQLParser.SECOND, 0); }
		public TerminalNode COUNT() { return getToken(SQLParser.COUNT, 0); }
		public TerminalNode VARYING() { return getToken(SQLParser.VARYING, 0); }
		public TerminalNode YEAR() { return getToken(SQLParser.YEAR, 0); }
		public TerminalNode SIMILAR() { return getToken(SQLParser.SIMILAR, 0); }
		public TerminalNode RLIKE() { return getToken(SQLParser.RLIKE, 0); }
		public TerminalNode PARTITION() { return getToken(SQLParser.PARTITION, 0); }
		public TerminalNode PURGE() { return getToken(SQLParser.PURGE, 0); }
		public TerminalNode BYTEA() { return getToken(SQLParser.BYTEA, 0); }
		public TerminalNode CHAR() { return getToken(SQLParser.CHAR, 0); }
		public TerminalNode VARBINARY() { return getToken(SQLParser.VARBINARY, 0); }
		public TerminalNode VARCHAR() { return getToken(SQLParser.VARCHAR, 0); }
		public TerminalNode AVG() { return getToken(SQLParser.AVG, 0); }
		public TerminalNode INET4() { return getToken(SQLParser.INET4, 0); }
		public TerminalNode FLOAT8() { return getToken(SQLParser.FLOAT8, 0); }
		public TerminalNode DROP() { return getToken(SQLParser.DROP, 0); }
		public TerminalNode VAR_POP() { return getToken(SQLParser.VAR_POP, 0); }
		public TerminalNode MINUTE() { return getToken(SQLParser.MINUTE, 0); }
		public TerminalNode ISOYEAR() { return getToken(SQLParser.ISOYEAR, 0); }
		public TerminalNode LAST() { return getToken(SQLParser.LAST, 0); }
		public TerminalNode COLUMN() { return getToken(SQLParser.COLUMN, 0); }
		public TerminalNode PUBLIC() { return getToken(SQLParser.PUBLIC, 0); }
		public TerminalNode DATA() { return getToken(SQLParser.DATA, 0); }
		public TerminalNode OVERWRITE() { return getToken(SQLParser.OVERWRITE, 0); }
		public TerminalNode NCHAR() { return getToken(SQLParser.NCHAR, 0); }
		public TerminalNode TIMEZONE_HOUR() { return getToken(SQLParser.TIMEZONE_HOUR, 0); }
		public TerminalNode TIMETZ() { return getToken(SQLParser.TIMETZ, 0); }
		public TerminalNode OBJECT() { return getToken(SQLParser.OBJECT, 0); }
		public TerminalNode TABLESPACE() { return getToken(SQLParser.TABLESPACE, 0); }
		public TerminalNode TEXT() { return getToken(SQLParser.TEXT, 0); }
		public TerminalNode MONTH() { return getToken(SQLParser.MONTH, 0); }
		public TerminalNode BLOB() { return getToken(SQLParser.BLOB, 0); }
		public TerminalNode DEC() { return getToken(SQLParser.DEC, 0); }
		public TerminalNode INTERSECTION() { return getToken(SQLParser.INTERSECTION, 0); }
		public TerminalNode LESS() { return getToken(SQLParser.LESS, 0); }
		public TerminalNode MILLENNIUM() { return getToken(SQLParser.MILLENNIUM, 0); }
		public TerminalNode OPTION() { return getToken(SQLParser.OPTION, 0); }
		public TerminalNode TINYINT() { return getToken(SQLParser.TINYINT, 0); }
		public TerminalNode GROUPING() { return getToken(SQLParser.GROUPING, 0); }
		public TerminalNode TIMESTAMPTZ() { return getToken(SQLParser.TIMESTAMPTZ, 0); }
		public TerminalNode NATIONAL() { return getToken(SQLParser.NATIONAL, 0); }
		public TerminalNode BETWEEN() { return getToken(SQLParser.BETWEEN, 0); }
		public TerminalNode DATE() { return getToken(SQLParser.DATE, 0); }
		public TerminalNode FUSION() { return getToken(SQLParser.FUSION, 0); }
		public TerminalNode INT2() { return getToken(SQLParser.INT2, 0); }
		public TerminalNode VARBIT() { return getToken(SQLParser.VARBIT, 0); }
		public TerminalNode WEEK() { return getToken(SQLParser.WEEK, 0); }
		public TerminalNode ZONE() { return getToken(SQLParser.ZONE, 0); }
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
		public TerminalNode BY() { return getToken(SQLParser.BY, 0); }
		public TerminalNode WRAPPER() { return getToken(SQLParser.WRAPPER, 0); }
		public TerminalNode TO() { return getToken(SQLParser.TO, 0); }
		public TerminalNode VALUES() { return getToken(SQLParser.VALUES, 0); }
		public TerminalNode SMALLINT() { return getToken(SQLParser.SMALLINT, 0); }
		public TerminalNode ISODOW() { return getToken(SQLParser.ISODOW, 0); }
		public TerminalNode FORMAT() { return getToken(SQLParser.FORMAT, 0); }
		public TerminalNode DOY() { return getToken(SQLParser.DOY, 0); }
		public TerminalNode MIN() { return getToken(SQLParser.MIN, 0); }
		public TerminalNode FILTER() { return getToken(SQLParser.FILTER, 0); }
		public TerminalNode PRECISION() { return getToken(SQLParser.PRECISION, 0); }
		public TerminalNode SUBPARTITION() { return getToken(SQLParser.SUBPARTITION, 0); }
		public TerminalNode DOW() { return getToken(SQLParser.DOW, 0); }
		public TerminalNode EXTERNAL() { return getToken(SQLParser.EXTERNAL, 0); }
		public TerminalNode MICROSECONDS() { return getToken(SQLParser.MICROSECONDS, 0); }
		public TerminalNode HASH() { return getToken(SQLParser.HASH, 0); }
		public TerminalNode DECIMAL() { return getToken(SQLParser.DECIMAL, 0); }
		public TerminalNode SET() { return getToken(SQLParser.SET, 0); }
		public TerminalNode THAN() { return getToken(SQLParser.THAN, 0); }
		public TerminalNode ADMIN() { return getToken(SQLParser.ADMIN, 0); }
		public TerminalNode EPOCH() { return getToken(SQLParser.EPOCH, 0); }
		public TerminalNode REGEXP() { return getToken(SQLParser.REGEXP, 0); }
		public TerminalNode TIMEZONE() { return getToken(SQLParser.TIMEZONE, 0); }
		public TerminalNode FLOAT4() { return getToken(SQLParser.FLOAT4, 0); }
		public TerminalNode CUBE() { return getToken(SQLParser.CUBE, 0); }
		public TerminalNode UNKNOWN() { return getToken(SQLParser.UNKNOWN, 0); }
		public TerminalNode TIMEZONE_MINUTE() { return getToken(SQLParser.TIMEZONE_MINUTE, 0); }
		public TerminalNode BOOLEAN() { return getToken(SQLParser.BOOLEAN, 0); }
		public TerminalNode CHARACTER() { return getToken(SQLParser.CHARACTER, 0); }
		public TerminalNode SERVER() { return getToken(SQLParser.SERVER, 0); }
		public TerminalNode REAL() { return getToken(SQLParser.REAL, 0); }
		public TerminalNode LANGUAGE() { return getToken(SQLParser.LANGUAGE, 0); }
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
		enterRule(_localctx, 72, RULE_nonreserved_keywords);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1178);
			_la = _input.LA(1);
			if ( !(((((_la - 96)) & ~0x3f) == 0 && ((1L << (_la - 96)) & ((1L << (ADMIN - 96)) | (1L << (AVG - 96)) | (1L << (BETWEEN - 96)) | (1L << (BY - 96)) | (1L << (CENTURY - 96)) | (1L << (CHARACTER - 96)) | (1L << (COLLECT - 96)) | (1L << (COALESCE - 96)) | (1L << (COLUMN - 96)) | (1L << (COUNT - 96)) | (1L << (CUBE - 96)) | (1L << (DATA - 96)) | (1L << (DAY - 96)) | (1L << (DEC - 96)) | (1L << (DECADE - 96)) | (1L << (DOW - 96)) | (1L << (DOY - 96)) | (1L << (DROP - 96)) | (1L << (EPOCH - 96)) | (1L << (EVERY - 96)) | (1L << (EXISTS - 96)) | (1L << (EXTERNAL - 96)) | (1L << (EXTRACT - 96)) | (1L << (FILTER - 96)) | (1L << (FIRST - 96)) | (1L << (FORMAT - 96)) | (1L << (FUSION - 96)) | (1L << (GROUPING - 96)) | (1L << (HASH - 96)) | (1L << (INDEX - 96)) | (1L << (INSERT - 96)) | (1L << (INTERSECTION - 96)) | (1L << (ISODOW - 96)) | (1L << (ISOYEAR - 96)) | (1L << (LANGUAGE - 96)) | (1L << (LARGE - 96)) | (1L << (LAST - 96)) | (1L << (LESS - 96)) | (1L << (LIST - 96)) | (1L << (LOCATION - 96)) | (1L << (MAX - 96)) | (1L << (MAXVALUE - 96)) | (1L << (MICROSECONDS - 96)) | (1L << (MILLENNIUM - 96)) | (1L << (MILLISECONDS - 96)) | (1L << (MIN - 96)) | (1L << (MINUTE - 96)) | (1L << (MONTH - 96)) | (1L << (NATIONAL - 96)) | (1L << (NULLIF - 96)) | (1L << (OBJECT - 96)) | (1L << (OPTION - 96)) | (1L << (OVERWRITE - 96)) | (1L << (PARTITION - 96)) | (1L << (PARTITIONS - 96)) | (1L << (PRECISION - 96)) | (1L << (PUBLIC - 96)) | (1L << (PURGE - 96)) | (1L << (QUARTER - 96)) | (1L << (RANGE - 96)) | (1L << (REGEXP - 96)) | (1L << (RLIKE - 96)) | (1L << (ROLLUP - 96)))) != 0) || ((((_la - 160)) & ~0x3f) == 0 && ((1L << (_la - 160)) & ((1L << (SECOND - 160)) | (1L << (SERVER - 160)) | (1L << (SET - 160)) | (1L << (SIMILAR - 160)) | (1L << (STDDEV_POP - 160)) | (1L << (STDDEV_SAMP - 160)) | (1L << (SUBPARTITION - 160)) | (1L << (SUM - 160)) | (1L << (TABLESPACE - 160)) | (1L << (THAN - 160)) | (1L << (TIMEZONE - 160)) | (1L << (TIMEZONE_HOUR - 160)) | (1L << (TIMEZONE_MINUTE - 160)) | (1L << (TRIM - 160)) | (1L << (TO - 160)) | (1L << (UNKNOWN - 160)) | (1L << (VALUES - 160)) | (1L << (VAR_SAMP - 160)) | (1L << (VAR_POP - 160)) | (1L << (VARYING - 160)) | (1L << (WEEK - 160)) | (1L << (WRAPPER - 160)) | (1L << (YEAR - 160)) | (1L << (ZONE - 160)) | (1L << (BOOLEAN - 160)) | (1L << (BOOL - 160)) | (1L << (BIT - 160)) | (1L << (VARBIT - 160)) | (1L << (INT1 - 160)) | (1L << (INT2 - 160)) | (1L << (INT4 - 160)) | (1L << (INT8 - 160)) | (1L << (TINYINT - 160)) | (1L << (SMALLINT - 160)) | (1L << (INT - 160)) | (1L << (INTEGER - 160)) | (1L << (BIGINT - 160)) | (1L << (FLOAT4 - 160)) | (1L << (FLOAT8 - 160)) | (1L << (REAL - 160)) | (1L << (FLOAT - 160)) | (1L << (DOUBLE - 160)) | (1L << (NUMERIC - 160)) | (1L << (DECIMAL - 160)) | (1L << (CHAR - 160)) | (1L << (VARCHAR - 160)) | (1L << (NCHAR - 160)) | (1L << (NVARCHAR - 160)) | (1L << (DATE - 160)) | (1L << (TIME - 160)) | (1L << (TIMETZ - 160)) | (1L << (TIMESTAMP - 160)) | (1L << (TIMESTAMPTZ - 160)) | (1L << (TEXT - 160)) | (1L << (VARBINARY - 160)) | (1L << (BLOB - 160)) | (1L << (BYTEA - 160)) | (1L << (INET4 - 160)))) != 0)) ) {
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
		enterRule(_localctx, 74, RULE_unsigned_literal);
		try {
			setState(1182);
			switch (_input.LA(1)) {
			case NUMBER:
			case REAL_NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(1180); unsigned_numeric_literal();
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
				setState(1181); general_literal();
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
		enterRule(_localctx, 76, RULE_general_literal);
		try {
			setState(1187);
			switch (_input.LA(1)) {
			case Character_String_Literal:
				enterOuterAlt(_localctx, 1);
				{
				setState(1184); match(Character_String_Literal);
				}
				break;
			case DATE:
			case TIME:
			case TIMESTAMP:
				enterOuterAlt(_localctx, 2);
				{
				setState(1185); datetime_literal();
				}
				break;
			case FALSE:
			case TRUE:
			case UNKNOWN:
				enterOuterAlt(_localctx, 3);
				{
				setState(1186); boolean_literal();
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
		enterRule(_localctx, 78, RULE_datetime_literal);
		try {
			setState(1192);
			switch (_input.LA(1)) {
			case TIMESTAMP:
				enterOuterAlt(_localctx, 1);
				{
				setState(1189); timestamp_literal();
				}
				break;
			case TIME:
				enterOuterAlt(_localctx, 2);
				{
				setState(1190); time_literal();
				}
				break;
			case DATE:
				enterOuterAlt(_localctx, 3);
				{
				setState(1191); date_literal();
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
		enterRule(_localctx, 80, RULE_time_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1194); match(TIME);
			setState(1195); ((Time_literalContext)_localctx).time_string = match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 82, RULE_timestamp_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1197); match(TIMESTAMP);
			setState(1198); ((Timestamp_literalContext)_localctx).timestamp_string = match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 84, RULE_date_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1200); match(DATE);
			setState(1201); ((Date_literalContext)_localctx).date_string = match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 86, RULE_boolean_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1203);
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
		enterRule(_localctx, 88, RULE_data_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1205); predefined_type();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 90, RULE_predefined_type);
		try {
			setState(1216);
			switch (_input.LA(1)) {
			case CHARACTER:
			case CHAR:
			case VARCHAR:
			case TEXT:
				enterOuterAlt(_localctx, 1);
				{
				setState(1207); character_string_type();
				}
				break;
			case NATIONAL:
			case NCHAR:
			case NVARCHAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(1208); national_character_string_type();
				}
				break;
			case BLOB:
			case BYTEA:
				enterOuterAlt(_localctx, 3);
				{
				setState(1209); binary_large_object_string_type();
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
				setState(1210); numeric_type();
				}
				break;
			case BOOLEAN:
			case BOOL:
				enterOuterAlt(_localctx, 5);
				{
				setState(1211); boolean_type();
				}
				break;
			case DATE:
			case TIME:
			case TIMETZ:
			case TIMESTAMP:
			case TIMESTAMPTZ:
				enterOuterAlt(_localctx, 6);
				{
				setState(1212); datetime_type();
				}
				break;
			case BIT:
			case VARBIT:
				enterOuterAlt(_localctx, 7);
				{
				setState(1213); bit_type();
				}
				break;
			case BINARY:
			case VARBINARY:
				enterOuterAlt(_localctx, 8);
				{
				setState(1214); binary_type();
				}
				break;
			case INET4:
				enterOuterAlt(_localctx, 9);
				{
				setState(1215); network_type();
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
		enterRule(_localctx, 92, RULE_network_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1218); match(INET4);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 94, RULE_character_string_type);
		try {
			setState(1243);
			switch ( getInterpreter().adaptivePredict(_input,149,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1220); match(CHARACTER);
				setState(1222);
				switch ( getInterpreter().adaptivePredict(_input,144,_ctx) ) {
				case 1:
					{
					setState(1221); type_length();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1224); match(CHAR);
				setState(1226);
				switch ( getInterpreter().adaptivePredict(_input,145,_ctx) ) {
				case 1:
					{
					setState(1225); type_length();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1228); match(CHARACTER);
				setState(1229); match(VARYING);
				setState(1231);
				switch ( getInterpreter().adaptivePredict(_input,146,_ctx) ) {
				case 1:
					{
					setState(1230); type_length();
					}
					break;
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1233); match(CHAR);
				setState(1234); match(VARYING);
				setState(1236);
				switch ( getInterpreter().adaptivePredict(_input,147,_ctx) ) {
				case 1:
					{
					setState(1235); type_length();
					}
					break;
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1238); match(VARCHAR);
				setState(1240);
				switch ( getInterpreter().adaptivePredict(_input,148,_ctx) ) {
				case 1:
					{
					setState(1239); type_length();
					}
					break;
				}
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1242); match(TEXT);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 96, RULE_type_length);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1245); match(LEFT_PAREN);
			setState(1246); match(NUMBER);
			setState(1247); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 98, RULE_national_character_string_type);
		try {
			setState(1284);
			switch ( getInterpreter().adaptivePredict(_input,157,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1249); match(NATIONAL);
				setState(1250); match(CHARACTER);
				setState(1252);
				switch ( getInterpreter().adaptivePredict(_input,150,_ctx) ) {
				case 1:
					{
					setState(1251); type_length();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1254); match(NATIONAL);
				setState(1255); match(CHAR);
				setState(1257);
				switch ( getInterpreter().adaptivePredict(_input,151,_ctx) ) {
				case 1:
					{
					setState(1256); type_length();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1259); match(NCHAR);
				setState(1261);
				switch ( getInterpreter().adaptivePredict(_input,152,_ctx) ) {
				case 1:
					{
					setState(1260); type_length();
					}
					break;
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1263); match(NATIONAL);
				setState(1264); match(CHARACTER);
				setState(1265); match(VARYING);
				setState(1267);
				switch ( getInterpreter().adaptivePredict(_input,153,_ctx) ) {
				case 1:
					{
					setState(1266); type_length();
					}
					break;
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1269); match(NATIONAL);
				setState(1270); match(CHAR);
				setState(1271); match(VARYING);
				setState(1273);
				switch ( getInterpreter().adaptivePredict(_input,154,_ctx) ) {
				case 1:
					{
					setState(1272); type_length();
					}
					break;
				}
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1275); match(NCHAR);
				setState(1276); match(VARYING);
				setState(1278);
				switch ( getInterpreter().adaptivePredict(_input,155,_ctx) ) {
				case 1:
					{
					setState(1277); type_length();
					}
					break;
				}
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1280); match(NVARCHAR);
				setState(1282);
				switch ( getInterpreter().adaptivePredict(_input,156,_ctx) ) {
				case 1:
					{
					setState(1281); type_length();
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
		enterRule(_localctx, 100, RULE_binary_large_object_string_type);
		try {
			setState(1294);
			switch (_input.LA(1)) {
			case BLOB:
				enterOuterAlt(_localctx, 1);
				{
				setState(1286); match(BLOB);
				setState(1288);
				switch ( getInterpreter().adaptivePredict(_input,158,_ctx) ) {
				case 1:
					{
					setState(1287); type_length();
					}
					break;
				}
				}
				break;
			case BYTEA:
				enterOuterAlt(_localctx, 2);
				{
				setState(1290); match(BYTEA);
				setState(1292);
				switch ( getInterpreter().adaptivePredict(_input,159,_ctx) ) {
				case 1:
					{
					setState(1291); type_length();
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
		enterRule(_localctx, 102, RULE_numeric_type);
		try {
			setState(1298);
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
				setState(1296); exact_numeric_type();
				}
				break;
			case FLOAT4:
			case FLOAT8:
			case REAL:
			case FLOAT:
			case DOUBLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(1297); approximate_numeric_type();
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
		enterRule(_localctx, 104, RULE_exact_numeric_type);
		try {
			setState(1321);
			switch (_input.LA(1)) {
			case NUMERIC:
				enterOuterAlt(_localctx, 1);
				{
				setState(1300); match(NUMERIC);
				setState(1302);
				switch ( getInterpreter().adaptivePredict(_input,162,_ctx) ) {
				case 1:
					{
					setState(1301); precision_param();
					}
					break;
				}
				}
				break;
			case DECIMAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(1304); match(DECIMAL);
				setState(1306);
				switch ( getInterpreter().adaptivePredict(_input,163,_ctx) ) {
				case 1:
					{
					setState(1305); precision_param();
					}
					break;
				}
				}
				break;
			case DEC:
				enterOuterAlt(_localctx, 3);
				{
				setState(1308); match(DEC);
				setState(1310);
				switch ( getInterpreter().adaptivePredict(_input,164,_ctx) ) {
				case 1:
					{
					setState(1309); precision_param();
					}
					break;
				}
				}
				break;
			case INT1:
				enterOuterAlt(_localctx, 4);
				{
				setState(1312); match(INT1);
				}
				break;
			case TINYINT:
				enterOuterAlt(_localctx, 5);
				{
				setState(1313); match(TINYINT);
				}
				break;
			case INT2:
				enterOuterAlt(_localctx, 6);
				{
				setState(1314); match(INT2);
				}
				break;
			case SMALLINT:
				enterOuterAlt(_localctx, 7);
				{
				setState(1315); match(SMALLINT);
				}
				break;
			case INT4:
				enterOuterAlt(_localctx, 8);
				{
				setState(1316); match(INT4);
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 9);
				{
				setState(1317); match(INT);
				}
				break;
			case INTEGER:
				enterOuterAlt(_localctx, 10);
				{
				setState(1318); match(INTEGER);
				}
				break;
			case INT8:
				enterOuterAlt(_localctx, 11);
				{
				setState(1319); match(INT8);
				}
				break;
			case BIGINT:
				enterOuterAlt(_localctx, 12);
				{
				setState(1320); match(BIGINT);
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
		enterRule(_localctx, 106, RULE_approximate_numeric_type);
		try {
			setState(1333);
			switch ( getInterpreter().adaptivePredict(_input,167,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1323); match(FLOAT);
				setState(1325);
				switch ( getInterpreter().adaptivePredict(_input,166,_ctx) ) {
				case 1:
					{
					setState(1324); precision_param();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1327); match(FLOAT4);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1328); match(REAL);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1329); match(FLOAT8);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1330); match(DOUBLE);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1331); match(DOUBLE);
				setState(1332); match(PRECISION);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 108, RULE_precision_param);
		try {
			setState(1343);
			switch ( getInterpreter().adaptivePredict(_input,168,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1335); match(LEFT_PAREN);
				setState(1336); ((Precision_paramContext)_localctx).precision = match(NUMBER);
				setState(1337); match(RIGHT_PAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1338); match(LEFT_PAREN);
				setState(1339); ((Precision_paramContext)_localctx).precision = match(NUMBER);
				setState(1340); match(COMMA);
				setState(1341); ((Precision_paramContext)_localctx).scale = match(NUMBER);
				setState(1342); match(RIGHT_PAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 110, RULE_boolean_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1345);
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
		enterRule(_localctx, 112, RULE_datetime_type);
		try {
			setState(1360);
			switch ( getInterpreter().adaptivePredict(_input,169,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1347); match(DATE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1348); match(TIME);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1349); match(TIME);
				setState(1350); match(WITH);
				setState(1351); match(TIME);
				setState(1352); match(ZONE);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1353); match(TIMETZ);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1354); match(TIMESTAMP);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1355); match(TIMESTAMP);
				setState(1356); match(WITH);
				setState(1357); match(TIME);
				setState(1358); match(ZONE);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1359); match(TIMESTAMPTZ);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 114, RULE_bit_type);
		try {
			setState(1375);
			switch ( getInterpreter().adaptivePredict(_input,173,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1362); match(BIT);
				setState(1364);
				switch ( getInterpreter().adaptivePredict(_input,170,_ctx) ) {
				case 1:
					{
					setState(1363); type_length();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1366); match(VARBIT);
				setState(1368);
				switch ( getInterpreter().adaptivePredict(_input,171,_ctx) ) {
				case 1:
					{
					setState(1367); type_length();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1370); match(BIT);
				setState(1371); match(VARYING);
				setState(1373);
				switch ( getInterpreter().adaptivePredict(_input,172,_ctx) ) {
				case 1:
					{
					setState(1372); type_length();
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
		enterRule(_localctx, 116, RULE_binary_type);
		try {
			setState(1390);
			switch ( getInterpreter().adaptivePredict(_input,177,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1377); match(BINARY);
				setState(1379);
				switch ( getInterpreter().adaptivePredict(_input,174,_ctx) ) {
				case 1:
					{
					setState(1378); type_length();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1381); match(BINARY);
				setState(1382); match(VARYING);
				setState(1384);
				switch ( getInterpreter().adaptivePredict(_input,175,_ctx) ) {
				case 1:
					{
					setState(1383); type_length();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1386); match(VARBINARY);
				setState(1388);
				switch ( getInterpreter().adaptivePredict(_input,176,_ctx) ) {
				case 1:
					{
					setState(1387); type_length();
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
		enterRule(_localctx, 118, RULE_value_expression_primary);
		try {
			setState(1394);
			switch ( getInterpreter().adaptivePredict(_input,178,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1392); parenthesized_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1393); nonparenthesized_value_expression_primary();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 120, RULE_parenthesized_value_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1396); match(LEFT_PAREN);
			setState(1397); value_expression();
			setState(1398); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 122, RULE_nonparenthesized_value_expression_primary);
		try {
			setState(1407);
			switch ( getInterpreter().adaptivePredict(_input,179,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1400); unsigned_value_specification();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1401); column_reference();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1402); set_function_specification();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1403); scalar_subquery();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1404); case_expression();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1405); cast_specification();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1406); routine_invocation();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 124, RULE_unsigned_value_specification);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1409); unsigned_literal();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 126, RULE_unsigned_numeric_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1411);
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
		enterRule(_localctx, 128, RULE_signed_numerical_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1414);
			_la = _input.LA(1);
			if (_la==PLUS || _la==MINUS) {
				{
				setState(1413); sign();
				}
			}

			setState(1416); unsigned_numeric_literal();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 130, RULE_set_function_specification);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1418); aggregate_function();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 132, RULE_aggregate_function);
		try {
			setState(1428);
			switch ( getInterpreter().adaptivePredict(_input,182,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1420); match(COUNT);
				setState(1421); match(LEFT_PAREN);
				setState(1422); match(MULTIPLY);
				setState(1423); match(RIGHT_PAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1424); general_set_function();
				setState(1426);
				switch ( getInterpreter().adaptivePredict(_input,181,_ctx) ) {
				case 1:
					{
					setState(1425); filter_clause();
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
		enterRule(_localctx, 134, RULE_general_set_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1430); set_function_type();
			setState(1431); match(LEFT_PAREN);
			setState(1433);
			_la = _input.LA(1);
			if (_la==ALL || _la==DISTINCT) {
				{
				setState(1432); set_qualifier();
				}
			}

			setState(1435); value_expression();
			setState(1436); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 136, RULE_set_function_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1438);
			_la = _input.LA(1);
			if ( !(_la==ANY || ((((_la - 76)) & ~0x3f) == 0 && ((1L << (_la - 76)) & ((1L << (SOME - 76)) | (1L << (AVG - 76)) | (1L << (COLLECT - 76)) | (1L << (COUNT - 76)) | (1L << (EVERY - 76)) | (1L << (FUSION - 76)) | (1L << (INTERSECTION - 76)) | (1L << (MAX - 76)))) != 0) || ((((_la - 142)) & ~0x3f) == 0 && ((1L << (_la - 142)) & ((1L << (MIN - 142)) | (1L << (STDDEV_POP - 142)) | (1L << (STDDEV_SAMP - 142)) | (1L << (SUM - 142)) | (1L << (VAR_SAMP - 142)) | (1L << (VAR_POP - 142)))) != 0)) ) {
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
		enterRule(_localctx, 138, RULE_filter_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1440); match(FILTER);
			setState(1441); match(LEFT_PAREN);
			setState(1442); match(WHERE);
			setState(1443); search_condition();
			setState(1444); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 140, RULE_grouping_operation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1446); match(GROUPING);
			setState(1447); match(LEFT_PAREN);
			setState(1448); column_reference_list();
			setState(1449); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 142, RULE_case_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1451); case_specification();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 144, RULE_case_abbreviation);
		int _la;
		try {
			setState(1471);
			switch (_input.LA(1)) {
			case NULLIF:
				enterOuterAlt(_localctx, 1);
				{
				setState(1453); match(NULLIF);
				setState(1454); match(LEFT_PAREN);
				setState(1455); numeric_value_expression();
				setState(1456); match(COMMA);
				setState(1457); boolean_value_expression();
				setState(1458); match(RIGHT_PAREN);
				}
				break;
			case COALESCE:
				enterOuterAlt(_localctx, 2);
				{
				setState(1460); match(COALESCE);
				setState(1461); match(LEFT_PAREN);
				setState(1462); numeric_value_expression();
				setState(1465); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1463); match(COMMA);
					setState(1464); boolean_value_expression();
					}
					}
					setState(1467); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==COMMA );
				setState(1469); match(RIGHT_PAREN);
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
		enterRule(_localctx, 146, RULE_case_specification);
		try {
			setState(1475);
			switch ( getInterpreter().adaptivePredict(_input,186,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1473); simple_case();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1474); searched_case();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 148, RULE_simple_case);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1477); match(CASE);
			setState(1478); boolean_value_expression();
			setState(1480); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1479); simple_when_clause();
				}
				}
				setState(1482); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WHEN );
			setState(1485);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(1484); else_clause();
				}
			}

			setState(1487); match(END);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 150, RULE_searched_case);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1489); match(CASE);
			setState(1491); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1490); searched_when_clause();
				}
				}
				setState(1493); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WHEN );
			setState(1496);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(1495); else_clause();
				}
			}

			setState(1498); match(END);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 152, RULE_simple_when_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1500); match(WHEN);
			setState(1501); search_condition();
			setState(1502); match(THEN);
			setState(1503); result();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 154, RULE_searched_when_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1505); match(WHEN);
			setState(1506); ((Searched_when_clauseContext)_localctx).c = search_condition();
			setState(1507); match(THEN);
			setState(1508); ((Searched_when_clauseContext)_localctx).r = result();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 156, RULE_else_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1510); match(ELSE);
			setState(1511); ((Else_clauseContext)_localctx).r = result();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 158, RULE_result);
		try {
			setState(1515);
			switch ( getInterpreter().adaptivePredict(_input,191,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1513); value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1514); match(NULL);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 160, RULE_cast_specification);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1517); match(CAST);
			setState(1518); match(LEFT_PAREN);
			setState(1519); cast_operand();
			setState(1520); match(AS);
			setState(1521); cast_target();
			setState(1522); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 162, RULE_cast_operand);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1524); value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 164, RULE_cast_target);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1526); data_type();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 166, RULE_value_expression);
		try {
			setState(1531);
			switch ( getInterpreter().adaptivePredict(_input,192,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1528); common_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1529); row_value_expression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1530); boolean_value_expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 168, RULE_common_value_expression);
		try {
			setState(1536);
			switch ( getInterpreter().adaptivePredict(_input,193,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1533); numeric_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1534); string_value_expression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1535); match(NULL);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 170, RULE_numeric_value_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1538); ((Numeric_value_expressionContext)_localctx).left = term();
			setState(1543);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				{
				setState(1539);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(1540); ((Numeric_value_expressionContext)_localctx).right = term();
				}
				}
				setState(1545);
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
		enterRule(_localctx, 172, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1546); ((TermContext)_localctx).left = factor();
			setState(1551);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 241)) & ~0x3f) == 0 && ((1L << (_la - 241)) & ((1L << (MULTIPLY - 241)) | (1L << (DIVIDE - 241)) | (1L << (MODULAR - 241)))) != 0)) {
				{
				{
				setState(1547);
				_la = _input.LA(1);
				if ( !(((((_la - 241)) & ~0x3f) == 0 && ((1L << (_la - 241)) & ((1L << (MULTIPLY - 241)) | (1L << (DIVIDE - 241)) | (1L << (MODULAR - 241)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(1548); ((TermContext)_localctx).right = factor();
				}
				}
				setState(1553);
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
		enterRule(_localctx, 174, RULE_factor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1555);
			_la = _input.LA(1);
			if (_la==PLUS || _la==MINUS) {
				{
				setState(1554); sign();
				}
			}

			setState(1557); numeric_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 176, RULE_array);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1559); match(LEFT_PAREN);
			setState(1560); numeric_value_expression();
			setState(1565);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1561); match(COMMA);
				setState(1562); numeric_value_expression();
				}
				}
				setState(1567);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1568); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 178, RULE_numeric_primary);
		int _la;
		try {
			setState(1579);
			switch ( getInterpreter().adaptivePredict(_input,199,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1570); value_expression_primary();
				setState(1575);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CAST_EXPRESSION) {
					{
					{
					setState(1571); match(CAST_EXPRESSION);
					setState(1572); cast_target();
					}
					}
					setState(1577);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1578); numeric_value_function();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 180, RULE_sign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1581);
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
		enterRule(_localctx, 182, RULE_numeric_value_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1583); extract_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 184, RULE_extract_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1585); match(EXTRACT);
			setState(1586); match(LEFT_PAREN);
			setState(1587); ((Extract_expressionContext)_localctx).extract_field_string = extract_field();
			setState(1588); match(FROM);
			setState(1589); extract_source();
			setState(1590); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 186, RULE_extract_field);
		try {
			setState(1595);
			switch (_input.LA(1)) {
			case DAY:
			case HOUR:
			case MINUTE:
			case MONTH:
			case SECOND:
			case YEAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(1592); primary_datetime_field();
				}
				break;
			case TIMEZONE:
			case TIMEZONE_HOUR:
			case TIMEZONE_MINUTE:
				enterOuterAlt(_localctx, 2);
				{
				setState(1593); time_zone_field();
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
				setState(1594); extended_datetime_field();
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
		enterRule(_localctx, 188, RULE_time_zone_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1597);
			_la = _input.LA(1);
			if ( !(((((_la - 171)) & ~0x3f) == 0 && ((1L << (_la - 171)) & ((1L << (TIMEZONE - 171)) | (1L << (TIMEZONE_HOUR - 171)) | (1L << (TIMEZONE_MINUTE - 171)))) != 0)) ) {
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
		enterRule(_localctx, 190, RULE_extract_source);
		try {
			setState(1601);
			switch ( getInterpreter().adaptivePredict(_input,201,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1599); column_reference();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1600); datetime_literal();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 192, RULE_string_value_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1603); character_value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 194, RULE_character_value_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1605); character_factor();
			setState(1610);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CONCATENATION_OPERATOR) {
				{
				{
				setState(1606); match(CONCATENATION_OPERATOR);
				setState(1607); character_factor();
				}
				}
				setState(1612);
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
		enterRule(_localctx, 196, RULE_character_factor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1613); character_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 198, RULE_character_primary);
		try {
			setState(1617);
			switch ( getInterpreter().adaptivePredict(_input,203,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1615); value_expression_primary();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1616); string_value_function();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 200, RULE_string_value_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1619); trim_function();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 202, RULE_trim_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1621); match(TRIM);
			setState(1622); match(LEFT_PAREN);
			setState(1623); trim_operands();
			setState(1624); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 204, RULE_trim_operands);
		int _la;
		try {
			setState(1640);
			switch ( getInterpreter().adaptivePredict(_input,207,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1633);
				switch ( getInterpreter().adaptivePredict(_input,206,_ctx) ) {
				case 1:
					{
					setState(1627);
					_la = _input.LA(1);
					if (_la==BOTH || _la==LEADING || _la==TRAILING) {
						{
						setState(1626); trim_specification();
						}
					}

					setState(1630);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ANY) | (1L << CASE) | (1L << CAST) | (1L << FALSE) | (1L << LEFT))) != 0) || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (RIGHT - 70)) | (1L << (SOME - 70)) | (1L << (TRUE - 70)) | (1L << (ADMIN - 70)) | (1L << (AVG - 70)) | (1L << (BETWEEN - 70)) | (1L << (BY - 70)) | (1L << (CENTURY - 70)) | (1L << (CHARACTER - 70)) | (1L << (COLLECT - 70)) | (1L << (COALESCE - 70)) | (1L << (COLUMN - 70)) | (1L << (COUNT - 70)) | (1L << (CUBE - 70)) | (1L << (DATA - 70)) | (1L << (DAY - 70)) | (1L << (DEC - 70)) | (1L << (DECADE - 70)) | (1L << (DOW - 70)) | (1L << (DOY - 70)) | (1L << (DROP - 70)) | (1L << (EPOCH - 70)) | (1L << (EVERY - 70)) | (1L << (EXISTS - 70)) | (1L << (EXTERNAL - 70)) | (1L << (EXTRACT - 70)) | (1L << (FILTER - 70)) | (1L << (FIRST - 70)) | (1L << (FORMAT - 70)) | (1L << (FUSION - 70)) | (1L << (GROUPING - 70)) | (1L << (HASH - 70)) | (1L << (INDEX - 70)) | (1L << (INSERT - 70)) | (1L << (INTERSECTION - 70)) | (1L << (ISODOW - 70)) | (1L << (ISOYEAR - 70)) | (1L << (LANGUAGE - 70)) | (1L << (LARGE - 70)) | (1L << (LAST - 70)))) != 0) || ((((_la - 134)) & ~0x3f) == 0 && ((1L << (_la - 134)) & ((1L << (LESS - 134)) | (1L << (LIST - 134)) | (1L << (LOCATION - 134)) | (1L << (MAX - 134)) | (1L << (MAXVALUE - 134)) | (1L << (MICROSECONDS - 134)) | (1L << (MILLENNIUM - 134)) | (1L << (MILLISECONDS - 134)) | (1L << (MIN - 134)) | (1L << (MINUTE - 134)) | (1L << (MONTH - 134)) | (1L << (NATIONAL - 134)) | (1L << (NULLIF - 134)) | (1L << (OBJECT - 134)) | (1L << (OPTION - 134)) | (1L << (OVERWRITE - 134)) | (1L << (PARTITION - 134)) | (1L << (PARTITIONS - 134)) | (1L << (PRECISION - 134)) | (1L << (PUBLIC - 134)) | (1L << (PURGE - 134)) | (1L << (QUARTER - 134)) | (1L << (RANGE - 134)) | (1L << (REGEXP - 134)) | (1L << (RLIKE - 134)) | (1L << (ROLLUP - 134)) | (1L << (SECOND - 134)) | (1L << (SERVER - 134)) | (1L << (SET - 134)) | (1L << (SIMILAR - 134)) | (1L << (STDDEV_POP - 134)) | (1L << (STDDEV_SAMP - 134)) | (1L << (SUBPARTITION - 134)) | (1L << (SUM - 134)) | (1L << (TABLESPACE - 134)) | (1L << (THAN - 134)) | (1L << (TIMEZONE - 134)) | (1L << (TIMEZONE_HOUR - 134)) | (1L << (TIMEZONE_MINUTE - 134)) | (1L << (TRIM - 134)) | (1L << (TO - 134)) | (1L << (UNKNOWN - 134)) | (1L << (VALUES - 134)) | (1L << (VAR_SAMP - 134)) | (1L << (VAR_POP - 134)) | (1L << (VARYING - 134)) | (1L << (WEEK - 134)) | (1L << (WRAPPER - 134)) | (1L << (YEAR - 134)) | (1L << (ZONE - 134)) | (1L << (BOOLEAN - 134)) | (1L << (BOOL - 134)) | (1L << (BIT - 134)) | (1L << (VARBIT - 134)) | (1L << (INT1 - 134)) | (1L << (INT2 - 134)) | (1L << (INT4 - 134)) | (1L << (INT8 - 134)) | (1L << (TINYINT - 134)) | (1L << (SMALLINT - 134)) | (1L << (INT - 134)) | (1L << (INTEGER - 134)))) != 0) || ((((_la - 198)) & ~0x3f) == 0 && ((1L << (_la - 198)) & ((1L << (BIGINT - 198)) | (1L << (FLOAT4 - 198)) | (1L << (FLOAT8 - 198)) | (1L << (REAL - 198)) | (1L << (FLOAT - 198)) | (1L << (DOUBLE - 198)) | (1L << (NUMERIC - 198)) | (1L << (DECIMAL - 198)) | (1L << (CHAR - 198)) | (1L << (VARCHAR - 198)) | (1L << (NCHAR - 198)) | (1L << (NVARCHAR - 198)) | (1L << (DATE - 198)) | (1L << (TIME - 198)) | (1L << (TIMETZ - 198)) | (1L << (TIMESTAMP - 198)) | (1L << (TIMESTAMPTZ - 198)) | (1L << (TEXT - 198)) | (1L << (VARBINARY - 198)) | (1L << (BLOB - 198)) | (1L << (BYTEA - 198)) | (1L << (INET4 - 198)) | (1L << (LEFT_PAREN - 198)) | (1L << (NUMBER - 198)) | (1L << (REAL_NUMBER - 198)) | (1L << (Identifier - 198)) | (1L << (Character_String_Literal - 198)))) != 0)) {
						{
						setState(1629); ((Trim_operandsContext)_localctx).trim_character = character_value_expression();
						}
					}

					setState(1632); match(FROM);
					}
					break;
				}
				setState(1635); ((Trim_operandsContext)_localctx).trim_source = character_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1636); ((Trim_operandsContext)_localctx).trim_source = character_value_expression();
				setState(1637); match(COMMA);
				setState(1638); ((Trim_operandsContext)_localctx).trim_character = character_value_expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 206, RULE_trim_specification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1642);
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
		enterRule(_localctx, 208, RULE_boolean_value_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1644); or_predicate();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 210, RULE_or_predicate);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1646); and_predicate();
			setState(1651);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,208,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1647); match(OR);
					setState(1648); or_predicate();
					}
					} 
				}
				setState(1653);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,208,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 212, RULE_and_predicate);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1654); boolean_factor();
			setState(1659);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,209,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1655); match(AND);
					setState(1656); and_predicate();
					}
					} 
				}
				setState(1661);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,209,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 214, RULE_boolean_factor);
		try {
			setState(1665);
			switch ( getInterpreter().adaptivePredict(_input,210,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1662); boolean_test();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1663); match(NOT);
				setState(1664); boolean_test();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 216, RULE_boolean_test);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1667); boolean_primary();
			setState(1669);
			_la = _input.LA(1);
			if (_la==IS) {
				{
				setState(1668); is_clause();
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
		enterRule(_localctx, 218, RULE_is_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1671); match(IS);
			setState(1673);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(1672); match(NOT);
				}
			}

			setState(1675); ((Is_clauseContext)_localctx).t = truth_value();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 220, RULE_truth_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1677);
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
		enterRule(_localctx, 222, RULE_boolean_primary);
		try {
			setState(1681);
			switch ( getInterpreter().adaptivePredict(_input,213,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1679); predicate();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1680); boolean_predicand();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 224, RULE_boolean_predicand);
		try {
			setState(1685);
			switch ( getInterpreter().adaptivePredict(_input,214,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1683); parenthesized_boolean_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1684); nonparenthesized_value_expression_primary();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 226, RULE_parenthesized_boolean_value_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1687); match(LEFT_PAREN);
			setState(1688); boolean_value_expression();
			setState(1689); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 228, RULE_row_value_expression);
		try {
			setState(1693);
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
			case CENTURY:
			case CHARACTER:
			case COLLECT:
			case COALESCE:
			case COLUMN:
			case COUNT:
			case CUBE:
			case DATA:
			case DAY:
			case DEC:
			case DECADE:
			case DOW:
			case DOY:
			case DROP:
			case EPOCH:
			case EVERY:
			case EXISTS:
			case EXTERNAL:
			case EXTRACT:
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
			case OVERWRITE:
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
			case SECOND:
			case SERVER:
			case SET:
			case SIMILAR:
			case STDDEV_POP:
			case STDDEV_SAMP:
			case SUBPARTITION:
			case SUM:
			case TABLESPACE:
			case THAN:
			case TIMEZONE:
			case TIMEZONE_HOUR:
			case TIMEZONE_MINUTE:
			case TRIM:
			case TO:
			case UNKNOWN:
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
			case NUMBER:
			case REAL_NUMBER:
			case Identifier:
			case Character_String_Literal:
				enterOuterAlt(_localctx, 1);
				{
				setState(1691); row_value_special_case();
				}
				break;
			case NULL:
				enterOuterAlt(_localctx, 2);
				{
				setState(1692); explicit_row_value_constructor();
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
		enterRule(_localctx, 230, RULE_row_value_special_case);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1695); nonparenthesized_value_expression_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 232, RULE_explicit_row_value_constructor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1697); match(NULL);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 234, RULE_row_value_predicand);
		try {
			setState(1701);
			switch ( getInterpreter().adaptivePredict(_input,216,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1699); row_value_special_case();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1700); row_value_constructor_predicand();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 236, RULE_row_value_constructor_predicand);
		try {
			setState(1705);
			switch ( getInterpreter().adaptivePredict(_input,217,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1703); common_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1704); boolean_predicand();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 238, RULE_table_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1707); from_clause();
			setState(1709);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(1708); where_clause();
				}
			}

			setState(1712);
			_la = _input.LA(1);
			if (_la==GROUP) {
				{
				setState(1711); groupby_clause();
				}
			}

			setState(1715);
			_la = _input.LA(1);
			if (_la==HAVING) {
				{
				setState(1714); having_clause();
				}
			}

			setState(1718);
			_la = _input.LA(1);
			if (_la==ORDER) {
				{
				setState(1717); orderby_clause();
				}
			}

			setState(1721);
			_la = _input.LA(1);
			if (_la==LIMIT) {
				{
				setState(1720); limit_clause();
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
		enterRule(_localctx, 240, RULE_from_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1723); match(FROM);
			setState(1724); table_reference_list();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 242, RULE_table_reference_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1726); table_reference();
			setState(1731);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1727); match(COMMA);
				setState(1728); table_reference();
				}
				}
				setState(1733);
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
		enterRule(_localctx, 244, RULE_table_reference);
		try {
			setState(1736);
			switch ( getInterpreter().adaptivePredict(_input,224,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1734); joined_table();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1735); table_primary();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 246, RULE_joined_table);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1738); table_primary();
			setState(1740); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(1739); joined_table_primary();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1742); 
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
		enterRule(_localctx, 248, RULE_joined_table_primary);
		int _la;
		try {
			setState(1763);
			switch (_input.LA(1)) {
			case CROSS:
				enterOuterAlt(_localctx, 1);
				{
				setState(1744); match(CROSS);
				setState(1745); match(JOIN);
				setState(1746); ((Joined_table_primaryContext)_localctx).right = table_primary();
				}
				break;
			case FULL:
			case INNER:
			case JOIN:
			case LEFT:
			case RIGHT:
				enterOuterAlt(_localctx, 2);
				{
				setState(1748);
				_la = _input.LA(1);
				if (((((_la - 32)) & ~0x3f) == 0 && ((1L << (_la - 32)) & ((1L << (FULL - 32)) | (1L << (INNER - 32)) | (1L << (LEFT - 32)) | (1L << (RIGHT - 32)))) != 0)) {
					{
					setState(1747); ((Joined_table_primaryContext)_localctx).t = join_type();
					}
				}

				setState(1750); match(JOIN);
				setState(1751); ((Joined_table_primaryContext)_localctx).right = table_primary();
				setState(1752); ((Joined_table_primaryContext)_localctx).s = join_specification();
				}
				break;
			case NATURAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(1754); match(NATURAL);
				setState(1756);
				_la = _input.LA(1);
				if (((((_la - 32)) & ~0x3f) == 0 && ((1L << (_la - 32)) & ((1L << (FULL - 32)) | (1L << (INNER - 32)) | (1L << (LEFT - 32)) | (1L << (RIGHT - 32)))) != 0)) {
					{
					setState(1755); ((Joined_table_primaryContext)_localctx).t = join_type();
					}
				}

				setState(1758); match(JOIN);
				setState(1759); ((Joined_table_primaryContext)_localctx).right = table_primary();
				}
				break;
			case UNION:
				enterOuterAlt(_localctx, 4);
				{
				setState(1760); match(UNION);
				setState(1761); match(JOIN);
				setState(1762); ((Joined_table_primaryContext)_localctx).right = table_primary();
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
		enterRule(_localctx, 250, RULE_cross_join);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1765); match(CROSS);
			setState(1766); match(JOIN);
			setState(1767); ((Cross_joinContext)_localctx).r = table_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 252, RULE_qualified_join);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1770);
			_la = _input.LA(1);
			if (((((_la - 32)) & ~0x3f) == 0 && ((1L << (_la - 32)) & ((1L << (FULL - 32)) | (1L << (INNER - 32)) | (1L << (LEFT - 32)) | (1L << (RIGHT - 32)))) != 0)) {
				{
				setState(1769); ((Qualified_joinContext)_localctx).t = join_type();
				}
			}

			setState(1772); match(JOIN);
			setState(1773); ((Qualified_joinContext)_localctx).r = table_primary();
			setState(1774); ((Qualified_joinContext)_localctx).s = join_specification();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 254, RULE_natural_join);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1776); match(NATURAL);
			setState(1778);
			_la = _input.LA(1);
			if (((((_la - 32)) & ~0x3f) == 0 && ((1L << (_la - 32)) & ((1L << (FULL - 32)) | (1L << (INNER - 32)) | (1L << (LEFT - 32)) | (1L << (RIGHT - 32)))) != 0)) {
				{
				setState(1777); ((Natural_joinContext)_localctx).t = join_type();
				}
			}

			setState(1780); match(JOIN);
			setState(1781); ((Natural_joinContext)_localctx).r = table_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 256, RULE_union_join);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1783); match(UNION);
			setState(1784); match(JOIN);
			setState(1785); ((Union_joinContext)_localctx).r = table_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 258, RULE_join_type);
		try {
			setState(1789);
			switch (_input.LA(1)) {
			case INNER:
				enterOuterAlt(_localctx, 1);
				{
				setState(1787); match(INNER);
				}
				break;
			case FULL:
			case LEFT:
			case RIGHT:
				enterOuterAlt(_localctx, 2);
				{
				setState(1788); ((Join_typeContext)_localctx).t = outer_join_type();
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
		enterRule(_localctx, 260, RULE_outer_join_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1791); outer_join_type_part2();
			setState(1793);
			_la = _input.LA(1);
			if (_la==OUTER) {
				{
				setState(1792); match(OUTER);
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
		enterRule(_localctx, 262, RULE_outer_join_type_part2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1795);
			_la = _input.LA(1);
			if ( !(((((_la - 32)) & ~0x3f) == 0 && ((1L << (_la - 32)) & ((1L << (FULL - 32)) | (1L << (LEFT - 32)) | (1L << (RIGHT - 32)))) != 0)) ) {
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
		enterRule(_localctx, 264, RULE_join_specification);
		try {
			setState(1799);
			switch (_input.LA(1)) {
			case ON:
				enterOuterAlt(_localctx, 1);
				{
				setState(1797); join_condition();
				}
				break;
			case USING:
				enterOuterAlt(_localctx, 2);
				{
				setState(1798); named_columns_join();
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
		enterRule(_localctx, 266, RULE_join_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1801); match(ON);
			setState(1802); search_condition();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 268, RULE_named_columns_join);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1804); match(USING);
			setState(1805); match(LEFT_PAREN);
			setState(1806); ((Named_columns_joinContext)_localctx).f = column_reference_list();
			setState(1807); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 270, RULE_table_primary);
		int _la;
		try {
			setState(1833);
			switch (_input.LA(1)) {
			case ADMIN:
			case AVG:
			case BETWEEN:
			case BY:
			case CENTURY:
			case CHARACTER:
			case COLLECT:
			case COALESCE:
			case COLUMN:
			case COUNT:
			case CUBE:
			case DATA:
			case DAY:
			case DEC:
			case DECADE:
			case DOW:
			case DOY:
			case DROP:
			case EPOCH:
			case EVERY:
			case EXISTS:
			case EXTERNAL:
			case EXTRACT:
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
			case OVERWRITE:
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
			case SECOND:
			case SERVER:
			case SET:
			case SIMILAR:
			case STDDEV_POP:
			case STDDEV_SAMP:
			case SUBPARTITION:
			case SUM:
			case TABLESPACE:
			case THAN:
			case TIMEZONE:
			case TIMEZONE_HOUR:
			case TIMEZONE_MINUTE:
			case TRIM:
			case TO:
			case UNKNOWN:
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
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(1809); table_or_query_name();
				setState(1814);
				switch ( getInterpreter().adaptivePredict(_input,235,_ctx) ) {
				case 1:
					{
					setState(1811);
					_la = _input.LA(1);
					if (_la==AS) {
						{
						setState(1810); match(AS);
						}
					}

					setState(1813); ((Table_primaryContext)_localctx).alias = identifier();
					}
					break;
				}
				setState(1820);
				switch ( getInterpreter().adaptivePredict(_input,236,_ctx) ) {
				case 1:
					{
					setState(1816); match(LEFT_PAREN);
					setState(1817); column_name_list();
					setState(1818); match(RIGHT_PAREN);
					}
					break;
				}
				}
				break;
			case LEFT_PAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(1822); derived_table();
				setState(1824);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(1823); match(AS);
					}
				}

				setState(1826); ((Table_primaryContext)_localctx).name = identifier();
				setState(1831);
				switch ( getInterpreter().adaptivePredict(_input,238,_ctx) ) {
				case 1:
					{
					setState(1827); match(LEFT_PAREN);
					setState(1828); column_name_list();
					setState(1829); match(RIGHT_PAREN);
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
		enterRule(_localctx, 272, RULE_column_name_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1835); identifier();
			setState(1840);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1836); match(COMMA);
				setState(1837); identifier();
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
		enterRule(_localctx, 274, RULE_derived_table);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1843); table_subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 276, RULE_where_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1845); match(WHERE);
			setState(1846); search_condition();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 278, RULE_search_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1848); value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 280, RULE_groupby_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1850); match(GROUP);
			setState(1851); match(BY);
			setState(1852); ((Groupby_clauseContext)_localctx).g = grouping_element_list();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 282, RULE_grouping_element_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1854); grouping_element();
			setState(1859);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1855); match(COMMA);
				setState(1856); grouping_element();
				}
				}
				setState(1861);
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
		enterRule(_localctx, 284, RULE_grouping_element);
		try {
			setState(1866);
			switch ( getInterpreter().adaptivePredict(_input,242,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1862); rollup_list();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1863); cube_list();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1864); empty_grouping_set();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1865); ordinary_grouping_set();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 286, RULE_ordinary_grouping_set);
		try {
			setState(1873);
			switch ( getInterpreter().adaptivePredict(_input,243,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1868); row_value_predicand();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1869); match(LEFT_PAREN);
				setState(1870); row_value_predicand_list();
				setState(1871); match(RIGHT_PAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 288, RULE_ordinary_grouping_set_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1875); ordinary_grouping_set();
			setState(1880);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1876); match(COMMA);
				setState(1877); ordinary_grouping_set();
				}
				}
				setState(1882);
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
		enterRule(_localctx, 290, RULE_rollup_list);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1883); match(ROLLUP);
			setState(1884); match(LEFT_PAREN);
			setState(1885); ((Rollup_listContext)_localctx).c = ordinary_grouping_set_list();
			setState(1886); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 292, RULE_cube_list);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1888); match(CUBE);
			setState(1889); match(LEFT_PAREN);
			setState(1890); ((Cube_listContext)_localctx).c = ordinary_grouping_set_list();
			setState(1891); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 294, RULE_empty_grouping_set);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1893); match(LEFT_PAREN);
			setState(1894); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 296, RULE_having_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1896); match(HAVING);
			setState(1897); boolean_value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 298, RULE_row_value_predicand_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1899); row_value_predicand();
			setState(1904);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1900); match(COMMA);
				setState(1901); row_value_predicand();
				}
				}
				setState(1906);
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
		enterRule(_localctx, 300, RULE_query_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1907); query_expression_body();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 302, RULE_query_expression_body);
		try {
			setState(1911);
			switch ( getInterpreter().adaptivePredict(_input,246,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1909); non_join_query_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1910); joined_table();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 304, RULE_non_join_query_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1921);
			switch ( getInterpreter().adaptivePredict(_input,248,_ctx) ) {
			case 1:
				{
				setState(1913); non_join_query_term();
				}
				break;
			case 2:
				{
				setState(1914); joined_table();
				setState(1915);
				_la = _input.LA(1);
				if ( !(_la==EXCEPT || _la==UNION) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(1917);
				_la = _input.LA(1);
				if (_la==ALL || _la==DISTINCT) {
					{
					setState(1916);
					_la = _input.LA(1);
					if ( !(_la==ALL || _la==DISTINCT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(1919); query_term();
				}
				break;
			}
			setState(1930);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==EXCEPT || _la==UNION) {
				{
				{
				setState(1923);
				_la = _input.LA(1);
				if ( !(_la==EXCEPT || _la==UNION) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(1925);
				_la = _input.LA(1);
				if (_la==ALL || _la==DISTINCT) {
					{
					setState(1924);
					_la = _input.LA(1);
					if ( !(_la==ALL || _la==DISTINCT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(1927); query_term();
				}
				}
				setState(1932);
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
		enterRule(_localctx, 306, RULE_query_term);
		try {
			setState(1935);
			switch ( getInterpreter().adaptivePredict(_input,251,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1933); non_join_query_term();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1934); joined_table();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 308, RULE_non_join_query_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1945);
			switch ( getInterpreter().adaptivePredict(_input,253,_ctx) ) {
			case 1:
				{
				setState(1937); non_join_query_primary();
				}
				break;
			case 2:
				{
				setState(1938); joined_table();
				setState(1939); match(INTERSECT);
				setState(1941);
				_la = _input.LA(1);
				if (_la==ALL || _la==DISTINCT) {
					{
					setState(1940);
					_la = _input.LA(1);
					if ( !(_la==ALL || _la==DISTINCT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(1943); query_primary();
				}
				break;
			}
			setState(1954);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==INTERSECT) {
				{
				{
				setState(1947); match(INTERSECT);
				setState(1949);
				_la = _input.LA(1);
				if (_la==ALL || _la==DISTINCT) {
					{
					setState(1948);
					_la = _input.LA(1);
					if ( !(_la==ALL || _la==DISTINCT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(1951); query_primary();
				}
				}
				setState(1956);
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
		enterRule(_localctx, 310, RULE_query_primary);
		try {
			setState(1959);
			switch ( getInterpreter().adaptivePredict(_input,256,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1957); non_join_query_primary();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1958); joined_table();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 312, RULE_non_join_query_primary);
		try {
			setState(1966);
			switch (_input.LA(1)) {
			case SELECT:
			case TABLE:
				enterOuterAlt(_localctx, 1);
				{
				setState(1961); simple_table();
				}
				break;
			case LEFT_PAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(1962); match(LEFT_PAREN);
				setState(1963); non_join_query_expression();
				setState(1964); match(RIGHT_PAREN);
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
		enterRule(_localctx, 314, RULE_simple_table);
		try {
			setState(1970);
			switch (_input.LA(1)) {
			case SELECT:
				enterOuterAlt(_localctx, 1);
				{
				setState(1968); query_specification();
				}
				break;
			case TABLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(1969); explicit_table();
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
		enterRule(_localctx, 316, RULE_explicit_table);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1972); match(TABLE);
			setState(1973); table_or_query_name();
			}
		}
		catch (RecognitionException re) {
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
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
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
		enterRule(_localctx, 318, RULE_table_or_query_name);
		try {
			setState(1977);
			switch ( getInterpreter().adaptivePredict(_input,259,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1975); table_name();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1976); identifier();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Table_nameContext extends ParserRuleContext {
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
		public Table_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterTable_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitTable_name(this);
		}
	}

	public final Table_nameContext table_name() throws RecognitionException {
		Table_nameContext _localctx = new Table_nameContext(_ctx, getState());
		enterRule(_localctx, 320, RULE_table_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1979); identifier();
			setState(1986);
			_la = _input.LA(1);
			if (_la==DOT) {
				{
				setState(1980); match(DOT);
				setState(1981); identifier();
				setState(1984);
				_la = _input.LA(1);
				if (_la==DOT) {
					{
					setState(1982); match(DOT);
					setState(1983); identifier();
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
		enterRule(_localctx, 322, RULE_query_specification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1988); match(SELECT);
			setState(1990);
			_la = _input.LA(1);
			if (_la==ALL || _la==DISTINCT) {
				{
				setState(1989); set_qualifier();
				}
			}

			setState(1992); select_list();
			setState(1994);
			_la = _input.LA(1);
			if (_la==FROM) {
				{
				setState(1993); table_expression();
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
		enterRule(_localctx, 324, RULE_select_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1996); select_sublist();
			setState(2001);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1997); match(COMMA);
				setState(1998); select_sublist();
				}
				}
				setState(2003);
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
		enterRule(_localctx, 326, RULE_select_sublist);
		try {
			setState(2006);
			switch ( getInterpreter().adaptivePredict(_input,265,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2004); derived_column();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2005); qualified_asterisk();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 328, RULE_derived_column);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2008); value_expression();
			setState(2010);
			switch ( getInterpreter().adaptivePredict(_input,266,_ctx) ) {
			case 1:
				{
				setState(2009); as_clause();
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
		enterRule(_localctx, 330, RULE_qualified_asterisk);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2014);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(2012); ((Qualified_asteriskContext)_localctx).tb_name = match(Identifier);
				setState(2013); match(DOT);
				}
			}

			setState(2016); match(MULTIPLY);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 332, RULE_set_qualifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2018);
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
		enterRule(_localctx, 334, RULE_column_reference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2023);
			switch ( getInterpreter().adaptivePredict(_input,268,_ctx) ) {
			case 1:
				{
				setState(2020); ((Column_referenceContext)_localctx).tb_name = identifier();
				setState(2021); match(DOT);
				}
				break;
			}
			setState(2025); ((Column_referenceContext)_localctx).name = identifier();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 336, RULE_as_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2028);
			_la = _input.LA(1);
			if (_la==AS) {
				{
				setState(2027); match(AS);
				}
			}

			setState(2030); identifier();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 338, RULE_column_reference_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2032); column_reference();
			setState(2037);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2033); match(COMMA);
				setState(2034); column_reference();
				}
				}
				setState(2039);
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
		enterRule(_localctx, 340, RULE_scalar_subquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2040); subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 342, RULE_row_subquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2042); subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 344, RULE_table_subquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2044); subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 346, RULE_subquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2046); match(LEFT_PAREN);
			setState(2047); query_expression();
			setState(2048); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 348, RULE_predicate);
		try {
			setState(2056);
			switch ( getInterpreter().adaptivePredict(_input,271,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2050); comparison_predicate();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2051); between_predicate();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2052); in_predicate();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2053); pattern_matching_predicate();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2054); null_predicate();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2055); exists_predicate();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 350, RULE_comparison_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2058); ((Comparison_predicateContext)_localctx).left = row_value_predicand();
			setState(2059); ((Comparison_predicateContext)_localctx).c = comp_op();
			setState(2060); ((Comparison_predicateContext)_localctx).right = row_value_predicand();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 352, RULE_comp_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2062);
			_la = _input.LA(1);
			if ( !(((((_la - 227)) & ~0x3f) == 0 && ((1L << (_la - 227)) & ((1L << (EQUAL - 227)) | (1L << (NOT_EQUAL - 227)) | (1L << (LTH - 227)) | (1L << (LEQ - 227)) | (1L << (GTH - 227)) | (1L << (GEQ - 227)))) != 0)) ) {
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
		enterRule(_localctx, 354, RULE_between_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2064); ((Between_predicateContext)_localctx).predicand = row_value_predicand();
			setState(2065); between_predicate_part_2();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 356, RULE_between_predicate_part_2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2068);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(2067); match(NOT);
				}
			}

			setState(2070); match(BETWEEN);
			setState(2072);
			_la = _input.LA(1);
			if (_la==ASYMMETRIC || _la==SYMMETRIC) {
				{
				setState(2071);
				_la = _input.LA(1);
				if ( !(_la==ASYMMETRIC || _la==SYMMETRIC) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(2074); ((Between_predicate_part_2Context)_localctx).begin = row_value_predicand();
			setState(2075); match(AND);
			setState(2076); ((Between_predicate_part_2Context)_localctx).end = row_value_predicand();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 358, RULE_in_predicate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2078); ((In_predicateContext)_localctx).predicand = numeric_value_expression();
			setState(2080);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(2079); match(NOT);
				}
			}

			setState(2082); match(IN);
			setState(2083); in_predicate_value();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 360, RULE_in_predicate_value);
		try {
			setState(2090);
			switch ( getInterpreter().adaptivePredict(_input,275,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2085); table_subquery();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2086); match(LEFT_PAREN);
				setState(2087); in_value_list();
				setState(2088); match(RIGHT_PAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 362, RULE_in_value_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2092); row_value_expression();
			setState(2097);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2093); match(COMMA);
				setState(2094); row_value_expression();
				}
				}
				setState(2099);
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
		enterRule(_localctx, 364, RULE_pattern_matching_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2100); ((Pattern_matching_predicateContext)_localctx).f = row_value_predicand();
			setState(2101); pattern_matcher();
			setState(2102); ((Pattern_matching_predicateContext)_localctx).s = match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 366, RULE_pattern_matcher);
		int _la;
		try {
			setState(2109);
			switch (_input.LA(1)) {
			case ILIKE:
			case LIKE:
			case NOT:
			case REGEXP:
			case RLIKE:
			case SIMILAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(2105);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(2104); match(NOT);
					}
				}

				setState(2107); negativable_matcher();
				}
				break;
			case Similar_To:
			case Not_Similar_To:
			case Similar_To_Case_Insensitive:
			case Not_Similar_To_Case_Insensitive:
				enterOuterAlt(_localctx, 2);
				{
				setState(2108); regex_matcher();
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
		enterRule(_localctx, 368, RULE_negativable_matcher);
		try {
			setState(2117);
			switch (_input.LA(1)) {
			case LIKE:
				enterOuterAlt(_localctx, 1);
				{
				setState(2111); match(LIKE);
				}
				break;
			case ILIKE:
				enterOuterAlt(_localctx, 2);
				{
				setState(2112); match(ILIKE);
				}
				break;
			case SIMILAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(2113); match(SIMILAR);
				setState(2114); match(TO);
				}
				break;
			case REGEXP:
				enterOuterAlt(_localctx, 4);
				{
				setState(2115); match(REGEXP);
				}
				break;
			case RLIKE:
				enterOuterAlt(_localctx, 5);
				{
				setState(2116); match(RLIKE);
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
		enterRule(_localctx, 370, RULE_regex_matcher);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2119);
			_la = _input.LA(1);
			if ( !(((((_la - 221)) & ~0x3f) == 0 && ((1L << (_la - 221)) & ((1L << (Similar_To - 221)) | (1L << (Not_Similar_To - 221)) | (1L << (Similar_To_Case_Insensitive - 221)) | (1L << (Not_Similar_To_Case_Insensitive - 221)))) != 0)) ) {
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
		enterRule(_localctx, 372, RULE_null_predicate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2121); ((Null_predicateContext)_localctx).predicand = row_value_predicand();
			setState(2122); match(IS);
			setState(2124);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(2123); ((Null_predicateContext)_localctx).n = match(NOT);
				}
			}

			setState(2126); match(NULL);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 374, RULE_quantified_comparison_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2128); ((Quantified_comparison_predicateContext)_localctx).l = numeric_value_expression();
			setState(2129); ((Quantified_comparison_predicateContext)_localctx).c = comp_op();
			setState(2130); ((Quantified_comparison_predicateContext)_localctx).q = quantifier();
			setState(2131); ((Quantified_comparison_predicateContext)_localctx).s = table_subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 376, RULE_quantifier);
		try {
			setState(2135);
			switch (_input.LA(1)) {
			case ALL:
				enterOuterAlt(_localctx, 1);
				{
				setState(2133); all();
				}
				break;
			case ANY:
			case SOME:
				enterOuterAlt(_localctx, 2);
				{
				setState(2134); some();
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
		enterRule(_localctx, 378, RULE_all);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2137); match(ALL);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 380, RULE_some);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2139);
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
		enterRule(_localctx, 382, RULE_exists_predicate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2142);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(2141); match(NOT);
				}
			}

			setState(2144); match(EXISTS);
			setState(2145); ((Exists_predicateContext)_localctx).s = table_subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 384, RULE_unique_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2147); match(UNIQUE);
			setState(2148); ((Unique_predicateContext)_localctx).s = table_subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 386, RULE_primary_datetime_field);
		try {
			setState(2152);
			switch (_input.LA(1)) {
			case DAY:
			case HOUR:
			case MINUTE:
			case MONTH:
			case YEAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(2150); non_second_primary_datetime_field();
				}
				break;
			case SECOND:
				enterOuterAlt(_localctx, 2);
				{
				setState(2151); match(SECOND);
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
		enterRule(_localctx, 388, RULE_non_second_primary_datetime_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2154);
			_la = _input.LA(1);
			if ( !(((((_la - 108)) & ~0x3f) == 0 && ((1L << (_la - 108)) & ((1L << (DAY - 108)) | (1L << (HOUR - 108)) | (1L << (MINUTE - 108)) | (1L << (MONTH - 108)))) != 0) || _la==YEAR) ) {
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
		enterRule(_localctx, 390, RULE_extended_datetime_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2156);
			_la = _input.LA(1);
			if ( !(((((_la - 100)) & ~0x3f) == 0 && ((1L << (_la - 100)) & ((1L << (CENTURY - 100)) | (1L << (DECADE - 100)) | (1L << (DOW - 100)) | (1L << (DOY - 100)) | (1L << (EPOCH - 100)) | (1L << (ISODOW - 100)) | (1L << (ISOYEAR - 100)) | (1L << (MICROSECONDS - 100)) | (1L << (MILLENNIUM - 100)) | (1L << (MILLISECONDS - 100)) | (1L << (QUARTER - 100)))) != 0) || _la==WEEK) ) {
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
		enterRule(_localctx, 392, RULE_routine_invocation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2158); function_name();
			setState(2159); match(LEFT_PAREN);
			setState(2161);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ANY) | (1L << CASE) | (1L << CAST) | (1L << FALSE) | (1L << LEFT) | (1L << NOT) | (1L << NULL))) != 0) || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (RIGHT - 70)) | (1L << (SOME - 70)) | (1L << (TRUE - 70)) | (1L << (ADMIN - 70)) | (1L << (AVG - 70)) | (1L << (BETWEEN - 70)) | (1L << (BY - 70)) | (1L << (CENTURY - 70)) | (1L << (CHARACTER - 70)) | (1L << (COLLECT - 70)) | (1L << (COALESCE - 70)) | (1L << (COLUMN - 70)) | (1L << (COUNT - 70)) | (1L << (CUBE - 70)) | (1L << (DATA - 70)) | (1L << (DAY - 70)) | (1L << (DEC - 70)) | (1L << (DECADE - 70)) | (1L << (DOW - 70)) | (1L << (DOY - 70)) | (1L << (DROP - 70)) | (1L << (EPOCH - 70)) | (1L << (EVERY - 70)) | (1L << (EXISTS - 70)) | (1L << (EXTERNAL - 70)) | (1L << (EXTRACT - 70)) | (1L << (FILTER - 70)) | (1L << (FIRST - 70)) | (1L << (FORMAT - 70)) | (1L << (FUSION - 70)) | (1L << (GROUPING - 70)) | (1L << (HASH - 70)) | (1L << (INDEX - 70)) | (1L << (INSERT - 70)) | (1L << (INTERSECTION - 70)) | (1L << (ISODOW - 70)) | (1L << (ISOYEAR - 70)) | (1L << (LANGUAGE - 70)) | (1L << (LARGE - 70)) | (1L << (LAST - 70)))) != 0) || ((((_la - 134)) & ~0x3f) == 0 && ((1L << (_la - 134)) & ((1L << (LESS - 134)) | (1L << (LIST - 134)) | (1L << (LOCATION - 134)) | (1L << (MAX - 134)) | (1L << (MAXVALUE - 134)) | (1L << (MICROSECONDS - 134)) | (1L << (MILLENNIUM - 134)) | (1L << (MILLISECONDS - 134)) | (1L << (MIN - 134)) | (1L << (MINUTE - 134)) | (1L << (MONTH - 134)) | (1L << (NATIONAL - 134)) | (1L << (NULLIF - 134)) | (1L << (OBJECT - 134)) | (1L << (OPTION - 134)) | (1L << (OVERWRITE - 134)) | (1L << (PARTITION - 134)) | (1L << (PARTITIONS - 134)) | (1L << (PRECISION - 134)) | (1L << (PUBLIC - 134)) | (1L << (PURGE - 134)) | (1L << (QUARTER - 134)) | (1L << (RANGE - 134)) | (1L << (REGEXP - 134)) | (1L << (RLIKE - 134)) | (1L << (ROLLUP - 134)) | (1L << (SECOND - 134)) | (1L << (SERVER - 134)) | (1L << (SET - 134)) | (1L << (SIMILAR - 134)) | (1L << (STDDEV_POP - 134)) | (1L << (STDDEV_SAMP - 134)) | (1L << (SUBPARTITION - 134)) | (1L << (SUM - 134)) | (1L << (TABLESPACE - 134)) | (1L << (THAN - 134)) | (1L << (TIMEZONE - 134)) | (1L << (TIMEZONE_HOUR - 134)) | (1L << (TIMEZONE_MINUTE - 134)) | (1L << (TRIM - 134)) | (1L << (TO - 134)) | (1L << (UNKNOWN - 134)) | (1L << (VALUES - 134)) | (1L << (VAR_SAMP - 134)) | (1L << (VAR_POP - 134)) | (1L << (VARYING - 134)) | (1L << (WEEK - 134)) | (1L << (WRAPPER - 134)) | (1L << (YEAR - 134)) | (1L << (ZONE - 134)) | (1L << (BOOLEAN - 134)) | (1L << (BOOL - 134)) | (1L << (BIT - 134)) | (1L << (VARBIT - 134)) | (1L << (INT1 - 134)) | (1L << (INT2 - 134)) | (1L << (INT4 - 134)) | (1L << (INT8 - 134)) | (1L << (TINYINT - 134)) | (1L << (SMALLINT - 134)) | (1L << (INT - 134)) | (1L << (INTEGER - 134)))) != 0) || ((((_la - 198)) & ~0x3f) == 0 && ((1L << (_la - 198)) & ((1L << (BIGINT - 198)) | (1L << (FLOAT4 - 198)) | (1L << (FLOAT8 - 198)) | (1L << (REAL - 198)) | (1L << (FLOAT - 198)) | (1L << (DOUBLE - 198)) | (1L << (NUMERIC - 198)) | (1L << (DECIMAL - 198)) | (1L << (CHAR - 198)) | (1L << (VARCHAR - 198)) | (1L << (NCHAR - 198)) | (1L << (NVARCHAR - 198)) | (1L << (DATE - 198)) | (1L << (TIME - 198)) | (1L << (TIMETZ - 198)) | (1L << (TIMESTAMP - 198)) | (1L << (TIMESTAMPTZ - 198)) | (1L << (TEXT - 198)) | (1L << (VARBINARY - 198)) | (1L << (BLOB - 198)) | (1L << (BYTEA - 198)) | (1L << (INET4 - 198)) | (1L << (LEFT_PAREN - 198)) | (1L << (PLUS - 198)) | (1L << (MINUS - 198)) | (1L << (NUMBER - 198)) | (1L << (REAL_NUMBER - 198)) | (1L << (Identifier - 198)) | (1L << (Character_String_Literal - 198)))) != 0)) {
				{
				setState(2160); sql_argument_list();
				}
			}

			setState(2163); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 394, RULE_function_names_for_reserved_words);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2165);
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
		enterRule(_localctx, 396, RULE_function_name);
		try {
			setState(2169);
			switch (_input.LA(1)) {
			case ADMIN:
			case AVG:
			case BETWEEN:
			case BY:
			case CENTURY:
			case CHARACTER:
			case COLLECT:
			case COALESCE:
			case COLUMN:
			case COUNT:
			case CUBE:
			case DATA:
			case DAY:
			case DEC:
			case DECADE:
			case DOW:
			case DOY:
			case DROP:
			case EPOCH:
			case EVERY:
			case EXISTS:
			case EXTERNAL:
			case EXTRACT:
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
			case OVERWRITE:
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
			case SECOND:
			case SERVER:
			case SET:
			case SIMILAR:
			case STDDEV_POP:
			case STDDEV_SAMP:
			case SUBPARTITION:
			case SUM:
			case TABLESPACE:
			case THAN:
			case TIMEZONE:
			case TIMEZONE_HOUR:
			case TIMEZONE_MINUTE:
			case TRIM:
			case TO:
			case UNKNOWN:
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
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(2167); identifier();
				}
				break;
			case LEFT:
			case RIGHT:
				enterOuterAlt(_localctx, 2);
				{
				setState(2168); function_names_for_reserved_words();
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
		enterRule(_localctx, 398, RULE_sql_argument_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2171); value_expression();
			setState(2176);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2172); match(COMMA);
				setState(2173); value_expression();
				}
				}
				setState(2178);
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
		enterRule(_localctx, 400, RULE_orderby_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2179); match(ORDER);
			setState(2180); match(BY);
			setState(2181); sort_specifier_list();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 402, RULE_sort_specifier_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2183); sort_specifier();
			setState(2188);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2184); match(COMMA);
				setState(2185); sort_specifier();
				}
				}
				setState(2190);
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
		enterRule(_localctx, 404, RULE_sort_specifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2191); ((Sort_specifierContext)_localctx).key = row_value_predicand();
			setState(2193);
			_la = _input.LA(1);
			if (_la==ASC || _la==DESC) {
				{
				setState(2192); ((Sort_specifierContext)_localctx).order = order_specification();
				}
			}

			setState(2196);
			_la = _input.LA(1);
			if (_la==NULL) {
				{
				setState(2195); ((Sort_specifierContext)_localctx).null_order = null_ordering();
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
		enterRule(_localctx, 406, RULE_order_specification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2198);
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
		enterRule(_localctx, 408, RULE_limit_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2200); match(LIMIT);
			setState(2201); ((Limit_clauseContext)_localctx).e = numeric_value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 410, RULE_null_ordering);
		try {
			setState(2207);
			switch ( getInterpreter().adaptivePredict(_input,290,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2203); match(NULL);
				setState(2204); match(FIRST);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2205); match(NULL);
				setState(2206); match(LAST);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public TerminalNode Character_String_Literal() { return getToken(SQLParser.Character_String_Literal, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
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
		enterRule(_localctx, 412, RULE_insert_statement);
		int _la;
		try {
			setState(2238);
			switch ( getInterpreter().adaptivePredict(_input,296,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2209); match(INSERT);
				setState(2211);
				_la = _input.LA(1);
				if (_la==OVERWRITE) {
					{
					setState(2210); match(OVERWRITE);
					}
				}

				setState(2213); match(INTO);
				setState(2214); table_name();
				setState(2219);
				switch ( getInterpreter().adaptivePredict(_input,292,_ctx) ) {
				case 1:
					{
					setState(2215); match(LEFT_PAREN);
					setState(2216); column_name_list();
					setState(2217); match(RIGHT_PAREN);
					}
					break;
				}
				setState(2221); query_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2223); match(INSERT);
				setState(2225);
				_la = _input.LA(1);
				if (_la==OVERWRITE) {
					{
					setState(2224); match(OVERWRITE);
					}
				}

				setState(2227); match(INTO);
				setState(2228); match(LOCATION);
				setState(2229); ((Insert_statementContext)_localctx).path = match(Character_String_Literal);
				setState(2235);
				_la = _input.LA(1);
				if (_la==USING) {
					{
					setState(2230); match(USING);
					setState(2231); ((Insert_statementContext)_localctx).file_type = identifier();
					setState(2233);
					_la = _input.LA(1);
					if (_la==WITH) {
						{
						setState(2232); param_clause();
						}
					}

					}
				}

				setState(2237); query_expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\u0103\u08c3\4\2\t"+
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
		"\t\u00cd\4\u00ce\t\u00ce\4\u00cf\t\u00cf\4\u00d0\t\u00d0\3\2\3\2\5\2\u01a3"+
		"\n\2\6\2\u01a5\n\2\r\2\16\2\u01a6\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\5\3\u01b3\n\3\3\4\3\4\3\5\3\5\3\6\3\6\5\6\u01bb\n\6\3\7\3\7\5\7\u01bf"+
		"\n\7\3\7\3\7\3\7\3\7\3\7\5\7\u01c6\n\7\3\7\3\7\3\7\3\7\5\7\u01cc\n\7\3"+
		"\b\3\b\3\b\3\b\3\b\5\b\u01d3\n\b\3\b\3\b\5\b\u01d7\n\b\3\b\3\b\5\b\u01db"+
		"\n\b\3\b\3\b\5\b\u01df\n\b\3\b\3\b\5\b\u01e3\n\b\3\t\3\t\5\t\u01e7\n\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u01f1\n\t\3\t\5\t\u01f4\n\t\6\t\u01f6"+
		"\n\t\r\t\16\t\u01f7\3\t\3\t\5\t\u01fc\n\t\3\t\3\t\3\t\3\t\3\t\5\t\u0203"+
		"\n\t\3\t\5\t\u0206\n\t\6\t\u0208\n\t\r\t\16\t\u0209\5\t\u020c\n\t\3\n"+
		"\3\n\5\n\u0210\n\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u0218\n\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\5\n\u0221\n\n\6\n\u0223\n\n\r\n\16\n\u0224\5\n\u0227\n"+
		"\n\5\n\u0229\n\n\3\n\3\n\3\n\3\n\5\n\u022f\n\n\3\n\3\n\3\n\5\n\u0234\n"+
		"\n\3\n\3\n\3\n\3\n\5\n\u023a\n\n\3\n\3\n\5\n\u023e\n\n\3\n\3\n\5\n\u0242"+
		"\n\n\3\n\3\n\5\n\u0246\n\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u024e\n\n\5\n\u0250"+
		"\n\n\3\n\3\n\3\13\3\13\6\13\u0256\n\13\r\13\16\13\u0257\3\13\3\13\5\13"+
		"\u025c\n\13\5\13\u025e\n\13\3\13\3\13\5\13\u0262\n\13\3\13\3\13\5\13\u0266"+
		"\n\13\6\13\u0268\n\13\r\13\16\13\u0269\3\13\3\13\3\13\3\13\3\13\3\13\5"+
		"\13\u0272\n\13\6\13\u0274\n\13\r\13\16\13\u0275\5\13\u0278\n\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\5\13\u0280\n\13\6\13\u0282\n\13\r\13\16\13\u0283"+
		"\6\13\u0286\n\13\r\13\16\13\u0287\3\13\3\13\5\13\u028c\n\13\3\13\3\13"+
		"\5\13\u0290\n\13\6\13\u0292\n\13\r\13\16\13\u0293\5\13\u0296\n\13\3\13"+
		"\3\13\5\13\u029a\n\13\3\13\3\13\5\13\u029e\n\13\6\13\u02a0\n\13\r\13\16"+
		"\13\u02a1\3\13\3\13\3\13\3\13\3\13\5\13\u02a9\n\13\6\13\u02ab\n\13\r\13"+
		"\16\13\u02ac\3\13\3\13\5\13\u02b1\n\13\5\13\u02b3\n\13\3\13\3\13\3\13"+
		"\3\13\5\13\u02b9\n\13\6\13\u02bb\n\13\r\13\16\13\u02bc\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\5\13\u02c5\n\13\6\13\u02c7\n\13\r\13\16\13\u02c8\5\13"+
		"\u02cb\n\13\3\13\3\13\3\13\3\13\3\13\5\13\u02d2\n\13\6\13\u02d4\n\13\r"+
		"\13\16\13\u02d5\3\13\3\13\5\13\u02da\n\13\5\13\u02dc\n\13\3\13\3\13\3"+
		"\13\3\13\5\13\u02e2\n\13\6\13\u02e4\n\13\r\13\16\13\u02e5\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\5\13\u02ee\n\13\5\13\u02f0\n\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\5\13\u02f8\n\13\6\13\u02fa\n\13\r\13\16\13\u02fb\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\5\13\u0304\n\13\5\13\u0306\n\13\3\13\3\13\3\13\3"+
		"\13\3\13\5\13\u030d\n\13\6\13\u030f\n\13\r\13\16\13\u0310\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\5\13\u0319\n\13\5\13\u031b\n\13\3\13\3\13\3\13\3\13"+
		"\3\13\5\13\u0322\n\13\3\13\5\13\u0325\n\13\3\13\3\13\5\13\u0329\n\13\7"+
		"\13\u032b\n\13\f\13\16\13\u032e\13\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\5\13\u0338\n\13\6\13\u033a\n\13\r\13\16\13\u033b\5\13\u033e\n"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u0346\n\13\5\13\u0348\n\13\3\13"+
		"\3\13\3\13\3\13\5\13\u034e\n\13\6\13\u0350\n\13\r\13\16\13\u0351\3\13"+
		"\3\13\3\13\3\13\3\13\5\13\u0359\n\13\6\13\u035b\n\13\r\13\16\13\u035c"+
		"\3\13\3\13\5\13\u0361\n\13\5\13\u0363\n\13\3\13\3\13\3\13\3\13\3\13\5"+
		"\13\u036a\n\13\6\13\u036c\n\13\r\13\16\13\u036d\3\13\3\13\3\13\3\13\3"+
		"\13\5\13\u0375\n\13\6\13\u0377\n\13\r\13\16\13\u0378\3\13\3\13\5\13\u037d"+
		"\n\13\5\13\u037f\n\13\3\13\3\13\3\13\3\13\5\13\u0385\n\13\6\13\u0387\n"+
		"\13\r\13\16\13\u0388\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u0391\n\13\5\13"+
		"\u0393\n\13\3\13\3\13\3\13\3\13\5\13\u0399\n\13\6\13\u039b\n\13\r\13\16"+
		"\13\u039c\3\13\3\13\3\13\3\13\5\13\u03a3\n\13\6\13\u03a5\n\13\r\13\16"+
		"\13\u03a6\3\13\3\13\3\13\5\13\u03ac\n\13\6\13\u03ae\n\13\r\13\16\13\u03af"+
		"\3\13\3\13\3\13\5\13\u03b5\n\13\5\13\u03b7\n\13\3\f\3\f\5\f\u03bb\n\f"+
		"\3\f\3\f\5\f\u03bf\n\f\3\f\5\f\u03c2\n\f\6\f\u03c4\n\f\r\f\16\f\u03c5"+
		"\3\f\3\f\3\f\5\f\u03cb\n\f\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\5\16\u03d7\n\16\3\16\5\16\u03da\n\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\5\16\u03e5\n\16\3\16\5\16\u03e8\n\16\3\16\5\16\u03eb"+
		"\n\16\3\16\3\16\5\16\u03ef\n\16\3\16\3\16\3\16\3\16\3\16\5\16\u03f6\n"+
		"\16\3\16\5\16\u03f9\n\16\3\16\5\16\u03fc\n\16\3\16\3\16\3\16\5\16\u0401"+
		"\n\16\3\17\3\17\3\17\3\17\7\17\u0407\n\17\f\17\16\17\u040a\13\17\3\17"+
		"\3\17\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3\22\3\22\7\22\u0418\n\22"+
		"\f\22\16\22\u041b\13\22\3\22\3\22\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3"+
		"\25\3\25\3\25\3\26\3\26\3\27\3\27\3\27\3\27\5\27\u042f\n\27\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\7\31\u043e\n\31"+
		"\f\31\16\31\u0441\13\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3"+
		"\32\5\32\u044d\n\32\3\32\3\32\5\32\u0451\n\32\5\32\u0453\n\32\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u0460\n\33\3\34\3\34"+
		"\3\34\7\34\u0465\n\34\f\34\16\34\u0468\13\34\3\35\3\35\3\35\3\36\3\36"+
		"\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \7 \u047d"+
		"\n \f \16 \u0480\13 \3!\3!\3!\3!\5!\u0486\n!\3!\3!\3!\3!\3\"\3\"\3\"\3"+
		"\"\3\"\3#\3#\3$\3$\3$\3$\5$\u0497\n$\3%\3%\5%\u049b\n%\3&\3&\3\'\3\'\5"+
		"\'\u04a1\n\'\3(\3(\3(\5(\u04a6\n(\3)\3)\3)\5)\u04ab\n)\3*\3*\3*\3+\3+"+
		"\3+\3,\3,\3,\3-\3-\3.\3.\3/\3/\3/\3/\3/\3/\3/\3/\3/\5/\u04c3\n/\3\60\3"+
		"\60\3\61\3\61\5\61\u04c9\n\61\3\61\3\61\5\61\u04cd\n\61\3\61\3\61\3\61"+
		"\5\61\u04d2\n\61\3\61\3\61\3\61\5\61\u04d7\n\61\3\61\3\61\5\61\u04db\n"+
		"\61\3\61\5\61\u04de\n\61\3\62\3\62\3\62\3\62\3\63\3\63\3\63\5\63\u04e7"+
		"\n\63\3\63\3\63\3\63\5\63\u04ec\n\63\3\63\3\63\5\63\u04f0\n\63\3\63\3"+
		"\63\3\63\3\63\5\63\u04f6\n\63\3\63\3\63\3\63\3\63\5\63\u04fc\n\63\3\63"+
		"\3\63\3\63\5\63\u0501\n\63\3\63\3\63\5\63\u0505\n\63\5\63\u0507\n\63\3"+
		"\64\3\64\5\64\u050b\n\64\3\64\3\64\5\64\u050f\n\64\5\64\u0511\n\64\3\65"+
		"\3\65\5\65\u0515\n\65\3\66\3\66\5\66\u0519\n\66\3\66\3\66\5\66\u051d\n"+
		"\66\3\66\3\66\5\66\u0521\n\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66"+
		"\3\66\5\66\u052c\n\66\3\67\3\67\5\67\u0530\n\67\3\67\3\67\3\67\3\67\3"+
		"\67\3\67\5\67\u0538\n\67\38\38\38\38\38\38\38\38\58\u0542\n8\39\39\3:"+
		"\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\5:\u0553\n:\3;\3;\5;\u0557\n;\3;"+
		"\3;\5;\u055b\n;\3;\3;\3;\5;\u0560\n;\5;\u0562\n;\3<\3<\5<\u0566\n<\3<"+
		"\3<\3<\5<\u056b\n<\3<\3<\5<\u056f\n<\5<\u0571\n<\3=\3=\5=\u0575\n=\3>"+
		"\3>\3>\3>\3?\3?\3?\3?\3?\3?\3?\5?\u0582\n?\3@\3@\3A\3A\3B\5B\u0589\nB"+
		"\3B\3B\3C\3C\3D\3D\3D\3D\3D\3D\5D\u0595\nD\5D\u0597\nD\3E\3E\3E\5E\u059c"+
		"\nE\3E\3E\3E\3F\3F\3G\3G\3G\3G\3G\3G\3H\3H\3H\3H\3H\3I\3I\3J\3J\3J\3J"+
		"\3J\3J\3J\3J\3J\3J\3J\3J\6J\u05bc\nJ\rJ\16J\u05bd\3J\3J\5J\u05c2\nJ\3"+
		"K\3K\5K\u05c6\nK\3L\3L\3L\6L\u05cb\nL\rL\16L\u05cc\3L\5L\u05d0\nL\3L\3"+
		"L\3M\3M\6M\u05d6\nM\rM\16M\u05d7\3M\5M\u05db\nM\3M\3M\3N\3N\3N\3N\3N\3"+
		"O\3O\3O\3O\3O\3P\3P\3P\3Q\3Q\5Q\u05ee\nQ\3R\3R\3R\3R\3R\3R\3R\3S\3S\3"+
		"T\3T\3U\3U\3U\5U\u05fe\nU\3V\3V\3V\5V\u0603\nV\3W\3W\3W\7W\u0608\nW\f"+
		"W\16W\u060b\13W\3X\3X\3X\7X\u0610\nX\fX\16X\u0613\13X\3Y\5Y\u0616\nY\3"+
		"Y\3Y\3Z\3Z\3Z\3Z\7Z\u061e\nZ\fZ\16Z\u0621\13Z\3Z\3Z\3[\3[\3[\7[\u0628"+
		"\n[\f[\16[\u062b\13[\3[\5[\u062e\n[\3\\\3\\\3]\3]\3^\3^\3^\3^\3^\3^\3"+
		"^\3_\3_\3_\5_\u063e\n_\3`\3`\3a\3a\5a\u0644\na\3b\3b\3c\3c\3c\7c\u064b"+
		"\nc\fc\16c\u064e\13c\3d\3d\3e\3e\5e\u0654\ne\3f\3f\3g\3g\3g\3g\3g\3h\5"+
		"h\u065e\nh\3h\5h\u0661\nh\3h\5h\u0664\nh\3h\3h\3h\3h\3h\5h\u066b\nh\3"+
		"i\3i\3j\3j\3k\3k\3k\7k\u0674\nk\fk\16k\u0677\13k\3l\3l\3l\7l\u067c\nl"+
		"\fl\16l\u067f\13l\3m\3m\3m\5m\u0684\nm\3n\3n\5n\u0688\nn\3o\3o\5o\u068c"+
		"\no\3o\3o\3p\3p\3q\3q\5q\u0694\nq\3r\3r\5r\u0698\nr\3s\3s\3s\3s\3t\3t"+
		"\5t\u06a0\nt\3u\3u\3v\3v\3w\3w\5w\u06a8\nw\3x\3x\5x\u06ac\nx\3y\3y\5y"+
		"\u06b0\ny\3y\5y\u06b3\ny\3y\5y\u06b6\ny\3y\5y\u06b9\ny\3y\5y\u06bc\ny"+
		"\3z\3z\3z\3{\3{\3{\7{\u06c4\n{\f{\16{\u06c7\13{\3|\3|\5|\u06cb\n|\3}\3"+
		"}\6}\u06cf\n}\r}\16}\u06d0\3~\3~\3~\3~\5~\u06d7\n~\3~\3~\3~\3~\3~\3~\5"+
		"~\u06df\n~\3~\3~\3~\3~\3~\5~\u06e6\n~\3\177\3\177\3\177\3\177\3\u0080"+
		"\5\u0080\u06ed\n\u0080\3\u0080\3\u0080\3\u0080\3\u0080\3\u0081\3\u0081"+
		"\5\u0081\u06f5\n\u0081\3\u0081\3\u0081\3\u0081\3\u0082\3\u0082\3\u0082"+
		"\3\u0082\3\u0083\3\u0083\5\u0083\u0700\n\u0083\3\u0084\3\u0084\5\u0084"+
		"\u0704\n\u0084\3\u0085\3\u0085\3\u0086\3\u0086\5\u0086\u070a\n\u0086\3"+
		"\u0087\3\u0087\3\u0087\3\u0088\3\u0088\3\u0088\3\u0088\3\u0088\3\u0089"+
		"\3\u0089\5\u0089\u0716\n\u0089\3\u0089\5\u0089\u0719\n\u0089\3\u0089\3"+
		"\u0089\3\u0089\3\u0089\5\u0089\u071f\n\u0089\3\u0089\3\u0089\5\u0089\u0723"+
		"\n\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\5\u0089\u072a\n\u0089"+
		"\5\u0089\u072c\n\u0089\3\u008a\3\u008a\3\u008a\7\u008a\u0731\n\u008a\f"+
		"\u008a\16\u008a\u0734\13\u008a\3\u008b\3\u008b\3\u008c\3\u008c\3\u008c"+
		"\3\u008d\3\u008d\3\u008e\3\u008e\3\u008e\3\u008e\3\u008f\3\u008f\3\u008f"+
		"\7\u008f\u0744\n\u008f\f\u008f\16\u008f\u0747\13\u008f\3\u0090\3\u0090"+
		"\3\u0090\3\u0090\5\u0090\u074d\n\u0090\3\u0091\3\u0091\3\u0091\3\u0091"+
		"\3\u0091\5\u0091\u0754\n\u0091\3\u0092\3\u0092\3\u0092\7\u0092\u0759\n"+
		"\u0092\f\u0092\16\u0092\u075c\13\u0092\3\u0093\3\u0093\3\u0093\3\u0093"+
		"\3\u0093\3\u0094\3\u0094\3\u0094\3\u0094\3\u0094\3\u0095\3\u0095\3\u0095"+
		"\3\u0096\3\u0096\3\u0096\3\u0097\3\u0097\3\u0097\7\u0097\u0771\n\u0097"+
		"\f\u0097\16\u0097\u0774\13\u0097\3\u0098\3\u0098\3\u0099\3\u0099\5\u0099"+
		"\u077a\n\u0099\3\u009a\3\u009a\3\u009a\3\u009a\5\u009a\u0780\n\u009a\3"+
		"\u009a\3\u009a\5\u009a\u0784\n\u009a\3\u009a\3\u009a\5\u009a\u0788\n\u009a"+
		"\3\u009a\7\u009a\u078b\n\u009a\f\u009a\16\u009a\u078e\13\u009a\3\u009b"+
		"\3\u009b\5\u009b\u0792\n\u009b\3\u009c\3\u009c\3\u009c\3\u009c\5\u009c"+
		"\u0798\n\u009c\3\u009c\3\u009c\5\u009c\u079c\n\u009c\3\u009c\3\u009c\5"+
		"\u009c\u07a0\n\u009c\3\u009c\7\u009c\u07a3\n\u009c\f\u009c\16\u009c\u07a6"+
		"\13\u009c\3\u009d\3\u009d\5\u009d\u07aa\n\u009d\3\u009e\3\u009e\3\u009e"+
		"\3\u009e\3\u009e\5\u009e\u07b1\n\u009e\3\u009f\3\u009f\5\u009f\u07b5\n"+
		"\u009f\3\u00a0\3\u00a0\3\u00a0\3\u00a1\3\u00a1\5\u00a1\u07bc\n\u00a1\3"+
		"\u00a2\3\u00a2\3\u00a2\3\u00a2\3\u00a2\5\u00a2\u07c3\n\u00a2\5\u00a2\u07c5"+
		"\n\u00a2\3\u00a3\3\u00a3\5\u00a3\u07c9\n\u00a3\3\u00a3\3\u00a3\5\u00a3"+
		"\u07cd\n\u00a3\3\u00a4\3\u00a4\3\u00a4\7\u00a4\u07d2\n\u00a4\f\u00a4\16"+
		"\u00a4\u07d5\13\u00a4\3\u00a5\3\u00a5\5\u00a5\u07d9\n\u00a5\3\u00a6\3"+
		"\u00a6\5\u00a6\u07dd\n\u00a6\3\u00a7\3\u00a7\5\u00a7\u07e1\n\u00a7\3\u00a7"+
		"\3\u00a7\3\u00a8\3\u00a8\3\u00a9\3\u00a9\3\u00a9\5\u00a9\u07ea\n\u00a9"+
		"\3\u00a9\3\u00a9\3\u00aa\5\u00aa\u07ef\n\u00aa\3\u00aa\3\u00aa\3\u00ab"+
		"\3\u00ab\3\u00ab\7\u00ab\u07f6\n\u00ab\f\u00ab\16\u00ab\u07f9\13\u00ab"+
		"\3\u00ac\3\u00ac\3\u00ad\3\u00ad\3\u00ae\3\u00ae\3\u00af\3\u00af\3\u00af"+
		"\3\u00af\3\u00b0\3\u00b0\3\u00b0\3\u00b0\3\u00b0\3\u00b0\5\u00b0\u080b"+
		"\n\u00b0\3\u00b1\3\u00b1\3\u00b1\3\u00b1\3\u00b2\3\u00b2\3\u00b3\3\u00b3"+
		"\3\u00b3\3\u00b4\5\u00b4\u0817\n\u00b4\3\u00b4\3\u00b4\5\u00b4\u081b\n"+
		"\u00b4\3\u00b4\3\u00b4\3\u00b4\3\u00b4\3\u00b5\3\u00b5\5\u00b5\u0823\n"+
		"\u00b5\3\u00b5\3\u00b5\3\u00b5\3\u00b6\3\u00b6\3\u00b6\3\u00b6\3\u00b6"+
		"\5\u00b6\u082d\n\u00b6\3\u00b7\3\u00b7\3\u00b7\7\u00b7\u0832\n\u00b7\f"+
		"\u00b7\16\u00b7\u0835\13\u00b7\3\u00b8\3\u00b8\3\u00b8\3\u00b8\3\u00b9"+
		"\5\u00b9\u083c\n\u00b9\3\u00b9\3\u00b9\5\u00b9\u0840\n\u00b9\3\u00ba\3"+
		"\u00ba\3\u00ba\3\u00ba\3\u00ba\3\u00ba\5\u00ba\u0848\n\u00ba\3\u00bb\3"+
		"\u00bb\3\u00bc\3\u00bc\3\u00bc\5\u00bc\u084f\n\u00bc\3\u00bc\3\u00bc\3"+
		"\u00bd\3\u00bd\3\u00bd\3\u00bd\3\u00bd\3\u00be\3\u00be\5\u00be\u085a\n"+
		"\u00be\3\u00bf\3\u00bf\3\u00c0\3\u00c0\3\u00c1\5\u00c1\u0861\n\u00c1\3"+
		"\u00c1\3\u00c1\3\u00c1\3\u00c2\3\u00c2\3\u00c2\3\u00c3\3\u00c3\5\u00c3"+
		"\u086b\n\u00c3\3\u00c4\3\u00c4\3\u00c5\3\u00c5\3\u00c6\3\u00c6\3\u00c6"+
		"\5\u00c6\u0874\n\u00c6\3\u00c6\3\u00c6\3\u00c7\3\u00c7\3\u00c8\3\u00c8"+
		"\5\u00c8\u087c\n\u00c8\3\u00c9\3\u00c9\3\u00c9\7\u00c9\u0881\n\u00c9\f"+
		"\u00c9\16\u00c9\u0884\13\u00c9\3\u00ca\3\u00ca\3\u00ca\3\u00ca\3\u00cb"+
		"\3\u00cb\3\u00cb\7\u00cb\u088d\n\u00cb\f\u00cb\16\u00cb\u0890\13\u00cb"+
		"\3\u00cc\3\u00cc\5\u00cc\u0894\n\u00cc\3\u00cc\5\u00cc\u0897\n\u00cc\3"+
		"\u00cd\3\u00cd\3\u00ce\3\u00ce\3\u00ce\3\u00cf\3\u00cf\3\u00cf\3\u00cf"+
		"\5\u00cf\u08a2\n\u00cf\3\u00d0\3\u00d0\5\u00d0\u08a6\n\u00d0\3\u00d0\3"+
		"\u00d0\3\u00d0\3\u00d0\3\u00d0\3\u00d0\5\u00d0\u08ae\n\u00d0\3\u00d0\3"+
		"\u00d0\3\u00d0\3\u00d0\5\u00d0\u08b4\n\u00d0\3\u00d0\3\u00d0\3\u00d0\3"+
		"\u00d0\3\u00d0\3\u00d0\5\u00d0\u08bc\n\u00d0\5\u00d0\u08be\n\u00d0\3\u00d0"+
		"\5\u00d0\u08c1\n\u00d0\3\u00d0\2\2\u00d1\2\4\6\b\n\f\16\20\22\24\26\30"+
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
		"\u018a\u018c\u018e\u0190\u0192\u0194\u0196\u0198\u019a\u019c\u019e\2\37"+
		"\4\299MM\4\2\u00b1\u00b1\u00e5\u00e5\t\2\26\26FFLLVVXX[[\u0081\u0081\6"+
		"\2FFLL[[\u0081\u0081\4\2LL[\\\5\2\16\16\20\20RS\4\2LL[[\4\2\20\20\\\\"+
		"\6\2,,\61\61@@^^\7\2b~\u0080\u00aa\u00ac\u00b6\u00b8\u00d9\u00db\u00de"+
		"\5\2\37\37WW\u00b2\u00b2\3\2\u00bc\u00bd\3\2\u00fb\u00fc\17\2\7\7NNcc"+
		"hhkkuu||\u0082\u0082\u008b\u008b\u0090\u0090\u00a6\u00a7\u00a9\u00a9\u00b4"+
		"\u00b5\3\2\u00f1\u00f2\3\2\u00f3\u00f5\3\2\u00ad\u00af\5\2\13\13\65\65"+
		"UU\5\2\"\"\66\66HH\4\2\34\34YY\4\2\5\5\30\30\4\2\u00e5\u00e5\u00ea\u00ee"+
		"\4\2\b\bPP\3\2\u00df\u00e2\4\2\7\7NN\6\2nn\177\177\u0091\u0092\u00ba\u00ba"+
		"\t\2ffprtt\u0083\u0084\u008d\u008f\u009d\u009d\u00b8\u00b8\4\2\66\66H"+
		"H\4\2\t\t\27\27\u0970\2\u01a4\3\2\2\2\4\u01b2\3\2\2\2\6\u01b4\3\2\2\2"+
		"\b\u01b6\3\2\2\2\n\u01ba\3\2\2\2\f\u01bc\3\2\2\2\16\u01cd\3\2\2\2\20\u020b"+
		"\3\2\2\2\22\u020d\3\2\2\2\24\u03b6\3\2\2\2\26\u03b8\3\2\2\2\30\u03cc\3"+
		"\2\2\2\32\u0400\3\2\2\2\34\u0402\3\2\2\2\36\u040d\3\2\2\2 \u0410\3\2\2"+
		"\2\"\u0412\3\2\2\2$\u041e\3\2\2\2&\u0422\3\2\2\2(\u0425\3\2\2\2*\u0428"+
		"\3\2\2\2,\u042e\3\2\2\2.\u0430\3\2\2\2\60\u043a\3\2\2\2\62\u0442\3\2\2"+
		"\2\64\u0454\3\2\2\2\66\u0461\3\2\2\28\u0469\3\2\2\2:\u046c\3\2\2\2<\u046f"+
		"\3\2\2\2>\u0479\3\2\2\2@\u0481\3\2\2\2B\u048b\3\2\2\2D\u0490\3\2\2\2F"+
		"\u0492\3\2\2\2H\u049a\3\2\2\2J\u049c\3\2\2\2L\u04a0\3\2\2\2N\u04a5\3\2"+
		"\2\2P\u04aa\3\2\2\2R\u04ac\3\2\2\2T\u04af\3\2\2\2V\u04b2\3\2\2\2X\u04b5"+
		"\3\2\2\2Z\u04b7\3\2\2\2\\\u04c2\3\2\2\2^\u04c4\3\2\2\2`\u04dd\3\2\2\2"+
		"b\u04df\3\2\2\2d\u0506\3\2\2\2f\u0510\3\2\2\2h\u0514\3\2\2\2j\u052b\3"+
		"\2\2\2l\u0537\3\2\2\2n\u0541\3\2\2\2p\u0543\3\2\2\2r\u0552\3\2\2\2t\u0561"+
		"\3\2\2\2v\u0570\3\2\2\2x\u0574\3\2\2\2z\u0576\3\2\2\2|\u0581\3\2\2\2~"+
		"\u0583\3\2\2\2\u0080\u0585\3\2\2\2\u0082\u0588\3\2\2\2\u0084\u058c\3\2"+
		"\2\2\u0086\u0596\3\2\2\2\u0088\u0598\3\2\2\2\u008a\u05a0\3\2\2\2\u008c"+
		"\u05a2\3\2\2\2\u008e\u05a8\3\2\2\2\u0090\u05ad\3\2\2\2\u0092\u05c1\3\2"+
		"\2\2\u0094\u05c5\3\2\2\2\u0096\u05c7\3\2\2\2\u0098\u05d3\3\2\2\2\u009a"+
		"\u05de\3\2\2\2\u009c\u05e3\3\2\2\2\u009e\u05e8\3\2\2\2\u00a0\u05ed\3\2"+
		"\2\2\u00a2\u05ef\3\2\2\2\u00a4\u05f6\3\2\2\2\u00a6\u05f8\3\2\2\2\u00a8"+
		"\u05fd\3\2\2\2\u00aa\u0602\3\2\2\2\u00ac\u0604\3\2\2\2\u00ae\u060c\3\2"+
		"\2\2\u00b0\u0615\3\2\2\2\u00b2\u0619\3\2\2\2\u00b4\u062d\3\2\2\2\u00b6"+
		"\u062f\3\2\2\2\u00b8\u0631\3\2\2\2\u00ba\u0633\3\2\2\2\u00bc\u063d\3\2"+
		"\2\2\u00be\u063f\3\2\2\2\u00c0\u0643\3\2\2\2\u00c2\u0645\3\2\2\2\u00c4"+
		"\u0647\3\2\2\2\u00c6\u064f\3\2\2\2\u00c8\u0653\3\2\2\2\u00ca\u0655\3\2"+
		"\2\2\u00cc\u0657\3\2\2\2\u00ce\u066a\3\2\2\2\u00d0\u066c\3\2\2\2\u00d2"+
		"\u066e\3\2\2\2\u00d4\u0670\3\2\2\2\u00d6\u0678\3\2\2\2\u00d8\u0683\3\2"+
		"\2\2\u00da\u0685\3\2\2\2\u00dc\u0689\3\2\2\2\u00de\u068f\3\2\2\2\u00e0"+
		"\u0693\3\2\2\2\u00e2\u0697\3\2\2\2\u00e4\u0699\3\2\2\2\u00e6\u069f\3\2"+
		"\2\2\u00e8\u06a1\3\2\2\2\u00ea\u06a3\3\2\2\2\u00ec\u06a7\3\2\2\2\u00ee"+
		"\u06ab\3\2\2\2\u00f0\u06ad\3\2\2\2\u00f2\u06bd\3\2\2\2\u00f4\u06c0\3\2"+
		"\2\2\u00f6\u06ca\3\2\2\2\u00f8\u06cc\3\2\2\2\u00fa\u06e5\3\2\2\2\u00fc"+
		"\u06e7\3\2\2\2\u00fe\u06ec\3\2\2\2\u0100\u06f2\3\2\2\2\u0102\u06f9\3\2"+
		"\2\2\u0104\u06ff\3\2\2\2\u0106\u0701\3\2\2\2\u0108\u0705\3\2\2\2\u010a"+
		"\u0709\3\2\2\2\u010c\u070b\3\2\2\2\u010e\u070e\3\2\2\2\u0110\u072b\3\2"+
		"\2\2\u0112\u072d\3\2\2\2\u0114\u0735\3\2\2\2\u0116\u0737\3\2\2\2\u0118"+
		"\u073a\3\2\2\2\u011a\u073c\3\2\2\2\u011c\u0740\3\2\2\2\u011e\u074c\3\2"+
		"\2\2\u0120\u0753\3\2\2\2\u0122\u0755\3\2\2\2\u0124\u075d\3\2\2\2\u0126"+
		"\u0762\3\2\2\2\u0128\u0767\3\2\2\2\u012a\u076a\3\2\2\2\u012c\u076d\3\2"+
		"\2\2\u012e\u0775\3\2\2\2\u0130\u0779\3\2\2\2\u0132\u0783\3\2\2\2\u0134"+
		"\u0791\3\2\2\2\u0136\u079b\3\2\2\2\u0138\u07a9\3\2\2\2\u013a\u07b0\3\2"+
		"\2\2\u013c\u07b4\3\2\2\2\u013e\u07b6\3\2\2\2\u0140\u07bb\3\2\2\2\u0142"+
		"\u07bd\3\2\2\2\u0144\u07c6\3\2\2\2\u0146\u07ce\3\2\2\2\u0148\u07d8\3\2"+
		"\2\2\u014a\u07da\3\2\2\2\u014c\u07e0\3\2\2\2\u014e\u07e4\3\2\2\2\u0150"+
		"\u07e9\3\2\2\2\u0152\u07ee\3\2\2\2\u0154\u07f2\3\2\2\2\u0156\u07fa\3\2"+
		"\2\2\u0158\u07fc\3\2\2\2\u015a\u07fe\3\2\2\2\u015c\u0800\3\2\2\2\u015e"+
		"\u080a\3\2\2\2\u0160\u080c\3\2\2\2\u0162\u0810\3\2\2\2\u0164\u0812\3\2"+
		"\2\2\u0166\u0816\3\2\2\2\u0168\u0820\3\2\2\2\u016a\u082c\3\2\2\2\u016c"+
		"\u082e\3\2\2\2\u016e\u0836\3\2\2\2\u0170\u083f\3\2\2\2\u0172\u0847\3\2"+
		"\2\2\u0174\u0849\3\2\2\2\u0176\u084b\3\2\2\2\u0178\u0852\3\2\2\2\u017a"+
		"\u0859\3\2\2\2\u017c\u085b\3\2\2\2\u017e\u085d\3\2\2\2\u0180\u0860\3\2"+
		"\2\2\u0182\u0865\3\2\2\2\u0184\u086a\3\2\2\2\u0186\u086c\3\2\2\2\u0188"+
		"\u086e\3\2\2\2\u018a\u0870\3\2\2\2\u018c\u0877\3\2\2\2\u018e\u087b\3\2"+
		"\2\2\u0190\u087d\3\2\2\2\u0192\u0885\3\2\2\2\u0194\u0889\3\2\2\2\u0196"+
		"\u0891\3\2\2\2\u0198\u0898\3\2\2\2\u019a\u089a\3\2\2\2\u019c\u08a1\3\2"+
		"\2\2\u019e\u08c0\3\2\2\2\u01a0\u01a2\5\4\3\2\u01a1\u01a3\7\u00e7\2\2\u01a2"+
		"\u01a1\3\2\2\2\u01a2\u01a3\3\2\2\2\u01a3\u01a5\3\2\2\2\u01a4\u01a0\3\2"+
		"\2\2\u01a5\u01a6\3\2\2\2\u01a6\u01a4\3\2\2\2\u01a6\u01a7\3\2\2\2\u01a7"+
		"\u01a8\3\2\2\2\u01a8\u01a9\7\2\2\3\u01a9\3\3\2\2\2\u01aa\u01b3\5\6\4\2"+
		"\u01ab\u01b3\5\b\5\2\u01ac\u01b3\5\n\6\2\u01ad\u01b3\5\f\7\2\u01ae\u01b3"+
		"\5\16\b\2\u01af\u01b3\5\20\t\2\u01b0\u01b3\5\22\n\2\u01b1\u01b3\5\24\13"+
		"\2\u01b2\u01aa\3\2\2\2\u01b2\u01ab\3\2\2\2\u01b2\u01ac\3\2\2\2\u01b2\u01ad"+
		"\3\2\2\2\u01b2\u01ae\3\2\2\2\u01b2\u01af\3\2\2\2\u01b2\u01b0\3\2\2\2\u01b2"+
		"\u01b1\3\2\2\2\u01b3\5\3\2\2\2\u01b4\u01b5\5\u012e\u0098\2\u01b5\7\3\2"+
		"\2\2\u01b6\u01b7\5\u019e\u00d0\2\u01b7\t\3\2\2\2\u01b8\u01bb\5\32\16\2"+
		"\u01b9\u01bb\5F$\2\u01ba\u01b8\3\2\2\2\u01ba\u01b9\3\2\2\2\u01bb\13\3"+
		"\2\2\2\u01bc\u01be\7\20\2\2\u01bd\u01bf\7Z\2\2\u01be\u01bd\3\2\2\2\u01be"+
		"\u01bf\3\2\2\2\u01bf\u01c0\3\2\2\2\u01c0\u01c1\7\u0080\2\2\u01c1\u01c2"+
		"\5H%\2\u01c2\u01c3\7>\2\2\u01c3\u01c5\5\u0142\u00a2\2\u01c4\u01c6\5&\24"+
		"\2\u01c5\u01c4\3\2\2\2\u01c5\u01c6\3\2\2\2\u01c6\u01c7\3\2\2\2\u01c7\u01c8"+
		"\7\u00ef\2\2\u01c8\u01c9\5\u0194\u00cb\2\u01c9\u01cb\7\u00f0\2\2\u01ca"+
		"\u01cc\5\"\22\2\u01cb\u01ca\3\2\2\2\u01cb\u01cc\3\2\2\2\u01cc\r\3\2\2"+
		"\2\u01cd\u01ce\7\20\2\2\u01ce\u01d2\7\36\2\2\u01cf\u01d0\7)\2\2\u01d0"+
		"\u01d1\7;\2\2\u01d1\u01d3\7v\2\2\u01d2\u01cf\3\2\2\2\u01d2\u01d3\3\2\2"+
		"\2\u01d3\u01d4\3\2\2\2\u01d4\u01d6\5H%\2\u01d5\u01d7\7a\2\2\u01d6\u01d5"+
		"\3\2\2\2\u01d6\u01d7\3\2\2\2\u01d7\u01da\3\2\2\2\u01d8\u01d9\7I\2\2\u01d9"+
		"\u01db\5H%\2\u01da\u01d8\3\2\2\2\u01da\u01db\3\2\2\2\u01db\u01de\3\2\2"+
		"\2\u01dc\u01dd\7\u00b7\2\2\u01dd\u01df\5H%\2\u01de\u01dc\3\2\2\2\u01de"+
		"\u01df\3\2\2\2\u01df\u01e2\3\2\2\2\u01e0\u01e1\7%\2\2\u01e1\u01e3\5H%"+
		"\2\u01e2\u01e0\3\2\2\2\u01e2\u01e3\3\2\2\2\u01e3\17\3\2\2\2\u01e4\u01e6"+
		"\7\u00a4\2\2\u01e5\u01e7\t\2\2\2\u01e6\u01e5\3\2\2\2\u01e6\u01e7\3\2\2"+
		"\2\u01e7\u01e8\3\2\2\2\u01e8\u01e9\5H%\2\u01e9\u01f5\t\3\2\2\u01ea\u01f1"+
		"\5H%\2\u01eb\u01ec\7\u00f9\2\2\u01ec\u01ed\5H%\2\u01ed\u01ee\7\u00f9\2"+
		"\2\u01ee\u01f1\3\2\2\2\u01ef\u01f1\7\23\2\2\u01f0\u01ea\3\2\2\2\u01f0"+
		"\u01eb\3\2\2\2\u01f0\u01ef\3\2\2\2\u01f1\u01f3\3\2\2\2\u01f2\u01f4\7\u00e8"+
		"\2\2\u01f3\u01f2\3\2\2\2\u01f3\u01f4\3\2\2\2\u01f4\u01f6\3\2\2\2\u01f5"+
		"\u01f0\3\2\2\2\u01f6\u01f7\3\2\2\2\u01f7\u01f5\3\2\2\2\u01f7\u01f8\3\2"+
		"\2\2\u01f8\u020c\3\2\2\2\u01f9\u01fb\7\u00a4\2\2\u01fa\u01fc\t\2\2\2\u01fb"+
		"\u01fa\3\2\2\2\u01fb\u01fc\3\2\2\2\u01fc\u01fd\3\2\2\2\u01fd\u01fe\7\u00d5"+
		"\2\2\u01fe\u0207\7\u00bb\2\2\u01ff\u0203\5H%\2\u0200\u0203\79\2\2\u0201"+
		"\u0203\7\23\2\2\u0202\u01ff\3\2\2\2\u0202\u0200\3\2\2\2\u0202\u0201\3"+
		"\2\2\2\u0203\u0205\3\2\2\2\u0204\u0206\7\u00e8\2\2\u0205\u0204\3\2\2\2"+
		"\u0205\u0206\3\2\2\2\u0206\u0208\3\2\2\2\u0207\u0202\3\2\2\2\u0208\u0209"+
		"\3\2\2\2\u0209\u0207\3\2\2\2\u0209\u020a\3\2\2\2\u020a\u020c\3\2\2\2\u020b"+
		"\u01e4\3\2\2\2\u020b\u01f9\3\2\2\2\u020c\21\3\2\2\2\u020d\u020f\7\20\2"+
		"\2\u020e\u0210\7\17\2\2\u020f\u020e\3\2\2\2\u020f\u0210\3\2\2\2\u0210"+
		"\u0211\3\2\2\2\u0211\u0212\7V\2\2\u0212\u0217\5H%\2\u0213\u0218\7\n\2"+
		"\2\u0214\u0215\7\62\2\2\u0215\u0218\7=\2\2\u0216\u0218\7\3\2\2\u0217\u0213"+
		"\3\2\2\2\u0217\u0214\3\2\2\2\u0217\u0216\3\2\2\2\u0218\u0228\3\2\2\2\u0219"+
		"\u0229\7\u0081\2\2\u021a\u0229\7\26\2\2\u021b\u0229\7X\2\2\u021c\u0226"+
		"\7[\2\2\u021d\u0222\7=\2\2\u021e\u0220\5H%\2\u021f\u0221\7\u00e8\2\2\u0220"+
		"\u021f\3\2\2\2\u0220\u0221\3\2\2\2\u0221\u0223\3\2\2\2\u0222\u021e\3\2"+
		"\2\2\u0223\u0224\3\2\2\2\u0224\u0222\3\2\2\2\u0224\u0225\3\2\2\2\u0225"+
		"\u0227\3\2\2\2\u0226\u021d\3\2\2\2\u0226\u0227\3\2\2\2\u0227\u0229\3\2"+
		"\2\2\u0228\u0219\3\2\2\2\u0228\u021a\3\2\2\2\u0228\u021b\3\2\2\2\u0228"+
		"\u021c\3\2\2\2\u0229\u022a\3\2\2\2\u022a\u022b\7>\2\2\u022b\u022e\5\u0142"+
		"\u00a2\2\u022c\u022d\7%\2\2\u022d\u022f\5\u0142\u00a2\2\u022e\u022c\3"+
		"\2\2\2\u022e\u022f\3\2\2\2\u022f\u0239\3\2\2\2\u0230\u0231\7;\2\2\u0231"+
		"\u023a\7\24\2\2\u0232\u0234\7\24\2\2\u0233\u0232\3\2\2\2\u0233\u0234\3"+
		"\2\2\2\u0234\u0235\3\2\2\2\u0235\u0236\7-\2\2\u0236\u023a\7+\2\2\u0237"+
		"\u0238\7-\2\2\u0238\u023a\7\25\2\2\u0239\u0230\3\2\2\2\u0239\u0233\3\2"+
		"\2\2\u0239\u0237\3\2\2\2\u0239\u023a\3\2\2\2\u023a\u0241\3\2\2\2\u023b"+
		"\u023d\7 \2\2\u023c\u023e\7\31\2\2\u023d\u023c\3\2\2\2\u023d\u023e\3\2"+
		"\2\2\u023e\u023f\3\2\2\2\u023f\u0242\7E\2\2\u0240\u0242\7O\2\2\u0241\u023b"+
		"\3\2\2\2\u0241\u0240\3\2\2\2\u0241\u0242\3\2\2\2\u0242\u0245\3\2\2\2\u0243"+
		"\u0244\7_\2\2\u0244\u0246\5\u00d2j\2\u0245\u0243\3\2\2\2\u0245\u0246\3"+
		"\2\2\2\u0246\u0247\3\2\2\2\u0247\u0248\7\35\2\2\u0248\u0249\7D\2\2\u0249"+
		"\u024a\5H%\2\u024a\u024f\7\u00ef\2\2\u024b\u024d\5H%\2\u024c\u024e\7\u00e8"+
		"\2\2\u024d\u024c\3\2\2\2\u024d\u024e\3\2\2\2\u024e\u0250\3\2\2\2\u024f"+
		"\u024b\3\2\2\2\u024f\u0250\3\2\2\2\u0250\u0251\3\2\2\2\u0251\u0252\7\u00f0"+
		"\2\2\u0252\23\3\2\2\2\u0253\u025d\7&\2\2\u0254\u0256\t\4\2\2\u0255\u0254"+
		"\3\2\2\2\u0256\u0257\3\2\2\2\u0257\u0255\3\2\2\2\u0257\u0258\3\2\2\2\u0258"+
		"\u025e\3\2\2\2\u0259\u025b\7\5\2\2\u025a\u025c\7C\2\2\u025b\u025a\3\2"+
		"\2\2\u025b\u025c\3\2\2\2\u025c\u025e\3\2\2\2\u025d\u0255\3\2\2\2\u025d"+
		"\u0259\3\2\2\2\u025e\u025f\3\2\2\2\u025f\u0277\7>\2\2\u0260\u0262\7Q\2"+
		"\2\u0261\u0260\3\2\2\2\u0261\u0262\3\2\2\2\u0262\u0267\3\2\2\2\u0263\u0265"+
		"\5\u0142\u00a2\2\u0264\u0266\7\u00e8\2\2\u0265\u0264\3\2\2\2\u0265\u0266"+
		"\3\2\2\2\u0266\u0268\3\2\2\2\u0267\u0263\3\2\2\2\u0268\u0269\3\2\2\2\u0269"+
		"\u0267\3\2\2\2\u0269\u026a\3\2\2\2\u026a\u0278\3\2\2\2\u026b\u026c\7\5"+
		"\2\2\u026c\u026d\7\u00ab\2\2\u026d\u026e\7,\2\2\u026e\u0273\7I\2\2\u026f"+
		"\u0271\5H%\2\u0270\u0272\7\u00e8\2\2\u0271\u0270\3\2\2\2\u0271\u0272\3"+
		"\2\2\2\u0272\u0274\3\2\2\2\u0273\u026f\3\2\2\2\u0274\u0275\3\2\2\2\u0275"+
		"\u0273\3\2\2\2\u0275\u0276\3\2\2\2\u0276\u0278\3\2\2\2\u0277\u0261\3\2"+
		"\2\2\u0277\u026b\3\2\2\2\u0278\u0279\3\2\2\2\u0279\u027a\5\26\f\2\u027a"+
		"\u03b7\3\2\2\2\u027b\u0295\7&\2\2\u027c\u0281\t\5\2\2\u027d\u027f\5H%"+
		"\2\u027e\u0280\7\u00e8\2\2\u027f\u027e\3\2\2\2\u027f\u0280\3\2\2\2\u0280"+
		"\u0282\3\2\2\2\u0281\u027d\3\2\2\2\u0282\u0283\3\2\2\2\u0283\u0281\3\2"+
		"\2\2\u0283\u0284\3\2\2\2\u0284\u0286\3\2\2\2\u0285\u027c\3\2\2\2\u0286"+
		"\u0287\3\2\2\2\u0287\u0285\3\2\2\2\u0287\u0288\3\2\2\2\u0288\u0296\3\2"+
		"\2\2\u0289\u028b\7\5\2\2\u028a\u028c\7C\2\2\u028b\u028a\3\2\2\2\u028b"+
		"\u028c\3\2\2\2\u028c\u0291\3\2\2\2\u028d\u028f\5H%\2\u028e\u0290\7\u00e8"+
		"\2\2\u028f\u028e\3\2\2\2\u028f\u0290\3\2\2\2\u0290\u0292\3\2\2\2\u0291"+
		"\u028d\3\2\2\2\u0292\u0293\3\2\2\2\u0293\u0291\3\2\2\2\u0293\u0294\3\2"+
		"\2\2\u0294\u0296\3\2\2\2\u0295\u0285\3\2\2\2\u0295\u0289\3\2\2\2\u0296"+
		"\u0297\3\2\2\2\u0297\u029f\7>\2\2\u0298\u029a\7Q\2\2\u0299\u0298\3\2\2"+
		"\2\u0299\u029a\3\2\2\2\u029a\u029b\3\2\2\2\u029b\u029d\5\u0142\u00a2\2"+
		"\u029c\u029e\7\u00e8\2\2\u029d\u029c\3\2\2\2\u029d\u029e\3\2\2\2\u029e"+
		"\u02a0\3\2\2\2\u029f\u0299\3\2\2\2\u02a0\u02a1\3\2\2\2\u02a1\u029f\3\2"+
		"\2\2\u02a1\u02a2\3\2\2\2\u02a2\u02a3\3\2\2\2\u02a3\u02a4\5\26\f\2\u02a4"+
		"\u03b7\3\2\2\2\u02a5\u02b2\7&\2\2\u02a6\u02a8\t\6\2\2\u02a7\u02a9\7\u00e8"+
		"\2\2\u02a8\u02a7\3\2\2\2\u02a8\u02a9\3\2\2\2\u02a9\u02ab\3\2\2\2\u02aa"+
		"\u02a6\3\2\2\2\u02ab\u02ac\3\2\2\2\u02ac\u02aa\3\2\2\2\u02ac\u02ad\3\2"+
		"\2\2\u02ad\u02b3\3\2\2\2\u02ae\u02b0\7\5\2\2\u02af\u02b1\7C\2\2\u02b0"+
		"\u02af\3\2\2\2\u02b0\u02b1\3\2\2\2\u02b1\u02b3\3\2\2\2\u02b2\u02aa\3\2"+
		"\2\2\u02b2\u02ae\3\2\2\2\u02b3\u02b4\3\2\2\2\u02b4\u02ca\7>\2\2\u02b5"+
		"\u02b6\7J\2\2\u02b6\u02b8\5H%\2\u02b7\u02b9\7\u00e8\2\2\u02b8\u02b7\3"+
		"\2\2\2\u02b8\u02b9\3\2\2\2\u02b9\u02bb\3\2\2\2\u02ba\u02b5\3\2\2\2\u02bb"+
		"\u02bc\3\2\2\2\u02bc\u02ba\3\2\2\2\u02bc\u02bd\3\2\2\2\u02bd\u02cb\3\2"+
		"\2\2\u02be\u02bf\7\5\2\2\u02bf\u02c0\7K\2\2\u02c0\u02c1\7,\2\2\u02c1\u02c6"+
		"\7I\2\2\u02c2\u02c4\5H%\2\u02c3\u02c5\7\u00e8\2\2\u02c4\u02c3\3\2\2\2"+
		"\u02c4\u02c5\3\2\2\2\u02c5\u02c7\3\2\2\2\u02c6\u02c2\3\2\2\2\u02c7\u02c8"+
		"\3\2\2\2\u02c8\u02c6\3\2\2\2\u02c8\u02c9\3\2\2\2\u02c9\u02cb\3\2\2\2\u02ca"+
		"\u02ba\3\2\2\2\u02ca\u02be\3\2\2\2\u02cb\u02cc\3\2\2\2\u02cc\u02cd\5\26"+
		"\f\2\u02cd\u03b7\3\2\2\2\u02ce\u02db\7&\2\2\u02cf\u02d1\t\7\2\2\u02d0"+
		"\u02d2\7\u00e8\2\2\u02d1\u02d0\3\2\2\2\u02d1\u02d2\3\2\2\2\u02d2\u02d4"+
		"\3\2\2\2\u02d3\u02cf\3\2\2\2\u02d4\u02d5\3\2\2\2\u02d5\u02d3\3\2\2\2\u02d5"+
		"\u02d6\3\2\2\2\u02d6\u02dc\3\2\2\2\u02d7\u02d9\7\5\2\2\u02d8\u02da\7C"+
		"\2\2\u02d9\u02d8\3\2\2\2\u02d9\u02da\3\2\2\2\u02da\u02dc\3\2\2\2\u02db"+
		"\u02d3\3\2\2\2\u02db\u02d7\3\2\2\2\u02dc\u02dd\3\2\2\2\u02dd\u02de\7>"+
		"\2\2\u02de\u02e3\7\22\2\2\u02df\u02e1\5H%\2\u02e0\u02e2\7\u00e8\2\2\u02e1"+
		"\u02e0\3\2\2\2\u02e1\u02e2\3\2\2\2\u02e2\u02e4\3\2\2\2\u02e3\u02df\3\2"+
		"\2\2\u02e4\u02e5\3\2\2\2\u02e5\u02e3\3\2\2\2\u02e5\u02e6\3\2\2\2\u02e6"+
		"\u02e7\3\2\2\2\u02e7\u02e8\5\26\f\2\u02e8\u03b7\3\2\2\2\u02e9\u02ef\7"+
		"&\2\2\u02ea\u02f0\7\\\2\2\u02eb\u02ed\7\5\2\2\u02ec\u02ee\7C\2\2\u02ed"+
		"\u02ec\3\2\2\2\u02ed\u02ee\3\2\2\2\u02ee\u02f0\3\2\2\2\u02ef\u02ea\3\2"+
		"\2\2\u02ef\u02eb\3\2\2\2\u02f0\u02f1\3\2\2\2\u02f1\u02f2\7>\2\2\u02f2"+
		"\u02f3\7!\2\2\u02f3\u02f4\7m\2\2\u02f4\u02f9\7\u00b9\2\2\u02f5\u02f7\5"+
		"H%\2\u02f6\u02f8\7\u00e8\2\2\u02f7\u02f6\3\2\2\2\u02f7\u02f8\3\2\2\2\u02f8"+
		"\u02fa\3\2\2\2\u02f9\u02f5\3\2\2\2\u02fa\u02fb\3\2\2\2\u02fb\u02f9\3\2"+
		"\2\2\u02fb\u02fc\3\2\2\2\u02fc\u02fd\3\2\2\2\u02fd\u02fe\5\26\f\2\u02fe"+
		"\u03b7\3\2\2\2\u02ff\u0305\7&\2\2\u0300\u0306\7\\\2\2\u0301\u0303\7\5"+
		"\2\2\u0302\u0304\7C\2\2\u0303\u0302\3\2\2\2\u0303\u0304\3\2\2\2\u0304"+
		"\u0306\3\2\2\2\u0305\u0300\3\2\2\2\u0305\u0301\3\2\2\2\u0306\u0307\3\2"+
		"\2\2\u0307\u0308\7>\2\2\u0308\u0309\7!\2\2\u0309\u030e\7\u00a3\2\2\u030a"+
		"\u030c\5H%\2\u030b\u030d\7\u00e8\2\2\u030c\u030b\3\2\2\2\u030c\u030d\3"+
		"\2\2\2\u030d\u030f\3\2\2\2\u030e\u030a\3\2\2\2\u030f\u0310\3\2\2\2\u0310"+
		"\u030e\3\2\2\2\u0310\u0311\3\2\2\2\u0311\u0312\3\2\2\2\u0312\u0313\5\26"+
		"\f\2\u0313\u03b7\3\2\2\2\u0314\u031a\7&\2\2\u0315\u031b\7\35\2\2\u0316"+
		"\u0318\7\5\2\2\u0317\u0319\7C\2\2\u0318\u0317\3\2\2\2\u0318\u0319\3\2"+
		"\2\2\u0319\u031b\3\2\2\2\u031a\u0315\3\2\2\2\u031a\u0316\3\2\2\2\u031b"+
		"\u031c\3\2\2\2\u031c\u033d\7>\2\2\u031d\u031e\7#\2\2\u031e\u031f\5H%\2"+
		"\u031f\u032c\7\u00ef\2\2\u0320\u0322\5\30\r\2\u0321\u0320\3\2\2\2\u0321"+
		"\u0322\3\2\2\2\u0322\u0324\3\2\2\2\u0323\u0325\5H%\2\u0324\u0323\3\2\2"+
		"\2\u0324\u0325\3\2\2\2\u0325\u0326\3\2\2\2\u0326\u0328\5Z.\2\u0327\u0329"+
		"\7\u00e8\2\2\u0328\u0327\3\2\2\2\u0328\u0329\3\2\2\2\u0329\u032b\3\2\2"+
		"\2\u032a\u0321\3\2\2\2\u032b\u032e\3\2\2\2\u032c\u032a\3\2\2\2\u032c\u032d"+
		"\3\2\2\2\u032d\u032f\3\2\2\2\u032e\u032c\3\2\2\2\u032f\u0330\7\u00f0\2"+
		"\2\u0330\u033e\3\2\2\2\u0331\u0332\7\5\2\2\u0332\u0333\7$\2\2\u0333\u0334"+
		"\7,\2\2\u0334\u0339\7I\2\2\u0335\u0337\5H%\2\u0336\u0338\7\u00e8\2\2\u0337"+
		"\u0336\3\2\2\2\u0337\u0338\3\2\2\2\u0338\u033a\3\2\2\2\u0339\u0335\3\2"+
		"\2\2\u033a\u033b\3\2\2\2\u033b\u0339\3\2\2\2\u033b\u033c\3\2\2\2\u033c"+
		"\u033e\3\2\2\2\u033d\u031d\3\2\2\2\u033d\u0331\3\2\2\2\u033e\u033f\3\2"+
		"\2\2\u033f\u0340\5\26\f\2\u0340\u03b7\3\2\2\2\u0341\u0347\7&\2\2\u0342"+
		"\u0348\7\\\2\2\u0343\u0345\7\5\2\2\u0344\u0346\7C\2\2\u0345\u0344\3\2"+
		"\2\2\u0345\u0346\3\2\2\2\u0346\u0348\3\2\2\2\u0347\u0342\3\2\2\2\u0347"+
		"\u0343\3\2\2\2\u0348\u0349\3\2\2\2\u0349\u034a\7>\2\2\u034a\u034f\7\u0085"+
		"\2\2\u034b\u034d\5H%\2\u034c\u034e\7\u00e8\2\2\u034d\u034c\3\2\2\2\u034d"+
		"\u034e\3\2\2\2\u034e\u0350\3\2\2\2\u034f\u034b\3\2\2\2\u0350\u0351\3\2"+
		"\2\2\u0351\u034f\3\2\2\2\u0351\u0352\3\2\2\2\u0352\u0353\3\2\2\2\u0353"+
		"\u0354\5\26\f\2\u0354\u03b7\3\2\2\2\u0355\u0362\7&\2\2\u0356\u0358\t\b"+
		"\2\2\u0357\u0359\7\u00e8\2\2\u0358\u0357\3\2\2\2\u0358\u0359\3\2\2\2\u0359"+
		"\u035b\3\2\2\2\u035a\u0356\3\2\2\2\u035b\u035c\3\2\2\2\u035c\u035a\3\2"+
		"\2\2\u035c\u035d\3\2\2\2\u035d\u0363\3\2\2\2\u035e\u0360\7\5\2\2\u035f"+
		"\u0361\7C\2\2\u0360\u035f\3\2\2\2\u0360\u0361\3\2\2\2\u0361\u0363\3\2"+
		"\2\2\u0362\u035a\3\2\2\2\u0362\u035e\3\2\2\2\u0363\u0364\3\2\2\2\u0364"+
		"\u0365\7>\2\2\u0365\u0366\7\u0086\2\2\u0366\u036b\7\u0095\2\2\u0367\u0369"+
		"\5H%\2\u0368\u036a\7\u00e8\2\2\u0369\u0368\3\2\2\2\u0369\u036a\3\2\2\2"+
		"\u036a\u036c\3\2\2\2\u036b\u0367\3\2\2\2\u036c\u036d\3\2\2\2\u036d\u036b"+
		"\3\2\2\2\u036d\u036e\3\2\2\2\u036e\u036f\3\2\2\2\u036f\u0370\5\26\f\2"+
		"\u0370\u03b7\3\2\2\2\u0371\u037e\7&\2\2\u0372\u0374\t\t\2\2\u0373\u0375"+
		"\7\u00e8\2\2\u0374\u0373\3\2\2\2\u0374\u0375\3\2\2\2\u0375\u0377\3\2\2"+
		"\2\u0376\u0372\3\2\2\2\u0377\u0378\3\2\2\2\u0378\u0376\3\2\2\2\u0378\u0379"+
		"\3\2\2\2\u0379\u037f\3\2\2\2\u037a\u037c\7\5\2\2\u037b\u037d\7C\2\2\u037c"+
		"\u037b\3\2\2\2\u037c\u037d\3\2\2\2\u037d\u037f\3\2\2\2\u037e\u0376\3\2"+
		"\2\2\u037e\u037a\3\2\2\2\u037f\u0380\3\2\2\2\u0380\u0381\7>\2\2\u0381"+
		"\u0386\7I\2\2\u0382\u0384\5H%\2\u0383\u0385\7\u00e8\2\2\u0384\u0383\3"+
		"\2\2\2\u0384\u0385\3\2\2\2\u0385\u0387\3\2\2\2\u0386\u0382\3\2\2\2\u0387"+
		"\u0388\3\2\2\2\u0388\u0386\3\2\2\2\u0388\u0389\3\2\2\2\u0389\u038a\3\2"+
		"\2\2\u038a\u038b\5\26\f\2\u038b\u03b7\3\2\2\2\u038c\u0392\7&\2\2\u038d"+
		"\u0393\7\20\2\2\u038e\u0390\7\5\2\2\u038f\u0391\7C\2\2\u0390\u038f\3\2"+
		"\2\2\u0390\u0391\3\2\2\2\u0391\u0393\3\2\2\2\u0392\u038d\3\2\2\2\u0392"+
		"\u038e\3\2\2\2\u0393\u0394\3\2\2\2\u0394\u0395\7>\2\2\u0395\u039a\7\u00aa"+
		"\2\2\u0396\u0398\5H%\2\u0397\u0399\7\u00e8\2\2\u0398\u0397\3\2\2\2\u0398"+
		"\u0399\3\2\2\2\u0399\u039b\3\2\2\2\u039a\u0396\3\2\2\2\u039b\u039c\3\2"+
		"\2\2\u039c\u039a\3\2\2\2\u039c\u039d\3\2\2\2\u039d\u039e\3\2\2\2\u039e"+
		"\u039f\5\26\f\2\u039f\u03a4\7&\2\2\u03a0\u03a2\5H%\2\u03a1\u03a3\7\u00e8"+
		"\2\2\u03a2\u03a1\3\2\2\2\u03a2\u03a3\3\2\2\2\u03a3\u03a5\3\2\2\2\u03a4"+
		"\u03a0\3\2\2\2\u03a5\u03a6\3\2\2\2\u03a6\u03a4\3\2\2\2\u03a6\u03a7\3\2"+
		"\2\2\u03a7\u03a8\3\2\2\2\u03a8\u03ad\7\u00b1\2\2\u03a9\u03ab\5H%\2\u03aa"+
		"\u03ac\7\u00e8\2\2\u03ab\u03aa\3\2\2\2\u03ab\u03ac\3\2\2\2\u03ac\u03ae"+
		"\3\2\2\2\u03ad\u03a9\3\2\2\2\u03ae\u03af\3\2\2\2\u03af\u03ad\3\2\2\2\u03af"+
		"\u03b0\3\2\2\2\u03b0\u03b4\3\2\2\2\u03b1\u03b2\7a\2\2\u03b2\u03b3\7b\2"+
		"\2\u03b3\u03b5\7\u0096\2\2\u03b4\u03b1\3\2\2\2\u03b4\u03b5\3\2\2\2\u03b5"+
		"\u03b7\3\2\2\2\u03b6\u0253\3\2\2\2\u03b6\u027b\3\2\2\2\u03b6\u02a5\3\2"+
		"\2\2\u03b6\u02ce\3\2\2\2\u03b6\u02e9\3\2\2\2\u03b6\u02ff\3\2\2\2\u03b6"+
		"\u0314\3\2\2\2\u03b6\u0341\3\2\2\2\u03b6\u0355\3\2\2\2\u03b6\u0371\3\2"+
		"\2\2\u03b6\u038c\3\2\2\2\u03b7\25\3\2\2\2\u03b8\u03c3\7\u00b1\2\2\u03b9"+
		"\u03bb\7\'\2\2\u03ba\u03b9\3\2\2\2\u03ba\u03bb\3\2\2\2\u03bb\u03be\3\2"+
		"\2\2\u03bc\u03bf\5H%\2\u03bd\u03bf\7\u009b\2\2\u03be\u03bc\3\2\2\2\u03be"+
		"\u03bd\3\2\2\2\u03bf\u03c1\3\2\2\2\u03c0\u03c2\7\u00e8\2\2\u03c1\u03c0"+
		"\3\2\2\2\u03c1\u03c2\3\2\2\2\u03c2\u03c4\3\2\2\2\u03c3\u03ba\3\2\2\2\u03c4"+
		"\u03c5\3\2\2\2\u03c5\u03c3\3\2\2\2\u03c5\u03c6\3\2\2\2\u03c6\u03ca\3\2"+
		"\2\2\u03c7\u03c8\7a\2\2\u03c8\u03c9\7&\2\2\u03c9\u03cb\7\u0096\2\2\u03ca"+
		"\u03c7\3\2\2\2\u03ca\u03cb\3\2\2\2\u03cb\27\3\2\2\2\u03cc\u03cd\t\n\2"+
		"\2\u03cd\31\3\2\2\2\u03ce\u03cf\7\20\2\2\u03cf\u03d0\7w\2\2\u03d0\u03d1"+
		"\7Q\2\2\u03d1\u03d2\5\u0142\u00a2\2\u03d2\u03d3\5\34\17\2\u03d3\u03d4"+
		"\7]\2\2\u03d4\u03d6\5H%\2\u03d5\u03d7\5\"\22\2\u03d6\u03d5\3\2\2\2\u03d6"+
		"\u03d7\3\2\2\2\u03d7\u03d9\3\2\2\2\u03d8\u03da\5,\27\2\u03d9\u03d8\3\2"+
		"\2\2\u03d9\u03da\3\2\2\2\u03da\u03db\3\2\2\2\u03db\u03dc\7\u008a\2\2\u03dc"+
		"\u03dd\7\u0100\2\2\u03dd\u0401\3\2\2\2\u03de\u03df\7\20\2\2\u03df\u03e0"+
		"\7Q\2\2\u03e0\u03e1\5\u0142\u00a2\2\u03e1\u03e4\5\34\17\2\u03e2\u03e3"+
		"\7]\2\2\u03e3\u03e5\5H%\2\u03e4\u03e2\3\2\2\2\u03e4\u03e5\3\2\2\2\u03e5"+
		"\u03e7\3\2\2\2\u03e6\u03e8\5\"\22\2\u03e7\u03e6\3\2\2\2\u03e7\u03e8\3"+
		"\2\2\2\u03e8\u03ea\3\2\2\2\u03e9\u03eb\5,\27\2\u03ea\u03e9\3\2\2\2\u03ea"+
		"\u03eb\3\2\2\2\u03eb\u03ee\3\2\2\2\u03ec\u03ed\7\4\2\2\u03ed\u03ef\5\u012e"+
		"\u0098\2\u03ee\u03ec\3\2\2\2\u03ee\u03ef\3\2\2\2\u03ef\u0401\3\2\2\2\u03f0"+
		"\u03f1\7\20\2\2\u03f1\u03f2\7Q\2\2\u03f2\u03f5\5\u0142\u00a2\2\u03f3\u03f4"+
		"\7]\2\2\u03f4\u03f6\5H%\2\u03f5\u03f3\3\2\2\2\u03f5\u03f6\3\2\2\2\u03f6"+
		"\u03f8\3\2\2\2\u03f7\u03f9\5\"\22\2\u03f8\u03f7\3\2\2\2\u03f8\u03f9\3"+
		"\2\2\2\u03f9\u03fb\3\2\2\2\u03fa\u03fc\5,\27\2\u03fb\u03fa\3\2\2\2\u03fb"+
		"\u03fc\3\2\2\2\u03fc\u03fd\3\2\2\2\u03fd\u03fe\7\4\2\2\u03fe\u03ff\5\u012e"+
		"\u0098\2\u03ff\u0401\3\2\2\2\u0400\u03ce\3\2\2\2\u0400\u03de\3\2\2\2\u0400"+
		"\u03f0\3\2\2\2\u0401\33\3\2\2\2\u0402\u0403\7\u00ef\2\2\u0403\u0408\5"+
		"\36\20\2\u0404\u0405\7\u00e8\2\2\u0405\u0407\5\36\20\2\u0406\u0404\3\2"+
		"\2\2\u0407\u040a\3\2\2\2\u0408\u0406\3\2\2\2\u0408\u0409\3\2\2\2\u0409"+
		"\u040b\3\2\2\2\u040a\u0408\3\2\2\2\u040b\u040c\7\u00f0\2\2\u040c\35\3"+
		"\2\2\2\u040d\u040e\5H%\2\u040e\u040f\5 \21\2\u040f\37\3\2\2\2\u0410\u0411"+
		"\5Z.\2\u0411!\3\2\2\2\u0412\u0413\7a\2\2\u0413\u0414\7\u00ef\2\2\u0414"+
		"\u0419\5$\23\2\u0415\u0416\7\u00e8\2\2\u0416\u0418\5$\23\2\u0417\u0415"+
		"\3\2\2\2\u0418\u041b\3\2\2\2\u0419\u0417\3\2\2\2\u0419\u041a\3\2\2\2\u041a"+
		"\u041c\3\2\2\2\u041b\u0419\3\2\2\2\u041c\u041d\7\u00f0\2\2\u041d#\3\2"+
		"\2\2\u041e\u041f\7\u0100\2\2\u041f\u0420\7\u00e5\2\2\u0420\u0421\5\u00ac"+
		"W\2\u0421%\3\2\2\2\u0422\u0423\7]\2\2\u0423\u0424\5H%\2\u0424\'\3\2\2"+
		"\2\u0425\u0426\7\u00aa\2\2\u0426\u0427\5*\26\2\u0427)\3\2\2\2\u0428\u0429"+
		"\5H%\2\u0429+\3\2\2\2\u042a\u042f\5.\30\2\u042b\u042f\5\64\33\2\u042c"+
		"\u042f\5<\37\2\u042d\u042f\5B\"\2\u042e\u042a\3\2\2\2\u042e\u042b\3\2"+
		"\2\2\u042e\u042c\3\2\2\2\u042e\u042d\3\2\2\2\u042f-\3\2\2\2\u0430\u0431"+
		"\7\u0098\2\2\u0431\u0432\7e\2\2\u0432\u0433\7\u009e\2\2\u0433\u0434\7"+
		"\u00ef\2\2\u0434\u0435\5\u0154\u00ab\2\u0435\u0436\7\u00f0\2\2\u0436\u0437"+
		"\7\u00ef\2\2\u0437\u0438\5\60\31\2\u0438\u0439\7\u00f0\2\2\u0439/\3\2"+
		"\2\2\u043a\u043f\5\62\32\2\u043b\u043c\7\u00e8\2\2\u043c\u043e\5\62\32"+
		"\2\u043d\u043b\3\2\2\2\u043e\u0441\3\2\2\2\u043f\u043d\3\2\2\2\u043f\u0440"+
		"\3\2\2\2\u0440\61\3\2\2\2\u0441\u043f\3\2\2\2\u0442\u0443\7\u0098\2\2"+
		"\u0443\u0444\5D#\2\u0444\u0445\7\u00b3\2\2\u0445\u0446\7\u0088\2\2\u0446"+
		"\u0452\7\u00ac\2\2\u0447\u0448\7\u00ef\2\2\u0448\u0449\5\u00a8U\2\u0449"+
		"\u044a\7\u00f0\2\2\u044a\u0453\3\2\2\2\u044b\u044d\7\u00ef\2\2\u044c\u044b"+
		"\3\2\2\2\u044c\u044d\3\2\2\2\u044d\u044e\3\2\2\2\u044e\u0450\7\u008c\2"+
		"\2\u044f\u0451\7\u00f0\2\2\u0450\u044f\3\2\2\2\u0450\u0451\3\2\2\2\u0451"+
		"\u0453\3\2\2\2\u0452\u0447\3\2\2\2\u0452\u044c\3\2\2\2\u0453\63\3\2\2"+
		"\2\u0454\u0455\7\u0098\2\2\u0455\u0456\7e\2\2\u0456\u0457\7~\2\2\u0457"+
		"\u0458\7\u00ef\2\2\u0458\u0459\5\u0154\u00ab\2\u0459\u045f\7\u00f0\2\2"+
		"\u045a\u045b\7\u00ef\2\2\u045b\u045c\5\66\34\2\u045c\u045d\7\u00f0\2\2"+
		"\u045d\u0460\3\2\2\2\u045e\u0460\5:\36\2\u045f\u045a\3\2\2\2\u045f\u045e"+
		"\3\2\2\2\u0460\65\3\2\2\2\u0461\u0466\58\35\2\u0462\u0463\7\u00e8\2\2"+
		"\u0463\u0465\58\35\2\u0464\u0462\3\2\2\2\u0465\u0468\3\2\2\2\u0466\u0464"+
		"\3\2\2\2\u0466\u0467\3\2\2\2\u0467\67\3\2\2\2\u0468\u0466\3\2\2\2\u0469"+
		"\u046a\7\u0098\2\2\u046a\u046b\5D#\2\u046b9\3\2\2\2\u046c\u046d\7\u0099"+
		"\2\2\u046d\u046e\5\u00acW\2\u046e;\3\2\2\2\u046f\u0470\7\u0098\2\2\u0470"+
		"\u0471\7e\2\2\u0471\u0472\7\u0089\2\2\u0472\u0473\7\u00ef\2\2\u0473\u0474"+
		"\5\u0154\u00ab\2\u0474\u0475\7\u00f0\2\2\u0475\u0476\7\u00ef\2\2\u0476"+
		"\u0477\5> \2\u0477\u0478\7\u00f0\2\2\u0478=\3\2\2\2\u0479\u047e\5@!\2"+
		"\u047a\u047b\7\u00e8\2\2\u047b\u047d\5@!\2\u047c\u047a\3\2\2\2\u047d\u0480"+
		"\3\2\2\2\u047e\u047c\3\2\2\2\u047e\u047f\3\2\2\2\u047f?\3\2\2\2\u0480"+
		"\u047e\3\2\2\2\u0481\u0482\7\u0098\2\2\u0482\u0483\5D#\2\u0483\u0485\7"+
		"\u00b3\2\2\u0484\u0486\7,\2\2\u0485\u0484\3\2\2\2\u0485\u0486\3\2\2\2"+
		"\u0486\u0487\3\2\2\2\u0487\u0488\7\u00ef\2\2\u0488\u0489\5\u016c\u00b7"+
		"\2\u0489\u048a\7\u00f0\2\2\u048aA\3\2\2\2\u048b\u048c\7\u0098\2\2\u048c"+
		"\u048d\7e\2\2\u048d\u048e\7j\2\2\u048e\u048f\5\34\17\2\u048fC\3\2\2\2"+
		"\u0490\u0491\5H%\2\u0491E\3\2\2\2\u0492\u0493\7s\2\2\u0493\u0494\7Q\2"+
		"\2\u0494\u0496\5\u0142\u00a2\2\u0495\u0497\7\u009c\2\2\u0496\u0495\3\2"+
		"\2\2\u0496\u0497\3\2\2\2\u0497G\3\2\2\2\u0498\u049b\7\u00ff\2\2\u0499"+
		"\u049b\5J&\2\u049a\u0498\3\2\2\2\u049a\u0499\3\2\2\2\u049bI\3\2\2\2\u049c"+
		"\u049d\t\13\2\2\u049dK\3\2\2\2\u049e\u04a1\5\u0080A\2\u049f\u04a1\5N("+
		"\2\u04a0\u049e\3\2\2\2\u04a0\u049f\3\2\2\2\u04a1M\3\2\2\2\u04a2\u04a6"+
		"\7\u0100\2\2\u04a3\u04a6\5P)\2\u04a4\u04a6\5X-\2\u04a5\u04a2\3\2\2\2\u04a5"+
		"\u04a3\3\2\2\2\u04a5\u04a4\3\2\2\2\u04a6O\3\2\2\2\u04a7\u04ab\5T+\2\u04a8"+
		"\u04ab\5R*\2\u04a9\u04ab\5V,\2\u04aa\u04a7\3\2\2\2\u04aa\u04a8\3\2\2\2"+
		"\u04aa\u04a9\3\2\2\2\u04abQ\3\2\2\2\u04ac\u04ad\7\u00d5\2\2\u04ad\u04ae"+
		"\7\u0100\2\2\u04aeS\3\2\2\2\u04af\u04b0\7\u00d7\2\2\u04b0\u04b1\7\u0100"+
		"\2\2\u04b1U\3\2\2\2\u04b2\u04b3\7\u00d4\2\2\u04b3\u04b4\7\u0100\2\2\u04b4"+
		"W\3\2\2\2\u04b5\u04b6\t\f\2\2\u04b6Y\3\2\2\2\u04b7\u04b8\5\\/\2\u04b8"+
		"[\3\2\2\2\u04b9\u04c3\5`\61\2\u04ba\u04c3\5d\63\2\u04bb\u04c3\5f\64\2"+
		"\u04bc\u04c3\5h\65\2\u04bd\u04c3\5p9\2\u04be\u04c3\5r:\2\u04bf\u04c3\5"+
		"t;\2\u04c0\u04c3\5v<\2\u04c1\u04c3\5^\60\2\u04c2\u04b9\3\2\2\2\u04c2\u04ba"+
		"\3\2\2\2\u04c2\u04bb\3\2\2\2\u04c2\u04bc\3\2\2\2\u04c2\u04bd\3\2\2\2\u04c2"+
		"\u04be\3\2\2\2\u04c2\u04bf\3\2\2\2\u04c2\u04c0\3\2\2\2\u04c2\u04c1\3\2"+
		"\2\2\u04c3]\3\2\2\2\u04c4\u04c5\7\u00de\2\2\u04c5_\3\2\2\2\u04c6\u04c8"+
		"\7g\2\2\u04c7\u04c9\5b\62\2\u04c8\u04c7\3\2\2\2\u04c8\u04c9\3\2\2\2\u04c9"+
		"\u04de\3\2\2\2\u04ca\u04cc\7\u00d0\2\2\u04cb\u04cd\5b\62\2\u04cc\u04cb"+
		"\3\2\2\2\u04cc\u04cd\3\2\2\2\u04cd\u04de\3\2\2\2\u04ce\u04cf\7g\2\2\u04cf"+
		"\u04d1\7\u00b6\2\2\u04d0\u04d2\5b\62\2\u04d1\u04d0\3\2\2\2\u04d1\u04d2"+
		"\3\2\2\2\u04d2\u04de\3\2\2\2\u04d3\u04d4\7\u00d0\2\2\u04d4\u04d6\7\u00b6"+
		"\2\2\u04d5\u04d7\5b\62\2\u04d6\u04d5\3\2\2\2\u04d6\u04d7\3\2\2\2\u04d7"+
		"\u04de\3\2\2\2\u04d8\u04da\7\u00d1\2\2\u04d9\u04db\5b\62\2\u04da\u04d9"+
		"\3\2\2\2\u04da\u04db\3\2\2\2\u04db\u04de\3\2\2\2\u04dc\u04de\7\u00d9\2"+
		"\2\u04dd\u04c6\3\2\2\2\u04dd\u04ca\3\2\2\2\u04dd\u04ce\3\2\2\2\u04dd\u04d3"+
		"\3\2\2\2\u04dd\u04d8\3\2\2\2\u04dd\u04dc\3\2\2\2\u04dea\3\2\2\2\u04df"+
		"\u04e0\7\u00ef\2\2\u04e0\u04e1\7\u00fb\2\2\u04e1\u04e2\7\u00f0\2\2\u04e2"+
		"c\3\2\2\2\u04e3\u04e4\7\u0093\2\2\u04e4\u04e6\7g\2\2\u04e5\u04e7\5b\62"+
		"\2\u04e6\u04e5\3\2\2\2\u04e6\u04e7\3\2\2\2\u04e7\u0507\3\2\2\2\u04e8\u04e9"+
		"\7\u0093\2\2\u04e9\u04eb\7\u00d0\2\2\u04ea\u04ec\5b\62\2\u04eb\u04ea\3"+
		"\2\2\2\u04eb\u04ec\3\2\2\2\u04ec\u0507\3\2\2\2\u04ed\u04ef\7\u00d2\2\2"+
		"\u04ee\u04f0\5b\62\2\u04ef\u04ee\3\2\2\2\u04ef\u04f0\3\2\2\2\u04f0\u0507"+
		"\3\2\2\2\u04f1\u04f2\7\u0093\2\2\u04f2\u04f3\7g\2\2\u04f3\u04f5\7\u00b6"+
		"\2\2\u04f4\u04f6\5b\62\2\u04f5\u04f4\3\2\2\2\u04f5\u04f6\3\2\2\2\u04f6"+
		"\u0507\3\2\2\2\u04f7\u04f8\7\u0093\2\2\u04f8\u04f9\7\u00d0\2\2\u04f9\u04fb"+
		"\7\u00b6\2\2\u04fa\u04fc\5b\62\2\u04fb\u04fa\3\2\2\2\u04fb\u04fc\3\2\2"+
		"\2\u04fc\u0507\3\2\2\2\u04fd\u04fe\7\u00d2\2\2\u04fe\u0500\7\u00b6\2\2"+
		"\u04ff\u0501\5b\62\2\u0500\u04ff\3\2\2\2\u0500\u0501\3\2\2\2\u0501\u0507"+
		"\3\2\2\2\u0502\u0504\7\u00d3\2\2\u0503\u0505\5b\62\2\u0504\u0503\3\2\2"+
		"\2\u0504\u0505\3\2\2\2\u0505\u0507\3\2\2\2\u0506\u04e3\3\2\2\2\u0506\u04e8"+
		"\3\2\2\2\u0506\u04ed\3\2\2\2\u0506\u04f1\3\2\2\2\u0506\u04f7\3\2\2\2\u0506"+
		"\u04fd\3\2\2\2\u0506\u0502\3\2\2\2\u0507e\3\2\2\2\u0508\u050a\7\u00dc"+
		"\2\2\u0509\u050b\5b\62\2\u050a\u0509\3\2\2\2\u050a\u050b\3\2\2\2\u050b"+
		"\u0511\3\2\2\2\u050c\u050e\7\u00dd\2\2\u050d\u050f\5b\62\2\u050e\u050d"+
		"\3\2\2\2\u050e\u050f\3\2\2\2\u050f\u0511\3\2\2\2\u0510\u0508\3\2\2\2\u0510"+
		"\u050c\3\2\2\2\u0511g\3\2\2\2\u0512\u0515\5j\66\2\u0513\u0515\5l\67\2"+
		"\u0514\u0512\3\2\2\2\u0514\u0513\3\2\2\2\u0515i\3\2\2\2\u0516\u0518\7"+
		"\u00ce\2\2\u0517\u0519\5n8\2\u0518\u0517\3\2\2\2\u0518\u0519\3\2\2\2\u0519"+
		"\u052c\3\2\2\2\u051a\u051c\7\u00cf\2\2\u051b\u051d\5n8\2\u051c\u051b\3"+
		"\2\2\2\u051c\u051d\3\2\2\2\u051d\u052c\3\2\2\2\u051e\u0520\7o\2\2\u051f"+
		"\u0521\5n8\2\u0520\u051f\3\2\2\2\u0520\u0521\3\2\2\2\u0521\u052c\3\2\2"+
		"\2\u0522\u052c\7\u00c0\2\2\u0523\u052c\7\u00c4\2\2\u0524\u052c\7\u00c1"+
		"\2\2\u0525\u052c\7\u00c5\2\2\u0526\u052c\7\u00c2\2\2\u0527\u052c\7\u00c6"+
		"\2\2\u0528\u052c\7\u00c7\2\2\u0529\u052c\7\u00c3\2\2\u052a\u052c\7\u00c8"+
		"\2\2\u052b\u0516\3\2\2\2\u052b\u051a\3\2\2\2\u052b\u051e\3\2\2\2\u052b"+
		"\u0522\3\2\2\2\u052b\u0523\3\2\2\2\u052b\u0524\3\2\2\2\u052b\u0525\3\2"+
		"\2\2\u052b\u0526\3\2\2\2\u052b\u0527\3\2\2\2\u052b\u0528\3\2\2\2\u052b"+
		"\u0529\3\2\2\2\u052b\u052a\3\2\2\2\u052ck\3\2\2\2\u052d\u052f\7\u00cc"+
		"\2\2\u052e\u0530\5n8\2\u052f\u052e\3\2\2\2\u052f\u0530\3\2\2\2\u0530\u0538"+
		"\3\2\2\2\u0531\u0538\7\u00c9\2\2\u0532\u0538\7\u00cb\2\2\u0533\u0538\7"+
		"\u00ca\2\2\u0534\u0538\7\u00cd\2\2\u0535\u0536\7\u00cd\2\2\u0536\u0538"+
		"\7\u009a\2\2\u0537\u052d\3\2\2\2\u0537\u0531\3\2\2\2\u0537\u0532\3\2\2"+
		"\2\u0537\u0533\3\2\2\2\u0537\u0534\3\2\2\2\u0537\u0535\3\2\2\2\u0538m"+
		"\3\2\2\2\u0539\u053a\7\u00ef\2\2\u053a\u053b\7\u00fb\2\2\u053b\u0542\7"+
		"\u00f0\2\2\u053c\u053d\7\u00ef\2\2\u053d\u053e\7\u00fb\2\2\u053e\u053f"+
		"\7\u00e8\2\2\u053f\u0540\7\u00fb\2\2\u0540\u0542\7\u00f0\2\2\u0541\u0539"+
		"\3\2\2\2\u0541\u053c\3\2\2\2\u0542o\3\2\2\2\u0543\u0544\t\r\2\2\u0544"+
		"q\3\2\2\2\u0545\u0553\7\u00d4\2\2\u0546\u0553\7\u00d5\2\2\u0547\u0548"+
		"\7\u00d5\2\2\u0548\u0549\7a\2\2\u0549\u054a\7\u00d5\2\2\u054a\u0553\7"+
		"\u00bb\2\2\u054b\u0553\7\u00d6\2\2\u054c\u0553\7\u00d7\2\2\u054d\u054e"+
		"\7\u00d7\2\2\u054e\u054f\7a\2\2\u054f\u0550\7\u00d5\2\2\u0550\u0553\7"+
		"\u00bb\2\2\u0551\u0553\7\u00d8\2\2\u0552\u0545\3\2\2\2\u0552\u0546\3\2"+
		"\2\2\u0552\u0547\3\2\2\2\u0552\u054b\3\2\2\2\u0552\u054c\3\2\2\2\u0552"+
		"\u054d\3\2\2\2\u0552\u0551\3\2\2\2\u0553s\3\2\2\2\u0554\u0556\7\u00be"+
		"\2\2\u0555\u0557\5b\62\2\u0556\u0555\3\2\2\2\u0556\u0557\3\2\2\2\u0557"+
		"\u0562\3\2\2\2\u0558\u055a\7\u00bf\2\2\u0559\u055b\5b\62\2\u055a\u0559"+
		"\3\2\2\2\u055a\u055b\3\2\2\2\u055b\u0562\3\2\2\2\u055c\u055d\7\u00be\2"+
		"\2\u055d\u055f\7\u00b6\2\2\u055e\u0560\5b\62\2\u055f\u055e\3\2\2\2\u055f"+
		"\u0560\3\2\2\2\u0560\u0562\3\2\2\2\u0561\u0554\3\2\2\2\u0561\u0558\3\2"+
		"\2\2\u0561\u055c\3\2\2\2\u0562u\3\2\2\2\u0563\u0565\7\u00da\2\2\u0564"+
		"\u0566\5b\62\2\u0565\u0564\3\2\2\2\u0565\u0566\3\2\2\2\u0566\u0571\3\2"+
		"\2\2\u0567\u0568\7\u00da\2\2\u0568\u056a\7\u00b6\2\2\u0569\u056b\5b\62"+
		"\2\u056a\u0569\3\2\2\2\u056a\u056b\3\2\2\2\u056b\u0571\3\2\2\2\u056c\u056e"+
		"\7\u00db\2\2\u056d\u056f\5b\62\2\u056e\u056d\3\2\2\2\u056e\u056f\3\2\2"+
		"\2\u056f\u0571\3\2\2\2\u0570\u0563\3\2\2\2\u0570\u0567\3\2\2\2\u0570\u056c"+
		"\3\2\2\2\u0571w\3\2\2\2\u0572\u0575\5z>\2\u0573\u0575\5|?\2\u0574\u0572"+
		"\3\2\2\2\u0574\u0573\3\2\2\2\u0575y\3\2\2\2\u0576\u0577\7\u00ef\2\2\u0577"+
		"\u0578\5\u00a8U\2\u0578\u0579\7\u00f0\2\2\u0579{\3\2\2\2\u057a\u0582\5"+
		"~@\2\u057b\u0582\5\u0150\u00a9\2\u057c\u0582\5\u0084C\2\u057d\u0582\5"+
		"\u0156\u00ac\2\u057e\u0582\5\u0090I\2\u057f\u0582\5\u00a2R\2\u0580\u0582"+
		"\5\u018a\u00c6\2\u0581\u057a\3\2\2\2\u0581\u057b\3\2\2\2\u0581\u057c\3"+
		"\2\2\2\u0581\u057d\3\2\2\2\u0581\u057e\3\2\2\2\u0581\u057f\3\2\2\2\u0581"+
		"\u0580\3\2\2\2\u0582}\3\2\2\2\u0583\u0584\5L\'\2\u0584\177\3\2\2\2\u0585"+
		"\u0586\t\16\2\2\u0586\u0081\3\2\2\2\u0587\u0589\5\u00b6\\\2\u0588\u0587"+
		"\3\2\2\2\u0588\u0589\3\2\2\2\u0589\u058a\3\2\2\2\u058a\u058b\5\u0080A"+
		"\2\u058b\u0083\3\2\2\2\u058c\u058d\5\u0086D\2\u058d\u0085\3\2\2\2\u058e"+
		"\u058f\7k\2\2\u058f\u0590\7\u00ef\2\2\u0590\u0591\7\u00f3\2\2\u0591\u0597"+
		"\7\u00f0\2\2\u0592\u0594\5\u0088E\2\u0593\u0595\5\u008cG\2\u0594\u0593"+
		"\3\2\2\2\u0594\u0595\3\2\2\2\u0595\u0597\3\2\2\2\u0596\u058e\3\2\2\2\u0596"+
		"\u0592\3\2\2\2\u0597\u0087\3\2\2\2\u0598\u0599\5\u008aF\2\u0599\u059b"+
		"\7\u00ef\2\2\u059a\u059c\5\u014e\u00a8\2\u059b\u059a\3\2\2\2\u059b\u059c"+
		"\3\2\2\2\u059c\u059d\3\2\2\2\u059d\u059e\5\u00a8U\2\u059e\u059f\7\u00f0"+
		"\2\2\u059f\u0089\3\2\2\2\u05a0\u05a1\t\17\2\2\u05a1\u008b\3\2\2\2\u05a2"+
		"\u05a3\7y\2\2\u05a3\u05a4\7\u00ef\2\2\u05a4\u05a5\7`\2\2\u05a5\u05a6\5"+
		"\u0118\u008d\2\u05a6\u05a7\7\u00f0\2\2\u05a7\u008d\3\2\2\2\u05a8\u05a9"+
		"\7}\2\2\u05a9\u05aa\7\u00ef\2\2\u05aa\u05ab\5\u0154\u00ab\2\u05ab\u05ac"+
		"\7\u00f0\2\2\u05ac\u008f\3\2\2\2\u05ad\u05ae\5\u0094K\2\u05ae\u0091\3"+
		"\2\2\2\u05af\u05b0\7\u0094\2\2\u05b0\u05b1\7\u00ef\2\2\u05b1\u05b2\5\u00ac"+
		"W\2\u05b2\u05b3\7\u00e8\2\2\u05b3\u05b4\5\u00d2j\2\u05b4\u05b5\7\u00f0"+
		"\2\2\u05b5\u05c2\3\2\2\2\u05b6\u05b7\7i\2\2\u05b7\u05b8\7\u00ef\2\2\u05b8"+
		"\u05bb\5\u00acW\2\u05b9\u05ba\7\u00e8\2\2\u05ba\u05bc\5\u00d2j\2\u05bb"+
		"\u05b9\3\2\2\2\u05bc\u05bd\3\2\2\2\u05bd\u05bb\3\2\2\2\u05bd\u05be\3\2"+
		"\2\2\u05be\u05bf\3\2\2\2\u05bf\u05c0\7\u00f0\2\2\u05c0\u05c2\3\2\2\2\u05c1"+
		"\u05af\3\2\2\2\u05c1\u05b6\3\2\2\2\u05c2\u0093\3\2\2\2\u05c3\u05c6\5\u0096"+
		"L\2\u05c4\u05c6\5\u0098M\2\u05c5\u05c3\3\2\2\2\u05c5\u05c4\3\2\2\2\u05c6"+
		"\u0095\3\2\2\2\u05c7\u05c8\7\f\2\2\u05c8\u05ca\5\u00d2j\2\u05c9\u05cb"+
		"\5\u009aN\2\u05ca\u05c9\3\2\2\2\u05cb\u05cc\3\2\2\2\u05cc\u05ca\3\2\2"+
		"\2\u05cc\u05cd\3\2\2\2\u05cd\u05cf\3\2\2\2\u05ce\u05d0\5\u009eP\2\u05cf"+
		"\u05ce\3\2\2\2\u05cf\u05d0\3\2\2\2\u05d0\u05d1\3\2\2\2\u05d1\u05d2\7\32"+
		"\2\2\u05d2\u0097\3\2\2\2\u05d3\u05d5\7\f\2\2\u05d4\u05d6\5\u009cO\2\u05d5"+
		"\u05d4\3\2\2\2\u05d6\u05d7\3\2\2\2\u05d7\u05d5\3\2\2\2\u05d7\u05d8\3\2"+
		"\2\2\u05d8\u05da\3\2\2\2\u05d9\u05db\5\u009eP\2\u05da\u05d9\3\2\2\2\u05da"+
		"\u05db\3\2\2\2\u05db\u05dc\3\2\2\2\u05dc\u05dd\7\32\2\2\u05dd\u0099\3"+
		"\2\2\2\u05de\u05df\7_\2\2\u05df\u05e0\5\u0118\u008d\2\u05e0\u05e1\7T\2"+
		"\2\u05e1\u05e2\5\u00a0Q\2\u05e2\u009b\3\2\2\2\u05e3\u05e4\7_\2\2\u05e4"+
		"\u05e5\5\u0118\u008d\2\u05e5\u05e6\7T\2\2\u05e6\u05e7\5\u00a0Q\2\u05e7"+
		"\u009d\3\2\2\2\u05e8\u05e9\7\33\2\2\u05e9\u05ea\5\u00a0Q\2\u05ea\u009f"+
		"\3\2\2\2\u05eb\u05ee\5\u00a8U\2\u05ec\u05ee\7<\2\2\u05ed\u05eb\3\2\2\2"+
		"\u05ed\u05ec\3\2\2\2\u05ee\u00a1\3\2\2\2\u05ef\u05f0\7\r\2\2\u05f0\u05f1"+
		"\7\u00ef\2\2\u05f1\u05f2\5\u00a4S\2\u05f2\u05f3\7\4\2\2\u05f3\u05f4\5"+
		"\u00a6T\2\u05f4\u05f5\7\u00f0\2\2\u05f5\u00a3\3\2\2\2\u05f6\u05f7\5\u00a8"+
		"U\2\u05f7\u00a5\3\2\2\2\u05f8\u05f9\5Z.\2\u05f9\u00a7\3\2\2\2\u05fa\u05fe"+
		"\5\u00aaV\2\u05fb\u05fe\5\u00e6t\2\u05fc\u05fe\5\u00d2j\2\u05fd\u05fa"+
		"\3\2\2\2\u05fd\u05fb\3\2\2\2\u05fd\u05fc\3\2\2\2\u05fe\u00a9\3\2\2\2\u05ff"+
		"\u0603\5\u00acW\2\u0600\u0603\5\u00c2b\2\u0601\u0603\7<\2\2\u0602\u05ff"+
		"\3\2\2\2\u0602\u0600\3\2\2\2\u0602\u0601\3\2\2\2\u0603\u00ab\3\2\2\2\u0604"+
		"\u0609\5\u00aeX\2\u0605\u0606\t\20\2\2\u0606\u0608\5\u00aeX\2\u0607\u0605"+
		"\3\2\2\2\u0608\u060b\3\2\2\2\u0609\u0607\3\2\2\2\u0609\u060a\3\2\2\2\u060a"+
		"\u00ad\3\2\2\2\u060b\u0609\3\2\2\2\u060c\u0611\5\u00b0Y\2\u060d\u060e"+
		"\t\21\2\2\u060e\u0610\5\u00b0Y\2\u060f\u060d\3\2\2\2\u0610\u0613\3\2\2"+
		"\2\u0611\u060f\3\2\2\2\u0611\u0612\3\2\2\2\u0612\u00af\3\2\2\2\u0613\u0611"+
		"\3\2\2\2\u0614\u0616\5\u00b6\\\2\u0615\u0614\3\2\2\2\u0615\u0616\3\2\2"+
		"\2\u0616\u0617\3\2\2\2\u0617\u0618\5\u00b4[\2\u0618\u00b1\3\2\2\2\u0619"+
		"\u061a\7\u00ef\2\2\u061a\u061f\5\u00acW\2\u061b\u061c\7\u00e8\2\2\u061c"+
		"\u061e\5\u00acW\2\u061d\u061b\3\2\2\2\u061e\u0621\3\2\2\2\u061f\u061d"+
		"\3\2\2\2\u061f\u0620\3\2\2\2\u0620\u0622\3\2\2\2\u0621\u061f\3\2\2\2\u0622"+
		"\u0623\7\u00f0\2\2\u0623\u00b3\3\2\2\2\u0624\u0629\5x=\2\u0625\u0626\7"+
		"\u00e3\2\2\u0626\u0628\5\u00a6T\2\u0627\u0625\3\2\2\2\u0628\u062b\3\2"+
		"\2\2\u0629\u0627\3\2\2\2\u0629\u062a\3\2\2\2\u062a\u062e\3\2\2\2\u062b"+
		"\u0629\3\2\2\2\u062c\u062e\5\u00b8]\2\u062d\u0624\3\2\2\2\u062d\u062c"+
		"\3\2\2\2\u062e\u00b5\3\2\2\2\u062f\u0630\t\20\2\2\u0630\u00b7\3\2\2\2"+
		"\u0631\u0632\5\u00ba^\2\u0632\u00b9\3\2\2\2\u0633\u0634\7x\2\2\u0634\u0635"+
		"\7\u00ef\2\2\u0635\u0636\5\u00bc_\2\u0636\u0637\7%\2\2\u0637\u0638\5\u00c0"+
		"a\2\u0638\u0639\7\u00f0\2\2\u0639\u00bb\3\2\2\2\u063a\u063e\5\u0184\u00c3"+
		"\2\u063b\u063e\5\u00be`\2\u063c\u063e\5\u0188\u00c5\2\u063d\u063a\3\2"+
		"\2\2\u063d\u063b\3\2\2\2\u063d\u063c\3\2\2\2\u063e\u00bd\3\2\2\2\u063f"+
		"\u0640\t\22\2\2\u0640\u00bf\3\2\2\2\u0641\u0644\5\u0150\u00a9\2\u0642"+
		"\u0644\5P)\2\u0643\u0641\3\2\2\2\u0643\u0642\3\2\2\2\u0644\u00c1\3\2\2"+
		"\2\u0645\u0646\5\u00c4c\2\u0646\u00c3\3\2\2\2\u0647\u064c\5\u00c6d\2\u0648"+
		"\u0649\7\u00e9\2\2\u0649\u064b\5\u00c6d\2\u064a\u0648\3\2\2\2\u064b\u064e"+
		"\3\2\2\2\u064c\u064a\3\2\2\2\u064c\u064d\3\2\2\2\u064d\u00c5\3\2\2\2\u064e"+
		"\u064c\3\2\2\2\u064f\u0650\5\u00c8e\2\u0650\u00c7\3\2\2\2\u0651\u0654"+
		"\5x=\2\u0652\u0654\5\u00caf\2\u0653\u0651\3\2\2\2\u0653\u0652\3\2\2\2"+
		"\u0654\u00c9\3\2\2\2\u0655\u0656\5\u00ccg\2\u0656\u00cb\3\2\2\2\u0657"+
		"\u0658\7\u00b0\2\2\u0658\u0659\7\u00ef\2\2\u0659\u065a\5\u00ceh\2\u065a"+
		"\u065b\7\u00f0\2\2\u065b\u00cd\3\2\2\2\u065c\u065e\5\u00d0i\2\u065d\u065c"+
		"\3\2\2\2\u065d\u065e\3\2\2\2\u065e\u0660\3\2\2\2\u065f\u0661\5\u00c4c"+
		"\2\u0660\u065f\3\2\2\2\u0660\u0661\3\2\2\2\u0661\u0662\3\2\2\2\u0662\u0664"+
		"\7%\2\2\u0663\u065d\3\2\2\2\u0663\u0664\3\2\2\2\u0664\u0665\3\2\2\2\u0665"+
		"\u066b\5\u00c4c\2\u0666\u0667\5\u00c4c\2\u0667\u0668\7\u00e8\2\2\u0668"+
		"\u0669\5\u00c4c\2\u0669\u066b\3\2\2\2\u066a\u0663\3\2\2\2\u066a\u0666"+
		"\3\2\2\2\u066b\u00cf\3\2\2\2\u066c\u066d\t\23\2\2\u066d\u00d1\3\2\2\2"+
		"\u066e\u066f\5\u00d4k\2\u066f\u00d3\3\2\2\2\u0670\u0675\5\u00d6l\2\u0671"+
		"\u0672\7A\2\2\u0672\u0674\5\u00d4k\2\u0673\u0671\3\2\2\2\u0674\u0677\3"+
		"\2\2\2\u0675\u0673\3\2\2\2\u0675\u0676\3\2\2\2\u0676\u00d5\3\2\2\2\u0677"+
		"\u0675\3\2\2\2\u0678\u067d\5\u00d8m\2\u0679\u067a\7\6\2\2\u067a\u067c"+
		"\5\u00d6l\2\u067b\u0679\3\2\2\2\u067c\u067f\3\2\2\2\u067d\u067b\3\2\2"+
		"\2\u067d\u067e\3\2\2\2\u067e\u00d7\3\2\2\2\u067f\u067d\3\2\2\2\u0680\u0684"+
		"\5\u00dan\2\u0681\u0682\7;\2\2\u0682\u0684\5\u00dan\2\u0683\u0680\3\2"+
		"\2\2\u0683\u0681\3\2\2\2\u0684\u00d9\3\2\2\2\u0685\u0687\5\u00e0q\2\u0686"+
		"\u0688\5\u00dco\2\u0687\u0686\3\2\2\2\u0687\u0688\3\2\2\2\u0688\u00db"+
		"\3\2\2\2\u0689\u068b\7\63\2\2\u068a\u068c\7;\2\2\u068b\u068a\3\2\2\2\u068b"+
		"\u068c\3\2\2\2\u068c\u068d\3\2\2\2\u068d\u068e\5\u00dep\2\u068e\u00dd"+
		"\3\2\2\2\u068f\u0690\t\f\2\2\u0690\u00df\3\2\2\2\u0691\u0694\5\u015e\u00b0"+
		"\2\u0692\u0694\5\u00e2r\2\u0693\u0691\3\2\2\2\u0693\u0692\3\2\2\2\u0694"+
		"\u00e1\3\2\2\2\u0695\u0698\5\u00e4s\2\u0696\u0698\5|?\2\u0697\u0695\3"+
		"\2\2\2\u0697\u0696\3\2\2\2\u0698\u00e3\3\2\2\2\u0699\u069a\7\u00ef\2\2"+
		"\u069a\u069b\5\u00d2j\2\u069b\u069c\7\u00f0\2\2\u069c\u00e5\3\2\2\2\u069d"+
		"\u06a0\5\u00e8u\2\u069e\u06a0\5\u00eav\2\u069f\u069d\3\2\2\2\u069f\u069e"+
		"\3\2\2\2\u06a0\u00e7\3\2\2\2\u06a1\u06a2\5|?\2\u06a2\u00e9\3\2\2\2\u06a3"+
		"\u06a4\7<\2\2\u06a4\u00eb\3\2\2\2\u06a5\u06a8\5\u00e8u\2\u06a6\u06a8\5"+
		"\u00eex\2\u06a7\u06a5\3\2\2\2\u06a7\u06a6\3\2\2\2\u06a8\u00ed\3\2\2\2"+
		"\u06a9\u06ac\5\u00aaV\2\u06aa\u06ac\5\u00e2r\2\u06ab\u06a9\3\2\2\2\u06ab"+
		"\u06aa\3\2\2\2\u06ac\u00ef\3\2\2\2\u06ad\u06af\5\u00f2z\2\u06ae\u06b0"+
		"\5\u0116\u008c\2\u06af\u06ae\3\2\2\2\u06af\u06b0\3\2\2\2\u06b0\u06b2\3"+
		"\2\2\2\u06b1\u06b3\5\u011a\u008e\2\u06b2\u06b1\3\2\2\2\u06b2\u06b3\3\2"+
		"\2\2\u06b3\u06b5\3\2\2\2\u06b4\u06b6\5\u012a\u0096\2\u06b5\u06b4\3\2\2"+
		"\2\u06b5\u06b6\3\2\2\2\u06b6\u06b8\3\2\2\2\u06b7\u06b9\5\u0192\u00ca\2"+
		"\u06b8\u06b7\3\2\2\2\u06b8\u06b9\3\2\2\2\u06b9\u06bb\3\2\2\2\u06ba\u06bc"+
		"\5\u019a\u00ce\2\u06bb\u06ba\3\2\2\2\u06bb\u06bc\3\2\2\2\u06bc\u00f1\3"+
		"\2\2\2\u06bd\u06be\7%\2\2\u06be\u06bf\5\u00f4{\2\u06bf\u00f3\3\2\2\2\u06c0"+
		"\u06c5\5\u00f6|\2\u06c1\u06c2\7\u00e8\2\2\u06c2\u06c4\5\u00f6|\2\u06c3"+
		"\u06c1\3\2\2\2\u06c4\u06c7\3\2\2\2\u06c5\u06c3\3\2\2\2\u06c5\u06c6\3\2"+
		"\2\2\u06c6\u00f5\3\2\2\2\u06c7\u06c5\3\2\2\2\u06c8\u06cb\5\u00f8}\2\u06c9"+
		"\u06cb\5\u0110\u0089\2\u06ca\u06c8\3\2\2\2\u06ca\u06c9\3\2\2\2\u06cb\u00f7"+
		"\3\2\2\2\u06cc\u06ce\5\u0110\u0089\2\u06cd\u06cf\5\u00fa~\2\u06ce\u06cd"+
		"\3\2\2\2\u06cf\u06d0\3\2\2\2\u06d0\u06ce\3\2\2\2\u06d0\u06d1\3\2\2\2\u06d1"+
		"\u00f9\3\2\2\2\u06d2\u06d3\7\21\2\2\u06d3\u06d4\7\64\2\2\u06d4\u06e6\5"+
		"\u0110\u0089\2\u06d5\u06d7\5\u0104\u0083\2\u06d6\u06d5\3\2\2\2\u06d6\u06d7"+
		"\3\2\2\2\u06d7\u06d8\3\2\2\2\u06d8\u06d9\7\64\2\2\u06d9\u06da\5\u0110"+
		"\u0089\2\u06da\u06db\5\u010a\u0086\2\u06db\u06e6\3\2\2\2\u06dc\u06de\7"+
		":\2\2\u06dd\u06df\5\u0104\u0083\2\u06de\u06dd\3\2\2\2\u06de\u06df\3\2"+
		"\2\2\u06df\u06e0\3\2\2\2\u06e0\u06e1\7\64\2\2\u06e1\u06e6\5\u0110\u0089"+
		"\2\u06e2\u06e3\7Y\2\2\u06e3\u06e4\7\64\2\2\u06e4\u06e6\5\u0110\u0089\2"+
		"\u06e5\u06d2\3\2\2\2\u06e5\u06d6\3\2\2\2\u06e5\u06dc\3\2\2\2\u06e5\u06e2"+
		"\3\2\2\2\u06e6\u00fb\3\2\2\2\u06e7\u06e8\7\21\2\2\u06e8\u06e9\7\64\2\2"+
		"\u06e9\u06ea\5\u0110\u0089\2\u06ea\u00fd\3\2\2\2\u06eb\u06ed\5\u0104\u0083"+
		"\2\u06ec\u06eb\3\2\2\2\u06ec\u06ed\3\2\2\2\u06ed\u06ee\3\2\2\2\u06ee\u06ef"+
		"\7\64\2\2\u06ef\u06f0\5\u0110\u0089\2\u06f0\u06f1\5\u010a\u0086\2\u06f1"+
		"\u00ff\3\2\2\2\u06f2\u06f4\7:\2\2\u06f3\u06f5\5\u0104\u0083\2\u06f4\u06f3"+
		"\3\2\2\2\u06f4\u06f5\3\2\2\2\u06f5\u06f6\3\2\2\2\u06f6\u06f7\7\64\2\2"+
		"\u06f7\u06f8\5\u0110\u0089\2\u06f8\u0101\3\2\2\2\u06f9\u06fa\7Y\2\2\u06fa"+
		"\u06fb\7\64\2\2\u06fb\u06fc\5\u0110\u0089\2\u06fc\u0103\3\2\2\2\u06fd"+
		"\u0700\7.\2\2\u06fe\u0700\5\u0106\u0084\2\u06ff\u06fd\3\2\2\2\u06ff\u06fe"+
		"\3\2\2\2\u0700\u0105\3\2\2\2\u0701\u0703\5\u0108\u0085\2\u0702\u0704\7"+
		"?\2\2\u0703\u0702\3\2\2\2\u0703\u0704\3\2\2\2\u0704\u0107\3\2\2\2\u0705"+
		"\u0706\t\24\2\2\u0706\u0109\3\2\2\2\u0707\u070a\5\u010c\u0087\2\u0708"+
		"\u070a\5\u010e\u0088\2\u0709\u0707\3\2\2\2\u0709\u0708\3\2\2\2\u070a\u010b"+
		"\3\2\2\2\u070b\u070c\7>\2\2\u070c\u070d\5\u0118\u008d\2\u070d\u010d\3"+
		"\2\2\2\u070e\u070f\7]\2\2\u070f\u0710\7\u00ef\2\2\u0710\u0711\5\u0154"+
		"\u00ab\2\u0711\u0712\7\u00f0\2\2\u0712\u010f\3\2\2\2\u0713\u0718\5\u0140"+
		"\u00a1\2\u0714\u0716\7\4\2\2\u0715\u0714\3\2\2\2\u0715\u0716\3\2\2\2\u0716"+
		"\u0717\3\2\2\2\u0717\u0719\5H%\2\u0718\u0715\3\2\2\2\u0718\u0719\3\2\2"+
		"\2\u0719\u071e\3\2\2\2\u071a\u071b\7\u00ef\2\2\u071b\u071c\5\u0112\u008a"+
		"\2\u071c\u071d\7\u00f0\2\2\u071d\u071f\3\2\2\2\u071e\u071a\3\2\2\2\u071e"+
		"\u071f\3\2\2\2\u071f\u072c\3\2\2\2\u0720\u0722\5\u0114\u008b\2\u0721\u0723"+
		"\7\4\2\2\u0722\u0721\3\2\2\2\u0722\u0723\3\2\2\2\u0723\u0724\3\2\2\2\u0724"+
		"\u0729\5H%\2\u0725\u0726\7\u00ef\2\2\u0726\u0727\5\u0112\u008a\2\u0727"+
		"\u0728\7\u00f0\2\2\u0728\u072a\3\2\2\2\u0729\u0725\3\2\2\2\u0729\u072a"+
		"\3\2\2\2\u072a\u072c\3\2\2\2\u072b\u0713\3\2\2\2\u072b\u0720\3\2\2\2\u072c"+
		"\u0111\3\2\2\2\u072d\u0732\5H%\2\u072e\u072f\7\u00e8\2\2\u072f\u0731\5"+
		"H%\2\u0730\u072e\3\2\2\2\u0731\u0734\3\2\2\2\u0732\u0730\3\2\2\2\u0732"+
		"\u0733\3\2\2\2\u0733\u0113\3\2\2\2\u0734\u0732\3\2\2\2\u0735\u0736\5\u015a"+
		"\u00ae\2\u0736\u0115\3\2\2\2\u0737\u0738\7`\2\2\u0738\u0739\5\u0118\u008d"+
		"\2\u0739\u0117\3\2\2\2\u073a\u073b\5\u00a8U\2\u073b\u0119\3\2\2\2\u073c"+
		"\u073d\7\'\2\2\u073d\u073e\7e\2\2\u073e\u073f\5\u011c\u008f\2\u073f\u011b"+
		"\3\2\2\2\u0740\u0745\5\u011e\u0090\2\u0741\u0742\7\u00e8\2\2\u0742\u0744"+
		"\5\u011e\u0090\2\u0743\u0741\3\2\2\2\u0744\u0747\3\2\2\2\u0745\u0743\3"+
		"\2\2\2\u0745\u0746\3\2\2\2\u0746\u011d\3\2\2\2\u0747\u0745\3\2\2\2\u0748"+
		"\u074d\5\u0124\u0093\2\u0749\u074d\5\u0126\u0094\2\u074a\u074d\5\u0128"+
		"\u0095\2\u074b\u074d\5\u0120\u0091\2\u074c\u0748\3\2\2\2\u074c\u0749\3"+
		"\2\2\2\u074c\u074a\3\2\2\2\u074c\u074b\3\2\2\2\u074d\u011f\3\2\2\2\u074e"+
		"\u0754\5\u00ecw\2\u074f\u0750\7\u00ef\2\2\u0750\u0751\5\u012c\u0097\2"+
		"\u0751\u0752\7\u00f0\2\2\u0752\u0754\3\2\2\2\u0753\u074e\3\2\2\2\u0753"+
		"\u074f\3\2\2\2\u0754\u0121\3\2\2\2\u0755\u075a\5\u0120\u0091\2\u0756\u0757"+
		"\7\u00e8\2\2\u0757\u0759\5\u0120\u0091\2\u0758\u0756\3\2\2\2\u0759\u075c"+
		"\3\2\2\2\u075a\u0758\3\2\2\2\u075a\u075b\3\2\2\2\u075b\u0123\3\2\2\2\u075c"+
		"\u075a\3\2\2\2\u075d\u075e\7\u00a1\2\2\u075e\u075f\7\u00ef\2\2\u075f\u0760"+
		"\5\u0122\u0092\2\u0760\u0761\7\u00f0\2\2\u0761\u0125\3\2\2\2\u0762\u0763"+
		"\7l\2\2\u0763\u0764\7\u00ef\2\2\u0764\u0765\5\u0122\u0092\2\u0765\u0766"+
		"\7\u00f0\2\2\u0766\u0127\3\2\2\2\u0767\u0768\7\u00ef\2\2\u0768\u0769\7"+
		"\u00f0\2\2\u0769\u0129\3\2\2\2\u076a\u076b\7(\2\2\u076b\u076c\5\u00d2"+
		"j\2\u076c\u012b\3\2\2\2\u076d\u0772\5\u00ecw\2\u076e\u076f\7\u00e8\2\2"+
		"\u076f\u0771\5\u00ecw\2\u0770\u076e\3\2\2\2\u0771\u0774\3\2\2\2\u0772"+
		"\u0770\3\2\2\2\u0772\u0773\3\2\2\2\u0773\u012d\3\2\2\2\u0774\u0772\3\2"+
		"\2\2\u0775\u0776\5\u0130\u0099\2\u0776\u012f\3\2\2\2\u0777\u077a\5\u0132"+
		"\u009a\2\u0778\u077a\5\u00f8}\2\u0779\u0777\3\2\2\2\u0779\u0778\3\2\2"+
		"\2\u077a\u0131\3\2\2\2\u077b\u0784\5\u0136\u009c\2\u077c\u077d\5\u00f8"+
		"}\2\u077d\u077f\t\25\2\2\u077e\u0780\t\26\2\2\u077f\u077e\3\2\2\2\u077f"+
		"\u0780\3\2\2\2\u0780\u0781\3\2\2\2\u0781\u0782\5\u0134\u009b\2\u0782\u0784"+
		"\3\2\2\2\u0783\u077b\3\2\2\2\u0783\u077c\3\2\2\2\u0784\u078c\3\2\2\2\u0785"+
		"\u0787\t\25\2\2\u0786\u0788\t\26\2\2\u0787\u0786\3\2\2\2\u0787\u0788\3"+
		"\2\2\2\u0788\u0789\3\2\2\2\u0789\u078b\5\u0134\u009b\2\u078a\u0785\3\2"+
		"\2\2\u078b\u078e\3\2\2\2\u078c\u078a\3\2\2\2\u078c\u078d\3\2\2\2\u078d"+
		"\u0133\3\2\2\2\u078e\u078c\3\2\2\2\u078f\u0792\5\u0136\u009c\2\u0790\u0792"+
		"\5\u00f8}\2\u0791\u078f\3\2\2\2\u0791\u0790\3\2\2\2\u0792\u0135\3\2\2"+
		"\2\u0793\u079c\5\u013a\u009e\2\u0794\u0795\5\u00f8}\2\u0795\u0797\7/\2"+
		"\2\u0796\u0798\t\26\2\2\u0797\u0796\3\2\2\2\u0797\u0798\3\2\2\2\u0798"+
		"\u0799\3\2\2\2\u0799\u079a\5\u0138\u009d\2\u079a\u079c\3\2\2\2\u079b\u0793"+
		"\3\2\2\2\u079b\u0794\3\2\2\2\u079c\u07a4\3\2\2\2\u079d\u079f\7/\2\2\u079e"+
		"\u07a0\t\26\2\2\u079f\u079e\3\2\2\2\u079f\u07a0\3\2\2\2\u07a0\u07a1\3"+
		"\2\2\2\u07a1\u07a3\5\u0138\u009d\2\u07a2\u079d\3\2\2\2\u07a3\u07a6\3\2"+
		"\2\2\u07a4\u07a2\3\2\2\2\u07a4\u07a5\3\2\2\2\u07a5\u0137\3\2\2\2\u07a6"+
		"\u07a4\3\2\2\2\u07a7\u07aa\5\u013a\u009e\2\u07a8\u07aa\5\u00f8}\2\u07a9"+
		"\u07a7\3\2\2\2\u07a9\u07a8\3\2\2\2\u07aa\u0139\3\2\2\2\u07ab\u07b1\5\u013c"+
		"\u009f\2\u07ac\u07ad\7\u00ef\2\2\u07ad\u07ae\5\u0132\u009a\2\u07ae\u07af"+
		"\7\u00f0\2\2\u07af\u07b1\3\2\2\2\u07b0\u07ab\3\2\2\2\u07b0\u07ac\3\2\2"+
		"\2\u07b1\u013b\3\2\2\2\u07b2\u07b5\5\u0144\u00a3\2\u07b3\u07b5\5\u013e"+
		"\u00a0\2\u07b4\u07b2\3\2\2\2\u07b4\u07b3\3\2\2\2\u07b5\u013d\3\2\2\2\u07b6"+
		"\u07b7\7Q\2\2\u07b7\u07b8\5\u0140\u00a1\2\u07b8\u013f\3\2\2\2\u07b9\u07bc"+
		"\5\u0142\u00a2\2\u07ba\u07bc\5H%\2\u07bb\u07b9\3\2\2\2\u07bb\u07ba\3\2"+
		"\2\2\u07bc\u0141\3\2\2\2\u07bd\u07c4\5H%\2\u07be\u07bf\7\u00f6\2\2\u07bf"+
		"\u07c2\5H%\2\u07c0\u07c1\7\u00f6\2\2\u07c1\u07c3\5H%\2\u07c2\u07c0\3\2"+
		"\2\2\u07c2\u07c3\3\2\2\2\u07c3\u07c5\3\2\2\2\u07c4\u07be\3\2\2\2\u07c4"+
		"\u07c5\3\2\2\2\u07c5\u0143\3\2\2\2\u07c6\u07c8\7L\2\2\u07c7\u07c9\5\u014e"+
		"\u00a8\2\u07c8\u07c7\3\2\2\2\u07c8\u07c9\3\2\2\2\u07c9\u07ca\3\2\2\2\u07ca"+
		"\u07cc\5\u0146\u00a4\2\u07cb\u07cd\5\u00f0y\2\u07cc\u07cb\3\2\2\2\u07cc"+
		"\u07cd\3\2\2\2\u07cd\u0145\3\2\2\2\u07ce\u07d3\5\u0148\u00a5\2\u07cf\u07d0"+
		"\7\u00e8\2\2\u07d0\u07d2\5\u0148\u00a5\2\u07d1\u07cf\3\2\2\2\u07d2\u07d5"+
		"\3\2\2\2\u07d3\u07d1\3\2\2\2\u07d3\u07d4\3\2\2\2\u07d4\u0147\3\2\2\2\u07d5"+
		"\u07d3\3\2\2\2\u07d6\u07d9\5\u014a\u00a6\2\u07d7\u07d9\5\u014c\u00a7\2"+
		"\u07d8\u07d6\3\2\2\2\u07d8\u07d7\3\2\2\2\u07d9\u0149\3\2\2\2\u07da\u07dc"+
		"\5\u00a8U\2\u07db\u07dd\5\u0152\u00aa\2\u07dc\u07db\3\2\2\2\u07dc\u07dd"+
		"\3\2\2\2\u07dd\u014b\3\2\2\2\u07de\u07df\7\u00ff\2\2\u07df\u07e1\7\u00f6"+
		"\2\2\u07e0\u07de\3\2\2\2\u07e0\u07e1\3\2\2\2\u07e1\u07e2\3\2\2\2\u07e2"+
		"\u07e3\7\u00f3\2\2\u07e3\u014d\3\2\2\2\u07e4\u07e5\t\26\2\2\u07e5\u014f"+
		"\3\2\2\2\u07e6\u07e7\5H%\2\u07e7\u07e8\7\u00f6\2\2\u07e8\u07ea\3\2\2\2"+
		"\u07e9\u07e6\3\2\2\2\u07e9\u07ea\3\2\2\2\u07ea\u07eb\3\2\2\2\u07eb\u07ec"+
		"\5H%\2\u07ec\u0151\3\2\2\2\u07ed\u07ef\7\4\2\2\u07ee\u07ed\3\2\2\2\u07ee"+
		"\u07ef\3\2\2\2\u07ef\u07f0\3\2\2\2\u07f0\u07f1\5H%\2\u07f1\u0153\3\2\2"+
		"\2\u07f2\u07f7\5\u0150\u00a9\2\u07f3\u07f4\7\u00e8\2\2\u07f4\u07f6\5\u0150"+
		"\u00a9\2\u07f5\u07f3\3\2\2\2\u07f6\u07f9\3\2\2\2\u07f7\u07f5\3\2\2\2\u07f7"+
		"\u07f8\3\2\2\2\u07f8\u0155\3\2\2\2\u07f9\u07f7\3\2\2\2\u07fa\u07fb\5\u015c"+
		"\u00af\2\u07fb\u0157\3\2\2\2\u07fc\u07fd\5\u015c\u00af\2\u07fd\u0159\3"+
		"\2\2\2\u07fe\u07ff\5\u015c\u00af\2\u07ff\u015b\3\2\2\2\u0800\u0801\7\u00ef"+
		"\2\2\u0801\u0802\5\u012e\u0098\2\u0802\u0803\7\u00f0\2\2\u0803\u015d\3"+
		"\2\2\2\u0804\u080b\5\u0160\u00b1\2\u0805\u080b\5\u0164\u00b3\2\u0806\u080b"+
		"\5\u0168\u00b5\2\u0807\u080b\5\u016e\u00b8\2\u0808\u080b\5\u0176\u00bc"+
		"\2\u0809\u080b\5\u0180\u00c1\2\u080a\u0804\3\2\2\2\u080a\u0805\3\2\2\2"+
		"\u080a\u0806\3\2\2\2\u080a\u0807\3\2\2\2\u080a\u0808\3\2\2\2\u080a\u0809"+
		"\3\2\2\2\u080b\u015f\3\2\2\2\u080c\u080d\5\u00ecw\2\u080d\u080e\5\u0162"+
		"\u00b2\2\u080e\u080f\5\u00ecw\2\u080f\u0161\3\2\2\2\u0810\u0811\t\27\2"+
		"\2\u0811\u0163\3\2\2\2\u0812\u0813\5\u00ecw\2\u0813\u0814\5\u0166\u00b4"+
		"\2\u0814\u0165\3\2\2\2\u0815\u0817\7;\2\2\u0816\u0815\3\2\2\2\u0816\u0817"+
		"\3\2\2\2\u0817\u0818\3\2\2\2\u0818\u081a\7d\2\2\u0819\u081b\t\30\2\2\u081a"+
		"\u0819\3\2\2\2\u081a\u081b\3\2\2\2\u081b\u081c\3\2\2\2\u081c\u081d\5\u00ec"+
		"w\2\u081d\u081e\7\6\2\2\u081e\u081f\5\u00ecw\2\u081f\u0167\3\2\2\2\u0820"+
		"\u0822\5\u00acW\2\u0821\u0823\7;\2\2\u0822\u0821\3\2\2\2\u0822\u0823\3"+
		"\2\2\2\u0823\u0824\3\2\2\2\u0824\u0825\7,\2\2\u0825\u0826\5\u016a\u00b6"+
		"\2\u0826\u0169\3\2\2\2\u0827\u082d\5\u015a\u00ae\2\u0828\u0829\7\u00ef"+
		"\2\2\u0829\u082a\5\u016c\u00b7\2\u082a\u082b\7\u00f0\2\2\u082b\u082d\3"+
		"\2\2\2\u082c\u0827\3\2\2\2\u082c\u0828\3\2\2\2\u082d\u016b\3\2\2\2\u082e"+
		"\u0833\5\u00e6t\2\u082f\u0830\7\u00e8\2\2\u0830\u0832\5\u00e6t\2\u0831"+
		"\u082f\3\2\2\2\u0832\u0835\3\2\2\2\u0833\u0831\3\2\2\2\u0833\u0834\3\2"+
		"\2\2\u0834\u016d\3\2\2\2\u0835\u0833\3\2\2\2\u0836\u0837\5\u00ecw\2\u0837"+
		"\u0838\5\u0170\u00b9\2\u0838\u0839\7\u0100\2\2\u0839\u016f\3\2\2\2\u083a"+
		"\u083c\7;\2\2\u083b\u083a\3\2\2\2\u083b\u083c\3\2\2\2\u083c\u083d\3\2"+
		"\2\2\u083d\u0840\5\u0172\u00ba\2\u083e\u0840\5\u0174\u00bb\2\u083f\u083b"+
		"\3\2\2\2\u083f\u083e\3\2\2\2\u0840\u0171\3\2\2\2\u0841\u0848\7\67\2\2"+
		"\u0842\u0848\7*\2\2\u0843\u0844\7\u00a5\2\2\u0844\u0848\7\u00b1\2\2\u0845"+
		"\u0848\7\u009f\2\2\u0846\u0848\7\u00a0\2\2\u0847\u0841\3\2\2\2\u0847\u0842"+
		"\3\2\2\2\u0847\u0843\3\2\2\2\u0847\u0845\3\2\2\2\u0847\u0846\3\2\2\2\u0848"+
		"\u0173\3\2\2\2\u0849\u084a\t\31\2\2\u084a\u0175\3\2\2\2\u084b\u084c\5"+
		"\u00ecw\2\u084c\u084e\7\63\2\2\u084d\u084f\7;\2\2\u084e\u084d\3\2\2\2"+
		"\u084e\u084f\3\2\2\2\u084f\u0850\3\2\2\2\u0850\u0851\7<\2\2\u0851\u0177"+
		"\3\2\2\2\u0852\u0853\5\u00acW\2\u0853\u0854\5\u0162\u00b2\2\u0854\u0855"+
		"\5\u017a\u00be\2\u0855\u0856\5\u015a\u00ae\2\u0856\u0179\3\2\2\2\u0857"+
		"\u085a\5\u017c\u00bf\2\u0858\u085a\5\u017e\u00c0\2\u0859\u0857\3\2\2\2"+
		"\u0859\u0858\3\2\2\2\u085a\u017b\3\2\2\2\u085b\u085c\7\5\2\2\u085c\u017d"+
		"\3\2\2\2\u085d\u085e\t\32\2\2\u085e\u017f\3\2\2\2\u085f\u0861\7;\2\2\u0860"+
		"\u085f\3\2\2\2\u0860\u0861\3\2\2\2\u0861\u0862\3\2\2\2\u0862\u0863\7v"+
		"\2\2\u0863\u0864\5\u015a\u00ae\2\u0864\u0181\3\2\2\2\u0865\u0866\7Z\2"+
		"\2\u0866\u0867\5\u015a\u00ae\2\u0867\u0183\3\2\2\2\u0868\u086b\5\u0186"+
		"\u00c4\2\u0869\u086b\7\u00a2\2\2\u086a\u0868\3\2\2\2\u086a\u0869\3\2\2"+
		"\2\u086b\u0185\3\2\2\2\u086c\u086d\t\33\2\2\u086d\u0187\3\2\2\2\u086e"+
		"\u086f\t\34\2\2\u086f\u0189\3\2\2\2\u0870\u0871\5\u018e\u00c8\2\u0871"+
		"\u0873\7\u00ef\2\2\u0872\u0874\5\u0190\u00c9\2\u0873\u0872\3\2\2\2\u0873"+
		"\u0874\3\2\2\2\u0874\u0875\3\2\2\2\u0875\u0876\7\u00f0\2\2\u0876\u018b"+
		"\3\2\2\2\u0877\u0878\t\35\2\2\u0878\u018d\3\2\2\2\u0879\u087c\5H%\2\u087a"+
		"\u087c\5\u018c\u00c7\2\u087b\u0879\3\2\2\2\u087b\u087a\3\2\2\2\u087c\u018f"+
		"\3\2\2\2\u087d\u0882\5\u00a8U\2\u087e\u087f\7\u00e8\2\2\u087f\u0881\5"+
		"\u00a8U\2\u0880\u087e\3\2\2\2\u0881\u0884\3\2\2\2\u0882\u0880\3\2\2\2"+
		"\u0882\u0883\3\2\2\2\u0883\u0191\3\2\2\2\u0884\u0882\3\2\2\2\u0885\u0886"+
		"\7B\2\2\u0886\u0887\7e\2\2\u0887\u0888\5\u0194\u00cb\2\u0888\u0193\3\2"+
		"\2\2\u0889\u088e\5\u0196\u00cc\2\u088a\u088b\7\u00e8\2\2\u088b\u088d\5"+
		"\u0196\u00cc\2\u088c\u088a\3\2\2\2\u088d\u0890\3\2\2\2\u088e\u088c\3\2"+
		"\2\2\u088e\u088f\3\2\2\2\u088f\u0195\3\2\2\2\u0890\u088e\3\2\2\2\u0891"+
		"\u0893\5\u00ecw\2\u0892\u0894\5\u0198\u00cd\2\u0893\u0892\3\2\2\2\u0893"+
		"\u0894\3\2\2\2\u0894\u0896\3\2\2\2\u0895\u0897\5\u019c\u00cf\2\u0896\u0895"+
		"\3\2\2\2\u0896\u0897\3\2\2\2\u0897\u0197\3\2\2\2\u0898\u0899\t\36\2\2"+
		"\u0899\u0199\3\2\2\2\u089a\u089b\78\2\2\u089b\u089c\5\u00acW\2\u089c\u019b"+
		"\3\2\2\2\u089d\u089e\7<\2\2\u089e\u08a2\7z\2\2\u089f\u08a0\7<\2\2\u08a0"+
		"\u08a2\7\u0087\2\2\u08a1\u089d\3\2\2\2\u08a1\u089f\3\2\2\2\u08a2\u019d"+
		"\3\2\2\2\u08a3\u08a5\7\u0081\2\2\u08a4\u08a6\7\u0097\2\2\u08a5\u08a4\3"+
		"\2\2\2\u08a5\u08a6\3\2\2\2\u08a6\u08a7\3\2\2\2\u08a7\u08a8\7\60\2\2\u08a8"+
		"\u08ad\5\u0142\u00a2\2\u08a9\u08aa\7\u00ef\2\2\u08aa\u08ab\5\u0112\u008a"+
		"\2\u08ab\u08ac\7\u00f0\2\2\u08ac\u08ae\3\2\2\2\u08ad\u08a9\3\2\2\2\u08ad"+
		"\u08ae\3\2\2\2\u08ae\u08af\3\2\2\2\u08af\u08b0\5\u012e\u0098\2\u08b0\u08c1"+
		"\3\2\2\2\u08b1\u08b3\7\u0081\2\2\u08b2\u08b4\7\u0097\2\2\u08b3\u08b2\3"+
		"\2\2\2\u08b3\u08b4\3\2\2\2\u08b4\u08b5\3\2\2\2\u08b5\u08b6\7\60\2\2\u08b6"+
		"\u08b7\7\u008a\2\2\u08b7\u08bd\7\u0100\2\2\u08b8\u08b9\7]\2\2\u08b9\u08bb"+
		"\5H%\2\u08ba\u08bc\5\"\22\2\u08bb\u08ba\3\2\2\2\u08bb\u08bc\3\2\2\2\u08bc"+
		"\u08be\3\2\2\2\u08bd\u08b8\3\2\2\2\u08bd\u08be\3\2\2\2\u08be\u08bf\3\2"+
		"\2\2\u08bf\u08c1\5\u012e\u0098\2\u08c0\u08a3\3\2\2\2\u08c0\u08b1\3\2\2"+
		"\2\u08c1\u019f\3\2\2\2\u012b\u01a2\u01a6\u01b2\u01ba\u01be\u01c5\u01cb"+
		"\u01d2\u01d6\u01da\u01de\u01e2\u01e6\u01f0\u01f3\u01f7\u01fb\u0202\u0205"+
		"\u0209\u020b\u020f\u0217\u0220\u0224\u0226\u0228\u022e\u0233\u0239\u023d"+
		"\u0241\u0245\u024d\u024f\u0257\u025b\u025d\u0261\u0265\u0269\u0271\u0275"+
		"\u0277\u027f\u0283\u0287\u028b\u028f\u0293\u0295\u0299\u029d\u02a1\u02a8"+
		"\u02ac\u02b0\u02b2\u02b8\u02bc\u02c4\u02c8\u02ca\u02d1\u02d5\u02d9\u02db"+
		"\u02e1\u02e5\u02ed\u02ef\u02f7\u02fb\u0303\u0305\u030c\u0310\u0318\u031a"+
		"\u0321\u0324\u0328\u032c\u0337\u033b\u033d\u0345\u0347\u034d\u0351\u0358"+
		"\u035c\u0360\u0362\u0369\u036d\u0374\u0378\u037c\u037e\u0384\u0388\u0390"+
		"\u0392\u0398\u039c\u03a2\u03a6\u03ab\u03af\u03b4\u03b6\u03ba\u03be\u03c1"+
		"\u03c5\u03ca\u03d6\u03d9\u03e4\u03e7\u03ea\u03ee\u03f5\u03f8\u03fb\u0400"+
		"\u0408\u0419\u042e\u043f\u044c\u0450\u0452\u045f\u0466\u047e\u0485\u0496"+
		"\u049a\u04a0\u04a5\u04aa\u04c2\u04c8\u04cc\u04d1\u04d6\u04da\u04dd\u04e6"+
		"\u04eb\u04ef\u04f5\u04fb\u0500\u0504\u0506\u050a\u050e\u0510\u0514\u0518"+
		"\u051c\u0520\u052b\u052f\u0537\u0541\u0552\u0556\u055a\u055f\u0561\u0565"+
		"\u056a\u056e\u0570\u0574\u0581\u0588\u0594\u0596\u059b\u05bd\u05c1\u05c5"+
		"\u05cc\u05cf\u05d7\u05da\u05ed\u05fd\u0602\u0609\u0611\u0615\u061f\u0629"+
		"\u062d\u063d\u0643\u064c\u0653\u065d\u0660\u0663\u066a\u0675\u067d\u0683"+
		"\u0687\u068b\u0693\u0697\u069f\u06a7\u06ab\u06af\u06b2\u06b5\u06b8\u06bb"+
		"\u06c5\u06ca\u06d0\u06d6\u06de\u06e5\u06ec\u06f4\u06ff\u0703\u0709\u0715"+
		"\u0718\u071e\u0722\u0729\u072b\u0732\u0745\u074c\u0753\u075a\u0772\u0779"+
		"\u077f\u0783\u0787\u078c\u0791\u0797\u079b\u079f\u07a4\u07a9\u07b0\u07b4"+
		"\u07bb\u07c2\u07c4\u07c8\u07cc\u07d3\u07d8\u07dc\u07e0\u07e9\u07ee\u07f7"+
		"\u080a\u0816\u081a\u0822\u082c\u0833\u083b\u083f\u0847\u084e\u0859\u0860"+
		"\u086a\u0873\u087b\u0882\u088e\u0893\u0896\u08a1\u08a5\u08ad\u08b3\u08bb"+
		"\u08bd\u08c0";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}