package cz.startnet.utils.pgdiff.schema;

import java.util.Map;
import java.util.Objects;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public interface PgOptionContainer extends IStatement {

    void addOption(String key, String value);
    Map<String, String> getOptions();

    default void compareOptions(PgOptionContainer oldContainer, PgOptionContainer newContainer, StringBuilder sb) {
        Map <String, String> oldOptions = oldContainer.getOptions();
        Map <String, String> newOptions = newContainer.getOptions();

        if (Objects.equals(oldOptions, newOptions)) {
            return;
        }

        StringBuilder setOptions = new StringBuilder();
        StringBuilder resetOptions = new StringBuilder();

        if (!oldOptions.isEmpty() || !newOptions.isEmpty()) {
            oldOptions.forEach((key, value) -> {
                if (newOptions.containsKey(key)) {
                    String newValue =  newOptions.get(key);
                    if (!Objects.equals(value, newValue)) {
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
            setOptions.setLength(setOptions.length()-2);
            sb.append("\n\nALTER ");
            if (oldContainer.getStatementType() == DbObjType.COLUMN) {
                sb.append("TABLE ")
                .append(PgDiffUtils.getQuotedName(oldContainer.getParent().getName()))
                .append(" ALTER ");
            }
            sb.append(oldContainer.getStatementType())
            .append(' ')
            .append(PgDiffUtils.getQuotedName(oldContainer.getName()))
            .append(" SET (").append(setOptions).append(");");
        }

        if (resetOptions.length() > 0) {
            resetOptions.setLength(resetOptions.length()-2);
            sb.append("\n\nALTER ");
            if (oldContainer.getStatementType() == DbObjType.COLUMN) {
                sb.append("TABLE ")
                .append(PgDiffUtils.getQuotedName(oldContainer.getParent().getName()))
                .append(" ALTER ");
            }
            sb.append(oldContainer.getStatementType())
            .append(' ')
            .append(PgDiffUtils.getQuotedName(oldContainer.getName()))
            .append(" RESET (").append(resetOptions).append(");");
        }
    }
}
