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
		FUNCTION=30, ISODOW=113, OVERWRITE=129, ROW=60, PRECISION=132, ILIKE=35, 
		Character_String_Literal=230, NOT=51, EXCEPT=24, BYTEA=195, CHARACTER=86, 
		STATEMENT=66, MONTH=126, BlockComment=227, VARBIT=165, CREATE=13, STDDEV_POP=142, 
		USING=77, NOT_EQUAL=208, TIMEZONE_MINUTE=150, VERTICAL_BAR=222, VARIADIC=78, 
		TIMESTAMPTZ=190, REGEXP=136, GEQ=212, STDDEV_SAMP=143, DIVIDE=218, BLOB=194, 
		ASC=7, GROUPING=107, SUBPARTITION=144, ELSE=23, NUMBER=225, BOOL=163, 
		TRAILING=70, SEMI_COLON=205, INT=172, RLIKE=137, LEADING=46, TABLESPACE=146, 
		MILLISECONDS=123, REAL=177, GROUP=32, INTERSECT=40, OUT=56, REAL_NUMBER=226, 
		TRIM=151, LEFT_PAREN=213, LOCATION=118, END=22, CONSTRAINT=12, TIMEZONE_HOUR=149, 
		CAST_EXPRESSION=201, ISOYEAR=114, NCHAR=184, EXECUTE=25, TABLE=68, VARCHAR=183, 
		MICROSECONDS=121, VERSION=158, FLOAT=178, ASYMMETRIC=6, SUM=145, Space=231, 
		INOUT=42, AS=2, TIME=187, RIGHT_PAREN=214, THEN=69, MAXVALUE=120, AVG=82, 
		REPLACE=61, LEFT=47, TRUNCATE=73, ZONE=161, COLUMN=89, PLUS=215, EXISTS=100, 
		NVARCHAR=185, Not_Similar_To=198, LIKE=48, INTEGER=173, OUTER=55, BY=84, 
		DEFERRABLE=16, TO=152, RIGHT=62, SET=140, HAVING=33, MIN=124, MINUS=216, 
		TEXT=191, HOUR=109, CONCATENATION_OPERATOR=207, UNION=74, COLON=204, SCHEMA=63, 
		DECIMAL=181, DROP=97, BIGINT=174, WHEN=79, BIT=164, NATURAL=50, FORMAT=105, 
		BETWEEN=83, EXTENSION=26, FIRST=104, CAST=11, EXTERNAL=101, WEEK=159, 
		DOUBLE_QUOTE=224, VARYING=157, TRIGGER=71, CASE=10, INT8=169, CHAR=182, 
		DAY=92, COUNT=90, INT2=167, INT1=166, Identifier=229, INT4=168, QUOTE=223, 
		MODULAR=219, FULL=29, QUARTER=134, THAN=147, INSERT=111, INTERSECTION=112, 
		LESS=116, BOTH=9, TINYINT=170, Similar_To_Case_Insensitive=199, DOUBLE=179, 
		SYMMETRIC=67, EACH=21, LAST=115, SELECT=64, INTO=41, UNIQUE=75, COALESCE=88, 
		SECOND=139, EPOCH=98, ROLLUP=138, NULL=52, EVERY=99, ON=54, DELETE=18, 
		INET4=196, NUMERIC=180, OF=53, LIST=117, UNDERLINE=221, Not_Similar_To_Case_Insensitive=200, 
		CUBE=91, NATIONAL=127, OR=57, VAR_POP=156, FILTER=103, FROM=31, COLLECT=87, 
		FALSE=27, DISTINCT=20, TIMESTAMP=189, DEC=93, WHERE=80, NULLIF=128, VAR_SAMP=155, 
		TIMETZ=188, INNER=39, YEAR=160, ORDER=58, TIMEZONE=148, LIMIT=49, DECADE=94, 
		GTH=211, White_Space=232, UPDATE=76, MAX=119, LineComment=228, DEFERRED=17, 
		FOR=28, FLOAT4=175, FLOAT8=176, AND=4, CROSS=14, Similar_To=197, IF=34, 
		INDEX=110, BOOLEAN=162, IN=37, UNKNOWN=153, MULTIPLY=217, COMMA=206, IS=44, 
		PARTITION=130, PARTITIONS=131, SOME=65, EQUAL=203, ALL=3, DOT=220, EXTRACT=102, 
		CENTURY=85, DOW=95, WITH=81, DOY=96, INITIALLY=38, FUSION=106, VARBINARY=193, 
		DEFAULT=15, VALUES=154, HASH=108, MILLENNIUM=122, RANGE=135, BEFORE=8, 
		PURGE=133, AFTER=1, INSTEAD=43, TRUE=72, PROCEDURE=59, JOIN=45, SIMILAR=141, 
		LTH=209, ANY=5, BAD=233, ASSIGN=202, IMMEDIATE=36, DESC=19, BINARY=192, 
		MINUTE=125, DATE=186, LEQ=210, SMALLINT=171;
	public static final String[] tokenNames = {
		"<INVALID>", "AFTER", "AS", "ALL", "AND", "ANY", "ASYMMETRIC", "ASC", 
		"BEFORE", "BOTH", "CASE", "CAST", "CONSTRAINT", "CREATE", "CROSS", "DEFAULT", 
		"DEFERRABLE", "DEFERRED", "DELETE", "DESC", "DISTINCT", "EACH", "END", 
		"ELSE", "EXCEPT", "EXECUTE", "EXTENSION", "FALSE", "FOR", "FULL", "FUNCTION", 
		"FROM", "GROUP", "HAVING", "IF", "ILIKE", "IMMEDIATE", "IN", "INITIALLY", 
		"INNER", "INTERSECT", "INTO", "INOUT", "INSTEAD", "IS", "JOIN", "LEADING", 
		"LEFT", "LIKE", "LIMIT", "NATURAL", "NOT", "NULL", "OF", "ON", "OUTER", 
		"OUT", "OR", "ORDER", "PROCEDURE", "ROW", "REPLACE", "RIGHT", "SCHEMA", 
		"SELECT", "SOME", "STATEMENT", "SYMMETRIC", "TABLE", "THEN", "TRAILING", 
		"TRIGGER", "TRUE", "TRUNCATE", "UNION", "UNIQUE", "UPDATE", "USING", "VARIADIC", 
		"WHEN", "WHERE", "WITH", "AVG", "BETWEEN", "BY", "CENTURY", "CHARACTER", 
		"COLLECT", "COALESCE", "COLUMN", "COUNT", "CUBE", "DAY", "DEC", "DECADE", 
		"DOW", "DOY", "DROP", "EPOCH", "EVERY", "EXISTS", "EXTERNAL", "EXTRACT", 
		"FILTER", "FIRST", "FORMAT", "FUSION", "GROUPING", "HASH", "HOUR", "INDEX", 
		"INSERT", "INTERSECTION", "ISODOW", "ISOYEAR", "LAST", "LESS", "LIST", 
		"LOCATION", "MAX", "MAXVALUE", "MICROSECONDS", "MILLENNIUM", "MILLISECONDS", 
		"MIN", "MINUTE", "MONTH", "NATIONAL", "NULLIF", "OVERWRITE", "PARTITION", 
		"PARTITIONS", "PRECISION", "PURGE", "QUARTER", "RANGE", "REGEXP", "RLIKE", 
		"ROLLUP", "SECOND", "SET", "SIMILAR", "STDDEV_POP", "STDDEV_SAMP", "SUBPARTITION", 
		"SUM", "TABLESPACE", "THAN", "TIMEZONE", "TIMEZONE_HOUR", "TIMEZONE_MINUTE", 
		"TRIM", "TO", "UNKNOWN", "VALUES", "VAR_SAMP", "VAR_POP", "VARYING", "VERSION", 
		"WEEK", "YEAR", "ZONE", "BOOLEAN", "BOOL", "BIT", "VARBIT", "INT1", "INT2", 
		"INT4", "INT8", "TINYINT", "SMALLINT", "INT", "INTEGER", "BIGINT", "FLOAT4", 
		"FLOAT8", "REAL", "FLOAT", "DOUBLE", "NUMERIC", "DECIMAL", "CHAR", "VARCHAR", 
		"NCHAR", "NVARCHAR", "DATE", "TIME", "TIMETZ", "TIMESTAMP", "TIMESTAMPTZ", 
		"TEXT", "BINARY", "VARBINARY", "BLOB", "BYTEA", "INET4", "'~'", "'!~'", 
		"'~*'", "'!~*'", "CAST_EXPRESSION", "':='", "'='", "':'", "';'", "','", 
		"CONCATENATION_OPERATOR", "NOT_EQUAL", "'<'", "'<='", "'>'", "'>='", "'('", 
		"')'", "'+'", "'-'", "'*'", "'/'", "'%'", "'.'", "'_'", "'|'", "'''", 
		"'\"'", "NUMBER", "REAL_NUMBER", "BlockComment", "LineComment", "Identifier", 
		"Character_String_Literal", "' '", "White_Space", "BAD"
	};
	public static final int
		RULE_sql = 0, RULE_statement = 1, RULE_data_statement = 2, RULE_data_change_statement = 3, 
		RULE_schema_statement = 4, RULE_index_statement = 5, RULE_create_extension_statement = 6, 
		RULE_create_trigger_statement = 7, RULE_argmode = 8, RULE_create_table_statement = 9, 
		RULE_table_elements = 10, RULE_field_element = 11, RULE_field_type = 12, 
		RULE_param_clause = 13, RULE_param = 14, RULE_method_specifier = 15, RULE_table_space_specifier = 16, 
		RULE_table_space_name = 17, RULE_table_partitioning_clauses = 18, RULE_range_partitions = 19, 
		RULE_range_value_clause_list = 20, RULE_range_value_clause = 21, RULE_hash_partitions = 22, 
		RULE_individual_hash_partitions = 23, RULE_individual_hash_partition = 24, 
		RULE_hash_partitions_by_quantity = 25, RULE_list_partitions = 26, RULE_list_value_clause_list = 27, 
		RULE_list_value_partition = 28, RULE_column_partitions = 29, RULE_partition_name = 30, 
		RULE_drop_table_statement = 31, RULE_identifier = 32, RULE_nonreserved_keywords = 33, 
		RULE_unsigned_literal = 34, RULE_general_literal = 35, RULE_datetime_literal = 36, 
		RULE_time_literal = 37, RULE_timestamp_literal = 38, RULE_date_literal = 39, 
		RULE_boolean_literal = 40, RULE_data_type = 41, RULE_predefined_type = 42, 
		RULE_network_type = 43, RULE_character_string_type = 44, RULE_type_length = 45, 
		RULE_national_character_string_type = 46, RULE_binary_large_object_string_type = 47, 
		RULE_numeric_type = 48, RULE_exact_numeric_type = 49, RULE_approximate_numeric_type = 50, 
		RULE_precision_param = 51, RULE_boolean_type = 52, RULE_datetime_type = 53, 
		RULE_bit_type = 54, RULE_binary_type = 55, RULE_value_expression_primary = 56, 
		RULE_parenthesized_value_expression = 57, RULE_nonparenthesized_value_expression_primary = 58, 
		RULE_unsigned_value_specification = 59, RULE_unsigned_numeric_literal = 60, 
		RULE_signed_numerical_literal = 61, RULE_set_function_specification = 62, 
		RULE_aggregate_function = 63, RULE_general_set_function = 64, RULE_set_function_type = 65, 
		RULE_filter_clause = 66, RULE_grouping_operation = 67, RULE_case_expression = 68, 
		RULE_case_abbreviation = 69, RULE_case_specification = 70, RULE_simple_case = 71, 
		RULE_searched_case = 72, RULE_simple_when_clause = 73, RULE_searched_when_clause = 74, 
		RULE_else_clause = 75, RULE_result = 76, RULE_cast_specification = 77, 
		RULE_cast_operand = 78, RULE_cast_target = 79, RULE_value_expression = 80, 
		RULE_common_value_expression = 81, RULE_numeric_value_expression = 82, 
		RULE_term = 83, RULE_factor = 84, RULE_array = 85, RULE_numeric_primary = 86, 
		RULE_sign = 87, RULE_numeric_value_function = 88, RULE_extract_expression = 89, 
		RULE_extract_field = 90, RULE_time_zone_field = 91, RULE_extract_source = 92, 
		RULE_string_value_expression = 93, RULE_character_value_expression = 94, 
		RULE_character_factor = 95, RULE_character_primary = 96, RULE_string_value_function = 97, 
		RULE_trim_function = 98, RULE_trim_operands = 99, RULE_trim_specification = 100, 
		RULE_boolean_value_expression = 101, RULE_or_predicate = 102, RULE_and_predicate = 103, 
		RULE_boolean_factor = 104, RULE_boolean_test = 105, RULE_is_clause = 106, 
		RULE_truth_value = 107, RULE_boolean_primary = 108, RULE_boolean_predicand = 109, 
		RULE_parenthesized_boolean_value_expression = 110, RULE_row_value_expression = 111, 
		RULE_row_value_special_case = 112, RULE_explicit_row_value_constructor = 113, 
		RULE_row_value_predicand = 114, RULE_row_value_constructor_predicand = 115, 
		RULE_table_expression = 116, RULE_from_clause = 117, RULE_table_reference_list = 118, 
		RULE_table_reference = 119, RULE_joined_table = 120, RULE_joined_table_primary = 121, 
		RULE_cross_join = 122, RULE_qualified_join = 123, RULE_natural_join = 124, 
		RULE_union_join = 125, RULE_join_type = 126, RULE_outer_join_type = 127, 
		RULE_outer_join_type_part2 = 128, RULE_join_specification = 129, RULE_join_condition = 130, 
		RULE_named_columns_join = 131, RULE_table_primary = 132, RULE_column_name_list = 133, 
		RULE_derived_table = 134, RULE_where_clause = 135, RULE_search_condition = 136, 
		RULE_groupby_clause = 137, RULE_grouping_element_list = 138, RULE_grouping_element = 139, 
		RULE_ordinary_grouping_set = 140, RULE_ordinary_grouping_set_list = 141, 
		RULE_rollup_list = 142, RULE_cube_list = 143, RULE_empty_grouping_set = 144, 
		RULE_having_clause = 145, RULE_row_value_predicand_list = 146, RULE_query_expression = 147, 
		RULE_query_expression_body = 148, RULE_non_join_query_expression = 149, 
		RULE_query_term = 150, RULE_non_join_query_term = 151, RULE_query_primary = 152, 
		RULE_non_join_query_primary = 153, RULE_simple_table = 154, RULE_explicit_table = 155, 
		RULE_table_or_query_name = 156, RULE_table_name = 157, RULE_query_specification = 158, 
		RULE_select_list = 159, RULE_select_sublist = 160, RULE_derived_column = 161, 
		RULE_qualified_asterisk = 162, RULE_set_qualifier = 163, RULE_column_reference = 164, 
		RULE_as_clause = 165, RULE_column_reference_list = 166, RULE_scalar_subquery = 167, 
		RULE_row_subquery = 168, RULE_table_subquery = 169, RULE_subquery = 170, 
		RULE_predicate = 171, RULE_comparison_predicate = 172, RULE_comp_op = 173, 
		RULE_between_predicate = 174, RULE_between_predicate_part_2 = 175, RULE_in_predicate = 176, 
		RULE_in_predicate_value = 177, RULE_in_value_list = 178, RULE_pattern_matching_predicate = 179, 
		RULE_pattern_matcher = 180, RULE_negativable_matcher = 181, RULE_regex_matcher = 182, 
		RULE_null_predicate = 183, RULE_quantified_comparison_predicate = 184, 
		RULE_quantifier = 185, RULE_all = 186, RULE_some = 187, RULE_exists_predicate = 188, 
		RULE_unique_predicate = 189, RULE_primary_datetime_field = 190, RULE_non_second_primary_datetime_field = 191, 
		RULE_extended_datetime_field = 192, RULE_routine_invocation = 193, RULE_function_names_for_reserved_words = 194, 
		RULE_function_name = 195, RULE_sql_argument_list = 196, RULE_orderby_clause = 197, 
		RULE_sort_specifier_list = 198, RULE_sort_specifier = 199, RULE_order_specification = 200, 
		RULE_limit_clause = 201, RULE_null_ordering = 202, RULE_insert_statement = 203;
	public static final String[] ruleNames = {
		"sql", "statement", "data_statement", "data_change_statement", "schema_statement", 
		"index_statement", "create_extension_statement", "create_trigger_statement", 
		"argmode", "create_table_statement", "table_elements", "field_element", 
		"field_type", "param_clause", "param", "method_specifier", "table_space_specifier", 
		"table_space_name", "table_partitioning_clauses", "range_partitions", 
		"range_value_clause_list", "range_value_clause", "hash_partitions", "individual_hash_partitions", 
		"individual_hash_partition", "hash_partitions_by_quantity", "list_partitions", 
		"list_value_clause_list", "list_value_partition", "column_partitions", 
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
			setState(412); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(408); statement();
				setState(410);
				_la = _input.LA(1);
				if (_la==SEMI_COLON) {
					{
					setState(409); match(SEMI_COLON);
					}
				}

				}
				}
				setState(414); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==CREATE || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (SELECT - 64)) | (1L << (TABLE - 64)) | (1L << (AVG - 64)) | (1L << (BETWEEN - 64)) | (1L << (BY - 64)) | (1L << (CENTURY - 64)) | (1L << (CHARACTER - 64)) | (1L << (COLLECT - 64)) | (1L << (COALESCE - 64)) | (1L << (COLUMN - 64)) | (1L << (COUNT - 64)) | (1L << (CUBE - 64)) | (1L << (DAY - 64)) | (1L << (DEC - 64)) | (1L << (DECADE - 64)) | (1L << (DOW - 64)) | (1L << (DOY - 64)) | (1L << (DROP - 64)) | (1L << (EPOCH - 64)) | (1L << (EVERY - 64)) | (1L << (EXISTS - 64)) | (1L << (EXTERNAL - 64)) | (1L << (EXTRACT - 64)) | (1L << (FILTER - 64)) | (1L << (FIRST - 64)) | (1L << (FORMAT - 64)) | (1L << (FUSION - 64)) | (1L << (GROUPING - 64)) | (1L << (HASH - 64)) | (1L << (INDEX - 64)) | (1L << (INSERT - 64)) | (1L << (INTERSECTION - 64)) | (1L << (ISODOW - 64)) | (1L << (ISOYEAR - 64)) | (1L << (LAST - 64)) | (1L << (LESS - 64)) | (1L << (LIST - 64)) | (1L << (LOCATION - 64)) | (1L << (MAX - 64)) | (1L << (MAXVALUE - 64)) | (1L << (MICROSECONDS - 64)) | (1L << (MILLENNIUM - 64)) | (1L << (MILLISECONDS - 64)) | (1L << (MIN - 64)) | (1L << (MINUTE - 64)) | (1L << (MONTH - 64)) | (1L << (NATIONAL - 64)))) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (NULLIF - 128)) | (1L << (OVERWRITE - 128)) | (1L << (PARTITION - 128)) | (1L << (PARTITIONS - 128)) | (1L << (PRECISION - 128)) | (1L << (PURGE - 128)) | (1L << (QUARTER - 128)) | (1L << (RANGE - 128)) | (1L << (REGEXP - 128)) | (1L << (RLIKE - 128)) | (1L << (ROLLUP - 128)) | (1L << (SECOND - 128)) | (1L << (SET - 128)) | (1L << (SIMILAR - 128)) | (1L << (STDDEV_POP - 128)) | (1L << (STDDEV_SAMP - 128)) | (1L << (SUBPARTITION - 128)) | (1L << (SUM - 128)) | (1L << (TABLESPACE - 128)) | (1L << (THAN - 128)) | (1L << (TIMEZONE - 128)) | (1L << (TIMEZONE_HOUR - 128)) | (1L << (TIMEZONE_MINUTE - 128)) | (1L << (TRIM - 128)) | (1L << (TO - 128)) | (1L << (UNKNOWN - 128)) | (1L << (VALUES - 128)) | (1L << (VAR_SAMP - 128)) | (1L << (VAR_POP - 128)) | (1L << (VARYING - 128)) | (1L << (WEEK - 128)) | (1L << (YEAR - 128)) | (1L << (ZONE - 128)) | (1L << (BOOLEAN - 128)) | (1L << (BOOL - 128)) | (1L << (BIT - 128)) | (1L << (VARBIT - 128)) | (1L << (INT1 - 128)) | (1L << (INT2 - 128)) | (1L << (INT4 - 128)) | (1L << (INT8 - 128)) | (1L << (TINYINT - 128)) | (1L << (SMALLINT - 128)) | (1L << (INT - 128)) | (1L << (INTEGER - 128)) | (1L << (BIGINT - 128)) | (1L << (FLOAT4 - 128)) | (1L << (FLOAT8 - 128)) | (1L << (REAL - 128)) | (1L << (FLOAT - 128)) | (1L << (DOUBLE - 128)) | (1L << (NUMERIC - 128)) | (1L << (DECIMAL - 128)) | (1L << (CHAR - 128)) | (1L << (VARCHAR - 128)) | (1L << (NCHAR - 128)) | (1L << (NVARCHAR - 128)) | (1L << (DATE - 128)) | (1L << (TIME - 128)) | (1L << (TIMETZ - 128)) | (1L << (TIMESTAMP - 128)) | (1L << (TIMESTAMPTZ - 128)) | (1L << (TEXT - 128)))) != 0) || ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & ((1L << (VARBINARY - 193)) | (1L << (BLOB - 193)) | (1L << (BYTEA - 193)) | (1L << (INET4 - 193)) | (1L << (LEFT_PAREN - 193)) | (1L << (Identifier - 193)))) != 0) );
			setState(416); match(EOF);
			}
		}
		catch (RecognitionException re) {
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
			setState(423);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(418); data_statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(419); data_change_statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(420); schema_statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(421); index_statement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(422); create_extension_statement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
			setState(425); query_expression();
			}
		}
		catch (RecognitionException re) {
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
			setState(427); insert_statement();
			}
		}
		catch (RecognitionException re) {
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
			setState(431);
			switch (_input.LA(1)) {
			case CREATE:
				enterOuterAlt(_localctx, 1);
				{
				setState(429); create_table_statement();
				}
				break;
			case DROP:
				enterOuterAlt(_localctx, 2);
				{
				setState(430); drop_table_statement();
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
			setState(433); match(CREATE);
			setState(435);
			_la = _input.LA(1);
			if (_la==UNIQUE) {
				{
				setState(434); ((Index_statementContext)_localctx).u = match(UNIQUE);
				}
			}

			setState(437); match(INDEX);
			setState(438); ((Index_statementContext)_localctx).n = identifier();
			setState(439); match(ON);
			setState(440); ((Index_statementContext)_localctx).t = table_name();
			setState(442);
			_la = _input.LA(1);
			if (_la==USING) {
				{
				setState(441); ((Index_statementContext)_localctx).m = method_specifier();
				}
			}

			setState(444); match(LEFT_PAREN);
			setState(445); ((Index_statementContext)_localctx).s = sort_specifier_list();
			setState(446); match(RIGHT_PAREN);
			setState(448);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(447); ((Index_statementContext)_localctx).p = param_clause();
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
			setState(450); match(CREATE);
			setState(451); match(EXTENSION);
			setState(455);
			_la = _input.LA(1);
			if (_la==IF) {
				{
				setState(452); match(IF);
				setState(453); match(NOT);
				setState(454); match(EXISTS);
				}
			}

			setState(457); ((Create_extension_statementContext)_localctx).name = identifier();
			setState(459);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(458); match(WITH);
				}
			}

			setState(463);
			_la = _input.LA(1);
			if (_la==SCHEMA) {
				{
				setState(461); match(SCHEMA);
				setState(462); ((Create_extension_statementContext)_localctx).schema_name = identifier();
				}
			}

			setState(467);
			_la = _input.LA(1);
			if (_la==VERSION) {
				{
				setState(465); match(VERSION);
				setState(466); ((Create_extension_statementContext)_localctx).version = identifier();
				}
			}

			setState(471);
			_la = _input.LA(1);
			if (_la==FROM) {
				{
				setState(469); match(FROM);
				setState(470); ((Create_extension_statementContext)_localctx).old_version = identifier();
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
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public TerminalNode UPDATE() { return getToken(SQLParser.UPDATE, 0); }
		public List<Table_nameContext> table_name() {
			return getRuleContexts(Table_nameContext.class);
		}
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public TerminalNode IMMEDIATE() { return getToken(SQLParser.IMMEDIATE, 0); }
		public TerminalNode WHEN() { return getToken(SQLParser.WHEN, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public TerminalNode FROM() { return getToken(SQLParser.FROM, 0); }
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
		enterRule(_localctx, 14, RULE_create_trigger_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(473); match(CREATE);
			setState(475);
			_la = _input.LA(1);
			if (_la==CONSTRAINT) {
				{
				setState(474); match(CONSTRAINT);
				}
			}

			setState(477); match(TRIGGER);
			setState(478); ((Create_trigger_statementContext)_localctx).name = identifier();
			setState(483);
			switch (_input.LA(1)) {
			case BEFORE:
				{
				setState(479); match(BEFORE);
				}
				break;
			case INSTEAD:
				{
				{
				setState(480); match(INSTEAD);
				setState(481); match(OF);
				}
				}
				break;
			case AFTER:
				{
				setState(482); match(AFTER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(500);
			switch (_input.LA(1)) {
			case INSERT:
				{
				setState(485); match(INSERT);
				}
				break;
			case DELETE:
				{
				setState(486); match(DELETE);
				}
				break;
			case TRUNCATE:
				{
				setState(487); match(TRUNCATE);
				}
				break;
			case UPDATE:
				{
				setState(488); match(UPDATE);
				setState(498);
				_la = _input.LA(1);
				if (_la==OF) {
					{
					setState(489); match(OF);
					setState(494); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(490); ((Create_trigger_statementContext)_localctx).columnName = identifier();
						setState(492);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(491); match(COMMA);
							}
						}

						}
						}
						setState(496); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 82)) & ~0x3f) == 0 && ((1L << (_la - 82)) & ((1L << (AVG - 82)) | (1L << (BETWEEN - 82)) | (1L << (BY - 82)) | (1L << (CENTURY - 82)) | (1L << (CHARACTER - 82)) | (1L << (COLLECT - 82)) | (1L << (COALESCE - 82)) | (1L << (COLUMN - 82)) | (1L << (COUNT - 82)) | (1L << (CUBE - 82)) | (1L << (DAY - 82)) | (1L << (DEC - 82)) | (1L << (DECADE - 82)) | (1L << (DOW - 82)) | (1L << (DOY - 82)) | (1L << (DROP - 82)) | (1L << (EPOCH - 82)) | (1L << (EVERY - 82)) | (1L << (EXISTS - 82)) | (1L << (EXTERNAL - 82)) | (1L << (EXTRACT - 82)) | (1L << (FILTER - 82)) | (1L << (FIRST - 82)) | (1L << (FORMAT - 82)) | (1L << (FUSION - 82)) | (1L << (GROUPING - 82)) | (1L << (HASH - 82)) | (1L << (INDEX - 82)) | (1L << (INSERT - 82)) | (1L << (INTERSECTION - 82)) | (1L << (ISODOW - 82)) | (1L << (ISOYEAR - 82)) | (1L << (LAST - 82)) | (1L << (LESS - 82)) | (1L << (LIST - 82)) | (1L << (LOCATION - 82)) | (1L << (MAX - 82)) | (1L << (MAXVALUE - 82)) | (1L << (MICROSECONDS - 82)) | (1L << (MILLENNIUM - 82)) | (1L << (MILLISECONDS - 82)) | (1L << (MIN - 82)) | (1L << (MINUTE - 82)) | (1L << (MONTH - 82)) | (1L << (NATIONAL - 82)) | (1L << (NULLIF - 82)) | (1L << (OVERWRITE - 82)) | (1L << (PARTITION - 82)) | (1L << (PARTITIONS - 82)) | (1L << (PRECISION - 82)) | (1L << (PURGE - 82)) | (1L << (QUARTER - 82)) | (1L << (RANGE - 82)) | (1L << (REGEXP - 82)) | (1L << (RLIKE - 82)) | (1L << (ROLLUP - 82)) | (1L << (SECOND - 82)) | (1L << (SET - 82)) | (1L << (SIMILAR - 82)) | (1L << (STDDEV_POP - 82)) | (1L << (STDDEV_SAMP - 82)) | (1L << (SUBPARTITION - 82)) | (1L << (SUM - 82)))) != 0) || ((((_la - 146)) & ~0x3f) == 0 && ((1L << (_la - 146)) & ((1L << (TABLESPACE - 146)) | (1L << (THAN - 146)) | (1L << (TIMEZONE - 146)) | (1L << (TIMEZONE_HOUR - 146)) | (1L << (TIMEZONE_MINUTE - 146)) | (1L << (TRIM - 146)) | (1L << (TO - 146)) | (1L << (UNKNOWN - 146)) | (1L << (VALUES - 146)) | (1L << (VAR_SAMP - 146)) | (1L << (VAR_POP - 146)) | (1L << (VARYING - 146)) | (1L << (WEEK - 146)) | (1L << (YEAR - 146)) | (1L << (ZONE - 146)) | (1L << (BOOLEAN - 146)) | (1L << (BOOL - 146)) | (1L << (BIT - 146)) | (1L << (VARBIT - 146)) | (1L << (INT1 - 146)) | (1L << (INT2 - 146)) | (1L << (INT4 - 146)) | (1L << (INT8 - 146)) | (1L << (TINYINT - 146)) | (1L << (SMALLINT - 146)) | (1L << (INT - 146)) | (1L << (INTEGER - 146)) | (1L << (BIGINT - 146)) | (1L << (FLOAT4 - 146)) | (1L << (FLOAT8 - 146)) | (1L << (REAL - 146)) | (1L << (FLOAT - 146)) | (1L << (DOUBLE - 146)) | (1L << (NUMERIC - 146)) | (1L << (DECIMAL - 146)) | (1L << (CHAR - 146)) | (1L << (VARCHAR - 146)) | (1L << (NCHAR - 146)) | (1L << (NVARCHAR - 146)) | (1L << (DATE - 146)) | (1L << (TIME - 146)) | (1L << (TIMETZ - 146)) | (1L << (TIMESTAMP - 146)) | (1L << (TIMESTAMPTZ - 146)) | (1L << (TEXT - 146)) | (1L << (VARBINARY - 146)) | (1L << (BLOB - 146)) | (1L << (BYTEA - 146)) | (1L << (INET4 - 146)))) != 0) || _la==Identifier );
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(502); match(ON);
			setState(503); ((Create_trigger_statementContext)_localctx).tabl_name = table_name();
			setState(506);
			_la = _input.LA(1);
			if (_la==FROM) {
				{
				setState(504); match(FROM);
				setState(505); ((Create_trigger_statementContext)_localctx).referenced_table_name = table_name();
				}
			}

			setState(517);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(508); match(NOT);
				setState(509); match(DEFERRABLE);
				}
				break;
			case 2:
				{
				setState(511);
				_la = _input.LA(1);
				if (_la==DEFERRABLE) {
					{
					setState(510); match(DEFERRABLE);
					}
				}

				{
				setState(513); match(INITIALLY);
				setState(514); match(IMMEDIATE);
				}
				}
				break;
			case 3:
				{
				{
				setState(515); match(INITIALLY);
				setState(516); match(DEFERRED);
				}
				}
				break;
			}
			setState(525);
			switch (_input.LA(1)) {
			case FOR:
				{
				setState(519); match(FOR);
				setState(521);
				_la = _input.LA(1);
				if (_la==EACH) {
					{
					setState(520); match(EACH);
					}
				}

				setState(523); match(ROW);
				}
				break;
			case STATEMENT:
				{
				setState(524); match(STATEMENT);
				}
				break;
			case EXECUTE:
			case WHEN:
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(529);
			_la = _input.LA(1);
			if (_la==WHEN) {
				{
				setState(527); match(WHEN);
				{
				setState(528); boolean_value_expression();
				}
				}
			}

			setState(531); match(EXECUTE);
			setState(532); match(PROCEDURE);
			setState(533); ((Create_trigger_statementContext)_localctx).func_name = identifier();
			setState(534); match(LEFT_PAREN);
			setState(539);
			_la = _input.LA(1);
			if (((((_la - 82)) & ~0x3f) == 0 && ((1L << (_la - 82)) & ((1L << (AVG - 82)) | (1L << (BETWEEN - 82)) | (1L << (BY - 82)) | (1L << (CENTURY - 82)) | (1L << (CHARACTER - 82)) | (1L << (COLLECT - 82)) | (1L << (COALESCE - 82)) | (1L << (COLUMN - 82)) | (1L << (COUNT - 82)) | (1L << (CUBE - 82)) | (1L << (DAY - 82)) | (1L << (DEC - 82)) | (1L << (DECADE - 82)) | (1L << (DOW - 82)) | (1L << (DOY - 82)) | (1L << (DROP - 82)) | (1L << (EPOCH - 82)) | (1L << (EVERY - 82)) | (1L << (EXISTS - 82)) | (1L << (EXTERNAL - 82)) | (1L << (EXTRACT - 82)) | (1L << (FILTER - 82)) | (1L << (FIRST - 82)) | (1L << (FORMAT - 82)) | (1L << (FUSION - 82)) | (1L << (GROUPING - 82)) | (1L << (HASH - 82)) | (1L << (INDEX - 82)) | (1L << (INSERT - 82)) | (1L << (INTERSECTION - 82)) | (1L << (ISODOW - 82)) | (1L << (ISOYEAR - 82)) | (1L << (LAST - 82)) | (1L << (LESS - 82)) | (1L << (LIST - 82)) | (1L << (LOCATION - 82)) | (1L << (MAX - 82)) | (1L << (MAXVALUE - 82)) | (1L << (MICROSECONDS - 82)) | (1L << (MILLENNIUM - 82)) | (1L << (MILLISECONDS - 82)) | (1L << (MIN - 82)) | (1L << (MINUTE - 82)) | (1L << (MONTH - 82)) | (1L << (NATIONAL - 82)) | (1L << (NULLIF - 82)) | (1L << (OVERWRITE - 82)) | (1L << (PARTITION - 82)) | (1L << (PARTITIONS - 82)) | (1L << (PRECISION - 82)) | (1L << (PURGE - 82)) | (1L << (QUARTER - 82)) | (1L << (RANGE - 82)) | (1L << (REGEXP - 82)) | (1L << (RLIKE - 82)) | (1L << (ROLLUP - 82)) | (1L << (SECOND - 82)) | (1L << (SET - 82)) | (1L << (SIMILAR - 82)) | (1L << (STDDEV_POP - 82)) | (1L << (STDDEV_SAMP - 82)) | (1L << (SUBPARTITION - 82)) | (1L << (SUM - 82)))) != 0) || ((((_la - 146)) & ~0x3f) == 0 && ((1L << (_la - 146)) & ((1L << (TABLESPACE - 146)) | (1L << (THAN - 146)) | (1L << (TIMEZONE - 146)) | (1L << (TIMEZONE_HOUR - 146)) | (1L << (TIMEZONE_MINUTE - 146)) | (1L << (TRIM - 146)) | (1L << (TO - 146)) | (1L << (UNKNOWN - 146)) | (1L << (VALUES - 146)) | (1L << (VAR_SAMP - 146)) | (1L << (VAR_POP - 146)) | (1L << (VARYING - 146)) | (1L << (WEEK - 146)) | (1L << (YEAR - 146)) | (1L << (ZONE - 146)) | (1L << (BOOLEAN - 146)) | (1L << (BOOL - 146)) | (1L << (BIT - 146)) | (1L << (VARBIT - 146)) | (1L << (INT1 - 146)) | (1L << (INT2 - 146)) | (1L << (INT4 - 146)) | (1L << (INT8 - 146)) | (1L << (TINYINT - 146)) | (1L << (SMALLINT - 146)) | (1L << (INT - 146)) | (1L << (INTEGER - 146)) | (1L << (BIGINT - 146)) | (1L << (FLOAT4 - 146)) | (1L << (FLOAT8 - 146)) | (1L << (REAL - 146)) | (1L << (FLOAT - 146)) | (1L << (DOUBLE - 146)) | (1L << (NUMERIC - 146)) | (1L << (DECIMAL - 146)) | (1L << (CHAR - 146)) | (1L << (VARCHAR - 146)) | (1L << (NCHAR - 146)) | (1L << (NVARCHAR - 146)) | (1L << (DATE - 146)) | (1L << (TIME - 146)) | (1L << (TIMETZ - 146)) | (1L << (TIMESTAMP - 146)) | (1L << (TIMESTAMPTZ - 146)) | (1L << (TEXT - 146)) | (1L << (VARBINARY - 146)) | (1L << (BLOB - 146)) | (1L << (BYTEA - 146)) | (1L << (INET4 - 146)))) != 0) || _la==Identifier) {
				{
				setState(535); ((Create_trigger_statementContext)_localctx).arguments = identifier();
				setState(537);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(536); match(COMMA);
					}
				}

				}
			}

			setState(541); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 16, RULE_argmode);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(543);
			_la = _input.LA(1);
			if ( !(((((_la - 37)) & ~0x3f) == 0 && ((1L << (_la - 37)) & ((1L << (IN - 37)) | (1L << (INOUT - 37)) | (1L << (OUT - 37)) | (1L << (VARIADIC - 37)))) != 0)) ) {
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
		enterRule(_localctx, 18, RULE_create_table_statement);
		int _la;
		try {
			setState(595);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(545); match(CREATE);
				setState(546); match(EXTERNAL);
				setState(547); match(TABLE);
				setState(548); ((Create_table_statementContext)_localctx).n = table_name();
				setState(549); table_elements();
				setState(550); match(USING);
				setState(551); ((Create_table_statementContext)_localctx).file_type = identifier();
				setState(553);
				_la = _input.LA(1);
				if (_la==WITH) {
					{
					setState(552); param_clause();
					}
				}

				setState(556);
				_la = _input.LA(1);
				if (_la==PARTITION) {
					{
					setState(555); table_partitioning_clauses();
					}
				}

				{
				setState(558); match(LOCATION);
				setState(559); ((Create_table_statementContext)_localctx).path = match(Character_String_Literal);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(561); match(CREATE);
				setState(562); match(TABLE);
				setState(563); ((Create_table_statementContext)_localctx).n = table_name();
				setState(564); table_elements();
				setState(567);
				_la = _input.LA(1);
				if (_la==USING) {
					{
					setState(565); match(USING);
					setState(566); ((Create_table_statementContext)_localctx).file_type = identifier();
					}
				}

				setState(570);
				_la = _input.LA(1);
				if (_la==WITH) {
					{
					setState(569); param_clause();
					}
				}

				setState(573);
				switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
				case 1:
					{
					setState(572); table_partitioning_clauses();
					}
					break;
				}
				setState(577);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(575); match(AS);
					setState(576); query_expression();
					}
				}

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(579); match(CREATE);
				setState(580); match(TABLE);
				setState(581); ((Create_table_statementContext)_localctx).n = table_name();
				setState(584);
				_la = _input.LA(1);
				if (_la==USING) {
					{
					setState(582); match(USING);
					setState(583); ((Create_table_statementContext)_localctx).file_type = identifier();
					}
				}

				setState(587);
				_la = _input.LA(1);
				if (_la==WITH) {
					{
					setState(586); param_clause();
					}
				}

				setState(590);
				_la = _input.LA(1);
				if (_la==PARTITION) {
					{
					setState(589); table_partitioning_clauses();
					}
				}

				setState(592); match(AS);
				setState(593); query_expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 20, RULE_table_elements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(597); match(LEFT_PAREN);
			setState(598); field_element();
			setState(603);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(599); match(COMMA);
				setState(600); field_element();
				}
				}
				setState(605);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(606); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 22, RULE_field_element);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(608); ((Field_elementContext)_localctx).name = identifier();
			setState(609); field_type();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 24, RULE_field_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(611); data_type();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 26, RULE_param_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(613); match(WITH);
			setState(614); match(LEFT_PAREN);
			setState(615); param();
			setState(620);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(616); match(COMMA);
				setState(617); param();
				}
				}
				setState(622);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(623); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 28, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(625); ((ParamContext)_localctx).key = match(Character_String_Literal);
			setState(626); match(EQUAL);
			setState(627); ((ParamContext)_localctx).value = numeric_value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 30, RULE_method_specifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(629); match(USING);
			setState(630); ((Method_specifierContext)_localctx).m = identifier();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 32, RULE_table_space_specifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(632); match(TABLESPACE);
			setState(633); table_space_name();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 34, RULE_table_space_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(635); identifier();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 36, RULE_table_partitioning_clauses);
		try {
			setState(641);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(637); range_partitions();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(638); hash_partitions();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(639); list_partitions();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(640); column_partitions();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 38, RULE_range_partitions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(643); match(PARTITION);
			setState(644); match(BY);
			setState(645); match(RANGE);
			setState(646); match(LEFT_PAREN);
			setState(647); column_reference_list();
			setState(648); match(RIGHT_PAREN);
			setState(649); match(LEFT_PAREN);
			setState(650); range_value_clause_list();
			setState(651); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 40, RULE_range_value_clause_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(653); range_value_clause();
			setState(658);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(654); match(COMMA);
				setState(655); range_value_clause();
				}
				}
				setState(660);
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
		enterRule(_localctx, 42, RULE_range_value_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(661); match(PARTITION);
			setState(662); partition_name();
			setState(663); match(VALUES);
			setState(664); match(LESS);
			setState(665); match(THAN);
			setState(677);
			switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
			case 1:
				{
				setState(666); match(LEFT_PAREN);
				setState(667); value_expression();
				setState(668); match(RIGHT_PAREN);
				}
				break;
			case 2:
				{
				setState(671);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(670); match(LEFT_PAREN);
					}
				}

				setState(673); match(MAXVALUE);
				setState(675);
				switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
				case 1:
					{
					setState(674); match(RIGHT_PAREN);
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
		enterRule(_localctx, 44, RULE_hash_partitions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(679); match(PARTITION);
			setState(680); match(BY);
			setState(681); match(HASH);
			setState(682); match(LEFT_PAREN);
			setState(683); column_reference_list();
			setState(684); match(RIGHT_PAREN);
			setState(690);
			switch (_input.LA(1)) {
			case LEFT_PAREN:
				{
				setState(685); match(LEFT_PAREN);
				setState(686); individual_hash_partitions();
				setState(687); match(RIGHT_PAREN);
				}
				break;
			case PARTITIONS:
				{
				setState(689); hash_partitions_by_quantity();
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
		enterRule(_localctx, 46, RULE_individual_hash_partitions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(692); individual_hash_partition();
			setState(697);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(693); match(COMMA);
				setState(694); individual_hash_partition();
				}
				}
				setState(699);
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
		enterRule(_localctx, 48, RULE_individual_hash_partition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(700); match(PARTITION);
			setState(701); partition_name();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 50, RULE_hash_partitions_by_quantity);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(703); match(PARTITIONS);
			setState(704); ((Hash_partitions_by_quantityContext)_localctx).quantity = numeric_value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 52, RULE_list_partitions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(706); match(PARTITION);
			setState(707); match(BY);
			setState(708); match(LIST);
			setState(709); match(LEFT_PAREN);
			setState(710); column_reference_list();
			setState(711); match(RIGHT_PAREN);
			setState(712); match(LEFT_PAREN);
			setState(713); list_value_clause_list();
			setState(714); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 54, RULE_list_value_clause_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(716); list_value_partition();
			setState(721);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(717); match(COMMA);
				setState(718); list_value_partition();
				}
				}
				setState(723);
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
		enterRule(_localctx, 56, RULE_list_value_partition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(724); match(PARTITION);
			setState(725); partition_name();
			setState(726); match(VALUES);
			setState(728);
			_la = _input.LA(1);
			if (_la==IN) {
				{
				setState(727); match(IN);
				}
			}

			setState(730); match(LEFT_PAREN);
			setState(731); in_value_list();
			setState(732); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 58, RULE_column_partitions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(734); match(PARTITION);
			setState(735); match(BY);
			setState(736); match(COLUMN);
			setState(737); table_elements();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 60, RULE_partition_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(739); identifier();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 62, RULE_drop_table_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(741); match(DROP);
			setState(742); match(TABLE);
			setState(743); table_name();
			setState(745);
			switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
			case 1:
				{
				setState(744); match(PURGE);
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
		enterRule(_localctx, 64, RULE_identifier);
		try {
			setState(749);
			switch (_input.LA(1)) {
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(747); match(Identifier);
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
				setState(748); nonreserved_keywords();
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
		enterRule(_localctx, 66, RULE_nonreserved_keywords);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(751);
			_la = _input.LA(1);
			if ( !(((((_la - 82)) & ~0x3f) == 0 && ((1L << (_la - 82)) & ((1L << (AVG - 82)) | (1L << (BETWEEN - 82)) | (1L << (BY - 82)) | (1L << (CENTURY - 82)) | (1L << (CHARACTER - 82)) | (1L << (COLLECT - 82)) | (1L << (COALESCE - 82)) | (1L << (COLUMN - 82)) | (1L << (COUNT - 82)) | (1L << (CUBE - 82)) | (1L << (DAY - 82)) | (1L << (DEC - 82)) | (1L << (DECADE - 82)) | (1L << (DOW - 82)) | (1L << (DOY - 82)) | (1L << (DROP - 82)) | (1L << (EPOCH - 82)) | (1L << (EVERY - 82)) | (1L << (EXISTS - 82)) | (1L << (EXTERNAL - 82)) | (1L << (EXTRACT - 82)) | (1L << (FILTER - 82)) | (1L << (FIRST - 82)) | (1L << (FORMAT - 82)) | (1L << (FUSION - 82)) | (1L << (GROUPING - 82)) | (1L << (HASH - 82)) | (1L << (INDEX - 82)) | (1L << (INSERT - 82)) | (1L << (INTERSECTION - 82)) | (1L << (ISODOW - 82)) | (1L << (ISOYEAR - 82)) | (1L << (LAST - 82)) | (1L << (LESS - 82)) | (1L << (LIST - 82)) | (1L << (LOCATION - 82)) | (1L << (MAX - 82)) | (1L << (MAXVALUE - 82)) | (1L << (MICROSECONDS - 82)) | (1L << (MILLENNIUM - 82)) | (1L << (MILLISECONDS - 82)) | (1L << (MIN - 82)) | (1L << (MINUTE - 82)) | (1L << (MONTH - 82)) | (1L << (NATIONAL - 82)) | (1L << (NULLIF - 82)) | (1L << (OVERWRITE - 82)) | (1L << (PARTITION - 82)) | (1L << (PARTITIONS - 82)) | (1L << (PRECISION - 82)) | (1L << (PURGE - 82)) | (1L << (QUARTER - 82)) | (1L << (RANGE - 82)) | (1L << (REGEXP - 82)) | (1L << (RLIKE - 82)) | (1L << (ROLLUP - 82)) | (1L << (SECOND - 82)) | (1L << (SET - 82)) | (1L << (SIMILAR - 82)) | (1L << (STDDEV_POP - 82)) | (1L << (STDDEV_SAMP - 82)) | (1L << (SUBPARTITION - 82)) | (1L << (SUM - 82)))) != 0) || ((((_la - 146)) & ~0x3f) == 0 && ((1L << (_la - 146)) & ((1L << (TABLESPACE - 146)) | (1L << (THAN - 146)) | (1L << (TIMEZONE - 146)) | (1L << (TIMEZONE_HOUR - 146)) | (1L << (TIMEZONE_MINUTE - 146)) | (1L << (TRIM - 146)) | (1L << (TO - 146)) | (1L << (UNKNOWN - 146)) | (1L << (VALUES - 146)) | (1L << (VAR_SAMP - 146)) | (1L << (VAR_POP - 146)) | (1L << (VARYING - 146)) | (1L << (WEEK - 146)) | (1L << (YEAR - 146)) | (1L << (ZONE - 146)) | (1L << (BOOLEAN - 146)) | (1L << (BOOL - 146)) | (1L << (BIT - 146)) | (1L << (VARBIT - 146)) | (1L << (INT1 - 146)) | (1L << (INT2 - 146)) | (1L << (INT4 - 146)) | (1L << (INT8 - 146)) | (1L << (TINYINT - 146)) | (1L << (SMALLINT - 146)) | (1L << (INT - 146)) | (1L << (INTEGER - 146)) | (1L << (BIGINT - 146)) | (1L << (FLOAT4 - 146)) | (1L << (FLOAT8 - 146)) | (1L << (REAL - 146)) | (1L << (FLOAT - 146)) | (1L << (DOUBLE - 146)) | (1L << (NUMERIC - 146)) | (1L << (DECIMAL - 146)) | (1L << (CHAR - 146)) | (1L << (VARCHAR - 146)) | (1L << (NCHAR - 146)) | (1L << (NVARCHAR - 146)) | (1L << (DATE - 146)) | (1L << (TIME - 146)) | (1L << (TIMETZ - 146)) | (1L << (TIMESTAMP - 146)) | (1L << (TIMESTAMPTZ - 146)) | (1L << (TEXT - 146)) | (1L << (VARBINARY - 146)) | (1L << (BLOB - 146)) | (1L << (BYTEA - 146)) | (1L << (INET4 - 146)))) != 0)) ) {
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
		enterRule(_localctx, 68, RULE_unsigned_literal);
		try {
			setState(755);
			switch (_input.LA(1)) {
			case NUMBER:
			case REAL_NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(753); unsigned_numeric_literal();
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
				setState(754); general_literal();
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
		enterRule(_localctx, 70, RULE_general_literal);
		try {
			setState(760);
			switch (_input.LA(1)) {
			case Character_String_Literal:
				enterOuterAlt(_localctx, 1);
				{
				setState(757); match(Character_String_Literal);
				}
				break;
			case DATE:
			case TIME:
			case TIMESTAMP:
				enterOuterAlt(_localctx, 2);
				{
				setState(758); datetime_literal();
				}
				break;
			case FALSE:
			case TRUE:
			case UNKNOWN:
				enterOuterAlt(_localctx, 3);
				{
				setState(759); boolean_literal();
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
		enterRule(_localctx, 72, RULE_datetime_literal);
		try {
			setState(765);
			switch (_input.LA(1)) {
			case TIMESTAMP:
				enterOuterAlt(_localctx, 1);
				{
				setState(762); timestamp_literal();
				}
				break;
			case TIME:
				enterOuterAlt(_localctx, 2);
				{
				setState(763); time_literal();
				}
				break;
			case DATE:
				enterOuterAlt(_localctx, 3);
				{
				setState(764); date_literal();
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
		enterRule(_localctx, 74, RULE_time_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(767); match(TIME);
			setState(768); ((Time_literalContext)_localctx).time_string = match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 76, RULE_timestamp_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(770); match(TIMESTAMP);
			setState(771); ((Timestamp_literalContext)_localctx).timestamp_string = match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 78, RULE_date_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(773); match(DATE);
			setState(774); ((Date_literalContext)_localctx).date_string = match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 80, RULE_boolean_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(776);
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
		enterRule(_localctx, 82, RULE_data_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(778); predefined_type();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 84, RULE_predefined_type);
		try {
			setState(789);
			switch (_input.LA(1)) {
			case CHARACTER:
			case CHAR:
			case VARCHAR:
			case TEXT:
				enterOuterAlt(_localctx, 1);
				{
				setState(780); character_string_type();
				}
				break;
			case NATIONAL:
			case NCHAR:
			case NVARCHAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(781); national_character_string_type();
				}
				break;
			case BLOB:
			case BYTEA:
				enterOuterAlt(_localctx, 3);
				{
				setState(782); binary_large_object_string_type();
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
				setState(783); numeric_type();
				}
				break;
			case BOOLEAN:
			case BOOL:
				enterOuterAlt(_localctx, 5);
				{
				setState(784); boolean_type();
				}
				break;
			case DATE:
			case TIME:
			case TIMETZ:
			case TIMESTAMP:
			case TIMESTAMPTZ:
				enterOuterAlt(_localctx, 6);
				{
				setState(785); datetime_type();
				}
				break;
			case BIT:
			case VARBIT:
				enterOuterAlt(_localctx, 7);
				{
				setState(786); bit_type();
				}
				break;
			case BINARY:
			case VARBINARY:
				enterOuterAlt(_localctx, 8);
				{
				setState(787); binary_type();
				}
				break;
			case INET4:
				enterOuterAlt(_localctx, 9);
				{
				setState(788); network_type();
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
		enterRule(_localctx, 86, RULE_network_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(791); match(INET4);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 88, RULE_character_string_type);
		try {
			setState(816);
			switch ( getInterpreter().adaptivePredict(_input,58,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(793); match(CHARACTER);
				setState(795);
				switch ( getInterpreter().adaptivePredict(_input,53,_ctx) ) {
				case 1:
					{
					setState(794); type_length();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(797); match(CHAR);
				setState(799);
				switch ( getInterpreter().adaptivePredict(_input,54,_ctx) ) {
				case 1:
					{
					setState(798); type_length();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(801); match(CHARACTER);
				setState(802); match(VARYING);
				setState(804);
				switch ( getInterpreter().adaptivePredict(_input,55,_ctx) ) {
				case 1:
					{
					setState(803); type_length();
					}
					break;
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(806); match(CHAR);
				setState(807); match(VARYING);
				setState(809);
				switch ( getInterpreter().adaptivePredict(_input,56,_ctx) ) {
				case 1:
					{
					setState(808); type_length();
					}
					break;
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(811); match(VARCHAR);
				setState(813);
				switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
				case 1:
					{
					setState(812); type_length();
					}
					break;
				}
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(815); match(TEXT);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 90, RULE_type_length);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(818); match(LEFT_PAREN);
			setState(819); match(NUMBER);
			setState(820); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 92, RULE_national_character_string_type);
		try {
			setState(857);
			switch ( getInterpreter().adaptivePredict(_input,66,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(822); match(NATIONAL);
				setState(823); match(CHARACTER);
				setState(825);
				switch ( getInterpreter().adaptivePredict(_input,59,_ctx) ) {
				case 1:
					{
					setState(824); type_length();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(827); match(NATIONAL);
				setState(828); match(CHAR);
				setState(830);
				switch ( getInterpreter().adaptivePredict(_input,60,_ctx) ) {
				case 1:
					{
					setState(829); type_length();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(832); match(NCHAR);
				setState(834);
				switch ( getInterpreter().adaptivePredict(_input,61,_ctx) ) {
				case 1:
					{
					setState(833); type_length();
					}
					break;
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(836); match(NATIONAL);
				setState(837); match(CHARACTER);
				setState(838); match(VARYING);
				setState(840);
				switch ( getInterpreter().adaptivePredict(_input,62,_ctx) ) {
				case 1:
					{
					setState(839); type_length();
					}
					break;
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(842); match(NATIONAL);
				setState(843); match(CHAR);
				setState(844); match(VARYING);
				setState(846);
				switch ( getInterpreter().adaptivePredict(_input,63,_ctx) ) {
				case 1:
					{
					setState(845); type_length();
					}
					break;
				}
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(848); match(NCHAR);
				setState(849); match(VARYING);
				setState(851);
				switch ( getInterpreter().adaptivePredict(_input,64,_ctx) ) {
				case 1:
					{
					setState(850); type_length();
					}
					break;
				}
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(853); match(NVARCHAR);
				setState(855);
				switch ( getInterpreter().adaptivePredict(_input,65,_ctx) ) {
				case 1:
					{
					setState(854); type_length();
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
		enterRule(_localctx, 94, RULE_binary_large_object_string_type);
		try {
			setState(867);
			switch (_input.LA(1)) {
			case BLOB:
				enterOuterAlt(_localctx, 1);
				{
				setState(859); match(BLOB);
				setState(861);
				switch ( getInterpreter().adaptivePredict(_input,67,_ctx) ) {
				case 1:
					{
					setState(860); type_length();
					}
					break;
				}
				}
				break;
			case BYTEA:
				enterOuterAlt(_localctx, 2);
				{
				setState(863); match(BYTEA);
				setState(865);
				switch ( getInterpreter().adaptivePredict(_input,68,_ctx) ) {
				case 1:
					{
					setState(864); type_length();
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
		enterRule(_localctx, 96, RULE_numeric_type);
		try {
			setState(871);
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
				setState(869); exact_numeric_type();
				}
				break;
			case FLOAT4:
			case FLOAT8:
			case REAL:
			case FLOAT:
			case DOUBLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(870); approximate_numeric_type();
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
		enterRule(_localctx, 98, RULE_exact_numeric_type);
		try {
			setState(894);
			switch (_input.LA(1)) {
			case NUMERIC:
				enterOuterAlt(_localctx, 1);
				{
				setState(873); match(NUMERIC);
				setState(875);
				switch ( getInterpreter().adaptivePredict(_input,71,_ctx) ) {
				case 1:
					{
					setState(874); precision_param();
					}
					break;
				}
				}
				break;
			case DECIMAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(877); match(DECIMAL);
				setState(879);
				switch ( getInterpreter().adaptivePredict(_input,72,_ctx) ) {
				case 1:
					{
					setState(878); precision_param();
					}
					break;
				}
				}
				break;
			case DEC:
				enterOuterAlt(_localctx, 3);
				{
				setState(881); match(DEC);
				setState(883);
				switch ( getInterpreter().adaptivePredict(_input,73,_ctx) ) {
				case 1:
					{
					setState(882); precision_param();
					}
					break;
				}
				}
				break;
			case INT1:
				enterOuterAlt(_localctx, 4);
				{
				setState(885); match(INT1);
				}
				break;
			case TINYINT:
				enterOuterAlt(_localctx, 5);
				{
				setState(886); match(TINYINT);
				}
				break;
			case INT2:
				enterOuterAlt(_localctx, 6);
				{
				setState(887); match(INT2);
				}
				break;
			case SMALLINT:
				enterOuterAlt(_localctx, 7);
				{
				setState(888); match(SMALLINT);
				}
				break;
			case INT4:
				enterOuterAlt(_localctx, 8);
				{
				setState(889); match(INT4);
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 9);
				{
				setState(890); match(INT);
				}
				break;
			case INTEGER:
				enterOuterAlt(_localctx, 10);
				{
				setState(891); match(INTEGER);
				}
				break;
			case INT8:
				enterOuterAlt(_localctx, 11);
				{
				setState(892); match(INT8);
				}
				break;
			case BIGINT:
				enterOuterAlt(_localctx, 12);
				{
				setState(893); match(BIGINT);
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
		enterRule(_localctx, 100, RULE_approximate_numeric_type);
		try {
			setState(906);
			switch ( getInterpreter().adaptivePredict(_input,76,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(896); match(FLOAT);
				setState(898);
				switch ( getInterpreter().adaptivePredict(_input,75,_ctx) ) {
				case 1:
					{
					setState(897); precision_param();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(900); match(FLOAT4);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(901); match(REAL);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(902); match(FLOAT8);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(903); match(DOUBLE);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(904); match(DOUBLE);
				setState(905); match(PRECISION);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 102, RULE_precision_param);
		try {
			setState(916);
			switch ( getInterpreter().adaptivePredict(_input,77,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(908); match(LEFT_PAREN);
				setState(909); ((Precision_paramContext)_localctx).precision = match(NUMBER);
				setState(910); match(RIGHT_PAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(911); match(LEFT_PAREN);
				setState(912); ((Precision_paramContext)_localctx).precision = match(NUMBER);
				setState(913); match(COMMA);
				setState(914); ((Precision_paramContext)_localctx).scale = match(NUMBER);
				setState(915); match(RIGHT_PAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 104, RULE_boolean_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(918);
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
		enterRule(_localctx, 106, RULE_datetime_type);
		try {
			setState(933);
			switch ( getInterpreter().adaptivePredict(_input,78,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(920); match(DATE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(921); match(TIME);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(922); match(TIME);
				setState(923); match(WITH);
				setState(924); match(TIME);
				setState(925); match(ZONE);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(926); match(TIMETZ);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(927); match(TIMESTAMP);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(928); match(TIMESTAMP);
				setState(929); match(WITH);
				setState(930); match(TIME);
				setState(931); match(ZONE);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(932); match(TIMESTAMPTZ);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 108, RULE_bit_type);
		try {
			setState(948);
			switch ( getInterpreter().adaptivePredict(_input,82,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(935); match(BIT);
				setState(937);
				switch ( getInterpreter().adaptivePredict(_input,79,_ctx) ) {
				case 1:
					{
					setState(936); type_length();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(939); match(VARBIT);
				setState(941);
				switch ( getInterpreter().adaptivePredict(_input,80,_ctx) ) {
				case 1:
					{
					setState(940); type_length();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(943); match(BIT);
				setState(944); match(VARYING);
				setState(946);
				switch ( getInterpreter().adaptivePredict(_input,81,_ctx) ) {
				case 1:
					{
					setState(945); type_length();
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
		enterRule(_localctx, 110, RULE_binary_type);
		try {
			setState(963);
			switch ( getInterpreter().adaptivePredict(_input,86,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(950); match(BINARY);
				setState(952);
				switch ( getInterpreter().adaptivePredict(_input,83,_ctx) ) {
				case 1:
					{
					setState(951); type_length();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(954); match(BINARY);
				setState(955); match(VARYING);
				setState(957);
				switch ( getInterpreter().adaptivePredict(_input,84,_ctx) ) {
				case 1:
					{
					setState(956); type_length();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(959); match(VARBINARY);
				setState(961);
				switch ( getInterpreter().adaptivePredict(_input,85,_ctx) ) {
				case 1:
					{
					setState(960); type_length();
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
		enterRule(_localctx, 112, RULE_value_expression_primary);
		try {
			setState(967);
			switch ( getInterpreter().adaptivePredict(_input,87,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(965); parenthesized_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(966); nonparenthesized_value_expression_primary();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 114, RULE_parenthesized_value_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(969); match(LEFT_PAREN);
			setState(970); value_expression();
			setState(971); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 116, RULE_nonparenthesized_value_expression_primary);
		try {
			setState(980);
			switch ( getInterpreter().adaptivePredict(_input,88,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(973); unsigned_value_specification();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(974); column_reference();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(975); set_function_specification();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(976); scalar_subquery();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(977); case_expression();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(978); cast_specification();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(979); routine_invocation();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 118, RULE_unsigned_value_specification);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(982); unsigned_literal();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 120, RULE_unsigned_numeric_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(984);
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
		enterRule(_localctx, 122, RULE_signed_numerical_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(987);
			_la = _input.LA(1);
			if (_la==PLUS || _la==MINUS) {
				{
				setState(986); sign();
				}
			}

			setState(989); unsigned_numeric_literal();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 124, RULE_set_function_specification);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(991); aggregate_function();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 126, RULE_aggregate_function);
		try {
			setState(1001);
			switch ( getInterpreter().adaptivePredict(_input,91,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(993); match(COUNT);
				setState(994); match(LEFT_PAREN);
				setState(995); match(MULTIPLY);
				setState(996); match(RIGHT_PAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(997); general_set_function();
				setState(999);
				switch ( getInterpreter().adaptivePredict(_input,90,_ctx) ) {
				case 1:
					{
					setState(998); filter_clause();
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
		enterRule(_localctx, 128, RULE_general_set_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1003); set_function_type();
			setState(1004); match(LEFT_PAREN);
			setState(1006);
			_la = _input.LA(1);
			if (_la==ALL || _la==DISTINCT) {
				{
				setState(1005); set_qualifier();
				}
			}

			setState(1008); value_expression();
			setState(1009); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 130, RULE_set_function_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1011);
			_la = _input.LA(1);
			if ( !(_la==ANY || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (SOME - 65)) | (1L << (AVG - 65)) | (1L << (COLLECT - 65)) | (1L << (COUNT - 65)) | (1L << (EVERY - 65)) | (1L << (FUSION - 65)) | (1L << (INTERSECTION - 65)) | (1L << (MAX - 65)) | (1L << (MIN - 65)))) != 0) || ((((_la - 142)) & ~0x3f) == 0 && ((1L << (_la - 142)) & ((1L << (STDDEV_POP - 142)) | (1L << (STDDEV_SAMP - 142)) | (1L << (SUM - 142)) | (1L << (VAR_SAMP - 142)) | (1L << (VAR_POP - 142)))) != 0)) ) {
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
		enterRule(_localctx, 132, RULE_filter_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1013); match(FILTER);
			setState(1014); match(LEFT_PAREN);
			setState(1015); match(WHERE);
			setState(1016); search_condition();
			setState(1017); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 134, RULE_grouping_operation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1019); match(GROUPING);
			setState(1020); match(LEFT_PAREN);
			setState(1021); column_reference_list();
			setState(1022); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 136, RULE_case_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1024); case_specification();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 138, RULE_case_abbreviation);
		int _la;
		try {
			setState(1044);
			switch (_input.LA(1)) {
			case NULLIF:
				enterOuterAlt(_localctx, 1);
				{
				setState(1026); match(NULLIF);
				setState(1027); match(LEFT_PAREN);
				setState(1028); numeric_value_expression();
				setState(1029); match(COMMA);
				setState(1030); boolean_value_expression();
				setState(1031); match(RIGHT_PAREN);
				}
				break;
			case COALESCE:
				enterOuterAlt(_localctx, 2);
				{
				setState(1033); match(COALESCE);
				setState(1034); match(LEFT_PAREN);
				setState(1035); numeric_value_expression();
				setState(1038); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1036); match(COMMA);
					setState(1037); boolean_value_expression();
					}
					}
					setState(1040); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==COMMA );
				setState(1042); match(RIGHT_PAREN);
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
		enterRule(_localctx, 140, RULE_case_specification);
		try {
			setState(1048);
			switch ( getInterpreter().adaptivePredict(_input,95,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1046); simple_case();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1047); searched_case();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 142, RULE_simple_case);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1050); match(CASE);
			setState(1051); boolean_value_expression();
			setState(1053); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1052); simple_when_clause();
				}
				}
				setState(1055); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WHEN );
			setState(1058);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(1057); else_clause();
				}
			}

			setState(1060); match(END);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 144, RULE_searched_case);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1062); match(CASE);
			setState(1064); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1063); searched_when_clause();
				}
				}
				setState(1066); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WHEN );
			setState(1069);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(1068); else_clause();
				}
			}

			setState(1071); match(END);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 146, RULE_simple_when_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1073); match(WHEN);
			setState(1074); search_condition();
			setState(1075); match(THEN);
			setState(1076); result();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 148, RULE_searched_when_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1078); match(WHEN);
			setState(1079); ((Searched_when_clauseContext)_localctx).c = search_condition();
			setState(1080); match(THEN);
			setState(1081); ((Searched_when_clauseContext)_localctx).r = result();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 150, RULE_else_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1083); match(ELSE);
			setState(1084); ((Else_clauseContext)_localctx).r = result();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 152, RULE_result);
		try {
			setState(1088);
			switch ( getInterpreter().adaptivePredict(_input,100,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1086); value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1087); match(NULL);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 154, RULE_cast_specification);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1090); match(CAST);
			setState(1091); match(LEFT_PAREN);
			setState(1092); cast_operand();
			setState(1093); match(AS);
			setState(1094); cast_target();
			setState(1095); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 156, RULE_cast_operand);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1097); value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 158, RULE_cast_target);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1099); data_type();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 160, RULE_value_expression);
		try {
			setState(1104);
			switch ( getInterpreter().adaptivePredict(_input,101,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1101); common_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1102); row_value_expression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1103); boolean_value_expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 162, RULE_common_value_expression);
		try {
			setState(1109);
			switch ( getInterpreter().adaptivePredict(_input,102,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1106); numeric_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1107); string_value_expression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1108); match(NULL);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 164, RULE_numeric_value_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1111); ((Numeric_value_expressionContext)_localctx).left = term();
			setState(1116);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				{
				setState(1112);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(1113); ((Numeric_value_expressionContext)_localctx).right = term();
				}
				}
				setState(1118);
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
		enterRule(_localctx, 166, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1119); ((TermContext)_localctx).left = factor();
			setState(1124);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 217)) & ~0x3f) == 0 && ((1L << (_la - 217)) & ((1L << (MULTIPLY - 217)) | (1L << (DIVIDE - 217)) | (1L << (MODULAR - 217)))) != 0)) {
				{
				{
				setState(1120);
				_la = _input.LA(1);
				if ( !(((((_la - 217)) & ~0x3f) == 0 && ((1L << (_la - 217)) & ((1L << (MULTIPLY - 217)) | (1L << (DIVIDE - 217)) | (1L << (MODULAR - 217)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(1121); ((TermContext)_localctx).right = factor();
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
		enterRule(_localctx, 168, RULE_factor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1128);
			_la = _input.LA(1);
			if (_la==PLUS || _la==MINUS) {
				{
				setState(1127); sign();
				}
			}

			setState(1130); numeric_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 170, RULE_array);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1132); match(LEFT_PAREN);
			setState(1133); numeric_value_expression();
			setState(1138);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1134); match(COMMA);
				setState(1135); numeric_value_expression();
				}
				}
				setState(1140);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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
		enterRule(_localctx, 172, RULE_numeric_primary);
		int _la;
		try {
			setState(1152);
			switch ( getInterpreter().adaptivePredict(_input,108,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1143); value_expression_primary();
				setState(1148);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CAST_EXPRESSION) {
					{
					{
					setState(1144); match(CAST_EXPRESSION);
					setState(1145); cast_target();
					}
					}
					setState(1150);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1151); numeric_value_function();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 174, RULE_sign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1154);
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
		enterRule(_localctx, 176, RULE_numeric_value_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1156); extract_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 178, RULE_extract_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1158); match(EXTRACT);
			setState(1159); match(LEFT_PAREN);
			setState(1160); ((Extract_expressionContext)_localctx).extract_field_string = extract_field();
			setState(1161); match(FROM);
			setState(1162); extract_source();
			setState(1163); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 180, RULE_extract_field);
		try {
			setState(1168);
			switch (_input.LA(1)) {
			case DAY:
			case HOUR:
			case MINUTE:
			case MONTH:
			case SECOND:
			case YEAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(1165); primary_datetime_field();
				}
				break;
			case TIMEZONE:
			case TIMEZONE_HOUR:
			case TIMEZONE_MINUTE:
				enterOuterAlt(_localctx, 2);
				{
				setState(1166); time_zone_field();
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
				setState(1167); extended_datetime_field();
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
		enterRule(_localctx, 182, RULE_time_zone_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1170);
			_la = _input.LA(1);
			if ( !(((((_la - 148)) & ~0x3f) == 0 && ((1L << (_la - 148)) & ((1L << (TIMEZONE - 148)) | (1L << (TIMEZONE_HOUR - 148)) | (1L << (TIMEZONE_MINUTE - 148)))) != 0)) ) {
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
		enterRule(_localctx, 184, RULE_extract_source);
		try {
			setState(1174);
			switch ( getInterpreter().adaptivePredict(_input,110,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1172); column_reference();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1173); datetime_literal();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 186, RULE_string_value_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1176); character_value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 188, RULE_character_value_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1178); character_factor();
			setState(1183);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CONCATENATION_OPERATOR) {
				{
				{
				setState(1179); match(CONCATENATION_OPERATOR);
				setState(1180); character_factor();
				}
				}
				setState(1185);
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
		enterRule(_localctx, 190, RULE_character_factor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1186); character_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 192, RULE_character_primary);
		try {
			setState(1190);
			switch ( getInterpreter().adaptivePredict(_input,112,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1188); value_expression_primary();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1189); string_value_function();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 194, RULE_string_value_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1192); trim_function();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 196, RULE_trim_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1194); match(TRIM);
			setState(1195); match(LEFT_PAREN);
			setState(1196); trim_operands();
			setState(1197); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 198, RULE_trim_operands);
		int _la;
		try {
			setState(1213);
			switch ( getInterpreter().adaptivePredict(_input,116,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1206);
				switch ( getInterpreter().adaptivePredict(_input,115,_ctx) ) {
				case 1:
					{
					setState(1200);
					_la = _input.LA(1);
					if (((((_la - 9)) & ~0x3f) == 0 && ((1L << (_la - 9)) & ((1L << (BOTH - 9)) | (1L << (LEADING - 9)) | (1L << (TRAILING - 9)))) != 0)) {
						{
						setState(1199); trim_specification();
						}
					}

					setState(1203);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ANY) | (1L << CASE) | (1L << CAST) | (1L << FALSE) | (1L << LEFT) | (1L << RIGHT))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (SOME - 65)) | (1L << (TRUE - 65)) | (1L << (AVG - 65)) | (1L << (BETWEEN - 65)) | (1L << (BY - 65)) | (1L << (CENTURY - 65)) | (1L << (CHARACTER - 65)) | (1L << (COLLECT - 65)) | (1L << (COALESCE - 65)) | (1L << (COLUMN - 65)) | (1L << (COUNT - 65)) | (1L << (CUBE - 65)) | (1L << (DAY - 65)) | (1L << (DEC - 65)) | (1L << (DECADE - 65)) | (1L << (DOW - 65)) | (1L << (DOY - 65)) | (1L << (DROP - 65)) | (1L << (EPOCH - 65)) | (1L << (EVERY - 65)) | (1L << (EXISTS - 65)) | (1L << (EXTERNAL - 65)) | (1L << (EXTRACT - 65)) | (1L << (FILTER - 65)) | (1L << (FIRST - 65)) | (1L << (FORMAT - 65)) | (1L << (FUSION - 65)) | (1L << (GROUPING - 65)) | (1L << (HASH - 65)) | (1L << (INDEX - 65)) | (1L << (INSERT - 65)) | (1L << (INTERSECTION - 65)) | (1L << (ISODOW - 65)) | (1L << (ISOYEAR - 65)) | (1L << (LAST - 65)) | (1L << (LESS - 65)) | (1L << (LIST - 65)) | (1L << (LOCATION - 65)) | (1L << (MAX - 65)) | (1L << (MAXVALUE - 65)) | (1L << (MICROSECONDS - 65)) | (1L << (MILLENNIUM - 65)) | (1L << (MILLISECONDS - 65)) | (1L << (MIN - 65)) | (1L << (MINUTE - 65)) | (1L << (MONTH - 65)) | (1L << (NATIONAL - 65)) | (1L << (NULLIF - 65)))) != 0) || ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (OVERWRITE - 129)) | (1L << (PARTITION - 129)) | (1L << (PARTITIONS - 129)) | (1L << (PRECISION - 129)) | (1L << (PURGE - 129)) | (1L << (QUARTER - 129)) | (1L << (RANGE - 129)) | (1L << (REGEXP - 129)) | (1L << (RLIKE - 129)) | (1L << (ROLLUP - 129)) | (1L << (SECOND - 129)) | (1L << (SET - 129)) | (1L << (SIMILAR - 129)) | (1L << (STDDEV_POP - 129)) | (1L << (STDDEV_SAMP - 129)) | (1L << (SUBPARTITION - 129)) | (1L << (SUM - 129)) | (1L << (TABLESPACE - 129)) | (1L << (THAN - 129)) | (1L << (TIMEZONE - 129)) | (1L << (TIMEZONE_HOUR - 129)) | (1L << (TIMEZONE_MINUTE - 129)) | (1L << (TRIM - 129)) | (1L << (TO - 129)) | (1L << (UNKNOWN - 129)) | (1L << (VALUES - 129)) | (1L << (VAR_SAMP - 129)) | (1L << (VAR_POP - 129)) | (1L << (VARYING - 129)) | (1L << (WEEK - 129)) | (1L << (YEAR - 129)) | (1L << (ZONE - 129)) | (1L << (BOOLEAN - 129)) | (1L << (BOOL - 129)) | (1L << (BIT - 129)) | (1L << (VARBIT - 129)) | (1L << (INT1 - 129)) | (1L << (INT2 - 129)) | (1L << (INT4 - 129)) | (1L << (INT8 - 129)) | (1L << (TINYINT - 129)) | (1L << (SMALLINT - 129)) | (1L << (INT - 129)) | (1L << (INTEGER - 129)) | (1L << (BIGINT - 129)) | (1L << (FLOAT4 - 129)) | (1L << (FLOAT8 - 129)) | (1L << (REAL - 129)) | (1L << (FLOAT - 129)) | (1L << (DOUBLE - 129)) | (1L << (NUMERIC - 129)) | (1L << (DECIMAL - 129)) | (1L << (CHAR - 129)) | (1L << (VARCHAR - 129)) | (1L << (NCHAR - 129)) | (1L << (NVARCHAR - 129)) | (1L << (DATE - 129)) | (1L << (TIME - 129)) | (1L << (TIMETZ - 129)) | (1L << (TIMESTAMP - 129)) | (1L << (TIMESTAMPTZ - 129)) | (1L << (TEXT - 129)))) != 0) || ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & ((1L << (VARBINARY - 193)) | (1L << (BLOB - 193)) | (1L << (BYTEA - 193)) | (1L << (INET4 - 193)) | (1L << (LEFT_PAREN - 193)) | (1L << (NUMBER - 193)) | (1L << (REAL_NUMBER - 193)) | (1L << (Identifier - 193)) | (1L << (Character_String_Literal - 193)))) != 0)) {
						{
						setState(1202); ((Trim_operandsContext)_localctx).trim_character = character_value_expression();
						}
					}

					setState(1205); match(FROM);
					}
					break;
				}
				setState(1208); ((Trim_operandsContext)_localctx).trim_source = character_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1209); ((Trim_operandsContext)_localctx).trim_source = character_value_expression();
				setState(1210); match(COMMA);
				setState(1211); ((Trim_operandsContext)_localctx).trim_character = character_value_expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 200, RULE_trim_specification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1215);
			_la = _input.LA(1);
			if ( !(((((_la - 9)) & ~0x3f) == 0 && ((1L << (_la - 9)) & ((1L << (BOTH - 9)) | (1L << (LEADING - 9)) | (1L << (TRAILING - 9)))) != 0)) ) {
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
		enterRule(_localctx, 202, RULE_boolean_value_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1217); or_predicate();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 204, RULE_or_predicate);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1219); and_predicate();
			setState(1224);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,117,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1220); match(OR);
					setState(1221); or_predicate();
					}
					} 
				}
				setState(1226);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,117,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 206, RULE_and_predicate);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1227); boolean_factor();
			setState(1232);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,118,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1228); match(AND);
					setState(1229); and_predicate();
					}
					} 
				}
				setState(1234);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,118,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 208, RULE_boolean_factor);
		try {
			setState(1238);
			switch ( getInterpreter().adaptivePredict(_input,119,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1235); boolean_test();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1236); match(NOT);
				setState(1237); boolean_test();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 210, RULE_boolean_test);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1240); boolean_primary();
			setState(1242);
			_la = _input.LA(1);
			if (_la==IS) {
				{
				setState(1241); is_clause();
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
		enterRule(_localctx, 212, RULE_is_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1244); match(IS);
			setState(1246);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(1245); match(NOT);
				}
			}

			setState(1248); ((Is_clauseContext)_localctx).t = truth_value();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 214, RULE_truth_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1250);
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
		enterRule(_localctx, 216, RULE_boolean_primary);
		try {
			setState(1254);
			switch ( getInterpreter().adaptivePredict(_input,122,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1252); predicate();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1253); boolean_predicand();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 218, RULE_boolean_predicand);
		try {
			setState(1258);
			switch ( getInterpreter().adaptivePredict(_input,123,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1256); parenthesized_boolean_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1257); nonparenthesized_value_expression_primary();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 220, RULE_parenthesized_boolean_value_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1260); match(LEFT_PAREN);
			setState(1261); boolean_value_expression();
			setState(1262); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 222, RULE_row_value_expression);
		try {
			setState(1266);
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
				setState(1264); row_value_special_case();
				}
				break;
			case NULL:
				enterOuterAlt(_localctx, 2);
				{
				setState(1265); explicit_row_value_constructor();
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
		enterRule(_localctx, 224, RULE_row_value_special_case);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1268); nonparenthesized_value_expression_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 226, RULE_explicit_row_value_constructor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1270); match(NULL);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 228, RULE_row_value_predicand);
		try {
			setState(1274);
			switch ( getInterpreter().adaptivePredict(_input,125,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1272); row_value_special_case();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1273); row_value_constructor_predicand();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 230, RULE_row_value_constructor_predicand);
		try {
			setState(1278);
			switch ( getInterpreter().adaptivePredict(_input,126,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1276); common_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1277); boolean_predicand();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 232, RULE_table_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1280); from_clause();
			setState(1282);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(1281); where_clause();
				}
			}

			setState(1285);
			_la = _input.LA(1);
			if (_la==GROUP) {
				{
				setState(1284); groupby_clause();
				}
			}

			setState(1288);
			_la = _input.LA(1);
			if (_la==HAVING) {
				{
				setState(1287); having_clause();
				}
			}

			setState(1291);
			_la = _input.LA(1);
			if (_la==ORDER) {
				{
				setState(1290); orderby_clause();
				}
			}

			setState(1294);
			_la = _input.LA(1);
			if (_la==LIMIT) {
				{
				setState(1293); limit_clause();
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
		enterRule(_localctx, 234, RULE_from_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1296); match(FROM);
			setState(1297); table_reference_list();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 236, RULE_table_reference_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1299); table_reference();
			setState(1304);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1300); match(COMMA);
				setState(1301); table_reference();
				}
				}
				setState(1306);
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
		enterRule(_localctx, 238, RULE_table_reference);
		try {
			setState(1309);
			switch ( getInterpreter().adaptivePredict(_input,133,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1307); joined_table();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1308); table_primary();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 240, RULE_joined_table);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1311); table_primary();
			setState(1313); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(1312); joined_table_primary();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1315); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,134,_ctx);
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
		enterRule(_localctx, 242, RULE_joined_table_primary);
		int _la;
		try {
			setState(1336);
			switch (_input.LA(1)) {
			case CROSS:
				enterOuterAlt(_localctx, 1);
				{
				setState(1317); match(CROSS);
				setState(1318); match(JOIN);
				setState(1319); ((Joined_table_primaryContext)_localctx).right = table_primary();
				}
				break;
			case FULL:
			case INNER:
			case JOIN:
			case LEFT:
			case RIGHT:
				enterOuterAlt(_localctx, 2);
				{
				setState(1321);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FULL) | (1L << INNER) | (1L << LEFT) | (1L << RIGHT))) != 0)) {
					{
					setState(1320); ((Joined_table_primaryContext)_localctx).t = join_type();
					}
				}

				setState(1323); match(JOIN);
				setState(1324); ((Joined_table_primaryContext)_localctx).right = table_primary();
				setState(1325); ((Joined_table_primaryContext)_localctx).s = join_specification();
				}
				break;
			case NATURAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(1327); match(NATURAL);
				setState(1329);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FULL) | (1L << INNER) | (1L << LEFT) | (1L << RIGHT))) != 0)) {
					{
					setState(1328); ((Joined_table_primaryContext)_localctx).t = join_type();
					}
				}

				setState(1331); match(JOIN);
				setState(1332); ((Joined_table_primaryContext)_localctx).right = table_primary();
				}
				break;
			case UNION:
				enterOuterAlt(_localctx, 4);
				{
				setState(1333); match(UNION);
				setState(1334); match(JOIN);
				setState(1335); ((Joined_table_primaryContext)_localctx).right = table_primary();
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
		enterRule(_localctx, 244, RULE_cross_join);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1338); match(CROSS);
			setState(1339); match(JOIN);
			setState(1340); ((Cross_joinContext)_localctx).r = table_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 246, RULE_qualified_join);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1343);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FULL) | (1L << INNER) | (1L << LEFT) | (1L << RIGHT))) != 0)) {
				{
				setState(1342); ((Qualified_joinContext)_localctx).t = join_type();
				}
			}

			setState(1345); match(JOIN);
			setState(1346); ((Qualified_joinContext)_localctx).r = table_primary();
			setState(1347); ((Qualified_joinContext)_localctx).s = join_specification();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 248, RULE_natural_join);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1349); match(NATURAL);
			setState(1351);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FULL) | (1L << INNER) | (1L << LEFT) | (1L << RIGHT))) != 0)) {
				{
				setState(1350); ((Natural_joinContext)_localctx).t = join_type();
				}
			}

			setState(1353); match(JOIN);
			setState(1354); ((Natural_joinContext)_localctx).r = table_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 250, RULE_union_join);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1356); match(UNION);
			setState(1357); match(JOIN);
			setState(1358); ((Union_joinContext)_localctx).r = table_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 252, RULE_join_type);
		try {
			setState(1362);
			switch (_input.LA(1)) {
			case INNER:
				enterOuterAlt(_localctx, 1);
				{
				setState(1360); match(INNER);
				}
				break;
			case FULL:
			case LEFT:
			case RIGHT:
				enterOuterAlt(_localctx, 2);
				{
				setState(1361); ((Join_typeContext)_localctx).t = outer_join_type();
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
		enterRule(_localctx, 254, RULE_outer_join_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1364); outer_join_type_part2();
			setState(1366);
			_la = _input.LA(1);
			if (_la==OUTER) {
				{
				setState(1365); match(OUTER);
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
		enterRule(_localctx, 256, RULE_outer_join_type_part2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1368);
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
		enterRule(_localctx, 258, RULE_join_specification);
		try {
			setState(1372);
			switch (_input.LA(1)) {
			case ON:
				enterOuterAlt(_localctx, 1);
				{
				setState(1370); join_condition();
				}
				break;
			case USING:
				enterOuterAlt(_localctx, 2);
				{
				setState(1371); named_columns_join();
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
		enterRule(_localctx, 260, RULE_join_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1374); match(ON);
			setState(1375); search_condition();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 262, RULE_named_columns_join);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1377); match(USING);
			setState(1378); match(LEFT_PAREN);
			setState(1379); ((Named_columns_joinContext)_localctx).f = column_reference_list();
			setState(1380); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 264, RULE_table_primary);
		int _la;
		try {
			setState(1406);
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
				setState(1382); table_or_query_name();
				setState(1387);
				switch ( getInterpreter().adaptivePredict(_input,144,_ctx) ) {
				case 1:
					{
					setState(1384);
					_la = _input.LA(1);
					if (_la==AS) {
						{
						setState(1383); match(AS);
						}
					}

					setState(1386); ((Table_primaryContext)_localctx).alias = identifier();
					}
					break;
				}
				setState(1393);
				switch ( getInterpreter().adaptivePredict(_input,145,_ctx) ) {
				case 1:
					{
					setState(1389); match(LEFT_PAREN);
					setState(1390); column_name_list();
					setState(1391); match(RIGHT_PAREN);
					}
					break;
				}
				}
				break;
			case LEFT_PAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(1395); derived_table();
				setState(1397);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(1396); match(AS);
					}
				}

				setState(1399); ((Table_primaryContext)_localctx).name = identifier();
				setState(1404);
				switch ( getInterpreter().adaptivePredict(_input,147,_ctx) ) {
				case 1:
					{
					setState(1400); match(LEFT_PAREN);
					setState(1401); column_name_list();
					setState(1402); match(RIGHT_PAREN);
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
		enterRule(_localctx, 266, RULE_column_name_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1408); identifier();
			setState(1413);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1409); match(COMMA);
				setState(1410); identifier();
				}
				}
				setState(1415);
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
		enterRule(_localctx, 268, RULE_derived_table);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1416); table_subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 270, RULE_where_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1418); match(WHERE);
			setState(1419); search_condition();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 272, RULE_search_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1421); value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 274, RULE_groupby_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1423); match(GROUP);
			setState(1424); match(BY);
			setState(1425); ((Groupby_clauseContext)_localctx).g = grouping_element_list();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 276, RULE_grouping_element_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1427); grouping_element();
			setState(1432);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1428); match(COMMA);
				setState(1429); grouping_element();
				}
				}
				setState(1434);
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
		enterRule(_localctx, 278, RULE_grouping_element);
		try {
			setState(1439);
			switch ( getInterpreter().adaptivePredict(_input,151,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1435); rollup_list();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1436); cube_list();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1437); empty_grouping_set();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1438); ordinary_grouping_set();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 280, RULE_ordinary_grouping_set);
		try {
			setState(1446);
			switch ( getInterpreter().adaptivePredict(_input,152,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1441); row_value_predicand();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1442); match(LEFT_PAREN);
				setState(1443); row_value_predicand_list();
				setState(1444); match(RIGHT_PAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 282, RULE_ordinary_grouping_set_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1448); ordinary_grouping_set();
			setState(1453);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1449); match(COMMA);
				setState(1450); ordinary_grouping_set();
				}
				}
				setState(1455);
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
		enterRule(_localctx, 284, RULE_rollup_list);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1456); match(ROLLUP);
			setState(1457); match(LEFT_PAREN);
			setState(1458); ((Rollup_listContext)_localctx).c = ordinary_grouping_set_list();
			setState(1459); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 286, RULE_cube_list);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1461); match(CUBE);
			setState(1462); match(LEFT_PAREN);
			setState(1463); ((Cube_listContext)_localctx).c = ordinary_grouping_set_list();
			setState(1464); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 288, RULE_empty_grouping_set);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1466); match(LEFT_PAREN);
			setState(1467); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 290, RULE_having_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1469); match(HAVING);
			setState(1470); boolean_value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 292, RULE_row_value_predicand_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1472); row_value_predicand();
			setState(1477);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1473); match(COMMA);
				setState(1474); row_value_predicand();
				}
				}
				setState(1479);
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
		enterRule(_localctx, 294, RULE_query_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1480); query_expression_body();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 296, RULE_query_expression_body);
		try {
			setState(1484);
			switch ( getInterpreter().adaptivePredict(_input,155,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1482); non_join_query_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1483); joined_table();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 298, RULE_non_join_query_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1494);
			switch ( getInterpreter().adaptivePredict(_input,157,_ctx) ) {
			case 1:
				{
				setState(1486); non_join_query_term();
				}
				break;
			case 2:
				{
				setState(1487); joined_table();
				setState(1488);
				_la = _input.LA(1);
				if ( !(_la==EXCEPT || _la==UNION) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(1490);
				_la = _input.LA(1);
				if (_la==ALL || _la==DISTINCT) {
					{
					setState(1489);
					_la = _input.LA(1);
					if ( !(_la==ALL || _la==DISTINCT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(1492); query_term();
				}
				break;
			}
			setState(1503);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==EXCEPT || _la==UNION) {
				{
				{
				setState(1496);
				_la = _input.LA(1);
				if ( !(_la==EXCEPT || _la==UNION) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(1498);
				_la = _input.LA(1);
				if (_la==ALL || _la==DISTINCT) {
					{
					setState(1497);
					_la = _input.LA(1);
					if ( !(_la==ALL || _la==DISTINCT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(1500); query_term();
				}
				}
				setState(1505);
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
		enterRule(_localctx, 300, RULE_query_term);
		try {
			setState(1508);
			switch ( getInterpreter().adaptivePredict(_input,160,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1506); non_join_query_term();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1507); joined_table();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 302, RULE_non_join_query_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1518);
			switch ( getInterpreter().adaptivePredict(_input,162,_ctx) ) {
			case 1:
				{
				setState(1510); non_join_query_primary();
				}
				break;
			case 2:
				{
				setState(1511); joined_table();
				setState(1512); match(INTERSECT);
				setState(1514);
				_la = _input.LA(1);
				if (_la==ALL || _la==DISTINCT) {
					{
					setState(1513);
					_la = _input.LA(1);
					if ( !(_la==ALL || _la==DISTINCT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(1516); query_primary();
				}
				break;
			}
			setState(1527);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==INTERSECT) {
				{
				{
				setState(1520); match(INTERSECT);
				setState(1522);
				_la = _input.LA(1);
				if (_la==ALL || _la==DISTINCT) {
					{
					setState(1521);
					_la = _input.LA(1);
					if ( !(_la==ALL || _la==DISTINCT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(1524); query_primary();
				}
				}
				setState(1529);
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
		enterRule(_localctx, 304, RULE_query_primary);
		try {
			setState(1532);
			switch ( getInterpreter().adaptivePredict(_input,165,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1530); non_join_query_primary();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1531); joined_table();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 306, RULE_non_join_query_primary);
		try {
			setState(1539);
			switch (_input.LA(1)) {
			case SELECT:
			case TABLE:
				enterOuterAlt(_localctx, 1);
				{
				setState(1534); simple_table();
				}
				break;
			case LEFT_PAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(1535); match(LEFT_PAREN);
				setState(1536); non_join_query_expression();
				setState(1537); match(RIGHT_PAREN);
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
		enterRule(_localctx, 308, RULE_simple_table);
		try {
			setState(1543);
			switch (_input.LA(1)) {
			case SELECT:
				enterOuterAlt(_localctx, 1);
				{
				setState(1541); query_specification();
				}
				break;
			case TABLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(1542); explicit_table();
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
		enterRule(_localctx, 310, RULE_explicit_table);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1545); match(TABLE);
			setState(1546); table_or_query_name();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 312, RULE_table_or_query_name);
		try {
			setState(1550);
			switch ( getInterpreter().adaptivePredict(_input,168,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1548); table_name();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1549); identifier();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 314, RULE_table_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1552); identifier();
			setState(1559);
			_la = _input.LA(1);
			if (_la==DOT) {
				{
				setState(1553); match(DOT);
				setState(1554); identifier();
				setState(1557);
				_la = _input.LA(1);
				if (_la==DOT) {
					{
					setState(1555); match(DOT);
					setState(1556); identifier();
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
		enterRule(_localctx, 316, RULE_query_specification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1561); match(SELECT);
			setState(1563);
			_la = _input.LA(1);
			if (_la==ALL || _la==DISTINCT) {
				{
				setState(1562); set_qualifier();
				}
			}

			setState(1565); select_list();
			setState(1567);
			_la = _input.LA(1);
			if (_la==FROM) {
				{
				setState(1566); table_expression();
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
		enterRule(_localctx, 318, RULE_select_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1569); select_sublist();
			setState(1574);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1570); match(COMMA);
				setState(1571); select_sublist();
				}
				}
				setState(1576);
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
		enterRule(_localctx, 320, RULE_select_sublist);
		try {
			setState(1579);
			switch ( getInterpreter().adaptivePredict(_input,174,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1577); derived_column();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1578); qualified_asterisk();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 322, RULE_derived_column);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1581); value_expression();
			setState(1583);
			switch ( getInterpreter().adaptivePredict(_input,175,_ctx) ) {
			case 1:
				{
				setState(1582); as_clause();
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
		enterRule(_localctx, 324, RULE_qualified_asterisk);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1587);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(1585); ((Qualified_asteriskContext)_localctx).tb_name = match(Identifier);
				setState(1586); match(DOT);
				}
			}

			setState(1589); match(MULTIPLY);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 326, RULE_set_qualifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1591);
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
		enterRule(_localctx, 328, RULE_column_reference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1596);
			switch ( getInterpreter().adaptivePredict(_input,177,_ctx) ) {
			case 1:
				{
				setState(1593); ((Column_referenceContext)_localctx).tb_name = identifier();
				setState(1594); match(DOT);
				}
				break;
			}
			setState(1598); ((Column_referenceContext)_localctx).name = identifier();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 330, RULE_as_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1601);
			_la = _input.LA(1);
			if (_la==AS) {
				{
				setState(1600); match(AS);
				}
			}

			setState(1603); identifier();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 332, RULE_column_reference_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1605); column_reference();
			setState(1610);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1606); match(COMMA);
				setState(1607); column_reference();
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
		enterRule(_localctx, 334, RULE_scalar_subquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1613); subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 336, RULE_row_subquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1615); subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 338, RULE_table_subquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1617); subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 340, RULE_subquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1619); match(LEFT_PAREN);
			setState(1620); query_expression();
			setState(1621); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 342, RULE_predicate);
		try {
			setState(1629);
			switch ( getInterpreter().adaptivePredict(_input,180,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1623); comparison_predicate();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1624); between_predicate();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1625); in_predicate();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1626); pattern_matching_predicate();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1627); null_predicate();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1628); exists_predicate();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 344, RULE_comparison_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1631); ((Comparison_predicateContext)_localctx).left = row_value_predicand();
			setState(1632); ((Comparison_predicateContext)_localctx).c = comp_op();
			setState(1633); ((Comparison_predicateContext)_localctx).right = row_value_predicand();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 346, RULE_comp_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1635);
			_la = _input.LA(1);
			if ( !(((((_la - 203)) & ~0x3f) == 0 && ((1L << (_la - 203)) & ((1L << (EQUAL - 203)) | (1L << (NOT_EQUAL - 203)) | (1L << (LTH - 203)) | (1L << (LEQ - 203)) | (1L << (GTH - 203)) | (1L << (GEQ - 203)))) != 0)) ) {
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
		enterRule(_localctx, 348, RULE_between_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1637); ((Between_predicateContext)_localctx).predicand = row_value_predicand();
			setState(1638); between_predicate_part_2();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 350, RULE_between_predicate_part_2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1641);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(1640); match(NOT);
				}
			}

			setState(1643); match(BETWEEN);
			setState(1645);
			_la = _input.LA(1);
			if (_la==ASYMMETRIC || _la==SYMMETRIC) {
				{
				setState(1644);
				_la = _input.LA(1);
				if ( !(_la==ASYMMETRIC || _la==SYMMETRIC) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(1647); ((Between_predicate_part_2Context)_localctx).begin = row_value_predicand();
			setState(1648); match(AND);
			setState(1649); ((Between_predicate_part_2Context)_localctx).end = row_value_predicand();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 352, RULE_in_predicate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1651); ((In_predicateContext)_localctx).predicand = numeric_value_expression();
			setState(1653);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(1652); match(NOT);
				}
			}

			setState(1655); match(IN);
			setState(1656); in_predicate_value();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 354, RULE_in_predicate_value);
		try {
			setState(1663);
			switch ( getInterpreter().adaptivePredict(_input,184,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1658); table_subquery();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1659); match(LEFT_PAREN);
				setState(1660); in_value_list();
				setState(1661); match(RIGHT_PAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 356, RULE_in_value_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1665); row_value_expression();
			setState(1670);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1666); match(COMMA);
				setState(1667); row_value_expression();
				}
				}
				setState(1672);
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
		enterRule(_localctx, 358, RULE_pattern_matching_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1673); ((Pattern_matching_predicateContext)_localctx).f = row_value_predicand();
			setState(1674); pattern_matcher();
			setState(1675); ((Pattern_matching_predicateContext)_localctx).s = match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 360, RULE_pattern_matcher);
		int _la;
		try {
			setState(1682);
			switch (_input.LA(1)) {
			case ILIKE:
			case LIKE:
			case NOT:
			case REGEXP:
			case RLIKE:
			case SIMILAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(1678);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(1677); match(NOT);
					}
				}

				setState(1680); negativable_matcher();
				}
				break;
			case Similar_To:
			case Not_Similar_To:
			case Similar_To_Case_Insensitive:
			case Not_Similar_To_Case_Insensitive:
				enterOuterAlt(_localctx, 2);
				{
				setState(1681); regex_matcher();
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
		enterRule(_localctx, 362, RULE_negativable_matcher);
		try {
			setState(1690);
			switch (_input.LA(1)) {
			case LIKE:
				enterOuterAlt(_localctx, 1);
				{
				setState(1684); match(LIKE);
				}
				break;
			case ILIKE:
				enterOuterAlt(_localctx, 2);
				{
				setState(1685); match(ILIKE);
				}
				break;
			case SIMILAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(1686); match(SIMILAR);
				setState(1687); match(TO);
				}
				break;
			case REGEXP:
				enterOuterAlt(_localctx, 4);
				{
				setState(1688); match(REGEXP);
				}
				break;
			case RLIKE:
				enterOuterAlt(_localctx, 5);
				{
				setState(1689); match(RLIKE);
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
		enterRule(_localctx, 364, RULE_regex_matcher);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1692);
			_la = _input.LA(1);
			if ( !(((((_la - 197)) & ~0x3f) == 0 && ((1L << (_la - 197)) & ((1L << (Similar_To - 197)) | (1L << (Not_Similar_To - 197)) | (1L << (Similar_To_Case_Insensitive - 197)) | (1L << (Not_Similar_To_Case_Insensitive - 197)))) != 0)) ) {
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
		enterRule(_localctx, 366, RULE_null_predicate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1694); ((Null_predicateContext)_localctx).predicand = row_value_predicand();
			setState(1695); match(IS);
			setState(1697);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(1696); ((Null_predicateContext)_localctx).n = match(NOT);
				}
			}

			setState(1699); match(NULL);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 368, RULE_quantified_comparison_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1701); ((Quantified_comparison_predicateContext)_localctx).l = numeric_value_expression();
			setState(1702); ((Quantified_comparison_predicateContext)_localctx).c = comp_op();
			setState(1703); ((Quantified_comparison_predicateContext)_localctx).q = quantifier();
			setState(1704); ((Quantified_comparison_predicateContext)_localctx).s = table_subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 370, RULE_quantifier);
		try {
			setState(1708);
			switch (_input.LA(1)) {
			case ALL:
				enterOuterAlt(_localctx, 1);
				{
				setState(1706); all();
				}
				break;
			case ANY:
			case SOME:
				enterOuterAlt(_localctx, 2);
				{
				setState(1707); some();
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
		enterRule(_localctx, 372, RULE_all);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1710); match(ALL);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 374, RULE_some);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1712);
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
		enterRule(_localctx, 376, RULE_exists_predicate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1715);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(1714); match(NOT);
				}
			}

			setState(1717); match(EXISTS);
			setState(1718); ((Exists_predicateContext)_localctx).s = table_subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 378, RULE_unique_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1720); match(UNIQUE);
			setState(1721); ((Unique_predicateContext)_localctx).s = table_subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 380, RULE_primary_datetime_field);
		try {
			setState(1725);
			switch (_input.LA(1)) {
			case DAY:
			case HOUR:
			case MINUTE:
			case MONTH:
			case YEAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(1723); non_second_primary_datetime_field();
				}
				break;
			case SECOND:
				enterOuterAlt(_localctx, 2);
				{
				setState(1724); match(SECOND);
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
		enterRule(_localctx, 382, RULE_non_second_primary_datetime_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1727);
			_la = _input.LA(1);
			if ( !(((((_la - 92)) & ~0x3f) == 0 && ((1L << (_la - 92)) & ((1L << (DAY - 92)) | (1L << (HOUR - 92)) | (1L << (MINUTE - 92)) | (1L << (MONTH - 92)))) != 0) || _la==YEAR) ) {
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
		enterRule(_localctx, 384, RULE_extended_datetime_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1729);
			_la = _input.LA(1);
			if ( !(((((_la - 85)) & ~0x3f) == 0 && ((1L << (_la - 85)) & ((1L << (CENTURY - 85)) | (1L << (DECADE - 85)) | (1L << (DOW - 85)) | (1L << (DOY - 85)) | (1L << (EPOCH - 85)) | (1L << (ISODOW - 85)) | (1L << (ISOYEAR - 85)) | (1L << (MICROSECONDS - 85)) | (1L << (MILLENNIUM - 85)) | (1L << (MILLISECONDS - 85)) | (1L << (QUARTER - 85)))) != 0) || _la==WEEK) ) {
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
		enterRule(_localctx, 386, RULE_routine_invocation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1731); function_name();
			setState(1732); match(LEFT_PAREN);
			setState(1734);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ANY) | (1L << CASE) | (1L << CAST) | (1L << FALSE) | (1L << LEFT) | (1L << NOT) | (1L << NULL) | (1L << RIGHT))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (SOME - 65)) | (1L << (TRUE - 65)) | (1L << (AVG - 65)) | (1L << (BETWEEN - 65)) | (1L << (BY - 65)) | (1L << (CENTURY - 65)) | (1L << (CHARACTER - 65)) | (1L << (COLLECT - 65)) | (1L << (COALESCE - 65)) | (1L << (COLUMN - 65)) | (1L << (COUNT - 65)) | (1L << (CUBE - 65)) | (1L << (DAY - 65)) | (1L << (DEC - 65)) | (1L << (DECADE - 65)) | (1L << (DOW - 65)) | (1L << (DOY - 65)) | (1L << (DROP - 65)) | (1L << (EPOCH - 65)) | (1L << (EVERY - 65)) | (1L << (EXISTS - 65)) | (1L << (EXTERNAL - 65)) | (1L << (EXTRACT - 65)) | (1L << (FILTER - 65)) | (1L << (FIRST - 65)) | (1L << (FORMAT - 65)) | (1L << (FUSION - 65)) | (1L << (GROUPING - 65)) | (1L << (HASH - 65)) | (1L << (INDEX - 65)) | (1L << (INSERT - 65)) | (1L << (INTERSECTION - 65)) | (1L << (ISODOW - 65)) | (1L << (ISOYEAR - 65)) | (1L << (LAST - 65)) | (1L << (LESS - 65)) | (1L << (LIST - 65)) | (1L << (LOCATION - 65)) | (1L << (MAX - 65)) | (1L << (MAXVALUE - 65)) | (1L << (MICROSECONDS - 65)) | (1L << (MILLENNIUM - 65)) | (1L << (MILLISECONDS - 65)) | (1L << (MIN - 65)) | (1L << (MINUTE - 65)) | (1L << (MONTH - 65)) | (1L << (NATIONAL - 65)) | (1L << (NULLIF - 65)))) != 0) || ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (OVERWRITE - 129)) | (1L << (PARTITION - 129)) | (1L << (PARTITIONS - 129)) | (1L << (PRECISION - 129)) | (1L << (PURGE - 129)) | (1L << (QUARTER - 129)) | (1L << (RANGE - 129)) | (1L << (REGEXP - 129)) | (1L << (RLIKE - 129)) | (1L << (ROLLUP - 129)) | (1L << (SECOND - 129)) | (1L << (SET - 129)) | (1L << (SIMILAR - 129)) | (1L << (STDDEV_POP - 129)) | (1L << (STDDEV_SAMP - 129)) | (1L << (SUBPARTITION - 129)) | (1L << (SUM - 129)) | (1L << (TABLESPACE - 129)) | (1L << (THAN - 129)) | (1L << (TIMEZONE - 129)) | (1L << (TIMEZONE_HOUR - 129)) | (1L << (TIMEZONE_MINUTE - 129)) | (1L << (TRIM - 129)) | (1L << (TO - 129)) | (1L << (UNKNOWN - 129)) | (1L << (VALUES - 129)) | (1L << (VAR_SAMP - 129)) | (1L << (VAR_POP - 129)) | (1L << (VARYING - 129)) | (1L << (WEEK - 129)) | (1L << (YEAR - 129)) | (1L << (ZONE - 129)) | (1L << (BOOLEAN - 129)) | (1L << (BOOL - 129)) | (1L << (BIT - 129)) | (1L << (VARBIT - 129)) | (1L << (INT1 - 129)) | (1L << (INT2 - 129)) | (1L << (INT4 - 129)) | (1L << (INT8 - 129)) | (1L << (TINYINT - 129)) | (1L << (SMALLINT - 129)) | (1L << (INT - 129)) | (1L << (INTEGER - 129)) | (1L << (BIGINT - 129)) | (1L << (FLOAT4 - 129)) | (1L << (FLOAT8 - 129)) | (1L << (REAL - 129)) | (1L << (FLOAT - 129)) | (1L << (DOUBLE - 129)) | (1L << (NUMERIC - 129)) | (1L << (DECIMAL - 129)) | (1L << (CHAR - 129)) | (1L << (VARCHAR - 129)) | (1L << (NCHAR - 129)) | (1L << (NVARCHAR - 129)) | (1L << (DATE - 129)) | (1L << (TIME - 129)) | (1L << (TIMETZ - 129)) | (1L << (TIMESTAMP - 129)) | (1L << (TIMESTAMPTZ - 129)) | (1L << (TEXT - 129)))) != 0) || ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & ((1L << (VARBINARY - 193)) | (1L << (BLOB - 193)) | (1L << (BYTEA - 193)) | (1L << (INET4 - 193)) | (1L << (LEFT_PAREN - 193)) | (1L << (PLUS - 193)) | (1L << (MINUS - 193)) | (1L << (NUMBER - 193)) | (1L << (REAL_NUMBER - 193)) | (1L << (Identifier - 193)) | (1L << (Character_String_Literal - 193)))) != 0)) {
				{
				setState(1733); sql_argument_list();
				}
			}

			setState(1736); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 388, RULE_function_names_for_reserved_words);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1738);
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
		enterRule(_localctx, 390, RULE_function_name);
		try {
			setState(1742);
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
				setState(1740); identifier();
				}
				break;
			case LEFT:
			case RIGHT:
				enterOuterAlt(_localctx, 2);
				{
				setState(1741); function_names_for_reserved_words();
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
		enterRule(_localctx, 392, RULE_sql_argument_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1744); value_expression();
			setState(1749);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1745); match(COMMA);
				setState(1746); value_expression();
				}
				}
				setState(1751);
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
		enterRule(_localctx, 394, RULE_orderby_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1752); match(ORDER);
			setState(1753); match(BY);
			setState(1754); sort_specifier_list();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 396, RULE_sort_specifier_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1756); sort_specifier();
			setState(1761);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1757); match(COMMA);
				setState(1758); sort_specifier();
				}
				}
				setState(1763);
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
		enterRule(_localctx, 398, RULE_sort_specifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1764); ((Sort_specifierContext)_localctx).key = row_value_predicand();
			setState(1766);
			_la = _input.LA(1);
			if (_la==ASC || _la==DESC) {
				{
				setState(1765); ((Sort_specifierContext)_localctx).order = order_specification();
				}
			}

			setState(1769);
			_la = _input.LA(1);
			if (_la==NULL) {
				{
				setState(1768); ((Sort_specifierContext)_localctx).null_order = null_ordering();
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
		enterRule(_localctx, 400, RULE_order_specification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1771);
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
		enterRule(_localctx, 402, RULE_limit_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1773); match(LIMIT);
			setState(1774); ((Limit_clauseContext)_localctx).e = numeric_value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 404, RULE_null_ordering);
		try {
			setState(1780);
			switch ( getInterpreter().adaptivePredict(_input,199,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1776); match(NULL);
				setState(1777); match(FIRST);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1778); match(NULL);
				setState(1779); match(LAST);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 406, RULE_insert_statement);
		int _la;
		try {
			setState(1811);
			switch ( getInterpreter().adaptivePredict(_input,205,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1782); match(INSERT);
				setState(1784);
				_la = _input.LA(1);
				if (_la==OVERWRITE) {
					{
					setState(1783); match(OVERWRITE);
					}
				}

				setState(1786); match(INTO);
				setState(1787); table_name();
				setState(1792);
				switch ( getInterpreter().adaptivePredict(_input,201,_ctx) ) {
				case 1:
					{
					setState(1788); match(LEFT_PAREN);
					setState(1789); column_name_list();
					setState(1790); match(RIGHT_PAREN);
					}
					break;
				}
				setState(1794); query_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1796); match(INSERT);
				setState(1798);
				_la = _input.LA(1);
				if (_la==OVERWRITE) {
					{
					setState(1797); match(OVERWRITE);
					}
				}

				setState(1800); match(INTO);
				setState(1801); match(LOCATION);
				setState(1802); ((Insert_statementContext)_localctx).path = match(Character_String_Literal);
				setState(1808);
				_la = _input.LA(1);
				if (_la==USING) {
					{
					setState(1803); match(USING);
					setState(1804); ((Insert_statementContext)_localctx).file_type = identifier();
					setState(1806);
					_la = _input.LA(1);
					if (_la==WITH) {
						{
						setState(1805); param_clause();
						}
					}

					}
				}

				setState(1810); query_expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\u00eb\u0718\4\2\t"+
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
		"\t\u00cd\3\2\3\2\5\2\u019d\n\2\6\2\u019f\n\2\r\2\16\2\u01a0\3\2\3\2\3"+
		"\3\3\3\3\3\3\3\3\3\5\3\u01aa\n\3\3\4\3\4\3\5\3\5\3\6\3\6\5\6\u01b2\n\6"+
		"\3\7\3\7\5\7\u01b6\n\7\3\7\3\7\3\7\3\7\3\7\5\7\u01bd\n\7\3\7\3\7\3\7\3"+
		"\7\5\7\u01c3\n\7\3\b\3\b\3\b\3\b\3\b\5\b\u01ca\n\b\3\b\3\b\5\b\u01ce\n"+
		"\b\3\b\3\b\5\b\u01d2\n\b\3\b\3\b\5\b\u01d6\n\b\3\b\3\b\5\b\u01da\n\b\3"+
		"\t\3\t\5\t\u01de\n\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u01e6\n\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\5\t\u01ef\n\t\6\t\u01f1\n\t\r\t\16\t\u01f2\5\t\u01f5"+
		"\n\t\5\t\u01f7\n\t\3\t\3\t\3\t\3\t\5\t\u01fd\n\t\3\t\3\t\3\t\5\t\u0202"+
		"\n\t\3\t\3\t\3\t\3\t\5\t\u0208\n\t\3\t\3\t\5\t\u020c\n\t\3\t\3\t\5\t\u0210"+
		"\n\t\3\t\3\t\5\t\u0214\n\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u021c\n\t\5\t\u021e"+
		"\n\t\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u022c"+
		"\n\13\3\13\5\13\u022f\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\5\13\u023a\n\13\3\13\5\13\u023d\n\13\3\13\5\13\u0240\n\13\3\13\3\13\5"+
		"\13\u0244\n\13\3\13\3\13\3\13\3\13\3\13\5\13\u024b\n\13\3\13\5\13\u024e"+
		"\n\13\3\13\5\13\u0251\n\13\3\13\3\13\3\13\5\13\u0256\n\13\3\f\3\f\3\f"+
		"\3\f\7\f\u025c\n\f\f\f\16\f\u025f\13\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3"+
		"\17\3\17\3\17\3\17\3\17\7\17\u026d\n\17\f\17\16\17\u0270\13\17\3\17\3"+
		"\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\24\3"+
		"\24\3\24\3\24\5\24\u0284\n\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\26\3\26\3\26\7\26\u0293\n\26\f\26\16\26\u0296\13\26\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u02a2\n\27\3\27\3\27"+
		"\5\27\u02a6\n\27\5\27\u02a8\n\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3"+
		"\30\3\30\3\30\3\30\5\30\u02b5\n\30\3\31\3\31\3\31\7\31\u02ba\n\31\f\31"+
		"\16\31\u02bd\13\31\3\32\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3"+
		"\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\7\35\u02d2\n\35\f\35\16\35"+
		"\u02d5\13\35\3\36\3\36\3\36\3\36\5\36\u02db\n\36\3\36\3\36\3\36\3\36\3"+
		"\37\3\37\3\37\3\37\3\37\3 \3 \3!\3!\3!\3!\5!\u02ec\n!\3\"\3\"\5\"\u02f0"+
		"\n\"\3#\3#\3$\3$\5$\u02f6\n$\3%\3%\3%\5%\u02fb\n%\3&\3&\3&\5&\u0300\n"+
		"&\3\'\3\'\3\'\3(\3(\3(\3)\3)\3)\3*\3*\3+\3+\3,\3,\3,\3,\3,\3,\3,\3,\3"+
		",\5,\u0318\n,\3-\3-\3.\3.\5.\u031e\n.\3.\3.\5.\u0322\n.\3.\3.\3.\5.\u0327"+
		"\n.\3.\3.\3.\5.\u032c\n.\3.\3.\5.\u0330\n.\3.\5.\u0333\n.\3/\3/\3/\3/"+
		"\3\60\3\60\3\60\5\60\u033c\n\60\3\60\3\60\3\60\5\60\u0341\n\60\3\60\3"+
		"\60\5\60\u0345\n\60\3\60\3\60\3\60\3\60\5\60\u034b\n\60\3\60\3\60\3\60"+
		"\3\60\5\60\u0351\n\60\3\60\3\60\3\60\5\60\u0356\n\60\3\60\3\60\5\60\u035a"+
		"\n\60\5\60\u035c\n\60\3\61\3\61\5\61\u0360\n\61\3\61\3\61\5\61\u0364\n"+
		"\61\5\61\u0366\n\61\3\62\3\62\5\62\u036a\n\62\3\63\3\63\5\63\u036e\n\63"+
		"\3\63\3\63\5\63\u0372\n\63\3\63\3\63\5\63\u0376\n\63\3\63\3\63\3\63\3"+
		"\63\3\63\3\63\3\63\3\63\3\63\5\63\u0381\n\63\3\64\3\64\5\64\u0385\n\64"+
		"\3\64\3\64\3\64\3\64\3\64\3\64\5\64\u038d\n\64\3\65\3\65\3\65\3\65\3\65"+
		"\3\65\3\65\3\65\5\65\u0397\n\65\3\66\3\66\3\67\3\67\3\67\3\67\3\67\3\67"+
		"\3\67\3\67\3\67\3\67\3\67\3\67\3\67\5\67\u03a8\n\67\38\38\58\u03ac\n8"+
		"\38\38\58\u03b0\n8\38\38\38\58\u03b5\n8\58\u03b7\n8\39\39\59\u03bb\n9"+
		"\39\39\39\59\u03c0\n9\39\39\59\u03c4\n9\59\u03c6\n9\3:\3:\5:\u03ca\n:"+
		"\3;\3;\3;\3;\3<\3<\3<\3<\3<\3<\3<\5<\u03d7\n<\3=\3=\3>\3>\3?\5?\u03de"+
		"\n?\3?\3?\3@\3@\3A\3A\3A\3A\3A\3A\5A\u03ea\nA\5A\u03ec\nA\3B\3B\3B\5B"+
		"\u03f1\nB\3B\3B\3B\3C\3C\3D\3D\3D\3D\3D\3D\3E\3E\3E\3E\3E\3F\3F\3G\3G"+
		"\3G\3G\3G\3G\3G\3G\3G\3G\3G\3G\6G\u0411\nG\rG\16G\u0412\3G\3G\5G\u0417"+
		"\nG\3H\3H\5H\u041b\nH\3I\3I\3I\6I\u0420\nI\rI\16I\u0421\3I\5I\u0425\n"+
		"I\3I\3I\3J\3J\6J\u042b\nJ\rJ\16J\u042c\3J\5J\u0430\nJ\3J\3J\3K\3K\3K\3"+
		"K\3K\3L\3L\3L\3L\3L\3M\3M\3M\3N\3N\5N\u0443\nN\3O\3O\3O\3O\3O\3O\3O\3"+
		"P\3P\3Q\3Q\3R\3R\3R\5R\u0453\nR\3S\3S\3S\5S\u0458\nS\3T\3T\3T\7T\u045d"+
		"\nT\fT\16T\u0460\13T\3U\3U\3U\7U\u0465\nU\fU\16U\u0468\13U\3V\5V\u046b"+
		"\nV\3V\3V\3W\3W\3W\3W\7W\u0473\nW\fW\16W\u0476\13W\3W\3W\3X\3X\3X\7X\u047d"+
		"\nX\fX\16X\u0480\13X\3X\5X\u0483\nX\3Y\3Y\3Z\3Z\3[\3[\3[\3[\3[\3[\3[\3"+
		"\\\3\\\3\\\5\\\u0493\n\\\3]\3]\3^\3^\5^\u0499\n^\3_\3_\3`\3`\3`\7`\u04a0"+
		"\n`\f`\16`\u04a3\13`\3a\3a\3b\3b\5b\u04a9\nb\3c\3c\3d\3d\3d\3d\3d\3e\5"+
		"e\u04b3\ne\3e\5e\u04b6\ne\3e\5e\u04b9\ne\3e\3e\3e\3e\3e\5e\u04c0\ne\3"+
		"f\3f\3g\3g\3h\3h\3h\7h\u04c9\nh\fh\16h\u04cc\13h\3i\3i\3i\7i\u04d1\ni"+
		"\fi\16i\u04d4\13i\3j\3j\3j\5j\u04d9\nj\3k\3k\5k\u04dd\nk\3l\3l\5l\u04e1"+
		"\nl\3l\3l\3m\3m\3n\3n\5n\u04e9\nn\3o\3o\5o\u04ed\no\3p\3p\3p\3p\3q\3q"+
		"\5q\u04f5\nq\3r\3r\3s\3s\3t\3t\5t\u04fd\nt\3u\3u\5u\u0501\nu\3v\3v\5v"+
		"\u0505\nv\3v\5v\u0508\nv\3v\5v\u050b\nv\3v\5v\u050e\nv\3v\5v\u0511\nv"+
		"\3w\3w\3w\3x\3x\3x\7x\u0519\nx\fx\16x\u051c\13x\3y\3y\5y\u0520\ny\3z\3"+
		"z\6z\u0524\nz\rz\16z\u0525\3{\3{\3{\3{\5{\u052c\n{\3{\3{\3{\3{\3{\3{\5"+
		"{\u0534\n{\3{\3{\3{\3{\3{\5{\u053b\n{\3|\3|\3|\3|\3}\5}\u0542\n}\3}\3"+
		"}\3}\3}\3~\3~\5~\u054a\n~\3~\3~\3~\3\177\3\177\3\177\3\177\3\u0080\3\u0080"+
		"\5\u0080\u0555\n\u0080\3\u0081\3\u0081\5\u0081\u0559\n\u0081\3\u0082\3"+
		"\u0082\3\u0083\3\u0083\5\u0083\u055f\n\u0083\3\u0084\3\u0084\3\u0084\3"+
		"\u0085\3\u0085\3\u0085\3\u0085\3\u0085\3\u0086\3\u0086\5\u0086\u056b\n"+
		"\u0086\3\u0086\5\u0086\u056e\n\u0086\3\u0086\3\u0086\3\u0086\3\u0086\5"+
		"\u0086\u0574\n\u0086\3\u0086\3\u0086\5\u0086\u0578\n\u0086\3\u0086\3\u0086"+
		"\3\u0086\3\u0086\3\u0086\5\u0086\u057f\n\u0086\5\u0086\u0581\n\u0086\3"+
		"\u0087\3\u0087\3\u0087\7\u0087\u0586\n\u0087\f\u0087\16\u0087\u0589\13"+
		"\u0087\3\u0088\3\u0088\3\u0089\3\u0089\3\u0089\3\u008a\3\u008a\3\u008b"+
		"\3\u008b\3\u008b\3\u008b\3\u008c\3\u008c\3\u008c\7\u008c\u0599\n\u008c"+
		"\f\u008c\16\u008c\u059c\13\u008c\3\u008d\3\u008d\3\u008d\3\u008d\5\u008d"+
		"\u05a2\n\u008d\3\u008e\3\u008e\3\u008e\3\u008e\3\u008e\5\u008e\u05a9\n"+
		"\u008e\3\u008f\3\u008f\3\u008f\7\u008f\u05ae\n\u008f\f\u008f\16\u008f"+
		"\u05b1\13\u008f\3\u0090\3\u0090\3\u0090\3\u0090\3\u0090\3\u0091\3\u0091"+
		"\3\u0091\3\u0091\3\u0091\3\u0092\3\u0092\3\u0092\3\u0093\3\u0093\3\u0093"+
		"\3\u0094\3\u0094\3\u0094\7\u0094\u05c6\n\u0094\f\u0094\16\u0094\u05c9"+
		"\13\u0094\3\u0095\3\u0095\3\u0096\3\u0096\5\u0096\u05cf\n\u0096\3\u0097"+
		"\3\u0097\3\u0097\3\u0097\5\u0097\u05d5\n\u0097\3\u0097\3\u0097\5\u0097"+
		"\u05d9\n\u0097\3\u0097\3\u0097\5\u0097\u05dd\n\u0097\3\u0097\7\u0097\u05e0"+
		"\n\u0097\f\u0097\16\u0097\u05e3\13\u0097\3\u0098\3\u0098\5\u0098\u05e7"+
		"\n\u0098\3\u0099\3\u0099\3\u0099\3\u0099\5\u0099\u05ed\n\u0099\3\u0099"+
		"\3\u0099\5\u0099\u05f1\n\u0099\3\u0099\3\u0099\5\u0099\u05f5\n\u0099\3"+
		"\u0099\7\u0099\u05f8\n\u0099\f\u0099\16\u0099\u05fb\13\u0099\3\u009a\3"+
		"\u009a\5\u009a\u05ff\n\u009a\3\u009b\3\u009b\3\u009b\3\u009b\3\u009b\5"+
		"\u009b\u0606\n\u009b\3\u009c\3\u009c\5\u009c\u060a\n\u009c\3\u009d\3\u009d"+
		"\3\u009d\3\u009e\3\u009e\5\u009e\u0611\n\u009e\3\u009f\3\u009f\3\u009f"+
		"\3\u009f\3\u009f\5\u009f\u0618\n\u009f\5\u009f\u061a\n\u009f\3\u00a0\3"+
		"\u00a0\5\u00a0\u061e\n\u00a0\3\u00a0\3\u00a0\5\u00a0\u0622\n\u00a0\3\u00a1"+
		"\3\u00a1\3\u00a1\7\u00a1\u0627\n\u00a1\f\u00a1\16\u00a1\u062a\13\u00a1"+
		"\3\u00a2\3\u00a2\5\u00a2\u062e\n\u00a2\3\u00a3\3\u00a3\5\u00a3\u0632\n"+
		"\u00a3\3\u00a4\3\u00a4\5\u00a4\u0636\n\u00a4\3\u00a4\3\u00a4\3\u00a5\3"+
		"\u00a5\3\u00a6\3\u00a6\3\u00a6\5\u00a6\u063f\n\u00a6\3\u00a6\3\u00a6\3"+
		"\u00a7\5\u00a7\u0644\n\u00a7\3\u00a7\3\u00a7\3\u00a8\3\u00a8\3\u00a8\7"+
		"\u00a8\u064b\n\u00a8\f\u00a8\16\u00a8\u064e\13\u00a8\3\u00a9\3\u00a9\3"+
		"\u00aa\3\u00aa\3\u00ab\3\u00ab\3\u00ac\3\u00ac\3\u00ac\3\u00ac\3\u00ad"+
		"\3\u00ad\3\u00ad\3\u00ad\3\u00ad\3\u00ad\5\u00ad\u0660\n\u00ad\3\u00ae"+
		"\3\u00ae\3\u00ae\3\u00ae\3\u00af\3\u00af\3\u00b0\3\u00b0\3\u00b0\3\u00b1"+
		"\5\u00b1\u066c\n\u00b1\3\u00b1\3\u00b1\5\u00b1\u0670\n\u00b1\3\u00b1\3"+
		"\u00b1\3\u00b1\3\u00b1\3\u00b2\3\u00b2\5\u00b2\u0678\n\u00b2\3\u00b2\3"+
		"\u00b2\3\u00b2\3\u00b3\3\u00b3\3\u00b3\3\u00b3\3\u00b3\5\u00b3\u0682\n"+
		"\u00b3\3\u00b4\3\u00b4\3\u00b4\7\u00b4\u0687\n\u00b4\f\u00b4\16\u00b4"+
		"\u068a\13\u00b4\3\u00b5\3\u00b5\3\u00b5\3\u00b5\3\u00b6\5\u00b6\u0691"+
		"\n\u00b6\3\u00b6\3\u00b6\5\u00b6\u0695\n\u00b6\3\u00b7\3\u00b7\3\u00b7"+
		"\3\u00b7\3\u00b7\3\u00b7\5\u00b7\u069d\n\u00b7\3\u00b8\3\u00b8\3\u00b9"+
		"\3\u00b9\3\u00b9\5\u00b9\u06a4\n\u00b9\3\u00b9\3\u00b9\3\u00ba\3\u00ba"+
		"\3\u00ba\3\u00ba\3\u00ba\3\u00bb\3\u00bb\5\u00bb\u06af\n\u00bb\3\u00bc"+
		"\3\u00bc\3\u00bd\3\u00bd\3\u00be\5\u00be\u06b6\n\u00be\3\u00be\3\u00be"+
		"\3\u00be\3\u00bf\3\u00bf\3\u00bf\3\u00c0\3\u00c0\5\u00c0\u06c0\n\u00c0"+
		"\3\u00c1\3\u00c1\3\u00c2\3\u00c2\3\u00c3\3\u00c3\3\u00c3\5\u00c3\u06c9"+
		"\n\u00c3\3\u00c3\3\u00c3\3\u00c4\3\u00c4\3\u00c5\3\u00c5\5\u00c5\u06d1"+
		"\n\u00c5\3\u00c6\3\u00c6\3\u00c6\7\u00c6\u06d6\n\u00c6\f\u00c6\16\u00c6"+
		"\u06d9\13\u00c6\3\u00c7\3\u00c7\3\u00c7\3\u00c7\3\u00c8\3\u00c8\3\u00c8"+
		"\7\u00c8\u06e2\n\u00c8\f\u00c8\16\u00c8\u06e5\13\u00c8\3\u00c9\3\u00c9"+
		"\5\u00c9\u06e9\n\u00c9\3\u00c9\5\u00c9\u06ec\n\u00c9\3\u00ca\3\u00ca\3"+
		"\u00cb\3\u00cb\3\u00cb\3\u00cc\3\u00cc\3\u00cc\3\u00cc\5\u00cc\u06f7\n"+
		"\u00cc\3\u00cd\3\u00cd\5\u00cd\u06fb\n\u00cd\3\u00cd\3\u00cd\3\u00cd\3"+
		"\u00cd\3\u00cd\3\u00cd\5\u00cd\u0703\n\u00cd\3\u00cd\3\u00cd\3\u00cd\3"+
		"\u00cd\5\u00cd\u0709\n\u00cd\3\u00cd\3\u00cd\3\u00cd\3\u00cd\3\u00cd\3"+
		"\u00cd\5\u00cd\u0711\n\u00cd\5\u00cd\u0713\n\u00cd\3\u00cd\5\u00cd\u0716"+
		"\n\u00cd\3\u00cd\2\2\u00ce\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$"+
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
		"\u018e\u0190\u0192\u0194\u0196\u0198\2\27\6\2\'\',,::PP\6\2Tnp\u009f\u00a1"+
		"\u00c1\u00c3\u00c6\5\2\35\35JJ\u009b\u009b\3\2\u00a4\u00a5\3\2\u00e3\u00e4"+
		"\17\2\7\7CCTTYY\\\\eellrryy~~\u0090\u0091\u0093\u0093\u009d\u009e\3\2"+
		"\u00d9\u00da\3\2\u00db\u00dd\3\2\u0096\u0098\5\2\13\13\60\60HH\5\2\37"+
		"\37\61\61@@\4\2\32\32LL\4\2\5\5\26\26\4\2\u00cd\u00cd\u00d2\u00d6\4\2"+
		"\b\bEE\3\2\u00c7\u00ca\4\2\7\7CC\6\2^^oo\177\u0080\u00a2\u00a2\t\2WW`"+
		"bddst{}\u0088\u0088\u00a1\u00a1\4\2\61\61@@\4\2\t\t\25\25\u075f\2\u019e"+
		"\3\2\2\2\4\u01a9\3\2\2\2\6\u01ab\3\2\2\2\b\u01ad\3\2\2\2\n\u01b1\3\2\2"+
		"\2\f\u01b3\3\2\2\2\16\u01c4\3\2\2\2\20\u01db\3\2\2\2\22\u0221\3\2\2\2"+
		"\24\u0255\3\2\2\2\26\u0257\3\2\2\2\30\u0262\3\2\2\2\32\u0265\3\2\2\2\34"+
		"\u0267\3\2\2\2\36\u0273\3\2\2\2 \u0277\3\2\2\2\"\u027a\3\2\2\2$\u027d"+
		"\3\2\2\2&\u0283\3\2\2\2(\u0285\3\2\2\2*\u028f\3\2\2\2,\u0297\3\2\2\2."+
		"\u02a9\3\2\2\2\60\u02b6\3\2\2\2\62\u02be\3\2\2\2\64\u02c1\3\2\2\2\66\u02c4"+
		"\3\2\2\28\u02ce\3\2\2\2:\u02d6\3\2\2\2<\u02e0\3\2\2\2>\u02e5\3\2\2\2@"+
		"\u02e7\3\2\2\2B\u02ef\3\2\2\2D\u02f1\3\2\2\2F\u02f5\3\2\2\2H\u02fa\3\2"+
		"\2\2J\u02ff\3\2\2\2L\u0301\3\2\2\2N\u0304\3\2\2\2P\u0307\3\2\2\2R\u030a"+
		"\3\2\2\2T\u030c\3\2\2\2V\u0317\3\2\2\2X\u0319\3\2\2\2Z\u0332\3\2\2\2\\"+
		"\u0334\3\2\2\2^\u035b\3\2\2\2`\u0365\3\2\2\2b\u0369\3\2\2\2d\u0380\3\2"+
		"\2\2f\u038c\3\2\2\2h\u0396\3\2\2\2j\u0398\3\2\2\2l\u03a7\3\2\2\2n\u03b6"+
		"\3\2\2\2p\u03c5\3\2\2\2r\u03c9\3\2\2\2t\u03cb\3\2\2\2v\u03d6\3\2\2\2x"+
		"\u03d8\3\2\2\2z\u03da\3\2\2\2|\u03dd\3\2\2\2~\u03e1\3\2\2\2\u0080\u03eb"+
		"\3\2\2\2\u0082\u03ed\3\2\2\2\u0084\u03f5\3\2\2\2\u0086\u03f7\3\2\2\2\u0088"+
		"\u03fd\3\2\2\2\u008a\u0402\3\2\2\2\u008c\u0416\3\2\2\2\u008e\u041a\3\2"+
		"\2\2\u0090\u041c\3\2\2\2\u0092\u0428\3\2\2\2\u0094\u0433\3\2\2\2\u0096"+
		"\u0438\3\2\2\2\u0098\u043d\3\2\2\2\u009a\u0442\3\2\2\2\u009c\u0444\3\2"+
		"\2\2\u009e\u044b\3\2\2\2\u00a0\u044d\3\2\2\2\u00a2\u0452\3\2\2\2\u00a4"+
		"\u0457\3\2\2\2\u00a6\u0459\3\2\2\2\u00a8\u0461\3\2\2\2\u00aa\u046a\3\2"+
		"\2\2\u00ac\u046e\3\2\2\2\u00ae\u0482\3\2\2\2\u00b0\u0484\3\2\2\2\u00b2"+
		"\u0486\3\2\2\2\u00b4\u0488\3\2\2\2\u00b6\u0492\3\2\2\2\u00b8\u0494\3\2"+
		"\2\2\u00ba\u0498\3\2\2\2\u00bc\u049a\3\2\2\2\u00be\u049c\3\2\2\2\u00c0"+
		"\u04a4\3\2\2\2\u00c2\u04a8\3\2\2\2\u00c4\u04aa\3\2\2\2\u00c6\u04ac\3\2"+
		"\2\2\u00c8\u04bf\3\2\2\2\u00ca\u04c1\3\2\2\2\u00cc\u04c3\3\2\2\2\u00ce"+
		"\u04c5\3\2\2\2\u00d0\u04cd\3\2\2\2\u00d2\u04d8\3\2\2\2\u00d4\u04da\3\2"+
		"\2\2\u00d6\u04de\3\2\2\2\u00d8\u04e4\3\2\2\2\u00da\u04e8\3\2\2\2\u00dc"+
		"\u04ec\3\2\2\2\u00de\u04ee\3\2\2\2\u00e0\u04f4\3\2\2\2\u00e2\u04f6\3\2"+
		"\2\2\u00e4\u04f8\3\2\2\2\u00e6\u04fc\3\2\2\2\u00e8\u0500\3\2\2\2\u00ea"+
		"\u0502\3\2\2\2\u00ec\u0512\3\2\2\2\u00ee\u0515\3\2\2\2\u00f0\u051f\3\2"+
		"\2\2\u00f2\u0521\3\2\2\2\u00f4\u053a\3\2\2\2\u00f6\u053c\3\2\2\2\u00f8"+
		"\u0541\3\2\2\2\u00fa\u0547\3\2\2\2\u00fc\u054e\3\2\2\2\u00fe\u0554\3\2"+
		"\2\2\u0100\u0556\3\2\2\2\u0102\u055a\3\2\2\2\u0104\u055e\3\2\2\2\u0106"+
		"\u0560\3\2\2\2\u0108\u0563\3\2\2\2\u010a\u0580\3\2\2\2\u010c\u0582\3\2"+
		"\2\2\u010e\u058a\3\2\2\2\u0110\u058c\3\2\2\2\u0112\u058f\3\2\2\2\u0114"+
		"\u0591\3\2\2\2\u0116\u0595\3\2\2\2\u0118\u05a1\3\2\2\2\u011a\u05a8\3\2"+
		"\2\2\u011c\u05aa\3\2\2\2\u011e\u05b2\3\2\2\2\u0120\u05b7\3\2\2\2\u0122"+
		"\u05bc\3\2\2\2\u0124\u05bf\3\2\2\2\u0126\u05c2\3\2\2\2\u0128\u05ca\3\2"+
		"\2\2\u012a\u05ce\3\2\2\2\u012c\u05d8\3\2\2\2\u012e\u05e6\3\2\2\2\u0130"+
		"\u05f0\3\2\2\2\u0132\u05fe\3\2\2\2\u0134\u0605\3\2\2\2\u0136\u0609\3\2"+
		"\2\2\u0138\u060b\3\2\2\2\u013a\u0610\3\2\2\2\u013c\u0612\3\2\2\2\u013e"+
		"\u061b\3\2\2\2\u0140\u0623\3\2\2\2\u0142\u062d\3\2\2\2\u0144\u062f\3\2"+
		"\2\2\u0146\u0635\3\2\2\2\u0148\u0639\3\2\2\2\u014a\u063e\3\2\2\2\u014c"+
		"\u0643\3\2\2\2\u014e\u0647\3\2\2\2\u0150\u064f\3\2\2\2\u0152\u0651\3\2"+
		"\2\2\u0154\u0653\3\2\2\2\u0156\u0655\3\2\2\2\u0158\u065f\3\2\2\2\u015a"+
		"\u0661\3\2\2\2\u015c\u0665\3\2\2\2\u015e\u0667\3\2\2\2\u0160\u066b\3\2"+
		"\2\2\u0162\u0675\3\2\2\2\u0164\u0681\3\2\2\2\u0166\u0683\3\2\2\2\u0168"+
		"\u068b\3\2\2\2\u016a\u0694\3\2\2\2\u016c\u069c\3\2\2\2\u016e\u069e\3\2"+
		"\2\2\u0170\u06a0\3\2\2\2\u0172\u06a7\3\2\2\2\u0174\u06ae\3\2\2\2\u0176"+
		"\u06b0\3\2\2\2\u0178\u06b2\3\2\2\2\u017a\u06b5\3\2\2\2\u017c\u06ba\3\2"+
		"\2\2\u017e\u06bf\3\2\2\2\u0180\u06c1\3\2\2\2\u0182\u06c3\3\2\2\2\u0184"+
		"\u06c5\3\2\2\2\u0186\u06cc\3\2\2\2\u0188\u06d0\3\2\2\2\u018a\u06d2\3\2"+
		"\2\2\u018c\u06da\3\2\2\2\u018e\u06de\3\2\2\2\u0190\u06e6\3\2\2\2\u0192"+
		"\u06ed\3\2\2\2\u0194\u06ef\3\2\2\2\u0196\u06f6\3\2\2\2\u0198\u0715\3\2"+
		"\2\2\u019a\u019c\5\4\3\2\u019b\u019d\7\u00cf\2\2\u019c\u019b\3\2\2\2\u019c"+
		"\u019d\3\2\2\2\u019d\u019f\3\2\2\2\u019e\u019a\3\2\2\2\u019f\u01a0\3\2"+
		"\2\2\u01a0\u019e\3\2\2\2\u01a0\u01a1\3\2\2\2\u01a1\u01a2\3\2\2\2\u01a2"+
		"\u01a3\7\2\2\3\u01a3\3\3\2\2\2\u01a4\u01aa\5\6\4\2\u01a5\u01aa\5\b\5\2"+
		"\u01a6\u01aa\5\n\6\2\u01a7\u01aa\5\f\7\2\u01a8\u01aa\5\16\b\2\u01a9\u01a4"+
		"\3\2\2\2\u01a9\u01a5\3\2\2\2\u01a9\u01a6\3\2\2\2\u01a9\u01a7\3\2\2\2\u01a9"+
		"\u01a8\3\2\2\2\u01aa\5\3\2\2\2\u01ab\u01ac\5\u0128\u0095\2\u01ac\7\3\2"+
		"\2\2\u01ad\u01ae\5\u0198\u00cd\2\u01ae\t\3\2\2\2\u01af\u01b2\5\24\13\2"+
		"\u01b0\u01b2\5@!\2\u01b1\u01af\3\2\2\2\u01b1\u01b0\3\2\2\2\u01b2\13\3"+
		"\2\2\2\u01b3\u01b5\7\17\2\2\u01b4\u01b6\7M\2\2\u01b5\u01b4\3\2\2\2\u01b5"+
		"\u01b6\3\2\2\2\u01b6\u01b7\3\2\2\2\u01b7\u01b8\7p\2\2\u01b8\u01b9\5B\""+
		"\2\u01b9\u01ba\78\2\2\u01ba\u01bc\5\u013c\u009f\2\u01bb\u01bd\5 \21\2"+
		"\u01bc\u01bb\3\2\2\2\u01bc\u01bd\3\2\2\2\u01bd\u01be\3\2\2\2\u01be\u01bf"+
		"\7\u00d7\2\2\u01bf\u01c0\5\u018e\u00c8\2\u01c0\u01c2\7\u00d8\2\2\u01c1"+
		"\u01c3\5\34\17\2\u01c2\u01c1\3\2\2\2\u01c2\u01c3\3\2\2\2\u01c3\r\3\2\2"+
		"\2\u01c4\u01c5\7\17\2\2\u01c5\u01c9\7\34\2\2\u01c6\u01c7\7$\2\2\u01c7"+
		"\u01c8\7\65\2\2\u01c8\u01ca\7f\2\2\u01c9\u01c6\3\2\2\2\u01c9\u01ca\3\2"+
		"\2\2\u01ca\u01cb\3\2\2\2\u01cb\u01cd\5B\"\2\u01cc\u01ce\7S\2\2\u01cd\u01cc"+
		"\3\2\2\2\u01cd\u01ce\3\2\2\2\u01ce\u01d1\3\2\2\2\u01cf\u01d0\7A\2\2\u01d0"+
		"\u01d2\5B\"\2\u01d1\u01cf\3\2\2\2\u01d1\u01d2\3\2\2\2\u01d2\u01d5\3\2"+
		"\2\2\u01d3\u01d4\7\u00a0\2\2\u01d4\u01d6\5B\"\2\u01d5\u01d3\3\2\2\2\u01d5"+
		"\u01d6\3\2\2\2\u01d6\u01d9\3\2\2\2\u01d7\u01d8\7!\2\2\u01d8\u01da\5B\""+
		"\2\u01d9\u01d7\3\2\2\2\u01d9\u01da\3\2\2\2\u01da\17\3\2\2\2\u01db\u01dd"+
		"\7\17\2\2\u01dc\u01de\7\16\2\2\u01dd\u01dc\3\2\2\2\u01dd\u01de\3\2\2\2"+
		"\u01de\u01df\3\2\2\2\u01df\u01e0\7I\2\2\u01e0\u01e5\5B\"\2\u01e1\u01e6"+
		"\7\n\2\2\u01e2\u01e3\7-\2\2\u01e3\u01e6\7\67\2\2\u01e4\u01e6\7\3\2\2\u01e5"+
		"\u01e1\3\2\2\2\u01e5\u01e2\3\2\2\2\u01e5\u01e4\3\2\2\2\u01e6\u01f6\3\2"+
		"\2\2\u01e7\u01f7\7q\2\2\u01e8\u01f7\7\24\2\2\u01e9\u01f7\7K\2\2\u01ea"+
		"\u01f4\7N\2\2\u01eb\u01f0\7\67\2\2\u01ec\u01ee\5B\"\2\u01ed\u01ef\7\u00d0"+
		"\2\2\u01ee\u01ed\3\2\2\2\u01ee\u01ef\3\2\2\2\u01ef\u01f1\3\2\2\2\u01f0"+
		"\u01ec\3\2\2\2\u01f1\u01f2\3\2\2\2\u01f2\u01f0\3\2\2\2\u01f2\u01f3\3\2"+
		"\2\2\u01f3\u01f5\3\2\2\2\u01f4\u01eb\3\2\2\2\u01f4\u01f5\3\2\2\2\u01f5"+
		"\u01f7\3\2\2\2\u01f6\u01e7\3\2\2\2\u01f6\u01e8\3\2\2\2\u01f6\u01e9\3\2"+
		"\2\2\u01f6\u01ea\3\2\2\2\u01f7\u01f8\3\2\2\2\u01f8\u01f9\78\2\2\u01f9"+
		"\u01fc\5\u013c\u009f\2\u01fa\u01fb\7!\2\2\u01fb\u01fd\5\u013c\u009f\2"+
		"\u01fc\u01fa\3\2\2\2\u01fc\u01fd\3\2\2\2\u01fd\u0207\3\2\2\2\u01fe\u01ff"+
		"\7\65\2\2\u01ff\u0208\7\22\2\2\u0200\u0202\7\22\2\2\u0201\u0200\3\2\2"+
		"\2\u0201\u0202\3\2\2\2\u0202\u0203\3\2\2\2\u0203\u0204\7(\2\2\u0204\u0208"+
		"\7&\2\2\u0205\u0206\7(\2\2\u0206\u0208\7\23\2\2\u0207\u01fe\3\2\2\2\u0207"+
		"\u0201\3\2\2\2\u0207\u0205\3\2\2\2\u0207\u0208\3\2\2\2\u0208\u020f\3\2"+
		"\2\2\u0209\u020b\7\36\2\2\u020a\u020c\7\27\2\2\u020b\u020a\3\2\2\2\u020b"+
		"\u020c\3\2\2\2\u020c\u020d\3\2\2\2\u020d\u0210\7>\2\2\u020e\u0210\7D\2"+
		"\2\u020f\u0209\3\2\2\2\u020f\u020e\3\2\2\2\u020f\u0210\3\2\2\2\u0210\u0213"+
		"\3\2\2\2\u0211\u0212\7Q\2\2\u0212\u0214\5\u00ccg\2\u0213\u0211\3\2\2\2"+
		"\u0213\u0214\3\2\2\2\u0214\u0215\3\2\2\2\u0215\u0216\7\33\2\2\u0216\u0217"+
		"\7=\2\2\u0217\u0218\5B\"\2\u0218\u021d\7\u00d7\2\2\u0219\u021b\5B\"\2"+
		"\u021a\u021c\7\u00d0\2\2\u021b\u021a\3\2\2\2\u021b\u021c\3\2\2\2\u021c"+
		"\u021e\3\2\2\2\u021d\u0219\3\2\2\2\u021d\u021e\3\2\2\2\u021e\u021f\3\2"+
		"\2\2\u021f\u0220\7\u00d8\2\2\u0220\21\3\2\2\2\u0221\u0222\t\2\2\2\u0222"+
		"\23\3\2\2\2\u0223\u0224\7\17\2\2\u0224\u0225\7g\2\2\u0225\u0226\7F\2\2"+
		"\u0226\u0227\5\u013c\u009f\2\u0227\u0228\5\26\f\2\u0228\u0229\7O\2\2\u0229"+
		"\u022b\5B\"\2\u022a\u022c\5\34\17\2\u022b\u022a\3\2\2\2\u022b\u022c\3"+
		"\2\2\2\u022c\u022e\3\2\2\2\u022d\u022f\5&\24\2\u022e\u022d\3\2\2\2\u022e"+
		"\u022f\3\2\2\2\u022f\u0230\3\2\2\2\u0230\u0231\7x\2\2\u0231\u0232\7\u00e8"+
		"\2\2\u0232\u0256\3\2\2\2\u0233\u0234\7\17\2\2\u0234\u0235\7F\2\2\u0235"+
		"\u0236\5\u013c\u009f\2\u0236\u0239\5\26\f\2\u0237\u0238\7O\2\2\u0238\u023a"+
		"\5B\"\2\u0239\u0237\3\2\2\2\u0239\u023a\3\2\2\2\u023a\u023c\3\2\2\2\u023b"+
		"\u023d\5\34\17\2\u023c\u023b\3\2\2\2\u023c\u023d\3\2\2\2\u023d\u023f\3"+
		"\2\2\2\u023e\u0240\5&\24\2\u023f\u023e\3\2\2\2\u023f\u0240\3\2\2\2\u0240"+
		"\u0243\3\2\2\2\u0241\u0242\7\4\2\2\u0242\u0244\5\u0128\u0095\2\u0243\u0241"+
		"\3\2\2\2\u0243\u0244\3\2\2\2\u0244\u0256\3\2\2\2\u0245\u0246\7\17\2\2"+
		"\u0246\u0247\7F\2\2\u0247\u024a\5\u013c\u009f\2\u0248\u0249\7O\2\2\u0249"+
		"\u024b\5B\"\2\u024a\u0248\3\2\2\2\u024a\u024b\3\2\2\2\u024b\u024d\3\2"+
		"\2\2\u024c\u024e\5\34\17\2\u024d\u024c\3\2\2\2\u024d\u024e\3\2\2\2\u024e"+
		"\u0250\3\2\2\2\u024f\u0251\5&\24\2\u0250\u024f\3\2\2\2\u0250\u0251\3\2"+
		"\2\2\u0251\u0252\3\2\2\2\u0252\u0253\7\4\2\2\u0253\u0254\5\u0128\u0095"+
		"\2\u0254\u0256\3\2\2\2\u0255\u0223\3\2\2\2\u0255\u0233\3\2\2\2\u0255\u0245"+
		"\3\2\2\2\u0256\25\3\2\2\2\u0257\u0258\7\u00d7\2\2\u0258\u025d\5\30\r\2"+
		"\u0259\u025a\7\u00d0\2\2\u025a\u025c\5\30\r\2\u025b\u0259\3\2\2\2\u025c"+
		"\u025f\3\2\2\2\u025d\u025b\3\2\2\2\u025d\u025e\3\2\2\2\u025e\u0260\3\2"+
		"\2\2\u025f\u025d\3\2\2\2\u0260\u0261\7\u00d8\2\2\u0261\27\3\2\2\2\u0262"+
		"\u0263\5B\"\2\u0263\u0264\5\32\16\2\u0264\31\3\2\2\2\u0265\u0266\5T+\2"+
		"\u0266\33\3\2\2\2\u0267\u0268\7S\2\2\u0268\u0269\7\u00d7\2\2\u0269\u026e"+
		"\5\36\20\2\u026a\u026b\7\u00d0\2\2\u026b\u026d\5\36\20\2\u026c\u026a\3"+
		"\2\2\2\u026d\u0270\3\2\2\2\u026e\u026c\3\2\2\2\u026e\u026f\3\2\2\2\u026f"+
		"\u0271\3\2\2\2\u0270\u026e\3\2\2\2\u0271\u0272\7\u00d8\2\2\u0272\35\3"+
		"\2\2\2\u0273\u0274\7\u00e8\2\2\u0274\u0275\7\u00cd\2\2\u0275\u0276\5\u00a6"+
		"T\2\u0276\37\3\2\2\2\u0277\u0278\7O\2\2\u0278\u0279\5B\"\2\u0279!\3\2"+
		"\2\2\u027a\u027b\7\u0094\2\2\u027b\u027c\5$\23\2\u027c#\3\2\2\2\u027d"+
		"\u027e\5B\"\2\u027e%\3\2\2\2\u027f\u0284\5(\25\2\u0280\u0284\5.\30\2\u0281"+
		"\u0284\5\66\34\2\u0282\u0284\5<\37\2\u0283\u027f\3\2\2\2\u0283\u0280\3"+
		"\2\2\2\u0283\u0281\3\2\2\2\u0283\u0282\3\2\2\2\u0284\'\3\2\2\2\u0285\u0286"+
		"\7\u0084\2\2\u0286\u0287\7V\2\2\u0287\u0288\7\u0089\2\2\u0288\u0289\7"+
		"\u00d7\2\2\u0289\u028a\5\u014e\u00a8\2\u028a\u028b\7\u00d8\2\2\u028b\u028c"+
		"\7\u00d7\2\2\u028c\u028d\5*\26\2\u028d\u028e\7\u00d8\2\2\u028e)\3\2\2"+
		"\2\u028f\u0294\5,\27\2\u0290\u0291\7\u00d0\2\2\u0291\u0293\5,\27\2\u0292"+
		"\u0290\3\2\2\2\u0293\u0296\3\2\2\2\u0294\u0292\3\2\2\2\u0294\u0295\3\2"+
		"\2\2\u0295+\3\2\2\2\u0296\u0294\3\2\2\2\u0297\u0298\7\u0084\2\2\u0298"+
		"\u0299\5> \2\u0299\u029a\7\u009c\2\2\u029a\u029b\7v\2\2\u029b\u02a7\7"+
		"\u0095\2\2\u029c\u029d\7\u00d7\2\2\u029d\u029e\5\u00a2R\2\u029e\u029f"+
		"\7\u00d8\2\2\u029f\u02a8\3\2\2\2\u02a0\u02a2\7\u00d7\2\2\u02a1\u02a0\3"+
		"\2\2\2\u02a1\u02a2\3\2\2\2\u02a2\u02a3\3\2\2\2\u02a3\u02a5\7z\2\2\u02a4"+
		"\u02a6\7\u00d8\2\2\u02a5\u02a4\3\2\2\2\u02a5\u02a6\3\2\2\2\u02a6\u02a8"+
		"\3\2\2\2\u02a7\u029c\3\2\2\2\u02a7\u02a1\3\2\2\2\u02a8-\3\2\2\2\u02a9"+
		"\u02aa\7\u0084\2\2\u02aa\u02ab\7V\2\2\u02ab\u02ac\7n\2\2\u02ac\u02ad\7"+
		"\u00d7\2\2\u02ad\u02ae\5\u014e\u00a8\2\u02ae\u02b4\7\u00d8\2\2\u02af\u02b0"+
		"\7\u00d7\2\2\u02b0\u02b1\5\60\31\2\u02b1\u02b2\7\u00d8\2\2\u02b2\u02b5"+
		"\3\2\2\2\u02b3\u02b5\5\64\33\2\u02b4\u02af\3\2\2\2\u02b4\u02b3\3\2\2\2"+
		"\u02b5/\3\2\2\2\u02b6\u02bb\5\62\32\2\u02b7\u02b8\7\u00d0\2\2\u02b8\u02ba"+
		"\5\62\32\2\u02b9\u02b7\3\2\2\2\u02ba\u02bd\3\2\2\2\u02bb\u02b9\3\2\2\2"+
		"\u02bb\u02bc\3\2\2\2\u02bc\61\3\2\2\2\u02bd\u02bb\3\2\2\2\u02be\u02bf"+
		"\7\u0084\2\2\u02bf\u02c0\5> \2\u02c0\63\3\2\2\2\u02c1\u02c2\7\u0085\2"+
		"\2\u02c2\u02c3\5\u00a6T\2\u02c3\65\3\2\2\2\u02c4\u02c5\7\u0084\2\2\u02c5"+
		"\u02c6\7V\2\2\u02c6\u02c7\7w\2\2\u02c7\u02c8\7\u00d7\2\2\u02c8\u02c9\5"+
		"\u014e\u00a8\2\u02c9\u02ca\7\u00d8\2\2\u02ca\u02cb\7\u00d7\2\2\u02cb\u02cc"+
		"\58\35\2\u02cc\u02cd\7\u00d8\2\2\u02cd\67\3\2\2\2\u02ce\u02d3\5:\36\2"+
		"\u02cf\u02d0\7\u00d0\2\2\u02d0\u02d2\5:\36\2\u02d1\u02cf\3\2\2\2\u02d2"+
		"\u02d5\3\2\2\2\u02d3\u02d1\3\2\2\2\u02d3\u02d4\3\2\2\2\u02d49\3\2\2\2"+
		"\u02d5\u02d3\3\2\2\2\u02d6\u02d7\7\u0084\2\2\u02d7\u02d8\5> \2\u02d8\u02da"+
		"\7\u009c\2\2\u02d9\u02db\7\'\2\2\u02da\u02d9\3\2\2\2\u02da\u02db\3\2\2"+
		"\2\u02db\u02dc\3\2\2\2\u02dc\u02dd\7\u00d7\2\2\u02dd\u02de\5\u0166\u00b4"+
		"\2\u02de\u02df\7\u00d8\2\2\u02df;\3\2\2\2\u02e0\u02e1\7\u0084\2\2\u02e1"+
		"\u02e2\7V\2\2\u02e2\u02e3\7[\2\2\u02e3\u02e4\5\26\f\2\u02e4=\3\2\2\2\u02e5"+
		"\u02e6\5B\"\2\u02e6?\3\2\2\2\u02e7\u02e8\7c\2\2\u02e8\u02e9\7F\2\2\u02e9"+
		"\u02eb\5\u013c\u009f\2\u02ea\u02ec\7\u0087\2\2\u02eb\u02ea\3\2\2\2\u02eb"+
		"\u02ec\3\2\2\2\u02ecA\3\2\2\2\u02ed\u02f0\7\u00e7\2\2\u02ee\u02f0\5D#"+
		"\2\u02ef\u02ed\3\2\2\2\u02ef\u02ee\3\2\2\2\u02f0C\3\2\2\2\u02f1\u02f2"+
		"\t\3\2\2\u02f2E\3\2\2\2\u02f3\u02f6\5z>\2\u02f4\u02f6\5H%\2\u02f5\u02f3"+
		"\3\2\2\2\u02f5\u02f4\3\2\2\2\u02f6G\3\2\2\2\u02f7\u02fb\7\u00e8\2\2\u02f8"+
		"\u02fb\5J&\2\u02f9\u02fb\5R*\2\u02fa\u02f7\3\2\2\2\u02fa\u02f8\3\2\2\2"+
		"\u02fa\u02f9\3\2\2\2\u02fbI\3\2\2\2\u02fc\u0300\5N(\2\u02fd\u0300\5L\'"+
		"\2\u02fe\u0300\5P)\2\u02ff\u02fc\3\2\2\2\u02ff\u02fd\3\2\2\2\u02ff\u02fe"+
		"\3\2\2\2\u0300K\3\2\2\2\u0301\u0302\7\u00bd\2\2\u0302\u0303\7\u00e8\2"+
		"\2\u0303M\3\2\2\2\u0304\u0305\7\u00bf\2\2\u0305\u0306\7\u00e8\2\2\u0306"+
		"O\3\2\2\2\u0307\u0308\7\u00bc\2\2\u0308\u0309\7\u00e8\2\2\u0309Q\3\2\2"+
		"\2\u030a\u030b\t\4\2\2\u030bS\3\2\2\2\u030c\u030d\5V,\2\u030dU\3\2\2\2"+
		"\u030e\u0318\5Z.\2\u030f\u0318\5^\60\2\u0310\u0318\5`\61\2\u0311\u0318"+
		"\5b\62\2\u0312\u0318\5j\66\2\u0313\u0318\5l\67\2\u0314\u0318\5n8\2\u0315"+
		"\u0318\5p9\2\u0316\u0318\5X-\2\u0317\u030e\3\2\2\2\u0317\u030f\3\2\2\2"+
		"\u0317\u0310\3\2\2\2\u0317\u0311\3\2\2\2\u0317\u0312\3\2\2\2\u0317\u0313"+
		"\3\2\2\2\u0317\u0314\3\2\2\2\u0317\u0315\3\2\2\2\u0317\u0316\3\2\2\2\u0318"+
		"W\3\2\2\2\u0319\u031a\7\u00c6\2\2\u031aY\3\2\2\2\u031b\u031d\7X\2\2\u031c"+
		"\u031e\5\\/\2\u031d\u031c\3\2\2\2\u031d\u031e\3\2\2\2\u031e\u0333\3\2"+
		"\2\2\u031f\u0321\7\u00b8\2\2\u0320\u0322\5\\/\2\u0321\u0320\3\2\2\2\u0321"+
		"\u0322\3\2\2\2\u0322\u0333\3\2\2\2\u0323\u0324\7X\2\2\u0324\u0326\7\u009f"+
		"\2\2\u0325\u0327\5\\/\2\u0326\u0325\3\2\2\2\u0326\u0327\3\2\2\2\u0327"+
		"\u0333\3\2\2\2\u0328\u0329\7\u00b8\2\2\u0329\u032b\7\u009f\2\2\u032a\u032c"+
		"\5\\/\2\u032b\u032a\3\2\2\2\u032b\u032c\3\2\2\2\u032c\u0333\3\2\2\2\u032d"+
		"\u032f\7\u00b9\2\2\u032e\u0330\5\\/\2\u032f\u032e\3\2\2\2\u032f\u0330"+
		"\3\2\2\2\u0330\u0333\3\2\2\2\u0331\u0333\7\u00c1\2\2\u0332\u031b\3\2\2"+
		"\2\u0332\u031f\3\2\2\2\u0332\u0323\3\2\2\2\u0332\u0328\3\2\2\2\u0332\u032d"+
		"\3\2\2\2\u0332\u0331\3\2\2\2\u0333[\3\2\2\2\u0334\u0335\7\u00d7\2\2\u0335"+
		"\u0336\7\u00e3\2\2\u0336\u0337\7\u00d8\2\2\u0337]\3\2\2\2\u0338\u0339"+
		"\7\u0081\2\2\u0339\u033b\7X\2\2\u033a\u033c\5\\/\2\u033b\u033a\3\2\2\2"+
		"\u033b\u033c\3\2\2\2\u033c\u035c\3\2\2\2\u033d\u033e\7\u0081\2\2\u033e"+
		"\u0340\7\u00b8\2\2\u033f\u0341\5\\/\2\u0340\u033f\3\2\2\2\u0340\u0341"+
		"\3\2\2\2\u0341\u035c\3\2\2\2\u0342\u0344\7\u00ba\2\2\u0343\u0345\5\\/"+
		"\2\u0344\u0343\3\2\2\2\u0344\u0345\3\2\2\2\u0345\u035c\3\2\2\2\u0346\u0347"+
		"\7\u0081\2\2\u0347\u0348\7X\2\2\u0348\u034a\7\u009f\2\2\u0349\u034b\5"+
		"\\/\2\u034a\u0349\3\2\2\2\u034a\u034b\3\2\2\2\u034b\u035c\3\2\2\2\u034c"+
		"\u034d\7\u0081\2\2\u034d\u034e\7\u00b8\2\2\u034e\u0350\7\u009f\2\2\u034f"+
		"\u0351\5\\/\2\u0350\u034f\3\2\2\2\u0350\u0351\3\2\2\2\u0351\u035c\3\2"+
		"\2\2\u0352\u0353\7\u00ba\2\2\u0353\u0355\7\u009f\2\2\u0354\u0356\5\\/"+
		"\2\u0355\u0354\3\2\2\2\u0355\u0356\3\2\2\2\u0356\u035c\3\2\2\2\u0357\u0359"+
		"\7\u00bb\2\2\u0358\u035a\5\\/\2\u0359\u0358\3\2\2\2\u0359\u035a\3\2\2"+
		"\2\u035a\u035c\3\2\2\2\u035b\u0338\3\2\2\2\u035b\u033d\3\2\2\2\u035b\u0342"+
		"\3\2\2\2\u035b\u0346\3\2\2\2\u035b\u034c\3\2\2\2\u035b\u0352\3\2\2\2\u035b"+
		"\u0357\3\2\2\2\u035c_\3\2\2\2\u035d\u035f\7\u00c4\2\2\u035e\u0360\5\\"+
		"/\2\u035f\u035e\3\2\2\2\u035f\u0360\3\2\2\2\u0360\u0366\3\2\2\2\u0361"+
		"\u0363\7\u00c5\2\2\u0362\u0364\5\\/\2\u0363\u0362\3\2\2\2\u0363\u0364"+
		"\3\2\2\2\u0364\u0366\3\2\2\2\u0365\u035d\3\2\2\2\u0365\u0361\3\2\2\2\u0366"+
		"a\3\2\2\2\u0367\u036a\5d\63\2\u0368\u036a\5f\64\2\u0369\u0367\3\2\2\2"+
		"\u0369\u0368\3\2\2\2\u036ac\3\2\2\2\u036b\u036d\7\u00b6\2\2\u036c\u036e"+
		"\5h\65\2\u036d\u036c\3\2\2\2\u036d\u036e\3\2\2\2\u036e\u0381\3\2\2\2\u036f"+
		"\u0371\7\u00b7\2\2\u0370\u0372\5h\65\2\u0371\u0370\3\2\2\2\u0371\u0372"+
		"\3\2\2\2\u0372\u0381\3\2\2\2\u0373\u0375\7_\2\2\u0374\u0376\5h\65\2\u0375"+
		"\u0374\3\2\2\2\u0375\u0376\3\2\2\2\u0376\u0381\3\2\2\2\u0377\u0381\7\u00a8"+
		"\2\2\u0378\u0381\7\u00ac\2\2\u0379\u0381\7\u00a9\2\2\u037a\u0381\7\u00ad"+
		"\2\2\u037b\u0381\7\u00aa\2\2\u037c\u0381\7\u00ae\2\2\u037d\u0381\7\u00af"+
		"\2\2\u037e\u0381\7\u00ab\2\2\u037f\u0381\7\u00b0\2\2\u0380\u036b\3\2\2"+
		"\2\u0380\u036f\3\2\2\2\u0380\u0373\3\2\2\2\u0380\u0377\3\2\2\2\u0380\u0378"+
		"\3\2\2\2\u0380\u0379\3\2\2\2\u0380\u037a\3\2\2\2\u0380\u037b\3\2\2\2\u0380"+
		"\u037c\3\2\2\2\u0380\u037d\3\2\2\2\u0380\u037e\3\2\2\2\u0380\u037f\3\2"+
		"\2\2\u0381e\3\2\2\2\u0382\u0384\7\u00b4\2\2\u0383\u0385\5h\65\2\u0384"+
		"\u0383\3\2\2\2\u0384\u0385\3\2\2\2\u0385\u038d\3\2\2\2\u0386\u038d\7\u00b1"+
		"\2\2\u0387\u038d\7\u00b3\2\2\u0388\u038d\7\u00b2\2\2\u0389\u038d\7\u00b5"+
		"\2\2\u038a\u038b\7\u00b5\2\2\u038b\u038d\7\u0086\2\2\u038c\u0382\3\2\2"+
		"\2\u038c\u0386\3\2\2\2\u038c\u0387\3\2\2\2\u038c\u0388\3\2\2\2\u038c\u0389"+
		"\3\2\2\2\u038c\u038a\3\2\2\2\u038dg\3\2\2\2\u038e\u038f\7\u00d7\2\2\u038f"+
		"\u0390\7\u00e3\2\2\u0390\u0397\7\u00d8\2\2\u0391\u0392\7\u00d7\2\2\u0392"+
		"\u0393\7\u00e3\2\2\u0393\u0394\7\u00d0\2\2\u0394\u0395\7\u00e3\2\2\u0395"+
		"\u0397\7\u00d8\2\2\u0396\u038e\3\2\2\2\u0396\u0391\3\2\2\2\u0397i\3\2"+
		"\2\2\u0398\u0399\t\5\2\2\u0399k\3\2\2\2\u039a\u03a8\7\u00bc\2\2\u039b"+
		"\u03a8\7\u00bd\2\2\u039c\u039d\7\u00bd\2\2\u039d\u039e\7S\2\2\u039e\u039f"+
		"\7\u00bd\2\2\u039f\u03a8\7\u00a3\2\2\u03a0\u03a8\7\u00be\2\2\u03a1\u03a8"+
		"\7\u00bf\2\2\u03a2\u03a3\7\u00bf\2\2\u03a3\u03a4\7S\2\2\u03a4\u03a5\7"+
		"\u00bd\2\2\u03a5\u03a8\7\u00a3\2\2\u03a6\u03a8\7\u00c0\2\2\u03a7\u039a"+
		"\3\2\2\2\u03a7\u039b\3\2\2\2\u03a7\u039c\3\2\2\2\u03a7\u03a0\3\2\2\2\u03a7"+
		"\u03a1\3\2\2\2\u03a7\u03a2\3\2\2\2\u03a7\u03a6\3\2\2\2\u03a8m\3\2\2\2"+
		"\u03a9\u03ab\7\u00a6\2\2\u03aa\u03ac\5\\/\2\u03ab\u03aa\3\2\2\2\u03ab"+
		"\u03ac\3\2\2\2\u03ac\u03b7\3\2\2\2\u03ad\u03af\7\u00a7\2\2\u03ae\u03b0"+
		"\5\\/\2\u03af\u03ae\3\2\2\2\u03af\u03b0\3\2\2\2\u03b0\u03b7\3\2\2\2\u03b1"+
		"\u03b2\7\u00a6\2\2\u03b2\u03b4\7\u009f\2\2\u03b3\u03b5\5\\/\2\u03b4\u03b3"+
		"\3\2\2\2\u03b4\u03b5\3\2\2\2\u03b5\u03b7\3\2\2\2\u03b6\u03a9\3\2\2\2\u03b6"+
		"\u03ad\3\2\2\2\u03b6\u03b1\3\2\2\2\u03b7o\3\2\2\2\u03b8\u03ba\7\u00c2"+
		"\2\2\u03b9\u03bb\5\\/\2\u03ba\u03b9\3\2\2\2\u03ba\u03bb\3\2\2\2\u03bb"+
		"\u03c6\3\2\2\2\u03bc\u03bd\7\u00c2\2\2\u03bd\u03bf\7\u009f\2\2\u03be\u03c0"+
		"\5\\/\2\u03bf\u03be\3\2\2\2\u03bf\u03c0\3\2\2\2\u03c0\u03c6\3\2\2\2\u03c1"+
		"\u03c3\7\u00c3\2\2\u03c2\u03c4\5\\/\2\u03c3\u03c2\3\2\2\2\u03c3\u03c4"+
		"\3\2\2\2\u03c4\u03c6\3\2\2\2\u03c5\u03b8\3\2\2\2\u03c5\u03bc\3\2\2\2\u03c5"+
		"\u03c1\3\2\2\2\u03c6q\3\2\2\2\u03c7\u03ca\5t;\2\u03c8\u03ca\5v<\2\u03c9"+
		"\u03c7\3\2\2\2\u03c9\u03c8\3\2\2\2\u03cas\3\2\2\2\u03cb\u03cc\7\u00d7"+
		"\2\2\u03cc\u03cd\5\u00a2R\2\u03cd\u03ce\7\u00d8\2\2\u03ceu\3\2\2\2\u03cf"+
		"\u03d7\5x=\2\u03d0\u03d7\5\u014a\u00a6\2\u03d1\u03d7\5~@\2\u03d2\u03d7"+
		"\5\u0150\u00a9\2\u03d3\u03d7\5\u008aF\2\u03d4\u03d7\5\u009cO\2\u03d5\u03d7"+
		"\5\u0184\u00c3\2\u03d6\u03cf\3\2\2\2\u03d6\u03d0\3\2\2\2\u03d6\u03d1\3"+
		"\2\2\2\u03d6\u03d2\3\2\2\2\u03d6\u03d3\3\2\2\2\u03d6\u03d4\3\2\2\2\u03d6"+
		"\u03d5\3\2\2\2\u03d7w\3\2\2\2\u03d8\u03d9\5F$\2\u03d9y\3\2\2\2\u03da\u03db"+
		"\t\6\2\2\u03db{\3\2\2\2\u03dc\u03de\5\u00b0Y\2\u03dd\u03dc\3\2\2\2\u03dd"+
		"\u03de\3\2\2\2\u03de\u03df\3\2\2\2\u03df\u03e0\5z>\2\u03e0}\3\2\2\2\u03e1"+
		"\u03e2\5\u0080A\2\u03e2\177\3\2\2\2\u03e3\u03e4\7\\\2\2\u03e4\u03e5\7"+
		"\u00d7\2\2\u03e5\u03e6\7\u00db\2\2\u03e6\u03ec\7\u00d8\2\2\u03e7\u03e9"+
		"\5\u0082B\2\u03e8\u03ea\5\u0086D\2\u03e9\u03e8\3\2\2\2\u03e9\u03ea\3\2"+
		"\2\2\u03ea\u03ec\3\2\2\2\u03eb\u03e3\3\2\2\2\u03eb\u03e7\3\2\2\2\u03ec"+
		"\u0081\3\2\2\2\u03ed\u03ee\5\u0084C\2\u03ee\u03f0\7\u00d7\2\2\u03ef\u03f1"+
		"\5\u0148\u00a5\2\u03f0\u03ef\3\2\2\2\u03f0\u03f1\3\2\2\2\u03f1\u03f2\3"+
		"\2\2\2\u03f2\u03f3\5\u00a2R\2\u03f3\u03f4\7\u00d8\2\2\u03f4\u0083\3\2"+
		"\2\2\u03f5\u03f6\t\7\2\2\u03f6\u0085\3\2\2\2\u03f7\u03f8\7i\2\2\u03f8"+
		"\u03f9\7\u00d7\2\2\u03f9\u03fa\7R\2\2\u03fa\u03fb\5\u0112\u008a\2\u03fb"+
		"\u03fc\7\u00d8\2\2\u03fc\u0087\3\2\2\2\u03fd\u03fe\7m\2\2\u03fe\u03ff"+
		"\7\u00d7\2\2\u03ff\u0400\5\u014e\u00a8\2\u0400\u0401\7\u00d8\2\2\u0401"+
		"\u0089\3\2\2\2\u0402\u0403\5\u008eH\2\u0403\u008b\3\2\2\2\u0404\u0405"+
		"\7\u0082\2\2\u0405\u0406\7\u00d7\2\2\u0406\u0407\5\u00a6T\2\u0407\u0408"+
		"\7\u00d0\2\2\u0408\u0409\5\u00ccg\2\u0409\u040a\7\u00d8\2\2\u040a\u0417"+
		"\3\2\2\2\u040b\u040c\7Z\2\2\u040c\u040d\7\u00d7\2\2\u040d\u0410\5\u00a6"+
		"T\2\u040e\u040f\7\u00d0\2\2\u040f\u0411\5\u00ccg\2\u0410\u040e\3\2\2\2"+
		"\u0411\u0412\3\2\2\2\u0412\u0410\3\2\2\2\u0412\u0413\3\2\2\2\u0413\u0414"+
		"\3\2\2\2\u0414\u0415\7\u00d8\2\2\u0415\u0417\3\2\2\2\u0416\u0404\3\2\2"+
		"\2\u0416\u040b\3\2\2\2\u0417\u008d\3\2\2\2\u0418\u041b\5\u0090I\2\u0419"+
		"\u041b\5\u0092J\2\u041a\u0418\3\2\2\2\u041a\u0419\3\2\2\2\u041b\u008f"+
		"\3\2\2\2\u041c\u041d\7\f\2\2\u041d\u041f\5\u00ccg\2\u041e\u0420\5\u0094"+
		"K\2\u041f\u041e\3\2\2\2\u0420\u0421\3\2\2\2\u0421\u041f\3\2\2\2\u0421"+
		"\u0422\3\2\2\2\u0422\u0424\3\2\2\2\u0423\u0425\5\u0098M\2\u0424\u0423"+
		"\3\2\2\2\u0424\u0425\3\2\2\2\u0425\u0426\3\2\2\2\u0426\u0427\7\30\2\2"+
		"\u0427\u0091\3\2\2\2\u0428\u042a\7\f\2\2\u0429\u042b\5\u0096L\2\u042a"+
		"\u0429\3\2\2\2\u042b\u042c\3\2\2\2\u042c\u042a\3\2\2\2\u042c\u042d\3\2"+
		"\2\2\u042d\u042f\3\2\2\2\u042e\u0430\5\u0098M\2\u042f\u042e\3\2\2\2\u042f"+
		"\u0430\3\2\2\2\u0430\u0431\3\2\2\2\u0431\u0432\7\30\2\2\u0432\u0093\3"+
		"\2\2\2\u0433\u0434\7Q\2\2\u0434\u0435\5\u0112\u008a\2\u0435\u0436\7G\2"+
		"\2\u0436\u0437\5\u009aN\2\u0437\u0095\3\2\2\2\u0438\u0439\7Q\2\2\u0439"+
		"\u043a\5\u0112\u008a\2\u043a\u043b\7G\2\2\u043b\u043c\5\u009aN\2\u043c"+
		"\u0097\3\2\2\2\u043d\u043e\7\31\2\2\u043e\u043f\5\u009aN\2\u043f\u0099"+
		"\3\2\2\2\u0440\u0443\5\u00a2R\2\u0441\u0443\7\66\2\2\u0442\u0440\3\2\2"+
		"\2\u0442\u0441\3\2\2\2\u0443\u009b\3\2\2\2\u0444\u0445\7\r\2\2\u0445\u0446"+
		"\7\u00d7\2\2\u0446\u0447\5\u009eP\2\u0447\u0448\7\4\2\2\u0448\u0449\5"+
		"\u00a0Q\2\u0449\u044a\7\u00d8\2\2\u044a\u009d\3\2\2\2\u044b\u044c\5\u00a2"+
		"R\2\u044c\u009f\3\2\2\2\u044d\u044e\5T+\2\u044e\u00a1\3\2\2\2\u044f\u0453"+
		"\5\u00a4S\2\u0450\u0453\5\u00e0q\2\u0451\u0453\5\u00ccg\2\u0452\u044f"+
		"\3\2\2\2\u0452\u0450\3\2\2\2\u0452\u0451\3\2\2\2\u0453\u00a3\3\2\2\2\u0454"+
		"\u0458\5\u00a6T\2\u0455\u0458\5\u00bc_\2\u0456\u0458\7\66\2\2\u0457\u0454"+
		"\3\2\2\2\u0457\u0455\3\2\2\2\u0457\u0456\3\2\2\2\u0458\u00a5\3\2\2\2\u0459"+
		"\u045e\5\u00a8U\2\u045a\u045b\t\b\2\2\u045b\u045d\5\u00a8U\2\u045c\u045a"+
		"\3\2\2\2\u045d\u0460\3\2\2\2\u045e\u045c\3\2\2\2\u045e\u045f\3\2\2\2\u045f"+
		"\u00a7\3\2\2\2\u0460\u045e\3\2\2\2\u0461\u0466\5\u00aaV\2\u0462\u0463"+
		"\t\t\2\2\u0463\u0465\5\u00aaV\2\u0464\u0462\3\2\2\2\u0465\u0468\3\2\2"+
		"\2\u0466\u0464\3\2\2\2\u0466\u0467\3\2\2\2\u0467\u00a9\3\2\2\2\u0468\u0466"+
		"\3\2\2\2\u0469\u046b\5\u00b0Y\2\u046a\u0469\3\2\2\2\u046a\u046b\3\2\2"+
		"\2\u046b\u046c\3\2\2\2\u046c\u046d\5\u00aeX\2\u046d\u00ab\3\2\2\2\u046e"+
		"\u046f\7\u00d7\2\2\u046f\u0474\5\u00a6T\2\u0470\u0471\7\u00d0\2\2\u0471"+
		"\u0473\5\u00a6T\2\u0472\u0470\3\2\2\2\u0473\u0476\3\2\2\2\u0474\u0472"+
		"\3\2\2\2\u0474\u0475\3\2\2\2\u0475\u0477\3\2\2\2\u0476\u0474\3\2\2\2\u0477"+
		"\u0478\7\u00d8\2\2\u0478\u00ad\3\2\2\2\u0479\u047e\5r:\2\u047a\u047b\7"+
		"\u00cb\2\2\u047b\u047d\5\u00a0Q\2\u047c\u047a\3\2\2\2\u047d\u0480\3\2"+
		"\2\2\u047e\u047c\3\2\2\2\u047e\u047f\3\2\2\2\u047f\u0483\3\2\2\2\u0480"+
		"\u047e\3\2\2\2\u0481\u0483\5\u00b2Z\2\u0482\u0479\3\2\2\2\u0482\u0481"+
		"\3\2\2\2\u0483\u00af\3\2\2\2\u0484\u0485\t\b\2\2\u0485\u00b1\3\2\2\2\u0486"+
		"\u0487\5\u00b4[\2\u0487\u00b3\3\2\2\2\u0488\u0489\7h\2\2\u0489\u048a\7"+
		"\u00d7\2\2\u048a\u048b\5\u00b6\\\2\u048b\u048c\7!\2\2\u048c\u048d\5\u00ba"+
		"^\2\u048d\u048e\7\u00d8\2\2\u048e\u00b5\3\2\2\2\u048f\u0493\5\u017e\u00c0"+
		"\2\u0490\u0493\5\u00b8]\2\u0491\u0493\5\u0182\u00c2\2\u0492\u048f\3\2"+
		"\2\2\u0492\u0490\3\2\2\2\u0492\u0491\3\2\2\2\u0493\u00b7\3\2\2\2\u0494"+
		"\u0495\t\n\2\2\u0495\u00b9\3\2\2\2\u0496\u0499\5\u014a\u00a6\2\u0497\u0499"+
		"\5J&\2\u0498\u0496\3\2\2\2\u0498\u0497\3\2\2\2\u0499\u00bb\3\2\2\2\u049a"+
		"\u049b\5\u00be`\2\u049b\u00bd\3\2\2\2\u049c\u04a1\5\u00c0a\2\u049d\u049e"+
		"\7\u00d1\2\2\u049e\u04a0\5\u00c0a\2\u049f\u049d\3\2\2\2\u04a0\u04a3\3"+
		"\2\2\2\u04a1\u049f\3\2\2\2\u04a1\u04a2\3\2\2\2\u04a2\u00bf\3\2\2\2\u04a3"+
		"\u04a1\3\2\2\2\u04a4\u04a5\5\u00c2b\2\u04a5\u00c1\3\2\2\2\u04a6\u04a9"+
		"\5r:\2\u04a7\u04a9\5\u00c4c\2\u04a8\u04a6\3\2\2\2\u04a8\u04a7\3\2\2\2"+
		"\u04a9\u00c3\3\2\2\2\u04aa\u04ab\5\u00c6d\2\u04ab\u00c5\3\2\2\2\u04ac"+
		"\u04ad\7\u0099\2\2\u04ad\u04ae\7\u00d7\2\2\u04ae\u04af\5\u00c8e\2\u04af"+
		"\u04b0\7\u00d8\2\2\u04b0\u00c7\3\2\2\2\u04b1\u04b3\5\u00caf\2\u04b2\u04b1"+
		"\3\2\2\2\u04b2\u04b3\3\2\2\2\u04b3\u04b5\3\2\2\2\u04b4\u04b6\5\u00be`"+
		"\2\u04b5\u04b4\3\2\2\2\u04b5\u04b6\3\2\2\2\u04b6\u04b7\3\2\2\2\u04b7\u04b9"+
		"\7!\2\2\u04b8\u04b2\3\2\2\2\u04b8\u04b9\3\2\2\2\u04b9\u04ba\3\2\2\2\u04ba"+
		"\u04c0\5\u00be`\2\u04bb\u04bc\5\u00be`\2\u04bc\u04bd\7\u00d0\2\2\u04bd"+
		"\u04be\5\u00be`\2\u04be\u04c0\3\2\2\2\u04bf\u04b8\3\2\2\2\u04bf\u04bb"+
		"\3\2\2\2\u04c0\u00c9\3\2\2\2\u04c1\u04c2\t\13\2\2\u04c2\u00cb\3\2\2\2"+
		"\u04c3\u04c4\5\u00ceh\2\u04c4\u00cd\3\2\2\2\u04c5\u04ca\5\u00d0i\2\u04c6"+
		"\u04c7\7;\2\2\u04c7\u04c9\5\u00ceh\2\u04c8\u04c6\3\2\2\2\u04c9\u04cc\3"+
		"\2\2\2\u04ca\u04c8\3\2\2\2\u04ca\u04cb\3\2\2\2\u04cb\u00cf\3\2\2\2\u04cc"+
		"\u04ca\3\2\2\2\u04cd\u04d2\5\u00d2j\2\u04ce\u04cf\7\6\2\2\u04cf\u04d1"+
		"\5\u00d0i\2\u04d0\u04ce\3\2\2\2\u04d1\u04d4\3\2\2\2\u04d2\u04d0\3\2\2"+
		"\2\u04d2\u04d3\3\2\2\2\u04d3\u00d1\3\2\2\2\u04d4\u04d2\3\2\2\2\u04d5\u04d9"+
		"\5\u00d4k\2\u04d6\u04d7\7\65\2\2\u04d7\u04d9\5\u00d4k\2\u04d8\u04d5\3"+
		"\2\2\2\u04d8\u04d6\3\2\2\2\u04d9\u00d3\3\2\2\2\u04da\u04dc\5\u00dan\2"+
		"\u04db\u04dd\5\u00d6l\2\u04dc\u04db\3\2\2\2\u04dc\u04dd\3\2\2\2\u04dd"+
		"\u00d5\3\2\2\2\u04de\u04e0\7.\2\2\u04df\u04e1\7\65\2\2\u04e0\u04df\3\2"+
		"\2\2\u04e0\u04e1\3\2\2\2\u04e1\u04e2\3\2\2\2\u04e2\u04e3\5\u00d8m\2\u04e3"+
		"\u00d7\3\2\2\2\u04e4\u04e5\t\4\2\2\u04e5\u00d9\3\2\2\2\u04e6\u04e9\5\u0158"+
		"\u00ad\2\u04e7\u04e9\5\u00dco\2\u04e8\u04e6\3\2\2\2\u04e8\u04e7\3\2\2"+
		"\2\u04e9\u00db\3\2\2\2\u04ea\u04ed\5\u00dep\2\u04eb\u04ed\5v<\2\u04ec"+
		"\u04ea\3\2\2\2\u04ec\u04eb\3\2\2\2\u04ed\u00dd\3\2\2\2\u04ee\u04ef\7\u00d7"+
		"\2\2\u04ef\u04f0\5\u00ccg\2\u04f0\u04f1\7\u00d8\2\2\u04f1\u00df\3\2\2"+
		"\2\u04f2\u04f5\5\u00e2r\2\u04f3\u04f5\5\u00e4s\2\u04f4\u04f2\3\2\2\2\u04f4"+
		"\u04f3\3\2\2\2\u04f5\u00e1\3\2\2\2\u04f6\u04f7\5v<\2\u04f7\u00e3\3\2\2"+
		"\2\u04f8\u04f9\7\66\2\2\u04f9\u00e5\3\2\2\2\u04fa\u04fd\5\u00e2r\2\u04fb"+
		"\u04fd\5\u00e8u\2\u04fc\u04fa\3\2\2\2\u04fc\u04fb\3\2\2\2\u04fd\u00e7"+
		"\3\2\2\2\u04fe\u0501\5\u00a4S\2\u04ff\u0501\5\u00dco\2\u0500\u04fe\3\2"+
		"\2\2\u0500\u04ff\3\2\2\2\u0501\u00e9\3\2\2\2\u0502\u0504\5\u00ecw\2\u0503"+
		"\u0505\5\u0110\u0089\2\u0504\u0503\3\2\2\2\u0504\u0505\3\2\2\2\u0505\u0507"+
		"\3\2\2\2\u0506\u0508\5\u0114\u008b\2\u0507\u0506\3\2\2\2\u0507\u0508\3"+
		"\2\2\2\u0508\u050a\3\2\2\2\u0509\u050b\5\u0124\u0093\2\u050a\u0509\3\2"+
		"\2\2\u050a\u050b\3\2\2\2\u050b\u050d\3\2\2\2\u050c\u050e\5\u018c\u00c7"+
		"\2\u050d\u050c\3\2\2\2\u050d\u050e\3\2\2\2\u050e\u0510\3\2\2\2\u050f\u0511"+
		"\5\u0194\u00cb\2\u0510\u050f\3\2\2\2\u0510\u0511\3\2\2\2\u0511\u00eb\3"+
		"\2\2\2\u0512\u0513\7!\2\2\u0513\u0514\5\u00eex\2\u0514\u00ed\3\2\2\2\u0515"+
		"\u051a\5\u00f0y\2\u0516\u0517\7\u00d0\2\2\u0517\u0519\5\u00f0y\2\u0518"+
		"\u0516\3\2\2\2\u0519\u051c\3\2\2\2\u051a\u0518\3\2\2\2\u051a\u051b\3\2"+
		"\2\2\u051b\u00ef\3\2\2\2\u051c\u051a\3\2\2\2\u051d\u0520\5\u00f2z\2\u051e"+
		"\u0520\5\u010a\u0086\2\u051f\u051d\3\2\2\2\u051f\u051e\3\2\2\2\u0520\u00f1"+
		"\3\2\2\2\u0521\u0523\5\u010a\u0086\2\u0522\u0524\5\u00f4{\2\u0523\u0522"+
		"\3\2\2\2\u0524\u0525\3\2\2\2\u0525\u0523\3\2\2\2\u0525\u0526\3\2\2\2\u0526"+
		"\u00f3\3\2\2\2\u0527\u0528\7\20\2\2\u0528\u0529\7/\2\2\u0529\u053b\5\u010a"+
		"\u0086\2\u052a\u052c\5\u00fe\u0080\2\u052b\u052a\3\2\2\2\u052b\u052c\3"+
		"\2\2\2\u052c\u052d\3\2\2\2\u052d\u052e\7/\2\2\u052e\u052f\5\u010a\u0086"+
		"\2\u052f\u0530\5\u0104\u0083\2\u0530\u053b\3\2\2\2\u0531\u0533\7\64\2"+
		"\2\u0532\u0534\5\u00fe\u0080\2\u0533\u0532\3\2\2\2\u0533\u0534\3\2\2\2"+
		"\u0534\u0535\3\2\2\2\u0535\u0536\7/\2\2\u0536\u053b\5\u010a\u0086\2\u0537"+
		"\u0538\7L\2\2\u0538\u0539\7/\2\2\u0539\u053b\5\u010a\u0086\2\u053a\u0527"+
		"\3\2\2\2\u053a\u052b\3\2\2\2\u053a\u0531\3\2\2\2\u053a\u0537\3\2\2\2\u053b"+
		"\u00f5\3\2\2\2\u053c\u053d\7\20\2\2\u053d\u053e\7/\2\2\u053e\u053f\5\u010a"+
		"\u0086\2\u053f\u00f7\3\2\2\2\u0540\u0542\5\u00fe\u0080\2\u0541\u0540\3"+
		"\2\2\2\u0541\u0542\3\2\2\2\u0542\u0543\3\2\2\2\u0543\u0544\7/\2\2\u0544"+
		"\u0545\5\u010a\u0086\2\u0545\u0546\5\u0104\u0083\2\u0546\u00f9\3\2\2\2"+
		"\u0547\u0549\7\64\2\2\u0548\u054a\5\u00fe\u0080\2\u0549\u0548\3\2\2\2"+
		"\u0549\u054a\3\2\2\2\u054a\u054b\3\2\2\2\u054b\u054c\7/\2\2\u054c\u054d"+
		"\5\u010a\u0086\2\u054d\u00fb\3\2\2\2\u054e\u054f\7L\2\2\u054f\u0550\7"+
		"/\2\2\u0550\u0551\5\u010a\u0086\2\u0551\u00fd\3\2\2\2\u0552\u0555\7)\2"+
		"\2\u0553\u0555\5\u0100\u0081\2\u0554\u0552\3\2\2\2\u0554\u0553\3\2\2\2"+
		"\u0555\u00ff\3\2\2\2\u0556\u0558\5\u0102\u0082\2\u0557\u0559\79\2\2\u0558"+
		"\u0557\3\2\2\2\u0558\u0559\3\2\2\2\u0559\u0101\3\2\2\2\u055a\u055b\t\f"+
		"\2\2\u055b\u0103\3\2\2\2\u055c\u055f\5\u0106\u0084\2\u055d\u055f\5\u0108"+
		"\u0085\2\u055e\u055c\3\2\2\2\u055e\u055d\3\2\2\2\u055f\u0105\3\2\2\2\u0560"+
		"\u0561\78\2\2\u0561\u0562\5\u0112\u008a\2\u0562\u0107\3\2\2\2\u0563\u0564"+
		"\7O\2\2\u0564\u0565\7\u00d7\2\2\u0565\u0566\5\u014e\u00a8\2\u0566\u0567"+
		"\7\u00d8\2\2\u0567\u0109\3\2\2\2\u0568\u056d\5\u013a\u009e\2\u0569\u056b"+
		"\7\4\2\2\u056a\u0569\3\2\2\2\u056a\u056b\3\2\2\2\u056b\u056c\3\2\2\2\u056c"+
		"\u056e\5B\"\2\u056d\u056a\3\2\2\2\u056d\u056e\3\2\2\2\u056e\u0573\3\2"+
		"\2\2\u056f\u0570\7\u00d7\2\2\u0570\u0571\5\u010c\u0087\2\u0571\u0572\7"+
		"\u00d8\2\2\u0572\u0574\3\2\2\2\u0573\u056f\3\2\2\2\u0573\u0574\3\2\2\2"+
		"\u0574\u0581\3\2\2\2\u0575\u0577\5\u010e\u0088\2\u0576\u0578\7\4\2\2\u0577"+
		"\u0576\3\2\2\2\u0577\u0578\3\2\2\2\u0578\u0579\3\2\2\2\u0579\u057e\5B"+
		"\"\2\u057a\u057b\7\u00d7\2\2\u057b\u057c\5\u010c\u0087\2\u057c\u057d\7"+
		"\u00d8\2\2\u057d\u057f\3\2\2\2\u057e\u057a\3\2\2\2\u057e\u057f\3\2\2\2"+
		"\u057f\u0581\3\2\2\2\u0580\u0568\3\2\2\2\u0580\u0575\3\2\2\2\u0581\u010b"+
		"\3\2\2\2\u0582\u0587\5B\"\2\u0583\u0584\7\u00d0\2\2\u0584\u0586\5B\"\2"+
		"\u0585\u0583\3\2\2\2\u0586\u0589\3\2\2\2\u0587\u0585\3\2\2\2\u0587\u0588"+
		"\3\2\2\2\u0588\u010d\3\2\2\2\u0589\u0587\3\2\2\2\u058a\u058b\5\u0154\u00ab"+
		"\2\u058b\u010f\3\2\2\2\u058c\u058d\7R\2\2\u058d\u058e\5\u0112\u008a\2"+
		"\u058e\u0111\3\2\2\2\u058f\u0590\5\u00a2R\2\u0590\u0113\3\2\2\2\u0591"+
		"\u0592\7\"\2\2\u0592\u0593\7V\2\2\u0593\u0594\5\u0116\u008c\2\u0594\u0115"+
		"\3\2\2\2\u0595\u059a\5\u0118\u008d\2\u0596\u0597\7\u00d0\2\2\u0597\u0599"+
		"\5\u0118\u008d\2\u0598\u0596\3\2\2\2\u0599\u059c\3\2\2\2\u059a\u0598\3"+
		"\2\2\2\u059a\u059b\3\2\2\2\u059b\u0117\3\2\2\2\u059c\u059a\3\2\2\2\u059d"+
		"\u05a2\5\u011e\u0090\2\u059e\u05a2\5\u0120\u0091\2\u059f\u05a2\5\u0122"+
		"\u0092\2\u05a0\u05a2\5\u011a\u008e\2\u05a1\u059d\3\2\2\2\u05a1\u059e\3"+
		"\2\2\2\u05a1\u059f\3\2\2\2\u05a1\u05a0\3\2\2\2\u05a2\u0119\3\2\2\2\u05a3"+
		"\u05a9\5\u00e6t\2\u05a4\u05a5\7\u00d7\2\2\u05a5\u05a6\5\u0126\u0094\2"+
		"\u05a6\u05a7\7\u00d8\2\2\u05a7\u05a9\3\2\2\2\u05a8\u05a3\3\2\2\2\u05a8"+
		"\u05a4\3\2\2\2\u05a9\u011b\3\2\2\2\u05aa\u05af\5\u011a\u008e\2\u05ab\u05ac"+
		"\7\u00d0\2\2\u05ac\u05ae\5\u011a\u008e\2\u05ad\u05ab\3\2\2\2\u05ae\u05b1"+
		"\3\2\2\2\u05af\u05ad\3\2\2\2\u05af\u05b0\3\2\2\2\u05b0\u011d\3\2\2\2\u05b1"+
		"\u05af\3\2\2\2\u05b2\u05b3\7\u008c\2\2\u05b3\u05b4\7\u00d7\2\2\u05b4\u05b5"+
		"\5\u011c\u008f\2\u05b5\u05b6\7\u00d8\2\2\u05b6\u011f\3\2\2\2\u05b7\u05b8"+
		"\7]\2\2\u05b8\u05b9\7\u00d7\2\2\u05b9\u05ba\5\u011c\u008f\2\u05ba\u05bb"+
		"\7\u00d8\2\2\u05bb\u0121\3\2\2\2\u05bc\u05bd\7\u00d7\2\2\u05bd\u05be\7"+
		"\u00d8\2\2\u05be\u0123\3\2\2\2\u05bf\u05c0\7#\2\2\u05c0\u05c1\5\u00cc"+
		"g\2\u05c1\u0125\3\2\2\2\u05c2\u05c7\5\u00e6t\2\u05c3\u05c4\7\u00d0\2\2"+
		"\u05c4\u05c6\5\u00e6t\2\u05c5\u05c3\3\2\2\2\u05c6\u05c9\3\2\2\2\u05c7"+
		"\u05c5\3\2\2\2\u05c7\u05c8\3\2\2\2\u05c8\u0127\3\2\2\2\u05c9\u05c7\3\2"+
		"\2\2\u05ca\u05cb\5\u012a\u0096\2\u05cb\u0129\3\2\2\2\u05cc\u05cf\5\u012c"+
		"\u0097\2\u05cd\u05cf\5\u00f2z\2\u05ce\u05cc\3\2\2\2\u05ce\u05cd\3\2\2"+
		"\2\u05cf\u012b\3\2\2\2\u05d0\u05d9\5\u0130\u0099\2\u05d1\u05d2\5\u00f2"+
		"z\2\u05d2\u05d4\t\r\2\2\u05d3\u05d5\t\16\2\2\u05d4\u05d3\3\2\2\2\u05d4"+
		"\u05d5\3\2\2\2\u05d5\u05d6\3\2\2\2\u05d6\u05d7\5\u012e\u0098\2\u05d7\u05d9"+
		"\3\2\2\2\u05d8\u05d0\3\2\2\2\u05d8\u05d1\3\2\2\2\u05d9\u05e1\3\2\2\2\u05da"+
		"\u05dc\t\r\2\2\u05db\u05dd\t\16\2\2\u05dc\u05db\3\2\2\2\u05dc\u05dd\3"+
		"\2\2\2\u05dd\u05de\3\2\2\2\u05de\u05e0\5\u012e\u0098\2\u05df\u05da\3\2"+
		"\2\2\u05e0\u05e3\3\2\2\2\u05e1\u05df\3\2\2\2\u05e1\u05e2\3\2\2\2\u05e2"+
		"\u012d\3\2\2\2\u05e3\u05e1\3\2\2\2\u05e4\u05e7\5\u0130\u0099\2\u05e5\u05e7"+
		"\5\u00f2z\2\u05e6\u05e4\3\2\2\2\u05e6\u05e5\3\2\2\2\u05e7\u012f\3\2\2"+
		"\2\u05e8\u05f1\5\u0134\u009b\2\u05e9\u05ea\5\u00f2z\2\u05ea\u05ec\7*\2"+
		"\2\u05eb\u05ed\t\16\2\2\u05ec\u05eb\3\2\2\2\u05ec\u05ed\3\2\2\2\u05ed"+
		"\u05ee\3\2\2\2\u05ee\u05ef\5\u0132\u009a\2\u05ef\u05f1\3\2\2\2\u05f0\u05e8"+
		"\3\2\2\2\u05f0\u05e9\3\2\2\2\u05f1\u05f9\3\2\2\2\u05f2\u05f4\7*\2\2\u05f3"+
		"\u05f5\t\16\2\2\u05f4\u05f3\3\2\2\2\u05f4\u05f5\3\2\2\2\u05f5\u05f6\3"+
		"\2\2\2\u05f6\u05f8\5\u0132\u009a\2\u05f7\u05f2\3\2\2\2\u05f8\u05fb\3\2"+
		"\2\2\u05f9\u05f7\3\2\2\2\u05f9\u05fa\3\2\2\2\u05fa\u0131\3\2\2\2\u05fb"+
		"\u05f9\3\2\2\2\u05fc\u05ff\5\u0134\u009b\2\u05fd\u05ff\5\u00f2z\2\u05fe"+
		"\u05fc\3\2\2\2\u05fe\u05fd\3\2\2\2\u05ff\u0133\3\2\2\2\u0600\u0606\5\u0136"+
		"\u009c\2\u0601\u0602\7\u00d7\2\2\u0602\u0603\5\u012c\u0097\2\u0603\u0604"+
		"\7\u00d8\2\2\u0604\u0606\3\2\2\2\u0605\u0600\3\2\2\2\u0605\u0601\3\2\2"+
		"\2\u0606\u0135\3\2\2\2\u0607\u060a\5\u013e\u00a0\2\u0608\u060a\5\u0138"+
		"\u009d\2\u0609\u0607\3\2\2\2\u0609\u0608\3\2\2\2\u060a\u0137\3\2\2\2\u060b"+
		"\u060c\7F\2\2\u060c\u060d\5\u013a\u009e\2\u060d\u0139\3\2\2\2\u060e\u0611"+
		"\5\u013c\u009f\2\u060f\u0611\5B\"\2\u0610\u060e\3\2\2\2\u0610\u060f\3"+
		"\2\2\2\u0611\u013b\3\2\2\2\u0612\u0619\5B\"\2\u0613\u0614\7\u00de\2\2"+
		"\u0614\u0617\5B\"\2\u0615\u0616\7\u00de\2\2\u0616\u0618\5B\"\2\u0617\u0615"+
		"\3\2\2\2\u0617\u0618\3\2\2\2\u0618\u061a\3\2\2\2\u0619\u0613\3\2\2\2\u0619"+
		"\u061a\3\2\2\2\u061a\u013d\3\2\2\2\u061b\u061d\7B\2\2\u061c\u061e\5\u0148"+
		"\u00a5\2\u061d\u061c\3\2\2\2\u061d\u061e\3\2\2\2\u061e\u061f\3\2\2\2\u061f"+
		"\u0621\5\u0140\u00a1\2\u0620\u0622\5\u00eav\2\u0621\u0620\3\2\2\2\u0621"+
		"\u0622\3\2\2\2\u0622\u013f\3\2\2\2\u0623\u0628\5\u0142\u00a2\2\u0624\u0625"+
		"\7\u00d0\2\2\u0625\u0627\5\u0142\u00a2\2\u0626\u0624\3\2\2\2\u0627\u062a"+
		"\3\2\2\2\u0628\u0626\3\2\2\2\u0628\u0629\3\2\2\2\u0629\u0141\3\2\2\2\u062a"+
		"\u0628\3\2\2\2\u062b\u062e\5\u0144\u00a3\2\u062c\u062e\5\u0146\u00a4\2"+
		"\u062d\u062b\3\2\2\2\u062d\u062c\3\2\2\2\u062e\u0143\3\2\2\2\u062f\u0631"+
		"\5\u00a2R\2\u0630\u0632\5\u014c\u00a7\2\u0631\u0630\3\2\2\2\u0631\u0632"+
		"\3\2\2\2\u0632\u0145\3\2\2\2\u0633\u0634\7\u00e7\2\2\u0634\u0636\7\u00de"+
		"\2\2\u0635\u0633\3\2\2\2\u0635\u0636\3\2\2\2\u0636\u0637\3\2\2\2\u0637"+
		"\u0638\7\u00db\2\2\u0638\u0147\3\2\2\2\u0639\u063a\t\16\2\2\u063a\u0149"+
		"\3\2\2\2\u063b\u063c\5B\"\2\u063c\u063d\7\u00de\2\2\u063d\u063f\3\2\2"+
		"\2\u063e\u063b\3\2\2\2\u063e\u063f\3\2\2\2\u063f\u0640\3\2\2\2\u0640\u0641"+
		"\5B\"\2\u0641\u014b\3\2\2\2\u0642\u0644\7\4\2\2\u0643\u0642\3\2\2\2\u0643"+
		"\u0644\3\2\2\2\u0644\u0645\3\2\2\2\u0645\u0646\5B\"\2\u0646\u014d\3\2"+
		"\2\2\u0647\u064c\5\u014a\u00a6\2\u0648\u0649\7\u00d0\2\2\u0649\u064b\5"+
		"\u014a\u00a6\2\u064a\u0648\3\2\2\2\u064b\u064e\3\2\2\2\u064c\u064a\3\2"+
		"\2\2\u064c\u064d\3\2\2\2\u064d\u014f\3\2\2\2\u064e\u064c\3\2\2\2\u064f"+
		"\u0650\5\u0156\u00ac\2\u0650\u0151\3\2\2\2\u0651\u0652\5\u0156\u00ac\2"+
		"\u0652\u0153\3\2\2\2\u0653\u0654\5\u0156\u00ac\2\u0654\u0155\3\2\2\2\u0655"+
		"\u0656\7\u00d7\2\2\u0656\u0657\5\u0128\u0095\2\u0657\u0658\7\u00d8\2\2"+
		"\u0658\u0157\3\2\2\2\u0659\u0660\5\u015a\u00ae\2\u065a\u0660\5\u015e\u00b0"+
		"\2\u065b\u0660\5\u0162\u00b2\2\u065c\u0660\5\u0168\u00b5\2\u065d\u0660"+
		"\5\u0170\u00b9\2\u065e\u0660\5\u017a\u00be\2\u065f\u0659\3\2\2\2\u065f"+
		"\u065a\3\2\2\2\u065f\u065b\3\2\2\2\u065f\u065c\3\2\2\2\u065f\u065d\3\2"+
		"\2\2\u065f\u065e\3\2\2\2\u0660\u0159\3\2\2\2\u0661\u0662\5\u00e6t\2\u0662"+
		"\u0663\5\u015c\u00af\2\u0663\u0664\5\u00e6t\2\u0664\u015b\3\2\2\2\u0665"+
		"\u0666\t\17\2\2\u0666\u015d\3\2\2\2\u0667\u0668\5\u00e6t\2\u0668\u0669"+
		"\5\u0160\u00b1\2\u0669\u015f\3\2\2\2\u066a\u066c\7\65\2\2\u066b\u066a"+
		"\3\2\2\2\u066b\u066c\3\2\2\2\u066c\u066d\3\2\2\2\u066d\u066f\7U\2\2\u066e"+
		"\u0670\t\20\2\2\u066f\u066e\3\2\2\2\u066f\u0670\3\2\2\2\u0670\u0671\3"+
		"\2\2\2\u0671\u0672\5\u00e6t\2\u0672\u0673\7\6\2\2\u0673\u0674\5\u00e6"+
		"t\2\u0674\u0161\3\2\2\2\u0675\u0677\5\u00a6T\2\u0676\u0678\7\65\2\2\u0677"+
		"\u0676\3\2\2\2\u0677\u0678\3\2\2\2\u0678\u0679\3\2\2\2\u0679\u067a\7\'"+
		"\2\2\u067a\u067b\5\u0164\u00b3\2\u067b\u0163\3\2\2\2\u067c\u0682\5\u0154"+
		"\u00ab\2\u067d\u067e\7\u00d7\2\2\u067e\u067f\5\u0166\u00b4\2\u067f\u0680"+
		"\7\u00d8\2\2\u0680\u0682\3\2\2\2\u0681\u067c\3\2\2\2\u0681\u067d\3\2\2"+
		"\2\u0682\u0165\3\2\2\2\u0683\u0688\5\u00e0q\2\u0684\u0685\7\u00d0\2\2"+
		"\u0685\u0687\5\u00e0q\2\u0686\u0684\3\2\2\2\u0687\u068a\3\2\2\2\u0688"+
		"\u0686\3\2\2\2\u0688\u0689\3\2\2\2\u0689\u0167\3\2\2\2\u068a\u0688\3\2"+
		"\2\2\u068b\u068c\5\u00e6t\2\u068c\u068d\5\u016a\u00b6\2\u068d\u068e\7"+
		"\u00e8\2\2\u068e\u0169\3\2\2\2\u068f\u0691\7\65\2\2\u0690\u068f\3\2\2"+
		"\2\u0690\u0691\3\2\2\2\u0691\u0692\3\2\2\2\u0692\u0695\5\u016c\u00b7\2"+
		"\u0693\u0695\5\u016e\u00b8\2\u0694\u0690\3\2\2\2\u0694\u0693\3\2\2\2\u0695"+
		"\u016b\3\2\2\2\u0696\u069d\7\62\2\2\u0697\u069d\7%\2\2\u0698\u0699\7\u008f"+
		"\2\2\u0699\u069d\7\u009a\2\2\u069a\u069d\7\u008a\2\2\u069b\u069d\7\u008b"+
		"\2\2\u069c\u0696\3\2\2\2\u069c\u0697\3\2\2\2\u069c\u0698\3\2\2\2\u069c"+
		"\u069a\3\2\2\2\u069c\u069b\3\2\2\2\u069d\u016d\3\2\2\2\u069e\u069f\t\21"+
		"\2\2\u069f\u016f\3\2\2\2\u06a0\u06a1\5\u00e6t\2\u06a1\u06a3\7.\2\2\u06a2"+
		"\u06a4\7\65\2\2\u06a3\u06a2\3\2\2\2\u06a3\u06a4\3\2\2\2\u06a4\u06a5\3"+
		"\2\2\2\u06a5\u06a6\7\66\2\2\u06a6\u0171\3\2\2\2\u06a7\u06a8\5\u00a6T\2"+
		"\u06a8\u06a9\5\u015c\u00af\2\u06a9\u06aa\5\u0174\u00bb\2\u06aa\u06ab\5"+
		"\u0154\u00ab\2\u06ab\u0173\3\2\2\2\u06ac\u06af\5\u0176\u00bc\2\u06ad\u06af"+
		"\5\u0178\u00bd\2\u06ae\u06ac\3\2\2\2\u06ae\u06ad\3\2\2\2\u06af\u0175\3"+
		"\2\2\2\u06b0\u06b1\7\5\2\2\u06b1\u0177\3\2\2\2\u06b2\u06b3\t\22\2\2\u06b3"+
		"\u0179\3\2\2\2\u06b4\u06b6\7\65\2\2\u06b5\u06b4\3\2\2\2\u06b5\u06b6\3"+
		"\2\2\2\u06b6\u06b7\3\2\2\2\u06b7\u06b8\7f\2\2\u06b8\u06b9\5\u0154\u00ab"+
		"\2\u06b9\u017b\3\2\2\2\u06ba\u06bb\7M\2\2\u06bb\u06bc\5\u0154\u00ab\2"+
		"\u06bc\u017d\3\2\2\2\u06bd\u06c0\5\u0180\u00c1\2\u06be\u06c0\7\u008d\2"+
		"\2\u06bf\u06bd\3\2\2\2\u06bf\u06be\3\2\2\2\u06c0\u017f\3\2\2\2\u06c1\u06c2"+
		"\t\23\2\2\u06c2\u0181\3\2\2\2\u06c3\u06c4\t\24\2\2\u06c4\u0183\3\2\2\2"+
		"\u06c5\u06c6\5\u0188\u00c5\2\u06c6\u06c8\7\u00d7\2\2\u06c7\u06c9\5\u018a"+
		"\u00c6\2\u06c8\u06c7\3\2\2\2\u06c8\u06c9\3\2\2\2\u06c9\u06ca\3\2\2\2\u06ca"+
		"\u06cb\7\u00d8\2\2\u06cb\u0185\3\2\2\2\u06cc\u06cd\t\25\2\2\u06cd\u0187"+
		"\3\2\2\2\u06ce\u06d1\5B\"\2\u06cf\u06d1\5\u0186\u00c4\2\u06d0\u06ce\3"+
		"\2\2\2\u06d0\u06cf\3\2\2\2\u06d1\u0189\3\2\2\2\u06d2\u06d7\5\u00a2R\2"+
		"\u06d3\u06d4\7\u00d0\2\2\u06d4\u06d6\5\u00a2R\2\u06d5\u06d3\3\2\2\2\u06d6"+
		"\u06d9\3\2\2\2\u06d7\u06d5\3\2\2\2\u06d7\u06d8\3\2\2\2\u06d8\u018b\3\2"+
		"\2\2\u06d9\u06d7\3\2\2\2\u06da\u06db\7<\2\2\u06db\u06dc\7V\2\2\u06dc\u06dd"+
		"\5\u018e\u00c8\2\u06dd\u018d\3\2\2\2\u06de\u06e3\5\u0190\u00c9\2\u06df"+
		"\u06e0\7\u00d0\2\2\u06e0\u06e2\5\u0190\u00c9\2\u06e1\u06df\3\2\2\2\u06e2"+
		"\u06e5\3\2\2\2\u06e3\u06e1\3\2\2\2\u06e3\u06e4\3\2\2\2\u06e4\u018f\3\2"+
		"\2\2\u06e5\u06e3\3\2\2\2\u06e6\u06e8\5\u00e6t\2\u06e7\u06e9\5\u0192\u00ca"+
		"\2\u06e8\u06e7\3\2\2\2\u06e8\u06e9\3\2\2\2\u06e9\u06eb\3\2\2\2\u06ea\u06ec"+
		"\5\u0196\u00cc\2\u06eb\u06ea\3\2\2\2\u06eb\u06ec\3\2\2\2\u06ec\u0191\3"+
		"\2\2\2\u06ed\u06ee\t\26\2\2\u06ee\u0193\3\2\2\2\u06ef\u06f0\7\63\2\2\u06f0"+
		"\u06f1\5\u00a6T\2\u06f1\u0195\3\2\2\2\u06f2\u06f3\7\66\2\2\u06f3\u06f7"+
		"\7j\2\2\u06f4\u06f5\7\66\2\2\u06f5\u06f7\7u\2\2\u06f6\u06f2\3\2\2\2\u06f6"+
		"\u06f4\3\2\2\2\u06f7\u0197\3\2\2\2\u06f8\u06fa\7q\2\2\u06f9\u06fb\7\u0083"+
		"\2\2\u06fa\u06f9\3\2\2\2\u06fa\u06fb\3\2\2\2\u06fb\u06fc\3\2\2\2\u06fc"+
		"\u06fd\7+\2\2\u06fd\u0702\5\u013c\u009f\2\u06fe\u06ff\7\u00d7\2\2\u06ff"+
		"\u0700\5\u010c\u0087\2\u0700\u0701\7\u00d8\2\2\u0701\u0703\3\2\2\2\u0702"+
		"\u06fe\3\2\2\2\u0702\u0703\3\2\2\2\u0703\u0704\3\2\2\2\u0704\u0705\5\u0128"+
		"\u0095\2\u0705\u0716\3\2\2\2\u0706\u0708\7q\2\2\u0707\u0709\7\u0083\2"+
		"\2\u0708\u0707\3\2\2\2\u0708\u0709\3\2\2\2\u0709\u070a\3\2\2\2\u070a\u070b"+
		"\7+\2\2\u070b\u070c\7x\2\2\u070c\u0712\7\u00e8\2\2\u070d\u070e\7O\2\2"+
		"\u070e\u0710\5B\"\2\u070f\u0711\5\34\17\2\u0710\u070f\3\2\2\2\u0710\u0711"+
		"\3\2\2\2\u0711\u0713\3\2\2\2\u0712\u070d\3\2\2\2\u0712\u0713\3\2\2\2\u0713"+
		"\u0714\3\2\2\2\u0714\u0716\5\u0128\u0095\2\u0715\u06f8\3\2\2\2\u0715\u0706"+
		"\3\2\2\2\u0716\u0199\3\2\2\2\u00d0\u019c\u01a0\u01a9\u01b1\u01b5\u01bc"+
		"\u01c2\u01c9\u01cd\u01d1\u01d5\u01d9\u01dd\u01e5\u01ee\u01f2\u01f4\u01f6"+
		"\u01fc\u0201\u0207\u020b\u020f\u0213\u021b\u021d\u022b\u022e\u0239\u023c"+
		"\u023f\u0243\u024a\u024d\u0250\u0255\u025d\u026e\u0283\u0294\u02a1\u02a5"+
		"\u02a7\u02b4\u02bb\u02d3\u02da\u02eb\u02ef\u02f5\u02fa\u02ff\u0317\u031d"+
		"\u0321\u0326\u032b\u032f\u0332\u033b\u0340\u0344\u034a\u0350\u0355\u0359"+
		"\u035b\u035f\u0363\u0365\u0369\u036d\u0371\u0375\u0380\u0384\u038c\u0396"+
		"\u03a7\u03ab\u03af\u03b4\u03b6\u03ba\u03bf\u03c3\u03c5\u03c9\u03d6\u03dd"+
		"\u03e9\u03eb\u03f0\u0412\u0416\u041a\u0421\u0424\u042c\u042f\u0442\u0452"+
		"\u0457\u045e\u0466\u046a\u0474\u047e\u0482\u0492\u0498\u04a1\u04a8\u04b2"+
		"\u04b5\u04b8\u04bf\u04ca\u04d2\u04d8\u04dc\u04e0\u04e8\u04ec\u04f4\u04fc"+
		"\u0500\u0504\u0507\u050a\u050d\u0510\u051a\u051f\u0525\u052b\u0533\u053a"+
		"\u0541\u0549\u0554\u0558\u055e\u056a\u056d\u0573\u0577\u057e\u0580\u0587"+
		"\u059a\u05a1\u05a8\u05af\u05c7\u05ce\u05d4\u05d8\u05dc\u05e1\u05e6\u05ec"+
		"\u05f0\u05f4\u05f9\u05fe\u0605\u0609\u0610\u0617\u0619\u061d\u0621\u0628"+
		"\u062d\u0631\u0635\u063e\u0643\u064c\u065f\u066b\u066f\u0677\u0681\u0688"+
		"\u0690\u0694\u069c\u06a3\u06ae\u06b5\u06bf\u06c8\u06d0\u06d7\u06e3\u06e8"+
		"\u06eb\u06f6\u06fa\u0702\u0708\u0710\u0712\u0715";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}