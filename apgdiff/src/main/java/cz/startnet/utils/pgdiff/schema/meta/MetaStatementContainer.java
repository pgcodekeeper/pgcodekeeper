package cz.startnet.utils.pgdiff.schema.meta;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import cz.startnet.utils.pgdiff.schema.IStatementContainer;
import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class MetaStatementContainer extends MetaRelation implements IStatementContainer {

    private static final long serialVersionUID = 6047324183451899826L;

    private final transient Map<String, MetaConstraint> constraints = new LinkedHashMap<>();
    private final transient Map<String, MetaStatement> indexes = new LinkedHashMap<>();
    private final transient Map<String, MetaStatement> triggers = new LinkedHashMap<>();
    private final transient Map<String, MetaStatement> rules = new LinkedHashMap<>();
    private final transient Map<String, MetaStatement> policies = new LinkedHashMap<>();

    public MetaStatementContainer(PgObjLocation object) {
        super(object);
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
            constraints.put(st.getName(), (MetaConstraint) st);
            break;
        case POLICY:
            policies.put(st.getName(), st);
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
        case POLICY:
            return policies.get(name);
        default:
            return null;
        }
    }

    @Override
    public Collection<MetaConstraint> getConstraints() {
        return Collections.unmodifiableCollection(constraints.values());
    }

    @Override
    public MetaStatement getCopy() {
        MetaStatementContainer copy = new MetaStatementContainer(getObject());
        copyBaseFields(copy);
        return copy;
    }
}
