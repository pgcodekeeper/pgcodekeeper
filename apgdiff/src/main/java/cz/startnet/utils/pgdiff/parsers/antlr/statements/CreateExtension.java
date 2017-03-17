package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.AntlrError;
import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_extension_statementContext;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgExtension;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class CreateExtension extends ParserAbstract {
    private final Create_extension_statementContext ctx;
    public CreateExtension(Create_extension_statementContext ctx, PgDatabase db,
            List<AntlrError> errors) {
        super(db, errors);
        this.ctx = ctx;
    }

    @Override
    public PgStatement getObject() {
        PgExtension ext = new PgExtension(QNameParser.getFirstName(ctx.name.identifier()),
                getFullCtxText(ctx.getParent()));
        if (ctx.schema_with_name() != null) {
            ext.setSchema(QNameParser.getFirstName(ctx.schema_with_name().name.identifier()));
            ext.addDep(new GenericColumn(ext.getSchema(), DbObjType.SCHEMA));
        }
        db.addExtension(ext);
        return ext;
    }

}
