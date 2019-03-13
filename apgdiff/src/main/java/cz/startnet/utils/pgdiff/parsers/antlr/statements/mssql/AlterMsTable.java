package cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql;

import java.util.Arrays;
import java.util.List;

import cz.startnet.utils.pgdiff.DangerStatement;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Alter_tableContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Column_def_table_constraintContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.IdContext;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.TableAbstract;
import cz.startnet.utils.pgdiff.schema.AbstractConstraint;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.AbstractTable;
import cz.startnet.utils.pgdiff.schema.MsConstraint;
import cz.startnet.utils.pgdiff.schema.MsTable;
import cz.startnet.utils.pgdiff.schema.MsTrigger;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import cz.startnet.utils.pgdiff.schema.StatementActions;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class AlterMsTable extends TableAbstract {

    private final Alter_tableContext ctx;

    public AlterMsTable(Alter_tableContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        IdContext schemaCtx = ctx.name.schema;
        IdContext nameCtx = ctx.name.name;
        List<IdContext> ids = Arrays.asList(schemaCtx, nameCtx);
        AbstractSchema schema = getSchemaSafe(ids);
        AbstractTable table = getSafe(AbstractSchema::getTable, schema, nameCtx);
        PgObjLocation ref = addObjReference(Arrays.asList(schemaCtx, nameCtx),
                DbObjType.TABLE, StatementActions.ALTER);

        Column_def_table_constraintContext colCtx = ctx.column_def_table_constraint();
        if (colCtx != null && colCtx.table_constraint() != null) {
            AbstractConstraint con = getMsConstraint(colCtx.table_constraint());
            con.setNotValid(ctx.nocheck_add != null);
            if (colCtx.table_constraint().id() != null) {
                addSafe(table, con, Arrays.asList(schemaCtx, nameCtx, colCtx.table_constraint().id()));
            } else {
                doSafe(AbstractTable::addConstraint, table, con);
            }
        } else if (ctx.con != null) {
            MsConstraint con = (MsConstraint) getSafe(AbstractTable::getConstraint, table, ctx.con);
            if (ctx.WITH() != null) {
                doSafe(AbstractConstraint::setNotValid, con, ctx.nocheck_check != null);
            }
            doSafe(MsConstraint::setDisabled, con, ctx.nocheck != null);
        } else if (ctx.DROP() != null && ctx.COLUMN() != null) {
            ref.setWarningText(DangerStatement.DROP_COLUMN);
        } else if (ctx.ALTER() != null && ctx.COLUMN() != null) {
            ref.setWarningText(DangerStatement.ALTER_COLUMN);
        }

        IdContext trigger = ctx.trigger;
        if (trigger != null) {
            MsTrigger tr = (MsTrigger) getSafe(AbstractTable::getTrigger, table, trigger);
            doSafe(MsTrigger::setDisable, tr, ctx.ENABLE() == null);
            addObjReference(Arrays.asList(schemaCtx, nameCtx, trigger),
                    DbObjType.TRIGGER, StatementActions.ALTER);
        } else if (ctx.CHANGE_TRACKING() != null && ctx.ENABLE() != null) {
            doSafe(MsTable::setTracked, ((MsTable) table), ctx.ON() != null);
        }
    }
}
