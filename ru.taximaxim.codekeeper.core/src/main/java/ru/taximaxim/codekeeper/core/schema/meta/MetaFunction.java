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
package ru.taximaxim.codekeeper.core.schema.meta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.ArgMode;
import ru.taximaxim.codekeeper.core.schema.Argument;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.IFunction;
import ru.taximaxim.codekeeper.core.schema.ISchema;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation;

public final class MetaFunction extends MetaStatement implements IFunction {

    private static final long serialVersionUID = 9086580570309984176L;

    private final String bareName;
    private List<Argument> arguments;
    private transient String signatureCache;

    /**
     * Order by for aggregate functions
     */
    private List<Argument> orderBy;

    /**
     *  Contains table's columns, if function returns table.
     */
    private Map<String, String> returnsColumns;

    /**
     * Function return type name, if null columns contains columns
     */
    private String returns;
    private boolean setof;

    public MetaFunction(PgObjLocation object, String bareName) {
        super(object);
        this.bareName = bareName;
    }

    public MetaFunction(String schemaName, String name, String bareName) {
        super(new GenericColumn(schemaName, name, DbObjType.FUNCTION));
        this.bareName = bareName;
    }

    @Override
    public Map<String, String> getReturnsColumns() {
        return returnsColumns == null ? Collections.emptyMap() : Collections.unmodifiableMap(returnsColumns);
    }

    public void addReturnsColumn(String name, String type) {
        if (returnsColumns == null) {
            returnsColumns = new LinkedHashMap<>();
        }
        returnsColumns.put(name, type);
    }

    @Override
    public List<Argument> getArguments() {
        return arguments == null ? Collections.emptyList() : Collections.unmodifiableList(arguments);
    }

    public void addArgument(final Argument arg) {
        if (arguments == null) {
            arguments = new ArrayList<>();
        }
        arguments.add(arg);
    }

    public boolean isSetof() {
        return setof;
    }

    public void setSetof(final boolean setof) {
        this.setof = setof;
    }

    public void addOrderBy(final Argument type) {
        if (orderBy == null) {
            orderBy = new ArrayList<>();
        }
        orderBy.add(type);
    }

    @Override
    public String getReturns() {
        return returns;
    }

    @Override
    public void setReturns(String returns) {
        this.returns = returns;
    }

    /**
     * Alias for {@link #getSignature()} which provides a unique function ID.
     *
     * Use {@link #getBareName()} to get just the function name.
     */
    @Override
    public String getName() {
        return getSignature();
    }

    @Override
    public String getBareName() {
        return bareName;
    }

    /**
     * Returns function signature. It consists of unquoted name and argument
     * data types.
     *
     * @return function signature
     */
    public String getSignature() {
        if (signatureCache == null) {
            signatureCache = getFunctionSignature();
        }
        return signatureCache;
    }

    private String getFunctionSignature() {
        StringBuilder sb = new StringBuilder();

        sb.append(PgDiffUtils.getQuotedName(getBareName())).append('(');
        boolean addComma = false;
        for (final Argument argument : getArguments()) {
            ArgMode mode = argument.getMode();
            if (ArgMode.OUT == mode) {
                continue;
            }
            if (addComma) {
                sb.append(", ");
            }

            sb.append(argument.getDataType());
            addComma = true;
        }
        sb.append(')');

        return sb.toString();
    }

    @Override
    public ISchema getContainingSchema() {
        throw new IllegalStateException("Unsupported operation");
    }

    @Override
    public String getSchemaName() {
        return getObject().getSchema();
    }
}
