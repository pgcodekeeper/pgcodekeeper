package cz.startnet.utils.pgdiff.schema;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import cz.startnet.utils.pgdiff.hashers.Hasher;
import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.utils.Pair;

/**
 * Stores sequence information.
 */
public abstract class AbstractSequence extends PgStatementWithSearchPath implements IRelation {

    protected static final String BIGINT = "bigint";

    private static final List<Pair<String, String>> relationColumns = Collections
            .unmodifiableList(new ArrayList<>(Arrays.asList(
                    new Pair<>("sequence_name", "name"), new Pair<>("last_value", BIGINT),
                    new Pair<>("start_value", BIGINT), new Pair<>("increment_by", BIGINT),
                    new Pair<>("max_value", BIGINT), new Pair<>("min_value", BIGINT),
                    new Pair<>("cache_value", BIGINT), new Pair<>("log_cnt", BIGINT),
                    new Pair<>("is_cycled", "boolean"), new Pair<>("is_called", "boolean"))));

    private boolean isCached;
    private String cache;
    protected String increment;
    protected String maxValue;
    protected String minValue;
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

    public abstract void setMinMaxInc(long inc, Long max, Long min, String dataType);

    protected long getBoundaryTypeVal(String type, boolean needMaxVal) {
        switch (type) {
        case "smallint":
            return needMaxVal ? Short.MAX_VALUE : Short.MIN_VALUE;
        case "integer":
            return needMaxVal ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        case "numeric":
        case "decimal":
            // It used for MS SQL.
            long boundaryTypeVal = (long) (Math.pow(10, Long.parseLong(presicion))) - 1;
            return needMaxVal ? boundaryTypeVal : - boundaryTypeVal;
        default:
            Log.log(Log.LOG_WARNING, "Unsupported sequence type: " + type);
            // $FALL-THROUGH$
        case BIGINT:
            return needMaxVal ? Long.MAX_VALUE : Long.MIN_VALUE;
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
