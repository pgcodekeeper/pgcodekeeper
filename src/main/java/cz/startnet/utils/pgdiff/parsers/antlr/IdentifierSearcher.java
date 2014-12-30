package cz.startnet.utils.pgdiff.parsers.antlr;

import java.nio.file.Path;

import cz.startnet.utils.pgdiff.parsers.ParserUtils;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Set_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.IdentifierReference;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.Set;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.GenericColumn.ViewReference;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import cz.startnet.utils.pgdiff.schema.PgSet;

public class IdentifierSearcher extends SQLParserBaseListener {

    private PgDatabase db;
    private Path filePath;
    private boolean isInSchemaQualified = false;

    public IdentifierSearcher(PgDatabase db, Path filePath) {
        this.db = db;
        this.filePath = filePath;
    }

    @Override
    public void enterSchema_qualified_name(Schema_qualified_nameContext ctx) {
        GenericColumn col = new IdentifierReference(db, filePath, ctx)
                .getColumn();
        if (col.getType() == ViewReference.COLUMN) {
            return;
        }
        PgObjLocation reference = new PgObjLocation(col.schema, col.table,
                null, ctx.getStart().getStartIndex(), filePath);
        db.addObjReference(reference);
        isInSchemaQualified = true;
    }
    
    @Override
    public void enterIdentifier(IdentifierContext ctx) {
        if (isInSchemaQualified) {
            isInSchemaQualified = false;
            return;
        }
        PgObjLocation reference = new PgObjLocation(db.getDefaultSchema().getName(),
                ctx.getText(),null, ctx.getStart().getStartIndex(), filePath);
        db.addObjReference(reference);
    }
    
    @Override
    public void exitSet_statement(Set_statementContext ctx) {
        PgSet set = (PgSet)new Set(ctx, db, filePath).getObject();
        if (set.getParam().equalsIgnoreCase("search_path")) {
            for (String value : set.getValues()) {
                db.setDefaultSchema(ParserUtils.getObjectName(value));
                break;
            }
        }
    }
}
