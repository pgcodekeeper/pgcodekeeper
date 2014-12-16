package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.nio.file.Path;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DbObjType;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Comment_on_statementContext;
import cz.startnet.utils.pgdiff.schema.PgComment;
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
        PgComment comment = new PgComment(getFullCtxText(ctx));
        comment.setObjName(getName(ctx.name));
        comment.setComment(ctx.comment_text.getText());
        String schemaName = getSchemaName(ctx.name);
        if (schemaName == null) {
            schemaName = getDefSchemaName();
        }
        // function
        if (ctx.function_args() != null) {
            PgFunction func = new PgFunction(getName(ctx.name),null, null);
            fillArguments(ctx.function_args(), func);
            comment.setObjName(func.getSignature());
            db.getSchema(schemaName).getFunction(comment.getObjName()).setComment(comment.getComment());
            return comment;
            //column
        } else if (ctx.COLUMN() != null){
            comment.setType(DbObjType.COLUMN);
            comment.setTableName(getTableName(ctx.name));
            if (schemaName.equals(comment.getTableName())) {
                schemaName= getDefSchemaName();
            }
            PgTable table = db.getSchema(schemaName).getTable(comment.getTableName());
            if (table == null) {
                db.getSchema(schemaName).getView(comment.getTableName()).addColumnComment(comment.getObjName(), comment.getComment());
            } else {
                db.getSchema(schemaName).getTable(comment.getTableName()).getColumn(comment.getObjName()).setComment(comment.getComment());
            }
            return comment;
            //extension
        }else if (ctx.EXTENSION() != null) {
            comment.setType(DbObjType.EXTENSION);
            db.getExtension(comment.getObjName()).setComment(comment.getComment());
            return comment;
            //constraint
        } else if (ctx.CONSTRAINT() != null) {
            comment.setTableName(getName(ctx.table_name));
            db.getSchema(schemaName).getTable(comment.getTableName()).getConstraint(comment.getObjName()).setComment(comment.getComment());
            return comment;
            // trigger
        } else if (ctx.TRIGGER() != null) {
            comment.setTableName(getName(ctx.table_name));
            db.getSchema(schemaName).getTable(comment.getTableName()).getTrigger(comment.getObjName()).setComment(comment.getComment());
            return comment;
            // database
        } else if (ctx.DATABASE() !=null) {
            db.setComment(comment.getComment());
            return comment;
            // index
        } else if (ctx.INDEX() != null) {
            if (schemaName.equals(comment.getTableName())) {
                schemaName= getDefSchemaName();
            }
            PgIndex index = null;
            for (PgTable table : db.getSchema(schemaName).getTables()) {
                index = table.getIndex(comment.getObjName());
                if (index != null) {
                    break;
                }
            }
            
            if (index == null) {
                PgConstraint constr= null;
                for (PgTable table : db.getSchema(schemaName).getTables()) {
                    constr = table.getConstraint(comment.getObjName());
                    if (constr != null) {
                        break;
                    }
                }
                if (constr != null) {
                    constr.setComment(comment.getComment());
                }
            } else {
                index.setComment(comment.getComment());
            }
            return comment;
            //schema
        } else if (ctx.SCHEMA() !=null) {
            db.getSchema(comment.getObjName()).setComment(comment.getComment());
            return comment;
            // sequence
        } else if (ctx.SEQUENCE() != null) {
            db.getSchema(schemaName).getSequence(comment.getObjName()).setComment(comment.getComment());
            return comment;
            // table
        } else if (ctx.TABLE() != null) {
            db.getSchema(schemaName).getTable(comment.getObjName()).setComment(comment.getComment());
            return comment;
            // view
        } else if (ctx.VIEW() != null) {
            db.getSchema(schemaName).getView(comment.getObjName()).setComment(comment.getComment());
            return comment;
        } 
        
        fillObjLocation(comment, ctx.comment_text.getStartIndex(), schemaName, false);
        return comment;
    }
}
