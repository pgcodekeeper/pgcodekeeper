package cz.startnet.utils.pgdiff.parsers.antlr.expr;

import java.util.Arrays;
import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.rulectx.Vex;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import ru.taximaxim.codekeeper.apgdiff.utils.Pair;

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
    public List<Pair<String, String>> analyze(Vex vex) {
        return Arrays.asList(this.vex.analyze(vex));
    }
}
