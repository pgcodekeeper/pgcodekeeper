package cz.startnet.utils.pgdiff.parsers.antlr;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cz.startnet.utils.pgdiff.DangerStatement;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Alter_sequence_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Alter_table_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Data_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Drop_statementsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_alterContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_dropContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.SqlContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.StatementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Table_actionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Alter_tableContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.BatchContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Ddl_clauseContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Dml_clauseContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Sql_clausesContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.St_clauseContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Tsql_fileContext;

public class DangerStatementParser {

    private final Set<DangerStatement> dangerStatements = new HashSet<>();

    public void checkDanger(String statement, boolean isMsSql) {
        if (isMsSql) {
            checkPgDanger(statement);
        } else {
            checkMsDanger(statement);
        }
    }

    public void checkPgDanger(String statement) {
        List<AntlrError> errors = new ArrayList<>();
        SqlContext sql = AntlrParser.makeBasicParser(SQLParser.class, statement,
                "Statement: " + statement, errors).sql();

        for (StatementContext st : sql.statement()) {
            Schema_statementContext schema = st.schema_statement();
            Data_statementContext ds;
            if (schema != null) {
                Schema_alterContext alter = schema.schema_alter();
                Schema_dropContext drop;
                if (alter != null) {
                    alter(alter);
                } else if ((drop = schema.schema_drop()) != null) {
                    Drop_statementsContext dropSt = drop.drop_statements();
                    if (dropSt != null && dropSt.TABLE() != null) {
                        dangerStatements.add(DangerStatement.DROP_TABLE);
                    }
                }
            } else if ((ds = st.data_statement()) != null
                    && ds.update_stmt_for_psql() != null) {
                dangerStatements.add(DangerStatement.UPDATE);
            }
        }
    }

    private void alter(Schema_alterContext alter) {
        Alter_sequence_statementContext seq = alter.alter_sequence_statement();
        Alter_table_statementContext at;
        if (seq != null && !seq.RESTART().isEmpty()) {
            dangerStatements.add(DangerStatement.RESTART_WITH);
        } else if ((at = alter.alter_table_statement()) != null) {
            for (Table_actionContext tablAction : at.table_action()) {
                if (tablAction.column != null && tablAction.DROP() != null) {
                    dangerStatements.add(DangerStatement.DROP_COLUMN);
                } else if (tablAction.datatype != null) {
                    dangerStatements.add(DangerStatement.ALTER_COLUMN);
                }
            }
        }
    }

    public void checkMsDanger(String statement) {
        List<AntlrError> errors = new ArrayList<>();
        Tsql_fileContext rootCtx = AntlrParser
                .makeBasicParser(TSQLParser.class, statement, "Statement: " + statement, errors)
                .tsql_file();

        for (BatchContext b : rootCtx.batch()) {
            Sql_clausesContext clauses = b.sql_clauses();
            if (clauses != null) {
                for (St_clauseContext st : clauses.st_clause()) {
                    clause(st);
                }
            }
        }
    }

    private void clause(St_clauseContext st) {
        Ddl_clauseContext ddl = st.ddl_clause();
        Dml_clauseContext dml;
        if (ddl != null) {
            ddl(ddl);
        } else if ((dml = st.dml_clause()) != null && dml.update_statement() != null) {
            dangerStatements.add(DangerStatement.UPDATE);
        }
    }

    private void ddl(Ddl_clauseContext ddl) {
        cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Schema_alterContext alter = ddl.schema_alter();
        cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Schema_dropContext drop;
        if (alter != null) {
            Alter_tableContext at = alter.alter_table();
            if (at != null) {
                if (at.DROP() != null && at.COLUMN() != null) {
                    dangerStatements.add(DangerStatement.DROP_COLUMN);
                } else if (at.ALTER() != null && at.COLUMN() != null) {
                    dangerStatements.add(DangerStatement.ALTER_COLUMN);
                }
            } else if (alter.alter_sequence() != null
                    && !alter.alter_sequence().RESTART().isEmpty()) {
                dangerStatements.add(DangerStatement.RESTART_WITH);
            }
        } else if ((drop = ddl.schema_drop()) != null) {
            cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Drop_statementsContext dropSt = drop.drop_statements();
            if (dropSt != null && dropSt.TABLE() != null) {
                dangerStatements.add(DangerStatement.DROP_TABLE);
            }
        }
    }

    public Set<DangerStatement> getDangerStatements() {
        return dangerStatements;
    }

    public boolean isDangerDdl(Collection<DangerStatement> allowedDangers) {
        for (DangerStatement d : dangerStatements) {
            if (!allowedDangers.contains(d)) {
                return true;
            }
        }

        return false;
    }
}