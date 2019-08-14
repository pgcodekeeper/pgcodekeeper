package cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.DangerStatement;
import cz.startnet.utils.pgdiff.loader.QueryLocation;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Alter_assemblyContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Assembly_optionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.MsAssembly;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.StatementActions;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class AlterMsAssembly extends ParserAbstract {

    private final Alter_assemblyContext ctx;

    public AlterMsAssembly(Alter_assemblyContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        MsAssembly assembly = getSafe(PgDatabase::getAssembly, db, ctx.name);
        addObjReference(Arrays.asList(ctx.name), DbObjType.ASSEMBLY, StatementActions.ALTER);

        List<Assembly_optionContext> options = ctx.assembly_option();
        if (options != null) {
            for (Assembly_optionContext option : options) {
                if (option.VISIBILITY() != null) {
                    doSafe(MsAssembly::setVisible, assembly, option.ON() != null);
                }
            }
        }
    }

    @Override
    protected void fillQueryLocation(String fullScript, List<List<QueryLocation>> batches,
            Set<DangerStatement> dangerStatements) {
        ParserRuleContext ctxWithActionName = ctx.getParent();
        String query = ParserAbstract.getFullCtxText(ctxWithActionName);
        batches.get(batches.size() - 1).add(new QueryLocation(getStmtAction(query),
                fullScript.indexOf(query), ctxWithActionName.getStart().getLine(), query));
    }
}
