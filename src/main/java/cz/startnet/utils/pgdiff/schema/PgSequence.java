/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff.schema;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import ru.taximaxim.codekeeper.apgdiff.UnixPrintWriter;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DbObjType;
import cz.startnet.utils.pgdiff.PgDiff;
import cz.startnet.utils.pgdiff.PgDiffScript;
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
    public String getCreationSQL() {
        final StringBuilder sbSQL = new StringBuilder();
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
            sbSQL.append("\n\n");
            appendCommentSql(sbSQL);
        }

        return sbSQL.toString();
    }

    /**
     * Creates SQL statement for modification "OWNED BY" parameter.
     */
    public String getOwnedBySQL() {
        final StringBuilder sbSQL = new StringBuilder();

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
    
    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb, AtomicBoolean isNeedDepcies) {
    	PgSequence newSequence = null;
    	if (newCondition instanceof PgSequence) {
    		newSequence = (PgSequence) newCondition;
    	} else {
    		return false;
    	}
    	PgDiffScript script = new PgDiffScript();
    	PgSequence oldSequence = this;
    	StringBuilder sbSQL = new StringBuilder(); 
        sbSQL.setLength(0);

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
            script.addStatement("ALTER SEQUENCE "
                    + PgDiffUtils.getQuotedName(newSequence.getName())
                    + sbSQL.toString() + ';');
        }
        
        if (!Objects.equals(oldSequence.getOwner(), newSequence.getOwner())) {
            script.addStatement(newSequence.getOwnerSQL());
        }
        
        if (!oldSequence.getPrivileges().equals(newSequence.getPrivileges())) {
            script.addStatement(newSequence.getPrivilegesSQL());
        }

        PgDiff.diffComments(oldSequence, newSequence, script);
        
        final ByteArrayOutputStream diffInput = new ByteArrayOutputStream();
        final PrintWriter writer = new UnixPrintWriter(diffInput, true);
        script.printStatements(writer);
        sb.append(diffInput.toString().trim());
        return false;
    }

    public boolean alterOwnedBy(PgStatement newCondition, StringBuilder sbSQL,
            AtomicBoolean isNeedDepcies) {
        PgSequence newSequence = null;
        if (newCondition instanceof PgSequence) {
            newSequence = (PgSequence) newCondition;
        } else {
            return false;
        }
        PgSequence oldSequence = this;
        final String oldOwnedBy = oldSequence.getOwnedBy();
        final String newOwnedBy = newSequence.getOwnedBy();

        if (newOwnedBy != null && !newOwnedBy.equals(oldOwnedBy)) {
            sbSQL.append("\n\tOWNED BY ");
            sbSQL.append(newOwnedBy);
        }
        return false;
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
        final int itrue = 1231;
        final int ifalse = 1237;
        int result = 1;
        result = prime * result + ((privileges == null) ? 0 : privileges.hashCode());
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
        return result;
    }

    @Override
    public PgSequence shallowCopy() {
        PgSequence sequenceDst = new PgSequence(getName(), getRawStatement());
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
    
    @Override
    public PgSchema getContainerSchema() {
    	return (PgSchema)this.getParent();
    }
}
