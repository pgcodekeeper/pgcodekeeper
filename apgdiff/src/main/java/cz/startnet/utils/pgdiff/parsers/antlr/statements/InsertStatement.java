package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Insert_stmt_for_psqlContext;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.utils.Pair;

public class InsertStatement extends ParserAbstract {

    private final Insert_stmt_for_psqlContext ctx;

    public InsertStatement(Insert_stmt_for_psqlContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        addObjReference(ctx.insert_table_name.identifier(), DbObjType.TABLE, ACTION_INSERT);
    }

    @Override
    protected Pair<String, GenericColumn> getActionAndObjForStmtAction() {
        List<IdentifierContext> ids = ctx.insert_table_name.identifier();
        return new Pair<>(ACTION_INSERT, new GenericColumn(QNameParser.getSchemaName(ids),
                QNameParser.getFirstNameCtx(ids).getText(), DbObjType.TABLE));
    }
}
