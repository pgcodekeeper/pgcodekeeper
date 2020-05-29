package cz.startnet.utils.pgdiff.parsers.antlr.expr.launcher;

import java.util.Collections;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.IDatabase;
import cz.startnet.utils.pgdiff.schema.IFunction;
import cz.startnet.utils.pgdiff.schema.IOperator;
import cz.startnet.utils.pgdiff.schema.ISchema;
import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import cz.startnet.utils.pgdiff.schema.PgStatementWithSearchPath;

public class OperatorAnalysisLaincher extends AbstractAnalysisLauncher {

    private final GenericColumn function;

    public OperatorAnalysisLaincher(PgStatementWithSearchPath stmt, GenericColumn function, String location) {
        super(stmt, null, location);
        this.function = function;
    }

    @Override
    protected Set<PgObjLocation> analyze(ParserRuleContext ctx, IDatabase db) {
        ISchema schema = db.getSchema(function.schema);
        if (schema != null) {
            IFunction func = schema.getFunction(function.table);
            IOperator oper = db.getSchema(stmt.getSchemaName()).getOperator(stmt.getName());

            if (oper != null && func != null) {
                oper.setReturns(func.getReturns());
            }
        }

        return Collections.emptySet();
    }

}
