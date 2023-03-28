/*******************************************************************************
 * Copyright 2017-2023 TAXTELECOM, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package ru.taximaxim.codekeeper.core.parsers.antlr.msexpr;

import java.util.Map.Entry;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.All_distinct_expressionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.Arbitrary_length_patternContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.Case_expressionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.Column_declarationContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.Data_typeContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.Date_expressionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.Edge_patternContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.ExpressionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.Expression_listContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.Full_column_nameContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.Function_callContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.IdContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.Last_nodeContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.Match_specificationContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.Object_expressionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.Order_by_clauseContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.Order_by_expressionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.Over_clauseContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.PredicateContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.Qualified_nameContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.Scalar_function_nameContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.Search_conditionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.Search_condition_andContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.Search_condition_notContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.Select_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.Select_stmt_no_parensContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.Simple_match_patternContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.Switch_search_condition_sectionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.Switch_sectionContext;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;

public class MsValueExpr extends MsAbstractExpr {

    protected MsValueExpr(MsAbstractExpr parent) {
        super(parent);
    }

    public MsValueExpr(String schema) {
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
        Function_callContext fc;


        if ((ssnp = exp.select_stmt_no_parens()) != null) {
            new MsSelect(this).analyze(ssnp);
        } else if ((ce = exp.case_expression()) != null) {
            caseExp(ce);
        } else if ((oc = exp.over_clause()) != null) {
            overClause(oc);
        } else if ((de = exp.date_expression()) != null) {
            analyze(de.expression());
        } else if ((fc = exp.function_call()) != null) {
            functionCall(fc);

            Object_expressionContext object = exp.object_expression();
            if (object != null) {
                objectExp(exp.object_expression());
            }
        }

        Full_column_nameContext fcn = exp.full_column_name();
        if (fcn != null) {
            addColumnDepcy(fcn);
        }
    }

    public GenericColumn functionCall(Function_callContext functionCall) {
        Scalar_function_nameContext sfn;
        Qualified_nameContext seq;
        Function_callContext fc;
        Data_typeContext dt;
        Order_by_clauseContext obc;

        for (ExpressionContext exp : functionCall.expression()) {
            analyze(exp);
        }

        if ((sfn = functionCall.scalar_function_name()) != null) {
            expressionList(functionCall.expression_list());
            All_distinct_expressionContext distinct = functionCall.all_distinct_expression();
            if (distinct != null) {
                analyze(distinct.expression());
            }
            overClause(functionCall.over_clause());
            return function(sfn);
        } else if ((seq = functionCall.sequence_name)!= null) {
            addObjectDepcy(seq, DbObjType.SEQUENCE);
            overClause(functionCall.over_clause());
        } else if ((fc = functionCall.function_call()) != null) {
            return functionCall(fc);
        } else if ((obc = functionCall.order_by_clause()) != null) {
            orderBy(obc);
        } else if ((dt = functionCall.data_type()) != null) {
            addTypeDepcy(dt);
        } else if (functionCall.OPENJSON() != null) {
            for (Column_declarationContext col : functionCall.column_declaration()) {
                addTypeDepcy(col.data_type());
            }
        } else if (functionCall.IIF() != null) {
            search(functionCall.search_condition());
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

    private void objectExp(Object_expressionContext object) {
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
            Function_callContext fc = object.function_call();
            Full_column_nameContext fcn = object.full_column_name();
            Object_expressionContext subObject = object.object_expression();

            if (fc != null) {
                functionCall(fc);
            }

            if (subObject != null) {
                objectExp(subObject);
            }

            if (fcn != null) {
                addColumnDepcy(fcn);
            }
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
            return addObjectDepcy(fullName, DbObjType.FUNCTION);
        }
        return null;
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
        for (Match_specificationContext match : predicate.match_specification()) {
            match(match);
        }
        expressionList(predicate.expression_list());

    }

    private void match(Match_specificationContext matchExpr) {
        for (Last_nodeContext lastNode : matchExpr.last_node()) {
            addTableReference(lastNode.qualified_name());
        }

        for (Simple_match_patternContext simpleMatch : matchExpr.simple_match_pattern()) {
            for (Qualified_nameContext tableName : simpleMatch.qualified_name()) {
                addTableReference(tableName);
            }

            for (Last_nodeContext lastNode : simpleMatch.last_node()) {
                addTableReference(lastNode.qualified_name());
            }

            if (simpleMatch.edge_pattern() != null) {
                addTableReference(simpleMatch.edge_pattern().qualified_name());
            }
        }

        for (Arbitrary_length_patternContext arbitaryLengthMatch : matchExpr.arbitrary_length_pattern()) {
            for (Qualified_nameContext tableName : arbitaryLengthMatch.qualified_name()) {
                addTableReference(tableName);
            }

            if (arbitaryLengthMatch.last_node() != null) {
                addTableReference(arbitaryLengthMatch.last_node().qualified_name());
            }

            for (Edge_patternContext edge_pattern : arbitaryLengthMatch.edge_pattern()) {
                addTableReference(edge_pattern.qualified_name());
            }
        }
    }

    private void addTableReference(Qualified_nameContext tableName) {
        IdContext relationCtx = tableName.name;
        String relationName = relationCtx.getText();

        Entry<String, GenericColumn> ref = findReference(null, relationName);
        if (ref != null) {
            GenericColumn table = ref.getValue();
            if (table != null) {
                if (relationName.equals(table.table)) {
                    addDepcy(table, relationCtx);
                } else {
                    addAliasReference(table, relationCtx);
                }
            }
        }
    }
}
