package cz.startnet.utils.pgdiff.parsers.antlr;

import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.CommonTokenStream;
import org.eclipse.core.runtime.IProgressMonitor;

import cz.startnet.utils.pgdiff.parsers.antlr.AntlrContextProcessor.SqlContextProcessor;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Rule_commonContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_createContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.SqlContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.StatementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateRule;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.StatementOverride;

public class SQLOverridesListener extends CustomParserListener
implements SqlContextProcessor {

    private final Map<PgStatement, StatementOverride> overrides;

    public SQLOverridesListener(PgDatabase db, String filename, List<AntlrError> errors,
            IProgressMonitor mon, Map<PgStatement, StatementOverride> overrides) {
        super(db, filename, errors, mon);
        this.overrides = overrides;
    }

    @Override
    public void process(SqlContext rootCtx, CommonTokenStream stream) {
        for (StatementContext s : rootCtx.statement()) {
            Schema_statementContext st = s.schema_statement();
            if (st != null) {
                Schema_createContext create = st.schema_create();
                if (create != null) {
                    Rule_commonContext rule = create.rule_common();
                    if (rule != null) {
                        safeParseStatement(new CreateRule(rule, db, overrides), create);
                    }
                }
            }
        }
    }
}