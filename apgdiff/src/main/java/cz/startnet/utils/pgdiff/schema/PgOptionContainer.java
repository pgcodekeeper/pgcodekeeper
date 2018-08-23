package cz.startnet.utils.pgdiff.schema;

import java.util.Map;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public interface PgOptionContainer extends IStatement {

    void addOption(String key, String value);
    Map<String, String> getOptions();

    default void compareOptions(PgOptionContainer newContainer, StringBuilder sb) {
        Map <String, String> oldOptions = getOptions();
        Map <String, String> newOptions = newContainer.getOptions();

        StringBuilder setOptions = new StringBuilder();
        StringBuilder resetOptions = new StringBuilder();

        if (!oldOptions.isEmpty() || !newOptions.isEmpty()) {
            oldOptions.forEach((key, value) -> {
                String newValue = newOptions.get(key);
                if (newValue != null) {
                    if (!value.equals(newValue)) {
                        setOptions.append(key);
                        if (!newValue.isEmpty()) {
                            setOptions.append('=');
                            setOptions.append(newValue);
                        }
                        setOptions.append(", ");
                    }
                } else {
                    resetOptions.append(key)
                    .append(", ");
                }
            });

            newOptions.forEach((key, value) -> {
                if (!oldOptions.containsKey(key)) {
                    setOptions.append(key);
                    if (!value.isEmpty()) {
                        setOptions.append('=');
                        setOptions.append(value);
                    }
                    setOptions.append(", ");
                }
            });
        }

        if (setOptions.length() > 0 || resetOptions.length() > 0) {
            appendOptions(newContainer, setOptions, resetOptions, sb);
        }
    }

    default void appendOptions(PgOptionContainer newContainer, StringBuilder setOptions,
            StringBuilder resetOptions, StringBuilder sb) {
        DbObjType type = getStatementType();

        if (setOptions.length() > 0) {
            setOptions.setLength(setOptions.length() - 2);
            sb.append("\n\nALTER ");
            if (type == DbObjType.COLUMN) {
                sb.append("TABLE ONLY ")
                .append(PgDiffUtils.getQuotedName(getParent().getParent().getName()))
                .append('.').append(PgDiffUtils.getQuotedName(getParent().getName()))
                .append(" ALTER ");
            } else if (type == DbObjType.VIEW && ((AbstractView)newContainer).isMatView()) {
                sb.append("MATERIALIZED ");
            }
            sb.append(type)
            .append(' ');
            if (type != DbObjType.COLUMN) {
                IStatement parent = getParent();
                if (type == DbObjType.INDEX) {
                    parent = parent.getParent();
                }
                sb.append(PgDiffUtils.getQuotedName(parent.getName())).append('.');
            }
            sb.append(PgDiffUtils.getQuotedName(getName())).append(" SET (")
            .append(setOptions).append(");");
        }

        if (resetOptions.length() > 0) {
            resetOptions.setLength(resetOptions.length() - 2);
            sb.append("\n\nALTER ");
            if (type == DbObjType.COLUMN) {
                sb.append("TABLE ONLY ")
                .append(PgDiffUtils.getQuotedName(getParent().getParent().getName()))
                .append('.').append(PgDiffUtils.getQuotedName(getParent().getName()))
                .append(" ALTER ");
            } else if (type == DbObjType.VIEW && ((AbstractView)newContainer).isMatView()) {
                sb.append("MATERIALIZED ");
            }
            sb.append(type)
            .append(' ');
            if (type != DbObjType.COLUMN) {
                IStatement parent = getParent();
                if (type == DbObjType.INDEX) {
                    parent = parent.getParent();
                }
                sb.append(PgDiffUtils.getQuotedName(parent.getName())).append('.');
            }
            sb.append(PgDiffUtils.getQuotedName(getName()))
            .append(" RESET (").append(resetOptions).append(");");
        }
    }
}
