package ru.taximaxim.codekeeper.core.parsers.antlr.expr.launcher;

import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;

import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.VexContext;
import ru.taximaxim.codekeeper.core.schema.PgConstraint;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation;
import ru.taximaxim.codekeeper.core.schema.meta.MetaContainer;

public class ConstraintAnalysisLauncher extends AbstractAnalysisLauncher {

    public ConstraintAnalysisLauncher(PgConstraint stmt, VexContext ctx, String location) {
        super(stmt, ctx, location);
    }

    @Override
    public Set<PgObjLocation> analyze(ParserRuleContext ctx, MetaContainer meta) {
        return analyzeTableChildVex((VexContext) ctx, meta);
    }
}
