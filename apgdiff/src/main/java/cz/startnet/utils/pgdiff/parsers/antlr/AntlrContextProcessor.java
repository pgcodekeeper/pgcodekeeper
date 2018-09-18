package cz.startnet.utils.pgdiff.parsers.antlr;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.SqlContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Tsql_fileContext;

public interface AntlrContextProcessor<R extends ParserRuleContext> {
    void process(R rootCtx);

    public static interface SqlContextProcessor extends AntlrContextProcessor<SqlContext> {
    }

    public static interface TSqlContextProcessor extends AntlrContextProcessor<Tsql_fileContext> {
    }
}
