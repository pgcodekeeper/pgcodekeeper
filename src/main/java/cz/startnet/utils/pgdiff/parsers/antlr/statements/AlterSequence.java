package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.nio.file.Path;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Alter_sequence_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Sequence_bodyContext;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgSequence;
import cz.startnet.utils.pgdiff.schema.PgStatement;

public class AlterSequence extends ParserAbstract {
private Alter_sequence_statementContext ctx;
    public AlterSequence(Alter_sequence_statementContext ctx, PgDatabase db, Path filePath) {
        super(db, filePath);
        this.ctx = ctx;
    }

    @Override
    public PgStatement getObject() {
        PgSequence seq = new PgSequence(getName(ctx.name), null, null);
        if (ctx.owner_to() !=null) {
            seq.setOwner(removeQuoted(ctx.owner_to().name));
        }
        for (Sequence_bodyContext seqbody : ctx.sequence_body()) {
            if (seqbody.OWNED() != null && 
                    seqbody.col_name!=null) {
                seq.setOwnedBy(getFullCtxText(seqbody.col_name));
            }
        }
        return seq;
    }

}
