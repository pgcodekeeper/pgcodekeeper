/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff.schema;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.PgDiffUtils;

public class PgIndex extends AbstractIndex {

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

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : options.entrySet()) {
            sb.append(entry.getKey());
            if (!entry.getValue().isEmpty()){
                sb.append("=").append(entry.getValue());
            }
            sb.append(", ");
        }

        if (sb.length() > 0){
            sb.setLength(sb.length() - 2);
            sbSQL.append("\nWITH (").append(sb).append(")");
        }

        if (getTableSpace() != null) {
            sbSQL.append("\nTABLESPACE ").append(getTableSpace());
        }
        if (getWhere() != null) {
            sbSQL.append("\nWHERE ").append(getWhere());
        }
        sbSQL.append(';');
        sbSQL.append(getClusterSQL());

        if (comment != null && !comment.isEmpty()) {
            sbSQL.append("\n\n");
            appendCommentSql(sbSQL);
        }

        return sbSQL.toString();
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
        if (!compareWithoutComments(newIndex)) {
            isNeedDepcies.set(true);
            return true;
        }

        if (isClusterIndex() && !newIndex.isClusterIndex() &&
                !((AbstractTable)newIndex.getParent()).isClustered()) {
            sb.append("\n\nALTER TABLE ")
            .append(PgDiffUtils.getQuotedName(getContainingSchema().getName()))
            .append('.').append(PgDiffUtils.getQuotedName(getTableName()))
            .append(" SET WITHOUT CLUSTER;");
        }

        compareOptions(newIndex, sb);

        if (!Objects.equals(getComment(), newIndex.getComment())) {
            sb.append("\n\n");
            newIndex.appendCommentSql(sb);
        }
        return sb.length() > startLength;
    }

    private String getClusterSQL() {
        final StringBuilder sbSQL = new StringBuilder();
        if (isClusterIndex()) {
            sbSQL.append("\n\nALTER TABLE ");
            sbSQL.append(PgDiffUtils.getQuotedName(getContainingSchema().getName())).append('.');
            sbSQL.append(PgDiffUtils.getQuotedName(getTableName()));
            sbSQL.append(" CLUSTER ON ");
            sbSQL.append(getName());
            sbSQL.append(';');
        }
        return sbSQL.toString();
    }

    @Override
    protected AbstractIndex getIndexCopy() {
        return new PgIndex(getName(), getRawStatement());
    }
}
