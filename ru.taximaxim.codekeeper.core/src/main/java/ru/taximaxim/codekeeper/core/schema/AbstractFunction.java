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
package ru.taximaxim.codekeeper.core.schema;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.hashers.Hasher;

public abstract class AbstractFunction extends PgStatementWithSearchPath implements IFunction {

    protected final List<Argument> arguments = new ArrayList<>();

    protected AbstractFunction(String name) {
        super(name);
    }

    @Override
    public AbstractSchema getContainingSchema() {
        return (AbstractSchema) getParent();
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
    public final String getCreationSQL() {
        final StringBuilder sbSQL = new StringBuilder();
        appendFunctionFullSQL(sbSQL, true);
        appendOwnerSQL(sbSQL);
        appendPrivileges(sbSQL);

        if (comment != null && !comment.isEmpty()) {
            appendCommentSql(sbSQL);
        }

        return sbSQL.toString();
    }

    @Override
    public boolean canDropBeforeCreate() {
        return true;
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        final int startLength = sb.length();
        AbstractFunction newFunction = (AbstractFunction) newCondition;

        if (!compareUnalterable(newFunction)) {
            if (needDrop(newFunction)) {
                isNeedDepcies.set(true);
                return true;
            }

            if (getDbType() == DatabaseType.MS) {
                isNeedDepcies.set(true);
            }

            newFunction.appendFunctionFullSQL(sb, false);
        }

        if (!Objects.equals(getOwner(), newFunction.getOwner())) {
            newFunction.alterOwnerSQL(sb);
        }

        alterPrivileges(newFunction, sb);

        if (!Objects.equals(getComment(), newFunction.getComment())) {
            newFunction.appendCommentSql(sb);
        }

        return sb.length() > startLength;
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

        return obj instanceof AbstractFunction && super.compare(obj)
                && compareUnalterable((AbstractFunction) obj);
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
