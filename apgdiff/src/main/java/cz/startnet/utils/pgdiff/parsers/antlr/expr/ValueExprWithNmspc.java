package cz.startnet.utils.pgdiff.parsers.antlr.expr;

import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;

import cz.startnet.utils.pgdiff.parsers.antlr.rulectx.Vex;
import cz.startnet.utils.pgdiff.schema.PgDatabase;

/**
 * For use with value expressions that have predefined namespace.
 * @author levsha_aa
 */
public class ValueExprWithNmspc extends AbstractExprWithNmspc<Vex> {

    private final ValueExpr vex;

    public ValueExprWithNmspc(String schema, PgDatabase db) {
        super(schema, db);
        vex = new ValueExpr(this);
    }

    @Override
    public List<Entry<String, String>> analyze(Vex vex) {
        this.vex.analyze(vex);
        return Collections.emptyList();
    }
}
