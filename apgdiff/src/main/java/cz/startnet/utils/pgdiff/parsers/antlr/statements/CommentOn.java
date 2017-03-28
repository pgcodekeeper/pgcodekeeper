package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Comment_on_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.schema.PgConstraint;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgDomain;
import cz.startnet.utils.pgdiff.schema.PgFunction;
import cz.startnet.utils.pgdiff.schema.PgIndex;
import cz.startnet.utils.pgdiff.schema.PgRuleContainer;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgTable;
import cz.startnet.utils.pgdiff.schema.PgTriggerContainer;
import cz.startnet.utils.pgdiff.schema.PgView;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;

public class CommentOn extends ParserAbstract {
    private final Comment_on_statementContext ctx;
    public CommentOn(Comment_on_statementContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public PgStatement getObject() {
        if (ctx.comment_text == null) {
            // maybe NULL if drop comment
            return null;
        }
        List<IdentifierContext> ids = ctx.name.identifier();
        ParserRuleContext name = QNameParser.getFirstNameCtx(ids);
        String schemaName = QNameParser.getSchemaName(ids, getDefSchemaName());
        String comment = ctx.comment_text.getText();
        PgSchema schema = db.getSchema(schemaName);

        // function
        if (ctx.FUNCTION() != null) {
            PgFunction func = new PgFunction(name.getText(), null);
            fillArguments(ctx.function_args(), func, getDefSchemaName());
            getFunctionSafe(schema::getFunction, func.getSignature(), ctx.function_args()).setComment(db.getArguments(), comment);
            //column
        } else if (ctx.COLUMN() != null){
            ParserRuleContext tableName = QNameParser.getSecondNameCtx(ids);
            if (schemaName.equals(tableName.getText())) {
                schema = db.getDefaultSchema();
            }
            PgTable table = schema.getTable(tableName.getText());
            if (table == null) {
                PgView view = schema.getView(tableName.getText());
                if (view == null) {
                    getSafe(schema::getType, tableName)
                    .getAttr(name.getText()).setComment(db.getArguments(), comment);
                } else {
                    view.addColumnComment(db.getArguments(), name.getText(), comment);
                }
            } else {
                getSafe(table::getColumn, name).setComment(db.getArguments(), comment);
            }
            //extension
        } else if (ctx.EXTENSION() != null) {
            getSafe(db::getExtension, ctx.name).setComment(db.getArguments(), comment);
            //constraint
        } else if (ctx.CONSTRAINT() != null) {
            PgTable table = schema.getTable(QNameParser.getFirstName(ctx.table_name.identifier()));
            if (table == null) {
                PgDomain domain = getSafe(schema::getDomain, name);
                getSafe(domain::getConstraint, name).setComment(db.getArguments(), comment);
            } else {
                getSafe(table::getConstraint, name).setComment(db.getArguments(), comment);
            }
            // trigger
        } else if (ctx.TRIGGER() != null) {
            PgTriggerContainer c = getSafe(schema::getTriggerContainer, ctx.table_name);
            getSafe(c::getTrigger, name).setComment(db.getArguments(), comment);
            // database
        } else if (ctx.DATABASE() !=null) {
            db.setComment(db.getArguments(), comment);
            // index
        } else if (ctx.INDEX() != null) {
            PgIndex index = null;
            for (PgTable table : schema.getTables()) {
                index = table.getIndex(name.getText());
                if (index != null) {
                    index.setComment(db.getArguments(), comment);
                    break;
                }
            }

            if (index == null) {
                PgConstraint constr = null;
                for (PgTable table : schema.getTables()) {
                    constr = table.getConstraint(name.getText());
                    if (constr != null) {
                        constr.setComment(db.getArguments(), comment);
                        break;
                    }
                }
            }
            //schema
        } else if (ctx.SCHEMA() != null && !name.getText().equals(ApgdiffConsts.PUBLIC)) {
            getSafe(db::getSchema, name).setComment(db.getArguments(), comment);
            // sequence
        } else if (ctx.SEQUENCE() != null) {
            getSafe(schema::getSequence, name).setComment(db.getArguments(), comment);
            // table
        } else if (ctx.TABLE() != null) {
            getSafe(schema::getTable, name).setComment(db.getArguments(), comment);
            // view
        } else if (ctx.VIEW() != null) {
            getSafe(schema::getView, name).setComment(db.getArguments(), comment);
            // type
        } else if (ctx.TYPE() != null) {
            getSafe(schema::getType, name).setComment(db.getArguments(), comment);
            // domain
        } else if (ctx.DOMAIN() != null) {
            getSafe(schema::getDomain, name).setComment(db.getArguments(), comment);
            // rule
        } else if (ctx.RULE() != null) {
            PgRuleContainer c = getSafe(schema::getRuleContainer, ctx.table_name);
            getSafe(c::getRule, name).setComment(db.getArguments(), comment);
        }
        return null;
    }
}
