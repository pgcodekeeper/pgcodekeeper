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
 **
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 *******************************************************************************/
package ru.taximaxim.codekeeper.core.schema.ch;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.PgDiffArguments;
import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.AbstractDatabase;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.IStatement;
import ru.taximaxim.codekeeper.core.schema.PgOverride;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.schema.PgStatementContainer;

public class ChDatabase extends AbstractDatabase {
    private final Map<String, ChFunction> functions = new LinkedHashMap<>();

    public ChDatabase(PgDiffArguments arguments) {
        super(arguments);
    }

    @Override
    protected void fillChildrenList(List<Collection<? extends PgStatement>> l) {
        super.fillChildrenList(l);
        l.add(functions.values());
    }

    @Override
    public PgStatement getChild(String name, DbObjType type) {
        switch (type) {
        case SCHEMA:
            return getSchema(name);
        case FUNCTION:
            return getFunction(name);
        default:
            return null;
        }
    }

    @Override
    public void addChild(IStatement st) {
        DbObjType type = st.getStatementType();
        switch (type) {
        case SCHEMA:
            addSchema((AbstractSchema) st);
            break;
        case FUNCTION:
            addFunction((ChFunction) st);
            break;
        default:
            throw new IllegalArgumentException("Unsupported child type: " + type);
        }
    }

    /**
     * Returns function of given name or null if the extension has not been found.
     *
     * @param name
     *            function name
     *
     * @return found function or null
     */
    public ChFunction getFunction(final String name) {
        return functions.get(name);
    }

    /**
     * Getter for {@link #functions}. The list cannot be modified.
     *
     * @return {@link #functions}
     */
    public Collection<ChFunction> getFunctions() {
        return Collections.unmodifiableCollection(functions.values());
    }

    public void addFunction(final ChFunction function) {
        addUnique(functions, function);
    }

    @Override
    public boolean compareChildren(PgStatement obj) {
        if (obj instanceof ChDatabase && super.compareChildren(obj)) {
            ChDatabase db = (ChDatabase) obj;
            return functions.equals(db.functions);
        }
        return false;
    }

    @Override
    public void computeChildrenHash(Hasher hasher) {
        super.computeChildrenHash(hasher);
        hasher.putUnordered(functions);
    }

    @Override
    protected void concat(PgStatement st) {
        DbObjType type = st.getStatementType();
        String name = st.getName();
        PgStatement parent = st.getParent();
        String parentName = parent.getName();
        PgStatement orig = null;
        switch (type) {
        case SCHEMA:
        case FUNCTION:
            orig = getChild(name, type);
            if (orig == null) {
                addChild(st.shallowCopy());
            }
            break;
        case CONSTRAINT:
        case INDEX:
            PgStatementContainer cont = getSchema(parent.getParent().getName()).getStatementContainer(parentName);

            orig = cont.getChild(name, type);
            if (orig == null) {
                cont.addChild(st.shallowCopy());
            }
            break;
        default:
            AbstractSchema schema = getSchema(parentName);
            orig = schema.getChild(name, type);
            if (orig == null) {
                schema.addChild(st.shallowCopy());
            }
            break;
        }

        if (orig != null && !orig.compare(st)) {
            addOverride(new PgOverride(orig, st));
        }
    }

    @Override
    protected AbstractDatabase getDatabaseCopy() {
        return new ChDatabase(getArguments());
    }

    @Override
    public DatabaseType getDbType() {
        return DatabaseType.CH;
    }

}