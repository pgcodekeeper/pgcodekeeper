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
package ru.taximaxim.codekeeper.core.parsers.antlr.expr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Additional_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Arguments_listContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Assign_stmtContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Base_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Case_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Control_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Cursor_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Data_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Data_typeContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Data_type_decContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.DeclarationContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.DeclarationsContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Declare_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Exception_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Execute_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Execute_stmtContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Explain_queryContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Explain_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Function_blockContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Function_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Function_statementsContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.IdentifierContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.If_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Lock_tableContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Loop_startContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Loop_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Message_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Only_table_multiplyContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.OptionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Perform_stmtContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Plpgsql_functionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Plpgsql_queryContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Raise_usingContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Reindex_stmtContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Return_stmtContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Schema_qualified_nameContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Select_stmt_no_parensContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Table_colsContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Table_cols_listContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Transaction_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Truncate_stmtContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Type_declarationContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Using_vexContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.VexContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.rulectx.SelectStmt;
import ru.taximaxim.codekeeper.core.parsers.antlr.rulectx.Vex;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.pg.PgParserAbstract;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.meta.MetaContainer;
import ru.taximaxim.codekeeper.core.utils.ModPair;
import ru.taximaxim.codekeeper.core.utils.Pair;


public class Function extends AbstractExprWithNmspc<Plpgsql_functionContext> {

    private static final Logger LOG = LoggerFactory.getLogger(Function.class);

    public Function(MetaContainer meta) {
        super(meta);
    }

    protected Function(AbstractExpr parent) {
        super(parent);
    }

    @Override
    public List<ModPair<String, String>> analyze(Plpgsql_functionContext root) {
        block(root.function_block());
        return Collections.emptyList();
    }

    private void block(Function_blockContext block) {
        // block label may be used to qualify references to vars in nested blocks
        // there's no mechanism to track this ATM, implement later if requested
        // same for loop-declared vars (at least with the FOR var IN ... syntax)
        declare(block.declarations());
        statements(block.function_statements());
        exception(block.exception_statement());
    }

    private void declare(DeclarationsContext declare) {
        if (declare == null) {
            return;
        }

        ValueExpr vex = new ValueExpr(this);

        for (DeclarationContext declaration : declare.declaration()) {
            String alias = declaration.identifier().getText();
            Type_declarationContext dec = declaration.type_declaration();

            Data_type_decContext datatype = dec.data_type_dec();
            if (datatype != null) {
                declareVar(alias, datatype);

                VexContext vexCtx = dec.vex();
                if (vexCtx != null) {
                    vex.analyze(new Vex(vexCtx));
                }
            } else if (dec.ALIAS() != null) {
                ParseTree idVar = dec.identifier();
                if (idVar == null) {
                    idVar = dec.DOLLAR_NUMBER();
                }
                String variable = idVar.getText();

                declareAlias(alias, variable);
            } else if (dec.CURSOR() != null) {
                Arguments_listContext list = dec.arguments_list();
                if (list != null) {
                    for (Data_typeContext type : list.data_type()) {
                        addTypeDepcy(type);
                    }
                }

                new Select(this).analyze(new SelectStmt(dec.select_stmt()));
                addNamespaceVariable(new Pair<>(alias, TypesSetManually.CURSOR));
            }
        }
    }

    private void declareVar(String alias, Data_type_decContext ctx) {
        Data_typeContext type = ctx.data_type();
        if (type != null) {
            declareNamespaceVar(alias, null, addTypeDepcy(type));
        } else if (ctx.ROWTYPE() != null) {
            declareNamespaceVar(alias, null, addTypeDepcy(ctx.schema_qualified_name_nontype()));
        } else {
            String varType = processColumn(PgParserAbstract.getIdentifiers(ctx.schema_qualified_name())).getSecond();
            addNamespaceVariable(new Pair<>(alias, varType));
        }
    }

    private void declareAlias(String alias, String variable) {
        Entry<String, GenericColumn> ref = findReference(null, variable, null);
        if (ref != null) {
            addReference(alias, ref.getValue());
        } else {
            Pair<String, String> pair = findColumnInComplex(variable);
            String type;
            if (pair != null) {
                type = pair.getSecond();
            } else {
                type = TypesSetManually.UNKNOWN;
                LOG.warn("Variable not found: {}", variable);
            }

            addNamespaceVariable(new Pair<>(alias, type));
        }
    }

    private void statements(Function_statementsContext statements) {
        for (Function_statementContext statement : statements.function_statement()) {
            Function_blockContext block = statement.function_block();
            Base_statementContext base;
            Control_statementContext control;
            Cursor_statementContext cursor;
            Message_statementContext message;
            Plpgsql_queryContext query;
            Transaction_statementContext transaction;
            Additional_statementContext additional;
            if (block != null) {
                new Function(this).block(block);
            } else if ((base = statement.base_statement()) != null) {
                base(base);
            } else if ((control = statement.control_statement()) != null) {
                control(control);
            } else if ((cursor = statement.cursor_statement()) != null) {
                cursor(cursor);
            } else if ((message = statement.message_statement()) != null) {
                message(message);
            } else if ((query = statement.plpgsql_query()) != null) {
                query(query);
            } else if ((transaction = statement.transaction_statement()) != null) {
                transaction(transaction);
            } else if ((additional = statement.additional_statement()) != null) {
                additional(additional);
            }
        }
    }

    private void base(Base_statementContext base) {
        Assign_stmtContext assign = base.assign_stmt();
        Perform_stmtContext perform;

        if (assign != null) {
            Select_stmt_no_parensContext select = assign.select_stmt_no_parens();
            if (select != null) {
                new Select(this).analyze(new SelectStmt(select));
            } else {
                new Select(this).analyze(assign.perform_stmt());
            }
        } else if ((perform = base.perform_stmt()) != null) {
            new Select(this).analyze(perform);
        }
    }

    private void execute(Execute_stmtContext exec) {
        ValueExpr vex = new ValueExpr(this);
        vex.analyze(new Vex(exec.vex()));
        Using_vexContext using = exec.using_vex();
        if (using != null) {
            for (VexContext v : using.vex()) {
                vex.analyze(new Vex(v));
            }
        }
    }

    private void control(Control_statementContext control) {
        ValueExpr vex = new ValueExpr(this);

        Return_stmtContext returnStmt = control.return_stmt();
        If_statementContext isc;
        Case_statementContext csc;
        Loop_statementContext loop;

        if (returnStmt != null) {
            returnStmt(returnStmt);
        } else if (control.CALL() != null) {
            vex.function(control.function_call());
        } else if ((isc = control.if_statement()) != null) {
            for (VexContext vexCtx : isc.vex()) {
                vex.analyze(new Vex(vexCtx));
            }
            for (Function_statementsContext statements : isc.function_statements()) {
                statements(statements);
            }
        } else if ((csc = control.case_statement()) != null) {
            for (VexContext vexCtx : csc.vex()) {
                vex.analyze(new Vex(vexCtx));
            }
            for (Function_statementsContext statements : csc.function_statements()) {
                statements(statements);
            }
        } else if ((loop = control.loop_statement()) != null) {
            loop(loop);
        }
    }

    private void loop(Loop_statementContext loop) {
        Function_statementsContext statements = loop.function_statements();
        VexContext vexCtx;

        if (statements != null) {
            Function function = new Function(this);
            Loop_startContext start = loop.loop_start();
            if (start != null) {
                function.loopStart(start);
            }
            function.statements(statements);
        } else if ((vexCtx = loop.vex()) != null) {
            ValueExpr vex = new ValueExpr(this);
            vex.analyze(new Vex(vexCtx));
        }
    }

    private void loopStart(Loop_startContext start) {
        IdentifierContext cur = start.cursor;
        if (cur != null) {
            // record
            addNamespaceVariable(new Pair<>(cur.getText(), TypesSetManually.UNKNOWN));
        } else if (start.DOUBLE_DOT() != null) {
            addNamespaceVariable(new Pair<>(start.alias.getText(), TypesSetManually.INTEGER));
        }

        List<VexContext> vexs = start.vex();
        List<OptionContext> options = start.option();
        if (!vexs.isEmpty() || !options.isEmpty()) {
            ValueExpr vex = new ValueExpr(this);

            for (VexContext v : vexs) {
                vex.analyze(new Vex(v));
            }

            for (OptionContext option : options) {
                vex.analyze(new Vex(option.vex()));
            }
        }

        Plpgsql_queryContext query = start.plpgsql_query();
        if (query != null) {
            var columns = query(query);
            if (columns.isEmpty()) {
                return;
            }
            var record = start.identifier_list().identifier();
            if (record.size() != 1) {
                return;
            }
            var key = record.get(0).getText();
            addReference(key, null);
            complexNamespace.put(key, new ArrayList<>(columns));
        }
    }

    private void returnStmt(Return_stmtContext returnStmt) {
        VexContext vexCtx = returnStmt.vex();
        Plpgsql_queryContext query;
        Perform_stmtContext perform;

        if (vexCtx != null) {
            ValueExpr vex = new ValueExpr(this);
            vex.analyze(new Vex(vexCtx));
        } else if ((query = returnStmt.plpgsql_query())!= null) {
            query(query);
        } else if ((perform = returnStmt.perform_stmt())!= null) {
            new Select(this).analyze(perform);
        }
    }

    private void cursor(Cursor_statementContext cursor) {
        List<OptionContext> options = cursor.option();
        Plpgsql_queryContext query;

        if (!options.isEmpty()) {
            ValueExpr vex = new ValueExpr(this);
            for (OptionContext option : options) {
                vex.analyze(new Vex(option.vex()));
            }
        } else if ((query = cursor.plpgsql_query()) != null) {
            query(query);
        }
    }

    private void message(Message_statementContext message) {
        ValueExpr vex = new ValueExpr(this);
        for (VexContext vexCtx : message.vex()) {
            vex.analyze(new Vex(vexCtx));
        }

        Raise_usingContext using = message.raise_using();
        if (using != null) {
            for (VexContext vexCtx : using.vex()) {
                vex.analyze(new Vex(vexCtx));
            }
        }
    }

    private List<ModPair<String, String>> query(Plpgsql_queryContext query) {
        Data_statementContext ds = query.data_statement();
        Explain_statementContext statement;
        Execute_stmtContext exec;

        if (ds != null) {
            return new Sql(this).data(ds);
        }
        if ((exec = query.execute_stmt()) != null) {
            execute(exec);
        } else if ((statement = query.explain_statement()) != null) {
            Explain_queryContext explain = statement.explain_query();
            ds = explain.data_statement();
            Execute_statementContext ex;
            Declare_statementContext dec;

            if (ds != null) {
                new Sql(this).data(ds);
            } else if ((ex = explain.execute_statement()) != null) {
                ValueExpr vex = new ValueExpr(this);
                for (VexContext v : ex.vex()) {
                    vex.analyze(new Vex(v));
                }
            } else if ((dec = explain.declare_statement()) != null) {
                new Select(this).analyze(dec.select_stmt());
            }
        }
        return Collections.emptyList();
    }

    private void transaction(Transaction_statementContext transaction) {
        Lock_tableContext lock = transaction.lock_table();
        if (lock != null) {
            for (Only_table_multiplyContext name : lock.only_table_multiply()) {
                addRelationDepcy(PgParserAbstract.getIdentifiers(name.schema_qualified_name()));
            }
        }
    }

    private void additional(Additional_statementContext additional) {
        Schema_qualified_nameContext table = additional.schema_qualified_name();
        Data_statementContext data;
        Table_cols_listContext col;
        Truncate_stmtContext truncate;
        Reindex_stmtContext reindex;

        if ((reindex = additional.reindex_stmt()) != null) {
            if (reindex.TABLE() != null) {
                addRelationDepcy(PgParserAbstract.getIdentifiers(reindex.schema_qualified_name()));
            } else if (reindex.SCHEMA() != null) {
                addSchemaDepcy(PgParserAbstract.getIdentifiers(reindex.schema_qualified_name()), null);
            }
        } else if (table != null && (additional.CLUSTER() != null || additional.REFRESH() != null)) {
            addRelationDepcy(PgParserAbstract.getIdentifiers(table));
        } else if ((data = additional.data_statement()) != null) {
            new Sql(this).data(data);

            for (Data_typeContext type : additional.data_type()) {
                addTypeDepcy(type);
            }
        } else if ((col = additional.table_cols_list()) != null) {
            for (Table_colsContext tabl : col.table_cols()) {
                List<ParserRuleContext> ids = PgParserAbstract.getIdentifiers(tabl.schema_qualified_name());
                GenericColumn rel = addRelationDepcy(ids);
                for (IdentifierContext id : tabl.identifier()) {
                    addFilteredColumnDepcy(rel.schema, rel.table, id.getText());
                }
            }
        } else if ((truncate = additional.truncate_stmt()) != null) {
            for (Only_table_multiplyContext name : truncate.only_table_multiply()) {
                addRelationDepcy(PgParserAbstract.getIdentifiers(name.schema_qualified_name()));
            }
        }
    }

    private void exception(Exception_statementContext exception) {
        if (exception == null) {
            return;
        }

        ValueExpr vex = new ValueExpr(this);
        for (VexContext vexCtx : exception.vex()) {
            vex.analyze(new Vex(vexCtx));
        }

        for (Function_statementsContext statements : exception.function_statements()) {
            statements(statements);
        }
    }
}
