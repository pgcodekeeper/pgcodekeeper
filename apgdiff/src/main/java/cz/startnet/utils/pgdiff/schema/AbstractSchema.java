package cz.startnet.utils.pgdiff.schema;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.hashers.Hasher;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;


/**
 * Stores base schema information.
 */
public abstract class AbstractSchema extends PgStatement implements ISchema {

    private final List<PgDomain> domains = new ArrayList<>();
    private final List<AbstractFunction> functions = new ArrayList<>();
    private final List<AbstractSequence> sequences = new ArrayList<>();
    private final List<AbstractTable> tables = new ArrayList<>();
    private final List<AbstractView> views = new ArrayList<>();
    private final List<PgType> types = new ArrayList<>();
    private final List<PgFtsParser> parsers = new ArrayList<>();
    private final List<PgFtsTemplate> templates = new ArrayList<>();
    private final List<PgFtsDictionary> dictionaries = new ArrayList<>();
    private final List<PgFtsConfiguration> configurations = new ArrayList<>();
    private final List<PgOperator> operators = new ArrayList<>();

    private String definition;

    @Override
    public DbObjType getStatementType() {
        return DbObjType.SCHEMA;
    }

    public AbstractSchema(String name, String rawStatement) {
        super(name, rawStatement);
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(final String definition) {
        this.definition = definition;
        resetHash();
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
        for (PgDomain dom : domains) {
            if (name.equals(dom.getName())) {
                return dom;
            }
        }
        return null;
    }

    /**
     * Getter for {@link #domains}. The list cannot be modified.
     *
     * @return {@link #domains}
     */
    public List<PgDomain> getDomains() {
        return Collections.unmodifiableList(domains);
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
        for (AbstractFunction function : functions) {
            if (function.getName().equals(signature)) {
                return function;
            }
        }

        return null;
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
    public List<AbstractFunction> getFunctions() {
        return Collections.unmodifiableList(functions);
    }

    @Override
    public Stream<IRelation> getRelations() {
        return Stream.concat(Stream.concat(getTables().stream(), getViews().stream()),
                getSequences().stream());
    }

    @Override
    public Stream<PgStatement> getDescendants() {
        Stream<PgStatement> stream = getChildren();

        for (AbstractTable tab : getTables()) {
            stream = Stream.concat(stream, tab.getDescendants());
        }

        for (AbstractView view : getViews()) {
            stream = Stream.concat(stream, view.getDescendants());
        }

        return stream;
    }

    @Override
    public Stream<PgStatement> getChildren() {
        Stream<PgStatement> stream = Stream.concat(getFunctions().stream(), getSequences().stream());
        stream = Stream.concat(stream, getTypes().stream());
        stream = Stream.concat(stream, getDomains().stream());
        stream = Stream.concat(stream, getTables().stream());
        stream = Stream.concat(stream, getViews().stream());
        stream = Stream.concat(stream, getFtsParsers().stream());
        stream = Stream.concat(stream, getFtsTemplates().stream());
        stream = Stream.concat(stream, getFtsDictionaries().stream());
        stream = Stream.concat(stream, getFtsConfigurations().stream());
        stream = Stream.concat(stream, getOperators().stream());
        return stream;
    }

    /**
     * Finds sequence according to specified sequence {@code name}.
     *
     * @param name name of the sequence to be searched
     *
     * @return found sequence or null if no such sequence has been found
     */
    public AbstractSequence getSequence(final String name) {
        for (AbstractSequence sequence : sequences) {
            if (sequence.getName().equals(name)) {
                return sequence;
            }
        }

        return null;
    }

    /**
     * Getter for {@link #sequences}. The list cannot be modified.
     *
     * @return {@link #sequences}
     */
    public List<AbstractSequence> getSequences() {
        return Collections.unmodifiableList(sequences);
    }

    /**
     * Finds table according to specified table {@code name}.
     *
     * @param name name of the table to be searched
     *
     * @return found table or null if no such table has been found
     */
    public AbstractTable getTable(final String name) {
        for (AbstractTable table : tables) {
            if (table.getName().equals(name)) {
                return table;
            }
        }

        return null;
    }

    /**
     * Getter for {@link #tables}. The list cannot be modified.
     *
     * @return {@link #tables}
     */
    public List<AbstractTable> getTables() {
        return Collections.unmodifiableList(tables);
    }

    /**
     * Finds view according to specified view {@code name}.
     *
     * @param name name of the view to be searched
     *
     * @return found view or null if no such view has been found
     */
    public AbstractView getView(final String name) {
        for (AbstractView view : views) {
            if (view.getName().equals(name)) {
                return view;
            }
        }

        return null;
    }

    /**
     * Getter for {@link #views}. The list cannot be modified.
     *
     * @return {@link #views}
     */
    public List<AbstractView> getViews() {
        return Collections.unmodifiableList(views);
    }

    /**
     * @return rule-containing element with matching name (either TABLE or VIEW)
     */
    public PgRuleContainer getRuleContainer(String name) {
        PgRuleContainer container = getTable(name);
        return container == null ? getView(name) : container;
    }

    /**
     * @return trigger-containing element with matching name (either TABLE or VIEW)
     */
    public PgTriggerContainer getTriggerContainer(String name) {
        PgTriggerContainer container = getTable(name);
        return container == null ? getView(name) : container;
    }

    /**
     * Finds type according to specified type {@code name}.
     *
     * @param name name of the type to be searched
     *
     * @return found type or null if no such type has been found
     */
    public PgType getType(final String name) {
        for (PgType type : types) {
            if (type.getName().equals(name)) {
                return type;
            }
        }
        return null;
    }

    /**
     * Finds parser according to specified dictionary {@code name}.
     *
     * @param name name of the parser to be searched
     *
     * @return found parser or null if no such type has been found
     */
    public PgFtsParser getFtsParser(final String name) {
        for (PgFtsParser parser : parsers) {
            if (parser.getName().equals(name)) {
                return parser;
            }
        }

        return null;
    }

    /**
     * Finds template according to specified dictionary {@code name}.
     *
     * @param name name of the template to be searched
     *
     * @return found template or null if no such type has been found
     */
    public PgFtsTemplate getFtsTemplate(final String name) {
        for (PgFtsTemplate template : templates) {
            if (template.getName().equals(name)) {
                return template;
            }
        }

        return null;
    }

    /**
     * Finds dictionary according to specified dictionary {@code name}.
     *
     * @param name name of the dictionary to be searched
     *
     * @return found dictionary or null if no such type has been found
     */
    public PgFtsDictionary getFtsDictionary(final String name) {
        for (PgFtsDictionary dictionary : dictionaries) {
            if (dictionary.getName().equals(name)) {
                return dictionary;
            }
        }

        return null;
    }

    /**
     * Finds configuration according to specified dictionary {@code name}.
     *
     * @param name name of the configuration to be searched
     *
     * @return found configuration or null if no such type has been found
     */
    public PgFtsConfiguration getFtsConfiguration(final String name) {
        for (PgFtsConfiguration configuration : configurations) {
            if (configuration.getName().equals(name)) {
                return configuration;
            }
        }

        return null;
    }

    /**
     * Finds operator according to specified operator {@code signature}.
     *
     * @param signature signature of the operator to be searched
     *
     * @return found operator or null if no such operator has been found
     */
    public PgOperator getOperator(final String signature) {
        for (PgOperator oper : operators) {
            if (oper.getName().equals(signature)) {
                return oper;
            }
        }

        return null;
    }

    /**
     * Getter for {@link #types}. The list cannot be modified.
     *
     * @return {@link #types}
     */
    public List<PgType> getTypes() {
        return Collections.unmodifiableList(types);
    }

    /**
     * Getter for {@link #parsers}. The list cannot be modified.
     *
     * @return {@link #parsers}
     */
    public List<PgFtsParser> getFtsParsers() {
        return Collections.unmodifiableList(parsers);
    }

    /**
     * Getter for {@link #templates}. The list cannot be modified.
     *
     * @return {@link #templates}
     */
    public List<PgFtsTemplate> getFtsTemplates() {
        return Collections.unmodifiableList(templates);
    }

    /**
     * Getter for {@link #dictionaries}. The list cannot be modified.
     *
     * @return {@link #dictionaries}
     */
    public List<PgFtsDictionary> getFtsDictionaries() {
        return Collections.unmodifiableList(dictionaries);
    }

    /**
     * Getter for {@link #configurations}. The list cannot be modified.
     *
     * @return {@link #configurations}
     */
    public List<PgFtsConfiguration> getFtsConfigurations() {
        return Collections.unmodifiableList(configurations);
    }

    /**
     * Getter for {@link #operators}. The list cannot be modified.
     *
     * @return {@link #operators}
     */
    public List<PgOperator> getOperators() {
        return Collections.unmodifiableList(operators);
    }

    public AbstractTable getTableByIndex(String name) {
        for (AbstractTable t : getTables()) {
            if (t.getIndex(name) != null) {
                return t;
            }
        }
        return null;
    }

    public void addDomain(PgDomain dom) {
        assertUnique(this::getDomain, dom);
        domains.add(dom);
        dom.setParent(this);
        resetHash();
    }

    public void addFunction(final AbstractFunction function) {
        assertUnique(this::getFunction, function);
        functions.add(function);
        function.setParent(this);
        resetHash();
    }

    public void addSequence(final AbstractSequence sequence) {
        assertUnique(this::getSequence, sequence);
        sequences.add(sequence);
        sequence.setParent(this);
        resetHash();
    }

    public void addTable(final AbstractTable table) {
        assertUnique(this::getTable, table);
        tables.add(table);
        table.setParent(this);
        resetHash();
    }

    public void addView(final AbstractView view) {
        assertUnique(this::getView, view);
        views.add(view);
        view.setParent(this);
        resetHash();
    }

    public void addType(final PgType type) {
        assertUnique(this::getType, type);
        types.add(type);
        type.setParent(this);
        resetHash();
    }

    public void addFtsParser(final PgFtsParser parser) {
        assertUnique(this::getFtsParser, parser);
        parsers.add(parser);
        parser.setParent(this);
        resetHash();
    }

    public void addFtsTemplate(final PgFtsTemplate template) {
        assertUnique(this::getFtsTemplate, template);
        templates.add(template);
        template.setParent(this);
        resetHash();
    }

    public void addFtsDictionary(final PgFtsDictionary dictionary) {
        assertUnique(this::getFtsDictionary, dictionary);
        dictionaries.add(dictionary);
        dictionary.setParent(this);
        resetHash();
    }

    public void addFtsConfiguration(final PgFtsConfiguration configuration) {
        assertUnique(this::getFtsConfiguration, configuration);
        configurations.add(configuration);
        configuration.setParent(this);
        resetHash();
    }

    public void addOperator(final PgOperator oper) {
        assertUnique(this::getOperator, oper);
        operators.add(oper);
        oper.setParent(this);
        resetHash();
    }

    public boolean containsSequence(final String name) {
        return getSequence(name) != null;
    }

    public boolean containsTable(final String name) {
        return getTable(name) != null;
    }

    public boolean containsView(final String name) {
        return getView(name) != null;
    }

    public boolean containsType(final String name) {
        return getType(name) != null;
    }

    public boolean containsDomain(final String name) {
        return getDomain(name) != null;
    }

    public boolean containsFtsParser(final String name) {
        return getFtsParser(name) != null;
    }

    public boolean containsFtsTemplate(final String name) {
        return getFtsTemplate(name) != null;
    }

    public boolean containsFtsDictionary(final String name) {
        return getFtsDictionary(name) != null;
    }

    public boolean containsFtsConfiguration(final String name) {
        return getFtsConfiguration(name) != null;
    }

    public boolean containsOperator(final String name) {
        return getOperator(name) != null;
    }

    @Override
    public boolean compare(PgStatement obj) {
        boolean eq = false;

        if(this == obj) {
            eq = true;
        } else if(obj instanceof AbstractSchema) {
            AbstractSchema schema = (AbstractSchema) obj;

            eq = Objects.equals(name, schema.getName())
                    && Objects.equals(definition, schema.getDefinition())
                    && grants.equals(schema.grants)
                    && revokes.equals(schema.revokes)
                    && Objects.equals(owner, schema.getOwner())
                    && Objects.equals(comment, schema.getComment());
        }

        return eq;
    }

    @Override
    public boolean compareChildren(PgStatement obj) {
        if (obj instanceof AbstractSchema) {
            AbstractSchema schema = (AbstractSchema) obj;
            return PgDiffUtils.setlikeEquals(domains, schema.domains)
                    && PgDiffUtils.setlikeEquals(sequences, schema.sequences)
                    && PgDiffUtils.setlikeEquals(functions, schema.functions)
                    && PgDiffUtils.setlikeEquals(views, schema.views)
                    && PgDiffUtils.setlikeEquals(tables, schema.tables)
                    && PgDiffUtils.setlikeEquals(types, schema.types)
                    && PgDiffUtils.setlikeEquals(parsers, schema.parsers)
                    && PgDiffUtils.setlikeEquals(templates, schema.templates)
                    && PgDiffUtils.setlikeEquals(dictionaries, schema.dictionaries)
                    && PgDiffUtils.setlikeEquals(configurations, schema.configurations)
                    && PgDiffUtils.setlikeEquals(operators, schema.operators);
        }
        return false;
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.put(name);
        hasher.put(owner);
        hasher.put(definition);
        hasher.putUnordered(grants);
        hasher.putUnordered(revokes);
        hasher.put(comment);
    }

    @Override
    protected void computeChildrenHash(Hasher hasher) {
        hasher.putUnordered(domains);
        hasher.putUnordered(sequences);
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
        schemaDst.setDefinition(getDefinition());
        schemaDst.setComment(getComment());
        for (PgPrivilege priv : revokes) {
            schemaDst.addPrivilege(priv);
        }
        for (PgPrivilege priv : grants) {
            schemaDst.addPrivilege(priv);
        }
        schemaDst.setOwner(getOwner());
        schemaDst.deps.addAll(deps);
        schemaDst.setLocation(getLocation());
        return schemaDst;
    }

    protected abstract AbstractSchema getSchemaCopy();

    @Override
    public AbstractSchema deepCopy() {
        AbstractSchema copy = shallowCopy();

        for (PgDomain dom : domains) {
            copy.addDomain(dom.deepCopy());
        }
        for (AbstractSequence seq : sequences) {
            copy.addSequence(seq.deepCopy());
        }
        for (AbstractFunction func : functions) {
            copy.addFunction(func.deepCopy());
        }
        for (AbstractView view : views) {
            copy.addView(view.deepCopy());
        }
        for (AbstractTable table : tables) {
            copy.addTable(table.deepCopy());
        }
        for (PgType type : types) {
            copy.addType(type.deepCopy());
        }
        for (PgFtsParser parser : parsers) {
            copy.addFtsParser(parser.deepCopy());
        }
        for (PgFtsTemplate template : templates) {
            copy.addFtsTemplate(template.deepCopy());
        }
        for (PgFtsDictionary dictionary : dictionaries) {
            copy.addFtsDictionary(dictionary.deepCopy());
        }
        for (PgFtsConfiguration configuration : configurations) {
            copy.addFtsConfiguration(configuration.deepCopy());
        }
        for (PgOperator oper : operators) {
            copy.addOperator(oper.deepCopy());
        }
        return copy;
    }
}
