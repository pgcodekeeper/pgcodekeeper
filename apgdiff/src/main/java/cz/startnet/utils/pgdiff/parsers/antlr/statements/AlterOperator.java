package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Alter_operator_actionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Alter_operator_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Operator_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Target_operatorContext;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgOperator;
import cz.startnet.utils.pgdiff.schema.PgStatement;

public class AlterOperator extends ParserAbstract {

    private final Alter_operator_statementContext ctx;
    public AlterOperator(Alter_operator_statementContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public PgStatement getObject() {
        Target_operatorContext targetOperCtx = ctx.target_operator();
        Operator_nameContext operNameCtx = targetOperCtx.name;
        PgOperator oper = getSafe(
                CreateOperator.getSchemaSafe(operNameCtx, db.getDefaultSchema(), db)::getOperator,
                parseSignature(operNameCtx.operator.getText(), targetOperCtx),
                operNameCtx.getStart());

        // filling of owner
        if (!db.getArguments().isIgnorePrivileges()) {
            Alter_operator_actionContext alterActionCtx = ctx.alter_operator_action();
            if (alterActionCtx.OWNER() != null) {
                oper.setOwner(alterActionCtx.user_identifer_current_session().getText());
            }
        }

        return null;
    }
}