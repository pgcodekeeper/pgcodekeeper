package cz.startnet.utils.pgdiff.parsers.antlr.expr;

import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;

import org.antlr.v4.runtime.tree.ParseTree;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Additional_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Arguments_listContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Assign_stmtContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Base_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Case_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Control_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Cursor_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Data_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Data_typeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Data_type_decContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.DeclarationContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.DeclarationsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Delete_stmt_for_psqlContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Exception_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Execute_stmtContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Function_blockContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Function_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Function_statementsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.If_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Insert_stmt_for_psqlContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Lock_tableContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Loop_startContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Loop_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Message_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Only_table_multiplyContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.OptionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Perform_stmtContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Plpgsql_functionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Raise_usingContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Return_stmtContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Select_stmtContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Select_stmt_no_parensContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.StatementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Table_colsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Table_cols_listContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Transaction_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Truncate_stmtContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Type_declarationContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Update_stmt_for_psqlContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Using_vexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.VexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.rulectx.SelectStmt;
import cz.startnet.utils.pgdiff.parsers.antlr.rulectx.Vex;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.utils.ModPair;
import ru.taximaxim.codekeeper.apgdiff.utils.Pair;

public class Function extends AbstractExprWithNmspc<Plpgsql_functionContext> {

    public Function(PgDatabase db, DbObjType... disabledDepcies) {
        super(db, disabledDepcies);
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
                String var = idVar.getText();

                declareAlias(alias, var);
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
            String varType = processColumn(ctx.schema_qualified_name().identifier()).getSecond();
            addNamespaceVariable(new Pair<>(alias, varType));
        }
    }

    private void declareAlias(String alias, String var) {
        Entry<String, GenericColumn> ref = findReference(null, var, null);
        if (ref != null) {
            addReference(alias, ref.getValue());
        } else {
            Pair<String, String> pair = findColumnInComplex(var);
            String type;
            if (pair != null) {
                type = pair.getSecond();
            } else {
                type = TypesSetManually.UNKNOWN;
                Log.log(Log.LOG_WARNING, "Variable not found: " + var);
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
            Data_statementContext data;
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
            } else if ((data = statement.data_statement()) != null) {
                data(data);
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
        } else if (base.EXECUTE() != null) {
            ValueExpr vex = new ValueExpr(this);
            vex.analyze(new Vex(base.vex()));
            Using_vexContext using = base.using_vex();
            if (using != null) {
                for (VexContext v : using.vex()) {
                    vex.analyze(new Vex(v));
                }
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

        Execute_stmtContext exec = start.execute_stmt();
        Select_stmtContext select;

        if (exec != null) {
            execute(exec);
        } else if ((select = start.select_stmt())!= null) {
            new Select(this).analyze(new SelectStmt(select));
        }
    }

    private void returnStmt(Return_stmtContext returnStmt) {
        VexContext vexCtx = returnStmt.vex();
        Execute_stmtContext exec;
        Select_stmtContext select;
        Perform_stmtContext perform;

        if (vexCtx != null) {
            ValueExpr vex = new ValueExpr(this);
            vex.analyze(new Vex(vexCtx));
        } else if ((exec = returnStmt.execute_stmt()) != null) {
            execute(exec);
        } else if ((select = returnStmt.select_stmt())!= null) {
            new Select(this).analyze(new SelectStmt(select));
        } else if ((perform = returnStmt.perform_stmt())!= null) {
            new Select(this).analyze(perform);
        }
    }

    private void cursor(Cursor_statementContext cursor) {
        List<OptionContext> options = cursor.option();
        Select_stmtContext select;
        Execute_stmtContext exec;

        if (!options.isEmpty()) {
            ValueExpr vex = new ValueExpr(this);
            for (OptionContext option : options) {
                vex.analyze(new Vex(option.vex()));
            }
        } else if ((select = cursor.select_stmt()) != null) {
            new Select(this).analyze(new SelectStmt(select));
        } else if ((exec = cursor.execute_stmt()) != null) {
            execute(exec);
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

    private void data(Data_statementContext data) {
        Select_stmtContext select = data.select_stmt();
        Insert_stmt_for_psqlContext insert;
        Update_stmt_for_psqlContext update;
        Delete_stmt_for_psqlContext delete;
        Truncate_stmtContext truncate;
        if (select != null) {
            new Select(this).analyze(new SelectStmt(select));
        } else if ((insert = data.insert_stmt_for_psql()) != null) {
            new Insert(this).analyze(insert);
        } else if ((update = data.update_stmt_for_psql()) != null) {
            new Update(this).analyze(update);
        } else if ((delete = data.delete_stmt_for_psql()) != null) {
            new Delete(this).analyze(delete);
        } else if ((truncate = data.truncate_stmt()) != null) {
            for (Only_table_multiplyContext name : truncate.only_table_multiply()) {
                addRelationDepcy(name.schema_qualified_name().identifier());
            }
        }
    }

    private void transaction(Transaction_statementContext transaction) {
        Lock_tableContext lock = transaction.lock_table();
        if (lock != null) {
            for (Only_table_multiplyContext name : lock.only_table_multiply()) {
                addRelationDepcy(name.schema_qualified_name().identifier());
            }
        }
    }

    private void additional(Additional_statementContext additional) {
        Schema_qualified_nameContext table = additional.schema_qualified_name();
        StatementContext statement;
        Data_statementContext data;
        Table_cols_listContext col;

        if (table != null) {
            if (additional.CLUSTER() != null || additional.TABLE() != null || additional.REFRESH() != null) {
                addRelationDepcy(table.identifier());
            } else if (additional.SCHEMA() != null) {
                addSchemaDepcy(table.identifier());
            }
        } else if ((statement = additional.statement()) != null) {
            data = statement.data_statement();
            if (data != null) {
                new Sql(this).data(data);
            }
        } else if ((data = additional.data_statement()) != null) {
            new Sql(this).data(data);

            for (Data_typeContext type : additional.data_type()) {
                addTypeDepcy(type);
            }
        } else if ((col = additional.table_cols_list()) != null) {
            for (Table_colsContext tabl : col.table_cols()) {
                List<IdentifierContext> ids = tabl.schema_qualified_name().identifier();
                GenericColumn rel = addRelationDepcy(ids);
                for (IdentifierContext id : tabl.identifier()) {
                    addFilteredColumnDepcy(rel.schema, rel.table, id.getText());
                }
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
