/*******************************************************************************
 * Copyright 2017-2023 TAXTELECOM, LLC
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

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.schema.AbstractFunction;
import ru.taximaxim.codekeeper.core.schema.SourceStatement;

public abstract class AbstractMsFunction extends AbstractFunction
implements SourceStatement {

    private boolean ansiNulls;
    private boolean quotedIdentified;
    private String firstPart;
    private String secondPart;

    protected AbstractMsFunction(String name) {
        super(name);
    }

    @Override
    public String getFirstPart() {
        return firstPart;
    }

    @Override
    public void setFirstPart(String firstPart) {
        this.firstPart = firstPart;
        resetHash();
    }

    @Override
    public String getSecondPart() {
        return secondPart;
    }

    @Override
    public void setSecondPart(String secondPart) {
        this.secondPart = secondPart;
        resetHash();
    }

    public void setAnsiNulls(boolean ansiNulls) {
        this.ansiNulls = ansiNulls;
        resetHash();
    }

    public boolean isAnsiNulls() {
        return ansiNulls;
    }

    public void setQuotedIdentified(boolean quotedIdentified) {
        this.quotedIdentified = quotedIdentified;
        resetHash();
    }

    public boolean isQuotedIdentified() {
        return quotedIdentified;
    }

    @Override
    public void computeHash(Hasher hasher) {
        super.computeHash(hasher);
        hasher.put(getFirstPart());
        hasher.put(getSecondPart());
        hasher.put(isQuotedIdentified());
        hasher.put(isAnsiNulls());
    }

    @Override
    protected boolean compareUnalterable(AbstractFunction func) {
        if (func instanceof AbstractMsFunction && super.compareUnalterable(func)) {
            AbstractMsFunction newFunction = (AbstractMsFunction) func;
            return isAnsiNulls() == newFunction.isAnsiNulls()
                    && isQuotedIdentified() == newFunction.isQuotedIdentified()
                    && Objects.equals(getFirstPart(), newFunction.getFirstPart())
                    && Objects.equals(getSecondPart(), newFunction.getSecondPart());
        }

        return false;
    }

    @Override
    public AbstractFunction shallowCopy() {
        AbstractMsFunction functionDst = (AbstractMsFunction) super.shallowCopy();
        functionDst.setAnsiNulls(isAnsiNulls());
        functionDst.setQuotedIdentified(isQuotedIdentified());
        functionDst.setFirstPart(getFirstPart());
        functionDst.setSecondPart(getSecondPart());
        return functionDst;
    }

    @Override
    public DatabaseType getDbType() {
        return DatabaseType.MS;
    }
}
