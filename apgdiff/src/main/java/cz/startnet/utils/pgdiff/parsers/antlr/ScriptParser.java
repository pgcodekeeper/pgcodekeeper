package cz.startnet.utils.pgdiff.parsers.antlr;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.antlr.v4.runtime.CommonTokenStream;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.SqlContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.StatementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.BatchContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.St_clauseContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Tsql_fileContext;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;

public class ScriptParser {

    private final String name;
    private final List<AntlrError> errors = new ArrayList<>();

    public ScriptParser(String name) {
        this.name = name;
    }

    public List<List<String>> parse(String script, boolean isMsSql)
            throws InterruptedException, ExecutionException {
        return isMsSql ? parseMs(script) : parsePg(script);
    }

    private List<List<String>> parseMs(String script) throws InterruptedException, ExecutionException {
        List<List<String>> list = new ArrayList<>();
        TSQLParser parser = AntlrParser.makeBasicParser(TSQLParser.class, script, name, errors);
        Future<Tsql_fileContext> future = AntlrParser.ANTLR_POOL.submit(parser::tsql_file);
        CommonTokenStream stream = (CommonTokenStream) parser.getInputStream();
        List<BatchContext> batches = future.get().batch();

        for (BatchContext batch : batches) {
            List<String> l = new ArrayList<>();
            if (batch.batch_statement() != null) {
                l.add(ParserAbstract.getFullCtxTextWithHidden(batch.batch_statement(), stream));
            } else {
                List<St_clauseContext> clauses = batch.sql_clauses().st_clause();
                for (St_clauseContext clause : clauses) {
                    l.add(ParserAbstract.getFullCtxText(clause));
                }
            }
            list.add(l);
        }

        return list;
    }

    private List<List<String>> parsePg(String script) throws InterruptedException, ExecutionException {
        Future<SqlContext> future = AntlrParser.ANTLR_POOL
                .submit(() -> AntlrParser.makeBasicParser(SQLParser.class, script, name, errors).sql());

        List<String> l = new ArrayList<>();

        List<StatementContext> statements = future.get().statement();

        if (errors.isEmpty()) {
            for (StatementContext st : statements) {
                l.add(ParserAbstract.getFullCtxText(st));
            }
        } else {
            // if has unsupported statement try to execute all script as one statement (like old mechanism)
            l.add(script);
        }

        List<List<String>> list = new ArrayList<>(1);
        list.add(l);
        return list;
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
}
