package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Comment_on_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.exception.UnresolvedReferenceException;
import cz.startnet.utils.pgdiff.schema.PgColumn;
import cz.startnet.utils.pgdiff.schema.PgConstraint;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgDomain;
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
        IdentifierContext nameCtx = QNameParser.getFirstNameCtx(ids);
        String name = nameCtx.getText();
        String comment = ctx.comment_text.getText();

        // column (separately because of schema qualification)
        // otherwise schema reference is considered unresolved
        if (ctx.COLUMN() != null) {
            IdentifierContext schemaCtx = QNameParser.getThirdNameCtx(ids);
            PgSchema schema = schemaCtx == null ? db.getDefaultSchema() : getSafe(db::getSchema, schemaCtx);
            IdentifierContext tableCtx = QNameParser.getSecondNameCtx(ids);
            String tableName = tableCtx.getText();
            PgTable table = schema.getTable(tableName);
            if (table == null) {
                PgView view = schema.getView(tableName);
                if (view == null) {
                    getSafe(schema::getType, tableCtx).getAttr(name).setComment(db.getArguments(), comment);
                } else {
                    view.addColumnComment(db.getArguments(), name, comment);
                }
            } else {
                PgColumn column;
                if (table.getInherits().isEmpty()) {
                    column = getSafe(table::getColumn, nameCtx);
                } else {
                    String colName = nameCtx.getText();
                    column = table.getColumn(colName);
                    if (column == null) {
                        column = new PgColumn(colName);
                        column.setInherit(true);
                        table.addColumn(column);
                    }
                }
                column.setComment(db.getArguments(), comment);
            }
            return null;
        }

        PgSchema schema;
        if (ctx.TRIGGER() != null || ctx.RULE() != null || ctx.CONSTRAINT() != null) {
            schema = getSchemaSafe(ctx.table_name.identifier(), db.getDefaultSchema());
        } else {
            schema = (ctx.EXTENSION() != null || ctx.SCHEMA() != null) ? null
                    : getSchemaSafe(ids, db.getDefaultSchema());
        }

        // function
        if (ctx.FUNCTION() != null) {
            getSafe(schema::getFunction, parseSignature(name, ctx.function_args()), nameCtx.getStart())
            .setComment(db.getArguments(), comment);
            //extension
        }  else if (ctx.EXTENSION() != null) {
            getSafe(db::getExtension, nameCtx).setComment(db.getArguments(), comment);
            //constraint
        } else if (ctx.CONSTRAINT() != null) {
            PgTable table = schema.getTable(QNameParser.getFirstName(ctx.table_name.identifier()));
            if (table == null) {
                PgDomain domain = getSafe(schema::getDomain, nameCtx);
                getSafe(domain::getConstraint, nameCtx).setComment(db.getArguments(), comment);
            } else {
                getSafe(table::getConstraint, nameCtx).setComment(db.getArguments(), comment);
            }
            // trigger
        } else if (ctx.TRIGGER() != null) {
            PgTriggerContainer c = getSafe(schema::getTriggerContainer,
                    QNameParser.getFirstNameCtx(ctx.table_name.identifier()));
            getSafe(c::getTrigger, nameCtx).setComment(db.getArguments(), comment);
            // database
        } else if (ctx.DATABASE() != null) {
            db.setComment(db.getArguments(), comment);
            // index
        } else if (ctx.INDEX() != null) {
            PgIndex index = null;
            for (PgTable table : schema.getTables()) {
                index = table.getIndex(name);
                if (index != null) {
                    index.setComment(db.getArguments(), comment);
                    break;
                }
            }

            if (index == null) {
                PgConstraint constr = null;
                for (PgTable table : schema.getTables()) {
                    constr = table.getConstraint(name);
                    if (constr != null) {
                        constr.setComment(db.getArguments(), comment);
                        break;
                    }
                }
                if (constr == null) {
                    throw new UnresolvedReferenceException(nameCtx.getStart());
                }
            }
            //schema
        } else if (ctx.SCHEMA() != null && !name.equals(ApgdiffConsts.PUBLIC)) {
            getSafe(db::getSchema, nameCtx).setComment(db.getArguments(), comment);
            // sequence
        } else if (ctx.SEQUENCE() != null) {
            getSafe(schema::getSequence, nameCtx).setComment(db.getArguments(), comment);
            // table
        } else if (ctx.TABLE() != null) {
            getSafe(schema::getTable, nameCtx).setComment(db.getArguments(), comment);
            // view
        } else if (ctx.VIEW() != null) {
            getSafe(schema::getView, nameCtx).setComment(db.getArguments(), comment);
            // type
        } else if (ctx.TYPE() != null) {
            getSafe(schema::getType, nameCtx).setComment(db.getArguments(), comment);
            // domain
        } else if (ctx.DOMAIN() != null) {
            getSafe(schema::getDomain, nameCtx).setComment(db.getArguments(), comment);
            // rule
        } else if (ctx.RULE() != null) {
            PgRuleContainer c = getSafe(schema::getRuleContainer,
                    QNameParser.getFirstNameCtx(ctx.table_name.identifier()));
            getSafe(c::getRule, nameCtx).setComment(db.getArguments(), comment);
        }
        return null;
    }
}
