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
package ru.taximaxim.codekeeper.core.schema;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.pg.PgShellType;

/**
 * Stores base schema information.
 */
public abstract class AbstractSchema extends PgStatement implements ISchema {

    private final Map<String, AbstractFunction> functions = new LinkedHashMap<>();
    private final Map<String, AbstractSequence> sequences = new LinkedHashMap<>();
    private final Map<String, AbstractTable> tables = new LinkedHashMap<>();
    private final Map<String, AbstractView> views = new LinkedHashMap<>();
    private final Map<String, AbstractType> types = new LinkedHashMap<>();

    @Override
    public DbObjType getStatementType() {
        return DbObjType.SCHEMA;
    }

    protected AbstractSchema(String name) {
        super(name);
    }

    @Override
    public AbstractDatabase getDatabase() {
        return (AbstractDatabase) parent;
    }

    /**
     * Finds function according to specified function {@code signature}.
     *
     * @param signature signature of the function to be searched
     *
     * @return found function or null if no such function has been found
     */
    @Override
    public AbstractFunction getFunction(final String signature) {
        return functions.get(signature);
    }

    /**
     * @return found relation or null if no such relation has been found
     */
    @Override
    public IRelation getRelation(String name) {
        return getRelations().filter(rel -> rel.getName().equals(name))
                .findAny().orElse(null);
    }

    /**
     * Getter for {@link #functions}. The list cannot be modified.
     *
     * @return {@link #functions}
     */
    @Override
    public Collection<IFunction> getFunctions() {
        return Collections.unmodifiableCollection(functions.values());
    }

    @Override
    public Stream<IRelation> getRelations() {
        return Stream.concat(Stream.concat(tables.values().stream(), views.values().stream()),
                sequences.values().stream());
    }

    @Override
    protected void fillDescendantsList(List<Collection<? extends PgStatement>> l) {
        fillChildrenList(l);
        for (AbstractTable table : tables.values()) {
            table.fillDescendantsList(l);
        }
        for (AbstractView view : views.values()) {
            view.fillDescendantsList(l);
        }
    }

    @Override
    protected void fillChildrenList(List<Collection<? extends PgStatement>> l) {
        l.add(functions.values());
        l.add(sequences.values());
        l.add(types.values());
        l.add(tables.values());
        l.add(views.values());
    }

    @Override
    public PgStatement getChild(String name, DbObjType type) {
        switch (type) {
        case FUNCTION:
        case PROCEDURE:
        case AGGREGATE:
            final String signature = name;
            AbstractFunction func = functions.get(signature);
            return func != null && func.getStatementType() == type ? func : null;
        case SEQUENCE:
            return sequences.get(name);
        case TYPE:
            return types.get(name);
        case TABLE:
            return tables.get(name);
        case VIEW:
            return views.get(name);
        default:
            return null;
        }
    }

    @Override
    public void addChild(IStatement st) {
        DbObjType type = st.getStatementType();
        switch (type) {
        case AGGREGATE:
        case FUNCTION:
        case PROCEDURE:
            addFunction((AbstractFunction) st);
            break;
        case SEQUENCE:
            addSequence((AbstractSequence) st);
            break;
        case TABLE:
            addTable((AbstractTable) st);
            break;
        case TYPE:
            addType((AbstractType) st);
            break;
        case VIEW:
            addView((AbstractView) st);
            break;
        default:
            throw new IllegalArgumentException("Unsupported child type: " + type);
        }
    }

    /**
     * Finds sequence according to specified sequence {@code name}.
     *
     * @param name name of the sequence to be searched
     *
     * @return found sequence or null if no such sequence has been found
     */
    public AbstractSequence getSequence(final String name) {
        return sequences.get(name);
    }


    /**
     * Getter for {@link #sequences}. The list cannot be modified.
     *
     * @return {@link #sequences}
     */
    public Collection<AbstractSequence> getSequences() {
        return Collections.unmodifiableCollection(sequences.values());
    }


    /**
     * Finds table according to specified table {@code name}.
     *
     * @param name name of the table to be searched
     *
     * @return found table or null if no such table has been found
     */
    public AbstractTable getTable(final String name) {
        return tables.get(name);
    }

    /**
     * Getter for {@link #tables}. The list cannot be modified.
     *
     * @return {@link #tables}
     */
    public Collection<AbstractTable> getTables() {
        return Collections.unmodifiableCollection(tables.values());
    }

    /**
     * Finds view according to specified view {@code name}.
     *
     * @param name name of the view to be searched
     *
     * @return found view or null if no such view has been found
     */
    public AbstractView getView(final String name) {
        return views.get(name);
    }

    /**
     * Getter for {@link #views}. The list cannot be modified.
     *
     * @return {@link #views}
     */
    public Collection<AbstractView> getViews() {
        return Collections.unmodifiableCollection(views.values());
    }

    /**
     * @return child-containing element with matching name (either TABLE or VIEW)
     */
    public PgStatementContainer getStatementContainer(String name) {
        PgStatementContainer container = tables.get(name);
        return container == null ? views.get(name) : container;
    }

    public Stream<PgStatementContainer> getStatementContainers() {
        return Stream.concat(tables.values().stream(), views.values().stream());
    }

    public AbstractIndex getIndexByName(String indexName) {
        return getStatementContainers()
                .flatMap(c -> c.getIndexes().stream())
                .filter(s -> s.getName().equals(indexName))
                .findAny().orElse(null);
    }

    public AbstractConstraint getConstraintByName(String constraintName) {
        return getStatementContainers()
                .flatMap(c -> c.getConstraints().stream())
                .filter(s -> s.getName().equals(constraintName))
                .findAny().orElse(null);
    }

    /**
     * Finds type according to specified type {@code name}.
     *
     * @param name name of the type to be searched
     *
     * @return found type or null if no such type has been found
     */
    public AbstractType getType(final String name) {
        return types.get(name);
    }

    public void addFunction(final AbstractFunction function) {
        addUnique(functions, function);
    }

    public void addSequence(final AbstractSequence sequence) {
        addUnique(sequences, sequence);
    }

    public void addTable(final AbstractTable table) {
        addUnique(tables, table);
    }

    public void addView(final AbstractView view) {
        addUnique(views, view);
    }

    public void addType(final AbstractType type) {
        // replace shell type by real type
        AbstractType oldType = types.get(type.name);
        if (oldType instanceof PgShellType && !(type instanceof PgShellType)) {
            types.remove(type.name);
            oldType.setParent(null);
        }
        addUnique(types, type);
    }

    @Override
    public boolean compare(PgStatement obj) {
        return this == obj || obj instanceof AbstractSchema && super.compare(obj);
    }

    @Override
    public boolean compareChildren(PgStatement obj) {
        if (obj instanceof AbstractSchema schema) {
            return sequences.equals(schema.sequences)
                    && functions.equals(schema.functions)
                    && views.equals(schema.views)
                    && tables.equals(schema.tables)
                    && types.equals(schema.types);
        }
        return false;
    }

    @Override
    public void computeHash(Hasher hasher) {
        // all hashable fields in PgStatement
    }

    @Override
    protected void computeChildrenHash(Hasher hasher) {
        hasher.putUnordered(sequences);
        hasher.putUnordered(functions);
        hasher.putUnordered(views);
        hasher.putUnordered(tables);
        hasher.putUnordered(types);
    }

    @Override
    public AbstractSchema shallowCopy() {
        AbstractSchema schemaDst = getSchemaCopy();
        copyBaseFields(schemaDst);
        return schemaDst;
    }

    protected abstract AbstractSchema getSchemaCopy();
}
