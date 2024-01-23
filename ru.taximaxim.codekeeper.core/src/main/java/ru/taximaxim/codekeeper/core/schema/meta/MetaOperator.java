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
package ru.taximaxim.codekeeper.core.schema.meta;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.IOperator;
import ru.taximaxim.codekeeper.core.schema.ISchema;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation;

public class MetaOperator extends MetaStatement implements IOperator {

    private static final long serialVersionUID = 5893184839623238431L;

    private String left;
    private String right;
    private String returns;

    public MetaOperator(PgObjLocation object) {
        super(object);
    }

    public MetaOperator(String schemaName, String name) {
        super(new GenericColumn(schemaName, name, DbObjType.OPERATOR));
    }

    @Override
    public String getName() {
        return getSignature();
    }

    public String getSignature() {
        StringBuilder sb = new StringBuilder();
        sb.append(getBareName());
        sb.append('(');
        sb.append(left == null ? "NONE" : left);
        sb.append(", ");
        sb.append(right == null ? "NONE" : right);
        sb.append(')');
        return sb.toString();
    }

    @Override
    public String getRightArg() {
        return right;
    }

    @Override
    public String getLeftArg() {
        return left;
    }

    @Override
    public String getReturns() {
        return returns;
    }

    public void setLeftArg(String left) {
        this.left = left;
    }

    public void setRightArg(String right) {
        this.right = right;
    }

    @Override
    public void setReturns(String returns) {
        this.returns = returns;
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
