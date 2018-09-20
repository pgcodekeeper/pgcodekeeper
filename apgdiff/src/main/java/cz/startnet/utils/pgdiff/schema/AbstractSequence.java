package cz.startnet.utils.pgdiff.schema;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import cz.startnet.utils.pgdiff.hashers.Hasher;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.utils.Pair;

/**
 * Stores sequence information.
 */
public abstract class AbstractSequence extends PgStatementWithSearchPath implements IRelation {

    private static final String BIGINT = "bigint";

    private static final List<Pair<String, String>> relationColumns = Collections
            .unmodifiableList(new ArrayList<>(Arrays.asList(
                    new Pair<>("sequence_name", "name"), new Pair<>("last_value", BIGINT),
                    new Pair<>("start_value", BIGINT), new Pair<>("increment_by", BIGINT),
                    new Pair<>("max_value", BIGINT), new Pair<>("min_value", BIGINT),
                    new Pair<>("cache_value", BIGINT), new Pair<>("log_cnt", BIGINT),
                    new Pair<>("is_cycled", "boolean"), new Pair<>("is_called", "boolean"))));

    private boolean isCached;
    private String cache;
    private String increment;
    private String maxValue;
    private String minValue;
    private String startWith;
    private boolean cycle;
    private String ownedBy;
    private String dataType = BIGINT;
    private String presicion;

    @Override
    public DbObjType getStatementType() {
        return DbObjType.SEQUENCE;
    }

    public AbstractSequence(String name, String rawStatement) {
        super(name, rawStatement);
    }

    public void setCache(final String cache) {
        this.cache = cache;
        resetHash();
    }

    public String getCache() {
        return cache;
    }

    @Override
    public Stream<Pair<String, String>> getRelationColumns() {
        return relationColumns.stream();
    }

    public void setCycle(final boolean cycle) {
        this.cycle = cycle;
        resetHash();
    }

    public boolean isCycle() {
        return cycle;
    }

    public String getPresicion() {
        return presicion;
    }

    public void setPresicion(String presicion) {
        this.presicion = presicion;
        resetHash();
    }

    public void setMinMaxInc(long inc, Long max, Long min, String dataType) {
        String type = dataType != null ? dataType : BIGINT;

        long maxTypeVal;
        long minTypeVal;
        switch(type) {
        case "smallint":
            maxTypeVal = Short.MAX_VALUE;
            minTypeVal = Short.MIN_VALUE;
            break;
        case "integer":
            maxTypeVal = Integer.MAX_VALUE;
            minTypeVal = Integer.MIN_VALUE;
            break;
        case BIGINT:
        default:
            maxTypeVal = Long.MAX_VALUE;
            minTypeVal = Long.MIN_VALUE;
            break;
        }

        this.increment = Long.toString(inc);
        if (max == null || (inc > 0 && max == maxTypeVal) || (inc < 0 && max == -1)) {
            this.maxValue = null;
        } else {
            this.maxValue = "" + max;
        }
        if (min == null || (inc > 0 && min == 1) || (inc < 0 && min == minTypeVal)) {
            this.minValue = null;
        } else {
            this.minValue = "" + min;
        }
    }

    public String getIncrement() {
        return increment;
    }

    public String getMaxValue() {
        return maxValue;
    }

    public String getMinValue() {
        return minValue;
    }

    public void setStartWith(final String startWith) {
        this.startWith = startWith;
        resetHash();
    }

    public String getStartWith() {
        return startWith;
    }

    public void setDataType(final String dataType) {
        this.dataType = dataType;
        resetHash();
    }

    public String getDataType() {
        return dataType;
    }

    public String getOwnedBy() {
        return ownedBy;
    }

    public void setOwnedBy(final String ownedBy) {
        this.ownedBy = ownedBy;
        resetHash();
    }

    public boolean isCached() {
        return isCached;
    }

    public void setCached(boolean isCached) {
        this.isCached = isCached;
        resetHash();
    }

    @Override
    public boolean compare(PgStatement obj) {
        boolean eq = false;

        if(this == obj) {
            eq = true;
        } else if(obj instanceof AbstractSequence) {
            AbstractSequence seq = (AbstractSequence) obj;
            eq = Objects.equals(name, seq.getName())
                    && Objects.equals(increment, seq.getIncrement())
                    && Objects.equals(minValue, seq.getMinValue())
                    && Objects.equals(maxValue, seq.getMaxValue())
                    && Objects.equals(startWith, seq.getStartWith())
                    && Objects.equals(cache, seq.getCache())
                    && cycle == seq.isCycle()
                    && isCached == seq.isCached()
                    && Objects.equals(ownedBy, seq.getOwnedBy())
                    && grants.equals(seq.grants)
                    && revokes.equals(seq.revokes)
                    && Objects.equals(owner, seq.getOwner())
                    && Objects.equals(presicion, seq.getPresicion())
                    && Objects.equals(comment, seq.getComment())
                    && Objects.equals(dataType, seq.getDataType());
        }

        return eq;
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.putOrdered(grants);
        hasher.putOrdered(revokes);
        hasher.put(cache);
        hasher.put(cycle);
        hasher.put(increment);
        hasher.put(maxValue);
        hasher.put(minValue);
        hasher.put(name);
        hasher.put(ownedBy);
        hasher.put(startWith);
        hasher.put(owner);
        hasher.put(comment);
        hasher.put(dataType);
        hasher.put(presicion);
        hasher.put(isCached);
    }

    @Override
    public AbstractSequence shallowCopy() {
        AbstractSequence sequenceDst = getSequenceCopy();
        sequenceDst.setCache(getCache());
        sequenceDst.setCycle(isCycle());
        sequenceDst.increment = getIncrement();
        sequenceDst.maxValue = getMaxValue();
        sequenceDst.minValue = getMinValue();
        sequenceDst.dataType = getDataType();
        sequenceDst.setOwnedBy(getOwnedBy());
        sequenceDst.setCached(isCached());
        sequenceDst.setStartWith(getStartWith());
        sequenceDst.setComment(getComment());
        for (PgPrivilege priv : revokes) {
            sequenceDst.addPrivilege(priv);
        }
        for (PgPrivilege priv : grants) {
            sequenceDst.addPrivilege(priv);
        }
        sequenceDst.setOwner(getOwner());
        sequenceDst.setPresicion(getPresicion());
        sequenceDst.deps.addAll(deps);
        sequenceDst.setLocation(getLocation());
        return sequenceDst;
    }

    protected abstract AbstractSequence getSequenceCopy();

    public abstract void fillSequenceBody(StringBuilder sbSQL);

    @Override
    public AbstractSequence deepCopy() {
        return shallowCopy();
    }

    @Override
    public AbstractSchema getContainingSchema() {
        return (AbstractSchema) getParent();
    }
}
