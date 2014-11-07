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
		ISODOW=88, OVERWRITE=104, PRECISION=107, ILIKE=24, Character_String_Literal=205, 
		NOT=36, EXCEPT=16, BYTEA=170, CHARACTER=61, MONTH=101, BlockComment=202, 
		VARBIT=140, CREATE=10, STDDEV_POP=117, USING=53, NOT_EQUAL=183, TIMEZONE_MINUTE=125, 
		VERTICAL_BAR=197, TIMESTAMPTZ=165, REGEXP=111, GEQ=187, STDDEV_SAMP=118, 
		DIVIDE=193, BLOB=169, GROUPING=82, ASC=6, SUBPARTITION=119, ELSE=15, NUMBER=200, 
		BOOL=138, TRAILING=49, INT=147, SEMI_COLON=180, RLIKE=112, LEADING=31, 
		TABLESPACE=121, MILLISECONDS=98, REAL=152, GROUP=21, INTERSECT=27, REAL_NUMBER=201, 
		TRIM=126, LOCATION=93, LEFT_PAREN=188, END=14, TIMEZONE_HOUR=124, CAST_EXPRESSION=176, 
		ISOYEAR=89, NCHAR=159, TABLE=47, VARCHAR=158, MICROSECONDS=96, VERSION=133, 
		FLOAT=153, ASYMMETRIC=5, SUM=120, Space=206, AS=1, TIME=162, RIGHT_PAREN=189, 
		THEN=48, MAXVALUE=95, AVG=57, LEFT=32, ZONE=136, COLUMN=64, PLUS=190, 
		EXISTS=75, NVARCHAR=160, Not_Similar_To=173, LIKE=33, INTEGER=148, OUTER=39, 
		BY=59, TO=127, RIGHT=42, SET=115, HAVING=22, MIN=99, TEXT=166, MINUS=191, 
		HOUR=84, UNION=51, CONCATENATION_OPERATOR=182, COLON=179, SCHEMA=43, DECIMAL=156, 
		DROP=72, BIGINT=149, WHEN=54, BIT=139, FORMAT=80, NATURAL=35, BETWEEN=58, 
		EXTENSION=17, FIRST=79, CAST=9, EXTERNAL=76, WEEK=134, DOUBLE_QUOTE=199, 
		VARYING=132, CASE=8, INT8=144, CHAR=157, DAY=67, COUNT=65, INT2=142, INT1=141, 
		Identifier=204, INT4=143, QUOTE=198, MODULAR=194, FULL=19, QUARTER=109, 
		THAN=122, INSERT=86, INTERSECTION=87, LESS=91, BOTH=7, TINYINT=145, DOUBLE=154, 
		Similar_To_Case_Insensitive=174, SYMMETRIC=46, LAST=90, SELECT=44, INTO=28, 
		UNIQUE=52, COALESCE=63, SECOND=114, EPOCH=73, ROLLUP=113, NULL=37, EVERY=74, 
		ON=38, NUMERIC=155, INET4=171, LIST=92, UNDERLINE=196, Not_Similar_To_Case_Insensitive=175, 
		CUBE=66, NATIONAL=102, OR=40, VAR_POP=131, FILTER=78, FROM=20, COLLECT=62, 
		FALSE=18, DISTINCT=13, TIMESTAMP=164, DEC=68, WHERE=55, NULLIF=103, VAR_SAMP=130, 
		TIMETZ=163, INNER=26, YEAR=135, ORDER=41, TIMEZONE=123, LIMIT=34, DECADE=69, 
		GTH=186, White_Space=207, MAX=94, LineComment=203, FLOAT4=150, FLOAT8=151, 
		AND=3, CROSS=11, Similar_To=172, IF=23, INDEX=85, BOOLEAN=137, IN=25, 
		UNKNOWN=128, MULTIPLY=192, COMMA=181, IS=29, PARTITION=105, PARTITIONS=106, 
		SOME=45, ALL=2, EQUAL=178, DOT=195, EXTRACT=77, CENTURY=60, DOW=70, WITH=56, 
		DOY=71, FUSION=81, VARBINARY=168, VALUES=129, HASH=83, MILLENNIUM=97, 
		RANGE=110, PURGE=108, TRUE=50, JOIN=30, SIMILAR=116, LTH=184, ANY=4, BAD=208, 
		ASSIGN=177, DESC=12, BINARY=167, MINUTE=100, DATE=161, SMALLINT=146, LEQ=185;
	public static final String[] tokenNames = {
		"<INVALID>", "AS", "ALL", "AND", "ANY", "ASYMMETRIC", "ASC", "BOTH", "CASE", 
		"CAST", "CREATE", "CROSS", "DESC", "DISTINCT", "END", "ELSE", "EXCEPT", 
		"EXTENSION", "FALSE", "FULL", "FROM", "GROUP", "HAVING", "IF", "ILIKE", 
		"IN", "INNER", "INTERSECT", "INTO", "IS", "JOIN", "LEADING", "LEFT", "LIKE", 
		"LIMIT", "NATURAL", "NOT", "NULL", "ON", "OUTER", "OR", "ORDER", "RIGHT", 
		"SCHEMA", "SELECT", "SOME", "SYMMETRIC", "TABLE", "THEN", "TRAILING", 
		"TRUE", "UNION", "UNIQUE", "USING", "WHEN", "WHERE", "WITH", "AVG", "BETWEEN", 
		"BY", "CENTURY", "CHARACTER", "COLLECT", "COALESCE", "COLUMN", "COUNT", 
		"CUBE", "DAY", "DEC", "DECADE", "DOW", "DOY", "DROP", "EPOCH", "EVERY", 
		"EXISTS", "EXTERNAL", "EXTRACT", "FILTER", "FIRST", "FORMAT", "FUSION", 
		"GROUPING", "HASH", "HOUR", "INDEX", "INSERT", "INTERSECTION", "ISODOW", 
		"ISOYEAR", "LAST", "LESS", "LIST", "LOCATION", "MAX", "MAXVALUE", "MICROSECONDS", 
		"MILLENNIUM", "MILLISECONDS", "MIN", "MINUTE", "MONTH", "NATIONAL", "NULLIF", 
		"OVERWRITE", "PARTITION", "PARTITIONS", "PRECISION", "PURGE", "QUARTER", 
		"RANGE", "REGEXP", "RLIKE", "ROLLUP", "SECOND", "SET", "SIMILAR", "STDDEV_POP", 
		"STDDEV_SAMP", "SUBPARTITION", "SUM", "TABLESPACE", "THAN", "TIMEZONE", 
		"TIMEZONE_HOUR", "TIMEZONE_MINUTE", "TRIM", "TO", "UNKNOWN", "VALUES", 
		"VAR_SAMP", "VAR_POP", "VARYING", "VERSION", "WEEK", "YEAR", "ZONE", "BOOLEAN", 
		"BOOL", "BIT", "VARBIT", "INT1", "INT2", "INT4", "INT8", "TINYINT", "SMALLINT", 
		"INT", "INTEGER", "BIGINT", "FLOAT4", "FLOAT8", "REAL", "FLOAT", "DOUBLE", 
		"NUMERIC", "DECIMAL", "CHAR", "VARCHAR", "NCHAR", "NVARCHAR", "DATE", 
		"TIME", "TIMETZ", "TIMESTAMP", "TIMESTAMPTZ", "TEXT", "BINARY", "VARBINARY", 
		"BLOB", "BYTEA", "INET4", "'~'", "'!~'", "'~*'", "'!~*'", "CAST_EXPRESSION", 
		"':='", "'='", "':'", "';'", "','", "CONCATENATION_OPERATOR", "NOT_EQUAL", 
		"'<'", "'<='", "'>'", "'>='", "'('", "')'", "'+'", "'-'", "'*'", "'/'", 
		"'%'", "'.'", "'_'", "'|'", "'''", "'\"'", "NUMBER", "REAL_NUMBER", "BlockComment", 
		"LineComment", "Identifier", "Character_String_Literal", "' '", "White_Space", 
		"BAD"
	};
	public static final int
		RULE_sql = 0, RULE_statement = 1, RULE_data_statement = 2, RULE_data_change_statement = 3, 
		RULE_schema_statement = 4, RULE_index_statement = 5, RULE_create_extension_statement = 6, 
		RULE_create_table_statement = 7, RULE_table_elements = 8, RULE_field_element = 9, 
		RULE_field_type = 10, RULE_param_clause = 11, RULE_param = 12, RULE_method_specifier = 13, 
		RULE_table_space_specifier = 14, RULE_table_space_name = 15, RULE_table_partitioning_clauses = 16, 
		RULE_range_partitions = 17, RULE_range_value_clause_list = 18, RULE_range_value_clause = 19, 
		RULE_hash_partitions = 20, RULE_individual_hash_partitions = 21, RULE_individual_hash_partition = 22, 
		RULE_hash_partitions_by_quantity = 23, RULE_list_partitions = 24, RULE_list_value_clause_list = 25, 
		RULE_list_value_partition = 26, RULE_column_partitions = 27, RULE_partition_name = 28, 
		RULE_drop_table_statement = 29, RULE_identifier = 30, RULE_nonreserved_keywords = 31, 
		RULE_unsigned_literal = 32, RULE_general_literal = 33, RULE_datetime_literal = 34, 
		RULE_time_literal = 35, RULE_timestamp_literal = 36, RULE_date_literal = 37, 
		RULE_boolean_literal = 38, RULE_data_type = 39, RULE_predefined_type = 40, 
		RULE_network_type = 41, RULE_character_string_type = 42, RULE_type_length = 43, 
		RULE_national_character_string_type = 44, RULE_binary_large_object_string_type = 45, 
		RULE_numeric_type = 46, RULE_exact_numeric_type = 47, RULE_approximate_numeric_type = 48, 
		RULE_precision_param = 49, RULE_boolean_type = 50, RULE_datetime_type = 51, 
		RULE_bit_type = 52, RULE_binary_type = 53, RULE_value_expression_primary = 54, 
		RULE_parenthesized_value_expression = 55, RULE_nonparenthesized_value_expression_primary = 56, 
		RULE_unsigned_value_specification = 57, RULE_unsigned_numeric_literal = 58, 
		RULE_signed_numerical_literal = 59, RULE_set_function_specification = 60, 
		RULE_aggregate_function = 61, RULE_general_set_function = 62, RULE_set_function_type = 63, 
		RULE_filter_clause = 64, RULE_grouping_operation = 65, RULE_case_expression = 66, 
		RULE_case_abbreviation = 67, RULE_case_specification = 68, RULE_simple_case = 69, 
		RULE_searched_case = 70, RULE_simple_when_clause = 71, RULE_searched_when_clause = 72, 
		RULE_else_clause = 73, RULE_result = 74, RULE_cast_specification = 75, 
		RULE_cast_operand = 76, RULE_cast_target = 77, RULE_value_expression = 78, 
		RULE_common_value_expression = 79, RULE_numeric_value_expression = 80, 
		RULE_term = 81, RULE_factor = 82, RULE_array = 83, RULE_numeric_primary = 84, 
		RULE_sign = 85, RULE_numeric_value_function = 86, RULE_extract_expression = 87, 
		RULE_extract_field = 88, RULE_time_zone_field = 89, RULE_extract_source = 90, 
		RULE_string_value_expression = 91, RULE_character_value_expression = 92, 
		RULE_character_factor = 93, RULE_character_primary = 94, RULE_string_value_function = 95, 
		RULE_trim_function = 96, RULE_trim_operands = 97, RULE_trim_specification = 98, 
		RULE_boolean_value_expression = 99, RULE_or_predicate = 100, RULE_and_predicate = 101, 
		RULE_boolean_factor = 102, RULE_boolean_test = 103, RULE_is_clause = 104, 
		RULE_truth_value = 105, RULE_boolean_primary = 106, RULE_boolean_predicand = 107, 
		RULE_parenthesized_boolean_value_expression = 108, RULE_row_value_expression = 109, 
		RULE_row_value_special_case = 110, RULE_explicit_row_value_constructor = 111, 
		RULE_row_value_predicand = 112, RULE_row_value_constructor_predicand = 113, 
		RULE_table_expression = 114, RULE_from_clause = 115, RULE_table_reference_list = 116, 
		RULE_table_reference = 117, RULE_joined_table = 118, RULE_joined_table_primary = 119, 
		RULE_cross_join = 120, RULE_qualified_join = 121, RULE_natural_join = 122, 
		RULE_union_join = 123, RULE_join_type = 124, RULE_outer_join_type = 125, 
		RULE_outer_join_type_part2 = 126, RULE_join_specification = 127, RULE_join_condition = 128, 
		RULE_named_columns_join = 129, RULE_table_primary = 130, RULE_column_name_list = 131, 
		RULE_derived_table = 132, RULE_where_clause = 133, RULE_search_condition = 134, 
		RULE_groupby_clause = 135, RULE_grouping_element_list = 136, RULE_grouping_element = 137, 
		RULE_ordinary_grouping_set = 138, RULE_ordinary_grouping_set_list = 139, 
		RULE_rollup_list = 140, RULE_cube_list = 141, RULE_empty_grouping_set = 142, 
		RULE_having_clause = 143, RULE_row_value_predicand_list = 144, RULE_query_expression = 145, 
		RULE_query_expression_body = 146, RULE_non_join_query_expression = 147, 
		RULE_query_term = 148, RULE_non_join_query_term = 149, RULE_query_primary = 150, 
		RULE_non_join_query_primary = 151, RULE_simple_table = 152, RULE_explicit_table = 153, 
		RULE_table_or_query_name = 154, RULE_table_name = 155, RULE_query_specification = 156, 
		RULE_select_list = 157, RULE_select_sublist = 158, RULE_derived_column = 159, 
		RULE_qualified_asterisk = 160, RULE_set_qualifier = 161, RULE_column_reference = 162, 
		RULE_as_clause = 163, RULE_column_reference_list = 164, RULE_scalar_subquery = 165, 
		RULE_row_subquery = 166, RULE_table_subquery = 167, RULE_subquery = 168, 
		RULE_predicate = 169, RULE_comparison_predicate = 170, RULE_comp_op = 171, 
		RULE_between_predicate = 172, RULE_between_predicate_part_2 = 173, RULE_in_predicate = 174, 
		RULE_in_predicate_value = 175, RULE_in_value_list = 176, RULE_pattern_matching_predicate = 177, 
		RULE_pattern_matcher = 178, RULE_negativable_matcher = 179, RULE_regex_matcher = 180, 
		RULE_null_predicate = 181, RULE_quantified_comparison_predicate = 182, 
		RULE_quantifier = 183, RULE_all = 184, RULE_some = 185, RULE_exists_predicate = 186, 
		RULE_unique_predicate = 187, RULE_primary_datetime_field = 188, RULE_non_second_primary_datetime_field = 189, 
		RULE_extended_datetime_field = 190, RULE_routine_invocation = 191, RULE_function_names_for_reserved_words = 192, 
		RULE_function_name = 193, RULE_sql_argument_list = 194, RULE_orderby_clause = 195, 
		RULE_sort_specifier_list = 196, RULE_sort_specifier = 197, RULE_order_specification = 198, 
		RULE_limit_clause = 199, RULE_null_ordering = 200, RULE_insert_statement = 201;
	public static final String[] ruleNames = {
		"sql", "statement", "data_statement", "data_change_statement", "schema_statement", 
		"index_statement", "create_extension_statement", "create_table_statement", 
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
			setState(408); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(404); statement();
				setState(406);
				_la = _input.LA(1);
				if (_la==SEMI_COLON) {
					{
					setState(405); match(SEMI_COLON);
					}
				}

				}
				}
				setState(410); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CREATE) | (1L << SELECT) | (1L << TABLE) | (1L << AVG) | (1L << BETWEEN) | (1L << BY) | (1L << CENTURY) | (1L << CHARACTER) | (1L << COLLECT) | (1L << COALESCE))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (COLUMN - 64)) | (1L << (COUNT - 64)) | (1L << (CUBE - 64)) | (1L << (DAY - 64)) | (1L << (DEC - 64)) | (1L << (DECADE - 64)) | (1L << (DOW - 64)) | (1L << (DOY - 64)) | (1L << (DROP - 64)) | (1L << (EPOCH - 64)) | (1L << (EVERY - 64)) | (1L << (EXISTS - 64)) | (1L << (EXTERNAL - 64)) | (1L << (EXTRACT - 64)) | (1L << (FILTER - 64)) | (1L << (FIRST - 64)) | (1L << (FORMAT - 64)) | (1L << (FUSION - 64)) | (1L << (GROUPING - 64)) | (1L << (HASH - 64)) | (1L << (INDEX - 64)) | (1L << (INSERT - 64)) | (1L << (INTERSECTION - 64)) | (1L << (ISODOW - 64)) | (1L << (ISOYEAR - 64)) | (1L << (LAST - 64)) | (1L << (LESS - 64)) | (1L << (LIST - 64)) | (1L << (LOCATION - 64)) | (1L << (MAX - 64)) | (1L << (MAXVALUE - 64)) | (1L << (MICROSECONDS - 64)) | (1L << (MILLENNIUM - 64)) | (1L << (MILLISECONDS - 64)) | (1L << (MIN - 64)) | (1L << (MINUTE - 64)) | (1L << (MONTH - 64)) | (1L << (NATIONAL - 64)) | (1L << (NULLIF - 64)) | (1L << (OVERWRITE - 64)) | (1L << (PARTITION - 64)) | (1L << (PARTITIONS - 64)) | (1L << (PRECISION - 64)) | (1L << (PURGE - 64)) | (1L << (QUARTER - 64)) | (1L << (RANGE - 64)) | (1L << (REGEXP - 64)) | (1L << (RLIKE - 64)) | (1L << (ROLLUP - 64)) | (1L << (SECOND - 64)) | (1L << (SET - 64)) | (1L << (SIMILAR - 64)) | (1L << (STDDEV_POP - 64)) | (1L << (STDDEV_SAMP - 64)) | (1L << (SUBPARTITION - 64)) | (1L << (SUM - 64)) | (1L << (TABLESPACE - 64)) | (1L << (THAN - 64)) | (1L << (TIMEZONE - 64)) | (1L << (TIMEZONE_HOUR - 64)) | (1L << (TIMEZONE_MINUTE - 64)) | (1L << (TRIM - 64)) | (1L << (TO - 64)))) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (UNKNOWN - 128)) | (1L << (VALUES - 128)) | (1L << (VAR_SAMP - 128)) | (1L << (VAR_POP - 128)) | (1L << (VARYING - 128)) | (1L << (WEEK - 128)) | (1L << (YEAR - 128)) | (1L << (ZONE - 128)) | (1L << (BOOLEAN - 128)) | (1L << (BOOL - 128)) | (1L << (BIT - 128)) | (1L << (VARBIT - 128)) | (1L << (INT1 - 128)) | (1L << (INT2 - 128)) | (1L << (INT4 - 128)) | (1L << (INT8 - 128)) | (1L << (TINYINT - 128)) | (1L << (SMALLINT - 128)) | (1L << (INT - 128)) | (1L << (INTEGER - 128)) | (1L << (BIGINT - 128)) | (1L << (FLOAT4 - 128)) | (1L << (FLOAT8 - 128)) | (1L << (REAL - 128)) | (1L << (FLOAT - 128)) | (1L << (DOUBLE - 128)) | (1L << (NUMERIC - 128)) | (1L << (DECIMAL - 128)) | (1L << (CHAR - 128)) | (1L << (VARCHAR - 128)) | (1L << (NCHAR - 128)) | (1L << (NVARCHAR - 128)) | (1L << (DATE - 128)) | (1L << (TIME - 128)) | (1L << (TIMETZ - 128)) | (1L << (TIMESTAMP - 128)) | (1L << (TIMESTAMPTZ - 128)) | (1L << (TEXT - 128)) | (1L << (VARBINARY - 128)) | (1L << (BLOB - 128)) | (1L << (BYTEA - 128)) | (1L << (INET4 - 128)) | (1L << (LEFT_PAREN - 128)))) != 0) || _la==Identifier );
			setState(412); match(EOF);
			}
		}
		catch (RecognitionException re) {
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
		public Create_extension_statementContext create_extension_statement() {
			return getRuleContext(Create_extension_statementContext.class,0);
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
			setState(419);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(414); data_statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(415); data_change_statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(416); schema_statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(417); index_statement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(418); create_extension_statement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
			setState(421); query_expression();
			}
		}
		catch (RecognitionException re) {
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
			setState(423); insert_statement();
			}
		}
		catch (RecognitionException re) {
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
			setState(427);
			switch (_input.LA(1)) {
			case CREATE:
				enterOuterAlt(_localctx, 1);
				{
				setState(425); create_table_statement();
				}
				break;
			case DROP:
				enterOuterAlt(_localctx, 2);
				{
				setState(426); drop_table_statement();
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
			setState(429); match(CREATE);
			setState(431);
			_la = _input.LA(1);
			if (_la==UNIQUE) {
				{
				setState(430); ((Index_statementContext)_localctx).u = match(UNIQUE);
				}
			}

			setState(433); match(INDEX);
			setState(434); ((Index_statementContext)_localctx).n = identifier();
			setState(435); match(ON);
			setState(436); ((Index_statementContext)_localctx).t = table_name();
			setState(438);
			_la = _input.LA(1);
			if (_la==USING) {
				{
				setState(437); ((Index_statementContext)_localctx).m = method_specifier();
				}
			}

			setState(440); match(LEFT_PAREN);
			setState(441); ((Index_statementContext)_localctx).s = sort_specifier_list();
			setState(442); match(RIGHT_PAREN);
			setState(444);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(443); ((Index_statementContext)_localctx).p = param_clause();
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
			setState(446); match(CREATE);
			setState(447); match(EXTENSION);
			setState(451);
			_la = _input.LA(1);
			if (_la==IF) {
				{
				setState(448); match(IF);
				setState(449); match(NOT);
				setState(450); match(EXISTS);
				}
			}

			setState(453); ((Create_extension_statementContext)_localctx).name = identifier();
			setState(455);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(454); match(WITH);
				}
			}

			setState(459);
			_la = _input.LA(1);
			if (_la==SCHEMA) {
				{
				setState(457); match(SCHEMA);
				setState(458); ((Create_extension_statementContext)_localctx).schema_name = identifier();
				}
			}

			setState(463);
			_la = _input.LA(1);
			if (_la==VERSION) {
				{
				setState(461); match(VERSION);
				setState(462); ((Create_extension_statementContext)_localctx).version = identifier();
				}
			}

			setState(467);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1+1:
				{
				setState(465); match(FROM);
				setState(466); ((Create_extension_statementContext)_localctx).old_version = identifier();
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
		enterRule(_localctx, 14, RULE_create_table_statement);
		int _la;
		try {
			setState(519);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(469); match(CREATE);
				setState(470); match(EXTERNAL);
				setState(471); match(TABLE);
				setState(472); ((Create_table_statementContext)_localctx).n = table_name();
				setState(473); table_elements();
				setState(474); match(USING);
				setState(475); ((Create_table_statementContext)_localctx).file_type = identifier();
				setState(477);
				_la = _input.LA(1);
				if (_la==WITH) {
					{
					setState(476); param_clause();
					}
				}

				setState(480);
				_la = _input.LA(1);
				if (_la==PARTITION) {
					{
					setState(479); table_partitioning_clauses();
					}
				}

				{
				setState(482); match(LOCATION);
				setState(483); ((Create_table_statementContext)_localctx).path = match(Character_String_Literal);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(485); match(CREATE);
				setState(486); match(TABLE);
				setState(487); ((Create_table_statementContext)_localctx).n = table_name();
				setState(488); table_elements();
				setState(491);
				_la = _input.LA(1);
				if (_la==USING) {
					{
					setState(489); match(USING);
					setState(490); ((Create_table_statementContext)_localctx).file_type = identifier();
					}
				}

				setState(494);
				_la = _input.LA(1);
				if (_la==WITH) {
					{
					setState(493); param_clause();
					}
				}

				setState(497);
				switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
				case 1:
					{
					setState(496); table_partitioning_clauses();
					}
					break;
				}
				setState(501);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(499); match(AS);
					setState(500); query_expression();
					}
				}

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(503); match(CREATE);
				setState(504); match(TABLE);
				setState(505); ((Create_table_statementContext)_localctx).n = table_name();
				setState(508);
				_la = _input.LA(1);
				if (_la==USING) {
					{
					setState(506); match(USING);
					setState(507); ((Create_table_statementContext)_localctx).file_type = identifier();
					}
				}

				setState(511);
				_la = _input.LA(1);
				if (_la==WITH) {
					{
					setState(510); param_clause();
					}
				}

				setState(514);
				_la = _input.LA(1);
				if (_la==PARTITION) {
					{
					setState(513); table_partitioning_clauses();
					}
				}

				setState(516); match(AS);
				setState(517); query_expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 16, RULE_table_elements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(521); match(LEFT_PAREN);
			setState(522); field_element();
			setState(527);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(523); match(COMMA);
				setState(524); field_element();
				}
				}
				setState(529);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(530); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 18, RULE_field_element);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(532); ((Field_elementContext)_localctx).name = identifier();
			setState(533); field_type();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 20, RULE_field_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(535); data_type();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 22, RULE_param_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(537); match(WITH);
			setState(538); match(LEFT_PAREN);
			setState(539); param();
			setState(544);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(540); match(COMMA);
				setState(541); param();
				}
				}
				setState(546);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(547); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 24, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(549); ((ParamContext)_localctx).key = match(Character_String_Literal);
			setState(550); match(EQUAL);
			setState(551); ((ParamContext)_localctx).value = numeric_value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 26, RULE_method_specifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(553); match(USING);
			setState(554); ((Method_specifierContext)_localctx).m = identifier();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 28, RULE_table_space_specifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(556); match(TABLESPACE);
			setState(557); table_space_name();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 30, RULE_table_space_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(559); identifier();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 32, RULE_table_partitioning_clauses);
		try {
			setState(565);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(561); range_partitions();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(562); hash_partitions();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(563); list_partitions();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(564); column_partitions();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 34, RULE_range_partitions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(567); match(PARTITION);
			setState(568); match(BY);
			setState(569); match(RANGE);
			setState(570); match(LEFT_PAREN);
			setState(571); column_reference_list();
			setState(572); match(RIGHT_PAREN);
			setState(573); match(LEFT_PAREN);
			setState(574); range_value_clause_list();
			setState(575); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 36, RULE_range_value_clause_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(577); range_value_clause();
			setState(582);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(578); match(COMMA);
				setState(579); range_value_clause();
				}
				}
				setState(584);
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
		enterRule(_localctx, 38, RULE_range_value_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(585); match(PARTITION);
			setState(586); partition_name();
			setState(587); match(VALUES);
			setState(588); match(LESS);
			setState(589); match(THAN);
			setState(601);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				{
				setState(590); match(LEFT_PAREN);
				setState(591); value_expression();
				setState(592); match(RIGHT_PAREN);
				}
				break;
			case 2:
				{
				setState(595);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(594); match(LEFT_PAREN);
					}
				}

				setState(597); match(MAXVALUE);
				setState(599);
				switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
				case 1:
					{
					setState(598); match(RIGHT_PAREN);
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
		enterRule(_localctx, 40, RULE_hash_partitions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(603); match(PARTITION);
			setState(604); match(BY);
			setState(605); match(HASH);
			setState(606); match(LEFT_PAREN);
			setState(607); column_reference_list();
			setState(608); match(RIGHT_PAREN);
			setState(614);
			switch (_input.LA(1)) {
			case LEFT_PAREN:
				{
				setState(609); match(LEFT_PAREN);
				setState(610); individual_hash_partitions();
				setState(611); match(RIGHT_PAREN);
				}
				break;
			case PARTITIONS:
				{
				setState(613); hash_partitions_by_quantity();
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
		enterRule(_localctx, 42, RULE_individual_hash_partitions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(616); individual_hash_partition();
			setState(621);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(617); match(COMMA);
				setState(618); individual_hash_partition();
				}
				}
				setState(623);
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
		enterRule(_localctx, 44, RULE_individual_hash_partition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(624); match(PARTITION);
			setState(625); partition_name();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 46, RULE_hash_partitions_by_quantity);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(627); match(PARTITIONS);
			setState(628); ((Hash_partitions_by_quantityContext)_localctx).quantity = numeric_value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 48, RULE_list_partitions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(630); match(PARTITION);
			setState(631); match(BY);
			setState(632); match(LIST);
			setState(633); match(LEFT_PAREN);
			setState(634); column_reference_list();
			setState(635); match(RIGHT_PAREN);
			setState(636); match(LEFT_PAREN);
			setState(637); list_value_clause_list();
			setState(638); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 50, RULE_list_value_clause_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(640); list_value_partition();
			setState(645);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(641); match(COMMA);
				setState(642); list_value_partition();
				}
				}
				setState(647);
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
		enterRule(_localctx, 52, RULE_list_value_partition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(648); match(PARTITION);
			setState(649); partition_name();
			setState(650); match(VALUES);
			setState(652);
			_la = _input.LA(1);
			if (_la==IN) {
				{
				setState(651); match(IN);
				}
			}

			setState(654); match(LEFT_PAREN);
			setState(655); in_value_list();
			setState(656); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 54, RULE_column_partitions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(658); match(PARTITION);
			setState(659); match(BY);
			setState(660); match(COLUMN);
			setState(661); table_elements();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 56, RULE_partition_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(663); identifier();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 58, RULE_drop_table_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(665); match(DROP);
			setState(666); match(TABLE);
			setState(667); table_name();
			setState(669);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				{
				setState(668); match(PURGE);
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
		enterRule(_localctx, 60, RULE_identifier);
		try {
			setState(673);
			switch (_input.LA(1)) {
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(671); match(Identifier);
				}
				break;
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
			case OVERWRITE:
			case PARTITION:
			case PARTITIONS:
			case PRECISION:
			case PURGE:
			case QUARTER:
			case RANGE:
			case REGEXP:
			case RLIKE:
			case ROLLUP:
			case SECOND:
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
				setState(672); nonreserved_keywords();
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
		public TerminalNode DROP() { return getToken(SQLParser.DROP, 0); }
		public TerminalNode FLOAT8() { return getToken(SQLParser.FLOAT8, 0); }
		public TerminalNode VAR_POP() { return getToken(SQLParser.VAR_POP, 0); }
		public TerminalNode MINUTE() { return getToken(SQLParser.MINUTE, 0); }
		public TerminalNode ISOYEAR() { return getToken(SQLParser.ISOYEAR, 0); }
		public TerminalNode LAST() { return getToken(SQLParser.LAST, 0); }
		public TerminalNode COLUMN() { return getToken(SQLParser.COLUMN, 0); }
		public TerminalNode OVERWRITE() { return getToken(SQLParser.OVERWRITE, 0); }
		public TerminalNode NCHAR() { return getToken(SQLParser.NCHAR, 0); }
		public TerminalNode TIMEZONE_HOUR() { return getToken(SQLParser.TIMEZONE_HOUR, 0); }
		public TerminalNode TIMETZ() { return getToken(SQLParser.TIMETZ, 0); }
		public TerminalNode TABLESPACE() { return getToken(SQLParser.TABLESPACE, 0); }
		public TerminalNode TEXT() { return getToken(SQLParser.TEXT, 0); }
		public TerminalNode MONTH() { return getToken(SQLParser.MONTH, 0); }
		public TerminalNode BLOB() { return getToken(SQLParser.BLOB, 0); }
		public TerminalNode DEC() { return getToken(SQLParser.DEC, 0); }
		public TerminalNode INTERSECTION() { return getToken(SQLParser.INTERSECTION, 0); }
		public TerminalNode LESS() { return getToken(SQLParser.LESS, 0); }
		public TerminalNode MILLENNIUM() { return getToken(SQLParser.MILLENNIUM, 0); }
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
		public TerminalNode NULLIF() { return getToken(SQLParser.NULLIF, 0); }
		public TerminalNode EXISTS() { return getToken(SQLParser.EXISTS, 0); }
		public TerminalNode TIME() { return getToken(SQLParser.TIME, 0); }
		public TerminalNode TRIM() { return getToken(SQLParser.TRIM, 0); }
		public TerminalNode INSERT() { return getToken(SQLParser.INSERT, 0); }
		public TerminalNode DOUBLE() { return getToken(SQLParser.DOUBLE, 0); }
		public TerminalNode LOCATION() { return getToken(SQLParser.LOCATION, 0); }
		public TerminalNode CENTURY() { return getToken(SQLParser.CENTURY, 0); }
		public TerminalNode LIST() { return getToken(SQLParser.LIST, 0); }
		public TerminalNode BY() { return getToken(SQLParser.BY, 0); }
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
		public TerminalNode EPOCH() { return getToken(SQLParser.EPOCH, 0); }
		public TerminalNode REGEXP() { return getToken(SQLParser.REGEXP, 0); }
		public TerminalNode TIMEZONE() { return getToken(SQLParser.TIMEZONE, 0); }
		public TerminalNode FLOAT4() { return getToken(SQLParser.FLOAT4, 0); }
		public TerminalNode CUBE() { return getToken(SQLParser.CUBE, 0); }
		public TerminalNode UNKNOWN() { return getToken(SQLParser.UNKNOWN, 0); }
		public TerminalNode TIMEZONE_MINUTE() { return getToken(SQLParser.TIMEZONE_MINUTE, 0); }
		public TerminalNode BOOLEAN() { return getToken(SQLParser.BOOLEAN, 0); }
		public TerminalNode CHARACTER() { return getToken(SQLParser.CHARACTER, 0); }
		public TerminalNode REAL() { return getToken(SQLParser.REAL, 0); }
		public TerminalNode DAY() { return getToken(SQLParser.DAY, 0); }
		public TerminalNode COLLECT() { return getToken(SQLParser.COLLECT, 0); }
		public TerminalNode BIGINT() { return getToken(SQLParser.BIGINT, 0); }
		public TerminalNode STDDEV_SAMP() { return getToken(SQLParser.STDDEV_SAMP, 0); }
		public TerminalNode RANGE() { return getToken(SQLParser.RANGE, 0); }
		public TerminalNode FLOAT() { return getToken(SQLParser.FLOAT, 0); }
		public TerminalNode EXTRACT() { return getToken(SQLParser.EXTRACT, 0); }
		public TerminalNode MAXVALUE() { return getToken(SQLParser.MAXVALUE, 0); }
		public TerminalNode INT4() { return getToken(SQLParser.INT4, 0); }
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
		enterRule(_localctx, 62, RULE_nonreserved_keywords);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(675);
			_la = _input.LA(1);
			if ( !(((((_la - 57)) & ~0x3f) == 0 && ((1L << (_la - 57)) & ((1L << (AVG - 57)) | (1L << (BETWEEN - 57)) | (1L << (BY - 57)) | (1L << (CENTURY - 57)) | (1L << (CHARACTER - 57)) | (1L << (COLLECT - 57)) | (1L << (COALESCE - 57)) | (1L << (COLUMN - 57)) | (1L << (COUNT - 57)) | (1L << (CUBE - 57)) | (1L << (DAY - 57)) | (1L << (DEC - 57)) | (1L << (DECADE - 57)) | (1L << (DOW - 57)) | (1L << (DOY - 57)) | (1L << (DROP - 57)) | (1L << (EPOCH - 57)) | (1L << (EVERY - 57)) | (1L << (EXISTS - 57)) | (1L << (EXTERNAL - 57)) | (1L << (EXTRACT - 57)) | (1L << (FILTER - 57)) | (1L << (FIRST - 57)) | (1L << (FORMAT - 57)) | (1L << (FUSION - 57)) | (1L << (GROUPING - 57)) | (1L << (HASH - 57)) | (1L << (INDEX - 57)) | (1L << (INSERT - 57)) | (1L << (INTERSECTION - 57)) | (1L << (ISODOW - 57)) | (1L << (ISOYEAR - 57)) | (1L << (LAST - 57)) | (1L << (LESS - 57)) | (1L << (LIST - 57)) | (1L << (LOCATION - 57)) | (1L << (MAX - 57)) | (1L << (MAXVALUE - 57)) | (1L << (MICROSECONDS - 57)) | (1L << (MILLENNIUM - 57)) | (1L << (MILLISECONDS - 57)) | (1L << (MIN - 57)) | (1L << (MINUTE - 57)) | (1L << (MONTH - 57)) | (1L << (NATIONAL - 57)) | (1L << (NULLIF - 57)) | (1L << (OVERWRITE - 57)) | (1L << (PARTITION - 57)) | (1L << (PARTITIONS - 57)) | (1L << (PRECISION - 57)) | (1L << (PURGE - 57)) | (1L << (QUARTER - 57)) | (1L << (RANGE - 57)) | (1L << (REGEXP - 57)) | (1L << (RLIKE - 57)) | (1L << (ROLLUP - 57)) | (1L << (SECOND - 57)) | (1L << (SET - 57)) | (1L << (SIMILAR - 57)) | (1L << (STDDEV_POP - 57)) | (1L << (STDDEV_SAMP - 57)) | (1L << (SUBPARTITION - 57)) | (1L << (SUM - 57)))) != 0) || ((((_la - 121)) & ~0x3f) == 0 && ((1L << (_la - 121)) & ((1L << (TABLESPACE - 121)) | (1L << (THAN - 121)) | (1L << (TIMEZONE - 121)) | (1L << (TIMEZONE_HOUR - 121)) | (1L << (TIMEZONE_MINUTE - 121)) | (1L << (TRIM - 121)) | (1L << (TO - 121)) | (1L << (UNKNOWN - 121)) | (1L << (VALUES - 121)) | (1L << (VAR_SAMP - 121)) | (1L << (VAR_POP - 121)) | (1L << (VARYING - 121)) | (1L << (WEEK - 121)) | (1L << (YEAR - 121)) | (1L << (ZONE - 121)) | (1L << (BOOLEAN - 121)) | (1L << (BOOL - 121)) | (1L << (BIT - 121)) | (1L << (VARBIT - 121)) | (1L << (INT1 - 121)) | (1L << (INT2 - 121)) | (1L << (INT4 - 121)) | (1L << (INT8 - 121)) | (1L << (TINYINT - 121)) | (1L << (SMALLINT - 121)) | (1L << (INT - 121)) | (1L << (INTEGER - 121)) | (1L << (BIGINT - 121)) | (1L << (FLOAT4 - 121)) | (1L << (FLOAT8 - 121)) | (1L << (REAL - 121)) | (1L << (FLOAT - 121)) | (1L << (DOUBLE - 121)) | (1L << (NUMERIC - 121)) | (1L << (DECIMAL - 121)) | (1L << (CHAR - 121)) | (1L << (VARCHAR - 121)) | (1L << (NCHAR - 121)) | (1L << (NVARCHAR - 121)) | (1L << (DATE - 121)) | (1L << (TIME - 121)) | (1L << (TIMETZ - 121)) | (1L << (TIMESTAMP - 121)) | (1L << (TIMESTAMPTZ - 121)) | (1L << (TEXT - 121)) | (1L << (VARBINARY - 121)) | (1L << (BLOB - 121)) | (1L << (BYTEA - 121)) | (1L << (INET4 - 121)))) != 0)) ) {
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
		enterRule(_localctx, 64, RULE_unsigned_literal);
		try {
			setState(679);
			switch (_input.LA(1)) {
			case NUMBER:
			case REAL_NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(677); unsigned_numeric_literal();
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
				setState(678); general_literal();
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
		enterRule(_localctx, 66, RULE_general_literal);
		try {
			setState(684);
			switch (_input.LA(1)) {
			case Character_String_Literal:
				enterOuterAlt(_localctx, 1);
				{
				setState(681); match(Character_String_Literal);
				}
				break;
			case DATE:
			case TIME:
			case TIMESTAMP:
				enterOuterAlt(_localctx, 2);
				{
				setState(682); datetime_literal();
				}
				break;
			case FALSE:
			case TRUE:
			case UNKNOWN:
				enterOuterAlt(_localctx, 3);
				{
				setState(683); boolean_literal();
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
		enterRule(_localctx, 68, RULE_datetime_literal);
		try {
			setState(689);
			switch (_input.LA(1)) {
			case TIMESTAMP:
				enterOuterAlt(_localctx, 1);
				{
				setState(686); timestamp_literal();
				}
				break;
			case TIME:
				enterOuterAlt(_localctx, 2);
				{
				setState(687); time_literal();
				}
				break;
			case DATE:
				enterOuterAlt(_localctx, 3);
				{
				setState(688); date_literal();
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
		enterRule(_localctx, 70, RULE_time_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(691); match(TIME);
			setState(692); ((Time_literalContext)_localctx).time_string = match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 72, RULE_timestamp_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(694); match(TIMESTAMP);
			setState(695); ((Timestamp_literalContext)_localctx).timestamp_string = match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 74, RULE_date_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(697); match(DATE);
			setState(698); ((Date_literalContext)_localctx).date_string = match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 76, RULE_boolean_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(700);
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
		enterRule(_localctx, 78, RULE_data_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(702); predefined_type();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 80, RULE_predefined_type);
		try {
			setState(713);
			switch (_input.LA(1)) {
			case CHARACTER:
			case CHAR:
			case VARCHAR:
			case TEXT:
				enterOuterAlt(_localctx, 1);
				{
				setState(704); character_string_type();
				}
				break;
			case NATIONAL:
			case NCHAR:
			case NVARCHAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(705); national_character_string_type();
				}
				break;
			case BLOB:
			case BYTEA:
				enterOuterAlt(_localctx, 3);
				{
				setState(706); binary_large_object_string_type();
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
				setState(707); numeric_type();
				}
				break;
			case BOOLEAN:
			case BOOL:
				enterOuterAlt(_localctx, 5);
				{
				setState(708); boolean_type();
				}
				break;
			case DATE:
			case TIME:
			case TIMETZ:
			case TIMESTAMP:
			case TIMESTAMPTZ:
				enterOuterAlt(_localctx, 6);
				{
				setState(709); datetime_type();
				}
				break;
			case BIT:
			case VARBIT:
				enterOuterAlt(_localctx, 7);
				{
				setState(710); bit_type();
				}
				break;
			case BINARY:
			case VARBINARY:
				enterOuterAlt(_localctx, 8);
				{
				setState(711); binary_type();
				}
				break;
			case INET4:
				enterOuterAlt(_localctx, 9);
				{
				setState(712); network_type();
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
		enterRule(_localctx, 82, RULE_network_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(715); match(INET4);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 84, RULE_character_string_type);
		try {
			setState(740);
			switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(717); match(CHARACTER);
				setState(719);
				switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
				case 1:
					{
					setState(718); type_length();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(721); match(CHAR);
				setState(723);
				switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
				case 1:
					{
					setState(722); type_length();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(725); match(CHARACTER);
				setState(726); match(VARYING);
				setState(728);
				switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
				case 1:
					{
					setState(727); type_length();
					}
					break;
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(730); match(CHAR);
				setState(731); match(VARYING);
				setState(733);
				switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
				case 1:
					{
					setState(732); type_length();
					}
					break;
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(735); match(VARCHAR);
				setState(737);
				switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
				case 1:
					{
					setState(736); type_length();
					}
					break;
				}
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(739); match(TEXT);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 86, RULE_type_length);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(742); match(LEFT_PAREN);
			setState(743); match(NUMBER);
			setState(744); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 88, RULE_national_character_string_type);
		try {
			setState(781);
			switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(746); match(NATIONAL);
				setState(747); match(CHARACTER);
				setState(749);
				switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
				case 1:
					{
					setState(748); type_length();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(751); match(NATIONAL);
				setState(752); match(CHAR);
				setState(754);
				switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
				case 1:
					{
					setState(753); type_length();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(756); match(NCHAR);
				setState(758);
				switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
				case 1:
					{
					setState(757); type_length();
					}
					break;
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(760); match(NATIONAL);
				setState(761); match(CHARACTER);
				setState(762); match(VARYING);
				setState(764);
				switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
				case 1:
					{
					setState(763); type_length();
					}
					break;
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(766); match(NATIONAL);
				setState(767); match(CHAR);
				setState(768); match(VARYING);
				setState(770);
				switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
				case 1:
					{
					setState(769); type_length();
					}
					break;
				}
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(772); match(NCHAR);
				setState(773); match(VARYING);
				setState(775);
				switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
				case 1:
					{
					setState(774); type_length();
					}
					break;
				}
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(777); match(NVARCHAR);
				setState(779);
				switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
				case 1:
					{
					setState(778); type_length();
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
		enterRule(_localctx, 90, RULE_binary_large_object_string_type);
		try {
			setState(791);
			switch (_input.LA(1)) {
			case BLOB:
				enterOuterAlt(_localctx, 1);
				{
				setState(783); match(BLOB);
				setState(785);
				switch ( getInterpreter().adaptivePredict(_input,53,_ctx) ) {
				case 1:
					{
					setState(784); type_length();
					}
					break;
				}
				}
				break;
			case BYTEA:
				enterOuterAlt(_localctx, 2);
				{
				setState(787); match(BYTEA);
				setState(789);
				switch ( getInterpreter().adaptivePredict(_input,54,_ctx) ) {
				case 1:
					{
					setState(788); type_length();
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
		enterRule(_localctx, 92, RULE_numeric_type);
		try {
			setState(795);
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
				setState(793); exact_numeric_type();
				}
				break;
			case FLOAT4:
			case FLOAT8:
			case REAL:
			case FLOAT:
			case DOUBLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(794); approximate_numeric_type();
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
		enterRule(_localctx, 94, RULE_exact_numeric_type);
		try {
			setState(818);
			switch (_input.LA(1)) {
			case NUMERIC:
				enterOuterAlt(_localctx, 1);
				{
				setState(797); match(NUMERIC);
				setState(799);
				switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
				case 1:
					{
					setState(798); precision_param();
					}
					break;
				}
				}
				break;
			case DECIMAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(801); match(DECIMAL);
				setState(803);
				switch ( getInterpreter().adaptivePredict(_input,58,_ctx) ) {
				case 1:
					{
					setState(802); precision_param();
					}
					break;
				}
				}
				break;
			case DEC:
				enterOuterAlt(_localctx, 3);
				{
				setState(805); match(DEC);
				setState(807);
				switch ( getInterpreter().adaptivePredict(_input,59,_ctx) ) {
				case 1:
					{
					setState(806); precision_param();
					}
					break;
				}
				}
				break;
			case INT1:
				enterOuterAlt(_localctx, 4);
				{
				setState(809); match(INT1);
				}
				break;
			case TINYINT:
				enterOuterAlt(_localctx, 5);
				{
				setState(810); match(TINYINT);
				}
				break;
			case INT2:
				enterOuterAlt(_localctx, 6);
				{
				setState(811); match(INT2);
				}
				break;
			case SMALLINT:
				enterOuterAlt(_localctx, 7);
				{
				setState(812); match(SMALLINT);
				}
				break;
			case INT4:
				enterOuterAlt(_localctx, 8);
				{
				setState(813); match(INT4);
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 9);
				{
				setState(814); match(INT);
				}
				break;
			case INTEGER:
				enterOuterAlt(_localctx, 10);
				{
				setState(815); match(INTEGER);
				}
				break;
			case INT8:
				enterOuterAlt(_localctx, 11);
				{
				setState(816); match(INT8);
				}
				break;
			case BIGINT:
				enterOuterAlt(_localctx, 12);
				{
				setState(817); match(BIGINT);
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
		enterRule(_localctx, 96, RULE_approximate_numeric_type);
		try {
			setState(830);
			switch ( getInterpreter().adaptivePredict(_input,62,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(820); match(FLOAT);
				setState(822);
				switch ( getInterpreter().adaptivePredict(_input,61,_ctx) ) {
				case 1:
					{
					setState(821); precision_param();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(824); match(FLOAT4);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(825); match(REAL);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(826); match(FLOAT8);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(827); match(DOUBLE);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(828); match(DOUBLE);
				setState(829); match(PRECISION);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 98, RULE_precision_param);
		try {
			setState(840);
			switch ( getInterpreter().adaptivePredict(_input,63,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(832); match(LEFT_PAREN);
				setState(833); ((Precision_paramContext)_localctx).precision = match(NUMBER);
				setState(834); match(RIGHT_PAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(835); match(LEFT_PAREN);
				setState(836); ((Precision_paramContext)_localctx).precision = match(NUMBER);
				setState(837); match(COMMA);
				setState(838); ((Precision_paramContext)_localctx).scale = match(NUMBER);
				setState(839); match(RIGHT_PAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 100, RULE_boolean_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(842);
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
		enterRule(_localctx, 102, RULE_datetime_type);
		try {
			setState(857);
			switch ( getInterpreter().adaptivePredict(_input,64,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(844); match(DATE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(845); match(TIME);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(846); match(TIME);
				setState(847); match(WITH);
				setState(848); match(TIME);
				setState(849); match(ZONE);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(850); match(TIMETZ);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(851); match(TIMESTAMP);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(852); match(TIMESTAMP);
				setState(853); match(WITH);
				setState(854); match(TIME);
				setState(855); match(ZONE);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(856); match(TIMESTAMPTZ);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 104, RULE_bit_type);
		try {
			setState(872);
			switch ( getInterpreter().adaptivePredict(_input,68,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(859); match(BIT);
				setState(861);
				switch ( getInterpreter().adaptivePredict(_input,65,_ctx) ) {
				case 1:
					{
					setState(860); type_length();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(863); match(VARBIT);
				setState(865);
				switch ( getInterpreter().adaptivePredict(_input,66,_ctx) ) {
				case 1:
					{
					setState(864); type_length();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(867); match(BIT);
				setState(868); match(VARYING);
				setState(870);
				switch ( getInterpreter().adaptivePredict(_input,67,_ctx) ) {
				case 1:
					{
					setState(869); type_length();
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
		enterRule(_localctx, 106, RULE_binary_type);
		try {
			setState(887);
			switch ( getInterpreter().adaptivePredict(_input,72,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(874); match(BINARY);
				setState(876);
				switch ( getInterpreter().adaptivePredict(_input,69,_ctx) ) {
				case 1:
					{
					setState(875); type_length();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(878); match(BINARY);
				setState(879); match(VARYING);
				setState(881);
				switch ( getInterpreter().adaptivePredict(_input,70,_ctx) ) {
				case 1:
					{
					setState(880); type_length();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(883); match(VARBINARY);
				setState(885);
				switch ( getInterpreter().adaptivePredict(_input,71,_ctx) ) {
				case 1:
					{
					setState(884); type_length();
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
		enterRule(_localctx, 108, RULE_value_expression_primary);
		try {
			setState(891);
			switch ( getInterpreter().adaptivePredict(_input,73,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(889); parenthesized_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(890); nonparenthesized_value_expression_primary();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 110, RULE_parenthesized_value_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(893); match(LEFT_PAREN);
			setState(894); value_expression();
			setState(895); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 112, RULE_nonparenthesized_value_expression_primary);
		try {
			setState(904);
			switch ( getInterpreter().adaptivePredict(_input,74,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(897); unsigned_value_specification();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(898); column_reference();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(899); set_function_specification();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(900); scalar_subquery();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(901); case_expression();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(902); cast_specification();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(903); routine_invocation();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 114, RULE_unsigned_value_specification);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(906); unsigned_literal();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 116, RULE_unsigned_numeric_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(908);
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
		enterRule(_localctx, 118, RULE_signed_numerical_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(911);
			_la = _input.LA(1);
			if (_la==PLUS || _la==MINUS) {
				{
				setState(910); sign();
				}
			}

			setState(913); unsigned_numeric_literal();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 120, RULE_set_function_specification);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(915); aggregate_function();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 122, RULE_aggregate_function);
		try {
			setState(925);
			switch ( getInterpreter().adaptivePredict(_input,77,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(917); match(COUNT);
				setState(918); match(LEFT_PAREN);
				setState(919); match(MULTIPLY);
				setState(920); match(RIGHT_PAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(921); general_set_function();
				setState(923);
				switch ( getInterpreter().adaptivePredict(_input,76,_ctx) ) {
				case 1:
					{
					setState(922); filter_clause();
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
		enterRule(_localctx, 124, RULE_general_set_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(927); set_function_type();
			setState(928); match(LEFT_PAREN);
			setState(930);
			_la = _input.LA(1);
			if (_la==ALL || _la==DISTINCT) {
				{
				setState(929); set_qualifier();
				}
			}

			setState(932); value_expression();
			setState(933); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 126, RULE_set_function_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(935);
			_la = _input.LA(1);
			if ( !(((((_la - 4)) & ~0x3f) == 0 && ((1L << (_la - 4)) & ((1L << (ANY - 4)) | (1L << (SOME - 4)) | (1L << (AVG - 4)) | (1L << (COLLECT - 4)) | (1L << (COUNT - 4)))) != 0) || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & ((1L << (EVERY - 74)) | (1L << (FUSION - 74)) | (1L << (INTERSECTION - 74)) | (1L << (MAX - 74)) | (1L << (MIN - 74)) | (1L << (STDDEV_POP - 74)) | (1L << (STDDEV_SAMP - 74)) | (1L << (SUM - 74)) | (1L << (VAR_SAMP - 74)) | (1L << (VAR_POP - 74)))) != 0)) ) {
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
		enterRule(_localctx, 128, RULE_filter_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(937); match(FILTER);
			setState(938); match(LEFT_PAREN);
			setState(939); match(WHERE);
			setState(940); search_condition();
			setState(941); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 130, RULE_grouping_operation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(943); match(GROUPING);
			setState(944); match(LEFT_PAREN);
			setState(945); column_reference_list();
			setState(946); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 132, RULE_case_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(948); case_specification();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 134, RULE_case_abbreviation);
		int _la;
		try {
			setState(968);
			switch (_input.LA(1)) {
			case NULLIF:
				enterOuterAlt(_localctx, 1);
				{
				setState(950); match(NULLIF);
				setState(951); match(LEFT_PAREN);
				setState(952); numeric_value_expression();
				setState(953); match(COMMA);
				setState(954); boolean_value_expression();
				setState(955); match(RIGHT_PAREN);
				}
				break;
			case COALESCE:
				enterOuterAlt(_localctx, 2);
				{
				setState(957); match(COALESCE);
				setState(958); match(LEFT_PAREN);
				setState(959); numeric_value_expression();
				setState(962); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(960); match(COMMA);
					setState(961); boolean_value_expression();
					}
					}
					setState(964); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==COMMA );
				setState(966); match(RIGHT_PAREN);
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
		enterRule(_localctx, 136, RULE_case_specification);
		try {
			setState(972);
			switch ( getInterpreter().adaptivePredict(_input,81,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(970); simple_case();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(971); searched_case();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 138, RULE_simple_case);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(974); match(CASE);
			setState(975); boolean_value_expression();
			setState(977); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(976); simple_when_clause();
				}
				}
				setState(979); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WHEN );
			setState(982);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(981); else_clause();
				}
			}

			setState(984); match(END);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 140, RULE_searched_case);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(986); match(CASE);
			setState(988); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(987); searched_when_clause();
				}
				}
				setState(990); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WHEN );
			setState(993);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(992); else_clause();
				}
			}

			setState(995); match(END);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 142, RULE_simple_when_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(997); match(WHEN);
			setState(998); search_condition();
			setState(999); match(THEN);
			setState(1000); result();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 144, RULE_searched_when_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1002); match(WHEN);
			setState(1003); ((Searched_when_clauseContext)_localctx).c = search_condition();
			setState(1004); match(THEN);
			setState(1005); ((Searched_when_clauseContext)_localctx).r = result();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 146, RULE_else_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1007); match(ELSE);
			setState(1008); ((Else_clauseContext)_localctx).r = result();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 148, RULE_result);
		try {
			setState(1012);
			switch ( getInterpreter().adaptivePredict(_input,86,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1010); value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1011); match(NULL);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 150, RULE_cast_specification);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1014); match(CAST);
			setState(1015); match(LEFT_PAREN);
			setState(1016); cast_operand();
			setState(1017); match(AS);
			setState(1018); cast_target();
			setState(1019); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 152, RULE_cast_operand);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1021); value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 154, RULE_cast_target);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1023); data_type();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 156, RULE_value_expression);
		try {
			setState(1028);
			switch ( getInterpreter().adaptivePredict(_input,87,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1025); common_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1026); row_value_expression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1027); boolean_value_expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 158, RULE_common_value_expression);
		try {
			setState(1033);
			switch ( getInterpreter().adaptivePredict(_input,88,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1030); numeric_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1031); string_value_expression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1032); match(NULL);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 160, RULE_numeric_value_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1035); ((Numeric_value_expressionContext)_localctx).left = term();
			setState(1040);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				{
				setState(1036);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(1037); ((Numeric_value_expressionContext)_localctx).right = term();
				}
				}
				setState(1042);
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
		enterRule(_localctx, 162, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1043); ((TermContext)_localctx).left = factor();
			setState(1048);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (MULTIPLY - 192)) | (1L << (DIVIDE - 192)) | (1L << (MODULAR - 192)))) != 0)) {
				{
				{
				setState(1044);
				_la = _input.LA(1);
				if ( !(((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (MULTIPLY - 192)) | (1L << (DIVIDE - 192)) | (1L << (MODULAR - 192)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(1045); ((TermContext)_localctx).right = factor();
				}
				}
				setState(1050);
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
		enterRule(_localctx, 164, RULE_factor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1052);
			_la = _input.LA(1);
			if (_la==PLUS || _la==MINUS) {
				{
				setState(1051); sign();
				}
			}

			setState(1054); numeric_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 166, RULE_array);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1056); match(LEFT_PAREN);
			setState(1057); numeric_value_expression();
			setState(1062);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1058); match(COMMA);
				setState(1059); numeric_value_expression();
				}
				}
				setState(1064);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1065); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 168, RULE_numeric_primary);
		int _la;
		try {
			setState(1076);
			switch ( getInterpreter().adaptivePredict(_input,94,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1067); value_expression_primary();
				setState(1072);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CAST_EXPRESSION) {
					{
					{
					setState(1068); match(CAST_EXPRESSION);
					setState(1069); cast_target();
					}
					}
					setState(1074);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1075); numeric_value_function();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 170, RULE_sign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1078);
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
		enterRule(_localctx, 172, RULE_numeric_value_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1080); extract_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 174, RULE_extract_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1082); match(EXTRACT);
			setState(1083); match(LEFT_PAREN);
			setState(1084); ((Extract_expressionContext)_localctx).extract_field_string = extract_field();
			setState(1085); match(FROM);
			setState(1086); extract_source();
			setState(1087); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 176, RULE_extract_field);
		try {
			setState(1092);
			switch (_input.LA(1)) {
			case DAY:
			case HOUR:
			case MINUTE:
			case MONTH:
			case SECOND:
			case YEAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(1089); primary_datetime_field();
				}
				break;
			case TIMEZONE:
			case TIMEZONE_HOUR:
			case TIMEZONE_MINUTE:
				enterOuterAlt(_localctx, 2);
				{
				setState(1090); time_zone_field();
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
				setState(1091); extended_datetime_field();
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
		enterRule(_localctx, 178, RULE_time_zone_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1094);
			_la = _input.LA(1);
			if ( !(((((_la - 123)) & ~0x3f) == 0 && ((1L << (_la - 123)) & ((1L << (TIMEZONE - 123)) | (1L << (TIMEZONE_HOUR - 123)) | (1L << (TIMEZONE_MINUTE - 123)))) != 0)) ) {
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
		enterRule(_localctx, 180, RULE_extract_source);
		try {
			setState(1098);
			switch ( getInterpreter().adaptivePredict(_input,96,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1096); column_reference();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1097); datetime_literal();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 182, RULE_string_value_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1100); character_value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 184, RULE_character_value_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1102); character_factor();
			setState(1107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CONCATENATION_OPERATOR) {
				{
				{
				setState(1103); match(CONCATENATION_OPERATOR);
				setState(1104); character_factor();
				}
				}
				setState(1109);
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
		enterRule(_localctx, 186, RULE_character_factor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1110); character_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 188, RULE_character_primary);
		try {
			setState(1114);
			switch ( getInterpreter().adaptivePredict(_input,98,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1112); value_expression_primary();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1113); string_value_function();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 190, RULE_string_value_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1116); trim_function();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 192, RULE_trim_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1118); match(TRIM);
			setState(1119); match(LEFT_PAREN);
			setState(1120); trim_operands();
			setState(1121); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 194, RULE_trim_operands);
		int _la;
		try {
			setState(1137);
			switch ( getInterpreter().adaptivePredict(_input,102,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1130);
				switch ( getInterpreter().adaptivePredict(_input,101,_ctx) ) {
				case 1:
					{
					setState(1124);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOTH) | (1L << LEADING) | (1L << TRAILING))) != 0)) {
						{
						setState(1123); trim_specification();
						}
					}

					setState(1127);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ANY) | (1L << CASE) | (1L << CAST) | (1L << FALSE) | (1L << LEFT) | (1L << RIGHT) | (1L << SOME) | (1L << TRUE) | (1L << AVG) | (1L << BETWEEN) | (1L << BY) | (1L << CENTURY) | (1L << CHARACTER) | (1L << COLLECT) | (1L << COALESCE))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (COLUMN - 64)) | (1L << (COUNT - 64)) | (1L << (CUBE - 64)) | (1L << (DAY - 64)) | (1L << (DEC - 64)) | (1L << (DECADE - 64)) | (1L << (DOW - 64)) | (1L << (DOY - 64)) | (1L << (DROP - 64)) | (1L << (EPOCH - 64)) | (1L << (EVERY - 64)) | (1L << (EXISTS - 64)) | (1L << (EXTERNAL - 64)) | (1L << (EXTRACT - 64)) | (1L << (FILTER - 64)) | (1L << (FIRST - 64)) | (1L << (FORMAT - 64)) | (1L << (FUSION - 64)) | (1L << (GROUPING - 64)) | (1L << (HASH - 64)) | (1L << (INDEX - 64)) | (1L << (INSERT - 64)) | (1L << (INTERSECTION - 64)) | (1L << (ISODOW - 64)) | (1L << (ISOYEAR - 64)) | (1L << (LAST - 64)) | (1L << (LESS - 64)) | (1L << (LIST - 64)) | (1L << (LOCATION - 64)) | (1L << (MAX - 64)) | (1L << (MAXVALUE - 64)) | (1L << (MICROSECONDS - 64)) | (1L << (MILLENNIUM - 64)) | (1L << (MILLISECONDS - 64)) | (1L << (MIN - 64)) | (1L << (MINUTE - 64)) | (1L << (MONTH - 64)) | (1L << (NATIONAL - 64)) | (1L << (NULLIF - 64)) | (1L << (OVERWRITE - 64)) | (1L << (PARTITION - 64)) | (1L << (PARTITIONS - 64)) | (1L << (PRECISION - 64)) | (1L << (PURGE - 64)) | (1L << (QUARTER - 64)) | (1L << (RANGE - 64)) | (1L << (REGEXP - 64)) | (1L << (RLIKE - 64)) | (1L << (ROLLUP - 64)) | (1L << (SECOND - 64)) | (1L << (SET - 64)) | (1L << (SIMILAR - 64)) | (1L << (STDDEV_POP - 64)) | (1L << (STDDEV_SAMP - 64)) | (1L << (SUBPARTITION - 64)) | (1L << (SUM - 64)) | (1L << (TABLESPACE - 64)) | (1L << (THAN - 64)) | (1L << (TIMEZONE - 64)) | (1L << (TIMEZONE_HOUR - 64)) | (1L << (TIMEZONE_MINUTE - 64)) | (1L << (TRIM - 64)) | (1L << (TO - 64)))) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (UNKNOWN - 128)) | (1L << (VALUES - 128)) | (1L << (VAR_SAMP - 128)) | (1L << (VAR_POP - 128)) | (1L << (VARYING - 128)) | (1L << (WEEK - 128)) | (1L << (YEAR - 128)) | (1L << (ZONE - 128)) | (1L << (BOOLEAN - 128)) | (1L << (BOOL - 128)) | (1L << (BIT - 128)) | (1L << (VARBIT - 128)) | (1L << (INT1 - 128)) | (1L << (INT2 - 128)) | (1L << (INT4 - 128)) | (1L << (INT8 - 128)) | (1L << (TINYINT - 128)) | (1L << (SMALLINT - 128)) | (1L << (INT - 128)) | (1L << (INTEGER - 128)) | (1L << (BIGINT - 128)) | (1L << (FLOAT4 - 128)) | (1L << (FLOAT8 - 128)) | (1L << (REAL - 128)) | (1L << (FLOAT - 128)) | (1L << (DOUBLE - 128)) | (1L << (NUMERIC - 128)) | (1L << (DECIMAL - 128)) | (1L << (CHAR - 128)) | (1L << (VARCHAR - 128)) | (1L << (NCHAR - 128)) | (1L << (NVARCHAR - 128)) | (1L << (DATE - 128)) | (1L << (TIME - 128)) | (1L << (TIMETZ - 128)) | (1L << (TIMESTAMP - 128)) | (1L << (TIMESTAMPTZ - 128)) | (1L << (TEXT - 128)) | (1L << (VARBINARY - 128)) | (1L << (BLOB - 128)) | (1L << (BYTEA - 128)) | (1L << (INET4 - 128)) | (1L << (LEFT_PAREN - 128)))) != 0) || ((((_la - 200)) & ~0x3f) == 0 && ((1L << (_la - 200)) & ((1L << (NUMBER - 200)) | (1L << (REAL_NUMBER - 200)) | (1L << (Identifier - 200)) | (1L << (Character_String_Literal - 200)))) != 0)) {
						{
						setState(1126); ((Trim_operandsContext)_localctx).trim_character = character_value_expression();
						}
					}

					setState(1129); match(FROM);
					}
					break;
				}
				setState(1132); ((Trim_operandsContext)_localctx).trim_source = character_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1133); ((Trim_operandsContext)_localctx).trim_source = character_value_expression();
				setState(1134); match(COMMA);
				setState(1135); ((Trim_operandsContext)_localctx).trim_character = character_value_expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 196, RULE_trim_specification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1139);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOTH) | (1L << LEADING) | (1L << TRAILING))) != 0)) ) {
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
		enterRule(_localctx, 198, RULE_boolean_value_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1141); or_predicate();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 200, RULE_or_predicate);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1143); and_predicate();
			setState(1148);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,103,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1144); match(OR);
					setState(1145); or_predicate();
					}
					} 
				}
				setState(1150);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,103,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 202, RULE_and_predicate);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1151); boolean_factor();
			setState(1156);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,104,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1152); match(AND);
					setState(1153); and_predicate();
					}
					} 
				}
				setState(1158);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,104,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 204, RULE_boolean_factor);
		try {
			setState(1162);
			switch ( getInterpreter().adaptivePredict(_input,105,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1159); boolean_test();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1160); match(NOT);
				setState(1161); boolean_test();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 206, RULE_boolean_test);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1164); boolean_primary();
			setState(1166);
			_la = _input.LA(1);
			if (_la==IS) {
				{
				setState(1165); is_clause();
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
		enterRule(_localctx, 208, RULE_is_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1168); match(IS);
			setState(1170);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(1169); match(NOT);
				}
			}

			setState(1172); ((Is_clauseContext)_localctx).t = truth_value();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 210, RULE_truth_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1174);
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
		enterRule(_localctx, 212, RULE_boolean_primary);
		try {
			setState(1178);
			switch ( getInterpreter().adaptivePredict(_input,108,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1176); predicate();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1177); boolean_predicand();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 214, RULE_boolean_predicand);
		try {
			setState(1182);
			switch ( getInterpreter().adaptivePredict(_input,109,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1180); parenthesized_boolean_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1181); nonparenthesized_value_expression_primary();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 216, RULE_parenthesized_boolean_value_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1184); match(LEFT_PAREN);
			setState(1185); boolean_value_expression();
			setState(1186); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 218, RULE_row_value_expression);
		try {
			setState(1190);
			switch (_input.LA(1)) {
			case ANY:
			case CASE:
			case CAST:
			case FALSE:
			case LEFT:
			case RIGHT:
			case SOME:
			case TRUE:
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
			case OVERWRITE:
			case PARTITION:
			case PARTITIONS:
			case PRECISION:
			case PURGE:
			case QUARTER:
			case RANGE:
			case REGEXP:
			case RLIKE:
			case ROLLUP:
			case SECOND:
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
				setState(1188); row_value_special_case();
				}
				break;
			case NULL:
				enterOuterAlt(_localctx, 2);
				{
				setState(1189); explicit_row_value_constructor();
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
		enterRule(_localctx, 220, RULE_row_value_special_case);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1192); nonparenthesized_value_expression_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 222, RULE_explicit_row_value_constructor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1194); match(NULL);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 224, RULE_row_value_predicand);
		try {
			setState(1198);
			switch ( getInterpreter().adaptivePredict(_input,111,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1196); row_value_special_case();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1197); row_value_constructor_predicand();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 226, RULE_row_value_constructor_predicand);
		try {
			setState(1202);
			switch ( getInterpreter().adaptivePredict(_input,112,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1200); common_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1201); boolean_predicand();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 228, RULE_table_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1204); from_clause();
			setState(1206);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(1205); where_clause();
				}
			}

			setState(1209);
			_la = _input.LA(1);
			if (_la==GROUP) {
				{
				setState(1208); groupby_clause();
				}
			}

			setState(1212);
			_la = _input.LA(1);
			if (_la==HAVING) {
				{
				setState(1211); having_clause();
				}
			}

			setState(1215);
			_la = _input.LA(1);
			if (_la==ORDER) {
				{
				setState(1214); orderby_clause();
				}
			}

			setState(1218);
			_la = _input.LA(1);
			if (_la==LIMIT) {
				{
				setState(1217); limit_clause();
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
		enterRule(_localctx, 230, RULE_from_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1220); match(FROM);
			setState(1221); table_reference_list();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 232, RULE_table_reference_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1223); table_reference();
			setState(1228);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1224); match(COMMA);
				setState(1225); table_reference();
				}
				}
				setState(1230);
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
		enterRule(_localctx, 234, RULE_table_reference);
		try {
			setState(1233);
			switch ( getInterpreter().adaptivePredict(_input,119,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1231); joined_table();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1232); table_primary();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 236, RULE_joined_table);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1235); table_primary();
			setState(1237); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(1236); joined_table_primary();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1239); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,120,_ctx);
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
		enterRule(_localctx, 238, RULE_joined_table_primary);
		int _la;
		try {
			setState(1260);
			switch (_input.LA(1)) {
			case CROSS:
				enterOuterAlt(_localctx, 1);
				{
				setState(1241); match(CROSS);
				setState(1242); match(JOIN);
				setState(1243); ((Joined_table_primaryContext)_localctx).right = table_primary();
				}
				break;
			case FULL:
			case INNER:
			case JOIN:
			case LEFT:
			case RIGHT:
				enterOuterAlt(_localctx, 2);
				{
				setState(1245);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FULL) | (1L << INNER) | (1L << LEFT) | (1L << RIGHT))) != 0)) {
					{
					setState(1244); ((Joined_table_primaryContext)_localctx).t = join_type();
					}
				}

				setState(1247); match(JOIN);
				setState(1248); ((Joined_table_primaryContext)_localctx).right = table_primary();
				setState(1249); ((Joined_table_primaryContext)_localctx).s = join_specification();
				}
				break;
			case NATURAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(1251); match(NATURAL);
				setState(1253);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FULL) | (1L << INNER) | (1L << LEFT) | (1L << RIGHT))) != 0)) {
					{
					setState(1252); ((Joined_table_primaryContext)_localctx).t = join_type();
					}
				}

				setState(1255); match(JOIN);
				setState(1256); ((Joined_table_primaryContext)_localctx).right = table_primary();
				}
				break;
			case UNION:
				enterOuterAlt(_localctx, 4);
				{
				setState(1257); match(UNION);
				setState(1258); match(JOIN);
				setState(1259); ((Joined_table_primaryContext)_localctx).right = table_primary();
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
		enterRule(_localctx, 240, RULE_cross_join);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1262); match(CROSS);
			setState(1263); match(JOIN);
			setState(1264); ((Cross_joinContext)_localctx).r = table_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 242, RULE_qualified_join);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1267);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FULL) | (1L << INNER) | (1L << LEFT) | (1L << RIGHT))) != 0)) {
				{
				setState(1266); ((Qualified_joinContext)_localctx).t = join_type();
				}
			}

			setState(1269); match(JOIN);
			setState(1270); ((Qualified_joinContext)_localctx).r = table_primary();
			setState(1271); ((Qualified_joinContext)_localctx).s = join_specification();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 244, RULE_natural_join);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1273); match(NATURAL);
			setState(1275);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FULL) | (1L << INNER) | (1L << LEFT) | (1L << RIGHT))) != 0)) {
				{
				setState(1274); ((Natural_joinContext)_localctx).t = join_type();
				}
			}

			setState(1277); match(JOIN);
			setState(1278); ((Natural_joinContext)_localctx).r = table_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 246, RULE_union_join);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1280); match(UNION);
			setState(1281); match(JOIN);
			setState(1282); ((Union_joinContext)_localctx).r = table_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 248, RULE_join_type);
		try {
			setState(1286);
			switch (_input.LA(1)) {
			case INNER:
				enterOuterAlt(_localctx, 1);
				{
				setState(1284); match(INNER);
				}
				break;
			case FULL:
			case LEFT:
			case RIGHT:
				enterOuterAlt(_localctx, 2);
				{
				setState(1285); ((Join_typeContext)_localctx).t = outer_join_type();
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
		enterRule(_localctx, 250, RULE_outer_join_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1288); outer_join_type_part2();
			setState(1290);
			_la = _input.LA(1);
			if (_la==OUTER) {
				{
				setState(1289); match(OUTER);
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
		enterRule(_localctx, 252, RULE_outer_join_type_part2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1292);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FULL) | (1L << LEFT) | (1L << RIGHT))) != 0)) ) {
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
		enterRule(_localctx, 254, RULE_join_specification);
		try {
			setState(1296);
			switch (_input.LA(1)) {
			case ON:
				enterOuterAlt(_localctx, 1);
				{
				setState(1294); join_condition();
				}
				break;
			case USING:
				enterOuterAlt(_localctx, 2);
				{
				setState(1295); named_columns_join();
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
		enterRule(_localctx, 256, RULE_join_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1298); match(ON);
			setState(1299); search_condition();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 258, RULE_named_columns_join);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1301); match(USING);
			setState(1302); match(LEFT_PAREN);
			setState(1303); ((Named_columns_joinContext)_localctx).f = column_reference_list();
			setState(1304); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 260, RULE_table_primary);
		int _la;
		try {
			setState(1330);
			switch (_input.LA(1)) {
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
			case OVERWRITE:
			case PARTITION:
			case PARTITIONS:
			case PRECISION:
			case PURGE:
			case QUARTER:
			case RANGE:
			case REGEXP:
			case RLIKE:
			case ROLLUP:
			case SECOND:
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
				setState(1306); table_or_query_name();
				setState(1311);
				switch ( getInterpreter().adaptivePredict(_input,130,_ctx) ) {
				case 1:
					{
					setState(1308);
					_la = _input.LA(1);
					if (_la==AS) {
						{
						setState(1307); match(AS);
						}
					}

					setState(1310); ((Table_primaryContext)_localctx).alias = identifier();
					}
					break;
				}
				setState(1317);
				switch ( getInterpreter().adaptivePredict(_input,131,_ctx) ) {
				case 1:
					{
					setState(1313); match(LEFT_PAREN);
					setState(1314); column_name_list();
					setState(1315); match(RIGHT_PAREN);
					}
					break;
				}
				}
				break;
			case LEFT_PAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(1319); derived_table();
				setState(1321);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(1320); match(AS);
					}
				}

				setState(1323); ((Table_primaryContext)_localctx).name = identifier();
				setState(1328);
				switch ( getInterpreter().adaptivePredict(_input,133,_ctx) ) {
				case 1:
					{
					setState(1324); match(LEFT_PAREN);
					setState(1325); column_name_list();
					setState(1326); match(RIGHT_PAREN);
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
		enterRule(_localctx, 262, RULE_column_name_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1332); identifier();
			setState(1337);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1333); match(COMMA);
				setState(1334); identifier();
				}
				}
				setState(1339);
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
		enterRule(_localctx, 264, RULE_derived_table);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1340); table_subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 266, RULE_where_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1342); match(WHERE);
			setState(1343); search_condition();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 268, RULE_search_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1345); value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 270, RULE_groupby_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1347); match(GROUP);
			setState(1348); match(BY);
			setState(1349); ((Groupby_clauseContext)_localctx).g = grouping_element_list();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 272, RULE_grouping_element_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1351); grouping_element();
			setState(1356);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1352); match(COMMA);
				setState(1353); grouping_element();
				}
				}
				setState(1358);
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
		enterRule(_localctx, 274, RULE_grouping_element);
		try {
			setState(1363);
			switch ( getInterpreter().adaptivePredict(_input,137,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1359); rollup_list();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1360); cube_list();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1361); empty_grouping_set();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1362); ordinary_grouping_set();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 276, RULE_ordinary_grouping_set);
		try {
			setState(1370);
			switch ( getInterpreter().adaptivePredict(_input,138,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1365); row_value_predicand();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1366); match(LEFT_PAREN);
				setState(1367); row_value_predicand_list();
				setState(1368); match(RIGHT_PAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 278, RULE_ordinary_grouping_set_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1372); ordinary_grouping_set();
			setState(1377);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1373); match(COMMA);
				setState(1374); ordinary_grouping_set();
				}
				}
				setState(1379);
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
		enterRule(_localctx, 280, RULE_rollup_list);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1380); match(ROLLUP);
			setState(1381); match(LEFT_PAREN);
			setState(1382); ((Rollup_listContext)_localctx).c = ordinary_grouping_set_list();
			setState(1383); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 282, RULE_cube_list);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1385); match(CUBE);
			setState(1386); match(LEFT_PAREN);
			setState(1387); ((Cube_listContext)_localctx).c = ordinary_grouping_set_list();
			setState(1388); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 284, RULE_empty_grouping_set);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1390); match(LEFT_PAREN);
			setState(1391); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 286, RULE_having_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1393); match(HAVING);
			setState(1394); boolean_value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 288, RULE_row_value_predicand_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1396); row_value_predicand();
			setState(1401);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1397); match(COMMA);
				setState(1398); row_value_predicand();
				}
				}
				setState(1403);
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
		enterRule(_localctx, 290, RULE_query_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1404); query_expression_body();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 292, RULE_query_expression_body);
		try {
			setState(1408);
			switch ( getInterpreter().adaptivePredict(_input,141,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1406); non_join_query_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1407); joined_table();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 294, RULE_non_join_query_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1418);
			switch ( getInterpreter().adaptivePredict(_input,143,_ctx) ) {
			case 1:
				{
				setState(1410); non_join_query_term();
				}
				break;
			case 2:
				{
				setState(1411); joined_table();
				setState(1412);
				_la = _input.LA(1);
				if ( !(_la==EXCEPT || _la==UNION) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(1414);
				_la = _input.LA(1);
				if (_la==ALL || _la==DISTINCT) {
					{
					setState(1413);
					_la = _input.LA(1);
					if ( !(_la==ALL || _la==DISTINCT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(1416); query_term();
				}
				break;
			}
			setState(1427);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==EXCEPT || _la==UNION) {
				{
				{
				setState(1420);
				_la = _input.LA(1);
				if ( !(_la==EXCEPT || _la==UNION) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(1422);
				_la = _input.LA(1);
				if (_la==ALL || _la==DISTINCT) {
					{
					setState(1421);
					_la = _input.LA(1);
					if ( !(_la==ALL || _la==DISTINCT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(1424); query_term();
				}
				}
				setState(1429);
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
		enterRule(_localctx, 296, RULE_query_term);
		try {
			setState(1432);
			switch ( getInterpreter().adaptivePredict(_input,146,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1430); non_join_query_term();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1431); joined_table();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 298, RULE_non_join_query_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1442);
			switch ( getInterpreter().adaptivePredict(_input,148,_ctx) ) {
			case 1:
				{
				setState(1434); non_join_query_primary();
				}
				break;
			case 2:
				{
				setState(1435); joined_table();
				setState(1436); match(INTERSECT);
				setState(1438);
				_la = _input.LA(1);
				if (_la==ALL || _la==DISTINCT) {
					{
					setState(1437);
					_la = _input.LA(1);
					if ( !(_la==ALL || _la==DISTINCT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(1440); query_primary();
				}
				break;
			}
			setState(1451);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==INTERSECT) {
				{
				{
				setState(1444); match(INTERSECT);
				setState(1446);
				_la = _input.LA(1);
				if (_la==ALL || _la==DISTINCT) {
					{
					setState(1445);
					_la = _input.LA(1);
					if ( !(_la==ALL || _la==DISTINCT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(1448); query_primary();
				}
				}
				setState(1453);
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
		enterRule(_localctx, 300, RULE_query_primary);
		try {
			setState(1456);
			switch ( getInterpreter().adaptivePredict(_input,151,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1454); non_join_query_primary();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1455); joined_table();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 302, RULE_non_join_query_primary);
		try {
			setState(1463);
			switch (_input.LA(1)) {
			case SELECT:
			case TABLE:
				enterOuterAlt(_localctx, 1);
				{
				setState(1458); simple_table();
				}
				break;
			case LEFT_PAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(1459); match(LEFT_PAREN);
				setState(1460); non_join_query_expression();
				setState(1461); match(RIGHT_PAREN);
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
		enterRule(_localctx, 304, RULE_simple_table);
		try {
			setState(1467);
			switch (_input.LA(1)) {
			case SELECT:
				enterOuterAlt(_localctx, 1);
				{
				setState(1465); query_specification();
				}
				break;
			case TABLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(1466); explicit_table();
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
		enterRule(_localctx, 306, RULE_explicit_table);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1469); match(TABLE);
			setState(1470); table_or_query_name();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 308, RULE_table_or_query_name);
		try {
			setState(1474);
			switch ( getInterpreter().adaptivePredict(_input,154,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1472); table_name();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1473); identifier();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 310, RULE_table_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1476); identifier();
			setState(1483);
			_la = _input.LA(1);
			if (_la==DOT) {
				{
				setState(1477); match(DOT);
				setState(1478); identifier();
				setState(1481);
				_la = _input.LA(1);
				if (_la==DOT) {
					{
					setState(1479); match(DOT);
					setState(1480); identifier();
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
		enterRule(_localctx, 312, RULE_query_specification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1485); match(SELECT);
			setState(1487);
			_la = _input.LA(1);
			if (_la==ALL || _la==DISTINCT) {
				{
				setState(1486); set_qualifier();
				}
			}

			setState(1489); select_list();
			setState(1491);
			_la = _input.LA(1);
			if (_la==FROM) {
				{
				setState(1490); table_expression();
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
		enterRule(_localctx, 314, RULE_select_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1493); select_sublist();
			setState(1498);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1494); match(COMMA);
				setState(1495); select_sublist();
				}
				}
				setState(1500);
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
		enterRule(_localctx, 316, RULE_select_sublist);
		try {
			setState(1503);
			switch ( getInterpreter().adaptivePredict(_input,160,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1501); derived_column();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1502); qualified_asterisk();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 318, RULE_derived_column);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1505); value_expression();
			setState(1507);
			switch ( getInterpreter().adaptivePredict(_input,161,_ctx) ) {
			case 1:
				{
				setState(1506); as_clause();
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
		enterRule(_localctx, 320, RULE_qualified_asterisk);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1511);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(1509); ((Qualified_asteriskContext)_localctx).tb_name = match(Identifier);
				setState(1510); match(DOT);
				}
			}

			setState(1513); match(MULTIPLY);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 322, RULE_set_qualifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1515);
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
		enterRule(_localctx, 324, RULE_column_reference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1520);
			switch ( getInterpreter().adaptivePredict(_input,163,_ctx) ) {
			case 1:
				{
				setState(1517); ((Column_referenceContext)_localctx).tb_name = identifier();
				setState(1518); match(DOT);
				}
				break;
			}
			setState(1522); ((Column_referenceContext)_localctx).name = identifier();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 326, RULE_as_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1525);
			_la = _input.LA(1);
			if (_la==AS) {
				{
				setState(1524); match(AS);
				}
			}

			setState(1527); identifier();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 328, RULE_column_reference_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1529); column_reference();
			setState(1534);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1530); match(COMMA);
				setState(1531); column_reference();
				}
				}
				setState(1536);
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
		enterRule(_localctx, 330, RULE_scalar_subquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1537); subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 332, RULE_row_subquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1539); subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 334, RULE_table_subquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1541); subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 336, RULE_subquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1543); match(LEFT_PAREN);
			setState(1544); query_expression();
			setState(1545); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 338, RULE_predicate);
		try {
			setState(1553);
			switch ( getInterpreter().adaptivePredict(_input,166,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1547); comparison_predicate();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1548); between_predicate();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1549); in_predicate();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1550); pattern_matching_predicate();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1551); null_predicate();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1552); exists_predicate();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 340, RULE_comparison_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1555); ((Comparison_predicateContext)_localctx).left = row_value_predicand();
			setState(1556); ((Comparison_predicateContext)_localctx).c = comp_op();
			setState(1557); ((Comparison_predicateContext)_localctx).right = row_value_predicand();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 342, RULE_comp_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1559);
			_la = _input.LA(1);
			if ( !(((((_la - 178)) & ~0x3f) == 0 && ((1L << (_la - 178)) & ((1L << (EQUAL - 178)) | (1L << (NOT_EQUAL - 178)) | (1L << (LTH - 178)) | (1L << (LEQ - 178)) | (1L << (GTH - 178)) | (1L << (GEQ - 178)))) != 0)) ) {
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
		enterRule(_localctx, 344, RULE_between_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1561); ((Between_predicateContext)_localctx).predicand = row_value_predicand();
			setState(1562); between_predicate_part_2();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 346, RULE_between_predicate_part_2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1565);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(1564); match(NOT);
				}
			}

			setState(1567); match(BETWEEN);
			setState(1569);
			_la = _input.LA(1);
			if (_la==ASYMMETRIC || _la==SYMMETRIC) {
				{
				setState(1568);
				_la = _input.LA(1);
				if ( !(_la==ASYMMETRIC || _la==SYMMETRIC) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(1571); ((Between_predicate_part_2Context)_localctx).begin = row_value_predicand();
			setState(1572); match(AND);
			setState(1573); ((Between_predicate_part_2Context)_localctx).end = row_value_predicand();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 348, RULE_in_predicate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1575); ((In_predicateContext)_localctx).predicand = numeric_value_expression();
			setState(1577);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(1576); match(NOT);
				}
			}

			setState(1579); match(IN);
			setState(1580); in_predicate_value();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 350, RULE_in_predicate_value);
		try {
			setState(1587);
			switch ( getInterpreter().adaptivePredict(_input,170,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1582); table_subquery();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1583); match(LEFT_PAREN);
				setState(1584); in_value_list();
				setState(1585); match(RIGHT_PAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 352, RULE_in_value_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1589); row_value_expression();
			setState(1594);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1590); match(COMMA);
				setState(1591); row_value_expression();
				}
				}
				setState(1596);
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
		enterRule(_localctx, 354, RULE_pattern_matching_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1597); ((Pattern_matching_predicateContext)_localctx).f = row_value_predicand();
			setState(1598); pattern_matcher();
			setState(1599); ((Pattern_matching_predicateContext)_localctx).s = match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 356, RULE_pattern_matcher);
		int _la;
		try {
			setState(1606);
			switch (_input.LA(1)) {
			case ILIKE:
			case LIKE:
			case NOT:
			case REGEXP:
			case RLIKE:
			case SIMILAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(1602);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(1601); match(NOT);
					}
				}

				setState(1604); negativable_matcher();
				}
				break;
			case Similar_To:
			case Not_Similar_To:
			case Similar_To_Case_Insensitive:
			case Not_Similar_To_Case_Insensitive:
				enterOuterAlt(_localctx, 2);
				{
				setState(1605); regex_matcher();
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
		enterRule(_localctx, 358, RULE_negativable_matcher);
		try {
			setState(1614);
			switch (_input.LA(1)) {
			case LIKE:
				enterOuterAlt(_localctx, 1);
				{
				setState(1608); match(LIKE);
				}
				break;
			case ILIKE:
				enterOuterAlt(_localctx, 2);
				{
				setState(1609); match(ILIKE);
				}
				break;
			case SIMILAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(1610); match(SIMILAR);
				setState(1611); match(TO);
				}
				break;
			case REGEXP:
				enterOuterAlt(_localctx, 4);
				{
				setState(1612); match(REGEXP);
				}
				break;
			case RLIKE:
				enterOuterAlt(_localctx, 5);
				{
				setState(1613); match(RLIKE);
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
		enterRule(_localctx, 360, RULE_regex_matcher);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1616);
			_la = _input.LA(1);
			if ( !(((((_la - 172)) & ~0x3f) == 0 && ((1L << (_la - 172)) & ((1L << (Similar_To - 172)) | (1L << (Not_Similar_To - 172)) | (1L << (Similar_To_Case_Insensitive - 172)) | (1L << (Not_Similar_To_Case_Insensitive - 172)))) != 0)) ) {
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
		enterRule(_localctx, 362, RULE_null_predicate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1618); ((Null_predicateContext)_localctx).predicand = row_value_predicand();
			setState(1619); match(IS);
			setState(1621);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(1620); ((Null_predicateContext)_localctx).n = match(NOT);
				}
			}

			setState(1623); match(NULL);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 364, RULE_quantified_comparison_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1625); ((Quantified_comparison_predicateContext)_localctx).l = numeric_value_expression();
			setState(1626); ((Quantified_comparison_predicateContext)_localctx).c = comp_op();
			setState(1627); ((Quantified_comparison_predicateContext)_localctx).q = quantifier();
			setState(1628); ((Quantified_comparison_predicateContext)_localctx).s = table_subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 366, RULE_quantifier);
		try {
			setState(1632);
			switch (_input.LA(1)) {
			case ALL:
				enterOuterAlt(_localctx, 1);
				{
				setState(1630); all();
				}
				break;
			case ANY:
			case SOME:
				enterOuterAlt(_localctx, 2);
				{
				setState(1631); some();
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
		enterRule(_localctx, 368, RULE_all);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1634); match(ALL);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 370, RULE_some);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1636);
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
		enterRule(_localctx, 372, RULE_exists_predicate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1639);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(1638); match(NOT);
				}
			}

			setState(1641); match(EXISTS);
			setState(1642); ((Exists_predicateContext)_localctx).s = table_subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 374, RULE_unique_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1644); match(UNIQUE);
			setState(1645); ((Unique_predicateContext)_localctx).s = table_subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 376, RULE_primary_datetime_field);
		try {
			setState(1649);
			switch (_input.LA(1)) {
			case DAY:
			case HOUR:
			case MINUTE:
			case MONTH:
			case YEAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(1647); non_second_primary_datetime_field();
				}
				break;
			case SECOND:
				enterOuterAlt(_localctx, 2);
				{
				setState(1648); match(SECOND);
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
		enterRule(_localctx, 378, RULE_non_second_primary_datetime_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1651);
			_la = _input.LA(1);
			if ( !(((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (DAY - 67)) | (1L << (HOUR - 67)) | (1L << (MINUTE - 67)) | (1L << (MONTH - 67)))) != 0) || _la==YEAR) ) {
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
		enterRule(_localctx, 380, RULE_extended_datetime_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1653);
			_la = _input.LA(1);
			if ( !(((((_la - 60)) & ~0x3f) == 0 && ((1L << (_la - 60)) & ((1L << (CENTURY - 60)) | (1L << (DECADE - 60)) | (1L << (DOW - 60)) | (1L << (DOY - 60)) | (1L << (EPOCH - 60)) | (1L << (ISODOW - 60)) | (1L << (ISOYEAR - 60)) | (1L << (MICROSECONDS - 60)) | (1L << (MILLENNIUM - 60)) | (1L << (MILLISECONDS - 60)) | (1L << (QUARTER - 60)))) != 0) || _la==WEEK) ) {
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
		enterRule(_localctx, 382, RULE_routine_invocation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1655); function_name();
			setState(1656); match(LEFT_PAREN);
			setState(1658);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ANY) | (1L << CASE) | (1L << CAST) | (1L << FALSE) | (1L << LEFT) | (1L << NOT) | (1L << NULL) | (1L << RIGHT) | (1L << SOME) | (1L << TRUE) | (1L << AVG) | (1L << BETWEEN) | (1L << BY) | (1L << CENTURY) | (1L << CHARACTER) | (1L << COLLECT) | (1L << COALESCE))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (COLUMN - 64)) | (1L << (COUNT - 64)) | (1L << (CUBE - 64)) | (1L << (DAY - 64)) | (1L << (DEC - 64)) | (1L << (DECADE - 64)) | (1L << (DOW - 64)) | (1L << (DOY - 64)) | (1L << (DROP - 64)) | (1L << (EPOCH - 64)) | (1L << (EVERY - 64)) | (1L << (EXISTS - 64)) | (1L << (EXTERNAL - 64)) | (1L << (EXTRACT - 64)) | (1L << (FILTER - 64)) | (1L << (FIRST - 64)) | (1L << (FORMAT - 64)) | (1L << (FUSION - 64)) | (1L << (GROUPING - 64)) | (1L << (HASH - 64)) | (1L << (INDEX - 64)) | (1L << (INSERT - 64)) | (1L << (INTERSECTION - 64)) | (1L << (ISODOW - 64)) | (1L << (ISOYEAR - 64)) | (1L << (LAST - 64)) | (1L << (LESS - 64)) | (1L << (LIST - 64)) | (1L << (LOCATION - 64)) | (1L << (MAX - 64)) | (1L << (MAXVALUE - 64)) | (1L << (MICROSECONDS - 64)) | (1L << (MILLENNIUM - 64)) | (1L << (MILLISECONDS - 64)) | (1L << (MIN - 64)) | (1L << (MINUTE - 64)) | (1L << (MONTH - 64)) | (1L << (NATIONAL - 64)) | (1L << (NULLIF - 64)) | (1L << (OVERWRITE - 64)) | (1L << (PARTITION - 64)) | (1L << (PARTITIONS - 64)) | (1L << (PRECISION - 64)) | (1L << (PURGE - 64)) | (1L << (QUARTER - 64)) | (1L << (RANGE - 64)) | (1L << (REGEXP - 64)) | (1L << (RLIKE - 64)) | (1L << (ROLLUP - 64)) | (1L << (SECOND - 64)) | (1L << (SET - 64)) | (1L << (SIMILAR - 64)) | (1L << (STDDEV_POP - 64)) | (1L << (STDDEV_SAMP - 64)) | (1L << (SUBPARTITION - 64)) | (1L << (SUM - 64)) | (1L << (TABLESPACE - 64)) | (1L << (THAN - 64)) | (1L << (TIMEZONE - 64)) | (1L << (TIMEZONE_HOUR - 64)) | (1L << (TIMEZONE_MINUTE - 64)) | (1L << (TRIM - 64)) | (1L << (TO - 64)))) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (UNKNOWN - 128)) | (1L << (VALUES - 128)) | (1L << (VAR_SAMP - 128)) | (1L << (VAR_POP - 128)) | (1L << (VARYING - 128)) | (1L << (WEEK - 128)) | (1L << (YEAR - 128)) | (1L << (ZONE - 128)) | (1L << (BOOLEAN - 128)) | (1L << (BOOL - 128)) | (1L << (BIT - 128)) | (1L << (VARBIT - 128)) | (1L << (INT1 - 128)) | (1L << (INT2 - 128)) | (1L << (INT4 - 128)) | (1L << (INT8 - 128)) | (1L << (TINYINT - 128)) | (1L << (SMALLINT - 128)) | (1L << (INT - 128)) | (1L << (INTEGER - 128)) | (1L << (BIGINT - 128)) | (1L << (FLOAT4 - 128)) | (1L << (FLOAT8 - 128)) | (1L << (REAL - 128)) | (1L << (FLOAT - 128)) | (1L << (DOUBLE - 128)) | (1L << (NUMERIC - 128)) | (1L << (DECIMAL - 128)) | (1L << (CHAR - 128)) | (1L << (VARCHAR - 128)) | (1L << (NCHAR - 128)) | (1L << (NVARCHAR - 128)) | (1L << (DATE - 128)) | (1L << (TIME - 128)) | (1L << (TIMETZ - 128)) | (1L << (TIMESTAMP - 128)) | (1L << (TIMESTAMPTZ - 128)) | (1L << (TEXT - 128)) | (1L << (VARBINARY - 128)) | (1L << (BLOB - 128)) | (1L << (BYTEA - 128)) | (1L << (INET4 - 128)) | (1L << (LEFT_PAREN - 128)) | (1L << (PLUS - 128)) | (1L << (MINUS - 128)))) != 0) || ((((_la - 200)) & ~0x3f) == 0 && ((1L << (_la - 200)) & ((1L << (NUMBER - 200)) | (1L << (REAL_NUMBER - 200)) | (1L << (Identifier - 200)) | (1L << (Character_String_Literal - 200)))) != 0)) {
				{
				setState(1657); sql_argument_list();
				}
			}

			setState(1660); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 384, RULE_function_names_for_reserved_words);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1662);
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
		enterRule(_localctx, 386, RULE_function_name);
		try {
			setState(1666);
			switch (_input.LA(1)) {
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
			case OVERWRITE:
			case PARTITION:
			case PARTITIONS:
			case PRECISION:
			case PURGE:
			case QUARTER:
			case RANGE:
			case REGEXP:
			case RLIKE:
			case ROLLUP:
			case SECOND:
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
				setState(1664); identifier();
				}
				break;
			case LEFT:
			case RIGHT:
				enterOuterAlt(_localctx, 2);
				{
				setState(1665); function_names_for_reserved_words();
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
		enterRule(_localctx, 388, RULE_sql_argument_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1668); value_expression();
			setState(1673);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1669); match(COMMA);
				setState(1670); value_expression();
				}
				}
				setState(1675);
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
		enterRule(_localctx, 390, RULE_orderby_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1676); match(ORDER);
			setState(1677); match(BY);
			setState(1678); sort_specifier_list();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 392, RULE_sort_specifier_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1680); sort_specifier();
			setState(1685);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1681); match(COMMA);
				setState(1682); sort_specifier();
				}
				}
				setState(1687);
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
		enterRule(_localctx, 394, RULE_sort_specifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1688); ((Sort_specifierContext)_localctx).key = row_value_predicand();
			setState(1690);
			_la = _input.LA(1);
			if (_la==ASC || _la==DESC) {
				{
				setState(1689); ((Sort_specifierContext)_localctx).order = order_specification();
				}
			}

			setState(1693);
			_la = _input.LA(1);
			if (_la==NULL) {
				{
				setState(1692); ((Sort_specifierContext)_localctx).null_order = null_ordering();
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
		enterRule(_localctx, 396, RULE_order_specification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1695);
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
		enterRule(_localctx, 398, RULE_limit_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1697); match(LIMIT);
			setState(1698); ((Limit_clauseContext)_localctx).e = numeric_value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 400, RULE_null_ordering);
		try {
			setState(1704);
			switch ( getInterpreter().adaptivePredict(_input,185,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1700); match(NULL);
				setState(1701); match(FIRST);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1702); match(NULL);
				setState(1703); match(LAST);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 402, RULE_insert_statement);
		int _la;
		try {
			setState(1735);
			switch ( getInterpreter().adaptivePredict(_input,191,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1706); match(INSERT);
				setState(1708);
				_la = _input.LA(1);
				if (_la==OVERWRITE) {
					{
					setState(1707); match(OVERWRITE);
					}
				}

				setState(1710); match(INTO);
				setState(1711); table_name();
				setState(1716);
				switch ( getInterpreter().adaptivePredict(_input,187,_ctx) ) {
				case 1:
					{
					setState(1712); match(LEFT_PAREN);
					setState(1713); column_name_list();
					setState(1714); match(RIGHT_PAREN);
					}
					break;
				}
				setState(1718); query_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1720); match(INSERT);
				setState(1722);
				_la = _input.LA(1);
				if (_la==OVERWRITE) {
					{
					setState(1721); match(OVERWRITE);
					}
				}

				setState(1724); match(INTO);
				setState(1725); match(LOCATION);
				setState(1726); ((Insert_statementContext)_localctx).path = match(Character_String_Literal);
				setState(1732);
				_la = _input.LA(1);
				if (_la==USING) {
					{
					setState(1727); match(USING);
					setState(1728); ((Insert_statementContext)_localctx).file_type = identifier();
					setState(1730);
					_la = _input.LA(1);
					if (_la==WITH) {
						{
						setState(1729); param_clause();
						}
					}

					}
				}

				setState(1734); query_expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\u00d2\u06cc\4\2\t"+
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
		"\4\u00c9\t\u00c9\4\u00ca\t\u00ca\4\u00cb\t\u00cb\3\2\3\2\5\2\u0199\n\2"+
		"\6\2\u019b\n\2\r\2\16\2\u019c\3\2\3\2\3\3\3\3\3\3\3\3\3\3\5\3\u01a6\n"+
		"\3\3\4\3\4\3\5\3\5\3\6\3\6\5\6\u01ae\n\6\3\7\3\7\5\7\u01b2\n\7\3\7\3\7"+
		"\3\7\3\7\3\7\5\7\u01b9\n\7\3\7\3\7\3\7\3\7\5\7\u01bf\n\7\3\b\3\b\3\b\3"+
		"\b\3\b\5\b\u01c6\n\b\3\b\3\b\5\b\u01ca\n\b\3\b\3\b\5\b\u01ce\n\b\3\b\3"+
		"\b\5\b\u01d2\n\b\3\b\3\b\5\b\u01d6\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\5\t\u01e0\n\t\3\t\5\t\u01e3\n\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5"+
		"\t\u01ee\n\t\3\t\5\t\u01f1\n\t\3\t\5\t\u01f4\n\t\3\t\3\t\5\t\u01f8\n\t"+
		"\3\t\3\t\3\t\3\t\3\t\5\t\u01ff\n\t\3\t\5\t\u0202\n\t\3\t\5\t\u0205\n\t"+
		"\3\t\3\t\3\t\5\t\u020a\n\t\3\n\3\n\3\n\3\n\7\n\u0210\n\n\f\n\16\n\u0213"+
		"\13\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r\3\r\7\r\u0221\n\r"+
		"\f\r\16\r\u0224\13\r\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3"+
		"\20\3\20\3\21\3\21\3\22\3\22\3\22\3\22\5\22\u0238\n\22\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\7\24\u0247\n\24\f\24"+
		"\16\24\u024a\13\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5"+
		"\25\u0256\n\25\3\25\3\25\5\25\u025a\n\25\5\25\u025c\n\25\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u0269\n\26\3\27\3\27\3\27"+
		"\7\27\u026e\n\27\f\27\16\27\u0271\13\27\3\30\3\30\3\30\3\31\3\31\3\31"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\7\33"+
		"\u0286\n\33\f\33\16\33\u0289\13\33\3\34\3\34\3\34\3\34\5\34\u028f\n\34"+
		"\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\37\3\37\3\37"+
		"\3\37\5\37\u02a0\n\37\3 \3 \5 \u02a4\n \3!\3!\3\"\3\"\5\"\u02aa\n\"\3"+
		"#\3#\3#\5#\u02af\n#\3$\3$\3$\5$\u02b4\n$\3%\3%\3%\3&\3&\3&\3\'\3\'\3\'"+
		"\3(\3(\3)\3)\3*\3*\3*\3*\3*\3*\3*\3*\3*\5*\u02cc\n*\3+\3+\3,\3,\5,\u02d2"+
		"\n,\3,\3,\5,\u02d6\n,\3,\3,\3,\5,\u02db\n,\3,\3,\3,\5,\u02e0\n,\3,\3,"+
		"\5,\u02e4\n,\3,\5,\u02e7\n,\3-\3-\3-\3-\3.\3.\3.\5.\u02f0\n.\3.\3.\3."+
		"\5.\u02f5\n.\3.\3.\5.\u02f9\n.\3.\3.\3.\3.\5.\u02ff\n.\3.\3.\3.\3.\5."+
		"\u0305\n.\3.\3.\3.\5.\u030a\n.\3.\3.\5.\u030e\n.\5.\u0310\n.\3/\3/\5/"+
		"\u0314\n/\3/\3/\5/\u0318\n/\5/\u031a\n/\3\60\3\60\5\60\u031e\n\60\3\61"+
		"\3\61\5\61\u0322\n\61\3\61\3\61\5\61\u0326\n\61\3\61\3\61\5\61\u032a\n"+
		"\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\5\61\u0335\n\61\3\62"+
		"\3\62\5\62\u0339\n\62\3\62\3\62\3\62\3\62\3\62\3\62\5\62\u0341\n\62\3"+
		"\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\5\63\u034b\n\63\3\64\3\64\3\65"+
		"\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\5\65\u035c"+
		"\n\65\3\66\3\66\5\66\u0360\n\66\3\66\3\66\5\66\u0364\n\66\3\66\3\66\3"+
		"\66\5\66\u0369\n\66\5\66\u036b\n\66\3\67\3\67\5\67\u036f\n\67\3\67\3\67"+
		"\3\67\5\67\u0374\n\67\3\67\3\67\5\67\u0378\n\67\5\67\u037a\n\67\38\38"+
		"\58\u037e\n8\39\39\39\39\3:\3:\3:\3:\3:\3:\3:\5:\u038b\n:\3;\3;\3<\3<"+
		"\3=\5=\u0392\n=\3=\3=\3>\3>\3?\3?\3?\3?\3?\3?\5?\u039e\n?\5?\u03a0\n?"+
		"\3@\3@\3@\5@\u03a5\n@\3@\3@\3@\3A\3A\3B\3B\3B\3B\3B\3B\3C\3C\3C\3C\3C"+
		"\3D\3D\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\6E\u03c5\nE\rE\16E\u03c6\3"+
		"E\3E\5E\u03cb\nE\3F\3F\5F\u03cf\nF\3G\3G\3G\6G\u03d4\nG\rG\16G\u03d5\3"+
		"G\5G\u03d9\nG\3G\3G\3H\3H\6H\u03df\nH\rH\16H\u03e0\3H\5H\u03e4\nH\3H\3"+
		"H\3I\3I\3I\3I\3I\3J\3J\3J\3J\3J\3K\3K\3K\3L\3L\5L\u03f7\nL\3M\3M\3M\3"+
		"M\3M\3M\3M\3N\3N\3O\3O\3P\3P\3P\5P\u0407\nP\3Q\3Q\3Q\5Q\u040c\nQ\3R\3"+
		"R\3R\7R\u0411\nR\fR\16R\u0414\13R\3S\3S\3S\7S\u0419\nS\fS\16S\u041c\13"+
		"S\3T\5T\u041f\nT\3T\3T\3U\3U\3U\3U\7U\u0427\nU\fU\16U\u042a\13U\3U\3U"+
		"\3V\3V\3V\7V\u0431\nV\fV\16V\u0434\13V\3V\5V\u0437\nV\3W\3W\3X\3X\3Y\3"+
		"Y\3Y\3Y\3Y\3Y\3Y\3Z\3Z\3Z\5Z\u0447\nZ\3[\3[\3\\\3\\\5\\\u044d\n\\\3]\3"+
		"]\3^\3^\3^\7^\u0454\n^\f^\16^\u0457\13^\3_\3_\3`\3`\5`\u045d\n`\3a\3a"+
		"\3b\3b\3b\3b\3b\3c\5c\u0467\nc\3c\5c\u046a\nc\3c\5c\u046d\nc\3c\3c\3c"+
		"\3c\3c\5c\u0474\nc\3d\3d\3e\3e\3f\3f\3f\7f\u047d\nf\ff\16f\u0480\13f\3"+
		"g\3g\3g\7g\u0485\ng\fg\16g\u0488\13g\3h\3h\3h\5h\u048d\nh\3i\3i\5i\u0491"+
		"\ni\3j\3j\5j\u0495\nj\3j\3j\3k\3k\3l\3l\5l\u049d\nl\3m\3m\5m\u04a1\nm"+
		"\3n\3n\3n\3n\3o\3o\5o\u04a9\no\3p\3p\3q\3q\3r\3r\5r\u04b1\nr\3s\3s\5s"+
		"\u04b5\ns\3t\3t\5t\u04b9\nt\3t\5t\u04bc\nt\3t\5t\u04bf\nt\3t\5t\u04c2"+
		"\nt\3t\5t\u04c5\nt\3u\3u\3u\3v\3v\3v\7v\u04cd\nv\fv\16v\u04d0\13v\3w\3"+
		"w\5w\u04d4\nw\3x\3x\6x\u04d8\nx\rx\16x\u04d9\3y\3y\3y\3y\5y\u04e0\ny\3"+
		"y\3y\3y\3y\3y\3y\5y\u04e8\ny\3y\3y\3y\3y\3y\5y\u04ef\ny\3z\3z\3z\3z\3"+
		"{\5{\u04f6\n{\3{\3{\3{\3{\3|\3|\5|\u04fe\n|\3|\3|\3|\3}\3}\3}\3}\3~\3"+
		"~\5~\u0509\n~\3\177\3\177\5\177\u050d\n\177\3\u0080\3\u0080\3\u0081\3"+
		"\u0081\5\u0081\u0513\n\u0081\3\u0082\3\u0082\3\u0082\3\u0083\3\u0083\3"+
		"\u0083\3\u0083\3\u0083\3\u0084\3\u0084\5\u0084\u051f\n\u0084\3\u0084\5"+
		"\u0084\u0522\n\u0084\3\u0084\3\u0084\3\u0084\3\u0084\5\u0084\u0528\n\u0084"+
		"\3\u0084\3\u0084\5\u0084\u052c\n\u0084\3\u0084\3\u0084\3\u0084\3\u0084"+
		"\3\u0084\5\u0084\u0533\n\u0084\5\u0084\u0535\n\u0084\3\u0085\3\u0085\3"+
		"\u0085\7\u0085\u053a\n\u0085\f\u0085\16\u0085\u053d\13\u0085\3\u0086\3"+
		"\u0086\3\u0087\3\u0087\3\u0087\3\u0088\3\u0088\3\u0089\3\u0089\3\u0089"+
		"\3\u0089\3\u008a\3\u008a\3\u008a\7\u008a\u054d\n\u008a\f\u008a\16\u008a"+
		"\u0550\13\u008a\3\u008b\3\u008b\3\u008b\3\u008b\5\u008b\u0556\n\u008b"+
		"\3\u008c\3\u008c\3\u008c\3\u008c\3\u008c\5\u008c\u055d\n\u008c\3\u008d"+
		"\3\u008d\3\u008d\7\u008d\u0562\n\u008d\f\u008d\16\u008d\u0565\13\u008d"+
		"\3\u008e\3\u008e\3\u008e\3\u008e\3\u008e\3\u008f\3\u008f\3\u008f\3\u008f"+
		"\3\u008f\3\u0090\3\u0090\3\u0090\3\u0091\3\u0091\3\u0091\3\u0092\3\u0092"+
		"\3\u0092\7\u0092\u057a\n\u0092\f\u0092\16\u0092\u057d\13\u0092\3\u0093"+
		"\3\u0093\3\u0094\3\u0094\5\u0094\u0583\n\u0094\3\u0095\3\u0095\3\u0095"+
		"\3\u0095\5\u0095\u0589\n\u0095\3\u0095\3\u0095\5\u0095\u058d\n\u0095\3"+
		"\u0095\3\u0095\5\u0095\u0591\n\u0095\3\u0095\7\u0095\u0594\n\u0095\f\u0095"+
		"\16\u0095\u0597\13\u0095\3\u0096\3\u0096\5\u0096\u059b\n\u0096\3\u0097"+
		"\3\u0097\3\u0097\3\u0097\5\u0097\u05a1\n\u0097\3\u0097\3\u0097\5\u0097"+
		"\u05a5\n\u0097\3\u0097\3\u0097\5\u0097\u05a9\n\u0097\3\u0097\7\u0097\u05ac"+
		"\n\u0097\f\u0097\16\u0097\u05af\13\u0097\3\u0098\3\u0098\5\u0098\u05b3"+
		"\n\u0098\3\u0099\3\u0099\3\u0099\3\u0099\3\u0099\5\u0099\u05ba\n\u0099"+
		"\3\u009a\3\u009a\5\u009a\u05be\n\u009a\3\u009b\3\u009b\3\u009b\3\u009c"+
		"\3\u009c\5\u009c\u05c5\n\u009c\3\u009d\3\u009d\3\u009d\3\u009d\3\u009d"+
		"\5\u009d\u05cc\n\u009d\5\u009d\u05ce\n\u009d\3\u009e\3\u009e\5\u009e\u05d2"+
		"\n\u009e\3\u009e\3\u009e\5\u009e\u05d6\n\u009e\3\u009f\3\u009f\3\u009f"+
		"\7\u009f\u05db\n\u009f\f\u009f\16\u009f\u05de\13\u009f\3\u00a0\3\u00a0"+
		"\5\u00a0\u05e2\n\u00a0\3\u00a1\3\u00a1\5\u00a1\u05e6\n\u00a1\3\u00a2\3"+
		"\u00a2\5\u00a2\u05ea\n\u00a2\3\u00a2\3\u00a2\3\u00a3\3\u00a3\3\u00a4\3"+
		"\u00a4\3\u00a4\5\u00a4\u05f3\n\u00a4\3\u00a4\3\u00a4\3\u00a5\5\u00a5\u05f8"+
		"\n\u00a5\3\u00a5\3\u00a5\3\u00a6\3\u00a6\3\u00a6\7\u00a6\u05ff\n\u00a6"+
		"\f\u00a6\16\u00a6\u0602\13\u00a6\3\u00a7\3\u00a7\3\u00a8\3\u00a8\3\u00a9"+
		"\3\u00a9\3\u00aa\3\u00aa\3\u00aa\3\u00aa\3\u00ab\3\u00ab\3\u00ab\3\u00ab"+
		"\3\u00ab\3\u00ab\5\u00ab\u0614\n\u00ab\3\u00ac\3\u00ac\3\u00ac\3\u00ac"+
		"\3\u00ad\3\u00ad\3\u00ae\3\u00ae\3\u00ae\3\u00af\5\u00af\u0620\n\u00af"+
		"\3\u00af\3\u00af\5\u00af\u0624\n\u00af\3\u00af\3\u00af\3\u00af\3\u00af"+
		"\3\u00b0\3\u00b0\5\u00b0\u062c\n\u00b0\3\u00b0\3\u00b0\3\u00b0\3\u00b1"+
		"\3\u00b1\3\u00b1\3\u00b1\3\u00b1\5\u00b1\u0636\n\u00b1\3\u00b2\3\u00b2"+
		"\3\u00b2\7\u00b2\u063b\n\u00b2\f\u00b2\16\u00b2\u063e\13\u00b2\3\u00b3"+
		"\3\u00b3\3\u00b3\3\u00b3\3\u00b4\5\u00b4\u0645\n\u00b4\3\u00b4\3\u00b4"+
		"\5\u00b4\u0649\n\u00b4\3\u00b5\3\u00b5\3\u00b5\3\u00b5\3\u00b5\3\u00b5"+
		"\5\u00b5\u0651\n\u00b5\3\u00b6\3\u00b6\3\u00b7\3\u00b7\3\u00b7\5\u00b7"+
		"\u0658\n\u00b7\3\u00b7\3\u00b7\3\u00b8\3\u00b8\3\u00b8\3\u00b8\3\u00b8"+
		"\3\u00b9\3\u00b9\5\u00b9\u0663\n\u00b9\3\u00ba\3\u00ba\3\u00bb\3\u00bb"+
		"\3\u00bc\5\u00bc\u066a\n\u00bc\3\u00bc\3\u00bc\3\u00bc\3\u00bd\3\u00bd"+
		"\3\u00bd\3\u00be\3\u00be\5\u00be\u0674\n\u00be\3\u00bf\3\u00bf\3\u00c0"+
		"\3\u00c0\3\u00c1\3\u00c1\3\u00c1\5\u00c1\u067d\n\u00c1\3\u00c1\3\u00c1"+
		"\3\u00c2\3\u00c2\3\u00c3\3\u00c3\5\u00c3\u0685\n\u00c3\3\u00c4\3\u00c4"+
		"\3\u00c4\7\u00c4\u068a\n\u00c4\f\u00c4\16\u00c4\u068d\13\u00c4\3\u00c5"+
		"\3\u00c5\3\u00c5\3\u00c5\3\u00c6\3\u00c6\3\u00c6\7\u00c6\u0696\n\u00c6"+
		"\f\u00c6\16\u00c6\u0699\13\u00c6\3\u00c7\3\u00c7\5\u00c7\u069d\n\u00c7"+
		"\3\u00c7\5\u00c7\u06a0\n\u00c7\3\u00c8\3\u00c8\3\u00c9\3\u00c9\3\u00c9"+
		"\3\u00ca\3\u00ca\3\u00ca\3\u00ca\5\u00ca\u06ab\n\u00ca\3\u00cb\3\u00cb"+
		"\5\u00cb\u06af\n\u00cb\3\u00cb\3\u00cb\3\u00cb\3\u00cb\3\u00cb\3\u00cb"+
		"\5\u00cb\u06b7\n\u00cb\3\u00cb\3\u00cb\3\u00cb\3\u00cb\5\u00cb\u06bd\n"+
		"\u00cb\3\u00cb\3\u00cb\3\u00cb\3\u00cb\3\u00cb\3\u00cb\5\u00cb\u06c5\n"+
		"\u00cb\5\u00cb\u06c7\n\u00cb\3\u00cb\5\u00cb\u06ca\n\u00cb\3\u00cb\3\u01d5"+
		"\2\u00cc\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668"+
		":<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088\u008a"+
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
		"\u0194\2\26\6\2;UW\u0086\u0088\u00a8\u00aa\u00ad\5\2\24\24\64\64\u0082"+
		"\u0082\3\2\u008b\u008c\3\2\u00ca\u00cb\17\2\6\6//;;@@CCLLSSYY``eewxzz"+
		"\u0084\u0085\3\2\u00c0\u00c1\3\2\u00c2\u00c4\3\2}\177\5\2\t\t!!\63\63"+
		"\5\2\25\25\"\",,\4\2\22\22\65\65\4\2\4\4\17\17\4\2\u00b4\u00b4\u00b9\u00bd"+
		"\4\2\7\7\60\60\3\2\u00ae\u00b1\4\2\6\6//\6\2EEVVfg\u0089\u0089\t\2>>G"+
		"IKKZ[bdoo\u0088\u0088\4\2\"\",,\4\2\b\b\16\16\u0701\2\u019a\3\2\2\2\4"+
		"\u01a5\3\2\2\2\6\u01a7\3\2\2\2\b\u01a9\3\2\2\2\n\u01ad\3\2\2\2\f\u01af"+
		"\3\2\2\2\16\u01c0\3\2\2\2\20\u0209\3\2\2\2\22\u020b\3\2\2\2\24\u0216\3"+
		"\2\2\2\26\u0219\3\2\2\2\30\u021b\3\2\2\2\32\u0227\3\2\2\2\34\u022b\3\2"+
		"\2\2\36\u022e\3\2\2\2 \u0231\3\2\2\2\"\u0237\3\2\2\2$\u0239\3\2\2\2&\u0243"+
		"\3\2\2\2(\u024b\3\2\2\2*\u025d\3\2\2\2,\u026a\3\2\2\2.\u0272\3\2\2\2\60"+
		"\u0275\3\2\2\2\62\u0278\3\2\2\2\64\u0282\3\2\2\2\66\u028a\3\2\2\28\u0294"+
		"\3\2\2\2:\u0299\3\2\2\2<\u029b\3\2\2\2>\u02a3\3\2\2\2@\u02a5\3\2\2\2B"+
		"\u02a9\3\2\2\2D\u02ae\3\2\2\2F\u02b3\3\2\2\2H\u02b5\3\2\2\2J\u02b8\3\2"+
		"\2\2L\u02bb\3\2\2\2N\u02be\3\2\2\2P\u02c0\3\2\2\2R\u02cb\3\2\2\2T\u02cd"+
		"\3\2\2\2V\u02e6\3\2\2\2X\u02e8\3\2\2\2Z\u030f\3\2\2\2\\\u0319\3\2\2\2"+
		"^\u031d\3\2\2\2`\u0334\3\2\2\2b\u0340\3\2\2\2d\u034a\3\2\2\2f\u034c\3"+
		"\2\2\2h\u035b\3\2\2\2j\u036a\3\2\2\2l\u0379\3\2\2\2n\u037d\3\2\2\2p\u037f"+
		"\3\2\2\2r\u038a\3\2\2\2t\u038c\3\2\2\2v\u038e\3\2\2\2x\u0391\3\2\2\2z"+
		"\u0395\3\2\2\2|\u039f\3\2\2\2~\u03a1\3\2\2\2\u0080\u03a9\3\2\2\2\u0082"+
		"\u03ab\3\2\2\2\u0084\u03b1\3\2\2\2\u0086\u03b6\3\2\2\2\u0088\u03ca\3\2"+
		"\2\2\u008a\u03ce\3\2\2\2\u008c\u03d0\3\2\2\2\u008e\u03dc\3\2\2\2\u0090"+
		"\u03e7\3\2\2\2\u0092\u03ec\3\2\2\2\u0094\u03f1\3\2\2\2\u0096\u03f6\3\2"+
		"\2\2\u0098\u03f8\3\2\2\2\u009a\u03ff\3\2\2\2\u009c\u0401\3\2\2\2\u009e"+
		"\u0406\3\2\2\2\u00a0\u040b\3\2\2\2\u00a2\u040d\3\2\2\2\u00a4\u0415\3\2"+
		"\2\2\u00a6\u041e\3\2\2\2\u00a8\u0422\3\2\2\2\u00aa\u0436\3\2\2\2\u00ac"+
		"\u0438\3\2\2\2\u00ae\u043a\3\2\2\2\u00b0\u043c\3\2\2\2\u00b2\u0446\3\2"+
		"\2\2\u00b4\u0448\3\2\2\2\u00b6\u044c\3\2\2\2\u00b8\u044e\3\2\2\2\u00ba"+
		"\u0450\3\2\2\2\u00bc\u0458\3\2\2\2\u00be\u045c\3\2\2\2\u00c0\u045e\3\2"+
		"\2\2\u00c2\u0460\3\2\2\2\u00c4\u0473\3\2\2\2\u00c6\u0475\3\2\2\2\u00c8"+
		"\u0477\3\2\2\2\u00ca\u0479\3\2\2\2\u00cc\u0481\3\2\2\2\u00ce\u048c\3\2"+
		"\2\2\u00d0\u048e\3\2\2\2\u00d2\u0492\3\2\2\2\u00d4\u0498\3\2\2\2\u00d6"+
		"\u049c\3\2\2\2\u00d8\u04a0\3\2\2\2\u00da\u04a2\3\2\2\2\u00dc\u04a8\3\2"+
		"\2\2\u00de\u04aa\3\2\2\2\u00e0\u04ac\3\2\2\2\u00e2\u04b0\3\2\2\2\u00e4"+
		"\u04b4\3\2\2\2\u00e6\u04b6\3\2\2\2\u00e8\u04c6\3\2\2\2\u00ea\u04c9\3\2"+
		"\2\2\u00ec\u04d3\3\2\2\2\u00ee\u04d5\3\2\2\2\u00f0\u04ee\3\2\2\2\u00f2"+
		"\u04f0\3\2\2\2\u00f4\u04f5\3\2\2\2\u00f6\u04fb\3\2\2\2\u00f8\u0502\3\2"+
		"\2\2\u00fa\u0508\3\2\2\2\u00fc\u050a\3\2\2\2\u00fe\u050e\3\2\2\2\u0100"+
		"\u0512\3\2\2\2\u0102\u0514\3\2\2\2\u0104\u0517\3\2\2\2\u0106\u0534\3\2"+
		"\2\2\u0108\u0536\3\2\2\2\u010a\u053e\3\2\2\2\u010c\u0540\3\2\2\2\u010e"+
		"\u0543\3\2\2\2\u0110\u0545\3\2\2\2\u0112\u0549\3\2\2\2\u0114\u0555\3\2"+
		"\2\2\u0116\u055c\3\2\2\2\u0118\u055e\3\2\2\2\u011a\u0566\3\2\2\2\u011c"+
		"\u056b\3\2\2\2\u011e\u0570\3\2\2\2\u0120\u0573\3\2\2\2\u0122\u0576\3\2"+
		"\2\2\u0124\u057e\3\2\2\2\u0126\u0582\3\2\2\2\u0128\u058c\3\2\2\2\u012a"+
		"\u059a\3\2\2\2\u012c\u05a4\3\2\2\2\u012e\u05b2\3\2\2\2\u0130\u05b9\3\2"+
		"\2\2\u0132\u05bd\3\2\2\2\u0134\u05bf\3\2\2\2\u0136\u05c4\3\2\2\2\u0138"+
		"\u05c6\3\2\2\2\u013a\u05cf\3\2\2\2\u013c\u05d7\3\2\2\2\u013e\u05e1\3\2"+
		"\2\2\u0140\u05e3\3\2\2\2\u0142\u05e9\3\2\2\2\u0144\u05ed\3\2\2\2\u0146"+
		"\u05f2\3\2\2\2\u0148\u05f7\3\2\2\2\u014a\u05fb\3\2\2\2\u014c\u0603\3\2"+
		"\2\2\u014e\u0605\3\2\2\2\u0150\u0607\3\2\2\2\u0152\u0609\3\2\2\2\u0154"+
		"\u0613\3\2\2\2\u0156\u0615\3\2\2\2\u0158\u0619\3\2\2\2\u015a\u061b\3\2"+
		"\2\2\u015c\u061f\3\2\2\2\u015e\u0629\3\2\2\2\u0160\u0635\3\2\2\2\u0162"+
		"\u0637\3\2\2\2\u0164\u063f\3\2\2\2\u0166\u0648\3\2\2\2\u0168\u0650\3\2"+
		"\2\2\u016a\u0652\3\2\2\2\u016c\u0654\3\2\2\2\u016e\u065b\3\2\2\2\u0170"+
		"\u0662\3\2\2\2\u0172\u0664\3\2\2\2\u0174\u0666\3\2\2\2\u0176\u0669\3\2"+
		"\2\2\u0178\u066e\3\2\2\2\u017a\u0673\3\2\2\2\u017c\u0675\3\2\2\2\u017e"+
		"\u0677\3\2\2\2\u0180\u0679\3\2\2\2\u0182\u0680\3\2\2\2\u0184\u0684\3\2"+
		"\2\2\u0186\u0686\3\2\2\2\u0188\u068e\3\2\2\2\u018a\u0692\3\2\2\2\u018c"+
		"\u069a\3\2\2\2\u018e\u06a1\3\2\2\2\u0190\u06a3\3\2\2\2\u0192\u06aa\3\2"+
		"\2\2\u0194\u06c9\3\2\2\2\u0196\u0198\5\4\3\2\u0197\u0199\7\u00b6\2\2\u0198"+
		"\u0197\3\2\2\2\u0198\u0199\3\2\2\2\u0199\u019b\3\2\2\2\u019a\u0196\3\2"+
		"\2\2\u019b\u019c\3\2\2\2\u019c\u019a\3\2\2\2\u019c\u019d\3\2\2\2\u019d"+
		"\u019e\3\2\2\2\u019e\u019f\7\2\2\3\u019f\3\3\2\2\2\u01a0\u01a6\5\6\4\2"+
		"\u01a1\u01a6\5\b\5\2\u01a2\u01a6\5\n\6\2\u01a3\u01a6\5\f\7\2\u01a4\u01a6"+
		"\5\16\b\2\u01a5\u01a0\3\2\2\2\u01a5\u01a1\3\2\2\2\u01a5\u01a2\3\2\2\2"+
		"\u01a5\u01a3\3\2\2\2\u01a5\u01a4\3\2\2\2\u01a6\5\3\2\2\2\u01a7\u01a8\5"+
		"\u0124\u0093\2\u01a8\7\3\2\2\2\u01a9\u01aa\5\u0194\u00cb\2\u01aa\t\3\2"+
		"\2\2\u01ab\u01ae\5\20\t\2\u01ac\u01ae\5<\37\2\u01ad\u01ab\3\2\2\2\u01ad"+
		"\u01ac\3\2\2\2\u01ae\13\3\2\2\2\u01af\u01b1\7\f\2\2\u01b0\u01b2\7\66\2"+
		"\2\u01b1\u01b0\3\2\2\2\u01b1\u01b2\3\2\2\2\u01b2\u01b3\3\2\2\2\u01b3\u01b4"+
		"\7W\2\2\u01b4\u01b5\5> \2\u01b5\u01b6\7(\2\2\u01b6\u01b8\5\u0138\u009d"+
		"\2\u01b7\u01b9\5\34\17\2\u01b8\u01b7\3\2\2\2\u01b8\u01b9\3\2\2\2\u01b9"+
		"\u01ba\3\2\2\2\u01ba\u01bb\7\u00be\2\2\u01bb\u01bc\5\u018a\u00c6\2\u01bc"+
		"\u01be\7\u00bf\2\2\u01bd\u01bf\5\30\r\2\u01be\u01bd\3\2\2\2\u01be\u01bf"+
		"\3\2\2\2\u01bf\r\3\2\2\2\u01c0\u01c1\7\f\2\2\u01c1\u01c5\7\23\2\2\u01c2"+
		"\u01c3\7\31\2\2\u01c3\u01c4\7&\2\2\u01c4\u01c6\7M\2\2\u01c5\u01c2\3\2"+
		"\2\2\u01c5\u01c6\3\2\2\2\u01c6\u01c7\3\2\2\2\u01c7\u01c9\5> \2\u01c8\u01ca"+
		"\7:\2\2\u01c9\u01c8\3\2\2\2\u01c9\u01ca\3\2\2\2\u01ca\u01cd\3\2\2\2\u01cb"+
		"\u01cc\7-\2\2\u01cc\u01ce\5> \2\u01cd\u01cb\3\2\2\2\u01cd\u01ce\3\2\2"+
		"\2\u01ce\u01d1\3\2\2\2\u01cf\u01d0\7\u0087\2\2\u01d0\u01d2\5> \2\u01d1"+
		"\u01cf\3\2\2\2\u01d1\u01d2\3\2\2\2\u01d2\u01d5\3\2\2\2\u01d3\u01d4\7\26"+
		"\2\2\u01d4\u01d6\5> \2\u01d5\u01d6\3\2\2\2\u01d5\u01d3\3\2\2\2\u01d6\17"+
		"\3\2\2\2\u01d7\u01d8\7\f\2\2\u01d8\u01d9\7N\2\2\u01d9\u01da\7\61\2\2\u01da"+
		"\u01db\5\u0138\u009d\2\u01db\u01dc\5\22\n\2\u01dc\u01dd\7\67\2\2\u01dd"+
		"\u01df\5> \2\u01de\u01e0\5\30\r\2\u01df\u01de\3\2\2\2\u01df\u01e0\3\2"+
		"\2\2\u01e0\u01e2\3\2\2\2\u01e1\u01e3\5\"\22\2\u01e2\u01e1\3\2\2\2\u01e2"+
		"\u01e3\3\2\2\2\u01e3\u01e4\3\2\2\2\u01e4\u01e5\7_\2\2\u01e5\u01e6\7\u00cf"+
		"\2\2\u01e6\u020a\3\2\2\2\u01e7\u01e8\7\f\2\2\u01e8\u01e9\7\61\2\2\u01e9"+
		"\u01ea\5\u0138\u009d\2\u01ea\u01ed\5\22\n\2\u01eb\u01ec\7\67\2\2\u01ec"+
		"\u01ee\5> \2\u01ed\u01eb\3\2\2\2\u01ed\u01ee\3\2\2\2\u01ee\u01f0\3\2\2"+
		"\2\u01ef\u01f1\5\30\r\2\u01f0\u01ef\3\2\2\2\u01f0\u01f1\3\2\2\2\u01f1"+
		"\u01f3\3\2\2\2\u01f2\u01f4\5\"\22\2\u01f3\u01f2\3\2\2\2\u01f3\u01f4\3"+
		"\2\2\2\u01f4\u01f7\3\2\2\2\u01f5\u01f6\7\3\2\2\u01f6\u01f8\5\u0124\u0093"+
		"\2\u01f7\u01f5\3\2\2\2\u01f7\u01f8\3\2\2\2\u01f8\u020a\3\2\2\2\u01f9\u01fa"+
		"\7\f\2\2\u01fa\u01fb\7\61\2\2\u01fb\u01fe\5\u0138\u009d\2\u01fc\u01fd"+
		"\7\67\2\2\u01fd\u01ff\5> \2\u01fe\u01fc\3\2\2\2\u01fe\u01ff\3\2\2\2\u01ff"+
		"\u0201\3\2\2\2\u0200\u0202\5\30\r\2\u0201\u0200\3\2\2\2\u0201\u0202\3"+
		"\2\2\2\u0202\u0204\3\2\2\2\u0203\u0205\5\"\22\2\u0204\u0203\3\2\2\2\u0204"+
		"\u0205\3\2\2\2\u0205\u0206\3\2\2\2\u0206\u0207\7\3\2\2\u0207\u0208\5\u0124"+
		"\u0093\2\u0208\u020a\3\2\2\2\u0209\u01d7\3\2\2\2\u0209\u01e7\3\2\2\2\u0209"+
		"\u01f9\3\2\2\2\u020a\21\3\2\2\2\u020b\u020c\7\u00be\2\2\u020c\u0211\5"+
		"\24\13\2\u020d\u020e\7\u00b7\2\2\u020e\u0210\5\24\13\2\u020f\u020d\3\2"+
		"\2\2\u0210\u0213\3\2\2\2\u0211\u020f\3\2\2\2\u0211\u0212\3\2\2\2\u0212"+
		"\u0214\3\2\2\2\u0213\u0211\3\2\2\2\u0214\u0215\7\u00bf\2\2\u0215\23\3"+
		"\2\2\2\u0216\u0217\5> \2\u0217\u0218\5\26\f\2\u0218\25\3\2\2\2\u0219\u021a"+
		"\5P)\2\u021a\27\3\2\2\2\u021b\u021c\7:\2\2\u021c\u021d\7\u00be\2\2\u021d"+
		"\u0222\5\32\16\2\u021e\u021f\7\u00b7\2\2\u021f\u0221\5\32\16\2\u0220\u021e"+
		"\3\2\2\2\u0221\u0224\3\2\2\2\u0222\u0220\3\2\2\2\u0222\u0223\3\2\2\2\u0223"+
		"\u0225\3\2\2\2\u0224\u0222\3\2\2\2\u0225\u0226\7\u00bf\2\2\u0226\31\3"+
		"\2\2\2\u0227\u0228\7\u00cf\2\2\u0228\u0229\7\u00b4\2\2\u0229\u022a\5\u00a2"+
		"R\2\u022a\33\3\2\2\2\u022b\u022c\7\67\2\2\u022c\u022d\5> \2\u022d\35\3"+
		"\2\2\2\u022e\u022f\7{\2\2\u022f\u0230\5 \21\2\u0230\37\3\2\2\2\u0231\u0232"+
		"\5> \2\u0232!\3\2\2\2\u0233\u0238\5$\23\2\u0234\u0238\5*\26\2\u0235\u0238"+
		"\5\62\32\2\u0236\u0238\58\35\2\u0237\u0233\3\2\2\2\u0237\u0234\3\2\2\2"+
		"\u0237\u0235\3\2\2\2\u0237\u0236\3\2\2\2\u0238#\3\2\2\2\u0239\u023a\7"+
		"k\2\2\u023a\u023b\7=\2\2\u023b\u023c\7p\2\2\u023c\u023d\7\u00be\2\2\u023d"+
		"\u023e\5\u014a\u00a6\2\u023e\u023f\7\u00bf\2\2\u023f\u0240\7\u00be\2\2"+
		"\u0240\u0241\5&\24\2\u0241\u0242\7\u00bf\2\2\u0242%\3\2\2\2\u0243\u0248"+
		"\5(\25\2\u0244\u0245\7\u00b7\2\2\u0245\u0247\5(\25\2\u0246\u0244\3\2\2"+
		"\2\u0247\u024a\3\2\2\2\u0248\u0246\3\2\2\2\u0248\u0249\3\2\2\2\u0249\'"+
		"\3\2\2\2\u024a\u0248\3\2\2\2\u024b\u024c\7k\2\2\u024c\u024d\5:\36\2\u024d"+
		"\u024e\7\u0083\2\2\u024e\u024f\7]\2\2\u024f\u025b\7|\2\2\u0250\u0251\7"+
		"\u00be\2\2\u0251\u0252\5\u009eP\2\u0252\u0253\7\u00bf\2\2\u0253\u025c"+
		"\3\2\2\2\u0254\u0256\7\u00be\2\2\u0255\u0254\3\2\2\2\u0255\u0256\3\2\2"+
		"\2\u0256\u0257\3\2\2\2\u0257\u0259\7a\2\2\u0258\u025a\7\u00bf\2\2\u0259"+
		"\u0258\3\2\2\2\u0259\u025a\3\2\2\2\u025a\u025c\3\2\2\2\u025b\u0250\3\2"+
		"\2\2\u025b\u0255\3\2\2\2\u025c)\3\2\2\2\u025d\u025e\7k\2\2\u025e\u025f"+
		"\7=\2\2\u025f\u0260\7U\2\2\u0260\u0261\7\u00be\2\2\u0261\u0262\5\u014a"+
		"\u00a6\2\u0262\u0268\7\u00bf\2\2\u0263\u0264\7\u00be\2\2\u0264\u0265\5"+
		",\27\2\u0265\u0266\7\u00bf\2\2\u0266\u0269\3\2\2\2\u0267\u0269\5\60\31"+
		"\2\u0268\u0263\3\2\2\2\u0268\u0267\3\2\2\2\u0269+\3\2\2\2\u026a\u026f"+
		"\5.\30\2\u026b\u026c\7\u00b7\2\2\u026c\u026e\5.\30\2\u026d\u026b\3\2\2"+
		"\2\u026e\u0271\3\2\2\2\u026f\u026d\3\2\2\2\u026f\u0270\3\2\2\2\u0270-"+
		"\3\2\2\2\u0271\u026f\3\2\2\2\u0272\u0273\7k\2\2\u0273\u0274\5:\36\2\u0274"+
		"/\3\2\2\2\u0275\u0276\7l\2\2\u0276\u0277\5\u00a2R\2\u0277\61\3\2\2\2\u0278"+
		"\u0279\7k\2\2\u0279\u027a\7=\2\2\u027a\u027b\7^\2\2\u027b\u027c\7\u00be"+
		"\2\2\u027c\u027d\5\u014a\u00a6\2\u027d\u027e\7\u00bf\2\2\u027e\u027f\7"+
		"\u00be\2\2\u027f\u0280\5\64\33\2\u0280\u0281\7\u00bf\2\2\u0281\63\3\2"+
		"\2\2\u0282\u0287\5\66\34\2\u0283\u0284\7\u00b7\2\2\u0284\u0286\5\66\34"+
		"\2\u0285\u0283\3\2\2\2\u0286\u0289\3\2\2\2\u0287\u0285\3\2\2\2\u0287\u0288"+
		"\3\2\2\2\u0288\65\3\2\2\2\u0289\u0287\3\2\2\2\u028a\u028b\7k\2\2\u028b"+
		"\u028c\5:\36\2\u028c\u028e\7\u0083\2\2\u028d\u028f\7\33\2\2\u028e\u028d"+
		"\3\2\2\2\u028e\u028f\3\2\2\2\u028f\u0290\3\2\2\2\u0290\u0291\7\u00be\2"+
		"\2\u0291\u0292\5\u0162\u00b2\2\u0292\u0293\7\u00bf\2\2\u0293\67\3\2\2"+
		"\2\u0294\u0295\7k\2\2\u0295\u0296\7=\2\2\u0296\u0297\7B\2\2\u0297\u0298"+
		"\5\22\n\2\u02989\3\2\2\2\u0299\u029a\5> \2\u029a;\3\2\2\2\u029b\u029c"+
		"\7J\2\2\u029c\u029d\7\61\2\2\u029d\u029f\5\u0138\u009d\2\u029e\u02a0\7"+
		"n\2\2\u029f\u029e\3\2\2\2\u029f\u02a0\3\2\2\2\u02a0=\3\2\2\2\u02a1\u02a4"+
		"\7\u00ce\2\2\u02a2\u02a4\5@!\2\u02a3\u02a1\3\2\2\2\u02a3\u02a2\3\2\2\2"+
		"\u02a4?\3\2\2\2\u02a5\u02a6\t\2\2\2\u02a6A\3\2\2\2\u02a7\u02aa\5v<\2\u02a8"+
		"\u02aa\5D#\2\u02a9\u02a7\3\2\2\2\u02a9\u02a8\3\2\2\2\u02aaC\3\2\2\2\u02ab"+
		"\u02af\7\u00cf\2\2\u02ac\u02af\5F$\2\u02ad\u02af\5N(\2\u02ae\u02ab\3\2"+
		"\2\2\u02ae\u02ac\3\2\2\2\u02ae\u02ad\3\2\2\2\u02afE\3\2\2\2\u02b0\u02b4"+
		"\5J&\2\u02b1\u02b4\5H%\2\u02b2\u02b4\5L\'\2\u02b3\u02b0\3\2\2\2\u02b3"+
		"\u02b1\3\2\2\2\u02b3\u02b2\3\2\2\2\u02b4G\3\2\2\2\u02b5\u02b6\7\u00a4"+
		"\2\2\u02b6\u02b7\7\u00cf\2\2\u02b7I\3\2\2\2\u02b8\u02b9\7\u00a6\2\2\u02b9"+
		"\u02ba\7\u00cf\2\2\u02baK\3\2\2\2\u02bb\u02bc\7\u00a3\2\2\u02bc\u02bd"+
		"\7\u00cf\2\2\u02bdM\3\2\2\2\u02be\u02bf\t\3\2\2\u02bfO\3\2\2\2\u02c0\u02c1"+
		"\5R*\2\u02c1Q\3\2\2\2\u02c2\u02cc\5V,\2\u02c3\u02cc\5Z.\2\u02c4\u02cc"+
		"\5\\/\2\u02c5\u02cc\5^\60\2\u02c6\u02cc\5f\64\2\u02c7\u02cc\5h\65\2\u02c8"+
		"\u02cc\5j\66\2\u02c9\u02cc\5l\67\2\u02ca\u02cc\5T+\2\u02cb\u02c2\3\2\2"+
		"\2\u02cb\u02c3\3\2\2\2\u02cb\u02c4\3\2\2\2\u02cb\u02c5\3\2\2\2\u02cb\u02c6"+
		"\3\2\2\2\u02cb\u02c7\3\2\2\2\u02cb\u02c8\3\2\2\2\u02cb\u02c9\3\2\2\2\u02cb"+
		"\u02ca\3\2\2\2\u02ccS\3\2\2\2\u02cd\u02ce\7\u00ad\2\2\u02ceU\3\2\2\2\u02cf"+
		"\u02d1\7?\2\2\u02d0\u02d2\5X-\2\u02d1\u02d0\3\2\2\2\u02d1\u02d2\3\2\2"+
		"\2\u02d2\u02e7\3\2\2\2\u02d3\u02d5\7\u009f\2\2\u02d4\u02d6\5X-\2\u02d5"+
		"\u02d4\3\2\2\2\u02d5\u02d6\3\2\2\2\u02d6\u02e7\3\2\2\2\u02d7\u02d8\7?"+
		"\2\2\u02d8\u02da\7\u0086\2\2\u02d9\u02db\5X-\2\u02da\u02d9\3\2\2\2\u02da"+
		"\u02db\3\2\2\2\u02db\u02e7\3\2\2\2\u02dc\u02dd\7\u009f\2\2\u02dd\u02df"+
		"\7\u0086\2\2\u02de\u02e0\5X-\2\u02df\u02de\3\2\2\2\u02df\u02e0\3\2\2\2"+
		"\u02e0\u02e7\3\2\2\2\u02e1\u02e3\7\u00a0\2\2\u02e2\u02e4\5X-\2\u02e3\u02e2"+
		"\3\2\2\2\u02e3\u02e4\3\2\2\2\u02e4\u02e7\3\2\2\2\u02e5\u02e7\7\u00a8\2"+
		"\2\u02e6\u02cf\3\2\2\2\u02e6\u02d3\3\2\2\2\u02e6\u02d7\3\2\2\2\u02e6\u02dc"+
		"\3\2\2\2\u02e6\u02e1\3\2\2\2\u02e6\u02e5\3\2\2\2\u02e7W\3\2\2\2\u02e8"+
		"\u02e9\7\u00be\2\2\u02e9\u02ea\7\u00ca\2\2\u02ea\u02eb\7\u00bf\2\2\u02eb"+
		"Y\3\2\2\2\u02ec\u02ed\7h\2\2\u02ed\u02ef\7?\2\2\u02ee\u02f0\5X-\2\u02ef"+
		"\u02ee\3\2\2\2\u02ef\u02f0\3\2\2\2\u02f0\u0310\3\2\2\2\u02f1\u02f2\7h"+
		"\2\2\u02f2\u02f4\7\u009f\2\2\u02f3\u02f5\5X-\2\u02f4\u02f3\3\2\2\2\u02f4"+
		"\u02f5\3\2\2\2\u02f5\u0310\3\2\2\2\u02f6\u02f8\7\u00a1\2\2\u02f7\u02f9"+
		"\5X-\2\u02f8\u02f7\3\2\2\2\u02f8\u02f9\3\2\2\2\u02f9\u0310\3\2\2\2\u02fa"+
		"\u02fb\7h\2\2\u02fb\u02fc\7?\2\2\u02fc\u02fe\7\u0086\2\2\u02fd\u02ff\5"+
		"X-\2\u02fe\u02fd\3\2\2\2\u02fe\u02ff\3\2\2\2\u02ff\u0310\3\2\2\2\u0300"+
		"\u0301\7h\2\2\u0301\u0302\7\u009f\2\2\u0302\u0304\7\u0086\2\2\u0303\u0305"+
		"\5X-\2\u0304\u0303\3\2\2\2\u0304\u0305\3\2\2\2\u0305\u0310\3\2\2\2\u0306"+
		"\u0307\7\u00a1\2\2\u0307\u0309\7\u0086\2\2\u0308\u030a\5X-\2\u0309\u0308"+
		"\3\2\2\2\u0309\u030a\3\2\2\2\u030a\u0310\3\2\2\2\u030b\u030d\7\u00a2\2"+
		"\2\u030c\u030e\5X-\2\u030d\u030c\3\2\2\2\u030d\u030e\3\2\2\2\u030e\u0310"+
		"\3\2\2\2\u030f\u02ec\3\2\2\2\u030f\u02f1\3\2\2\2\u030f\u02f6\3\2\2\2\u030f"+
		"\u02fa\3\2\2\2\u030f\u0300\3\2\2\2\u030f\u0306\3\2\2\2\u030f\u030b\3\2"+
		"\2\2\u0310[\3\2\2\2\u0311\u0313\7\u00ab\2\2\u0312\u0314\5X-\2\u0313\u0312"+
		"\3\2\2\2\u0313\u0314\3\2\2\2\u0314\u031a\3\2\2\2\u0315\u0317\7\u00ac\2"+
		"\2\u0316\u0318\5X-\2\u0317\u0316\3\2\2\2\u0317\u0318\3\2\2\2\u0318\u031a"+
		"\3\2\2\2\u0319\u0311\3\2\2\2\u0319\u0315\3\2\2\2\u031a]\3\2\2\2\u031b"+
		"\u031e\5`\61\2\u031c\u031e\5b\62\2\u031d\u031b\3\2\2\2\u031d\u031c\3\2"+
		"\2\2\u031e_\3\2\2\2\u031f\u0321\7\u009d\2\2\u0320\u0322\5d\63\2\u0321"+
		"\u0320\3\2\2\2\u0321\u0322\3\2\2\2\u0322\u0335\3\2\2\2\u0323\u0325\7\u009e"+
		"\2\2\u0324\u0326\5d\63\2\u0325\u0324\3\2\2\2\u0325\u0326\3\2\2\2\u0326"+
		"\u0335\3\2\2\2\u0327\u0329\7F\2\2\u0328\u032a\5d\63\2\u0329\u0328\3\2"+
		"\2\2\u0329\u032a\3\2\2\2\u032a\u0335\3\2\2\2\u032b\u0335\7\u008f\2\2\u032c"+
		"\u0335\7\u0093\2\2\u032d\u0335\7\u0090\2\2\u032e\u0335\7\u0094\2\2\u032f"+
		"\u0335\7\u0091\2\2\u0330\u0335\7\u0095\2\2\u0331\u0335\7\u0096\2\2\u0332"+
		"\u0335\7\u0092\2\2\u0333\u0335\7\u0097\2\2\u0334\u031f\3\2\2\2\u0334\u0323"+
		"\3\2\2\2\u0334\u0327\3\2\2\2\u0334\u032b\3\2\2\2\u0334\u032c\3\2\2\2\u0334"+
		"\u032d\3\2\2\2\u0334\u032e\3\2\2\2\u0334\u032f\3\2\2\2\u0334\u0330\3\2"+
		"\2\2\u0334\u0331\3\2\2\2\u0334\u0332\3\2\2\2\u0334\u0333\3\2\2\2\u0335"+
		"a\3\2\2\2\u0336\u0338\7\u009b\2\2\u0337\u0339\5d\63\2\u0338\u0337\3\2"+
		"\2\2\u0338\u0339\3\2\2\2\u0339\u0341\3\2\2\2\u033a\u0341\7\u0098\2\2\u033b"+
		"\u0341\7\u009a\2\2\u033c\u0341\7\u0099\2\2\u033d\u0341\7\u009c\2\2\u033e"+
		"\u033f\7\u009c\2\2\u033f\u0341\7m\2\2\u0340\u0336\3\2\2\2\u0340\u033a"+
		"\3\2\2\2\u0340\u033b\3\2\2\2\u0340\u033c\3\2\2\2\u0340\u033d\3\2\2\2\u0340"+
		"\u033e\3\2\2\2\u0341c\3\2\2\2\u0342\u0343\7\u00be\2\2\u0343\u0344\7\u00ca"+
		"\2\2\u0344\u034b\7\u00bf\2\2\u0345\u0346\7\u00be\2\2\u0346\u0347\7\u00ca"+
		"\2\2\u0347\u0348\7\u00b7\2\2\u0348\u0349\7\u00ca\2\2\u0349\u034b\7\u00bf"+
		"\2\2\u034a\u0342\3\2\2\2\u034a\u0345\3\2\2\2\u034be\3\2\2\2\u034c\u034d"+
		"\t\4\2\2\u034dg\3\2\2\2\u034e\u035c\7\u00a3\2\2\u034f\u035c\7\u00a4\2"+
		"\2\u0350\u0351\7\u00a4\2\2\u0351\u0352\7:\2\2\u0352\u0353\7\u00a4\2\2"+
		"\u0353\u035c\7\u008a\2\2\u0354\u035c\7\u00a5\2\2\u0355\u035c\7\u00a6\2"+
		"\2\u0356\u0357\7\u00a6\2\2\u0357\u0358\7:\2\2\u0358\u0359\7\u00a4\2\2"+
		"\u0359\u035c\7\u008a\2\2\u035a\u035c\7\u00a7\2\2\u035b\u034e\3\2\2\2\u035b"+
		"\u034f\3\2\2\2\u035b\u0350\3\2\2\2\u035b\u0354\3\2\2\2\u035b\u0355\3\2"+
		"\2\2\u035b\u0356\3\2\2\2\u035b\u035a\3\2\2\2\u035ci\3\2\2\2\u035d\u035f"+
		"\7\u008d\2\2\u035e\u0360\5X-\2\u035f\u035e\3\2\2\2\u035f\u0360\3\2\2\2"+
		"\u0360\u036b\3\2\2\2\u0361\u0363\7\u008e\2\2\u0362\u0364\5X-\2\u0363\u0362"+
		"\3\2\2\2\u0363\u0364\3\2\2\2\u0364\u036b\3\2\2\2\u0365\u0366\7\u008d\2"+
		"\2\u0366\u0368\7\u0086\2\2\u0367\u0369\5X-\2\u0368\u0367\3\2\2\2\u0368"+
		"\u0369\3\2\2\2\u0369\u036b\3\2\2\2\u036a\u035d\3\2\2\2\u036a\u0361\3\2"+
		"\2\2\u036a\u0365\3\2\2\2\u036bk\3\2\2\2\u036c\u036e\7\u00a9\2\2\u036d"+
		"\u036f\5X-\2\u036e\u036d\3\2\2\2\u036e\u036f\3\2\2\2\u036f\u037a\3\2\2"+
		"\2\u0370\u0371\7\u00a9\2\2\u0371\u0373\7\u0086\2\2\u0372\u0374\5X-\2\u0373"+
		"\u0372\3\2\2\2\u0373\u0374\3\2\2\2\u0374\u037a\3\2\2\2\u0375\u0377\7\u00aa"+
		"\2\2\u0376\u0378\5X-\2\u0377\u0376\3\2\2\2\u0377\u0378\3\2\2\2\u0378\u037a"+
		"\3\2\2\2\u0379\u036c\3\2\2\2\u0379\u0370\3\2\2\2\u0379\u0375\3\2\2\2\u037a"+
		"m\3\2\2\2\u037b\u037e\5p9\2\u037c\u037e\5r:\2\u037d\u037b\3\2\2\2\u037d"+
		"\u037c\3\2\2\2\u037eo\3\2\2\2\u037f\u0380\7\u00be\2\2\u0380\u0381\5\u009e"+
		"P\2\u0381\u0382\7\u00bf\2\2\u0382q\3\2\2\2\u0383\u038b\5t;\2\u0384\u038b"+
		"\5\u0146\u00a4\2\u0385\u038b\5z>\2\u0386\u038b\5\u014c\u00a7\2\u0387\u038b"+
		"\5\u0086D\2\u0388\u038b\5\u0098M\2\u0389\u038b\5\u0180\u00c1\2\u038a\u0383"+
		"\3\2\2\2\u038a\u0384\3\2\2\2\u038a\u0385\3\2\2\2\u038a\u0386\3\2\2\2\u038a"+
		"\u0387\3\2\2\2\u038a\u0388\3\2\2\2\u038a\u0389\3\2\2\2\u038bs\3\2\2\2"+
		"\u038c\u038d\5B\"\2\u038du\3\2\2\2\u038e\u038f\t\5\2\2\u038fw\3\2\2\2"+
		"\u0390\u0392\5\u00acW\2\u0391\u0390\3\2\2\2\u0391\u0392\3\2\2\2\u0392"+
		"\u0393\3\2\2\2\u0393\u0394\5v<\2\u0394y\3\2\2\2\u0395\u0396\5|?\2\u0396"+
		"{\3\2\2\2\u0397\u0398\7C\2\2\u0398\u0399\7\u00be\2\2\u0399\u039a\7\u00c2"+
		"\2\2\u039a\u03a0\7\u00bf\2\2\u039b\u039d\5~@\2\u039c\u039e\5\u0082B\2"+
		"\u039d\u039c\3\2\2\2\u039d\u039e\3\2\2\2\u039e\u03a0\3\2\2\2\u039f\u0397"+
		"\3\2\2\2\u039f\u039b\3\2\2\2\u03a0}\3\2\2\2\u03a1\u03a2\5\u0080A\2\u03a2"+
		"\u03a4\7\u00be\2\2\u03a3\u03a5\5\u0144\u00a3\2\u03a4\u03a3\3\2\2\2\u03a4"+
		"\u03a5\3\2\2\2\u03a5\u03a6\3\2\2\2\u03a6\u03a7\5\u009eP\2\u03a7\u03a8"+
		"\7\u00bf\2\2\u03a8\177\3\2\2\2\u03a9\u03aa\t\6\2\2\u03aa\u0081\3\2\2\2"+
		"\u03ab\u03ac\7P\2\2\u03ac\u03ad\7\u00be\2\2\u03ad\u03ae\79\2\2\u03ae\u03af"+
		"\5\u010e\u0088\2\u03af\u03b0\7\u00bf\2\2\u03b0\u0083\3\2\2\2\u03b1\u03b2"+
		"\7T\2\2\u03b2\u03b3\7\u00be\2\2\u03b3\u03b4\5\u014a\u00a6\2\u03b4\u03b5"+
		"\7\u00bf\2\2\u03b5\u0085\3\2\2\2\u03b6\u03b7\5\u008aF\2\u03b7\u0087\3"+
		"\2\2\2\u03b8\u03b9\7i\2\2\u03b9\u03ba\7\u00be\2\2\u03ba\u03bb\5\u00a2"+
		"R\2\u03bb\u03bc\7\u00b7\2\2\u03bc\u03bd\5\u00c8e\2\u03bd\u03be\7\u00bf"+
		"\2\2\u03be\u03cb\3\2\2\2\u03bf\u03c0\7A\2\2\u03c0\u03c1\7\u00be\2\2\u03c1"+
		"\u03c4\5\u00a2R\2\u03c2\u03c3\7\u00b7\2\2\u03c3\u03c5\5\u00c8e\2\u03c4"+
		"\u03c2\3\2\2\2\u03c5\u03c6\3\2\2\2\u03c6\u03c4\3\2\2\2\u03c6\u03c7\3\2"+
		"\2\2\u03c7\u03c8\3\2\2\2\u03c8\u03c9\7\u00bf\2\2\u03c9\u03cb\3\2\2\2\u03ca"+
		"\u03b8\3\2\2\2\u03ca\u03bf\3\2\2\2\u03cb\u0089\3\2\2\2\u03cc\u03cf\5\u008c"+
		"G\2\u03cd\u03cf\5\u008eH\2\u03ce\u03cc\3\2\2\2\u03ce\u03cd\3\2\2\2\u03cf"+
		"\u008b\3\2\2\2\u03d0\u03d1\7\n\2\2\u03d1\u03d3\5\u00c8e\2\u03d2\u03d4"+
		"\5\u0090I\2\u03d3\u03d2\3\2\2\2\u03d4\u03d5\3\2\2\2\u03d5\u03d3\3\2\2"+
		"\2\u03d5\u03d6\3\2\2\2\u03d6\u03d8\3\2\2\2\u03d7\u03d9\5\u0094K\2\u03d8"+
		"\u03d7\3\2\2\2\u03d8\u03d9\3\2\2\2\u03d9\u03da\3\2\2\2\u03da\u03db\7\20"+
		"\2\2\u03db\u008d\3\2\2\2\u03dc\u03de\7\n\2\2\u03dd\u03df\5\u0092J\2\u03de"+
		"\u03dd\3\2\2\2\u03df\u03e0\3\2\2\2\u03e0\u03de\3\2\2\2\u03e0\u03e1\3\2"+
		"\2\2\u03e1\u03e3\3\2\2\2\u03e2\u03e4\5\u0094K\2\u03e3\u03e2\3\2\2\2\u03e3"+
		"\u03e4\3\2\2\2\u03e4\u03e5\3\2\2\2\u03e5\u03e6\7\20\2\2\u03e6\u008f\3"+
		"\2\2\2\u03e7\u03e8\78\2\2\u03e8\u03e9\5\u010e\u0088\2\u03e9\u03ea\7\62"+
		"\2\2\u03ea\u03eb\5\u0096L\2\u03eb\u0091\3\2\2\2\u03ec\u03ed\78\2\2\u03ed"+
		"\u03ee\5\u010e\u0088\2\u03ee\u03ef\7\62\2\2\u03ef\u03f0\5\u0096L\2\u03f0"+
		"\u0093\3\2\2\2\u03f1\u03f2\7\21\2\2\u03f2\u03f3\5\u0096L\2\u03f3\u0095"+
		"\3\2\2\2\u03f4\u03f7\5\u009eP\2\u03f5\u03f7\7\'\2\2\u03f6\u03f4\3\2\2"+
		"\2\u03f6\u03f5\3\2\2\2\u03f7\u0097\3\2\2\2\u03f8\u03f9\7\13\2\2\u03f9"+
		"\u03fa\7\u00be\2\2\u03fa\u03fb\5\u009aN\2\u03fb\u03fc\7\3\2\2\u03fc\u03fd"+
		"\5\u009cO\2\u03fd\u03fe\7\u00bf\2\2\u03fe\u0099\3\2\2\2\u03ff\u0400\5"+
		"\u009eP\2\u0400\u009b\3\2\2\2\u0401\u0402\5P)\2\u0402\u009d\3\2\2\2\u0403"+
		"\u0407\5\u00a0Q\2\u0404\u0407\5\u00dco\2\u0405\u0407\5\u00c8e\2\u0406"+
		"\u0403\3\2\2\2\u0406\u0404\3\2\2\2\u0406\u0405\3\2\2\2\u0407\u009f\3\2"+
		"\2\2\u0408\u040c\5\u00a2R\2\u0409\u040c\5\u00b8]\2\u040a\u040c\7\'\2\2"+
		"\u040b\u0408\3\2\2\2\u040b\u0409\3\2\2\2\u040b\u040a\3\2\2\2\u040c\u00a1"+
		"\3\2\2\2\u040d\u0412\5\u00a4S\2\u040e\u040f\t\7\2\2\u040f\u0411\5\u00a4"+
		"S\2\u0410\u040e\3\2\2\2\u0411\u0414\3\2\2\2\u0412\u0410\3\2\2\2\u0412"+
		"\u0413\3\2\2\2\u0413\u00a3\3\2\2\2\u0414\u0412\3\2\2\2\u0415\u041a\5\u00a6"+
		"T\2\u0416\u0417\t\b\2\2\u0417\u0419\5\u00a6T\2\u0418\u0416\3\2\2\2\u0419"+
		"\u041c\3\2\2\2\u041a\u0418\3\2\2\2\u041a\u041b\3\2\2\2\u041b\u00a5\3\2"+
		"\2\2\u041c\u041a\3\2\2\2\u041d\u041f\5\u00acW\2\u041e\u041d\3\2\2\2\u041e"+
		"\u041f\3\2\2\2\u041f\u0420\3\2\2\2\u0420\u0421\5\u00aaV\2\u0421\u00a7"+
		"\3\2\2\2\u0422\u0423\7\u00be\2\2\u0423\u0428\5\u00a2R\2\u0424\u0425\7"+
		"\u00b7\2\2\u0425\u0427\5\u00a2R\2\u0426\u0424\3\2\2\2\u0427\u042a\3\2"+
		"\2\2\u0428\u0426\3\2\2\2\u0428\u0429\3\2\2\2\u0429\u042b\3\2\2\2\u042a"+
		"\u0428\3\2\2\2\u042b\u042c\7\u00bf\2\2\u042c\u00a9\3\2\2\2\u042d\u0432"+
		"\5n8\2\u042e\u042f\7\u00b2\2\2\u042f\u0431\5\u009cO\2\u0430\u042e\3\2"+
		"\2\2\u0431\u0434\3\2\2\2\u0432\u0430\3\2\2\2\u0432\u0433\3\2\2\2\u0433"+
		"\u0437\3\2\2\2\u0434\u0432\3\2\2\2\u0435\u0437\5\u00aeX\2\u0436\u042d"+
		"\3\2\2\2\u0436\u0435\3\2\2\2\u0437\u00ab\3\2\2\2\u0438\u0439\t\7\2\2\u0439"+
		"\u00ad\3\2\2\2\u043a\u043b\5\u00b0Y\2\u043b\u00af\3\2\2\2\u043c\u043d"+
		"\7O\2\2\u043d\u043e\7\u00be\2\2\u043e\u043f\5\u00b2Z\2\u043f\u0440\7\26"+
		"\2\2\u0440\u0441\5\u00b6\\\2\u0441\u0442\7\u00bf\2\2\u0442\u00b1\3\2\2"+
		"\2\u0443\u0447\5\u017a\u00be\2\u0444\u0447\5\u00b4[\2\u0445\u0447\5\u017e"+
		"\u00c0\2\u0446\u0443\3\2\2\2\u0446\u0444\3\2\2\2\u0446\u0445\3\2\2\2\u0447"+
		"\u00b3\3\2\2\2\u0448\u0449\t\t\2\2\u0449\u00b5\3\2\2\2\u044a\u044d\5\u0146"+
		"\u00a4\2\u044b\u044d\5F$\2\u044c\u044a\3\2\2\2\u044c\u044b\3\2\2\2\u044d"+
		"\u00b7\3\2\2\2\u044e\u044f\5\u00ba^\2\u044f\u00b9\3\2\2\2\u0450\u0455"+
		"\5\u00bc_\2\u0451\u0452\7\u00b8\2\2\u0452\u0454\5\u00bc_\2\u0453\u0451"+
		"\3\2\2\2\u0454\u0457\3\2\2\2\u0455\u0453\3\2\2\2\u0455\u0456\3\2\2\2\u0456"+
		"\u00bb\3\2\2\2\u0457\u0455\3\2\2\2\u0458\u0459\5\u00be`\2\u0459\u00bd"+
		"\3\2\2\2\u045a\u045d\5n8\2\u045b\u045d\5\u00c0a\2\u045c\u045a\3\2\2\2"+
		"\u045c\u045b\3\2\2\2\u045d\u00bf\3\2\2\2\u045e\u045f\5\u00c2b\2\u045f"+
		"\u00c1\3\2\2\2\u0460\u0461\7\u0080\2\2\u0461\u0462\7\u00be\2\2\u0462\u0463"+
		"\5\u00c4c\2\u0463\u0464\7\u00bf\2\2\u0464\u00c3\3\2\2\2\u0465\u0467\5"+
		"\u00c6d\2\u0466\u0465\3\2\2\2\u0466\u0467\3\2\2\2\u0467\u0469\3\2\2\2"+
		"\u0468\u046a\5\u00ba^\2\u0469\u0468\3\2\2\2\u0469\u046a\3\2\2\2\u046a"+
		"\u046b\3\2\2\2\u046b\u046d\7\26\2\2\u046c\u0466\3\2\2\2\u046c\u046d\3"+
		"\2\2\2\u046d\u046e\3\2\2\2\u046e\u0474\5\u00ba^\2\u046f\u0470\5\u00ba"+
		"^\2\u0470\u0471\7\u00b7\2\2\u0471\u0472\5\u00ba^\2\u0472\u0474\3\2\2\2"+
		"\u0473\u046c\3\2\2\2\u0473\u046f\3\2\2\2\u0474\u00c5\3\2\2\2\u0475\u0476"+
		"\t\n\2\2\u0476\u00c7\3\2\2\2\u0477\u0478\5\u00caf\2\u0478\u00c9\3\2\2"+
		"\2\u0479\u047e\5\u00ccg\2\u047a\u047b\7*\2\2\u047b\u047d\5\u00caf\2\u047c"+
		"\u047a\3\2\2\2\u047d\u0480\3\2\2\2\u047e\u047c\3\2\2\2\u047e\u047f\3\2"+
		"\2\2\u047f\u00cb\3\2\2\2\u0480\u047e\3\2\2\2\u0481\u0486\5\u00ceh\2\u0482"+
		"\u0483\7\5\2\2\u0483\u0485\5\u00ccg\2\u0484\u0482\3\2\2\2\u0485\u0488"+
		"\3\2\2\2\u0486\u0484\3\2\2\2\u0486\u0487\3\2\2\2\u0487\u00cd\3\2\2\2\u0488"+
		"\u0486\3\2\2\2\u0489\u048d\5\u00d0i\2\u048a\u048b\7&\2\2\u048b\u048d\5"+
		"\u00d0i\2\u048c\u0489\3\2\2\2\u048c\u048a\3\2\2\2\u048d\u00cf\3\2\2\2"+
		"\u048e\u0490\5\u00d6l\2\u048f\u0491\5\u00d2j\2\u0490\u048f\3\2\2\2\u0490"+
		"\u0491\3\2\2\2\u0491\u00d1\3\2\2\2\u0492\u0494\7\37\2\2\u0493\u0495\7"+
		"&\2\2\u0494\u0493\3\2\2\2\u0494\u0495\3\2\2\2\u0495\u0496\3\2\2\2\u0496"+
		"\u0497\5\u00d4k\2\u0497\u00d3\3\2\2\2\u0498\u0499\t\3\2\2\u0499\u00d5"+
		"\3\2\2\2\u049a\u049d\5\u0154\u00ab\2\u049b\u049d\5\u00d8m\2\u049c\u049a"+
		"\3\2\2\2\u049c\u049b\3\2\2\2\u049d\u00d7\3\2\2\2\u049e\u04a1\5\u00dan"+
		"\2\u049f\u04a1\5r:\2\u04a0\u049e\3\2\2\2\u04a0\u049f\3\2\2\2\u04a1\u00d9"+
		"\3\2\2\2\u04a2\u04a3\7\u00be\2\2\u04a3\u04a4\5\u00c8e\2\u04a4\u04a5\7"+
		"\u00bf\2\2\u04a5\u00db\3\2\2\2\u04a6\u04a9\5\u00dep\2\u04a7\u04a9\5\u00e0"+
		"q\2\u04a8\u04a6\3\2\2\2\u04a8\u04a7\3\2\2\2\u04a9\u00dd\3\2\2\2\u04aa"+
		"\u04ab\5r:\2\u04ab\u00df\3\2\2\2\u04ac\u04ad\7\'\2\2\u04ad\u00e1\3\2\2"+
		"\2\u04ae\u04b1\5\u00dep\2\u04af\u04b1\5\u00e4s\2\u04b0\u04ae\3\2\2\2\u04b0"+
		"\u04af\3\2\2\2\u04b1\u00e3\3\2\2\2\u04b2\u04b5\5\u00a0Q\2\u04b3\u04b5"+
		"\5\u00d8m\2\u04b4\u04b2\3\2\2\2\u04b4\u04b3\3\2\2\2\u04b5\u00e5\3\2\2"+
		"\2\u04b6\u04b8\5\u00e8u\2\u04b7\u04b9\5\u010c\u0087\2\u04b8\u04b7\3\2"+
		"\2\2\u04b8\u04b9\3\2\2\2\u04b9\u04bb\3\2\2\2\u04ba\u04bc\5\u0110\u0089"+
		"\2\u04bb\u04ba\3\2\2\2\u04bb\u04bc\3\2\2\2\u04bc\u04be\3\2\2\2\u04bd\u04bf"+
		"\5\u0120\u0091\2\u04be\u04bd\3\2\2\2\u04be\u04bf\3\2\2\2\u04bf\u04c1\3"+
		"\2\2\2\u04c0\u04c2\5\u0188\u00c5\2\u04c1\u04c0\3\2\2\2\u04c1\u04c2\3\2"+
		"\2\2\u04c2\u04c4\3\2\2\2\u04c3\u04c5\5\u0190\u00c9\2\u04c4\u04c3\3\2\2"+
		"\2\u04c4\u04c5\3\2\2\2\u04c5\u00e7\3\2\2\2\u04c6\u04c7\7\26\2\2\u04c7"+
		"\u04c8\5\u00eav\2\u04c8\u00e9\3\2\2\2\u04c9\u04ce\5\u00ecw\2\u04ca\u04cb"+
		"\7\u00b7\2\2\u04cb\u04cd\5\u00ecw\2\u04cc\u04ca\3\2\2\2\u04cd\u04d0\3"+
		"\2\2\2\u04ce\u04cc\3\2\2\2\u04ce\u04cf\3\2\2\2\u04cf\u00eb\3\2\2\2\u04d0"+
		"\u04ce\3\2\2\2\u04d1\u04d4\5\u00eex\2\u04d2\u04d4\5\u0106\u0084\2\u04d3"+
		"\u04d1\3\2\2\2\u04d3\u04d2\3\2\2\2\u04d4\u00ed\3\2\2\2\u04d5\u04d7\5\u0106"+
		"\u0084\2\u04d6\u04d8\5\u00f0y\2\u04d7\u04d6\3\2\2\2\u04d8\u04d9\3\2\2"+
		"\2\u04d9\u04d7\3\2\2\2\u04d9\u04da\3\2\2\2\u04da\u00ef\3\2\2\2\u04db\u04dc"+
		"\7\r\2\2\u04dc\u04dd\7 \2\2\u04dd\u04ef\5\u0106\u0084\2\u04de\u04e0\5"+
		"\u00fa~\2\u04df\u04de\3\2\2\2\u04df\u04e0\3\2\2\2\u04e0\u04e1\3\2\2\2"+
		"\u04e1\u04e2\7 \2\2\u04e2\u04e3\5\u0106\u0084\2\u04e3\u04e4\5\u0100\u0081"+
		"\2\u04e4\u04ef\3\2\2\2\u04e5\u04e7\7%\2\2\u04e6\u04e8\5\u00fa~\2\u04e7"+
		"\u04e6\3\2\2\2\u04e7\u04e8\3\2\2\2\u04e8\u04e9\3\2\2\2\u04e9\u04ea\7 "+
		"\2\2\u04ea\u04ef\5\u0106\u0084\2\u04eb\u04ec\7\65\2\2\u04ec\u04ed\7 \2"+
		"\2\u04ed\u04ef\5\u0106\u0084\2\u04ee\u04db\3\2\2\2\u04ee\u04df\3\2\2\2"+
		"\u04ee\u04e5\3\2\2\2\u04ee\u04eb\3\2\2\2\u04ef\u00f1\3\2\2\2\u04f0\u04f1"+
		"\7\r\2\2\u04f1\u04f2\7 \2\2\u04f2\u04f3\5\u0106\u0084\2\u04f3\u00f3\3"+
		"\2\2\2\u04f4\u04f6\5\u00fa~\2\u04f5\u04f4\3\2\2\2\u04f5\u04f6\3\2\2\2"+
		"\u04f6\u04f7\3\2\2\2\u04f7\u04f8\7 \2\2\u04f8\u04f9\5\u0106\u0084\2\u04f9"+
		"\u04fa\5\u0100\u0081\2\u04fa\u00f5\3\2\2\2\u04fb\u04fd\7%\2\2\u04fc\u04fe"+
		"\5\u00fa~\2\u04fd\u04fc\3\2\2\2\u04fd\u04fe\3\2\2\2\u04fe\u04ff\3\2\2"+
		"\2\u04ff\u0500\7 \2\2\u0500\u0501\5\u0106\u0084\2\u0501\u00f7\3\2\2\2"+
		"\u0502\u0503\7\65\2\2\u0503\u0504\7 \2\2\u0504\u0505\5\u0106\u0084\2\u0505"+
		"\u00f9\3\2\2\2\u0506\u0509\7\34\2\2\u0507\u0509\5\u00fc\177\2\u0508\u0506"+
		"\3\2\2\2\u0508\u0507\3\2\2\2\u0509\u00fb\3\2\2\2\u050a\u050c\5\u00fe\u0080"+
		"\2\u050b\u050d\7)\2\2\u050c\u050b\3\2\2\2\u050c\u050d\3\2\2\2\u050d\u00fd"+
		"\3\2\2\2\u050e\u050f\t\13\2\2\u050f\u00ff\3\2\2\2\u0510\u0513\5\u0102"+
		"\u0082\2\u0511\u0513\5\u0104\u0083\2\u0512\u0510\3\2\2\2\u0512\u0511\3"+
		"\2\2\2\u0513\u0101\3\2\2\2\u0514\u0515\7(\2\2\u0515\u0516\5\u010e\u0088"+
		"\2\u0516\u0103\3\2\2\2\u0517\u0518\7\67\2\2\u0518\u0519\7\u00be\2\2\u0519"+
		"\u051a\5\u014a\u00a6\2\u051a\u051b\7\u00bf\2\2\u051b\u0105\3\2\2\2\u051c"+
		"\u0521\5\u0136\u009c\2\u051d\u051f\7\3\2\2\u051e\u051d\3\2\2\2\u051e\u051f"+
		"\3\2\2\2\u051f\u0520\3\2\2\2\u0520\u0522\5> \2\u0521\u051e\3\2\2\2\u0521"+
		"\u0522\3\2\2\2\u0522\u0527\3\2\2\2\u0523\u0524\7\u00be\2\2\u0524\u0525"+
		"\5\u0108\u0085\2\u0525\u0526\7\u00bf\2\2\u0526\u0528\3\2\2\2\u0527\u0523"+
		"\3\2\2\2\u0527\u0528\3\2\2\2\u0528\u0535\3\2\2\2\u0529\u052b\5\u010a\u0086"+
		"\2\u052a\u052c\7\3\2\2\u052b\u052a\3\2\2\2\u052b\u052c\3\2\2\2\u052c\u052d"+
		"\3\2\2\2\u052d\u0532\5> \2\u052e\u052f\7\u00be\2\2\u052f\u0530\5\u0108"+
		"\u0085\2\u0530\u0531\7\u00bf\2\2\u0531\u0533\3\2\2\2\u0532\u052e\3\2\2"+
		"\2\u0532\u0533\3\2\2\2\u0533\u0535\3\2\2\2\u0534\u051c\3\2\2\2\u0534\u0529"+
		"\3\2\2\2\u0535\u0107\3\2\2\2\u0536\u053b\5> \2\u0537\u0538\7\u00b7\2\2"+
		"\u0538\u053a\5> \2\u0539\u0537\3\2\2\2\u053a\u053d\3\2\2\2\u053b\u0539"+
		"\3\2\2\2\u053b\u053c\3\2\2\2\u053c\u0109\3\2\2\2\u053d\u053b\3\2\2\2\u053e"+
		"\u053f\5\u0150\u00a9\2\u053f\u010b\3\2\2\2\u0540\u0541\79\2\2\u0541\u0542"+
		"\5\u010e\u0088\2\u0542\u010d\3\2\2\2\u0543\u0544\5\u009eP\2\u0544\u010f"+
		"\3\2\2\2\u0545\u0546\7\27\2\2\u0546\u0547\7=\2\2\u0547\u0548\5\u0112\u008a"+
		"\2\u0548\u0111\3\2\2\2\u0549\u054e\5\u0114\u008b\2\u054a\u054b\7\u00b7"+
		"\2\2\u054b\u054d\5\u0114\u008b\2\u054c\u054a\3\2\2\2\u054d\u0550\3\2\2"+
		"\2\u054e\u054c\3\2\2\2\u054e\u054f\3\2\2\2\u054f\u0113\3\2\2\2\u0550\u054e"+
		"\3\2\2\2\u0551\u0556\5\u011a\u008e\2\u0552\u0556\5\u011c\u008f\2\u0553"+
		"\u0556\5\u011e\u0090\2\u0554\u0556\5\u0116\u008c\2\u0555\u0551\3\2\2\2"+
		"\u0555\u0552\3\2\2\2\u0555\u0553\3\2\2\2\u0555\u0554\3\2\2\2\u0556\u0115"+
		"\3\2\2\2\u0557\u055d\5\u00e2r\2\u0558\u0559\7\u00be\2\2\u0559\u055a\5"+
		"\u0122\u0092\2\u055a\u055b\7\u00bf\2\2\u055b\u055d\3\2\2\2\u055c\u0557"+
		"\3\2\2\2\u055c\u0558\3\2\2\2\u055d\u0117\3\2\2\2\u055e\u0563\5\u0116\u008c"+
		"\2\u055f\u0560\7\u00b7\2\2\u0560\u0562\5\u0116\u008c\2\u0561\u055f\3\2"+
		"\2\2\u0562\u0565\3\2\2\2\u0563\u0561\3\2\2\2\u0563\u0564\3\2\2\2\u0564"+
		"\u0119\3\2\2\2\u0565\u0563\3\2\2\2\u0566\u0567\7s\2\2\u0567\u0568\7\u00be"+
		"\2\2\u0568\u0569\5\u0118\u008d\2\u0569\u056a\7\u00bf\2\2\u056a\u011b\3"+
		"\2\2\2\u056b\u056c\7D\2\2\u056c\u056d\7\u00be\2\2\u056d\u056e\5\u0118"+
		"\u008d\2\u056e\u056f\7\u00bf\2\2\u056f\u011d\3\2\2\2\u0570\u0571\7\u00be"+
		"\2\2\u0571\u0572\7\u00bf\2\2\u0572\u011f\3\2\2\2\u0573\u0574\7\30\2\2"+
		"\u0574\u0575\5\u00c8e\2\u0575\u0121\3\2\2\2\u0576\u057b\5\u00e2r\2\u0577"+
		"\u0578\7\u00b7\2\2\u0578\u057a\5\u00e2r\2\u0579\u0577\3\2\2\2\u057a\u057d"+
		"\3\2\2\2\u057b\u0579\3\2\2\2\u057b\u057c\3\2\2\2\u057c\u0123\3\2\2\2\u057d"+
		"\u057b\3\2\2\2\u057e\u057f\5\u0126\u0094\2\u057f\u0125\3\2\2\2\u0580\u0583"+
		"\5\u0128\u0095\2\u0581\u0583\5\u00eex\2\u0582\u0580\3\2\2\2\u0582\u0581"+
		"\3\2\2\2\u0583\u0127\3\2\2\2\u0584\u058d\5\u012c\u0097\2\u0585\u0586\5"+
		"\u00eex\2\u0586\u0588\t\f\2\2\u0587\u0589\t\r\2\2\u0588\u0587\3\2\2\2"+
		"\u0588\u0589\3\2\2\2\u0589\u058a\3\2\2\2\u058a\u058b\5\u012a\u0096\2\u058b"+
		"\u058d\3\2\2\2\u058c\u0584\3\2\2\2\u058c\u0585\3\2\2\2\u058d\u0595\3\2"+
		"\2\2\u058e\u0590\t\f\2\2\u058f\u0591\t\r\2\2\u0590\u058f\3\2\2\2\u0590"+
		"\u0591\3\2\2\2\u0591\u0592\3\2\2\2\u0592\u0594\5\u012a\u0096\2\u0593\u058e"+
		"\3\2\2\2\u0594\u0597\3\2\2\2\u0595\u0593\3\2\2\2\u0595\u0596\3\2\2\2\u0596"+
		"\u0129\3\2\2\2\u0597\u0595\3\2\2\2\u0598\u059b\5\u012c\u0097\2\u0599\u059b"+
		"\5\u00eex\2\u059a\u0598\3\2\2\2\u059a\u0599\3\2\2\2\u059b\u012b\3\2\2"+
		"\2\u059c\u05a5\5\u0130\u0099\2\u059d\u059e\5\u00eex\2\u059e\u05a0\7\35"+
		"\2\2\u059f\u05a1\t\r\2\2\u05a0\u059f\3\2\2\2\u05a0\u05a1\3\2\2\2\u05a1"+
		"\u05a2\3\2\2\2\u05a2\u05a3\5\u012e\u0098\2\u05a3\u05a5\3\2\2\2\u05a4\u059c"+
		"\3\2\2\2\u05a4\u059d\3\2\2\2\u05a5\u05ad\3\2\2\2\u05a6\u05a8\7\35\2\2"+
		"\u05a7\u05a9\t\r\2\2\u05a8\u05a7\3\2\2\2\u05a8\u05a9\3\2\2\2\u05a9\u05aa"+
		"\3\2\2\2\u05aa\u05ac\5\u012e\u0098\2\u05ab\u05a6\3\2\2\2\u05ac\u05af\3"+
		"\2\2\2\u05ad\u05ab\3\2\2\2\u05ad\u05ae\3\2\2\2\u05ae\u012d\3\2\2\2\u05af"+
		"\u05ad\3\2\2\2\u05b0\u05b3\5\u0130\u0099\2\u05b1\u05b3\5\u00eex\2\u05b2"+
		"\u05b0\3\2\2\2\u05b2\u05b1\3\2\2\2\u05b3\u012f\3\2\2\2\u05b4\u05ba\5\u0132"+
		"\u009a\2\u05b5\u05b6\7\u00be\2\2\u05b6\u05b7\5\u0128\u0095\2\u05b7\u05b8"+
		"\7\u00bf\2\2\u05b8\u05ba\3\2\2\2\u05b9\u05b4\3\2\2\2\u05b9\u05b5\3\2\2"+
		"\2\u05ba\u0131\3\2\2\2\u05bb\u05be\5\u013a\u009e\2\u05bc\u05be\5\u0134"+
		"\u009b\2\u05bd\u05bb\3\2\2\2\u05bd\u05bc\3\2\2\2\u05be\u0133\3\2\2\2\u05bf"+
		"\u05c0\7\61\2\2\u05c0\u05c1\5\u0136\u009c\2\u05c1\u0135\3\2\2\2\u05c2"+
		"\u05c5\5\u0138\u009d\2\u05c3\u05c5\5> \2\u05c4\u05c2\3\2\2\2\u05c4\u05c3"+
		"\3\2\2\2\u05c5\u0137\3\2\2\2\u05c6\u05cd\5> \2\u05c7\u05c8\7\u00c5\2\2"+
		"\u05c8\u05cb\5> \2\u05c9\u05ca\7\u00c5\2\2\u05ca\u05cc\5> \2\u05cb\u05c9"+
		"\3\2\2\2\u05cb\u05cc\3\2\2\2\u05cc\u05ce\3\2\2\2\u05cd\u05c7\3\2\2\2\u05cd"+
		"\u05ce\3\2\2\2\u05ce\u0139\3\2\2\2\u05cf\u05d1\7.\2\2\u05d0\u05d2\5\u0144"+
		"\u00a3\2\u05d1\u05d0\3\2\2\2\u05d1\u05d2\3\2\2\2\u05d2\u05d3\3\2\2\2\u05d3"+
		"\u05d5\5\u013c\u009f\2\u05d4\u05d6\5\u00e6t\2\u05d5\u05d4\3\2\2\2\u05d5"+
		"\u05d6\3\2\2\2\u05d6\u013b\3\2\2\2\u05d7\u05dc\5\u013e\u00a0\2\u05d8\u05d9"+
		"\7\u00b7\2\2\u05d9\u05db\5\u013e\u00a0\2\u05da\u05d8\3\2\2\2\u05db\u05de"+
		"\3\2\2\2\u05dc\u05da\3\2\2\2\u05dc\u05dd\3\2\2\2\u05dd\u013d\3\2\2\2\u05de"+
		"\u05dc\3\2\2\2\u05df\u05e2\5\u0140\u00a1\2\u05e0\u05e2\5\u0142\u00a2\2"+
		"\u05e1\u05df\3\2\2\2\u05e1\u05e0\3\2\2\2\u05e2\u013f\3\2\2\2\u05e3\u05e5"+
		"\5\u009eP\2\u05e4\u05e6\5\u0148\u00a5\2\u05e5\u05e4\3\2\2\2\u05e5\u05e6"+
		"\3\2\2\2\u05e6\u0141\3\2\2\2\u05e7\u05e8\7\u00ce\2\2\u05e8\u05ea\7\u00c5"+
		"\2\2\u05e9\u05e7\3\2\2\2\u05e9\u05ea\3\2\2\2\u05ea\u05eb\3\2\2\2\u05eb"+
		"\u05ec\7\u00c2\2\2\u05ec\u0143\3\2\2\2\u05ed\u05ee\t\r\2\2\u05ee\u0145"+
		"\3\2\2\2\u05ef\u05f0\5> \2\u05f0\u05f1\7\u00c5\2\2\u05f1\u05f3\3\2\2\2"+
		"\u05f2\u05ef\3\2\2\2\u05f2\u05f3\3\2\2\2\u05f3\u05f4\3\2\2\2\u05f4\u05f5"+
		"\5> \2\u05f5\u0147\3\2\2\2\u05f6\u05f8\7\3\2\2\u05f7\u05f6\3\2\2\2\u05f7"+
		"\u05f8\3\2\2\2\u05f8\u05f9\3\2\2\2\u05f9\u05fa\5> \2\u05fa\u0149\3\2\2"+
		"\2\u05fb\u0600\5\u0146\u00a4\2\u05fc\u05fd\7\u00b7\2\2\u05fd\u05ff\5\u0146"+
		"\u00a4\2\u05fe\u05fc\3\2\2\2\u05ff\u0602\3\2\2\2\u0600\u05fe\3\2\2\2\u0600"+
		"\u0601\3\2\2\2\u0601\u014b\3\2\2\2\u0602\u0600\3\2\2\2\u0603\u0604\5\u0152"+
		"\u00aa\2\u0604\u014d\3\2\2\2\u0605\u0606\5\u0152\u00aa\2\u0606\u014f\3"+
		"\2\2\2\u0607\u0608\5\u0152\u00aa\2\u0608\u0151\3\2\2\2\u0609\u060a\7\u00be"+
		"\2\2\u060a\u060b\5\u0124\u0093\2\u060b\u060c\7\u00bf\2\2\u060c\u0153\3"+
		"\2\2\2\u060d\u0614\5\u0156\u00ac\2\u060e\u0614\5\u015a\u00ae\2\u060f\u0614"+
		"\5\u015e\u00b0\2\u0610\u0614\5\u0164\u00b3\2\u0611\u0614\5\u016c\u00b7"+
		"\2\u0612\u0614\5\u0176\u00bc\2\u0613\u060d\3\2\2\2\u0613\u060e\3\2\2\2"+
		"\u0613\u060f\3\2\2\2\u0613\u0610\3\2\2\2\u0613\u0611\3\2\2\2\u0613\u0612"+
		"\3\2\2\2\u0614\u0155\3\2\2\2\u0615\u0616\5\u00e2r\2\u0616\u0617\5\u0158"+
		"\u00ad\2\u0617\u0618\5\u00e2r\2\u0618\u0157\3\2\2\2\u0619\u061a\t\16\2"+
		"\2\u061a\u0159\3\2\2\2\u061b\u061c\5\u00e2r\2\u061c\u061d\5\u015c\u00af"+
		"\2\u061d\u015b\3\2\2\2\u061e\u0620\7&\2\2\u061f\u061e\3\2\2\2\u061f\u0620"+
		"\3\2\2\2\u0620\u0621\3\2\2\2\u0621\u0623\7<\2\2\u0622\u0624\t\17\2\2\u0623"+
		"\u0622\3\2\2\2\u0623\u0624\3\2\2\2\u0624\u0625\3\2\2\2\u0625\u0626\5\u00e2"+
		"r\2\u0626\u0627\7\5\2\2\u0627\u0628\5\u00e2r\2\u0628\u015d\3\2\2\2\u0629"+
		"\u062b\5\u00a2R\2\u062a\u062c\7&\2\2\u062b\u062a\3\2\2\2\u062b\u062c\3"+
		"\2\2\2\u062c\u062d\3\2\2\2\u062d\u062e\7\33\2\2\u062e\u062f\5\u0160\u00b1"+
		"\2\u062f\u015f\3\2\2\2\u0630\u0636\5\u0150\u00a9\2\u0631\u0632\7\u00be"+
		"\2\2\u0632\u0633\5\u0162\u00b2\2\u0633\u0634\7\u00bf\2\2\u0634\u0636\3"+
		"\2\2\2\u0635\u0630\3\2\2\2\u0635\u0631\3\2\2\2\u0636\u0161\3\2\2\2\u0637"+
		"\u063c\5\u00dco\2\u0638\u0639\7\u00b7\2\2\u0639\u063b\5\u00dco\2\u063a"+
		"\u0638\3\2\2\2\u063b\u063e\3\2\2\2\u063c\u063a\3\2\2\2\u063c\u063d\3\2"+
		"\2\2\u063d\u0163\3\2\2\2\u063e\u063c\3\2\2\2\u063f\u0640\5\u00e2r\2\u0640"+
		"\u0641\5\u0166\u00b4\2\u0641\u0642\7\u00cf\2\2\u0642\u0165\3\2\2\2\u0643"+
		"\u0645\7&\2\2\u0644\u0643\3\2\2\2\u0644\u0645\3\2\2\2\u0645\u0646\3\2"+
		"\2\2\u0646\u0649\5\u0168\u00b5\2\u0647\u0649\5\u016a\u00b6\2\u0648\u0644"+
		"\3\2\2\2\u0648\u0647\3\2\2\2\u0649\u0167\3\2\2\2\u064a\u0651\7#\2\2\u064b"+
		"\u0651\7\32\2\2\u064c\u064d\7v\2\2\u064d\u0651\7\u0081\2\2\u064e\u0651"+
		"\7q\2\2\u064f\u0651\7r\2\2\u0650\u064a\3\2\2\2\u0650\u064b\3\2\2\2\u0650"+
		"\u064c\3\2\2\2\u0650\u064e\3\2\2\2\u0650\u064f\3\2\2\2\u0651\u0169\3\2"+
		"\2\2\u0652\u0653\t\20\2\2\u0653\u016b\3\2\2\2\u0654\u0655\5\u00e2r\2\u0655"+
		"\u0657\7\37\2\2\u0656\u0658\7&\2\2\u0657\u0656\3\2\2\2\u0657\u0658\3\2"+
		"\2\2\u0658\u0659\3\2\2\2\u0659\u065a\7\'\2\2\u065a\u016d\3\2\2\2\u065b"+
		"\u065c\5\u00a2R\2\u065c\u065d\5\u0158\u00ad\2\u065d\u065e\5\u0170\u00b9"+
		"\2\u065e\u065f\5\u0150\u00a9\2\u065f\u016f\3\2\2\2\u0660\u0663\5\u0172"+
		"\u00ba\2\u0661\u0663\5\u0174\u00bb\2\u0662\u0660\3\2\2\2\u0662\u0661\3"+
		"\2\2\2\u0663\u0171\3\2\2\2\u0664\u0665\7\4\2\2\u0665\u0173\3\2\2\2\u0666"+
		"\u0667\t\21\2\2\u0667\u0175\3\2\2\2\u0668\u066a\7&\2\2\u0669\u0668\3\2"+
		"\2\2\u0669\u066a\3\2\2\2\u066a\u066b\3\2\2\2\u066b\u066c\7M\2\2\u066c"+
		"\u066d\5\u0150\u00a9\2\u066d\u0177\3\2\2\2\u066e\u066f\7\66\2\2\u066f"+
		"\u0670\5\u0150\u00a9\2\u0670\u0179\3\2\2\2\u0671\u0674\5\u017c\u00bf\2"+
		"\u0672\u0674\7t\2\2\u0673\u0671\3\2\2\2\u0673\u0672\3\2\2\2\u0674\u017b"+
		"\3\2\2\2\u0675\u0676\t\22\2\2\u0676\u017d\3\2\2\2\u0677\u0678\t\23\2\2"+
		"\u0678\u017f\3\2\2\2\u0679\u067a\5\u0184\u00c3\2\u067a\u067c\7\u00be\2"+
		"\2\u067b\u067d\5\u0186\u00c4\2\u067c\u067b\3\2\2\2\u067c\u067d\3\2\2\2"+
		"\u067d\u067e\3\2\2\2\u067e\u067f\7\u00bf\2\2\u067f\u0181\3\2\2\2\u0680"+
		"\u0681\t\24\2\2\u0681\u0183\3\2\2\2\u0682\u0685\5> \2\u0683\u0685\5\u0182"+
		"\u00c2\2\u0684\u0682\3\2\2\2\u0684\u0683\3\2\2\2\u0685\u0185\3\2\2\2\u0686"+
		"\u068b\5\u009eP\2\u0687\u0688\7\u00b7\2\2\u0688\u068a\5\u009eP\2\u0689"+
		"\u0687\3\2\2\2\u068a\u068d\3\2\2\2\u068b\u0689\3\2\2\2\u068b\u068c\3\2"+
		"\2\2\u068c\u0187\3\2\2\2\u068d\u068b\3\2\2\2\u068e\u068f\7+\2\2\u068f"+
		"\u0690\7=\2\2\u0690\u0691\5\u018a\u00c6\2\u0691\u0189\3\2\2\2\u0692\u0697"+
		"\5\u018c\u00c7\2\u0693\u0694\7\u00b7\2\2\u0694\u0696\5\u018c\u00c7\2\u0695"+
		"\u0693\3\2\2\2\u0696\u0699\3\2\2\2\u0697\u0695\3\2\2\2\u0697\u0698\3\2"+
		"\2\2\u0698\u018b\3\2\2\2\u0699\u0697\3\2\2\2\u069a\u069c\5\u00e2r\2\u069b"+
		"\u069d\5\u018e\u00c8\2\u069c\u069b\3\2\2\2\u069c\u069d\3\2\2\2\u069d\u069f"+
		"\3\2\2\2\u069e\u06a0\5\u0192\u00ca\2\u069f\u069e\3\2\2\2\u069f\u06a0\3"+
		"\2\2\2\u06a0\u018d\3\2\2\2\u06a1\u06a2\t\25\2\2\u06a2\u018f\3\2\2\2\u06a3"+
		"\u06a4\7$\2\2\u06a4\u06a5\5\u00a2R\2\u06a5\u0191\3\2\2\2\u06a6\u06a7\7"+
		"\'\2\2\u06a7\u06ab\7Q\2\2\u06a8\u06a9\7\'\2\2\u06a9\u06ab\7\\\2\2\u06aa"+
		"\u06a6\3\2\2\2\u06aa\u06a8\3\2\2\2\u06ab\u0193\3\2\2\2\u06ac\u06ae\7X"+
		"\2\2\u06ad\u06af\7j\2\2\u06ae\u06ad\3\2\2\2\u06ae\u06af\3\2\2\2\u06af"+
		"\u06b0\3\2\2\2\u06b0\u06b1\7\36\2\2\u06b1\u06b6\5\u0138\u009d\2\u06b2"+
		"\u06b3\7\u00be\2\2\u06b3\u06b4\5\u0108\u0085\2\u06b4\u06b5\7\u00bf\2\2"+
		"\u06b5\u06b7\3\2\2\2\u06b6\u06b2\3\2\2\2\u06b6\u06b7\3\2\2\2\u06b7\u06b8"+
		"\3\2\2\2\u06b8\u06b9\5\u0124\u0093\2\u06b9\u06ca\3\2\2\2\u06ba\u06bc\7"+
		"X\2\2\u06bb\u06bd\7j\2\2\u06bc\u06bb\3\2\2\2\u06bc\u06bd\3\2\2\2\u06bd"+
		"\u06be\3\2\2\2\u06be\u06bf\7\36\2\2\u06bf\u06c0\7_\2\2\u06c0\u06c6\7\u00cf"+
		"\2\2\u06c1\u06c2\7\67\2\2\u06c2\u06c4\5> \2\u06c3\u06c5\5\30\r\2\u06c4"+
		"\u06c3\3\2\2\2\u06c4\u06c5\3\2\2\2\u06c5\u06c7\3\2\2\2\u06c6\u06c1\3\2"+
		"\2\2\u06c6\u06c7\3\2\2\2\u06c7\u06c8\3\2\2\2\u06c8\u06ca\5\u0124\u0093"+
		"\2\u06c9\u06ac\3\2\2\2\u06c9\u06ba\3\2\2\2\u06ca\u0195\3\2\2\2\u00c2\u0198"+
		"\u019c\u01a5\u01ad\u01b1\u01b8\u01be\u01c5\u01c9\u01cd\u01d1\u01d5\u01df"+
		"\u01e2\u01ed\u01f0\u01f3\u01f7\u01fe\u0201\u0204\u0209\u0211\u0222\u0237"+
		"\u0248\u0255\u0259\u025b\u0268\u026f\u0287\u028e\u029f\u02a3\u02a9\u02ae"+
		"\u02b3\u02cb\u02d1\u02d5\u02da\u02df\u02e3\u02e6\u02ef\u02f4\u02f8\u02fe"+
		"\u0304\u0309\u030d\u030f\u0313\u0317\u0319\u031d\u0321\u0325\u0329\u0334"+
		"\u0338\u0340\u034a\u035b\u035f\u0363\u0368\u036a\u036e\u0373\u0377\u0379"+
		"\u037d\u038a\u0391\u039d\u039f\u03a4\u03c6\u03ca\u03ce\u03d5\u03d8\u03e0"+
		"\u03e3\u03f6\u0406\u040b\u0412\u041a\u041e\u0428\u0432\u0436\u0446\u044c"+
		"\u0455\u045c\u0466\u0469\u046c\u0473\u047e\u0486\u048c\u0490\u0494\u049c"+
		"\u04a0\u04a8\u04b0\u04b4\u04b8\u04bb\u04be\u04c1\u04c4\u04ce\u04d3\u04d9"+
		"\u04df\u04e7\u04ee\u04f5\u04fd\u0508\u050c\u0512\u051e\u0521\u0527\u052b"+
		"\u0532\u0534\u053b\u054e\u0555\u055c\u0563\u057b\u0582\u0588\u058c\u0590"+
		"\u0595\u059a\u05a0\u05a4\u05a8\u05ad\u05b2\u05b9\u05bd\u05c4\u05cb\u05cd"+
		"\u05d1\u05d5\u05dc\u05e1\u05e5\u05e9\u05f2\u05f7\u0600\u0613\u061f\u0623"+
		"\u062b\u0635\u063c\u0644\u0648\u0650\u0657\u0662\u0669\u0673\u067c\u0684"+
		"\u068b\u0697\u069c\u069f\u06aa\u06ae\u06b6\u06bc\u06c4\u06c6\u06c9";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}