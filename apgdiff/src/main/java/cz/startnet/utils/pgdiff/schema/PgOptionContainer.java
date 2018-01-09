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

        if (setOptions.length() > 0) {
            setOptions.setLength(setOptions.length() - 2);
            sb.append("\n\nALTER ");
            if (getStatementType() == DbObjType.COLUMN) {
                sb.append("TABLE ONLY ")
                .append(PgDiffUtils.getQuotedName(getParent().getName()))
                .append(" ALTER ");
            }
            sb.append(getStatementType())
            .append(' ')
            .append(PgDiffUtils.getQuotedName(getName()))
            .append(" SET (").append(setOptions).append(");");
        }

        if (resetOptions.length() > 0) {
            resetOptions.setLength(resetOptions.length() - 2);
            sb.append("\n\nALTER ");
            if (getStatementType() == DbObjType.COLUMN) {
                sb.append("TABLE ONLY ")
                .append(PgDiffUtils.getQuotedName(getParent().getName()))
                .append(" ALTER ");
            }
            sb.append(getStatementType())
            .append(' ')
            .append(PgDiffUtils.getQuotedName(getName()))
            .append(" RESET (").append(resetOptions).append(");");
        }
    }
}
