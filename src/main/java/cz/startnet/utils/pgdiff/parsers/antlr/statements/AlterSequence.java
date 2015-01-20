package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.nio.file.Path;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DbObjType;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Alter_sequence_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Sequence_bodyContext;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgSequence;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.StatementActions;

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
//                String colName = getTableName(seqbody.col_name);
                String tableName = getTableName(seqbody.col_name);
                String schName = getSchemaName(seqbody.col_name);
                if (tableName.equals(schName)) {
                    schName = schemaName;
                }
                int offset = 0; 
                if (schName != null) {
                    offset = schName.length() + 1;
                    addObjReference(null, schName, DbObjType.SCHEMA,
                            StatementActions.NONE, seqbody.col_name.getStart().getStartIndex(), 0);
                }
                addObjReference(schName, tableName, DbObjType.TABLE,
                        StatementActions.NONE, seqbody.col_name.getStart().getStartIndex()+offset, 0);
            }
        }
        addObjReference(schemaName, name, DbObjType.SEQUENCE,
                StatementActions.ALTER, ctx.name.getStart().getStartIndex(), 0);
        return null;
    }

}
