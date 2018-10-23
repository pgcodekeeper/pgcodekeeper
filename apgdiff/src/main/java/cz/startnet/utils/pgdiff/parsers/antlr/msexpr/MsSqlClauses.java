package cz.startnet.utils.pgdiff.parsers.antlr.msexpr;

import java.util.Collections;
import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Another_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Cfl_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Dbcc_clauseContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Ddl_clauseContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Delete_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Dml_clauseContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Insert_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Merge_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Select_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Sql_clausesContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.St_clauseContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Update_statementContext;

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

    }

    private void cfl(Cfl_statementContext cfl) {

    }

    private void dbcc(Dbcc_clauseContext dbcc) {

    }

    private void another(Another_statementContext another) {

    }

}
