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
package ru.taximaxim.codekeeper.core.schema.ch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import ru.taximaxim.codekeeper.core.ChDiffUtils;
import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.Argument;
import ru.taximaxim.codekeeper.core.schema.IFunction;
import ru.taximaxim.codekeeper.core.schema.ISchema;
import ru.taximaxim.codekeeper.core.schema.ObjectState;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.script.SQLScript;

public final class ChFunction extends PgStatement implements IFunction {

    private String body;
    private final List<Argument> arguments = new ArrayList<>();

    public ChFunction(String name) {
        super(name);
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
        resetHash();
    }

    @Override
    public List<Argument> getArguments() {
        return Collections.unmodifiableList(arguments);
    }

    public void addArgument(Argument argument) {
        arguments.add(argument);
        resetHash();
    }

    @Override
    public DbObjType getStatementType() {
        return DbObjType.FUNCTION;
    }

    @Override
    public void getCreationSQL(SQLScript script) {
        final StringBuilder sb = new StringBuilder();
        sb.append("CREATE FUNCTION ").append(ChDiffUtils.getQuotedName(name)).append(" AS ");
        fillArgs(sb);
        sb.append(" -> ").append(body);
        script.addStatement(sb);
    }

    private void fillArgs(StringBuilder sb) {
        sb.append("(");
        sb.append(arguments.stream().map(Argument::getName).collect(Collectors.joining(", ")));
        sb.append(")");
    }

    @Override
    protected StringBuilder appendFullName(StringBuilder sb) {
        sb.append(getQualifiedName());
        return sb;
    }

    @Override
    public ObjectState appendAlterSQL(PgStatement newCondition, SQLScript script) {
        var newFunction = (ChFunction) newCondition;
        if (!compareUnalterable(newFunction)) {
            return ObjectState.RECREATE;
        }
        return ObjectState.NOTHING;
    }

    @Override
    public DatabaseType getDbType() {
        return DatabaseType.CH;
    }

    private boolean compareUnalterable(ChFunction newFunc) {
        return Objects.equals(body, newFunc.getBody())
                && arguments.equals(newFunc.arguments);
    }

    @Override
    public ChDatabase getDatabase() {
        return (ChDatabase) parent;
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.put(body);
        hasher.putOrdered(arguments);
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (this == obj) {
            return true;
        }

        return obj instanceof ChFunction func && super.compare(func)
                && compareUnalterable(func);
    }

    @Override
    public PgStatement shallowCopy() {
        ChFunction copy = new ChFunction(name);
        copyBaseFields(copy);
        copy.arguments.addAll(arguments);
        copy.setBody(body);
        return copy;
    }

    @Override
    public String getReturns() {
        return null;
    }

    @Override
    public Map<String, String> getReturnsColumns() {
        return Collections.emptyMap();
    }

    @Override
    public void setReturns(String returns) {
        //unused
    }

    @Override
    public ISchema getContainingSchema() {
        return null;
    }
}