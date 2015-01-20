package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.nio.file.Path;

import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DbObjType;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Index_statementContext;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgIndex;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.StatementActions;

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
        addObjReference(schemaName, getName(ctx.table_name), DbObjType.TABLE,
                StatementActions.NONE, ctx.table_name.getStart().getStartIndex(), 0);
        ind.setTableName(getName(ctx.table_name));
        ind.setDefinition(getFullCtxText(ctx.using_def()));
        ind.setUnique(ctx.UNIQUE() != null);
        if (name != null) {
            if (db.getSchema(schemaName) == null) {
                logSkipedObject(schemaName, "TRIGGER", ind.getTableName());
                return null;
            } else if(db.getSchema(schemaName).getTable(ind.getTableName()) == null) {
                Log.log(Log.LOG_ERROR,
                        new StringBuilder().append("TABLE ")
                                .append(ind.getTableName())
                                .append(" not found on schema ").append(schemaName)
                                .append(" That's why index ").append(name)
                                .append("will be skipped").toString());
                return null;
            }
            db.getSchema(schemaName).getTable(ind.getTableName()).addIndex(ind);
            fillObjDefinition(schemaName, ind, ctx.name.getStart().getStartIndex());
        }
        return ind;
    }

}
