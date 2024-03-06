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
package ru.taximaxim.codekeeper.core.schema.pg;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.AbstractDatabase;
import ru.taximaxim.codekeeper.core.schema.ICast;
import ru.taximaxim.codekeeper.core.schema.PgStatement;

public class PgCast extends PgStatement implements ICast {

    public enum CastMethod {
        FUNCTION, BINARY, INOUT
    }

    private CastMethod method = CastMethod.BINARY;
    private CastContext context = CastContext.EXPLICIT;

    private String function;

    private final String source;
    private final String target;

    @Override
    public DbObjType getStatementType() {
        return DbObjType.CAST;
    }

    public PgCast(String source, String target) {
        super(ICast.getSimpleName(source, target));
        this.source = source;
        this.target = target;
    }

    @Override
    public CastContext getContext() {
        return context;
    }

    public void setContext(CastContext context) {
        this.context = context;
        resetHash();
    }

    public CastMethod getMethod() {
        return method;
    }

    public void setMethod(CastMethod method) {
        this.method = method;
        resetHash();
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
        resetHash();
    }

    @Override
    public String getSource() {
        return source;
    }

    @Override
    public String getTarget() {
        return target;
    }

    @Override
    public AbstractDatabase getDatabase() {
        return (AbstractDatabase) getParent();
    }

    @Override
    public String getQualifiedName() {
        return '(' + source + " AS " + target + ')';
    }

    @Override
    public String getCreationSQL() {
        final StringBuilder sbSQL = new StringBuilder();
        sbSQL.append("CREATE CAST ").append(getQualifiedName());

        switch (method) {
        case FUNCTION:
            sbSQL.append(" WITH FUNCTION ").append(function);
            break;
        case BINARY:
            sbSQL.append(" WITHOUT FUNCTION");
            break;
        case INOUT:
            sbSQL.append(" WITH INOUT");
            break;
        }

        switch (context) {
        case IMPLICIT:
            sbSQL.append(" AS IMPLICIT");
            break;
        case ASSIGNMENT:
            sbSQL.append(" AS ASSIGNMENT");
            break;
        default:
            break;
        }

        sbSQL.append(';');

        return sbSQL.toString();
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        final int startLength = sb.length();
        PgCast newCast = (PgCast) newCondition;

        if (!compareUnalterable(newCast)) {
            isNeedDepcies.set(true);
            return true;
        }
        compareComments(sb, newCast);

        return sb.length() > startLength;
    }

    private boolean compareUnalterable(PgCast cast) {
        return Objects.equals(function, cast.function)
                && method == cast.method
                && context == cast.context;
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof PgCast && super.compare(obj)) {
            return compareUnalterable((PgCast) obj);
        }

        return false;
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.put(context);
        hasher.put(method);
        hasher.put(function);
    }

    @Override
    public PgCast shallowCopy() {
        PgCast copy = new PgCast(getSource(), getTarget());
        copyBaseFields(copy);
        copy.setContext(getContext());
        copy.setMethod(getMethod());
        copy.setFunction(getFunction());
        return copy;
    }
}
