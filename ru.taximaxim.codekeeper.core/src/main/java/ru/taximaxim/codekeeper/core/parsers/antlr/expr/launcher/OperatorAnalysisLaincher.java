package ru.taximaxim.codekeeper.core.parsers.antlr.expr.launcher;

import java.util.Collections;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;

import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.IFunction;
import ru.taximaxim.codekeeper.core.schema.IOperator;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation;
import ru.taximaxim.codekeeper.core.schema.PgStatementWithSearchPath;
import ru.taximaxim.codekeeper.core.schema.meta.MetaContainer;

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
