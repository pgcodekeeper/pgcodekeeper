package cz.startnet.utils.pgdiff.parsers.antlr.expr;

import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_nameContext;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class UtilExpr {

    public static void create(ParserRuleContext ctx, AbstractExprWithNmspc analizer, PgStatement pg) {
        analizer.analize(ctx);
        for (GenericColumn col : analizer.getDepcies()) {
            pg.addDep(col);
        }
    }

    public static void addAliasRef(Schema_qualified_nameContext table, AbstractExprWithNmspc expr,
            IdentifierContext alias) {
        List<IdentifierContext> tableIds = table.identifier();
        String tableName = QNameParser.getFirstName(tableIds);
        boolean isCte = tableIds.size() == 1 && expr.hasCte(tableName);
        GenericColumn depcy = null;
        if (!isCte) {
            depcy = expr.addObjectDepcy(tableIds, DbObjType.TABLE);
        }
        if (alias != null) {
            String aliasName = alias.getText();
            expr.addReference(aliasName, depcy);
        } else if (isCte) {
            expr.addReference(tableName, null);
        } else {
            expr.addRawTableReference(depcy);
        }
    }
}
