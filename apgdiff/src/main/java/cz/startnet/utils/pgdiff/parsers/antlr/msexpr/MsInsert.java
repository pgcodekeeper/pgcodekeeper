package cz.startnet.utils.pgdiff.parsers.antlr.msexpr;

import java.util.Collections;
import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Column_name_listContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Execute_moduleContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Execute_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.ExpressionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.IdContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Insert_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Qualified_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Select_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.With_expressionContext;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class MsInsert extends MsAbstractExprWithNmspc<Insert_statementContext> {

    protected MsInsert(MsAbstractExpr parent) {
        super(parent);
    }

    @Override
    public List<String> analyze(Insert_statementContext insert) {
        With_expressionContext with = insert.with_expression();
        if (with != null) {
            analyzeCte(with);
        }

        ExpressionContext exp = insert.expression();
        if (exp != null) {
            new MsValueExpr(this).analyze(exp);
        }

        Select_statementContext ss = insert.select_statement();
        Execute_statementContext es;

        if (ss != null) {
            new MsSelect(this).analyze(ss);
        } else if ((es = insert.execute_statement()) != null) {
            Execute_moduleContext em = es.execute_module();
            Qualified_nameContext qname;
            if (em != null && (qname = em.qualified_name()) != null) {
                addObjectDepcy(qname, DbObjType.FUNCTION);
            }
        }

        Qualified_nameContext tableName = insert.qualified_name();
        if (tableName != null) {
            GenericColumn gc = addNameReference(tableName, null);
            Column_name_listContext columns;

            if (gc != null && (columns = insert.column_name_list()) != null) {
                for (IdContext id : columns.id()) {
                    addDepcy(new GenericColumn(gc.schema, gc.table, id.getText(),
                            DbObjType.COLUMN));
                }
            }
        }

        return Collections.emptyList();
    }

}
