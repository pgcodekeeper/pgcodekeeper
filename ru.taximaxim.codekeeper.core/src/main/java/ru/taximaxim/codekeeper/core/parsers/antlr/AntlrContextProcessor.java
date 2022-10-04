package ru.taximaxim.codekeeper.core.parsers.antlr;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;

import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.SqlContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.Tsql_fileContext;

public interface AntlrContextProcessor<R extends ParserRuleContext> {
    void process(R rootCtx, CommonTokenStream stream);

    public static interface SqlContextProcessor extends AntlrContextProcessor<SqlContext> {
    }

    public static interface TSqlContextProcessor extends AntlrContextProcessor<Tsql_fileContext> {
    }
}
