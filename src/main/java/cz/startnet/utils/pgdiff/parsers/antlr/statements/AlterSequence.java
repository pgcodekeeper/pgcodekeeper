package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.nio.file.Path;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Alter_sequence_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Sequence_bodyContext;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgSequence;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgTable;

public class AlterSequence extends ParserAbstract {
private Alter_sequence_statementContext ctx;
    public AlterSequence(Alter_sequence_statementContext ctx, PgDatabase db, Path filePath) {
        super(db, filePath);
        this.ctx = ctx;
    }

    @Override
    public PgStatement getObject() {
        String name = getName(ctx.name);
        String schemaName = getSchemaName(ctx.name);
        if (schemaName == null) {
            schemaName = getDefSchemaName();
        }
        PgSequence sequence = db.getSchema(schemaName).getSequence(name);
        if (sequence == null) {
            logError("SEQUENCE", name);
            return null;
        }
        if (ctx.owner_to() != null) {
            sequence.setOwner(removeQuotes(ctx.owner_to().name));
        }
        for (Sequence_bodyContext seqbody : ctx.sequence_body()) {
            if (seqbody.OWNED() != null && seqbody.col_name != null) {
                sequence.setOwnedBy(getFullCtxText(seqbody.col_name));
                String colName = getTableName(seqbody.col_name);
                String tableName = getTableName(seqbody.col_name);
                String schName = getSchemaName(seqbody.col_name);
                if (tableName.equals(schName)) {
                    schName = schemaName;
                }
                addObjReference(schName, new PgTable(tableName, "" ,""), seqbody.col_name.getStart().getStartIndex());
            }
        }
        addObjReference(schemaName, sequence, ctx.name.getStart().getStartIndex());
        return null;
    }

}
