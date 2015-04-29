package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.nio.file.Path;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_nameContext;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.GenericColumn.ViewReference;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;

public class IdentifierReference extends ParserAbstract {

    private Schema_qualified_nameContext ctx;

    public IdentifierReference(PgDatabase db, Path filePath,
            Schema_qualified_nameContext ctx) {
        super(db, filePath);
        this.ctx = ctx;
    }

    @Override
    public PgStatement getObject() {
        return null;
    }

    public GenericColumn getColumn() {
        String name = getName(ctx);
        String tableName = getTableName(ctx);
        String schemaName = getSchemaName(ctx);
        GenericColumn col = null;
        if (schemaName != null && !schemaName.equals(tableName)) {
            col = new GenericColumn(schemaName, tableName, name);
        } else {
            col = new GenericColumn(tableName != null ?
                    tableName : getDefSchemaName(), name, null);
            col.setType(ViewReference.TABLE);
        }
        return col;
    }

}
