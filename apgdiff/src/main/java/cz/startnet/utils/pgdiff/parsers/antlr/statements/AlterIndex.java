package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Alter_index_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_nameContext;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgIndex;
import cz.startnet.utils.pgdiff.schema.StatementActions;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class AlterIndex extends ParserAbstract {

    private final Alter_index_statementContext ctx;

    public AlterIndex(Alter_index_statementContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        if (ctx.ALL() != null) {
            return;
        }

        List<IdentifierContext> ids = ctx.schema_qualified_name().identifier();

        Schema_qualified_nameContext inherit = ctx.index_def_action().index;

        if (inherit != null) {
            // in this case inherit is real index name
            List<IdentifierContext> idsInh = inherit.identifier();

            PgIndex index = (PgIndex) getSafe(AbstractSchema::getIndexByName,
                    getSchemaSafe(idsInh), QNameParser.getFirstNameCtx(idsInh));

            String inhSchemaName = getSchemaNameSafe(ids);
            String inhTableName = QNameParser.getFirstName(ids);
            doSafe((i,o) -> i.addInherit(inhSchemaName, inhTableName), index, null);
            addDepSafe(index, ids, DbObjType.INDEX, true);

            addObjReference(idsInh, DbObjType.INDEX, StatementActions.ALTER);
        } else {
            addObjReference(ids, DbObjType.INDEX, StatementActions.ALTER);
        }
    }
}