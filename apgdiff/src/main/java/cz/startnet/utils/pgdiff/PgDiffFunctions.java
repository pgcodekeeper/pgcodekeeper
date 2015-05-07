/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff;

import java.util.Iterator;
import java.util.Objects;

import cz.startnet.utils.pgdiff.schema.PgFunction;
import cz.startnet.utils.pgdiff.schema.PgFunction.Argument;

/**
 * Diffs functions.
 *
 * @author fordfrog
 */
public final class PgDiffFunctions {

    public static boolean needDrop(PgFunction oldFunction,
            PgFunction newFunction) {
        if (newFunction == null || 
                !Objects.equals(oldFunction.getReturns(), newFunction.getReturns())) {
            return true;
        }
        
        Iterator<Argument> iOld = oldFunction.getArguments().iterator();
        Iterator<Argument> iNew = newFunction.getArguments().iterator();
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
            if (/*argOld.getMode() != null && argOld.getMode().endsWith("OUT") &&*/
                    !Objects.equals(argOld.getName(), argNew.getName())) {
                return true;
            }
        }
        
        return false;
    }

    /**
     * Creates a new instance of PgDiffFunctions.
     */
    private PgDiffFunctions() {
    }
}
