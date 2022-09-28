package ru.taximaxim.codekeeper.core.parsers.antlr.statements.mssql;

import java.util.Arrays;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import ru.taximaxim.codekeeper.core.DangerStatement;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.Alter_tableContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.Column_def_table_constraintContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.Column_def_table_constraintsContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.IdContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.Schema_alterContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.Table_action_dropContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.Table_constraintContext;
import ru.taximaxim.codekeeper.core.schema.AbstractConstraint;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.AbstractTable;
import ru.taximaxim.codekeeper.core.schema.MsConstraint;
import ru.taximaxim.codekeeper.core.schema.MsTable;
import ru.taximaxim.codekeeper.core.schema.MsTrigger;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation;

public class AlterMsTable extends MsTableAbstract {

    private final Alter_tableContext ctx;

    public AlterMsTable(Alter_tableContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        IdContext schemaCtx = ctx.name.schema;
        IdContext nameCtx = ctx.name.name;
        List<ParserRuleContext> ids = Arrays.asList(schemaCtx, nameCtx);
        AbstractSchema schema = getSchemaSafe(ids);
        AbstractTable table = getSafe(AbstractSchema::getTable, schema, nameCtx);
        PgObjLocation ref = addObjReference(Arrays.asList(schemaCtx, nameCtx),
                DbObjType.TABLE, ACTION_ALTER);

        Column_def_table_constraintsContext constrs = ctx.column_def_table_constraints();
        if (constrs != null ) {
            for (Column_def_table_constraintContext colCtx : constrs.column_def_table_constraint()) {
                Table_constraintContext constrCtx;
                if (colCtx != null && (constrCtx = colCtx.table_constraint()) != null) {
                    AbstractConstraint con = getMsConstraint(constrCtx, schemaCtx.getText(), nameCtx.getText());
                    con.setNotValid(ctx.nocheck_add != null);
                    IdContext id = constrCtx.id();
                    if (id != null) {
                        addSafe(table, con, Arrays.asList(schemaCtx, nameCtx, id));
                    } else {
                        doSafe(AbstractTable::addConstraint, table, con);
                    }
                }
            }
        } else if (ctx.CONSTRAINT() != null) {
            for (IdContext id : ctx.id()) {
                MsConstraint con = (MsConstraint) getSafe(AbstractTable::getConstraint, table, id);
                if (ctx.WITH() != null) {
                    doSafe(AbstractConstraint::setNotValid, con, ctx.nocheck_check != null);
                }
                doSafe(MsConstraint::setDisabled, con, ctx.nocheck != null);
            }
        } else if (ctx.DROP() != null) {
            for (Table_action_dropContext drop : ctx.table_action_drop()) {
                if (drop.COLUMN() != null) {
                    ref.setWarning(DangerStatement.DROP_COLUMN);
                    break;
                }
            }
        } else if (ctx.ALTER() != null && ctx.COLUMN() != null) {
            ref.setWarning(DangerStatement.ALTER_COLUMN);
        } else if (ctx.TRIGGER() != null) {
            for (IdContext trigger : ctx.id()) {
                MsTrigger tr = (MsTrigger) getSafe(AbstractTable::getTrigger, table, trigger);
                doSafe(MsTrigger::setDisable, tr, ctx.ENABLE() == null);
                addObjReference(Arrays.asList(schemaCtx, nameCtx, trigger),
                        DbObjType.TRIGGER, ACTION_ALTER);
            }
        } else if (ctx.CHANGE_TRACKING() != null && ctx.ENABLE() != null) {
            doSafe(MsTable::setTracked, ((MsTable) table), ctx.ON() != null);
        }
    }

    @Override
    protected PgObjLocation fillQueryLocation(ParserRuleContext ctx) {
        PgObjLocation loc = super.fillQueryLocation(ctx);
        Alter_tableContext alterTblCtx  = ((Schema_alterContext) ctx).alter_table();
        if (alterTblCtx.DROP() != null && alterTblCtx.COLUMN() != null) {
            loc.setWarning(DangerStatement.DROP_COLUMN);
        } else if (alterTblCtx.ALTER() != null && alterTblCtx.COLUMN() != null) {
            loc.setWarning(DangerStatement.ALTER_COLUMN);
        }
        return loc;
    }

    @Override
    protected String getStmtAction() {
        return getStrForStmtAction(ACTION_ALTER, DbObjType.TABLE, ctx.name);
    }
}
