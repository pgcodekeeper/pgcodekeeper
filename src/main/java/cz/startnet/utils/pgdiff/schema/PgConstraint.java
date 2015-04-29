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
import java.util.regex.Pattern;

import ru.taximaxim.codekeeper.apgdiff.UnixPrintWriter;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import cz.startnet.utils.pgdiff.PgDiff;
import cz.startnet.utils.pgdiff.PgDiffScript;
import cz.startnet.utils.pgdiff.PgDiffUtils;

/**
 * Stores table constraint information.
 *
 * @author fordfrog
 */
public class PgConstraint extends PgStatementWithSearchPath {

    /**
     * Pattern for checking whether the constraint is PRIMARY KEY constraint.
     */
    private static final Pattern PATTERN_PRIMARY_KEY =
            Pattern.compile(".*PRIMARY[\\s]+KEY.*", Pattern.CASE_INSENSITIVE);

    private String definition;
    private String tableName;

    @Override
    public DbObjType getStatementType() {
        return DbObjType.CONSTRAINT;
    }
    
    public PgConstraint(String name, String rawStatement) {
        super(name, rawStatement);
    }

    @Override
    public String getCreationSQL() {
        final StringBuilder sbSQL = new StringBuilder();
        sbSQL.append("ALTER TABLE ");
        sbSQL.append(PgDiffUtils.getQuotedName(getTableName()));
        sbSQL.append("\n\tADD CONSTRAINT ");
        sbSQL.append(PgDiffUtils.getQuotedName(getName()));
        sbSQL.append(' ');
        sbSQL.append(getDefinition());
        sbSQL.append(';');

        if (comment != null && !comment.isEmpty()) {
            sbSQL.append("\n\n");
            appendCommentSql(sbSQL);
        }

        return sbSQL.toString();
    }

    public void setDefinition(final String definition) {
        this.definition = definition;
        resetHash();
    }

    public String getDefinition() {
        return definition;
    }

    @Override
    public String getDropSQL() {
        final StringBuilder sbSQL = new StringBuilder();
        sbSQL.append("ALTER TABLE ");
        sbSQL.append(PgDiffUtils.getQuotedName(getTableName()));
        sbSQL.append("\n\tDROP CONSTRAINT ");
        sbSQL.append(PgDiffUtils.getQuotedName(getName()));
        sbSQL.append(';');

        return sbSQL.toString();
    }
    
    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        final int startLength = sb.length();
        PgConstraint newConstr;
        if (newCondition instanceof PgConstraint) {
            newConstr = (PgConstraint)newCondition; 
        } else {
            return false;
        }
        // TODO alterable state resulting in VALIDATE CONSTRAINT
        PgConstraint oldConstr = this;
        if (!oldConstr.compareWithoutComments(newConstr)) {
            isNeedDepcies.set(true);
            return true;
        }
        PgDiffScript script = new PgDiffScript();
        PgDiff.diffComments(oldConstr, newConstr, script);
        
        final ByteArrayOutputStream diffInput = new ByteArrayOutputStream();
        final PrintWriter writer = new UnixPrintWriter(diffInput, true);
        script.printStatements(writer);
        sb.append(diffInput.toString().trim());
        return sb.length() > startLength;
    }

    public boolean isPrimaryKeyConstraint() {
        return PATTERN_PRIMARY_KEY.matcher(definition).matches();
    }

    public void setTableName(final String tableName) {
        this.tableName = tableName;
        resetHash();
    }

    public String getTableName() {
        return tableName;
    }

    @Override
    public boolean compare(PgStatement obj) {
        boolean eq = false;

        if (this == obj) {
            eq = true;
        } else if (obj instanceof PgConstraint) {
            PgConstraint constraint = (PgConstraint) obj;
            eq = compareWithoutComments(constraint)
                    && Objects.equals(comment, constraint.getComment());
        }

        return eq;
    }

    public boolean compareWithoutComments(PgConstraint constraint) {
        boolean eq;
        eq = Objects.equals(definition, constraint.getDefinition())
                && Objects.equals(name, constraint.getName())
                && Objects.equals(tableName, constraint.getTableName());
        return eq;
    }

    @Override
    public int computeHash() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((definition == null) ? 0 : definition.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((tableName == null) ? 0 : tableName.hashCode());
        result = prime * result + ((comment == null) ? 0 : comment.hashCode());
        return result;
    }
    
    @Override
    public PgConstraint shallowCopy() {
        PgConstraint constraintDst = new PgConstraint(getName(), getRawStatement());
        constraintDst.setDefinition(getDefinition());
        constraintDst.setTableName(getTableName());
        constraintDst.setComment(getComment());
        return constraintDst;
    }
    
    @Override
    public PgConstraint deepCopy() {
        return shallowCopy();
    }
    
    @Override
    public PgSchema getContainingSchema() {
        return (PgSchema)this.getParent().getParent();
    }
}
