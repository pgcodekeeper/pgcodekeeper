/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff.schema;

import java.util.Iterator;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

/**
 * Stores Postgres procedure information.
 */
public class PgProcedure extends AbstractPgFunction {

    public PgProcedure(String name) {
        super(name);
    }

    @Override
    public DbObjType getStatementType() {
        return DbObjType.PROCEDURE;
    }

    @Override
    public boolean needDrop(AbstractFunction newFunction) {
        Iterator<Argument> iOld = arguments.iterator();
        Iterator<Argument> iNew = newFunction.arguments.iterator();
        while (iOld.hasNext() && iNew.hasNext()) {
            Argument argOld = iOld.next();
            Argument argNew = iNew.next();

            String oldDef = argOld.getDefaultExpression();
            String newDef = argNew.getDefaultExpression();
            // allow creation of defaults (old==null && new!=null)
            if (oldDef != null && !oldDef.equals(newDef)) {
                return true;
            }
        }

        return false;
    }

    @Override
    protected AbstractPgFunction getFunctionCopy() {
        return new PgProcedure(getBareName());
    }
}
