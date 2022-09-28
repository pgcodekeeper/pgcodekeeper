package ru.taximaxim.codekeeper.core.parsers.antlr.expr;

import java.util.Arrays;
import java.util.List;

import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.VexContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Vex_bContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.rulectx.Vex;
import ru.taximaxim.codekeeper.core.schema.meta.MetaContainer;
import ru.taximaxim.codekeeper.core.utils.ModPair;

/**
 * For use with value expressions that have predefined namespace.
 * @author levsha_aa
 */
public class ValueExprWithNmspc extends AbstractExprWithNmspc<VexContext> {

    private final ValueExpr vex;

    public ValueExprWithNmspc(MetaContainer meta) {
        super(meta);
        vex = new ValueExpr(this);
    }

    @Override
    public List<ModPair<String, String>> analyze(VexContext vex) {
        return analyze(new Vex(vex));
    }

    public List<ModPair<String, String>> analyze(Vex_bContext vex) {
        return analyze(new Vex(vex));
    }

    public List<ModPair<String, String>> analyze(Vex vex) {
        return Arrays.asList(this.vex.analyze(vex));
    }
}
