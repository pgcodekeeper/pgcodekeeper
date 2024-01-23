/*******************************************************************************
 * Copyright 2017-2024 TAXTELECOM, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 **
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 *******************************************************************************/
package ru.taximaxim.codekeeper.core.schema.pg;

import java.util.Iterator;
import java.util.Objects;

import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.AbstractFunction;
import ru.taximaxim.codekeeper.core.schema.Argument;

/**
 * Stores Postgres procedure information.
 */
public class PgProcedure extends AbstractPgFunction {

    private String returns;

    public PgProcedure(String name) {
        super(name);
    }

    @Override
    public DbObjType getStatementType() {
        return DbObjType.PROCEDURE;
    }

    @Override
    public String getReturns() {
        return returns;
    }

    @Override
    public void setReturns(String returns) {
        this.returns = returns;
    }

    @Override
    public boolean needDrop(AbstractFunction newFunction) {
        Iterator<Argument> iOld = arguments.iterator();
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
        }

        return false;
    }

    @Override
    protected boolean compareUnalterable(AbstractFunction function) {
        if (function instanceof PgProcedure && super.compareUnalterable(function)) {
            return Objects.equals(returns, ((PgProcedure)function).getReturns());
        }
        return false;
    }

    @Override
    public void computeHash(Hasher hasher) {
        super.computeHash(hasher);
        hasher.put(returns);
    }

    @Override
    protected AbstractPgFunction getFunctionCopy() {
        return new PgProcedure(getBareName());
    }
}
