package cz.startnet.utils.pgdiff.schema.meta;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.IRelation;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.utils.Pair;

public class MetaRelation extends MetaStatement implements IRelation {

    private static final long serialVersionUID = -3160120843161643684L;

    private final Map<String, MetaStatement> constraints = new LinkedHashMap<>();
    private final Map<String, MetaStatement> indexes = new LinkedHashMap<>();
    private final Map<String, MetaStatement> triggers = new LinkedHashMap<>();
    private final Map<String, MetaStatement> rules = new LinkedHashMap<>();

    /**
     * Contains columns names and types
     */
    private final List<Pair<String, String>> columns = new ArrayList<>();

    public MetaRelation(GenericColumn object) {
        super(object);
    }

    public MetaRelation(String schema, String name, DbObjType type) {
        super(new GenericColumn(schema, name, type));
    }

    @Override
    public void addChild(MetaStatement st) {
        st.setParent(this);
        DbObjType type = st.getStatementType();
        switch (type) {
        case INDEX:
            indexes.put(st.getName(), st);
            break;
        case TRIGGER:
            triggers.put(st.getName(), st);
            break;
        case RULE:
            rules.put(st.getName(), st);
            break;
        case CONSTRAINT:
            constraints.put(st.getName(), st);
            break;
        default:
            throw new IllegalArgumentException("Unsupported child type: " + type);
        }
    }

    @Override
    public MetaStatement getChild(String name, DbObjType type) {
        switch (type) {
        case INDEX:
            return indexes.get(name);
        case TRIGGER:
            return triggers.get(name);
        case RULE:
            return rules.get(name);
        case CONSTRAINT:
            return constraints.get(name);
        default:
            return null;
        }
    }

    @Override
    public Stream<Pair<String, String>> getRelationColumns() {
        return columns.stream();
    }

    public void addColumn(String name, String type) {
        columns.add(new Pair<>(name, type));
    }

    @Override
    public MetaSchema getContainingSchema() {
        return (MetaSchema) getParent();
    }
}