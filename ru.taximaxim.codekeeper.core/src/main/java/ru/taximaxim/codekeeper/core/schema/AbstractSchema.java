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
package ru.taximaxim.codekeeper.core.schema;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.pg.PgCollation;
import ru.taximaxim.codekeeper.core.schema.pg.PgDomain;
import ru.taximaxim.codekeeper.core.schema.pg.PgFtsConfiguration;
import ru.taximaxim.codekeeper.core.schema.pg.PgFtsDictionary;
import ru.taximaxim.codekeeper.core.schema.pg.PgFtsParser;
import ru.taximaxim.codekeeper.core.schema.pg.PgFtsTemplate;
import ru.taximaxim.codekeeper.core.schema.pg.PgOperator;
import ru.taximaxim.codekeeper.core.schema.pg.PgShellType;

/**
 * Stores base schema information.
 */
public abstract class AbstractSchema extends PgStatement implements ISchema {

    private final Map<String, PgDomain> domains = new LinkedHashMap<>();
    private final Map<String, AbstractFunction> functions = new LinkedHashMap<>();
    private final Map<String, AbstractSequence> sequences = new LinkedHashMap<>();
    private final Map<String, AbstractTable> tables = new LinkedHashMap<>();
    private final Map<String, AbstractView> views = new LinkedHashMap<>();
    private final Map<String, AbstractType> types = new LinkedHashMap<>();
    private final Map<String, PgFtsParser> parsers = new LinkedHashMap<>();
    private final Map<String, PgFtsTemplate> templates = new LinkedHashMap<>();
    private final Map<String, PgFtsDictionary> dictionaries = new LinkedHashMap<>();
    private final Map<String, PgFtsConfiguration> configurations = new LinkedHashMap<>();
    private final Map<String, PgOperator> operators = new LinkedHashMap<>();
    private final Map<String, PgCollation> collations = new LinkedHashMap<>();

    @Override
    public DbObjType getStatementType() {
        return DbObjType.SCHEMA;
    }

    protected AbstractSchema(String name) {
        super(name);
    }

    @Override
    public PgDatabase getDatabase() {
        return (PgDatabase)getParent();
    }

    /**
     * Finds domain according to specified domain {@code name}.
     *
     * @param name name of the domain to be searched
     *
     * @return found domain or null if no such domain has been found
     */
    public PgDomain getDomain(String name) {
        return domains.get(name);
    }

    /**
     * Getter for {@link #domains}. The list cannot be modified.
     *
     * @return {@link #domains}
     */
    public Collection<PgDomain> getDomains() {
        return Collections.unmodifiableCollection(domains.values());
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
    public Collection<AbstractFunction> getFunctions() {
        return Collections.unmodifiableCollection(functions.values());
    }

    @Override
    public Stream<IRelation> getRelations() {
        return Stream.concat(Stream.concat(getTables().stream(), getViews().stream()),
                getSequences().stream());
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
        l.add(domains.values());
        l.add(tables.values());
        l.add(views.values());
        l.add(parsers.values());
        l.add(templates.values());
        l.add(dictionaries.values());
        l.add(configurations.values());
        l.add(operators.values());
        l.add(collations.values());
    }

    @Override
    public PgStatement getChild(String name, DbObjType type) {
        switch (type) {
        case FUNCTION:
        case PROCEDURE:
        case AGGREGATE:
            AbstractFunction func = getFunction(name);
            return func != null && func.getStatementType() == type ? func : null;
        case SEQUENCE:
            return getSequence(name);
        case TYPE:
            return getType(name);
        case DOMAIN:
            return getDomain(name);
        case TABLE:
            return getTable(name);
        case VIEW:
            return getView(name);
        case FTS_PARSER:
            return getFtsParser(name);
        case FTS_TEMPLATE:
            return getFtsTemplate(name);
        case FTS_DICTIONARY:
            return getFtsDictionary(name);
        case FTS_CONFIGURATION:
            return getFtsConfiguration(name);
        case OPERATOR:
            return getOperator(name);
        case COLLATION:
            return getCollation(name);
        default:
            return null;
        }
    }

    @Override
    public void addChild(IStatement st) {
        DbObjType type = st.getStatementType();
        switch (type) {
        case DOMAIN:
            addDomain((PgDomain) st);
            break;
        case FTS_CONFIGURATION:
            addFtsConfiguration((PgFtsConfiguration) st);
            break;
        case FTS_DICTIONARY:
            addFtsDictionary((PgFtsDictionary) st);
            break;
        case FTS_PARSER:
            addFtsParser((PgFtsParser) st);
            break;
        case FTS_TEMPLATE:
            addFtsTemplate((PgFtsTemplate) st);
            break;
        case AGGREGATE:
        case FUNCTION:
        case PROCEDURE:
            addFunction((AbstractFunction) st);
            break;
        case OPERATOR:
            addOperator((PgOperator) st);
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
        case COLLATION:
            addCollation((PgCollation) st);
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
     * Finds collation according to specified collation {@code name}.
     *
     * @param name name of the collation to be searched
     *
     * @return found collation or null if no such collations has been found
     */
    public PgCollation getCollation(final String name) {
        return collations.get(name);
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
     * Getter for {@link #collations}. The list cannot be modified.
     *
     * @return {@link #collations}
     */
    public Collection<PgCollation> getCollations() {
        return Collections.unmodifiableCollection(collations.values());
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
        PgStatementContainer container = getTable(name);
        return container == null ? getView(name) : container;
    }

    public Stream<PgStatementContainer> getStatementContainers() {
        return Stream.concat(getTables().stream(), getViews().stream());
    }

    public AbstractIndex getIndexByName(String indexName) {
        return getStatementContainers()
                .flatMap(c -> c.getIndexes().stream())
                .filter(s -> s.getName().equals(indexName))
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

    /**
     * Finds parser according to specified dictionary {@code name}.
     *
     * @param name name of the parser to be searched
     *
     * @return found parser or null if no such type has been found
     */
    public PgFtsParser getFtsParser(final String name) {
        return parsers.get(name);
    }

    /**
     * Finds template according to specified dictionary {@code name}.
     *
     * @param name name of the template to be searched
     *
     * @return found template or null if no such type has been found
     */
    public PgFtsTemplate getFtsTemplate(final String name) {
        return templates.get(name);
    }

    /**
     * Finds dictionary according to specified dictionary {@code name}.
     *
     * @param name name of the dictionary to be searched
     *
     * @return found dictionary or null if no such type has been found
     */
    public PgFtsDictionary getFtsDictionary(final String name) {
        return dictionaries.get(name);
    }

    /**
     * Finds configuration according to specified dictionary {@code name}.
     *
     * @param name name of the configuration to be searched
     *
     * @return found configuration or null if no such type has been found
     */
    public PgFtsConfiguration getFtsConfiguration(final String name) {
        return configurations.get(name);
    }

    /**
     * Finds operator according to specified operator {@code signature}.
     *
     * @param signature signature of the operator to be searched
     *
     * @return found operator or null if no such operator has been found
     */
    @Override
    public PgOperator getOperator(final String signature) {
        return operators.get(signature);
    }

    /**
     * Getter for {@link #types}. The list cannot be modified.
     *
     * @return {@link #types}
     */
    public Collection<AbstractType> getTypes() {
        return Collections.unmodifiableCollection(types.values());
    }

    /**
     * Getter for {@link #parsers}. The list cannot be modified.
     *
     * @return {@link #parsers}
     */
    public Collection<PgFtsParser> getFtsParsers() {
        return Collections.unmodifiableCollection(parsers.values());
    }

    /**
     * Getter for {@link #templates}. The list cannot be modified.
     *
     * @return {@link #templates}
     */
    public Collection<PgFtsTemplate> getFtsTemplates() {
        return Collections.unmodifiableCollection(templates.values());
    }

    /**
     * Getter for {@link #dictionaries}. The list cannot be modified.
     *
     * @return {@link #dictionaries}
     */
    public Collection<PgFtsDictionary> getFtsDictionaries() {
        return Collections.unmodifiableCollection(dictionaries.values());
    }

    /**
     * Getter for {@link #configurations}. The list cannot be modified.
     *
     * @return {@link #configurations}
     */
    public Collection<PgFtsConfiguration> getFtsConfigurations() {
        return Collections.unmodifiableCollection(configurations.values());
    }

    /**
     * Getter for {@link #operators}. The list cannot be modified.
     *
     * @return {@link #operators}
     */
    @Override
    public Collection<PgOperator> getOperators() {
        return Collections.unmodifiableCollection(operators.values());
    }

    public void addDomain(PgDomain dom) {
        addUnique(domains, dom);
    }

    public void addFunction(final AbstractFunction function) {
        addUnique(functions, function);
    }

    public void addSequence(final AbstractSequence sequence) {
        addUnique(sequences, sequence);
    }

    public void addCollation(final PgCollation collation) {
        addUnique(collations, collation);
    }

    public void addTable(final AbstractTable table) {
        addUnique(tables, table);
    }

    public void addView(final AbstractView view) {
        addUnique(views, view);
    }

    public void addType(final AbstractType type) {
        // replace shell type by real type
        AbstractType oldType = types.get(type.getName());
        if (oldType instanceof PgShellType && !(type instanceof PgShellType)) {
            types.remove(type.getName());
            oldType.setParent(null);
        }
        addUnique(types, type);
    }

    public void addFtsParser(final PgFtsParser parser) {
        addUnique(parsers, parser);
    }

    public void addFtsTemplate(final PgFtsTemplate template) {
        addUnique(templates, template);
    }

    public void addFtsDictionary(final PgFtsDictionary dictionary) {
        addUnique(dictionaries, dictionary);
    }

    public void addFtsConfiguration(final PgFtsConfiguration configuration) {
        addUnique(configurations, configuration);
    }

    public void addOperator(final PgOperator oper) {
        addUnique(operators, oper);
    }

    @Override
    public boolean compare(PgStatement obj) {
        return this == obj || obj instanceof AbstractSchema && super.compare(obj);
    }

    @Override
    public boolean compareChildren(PgStatement obj) {
        if (obj instanceof AbstractSchema) {
            AbstractSchema schema = (AbstractSchema) obj;
            return domains.equals(schema.domains)
                    && sequences.equals(schema.sequences)
                    && collations.equals(schema.collations)
                    && functions.equals(schema.functions)
                    && views.equals(schema.views)
                    && tables.equals(schema.tables)
                    && types.equals(schema.types)
                    && parsers.equals(schema.parsers)
                    && templates.equals(schema.templates)
                    && dictionaries.equals(schema.dictionaries)
                    && configurations.equals(schema.configurations)
                    && operators.equals(schema.operators);
        }
        return false;
    }

    @Override
    public void computeHash(Hasher hasher) {
        // all hashable fields in PgStatement
    }

    @Override
    protected void computeChildrenHash(Hasher hasher) {
        hasher.putUnordered(domains);
        hasher.putUnordered(sequences);
        hasher.putUnordered(collations);
        hasher.putUnordered(functions);
        hasher.putUnordered(views);
        hasher.putUnordered(tables);
        hasher.putUnordered(types);
        hasher.putUnordered(parsers);
        hasher.putUnordered(templates);
        hasher.putUnordered(dictionaries);
        hasher.putUnordered(configurations);
        hasher.putUnordered(operators);
    }

    @Override
    public AbstractSchema shallowCopy() {
        AbstractSchema schemaDst = getSchemaCopy();
        copyBaseFields(schemaDst);
        return schemaDst;
    }

    protected abstract AbstractSchema getSchemaCopy();
}
