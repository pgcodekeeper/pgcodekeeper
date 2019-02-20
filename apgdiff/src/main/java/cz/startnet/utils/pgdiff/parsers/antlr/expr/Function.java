package cz.startnet.utils.pgdiff.parsers.antlr.expr;

import java.util.Collections;
import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Arguments_listContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Base_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Case_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Control_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Cursor_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Data_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Data_typeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Data_type_decContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.DeclarationsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Delete_stmt_for_psqlContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Exception_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Function_blockContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Function_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Function_statementsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.If_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Insert_stmt_for_psqlContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Loop_startContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Loop_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Message_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.OptionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Perform_stmtContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Plpgsql_functionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Raise_usingContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Return_stmtContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Select_stmtContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Select_stmt_no_parensContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Type_declarationContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Update_stmt_for_psqlContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Using_vexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Var_assign_valueContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.VexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.rulectx.SelectStmt;
import cz.startnet.utils.pgdiff.parsers.antlr.rulectx.Vex;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import ru.taximaxim.codekeeper.apgdiff.utils.Pair;

public class Function extends AbstractExprWithNmspc<Plpgsql_functionContext> {

    public Function(PgDatabase db) {
        super(db);
    }

    protected Function(AbstractExpr parent) {
        super(parent);
    }

    @Override
    public List<Pair<String, String>> analyze(Plpgsql_functionContext root) {
        block(root.function_block());
        return Collections.emptyList();
    }

    private void block(Function_blockContext block) {
        declare(block.declarations());
        statements(block.function_statements());
        exception(block.exception_statement());
    }

    private void declare(DeclarationsContext declare) {
        if (declare == null) {
            return;
        }

        ValueExpr vex = new ValueExpr(this);

        for (Type_declarationContext dec : declare.type_declaration()) {
            VexContext vexCtx = dec.vex();
            if (vexCtx != null) {
                vex.analyze(new Vex(vexCtx));
            }

            Data_type_decContext datatype = dec.data_type_dec();
            if (datatype != null) {
                addTypeDepcy(datatype.data_type());
            }

            Arguments_listContext list = dec.arguments_list();
            if (list != null) {
                for (Data_typeContext type : list.data_type()) {
                    addTypeDepcy(type);
                }
            }

            Select_stmtContext select = dec.select_stmt();
            if (select != null) {
                new Select(this).analyze(new SelectStmt(select));
            }
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
            if (block != null) {
                block(block);
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
            }
        }
    }

    private void base(Base_statementContext base) {
        Var_assign_valueContext assign = base.var_assign_value();
        VexContext vexCtx;
        Perform_stmtContext perform;

        if (assign != null) {
            Select_stmt_no_parensContext select = assign.select_stmt_no_parens();
            if (select != null) {
                new Select(this).analyze(new SelectStmt(select));
            } else {
                new Select(this).analyze(assign.perform_stmt());
            }
        } else if ((vexCtx = base.vex()) != null) {
            ValueExpr vex = new ValueExpr(this);
            vex.analyze(new Vex(vexCtx));
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
        ValueExpr vex = new ValueExpr(this);

        Function_statementsContext statements = loop.function_statements();
        VexContext vexCtx;

        if (statements != null) {
            statements(statements);
            Loop_startContext start = loop.loop_start();
            if (start != null) {
                start(start);
            }
        } else if ((vexCtx = loop.vex()) != null) {
            vex.analyze(new Vex(vexCtx));
        }
    }

    private void start(Loop_startContext start) {
        Using_vexContext using = start.using_vex();
        Select_stmt_no_parensContext select;
        ValueExpr vex = new ValueExpr(this);

        for (VexContext v : start.vex()) {
            vex.analyze(new Vex(v));
        }

        for (OptionContext option : start.option()) {
            vex.analyze(new Vex(option.vex()));
        }

        if (using != null) {
            for (VexContext v : using.vex()) {
                vex.analyze(new Vex(v));
            }
        } else if ((select = start.select_stmt_no_parens())!= null) {
            new Select(this).analyze(new SelectStmt(select));
        }
    }

    private void returnStmt(Return_stmtContext returnStmt) {
        ValueExpr vex = new ValueExpr(this);

        VexContext vexCtx = returnStmt.vex();
        Select_stmtContext select;

        if (vexCtx != null) {
            vex.analyze(new Vex(vexCtx));
            Using_vexContext using = returnStmt.using_vex();
            if (using != null) {
                for (VexContext v : using.vex()) {
                    vex.analyze(new Vex(v));
                }
            }
        } else if ((select = returnStmt.select_stmt())!= null) {
            new Select(this).analyze(new SelectStmt(select));
        }
    }

    private void cursor(Cursor_statementContext cursor) {
        ValueExpr vex = new ValueExpr(this);
        List<OptionContext> options = cursor.option();
        Select_stmtContext select;
        Schema_qualified_nameContext name;
        VexContext vexCtx;
        if (!options.isEmpty()) {
            for (OptionContext option : options) {
                vex.analyze(new Vex(option.vex()));
            }
        } else if ((select = cursor.select_stmt()) != null) {
            new Select(this).analyze(new SelectStmt(select));
        } else if ((vexCtx = cursor.vex()) != null) {
            vex.analyze(new Vex(vexCtx));
            Using_vexContext using = cursor.using_vex();
            if (using != null) {
                for (VexContext v : using.vex()) {
                    vex.analyze(new Vex(v));
                }
            }
        } else if ((name = cursor.schema_qualified_name()) != null) {
            addNameReference(name, null);
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
        if (select != null) {
            new Select(this).analyze(new SelectStmt(select));
        } else if ((insert = data.insert_stmt_for_psql()) != null) {
            new Insert(this).analyze(insert);
        } else if ((update = data.update_stmt_for_psql()) != null) {
            new Update(this).analyze(update);
        } else if ((delete = data.delete_stmt_for_psql()) != null) {
            new Delete(this).analyze(delete);
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
