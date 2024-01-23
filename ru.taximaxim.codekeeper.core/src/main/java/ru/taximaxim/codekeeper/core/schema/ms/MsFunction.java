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
 *******************************************************************************/
package ru.taximaxim.codekeeper.core.schema.ms;

import java.util.Objects;

import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.AbstractFunction;
import ru.taximaxim.codekeeper.core.schema.FuncTypes;

public class MsFunction extends AbstractMsFunction {

    private FuncTypes funcType = FuncTypes.SCALAR;

    @Override
    public DbObjType getStatementType() {
        return DbObjType.FUNCTION;
    }

    public MsFunction(String name) {
        super(name);
    }

    @Override
    protected void appendFunctionFullSQL(StringBuilder sbSQL, boolean isCreate) {
        sbSQL.append("SET QUOTED_IDENTIFIER ").append(isQuotedIdentified() ? "ON" : "OFF");
        sbSQL.append(GO).append('\n');
        sbSQL.append("SET ANSI_NULLS ").append(isAnsiNulls() ? "ON" : "OFF");
        sbSQL.append(GO).append('\n');
        appendSourceStatement(isCreate, sbSQL);
        sbSQL.append(GO);
    }

    @Override
    protected boolean compareUnalterable(AbstractFunction func) {
        return func instanceof AbstractMsFunction && super.compareUnalterable(func)
                && Objects.equals(getFuncType(), ((MsFunction) func).getFuncType());
    }

    @Override
    public boolean needDrop(AbstractFunction newFunction) {
        if (newFunction instanceof MsFunction) {
            return getFuncType() != ((MsFunction) newFunction).getFuncType();
        }

        return true;
    }

    @Override
    public void computeHash(Hasher hasher) {
        super.computeHash(hasher);
        hasher.put(getFuncType());
    }

    @Override
    protected AbstractMsFunction getFunctionCopy() {
        MsFunction func = new MsFunction(getName());
        func.setFuncType(getFuncType());
        return func;
    }

    public FuncTypes getFuncType() {
        return funcType;
    }

    public void setFuncType(FuncTypes funcType) {
        this.funcType = funcType;
        resetHash();
    }
}
