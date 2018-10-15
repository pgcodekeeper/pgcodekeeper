package cz.startnet.utils.pgdiff.parsers.antlr.expr;

import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Aggregate_windowed_functionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.All_distinct_expressionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Analytic_windowed_functionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Case_expressionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Date_expressionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.ExpressionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Expression_listContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Full_column_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Full_table_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Func_proc_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Function_callContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.IdContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Object_expressionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Order_by_clauseContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Order_by_expressionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Over_clauseContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.PredicateContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Ranking_windowed_functionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Scalar_function_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Search_conditionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Search_condition_andContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Search_condition_notContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Select_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Select_stmt_no_parensContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Sequence_callContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Switch_search_condition_sectionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Switch_sectionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Table_nameContext;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import ru.taximaxim.codekeeper.apgdiff.utils.Pair;

public class MsValueExpr extends AbstractExpr {

    protected MsValueExpr(AbstractExpr parent) {
        super(parent);
    }

    public MsValueExpr(String schema, PgDatabase db) {
        super(schema, db);
    }


    public Pair<String, String> analyze(ExpressionContext vex) {
        for (ExpressionContext v : vex.expression()) {
            analyze(v);
        }

        Select_stmt_no_parensContext ssnp;
        Case_expressionContext ce;
        Over_clauseContext oc;
        Date_expressionContext de;
        Sequence_callContext sc;
        Function_callContext fc;


        if ((ssnp = vex.select_stmt_no_parens()) != null) {
            //new MsSelect(this).analyze(ssnp);
        } else if ((ce = vex.case_expression()) != null) {
            caseExp(ce);
        } else if ((oc = vex.over_clause()) != null) {
            overClause(oc);
        } else if ((de = vex.date_expression()) != null) {
            analyze(de.expression());
        } else if ((sc = vex.sequence_call()) != null) {
            Full_table_nameContext name = sc.full_table_name();
            IdContext schemaName = name.schema;
            addSequenceDepcy(schemaName == null ?
                    db.getDefaultSchema().getName() : schemaName.getText(),
                    name.table.getText());
        } else if ((fc = vex.function_call()) != null) {
            column(vex.full_column_name());
            functionCall(fc);
            objectExp(vex.object_expression());
        }

        return null;
    }

    private void objectExp(Object_expressionContext object) {
        Select_stmt_no_parensContext ssnp;
        Case_expressionContext ce;
        Over_clauseContext oc;

        if ((ssnp = object.select_stmt_no_parens()) != null) {
            //new MsSelect(this).analyze(ssnp);
        } else if ((ce = object.case_expression()) != null) {
            caseExp(ce);
        } else if ((oc = object.over_clause()) != null) {
            overClause(oc);
        } else {
            column(object.full_column_name());
            functionCall(object.function_call());
            objectExp(object.object_expression());
        }
    }

    private void caseExp(Case_expressionContext ce) {
        for (ExpressionContext exp : ce.expression()) {
            analyze(exp);
        }

        for (Switch_sectionContext s : ce.switch_section()) {
            for (ExpressionContext exp : s.expression()) {
                analyze(exp);
            }
        }

        for (Switch_search_condition_sectionContext s : ce.switch_search_condition_section()) {
            search(s.search_condition());
            analyze(s.expression());
        }
    }

    private void functionCall(Function_callContext functionCall) {
        if (functionCall == null) {
            return;
        }

        Ranking_windowed_functionContext rwf;
        Analytic_windowed_functionContext awf;
        Aggregate_windowed_functionContext agg;
        Scalar_function_nameContext sfn;

        for (ExpressionContext exp : functionCall.expression()) {
            analyze(exp);
        }

        if ((rwf = functionCall.ranking_windowed_function()) != null) {
            overClause(rwf.over_clause());
            ExpressionContext exp = rwf.expression();
            if (exp != null) {
                analyze(exp);
            }
        } else if ((awf = functionCall.analytic_windowed_function()) != null) {
            overClause(awf.over_clause());
            for (ExpressionContext exp : awf.expression()) {
                analyze(exp);
            }
        } else if ((agg = functionCall.aggregate_windowed_function()) != null) {
            overClause(agg.over_clause());
            expressionList(agg.expression_list());
            All_distinct_expressionContext distinct = agg.all_distinct_expression();
            if (distinct != null) {
                analyze(distinct.expression());
            }

            ExpressionContext exp = agg.expression();
            if (exp != null) {
                analyze(exp);
            }
        } else if ((sfn = functionCall.scalar_function_name()) != null) {
            function(sfn);
            expressionList(functionCall.expression_list());
        } else {
            expressionList(functionCall.expression_list());
        }
    }

    private void function(Scalar_function_nameContext sfn) {
        Func_proc_nameContext fullName = sfn.func_proc_name();
        if (fullName != null) {
            String functionName = fullName.procedure.getText();
            IdContext schemaCtx = fullName.schema;
            String schemaName = schemaCtx == null ? db.getDefaultSchema().getName()
                    : schemaCtx.getText();
            addFunctionDepcy(schemaName, functionName);
        }
    }

    private void column(Full_column_nameContext fullName) {
        if (fullName != null) {
            Table_nameContext tableName = fullName.table_name();
            if (tableName != null) {
                String colName = fullName.id().getText();
                String relationName = tableName.table.getText();
                IdContext schemaCtx = tableName.schema;
                String schemaName = schemaCtx == null ? db.getDefaultSchema().getName()
                        : schemaCtx.getText();

                // TODO system schemas from PostgreSQL
                addFilteredRelationColumnsDepcies(schemaName, relationName,
                        col -> col.equals(colName));
            }
        }
    }

    private void overClause(Over_clauseContext oc) {
        expressionList(oc.expression_list());
        orderBy(oc.order_by_clause());
    }

    private void expressionList(Expression_listContext list) {
        if (list != null) {
            for (ExpressionContext exp : list.expression()) {
                analyze(exp);
            }
        }
    }

    private void orderBy(Order_by_clauseContext obc) {
        if (obc != null) {
            for (ExpressionContext exp : obc.expression()) {
                analyze(exp);
            }
            for (Order_by_expressionContext obe : obc.order_by_expression()) {
                analyze(obe.expression());
            }
        }
    }

    private void search(Search_conditionContext search) {
        for (Search_condition_andContext sca: search.search_condition_and()) {
            for (Search_condition_notContext scn : sca.search_condition_not()) {
                predicate(scn.predicate());
            }
        }
    }

    private void predicate(PredicateContext predicate) {
        for (ExpressionContext exp : predicate.expression()) {
            analyze(exp);
        }

        Select_statementContext select;
        Search_conditionContext search;

        if ((select = predicate.select_statement()) != null) {
            //new MsSelect(this).analyze(select);
        } else if ((search = predicate.search_condition()) != null) {
            search(search);
        }

        expressionList(predicate.expression_list());
    }
}
