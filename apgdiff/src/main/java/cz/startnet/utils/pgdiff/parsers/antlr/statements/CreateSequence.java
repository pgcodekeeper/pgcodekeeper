package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.nio.file.Path;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_sequence_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Sequence_bodyContext;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgSequence;
import cz.startnet.utils.pgdiff.schema.PgStatement;

public class CreateSequence extends ParserAbstract {
    private Create_sequence_statementContext ctx;
    public CreateSequence(Create_sequence_statementContext ctx, PgDatabase db, Path filePath) {
        super(db, filePath);
        this.ctx = ctx;
    }

    @Override
    public PgStatement getObject() {
        String name = getName(ctx.name);
        String schemaName =getSchemaName(ctx.name);
        if (schemaName==null) {
            schemaName = getDefSchemaName();
        }
        PgSequence sequence = new PgSequence(name, getFullCtxText(ctx.getParent()));
        long inc = 0;
        String maxValue = null;
        String minValue = null;
        for (Sequence_bodyContext body : ctx.sequence_body()) {
            if (body.cache_val != null) {
                sequence.setCache(body.cache_val.getText());
            }
            if (body.incr!=null) {
                sequence.setIncrement(body.incr.getText());
                inc = Long.parseLong(body.incr.getText());
            }
            if (body.maxval!=null) {
                maxValue = body.maxval.getText();
            }
            if (body.minval!=null) {
                minValue = body.minval.getText();
            }
            if (body.start_val!=null) {
                sequence.setStartWith(body.start_val.getText());
            }
            if (body.cycle_val!=null) {
                sequence.setCycle(body.cycle_true==null);
            }
            if (body.col_name!=null) {
                sequence.setOwnedBy(body.col_name.getText());
            }
        }
        sequence.setMaxValue(getMaxValue(inc, maxValue));
        sequence.setMinValue(getMinValue(inc, minValue));
        
        if (db.getSchema(schemaName) == null) {
            logSkipedObject(schemaName, "SEQUENCE", name);
            return null;
        }
        db.getSchema(schemaName).addSequence(sequence);
        return sequence;
    }

}
