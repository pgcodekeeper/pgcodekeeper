package cz.startnet.utils.pgdiff.parsers.antlr.expr.launcher;

import java.util.Collections;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.IFunction;
import cz.startnet.utils.pgdiff.schema.IOperator;
import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import cz.startnet.utils.pgdiff.schema.PgStatementWithSearchPath;
import cz.startnet.utils.pgdiff.schema.meta.MetaContainer;

public class OperatorAnalysisLaincher extends AbstractAnalysisLauncher {

    private final GenericColumn function;

    public OperatorAnalysisLaincher(PgStatementWithSearchPath stmt, GenericColumn function, String location) {
        super(stmt, null, location);
        this.function = function;
    }

    @Override
    protected Set<PgObjLocation> analyze(ParserRuleContext ctx, MetaContainer meta) {
        IFunction func = meta.findFunction(function.schema, function.table);
        IOperator oper = meta.findOperator(stmt.getSchemaName(), stmt.getName());

        if (oper != null && func != null) {
            oper.setReturns(func.getReturns());
        }

        return Collections.emptySet();
    }

}
