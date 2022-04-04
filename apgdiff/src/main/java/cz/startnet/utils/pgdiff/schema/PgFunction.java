/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff.schema;

import java.util.Iterator;
import java.util.Objects;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

/**
 * Stores Postgres function information.
 */
public class PgFunction extends AbstractPgFunction {

    @Override
    public DbObjType getStatementType() {
        return DbObjType.FUNCTION;
    }

    public PgFunction(String name) {
        super(name);
    }

    @Override
    public boolean needDrop(AbstractFunction newFunction) {
        if (newFunction == null ||
                !Objects.equals(getReturns(), newFunction.getReturns())) {
            return true;
        }

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

            // [IN]OUT args that change their names implicitly change the function's
            // return type due to it being "SETOF record" in case of
            // multiple [IN]OUT args present

            // actually any argument name change requires drop
            if (!Objects.equals(argOld.getName(), argNew.getName())) {
                return true;
            }
            // нельзя менять тип out параметров
            if (ArgMode.OUT == argOld.getMode() &&
                    !Objects.equals(argOld.getDataType(), argNew.getDataType())) {
                return true;
            }

            // Covers any difference between modes of arguments, but used only
            // for cases of changes of 'IN' to 'INOUT' and vice versa.
            // Other cases are processed in another places.
            if (argOld.getMode() != argNew.getMode()) {
                return true;
            }
        }
        // Если добавляется или удаляется out параметр нужно удалить функцию,
        // т.к. меняется её возвращаемое значение
        while (iOld.hasNext()) {
            if (ArgMode.OUT  == iOld.next().getMode()) {
                return true;
            }
        }
        while (iNew.hasNext()) {
            if (ArgMode.OUT == iNew.next().getMode()) {
                return true;
            }
        }

        return false;
    }

    @Override
    protected AbstractPgFunction getFunctionCopy() {
        return new PgFunction(getBareName());
    }
}
