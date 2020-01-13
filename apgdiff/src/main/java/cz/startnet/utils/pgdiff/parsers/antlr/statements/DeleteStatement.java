package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Delete_stmt_for_psqlContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.utils.Pair;

public class DeleteStatement extends ParserAbstract {

    private final Delete_stmt_for_psqlContext ctx;

    public DeleteStatement(Delete_stmt_for_psqlContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        addObjReference(ctx.delete_table_name.identifier(), DbObjType.TABLE, ACTION_DELETE);
    }

    @Override
    protected Pair<String, GenericColumn> getActionAndObjForStmtAction() {
        List<IdentifierContext> ids = ctx.delete_table_name.identifier();
        return new Pair<>(ACTION_DELETE, new GenericColumn(QNameParser.getSchemaName(ids),
                QNameParser.getFirstName(ids), DbObjType.TABLE));
    }
}
