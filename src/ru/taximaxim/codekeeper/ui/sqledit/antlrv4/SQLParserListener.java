package ru.taximaxim.codekeeper.ui.sqledit.antlrv4;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SQLParser}.
 */
public interface SQLParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SQLParser#field_type}.
	 * @param ctx the parse tree
	 */
	void enterField_type(@NotNull SQLParser.Field_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#field_type}.
	 * @param ctx the parse tree
	 */
	void exitField_type(@NotNull SQLParser.Field_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#query_expression}.
	 * @param ctx the parse tree
	 */
	void enterQuery_expression(@NotNull SQLParser.Query_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#query_expression}.
	 * @param ctx the parse tree
	 */
	void exitQuery_expression(@NotNull SQLParser.Query_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#scalar_subquery}.
	 * @param ctx the parse tree
	 */
	void enterScalar_subquery(@NotNull SQLParser.Scalar_subqueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#scalar_subquery}.
	 * @param ctx the parse tree
	 */
	void exitScalar_subquery(@NotNull SQLParser.Scalar_subqueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#predicate}.
	 * @param ctx the parse tree
	 */
	void enterPredicate(@NotNull SQLParser.PredicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#predicate}.
	 * @param ctx the parse tree
	 */
	void exitPredicate(@NotNull SQLParser.PredicateContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#aggregate_function}.
	 * @param ctx the parse tree
	 */
	void enterAggregate_function(@NotNull SQLParser.Aggregate_functionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#aggregate_function}.
	 * @param ctx the parse tree
	 */
	void exitAggregate_function(@NotNull SQLParser.Aggregate_functionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#table_reference_list}.
	 * @param ctx the parse tree
	 */
	void enterTable_reference_list(@NotNull SQLParser.Table_reference_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#table_reference_list}.
	 * @param ctx the parse tree
	 */
	void exitTable_reference_list(@NotNull SQLParser.Table_reference_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#rollup_list}.
	 * @param ctx the parse tree
	 */
	void enterRollup_list(@NotNull SQLParser.Rollup_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#rollup_list}.
	 * @param ctx the parse tree
	 */
	void exitRollup_list(@NotNull SQLParser.Rollup_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#pattern_matcher}.
	 * @param ctx the parse tree
	 */
	void enterPattern_matcher(@NotNull SQLParser.Pattern_matcherContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#pattern_matcher}.
	 * @param ctx the parse tree
	 */
	void exitPattern_matcher(@NotNull SQLParser.Pattern_matcherContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#or_predicate}.
	 * @param ctx the parse tree
	 */
	void enterOr_predicate(@NotNull SQLParser.Or_predicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#or_predicate}.
	 * @param ctx the parse tree
	 */
	void exitOr_predicate(@NotNull SQLParser.Or_predicateContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#cube_list}.
	 * @param ctx the parse tree
	 */
	void enterCube_list(@NotNull SQLParser.Cube_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#cube_list}.
	 * @param ctx the parse tree
	 */
	void exitCube_list(@NotNull SQLParser.Cube_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#numeric_type}.
	 * @param ctx the parse tree
	 */
	void enterNumeric_type(@NotNull SQLParser.Numeric_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#numeric_type}.
	 * @param ctx the parse tree
	 */
	void exitNumeric_type(@NotNull SQLParser.Numeric_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#schema_statement}.
	 * @param ctx the parse tree
	 */
	void enterSchema_statement(@NotNull SQLParser.Schema_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#schema_statement}.
	 * @param ctx the parse tree
	 */
	void exitSchema_statement(@NotNull SQLParser.Schema_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#row_value_special_case}.
	 * @param ctx the parse tree
	 */
	void enterRow_value_special_case(@NotNull SQLParser.Row_value_special_caseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#row_value_special_case}.
	 * @param ctx the parse tree
	 */
	void exitRow_value_special_case(@NotNull SQLParser.Row_value_special_caseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#binary_type}.
	 * @param ctx the parse tree
	 */
	void enterBinary_type(@NotNull SQLParser.Binary_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#binary_type}.
	 * @param ctx the parse tree
	 */
	void exitBinary_type(@NotNull SQLParser.Binary_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#explicit_row_value_constructor}.
	 * @param ctx the parse tree
	 */
	void enterExplicit_row_value_constructor(@NotNull SQLParser.Explicit_row_value_constructorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#explicit_row_value_constructor}.
	 * @param ctx the parse tree
	 */
	void exitExplicit_row_value_constructor(@NotNull SQLParser.Explicit_row_value_constructorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#time_literal}.
	 * @param ctx the parse tree
	 */
	void enterTime_literal(@NotNull SQLParser.Time_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#time_literal}.
	 * @param ctx the parse tree
	 */
	void exitTime_literal(@NotNull SQLParser.Time_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#row_value_constructor_predicand}.
	 * @param ctx the parse tree
	 */
	void enterRow_value_constructor_predicand(@NotNull SQLParser.Row_value_constructor_predicandContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#row_value_constructor_predicand}.
	 * @param ctx the parse tree
	 */
	void exitRow_value_constructor_predicand(@NotNull SQLParser.Row_value_constructor_predicandContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#bit_type}.
	 * @param ctx the parse tree
	 */
	void enterBit_type(@NotNull SQLParser.Bit_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#bit_type}.
	 * @param ctx the parse tree
	 */
	void exitBit_type(@NotNull SQLParser.Bit_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#precision_param}.
	 * @param ctx the parse tree
	 */
	void enterPrecision_param(@NotNull SQLParser.Precision_paramContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#precision_param}.
	 * @param ctx the parse tree
	 */
	void exitPrecision_param(@NotNull SQLParser.Precision_paramContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#drop_table_statement}.
	 * @param ctx the parse tree
	 */
	void enterDrop_table_statement(@NotNull SQLParser.Drop_table_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#drop_table_statement}.
	 * @param ctx the parse tree
	 */
	void exitDrop_table_statement(@NotNull SQLParser.Drop_table_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#limit_clause}.
	 * @param ctx the parse tree
	 */
	void enterLimit_clause(@NotNull SQLParser.Limit_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#limit_clause}.
	 * @param ctx the parse tree
	 */
	void exitLimit_clause(@NotNull SQLParser.Limit_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#from_clause}.
	 * @param ctx the parse tree
	 */
	void enterFrom_clause(@NotNull SQLParser.From_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#from_clause}.
	 * @param ctx the parse tree
	 */
	void exitFrom_clause(@NotNull SQLParser.From_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#in_predicate_value}.
	 * @param ctx the parse tree
	 */
	void enterIn_predicate_value(@NotNull SQLParser.In_predicate_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#in_predicate_value}.
	 * @param ctx the parse tree
	 */
	void exitIn_predicate_value(@NotNull SQLParser.In_predicate_valueContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#individual_hash_partition}.
	 * @param ctx the parse tree
	 */
	void enterIndividual_hash_partition(@NotNull SQLParser.Individual_hash_partitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#individual_hash_partition}.
	 * @param ctx the parse tree
	 */
	void exitIndividual_hash_partition(@NotNull SQLParser.Individual_hash_partitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#column_partitions}.
	 * @param ctx the parse tree
	 */
	void enterColumn_partitions(@NotNull SQLParser.Column_partitionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#column_partitions}.
	 * @param ctx the parse tree
	 */
	void exitColumn_partitions(@NotNull SQLParser.Column_partitionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#boolean_test}.
	 * @param ctx the parse tree
	 */
	void enterBoolean_test(@NotNull SQLParser.Boolean_testContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#boolean_test}.
	 * @param ctx the parse tree
	 */
	void exitBoolean_test(@NotNull SQLParser.Boolean_testContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#exists_predicate}.
	 * @param ctx the parse tree
	 */
	void enterExists_predicate(@NotNull SQLParser.Exists_predicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#exists_predicate}.
	 * @param ctx the parse tree
	 */
	void exitExists_predicate(@NotNull SQLParser.Exists_predicateContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#character_factor}.
	 * @param ctx the parse tree
	 */
	void enterCharacter_factor(@NotNull SQLParser.Character_factorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#character_factor}.
	 * @param ctx the parse tree
	 */
	void exitCharacter_factor(@NotNull SQLParser.Character_factorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#named_columns_join}.
	 * @param ctx the parse tree
	 */
	void enterNamed_columns_join(@NotNull SQLParser.Named_columns_joinContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#named_columns_join}.
	 * @param ctx the parse tree
	 */
	void exitNamed_columns_join(@NotNull SQLParser.Named_columns_joinContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#pattern_matching_predicate}.
	 * @param ctx the parse tree
	 */
	void enterPattern_matching_predicate(@NotNull SQLParser.Pattern_matching_predicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#pattern_matching_predicate}.
	 * @param ctx the parse tree
	 */
	void exitPattern_matching_predicate(@NotNull SQLParser.Pattern_matching_predicateContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#array}.
	 * @param ctx the parse tree
	 */
	void enterArray(@NotNull SQLParser.ArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#array}.
	 * @param ctx the parse tree
	 */
	void exitArray(@NotNull SQLParser.ArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#unsigned_value_specification}.
	 * @param ctx the parse tree
	 */
	void enterUnsigned_value_specification(@NotNull SQLParser.Unsigned_value_specificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#unsigned_value_specification}.
	 * @param ctx the parse tree
	 */
	void exitUnsigned_value_specification(@NotNull SQLParser.Unsigned_value_specificationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#network_type}.
	 * @param ctx the parse tree
	 */
	void enterNetwork_type(@NotNull SQLParser.Network_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#network_type}.
	 * @param ctx the parse tree
	 */
	void exitNetwork_type(@NotNull SQLParser.Network_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParam(@NotNull SQLParser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParam(@NotNull SQLParser.ParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#simple_table}.
	 * @param ctx the parse tree
	 */
	void enterSimple_table(@NotNull SQLParser.Simple_tableContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#simple_table}.
	 * @param ctx the parse tree
	 */
	void exitSimple_table(@NotNull SQLParser.Simple_tableContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#param_clause}.
	 * @param ctx the parse tree
	 */
	void enterParam_clause(@NotNull SQLParser.Param_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#param_clause}.
	 * @param ctx the parse tree
	 */
	void exitParam_clause(@NotNull SQLParser.Param_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#derived_table}.
	 * @param ctx the parse tree
	 */
	void enterDerived_table(@NotNull SQLParser.Derived_tableContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#derived_table}.
	 * @param ctx the parse tree
	 */
	void exitDerived_table(@NotNull SQLParser.Derived_tableContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#having_clause}.
	 * @param ctx the parse tree
	 */
	void enterHaving_clause(@NotNull SQLParser.Having_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#having_clause}.
	 * @param ctx the parse tree
	 */
	void exitHaving_clause(@NotNull SQLParser.Having_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#character_string_type}.
	 * @param ctx the parse tree
	 */
	void enterCharacter_string_type(@NotNull SQLParser.Character_string_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#character_string_type}.
	 * @param ctx the parse tree
	 */
	void exitCharacter_string_type(@NotNull SQLParser.Character_string_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#set_function_type}.
	 * @param ctx the parse tree
	 */
	void enterSet_function_type(@NotNull SQLParser.Set_function_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#set_function_type}.
	 * @param ctx the parse tree
	 */
	void exitSet_function_type(@NotNull SQLParser.Set_function_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#argmode}.
	 * @param ctx the parse tree
	 */
	void enterArgmode(@NotNull SQLParser.ArgmodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#argmode}.
	 * @param ctx the parse tree
	 */
	void exitArgmode(@NotNull SQLParser.ArgmodeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#parenthesized_boolean_value_expression}.
	 * @param ctx the parse tree
	 */
	void enterParenthesized_boolean_value_expression(@NotNull SQLParser.Parenthesized_boolean_value_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#parenthesized_boolean_value_expression}.
	 * @param ctx the parse tree
	 */
	void exitParenthesized_boolean_value_expression(@NotNull SQLParser.Parenthesized_boolean_value_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#extended_datetime_field}.
	 * @param ctx the parse tree
	 */
	void enterExtended_datetime_field(@NotNull SQLParser.Extended_datetime_fieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#extended_datetime_field}.
	 * @param ctx the parse tree
	 */
	void exitExtended_datetime_field(@NotNull SQLParser.Extended_datetime_fieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#comp_op}.
	 * @param ctx the parse tree
	 */
	void enterComp_op(@NotNull SQLParser.Comp_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#comp_op}.
	 * @param ctx the parse tree
	 */
	void exitComp_op(@NotNull SQLParser.Comp_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#joined_table}.
	 * @param ctx the parse tree
	 */
	void enterJoined_table(@NotNull SQLParser.Joined_tableContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#joined_table}.
	 * @param ctx the parse tree
	 */
	void exitJoined_table(@NotNull SQLParser.Joined_tableContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(@NotNull SQLParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(@NotNull SQLParser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#case_expression}.
	 * @param ctx the parse tree
	 */
	void enterCase_expression(@NotNull SQLParser.Case_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#case_expression}.
	 * @param ctx the parse tree
	 */
	void exitCase_expression(@NotNull SQLParser.Case_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#select_list}.
	 * @param ctx the parse tree
	 */
	void enterSelect_list(@NotNull SQLParser.Select_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#select_list}.
	 * @param ctx the parse tree
	 */
	void exitSelect_list(@NotNull SQLParser.Select_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#character_value_expression}.
	 * @param ctx the parse tree
	 */
	void enterCharacter_value_expression(@NotNull SQLParser.Character_value_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#character_value_expression}.
	 * @param ctx the parse tree
	 */
	void exitCharacter_value_expression(@NotNull SQLParser.Character_value_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#set_statement}.
	 * @param ctx the parse tree
	 */
	void enterSet_statement(@NotNull SQLParser.Set_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#set_statement}.
	 * @param ctx the parse tree
	 */
	void exitSet_statement(@NotNull SQLParser.Set_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#sort_specifier_list}.
	 * @param ctx the parse tree
	 */
	void enterSort_specifier_list(@NotNull SQLParser.Sort_specifier_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#sort_specifier_list}.
	 * @param ctx the parse tree
	 */
	void exitSort_specifier_list(@NotNull SQLParser.Sort_specifier_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#general_literal}.
	 * @param ctx the parse tree
	 */
	void enterGeneral_literal(@NotNull SQLParser.General_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#general_literal}.
	 * @param ctx the parse tree
	 */
	void exitGeneral_literal(@NotNull SQLParser.General_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#ordinary_grouping_set}.
	 * @param ctx the parse tree
	 */
	void enterOrdinary_grouping_set(@NotNull SQLParser.Ordinary_grouping_setContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#ordinary_grouping_set}.
	 * @param ctx the parse tree
	 */
	void exitOrdinary_grouping_set(@NotNull SQLParser.Ordinary_grouping_setContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#time_zone_field}.
	 * @param ctx the parse tree
	 */
	void enterTime_zone_field(@NotNull SQLParser.Time_zone_fieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#time_zone_field}.
	 * @param ctx the parse tree
	 */
	void exitTime_zone_field(@NotNull SQLParser.Time_zone_fieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#cast_target}.
	 * @param ctx the parse tree
	 */
	void enterCast_target(@NotNull SQLParser.Cast_targetContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#cast_target}.
	 * @param ctx the parse tree
	 */
	void exitCast_target(@NotNull SQLParser.Cast_targetContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#individual_hash_partitions}.
	 * @param ctx the parse tree
	 */
	void enterIndividual_hash_partitions(@NotNull SQLParser.Individual_hash_partitionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#individual_hash_partitions}.
	 * @param ctx the parse tree
	 */
	void exitIndividual_hash_partitions(@NotNull SQLParser.Individual_hash_partitionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#column_reference_list}.
	 * @param ctx the parse tree
	 */
	void enterColumn_reference_list(@NotNull SQLParser.Column_reference_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#column_reference_list}.
	 * @param ctx the parse tree
	 */
	void exitColumn_reference_list(@NotNull SQLParser.Column_reference_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#data_statement}.
	 * @param ctx the parse tree
	 */
	void enterData_statement(@NotNull SQLParser.Data_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#data_statement}.
	 * @param ctx the parse tree
	 */
	void exitData_statement(@NotNull SQLParser.Data_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#table_expression}.
	 * @param ctx the parse tree
	 */
	void enterTable_expression(@NotNull SQLParser.Table_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#table_expression}.
	 * @param ctx the parse tree
	 */
	void exitTable_expression(@NotNull SQLParser.Table_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#string_value_function}.
	 * @param ctx the parse tree
	 */
	void enterString_value_function(@NotNull SQLParser.String_value_functionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#string_value_function}.
	 * @param ctx the parse tree
	 */
	void exitString_value_function(@NotNull SQLParser.String_value_functionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#derived_column}.
	 * @param ctx the parse tree
	 */
	void enterDerived_column(@NotNull SQLParser.Derived_columnContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#derived_column}.
	 * @param ctx the parse tree
	 */
	void exitDerived_column(@NotNull SQLParser.Derived_columnContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#query_term}.
	 * @param ctx the parse tree
	 */
	void enterQuery_term(@NotNull SQLParser.Query_termContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#query_term}.
	 * @param ctx the parse tree
	 */
	void exitQuery_term(@NotNull SQLParser.Query_termContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#insert_statement}.
	 * @param ctx the parse tree
	 */
	void enterInsert_statement(@NotNull SQLParser.Insert_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#insert_statement}.
	 * @param ctx the parse tree
	 */
	void exitInsert_statement(@NotNull SQLParser.Insert_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#join_type}.
	 * @param ctx the parse tree
	 */
	void enterJoin_type(@NotNull SQLParser.Join_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#join_type}.
	 * @param ctx the parse tree
	 */
	void exitJoin_type(@NotNull SQLParser.Join_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#join_specification}.
	 * @param ctx the parse tree
	 */
	void enterJoin_specification(@NotNull SQLParser.Join_specificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#join_specification}.
	 * @param ctx the parse tree
	 */
	void exitJoin_specification(@NotNull SQLParser.Join_specificationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#data_type}.
	 * @param ctx the parse tree
	 */
	void enterData_type(@NotNull SQLParser.Data_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#data_type}.
	 * @param ctx the parse tree
	 */
	void exitData_type(@NotNull SQLParser.Data_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#grouping_element_list}.
	 * @param ctx the parse tree
	 */
	void enterGrouping_element_list(@NotNull SQLParser.Grouping_element_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#grouping_element_list}.
	 * @param ctx the parse tree
	 */
	void exitGrouping_element_list(@NotNull SQLParser.Grouping_element_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#cast_operand}.
	 * @param ctx the parse tree
	 */
	void enterCast_operand(@NotNull SQLParser.Cast_operandContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#cast_operand}.
	 * @param ctx the parse tree
	 */
	void exitCast_operand(@NotNull SQLParser.Cast_operandContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#function_name}.
	 * @param ctx the parse tree
	 */
	void enterFunction_name(@NotNull SQLParser.Function_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#function_name}.
	 * @param ctx the parse tree
	 */
	void exitFunction_name(@NotNull SQLParser.Function_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#query_expression_body}.
	 * @param ctx the parse tree
	 */
	void enterQuery_expression_body(@NotNull SQLParser.Query_expression_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#query_expression_body}.
	 * @param ctx the parse tree
	 */
	void exitQuery_expression_body(@NotNull SQLParser.Query_expression_bodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#datetime_literal}.
	 * @param ctx the parse tree
	 */
	void enterDatetime_literal(@NotNull SQLParser.Datetime_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#datetime_literal}.
	 * @param ctx the parse tree
	 */
	void exitDatetime_literal(@NotNull SQLParser.Datetime_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#boolean_factor}.
	 * @param ctx the parse tree
	 */
	void enterBoolean_factor(@NotNull SQLParser.Boolean_factorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#boolean_factor}.
	 * @param ctx the parse tree
	 */
	void exitBoolean_factor(@NotNull SQLParser.Boolean_factorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#query_primary}.
	 * @param ctx the parse tree
	 */
	void enterQuery_primary(@NotNull SQLParser.Query_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#query_primary}.
	 * @param ctx the parse tree
	 */
	void exitQuery_primary(@NotNull SQLParser.Query_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#routine_invocation}.
	 * @param ctx the parse tree
	 */
	void enterRoutine_invocation(@NotNull SQLParser.Routine_invocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#routine_invocation}.
	 * @param ctx the parse tree
	 */
	void exitRoutine_invocation(@NotNull SQLParser.Routine_invocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#numeric_value_expression}.
	 * @param ctx the parse tree
	 */
	void enterNumeric_value_expression(@NotNull SQLParser.Numeric_value_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#numeric_value_expression}.
	 * @param ctx the parse tree
	 */
	void exitNumeric_value_expression(@NotNull SQLParser.Numeric_value_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#joined_table_primary}.
	 * @param ctx the parse tree
	 */
	void enterJoined_table_primary(@NotNull SQLParser.Joined_table_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#joined_table_primary}.
	 * @param ctx the parse tree
	 */
	void exitJoined_table_primary(@NotNull SQLParser.Joined_table_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#non_join_query_expression}.
	 * @param ctx the parse tree
	 */
	void enterNon_join_query_expression(@NotNull SQLParser.Non_join_query_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#non_join_query_expression}.
	 * @param ctx the parse tree
	 */
	void exitNon_join_query_expression(@NotNull SQLParser.Non_join_query_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#column_name_list}.
	 * @param ctx the parse tree
	 */
	void enterColumn_name_list(@NotNull SQLParser.Column_name_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#column_name_list}.
	 * @param ctx the parse tree
	 */
	void exitColumn_name_list(@NotNull SQLParser.Column_name_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#sign}.
	 * @param ctx the parse tree
	 */
	void enterSign(@NotNull SQLParser.SignContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#sign}.
	 * @param ctx the parse tree
	 */
	void exitSign(@NotNull SQLParser.SignContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#value_expression_primary}.
	 * @param ctx the parse tree
	 */
	void enterValue_expression_primary(@NotNull SQLParser.Value_expression_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#value_expression_primary}.
	 * @param ctx the parse tree
	 */
	void exitValue_expression_primary(@NotNull SQLParser.Value_expression_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#create_trigger_statement}.
	 * @param ctx the parse tree
	 */
	void enterCreate_trigger_statement(@NotNull SQLParser.Create_trigger_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#create_trigger_statement}.
	 * @param ctx the parse tree
	 */
	void exitCreate_trigger_statement(@NotNull SQLParser.Create_trigger_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#range_partitions}.
	 * @param ctx the parse tree
	 */
	void enterRange_partitions(@NotNull SQLParser.Range_partitionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#range_partitions}.
	 * @param ctx the parse tree
	 */
	void exitRange_partitions(@NotNull SQLParser.Range_partitionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#comparison_predicate}.
	 * @param ctx the parse tree
	 */
	void enterComparison_predicate(@NotNull SQLParser.Comparison_predicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#comparison_predicate}.
	 * @param ctx the parse tree
	 */
	void exitComparison_predicate(@NotNull SQLParser.Comparison_predicateContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#case_specification}.
	 * @param ctx the parse tree
	 */
	void enterCase_specification(@NotNull SQLParser.Case_specificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#case_specification}.
	 * @param ctx the parse tree
	 */
	void exitCase_specification(@NotNull SQLParser.Case_specificationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#binary_large_object_string_type}.
	 * @param ctx the parse tree
	 */
	void enterBinary_large_object_string_type(@NotNull SQLParser.Binary_large_object_string_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#binary_large_object_string_type}.
	 * @param ctx the parse tree
	 */
	void exitBinary_large_object_string_type(@NotNull SQLParser.Binary_large_object_string_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#in_predicate}.
	 * @param ctx the parse tree
	 */
	void enterIn_predicate(@NotNull SQLParser.In_predicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#in_predicate}.
	 * @param ctx the parse tree
	 */
	void exitIn_predicate(@NotNull SQLParser.In_predicateContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#outer_join_type}.
	 * @param ctx the parse tree
	 */
	void enterOuter_join_type(@NotNull SQLParser.Outer_join_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#outer_join_type}.
	 * @param ctx the parse tree
	 */
	void exitOuter_join_type(@NotNull SQLParser.Outer_join_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#string_value_expression}.
	 * @param ctx the parse tree
	 */
	void enterString_value_expression(@NotNull SQLParser.String_value_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#string_value_expression}.
	 * @param ctx the parse tree
	 */
	void exitString_value_expression(@NotNull SQLParser.String_value_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(@NotNull SQLParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(@NotNull SQLParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#result}.
	 * @param ctx the parse tree
	 */
	void enterResult(@NotNull SQLParser.ResultContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#result}.
	 * @param ctx the parse tree
	 */
	void exitResult(@NotNull SQLParser.ResultContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#boolean_literal}.
	 * @param ctx the parse tree
	 */
	void enterBoolean_literal(@NotNull SQLParser.Boolean_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#boolean_literal}.
	 * @param ctx the parse tree
	 */
	void exitBoolean_literal(@NotNull SQLParser.Boolean_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#common_value_expression}.
	 * @param ctx the parse tree
	 */
	void enterCommon_value_expression(@NotNull SQLParser.Common_value_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#common_value_expression}.
	 * @param ctx the parse tree
	 */
	void exitCommon_value_expression(@NotNull SQLParser.Common_value_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#boolean_type}.
	 * @param ctx the parse tree
	 */
	void enterBoolean_type(@NotNull SQLParser.Boolean_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#boolean_type}.
	 * @param ctx the parse tree
	 */
	void exitBoolean_type(@NotNull SQLParser.Boolean_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#table_reference}.
	 * @param ctx the parse tree
	 */
	void enterTable_reference(@NotNull SQLParser.Table_referenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#table_reference}.
	 * @param ctx the parse tree
	 */
	void exitTable_reference(@NotNull SQLParser.Table_referenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#table_or_query_name}.
	 * @param ctx the parse tree
	 */
	void enterTable_or_query_name(@NotNull SQLParser.Table_or_query_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#table_or_query_name}.
	 * @param ctx the parse tree
	 */
	void exitTable_or_query_name(@NotNull SQLParser.Table_or_query_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#case_abbreviation}.
	 * @param ctx the parse tree
	 */
	void enterCase_abbreviation(@NotNull SQLParser.Case_abbreviationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#case_abbreviation}.
	 * @param ctx the parse tree
	 */
	void exitCase_abbreviation(@NotNull SQLParser.Case_abbreviationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#empty_grouping_set}.
	 * @param ctx the parse tree
	 */
	void enterEmpty_grouping_set(@NotNull SQLParser.Empty_grouping_setContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#empty_grouping_set}.
	 * @param ctx the parse tree
	 */
	void exitEmpty_grouping_set(@NotNull SQLParser.Empty_grouping_setContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#null_predicate}.
	 * @param ctx the parse tree
	 */
	void enterNull_predicate(@NotNull SQLParser.Null_predicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#null_predicate}.
	 * @param ctx the parse tree
	 */
	void exitNull_predicate(@NotNull SQLParser.Null_predicateContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#order_specification}.
	 * @param ctx the parse tree
	 */
	void enterOrder_specification(@NotNull SQLParser.Order_specificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#order_specification}.
	 * @param ctx the parse tree
	 */
	void exitOrder_specification(@NotNull SQLParser.Order_specificationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#parenthesized_value_expression}.
	 * @param ctx the parse tree
	 */
	void enterParenthesized_value_expression(@NotNull SQLParser.Parenthesized_value_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#parenthesized_value_expression}.
	 * @param ctx the parse tree
	 */
	void exitParenthesized_value_expression(@NotNull SQLParser.Parenthesized_value_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#simple_when_clause}.
	 * @param ctx the parse tree
	 */
	void enterSimple_when_clause(@NotNull SQLParser.Simple_when_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#simple_when_clause}.
	 * @param ctx the parse tree
	 */
	void exitSimple_when_clause(@NotNull SQLParser.Simple_when_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#list_value_clause_list}.
	 * @param ctx the parse tree
	 */
	void enterList_value_clause_list(@NotNull SQLParser.List_value_clause_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#list_value_clause_list}.
	 * @param ctx the parse tree
	 */
	void exitList_value_clause_list(@NotNull SQLParser.List_value_clause_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#filter_clause}.
	 * @param ctx the parse tree
	 */
	void enterFilter_clause(@NotNull SQLParser.Filter_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#filter_clause}.
	 * @param ctx the parse tree
	 */
	void exitFilter_clause(@NotNull SQLParser.Filter_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#orderby_clause}.
	 * @param ctx the parse tree
	 */
	void enterOrderby_clause(@NotNull SQLParser.Orderby_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#orderby_clause}.
	 * @param ctx the parse tree
	 */
	void exitOrderby_clause(@NotNull SQLParser.Orderby_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#all}.
	 * @param ctx the parse tree
	 */
	void enterAll(@NotNull SQLParser.AllContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#all}.
	 * @param ctx the parse tree
	 */
	void exitAll(@NotNull SQLParser.AllContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#data_change_statement}.
	 * @param ctx the parse tree
	 */
	void enterData_change_statement(@NotNull SQLParser.Data_change_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#data_change_statement}.
	 * @param ctx the parse tree
	 */
	void exitData_change_statement(@NotNull SQLParser.Data_change_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#where_clause}.
	 * @param ctx the parse tree
	 */
	void enterWhere_clause(@NotNull SQLParser.Where_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#where_clause}.
	 * @param ctx the parse tree
	 */
	void exitWhere_clause(@NotNull SQLParser.Where_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#field_element}.
	 * @param ctx the parse tree
	 */
	void enterField_element(@NotNull SQLParser.Field_elementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#field_element}.
	 * @param ctx the parse tree
	 */
	void exitField_element(@NotNull SQLParser.Field_elementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#non_join_query_term}.
	 * @param ctx the parse tree
	 */
	void enterNon_join_query_term(@NotNull SQLParser.Non_join_query_termContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#non_join_query_term}.
	 * @param ctx the parse tree
	 */
	void exitNon_join_query_term(@NotNull SQLParser.Non_join_query_termContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#null_ordering}.
	 * @param ctx the parse tree
	 */
	void enterNull_ordering(@NotNull SQLParser.Null_orderingContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#null_ordering}.
	 * @param ctx the parse tree
	 */
	void exitNull_ordering(@NotNull SQLParser.Null_orderingContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#non_second_primary_datetime_field}.
	 * @param ctx the parse tree
	 */
	void enterNon_second_primary_datetime_field(@NotNull SQLParser.Non_second_primary_datetime_fieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#non_second_primary_datetime_field}.
	 * @param ctx the parse tree
	 */
	void exitNon_second_primary_datetime_field(@NotNull SQLParser.Non_second_primary_datetime_fieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#value_expression}.
	 * @param ctx the parse tree
	 */
	void enterValue_expression(@NotNull SQLParser.Value_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#value_expression}.
	 * @param ctx the parse tree
	 */
	void exitValue_expression(@NotNull SQLParser.Value_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#ordinary_grouping_set_list}.
	 * @param ctx the parse tree
	 */
	void enterOrdinary_grouping_set_list(@NotNull SQLParser.Ordinary_grouping_set_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#ordinary_grouping_set_list}.
	 * @param ctx the parse tree
	 */
	void exitOrdinary_grouping_set_list(@NotNull SQLParser.Ordinary_grouping_set_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#join_condition}.
	 * @param ctx the parse tree
	 */
	void enterJoin_condition(@NotNull SQLParser.Join_conditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#join_condition}.
	 * @param ctx the parse tree
	 */
	void exitJoin_condition(@NotNull SQLParser.Join_conditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#negativable_matcher}.
	 * @param ctx the parse tree
	 */
	void enterNegativable_matcher(@NotNull SQLParser.Negativable_matcherContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#negativable_matcher}.
	 * @param ctx the parse tree
	 */
	void exitNegativable_matcher(@NotNull SQLParser.Negativable_matcherContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#qualified_asterisk}.
	 * @param ctx the parse tree
	 */
	void enterQualified_asterisk(@NotNull SQLParser.Qualified_asteriskContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#qualified_asterisk}.
	 * @param ctx the parse tree
	 */
	void exitQualified_asterisk(@NotNull SQLParser.Qualified_asteriskContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#general_set_function}.
	 * @param ctx the parse tree
	 */
	void enterGeneral_set_function(@NotNull SQLParser.General_set_functionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#general_set_function}.
	 * @param ctx the parse tree
	 */
	void exitGeneral_set_function(@NotNull SQLParser.General_set_functionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#non_join_query_primary}.
	 * @param ctx the parse tree
	 */
	void enterNon_join_query_primary(@NotNull SQLParser.Non_join_query_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#non_join_query_primary}.
	 * @param ctx the parse tree
	 */
	void exitNon_join_query_primary(@NotNull SQLParser.Non_join_query_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#quantifier}.
	 * @param ctx the parse tree
	 */
	void enterQuantifier(@NotNull SQLParser.QuantifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#quantifier}.
	 * @param ctx the parse tree
	 */
	void exitQuantifier(@NotNull SQLParser.QuantifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#index_statement}.
	 * @param ctx the parse tree
	 */
	void enterIndex_statement(@NotNull SQLParser.Index_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#index_statement}.
	 * @param ctx the parse tree
	 */
	void exitIndex_statement(@NotNull SQLParser.Index_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#primary_datetime_field}.
	 * @param ctx the parse tree
	 */
	void enterPrimary_datetime_field(@NotNull SQLParser.Primary_datetime_fieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#primary_datetime_field}.
	 * @param ctx the parse tree
	 */
	void exitPrimary_datetime_field(@NotNull SQLParser.Primary_datetime_fieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#between_predicate}.
	 * @param ctx the parse tree
	 */
	void enterBetween_predicate(@NotNull SQLParser.Between_predicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#between_predicate}.
	 * @param ctx the parse tree
	 */
	void exitBetween_predicate(@NotNull SQLParser.Between_predicateContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#signed_numerical_literal}.
	 * @param ctx the parse tree
	 */
	void enterSigned_numerical_literal(@NotNull SQLParser.Signed_numerical_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#signed_numerical_literal}.
	 * @param ctx the parse tree
	 */
	void exitSigned_numerical_literal(@NotNull SQLParser.Signed_numerical_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#natural_join}.
	 * @param ctx the parse tree
	 */
	void enterNatural_join(@NotNull SQLParser.Natural_joinContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#natural_join}.
	 * @param ctx the parse tree
	 */
	void exitNatural_join(@NotNull SQLParser.Natural_joinContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#sql_argument_list}.
	 * @param ctx the parse tree
	 */
	void enterSql_argument_list(@NotNull SQLParser.Sql_argument_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#sql_argument_list}.
	 * @param ctx the parse tree
	 */
	void exitSql_argument_list(@NotNull SQLParser.Sql_argument_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#unique_predicate}.
	 * @param ctx the parse tree
	 */
	void enterUnique_predicate(@NotNull SQLParser.Unique_predicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#unique_predicate}.
	 * @param ctx the parse tree
	 */
	void exitUnique_predicate(@NotNull SQLParser.Unique_predicateContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#and_predicate}.
	 * @param ctx the parse tree
	 */
	void enterAnd_predicate(@NotNull SQLParser.And_predicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#and_predicate}.
	 * @param ctx the parse tree
	 */
	void exitAnd_predicate(@NotNull SQLParser.And_predicateContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#query_specification}.
	 * @param ctx the parse tree
	 */
	void enterQuery_specification(@NotNull SQLParser.Query_specificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#query_specification}.
	 * @param ctx the parse tree
	 */
	void exitQuery_specification(@NotNull SQLParser.Query_specificationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#extract_expression}.
	 * @param ctx the parse tree
	 */
	void enterExtract_expression(@NotNull SQLParser.Extract_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#extract_expression}.
	 * @param ctx the parse tree
	 */
	void exitExtract_expression(@NotNull SQLParser.Extract_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#grouping_element}.
	 * @param ctx the parse tree
	 */
	void enterGrouping_element(@NotNull SQLParser.Grouping_elementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#grouping_element}.
	 * @param ctx the parse tree
	 */
	void exitGrouping_element(@NotNull SQLParser.Grouping_elementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#nonreserved_keywords}.
	 * @param ctx the parse tree
	 */
	void enterNonreserved_keywords(@NotNull SQLParser.Nonreserved_keywordsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#nonreserved_keywords}.
	 * @param ctx the parse tree
	 */
	void exitNonreserved_keywords(@NotNull SQLParser.Nonreserved_keywordsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#set_function_specification}.
	 * @param ctx the parse tree
	 */
	void enterSet_function_specification(@NotNull SQLParser.Set_function_specificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#set_function_specification}.
	 * @param ctx the parse tree
	 */
	void exitSet_function_specification(@NotNull SQLParser.Set_function_specificationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#some}.
	 * @param ctx the parse tree
	 */
	void enterSome(@NotNull SQLParser.SomeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#some}.
	 * @param ctx the parse tree
	 */
	void exitSome(@NotNull SQLParser.SomeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#truth_value}.
	 * @param ctx the parse tree
	 */
	void enterTruth_value(@NotNull SQLParser.Truth_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#truth_value}.
	 * @param ctx the parse tree
	 */
	void exitTruth_value(@NotNull SQLParser.Truth_valueContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#datetime_type}.
	 * @param ctx the parse tree
	 */
	void enterDatetime_type(@NotNull SQLParser.Datetime_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#datetime_type}.
	 * @param ctx the parse tree
	 */
	void exitDatetime_type(@NotNull SQLParser.Datetime_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#create_extension_statement}.
	 * @param ctx the parse tree
	 */
	void enterCreate_extension_statement(@NotNull SQLParser.Create_extension_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#create_extension_statement}.
	 * @param ctx the parse tree
	 */
	void exitCreate_extension_statement(@NotNull SQLParser.Create_extension_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#set_qualifier}.
	 * @param ctx the parse tree
	 */
	void enterSet_qualifier(@NotNull SQLParser.Set_qualifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#set_qualifier}.
	 * @param ctx the parse tree
	 */
	void exitSet_qualifier(@NotNull SQLParser.Set_qualifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#explicit_table}.
	 * @param ctx the parse tree
	 */
	void enterExplicit_table(@NotNull SQLParser.Explicit_tableContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#explicit_table}.
	 * @param ctx the parse tree
	 */
	void exitExplicit_table(@NotNull SQLParser.Explicit_tableContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#grant_to_rule}.
	 * @param ctx the parse tree
	 */
	void enterGrant_to_rule(@NotNull SQLParser.Grant_to_ruleContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#grant_to_rule}.
	 * @param ctx the parse tree
	 */
	void exitGrant_to_rule(@NotNull SQLParser.Grant_to_ruleContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#unsigned_numeric_literal}.
	 * @param ctx the parse tree
	 */
	void enterUnsigned_numeric_literal(@NotNull SQLParser.Unsigned_numeric_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#unsigned_numeric_literal}.
	 * @param ctx the parse tree
	 */
	void exitUnsigned_numeric_literal(@NotNull SQLParser.Unsigned_numeric_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#boolean_predicand}.
	 * @param ctx the parse tree
	 */
	void enterBoolean_predicand(@NotNull SQLParser.Boolean_predicandContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#boolean_predicand}.
	 * @param ctx the parse tree
	 */
	void exitBoolean_predicand(@NotNull SQLParser.Boolean_predicandContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#search_condition}.
	 * @param ctx the parse tree
	 */
	void enterSearch_condition(@NotNull SQLParser.Search_conditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#search_condition}.
	 * @param ctx the parse tree
	 */
	void exitSearch_condition(@NotNull SQLParser.Search_conditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#boolean_primary}.
	 * @param ctx the parse tree
	 */
	void enterBoolean_primary(@NotNull SQLParser.Boolean_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#boolean_primary}.
	 * @param ctx the parse tree
	 */
	void exitBoolean_primary(@NotNull SQLParser.Boolean_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#searched_when_clause}.
	 * @param ctx the parse tree
	 */
	void enterSearched_when_clause(@NotNull SQLParser.Searched_when_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#searched_when_clause}.
	 * @param ctx the parse tree
	 */
	void exitSearched_when_clause(@NotNull SQLParser.Searched_when_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#date_literal}.
	 * @param ctx the parse tree
	 */
	void enterDate_literal(@NotNull SQLParser.Date_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#date_literal}.
	 * @param ctx the parse tree
	 */
	void exitDate_literal(@NotNull SQLParser.Date_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#simple_case}.
	 * @param ctx the parse tree
	 */
	void enterSimple_case(@NotNull SQLParser.Simple_caseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#simple_case}.
	 * @param ctx the parse tree
	 */
	void exitSimple_case(@NotNull SQLParser.Simple_caseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#character_primary}.
	 * @param ctx the parse tree
	 */
	void enterCharacter_primary(@NotNull SQLParser.Character_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#character_primary}.
	 * @param ctx the parse tree
	 */
	void exitCharacter_primary(@NotNull SQLParser.Character_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#range_value_clause}.
	 * @param ctx the parse tree
	 */
	void enterRange_value_clause(@NotNull SQLParser.Range_value_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#range_value_clause}.
	 * @param ctx the parse tree
	 */
	void exitRange_value_clause(@NotNull SQLParser.Range_value_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#approximate_numeric_type}.
	 * @param ctx the parse tree
	 */
	void enterApproximate_numeric_type(@NotNull SQLParser.Approximate_numeric_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#approximate_numeric_type}.
	 * @param ctx the parse tree
	 */
	void exitApproximate_numeric_type(@NotNull SQLParser.Approximate_numeric_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#grouping_operation}.
	 * @param ctx the parse tree
	 */
	void enterGrouping_operation(@NotNull SQLParser.Grouping_operationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#grouping_operation}.
	 * @param ctx the parse tree
	 */
	void exitGrouping_operation(@NotNull SQLParser.Grouping_operationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#trim_operands}.
	 * @param ctx the parse tree
	 */
	void enterTrim_operands(@NotNull SQLParser.Trim_operandsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#trim_operands}.
	 * @param ctx the parse tree
	 */
	void exitTrim_operands(@NotNull SQLParser.Trim_operandsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#sql}.
	 * @param ctx the parse tree
	 */
	void enterSql(@NotNull SQLParser.SqlContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#sql}.
	 * @param ctx the parse tree
	 */
	void exitSql(@NotNull SQLParser.SqlContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#grant_statement}.
	 * @param ctx the parse tree
	 */
	void enterGrant_statement(@NotNull SQLParser.Grant_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#grant_statement}.
	 * @param ctx the parse tree
	 */
	void exitGrant_statement(@NotNull SQLParser.Grant_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#table_subquery}.
	 * @param ctx the parse tree
	 */
	void enterTable_subquery(@NotNull SQLParser.Table_subqueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#table_subquery}.
	 * @param ctx the parse tree
	 */
	void exitTable_subquery(@NotNull SQLParser.Table_subqueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#outer_join_type_part2}.
	 * @param ctx the parse tree
	 */
	void enterOuter_join_type_part2(@NotNull SQLParser.Outer_join_type_part2Context ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#outer_join_type_part2}.
	 * @param ctx the parse tree
	 */
	void exitOuter_join_type_part2(@NotNull SQLParser.Outer_join_type_part2Context ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#cross_join}.
	 * @param ctx the parse tree
	 */
	void enterCross_join(@NotNull SQLParser.Cross_joinContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#cross_join}.
	 * @param ctx the parse tree
	 */
	void exitCross_join(@NotNull SQLParser.Cross_joinContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#unsigned_literal}.
	 * @param ctx the parse tree
	 */
	void enterUnsigned_literal(@NotNull SQLParser.Unsigned_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#unsigned_literal}.
	 * @param ctx the parse tree
	 */
	void exitUnsigned_literal(@NotNull SQLParser.Unsigned_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#row_subquery}.
	 * @param ctx the parse tree
	 */
	void enterRow_subquery(@NotNull SQLParser.Row_subqueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#row_subquery}.
	 * @param ctx the parse tree
	 */
	void exitRow_subquery(@NotNull SQLParser.Row_subqueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#numeric_value_function}.
	 * @param ctx the parse tree
	 */
	void enterNumeric_value_function(@NotNull SQLParser.Numeric_value_functionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#numeric_value_function}.
	 * @param ctx the parse tree
	 */
	void exitNumeric_value_function(@NotNull SQLParser.Numeric_value_functionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#predefined_type}.
	 * @param ctx the parse tree
	 */
	void enterPredefined_type(@NotNull SQLParser.Predefined_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#predefined_type}.
	 * @param ctx the parse tree
	 */
	void exitPredefined_type(@NotNull SQLParser.Predefined_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#select_sublist}.
	 * @param ctx the parse tree
	 */
	void enterSelect_sublist(@NotNull SQLParser.Select_sublistContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#select_sublist}.
	 * @param ctx the parse tree
	 */
	void exitSelect_sublist(@NotNull SQLParser.Select_sublistContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#quantified_comparison_predicate}.
	 * @param ctx the parse tree
	 */
	void enterQuantified_comparison_predicate(@NotNull SQLParser.Quantified_comparison_predicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#quantified_comparison_predicate}.
	 * @param ctx the parse tree
	 */
	void exitQuantified_comparison_predicate(@NotNull SQLParser.Quantified_comparison_predicateContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#table_partitioning_clauses}.
	 * @param ctx the parse tree
	 */
	void enterTable_partitioning_clauses(@NotNull SQLParser.Table_partitioning_clausesContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#table_partitioning_clauses}.
	 * @param ctx the parse tree
	 */
	void exitTable_partitioning_clauses(@NotNull SQLParser.Table_partitioning_clausesContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#exact_numeric_type}.
	 * @param ctx the parse tree
	 */
	void enterExact_numeric_type(@NotNull SQLParser.Exact_numeric_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#exact_numeric_type}.
	 * @param ctx the parse tree
	 */
	void exitExact_numeric_type(@NotNull SQLParser.Exact_numeric_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#in_value_list}.
	 * @param ctx the parse tree
	 */
	void enterIn_value_list(@NotNull SQLParser.In_value_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#in_value_list}.
	 * @param ctx the parse tree
	 */
	void exitIn_value_list(@NotNull SQLParser.In_value_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#numeric_primary}.
	 * @param ctx the parse tree
	 */
	void enterNumeric_primary(@NotNull SQLParser.Numeric_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#numeric_primary}.
	 * @param ctx the parse tree
	 */
	void exitNumeric_primary(@NotNull SQLParser.Numeric_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#trim_function}.
	 * @param ctx the parse tree
	 */
	void enterTrim_function(@NotNull SQLParser.Trim_functionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#trim_function}.
	 * @param ctx the parse tree
	 */
	void exitTrim_function(@NotNull SQLParser.Trim_functionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#groupby_clause}.
	 * @param ctx the parse tree
	 */
	void enterGroupby_clause(@NotNull SQLParser.Groupby_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#groupby_clause}.
	 * @param ctx the parse tree
	 */
	void exitGroupby_clause(@NotNull SQLParser.Groupby_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#row_value_expression}.
	 * @param ctx the parse tree
	 */
	void enterRow_value_expression(@NotNull SQLParser.Row_value_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#row_value_expression}.
	 * @param ctx the parse tree
	 */
	void exitRow_value_expression(@NotNull SQLParser.Row_value_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#national_character_string_type}.
	 * @param ctx the parse tree
	 */
	void enterNational_character_string_type(@NotNull SQLParser.National_character_string_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#national_character_string_type}.
	 * @param ctx the parse tree
	 */
	void exitNational_character_string_type(@NotNull SQLParser.National_character_string_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#trim_specification}.
	 * @param ctx the parse tree
	 */
	void enterTrim_specification(@NotNull SQLParser.Trim_specificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#trim_specification}.
	 * @param ctx the parse tree
	 */
	void exitTrim_specification(@NotNull SQLParser.Trim_specificationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#row_value_predicand}.
	 * @param ctx the parse tree
	 */
	void enterRow_value_predicand(@NotNull SQLParser.Row_value_predicandContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#row_value_predicand}.
	 * @param ctx the parse tree
	 */
	void exitRow_value_predicand(@NotNull SQLParser.Row_value_predicandContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#qualified_join}.
	 * @param ctx the parse tree
	 */
	void enterQualified_join(@NotNull SQLParser.Qualified_joinContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#qualified_join}.
	 * @param ctx the parse tree
	 */
	void exitQualified_join(@NotNull SQLParser.Qualified_joinContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#type_length}.
	 * @param ctx the parse tree
	 */
	void enterType_length(@NotNull SQLParser.Type_lengthContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#type_length}.
	 * @param ctx the parse tree
	 */
	void exitType_length(@NotNull SQLParser.Type_lengthContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#else_clause}.
	 * @param ctx the parse tree
	 */
	void enterElse_clause(@NotNull SQLParser.Else_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#else_clause}.
	 * @param ctx the parse tree
	 */
	void exitElse_clause(@NotNull SQLParser.Else_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(@NotNull SQLParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(@NotNull SQLParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#column_reference}.
	 * @param ctx the parse tree
	 */
	void enterColumn_reference(@NotNull SQLParser.Column_referenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#column_reference}.
	 * @param ctx the parse tree
	 */
	void exitColumn_reference(@NotNull SQLParser.Column_referenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#union_join}.
	 * @param ctx the parse tree
	 */
	void enterUnion_join(@NotNull SQLParser.Union_joinContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#union_join}.
	 * @param ctx the parse tree
	 */
	void exitUnion_join(@NotNull SQLParser.Union_joinContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#timestamp_literal}.
	 * @param ctx the parse tree
	 */
	void enterTimestamp_literal(@NotNull SQLParser.Timestamp_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#timestamp_literal}.
	 * @param ctx the parse tree
	 */
	void exitTimestamp_literal(@NotNull SQLParser.Timestamp_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#partition_name}.
	 * @param ctx the parse tree
	 */
	void enterPartition_name(@NotNull SQLParser.Partition_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#partition_name}.
	 * @param ctx the parse tree
	 */
	void exitPartition_name(@NotNull SQLParser.Partition_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#boolean_value_expression}.
	 * @param ctx the parse tree
	 */
	void enterBoolean_value_expression(@NotNull SQLParser.Boolean_value_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#boolean_value_expression}.
	 * @param ctx the parse tree
	 */
	void exitBoolean_value_expression(@NotNull SQLParser.Boolean_value_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#hash_partitions_by_quantity}.
	 * @param ctx the parse tree
	 */
	void enterHash_partitions_by_quantity(@NotNull SQLParser.Hash_partitions_by_quantityContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#hash_partitions_by_quantity}.
	 * @param ctx the parse tree
	 */
	void exitHash_partitions_by_quantity(@NotNull SQLParser.Hash_partitions_by_quantityContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#extract_source}.
	 * @param ctx the parse tree
	 */
	void enterExtract_source(@NotNull SQLParser.Extract_sourceContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#extract_source}.
	 * @param ctx the parse tree
	 */
	void exitExtract_source(@NotNull SQLParser.Extract_sourceContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#table_space_name}.
	 * @param ctx the parse tree
	 */
	void enterTable_space_name(@NotNull SQLParser.Table_space_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#table_space_name}.
	 * @param ctx the parse tree
	 */
	void exitTable_space_name(@NotNull SQLParser.Table_space_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#list_value_partition}.
	 * @param ctx the parse tree
	 */
	void enterList_value_partition(@NotNull SQLParser.List_value_partitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#list_value_partition}.
	 * @param ctx the parse tree
	 */
	void exitList_value_partition(@NotNull SQLParser.List_value_partitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#list_partitions}.
	 * @param ctx the parse tree
	 */
	void enterList_partitions(@NotNull SQLParser.List_partitionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#list_partitions}.
	 * @param ctx the parse tree
	 */
	void exitList_partitions(@NotNull SQLParser.List_partitionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#extract_field}.
	 * @param ctx the parse tree
	 */
	void enterExtract_field(@NotNull SQLParser.Extract_fieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#extract_field}.
	 * @param ctx the parse tree
	 */
	void exitExtract_field(@NotNull SQLParser.Extract_fieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#hash_partitions}.
	 * @param ctx the parse tree
	 */
	void enterHash_partitions(@NotNull SQLParser.Hash_partitionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#hash_partitions}.
	 * @param ctx the parse tree
	 */
	void exitHash_partitions(@NotNull SQLParser.Hash_partitionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#create_table_statement}.
	 * @param ctx the parse tree
	 */
	void enterCreate_table_statement(@NotNull SQLParser.Create_table_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#create_table_statement}.
	 * @param ctx the parse tree
	 */
	void exitCreate_table_statement(@NotNull SQLParser.Create_table_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#cast_specification}.
	 * @param ctx the parse tree
	 */
	void enterCast_specification(@NotNull SQLParser.Cast_specificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#cast_specification}.
	 * @param ctx the parse tree
	 */
	void exitCast_specification(@NotNull SQLParser.Cast_specificationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#table_name}.
	 * @param ctx the parse tree
	 */
	void enterTable_name(@NotNull SQLParser.Table_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#table_name}.
	 * @param ctx the parse tree
	 */
	void exitTable_name(@NotNull SQLParser.Table_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#as_clause}.
	 * @param ctx the parse tree
	 */
	void enterAs_clause(@NotNull SQLParser.As_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#as_clause}.
	 * @param ctx the parse tree
	 */
	void exitAs_clause(@NotNull SQLParser.As_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#sort_specifier}.
	 * @param ctx the parse tree
	 */
	void enterSort_specifier(@NotNull SQLParser.Sort_specifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#sort_specifier}.
	 * @param ctx the parse tree
	 */
	void exitSort_specifier(@NotNull SQLParser.Sort_specifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#row_value_predicand_list}.
	 * @param ctx the parse tree
	 */
	void enterRow_value_predicand_list(@NotNull SQLParser.Row_value_predicand_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#row_value_predicand_list}.
	 * @param ctx the parse tree
	 */
	void exitRow_value_predicand_list(@NotNull SQLParser.Row_value_predicand_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#table_elements}.
	 * @param ctx the parse tree
	 */
	void enterTable_elements(@NotNull SQLParser.Table_elementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#table_elements}.
	 * @param ctx the parse tree
	 */
	void exitTable_elements(@NotNull SQLParser.Table_elementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#range_value_clause_list}.
	 * @param ctx the parse tree
	 */
	void enterRange_value_clause_list(@NotNull SQLParser.Range_value_clause_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#range_value_clause_list}.
	 * @param ctx the parse tree
	 */
	void exitRange_value_clause_list(@NotNull SQLParser.Range_value_clause_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#is_clause}.
	 * @param ctx the parse tree
	 */
	void enterIs_clause(@NotNull SQLParser.Is_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#is_clause}.
	 * @param ctx the parse tree
	 */
	void exitIs_clause(@NotNull SQLParser.Is_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#method_specifier}.
	 * @param ctx the parse tree
	 */
	void enterMethod_specifier(@NotNull SQLParser.Method_specifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#method_specifier}.
	 * @param ctx the parse tree
	 */
	void exitMethod_specifier(@NotNull SQLParser.Method_specifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#between_predicate_part_2}.
	 * @param ctx the parse tree
	 */
	void enterBetween_predicate_part_2(@NotNull SQLParser.Between_predicate_part_2Context ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#between_predicate_part_2}.
	 * @param ctx the parse tree
	 */
	void exitBetween_predicate_part_2(@NotNull SQLParser.Between_predicate_part_2Context ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#subquery}.
	 * @param ctx the parse tree
	 */
	void enterSubquery(@NotNull SQLParser.SubqueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#subquery}.
	 * @param ctx the parse tree
	 */
	void exitSubquery(@NotNull SQLParser.SubqueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#function_names_for_reserved_words}.
	 * @param ctx the parse tree
	 */
	void enterFunction_names_for_reserved_words(@NotNull SQLParser.Function_names_for_reserved_wordsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#function_names_for_reserved_words}.
	 * @param ctx the parse tree
	 */
	void exitFunction_names_for_reserved_words(@NotNull SQLParser.Function_names_for_reserved_wordsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#searched_case}.
	 * @param ctx the parse tree
	 */
	void enterSearched_case(@NotNull SQLParser.Searched_caseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#searched_case}.
	 * @param ctx the parse tree
	 */
	void exitSearched_case(@NotNull SQLParser.Searched_caseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#nonparenthesized_value_expression_primary}.
	 * @param ctx the parse tree
	 */
	void enterNonparenthesized_value_expression_primary(@NotNull SQLParser.Nonparenthesized_value_expression_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#nonparenthesized_value_expression_primary}.
	 * @param ctx the parse tree
	 */
	void exitNonparenthesized_value_expression_primary(@NotNull SQLParser.Nonparenthesized_value_expression_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#regex_matcher}.
	 * @param ctx the parse tree
	 */
	void enterRegex_matcher(@NotNull SQLParser.Regex_matcherContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#regex_matcher}.
	 * @param ctx the parse tree
	 */
	void exitRegex_matcher(@NotNull SQLParser.Regex_matcherContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(@NotNull SQLParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(@NotNull SQLParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#table_space_specifier}.
	 * @param ctx the parse tree
	 */
	void enterTable_space_specifier(@NotNull SQLParser.Table_space_specifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#table_space_specifier}.
	 * @param ctx the parse tree
	 */
	void exitTable_space_specifier(@NotNull SQLParser.Table_space_specifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#table_primary}.
	 * @param ctx the parse tree
	 */
	void enterTable_primary(@NotNull SQLParser.Table_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#table_primary}.
	 * @param ctx the parse tree
	 */
	void exitTable_primary(@NotNull SQLParser.Table_primaryContext ctx);
}