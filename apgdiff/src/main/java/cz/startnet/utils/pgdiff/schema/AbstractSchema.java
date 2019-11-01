package cz.startnet.utils.pgdiff.schema;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
    private final List<AbstractType> types = new ArrayList<>();
    private final List<PgFtsParser> parsers = new ArrayList<>();
    private final List<PgFtsTemplate> templates = new ArrayList<>();
    private final List<PgFtsDictionary> dictionaries = new ArrayList<>();
    private final List<PgFtsConfiguration> configurations = new ArrayList<>();
    private final List<PgOperator> operators = new ArrayList<>();

    @Override
    public DbObjType getStatementType() {
        return DbObjType.SCHEMA;
    }

    public AbstractSchema(String name) {
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
    protected void fillDescendantsList(List<List<? extends PgStatement>> l) {
        fillChildrenList(l);
        for (AbstractTable table : tables) {
            table.fillDescendantsList(l);
        }
        for (AbstractView view : views) {
            view.fillDescendantsList(l);
        }
    }

    @Override
    protected void fillChildrenList(List<List<? extends PgStatement>> l) {
        l.add(functions);
        l.add(sequences);
        l.add(types);
        l.add(domains);
        l.add(tables);
        l.add(views);
        l.add(parsers);
        l.add(templates);
        l.add(dictionaries);
        l.add(configurations);
        l.add(operators);
    }

    @Override
    public void addChild(PgStatement st) {
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
     * @return child-containing element with matching name (either TABLE or VIEW)
     */
    public IStatementContainer getStatementContainer(String name) {
        IStatementContainer container = getTable(name);
        return container == null ? getView(name) : container;
    }

    public Stream<IStatementContainer> getStatementContainers() {
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
        for (AbstractType type : types) {
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
    public List<AbstractType> getTypes() {
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

    public void addType(final AbstractType type) {
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

    @Override
    public boolean compare(PgStatement obj) {
        return this == obj || obj instanceof AbstractSchema && super.compare(obj);
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
        // all hashable fields in PgStatement
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
        copyBaseFields(schemaDst);
        return schemaDst;
    }

    protected abstract AbstractSchema getSchemaCopy();
}
