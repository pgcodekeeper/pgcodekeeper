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
package ru.taximaxim.codekeeper.core.schema.pg;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.PgDiffArguments;
import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.AbstractDatabase;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.IOperator;
import ru.taximaxim.codekeeper.core.schema.IStatement;
import ru.taximaxim.codekeeper.core.schema.PgStatement;

/**
 * Stores database information.
 *
 * @author fordfrog
 */
public class PgDatabase extends AbstractDatabase {

    private final Map<String, PgExtension> extensions = new LinkedHashMap<>();
    private final Map<String, PgEventTrigger> eventTriggers = new LinkedHashMap<>();
    private final Map<String, PgForeignDataWrapper> fdws = new LinkedHashMap<>();
    private final Map<String, PgServer> servers = new LinkedHashMap<>();
    private final Map<String, PgUserMapping> userMappings = new LinkedHashMap<>();
    private final Map<String, PgCast> casts = new LinkedHashMap<>();
    private final Map<String, PgTrigger> parentTriggers = new LinkedHashMap<>();

    public PgDatabase() {
        super();
    }

    public PgDatabase(PgDiffArguments arguments) {
        super(arguments);
    }

    public boolean containsExtension(final String name) {
        return getExtension(name) != null;
    }

    @Override
    protected void fillChildrenList(List<Collection<? extends PgStatement>> l) {
        super.fillChildrenList(l);
        l.add(extensions.values());
        l.add(eventTriggers.values());
        l.add(fdws.values());
        l.add(servers.values());
        l.add(userMappings.values());
        l.add(casts.values());
    }

    @Override
    public PgStatement getChild(String name, DbObjType type) {
        switch (type) {
        case SCHEMA:
            return getSchema(name);
        case EXTENSION:
            return getExtension(name);
        case EVENT_TRIGGER:
            return getEventTrigger(name);
        case FOREIGN_DATA_WRAPPER:
            return getForeignDW(name);
        case SERVER:
            return getServer(name);
        case USER_MAPPING:
            return getUserMapping(name);
        case CAST:
            return getCast(name);
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
        case EXTENSION:
            addExtension((PgExtension) st);
            break;
        case EVENT_TRIGGER:
            addEventTrigger((PgEventTrigger) st);
            break;
        case FOREIGN_DATA_WRAPPER:
            addForeignDW((PgForeignDataWrapper) st);
            break;
        case SERVER:
            addServer((PgServer) st);
            break;
        case CAST:
            addCast((PgCast) st);
            break;
        case USER_MAPPING:
            addUserMapping((PgUserMapping) st);
            break;
        default:
            throw new IllegalArgumentException("Unsupported child type: " + type);
        }
    }

    /**
     * Returns extension of given name or null if the extension has not been found.
     *
     * @param name
     *            extension name
     *
     * @return found extension or null
     */
    public PgExtension getExtension(final String name) {
        return extensions.get(name);
    }

    /**
     * Getter for {@link #extensions}. The list cannot be modified.
     *
     * @return {@link #extensions}
     */
    public Collection<PgExtension> getExtensions() {
        return Collections.unmodifiableCollection(extensions.values());
    }

    public void addExtension(final PgExtension extension) {
        addUnique(extensions, extension);
    }

    public Collection<PgEventTrigger> getEventTriggers() {
        return Collections.unmodifiableCollection(eventTriggers.values());
    }

    public PgEventTrigger getEventTrigger(final String name) {
        return eventTriggers.get(name);
    }

    public void addEventTrigger(final PgEventTrigger et) {
        addUnique(eventTriggers, et);
    }

    /**
     * Returns foreign data wrapper of given name or null if the foreign data wrapper has not been found.
     *
     * @param name
     *            foreign data wrapper name
     *
     * @return found foreign data wrapper or null
     */
    public PgForeignDataWrapper getForeignDW(final String name) {
        return fdws.get(name);
    }

    /**
     * Getter for {@link #fdws}. The list cannot be modified.
     *
     * @return {@link #fdws}
     */
    public Collection<PgForeignDataWrapper> getForeignDWs() {
        return Collections.unmodifiableCollection(fdws.values());
    }

    public void addForeignDW(final PgForeignDataWrapper fDW) {
        addUnique(fdws, fDW);
    }

    public PgServer getServer(final String name) {
        return servers.get(name);
    }

    public Collection<PgServer> getServers() {
        return Collections.unmodifiableCollection(servers.values());
    }

    public void addServer(final PgServer server) {
        addUnique(servers, server);
    }

    public PgUserMapping getUserMapping(final String name) {
        return userMappings.get(name);
    }

    public Collection<PgUserMapping> getUserMappings() {
        return Collections.unmodifiableCollection(userMappings.values());
    }

    public void addUserMapping(final PgUserMapping userMapping) {
        addUnique(userMappings, userMapping);
    }

    /**
     * Returns cast of given name or null if the cast has not been found.
     *
     * @param name
     *            cast name
     *
     * @return found cast or null
     */
    public PgCast getCast(final String name) {
        return casts.get(name);
    }

    /**
     * Getter for {@link #casts}. The list cannot be modified.
     *
     * @return {@link #casts}
     */
    public Collection<PgCast> getCasts() {
        return Collections.unmodifiableCollection(casts.values());
    }

    public void addCast(final PgCast cast) {
        addUnique(casts, cast);
    }

    @Override
    public boolean compareChildren(PgStatement obj) {
        if (obj instanceof PgDatabase db && super.compareChildren(obj)) {
            return extensions.equals(db.extensions)
                    && eventTriggers.equals(db.eventTriggers)
                    && fdws.equals(db.fdws)
                    && servers.equals(db.servers)
                    && casts.equals(db.casts);
        }
        return false;
    }

    @Override
    public void computeChildrenHash(Hasher hasher) {
        super.computeChildrenHash(hasher);
        hasher.putUnordered(extensions);
        hasher.putUnordered(eventTriggers);
        hasher.putUnordered(fdws);
        hasher.putUnordered(servers);
        hasher.putUnordered(casts);
    }

    @Override
    protected void concat(PgStatement st) {
        DbObjType type = st.getStatementType();
        String name = st.getName();
        if (type == DbObjType.SCHEMA && Consts.PUBLIC.equals(name) && !st.hasChildren()) {
            // skip empty public schema
            return;
        }

        super.concat(st);
    }

    @Override
    protected boolean isFirstLevelType(DbObjType type) {
        return type.in(DbObjType.SCHEMA, DbObjType.EXTENSION, DbObjType.FOREIGN_DATA_WRAPPER, DbObjType.EVENT_TRIGGER,
                DbObjType.SERVER, DbObjType.USER_MAPPING, DbObjType.CAST);
    }

    @Override
    protected AbstractDatabase getDatabaseCopy() {
        return new PgDatabase(getArguments());
    }

    @Override
    protected IOperator resolveOperatorCall(AbstractSchema abstractSchema, String table) {
        PgSchema schema = (PgSchema) abstractSchema;
        IOperator oper = null;
        if (table.indexOf('(') != -1) {
            oper = schema.getOperator(table);
        }
        if (oper != null) {
            return oper;
        }

        int found = 0;
        for (IOperator o : schema.getOperators()) {
            if (o.getBareName().equals(table)) {
                ++found;
                oper = o;
            }
        }
        return found == 1 ? oper : null;
    }

    public Map<String, PgTrigger> getParentTriggers() {
        return parentTriggers;
    }
}