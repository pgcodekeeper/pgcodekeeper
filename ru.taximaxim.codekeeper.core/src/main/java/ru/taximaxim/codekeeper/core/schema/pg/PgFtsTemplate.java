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

import java.util.Collection;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.ISearchPath;
import ru.taximaxim.codekeeper.core.schema.ObjectState;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.schema.SQLAction;

public class PgFtsTemplate extends PgStatement implements ISearchPath {

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
        return (AbstractSchema) getParent();
    }

    @Override
    public void getCreationSQL(Collection<SQLAction> createActions) {
        SQLAction sbSql = new SQLAction();
        sbSql.append("CREATE TEXT SEARCH TEMPLATE ")
        .append(getQualifiedName()).append(" (\n\t");

        if (initFunction != null) {
            sbSql.append("INIT = ").append(initFunction).append(",\n\t");
        }

        sbSql.append("LEXIZE = ").append(lexizeFunction).append(" )");
        createActions.add(sbSql);
        appendComments(createActions);
    }

    @Override
    public ObjectState appendAlterSQL(PgStatement newCondition,
            AtomicBoolean isNeedDepcies, Collection<SQLAction> alterActions) {

        if (!compareUnalterable((PgFtsTemplate) newCondition)) {
            isNeedDepcies.set(true);
            return ObjectState.RECREATE;
        }
        appendAlterComments(newCondition, alterActions);

        return getObjectState(alterActions);
    }

    @Override
    public PgFtsTemplate shallowCopy() {
        PgFtsTemplate templateDst = new PgFtsTemplate(getName());
        copyBaseFields(templateDst);
        templateDst.setInitFunction(getInitFunction());
        templateDst.setLexizeFunction(getLexizeFunction());
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

    public String getInitFunction() {
        return initFunction;
    }

    public void setInitFunction(final String initFunction) {
        this.initFunction = initFunction;
        resetHash();
    }

    public String getLexizeFunction() {
        return lexizeFunction;
    }

    public void setLexizeFunction(final String lexizeFunction) {
        this.lexizeFunction = lexizeFunction;
        resetHash();
    }
}
