package cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql;

import java.util.Arrays;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.DangerStatement;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Alter_tableContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Column_def_table_constraintContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Column_def_table_constraintsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.IdContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Qualified_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Schema_alterContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Table_action_dropContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Table_constraintContext;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.TableAbstract;
import cz.startnet.utils.pgdiff.schema.AbstractConstraint;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.AbstractTable;
import cz.startnet.utils.pgdiff.schema.MsConstraint;
import cz.startnet.utils.pgdiff.schema.MsTable;
import cz.startnet.utils.pgdiff.schema.MsTrigger;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgObjLocation;
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
                    AbstractConstraint con = getMsConstraint(constrCtx);
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
        Qualified_nameContext qualNameCtx = ctx.name;
        return getStrForStmtAction(ACTION_ALTER, DbObjType.TABLE,
                Arrays.asList(qualNameCtx.schema, qualNameCtx.name));
    }
}
