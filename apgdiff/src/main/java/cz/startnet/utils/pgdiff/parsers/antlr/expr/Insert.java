package cz.startnet.utils.pgdiff.parsers.antlr.expr;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Insert_stmt_for_psqlContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Select_stmtContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.With_clauseContext;

public class Insert extends AbstractExprWithNmspc {


    /**
     * CTE names that current level of FROM has access to.
     */
    private final Set<String> cte = new HashSet<>();

    protected Insert(AbstractExpr parent) {
        super(parent);
    }

    public Insert(String schema) {
        super(schema);
    }

    @Override
    protected AbstractExpr findCte(String cteName) {
        return cte.contains(cteName) ? this : super.findCte(cteName);
    }

    @Override
    protected List<String> analize(ParserRuleContext ruleCtx) {
        Insert_stmt_for_psqlContext insert = (Insert_stmt_for_psqlContext) ruleCtx;
        With_clauseContext with = insert.with_clause();
        if (with != null) {
            withPerform(with, cte);
        }
		if (insert.insert_table_name != null) {
			UtilExpr.addAliasRef(insert.insert_table_name, this, null);
            if (insert.LEFT_PAREN() != null && insert.RIGHT_PAREN() != null) {
				List<IdentifierContext> tableIds = insert.insert_table_name.identifier();
				String schemaName = QNameParser.getSchemaName(tableIds, getDefaultSchemaName());
				String tableName = QNameParser.getFirstName(tableIds);
                addColumnDepcy(schemaName, tableName, insert.column);
            }
			Select_stmtContext select_ctx;
			if ((select_ctx = insert.select_stmt()) != null) {
				new Select(this).analize(select_ctx);
            }
        }
        return null;
    }

}
