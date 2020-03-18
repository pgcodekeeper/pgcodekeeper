package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.DangerStatement;
import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Alter_sequence_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_alterContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Sequence_bodyContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Tokens_nonreserved_except_function_typeContext;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import cz.startnet.utils.pgdiff.schema.PgSequence;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class AlterSequence extends ParserAbstract {
    private final Alter_sequence_statementContext ctx;
    public AlterSequence(Alter_sequence_statementContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        List<IdentifierContext> ids = ctx.name.identifier();
        PgSequence sequence = (PgSequence) getSafe(AbstractSchema::getSequence,
                getSchemaSafe(ids), QNameParser.getFirstNameCtx(ids));

        PgObjLocation loc = addObjReference(ids, DbObjType.SEQUENCE, ACTION_ALTER);

        for (Sequence_bodyContext seqbody : ctx.sequence_body()) {
            if (seqbody.OWNED() != null && seqbody.col_name != null) {
                List<IdentifierContext> col = seqbody.col_name.identifier();
                Tokens_nonreserved_except_function_typeContext word;
                if (col.size() != 1 || (word = col.get(0).tokens_nonreserved_except_function_type()) == null
                        || word.NONE() == null) {
                    GenericColumn gc = new GenericColumn(QNameParser.getThirdName(col),
                            QNameParser.getSecondName(col), QNameParser.getFirstName(col), DbObjType.COLUMN);
                    doSafe(PgSequence::setOwnedBy, sequence, gc);
                }

                addObjReference(col, DbObjType.TABLE, null);
            }
        }

        if (!ctx.RESTART().isEmpty()) {
            loc.setWarning(DangerStatement.RESTART_WITH);
        }
    }

    @Override
    protected PgObjLocation fillQueryLocation(ParserRuleContext ctx) {
        PgObjLocation loc = super.fillQueryLocation(ctx);
        if (!((Schema_alterContext) ctx).alter_sequence_statement().RESTART().isEmpty()) {
            loc.setWarning(DangerStatement.RESTART_WITH);
        }
        return loc;
    }

    @Override
    protected String getStmtAction() {
        return getStrForStmtAction(ACTION_CREATE, DbObjType.SEQUENCE, ctx.name.identifier());
    }
}