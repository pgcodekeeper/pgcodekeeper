package cz.startnet.utils.pgdiff.parsers.antlr.exprold;

import cz.startnet.utils.pgdiff.parsers.antlr.rulectx.Vex;

/**
 * For use with value expressions that have predefined namespace.
 * @author levsha_aa
 */
public class ValueExprWithNmspc extends AbstractExprWithNmspc<Vex> {

    private final ValueExpr vex;

    public ValueExprWithNmspc(String schema) {
        super(schema);
        vex = new ValueExpr(this);
    }

    @Override
    public void analyze(Vex vex) {
        this.vex.analyze(vex);
    }
}
