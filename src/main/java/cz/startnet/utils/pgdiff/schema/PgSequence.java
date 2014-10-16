/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff.schema;

import java.util.Objects;

import cz.startnet.utils.pgdiff.PgDiffUtils;

/**
 * Stores sequence information.
 *
 * @author fordfrog
 */
public class PgSequence extends PgStatementWithSearchPath {

    private String cache;
    private String increment;
    private String maxValue;
    private String minValue;
    private String startWith;
    private boolean cycle;
    private String ownedBy;
    private String comment;

    public PgSequence(String name, String rawStatement, String searchPath) {
        super(name, rawStatement, searchPath);
    }

    public void setCache(final String cache) {
        this.cache = cache;
        resetHash();
    }

    public String getCache() {
        return cache;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(final String comment) {
        this.comment = comment;
    }

    @Override
    public String getCreationSQL() {
        final StringBuilder sbSQL = new StringBuilder(100);
        sbSQL.append("CREATE SEQUENCE ");
        sbSQL.append(PgDiffUtils.getQuotedName(name));

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

        sbSQL.append(';');

        appendOwnerSQL(sbSQL);
        appendPrivileges(sbSQL);

        if (comment != null && !comment.isEmpty()) {
            sbSQL.append("\n\nCOMMENT ON SEQUENCE ");
            sbSQL.append(PgDiffUtils.getQuotedName(name));
            sbSQL.append(" IS ");
            sbSQL.append(comment);
            sbSQL.append(';');
        }

        return sbSQL.toString();
    }

    /**
     * Creates SQL statement for modification "OWNED BY" parameter.
     */
    public String getOwnedBySQL() {
        final StringBuilder sbSQL = new StringBuilder(100);

        sbSQL.append("ALTER SEQUENCE ");
        sbSQL.append(PgDiffUtils.getQuotedName(name));

        if (ownedBy != null && !ownedBy.isEmpty()) {
            sbSQL.append("\n\tOWNED BY ");
            sbSQL.append(ownedBy);
        }

        sbSQL.append(';');

        return sbSQL.toString();
    }
    
    @Override
    public String getFullSQL() {
        String superFull = super.getFullSQL();
        
        if (ownedBy != null && !ownedBy.isEmpty()) {
            StringBuilder sb = new StringBuilder(superFull);
            sb.append("\n\n").append(getOwnedBySQL());
            return sb.toString();
        } else {
            return superFull;
        }
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
        return "DROP SEQUENCE " + PgDiffUtils.getQuotedName(getName()) + ";";
    }

    public void setIncrement(final String increment) {
        this.increment = increment;
        resetHash();
    }

    public String getIncrement() {
        return increment;
    }

    public void setMaxValue(final String maxValue) {
        this.maxValue = maxValue;
        resetHash();
    }

    public String getMaxValue() {
        return maxValue;
    }

    public void setMinValue(final String minValue) {
        this.minValue = minValue;
        resetHash();
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
                    && privileges.equals(seq.privileges)
                    && Objects.equals(owner, seq.getOwner())
                    && Objects.equals(comment, seq.getComment());
        }
        
        return eq;
    }

    @Override
    public int computeHash() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((privileges == null) ? 0 : privileges.hashCode());
        result = prime * result + ((cache == null) ? 0 : cache.hashCode());
        result = prime * result + (cycle ? 1231 : 1237);
        result = prime * result + ((increment == null) ? 0 : increment.hashCode());
        result = prime * result + ((maxValue == null) ? 0 : maxValue.hashCode());
        result = prime * result + ((minValue == null) ? 0 : minValue.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((ownedBy == null) ? 0 : ownedBy.hashCode());
        result = prime * result + ((startWith == null) ? 0 : startWith.hashCode());
        result = prime * result + ((owner == null) ? 0 : owner.hashCode());
        result = prime * result + ((comment == null) ? 0 : comment.hashCode());
        return result;
    }

    @Override
    public PgSequence shallowCopy() {
        PgSequence sequenceDst = new PgSequence(getName(), getRawStatement(), getSearchPath());
        sequenceDst.setCache(getCache());
        sequenceDst.setCycle(isCycle());
        sequenceDst.setIncrement(getIncrement());
        sequenceDst.setMaxValue(getMaxValue());
        sequenceDst.setMinValue(getMinValue());
        sequenceDst.setOwnedBy(getOwnedBy());
        sequenceDst.setStartWith(getStartWith());
        sequenceDst.setComment(getComment());
        for (PgPrivilege priv : privileges) {
            sequenceDst.addPrivilege(priv.shallowCopy());
        }
        sequenceDst.setOwner(getOwner());
        return sequenceDst;
    }
    
    @Override
    public PgSequence deepCopy() {
        return shallowCopy();
    }
}
