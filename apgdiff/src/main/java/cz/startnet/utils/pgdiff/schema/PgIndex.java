/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff.schema;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.hashers.Hasher;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

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
    private final Set<String> columns = new HashSet<>();

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
        PgDiffArguments args = getDatabase().getArguments();
        if (args != null && args.isConcurrentlyMode()) {
            sbSQL.append("CONCURRENTLY ");
        }
        sbSQL.append(PgDiffUtils.getQuotedName(getName()));
        sbSQL.append(" ON ");
        sbSQL.append(PgDiffUtils.getQuotedName(getContainingSchema().getName())).append('.');
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

    public void addColumn(String column) {
        columns.add(column);
    }

    public Set<String> getColumns(){
        return Collections.unmodifiableSet(columns);
    }

    @Override
    public String getDropSQL() {
        return "DROP INDEX " + PgDiffUtils.getQuotedName(getContainingSchema().getName()) + '.'
                + PgDiffUtils.getQuotedName(getName()) + ";";
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        final int startLength = sb.length();
        PgIndex newIndex;
        if (newCondition instanceof PgIndex) {
            newIndex = (PgIndex)newCondition;
        } else {
            return false;
        }
        PgIndex oldIndex = this;
        if (!oldIndex.compareWithoutComments(newIndex)) {
            isNeedDepcies.set(true);
            return true;
        }

        if (oldIndex.isClusterIndex() && !newIndex.isClusterIndex() &&
                !((PgTable)newIndex.getParent()).isClustered()) {
            sb.append("\n\nALTER TABLE "
                    + PgDiffUtils.getQuotedName(oldIndex.getContainingSchema().getName()) + '.'
                    + PgDiffUtils.getQuotedName(oldIndex.getTableName())
                    + " SET WITHOUT CLUSTER;");
        }

        if (!Objects.equals(oldIndex.getComment(), newIndex.getComment())) {
            sb.append("\n\n");
            newIndex.appendCommentSql(sb);
        }
        return sb.length() > startLength;
    }

    private String getClusterSQL() {
        final StringBuilder sbSQL = new StringBuilder();
        if (clusterIndex) {
            sbSQL.append("\n\nALTER TABLE ");
            sbSQL.append(PgDiffUtils.getQuotedName(getContainingSchema().getName())).append('.');
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

    protected boolean compareWithoutComments(PgIndex index) {
        return Objects.equals(definition, index.getDefinition())
                && Objects.equals(name, index.getName())
                && Objects.equals(tableName, index.getTableName())
                && unique == index.isUnique();
    }


    @Override
    public void computeHash(Hasher hasher) {
        hasher.put(definition);
        hasher.put(name);
        hasher.put(tableName);
        hasher.put(unique);
        hasher.put(clusterIndex);
        hasher.put(comment);
    }

    @Override
    public PgIndex shallowCopy() {
        PgIndex indexDst = new PgIndex(getName(), getRawStatement());
        indexDst.setDefinition(getDefinition());
        indexDst.setTableName(getTableName());
        indexDst.setUnique(isUnique());
        indexDst.setClusterIndex(isClusterIndex());
        indexDst.setComment(getComment());
        indexDst.deps.addAll(deps);
        indexDst.columns.addAll(columns);
        return indexDst;
    }

    @Override
    public PgIndex deepCopy() {
        return shallowCopy();
    }

    @Override
    public AbstractSchema getContainingSchema() {
        return (AbstractSchema)this.getParent().getParent();
    }
}
