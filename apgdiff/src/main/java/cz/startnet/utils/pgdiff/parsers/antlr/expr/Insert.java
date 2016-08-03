package cz.startnet.utils.pgdiff.parsers.antlr.expr;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Insert_stmt_for_psqlContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.With_clauseContext;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class Insert extends AbstractExpr {


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

    private boolean hasCte(String cteName) {
        return findCte(cteName) != null;
    }

    @Override
    protected List<String> analize(ParserRuleContext ruleCtx) {
        Insert_stmt_for_psqlContext insert = (Insert_stmt_for_psqlContext) ruleCtx;
        With_clauseContext with = insert.with_clause();
        if (with != null) {
            withPerform(with, cte);
        }

        Schema_qualified_nameContext table = insert.insert_table_name;
        if (table != null) {
            List<IdentifierContext> tableIds = table.identifier();
            String tableName = QNameParser.getFirstName(tableIds);
            String schemaName = QNameParser.getSchemaName(tableIds, getDefaultSchemaName());

            boolean isCte = tableIds.size() == 1 && hasCte(tableName);
            GenericColumn depcy = null;

            if (isCte) {
                addReference(tableName, null);
            } else {
                depcy = addObjectDepcy(tableIds, DbObjType.TABLE);
                addRawTableReference(depcy);

            }

            if (insert.LEFT_PAREN() != null && insert.RIGHT_PAREN() != null) {
                addColumnDepcy(schemaName, tableName, insert.column);
            }
            if (insert.select_stmt() != null) {
                //UtilExpr.create(insert.select_stmt(), new Select(this), pg);
                //new Select(this).analize(new SelectStmt(insert.select_stmt()));
                new Select(this).analize(insert.select_stmt());
            }
        }
        return null;
    }

    public List<String> insert(Insert_stmt_for_psqlContext insert) {
        With_clauseContext with = insert.with_clause();
        if (with != null) {
            withPerform(with, cte);
        }

        Schema_qualified_nameContext table = insert.insert_table_name;
        if (table != null) {
            List<IdentifierContext> tableIds = table.identifier();
            String tableName = QNameParser.getFirstName(tableIds);
            String schemaName = QNameParser.getSchemaName(tableIds, getDefaultSchemaName());

            boolean isCte = tableIds.size() == 1 && hasCte(tableName);
            GenericColumn depcy = null;

            if (isCte) {
                addReference(tableName, null);
            } else {
                depcy = addObjectDepcy(tableIds, DbObjType.TABLE);
                addRawTableReference(depcy);

            }

            if (insert.LEFT_PAREN() != null && insert.RIGHT_PAREN() != null) {
                addColumnDepcy(schemaName, tableName, insert.column);
            }
            if (insert.select_stmt() != null) {
                new Select(this).analize(insert.select_stmt());
            }
        }
        return null;
    }

}
