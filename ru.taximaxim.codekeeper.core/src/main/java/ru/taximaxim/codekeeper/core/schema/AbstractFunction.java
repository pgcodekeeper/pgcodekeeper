/*******************************************************************************
 * Copyright 2017-2025 TAXTELECOM, LLC
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
package ru.taximaxim.codekeeper.core.schema;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.script.SQLScript;

public abstract class AbstractFunction extends PgStatement implements IFunction, ISearchPath {

    protected final List<Argument> arguments = new ArrayList<>();

    protected AbstractFunction(String name) {
        super(name);
    }

    @Override
    public AbstractSchema getContainingSchema() {
        return (AbstractSchema) parent;
    }

    @Override
    public String getReturns() {
        // subclasses may override if needed
        return null;
    }

    @Override
    public void setReturns(String returns) {
        throw new IllegalStateException();
    }

    @Override
    public Map<String, String> getReturnsColumns() {
        // subclasses may override if needed
        return Collections.emptyMap();
    }

    @Override
    public void getCreationSQL(SQLScript script) {
        final StringBuilder sbSQL = new StringBuilder();
        appendFunctionFullSQL(sbSQL, true);
        script.addStatement(sbSQL);
        appendOwnerSQL(script);
        appendPrivileges(script);
        appendComments(script);
    }

    @Override
    public boolean canDropBeforeCreate() {
        return true;
    }

    @Override
    public ObjectState appendAlterSQL(PgStatement newCondition, SQLScript script) {
        int startSize = script.getSize();
        boolean isNeedDepcies = false;
        AbstractFunction newFunction = (AbstractFunction) newCondition;

        if (!compareUnalterable(newFunction)) {
            if (needDrop(newFunction)) {
                return ObjectState.RECREATE;
            }

            isNeedDepcies = getDbType() == DatabaseType.MS;

            StringBuilder sbSQL = new StringBuilder();
            newFunction.appendFunctionFullSQL(sbSQL, false);
            script.addStatement(sbSQL);
        }

        appendAlterOwner(newFunction, script);
        alterPrivileges(newFunction, script);
        appendAlterComments(newFunction, script);

        return getObjectState(isNeedDepcies, script, startSize);
    }

    protected abstract void appendFunctionFullSQL(StringBuilder sb, boolean isCreate);

    /**
     * Getter for {@link #arguments}. List cannot be modified.
     */
    @Override
    public List<Argument> getArguments() {
        return Collections.unmodifiableList(arguments);
    }

    public void addArgument(final Argument argument) {
        arguments.add(argument);
        resetHash();
    }

    /**
     * Compares two objects whether they are equal. If both objects are of the same class but they not equal just in
     * whitespace in function body, they are considered being equal.
     *
     * @param func
     *            object to be compared
     * @return true if {@code object} is PgFunction and the function code is the same when compared ignoring whitespace,
     *         otherwise returns false
     */
    protected boolean compareUnalterable(AbstractFunction func) {
        return arguments.equals(func.arguments);
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof AbstractFunction func && super.compare(obj)) {
            return compareUnalterable(func);
        }

        return false;
    }

    public abstract boolean needDrop(AbstractFunction newFunction);

    @Override
    public void computeHash(Hasher hasher) {
        hasher.putOrdered(arguments);
    }

    @Override
    public AbstractFunction shallowCopy() {
        AbstractFunction functionDst = getFunctionCopy();
        copyBaseFields(functionDst);
        for (Argument argSrc : arguments) {
            Argument argDst = new Argument(argSrc.getMode(), argSrc.getName(), argSrc.getDataType());
            argDst.setDefaultExpression(argSrc.getDefaultExpression());
            argDst.setReadOnly(argSrc.isReadOnly());
            functionDst.addArgument(argDst);
        }
        return functionDst;
    }

    protected abstract AbstractFunction getFunctionCopy();
}
