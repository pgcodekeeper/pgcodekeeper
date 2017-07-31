package cz.startnet.utils.pgdiff.schema;

import java.util.Map;

public interface PgOptionContainer extends IStatement {
    void addOption(String key, String value);
    Map<String, String> getOptions();
}
