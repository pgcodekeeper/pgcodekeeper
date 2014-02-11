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

    /**
     * Value for CACHE or null if no value is specified.
     */
    private String cache;
    /**
     * Value for INCREMENT BY or null if no value is specified.
     */
    private String increment;
    /**
     * Value for MAXVALUE or null if no value is specified.
     */
    private String maxValue;
    /**
     * Value for MINVALUE or null if no value is specified.
     */
    private String minValue;
    /**
     * Name of the sequence.
     */
    private String name;
    /**
     * Value for START WITH or null if no value is specified.
     */
    private String startWith;
    /**
     * True if CYCLE, false if NO CYCLE.
     */
    private boolean cycle;
    /**
     * Column the sequence is owned by.
     */
    private String ownedBy;
    /**
     * Comment.
     */
    private String comment;

    /**
     * Creates a new PgSequence object.
     *
     * @param name name of the sequence
     */
    public PgSequence(final String name, final String rawStatement,
    		final String searchPath) {
    	super(rawStatement, searchPath);
        this.name = name;
    }

    /**
     * Setter for {@link #cache}.
     *
     * @param cache {@link #cache}
     */
    public void setCache(final String cache) {
        this.cache = cache;
    }

    /**
     * Getter for {@link #cache}.
     *
     * @return {@link #cache}
     */
    public String getCache() {
        return cache;
    }

    /**
     * Getter for {@link #comment}.
     *
     * @return {@link #comment}
     */
    public String getComment() {
        return comment;
    }

    /**
     * Setter for {@link #comment}.
     *
     * @param comment {@link #comment}
     */
    public void setComment(final String comment) {
        this.comment = comment;
    }

    /**
     * Creates and returns SQL statement for creation of the sequence.
     *
     * @return created SQL statement
     */
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
     * Creates and returns SQL statement for modification "OWNED BY" parameter.
     *
     * @return created SQL statement
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

    /**
     * Setter for {@link #cycle}.
     *
     * @param cycle {@link #cycle}
     */
    public void setCycle(final boolean cycle) {
        this.cycle = cycle;
    }

    /**
     * Getter for {@link #cycle}.
     *
     * @return {@link #cycle}
     */
    public boolean isCycle() {
        return cycle;
    }

    /**
     * Creates and returns SQL statement for dropping the sequence.
     *
     * @return created SQL
     */
    public String getDropSQL() {
        return "DROP SEQUENCE " + PgDiffUtils.getQuotedName(getName()) + ";";
    }

    /**
     * Setter for {@link #increment}.
     *
     * @param increment {@link #increment}
     */
    public void setIncrement(final String increment) {
        this.increment = increment;
    }

    /**
     * Getter for {@link #increment}.
     *
     * @return {@link #increment}
     */
    public String getIncrement() {
        return increment;
    }

    /**
     * Setter for {@link #maxValue}.
     *
     * @param maxValue {@link #maxValue}
     */
    public void setMaxValue(final String maxValue) {
        this.maxValue = maxValue;
    }

    /**
     * Getter for {@link #maxValue}.
     *
     * @return {@link #maxValue}
     */
    public String getMaxValue() {
        return maxValue;
    }

    /**
     * Setter for {@link #minValue}.
     *
     * @param minValue {@link #minValue}
     */
    public void setMinValue(final String minValue) {
        this.minValue = minValue;
    }

    /**
     * Getter for {@link #minValue}.
     *
     * @return {@link #minValue}
     */
    public String getMinValue() {
        return minValue;
    }

    /**
     * Setter for {@link #name}.
     *
     * @param name {@link #name}
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Getter for {@link #name}.
     *
     * @return {@link #name}
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for {@link #startWith}.
     *
     * @param startWith {@link #startWith}
     */
    public void setStartWith(final String startWith) {
        this.startWith = startWith;
    }

    /**
     * Getter for {@link #startWith}.
     *
     * @return {@link #startWith}
     */
    public String getStartWith() {
        return startWith;
    }

    /**
     * Getter for {@link #ownedBy}.
     *
     * @return {@link #ownedBy}
     */
    public String getOwnedBy() {
        return ownedBy;
    }

    /**
     * Setter for {@link #ownedBy}.
     *
     * @param ownedBy {@link #ownedBy}
     */
    public void setOwnedBy(final String ownedBy) {
        this.ownedBy = ownedBy;
    }
    
    @Override
    public boolean equals(Object obj) {
    	boolean eq = false;
    	
    	if(this == obj) {
    		eq = true;
    	} else if(obj instanceof PgSequence) {
    		final PgSequence seq = (PgSequence) obj;
    		eq = Objects.equals(name, seq.getName())
    				&& Objects.equals(increment, seq.getIncrement())
    				&& Objects.equals(minValue, seq.getMinValue())
    				&& Objects.equals(maxValue, seq.getMaxValue())
    				&& Objects.equals(startWith, seq.getStartWith())
    				&& Objects.equals(cache, seq.getCache())
    				&& cycle == seq.isCycle()
    				&& Objects.equals(ownedBy, seq.getOwnedBy());
    	}
    	
    	return eq;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cache == null) ? 0 : cache.hashCode());
        result = prime * result + (cycle ? 1231 : 1237);
        result = prime * result + ((increment == null) ? 0 : increment.hashCode());
        result = prime * result + ((maxValue == null) ? 0 : maxValue.hashCode());
        result = prime * result + ((minValue == null) ? 0 : minValue.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((ownedBy == null) ? 0 : ownedBy.hashCode());
        result = prime * result + ((startWith == null) ? 0 : startWith.hashCode());
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
        return sequenceDst;
    }
    
    @Override
    public PgSequence deepCopy() {
        return shallowCopy();
    }
}
