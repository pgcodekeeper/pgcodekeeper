package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Comment_on_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.schema.PgConstraint;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgDomain;
import cz.startnet.utils.pgdiff.schema.PgFunction;
import cz.startnet.utils.pgdiff.schema.PgIndex;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgTable;
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
        String name = QNameParser.getFirstName(ids);
        String schemaName = QNameParser.getSchemaName(ids, getDefSchemaName());
        String comment = ctx.comment_text.getText();
        PgSchema schema = db.getSchema(schemaName);

        // function
        if (ctx.FUNCTION() != null) {
            PgFunction func = new PgFunction(name, null);
            fillArguments(ctx.function_args(), func, getDefSchemaName());
            name = func.getSignature();
            schema.getFunction(name).setComment(db.getArguments(), comment);
            //column
        } else if (ctx.COLUMN() != null){
            String tableName = QNameParser.getSecondName(ids);
            if (schemaName.equals(tableName)) {
                schema = db.getSchema(getDefSchemaName());
            }
            PgTable table = schema.getTable(tableName);
            if (table == null) {
                PgView view = schema.getView(tableName);
                if (view == null) {
                    schema.getType(tableName).getAttr(name).setComment(db.getArguments(), comment);
                } else {
                    view.addColumnComment(db.getArguments(), name, comment);
                }
            } else {
                table.getColumn(name).setComment(db.getArguments(), comment);
            }
            //extension
        }else if (ctx.EXTENSION() != null) {
            db.getExtension(name).setComment(db.getArguments(), comment);
            //constraint
        } else if (ctx.CONSTRAINT() != null) {
            String tableName = QNameParser.getFirstName(ctx.table_name.identifier());
            PgTable table = schema.getTable(tableName);
            if (table == null) {
                PgDomain dom = schema.getDomain(tableName);
                PgConstraint c = dom.getConstraint(name);
                if (c == null) {
                    c = dom.getConstraintNotValid(name);
                }
                c.setComment(db.getArguments(), comment);
            } else {
                table.getConstraint(name).setComment(db.getArguments(), comment);
            }
            // trigger
        } else if (ctx.TRIGGER() != null) {
            String tableName = QNameParser.getFirstName(ctx.table_name.identifier());
            schema.getTable(tableName).getTrigger(name).setComment(db.getArguments(), comment);
            // database
        } else if (ctx.DATABASE() !=null) {
            db.setComment(db.getArguments(), comment);
            // index
        } else if (ctx.INDEX() != null) {
            PgIndex index = null;
            for (PgTable table : schema.getTables()) {
                index = table.getIndex(name);
                if (index != null) {
                    break;
                }
            }

            if (index == null) {
                PgConstraint constr= null;
                for (PgTable table : schema.getTables()) {
                    constr = table.getConstraint(name);
                    if (constr != null) {
                        break;
                    }
                }
                if (constr != null) {
                    constr.setComment(db.getArguments(), comment);
                }
            } else {
                index.setComment(db.getArguments(), comment);
            }
            //schema
        } else if (ctx.SCHEMA() != null && !name.equals(ApgdiffConsts.PUBLIC)) {
            db.getSchema(name).setComment(db.getArguments(), comment);
            // sequence
        } else if (ctx.SEQUENCE() != null) {
            schema.getSequence(name).setComment(db.getArguments(), comment);
            // table
        } else if (ctx.TABLE() != null) {
            schema.getTable(name).setComment(db.getArguments(), comment);
            // view
        } else if (ctx.VIEW() != null) {
            schema.getView(name).setComment(db.getArguments(), comment);
            // type
        } else if (ctx.TYPE() != null) {
            schema.getType(name).setComment(db.getArguments(), comment);
            // domain
        } else if (ctx.DOMAIN() != null) {
            schema.getDomain(name).setComment(db.getArguments(), comment);
            // rule
        } else if (ctx.RULE() != null) {
            String tableName = QNameParser.getFirstName(ctx.table_name.identifier());
            PgTable table = schema.getTable(tableName);
            if (table != null) {
                table.getRule(name).setComment(db.getArguments(), comment);
            } else {
                schema.getView(tableName).getRule(name).setComment(db.getArguments(), comment);
            }
        }
        return null;
    }
}
