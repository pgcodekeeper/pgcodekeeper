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

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.IOptionContainer;
import ru.taximaxim.codekeeper.core.schema.ISearchPath;
import ru.taximaxim.codekeeper.core.schema.ISimpleOptionContainer;
import ru.taximaxim.codekeeper.core.schema.ObjectState;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.script.SQLScript;

public class PgFtsDictionary extends PgStatement
implements ISimpleOptionContainer, ISearchPath {

    private String template;
    private final Map<String, String> options = new LinkedHashMap<>();

    public PgFtsDictionary(String name) {
        super(name);
    }

    @Override
    public DbObjType getStatementType() {
        return DbObjType.FTS_DICTIONARY;
    }

    @Override
    public AbstractSchema getContainingSchema() {
        return (AbstractSchema) getParent();
    }

    @Override
    public void getCreationSQL(SQLScript script) {
        final StringBuilder sbSql = new StringBuilder();
        sbSql.append("CREATE TEXT SEARCH DICTIONARY ")
        .append(getQualifiedName());
        sbSql.append(" (\n\tTEMPLATE = ").append(template);

        options.forEach((k,v) -> sbSql.append(",\n\t").append(k).append(" = ").append(v));
        sbSql.append(" )");
        script.addStatement(sbSql);
        appendOwnerSQL(script);
        appendComments(script);
    }

    @Override
    public ObjectState appendAlterSQL(PgStatement newCondition, SQLScript script) {
        int startSize = script.getSize();
        PgFtsDictionary newDictionary = (PgFtsDictionary) newCondition;

        if (!newDictionary.getTemplate().equals(template)) {
            return ObjectState.RECREATE;
        }

        compareOptions(newDictionary, script);
        appendAlterComments(newDictionary, script);

        return getObjectState(script, startSize);
    }

    @Override
    public void appendOptions(IOptionContainer newContainer, StringBuilder setOptions, StringBuilder resetOptions,
            SQLScript script) {
        StringBuilder sb = new StringBuilder();
        sb.append("ALTER TEXT SEARCH DICTIONARY ");
        sb.append(getQualifiedName());
        sb.append("\n\t(");

        if (setOptions.length() > 0) {
            sb.append(setOptions);
        }

        if (resetOptions.length() > 0) {
            sb.append(resetOptions);
        }
        sb.setLength(sb.length() - 2);
        sb.append(")");
        script.addStatement(sb);
    }

    public void setTemplate(final String template) {
        this.template = template;
        resetHash();
    }

    public String getTemplate() {
        return template;
    }

    @Override
    public void addOption(String option, String value) {
        options.put(option, value);
        resetHash();
    }

    @Override
    public Map<String, String> getOptions() {
        return Collections.unmodifiableMap(options);
    }

    @Override
    public PgFtsDictionary shallowCopy() {
        PgFtsDictionary dictDst = new PgFtsDictionary(getName());
        copyBaseFields(dictDst);
        dictDst.setTemplate(getTemplate());
        dictDst.options.putAll(options);
        return dictDst;
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof PgFtsDictionary dictionary && super.compare(obj)) {
            return Objects.equals(template, dictionary.template)
                    && options.equals(dictionary.options);
        }

        return false;
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.put(template);
        hasher.put(options);
    }
}
