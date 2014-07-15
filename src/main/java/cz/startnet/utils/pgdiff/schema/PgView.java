/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff.schema;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

import cz.startnet.utils.pgdiff.PgDiffUtils;

/**
 * Stores view information.
 *
 * @author fordfrog
 */
public class PgView extends PgStatementWithSearchPath {

    private String query;
    private String normalizedQuery;
    private PgSelect select;
    private List<String> columnNames = new ArrayList<>(1);
    private final List<DefaultValue> defaultValues = new ArrayList<DefaultValue>(0);
    private final List<ColumnComment> columnComments = new ArrayList<ColumnComment>(0);
    private String comment;

    public PgView(String name, String rawStatement, String searchPath) {
        super(name, rawStatement, searchPath);
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

    public String getComment() {
        return comment;
    }

    public void setComment(final String comment) {
        this.comment = comment;
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
            sbSQL.append("\n\nCOMMENT ON VIEW ");
            sbSQL.append(PgDiffUtils.getQuotedName(name));
            sbSQL.append(" IS ");
            sbSQL.append(comment);
            sbSQL.append(';');
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
                    && privileges.equals(view.privileges)
                    && Objects.equals(owner, view.getOwner());
        }
        
        return eq;
    }

    @Override
    public int computeHash() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((privileges == null) ? 0 : privileges.hashCode());
        result = prime * result + ((columnNames == null) ? 0 : columnNames.hashCode());
        result = prime * result + new HashSet<>(defaultValues).hashCode();
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((normalizedQuery == null) ? 0 : normalizedQuery.hashCode());
        result = prime * result + ((select == null) ? 0 : select.hashCode());
        result = prime * result + ((owner == null) ? 0 : owner.hashCode());
        return result;
    }
    
    @Override
    public PgView shallowCopy() {
        PgView viewDst = new PgView(getName(), getRawStatement(), getSearchPath());
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
        for (PgPrivilege priv : privileges) {
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
    }
}
