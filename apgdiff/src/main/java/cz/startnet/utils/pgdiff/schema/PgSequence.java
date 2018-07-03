/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff.schema;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Stream;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.utils.Pair;

/**
 * Stores sequence information.
 *
 * @author fordfrog
 */
public class PgSequence extends PgStatementWithSearchPath implements IRelation {

    private static final List<Pair<String, String>> relationColumns = Collections
            .unmodifiableList(new ArrayList<>(Arrays.asList(
                    new Pair<>("sequence_name", "name"), new Pair<>("last_value", "bigint"),
                    new Pair<>("start_value", "bigint"), new Pair<>("increment_by", "bigint"),
                    new Pair<>("max_value", "bigint"), new Pair<>("min_value", "bigint"),
                    new Pair<>("cache_value", "bigint"), new Pair<>("log_cnt", "bigint"),
                    new Pair<>("is_cycled", "boolean"), new Pair<>("is_called", "boolean"))));

    private String cache;
    private String increment;
    private String maxValue;
    private String minValue;
    private String startWith;
    private boolean cycle;
    private String ownedBy;
    private String dataType = "bigint";

    @Override
    public DbObjType getStatementType() {
        return DbObjType.SEQUENCE;
    }

    public PgSequence(String name, String rawStatement) {
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

    @Override
    public String getCreationSQL() {
        final StringBuilder sbSQL = new StringBuilder();
        sbSQL.append("CREATE SEQUENCE ");
        sbSQL.append(PgDiffUtils.getQuotedName(getContainingSchema().getName())).append('.');
        sbSQL.append(PgDiffUtils.getQuotedName(name));

        if (!"bigint".equals(dataType)) {
            sbSQL.append("\n\tAS ").append(dataType);
        }

        fillSequenceBody(sbSQL);

        sbSQL.append(';');

        appendOwnerSQL(sbSQL);
        appendPrivileges(sbSQL);

        if (comment != null && !comment.isEmpty()) {
            sbSQL.append("\n\n");
            appendCommentSql(sbSQL);
        }

        return sbSQL.toString();
    }

    public void fillSequenceBody(StringBuilder sbSQL) {
        if (startWith != null) {
            sbSQL.append("\n\tSTART WITH ");
            sbSQL.append(startWith);
        }

        if (increment != null) {
            sbSQL.append("\n\tINCREMENT BY ");
            sbSQL.append(increment);
        }

        sbSQL.append("\n\t");

        if (maxValue == null) {
            sbSQL.append("NO MAXVALUE");
        } else {
            sbSQL.append("MAXVALUE ");
            sbSQL.append(maxValue);
        }

        sbSQL.append("\n\t");

        if (minValue == null) {
            sbSQL.append("NO MINVALUE");
        } else {
            sbSQL.append("MINVALUE ");
            sbSQL.append(minValue);
        }

        if (cache != null) {
            sbSQL.append("\n\tCACHE ");
            sbSQL.append(cache);
        }

        if (cycle) {
            sbSQL.append("\n\tCYCLE");
        }
    }

    /**
     * Creates SQL statement for modification "OWNED BY" parameter.
     */
    public String getOwnedBySQL() {
        if (ownedBy == null || ownedBy.isEmpty()) {
            return "";
        }
        final StringBuilder sbSQL = new StringBuilder();

        sbSQL.append("\n\nALTER SEQUENCE ")
        .append(PgDiffUtils.getQuotedName(getContainingSchema().getName())).append('.')
        .append(PgDiffUtils.getQuotedName(name));
        sbSQL.append("\n\tOWNED BY ")
        .append(ownedBy).append(';');

        return sbSQL.toString();
    }

    @Override
    public String getFullSQL() {
        StringBuilder sb = new StringBuilder(super.getFullSQL());
        sb.append(getOwnedBySQL());
        return sb.toString();
    }

    public void setCycle(final boolean cycle) {
        this.cycle = cycle;
        resetHash();
    }

    public boolean isCycle() {
        return cycle;
    }

    @Override
    public String getDropSQL() {
        return "DROP SEQUENCE " + PgDiffUtils.getQuotedName(getContainingSchema().getName()) + '.'
                + PgDiffUtils.getQuotedName(getName()) + ";";
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        final int startLength = sb.length();
        PgSequence newSequence;
        if (newCondition instanceof PgSequence) {
            newSequence = (PgSequence) newCondition;
        } else {
            return false;
        }
        PgSequence oldSequence = this;
        StringBuilder sbSQL = new StringBuilder();
        sbSQL.setLength(0);

        final String oldType = oldSequence.getDataType();
        final String newType = newSequence.getDataType();

        if (!oldType.equals(newType)) {
            sbSQL.append("\n\tAS ");
            sbSQL.append(newType);
        }

        final String oldIncrement = oldSequence.getIncrement();
        final String newIncrement = newSequence.getIncrement();

        if (newIncrement != null
                && !newIncrement.equals(oldIncrement)) {
            sbSQL.append("\n\tINCREMENT BY ");
            sbSQL.append(newIncrement);
        }

        final String oldMinValue = oldSequence.getMinValue();
        final String newMinValue = newSequence.getMinValue();

        if (newMinValue == null && oldMinValue != null) {
            sbSQL.append("\n\tNO MINVALUE");
        } else if (newMinValue != null
                && !newMinValue.equals(oldMinValue)) {
            sbSQL.append("\n\tMINVALUE ");
            sbSQL.append(newMinValue);
        }

        final String oldMaxValue = oldSequence.getMaxValue();
        final String newMaxValue = newSequence.getMaxValue();

        if (newMaxValue == null && oldMaxValue != null) {
            sbSQL.append("\n\tNO MAXVALUE");
        } else if (newMaxValue != null
                && !newMaxValue.equals(oldMaxValue)) {
            sbSQL.append("\n\tMAXVALUE ");
            sbSQL.append(newMaxValue);
        }

        final String oldStart = oldSequence.getStartWith();
        final String newStart = newSequence.getStartWith();

        if (newStart != null && !newStart.equals(oldStart)) {
            sbSQL.append("\n\tRESTART WITH ");
            sbSQL.append(newStart);
        }

        final String oldCache = oldSequence.getCache();
        final String newCache = newSequence.getCache();

        if (newCache != null && !newCache.equals(oldCache)) {
            sbSQL.append("\n\tCACHE ");
            sbSQL.append(newCache);
        }

        final boolean oldCycle = oldSequence.isCycle();
        final boolean newCycle = newSequence.isCycle();

        if (oldCycle && !newCycle) {
            sbSQL.append("\n\tNO CYCLE");
        } else if (!oldCycle && newCycle) {
            sbSQL.append("\n\tCYCLE");
        }

        if (sbSQL.length() > 0) {
            sb.append("\n\nALTER SEQUENCE "
                    + PgDiffUtils.getQuotedName(getContainingSchema().getName()) + '.'
                    + PgDiffUtils.getQuotedName(newSequence.getName())
                    + sbSQL.toString() + ";");
        }

        if (!Objects.equals(oldSequence.getOwner(), newSequence.getOwner())) {
            sb.append(newSequence.getOwnerSQL());
        }

        alterPrivileges(newSequence, sb);

        if (!Objects.equals(oldSequence.getComment(), newSequence.getComment())) {
            sb.append("\n\n");
            newSequence.appendCommentSql(sb);
        }
        return sb.length() > startLength;
    }

    public void setMinMaxInc(long inc, Long max, Long min) {
        this.increment = Long.toString(inc);
        if (max == null || (inc > 0 && max == Long.MAX_VALUE) || (inc < 0 && max == -1)) {
            this.maxValue = null;
        } else {
            this.maxValue = "" + max;
        }
        if (min == null || (inc > 0 && min == 1) || (inc < 0 && min == -Long.MAX_VALUE)) {
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

    @Override
    public boolean compare(PgStatement obj) {
        boolean eq = false;

        if(this == obj) {
            eq = true;
        } else if(obj instanceof PgSequence) {
            PgSequence seq = (PgSequence) obj;
            eq = Objects.equals(name, seq.getName())
                    && Objects.equals(increment, seq.getIncrement())
                    && Objects.equals(minValue, seq.getMinValue())
                    && Objects.equals(maxValue, seq.getMaxValue())
                    && Objects.equals(startWith, seq.getStartWith())
                    && Objects.equals(cache, seq.getCache())
                    && cycle == seq.isCycle()
                    && Objects.equals(ownedBy, seq.getOwnedBy())
                    && grants.equals(seq.grants)
                    && revokes.equals(seq.revokes)
                    && Objects.equals(owner, seq.getOwner())
                    && Objects.equals(comment, seq.getComment())
                    && Objects.equals(dataType, seq.getDataType());
        }

        return eq;
    }

    @Override
    public int computeHash() {
        final int prime = 31;
        final int itrue = 1231;
        final int ifalse = 1237;
        int result = 1;
        result = prime * result + ((grants == null) ? 0 : grants.hashCode());
        result = prime * result + ((revokes == null) ? 0 : revokes.hashCode());
        result = prime * result + ((cache == null) ? 0 : cache.hashCode());
        result = prime * result + (cycle ? itrue : ifalse);
        result = prime * result + ((increment == null) ? 0 : increment.hashCode());
        result = prime * result + ((maxValue == null) ? 0 : maxValue.hashCode());
        result = prime * result + ((minValue == null) ? 0 : minValue.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((ownedBy == null) ? 0 : ownedBy.hashCode());
        result = prime * result + ((startWith == null) ? 0 : startWith.hashCode());
        result = prime * result + ((owner == null) ? 0 : owner.hashCode());
        result = prime * result + ((comment == null) ? 0 : comment.hashCode());
        result = prime * result + ((dataType == null) ? 0 : dataType.hashCode());
        return result;
    }

    @Override
    public PgSequence shallowCopy() {
        PgSequence sequenceDst = new PgSequence(getName(), getRawStatement());
        sequenceDst.setCache(getCache());
        sequenceDst.setCycle(isCycle());
        sequenceDst.increment = getIncrement();
        sequenceDst.maxValue = getMaxValue();
        sequenceDst.minValue = getMinValue();
        sequenceDst.dataType = getDataType();
        sequenceDst.setOwnedBy(getOwnedBy());
        sequenceDst.setStartWith(getStartWith());
        sequenceDst.setComment(getComment());
        for (PgPrivilege priv : revokes) {
            sequenceDst.addPrivilege(priv.deepCopy());
        }
        for (PgPrivilege priv : grants) {
            sequenceDst.addPrivilege(priv.deepCopy());
        }
        sequenceDst.setOwner(getOwner());
        sequenceDst.deps.addAll(deps);
        return sequenceDst;
    }

    @Override
    public PgSequence deepCopy() {
        return shallowCopy();
    }

    @Override
    public PgSchema getContainingSchema() {
        return (PgSchema)this.getParent();
    }
}
