package cz.startnet.utils.pgdiff.schema.meta;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import cz.startnet.utils.pgdiff.schema.AbstractConstraint;
import cz.startnet.utils.pgdiff.schema.AbstractIndex;
import cz.startnet.utils.pgdiff.schema.AbstractTrigger;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.IStatementContainer;
import cz.startnet.utils.pgdiff.schema.PgRule;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class MetaStatementContainer extends MetaRelation implements IStatementContainer {

    private static final long serialVersionUID = 6047324183451899826L;

    private final Map<String, MetaConstraint> constraints = new LinkedHashMap<>();
    private final Map<String, MetaStatement> indexes = new LinkedHashMap<>();
    private final Map<String, MetaStatement> triggers = new LinkedHashMap<>();
    private final Map<String, MetaStatement> rules = new LinkedHashMap<>();

    public MetaStatementContainer(GenericColumn object) {
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
    public void addTrigger(AbstractTrigger trigger) {

    }

    @Override
    public AbstractTrigger getTrigger(String name) {
        return null;
    }

    @Override
    public Collection<AbstractTrigger> getTriggers() {
        return null;
    }

    @Override
    public void addRule(PgRule rule) {

    }

    @Override
    public PgRule getRule(String name) {
        return null;
    }

    @Override
    public Collection<PgRule> getRules() {
        return null;
    }

    @Override
    public void addIndex(AbstractIndex index) {

    }

    @Override
    public AbstractIndex getIndex(String name) {
        return null;
    }

    @Override
    public Collection<AbstractIndex> getIndexes() {
        return null;
    }

    @Override
    public void addConstraint(AbstractConstraint constraint) {

    }

    @Override
    public AbstractConstraint getConstraint(String name) {
        return null;
    }

    @Override
    public Collection<MetaConstraint> getConstraints() {
        return Collections.unmodifiableCollection(constraints.values());
    }

}
