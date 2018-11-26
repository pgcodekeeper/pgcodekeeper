package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Alter_sequence_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Sequence_bodyContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Tokens_nonreserved_except_function_typeContext;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.AbstractSequence;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;

public class AlterSequence extends ParserAbstract {
    private final Alter_sequence_statementContext ctx;
    public AlterSequence(Alter_sequence_statementContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public PgStatement getObject() {
        List<IdentifierContext> ids = ctx.name.identifier();
        AbstractSchema schema = getSchemaSafe(ids, db.getDefaultSchema());
        AbstractSequence sequence = getSafe(schema::getSequence, QNameParser.getFirstNameCtx(ids));

        fillOwnerTo(ctx.owner_to(), sequence);
        for (Sequence_bodyContext seqbody : ctx.sequence_body()) {
            if (seqbody.OWNED() != null && seqbody.col_name != null) {
                List<IdentifierContext> col = seqbody.col_name.identifier();
                Tokens_nonreserved_except_function_typeContext word;
                if (col.size() != 1 || (word = col.get(0).tokens_nonreserved_except_function_type()) == null
                        || word.NONE() == null) {
                    sequence.setOwnedBy(getFullCtxText(seqbody.col_name));
                }
            }
        }
        return null;
    }

}
