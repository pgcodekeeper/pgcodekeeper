package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.nio.file.Path;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DbObjType;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Comment_on_statementContext;
import cz.startnet.utils.pgdiff.schema.PgComment;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgFunction;
import cz.startnet.utils.pgdiff.schema.PgStatement;

public class CommentOn extends ParserAbstract {
    private Comment_on_statementContext ctx;
    public CommentOn(Comment_on_statementContext ctx, PgDatabase db, Path filePath) {
        super(db, filePath);
        this.ctx = ctx;
    }

    @Override
    public PgStatement getObject() {
        PgComment comment = new PgComment(getFullCtxText(ctx));
        if (ctx.function_args() != null) {
            PgFunction func = new PgFunction(getName(ctx.name),null, null);
            fillArguments(ctx.function_args(), func);
            comment.setObjName(func.getSignature());
        } else if (ctx.name != null) {
            comment.setObjName(getName(ctx.name));
        }
        if (ctx.EXTENSION() != null) {
            comment.setType(DbObjType.EXTENSION);
        } else {
            // для того чтобы выделить расширения в отдельную группу, т.к. их имена могут совпадать с именами схемы
            comment.setType(DbObjType.SCHEMA);
        }
        comment.setComment(ctx.comment_text.getText());
        fillObjLocation(comment, ctx.comment_text.getStartIndex(), getDefSchemaName());
        return comment;
    }

}
