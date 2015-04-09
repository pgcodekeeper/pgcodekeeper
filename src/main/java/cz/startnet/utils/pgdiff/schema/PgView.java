/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff.schema;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import ru.taximaxim.codekeeper.apgdiff.UnixPrintWriter;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DbObjType;
import cz.startnet.utils.pgdiff.PgDiff;
import cz.startnet.utils.pgdiff.PgDiffScript;
import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.PgDiffViews;

/**
 * Stores view information.
 *
 * @author fordfrog
 */
public class PgView extends PgStatementWithSearchPath {

    private String query;
    private String normalizedQuery;
    private PgSelect select;
    private List<String> columnNames = new ArrayList<>();
    private final List<DefaultValue> defaultValues = new ArrayList<>();
    private final List<ColumnComment> columnComments = new ArrayList<>();

    @Override
    public DbObjType getStatementType() {
        return DbObjType.VIEW;
    }
    
    public PgView(String name, String rawStatement) {
        super(name, rawStatement);
    }

    public void addColumnName(String colName) {
        columnNames.add(colName);
        resetHash();
    }
    
    public void setColumnNames(final List<String> columnNames) {
        this.columnNames = columnNames;
        resetHash();
    }

    /**
     * Getter for {@link #columnNames}. The list cannot be modified.
     *
     * @return {@link #columnNames}
     */
    public List<String> getColumnNames() {
        return Collections.unmodifiableList(columnNames);
    }

    @Override
    public String getCreationSQL() {
        final StringBuilder sbSQL = new StringBuilder(query.length() * 2);
        sbSQL.append("CREATE VIEW ");
        sbSQL.append(PgDiffUtils.getQuotedName(name));

        if (columnNames != null && !columnNames.isEmpty()) {
            sbSQL.append(" (");

            for (int i = 0; i < columnNames.size(); i++) {
                if (i > 0) {
                    sbSQL.append(", ");
                }

                sbSQL.append(PgDiffUtils.getQuotedName(columnNames.get(i)));
            }
            sbSQL.append(')');
        }

        sbSQL.append(" AS\n\t");
        sbSQL.append(query);
        sbSQL.append(';');

        appendOwnerSQL(sbSQL);
        appendPrivileges(sbSQL);

        for (final DefaultValue defaultValue : defaultValues) {
            sbSQL.append("\n\nALTER VIEW ");
            sbSQL.append(PgDiffUtils.getQuotedName(name));
            sbSQL.append(" ALTER COLUMN ");
            sbSQL.append(
                    PgDiffUtils.getQuotedName(defaultValue.getColumnName()));
            sbSQL.append(" SET DEFAULT ");
            sbSQL.append(defaultValue.getDefaultValue());
            sbSQL.append(';');
        }

        if (comment != null && !comment.isEmpty()) {
            sbSQL.append("\n\n");
            appendCommentSql(sbSQL);
        }

        for (final ColumnComment columnComment : columnComments) {
            if (columnComment.getComment() != null
                    && !columnComment.getComment().isEmpty()) {
                sbSQL.append("\n\nCOMMENT ON COLUMN ");
                sbSQL.append(PgDiffUtils.getQuotedName(name));
                sbSQL.append('.');
                sbSQL.append(PgDiffUtils.getQuotedName(columnComment.getColumnName()));
                sbSQL.append(" IS ");
                sbSQL.append(columnComment.getComment());
                sbSQL.append(';');
            }
        }

        return sbSQL.toString();
    }
    
    @Override
    public String getDropSQL() {
        return "DROP VIEW " + PgDiffUtils.getQuotedName(getName()) + ';';
    }
    
    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        final int startLength = sb.length();
        PgView newView;
        if (newCondition instanceof PgView) {
            newView = (PgView) newCondition;
        } else {
            return false;
        }
        PgView oldView = this;
        PgDiffScript script = new PgDiffScript();
        if (PgDiffViews.isViewModified(oldView, newView)) {
            isNeedDepcies.set(true);
            return true;
        }
        PgDiffViews.diffDefaultValues(script, oldView, newView);

        if (!Objects.equals(oldView.getOwner(), newView.getOwner())) {
            script.addStatement(newView.getOwnerSQL());
        }

        if (!oldView.getGrants().equals(newView.getGrants())
                || !oldView.getRevokes().equals(newView.getRevokes())) {
            script.addStatement(newView.getPrivilegesSQL());
        }

        PgDiff.diffComments(oldView, newView, script);

        final List<String> columnNames = new ArrayList<>(newView
                .getColumnComments().size());

        for (final PgView.ColumnComment columnComment : newView
                .getColumnComments()) {
            columnNames.add(columnComment.getColumnName());
        }

        for (final PgView.ColumnComment columnComment : oldView
                .getColumnComments()) {
            if (!columnNames.contains(columnComment.getColumnName())) {
                columnNames.add(columnComment.getColumnName());
            }
        }

        for (final String columnName : columnNames) {
            PgView.ColumnComment oldColumnComment = null;
            PgView.ColumnComment newColumnComment = null;

            for (final PgView.ColumnComment columnComment : oldView
                    .getColumnComments()) {
                if (columnName.equals(columnComment.getColumnName())) {
                    oldColumnComment = columnComment;
                    break;
                }
            }

            for (final PgView.ColumnComment columnComment : newView
                    .getColumnComments()) {
                if (columnName.equals(columnComment.getColumnName())) {
                    newColumnComment = columnComment;
                    break;
                }
            }

            if (oldColumnComment == null
                    && newColumnComment != null
                    || oldColumnComment != null
                    && newColumnComment != null
                    && !oldColumnComment.getComment().equals(
                            newColumnComment.getComment())) {

                script.addStatement("COMMENT ON COLUMN "
                        + PgDiffUtils.getQuotedName(newView.getName())
                        + '.'
                        + PgDiffUtils.getQuotedName(newColumnComment
                                .getColumnName()) + " IS "
                        + newColumnComment.getComment() + ';');
            } else if (oldColumnComment != null && newColumnComment == null) {

                script.addStatement("COMMENT ON COLUMN "
                        + PgDiffUtils.getQuotedName(newView.getName())
                        + '.'
                        + PgDiffUtils.getQuotedName(oldColumnComment
                                .getColumnName()) + " IS NULL;");
            }
        }
        final ByteArrayOutputStream diffInput = new ByteArrayOutputStream();
        final PrintWriter writer = new UnixPrintWriter(diffInput, true);
        script.printStatements(writer);
        sb.append(diffInput.toString().trim());
        return sb.length() > startLength;
    }

    public void setQuery(final String query) {
        this.query = query;
        this.normalizedQuery = PgDiffUtils.normalizeWhitespaceUnquoted(query);
        resetHash();
    }

    public String getQuery() {
        return query;
    }

    /**
     * @return query string with whitespace normalized.
     * @see PgDiffUtils#normalizeWhitespaceUnquoted(String)
     */
    public String getNormalizedQuery(){
        return normalizedQuery;
    }
    
    public void setSelect(PgSelect select) {
        this.select = select;
        select.setParent(this);
        resetHash();
    }
    
    public PgSelect getSelect() {
        return select;
    }

    /**
     * Adds/replaces column default value specification.
     */
    public void addColumnDefaultValue(final String columnName,
            final String defaultValue) {
        removeColumnDefaultValue(columnName);
        defaultValues.add(new DefaultValue(columnName, defaultValue));
        resetHash();
    }

    public void removeColumnDefaultValue(final String columnName) {
        for (final DefaultValue item : defaultValues) {
            if (item.getColumnName().equals(columnName)) {
                defaultValues.remove(item);
                resetHash();
                return;
            }
        }
    }

    /**
     * Getter for {@link #defaultValues}.
     *
     * @return {@link #defaultValues}
     */
    public List<DefaultValue> getDefaultValues() {
        return Collections.unmodifiableList(defaultValues);
    }

    /**
     * Adds/replaces column comment.
     */
    public void addColumnComment(final String columnName,
            final String comment) {
        removeColumnDefaultValue(columnName);
        columnComments.add(new ColumnComment(columnName, comment));
    }

    public void removeColumnComment(final String columnName) {
        for (final ColumnComment item : columnComments) {
            if (item.getColumnName().equals(columnName)) {
                columnComments.remove(item);
                return;
            }
        }
    }

    public List<ColumnComment> getColumnComments() {
        return Collections.unmodifiableList(columnComments);
    }

    @Override
    public boolean compare(PgStatement obj) {
        boolean eq = false;
        
        if(this == obj) {
            eq = true;
        } else if(obj instanceof PgView) {
            PgView view = (PgView) obj;
            eq = Objects.equals(name, view.getName())
                    && Objects.equals(normalizedQuery, view.getNormalizedQuery())
                    && Objects.equals(select, view.getSelect())
                    && columnNames.equals(view.columnNames)
                    && new HashSet<>(defaultValues).equals(new HashSet<>(view.defaultValues))
                    && grants.equals(view.grants)
                    && revokes.equals(view.revokes)
                    && Objects.equals(owner, view.getOwner())
                    && Objects.equals(comment, view.getComment())
                    && Objects.equals(columnComments, view.getColumnComments());
        }
        
        return eq;
    }

    @Override
    public int computeHash() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((grants == null) ? 0 : grants.hashCode());
        result = prime * result + ((revokes == null) ? 0 : revokes.hashCode());
        result = prime * result + ((columnNames == null) ? 0 : columnNames.hashCode());
        result = prime * result + new HashSet<>(defaultValues).hashCode();
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((normalizedQuery == null) ? 0 : normalizedQuery.hashCode());
        result = prime * result + ((select == null) ? 0 : select.hashCode());
        result = prime * result + ((owner == null) ? 0 : owner.hashCode());
        result = prime * result + ((comment == null) ? 0 : comment.hashCode());
        result = prime * result + ((columnComments == null) ? 0 : columnComments.hashCode());
        return result;
    }
    
    @Override
    public PgView shallowCopy() {
        PgView viewDst = new PgView(getName(), getRawStatement());
        viewDst.setQuery(getQuery());
        viewDst.setSelect(select.shallowCopy());
        viewDst.setComment(getComment());
        viewDst.setColumnNames(new ArrayList<>(columnNames));
        for(DefaultValue defval : defaultValues) {
            viewDst.addColumnDefaultValue(defval.getColumnName(), defval.getDefaultValue());
        }
        for(ColumnComment colcomment : columnComments) {
            viewDst.addColumnComment(colcomment.getColumnName(), colcomment.getComment());
        }
        for (PgPrivilege priv : revokes) {
            viewDst.addPrivilege(priv.shallowCopy());
        }
        for (PgPrivilege priv : grants) {
            viewDst.addPrivilege(priv.shallowCopy());
        }
        viewDst.setOwner(getOwner());
        return viewDst;
    }
    
    @Override
    public PgView deepCopy() {
        return shallowCopy();
    }

    /**
     * Contains information about default value of column.
     */
    public static class DefaultValue {

        private final String columnName;
        private final String defaultValue;

        DefaultValue(final String columnName, final String defaultValue) {
            this.columnName = columnName;
            this.defaultValue = defaultValue;
        }

        public String getColumnName() {
            return columnName;
        }

        public String getDefaultValue() {
            return defaultValue;
        }

        @Override
        public boolean equals(Object obj) {
            boolean eq = false;
            
            if(this == obj) {
                eq = true;
            } else if(obj instanceof DefaultValue) {
                DefaultValue val = (DefaultValue) obj;
                eq = Objects.equals(columnName, val.getColumnName())
                        && Objects.equals(defaultValue, val.getDefaultValue());
            }
            
            return eq;
        }
        
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((columnName == null) ? 0 : columnName.hashCode());
            result = prime * result + ((defaultValue == null) ? 0 : defaultValue.hashCode());
            return result;
        }
    }

    /**
     * Contains information about column comment.
     */
    public static class ColumnComment {

        private final String columnName;
        private final String comment;

        ColumnComment(final String columnName, final String comment) {
            this.columnName = columnName;
            this.comment = comment;
        }

        public String getColumnName() {
            return columnName;
        }

        public String getComment() {
            return comment;
        }
        
        @Override
        public boolean equals(Object obj) {
            boolean eq = false;
            
            if (this == obj) {
                eq = true;
            } else if(obj instanceof ColumnComment) {
                ColumnComment val = (ColumnComment) obj;
                eq = Objects.equals(columnName, val.getColumnName())
                        && Objects.equals(comment, val.getComment());
            }
            
            return eq;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((columnName == null) ? 0 : columnName.hashCode());
            result = prime * result + ((comment == null) ? 0 : comment.hashCode());
            return result;
        }
    }
    
    @Override
    public PgSchema getContainingSchema() {
        return (PgSchema)this.getParent();
    }
}
