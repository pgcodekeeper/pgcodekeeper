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
        PgSequence sequnce = new PgSequence(name, getFullCtxText(ctx.getParent()), "");
        for (Sequence_bodyContext body : ctx.sequence_body()) {
            if (body.cache_val != null) {
                sequnce.setCache(body.cache_val.getText());
            }
            if (body.incr!=null) {
                sequnce.setIncrement(body.incr.getText());
            }
            if (body.maxval!=null) {
                sequnce.setMaxValue(body.maxval.getText());
            }
            if (body.minval!=null) {
                sequnce.setMinValue(body.minval.getText());
            }
            if (body.start_val!=null) {
                sequnce.setStartWith(body.start_val.getText());
            }
            if (body.cycle_val!=null) {
                sequnce.setCycle(body.cycle_true==null);
            }
            if (body.col_name!=null) {
                sequnce.setOwnedBy(body.col_name.getText());
            }
        }
        fillObjLocation(sequnce, ctx.name.getStart().getStartIndex(), schemaName);
        return sequnce;
    }

}
