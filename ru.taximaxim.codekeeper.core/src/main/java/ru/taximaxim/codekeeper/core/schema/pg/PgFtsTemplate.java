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
package ru.taximaxim.codekeeper.core.schema.pg;

import java.util.Objects;

import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.ISearchPath;
import ru.taximaxim.codekeeper.core.schema.ObjectState;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.script.SQLScript;

public final class PgFtsTemplate extends PgStatement implements ISearchPath {

    private String initFunction;
    private String lexizeFunction;

    public PgFtsTemplate(String name) {
        super(name);
    }

    @Override
    public DbObjType getStatementType() {
        return DbObjType.FTS_TEMPLATE;
    }

    @Override
    public AbstractSchema getContainingSchema() {
        return (AbstractSchema) parent;
    }

    @Override
    public void getCreationSQL(SQLScript script) {
        StringBuilder sbSql = new StringBuilder();
        sbSql.append("CREATE TEXT SEARCH TEMPLATE ")
        .append(getQualifiedName()).append(" (\n\t");

        if (initFunction != null) {
            sbSql.append("INIT = ").append(initFunction).append(",\n\t");
        }

        sbSql.append("LEXIZE = ").append(lexizeFunction).append(" )");
        script.addStatement(sbSql);
        appendComments(script);
    }

    @Override
    public ObjectState appendAlterSQL(PgStatement newCondition, SQLScript script) {
        int startSize = script.getSize();
        if (!compareUnalterable((PgFtsTemplate) newCondition)) {
            return ObjectState.RECREATE;
        }
        appendAlterComments(newCondition, script);

        return getObjectState(script, startSize);
    }

    @Override
    public PgFtsTemplate shallowCopy() {
        PgFtsTemplate templateDst = new PgFtsTemplate(name);
        copyBaseFields(templateDst);
        templateDst.setInitFunction(initFunction);
        templateDst.setLexizeFunction(lexizeFunction);
        return templateDst;
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof PgFtsTemplate temp && super.compare(obj)) {
            return compareUnalterable(temp);
        }

        return false;
    }

    private boolean compareUnalterable(PgFtsTemplate template) {
        return Objects.equals(initFunction, template.initFunction)
                && Objects.equals(lexizeFunction, template.lexizeFunction);
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.put(initFunction);
        hasher.put(lexizeFunction);
    }

    public void setInitFunction(final String initFunction) {
        this.initFunction = initFunction;
        resetHash();
    }

    public void setLexizeFunction(final String lexizeFunction) {
        this.lexizeFunction = lexizeFunction;
        resetHash();
    }
}
