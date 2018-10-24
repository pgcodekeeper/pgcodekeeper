/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff.schema;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import cz.startnet.utils.pgdiff.PgDiffUtils;

/**
 * Stores sequence information.
 */
public class PgSequence extends AbstractSequence {

    public PgSequence(String name, String rawStatement) {
        super(name, rawStatement);
    }

    @Override
    public String getCreationSQL() {
        final StringBuilder sbSQL = new StringBuilder();
        sbSQL.append("CREATE SEQUENCE ");
        sbSQL.append(PgDiffUtils.getQuotedName(getContainingSchema().getName())).append('.');
        sbSQL.append(PgDiffUtils.getQuotedName(name));

        if (!"bigint".equals(getDataType())) {
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
        if (getOwnedBy() == null || getOwnedBy().isEmpty()) {
            return "";
        }
        final StringBuilder sbSQL = new StringBuilder();

        sbSQL.append("\n\nALTER SEQUENCE ")
        .append(PgDiffUtils.getQuotedName(getContainingSchema().getName())).append('.')
        .append(PgDiffUtils.getQuotedName(name));
        sbSQL.append("\n\tOWNED BY ").append(getOwnedBy()).append(';');

        return sbSQL.toString();
    }

    @Override
    public String getFullSQL() {
        StringBuilder sb = new StringBuilder(super.getFullSQL());
        sb.append(getOwnedBySQL());
        return sb.toString();
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

        if (compareSequenceBody(newSequence, oldSequence, sbSQL)) {
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

    private boolean compareSequenceBody(AbstractSequence newSequence, AbstractSequence oldSequence, StringBuilder sbSQL) {
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

        return sbSQL.length() > 0;
    }

    @Override
    public void setMinMaxInc(long inc, Long max, Long min, String dataType) {
        String type = dataType != null ? dataType : BIGINT;
        this.increment = Long.toString(inc);
        if (max == null || (inc > 0 && max == getBoundaryTypeVal(type, true))
                || (inc < 0 && max == -1)) {
            this.maxValue = null;
        } else {
            this.maxValue = "" + max;
        }
        if (min == null || (inc > 0 && min == 1)
                || (inc < 0 && min == getBoundaryTypeVal(type, false))) {
            this.minValue = null;
        } else {
            this.minValue = "" + min;
        }
        resetHash();
    }

    @Override
    protected AbstractSequence getSequenceCopy() {
        return new PgSequence(getName(), getRawStatement());
    }
}
