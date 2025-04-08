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

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.IRelation;
import ru.taximaxim.codekeeper.core.schema.IStatement;
import ru.taximaxim.codekeeper.core.schema.ObjectState;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.script.SQLScript;

public final class ChSchema extends AbstractSchema {

    private String engine = "Atomic";
    private Map<String, ChDictionary> dictionaries = new LinkedHashMap<>();

    public ChSchema(String name) {
        super(name);
    }

    public void setEngine(String engine) {
        this.engine = engine;
        resetHash();
    }

    @Override
    public Stream<IRelation> getRelations() {
        return Stream.concat(super.getRelations(), dictionaries.values().stream());
    }

    @Override
    public IRelation getRelation(String name) {
        IRelation result = super.getRelation(name);
        return result != null ? result : getDictionary(name);
    }

    private void addDictionary(final ChDictionary dictionary) {
        addUnique(dictionaries, dictionary);
    }

    @Override
    protected void fillChildrenList(List<Collection<? extends PgStatement>> l) {
        super.fillChildrenList(l);
        l.add(dictionaries.values());
    }

    @Override
    public PgStatement getChild(String name, DbObjType type) {
        if (type == DbObjType.DICTIONARY) {
            return getDictionary(name);
        }
        return super.getChild(name, type);
    }

    private ChDictionary getDictionary(String name) {
        return getChildByName(dictionaries, name);
    }

    @Override
    public void addChild(IStatement st) {
        DbObjType type = st.getStatementType();
        if (type == DbObjType.DICTIONARY) {
            addDictionary((ChDictionary) st);
            return;
        }
        super.addChild(st);
    }

    @Override
    public void getCreationSQL(SQLScript script) {
        var sb = new StringBuilder();
        sb.append("CREATE DATABASE ");
        appendIfNotExists(sb, script.getSettings());
        sb.append(getQualifiedName()).append("\nENGINE = ").append(engine);
        if (getComment() != null) {
            sb.append("\nCOMMENT ").append(getComment());
        }
        script.addStatement(sb);
    }

    @Override
    public ObjectState appendAlterSQL(PgStatement newCondition, SQLScript script) {
        if (!compareUnalterable((ChSchema) newCondition)) {
            return ObjectState.RECREATE;
        }
        return ObjectState.NOTHING;
    }

    @Override
    public void getDropSQL(SQLScript script, boolean generateExists) {
        final StringBuilder sb = new StringBuilder();
        sb.append("DROP DATABASE ");
        if (generateExists) {
            sb.append(IF_EXISTS);
        }
        appendFullName(sb);
        script.addStatement(sb);
    }

    @Override
    public DatabaseType getDbType() {
        return DatabaseType.CH;
    }

    @Override
    public void computeHash(Hasher hasher) {
        super.computeHash(hasher);
        hasher.put(engine);
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (this == obj) {
            return true;
        }
        return obj instanceof ChSchema schema && super.compare(schema)
                && compareUnalterable(schema);
    }

    private boolean compareUnalterable(ChSchema newSchema) {
        return Objects.equals(engine, newSchema.engine)
                && Objects.equals(comment, newSchema.comment);
    }

    @Override
    public boolean compareChildren(PgStatement obj) {
        if (obj instanceof ChSchema schema) {
            return super.compareChildren(obj)
                    && dictionaries.equals(schema.dictionaries);
        }
        return false;
    }

    @Override
    protected void computeChildrenHash(Hasher hasher) {
        super.computeChildrenHash(hasher);
        hasher.putUnordered(dictionaries);
    }

    @Override
    protected AbstractSchema getSchemaCopy() {
        var schema = new ChSchema(name);
        schema.setEngine(engine);
        return schema;
    }

    @Override
    public void appendComments(SQLScript script) {
        // no impl
    }
}
