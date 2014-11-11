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
		FUNCTION=34, ISODOW=132, OVERWRITE=152, FUNCTIONS=35, ROW=68, PRECISION=155, 
		ILIKE=41, Character_String_Literal=257, NOT=58, EXCEPT=27, FOREIGN=32, 
		PRIVILEGES=66, BYTEA=222, STATEMENT=80, CHARACTER=104, MONTH=147, BlockComment=254, 
		VARBIT=192, CREATE=15, STDDEV_POP=167, USING=94, NOT_EQUAL=235, TIMEZONE_MINUTE=176, 
		VERTICAL_BAR=249, VARIADIC=95, TIMESTAMPTZ=217, REGEXP=160, GEQ=239, STDDEV_SAMP=168, 
		DIVIDE=245, BLOB=221, ASC=7, GROUPING=126, SUBPARTITION=169, TEMP=83, 
		ELSE=26, NUMBER=252, BOOL=190, TRAILING=86, SEMI_COLON=232, INT=199, RLIKE=161, 
		RESTRICT=71, LEADING=52, SERVER=164, TABLESPACE=171, MILLISECONDS=144, 
		REAL=204, GROUP=38, INTERSECT=46, LANGUAGE=134, SEQUENCES=76, OUT=63, 
		REAL_NUMBER=253, TRIM=177, LEFT_PAREN=240, LOCATION=139, END=25, CONSTRAINT=14, 
		TIMEZONE_HOUR=175, CAST_EXPRESSION=228, OPTION=151, ISOYEAR=133, NCHAR=211, 
		EXECUTE=28, TABLE=82, VARCHAR=210, FLOAT=205, MICROSECONDS=142, VERSION=184, 
		ASYMMETRIC=6, SUM=170, Space=258, INOUT=48, TIME=214, AS=2, RIGHT_PAREN=241, 
		THEN=85, MAXVALUE=141, REPLACE=70, LEFT=53, AVG=100, TRUNCATE=89, ZONE=188, 
		COLUMN=107, PLUS=242, EXISTS=119, NVARCHAR=212, Not_Similar_To=225, LIKE=54, 
		INTEGER=200, OUTER=62, BY=102, DEFERRABLE=19, TO=178, RIGHT=73, SET=165, 
		HAVING=39, SESSION=78, MIN=145, MINUS=243, TEXT=218, HOUR=128, CONCATENATION_OPERATOR=234, 
		UNION=90, COLON=231, SCHEMA=74, DATABASE=17, DECIMAL=208, DROP=116, BIGINT=201, 
		WHEN=96, BIT=191, LARGE=135, REVOKE=72, NATURAL=57, FORMAT=124, PUBLIC=156, 
		EXTENSION=29, BETWEEN=101, FIRST=123, CAST=12, EXTERNAL=120, WEEK=185, 
		DOUBLE_QUOTE=251, VARYING=183, TRIGGER=87, CASE=10, CHAR=209, INT8=196, 
		COUNT=108, DAY=111, CASCADE=11, INT2=194, INT1=193, Identifier=256, INT4=195, 
		QUOTE=250, MODULAR=246, FULL=33, QUARTER=158, THAN=173, INSERT=130, CONNECT=13, 
		INTERSECTION=131, LESS=137, TINYINT=197, BOTH=9, Similar_To_Case_Insensitive=226, 
		DOUBLE=206, ADMIN=99, SYMMETRIC=81, EACH=24, LAST=136, SELECT=77, INTO=47, 
		UNIQUE=91, COALESCE=106, SECOND=163, EPOCH=117, ROLLUP=162, NULL=59, EVERY=118, 
		ON=61, DELETE=21, INET4=223, NUMERIC=207, LOCAL=56, OF=60, LIST=138, TABLES=172, 
		UNDERLINE=248, SEQUENCE=75, Not_Similar_To_Case_Insensitive=227, CUBE=109, 
		NATIONAL=148, OR=64, VAR_POP=182, FILTER=122, FROM=36, FALSE=30, COLLECT=105, 
		TEMPORARY=84, DISTINCT=23, TIMESTAMP=216, WHERE=97, DEC=112, NULLIF=149, 
		VAR_SAMP=181, TIMETZ=215, INNER=45, YEAR=187, ORDER=65, TIMEZONE=174, 
		LIMIT=55, DECADE=113, GTH=238, White_Space=259, UPDATE=92, MAX=140, LineComment=255, 
		DEFERRED=20, FOR=31, FLOAT4=202, FLOAT8=203, AND=4, CROSS=16, Similar_To=224, 
		USAGE=93, IF=40, INDEX=129, BOOLEAN=189, IN=43, UNKNOWN=179, MULTIPLY=244, 
		OBJECT=150, COMMA=233, REFERENCES=69, IS=50, PARTITION=153, PARTITIONS=154, 
		SOME=79, EQUAL=230, ALL=3, DOT=247, EXTRACT=121, CENTURY=103, DOW=114, 
		WITH=98, INITIALLY=44, DOY=115, FUSION=125, GRANT=37, VARBINARY=220, DEFAULT=18, 
		VALUES=180, HASH=127, MILLENNIUM=143, RANGE=159, BEFORE=8, PURGE=157, 
		AFTER=1, INSTEAD=49, TRUE=88, WRAPPER=186, PROCEDURE=67, JOIN=51, SIMILAR=166, 
		LTH=236, ANY=5, BAD=260, ASSIGN=229, IMMEDIATE=42, BINARY=219, DESC=22, 
		DATE=213, MINUTE=146, DATA=110, LEQ=237, SMALLINT=198;
	public static final String[] tokenNames = {
		"<INVALID>", "AFTER", "AS", "ALL", "AND", "ANY", "ASYMMETRIC", "ASC", 
		"BEFORE", "BOTH", "CASE", "CASCADE", "CAST", "CONNECT", "CONSTRAINT", 
		"CREATE", "CROSS", "DATABASE", "DEFAULT", "DEFERRABLE", "DEFERRED", "DELETE", 
		"DESC", "DISTINCT", "EACH", "END", "ELSE", "EXCEPT", "EXECUTE", "EXTENSION", 
		"FALSE", "FOR", "FOREIGN", "FULL", "FUNCTION", "FUNCTIONS", "FROM", "GRANT", 
		"GROUP", "HAVING", "IF", "ILIKE", "IMMEDIATE", "IN", "INITIALLY", "INNER", 
		"INTERSECT", "INTO", "INOUT", "INSTEAD", "IS", "JOIN", "LEADING", "LEFT", 
		"LIKE", "LIMIT", "LOCAL", "NATURAL", "NOT", "NULL", "OF", "ON", "OUTER", 
		"OUT", "OR", "ORDER", "PRIVILEGES", "PROCEDURE", "ROW", "REFERENCES", 
		"REPLACE", "RESTRICT", "REVOKE", "RIGHT", "SCHEMA", "SEQUENCE", "SEQUENCES", 
		"SELECT", "SESSION", "SOME", "STATEMENT", "SYMMETRIC", "TABLE", "TEMP", 
		"TEMPORARY", "THEN", "TRAILING", "TRIGGER", "TRUE", "TRUNCATE", "UNION", 
		"UNIQUE", "UPDATE", "USAGE", "USING", "VARIADIC", "WHEN", "WHERE", "WITH", 
		"ADMIN", "AVG", "BETWEEN", "BY", "CENTURY", "CHARACTER", "COLLECT", "COALESCE", 
		"COLUMN", "COUNT", "CUBE", "DATA", "DAY", "DEC", "DECADE", "DOW", "DOY", 
		"DROP", "EPOCH", "EVERY", "EXISTS", "EXTERNAL", "EXTRACT", "FILTER", "FIRST", 
		"FORMAT", "FUSION", "GROUPING", "HASH", "HOUR", "INDEX", "INSERT", "INTERSECTION", 
		"ISODOW", "ISOYEAR", "LANGUAGE", "LARGE", "LAST", "LESS", "LIST", "LOCATION", 
		"MAX", "MAXVALUE", "MICROSECONDS", "MILLENNIUM", "MILLISECONDS", "MIN", 
		"MINUTE", "MONTH", "NATIONAL", "NULLIF", "OBJECT", "OPTION", "OVERWRITE", 
		"PARTITION", "PARTITIONS", "PRECISION", "PUBLIC", "PURGE", "QUARTER", 
		"RANGE", "REGEXP", "RLIKE", "ROLLUP", "SECOND", "SERVER", "SET", "SIMILAR", 
		"STDDEV_POP", "STDDEV_SAMP", "SUBPARTITION", "SUM", "TABLESPACE", "TABLES", 
		"THAN", "TIMEZONE", "TIMEZONE_HOUR", "TIMEZONE_MINUTE", "TRIM", "TO", 
		"UNKNOWN", "VALUES", "VAR_SAMP", "VAR_POP", "VARYING", "VERSION", "WEEK", 
		"WRAPPER", "YEAR", "ZONE", "BOOLEAN", "BOOL", "BIT", "VARBIT", "INT1", 
		"INT2", "INT4", "INT8", "TINYINT", "SMALLINT", "INT", "INTEGER", "BIGINT", 
		"FLOAT4", "FLOAT8", "REAL", "FLOAT", "DOUBLE", "NUMERIC", "DECIMAL", "CHAR", 
		"VARCHAR", "NCHAR", "NVARCHAR", "DATE", "TIME", "TIMETZ", "TIMESTAMP", 
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
		RULE_set_statement = 7, RULE_create_trigger_statement = 8, RULE_revoke_statement = 9, 
		RULE_grant_statement = 10, RULE_grant_to_rule = 11, RULE_argmode = 12, 
		RULE_function_definition = 13, RULE_functions_definition_schema = 14, 
		RULE_create_table_statement = 15, RULE_table_elements = 16, RULE_field_element = 17, 
		RULE_field_type = 18, RULE_param_clause = 19, RULE_param = 20, RULE_method_specifier = 21, 
		RULE_table_space_specifier = 22, RULE_table_space_name = 23, RULE_table_partitioning_clauses = 24, 
		RULE_range_partitions = 25, RULE_range_value_clause_list = 26, RULE_range_value_clause = 27, 
		RULE_hash_partitions = 28, RULE_individual_hash_partitions = 29, RULE_individual_hash_partition = 30, 
		RULE_hash_partitions_by_quantity = 31, RULE_list_partitions = 32, RULE_list_value_clause_list = 33, 
		RULE_list_value_partition = 34, RULE_column_partitions = 35, RULE_partition_name = 36, 
		RULE_drop_table_statement = 37, RULE_identifier = 38, RULE_nonreserved_keywords = 39, 
		RULE_unsigned_literal = 40, RULE_general_literal = 41, RULE_datetime_literal = 42, 
		RULE_time_literal = 43, RULE_timestamp_literal = 44, RULE_date_literal = 45, 
		RULE_boolean_literal = 46, RULE_data_type = 47, RULE_predefined_type = 48, 
		RULE_network_type = 49, RULE_character_string_type = 50, RULE_type_length = 51, 
		RULE_national_character_string_type = 52, RULE_binary_large_object_string_type = 53, 
		RULE_numeric_type = 54, RULE_exact_numeric_type = 55, RULE_approximate_numeric_type = 56, 
		RULE_precision_param = 57, RULE_boolean_type = 58, RULE_datetime_type = 59, 
		RULE_bit_type = 60, RULE_binary_type = 61, RULE_value_expression_primary = 62, 
		RULE_parenthesized_value_expression = 63, RULE_nonparenthesized_value_expression_primary = 64, 
		RULE_unsigned_value_specification = 65, RULE_unsigned_numeric_literal = 66, 
		RULE_signed_numerical_literal = 67, RULE_set_function_specification = 68, 
		RULE_aggregate_function = 69, RULE_general_set_function = 70, RULE_set_function_type = 71, 
		RULE_filter_clause = 72, RULE_grouping_operation = 73, RULE_case_expression = 74, 
		RULE_case_abbreviation = 75, RULE_case_specification = 76, RULE_simple_case = 77, 
		RULE_searched_case = 78, RULE_simple_when_clause = 79, RULE_searched_when_clause = 80, 
		RULE_else_clause = 81, RULE_result = 82, RULE_cast_specification = 83, 
		RULE_cast_operand = 84, RULE_cast_target = 85, RULE_value_expression = 86, 
		RULE_common_value_expression = 87, RULE_numeric_value_expression = 88, 
		RULE_term = 89, RULE_factor = 90, RULE_array = 91, RULE_numeric_primary = 92, 
		RULE_sign = 93, RULE_numeric_value_function = 94, RULE_extract_expression = 95, 
		RULE_extract_field = 96, RULE_time_zone_field = 97, RULE_extract_source = 98, 
		RULE_string_value_expression = 99, RULE_character_value_expression = 100, 
		RULE_character_factor = 101, RULE_character_primary = 102, RULE_string_value_function = 103, 
		RULE_trim_function = 104, RULE_trim_operands = 105, RULE_trim_specification = 106, 
		RULE_boolean_value_expression = 107, RULE_or_predicate = 108, RULE_and_predicate = 109, 
		RULE_boolean_factor = 110, RULE_boolean_test = 111, RULE_is_clause = 112, 
		RULE_truth_value = 113, RULE_boolean_primary = 114, RULE_boolean_predicand = 115, 
		RULE_parenthesized_boolean_value_expression = 116, RULE_row_value_expression = 117, 
		RULE_row_value_special_case = 118, RULE_explicit_row_value_constructor = 119, 
		RULE_row_value_predicand = 120, RULE_row_value_constructor_predicand = 121, 
		RULE_table_expression = 122, RULE_from_clause = 123, RULE_table_reference_list = 124, 
		RULE_table_reference = 125, RULE_joined_table = 126, RULE_joined_table_primary = 127, 
		RULE_cross_join = 128, RULE_qualified_join = 129, RULE_natural_join = 130, 
		RULE_union_join = 131, RULE_join_type = 132, RULE_outer_join_type = 133, 
		RULE_outer_join_type_part2 = 134, RULE_join_specification = 135, RULE_join_condition = 136, 
		RULE_named_columns_join = 137, RULE_table_primary = 138, RULE_column_name_list = 139, 
		RULE_derived_table = 140, RULE_where_clause = 141, RULE_search_condition = 142, 
		RULE_groupby_clause = 143, RULE_grouping_element_list = 144, RULE_grouping_element = 145, 
		RULE_ordinary_grouping_set = 146, RULE_ordinary_grouping_set_list = 147, 
		RULE_rollup_list = 148, RULE_cube_list = 149, RULE_empty_grouping_set = 150, 
		RULE_having_clause = 151, RULE_row_value_predicand_list = 152, RULE_query_expression = 153, 
		RULE_query_expression_body = 154, RULE_non_join_query_expression = 155, 
		RULE_query_term = 156, RULE_non_join_query_term = 157, RULE_query_primary = 158, 
		RULE_non_join_query_primary = 159, RULE_simple_table = 160, RULE_explicit_table = 161, 
		RULE_table_or_query_name = 162, RULE_table_name = 163, RULE_query_specification = 164, 
		RULE_select_list = 165, RULE_select_sublist = 166, RULE_derived_column = 167, 
		RULE_qualified_asterisk = 168, RULE_set_qualifier = 169, RULE_column_reference = 170, 
		RULE_as_clause = 171, RULE_column_reference_list = 172, RULE_scalar_subquery = 173, 
		RULE_row_subquery = 174, RULE_table_subquery = 175, RULE_subquery = 176, 
		RULE_predicate = 177, RULE_comparison_predicate = 178, RULE_comp_op = 179, 
		RULE_between_predicate = 180, RULE_between_predicate_part_2 = 181, RULE_in_predicate = 182, 
		RULE_in_predicate_value = 183, RULE_in_value_list = 184, RULE_pattern_matching_predicate = 185, 
		RULE_pattern_matcher = 186, RULE_negativable_matcher = 187, RULE_regex_matcher = 188, 
		RULE_null_predicate = 189, RULE_quantified_comparison_predicate = 190, 
		RULE_quantifier = 191, RULE_all = 192, RULE_some = 193, RULE_exists_predicate = 194, 
		RULE_unique_predicate = 195, RULE_primary_datetime_field = 196, RULE_non_second_primary_datetime_field = 197, 
		RULE_extended_datetime_field = 198, RULE_routine_invocation = 199, RULE_function_names_for_reserved_words = 200, 
		RULE_function_name = 201, RULE_sql_argument_list = 202, RULE_orderby_clause = 203, 
		RULE_sort_specifier_list = 204, RULE_sort_specifier = 205, RULE_order_specification = 206, 
		RULE_limit_clause = 207, RULE_null_ordering = 208, RULE_insert_statement = 209;
	public static final String[] ruleNames = {
		"sql", "statement", "data_statement", "data_change_statement", "schema_statement", 
		"index_statement", "create_extension_statement", "set_statement", "create_trigger_statement", 
		"revoke_statement", "grant_statement", "grant_to_rule", "argmode", "function_definition", 
		"functions_definition_schema", "create_table_statement", "table_elements", 
		"field_element", "field_type", "param_clause", "param", "method_specifier", 
		"table_space_specifier", "table_space_name", "table_partitioning_clauses", 
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
			setState(424); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(420); statement();
				setState(422);
				_la = _input.LA(1);
				if (_la==SEMI_COLON) {
					{
					setState(421); match(SEMI_COLON);
					}
				}

				}
				}
				setState(426); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==CREATE || _la==GRANT || ((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & ((1L << (REVOKE - 72)) | (1L << (SELECT - 72)) | (1L << (TABLE - 72)) | (1L << (ADMIN - 72)) | (1L << (AVG - 72)) | (1L << (BETWEEN - 72)) | (1L << (BY - 72)) | (1L << (CENTURY - 72)) | (1L << (CHARACTER - 72)) | (1L << (COLLECT - 72)) | (1L << (COALESCE - 72)) | (1L << (COLUMN - 72)) | (1L << (COUNT - 72)) | (1L << (CUBE - 72)) | (1L << (DATA - 72)) | (1L << (DAY - 72)) | (1L << (DEC - 72)) | (1L << (DECADE - 72)) | (1L << (DOW - 72)) | (1L << (DOY - 72)) | (1L << (DROP - 72)) | (1L << (EPOCH - 72)) | (1L << (EVERY - 72)) | (1L << (EXISTS - 72)) | (1L << (EXTERNAL - 72)) | (1L << (EXTRACT - 72)) | (1L << (FILTER - 72)) | (1L << (FIRST - 72)) | (1L << (FORMAT - 72)) | (1L << (FUSION - 72)) | (1L << (GROUPING - 72)) | (1L << (HASH - 72)) | (1L << (INDEX - 72)) | (1L << (INSERT - 72)) | (1L << (INTERSECTION - 72)) | (1L << (ISODOW - 72)) | (1L << (ISOYEAR - 72)) | (1L << (LANGUAGE - 72)) | (1L << (LARGE - 72)))) != 0) || ((((_la - 136)) & ~0x3f) == 0 && ((1L << (_la - 136)) & ((1L << (LAST - 136)) | (1L << (LESS - 136)) | (1L << (LIST - 136)) | (1L << (LOCATION - 136)) | (1L << (MAX - 136)) | (1L << (MAXVALUE - 136)) | (1L << (MICROSECONDS - 136)) | (1L << (MILLENNIUM - 136)) | (1L << (MILLISECONDS - 136)) | (1L << (MIN - 136)) | (1L << (MINUTE - 136)) | (1L << (MONTH - 136)) | (1L << (NATIONAL - 136)) | (1L << (NULLIF - 136)) | (1L << (OBJECT - 136)) | (1L << (OPTION - 136)) | (1L << (OVERWRITE - 136)) | (1L << (PARTITION - 136)) | (1L << (PARTITIONS - 136)) | (1L << (PRECISION - 136)) | (1L << (PUBLIC - 136)) | (1L << (PURGE - 136)) | (1L << (QUARTER - 136)) | (1L << (RANGE - 136)) | (1L << (REGEXP - 136)) | (1L << (RLIKE - 136)) | (1L << (ROLLUP - 136)) | (1L << (SECOND - 136)) | (1L << (SERVER - 136)) | (1L << (SET - 136)) | (1L << (SIMILAR - 136)) | (1L << (STDDEV_POP - 136)) | (1L << (STDDEV_SAMP - 136)) | (1L << (SUBPARTITION - 136)) | (1L << (SUM - 136)) | (1L << (TABLESPACE - 136)) | (1L << (THAN - 136)) | (1L << (TIMEZONE - 136)) | (1L << (TIMEZONE_HOUR - 136)) | (1L << (TIMEZONE_MINUTE - 136)) | (1L << (TRIM - 136)) | (1L << (TO - 136)) | (1L << (UNKNOWN - 136)) | (1L << (VALUES - 136)) | (1L << (VAR_SAMP - 136)) | (1L << (VAR_POP - 136)) | (1L << (VARYING - 136)) | (1L << (WEEK - 136)) | (1L << (WRAPPER - 136)) | (1L << (YEAR - 136)) | (1L << (ZONE - 136)) | (1L << (BOOLEAN - 136)) | (1L << (BOOL - 136)) | (1L << (BIT - 136)) | (1L << (VARBIT - 136)) | (1L << (INT1 - 136)) | (1L << (INT2 - 136)) | (1L << (INT4 - 136)) | (1L << (INT8 - 136)) | (1L << (TINYINT - 136)) | (1L << (SMALLINT - 136)) | (1L << (INT - 136)))) != 0) || ((((_la - 200)) & ~0x3f) == 0 && ((1L << (_la - 200)) & ((1L << (INTEGER - 200)) | (1L << (BIGINT - 200)) | (1L << (FLOAT4 - 200)) | (1L << (FLOAT8 - 200)) | (1L << (REAL - 200)) | (1L << (FLOAT - 200)) | (1L << (DOUBLE - 200)) | (1L << (NUMERIC - 200)) | (1L << (DECIMAL - 200)) | (1L << (CHAR - 200)) | (1L << (VARCHAR - 200)) | (1L << (NCHAR - 200)) | (1L << (NVARCHAR - 200)) | (1L << (DATE - 200)) | (1L << (TIME - 200)) | (1L << (TIMETZ - 200)) | (1L << (TIMESTAMP - 200)) | (1L << (TIMESTAMPTZ - 200)) | (1L << (TEXT - 200)) | (1L << (VARBINARY - 200)) | (1L << (BLOB - 200)) | (1L << (BYTEA - 200)) | (1L << (INET4 - 200)) | (1L << (LEFT_PAREN - 200)) | (1L << (Identifier - 200)))) != 0) );
			setState(428); match(EOF);
			}
		}
		catch (RecognitionException re) {
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
			setState(439);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(430); data_statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(431); data_change_statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(432); schema_statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(433); index_statement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(434); create_extension_statement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(435); set_statement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(436); create_trigger_statement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(437); grant_statement();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(438); revoke_statement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
			setState(441); query_expression();
			}
		}
		catch (RecognitionException re) {
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
			setState(443); insert_statement();
			}
		}
		catch (RecognitionException re) {
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
			setState(447);
			switch (_input.LA(1)) {
			case CREATE:
				enterOuterAlt(_localctx, 1);
				{
				setState(445); create_table_statement();
				}
				break;
			case DROP:
				enterOuterAlt(_localctx, 2);
				{
				setState(446); drop_table_statement();
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
			setState(449); match(CREATE);
			setState(451);
			_la = _input.LA(1);
			if (_la==UNIQUE) {
				{
				setState(450); ((Index_statementContext)_localctx).u = match(UNIQUE);
				}
			}

			setState(453); match(INDEX);
			setState(454); ((Index_statementContext)_localctx).n = identifier();
			setState(455); match(ON);
			setState(456); ((Index_statementContext)_localctx).t = table_name();
			setState(458);
			_la = _input.LA(1);
			if (_la==USING) {
				{
				setState(457); ((Index_statementContext)_localctx).m = method_specifier();
				}
			}

			setState(460); match(LEFT_PAREN);
			setState(461); ((Index_statementContext)_localctx).s = sort_specifier_list();
			setState(462); match(RIGHT_PAREN);
			setState(464);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(463); ((Index_statementContext)_localctx).p = param_clause();
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
			setState(466); match(CREATE);
			setState(467); match(EXTENSION);
			setState(471);
			_la = _input.LA(1);
			if (_la==IF) {
				{
				setState(468); match(IF);
				setState(469); match(NOT);
				setState(470); match(EXISTS);
				}
			}

			setState(473); ((Create_extension_statementContext)_localctx).name = identifier();
			setState(475);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(474); match(WITH);
				}
			}

			setState(479);
			_la = _input.LA(1);
			if (_la==SCHEMA) {
				{
				setState(477); match(SCHEMA);
				setState(478); ((Create_extension_statementContext)_localctx).schema_name = identifier();
				}
			}

			setState(483);
			_la = _input.LA(1);
			if (_la==VERSION) {
				{
				setState(481); match(VERSION);
				setState(482); ((Create_extension_statementContext)_localctx).version = identifier();
				}
			}

			setState(487);
			_la = _input.LA(1);
			if (_la==FROM) {
				{
				setState(485); match(FROM);
				setState(486); ((Create_extension_statementContext)_localctx).old_version = identifier();
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
			setState(528);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(489); match(SET);
				setState(491);
				_la = _input.LA(1);
				if (_la==LOCAL || _la==SESSION) {
					{
					setState(490);
					_la = _input.LA(1);
					if ( !(_la==LOCAL || _la==SESSION) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(493); ((Set_statementContext)_localctx).config_param = identifier();
				setState(494);
				_la = _input.LA(1);
				if ( !(_la==TO || _la==EQUAL) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(506); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(501);
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
							setState(495); ((Set_statementContext)_localctx).value = identifier();
							}
							break;
						case QUOTE:
							{
							setState(496); match(QUOTE);
							setState(497); ((Set_statementContext)_localctx).value = identifier();
							setState(498); match(QUOTE);
							}
							break;
						case DEFAULT:
							{
							setState(500); match(DEFAULT);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(504);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(503); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(508); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(510); match(SET);
				setState(512);
				_la = _input.LA(1);
				if (_la==LOCAL || _la==SESSION) {
					{
					setState(511);
					_la = _input.LA(1);
					if ( !(_la==LOCAL || _la==SESSION) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(514); match(TIME);
				setState(515); match(ZONE);
				setState(524); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(519);
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
							setState(516); ((Set_statementContext)_localctx).timezone = identifier();
							}
							break;
						case LOCAL:
							{
							setState(517); match(LOCAL);
							}
							break;
						case DEFAULT:
							{
							setState(518); match(DEFAULT);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(522);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(521); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(526); 
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
			setState(530); match(CREATE);
			setState(532);
			_la = _input.LA(1);
			if (_la==CONSTRAINT) {
				{
				setState(531); match(CONSTRAINT);
				}
			}

			setState(534); match(TRIGGER);
			setState(535); ((Create_trigger_statementContext)_localctx).name = identifier();
			setState(540);
			switch (_input.LA(1)) {
			case BEFORE:
				{
				setState(536); match(BEFORE);
				}
				break;
			case INSTEAD:
				{
				{
				setState(537); match(INSTEAD);
				setState(538); match(OF);
				}
				}
				break;
			case AFTER:
				{
				setState(539); match(AFTER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(557);
			switch (_input.LA(1)) {
			case INSERT:
				{
				setState(542); match(INSERT);
				}
				break;
			case DELETE:
				{
				setState(543); match(DELETE);
				}
				break;
			case TRUNCATE:
				{
				setState(544); match(TRUNCATE);
				}
				break;
			case UPDATE:
				{
				{
				setState(545); match(UPDATE);
				setState(555);
				_la = _input.LA(1);
				if (_la==OF) {
					{
					setState(546); match(OF);
					setState(551); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(547); ((Create_trigger_statementContext)_localctx).columnName = identifier();
						setState(549);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(548); match(COMMA);
							}
						}

						}
						}
						setState(553); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 99)) & ~0x3f) == 0 && ((1L << (_la - 99)) & ((1L << (ADMIN - 99)) | (1L << (AVG - 99)) | (1L << (BETWEEN - 99)) | (1L << (BY - 99)) | (1L << (CENTURY - 99)) | (1L << (CHARACTER - 99)) | (1L << (COLLECT - 99)) | (1L << (COALESCE - 99)) | (1L << (COLUMN - 99)) | (1L << (COUNT - 99)) | (1L << (CUBE - 99)) | (1L << (DATA - 99)) | (1L << (DAY - 99)) | (1L << (DEC - 99)) | (1L << (DECADE - 99)) | (1L << (DOW - 99)) | (1L << (DOY - 99)) | (1L << (DROP - 99)) | (1L << (EPOCH - 99)) | (1L << (EVERY - 99)) | (1L << (EXISTS - 99)) | (1L << (EXTERNAL - 99)) | (1L << (EXTRACT - 99)) | (1L << (FILTER - 99)) | (1L << (FIRST - 99)) | (1L << (FORMAT - 99)) | (1L << (FUSION - 99)) | (1L << (GROUPING - 99)) | (1L << (HASH - 99)) | (1L << (INDEX - 99)) | (1L << (INSERT - 99)) | (1L << (INTERSECTION - 99)) | (1L << (ISODOW - 99)) | (1L << (ISOYEAR - 99)) | (1L << (LANGUAGE - 99)) | (1L << (LARGE - 99)) | (1L << (LAST - 99)) | (1L << (LESS - 99)) | (1L << (LIST - 99)) | (1L << (LOCATION - 99)) | (1L << (MAX - 99)) | (1L << (MAXVALUE - 99)) | (1L << (MICROSECONDS - 99)) | (1L << (MILLENNIUM - 99)) | (1L << (MILLISECONDS - 99)) | (1L << (MIN - 99)) | (1L << (MINUTE - 99)) | (1L << (MONTH - 99)) | (1L << (NATIONAL - 99)) | (1L << (NULLIF - 99)) | (1L << (OBJECT - 99)) | (1L << (OPTION - 99)) | (1L << (OVERWRITE - 99)) | (1L << (PARTITION - 99)) | (1L << (PARTITIONS - 99)) | (1L << (PRECISION - 99)) | (1L << (PUBLIC - 99)) | (1L << (PURGE - 99)) | (1L << (QUARTER - 99)) | (1L << (RANGE - 99)) | (1L << (REGEXP - 99)) | (1L << (RLIKE - 99)) | (1L << (ROLLUP - 99)))) != 0) || ((((_la - 163)) & ~0x3f) == 0 && ((1L << (_la - 163)) & ((1L << (SECOND - 163)) | (1L << (SERVER - 163)) | (1L << (SET - 163)) | (1L << (SIMILAR - 163)) | (1L << (STDDEV_POP - 163)) | (1L << (STDDEV_SAMP - 163)) | (1L << (SUBPARTITION - 163)) | (1L << (SUM - 163)) | (1L << (TABLESPACE - 163)) | (1L << (THAN - 163)) | (1L << (TIMEZONE - 163)) | (1L << (TIMEZONE_HOUR - 163)) | (1L << (TIMEZONE_MINUTE - 163)) | (1L << (TRIM - 163)) | (1L << (TO - 163)) | (1L << (UNKNOWN - 163)) | (1L << (VALUES - 163)) | (1L << (VAR_SAMP - 163)) | (1L << (VAR_POP - 163)) | (1L << (VARYING - 163)) | (1L << (WEEK - 163)) | (1L << (WRAPPER - 163)) | (1L << (YEAR - 163)) | (1L << (ZONE - 163)) | (1L << (BOOLEAN - 163)) | (1L << (BOOL - 163)) | (1L << (BIT - 163)) | (1L << (VARBIT - 163)) | (1L << (INT1 - 163)) | (1L << (INT2 - 163)) | (1L << (INT4 - 163)) | (1L << (INT8 - 163)) | (1L << (TINYINT - 163)) | (1L << (SMALLINT - 163)) | (1L << (INT - 163)) | (1L << (INTEGER - 163)) | (1L << (BIGINT - 163)) | (1L << (FLOAT4 - 163)) | (1L << (FLOAT8 - 163)) | (1L << (REAL - 163)) | (1L << (FLOAT - 163)) | (1L << (DOUBLE - 163)) | (1L << (NUMERIC - 163)) | (1L << (DECIMAL - 163)) | (1L << (CHAR - 163)) | (1L << (VARCHAR - 163)) | (1L << (NCHAR - 163)) | (1L << (NVARCHAR - 163)) | (1L << (DATE - 163)) | (1L << (TIME - 163)) | (1L << (TIMETZ - 163)) | (1L << (TIMESTAMP - 163)) | (1L << (TIMESTAMPTZ - 163)) | (1L << (TEXT - 163)) | (1L << (VARBINARY - 163)) | (1L << (BLOB - 163)) | (1L << (BYTEA - 163)) | (1L << (INET4 - 163)))) != 0) || _la==Identifier );
					}
				}

				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(559); match(ON);
			setState(560); ((Create_trigger_statementContext)_localctx).tabl_name = table_name();
			setState(563);
			_la = _input.LA(1);
			if (_la==FROM) {
				{
				setState(561); match(FROM);
				setState(562); ((Create_trigger_statementContext)_localctx).referenced_table_name = table_name();
				}
			}

			setState(574);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				{
				setState(565); match(NOT);
				setState(566); match(DEFERRABLE);
				}
				break;
			case 2:
				{
				setState(568);
				_la = _input.LA(1);
				if (_la==DEFERRABLE) {
					{
					setState(567); match(DEFERRABLE);
					}
				}

				{
				setState(570); match(INITIALLY);
				setState(571); match(IMMEDIATE);
				}
				}
				break;
			case 3:
				{
				{
				setState(572); match(INITIALLY);
				setState(573); match(DEFERRED);
				}
				}
				break;
			}
			setState(582);
			switch (_input.LA(1)) {
			case FOR:
				{
				setState(576); match(FOR);
				setState(578);
				_la = _input.LA(1);
				if (_la==EACH) {
					{
					setState(577); match(EACH);
					}
				}

				setState(580); match(ROW);
				}
				break;
			case STATEMENT:
				{
				setState(581); match(STATEMENT);
				}
				break;
			case EXECUTE:
			case WHEN:
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(586);
			_la = _input.LA(1);
			if (_la==WHEN) {
				{
				setState(584); match(WHEN);
				{
				setState(585); boolean_value_expression();
				}
				}
			}

			setState(588); match(EXECUTE);
			setState(589); match(PROCEDURE);
			setState(590); ((Create_trigger_statementContext)_localctx).func_name = identifier();
			setState(591); match(LEFT_PAREN);
			setState(596);
			_la = _input.LA(1);
			if (((((_la - 99)) & ~0x3f) == 0 && ((1L << (_la - 99)) & ((1L << (ADMIN - 99)) | (1L << (AVG - 99)) | (1L << (BETWEEN - 99)) | (1L << (BY - 99)) | (1L << (CENTURY - 99)) | (1L << (CHARACTER - 99)) | (1L << (COLLECT - 99)) | (1L << (COALESCE - 99)) | (1L << (COLUMN - 99)) | (1L << (COUNT - 99)) | (1L << (CUBE - 99)) | (1L << (DATA - 99)) | (1L << (DAY - 99)) | (1L << (DEC - 99)) | (1L << (DECADE - 99)) | (1L << (DOW - 99)) | (1L << (DOY - 99)) | (1L << (DROP - 99)) | (1L << (EPOCH - 99)) | (1L << (EVERY - 99)) | (1L << (EXISTS - 99)) | (1L << (EXTERNAL - 99)) | (1L << (EXTRACT - 99)) | (1L << (FILTER - 99)) | (1L << (FIRST - 99)) | (1L << (FORMAT - 99)) | (1L << (FUSION - 99)) | (1L << (GROUPING - 99)) | (1L << (HASH - 99)) | (1L << (INDEX - 99)) | (1L << (INSERT - 99)) | (1L << (INTERSECTION - 99)) | (1L << (ISODOW - 99)) | (1L << (ISOYEAR - 99)) | (1L << (LANGUAGE - 99)) | (1L << (LARGE - 99)) | (1L << (LAST - 99)) | (1L << (LESS - 99)) | (1L << (LIST - 99)) | (1L << (LOCATION - 99)) | (1L << (MAX - 99)) | (1L << (MAXVALUE - 99)) | (1L << (MICROSECONDS - 99)) | (1L << (MILLENNIUM - 99)) | (1L << (MILLISECONDS - 99)) | (1L << (MIN - 99)) | (1L << (MINUTE - 99)) | (1L << (MONTH - 99)) | (1L << (NATIONAL - 99)) | (1L << (NULLIF - 99)) | (1L << (OBJECT - 99)) | (1L << (OPTION - 99)) | (1L << (OVERWRITE - 99)) | (1L << (PARTITION - 99)) | (1L << (PARTITIONS - 99)) | (1L << (PRECISION - 99)) | (1L << (PUBLIC - 99)) | (1L << (PURGE - 99)) | (1L << (QUARTER - 99)) | (1L << (RANGE - 99)) | (1L << (REGEXP - 99)) | (1L << (RLIKE - 99)) | (1L << (ROLLUP - 99)))) != 0) || ((((_la - 163)) & ~0x3f) == 0 && ((1L << (_la - 163)) & ((1L << (SECOND - 163)) | (1L << (SERVER - 163)) | (1L << (SET - 163)) | (1L << (SIMILAR - 163)) | (1L << (STDDEV_POP - 163)) | (1L << (STDDEV_SAMP - 163)) | (1L << (SUBPARTITION - 163)) | (1L << (SUM - 163)) | (1L << (TABLESPACE - 163)) | (1L << (THAN - 163)) | (1L << (TIMEZONE - 163)) | (1L << (TIMEZONE_HOUR - 163)) | (1L << (TIMEZONE_MINUTE - 163)) | (1L << (TRIM - 163)) | (1L << (TO - 163)) | (1L << (UNKNOWN - 163)) | (1L << (VALUES - 163)) | (1L << (VAR_SAMP - 163)) | (1L << (VAR_POP - 163)) | (1L << (VARYING - 163)) | (1L << (WEEK - 163)) | (1L << (WRAPPER - 163)) | (1L << (YEAR - 163)) | (1L << (ZONE - 163)) | (1L << (BOOLEAN - 163)) | (1L << (BOOL - 163)) | (1L << (BIT - 163)) | (1L << (VARBIT - 163)) | (1L << (INT1 - 163)) | (1L << (INT2 - 163)) | (1L << (INT4 - 163)) | (1L << (INT8 - 163)) | (1L << (TINYINT - 163)) | (1L << (SMALLINT - 163)) | (1L << (INT - 163)) | (1L << (INTEGER - 163)) | (1L << (BIGINT - 163)) | (1L << (FLOAT4 - 163)) | (1L << (FLOAT8 - 163)) | (1L << (REAL - 163)) | (1L << (FLOAT - 163)) | (1L << (DOUBLE - 163)) | (1L << (NUMERIC - 163)) | (1L << (DECIMAL - 163)) | (1L << (CHAR - 163)) | (1L << (VARCHAR - 163)) | (1L << (NCHAR - 163)) | (1L << (NVARCHAR - 163)) | (1L << (DATE - 163)) | (1L << (TIME - 163)) | (1L << (TIMETZ - 163)) | (1L << (TIMESTAMP - 163)) | (1L << (TIMESTAMPTZ - 163)) | (1L << (TEXT - 163)) | (1L << (VARBINARY - 163)) | (1L << (BLOB - 163)) | (1L << (BYTEA - 163)) | (1L << (INET4 - 163)))) != 0) || _la==Identifier) {
				{
				setState(592); ((Create_trigger_statementContext)_localctx).arguments = identifier();
				setState(594);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(593); match(COMMA);
					}
				}

				}
			}

			setState(598); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		public IdentifierContext role_name;
		public IdentifierContext schema_name;
		public TerminalNode EXECUTE() { return getToken(SQLParser.EXECUTE, 0); }
		public TerminalNode SCHEMA() { return getToken(SQLParser.SCHEMA, 0); }
		public TerminalNode USAGE(int i) {
			return getToken(SQLParser.USAGE, i);
		}
		public TerminalNode REVOKE() { return getToken(SQLParser.REVOKE, 0); }
		public TerminalNode ON() { return getToken(SQLParser.ON, 0); }
		public Functions_definition_schemaContext functions_definition_schema() {
			return getRuleContext(Functions_definition_schemaContext.class,0);
		}
		public TerminalNode GRANT() { return getToken(SQLParser.GRANT, 0); }
		public TerminalNode PRIVILEGES() { return getToken(SQLParser.PRIVILEGES, 0); }
		public TerminalNode OPTION() { return getToken(SQLParser.OPTION, 0); }
		public TerminalNode FROM() { return getToken(SQLParser.FROM, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public List<TerminalNode> GROUP() { return getTokens(SQLParser.GROUP); }
		public TerminalNode ALL() { return getToken(SQLParser.ALL, 0); }
		public List<TerminalNode> CREATE() { return getTokens(SQLParser.CREATE); }
		public TerminalNode CREATE(int i) {
			return getToken(SQLParser.CREATE, i);
		}
		public TerminalNode PUBLIC(int i) {
			return getToken(SQLParser.PUBLIC, i);
		}
		public TerminalNode RESTRICT() { return getToken(SQLParser.RESTRICT, 0); }
		public List<TerminalNode> USAGE() { return getTokens(SQLParser.USAGE); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public List<TerminalNode> PUBLIC() { return getTokens(SQLParser.PUBLIC); }
		public TerminalNode CASCADE() { return getToken(SQLParser.CASCADE, 0); }
		public TerminalNode FOR() { return getToken(SQLParser.FOR, 0); }
		public TerminalNode GROUP(int i) {
			return getToken(SQLParser.GROUP, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public Function_definitionContext function_definition() {
			return getRuleContext(Function_definitionContext.class,0);
		}
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
			setState(684);
			switch ( getInterpreter().adaptivePredict(_input,56,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(600); match(REVOKE);
				setState(604);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(601); match(GRANT);
					setState(602); match(OPTION);
					setState(603); match(FOR);
					}
				}

				setState(611);
				switch (_input.LA(1)) {
				case EXECUTE:
					{
					setState(606); match(EXECUTE);
					}
					break;
				case ALL:
					{
					setState(607); match(ALL);
					setState(609);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(608); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(613); match(ON);
				setState(616);
				switch (_input.LA(1)) {
				case FUNCTION:
					{
					setState(614); function_definition();
					}
					break;
				case ALL:
					{
					setState(615); functions_definition_schema();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(618); match(FROM);
				setState(629); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(624);
						switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
						case 1:
							{
							{
							setState(620);
							_la = _input.LA(1);
							if (_la==GROUP) {
								{
								setState(619); match(GROUP);
								}
							}

							setState(622); ((Revoke_statementContext)_localctx).role_name = identifier();
							}
							}
							break;
						case 2:
							{
							setState(623); match(PUBLIC);
							}
							break;
						}
						setState(627);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(626); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(631); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(634);
				_la = _input.LA(1);
				if (_la==CASCADE || _la==RESTRICT) {
					{
					setState(633);
					_la = _input.LA(1);
					if ( !(_la==CASCADE || _la==RESTRICT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(636); match(REVOKE);
				setState(640);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(637); match(GRANT);
					setState(638); match(OPTION);
					setState(639); match(FOR);
					}
				}

				setState(654);
				switch (_input.LA(1)) {
				case CREATE:
				case USAGE:
					{
					setState(646); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(642);
						_la = _input.LA(1);
						if ( !(_la==CREATE || _la==USAGE) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(644);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(643); match(COMMA);
							}
						}

						}
						}
						setState(648); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==CREATE || _la==USAGE );
					}
					break;
				case ALL:
					{
					setState(650); match(ALL);
					setState(652);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(651); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(656); match(ON);
				setState(657); match(SCHEMA);
				setState(662); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(658); ((Revoke_statementContext)_localctx).schema_name = identifier();
					setState(660);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(659); match(COMMA);
						}
					}

					}
					}
					setState(664); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 99)) & ~0x3f) == 0 && ((1L << (_la - 99)) & ((1L << (ADMIN - 99)) | (1L << (AVG - 99)) | (1L << (BETWEEN - 99)) | (1L << (BY - 99)) | (1L << (CENTURY - 99)) | (1L << (CHARACTER - 99)) | (1L << (COLLECT - 99)) | (1L << (COALESCE - 99)) | (1L << (COLUMN - 99)) | (1L << (COUNT - 99)) | (1L << (CUBE - 99)) | (1L << (DATA - 99)) | (1L << (DAY - 99)) | (1L << (DEC - 99)) | (1L << (DECADE - 99)) | (1L << (DOW - 99)) | (1L << (DOY - 99)) | (1L << (DROP - 99)) | (1L << (EPOCH - 99)) | (1L << (EVERY - 99)) | (1L << (EXISTS - 99)) | (1L << (EXTERNAL - 99)) | (1L << (EXTRACT - 99)) | (1L << (FILTER - 99)) | (1L << (FIRST - 99)) | (1L << (FORMAT - 99)) | (1L << (FUSION - 99)) | (1L << (GROUPING - 99)) | (1L << (HASH - 99)) | (1L << (INDEX - 99)) | (1L << (INSERT - 99)) | (1L << (INTERSECTION - 99)) | (1L << (ISODOW - 99)) | (1L << (ISOYEAR - 99)) | (1L << (LANGUAGE - 99)) | (1L << (LARGE - 99)) | (1L << (LAST - 99)) | (1L << (LESS - 99)) | (1L << (LIST - 99)) | (1L << (LOCATION - 99)) | (1L << (MAX - 99)) | (1L << (MAXVALUE - 99)) | (1L << (MICROSECONDS - 99)) | (1L << (MILLENNIUM - 99)) | (1L << (MILLISECONDS - 99)) | (1L << (MIN - 99)) | (1L << (MINUTE - 99)) | (1L << (MONTH - 99)) | (1L << (NATIONAL - 99)) | (1L << (NULLIF - 99)) | (1L << (OBJECT - 99)) | (1L << (OPTION - 99)) | (1L << (OVERWRITE - 99)) | (1L << (PARTITION - 99)) | (1L << (PARTITIONS - 99)) | (1L << (PRECISION - 99)) | (1L << (PUBLIC - 99)) | (1L << (PURGE - 99)) | (1L << (QUARTER - 99)) | (1L << (RANGE - 99)) | (1L << (REGEXP - 99)) | (1L << (RLIKE - 99)) | (1L << (ROLLUP - 99)))) != 0) || ((((_la - 163)) & ~0x3f) == 0 && ((1L << (_la - 163)) & ((1L << (SECOND - 163)) | (1L << (SERVER - 163)) | (1L << (SET - 163)) | (1L << (SIMILAR - 163)) | (1L << (STDDEV_POP - 163)) | (1L << (STDDEV_SAMP - 163)) | (1L << (SUBPARTITION - 163)) | (1L << (SUM - 163)) | (1L << (TABLESPACE - 163)) | (1L << (THAN - 163)) | (1L << (TIMEZONE - 163)) | (1L << (TIMEZONE_HOUR - 163)) | (1L << (TIMEZONE_MINUTE - 163)) | (1L << (TRIM - 163)) | (1L << (TO - 163)) | (1L << (UNKNOWN - 163)) | (1L << (VALUES - 163)) | (1L << (VAR_SAMP - 163)) | (1L << (VAR_POP - 163)) | (1L << (VARYING - 163)) | (1L << (WEEK - 163)) | (1L << (WRAPPER - 163)) | (1L << (YEAR - 163)) | (1L << (ZONE - 163)) | (1L << (BOOLEAN - 163)) | (1L << (BOOL - 163)) | (1L << (BIT - 163)) | (1L << (VARBIT - 163)) | (1L << (INT1 - 163)) | (1L << (INT2 - 163)) | (1L << (INT4 - 163)) | (1L << (INT8 - 163)) | (1L << (TINYINT - 163)) | (1L << (SMALLINT - 163)) | (1L << (INT - 163)) | (1L << (INTEGER - 163)) | (1L << (BIGINT - 163)) | (1L << (FLOAT4 - 163)) | (1L << (FLOAT8 - 163)) | (1L << (REAL - 163)) | (1L << (FLOAT - 163)) | (1L << (DOUBLE - 163)) | (1L << (NUMERIC - 163)) | (1L << (DECIMAL - 163)) | (1L << (CHAR - 163)) | (1L << (VARCHAR - 163)) | (1L << (NCHAR - 163)) | (1L << (NVARCHAR - 163)) | (1L << (DATE - 163)) | (1L << (TIME - 163)) | (1L << (TIMETZ - 163)) | (1L << (TIMESTAMP - 163)) | (1L << (TIMESTAMPTZ - 163)) | (1L << (TEXT - 163)) | (1L << (VARBINARY - 163)) | (1L << (BLOB - 163)) | (1L << (BYTEA - 163)) | (1L << (INET4 - 163)))) != 0) || _la==Identifier );
				setState(666); match(FROM);
				setState(677); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(672);
						switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
						case 1:
							{
							{
							setState(668);
							_la = _input.LA(1);
							if (_la==GROUP) {
								{
								setState(667); match(GROUP);
								}
							}

							setState(670); ((Revoke_statementContext)_localctx).role_name = identifier();
							}
							}
							break;
						case 2:
							{
							setState(671); match(PUBLIC);
							}
							break;
						}
						setState(675);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(674); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(679); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(682);
				_la = _input.LA(1);
				if (_la==CASCADE || _la==RESTRICT) {
					{
					setState(681);
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

	public static class Grant_statementContext extends ParserRuleContext {
		public Table_nameContext tabl_name;
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
		public Table_nameContext table_name(int i) {
			return getRuleContext(Table_nameContext.class,i);
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
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode TEMPORARY(int i) {
			return getToken(SQLParser.TEMPORARY, i);
		}
		public Function_definitionContext function_definition() {
			return getRuleContext(Function_definitionContext.class,0);
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
		enterRule(_localctx, 20, RULE_grant_statement);
		int _la;
		try {
			int _alt;
			setState(1011);
			switch ( getInterpreter().adaptivePredict(_input,127,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(686); match(GRANT);
				setState(696);
				switch (_input.LA(1)) {
				case DELETE:
				case REFERENCES:
				case SELECT:
				case TRIGGER:
				case TRUNCATE:
				case UPDATE:
				case INSERT:
					{
					setState(688); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(687);
						_la = _input.LA(1);
						if ( !(_la==DELETE || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (REFERENCES - 69)) | (1L << (SELECT - 69)) | (1L << (TRIGGER - 69)) | (1L << (TRUNCATE - 69)) | (1L << (UPDATE - 69)) | (1L << (INSERT - 69)))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
						}
						setState(690); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==DELETE || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (REFERENCES - 69)) | (1L << (SELECT - 69)) | (1L << (TRIGGER - 69)) | (1L << (TRUNCATE - 69)) | (1L << (UPDATE - 69)) | (1L << (INSERT - 69)))) != 0) );
					}
					break;
				case ALL:
					{
					setState(692); match(ALL);
					setState(694);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(693); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(698); match(ON);
				setState(722);
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
					setState(700);
					_la = _input.LA(1);
					if (_la==TABLE) {
						{
						setState(699); match(TABLE);
						}
					}

					setState(706); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(702); ((Grant_statementContext)_localctx).tabl_name = table_name();
							setState(704);
							_la = _input.LA(1);
							if (_la==COMMA) {
								{
								setState(703); match(COMMA);
								}
							}

							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(708); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,62,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					}
					}
					break;
				case ALL:
					{
					{
					setState(710); match(ALL);
					setState(711); match(TABLES);
					setState(712); match(IN);
					setState(713); match(SCHEMA);
					setState(718); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(714); ((Grant_statementContext)_localctx).schem_name = identifier();
							setState(716);
							_la = _input.LA(1);
							if (_la==COMMA) {
								{
								setState(715); match(COMMA);
								}
							}

							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(720); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,64,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(724); grant_to_rule();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(726); match(GRANT);
				setState(752);
				switch (_input.LA(1)) {
				case REFERENCES:
				case SELECT:
				case UPDATE:
				case INSERT:
					{
					setState(736); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(727);
						_la = _input.LA(1);
						if ( !(((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (REFERENCES - 69)) | (1L << (SELECT - 69)) | (1L << (UPDATE - 69)) | (1L << (INSERT - 69)))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(732); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(728); ((Grant_statementContext)_localctx).column = identifier();
								setState(730);
								_la = _input.LA(1);
								if (_la==COMMA) {
									{
									setState(729); match(COMMA);
									}
								}

								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(734); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,67,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						}
						}
						setState(738); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (REFERENCES - 69)) | (1L << (SELECT - 69)) | (1L << (UPDATE - 69)) | (1L << (INSERT - 69)))) != 0) );
					}
					break;
				case ALL:
					{
					setState(740); match(ALL);
					setState(742);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(741); match(PRIVILEGES);
						}
					}

					setState(748); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(744); ((Grant_statementContext)_localctx).column = identifier();
						setState(746);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(745); match(COMMA);
							}
						}

						}
						}
						setState(750); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 99)) & ~0x3f) == 0 && ((1L << (_la - 99)) & ((1L << (ADMIN - 99)) | (1L << (AVG - 99)) | (1L << (BETWEEN - 99)) | (1L << (BY - 99)) | (1L << (CENTURY - 99)) | (1L << (CHARACTER - 99)) | (1L << (COLLECT - 99)) | (1L << (COALESCE - 99)) | (1L << (COLUMN - 99)) | (1L << (COUNT - 99)) | (1L << (CUBE - 99)) | (1L << (DATA - 99)) | (1L << (DAY - 99)) | (1L << (DEC - 99)) | (1L << (DECADE - 99)) | (1L << (DOW - 99)) | (1L << (DOY - 99)) | (1L << (DROP - 99)) | (1L << (EPOCH - 99)) | (1L << (EVERY - 99)) | (1L << (EXISTS - 99)) | (1L << (EXTERNAL - 99)) | (1L << (EXTRACT - 99)) | (1L << (FILTER - 99)) | (1L << (FIRST - 99)) | (1L << (FORMAT - 99)) | (1L << (FUSION - 99)) | (1L << (GROUPING - 99)) | (1L << (HASH - 99)) | (1L << (INDEX - 99)) | (1L << (INSERT - 99)) | (1L << (INTERSECTION - 99)) | (1L << (ISODOW - 99)) | (1L << (ISOYEAR - 99)) | (1L << (LANGUAGE - 99)) | (1L << (LARGE - 99)) | (1L << (LAST - 99)) | (1L << (LESS - 99)) | (1L << (LIST - 99)) | (1L << (LOCATION - 99)) | (1L << (MAX - 99)) | (1L << (MAXVALUE - 99)) | (1L << (MICROSECONDS - 99)) | (1L << (MILLENNIUM - 99)) | (1L << (MILLISECONDS - 99)) | (1L << (MIN - 99)) | (1L << (MINUTE - 99)) | (1L << (MONTH - 99)) | (1L << (NATIONAL - 99)) | (1L << (NULLIF - 99)) | (1L << (OBJECT - 99)) | (1L << (OPTION - 99)) | (1L << (OVERWRITE - 99)) | (1L << (PARTITION - 99)) | (1L << (PARTITIONS - 99)) | (1L << (PRECISION - 99)) | (1L << (PUBLIC - 99)) | (1L << (PURGE - 99)) | (1L << (QUARTER - 99)) | (1L << (RANGE - 99)) | (1L << (REGEXP - 99)) | (1L << (RLIKE - 99)) | (1L << (ROLLUP - 99)))) != 0) || ((((_la - 163)) & ~0x3f) == 0 && ((1L << (_la - 163)) & ((1L << (SECOND - 163)) | (1L << (SERVER - 163)) | (1L << (SET - 163)) | (1L << (SIMILAR - 163)) | (1L << (STDDEV_POP - 163)) | (1L << (STDDEV_SAMP - 163)) | (1L << (SUBPARTITION - 163)) | (1L << (SUM - 163)) | (1L << (TABLESPACE - 163)) | (1L << (THAN - 163)) | (1L << (TIMEZONE - 163)) | (1L << (TIMEZONE_HOUR - 163)) | (1L << (TIMEZONE_MINUTE - 163)) | (1L << (TRIM - 163)) | (1L << (TO - 163)) | (1L << (UNKNOWN - 163)) | (1L << (VALUES - 163)) | (1L << (VAR_SAMP - 163)) | (1L << (VAR_POP - 163)) | (1L << (VARYING - 163)) | (1L << (WEEK - 163)) | (1L << (WRAPPER - 163)) | (1L << (YEAR - 163)) | (1L << (ZONE - 163)) | (1L << (BOOLEAN - 163)) | (1L << (BOOL - 163)) | (1L << (BIT - 163)) | (1L << (VARBIT - 163)) | (1L << (INT1 - 163)) | (1L << (INT2 - 163)) | (1L << (INT4 - 163)) | (1L << (INT8 - 163)) | (1L << (TINYINT - 163)) | (1L << (SMALLINT - 163)) | (1L << (INT - 163)) | (1L << (INTEGER - 163)) | (1L << (BIGINT - 163)) | (1L << (FLOAT4 - 163)) | (1L << (FLOAT8 - 163)) | (1L << (REAL - 163)) | (1L << (FLOAT - 163)) | (1L << (DOUBLE - 163)) | (1L << (NUMERIC - 163)) | (1L << (DECIMAL - 163)) | (1L << (CHAR - 163)) | (1L << (VARCHAR - 163)) | (1L << (NCHAR - 163)) | (1L << (NVARCHAR - 163)) | (1L << (DATE - 163)) | (1L << (TIME - 163)) | (1L << (TIMETZ - 163)) | (1L << (TIMESTAMP - 163)) | (1L << (TIMESTAMPTZ - 163)) | (1L << (TEXT - 163)) | (1L << (VARBINARY - 163)) | (1L << (BLOB - 163)) | (1L << (BYTEA - 163)) | (1L << (INET4 - 163)))) != 0) || _la==Identifier );
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(754); match(ON);
				setState(762); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(756);
						_la = _input.LA(1);
						if (_la==TABLE) {
							{
							setState(755); match(TABLE);
							}
						}

						setState(758); ((Grant_statementContext)_localctx).tabl_name = table_name();
						setState(760);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(759); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(764); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,75,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(766); grant_to_rule();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(768); match(GRANT);
				setState(781);
				switch (_input.LA(1)) {
				case SELECT:
				case UPDATE:
				case USAGE:
					{
					setState(773); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(769);
						_la = _input.LA(1);
						if ( !(((((_la - 77)) & ~0x3f) == 0 && ((1L << (_la - 77)) & ((1L << (SELECT - 77)) | (1L << (UPDATE - 77)) | (1L << (USAGE - 77)))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(771);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(770); match(COMMA);
							}
						}

						}
						}
						setState(775); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 77)) & ~0x3f) == 0 && ((1L << (_la - 77)) & ((1L << (SELECT - 77)) | (1L << (UPDATE - 77)) | (1L << (USAGE - 77)))) != 0) );
					}
					break;
				case ALL:
					{
					setState(777); match(ALL);
					setState(779);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(778); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(783); match(ON);
				setState(805);
				switch (_input.LA(1)) {
				case SEQUENCE:
					{
					setState(789); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(784); match(SEQUENCE);
						setState(785); ((Grant_statementContext)_localctx).sequence_name = identifier();
						setState(787);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(786); match(COMMA);
							}
						}

						}
						}
						setState(791); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==SEQUENCE );
					}
					break;
				case ALL:
					{
					setState(793); match(ALL);
					setState(794); match(SEQUENCES);
					setState(795); match(IN);
					setState(796); match(SCHEMA);
					setState(801); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(797); ((Grant_statementContext)_localctx).schema_name = identifier();
							setState(799);
							_la = _input.LA(1);
							if (_la==COMMA) {
								{
								setState(798); match(COMMA);
								}
							}

							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(803); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,83,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(807); grant_to_rule();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(809); match(GRANT);
				setState(822);
				switch (_input.LA(1)) {
				case CONNECT:
				case CREATE:
				case TEMP:
				case TEMPORARY:
					{
					setState(814); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(810);
						_la = _input.LA(1);
						if ( !(_la==CONNECT || _la==CREATE || _la==TEMP || _la==TEMPORARY) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(812);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(811); match(COMMA);
							}
						}

						}
						}
						setState(816); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==CONNECT || _la==CREATE || _la==TEMP || _la==TEMPORARY );
					}
					break;
				case ALL:
					{
					setState(818); match(ALL);
					setState(820);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(819); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(824); match(ON);
				setState(825); match(DATABASE);
				setState(830); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(826); ((Grant_statementContext)_localctx).database_name = identifier();
						setState(828);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(827); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(832); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,90,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(834); grant_to_rule();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(836); match(GRANT);
				setState(842);
				switch (_input.LA(1)) {
				case USAGE:
					{
					setState(837); match(USAGE);
					}
					break;
				case ALL:
					{
					setState(838); match(ALL);
					setState(840);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(839); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(844); match(ON);
				setState(845); match(FOREIGN);
				setState(846); match(DATA);
				setState(847); match(WRAPPER);
				setState(852); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(848); ((Grant_statementContext)_localctx).fdw_name = identifier();
						setState(850);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(849); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(854); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,94,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(856); grant_to_rule();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(858); match(GRANT);
				setState(864);
				switch (_input.LA(1)) {
				case USAGE:
					{
					setState(859); match(USAGE);
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
				setState(867); match(FOREIGN);
				setState(868); match(SERVER);
				setState(873); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(869); ((Grant_statementContext)_localctx).server_name = identifier();
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
					_alt = getInterpreter().adaptivePredict(_input,98,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(877); grant_to_rule();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(879); match(GRANT);
				setState(885);
				switch (_input.LA(1)) {
				case EXECUTE:
					{
					setState(880); match(EXECUTE);
					}
					break;
				case ALL:
					{
					setState(881); match(ALL);
					setState(883);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(882); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(887); match(ON);
				setState(890);
				switch (_input.LA(1)) {
				case FUNCTION:
					{
					setState(888); function_definition();
					}
					break;
				case ALL:
					{
					setState(889); functions_definition_schema();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(892); grant_to_rule();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(894); match(GRANT);
				setState(900);
				switch (_input.LA(1)) {
				case USAGE:
					{
					setState(895); match(USAGE);
					}
					break;
				case ALL:
					{
					setState(896); match(ALL);
					setState(898);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(897); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(902); match(ON);
				setState(903); match(LANGUAGE);
				setState(908); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(904); ((Grant_statementContext)_localctx).lang_name = identifier();
						setState(906);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(905); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(910); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,105,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(912); grant_to_rule();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(914); match(GRANT);
				setState(927);
				switch (_input.LA(1)) {
				case SELECT:
				case UPDATE:
					{
					setState(919); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(915);
						_la = _input.LA(1);
						if ( !(_la==SELECT || _la==UPDATE) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(917);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(916); match(COMMA);
							}
						}

						}
						}
						setState(921); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==SELECT || _la==UPDATE );
					}
					break;
				case ALL:
					{
					setState(923); match(ALL);
					setState(925);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(924); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(929); match(ON);
				setState(930); match(LARGE);
				setState(931); match(OBJECT);
				setState(936); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(932); ((Grant_statementContext)_localctx).loid = identifier();
						setState(934);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(933); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(938); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,111,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(940); grant_to_rule();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(942); match(GRANT);
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
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(959); ((Grant_statementContext)_localctx).schema_name = identifier();
						setState(961);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(960); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(965); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,117,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(967); grant_to_rule();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(969); match(GRANT);
				setState(975);
				switch (_input.LA(1)) {
				case CREATE:
					{
					setState(970); match(CREATE);
					}
					break;
				case ALL:
					{
					setState(971); match(ALL);
					setState(973);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(972); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(977); match(ON);
				setState(978); match(TABLESPACE);
				setState(983); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(979); ((Grant_statementContext)_localctx).tablespace_name = identifier();
						setState(981);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(980); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(985); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,121,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(987); grant_to_rule();
				setState(988); match(GRANT);
				setState(993); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(989); ((Grant_statementContext)_localctx).role_name = identifier();
						setState(991);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(990); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(995); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,123,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(997); match(TO);
				setState(1002); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(998); ((Grant_statementContext)_localctx).role_name = identifier();
						setState(1000);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(999); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1004); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,125,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1009);
				_la = _input.LA(1);
				if (_la==WITH) {
					{
					setState(1006); match(WITH);
					setState(1007); match(ADMIN);
					setState(1008); match(OPTION);
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
		enterRule(_localctx, 22, RULE_grant_to_rule);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1013); match(TO);
			setState(1024); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(1015);
					_la = _input.LA(1);
					if (_la==GROUP) {
						{
						setState(1014); match(GROUP);
						}
					}

					setState(1019);
					switch ( getInterpreter().adaptivePredict(_input,129,_ctx) ) {
					case 1:
						{
						{
						setState(1017); ((Grant_to_ruleContext)_localctx).role_name = identifier();
						}
						}
						break;
					case 2:
						{
						setState(1018); match(PUBLIC);
						}
						break;
					}
					setState(1022);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1021); match(COMMA);
						}
					}

					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1026); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,131,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(1031);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(1028); match(WITH);
				setState(1029); match(GRANT);
				setState(1030); match(OPTION);
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
		enterRule(_localctx, 24, RULE_argmode);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1033);
			_la = _input.LA(1);
			if ( !(((((_la - 43)) & ~0x3f) == 0 && ((1L << (_la - 43)) & ((1L << (IN - 43)) | (1L << (INOUT - 43)) | (1L << (OUT - 43)) | (1L << (VARIADIC - 43)))) != 0)) ) {
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
		enterRule(_localctx, 26, RULE_function_definition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1035); match(FUNCTION);
			setState(1036); ((Function_definitionContext)_localctx).func_name = identifier();
			setState(1037); match(LEFT_PAREN);
			setState(1050);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IN) | (1L << INOUT) | (1L << OUT))) != 0) || ((((_la - 95)) & ~0x3f) == 0 && ((1L << (_la - 95)) & ((1L << (VARIADIC - 95)) | (1L << (ADMIN - 95)) | (1L << (AVG - 95)) | (1L << (BETWEEN - 95)) | (1L << (BY - 95)) | (1L << (CENTURY - 95)) | (1L << (CHARACTER - 95)) | (1L << (COLLECT - 95)) | (1L << (COALESCE - 95)) | (1L << (COLUMN - 95)) | (1L << (COUNT - 95)) | (1L << (CUBE - 95)) | (1L << (DATA - 95)) | (1L << (DAY - 95)) | (1L << (DEC - 95)) | (1L << (DECADE - 95)) | (1L << (DOW - 95)) | (1L << (DOY - 95)) | (1L << (DROP - 95)) | (1L << (EPOCH - 95)) | (1L << (EVERY - 95)) | (1L << (EXISTS - 95)) | (1L << (EXTERNAL - 95)) | (1L << (EXTRACT - 95)) | (1L << (FILTER - 95)) | (1L << (FIRST - 95)) | (1L << (FORMAT - 95)) | (1L << (FUSION - 95)) | (1L << (GROUPING - 95)) | (1L << (HASH - 95)) | (1L << (INDEX - 95)) | (1L << (INSERT - 95)) | (1L << (INTERSECTION - 95)) | (1L << (ISODOW - 95)) | (1L << (ISOYEAR - 95)) | (1L << (LANGUAGE - 95)) | (1L << (LARGE - 95)) | (1L << (LAST - 95)) | (1L << (LESS - 95)) | (1L << (LIST - 95)) | (1L << (LOCATION - 95)) | (1L << (MAX - 95)) | (1L << (MAXVALUE - 95)) | (1L << (MICROSECONDS - 95)) | (1L << (MILLENNIUM - 95)) | (1L << (MILLISECONDS - 95)) | (1L << (MIN - 95)) | (1L << (MINUTE - 95)) | (1L << (MONTH - 95)) | (1L << (NATIONAL - 95)) | (1L << (NULLIF - 95)) | (1L << (OBJECT - 95)) | (1L << (OPTION - 95)) | (1L << (OVERWRITE - 95)) | (1L << (PARTITION - 95)) | (1L << (PARTITIONS - 95)) | (1L << (PRECISION - 95)) | (1L << (PUBLIC - 95)) | (1L << (PURGE - 95)) | (1L << (QUARTER - 95)))) != 0) || ((((_la - 159)) & ~0x3f) == 0 && ((1L << (_la - 159)) & ((1L << (RANGE - 159)) | (1L << (REGEXP - 159)) | (1L << (RLIKE - 159)) | (1L << (ROLLUP - 159)) | (1L << (SECOND - 159)) | (1L << (SERVER - 159)) | (1L << (SET - 159)) | (1L << (SIMILAR - 159)) | (1L << (STDDEV_POP - 159)) | (1L << (STDDEV_SAMP - 159)) | (1L << (SUBPARTITION - 159)) | (1L << (SUM - 159)) | (1L << (TABLESPACE - 159)) | (1L << (THAN - 159)) | (1L << (TIMEZONE - 159)) | (1L << (TIMEZONE_HOUR - 159)) | (1L << (TIMEZONE_MINUTE - 159)) | (1L << (TRIM - 159)) | (1L << (TO - 159)) | (1L << (UNKNOWN - 159)) | (1L << (VALUES - 159)) | (1L << (VAR_SAMP - 159)) | (1L << (VAR_POP - 159)) | (1L << (VARYING - 159)) | (1L << (WEEK - 159)) | (1L << (WRAPPER - 159)) | (1L << (YEAR - 159)) | (1L << (ZONE - 159)) | (1L << (BOOLEAN - 159)) | (1L << (BOOL - 159)) | (1L << (BIT - 159)) | (1L << (VARBIT - 159)) | (1L << (INT1 - 159)) | (1L << (INT2 - 159)) | (1L << (INT4 - 159)) | (1L << (INT8 - 159)) | (1L << (TINYINT - 159)) | (1L << (SMALLINT - 159)) | (1L << (INT - 159)) | (1L << (INTEGER - 159)) | (1L << (BIGINT - 159)) | (1L << (FLOAT4 - 159)) | (1L << (FLOAT8 - 159)) | (1L << (REAL - 159)) | (1L << (FLOAT - 159)) | (1L << (DOUBLE - 159)) | (1L << (NUMERIC - 159)) | (1L << (DECIMAL - 159)) | (1L << (CHAR - 159)) | (1L << (VARCHAR - 159)) | (1L << (NCHAR - 159)) | (1L << (NVARCHAR - 159)) | (1L << (DATE - 159)) | (1L << (TIME - 159)) | (1L << (TIMETZ - 159)) | (1L << (TIMESTAMP - 159)) | (1L << (TIMESTAMPTZ - 159)) | (1L << (TEXT - 159)) | (1L << (BINARY - 159)) | (1L << (VARBINARY - 159)) | (1L << (BLOB - 159)) | (1L << (BYTEA - 159)))) != 0) || _la==INET4 || _la==Identifier) {
				{
				{
				setState(1039);
				_la = _input.LA(1);
				if (((((_la - 43)) & ~0x3f) == 0 && ((1L << (_la - 43)) & ((1L << (IN - 43)) | (1L << (INOUT - 43)) | (1L << (OUT - 43)) | (1L << (VARIADIC - 43)))) != 0)) {
					{
					setState(1038); ((Function_definitionContext)_localctx).arg_mode = argmode();
					}
				}

				setState(1042);
				switch ( getInterpreter().adaptivePredict(_input,134,_ctx) ) {
				case 1:
					{
					setState(1041); ((Function_definitionContext)_localctx).argname = identifier();
					}
					break;
				}
				setState(1044); ((Function_definitionContext)_localctx).argtype = data_type();
				setState(1046);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(1045); match(COMMA);
					}
				}

				}
				}
				setState(1052);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1053); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 28, RULE_functions_definition_schema);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1055); match(ALL);
			setState(1056); match(FUNCTIONS);
			setState(1057); match(IN);
			setState(1058); match(SCHEMA);
			setState(1063); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(1059); ((Functions_definition_schemaContext)_localctx).schema_name = identifier();
					setState(1061);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1060); match(COMMA);
						}
					}

					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1065); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,138,_ctx);
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
		enterRule(_localctx, 30, RULE_create_table_statement);
		int _la;
		try {
			setState(1117);
			switch ( getInterpreter().adaptivePredict(_input,148,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1067); match(CREATE);
				setState(1068); match(EXTERNAL);
				setState(1069); match(TABLE);
				setState(1070); ((Create_table_statementContext)_localctx).n = table_name();
				setState(1071); table_elements();
				setState(1072); match(USING);
				setState(1073); ((Create_table_statementContext)_localctx).file_type = identifier();
				setState(1075);
				_la = _input.LA(1);
				if (_la==WITH) {
					{
					setState(1074); param_clause();
					}
				}

				setState(1078);
				_la = _input.LA(1);
				if (_la==PARTITION) {
					{
					setState(1077); table_partitioning_clauses();
					}
				}

				{
				setState(1080); match(LOCATION);
				setState(1081); ((Create_table_statementContext)_localctx).path = match(Character_String_Literal);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1083); match(CREATE);
				setState(1084); match(TABLE);
				setState(1085); ((Create_table_statementContext)_localctx).n = table_name();
				setState(1086); table_elements();
				setState(1089);
				_la = _input.LA(1);
				if (_la==USING) {
					{
					setState(1087); match(USING);
					setState(1088); ((Create_table_statementContext)_localctx).file_type = identifier();
					}
				}

				setState(1092);
				_la = _input.LA(1);
				if (_la==WITH) {
					{
					setState(1091); param_clause();
					}
				}

				setState(1095);
				switch ( getInterpreter().adaptivePredict(_input,143,_ctx) ) {
				case 1:
					{
					setState(1094); table_partitioning_clauses();
					}
					break;
				}
				setState(1099);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(1097); match(AS);
					setState(1098); query_expression();
					}
				}

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1101); match(CREATE);
				setState(1102); match(TABLE);
				setState(1103); ((Create_table_statementContext)_localctx).n = table_name();
				setState(1106);
				_la = _input.LA(1);
				if (_la==USING) {
					{
					setState(1104); match(USING);
					setState(1105); ((Create_table_statementContext)_localctx).file_type = identifier();
					}
				}

				setState(1109);
				_la = _input.LA(1);
				if (_la==WITH) {
					{
					setState(1108); param_clause();
					}
				}

				setState(1112);
				_la = _input.LA(1);
				if (_la==PARTITION) {
					{
					setState(1111); table_partitioning_clauses();
					}
				}

				setState(1114); match(AS);
				setState(1115); query_expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 32, RULE_table_elements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1119); match(LEFT_PAREN);
			setState(1120); field_element();
			setState(1125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1121); match(COMMA);
				setState(1122); field_element();
				}
				}
				setState(1127);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1128); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 34, RULE_field_element);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1130); ((Field_elementContext)_localctx).name = identifier();
			setState(1131); field_type();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 36, RULE_field_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1133); data_type();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 38, RULE_param_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1135); match(WITH);
			setState(1136); match(LEFT_PAREN);
			setState(1137); param();
			setState(1142);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1138); match(COMMA);
				setState(1139); param();
				}
				}
				setState(1144);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1145); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 40, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1147); ((ParamContext)_localctx).key = match(Character_String_Literal);
			setState(1148); match(EQUAL);
			setState(1149); ((ParamContext)_localctx).value = numeric_value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 42, RULE_method_specifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1151); match(USING);
			setState(1152); ((Method_specifierContext)_localctx).m = identifier();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 44, RULE_table_space_specifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1154); match(TABLESPACE);
			setState(1155); table_space_name();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 46, RULE_table_space_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1157); identifier();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 48, RULE_table_partitioning_clauses);
		try {
			setState(1163);
			switch ( getInterpreter().adaptivePredict(_input,151,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1159); range_partitions();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1160); hash_partitions();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1161); list_partitions();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1162); column_partitions();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 50, RULE_range_partitions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1165); match(PARTITION);
			setState(1166); match(BY);
			setState(1167); match(RANGE);
			setState(1168); match(LEFT_PAREN);
			setState(1169); column_reference_list();
			setState(1170); match(RIGHT_PAREN);
			setState(1171); match(LEFT_PAREN);
			setState(1172); range_value_clause_list();
			setState(1173); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 52, RULE_range_value_clause_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1175); range_value_clause();
			setState(1180);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1176); match(COMMA);
				setState(1177); range_value_clause();
				}
				}
				setState(1182);
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
		enterRule(_localctx, 54, RULE_range_value_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1183); match(PARTITION);
			setState(1184); partition_name();
			setState(1185); match(VALUES);
			setState(1186); match(LESS);
			setState(1187); match(THAN);
			setState(1199);
			switch ( getInterpreter().adaptivePredict(_input,155,_ctx) ) {
			case 1:
				{
				setState(1188); match(LEFT_PAREN);
				setState(1189); value_expression();
				setState(1190); match(RIGHT_PAREN);
				}
				break;
			case 2:
				{
				setState(1193);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(1192); match(LEFT_PAREN);
					}
				}

				setState(1195); match(MAXVALUE);
				setState(1197);
				switch ( getInterpreter().adaptivePredict(_input,154,_ctx) ) {
				case 1:
					{
					setState(1196); match(RIGHT_PAREN);
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
		enterRule(_localctx, 56, RULE_hash_partitions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1201); match(PARTITION);
			setState(1202); match(BY);
			setState(1203); match(HASH);
			setState(1204); match(LEFT_PAREN);
			setState(1205); column_reference_list();
			setState(1206); match(RIGHT_PAREN);
			setState(1212);
			switch (_input.LA(1)) {
			case LEFT_PAREN:
				{
				setState(1207); match(LEFT_PAREN);
				setState(1208); individual_hash_partitions();
				setState(1209); match(RIGHT_PAREN);
				}
				break;
			case PARTITIONS:
				{
				setState(1211); hash_partitions_by_quantity();
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
		enterRule(_localctx, 58, RULE_individual_hash_partitions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1214); individual_hash_partition();
			setState(1219);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1215); match(COMMA);
				setState(1216); individual_hash_partition();
				}
				}
				setState(1221);
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
		enterRule(_localctx, 60, RULE_individual_hash_partition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1222); match(PARTITION);
			setState(1223); partition_name();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 62, RULE_hash_partitions_by_quantity);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1225); match(PARTITIONS);
			setState(1226); ((Hash_partitions_by_quantityContext)_localctx).quantity = numeric_value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 64, RULE_list_partitions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1228); match(PARTITION);
			setState(1229); match(BY);
			setState(1230); match(LIST);
			setState(1231); match(LEFT_PAREN);
			setState(1232); column_reference_list();
			setState(1233); match(RIGHT_PAREN);
			setState(1234); match(LEFT_PAREN);
			setState(1235); list_value_clause_list();
			setState(1236); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 66, RULE_list_value_clause_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1238); list_value_partition();
			setState(1243);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1239); match(COMMA);
				setState(1240); list_value_partition();
				}
				}
				setState(1245);
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
		enterRule(_localctx, 68, RULE_list_value_partition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1246); match(PARTITION);
			setState(1247); partition_name();
			setState(1248); match(VALUES);
			setState(1250);
			_la = _input.LA(1);
			if (_la==IN) {
				{
				setState(1249); match(IN);
				}
			}

			setState(1252); match(LEFT_PAREN);
			setState(1253); in_value_list();
			setState(1254); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 70, RULE_column_partitions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1256); match(PARTITION);
			setState(1257); match(BY);
			setState(1258); match(COLUMN);
			setState(1259); table_elements();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 72, RULE_partition_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1261); identifier();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 74, RULE_drop_table_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1263); match(DROP);
			setState(1264); match(TABLE);
			setState(1265); table_name();
			setState(1267);
			switch ( getInterpreter().adaptivePredict(_input,160,_ctx) ) {
			case 1:
				{
				setState(1266); match(PURGE);
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
		enterRule(_localctx, 76, RULE_identifier);
		try {
			setState(1271);
			switch (_input.LA(1)) {
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(1269); match(Identifier);
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
				setState(1270); nonreserved_keywords();
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
		enterRule(_localctx, 78, RULE_nonreserved_keywords);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1273);
			_la = _input.LA(1);
			if ( !(((((_la - 99)) & ~0x3f) == 0 && ((1L << (_la - 99)) & ((1L << (ADMIN - 99)) | (1L << (AVG - 99)) | (1L << (BETWEEN - 99)) | (1L << (BY - 99)) | (1L << (CENTURY - 99)) | (1L << (CHARACTER - 99)) | (1L << (COLLECT - 99)) | (1L << (COALESCE - 99)) | (1L << (COLUMN - 99)) | (1L << (COUNT - 99)) | (1L << (CUBE - 99)) | (1L << (DATA - 99)) | (1L << (DAY - 99)) | (1L << (DEC - 99)) | (1L << (DECADE - 99)) | (1L << (DOW - 99)) | (1L << (DOY - 99)) | (1L << (DROP - 99)) | (1L << (EPOCH - 99)) | (1L << (EVERY - 99)) | (1L << (EXISTS - 99)) | (1L << (EXTERNAL - 99)) | (1L << (EXTRACT - 99)) | (1L << (FILTER - 99)) | (1L << (FIRST - 99)) | (1L << (FORMAT - 99)) | (1L << (FUSION - 99)) | (1L << (GROUPING - 99)) | (1L << (HASH - 99)) | (1L << (INDEX - 99)) | (1L << (INSERT - 99)) | (1L << (INTERSECTION - 99)) | (1L << (ISODOW - 99)) | (1L << (ISOYEAR - 99)) | (1L << (LANGUAGE - 99)) | (1L << (LARGE - 99)) | (1L << (LAST - 99)) | (1L << (LESS - 99)) | (1L << (LIST - 99)) | (1L << (LOCATION - 99)) | (1L << (MAX - 99)) | (1L << (MAXVALUE - 99)) | (1L << (MICROSECONDS - 99)) | (1L << (MILLENNIUM - 99)) | (1L << (MILLISECONDS - 99)) | (1L << (MIN - 99)) | (1L << (MINUTE - 99)) | (1L << (MONTH - 99)) | (1L << (NATIONAL - 99)) | (1L << (NULLIF - 99)) | (1L << (OBJECT - 99)) | (1L << (OPTION - 99)) | (1L << (OVERWRITE - 99)) | (1L << (PARTITION - 99)) | (1L << (PARTITIONS - 99)) | (1L << (PRECISION - 99)) | (1L << (PUBLIC - 99)) | (1L << (PURGE - 99)) | (1L << (QUARTER - 99)) | (1L << (RANGE - 99)) | (1L << (REGEXP - 99)) | (1L << (RLIKE - 99)) | (1L << (ROLLUP - 99)))) != 0) || ((((_la - 163)) & ~0x3f) == 0 && ((1L << (_la - 163)) & ((1L << (SECOND - 163)) | (1L << (SERVER - 163)) | (1L << (SET - 163)) | (1L << (SIMILAR - 163)) | (1L << (STDDEV_POP - 163)) | (1L << (STDDEV_SAMP - 163)) | (1L << (SUBPARTITION - 163)) | (1L << (SUM - 163)) | (1L << (TABLESPACE - 163)) | (1L << (THAN - 163)) | (1L << (TIMEZONE - 163)) | (1L << (TIMEZONE_HOUR - 163)) | (1L << (TIMEZONE_MINUTE - 163)) | (1L << (TRIM - 163)) | (1L << (TO - 163)) | (1L << (UNKNOWN - 163)) | (1L << (VALUES - 163)) | (1L << (VAR_SAMP - 163)) | (1L << (VAR_POP - 163)) | (1L << (VARYING - 163)) | (1L << (WEEK - 163)) | (1L << (WRAPPER - 163)) | (1L << (YEAR - 163)) | (1L << (ZONE - 163)) | (1L << (BOOLEAN - 163)) | (1L << (BOOL - 163)) | (1L << (BIT - 163)) | (1L << (VARBIT - 163)) | (1L << (INT1 - 163)) | (1L << (INT2 - 163)) | (1L << (INT4 - 163)) | (1L << (INT8 - 163)) | (1L << (TINYINT - 163)) | (1L << (SMALLINT - 163)) | (1L << (INT - 163)) | (1L << (INTEGER - 163)) | (1L << (BIGINT - 163)) | (1L << (FLOAT4 - 163)) | (1L << (FLOAT8 - 163)) | (1L << (REAL - 163)) | (1L << (FLOAT - 163)) | (1L << (DOUBLE - 163)) | (1L << (NUMERIC - 163)) | (1L << (DECIMAL - 163)) | (1L << (CHAR - 163)) | (1L << (VARCHAR - 163)) | (1L << (NCHAR - 163)) | (1L << (NVARCHAR - 163)) | (1L << (DATE - 163)) | (1L << (TIME - 163)) | (1L << (TIMETZ - 163)) | (1L << (TIMESTAMP - 163)) | (1L << (TIMESTAMPTZ - 163)) | (1L << (TEXT - 163)) | (1L << (VARBINARY - 163)) | (1L << (BLOB - 163)) | (1L << (BYTEA - 163)) | (1L << (INET4 - 163)))) != 0)) ) {
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
		enterRule(_localctx, 80, RULE_unsigned_literal);
		try {
			setState(1277);
			switch (_input.LA(1)) {
			case NUMBER:
			case REAL_NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(1275); unsigned_numeric_literal();
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
				setState(1276); general_literal();
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
		enterRule(_localctx, 82, RULE_general_literal);
		try {
			setState(1282);
			switch (_input.LA(1)) {
			case Character_String_Literal:
				enterOuterAlt(_localctx, 1);
				{
				setState(1279); match(Character_String_Literal);
				}
				break;
			case DATE:
			case TIME:
			case TIMESTAMP:
				enterOuterAlt(_localctx, 2);
				{
				setState(1280); datetime_literal();
				}
				break;
			case FALSE:
			case TRUE:
			case UNKNOWN:
				enterOuterAlt(_localctx, 3);
				{
				setState(1281); boolean_literal();
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
		enterRule(_localctx, 84, RULE_datetime_literal);
		try {
			setState(1287);
			switch (_input.LA(1)) {
			case TIMESTAMP:
				enterOuterAlt(_localctx, 1);
				{
				setState(1284); timestamp_literal();
				}
				break;
			case TIME:
				enterOuterAlt(_localctx, 2);
				{
				setState(1285); time_literal();
				}
				break;
			case DATE:
				enterOuterAlt(_localctx, 3);
				{
				setState(1286); date_literal();
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
		enterRule(_localctx, 86, RULE_time_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1289); match(TIME);
			setState(1290); ((Time_literalContext)_localctx).time_string = match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 88, RULE_timestamp_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1292); match(TIMESTAMP);
			setState(1293); ((Timestamp_literalContext)_localctx).timestamp_string = match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 90, RULE_date_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1295); match(DATE);
			setState(1296); ((Date_literalContext)_localctx).date_string = match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 92, RULE_boolean_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1298);
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
		enterRule(_localctx, 94, RULE_data_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1300); predefined_type();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 96, RULE_predefined_type);
		try {
			setState(1311);
			switch (_input.LA(1)) {
			case CHARACTER:
			case CHAR:
			case VARCHAR:
			case TEXT:
				enterOuterAlt(_localctx, 1);
				{
				setState(1302); character_string_type();
				}
				break;
			case NATIONAL:
			case NCHAR:
			case NVARCHAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(1303); national_character_string_type();
				}
				break;
			case BLOB:
			case BYTEA:
				enterOuterAlt(_localctx, 3);
				{
				setState(1304); binary_large_object_string_type();
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
				setState(1305); numeric_type();
				}
				break;
			case BOOLEAN:
			case BOOL:
				enterOuterAlt(_localctx, 5);
				{
				setState(1306); boolean_type();
				}
				break;
			case DATE:
			case TIME:
			case TIMETZ:
			case TIMESTAMP:
			case TIMESTAMPTZ:
				enterOuterAlt(_localctx, 6);
				{
				setState(1307); datetime_type();
				}
				break;
			case BIT:
			case VARBIT:
				enterOuterAlt(_localctx, 7);
				{
				setState(1308); bit_type();
				}
				break;
			case BINARY:
			case VARBINARY:
				enterOuterAlt(_localctx, 8);
				{
				setState(1309); binary_type();
				}
				break;
			case INET4:
				enterOuterAlt(_localctx, 9);
				{
				setState(1310); network_type();
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
		enterRule(_localctx, 98, RULE_network_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1313); match(INET4);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 100, RULE_character_string_type);
		try {
			setState(1338);
			switch ( getInterpreter().adaptivePredict(_input,171,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1315); match(CHARACTER);
				setState(1317);
				switch ( getInterpreter().adaptivePredict(_input,166,_ctx) ) {
				case 1:
					{
					setState(1316); type_length();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1319); match(CHAR);
				setState(1321);
				switch ( getInterpreter().adaptivePredict(_input,167,_ctx) ) {
				case 1:
					{
					setState(1320); type_length();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1323); match(CHARACTER);
				setState(1324); match(VARYING);
				setState(1326);
				switch ( getInterpreter().adaptivePredict(_input,168,_ctx) ) {
				case 1:
					{
					setState(1325); type_length();
					}
					break;
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1328); match(CHAR);
				setState(1329); match(VARYING);
				setState(1331);
				switch ( getInterpreter().adaptivePredict(_input,169,_ctx) ) {
				case 1:
					{
					setState(1330); type_length();
					}
					break;
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1333); match(VARCHAR);
				setState(1335);
				switch ( getInterpreter().adaptivePredict(_input,170,_ctx) ) {
				case 1:
					{
					setState(1334); type_length();
					}
					break;
				}
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1337); match(TEXT);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 102, RULE_type_length);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1340); match(LEFT_PAREN);
			setState(1341); match(NUMBER);
			setState(1342); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 104, RULE_national_character_string_type);
		try {
			setState(1379);
			switch ( getInterpreter().adaptivePredict(_input,179,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1344); match(NATIONAL);
				setState(1345); match(CHARACTER);
				setState(1347);
				switch ( getInterpreter().adaptivePredict(_input,172,_ctx) ) {
				case 1:
					{
					setState(1346); type_length();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1349); match(NATIONAL);
				setState(1350); match(CHAR);
				setState(1352);
				switch ( getInterpreter().adaptivePredict(_input,173,_ctx) ) {
				case 1:
					{
					setState(1351); type_length();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1354); match(NCHAR);
				setState(1356);
				switch ( getInterpreter().adaptivePredict(_input,174,_ctx) ) {
				case 1:
					{
					setState(1355); type_length();
					}
					break;
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1358); match(NATIONAL);
				setState(1359); match(CHARACTER);
				setState(1360); match(VARYING);
				setState(1362);
				switch ( getInterpreter().adaptivePredict(_input,175,_ctx) ) {
				case 1:
					{
					setState(1361); type_length();
					}
					break;
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1364); match(NATIONAL);
				setState(1365); match(CHAR);
				setState(1366); match(VARYING);
				setState(1368);
				switch ( getInterpreter().adaptivePredict(_input,176,_ctx) ) {
				case 1:
					{
					setState(1367); type_length();
					}
					break;
				}
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1370); match(NCHAR);
				setState(1371); match(VARYING);
				setState(1373);
				switch ( getInterpreter().adaptivePredict(_input,177,_ctx) ) {
				case 1:
					{
					setState(1372); type_length();
					}
					break;
				}
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1375); match(NVARCHAR);
				setState(1377);
				switch ( getInterpreter().adaptivePredict(_input,178,_ctx) ) {
				case 1:
					{
					setState(1376); type_length();
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
		enterRule(_localctx, 106, RULE_binary_large_object_string_type);
		try {
			setState(1389);
			switch (_input.LA(1)) {
			case BLOB:
				enterOuterAlt(_localctx, 1);
				{
				setState(1381); match(BLOB);
				setState(1383);
				switch ( getInterpreter().adaptivePredict(_input,180,_ctx) ) {
				case 1:
					{
					setState(1382); type_length();
					}
					break;
				}
				}
				break;
			case BYTEA:
				enterOuterAlt(_localctx, 2);
				{
				setState(1385); match(BYTEA);
				setState(1387);
				switch ( getInterpreter().adaptivePredict(_input,181,_ctx) ) {
				case 1:
					{
					setState(1386); type_length();
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
		enterRule(_localctx, 108, RULE_numeric_type);
		try {
			setState(1393);
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
				setState(1391); exact_numeric_type();
				}
				break;
			case FLOAT4:
			case FLOAT8:
			case REAL:
			case FLOAT:
			case DOUBLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(1392); approximate_numeric_type();
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
		enterRule(_localctx, 110, RULE_exact_numeric_type);
		try {
			setState(1416);
			switch (_input.LA(1)) {
			case NUMERIC:
				enterOuterAlt(_localctx, 1);
				{
				setState(1395); match(NUMERIC);
				setState(1397);
				switch ( getInterpreter().adaptivePredict(_input,184,_ctx) ) {
				case 1:
					{
					setState(1396); precision_param();
					}
					break;
				}
				}
				break;
			case DECIMAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(1399); match(DECIMAL);
				setState(1401);
				switch ( getInterpreter().adaptivePredict(_input,185,_ctx) ) {
				case 1:
					{
					setState(1400); precision_param();
					}
					break;
				}
				}
				break;
			case DEC:
				enterOuterAlt(_localctx, 3);
				{
				setState(1403); match(DEC);
				setState(1405);
				switch ( getInterpreter().adaptivePredict(_input,186,_ctx) ) {
				case 1:
					{
					setState(1404); precision_param();
					}
					break;
				}
				}
				break;
			case INT1:
				enterOuterAlt(_localctx, 4);
				{
				setState(1407); match(INT1);
				}
				break;
			case TINYINT:
				enterOuterAlt(_localctx, 5);
				{
				setState(1408); match(TINYINT);
				}
				break;
			case INT2:
				enterOuterAlt(_localctx, 6);
				{
				setState(1409); match(INT2);
				}
				break;
			case SMALLINT:
				enterOuterAlt(_localctx, 7);
				{
				setState(1410); match(SMALLINT);
				}
				break;
			case INT4:
				enterOuterAlt(_localctx, 8);
				{
				setState(1411); match(INT4);
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 9);
				{
				setState(1412); match(INT);
				}
				break;
			case INTEGER:
				enterOuterAlt(_localctx, 10);
				{
				setState(1413); match(INTEGER);
				}
				break;
			case INT8:
				enterOuterAlt(_localctx, 11);
				{
				setState(1414); match(INT8);
				}
				break;
			case BIGINT:
				enterOuterAlt(_localctx, 12);
				{
				setState(1415); match(BIGINT);
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
		enterRule(_localctx, 112, RULE_approximate_numeric_type);
		try {
			setState(1428);
			switch ( getInterpreter().adaptivePredict(_input,189,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1418); match(FLOAT);
				setState(1420);
				switch ( getInterpreter().adaptivePredict(_input,188,_ctx) ) {
				case 1:
					{
					setState(1419); precision_param();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1422); match(FLOAT4);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1423); match(REAL);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1424); match(FLOAT8);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1425); match(DOUBLE);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1426); match(DOUBLE);
				setState(1427); match(PRECISION);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 114, RULE_precision_param);
		try {
			setState(1438);
			switch ( getInterpreter().adaptivePredict(_input,190,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1430); match(LEFT_PAREN);
				setState(1431); ((Precision_paramContext)_localctx).precision = match(NUMBER);
				setState(1432); match(RIGHT_PAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1433); match(LEFT_PAREN);
				setState(1434); ((Precision_paramContext)_localctx).precision = match(NUMBER);
				setState(1435); match(COMMA);
				setState(1436); ((Precision_paramContext)_localctx).scale = match(NUMBER);
				setState(1437); match(RIGHT_PAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 116, RULE_boolean_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1440);
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
		enterRule(_localctx, 118, RULE_datetime_type);
		try {
			setState(1455);
			switch ( getInterpreter().adaptivePredict(_input,191,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1442); match(DATE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1443); match(TIME);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1444); match(TIME);
				setState(1445); match(WITH);
				setState(1446); match(TIME);
				setState(1447); match(ZONE);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1448); match(TIMETZ);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1449); match(TIMESTAMP);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1450); match(TIMESTAMP);
				setState(1451); match(WITH);
				setState(1452); match(TIME);
				setState(1453); match(ZONE);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1454); match(TIMESTAMPTZ);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 120, RULE_bit_type);
		try {
			setState(1470);
			switch ( getInterpreter().adaptivePredict(_input,195,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1457); match(BIT);
				setState(1459);
				switch ( getInterpreter().adaptivePredict(_input,192,_ctx) ) {
				case 1:
					{
					setState(1458); type_length();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1461); match(VARBIT);
				setState(1463);
				switch ( getInterpreter().adaptivePredict(_input,193,_ctx) ) {
				case 1:
					{
					setState(1462); type_length();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1465); match(BIT);
				setState(1466); match(VARYING);
				setState(1468);
				switch ( getInterpreter().adaptivePredict(_input,194,_ctx) ) {
				case 1:
					{
					setState(1467); type_length();
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
		enterRule(_localctx, 122, RULE_binary_type);
		try {
			setState(1485);
			switch ( getInterpreter().adaptivePredict(_input,199,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1472); match(BINARY);
				setState(1474);
				switch ( getInterpreter().adaptivePredict(_input,196,_ctx) ) {
				case 1:
					{
					setState(1473); type_length();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1476); match(BINARY);
				setState(1477); match(VARYING);
				setState(1479);
				switch ( getInterpreter().adaptivePredict(_input,197,_ctx) ) {
				case 1:
					{
					setState(1478); type_length();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1481); match(VARBINARY);
				setState(1483);
				switch ( getInterpreter().adaptivePredict(_input,198,_ctx) ) {
				case 1:
					{
					setState(1482); type_length();
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
		enterRule(_localctx, 124, RULE_value_expression_primary);
		try {
			setState(1489);
			switch ( getInterpreter().adaptivePredict(_input,200,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1487); parenthesized_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1488); nonparenthesized_value_expression_primary();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 126, RULE_parenthesized_value_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1491); match(LEFT_PAREN);
			setState(1492); value_expression();
			setState(1493); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 128, RULE_nonparenthesized_value_expression_primary);
		try {
			setState(1502);
			switch ( getInterpreter().adaptivePredict(_input,201,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1495); unsigned_value_specification();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1496); column_reference();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1497); set_function_specification();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1498); scalar_subquery();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1499); case_expression();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1500); cast_specification();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1501); routine_invocation();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 130, RULE_unsigned_value_specification);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1504); unsigned_literal();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 132, RULE_unsigned_numeric_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1506);
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
		enterRule(_localctx, 134, RULE_signed_numerical_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1509);
			_la = _input.LA(1);
			if (_la==PLUS || _la==MINUS) {
				{
				setState(1508); sign();
				}
			}

			setState(1511); unsigned_numeric_literal();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 136, RULE_set_function_specification);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1513); aggregate_function();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 138, RULE_aggregate_function);
		try {
			setState(1523);
			switch ( getInterpreter().adaptivePredict(_input,204,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1515); match(COUNT);
				setState(1516); match(LEFT_PAREN);
				setState(1517); match(MULTIPLY);
				setState(1518); match(RIGHT_PAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1519); general_set_function();
				setState(1521);
				switch ( getInterpreter().adaptivePredict(_input,203,_ctx) ) {
				case 1:
					{
					setState(1520); filter_clause();
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
		enterRule(_localctx, 140, RULE_general_set_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1525); set_function_type();
			setState(1526); match(LEFT_PAREN);
			setState(1528);
			_la = _input.LA(1);
			if (_la==ALL || _la==DISTINCT) {
				{
				setState(1527); set_qualifier();
				}
			}

			setState(1530); value_expression();
			setState(1531); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 142, RULE_set_function_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1533);
			_la = _input.LA(1);
			if ( !(_la==ANY || ((((_la - 79)) & ~0x3f) == 0 && ((1L << (_la - 79)) & ((1L << (SOME - 79)) | (1L << (AVG - 79)) | (1L << (COLLECT - 79)) | (1L << (COUNT - 79)) | (1L << (EVERY - 79)) | (1L << (FUSION - 79)) | (1L << (INTERSECTION - 79)) | (1L << (MAX - 79)))) != 0) || ((((_la - 145)) & ~0x3f) == 0 && ((1L << (_la - 145)) & ((1L << (MIN - 145)) | (1L << (STDDEV_POP - 145)) | (1L << (STDDEV_SAMP - 145)) | (1L << (SUM - 145)) | (1L << (VAR_SAMP - 145)) | (1L << (VAR_POP - 145)))) != 0)) ) {
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
		enterRule(_localctx, 144, RULE_filter_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1535); match(FILTER);
			setState(1536); match(LEFT_PAREN);
			setState(1537); match(WHERE);
			setState(1538); search_condition();
			setState(1539); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 146, RULE_grouping_operation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1541); match(GROUPING);
			setState(1542); match(LEFT_PAREN);
			setState(1543); column_reference_list();
			setState(1544); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 148, RULE_case_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1546); case_specification();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 150, RULE_case_abbreviation);
		int _la;
		try {
			setState(1566);
			switch (_input.LA(1)) {
			case NULLIF:
				enterOuterAlt(_localctx, 1);
				{
				setState(1548); match(NULLIF);
				setState(1549); match(LEFT_PAREN);
				setState(1550); numeric_value_expression();
				setState(1551); match(COMMA);
				setState(1552); boolean_value_expression();
				setState(1553); match(RIGHT_PAREN);
				}
				break;
			case COALESCE:
				enterOuterAlt(_localctx, 2);
				{
				setState(1555); match(COALESCE);
				setState(1556); match(LEFT_PAREN);
				setState(1557); numeric_value_expression();
				setState(1560); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1558); match(COMMA);
					setState(1559); boolean_value_expression();
					}
					}
					setState(1562); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==COMMA );
				setState(1564); match(RIGHT_PAREN);
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
		enterRule(_localctx, 152, RULE_case_specification);
		try {
			setState(1570);
			switch ( getInterpreter().adaptivePredict(_input,208,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1568); simple_case();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1569); searched_case();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 154, RULE_simple_case);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1572); match(CASE);
			setState(1573); boolean_value_expression();
			setState(1575); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1574); simple_when_clause();
				}
				}
				setState(1577); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WHEN );
			setState(1580);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(1579); else_clause();
				}
			}

			setState(1582); match(END);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 156, RULE_searched_case);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1584); match(CASE);
			setState(1586); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1585); searched_when_clause();
				}
				}
				setState(1588); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WHEN );
			setState(1591);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(1590); else_clause();
				}
			}

			setState(1593); match(END);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 158, RULE_simple_when_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1595); match(WHEN);
			setState(1596); search_condition();
			setState(1597); match(THEN);
			setState(1598); result();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 160, RULE_searched_when_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1600); match(WHEN);
			setState(1601); ((Searched_when_clauseContext)_localctx).c = search_condition();
			setState(1602); match(THEN);
			setState(1603); ((Searched_when_clauseContext)_localctx).r = result();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 162, RULE_else_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1605); match(ELSE);
			setState(1606); ((Else_clauseContext)_localctx).r = result();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 164, RULE_result);
		try {
			setState(1610);
			switch ( getInterpreter().adaptivePredict(_input,213,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1608); value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1609); match(NULL);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 166, RULE_cast_specification);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1612); match(CAST);
			setState(1613); match(LEFT_PAREN);
			setState(1614); cast_operand();
			setState(1615); match(AS);
			setState(1616); cast_target();
			setState(1617); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 168, RULE_cast_operand);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1619); value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 170, RULE_cast_target);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1621); data_type();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 172, RULE_value_expression);
		try {
			setState(1626);
			switch ( getInterpreter().adaptivePredict(_input,214,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1623); common_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1624); row_value_expression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1625); boolean_value_expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 174, RULE_common_value_expression);
		try {
			setState(1631);
			switch ( getInterpreter().adaptivePredict(_input,215,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1628); numeric_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1629); string_value_expression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1630); match(NULL);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 176, RULE_numeric_value_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1633); ((Numeric_value_expressionContext)_localctx).left = term();
			setState(1638);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				{
				setState(1634);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(1635); ((Numeric_value_expressionContext)_localctx).right = term();
				}
				}
				setState(1640);
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
		enterRule(_localctx, 178, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1641); ((TermContext)_localctx).left = factor();
			setState(1646);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 244)) & ~0x3f) == 0 && ((1L << (_la - 244)) & ((1L << (MULTIPLY - 244)) | (1L << (DIVIDE - 244)) | (1L << (MODULAR - 244)))) != 0)) {
				{
				{
				setState(1642);
				_la = _input.LA(1);
				if ( !(((((_la - 244)) & ~0x3f) == 0 && ((1L << (_la - 244)) & ((1L << (MULTIPLY - 244)) | (1L << (DIVIDE - 244)) | (1L << (MODULAR - 244)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(1643); ((TermContext)_localctx).right = factor();
				}
				}
				setState(1648);
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
		enterRule(_localctx, 180, RULE_factor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1650);
			_la = _input.LA(1);
			if (_la==PLUS || _la==MINUS) {
				{
				setState(1649); sign();
				}
			}

			setState(1652); numeric_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 182, RULE_array);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1654); match(LEFT_PAREN);
			setState(1655); numeric_value_expression();
			setState(1660);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1656); match(COMMA);
				setState(1657); numeric_value_expression();
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
		enterRule(_localctx, 184, RULE_numeric_primary);
		int _la;
		try {
			setState(1674);
			switch ( getInterpreter().adaptivePredict(_input,221,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1665); value_expression_primary();
				setState(1670);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CAST_EXPRESSION) {
					{
					{
					setState(1666); match(CAST_EXPRESSION);
					setState(1667); cast_target();
					}
					}
					setState(1672);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1673); numeric_value_function();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 186, RULE_sign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1676);
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
		enterRule(_localctx, 188, RULE_numeric_value_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1678); extract_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 190, RULE_extract_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1680); match(EXTRACT);
			setState(1681); match(LEFT_PAREN);
			setState(1682); ((Extract_expressionContext)_localctx).extract_field_string = extract_field();
			setState(1683); match(FROM);
			setState(1684); extract_source();
			setState(1685); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 192, RULE_extract_field);
		try {
			setState(1690);
			switch (_input.LA(1)) {
			case DAY:
			case HOUR:
			case MINUTE:
			case MONTH:
			case SECOND:
			case YEAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(1687); primary_datetime_field();
				}
				break;
			case TIMEZONE:
			case TIMEZONE_HOUR:
			case TIMEZONE_MINUTE:
				enterOuterAlt(_localctx, 2);
				{
				setState(1688); time_zone_field();
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
				setState(1689); extended_datetime_field();
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
		enterRule(_localctx, 194, RULE_time_zone_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1692);
			_la = _input.LA(1);
			if ( !(((((_la - 174)) & ~0x3f) == 0 && ((1L << (_la - 174)) & ((1L << (TIMEZONE - 174)) | (1L << (TIMEZONE_HOUR - 174)) | (1L << (TIMEZONE_MINUTE - 174)))) != 0)) ) {
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
		enterRule(_localctx, 196, RULE_extract_source);
		try {
			setState(1696);
			switch ( getInterpreter().adaptivePredict(_input,223,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1694); column_reference();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1695); datetime_literal();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 198, RULE_string_value_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1698); character_value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 200, RULE_character_value_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1700); character_factor();
			setState(1705);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CONCATENATION_OPERATOR) {
				{
				{
				setState(1701); match(CONCATENATION_OPERATOR);
				setState(1702); character_factor();
				}
				}
				setState(1707);
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
		enterRule(_localctx, 202, RULE_character_factor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1708); character_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 204, RULE_character_primary);
		try {
			setState(1712);
			switch ( getInterpreter().adaptivePredict(_input,225,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1710); value_expression_primary();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1711); string_value_function();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 206, RULE_string_value_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1714); trim_function();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 208, RULE_trim_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1716); match(TRIM);
			setState(1717); match(LEFT_PAREN);
			setState(1718); trim_operands();
			setState(1719); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 210, RULE_trim_operands);
		int _la;
		try {
			setState(1735);
			switch ( getInterpreter().adaptivePredict(_input,229,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1728);
				switch ( getInterpreter().adaptivePredict(_input,228,_ctx) ) {
				case 1:
					{
					setState(1722);
					_la = _input.LA(1);
					if (_la==BOTH || _la==LEADING || _la==TRAILING) {
						{
						setState(1721); trim_specification();
						}
					}

					setState(1725);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ANY) | (1L << CASE) | (1L << CAST) | (1L << FALSE) | (1L << LEFT))) != 0) || ((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & ((1L << (RIGHT - 73)) | (1L << (SOME - 73)) | (1L << (TRUE - 73)) | (1L << (ADMIN - 73)) | (1L << (AVG - 73)) | (1L << (BETWEEN - 73)) | (1L << (BY - 73)) | (1L << (CENTURY - 73)) | (1L << (CHARACTER - 73)) | (1L << (COLLECT - 73)) | (1L << (COALESCE - 73)) | (1L << (COLUMN - 73)) | (1L << (COUNT - 73)) | (1L << (CUBE - 73)) | (1L << (DATA - 73)) | (1L << (DAY - 73)) | (1L << (DEC - 73)) | (1L << (DECADE - 73)) | (1L << (DOW - 73)) | (1L << (DOY - 73)) | (1L << (DROP - 73)) | (1L << (EPOCH - 73)) | (1L << (EVERY - 73)) | (1L << (EXISTS - 73)) | (1L << (EXTERNAL - 73)) | (1L << (EXTRACT - 73)) | (1L << (FILTER - 73)) | (1L << (FIRST - 73)) | (1L << (FORMAT - 73)) | (1L << (FUSION - 73)) | (1L << (GROUPING - 73)) | (1L << (HASH - 73)) | (1L << (INDEX - 73)) | (1L << (INSERT - 73)) | (1L << (INTERSECTION - 73)) | (1L << (ISODOW - 73)) | (1L << (ISOYEAR - 73)) | (1L << (LANGUAGE - 73)) | (1L << (LARGE - 73)) | (1L << (LAST - 73)))) != 0) || ((((_la - 137)) & ~0x3f) == 0 && ((1L << (_la - 137)) & ((1L << (LESS - 137)) | (1L << (LIST - 137)) | (1L << (LOCATION - 137)) | (1L << (MAX - 137)) | (1L << (MAXVALUE - 137)) | (1L << (MICROSECONDS - 137)) | (1L << (MILLENNIUM - 137)) | (1L << (MILLISECONDS - 137)) | (1L << (MIN - 137)) | (1L << (MINUTE - 137)) | (1L << (MONTH - 137)) | (1L << (NATIONAL - 137)) | (1L << (NULLIF - 137)) | (1L << (OBJECT - 137)) | (1L << (OPTION - 137)) | (1L << (OVERWRITE - 137)) | (1L << (PARTITION - 137)) | (1L << (PARTITIONS - 137)) | (1L << (PRECISION - 137)) | (1L << (PUBLIC - 137)) | (1L << (PURGE - 137)) | (1L << (QUARTER - 137)) | (1L << (RANGE - 137)) | (1L << (REGEXP - 137)) | (1L << (RLIKE - 137)) | (1L << (ROLLUP - 137)) | (1L << (SECOND - 137)) | (1L << (SERVER - 137)) | (1L << (SET - 137)) | (1L << (SIMILAR - 137)) | (1L << (STDDEV_POP - 137)) | (1L << (STDDEV_SAMP - 137)) | (1L << (SUBPARTITION - 137)) | (1L << (SUM - 137)) | (1L << (TABLESPACE - 137)) | (1L << (THAN - 137)) | (1L << (TIMEZONE - 137)) | (1L << (TIMEZONE_HOUR - 137)) | (1L << (TIMEZONE_MINUTE - 137)) | (1L << (TRIM - 137)) | (1L << (TO - 137)) | (1L << (UNKNOWN - 137)) | (1L << (VALUES - 137)) | (1L << (VAR_SAMP - 137)) | (1L << (VAR_POP - 137)) | (1L << (VARYING - 137)) | (1L << (WEEK - 137)) | (1L << (WRAPPER - 137)) | (1L << (YEAR - 137)) | (1L << (ZONE - 137)) | (1L << (BOOLEAN - 137)) | (1L << (BOOL - 137)) | (1L << (BIT - 137)) | (1L << (VARBIT - 137)) | (1L << (INT1 - 137)) | (1L << (INT2 - 137)) | (1L << (INT4 - 137)) | (1L << (INT8 - 137)) | (1L << (TINYINT - 137)) | (1L << (SMALLINT - 137)) | (1L << (INT - 137)) | (1L << (INTEGER - 137)))) != 0) || ((((_la - 201)) & ~0x3f) == 0 && ((1L << (_la - 201)) & ((1L << (BIGINT - 201)) | (1L << (FLOAT4 - 201)) | (1L << (FLOAT8 - 201)) | (1L << (REAL - 201)) | (1L << (FLOAT - 201)) | (1L << (DOUBLE - 201)) | (1L << (NUMERIC - 201)) | (1L << (DECIMAL - 201)) | (1L << (CHAR - 201)) | (1L << (VARCHAR - 201)) | (1L << (NCHAR - 201)) | (1L << (NVARCHAR - 201)) | (1L << (DATE - 201)) | (1L << (TIME - 201)) | (1L << (TIMETZ - 201)) | (1L << (TIMESTAMP - 201)) | (1L << (TIMESTAMPTZ - 201)) | (1L << (TEXT - 201)) | (1L << (VARBINARY - 201)) | (1L << (BLOB - 201)) | (1L << (BYTEA - 201)) | (1L << (INET4 - 201)) | (1L << (LEFT_PAREN - 201)) | (1L << (NUMBER - 201)) | (1L << (REAL_NUMBER - 201)) | (1L << (Identifier - 201)) | (1L << (Character_String_Literal - 201)))) != 0)) {
						{
						setState(1724); ((Trim_operandsContext)_localctx).trim_character = character_value_expression();
						}
					}

					setState(1727); match(FROM);
					}
					break;
				}
				setState(1730); ((Trim_operandsContext)_localctx).trim_source = character_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1731); ((Trim_operandsContext)_localctx).trim_source = character_value_expression();
				setState(1732); match(COMMA);
				setState(1733); ((Trim_operandsContext)_localctx).trim_character = character_value_expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 212, RULE_trim_specification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1737);
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
		enterRule(_localctx, 214, RULE_boolean_value_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1739); or_predicate();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 216, RULE_or_predicate);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1741); and_predicate();
			setState(1746);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,230,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1742); match(OR);
					setState(1743); or_predicate();
					}
					} 
				}
				setState(1748);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,230,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 218, RULE_and_predicate);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1749); boolean_factor();
			setState(1754);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,231,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1750); match(AND);
					setState(1751); and_predicate();
					}
					} 
				}
				setState(1756);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,231,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 220, RULE_boolean_factor);
		try {
			setState(1760);
			switch ( getInterpreter().adaptivePredict(_input,232,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1757); boolean_test();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1758); match(NOT);
				setState(1759); boolean_test();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 222, RULE_boolean_test);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1762); boolean_primary();
			setState(1764);
			_la = _input.LA(1);
			if (_la==IS) {
				{
				setState(1763); is_clause();
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
		enterRule(_localctx, 224, RULE_is_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1766); match(IS);
			setState(1768);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(1767); match(NOT);
				}
			}

			setState(1770); ((Is_clauseContext)_localctx).t = truth_value();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 226, RULE_truth_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1772);
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
		enterRule(_localctx, 228, RULE_boolean_primary);
		try {
			setState(1776);
			switch ( getInterpreter().adaptivePredict(_input,235,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1774); predicate();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1775); boolean_predicand();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 230, RULE_boolean_predicand);
		try {
			setState(1780);
			switch ( getInterpreter().adaptivePredict(_input,236,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1778); parenthesized_boolean_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1779); nonparenthesized_value_expression_primary();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 232, RULE_parenthesized_boolean_value_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1782); match(LEFT_PAREN);
			setState(1783); boolean_value_expression();
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
		enterRule(_localctx, 234, RULE_row_value_expression);
		try {
			setState(1788);
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
				setState(1786); row_value_special_case();
				}
				break;
			case NULL:
				enterOuterAlt(_localctx, 2);
				{
				setState(1787); explicit_row_value_constructor();
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
		enterRule(_localctx, 236, RULE_row_value_special_case);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1790); nonparenthesized_value_expression_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 238, RULE_explicit_row_value_constructor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1792); match(NULL);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 240, RULE_row_value_predicand);
		try {
			setState(1796);
			switch ( getInterpreter().adaptivePredict(_input,238,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1794); row_value_special_case();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1795); row_value_constructor_predicand();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 242, RULE_row_value_constructor_predicand);
		try {
			setState(1800);
			switch ( getInterpreter().adaptivePredict(_input,239,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1798); common_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1799); boolean_predicand();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 244, RULE_table_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1802); from_clause();
			setState(1804);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(1803); where_clause();
				}
			}

			setState(1807);
			_la = _input.LA(1);
			if (_la==GROUP) {
				{
				setState(1806); groupby_clause();
				}
			}

			setState(1810);
			_la = _input.LA(1);
			if (_la==HAVING) {
				{
				setState(1809); having_clause();
				}
			}

			setState(1813);
			_la = _input.LA(1);
			if (_la==ORDER) {
				{
				setState(1812); orderby_clause();
				}
			}

			setState(1816);
			_la = _input.LA(1);
			if (_la==LIMIT) {
				{
				setState(1815); limit_clause();
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
		enterRule(_localctx, 246, RULE_from_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1818); match(FROM);
			setState(1819); table_reference_list();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 248, RULE_table_reference_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1821); table_reference();
			setState(1826);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1822); match(COMMA);
				setState(1823); table_reference();
				}
				}
				setState(1828);
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
		enterRule(_localctx, 250, RULE_table_reference);
		try {
			setState(1831);
			switch ( getInterpreter().adaptivePredict(_input,246,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1829); joined_table();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1830); table_primary();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 252, RULE_joined_table);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1833); table_primary();
			setState(1835); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(1834); joined_table_primary();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1837); 
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
		enterRule(_localctx, 254, RULE_joined_table_primary);
		int _la;
		try {
			setState(1858);
			switch (_input.LA(1)) {
			case CROSS:
				enterOuterAlt(_localctx, 1);
				{
				setState(1839); match(CROSS);
				setState(1840); match(JOIN);
				setState(1841); ((Joined_table_primaryContext)_localctx).right = table_primary();
				}
				break;
			case FULL:
			case INNER:
			case JOIN:
			case LEFT:
			case RIGHT:
				enterOuterAlt(_localctx, 2);
				{
				setState(1843);
				_la = _input.LA(1);
				if (((((_la - 33)) & ~0x3f) == 0 && ((1L << (_la - 33)) & ((1L << (FULL - 33)) | (1L << (INNER - 33)) | (1L << (LEFT - 33)) | (1L << (RIGHT - 33)))) != 0)) {
					{
					setState(1842); ((Joined_table_primaryContext)_localctx).t = join_type();
					}
				}

				setState(1845); match(JOIN);
				setState(1846); ((Joined_table_primaryContext)_localctx).right = table_primary();
				setState(1847); ((Joined_table_primaryContext)_localctx).s = join_specification();
				}
				break;
			case NATURAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(1849); match(NATURAL);
				setState(1851);
				_la = _input.LA(1);
				if (((((_la - 33)) & ~0x3f) == 0 && ((1L << (_la - 33)) & ((1L << (FULL - 33)) | (1L << (INNER - 33)) | (1L << (LEFT - 33)) | (1L << (RIGHT - 33)))) != 0)) {
					{
					setState(1850); ((Joined_table_primaryContext)_localctx).t = join_type();
					}
				}

				setState(1853); match(JOIN);
				setState(1854); ((Joined_table_primaryContext)_localctx).right = table_primary();
				}
				break;
			case UNION:
				enterOuterAlt(_localctx, 4);
				{
				setState(1855); match(UNION);
				setState(1856); match(JOIN);
				setState(1857); ((Joined_table_primaryContext)_localctx).right = table_primary();
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
		enterRule(_localctx, 256, RULE_cross_join);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1860); match(CROSS);
			setState(1861); match(JOIN);
			setState(1862); ((Cross_joinContext)_localctx).r = table_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 258, RULE_qualified_join);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1865);
			_la = _input.LA(1);
			if (((((_la - 33)) & ~0x3f) == 0 && ((1L << (_la - 33)) & ((1L << (FULL - 33)) | (1L << (INNER - 33)) | (1L << (LEFT - 33)) | (1L << (RIGHT - 33)))) != 0)) {
				{
				setState(1864); ((Qualified_joinContext)_localctx).t = join_type();
				}
			}

			setState(1867); match(JOIN);
			setState(1868); ((Qualified_joinContext)_localctx).r = table_primary();
			setState(1869); ((Qualified_joinContext)_localctx).s = join_specification();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 260, RULE_natural_join);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1871); match(NATURAL);
			setState(1873);
			_la = _input.LA(1);
			if (((((_la - 33)) & ~0x3f) == 0 && ((1L << (_la - 33)) & ((1L << (FULL - 33)) | (1L << (INNER - 33)) | (1L << (LEFT - 33)) | (1L << (RIGHT - 33)))) != 0)) {
				{
				setState(1872); ((Natural_joinContext)_localctx).t = join_type();
				}
			}

			setState(1875); match(JOIN);
			setState(1876); ((Natural_joinContext)_localctx).r = table_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 262, RULE_union_join);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1878); match(UNION);
			setState(1879); match(JOIN);
			setState(1880); ((Union_joinContext)_localctx).r = table_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 264, RULE_join_type);
		try {
			setState(1884);
			switch (_input.LA(1)) {
			case INNER:
				enterOuterAlt(_localctx, 1);
				{
				setState(1882); match(INNER);
				}
				break;
			case FULL:
			case LEFT:
			case RIGHT:
				enterOuterAlt(_localctx, 2);
				{
				setState(1883); ((Join_typeContext)_localctx).t = outer_join_type();
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
		enterRule(_localctx, 266, RULE_outer_join_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1886); outer_join_type_part2();
			setState(1888);
			_la = _input.LA(1);
			if (_la==OUTER) {
				{
				setState(1887); match(OUTER);
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
		enterRule(_localctx, 268, RULE_outer_join_type_part2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1890);
			_la = _input.LA(1);
			if ( !(((((_la - 33)) & ~0x3f) == 0 && ((1L << (_la - 33)) & ((1L << (FULL - 33)) | (1L << (LEFT - 33)) | (1L << (RIGHT - 33)))) != 0)) ) {
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
		enterRule(_localctx, 270, RULE_join_specification);
		try {
			setState(1894);
			switch (_input.LA(1)) {
			case ON:
				enterOuterAlt(_localctx, 1);
				{
				setState(1892); join_condition();
				}
				break;
			case USING:
				enterOuterAlt(_localctx, 2);
				{
				setState(1893); named_columns_join();
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
		enterRule(_localctx, 272, RULE_join_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1896); match(ON);
			setState(1897); search_condition();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 274, RULE_named_columns_join);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1899); match(USING);
			setState(1900); match(LEFT_PAREN);
			setState(1901); ((Named_columns_joinContext)_localctx).f = column_reference_list();
			setState(1902); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 276, RULE_table_primary);
		int _la;
		try {
			setState(1928);
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
				setState(1904); table_or_query_name();
				setState(1909);
				switch ( getInterpreter().adaptivePredict(_input,257,_ctx) ) {
				case 1:
					{
					setState(1906);
					_la = _input.LA(1);
					if (_la==AS) {
						{
						setState(1905); match(AS);
						}
					}

					setState(1908); ((Table_primaryContext)_localctx).alias = identifier();
					}
					break;
				}
				setState(1915);
				switch ( getInterpreter().adaptivePredict(_input,258,_ctx) ) {
				case 1:
					{
					setState(1911); match(LEFT_PAREN);
					setState(1912); column_name_list();
					setState(1913); match(RIGHT_PAREN);
					}
					break;
				}
				}
				break;
			case LEFT_PAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(1917); derived_table();
				setState(1919);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(1918); match(AS);
					}
				}

				setState(1921); ((Table_primaryContext)_localctx).name = identifier();
				setState(1926);
				switch ( getInterpreter().adaptivePredict(_input,260,_ctx) ) {
				case 1:
					{
					setState(1922); match(LEFT_PAREN);
					setState(1923); column_name_list();
					setState(1924); match(RIGHT_PAREN);
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
		enterRule(_localctx, 278, RULE_column_name_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1930); identifier();
			setState(1935);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1931); match(COMMA);
				setState(1932); identifier();
				}
				}
				setState(1937);
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
		enterRule(_localctx, 280, RULE_derived_table);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1938); table_subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 282, RULE_where_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1940); match(WHERE);
			setState(1941); search_condition();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 284, RULE_search_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1943); value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 286, RULE_groupby_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1945); match(GROUP);
			setState(1946); match(BY);
			setState(1947); ((Groupby_clauseContext)_localctx).g = grouping_element_list();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 288, RULE_grouping_element_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1949); grouping_element();
			setState(1954);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1950); match(COMMA);
				setState(1951); grouping_element();
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
		enterRule(_localctx, 290, RULE_grouping_element);
		try {
			setState(1961);
			switch ( getInterpreter().adaptivePredict(_input,264,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1957); rollup_list();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1958); cube_list();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1959); empty_grouping_set();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1960); ordinary_grouping_set();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 292, RULE_ordinary_grouping_set);
		try {
			setState(1968);
			switch ( getInterpreter().adaptivePredict(_input,265,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1963); row_value_predicand();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1964); match(LEFT_PAREN);
				setState(1965); row_value_predicand_list();
				setState(1966); match(RIGHT_PAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 294, RULE_ordinary_grouping_set_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1970); ordinary_grouping_set();
			setState(1975);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1971); match(COMMA);
				setState(1972); ordinary_grouping_set();
				}
				}
				setState(1977);
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
		enterRule(_localctx, 296, RULE_rollup_list);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1978); match(ROLLUP);
			setState(1979); match(LEFT_PAREN);
			setState(1980); ((Rollup_listContext)_localctx).c = ordinary_grouping_set_list();
			setState(1981); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 298, RULE_cube_list);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1983); match(CUBE);
			setState(1984); match(LEFT_PAREN);
			setState(1985); ((Cube_listContext)_localctx).c = ordinary_grouping_set_list();
			setState(1986); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 300, RULE_empty_grouping_set);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1988); match(LEFT_PAREN);
			setState(1989); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 302, RULE_having_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1991); match(HAVING);
			setState(1992); boolean_value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 304, RULE_row_value_predicand_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1994); row_value_predicand();
			setState(1999);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1995); match(COMMA);
				setState(1996); row_value_predicand();
				}
				}
				setState(2001);
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
		enterRule(_localctx, 306, RULE_query_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2002); query_expression_body();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 308, RULE_query_expression_body);
		try {
			setState(2006);
			switch ( getInterpreter().adaptivePredict(_input,268,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2004); non_join_query_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2005); joined_table();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 310, RULE_non_join_query_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2016);
			switch ( getInterpreter().adaptivePredict(_input,270,_ctx) ) {
			case 1:
				{
				setState(2008); non_join_query_term();
				}
				break;
			case 2:
				{
				setState(2009); joined_table();
				setState(2010);
				_la = _input.LA(1);
				if ( !(_la==EXCEPT || _la==UNION) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(2012);
				_la = _input.LA(1);
				if (_la==ALL || _la==DISTINCT) {
					{
					setState(2011);
					_la = _input.LA(1);
					if ( !(_la==ALL || _la==DISTINCT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(2014); query_term();
				}
				break;
			}
			setState(2025);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==EXCEPT || _la==UNION) {
				{
				{
				setState(2018);
				_la = _input.LA(1);
				if ( !(_la==EXCEPT || _la==UNION) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(2020);
				_la = _input.LA(1);
				if (_la==ALL || _la==DISTINCT) {
					{
					setState(2019);
					_la = _input.LA(1);
					if ( !(_la==ALL || _la==DISTINCT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(2022); query_term();
				}
				}
				setState(2027);
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
		enterRule(_localctx, 312, RULE_query_term);
		try {
			setState(2030);
			switch ( getInterpreter().adaptivePredict(_input,273,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2028); non_join_query_term();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2029); joined_table();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 314, RULE_non_join_query_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2040);
			switch ( getInterpreter().adaptivePredict(_input,275,_ctx) ) {
			case 1:
				{
				setState(2032); non_join_query_primary();
				}
				break;
			case 2:
				{
				setState(2033); joined_table();
				setState(2034); match(INTERSECT);
				setState(2036);
				_la = _input.LA(1);
				if (_la==ALL || _la==DISTINCT) {
					{
					setState(2035);
					_la = _input.LA(1);
					if ( !(_la==ALL || _la==DISTINCT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(2038); query_primary();
				}
				break;
			}
			setState(2049);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==INTERSECT) {
				{
				{
				setState(2042); match(INTERSECT);
				setState(2044);
				_la = _input.LA(1);
				if (_la==ALL || _la==DISTINCT) {
					{
					setState(2043);
					_la = _input.LA(1);
					if ( !(_la==ALL || _la==DISTINCT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(2046); query_primary();
				}
				}
				setState(2051);
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
		enterRule(_localctx, 316, RULE_query_primary);
		try {
			setState(2054);
			switch ( getInterpreter().adaptivePredict(_input,278,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2052); non_join_query_primary();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2053); joined_table();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 318, RULE_non_join_query_primary);
		try {
			setState(2061);
			switch (_input.LA(1)) {
			case SELECT:
			case TABLE:
				enterOuterAlt(_localctx, 1);
				{
				setState(2056); simple_table();
				}
				break;
			case LEFT_PAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(2057); match(LEFT_PAREN);
				setState(2058); non_join_query_expression();
				setState(2059); match(RIGHT_PAREN);
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
		enterRule(_localctx, 320, RULE_simple_table);
		try {
			setState(2065);
			switch (_input.LA(1)) {
			case SELECT:
				enterOuterAlt(_localctx, 1);
				{
				setState(2063); query_specification();
				}
				break;
			case TABLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(2064); explicit_table();
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
		enterRule(_localctx, 322, RULE_explicit_table);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2067); match(TABLE);
			setState(2068); table_or_query_name();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 324, RULE_table_or_query_name);
		try {
			setState(2072);
			switch ( getInterpreter().adaptivePredict(_input,281,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2070); table_name();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2071); identifier();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 326, RULE_table_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2074); identifier();
			setState(2081);
			_la = _input.LA(1);
			if (_la==DOT) {
				{
				setState(2075); match(DOT);
				setState(2076); identifier();
				setState(2079);
				_la = _input.LA(1);
				if (_la==DOT) {
					{
					setState(2077); match(DOT);
					setState(2078); identifier();
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
		enterRule(_localctx, 328, RULE_query_specification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2083); match(SELECT);
			setState(2085);
			_la = _input.LA(1);
			if (_la==ALL || _la==DISTINCT) {
				{
				setState(2084); set_qualifier();
				}
			}

			setState(2087); select_list();
			setState(2089);
			_la = _input.LA(1);
			if (_la==FROM) {
				{
				setState(2088); table_expression();
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
		enterRule(_localctx, 330, RULE_select_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2091); select_sublist();
			setState(2096);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2092); match(COMMA);
				setState(2093); select_sublist();
				}
				}
				setState(2098);
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
		enterRule(_localctx, 332, RULE_select_sublist);
		try {
			setState(2101);
			switch ( getInterpreter().adaptivePredict(_input,287,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2099); derived_column();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2100); qualified_asterisk();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 334, RULE_derived_column);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2103); value_expression();
			setState(2105);
			switch ( getInterpreter().adaptivePredict(_input,288,_ctx) ) {
			case 1:
				{
				setState(2104); as_clause();
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
		enterRule(_localctx, 336, RULE_qualified_asterisk);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2109);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(2107); ((Qualified_asteriskContext)_localctx).tb_name = match(Identifier);
				setState(2108); match(DOT);
				}
			}

			setState(2111); match(MULTIPLY);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 338, RULE_set_qualifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2113);
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
		enterRule(_localctx, 340, RULE_column_reference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2118);
			switch ( getInterpreter().adaptivePredict(_input,290,_ctx) ) {
			case 1:
				{
				setState(2115); ((Column_referenceContext)_localctx).tb_name = identifier();
				setState(2116); match(DOT);
				}
				break;
			}
			setState(2120); ((Column_referenceContext)_localctx).name = identifier();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 342, RULE_as_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2123);
			_la = _input.LA(1);
			if (_la==AS) {
				{
				setState(2122); match(AS);
				}
			}

			setState(2125); identifier();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 344, RULE_column_reference_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2127); column_reference();
			setState(2132);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2128); match(COMMA);
				setState(2129); column_reference();
				}
				}
				setState(2134);
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
		enterRule(_localctx, 346, RULE_scalar_subquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2135); subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 348, RULE_row_subquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2137); subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 350, RULE_table_subquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2139); subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 352, RULE_subquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2141); match(LEFT_PAREN);
			setState(2142); query_expression();
			setState(2143); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 354, RULE_predicate);
		try {
			setState(2151);
			switch ( getInterpreter().adaptivePredict(_input,293,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2145); comparison_predicate();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2146); between_predicate();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2147); in_predicate();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2148); pattern_matching_predicate();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2149); null_predicate();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2150); exists_predicate();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 356, RULE_comparison_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2153); ((Comparison_predicateContext)_localctx).left = row_value_predicand();
			setState(2154); ((Comparison_predicateContext)_localctx).c = comp_op();
			setState(2155); ((Comparison_predicateContext)_localctx).right = row_value_predicand();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 358, RULE_comp_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2157);
			_la = _input.LA(1);
			if ( !(((((_la - 230)) & ~0x3f) == 0 && ((1L << (_la - 230)) & ((1L << (EQUAL - 230)) | (1L << (NOT_EQUAL - 230)) | (1L << (LTH - 230)) | (1L << (LEQ - 230)) | (1L << (GTH - 230)) | (1L << (GEQ - 230)))) != 0)) ) {
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
		enterRule(_localctx, 360, RULE_between_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2159); ((Between_predicateContext)_localctx).predicand = row_value_predicand();
			setState(2160); between_predicate_part_2();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 362, RULE_between_predicate_part_2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2163);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(2162); match(NOT);
				}
			}

			setState(2165); match(BETWEEN);
			setState(2167);
			_la = _input.LA(1);
			if (_la==ASYMMETRIC || _la==SYMMETRIC) {
				{
				setState(2166);
				_la = _input.LA(1);
				if ( !(_la==ASYMMETRIC || _la==SYMMETRIC) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(2169); ((Between_predicate_part_2Context)_localctx).begin = row_value_predicand();
			setState(2170); match(AND);
			setState(2171); ((Between_predicate_part_2Context)_localctx).end = row_value_predicand();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 364, RULE_in_predicate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2173); ((In_predicateContext)_localctx).predicand = numeric_value_expression();
			setState(2175);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(2174); match(NOT);
				}
			}

			setState(2177); match(IN);
			setState(2178); in_predicate_value();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 366, RULE_in_predicate_value);
		try {
			setState(2185);
			switch ( getInterpreter().adaptivePredict(_input,297,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2180); table_subquery();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2181); match(LEFT_PAREN);
				setState(2182); in_value_list();
				setState(2183); match(RIGHT_PAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 368, RULE_in_value_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2187); row_value_expression();
			setState(2192);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2188); match(COMMA);
				setState(2189); row_value_expression();
				}
				}
				setState(2194);
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
		enterRule(_localctx, 370, RULE_pattern_matching_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2195); ((Pattern_matching_predicateContext)_localctx).f = row_value_predicand();
			setState(2196); pattern_matcher();
			setState(2197); ((Pattern_matching_predicateContext)_localctx).s = match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 372, RULE_pattern_matcher);
		int _la;
		try {
			setState(2204);
			switch (_input.LA(1)) {
			case ILIKE:
			case LIKE:
			case NOT:
			case REGEXP:
			case RLIKE:
			case SIMILAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(2200);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(2199); match(NOT);
					}
				}

				setState(2202); negativable_matcher();
				}
				break;
			case Similar_To:
			case Not_Similar_To:
			case Similar_To_Case_Insensitive:
			case Not_Similar_To_Case_Insensitive:
				enterOuterAlt(_localctx, 2);
				{
				setState(2203); regex_matcher();
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
		enterRule(_localctx, 374, RULE_negativable_matcher);
		try {
			setState(2212);
			switch (_input.LA(1)) {
			case LIKE:
				enterOuterAlt(_localctx, 1);
				{
				setState(2206); match(LIKE);
				}
				break;
			case ILIKE:
				enterOuterAlt(_localctx, 2);
				{
				setState(2207); match(ILIKE);
				}
				break;
			case SIMILAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(2208); match(SIMILAR);
				setState(2209); match(TO);
				}
				break;
			case REGEXP:
				enterOuterAlt(_localctx, 4);
				{
				setState(2210); match(REGEXP);
				}
				break;
			case RLIKE:
				enterOuterAlt(_localctx, 5);
				{
				setState(2211); match(RLIKE);
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
		enterRule(_localctx, 376, RULE_regex_matcher);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2214);
			_la = _input.LA(1);
			if ( !(((((_la - 224)) & ~0x3f) == 0 && ((1L << (_la - 224)) & ((1L << (Similar_To - 224)) | (1L << (Not_Similar_To - 224)) | (1L << (Similar_To_Case_Insensitive - 224)) | (1L << (Not_Similar_To_Case_Insensitive - 224)))) != 0)) ) {
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
		enterRule(_localctx, 378, RULE_null_predicate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2216); ((Null_predicateContext)_localctx).predicand = row_value_predicand();
			setState(2217); match(IS);
			setState(2219);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(2218); ((Null_predicateContext)_localctx).n = match(NOT);
				}
			}

			setState(2221); match(NULL);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 380, RULE_quantified_comparison_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2223); ((Quantified_comparison_predicateContext)_localctx).l = numeric_value_expression();
			setState(2224); ((Quantified_comparison_predicateContext)_localctx).c = comp_op();
			setState(2225); ((Quantified_comparison_predicateContext)_localctx).q = quantifier();
			setState(2226); ((Quantified_comparison_predicateContext)_localctx).s = table_subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 382, RULE_quantifier);
		try {
			setState(2230);
			switch (_input.LA(1)) {
			case ALL:
				enterOuterAlt(_localctx, 1);
				{
				setState(2228); all();
				}
				break;
			case ANY:
			case SOME:
				enterOuterAlt(_localctx, 2);
				{
				setState(2229); some();
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
		enterRule(_localctx, 384, RULE_all);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2232); match(ALL);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 386, RULE_some);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2234);
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
		enterRule(_localctx, 388, RULE_exists_predicate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2237);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(2236); match(NOT);
				}
			}

			setState(2239); match(EXISTS);
			setState(2240); ((Exists_predicateContext)_localctx).s = table_subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 390, RULE_unique_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2242); match(UNIQUE);
			setState(2243); ((Unique_predicateContext)_localctx).s = table_subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 392, RULE_primary_datetime_field);
		try {
			setState(2247);
			switch (_input.LA(1)) {
			case DAY:
			case HOUR:
			case MINUTE:
			case MONTH:
			case YEAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(2245); non_second_primary_datetime_field();
				}
				break;
			case SECOND:
				enterOuterAlt(_localctx, 2);
				{
				setState(2246); match(SECOND);
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
		enterRule(_localctx, 394, RULE_non_second_primary_datetime_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2249);
			_la = _input.LA(1);
			if ( !(((((_la - 111)) & ~0x3f) == 0 && ((1L << (_la - 111)) & ((1L << (DAY - 111)) | (1L << (HOUR - 111)) | (1L << (MINUTE - 111)) | (1L << (MONTH - 111)))) != 0) || _la==YEAR) ) {
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
		enterRule(_localctx, 396, RULE_extended_datetime_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2251);
			_la = _input.LA(1);
			if ( !(((((_la - 103)) & ~0x3f) == 0 && ((1L << (_la - 103)) & ((1L << (CENTURY - 103)) | (1L << (DECADE - 103)) | (1L << (DOW - 103)) | (1L << (DOY - 103)) | (1L << (EPOCH - 103)) | (1L << (ISODOW - 103)) | (1L << (ISOYEAR - 103)) | (1L << (MICROSECONDS - 103)) | (1L << (MILLENNIUM - 103)) | (1L << (MILLISECONDS - 103)) | (1L << (QUARTER - 103)))) != 0) || _la==WEEK) ) {
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
		enterRule(_localctx, 398, RULE_routine_invocation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2253); function_name();
			setState(2254); match(LEFT_PAREN);
			setState(2256);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ANY) | (1L << CASE) | (1L << CAST) | (1L << FALSE) | (1L << LEFT) | (1L << NOT) | (1L << NULL))) != 0) || ((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & ((1L << (RIGHT - 73)) | (1L << (SOME - 73)) | (1L << (TRUE - 73)) | (1L << (ADMIN - 73)) | (1L << (AVG - 73)) | (1L << (BETWEEN - 73)) | (1L << (BY - 73)) | (1L << (CENTURY - 73)) | (1L << (CHARACTER - 73)) | (1L << (COLLECT - 73)) | (1L << (COALESCE - 73)) | (1L << (COLUMN - 73)) | (1L << (COUNT - 73)) | (1L << (CUBE - 73)) | (1L << (DATA - 73)) | (1L << (DAY - 73)) | (1L << (DEC - 73)) | (1L << (DECADE - 73)) | (1L << (DOW - 73)) | (1L << (DOY - 73)) | (1L << (DROP - 73)) | (1L << (EPOCH - 73)) | (1L << (EVERY - 73)) | (1L << (EXISTS - 73)) | (1L << (EXTERNAL - 73)) | (1L << (EXTRACT - 73)) | (1L << (FILTER - 73)) | (1L << (FIRST - 73)) | (1L << (FORMAT - 73)) | (1L << (FUSION - 73)) | (1L << (GROUPING - 73)) | (1L << (HASH - 73)) | (1L << (INDEX - 73)) | (1L << (INSERT - 73)) | (1L << (INTERSECTION - 73)) | (1L << (ISODOW - 73)) | (1L << (ISOYEAR - 73)) | (1L << (LANGUAGE - 73)) | (1L << (LARGE - 73)) | (1L << (LAST - 73)))) != 0) || ((((_la - 137)) & ~0x3f) == 0 && ((1L << (_la - 137)) & ((1L << (LESS - 137)) | (1L << (LIST - 137)) | (1L << (LOCATION - 137)) | (1L << (MAX - 137)) | (1L << (MAXVALUE - 137)) | (1L << (MICROSECONDS - 137)) | (1L << (MILLENNIUM - 137)) | (1L << (MILLISECONDS - 137)) | (1L << (MIN - 137)) | (1L << (MINUTE - 137)) | (1L << (MONTH - 137)) | (1L << (NATIONAL - 137)) | (1L << (NULLIF - 137)) | (1L << (OBJECT - 137)) | (1L << (OPTION - 137)) | (1L << (OVERWRITE - 137)) | (1L << (PARTITION - 137)) | (1L << (PARTITIONS - 137)) | (1L << (PRECISION - 137)) | (1L << (PUBLIC - 137)) | (1L << (PURGE - 137)) | (1L << (QUARTER - 137)) | (1L << (RANGE - 137)) | (1L << (REGEXP - 137)) | (1L << (RLIKE - 137)) | (1L << (ROLLUP - 137)) | (1L << (SECOND - 137)) | (1L << (SERVER - 137)) | (1L << (SET - 137)) | (1L << (SIMILAR - 137)) | (1L << (STDDEV_POP - 137)) | (1L << (STDDEV_SAMP - 137)) | (1L << (SUBPARTITION - 137)) | (1L << (SUM - 137)) | (1L << (TABLESPACE - 137)) | (1L << (THAN - 137)) | (1L << (TIMEZONE - 137)) | (1L << (TIMEZONE_HOUR - 137)) | (1L << (TIMEZONE_MINUTE - 137)) | (1L << (TRIM - 137)) | (1L << (TO - 137)) | (1L << (UNKNOWN - 137)) | (1L << (VALUES - 137)) | (1L << (VAR_SAMP - 137)) | (1L << (VAR_POP - 137)) | (1L << (VARYING - 137)) | (1L << (WEEK - 137)) | (1L << (WRAPPER - 137)) | (1L << (YEAR - 137)) | (1L << (ZONE - 137)) | (1L << (BOOLEAN - 137)) | (1L << (BOOL - 137)) | (1L << (BIT - 137)) | (1L << (VARBIT - 137)) | (1L << (INT1 - 137)) | (1L << (INT2 - 137)) | (1L << (INT4 - 137)) | (1L << (INT8 - 137)) | (1L << (TINYINT - 137)) | (1L << (SMALLINT - 137)) | (1L << (INT - 137)) | (1L << (INTEGER - 137)))) != 0) || ((((_la - 201)) & ~0x3f) == 0 && ((1L << (_la - 201)) & ((1L << (BIGINT - 201)) | (1L << (FLOAT4 - 201)) | (1L << (FLOAT8 - 201)) | (1L << (REAL - 201)) | (1L << (FLOAT - 201)) | (1L << (DOUBLE - 201)) | (1L << (NUMERIC - 201)) | (1L << (DECIMAL - 201)) | (1L << (CHAR - 201)) | (1L << (VARCHAR - 201)) | (1L << (NCHAR - 201)) | (1L << (NVARCHAR - 201)) | (1L << (DATE - 201)) | (1L << (TIME - 201)) | (1L << (TIMETZ - 201)) | (1L << (TIMESTAMP - 201)) | (1L << (TIMESTAMPTZ - 201)) | (1L << (TEXT - 201)) | (1L << (VARBINARY - 201)) | (1L << (BLOB - 201)) | (1L << (BYTEA - 201)) | (1L << (INET4 - 201)) | (1L << (LEFT_PAREN - 201)) | (1L << (PLUS - 201)) | (1L << (MINUS - 201)) | (1L << (NUMBER - 201)) | (1L << (REAL_NUMBER - 201)) | (1L << (Identifier - 201)) | (1L << (Character_String_Literal - 201)))) != 0)) {
				{
				setState(2255); sql_argument_list();
				}
			}

			setState(2258); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 400, RULE_function_names_for_reserved_words);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2260);
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
		enterRule(_localctx, 402, RULE_function_name);
		try {
			setState(2264);
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
				setState(2262); identifier();
				}
				break;
			case LEFT:
			case RIGHT:
				enterOuterAlt(_localctx, 2);
				{
				setState(2263); function_names_for_reserved_words();
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
		enterRule(_localctx, 404, RULE_sql_argument_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2266); value_expression();
			setState(2271);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2267); match(COMMA);
				setState(2268); value_expression();
				}
				}
				setState(2273);
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
		enterRule(_localctx, 406, RULE_orderby_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2274); match(ORDER);
			setState(2275); match(BY);
			setState(2276); sort_specifier_list();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 408, RULE_sort_specifier_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2278); sort_specifier();
			setState(2283);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2279); match(COMMA);
				setState(2280); sort_specifier();
				}
				}
				setState(2285);
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
		enterRule(_localctx, 410, RULE_sort_specifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2286); ((Sort_specifierContext)_localctx).key = row_value_predicand();
			setState(2288);
			_la = _input.LA(1);
			if (_la==ASC || _la==DESC) {
				{
				setState(2287); ((Sort_specifierContext)_localctx).order = order_specification();
				}
			}

			setState(2291);
			_la = _input.LA(1);
			if (_la==NULL) {
				{
				setState(2290); ((Sort_specifierContext)_localctx).null_order = null_ordering();
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
		enterRule(_localctx, 412, RULE_order_specification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2293);
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
		enterRule(_localctx, 414, RULE_limit_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2295); match(LIMIT);
			setState(2296); ((Limit_clauseContext)_localctx).e = numeric_value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 416, RULE_null_ordering);
		try {
			setState(2302);
			switch ( getInterpreter().adaptivePredict(_input,312,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2298); match(NULL);
				setState(2299); match(FIRST);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2300); match(NULL);
				setState(2301); match(LAST);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 418, RULE_insert_statement);
		int _la;
		try {
			setState(2333);
			switch ( getInterpreter().adaptivePredict(_input,318,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2304); match(INSERT);
				setState(2306);
				_la = _input.LA(1);
				if (_la==OVERWRITE) {
					{
					setState(2305); match(OVERWRITE);
					}
				}

				setState(2308); match(INTO);
				setState(2309); table_name();
				setState(2314);
				switch ( getInterpreter().adaptivePredict(_input,314,_ctx) ) {
				case 1:
					{
					setState(2310); match(LEFT_PAREN);
					setState(2311); column_name_list();
					setState(2312); match(RIGHT_PAREN);
					}
					break;
				}
				setState(2316); query_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2318); match(INSERT);
				setState(2320);
				_la = _input.LA(1);
				if (_la==OVERWRITE) {
					{
					setState(2319); match(OVERWRITE);
					}
				}

				setState(2322); match(INTO);
				setState(2323); match(LOCATION);
				setState(2324); ((Insert_statementContext)_localctx).path = match(Character_String_Literal);
				setState(2330);
				_la = _input.LA(1);
				if (_la==USING) {
					{
					setState(2325); match(USING);
					setState(2326); ((Insert_statementContext)_localctx).file_type = identifier();
					setState(2328);
					_la = _input.LA(1);
					if (_la==WITH) {
						{
						setState(2327); param_clause();
						}
					}

					}
				}

				setState(2332); query_expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\u0106\u0922\4\2\t"+
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
		"\4\u00d2\t\u00d2\4\u00d3\t\u00d3\3\2\3\2\5\2\u01a9\n\2\6\2\u01ab\n\2\r"+
		"\2\16\2\u01ac\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\u01ba\n"+
		"\3\3\4\3\4\3\5\3\5\3\6\3\6\5\6\u01c2\n\6\3\7\3\7\5\7\u01c6\n\7\3\7\3\7"+
		"\3\7\3\7\3\7\5\7\u01cd\n\7\3\7\3\7\3\7\3\7\5\7\u01d3\n\7\3\b\3\b\3\b\3"+
		"\b\3\b\5\b\u01da\n\b\3\b\3\b\5\b\u01de\n\b\3\b\3\b\5\b\u01e2\n\b\3\b\3"+
		"\b\5\b\u01e6\n\b\3\b\3\b\5\b\u01ea\n\b\3\t\3\t\5\t\u01ee\n\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\5\t\u01f8\n\t\3\t\5\t\u01fb\n\t\6\t\u01fd\n\t\r"+
		"\t\16\t\u01fe\3\t\3\t\5\t\u0203\n\t\3\t\3\t\3\t\3\t\3\t\5\t\u020a\n\t"+
		"\3\t\5\t\u020d\n\t\6\t\u020f\n\t\r\t\16\t\u0210\5\t\u0213\n\t\3\n\3\n"+
		"\5\n\u0217\n\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u021f\n\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\5\n\u0228\n\n\6\n\u022a\n\n\r\n\16\n\u022b\5\n\u022e\n\n\5"+
		"\n\u0230\n\n\3\n\3\n\3\n\3\n\5\n\u0236\n\n\3\n\3\n\3\n\5\n\u023b\n\n\3"+
		"\n\3\n\3\n\3\n\5\n\u0241\n\n\3\n\3\n\5\n\u0245\n\n\3\n\3\n\5\n\u0249\n"+
		"\n\3\n\3\n\5\n\u024d\n\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u0255\n\n\5\n\u0257"+
		"\n\n\3\n\3\n\3\13\3\13\3\13\3\13\5\13\u025f\n\13\3\13\3\13\3\13\5\13\u0264"+
		"\n\13\5\13\u0266\n\13\3\13\3\13\3\13\5\13\u026b\n\13\3\13\3\13\5\13\u026f"+
		"\n\13\3\13\3\13\5\13\u0273\n\13\3\13\5\13\u0276\n\13\6\13\u0278\n\13\r"+
		"\13\16\13\u0279\3\13\5\13\u027d\n\13\3\13\3\13\3\13\3\13\5\13\u0283\n"+
		"\13\3\13\3\13\5\13\u0287\n\13\6\13\u0289\n\13\r\13\16\13\u028a\3\13\3"+
		"\13\5\13\u028f\n\13\5\13\u0291\n\13\3\13\3\13\3\13\3\13\5\13\u0297\n\13"+
		"\6\13\u0299\n\13\r\13\16\13\u029a\3\13\3\13\5\13\u029f\n\13\3\13\3\13"+
		"\5\13\u02a3\n\13\3\13\5\13\u02a6\n\13\6\13\u02a8\n\13\r\13\16\13\u02a9"+
		"\3\13\5\13\u02ad\n\13\5\13\u02af\n\13\3\f\3\f\6\f\u02b3\n\f\r\f\16\f\u02b4"+
		"\3\f\3\f\5\f\u02b9\n\f\5\f\u02bb\n\f\3\f\3\f\5\f\u02bf\n\f\3\f\3\f\5\f"+
		"\u02c3\n\f\6\f\u02c5\n\f\r\f\16\f\u02c6\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u02cf"+
		"\n\f\6\f\u02d1\n\f\r\f\16\f\u02d2\5\f\u02d5\n\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\5\f\u02dd\n\f\6\f\u02df\n\f\r\f\16\f\u02e0\6\f\u02e3\n\f\r\f\16\f\u02e4"+
		"\3\f\3\f\5\f\u02e9\n\f\3\f\3\f\5\f\u02ed\n\f\6\f\u02ef\n\f\r\f\16\f\u02f0"+
		"\5\f\u02f3\n\f\3\f\3\f\5\f\u02f7\n\f\3\f\3\f\5\f\u02fb\n\f\6\f\u02fd\n"+
		"\f\r\f\16\f\u02fe\3\f\3\f\3\f\3\f\3\f\5\f\u0306\n\f\6\f\u0308\n\f\r\f"+
		"\16\f\u0309\3\f\3\f\5\f\u030e\n\f\5\f\u0310\n\f\3\f\3\f\3\f\3\f\5\f\u0316"+
		"\n\f\6\f\u0318\n\f\r\f\16\f\u0319\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u0322\n"+
		"\f\6\f\u0324\n\f\r\f\16\f\u0325\5\f\u0328\n\f\3\f\3\f\3\f\3\f\3\f\5\f"+
		"\u032f\n\f\6\f\u0331\n\f\r\f\16\f\u0332\3\f\3\f\5\f\u0337\n\f\5\f\u0339"+
		"\n\f\3\f\3\f\3\f\3\f\5\f\u033f\n\f\6\f\u0341\n\f\r\f\16\f\u0342\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\5\f\u034b\n\f\5\f\u034d\n\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\5\f\u0355\n\f\6\f\u0357\n\f\r\f\16\f\u0358\3\f\3\f\3\f\3\f\3\f\3\f\5"+
		"\f\u0361\n\f\5\f\u0363\n\f\3\f\3\f\3\f\3\f\3\f\5\f\u036a\n\f\6\f\u036c"+
		"\n\f\r\f\16\f\u036d\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u0376\n\f\5\f\u0378\n"+
		"\f\3\f\3\f\3\f\5\f\u037d\n\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u0385\n\f\5\f"+
		"\u0387\n\f\3\f\3\f\3\f\3\f\5\f\u038d\n\f\6\f\u038f\n\f\r\f\16\f\u0390"+
		"\3\f\3\f\3\f\3\f\3\f\5\f\u0398\n\f\6\f\u039a\n\f\r\f\16\f\u039b\3\f\3"+
		"\f\5\f\u03a0\n\f\5\f\u03a2\n\f\3\f\3\f\3\f\3\f\3\f\5\f\u03a9\n\f\6\f\u03ab"+
		"\n\f\r\f\16\f\u03ac\3\f\3\f\3\f\3\f\3\f\5\f\u03b4\n\f\6\f\u03b6\n\f\r"+
		"\f\16\f\u03b7\3\f\3\f\5\f\u03bc\n\f\5\f\u03be\n\f\3\f\3\f\3\f\3\f\5\f"+
		"\u03c4\n\f\6\f\u03c6\n\f\r\f\16\f\u03c7\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u03d0"+
		"\n\f\5\f\u03d2\n\f\3\f\3\f\3\f\3\f\5\f\u03d8\n\f\6\f\u03da\n\f\r\f\16"+
		"\f\u03db\3\f\3\f\3\f\3\f\5\f\u03e2\n\f\6\f\u03e4\n\f\r\f\16\f\u03e5\3"+
		"\f\3\f\3\f\5\f\u03eb\n\f\6\f\u03ed\n\f\r\f\16\f\u03ee\3\f\3\f\3\f\5\f"+
		"\u03f4\n\f\5\f\u03f6\n\f\3\r\3\r\5\r\u03fa\n\r\3\r\3\r\5\r\u03fe\n\r\3"+
		"\r\5\r\u0401\n\r\6\r\u0403\n\r\r\r\16\r\u0404\3\r\3\r\3\r\5\r\u040a\n"+
		"\r\3\16\3\16\3\17\3\17\3\17\3\17\5\17\u0412\n\17\3\17\5\17\u0415\n\17"+
		"\3\17\3\17\5\17\u0419\n\17\7\17\u041b\n\17\f\17\16\17\u041e\13\17\3\17"+
		"\3\17\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u0428\n\20\6\20\u042a\n\20\r"+
		"\20\16\20\u042b\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u0436\n\21"+
		"\3\21\5\21\u0439\n\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21"+
		"\u0444\n\21\3\21\5\21\u0447\n\21\3\21\5\21\u044a\n\21\3\21\3\21\5\21\u044e"+
		"\n\21\3\21\3\21\3\21\3\21\3\21\5\21\u0455\n\21\3\21\5\21\u0458\n\21\3"+
		"\21\5\21\u045b\n\21\3\21\3\21\3\21\5\21\u0460\n\21\3\22\3\22\3\22\3\22"+
		"\7\22\u0466\n\22\f\22\16\22\u0469\13\22\3\22\3\22\3\23\3\23\3\23\3\24"+
		"\3\24\3\25\3\25\3\25\3\25\3\25\7\25\u0477\n\25\f\25\16\25\u047a\13\25"+
		"\3\25\3\25\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31"+
		"\3\32\3\32\3\32\3\32\5\32\u048e\n\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\34\3\34\3\34\7\34\u049d\n\34\f\34\16\34\u04a0\13\34"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\5\35\u04ac\n\35\3\35"+
		"\3\35\5\35\u04b0\n\35\5\35\u04b2\n\35\3\36\3\36\3\36\3\36\3\36\3\36\3"+
		"\36\3\36\3\36\3\36\3\36\5\36\u04bf\n\36\3\37\3\37\3\37\7\37\u04c4\n\37"+
		"\f\37\16\37\u04c7\13\37\3 \3 \3 \3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\""+
		"\3\"\3\"\3\"\3#\3#\3#\7#\u04dc\n#\f#\16#\u04df\13#\3$\3$\3$\3$\5$\u04e5"+
		"\n$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3&\3&\3\'\3\'\3\'\3\'\5\'\u04f6\n\'\3("+
		"\3(\5(\u04fa\n(\3)\3)\3*\3*\5*\u0500\n*\3+\3+\3+\5+\u0505\n+\3,\3,\3,"+
		"\5,\u050a\n,\3-\3-\3-\3.\3.\3.\3/\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62"+
		"\3\62\3\62\3\62\3\62\3\62\3\62\3\62\5\62\u0522\n\62\3\63\3\63\3\64\3\64"+
		"\5\64\u0528\n\64\3\64\3\64\5\64\u052c\n\64\3\64\3\64\3\64\5\64\u0531\n"+
		"\64\3\64\3\64\3\64\5\64\u0536\n\64\3\64\3\64\5\64\u053a\n\64\3\64\5\64"+
		"\u053d\n\64\3\65\3\65\3\65\3\65\3\66\3\66\3\66\5\66\u0546\n\66\3\66\3"+
		"\66\3\66\5\66\u054b\n\66\3\66\3\66\5\66\u054f\n\66\3\66\3\66\3\66\3\66"+
		"\5\66\u0555\n\66\3\66\3\66\3\66\3\66\5\66\u055b\n\66\3\66\3\66\3\66\5"+
		"\66\u0560\n\66\3\66\3\66\5\66\u0564\n\66\5\66\u0566\n\66\3\67\3\67\5\67"+
		"\u056a\n\67\3\67\3\67\5\67\u056e\n\67\5\67\u0570\n\67\38\38\58\u0574\n"+
		"8\39\39\59\u0578\n9\39\39\59\u057c\n9\39\39\59\u0580\n9\39\39\39\39\3"+
		"9\39\39\39\39\59\u058b\n9\3:\3:\5:\u058f\n:\3:\3:\3:\3:\3:\3:\5:\u0597"+
		"\n:\3;\3;\3;\3;\3;\3;\3;\3;\5;\u05a1\n;\3<\3<\3=\3=\3=\3=\3=\3=\3=\3="+
		"\3=\3=\3=\3=\3=\5=\u05b2\n=\3>\3>\5>\u05b6\n>\3>\3>\5>\u05ba\n>\3>\3>"+
		"\3>\5>\u05bf\n>\5>\u05c1\n>\3?\3?\5?\u05c5\n?\3?\3?\3?\5?\u05ca\n?\3?"+
		"\3?\5?\u05ce\n?\5?\u05d0\n?\3@\3@\5@\u05d4\n@\3A\3A\3A\3A\3B\3B\3B\3B"+
		"\3B\3B\3B\5B\u05e1\nB\3C\3C\3D\3D\3E\5E\u05e8\nE\3E\3E\3F\3F\3G\3G\3G"+
		"\3G\3G\3G\5G\u05f4\nG\5G\u05f6\nG\3H\3H\3H\5H\u05fb\nH\3H\3H\3H\3I\3I"+
		"\3J\3J\3J\3J\3J\3J\3K\3K\3K\3K\3K\3L\3L\3M\3M\3M\3M\3M\3M\3M\3M\3M\3M"+
		"\3M\3M\6M\u061b\nM\rM\16M\u061c\3M\3M\5M\u0621\nM\3N\3N\5N\u0625\nN\3"+
		"O\3O\3O\6O\u062a\nO\rO\16O\u062b\3O\5O\u062f\nO\3O\3O\3P\3P\6P\u0635\n"+
		"P\rP\16P\u0636\3P\5P\u063a\nP\3P\3P\3Q\3Q\3Q\3Q\3Q\3R\3R\3R\3R\3R\3S\3"+
		"S\3S\3T\3T\5T\u064d\nT\3U\3U\3U\3U\3U\3U\3U\3V\3V\3W\3W\3X\3X\3X\5X\u065d"+
		"\nX\3Y\3Y\3Y\5Y\u0662\nY\3Z\3Z\3Z\7Z\u0667\nZ\fZ\16Z\u066a\13Z\3[\3[\3"+
		"[\7[\u066f\n[\f[\16[\u0672\13[\3\\\5\\\u0675\n\\\3\\\3\\\3]\3]\3]\3]\7"+
		"]\u067d\n]\f]\16]\u0680\13]\3]\3]\3^\3^\3^\7^\u0687\n^\f^\16^\u068a\13"+
		"^\3^\5^\u068d\n^\3_\3_\3`\3`\3a\3a\3a\3a\3a\3a\3a\3b\3b\3b\5b\u069d\n"+
		"b\3c\3c\3d\3d\5d\u06a3\nd\3e\3e\3f\3f\3f\7f\u06aa\nf\ff\16f\u06ad\13f"+
		"\3g\3g\3h\3h\5h\u06b3\nh\3i\3i\3j\3j\3j\3j\3j\3k\5k\u06bd\nk\3k\5k\u06c0"+
		"\nk\3k\5k\u06c3\nk\3k\3k\3k\3k\3k\5k\u06ca\nk\3l\3l\3m\3m\3n\3n\3n\7n"+
		"\u06d3\nn\fn\16n\u06d6\13n\3o\3o\3o\7o\u06db\no\fo\16o\u06de\13o\3p\3"+
		"p\3p\5p\u06e3\np\3q\3q\5q\u06e7\nq\3r\3r\5r\u06eb\nr\3r\3r\3s\3s\3t\3"+
		"t\5t\u06f3\nt\3u\3u\5u\u06f7\nu\3v\3v\3v\3v\3w\3w\5w\u06ff\nw\3x\3x\3"+
		"y\3y\3z\3z\5z\u0707\nz\3{\3{\5{\u070b\n{\3|\3|\5|\u070f\n|\3|\5|\u0712"+
		"\n|\3|\5|\u0715\n|\3|\5|\u0718\n|\3|\5|\u071b\n|\3}\3}\3}\3~\3~\3~\7~"+
		"\u0723\n~\f~\16~\u0726\13~\3\177\3\177\5\177\u072a\n\177\3\u0080\3\u0080"+
		"\6\u0080\u072e\n\u0080\r\u0080\16\u0080\u072f\3\u0081\3\u0081\3\u0081"+
		"\3\u0081\5\u0081\u0736\n\u0081\3\u0081\3\u0081\3\u0081\3\u0081\3\u0081"+
		"\3\u0081\5\u0081\u073e\n\u0081\3\u0081\3\u0081\3\u0081\3\u0081\3\u0081"+
		"\5\u0081\u0745\n\u0081\3\u0082\3\u0082\3\u0082\3\u0082\3\u0083\5\u0083"+
		"\u074c\n\u0083\3\u0083\3\u0083\3\u0083\3\u0083\3\u0084\3\u0084\5\u0084"+
		"\u0754\n\u0084\3\u0084\3\u0084\3\u0084\3\u0085\3\u0085\3\u0085\3\u0085"+
		"\3\u0086\3\u0086\5\u0086\u075f\n\u0086\3\u0087\3\u0087\5\u0087\u0763\n"+
		"\u0087\3\u0088\3\u0088\3\u0089\3\u0089\5\u0089\u0769\n\u0089\3\u008a\3"+
		"\u008a\3\u008a\3\u008b\3\u008b\3\u008b\3\u008b\3\u008b\3\u008c\3\u008c"+
		"\5\u008c\u0775\n\u008c\3\u008c\5\u008c\u0778\n\u008c\3\u008c\3\u008c\3"+
		"\u008c\3\u008c\5\u008c\u077e\n\u008c\3\u008c\3\u008c\5\u008c\u0782\n\u008c"+
		"\3\u008c\3\u008c\3\u008c\3\u008c\3\u008c\5\u008c\u0789\n\u008c\5\u008c"+
		"\u078b\n\u008c\3\u008d\3\u008d\3\u008d\7\u008d\u0790\n\u008d\f\u008d\16"+
		"\u008d\u0793\13\u008d\3\u008e\3\u008e\3\u008f\3\u008f\3\u008f\3\u0090"+
		"\3\u0090\3\u0091\3\u0091\3\u0091\3\u0091\3\u0092\3\u0092\3\u0092\7\u0092"+
		"\u07a3\n\u0092\f\u0092\16\u0092\u07a6\13\u0092\3\u0093\3\u0093\3\u0093"+
		"\3\u0093\5\u0093\u07ac\n\u0093\3\u0094\3\u0094\3\u0094\3\u0094\3\u0094"+
		"\5\u0094\u07b3\n\u0094\3\u0095\3\u0095\3\u0095\7\u0095\u07b8\n\u0095\f"+
		"\u0095\16\u0095\u07bb\13\u0095\3\u0096\3\u0096\3\u0096\3\u0096\3\u0096"+
		"\3\u0097\3\u0097\3\u0097\3\u0097\3\u0097\3\u0098\3\u0098\3\u0098\3\u0099"+
		"\3\u0099\3\u0099\3\u009a\3\u009a\3\u009a\7\u009a\u07d0\n\u009a\f\u009a"+
		"\16\u009a\u07d3\13\u009a\3\u009b\3\u009b\3\u009c\3\u009c\5\u009c\u07d9"+
		"\n\u009c\3\u009d\3\u009d\3\u009d\3\u009d\5\u009d\u07df\n\u009d\3\u009d"+
		"\3\u009d\5\u009d\u07e3\n\u009d\3\u009d\3\u009d\5\u009d\u07e7\n\u009d\3"+
		"\u009d\7\u009d\u07ea\n\u009d\f\u009d\16\u009d\u07ed\13\u009d\3\u009e\3"+
		"\u009e\5\u009e\u07f1\n\u009e\3\u009f\3\u009f\3\u009f\3\u009f\5\u009f\u07f7"+
		"\n\u009f\3\u009f\3\u009f\5\u009f\u07fb\n\u009f\3\u009f\3\u009f\5\u009f"+
		"\u07ff\n\u009f\3\u009f\7\u009f\u0802\n\u009f\f\u009f\16\u009f\u0805\13"+
		"\u009f\3\u00a0\3\u00a0\5\u00a0\u0809\n\u00a0\3\u00a1\3\u00a1\3\u00a1\3"+
		"\u00a1\3\u00a1\5\u00a1\u0810\n\u00a1\3\u00a2\3\u00a2\5\u00a2\u0814\n\u00a2"+
		"\3\u00a3\3\u00a3\3\u00a3\3\u00a4\3\u00a4\5\u00a4\u081b\n\u00a4\3\u00a5"+
		"\3\u00a5\3\u00a5\3\u00a5\3\u00a5\5\u00a5\u0822\n\u00a5\5\u00a5\u0824\n"+
		"\u00a5\3\u00a6\3\u00a6\5\u00a6\u0828\n\u00a6\3\u00a6\3\u00a6\5\u00a6\u082c"+
		"\n\u00a6\3\u00a7\3\u00a7\3\u00a7\7\u00a7\u0831\n\u00a7\f\u00a7\16\u00a7"+
		"\u0834\13\u00a7\3\u00a8\3\u00a8\5\u00a8\u0838\n\u00a8\3\u00a9\3\u00a9"+
		"\5\u00a9\u083c\n\u00a9\3\u00aa\3\u00aa\5\u00aa\u0840\n\u00aa\3\u00aa\3"+
		"\u00aa\3\u00ab\3\u00ab\3\u00ac\3\u00ac\3\u00ac\5\u00ac\u0849\n\u00ac\3"+
		"\u00ac\3\u00ac\3\u00ad\5\u00ad\u084e\n\u00ad\3\u00ad\3\u00ad\3\u00ae\3"+
		"\u00ae\3\u00ae\7\u00ae\u0855\n\u00ae\f\u00ae\16\u00ae\u0858\13\u00ae\3"+
		"\u00af\3\u00af\3\u00b0\3\u00b0\3\u00b1\3\u00b1\3\u00b2\3\u00b2\3\u00b2"+
		"\3\u00b2\3\u00b3\3\u00b3\3\u00b3\3\u00b3\3\u00b3\3\u00b3\5\u00b3\u086a"+
		"\n\u00b3\3\u00b4\3\u00b4\3\u00b4\3\u00b4\3\u00b5\3\u00b5\3\u00b6\3\u00b6"+
		"\3\u00b6\3\u00b7\5\u00b7\u0876\n\u00b7\3\u00b7\3\u00b7\5\u00b7\u087a\n"+
		"\u00b7\3\u00b7\3\u00b7\3\u00b7\3\u00b7\3\u00b8\3\u00b8\5\u00b8\u0882\n"+
		"\u00b8\3\u00b8\3\u00b8\3\u00b8\3\u00b9\3\u00b9\3\u00b9\3\u00b9\3\u00b9"+
		"\5\u00b9\u088c\n\u00b9\3\u00ba\3\u00ba\3\u00ba\7\u00ba\u0891\n\u00ba\f"+
		"\u00ba\16\u00ba\u0894\13\u00ba\3\u00bb\3\u00bb\3\u00bb\3\u00bb\3\u00bc"+
		"\5\u00bc\u089b\n\u00bc\3\u00bc\3\u00bc\5\u00bc\u089f\n\u00bc\3\u00bd\3"+
		"\u00bd\3\u00bd\3\u00bd\3\u00bd\3\u00bd\5\u00bd\u08a7\n\u00bd\3\u00be\3"+
		"\u00be\3\u00bf\3\u00bf\3\u00bf\5\u00bf\u08ae\n\u00bf\3\u00bf\3\u00bf\3"+
		"\u00c0\3\u00c0\3\u00c0\3\u00c0\3\u00c0\3\u00c1\3\u00c1\5\u00c1\u08b9\n"+
		"\u00c1\3\u00c2\3\u00c2\3\u00c3\3\u00c3\3\u00c4\5\u00c4\u08c0\n\u00c4\3"+
		"\u00c4\3\u00c4\3\u00c4\3\u00c5\3\u00c5\3\u00c5\3\u00c6\3\u00c6\5\u00c6"+
		"\u08ca\n\u00c6\3\u00c7\3\u00c7\3\u00c8\3\u00c8\3\u00c9\3\u00c9\3\u00c9"+
		"\5\u00c9\u08d3\n\u00c9\3\u00c9\3\u00c9\3\u00ca\3\u00ca\3\u00cb\3\u00cb"+
		"\5\u00cb\u08db\n\u00cb\3\u00cc\3\u00cc\3\u00cc\7\u00cc\u08e0\n\u00cc\f"+
		"\u00cc\16\u00cc\u08e3\13\u00cc\3\u00cd\3\u00cd\3\u00cd\3\u00cd\3\u00ce"+
		"\3\u00ce\3\u00ce\7\u00ce\u08ec\n\u00ce\f\u00ce\16\u00ce\u08ef\13\u00ce"+
		"\3\u00cf\3\u00cf\5\u00cf\u08f3\n\u00cf\3\u00cf\5\u00cf\u08f6\n\u00cf\3"+
		"\u00d0\3\u00d0\3\u00d1\3\u00d1\3\u00d1\3\u00d2\3\u00d2\3\u00d2\3\u00d2"+
		"\5\u00d2\u0901\n\u00d2\3\u00d3\3\u00d3\5\u00d3\u0905\n\u00d3\3\u00d3\3"+
		"\u00d3\3\u00d3\3\u00d3\3\u00d3\3\u00d3\5\u00d3\u090d\n\u00d3\3\u00d3\3"+
		"\u00d3\3\u00d3\3\u00d3\5\u00d3\u0913\n\u00d3\3\u00d3\3\u00d3\3\u00d3\3"+
		"\u00d3\3\u00d3\3\u00d3\5\u00d3\u091b\n\u00d3\5\u00d3\u091d\n\u00d3\3\u00d3"+
		"\5\u00d3\u0920\n\u00d3\3\u00d3\2\2\u00d4\2\4\6\b\n\f\16\20\22\24\26\30"+
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
		"\u01a2\u01a4\2 \4\2::PP\4\2\u00b4\u00b4\u00e8\u00e8\4\2\r\rII\4\2\21\21"+
		"__\t\2\27\27GGOOYY[[^^\u0084\u0084\6\2GGOO^^\u0084\u0084\4\2OO^_\5\2\17"+
		"\17\21\21UV\4\2OO^^\6\2--\62\62AAaa\7\2e\u0081\u0083\u00ad\u00af\u00b9"+
		"\u00bb\u00dc\u00de\u00e1\5\2  ZZ\u00b5\u00b5\3\2\u00bf\u00c0\3\2\u00fe"+
		"\u00ff\17\2\7\7QQffkknnxx\177\177\u0085\u0085\u008e\u008e\u0093\u0093"+
		"\u00a9\u00aa\u00ac\u00ac\u00b7\u00b8\3\2\u00f4\u00f5\3\2\u00f6\u00f8\3"+
		"\2\u00b0\u00b2\5\2\13\13\66\66XX\5\2##\67\67KK\4\2\35\35\\\\\4\2\5\5\31"+
		"\31\4\2\u00e8\u00e8\u00ed\u00f1\4\2\b\bSS\3\2\u00e2\u00e5\4\2\7\7QQ\6"+
		"\2qq\u0082\u0082\u0094\u0095\u00bd\u00bd\t\2iisuww\u0086\u0087\u0090\u0092"+
		"\u00a0\u00a0\u00bb\u00bb\4\2\67\67KK\4\2\t\t\30\30\u09e3\2\u01aa\3\2\2"+
		"\2\4\u01b9\3\2\2\2\6\u01bb\3\2\2\2\b\u01bd\3\2\2\2\n\u01c1\3\2\2\2\f\u01c3"+
		"\3\2\2\2\16\u01d4\3\2\2\2\20\u0212\3\2\2\2\22\u0214\3\2\2\2\24\u02ae\3"+
		"\2\2\2\26\u03f5\3\2\2\2\30\u03f7\3\2\2\2\32\u040b\3\2\2\2\34\u040d\3\2"+
		"\2\2\36\u0421\3\2\2\2 \u045f\3\2\2\2\"\u0461\3\2\2\2$\u046c\3\2\2\2&\u046f"+
		"\3\2\2\2(\u0471\3\2\2\2*\u047d\3\2\2\2,\u0481\3\2\2\2.\u0484\3\2\2\2\60"+
		"\u0487\3\2\2\2\62\u048d\3\2\2\2\64\u048f\3\2\2\2\66\u0499\3\2\2\28\u04a1"+
		"\3\2\2\2:\u04b3\3\2\2\2<\u04c0\3\2\2\2>\u04c8\3\2\2\2@\u04cb\3\2\2\2B"+
		"\u04ce\3\2\2\2D\u04d8\3\2\2\2F\u04e0\3\2\2\2H\u04ea\3\2\2\2J\u04ef\3\2"+
		"\2\2L\u04f1\3\2\2\2N\u04f9\3\2\2\2P\u04fb\3\2\2\2R\u04ff\3\2\2\2T\u0504"+
		"\3\2\2\2V\u0509\3\2\2\2X\u050b\3\2\2\2Z\u050e\3\2\2\2\\\u0511\3\2\2\2"+
		"^\u0514\3\2\2\2`\u0516\3\2\2\2b\u0521\3\2\2\2d\u0523\3\2\2\2f\u053c\3"+
		"\2\2\2h\u053e\3\2\2\2j\u0565\3\2\2\2l\u056f\3\2\2\2n\u0573\3\2\2\2p\u058a"+
		"\3\2\2\2r\u0596\3\2\2\2t\u05a0\3\2\2\2v\u05a2\3\2\2\2x\u05b1\3\2\2\2z"+
		"\u05c0\3\2\2\2|\u05cf\3\2\2\2~\u05d3\3\2\2\2\u0080\u05d5\3\2\2\2\u0082"+
		"\u05e0\3\2\2\2\u0084\u05e2\3\2\2\2\u0086\u05e4\3\2\2\2\u0088\u05e7\3\2"+
		"\2\2\u008a\u05eb\3\2\2\2\u008c\u05f5\3\2\2\2\u008e\u05f7\3\2\2\2\u0090"+
		"\u05ff\3\2\2\2\u0092\u0601\3\2\2\2\u0094\u0607\3\2\2\2\u0096\u060c\3\2"+
		"\2\2\u0098\u0620\3\2\2\2\u009a\u0624\3\2\2\2\u009c\u0626\3\2\2\2\u009e"+
		"\u0632\3\2\2\2\u00a0\u063d\3\2\2\2\u00a2\u0642\3\2\2\2\u00a4\u0647\3\2"+
		"\2\2\u00a6\u064c\3\2\2\2\u00a8\u064e\3\2\2\2\u00aa\u0655\3\2\2\2\u00ac"+
		"\u0657\3\2\2\2\u00ae\u065c\3\2\2\2\u00b0\u0661\3\2\2\2\u00b2\u0663\3\2"+
		"\2\2\u00b4\u066b\3\2\2\2\u00b6\u0674\3\2\2\2\u00b8\u0678\3\2\2\2\u00ba"+
		"\u068c\3\2\2\2\u00bc\u068e\3\2\2\2\u00be\u0690\3\2\2\2\u00c0\u0692\3\2"+
		"\2\2\u00c2\u069c\3\2\2\2\u00c4\u069e\3\2\2\2\u00c6\u06a2\3\2\2\2\u00c8"+
		"\u06a4\3\2\2\2\u00ca\u06a6\3\2\2\2\u00cc\u06ae\3\2\2\2\u00ce\u06b2\3\2"+
		"\2\2\u00d0\u06b4\3\2\2\2\u00d2\u06b6\3\2\2\2\u00d4\u06c9\3\2\2\2\u00d6"+
		"\u06cb\3\2\2\2\u00d8\u06cd\3\2\2\2\u00da\u06cf\3\2\2\2\u00dc\u06d7\3\2"+
		"\2\2\u00de\u06e2\3\2\2\2\u00e0\u06e4\3\2\2\2\u00e2\u06e8\3\2\2\2\u00e4"+
		"\u06ee\3\2\2\2\u00e6\u06f2\3\2\2\2\u00e8\u06f6\3\2\2\2\u00ea\u06f8\3\2"+
		"\2\2\u00ec\u06fe\3\2\2\2\u00ee\u0700\3\2\2\2\u00f0\u0702\3\2\2\2\u00f2"+
		"\u0706\3\2\2\2\u00f4\u070a\3\2\2\2\u00f6\u070c\3\2\2\2\u00f8\u071c\3\2"+
		"\2\2\u00fa\u071f\3\2\2\2\u00fc\u0729\3\2\2\2\u00fe\u072b\3\2\2\2\u0100"+
		"\u0744\3\2\2\2\u0102\u0746\3\2\2\2\u0104\u074b\3\2\2\2\u0106\u0751\3\2"+
		"\2\2\u0108\u0758\3\2\2\2\u010a\u075e\3\2\2\2\u010c\u0760\3\2\2\2\u010e"+
		"\u0764\3\2\2\2\u0110\u0768\3\2\2\2\u0112\u076a\3\2\2\2\u0114\u076d\3\2"+
		"\2\2\u0116\u078a\3\2\2\2\u0118\u078c\3\2\2\2\u011a\u0794\3\2\2\2\u011c"+
		"\u0796\3\2\2\2\u011e\u0799\3\2\2\2\u0120\u079b\3\2\2\2\u0122\u079f\3\2"+
		"\2\2\u0124\u07ab\3\2\2\2\u0126\u07b2\3\2\2\2\u0128\u07b4\3\2\2\2\u012a"+
		"\u07bc\3\2\2\2\u012c\u07c1\3\2\2\2\u012e\u07c6\3\2\2\2\u0130\u07c9\3\2"+
		"\2\2\u0132\u07cc\3\2\2\2\u0134\u07d4\3\2\2\2\u0136\u07d8\3\2\2\2\u0138"+
		"\u07e2\3\2\2\2\u013a\u07f0\3\2\2\2\u013c\u07fa\3\2\2\2\u013e\u0808\3\2"+
		"\2\2\u0140\u080f\3\2\2\2\u0142\u0813\3\2\2\2\u0144\u0815\3\2\2\2\u0146"+
		"\u081a\3\2\2\2\u0148\u081c\3\2\2\2\u014a\u0825\3\2\2\2\u014c\u082d\3\2"+
		"\2\2\u014e\u0837\3\2\2\2\u0150\u0839\3\2\2\2\u0152\u083f\3\2\2\2\u0154"+
		"\u0843\3\2\2\2\u0156\u0848\3\2\2\2\u0158\u084d\3\2\2\2\u015a\u0851\3\2"+
		"\2\2\u015c\u0859\3\2\2\2\u015e\u085b\3\2\2\2\u0160\u085d\3\2\2\2\u0162"+
		"\u085f\3\2\2\2\u0164\u0869\3\2\2\2\u0166\u086b\3\2\2\2\u0168\u086f\3\2"+
		"\2\2\u016a\u0871\3\2\2\2\u016c\u0875\3\2\2\2\u016e\u087f\3\2\2\2\u0170"+
		"\u088b\3\2\2\2\u0172\u088d\3\2\2\2\u0174\u0895\3\2\2\2\u0176\u089e\3\2"+
		"\2\2\u0178\u08a6\3\2\2\2\u017a\u08a8\3\2\2\2\u017c\u08aa\3\2\2\2\u017e"+
		"\u08b1\3\2\2\2\u0180\u08b8\3\2\2\2\u0182\u08ba\3\2\2\2\u0184\u08bc\3\2"+
		"\2\2\u0186\u08bf\3\2\2\2\u0188\u08c4\3\2\2\2\u018a\u08c9\3\2\2\2\u018c"+
		"\u08cb\3\2\2\2\u018e\u08cd\3\2\2\2\u0190\u08cf\3\2\2\2\u0192\u08d6\3\2"+
		"\2\2\u0194\u08da\3\2\2\2\u0196\u08dc\3\2\2\2\u0198\u08e4\3\2\2\2\u019a"+
		"\u08e8\3\2\2\2\u019c\u08f0\3\2\2\2\u019e\u08f7\3\2\2\2\u01a0\u08f9\3\2"+
		"\2\2\u01a2\u0900\3\2\2\2\u01a4\u091f\3\2\2\2\u01a6\u01a8\5\4\3\2\u01a7"+
		"\u01a9\7\u00ea\2\2\u01a8\u01a7\3\2\2\2\u01a8\u01a9\3\2\2\2\u01a9\u01ab"+
		"\3\2\2\2\u01aa\u01a6\3\2\2\2\u01ab\u01ac\3\2\2\2\u01ac\u01aa\3\2\2\2\u01ac"+
		"\u01ad\3\2\2\2\u01ad\u01ae\3\2\2\2\u01ae\u01af\7\2\2\3\u01af\3\3\2\2\2"+
		"\u01b0\u01ba\5\6\4\2\u01b1\u01ba\5\b\5\2\u01b2\u01ba\5\n\6\2\u01b3\u01ba"+
		"\5\f\7\2\u01b4\u01ba\5\16\b\2\u01b5\u01ba\5\20\t\2\u01b6\u01ba\5\22\n"+
		"\2\u01b7\u01ba\5\26\f\2\u01b8\u01ba\5\24\13\2\u01b9\u01b0\3\2\2\2\u01b9"+
		"\u01b1\3\2\2\2\u01b9\u01b2\3\2\2\2\u01b9\u01b3\3\2\2\2\u01b9\u01b4\3\2"+
		"\2\2\u01b9\u01b5\3\2\2\2\u01b9\u01b6\3\2\2\2\u01b9\u01b7\3\2\2\2\u01b9"+
		"\u01b8\3\2\2\2\u01ba\5\3\2\2\2\u01bb\u01bc\5\u0134\u009b\2\u01bc\7\3\2"+
		"\2\2\u01bd\u01be\5\u01a4\u00d3\2\u01be\t\3\2\2\2\u01bf\u01c2\5 \21\2\u01c0"+
		"\u01c2\5L\'\2\u01c1\u01bf\3\2\2\2\u01c1\u01c0\3\2\2\2\u01c2\13\3\2\2\2"+
		"\u01c3\u01c5\7\21\2\2\u01c4\u01c6\7]\2\2\u01c5\u01c4\3\2\2\2\u01c5\u01c6"+
		"\3\2\2\2\u01c6\u01c7\3\2\2\2\u01c7\u01c8\7\u0083\2\2\u01c8\u01c9\5N(\2"+
		"\u01c9\u01ca\7?\2\2\u01ca\u01cc\5\u0148\u00a5\2\u01cb\u01cd\5,\27\2\u01cc"+
		"\u01cb\3\2\2\2\u01cc\u01cd\3\2\2\2\u01cd\u01ce\3\2\2\2\u01ce\u01cf\7\u00f2"+
		"\2\2\u01cf\u01d0\5\u019a\u00ce\2\u01d0\u01d2\7\u00f3\2\2\u01d1\u01d3\5"+
		"(\25\2\u01d2\u01d1\3\2\2\2\u01d2\u01d3\3\2\2\2\u01d3\r\3\2\2\2\u01d4\u01d5"+
		"\7\21\2\2\u01d5\u01d9\7\37\2\2\u01d6\u01d7\7*\2\2\u01d7\u01d8\7<\2\2\u01d8"+
		"\u01da\7y\2\2\u01d9\u01d6\3\2\2\2\u01d9\u01da\3\2\2\2\u01da\u01db\3\2"+
		"\2\2\u01db\u01dd\5N(\2\u01dc\u01de\7d\2\2\u01dd\u01dc\3\2\2\2\u01dd\u01de"+
		"\3\2\2\2\u01de\u01e1\3\2\2\2\u01df\u01e0\7L\2\2\u01e0\u01e2\5N(\2\u01e1"+
		"\u01df\3\2\2\2\u01e1\u01e2\3\2\2\2\u01e2\u01e5\3\2\2\2\u01e3\u01e4\7\u00ba"+
		"\2\2\u01e4\u01e6\5N(\2\u01e5\u01e3\3\2\2\2\u01e5\u01e6\3\2\2\2\u01e6\u01e9"+
		"\3\2\2\2\u01e7\u01e8\7&\2\2\u01e8\u01ea\5N(\2\u01e9\u01e7\3\2\2\2\u01e9"+
		"\u01ea\3\2\2\2\u01ea\17\3\2\2\2\u01eb\u01ed\7\u00a7\2\2\u01ec\u01ee\t"+
		"\2\2\2\u01ed\u01ec\3\2\2\2\u01ed\u01ee\3\2\2\2\u01ee\u01ef\3\2\2\2\u01ef"+
		"\u01f0\5N(\2\u01f0\u01fc\t\3\2\2\u01f1\u01f8\5N(\2\u01f2\u01f3\7\u00fc"+
		"\2\2\u01f3\u01f4\5N(\2\u01f4\u01f5\7\u00fc\2\2\u01f5\u01f8\3\2\2\2\u01f6"+
		"\u01f8\7\24\2\2\u01f7\u01f1\3\2\2\2\u01f7\u01f2\3\2\2\2\u01f7\u01f6\3"+
		"\2\2\2\u01f8\u01fa\3\2\2\2\u01f9\u01fb\7\u00eb\2\2\u01fa\u01f9\3\2\2\2"+
		"\u01fa\u01fb\3\2\2\2\u01fb\u01fd\3\2\2\2\u01fc\u01f7\3\2\2\2\u01fd\u01fe"+
		"\3\2\2\2\u01fe\u01fc\3\2\2\2\u01fe\u01ff\3\2\2\2\u01ff\u0213\3\2\2\2\u0200"+
		"\u0202\7\u00a7\2\2\u0201\u0203\t\2\2\2\u0202\u0201\3\2\2\2\u0202\u0203"+
		"\3\2\2\2\u0203\u0204\3\2\2\2\u0204\u0205\7\u00d8\2\2\u0205\u020e\7\u00be"+
		"\2\2\u0206\u020a\5N(\2\u0207\u020a\7:\2\2\u0208\u020a\7\24\2\2\u0209\u0206"+
		"\3\2\2\2\u0209\u0207\3\2\2\2\u0209\u0208\3\2\2\2\u020a\u020c\3\2\2\2\u020b"+
		"\u020d\7\u00eb\2\2\u020c\u020b\3\2\2\2\u020c\u020d\3\2\2\2\u020d\u020f"+
		"\3\2\2\2\u020e\u0209\3\2\2\2\u020f\u0210\3\2\2\2\u0210\u020e\3\2\2\2\u0210"+
		"\u0211\3\2\2\2\u0211\u0213\3\2\2\2\u0212\u01eb\3\2\2\2\u0212\u0200\3\2"+
		"\2\2\u0213\21\3\2\2\2\u0214\u0216\7\21\2\2\u0215\u0217\7\20\2\2\u0216"+
		"\u0215\3\2\2\2\u0216\u0217\3\2\2\2\u0217\u0218\3\2\2\2\u0218\u0219\7Y"+
		"\2\2\u0219\u021e\5N(\2\u021a\u021f\7\n\2\2\u021b\u021c\7\63\2\2\u021c"+
		"\u021f\7>\2\2\u021d\u021f\7\3\2\2\u021e\u021a\3\2\2\2\u021e\u021b\3\2"+
		"\2\2\u021e\u021d\3\2\2\2\u021f\u022f\3\2\2\2\u0220\u0230\7\u0084\2\2\u0221"+
		"\u0230\7\27\2\2\u0222\u0230\7[\2\2\u0223\u022d\7^\2\2\u0224\u0229\7>\2"+
		"\2\u0225\u0227\5N(\2\u0226\u0228\7\u00eb\2\2\u0227\u0226\3\2\2\2\u0227"+
		"\u0228\3\2\2\2\u0228\u022a\3\2\2\2\u0229\u0225\3\2\2\2\u022a\u022b\3\2"+
		"\2\2\u022b\u0229\3\2\2\2\u022b\u022c\3\2\2\2\u022c\u022e\3\2\2\2\u022d"+
		"\u0224\3\2\2\2\u022d\u022e\3\2\2\2\u022e\u0230\3\2\2\2\u022f\u0220\3\2"+
		"\2\2\u022f\u0221\3\2\2\2\u022f\u0222\3\2\2\2\u022f\u0223\3\2\2\2\u0230"+
		"\u0231\3\2\2\2\u0231\u0232\7?\2\2\u0232\u0235\5\u0148\u00a5\2\u0233\u0234"+
		"\7&\2\2\u0234\u0236\5\u0148\u00a5\2\u0235\u0233\3\2\2\2\u0235\u0236\3"+
		"\2\2\2\u0236\u0240\3\2\2\2\u0237\u0238\7<\2\2\u0238\u0241\7\25\2\2\u0239"+
		"\u023b\7\25\2\2\u023a\u0239\3\2\2\2\u023a\u023b\3\2\2\2\u023b\u023c\3"+
		"\2\2\2\u023c\u023d\7.\2\2\u023d\u0241\7,\2\2\u023e\u023f\7.\2\2\u023f"+
		"\u0241\7\26\2\2\u0240\u0237\3\2\2\2\u0240\u023a\3\2\2\2\u0240\u023e\3"+
		"\2\2\2\u0240\u0241\3\2\2\2\u0241\u0248\3\2\2\2\u0242\u0244\7!\2\2\u0243"+
		"\u0245\7\32\2\2\u0244\u0243\3\2\2\2\u0244\u0245\3\2\2\2\u0245\u0246\3"+
		"\2\2\2\u0246\u0249\7F\2\2\u0247\u0249\7R\2\2\u0248\u0242\3\2\2\2\u0248"+
		"\u0247\3\2\2\2\u0248\u0249\3\2\2\2\u0249\u024c\3\2\2\2\u024a\u024b\7b"+
		"\2\2\u024b\u024d\5\u00d8m\2\u024c\u024a\3\2\2\2\u024c\u024d\3\2\2\2\u024d"+
		"\u024e\3\2\2\2\u024e\u024f\7\36\2\2\u024f\u0250\7E\2\2\u0250\u0251\5N"+
		"(\2\u0251\u0256\7\u00f2\2\2\u0252\u0254\5N(\2\u0253\u0255\7\u00eb\2\2"+
		"\u0254\u0253\3\2\2\2\u0254\u0255\3\2\2\2\u0255\u0257\3\2\2\2\u0256\u0252"+
		"\3\2\2\2\u0256\u0257\3\2\2\2\u0257\u0258\3\2\2\2\u0258\u0259\7\u00f3\2"+
		"\2\u0259\23\3\2\2\2\u025a\u025e\7J\2\2\u025b\u025c\7\'\2\2\u025c\u025d"+
		"\7\u0099\2\2\u025d\u025f\7!\2\2\u025e\u025b\3\2\2\2\u025e\u025f\3\2\2"+
		"\2\u025f\u0265\3\2\2\2\u0260\u0266\7\36\2\2\u0261\u0263\7\5\2\2\u0262"+
		"\u0264\7D\2\2\u0263\u0262\3\2\2\2\u0263\u0264\3\2\2\2\u0264\u0266\3\2"+
		"\2\2\u0265\u0260\3\2\2\2\u0265\u0261\3\2\2\2\u0266\u0267\3\2\2\2\u0267"+
		"\u026a\7?\2\2\u0268\u026b\5\34\17\2\u0269\u026b\5\36\20\2\u026a\u0268"+
		"\3\2\2\2\u026a\u0269\3\2\2\2\u026b\u026c\3\2\2\2\u026c\u0277\7&\2\2\u026d"+
		"\u026f\7(\2\2\u026e\u026d\3\2\2\2\u026e\u026f\3\2\2\2\u026f\u0270\3\2"+
		"\2\2\u0270\u0273\5N(\2\u0271\u0273\7\u009e\2\2\u0272\u026e\3\2\2\2\u0272"+
		"\u0271\3\2\2\2\u0273\u0275\3\2\2\2\u0274\u0276\7\u00eb\2\2\u0275\u0274"+
		"\3\2\2\2\u0275\u0276\3\2\2\2\u0276\u0278\3\2\2\2\u0277\u0272\3\2\2\2\u0278"+
		"\u0279\3\2\2\2\u0279\u0277\3\2\2\2\u0279\u027a\3\2\2\2\u027a\u027c\3\2"+
		"\2\2\u027b\u027d\t\4\2\2\u027c\u027b\3\2\2\2\u027c\u027d\3\2\2\2\u027d"+
		"\u02af\3\2\2\2\u027e\u0282\7J\2\2\u027f\u0280\7\'\2\2\u0280\u0281\7\u0099"+
		"\2\2\u0281\u0283\7!\2\2\u0282\u027f\3\2\2\2\u0282\u0283\3\2\2\2\u0283"+
		"\u0290\3\2\2\2\u0284\u0286\t\5\2\2\u0285\u0287\7\u00eb\2\2\u0286\u0285"+
		"\3\2\2\2\u0286\u0287\3\2\2\2\u0287\u0289\3\2\2\2\u0288\u0284\3\2\2\2\u0289"+
		"\u028a\3\2\2\2\u028a\u0288\3\2\2\2\u028a\u028b\3\2\2\2\u028b\u0291\3\2"+
		"\2\2\u028c\u028e\7\5\2\2\u028d\u028f\7D\2\2\u028e\u028d\3\2\2\2\u028e"+
		"\u028f\3\2\2\2\u028f\u0291\3\2\2\2\u0290\u0288\3\2\2\2\u0290\u028c\3\2"+
		"\2\2\u0291\u0292\3\2\2\2\u0292\u0293\7?\2\2\u0293\u0298\7L\2\2\u0294\u0296"+
		"\5N(\2\u0295\u0297\7\u00eb\2\2\u0296\u0295\3\2\2\2\u0296\u0297\3\2\2\2"+
		"\u0297\u0299\3\2\2\2\u0298\u0294\3\2\2\2\u0299\u029a\3\2\2\2\u029a\u0298"+
		"\3\2\2\2\u029a\u029b\3\2\2\2\u029b\u029c\3\2\2\2\u029c\u02a7\7&\2\2\u029d"+
		"\u029f\7(\2\2\u029e\u029d\3\2\2\2\u029e\u029f\3\2\2\2\u029f\u02a0\3\2"+
		"\2\2\u02a0\u02a3\5N(\2\u02a1\u02a3\7\u009e\2\2\u02a2\u029e\3\2\2\2\u02a2"+
		"\u02a1\3\2\2\2\u02a3\u02a5\3\2\2\2\u02a4\u02a6\7\u00eb\2\2\u02a5\u02a4"+
		"\3\2\2\2\u02a5\u02a6\3\2\2\2\u02a6\u02a8\3\2\2\2\u02a7\u02a2\3\2\2\2\u02a8"+
		"\u02a9\3\2\2\2\u02a9\u02a7\3\2\2\2\u02a9\u02aa\3\2\2\2\u02aa\u02ac\3\2"+
		"\2\2\u02ab\u02ad\t\4\2\2\u02ac\u02ab\3\2\2\2\u02ac\u02ad\3\2\2\2\u02ad"+
		"\u02af\3\2\2\2\u02ae\u025a\3\2\2\2\u02ae\u027e\3\2\2\2\u02af\25\3\2\2"+
		"\2\u02b0\u02ba\7\'\2\2\u02b1\u02b3\t\6\2\2\u02b2\u02b1\3\2\2\2\u02b3\u02b4"+
		"\3\2\2\2\u02b4\u02b2\3\2\2\2\u02b4\u02b5\3\2\2\2\u02b5\u02bb\3\2\2\2\u02b6"+
		"\u02b8\7\5\2\2\u02b7\u02b9\7D\2\2\u02b8\u02b7\3\2\2\2\u02b8\u02b9\3\2"+
		"\2\2\u02b9\u02bb\3\2\2\2\u02ba\u02b2\3\2\2\2\u02ba\u02b6\3\2\2\2\u02bb"+
		"\u02bc\3\2\2\2\u02bc\u02d4\7?\2\2\u02bd\u02bf\7T\2\2\u02be\u02bd\3\2\2"+
		"\2\u02be\u02bf\3\2\2\2\u02bf\u02c4\3\2\2\2\u02c0\u02c2\5\u0148\u00a5\2"+
		"\u02c1\u02c3\7\u00eb\2\2\u02c2\u02c1\3\2\2\2\u02c2\u02c3\3\2\2\2\u02c3"+
		"\u02c5\3\2\2\2\u02c4\u02c0\3\2\2\2\u02c5\u02c6\3\2\2\2\u02c6\u02c4\3\2"+
		"\2\2\u02c6\u02c7\3\2\2\2\u02c7\u02d5\3\2\2\2\u02c8\u02c9\7\5\2\2\u02c9"+
		"\u02ca\7\u00ae\2\2\u02ca\u02cb\7-\2\2\u02cb\u02d0\7L\2\2\u02cc\u02ce\5"+
		"N(\2\u02cd\u02cf\7\u00eb\2\2\u02ce\u02cd\3\2\2\2\u02ce\u02cf\3\2\2\2\u02cf"+
		"\u02d1\3\2\2\2\u02d0\u02cc\3\2\2\2\u02d1\u02d2\3\2\2\2\u02d2\u02d0\3\2"+
		"\2\2\u02d2\u02d3\3\2\2\2\u02d3\u02d5\3\2\2\2\u02d4\u02be\3\2\2\2\u02d4"+
		"\u02c8\3\2\2\2\u02d5\u02d6\3\2\2\2\u02d6\u02d7\5\30\r\2\u02d7\u03f6\3"+
		"\2\2\2\u02d8\u02f2\7\'\2\2\u02d9\u02de\t\7\2\2\u02da\u02dc\5N(\2\u02db"+
		"\u02dd\7\u00eb\2\2\u02dc\u02db\3\2\2\2\u02dc\u02dd\3\2\2\2\u02dd\u02df"+
		"\3\2\2\2\u02de\u02da\3\2\2\2\u02df\u02e0\3\2\2\2\u02e0\u02de\3\2\2\2\u02e0"+
		"\u02e1\3\2\2\2\u02e1\u02e3\3\2\2\2\u02e2\u02d9\3\2\2\2\u02e3\u02e4\3\2"+
		"\2\2\u02e4\u02e2\3\2\2\2\u02e4\u02e5\3\2\2\2\u02e5\u02f3\3\2\2\2\u02e6"+
		"\u02e8\7\5\2\2\u02e7\u02e9\7D\2\2\u02e8\u02e7\3\2\2\2\u02e8\u02e9\3\2"+
		"\2\2\u02e9\u02ee\3\2\2\2\u02ea\u02ec\5N(\2\u02eb\u02ed\7\u00eb\2\2\u02ec"+
		"\u02eb\3\2\2\2\u02ec\u02ed\3\2\2\2\u02ed\u02ef\3\2\2\2\u02ee\u02ea\3\2"+
		"\2\2\u02ef\u02f0\3\2\2\2\u02f0\u02ee\3\2\2\2\u02f0\u02f1\3\2\2\2\u02f1"+
		"\u02f3\3\2\2\2\u02f2\u02e2\3\2\2\2\u02f2\u02e6\3\2\2\2\u02f3\u02f4\3\2"+
		"\2\2\u02f4\u02fc\7?\2\2\u02f5\u02f7\7T\2\2\u02f6\u02f5\3\2\2\2\u02f6\u02f7"+
		"\3\2\2\2\u02f7\u02f8\3\2\2\2\u02f8\u02fa\5\u0148\u00a5\2\u02f9\u02fb\7"+
		"\u00eb\2\2\u02fa\u02f9\3\2\2\2\u02fa\u02fb\3\2\2\2\u02fb\u02fd\3\2\2\2"+
		"\u02fc\u02f6\3\2\2\2\u02fd\u02fe\3\2\2\2\u02fe\u02fc\3\2\2\2\u02fe\u02ff"+
		"\3\2\2\2\u02ff\u0300\3\2\2\2\u0300\u0301\5\30\r\2\u0301\u03f6\3\2\2\2"+
		"\u0302\u030f\7\'\2\2\u0303\u0305\t\b\2\2\u0304\u0306\7\u00eb\2\2\u0305"+
		"\u0304\3\2\2\2\u0305\u0306\3\2\2\2\u0306\u0308\3\2\2\2\u0307\u0303\3\2"+
		"\2\2\u0308\u0309\3\2\2\2\u0309\u0307\3\2\2\2\u0309\u030a\3\2\2\2\u030a"+
		"\u0310\3\2\2\2\u030b\u030d\7\5\2\2\u030c\u030e\7D\2\2\u030d\u030c\3\2"+
		"\2\2\u030d\u030e\3\2\2\2\u030e\u0310\3\2\2\2\u030f\u0307\3\2\2\2\u030f"+
		"\u030b\3\2\2\2\u0310\u0311\3\2\2\2\u0311\u0327\7?\2\2\u0312\u0313\7M\2"+
		"\2\u0313\u0315\5N(\2\u0314\u0316\7\u00eb\2\2\u0315\u0314\3\2\2\2\u0315"+
		"\u0316\3\2\2\2\u0316\u0318\3\2\2\2\u0317\u0312\3\2\2\2\u0318\u0319\3\2"+
		"\2\2\u0319\u0317\3\2\2\2\u0319\u031a\3\2\2\2\u031a\u0328\3\2\2\2\u031b"+
		"\u031c\7\5\2\2\u031c\u031d\7N\2\2\u031d\u031e\7-\2\2\u031e\u0323\7L\2"+
		"\2\u031f\u0321\5N(\2\u0320\u0322\7\u00eb\2\2\u0321\u0320\3\2\2\2\u0321"+
		"\u0322\3\2\2\2\u0322\u0324\3\2\2\2\u0323\u031f\3\2\2\2\u0324\u0325\3\2"+
		"\2\2\u0325\u0323\3\2\2\2\u0325\u0326\3\2\2\2\u0326\u0328\3\2\2\2\u0327"+
		"\u0317\3\2\2\2\u0327\u031b\3\2\2\2\u0328\u0329\3\2\2\2\u0329\u032a\5\30"+
		"\r\2\u032a\u03f6\3\2\2\2\u032b\u0338\7\'\2\2\u032c\u032e\t\t\2\2\u032d"+
		"\u032f\7\u00eb\2\2\u032e\u032d\3\2\2\2\u032e\u032f\3\2\2\2\u032f\u0331"+
		"\3\2\2\2\u0330\u032c\3\2\2\2\u0331\u0332\3\2\2\2\u0332\u0330\3\2\2\2\u0332"+
		"\u0333\3\2\2\2\u0333\u0339\3\2\2\2\u0334\u0336\7\5\2\2\u0335\u0337\7D"+
		"\2\2\u0336\u0335\3\2\2\2\u0336\u0337\3\2\2\2\u0337\u0339\3\2\2\2\u0338"+
		"\u0330\3\2\2\2\u0338\u0334\3\2\2\2\u0339\u033a\3\2\2\2\u033a\u033b\7?"+
		"\2\2\u033b\u0340\7\23\2\2\u033c\u033e\5N(\2\u033d\u033f\7\u00eb\2\2\u033e"+
		"\u033d\3\2\2\2\u033e\u033f\3\2\2\2\u033f\u0341\3\2\2\2\u0340\u033c\3\2"+
		"\2\2\u0341\u0342\3\2\2\2\u0342\u0340\3\2\2\2\u0342\u0343\3\2\2\2\u0343"+
		"\u0344\3\2\2\2\u0344\u0345\5\30\r\2\u0345\u03f6\3\2\2\2\u0346\u034c\7"+
		"\'\2\2\u0347\u034d\7_\2\2\u0348\u034a\7\5\2\2\u0349\u034b\7D\2\2\u034a"+
		"\u0349\3\2\2\2\u034a\u034b\3\2\2\2\u034b\u034d\3\2\2\2\u034c\u0347\3\2"+
		"\2\2\u034c\u0348\3\2\2\2\u034d\u034e\3\2\2\2\u034e\u034f\7?\2\2\u034f"+
		"\u0350\7\"\2\2\u0350\u0351\7p\2\2\u0351\u0356\7\u00bc\2\2\u0352\u0354"+
		"\5N(\2\u0353\u0355\7\u00eb\2\2\u0354\u0353\3\2\2\2\u0354\u0355\3\2\2\2"+
		"\u0355\u0357\3\2\2\2\u0356\u0352\3\2\2\2\u0357\u0358\3\2\2\2\u0358\u0356"+
		"\3\2\2\2\u0358\u0359\3\2\2\2\u0359\u035a\3\2\2\2\u035a\u035b\5\30\r\2"+
		"\u035b\u03f6\3\2\2\2\u035c\u0362\7\'\2\2\u035d\u0363\7_\2\2\u035e\u0360"+
		"\7\5\2\2\u035f\u0361\7D\2\2\u0360\u035f\3\2\2\2\u0360\u0361\3\2\2\2\u0361"+
		"\u0363\3\2\2\2\u0362\u035d\3\2\2\2\u0362\u035e\3\2\2\2\u0363\u0364\3\2"+
		"\2\2\u0364\u0365\7?\2\2\u0365\u0366\7\"\2\2\u0366\u036b\7\u00a6\2\2\u0367"+
		"\u0369\5N(\2\u0368\u036a\7\u00eb\2\2\u0369\u0368\3\2\2\2\u0369\u036a\3"+
		"\2\2\2\u036a\u036c\3\2\2\2\u036b\u0367\3\2\2\2\u036c\u036d\3\2\2\2\u036d"+
		"\u036b\3\2\2\2\u036d\u036e\3\2\2\2\u036e\u036f\3\2\2\2\u036f\u0370\5\30"+
		"\r\2\u0370\u03f6\3\2\2\2\u0371\u0377\7\'\2\2\u0372\u0378\7\36\2\2\u0373"+
		"\u0375\7\5\2\2\u0374\u0376\7D\2\2\u0375\u0374\3\2\2\2\u0375\u0376\3\2"+
		"\2\2\u0376\u0378\3\2\2\2\u0377\u0372\3\2\2\2\u0377\u0373\3\2\2\2\u0378"+
		"\u0379\3\2\2\2\u0379\u037c\7?\2\2\u037a\u037d\5\34\17\2\u037b\u037d\5"+
		"\36\20\2\u037c\u037a\3\2\2\2\u037c\u037b\3\2\2\2\u037d\u037e\3\2\2\2\u037e"+
		"\u037f\5\30\r\2\u037f\u03f6\3\2\2\2\u0380\u0386\7\'\2\2\u0381\u0387\7"+
		"_\2\2\u0382\u0384\7\5\2\2\u0383\u0385\7D\2\2\u0384\u0383\3\2\2\2\u0384"+
		"\u0385\3\2\2\2\u0385\u0387\3\2\2\2\u0386\u0381\3\2\2\2\u0386\u0382\3\2"+
		"\2\2\u0387\u0388\3\2\2\2\u0388\u0389\7?\2\2\u0389\u038e\7\u0088\2\2\u038a"+
		"\u038c\5N(\2\u038b\u038d\7\u00eb\2\2\u038c\u038b\3\2\2\2\u038c\u038d\3"+
		"\2\2\2\u038d\u038f\3\2\2\2\u038e\u038a\3\2\2\2\u038f\u0390\3\2\2\2\u0390"+
		"\u038e\3\2\2\2\u0390\u0391\3\2\2\2\u0391\u0392\3\2\2\2\u0392\u0393\5\30"+
		"\r\2\u0393\u03f6\3\2\2\2\u0394\u03a1\7\'\2\2\u0395\u0397\t\n\2\2\u0396"+
		"\u0398\7\u00eb\2\2\u0397\u0396\3\2\2\2\u0397\u0398\3\2\2\2\u0398\u039a"+
		"\3\2\2\2\u0399\u0395\3\2\2\2\u039a\u039b\3\2\2\2\u039b\u0399\3\2\2\2\u039b"+
		"\u039c\3\2\2\2\u039c\u03a2\3\2\2\2\u039d\u039f\7\5\2\2\u039e\u03a0\7D"+
		"\2\2\u039f\u039e\3\2\2\2\u039f\u03a0\3\2\2\2\u03a0\u03a2\3\2\2\2\u03a1"+
		"\u0399\3\2\2\2\u03a1\u039d\3\2\2\2\u03a2\u03a3\3\2\2\2\u03a3\u03a4\7?"+
		"\2\2\u03a4\u03a5\7\u0089\2\2\u03a5\u03aa\7\u0098\2\2\u03a6\u03a8\5N(\2"+
		"\u03a7\u03a9\7\u00eb\2\2\u03a8\u03a7\3\2\2\2\u03a8\u03a9\3\2\2\2\u03a9"+
		"\u03ab\3\2\2\2\u03aa\u03a6\3\2\2\2\u03ab\u03ac\3\2\2\2\u03ac\u03aa\3\2"+
		"\2\2\u03ac\u03ad\3\2\2\2\u03ad\u03ae\3\2\2\2\u03ae\u03af\5\30\r\2\u03af"+
		"\u03f6\3\2\2\2\u03b0\u03bd\7\'\2\2\u03b1\u03b3\t\5\2\2\u03b2\u03b4\7\u00eb"+
		"\2\2\u03b3\u03b2\3\2\2\2\u03b3\u03b4\3\2\2\2\u03b4\u03b6\3\2\2\2\u03b5"+
		"\u03b1\3\2\2\2\u03b6\u03b7\3\2\2\2\u03b7\u03b5\3\2\2\2\u03b7\u03b8\3\2"+
		"\2\2\u03b8\u03be\3\2\2\2\u03b9\u03bb\7\5\2\2\u03ba\u03bc\7D\2\2\u03bb"+
		"\u03ba\3\2\2\2\u03bb\u03bc\3\2\2\2\u03bc\u03be\3\2\2\2\u03bd\u03b5\3\2"+
		"\2\2\u03bd\u03b9\3\2\2\2\u03be\u03bf\3\2\2\2\u03bf\u03c0\7?\2\2\u03c0"+
		"\u03c5\7L\2\2\u03c1\u03c3\5N(\2\u03c2\u03c4\7\u00eb\2\2\u03c3\u03c2\3"+
		"\2\2\2\u03c3\u03c4\3\2\2\2\u03c4\u03c6\3\2\2\2\u03c5\u03c1\3\2\2\2\u03c6"+
		"\u03c7\3\2\2\2\u03c7\u03c5\3\2\2\2\u03c7\u03c8\3\2\2\2\u03c8\u03c9\3\2"+
		"\2\2\u03c9\u03ca\5\30\r\2\u03ca\u03f6\3\2\2\2\u03cb\u03d1\7\'\2\2\u03cc"+
		"\u03d2\7\21\2\2\u03cd\u03cf\7\5\2\2\u03ce\u03d0\7D\2\2\u03cf\u03ce\3\2"+
		"\2\2\u03cf\u03d0\3\2\2\2\u03d0\u03d2\3\2\2\2\u03d1\u03cc\3\2\2\2\u03d1"+
		"\u03cd\3\2\2\2\u03d2\u03d3\3\2\2\2\u03d3\u03d4\7?\2\2\u03d4\u03d9\7\u00ad"+
		"\2\2\u03d5\u03d7\5N(\2\u03d6\u03d8\7\u00eb\2\2\u03d7\u03d6\3\2\2\2\u03d7"+
		"\u03d8\3\2\2\2\u03d8\u03da\3\2\2\2\u03d9\u03d5\3\2\2\2\u03da\u03db\3\2"+
		"\2\2\u03db\u03d9\3\2\2\2\u03db\u03dc\3\2\2\2\u03dc\u03dd\3\2\2\2\u03dd"+
		"\u03de\5\30\r\2\u03de\u03e3\7\'\2\2\u03df\u03e1\5N(\2\u03e0\u03e2\7\u00eb"+
		"\2\2\u03e1\u03e0\3\2\2\2\u03e1\u03e2\3\2\2\2\u03e2\u03e4\3\2\2\2\u03e3"+
		"\u03df\3\2\2\2\u03e4\u03e5\3\2\2\2\u03e5\u03e3\3\2\2\2\u03e5\u03e6\3\2"+
		"\2\2\u03e6\u03e7\3\2\2\2\u03e7\u03ec\7\u00b4\2\2\u03e8\u03ea\5N(\2\u03e9"+
		"\u03eb\7\u00eb\2\2\u03ea\u03e9\3\2\2\2\u03ea\u03eb\3\2\2\2\u03eb\u03ed"+
		"\3\2\2\2\u03ec\u03e8\3\2\2\2\u03ed\u03ee\3\2\2\2\u03ee\u03ec\3\2\2\2\u03ee"+
		"\u03ef\3\2\2\2\u03ef\u03f3\3\2\2\2\u03f0\u03f1\7d\2\2\u03f1\u03f2\7e\2"+
		"\2\u03f2\u03f4\7\u0099\2\2\u03f3\u03f0\3\2\2\2\u03f3\u03f4\3\2\2\2\u03f4"+
		"\u03f6\3\2\2\2\u03f5\u02b0\3\2\2\2\u03f5\u02d8\3\2\2\2\u03f5\u0302\3\2"+
		"\2\2\u03f5\u032b\3\2\2\2\u03f5\u0346\3\2\2\2\u03f5\u035c\3\2\2\2\u03f5"+
		"\u0371\3\2\2\2\u03f5\u0380\3\2\2\2\u03f5\u0394\3\2\2\2\u03f5\u03b0\3\2"+
		"\2\2\u03f5\u03cb\3\2\2\2\u03f6\27\3\2\2\2\u03f7\u0402\7\u00b4\2\2\u03f8"+
		"\u03fa\7(\2\2\u03f9\u03f8\3\2\2\2\u03f9\u03fa\3\2\2\2\u03fa\u03fd\3\2"+
		"\2\2\u03fb\u03fe\5N(\2\u03fc\u03fe\7\u009e\2\2\u03fd\u03fb\3\2\2\2\u03fd"+
		"\u03fc\3\2\2\2\u03fe\u0400\3\2\2\2\u03ff\u0401\7\u00eb\2\2\u0400\u03ff"+
		"\3\2\2\2\u0400\u0401\3\2\2\2\u0401\u0403\3\2\2\2\u0402\u03f9\3\2\2\2\u0403"+
		"\u0404\3\2\2\2\u0404\u0402\3\2\2\2\u0404\u0405\3\2\2\2\u0405\u0409\3\2"+
		"\2\2\u0406\u0407\7d\2\2\u0407\u0408\7\'\2\2\u0408\u040a\7\u0099\2\2\u0409"+
		"\u0406\3\2\2\2\u0409\u040a\3\2\2\2\u040a\31\3\2\2\2\u040b\u040c\t\13\2"+
		"\2\u040c\33\3\2\2\2\u040d\u040e\7$\2\2\u040e\u040f\5N(\2\u040f\u041c\7"+
		"\u00f2\2\2\u0410\u0412\5\32\16\2\u0411\u0410\3\2\2\2\u0411\u0412\3\2\2"+
		"\2\u0412\u0414\3\2\2\2\u0413\u0415\5N(\2\u0414\u0413\3\2\2\2\u0414\u0415"+
		"\3\2\2\2\u0415\u0416\3\2\2\2\u0416\u0418\5`\61\2\u0417\u0419\7\u00eb\2"+
		"\2\u0418\u0417\3\2\2\2\u0418\u0419\3\2\2\2\u0419\u041b\3\2\2\2\u041a\u0411"+
		"\3\2\2\2\u041b\u041e\3\2\2\2\u041c\u041a\3\2\2\2\u041c\u041d\3\2\2\2\u041d"+
		"\u041f\3\2\2\2\u041e\u041c\3\2\2\2\u041f\u0420\7\u00f3\2\2\u0420\35\3"+
		"\2\2\2\u0421\u0422\7\5\2\2\u0422\u0423\7%\2\2\u0423\u0424\7-\2\2\u0424"+
		"\u0429\7L\2\2\u0425\u0427\5N(\2\u0426\u0428\7\u00eb\2\2\u0427\u0426\3"+
		"\2\2\2\u0427\u0428\3\2\2\2\u0428\u042a\3\2\2\2\u0429\u0425\3\2\2\2\u042a"+
		"\u042b\3\2\2\2\u042b\u0429\3\2\2\2\u042b\u042c\3\2\2\2\u042c\37\3\2\2"+
		"\2\u042d\u042e\7\21\2\2\u042e\u042f\7z\2\2\u042f\u0430\7T\2\2\u0430\u0431"+
		"\5\u0148\u00a5\2\u0431\u0432\5\"\22\2\u0432\u0433\7`\2\2\u0433\u0435\5"+
		"N(\2\u0434\u0436\5(\25\2\u0435\u0434\3\2\2\2\u0435\u0436\3\2\2\2\u0436"+
		"\u0438\3\2\2\2\u0437\u0439\5\62\32\2\u0438\u0437\3\2\2\2\u0438\u0439\3"+
		"\2\2\2\u0439\u043a\3\2\2\2\u043a\u043b\7\u008d\2\2\u043b\u043c\7\u0103"+
		"\2\2\u043c\u0460\3\2\2\2\u043d\u043e\7\21\2\2\u043e\u043f\7T\2\2\u043f"+
		"\u0440\5\u0148\u00a5\2\u0440\u0443\5\"\22\2\u0441\u0442\7`\2\2\u0442\u0444"+
		"\5N(\2\u0443\u0441\3\2\2\2\u0443\u0444\3\2\2\2\u0444\u0446\3\2\2\2\u0445"+
		"\u0447\5(\25\2\u0446\u0445\3\2\2\2\u0446\u0447\3\2\2\2\u0447\u0449\3\2"+
		"\2\2\u0448\u044a\5\62\32\2\u0449\u0448\3\2\2\2\u0449\u044a\3\2\2\2\u044a"+
		"\u044d\3\2\2\2\u044b\u044c\7\4\2\2\u044c\u044e\5\u0134\u009b\2\u044d\u044b"+
		"\3\2\2\2\u044d\u044e\3\2\2\2\u044e\u0460\3\2\2\2\u044f\u0450\7\21\2\2"+
		"\u0450\u0451\7T\2\2\u0451\u0454\5\u0148\u00a5\2\u0452\u0453\7`\2\2\u0453"+
		"\u0455\5N(\2\u0454\u0452\3\2\2\2\u0454\u0455\3\2\2\2\u0455\u0457\3\2\2"+
		"\2\u0456\u0458\5(\25\2\u0457\u0456\3\2\2\2\u0457\u0458\3\2\2\2\u0458\u045a"+
		"\3\2\2\2\u0459\u045b\5\62\32\2\u045a\u0459\3\2\2\2\u045a\u045b\3\2\2\2"+
		"\u045b\u045c\3\2\2\2\u045c\u045d\7\4\2\2\u045d\u045e\5\u0134\u009b\2\u045e"+
		"\u0460\3\2\2\2\u045f\u042d\3\2\2\2\u045f\u043d\3\2\2\2\u045f\u044f\3\2"+
		"\2\2\u0460!\3\2\2\2\u0461\u0462\7\u00f2\2\2\u0462\u0467\5$\23\2\u0463"+
		"\u0464\7\u00eb\2\2\u0464\u0466\5$\23\2\u0465\u0463\3\2\2\2\u0466\u0469"+
		"\3\2\2\2\u0467\u0465\3\2\2\2\u0467\u0468\3\2\2\2\u0468\u046a\3\2\2\2\u0469"+
		"\u0467\3\2\2\2\u046a\u046b\7\u00f3\2\2\u046b#\3\2\2\2\u046c\u046d\5N("+
		"\2\u046d\u046e\5&\24\2\u046e%\3\2\2\2\u046f\u0470\5`\61\2\u0470\'\3\2"+
		"\2\2\u0471\u0472\7d\2\2\u0472\u0473\7\u00f2\2\2\u0473\u0478\5*\26\2\u0474"+
		"\u0475\7\u00eb\2\2\u0475\u0477\5*\26\2\u0476\u0474\3\2\2\2\u0477\u047a"+
		"\3\2\2\2\u0478\u0476\3\2\2\2\u0478\u0479\3\2\2\2\u0479\u047b\3\2\2\2\u047a"+
		"\u0478\3\2\2\2\u047b\u047c\7\u00f3\2\2\u047c)\3\2\2\2\u047d\u047e\7\u0103"+
		"\2\2\u047e\u047f\7\u00e8\2\2\u047f\u0480\5\u00b2Z\2\u0480+\3\2\2\2\u0481"+
		"\u0482\7`\2\2\u0482\u0483\5N(\2\u0483-\3\2\2\2\u0484\u0485\7\u00ad\2\2"+
		"\u0485\u0486\5\60\31\2\u0486/\3\2\2\2\u0487\u0488\5N(\2\u0488\61\3\2\2"+
		"\2\u0489\u048e\5\64\33\2\u048a\u048e\5:\36\2\u048b\u048e\5B\"\2\u048c"+
		"\u048e\5H%\2\u048d\u0489\3\2\2\2\u048d\u048a\3\2\2\2\u048d\u048b\3\2\2"+
		"\2\u048d\u048c\3\2\2\2\u048e\63\3\2\2\2\u048f\u0490\7\u009b\2\2\u0490"+
		"\u0491\7h\2\2\u0491\u0492\7\u00a1\2\2\u0492\u0493\7\u00f2\2\2\u0493\u0494"+
		"\5\u015a\u00ae\2\u0494\u0495\7\u00f3\2\2\u0495\u0496\7\u00f2\2\2\u0496"+
		"\u0497\5\66\34\2\u0497\u0498\7\u00f3\2\2\u0498\65\3\2\2\2\u0499\u049e"+
		"\58\35\2\u049a\u049b\7\u00eb\2\2\u049b\u049d\58\35\2\u049c\u049a\3\2\2"+
		"\2\u049d\u04a0\3\2\2\2\u049e\u049c\3\2\2\2\u049e\u049f\3\2\2\2\u049f\67"+
		"\3\2\2\2\u04a0\u049e\3\2\2\2\u04a1\u04a2\7\u009b\2\2\u04a2\u04a3\5J&\2"+
		"\u04a3\u04a4\7\u00b6\2\2\u04a4\u04a5\7\u008b\2\2\u04a5\u04b1\7\u00af\2"+
		"\2\u04a6\u04a7\7\u00f2\2\2\u04a7\u04a8\5\u00aeX\2\u04a8\u04a9\7\u00f3"+
		"\2\2\u04a9\u04b2\3\2\2\2\u04aa\u04ac\7\u00f2\2\2\u04ab\u04aa\3\2\2\2\u04ab"+
		"\u04ac\3\2\2\2\u04ac\u04ad\3\2\2\2\u04ad\u04af\7\u008f\2\2\u04ae\u04b0"+
		"\7\u00f3\2\2\u04af\u04ae\3\2\2\2\u04af\u04b0\3\2\2\2\u04b0\u04b2\3\2\2"+
		"\2\u04b1\u04a6\3\2\2\2\u04b1\u04ab\3\2\2\2\u04b29\3\2\2\2\u04b3\u04b4"+
		"\7\u009b\2\2\u04b4\u04b5\7h\2\2\u04b5\u04b6\7\u0081\2\2\u04b6\u04b7\7"+
		"\u00f2\2\2\u04b7\u04b8\5\u015a\u00ae\2\u04b8\u04be\7\u00f3\2\2\u04b9\u04ba"+
		"\7\u00f2\2\2\u04ba\u04bb\5<\37\2\u04bb\u04bc\7\u00f3\2\2\u04bc\u04bf\3"+
		"\2\2\2\u04bd\u04bf\5@!\2\u04be\u04b9\3\2\2\2\u04be\u04bd\3\2\2\2\u04bf"+
		";\3\2\2\2\u04c0\u04c5\5> \2\u04c1\u04c2\7\u00eb\2\2\u04c2\u04c4\5> \2"+
		"\u04c3\u04c1\3\2\2\2\u04c4\u04c7\3\2\2\2\u04c5\u04c3\3\2\2\2\u04c5\u04c6"+
		"\3\2\2\2\u04c6=\3\2\2\2\u04c7\u04c5\3\2\2\2\u04c8\u04c9\7\u009b\2\2\u04c9"+
		"\u04ca\5J&\2\u04ca?\3\2\2\2\u04cb\u04cc\7\u009c\2\2\u04cc\u04cd\5\u00b2"+
		"Z\2\u04cdA\3\2\2\2\u04ce\u04cf\7\u009b\2\2\u04cf\u04d0\7h\2\2\u04d0\u04d1"+
		"\7\u008c\2\2\u04d1\u04d2\7\u00f2\2\2\u04d2\u04d3\5\u015a\u00ae\2\u04d3"+
		"\u04d4\7\u00f3\2\2\u04d4\u04d5\7\u00f2\2\2\u04d5\u04d6\5D#\2\u04d6\u04d7"+
		"\7\u00f3\2\2\u04d7C\3\2\2\2\u04d8\u04dd\5F$\2\u04d9\u04da\7\u00eb\2\2"+
		"\u04da\u04dc\5F$\2\u04db\u04d9\3\2\2\2\u04dc\u04df\3\2\2\2\u04dd\u04db"+
		"\3\2\2\2\u04dd\u04de\3\2\2\2\u04deE\3\2\2\2\u04df\u04dd\3\2\2\2\u04e0"+
		"\u04e1\7\u009b\2\2\u04e1\u04e2\5J&\2\u04e2\u04e4\7\u00b6\2\2\u04e3\u04e5"+
		"\7-\2\2\u04e4\u04e3\3\2\2\2\u04e4\u04e5\3\2\2\2\u04e5\u04e6\3\2\2\2\u04e6"+
		"\u04e7\7\u00f2\2\2\u04e7\u04e8\5\u0172\u00ba\2\u04e8\u04e9\7\u00f3\2\2"+
		"\u04e9G\3\2\2\2\u04ea\u04eb\7\u009b\2\2\u04eb\u04ec\7h\2\2\u04ec\u04ed"+
		"\7m\2\2\u04ed\u04ee\5\"\22\2\u04eeI\3\2\2\2\u04ef\u04f0\5N(\2\u04f0K\3"+
		"\2\2\2\u04f1\u04f2\7v\2\2\u04f2\u04f3\7T\2\2\u04f3\u04f5\5\u0148\u00a5"+
		"\2\u04f4\u04f6\7\u009f\2\2\u04f5\u04f4\3\2\2\2\u04f5\u04f6\3\2\2\2\u04f6"+
		"M\3\2\2\2\u04f7\u04fa\7\u0102\2\2\u04f8\u04fa\5P)\2\u04f9\u04f7\3\2\2"+
		"\2\u04f9\u04f8\3\2\2\2\u04faO\3\2\2\2\u04fb\u04fc\t\f\2\2\u04fcQ\3\2\2"+
		"\2\u04fd\u0500\5\u0086D\2\u04fe\u0500\5T+\2\u04ff\u04fd\3\2\2\2\u04ff"+
		"\u04fe\3\2\2\2\u0500S\3\2\2\2\u0501\u0505\7\u0103\2\2\u0502\u0505\5V,"+
		"\2\u0503\u0505\5^\60\2\u0504\u0501\3\2\2\2\u0504\u0502\3\2\2\2\u0504\u0503"+
		"\3\2\2\2\u0505U\3\2\2\2\u0506\u050a\5Z.\2\u0507\u050a\5X-\2\u0508\u050a"+
		"\5\\/\2\u0509\u0506\3\2\2\2\u0509\u0507\3\2\2\2\u0509\u0508\3\2\2\2\u050a"+
		"W\3\2\2\2\u050b\u050c\7\u00d8\2\2\u050c\u050d\7\u0103\2\2\u050dY\3\2\2"+
		"\2\u050e\u050f\7\u00da\2\2\u050f\u0510\7\u0103\2\2\u0510[\3\2\2\2\u0511"+
		"\u0512\7\u00d7\2\2\u0512\u0513\7\u0103\2\2\u0513]\3\2\2\2\u0514\u0515"+
		"\t\r\2\2\u0515_\3\2\2\2\u0516\u0517\5b\62\2\u0517a\3\2\2\2\u0518\u0522"+
		"\5f\64\2\u0519\u0522\5j\66\2\u051a\u0522\5l\67\2\u051b\u0522\5n8\2\u051c"+
		"\u0522\5v<\2\u051d\u0522\5x=\2\u051e\u0522\5z>\2\u051f\u0522\5|?\2\u0520"+
		"\u0522\5d\63\2\u0521\u0518\3\2\2\2\u0521\u0519\3\2\2\2\u0521\u051a\3\2"+
		"\2\2\u0521\u051b\3\2\2\2\u0521\u051c\3\2\2\2\u0521\u051d\3\2\2\2\u0521"+
		"\u051e\3\2\2\2\u0521\u051f\3\2\2\2\u0521\u0520\3\2\2\2\u0522c\3\2\2\2"+
		"\u0523\u0524\7\u00e1\2\2\u0524e\3\2\2\2\u0525\u0527\7j\2\2\u0526\u0528"+
		"\5h\65\2\u0527\u0526\3\2\2\2\u0527\u0528\3\2\2\2\u0528\u053d\3\2\2\2\u0529"+
		"\u052b\7\u00d3\2\2\u052a\u052c\5h\65\2\u052b\u052a\3\2\2\2\u052b\u052c"+
		"\3\2\2\2\u052c\u053d\3\2\2\2\u052d\u052e\7j\2\2\u052e\u0530\7\u00b9\2"+
		"\2\u052f\u0531\5h\65\2\u0530\u052f\3\2\2\2\u0530\u0531\3\2\2\2\u0531\u053d"+
		"\3\2\2\2\u0532\u0533\7\u00d3\2\2\u0533\u0535\7\u00b9\2\2\u0534\u0536\5"+
		"h\65\2\u0535\u0534\3\2\2\2\u0535\u0536\3\2\2\2\u0536\u053d\3\2\2\2\u0537"+
		"\u0539\7\u00d4\2\2\u0538\u053a\5h\65\2\u0539\u0538\3\2\2\2\u0539\u053a"+
		"\3\2\2\2\u053a\u053d\3\2\2\2\u053b\u053d\7\u00dc\2\2\u053c\u0525\3\2\2"+
		"\2\u053c\u0529\3\2\2\2\u053c\u052d\3\2\2\2\u053c\u0532\3\2\2\2\u053c\u0537"+
		"\3\2\2\2\u053c\u053b\3\2\2\2\u053dg\3\2\2\2\u053e\u053f\7\u00f2\2\2\u053f"+
		"\u0540\7\u00fe\2\2\u0540\u0541\7\u00f3\2\2\u0541i\3\2\2\2\u0542\u0543"+
		"\7\u0096\2\2\u0543\u0545\7j\2\2\u0544\u0546\5h\65\2\u0545\u0544\3\2\2"+
		"\2\u0545\u0546\3\2\2\2\u0546\u0566\3\2\2\2\u0547\u0548\7\u0096\2\2\u0548"+
		"\u054a\7\u00d3\2\2\u0549\u054b\5h\65\2\u054a\u0549\3\2\2\2\u054a\u054b"+
		"\3\2\2\2\u054b\u0566\3\2\2\2\u054c\u054e\7\u00d5\2\2\u054d\u054f\5h\65"+
		"\2\u054e\u054d\3\2\2\2\u054e\u054f\3\2\2\2\u054f\u0566\3\2\2\2\u0550\u0551"+
		"\7\u0096\2\2\u0551\u0552\7j\2\2\u0552\u0554\7\u00b9\2\2\u0553\u0555\5"+
		"h\65\2\u0554\u0553\3\2\2\2\u0554\u0555\3\2\2\2\u0555\u0566\3\2\2\2\u0556"+
		"\u0557\7\u0096\2\2\u0557\u0558\7\u00d3\2\2\u0558\u055a\7\u00b9\2\2\u0559"+
		"\u055b\5h\65\2\u055a\u0559\3\2\2\2\u055a\u055b\3\2\2\2\u055b\u0566\3\2"+
		"\2\2\u055c\u055d\7\u00d5\2\2\u055d\u055f\7\u00b9\2\2\u055e\u0560\5h\65"+
		"\2\u055f\u055e\3\2\2\2\u055f\u0560\3\2\2\2\u0560\u0566\3\2\2\2\u0561\u0563"+
		"\7\u00d6\2\2\u0562\u0564\5h\65\2\u0563\u0562\3\2\2\2\u0563\u0564\3\2\2"+
		"\2\u0564\u0566\3\2\2\2\u0565\u0542\3\2\2\2\u0565\u0547\3\2\2\2\u0565\u054c"+
		"\3\2\2\2\u0565\u0550\3\2\2\2\u0565\u0556\3\2\2\2\u0565\u055c\3\2\2\2\u0565"+
		"\u0561\3\2\2\2\u0566k\3\2\2\2\u0567\u0569\7\u00df\2\2\u0568\u056a\5h\65"+
		"\2\u0569\u0568\3\2\2\2\u0569\u056a\3\2\2\2\u056a\u0570\3\2\2\2\u056b\u056d"+
		"\7\u00e0\2\2\u056c\u056e\5h\65\2\u056d\u056c\3\2\2\2\u056d\u056e\3\2\2"+
		"\2\u056e\u0570\3\2\2\2\u056f\u0567\3\2\2\2\u056f\u056b\3\2\2\2\u0570m"+
		"\3\2\2\2\u0571\u0574\5p9\2\u0572\u0574\5r:\2\u0573\u0571\3\2\2\2\u0573"+
		"\u0572\3\2\2\2\u0574o\3\2\2\2\u0575\u0577\7\u00d1\2\2\u0576\u0578\5t;"+
		"\2\u0577\u0576\3\2\2\2\u0577\u0578\3\2\2\2\u0578\u058b\3\2\2\2\u0579\u057b"+
		"\7\u00d2\2\2\u057a\u057c\5t;\2\u057b\u057a\3\2\2\2\u057b\u057c\3\2\2\2"+
		"\u057c\u058b\3\2\2\2\u057d\u057f\7r\2\2\u057e\u0580\5t;\2\u057f\u057e"+
		"\3\2\2\2\u057f\u0580\3\2\2\2\u0580\u058b\3\2\2\2\u0581\u058b\7\u00c3\2"+
		"\2\u0582\u058b\7\u00c7\2\2\u0583\u058b\7\u00c4\2\2\u0584\u058b\7\u00c8"+
		"\2\2\u0585\u058b\7\u00c5\2\2\u0586\u058b\7\u00c9\2\2\u0587\u058b\7\u00ca"+
		"\2\2\u0588\u058b\7\u00c6\2\2\u0589\u058b\7\u00cb\2\2\u058a\u0575\3\2\2"+
		"\2\u058a\u0579\3\2\2\2\u058a\u057d\3\2\2\2\u058a\u0581\3\2\2\2\u058a\u0582"+
		"\3\2\2\2\u058a\u0583\3\2\2\2\u058a\u0584\3\2\2\2\u058a\u0585\3\2\2\2\u058a"+
		"\u0586\3\2\2\2\u058a\u0587\3\2\2\2\u058a\u0588\3\2\2\2\u058a\u0589\3\2"+
		"\2\2\u058bq\3\2\2\2\u058c\u058e\7\u00cf\2\2\u058d\u058f\5t;\2\u058e\u058d"+
		"\3\2\2\2\u058e\u058f\3\2\2\2\u058f\u0597\3\2\2\2\u0590\u0597\7\u00cc\2"+
		"\2\u0591\u0597\7\u00ce\2\2\u0592\u0597\7\u00cd\2\2\u0593\u0597\7\u00d0"+
		"\2\2\u0594\u0595\7\u00d0\2\2\u0595\u0597\7\u009d\2\2\u0596\u058c\3\2\2"+
		"\2\u0596\u0590\3\2\2\2\u0596\u0591\3\2\2\2\u0596\u0592\3\2\2\2\u0596\u0593"+
		"\3\2\2\2\u0596\u0594\3\2\2\2\u0597s\3\2\2\2\u0598\u0599\7\u00f2\2\2\u0599"+
		"\u059a\7\u00fe\2\2\u059a\u05a1\7\u00f3\2\2\u059b\u059c\7\u00f2\2\2\u059c"+
		"\u059d\7\u00fe\2\2\u059d\u059e\7\u00eb\2\2\u059e\u059f\7\u00fe\2\2\u059f"+
		"\u05a1\7\u00f3\2\2\u05a0\u0598\3\2\2\2\u05a0\u059b\3\2\2\2\u05a1u\3\2"+
		"\2\2\u05a2\u05a3\t\16\2\2\u05a3w\3\2\2\2\u05a4\u05b2\7\u00d7\2\2\u05a5"+
		"\u05b2\7\u00d8\2\2\u05a6\u05a7\7\u00d8\2\2\u05a7\u05a8\7d\2\2\u05a8\u05a9"+
		"\7\u00d8\2\2\u05a9\u05b2\7\u00be\2\2\u05aa\u05b2\7\u00d9\2\2\u05ab\u05b2"+
		"\7\u00da\2\2\u05ac\u05ad\7\u00da\2\2\u05ad\u05ae\7d\2\2\u05ae\u05af\7"+
		"\u00d8\2\2\u05af\u05b2\7\u00be\2\2\u05b0\u05b2\7\u00db\2\2\u05b1\u05a4"+
		"\3\2\2\2\u05b1\u05a5\3\2\2\2\u05b1\u05a6\3\2\2\2\u05b1\u05aa\3\2\2\2\u05b1"+
		"\u05ab\3\2\2\2\u05b1\u05ac\3\2\2\2\u05b1\u05b0\3\2\2\2\u05b2y\3\2\2\2"+
		"\u05b3\u05b5\7\u00c1\2\2\u05b4\u05b6\5h\65\2\u05b5\u05b4\3\2\2\2\u05b5"+
		"\u05b6\3\2\2\2\u05b6\u05c1\3\2\2\2\u05b7\u05b9\7\u00c2\2\2\u05b8\u05ba"+
		"\5h\65\2\u05b9\u05b8\3\2\2\2\u05b9\u05ba\3\2\2\2\u05ba\u05c1\3\2\2\2\u05bb"+
		"\u05bc\7\u00c1\2\2\u05bc\u05be\7\u00b9\2\2\u05bd\u05bf\5h\65\2\u05be\u05bd"+
		"\3\2\2\2\u05be\u05bf\3\2\2\2\u05bf\u05c1\3\2\2\2\u05c0\u05b3\3\2\2\2\u05c0"+
		"\u05b7\3\2\2\2\u05c0\u05bb\3\2\2\2\u05c1{\3\2\2\2\u05c2\u05c4\7\u00dd"+
		"\2\2\u05c3\u05c5\5h\65\2\u05c4\u05c3\3\2\2\2\u05c4\u05c5\3\2\2\2\u05c5"+
		"\u05d0\3\2\2\2\u05c6\u05c7\7\u00dd\2\2\u05c7\u05c9\7\u00b9\2\2\u05c8\u05ca"+
		"\5h\65\2\u05c9\u05c8\3\2\2\2\u05c9\u05ca\3\2\2\2\u05ca\u05d0\3\2\2\2\u05cb"+
		"\u05cd\7\u00de\2\2\u05cc\u05ce\5h\65\2\u05cd\u05cc\3\2\2\2\u05cd\u05ce"+
		"\3\2\2\2\u05ce\u05d0\3\2\2\2\u05cf\u05c2\3\2\2\2\u05cf\u05c6\3\2\2\2\u05cf"+
		"\u05cb\3\2\2\2\u05d0}\3\2\2\2\u05d1\u05d4\5\u0080A\2\u05d2\u05d4\5\u0082"+
		"B\2\u05d3\u05d1\3\2\2\2\u05d3\u05d2\3\2\2\2\u05d4\177\3\2\2\2\u05d5\u05d6"+
		"\7\u00f2\2\2\u05d6\u05d7\5\u00aeX\2\u05d7\u05d8\7\u00f3\2\2\u05d8\u0081"+
		"\3\2\2\2\u05d9\u05e1\5\u0084C\2\u05da\u05e1\5\u0156\u00ac\2\u05db\u05e1"+
		"\5\u008aF\2\u05dc\u05e1\5\u015c\u00af\2\u05dd\u05e1\5\u0096L\2\u05de\u05e1"+
		"\5\u00a8U\2\u05df\u05e1\5\u0190\u00c9\2\u05e0\u05d9\3\2\2\2\u05e0\u05da"+
		"\3\2\2\2\u05e0\u05db\3\2\2\2\u05e0\u05dc\3\2\2\2\u05e0\u05dd\3\2\2\2\u05e0"+
		"\u05de\3\2\2\2\u05e0\u05df\3\2\2\2\u05e1\u0083\3\2\2\2\u05e2\u05e3\5R"+
		"*\2\u05e3\u0085\3\2\2\2\u05e4\u05e5\t\17\2\2\u05e5\u0087\3\2\2\2\u05e6"+
		"\u05e8\5\u00bc_\2\u05e7\u05e6\3\2\2\2\u05e7\u05e8\3\2\2\2\u05e8\u05e9"+
		"\3\2\2\2\u05e9\u05ea\5\u0086D\2\u05ea\u0089\3\2\2\2\u05eb\u05ec\5\u008c"+
		"G\2\u05ec\u008b\3\2\2\2\u05ed\u05ee\7n\2\2\u05ee\u05ef\7\u00f2\2\2\u05ef"+
		"\u05f0\7\u00f6\2\2\u05f0\u05f6\7\u00f3\2\2\u05f1\u05f3\5\u008eH\2\u05f2"+
		"\u05f4\5\u0092J\2\u05f3\u05f2\3\2\2\2\u05f3\u05f4\3\2\2\2\u05f4\u05f6"+
		"\3\2\2\2\u05f5\u05ed\3\2\2\2\u05f5\u05f1\3\2\2\2\u05f6\u008d\3\2\2\2\u05f7"+
		"\u05f8\5\u0090I\2\u05f8\u05fa\7\u00f2\2\2\u05f9\u05fb\5\u0154\u00ab\2"+
		"\u05fa\u05f9\3\2\2\2\u05fa\u05fb\3\2\2\2\u05fb\u05fc\3\2\2\2\u05fc\u05fd"+
		"\5\u00aeX\2\u05fd\u05fe\7\u00f3\2\2\u05fe\u008f\3\2\2\2\u05ff\u0600\t"+
		"\20\2\2\u0600\u0091\3\2\2\2\u0601\u0602\7|\2\2\u0602\u0603\7\u00f2\2\2"+
		"\u0603\u0604\7c\2\2\u0604\u0605\5\u011e\u0090\2\u0605\u0606\7\u00f3\2"+
		"\2\u0606\u0093\3\2\2\2\u0607\u0608\7\u0080\2\2\u0608\u0609\7\u00f2\2\2"+
		"\u0609\u060a\5\u015a\u00ae\2\u060a\u060b\7\u00f3\2\2\u060b\u0095\3\2\2"+
		"\2\u060c\u060d\5\u009aN\2\u060d\u0097\3\2\2\2\u060e\u060f\7\u0097\2\2"+
		"\u060f\u0610\7\u00f2\2\2\u0610\u0611\5\u00b2Z\2\u0611\u0612\7\u00eb\2"+
		"\2\u0612\u0613\5\u00d8m\2\u0613\u0614\7\u00f3\2\2\u0614\u0621\3\2\2\2"+
		"\u0615\u0616\7l\2\2\u0616\u0617\7\u00f2\2\2\u0617\u061a\5\u00b2Z\2\u0618"+
		"\u0619\7\u00eb\2\2\u0619\u061b\5\u00d8m\2\u061a\u0618\3\2\2\2\u061b\u061c"+
		"\3\2\2\2\u061c\u061a\3\2\2\2\u061c\u061d\3\2\2\2\u061d\u061e\3\2\2\2\u061e"+
		"\u061f\7\u00f3\2\2\u061f\u0621\3\2\2\2\u0620\u060e\3\2\2\2\u0620\u0615"+
		"\3\2\2\2\u0621\u0099\3\2\2\2\u0622\u0625\5\u009cO\2\u0623\u0625\5\u009e"+
		"P\2\u0624\u0622\3\2\2\2\u0624\u0623\3\2\2\2\u0625\u009b\3\2\2\2\u0626"+
		"\u0627\7\f\2\2\u0627\u0629\5\u00d8m\2\u0628\u062a\5\u00a0Q\2\u0629\u0628"+
		"\3\2\2\2\u062a\u062b\3\2\2\2\u062b\u0629\3\2\2\2\u062b\u062c\3\2\2\2\u062c"+
		"\u062e\3\2\2\2\u062d\u062f\5\u00a4S\2\u062e\u062d\3\2\2\2\u062e\u062f"+
		"\3\2\2\2\u062f\u0630\3\2\2\2\u0630\u0631\7\33\2\2\u0631\u009d\3\2\2\2"+
		"\u0632\u0634\7\f\2\2\u0633\u0635\5\u00a2R\2\u0634\u0633\3\2\2\2\u0635"+
		"\u0636\3\2\2\2\u0636\u0634\3\2\2\2\u0636\u0637\3\2\2\2\u0637\u0639\3\2"+
		"\2\2\u0638\u063a\5\u00a4S\2\u0639\u0638\3\2\2\2\u0639\u063a\3\2\2\2\u063a"+
		"\u063b\3\2\2\2\u063b\u063c\7\33\2\2\u063c\u009f\3\2\2\2\u063d\u063e\7"+
		"b\2\2\u063e\u063f\5\u011e\u0090\2\u063f\u0640\7W\2\2\u0640\u0641\5\u00a6"+
		"T\2\u0641\u00a1\3\2\2\2\u0642\u0643\7b\2\2\u0643\u0644\5\u011e\u0090\2"+
		"\u0644\u0645\7W\2\2\u0645\u0646\5\u00a6T\2\u0646\u00a3\3\2\2\2\u0647\u0648"+
		"\7\34\2\2\u0648\u0649\5\u00a6T\2\u0649\u00a5\3\2\2\2\u064a\u064d\5\u00ae"+
		"X\2\u064b\u064d\7=\2\2\u064c\u064a\3\2\2\2\u064c\u064b\3\2\2\2\u064d\u00a7"+
		"\3\2\2\2\u064e\u064f\7\16\2\2\u064f\u0650\7\u00f2\2\2\u0650\u0651\5\u00aa"+
		"V\2\u0651\u0652\7\4\2\2\u0652\u0653\5\u00acW\2\u0653\u0654\7\u00f3\2\2"+
		"\u0654\u00a9\3\2\2\2\u0655\u0656\5\u00aeX\2\u0656\u00ab\3\2\2\2\u0657"+
		"\u0658\5`\61\2\u0658\u00ad\3\2\2\2\u0659\u065d\5\u00b0Y\2\u065a\u065d"+
		"\5\u00ecw\2\u065b\u065d\5\u00d8m\2\u065c\u0659\3\2\2\2\u065c\u065a\3\2"+
		"\2\2\u065c\u065b\3\2\2\2\u065d\u00af\3\2\2\2\u065e\u0662\5\u00b2Z\2\u065f"+
		"\u0662\5\u00c8e\2\u0660\u0662\7=\2\2\u0661\u065e\3\2\2\2\u0661\u065f\3"+
		"\2\2\2\u0661\u0660\3\2\2\2\u0662\u00b1\3\2\2\2\u0663\u0668\5\u00b4[\2"+
		"\u0664\u0665\t\21\2\2\u0665\u0667\5\u00b4[\2\u0666\u0664\3\2\2\2\u0667"+
		"\u066a\3\2\2\2\u0668\u0666\3\2\2\2\u0668\u0669\3\2\2\2\u0669\u00b3\3\2"+
		"\2\2\u066a\u0668\3\2\2\2\u066b\u0670\5\u00b6\\\2\u066c\u066d\t\22\2\2"+
		"\u066d\u066f\5\u00b6\\\2\u066e\u066c\3\2\2\2\u066f\u0672\3\2\2\2\u0670"+
		"\u066e\3\2\2\2\u0670\u0671\3\2\2\2\u0671\u00b5\3\2\2\2\u0672\u0670\3\2"+
		"\2\2\u0673\u0675\5\u00bc_\2\u0674\u0673\3\2\2\2\u0674\u0675\3\2\2\2\u0675"+
		"\u0676\3\2\2\2\u0676\u0677\5\u00ba^\2\u0677\u00b7\3\2\2\2\u0678\u0679"+
		"\7\u00f2\2\2\u0679\u067e\5\u00b2Z\2\u067a\u067b\7\u00eb\2\2\u067b\u067d"+
		"\5\u00b2Z\2\u067c\u067a\3\2\2\2\u067d\u0680\3\2\2\2\u067e\u067c\3\2\2"+
		"\2\u067e\u067f\3\2\2\2\u067f\u0681\3\2\2\2\u0680\u067e\3\2\2\2\u0681\u0682"+
		"\7\u00f3\2\2\u0682\u00b9\3\2\2\2\u0683\u0688\5~@\2\u0684\u0685\7\u00e6"+
		"\2\2\u0685\u0687\5\u00acW\2\u0686\u0684\3\2\2\2\u0687\u068a\3\2\2\2\u0688"+
		"\u0686\3\2\2\2\u0688\u0689\3\2\2\2\u0689\u068d\3\2\2\2\u068a\u0688\3\2"+
		"\2\2\u068b\u068d\5\u00be`\2\u068c\u0683\3\2\2\2\u068c\u068b\3\2\2\2\u068d"+
		"\u00bb\3\2\2\2\u068e\u068f\t\21\2\2\u068f\u00bd\3\2\2\2\u0690\u0691\5"+
		"\u00c0a\2\u0691\u00bf\3\2\2\2\u0692\u0693\7{\2\2\u0693\u0694\7\u00f2\2"+
		"\2\u0694\u0695\5\u00c2b\2\u0695\u0696\7&\2\2\u0696\u0697\5\u00c6d\2\u0697"+
		"\u0698\7\u00f3\2\2\u0698\u00c1\3\2\2\2\u0699\u069d\5\u018a\u00c6\2\u069a"+
		"\u069d\5\u00c4c\2\u069b\u069d\5\u018e\u00c8\2\u069c\u0699\3\2\2\2\u069c"+
		"\u069a\3\2\2\2\u069c\u069b\3\2\2\2\u069d\u00c3\3\2\2\2\u069e\u069f\t\23"+
		"\2\2\u069f\u00c5\3\2\2\2\u06a0\u06a3\5\u0156\u00ac\2\u06a1\u06a3\5V,\2"+
		"\u06a2\u06a0\3\2\2\2\u06a2\u06a1\3\2\2\2\u06a3\u00c7\3\2\2\2\u06a4\u06a5"+
		"\5\u00caf\2\u06a5\u00c9\3\2\2\2\u06a6\u06ab\5\u00ccg\2\u06a7\u06a8\7\u00ec"+
		"\2\2\u06a8\u06aa\5\u00ccg\2\u06a9\u06a7\3\2\2\2\u06aa\u06ad\3\2\2\2\u06ab"+
		"\u06a9\3\2\2\2\u06ab\u06ac\3\2\2\2\u06ac\u00cb\3\2\2\2\u06ad\u06ab\3\2"+
		"\2\2\u06ae\u06af\5\u00ceh\2\u06af\u00cd\3\2\2\2\u06b0\u06b3\5~@\2\u06b1"+
		"\u06b3\5\u00d0i\2\u06b2\u06b0\3\2\2\2\u06b2\u06b1\3\2\2\2\u06b3\u00cf"+
		"\3\2\2\2\u06b4\u06b5\5\u00d2j\2\u06b5\u00d1\3\2\2\2\u06b6\u06b7\7\u00b3"+
		"\2\2\u06b7\u06b8\7\u00f2\2\2\u06b8\u06b9\5\u00d4k\2\u06b9\u06ba\7\u00f3"+
		"\2\2\u06ba\u00d3\3\2\2\2\u06bb\u06bd\5\u00d6l\2\u06bc\u06bb\3\2\2\2\u06bc"+
		"\u06bd\3\2\2\2\u06bd\u06bf\3\2\2\2\u06be\u06c0\5\u00caf\2\u06bf\u06be"+
		"\3\2\2\2\u06bf\u06c0\3\2\2\2\u06c0\u06c1\3\2\2\2\u06c1\u06c3\7&\2\2\u06c2"+
		"\u06bc\3\2\2\2\u06c2\u06c3\3\2\2\2\u06c3\u06c4\3\2\2\2\u06c4\u06ca\5\u00ca"+
		"f\2\u06c5\u06c6\5\u00caf\2\u06c6\u06c7\7\u00eb\2\2\u06c7\u06c8\5\u00ca"+
		"f\2\u06c8\u06ca\3\2\2\2\u06c9\u06c2\3\2\2\2\u06c9\u06c5\3\2\2\2\u06ca"+
		"\u00d5\3\2\2\2\u06cb\u06cc\t\24\2\2\u06cc\u00d7\3\2\2\2\u06cd\u06ce\5"+
		"\u00dan\2\u06ce\u00d9\3\2\2\2\u06cf\u06d4\5\u00dco\2\u06d0\u06d1\7B\2"+
		"\2\u06d1\u06d3\5\u00dan\2\u06d2\u06d0\3\2\2\2\u06d3\u06d6\3\2\2\2\u06d4"+
		"\u06d2\3\2\2\2\u06d4\u06d5\3\2\2\2\u06d5\u00db\3\2\2\2\u06d6\u06d4\3\2"+
		"\2\2\u06d7\u06dc\5\u00dep\2\u06d8\u06d9\7\6\2\2\u06d9\u06db\5\u00dco\2"+
		"\u06da\u06d8\3\2\2\2\u06db\u06de\3\2\2\2\u06dc\u06da\3\2\2\2\u06dc\u06dd"+
		"\3\2\2\2\u06dd\u00dd\3\2\2\2\u06de\u06dc\3\2\2\2\u06df\u06e3\5\u00e0q"+
		"\2\u06e0\u06e1\7<\2\2\u06e1\u06e3\5\u00e0q\2\u06e2\u06df\3\2\2\2\u06e2"+
		"\u06e0\3\2\2\2\u06e3\u00df\3\2\2\2\u06e4\u06e6\5\u00e6t\2\u06e5\u06e7"+
		"\5\u00e2r\2\u06e6\u06e5\3\2\2\2\u06e6\u06e7\3\2\2\2\u06e7\u00e1\3\2\2"+
		"\2\u06e8\u06ea\7\64\2\2\u06e9\u06eb\7<\2\2\u06ea\u06e9\3\2\2\2\u06ea\u06eb"+
		"\3\2\2\2\u06eb\u06ec\3\2\2\2\u06ec\u06ed\5\u00e4s\2\u06ed\u00e3\3\2\2"+
		"\2\u06ee\u06ef\t\r\2\2\u06ef\u00e5\3\2\2\2\u06f0\u06f3\5\u0164\u00b3\2"+
		"\u06f1\u06f3\5\u00e8u\2\u06f2\u06f0\3\2\2\2\u06f2\u06f1\3\2\2\2\u06f3"+
		"\u00e7\3\2\2\2\u06f4\u06f7\5\u00eav\2\u06f5\u06f7\5\u0082B\2\u06f6\u06f4"+
		"\3\2\2\2\u06f6\u06f5\3\2\2\2\u06f7\u00e9\3\2\2\2\u06f8\u06f9\7\u00f2\2"+
		"\2\u06f9\u06fa\5\u00d8m\2\u06fa\u06fb\7\u00f3\2\2\u06fb\u00eb\3\2\2\2"+
		"\u06fc\u06ff\5\u00eex\2\u06fd\u06ff\5\u00f0y\2\u06fe\u06fc\3\2\2\2\u06fe"+
		"\u06fd\3\2\2\2\u06ff\u00ed\3\2\2\2\u0700\u0701\5\u0082B\2\u0701\u00ef"+
		"\3\2\2\2\u0702\u0703\7=\2\2\u0703\u00f1\3\2\2\2\u0704\u0707\5\u00eex\2"+
		"\u0705\u0707\5\u00f4{\2\u0706\u0704\3\2\2\2\u0706\u0705\3\2\2\2\u0707"+
		"\u00f3\3\2\2\2\u0708\u070b\5\u00b0Y\2\u0709\u070b\5\u00e8u\2\u070a\u0708"+
		"\3\2\2\2\u070a\u0709\3\2\2\2\u070b\u00f5\3\2\2\2\u070c\u070e\5\u00f8}"+
		"\2\u070d\u070f\5\u011c\u008f\2\u070e\u070d\3\2\2\2\u070e\u070f\3\2\2\2"+
		"\u070f\u0711\3\2\2\2\u0710\u0712\5\u0120\u0091\2\u0711\u0710\3\2\2\2\u0711"+
		"\u0712\3\2\2\2\u0712\u0714\3\2\2\2\u0713\u0715\5\u0130\u0099\2\u0714\u0713"+
		"\3\2\2\2\u0714\u0715\3\2\2\2\u0715\u0717\3\2\2\2\u0716\u0718\5\u0198\u00cd"+
		"\2\u0717\u0716\3\2\2\2\u0717\u0718\3\2\2\2\u0718\u071a\3\2\2\2\u0719\u071b"+
		"\5\u01a0\u00d1\2\u071a\u0719\3\2\2\2\u071a\u071b\3\2\2\2\u071b\u00f7\3"+
		"\2\2\2\u071c\u071d\7&\2\2\u071d\u071e\5\u00fa~\2\u071e\u00f9\3\2\2\2\u071f"+
		"\u0724\5\u00fc\177\2\u0720\u0721\7\u00eb\2\2\u0721\u0723\5\u00fc\177\2"+
		"\u0722\u0720\3\2\2\2\u0723\u0726\3\2\2\2\u0724\u0722\3\2\2\2\u0724\u0725"+
		"\3\2\2\2\u0725\u00fb\3\2\2\2\u0726\u0724\3\2\2\2\u0727\u072a\5\u00fe\u0080"+
		"\2\u0728\u072a\5\u0116\u008c\2\u0729\u0727\3\2\2\2\u0729\u0728\3\2\2\2"+
		"\u072a\u00fd\3\2\2\2\u072b\u072d\5\u0116\u008c\2\u072c\u072e\5\u0100\u0081"+
		"\2\u072d\u072c\3\2\2\2\u072e\u072f\3\2\2\2\u072f\u072d\3\2\2\2\u072f\u0730"+
		"\3\2\2\2\u0730\u00ff\3\2\2\2\u0731\u0732\7\22\2\2\u0732\u0733\7\65\2\2"+
		"\u0733\u0745\5\u0116\u008c\2\u0734\u0736\5\u010a\u0086\2\u0735\u0734\3"+
		"\2\2\2\u0735\u0736\3\2\2\2\u0736\u0737\3\2\2\2\u0737\u0738\7\65\2\2\u0738"+
		"\u0739\5\u0116\u008c\2\u0739\u073a\5\u0110\u0089\2\u073a\u0745\3\2\2\2"+
		"\u073b\u073d\7;\2\2\u073c\u073e\5\u010a\u0086\2\u073d\u073c\3\2\2\2\u073d"+
		"\u073e\3\2\2\2\u073e\u073f\3\2\2\2\u073f\u0740\7\65\2\2\u0740\u0745\5"+
		"\u0116\u008c\2\u0741\u0742\7\\\2\2\u0742\u0743\7\65\2\2\u0743\u0745\5"+
		"\u0116\u008c\2\u0744\u0731\3\2\2\2\u0744\u0735\3\2\2\2\u0744\u073b\3\2"+
		"\2\2\u0744\u0741\3\2\2\2\u0745\u0101\3\2\2\2\u0746\u0747\7\22\2\2\u0747"+
		"\u0748\7\65\2\2\u0748\u0749\5\u0116\u008c\2\u0749\u0103\3\2\2\2\u074a"+
		"\u074c\5\u010a\u0086\2\u074b\u074a\3\2\2\2\u074b\u074c\3\2\2\2\u074c\u074d"+
		"\3\2\2\2\u074d\u074e\7\65\2\2\u074e\u074f\5\u0116\u008c\2\u074f\u0750"+
		"\5\u0110\u0089\2\u0750\u0105\3\2\2\2\u0751\u0753\7;\2\2\u0752\u0754\5"+
		"\u010a\u0086\2\u0753\u0752\3\2\2\2\u0753\u0754\3\2\2\2\u0754\u0755\3\2"+
		"\2\2\u0755\u0756\7\65\2\2\u0756\u0757\5\u0116\u008c\2\u0757\u0107\3\2"+
		"\2\2\u0758\u0759\7\\\2\2\u0759\u075a\7\65\2\2\u075a\u075b\5\u0116\u008c"+
		"\2\u075b\u0109\3\2\2\2\u075c\u075f\7/\2\2\u075d\u075f\5\u010c\u0087\2"+
		"\u075e\u075c\3\2\2\2\u075e\u075d\3\2\2\2\u075f\u010b\3\2\2\2\u0760\u0762"+
		"\5\u010e\u0088\2\u0761\u0763\7@\2\2\u0762\u0761\3\2\2\2\u0762\u0763\3"+
		"\2\2\2\u0763\u010d\3\2\2\2\u0764\u0765\t\25\2\2\u0765\u010f\3\2\2\2\u0766"+
		"\u0769\5\u0112\u008a\2\u0767\u0769\5\u0114\u008b\2\u0768\u0766\3\2\2\2"+
		"\u0768\u0767\3\2\2\2\u0769\u0111\3\2\2\2\u076a\u076b\7?\2\2\u076b\u076c"+
		"\5\u011e\u0090\2\u076c\u0113\3\2\2\2\u076d\u076e\7`\2\2\u076e\u076f\7"+
		"\u00f2\2\2\u076f\u0770\5\u015a\u00ae\2\u0770\u0771\7\u00f3\2\2\u0771\u0115"+
		"\3\2\2\2\u0772\u0777\5\u0146\u00a4\2\u0773\u0775\7\4\2\2\u0774\u0773\3"+
		"\2\2\2\u0774\u0775\3\2\2\2\u0775\u0776\3\2\2\2\u0776\u0778\5N(\2\u0777"+
		"\u0774\3\2\2\2\u0777\u0778\3\2\2\2\u0778\u077d\3\2\2\2\u0779\u077a\7\u00f2"+
		"\2\2\u077a\u077b\5\u0118\u008d\2\u077b\u077c\7\u00f3\2\2\u077c\u077e\3"+
		"\2\2\2\u077d\u0779\3\2\2\2\u077d\u077e\3\2\2\2\u077e\u078b\3\2\2\2\u077f"+
		"\u0781\5\u011a\u008e\2\u0780\u0782\7\4\2\2\u0781\u0780\3\2\2\2\u0781\u0782"+
		"\3\2\2\2\u0782\u0783\3\2\2\2\u0783\u0788\5N(\2\u0784\u0785\7\u00f2\2\2"+
		"\u0785\u0786\5\u0118\u008d\2\u0786\u0787\7\u00f3\2\2\u0787\u0789\3\2\2"+
		"\2\u0788\u0784\3\2\2\2\u0788\u0789\3\2\2\2\u0789\u078b\3\2\2\2\u078a\u0772"+
		"\3\2\2\2\u078a\u077f\3\2\2\2\u078b\u0117\3\2\2\2\u078c\u0791\5N(\2\u078d"+
		"\u078e\7\u00eb\2\2\u078e\u0790\5N(\2\u078f\u078d\3\2\2\2\u0790\u0793\3"+
		"\2\2\2\u0791\u078f\3\2\2\2\u0791\u0792\3\2\2\2\u0792\u0119\3\2\2\2\u0793"+
		"\u0791\3\2\2\2\u0794\u0795\5\u0160\u00b1\2\u0795\u011b\3\2\2\2\u0796\u0797"+
		"\7c\2\2\u0797\u0798\5\u011e\u0090\2\u0798\u011d\3\2\2\2\u0799\u079a\5"+
		"\u00aeX\2\u079a\u011f\3\2\2\2\u079b\u079c\7(\2\2\u079c\u079d\7h\2\2\u079d"+
		"\u079e\5\u0122\u0092\2\u079e\u0121\3\2\2\2\u079f\u07a4\5\u0124\u0093\2"+
		"\u07a0\u07a1\7\u00eb\2\2\u07a1\u07a3\5\u0124\u0093\2\u07a2\u07a0\3\2\2"+
		"\2\u07a3\u07a6\3\2\2\2\u07a4\u07a2\3\2\2\2\u07a4\u07a5\3\2\2\2\u07a5\u0123"+
		"\3\2\2\2\u07a6\u07a4\3\2\2\2\u07a7\u07ac\5\u012a\u0096\2\u07a8\u07ac\5"+
		"\u012c\u0097\2\u07a9\u07ac\5\u012e\u0098\2\u07aa\u07ac\5\u0126\u0094\2"+
		"\u07ab\u07a7\3\2\2\2\u07ab\u07a8\3\2\2\2\u07ab\u07a9\3\2\2\2\u07ab\u07aa"+
		"\3\2\2\2\u07ac\u0125\3\2\2\2\u07ad\u07b3\5\u00f2z\2\u07ae\u07af\7\u00f2"+
		"\2\2\u07af\u07b0\5\u0132\u009a\2\u07b0\u07b1\7\u00f3\2\2\u07b1\u07b3\3"+
		"\2\2\2\u07b2\u07ad\3\2\2\2\u07b2\u07ae\3\2\2\2\u07b3\u0127\3\2\2\2\u07b4"+
		"\u07b9\5\u0126\u0094\2\u07b5\u07b6\7\u00eb\2\2\u07b6\u07b8\5\u0126\u0094"+
		"\2\u07b7\u07b5\3\2\2\2\u07b8\u07bb\3\2\2\2\u07b9\u07b7\3\2\2\2\u07b9\u07ba"+
		"\3\2\2\2\u07ba\u0129\3\2\2\2\u07bb\u07b9\3\2\2\2\u07bc\u07bd\7\u00a4\2"+
		"\2\u07bd\u07be\7\u00f2\2\2\u07be\u07bf\5\u0128\u0095\2\u07bf\u07c0\7\u00f3"+
		"\2\2\u07c0\u012b\3\2\2\2\u07c1\u07c2\7o\2\2\u07c2\u07c3\7\u00f2\2\2\u07c3"+
		"\u07c4\5\u0128\u0095\2\u07c4\u07c5\7\u00f3\2\2\u07c5\u012d\3\2\2\2\u07c6"+
		"\u07c7\7\u00f2\2\2\u07c7\u07c8\7\u00f3\2\2\u07c8\u012f\3\2\2\2\u07c9\u07ca"+
		"\7)\2\2\u07ca\u07cb\5\u00d8m\2\u07cb\u0131\3\2\2\2\u07cc\u07d1\5\u00f2"+
		"z\2\u07cd\u07ce\7\u00eb\2\2\u07ce\u07d0\5\u00f2z\2\u07cf\u07cd\3\2\2\2"+
		"\u07d0\u07d3\3\2\2\2\u07d1\u07cf\3\2\2\2\u07d1\u07d2\3\2\2\2\u07d2\u0133"+
		"\3\2\2\2\u07d3\u07d1\3\2\2\2\u07d4\u07d5\5\u0136\u009c\2\u07d5\u0135\3"+
		"\2\2\2\u07d6\u07d9\5\u0138\u009d\2\u07d7\u07d9\5\u00fe\u0080\2\u07d8\u07d6"+
		"\3\2\2\2\u07d8\u07d7\3\2\2\2\u07d9\u0137\3\2\2\2\u07da\u07e3\5\u013c\u009f"+
		"\2\u07db\u07dc\5\u00fe\u0080\2\u07dc\u07de\t\26\2\2\u07dd\u07df\t\27\2"+
		"\2\u07de\u07dd\3\2\2\2\u07de\u07df\3\2\2\2\u07df\u07e0\3\2\2\2\u07e0\u07e1"+
		"\5\u013a\u009e\2\u07e1\u07e3\3\2\2\2\u07e2\u07da\3\2\2\2\u07e2\u07db\3"+
		"\2\2\2\u07e3\u07eb\3\2\2\2\u07e4\u07e6\t\26\2\2\u07e5\u07e7\t\27\2\2\u07e6"+
		"\u07e5\3\2\2\2\u07e6\u07e7\3\2\2\2\u07e7\u07e8\3\2\2\2\u07e8\u07ea\5\u013a"+
		"\u009e\2\u07e9\u07e4\3\2\2\2\u07ea\u07ed\3\2\2\2\u07eb\u07e9\3\2\2\2\u07eb"+
		"\u07ec\3\2\2\2\u07ec\u0139\3\2\2\2\u07ed\u07eb\3\2\2\2\u07ee\u07f1\5\u013c"+
		"\u009f\2\u07ef\u07f1\5\u00fe\u0080\2\u07f0\u07ee\3\2\2\2\u07f0\u07ef\3"+
		"\2\2\2\u07f1\u013b\3\2\2\2\u07f2\u07fb\5\u0140\u00a1\2\u07f3\u07f4\5\u00fe"+
		"\u0080\2\u07f4\u07f6\7\60\2\2\u07f5\u07f7\t\27\2\2\u07f6\u07f5\3\2\2\2"+
		"\u07f6\u07f7\3\2\2\2\u07f7\u07f8\3\2\2\2\u07f8\u07f9\5\u013e\u00a0\2\u07f9"+
		"\u07fb\3\2\2\2\u07fa\u07f2\3\2\2\2\u07fa\u07f3\3\2\2\2\u07fb\u0803\3\2"+
		"\2\2\u07fc\u07fe\7\60\2\2\u07fd\u07ff\t\27\2\2\u07fe\u07fd\3\2\2\2\u07fe"+
		"\u07ff\3\2\2\2\u07ff\u0800\3\2\2\2\u0800\u0802\5\u013e\u00a0\2\u0801\u07fc"+
		"\3\2\2\2\u0802\u0805\3\2\2\2\u0803\u0801\3\2\2\2\u0803\u0804\3\2\2\2\u0804"+
		"\u013d\3\2\2\2\u0805\u0803\3\2\2\2\u0806\u0809\5\u0140\u00a1\2\u0807\u0809"+
		"\5\u00fe\u0080\2\u0808\u0806\3\2\2\2\u0808\u0807\3\2\2\2\u0809\u013f\3"+
		"\2\2\2\u080a\u0810\5\u0142\u00a2\2\u080b\u080c\7\u00f2\2\2\u080c\u080d"+
		"\5\u0138\u009d\2\u080d\u080e\7\u00f3\2\2\u080e\u0810\3\2\2\2\u080f\u080a"+
		"\3\2\2\2\u080f\u080b\3\2\2\2\u0810\u0141\3\2\2\2\u0811\u0814\5\u014a\u00a6"+
		"\2\u0812\u0814\5\u0144\u00a3\2\u0813\u0811\3\2\2\2\u0813\u0812\3\2\2\2"+
		"\u0814\u0143\3\2\2\2\u0815\u0816\7T\2\2\u0816\u0817\5\u0146\u00a4\2\u0817"+
		"\u0145\3\2\2\2\u0818\u081b\5\u0148\u00a5\2\u0819\u081b\5N(\2\u081a\u0818"+
		"\3\2\2\2\u081a\u0819\3\2\2\2\u081b\u0147\3\2\2\2\u081c\u0823\5N(\2\u081d"+
		"\u081e\7\u00f9\2\2\u081e\u0821\5N(\2\u081f\u0820\7\u00f9\2\2\u0820\u0822"+
		"\5N(\2\u0821\u081f\3\2\2\2\u0821\u0822\3\2\2\2\u0822\u0824\3\2\2\2\u0823"+
		"\u081d\3\2\2\2\u0823\u0824\3\2\2\2\u0824\u0149\3\2\2\2\u0825\u0827\7O"+
		"\2\2\u0826\u0828\5\u0154\u00ab\2\u0827\u0826\3\2\2\2\u0827\u0828\3\2\2"+
		"\2\u0828\u0829\3\2\2\2\u0829\u082b\5\u014c\u00a7\2\u082a\u082c\5\u00f6"+
		"|\2\u082b\u082a\3\2\2\2\u082b\u082c\3\2\2\2\u082c\u014b\3\2\2\2\u082d"+
		"\u0832\5\u014e\u00a8\2\u082e\u082f\7\u00eb\2\2\u082f\u0831\5\u014e\u00a8"+
		"\2\u0830\u082e\3\2\2\2\u0831\u0834\3\2\2\2\u0832\u0830\3\2\2\2\u0832\u0833"+
		"\3\2\2\2\u0833\u014d\3\2\2\2\u0834\u0832\3\2\2\2\u0835\u0838\5\u0150\u00a9"+
		"\2\u0836\u0838\5\u0152\u00aa\2\u0837\u0835\3\2\2\2\u0837\u0836\3\2\2\2"+
		"\u0838\u014f\3\2\2\2\u0839\u083b\5\u00aeX\2\u083a\u083c\5\u0158\u00ad"+
		"\2\u083b\u083a\3\2\2\2\u083b\u083c\3\2\2\2\u083c\u0151\3\2\2\2\u083d\u083e"+
		"\7\u0102\2\2\u083e\u0840\7\u00f9\2\2\u083f\u083d\3\2\2\2\u083f\u0840\3"+
		"\2\2\2\u0840\u0841\3\2\2\2\u0841\u0842\7\u00f6\2\2\u0842\u0153\3\2\2\2"+
		"\u0843\u0844\t\27\2\2\u0844\u0155\3\2\2\2\u0845\u0846\5N(\2\u0846\u0847"+
		"\7\u00f9\2\2\u0847\u0849\3\2\2\2\u0848\u0845\3\2\2\2\u0848\u0849\3\2\2"+
		"\2\u0849\u084a\3\2\2\2\u084a\u084b\5N(\2\u084b\u0157\3\2\2\2\u084c\u084e"+
		"\7\4\2\2\u084d\u084c\3\2\2\2\u084d\u084e\3\2\2\2\u084e\u084f\3\2\2\2\u084f"+
		"\u0850\5N(\2\u0850\u0159\3\2\2\2\u0851\u0856\5\u0156\u00ac\2\u0852\u0853"+
		"\7\u00eb\2\2\u0853\u0855\5\u0156\u00ac\2\u0854\u0852\3\2\2\2\u0855\u0858"+
		"\3\2\2\2\u0856\u0854\3\2\2\2\u0856\u0857\3\2\2\2\u0857\u015b\3\2\2\2\u0858"+
		"\u0856\3\2\2\2\u0859\u085a\5\u0162\u00b2\2\u085a\u015d\3\2\2\2\u085b\u085c"+
		"\5\u0162\u00b2\2\u085c\u015f\3\2\2\2\u085d\u085e\5\u0162\u00b2\2\u085e"+
		"\u0161\3\2\2\2\u085f\u0860\7\u00f2\2\2\u0860\u0861\5\u0134\u009b\2\u0861"+
		"\u0862\7\u00f3\2\2\u0862\u0163\3\2\2\2\u0863\u086a\5\u0166\u00b4\2\u0864"+
		"\u086a\5\u016a\u00b6\2\u0865\u086a\5\u016e\u00b8\2\u0866\u086a\5\u0174"+
		"\u00bb\2\u0867\u086a\5\u017c\u00bf\2\u0868\u086a\5\u0186\u00c4\2\u0869"+
		"\u0863\3\2\2\2\u0869\u0864\3\2\2\2\u0869\u0865\3\2\2\2\u0869\u0866\3\2"+
		"\2\2\u0869\u0867\3\2\2\2\u0869\u0868\3\2\2\2\u086a\u0165\3\2\2\2\u086b"+
		"\u086c\5\u00f2z\2\u086c\u086d\5\u0168\u00b5\2\u086d\u086e\5\u00f2z\2\u086e"+
		"\u0167\3\2\2\2\u086f\u0870\t\30\2\2\u0870\u0169\3\2\2\2\u0871\u0872\5"+
		"\u00f2z\2\u0872\u0873\5\u016c\u00b7\2\u0873\u016b\3\2\2\2\u0874\u0876"+
		"\7<\2\2\u0875\u0874\3\2\2\2\u0875\u0876\3\2\2\2\u0876\u0877\3\2\2\2\u0877"+
		"\u0879\7g\2\2\u0878\u087a\t\31\2\2\u0879\u0878\3\2\2\2\u0879\u087a\3\2"+
		"\2\2\u087a\u087b\3\2\2\2\u087b\u087c\5\u00f2z\2\u087c\u087d\7\6\2\2\u087d"+
		"\u087e\5\u00f2z\2\u087e\u016d\3\2\2\2\u087f\u0881\5\u00b2Z\2\u0880\u0882"+
		"\7<\2\2\u0881\u0880\3\2\2\2\u0881\u0882\3\2\2\2\u0882\u0883\3\2\2\2\u0883"+
		"\u0884\7-\2\2\u0884\u0885\5\u0170\u00b9\2\u0885\u016f\3\2\2\2\u0886\u088c"+
		"\5\u0160\u00b1\2\u0887\u0888\7\u00f2\2\2\u0888\u0889\5\u0172\u00ba\2\u0889"+
		"\u088a\7\u00f3\2\2\u088a\u088c\3\2\2\2\u088b\u0886\3\2\2\2\u088b\u0887"+
		"\3\2\2\2\u088c\u0171\3\2\2\2\u088d\u0892\5\u00ecw\2\u088e\u088f\7\u00eb"+
		"\2\2\u088f\u0891\5\u00ecw\2\u0890\u088e\3\2\2\2\u0891\u0894\3\2\2\2\u0892"+
		"\u0890\3\2\2\2\u0892\u0893\3\2\2\2\u0893\u0173\3\2\2\2\u0894\u0892\3\2"+
		"\2\2\u0895\u0896\5\u00f2z\2\u0896\u0897\5\u0176\u00bc\2\u0897\u0898\7"+
		"\u0103\2\2\u0898\u0175\3\2\2\2\u0899\u089b\7<\2\2\u089a\u0899\3\2\2\2"+
		"\u089a\u089b\3\2\2\2\u089b\u089c\3\2\2\2\u089c\u089f\5\u0178\u00bd\2\u089d"+
		"\u089f\5\u017a\u00be\2\u089e\u089a\3\2\2\2\u089e\u089d\3\2\2\2\u089f\u0177"+
		"\3\2\2\2\u08a0\u08a7\78\2\2\u08a1\u08a7\7+\2\2\u08a2\u08a3\7\u00a8\2\2"+
		"\u08a3\u08a7\7\u00b4\2\2\u08a4\u08a7\7\u00a2\2\2\u08a5\u08a7\7\u00a3\2"+
		"\2\u08a6\u08a0\3\2\2\2\u08a6\u08a1\3\2\2\2\u08a6\u08a2\3\2\2\2\u08a6\u08a4"+
		"\3\2\2\2\u08a6\u08a5\3\2\2\2\u08a7\u0179\3\2\2\2\u08a8\u08a9\t\32\2\2"+
		"\u08a9\u017b\3\2\2\2\u08aa\u08ab\5\u00f2z\2\u08ab\u08ad\7\64\2\2\u08ac"+
		"\u08ae\7<\2\2\u08ad\u08ac\3\2\2\2\u08ad\u08ae\3\2\2\2\u08ae\u08af\3\2"+
		"\2\2\u08af\u08b0\7=\2\2\u08b0\u017d\3\2\2\2\u08b1\u08b2\5\u00b2Z\2\u08b2"+
		"\u08b3\5\u0168\u00b5\2\u08b3\u08b4\5\u0180\u00c1\2\u08b4\u08b5\5\u0160"+
		"\u00b1\2\u08b5\u017f\3\2\2\2\u08b6\u08b9\5\u0182\u00c2\2\u08b7\u08b9\5"+
		"\u0184\u00c3\2\u08b8\u08b6\3\2\2\2\u08b8\u08b7\3\2\2\2\u08b9\u0181\3\2"+
		"\2\2\u08ba\u08bb\7\5\2\2\u08bb\u0183\3\2\2\2\u08bc\u08bd\t\33\2\2\u08bd"+
		"\u0185\3\2\2\2\u08be\u08c0\7<\2\2\u08bf\u08be\3\2\2\2\u08bf\u08c0\3\2"+
		"\2\2\u08c0\u08c1\3\2\2\2\u08c1\u08c2\7y\2\2\u08c2\u08c3\5\u0160\u00b1"+
		"\2\u08c3\u0187\3\2\2\2\u08c4\u08c5\7]\2\2\u08c5\u08c6\5\u0160\u00b1\2"+
		"\u08c6\u0189\3\2\2\2\u08c7\u08ca\5\u018c\u00c7\2\u08c8\u08ca\7\u00a5\2"+
		"\2\u08c9\u08c7\3\2\2\2\u08c9\u08c8\3\2\2\2\u08ca\u018b\3\2\2\2\u08cb\u08cc"+
		"\t\34\2\2\u08cc\u018d\3\2\2\2\u08cd\u08ce\t\35\2\2\u08ce\u018f\3\2\2\2"+
		"\u08cf\u08d0\5\u0194\u00cb\2\u08d0\u08d2\7\u00f2\2\2\u08d1\u08d3\5\u0196"+
		"\u00cc\2\u08d2\u08d1\3\2\2\2\u08d2\u08d3\3\2\2\2\u08d3\u08d4\3\2\2\2\u08d4"+
		"\u08d5\7\u00f3\2\2\u08d5\u0191\3\2\2\2\u08d6\u08d7\t\36\2\2\u08d7\u0193"+
		"\3\2\2\2\u08d8\u08db\5N(\2\u08d9\u08db\5\u0192\u00ca\2\u08da\u08d8\3\2"+
		"\2\2\u08da\u08d9\3\2\2\2\u08db\u0195\3\2\2\2\u08dc\u08e1\5\u00aeX\2\u08dd"+
		"\u08de\7\u00eb\2\2\u08de\u08e0\5\u00aeX\2\u08df\u08dd\3\2\2\2\u08e0\u08e3"+
		"\3\2\2\2\u08e1\u08df\3\2\2\2\u08e1\u08e2\3\2\2\2\u08e2\u0197\3\2\2\2\u08e3"+
		"\u08e1\3\2\2\2\u08e4\u08e5\7C\2\2\u08e5\u08e6\7h\2\2\u08e6\u08e7\5\u019a"+
		"\u00ce\2\u08e7\u0199\3\2\2\2\u08e8\u08ed\5\u019c\u00cf\2\u08e9\u08ea\7"+
		"\u00eb\2\2\u08ea\u08ec\5\u019c\u00cf\2\u08eb\u08e9\3\2\2\2\u08ec\u08ef"+
		"\3\2\2\2\u08ed\u08eb\3\2\2\2\u08ed\u08ee\3\2\2\2\u08ee\u019b\3\2\2\2\u08ef"+
		"\u08ed\3\2\2\2\u08f0\u08f2\5\u00f2z\2\u08f1\u08f3\5\u019e\u00d0\2\u08f2"+
		"\u08f1\3\2\2\2\u08f2\u08f3\3\2\2\2\u08f3\u08f5\3\2\2\2\u08f4\u08f6\5\u01a2"+
		"\u00d2\2\u08f5\u08f4\3\2\2\2\u08f5\u08f6\3\2\2\2\u08f6\u019d\3\2\2\2\u08f7"+
		"\u08f8\t\37\2\2\u08f8\u019f\3\2\2\2\u08f9\u08fa\79\2\2\u08fa\u08fb\5\u00b2"+
		"Z\2\u08fb\u01a1\3\2\2\2\u08fc\u08fd\7=\2\2\u08fd\u0901\7}\2\2\u08fe\u08ff"+
		"\7=\2\2\u08ff\u0901\7\u008a\2\2\u0900\u08fc\3\2\2\2\u0900\u08fe\3\2\2"+
		"\2\u0901\u01a3\3\2\2\2\u0902\u0904\7\u0084\2\2\u0903\u0905\7\u009a\2\2"+
		"\u0904\u0903\3\2\2\2\u0904\u0905\3\2\2\2\u0905\u0906\3\2\2\2\u0906\u0907"+
		"\7\61\2\2\u0907\u090c\5\u0148\u00a5\2\u0908\u0909\7\u00f2\2\2\u0909\u090a"+
		"\5\u0118\u008d\2\u090a\u090b\7\u00f3\2\2\u090b\u090d\3\2\2\2\u090c\u0908"+
		"\3\2\2\2\u090c\u090d\3\2\2\2\u090d\u090e\3\2\2\2\u090e\u090f\5\u0134\u009b"+
		"\2\u090f\u0920\3\2\2\2\u0910\u0912\7\u0084\2\2\u0911\u0913\7\u009a\2\2"+
		"\u0912\u0911\3\2\2\2\u0912\u0913\3\2\2\2\u0913\u0914\3\2\2\2\u0914\u0915"+
		"\7\61\2\2\u0915\u0916\7\u008d\2\2\u0916\u091c\7\u0103\2\2\u0917\u0918"+
		"\7`\2\2\u0918\u091a\5N(\2\u0919\u091b\5(\25\2\u091a\u0919\3\2\2\2\u091a"+
		"\u091b\3\2\2\2\u091b\u091d\3\2\2\2\u091c\u0917\3\2\2\2\u091c\u091d\3\2"+
		"\2\2\u091d\u091e\3\2\2\2\u091e\u0920\5\u0134\u009b\2\u091f\u0902\3\2\2"+
		"\2\u091f\u0910\3\2\2\2\u0920\u01a5\3\2\2\2\u0141\u01a8\u01ac\u01b9\u01c1"+
		"\u01c5\u01cc\u01d2\u01d9\u01dd\u01e1\u01e5\u01e9\u01ed\u01f7\u01fa\u01fe"+
		"\u0202\u0209\u020c\u0210\u0212\u0216\u021e\u0227\u022b\u022d\u022f\u0235"+
		"\u023a\u0240\u0244\u0248\u024c\u0254\u0256\u025e\u0263\u0265\u026a\u026e"+
		"\u0272\u0275\u0279\u027c\u0282\u0286\u028a\u028e\u0290\u0296\u029a\u029e"+
		"\u02a2\u02a5\u02a9\u02ac\u02ae\u02b4\u02b8\u02ba\u02be\u02c2\u02c6\u02ce"+
		"\u02d2\u02d4\u02dc\u02e0\u02e4\u02e8\u02ec\u02f0\u02f2\u02f6\u02fa\u02fe"+
		"\u0305\u0309\u030d\u030f\u0315\u0319\u0321\u0325\u0327\u032e\u0332\u0336"+
		"\u0338\u033e\u0342\u034a\u034c\u0354\u0358\u0360\u0362\u0369\u036d\u0375"+
		"\u0377\u037c\u0384\u0386\u038c\u0390\u0397\u039b\u039f\u03a1\u03a8\u03ac"+
		"\u03b3\u03b7\u03bb\u03bd\u03c3\u03c7\u03cf\u03d1\u03d7\u03db\u03e1\u03e5"+
		"\u03ea\u03ee\u03f3\u03f5\u03f9\u03fd\u0400\u0404\u0409\u0411\u0414\u0418"+
		"\u041c\u0427\u042b\u0435\u0438\u0443\u0446\u0449\u044d\u0454\u0457\u045a"+
		"\u045f\u0467\u0478\u048d\u049e\u04ab\u04af\u04b1\u04be\u04c5\u04dd\u04e4"+
		"\u04f5\u04f9\u04ff\u0504\u0509\u0521\u0527\u052b\u0530\u0535\u0539\u053c"+
		"\u0545\u054a\u054e\u0554\u055a\u055f\u0563\u0565\u0569\u056d\u056f\u0573"+
		"\u0577\u057b\u057f\u058a\u058e\u0596\u05a0\u05b1\u05b5\u05b9\u05be\u05c0"+
		"\u05c4\u05c9\u05cd\u05cf\u05d3\u05e0\u05e7\u05f3\u05f5\u05fa\u061c\u0620"+
		"\u0624\u062b\u062e\u0636\u0639\u064c\u065c\u0661\u0668\u0670\u0674\u067e"+
		"\u0688\u068c\u069c\u06a2\u06ab\u06b2\u06bc\u06bf\u06c2\u06c9\u06d4\u06dc"+
		"\u06e2\u06e6\u06ea\u06f2\u06f6\u06fe\u0706\u070a\u070e\u0711\u0714\u0717"+
		"\u071a\u0724\u0729\u072f\u0735\u073d\u0744\u074b\u0753\u075e\u0762\u0768"+
		"\u0774\u0777\u077d\u0781\u0788\u078a\u0791\u07a4\u07ab\u07b2\u07b9\u07d1"+
		"\u07d8\u07de\u07e2\u07e6\u07eb\u07f0\u07f6\u07fa\u07fe\u0803\u0808\u080f"+
		"\u0813\u081a\u0821\u0823\u0827\u082b\u0832\u0837\u083b\u083f\u0848\u084d"+
		"\u0856\u0869\u0875\u0879\u0881\u088b\u0892\u089a\u089e\u08a6\u08ad\u08b8"+
		"\u08bf\u08c9\u08d2\u08da\u08e1\u08ed\u08f2\u08f5\u0900\u0904\u090c\u0912"+
		"\u091a\u091c\u091f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}