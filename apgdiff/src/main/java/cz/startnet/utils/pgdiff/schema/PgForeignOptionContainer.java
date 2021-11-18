package cz.startnet.utils.pgdiff.schema;

import java.text.MessageFormat;
import java.util.Map;

public interface PgForeignOptionContainer extends PgOptionContainer {

    static final String ALTER_FOREIGN_OPTION = "{0} OPTIONS ({1} {2} {3});";

    String getAlterHeader();

    @Override
    default void compareOptions(PgOptionContainer newContainer, StringBuilder sb) {
        Map <String, String> oldForeignOptions = getOptions();
        Map <String, String> newForeignOptions = newContainer.getOptions();
        if (!oldForeignOptions.isEmpty() || !newForeignOptions.isEmpty()) {
            oldForeignOptions.forEach((key, value) -> {
                String newValue = newForeignOptions.get(key);
                if (newValue != null) {
                    if (!value.equals(newValue)) {
                        sb.append(MessageFormat.format(ALTER_FOREIGN_OPTION,
                                getAlterHeader(), "SET", key, newValue));
                    }
                } else {
                    sb.append(MessageFormat.format(ALTER_FOREIGN_OPTION,
                            getAlterHeader(), "DROP", key, ""));
                }
            });

            newForeignOptions.forEach((key, value) -> {
                if (!oldForeignOptions.containsKey(key)) {
                    sb.append(MessageFormat.format(ALTER_FOREIGN_OPTION,
                            getAlterHeader(), "ADD", key, value));
                }
            });
        }
    }
}
