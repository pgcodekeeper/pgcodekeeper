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
 * Stores table index information.
 *
 * @author fordfrog
 */
public class PgIndex extends PgStatementWithSearchPath {

    private String definition;
    private String tableName;
    private boolean unique;
    private boolean clusterIndex;

    @Override
    public DbObjType getStatementType() {
        return DbObjType.INDEX;
    }
    
    public PgIndex(String name, String rawStatement) {
        super(name, rawStatement);
    }

    @Override
    public String getCreationSQL() {
        final StringBuilder sbSQL = new StringBuilder();
        sbSQL.append("CREATE ");

        if (isUnique()) {
            sbSQL.append("UNIQUE ");
        }

        sbSQL.append("INDEX ");
        sbSQL.append(PgDiffUtils.getQuotedName(getName()));
        sbSQL.append(" ON ");
        sbSQL.append(PgDiffUtils.getQuotedName(getTableName()));
        sbSQL.append(' ');
        sbSQL.append(getDefinition());
        sbSQL.append(';');
        sbSQL.append(getClusterSQL());

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
    
    public void setClusterIndex(boolean value) {
        clusterIndex = value;
        resetHash();
    }

    public boolean isClusterIndex() {
        return clusterIndex;
    }

    @Override
    public String getDropSQL() {
        return "DROP INDEX " + PgDiffUtils.getQuotedName(getName()) + ";";
    }
    
    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb, AtomicBoolean isNeedDepcies) {
        PgIndex newIndex;
        if (newCondition instanceof PgIndex) {
            newIndex = (PgIndex)newCondition; 
        } else {
            return false;
        }
        PgIndex oldIndex = this;
        PgDiffScript script = new PgDiffScript();
        
        boolean oldCluster = oldIndex.isClusterIndex();
        
        if (oldCluster && !newIndex.isClusterIndex() && 
                !((PgTable)newIndex.getParent()).isClustered()) { 
             script.addStatement("ALTER TABLE "
                        + PgDiffUtils.getQuotedName(oldIndex.getTableName())
                        + " SET WITHOUT CLUSTER;");
        }
        
        PgDiff.diffComments(oldIndex, newIndex, script);
        
        final ByteArrayOutputStream diffInput = new ByteArrayOutputStream();
        final PrintWriter writer = new UnixPrintWriter(diffInput, true);
        script.printStatements(writer);
        sb.append(diffInput.toString().trim());
        return sb.length() > 0;
    }

    private String getClusterSQL() {
        final StringBuilder sbSQL = new StringBuilder();
        if (clusterIndex) {
            sbSQL.append("\n\nALTER TABLE ");
            sbSQL.append(PgDiffUtils.getQuotedName(getTableName()));
            sbSQL.append(" CLUSTER ON ");
            sbSQL.append(getName());
            sbSQL.append(';');
        }
        return sbSQL.toString();
    }
    
    public void setTableName(final String tableName) {
        this.tableName = tableName;
        resetHash();
    }

    public String getTableName() {
        return tableName;
    }

    public boolean isUnique() {
        return unique;
    }

    public void setUnique(final boolean unique) {
        this.unique = unique;
        resetHash();
    }

    @Override
    public boolean compare(PgStatement obj) {
        boolean equals = false;

        if (this == obj) {
            equals = true;
        } else if (obj instanceof PgIndex) {
            PgIndex index = (PgIndex) obj;
            equals = compareWithoutComments(index)
                    && Objects.equals(comment, index.getComment())
                    && Objects.equals(clusterIndex, index.isClusterIndex());
        }

        return equals;
    }

    public boolean compareWithoutComments(PgIndex index) {
        return Objects.equals(definition, index.getDefinition())
                && Objects.equals(name, index.getName())
                && Objects.equals(tableName, index.getTableName())
                && unique == index.isUnique();
    }
    

    @Override
    public int computeHash() {
        final int prime = 31;
        final int itrue = 1231;
        final int ifalse = 1237;
        int result = 1;
        result = prime * result + ((definition == null) ? 0 : definition.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((tableName == null) ? 0 : tableName.hashCode());
        result = prime * result + (unique ? itrue : ifalse);
        result = prime * result + (clusterIndex ? itrue : ifalse);
        result = prime * result + ((comment == null) ? 0 : comment.hashCode());
        return result;
    }
    
    @Override
    public PgIndex shallowCopy() {
        PgIndex indexDst = new PgIndex(getName(), getRawStatement());
        indexDst.setDefinition(getDefinition());
        indexDst.setTableName(getTableName());
        indexDst.setUnique(isUnique());
        indexDst.setClusterIndex(isClusterIndex());
        indexDst.setComment(getComment());
        return indexDst;
    }
    
    @Override
    public PgIndex deepCopy() {
        return shallowCopy();
    }
    
    @Override
    public PgSchema getContainingSchema() {
        return (PgSchema)this.getParent().getParent();
    }
}
