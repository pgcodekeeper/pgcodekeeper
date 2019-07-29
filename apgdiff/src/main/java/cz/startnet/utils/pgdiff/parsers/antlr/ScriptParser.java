package cz.startnet.utils.pgdiff.parsers.antlr;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Pattern;

import org.antlr.v4.runtime.CommonTokenStream;

import cz.startnet.utils.pgdiff.DangerStatement;
import cz.startnet.utils.pgdiff.loader.callables.QueryLocation;
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
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Batch_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Ddl_clauseContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Dml_clauseContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Sql_clausesContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.St_clauseContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Tsql_fileContext;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;

public class ScriptParser {

    private static final Pattern PATTERN_WS = Pattern.compile("\\s+");

    private final String script;
    private final List<List<QueryLocation>> batches = new ArrayList<>();
    private final List<AntlrError> errors = new ArrayList<>();
    private final Set<DangerStatement> dangerStatements = EnumSet.noneOf(DangerStatement.class);

    public ScriptParser(String name, String script, boolean isMsSql) {
        this.script = script;
        SqlContext sql = null;
        Tsql_fileContext tsql = null;
        if (isMsSql) {
            TSQLParser[] parser = new TSQLParser[1];
            tsql = AntlrParser.parseSqlString(TSQLParser.class,
                    p -> { parser[0] = p; return p.tsql_file(); },
                    script, name, errors);
            if (!errors.isEmpty()) {
                return;
            }
            checkMsDanger(tsql);
            batchMs(tsql, (CommonTokenStream) parser[0].getInputStream());
        } else {
            sql = AntlrParser.parseSqlString(SQLParser.class, SQLParser::sql,
                    script, name, errors);
            if (!errors.isEmpty()) {
                return;
            }
            checkPgDanger(sql);
            batchPg(sql);
        }
    }

    public List<List<QueryLocation>> batch() {
        return batches;
    }

    private void batchMs(Tsql_fileContext rootCtx, CommonTokenStream stream) {
        for (BatchContext batch : rootCtx.batch()) {
            List<QueryLocation> l = new ArrayList<>();
            if (batch.batch_statement() != null) {
                Batch_statementContext st = batch.batch_statement();
                String query = ParserAbstract
                        .getFullCtxTextWithHidden(batch.batch_statement(), stream);
                l.add(new QueryLocation(getStmtAction(query), getOffsetInFullTxt(query),
                        st.getStart().getLine(), query));
            } else {
                List<St_clauseContext> clauses = batch.sql_clauses().st_clause();
                for (St_clauseContext clause : clauses) {
                    String query = ParserAbstract.getFullCtxText(clause);
                    l.add(new QueryLocation(getStmtAction(query), getOffsetInFullTxt(query),
                            clause.getStart().getLine(), query));
                }
            }
            batches.add(l);
        }
    }

    private void batchPg(SqlContext rootCtx) {
        List<QueryLocation> l = new ArrayList<>();
        batches.add(l);

        for (StatementContext st : rootCtx.statement()) {
            String query = ParserAbstract.getFullCtxText(st);
            l.add(new QueryLocation(getStmtAction(query), getOffsetInFullTxt(query),
                    st.getStart().getLine(), query));
        }
    }

    private String getStmtAction(String query) {
        // trim to avoid empty strings at the edges of the array
        String[] arr = PATTERN_WS.split(query.trim(), 3);
        if (arr[0].isEmpty()) {
            // empty or whitespace query, wtf was that
            return null;
        }

        String message = arr[0].toUpperCase(Locale.ROOT);
        if (arr.length > 1) {
            switch (message) {
            case "CREATE":
            case "ALTER":
            case "DROP":
            case "START":
            case "BEGIN":
                message += ' ' + arr[1].toUpperCase(Locale.ROOT);
            }
        }
        return message;
    }

    private int getOffsetInFullTxt(String query) {
        return script.indexOf(query);
    }

    private void checkPgDanger(SqlContext rootCtx) {
        for (StatementContext st : rootCtx.statement()) {
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

    private void checkMsDanger(Tsql_fileContext rootCtx) {
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

    public boolean isDangerDdl(Collection<DangerStatement> allowedDangers) {
        return !allowedDangers.containsAll(dangerStatements);
    }

    public Set<DangerStatement> getDangerDdl(Collection<DangerStatement> allowedDangers) {
        Set<DangerStatement> danger = EnumSet.noneOf(DangerStatement.class);

        for (DangerStatement d : dangerStatements) {
            if (!allowedDangers.contains(d)) {
                danger.add(d);
            }
        }

        return danger;
    }


    public String getErrorMessage() {
        if (!errors.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Errors while parse script:\n");
            for (AntlrError er : errors) {
                sb.append(er).append('\n');
            }
            return sb.toString();
        }

        return null;
    }

    public String getScript() {
        return script;
    }
}
