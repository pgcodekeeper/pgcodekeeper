package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.nio.file.Path;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Comment_on_statementContext;
import cz.startnet.utils.pgdiff.schema.PgConstraint;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgFunction;
import cz.startnet.utils.pgdiff.schema.PgIndex;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgTable;

public class CommentOn extends ParserAbstract {
    private Comment_on_statementContext ctx;
    public CommentOn(Comment_on_statementContext ctx, PgDatabase db, Path filePath) {
        super(db, filePath);
        this.ctx = ctx;
    }

    @Override
    public PgStatement getObject() {
        String name = getName(ctx.name);
        String comment = ctx.comment_text.getText();
        String schemaName = getSchemaName(ctx.name);
        if (schemaName == null) {
            schemaName = getDefSchemaName();
        }
        // function
        if (ctx.function_args() != null) {
            PgFunction func = new PgFunction(getName(ctx.name),null, db.getDefSearchPath());
            fillArguments(ctx.function_args(), func);
            name = func.getSignature();
            db.getSchema(schemaName).getFunction(name).setComment(comment);
            addObjReference(schemaName, func, ctx.name.getStart().getStartIndex());
            //column
        } else if (ctx.COLUMN() != null){
            String tableName = getTableName(ctx.name);
            if (schemaName.equals(tableName)) {
                schemaName= getDefSchemaName();
            }
            PgTable table = db.getSchema(schemaName).getTable(tableName);
            if (table == null) {
                db.getSchema(schemaName).getView(tableName).addColumnComment(name, comment);
                addObjReference(schemaName, db.getSchema(schemaName).getView(tableName), ctx.name.getStart().getStartIndex());
            } else {
                db.getSchema(schemaName).getTable(tableName).getColumn(name).setComment(comment);
                addObjReference(schemaName, db.getSchema(schemaName).getTable(tableName), ctx.name.getStart().getStartIndex());
            }
            //extension
        }else if (ctx.EXTENSION() != null) {
            db.getExtension(name).setComment(comment);
            addObjReference(null, db.getExtension(name), ctx.name.getStart().getStartIndex());
            //constraint
        } else if (ctx.CONSTRAINT() != null) {
            String tableName = getName(ctx.table_name);
            db.getSchema(schemaName).getTable(tableName).getConstraint(name).setComment(comment);
            // trigger
        } else if (ctx.TRIGGER() != null) {
            String tableName = getName(ctx.table_name);
            db.getSchema(schemaName).getTable(tableName).getTrigger(name).setComment(comment);
            addObjReference(null, db.getSchema(schemaName).getTable(tableName).getTrigger(name), ctx.name.getStart().getStartIndex());
            // database
        } else if (ctx.DATABASE() !=null) {
            db.setComment(comment);
            // index
        } else if (ctx.INDEX() != null) {
            String tableName = getName(ctx.table_name);
            if (schemaName.equals(tableName)) {
                schemaName= getDefSchemaName();
            }
            PgIndex index = null;
            for (PgTable table : db.getSchema(schemaName).getTables()) {
                index = table.getIndex(name);
                if (index != null) {
                    break;
                }
            }
            
            if (index == null) {
                PgConstraint constr= null;
                for (PgTable table : db.getSchema(schemaName).getTables()) {
                    constr = table.getConstraint(name);
                    if (constr != null) {
                        break;
                    }
                }
                if (constr != null) {
                    constr.setComment(comment);
                }
            } else {
                index.setComment(comment);
                addObjReference(null, index, ctx.name.getStart().getStartIndex());
            }
            //schema
        } else if (ctx.SCHEMA() !=null) {
            db.getSchema(name).setComment(comment);
            addObjReference(null, db.getSchema(name), ctx.name.getStart().getStartIndex());
            // sequence
        } else if (ctx.SEQUENCE() != null) {
            db.getSchema(schemaName).getSequence(name).setComment(comment);
            addObjReference(null, db.getSchema(schemaName).getSequence(name), ctx.name.getStart().getStartIndex());
            // table
        } else if (ctx.TABLE() != null) {
            db.getSchema(schemaName).getTable(name).setComment(comment);
            addObjReference(null, db.getSchema(schemaName).getTable(name), ctx.name.getStart().getStartIndex());
            // view
        } else if (ctx.VIEW() != null) {
            db.getSchema(schemaName).getView(name).setComment(comment);
            addObjReference(null, db.getSchema(schemaName).getView(name), ctx.name.getStart().getStartIndex());
        }
        return null;
    }
}
