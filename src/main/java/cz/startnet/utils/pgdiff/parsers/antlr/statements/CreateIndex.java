package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.nio.file.Path;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Index_statementContext;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgIndex;
import cz.startnet.utils.pgdiff.schema.PgStatement;

public class CreateIndex extends ParserAbstract {
    private final Index_statementContext ctx;
    
    public CreateIndex(Index_statementContext ctx, PgDatabase db, Path filePath) {
        super(db, filePath);
        this.ctx = ctx;
    }

    @Override
    public PgStatement getObject() {
        String name = getName(ctx.name);
        String schemaName =getSchemaName(ctx.name);
        if (schemaName==null) {
            schemaName = getDefSchemaName();
        }
        PgIndex ind = new PgIndex(name != null ? name : "", getFullCtxText(ctx.getParent()), db.getDefSearchPath());
        ind.setTableName(getName(ctx.table_name));
        ind.setDefinition(getFullCtxText(ctx.using_def()));
        ind.setUnique(ctx.UNIQUE() != null);
        if (name != null) {
            db.getSchema(schemaName).getTable(ind.getTableName()).addIndex(ind);
            fillObjLocation(ind, ctx.name.getStart().getStartIndex(),schemaName, 
                    db.getSchema(schemaName).getTable(ind.getTableName()).getIndex(name) !=null);
        }
        return ind;
    }

}
