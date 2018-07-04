package cz.startnet.utils.pgdiff.schema;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import cz.startnet.utils.pgdiff.MsDiffUtils;

public class MsView extends PgView {

    public MsView(String name, String rawStatement) {
        super(name, rawStatement);
    }

    @Override
    public String getCreationSQL() {
        final StringBuilder sbSQL = new StringBuilder(getQuery().length() * 2);
        sbSQL.append("CREATE OR ALTER VIEW ");
        sbSQL.append(getQualifiedName());

        List<String> columnNames = getColumnNames();
        if (!columnNames.isEmpty()) {
            sbSQL.append(" (");

            for (int i = 0; i < columnNames.size(); i++) {
                if (i > 0) {
                    sbSQL.append(", ");
                }

                sbSQL.append(MsDiffUtils.quoteName(columnNames.get(i)));
            }
            sbSQL.append(')');
        }

        Map<String, String> options = getOptions();
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : options.entrySet()) {
            if (!CHECK_OPTION.equals(entry.getKey())){
                sb.append(entry.getKey());
                sb.append(", ");
            }
        }

        if (sb.length() > 0) {
            sb.setLength(sb.length() - 2);
            sbSQL.append("\nWITH ").append(sb);
        }

        sbSQL.append(" AS\n\t");
        sbSQL.append(getQuery());
        if (options.containsKey(CHECK_OPTION)) {
            sbSQL.append("\nWITH CHECK OPTION");
        }
        sbSQL.append(GO);

        appendOwnerSQL(sbSQL);
        appendPrivileges(sbSQL);

        return sbSQL.toString();
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        final int startLength = sb.length();
        MsView newView;
        if (newCondition instanceof MsView) {
            newView = (MsView) newCondition;
        } else {
            return false;
        }

        if (isViewModified(newView) || !Objects.equals(getOptions(), newView.getOptions())) {
            sb.append(newView.getCreationSQL());
            return true;
        }

        if (!Objects.equals(getOwner(), newView.getOwner())) {
            sb.append(newView.getOwnerSQL());
        }
        alterPrivileges(newView, sb);

        return sb.length() > startLength;
    }

    @Override
    public String getDropSQL() {
        return "DROP VIEW " + getQualifiedName() + GO;
    }

    @Override
    public boolean isPostgres() {
        return false;
    }
}
