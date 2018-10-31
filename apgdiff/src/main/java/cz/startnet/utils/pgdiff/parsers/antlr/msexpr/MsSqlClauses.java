package cz.startnet.utils.pgdiff.parsers.antlr.msexpr;

import java.util.Collections;
import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Another_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Block_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Cfl_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Cursor_commonContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Cursor_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Dbcc_clauseContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Ddl_clauseContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Declare_localContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Declare_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Delete_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Dml_clauseContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Enable_disable_triggerContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Execute_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.ExpressionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Expression_listContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.If_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Insert_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Lock_tableContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Merge_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Names_referencesContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Print_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Qualified_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Receive_column_specifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Receive_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Return_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Select_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Set_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Sql_clausesContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.St_clauseContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Top_clauseContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Truncate_tableContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Try_catch_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Update_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Update_statisticsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Waitfor_receiveContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Waitfor_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.While_statementContext;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class MsSqlClauses extends MsAbstractExprWithNmspc<Sql_clausesContext> {

    protected MsSqlClauses(MsAbstractExpr parent) {
        super(parent);
    }

    public MsSqlClauses(String schema) {
        super(schema);
    }

    @Override
    public List<String> analyze(Sql_clausesContext sql) {
        for (St_clauseContext st : sql.st_clause()) {
            clause(st);
        }

        return Collections.emptyList();
    }

    private void clause(St_clauseContext st) {
        Dml_clauseContext dml = st.dml_clause();
        Ddl_clauseContext ddl;
        Cfl_statementContext cfl;
        Dbcc_clauseContext dbcc;
        Another_statementContext another;
        if (dml != null) {
            dml(dml);
        } else if ((ddl = st.ddl_clause()) != null) {
            ddl(ddl);
        } else if ((cfl = st.cfl_statement()) != null) {
            cfl(cfl);
        } else if ((dbcc = st.dbcc_clause()) != null) {
            dbcc(dbcc);
        } else if ((another = st.another_statement()) != null) {
            another(another);
        }

    }

    private void dml(Dml_clauseContext dml) {
        Merge_statementContext ms = dml.merge_statement();
        Delete_statementContext ds;
        Insert_statementContext is;
        Select_statementContext ss;
        Update_statementContext us;

        if (ms != null) {
            new MsMerge(this).analyze(ms);
        } else if ((ds = dml.delete_statement()) != null) {
            new MsDelete(this).analyze(ds);
        } else if ((is = dml.insert_statement()) != null) {
            new MsInsert(this).analyze(is);
        } else if ((ss = dml.select_statement()) != null) {
            new MsSelect(this).analyze(ss);
        } else if ((us = dml.update_statement()) != null) {
            new MsUpdate(this).analyze(us);
        }
    }

    private void ddl(Ddl_clauseContext ddl) {
        Lock_tableContext lt = ddl.lock_table();
        Truncate_tableContext tt;
        Enable_disable_triggerContext edt;
        Update_statisticsContext us;

        if (lt != null) {
            addObjectDepcy(lt.qualified_name(), DbObjType.TABLE);
        } else if ((tt = ddl.truncate_table()) != null) {
            addObjectDepcy(tt.qualified_name(), DbObjType.TABLE);
        } else if ((edt = ddl.enable_disable_trigger()) != null) {
            enableDisableTrigger(edt);
        } else if ((us = ddl.update_statistics()) != null) {
            updateStatistics(us);
        }
    }

    private void enableDisableTrigger(Enable_disable_triggerContext edt) {
        Qualified_nameContext qualifiedName = edt.qualified_name();
        if (qualifiedName != null) {
            GenericColumn cont = addObjectDepcy(qualifiedName, DbObjType.TABLE);
            Names_referencesContext names = edt.names_references();
            if (names != null) {
                for (Qualified_nameContext trig : names.qualified_name()) {
                    addDepcy(new GenericColumn(cont.schema,
                            cont.table, trig.name.getText(), DbObjType.TRIGGER));
                }
            }
        }
    }

    private void updateStatistics(Update_statisticsContext us) {
        GenericColumn cont = addObjectDepcy(us.table_name, DbObjType.TABLE);
        Qualified_nameContext index = us.index_name;
        Names_referencesContext names;
        if (index != null) {
            addDepcy(new GenericColumn(cont.schema,
                    cont.table, index.name.getText(), DbObjType.TRIGGER));
        } else if ((names = us.names_references()) != null) {
            for (Qualified_nameContext ind : names.qualified_name()) {
                addDepcy(new GenericColumn(cont.schema,
                        cont.table, ind.name.getText(), DbObjType.TRIGGER));
            }
        }
    }

    private void cfl(Cfl_statementContext cfl) {
        Block_statementContext block = cfl.block_statement();
        If_statementContext is;
        Return_statementContext rs;
        Try_catch_statementContext tcs;
        Waitfor_statementContext wfs;
        While_statementContext ws;
        Print_statementContext ps;

        if (block != null) {
            analyze(block.sql_clauses());
        } else if ((is = cfl.if_statement()) != null) {
            new MsValueExpr(this).search(is.search_condition());

            for (St_clauseContext clause : is.st_clause()) {
                clause(clause);
            }
        } else if ((rs = cfl.return_statement()) != null) {
            ExpressionContext exp = rs.expression();
            if (exp != null) {
                new MsValueExpr(this).analyze(rs.expression());
            }
        } else if ((tcs = cfl.try_catch_statement()) != null) {
            for (Sql_clausesContext clauses : tcs.sql_clauses()) {
                analyze(clauses);
            }
        } else if ((wfs = cfl.waitfor_statement()) != null) {
            Waitfor_receiveContext rec = wfs.waitfor_receive();
            if (rec != null) {
                receive(rec.receive_statement());
            }
        } else if ((ws = cfl.while_statement()) != null) {
            new MsValueExpr(this).search(ws.search_condition());
            clause(ws.st_clause());
        } else if ((ps = cfl.print_statement()) != null) {
            ExpressionContext exp = ps.expression();
            if (exp != null) {
                new MsValueExpr(this).analyze(exp);
            }
        }
    }

    private void receive(Receive_statementContext receive) {
        Top_clauseContext top = receive.top_clause();
        if (top != null) {
            ExpressionContext exp = top.top_count().expression();
            if (exp != null) {
                new MsValueExpr(this).analyze(exp);
            }
        }

        for (Receive_column_specifierContext col : receive.receive_column_specifier()) {
            ExpressionContext exp = col.expression();
            if (exp != null) {
                new MsValueExpr(this).analyze(exp);
            }
        }

        if (receive.WHERE() != null) {
            new MsValueExpr(this).search(receive.search_condition());
        }
    }

    private void dbcc(Dbcc_clauseContext dbcc) {
        Expression_listContext list = dbcc.expression_list();
        if (list != null) {
            new MsValueExpr(this).expressionList(list);
        }
    }

    private void another(Another_statementContext another) {
        Declare_statementContext dec = another.declare_statement();
        Cursor_statementContext cursor;
        Receive_statementContext receive;
        Execute_statementContext exec;
        Set_statementContext set;

        if (dec != null) {
            declare(dec);
        } else if ((cursor = another.cursor_statement()) != null) {
            cursor(cursor);
        } else if ((receive = another.receive_statement())!= null) {
            receive(receive);
        } else if ((exec = another.execute_statement())!= null) {
            new MsValueExpr(this).analyze(exec.expression());
        } else if ((set = another.set_statement()) != null) {
            set(set);
        }
    }

    private void set(Set_statementContext set) {
        ExpressionContext exp = set.expression();
        Cursor_commonContext cc;

        if (exp != null) {
            new MsValueExpr(this).analyze(exp);
        } else if ((cc = set.cursor_common()) != null) {
            new MsSelect(this).analyze(cc.select_statement());
        }
    }

    private void cursor(Cursor_statementContext cursor) {
        ExpressionContext exp = cursor.expression();
        Cursor_commonContext cc;
        if (exp != null) {
            new MsValueExpr(this).analyze(exp);
        } else if ((cc = cursor.cursor_common()) != null) {
            new MsSelect(this).analyze(cc.select_statement());
        }
    }

    private void declare(Declare_statementContext dec) {
        for (Declare_localContext local : dec.declare_local()) {
            ExpressionContext exp = local.expression();
            if (exp != null) {
                new MsValueExpr(this).analyze(exp);
            }
        }
    }
}
