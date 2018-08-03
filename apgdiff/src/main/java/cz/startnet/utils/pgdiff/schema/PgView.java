/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff.schema;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import cz.startnet.utils.pgdiff.PgDiffUtils;

/**
 * Stores view information.
 *
 * @author fordfrog
 */
public class PgView extends AbstractView {

    public PgView(String name, String rawStatement) {
        super(name, rawStatement);
    }

    @Override
    public String getCreationSQL() {
        final StringBuilder sbSQL = new StringBuilder(getQuery().length() * 2);
        sbSQL.append("CREATE");
        if (isMatView()) {
            sbSQL.append(" MATERIALIZED");
        }
        sbSQL.append(" VIEW ");
        sbSQL.append(PgDiffUtils.getQuotedName(getContainingSchema().getName())).append('.');
        sbSQL.append(PgDiffUtils.getQuotedName(name));

        if (!columnNames.isEmpty()) {
            sbSQL.append(" (");

            for (int i = 0; i < columnNames.size(); i++) {
                if (i > 0) {
                    sbSQL.append(", ");
                }

                sbSQL.append(PgDiffUtils.getQuotedName(columnNames.get(i)));
            }
            sbSQL.append(')');
        }

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : options.entrySet()){
            if (!CHECK_OPTION.equals(entry.getKey())){
                sb.append(entry.getKey());
                if (!entry.getValue().isEmpty()){
                    sb.append("=").append(entry.getValue());
                }
                sb.append(", ");
            }
        }

        if (sb.length() > 0){
            sb.setLength(sb.length() - 2);
            sbSQL.append("\nWITH (").append(sb).append(")");
        }

        if (getTablespace() != null) {
            sbSQL.append("\nTABLESPACE ").append(getTablespace());
        }

        sbSQL.append(" AS\n\t");
        sbSQL.append(getQuery());
        if (isMatView()){
            sbSQL.append("\nWITH ");
            if (!isWithData()){
                sbSQL.append("NO ");
            }
            sbSQL.append("DATA");
        } else if (options.containsKey(CHECK_OPTION)){
            String chekOption = options.get(CHECK_OPTION);
            sbSQL.append("\nWITH ");
            if (chekOption != null){
                sbSQL.append(chekOption.toUpperCase());
            }
            sbSQL.append(" CHECK OPTION");
        }
        sbSQL.append(';');

        appendOwnerSQL(sbSQL);
        appendPrivileges(sbSQL);

        for (final DefaultValue defaultValue : getDefaultValues()) {
            sbSQL.append("\n\nALTER VIEW ");
            sbSQL.append(PgDiffUtils.getQuotedName(getContainingSchema().getName()));
            sbSQL.append('.');
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

        for (final ColumnComment columnComment : getColumnComments()) {
            if (columnComment.getComment() != null
                    && !columnComment.getComment().isEmpty()) {
                sbSQL.append("\n\nCOMMENT ON COLUMN ");
                sbSQL.append(PgDiffUtils.getQuotedName(getContainingSchema().getName()));
                sbSQL.append('.');
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
        String mat = isMatView() ? "MATERIALIZED " : "";
        return "DROP " + mat + "VIEW " + PgDiffUtils.getQuotedName(getContainingSchema().getName()) + '.'
                + PgDiffUtils.getQuotedName(getName()) + ';';
    }

    @Override
    protected StringBuilder appendOwnerSQL(StringBuilder sb) {
        return (!isMatView() || owner == null) ? super.appendOwnerSQL(sb)
                : sb.append("\n\nALTER MATERIALIZED VIEW ")
                .append(PgDiffUtils.getQuotedName(getContainingSchema().getName()))
                .append('.').append(PgDiffUtils.getQuotedName(getName()))
                .append(" OWNER TO ").append(PgDiffUtils.getQuotedName(owner)).append(';');
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

        // TODO add alter for materialized view
        // after merge view columns dependencies branch
        if (isViewModified(newView)
                || isWithData() != newView.isWithData()
                || getTablespace() != newView.getTablespace()) {
            isNeedDepcies.set(true);
            return true;
        }
        diffDefaultValues(sb, newView);

        if (!Objects.equals(getOwner(), newView.getOwner())) {
            sb.append(newView.getOwnerSQL());
        }

        alterPrivileges(newView, sb);

        if (!Objects.equals(getComment(), newView.getComment())) {
            sb.append("\n\n");
            newView.appendCommentSql(sb);
        }
        final List<String> columnNames = new ArrayList<>(newView
                .getColumnComments().size());

        for (final AbstractView.ColumnComment columnComment : newView
                .getColumnComments()) {
            columnNames.add(columnComment.getColumnName());
        }

        for (final AbstractView.ColumnComment columnComment : getColumnComments()) {
            if (!columnNames.contains(columnComment.getColumnName())) {
                columnNames.add(columnComment.getColumnName());
            }
        }

        for (final String columnName : columnNames) {
            AbstractView.ColumnComment oldColumnComment = null;
            AbstractView.ColumnComment newColumnComment = null;

            for (final AbstractView.ColumnComment columnComment : getColumnComments()) {
                if (columnName.equals(columnComment.getColumnName())) {
                    oldColumnComment = columnComment;
                    break;
                }
            }

            for (final AbstractView.ColumnComment columnComment : newView
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

                sb.append("\n\nCOMMENT ON COLUMN "
                        + PgDiffUtils.getQuotedName(PgDiffUtils.getQuotedName(getContainingSchema().getName())) + '.'
                        + PgDiffUtils.getQuotedName(newView.getName()) + '.'
                        + PgDiffUtils.getQuotedName(newColumnComment
                                .getColumnName()) + " IS "
                                + newColumnComment.getComment() + ';');
            } else if (oldColumnComment != null && newColumnComment == null) {
                sb.append("\n\nCOMMENT ON COLUMN "
                        + PgDiffUtils.getQuotedName(PgDiffUtils.getQuotedName(getContainingSchema().getName())) + '.'
                        + PgDiffUtils.getQuotedName(newView.getName()) + '.'
                        + PgDiffUtils.getQuotedName(oldColumnComment
                                .getColumnName()) + " IS NULL;");
            }
        }

        compareOptions(newView, sb);

        return sb.length() > startLength;
    }

    /**
     * Compares default values with values in new view.
     *
     * @param sb               writer
     * @param newView          new view
     */
    private void diffDefaultValues(final StringBuilder sb, final PgView newView) {
        final List<DefaultValue> oldValues = getDefaultValues();
        final List<DefaultValue> newValues =
                newView.getDefaultValues();

        // modify defaults that are in old view
        for (final DefaultValue oldValue : oldValues) {
            boolean found = false;

            for (final DefaultValue newValue : newValues) {
                if (oldValue.getColumnName().equals(newValue.getColumnName())) {
                    found = true;

                    if (!oldValue.getDefaultValue().equals(newValue.getDefaultValue())) {
                        sb.append("\n\nALTER TABLE "
                                + PgDiffUtils.getQuotedName(newView.getContainingSchema().getName()) + '.'
                                + PgDiffUtils.getQuotedName(newView.getName())
                                + " ALTER COLUMN "
                                + PgDiffUtils.getQuotedName(newValue.getColumnName())
                                + " SET DEFAULT "
                                + newValue.getDefaultValue()
                                + ';');
                    }

                    break;
                }
            }

            if (!found) {
                sb.append("\n\nALTER TABLE "
                        + PgDiffUtils.getQuotedName(newView.getContainingSchema().getName()) + '.'
                        + PgDiffUtils.getQuotedName(newView.getName())
                        + " ALTER COLUMN "
                        + PgDiffUtils.getQuotedName(oldValue.getColumnName())
                        + " DROP DEFAULT;");
            }
        }

        // add new defaults
        for (final DefaultValue newValue : newValues) {
            boolean found = false;

            for (final DefaultValue oldValue : oldValues) {
                if (newValue.getColumnName().equals(oldValue.getColumnName())) {
                    found = true;
                    break;
                }
            }

            if (found) {
                continue;
            }

            sb.append("\n\nALTER TABLE "
                    + PgDiffUtils.getQuotedName(newView.getContainingSchema().getName()) + '.'
                    + PgDiffUtils.getQuotedName(newView.getName())
                    + " ALTER COLUMN "
                    + PgDiffUtils.getQuotedName(newValue.getColumnName())
                    + " SET DEFAULT "
                    + newValue.getDefaultValue()
                    + ';');
        }
    }

    @Override
    protected AbstractView getViewCopy() {
        return new PgView(getName(), getRawStatement());
    }
}
