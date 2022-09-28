package ru.taximaxim.codekeeper.core.parsers.antlr.statements;

import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.QNameParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Alter_index_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Schema_qualified_nameContext;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.PgIndex;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation;

public class AlterIndex extends ParserAbstract {

    private final Alter_index_statementContext ctx;
    private final String alterIdxAllAction;

    public AlterIndex(Alter_index_statementContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
        alterIdxAllAction = ctx.ALL() == null ? null : "ALTER INDEX ALL";
    }

    @Override
    public void parseObject() {
        if (alterIdxAllAction != null) {
            PgObjLocation loc = new PgObjLocation.Builder()
                    .setAction(alterIdxAllAction)
                    .setCtx(ctx.getParent())
                    .build();

            db.addReference(fileName, loc);
            return;
        }

        List<ParserRuleContext> ids = getIdentifiers(ctx.schema_qualified_name());

        Schema_qualified_nameContext inherit = ctx.index_def_action().index;

        if (inherit != null) {
            // in this case inherit is real index name
            List<ParserRuleContext> idsInh = getIdentifiers(inherit);

            PgIndex index = (PgIndex) getSafe(AbstractSchema::getIndexByName,
                    getSchemaSafe(idsInh), QNameParser.getFirstNameCtx(idsInh));

            String inhSchemaName = getSchemaNameSafe(ids);
            String inhTableName = QNameParser.getFirstName(ids);
            doSafe((i,o) -> i.addInherit(inhSchemaName, inhTableName), index, null);
            addDepSafe(index, ids, DbObjType.INDEX, true);

            addObjReference(idsInh, DbObjType.INDEX, ACTION_ALTER);
        } else {
            addObjReference(ids, DbObjType.INDEX, ACTION_ALTER);
        }
    }

    @Override
    protected String getStmtAction() {
        return alterIdxAllAction != null ? alterIdxAllAction
                : getStrForStmtAction(ACTION_ALTER, DbObjType.INDEX,
                        getIdentifiers(ctx.schema_qualified_name()));
    }
}
