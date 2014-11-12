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
		FUNCTION=39, ISODOW=151, OVERWRITE=173, FUNCTIONS=40, ROW=80, PRECISION=177, 
		ILIKE=47, Character_String_Literal=283, NOT=67, EXCEPT=30, FOREIGN=37, 
		PRIVILEGES=78, BYTEA=248, STATEMENT=93, CHARACTER=118, MONTH=167, BlockComment=280, 
		VARBIT=217, CREATE=17, STDDEV_POP=191, COMMENTS=124, USING=107, UNLOGGED=204, 
		NOT_EQUAL=261, TIMEZONE_MINUTE=200, VERTICAL_BAR=275, VARIADIC=108, TIMESTAMPTZ=243, 
		REGEXP=182, GEQ=265, STDDEV_SAMP=192, DIVIDE=271, BLOB=247, PRESERVE=76, 
		ASC=7, GROUPING=144, SUBPARTITION=193, KEY=60, TEMP=96, ELSE=29, NUMBER=278, 
		BOOL=215, TRAILING=99, SEMI_COLON=258, INT=224, RLIKE=183, RESTRICT=84, 
		LEADING=61, SERVER=186, TABLESPACE=195, MILLISECONDS=164, REAL=229, INTERSECT=54, 
		GROUP=44, LANGUAGE=153, SEQUENCES=89, OUT=73, REAL_NUMBER=279, TRIM=201, 
		LEFT_PAREN=266, LOCATION=158, END=28, CONSTRAINT=15, TIMEZONE_HOUR=199, 
		CAST_EXPRESSION=254, OPTION=171, ISOYEAR=152, NCHAR=237, EXECUTE=33, TABLE=95, 
		VARCHAR=236, FLOAT=231, VERSION=209, MICROSECONDS=162, ASYMMETRIC=6, SUM=194, 
		Space=284, INOUT=56, STORAGE=190, TIME=240, AS=2, RIGHT_PAREN=267, THEN=98, 
		MAXVALUE=161, REPLACE=83, LEFT=62, AVG=114, ZONE=213, TRUNCATE=102, COLUMN=122, 
		PLUS=268, EXISTS=137, NVARCHAR=238, Not_Similar_To=251, LIKE=63, COLLATE=13, 
		INTEGER=225, OUTER=72, BY=116, DEFERRABLE=22, TO=202, RIGHT=86, SET=187, 
		HAVING=45, SESSION=91, MIN=165, MINUS=269, TEXT=244, HOUR=146, CONCATENATION_OPERATOR=260, 
		UNION=103, COLON=257, COMMIT=125, SCHEMA=87, DATABASE=19, DECIMAL=234, 
		DROP=134, BIGINT=226, WHEN=109, ROWS=81, BIT=216, LARGE=154, REVOKE=85, 
		NATURAL=66, FORMAT=142, PUBLIC=178, EXTENSION=34, BETWEEN=115, OPTIONS=172, 
		FIRST=141, CAST=12, WEEK=210, EXTERNAL=138, DOUBLE_QUOTE=277, VARYING=208, 
		TRIGGER=100, CASE=10, CHAR=235, INT8=221, COUNT=126, DAY=129, CASCADE=11, 
		INT2=219, INT1=218, Identifier=282, INT4=220, QUOTE=276, MODULAR=272, 
		FULL=38, THAN=197, QUARTER=180, INSERT=149, INHERITS=51, CONNECT=14, INTERSECTION=150, 
		LESS=156, TINYINT=222, BOTH=9, Similar_To_Case_Insensitive=252, DOUBLE=232, 
		ADMIN=113, SYMMETRIC=94, EACH=27, LAST=155, COMMENT=123, SELECT=90, INTO=55, 
		UNIQUE=104, COALESCE=121, SECOND=185, EPOCH=135, ROLLUP=184, NULL=68, 
		WITHOUT=112, EVERY=136, ON=71, MATCH=159, PRIMARY=77, DELETE=24, INET4=249, 
		NUMERIC=233, LOCAL=65, OF=69, EXCLUDING=32, LIST=157, TABLES=196, UNDERLINE=274, 
		SEQUENCE=88, Not_Similar_To_Case_Insensitive=253, CUBE=127, NATIONAL=168, 
		VAR_POP=207, OR=74, FILTER=140, CHECK=119, FROM=41, FALSE=35, COLLECT=120, 
		DISTINCT=26, TEMPORARY=97, TIMESTAMP=242, SIMPLE=189, CONSTRAINTS=16, 
		WHERE=110, DEC=130, VAR_SAMP=206, NULLIF=169, TIMETZ=241, INNER=53, YEAR=212, 
		TIMEZONE=198, ORDER=75, LIMIT=64, DECADE=131, GTH=264, White_Space=285, 
		UPDATE=105, MAX=160, LineComment=281, DEFERRED=23, FOR=36, FLOAT4=227, 
		FLOAT8=228, AND=4, CROSS=18, Similar_To=250, USAGE=106, IF=46, INDEX=147, 
		OIDS=70, BOOLEAN=214, IN=49, UNKNOWN=203, MULTIPLY=270, OBJECT=170, COMMA=259, 
		REFERENCES=82, IS=58, PARTITION=175, PARTITIONS=176, SOME=92, EQUAL=256, 
		ALL=3, DOT=273, EXTRACT=139, CENTURY=117, DOW=132, PARTIAL=174, EXCLUDE=31, 
		WITH=111, INITIALLY=52, DOY=133, FUSION=143, GRANT=43, VARBINARY=246, 
		DEFAULT=20, VALUES=205, HASH=145, INDEXES=148, MILLENNIUM=163, RANGE=181, 
		BEFORE=8, PURGE=179, AFTER=1, INSTEAD=57, WRAPPER=211, TRUE=101, PROCEDURE=79, 
		JOIN=59, SIMILAR=188, DEFAULTS=21, LTH=262, ANY=5, BAD=286, ASSIGN=255, 
		REGCLASS=230, IMMEDIATE=48, BINARY=245, DESC=25, DATE=239, GLOBAL=42, 
		MINUTE=166, DATA=128, INCLUDING=50, LEQ=263, SMALLINT=223;
	public static final String[] tokenNames = {
		"<INVALID>", "AFTER", "AS", "ALL", "AND", "ANY", "ASYMMETRIC", "ASC", 
		"BEFORE", "BOTH", "CASE", "CASCADE", "CAST", "COLLATE", "CONNECT", "CONSTRAINT", 
		"CONSTRAINTS", "CREATE", "CROSS", "DATABASE", "DEFAULT", "DEFAULTS", "DEFERRABLE", 
		"DEFERRED", "DELETE", "DESC", "DISTINCT", "EACH", "END", "ELSE", "EXCEPT", 
		"EXCLUDE", "EXCLUDING", "EXECUTE", "EXTENSION", "FALSE", "FOR", "FOREIGN", 
		"FULL", "FUNCTION", "FUNCTIONS", "FROM", "GLOBAL", "GRANT", "GROUP", "HAVING", 
		"IF", "ILIKE", "IMMEDIATE", "IN", "INCLUDING", "INHERITS", "INITIALLY", 
		"INNER", "INTERSECT", "INTO", "INOUT", "INSTEAD", "IS", "JOIN", "KEY", 
		"LEADING", "LEFT", "LIKE", "LIMIT", "LOCAL", "NATURAL", "NOT", "NULL", 
		"OF", "OIDS", "ON", "OUTER", "OUT", "OR", "ORDER", "PRESERVE", "PRIMARY", 
		"PRIVILEGES", "PROCEDURE", "ROW", "ROWS", "REFERENCES", "REPLACE", "RESTRICT", 
		"REVOKE", "RIGHT", "SCHEMA", "SEQUENCE", "SEQUENCES", "SELECT", "SESSION", 
		"SOME", "STATEMENT", "SYMMETRIC", "TABLE", "TEMP", "TEMPORARY", "THEN", 
		"TRAILING", "TRIGGER", "TRUE", "TRUNCATE", "UNION", "UNIQUE", "UPDATE", 
		"USAGE", "USING", "VARIADIC", "WHEN", "WHERE", "WITH", "WITHOUT", "ADMIN", 
		"AVG", "BETWEEN", "BY", "CENTURY", "CHARACTER", "CHECK", "COLLECT", "COALESCE", 
		"COLUMN", "COMMENT", "COMMENTS", "COMMIT", "COUNT", "CUBE", "DATA", "DAY", 
		"DEC", "DECADE", "DOW", "DOY", "DROP", "EPOCH", "EVERY", "EXISTS", "EXTERNAL", 
		"EXTRACT", "FILTER", "FIRST", "FORMAT", "FUSION", "GROUPING", "HASH", 
		"HOUR", "INDEX", "INDEXES", "INSERT", "INTERSECTION", "ISODOW", "ISOYEAR", 
		"LANGUAGE", "LARGE", "LAST", "LESS", "LIST", "LOCATION", "MATCH", "MAX", 
		"MAXVALUE", "MICROSECONDS", "MILLENNIUM", "MILLISECONDS", "MIN", "MINUTE", 
		"MONTH", "NATIONAL", "NULLIF", "OBJECT", "OPTION", "OPTIONS", "OVERWRITE", 
		"PARTIAL", "PARTITION", "PARTITIONS", "PRECISION", "PUBLIC", "PURGE", 
		"QUARTER", "RANGE", "REGEXP", "RLIKE", "ROLLUP", "SECOND", "SERVER", "SET", 
		"SIMILAR", "SIMPLE", "STORAGE", "STDDEV_POP", "STDDEV_SAMP", "SUBPARTITION", 
		"SUM", "TABLESPACE", "TABLES", "THAN", "TIMEZONE", "TIMEZONE_HOUR", "TIMEZONE_MINUTE", 
		"TRIM", "TO", "UNKNOWN", "UNLOGGED", "VALUES", "VAR_SAMP", "VAR_POP", 
		"VARYING", "VERSION", "WEEK", "WRAPPER", "YEAR", "ZONE", "BOOLEAN", "BOOL", 
		"BIT", "VARBIT", "INT1", "INT2", "INT4", "INT8", "TINYINT", "SMALLINT", 
		"INT", "INTEGER", "BIGINT", "FLOAT4", "FLOAT8", "REAL", "REGCLASS", "FLOAT", 
		"DOUBLE", "NUMERIC", "DECIMAL", "CHAR", "VARCHAR", "NCHAR", "NVARCHAR", 
		"DATE", "TIME", "TIMETZ", "TIMESTAMP", "TIMESTAMPTZ", "TEXT", "BINARY", 
		"VARBINARY", "BLOB", "BYTEA", "INET4", "'~'", "'!~'", "'~*'", "'!~*'", 
		"CAST_EXPRESSION", "':='", "'='", "':'", "';'", "','", "CONCATENATION_OPERATOR", 
		"NOT_EQUAL", "'<'", "'<='", "'>'", "'>='", "'('", "')'", "'+'", "'-'", 
		"'*'", "'/'", "'%'", "'.'", "'_'", "'|'", "'''", "'\"'", "NUMBER", "REAL_NUMBER", 
		"BlockComment", "LineComment", "Identifier", "Character_String_Literal", 
		"' '", "White_Space", "BAD"
	};
	public static final int
		RULE_sql = 0, RULE_statement = 1, RULE_data_statement = 2, RULE_data_change_statement = 3, 
		RULE_schema_statement = 4, RULE_index_statement = 5, RULE_create_extension_statement = 6, 
		RULE_set_statement = 7, RULE_create_trigger_statement = 8, RULE_revoke_statement = 9, 
		RULE_grant_statement = 10, RULE_grant_to_rule = 11, RULE_argmode = 12, 
		RULE_function_definition = 13, RULE_functions_definition_schema = 14, 
		RULE_create_table_statement = 15, RULE_like_option = 16, RULE_table_constraint = 17, 
		RULE_column_constraint = 18, RULE_check_boolean_expression = 19, RULE_storage_parameter = 20, 
		RULE_storage_parameter_oid = 21, RULE_on_commit = 22, RULE_table_space = 23, 
		RULE_action = 24, RULE_index_parameters = 25, RULE_table_elements = 26, 
		RULE_field_element = 27, RULE_field_type = 28, RULE_param_clause = 29, 
		RULE_param = 30, RULE_method_specifier = 31, RULE_table_space_specifier = 32, 
		RULE_table_space_name = 33, RULE_table_partitioning_clauses = 34, RULE_range_partitions = 35, 
		RULE_range_value_clause_list = 36, RULE_range_value_clause = 37, RULE_hash_partitions = 38, 
		RULE_individual_hash_partitions = 39, RULE_individual_hash_partition = 40, 
		RULE_hash_partitions_by_quantity = 41, RULE_list_partitions = 42, RULE_list_value_clause_list = 43, 
		RULE_list_value_partition = 44, RULE_column_partitions = 45, RULE_partition_name = 46, 
		RULE_drop_table_statement = 47, RULE_identifier = 48, RULE_nonreserved_keywords = 49, 
		RULE_unsigned_literal = 50, RULE_general_literal = 51, RULE_datetime_literal = 52, 
		RULE_time_literal = 53, RULE_timestamp_literal = 54, RULE_date_literal = 55, 
		RULE_boolean_literal = 56, RULE_data_type = 57, RULE_predefined_type = 58, 
		RULE_regclass = 59, RULE_network_type = 60, RULE_character_string_type = 61, 
		RULE_type_length = 62, RULE_national_character_string_type = 63, RULE_binary_large_object_string_type = 64, 
		RULE_numeric_type = 65, RULE_exact_numeric_type = 66, RULE_approximate_numeric_type = 67, 
		RULE_precision_param = 68, RULE_boolean_type = 69, RULE_datetime_type = 70, 
		RULE_bit_type = 71, RULE_binary_type = 72, RULE_value_expression_primary = 73, 
		RULE_parenthesized_value_expression = 74, RULE_nonparenthesized_value_expression_primary = 75, 
		RULE_unsigned_value_specification = 76, RULE_unsigned_numeric_literal = 77, 
		RULE_signed_numerical_literal = 78, RULE_set_function_specification = 79, 
		RULE_aggregate_function = 80, RULE_general_set_function = 81, RULE_set_function_type = 82, 
		RULE_filter_clause = 83, RULE_grouping_operation = 84, RULE_case_expression = 85, 
		RULE_case_abbreviation = 86, RULE_case_specification = 87, RULE_simple_case = 88, 
		RULE_searched_case = 89, RULE_simple_when_clause = 90, RULE_searched_when_clause = 91, 
		RULE_else_clause = 92, RULE_result = 93, RULE_cast_specification = 94, 
		RULE_cast_operand = 95, RULE_cast_target = 96, RULE_value_expression = 97, 
		RULE_common_value_expression = 98, RULE_numeric_value_expression = 99, 
		RULE_term = 100, RULE_factor = 101, RULE_array = 102, RULE_numeric_primary = 103, 
		RULE_sign = 104, RULE_numeric_value_function = 105, RULE_extract_expression = 106, 
		RULE_extract_field = 107, RULE_time_zone_field = 108, RULE_extract_source = 109, 
		RULE_string_value_expression = 110, RULE_character_value_expression = 111, 
		RULE_character_factor = 112, RULE_character_primary = 113, RULE_string_value_function = 114, 
		RULE_trim_function = 115, RULE_trim_operands = 116, RULE_trim_specification = 117, 
		RULE_boolean_value_expression = 118, RULE_or_predicate = 119, RULE_and_predicate = 120, 
		RULE_boolean_factor = 121, RULE_boolean_test = 122, RULE_is_clause = 123, 
		RULE_truth_value = 124, RULE_boolean_primary = 125, RULE_boolean_predicand = 126, 
		RULE_parenthesized_boolean_value_expression = 127, RULE_row_value_expression = 128, 
		RULE_row_value_special_case = 129, RULE_explicit_row_value_constructor = 130, 
		RULE_row_value_predicand = 131, RULE_row_value_constructor_predicand = 132, 
		RULE_table_expression = 133, RULE_from_clause = 134, RULE_table_reference_list = 135, 
		RULE_table_reference = 136, RULE_joined_table = 137, RULE_joined_table_primary = 138, 
		RULE_cross_join = 139, RULE_qualified_join = 140, RULE_natural_join = 141, 
		RULE_union_join = 142, RULE_join_type = 143, RULE_outer_join_type = 144, 
		RULE_outer_join_type_part2 = 145, RULE_join_specification = 146, RULE_join_condition = 147, 
		RULE_named_columns_join = 148, RULE_table_primary = 149, RULE_column_name_list = 150, 
		RULE_derived_table = 151, RULE_where_clause = 152, RULE_search_condition = 153, 
		RULE_groupby_clause = 154, RULE_grouping_element_list = 155, RULE_grouping_element = 156, 
		RULE_ordinary_grouping_set = 157, RULE_ordinary_grouping_set_list = 158, 
		RULE_rollup_list = 159, RULE_cube_list = 160, RULE_empty_grouping_set = 161, 
		RULE_having_clause = 162, RULE_row_value_predicand_list = 163, RULE_query_expression = 164, 
		RULE_query_expression_body = 165, RULE_non_join_query_expression = 166, 
		RULE_query_term = 167, RULE_non_join_query_term = 168, RULE_query_primary = 169, 
		RULE_non_join_query_primary = 170, RULE_simple_table = 171, RULE_explicit_table = 172, 
		RULE_table_or_query_name = 173, RULE_table_name = 174, RULE_query_specification = 175, 
		RULE_select_list = 176, RULE_select_sublist = 177, RULE_derived_column = 178, 
		RULE_qualified_asterisk = 179, RULE_set_qualifier = 180, RULE_column_reference = 181, 
		RULE_as_clause = 182, RULE_column_reference_list = 183, RULE_scalar_subquery = 184, 
		RULE_row_subquery = 185, RULE_table_subquery = 186, RULE_subquery = 187, 
		RULE_predicate = 188, RULE_comparison_predicate = 189, RULE_comp_op = 190, 
		RULE_between_predicate = 191, RULE_between_predicate_part_2 = 192, RULE_in_predicate = 193, 
		RULE_in_predicate_value = 194, RULE_in_value_list = 195, RULE_pattern_matching_predicate = 196, 
		RULE_pattern_matcher = 197, RULE_negativable_matcher = 198, RULE_regex_matcher = 199, 
		RULE_null_predicate = 200, RULE_quantified_comparison_predicate = 201, 
		RULE_quantifier = 202, RULE_all = 203, RULE_some = 204, RULE_exists_predicate = 205, 
		RULE_unique_predicate = 206, RULE_primary_datetime_field = 207, RULE_non_second_primary_datetime_field = 208, 
		RULE_extended_datetime_field = 209, RULE_routine_invocation = 210, RULE_function_names_for_reserved_words = 211, 
		RULE_function_name = 212, RULE_sql_argument_list = 213, RULE_orderby_clause = 214, 
		RULE_sort_specifier_list = 215, RULE_sort_specifier = 216, RULE_order_specification = 217, 
		RULE_limit_clause = 218, RULE_null_ordering = 219, RULE_insert_statement = 220;
	public static final String[] ruleNames = {
		"sql", "statement", "data_statement", "data_change_statement", "schema_statement", 
		"index_statement", "create_extension_statement", "set_statement", "create_trigger_statement", 
		"revoke_statement", "grant_statement", "grant_to_rule", "argmode", "function_definition", 
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
			setState(446); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(442); statement();
				setState(444);
				_la = _input.LA(1);
				if (_la==SEMI_COLON) {
					{
					setState(443); match(SEMI_COLON);
					}
				}

				}
				}
				setState(448); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==CREATE || _la==GRANT || ((((_la - 85)) & ~0x3f) == 0 && ((1L << (_la - 85)) & ((1L << (REVOKE - 85)) | (1L << (SELECT - 85)) | (1L << (TABLE - 85)) | (1L << (ADMIN - 85)) | (1L << (AVG - 85)) | (1L << (BETWEEN - 85)) | (1L << (BY - 85)) | (1L << (CENTURY - 85)) | (1L << (CHARACTER - 85)) | (1L << (CHECK - 85)) | (1L << (COLLECT - 85)) | (1L << (COALESCE - 85)) | (1L << (COLUMN - 85)) | (1L << (COMMENT - 85)) | (1L << (COMMENTS - 85)) | (1L << (COMMIT - 85)) | (1L << (COUNT - 85)) | (1L << (CUBE - 85)) | (1L << (DATA - 85)) | (1L << (DAY - 85)) | (1L << (DEC - 85)) | (1L << (DECADE - 85)) | (1L << (DOW - 85)) | (1L << (DOY - 85)) | (1L << (DROP - 85)) | (1L << (EPOCH - 85)) | (1L << (EVERY - 85)) | (1L << (EXISTS - 85)) | (1L << (EXTERNAL - 85)) | (1L << (EXTRACT - 85)) | (1L << (FILTER - 85)) | (1L << (FIRST - 85)) | (1L << (FORMAT - 85)) | (1L << (FUSION - 85)) | (1L << (GROUPING - 85)) | (1L << (HASH - 85)) | (1L << (INDEX - 85)))) != 0) || ((((_la - 149)) & ~0x3f) == 0 && ((1L << (_la - 149)) & ((1L << (INSERT - 149)) | (1L << (INTERSECTION - 149)) | (1L << (ISODOW - 149)) | (1L << (ISOYEAR - 149)) | (1L << (LANGUAGE - 149)) | (1L << (LARGE - 149)) | (1L << (LAST - 149)) | (1L << (LESS - 149)) | (1L << (LIST - 149)) | (1L << (LOCATION - 149)) | (1L << (MATCH - 149)) | (1L << (MAX - 149)) | (1L << (MAXVALUE - 149)) | (1L << (MICROSECONDS - 149)) | (1L << (MILLENNIUM - 149)) | (1L << (MILLISECONDS - 149)) | (1L << (MIN - 149)) | (1L << (MINUTE - 149)) | (1L << (MONTH - 149)) | (1L << (NATIONAL - 149)) | (1L << (NULLIF - 149)) | (1L << (OBJECT - 149)) | (1L << (OPTION - 149)) | (1L << (OPTIONS - 149)) | (1L << (OVERWRITE - 149)) | (1L << (PARTIAL - 149)) | (1L << (PARTITION - 149)) | (1L << (PARTITIONS - 149)) | (1L << (PRECISION - 149)) | (1L << (PUBLIC - 149)) | (1L << (PURGE - 149)) | (1L << (QUARTER - 149)) | (1L << (RANGE - 149)) | (1L << (REGEXP - 149)) | (1L << (RLIKE - 149)) | (1L << (ROLLUP - 149)) | (1L << (SECOND - 149)) | (1L << (SERVER - 149)) | (1L << (SET - 149)) | (1L << (SIMILAR - 149)) | (1L << (SIMPLE - 149)) | (1L << (STORAGE - 149)) | (1L << (STDDEV_POP - 149)) | (1L << (STDDEV_SAMP - 149)) | (1L << (SUBPARTITION - 149)) | (1L << (SUM - 149)) | (1L << (TABLESPACE - 149)) | (1L << (THAN - 149)) | (1L << (TIMEZONE - 149)) | (1L << (TIMEZONE_HOUR - 149)) | (1L << (TIMEZONE_MINUTE - 149)) | (1L << (TRIM - 149)) | (1L << (TO - 149)) | (1L << (UNKNOWN - 149)) | (1L << (UNLOGGED - 149)) | (1L << (VALUES - 149)) | (1L << (VAR_SAMP - 149)) | (1L << (VAR_POP - 149)) | (1L << (VARYING - 149)) | (1L << (WEEK - 149)) | (1L << (WRAPPER - 149)) | (1L << (YEAR - 149)))) != 0) || ((((_la - 213)) & ~0x3f) == 0 && ((1L << (_la - 213)) & ((1L << (ZONE - 213)) | (1L << (BOOLEAN - 213)) | (1L << (BOOL - 213)) | (1L << (BIT - 213)) | (1L << (VARBIT - 213)) | (1L << (INT1 - 213)) | (1L << (INT2 - 213)) | (1L << (INT4 - 213)) | (1L << (INT8 - 213)) | (1L << (TINYINT - 213)) | (1L << (SMALLINT - 213)) | (1L << (INT - 213)) | (1L << (INTEGER - 213)) | (1L << (BIGINT - 213)) | (1L << (FLOAT4 - 213)) | (1L << (FLOAT8 - 213)) | (1L << (REAL - 213)) | (1L << (FLOAT - 213)) | (1L << (DOUBLE - 213)) | (1L << (NUMERIC - 213)) | (1L << (DECIMAL - 213)) | (1L << (CHAR - 213)) | (1L << (VARCHAR - 213)) | (1L << (NCHAR - 213)) | (1L << (NVARCHAR - 213)) | (1L << (DATE - 213)) | (1L << (TIME - 213)) | (1L << (TIMETZ - 213)) | (1L << (TIMESTAMP - 213)) | (1L << (TIMESTAMPTZ - 213)) | (1L << (TEXT - 213)) | (1L << (VARBINARY - 213)) | (1L << (BLOB - 213)) | (1L << (BYTEA - 213)) | (1L << (INET4 - 213)) | (1L << (LEFT_PAREN - 213)) | (1L << (QUOTE - 213)))) != 0) || _la==Identifier );
			setState(450); match(EOF);
			}
		}
		catch (RecognitionException re) {
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
			setState(461);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(452); data_statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(453); data_change_statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(454); schema_statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(455); index_statement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(456); create_extension_statement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(457); set_statement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(458); create_trigger_statement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(459); grant_statement();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(460); revoke_statement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
			setState(463); query_expression();
			}
		}
		catch (RecognitionException re) {
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
			setState(465); insert_statement();
			}
		}
		catch (RecognitionException re) {
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
			setState(469);
			switch (_input.LA(1)) {
			case CREATE:
				enterOuterAlt(_localctx, 1);
				{
				setState(467); create_table_statement();
				}
				break;
			case DROP:
				enterOuterAlt(_localctx, 2);
				{
				setState(468); drop_table_statement();
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
			setState(471); match(CREATE);
			setState(473);
			_la = _input.LA(1);
			if (_la==UNIQUE) {
				{
				setState(472); ((Index_statementContext)_localctx).u = match(UNIQUE);
				}
			}

			setState(475); match(INDEX);
			setState(476); ((Index_statementContext)_localctx).n = identifier();
			setState(477); match(ON);
			setState(478); ((Index_statementContext)_localctx).t = table_name();
			setState(480);
			_la = _input.LA(1);
			if (_la==USING) {
				{
				setState(479); ((Index_statementContext)_localctx).m = method_specifier();
				}
			}

			setState(482); match(LEFT_PAREN);
			setState(483); ((Index_statementContext)_localctx).s = sort_specifier_list();
			setState(484); match(RIGHT_PAREN);
			setState(486);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(485); ((Index_statementContext)_localctx).p = param_clause();
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
			setState(488); match(CREATE);
			setState(489); match(EXTENSION);
			setState(493);
			_la = _input.LA(1);
			if (_la==IF) {
				{
				setState(490); match(IF);
				setState(491); match(NOT);
				setState(492); match(EXISTS);
				}
			}

			setState(495); ((Create_extension_statementContext)_localctx).name = identifier();
			setState(497);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(496); match(WITH);
				}
			}

			setState(501);
			_la = _input.LA(1);
			if (_la==SCHEMA) {
				{
				setState(499); match(SCHEMA);
				setState(500); ((Create_extension_statementContext)_localctx).schema_name = identifier();
				}
			}

			setState(505);
			_la = _input.LA(1);
			if (_la==VERSION) {
				{
				setState(503); match(VERSION);
				setState(504); ((Create_extension_statementContext)_localctx).version = identifier();
				}
			}

			setState(509);
			_la = _input.LA(1);
			if (_la==FROM) {
				{
				setState(507); match(FROM);
				setState(508); ((Create_extension_statementContext)_localctx).old_version = identifier();
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
			setState(550);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(511); match(SET);
				setState(513);
				_la = _input.LA(1);
				if (_la==LOCAL || _la==SESSION) {
					{
					setState(512);
					_la = _input.LA(1);
					if ( !(_la==LOCAL || _la==SESSION) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(515); ((Set_statementContext)_localctx).config_param = identifier();
				setState(516);
				_la = _input.LA(1);
				if ( !(_la==TO || _la==EQUAL) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(528); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(523);
						switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
						case 1:
							{
							setState(517); ((Set_statementContext)_localctx).value = identifier();
							}
							break;
						case 2:
							{
							setState(518); match(QUOTE);
							setState(519); ((Set_statementContext)_localctx).value = identifier();
							setState(520); match(QUOTE);
							}
							break;
						case 3:
							{
							setState(522); match(DEFAULT);
							}
							break;
						}
						setState(526);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(525); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(530); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(532); match(SET);
				setState(534);
				_la = _input.LA(1);
				if (_la==LOCAL || _la==SESSION) {
					{
					setState(533);
					_la = _input.LA(1);
					if ( !(_la==LOCAL || _la==SESSION) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(536); match(TIME);
				setState(537); match(ZONE);
				setState(546); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(541);
						switch (_input.LA(1)) {
						case ADMIN:
						case AVG:
						case BETWEEN:
						case BY:
						case CENTURY:
						case CHARACTER:
						case CHECK:
						case COLLECT:
						case COALESCE:
						case COLUMN:
						case COMMENT:
						case COMMENTS:
						case COMMIT:
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
							setState(538); ((Set_statementContext)_localctx).timezone = identifier();
							}
							break;
						case LOCAL:
							{
							setState(539); match(LOCAL);
							}
							break;
						case DEFAULT:
							{
							setState(540); match(DEFAULT);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(544);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(543); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(548); 
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
			setState(552); match(CREATE);
			setState(554);
			_la = _input.LA(1);
			if (_la==CONSTRAINT) {
				{
				setState(553); match(CONSTRAINT);
				}
			}

			setState(556); match(TRIGGER);
			setState(557); ((Create_trigger_statementContext)_localctx).name = identifier();
			setState(562);
			switch (_input.LA(1)) {
			case BEFORE:
				{
				setState(558); match(BEFORE);
				}
				break;
			case INSTEAD:
				{
				{
				setState(559); match(INSTEAD);
				setState(560); match(OF);
				}
				}
				break;
			case AFTER:
				{
				setState(561); match(AFTER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(579);
			switch (_input.LA(1)) {
			case INSERT:
				{
				setState(564); match(INSERT);
				}
				break;
			case DELETE:
				{
				setState(565); match(DELETE);
				}
				break;
			case TRUNCATE:
				{
				setState(566); match(TRUNCATE);
				}
				break;
			case UPDATE:
				{
				{
				setState(567); match(UPDATE);
				setState(577);
				_la = _input.LA(1);
				if (_la==OF) {
					{
					setState(568); match(OF);
					setState(573); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(569); ((Create_trigger_statementContext)_localctx).columnName = identifier();
						setState(571);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(570); match(COMMA);
							}
						}

						}
						}
						setState(575); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 113)) & ~0x3f) == 0 && ((1L << (_la - 113)) & ((1L << (ADMIN - 113)) | (1L << (AVG - 113)) | (1L << (BETWEEN - 113)) | (1L << (BY - 113)) | (1L << (CENTURY - 113)) | (1L << (CHARACTER - 113)) | (1L << (CHECK - 113)) | (1L << (COLLECT - 113)) | (1L << (COALESCE - 113)) | (1L << (COLUMN - 113)) | (1L << (COMMENT - 113)) | (1L << (COMMENTS - 113)) | (1L << (COMMIT - 113)) | (1L << (COUNT - 113)) | (1L << (CUBE - 113)) | (1L << (DATA - 113)) | (1L << (DAY - 113)) | (1L << (DEC - 113)) | (1L << (DECADE - 113)) | (1L << (DOW - 113)) | (1L << (DOY - 113)) | (1L << (DROP - 113)) | (1L << (EPOCH - 113)) | (1L << (EVERY - 113)) | (1L << (EXISTS - 113)) | (1L << (EXTERNAL - 113)) | (1L << (EXTRACT - 113)) | (1L << (FILTER - 113)) | (1L << (FIRST - 113)) | (1L << (FORMAT - 113)) | (1L << (FUSION - 113)) | (1L << (GROUPING - 113)) | (1L << (HASH - 113)) | (1L << (INDEX - 113)) | (1L << (INSERT - 113)) | (1L << (INTERSECTION - 113)) | (1L << (ISODOW - 113)) | (1L << (ISOYEAR - 113)) | (1L << (LANGUAGE - 113)) | (1L << (LARGE - 113)) | (1L << (LAST - 113)) | (1L << (LESS - 113)) | (1L << (LIST - 113)) | (1L << (LOCATION - 113)) | (1L << (MATCH - 113)) | (1L << (MAX - 113)) | (1L << (MAXVALUE - 113)) | (1L << (MICROSECONDS - 113)) | (1L << (MILLENNIUM - 113)) | (1L << (MILLISECONDS - 113)) | (1L << (MIN - 113)) | (1L << (MINUTE - 113)) | (1L << (MONTH - 113)) | (1L << (NATIONAL - 113)) | (1L << (NULLIF - 113)) | (1L << (OBJECT - 113)) | (1L << (OPTION - 113)) | (1L << (OPTIONS - 113)) | (1L << (OVERWRITE - 113)) | (1L << (PARTIAL - 113)) | (1L << (PARTITION - 113)) | (1L << (PARTITIONS - 113)))) != 0) || ((((_la - 177)) & ~0x3f) == 0 && ((1L << (_la - 177)) & ((1L << (PRECISION - 177)) | (1L << (PUBLIC - 177)) | (1L << (PURGE - 177)) | (1L << (QUARTER - 177)) | (1L << (RANGE - 177)) | (1L << (REGEXP - 177)) | (1L << (RLIKE - 177)) | (1L << (ROLLUP - 177)) | (1L << (SECOND - 177)) | (1L << (SERVER - 177)) | (1L << (SET - 177)) | (1L << (SIMILAR - 177)) | (1L << (SIMPLE - 177)) | (1L << (STORAGE - 177)) | (1L << (STDDEV_POP - 177)) | (1L << (STDDEV_SAMP - 177)) | (1L << (SUBPARTITION - 177)) | (1L << (SUM - 177)) | (1L << (TABLESPACE - 177)) | (1L << (THAN - 177)) | (1L << (TIMEZONE - 177)) | (1L << (TIMEZONE_HOUR - 177)) | (1L << (TIMEZONE_MINUTE - 177)) | (1L << (TRIM - 177)) | (1L << (TO - 177)) | (1L << (UNKNOWN - 177)) | (1L << (UNLOGGED - 177)) | (1L << (VALUES - 177)) | (1L << (VAR_SAMP - 177)) | (1L << (VAR_POP - 177)) | (1L << (VARYING - 177)) | (1L << (WEEK - 177)) | (1L << (WRAPPER - 177)) | (1L << (YEAR - 177)) | (1L << (ZONE - 177)) | (1L << (BOOLEAN - 177)) | (1L << (BOOL - 177)) | (1L << (BIT - 177)) | (1L << (VARBIT - 177)) | (1L << (INT1 - 177)) | (1L << (INT2 - 177)) | (1L << (INT4 - 177)) | (1L << (INT8 - 177)) | (1L << (TINYINT - 177)) | (1L << (SMALLINT - 177)) | (1L << (INT - 177)) | (1L << (INTEGER - 177)) | (1L << (BIGINT - 177)) | (1L << (FLOAT4 - 177)) | (1L << (FLOAT8 - 177)) | (1L << (REAL - 177)) | (1L << (FLOAT - 177)) | (1L << (DOUBLE - 177)) | (1L << (NUMERIC - 177)) | (1L << (DECIMAL - 177)) | (1L << (CHAR - 177)) | (1L << (VARCHAR - 177)) | (1L << (NCHAR - 177)) | (1L << (NVARCHAR - 177)) | (1L << (DATE - 177)) | (1L << (TIME - 177)))) != 0) || ((((_la - 241)) & ~0x3f) == 0 && ((1L << (_la - 241)) & ((1L << (TIMETZ - 241)) | (1L << (TIMESTAMP - 241)) | (1L << (TIMESTAMPTZ - 241)) | (1L << (TEXT - 241)) | (1L << (VARBINARY - 241)) | (1L << (BLOB - 241)) | (1L << (BYTEA - 241)) | (1L << (INET4 - 241)) | (1L << (QUOTE - 241)) | (1L << (Identifier - 241)))) != 0) );
					}
				}

				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(581); match(ON);
			setState(582); ((Create_trigger_statementContext)_localctx).tabl_name = table_name();
			setState(585);
			_la = _input.LA(1);
			if (_la==FROM) {
				{
				setState(583); match(FROM);
				setState(584); ((Create_trigger_statementContext)_localctx).referenced_table_name = table_name();
				}
			}

			setState(596);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				{
				setState(587); match(NOT);
				setState(588); match(DEFERRABLE);
				}
				break;
			case 2:
				{
				setState(590);
				_la = _input.LA(1);
				if (_la==DEFERRABLE) {
					{
					setState(589); match(DEFERRABLE);
					}
				}

				{
				setState(592); match(INITIALLY);
				setState(593); match(IMMEDIATE);
				}
				}
				break;
			case 3:
				{
				{
				setState(594); match(INITIALLY);
				setState(595); match(DEFERRED);
				}
				}
				break;
			}
			setState(604);
			switch (_input.LA(1)) {
			case FOR:
				{
				setState(598); match(FOR);
				setState(600);
				_la = _input.LA(1);
				if (_la==EACH) {
					{
					setState(599); match(EACH);
					}
				}

				setState(602); match(ROW);
				}
				break;
			case STATEMENT:
				{
				setState(603); match(STATEMENT);
				}
				break;
			case EXECUTE:
			case WHEN:
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(608);
			_la = _input.LA(1);
			if (_la==WHEN) {
				{
				setState(606); match(WHEN);
				{
				setState(607); boolean_value_expression();
				}
				}
			}

			setState(610); match(EXECUTE);
			setState(611); match(PROCEDURE);
			setState(612); ((Create_trigger_statementContext)_localctx).func_name = identifier();
			setState(613); match(LEFT_PAREN);
			setState(618);
			_la = _input.LA(1);
			if (((((_la - 113)) & ~0x3f) == 0 && ((1L << (_la - 113)) & ((1L << (ADMIN - 113)) | (1L << (AVG - 113)) | (1L << (BETWEEN - 113)) | (1L << (BY - 113)) | (1L << (CENTURY - 113)) | (1L << (CHARACTER - 113)) | (1L << (CHECK - 113)) | (1L << (COLLECT - 113)) | (1L << (COALESCE - 113)) | (1L << (COLUMN - 113)) | (1L << (COMMENT - 113)) | (1L << (COMMENTS - 113)) | (1L << (COMMIT - 113)) | (1L << (COUNT - 113)) | (1L << (CUBE - 113)) | (1L << (DATA - 113)) | (1L << (DAY - 113)) | (1L << (DEC - 113)) | (1L << (DECADE - 113)) | (1L << (DOW - 113)) | (1L << (DOY - 113)) | (1L << (DROP - 113)) | (1L << (EPOCH - 113)) | (1L << (EVERY - 113)) | (1L << (EXISTS - 113)) | (1L << (EXTERNAL - 113)) | (1L << (EXTRACT - 113)) | (1L << (FILTER - 113)) | (1L << (FIRST - 113)) | (1L << (FORMAT - 113)) | (1L << (FUSION - 113)) | (1L << (GROUPING - 113)) | (1L << (HASH - 113)) | (1L << (INDEX - 113)) | (1L << (INSERT - 113)) | (1L << (INTERSECTION - 113)) | (1L << (ISODOW - 113)) | (1L << (ISOYEAR - 113)) | (1L << (LANGUAGE - 113)) | (1L << (LARGE - 113)) | (1L << (LAST - 113)) | (1L << (LESS - 113)) | (1L << (LIST - 113)) | (1L << (LOCATION - 113)) | (1L << (MATCH - 113)) | (1L << (MAX - 113)) | (1L << (MAXVALUE - 113)) | (1L << (MICROSECONDS - 113)) | (1L << (MILLENNIUM - 113)) | (1L << (MILLISECONDS - 113)) | (1L << (MIN - 113)) | (1L << (MINUTE - 113)) | (1L << (MONTH - 113)) | (1L << (NATIONAL - 113)) | (1L << (NULLIF - 113)) | (1L << (OBJECT - 113)) | (1L << (OPTION - 113)) | (1L << (OPTIONS - 113)) | (1L << (OVERWRITE - 113)) | (1L << (PARTIAL - 113)) | (1L << (PARTITION - 113)) | (1L << (PARTITIONS - 113)))) != 0) || ((((_la - 177)) & ~0x3f) == 0 && ((1L << (_la - 177)) & ((1L << (PRECISION - 177)) | (1L << (PUBLIC - 177)) | (1L << (PURGE - 177)) | (1L << (QUARTER - 177)) | (1L << (RANGE - 177)) | (1L << (REGEXP - 177)) | (1L << (RLIKE - 177)) | (1L << (ROLLUP - 177)) | (1L << (SECOND - 177)) | (1L << (SERVER - 177)) | (1L << (SET - 177)) | (1L << (SIMILAR - 177)) | (1L << (SIMPLE - 177)) | (1L << (STORAGE - 177)) | (1L << (STDDEV_POP - 177)) | (1L << (STDDEV_SAMP - 177)) | (1L << (SUBPARTITION - 177)) | (1L << (SUM - 177)) | (1L << (TABLESPACE - 177)) | (1L << (THAN - 177)) | (1L << (TIMEZONE - 177)) | (1L << (TIMEZONE_HOUR - 177)) | (1L << (TIMEZONE_MINUTE - 177)) | (1L << (TRIM - 177)) | (1L << (TO - 177)) | (1L << (UNKNOWN - 177)) | (1L << (UNLOGGED - 177)) | (1L << (VALUES - 177)) | (1L << (VAR_SAMP - 177)) | (1L << (VAR_POP - 177)) | (1L << (VARYING - 177)) | (1L << (WEEK - 177)) | (1L << (WRAPPER - 177)) | (1L << (YEAR - 177)) | (1L << (ZONE - 177)) | (1L << (BOOLEAN - 177)) | (1L << (BOOL - 177)) | (1L << (BIT - 177)) | (1L << (VARBIT - 177)) | (1L << (INT1 - 177)) | (1L << (INT2 - 177)) | (1L << (INT4 - 177)) | (1L << (INT8 - 177)) | (1L << (TINYINT - 177)) | (1L << (SMALLINT - 177)) | (1L << (INT - 177)) | (1L << (INTEGER - 177)) | (1L << (BIGINT - 177)) | (1L << (FLOAT4 - 177)) | (1L << (FLOAT8 - 177)) | (1L << (REAL - 177)) | (1L << (FLOAT - 177)) | (1L << (DOUBLE - 177)) | (1L << (NUMERIC - 177)) | (1L << (DECIMAL - 177)) | (1L << (CHAR - 177)) | (1L << (VARCHAR - 177)) | (1L << (NCHAR - 177)) | (1L << (NVARCHAR - 177)) | (1L << (DATE - 177)) | (1L << (TIME - 177)))) != 0) || ((((_la - 241)) & ~0x3f) == 0 && ((1L << (_la - 241)) & ((1L << (TIMETZ - 241)) | (1L << (TIMESTAMP - 241)) | (1L << (TIMESTAMPTZ - 241)) | (1L << (TEXT - 241)) | (1L << (VARBINARY - 241)) | (1L << (BLOB - 241)) | (1L << (BYTEA - 241)) | (1L << (INET4 - 241)) | (1L << (QUOTE - 241)) | (1L << (Identifier - 241)))) != 0)) {
				{
				setState(614); ((Create_trigger_statementContext)_localctx).arguments = identifier();
				setState(616);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(615); match(COMMA);
					}
				}

				}
			}

			setState(620); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
			setState(706);
			switch ( getInterpreter().adaptivePredict(_input,56,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(622); match(REVOKE);
				setState(626);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(623); match(GRANT);
					setState(624); match(OPTION);
					setState(625); match(FOR);
					}
				}

				setState(633);
				switch (_input.LA(1)) {
				case EXECUTE:
					{
					setState(628); match(EXECUTE);
					}
					break;
				case ALL:
					{
					setState(629); match(ALL);
					setState(631);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(630); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(635); match(ON);
				setState(638);
				switch (_input.LA(1)) {
				case FUNCTION:
					{
					setState(636); function_definition();
					}
					break;
				case ALL:
					{
					setState(637); functions_definition_schema();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(640); match(FROM);
				setState(651); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(646);
						switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
						case 1:
							{
							{
							setState(642);
							_la = _input.LA(1);
							if (_la==GROUP) {
								{
								setState(641); match(GROUP);
								}
							}

							setState(644); ((Revoke_statementContext)_localctx).role_name = identifier();
							}
							}
							break;
						case 2:
							{
							setState(645); match(PUBLIC);
							}
							break;
						}
						setState(649);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(648); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(653); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(656);
				_la = _input.LA(1);
				if (_la==CASCADE || _la==RESTRICT) {
					{
					setState(655);
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
				setState(658); match(REVOKE);
				setState(662);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(659); match(GRANT);
					setState(660); match(OPTION);
					setState(661); match(FOR);
					}
				}

				setState(676);
				switch (_input.LA(1)) {
				case CREATE:
				case USAGE:
					{
					setState(668); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(664);
						_la = _input.LA(1);
						if ( !(_la==CREATE || _la==USAGE) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(666);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(665); match(COMMA);
							}
						}

						}
						}
						setState(670); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==CREATE || _la==USAGE );
					}
					break;
				case ALL:
					{
					setState(672); match(ALL);
					setState(674);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(673); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(678); match(ON);
				setState(679); match(SCHEMA);
				setState(684); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(680); ((Revoke_statementContext)_localctx).schema_name = identifier();
					setState(682);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(681); match(COMMA);
						}
					}

					}
					}
					setState(686); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 113)) & ~0x3f) == 0 && ((1L << (_la - 113)) & ((1L << (ADMIN - 113)) | (1L << (AVG - 113)) | (1L << (BETWEEN - 113)) | (1L << (BY - 113)) | (1L << (CENTURY - 113)) | (1L << (CHARACTER - 113)) | (1L << (CHECK - 113)) | (1L << (COLLECT - 113)) | (1L << (COALESCE - 113)) | (1L << (COLUMN - 113)) | (1L << (COMMENT - 113)) | (1L << (COMMENTS - 113)) | (1L << (COMMIT - 113)) | (1L << (COUNT - 113)) | (1L << (CUBE - 113)) | (1L << (DATA - 113)) | (1L << (DAY - 113)) | (1L << (DEC - 113)) | (1L << (DECADE - 113)) | (1L << (DOW - 113)) | (1L << (DOY - 113)) | (1L << (DROP - 113)) | (1L << (EPOCH - 113)) | (1L << (EVERY - 113)) | (1L << (EXISTS - 113)) | (1L << (EXTERNAL - 113)) | (1L << (EXTRACT - 113)) | (1L << (FILTER - 113)) | (1L << (FIRST - 113)) | (1L << (FORMAT - 113)) | (1L << (FUSION - 113)) | (1L << (GROUPING - 113)) | (1L << (HASH - 113)) | (1L << (INDEX - 113)) | (1L << (INSERT - 113)) | (1L << (INTERSECTION - 113)) | (1L << (ISODOW - 113)) | (1L << (ISOYEAR - 113)) | (1L << (LANGUAGE - 113)) | (1L << (LARGE - 113)) | (1L << (LAST - 113)) | (1L << (LESS - 113)) | (1L << (LIST - 113)) | (1L << (LOCATION - 113)) | (1L << (MATCH - 113)) | (1L << (MAX - 113)) | (1L << (MAXVALUE - 113)) | (1L << (MICROSECONDS - 113)) | (1L << (MILLENNIUM - 113)) | (1L << (MILLISECONDS - 113)) | (1L << (MIN - 113)) | (1L << (MINUTE - 113)) | (1L << (MONTH - 113)) | (1L << (NATIONAL - 113)) | (1L << (NULLIF - 113)) | (1L << (OBJECT - 113)) | (1L << (OPTION - 113)) | (1L << (OPTIONS - 113)) | (1L << (OVERWRITE - 113)) | (1L << (PARTIAL - 113)) | (1L << (PARTITION - 113)) | (1L << (PARTITIONS - 113)))) != 0) || ((((_la - 177)) & ~0x3f) == 0 && ((1L << (_la - 177)) & ((1L << (PRECISION - 177)) | (1L << (PUBLIC - 177)) | (1L << (PURGE - 177)) | (1L << (QUARTER - 177)) | (1L << (RANGE - 177)) | (1L << (REGEXP - 177)) | (1L << (RLIKE - 177)) | (1L << (ROLLUP - 177)) | (1L << (SECOND - 177)) | (1L << (SERVER - 177)) | (1L << (SET - 177)) | (1L << (SIMILAR - 177)) | (1L << (SIMPLE - 177)) | (1L << (STORAGE - 177)) | (1L << (STDDEV_POP - 177)) | (1L << (STDDEV_SAMP - 177)) | (1L << (SUBPARTITION - 177)) | (1L << (SUM - 177)) | (1L << (TABLESPACE - 177)) | (1L << (THAN - 177)) | (1L << (TIMEZONE - 177)) | (1L << (TIMEZONE_HOUR - 177)) | (1L << (TIMEZONE_MINUTE - 177)) | (1L << (TRIM - 177)) | (1L << (TO - 177)) | (1L << (UNKNOWN - 177)) | (1L << (UNLOGGED - 177)) | (1L << (VALUES - 177)) | (1L << (VAR_SAMP - 177)) | (1L << (VAR_POP - 177)) | (1L << (VARYING - 177)) | (1L << (WEEK - 177)) | (1L << (WRAPPER - 177)) | (1L << (YEAR - 177)) | (1L << (ZONE - 177)) | (1L << (BOOLEAN - 177)) | (1L << (BOOL - 177)) | (1L << (BIT - 177)) | (1L << (VARBIT - 177)) | (1L << (INT1 - 177)) | (1L << (INT2 - 177)) | (1L << (INT4 - 177)) | (1L << (INT8 - 177)) | (1L << (TINYINT - 177)) | (1L << (SMALLINT - 177)) | (1L << (INT - 177)) | (1L << (INTEGER - 177)) | (1L << (BIGINT - 177)) | (1L << (FLOAT4 - 177)) | (1L << (FLOAT8 - 177)) | (1L << (REAL - 177)) | (1L << (FLOAT - 177)) | (1L << (DOUBLE - 177)) | (1L << (NUMERIC - 177)) | (1L << (DECIMAL - 177)) | (1L << (CHAR - 177)) | (1L << (VARCHAR - 177)) | (1L << (NCHAR - 177)) | (1L << (NVARCHAR - 177)) | (1L << (DATE - 177)) | (1L << (TIME - 177)))) != 0) || ((((_la - 241)) & ~0x3f) == 0 && ((1L << (_la - 241)) & ((1L << (TIMETZ - 241)) | (1L << (TIMESTAMP - 241)) | (1L << (TIMESTAMPTZ - 241)) | (1L << (TEXT - 241)) | (1L << (VARBINARY - 241)) | (1L << (BLOB - 241)) | (1L << (BYTEA - 241)) | (1L << (INET4 - 241)) | (1L << (QUOTE - 241)) | (1L << (Identifier - 241)))) != 0) );
				setState(688); match(FROM);
				setState(699); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(694);
						switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
						case 1:
							{
							{
							setState(690);
							_la = _input.LA(1);
							if (_la==GROUP) {
								{
								setState(689); match(GROUP);
								}
							}

							setState(692); ((Revoke_statementContext)_localctx).role_name = identifier();
							}
							}
							break;
						case 2:
							{
							setState(693); match(PUBLIC);
							}
							break;
						}
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
					_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(704);
				_la = _input.LA(1);
				if (_la==CASCADE || _la==RESTRICT) {
					{
					setState(703);
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
			setState(1033);
			switch ( getInterpreter().adaptivePredict(_input,127,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(708); match(GRANT);
				setState(718);
				switch (_input.LA(1)) {
				case DELETE:
				case REFERENCES:
				case SELECT:
				case TRIGGER:
				case TRUNCATE:
				case UPDATE:
				case INSERT:
					{
					setState(710); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(709);
						_la = _input.LA(1);
						if ( !(_la==DELETE || _la==REFERENCES || ((((_la - 90)) & ~0x3f) == 0 && ((1L << (_la - 90)) & ((1L << (SELECT - 90)) | (1L << (TRIGGER - 90)) | (1L << (TRUNCATE - 90)) | (1L << (UPDATE - 90)) | (1L << (INSERT - 90)))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
						}
						setState(712); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==DELETE || _la==REFERENCES || ((((_la - 90)) & ~0x3f) == 0 && ((1L << (_la - 90)) & ((1L << (SELECT - 90)) | (1L << (TRIGGER - 90)) | (1L << (TRUNCATE - 90)) | (1L << (UPDATE - 90)) | (1L << (INSERT - 90)))) != 0) );
					}
					break;
				case ALL:
					{
					setState(714); match(ALL);
					setState(716);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(715); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(720); match(ON);
				setState(744);
				switch (_input.LA(1)) {
				case TABLE:
				case ADMIN:
				case AVG:
				case BETWEEN:
				case BY:
				case CENTURY:
				case CHARACTER:
				case CHECK:
				case COLLECT:
				case COALESCE:
				case COLUMN:
				case COMMENT:
				case COMMENTS:
				case COMMIT:
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
					setState(722);
					_la = _input.LA(1);
					if (_la==TABLE) {
						{
						setState(721); match(TABLE);
						}
					}

					setState(728); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(724); ((Grant_statementContext)_localctx).tabl_name = table_name();
							setState(726);
							_la = _input.LA(1);
							if (_la==COMMA) {
								{
								setState(725); match(COMMA);
								}
							}

							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(730); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,62,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					}
					}
					break;
				case ALL:
					{
					{
					setState(732); match(ALL);
					setState(733); match(TABLES);
					setState(734); match(IN);
					setState(735); match(SCHEMA);
					setState(740); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(736); ((Grant_statementContext)_localctx).schem_name = identifier();
							setState(738);
							_la = _input.LA(1);
							if (_la==COMMA) {
								{
								setState(737); match(COMMA);
								}
							}

							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(742); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,64,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(746); grant_to_rule();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(748); match(GRANT);
				setState(774);
				switch (_input.LA(1)) {
				case REFERENCES:
				case SELECT:
				case UPDATE:
				case INSERT:
					{
					setState(758); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(749);
						_la = _input.LA(1);
						if ( !(((((_la - 82)) & ~0x3f) == 0 && ((1L << (_la - 82)) & ((1L << (REFERENCES - 82)) | (1L << (SELECT - 82)) | (1L << (UPDATE - 82)))) != 0) || _la==INSERT) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(754); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(750); ((Grant_statementContext)_localctx).column = identifier();
								setState(752);
								_la = _input.LA(1);
								if (_la==COMMA) {
									{
									setState(751); match(COMMA);
									}
								}

								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(756); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,67,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						}
						}
						setState(760); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 82)) & ~0x3f) == 0 && ((1L << (_la - 82)) & ((1L << (REFERENCES - 82)) | (1L << (SELECT - 82)) | (1L << (UPDATE - 82)))) != 0) || _la==INSERT );
					}
					break;
				case ALL:
					{
					setState(762); match(ALL);
					setState(764);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(763); match(PRIVILEGES);
						}
					}

					setState(770); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(766); ((Grant_statementContext)_localctx).column = identifier();
						setState(768);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(767); match(COMMA);
							}
						}

						}
						}
						setState(772); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 113)) & ~0x3f) == 0 && ((1L << (_la - 113)) & ((1L << (ADMIN - 113)) | (1L << (AVG - 113)) | (1L << (BETWEEN - 113)) | (1L << (BY - 113)) | (1L << (CENTURY - 113)) | (1L << (CHARACTER - 113)) | (1L << (CHECK - 113)) | (1L << (COLLECT - 113)) | (1L << (COALESCE - 113)) | (1L << (COLUMN - 113)) | (1L << (COMMENT - 113)) | (1L << (COMMENTS - 113)) | (1L << (COMMIT - 113)) | (1L << (COUNT - 113)) | (1L << (CUBE - 113)) | (1L << (DATA - 113)) | (1L << (DAY - 113)) | (1L << (DEC - 113)) | (1L << (DECADE - 113)) | (1L << (DOW - 113)) | (1L << (DOY - 113)) | (1L << (DROP - 113)) | (1L << (EPOCH - 113)) | (1L << (EVERY - 113)) | (1L << (EXISTS - 113)) | (1L << (EXTERNAL - 113)) | (1L << (EXTRACT - 113)) | (1L << (FILTER - 113)) | (1L << (FIRST - 113)) | (1L << (FORMAT - 113)) | (1L << (FUSION - 113)) | (1L << (GROUPING - 113)) | (1L << (HASH - 113)) | (1L << (INDEX - 113)) | (1L << (INSERT - 113)) | (1L << (INTERSECTION - 113)) | (1L << (ISODOW - 113)) | (1L << (ISOYEAR - 113)) | (1L << (LANGUAGE - 113)) | (1L << (LARGE - 113)) | (1L << (LAST - 113)) | (1L << (LESS - 113)) | (1L << (LIST - 113)) | (1L << (LOCATION - 113)) | (1L << (MATCH - 113)) | (1L << (MAX - 113)) | (1L << (MAXVALUE - 113)) | (1L << (MICROSECONDS - 113)) | (1L << (MILLENNIUM - 113)) | (1L << (MILLISECONDS - 113)) | (1L << (MIN - 113)) | (1L << (MINUTE - 113)) | (1L << (MONTH - 113)) | (1L << (NATIONAL - 113)) | (1L << (NULLIF - 113)) | (1L << (OBJECT - 113)) | (1L << (OPTION - 113)) | (1L << (OPTIONS - 113)) | (1L << (OVERWRITE - 113)) | (1L << (PARTIAL - 113)) | (1L << (PARTITION - 113)) | (1L << (PARTITIONS - 113)))) != 0) || ((((_la - 177)) & ~0x3f) == 0 && ((1L << (_la - 177)) & ((1L << (PRECISION - 177)) | (1L << (PUBLIC - 177)) | (1L << (PURGE - 177)) | (1L << (QUARTER - 177)) | (1L << (RANGE - 177)) | (1L << (REGEXP - 177)) | (1L << (RLIKE - 177)) | (1L << (ROLLUP - 177)) | (1L << (SECOND - 177)) | (1L << (SERVER - 177)) | (1L << (SET - 177)) | (1L << (SIMILAR - 177)) | (1L << (SIMPLE - 177)) | (1L << (STORAGE - 177)) | (1L << (STDDEV_POP - 177)) | (1L << (STDDEV_SAMP - 177)) | (1L << (SUBPARTITION - 177)) | (1L << (SUM - 177)) | (1L << (TABLESPACE - 177)) | (1L << (THAN - 177)) | (1L << (TIMEZONE - 177)) | (1L << (TIMEZONE_HOUR - 177)) | (1L << (TIMEZONE_MINUTE - 177)) | (1L << (TRIM - 177)) | (1L << (TO - 177)) | (1L << (UNKNOWN - 177)) | (1L << (UNLOGGED - 177)) | (1L << (VALUES - 177)) | (1L << (VAR_SAMP - 177)) | (1L << (VAR_POP - 177)) | (1L << (VARYING - 177)) | (1L << (WEEK - 177)) | (1L << (WRAPPER - 177)) | (1L << (YEAR - 177)) | (1L << (ZONE - 177)) | (1L << (BOOLEAN - 177)) | (1L << (BOOL - 177)) | (1L << (BIT - 177)) | (1L << (VARBIT - 177)) | (1L << (INT1 - 177)) | (1L << (INT2 - 177)) | (1L << (INT4 - 177)) | (1L << (INT8 - 177)) | (1L << (TINYINT - 177)) | (1L << (SMALLINT - 177)) | (1L << (INT - 177)) | (1L << (INTEGER - 177)) | (1L << (BIGINT - 177)) | (1L << (FLOAT4 - 177)) | (1L << (FLOAT8 - 177)) | (1L << (REAL - 177)) | (1L << (FLOAT - 177)) | (1L << (DOUBLE - 177)) | (1L << (NUMERIC - 177)) | (1L << (DECIMAL - 177)) | (1L << (CHAR - 177)) | (1L << (VARCHAR - 177)) | (1L << (NCHAR - 177)) | (1L << (NVARCHAR - 177)) | (1L << (DATE - 177)) | (1L << (TIME - 177)))) != 0) || ((((_la - 241)) & ~0x3f) == 0 && ((1L << (_la - 241)) & ((1L << (TIMETZ - 241)) | (1L << (TIMESTAMP - 241)) | (1L << (TIMESTAMPTZ - 241)) | (1L << (TEXT - 241)) | (1L << (VARBINARY - 241)) | (1L << (BLOB - 241)) | (1L << (BYTEA - 241)) | (1L << (INET4 - 241)) | (1L << (QUOTE - 241)) | (1L << (Identifier - 241)))) != 0) );
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(776); match(ON);
				setState(784); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(778);
						_la = _input.LA(1);
						if (_la==TABLE) {
							{
							setState(777); match(TABLE);
							}
						}

						setState(780); ((Grant_statementContext)_localctx).tabl_name = table_name();
						setState(782);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(781); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(786); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,75,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(788); grant_to_rule();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(790); match(GRANT);
				setState(803);
				switch (_input.LA(1)) {
				case SELECT:
				case UPDATE:
				case USAGE:
					{
					setState(795); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(791);
						_la = _input.LA(1);
						if ( !(((((_la - 90)) & ~0x3f) == 0 && ((1L << (_la - 90)) & ((1L << (SELECT - 90)) | (1L << (UPDATE - 90)) | (1L << (USAGE - 90)))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(793);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(792); match(COMMA);
							}
						}

						}
						}
						setState(797); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 90)) & ~0x3f) == 0 && ((1L << (_la - 90)) & ((1L << (SELECT - 90)) | (1L << (UPDATE - 90)) | (1L << (USAGE - 90)))) != 0) );
					}
					break;
				case ALL:
					{
					setState(799); match(ALL);
					setState(801);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(800); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(805); match(ON);
				setState(827);
				switch (_input.LA(1)) {
				case SEQUENCE:
					{
					setState(811); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(806); match(SEQUENCE);
						setState(807); ((Grant_statementContext)_localctx).sequence_name = identifier();
						setState(809);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(808); match(COMMA);
							}
						}

						}
						}
						setState(813); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==SEQUENCE );
					}
					break;
				case ALL:
					{
					setState(815); match(ALL);
					setState(816); match(SEQUENCES);
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
						_alt = getInterpreter().adaptivePredict(_input,83,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(829); grant_to_rule();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(831); match(GRANT);
				setState(844);
				switch (_input.LA(1)) {
				case CONNECT:
				case CREATE:
				case TEMP:
				case TEMPORARY:
					{
					setState(836); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(832);
						_la = _input.LA(1);
						if ( !(_la==CONNECT || _la==CREATE || _la==TEMP || _la==TEMPORARY) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(834);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(833); match(COMMA);
							}
						}

						}
						}
						setState(838); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==CONNECT || _la==CREATE || _la==TEMP || _la==TEMPORARY );
					}
					break;
				case ALL:
					{
					setState(840); match(ALL);
					setState(842);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(841); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(846); match(ON);
				setState(847); match(DATABASE);
				setState(852); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(848); ((Grant_statementContext)_localctx).database_name = identifier();
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
					_alt = getInterpreter().adaptivePredict(_input,90,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(856); grant_to_rule();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
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
				setState(868); match(DATA);
				setState(869); match(WRAPPER);
				setState(874); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(870); ((Grant_statementContext)_localctx).fdw_name = identifier();
						setState(872);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(871); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(876); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,94,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(878); grant_to_rule();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(880); match(GRANT);
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
				setState(889); match(FOREIGN);
				setState(890); match(SERVER);
				setState(895); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(891); ((Grant_statementContext)_localctx).server_name = identifier();
						setState(893);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(892); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(897); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,98,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(899); grant_to_rule();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(901); match(GRANT);
				setState(907);
				switch (_input.LA(1)) {
				case EXECUTE:
					{
					setState(902); match(EXECUTE);
					}
					break;
				case ALL:
					{
					setState(903); match(ALL);
					setState(905);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(904); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(909); match(ON);
				setState(912);
				switch (_input.LA(1)) {
				case FUNCTION:
					{
					setState(910); function_definition();
					}
					break;
				case ALL:
					{
					setState(911); functions_definition_schema();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(914); grant_to_rule();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(916); match(GRANT);
				setState(922);
				switch (_input.LA(1)) {
				case USAGE:
					{
					setState(917); match(USAGE);
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
				setState(925); match(LANGUAGE);
				setState(930); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(926); ((Grant_statementContext)_localctx).lang_name = identifier();
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
					_alt = getInterpreter().adaptivePredict(_input,105,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(934); grant_to_rule();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(936); match(GRANT);
				setState(949);
				switch (_input.LA(1)) {
				case SELECT:
				case UPDATE:
					{
					setState(941); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(937);
						_la = _input.LA(1);
						if ( !(_la==SELECT || _la==UPDATE) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(939);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(938); match(COMMA);
							}
						}

						}
						}
						setState(943); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==SELECT || _la==UPDATE );
					}
					break;
				case ALL:
					{
					setState(945); match(ALL);
					setState(947);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(946); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(951); match(ON);
				setState(952); match(LARGE);
				setState(953); match(OBJECT);
				setState(958); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(954); ((Grant_statementContext)_localctx).loid = identifier();
						setState(956);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(955); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(960); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,111,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(962); grant_to_rule();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(964); match(GRANT);
				setState(977);
				switch (_input.LA(1)) {
				case CREATE:
				case USAGE:
					{
					setState(969); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(965);
						_la = _input.LA(1);
						if ( !(_la==CREATE || _la==USAGE) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(967);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(966); match(COMMA);
							}
						}

						}
						}
						setState(971); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==CREATE || _la==USAGE );
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
				setState(980); match(SCHEMA);
				setState(985); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(981); ((Grant_statementContext)_localctx).schema_name = identifier();
						setState(983);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(982); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(987); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,117,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(989); grant_to_rule();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(991); match(GRANT);
				setState(997);
				switch (_input.LA(1)) {
				case CREATE:
					{
					setState(992); match(CREATE);
					}
					break;
				case ALL:
					{
					setState(993); match(ALL);
					setState(995);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(994); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(999); match(ON);
				setState(1000); match(TABLESPACE);
				setState(1005); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1001); ((Grant_statementContext)_localctx).tablespace_name = identifier();
						setState(1003);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1002); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1007); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,121,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1009); grant_to_rule();
				setState(1010); match(GRANT);
				setState(1015); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1011); ((Grant_statementContext)_localctx).role_name = identifier();
						setState(1013);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1012); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1017); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,123,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1019); match(TO);
				setState(1024); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1020); ((Grant_statementContext)_localctx).role_name = identifier();
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
					_alt = getInterpreter().adaptivePredict(_input,125,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1031);
				_la = _input.LA(1);
				if (_la==WITH) {
					{
					setState(1028); match(WITH);
					setState(1029); match(ADMIN);
					setState(1030); match(OPTION);
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
			setState(1035); match(TO);
			setState(1046); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(1037);
					_la = _input.LA(1);
					if (_la==GROUP) {
						{
						setState(1036); match(GROUP);
						}
					}

					setState(1041);
					switch ( getInterpreter().adaptivePredict(_input,129,_ctx) ) {
					case 1:
						{
						{
						setState(1039); ((Grant_to_ruleContext)_localctx).role_name = identifier();
						}
						}
						break;
					case 2:
						{
						setState(1040); match(PUBLIC);
						}
						break;
					}
					setState(1044);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1043); match(COMMA);
						}
					}

					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1048); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,131,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(1053);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(1050); match(WITH);
				setState(1051); match(GRANT);
				setState(1052); match(OPTION);
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
			setState(1055);
			_la = _input.LA(1);
			if ( !(((((_la - 49)) & ~0x3f) == 0 && ((1L << (_la - 49)) & ((1L << (IN - 49)) | (1L << (INOUT - 49)) | (1L << (OUT - 49)) | (1L << (VARIADIC - 49)))) != 0)) ) {
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
			setState(1057); match(FUNCTION);
			setState(1058); ((Function_definitionContext)_localctx).func_name = identifier();
			setState(1059); match(LEFT_PAREN);
			setState(1072);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 49)) & ~0x3f) == 0 && ((1L << (_la - 49)) & ((1L << (IN - 49)) | (1L << (INOUT - 49)) | (1L << (OUT - 49)) | (1L << (VARIADIC - 49)))) != 0) || ((((_la - 113)) & ~0x3f) == 0 && ((1L << (_la - 113)) & ((1L << (ADMIN - 113)) | (1L << (AVG - 113)) | (1L << (BETWEEN - 113)) | (1L << (BY - 113)) | (1L << (CENTURY - 113)) | (1L << (CHARACTER - 113)) | (1L << (CHECK - 113)) | (1L << (COLLECT - 113)) | (1L << (COALESCE - 113)) | (1L << (COLUMN - 113)) | (1L << (COMMENT - 113)) | (1L << (COMMENTS - 113)) | (1L << (COMMIT - 113)) | (1L << (COUNT - 113)) | (1L << (CUBE - 113)) | (1L << (DATA - 113)) | (1L << (DAY - 113)) | (1L << (DEC - 113)) | (1L << (DECADE - 113)) | (1L << (DOW - 113)) | (1L << (DOY - 113)) | (1L << (DROP - 113)) | (1L << (EPOCH - 113)) | (1L << (EVERY - 113)) | (1L << (EXISTS - 113)) | (1L << (EXTERNAL - 113)) | (1L << (EXTRACT - 113)) | (1L << (FILTER - 113)) | (1L << (FIRST - 113)) | (1L << (FORMAT - 113)) | (1L << (FUSION - 113)) | (1L << (GROUPING - 113)) | (1L << (HASH - 113)) | (1L << (INDEX - 113)) | (1L << (INSERT - 113)) | (1L << (INTERSECTION - 113)) | (1L << (ISODOW - 113)) | (1L << (ISOYEAR - 113)) | (1L << (LANGUAGE - 113)) | (1L << (LARGE - 113)) | (1L << (LAST - 113)) | (1L << (LESS - 113)) | (1L << (LIST - 113)) | (1L << (LOCATION - 113)) | (1L << (MATCH - 113)) | (1L << (MAX - 113)) | (1L << (MAXVALUE - 113)) | (1L << (MICROSECONDS - 113)) | (1L << (MILLENNIUM - 113)) | (1L << (MILLISECONDS - 113)) | (1L << (MIN - 113)) | (1L << (MINUTE - 113)) | (1L << (MONTH - 113)) | (1L << (NATIONAL - 113)) | (1L << (NULLIF - 113)) | (1L << (OBJECT - 113)) | (1L << (OPTION - 113)) | (1L << (OPTIONS - 113)) | (1L << (OVERWRITE - 113)) | (1L << (PARTIAL - 113)) | (1L << (PARTITION - 113)) | (1L << (PARTITIONS - 113)))) != 0) || ((((_la - 177)) & ~0x3f) == 0 && ((1L << (_la - 177)) & ((1L << (PRECISION - 177)) | (1L << (PUBLIC - 177)) | (1L << (PURGE - 177)) | (1L << (QUARTER - 177)) | (1L << (RANGE - 177)) | (1L << (REGEXP - 177)) | (1L << (RLIKE - 177)) | (1L << (ROLLUP - 177)) | (1L << (SECOND - 177)) | (1L << (SERVER - 177)) | (1L << (SET - 177)) | (1L << (SIMILAR - 177)) | (1L << (SIMPLE - 177)) | (1L << (STORAGE - 177)) | (1L << (STDDEV_POP - 177)) | (1L << (STDDEV_SAMP - 177)) | (1L << (SUBPARTITION - 177)) | (1L << (SUM - 177)) | (1L << (TABLESPACE - 177)) | (1L << (THAN - 177)) | (1L << (TIMEZONE - 177)) | (1L << (TIMEZONE_HOUR - 177)) | (1L << (TIMEZONE_MINUTE - 177)) | (1L << (TRIM - 177)) | (1L << (TO - 177)) | (1L << (UNKNOWN - 177)) | (1L << (UNLOGGED - 177)) | (1L << (VALUES - 177)) | (1L << (VAR_SAMP - 177)) | (1L << (VAR_POP - 177)) | (1L << (VARYING - 177)) | (1L << (WEEK - 177)) | (1L << (WRAPPER - 177)) | (1L << (YEAR - 177)) | (1L << (ZONE - 177)) | (1L << (BOOLEAN - 177)) | (1L << (BOOL - 177)) | (1L << (BIT - 177)) | (1L << (VARBIT - 177)) | (1L << (INT1 - 177)) | (1L << (INT2 - 177)) | (1L << (INT4 - 177)) | (1L << (INT8 - 177)) | (1L << (TINYINT - 177)) | (1L << (SMALLINT - 177)) | (1L << (INT - 177)) | (1L << (INTEGER - 177)) | (1L << (BIGINT - 177)) | (1L << (FLOAT4 - 177)) | (1L << (FLOAT8 - 177)) | (1L << (REAL - 177)) | (1L << (REGCLASS - 177)) | (1L << (FLOAT - 177)) | (1L << (DOUBLE - 177)) | (1L << (NUMERIC - 177)) | (1L << (DECIMAL - 177)) | (1L << (CHAR - 177)) | (1L << (VARCHAR - 177)) | (1L << (NCHAR - 177)) | (1L << (NVARCHAR - 177)) | (1L << (DATE - 177)) | (1L << (TIME - 177)))) != 0) || ((((_la - 241)) & ~0x3f) == 0 && ((1L << (_la - 241)) & ((1L << (TIMETZ - 241)) | (1L << (TIMESTAMP - 241)) | (1L << (TIMESTAMPTZ - 241)) | (1L << (TEXT - 241)) | (1L << (BINARY - 241)) | (1L << (VARBINARY - 241)) | (1L << (BLOB - 241)) | (1L << (BYTEA - 241)) | (1L << (INET4 - 241)) | (1L << (QUOTE - 241)) | (1L << (Identifier - 241)))) != 0)) {
				{
				{
				setState(1061);
				_la = _input.LA(1);
				if (((((_la - 49)) & ~0x3f) == 0 && ((1L << (_la - 49)) & ((1L << (IN - 49)) | (1L << (INOUT - 49)) | (1L << (OUT - 49)) | (1L << (VARIADIC - 49)))) != 0)) {
					{
					setState(1060); ((Function_definitionContext)_localctx).arg_mode = argmode();
					}
				}

				setState(1064);
				switch ( getInterpreter().adaptivePredict(_input,134,_ctx) ) {
				case 1:
					{
					setState(1063); ((Function_definitionContext)_localctx).argname = identifier();
					}
					break;
				}
				setState(1066); ((Function_definitionContext)_localctx).argtype = data_type();
				setState(1068);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(1067); match(COMMA);
					}
				}

				}
				}
				setState(1074);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1075); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
			setState(1077); match(ALL);
			setState(1078); match(FUNCTIONS);
			setState(1079); match(IN);
			setState(1080); match(SCHEMA);
			setState(1085); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(1081); ((Functions_definition_schemaContext)_localctx).schema_name = identifier();
					setState(1083);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1082); match(COMMA);
						}
					}

					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1087); 
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
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
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
			int _alt;
			setState(1251);
			switch ( getInterpreter().adaptivePredict(_input,169,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1089); match(CREATE);
				setState(1090); match(EXTERNAL);
				setState(1091); match(TABLE);
				setState(1092); ((Create_table_statementContext)_localctx).n = table_name();
				setState(1093); table_elements();
				setState(1094); match(USING);
				setState(1095); ((Create_table_statementContext)_localctx).file_type = identifier();
				setState(1097);
				_la = _input.LA(1);
				if (_la==WITH) {
					{
					setState(1096); param_clause();
					}
				}

				setState(1100);
				_la = _input.LA(1);
				if (_la==PARTITION) {
					{
					setState(1099); table_partitioning_clauses();
					}
				}

				{
				setState(1102); match(LOCATION);
				setState(1103); ((Create_table_statementContext)_localctx).path = match(Character_String_Literal);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1105); match(CREATE);
				setState(1106); match(TABLE);
				setState(1107); ((Create_table_statementContext)_localctx).n = table_name();
				setState(1108); table_elements();
				setState(1111);
				_la = _input.LA(1);
				if (_la==USING) {
					{
					setState(1109); match(USING);
					setState(1110); ((Create_table_statementContext)_localctx).file_type = identifier();
					}
				}

				setState(1114);
				_la = _input.LA(1);
				if (_la==WITH) {
					{
					setState(1113); param_clause();
					}
				}

				setState(1117);
				switch ( getInterpreter().adaptivePredict(_input,143,_ctx) ) {
				case 1:
					{
					setState(1116); table_partitioning_clauses();
					}
					break;
				}
				setState(1121);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(1119); match(AS);
					setState(1120); query_expression();
					}
				}

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1123); match(CREATE);
				setState(1124); match(TABLE);
				setState(1125); ((Create_table_statementContext)_localctx).n = table_name();
				setState(1128);
				_la = _input.LA(1);
				if (_la==USING) {
					{
					setState(1126); match(USING);
					setState(1127); ((Create_table_statementContext)_localctx).file_type = identifier();
					}
				}

				setState(1131);
				_la = _input.LA(1);
				if (_la==WITH) {
					{
					setState(1130); param_clause();
					}
				}

				setState(1134);
				_la = _input.LA(1);
				if (_la==PARTITION) {
					{
					setState(1133); table_partitioning_clauses();
					}
				}

				setState(1136); match(AS);
				setState(1137); query_expression();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1139); match(CREATE);
				setState(1145);
				switch (_input.LA(1)) {
				case GLOBAL:
				case LOCAL:
				case TEMP:
				case TEMPORARY:
					{
					setState(1141);
					_la = _input.LA(1);
					if (_la==GLOBAL || _la==LOCAL) {
						{
						setState(1140);
						_la = _input.LA(1);
						if ( !(_la==GLOBAL || _la==LOCAL) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
					}

					setState(1143);
					_la = _input.LA(1);
					if ( !(_la==TEMP || _la==TEMPORARY) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
					break;
				case UNLOGGED:
					{
					setState(1144); match(UNLOGGED);
					}
					break;
				case TABLE:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1147); match(TABLE);
				setState(1151);
				_la = _input.LA(1);
				if (_la==IF) {
					{
					setState(1148); match(IF);
					setState(1149); match(NOT);
					setState(1150); match(EXISTS);
					}
				}

				setState(1153); ((Create_table_statementContext)_localctx).n = table_name();
				setState(1154); match(LEFT_PAREN);
				setState(1185);
				_la = _input.LA(1);
				if (((((_la - 15)) & ~0x3f) == 0 && ((1L << (_la - 15)) & ((1L << (CONSTRAINT - 15)) | (1L << (EXCLUDE - 15)) | (1L << (FOREIGN - 15)) | (1L << (LIKE - 15)) | (1L << (PRIMARY - 15)))) != 0) || ((((_la - 104)) & ~0x3f) == 0 && ((1L << (_la - 104)) & ((1L << (UNIQUE - 104)) | (1L << (ADMIN - 104)) | (1L << (AVG - 104)) | (1L << (BETWEEN - 104)) | (1L << (BY - 104)) | (1L << (CENTURY - 104)) | (1L << (CHARACTER - 104)) | (1L << (CHECK - 104)) | (1L << (COLLECT - 104)) | (1L << (COALESCE - 104)) | (1L << (COLUMN - 104)) | (1L << (COMMENT - 104)) | (1L << (COMMENTS - 104)) | (1L << (COMMIT - 104)) | (1L << (COUNT - 104)) | (1L << (CUBE - 104)) | (1L << (DATA - 104)) | (1L << (DAY - 104)) | (1L << (DEC - 104)) | (1L << (DECADE - 104)) | (1L << (DOW - 104)) | (1L << (DOY - 104)) | (1L << (DROP - 104)) | (1L << (EPOCH - 104)) | (1L << (EVERY - 104)) | (1L << (EXISTS - 104)) | (1L << (EXTERNAL - 104)) | (1L << (EXTRACT - 104)) | (1L << (FILTER - 104)) | (1L << (FIRST - 104)) | (1L << (FORMAT - 104)) | (1L << (FUSION - 104)) | (1L << (GROUPING - 104)) | (1L << (HASH - 104)) | (1L << (INDEX - 104)) | (1L << (INSERT - 104)) | (1L << (INTERSECTION - 104)) | (1L << (ISODOW - 104)) | (1L << (ISOYEAR - 104)) | (1L << (LANGUAGE - 104)) | (1L << (LARGE - 104)) | (1L << (LAST - 104)) | (1L << (LESS - 104)) | (1L << (LIST - 104)) | (1L << (LOCATION - 104)) | (1L << (MATCH - 104)) | (1L << (MAX - 104)) | (1L << (MAXVALUE - 104)) | (1L << (MICROSECONDS - 104)) | (1L << (MILLENNIUM - 104)) | (1L << (MILLISECONDS - 104)) | (1L << (MIN - 104)) | (1L << (MINUTE - 104)) | (1L << (MONTH - 104)))) != 0) || ((((_la - 168)) & ~0x3f) == 0 && ((1L << (_la - 168)) & ((1L << (NATIONAL - 168)) | (1L << (NULLIF - 168)) | (1L << (OBJECT - 168)) | (1L << (OPTION - 168)) | (1L << (OPTIONS - 168)) | (1L << (OVERWRITE - 168)) | (1L << (PARTIAL - 168)) | (1L << (PARTITION - 168)) | (1L << (PARTITIONS - 168)) | (1L << (PRECISION - 168)) | (1L << (PUBLIC - 168)) | (1L << (PURGE - 168)) | (1L << (QUARTER - 168)) | (1L << (RANGE - 168)) | (1L << (REGEXP - 168)) | (1L << (RLIKE - 168)) | (1L << (ROLLUP - 168)) | (1L << (SECOND - 168)) | (1L << (SERVER - 168)) | (1L << (SET - 168)) | (1L << (SIMILAR - 168)) | (1L << (SIMPLE - 168)) | (1L << (STORAGE - 168)) | (1L << (STDDEV_POP - 168)) | (1L << (STDDEV_SAMP - 168)) | (1L << (SUBPARTITION - 168)) | (1L << (SUM - 168)) | (1L << (TABLESPACE - 168)) | (1L << (THAN - 168)) | (1L << (TIMEZONE - 168)) | (1L << (TIMEZONE_HOUR - 168)) | (1L << (TIMEZONE_MINUTE - 168)) | (1L << (TRIM - 168)) | (1L << (TO - 168)) | (1L << (UNKNOWN - 168)) | (1L << (UNLOGGED - 168)) | (1L << (VALUES - 168)) | (1L << (VAR_SAMP - 168)) | (1L << (VAR_POP - 168)) | (1L << (VARYING - 168)) | (1L << (WEEK - 168)) | (1L << (WRAPPER - 168)) | (1L << (YEAR - 168)) | (1L << (ZONE - 168)) | (1L << (BOOLEAN - 168)) | (1L << (BOOL - 168)) | (1L << (BIT - 168)) | (1L << (VARBIT - 168)) | (1L << (INT1 - 168)) | (1L << (INT2 - 168)) | (1L << (INT4 - 168)) | (1L << (INT8 - 168)) | (1L << (TINYINT - 168)) | (1L << (SMALLINT - 168)) | (1L << (INT - 168)) | (1L << (INTEGER - 168)) | (1L << (BIGINT - 168)) | (1L << (FLOAT4 - 168)) | (1L << (FLOAT8 - 168)) | (1L << (REAL - 168)) | (1L << (FLOAT - 168)))) != 0) || ((((_la - 232)) & ~0x3f) == 0 && ((1L << (_la - 232)) & ((1L << (DOUBLE - 232)) | (1L << (NUMERIC - 232)) | (1L << (DECIMAL - 232)) | (1L << (CHAR - 232)) | (1L << (VARCHAR - 232)) | (1L << (NCHAR - 232)) | (1L << (NVARCHAR - 232)) | (1L << (DATE - 232)) | (1L << (TIME - 232)) | (1L << (TIMETZ - 232)) | (1L << (TIMESTAMP - 232)) | (1L << (TIMESTAMPTZ - 232)) | (1L << (TEXT - 232)) | (1L << (VARBINARY - 232)) | (1L << (BLOB - 232)) | (1L << (BYTEA - 232)) | (1L << (INET4 - 232)) | (1L << (QUOTE - 232)) | (1L << (Identifier - 232)))) != 0)) {
					{
					setState(1181); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1176);
						switch ( getInterpreter().adaptivePredict(_input,154,_ctx) ) {
						case 1:
							{
							{
							setState(1155); ((Create_table_statementContext)_localctx).column_name = identifier();
							setState(1156); ((Create_table_statementContext)_localctx).datatype = data_type();
							setState(1159);
							_la = _input.LA(1);
							if (_la==COLLATE) {
								{
								setState(1157); match(COLLATE);
								setState(1158); ((Create_table_statementContext)_localctx).collation = identifier();
								}
							}

							setState(1164);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,152,_ctx);
							while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
								if ( _alt==1 ) {
									{
									{
									setState(1161); ((Create_table_statementContext)_localctx).colmn_constraint = column_constraint();
									}
									} 
								}
								setState(1166);
								_errHandler.sync(this);
								_alt = getInterpreter().adaptivePredict(_input,152,_ctx);
							}
							}
							}
							break;
						case 2:
							{
							setState(1167); ((Create_table_statementContext)_localctx).tabl_constraint = table_constraint();
							}
							break;
						case 3:
							{
							{
							setState(1168); match(LIKE);
							setState(1169); ((Create_table_statementContext)_localctx).parent_table = identifier();
							setState(1173);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==EXCLUDING || _la==INCLUDING) {
								{
								{
								setState(1170); ((Create_table_statementContext)_localctx).like_opt = like_option();
								}
								}
								setState(1175);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
							}
							break;
						}
						setState(1179);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1178); match(COMMA);
							}
						}

						}
						}
						setState(1183); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 15)) & ~0x3f) == 0 && ((1L << (_la - 15)) & ((1L << (CONSTRAINT - 15)) | (1L << (EXCLUDE - 15)) | (1L << (FOREIGN - 15)) | (1L << (LIKE - 15)) | (1L << (PRIMARY - 15)))) != 0) || ((((_la - 104)) & ~0x3f) == 0 && ((1L << (_la - 104)) & ((1L << (UNIQUE - 104)) | (1L << (ADMIN - 104)) | (1L << (AVG - 104)) | (1L << (BETWEEN - 104)) | (1L << (BY - 104)) | (1L << (CENTURY - 104)) | (1L << (CHARACTER - 104)) | (1L << (CHECK - 104)) | (1L << (COLLECT - 104)) | (1L << (COALESCE - 104)) | (1L << (COLUMN - 104)) | (1L << (COMMENT - 104)) | (1L << (COMMENTS - 104)) | (1L << (COMMIT - 104)) | (1L << (COUNT - 104)) | (1L << (CUBE - 104)) | (1L << (DATA - 104)) | (1L << (DAY - 104)) | (1L << (DEC - 104)) | (1L << (DECADE - 104)) | (1L << (DOW - 104)) | (1L << (DOY - 104)) | (1L << (DROP - 104)) | (1L << (EPOCH - 104)) | (1L << (EVERY - 104)) | (1L << (EXISTS - 104)) | (1L << (EXTERNAL - 104)) | (1L << (EXTRACT - 104)) | (1L << (FILTER - 104)) | (1L << (FIRST - 104)) | (1L << (FORMAT - 104)) | (1L << (FUSION - 104)) | (1L << (GROUPING - 104)) | (1L << (HASH - 104)) | (1L << (INDEX - 104)) | (1L << (INSERT - 104)) | (1L << (INTERSECTION - 104)) | (1L << (ISODOW - 104)) | (1L << (ISOYEAR - 104)) | (1L << (LANGUAGE - 104)) | (1L << (LARGE - 104)) | (1L << (LAST - 104)) | (1L << (LESS - 104)) | (1L << (LIST - 104)) | (1L << (LOCATION - 104)) | (1L << (MATCH - 104)) | (1L << (MAX - 104)) | (1L << (MAXVALUE - 104)) | (1L << (MICROSECONDS - 104)) | (1L << (MILLENNIUM - 104)) | (1L << (MILLISECONDS - 104)) | (1L << (MIN - 104)) | (1L << (MINUTE - 104)) | (1L << (MONTH - 104)))) != 0) || ((((_la - 168)) & ~0x3f) == 0 && ((1L << (_la - 168)) & ((1L << (NATIONAL - 168)) | (1L << (NULLIF - 168)) | (1L << (OBJECT - 168)) | (1L << (OPTION - 168)) | (1L << (OPTIONS - 168)) | (1L << (OVERWRITE - 168)) | (1L << (PARTIAL - 168)) | (1L << (PARTITION - 168)) | (1L << (PARTITIONS - 168)) | (1L << (PRECISION - 168)) | (1L << (PUBLIC - 168)) | (1L << (PURGE - 168)) | (1L << (QUARTER - 168)) | (1L << (RANGE - 168)) | (1L << (REGEXP - 168)) | (1L << (RLIKE - 168)) | (1L << (ROLLUP - 168)) | (1L << (SECOND - 168)) | (1L << (SERVER - 168)) | (1L << (SET - 168)) | (1L << (SIMILAR - 168)) | (1L << (SIMPLE - 168)) | (1L << (STORAGE - 168)) | (1L << (STDDEV_POP - 168)) | (1L << (STDDEV_SAMP - 168)) | (1L << (SUBPARTITION - 168)) | (1L << (SUM - 168)) | (1L << (TABLESPACE - 168)) | (1L << (THAN - 168)) | (1L << (TIMEZONE - 168)) | (1L << (TIMEZONE_HOUR - 168)) | (1L << (TIMEZONE_MINUTE - 168)) | (1L << (TRIM - 168)) | (1L << (TO - 168)) | (1L << (UNKNOWN - 168)) | (1L << (UNLOGGED - 168)) | (1L << (VALUES - 168)) | (1L << (VAR_SAMP - 168)) | (1L << (VAR_POP - 168)) | (1L << (VARYING - 168)) | (1L << (WEEK - 168)) | (1L << (WRAPPER - 168)) | (1L << (YEAR - 168)) | (1L << (ZONE - 168)) | (1L << (BOOLEAN - 168)) | (1L << (BOOL - 168)) | (1L << (BIT - 168)) | (1L << (VARBIT - 168)) | (1L << (INT1 - 168)) | (1L << (INT2 - 168)) | (1L << (INT4 - 168)) | (1L << (INT8 - 168)) | (1L << (TINYINT - 168)) | (1L << (SMALLINT - 168)) | (1L << (INT - 168)) | (1L << (INTEGER - 168)) | (1L << (BIGINT - 168)) | (1L << (FLOAT4 - 168)) | (1L << (FLOAT8 - 168)) | (1L << (REAL - 168)) | (1L << (FLOAT - 168)))) != 0) || ((((_la - 232)) & ~0x3f) == 0 && ((1L << (_la - 232)) & ((1L << (DOUBLE - 232)) | (1L << (NUMERIC - 232)) | (1L << (DECIMAL - 232)) | (1L << (CHAR - 232)) | (1L << (VARCHAR - 232)) | (1L << (NCHAR - 232)) | (1L << (NVARCHAR - 232)) | (1L << (DATE - 232)) | (1L << (TIME - 232)) | (1L << (TIMETZ - 232)) | (1L << (TIMESTAMP - 232)) | (1L << (TIMESTAMPTZ - 232)) | (1L << (TEXT - 232)) | (1L << (VARBINARY - 232)) | (1L << (BLOB - 232)) | (1L << (BYTEA - 232)) | (1L << (INET4 - 232)) | (1L << (QUOTE - 232)) | (1L << (Identifier - 232)))) != 0) );
					}
				}

				setState(1187); match(RIGHT_PAREN);
				setState(1200);
				_la = _input.LA(1);
				if (_la==INHERITS) {
					{
					setState(1188); match(INHERITS);
					setState(1189); match(LEFT_PAREN);
					setState(1194); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1190); ((Create_table_statementContext)_localctx).parent_table = identifier();
						setState(1192);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1191); match(COMMA);
							}
						}

						}
						}
						setState(1196); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 113)) & ~0x3f) == 0 && ((1L << (_la - 113)) & ((1L << (ADMIN - 113)) | (1L << (AVG - 113)) | (1L << (BETWEEN - 113)) | (1L << (BY - 113)) | (1L << (CENTURY - 113)) | (1L << (CHARACTER - 113)) | (1L << (CHECK - 113)) | (1L << (COLLECT - 113)) | (1L << (COALESCE - 113)) | (1L << (COLUMN - 113)) | (1L << (COMMENT - 113)) | (1L << (COMMENTS - 113)) | (1L << (COMMIT - 113)) | (1L << (COUNT - 113)) | (1L << (CUBE - 113)) | (1L << (DATA - 113)) | (1L << (DAY - 113)) | (1L << (DEC - 113)) | (1L << (DECADE - 113)) | (1L << (DOW - 113)) | (1L << (DOY - 113)) | (1L << (DROP - 113)) | (1L << (EPOCH - 113)) | (1L << (EVERY - 113)) | (1L << (EXISTS - 113)) | (1L << (EXTERNAL - 113)) | (1L << (EXTRACT - 113)) | (1L << (FILTER - 113)) | (1L << (FIRST - 113)) | (1L << (FORMAT - 113)) | (1L << (FUSION - 113)) | (1L << (GROUPING - 113)) | (1L << (HASH - 113)) | (1L << (INDEX - 113)) | (1L << (INSERT - 113)) | (1L << (INTERSECTION - 113)) | (1L << (ISODOW - 113)) | (1L << (ISOYEAR - 113)) | (1L << (LANGUAGE - 113)) | (1L << (LARGE - 113)) | (1L << (LAST - 113)) | (1L << (LESS - 113)) | (1L << (LIST - 113)) | (1L << (LOCATION - 113)) | (1L << (MATCH - 113)) | (1L << (MAX - 113)) | (1L << (MAXVALUE - 113)) | (1L << (MICROSECONDS - 113)) | (1L << (MILLENNIUM - 113)) | (1L << (MILLISECONDS - 113)) | (1L << (MIN - 113)) | (1L << (MINUTE - 113)) | (1L << (MONTH - 113)) | (1L << (NATIONAL - 113)) | (1L << (NULLIF - 113)) | (1L << (OBJECT - 113)) | (1L << (OPTION - 113)) | (1L << (OPTIONS - 113)) | (1L << (OVERWRITE - 113)) | (1L << (PARTIAL - 113)) | (1L << (PARTITION - 113)) | (1L << (PARTITIONS - 113)))) != 0) || ((((_la - 177)) & ~0x3f) == 0 && ((1L << (_la - 177)) & ((1L << (PRECISION - 177)) | (1L << (PUBLIC - 177)) | (1L << (PURGE - 177)) | (1L << (QUARTER - 177)) | (1L << (RANGE - 177)) | (1L << (REGEXP - 177)) | (1L << (RLIKE - 177)) | (1L << (ROLLUP - 177)) | (1L << (SECOND - 177)) | (1L << (SERVER - 177)) | (1L << (SET - 177)) | (1L << (SIMILAR - 177)) | (1L << (SIMPLE - 177)) | (1L << (STORAGE - 177)) | (1L << (STDDEV_POP - 177)) | (1L << (STDDEV_SAMP - 177)) | (1L << (SUBPARTITION - 177)) | (1L << (SUM - 177)) | (1L << (TABLESPACE - 177)) | (1L << (THAN - 177)) | (1L << (TIMEZONE - 177)) | (1L << (TIMEZONE_HOUR - 177)) | (1L << (TIMEZONE_MINUTE - 177)) | (1L << (TRIM - 177)) | (1L << (TO - 177)) | (1L << (UNKNOWN - 177)) | (1L << (UNLOGGED - 177)) | (1L << (VALUES - 177)) | (1L << (VAR_SAMP - 177)) | (1L << (VAR_POP - 177)) | (1L << (VARYING - 177)) | (1L << (WEEK - 177)) | (1L << (WRAPPER - 177)) | (1L << (YEAR - 177)) | (1L << (ZONE - 177)) | (1L << (BOOLEAN - 177)) | (1L << (BOOL - 177)) | (1L << (BIT - 177)) | (1L << (VARBIT - 177)) | (1L << (INT1 - 177)) | (1L << (INT2 - 177)) | (1L << (INT4 - 177)) | (1L << (INT8 - 177)) | (1L << (TINYINT - 177)) | (1L << (SMALLINT - 177)) | (1L << (INT - 177)) | (1L << (INTEGER - 177)) | (1L << (BIGINT - 177)) | (1L << (FLOAT4 - 177)) | (1L << (FLOAT8 - 177)) | (1L << (REAL - 177)) | (1L << (FLOAT - 177)) | (1L << (DOUBLE - 177)) | (1L << (NUMERIC - 177)) | (1L << (DECIMAL - 177)) | (1L << (CHAR - 177)) | (1L << (VARCHAR - 177)) | (1L << (NCHAR - 177)) | (1L << (NVARCHAR - 177)) | (1L << (DATE - 177)) | (1L << (TIME - 177)))) != 0) || ((((_la - 241)) & ~0x3f) == 0 && ((1L << (_la - 241)) & ((1L << (TIMETZ - 241)) | (1L << (TIMESTAMP - 241)) | (1L << (TIMESTAMPTZ - 241)) | (1L << (TEXT - 241)) | (1L << (VARBINARY - 241)) | (1L << (BLOB - 241)) | (1L << (BYTEA - 241)) | (1L << (INET4 - 241)) | (1L << (QUOTE - 241)) | (1L << (Identifier - 241)))) != 0) );
					setState(1198); match(RIGHT_PAREN);
					}
				}

				setState(1202); storage_parameter_oid();
				setState(1203); on_commit();
				setState(1204); table_space();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1206); match(CREATE);
				setState(1212);
				switch (_input.LA(1)) {
				case GLOBAL:
				case LOCAL:
				case TEMP:
				case TEMPORARY:
					{
					setState(1208);
					_la = _input.LA(1);
					if (_la==GLOBAL || _la==LOCAL) {
						{
						setState(1207);
						_la = _input.LA(1);
						if ( !(_la==GLOBAL || _la==LOCAL) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
					}

					setState(1210);
					_la = _input.LA(1);
					if ( !(_la==TEMP || _la==TEMPORARY) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
					break;
				case UNLOGGED:
					{
					setState(1211); match(UNLOGGED);
					}
					break;
				case TABLE:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1214); match(TABLE);
				setState(1218);
				_la = _input.LA(1);
				if (_la==IF) {
					{
					setState(1215); match(IF);
					setState(1216); match(NOT);
					setState(1217); match(EXISTS);
					}
				}

				setState(1220); ((Create_table_statementContext)_localctx).n = table_name();
				setState(1221); match(OF);
				setState(1222); ((Create_table_statementContext)_localctx).type_name = identifier();
				setState(1245);
				switch ( getInterpreter().adaptivePredict(_input,168,_ctx) ) {
				case 1:
					{
					setState(1223); match(LEFT_PAREN);
					setState(1239); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1234);
						switch ( getInterpreter().adaptivePredict(_input,165,_ctx) ) {
						case 1:
							{
							{
							setState(1224); ((Create_table_statementContext)_localctx).column_name = identifier();
							setState(1225); match(WITH);
							setState(1226); match(OPTIONS);
							setState(1230);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,164,_ctx);
							while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
								if ( _alt==1 ) {
									{
									{
									setState(1227); ((Create_table_statementContext)_localctx).col_constraint = column_constraint();
									}
									} 
								}
								setState(1232);
								_errHandler.sync(this);
								_alt = getInterpreter().adaptivePredict(_input,164,_ctx);
							}
							}
							}
							break;
						case 2:
							{
							setState(1233); table_constraint();
							}
							break;
						}
						setState(1237);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1236); match(COMMA);
							}
						}

						}
						}
						setState(1241); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 15)) & ~0x3f) == 0 && ((1L << (_la - 15)) & ((1L << (CONSTRAINT - 15)) | (1L << (EXCLUDE - 15)) | (1L << (FOREIGN - 15)) | (1L << (PRIMARY - 15)))) != 0) || ((((_la - 104)) & ~0x3f) == 0 && ((1L << (_la - 104)) & ((1L << (UNIQUE - 104)) | (1L << (ADMIN - 104)) | (1L << (AVG - 104)) | (1L << (BETWEEN - 104)) | (1L << (BY - 104)) | (1L << (CENTURY - 104)) | (1L << (CHARACTER - 104)) | (1L << (CHECK - 104)) | (1L << (COLLECT - 104)) | (1L << (COALESCE - 104)) | (1L << (COLUMN - 104)) | (1L << (COMMENT - 104)) | (1L << (COMMENTS - 104)) | (1L << (COMMIT - 104)) | (1L << (COUNT - 104)) | (1L << (CUBE - 104)) | (1L << (DATA - 104)) | (1L << (DAY - 104)) | (1L << (DEC - 104)) | (1L << (DECADE - 104)) | (1L << (DOW - 104)) | (1L << (DOY - 104)) | (1L << (DROP - 104)) | (1L << (EPOCH - 104)) | (1L << (EVERY - 104)) | (1L << (EXISTS - 104)) | (1L << (EXTERNAL - 104)) | (1L << (EXTRACT - 104)) | (1L << (FILTER - 104)) | (1L << (FIRST - 104)) | (1L << (FORMAT - 104)) | (1L << (FUSION - 104)) | (1L << (GROUPING - 104)) | (1L << (HASH - 104)) | (1L << (INDEX - 104)) | (1L << (INSERT - 104)) | (1L << (INTERSECTION - 104)) | (1L << (ISODOW - 104)) | (1L << (ISOYEAR - 104)) | (1L << (LANGUAGE - 104)) | (1L << (LARGE - 104)) | (1L << (LAST - 104)) | (1L << (LESS - 104)) | (1L << (LIST - 104)) | (1L << (LOCATION - 104)) | (1L << (MATCH - 104)) | (1L << (MAX - 104)) | (1L << (MAXVALUE - 104)) | (1L << (MICROSECONDS - 104)) | (1L << (MILLENNIUM - 104)) | (1L << (MILLISECONDS - 104)) | (1L << (MIN - 104)) | (1L << (MINUTE - 104)) | (1L << (MONTH - 104)))) != 0) || ((((_la - 168)) & ~0x3f) == 0 && ((1L << (_la - 168)) & ((1L << (NATIONAL - 168)) | (1L << (NULLIF - 168)) | (1L << (OBJECT - 168)) | (1L << (OPTION - 168)) | (1L << (OPTIONS - 168)) | (1L << (OVERWRITE - 168)) | (1L << (PARTIAL - 168)) | (1L << (PARTITION - 168)) | (1L << (PARTITIONS - 168)) | (1L << (PRECISION - 168)) | (1L << (PUBLIC - 168)) | (1L << (PURGE - 168)) | (1L << (QUARTER - 168)) | (1L << (RANGE - 168)) | (1L << (REGEXP - 168)) | (1L << (RLIKE - 168)) | (1L << (ROLLUP - 168)) | (1L << (SECOND - 168)) | (1L << (SERVER - 168)) | (1L << (SET - 168)) | (1L << (SIMILAR - 168)) | (1L << (SIMPLE - 168)) | (1L << (STORAGE - 168)) | (1L << (STDDEV_POP - 168)) | (1L << (STDDEV_SAMP - 168)) | (1L << (SUBPARTITION - 168)) | (1L << (SUM - 168)) | (1L << (TABLESPACE - 168)) | (1L << (THAN - 168)) | (1L << (TIMEZONE - 168)) | (1L << (TIMEZONE_HOUR - 168)) | (1L << (TIMEZONE_MINUTE - 168)) | (1L << (TRIM - 168)) | (1L << (TO - 168)) | (1L << (UNKNOWN - 168)) | (1L << (UNLOGGED - 168)) | (1L << (VALUES - 168)) | (1L << (VAR_SAMP - 168)) | (1L << (VAR_POP - 168)) | (1L << (VARYING - 168)) | (1L << (WEEK - 168)) | (1L << (WRAPPER - 168)) | (1L << (YEAR - 168)) | (1L << (ZONE - 168)) | (1L << (BOOLEAN - 168)) | (1L << (BOOL - 168)) | (1L << (BIT - 168)) | (1L << (VARBIT - 168)) | (1L << (INT1 - 168)) | (1L << (INT2 - 168)) | (1L << (INT4 - 168)) | (1L << (INT8 - 168)) | (1L << (TINYINT - 168)) | (1L << (SMALLINT - 168)) | (1L << (INT - 168)) | (1L << (INTEGER - 168)) | (1L << (BIGINT - 168)) | (1L << (FLOAT4 - 168)) | (1L << (FLOAT8 - 168)) | (1L << (REAL - 168)) | (1L << (FLOAT - 168)))) != 0) || ((((_la - 232)) & ~0x3f) == 0 && ((1L << (_la - 232)) & ((1L << (DOUBLE - 232)) | (1L << (NUMERIC - 232)) | (1L << (DECIMAL - 232)) | (1L << (CHAR - 232)) | (1L << (VARCHAR - 232)) | (1L << (NCHAR - 232)) | (1L << (NVARCHAR - 232)) | (1L << (DATE - 232)) | (1L << (TIME - 232)) | (1L << (TIMETZ - 232)) | (1L << (TIMESTAMP - 232)) | (1L << (TIMESTAMPTZ - 232)) | (1L << (TEXT - 232)) | (1L << (VARBINARY - 232)) | (1L << (BLOB - 232)) | (1L << (BYTEA - 232)) | (1L << (INET4 - 232)) | (1L << (QUOTE - 232)) | (1L << (Identifier - 232)))) != 0) );
					setState(1243); match(RIGHT_PAREN);
					}
					break;
				}
				setState(1247); storage_parameter_oid();
				setState(1248); on_commit();
				setState(1249); table_space();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 32, RULE_like_option);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1253);
			_la = _input.LA(1);
			if ( !(_la==EXCLUDING || _la==INCLUDING) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(1254);
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
		enterRule(_localctx, 34, RULE_table_constraint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1258);
			_la = _input.LA(1);
			if (_la==CONSTRAINT) {
				{
				setState(1256); match(CONSTRAINT);
				setState(1257); ((Table_constraintContext)_localctx).constraint_name = identifier();
				}
			}

			setState(1358);
			switch (_input.LA(1)) {
			case CHECK:
				{
				setState(1260); check_boolean_expression();
				}
				break;
			case UNIQUE:
				{
				{
				setState(1261); match(UNIQUE);
				setState(1262); match(LEFT_PAREN);
				setState(1267); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1263); ((Table_constraintContext)_localctx).column_name_unique = identifier();
					setState(1265);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1264); match(COMMA);
						}
					}

					}
					}
					setState(1269); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 113)) & ~0x3f) == 0 && ((1L << (_la - 113)) & ((1L << (ADMIN - 113)) | (1L << (AVG - 113)) | (1L << (BETWEEN - 113)) | (1L << (BY - 113)) | (1L << (CENTURY - 113)) | (1L << (CHARACTER - 113)) | (1L << (CHECK - 113)) | (1L << (COLLECT - 113)) | (1L << (COALESCE - 113)) | (1L << (COLUMN - 113)) | (1L << (COMMENT - 113)) | (1L << (COMMENTS - 113)) | (1L << (COMMIT - 113)) | (1L << (COUNT - 113)) | (1L << (CUBE - 113)) | (1L << (DATA - 113)) | (1L << (DAY - 113)) | (1L << (DEC - 113)) | (1L << (DECADE - 113)) | (1L << (DOW - 113)) | (1L << (DOY - 113)) | (1L << (DROP - 113)) | (1L << (EPOCH - 113)) | (1L << (EVERY - 113)) | (1L << (EXISTS - 113)) | (1L << (EXTERNAL - 113)) | (1L << (EXTRACT - 113)) | (1L << (FILTER - 113)) | (1L << (FIRST - 113)) | (1L << (FORMAT - 113)) | (1L << (FUSION - 113)) | (1L << (GROUPING - 113)) | (1L << (HASH - 113)) | (1L << (INDEX - 113)) | (1L << (INSERT - 113)) | (1L << (INTERSECTION - 113)) | (1L << (ISODOW - 113)) | (1L << (ISOYEAR - 113)) | (1L << (LANGUAGE - 113)) | (1L << (LARGE - 113)) | (1L << (LAST - 113)) | (1L << (LESS - 113)) | (1L << (LIST - 113)) | (1L << (LOCATION - 113)) | (1L << (MATCH - 113)) | (1L << (MAX - 113)) | (1L << (MAXVALUE - 113)) | (1L << (MICROSECONDS - 113)) | (1L << (MILLENNIUM - 113)) | (1L << (MILLISECONDS - 113)) | (1L << (MIN - 113)) | (1L << (MINUTE - 113)) | (1L << (MONTH - 113)) | (1L << (NATIONAL - 113)) | (1L << (NULLIF - 113)) | (1L << (OBJECT - 113)) | (1L << (OPTION - 113)) | (1L << (OPTIONS - 113)) | (1L << (OVERWRITE - 113)) | (1L << (PARTIAL - 113)) | (1L << (PARTITION - 113)) | (1L << (PARTITIONS - 113)))) != 0) || ((((_la - 177)) & ~0x3f) == 0 && ((1L << (_la - 177)) & ((1L << (PRECISION - 177)) | (1L << (PUBLIC - 177)) | (1L << (PURGE - 177)) | (1L << (QUARTER - 177)) | (1L << (RANGE - 177)) | (1L << (REGEXP - 177)) | (1L << (RLIKE - 177)) | (1L << (ROLLUP - 177)) | (1L << (SECOND - 177)) | (1L << (SERVER - 177)) | (1L << (SET - 177)) | (1L << (SIMILAR - 177)) | (1L << (SIMPLE - 177)) | (1L << (STORAGE - 177)) | (1L << (STDDEV_POP - 177)) | (1L << (STDDEV_SAMP - 177)) | (1L << (SUBPARTITION - 177)) | (1L << (SUM - 177)) | (1L << (TABLESPACE - 177)) | (1L << (THAN - 177)) | (1L << (TIMEZONE - 177)) | (1L << (TIMEZONE_HOUR - 177)) | (1L << (TIMEZONE_MINUTE - 177)) | (1L << (TRIM - 177)) | (1L << (TO - 177)) | (1L << (UNKNOWN - 177)) | (1L << (UNLOGGED - 177)) | (1L << (VALUES - 177)) | (1L << (VAR_SAMP - 177)) | (1L << (VAR_POP - 177)) | (1L << (VARYING - 177)) | (1L << (WEEK - 177)) | (1L << (WRAPPER - 177)) | (1L << (YEAR - 177)) | (1L << (ZONE - 177)) | (1L << (BOOLEAN - 177)) | (1L << (BOOL - 177)) | (1L << (BIT - 177)) | (1L << (VARBIT - 177)) | (1L << (INT1 - 177)) | (1L << (INT2 - 177)) | (1L << (INT4 - 177)) | (1L << (INT8 - 177)) | (1L << (TINYINT - 177)) | (1L << (SMALLINT - 177)) | (1L << (INT - 177)) | (1L << (INTEGER - 177)) | (1L << (BIGINT - 177)) | (1L << (FLOAT4 - 177)) | (1L << (FLOAT8 - 177)) | (1L << (REAL - 177)) | (1L << (FLOAT - 177)) | (1L << (DOUBLE - 177)) | (1L << (NUMERIC - 177)) | (1L << (DECIMAL - 177)) | (1L << (CHAR - 177)) | (1L << (VARCHAR - 177)) | (1L << (NCHAR - 177)) | (1L << (NVARCHAR - 177)) | (1L << (DATE - 177)) | (1L << (TIME - 177)))) != 0) || ((((_la - 241)) & ~0x3f) == 0 && ((1L << (_la - 241)) & ((1L << (TIMETZ - 241)) | (1L << (TIMESTAMP - 241)) | (1L << (TIMESTAMPTZ - 241)) | (1L << (TEXT - 241)) | (1L << (VARBINARY - 241)) | (1L << (BLOB - 241)) | (1L << (BYTEA - 241)) | (1L << (INET4 - 241)) | (1L << (QUOTE - 241)) | (1L << (Identifier - 241)))) != 0) );
				setState(1271); match(RIGHT_PAREN);
				setState(1272); ((Table_constraintContext)_localctx).index_parameters_unique = index_parameters();
				}
				}
				break;
			case PRIMARY:
				{
				{
				setState(1274); match(PRIMARY);
				setState(1275); match(KEY);
				setState(1276); match(LEFT_PAREN);
				setState(1281); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1277); ((Table_constraintContext)_localctx).column_name_pr_key = identifier();
					setState(1279);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1278); match(COMMA);
						}
					}

					}
					}
					setState(1283); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 113)) & ~0x3f) == 0 && ((1L << (_la - 113)) & ((1L << (ADMIN - 113)) | (1L << (AVG - 113)) | (1L << (BETWEEN - 113)) | (1L << (BY - 113)) | (1L << (CENTURY - 113)) | (1L << (CHARACTER - 113)) | (1L << (CHECK - 113)) | (1L << (COLLECT - 113)) | (1L << (COALESCE - 113)) | (1L << (COLUMN - 113)) | (1L << (COMMENT - 113)) | (1L << (COMMENTS - 113)) | (1L << (COMMIT - 113)) | (1L << (COUNT - 113)) | (1L << (CUBE - 113)) | (1L << (DATA - 113)) | (1L << (DAY - 113)) | (1L << (DEC - 113)) | (1L << (DECADE - 113)) | (1L << (DOW - 113)) | (1L << (DOY - 113)) | (1L << (DROP - 113)) | (1L << (EPOCH - 113)) | (1L << (EVERY - 113)) | (1L << (EXISTS - 113)) | (1L << (EXTERNAL - 113)) | (1L << (EXTRACT - 113)) | (1L << (FILTER - 113)) | (1L << (FIRST - 113)) | (1L << (FORMAT - 113)) | (1L << (FUSION - 113)) | (1L << (GROUPING - 113)) | (1L << (HASH - 113)) | (1L << (INDEX - 113)) | (1L << (INSERT - 113)) | (1L << (INTERSECTION - 113)) | (1L << (ISODOW - 113)) | (1L << (ISOYEAR - 113)) | (1L << (LANGUAGE - 113)) | (1L << (LARGE - 113)) | (1L << (LAST - 113)) | (1L << (LESS - 113)) | (1L << (LIST - 113)) | (1L << (LOCATION - 113)) | (1L << (MATCH - 113)) | (1L << (MAX - 113)) | (1L << (MAXVALUE - 113)) | (1L << (MICROSECONDS - 113)) | (1L << (MILLENNIUM - 113)) | (1L << (MILLISECONDS - 113)) | (1L << (MIN - 113)) | (1L << (MINUTE - 113)) | (1L << (MONTH - 113)) | (1L << (NATIONAL - 113)) | (1L << (NULLIF - 113)) | (1L << (OBJECT - 113)) | (1L << (OPTION - 113)) | (1L << (OPTIONS - 113)) | (1L << (OVERWRITE - 113)) | (1L << (PARTIAL - 113)) | (1L << (PARTITION - 113)) | (1L << (PARTITIONS - 113)))) != 0) || ((((_la - 177)) & ~0x3f) == 0 && ((1L << (_la - 177)) & ((1L << (PRECISION - 177)) | (1L << (PUBLIC - 177)) | (1L << (PURGE - 177)) | (1L << (QUARTER - 177)) | (1L << (RANGE - 177)) | (1L << (REGEXP - 177)) | (1L << (RLIKE - 177)) | (1L << (ROLLUP - 177)) | (1L << (SECOND - 177)) | (1L << (SERVER - 177)) | (1L << (SET - 177)) | (1L << (SIMILAR - 177)) | (1L << (SIMPLE - 177)) | (1L << (STORAGE - 177)) | (1L << (STDDEV_POP - 177)) | (1L << (STDDEV_SAMP - 177)) | (1L << (SUBPARTITION - 177)) | (1L << (SUM - 177)) | (1L << (TABLESPACE - 177)) | (1L << (THAN - 177)) | (1L << (TIMEZONE - 177)) | (1L << (TIMEZONE_HOUR - 177)) | (1L << (TIMEZONE_MINUTE - 177)) | (1L << (TRIM - 177)) | (1L << (TO - 177)) | (1L << (UNKNOWN - 177)) | (1L << (UNLOGGED - 177)) | (1L << (VALUES - 177)) | (1L << (VAR_SAMP - 177)) | (1L << (VAR_POP - 177)) | (1L << (VARYING - 177)) | (1L << (WEEK - 177)) | (1L << (WRAPPER - 177)) | (1L << (YEAR - 177)) | (1L << (ZONE - 177)) | (1L << (BOOLEAN - 177)) | (1L << (BOOL - 177)) | (1L << (BIT - 177)) | (1L << (VARBIT - 177)) | (1L << (INT1 - 177)) | (1L << (INT2 - 177)) | (1L << (INT4 - 177)) | (1L << (INT8 - 177)) | (1L << (TINYINT - 177)) | (1L << (SMALLINT - 177)) | (1L << (INT - 177)) | (1L << (INTEGER - 177)) | (1L << (BIGINT - 177)) | (1L << (FLOAT4 - 177)) | (1L << (FLOAT8 - 177)) | (1L << (REAL - 177)) | (1L << (FLOAT - 177)) | (1L << (DOUBLE - 177)) | (1L << (NUMERIC - 177)) | (1L << (DECIMAL - 177)) | (1L << (CHAR - 177)) | (1L << (VARCHAR - 177)) | (1L << (NCHAR - 177)) | (1L << (NVARCHAR - 177)) | (1L << (DATE - 177)) | (1L << (TIME - 177)))) != 0) || ((((_la - 241)) & ~0x3f) == 0 && ((1L << (_la - 241)) & ((1L << (TIMETZ - 241)) | (1L << (TIMESTAMP - 241)) | (1L << (TIMESTAMPTZ - 241)) | (1L << (TEXT - 241)) | (1L << (VARBINARY - 241)) | (1L << (BLOB - 241)) | (1L << (BYTEA - 241)) | (1L << (INET4 - 241)) | (1L << (QUOTE - 241)) | (1L << (Identifier - 241)))) != 0) );
				setState(1285); match(RIGHT_PAREN);
				setState(1286); ((Table_constraintContext)_localctx).index_parameters_pr_key = index_parameters();
				}
				}
				break;
			case EXCLUDE:
				{
				{
				setState(1288); match(EXCLUDE);
				setState(1291);
				_la = _input.LA(1);
				if (_la==USING) {
					{
					setState(1289); match(USING);
					setState(1290); ((Table_constraintContext)_localctx).index_method = identifier();
					}
				}

				setState(1293); match(LEFT_PAREN);
				setState(1294); ((Table_constraintContext)_localctx).exclude_element = identifier();
				setState(1295); match(WITH);
				setState(1300); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1296); ((Table_constraintContext)_localctx).operator = identifier();
					setState(1298);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1297); match(COMMA);
						}
					}

					}
					}
					setState(1302); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 113)) & ~0x3f) == 0 && ((1L << (_la - 113)) & ((1L << (ADMIN - 113)) | (1L << (AVG - 113)) | (1L << (BETWEEN - 113)) | (1L << (BY - 113)) | (1L << (CENTURY - 113)) | (1L << (CHARACTER - 113)) | (1L << (CHECK - 113)) | (1L << (COLLECT - 113)) | (1L << (COALESCE - 113)) | (1L << (COLUMN - 113)) | (1L << (COMMENT - 113)) | (1L << (COMMENTS - 113)) | (1L << (COMMIT - 113)) | (1L << (COUNT - 113)) | (1L << (CUBE - 113)) | (1L << (DATA - 113)) | (1L << (DAY - 113)) | (1L << (DEC - 113)) | (1L << (DECADE - 113)) | (1L << (DOW - 113)) | (1L << (DOY - 113)) | (1L << (DROP - 113)) | (1L << (EPOCH - 113)) | (1L << (EVERY - 113)) | (1L << (EXISTS - 113)) | (1L << (EXTERNAL - 113)) | (1L << (EXTRACT - 113)) | (1L << (FILTER - 113)) | (1L << (FIRST - 113)) | (1L << (FORMAT - 113)) | (1L << (FUSION - 113)) | (1L << (GROUPING - 113)) | (1L << (HASH - 113)) | (1L << (INDEX - 113)) | (1L << (INSERT - 113)) | (1L << (INTERSECTION - 113)) | (1L << (ISODOW - 113)) | (1L << (ISOYEAR - 113)) | (1L << (LANGUAGE - 113)) | (1L << (LARGE - 113)) | (1L << (LAST - 113)) | (1L << (LESS - 113)) | (1L << (LIST - 113)) | (1L << (LOCATION - 113)) | (1L << (MATCH - 113)) | (1L << (MAX - 113)) | (1L << (MAXVALUE - 113)) | (1L << (MICROSECONDS - 113)) | (1L << (MILLENNIUM - 113)) | (1L << (MILLISECONDS - 113)) | (1L << (MIN - 113)) | (1L << (MINUTE - 113)) | (1L << (MONTH - 113)) | (1L << (NATIONAL - 113)) | (1L << (NULLIF - 113)) | (1L << (OBJECT - 113)) | (1L << (OPTION - 113)) | (1L << (OPTIONS - 113)) | (1L << (OVERWRITE - 113)) | (1L << (PARTIAL - 113)) | (1L << (PARTITION - 113)) | (1L << (PARTITIONS - 113)))) != 0) || ((((_la - 177)) & ~0x3f) == 0 && ((1L << (_la - 177)) & ((1L << (PRECISION - 177)) | (1L << (PUBLIC - 177)) | (1L << (PURGE - 177)) | (1L << (QUARTER - 177)) | (1L << (RANGE - 177)) | (1L << (REGEXP - 177)) | (1L << (RLIKE - 177)) | (1L << (ROLLUP - 177)) | (1L << (SECOND - 177)) | (1L << (SERVER - 177)) | (1L << (SET - 177)) | (1L << (SIMILAR - 177)) | (1L << (SIMPLE - 177)) | (1L << (STORAGE - 177)) | (1L << (STDDEV_POP - 177)) | (1L << (STDDEV_SAMP - 177)) | (1L << (SUBPARTITION - 177)) | (1L << (SUM - 177)) | (1L << (TABLESPACE - 177)) | (1L << (THAN - 177)) | (1L << (TIMEZONE - 177)) | (1L << (TIMEZONE_HOUR - 177)) | (1L << (TIMEZONE_MINUTE - 177)) | (1L << (TRIM - 177)) | (1L << (TO - 177)) | (1L << (UNKNOWN - 177)) | (1L << (UNLOGGED - 177)) | (1L << (VALUES - 177)) | (1L << (VAR_SAMP - 177)) | (1L << (VAR_POP - 177)) | (1L << (VARYING - 177)) | (1L << (WEEK - 177)) | (1L << (WRAPPER - 177)) | (1L << (YEAR - 177)) | (1L << (ZONE - 177)) | (1L << (BOOLEAN - 177)) | (1L << (BOOL - 177)) | (1L << (BIT - 177)) | (1L << (VARBIT - 177)) | (1L << (INT1 - 177)) | (1L << (INT2 - 177)) | (1L << (INT4 - 177)) | (1L << (INT8 - 177)) | (1L << (TINYINT - 177)) | (1L << (SMALLINT - 177)) | (1L << (INT - 177)) | (1L << (INTEGER - 177)) | (1L << (BIGINT - 177)) | (1L << (FLOAT4 - 177)) | (1L << (FLOAT8 - 177)) | (1L << (REAL - 177)) | (1L << (FLOAT - 177)) | (1L << (DOUBLE - 177)) | (1L << (NUMERIC - 177)) | (1L << (DECIMAL - 177)) | (1L << (CHAR - 177)) | (1L << (VARCHAR - 177)) | (1L << (NCHAR - 177)) | (1L << (NVARCHAR - 177)) | (1L << (DATE - 177)) | (1L << (TIME - 177)))) != 0) || ((((_la - 241)) & ~0x3f) == 0 && ((1L << (_la - 241)) & ((1L << (TIMETZ - 241)) | (1L << (TIMESTAMP - 241)) | (1L << (TIMESTAMPTZ - 241)) | (1L << (TEXT - 241)) | (1L << (VARBINARY - 241)) | (1L << (BLOB - 241)) | (1L << (BYTEA - 241)) | (1L << (INET4 - 241)) | (1L << (QUOTE - 241)) | (1L << (Identifier - 241)))) != 0) );
				setState(1304); match(RIGHT_PAREN);
				setState(1305); index_parameters();
				setState(1311);
				_la = _input.LA(1);
				if (_la==WHERE) {
					{
					setState(1306); match(WHERE);
					setState(1307); match(LEFT_PAREN);
					setState(1308); ((Table_constraintContext)_localctx).predicat = identifier();
					setState(1309); match(RIGHT_PAREN);
					}
				}

				}
				}
				break;
			case FOREIGN:
				{
				{
				setState(1313); match(FOREIGN);
				setState(1314); match(KEY);
				setState(1315); match(LEFT_PAREN);
				setState(1320); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1316); ((Table_constraintContext)_localctx).column_name_for_key = identifier();
					setState(1318);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1317); match(COMMA);
						}
					}

					}
					}
					setState(1322); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 113)) & ~0x3f) == 0 && ((1L << (_la - 113)) & ((1L << (ADMIN - 113)) | (1L << (AVG - 113)) | (1L << (BETWEEN - 113)) | (1L << (BY - 113)) | (1L << (CENTURY - 113)) | (1L << (CHARACTER - 113)) | (1L << (CHECK - 113)) | (1L << (COLLECT - 113)) | (1L << (COALESCE - 113)) | (1L << (COLUMN - 113)) | (1L << (COMMENT - 113)) | (1L << (COMMENTS - 113)) | (1L << (COMMIT - 113)) | (1L << (COUNT - 113)) | (1L << (CUBE - 113)) | (1L << (DATA - 113)) | (1L << (DAY - 113)) | (1L << (DEC - 113)) | (1L << (DECADE - 113)) | (1L << (DOW - 113)) | (1L << (DOY - 113)) | (1L << (DROP - 113)) | (1L << (EPOCH - 113)) | (1L << (EVERY - 113)) | (1L << (EXISTS - 113)) | (1L << (EXTERNAL - 113)) | (1L << (EXTRACT - 113)) | (1L << (FILTER - 113)) | (1L << (FIRST - 113)) | (1L << (FORMAT - 113)) | (1L << (FUSION - 113)) | (1L << (GROUPING - 113)) | (1L << (HASH - 113)) | (1L << (INDEX - 113)) | (1L << (INSERT - 113)) | (1L << (INTERSECTION - 113)) | (1L << (ISODOW - 113)) | (1L << (ISOYEAR - 113)) | (1L << (LANGUAGE - 113)) | (1L << (LARGE - 113)) | (1L << (LAST - 113)) | (1L << (LESS - 113)) | (1L << (LIST - 113)) | (1L << (LOCATION - 113)) | (1L << (MATCH - 113)) | (1L << (MAX - 113)) | (1L << (MAXVALUE - 113)) | (1L << (MICROSECONDS - 113)) | (1L << (MILLENNIUM - 113)) | (1L << (MILLISECONDS - 113)) | (1L << (MIN - 113)) | (1L << (MINUTE - 113)) | (1L << (MONTH - 113)) | (1L << (NATIONAL - 113)) | (1L << (NULLIF - 113)) | (1L << (OBJECT - 113)) | (1L << (OPTION - 113)) | (1L << (OPTIONS - 113)) | (1L << (OVERWRITE - 113)) | (1L << (PARTIAL - 113)) | (1L << (PARTITION - 113)) | (1L << (PARTITIONS - 113)))) != 0) || ((((_la - 177)) & ~0x3f) == 0 && ((1L << (_la - 177)) & ((1L << (PRECISION - 177)) | (1L << (PUBLIC - 177)) | (1L << (PURGE - 177)) | (1L << (QUARTER - 177)) | (1L << (RANGE - 177)) | (1L << (REGEXP - 177)) | (1L << (RLIKE - 177)) | (1L << (ROLLUP - 177)) | (1L << (SECOND - 177)) | (1L << (SERVER - 177)) | (1L << (SET - 177)) | (1L << (SIMILAR - 177)) | (1L << (SIMPLE - 177)) | (1L << (STORAGE - 177)) | (1L << (STDDEV_POP - 177)) | (1L << (STDDEV_SAMP - 177)) | (1L << (SUBPARTITION - 177)) | (1L << (SUM - 177)) | (1L << (TABLESPACE - 177)) | (1L << (THAN - 177)) | (1L << (TIMEZONE - 177)) | (1L << (TIMEZONE_HOUR - 177)) | (1L << (TIMEZONE_MINUTE - 177)) | (1L << (TRIM - 177)) | (1L << (TO - 177)) | (1L << (UNKNOWN - 177)) | (1L << (UNLOGGED - 177)) | (1L << (VALUES - 177)) | (1L << (VAR_SAMP - 177)) | (1L << (VAR_POP - 177)) | (1L << (VARYING - 177)) | (1L << (WEEK - 177)) | (1L << (WRAPPER - 177)) | (1L << (YEAR - 177)) | (1L << (ZONE - 177)) | (1L << (BOOLEAN - 177)) | (1L << (BOOL - 177)) | (1L << (BIT - 177)) | (1L << (VARBIT - 177)) | (1L << (INT1 - 177)) | (1L << (INT2 - 177)) | (1L << (INT4 - 177)) | (1L << (INT8 - 177)) | (1L << (TINYINT - 177)) | (1L << (SMALLINT - 177)) | (1L << (INT - 177)) | (1L << (INTEGER - 177)) | (1L << (BIGINT - 177)) | (1L << (FLOAT4 - 177)) | (1L << (FLOAT8 - 177)) | (1L << (REAL - 177)) | (1L << (FLOAT - 177)) | (1L << (DOUBLE - 177)) | (1L << (NUMERIC - 177)) | (1L << (DECIMAL - 177)) | (1L << (CHAR - 177)) | (1L << (VARCHAR - 177)) | (1L << (NCHAR - 177)) | (1L << (NVARCHAR - 177)) | (1L << (DATE - 177)) | (1L << (TIME - 177)))) != 0) || ((((_la - 241)) & ~0x3f) == 0 && ((1L << (_la - 241)) & ((1L << (TIMETZ - 241)) | (1L << (TIMESTAMP - 241)) | (1L << (TIMESTAMPTZ - 241)) | (1L << (TEXT - 241)) | (1L << (VARBINARY - 241)) | (1L << (BLOB - 241)) | (1L << (BYTEA - 241)) | (1L << (INET4 - 241)) | (1L << (QUOTE - 241)) | (1L << (Identifier - 241)))) != 0) );
				setState(1324); match(RIGHT_PAREN);
				setState(1325); match(REFERENCES);
				setState(1326); ((Table_constraintContext)_localctx).reftable = identifier();
				setState(1338);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(1327); match(LEFT_PAREN);
					setState(1332); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1328); ((Table_constraintContext)_localctx).refcolumn = identifier();
						setState(1330);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1329); match(COMMA);
							}
						}

						}
						}
						setState(1334); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 113)) & ~0x3f) == 0 && ((1L << (_la - 113)) & ((1L << (ADMIN - 113)) | (1L << (AVG - 113)) | (1L << (BETWEEN - 113)) | (1L << (BY - 113)) | (1L << (CENTURY - 113)) | (1L << (CHARACTER - 113)) | (1L << (CHECK - 113)) | (1L << (COLLECT - 113)) | (1L << (COALESCE - 113)) | (1L << (COLUMN - 113)) | (1L << (COMMENT - 113)) | (1L << (COMMENTS - 113)) | (1L << (COMMIT - 113)) | (1L << (COUNT - 113)) | (1L << (CUBE - 113)) | (1L << (DATA - 113)) | (1L << (DAY - 113)) | (1L << (DEC - 113)) | (1L << (DECADE - 113)) | (1L << (DOW - 113)) | (1L << (DOY - 113)) | (1L << (DROP - 113)) | (1L << (EPOCH - 113)) | (1L << (EVERY - 113)) | (1L << (EXISTS - 113)) | (1L << (EXTERNAL - 113)) | (1L << (EXTRACT - 113)) | (1L << (FILTER - 113)) | (1L << (FIRST - 113)) | (1L << (FORMAT - 113)) | (1L << (FUSION - 113)) | (1L << (GROUPING - 113)) | (1L << (HASH - 113)) | (1L << (INDEX - 113)) | (1L << (INSERT - 113)) | (1L << (INTERSECTION - 113)) | (1L << (ISODOW - 113)) | (1L << (ISOYEAR - 113)) | (1L << (LANGUAGE - 113)) | (1L << (LARGE - 113)) | (1L << (LAST - 113)) | (1L << (LESS - 113)) | (1L << (LIST - 113)) | (1L << (LOCATION - 113)) | (1L << (MATCH - 113)) | (1L << (MAX - 113)) | (1L << (MAXVALUE - 113)) | (1L << (MICROSECONDS - 113)) | (1L << (MILLENNIUM - 113)) | (1L << (MILLISECONDS - 113)) | (1L << (MIN - 113)) | (1L << (MINUTE - 113)) | (1L << (MONTH - 113)) | (1L << (NATIONAL - 113)) | (1L << (NULLIF - 113)) | (1L << (OBJECT - 113)) | (1L << (OPTION - 113)) | (1L << (OPTIONS - 113)) | (1L << (OVERWRITE - 113)) | (1L << (PARTIAL - 113)) | (1L << (PARTITION - 113)) | (1L << (PARTITIONS - 113)))) != 0) || ((((_la - 177)) & ~0x3f) == 0 && ((1L << (_la - 177)) & ((1L << (PRECISION - 177)) | (1L << (PUBLIC - 177)) | (1L << (PURGE - 177)) | (1L << (QUARTER - 177)) | (1L << (RANGE - 177)) | (1L << (REGEXP - 177)) | (1L << (RLIKE - 177)) | (1L << (ROLLUP - 177)) | (1L << (SECOND - 177)) | (1L << (SERVER - 177)) | (1L << (SET - 177)) | (1L << (SIMILAR - 177)) | (1L << (SIMPLE - 177)) | (1L << (STORAGE - 177)) | (1L << (STDDEV_POP - 177)) | (1L << (STDDEV_SAMP - 177)) | (1L << (SUBPARTITION - 177)) | (1L << (SUM - 177)) | (1L << (TABLESPACE - 177)) | (1L << (THAN - 177)) | (1L << (TIMEZONE - 177)) | (1L << (TIMEZONE_HOUR - 177)) | (1L << (TIMEZONE_MINUTE - 177)) | (1L << (TRIM - 177)) | (1L << (TO - 177)) | (1L << (UNKNOWN - 177)) | (1L << (UNLOGGED - 177)) | (1L << (VALUES - 177)) | (1L << (VAR_SAMP - 177)) | (1L << (VAR_POP - 177)) | (1L << (VARYING - 177)) | (1L << (WEEK - 177)) | (1L << (WRAPPER - 177)) | (1L << (YEAR - 177)) | (1L << (ZONE - 177)) | (1L << (BOOLEAN - 177)) | (1L << (BOOL - 177)) | (1L << (BIT - 177)) | (1L << (VARBIT - 177)) | (1L << (INT1 - 177)) | (1L << (INT2 - 177)) | (1L << (INT4 - 177)) | (1L << (INT8 - 177)) | (1L << (TINYINT - 177)) | (1L << (SMALLINT - 177)) | (1L << (INT - 177)) | (1L << (INTEGER - 177)) | (1L << (BIGINT - 177)) | (1L << (FLOAT4 - 177)) | (1L << (FLOAT8 - 177)) | (1L << (REAL - 177)) | (1L << (FLOAT - 177)) | (1L << (DOUBLE - 177)) | (1L << (NUMERIC - 177)) | (1L << (DECIMAL - 177)) | (1L << (CHAR - 177)) | (1L << (VARCHAR - 177)) | (1L << (NCHAR - 177)) | (1L << (NVARCHAR - 177)) | (1L << (DATE - 177)) | (1L << (TIME - 177)))) != 0) || ((((_la - 241)) & ~0x3f) == 0 && ((1L << (_la - 241)) & ((1L << (TIMETZ - 241)) | (1L << (TIMESTAMP - 241)) | (1L << (TIMESTAMPTZ - 241)) | (1L << (TEXT - 241)) | (1L << (VARBINARY - 241)) | (1L << (BLOB - 241)) | (1L << (BYTEA - 241)) | (1L << (INET4 - 241)) | (1L << (QUOTE - 241)) | (1L << (Identifier - 241)))) != 0) );
					setState(1336); match(RIGHT_PAREN);
					}
				}

				setState(1346);
				switch ( getInterpreter().adaptivePredict(_input,184,_ctx) ) {
				case 1:
					{
					{
					setState(1340); match(MATCH);
					setState(1341); match(FULL);
					}
					}
					break;
				case 2:
					{
					{
					setState(1342); match(MATCH);
					setState(1343); match(PARTIAL);
					}
					}
					break;
				case 3:
					{
					{
					setState(1344); match(MATCH);
					setState(1345); match(SIMPLE);
					}
					}
					break;
				}
				setState(1351);
				switch ( getInterpreter().adaptivePredict(_input,185,_ctx) ) {
				case 1:
					{
					setState(1348); match(ON);
					setState(1349); match(DELETE);
					setState(1350); ((Table_constraintContext)_localctx).action_on_delete = action();
					}
					break;
				}
				setState(1356);
				_la = _input.LA(1);
				if (_la==ON) {
					{
					setState(1353); match(ON);
					setState(1354); match(UPDATE);
					setState(1355); ((Table_constraintContext)_localctx).action_on_update = action();
					}
				}

				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(1363);
			switch (_input.LA(1)) {
			case DEFERRABLE:
				{
				setState(1360); match(DEFERRABLE);
				}
				break;
			case NOT:
				{
				{
				setState(1361); match(NOT);
				setState(1362); match(DEFERRABLE);
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
			case CENTURY:
			case CHARACTER:
			case CHECK:
			case COLLECT:
			case COALESCE:
			case COLUMN:
			case COMMENT:
			case COMMENTS:
			case COMMIT:
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
			setState(1369);
			switch ( getInterpreter().adaptivePredict(_input,189,_ctx) ) {
			case 1:
				{
				{
				setState(1365); match(INITIALLY);
				setState(1366); match(DEFERRED);
				}
				}
				break;
			case 2:
				{
				{
				setState(1367); match(INITIALLY);
				setState(1368); match(IMMEDIATE);
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
		public Table_nameContext reftable;
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
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
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
		enterRule(_localctx, 36, RULE_column_constraint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1373);
			_la = _input.LA(1);
			if (_la==CONSTRAINT) {
				{
				setState(1371); match(CONSTRAINT);
				setState(1372); ((Column_constraintContext)_localctx).constraint_name = identifier();
				}
			}

			setState(1407);
			switch (_input.LA(1)) {
			case NOT:
				{
				{
				setState(1375); match(NOT);
				setState(1376); match(NULL);
				}
				}
				break;
			case NULL:
				{
				setState(1377); match(NULL);
				}
				break;
			case CHECK:
				{
				setState(1378); check_boolean_expression();
				}
				break;
			case DEFAULT:
				{
				{
				setState(1379); match(DEFAULT);
				setState(1380); ((Column_constraintContext)_localctx).default_expr = routine_invocation();
				}
				}
				break;
			case UNIQUE:
				{
				{
				setState(1381); match(UNIQUE);
				setState(1382); ((Column_constraintContext)_localctx).index_params_unique = index_parameters();
				}
				}
				break;
			case PRIMARY:
				{
				{
				setState(1383); match(PRIMARY);
				setState(1384); match(KEY);
				setState(1385); ((Column_constraintContext)_localctx).index_params_pr_key = index_parameters();
				}
				}
				break;
			case REFERENCES:
				{
				{
				setState(1386); match(REFERENCES);
				setState(1387); ((Column_constraintContext)_localctx).reftable = table_name();
				{
				{
				setState(1388); ((Column_constraintContext)_localctx).refcolumn = identifier();
				}
				}
				setState(1395);
				switch ( getInterpreter().adaptivePredict(_input,191,_ctx) ) {
				case 1:
					{
					setState(1389); match(MATCH);
					setState(1390); match(FULL);
					}
					break;
				case 2:
					{
					setState(1391); match(MATCH);
					setState(1392); match(PARTIAL);
					}
					break;
				case 3:
					{
					setState(1393); match(MATCH);
					setState(1394); match(SIMPLE);
					}
					break;
				}
				setState(1400);
				switch ( getInterpreter().adaptivePredict(_input,192,_ctx) ) {
				case 1:
					{
					setState(1397); match(ON);
					setState(1398); match(DELETE);
					setState(1399); ((Column_constraintContext)_localctx).action_on_delete = action();
					}
					break;
				}
				setState(1405);
				_la = _input.LA(1);
				if (_la==ON) {
					{
					setState(1402); match(ON);
					setState(1403); match(UPDATE);
					setState(1404); ((Column_constraintContext)_localctx).action_on_update = action();
					}
				}

				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(1412);
			switch ( getInterpreter().adaptivePredict(_input,195,_ctx) ) {
			case 1:
				{
				setState(1409); match(DEFERRABLE);
				}
				break;
			case 2:
				{
				{
				setState(1410); match(NOT);
				setState(1411); match(DEFERRABLE);
				}
				}
				break;
			}
			setState(1418);
			switch ( getInterpreter().adaptivePredict(_input,196,_ctx) ) {
			case 1:
				{
				{
				setState(1414); match(INITIALLY);
				setState(1415); match(DEFERRED);
				}
				}
				break;
			case 2:
				{
				{
				setState(1416); match(INITIALLY);
				setState(1417); match(IMMEDIATE);
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
		enterRule(_localctx, 38, RULE_check_boolean_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1420); match(CHECK);
			setState(1421); match(LEFT_PAREN);
			setState(1422); ((Check_boolean_expressionContext)_localctx).expression = boolean_value_expression();
			setState(1423); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 40, RULE_storage_parameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1425); match(WITH);
			setState(1426); match(LEFT_PAREN);
			setState(1435); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1427); ((Storage_parameterContext)_localctx).storage_param = identifier();
				setState(1430);
				_la = _input.LA(1);
				if (_la==EQUAL) {
					{
					setState(1428); match(EQUAL);
					setState(1429); ((Storage_parameterContext)_localctx).value = identifier();
					}
				}

				setState(1433);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(1432); match(COMMA);
					}
				}

				}
				}
				setState(1437); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 113)) & ~0x3f) == 0 && ((1L << (_la - 113)) & ((1L << (ADMIN - 113)) | (1L << (AVG - 113)) | (1L << (BETWEEN - 113)) | (1L << (BY - 113)) | (1L << (CENTURY - 113)) | (1L << (CHARACTER - 113)) | (1L << (CHECK - 113)) | (1L << (COLLECT - 113)) | (1L << (COALESCE - 113)) | (1L << (COLUMN - 113)) | (1L << (COMMENT - 113)) | (1L << (COMMENTS - 113)) | (1L << (COMMIT - 113)) | (1L << (COUNT - 113)) | (1L << (CUBE - 113)) | (1L << (DATA - 113)) | (1L << (DAY - 113)) | (1L << (DEC - 113)) | (1L << (DECADE - 113)) | (1L << (DOW - 113)) | (1L << (DOY - 113)) | (1L << (DROP - 113)) | (1L << (EPOCH - 113)) | (1L << (EVERY - 113)) | (1L << (EXISTS - 113)) | (1L << (EXTERNAL - 113)) | (1L << (EXTRACT - 113)) | (1L << (FILTER - 113)) | (1L << (FIRST - 113)) | (1L << (FORMAT - 113)) | (1L << (FUSION - 113)) | (1L << (GROUPING - 113)) | (1L << (HASH - 113)) | (1L << (INDEX - 113)) | (1L << (INSERT - 113)) | (1L << (INTERSECTION - 113)) | (1L << (ISODOW - 113)) | (1L << (ISOYEAR - 113)) | (1L << (LANGUAGE - 113)) | (1L << (LARGE - 113)) | (1L << (LAST - 113)) | (1L << (LESS - 113)) | (1L << (LIST - 113)) | (1L << (LOCATION - 113)) | (1L << (MATCH - 113)) | (1L << (MAX - 113)) | (1L << (MAXVALUE - 113)) | (1L << (MICROSECONDS - 113)) | (1L << (MILLENNIUM - 113)) | (1L << (MILLISECONDS - 113)) | (1L << (MIN - 113)) | (1L << (MINUTE - 113)) | (1L << (MONTH - 113)) | (1L << (NATIONAL - 113)) | (1L << (NULLIF - 113)) | (1L << (OBJECT - 113)) | (1L << (OPTION - 113)) | (1L << (OPTIONS - 113)) | (1L << (OVERWRITE - 113)) | (1L << (PARTIAL - 113)) | (1L << (PARTITION - 113)) | (1L << (PARTITIONS - 113)))) != 0) || ((((_la - 177)) & ~0x3f) == 0 && ((1L << (_la - 177)) & ((1L << (PRECISION - 177)) | (1L << (PUBLIC - 177)) | (1L << (PURGE - 177)) | (1L << (QUARTER - 177)) | (1L << (RANGE - 177)) | (1L << (REGEXP - 177)) | (1L << (RLIKE - 177)) | (1L << (ROLLUP - 177)) | (1L << (SECOND - 177)) | (1L << (SERVER - 177)) | (1L << (SET - 177)) | (1L << (SIMILAR - 177)) | (1L << (SIMPLE - 177)) | (1L << (STORAGE - 177)) | (1L << (STDDEV_POP - 177)) | (1L << (STDDEV_SAMP - 177)) | (1L << (SUBPARTITION - 177)) | (1L << (SUM - 177)) | (1L << (TABLESPACE - 177)) | (1L << (THAN - 177)) | (1L << (TIMEZONE - 177)) | (1L << (TIMEZONE_HOUR - 177)) | (1L << (TIMEZONE_MINUTE - 177)) | (1L << (TRIM - 177)) | (1L << (TO - 177)) | (1L << (UNKNOWN - 177)) | (1L << (UNLOGGED - 177)) | (1L << (VALUES - 177)) | (1L << (VAR_SAMP - 177)) | (1L << (VAR_POP - 177)) | (1L << (VARYING - 177)) | (1L << (WEEK - 177)) | (1L << (WRAPPER - 177)) | (1L << (YEAR - 177)) | (1L << (ZONE - 177)) | (1L << (BOOLEAN - 177)) | (1L << (BOOL - 177)) | (1L << (BIT - 177)) | (1L << (VARBIT - 177)) | (1L << (INT1 - 177)) | (1L << (INT2 - 177)) | (1L << (INT4 - 177)) | (1L << (INT8 - 177)) | (1L << (TINYINT - 177)) | (1L << (SMALLINT - 177)) | (1L << (INT - 177)) | (1L << (INTEGER - 177)) | (1L << (BIGINT - 177)) | (1L << (FLOAT4 - 177)) | (1L << (FLOAT8 - 177)) | (1L << (REAL - 177)) | (1L << (FLOAT - 177)) | (1L << (DOUBLE - 177)) | (1L << (NUMERIC - 177)) | (1L << (DECIMAL - 177)) | (1L << (CHAR - 177)) | (1L << (VARCHAR - 177)) | (1L << (NCHAR - 177)) | (1L << (NVARCHAR - 177)) | (1L << (DATE - 177)) | (1L << (TIME - 177)))) != 0) || ((((_la - 241)) & ~0x3f) == 0 && ((1L << (_la - 241)) & ((1L << (TIMETZ - 241)) | (1L << (TIMESTAMP - 241)) | (1L << (TIMESTAMPTZ - 241)) | (1L << (TEXT - 241)) | (1L << (VARBINARY - 241)) | (1L << (BLOB - 241)) | (1L << (BYTEA - 241)) | (1L << (INET4 - 241)) | (1L << (QUOTE - 241)) | (1L << (Identifier - 241)))) != 0) );
			setState(1439); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 42, RULE_storage_parameter_oid);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1446);
			switch ( getInterpreter().adaptivePredict(_input,200,_ctx) ) {
			case 1:
				{
				setState(1441); storage_parameter();
				}
				break;
			case 2:
				{
				{
				setState(1442); match(WITH);
				setState(1443); match(OIDS);
				}
				}
				break;
			case 3:
				{
				{
				setState(1444); match(WITHOUT);
				setState(1445); match(OIDS);
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
		enterRule(_localctx, 44, RULE_on_commit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1457);
			_la = _input.LA(1);
			if (_la==ON) {
				{
				setState(1448); match(ON);
				setState(1449); match(COMMIT);
				setState(1455);
				switch (_input.LA(1)) {
				case PRESERVE:
					{
					{
					setState(1450); match(PRESERVE);
					setState(1451); match(ROWS);
					}
					}
					break;
				case DELETE:
					{
					{
					setState(1452); match(DELETE);
					setState(1453); match(ROWS);
					}
					}
					break;
				case DROP:
					{
					setState(1454); match(DROP);
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
		enterRule(_localctx, 46, RULE_table_space);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1461);
			switch ( getInterpreter().adaptivePredict(_input,203,_ctx) ) {
			case 1:
				{
				setState(1459); match(TABLESPACE);
				setState(1460); ((Table_spaceContext)_localctx).tablespace = identifier();
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
		enterRule(_localctx, 48, RULE_action);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1469);
			switch ( getInterpreter().adaptivePredict(_input,204,_ctx) ) {
			case 1:
				{
				setState(1463); match(RESTRICT);
				}
				break;
			case 2:
				{
				setState(1464); match(CASCADE);
				}
				break;
			case 3:
				{
				setState(1465); match(SET);
				setState(1466); match(NULL);
				}
				break;
			case 4:
				{
				setState(1467); match(SET);
				setState(1468); match(DEFAULT);
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
		enterRule(_localctx, 50, RULE_index_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1472);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(1471); storage_parameter();
				}
			}

			setState(1478);
			_la = _input.LA(1);
			if (_la==USING) {
				{
				setState(1474); match(USING);
				setState(1475); match(INDEX);
				setState(1476); match(TABLESPACE);
				setState(1477); ((Index_parametersContext)_localctx).tablespace = identifier();
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
		enterRule(_localctx, 52, RULE_table_elements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1480); match(LEFT_PAREN);
			setState(1481); field_element();
			setState(1486);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1482); match(COMMA);
				setState(1483); field_element();
				}
				}
				setState(1488);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1489); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 54, RULE_field_element);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1491); ((Field_elementContext)_localctx).name = identifier();
			setState(1492); field_type();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 56, RULE_field_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1494); data_type();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 58, RULE_param_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1496); match(WITH);
			setState(1497); match(LEFT_PAREN);
			setState(1498); param();
			setState(1503);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1499); match(COMMA);
				setState(1500); param();
				}
				}
				setState(1505);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1506); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 60, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1508); ((ParamContext)_localctx).key = match(Character_String_Literal);
			setState(1509); match(EQUAL);
			setState(1510); ((ParamContext)_localctx).value = numeric_value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 62, RULE_method_specifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1512); match(USING);
			setState(1513); ((Method_specifierContext)_localctx).m = identifier();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 64, RULE_table_space_specifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1515); match(TABLESPACE);
			setState(1516); table_space_name();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 66, RULE_table_space_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1518); identifier();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 68, RULE_table_partitioning_clauses);
		try {
			setState(1524);
			switch ( getInterpreter().adaptivePredict(_input,209,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1520); range_partitions();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1521); hash_partitions();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1522); list_partitions();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1523); column_partitions();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 70, RULE_range_partitions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1526); match(PARTITION);
			setState(1527); match(BY);
			setState(1528); match(RANGE);
			setState(1529); match(LEFT_PAREN);
			setState(1530); column_reference_list();
			setState(1531); match(RIGHT_PAREN);
			setState(1532); match(LEFT_PAREN);
			setState(1533); range_value_clause_list();
			setState(1534); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 72, RULE_range_value_clause_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1536); range_value_clause();
			setState(1541);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1537); match(COMMA);
				setState(1538); range_value_clause();
				}
				}
				setState(1543);
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
		enterRule(_localctx, 74, RULE_range_value_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1544); match(PARTITION);
			setState(1545); partition_name();
			setState(1546); match(VALUES);
			setState(1547); match(LESS);
			setState(1548); match(THAN);
			setState(1560);
			switch ( getInterpreter().adaptivePredict(_input,213,_ctx) ) {
			case 1:
				{
				setState(1549); match(LEFT_PAREN);
				setState(1550); value_expression();
				setState(1551); match(RIGHT_PAREN);
				}
				break;
			case 2:
				{
				setState(1554);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(1553); match(LEFT_PAREN);
					}
				}

				setState(1556); match(MAXVALUE);
				setState(1558);
				switch ( getInterpreter().adaptivePredict(_input,212,_ctx) ) {
				case 1:
					{
					setState(1557); match(RIGHT_PAREN);
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
		enterRule(_localctx, 76, RULE_hash_partitions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1562); match(PARTITION);
			setState(1563); match(BY);
			setState(1564); match(HASH);
			setState(1565); match(LEFT_PAREN);
			setState(1566); column_reference_list();
			setState(1567); match(RIGHT_PAREN);
			setState(1573);
			switch (_input.LA(1)) {
			case LEFT_PAREN:
				{
				setState(1568); match(LEFT_PAREN);
				setState(1569); individual_hash_partitions();
				setState(1570); match(RIGHT_PAREN);
				}
				break;
			case PARTITIONS:
				{
				setState(1572); hash_partitions_by_quantity();
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
		enterRule(_localctx, 78, RULE_individual_hash_partitions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1575); individual_hash_partition();
			setState(1580);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1576); match(COMMA);
				setState(1577); individual_hash_partition();
				}
				}
				setState(1582);
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
		enterRule(_localctx, 80, RULE_individual_hash_partition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1583); match(PARTITION);
			setState(1584); partition_name();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 82, RULE_hash_partitions_by_quantity);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1586); match(PARTITIONS);
			setState(1587); ((Hash_partitions_by_quantityContext)_localctx).quantity = numeric_value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 84, RULE_list_partitions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1589); match(PARTITION);
			setState(1590); match(BY);
			setState(1591); match(LIST);
			setState(1592); match(LEFT_PAREN);
			setState(1593); column_reference_list();
			setState(1594); match(RIGHT_PAREN);
			setState(1595); match(LEFT_PAREN);
			setState(1596); list_value_clause_list();
			setState(1597); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 86, RULE_list_value_clause_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1599); list_value_partition();
			setState(1604);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1600); match(COMMA);
				setState(1601); list_value_partition();
				}
				}
				setState(1606);
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
		enterRule(_localctx, 88, RULE_list_value_partition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1607); match(PARTITION);
			setState(1608); partition_name();
			setState(1609); match(VALUES);
			setState(1611);
			_la = _input.LA(1);
			if (_la==IN) {
				{
				setState(1610); match(IN);
				}
			}

			setState(1613); match(LEFT_PAREN);
			setState(1614); in_value_list();
			setState(1615); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 90, RULE_column_partitions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1617); match(PARTITION);
			setState(1618); match(BY);
			setState(1619); match(COLUMN);
			setState(1620); table_elements();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 92, RULE_partition_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1622); identifier();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 94, RULE_drop_table_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1624); match(DROP);
			setState(1625); match(TABLE);
			setState(1626); table_name();
			setState(1628);
			switch ( getInterpreter().adaptivePredict(_input,218,_ctx) ) {
			case 1:
				{
				setState(1627); match(PURGE);
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
		enterRule(_localctx, 96, RULE_identifier);
		int _la;
		try {
			setState(1638);
			switch (_input.LA(1)) {
			case QUOTE:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(1631);
				_la = _input.LA(1);
				if (_la==QUOTE) {
					{
					setState(1630); match(QUOTE);
					}
				}

				setState(1633); match(Identifier);
				setState(1635);
				switch ( getInterpreter().adaptivePredict(_input,220,_ctx) ) {
				case 1:
					{
					setState(1634); match(QUOTE);
					}
					break;
				}
				}
				break;
			case ADMIN:
			case AVG:
			case BETWEEN:
			case BY:
			case CENTURY:
			case CHARACTER:
			case CHECK:
			case COLLECT:
			case COALESCE:
			case COLUMN:
			case COMMENT:
			case COMMENTS:
			case COMMIT:
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
				setState(1637); nonreserved_keywords();
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
		public TerminalNode COALESCE() { return getToken(SQLParser.COALESCE, 0); }
		public TerminalNode STDDEV_POP() { return getToken(SQLParser.STDDEV_POP, 0); }
		public TerminalNode VAR_SAMP() { return getToken(SQLParser.VAR_SAMP, 0); }
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
		public TerminalNode VARYING() { return getToken(SQLParser.VARYING, 0); }
		public TerminalNode YEAR() { return getToken(SQLParser.YEAR, 0); }
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
		public TerminalNode MINUTE() { return getToken(SQLParser.MINUTE, 0); }
		public TerminalNode LAST() { return getToken(SQLParser.LAST, 0); }
		public TerminalNode COLUMN() { return getToken(SQLParser.COLUMN, 0); }
		public TerminalNode PUBLIC() { return getToken(SQLParser.PUBLIC, 0); }
		public TerminalNode DATA() { return getToken(SQLParser.DATA, 0); }
		public TerminalNode OVERWRITE() { return getToken(SQLParser.OVERWRITE, 0); }
		public TerminalNode NCHAR() { return getToken(SQLParser.NCHAR, 0); }
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
		public TerminalNode FUSION() { return getToken(SQLParser.FUSION, 0); }
		public TerminalNode UNLOGGED() { return getToken(SQLParser.UNLOGGED, 0); }
		public TerminalNode COMMIT() { return getToken(SQLParser.COMMIT, 0); }
		public TerminalNode INT2() { return getToken(SQLParser.INT2, 0); }
		public TerminalNode VARBIT() { return getToken(SQLParser.VARBIT, 0); }
		public TerminalNode ZONE() { return getToken(SQLParser.ZONE, 0); }
		public TerminalNode WEEK() { return getToken(SQLParser.WEEK, 0); }
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
		public TerminalNode COMMENTS() { return getToken(SQLParser.COMMENTS, 0); }
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
		enterRule(_localctx, 98, RULE_nonreserved_keywords);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1640);
			_la = _input.LA(1);
			if ( !(((((_la - 113)) & ~0x3f) == 0 && ((1L << (_la - 113)) & ((1L << (ADMIN - 113)) | (1L << (AVG - 113)) | (1L << (BETWEEN - 113)) | (1L << (BY - 113)) | (1L << (CENTURY - 113)) | (1L << (CHARACTER - 113)) | (1L << (CHECK - 113)) | (1L << (COLLECT - 113)) | (1L << (COALESCE - 113)) | (1L << (COLUMN - 113)) | (1L << (COMMENT - 113)) | (1L << (COMMENTS - 113)) | (1L << (COMMIT - 113)) | (1L << (COUNT - 113)) | (1L << (CUBE - 113)) | (1L << (DATA - 113)) | (1L << (DAY - 113)) | (1L << (DEC - 113)) | (1L << (DECADE - 113)) | (1L << (DOW - 113)) | (1L << (DOY - 113)) | (1L << (DROP - 113)) | (1L << (EPOCH - 113)) | (1L << (EVERY - 113)) | (1L << (EXISTS - 113)) | (1L << (EXTERNAL - 113)) | (1L << (EXTRACT - 113)) | (1L << (FILTER - 113)) | (1L << (FIRST - 113)) | (1L << (FORMAT - 113)) | (1L << (FUSION - 113)) | (1L << (GROUPING - 113)) | (1L << (HASH - 113)) | (1L << (INDEX - 113)) | (1L << (INSERT - 113)) | (1L << (INTERSECTION - 113)) | (1L << (ISODOW - 113)) | (1L << (ISOYEAR - 113)) | (1L << (LANGUAGE - 113)) | (1L << (LARGE - 113)) | (1L << (LAST - 113)) | (1L << (LESS - 113)) | (1L << (LIST - 113)) | (1L << (LOCATION - 113)) | (1L << (MATCH - 113)) | (1L << (MAX - 113)) | (1L << (MAXVALUE - 113)) | (1L << (MICROSECONDS - 113)) | (1L << (MILLENNIUM - 113)) | (1L << (MILLISECONDS - 113)) | (1L << (MIN - 113)) | (1L << (MINUTE - 113)) | (1L << (MONTH - 113)) | (1L << (NATIONAL - 113)) | (1L << (NULLIF - 113)) | (1L << (OBJECT - 113)) | (1L << (OPTION - 113)) | (1L << (OPTIONS - 113)) | (1L << (OVERWRITE - 113)) | (1L << (PARTIAL - 113)) | (1L << (PARTITION - 113)) | (1L << (PARTITIONS - 113)))) != 0) || ((((_la - 177)) & ~0x3f) == 0 && ((1L << (_la - 177)) & ((1L << (PRECISION - 177)) | (1L << (PUBLIC - 177)) | (1L << (PURGE - 177)) | (1L << (QUARTER - 177)) | (1L << (RANGE - 177)) | (1L << (REGEXP - 177)) | (1L << (RLIKE - 177)) | (1L << (ROLLUP - 177)) | (1L << (SECOND - 177)) | (1L << (SERVER - 177)) | (1L << (SET - 177)) | (1L << (SIMILAR - 177)) | (1L << (SIMPLE - 177)) | (1L << (STORAGE - 177)) | (1L << (STDDEV_POP - 177)) | (1L << (STDDEV_SAMP - 177)) | (1L << (SUBPARTITION - 177)) | (1L << (SUM - 177)) | (1L << (TABLESPACE - 177)) | (1L << (THAN - 177)) | (1L << (TIMEZONE - 177)) | (1L << (TIMEZONE_HOUR - 177)) | (1L << (TIMEZONE_MINUTE - 177)) | (1L << (TRIM - 177)) | (1L << (TO - 177)) | (1L << (UNKNOWN - 177)) | (1L << (UNLOGGED - 177)) | (1L << (VALUES - 177)) | (1L << (VAR_SAMP - 177)) | (1L << (VAR_POP - 177)) | (1L << (VARYING - 177)) | (1L << (WEEK - 177)) | (1L << (WRAPPER - 177)) | (1L << (YEAR - 177)) | (1L << (ZONE - 177)) | (1L << (BOOLEAN - 177)) | (1L << (BOOL - 177)) | (1L << (BIT - 177)) | (1L << (VARBIT - 177)) | (1L << (INT1 - 177)) | (1L << (INT2 - 177)) | (1L << (INT4 - 177)) | (1L << (INT8 - 177)) | (1L << (TINYINT - 177)) | (1L << (SMALLINT - 177)) | (1L << (INT - 177)) | (1L << (INTEGER - 177)) | (1L << (BIGINT - 177)) | (1L << (FLOAT4 - 177)) | (1L << (FLOAT8 - 177)) | (1L << (REAL - 177)) | (1L << (FLOAT - 177)) | (1L << (DOUBLE - 177)) | (1L << (NUMERIC - 177)) | (1L << (DECIMAL - 177)) | (1L << (CHAR - 177)) | (1L << (VARCHAR - 177)) | (1L << (NCHAR - 177)) | (1L << (NVARCHAR - 177)) | (1L << (DATE - 177)) | (1L << (TIME - 177)))) != 0) || ((((_la - 241)) & ~0x3f) == 0 && ((1L << (_la - 241)) & ((1L << (TIMETZ - 241)) | (1L << (TIMESTAMP - 241)) | (1L << (TIMESTAMPTZ - 241)) | (1L << (TEXT - 241)) | (1L << (VARBINARY - 241)) | (1L << (BLOB - 241)) | (1L << (BYTEA - 241)) | (1L << (INET4 - 241)))) != 0)) ) {
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
		enterRule(_localctx, 100, RULE_unsigned_literal);
		try {
			setState(1644);
			switch (_input.LA(1)) {
			case NUMBER:
			case REAL_NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(1642); unsigned_numeric_literal();
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
				setState(1643); general_literal();
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
		enterRule(_localctx, 102, RULE_general_literal);
		try {
			setState(1649);
			switch (_input.LA(1)) {
			case Character_String_Literal:
				enterOuterAlt(_localctx, 1);
				{
				setState(1646); match(Character_String_Literal);
				}
				break;
			case DATE:
			case TIME:
			case TIMESTAMP:
				enterOuterAlt(_localctx, 2);
				{
				setState(1647); datetime_literal();
				}
				break;
			case FALSE:
			case TRUE:
			case UNKNOWN:
				enterOuterAlt(_localctx, 3);
				{
				setState(1648); boolean_literal();
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
		enterRule(_localctx, 104, RULE_datetime_literal);
		try {
			setState(1654);
			switch (_input.LA(1)) {
			case TIMESTAMP:
				enterOuterAlt(_localctx, 1);
				{
				setState(1651); timestamp_literal();
				}
				break;
			case TIME:
				enterOuterAlt(_localctx, 2);
				{
				setState(1652); time_literal();
				}
				break;
			case DATE:
				enterOuterAlt(_localctx, 3);
				{
				setState(1653); date_literal();
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
		enterRule(_localctx, 106, RULE_time_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1656); match(TIME);
			setState(1657); ((Time_literalContext)_localctx).time_string = match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 108, RULE_timestamp_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1659); match(TIMESTAMP);
			setState(1660); ((Timestamp_literalContext)_localctx).timestamp_string = match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 110, RULE_date_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1662); match(DATE);
			setState(1663); ((Date_literalContext)_localctx).date_string = match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 112, RULE_boolean_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1665);
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
		enterRule(_localctx, 114, RULE_data_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1667); predefined_type();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 116, RULE_predefined_type);
		try {
			setState(1679);
			switch (_input.LA(1)) {
			case CHARACTER:
			case CHAR:
			case VARCHAR:
			case TEXT:
				enterOuterAlt(_localctx, 1);
				{
				setState(1669); character_string_type();
				}
				break;
			case NATIONAL:
			case NCHAR:
			case NVARCHAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(1670); national_character_string_type();
				}
				break;
			case BLOB:
			case BYTEA:
				enterOuterAlt(_localctx, 3);
				{
				setState(1671); binary_large_object_string_type();
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
				setState(1672); numeric_type();
				}
				break;
			case BOOLEAN:
			case BOOL:
				enterOuterAlt(_localctx, 5);
				{
				setState(1673); boolean_type();
				}
				break;
			case DATE:
			case TIME:
			case TIMETZ:
			case TIMESTAMP:
			case TIMESTAMPTZ:
				enterOuterAlt(_localctx, 6);
				{
				setState(1674); datetime_type();
				}
				break;
			case BIT:
			case VARBIT:
				enterOuterAlt(_localctx, 7);
				{
				setState(1675); bit_type();
				}
				break;
			case BINARY:
			case VARBINARY:
				enterOuterAlt(_localctx, 8);
				{
				setState(1676); binary_type();
				}
				break;
			case INET4:
				enterOuterAlt(_localctx, 9);
				{
				setState(1677); network_type();
				}
				break;
			case REGCLASS:
				enterOuterAlt(_localctx, 10);
				{
				setState(1678); regclass();
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
		enterRule(_localctx, 118, RULE_regclass);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1681); match(REGCLASS);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 120, RULE_network_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1683); match(INET4);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 122, RULE_character_string_type);
		try {
			setState(1708);
			switch ( getInterpreter().adaptivePredict(_input,231,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1685); match(CHARACTER);
				setState(1687);
				switch ( getInterpreter().adaptivePredict(_input,226,_ctx) ) {
				case 1:
					{
					setState(1686); type_length();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1689); match(CHAR);
				setState(1691);
				switch ( getInterpreter().adaptivePredict(_input,227,_ctx) ) {
				case 1:
					{
					setState(1690); type_length();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1693); match(CHARACTER);
				setState(1694); match(VARYING);
				setState(1696);
				switch ( getInterpreter().adaptivePredict(_input,228,_ctx) ) {
				case 1:
					{
					setState(1695); type_length();
					}
					break;
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1698); match(CHAR);
				setState(1699); match(VARYING);
				setState(1701);
				switch ( getInterpreter().adaptivePredict(_input,229,_ctx) ) {
				case 1:
					{
					setState(1700); type_length();
					}
					break;
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1703); match(VARCHAR);
				setState(1705);
				switch ( getInterpreter().adaptivePredict(_input,230,_ctx) ) {
				case 1:
					{
					setState(1704); type_length();
					}
					break;
				}
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1707); match(TEXT);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 124, RULE_type_length);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1710); match(LEFT_PAREN);
			setState(1711); match(NUMBER);
			setState(1712); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 126, RULE_national_character_string_type);
		try {
			setState(1749);
			switch ( getInterpreter().adaptivePredict(_input,239,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1714); match(NATIONAL);
				setState(1715); match(CHARACTER);
				setState(1717);
				switch ( getInterpreter().adaptivePredict(_input,232,_ctx) ) {
				case 1:
					{
					setState(1716); type_length();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1719); match(NATIONAL);
				setState(1720); match(CHAR);
				setState(1722);
				switch ( getInterpreter().adaptivePredict(_input,233,_ctx) ) {
				case 1:
					{
					setState(1721); type_length();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1724); match(NCHAR);
				setState(1726);
				switch ( getInterpreter().adaptivePredict(_input,234,_ctx) ) {
				case 1:
					{
					setState(1725); type_length();
					}
					break;
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1728); match(NATIONAL);
				setState(1729); match(CHARACTER);
				setState(1730); match(VARYING);
				setState(1732);
				switch ( getInterpreter().adaptivePredict(_input,235,_ctx) ) {
				case 1:
					{
					setState(1731); type_length();
					}
					break;
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1734); match(NATIONAL);
				setState(1735); match(CHAR);
				setState(1736); match(VARYING);
				setState(1738);
				switch ( getInterpreter().adaptivePredict(_input,236,_ctx) ) {
				case 1:
					{
					setState(1737); type_length();
					}
					break;
				}
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1740); match(NCHAR);
				setState(1741); match(VARYING);
				setState(1743);
				switch ( getInterpreter().adaptivePredict(_input,237,_ctx) ) {
				case 1:
					{
					setState(1742); type_length();
					}
					break;
				}
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1745); match(NVARCHAR);
				setState(1747);
				switch ( getInterpreter().adaptivePredict(_input,238,_ctx) ) {
				case 1:
					{
					setState(1746); type_length();
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
		enterRule(_localctx, 128, RULE_binary_large_object_string_type);
		try {
			setState(1759);
			switch (_input.LA(1)) {
			case BLOB:
				enterOuterAlt(_localctx, 1);
				{
				setState(1751); match(BLOB);
				setState(1753);
				switch ( getInterpreter().adaptivePredict(_input,240,_ctx) ) {
				case 1:
					{
					setState(1752); type_length();
					}
					break;
				}
				}
				break;
			case BYTEA:
				enterOuterAlt(_localctx, 2);
				{
				setState(1755); match(BYTEA);
				setState(1757);
				switch ( getInterpreter().adaptivePredict(_input,241,_ctx) ) {
				case 1:
					{
					setState(1756); type_length();
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
		enterRule(_localctx, 130, RULE_numeric_type);
		try {
			setState(1763);
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
				setState(1761); exact_numeric_type();
				}
				break;
			case FLOAT4:
			case FLOAT8:
			case REAL:
			case FLOAT:
			case DOUBLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(1762); approximate_numeric_type();
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
		enterRule(_localctx, 132, RULE_exact_numeric_type);
		try {
			setState(1786);
			switch (_input.LA(1)) {
			case NUMERIC:
				enterOuterAlt(_localctx, 1);
				{
				setState(1765); match(NUMERIC);
				setState(1767);
				switch ( getInterpreter().adaptivePredict(_input,244,_ctx) ) {
				case 1:
					{
					setState(1766); precision_param();
					}
					break;
				}
				}
				break;
			case DECIMAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(1769); match(DECIMAL);
				setState(1771);
				switch ( getInterpreter().adaptivePredict(_input,245,_ctx) ) {
				case 1:
					{
					setState(1770); precision_param();
					}
					break;
				}
				}
				break;
			case DEC:
				enterOuterAlt(_localctx, 3);
				{
				setState(1773); match(DEC);
				setState(1775);
				switch ( getInterpreter().adaptivePredict(_input,246,_ctx) ) {
				case 1:
					{
					setState(1774); precision_param();
					}
					break;
				}
				}
				break;
			case INT1:
				enterOuterAlt(_localctx, 4);
				{
				setState(1777); match(INT1);
				}
				break;
			case TINYINT:
				enterOuterAlt(_localctx, 5);
				{
				setState(1778); match(TINYINT);
				}
				break;
			case INT2:
				enterOuterAlt(_localctx, 6);
				{
				setState(1779); match(INT2);
				}
				break;
			case SMALLINT:
				enterOuterAlt(_localctx, 7);
				{
				setState(1780); match(SMALLINT);
				}
				break;
			case INT4:
				enterOuterAlt(_localctx, 8);
				{
				setState(1781); match(INT4);
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 9);
				{
				setState(1782); match(INT);
				}
				break;
			case INTEGER:
				enterOuterAlt(_localctx, 10);
				{
				setState(1783); match(INTEGER);
				}
				break;
			case INT8:
				enterOuterAlt(_localctx, 11);
				{
				setState(1784); match(INT8);
				}
				break;
			case BIGINT:
				enterOuterAlt(_localctx, 12);
				{
				setState(1785); match(BIGINT);
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
		enterRule(_localctx, 134, RULE_approximate_numeric_type);
		try {
			setState(1798);
			switch ( getInterpreter().adaptivePredict(_input,249,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1788); match(FLOAT);
				setState(1790);
				switch ( getInterpreter().adaptivePredict(_input,248,_ctx) ) {
				case 1:
					{
					setState(1789); precision_param();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1792); match(FLOAT4);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1793); match(REAL);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1794); match(FLOAT8);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1795); match(DOUBLE);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1796); match(DOUBLE);
				setState(1797); match(PRECISION);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 136, RULE_precision_param);
		try {
			setState(1808);
			switch ( getInterpreter().adaptivePredict(_input,250,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1800); match(LEFT_PAREN);
				setState(1801); ((Precision_paramContext)_localctx).precision = match(NUMBER);
				setState(1802); match(RIGHT_PAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1803); match(LEFT_PAREN);
				setState(1804); ((Precision_paramContext)_localctx).precision = match(NUMBER);
				setState(1805); match(COMMA);
				setState(1806); ((Precision_paramContext)_localctx).scale = match(NUMBER);
				setState(1807); match(RIGHT_PAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 138, RULE_boolean_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1810);
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
		enterRule(_localctx, 140, RULE_datetime_type);
		try {
			setState(1825);
			switch ( getInterpreter().adaptivePredict(_input,251,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1812); match(DATE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1813); match(TIME);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1814); match(TIME);
				setState(1815); match(WITH);
				setState(1816); match(TIME);
				setState(1817); match(ZONE);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1818); match(TIMETZ);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1819); match(TIMESTAMP);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1820); match(TIMESTAMP);
				setState(1821); match(WITH);
				setState(1822); match(TIME);
				setState(1823); match(ZONE);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1824); match(TIMESTAMPTZ);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 142, RULE_bit_type);
		try {
			setState(1840);
			switch ( getInterpreter().adaptivePredict(_input,255,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1827); match(BIT);
				setState(1829);
				switch ( getInterpreter().adaptivePredict(_input,252,_ctx) ) {
				case 1:
					{
					setState(1828); type_length();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1831); match(VARBIT);
				setState(1833);
				switch ( getInterpreter().adaptivePredict(_input,253,_ctx) ) {
				case 1:
					{
					setState(1832); type_length();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1835); match(BIT);
				setState(1836); match(VARYING);
				setState(1838);
				switch ( getInterpreter().adaptivePredict(_input,254,_ctx) ) {
				case 1:
					{
					setState(1837); type_length();
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
		enterRule(_localctx, 144, RULE_binary_type);
		try {
			setState(1855);
			switch ( getInterpreter().adaptivePredict(_input,259,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1842); match(BINARY);
				setState(1844);
				switch ( getInterpreter().adaptivePredict(_input,256,_ctx) ) {
				case 1:
					{
					setState(1843); type_length();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1846); match(BINARY);
				setState(1847); match(VARYING);
				setState(1849);
				switch ( getInterpreter().adaptivePredict(_input,257,_ctx) ) {
				case 1:
					{
					setState(1848); type_length();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1851); match(VARBINARY);
				setState(1853);
				switch ( getInterpreter().adaptivePredict(_input,258,_ctx) ) {
				case 1:
					{
					setState(1852); type_length();
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
		enterRule(_localctx, 146, RULE_value_expression_primary);
		try {
			setState(1859);
			switch ( getInterpreter().adaptivePredict(_input,260,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1857); parenthesized_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1858); nonparenthesized_value_expression_primary();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 148, RULE_parenthesized_value_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1861); match(LEFT_PAREN);
			setState(1862); value_expression();
			setState(1863); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 150, RULE_nonparenthesized_value_expression_primary);
		try {
			setState(1872);
			switch ( getInterpreter().adaptivePredict(_input,261,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1865); unsigned_value_specification();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1866); column_reference();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1867); set_function_specification();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1868); scalar_subquery();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1869); case_expression();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1870); cast_specification();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1871); routine_invocation();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 152, RULE_unsigned_value_specification);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1874); unsigned_literal();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 154, RULE_unsigned_numeric_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1876);
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
		enterRule(_localctx, 156, RULE_signed_numerical_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1879);
			_la = _input.LA(1);
			if (_la==PLUS || _la==MINUS) {
				{
				setState(1878); sign();
				}
			}

			setState(1881); unsigned_numeric_literal();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 158, RULE_set_function_specification);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1883); aggregate_function();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 160, RULE_aggregate_function);
		try {
			setState(1893);
			switch ( getInterpreter().adaptivePredict(_input,264,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1885); match(COUNT);
				setState(1886); match(LEFT_PAREN);
				setState(1887); match(MULTIPLY);
				setState(1888); match(RIGHT_PAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1889); general_set_function();
				setState(1891);
				switch ( getInterpreter().adaptivePredict(_input,263,_ctx) ) {
				case 1:
					{
					setState(1890); filter_clause();
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
		enterRule(_localctx, 162, RULE_general_set_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1895); set_function_type();
			setState(1896); match(LEFT_PAREN);
			setState(1898);
			_la = _input.LA(1);
			if (_la==ALL || _la==DISTINCT) {
				{
				setState(1897); set_qualifier();
				}
			}

			setState(1900); value_expression();
			setState(1901); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 164, RULE_set_function_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1903);
			_la = _input.LA(1);
			if ( !(_la==ANY || ((((_la - 92)) & ~0x3f) == 0 && ((1L << (_la - 92)) & ((1L << (SOME - 92)) | (1L << (AVG - 92)) | (1L << (COLLECT - 92)) | (1L << (COUNT - 92)) | (1L << (EVERY - 92)) | (1L << (FUSION - 92)) | (1L << (INTERSECTION - 92)))) != 0) || ((((_la - 160)) & ~0x3f) == 0 && ((1L << (_la - 160)) & ((1L << (MAX - 160)) | (1L << (MIN - 160)) | (1L << (STDDEV_POP - 160)) | (1L << (STDDEV_SAMP - 160)) | (1L << (SUM - 160)) | (1L << (VAR_SAMP - 160)) | (1L << (VAR_POP - 160)))) != 0)) ) {
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
		enterRule(_localctx, 166, RULE_filter_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1905); match(FILTER);
			setState(1906); match(LEFT_PAREN);
			setState(1907); match(WHERE);
			setState(1908); search_condition();
			setState(1909); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 168, RULE_grouping_operation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1911); match(GROUPING);
			setState(1912); match(LEFT_PAREN);
			setState(1913); column_reference_list();
			setState(1914); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 170, RULE_case_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1916); case_specification();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 172, RULE_case_abbreviation);
		int _la;
		try {
			setState(1936);
			switch (_input.LA(1)) {
			case NULLIF:
				enterOuterAlt(_localctx, 1);
				{
				setState(1918); match(NULLIF);
				setState(1919); match(LEFT_PAREN);
				setState(1920); numeric_value_expression();
				setState(1921); match(COMMA);
				setState(1922); boolean_value_expression();
				setState(1923); match(RIGHT_PAREN);
				}
				break;
			case COALESCE:
				enterOuterAlt(_localctx, 2);
				{
				setState(1925); match(COALESCE);
				setState(1926); match(LEFT_PAREN);
				setState(1927); numeric_value_expression();
				setState(1930); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1928); match(COMMA);
					setState(1929); boolean_value_expression();
					}
					}
					setState(1932); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==COMMA );
				setState(1934); match(RIGHT_PAREN);
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
		enterRule(_localctx, 174, RULE_case_specification);
		try {
			setState(1940);
			switch ( getInterpreter().adaptivePredict(_input,268,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1938); simple_case();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1939); searched_case();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 176, RULE_simple_case);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1942); match(CASE);
			setState(1943); boolean_value_expression();
			setState(1945); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1944); simple_when_clause();
				}
				}
				setState(1947); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WHEN );
			setState(1950);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(1949); else_clause();
				}
			}

			setState(1952); match(END);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 178, RULE_searched_case);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1954); match(CASE);
			setState(1956); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1955); searched_when_clause();
				}
				}
				setState(1958); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WHEN );
			setState(1961);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(1960); else_clause();
				}
			}

			setState(1963); match(END);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 180, RULE_simple_when_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1965); match(WHEN);
			setState(1966); search_condition();
			setState(1967); match(THEN);
			setState(1968); result();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 182, RULE_searched_when_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1970); match(WHEN);
			setState(1971); ((Searched_when_clauseContext)_localctx).c = search_condition();
			setState(1972); match(THEN);
			setState(1973); ((Searched_when_clauseContext)_localctx).r = result();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 184, RULE_else_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1975); match(ELSE);
			setState(1976); ((Else_clauseContext)_localctx).r = result();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 186, RULE_result);
		try {
			setState(1980);
			switch ( getInterpreter().adaptivePredict(_input,273,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1978); value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1979); match(NULL);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 188, RULE_cast_specification);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1982); match(CAST);
			setState(1983); match(LEFT_PAREN);
			setState(1984); cast_operand();
			setState(1985); match(AS);
			setState(1986); cast_target();
			setState(1987); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 190, RULE_cast_operand);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1989); value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 192, RULE_cast_target);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1991); data_type();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 194, RULE_value_expression);
		try {
			setState(1996);
			switch ( getInterpreter().adaptivePredict(_input,274,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1993); common_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1994); row_value_expression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1995); boolean_value_expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 196, RULE_common_value_expression);
		try {
			setState(2001);
			switch ( getInterpreter().adaptivePredict(_input,275,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1998); numeric_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1999); string_value_expression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2000); match(NULL);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 198, RULE_numeric_value_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2003); ((Numeric_value_expressionContext)_localctx).left = term();
			setState(2008);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				{
				setState(2004);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(2005); ((Numeric_value_expressionContext)_localctx).right = term();
				}
				}
				setState(2010);
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
		enterRule(_localctx, 200, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2011); ((TermContext)_localctx).left = factor();
			setState(2016);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 270)) & ~0x3f) == 0 && ((1L << (_la - 270)) & ((1L << (MULTIPLY - 270)) | (1L << (DIVIDE - 270)) | (1L << (MODULAR - 270)))) != 0)) {
				{
				{
				setState(2012);
				_la = _input.LA(1);
				if ( !(((((_la - 270)) & ~0x3f) == 0 && ((1L << (_la - 270)) & ((1L << (MULTIPLY - 270)) | (1L << (DIVIDE - 270)) | (1L << (MODULAR - 270)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(2013); ((TermContext)_localctx).right = factor();
				}
				}
				setState(2018);
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
		enterRule(_localctx, 202, RULE_factor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2020);
			_la = _input.LA(1);
			if (_la==PLUS || _la==MINUS) {
				{
				setState(2019); sign();
				}
			}

			setState(2022); numeric_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 204, RULE_array);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2024); match(LEFT_PAREN);
			setState(2025); numeric_value_expression();
			setState(2030);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2026); match(COMMA);
				setState(2027); numeric_value_expression();
				}
				}
				setState(2032);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2033); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 206, RULE_numeric_primary);
		int _la;
		try {
			setState(2044);
			switch ( getInterpreter().adaptivePredict(_input,281,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2035); value_expression_primary();
				setState(2040);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CAST_EXPRESSION) {
					{
					{
					setState(2036); match(CAST_EXPRESSION);
					setState(2037); cast_target();
					}
					}
					setState(2042);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2043); numeric_value_function();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 208, RULE_sign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2046);
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
		enterRule(_localctx, 210, RULE_numeric_value_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2048); extract_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 212, RULE_extract_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2050); match(EXTRACT);
			setState(2051); match(LEFT_PAREN);
			setState(2052); ((Extract_expressionContext)_localctx).extract_field_string = extract_field();
			setState(2053); match(FROM);
			setState(2054); extract_source();
			setState(2055); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 214, RULE_extract_field);
		try {
			setState(2060);
			switch (_input.LA(1)) {
			case DAY:
			case HOUR:
			case MINUTE:
			case MONTH:
			case SECOND:
			case YEAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(2057); primary_datetime_field();
				}
				break;
			case TIMEZONE:
			case TIMEZONE_HOUR:
			case TIMEZONE_MINUTE:
				enterOuterAlt(_localctx, 2);
				{
				setState(2058); time_zone_field();
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
				setState(2059); extended_datetime_field();
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
		enterRule(_localctx, 216, RULE_time_zone_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2062);
			_la = _input.LA(1);
			if ( !(((((_la - 198)) & ~0x3f) == 0 && ((1L << (_la - 198)) & ((1L << (TIMEZONE - 198)) | (1L << (TIMEZONE_HOUR - 198)) | (1L << (TIMEZONE_MINUTE - 198)))) != 0)) ) {
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
		enterRule(_localctx, 218, RULE_extract_source);
		try {
			setState(2066);
			switch ( getInterpreter().adaptivePredict(_input,283,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2064); column_reference();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2065); datetime_literal();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 220, RULE_string_value_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2068); character_value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 222, RULE_character_value_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2070); character_factor();
			setState(2075);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CONCATENATION_OPERATOR) {
				{
				{
				setState(2071); match(CONCATENATION_OPERATOR);
				setState(2072); character_factor();
				}
				}
				setState(2077);
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
		enterRule(_localctx, 224, RULE_character_factor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2078); character_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 226, RULE_character_primary);
		try {
			setState(2082);
			switch ( getInterpreter().adaptivePredict(_input,285,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2080); value_expression_primary();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2081); string_value_function();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 228, RULE_string_value_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2084); trim_function();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 230, RULE_trim_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2086); match(TRIM);
			setState(2087); match(LEFT_PAREN);
			setState(2088); trim_operands();
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
		enterRule(_localctx, 232, RULE_trim_operands);
		int _la;
		try {
			setState(2105);
			switch ( getInterpreter().adaptivePredict(_input,289,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2098);
				switch ( getInterpreter().adaptivePredict(_input,288,_ctx) ) {
				case 1:
					{
					setState(2092);
					_la = _input.LA(1);
					if (_la==BOTH || _la==LEADING || _la==TRAILING) {
						{
						setState(2091); trim_specification();
						}
					}

					setState(2095);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ANY) | (1L << CASE) | (1L << CAST) | (1L << FALSE) | (1L << LEFT))) != 0) || ((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & ((1L << (RIGHT - 86)) | (1L << (SOME - 86)) | (1L << (TRUE - 86)) | (1L << (ADMIN - 86)) | (1L << (AVG - 86)) | (1L << (BETWEEN - 86)) | (1L << (BY - 86)) | (1L << (CENTURY - 86)) | (1L << (CHARACTER - 86)) | (1L << (CHECK - 86)) | (1L << (COLLECT - 86)) | (1L << (COALESCE - 86)) | (1L << (COLUMN - 86)) | (1L << (COMMENT - 86)) | (1L << (COMMENTS - 86)) | (1L << (COMMIT - 86)) | (1L << (COUNT - 86)) | (1L << (CUBE - 86)) | (1L << (DATA - 86)) | (1L << (DAY - 86)) | (1L << (DEC - 86)) | (1L << (DECADE - 86)) | (1L << (DOW - 86)) | (1L << (DOY - 86)) | (1L << (DROP - 86)) | (1L << (EPOCH - 86)) | (1L << (EVERY - 86)) | (1L << (EXISTS - 86)) | (1L << (EXTERNAL - 86)) | (1L << (EXTRACT - 86)) | (1L << (FILTER - 86)) | (1L << (FIRST - 86)) | (1L << (FORMAT - 86)) | (1L << (FUSION - 86)) | (1L << (GROUPING - 86)) | (1L << (HASH - 86)) | (1L << (INDEX - 86)) | (1L << (INSERT - 86)))) != 0) || ((((_la - 150)) & ~0x3f) == 0 && ((1L << (_la - 150)) & ((1L << (INTERSECTION - 150)) | (1L << (ISODOW - 150)) | (1L << (ISOYEAR - 150)) | (1L << (LANGUAGE - 150)) | (1L << (LARGE - 150)) | (1L << (LAST - 150)) | (1L << (LESS - 150)) | (1L << (LIST - 150)) | (1L << (LOCATION - 150)) | (1L << (MATCH - 150)) | (1L << (MAX - 150)) | (1L << (MAXVALUE - 150)) | (1L << (MICROSECONDS - 150)) | (1L << (MILLENNIUM - 150)) | (1L << (MILLISECONDS - 150)) | (1L << (MIN - 150)) | (1L << (MINUTE - 150)) | (1L << (MONTH - 150)) | (1L << (NATIONAL - 150)) | (1L << (NULLIF - 150)) | (1L << (OBJECT - 150)) | (1L << (OPTION - 150)) | (1L << (OPTIONS - 150)) | (1L << (OVERWRITE - 150)) | (1L << (PARTIAL - 150)) | (1L << (PARTITION - 150)) | (1L << (PARTITIONS - 150)) | (1L << (PRECISION - 150)) | (1L << (PUBLIC - 150)) | (1L << (PURGE - 150)) | (1L << (QUARTER - 150)) | (1L << (RANGE - 150)) | (1L << (REGEXP - 150)) | (1L << (RLIKE - 150)) | (1L << (ROLLUP - 150)) | (1L << (SECOND - 150)) | (1L << (SERVER - 150)) | (1L << (SET - 150)) | (1L << (SIMILAR - 150)) | (1L << (SIMPLE - 150)) | (1L << (STORAGE - 150)) | (1L << (STDDEV_POP - 150)) | (1L << (STDDEV_SAMP - 150)) | (1L << (SUBPARTITION - 150)) | (1L << (SUM - 150)) | (1L << (TABLESPACE - 150)) | (1L << (THAN - 150)) | (1L << (TIMEZONE - 150)) | (1L << (TIMEZONE_HOUR - 150)) | (1L << (TIMEZONE_MINUTE - 150)) | (1L << (TRIM - 150)) | (1L << (TO - 150)) | (1L << (UNKNOWN - 150)) | (1L << (UNLOGGED - 150)) | (1L << (VALUES - 150)) | (1L << (VAR_SAMP - 150)) | (1L << (VAR_POP - 150)) | (1L << (VARYING - 150)) | (1L << (WEEK - 150)) | (1L << (WRAPPER - 150)) | (1L << (YEAR - 150)) | (1L << (ZONE - 150)))) != 0) || ((((_la - 214)) & ~0x3f) == 0 && ((1L << (_la - 214)) & ((1L << (BOOLEAN - 214)) | (1L << (BOOL - 214)) | (1L << (BIT - 214)) | (1L << (VARBIT - 214)) | (1L << (INT1 - 214)) | (1L << (INT2 - 214)) | (1L << (INT4 - 214)) | (1L << (INT8 - 214)) | (1L << (TINYINT - 214)) | (1L << (SMALLINT - 214)) | (1L << (INT - 214)) | (1L << (INTEGER - 214)) | (1L << (BIGINT - 214)) | (1L << (FLOAT4 - 214)) | (1L << (FLOAT8 - 214)) | (1L << (REAL - 214)) | (1L << (FLOAT - 214)) | (1L << (DOUBLE - 214)) | (1L << (NUMERIC - 214)) | (1L << (DECIMAL - 214)) | (1L << (CHAR - 214)) | (1L << (VARCHAR - 214)) | (1L << (NCHAR - 214)) | (1L << (NVARCHAR - 214)) | (1L << (DATE - 214)) | (1L << (TIME - 214)) | (1L << (TIMETZ - 214)) | (1L << (TIMESTAMP - 214)) | (1L << (TIMESTAMPTZ - 214)) | (1L << (TEXT - 214)) | (1L << (VARBINARY - 214)) | (1L << (BLOB - 214)) | (1L << (BYTEA - 214)) | (1L << (INET4 - 214)) | (1L << (LEFT_PAREN - 214)) | (1L << (QUOTE - 214)))) != 0) || ((((_la - 278)) & ~0x3f) == 0 && ((1L << (_la - 278)) & ((1L << (NUMBER - 278)) | (1L << (REAL_NUMBER - 278)) | (1L << (Identifier - 278)) | (1L << (Character_String_Literal - 278)))) != 0)) {
						{
						setState(2094); ((Trim_operandsContext)_localctx).trim_character = character_value_expression();
						}
					}

					setState(2097); match(FROM);
					}
					break;
				}
				setState(2100); ((Trim_operandsContext)_localctx).trim_source = character_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2101); ((Trim_operandsContext)_localctx).trim_source = character_value_expression();
				setState(2102); match(COMMA);
				setState(2103); ((Trim_operandsContext)_localctx).trim_character = character_value_expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 234, RULE_trim_specification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2107);
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
		enterRule(_localctx, 236, RULE_boolean_value_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2109); or_predicate();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 238, RULE_or_predicate);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2111); and_predicate();
			setState(2116);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,290,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(2112); match(OR);
					setState(2113); or_predicate();
					}
					} 
				}
				setState(2118);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,290,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 240, RULE_and_predicate);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2119); boolean_factor();
			setState(2124);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,291,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(2120); match(AND);
					setState(2121); and_predicate();
					}
					} 
				}
				setState(2126);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,291,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 242, RULE_boolean_factor);
		try {
			setState(2130);
			switch ( getInterpreter().adaptivePredict(_input,292,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2127); boolean_test();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2128); match(NOT);
				setState(2129); boolean_test();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 244, RULE_boolean_test);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2132); boolean_primary();
			setState(2134);
			_la = _input.LA(1);
			if (_la==IS) {
				{
				setState(2133); is_clause();
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
		enterRule(_localctx, 246, RULE_is_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2136); match(IS);
			setState(2138);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(2137); match(NOT);
				}
			}

			setState(2140); ((Is_clauseContext)_localctx).t = truth_value();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 248, RULE_truth_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2142);
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
		enterRule(_localctx, 250, RULE_boolean_primary);
		try {
			setState(2146);
			switch ( getInterpreter().adaptivePredict(_input,295,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2144); predicate();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2145); boolean_predicand();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 252, RULE_boolean_predicand);
		try {
			setState(2150);
			switch ( getInterpreter().adaptivePredict(_input,296,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2148); parenthesized_boolean_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2149); nonparenthesized_value_expression_primary();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 254, RULE_parenthesized_boolean_value_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2152); match(LEFT_PAREN);
			setState(2153); boolean_value_expression();
			setState(2154); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 256, RULE_row_value_expression);
		try {
			setState(2158);
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
			case CHECK:
			case COLLECT:
			case COALESCE:
			case COLUMN:
			case COMMENT:
			case COMMENTS:
			case COMMIT:
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
				setState(2156); row_value_special_case();
				}
				break;
			case NULL:
				enterOuterAlt(_localctx, 2);
				{
				setState(2157); explicit_row_value_constructor();
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
		enterRule(_localctx, 258, RULE_row_value_special_case);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2160); nonparenthesized_value_expression_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 260, RULE_explicit_row_value_constructor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2162); match(NULL);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 262, RULE_row_value_predicand);
		try {
			setState(2166);
			switch ( getInterpreter().adaptivePredict(_input,298,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2164); row_value_special_case();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2165); row_value_constructor_predicand();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 264, RULE_row_value_constructor_predicand);
		try {
			setState(2170);
			switch ( getInterpreter().adaptivePredict(_input,299,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2168); common_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2169); boolean_predicand();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 266, RULE_table_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2172); from_clause();
			setState(2174);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(2173); where_clause();
				}
			}

			setState(2177);
			_la = _input.LA(1);
			if (_la==GROUP) {
				{
				setState(2176); groupby_clause();
				}
			}

			setState(2180);
			_la = _input.LA(1);
			if (_la==HAVING) {
				{
				setState(2179); having_clause();
				}
			}

			setState(2183);
			_la = _input.LA(1);
			if (_la==ORDER) {
				{
				setState(2182); orderby_clause();
				}
			}

			setState(2186);
			_la = _input.LA(1);
			if (_la==LIMIT) {
				{
				setState(2185); limit_clause();
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
		enterRule(_localctx, 268, RULE_from_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2188); match(FROM);
			setState(2189); table_reference_list();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 270, RULE_table_reference_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2191); table_reference();
			setState(2196);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2192); match(COMMA);
				setState(2193); table_reference();
				}
				}
				setState(2198);
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
		enterRule(_localctx, 272, RULE_table_reference);
		try {
			setState(2201);
			switch ( getInterpreter().adaptivePredict(_input,306,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2199); joined_table();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2200); table_primary();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 274, RULE_joined_table);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2203); table_primary();
			setState(2205); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(2204); joined_table_primary();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(2207); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,307,_ctx);
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
		enterRule(_localctx, 276, RULE_joined_table_primary);
		int _la;
		try {
			setState(2228);
			switch (_input.LA(1)) {
			case CROSS:
				enterOuterAlt(_localctx, 1);
				{
				setState(2209); match(CROSS);
				setState(2210); match(JOIN);
				setState(2211); ((Joined_table_primaryContext)_localctx).right = table_primary();
				}
				break;
			case FULL:
			case INNER:
			case JOIN:
			case LEFT:
			case RIGHT:
				enterOuterAlt(_localctx, 2);
				{
				setState(2213);
				_la = _input.LA(1);
				if (((((_la - 38)) & ~0x3f) == 0 && ((1L << (_la - 38)) & ((1L << (FULL - 38)) | (1L << (INNER - 38)) | (1L << (LEFT - 38)) | (1L << (RIGHT - 38)))) != 0)) {
					{
					setState(2212); ((Joined_table_primaryContext)_localctx).t = join_type();
					}
				}

				setState(2215); match(JOIN);
				setState(2216); ((Joined_table_primaryContext)_localctx).right = table_primary();
				setState(2217); ((Joined_table_primaryContext)_localctx).s = join_specification();
				}
				break;
			case NATURAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(2219); match(NATURAL);
				setState(2221);
				_la = _input.LA(1);
				if (((((_la - 38)) & ~0x3f) == 0 && ((1L << (_la - 38)) & ((1L << (FULL - 38)) | (1L << (INNER - 38)) | (1L << (LEFT - 38)) | (1L << (RIGHT - 38)))) != 0)) {
					{
					setState(2220); ((Joined_table_primaryContext)_localctx).t = join_type();
					}
				}

				setState(2223); match(JOIN);
				setState(2224); ((Joined_table_primaryContext)_localctx).right = table_primary();
				}
				break;
			case UNION:
				enterOuterAlt(_localctx, 4);
				{
				setState(2225); match(UNION);
				setState(2226); match(JOIN);
				setState(2227); ((Joined_table_primaryContext)_localctx).right = table_primary();
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
		enterRule(_localctx, 278, RULE_cross_join);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2230); match(CROSS);
			setState(2231); match(JOIN);
			setState(2232); ((Cross_joinContext)_localctx).r = table_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 280, RULE_qualified_join);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2235);
			_la = _input.LA(1);
			if (((((_la - 38)) & ~0x3f) == 0 && ((1L << (_la - 38)) & ((1L << (FULL - 38)) | (1L << (INNER - 38)) | (1L << (LEFT - 38)) | (1L << (RIGHT - 38)))) != 0)) {
				{
				setState(2234); ((Qualified_joinContext)_localctx).t = join_type();
				}
			}

			setState(2237); match(JOIN);
			setState(2238); ((Qualified_joinContext)_localctx).r = table_primary();
			setState(2239); ((Qualified_joinContext)_localctx).s = join_specification();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 282, RULE_natural_join);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2241); match(NATURAL);
			setState(2243);
			_la = _input.LA(1);
			if (((((_la - 38)) & ~0x3f) == 0 && ((1L << (_la - 38)) & ((1L << (FULL - 38)) | (1L << (INNER - 38)) | (1L << (LEFT - 38)) | (1L << (RIGHT - 38)))) != 0)) {
				{
				setState(2242); ((Natural_joinContext)_localctx).t = join_type();
				}
			}

			setState(2245); match(JOIN);
			setState(2246); ((Natural_joinContext)_localctx).r = table_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 284, RULE_union_join);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2248); match(UNION);
			setState(2249); match(JOIN);
			setState(2250); ((Union_joinContext)_localctx).r = table_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 286, RULE_join_type);
		try {
			setState(2254);
			switch (_input.LA(1)) {
			case INNER:
				enterOuterAlt(_localctx, 1);
				{
				setState(2252); match(INNER);
				}
				break;
			case FULL:
			case LEFT:
			case RIGHT:
				enterOuterAlt(_localctx, 2);
				{
				setState(2253); ((Join_typeContext)_localctx).t = outer_join_type();
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
		enterRule(_localctx, 288, RULE_outer_join_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2256); outer_join_type_part2();
			setState(2258);
			_la = _input.LA(1);
			if (_la==OUTER) {
				{
				setState(2257); match(OUTER);
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
		enterRule(_localctx, 290, RULE_outer_join_type_part2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2260);
			_la = _input.LA(1);
			if ( !(((((_la - 38)) & ~0x3f) == 0 && ((1L << (_la - 38)) & ((1L << (FULL - 38)) | (1L << (LEFT - 38)) | (1L << (RIGHT - 38)))) != 0)) ) {
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
		enterRule(_localctx, 292, RULE_join_specification);
		try {
			setState(2264);
			switch (_input.LA(1)) {
			case ON:
				enterOuterAlt(_localctx, 1);
				{
				setState(2262); join_condition();
				}
				break;
			case USING:
				enterOuterAlt(_localctx, 2);
				{
				setState(2263); named_columns_join();
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
		enterRule(_localctx, 294, RULE_join_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2266); match(ON);
			setState(2267); search_condition();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 296, RULE_named_columns_join);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2269); match(USING);
			setState(2270); match(LEFT_PAREN);
			setState(2271); ((Named_columns_joinContext)_localctx).f = column_reference_list();
			setState(2272); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 298, RULE_table_primary);
		int _la;
		try {
			setState(2298);
			switch (_input.LA(1)) {
			case ADMIN:
			case AVG:
			case BETWEEN:
			case BY:
			case CENTURY:
			case CHARACTER:
			case CHECK:
			case COLLECT:
			case COALESCE:
			case COLUMN:
			case COMMENT:
			case COMMENTS:
			case COMMIT:
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
				setState(2274); table_or_query_name();
				setState(2279);
				switch ( getInterpreter().adaptivePredict(_input,317,_ctx) ) {
				case 1:
					{
					setState(2276);
					_la = _input.LA(1);
					if (_la==AS) {
						{
						setState(2275); match(AS);
						}
					}

					setState(2278); ((Table_primaryContext)_localctx).alias = identifier();
					}
					break;
				}
				setState(2285);
				switch ( getInterpreter().adaptivePredict(_input,318,_ctx) ) {
				case 1:
					{
					setState(2281); match(LEFT_PAREN);
					setState(2282); column_name_list();
					setState(2283); match(RIGHT_PAREN);
					}
					break;
				}
				}
				break;
			case LEFT_PAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(2287); derived_table();
				setState(2289);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(2288); match(AS);
					}
				}

				setState(2291); ((Table_primaryContext)_localctx).name = identifier();
				setState(2296);
				switch ( getInterpreter().adaptivePredict(_input,320,_ctx) ) {
				case 1:
					{
					setState(2292); match(LEFT_PAREN);
					setState(2293); column_name_list();
					setState(2294); match(RIGHT_PAREN);
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
		enterRule(_localctx, 300, RULE_column_name_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2300); identifier();
			setState(2305);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2301); match(COMMA);
				setState(2302); identifier();
				}
				}
				setState(2307);
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
		enterRule(_localctx, 302, RULE_derived_table);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2308); table_subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 304, RULE_where_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2310); match(WHERE);
			setState(2311); search_condition();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 306, RULE_search_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2313); value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 308, RULE_groupby_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2315); match(GROUP);
			setState(2316); match(BY);
			setState(2317); ((Groupby_clauseContext)_localctx).g = grouping_element_list();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 310, RULE_grouping_element_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2319); grouping_element();
			setState(2324);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2320); match(COMMA);
				setState(2321); grouping_element();
				}
				}
				setState(2326);
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
		enterRule(_localctx, 312, RULE_grouping_element);
		try {
			setState(2331);
			switch ( getInterpreter().adaptivePredict(_input,324,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2327); rollup_list();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2328); cube_list();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2329); empty_grouping_set();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2330); ordinary_grouping_set();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 314, RULE_ordinary_grouping_set);
		try {
			setState(2338);
			switch ( getInterpreter().adaptivePredict(_input,325,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2333); row_value_predicand();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2334); match(LEFT_PAREN);
				setState(2335); row_value_predicand_list();
				setState(2336); match(RIGHT_PAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 316, RULE_ordinary_grouping_set_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2340); ordinary_grouping_set();
			setState(2345);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2341); match(COMMA);
				setState(2342); ordinary_grouping_set();
				}
				}
				setState(2347);
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
		enterRule(_localctx, 318, RULE_rollup_list);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2348); match(ROLLUP);
			setState(2349); match(LEFT_PAREN);
			setState(2350); ((Rollup_listContext)_localctx).c = ordinary_grouping_set_list();
			setState(2351); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 320, RULE_cube_list);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2353); match(CUBE);
			setState(2354); match(LEFT_PAREN);
			setState(2355); ((Cube_listContext)_localctx).c = ordinary_grouping_set_list();
			setState(2356); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 322, RULE_empty_grouping_set);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2358); match(LEFT_PAREN);
			setState(2359); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 324, RULE_having_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2361); match(HAVING);
			setState(2362); boolean_value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 326, RULE_row_value_predicand_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2364); row_value_predicand();
			setState(2369);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2365); match(COMMA);
				setState(2366); row_value_predicand();
				}
				}
				setState(2371);
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
		enterRule(_localctx, 328, RULE_query_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2372); query_expression_body();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 330, RULE_query_expression_body);
		try {
			setState(2376);
			switch ( getInterpreter().adaptivePredict(_input,328,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2374); non_join_query_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2375); joined_table();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 332, RULE_non_join_query_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2386);
			switch ( getInterpreter().adaptivePredict(_input,330,_ctx) ) {
			case 1:
				{
				setState(2378); non_join_query_term();
				}
				break;
			case 2:
				{
				setState(2379); joined_table();
				setState(2380);
				_la = _input.LA(1);
				if ( !(_la==EXCEPT || _la==UNION) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(2382);
				_la = _input.LA(1);
				if (_la==ALL || _la==DISTINCT) {
					{
					setState(2381);
					_la = _input.LA(1);
					if ( !(_la==ALL || _la==DISTINCT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(2384); query_term();
				}
				break;
			}
			setState(2395);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==EXCEPT || _la==UNION) {
				{
				{
				setState(2388);
				_la = _input.LA(1);
				if ( !(_la==EXCEPT || _la==UNION) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(2390);
				_la = _input.LA(1);
				if (_la==ALL || _la==DISTINCT) {
					{
					setState(2389);
					_la = _input.LA(1);
					if ( !(_la==ALL || _la==DISTINCT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(2392); query_term();
				}
				}
				setState(2397);
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
		enterRule(_localctx, 334, RULE_query_term);
		try {
			setState(2400);
			switch ( getInterpreter().adaptivePredict(_input,333,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2398); non_join_query_term();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2399); joined_table();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 336, RULE_non_join_query_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2410);
			switch ( getInterpreter().adaptivePredict(_input,335,_ctx) ) {
			case 1:
				{
				setState(2402); non_join_query_primary();
				}
				break;
			case 2:
				{
				setState(2403); joined_table();
				setState(2404); match(INTERSECT);
				setState(2406);
				_la = _input.LA(1);
				if (_la==ALL || _la==DISTINCT) {
					{
					setState(2405);
					_la = _input.LA(1);
					if ( !(_la==ALL || _la==DISTINCT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(2408); query_primary();
				}
				break;
			}
			setState(2419);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==INTERSECT) {
				{
				{
				setState(2412); match(INTERSECT);
				setState(2414);
				_la = _input.LA(1);
				if (_la==ALL || _la==DISTINCT) {
					{
					setState(2413);
					_la = _input.LA(1);
					if ( !(_la==ALL || _la==DISTINCT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(2416); query_primary();
				}
				}
				setState(2421);
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
		enterRule(_localctx, 338, RULE_query_primary);
		try {
			setState(2424);
			switch ( getInterpreter().adaptivePredict(_input,338,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2422); non_join_query_primary();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2423); joined_table();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 340, RULE_non_join_query_primary);
		try {
			setState(2431);
			switch (_input.LA(1)) {
			case SELECT:
			case TABLE:
				enterOuterAlt(_localctx, 1);
				{
				setState(2426); simple_table();
				}
				break;
			case LEFT_PAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(2427); match(LEFT_PAREN);
				setState(2428); non_join_query_expression();
				setState(2429); match(RIGHT_PAREN);
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
		enterRule(_localctx, 342, RULE_simple_table);
		try {
			setState(2435);
			switch (_input.LA(1)) {
			case SELECT:
				enterOuterAlt(_localctx, 1);
				{
				setState(2433); query_specification();
				}
				break;
			case TABLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(2434); explicit_table();
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
		enterRule(_localctx, 344, RULE_explicit_table);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2437); match(TABLE);
			setState(2438); table_or_query_name();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 346, RULE_table_or_query_name);
		try {
			setState(2442);
			switch ( getInterpreter().adaptivePredict(_input,341,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2440); table_name();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2441); identifier();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 348, RULE_table_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2444); identifier();
			setState(2451);
			_la = _input.LA(1);
			if (_la==DOT) {
				{
				setState(2445); match(DOT);
				setState(2446); identifier();
				setState(2449);
				_la = _input.LA(1);
				if (_la==DOT) {
					{
					setState(2447); match(DOT);
					setState(2448); identifier();
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
		enterRule(_localctx, 350, RULE_query_specification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2453); match(SELECT);
			setState(2455);
			_la = _input.LA(1);
			if (_la==ALL || _la==DISTINCT) {
				{
				setState(2454); set_qualifier();
				}
			}

			setState(2457); select_list();
			setState(2459);
			_la = _input.LA(1);
			if (_la==FROM) {
				{
				setState(2458); table_expression();
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
		enterRule(_localctx, 352, RULE_select_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2461); select_sublist();
			setState(2466);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2462); match(COMMA);
				setState(2463); select_sublist();
				}
				}
				setState(2468);
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
		enterRule(_localctx, 354, RULE_select_sublist);
		try {
			setState(2471);
			switch ( getInterpreter().adaptivePredict(_input,347,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2469); derived_column();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2470); qualified_asterisk();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 356, RULE_derived_column);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2473); value_expression();
			setState(2475);
			switch ( getInterpreter().adaptivePredict(_input,348,_ctx) ) {
			case 1:
				{
				setState(2474); as_clause();
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
		enterRule(_localctx, 358, RULE_qualified_asterisk);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2479);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(2477); ((Qualified_asteriskContext)_localctx).tb_name = match(Identifier);
				setState(2478); match(DOT);
				}
			}

			setState(2481); match(MULTIPLY);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 360, RULE_set_qualifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2483);
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
		enterRule(_localctx, 362, RULE_column_reference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2488);
			switch ( getInterpreter().adaptivePredict(_input,350,_ctx) ) {
			case 1:
				{
				setState(2485); ((Column_referenceContext)_localctx).tb_name = identifier();
				setState(2486); match(DOT);
				}
				break;
			}
			setState(2490); ((Column_referenceContext)_localctx).name = identifier();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 364, RULE_as_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2493);
			_la = _input.LA(1);
			if (_la==AS) {
				{
				setState(2492); match(AS);
				}
			}

			setState(2495); identifier();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 366, RULE_column_reference_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2497); column_reference();
			setState(2502);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2498); match(COMMA);
				setState(2499); column_reference();
				}
				}
				setState(2504);
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
		enterRule(_localctx, 368, RULE_scalar_subquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2505); subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 370, RULE_row_subquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2507); subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 372, RULE_table_subquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2509); subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 374, RULE_subquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2511); match(LEFT_PAREN);
			setState(2512); query_expression();
			setState(2513); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 376, RULE_predicate);
		try {
			setState(2521);
			switch ( getInterpreter().adaptivePredict(_input,353,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2515); comparison_predicate();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2516); between_predicate();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2517); in_predicate();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2518); pattern_matching_predicate();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2519); null_predicate();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2520); exists_predicate();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 378, RULE_comparison_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2523); ((Comparison_predicateContext)_localctx).left = row_value_predicand();
			setState(2524); ((Comparison_predicateContext)_localctx).c = comp_op();
			setState(2525); ((Comparison_predicateContext)_localctx).right = row_value_predicand();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 380, RULE_comp_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2527);
			_la = _input.LA(1);
			if ( !(((((_la - 256)) & ~0x3f) == 0 && ((1L << (_la - 256)) & ((1L << (EQUAL - 256)) | (1L << (NOT_EQUAL - 256)) | (1L << (LTH - 256)) | (1L << (LEQ - 256)) | (1L << (GTH - 256)) | (1L << (GEQ - 256)))) != 0)) ) {
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
		enterRule(_localctx, 382, RULE_between_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2529); ((Between_predicateContext)_localctx).predicand = row_value_predicand();
			setState(2530); between_predicate_part_2();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 384, RULE_between_predicate_part_2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2533);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(2532); match(NOT);
				}
			}

			setState(2535); match(BETWEEN);
			setState(2537);
			_la = _input.LA(1);
			if (_la==ASYMMETRIC || _la==SYMMETRIC) {
				{
				setState(2536);
				_la = _input.LA(1);
				if ( !(_la==ASYMMETRIC || _la==SYMMETRIC) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(2539); ((Between_predicate_part_2Context)_localctx).begin = row_value_predicand();
			setState(2540); match(AND);
			setState(2541); ((Between_predicate_part_2Context)_localctx).end = row_value_predicand();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 386, RULE_in_predicate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2543); ((In_predicateContext)_localctx).predicand = numeric_value_expression();
			setState(2545);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(2544); match(NOT);
				}
			}

			setState(2547); match(IN);
			setState(2548); in_predicate_value();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 388, RULE_in_predicate_value);
		try {
			setState(2555);
			switch ( getInterpreter().adaptivePredict(_input,357,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2550); table_subquery();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2551); match(LEFT_PAREN);
				setState(2552); in_value_list();
				setState(2553); match(RIGHT_PAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 390, RULE_in_value_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2557); row_value_expression();
			setState(2562);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2558); match(COMMA);
				setState(2559); row_value_expression();
				}
				}
				setState(2564);
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
		enterRule(_localctx, 392, RULE_pattern_matching_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2565); ((Pattern_matching_predicateContext)_localctx).f = row_value_predicand();
			setState(2566); pattern_matcher();
			setState(2567); ((Pattern_matching_predicateContext)_localctx).s = match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 394, RULE_pattern_matcher);
		int _la;
		try {
			setState(2574);
			switch (_input.LA(1)) {
			case ILIKE:
			case LIKE:
			case NOT:
			case REGEXP:
			case RLIKE:
			case SIMILAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(2570);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(2569); match(NOT);
					}
				}

				setState(2572); negativable_matcher();
				}
				break;
			case Similar_To:
			case Not_Similar_To:
			case Similar_To_Case_Insensitive:
			case Not_Similar_To_Case_Insensitive:
				enterOuterAlt(_localctx, 2);
				{
				setState(2573); regex_matcher();
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
		enterRule(_localctx, 396, RULE_negativable_matcher);
		try {
			setState(2582);
			switch (_input.LA(1)) {
			case LIKE:
				enterOuterAlt(_localctx, 1);
				{
				setState(2576); match(LIKE);
				}
				break;
			case ILIKE:
				enterOuterAlt(_localctx, 2);
				{
				setState(2577); match(ILIKE);
				}
				break;
			case SIMILAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(2578); match(SIMILAR);
				setState(2579); match(TO);
				}
				break;
			case REGEXP:
				enterOuterAlt(_localctx, 4);
				{
				setState(2580); match(REGEXP);
				}
				break;
			case RLIKE:
				enterOuterAlt(_localctx, 5);
				{
				setState(2581); match(RLIKE);
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
		enterRule(_localctx, 398, RULE_regex_matcher);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2584);
			_la = _input.LA(1);
			if ( !(((((_la - 250)) & ~0x3f) == 0 && ((1L << (_la - 250)) & ((1L << (Similar_To - 250)) | (1L << (Not_Similar_To - 250)) | (1L << (Similar_To_Case_Insensitive - 250)) | (1L << (Not_Similar_To_Case_Insensitive - 250)))) != 0)) ) {
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
		enterRule(_localctx, 400, RULE_null_predicate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2586); ((Null_predicateContext)_localctx).predicand = row_value_predicand();
			setState(2587); match(IS);
			setState(2589);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(2588); ((Null_predicateContext)_localctx).n = match(NOT);
				}
			}

			setState(2591); match(NULL);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 402, RULE_quantified_comparison_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2593); ((Quantified_comparison_predicateContext)_localctx).l = numeric_value_expression();
			setState(2594); ((Quantified_comparison_predicateContext)_localctx).c = comp_op();
			setState(2595); ((Quantified_comparison_predicateContext)_localctx).q = quantifier();
			setState(2596); ((Quantified_comparison_predicateContext)_localctx).s = table_subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 404, RULE_quantifier);
		try {
			setState(2600);
			switch (_input.LA(1)) {
			case ALL:
				enterOuterAlt(_localctx, 1);
				{
				setState(2598); all();
				}
				break;
			case ANY:
			case SOME:
				enterOuterAlt(_localctx, 2);
				{
				setState(2599); some();
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
		enterRule(_localctx, 406, RULE_all);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2602); match(ALL);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 408, RULE_some);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2604);
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
		enterRule(_localctx, 410, RULE_exists_predicate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2607);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(2606); match(NOT);
				}
			}

			setState(2609); match(EXISTS);
			setState(2610); ((Exists_predicateContext)_localctx).s = table_subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 412, RULE_unique_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2612); match(UNIQUE);
			setState(2613); ((Unique_predicateContext)_localctx).s = table_subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 414, RULE_primary_datetime_field);
		try {
			setState(2617);
			switch (_input.LA(1)) {
			case DAY:
			case HOUR:
			case MINUTE:
			case MONTH:
			case YEAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(2615); non_second_primary_datetime_field();
				}
				break;
			case SECOND:
				enterOuterAlt(_localctx, 2);
				{
				setState(2616); match(SECOND);
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
		enterRule(_localctx, 416, RULE_non_second_primary_datetime_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2619);
			_la = _input.LA(1);
			if ( !(((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (DAY - 129)) | (1L << (HOUR - 129)) | (1L << (MINUTE - 129)) | (1L << (MONTH - 129)))) != 0) || _la==YEAR) ) {
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
		enterRule(_localctx, 418, RULE_extended_datetime_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2621);
			_la = _input.LA(1);
			if ( !(((((_la - 117)) & ~0x3f) == 0 && ((1L << (_la - 117)) & ((1L << (CENTURY - 117)) | (1L << (DECADE - 117)) | (1L << (DOW - 117)) | (1L << (DOY - 117)) | (1L << (EPOCH - 117)) | (1L << (ISODOW - 117)) | (1L << (ISOYEAR - 117)) | (1L << (MICROSECONDS - 117)) | (1L << (MILLENNIUM - 117)) | (1L << (MILLISECONDS - 117)) | (1L << (QUARTER - 117)))) != 0) || _la==WEEK) ) {
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
		enterRule(_localctx, 420, RULE_routine_invocation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2623); function_name();
			setState(2624); match(LEFT_PAREN);
			setState(2626);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ANY) | (1L << CASE) | (1L << CAST) | (1L << FALSE) | (1L << LEFT))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (NOT - 67)) | (1L << (NULL - 67)) | (1L << (RIGHT - 67)) | (1L << (SOME - 67)) | (1L << (TRUE - 67)) | (1L << (ADMIN - 67)) | (1L << (AVG - 67)) | (1L << (BETWEEN - 67)) | (1L << (BY - 67)) | (1L << (CENTURY - 67)) | (1L << (CHARACTER - 67)) | (1L << (CHECK - 67)) | (1L << (COLLECT - 67)) | (1L << (COALESCE - 67)) | (1L << (COLUMN - 67)) | (1L << (COMMENT - 67)) | (1L << (COMMENTS - 67)) | (1L << (COMMIT - 67)) | (1L << (COUNT - 67)) | (1L << (CUBE - 67)) | (1L << (DATA - 67)) | (1L << (DAY - 67)) | (1L << (DEC - 67)))) != 0) || ((((_la - 131)) & ~0x3f) == 0 && ((1L << (_la - 131)) & ((1L << (DECADE - 131)) | (1L << (DOW - 131)) | (1L << (DOY - 131)) | (1L << (DROP - 131)) | (1L << (EPOCH - 131)) | (1L << (EVERY - 131)) | (1L << (EXISTS - 131)) | (1L << (EXTERNAL - 131)) | (1L << (EXTRACT - 131)) | (1L << (FILTER - 131)) | (1L << (FIRST - 131)) | (1L << (FORMAT - 131)) | (1L << (FUSION - 131)) | (1L << (GROUPING - 131)) | (1L << (HASH - 131)) | (1L << (INDEX - 131)) | (1L << (INSERT - 131)) | (1L << (INTERSECTION - 131)) | (1L << (ISODOW - 131)) | (1L << (ISOYEAR - 131)) | (1L << (LANGUAGE - 131)) | (1L << (LARGE - 131)) | (1L << (LAST - 131)) | (1L << (LESS - 131)) | (1L << (LIST - 131)) | (1L << (LOCATION - 131)) | (1L << (MATCH - 131)) | (1L << (MAX - 131)) | (1L << (MAXVALUE - 131)) | (1L << (MICROSECONDS - 131)) | (1L << (MILLENNIUM - 131)) | (1L << (MILLISECONDS - 131)) | (1L << (MIN - 131)) | (1L << (MINUTE - 131)) | (1L << (MONTH - 131)) | (1L << (NATIONAL - 131)) | (1L << (NULLIF - 131)) | (1L << (OBJECT - 131)) | (1L << (OPTION - 131)) | (1L << (OPTIONS - 131)) | (1L << (OVERWRITE - 131)) | (1L << (PARTIAL - 131)) | (1L << (PARTITION - 131)) | (1L << (PARTITIONS - 131)) | (1L << (PRECISION - 131)) | (1L << (PUBLIC - 131)) | (1L << (PURGE - 131)) | (1L << (QUARTER - 131)) | (1L << (RANGE - 131)) | (1L << (REGEXP - 131)) | (1L << (RLIKE - 131)) | (1L << (ROLLUP - 131)) | (1L << (SECOND - 131)) | (1L << (SERVER - 131)) | (1L << (SET - 131)) | (1L << (SIMILAR - 131)) | (1L << (SIMPLE - 131)) | (1L << (STORAGE - 131)) | (1L << (STDDEV_POP - 131)) | (1L << (STDDEV_SAMP - 131)) | (1L << (SUBPARTITION - 131)) | (1L << (SUM - 131)))) != 0) || ((((_la - 195)) & ~0x3f) == 0 && ((1L << (_la - 195)) & ((1L << (TABLESPACE - 195)) | (1L << (THAN - 195)) | (1L << (TIMEZONE - 195)) | (1L << (TIMEZONE_HOUR - 195)) | (1L << (TIMEZONE_MINUTE - 195)) | (1L << (TRIM - 195)) | (1L << (TO - 195)) | (1L << (UNKNOWN - 195)) | (1L << (UNLOGGED - 195)) | (1L << (VALUES - 195)) | (1L << (VAR_SAMP - 195)) | (1L << (VAR_POP - 195)) | (1L << (VARYING - 195)) | (1L << (WEEK - 195)) | (1L << (WRAPPER - 195)) | (1L << (YEAR - 195)) | (1L << (ZONE - 195)) | (1L << (BOOLEAN - 195)) | (1L << (BOOL - 195)) | (1L << (BIT - 195)) | (1L << (VARBIT - 195)) | (1L << (INT1 - 195)) | (1L << (INT2 - 195)) | (1L << (INT4 - 195)) | (1L << (INT8 - 195)) | (1L << (TINYINT - 195)) | (1L << (SMALLINT - 195)) | (1L << (INT - 195)) | (1L << (INTEGER - 195)) | (1L << (BIGINT - 195)) | (1L << (FLOAT4 - 195)) | (1L << (FLOAT8 - 195)) | (1L << (REAL - 195)) | (1L << (FLOAT - 195)) | (1L << (DOUBLE - 195)) | (1L << (NUMERIC - 195)) | (1L << (DECIMAL - 195)) | (1L << (CHAR - 195)) | (1L << (VARCHAR - 195)) | (1L << (NCHAR - 195)) | (1L << (NVARCHAR - 195)) | (1L << (DATE - 195)) | (1L << (TIME - 195)) | (1L << (TIMETZ - 195)) | (1L << (TIMESTAMP - 195)) | (1L << (TIMESTAMPTZ - 195)) | (1L << (TEXT - 195)) | (1L << (VARBINARY - 195)) | (1L << (BLOB - 195)) | (1L << (BYTEA - 195)) | (1L << (INET4 - 195)))) != 0) || ((((_la - 266)) & ~0x3f) == 0 && ((1L << (_la - 266)) & ((1L << (LEFT_PAREN - 266)) | (1L << (PLUS - 266)) | (1L << (MINUS - 266)) | (1L << (QUOTE - 266)) | (1L << (NUMBER - 266)) | (1L << (REAL_NUMBER - 266)) | (1L << (Identifier - 266)) | (1L << (Character_String_Literal - 266)))) != 0)) {
				{
				setState(2625); sql_argument_list();
				}
			}

			setState(2628); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 422, RULE_function_names_for_reserved_words);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2630);
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
		enterRule(_localctx, 424, RULE_function_name);
		try {
			setState(2634);
			switch (_input.LA(1)) {
			case ADMIN:
			case AVG:
			case BETWEEN:
			case BY:
			case CENTURY:
			case CHARACTER:
			case CHECK:
			case COLLECT:
			case COALESCE:
			case COLUMN:
			case COMMENT:
			case COMMENTS:
			case COMMIT:
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
				setState(2632); identifier();
				}
				break;
			case LEFT:
			case RIGHT:
				enterOuterAlt(_localctx, 2);
				{
				setState(2633); function_names_for_reserved_words();
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
		enterRule(_localctx, 426, RULE_sql_argument_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2636); value_expression();
			setState(2641);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2637); match(COMMA);
				setState(2638); value_expression();
				}
				}
				setState(2643);
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
		enterRule(_localctx, 428, RULE_orderby_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2644); match(ORDER);
			setState(2645); match(BY);
			setState(2646); sort_specifier_list();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 430, RULE_sort_specifier_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2648); sort_specifier();
			setState(2653);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2649); match(COMMA);
				setState(2650); sort_specifier();
				}
				}
				setState(2655);
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
		enterRule(_localctx, 432, RULE_sort_specifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2656); ((Sort_specifierContext)_localctx).key = row_value_predicand();
			setState(2658);
			_la = _input.LA(1);
			if (_la==ASC || _la==DESC) {
				{
				setState(2657); ((Sort_specifierContext)_localctx).order = order_specification();
				}
			}

			setState(2661);
			_la = _input.LA(1);
			if (_la==NULL) {
				{
				setState(2660); ((Sort_specifierContext)_localctx).null_order = null_ordering();
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
		enterRule(_localctx, 434, RULE_order_specification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2663);
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
		enterRule(_localctx, 436, RULE_limit_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2665); match(LIMIT);
			setState(2666); ((Limit_clauseContext)_localctx).e = numeric_value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 438, RULE_null_ordering);
		try {
			setState(2672);
			switch ( getInterpreter().adaptivePredict(_input,372,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2668); match(NULL);
				setState(2669); match(FIRST);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2670); match(NULL);
				setState(2671); match(LAST);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 440, RULE_insert_statement);
		int _la;
		try {
			setState(2703);
			switch ( getInterpreter().adaptivePredict(_input,378,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2674); match(INSERT);
				setState(2676);
				_la = _input.LA(1);
				if (_la==OVERWRITE) {
					{
					setState(2675); match(OVERWRITE);
					}
				}

				setState(2678); match(INTO);
				setState(2679); table_name();
				setState(2684);
				switch ( getInterpreter().adaptivePredict(_input,374,_ctx) ) {
				case 1:
					{
					setState(2680); match(LEFT_PAREN);
					setState(2681); column_name_list();
					setState(2682); match(RIGHT_PAREN);
					}
					break;
				}
				setState(2686); query_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2688); match(INSERT);
				setState(2690);
				_la = _input.LA(1);
				if (_la==OVERWRITE) {
					{
					setState(2689); match(OVERWRITE);
					}
				}

				setState(2692); match(INTO);
				setState(2693); match(LOCATION);
				setState(2694); ((Insert_statementContext)_localctx).path = match(Character_String_Literal);
				setState(2700);
				_la = _input.LA(1);
				if (_la==USING) {
					{
					setState(2695); match(USING);
					setState(2696); ((Insert_statementContext)_localctx).file_type = identifier();
					setState(2698);
					_la = _input.LA(1);
					if (_la==WITH) {
						{
						setState(2697); param_clause();
						}
					}

					}
				}

				setState(2702); query_expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\u0120\u0a94\4\2\t"+
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
		"\4\u00db\t\u00db\4\u00dc\t\u00dc\4\u00dd\t\u00dd\4\u00de\t\u00de\3\2\3"+
		"\2\5\2\u01bf\n\2\6\2\u01c1\n\2\r\2\16\2\u01c2\3\2\3\2\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\5\3\u01d0\n\3\3\4\3\4\3\5\3\5\3\6\3\6\5\6\u01d8\n"+
		"\6\3\7\3\7\5\7\u01dc\n\7\3\7\3\7\3\7\3\7\3\7\5\7\u01e3\n\7\3\7\3\7\3\7"+
		"\3\7\5\7\u01e9\n\7\3\b\3\b\3\b\3\b\3\b\5\b\u01f0\n\b\3\b\3\b\5\b\u01f4"+
		"\n\b\3\b\3\b\5\b\u01f8\n\b\3\b\3\b\5\b\u01fc\n\b\3\b\3\b\5\b\u0200\n\b"+
		"\3\t\3\t\5\t\u0204\n\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u020e\n\t\3"+
		"\t\5\t\u0211\n\t\6\t\u0213\n\t\r\t\16\t\u0214\3\t\3\t\5\t\u0219\n\t\3"+
		"\t\3\t\3\t\3\t\3\t\5\t\u0220\n\t\3\t\5\t\u0223\n\t\6\t\u0225\n\t\r\t\16"+
		"\t\u0226\5\t\u0229\n\t\3\n\3\n\5\n\u022d\n\n\3\n\3\n\3\n\3\n\3\n\3\n\5"+
		"\n\u0235\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u023e\n\n\6\n\u0240\n\n\r"+
		"\n\16\n\u0241\5\n\u0244\n\n\5\n\u0246\n\n\3\n\3\n\3\n\3\n\5\n\u024c\n"+
		"\n\3\n\3\n\3\n\5\n\u0251\n\n\3\n\3\n\3\n\3\n\5\n\u0257\n\n\3\n\3\n\5\n"+
		"\u025b\n\n\3\n\3\n\5\n\u025f\n\n\3\n\3\n\5\n\u0263\n\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\5\n\u026b\n\n\5\n\u026d\n\n\3\n\3\n\3\13\3\13\3\13\3\13\5\13"+
		"\u0275\n\13\3\13\3\13\3\13\5\13\u027a\n\13\5\13\u027c\n\13\3\13\3\13\3"+
		"\13\5\13\u0281\n\13\3\13\3\13\5\13\u0285\n\13\3\13\3\13\5\13\u0289\n\13"+
		"\3\13\5\13\u028c\n\13\6\13\u028e\n\13\r\13\16\13\u028f\3\13\5\13\u0293"+
		"\n\13\3\13\3\13\3\13\3\13\5\13\u0299\n\13\3\13\3\13\5\13\u029d\n\13\6"+
		"\13\u029f\n\13\r\13\16\13\u02a0\3\13\3\13\5\13\u02a5\n\13\5\13\u02a7\n"+
		"\13\3\13\3\13\3\13\3\13\5\13\u02ad\n\13\6\13\u02af\n\13\r\13\16\13\u02b0"+
		"\3\13\3\13\5\13\u02b5\n\13\3\13\3\13\5\13\u02b9\n\13\3\13\5\13\u02bc\n"+
		"\13\6\13\u02be\n\13\r\13\16\13\u02bf\3\13\5\13\u02c3\n\13\5\13\u02c5\n"+
		"\13\3\f\3\f\6\f\u02c9\n\f\r\f\16\f\u02ca\3\f\3\f\5\f\u02cf\n\f\5\f\u02d1"+
		"\n\f\3\f\3\f\5\f\u02d5\n\f\3\f\3\f\5\f\u02d9\n\f\6\f\u02db\n\f\r\f\16"+
		"\f\u02dc\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u02e5\n\f\6\f\u02e7\n\f\r\f\16\f"+
		"\u02e8\5\f\u02eb\n\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u02f3\n\f\6\f\u02f5\n"+
		"\f\r\f\16\f\u02f6\6\f\u02f9\n\f\r\f\16\f\u02fa\3\f\3\f\5\f\u02ff\n\f\3"+
		"\f\3\f\5\f\u0303\n\f\6\f\u0305\n\f\r\f\16\f\u0306\5\f\u0309\n\f\3\f\3"+
		"\f\5\f\u030d\n\f\3\f\3\f\5\f\u0311\n\f\6\f\u0313\n\f\r\f\16\f\u0314\3"+
		"\f\3\f\3\f\3\f\3\f\5\f\u031c\n\f\6\f\u031e\n\f\r\f\16\f\u031f\3\f\3\f"+
		"\5\f\u0324\n\f\5\f\u0326\n\f\3\f\3\f\3\f\3\f\5\f\u032c\n\f\6\f\u032e\n"+
		"\f\r\f\16\f\u032f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u0338\n\f\6\f\u033a\n\f"+
		"\r\f\16\f\u033b\5\f\u033e\n\f\3\f\3\f\3\f\3\f\3\f\5\f\u0345\n\f\6\f\u0347"+
		"\n\f\r\f\16\f\u0348\3\f\3\f\5\f\u034d\n\f\5\f\u034f\n\f\3\f\3\f\3\f\3"+
		"\f\5\f\u0355\n\f\6\f\u0357\n\f\r\f\16\f\u0358\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\5\f\u0361\n\f\5\f\u0363\n\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u036b\n\f\6\f"+
		"\u036d\n\f\r\f\16\f\u036e\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u0377\n\f\5\f\u0379"+
		"\n\f\3\f\3\f\3\f\3\f\3\f\5\f\u0380\n\f\6\f\u0382\n\f\r\f\16\f\u0383\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\5\f\u038c\n\f\5\f\u038e\n\f\3\f\3\f\3\f\5\f\u0393"+
		"\n\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u039b\n\f\5\f\u039d\n\f\3\f\3\f\3\f\3"+
		"\f\5\f\u03a3\n\f\6\f\u03a5\n\f\r\f\16\f\u03a6\3\f\3\f\3\f\3\f\3\f\5\f"+
		"\u03ae\n\f\6\f\u03b0\n\f\r\f\16\f\u03b1\3\f\3\f\5\f\u03b6\n\f\5\f\u03b8"+
		"\n\f\3\f\3\f\3\f\3\f\3\f\5\f\u03bf\n\f\6\f\u03c1\n\f\r\f\16\f\u03c2\3"+
		"\f\3\f\3\f\3\f\3\f\5\f\u03ca\n\f\6\f\u03cc\n\f\r\f\16\f\u03cd\3\f\3\f"+
		"\5\f\u03d2\n\f\5\f\u03d4\n\f\3\f\3\f\3\f\3\f\5\f\u03da\n\f\6\f\u03dc\n"+
		"\f\r\f\16\f\u03dd\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u03e6\n\f\5\f\u03e8\n\f"+
		"\3\f\3\f\3\f\3\f\5\f\u03ee\n\f\6\f\u03f0\n\f\r\f\16\f\u03f1\3\f\3\f\3"+
		"\f\3\f\5\f\u03f8\n\f\6\f\u03fa\n\f\r\f\16\f\u03fb\3\f\3\f\3\f\5\f\u0401"+
		"\n\f\6\f\u0403\n\f\r\f\16\f\u0404\3\f\3\f\3\f\5\f\u040a\n\f\5\f\u040c"+
		"\n\f\3\r\3\r\5\r\u0410\n\r\3\r\3\r\5\r\u0414\n\r\3\r\5\r\u0417\n\r\6\r"+
		"\u0419\n\r\r\r\16\r\u041a\3\r\3\r\3\r\5\r\u0420\n\r\3\16\3\16\3\17\3\17"+
		"\3\17\3\17\5\17\u0428\n\17\3\17\5\17\u042b\n\17\3\17\3\17\5\17\u042f\n"+
		"\17\7\17\u0431\n\17\f\17\16\17\u0434\13\17\3\17\3\17\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\5\20\u043e\n\20\6\20\u0440\n\20\r\20\16\20\u0441\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u044c\n\21\3\21\5\21\u044f\n\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u045a\n\21\3\21\5\21"+
		"\u045d\n\21\3\21\5\21\u0460\n\21\3\21\3\21\5\21\u0464\n\21\3\21\3\21\3"+
		"\21\3\21\3\21\5\21\u046b\n\21\3\21\5\21\u046e\n\21\3\21\5\21\u0471\n\21"+
		"\3\21\3\21\3\21\3\21\3\21\5\21\u0478\n\21\3\21\3\21\5\21\u047c\n\21\3"+
		"\21\3\21\3\21\3\21\5\21\u0482\n\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21"+
		"\u048a\n\21\3\21\7\21\u048d\n\21\f\21\16\21\u0490\13\21\3\21\3\21\3\21"+
		"\3\21\7\21\u0496\n\21\f\21\16\21\u0499\13\21\5\21\u049b\n\21\3\21\5\21"+
		"\u049e\n\21\6\21\u04a0\n\21\r\21\16\21\u04a1\5\21\u04a4\n\21\3\21\3\21"+
		"\3\21\3\21\3\21\5\21\u04ab\n\21\6\21\u04ad\n\21\r\21\16\21\u04ae\3\21"+
		"\3\21\5\21\u04b3\n\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u04bb\n\21\3"+
		"\21\3\21\5\21\u04bf\n\21\3\21\3\21\3\21\3\21\5\21\u04c5\n\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\7\21\u04cf\n\21\f\21\16\21\u04d2\13\21"+
		"\3\21\5\21\u04d5\n\21\3\21\5\21\u04d8\n\21\6\21\u04da\n\21\r\21\16\21"+
		"\u04db\3\21\3\21\5\21\u04e0\n\21\3\21\3\21\3\21\3\21\5\21\u04e6\n\21\3"+
		"\22\3\22\3\22\3\23\3\23\5\23\u04ed\n\23\3\23\3\23\3\23\3\23\3\23\5\23"+
		"\u04f4\n\23\6\23\u04f6\n\23\r\23\16\23\u04f7\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\5\23\u0502\n\23\6\23\u0504\n\23\r\23\16\23\u0505\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\5\23\u050e\n\23\3\23\3\23\3\23\3\23\3\23\5\23"+
		"\u0515\n\23\6\23\u0517\n\23\r\23\16\23\u0518\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\5\23\u0522\n\23\3\23\3\23\3\23\3\23\3\23\5\23\u0529\n\23\6"+
		"\23\u052b\n\23\r\23\16\23\u052c\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u0535"+
		"\n\23\6\23\u0537\n\23\r\23\16\23\u0538\3\23\3\23\5\23\u053d\n\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\5\23\u0545\n\23\3\23\3\23\3\23\5\23\u054a\n"+
		"\23\3\23\3\23\3\23\5\23\u054f\n\23\5\23\u0551\n\23\3\23\3\23\3\23\5\23"+
		"\u0556\n\23\3\23\3\23\3\23\3\23\5\23\u055c\n\23\3\24\3\24\5\24\u0560\n"+
		"\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3"+
		"\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u0576\n\24\3\24\3\24\3\24\5\24"+
		"\u057b\n\24\3\24\3\24\3\24\5\24\u0580\n\24\5\24\u0582\n\24\3\24\3\24\3"+
		"\24\5\24\u0587\n\24\3\24\3\24\3\24\3\24\5\24\u058d\n\24\3\25\3\25\3\25"+
		"\3\25\3\25\3\26\3\26\3\26\3\26\3\26\5\26\u0599\n\26\3\26\5\26\u059c\n"+
		"\26\6\26\u059e\n\26\r\26\16\26\u059f\3\26\3\26\3\27\3\27\3\27\3\27\3\27"+
		"\5\27\u05a9\n\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u05b2\n\30\5"+
		"\30\u05b4\n\30\3\31\3\31\5\31\u05b8\n\31\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\5\32\u05c0\n\32\3\33\5\33\u05c3\n\33\3\33\3\33\3\33\3\33\5\33\u05c9\n"+
		"\33\3\34\3\34\3\34\3\34\7\34\u05cf\n\34\f\34\16\34\u05d2\13\34\3\34\3"+
		"\34\3\35\3\35\3\35\3\36\3\36\3\37\3\37\3\37\3\37\3\37\7\37\u05e0\n\37"+
		"\f\37\16\37\u05e3\13\37\3\37\3\37\3 \3 \3 \3 \3!\3!\3!\3\"\3\"\3\"\3#"+
		"\3#\3$\3$\3$\3$\5$\u05f7\n$\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3&\3&\3&\7&"+
		"\u0606\n&\f&\16&\u0609\13&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\5\'"+
		"\u0615\n\'\3\'\3\'\5\'\u0619\n\'\5\'\u061b\n\'\3(\3(\3(\3(\3(\3(\3(\3"+
		"(\3(\3(\3(\5(\u0628\n(\3)\3)\3)\7)\u062d\n)\f)\16)\u0630\13)\3*\3*\3*"+
		"\3+\3+\3+\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3-\3-\3-\7-\u0645\n-\f-\16-\u0648"+
		"\13-\3.\3.\3.\3.\5.\u064e\n.\3.\3.\3.\3.\3/\3/\3/\3/\3/\3\60\3\60\3\61"+
		"\3\61\3\61\3\61\5\61\u065f\n\61\3\62\5\62\u0662\n\62\3\62\3\62\5\62\u0666"+
		"\n\62\3\62\5\62\u0669\n\62\3\63\3\63\3\64\3\64\5\64\u066f\n\64\3\65\3"+
		"\65\3\65\5\65\u0674\n\65\3\66\3\66\3\66\5\66\u0679\n\66\3\67\3\67\3\67"+
		"\38\38\38\39\39\39\3:\3:\3;\3;\3<\3<\3<\3<\3<\3<\3<\3<\3<\3<\5<\u0692"+
		"\n<\3=\3=\3>\3>\3?\3?\5?\u069a\n?\3?\3?\5?\u069e\n?\3?\3?\3?\5?\u06a3"+
		"\n?\3?\3?\3?\5?\u06a8\n?\3?\3?\5?\u06ac\n?\3?\5?\u06af\n?\3@\3@\3@\3@"+
		"\3A\3A\3A\5A\u06b8\nA\3A\3A\3A\5A\u06bd\nA\3A\3A\5A\u06c1\nA\3A\3A\3A"+
		"\3A\5A\u06c7\nA\3A\3A\3A\3A\5A\u06cd\nA\3A\3A\3A\5A\u06d2\nA\3A\3A\5A"+
		"\u06d6\nA\5A\u06d8\nA\3B\3B\5B\u06dc\nB\3B\3B\5B\u06e0\nB\5B\u06e2\nB"+
		"\3C\3C\5C\u06e6\nC\3D\3D\5D\u06ea\nD\3D\3D\5D\u06ee\nD\3D\3D\5D\u06f2"+
		"\nD\3D\3D\3D\3D\3D\3D\3D\3D\3D\5D\u06fd\nD\3E\3E\5E\u0701\nE\3E\3E\3E"+
		"\3E\3E\3E\5E\u0709\nE\3F\3F\3F\3F\3F\3F\3F\3F\5F\u0713\nF\3G\3G\3H\3H"+
		"\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\5H\u0724\nH\3I\3I\5I\u0728\nI\3I\3I"+
		"\5I\u072c\nI\3I\3I\3I\5I\u0731\nI\5I\u0733\nI\3J\3J\5J\u0737\nJ\3J\3J"+
		"\3J\5J\u073c\nJ\3J\3J\5J\u0740\nJ\5J\u0742\nJ\3K\3K\5K\u0746\nK\3L\3L"+
		"\3L\3L\3M\3M\3M\3M\3M\3M\3M\5M\u0753\nM\3N\3N\3O\3O\3P\5P\u075a\nP\3P"+
		"\3P\3Q\3Q\3R\3R\3R\3R\3R\3R\5R\u0766\nR\5R\u0768\nR\3S\3S\3S\5S\u076d"+
		"\nS\3S\3S\3S\3T\3T\3U\3U\3U\3U\3U\3U\3V\3V\3V\3V\3V\3W\3W\3X\3X\3X\3X"+
		"\3X\3X\3X\3X\3X\3X\3X\3X\6X\u078d\nX\rX\16X\u078e\3X\3X\5X\u0793\nX\3"+
		"Y\3Y\5Y\u0797\nY\3Z\3Z\3Z\6Z\u079c\nZ\rZ\16Z\u079d\3Z\5Z\u07a1\nZ\3Z\3"+
		"Z\3[\3[\6[\u07a7\n[\r[\16[\u07a8\3[\5[\u07ac\n[\3[\3[\3\\\3\\\3\\\3\\"+
		"\3\\\3]\3]\3]\3]\3]\3^\3^\3^\3_\3_\5_\u07bf\n_\3`\3`\3`\3`\3`\3`\3`\3"+
		"a\3a\3b\3b\3c\3c\3c\5c\u07cf\nc\3d\3d\3d\5d\u07d4\nd\3e\3e\3e\7e\u07d9"+
		"\ne\fe\16e\u07dc\13e\3f\3f\3f\7f\u07e1\nf\ff\16f\u07e4\13f\3g\5g\u07e7"+
		"\ng\3g\3g\3h\3h\3h\3h\7h\u07ef\nh\fh\16h\u07f2\13h\3h\3h\3i\3i\3i\7i\u07f9"+
		"\ni\fi\16i\u07fc\13i\3i\5i\u07ff\ni\3j\3j\3k\3k\3l\3l\3l\3l\3l\3l\3l\3"+
		"m\3m\3m\5m\u080f\nm\3n\3n\3o\3o\5o\u0815\no\3p\3p\3q\3q\3q\7q\u081c\n"+
		"q\fq\16q\u081f\13q\3r\3r\3s\3s\5s\u0825\ns\3t\3t\3u\3u\3u\3u\3u\3v\5v"+
		"\u082f\nv\3v\5v\u0832\nv\3v\5v\u0835\nv\3v\3v\3v\3v\3v\5v\u083c\nv\3w"+
		"\3w\3x\3x\3y\3y\3y\7y\u0845\ny\fy\16y\u0848\13y\3z\3z\3z\7z\u084d\nz\f"+
		"z\16z\u0850\13z\3{\3{\3{\5{\u0855\n{\3|\3|\5|\u0859\n|\3}\3}\5}\u085d"+
		"\n}\3}\3}\3~\3~\3\177\3\177\5\177\u0865\n\177\3\u0080\3\u0080\5\u0080"+
		"\u0869\n\u0080\3\u0081\3\u0081\3\u0081\3\u0081\3\u0082\3\u0082\5\u0082"+
		"\u0871\n\u0082\3\u0083\3\u0083\3\u0084\3\u0084\3\u0085\3\u0085\5\u0085"+
		"\u0879\n\u0085\3\u0086\3\u0086\5\u0086\u087d\n\u0086\3\u0087\3\u0087\5"+
		"\u0087\u0881\n\u0087\3\u0087\5\u0087\u0884\n\u0087\3\u0087\5\u0087\u0887"+
		"\n\u0087\3\u0087\5\u0087\u088a\n\u0087\3\u0087\5\u0087\u088d\n\u0087\3"+
		"\u0088\3\u0088\3\u0088\3\u0089\3\u0089\3\u0089\7\u0089\u0895\n\u0089\f"+
		"\u0089\16\u0089\u0898\13\u0089\3\u008a\3\u008a\5\u008a\u089c\n\u008a\3"+
		"\u008b\3\u008b\6\u008b\u08a0\n\u008b\r\u008b\16\u008b\u08a1\3\u008c\3"+
		"\u008c\3\u008c\3\u008c\5\u008c\u08a8\n\u008c\3\u008c\3\u008c\3\u008c\3"+
		"\u008c\3\u008c\3\u008c\5\u008c\u08b0\n\u008c\3\u008c\3\u008c\3\u008c\3"+
		"\u008c\3\u008c\5\u008c\u08b7\n\u008c\3\u008d\3\u008d\3\u008d\3\u008d\3"+
		"\u008e\5\u008e\u08be\n\u008e\3\u008e\3\u008e\3\u008e\3\u008e\3\u008f\3"+
		"\u008f\5\u008f\u08c6\n\u008f\3\u008f\3\u008f\3\u008f\3\u0090\3\u0090\3"+
		"\u0090\3\u0090\3\u0091\3\u0091\5\u0091\u08d1\n\u0091\3\u0092\3\u0092\5"+
		"\u0092\u08d5\n\u0092\3\u0093\3\u0093\3\u0094\3\u0094\5\u0094\u08db\n\u0094"+
		"\3\u0095\3\u0095\3\u0095\3\u0096\3\u0096\3\u0096\3\u0096\3\u0096\3\u0097"+
		"\3\u0097\5\u0097\u08e7\n\u0097\3\u0097\5\u0097\u08ea\n\u0097\3\u0097\3"+
		"\u0097\3\u0097\3\u0097\5\u0097\u08f0\n\u0097\3\u0097\3\u0097\5\u0097\u08f4"+
		"\n\u0097\3\u0097\3\u0097\3\u0097\3\u0097\3\u0097\5\u0097\u08fb\n\u0097"+
		"\5\u0097\u08fd\n\u0097\3\u0098\3\u0098\3\u0098\7\u0098\u0902\n\u0098\f"+
		"\u0098\16\u0098\u0905\13\u0098\3\u0099\3\u0099\3\u009a\3\u009a\3\u009a"+
		"\3\u009b\3\u009b\3\u009c\3\u009c\3\u009c\3\u009c\3\u009d\3\u009d\3\u009d"+
		"\7\u009d\u0915\n\u009d\f\u009d\16\u009d\u0918\13\u009d\3\u009e\3\u009e"+
		"\3\u009e\3\u009e\5\u009e\u091e\n\u009e\3\u009f\3\u009f\3\u009f\3\u009f"+
		"\3\u009f\5\u009f\u0925\n\u009f\3\u00a0\3\u00a0\3\u00a0\7\u00a0\u092a\n"+
		"\u00a0\f\u00a0\16\u00a0\u092d\13\u00a0\3\u00a1\3\u00a1\3\u00a1\3\u00a1"+
		"\3\u00a1\3\u00a2\3\u00a2\3\u00a2\3\u00a2\3\u00a2\3\u00a3\3\u00a3\3\u00a3"+
		"\3\u00a4\3\u00a4\3\u00a4\3\u00a5\3\u00a5\3\u00a5\7\u00a5\u0942\n\u00a5"+
		"\f\u00a5\16\u00a5\u0945\13\u00a5\3\u00a6\3\u00a6\3\u00a7\3\u00a7\5\u00a7"+
		"\u094b\n\u00a7\3\u00a8\3\u00a8\3\u00a8\3\u00a8\5\u00a8\u0951\n\u00a8\3"+
		"\u00a8\3\u00a8\5\u00a8\u0955\n\u00a8\3\u00a8\3\u00a8\5\u00a8\u0959\n\u00a8"+
		"\3\u00a8\7\u00a8\u095c\n\u00a8\f\u00a8\16\u00a8\u095f\13\u00a8\3\u00a9"+
		"\3\u00a9\5\u00a9\u0963\n\u00a9\3\u00aa\3\u00aa\3\u00aa\3\u00aa\5\u00aa"+
		"\u0969\n\u00aa\3\u00aa\3\u00aa\5\u00aa\u096d\n\u00aa\3\u00aa\3\u00aa\5"+
		"\u00aa\u0971\n\u00aa\3\u00aa\7\u00aa\u0974\n\u00aa\f\u00aa\16\u00aa\u0977"+
		"\13\u00aa\3\u00ab\3\u00ab\5\u00ab\u097b\n\u00ab\3\u00ac\3\u00ac\3\u00ac"+
		"\3\u00ac\3\u00ac\5\u00ac\u0982\n\u00ac\3\u00ad\3\u00ad\5\u00ad\u0986\n"+
		"\u00ad\3\u00ae\3\u00ae\3\u00ae\3\u00af\3\u00af\5\u00af\u098d\n\u00af\3"+
		"\u00b0\3\u00b0\3\u00b0\3\u00b0\3\u00b0\5\u00b0\u0994\n\u00b0\5\u00b0\u0996"+
		"\n\u00b0\3\u00b1\3\u00b1\5\u00b1\u099a\n\u00b1\3\u00b1\3\u00b1\5\u00b1"+
		"\u099e\n\u00b1\3\u00b2\3\u00b2\3\u00b2\7\u00b2\u09a3\n\u00b2\f\u00b2\16"+
		"\u00b2\u09a6\13\u00b2\3\u00b3\3\u00b3\5\u00b3\u09aa\n\u00b3\3\u00b4\3"+
		"\u00b4\5\u00b4\u09ae\n\u00b4\3\u00b5\3\u00b5\5\u00b5\u09b2\n\u00b5\3\u00b5"+
		"\3\u00b5\3\u00b6\3\u00b6\3\u00b7\3\u00b7\3\u00b7\5\u00b7\u09bb\n\u00b7"+
		"\3\u00b7\3\u00b7\3\u00b8\5\u00b8\u09c0\n\u00b8\3\u00b8\3\u00b8\3\u00b9"+
		"\3\u00b9\3\u00b9\7\u00b9\u09c7\n\u00b9\f\u00b9\16\u00b9\u09ca\13\u00b9"+
		"\3\u00ba\3\u00ba\3\u00bb\3\u00bb\3\u00bc\3\u00bc\3\u00bd\3\u00bd\3\u00bd"+
		"\3\u00bd\3\u00be\3\u00be\3\u00be\3\u00be\3\u00be\3\u00be\5\u00be\u09dc"+
		"\n\u00be\3\u00bf\3\u00bf\3\u00bf\3\u00bf\3\u00c0\3\u00c0\3\u00c1\3\u00c1"+
		"\3\u00c1\3\u00c2\5\u00c2\u09e8\n\u00c2\3\u00c2\3\u00c2\5\u00c2\u09ec\n"+
		"\u00c2\3\u00c2\3\u00c2\3\u00c2\3\u00c2\3\u00c3\3\u00c3\5\u00c3\u09f4\n"+
		"\u00c3\3\u00c3\3\u00c3\3\u00c3\3\u00c4\3\u00c4\3\u00c4\3\u00c4\3\u00c4"+
		"\5\u00c4\u09fe\n\u00c4\3\u00c5\3\u00c5\3\u00c5\7\u00c5\u0a03\n\u00c5\f"+
		"\u00c5\16\u00c5\u0a06\13\u00c5\3\u00c6\3\u00c6\3\u00c6\3\u00c6\3\u00c7"+
		"\5\u00c7\u0a0d\n\u00c7\3\u00c7\3\u00c7\5\u00c7\u0a11\n\u00c7\3\u00c8\3"+
		"\u00c8\3\u00c8\3\u00c8\3\u00c8\3\u00c8\5\u00c8\u0a19\n\u00c8\3\u00c9\3"+
		"\u00c9\3\u00ca\3\u00ca\3\u00ca\5\u00ca\u0a20\n\u00ca\3\u00ca\3\u00ca\3"+
		"\u00cb\3\u00cb\3\u00cb\3\u00cb\3\u00cb\3\u00cc\3\u00cc\5\u00cc\u0a2b\n"+
		"\u00cc\3\u00cd\3\u00cd\3\u00ce\3\u00ce\3\u00cf\5\u00cf\u0a32\n\u00cf\3"+
		"\u00cf\3\u00cf\3\u00cf\3\u00d0\3\u00d0\3\u00d0\3\u00d1\3\u00d1\5\u00d1"+
		"\u0a3c\n\u00d1\3\u00d2\3\u00d2\3\u00d3\3\u00d3\3\u00d4\3\u00d4\3\u00d4"+
		"\5\u00d4\u0a45\n\u00d4\3\u00d4\3\u00d4\3\u00d5\3\u00d5\3\u00d6\3\u00d6"+
		"\5\u00d6\u0a4d\n\u00d6\3\u00d7\3\u00d7\3\u00d7\7\u00d7\u0a52\n\u00d7\f"+
		"\u00d7\16\u00d7\u0a55\13\u00d7\3\u00d8\3\u00d8\3\u00d8\3\u00d8\3\u00d9"+
		"\3\u00d9\3\u00d9\7\u00d9\u0a5e\n\u00d9\f\u00d9\16\u00d9\u0a61\13\u00d9"+
		"\3\u00da\3\u00da\5\u00da\u0a65\n\u00da\3\u00da\5\u00da\u0a68\n\u00da\3"+
		"\u00db\3\u00db\3\u00dc\3\u00dc\3\u00dc\3\u00dd\3\u00dd\3\u00dd\3\u00dd"+
		"\5\u00dd\u0a73\n\u00dd\3\u00de\3\u00de\5\u00de\u0a77\n\u00de\3\u00de\3"+
		"\u00de\3\u00de\3\u00de\3\u00de\3\u00de\5\u00de\u0a7f\n\u00de\3\u00de\3"+
		"\u00de\3\u00de\3\u00de\5\u00de\u0a85\n\u00de\3\u00de\3\u00de\3\u00de\3"+
		"\u00de\3\u00de\3\u00de\5\u00de\u0a8d\n\u00de\5\u00de\u0a8f\n\u00de\3\u00de"+
		"\5\u00de\u0a92\n\u00de\3\u00de\2\2\u00df\2\4\6\b\n\f\16\20\22\24\26\30"+
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
		"\u01ba\2$\4\2CC]]\4\2\u00cc\u00cc\u0102\u0102\4\2\r\rVV\4\2\23\23ll\t"+
		"\2\32\32TT\\\\ffhhkk\u0097\u0097\6\2TT\\\\kk\u0097\u0097\4\2\\\\kl\5\2"+
		"\20\20\23\23bc\4\2\\\\kk\6\2\63\63::KKnn\4\2,,CC\3\2bc\4\2\"\"\64\64\b"+
		"\2\5\5\22\22\27\27~~\u0096\u0096\u00c0\u00c0\t\2s\u0093\u0095\u0095\u0097"+
		"\u00c5\u00c7\u00d2\u00d4\u00e7\u00e9\u00f6\u00f8\u00fb\5\2%%gg\u00cd\u00cd"+
		"\3\2\u00d8\u00d9\3\2\u0118\u0119\17\2\7\7^^ttzz\u0080\u0080\u008a\u008a"+
		"\u0091\u0091\u0098\u0098\u00a2\u00a2\u00a7\u00a7\u00c1\u00c2\u00c4\u00c4"+
		"\u00d0\u00d1\3\2\u010e\u010f\3\2\u0110\u0112\3\2\u00c8\u00ca\5\2\13\13"+
		"??ee\5\2((@@XX\4\2  ii\4\2\5\5\34\34\4\2\u0102\u0102\u0107\u010b\4\2\b"+
		"\b``\3\2\u00fc\u00ff\4\2\7\7^^\6\2\u0083\u0083\u0094\u0094\u00a8\u00a9"+
		"\u00d6\u00d6\t\2ww\u0085\u0087\u0089\u0089\u0099\u009a\u00a4\u00a6\u00b6"+
		"\u00b6\u00d4\u00d4\4\2@@XX\4\2\t\t\33\33\u0ba1\2\u01c0\3\2\2\2\4\u01cf"+
		"\3\2\2\2\6\u01d1\3\2\2\2\b\u01d3\3\2\2\2\n\u01d7\3\2\2\2\f\u01d9\3\2\2"+
		"\2\16\u01ea\3\2\2\2\20\u0228\3\2\2\2\22\u022a\3\2\2\2\24\u02c4\3\2\2\2"+
		"\26\u040b\3\2\2\2\30\u040d\3\2\2\2\32\u0421\3\2\2\2\34\u0423\3\2\2\2\36"+
		"\u0437\3\2\2\2 \u04e5\3\2\2\2\"\u04e7\3\2\2\2$\u04ec\3\2\2\2&\u055f\3"+
		"\2\2\2(\u058e\3\2\2\2*\u0593\3\2\2\2,\u05a8\3\2\2\2.\u05b3\3\2\2\2\60"+
		"\u05b7\3\2\2\2\62\u05bf\3\2\2\2\64\u05c2\3\2\2\2\66\u05ca\3\2\2\28\u05d5"+
		"\3\2\2\2:\u05d8\3\2\2\2<\u05da\3\2\2\2>\u05e6\3\2\2\2@\u05ea\3\2\2\2B"+
		"\u05ed\3\2\2\2D\u05f0\3\2\2\2F\u05f6\3\2\2\2H\u05f8\3\2\2\2J\u0602\3\2"+
		"\2\2L\u060a\3\2\2\2N\u061c\3\2\2\2P\u0629\3\2\2\2R\u0631\3\2\2\2T\u0634"+
		"\3\2\2\2V\u0637\3\2\2\2X\u0641\3\2\2\2Z\u0649\3\2\2\2\\\u0653\3\2\2\2"+
		"^\u0658\3\2\2\2`\u065a\3\2\2\2b\u0668\3\2\2\2d\u066a\3\2\2\2f\u066e\3"+
		"\2\2\2h\u0673\3\2\2\2j\u0678\3\2\2\2l\u067a\3\2\2\2n\u067d\3\2\2\2p\u0680"+
		"\3\2\2\2r\u0683\3\2\2\2t\u0685\3\2\2\2v\u0691\3\2\2\2x\u0693\3\2\2\2z"+
		"\u0695\3\2\2\2|\u06ae\3\2\2\2~\u06b0\3\2\2\2\u0080\u06d7\3\2\2\2\u0082"+
		"\u06e1\3\2\2\2\u0084\u06e5\3\2\2\2\u0086\u06fc\3\2\2\2\u0088\u0708\3\2"+
		"\2\2\u008a\u0712\3\2\2\2\u008c\u0714\3\2\2\2\u008e\u0723\3\2\2\2\u0090"+
		"\u0732\3\2\2\2\u0092\u0741\3\2\2\2\u0094\u0745\3\2\2\2\u0096\u0747\3\2"+
		"\2\2\u0098\u0752\3\2\2\2\u009a\u0754\3\2\2\2\u009c\u0756\3\2\2\2\u009e"+
		"\u0759\3\2\2\2\u00a0\u075d\3\2\2\2\u00a2\u0767\3\2\2\2\u00a4\u0769\3\2"+
		"\2\2\u00a6\u0771\3\2\2\2\u00a8\u0773\3\2\2\2\u00aa\u0779\3\2\2\2\u00ac"+
		"\u077e\3\2\2\2\u00ae\u0792\3\2\2\2\u00b0\u0796\3\2\2\2\u00b2\u0798\3\2"+
		"\2\2\u00b4\u07a4\3\2\2\2\u00b6\u07af\3\2\2\2\u00b8\u07b4\3\2\2\2\u00ba"+
		"\u07b9\3\2\2\2\u00bc\u07be\3\2\2\2\u00be\u07c0\3\2\2\2\u00c0\u07c7\3\2"+
		"\2\2\u00c2\u07c9\3\2\2\2\u00c4\u07ce\3\2\2\2\u00c6\u07d3\3\2\2\2\u00c8"+
		"\u07d5\3\2\2\2\u00ca\u07dd\3\2\2\2\u00cc\u07e6\3\2\2\2\u00ce\u07ea\3\2"+
		"\2\2\u00d0\u07fe\3\2\2\2\u00d2\u0800\3\2\2\2\u00d4\u0802\3\2\2\2\u00d6"+
		"\u0804\3\2\2\2\u00d8\u080e\3\2\2\2\u00da\u0810\3\2\2\2\u00dc\u0814\3\2"+
		"\2\2\u00de\u0816\3\2\2\2\u00e0\u0818\3\2\2\2\u00e2\u0820\3\2\2\2\u00e4"+
		"\u0824\3\2\2\2\u00e6\u0826\3\2\2\2\u00e8\u0828\3\2\2\2\u00ea\u083b\3\2"+
		"\2\2\u00ec\u083d\3\2\2\2\u00ee\u083f\3\2\2\2\u00f0\u0841\3\2\2\2\u00f2"+
		"\u0849\3\2\2\2\u00f4\u0854\3\2\2\2\u00f6\u0856\3\2\2\2\u00f8\u085a\3\2"+
		"\2\2\u00fa\u0860\3\2\2\2\u00fc\u0864\3\2\2\2\u00fe\u0868\3\2\2\2\u0100"+
		"\u086a\3\2\2\2\u0102\u0870\3\2\2\2\u0104\u0872\3\2\2\2\u0106\u0874\3\2"+
		"\2\2\u0108\u0878\3\2\2\2\u010a\u087c\3\2\2\2\u010c\u087e\3\2\2\2\u010e"+
		"\u088e\3\2\2\2\u0110\u0891\3\2\2\2\u0112\u089b\3\2\2\2\u0114\u089d\3\2"+
		"\2\2\u0116\u08b6\3\2\2\2\u0118\u08b8\3\2\2\2\u011a\u08bd\3\2\2\2\u011c"+
		"\u08c3\3\2\2\2\u011e\u08ca\3\2\2\2\u0120\u08d0\3\2\2\2\u0122\u08d2\3\2"+
		"\2\2\u0124\u08d6\3\2\2\2\u0126\u08da\3\2\2\2\u0128\u08dc\3\2\2\2\u012a"+
		"\u08df\3\2\2\2\u012c\u08fc\3\2\2\2\u012e\u08fe\3\2\2\2\u0130\u0906\3\2"+
		"\2\2\u0132\u0908\3\2\2\2\u0134\u090b\3\2\2\2\u0136\u090d\3\2\2\2\u0138"+
		"\u0911\3\2\2\2\u013a\u091d\3\2\2\2\u013c\u0924\3\2\2\2\u013e\u0926\3\2"+
		"\2\2\u0140\u092e\3\2\2\2\u0142\u0933\3\2\2\2\u0144\u0938\3\2\2\2\u0146"+
		"\u093b\3\2\2\2\u0148\u093e\3\2\2\2\u014a\u0946\3\2\2\2\u014c\u094a\3\2"+
		"\2\2\u014e\u0954\3\2\2\2\u0150\u0962\3\2\2\2\u0152\u096c\3\2\2\2\u0154"+
		"\u097a\3\2\2\2\u0156\u0981\3\2\2\2\u0158\u0985\3\2\2\2\u015a\u0987\3\2"+
		"\2\2\u015c\u098c\3\2\2\2\u015e\u098e\3\2\2\2\u0160\u0997\3\2\2\2\u0162"+
		"\u099f\3\2\2\2\u0164\u09a9\3\2\2\2\u0166\u09ab\3\2\2\2\u0168\u09b1\3\2"+
		"\2\2\u016a\u09b5\3\2\2\2\u016c\u09ba\3\2\2\2\u016e\u09bf\3\2\2\2\u0170"+
		"\u09c3\3\2\2\2\u0172\u09cb\3\2\2\2\u0174\u09cd\3\2\2\2\u0176\u09cf\3\2"+
		"\2\2\u0178\u09d1\3\2\2\2\u017a\u09db\3\2\2\2\u017c\u09dd\3\2\2\2\u017e"+
		"\u09e1\3\2\2\2\u0180\u09e3\3\2\2\2\u0182\u09e7\3\2\2\2\u0184\u09f1\3\2"+
		"\2\2\u0186\u09fd\3\2\2\2\u0188\u09ff\3\2\2\2\u018a\u0a07\3\2\2\2\u018c"+
		"\u0a10\3\2\2\2\u018e\u0a18\3\2\2\2\u0190\u0a1a\3\2\2\2\u0192\u0a1c\3\2"+
		"\2\2\u0194\u0a23\3\2\2\2\u0196\u0a2a\3\2\2\2\u0198\u0a2c\3\2\2\2\u019a"+
		"\u0a2e\3\2\2\2\u019c\u0a31\3\2\2\2\u019e\u0a36\3\2\2\2\u01a0\u0a3b\3\2"+
		"\2\2\u01a2\u0a3d\3\2\2\2\u01a4\u0a3f\3\2\2\2\u01a6\u0a41\3\2\2\2\u01a8"+
		"\u0a48\3\2\2\2\u01aa\u0a4c\3\2\2\2\u01ac\u0a4e\3\2\2\2\u01ae\u0a56\3\2"+
		"\2\2\u01b0\u0a5a\3\2\2\2\u01b2\u0a62\3\2\2\2\u01b4\u0a69\3\2\2\2\u01b6"+
		"\u0a6b\3\2\2\2\u01b8\u0a72\3\2\2\2\u01ba\u0a91\3\2\2\2\u01bc\u01be\5\4"+
		"\3\2\u01bd\u01bf\7\u0104\2\2\u01be\u01bd\3\2\2\2\u01be\u01bf\3\2\2\2\u01bf"+
		"\u01c1\3\2\2\2\u01c0\u01bc\3\2\2\2\u01c1\u01c2\3\2\2\2\u01c2\u01c0\3\2"+
		"\2\2\u01c2\u01c3\3\2\2\2\u01c3\u01c4\3\2\2\2\u01c4\u01c5\7\2\2\3\u01c5"+
		"\3\3\2\2\2\u01c6\u01d0\5\6\4\2\u01c7\u01d0\5\b\5\2\u01c8\u01d0\5\n\6\2"+
		"\u01c9\u01d0\5\f\7\2\u01ca\u01d0\5\16\b\2\u01cb\u01d0\5\20\t\2\u01cc\u01d0"+
		"\5\22\n\2\u01cd\u01d0\5\26\f\2\u01ce\u01d0\5\24\13\2\u01cf\u01c6\3\2\2"+
		"\2\u01cf\u01c7\3\2\2\2\u01cf\u01c8\3\2\2\2\u01cf\u01c9\3\2\2\2\u01cf\u01ca"+
		"\3\2\2\2\u01cf\u01cb\3\2\2\2\u01cf\u01cc\3\2\2\2\u01cf\u01cd\3\2\2\2\u01cf"+
		"\u01ce\3\2\2\2\u01d0\5\3\2\2\2\u01d1\u01d2\5\u014a\u00a6\2\u01d2\7\3\2"+
		"\2\2\u01d3\u01d4\5\u01ba\u00de\2\u01d4\t\3\2\2\2\u01d5\u01d8\5 \21\2\u01d6"+
		"\u01d8\5`\61\2\u01d7\u01d5\3\2\2\2\u01d7\u01d6\3\2\2\2\u01d8\13\3\2\2"+
		"\2\u01d9\u01db\7\23\2\2\u01da\u01dc\7j\2\2\u01db\u01da\3\2\2\2\u01db\u01dc"+
		"\3\2\2\2\u01dc\u01dd\3\2\2\2\u01dd\u01de\7\u0095\2\2\u01de\u01df\5b\62"+
		"\2\u01df\u01e0\7I\2\2\u01e0\u01e2\5\u015e\u00b0\2\u01e1\u01e3\5@!\2\u01e2"+
		"\u01e1\3\2\2\2\u01e2\u01e3\3\2\2\2\u01e3\u01e4\3\2\2\2\u01e4\u01e5\7\u010c"+
		"\2\2\u01e5\u01e6\5\u01b0\u00d9\2\u01e6\u01e8\7\u010d\2\2\u01e7\u01e9\5"+
		"<\37\2\u01e8\u01e7\3\2\2\2\u01e8\u01e9\3\2\2\2\u01e9\r\3\2\2\2\u01ea\u01eb"+
		"\7\23\2\2\u01eb\u01ef\7$\2\2\u01ec\u01ed\7\60\2\2\u01ed\u01ee\7E\2\2\u01ee"+
		"\u01f0\7\u008b\2\2\u01ef\u01ec\3\2\2\2\u01ef\u01f0\3\2\2\2\u01f0\u01f1"+
		"\3\2\2\2\u01f1\u01f3\5b\62\2\u01f2\u01f4\7q\2\2\u01f3\u01f2\3\2\2\2\u01f3"+
		"\u01f4\3\2\2\2\u01f4\u01f7\3\2\2\2\u01f5\u01f6\7Y\2\2\u01f6\u01f8\5b\62"+
		"\2\u01f7\u01f5\3\2\2\2\u01f7\u01f8\3\2\2\2\u01f8\u01fb\3\2\2\2\u01f9\u01fa"+
		"\7\u00d3\2\2\u01fa\u01fc\5b\62\2\u01fb\u01f9\3\2\2\2\u01fb\u01fc\3\2\2"+
		"\2\u01fc\u01ff\3\2\2\2\u01fd\u01fe\7+\2\2\u01fe\u0200\5b\62\2\u01ff\u01fd"+
		"\3\2\2\2\u01ff\u0200\3\2\2\2\u0200\17\3\2\2\2\u0201\u0203\7\u00bd\2\2"+
		"\u0202\u0204\t\2\2\2\u0203\u0202\3\2\2\2\u0203\u0204\3\2\2\2\u0204\u0205"+
		"\3\2\2\2\u0205\u0206\5b\62\2\u0206\u0212\t\3\2\2\u0207\u020e\5b\62\2\u0208"+
		"\u0209\7\u0116\2\2\u0209\u020a\5b\62\2\u020a\u020b\7\u0116\2\2\u020b\u020e"+
		"\3\2\2\2\u020c\u020e\7\26\2\2\u020d\u0207\3\2\2\2\u020d\u0208\3\2\2\2"+
		"\u020d\u020c\3\2\2\2\u020e\u0210\3\2\2\2\u020f\u0211\7\u0105\2\2\u0210"+
		"\u020f\3\2\2\2\u0210\u0211\3\2\2\2\u0211\u0213\3\2\2\2\u0212\u020d\3\2"+
		"\2\2\u0213\u0214\3\2\2\2\u0214\u0212\3\2\2\2\u0214\u0215\3\2\2\2\u0215"+
		"\u0229\3\2\2\2\u0216\u0218\7\u00bd\2\2\u0217\u0219\t\2\2\2\u0218\u0217"+
		"\3\2\2\2\u0218\u0219\3\2\2\2\u0219\u021a\3\2\2\2\u021a\u021b\7\u00f2\2"+
		"\2\u021b\u0224\7\u00d7\2\2\u021c\u0220\5b\62\2\u021d\u0220\7C\2\2\u021e"+
		"\u0220\7\26\2\2\u021f\u021c\3\2\2\2\u021f\u021d\3\2\2\2\u021f\u021e\3"+
		"\2\2\2\u0220\u0222\3\2\2\2\u0221\u0223\7\u0105\2\2\u0222\u0221\3\2\2\2"+
		"\u0222\u0223\3\2\2\2\u0223\u0225\3\2\2\2\u0224\u021f\3\2\2\2\u0225\u0226"+
		"\3\2\2\2\u0226\u0224\3\2\2\2\u0226\u0227\3\2\2\2\u0227\u0229\3\2\2\2\u0228"+
		"\u0201\3\2\2\2\u0228\u0216\3\2\2\2\u0229\21\3\2\2\2\u022a\u022c\7\23\2"+
		"\2\u022b\u022d\7\21\2\2\u022c\u022b\3\2\2\2\u022c\u022d\3\2\2\2\u022d"+
		"\u022e\3\2\2\2\u022e\u022f\7f\2\2\u022f\u0234\5b\62\2\u0230\u0235\7\n"+
		"\2\2\u0231\u0232\7;\2\2\u0232\u0235\7G\2\2\u0233\u0235\7\3\2\2\u0234\u0230"+
		"\3\2\2\2\u0234\u0231\3\2\2\2\u0234\u0233\3\2\2\2\u0235\u0245\3\2\2\2\u0236"+
		"\u0246\7\u0097\2\2\u0237\u0246\7\32\2\2\u0238\u0246\7h\2\2\u0239\u0243"+
		"\7k\2\2\u023a\u023f\7G\2\2\u023b\u023d\5b\62\2\u023c\u023e\7\u0105\2\2"+
		"\u023d\u023c\3\2\2\2\u023d\u023e\3\2\2\2\u023e\u0240\3\2\2\2\u023f\u023b"+
		"\3\2\2\2\u0240\u0241\3\2\2\2\u0241\u023f\3\2\2\2\u0241\u0242\3\2\2\2\u0242"+
		"\u0244\3\2\2\2\u0243\u023a\3\2\2\2\u0243\u0244\3\2\2\2\u0244\u0246\3\2"+
		"\2\2\u0245\u0236\3\2\2\2\u0245\u0237\3\2\2\2\u0245\u0238\3\2\2\2\u0245"+
		"\u0239\3\2\2\2\u0246\u0247\3\2\2\2\u0247\u0248\7I\2\2\u0248\u024b\5\u015e"+
		"\u00b0\2\u0249\u024a\7+\2\2\u024a\u024c\5\u015e\u00b0\2\u024b\u0249\3"+
		"\2\2\2\u024b\u024c\3\2\2\2\u024c\u0256\3\2\2\2\u024d\u024e\7E\2\2\u024e"+
		"\u0257\7\30\2\2\u024f\u0251\7\30\2\2\u0250\u024f\3\2\2\2\u0250\u0251\3"+
		"\2\2\2\u0251\u0252\3\2\2\2\u0252\u0253\7\66\2\2\u0253\u0257\7\62\2\2\u0254"+
		"\u0255\7\66\2\2\u0255\u0257\7\31\2\2\u0256\u024d\3\2\2\2\u0256\u0250\3"+
		"\2\2\2\u0256\u0254\3\2\2\2\u0256\u0257\3\2\2\2\u0257\u025e\3\2\2\2\u0258"+
		"\u025a\7&\2\2\u0259\u025b\7\35\2\2\u025a\u0259\3\2\2\2\u025a\u025b\3\2"+
		"\2\2\u025b\u025c\3\2\2\2\u025c\u025f\7R\2\2\u025d\u025f\7_\2\2\u025e\u0258"+
		"\3\2\2\2\u025e\u025d\3\2\2\2\u025e\u025f\3\2\2\2\u025f\u0262\3\2\2\2\u0260"+
		"\u0261\7o\2\2\u0261\u0263\5\u00eex\2\u0262\u0260\3\2\2\2\u0262\u0263\3"+
		"\2\2\2\u0263\u0264\3\2\2\2\u0264\u0265\7#\2\2\u0265\u0266\7Q\2\2\u0266"+
		"\u0267\5b\62\2\u0267\u026c\7\u010c\2\2\u0268\u026a\5b\62\2\u0269\u026b"+
		"\7\u0105\2\2\u026a\u0269\3\2\2\2\u026a\u026b\3\2\2\2\u026b\u026d\3\2\2"+
		"\2\u026c\u0268\3\2\2\2\u026c\u026d\3\2\2\2\u026d\u026e\3\2\2\2\u026e\u026f"+
		"\7\u010d\2\2\u026f\23\3\2\2\2\u0270\u0274\7W\2\2\u0271\u0272\7-\2\2\u0272"+
		"\u0273\7\u00ad\2\2\u0273\u0275\7&\2\2\u0274\u0271\3\2\2\2\u0274\u0275"+
		"\3\2\2\2\u0275\u027b\3\2\2\2\u0276\u027c\7#\2\2\u0277\u0279\7\5\2\2\u0278"+
		"\u027a\7P\2\2\u0279\u0278\3\2\2\2\u0279\u027a\3\2\2\2\u027a\u027c\3\2"+
		"\2\2\u027b\u0276\3\2\2\2\u027b\u0277\3\2\2\2\u027c\u027d\3\2\2\2\u027d"+
		"\u0280\7I\2\2\u027e\u0281\5\34\17\2\u027f\u0281\5\36\20\2\u0280\u027e"+
		"\3\2\2\2\u0280\u027f\3\2\2\2\u0281\u0282\3\2\2\2\u0282\u028d\7+\2\2\u0283"+
		"\u0285\7.\2\2\u0284\u0283\3\2\2\2\u0284\u0285\3\2\2\2\u0285\u0286\3\2"+
		"\2\2\u0286\u0289\5b\62\2\u0287\u0289\7\u00b4\2\2\u0288\u0284\3\2\2\2\u0288"+
		"\u0287\3\2\2\2\u0289\u028b\3\2\2\2\u028a\u028c\7\u0105\2\2\u028b\u028a"+
		"\3\2\2\2\u028b\u028c\3\2\2\2\u028c\u028e\3\2\2\2\u028d\u0288\3\2\2\2\u028e"+
		"\u028f\3\2\2\2\u028f\u028d\3\2\2\2\u028f\u0290\3\2\2\2\u0290\u0292\3\2"+
		"\2\2\u0291\u0293\t\4\2\2\u0292\u0291\3\2\2\2\u0292\u0293\3\2\2\2\u0293"+
		"\u02c5\3\2\2\2\u0294\u0298\7W\2\2\u0295\u0296\7-\2\2\u0296\u0297\7\u00ad"+
		"\2\2\u0297\u0299\7&\2\2\u0298\u0295\3\2\2\2\u0298\u0299\3\2\2\2\u0299"+
		"\u02a6\3\2\2\2\u029a\u029c\t\5\2\2\u029b\u029d\7\u0105\2\2\u029c\u029b"+
		"\3\2\2\2\u029c\u029d\3\2\2\2\u029d\u029f\3\2\2\2\u029e\u029a\3\2\2\2\u029f"+
		"\u02a0\3\2\2\2\u02a0\u029e\3\2\2\2\u02a0\u02a1\3\2\2\2\u02a1\u02a7\3\2"+
		"\2\2\u02a2\u02a4\7\5\2\2\u02a3\u02a5\7P\2\2\u02a4\u02a3\3\2\2\2\u02a4"+
		"\u02a5\3\2\2\2\u02a5\u02a7\3\2\2\2\u02a6\u029e\3\2\2\2\u02a6\u02a2\3\2"+
		"\2\2\u02a7\u02a8\3\2\2\2\u02a8\u02a9\7I\2\2\u02a9\u02ae\7Y\2\2\u02aa\u02ac"+
		"\5b\62\2\u02ab\u02ad\7\u0105\2\2\u02ac\u02ab\3\2\2\2\u02ac\u02ad\3\2\2"+
		"\2\u02ad\u02af\3\2\2\2\u02ae\u02aa\3\2\2\2\u02af\u02b0\3\2\2\2\u02b0\u02ae"+
		"\3\2\2\2\u02b0\u02b1\3\2\2\2\u02b1\u02b2\3\2\2\2\u02b2\u02bd\7+\2\2\u02b3"+
		"\u02b5\7.\2\2\u02b4\u02b3\3\2\2\2\u02b4\u02b5\3\2\2\2\u02b5\u02b6\3\2"+
		"\2\2\u02b6\u02b9\5b\62\2\u02b7\u02b9\7\u00b4\2\2\u02b8\u02b4\3\2\2\2\u02b8"+
		"\u02b7\3\2\2\2\u02b9\u02bb\3\2\2\2\u02ba\u02bc\7\u0105\2\2\u02bb\u02ba"+
		"\3\2\2\2\u02bb\u02bc\3\2\2\2\u02bc\u02be\3\2\2\2\u02bd\u02b8\3\2\2\2\u02be"+
		"\u02bf\3\2\2\2\u02bf\u02bd\3\2\2\2\u02bf\u02c0\3\2\2\2\u02c0\u02c2\3\2"+
		"\2\2\u02c1\u02c3\t\4\2\2\u02c2\u02c1\3\2\2\2\u02c2\u02c3\3\2\2\2\u02c3"+
		"\u02c5\3\2\2\2\u02c4\u0270\3\2\2\2\u02c4\u0294\3\2\2\2\u02c5\25\3\2\2"+
		"\2\u02c6\u02d0\7-\2\2\u02c7\u02c9\t\6\2\2\u02c8\u02c7\3\2\2\2\u02c9\u02ca"+
		"\3\2\2\2\u02ca\u02c8\3\2\2\2\u02ca\u02cb\3\2\2\2\u02cb\u02d1\3\2\2\2\u02cc"+
		"\u02ce\7\5\2\2\u02cd\u02cf\7P\2\2\u02ce\u02cd\3\2\2\2\u02ce\u02cf\3\2"+
		"\2\2\u02cf\u02d1\3\2\2\2\u02d0\u02c8\3\2\2\2\u02d0\u02cc\3\2\2\2\u02d1"+
		"\u02d2\3\2\2\2\u02d2\u02ea\7I\2\2\u02d3\u02d5\7a\2\2\u02d4\u02d3\3\2\2"+
		"\2\u02d4\u02d5\3\2\2\2\u02d5\u02da\3\2\2\2\u02d6\u02d8\5\u015e\u00b0\2"+
		"\u02d7\u02d9\7\u0105\2\2\u02d8\u02d7\3\2\2\2\u02d8\u02d9\3\2\2\2\u02d9"+
		"\u02db\3\2\2\2\u02da\u02d6\3\2\2\2\u02db\u02dc\3\2\2\2\u02dc\u02da\3\2"+
		"\2\2\u02dc\u02dd\3\2\2\2\u02dd\u02eb\3\2\2\2\u02de\u02df\7\5\2\2\u02df"+
		"\u02e0\7\u00c6\2\2\u02e0\u02e1\7\63\2\2\u02e1\u02e6\7Y\2\2\u02e2\u02e4"+
		"\5b\62\2\u02e3\u02e5\7\u0105\2\2\u02e4\u02e3\3\2\2\2\u02e4\u02e5\3\2\2"+
		"\2\u02e5\u02e7\3\2\2\2\u02e6\u02e2\3\2\2\2\u02e7\u02e8\3\2\2\2\u02e8\u02e6"+
		"\3\2\2\2\u02e8\u02e9\3\2\2\2\u02e9\u02eb\3\2\2\2\u02ea\u02d4\3\2\2\2\u02ea"+
		"\u02de\3\2\2\2\u02eb\u02ec\3\2\2\2\u02ec\u02ed\5\30\r\2\u02ed\u040c\3"+
		"\2\2\2\u02ee\u0308\7-\2\2\u02ef\u02f4\t\7\2\2\u02f0\u02f2\5b\62\2\u02f1"+
		"\u02f3\7\u0105\2\2\u02f2\u02f1\3\2\2\2\u02f2\u02f3\3\2\2\2\u02f3\u02f5"+
		"\3\2\2\2\u02f4\u02f0\3\2\2\2\u02f5\u02f6\3\2\2\2\u02f6\u02f4\3\2\2\2\u02f6"+
		"\u02f7\3\2\2\2\u02f7\u02f9\3\2\2\2\u02f8\u02ef\3\2\2\2\u02f9\u02fa\3\2"+
		"\2\2\u02fa\u02f8\3\2\2\2\u02fa\u02fb\3\2\2\2\u02fb\u0309\3\2\2\2\u02fc"+
		"\u02fe\7\5\2\2\u02fd\u02ff\7P\2\2\u02fe\u02fd\3\2\2\2\u02fe\u02ff\3\2"+
		"\2\2\u02ff\u0304\3\2\2\2\u0300\u0302\5b\62\2\u0301\u0303\7\u0105\2\2\u0302"+
		"\u0301\3\2\2\2\u0302\u0303\3\2\2\2\u0303\u0305\3\2\2\2\u0304\u0300\3\2"+
		"\2\2\u0305\u0306\3\2\2\2\u0306\u0304\3\2\2\2\u0306\u0307\3\2\2\2\u0307"+
		"\u0309\3\2\2\2\u0308\u02f8\3\2\2\2\u0308\u02fc\3\2\2\2\u0309\u030a\3\2"+
		"\2\2\u030a\u0312\7I\2\2\u030b\u030d\7a\2\2\u030c\u030b\3\2\2\2\u030c\u030d"+
		"\3\2\2\2\u030d\u030e\3\2\2\2\u030e\u0310\5\u015e\u00b0\2\u030f\u0311\7"+
		"\u0105\2\2\u0310\u030f\3\2\2\2\u0310\u0311\3\2\2\2\u0311\u0313\3\2\2\2"+
		"\u0312\u030c\3\2\2\2\u0313\u0314\3\2\2\2\u0314\u0312\3\2\2\2\u0314\u0315"+
		"\3\2\2\2\u0315\u0316\3\2\2\2\u0316\u0317\5\30\r\2\u0317\u040c\3\2\2\2"+
		"\u0318\u0325\7-\2\2\u0319\u031b\t\b\2\2\u031a\u031c\7\u0105\2\2\u031b"+
		"\u031a\3\2\2\2\u031b\u031c\3\2\2\2\u031c\u031e\3\2\2\2\u031d\u0319\3\2"+
		"\2\2\u031e\u031f\3\2\2\2\u031f\u031d\3\2\2\2\u031f\u0320\3\2\2\2\u0320"+
		"\u0326\3\2\2\2\u0321\u0323\7\5\2\2\u0322\u0324\7P\2\2\u0323\u0322\3\2"+
		"\2\2\u0323\u0324\3\2\2\2\u0324\u0326\3\2\2\2\u0325\u031d\3\2\2\2\u0325"+
		"\u0321\3\2\2\2\u0326\u0327\3\2\2\2\u0327\u033d\7I\2\2\u0328\u0329\7Z\2"+
		"\2\u0329\u032b\5b\62\2\u032a\u032c\7\u0105\2\2\u032b\u032a\3\2\2\2\u032b"+
		"\u032c\3\2\2\2\u032c\u032e\3\2\2\2\u032d\u0328\3\2\2\2\u032e\u032f\3\2"+
		"\2\2\u032f\u032d\3\2\2\2\u032f\u0330\3\2\2\2\u0330\u033e\3\2\2\2\u0331"+
		"\u0332\7\5\2\2\u0332\u0333\7[\2\2\u0333\u0334\7\63\2\2\u0334\u0339\7Y"+
		"\2\2\u0335\u0337\5b\62\2\u0336\u0338\7\u0105\2\2\u0337\u0336\3\2\2\2\u0337"+
		"\u0338\3\2\2\2\u0338\u033a\3\2\2\2\u0339\u0335\3\2\2\2\u033a\u033b\3\2"+
		"\2\2\u033b\u0339\3\2\2\2\u033b\u033c\3\2\2\2\u033c\u033e\3\2\2\2\u033d"+
		"\u032d\3\2\2\2\u033d\u0331\3\2\2\2\u033e\u033f\3\2\2\2\u033f\u0340\5\30"+
		"\r\2\u0340\u040c\3\2\2\2\u0341\u034e\7-\2\2\u0342\u0344\t\t\2\2\u0343"+
		"\u0345\7\u0105\2\2\u0344\u0343\3\2\2\2\u0344\u0345\3\2\2\2\u0345\u0347"+
		"\3\2\2\2\u0346\u0342\3\2\2\2\u0347\u0348\3\2\2\2\u0348\u0346\3\2\2\2\u0348"+
		"\u0349\3\2\2\2\u0349\u034f\3\2\2\2\u034a\u034c\7\5\2\2\u034b\u034d\7P"+
		"\2\2\u034c\u034b\3\2\2\2\u034c\u034d\3\2\2\2\u034d\u034f\3\2\2\2\u034e"+
		"\u0346\3\2\2\2\u034e\u034a\3\2\2\2\u034f\u0350\3\2\2\2\u0350\u0351\7I"+
		"\2\2\u0351\u0356\7\25\2\2\u0352\u0354\5b\62\2\u0353\u0355\7\u0105\2\2"+
		"\u0354\u0353\3\2\2\2\u0354\u0355\3\2\2\2\u0355\u0357\3\2\2\2\u0356\u0352"+
		"\3\2\2\2\u0357\u0358\3\2\2\2\u0358\u0356\3\2\2\2\u0358\u0359\3\2\2\2\u0359"+
		"\u035a\3\2\2\2\u035a\u035b\5\30\r\2\u035b\u040c\3\2\2\2\u035c\u0362\7"+
		"-\2\2\u035d\u0363\7l\2\2\u035e\u0360\7\5\2\2\u035f\u0361\7P\2\2\u0360"+
		"\u035f\3\2\2\2\u0360\u0361\3\2\2\2\u0361\u0363\3\2\2\2\u0362\u035d\3\2"+
		"\2\2\u0362\u035e\3\2\2\2\u0363\u0364\3\2\2\2\u0364\u0365\7I\2\2\u0365"+
		"\u0366\7\'\2\2\u0366\u0367\7\u0082\2\2\u0367\u036c\7\u00d5\2\2\u0368\u036a"+
		"\5b\62\2\u0369\u036b\7\u0105\2\2\u036a\u0369\3\2\2\2\u036a\u036b\3\2\2"+
		"\2\u036b\u036d\3\2\2\2\u036c\u0368\3\2\2\2\u036d\u036e\3\2\2\2\u036e\u036c"+
		"\3\2\2\2\u036e\u036f\3\2\2\2\u036f\u0370\3\2\2\2\u0370\u0371\5\30\r\2"+
		"\u0371\u040c\3\2\2\2\u0372\u0378\7-\2\2\u0373\u0379\7l\2\2\u0374\u0376"+
		"\7\5\2\2\u0375\u0377\7P\2\2\u0376\u0375\3\2\2\2\u0376\u0377\3\2\2\2\u0377"+
		"\u0379\3\2\2\2\u0378\u0373\3\2\2\2\u0378\u0374\3\2\2\2\u0379\u037a\3\2"+
		"\2\2\u037a\u037b\7I\2\2\u037b\u037c\7\'\2\2\u037c\u0381\7\u00bc\2\2\u037d"+
		"\u037f\5b\62\2\u037e\u0380\7\u0105\2\2\u037f\u037e\3\2\2\2\u037f\u0380"+
		"\3\2\2\2\u0380\u0382\3\2\2\2\u0381\u037d\3\2\2\2\u0382\u0383\3\2\2\2\u0383"+
		"\u0381\3\2\2\2\u0383\u0384\3\2\2\2\u0384\u0385\3\2\2\2\u0385\u0386\5\30"+
		"\r\2\u0386\u040c\3\2\2\2\u0387\u038d\7-\2\2\u0388\u038e\7#\2\2\u0389\u038b"+
		"\7\5\2\2\u038a\u038c\7P\2\2\u038b\u038a\3\2\2\2\u038b\u038c\3\2\2\2\u038c"+
		"\u038e\3\2\2\2\u038d\u0388\3\2\2\2\u038d\u0389\3\2\2\2\u038e\u038f\3\2"+
		"\2\2\u038f\u0392\7I\2\2\u0390\u0393\5\34\17\2\u0391\u0393\5\36\20\2\u0392"+
		"\u0390\3\2\2\2\u0392\u0391\3\2\2\2\u0393\u0394\3\2\2\2\u0394\u0395\5\30"+
		"\r\2\u0395\u040c\3\2\2\2\u0396\u039c\7-\2\2\u0397\u039d\7l\2\2\u0398\u039a"+
		"\7\5\2\2\u0399\u039b\7P\2\2\u039a\u0399\3\2\2\2\u039a\u039b\3\2\2\2\u039b"+
		"\u039d\3\2\2\2\u039c\u0397\3\2\2\2\u039c\u0398\3\2\2\2\u039d\u039e\3\2"+
		"\2\2\u039e\u039f\7I\2\2\u039f\u03a4\7\u009b\2\2\u03a0\u03a2\5b\62\2\u03a1"+
		"\u03a3\7\u0105\2\2\u03a2\u03a1\3\2\2\2\u03a2\u03a3\3\2\2\2\u03a3\u03a5"+
		"\3\2\2\2\u03a4\u03a0\3\2\2\2\u03a5\u03a6\3\2\2\2\u03a6\u03a4\3\2\2\2\u03a6"+
		"\u03a7\3\2\2\2\u03a7\u03a8\3\2\2\2\u03a8\u03a9\5\30\r\2\u03a9\u040c\3"+
		"\2\2\2\u03aa\u03b7\7-\2\2\u03ab\u03ad\t\n\2\2\u03ac\u03ae\7\u0105\2\2"+
		"\u03ad\u03ac\3\2\2\2\u03ad\u03ae\3\2\2\2\u03ae\u03b0\3\2\2\2\u03af\u03ab"+
		"\3\2\2\2\u03b0\u03b1\3\2\2\2\u03b1\u03af\3\2\2\2\u03b1\u03b2\3\2\2\2\u03b2"+
		"\u03b8\3\2\2\2\u03b3\u03b5\7\5\2\2\u03b4\u03b6\7P\2\2\u03b5\u03b4\3\2"+
		"\2\2\u03b5\u03b6\3\2\2\2\u03b6\u03b8\3\2\2\2\u03b7\u03af\3\2\2\2\u03b7"+
		"\u03b3\3\2\2\2\u03b8\u03b9\3\2\2\2\u03b9\u03ba\7I\2\2\u03ba\u03bb\7\u009c"+
		"\2\2\u03bb\u03c0\7\u00ac\2\2\u03bc\u03be\5b\62\2\u03bd\u03bf\7\u0105\2"+
		"\2\u03be\u03bd\3\2\2\2\u03be\u03bf\3\2\2\2\u03bf\u03c1\3\2\2\2\u03c0\u03bc"+
		"\3\2\2\2\u03c1\u03c2\3\2\2\2\u03c2\u03c0\3\2\2\2\u03c2\u03c3\3\2\2\2\u03c3"+
		"\u03c4\3\2\2\2\u03c4\u03c5\5\30\r\2\u03c5\u040c\3\2\2\2\u03c6\u03d3\7"+
		"-\2\2\u03c7\u03c9\t\5\2\2\u03c8\u03ca\7\u0105\2\2\u03c9\u03c8\3\2\2\2"+
		"\u03c9\u03ca\3\2\2\2\u03ca\u03cc\3\2\2\2\u03cb\u03c7\3\2\2\2\u03cc\u03cd"+
		"\3\2\2\2\u03cd\u03cb\3\2\2\2\u03cd\u03ce\3\2\2\2\u03ce\u03d4\3\2\2\2\u03cf"+
		"\u03d1\7\5\2\2\u03d0\u03d2\7P\2\2\u03d1\u03d0\3\2\2\2\u03d1\u03d2\3\2"+
		"\2\2\u03d2\u03d4\3\2\2\2\u03d3\u03cb\3\2\2\2\u03d3\u03cf\3\2\2\2\u03d4"+
		"\u03d5\3\2\2\2\u03d5\u03d6\7I\2\2\u03d6\u03db\7Y\2\2\u03d7\u03d9\5b\62"+
		"\2\u03d8\u03da\7\u0105\2\2\u03d9\u03d8\3\2\2\2\u03d9\u03da\3\2\2\2\u03da"+
		"\u03dc\3\2\2\2\u03db\u03d7\3\2\2\2\u03dc\u03dd\3\2\2\2\u03dd\u03db\3\2"+
		"\2\2\u03dd\u03de\3\2\2\2\u03de\u03df\3\2\2\2\u03df\u03e0\5\30\r\2\u03e0"+
		"\u040c\3\2\2\2\u03e1\u03e7\7-\2\2\u03e2\u03e8\7\23\2\2\u03e3\u03e5\7\5"+
		"\2\2\u03e4\u03e6\7P\2\2\u03e5\u03e4\3\2\2\2\u03e5\u03e6\3\2\2\2\u03e6"+
		"\u03e8\3\2\2\2\u03e7\u03e2\3\2\2\2\u03e7\u03e3\3\2\2\2\u03e8\u03e9\3\2"+
		"\2\2\u03e9\u03ea\7I\2\2\u03ea\u03ef\7\u00c5\2\2\u03eb\u03ed\5b\62\2\u03ec"+
		"\u03ee\7\u0105\2\2\u03ed\u03ec\3\2\2\2\u03ed\u03ee\3\2\2\2\u03ee\u03f0"+
		"\3\2\2\2\u03ef\u03eb\3\2\2\2\u03f0\u03f1\3\2\2\2\u03f1\u03ef\3\2\2\2\u03f1"+
		"\u03f2\3\2\2\2\u03f2\u03f3\3\2\2\2\u03f3\u03f4\5\30\r\2\u03f4\u03f9\7"+
		"-\2\2\u03f5\u03f7\5b\62\2\u03f6\u03f8\7\u0105\2\2\u03f7\u03f6\3\2\2\2"+
		"\u03f7\u03f8\3\2\2\2\u03f8\u03fa\3\2\2\2\u03f9\u03f5\3\2\2\2\u03fa\u03fb"+
		"\3\2\2\2\u03fb\u03f9\3\2\2\2\u03fb\u03fc\3\2\2\2\u03fc\u03fd\3\2\2\2\u03fd"+
		"\u0402\7\u00cc\2\2\u03fe\u0400\5b\62\2\u03ff\u0401\7\u0105\2\2\u0400\u03ff"+
		"\3\2\2\2\u0400\u0401\3\2\2\2\u0401\u0403\3\2\2\2\u0402\u03fe\3\2\2\2\u0403"+
		"\u0404\3\2\2\2\u0404\u0402\3\2\2\2\u0404\u0405\3\2\2\2\u0405\u0409\3\2"+
		"\2\2\u0406\u0407\7q\2\2\u0407\u0408\7s\2\2\u0408\u040a\7\u00ad\2\2\u0409"+
		"\u0406\3\2\2\2\u0409\u040a\3\2\2\2\u040a\u040c\3\2\2\2\u040b\u02c6\3\2"+
		"\2\2\u040b\u02ee\3\2\2\2\u040b\u0318\3\2\2\2\u040b\u0341\3\2\2\2\u040b"+
		"\u035c\3\2\2\2\u040b\u0372\3\2\2\2\u040b\u0387\3\2\2\2\u040b\u0396\3\2"+
		"\2\2\u040b\u03aa\3\2\2\2\u040b\u03c6\3\2\2\2\u040b\u03e1\3\2\2\2\u040c"+
		"\27\3\2\2\2\u040d\u0418\7\u00cc\2\2\u040e\u0410\7.\2\2\u040f\u040e\3\2"+
		"\2\2\u040f\u0410\3\2\2\2\u0410\u0413\3\2\2\2\u0411\u0414\5b\62\2\u0412"+
		"\u0414\7\u00b4\2\2\u0413\u0411\3\2\2\2\u0413\u0412\3\2\2\2\u0414\u0416"+
		"\3\2\2\2\u0415\u0417\7\u0105\2\2\u0416\u0415\3\2\2\2\u0416\u0417\3\2\2"+
		"\2\u0417\u0419\3\2\2\2\u0418\u040f\3\2\2\2\u0419\u041a\3\2\2\2\u041a\u0418"+
		"\3\2\2\2\u041a\u041b\3\2\2\2\u041b\u041f\3\2\2\2\u041c\u041d\7q\2\2\u041d"+
		"\u041e\7-\2\2\u041e\u0420\7\u00ad\2\2\u041f\u041c\3\2\2\2\u041f\u0420"+
		"\3\2\2\2\u0420\31\3\2\2\2\u0421\u0422\t\13\2\2\u0422\33\3\2\2\2\u0423"+
		"\u0424\7)\2\2\u0424\u0425\5b\62\2\u0425\u0432\7\u010c\2\2\u0426\u0428"+
		"\5\32\16\2\u0427\u0426\3\2\2\2\u0427\u0428\3\2\2\2\u0428\u042a\3\2\2\2"+
		"\u0429\u042b\5b\62\2\u042a\u0429\3\2\2\2\u042a\u042b\3\2\2\2\u042b\u042c"+
		"\3\2\2\2\u042c\u042e\5t;\2\u042d\u042f\7\u0105\2\2\u042e\u042d\3\2\2\2"+
		"\u042e\u042f\3\2\2\2\u042f\u0431\3\2\2\2\u0430\u0427\3\2\2\2\u0431\u0434"+
		"\3\2\2\2\u0432\u0430\3\2\2\2\u0432\u0433\3\2\2\2\u0433\u0435\3\2\2\2\u0434"+
		"\u0432\3\2\2\2\u0435\u0436\7\u010d\2\2\u0436\35\3\2\2\2\u0437\u0438\7"+
		"\5\2\2\u0438\u0439\7*\2\2\u0439\u043a\7\63\2\2\u043a\u043f\7Y\2\2\u043b"+
		"\u043d\5b\62\2\u043c\u043e\7\u0105\2\2\u043d\u043c\3\2\2\2\u043d\u043e"+
		"\3\2\2\2\u043e\u0440\3\2\2\2\u043f\u043b\3\2\2\2\u0440\u0441\3\2\2\2\u0441"+
		"\u043f\3\2\2\2\u0441\u0442\3\2\2\2\u0442\37\3\2\2\2\u0443\u0444\7\23\2"+
		"\2\u0444\u0445\7\u008c\2\2\u0445\u0446\7a\2\2\u0446\u0447\5\u015e\u00b0"+
		"\2\u0447\u0448\5\66\34\2\u0448\u0449\7m\2\2\u0449\u044b\5b\62\2\u044a"+
		"\u044c\5<\37\2\u044b\u044a\3\2\2\2\u044b\u044c\3\2\2\2\u044c\u044e\3\2"+
		"\2\2\u044d\u044f\5F$\2\u044e\u044d\3\2\2\2\u044e\u044f\3\2\2\2\u044f\u0450"+
		"\3\2\2\2\u0450\u0451\7\u00a0\2\2\u0451\u0452\7\u011d\2\2\u0452\u04e6\3"+
		"\2\2\2\u0453\u0454\7\23\2\2\u0454\u0455\7a\2\2\u0455\u0456\5\u015e\u00b0"+
		"\2\u0456\u0459\5\66\34\2\u0457\u0458\7m\2\2\u0458\u045a\5b\62\2\u0459"+
		"\u0457\3\2\2\2\u0459\u045a\3\2\2\2\u045a\u045c\3\2\2\2\u045b\u045d\5<"+
		"\37\2\u045c\u045b\3\2\2\2\u045c\u045d\3\2\2\2\u045d\u045f\3\2\2\2\u045e"+
		"\u0460\5F$\2\u045f\u045e\3\2\2\2\u045f\u0460\3\2\2\2\u0460\u0463\3\2\2"+
		"\2\u0461\u0462\7\4\2\2\u0462\u0464\5\u014a\u00a6\2\u0463\u0461\3\2\2\2"+
		"\u0463\u0464\3\2\2\2\u0464\u04e6\3\2\2\2\u0465\u0466\7\23\2\2\u0466\u0467"+
		"\7a\2\2\u0467\u046a\5\u015e\u00b0\2\u0468\u0469\7m\2\2\u0469\u046b\5b"+
		"\62\2\u046a\u0468\3\2\2\2\u046a\u046b\3\2\2\2\u046b\u046d\3\2\2\2\u046c"+
		"\u046e\5<\37\2\u046d\u046c\3\2\2\2\u046d\u046e\3\2\2\2\u046e\u0470\3\2"+
		"\2\2\u046f\u0471\5F$\2\u0470\u046f\3\2\2\2\u0470\u0471\3\2\2\2\u0471\u0472"+
		"\3\2\2\2\u0472\u0473\7\4\2\2\u0473\u0474\5\u014a\u00a6\2\u0474\u04e6\3"+
		"\2\2\2\u0475\u047b\7\23\2\2\u0476\u0478\t\f\2\2\u0477\u0476\3\2\2\2\u0477"+
		"\u0478\3\2\2\2\u0478\u0479\3\2\2\2\u0479\u047c\t\r\2\2\u047a\u047c\7\u00ce"+
		"\2\2\u047b\u0477\3\2\2\2\u047b\u047a\3\2\2\2\u047b\u047c\3\2\2\2\u047c"+
		"\u047d\3\2\2\2\u047d\u0481\7a\2\2\u047e\u047f\7\60\2\2\u047f\u0480\7E"+
		"\2\2\u0480\u0482\7\u008b\2\2\u0481\u047e\3\2\2\2\u0481\u0482\3\2\2\2\u0482"+
		"\u0483\3\2\2\2\u0483\u0484\5\u015e\u00b0\2\u0484\u04a3\7\u010c\2\2\u0485"+
		"\u0486\5b\62\2\u0486\u0489\5t;\2\u0487\u0488\7\17\2\2\u0488\u048a\5b\62"+
		"\2\u0489\u0487\3\2\2\2\u0489\u048a\3\2\2\2\u048a\u048e\3\2\2\2\u048b\u048d"+
		"\5&\24\2\u048c\u048b\3\2\2\2\u048d\u0490\3\2\2\2\u048e\u048c\3\2\2\2\u048e"+
		"\u048f\3\2\2\2\u048f\u049b\3\2\2\2\u0490\u048e\3\2\2\2\u0491\u049b\5$"+
		"\23\2\u0492\u0493\7A\2\2\u0493\u0497\5b\62\2\u0494\u0496\5\"\22\2\u0495"+
		"\u0494\3\2\2\2\u0496\u0499\3\2\2\2\u0497\u0495\3\2\2\2\u0497\u0498\3\2"+
		"\2\2\u0498\u049b\3\2\2\2\u0499\u0497\3\2\2\2\u049a\u0485\3\2\2\2\u049a"+
		"\u0491\3\2\2\2\u049a\u0492\3\2\2\2\u049b\u049d\3\2\2\2\u049c\u049e\7\u0105"+
		"\2\2\u049d\u049c\3\2\2\2\u049d\u049e\3\2\2\2\u049e\u04a0\3\2\2\2\u049f"+
		"\u049a\3\2\2\2\u04a0\u04a1\3\2\2\2\u04a1\u049f\3\2\2\2\u04a1\u04a2\3\2"+
		"\2\2\u04a2\u04a4\3\2\2\2\u04a3\u049f\3\2\2\2\u04a3\u04a4\3\2\2\2\u04a4"+
		"\u04a5\3\2\2\2\u04a5\u04b2\7\u010d\2\2\u04a6\u04a7\7\65\2\2\u04a7\u04ac"+
		"\7\u010c\2\2\u04a8\u04aa\5b\62\2\u04a9\u04ab\7\u0105\2\2\u04aa\u04a9\3"+
		"\2\2\2\u04aa\u04ab\3\2\2\2\u04ab\u04ad\3\2\2\2\u04ac\u04a8\3\2\2\2\u04ad"+
		"\u04ae\3\2\2\2\u04ae\u04ac\3\2\2\2\u04ae\u04af\3\2\2\2\u04af\u04b0\3\2"+
		"\2\2\u04b0\u04b1\7\u010d\2\2\u04b1\u04b3\3\2\2\2\u04b2\u04a6\3\2\2\2\u04b2"+
		"\u04b3\3\2\2\2\u04b3\u04b4\3\2\2\2\u04b4\u04b5\5,\27\2\u04b5\u04b6\5."+
		"\30\2\u04b6\u04b7\5\60\31\2\u04b7\u04e6\3\2\2\2\u04b8\u04be\7\23\2\2\u04b9"+
		"\u04bb\t\f\2\2\u04ba\u04b9\3\2\2\2\u04ba\u04bb\3\2\2\2\u04bb\u04bc\3\2"+
		"\2\2\u04bc\u04bf\t\r\2\2\u04bd\u04bf\7\u00ce\2\2\u04be\u04ba\3\2\2\2\u04be"+
		"\u04bd\3\2\2\2\u04be\u04bf\3\2\2\2\u04bf\u04c0\3\2\2\2\u04c0\u04c4\7a"+
		"\2\2\u04c1\u04c2\7\60\2\2\u04c2\u04c3\7E\2\2\u04c3\u04c5\7\u008b\2\2\u04c4"+
		"\u04c1\3\2\2\2\u04c4\u04c5\3\2\2\2\u04c5\u04c6\3\2\2\2\u04c6\u04c7\5\u015e"+
		"\u00b0\2\u04c7\u04c8\7G\2\2\u04c8\u04df\5b\62\2\u04c9\u04d9\7\u010c\2"+
		"\2\u04ca\u04cb\5b\62\2\u04cb\u04cc\7q\2\2\u04cc\u04d0\7\u00ae\2\2\u04cd"+
		"\u04cf\5&\24\2\u04ce\u04cd\3\2\2\2\u04cf\u04d2\3\2\2\2\u04d0\u04ce\3\2"+
		"\2\2\u04d0\u04d1\3\2\2\2\u04d1\u04d5\3\2\2\2\u04d2\u04d0\3\2\2\2\u04d3"+
		"\u04d5\5$\23\2\u04d4\u04ca\3\2\2\2\u04d4\u04d3\3\2\2\2\u04d5\u04d7\3\2"+
		"\2\2\u04d6\u04d8\7\u0105\2\2\u04d7\u04d6\3\2\2\2\u04d7\u04d8\3\2\2\2\u04d8"+
		"\u04da\3\2\2\2\u04d9\u04d4\3\2\2\2\u04da\u04db\3\2\2\2\u04db\u04d9\3\2"+
		"\2\2\u04db\u04dc\3\2\2\2\u04dc\u04dd\3\2\2\2\u04dd\u04de\7\u010d\2\2\u04de"+
		"\u04e0\3\2\2\2\u04df\u04c9\3\2\2\2\u04df\u04e0\3\2\2\2\u04e0\u04e1\3\2"+
		"\2\2\u04e1\u04e2\5,\27\2\u04e2\u04e3\5.\30\2\u04e3\u04e4\5\60\31\2\u04e4"+
		"\u04e6\3\2\2\2\u04e5\u0443\3\2\2\2\u04e5\u0453\3\2\2\2\u04e5\u0465\3\2"+
		"\2\2\u04e5\u0475\3\2\2\2\u04e5\u04b8\3\2\2\2\u04e6!\3\2\2\2\u04e7\u04e8"+
		"\t\16\2\2\u04e8\u04e9\t\17\2\2\u04e9#\3\2\2\2\u04ea\u04eb\7\21\2\2\u04eb"+
		"\u04ed\5b\62\2\u04ec\u04ea\3\2\2\2\u04ec\u04ed\3\2\2\2\u04ed\u0550\3\2"+
		"\2\2\u04ee\u0551\5(\25\2\u04ef\u04f0\7j\2\2\u04f0\u04f5\7\u010c\2\2\u04f1"+
		"\u04f3\5b\62\2\u04f2\u04f4\7\u0105\2\2\u04f3\u04f2\3\2\2\2\u04f3\u04f4"+
		"\3\2\2\2\u04f4\u04f6\3\2\2\2\u04f5\u04f1\3\2\2\2\u04f6\u04f7\3\2\2\2\u04f7"+
		"\u04f5\3\2\2\2\u04f7\u04f8\3\2\2\2\u04f8\u04f9\3\2\2\2\u04f9\u04fa\7\u010d"+
		"\2\2\u04fa\u04fb\5\64\33\2\u04fb\u0551\3\2\2\2\u04fc\u04fd\7O\2\2\u04fd"+
		"\u04fe\7>\2\2\u04fe\u0503\7\u010c\2\2\u04ff\u0501\5b\62\2\u0500\u0502"+
		"\7\u0105\2\2\u0501\u0500\3\2\2\2\u0501\u0502\3\2\2\2\u0502\u0504\3\2\2"+
		"\2\u0503\u04ff\3\2\2\2\u0504\u0505\3\2\2\2\u0505\u0503\3\2\2\2\u0505\u0506"+
		"\3\2\2\2\u0506\u0507\3\2\2\2\u0507\u0508\7\u010d\2\2\u0508\u0509\5\64"+
		"\33\2\u0509\u0551\3\2\2\2\u050a\u050d\7!\2\2\u050b\u050c\7m\2\2\u050c"+
		"\u050e\5b\62\2\u050d\u050b\3\2\2\2\u050d\u050e\3\2\2\2\u050e\u050f\3\2"+
		"\2\2\u050f\u0510\7\u010c\2\2\u0510\u0511\5b\62\2\u0511\u0516\7q\2\2\u0512"+
		"\u0514\5b\62\2\u0513\u0515\7\u0105\2\2\u0514\u0513\3\2\2\2\u0514\u0515"+
		"\3\2\2\2\u0515\u0517\3\2\2\2\u0516\u0512\3\2\2\2\u0517\u0518\3\2\2\2\u0518"+
		"\u0516\3\2\2\2\u0518\u0519\3\2\2\2\u0519\u051a\3\2\2\2\u051a\u051b\7\u010d"+
		"\2\2\u051b\u0521\5\64\33\2\u051c\u051d\7p\2\2\u051d\u051e\7\u010c\2\2"+
		"\u051e\u051f\5b\62\2\u051f\u0520\7\u010d\2\2\u0520\u0522\3\2\2\2\u0521"+
		"\u051c\3\2\2\2\u0521\u0522\3\2\2\2\u0522\u0551\3\2\2\2\u0523\u0524\7\'"+
		"\2\2\u0524\u0525\7>\2\2\u0525\u052a\7\u010c\2\2\u0526\u0528\5b\62\2\u0527"+
		"\u0529\7\u0105\2\2\u0528\u0527\3\2\2\2\u0528\u0529\3\2\2\2\u0529\u052b"+
		"\3\2\2\2\u052a\u0526\3\2\2\2\u052b\u052c\3\2\2\2\u052c\u052a\3\2\2\2\u052c"+
		"\u052d\3\2\2\2\u052d\u052e\3\2\2\2\u052e\u052f\7\u010d\2\2\u052f\u0530"+
		"\7T\2\2\u0530\u053c\5b\62\2\u0531\u0536\7\u010c\2\2\u0532\u0534\5b\62"+
		"\2\u0533\u0535\7\u0105\2\2\u0534\u0533\3\2\2\2\u0534\u0535\3\2\2\2\u0535"+
		"\u0537\3\2\2\2\u0536\u0532\3\2\2\2\u0537\u0538\3\2\2\2\u0538\u0536\3\2"+
		"\2\2\u0538\u0539\3\2\2\2\u0539\u053a\3\2\2\2\u053a\u053b\7\u010d\2\2\u053b"+
		"\u053d\3\2\2\2\u053c\u0531\3\2\2\2\u053c\u053d\3\2\2\2\u053d\u0544\3\2"+
		"\2\2\u053e\u053f\7\u00a1\2\2\u053f\u0545\7(\2\2\u0540\u0541\7\u00a1\2"+
		"\2\u0541\u0545\7\u00b0\2\2\u0542\u0543\7\u00a1\2\2\u0543\u0545\7\u00bf"+
		"\2\2\u0544\u053e\3\2\2\2\u0544\u0540\3\2\2\2\u0544\u0542\3\2\2\2\u0544"+
		"\u0545\3\2\2\2\u0545\u0549\3\2\2\2\u0546\u0547\7I\2\2\u0547\u0548\7\32"+
		"\2\2\u0548\u054a\5\62\32\2\u0549\u0546\3\2\2\2\u0549\u054a\3\2\2\2\u054a"+
		"\u054e\3\2\2\2\u054b\u054c\7I\2\2\u054c\u054d\7k\2\2\u054d\u054f\5\62"+
		"\32\2\u054e\u054b\3\2\2\2\u054e\u054f\3\2\2\2\u054f\u0551\3\2\2\2\u0550"+
		"\u04ee\3\2\2\2\u0550\u04ef\3\2\2\2\u0550\u04fc\3\2\2\2\u0550\u050a\3\2"+
		"\2\2\u0550\u0523\3\2\2\2\u0551\u0555\3\2\2\2\u0552\u0556\7\30\2\2\u0553"+
		"\u0554\7E\2\2\u0554\u0556\7\30\2\2\u0555\u0552\3\2\2\2\u0555\u0553\3\2"+
		"\2\2\u0555\u0556\3\2\2\2\u0556\u055b\3\2\2\2\u0557\u0558\7\66\2\2\u0558"+
		"\u055c\7\31\2\2\u0559\u055a\7\66\2\2\u055a\u055c\7\62\2\2\u055b\u0557"+
		"\3\2\2\2\u055b\u0559\3\2\2\2\u055b\u055c\3\2\2\2\u055c%\3\2\2\2\u055d"+
		"\u055e\7\21\2\2\u055e\u0560\5b\62\2\u055f\u055d\3\2\2\2\u055f\u0560\3"+
		"\2\2\2\u0560\u0581\3\2\2\2\u0561\u0562\7E\2\2\u0562\u0582\7F\2\2\u0563"+
		"\u0582\7F\2\2\u0564\u0582\5(\25\2\u0565\u0566\7\26\2\2\u0566\u0582\5\u01a6"+
		"\u00d4\2\u0567\u0568\7j\2\2\u0568\u0582\5\64\33\2\u0569\u056a\7O\2\2\u056a"+
		"\u056b\7>\2\2\u056b\u0582\5\64\33\2\u056c\u056d\7T\2\2\u056d\u056e\5\u015e"+
		"\u00b0\2\u056e\u0575\5b\62\2\u056f\u0570\7\u00a1\2\2\u0570\u0576\7(\2"+
		"\2\u0571\u0572\7\u00a1\2\2\u0572\u0576\7\u00b0\2\2\u0573\u0574\7\u00a1"+
		"\2\2\u0574\u0576\7\u00bf\2\2\u0575\u056f\3\2\2\2\u0575\u0571\3\2\2\2\u0575"+
		"\u0573\3\2\2\2\u0575\u0576\3\2\2\2\u0576\u057a\3\2\2\2\u0577\u0578\7I"+
		"\2\2\u0578\u0579\7\32\2\2\u0579\u057b\5\62\32\2\u057a\u0577\3\2\2\2\u057a"+
		"\u057b\3\2\2\2\u057b\u057f\3\2\2\2\u057c\u057d\7I\2\2\u057d\u057e\7k\2"+
		"\2\u057e\u0580\5\62\32\2\u057f\u057c\3\2\2\2\u057f\u0580\3\2\2\2\u0580"+
		"\u0582\3\2\2\2\u0581\u0561\3\2\2\2\u0581\u0563\3\2\2\2\u0581\u0564\3\2"+
		"\2\2\u0581\u0565\3\2\2\2\u0581\u0567\3\2\2\2\u0581\u0569\3\2\2\2\u0581"+
		"\u056c\3\2\2\2\u0582\u0586\3\2\2\2\u0583\u0587\7\30\2\2\u0584\u0585\7"+
		"E\2\2\u0585\u0587\7\30\2\2\u0586\u0583\3\2\2\2\u0586\u0584\3\2\2\2\u0586"+
		"\u0587\3\2\2\2\u0587\u058c\3\2\2\2\u0588\u0589\7\66\2\2\u0589\u058d\7"+
		"\31\2\2\u058a\u058b\7\66\2\2\u058b\u058d\7\62\2\2\u058c\u0588\3\2\2\2"+
		"\u058c\u058a\3\2\2\2\u058c\u058d\3\2\2\2\u058d\'\3\2\2\2\u058e\u058f\7"+
		"y\2\2\u058f\u0590\7\u010c\2\2\u0590\u0591\5\u00eex\2\u0591\u0592\7\u010d"+
		"\2\2\u0592)\3\2\2\2\u0593\u0594\7q\2\2\u0594\u059d\7\u010c\2\2\u0595\u0598"+
		"\5b\62\2\u0596\u0597\7\u0102\2\2\u0597\u0599\5b\62\2\u0598\u0596\3\2\2"+
		"\2\u0598\u0599\3\2\2\2\u0599\u059b\3\2\2\2\u059a\u059c\7\u0105\2\2\u059b"+
		"\u059a\3\2\2\2\u059b\u059c\3\2\2\2\u059c\u059e\3\2\2\2\u059d\u0595\3\2"+
		"\2\2\u059e\u059f\3\2\2\2\u059f\u059d\3\2\2\2\u059f\u05a0\3\2\2\2\u05a0"+
		"\u05a1\3\2\2\2\u05a1\u05a2\7\u010d\2\2\u05a2+\3\2\2\2\u05a3\u05a9\5*\26"+
		"\2\u05a4\u05a5\7q\2\2\u05a5\u05a9\7H\2\2\u05a6\u05a7\7r\2\2\u05a7\u05a9"+
		"\7H\2\2\u05a8\u05a3\3\2\2\2\u05a8\u05a4\3\2\2\2\u05a8\u05a6\3\2\2\2\u05a8"+
		"\u05a9\3\2\2\2\u05a9-\3\2\2\2\u05aa\u05ab\7I\2\2\u05ab\u05b1\7\177\2\2"+
		"\u05ac\u05ad\7N\2\2\u05ad\u05b2\7S\2\2\u05ae\u05af\7\32\2\2\u05af\u05b2"+
		"\7S\2\2\u05b0\u05b2\7\u0088\2\2\u05b1\u05ac\3\2\2\2\u05b1\u05ae\3\2\2"+
		"\2\u05b1\u05b0\3\2\2\2\u05b2\u05b4\3\2\2\2\u05b3\u05aa\3\2\2\2\u05b3\u05b4"+
		"\3\2\2\2\u05b4/\3\2\2\2\u05b5\u05b6\7\u00c5\2\2\u05b6\u05b8\5b\62\2\u05b7"+
		"\u05b5\3\2\2\2\u05b7\u05b8\3\2\2\2\u05b8\61\3\2\2\2\u05b9\u05c0\7V\2\2"+
		"\u05ba\u05c0\7\r\2\2\u05bb\u05bc\7\u00bd\2\2\u05bc\u05c0\7F\2\2\u05bd"+
		"\u05be\7\u00bd\2\2\u05be\u05c0\7\26\2\2\u05bf\u05b9\3\2\2\2\u05bf\u05ba"+
		"\3\2\2\2\u05bf\u05bb\3\2\2\2\u05bf\u05bd\3\2\2\2\u05c0\63\3\2\2\2\u05c1"+
		"\u05c3\5*\26\2\u05c2\u05c1\3\2\2\2\u05c2\u05c3\3\2\2\2\u05c3\u05c8\3\2"+
		"\2\2\u05c4\u05c5\7m\2\2\u05c5\u05c6\7\u0095\2\2\u05c6\u05c7\7\u00c5\2"+
		"\2\u05c7\u05c9\5b\62\2\u05c8\u05c4\3\2\2\2\u05c8\u05c9\3\2\2\2\u05c9\65"+
		"\3\2\2\2\u05ca\u05cb\7\u010c\2\2\u05cb\u05d0\58\35\2\u05cc\u05cd\7\u0105"+
		"\2\2\u05cd\u05cf\58\35\2\u05ce\u05cc\3\2\2\2\u05cf\u05d2\3\2\2\2\u05d0"+
		"\u05ce\3\2\2\2\u05d0\u05d1\3\2\2\2\u05d1\u05d3\3\2\2\2\u05d2\u05d0\3\2"+
		"\2\2\u05d3\u05d4\7\u010d\2\2\u05d4\67\3\2\2\2\u05d5\u05d6\5b\62\2\u05d6"+
		"\u05d7\5:\36\2\u05d79\3\2\2\2\u05d8\u05d9\5t;\2\u05d9;\3\2\2\2\u05da\u05db"+
		"\7q\2\2\u05db\u05dc\7\u010c\2\2\u05dc\u05e1\5> \2\u05dd\u05de\7\u0105"+
		"\2\2\u05de\u05e0\5> \2\u05df\u05dd\3\2\2\2\u05e0\u05e3\3\2\2\2\u05e1\u05df"+
		"\3\2\2\2\u05e1\u05e2\3\2\2\2\u05e2\u05e4\3\2\2\2\u05e3\u05e1\3\2\2\2\u05e4"+
		"\u05e5\7\u010d\2\2\u05e5=\3\2\2\2\u05e6\u05e7\7\u011d\2\2\u05e7\u05e8"+
		"\7\u0102\2\2\u05e8\u05e9\5\u00c8e\2\u05e9?\3\2\2\2\u05ea\u05eb\7m\2\2"+
		"\u05eb\u05ec\5b\62\2\u05ecA\3\2\2\2\u05ed\u05ee\7\u00c5\2\2\u05ee\u05ef"+
		"\5D#\2\u05efC\3\2\2\2\u05f0\u05f1\5b\62\2\u05f1E\3\2\2\2\u05f2\u05f7\5"+
		"H%\2\u05f3\u05f7\5N(\2\u05f4\u05f7\5V,\2\u05f5\u05f7\5\\/\2\u05f6\u05f2"+
		"\3\2\2\2\u05f6\u05f3\3\2\2\2\u05f6\u05f4\3\2\2\2\u05f6\u05f5\3\2\2\2\u05f7"+
		"G\3\2\2\2\u05f8\u05f9\7\u00b1\2\2\u05f9\u05fa\7v\2\2\u05fa\u05fb\7\u00b7"+
		"\2\2\u05fb\u05fc\7\u010c\2\2\u05fc\u05fd\5\u0170\u00b9\2\u05fd\u05fe\7"+
		"\u010d\2\2\u05fe\u05ff\7\u010c\2\2\u05ff\u0600\5J&\2\u0600\u0601\7\u010d"+
		"\2\2\u0601I\3\2\2\2\u0602\u0607\5L\'\2\u0603\u0604\7\u0105\2\2\u0604\u0606"+
		"\5L\'\2\u0605\u0603\3\2\2\2\u0606\u0609\3\2\2\2\u0607\u0605\3\2\2\2\u0607"+
		"\u0608\3\2\2\2\u0608K\3\2\2\2\u0609\u0607\3\2\2\2\u060a\u060b\7\u00b1"+
		"\2\2\u060b\u060c\5^\60\2\u060c\u060d\7\u00cf\2\2\u060d\u060e\7\u009e\2"+
		"\2\u060e\u061a\7\u00c7\2\2\u060f\u0610\7\u010c\2\2\u0610\u0611\5\u00c4"+
		"c\2\u0611\u0612\7\u010d\2\2\u0612\u061b\3\2\2\2\u0613\u0615\7\u010c\2"+
		"\2\u0614\u0613\3\2\2\2\u0614\u0615\3\2\2\2\u0615\u0616\3\2\2\2\u0616\u0618"+
		"\7\u00a3\2\2\u0617\u0619\7\u010d\2\2\u0618\u0617\3\2\2\2\u0618\u0619\3"+
		"\2\2\2\u0619\u061b\3\2\2\2\u061a\u060f\3\2\2\2\u061a\u0614\3\2\2\2\u061b"+
		"M\3\2\2\2\u061c\u061d\7\u00b1\2\2\u061d\u061e\7v\2\2\u061e\u061f\7\u0093"+
		"\2\2\u061f\u0620\7\u010c\2\2\u0620\u0621\5\u0170\u00b9\2\u0621\u0627\7"+
		"\u010d\2\2\u0622\u0623\7\u010c\2\2\u0623\u0624\5P)\2\u0624\u0625\7\u010d"+
		"\2\2\u0625\u0628\3\2\2\2\u0626\u0628\5T+\2\u0627\u0622\3\2\2\2\u0627\u0626"+
		"\3\2\2\2\u0628O\3\2\2\2\u0629\u062e\5R*\2\u062a\u062b\7\u0105\2\2\u062b"+
		"\u062d\5R*\2\u062c\u062a\3\2\2\2\u062d\u0630\3\2\2\2\u062e\u062c\3\2\2"+
		"\2\u062e\u062f\3\2\2\2\u062fQ\3\2\2\2\u0630\u062e\3\2\2\2\u0631\u0632"+
		"\7\u00b1\2\2\u0632\u0633\5^\60\2\u0633S\3\2\2\2\u0634\u0635\7\u00b2\2"+
		"\2\u0635\u0636\5\u00c8e\2\u0636U\3\2\2\2\u0637\u0638\7\u00b1\2\2\u0638"+
		"\u0639\7v\2\2\u0639\u063a\7\u009f\2\2\u063a\u063b\7\u010c\2\2\u063b\u063c"+
		"\5\u0170\u00b9\2\u063c\u063d\7\u010d\2\2\u063d\u063e\7\u010c\2\2\u063e"+
		"\u063f\5X-\2\u063f\u0640\7\u010d\2\2\u0640W\3\2\2\2\u0641\u0646\5Z.\2"+
		"\u0642\u0643\7\u0105\2\2\u0643\u0645\5Z.\2\u0644\u0642\3\2\2\2\u0645\u0648"+
		"\3\2\2\2\u0646\u0644\3\2\2\2\u0646\u0647\3\2\2\2\u0647Y\3\2\2\2\u0648"+
		"\u0646\3\2\2\2\u0649\u064a\7\u00b1\2\2\u064a\u064b\5^\60\2\u064b\u064d"+
		"\7\u00cf\2\2\u064c\u064e\7\63\2\2\u064d\u064c\3\2\2\2\u064d\u064e\3\2"+
		"\2\2\u064e\u064f\3\2\2\2\u064f\u0650\7\u010c\2\2\u0650\u0651\5\u0188\u00c5"+
		"\2\u0651\u0652\7\u010d\2\2\u0652[\3\2\2\2\u0653\u0654\7\u00b1\2\2\u0654"+
		"\u0655\7v\2\2\u0655\u0656\7|\2\2\u0656\u0657\5\66\34\2\u0657]\3\2\2\2"+
		"\u0658\u0659\5b\62\2\u0659_\3\2\2\2\u065a\u065b\7\u0088\2\2\u065b\u065c"+
		"\7a\2\2\u065c\u065e\5\u015e\u00b0\2\u065d\u065f\7\u00b5\2\2\u065e\u065d"+
		"\3\2\2\2\u065e\u065f\3\2\2\2\u065fa\3\2\2\2\u0660\u0662\7\u0116\2\2\u0661"+
		"\u0660\3\2\2\2\u0661\u0662\3\2\2\2\u0662\u0663\3\2\2\2\u0663\u0665\7\u011c"+
		"\2\2\u0664\u0666\7\u0116\2\2\u0665\u0664\3\2\2\2\u0665\u0666\3\2\2\2\u0666"+
		"\u0669\3\2\2\2\u0667\u0669\5d\63\2\u0668\u0661\3\2\2\2\u0668\u0667\3\2"+
		"\2\2\u0669c\3\2\2\2\u066a\u066b\t\20\2\2\u066be\3\2\2\2\u066c\u066f\5"+
		"\u009cO\2\u066d\u066f\5h\65\2\u066e\u066c\3\2\2\2\u066e\u066d\3\2\2\2"+
		"\u066fg\3\2\2\2\u0670\u0674\7\u011d\2\2\u0671\u0674\5j\66\2\u0672\u0674"+
		"\5r:\2\u0673\u0670\3\2\2\2\u0673\u0671\3\2\2\2\u0673\u0672\3\2\2\2\u0674"+
		"i\3\2\2\2\u0675\u0679\5n8\2\u0676\u0679\5l\67\2\u0677\u0679\5p9\2\u0678"+
		"\u0675\3\2\2\2\u0678\u0676\3\2\2\2\u0678\u0677\3\2\2\2\u0679k\3\2\2\2"+
		"\u067a\u067b\7\u00f2\2\2\u067b\u067c\7\u011d\2\2\u067cm\3\2\2\2\u067d"+
		"\u067e\7\u00f4\2\2\u067e\u067f\7\u011d\2\2\u067fo\3\2\2\2\u0680\u0681"+
		"\7\u00f1\2\2\u0681\u0682\7\u011d\2\2\u0682q\3\2\2\2\u0683\u0684\t\21\2"+
		"\2\u0684s\3\2\2\2\u0685\u0686\5v<\2\u0686u\3\2\2\2\u0687\u0692\5|?\2\u0688"+
		"\u0692\5\u0080A\2\u0689\u0692\5\u0082B\2\u068a\u0692\5\u0084C\2\u068b"+
		"\u0692\5\u008cG\2\u068c\u0692\5\u008eH\2\u068d\u0692\5\u0090I\2\u068e"+
		"\u0692\5\u0092J\2\u068f\u0692\5z>\2\u0690\u0692\5x=\2\u0691\u0687\3\2"+
		"\2\2\u0691\u0688\3\2\2\2\u0691\u0689\3\2\2\2\u0691\u068a\3\2\2\2\u0691"+
		"\u068b\3\2\2\2\u0691\u068c\3\2\2\2\u0691\u068d\3\2\2\2\u0691\u068e\3\2"+
		"\2\2\u0691\u068f\3\2\2\2\u0691\u0690\3\2\2\2\u0692w\3\2\2\2\u0693\u0694"+
		"\7\u00e8\2\2\u0694y\3\2\2\2\u0695\u0696\7\u00fb\2\2\u0696{\3\2\2\2\u0697"+
		"\u0699\7x\2\2\u0698\u069a\5~@\2\u0699\u0698\3\2\2\2\u0699\u069a\3\2\2"+
		"\2\u069a\u06af\3\2\2\2\u069b\u069d\7\u00ed\2\2\u069c\u069e\5~@\2\u069d"+
		"\u069c\3\2\2\2\u069d\u069e\3\2\2\2\u069e\u06af\3\2\2\2\u069f\u06a0\7x"+
		"\2\2\u06a0\u06a2\7\u00d2\2\2\u06a1\u06a3\5~@\2\u06a2\u06a1\3\2\2\2\u06a2"+
		"\u06a3\3\2\2\2\u06a3\u06af\3\2\2\2\u06a4\u06a5\7\u00ed\2\2\u06a5\u06a7"+
		"\7\u00d2\2\2\u06a6\u06a8\5~@\2\u06a7\u06a6\3\2\2\2\u06a7\u06a8\3\2\2\2"+
		"\u06a8\u06af\3\2\2\2\u06a9\u06ab\7\u00ee\2\2\u06aa\u06ac\5~@\2\u06ab\u06aa"+
		"\3\2\2\2\u06ab\u06ac\3\2\2\2\u06ac\u06af\3\2\2\2\u06ad\u06af\7\u00f6\2"+
		"\2\u06ae\u0697\3\2\2\2\u06ae\u069b\3\2\2\2\u06ae\u069f\3\2\2\2\u06ae\u06a4"+
		"\3\2\2\2\u06ae\u06a9\3\2\2\2\u06ae\u06ad\3\2\2\2\u06af}\3\2\2\2\u06b0"+
		"\u06b1\7\u010c\2\2\u06b1\u06b2\7\u0118\2\2\u06b2\u06b3\7\u010d\2\2\u06b3"+
		"\177\3\2\2\2\u06b4\u06b5\7\u00aa\2\2\u06b5\u06b7\7x\2\2\u06b6\u06b8\5"+
		"~@\2\u06b7\u06b6\3\2\2\2\u06b7\u06b8\3\2\2\2\u06b8\u06d8\3\2\2\2\u06b9"+
		"\u06ba\7\u00aa\2\2\u06ba\u06bc\7\u00ed\2\2\u06bb\u06bd\5~@\2\u06bc\u06bb"+
		"\3\2\2\2\u06bc\u06bd\3\2\2\2\u06bd\u06d8\3\2\2\2\u06be\u06c0\7\u00ef\2"+
		"\2\u06bf\u06c1\5~@\2\u06c0\u06bf\3\2\2\2\u06c0\u06c1\3\2\2\2\u06c1\u06d8"+
		"\3\2\2\2\u06c2\u06c3\7\u00aa\2\2\u06c3\u06c4\7x\2\2\u06c4\u06c6\7\u00d2"+
		"\2\2\u06c5\u06c7\5~@\2\u06c6\u06c5\3\2\2\2\u06c6\u06c7\3\2\2\2\u06c7\u06d8"+
		"\3\2\2\2\u06c8\u06c9\7\u00aa\2\2\u06c9\u06ca\7\u00ed\2\2\u06ca\u06cc\7"+
		"\u00d2\2\2\u06cb\u06cd\5~@\2\u06cc\u06cb\3\2\2\2\u06cc\u06cd\3\2\2\2\u06cd"+
		"\u06d8\3\2\2\2\u06ce\u06cf\7\u00ef\2\2\u06cf\u06d1\7\u00d2\2\2\u06d0\u06d2"+
		"\5~@\2\u06d1\u06d0\3\2\2\2\u06d1\u06d2\3\2\2\2\u06d2\u06d8\3\2\2\2\u06d3"+
		"\u06d5\7\u00f0\2\2\u06d4\u06d6\5~@\2\u06d5\u06d4\3\2\2\2\u06d5\u06d6\3"+
		"\2\2\2\u06d6\u06d8\3\2\2\2\u06d7\u06b4\3\2\2\2\u06d7\u06b9\3\2\2\2\u06d7"+
		"\u06be\3\2\2\2\u06d7\u06c2\3\2\2\2\u06d7\u06c8\3\2\2\2\u06d7\u06ce\3\2"+
		"\2\2\u06d7\u06d3\3\2\2\2\u06d8\u0081\3\2\2\2\u06d9\u06db\7\u00f9\2\2\u06da"+
		"\u06dc\5~@\2\u06db\u06da\3\2\2\2\u06db\u06dc\3\2\2\2\u06dc\u06e2\3\2\2"+
		"\2\u06dd\u06df\7\u00fa\2\2\u06de\u06e0\5~@\2\u06df\u06de\3\2\2\2\u06df"+
		"\u06e0\3\2\2\2\u06e0\u06e2\3\2\2\2\u06e1\u06d9\3\2\2\2\u06e1\u06dd\3\2"+
		"\2\2\u06e2\u0083\3\2\2\2\u06e3\u06e6\5\u0086D\2\u06e4\u06e6\5\u0088E\2"+
		"\u06e5\u06e3\3\2\2\2\u06e5\u06e4\3\2\2\2\u06e6\u0085\3\2\2\2\u06e7\u06e9"+
		"\7\u00eb\2\2\u06e8\u06ea\5\u008aF\2\u06e9\u06e8\3\2\2\2\u06e9\u06ea\3"+
		"\2\2\2\u06ea\u06fd\3\2\2\2\u06eb\u06ed\7\u00ec\2\2\u06ec\u06ee\5\u008a"+
		"F\2\u06ed\u06ec\3\2\2\2\u06ed\u06ee\3\2\2\2\u06ee\u06fd\3\2\2\2\u06ef"+
		"\u06f1\7\u0084\2\2\u06f0\u06f2\5\u008aF\2\u06f1\u06f0\3\2\2\2\u06f1\u06f2"+
		"\3\2\2\2\u06f2\u06fd\3\2\2\2\u06f3\u06fd\7\u00dc\2\2\u06f4\u06fd\7\u00e0"+
		"\2\2\u06f5\u06fd\7\u00dd\2\2\u06f6\u06fd\7\u00e1\2\2\u06f7\u06fd\7\u00de"+
		"\2\2\u06f8\u06fd\7\u00e2\2\2\u06f9\u06fd\7\u00e3\2\2\u06fa\u06fd\7\u00df"+
		"\2\2\u06fb\u06fd\7\u00e4\2\2\u06fc\u06e7\3\2\2\2\u06fc\u06eb\3\2\2\2\u06fc"+
		"\u06ef\3\2\2\2\u06fc\u06f3\3\2\2\2\u06fc\u06f4\3\2\2\2\u06fc\u06f5\3\2"+
		"\2\2\u06fc\u06f6\3\2\2\2\u06fc\u06f7\3\2\2\2\u06fc\u06f8\3\2\2\2\u06fc"+
		"\u06f9\3\2\2\2\u06fc\u06fa\3\2\2\2\u06fc\u06fb\3\2\2\2\u06fd\u0087\3\2"+
		"\2\2\u06fe\u0700\7\u00e9\2\2\u06ff\u0701\5\u008aF\2\u0700\u06ff\3\2\2"+
		"\2\u0700\u0701\3\2\2\2\u0701\u0709\3\2\2\2\u0702\u0709\7\u00e5\2\2\u0703"+
		"\u0709\7\u00e7\2\2\u0704\u0709\7\u00e6\2\2\u0705\u0709\7\u00ea\2\2\u0706"+
		"\u0707\7\u00ea\2\2\u0707\u0709\7\u00b3\2\2\u0708\u06fe\3\2\2\2\u0708\u0702"+
		"\3\2\2\2\u0708\u0703\3\2\2\2\u0708\u0704\3\2\2\2\u0708\u0705\3\2\2\2\u0708"+
		"\u0706\3\2\2\2\u0709\u0089\3\2\2\2\u070a\u070b\7\u010c\2\2\u070b\u070c"+
		"\7\u0118\2\2\u070c\u0713\7\u010d\2\2\u070d\u070e\7\u010c\2\2\u070e\u070f"+
		"\7\u0118\2\2\u070f\u0710\7\u0105\2\2\u0710\u0711\7\u0118\2\2\u0711\u0713"+
		"\7\u010d\2\2\u0712\u070a\3\2\2\2\u0712\u070d\3\2\2\2\u0713\u008b\3\2\2"+
		"\2\u0714\u0715\t\22\2\2\u0715\u008d\3\2\2\2\u0716\u0724\7\u00f1\2\2\u0717"+
		"\u0724\7\u00f2\2\2\u0718\u0719\7\u00f2\2\2\u0719\u071a\7q\2\2\u071a\u071b"+
		"\7\u00f2\2\2\u071b\u0724\7\u00d7\2\2\u071c\u0724\7\u00f3\2\2\u071d\u0724"+
		"\7\u00f4\2\2\u071e\u071f\7\u00f4\2\2\u071f\u0720\7q\2\2\u0720\u0721\7"+
		"\u00f2\2\2\u0721\u0724\7\u00d7\2\2\u0722\u0724\7\u00f5\2\2\u0723\u0716"+
		"\3\2\2\2\u0723\u0717\3\2\2\2\u0723\u0718\3\2\2\2\u0723\u071c\3\2\2\2\u0723"+
		"\u071d\3\2\2\2\u0723\u071e\3\2\2\2\u0723\u0722\3\2\2\2\u0724\u008f\3\2"+
		"\2\2\u0725\u0727\7\u00da\2\2\u0726\u0728\5~@\2\u0727\u0726\3\2\2\2\u0727"+
		"\u0728\3\2\2\2\u0728\u0733\3\2\2\2\u0729\u072b\7\u00db\2\2\u072a\u072c"+
		"\5~@\2\u072b\u072a\3\2\2\2\u072b\u072c\3\2\2\2\u072c\u0733\3\2\2\2\u072d"+
		"\u072e\7\u00da\2\2\u072e\u0730\7\u00d2\2\2\u072f\u0731\5~@\2\u0730\u072f"+
		"\3\2\2\2\u0730\u0731\3\2\2\2\u0731\u0733\3\2\2\2\u0732\u0725\3\2\2\2\u0732"+
		"\u0729\3\2\2\2\u0732\u072d\3\2\2\2\u0733\u0091\3\2\2\2\u0734\u0736\7\u00f7"+
		"\2\2\u0735\u0737\5~@\2\u0736\u0735\3\2\2\2\u0736\u0737\3\2\2\2\u0737\u0742"+
		"\3\2\2\2\u0738\u0739\7\u00f7\2\2\u0739\u073b\7\u00d2\2\2\u073a\u073c\5"+
		"~@\2\u073b\u073a\3\2\2\2\u073b\u073c\3\2\2\2\u073c\u0742\3\2\2\2\u073d"+
		"\u073f\7\u00f8\2\2\u073e\u0740\5~@\2\u073f\u073e\3\2\2\2\u073f\u0740\3"+
		"\2\2\2\u0740\u0742\3\2\2\2\u0741\u0734\3\2\2\2\u0741\u0738\3\2\2\2\u0741"+
		"\u073d\3\2\2\2\u0742\u0093\3\2\2\2\u0743\u0746\5\u0096L\2\u0744\u0746"+
		"\5\u0098M\2\u0745\u0743\3\2\2\2\u0745\u0744\3\2\2\2\u0746\u0095\3\2\2"+
		"\2\u0747\u0748\7\u010c\2\2\u0748\u0749\5\u00c4c\2\u0749\u074a\7\u010d"+
		"\2\2\u074a\u0097\3\2\2\2\u074b\u0753\5\u009aN\2\u074c\u0753\5\u016c\u00b7"+
		"\2\u074d\u0753\5\u00a0Q\2\u074e\u0753\5\u0172\u00ba\2\u074f\u0753\5\u00ac"+
		"W\2\u0750\u0753\5\u00be`\2\u0751\u0753\5\u01a6\u00d4\2\u0752\u074b\3\2"+
		"\2\2\u0752\u074c\3\2\2\2\u0752\u074d\3\2\2\2\u0752\u074e\3\2\2\2\u0752"+
		"\u074f\3\2\2\2\u0752\u0750\3\2\2\2\u0752\u0751\3\2\2\2\u0753\u0099\3\2"+
		"\2\2\u0754\u0755\5f\64\2\u0755\u009b\3\2\2\2\u0756\u0757\t\23\2\2\u0757"+
		"\u009d\3\2\2\2\u0758\u075a\5\u00d2j\2\u0759\u0758\3\2\2\2\u0759\u075a"+
		"\3\2\2\2\u075a\u075b\3\2\2\2\u075b\u075c\5\u009cO\2\u075c\u009f\3\2\2"+
		"\2\u075d\u075e\5\u00a2R\2\u075e\u00a1\3\2\2\2\u075f\u0760\7\u0080\2\2"+
		"\u0760\u0761\7\u010c\2\2\u0761\u0762\7\u0110\2\2\u0762\u0768\7\u010d\2"+
		"\2\u0763\u0765\5\u00a4S\2\u0764\u0766\5\u00a8U\2\u0765\u0764\3\2\2\2\u0765"+
		"\u0766\3\2\2\2\u0766\u0768\3\2\2\2\u0767\u075f\3\2\2\2\u0767\u0763\3\2"+
		"\2\2\u0768\u00a3\3\2\2\2\u0769\u076a\5\u00a6T\2\u076a\u076c\7\u010c\2"+
		"\2\u076b\u076d\5\u016a\u00b6\2\u076c\u076b\3\2\2\2\u076c\u076d\3\2\2\2"+
		"\u076d\u076e\3\2\2\2\u076e\u076f\5\u00c4c\2\u076f\u0770\7\u010d\2\2\u0770"+
		"\u00a5\3\2\2\2\u0771\u0772\t\24\2\2\u0772\u00a7\3\2\2\2\u0773\u0774\7"+
		"\u008e\2\2\u0774\u0775\7\u010c\2\2\u0775\u0776\7p\2\2\u0776\u0777\5\u0134"+
		"\u009b\2\u0777\u0778\7\u010d\2\2\u0778\u00a9\3\2\2\2\u0779\u077a\7\u0092"+
		"\2\2\u077a\u077b\7\u010c\2\2\u077b\u077c\5\u0170\u00b9\2\u077c\u077d\7"+
		"\u010d\2\2\u077d\u00ab\3\2\2\2\u077e\u077f\5\u00b0Y\2\u077f\u00ad\3\2"+
		"\2\2\u0780\u0781\7\u00ab\2\2\u0781\u0782\7\u010c\2\2\u0782\u0783\5\u00c8"+
		"e\2\u0783\u0784\7\u0105\2\2\u0784\u0785\5\u00eex\2\u0785\u0786\7\u010d"+
		"\2\2\u0786\u0793\3\2\2\2\u0787\u0788\7{\2\2\u0788\u0789\7\u010c\2\2\u0789"+
		"\u078c\5\u00c8e\2\u078a\u078b\7\u0105\2\2\u078b\u078d\5\u00eex\2\u078c"+
		"\u078a\3\2\2\2\u078d\u078e\3\2\2\2\u078e\u078c\3\2\2\2\u078e\u078f\3\2"+
		"\2\2\u078f\u0790\3\2\2\2\u0790\u0791\7\u010d\2\2\u0791\u0793\3\2\2\2\u0792"+
		"\u0780\3\2\2\2\u0792\u0787\3\2\2\2\u0793\u00af\3\2\2\2\u0794\u0797\5\u00b2"+
		"Z\2\u0795\u0797\5\u00b4[\2\u0796\u0794\3\2\2\2\u0796\u0795\3\2\2\2\u0797"+
		"\u00b1\3\2\2\2\u0798\u0799\7\f\2\2\u0799\u079b\5\u00eex\2\u079a\u079c"+
		"\5\u00b6\\\2\u079b\u079a\3\2\2\2\u079c\u079d\3\2\2\2\u079d\u079b\3\2\2"+
		"\2\u079d\u079e\3\2\2\2\u079e\u07a0\3\2\2\2\u079f\u07a1\5\u00ba^\2\u07a0"+
		"\u079f\3\2\2\2\u07a0\u07a1\3\2\2\2\u07a1\u07a2\3\2\2\2\u07a2\u07a3\7\36"+
		"\2\2\u07a3\u00b3\3\2\2\2\u07a4\u07a6\7\f\2\2\u07a5\u07a7\5\u00b8]\2\u07a6"+
		"\u07a5\3\2\2\2\u07a7\u07a8\3\2\2\2\u07a8\u07a6\3\2\2\2\u07a8\u07a9\3\2"+
		"\2\2\u07a9\u07ab\3\2\2\2\u07aa\u07ac\5\u00ba^\2\u07ab\u07aa\3\2\2\2\u07ab"+
		"\u07ac\3\2\2\2\u07ac\u07ad\3\2\2\2\u07ad\u07ae\7\36\2\2\u07ae\u00b5\3"+
		"\2\2\2\u07af\u07b0\7o\2\2\u07b0\u07b1\5\u0134\u009b\2\u07b1\u07b2\7d\2"+
		"\2\u07b2\u07b3\5\u00bc_\2\u07b3\u00b7\3\2\2\2\u07b4\u07b5\7o\2\2\u07b5"+
		"\u07b6\5\u0134\u009b\2\u07b6\u07b7\7d\2\2\u07b7\u07b8\5\u00bc_\2\u07b8"+
		"\u00b9\3\2\2\2\u07b9\u07ba\7\37\2\2\u07ba\u07bb\5\u00bc_\2\u07bb\u00bb"+
		"\3\2\2\2\u07bc\u07bf\5\u00c4c\2\u07bd\u07bf\7F\2\2\u07be\u07bc\3\2\2\2"+
		"\u07be\u07bd\3\2\2\2\u07bf\u00bd\3\2\2\2\u07c0\u07c1\7\16\2\2\u07c1\u07c2"+
		"\7\u010c\2\2\u07c2\u07c3\5\u00c0a\2\u07c3\u07c4\7\4\2\2\u07c4\u07c5\5"+
		"\u00c2b\2\u07c5\u07c6\7\u010d\2\2\u07c6\u00bf\3\2\2\2\u07c7\u07c8\5\u00c4"+
		"c\2\u07c8\u00c1\3\2\2\2\u07c9\u07ca\5t;\2\u07ca\u00c3\3\2\2\2\u07cb\u07cf"+
		"\5\u00c6d\2\u07cc\u07cf\5\u0102\u0082\2\u07cd\u07cf\5\u00eex\2\u07ce\u07cb"+
		"\3\2\2\2\u07ce\u07cc\3\2\2\2\u07ce\u07cd\3\2\2\2\u07cf\u00c5\3\2\2\2\u07d0"+
		"\u07d4\5\u00c8e\2\u07d1\u07d4\5\u00dep\2\u07d2\u07d4\7F\2\2\u07d3\u07d0"+
		"\3\2\2\2\u07d3\u07d1\3\2\2\2\u07d3\u07d2\3\2\2\2\u07d4\u00c7\3\2\2\2\u07d5"+
		"\u07da\5\u00caf\2\u07d6\u07d7\t\25\2\2\u07d7\u07d9\5\u00caf\2\u07d8\u07d6"+
		"\3\2\2\2\u07d9\u07dc\3\2\2\2\u07da\u07d8\3\2\2\2\u07da\u07db\3\2\2\2\u07db"+
		"\u00c9\3\2\2\2\u07dc\u07da\3\2\2\2\u07dd\u07e2\5\u00ccg\2\u07de\u07df"+
		"\t\26\2\2\u07df\u07e1\5\u00ccg\2\u07e0\u07de\3\2\2\2\u07e1\u07e4\3\2\2"+
		"\2\u07e2\u07e0\3\2\2\2\u07e2\u07e3\3\2\2\2\u07e3\u00cb\3\2\2\2\u07e4\u07e2"+
		"\3\2\2\2\u07e5\u07e7\5\u00d2j\2\u07e6\u07e5\3\2\2\2\u07e6\u07e7\3\2\2"+
		"\2\u07e7\u07e8\3\2\2\2\u07e8\u07e9\5\u00d0i\2\u07e9\u00cd\3\2\2\2\u07ea"+
		"\u07eb\7\u010c\2\2\u07eb\u07f0\5\u00c8e\2\u07ec\u07ed\7\u0105\2\2\u07ed"+
		"\u07ef\5\u00c8e\2\u07ee\u07ec\3\2\2\2\u07ef\u07f2\3\2\2\2\u07f0\u07ee"+
		"\3\2\2\2\u07f0\u07f1\3\2\2\2\u07f1\u07f3\3\2\2\2\u07f2\u07f0\3\2\2\2\u07f3"+
		"\u07f4\7\u010d\2\2\u07f4\u00cf\3\2\2\2\u07f5\u07fa\5\u0094K\2\u07f6\u07f7"+
		"\7\u0100\2\2\u07f7\u07f9\5\u00c2b\2\u07f8\u07f6\3\2\2\2\u07f9\u07fc\3"+
		"\2\2\2\u07fa\u07f8\3\2\2\2\u07fa\u07fb\3\2\2\2\u07fb\u07ff\3\2\2\2\u07fc"+
		"\u07fa\3\2\2\2\u07fd\u07ff\5\u00d4k\2\u07fe\u07f5\3\2\2\2\u07fe\u07fd"+
		"\3\2\2\2\u07ff\u00d1\3\2\2\2\u0800\u0801\t\25\2\2\u0801\u00d3\3\2\2\2"+
		"\u0802\u0803\5\u00d6l\2\u0803\u00d5\3\2\2\2\u0804\u0805\7\u008d\2\2\u0805"+
		"\u0806\7\u010c\2\2\u0806\u0807\5\u00d8m\2\u0807\u0808\7+\2\2\u0808\u0809"+
		"\5\u00dco\2\u0809\u080a\7\u010d\2\2\u080a\u00d7\3\2\2\2\u080b\u080f\5"+
		"\u01a0\u00d1\2\u080c\u080f\5\u00dan\2\u080d\u080f\5\u01a4\u00d3\2\u080e"+
		"\u080b\3\2\2\2\u080e\u080c\3\2\2\2\u080e\u080d\3\2\2\2\u080f\u00d9\3\2"+
		"\2\2\u0810\u0811\t\27\2\2\u0811\u00db\3\2\2\2\u0812\u0815\5\u016c\u00b7"+
		"\2\u0813\u0815\5j\66\2\u0814\u0812\3\2\2\2\u0814\u0813\3\2\2\2\u0815\u00dd"+
		"\3\2\2\2\u0816\u0817\5\u00e0q\2\u0817\u00df\3\2\2\2\u0818\u081d\5\u00e2"+
		"r\2\u0819\u081a\7\u0106\2\2\u081a\u081c\5\u00e2r\2\u081b\u0819\3\2\2\2"+
		"\u081c\u081f\3\2\2\2\u081d\u081b\3\2\2\2\u081d\u081e\3\2\2\2\u081e\u00e1"+
		"\3\2\2\2\u081f\u081d\3\2\2\2\u0820\u0821\5\u00e4s\2\u0821\u00e3\3\2\2"+
		"\2\u0822\u0825\5\u0094K\2\u0823\u0825\5\u00e6t\2\u0824\u0822\3\2\2\2\u0824"+
		"\u0823\3\2\2\2\u0825\u00e5\3\2\2\2\u0826\u0827\5\u00e8u\2\u0827\u00e7"+
		"\3\2\2\2\u0828\u0829\7\u00cb\2\2\u0829\u082a\7\u010c\2\2\u082a\u082b\5"+
		"\u00eav\2\u082b\u082c\7\u010d\2\2\u082c\u00e9\3\2\2\2\u082d\u082f\5\u00ec"+
		"w\2\u082e\u082d\3\2\2\2\u082e\u082f\3\2\2\2\u082f\u0831\3\2\2\2\u0830"+
		"\u0832\5\u00e0q\2\u0831\u0830\3\2\2\2\u0831\u0832\3\2\2\2\u0832\u0833"+
		"\3\2\2\2\u0833\u0835\7+\2\2\u0834\u082e\3\2\2\2\u0834\u0835\3\2\2\2\u0835"+
		"\u0836\3\2\2\2\u0836\u083c\5\u00e0q\2\u0837\u0838\5\u00e0q\2\u0838\u0839"+
		"\7\u0105\2\2\u0839\u083a\5\u00e0q\2\u083a\u083c\3\2\2\2\u083b\u0834\3"+
		"\2\2\2\u083b\u0837\3\2\2\2\u083c\u00eb\3\2\2\2\u083d\u083e\t\30\2\2\u083e"+
		"\u00ed\3\2\2\2\u083f\u0840\5\u00f0y\2\u0840\u00ef\3\2\2\2\u0841\u0846"+
		"\5\u00f2z\2\u0842\u0843\7L\2\2\u0843\u0845\5\u00f0y\2\u0844\u0842\3\2"+
		"\2\2\u0845\u0848\3\2\2\2\u0846\u0844\3\2\2\2\u0846\u0847\3\2\2\2\u0847"+
		"\u00f1\3\2\2\2\u0848\u0846\3\2\2\2\u0849\u084e\5\u00f4{\2\u084a\u084b"+
		"\7\6\2\2\u084b\u084d\5\u00f2z\2\u084c\u084a\3\2\2\2\u084d\u0850\3\2\2"+
		"\2\u084e\u084c\3\2\2\2\u084e\u084f\3\2\2\2\u084f\u00f3\3\2\2\2\u0850\u084e"+
		"\3\2\2\2\u0851\u0855\5\u00f6|\2\u0852\u0853\7E\2\2\u0853\u0855\5\u00f6"+
		"|\2\u0854\u0851\3\2\2\2\u0854\u0852\3\2\2\2\u0855\u00f5\3\2\2\2\u0856"+
		"\u0858\5\u00fc\177\2\u0857\u0859\5\u00f8}\2\u0858\u0857\3\2\2\2\u0858"+
		"\u0859\3\2\2\2\u0859\u00f7\3\2\2\2\u085a\u085c\7<\2\2\u085b\u085d\7E\2"+
		"\2\u085c\u085b\3\2\2\2\u085c\u085d\3\2\2\2\u085d\u085e\3\2\2\2\u085e\u085f"+
		"\5\u00fa~\2\u085f\u00f9\3\2\2\2\u0860\u0861\t\21\2\2\u0861\u00fb\3\2\2"+
		"\2\u0862\u0865\5\u017a\u00be\2\u0863\u0865\5\u00fe\u0080\2\u0864\u0862"+
		"\3\2\2\2\u0864\u0863\3\2\2\2\u0865\u00fd\3\2\2\2\u0866\u0869\5\u0100\u0081"+
		"\2\u0867\u0869\5\u0098M\2\u0868\u0866\3\2\2\2\u0868\u0867\3\2\2\2\u0869"+
		"\u00ff\3\2\2\2\u086a\u086b\7\u010c\2\2\u086b\u086c\5\u00eex\2\u086c\u086d"+
		"\7\u010d\2\2\u086d\u0101\3\2\2\2\u086e\u0871\5\u0104\u0083\2\u086f\u0871"+
		"\5\u0106\u0084\2\u0870\u086e\3\2\2\2\u0870\u086f\3\2\2\2\u0871\u0103\3"+
		"\2\2\2\u0872\u0873\5\u0098M\2\u0873\u0105\3\2\2\2\u0874\u0875\7F\2\2\u0875"+
		"\u0107\3\2\2\2\u0876\u0879\5\u0104\u0083\2\u0877\u0879\5\u010a\u0086\2"+
		"\u0878\u0876\3\2\2\2\u0878\u0877\3\2\2\2\u0879\u0109\3\2\2\2\u087a\u087d"+
		"\5\u00c6d\2\u087b\u087d\5\u00fe\u0080\2\u087c\u087a\3\2\2\2\u087c\u087b"+
		"\3\2\2\2\u087d\u010b\3\2\2\2\u087e\u0880\5\u010e\u0088\2\u087f\u0881\5"+
		"\u0132\u009a\2\u0880\u087f\3\2\2\2\u0880\u0881\3\2\2\2\u0881\u0883\3\2"+
		"\2\2\u0882\u0884\5\u0136\u009c\2\u0883\u0882\3\2\2\2\u0883\u0884\3\2\2"+
		"\2\u0884\u0886\3\2\2\2\u0885\u0887\5\u0146\u00a4\2\u0886\u0885\3\2\2\2"+
		"\u0886\u0887\3\2\2\2\u0887\u0889\3\2\2\2\u0888\u088a\5\u01ae\u00d8\2\u0889"+
		"\u0888\3\2\2\2\u0889\u088a\3\2\2\2\u088a\u088c\3\2\2\2\u088b\u088d\5\u01b6"+
		"\u00dc\2\u088c\u088b\3\2\2\2\u088c\u088d\3\2\2\2\u088d\u010d\3\2\2\2\u088e"+
		"\u088f\7+\2\2\u088f\u0890\5\u0110\u0089\2\u0890\u010f\3\2\2\2\u0891\u0896"+
		"\5\u0112\u008a\2\u0892\u0893\7\u0105\2\2\u0893\u0895\5\u0112\u008a\2\u0894"+
		"\u0892\3\2\2\2\u0895\u0898\3\2\2\2\u0896\u0894\3\2\2\2\u0896\u0897\3\2"+
		"\2\2\u0897\u0111\3\2\2\2\u0898\u0896\3\2\2\2\u0899\u089c\5\u0114\u008b"+
		"\2\u089a\u089c\5\u012c\u0097\2\u089b\u0899\3\2\2\2\u089b\u089a\3\2\2\2"+
		"\u089c\u0113\3\2\2\2\u089d\u089f\5\u012c\u0097\2\u089e\u08a0\5\u0116\u008c"+
		"\2\u089f\u089e\3\2\2\2\u08a0\u08a1\3\2\2\2\u08a1\u089f\3\2\2\2\u08a1\u08a2"+
		"\3\2\2\2\u08a2\u0115\3\2\2\2\u08a3\u08a4\7\24\2\2\u08a4\u08a5\7=\2\2\u08a5"+
		"\u08b7\5\u012c\u0097\2\u08a6\u08a8\5\u0120\u0091\2\u08a7\u08a6\3\2\2\2"+
		"\u08a7\u08a8\3\2\2\2\u08a8\u08a9\3\2\2\2\u08a9\u08aa\7=\2\2\u08aa\u08ab"+
		"\5\u012c\u0097\2\u08ab\u08ac\5\u0126\u0094\2\u08ac\u08b7\3\2\2\2\u08ad"+
		"\u08af\7D\2\2\u08ae\u08b0\5\u0120\u0091\2\u08af\u08ae\3\2\2\2\u08af\u08b0"+
		"\3\2\2\2\u08b0\u08b1\3\2\2\2\u08b1\u08b2\7=\2\2\u08b2\u08b7\5\u012c\u0097"+
		"\2\u08b3\u08b4\7i\2\2\u08b4\u08b5\7=\2\2\u08b5\u08b7\5\u012c\u0097\2\u08b6"+
		"\u08a3\3\2\2\2\u08b6\u08a7\3\2\2\2\u08b6\u08ad\3\2\2\2\u08b6\u08b3\3\2"+
		"\2\2\u08b7\u0117\3\2\2\2\u08b8\u08b9\7\24\2\2\u08b9\u08ba\7=\2\2\u08ba"+
		"\u08bb\5\u012c\u0097\2\u08bb\u0119\3\2\2\2\u08bc\u08be\5\u0120\u0091\2"+
		"\u08bd\u08bc\3\2\2\2\u08bd\u08be\3\2\2\2\u08be\u08bf\3\2\2\2\u08bf\u08c0"+
		"\7=\2\2\u08c0\u08c1\5\u012c\u0097\2\u08c1\u08c2\5\u0126\u0094\2\u08c2"+
		"\u011b\3\2\2\2\u08c3\u08c5\7D\2\2\u08c4\u08c6\5\u0120\u0091\2\u08c5\u08c4"+
		"\3\2\2\2\u08c5\u08c6\3\2\2\2\u08c6\u08c7\3\2\2\2\u08c7\u08c8\7=\2\2\u08c8"+
		"\u08c9\5\u012c\u0097\2\u08c9\u011d\3\2\2\2\u08ca\u08cb\7i\2\2\u08cb\u08cc"+
		"\7=\2\2\u08cc\u08cd\5\u012c\u0097\2\u08cd\u011f\3\2\2\2\u08ce\u08d1\7"+
		"\67\2\2\u08cf\u08d1\5\u0122\u0092\2\u08d0\u08ce\3\2\2\2\u08d0\u08cf\3"+
		"\2\2\2\u08d1\u0121\3\2\2\2\u08d2\u08d4\5\u0124\u0093\2\u08d3\u08d5\7J"+
		"\2\2\u08d4\u08d3\3\2\2\2\u08d4\u08d5\3\2\2\2\u08d5\u0123\3\2\2\2\u08d6"+
		"\u08d7\t\31\2\2\u08d7\u0125\3\2\2\2\u08d8\u08db\5\u0128\u0095\2\u08d9"+
		"\u08db\5\u012a\u0096\2\u08da\u08d8\3\2\2\2\u08da\u08d9\3\2\2\2\u08db\u0127"+
		"\3\2\2\2\u08dc\u08dd\7I\2\2\u08dd\u08de\5\u0134\u009b\2\u08de\u0129\3"+
		"\2\2\2\u08df\u08e0\7m\2\2\u08e0\u08e1\7\u010c\2\2\u08e1\u08e2\5\u0170"+
		"\u00b9\2\u08e2\u08e3\7\u010d\2\2\u08e3\u012b\3\2\2\2\u08e4\u08e9\5\u015c"+
		"\u00af\2\u08e5\u08e7\7\4\2\2\u08e6\u08e5\3\2\2\2\u08e6\u08e7\3\2\2\2\u08e7"+
		"\u08e8\3\2\2\2\u08e8\u08ea\5b\62\2\u08e9\u08e6\3\2\2\2\u08e9\u08ea\3\2"+
		"\2\2\u08ea\u08ef\3\2\2\2\u08eb\u08ec\7\u010c\2\2\u08ec\u08ed\5\u012e\u0098"+
		"\2\u08ed\u08ee\7\u010d\2\2\u08ee\u08f0\3\2\2\2\u08ef\u08eb\3\2\2\2\u08ef"+
		"\u08f0\3\2\2\2\u08f0\u08fd\3\2\2\2\u08f1\u08f3\5\u0130\u0099\2\u08f2\u08f4"+
		"\7\4\2\2\u08f3\u08f2\3\2\2\2\u08f3\u08f4\3\2\2\2\u08f4\u08f5\3\2\2\2\u08f5"+
		"\u08fa\5b\62\2\u08f6\u08f7\7\u010c\2\2\u08f7\u08f8\5\u012e\u0098\2\u08f8"+
		"\u08f9\7\u010d\2\2\u08f9\u08fb\3\2\2\2\u08fa\u08f6\3\2\2\2\u08fa\u08fb"+
		"\3\2\2\2\u08fb\u08fd\3\2\2\2\u08fc\u08e4\3\2\2\2\u08fc\u08f1\3\2\2\2\u08fd"+
		"\u012d\3\2\2\2\u08fe\u0903\5b\62\2\u08ff\u0900\7\u0105\2\2\u0900\u0902"+
		"\5b\62\2\u0901\u08ff\3\2\2\2\u0902\u0905\3\2\2\2\u0903\u0901\3\2\2\2\u0903"+
		"\u0904\3\2\2\2\u0904\u012f\3\2\2\2\u0905\u0903\3\2\2\2\u0906\u0907\5\u0176"+
		"\u00bc\2\u0907\u0131\3\2\2\2\u0908\u0909\7p\2\2\u0909\u090a\5\u0134\u009b"+
		"\2\u090a\u0133\3\2\2\2\u090b\u090c\5\u00c4c\2\u090c\u0135\3\2\2\2\u090d"+
		"\u090e\7.\2\2\u090e\u090f\7v\2\2\u090f\u0910\5\u0138\u009d\2\u0910\u0137"+
		"\3\2\2\2\u0911\u0916\5\u013a\u009e\2\u0912\u0913\7\u0105\2\2\u0913\u0915"+
		"\5\u013a\u009e\2\u0914\u0912\3\2\2\2\u0915\u0918\3\2\2\2\u0916\u0914\3"+
		"\2\2\2\u0916\u0917\3\2\2\2\u0917\u0139\3\2\2\2\u0918\u0916\3\2\2\2\u0919"+
		"\u091e\5\u0140\u00a1\2\u091a\u091e\5\u0142\u00a2\2\u091b\u091e\5\u0144"+
		"\u00a3\2\u091c\u091e\5\u013c\u009f\2\u091d\u0919\3\2\2\2\u091d\u091a\3"+
		"\2\2\2\u091d\u091b\3\2\2\2\u091d\u091c\3\2\2\2\u091e\u013b\3\2\2\2\u091f"+
		"\u0925\5\u0108\u0085\2\u0920\u0921\7\u010c\2\2\u0921\u0922\5\u0148\u00a5"+
		"\2\u0922\u0923\7\u010d\2\2\u0923\u0925\3\2\2\2\u0924\u091f\3\2\2\2\u0924"+
		"\u0920\3\2\2\2\u0925\u013d\3\2\2\2\u0926\u092b\5\u013c\u009f\2\u0927\u0928"+
		"\7\u0105\2\2\u0928\u092a\5\u013c\u009f\2\u0929\u0927\3\2\2\2\u092a\u092d"+
		"\3\2\2\2\u092b\u0929\3\2\2\2\u092b\u092c\3\2\2\2\u092c\u013f\3\2\2\2\u092d"+
		"\u092b\3\2\2\2\u092e\u092f\7\u00ba\2\2\u092f\u0930\7\u010c\2\2\u0930\u0931"+
		"\5\u013e\u00a0\2\u0931\u0932\7\u010d\2\2\u0932\u0141\3\2\2\2\u0933\u0934"+
		"\7\u0081\2\2\u0934\u0935\7\u010c\2\2\u0935\u0936\5\u013e\u00a0\2\u0936"+
		"\u0937\7\u010d\2\2\u0937\u0143\3\2\2\2\u0938\u0939\7\u010c\2\2\u0939\u093a"+
		"\7\u010d\2\2\u093a\u0145\3\2\2\2\u093b\u093c\7/\2\2\u093c\u093d\5\u00ee"+
		"x\2\u093d\u0147\3\2\2\2\u093e\u0943\5\u0108\u0085\2\u093f\u0940\7\u0105"+
		"\2\2\u0940\u0942\5\u0108\u0085\2\u0941\u093f\3\2";
	private static final String _serializedATNSegment1 =
		"\2\2\u0942\u0945\3\2\2\2\u0943\u0941\3\2\2\2\u0943\u0944\3\2\2\2\u0944"+
		"\u0149\3\2\2\2\u0945\u0943\3\2\2\2\u0946\u0947\5\u014c\u00a7\2\u0947\u014b"+
		"\3\2\2\2\u0948\u094b\5\u014e\u00a8\2\u0949\u094b\5\u0114\u008b\2\u094a"+
		"\u0948\3\2\2\2\u094a\u0949\3\2\2\2\u094b\u014d\3\2\2\2\u094c\u0955\5\u0152"+
		"\u00aa\2\u094d\u094e\5\u0114\u008b\2\u094e\u0950\t\32\2\2\u094f\u0951"+
		"\t\33\2\2\u0950\u094f\3\2\2\2\u0950\u0951\3\2\2\2\u0951\u0952\3\2\2\2"+
		"\u0952\u0953\5\u0150\u00a9\2\u0953\u0955\3\2\2\2\u0954\u094c\3\2\2\2\u0954"+
		"\u094d\3\2\2\2\u0955\u095d\3\2\2\2\u0956\u0958\t\32\2\2\u0957\u0959\t"+
		"\33\2\2\u0958\u0957\3\2\2\2\u0958\u0959\3\2\2\2\u0959\u095a\3\2\2\2\u095a"+
		"\u095c\5\u0150\u00a9\2\u095b\u0956\3\2\2\2\u095c\u095f\3\2\2\2\u095d\u095b"+
		"\3\2\2\2\u095d\u095e\3\2\2\2\u095e\u014f\3\2\2\2\u095f\u095d\3\2\2\2\u0960"+
		"\u0963\5\u0152\u00aa\2\u0961\u0963\5\u0114\u008b\2\u0962\u0960\3\2\2\2"+
		"\u0962\u0961\3\2\2\2\u0963\u0151\3\2\2\2\u0964\u096d\5\u0156\u00ac\2\u0965"+
		"\u0966\5\u0114\u008b\2\u0966\u0968\78\2\2\u0967\u0969\t\33\2\2\u0968\u0967"+
		"\3\2\2\2\u0968\u0969\3\2\2\2\u0969\u096a\3\2\2\2\u096a\u096b\5\u0154\u00ab"+
		"\2\u096b\u096d\3\2\2\2\u096c\u0964\3\2\2\2\u096c\u0965\3\2\2\2\u096d\u0975"+
		"\3\2\2\2\u096e\u0970\78\2\2\u096f\u0971\t\33\2\2\u0970\u096f\3\2\2\2\u0970"+
		"\u0971\3\2\2\2\u0971\u0972\3\2\2\2\u0972\u0974\5\u0154\u00ab\2\u0973\u096e"+
		"\3\2\2\2\u0974\u0977\3\2\2\2\u0975\u0973\3\2\2\2\u0975\u0976\3\2\2\2\u0976"+
		"\u0153\3\2\2\2\u0977\u0975\3\2\2\2\u0978\u097b\5\u0156\u00ac\2\u0979\u097b"+
		"\5\u0114\u008b\2\u097a\u0978\3\2\2\2\u097a\u0979\3\2\2\2\u097b\u0155\3"+
		"\2\2\2\u097c\u0982\5\u0158\u00ad\2\u097d\u097e\7\u010c\2\2\u097e\u097f"+
		"\5\u014e\u00a8\2\u097f\u0980\7\u010d\2\2\u0980\u0982\3\2\2\2\u0981\u097c"+
		"\3\2\2\2\u0981\u097d\3\2\2\2\u0982\u0157\3\2\2\2\u0983\u0986\5\u0160\u00b1"+
		"\2\u0984\u0986\5\u015a\u00ae\2\u0985\u0983\3\2\2\2\u0985\u0984\3\2\2\2"+
		"\u0986\u0159\3\2\2\2\u0987\u0988\7a\2\2\u0988\u0989\5\u015c\u00af\2\u0989"+
		"\u015b\3\2\2\2\u098a\u098d\5\u015e\u00b0\2\u098b\u098d\5b\62\2\u098c\u098a"+
		"\3\2\2\2\u098c\u098b\3\2\2\2\u098d\u015d\3\2\2\2\u098e\u0995\5b\62\2\u098f"+
		"\u0990\7\u0113\2\2\u0990\u0993\5b\62\2\u0991\u0992\7\u0113\2\2\u0992\u0994"+
		"\5b\62\2\u0993\u0991\3\2\2\2\u0993\u0994\3\2\2\2\u0994\u0996\3\2\2\2\u0995"+
		"\u098f\3\2\2\2\u0995\u0996\3\2\2\2\u0996\u015f\3\2\2\2\u0997\u0999\7\\"+
		"\2\2\u0998\u099a\5\u016a\u00b6\2\u0999\u0998\3\2\2\2\u0999\u099a\3\2\2"+
		"\2\u099a\u099b\3\2\2\2\u099b\u099d\5\u0162\u00b2\2\u099c\u099e\5\u010c"+
		"\u0087\2\u099d\u099c\3\2\2\2\u099d\u099e\3\2\2\2\u099e\u0161\3\2\2\2\u099f"+
		"\u09a4\5\u0164\u00b3\2\u09a0\u09a1\7\u0105\2\2\u09a1\u09a3\5\u0164\u00b3"+
		"\2\u09a2\u09a0\3\2\2\2\u09a3\u09a6\3\2\2\2\u09a4\u09a2\3\2\2\2\u09a4\u09a5"+
		"\3\2\2\2\u09a5\u0163\3\2\2\2\u09a6\u09a4\3\2\2\2\u09a7\u09aa\5\u0166\u00b4"+
		"\2\u09a8\u09aa\5\u0168\u00b5\2\u09a9\u09a7\3\2\2\2\u09a9\u09a8\3\2\2\2"+
		"\u09aa\u0165\3\2\2\2\u09ab\u09ad\5\u00c4c\2\u09ac\u09ae\5\u016e\u00b8"+
		"\2\u09ad\u09ac\3\2\2\2\u09ad\u09ae\3\2\2\2\u09ae\u0167\3\2\2\2\u09af\u09b0"+
		"\7\u011c\2\2\u09b0\u09b2\7\u0113\2\2\u09b1\u09af\3\2\2\2\u09b1\u09b2\3"+
		"\2\2\2\u09b2\u09b3\3\2\2\2\u09b3\u09b4\7\u0110\2\2\u09b4\u0169\3\2\2\2"+
		"\u09b5\u09b6\t\33\2\2\u09b6\u016b\3\2\2\2\u09b7\u09b8\5b\62\2\u09b8\u09b9"+
		"\7\u0113\2\2\u09b9\u09bb\3\2\2\2\u09ba\u09b7\3\2\2\2\u09ba\u09bb\3\2\2"+
		"\2\u09bb\u09bc\3\2\2\2\u09bc\u09bd\5b\62\2\u09bd\u016d\3\2\2\2\u09be\u09c0"+
		"\7\4\2\2\u09bf\u09be\3\2\2\2\u09bf\u09c0\3\2\2\2\u09c0\u09c1\3\2\2\2\u09c1"+
		"\u09c2\5b\62\2\u09c2\u016f\3\2\2\2\u09c3\u09c8\5\u016c\u00b7\2\u09c4\u09c5"+
		"\7\u0105\2\2\u09c5\u09c7\5\u016c\u00b7\2\u09c6\u09c4\3\2\2\2\u09c7\u09ca"+
		"\3\2\2\2\u09c8\u09c6\3\2\2\2\u09c8\u09c9\3\2\2\2\u09c9\u0171\3\2\2\2\u09ca"+
		"\u09c8\3\2\2\2\u09cb\u09cc\5\u0178\u00bd\2\u09cc\u0173\3\2\2\2\u09cd\u09ce"+
		"\5\u0178\u00bd\2\u09ce\u0175\3\2\2\2\u09cf\u09d0\5\u0178\u00bd\2\u09d0"+
		"\u0177\3\2\2\2\u09d1\u09d2\7\u010c\2\2\u09d2\u09d3\5\u014a\u00a6\2\u09d3"+
		"\u09d4\7\u010d\2\2\u09d4\u0179\3\2\2\2\u09d5\u09dc\5\u017c\u00bf\2\u09d6"+
		"\u09dc\5\u0180\u00c1\2\u09d7\u09dc\5\u0184\u00c3\2\u09d8\u09dc\5\u018a"+
		"\u00c6\2\u09d9\u09dc\5\u0192\u00ca\2\u09da\u09dc\5\u019c\u00cf\2\u09db"+
		"\u09d5\3\2\2\2\u09db\u09d6\3\2\2\2\u09db\u09d7\3\2\2\2\u09db\u09d8\3\2"+
		"\2\2\u09db\u09d9\3\2\2\2\u09db\u09da\3\2\2\2\u09dc\u017b\3\2\2\2\u09dd"+
		"\u09de\5\u0108\u0085\2\u09de\u09df\5\u017e\u00c0\2\u09df\u09e0\5\u0108"+
		"\u0085\2\u09e0\u017d\3\2\2\2\u09e1\u09e2\t\34\2\2\u09e2\u017f\3\2\2\2"+
		"\u09e3\u09e4\5\u0108\u0085\2\u09e4\u09e5\5\u0182\u00c2\2\u09e5\u0181\3"+
		"\2\2\2\u09e6\u09e8\7E\2\2\u09e7\u09e6\3\2\2\2\u09e7\u09e8\3\2\2\2\u09e8"+
		"\u09e9\3\2\2\2\u09e9\u09eb\7u\2\2\u09ea\u09ec\t\35\2\2\u09eb\u09ea\3\2"+
		"\2\2\u09eb\u09ec\3\2\2\2\u09ec\u09ed\3\2\2\2\u09ed\u09ee\5\u0108\u0085"+
		"\2\u09ee\u09ef\7\6\2\2\u09ef\u09f0\5\u0108\u0085\2\u09f0\u0183\3\2\2\2"+
		"\u09f1\u09f3\5\u00c8e\2\u09f2\u09f4\7E\2\2\u09f3\u09f2\3\2\2\2\u09f3\u09f4"+
		"\3\2\2\2\u09f4\u09f5\3\2\2\2\u09f5\u09f6\7\63\2\2\u09f6\u09f7\5\u0186"+
		"\u00c4\2\u09f7\u0185\3\2\2\2\u09f8\u09fe\5\u0176\u00bc\2\u09f9\u09fa\7"+
		"\u010c\2\2\u09fa\u09fb\5\u0188\u00c5\2\u09fb\u09fc\7\u010d\2\2\u09fc\u09fe"+
		"\3\2\2\2\u09fd\u09f8\3\2\2\2\u09fd\u09f9\3\2\2\2\u09fe\u0187\3\2\2\2\u09ff"+
		"\u0a04\5\u0102\u0082\2\u0a00\u0a01\7\u0105\2\2\u0a01\u0a03\5\u0102\u0082"+
		"\2\u0a02\u0a00\3\2\2\2\u0a03\u0a06\3\2\2\2\u0a04\u0a02\3\2\2\2\u0a04\u0a05"+
		"\3\2\2\2\u0a05\u0189\3\2\2\2\u0a06\u0a04\3\2\2\2\u0a07\u0a08\5\u0108\u0085"+
		"\2\u0a08\u0a09\5\u018c\u00c7\2\u0a09\u0a0a\7\u011d\2\2\u0a0a\u018b\3\2"+
		"\2\2\u0a0b\u0a0d\7E\2\2\u0a0c\u0a0b\3\2\2\2\u0a0c\u0a0d\3\2\2\2\u0a0d"+
		"\u0a0e\3\2\2\2\u0a0e\u0a11\5\u018e\u00c8\2\u0a0f\u0a11\5\u0190\u00c9\2"+
		"\u0a10\u0a0c\3\2\2\2\u0a10\u0a0f\3\2\2\2\u0a11\u018d\3\2\2\2\u0a12\u0a19"+
		"\7A\2\2\u0a13\u0a19\7\61\2\2\u0a14\u0a15\7\u00be\2\2\u0a15\u0a19\7\u00cc"+
		"\2\2\u0a16\u0a19\7\u00b8\2\2\u0a17\u0a19\7\u00b9\2\2\u0a18\u0a12\3\2\2"+
		"\2\u0a18\u0a13\3\2\2\2\u0a18\u0a14\3\2\2\2\u0a18\u0a16\3\2\2\2\u0a18\u0a17"+
		"\3\2\2\2\u0a19\u018f\3\2\2\2\u0a1a\u0a1b\t\36\2\2\u0a1b\u0191\3\2\2\2"+
		"\u0a1c\u0a1d\5\u0108\u0085\2\u0a1d\u0a1f\7<\2\2\u0a1e\u0a20\7E\2\2\u0a1f"+
		"\u0a1e\3\2\2\2\u0a1f\u0a20\3\2\2\2\u0a20\u0a21\3\2\2\2\u0a21\u0a22\7F"+
		"\2\2\u0a22\u0193\3\2\2\2\u0a23\u0a24\5\u00c8e\2\u0a24\u0a25\5\u017e\u00c0"+
		"\2\u0a25\u0a26\5\u0196\u00cc\2\u0a26\u0a27\5\u0176\u00bc\2\u0a27\u0195"+
		"\3\2\2\2\u0a28\u0a2b\5\u0198\u00cd\2\u0a29\u0a2b\5\u019a\u00ce\2\u0a2a"+
		"\u0a28\3\2\2\2\u0a2a\u0a29\3\2\2\2\u0a2b\u0197\3\2\2\2\u0a2c\u0a2d\7\5"+
		"\2\2\u0a2d\u0199\3\2\2\2\u0a2e\u0a2f\t\37\2\2\u0a2f\u019b\3\2\2\2\u0a30"+
		"\u0a32\7E\2\2\u0a31\u0a30\3\2\2\2\u0a31\u0a32\3\2\2\2\u0a32\u0a33\3\2"+
		"\2\2\u0a33\u0a34\7\u008b\2\2\u0a34\u0a35\5\u0176\u00bc\2\u0a35\u019d\3"+
		"\2\2\2\u0a36\u0a37\7j\2\2\u0a37\u0a38\5\u0176\u00bc\2\u0a38\u019f\3\2"+
		"\2\2\u0a39\u0a3c\5\u01a2\u00d2\2\u0a3a\u0a3c\7\u00bb\2\2\u0a3b\u0a39\3"+
		"\2\2\2\u0a3b\u0a3a\3\2\2\2\u0a3c\u01a1\3\2\2\2\u0a3d\u0a3e\t \2\2\u0a3e"+
		"\u01a3\3\2\2\2\u0a3f\u0a40\t!\2\2\u0a40\u01a5\3\2\2\2\u0a41\u0a42\5\u01aa"+
		"\u00d6\2\u0a42\u0a44\7\u010c\2\2\u0a43\u0a45\5\u01ac\u00d7\2\u0a44\u0a43"+
		"\3\2\2\2\u0a44\u0a45\3\2\2\2\u0a45\u0a46\3\2\2\2\u0a46\u0a47\7\u010d\2"+
		"\2\u0a47\u01a7\3\2\2\2\u0a48\u0a49\t\"\2\2\u0a49\u01a9\3\2\2\2\u0a4a\u0a4d"+
		"\5b\62\2\u0a4b\u0a4d\5\u01a8\u00d5\2\u0a4c\u0a4a\3\2\2\2\u0a4c\u0a4b\3"+
		"\2\2\2\u0a4d\u01ab\3\2\2\2\u0a4e\u0a53\5\u00c4c\2\u0a4f\u0a50\7\u0105"+
		"\2\2\u0a50\u0a52\5\u00c4c\2\u0a51\u0a4f\3\2\2\2\u0a52\u0a55\3\2\2\2\u0a53"+
		"\u0a51\3\2\2\2\u0a53\u0a54\3\2\2\2\u0a54\u01ad\3\2\2\2\u0a55\u0a53\3\2"+
		"\2\2\u0a56\u0a57\7M\2\2\u0a57\u0a58\7v\2\2\u0a58\u0a59\5\u01b0\u00d9\2"+
		"\u0a59\u01af\3\2\2\2\u0a5a\u0a5f\5\u01b2\u00da\2\u0a5b\u0a5c\7\u0105\2"+
		"\2\u0a5c\u0a5e\5\u01b2\u00da\2\u0a5d\u0a5b\3\2\2\2\u0a5e\u0a61\3\2\2\2"+
		"\u0a5f\u0a5d\3\2\2\2\u0a5f\u0a60\3\2\2\2\u0a60\u01b1\3\2\2\2\u0a61\u0a5f"+
		"\3\2\2\2\u0a62\u0a64\5\u0108\u0085\2\u0a63\u0a65\5\u01b4\u00db\2\u0a64"+
		"\u0a63\3\2\2\2\u0a64\u0a65\3\2\2\2\u0a65\u0a67\3\2\2\2\u0a66\u0a68\5\u01b8"+
		"\u00dd\2\u0a67\u0a66\3\2\2\2\u0a67\u0a68\3\2\2\2\u0a68\u01b3\3\2\2\2\u0a69"+
		"\u0a6a\t#\2\2\u0a6a\u01b5\3\2\2\2\u0a6b\u0a6c\7B\2\2\u0a6c\u0a6d\5\u00c8"+
		"e\2\u0a6d\u01b7\3\2\2\2\u0a6e\u0a6f\7F\2\2\u0a6f\u0a73\7\u008f\2\2\u0a70"+
		"\u0a71\7F\2\2\u0a71\u0a73\7\u009d\2\2\u0a72\u0a6e\3\2\2\2\u0a72\u0a70"+
		"\3\2\2\2\u0a73\u01b9\3\2\2\2\u0a74\u0a76\7\u0097\2\2\u0a75\u0a77\7\u00af"+
		"\2\2\u0a76\u0a75\3\2\2\2\u0a76\u0a77\3\2\2\2\u0a77\u0a78\3\2\2\2\u0a78"+
		"\u0a79\79\2\2\u0a79\u0a7e\5\u015e\u00b0\2\u0a7a\u0a7b\7\u010c\2\2\u0a7b"+
		"\u0a7c\5\u012e\u0098\2\u0a7c\u0a7d\7\u010d\2\2\u0a7d\u0a7f\3\2\2\2\u0a7e"+
		"\u0a7a\3\2\2\2\u0a7e\u0a7f\3\2\2\2\u0a7f\u0a80\3\2\2\2\u0a80\u0a81\5\u014a"+
		"\u00a6\2\u0a81\u0a92\3\2\2\2\u0a82\u0a84\7\u0097\2\2\u0a83\u0a85\7\u00af"+
		"\2\2\u0a84\u0a83\3\2\2\2\u0a84\u0a85\3\2\2\2\u0a85\u0a86\3\2\2\2\u0a86"+
		"\u0a87\79\2\2\u0a87\u0a88\7\u00a0\2\2\u0a88\u0a8e\7\u011d\2\2\u0a89\u0a8a"+
		"\7m\2\2\u0a8a\u0a8c\5b\62\2\u0a8b\u0a8d\5<\37\2\u0a8c\u0a8b\3\2\2\2\u0a8c"+
		"\u0a8d\3\2\2\2\u0a8d\u0a8f\3\2\2\2\u0a8e\u0a89\3\2\2\2\u0a8e\u0a8f\3\2"+
		"\2\2\u0a8f\u0a90\3\2\2\2\u0a90\u0a92\5\u014a\u00a6\2\u0a91\u0a74\3\2\2"+
		"\2\u0a91\u0a82\3\2\2\2\u0a92\u01bb\3\2\2\2\u017d\u01be\u01c2\u01cf\u01d7"+
		"\u01db\u01e2\u01e8\u01ef\u01f3\u01f7\u01fb\u01ff\u0203\u020d\u0210\u0214"+
		"\u0218\u021f\u0222\u0226\u0228\u022c\u0234\u023d\u0241\u0243\u0245\u024b"+
		"\u0250\u0256\u025a\u025e\u0262\u026a\u026c\u0274\u0279\u027b\u0280\u0284"+
		"\u0288\u028b\u028f\u0292\u0298\u029c\u02a0\u02a4\u02a6\u02ac\u02b0\u02b4"+
		"\u02b8\u02bb\u02bf\u02c2\u02c4\u02ca\u02ce\u02d0\u02d4\u02d8\u02dc\u02e4"+
		"\u02e8\u02ea\u02f2\u02f6\u02fa\u02fe\u0302\u0306\u0308\u030c\u0310\u0314"+
		"\u031b\u031f\u0323\u0325\u032b\u032f\u0337\u033b\u033d\u0344\u0348\u034c"+
		"\u034e\u0354\u0358\u0360\u0362\u036a\u036e\u0376\u0378\u037f\u0383\u038b"+
		"\u038d\u0392\u039a\u039c\u03a2\u03a6\u03ad\u03b1\u03b5\u03b7\u03be\u03c2"+
		"\u03c9\u03cd\u03d1\u03d3\u03d9\u03dd\u03e5\u03e7\u03ed\u03f1\u03f7\u03fb"+
		"\u0400\u0404\u0409\u040b\u040f\u0413\u0416\u041a\u041f\u0427\u042a\u042e"+
		"\u0432\u043d\u0441\u044b\u044e\u0459\u045c\u045f\u0463\u046a\u046d\u0470"+
		"\u0477\u047b\u0481\u0489\u048e\u0497\u049a\u049d\u04a1\u04a3\u04aa\u04ae"+
		"\u04b2\u04ba\u04be\u04c4\u04d0\u04d4\u04d7\u04db\u04df\u04e5\u04ec\u04f3"+
		"\u04f7\u0501\u0505\u050d\u0514\u0518\u0521\u0528\u052c\u0534\u0538\u053c"+
		"\u0544\u0549\u054e\u0550\u0555\u055b\u055f\u0575\u057a\u057f\u0581\u0586"+
		"\u058c\u0598\u059b\u059f\u05a8\u05b1\u05b3\u05b7\u05bf\u05c2\u05c8\u05d0"+
		"\u05e1\u05f6\u0607\u0614\u0618\u061a\u0627\u062e\u0646\u064d\u065e\u0661"+
		"\u0665\u0668\u066e\u0673\u0678\u0691\u0699\u069d\u06a2\u06a7\u06ab\u06ae"+
		"\u06b7\u06bc\u06c0\u06c6\u06cc\u06d1\u06d5\u06d7\u06db\u06df\u06e1\u06e5"+
		"\u06e9\u06ed\u06f1\u06fc\u0700\u0708\u0712\u0723\u0727\u072b\u0730\u0732"+
		"\u0736\u073b\u073f\u0741\u0745\u0752\u0759\u0765\u0767\u076c\u078e\u0792"+
		"\u0796\u079d\u07a0\u07a8\u07ab\u07be\u07ce\u07d3\u07da\u07e2\u07e6\u07f0"+
		"\u07fa\u07fe\u080e\u0814\u081d\u0824\u082e\u0831\u0834\u083b\u0846\u084e"+
		"\u0854\u0858\u085c\u0864\u0868\u0870\u0878\u087c\u0880\u0883\u0886\u0889"+
		"\u088c\u0896\u089b\u08a1\u08a7\u08af\u08b6\u08bd\u08c5\u08d0\u08d4\u08da"+
		"\u08e6\u08e9\u08ef\u08f3\u08fa\u08fc\u0903\u0916\u091d\u0924\u092b\u0943"+
		"\u094a\u0950\u0954\u0958\u095d\u0962\u0968\u096c\u0970\u0975\u097a\u0981"+
		"\u0985\u098c\u0993\u0995\u0999\u099d\u09a4\u09a9\u09ad\u09b1\u09ba\u09bf"+
		"\u09c8\u09db\u09e7\u09eb\u09f3\u09fd\u0a04\u0a0c\u0a10\u0a18\u0a1f\u0a2a"+
		"\u0a31\u0a3b\u0a44\u0a4c\u0a53\u0a5f\u0a64\u0a67\u0a72\u0a76\u0a7e\u0a84"+
		"\u0a8c\u0a8e\u0a91";
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