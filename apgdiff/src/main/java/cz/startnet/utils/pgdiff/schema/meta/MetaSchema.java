package cz.startnet.utils.pgdiff.schema.meta;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.ISchema;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class MetaSchema extends MetaStatement implements ISchema {

    private static final long serialVersionUID = -6836132289662805345L;

    private final transient Map<String, MetaRelation> relations = new LinkedHashMap<>();
    private final transient Map<String, MetaFunction> functions = new LinkedHashMap<>();
    private final transient Map<String, MetaStatement> domains = new LinkedHashMap<>();
    private final transient Map<String, MetaStatement> types = new LinkedHashMap<>();
    private final transient Map<String, MetaStatement> parsers = new LinkedHashMap<>();
    private final transient Map<String, MetaStatement> templates = new LinkedHashMap<>();
    private final transient Map<String, MetaStatement> dictionaries = new LinkedHashMap<>();
    private final transient Map<String, MetaStatement> configurations = new LinkedHashMap<>();
    private final transient Map<String, MetaStatement> operators = new LinkedHashMap<>();

    public MetaSchema(GenericColumn object) {
        super(object);
    }

    public MetaSchema(String schema) {
        super(new GenericColumn(schema, DbObjType.SCHEMA));
    }

    @Override
    public MetaStatement getChild(String name, DbObjType type) {
        switch (type) {
        case FUNCTION:
        case PROCEDURE:
        case AGGREGATE:
            return getFunction(name);
        case SEQUENCE:
        case TABLE:
        case VIEW:
            return getRelation(name);
        case TYPE:
            return types.get(name);
        case DOMAIN:
            return domains.get(name);
        case FTS_PARSER:
            return parsers.get(name);
        case FTS_TEMPLATE:
            return templates.get(name);
        case FTS_DICTIONARY:
            return dictionaries.get(name);
        case FTS_CONFIGURATION:
            return configurations.get(name);
        case OPERATOR:
            return operators.get(name);
        default:
            return null;
        }
    }

    @Override
    public void addChild(MetaStatement st) {
        st.setParent(this);
        DbObjType type = st.getStatementType();
        switch (type) {
        case AGGREGATE:
        case FUNCTION:
        case PROCEDURE:
            addFunction((MetaFunction) st);
            break;
        case SEQUENCE:
        case TABLE:
        case VIEW:
            addRelation((MetaRelation) st);
            break;
        case TYPE:
            types.put(st.getName(), st);
            break;
        case OPERATOR:
            operators.put(st.getName(), st);
            break;
        case DOMAIN:
            domains.put(st.getName(), st);
            break;
        case FTS_CONFIGURATION:
            configurations.put(st.getName(), st);
            break;
        case FTS_DICTIONARY:
            dictionaries.put(st.getName(), st);
            break;
        case FTS_PARSER:
            parsers.put(st.getName(), st);
            break;
        case FTS_TEMPLATE:
            templates.put(st.getName(), st);
            break;
        default:
            throw new IllegalArgumentException("Unsupported child type: " + type);
        }
    }

    @Override
    public Stream<MetaRelation> getRelations() {
        return relations.values().stream();
    }

    @Override
    public MetaRelation getRelation(String name) {
        return relations.get(name);
    }

    public void addRelation(final MetaRelation relation) {
        relations.put(relation.getName(), relation);
    }

    @Override
    public Collection<MetaFunction> getFunctions() {
        return Collections.unmodifiableCollection(functions.values());
    }

    @Override
    public MetaFunction getFunction(String signature) {
        return functions.get(signature);
    }

    public void addFunction(final MetaFunction function) {
        functions.put(function.getName(), function);
    }
}
