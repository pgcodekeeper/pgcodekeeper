package cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql;

import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Create_sequenceContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Data_typeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Data_type_sizeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.IdContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Sequence_bodyContext;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.AbstractSequence;
import cz.startnet.utils.pgdiff.schema.MsSequence;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;

public class CreateMsSequence extends ParserAbstract {

    private final Create_sequenceContext ctx;

    public CreateMsSequence(Create_sequenceContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public PgStatement getObject() {
        List<IdContext> ids = ctx.simple_name().id();
        AbstractSequence sequence = new MsSequence(QNameParser.getFirstName(ids), getFullCtxText(ctx.getParent()));
        fillSequence(sequence, ctx.sequence_body());
        getSchemaSafe(ids, db.getDefaultSchema()).addSequence(sequence);
        return sequence;
    }

    private void fillSequence(AbstractSequence sequence, List<Sequence_bodyContext> list) {
        long inc = 1;
        Long maxValue = null;
        Long minValue = null;
        String dataType = null;
        String precision = null;
        for (Sequence_bodyContext body : list) {
            if (body.data_type() != null) {
                Data_typeContext data = body.data_type();
                dataType = data.simple_name().getText().toLowerCase();
                sequence.setDataType(dataType);
                Data_type_sizeContext size = data.size;
                if (size != null && size.presicion != null) {
                    precision = size.presicion.getText();
                    sequence.setPresicion(precision);
                }
            } else if (body.start_val != null) {
                sequence.setStartWith(body.start_val.getText());
            } else if (body.CACHE() != null && body.NO() == null) {
                sequence.setCached(true);
                if (body.cache_val != null) {
                    sequence.setCache(body.cache_val.getText());
                }
            } else if (body.incr != null) {
                inc = Long.parseLong(body.incr.getText());
            } else if (body.maxval != null) {
                maxValue = Long.parseLong(body.maxval.getText());
            } else if (body.minval != null) {
                minValue = Long.parseLong(body.minval.getText());
            }  else if (body.cycle_val != null) {
                sequence.setCycle(body.cycle_true == null);
            }
        }

        sequence.setMinMaxInc(inc, maxValue, minValue, dataType, Long.parseLong(precision));
    }
}
