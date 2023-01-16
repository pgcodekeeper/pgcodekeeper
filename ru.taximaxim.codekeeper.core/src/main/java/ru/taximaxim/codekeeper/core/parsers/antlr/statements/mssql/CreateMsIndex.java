package ru.taximaxim.codekeeper.core.parsers.antlr.statements.mssql;

import java.util.Arrays;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.ClusteredContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.Create_indexContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.IdContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.Qualified_nameContext;
import ru.taximaxim.codekeeper.core.schema.AbstractIndex;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.MsIndex;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.PgStatementContainer;

public class CreateMsIndex extends MsTableAbstract {

    private final Create_indexContext ctx;

    public CreateMsIndex(Create_indexContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        IdContext schemaCtx = ctx.qualified_name().schema;
        IdContext tableCtx = ctx.qualified_name().name;
        IdContext nameCtx = ctx.name;
        List<ParserRuleContext> ids = Arrays.asList(schemaCtx, nameCtx);
        AbstractSchema schema = getSchemaSafe(ids);
        addObjReference(Arrays.asList(schemaCtx, tableCtx), DbObjType.TABLE, null);

        AbstractIndex ind = new MsIndex(nameCtx.getText());
        ind.setUnique(ctx.UNIQUE() != null);
        ClusteredContext cluster = ctx.clustered();
        ind.setClusterIndex(cluster != null && cluster.CLUSTERED() != null);

        parseIndex(ctx.index_rest(), ind, schemaCtx == null ? null : schemaCtx.getText(), tableCtx.getText());

        PgStatementContainer table = getSafe(AbstractSchema::getStatementContainer, schema, tableCtx);
        addSafe(table, ind, Arrays.asList(schemaCtx, tableCtx, nameCtx));
    }

    @Override
    protected String getStmtAction() {
        Qualified_nameContext qualNameCtx = ctx.qualified_name();
        return getStrForStmtAction(ACTION_CREATE, DbObjType.INDEX,
                Arrays.asList(qualNameCtx.schema, qualNameCtx.name, ctx.name));
    }
}
