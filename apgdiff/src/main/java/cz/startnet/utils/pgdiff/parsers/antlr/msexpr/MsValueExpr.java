package cz.startnet.utils.pgdiff.parsers.antlr.msexpr;

import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Aggregate_windowed_functionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.All_distinct_expressionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Analytic_windowed_functionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Case_expressionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Date_expressionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.ExpressionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Expression_listContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Full_column_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Function_callContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Object_expressionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Order_by_clauseContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Order_by_expressionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Over_clauseContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.PredicateContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Qualified_nameContext;
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
import cz.startnet.utils.pgdiff.schema.GenericColumn;

public class MsValueExpr extends MsAbstractExpr {

    protected MsValueExpr(MsAbstractExpr parent) {
        super(parent);
    }

    protected MsValueExpr(String schema) {
        super(schema);
    }

    public void analyze(ExpressionContext exp) {
        for (ExpressionContext v : exp.expression()) {
            analyze(v);
        }

        Select_stmt_no_parensContext ssnp;
        Case_expressionContext ce;
        Over_clauseContext oc;
        Date_expressionContext de;
        Sequence_callContext sc;
        Function_callContext fc;


        if ((ssnp = exp.select_stmt_no_parens()) != null) {
            new MsSelect(this).analyze(ssnp);
        } else if ((ce = exp.case_expression()) != null) {
            caseExp(ce);
        } else if ((oc = exp.over_clause()) != null) {
            overClause(oc);
        } else if ((de = exp.date_expression()) != null) {
            analyze(de.expression());
        } else if ((sc = exp.sequence_call()) != null) {
            addSequenceDepcy(sc.qualified_name());
        } else if ((fc = exp.function_call()) != null) {
            functionCall(fc);
            objectExp(exp.object_expression());
            column(exp.full_column_name());
        }
    }

    public GenericColumn functionCall(Function_callContext functionCall) {
        if (functionCall == null) {
            return null;
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
            aggregate(agg);
        } else if ((sfn = functionCall.scalar_function_name()) != null) {
            expressionList(functionCall.expression_list());
            return function(sfn);
        } else {
            expressionList(functionCall.expression_list());
        }

        return null;
    }

    public void expressionList(Expression_listContext list) {
        if (list != null) {
            for (ExpressionContext exp : list.expression()) {
                analyze(exp);
            }
        }
    }

    public void search(Search_conditionContext search) {
        for (Search_condition_andContext sca: search.search_condition_and()) {
            for (Search_condition_notContext scn : sca.search_condition_not()) {
                predicate(scn.predicate());
            }
        }
    }

    public void aggregate(Aggregate_windowed_functionContext agg) {
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
    }

    private void objectExp(Object_expressionContext object) {
        if (object == null) {
            return;
        }
        Select_stmt_no_parensContext ssnp;
        Case_expressionContext ce;
        Over_clauseContext oc;

        if ((ssnp = object.select_stmt_no_parens()) != null) {
            new MsSelect(this).analyze(ssnp);
        } else if ((ce = object.case_expression()) != null) {
            caseExp(ce);
        } else if ((oc = object.over_clause()) != null) {
            overClause(oc);
        } else {
            objectExp(object.object_expression());
            functionCall(object.function_call());
            column(object.full_column_name());
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

    private GenericColumn function(Scalar_function_nameContext sfn) {
        Qualified_nameContext fullName = sfn.qualified_name();
        if (fullName != null) {
            return addFunctionDepcy(fullName);
        }
        return null;
    }

    private void column(Full_column_nameContext fullName) {
        if (fullName != null) {
            Qualified_nameContext tableName = fullName.qualified_name();
            if (tableName != null) {
                addColumnDepcy(tableName, fullName.id().getText());
            }
        }
    }

    private void overClause(Over_clauseContext oc) {
        if (oc != null) {
            expressionList(oc.expression_list());
            orderBy(oc.order_by_clause());
        }
    }

    public void orderBy(Order_by_clauseContext obc) {
        if (obc != null) {
            for (ExpressionContext exp : obc.expression()) {
                analyze(exp);
            }
            for (Order_by_expressionContext obe : obc.order_by_expression()) {
                analyze(obe.expression());
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
            new MsSelect(this).analyze(select);
        } else if ((search = predicate.search_condition()) != null) {
            search(search);
        }

        expressionList(predicate.expression_list());
    }
}
