package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.nio.file.Path;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Set_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Set_statement_valueContext;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgSet;
import cz.startnet.utils.pgdiff.schema.PgStatement;

public class Set extends ParserAbstract {
    private Set_statementContext ctx;
    public Set(Set_statementContext ctx, PgDatabase db, Path filePath) {
        super(db, filePath);
        this.ctx = ctx;
    }

    @Override
    public PgStatement getObject() {
        PgSet set = null;
        if (ctx.config_param != null) {
            set = new PgSet(getFullCtxText(ctx));
            set.setParam(ctx.config_param.getText());
            for (Set_statement_valueContext value : ctx.config_param_val){
                set.addValue(value.getText());
            }
        }
        return set;
    }

}
