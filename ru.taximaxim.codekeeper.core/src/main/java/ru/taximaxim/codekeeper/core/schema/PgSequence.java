/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package ru.taximaxim.codekeeper.core.schema;

import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import ru.taximaxim.codekeeper.core.hashers.Hasher;

/**
 * Stores sequence information.
 */
public class PgSequence extends AbstractSequence {

    private GenericColumn ownedBy;
    private boolean isLogged = true;

    public PgSequence(String name) {
        super(name);
        setCache("1");
    }

    @Override
    public String getCreationSQL() {
        final StringBuilder sbSQL = new StringBuilder();
        sbSQL.append("CREATE ");
        if (!isLogged) {
            sbSQL.append("UNLOGGED ");
        }
        sbSQL.append("SEQUENCE ");
        appendIfNotExists(sbSQL);
        sbSQL.append(getQualifiedName());

        if (!BIGINT.equals(getDataType())) {
            sbSQL.append("\n\tAS ").append(getDataType());
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

    @Override
    public void fillSequenceBody(StringBuilder sbSQL) {
        if (getStartWith() != null) {
            sbSQL.append("\n\tSTART WITH ");
            sbSQL.append(getStartWith());
        }

        if (getIncrement() != null) {
            sbSQL.append("\n\tINCREMENT BY ");
            sbSQL.append(getIncrement());
        }

        sbSQL.append("\n\t");

        if (getMaxValue() == null) {
            sbSQL.append("NO MAXVALUE");
        } else {
            sbSQL.append("MAXVALUE ");
            sbSQL.append(getMaxValue());
        }

        sbSQL.append("\n\t");

        if (getMinValue() == null) {
            sbSQL.append("NO MINVALUE");
        } else {
            sbSQL.append("MINVALUE ");
            sbSQL.append(getMinValue());
        }

        if (getCache() != null) {
            sbSQL.append("\n\tCACHE ");
            sbSQL.append(getCache());
        }

        if (isCycle()) {
            sbSQL.append("\n\tCYCLE");
        }
    }

    /**
     * Creates SQL statement for modification "OWNED BY" parameter.
     */
    public String getOwnedBySQL() {
        if (getOwnedBy() == null) {
            return "";
        }
        final StringBuilder sbSQL = new StringBuilder();

        sbSQL.append("\n\nALTER SEQUENCE ").append(getQualifiedName());
        sbSQL.append("\n\tOWNED BY ").append(getOwnedBy().getQualifiedName()).append(';');

        return sbSQL.toString();
    }

    @Override
    public String getFullSQL() {
        StringBuilder sb = new StringBuilder(super.getFullSQL());
        sb.append(getOwnedBySQL());
        return sb.toString();
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        final int startLength = sb.length();
        PgSequence newSequence = (PgSequence) newCondition;
        StringBuilder sbSQL = new StringBuilder();

        if (compareSequenceBody(newSequence, sbSQL)) {
            sb.append("\n\nALTER SEQUENCE ").append(newSequence.getQualifiedName())
            .append(sbSQL).append(';');
        }

        if (!Objects.equals(getOwner(), newSequence.getOwner())) {
            newSequence.alterOwnerSQL(sb);
        }

        if (isLogged != newSequence.isLogged) {
            sb.append("\n\nALTER SEQUENCE ").append(newSequence.getQualifiedName())
            .append(" SET")
            .append(newSequence.isLogged ? " LOGGED" : " UNLOGGED");
            sb.append(';');
        }

        alterPrivileges(newSequence, sb);

        if (!Objects.equals(getComment(), newSequence.getComment())) {
            sb.append("\n\n");
            newSequence.appendCommentSql(sb);
        }

        return sb.length() > startLength;
    }

    private boolean compareSequenceBody(PgSequence newSequence, StringBuilder sbSQL) {
        final String oldType = getDataType();
        final String newType = newSequence.getDataType();

        if (!oldType.equals(newType)) {
            sbSQL.append("\n\tAS ");
            sbSQL.append(newType);
        }

        final String newIncrement = newSequence.getIncrement();
        if (newIncrement != null && !newIncrement.equals(getIncrement())) {
            sbSQL.append("\n\tINCREMENT BY ");
            sbSQL.append(newIncrement);
        }

        final String newMinValue = newSequence.getMinValue();
        if (newMinValue == null && getMinValue() != null) {
            sbSQL.append("\n\tNO MINVALUE");
        } else if (newMinValue != null && !newMinValue.equals(getMinValue())) {
            sbSQL.append("\n\tMINVALUE ");
            sbSQL.append(newMinValue);
        }

        final String newMaxValue = newSequence.getMaxValue();
        if (newMaxValue == null && getMaxValue() != null) {
            sbSQL.append("\n\tNO MAXVALUE");
        } else if (newMaxValue != null && !newMaxValue.equals(getMaxValue())) {
            sbSQL.append("\n\tMAXVALUE ");
            sbSQL.append(newMaxValue);
        }

        final String newStart = newSequence.getStartWith();
        if (newStart != null && !newStart.equals(getStartWith())) {
            sbSQL.append("\n\tSTART WITH ");
            sbSQL.append(newStart);
        }

        final String newCache = newSequence.getCache();
        if (newCache != null && !newCache.equals(getCache())) {
            sbSQL.append("\n\tCACHE ");
            sbSQL.append(newCache);
        }

        final boolean newCycle = newSequence.isCycle();
        if (isCycle() && !newCycle) {
            sbSQL.append("\n\tNO CYCLE");
        } else if (!isCycle() && newCycle) {
            sbSQL.append("\n\tCYCLE");
        }

        final GenericColumn newOwnedBy = newSequence.getOwnedBy();
        if (!Objects.equals(getOwnedBy(), newOwnedBy)) {
            sbSQL.append("\n\tOWNED BY ");
            sbSQL.append(newOwnedBy != null ? newOwnedBy.getQualifiedName() : "NONE");
        }

        return sbSQL.length() > 0;
    }

    @Override
    public void setMinMaxInc(long inc, Long max, Long min, String dataType,
            long precision) {
        String type = dataType != null ? dataType : BIGINT;
        this.increment = Long.toString(inc);
        if (max == null || (inc > 0 && max == getBoundaryTypeVal(type, true, 0L))
                || (inc < 0 && max == -1)) {
            this.maxValue = null;
        } else {
            this.maxValue = "" + max;
        }
        if (min == null || (inc > 0 && min == 1)
                || (inc < 0 && min == getBoundaryTypeVal(type, false, 0L))) {
            this.minValue = null;
        } else {
            this.minValue = "" + min;
        }

        if (getStartWith() == null) {
            if (this.minValue != null) {
                setStartWith(this.minValue);
            } else {
                setStartWith(inc < 0 ? "-1" : "1");
            }
        }
        resetHash();
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (obj instanceof PgSequence && super.compare(obj)) {
            PgSequence seq = (PgSequence) obj;
            return Objects.equals(ownedBy, seq.getOwnedBy())
                    && isLogged == seq.isLogged();
        }

        return false;
    }

    public GenericColumn getOwnedBy() {
        return ownedBy;
    }

    public void setOwnedBy(final GenericColumn ownedBy) {
        this.ownedBy = ownedBy;
        resetHash();
    }

    @Override
    public void setDataType(String dataType) {
        super.setDataType(dataType.toLowerCase(Locale.ROOT));
    }

    public boolean isLogged() {
        return isLogged;
    }

    public void setLogged(boolean isLogged) {
        this.isLogged = isLogged;
        resetHash();
    }

    @Override
    public void computeHash(Hasher hasher) {
        super.computeHash(hasher);
        hasher.put(ownedBy == null ? 0 : ownedBy.hashCode());
        hasher.put(isLogged);
    }

    @Override
    protected AbstractSequence getSequenceCopy() {
        PgSequence sequence = new PgSequence(getName());
        sequence.setOwnedBy(getOwnedBy());
        return sequence;
    }

    @Override
    public AbstractSequence shallowCopy() {
        PgSequence copy = (PgSequence) super.shallowCopy();
        copy.setLogged(isLogged);
        return copy;
    }
}
