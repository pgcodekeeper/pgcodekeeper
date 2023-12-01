/*******************************************************************************
 * Copyright 2017-2023 TAXTELECOM, LLC
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

import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.pg.PgPolicy;
import ru.taximaxim.codekeeper.core.schema.pg.PgRule;

public abstract class PgStatementContainer extends PgStatementWithSearchPath
implements IRelation {

    private final Map<String, AbstractIndex> indexes = new LinkedHashMap<>();
    private final Map<String, AbstractTrigger> triggers = new LinkedHashMap<>();
    private final Map<String, PgRule> rules = new LinkedHashMap<>();
    private final Map<String, PgPolicy> policies = new LinkedHashMap<>();

    protected PgStatementContainer(String name) {
        super(name);
    }

    @Override
    protected void fillChildrenList(List<Collection<? extends PgStatement>> l) {
        l.add(indexes.values());
        l.add(triggers.values());
        l.add(rules.values());
        l.add(policies.values());
    }

    @Override
    public PgStatement getChild(String name, DbObjType type) {
        switch (type) {
        case INDEX:
            return getIndex(name);
        case TRIGGER:
            return getTrigger(name);
        case RULE:
            return getRule(name);
        case CONSTRAINT:
            return getConstraint(name);
        case POLICY:
            return getPolicy(name);
        default:
            return null;
        }
    }

    @Override
    public void addChild(PgStatement st) {
        DbObjType type = st.getStatementType();
        switch (type) {
        case INDEX:
            addIndex((AbstractIndex) st);
            break;
        case CONSTRAINT:
            addConstraint((AbstractConstraint) st);
            break;
        case TRIGGER:
            addTrigger((AbstractTrigger) st);
            break;
        case RULE:
            addRule((PgRule) st);
            break;
        case POLICY:
            addPolicy((PgPolicy) st);
            break;
        default:
            throw new IllegalArgumentException("Unsupported child type: " + type);
        }
    }

    public final boolean isClustered() {
        for (AbstractIndex ind : getIndexes()) {
            if (ind.isClustered()) {
                return true;
            }
        }

        for (AbstractConstraint constr : getConstraints()) {
            if (constr instanceof IConstraintPk && ((IConstraintPk) constr).isClustered()) {
                return true;
            }
        }

        return false;
    }

    /**
     * Finds constraint according to specified constraint {@code name}.
     *
     * @param name name of the constraint to be searched
     *
     * @return found constraint or null if no such constraint has been found
     */
    public abstract AbstractConstraint getConstraint(final String name);

    /**
     * Finds index according to specified index {@code name}.
     *
     * @param name name of the index to be searched
     *
     * @return found index or null if no such index has been found
     */
    public AbstractIndex getIndex(final String name) {
        return indexes.get(name);
    }

    /**
     * Finds trigger according to specified trigger {@code name}.
     *
     * @param name name of the trigger to be searched
     *
     * @return found trigger or null if no such trigger has been found
     */
    public AbstractTrigger getTrigger(final String name) {
        return triggers.get(name);
    }

    /**
     * Finds rule according to specified rule {@code name}.
     *
     * @param name name of the rule to be searched
     *
     * @return found rule or null if no such rule has been found
     */
    public PgRule getRule(final String name) {
        return rules.get(name);
    }

    /**
     * Finds policy according to specified policy {@code name}.
     *
     * @param name name of the policy to be searched
     *
     * @return found policy or null if no such policy has been found
     */
    public PgPolicy getPolicy(String name) {
        return policies.get(name);
    }

    public abstract Collection<AbstractConstraint> getConstraints();

    /**
     * Getter for {@link #indexes}. The list cannot be modified.
     *
     * @return {@link #indexes}
     */
    public Collection<AbstractIndex> getIndexes() {
        return Collections.unmodifiableCollection(indexes.values());
    }

    /**
     * Getter for {@link #triggers}. The list cannot be modified.
     *
     * @return {@link #triggers}
     */
    public Collection<AbstractTrigger> getTriggers() {
        return Collections.unmodifiableCollection(triggers.values());
    }

    /**
     * Getter for {@link #rules}. The list cannot be modified.
     *
     * @return {@link #rules}
     */
    public Collection<PgRule> getRules() {
        return Collections.unmodifiableCollection(rules.values());
    }

    /**
     * Getter for {@link #policies}. The list cannot be modified.
     *
     * @return {@link #policies}
     */
    public Collection<PgPolicy> getPolicies() {
        return Collections.unmodifiableCollection(policies.values());
    }

    public abstract void addConstraint(final AbstractConstraint constraint);

    public void addIndex(final AbstractIndex index) {
        addUnique(indexes, index);
    }

    public void addTrigger(final AbstractTrigger trigger) {
        addUnique(triggers, trigger);
    }

    public void addRule(final PgRule rule) {
        addUnique(rules, rule);
    }

    public void addPolicy(PgPolicy policy) {
        addUnique(policies, policy);
    }

    @Override
    public boolean compareChildren(PgStatement obj) {
        if (obj instanceof PgStatementContainer) {
            PgStatementContainer table = (PgStatementContainer) obj;
            return indexes.equals(table.indexes)
                    && triggers.equals(table.triggers)
                    && rules.equals(table.rules)
                    && policies.equals(table.policies);
        }
        return false;
    }

    @Override
    public void computeChildrenHash(Hasher hasher) {
        hasher.putUnordered(indexes);
        hasher.putUnordered(triggers);
        hasher.putUnordered(rules);
        hasher.putUnordered(policies);
    }

    @Override
    public PgStatementContainer shallowCopy() {
        PgStatementContainer copy = getCopy();
        copyBaseFields(copy);
        return copy;
    }

    protected abstract PgStatementContainer getCopy();

    @Override
    public AbstractSchema getContainingSchema() {
        return (AbstractSchema) this.getParent();
    }
}
