package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_sequence_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Sequence_bodyContext;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgSequence;
import cz.startnet.utils.pgdiff.schema.PgStatement;

public class CreateSequence extends ParserAbstract {
    private final Create_sequence_statementContext ctx;
    public CreateSequence(Create_sequence_statementContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public PgStatement getObject() {
        List<IdentifierContext> ids = ctx.name.identifier();
        PgSequence sequence = new PgSequence(QNameParser.getFirstName(ids), getFullCtxText(ctx.getParent()));
        fillSequence(sequence, ctx.sequence_body());
        getSchemaSafe(ids, db.getDefaultSchema()).addSequence(sequence);
        return sequence;
    }

    public static void fillSequence(PgSequence sequence, List<Sequence_bodyContext> list) {
        long inc = 1;
        Long maxValue = null;
        Long minValue = null;
        String dataType = null;
        for (Sequence_bodyContext body : list) {
            if (body.type != null) {
                dataType = body.type.getText().toLowerCase();
            } else if (body.cache_val != null) {
                sequence.setCache(body.cache_val.getText());
            } else if (body.incr != null) {
                inc = Long.parseLong(body.incr.getText());
            } else if (body.maxval != null) {
                maxValue = Long.parseLong(body.maxval.getText());
            } else if (body.minval != null) {
                minValue = Long.parseLong(body.minval.getText());
            } else if (body.start_val != null) {
                sequence.setStartWith(body.start_val.getText());
            } else if (body.cycle_val != null) {
                sequence.setCycle(body.cycle_true == null);
            } else if (body.col_name != null) {
                // TODO incorrect qualified name work
                // also broken in altersequence
                sequence.setOwnedBy(body.col_name.getText());
            }
        }
        sequence.setMinMaxInc(inc, maxValue, minValue, dataType);
    }
}
